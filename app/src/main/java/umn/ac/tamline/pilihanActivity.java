package umn.ac.tamline;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class pilihanActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pilihan);

        Button pengguna = findViewById(R.id.buttonPengguna);
        pengguna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(pilihanActivity.this, CustomerLoginActivity.class));
            }
        });

        Button bengkel = findViewById(R.id.buttonBengkel);
        bengkel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(pilihanActivity.this, loginBengkelActivity.class));
            }
        });

    }
}