package com.example.mangalashri.notebook;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import static com.example.mangalashri.notebook.R.id.noteText;
import static com.example.mangalashri.notebook.R.id.viewNoteMessage;


/**
 * A simple {@link Fragment} subclass.
 */
public class NoteViewFragment extends Fragment {


    public NoteViewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View fragmentLayout = inflater.inflate(R.layout.fragment_note_view,container,false);
        TextView title = (TextView)fragmentLayout.findViewById(R.id.viewNoteTitle);
        TextView note = (TextView) fragmentLayout.findViewById(viewNoteMessage);
        ImageView noteIcon = (ImageView) fragmentLayout.findViewById(R.id.viewNoteIcon);

        Intent intent = getActivity().getIntent();
        title.setText(intent.getStringExtra(MainActivity.NOTE_TITLE_EXTRA));
        note.setText(intent.getStringExtra(MainActivity.NOTE_MESSAGE_EXTRA));

        Note.Category noteCat = (Note.Category) intent.getSerializableExtra(MainActivity.NOTE_CATEGORY_EXTRA);
        noteIcon.setImageResource(Note.categoryToDrawable(noteCat));

        // Inflate the layout for this fragment
        return fragmentLayout;
    }

}
