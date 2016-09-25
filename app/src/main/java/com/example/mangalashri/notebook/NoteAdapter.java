package com.example.mangalashri.notebook;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import static com.example.mangalashri.notebook.R.drawable.t;

/**
 * Created by Mangalashri on 26-09-2016.
 */

public class NoteAdapter extends ArrayAdapter<Note> {
    public NoteAdapter(Context context, ArrayList<Note> notes){
        super(context,0,notes);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Note note = getItem(position);

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_row,parent,false);
        }

        TextView noteTitle = (TextView)convertView.findViewById(R.id.listItemNoteTitle);
        TextView noteText = (TextView) convertView.findViewById(R.id.noteText);
        ImageView noteIcon = (ImageView) convertView.findViewById(R.id.listItemNoteImg);

        noteTitle.setText(note.getTitle());
        noteText.setText(note.getMessage());
        noteIcon.setImageResource(note.getAssociateddDrawable());

        return convertView;
    }
}

