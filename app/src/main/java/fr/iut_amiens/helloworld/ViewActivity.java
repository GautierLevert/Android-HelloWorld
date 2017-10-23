package fr.iut_amiens.helloworld;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ViewActivity extends Activity {

    public static final String EXTRA_NAME = "name";

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        bindViews();

        // retrive the intent that started this activity.
        Intent intent = getIntent();

        // retrieve extra value from the intent.
        String name = intent.getStringExtra(EXTRA_NAME);

        // define the text content in the text with formatted string
        textView.setText(getString(R.string.view_greetings, name));
    }

    private void bindViews() {
        textView = findViewById(R.id.textView);
    }
}
