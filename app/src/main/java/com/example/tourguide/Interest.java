package com.example.tourguide;

/**
 * Created by Mayank on 12/5/18 at 8:23 PM
 **/
public class Interest {

    private String mTitle;
    private String mDescription;
    private int mImageResId;

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    int getImageResId() {
        return mImageResId;
    }

    void setImageResId(int mImageResId) {
        this.mImageResId = mImageResId;
    }
}
