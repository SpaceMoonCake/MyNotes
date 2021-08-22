package com.example.mynotes;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class BodyOfNoteFragment extends Fragment {

    public static final String ARG_NOTE = "note";
    private Note note;

    public BodyOfNoteFragment() {
        // Required empty public constructor
    }

    public static BodyOfNoteFragment newInstance(Note note) {
        BodyOfNoteFragment fragment = new BodyOfNoteFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_NOTE, note);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            note = (Note) getArguments().getParcelable(ARG_NOTE);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_body_of_note, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view, note);
    }

    private void initView(View view, Note note) {
        LinearLayout linearLayout = (LinearLayout) view;
        TextView textViewDataCreatedNote = new TextView(getContext());
        TextView textViewTitleNote = new TextView(getContext());
        TextView textViewBodyNote = new TextView(getContext());
        textViewTitleNote.setText(note.getTitleNote());
        textViewDataCreatedNote.setText(note.getDateCreatedNote());
        textViewBodyNote.setText(note.getBodyNote());
        linearLayout.addView(textViewDataCreatedNote);
        linearLayout.addView(textViewTitleNote);
        linearLayout.addView(textViewBodyNote);
    }
}