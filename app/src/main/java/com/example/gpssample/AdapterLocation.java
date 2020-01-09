package com.example.gpssample;

import android.content.Context;
import android.location.Location;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterLocation extends RecyclerView.Adapter<AdapterLocation.ViewLocationViewHolder> {

    View view;
    ArrayList<Location> models = new ArrayList<>();


    public void setData(ArrayList<Location> location) {
        this.models = location;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewLocationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.locationlist, parent, false);
        ViewLocationViewHolder viewLocationViewHolder = new ViewLocationViewHolder(view);
        return viewLocationViewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull ViewLocationViewHolder holder, int position) {
        Location location = models.get(position);

        holder.textView.setText("Latitude : " + location.getLatitude() + "\nLongitude : " + location.getLongitude());

    }


    @Override
    public int getItemCount() {
        return models.size();
    }

    public class ViewLocationViewHolder extends RecyclerView.ViewHolder {

        AppCompatTextView textView;

        public ViewLocationViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.currenctLocation);
        }
    }
}
