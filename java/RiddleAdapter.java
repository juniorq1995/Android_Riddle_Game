package com.example.jquintero.riddle;

import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.app.Activity;
import java.util.ArrayList;
import android.view.LayoutInflater;
import android.widget.TextView;
import android.widget.ImageView;
import android.content.Context;

import java.util.ArrayList;

/**
 * Created by jquintero on 8/17/16.
 */

public class RiddleAdapter extends ArrayAdapter<Riddle> {
    /**
     * Create a new {@link RiddleAdapter} object.
     *
     * @param context is the current context (i.e. Activity) that the adapter is being created in.
     * @param riddles is the list to be displayed.
     */
    public RiddleAdapter(Context context, ArrayList<Riddle> riddles) {
        super(context, 0, riddles);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        // Get the {@link Riddle} object located at this position in the list
        Riddle currentWord = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID miwok_text_view.
        TextView riddleTextView = (TextView) listItemView.findViewById(R.id.riddleItem);
        // Get the Miwok translation from the currentWord object and set this text on
        // the Miwok TextView.
        riddleTextView.setText(currentWord.getRiddle());

        // Find the TextView in the list_item.xml layout with the ID miwok_text_view.
        TextView answerTextView = (TextView) listItemView.findViewById(R.id.answerItem);
        // Get the Miwok translation from the currentWord object and set this text on
        // the Miwok TextView.
        answerTextView.setText(currentWord.getAnswer());

        answerTextView.setVisibility(View.INVISIBLE);

        // Return the whole list item layout (containing 2 TextViews) so that it can be shown in
        // the ListView.
        return listItemView;
    }
}
