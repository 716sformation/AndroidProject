package mou3adh.firstproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    EditText etPassword;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = (EditText) findViewById(R.id.etName);
        etPassword = (EditText) findViewById(R.id.etPass);
        btn = (Button) findViewById(R.id.sayhi);


    }

    public void ok(View view) {
        String name = etName.getText().toString();
        String pass = etPassword.getText().toString();

        if (name.equals("") && name.equals("")) {
            Toast.makeText(getApplicationContext(),

                    "Remplir les champs svp"
                    , Toast.LENGTH_LONG).show();
        } else {


            Intent i = new Intent(getApplicationContext(),SecondActivity.class);
            i.putExtra("key",name);
            startActivity(i);

            Toast.makeText(getApplicationContext(),

                    "My name is :" + name + " My pass is" + pass
                    , Toast.LENGTH_SHORT).show();
        }
    }

}
