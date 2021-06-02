package ru.goncharova.my_notes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    ArrayList<Note> notes = new ArrayList<>();

    protected void createTestData() {
        Note temp;

        temp = new Note();
        temp.setName("Встреча в 13:00");
        temp.setAuthor("User");
        temp.setText("Доехать до Краснопресненской");
        temp.setDatetime(new Date());
        notes.add(temp);

        temp = new Note();
        temp.setName("Забрать вещи из химчистки");
        temp.setAuthor("");
        temp.setText("Пиджак/рубашка");
        temp.setDatetime(new Date());
        notes.add(temp);

        temp = new Note();
        temp.setName("Посетить музей");
        temp.setAuthor("");
        temp.setText("Купить билет на кассе");
        temp.setDatetime(new Date());
        notes.add(temp);

        temp = new Note();
        temp.setName("Сходить к врачу");
        temp.setAuthor("");
        temp.setText("Составить список витаминов");
        temp.setDatetime(new Date());
        notes.add(temp);

        temp = new Note();
        temp.setName("Купить стройматериалы");
        temp.setAuthor("");
        temp.setText("Цемент и шпаклевка");
        temp.setDatetime(new Date());
        notes.add(temp);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        createTestData();

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            setContentView(R.layout.activity_main_land);

            NotesListFragment detail = NotesListFragment.newInstance(notes);
            ArrayList<Button> buttons = new ArrayList<>();

            for (int i = 0; i < this.notes.size(); i++) {
                Button button = new Button(this);

                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        int id = ((Button) v).getId();

                        NoteDataFragment detail = NoteDataFragment.newInstance(notes.get(id).getName(),notes.get(id).getAuthor(), notes.get(id).getText(), notes.get(id).getDatetime().toString());

                        FragmentManager fragmentManager = getSupportFragmentManager();
                        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.noteData_land, detail);  // замена фрагмента
                        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                        fragmentTransaction.commit();
                    }
                });

                button.setText(notes.get(i).getName());
                button.setId(i);

                buttons.add(button);
            }

            detail.setButtons(buttons);

            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.notesListFragment_land, detail);  // замена фрагмента
            fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            fragmentTransaction.commit();
        }

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            setContentView(R.layout.activity_main);

            NotesListFragment detail = NotesListFragment.newInstance(notes);
            ArrayList<Button> buttons = new ArrayList<>();

            for (int i = 0; i < this.notes.size(); i++) {
                Button button = new Button(this);

                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        int id = ((Button) v).getId();

                        String NAME     = "NAME";
                        String AUTHOR   = "AUTHOR";
                        String TEXT     = "TEXT";
                        String DATETIME = "DATETIME";

                        Intent intent = new Intent(getApplicationContext(), NoteOpenActivity.class);

                        intent.putExtra(NAME, notes.get(id).getName());
                        intent.putExtra(AUTHOR, notes.get(id).getAuthor());
                        intent.putExtra(TEXT, notes.get(id).getText());
                        intent.putExtra(DATETIME, notes.get(id).getDatetime());

                        startActivity(intent);
                    }
                });

                button.setText(notes.get(i).getName());
                button.setId(i);

                buttons.add(button);
            }

            detail.setButtons(buttons);

            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.notesListFragment, detail);  // замена фрагмента
            fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            fragmentTransaction.commit();
        }
    }
}