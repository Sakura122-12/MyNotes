package ru.goncharova.my_notes;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NoteDataFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NoteDataFragment extends Fragment {

    private boolean isLandscape;

    private static final String NAME_PARAM   = "name";
    private static final String AUTHOR_PARAM = "author";
    private static final String TEXT_PARAM         = "text";
    private static final String DATETIME_PARAM     = "datetime";

    private String name;
    private String author;
    private String text;
    private String datetime;

    public NoteDataFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static NoteDataFragment newInstance(String name, String author, String text, String datetime) {
        NoteDataFragment fragment = new NoteDataFragment();
        Bundle args = new Bundle();
        args.putString(NAME_PARAM,      name);
        args.putString(AUTHOR_PARAM,    author);
        args.putString(TEXT_PARAM,      text);
        args.putString(DATETIME_PARAM,  datetime);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            name = getArguments().getString(NAME_PARAM);
            author = getArguments().getString(AUTHOR_PARAM);
            text = getArguments().getString(TEXT_PARAM);
            datetime = getArguments().getString(DATETIME_PARAM);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_note_data, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView nameTextView = (TextView)view.findViewById(R.id.editTextNameNote);
        nameTextView.setText(name);

        TextView authorTextView = (TextView)view.findViewById(R.id.editTextNameAuthor);
        authorTextView.setText(author);

        TextView textTextView = (TextView)view.findViewById(R.id.editTextText);
        textTextView.setText(text);

        TextView datetimeTextView = (TextView)view.findViewById(R.id.editTextDataTime);
        datetimeTextView.setText(datetime);
    }
}