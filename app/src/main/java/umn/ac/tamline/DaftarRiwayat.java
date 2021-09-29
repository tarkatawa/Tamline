package umn.ac.tamline;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DaftarRiwayat extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.Adapter programAdapter;
    RecyclerView.LayoutManager layoutmanager;
    String[] programNameList = {"Bengkel Tamvan","Bengkel Tamvan","Bengkel Tamvan","Bengkel Tamvan","Bengkel Tamvan","Bengkel Tamvan","Bengkel Tamvan","Bengkel Tamvan","Bengkel Tamvan","Bengkel Tamvan","Bengkel Tamvan","Bengkel Tamvan","Bengkel Tamvan","Bengkel Tamvan","Bengkel Tamvan","PostgreSQL","Bengkel Tamvan","Bengkel Tamvan","Bengkel Tamvan","Bengkel Tamvan"};
    String[] programAlamatList = {"Jl. Semangka No. 109","Jl. Semangka No. 109","Jl. Semangka No. 109","Jl. Semangka No. 109","Jl. Semangka No. 109","Jl. Semangka No. 109","Jl. Semangka No. 109","Jl. Semangka No. 109","Jl. Semangka No. 109","Jl. Semangka No. 109","Jl. Semangka No. 109","Jl. Semangka No. 109","Jl. Semangka No. 109","Jl. Semangka No. 109","Jl. Semangka No. 109","Jl. Semangka No. 109","Jl. Semangka No. 109","Jl. Semangka No. 109","Jl. Semangka No. 109","Jl. Semangka No. 109"};
    int[] programImages = {R.drawable.bengkel_logo};
    Button btnHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_riwayat);
        recyclerView = findViewById(R.id.rvRiwayat);

        layoutmanager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutmanager);

        programAdapter = new ProgramAdapter3(this, programNameList, programAlamatList, programImages);
        recyclerView.setAdapter(programAdapter);

        btnHome = (Button) findViewById(R.id.home);
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DaftarRiwayat.this, CustomerMapActivity.class);
                startActivity(intent);
            }
        });
    }
}