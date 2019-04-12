package com.mfr414.notesapp.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.mfr414.notesapp.Constant;
import com.mfr414.notesapp.R;
import com.mfr414.notesapp.Setting;
import com.mfr414.notesapp.adapter.NoteAdapter;
import com.mfr414.notesapp.models.Data;


public class NoteFragment extends Fragment {

    private RecyclerView recyclerView;
    private NoteAdapter adapter;
    private OnNoteFragmentListener listener;
    Setting settingNote;

    public NoteFragment() {
        // Required empty public constructor
    }

    public void setListener(OnNoteFragmentListener listener) {
        this.listener = listener;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_note,container, false);
        recyclerView = view.findViewById(R.id.rv_notes);
        settingNote = new Setting(getContext());
        adapter = new NoteAdapter(getContext(), Data.getNotes(),settingNote);
        recyclerView.setAdapter(adapter);
        if (settingNote.getLayoutMode() == 1){
            displayAsGrid();
        }else {
            displayAsList();
        }
        return view;

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_note, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    // Untuk Menampilkan List atau Grid
    private void displayAsList() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        adapter.setLayout(Constant.LAYOUT_MODE_LIST);
    }

    private void displayAsGrid(){
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(), 2);
        recyclerView.setLayoutManager(layoutManager);
        adapter.setLayout(Constant.LAYOUT_MODE_GRID);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_show_list:
                displayAsList();
                settingNote.setLayoutMode(0);

                return true;
            case R.id.action_show_grid:
                displayAsGrid();
                settingNote.setLayoutMode(1);
                return true;

            case R.id.action_logout:
                listener.onLogoutClick();
                return true;

            case R.id.setTextSize:
                settingNote.setTextSize("22");
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public  interface OnNoteFragmentListener {
        void onLogoutClick();
    }
}
