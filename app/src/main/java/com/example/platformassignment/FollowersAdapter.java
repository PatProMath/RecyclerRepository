package com.example.platformassignment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class FollowersAdapter extends RecyclerView.Adapter<FollowersAdapter.myViewHolder> {
    ArrayList<Follower> followersList;

    public FollowersAdapter(ArrayList<Follower> list) {
        this.followersList = list;
    }

    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater viewInflater = LayoutInflater.from(parent.getContext());
        View view = viewInflater.inflate(R.layout.followerview,parent,false);

        FollowersAdapter.myViewHolder viewHolder = new FollowersAdapter.myViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        Follower folInfo = followersList.get(position);
        holder.img.setImageResource(folInfo.getImage());
        holder.name.setText(folInfo.getName());
        holder.location.setText(folInfo.getLocation());
        holder.status.setText(folInfo.getStatus());
    }

    @Override
    public int getItemCount() {
        return followersList.size();
    }

    public void putNewList(ArrayList<Follower> filteredList) {
        followersList = filteredList;
        notifyDataSetChanged();
    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        TextView name, location, status;
        CircleImageView img;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.followerName);
            location = itemView.findViewById(R.id.followerLocation);
            status = itemView.findViewById(R.id.followerStatus);
            img =itemView.findViewById(R.id.followerImage);
        }
    }
}
