package com.example.mynotes;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CreatingNewNoteFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CreatingNewNoteFragment extends Fragment {

    public CreatingNewNoteFragment() {
        // Required empty public constructor
    }

    public static CreatingNewNoteFragment newInstance() {
        CreatingNewNoteFragment fragment = new CreatingNewNoteFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_creatin_new_note, container, false);
    }
}