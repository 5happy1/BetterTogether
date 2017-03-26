package com.cybereyestudios.bettertogether;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment {
    TagsAdapter tagsAdapter;
    RecyclerView.LayoutManager deedsViewLayoutManager;

    public ProfileFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment FeedFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProfileFragment newInstance() {
        ProfileFragment fragment = new ProfileFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootView = inflater.inflate(R.layout.fragment_profile, container, false);

        // Populate text views
        TextView textViewProfileUsername = (TextView) rootView.findViewById(R.id.textViewProfileUsername);
        textViewProfileUsername.setText("johnsmith12");

        TextView textViewProfileBio = (TextView) rootView.findViewById(R.id.textViewProfileBio);
        textViewProfileBio.setText("this is a bio");

        RecyclerView userTagsView = (RecyclerView) rootView.findViewById(R.id.recyclerViewProfileTags);
        deedsViewLayoutManager = new LinearLayoutManager(getActivity());
        userTagsView.setLayoutManager(deedsViewLayoutManager);

        ArrayList<String> userTags = new ArrayList<String>();

        tagsAdapter = new TagsAdapter(userTags, getContext());
        userTagsView.setAdapter(tagsAdapter);

        Button editTags = (Button) rootView.findViewById(R.id.buttonEditTags);
        editTags.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayout linearLayoutAddTags = (LinearLayout) rootView.findViewById(R.id.linearLayoutAddTags);
                linearLayoutAddTags.removeAllViews();

                //add textView
                final TextView textViewAddTag = new TextView(getContext());
                textViewAddTag.setHint(getString(R.string.tag));

                // added Button
                Button buttonAddTag = new Button(getContext());
                buttonAddTag.setText(getString(R.string.add));
                buttonAddTag.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        tagsAdapter.addTag(textViewAddTag.getText().toString());
                        tagsAdapter.notifyDataSetChanged();
                    }
                });

                //added the textView and the Button to LinearLayout
                linearLayoutAddTags.addView(textViewAddTag);
                linearLayoutAddTags.addView(buttonAddTag);

            }
        });

        return rootView;
    }
}
