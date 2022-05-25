    package com.soul.touristcompany.presentation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.soul.touristcompany.R;
import com.soul.touristcompany.domain.Tourist;

import java.util.ArrayList;

public class TouristAdapter extends RecyclerView.Adapter<TouristAdapter.TouristViewHolder> {

    private ArrayList<Tourist> tourists;

    public TouristAdapter(ArrayList<Tourist> tourists) {
        this.tourists = tourists;
    }

    public void setTourists(ArrayList<Tourist> tourists) {
        this.tourists = tourists;
        notifyDataSetChanged();
    }

    @NonNull
    @org.jetbrains.annotations.NotNull
    @Override
    public TouristViewHolder onCreateViewHolder(@NonNull @org.jetbrains.annotations.NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.note_item, parent, false);
        return new TouristViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @org.jetbrains.annotations.NotNull TouristAdapter.TouristViewHolder holder, int position) {

        Tourist tourist = tourists.get(position);
        holder.title.setText(tourist.getTitle());
       holder.imageView.setImageResource(tourist.getImages());
        holder.description.setText(tourist.getDescription());


    }

    @Override
    public int getItemCount() {
        return tourists.size();
    }

    class TouristViewHolder extends RecyclerView.ViewHolder {
        private TextView title;
        private ImageView imageView;
        private TextView description;
        public TouristViewHolder(@NonNull @org.jetbrains.annotations.NotNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.textViewTitleItem);
            imageView = itemView.findViewById(R.id.imageView_first);
            description = itemView.findViewById(R.id.textViewDescription);
        }
    }
}
