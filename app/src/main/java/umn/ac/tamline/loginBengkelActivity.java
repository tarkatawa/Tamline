package umn.ac.tamline;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class loginBengkelActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_bengkel);

        final TextView lupaPassword = (TextView) findViewById(R.id.lupaPasswordBengkel);
        lupaPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(loginBengkelActivity.this, lupaPasswordActivity.class);
                startActivity(myIntent);
                return;
            }
        });

        final TextView daftarBengkel = (TextView) findViewById(R.id.daftarBengkel);
        daftarBengkel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(loginBengkelActivity.this, signupBengkelActivity.class);
                startActivity(myIntent);
                return;
            }
        });
    }
}