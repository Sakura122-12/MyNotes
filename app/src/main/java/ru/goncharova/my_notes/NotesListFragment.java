package ru.goncharova.mynotes;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;


import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NotesListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NotesListFragment extends Fragment {


    private ArrayList<String> notesParams;

    ArrayList<Button> buttons;
    ArrayList<Note> notes;

    public NotesListFragment() {
        // Required empty public constructor
    }

    public static NotesListFragment newInstance(ArrayList<Note> notes) {
        NotesListFragment fragment = new NotesListFragment();
        Bundle args = new Bundle();

        for(int i = 0; i < notes.size();i++) {
            args.putString("param" + i, notes.get(i).getName());
        }
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        createButtons(view);
    }

    public void createButtons(View view) {
        LinearLayout linearLayout = (LinearLayout)view.findViewById(R.id.notesList);

        for (int i = 0; i < this.buttons.size(); i++) {

            buttons.get(i).setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT));

            linearLayout.addView(buttons.get(i));
        }
    }

    public void setNotes(ArrayList<Note> notes) {
        this.notes = notes;
    }
    public void setButtons(ArrayList<Button> buttons) {
        this.buttons = buttons;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_notes_list, container, false);
    }
}