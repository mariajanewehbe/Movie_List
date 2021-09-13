package org.mariajane.final_csc498;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MovieFragment extends Fragment {

    public MovieFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RecyclerView movieRecycler = (RecyclerView) inflater. inflate(R.layout.fragment_movie, container, false);

        String[] movieTitles = new String[Movie.movies.length];
        for(int i = 0; i< movieTitles.length; i++)
            movieTitles[i] = Movie.movies[i].getTitle();

        int[] movieImages = new int[Movie.movies.length];
        for(int i = 0; i < movieImages.length; i++)
            movieImages[i] = Movie.movies[i].getImageId();

        CaptionedImagesAdapter captionedImagesAdapter = new CaptionedImagesAdapter(getContext(), movieTitles, movieImages);
        movieRecycler.setAdapter(captionedImagesAdapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        movieRecycler.setLayoutManager(layoutManager);

        return movieRecycler;
    }
}