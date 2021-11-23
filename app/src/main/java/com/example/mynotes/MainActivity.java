package com.example.mynotes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.provider.Settings;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

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
        initView();
    }

    private void initView() {
        findViewById(R.id.navigation_create_new_note).setOnClickListener(v -> {
            CreatingNewNoteFragment creatingNewNoteFragment = CreatingNewNoteFragment.newInstance();
            getSupportFragmentManager()
                    .beginTransaction()
                    .addToBackStack("")
                    .replace(R.id.container_for_fragment, creatingNewNoteFragment)
                    .commit();
        });
        ListOfNotesFragment listOfNotesFragment = ListOfNotesFragment.newInstance(listOfNotes);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container_for_fragment, listOfNotesFragment)
                .commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_up, menu);
        getMenuInflater().inflate(R.menu.menu_action_bar_up, menu);
        getMenuInflater().inflate(R.menu.menu_bottom_navigation, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menu_settings) {
            SettingsFragment settingsFragment = SettingsFragment.newInstance();
            showMenuItemFragment(settingsFragment);
        }
        if (item.getItemId() == R.id.menu_info) {
            InfoFragment infoFragment = InfoFragment.newInstance();
            showMenuItemFragment(infoFragment);
        }  if(item.getItemId() == R.id.navigation_create_new_note){
            CreatingNewNoteFragment creatingNewNoteFragment = CreatingNewNoteFragment.newInstance();
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container_for_fragment, creatingNewNoteFragment)
                    .commit();
        }

        return super.onOptionsItemSelected(item);
    }

    private void showMenuItemFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                //TODO Удалять текущий фрагмент (чтобы настройки не накладывались друг на друга)
                .addToBackStack("")
//                    Почему add не работает?
//                    .add(settingsFragment)
                .replace(R.id.main_activity, fragment)
                .commit();
    }

//    @Override
//    public void onBackPressed() {
//        Toast.makeText(this, "Shura?", Toast.LENGTH_SHORT).show();
//        super.onBackPressed();
//    }
}