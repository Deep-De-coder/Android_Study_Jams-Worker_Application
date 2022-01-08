package com.example.workersapplication.Adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.workersapplication.Models.Workers;
import com.example.workersapplication.R;
import com.example.workersapplication.WorkersProfile;

import java.util.ArrayList;

public class WorkersListAdapter extends RecyclerView.Adapter<WorkersListAdapter.MyViewHolder>{

    ArrayList<Workers> list;

    public WorkersListAdapter(ArrayList<Workers> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.model_workers_list,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
       Workers workers = list.get(position);
       holder.worker_name.setText(workers.getWorker_name());
       holder.location.setText(workers.getLocation());
       holder.worker_pic.setImageResource(workers.getWorker_image());
       holder.rating.setText(workers.getRating());
       holder.salary.setText(workers.getSalary());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.itemView.getContext(), WorkersProfile.class);
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView worker_name,location,salary,rating;
        ImageView worker_pic,bookmark_btn;
        int bookmark_select = 0;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            worker_name = itemView.findViewById(R.id.worker_name);
            location = itemView.findViewById(R.id.worker_location);
            worker_pic = itemView.findViewById(R.id.worker_image);
            bookmark_btn = itemView.findViewById(R.id.bookmark_btn);
            salary = itemView.findViewById(R.id.salary);
            rating = itemView.findViewById(R.id.rating);
            worker_pic.setClipToOutline(true);

            bookmark_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (bookmark_select == 0){
                        bookmark_select = 1;
                        bookmark_btn.setImageResource(R.drawable.ic_baseline_bookmark_24);
                    }
                    else {
                        bookmark_select = 0;
                        bookmark_btn.setImageResource(R.drawable.ic_baseline_bookmark_border_24);
                    }
                }
            });

        }
    }
}
