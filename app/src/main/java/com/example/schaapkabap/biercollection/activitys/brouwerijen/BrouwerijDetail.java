package com.example.schaapkabap.biercollection.activitys.brouwerijen;

import com.example.schaapkabap.biercollection.helpers.Api.ApiHandler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class BrouwerijDetail {



    /**
     * An array of sample (dummy) items.
     */
    public static final List<Bier> ITEMS = new ArrayList<Bier>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, Bier> ITEM_MAP = new HashMap<String, Bier>();

    private static final int COUNT = 25;

    static {

        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            try {
                addItem(createBierItem(i));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void addItem(Bier item) throws IOException {
//        ApiHandler.getInstance("37f34d7d9ce37224e5cf94b33db59ab3").getAll();
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    private static Bier createBierItem(int position) {
        return new Bier(String.valueOf(position), "Item " + position, makeDetails(position));
    }

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore details information here.");
        }
        return builder.toString();
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class Bier {
        public final String id;
        public final String content;
        public final String details;

        public Bier(String id, String content, String details) {
            this.id = id;
            this.content = content;
            this.details = details;
        }

        @Override
        public String toString() {
            return content;
        }
    }
}
