package com.example.android.landlayapplication;

/**
 * Created by Android on 9/26/2017.
 */

public class Book {
    public String title;
    public String description;
    public int pictureID;
    public String spoiler;

    public Book(String title, String description, int pictureID, String spoiler) {
        this.title = title;
        this.description = description;
        this.pictureID = pictureID;
        this.spoiler = spoiler;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPictureID() {
        return pictureID;
    }

    public void setPictureID(int pictureID) {
        this.pictureID = pictureID;
    }

    public String getSpoiler() {
        return spoiler;
    }

    public void setSpoiler(String spoiler) {
        this.spoiler = spoiler;
    }
}
