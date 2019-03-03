package com.example.schaapkabap.biercollection.activitys;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.schaapkabap.biercollection.Models.ApiBier;
import com.example.schaapkabap.biercollection.R;

import com.example.schaapkabap.biercollection.activitys.brouwerijen.BrouwerijDetail;
import com.example.schaapkabap.biercollection.helpers.Api.ApiHandler;
import com.example.schaapkabap.biercollection.helpers.SharePref;

import org.json.JSONException;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

/**
 * An activity representing a list of Items. This activity
 * has different presentations for handset and tablet-size devices. On
 * handsets, the activity presents a list of items, which when touched,
 * lead to a {@link ItemDetailActivity} representing
 * item details. On tablets, the activity presents the list of items and
 * item details side-by-side using two vertical panes.
 */
public class ItemListActivity extends AppCompatActivity {

    /**
     * Whether or not the activity is in two-pane mode, i.e. running on a tablet
     * device.
     */
    private boolean mTwoPane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list);
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(getTitle());

        if (findViewById(R.id.item_detail_container) != null) {
            // The detail container view will be present only in the
            // large-screen layouts (res/values-w900dp).
            // If this view is present, then the
            // activity should be in two-pane mode.
            mTwoPane = true;
        }

        View recyclerView = findViewById(R.id.item_list);
        assert recyclerView != null;
        try {
            setupRecyclerView((RecyclerView) recyclerView);
        } catch (IOException e) {
            e.printStackTrace();
            apiKeyFailed();
        } catch (JSONException e) {
            e.printStackTrace();
            apiKeyFailed();
        }
    }

    private void setupRecyclerView(@NonNull RecyclerView recyclerView) throws IOException, JSONException {
        String key = SharePref.getInstance(getApplicationContext()).getPlaceObj();
        recyclerView.setAdapter(new SimpleItemRecyclerViewAdapter(this, ApiHandler.getInstance(key).getAll(), mTwoPane));
    }

    public static class SimpleItemRecyclerViewAdapter
            extends RecyclerView.Adapter<SimpleItemRecyclerViewAdapter.ViewHolder> {

        private final ItemListActivity mParentActivity;
        private final List<ApiBier> mValues;
        private final boolean mTwoPane;

        SimpleItemRecyclerViewAdapter(ItemListActivity parent,
                                      List<ApiBier> items,
                                      boolean twoPane) {

            mValues = items;
            mParentActivity = parent;
            mTwoPane = twoPane;
        }
        private final View.OnClickListener mOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ApiBier item = (ApiBier) view.getTag();
                if (mTwoPane) {
                    Bundle arguments = new Bundle();
                    ItemDetailFragment fragment = new ItemDetailFragment();
                    fragment.setArguments(arguments);
                    fragment.setmItem(item);
                    mParentActivity.getSupportFragmentManager().beginTransaction()
                            .replace(R.id.item_detail_container, fragment)
                            .commit();
                } else {
                    Context context = view.getContext();
                    Intent intent = new Intent(context, ItemDetailActivity.class);
                    intent.putExtra("ApiBier",  item);


                    context.startActivity(intent);
                }
            }
        };



        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_list_content, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, int position) {
            holder.mIdView.setText(mValues.get(position).getId());
            holder.mContentView.setText(mValues.get(position).getName());

            holder.itemView.setTag(mValues.get(position));
            holder.itemView.setOnClickListener(mOnClickListener);
        }

        @Override
        public int getItemCount() {
            return mValues.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            final TextView mIdView;
            final TextView mContentView;

            ViewHolder(View view) {
                super(view);
                mIdView = (TextView) view.findViewById(R.id.id_text);
                mContentView = (TextView) view.findViewById(R.id.content);
            }
        }
    }
    private void apiKeyFailed(){
        Toast.makeText(this,"U hebt geen internet of de key functioneert niet",Toast.LENGTH_LONG).show();
        finish();

    }
}
