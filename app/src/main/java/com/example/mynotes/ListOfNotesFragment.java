package com.example.mynotes;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ListOfNotesFragment extends Fragment {

    private static final String ARG_LIST_OF_NOTES = "list of notes";
    private Note[] listOfNotes;
    private boolean isLandOrientation = false;


    public ListOfNotesFragment() {
        // Required empty public constructor
    }

    public static ListOfNotesFragment newInstance(Note[] listOfNotes) {
        ListOfNotesFragment fragment = new ListOfNotesFragment();
        Bundle arguments = new Bundle();
        arguments.putParcelableArray(ARG_LIST_OF_NOTES, listOfNotes);
        fragment.setArguments(arguments);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            listOfNotes = (Note[]) getArguments().getParcelableArray(ARG_LIST_OF_NOTES);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list_of_notes, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        isLandOrientation = getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE;
        if (isLandOrientation) {
            showNoteLand(listOfNotes[0]);
        }
        initView(view, listOfNotes);
    }

    private void initView(View view, Note[] listOfNotes) {
        LinearLayout linearLayout = (LinearLayout) view;
        for (Note note : listOfNotes) {
            TextView textView = new TextView(getContext());
            textView.setText(note.getTitleNote());
            textView.setTextSize(30);
            final Note finalNote = note;
            textView.setOnClickListener(v -> {
                showNote(finalNote);
            });
            linearLayout.addView(textView);
        }
    }

    private void showNote(Note finalNote) {
        if (isLandOrientation) {
            showNoteLand(finalNote);
        } else {
            showNotePort(finalNote);
        }

    }

    private void showNoteLand(Note finalNote) {
        BodyOfNoteFragment fragment = BodyOfNoteFragment.newInstance(finalNote);
        requireActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.body_of_note_land, fragment)
                .commit();
    }


    private void showNotePort(Note note) {
        Intent intent = new Intent();
        intent.setClass(getActivity(), BodyNoteActivity.class);
        intent.putExtra(BodyOfNoteFragment.ARG_NOTE, note);
        startActivity(intent);
    }
}