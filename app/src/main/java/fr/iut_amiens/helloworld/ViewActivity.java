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

        textView = (TextView) findViewById(R.id.textView);

        Intent intent = getIntent();
        String name = intent.getStringExtra(EXTRA_NAME);
        textView.setText("Hello " + name);
    }
}
