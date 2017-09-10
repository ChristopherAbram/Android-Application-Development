package fi.jamk.aad.l3334.basicuicontrols2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AutoCompleteTextView login = (AutoCompleteTextView)findViewById(R.id.autoCompleteTextView);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line,
                new String[]{"Ari", "Roosa", "Jasmin", "Sofia", "Robert", "Lucas"});

        login.setAdapter(adapter);

        return;
    }

    public void signIn(View view){
        try {
            Button signin = (Button) findViewById(R.id.sign_in);

            AutoCompleteTextView login = (AutoCompleteTextView)findViewById(R.id.autoCompleteTextView);
            EditText password = (EditText)findViewById(R.id.editText);

            String log = login.getText().toString();
            String pass = password.getText().toString();

            if(!log.isEmpty() || !pass.isEmpty())
                Toast.makeText(getApplicationContext(), log + " " + pass, Toast.LENGTH_SHORT).show();

        } catch(NullPointerException npe){}
    }
}
