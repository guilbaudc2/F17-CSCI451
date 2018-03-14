package com.example.android.assignment10;

import java.sql.Blob;

/**
 * Created by Android on 11/12/2017.
 */

public class RecipeDBSchema
{
    public static final class RecipeTable
    {
        public static final String NAME = "recipes";

        public static final class Cols
        {
            public static final String UUID = "uuid";
            public static final String SMOOTHIE_NAME = "smoothie_name";
            public static final String DESCRIPTION = "description";
            public static final String INGREDIENTS = "ingredients";
//            public static final String SMOOTHIE_IMAGE = "smoothie_image";

        }
    }
}
