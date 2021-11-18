package ru.klimov.notes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.nfc.cardemulation.CardEmulation;
import android.os.Bundle;

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
        recyclerView.setAdapter();

    }
}