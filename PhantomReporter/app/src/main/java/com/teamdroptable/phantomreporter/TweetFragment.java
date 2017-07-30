package com.teamdroptable.phantomreporter;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link TweetFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link TweetFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TweetFragment extends Fragment {

    View tweetView;


    public TweetFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        tweetView = inflater.inflate(R.layout.trending_tweets,container,false);
        return tweetView;
    }




}
