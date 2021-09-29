package umn.ac.tamline;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Chattingan extends AppCompatActivity {
    Button mKeOtw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chattingan);

        mKeOtw = (Button) findViewById(R.id.keOtw);
        mKeOtw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Chattingan.this, OnTheWay.class);
                startActivity(intent);
            }
        });

    }
}