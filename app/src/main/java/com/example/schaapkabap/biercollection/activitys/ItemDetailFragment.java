package com.example.schaapkabap.biercollection.activitys;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.design.widget.CollapsingToolbarLayout;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.schaapkabap.biercollection.Models.ApiBier;
import com.example.schaapkabap.biercollection.R;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * A fragment representing a single Item detail screen.
 * This fragment is either contained in a {@link ItemListActivity}
 * in two-pane mode (on tablets) or a {@link ItemDetailActivity}
 * on handsets.
 */
public class ItemDetailFragment extends Fragment {

    /**
     * The dummy content this fragment is presenting.
     */
    private ApiBier mItem;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ItemDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        Activity activity = this.getActivity();

        CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) activity.findViewById(R.id.toolbar_layout);
        if (appBarLayout != null) {
            appBarLayout.setTitle(mItem.getName());
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.item_detail, container, false);

        if (mItem != null) {
            ((TextView) rootView.findViewById(R.id.item_detail)).setText(mItem.getAbv()+"%");
            ImageView i = (ImageView) rootView.findViewById(R.id.logo);
            try {
                Bitmap bitmap = BitmapFactory.decodeStream((InputStream)new URL(mItem.getUrlImage()).getContent());
                i.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
        Button recensieButton = (Button) rootView.findViewById(R.id.recensiebutton);
        recensieButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(rootView.getContext(), RecensieActivity.class);
                intent.putExtra("ApiBier",  mItem);
                getContext().startActivity(intent);
            }
        });

        return rootView;
    }

    public ApiBier getmItem() {
        return mItem;
    }

    public void setmItem(ApiBier mItem) {
        this.mItem = mItem;
    }
}
