package com.example.android.assignment11;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;

/**
 * Created by Android on 12/3/2017.
 */

public class PictureUtils {

    public static Bitmap
    getScaledBitmap(String path, int destWidth, int destHeight) {

        //read in dimensions
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(path, options);

        float srcWidth = options.outWidth;
        float srcHeight = options.outHeight;

        int sampleSize = 1;  //original resolution

        if(srcHeight > destHeight || srcWidth > destWidth) {
            float heightScale = srcHeight / destHeight;
            float widthScale = srcWidth / destWidth;

//            if(heightScale > widthScale) {
//                sampleSize = Math.round(heightScale);
//            } else {
//                sampleSize = Math.round(widthScale);
//            }
            sampleSize = Math.round(heightScale > widthScale ? heightScale :
                    widthScale);
        }

        options = new BitmapFactory.Options();
        options.inSampleSize = sampleSize;

        //create final bitmap
        return BitmapFactory.decodeFile(path, options);
    }

    public static Bitmap getScaledBitmap(String path, Activity activity) {
        Point size = new Point();
        activity.getWindowManager().getDefaultDisplay().getSize(size);

        return getScaledBitmap(path, size.x, size.y);
    }
}
