package com.example;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.tp01.R;

public class ListActivity extends AppCompatActivity {

    ListView notes_list;
    String notes [] = {"10", "3", "2", " 4", "15", "26", "17"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        notes_list = findViewById(R.id.notes_list);
        //on crée un adapter pour afficher les notes de tab:
        ArrayAdapter source = new ArrayAdapter(this, android.R.layout.simple_list_item_1, notes);

        //charger le contenu de l'adapter dans la liste
        notes_list.setAdapter(source);

    }
}