package com.example.android.assignment11;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.content.FileProvider;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import static android.app.Activity.RESULT_OK;
import static com.example.android.assignment11.RecipeListFragment.RECIPE_ID;


/**
 * A placeholder fragment containing a simple view.
 */
public class RecipeDetailFragment extends Fragment {
    View view;
    private Recipe recipe;
    private Callbacks callbacks;
    private File photoFile;
    private ImageView photoView;

    private static final String ARGS_RECIPE_ID = "recipe_id";
    private static final int REQUEST_PHOTO = 0;


    public interface Callbacks {
        void onRecipeUpdated(int recipeID);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        callbacks = (Callbacks)context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        callbacks = null;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);

        UUID recipeId = (UUID)getArguments().getSerializable(ARGS_RECIPE_ID);
        recipe = (RecipeSet.getList(getActivity())).getRecipe(recipeId);
        photoFile = getPhotoFile(recipe);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent,
                             Bundle savedInstanceState)
    {
        view =  inflater.inflate(R.layout.fragment_recipe_detail, parent, false);
        initSmoothieNameET(view);
        initDescriptionET(view);
        initIngredientsET(view);
        initStepsET(view);
        initSubmitBtn();
        initDiscardBtn();
        initCameraButton(view);
        initFavorited(view);
        photoView = (ImageView)view.findViewById(R.id.iv_thumbnail);
        updatePhotoView();
        initCancelBtn();
        return view;
    }

    public void initSmoothieNameET(View view)
    {
        EditText smoothieNameET = (EditText) view.findViewById(R.id.et_recipe_smoothieName);
        smoothieNameET.setText(recipe.getSmoothieName());
        smoothieNameET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(
                    CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(
                    CharSequence text, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                recipe.setSmoothieName(editable.toString());
            }
        });
    }

    public void initDescriptionET(View view)
    {
        EditText descriptionET = (EditText) view.findViewById(R.id.et_recipe_description);
        descriptionET.setText(recipe.getDescription());
        descriptionET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(
                    CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(
                    CharSequence text, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                recipe.setDescription(editable.toString());
            }
        });
    }

    public void initIngredientsET(View view)
    {
        EditText ingredientsET = (EditText) view.findViewById(R.id.et_recipe_ingredients);
        ingredientsET.setText(recipe.getIngredients());
        ingredientsET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(
                    CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(
                    CharSequence text, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                recipe.setIngredients(editable.toString());
            }
        });
    }

    public void initStepsET(View view)
    {
        EditText stepsET = (EditText) view.findViewById(R.id.et_recipe_steps);
        stepsET.setText(recipe.getRecipeSteps());
        stepsET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(
                    CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(
                    CharSequence text, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                recipe.setRecipeSteps(editable.toString());
            }
        });
    }

//    public void initNewIngredientsET(View view)
//    {
//        EditText ingredientET = (EditText) view.findViewById(R.id.et_single_ingredient);
//        ingredientET.setText(recipe.getSmoothieName());
//        ingredientET.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(
//                    CharSequence charSequence, int i, int i1, int i2) {
//
//            }
//
//            @Override
//            public void onTextChanged(
//                    CharSequence text, int i, int i1, int i2) {
//
//            }
//
//            @Override
//            public void afterTextChanged(Editable editable) {
//                recipe.setIngredients(editable.toString());
//            }
//        });
//    }

    public void initSubmitBtn(){
        Button submitBtn = (Button)view.findViewById(R.id.button_submit);
        submitBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), RecipeListActivity.class);
                startActivity(intent);
            }
        });
    }

    public void initCancelBtn(){
        Button cancelBtn = (Button)view.findViewById(R.id.button_cancel);
        cancelBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), RecipeListActivity.class);
                startActivity(intent);
            }
        });
    }

    public void initDiscardBtn(){
        Button discardBtn = (Button)view.findViewById(R.id.button_discard);
        discardBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                RecipeSet.getList(getActivity()).deleteRecipe(recipe);
                Intent intent = new Intent(getActivity(), RecipeListActivity.class);
                startActivity(intent);
            }
        });
    }

    public void initFavorited(View view) {
        final FloatingActionButton favoritedFAB = (FloatingActionButton) view.findViewById(R.id.fab_item_fave);
        if(recipe.isFavorite()){
            favoritedFAB.setImageResource(R.drawable.heart);
        }
        favoritedFAB.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                if (recipe.isFavorite()) {
                    recipe.setFavorite(false);
                    favoritedFAB.setImageResource(R.drawable.heart_outline);
                } else {
                    recipe.setFavorite(true);
                    favoritedFAB.setImageResource(R.drawable.heart);
                }
            }
        });
    }

    public static RecipeDetailFragment newInstance(UUID recipeId)
    {
        Bundle args = new Bundle();
        args.putSerializable(ARGS_RECIPE_ID, recipeId);
        RecipeDetailFragment recipeDetailFragment = new RecipeDetailFragment();
        recipeDetailFragment.setArguments(args);
        return recipeDetailFragment;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_recipe_list, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch(item.getItemId())
        {
            case R.id.menu_fave:
//                Recipe recipe = new Recipe();
//                RecipeSet.getList(getActivity()).addFavorite(recipe);
//                Intent intent = new Intent(getActivity(), FavoritesActivity.class);
//                intent.putExtra(RECIPE_ID, recipe.getId());
//                startActivity(intent);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }


    @Override
    public void onPause() {
        super.onPause();

        RecipeSet.getList(getActivity()).updateRecipe(recipe);
    }

    private void initCameraButton(View view) {

        //access the button
        ImageButton cameraButton = (ImageButton)view.findViewById(R.id.ib_thumbnail_button);

        //create intent to launch camera/capture image
        final Intent captureImage = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        //check if you can take a picture, and photo file exists
        //also make sure the package manager syas we have camera capabilities
        PackageManager packageManager = getActivity().getPackageManager();
        boolean canTakePhoto = photoFile != null &&
                captureImage.resolveActivity(packageManager) != null;

        //if we can take a picture then enable the camera button
        cameraButton.setEnabled(canTakePhoto);

        //When the image button is clicked
        cameraButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = FileProvider.getUriForFile(getActivity(),
                        "com.example.android.assignment11.fileprovider", photoFile);
                captureImage.putExtra(MediaStore.EXTRA_OUTPUT, uri);

                List<ResolveInfo> cameraActivities = getActivity()
                        .getPackageManager().queryIntentActivities(captureImage,
                                PackageManager.MATCH_DEFAULT_ONLY);

        for (ResolveInfo activity : cameraActivities) {
            getActivity().grantUriPermission(activity.activityInfo.packageName,
                    uri, Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
        }
                startActivityForResult(captureImage, REQUEST_PHOTO);
            }
        });
    }

    private File getPhotoFile(Recipe recipe) {
        File fileDir = getActivity().getFilesDir();
        return new File(fileDir,recipe.getPhotoFilename());
    }

    private void updatePhotoView() {
        if(photoFile == null || !photoFile.exists()) {
            photoView.setImageDrawable(null);
        }
        else {
            Bitmap bitmap =
                    PictureUtils.getScaledBitmap(photoFile.getPath(), getActivity());
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, bos);
            byte[] bArray = bos.toByteArray();
            recipe.setSmoothieImage(bArray);
//                ByteArrayInputStream imageStream = new ByteArrayInputStream(bArray);
//                Bitmap bmp = BitmapFactory.decodeStream(imageStream);
            photoView.setImageBitmap(bitmap);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode != Activity.RESULT_OK) return;

        if(requestCode == REQUEST_PHOTO) {
            Uri uri = FileProvider.getUriForFile(getActivity(),
                    "com.example.android.assignment11.fileprovider", photoFile);
            getActivity().revokeUriPermission(uri, Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
            updatePhotoView();
        }
    }
}
