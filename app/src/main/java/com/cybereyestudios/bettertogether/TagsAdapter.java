package com.cybereyestudios.bettertogether;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Adapter for Feed RecyclerView.
 */
public class TagsAdapter extends RecyclerView.Adapter<TagsAdapter.TagHolder> {
    private ArrayList<String> tags;
    private Context context;

    public TagsAdapter(ArrayList<String> tags, Context context) {
        this.tags = tags;
        this.context = context;
    }

    @Override
    public TagHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        TagHolder tagHolder;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        View v = inflater.inflate(R.layout.card_tag, parent, false);
        tagHolder = new TagHolder(v);
        return tagHolder;
    }

    @Override
    public void onBindViewHolder(TagHolder holder, int position) {
        String tag = tags.get(position);
        holder.textViewTagName.setText(tag);
        ;
    }

    @Override
    public int getItemCount() {
        return tags.size();
    }

    public void addTag(String tag) {
        tags.add(tag);
    }

    public boolean removeTag(String tagToRemove) {
        for (String tag : tags) {
            if (tag.equals(tagToRemove)) {
                return tags.remove(tag);
            }
        }
        return false;
    }

    public class TagHolder extends RecyclerView.ViewHolder {
        public TextView textViewTagName;

        public TagHolder(View v) {
            super(v);
            textViewTagName = (TextView) v.findViewById(R.id.textViewTagName);
        }
    }
}

