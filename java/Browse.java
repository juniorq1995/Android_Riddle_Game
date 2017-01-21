package com.example.jquintero.riddle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import android.view.View;

public class Browse extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.riddle_layout);

        // Create an {@link WordAdapter}, whose data source is a list of {@link Word}s. The
        // adapter knows how to create list items for each item in the list.
        RiddleAdapter adapter = new RiddleAdapter(this, new RiddleList().getList());

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_list.xml layout file.
        ListView listView = (ListView) findViewById(R.id.list);

        // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Word} in the list.
        listView.setAdapter(adapter);
    }
    public void toggleAnswer(View layout){
        TextView answer = (TextView) layout.findViewById(R.id.answerItem);
        TextView click = (TextView) layout.findViewById(R.id.clickItem);
        if(click.getText().equals("Click to see answer"))
            {
            click.setText("Click to hide answer");
            answer.setVisibility(View.VISIBLE);
            }
        else if(click.getText().equals("Click to hide answer"))
            {
            click.setText("Click to see answer");
            answer.setVisibility(View.INVISIBLE);
            }

    }
}
