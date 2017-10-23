package fr.iut_amiens.helloworld;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity implements View.OnClickListener {

    private Button button;

    private EditText editText;

    /**
     * Called when
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // never forget to call super method
        super.onCreate(savedInstanceState);

        // bind the Activity and the layout
        setContentView(R.layout.activity_main);

        // don't forget to call this AFTER setContentView()
        bindViews();

        button.setOnClickListener(this);
    }

    /**
     * Bind view as attributes with view from layout
     */
    private void bindViews() {
        button = findViewById(R.id.button);
        editText = findViewById(R.id.editText);
    }

    @Override
    public void onClick(View v) {
        // get entered name
        String name = editText.getText().toString();

        // create Intent for the second Activity
        Intent intent = new Intent(this, ViewActivity.class);

        // add the name as Extra
        intent.putExtra(ViewActivity.EXTRA_NAME, name);

        // ask system to launch second Activity
        startActivity(intent);
    }
}
