package fr.iut_amiens.helloworld;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener {

    private Button button;

    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);
        editText = (EditText) findViewById(R.id.editText);

        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String name = editText.getText().toString();
        Intent intent = new Intent(this, ViewActivity.class);
        intent.putExtra(ViewActivity.EXTRA_NAME, name);
        startActivity(intent);
    }
}
