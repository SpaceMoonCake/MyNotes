package com.example.mynotes;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private Note note1 = new Note("Note 1", "Text note 1", "01.02.2021");
    private Note note2 = new Note("Note 2", "Text note 2", "02.02.2021");
    private Note note3 = new Note("Note 3", "Text note 3", "03.02.2021");
    private Note note4 = new Note("Note 4", "Text note 4", "04.02.2021");
    public Note[] listOfNotes = new Note[]{note1, note2, note3, note4};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListOfNotesFragment listOfNotesFragment = ListOfNotesFragment.newInstance(listOfNotes);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main_activity, listOfNotesFragment)
                .commit();
    }


}