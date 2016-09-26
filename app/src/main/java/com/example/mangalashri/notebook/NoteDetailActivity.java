package com.example.mangalashri.notebook;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import static com.example.mangalashri.notebook.R.drawable.f;

public class NoteDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_detail);
        createAndAddFragment();
    }
    private void createAndAddFragment(){
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        NoteViewFragment noteViewFragment = new NoteViewFragment();
        setTitle(R.string.viewFragmentTitle);
        fragmentTransaction.add(R.id.note_container,noteViewFragment,"NOTE_VIEW_FRAGMENT");
        fragmentTransaction.commit();
    }
}
