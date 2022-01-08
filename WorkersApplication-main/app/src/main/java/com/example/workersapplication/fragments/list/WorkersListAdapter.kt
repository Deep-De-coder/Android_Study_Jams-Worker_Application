package com.example.workersapplication.fragments.list

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.workersapplication.KotSettingsActivity
import com.example.workersapplication.R
import com.example.workersapplication.WorkersProfile
import kotlinx.android.synthetic.main.activity_main.*
import com.example.workersapplication.database.workers.Workers
import kotlinx.android.synthetic.main.model_workers_list.view.*

class WorkersListAdapter: RecyclerView.Adapter<WorkersListAdapter.MyViewHolder>() {

    private var workersList = emptyList<Workers>()

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.model_workers_list, parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = workersList[position]
        holder.itemView.worker_name.text = currentItem.fName + " "+ currentItem.lName
        holder.itemView.worker_location.text = currentItem.locality + " ,"+ currentItem.city
        holder.itemView.workers_age.text = currentItem.age.toString()
        holder.itemView.rating.text = currentItem.rating.toString()
        holder.itemView.families_cared.text = "Cared for "+ currentItem.families_cared.toString() +" families"
        holder.itemView.experience.text = currentItem.experience.toString() +" years paid experience"
        holder.itemView.salary.text = "₹ "+currentItem.price.toString() +"/Mon"

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, WorkersProfile::class.java)
            intent.putExtra("wname",currentItem.fName + " "+ currentItem.lName)
            intent.putExtra("waddress",currentItem.locality + " ,"+ currentItem.city)
            intent.putExtra("wage",currentItem.age.toString())
            intent.putExtra("wrating",currentItem.rating.toString())
            intent.putExtra("wprice",currentItem.price.toString())
            intent.putExtra("wexp",currentItem.experience.toString())
            //intent.putExtra("wrating",currentItem.rating.toString())
            holder.itemView.context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int {
        return workersList.size
    }

    fun setData(worker: List<Workers>){
        this.workersList = worker
        notifyDataSetChanged()
    }
}