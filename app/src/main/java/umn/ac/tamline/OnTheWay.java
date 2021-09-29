package umn.ac.tamline;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class OnTheWay extends AppCompatActivity {
    Button onTheWay, mKeHome, keCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_the_way);

//        onTheWay = (Button) findViewById(R.id.datangBtn);
//        onTheWay.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(OnTheWay.this, .class);
//                startActivity(intent);
//            }
//        });
        mKeHome = (Button) findViewById(R.id.logout);
        mKeHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OnTheWay.this, CustomerMapActivity.class);
                startActivity(intent);
            }
        });

        keCancel = (Button) findViewById(R.id.backCancel);
        keCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OnTheWay.this, CustomerMapActivity.class);
                startActivity(intent);
            }
        });
    }

}