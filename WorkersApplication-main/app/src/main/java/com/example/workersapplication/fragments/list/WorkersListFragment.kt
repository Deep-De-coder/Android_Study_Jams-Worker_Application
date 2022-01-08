package com.example.workersapplication.fragments.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.workersapplication.R
import com.example.workersapplication.viewmodels.WorkersViewModel
import kotlinx.android.synthetic.main.fragment_workers_list.view.*
import kotlinx.coroutines.flow.observeOn


class WorkersListFragment : Fragment() {


    private lateinit var mWorkersViewModel : WorkersViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_workers_list, container, false)

        //recycler view
        val adapter = WorkersListAdapter()
        val recyclerView = view.workers_list
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        //view model
        mWorkersViewModel = ViewModelProvider(this).get(WorkersViewModel::class.java)
        mWorkersViewModel.readAllData.observe(viewLifecycleOwner, Observer { workers ->
            adapter.setData(workers)
        })

        return view
    }


}