package com.sptpc.app.androidnetjson.model;

import android.graphics.Bitmap;

/**
 * Created by wwb on 2018/4/9.
 */
public class News {
    private int imageID;
    private Bitmap imageBitmap;
    private String title;

    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Bitmap getImageBitmap() {
        return imageBitmap;
    }

    public void setImageBitmap(Bitmap imageBitmap) {
        this.imageBitmap = imageBitmap;
    }
}
