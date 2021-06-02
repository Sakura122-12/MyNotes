package ru.goncharova.mynotes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;

public class NoteOpenActivity extends AppCompatActivity {

    String NAME     = "NAME";
    String AUTHOR   = "AUTHOR";
    String TEXT     = "TEXT";
    String DATETIME = "DATETIME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_open);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        if(bundle != null) {

            String name     = bundle.getString(NAME);
            String author   = bundle.getString(AUTHOR);
            String text     = bundle.getString(TEXT);
            String datetime = bundle.getString(DATETIME);

            NoteDataFragment detail = NoteDataFragment.newInstance(name, author, text, datetime);

            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.note_fragment_container, detail);  // замена фрагмента
            fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            fragmentTransaction.commit();
        }
    }
}

