package umn.ac.tamline;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class ChatUtama extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.Adapter programAdapter;
    RecyclerView.LayoutManager layoutmanager;
    String[] programNameList = {"Bengkel Tamvan","Bengkel Tamvan","Bengkel Tamvan","Bengkel Tamvan","Bengkel Tamvan","Bengkel Tamvan","Bengkel Tamvan","Bengkel Tamvan","Bengkel Tamvan","Bengkel Tamvan","Bengkel Tamvan","Bengkel Tamvan","Bengkel Tamvan","Bengkel Tamvan","Bengkel Tamvan","PostgreSQL","Bengkel Tamvan","Bengkel Tamvan","Bengkel Tamvan","Bengkel Tamvan"};
    String[] programPercakapanList = {"Oke bang","Oke bang","Oke bang","Oke bang","Oke bang","Oke bang","Oke bang","Oke bang","Oke bang","Oke bang","Oke bang","Oke bang","Oke bang","Oke bang","Oke bang","Oke bang","Oke bang","Oke bang","Oke bang","Oke bang"};
    int[] programImages = {R.drawable.bengkel_logo};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_utama);
        recyclerView = findViewById(R.id.rvChatUtama);

        layoutmanager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutmanager);

        programAdapter = new ProgramAdapter4(this, programNameList, programPercakapanList, programImages);
        recyclerView.setAdapter(programAdapter);
    }
}