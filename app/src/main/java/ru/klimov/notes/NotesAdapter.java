package ru.klimov.notes;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.NoteViewHolder> {
    private List<Note> noteList;
    private onNoteClickListener clickListener;

    public NotesAdapter(List<Note> noteList) {
        this.noteList = noteList;
    }

    public void setClickListener(onNoteClickListener clickListener) {
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_item_layout, parent, false);
        return new NoteViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {
        holder.bind(noteList.get(position));
    }

    @Override
    public int getItemCount() {
        return noteList.size();
    }

    class NoteViewHolder extends RecyclerView.ViewHolder {

        TextView content = itemView.findViewById(R.id.content);
        TextView title = itemView.findViewById(R.id.title);

        public NoteViewHolder(@NonNull View itemView) {
            super(itemView);
        }
        void bind(Note note) {
            title.setText(note.getTitle());
            content.setText(note.getContent());
            content.setOnClickListener((View.OnClickListener) v -> {
                if (clickListener != null) {
                    clickListener.onNoteClick(v, getAdapterPosition());
                }
            });
        }
    }

    interface onNoteClickListener {
        void onNoteClick(View view, int position);
    }
}
