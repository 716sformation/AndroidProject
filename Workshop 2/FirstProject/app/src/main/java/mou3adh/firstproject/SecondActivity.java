package mou3adh.firstproject;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView txtname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        txtname = (TextView) findViewById(R.id.txtname);
        Button callme = (Button) findViewById(R.id.call);
        String name = getIntent().getStringExtra("key");
        txtname.setText(name);

        callme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int REQUEST_CODE_ASK_PERMISSIONS = 123;
                Intent i = new Intent(Intent.ACTION_CALL, Uri.parse("tel:55888777"));
                if (Build.VERSION.SDK_INT >= 23) {
                    if (ActivityCompat.checkSelfPermission(SecondActivity.this, Manifest.permission.CALL_PHONE) !=
                            PackageManager.PERMISSION_GRANTED) {
                        requestPermissions(new String[]{
                                        Manifest.permission.CALL_PHONE},
                                REQUEST_CODE_ASK_PERMISSIONS);
                        return;
                    }

                } else {
                    try {
                        startActivity(i);
                    } catch (Exception ex) {
                    }
                }
            }
        });





    }
}
