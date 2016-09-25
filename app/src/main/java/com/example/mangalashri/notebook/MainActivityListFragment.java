package com.example.mangalashri.notebook;


import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import static android.R.string.no;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainActivityListFragment extends ListFragment {

    private ArrayList<Note> notes;
    private NoteAdapter noteAdapter;
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
       /* String[] values = new String[]{"Android", "iPhone", "WindowsMobile","Blackberry", "WebOS","Ubuntu", "Windows7", "Mac OS x", "Linux" };
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,values);
        setListAdapter(adapter);*/

        notes = new ArrayList<Note>();
        notes.add(new Note("This is a new note title!", "This is the body of our note!", Note.Category.PERSONAL));
        notes.add(new Note("New note Hey Hey Hey Lets see how large we can make this thing let's see hos much large", "something wrong?",Note.Category.FINANCE));
        notes.add(new Note("This is working very well", "I'cant speak English",Note.Category.QUOTE));
        notes.add(new Note("Uncle ben?", "With big powers come big responsibility",Note.Category.QUOTE));
        notes.add(new Note("Good Stuff", "Happy new year? LOL",Note.Category.TECHNICAL));
        notes.add(new Note("This is a new  note Title", "This is the Body of our Note",Note.Category.QUOTE));
        notes.add(new Note("Whats up", "Google knows everything",Note.Category.TECHNICAL));
        notes.add(new Note("Moneyyyyy", "Yeah baby",Note.Category.FINANCE));


        noteAdapter = new NoteAdapter(getActivity(),notes);
        setListAdapter(noteAdapter);

        /*getListView().setDivider(ContextCompat.getDrawable(getActivity(), android.R.color.white));
        getListView().setDividerHeight(1);*/
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        launchNoteDetailActivity(position);
    }

    private void launchNoteDetailActivity(int position){
        Note note = (Note) getListAdapter().getItem(position);
        Intent intent = new Intent(getActivity(), NoteDetailActivity.class);
        intent.putExtra(MainActivity.NOTE_TITLE_EXTRA,note.getTitle());
        intent.putExtra(MainActivity.NOTE_MESSAGE_EXTRA, note.getMessage());
        intent.putExtra(MainActivity.NOTE_CATEGORY_EXTRA,note.getCategory());
        intent.putExtra(MainActivity.NOTE_ID_EXTRA,note.getNoteId());

        startActivity(intent);
    }
}

