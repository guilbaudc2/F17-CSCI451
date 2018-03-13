package com.example.plantep.javashoppinglist;

import java.util.UUID;

/**
 * Created by plantep on 8/24/2017.
 */

public class Item {
    private int count;
    private String title;
    private String category;
    private boolean complete;
    private UUID id;

    public Item (int count, String title, String category, boolean complete) {
        this.count = count;
        this.title = title;
        this.category = category;
        this.complete = complete;
        this.id = UUID.randomUUID();
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public UUID getId() {
        return id;
    }
}