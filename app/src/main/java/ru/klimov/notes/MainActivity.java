package ru.klimov.notes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.nfc.cardemulation.CardEmulation;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       List<Note> noteList = Arrays.asList(
               new Note(getString(R.string.title1), getString(R.string.content1)),
               new Note(getString(R.string.title2), getString(R.string.content2)),
               new Note(getString(R.string.title3), getString(R.string.content3)),
               new Note(getString(R.string.title4), getString(R.string.content4))
       );

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        NotesAdapter adapter = new NotesAdapter(noteList);
        adapter.setClickListener((view, position) -> {
            Toast.makeText(this, noteList.get(position).getContent(), Toast.LENGTH_SHORT).show();
        });
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, LinearLayoutManager.VERTICAL);
        dividerItemDecoration.setDrawable(AppCompatResources.getDrawable(this, R.drawable.separator));
        recyclerView.addItemDecoration(dividerItemDecoration);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);


    }
}