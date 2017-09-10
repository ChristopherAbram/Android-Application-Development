package fi.jamk.aad.l3334.basicuicontrols;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.widget.RadioGroup;
import android.widget.RadioButton;
import android.view.View;
import android.R.*;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selectButtonClicked(View view) {
        // find radiogroup
        RadioGroup rg = (RadioGroup) findViewById(R.id.myGroup);
        int id = rg.getCheckedRadioButtonId();
        // find button
        RadioButton rb = (RadioButton) findViewById(id);
        // get radiobutton text
        String text = (String) rb.getText();
        // toast message to screen
        Toast.makeText(getApplicationContext(), text,
                Toast.LENGTH_SHORT).show();
    }
}
