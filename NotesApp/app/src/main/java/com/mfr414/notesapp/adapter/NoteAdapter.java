package com.mfr414.notesapp.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mfr414.notesapp.Constant;
import com.mfr414.notesapp.R;
import com.mfr414.notesapp.Setting;
import com.mfr414.notesapp.models.Note;

import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.ViewHolder> {

    private Context context;
    private List<Note> notes;
    private int layout;
    private Setting setTextSize;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        switch (getItemViewType(i)) {
            case Constant.LAYOUT_MODE_GRID:
                View gridView = LayoutInflater.from(context)
                        .inflate(R.layout.item_note_grid, viewGroup, false);
                return new GridViewHolder(gridView);

            default:
                View listView = LayoutInflater.from(context)
                        .inflate(R.layout.item_note_list, viewGroup, false);
                return new ListViewHolder(listView);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Note note = notes.get(i);
        viewHolder.onBindViewHolder(note);
    }

    @Override
    public int getItemCount() {
        return (notes != null) ? notes.size() : 0;
    }


    public abstract class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        protected abstract void onBindViewHolder(Note note);
    }

    public class ListViewHolder extends ViewHolder{
        TextView titleText;
        TextView dateText;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            titleText = itemView.findViewById(R.id.text_title);
            dateText = itemView.findViewById(R.id.text_date);
            titleText.setTextSize(setTextSize.getTextSize());
            dateText.setTextSize(setTextSize.getTextSize());
        }

        @Override
        protected void onBindViewHolder(Note note) {
            titleText.setText(note.getTitle());
            dateText.setText(note.getFormattedDate());

        }
    }

    public class GridViewHolder extends ViewHolder {
        TextView tittleText;
        TextView contentText;

        public GridViewHolder(@NonNull View itemView) {
            super(itemView);
            tittleText = itemView.findViewById(R.id.text_title);
            contentText = itemView.findViewById(R.id.text_content);
            tittleText.setTextSize(setTextSize.getTextSize());
            contentText.setTextSize(setTextSize.getTextSize());
        }

        @Override
        protected void onBindViewHolder(Note note) {
            tittleText.setText(note.getTitle());
            contentText.setText(note.getContent());
        }
    }

    public NoteAdapter(Context context, List<Note> notes, Setting setingText) {
        this.context = context;
        this.notes = notes;
        this.setTextSize = setingText;

    }

    public void setLayout(int layout) {
        this.layout = layout;
    }

    @Override
    public int getItemViewType(int position) {
        return layout;
    }
}
