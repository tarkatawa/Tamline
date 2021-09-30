package umn.ac.tamline;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class signupPenggunaActivity extends AppCompatActivity {
    Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_pengguna);

        register = (Button) findViewById(R.id.buttonDaftar);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
            }
        });

        TextView textView = findViewById(R.id.checkSK);

        String text = "Dengan mendaftar, Anda menyetujui Persyaratan Layanan dan Kebijakan Privasi dari TAM-LINE";

        SpannableString ss = new SpannableString(text);
        SpannableStringBuilder ssb = new SpannableStringBuilder(text);

        ForegroundColorSpan pl = new ForegroundColorSpan(Color.BLACK);
        ForegroundColorSpan kp = new ForegroundColorSpan(Color.BLACK);

        ssb.setSpan(pl, 34, 53, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ssb.setSpan(kp, 58, 75, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textView.setText(ssb);
    }

    public void setText(View view) {
        final EditText editTextName = findViewById(R.id.inputName);
        final String textValueName = editTextName.getText().toString();

        final EditText editTextEmail = findViewById(R.id.inputEmail);
        final String textValueEmail = editTextEmail.getText().toString();

        final EditText editTextNumber = findViewById(R.id.inputNumber);
        final String textValueNumber = editTextNumber.getText().toString();

        final EditText editTextPassword = findViewById(R.id.inputPassword);
        final String textValuePassword = editTextPassword.getText().toString();

        final EditText editTextConfirmPassword = findViewById(R.id.inputConfirmPassword);
        final String textValueConfirmPassword = editTextConfirmPassword.getText().toString();

        if (TextUtils.isEmpty(textValueName)) {
            editTextName.setError("Silahkan Isi Nama");
            editTextName.requestFocus();
        } else if (TextUtils.isEmpty(textValueEmail)) {
            editTextEmail.setError("Silahkan Isi Email");
            editTextEmail.requestFocus();
        } else if (TextUtils.isEmpty(textValueNumber)) {
            editTextNumber.setError("Silahkan Isi Nomor Telepon");
            editTextNumber.requestFocus();
        } else if (TextUtils.isEmpty(textValuePassword)) {
            editTextPassword.setError("Silahkan Isi Kata Sandi");
            editTextPassword.requestFocus();
        } else if (TextUtils.isEmpty(textValueConfirmPassword)) {
            editTextConfirmPassword.setError("Silahkan Isi Konfirmasi Kata Sandi");
            editTextConfirmPassword.requestFocus();
        }
    }
}