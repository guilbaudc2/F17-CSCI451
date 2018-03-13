package com.example.android.landlayapplication;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class BookDetailFragment extends Fragment {
    View view;
    int bookNum = 0;
    BookSet bookSet = BookSet.getBookSet();

    ArrayList<Book> bookList = bookSet.getItems();

    public static final String KEY_BOOK_NUM = "Book Number";
    public static final int DETAIL_SPOILED = 1;
    public static final String SPOILER = "Book Spoiler";
    public static final String TITLE = "Book Title";

    public BookDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putInt(KEY_BOOK_NUM, bookNum);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            bookNum = savedInstanceState.getInt(KEY_BOOK_NUM, bookNum);
        }
        setRetainInstance(true);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if (savedInstanceState != null) {
            bookNum = savedInstanceState.getInt(KEY_BOOK_NUM, bookNum);
        }
        view = inflater.inflate(R.layout.fragment_book_detail, container, false);
        initBookDetail(bookNum);
        initButtonNext();
        return view;

    }

    public void initBookDetail(int bookNum){
        TextView bookTitle = (TextView)view.findViewById(R.id.book_title);
        ImageView bookImage = (ImageView)view.findViewById(R.id.book_image);
        TextView bookDescription =  (TextView)view.findViewById(R.id.book_desc_short);
        TextView youSpoiled = (TextView)view.findViewById(R.id.spoiled);
        youSpoiled.setText("");

        bookTitle.setText(bookList.get(bookNum).getTitle());
        bookImage.setImageResource(bookList.get(bookNum).getPictureID());
        bookDescription.setText(bookList.get(bookNum).getDescription().substring(0, 200) + "...");
        initButtonSpoiler();
        initButtonDetailsMore();

    }

    public void initButtonDetailsMore(){
        final TextView moreBtn = (TextView)view.findViewById(R.id.button_more);
        moreBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View localView) {
                TextView bookDescrip = (TextView)view.findViewById(R.id.book_desc_short);

                if (bookDescrip.getText().equals((bookList.get(bookNum).getDescription().substring(0, 200) + "..."))) {
                    bookDescrip.setText(bookList.get(bookNum).getDescription());
                    moreBtn.setText("See Less...");
                } else {
                    bookDescrip.setText(bookList.get(bookNum).getDescription().substring(0, 200) + "...");
                    moreBtn.setText("See More...");
                }
            }
        });
    }

    public void initButtonSpoiler(){
        Button spoilerBtn = (Button)view.findViewById(R.id.button_spoiler);
        spoilerBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View localView) {
                Intent intent = new Intent(getActivity(), BookSpoilerActivity.class);
                String bookTitle = bookList.get(bookNum).getTitle();
                String spoiler = bookList.get(bookNum).getSpoiler();
                intent.putExtra(TITLE, bookTitle);
                intent.putExtra(SPOILER, spoiler);
                startActivityForResult(intent,DETAIL_SPOILED);
            }
        });

    }

    public void initButtonNext(){
        Button nextBtn = (Button)view.findViewById(R.id.button_next);
        nextBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {


                if (bookNum < 5) {
                    bookNum++;
                    initBookDetail(bookNum);
                }
                else {
                    Intent intent = new Intent(getActivity(), EndActivity.class);
                    startActivity(intent);

                }
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(data == null){
            return;
        }

        if(resultCode == DETAIL_SPOILED){
            TextView spoiledIt = (TextView)view.findViewById(R.id.spoiled);

            spoiledIt.setText("You spoiled it, silly!");
        }
    }
}
