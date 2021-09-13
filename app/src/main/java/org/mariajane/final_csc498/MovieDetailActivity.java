package org.mariajane.final_csc498;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MovieDetailActivity extends AppCompatActivity {

    public static final String ITEM_NUMBER = "item_number";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        Intent intent = getIntent();
        int itemNum = intent.getIntExtra(ITEM_NUMBER, 0);

        ImageView imageView = findViewById(R.id.moive_image_view);
        TextView textViewTitle = findViewById(R.id.movie_title_text_view);
        TextView textViewDesc = findViewById(R.id.movie_desc_text_view);

        imageView.setImageResource(Movie.movies[itemNum].getImageId());
        textViewTitle.setText(Movie.movies[itemNum].getTitle());
        textViewDesc.setText(Movie.movies[itemNum].getDesc());
    }
}