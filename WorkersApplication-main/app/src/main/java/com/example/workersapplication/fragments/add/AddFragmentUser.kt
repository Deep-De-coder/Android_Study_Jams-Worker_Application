package com.example.workersapplication.fragments.add

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.workersapplication.R
import com.example.workersapplication.ViewModel.UserViewModel
import com.example.workersapplication.database.User.User
import kotlinx.android.synthetic.main.fragment_add_user.*
import kotlinx.android.synthetic.main.fragment_add_user.view.*


class AddFragmentUser : Fragment() {

    private  lateinit var mUserViewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_add_user, container, false)

        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        view.add_button.setOnClickListener{
            insertDataToDatabase()
        }
        return view
    }

    private fun insertDataToDatabase() {
        val firstname = addFirstName_et.text.toString()
        val lastname = addLastName_et.text.toString()
        val emailid = addEmailId_et.text.toString()
        val locality = addLocality_et.text.toString()
        val city = addCity_et.text.toString()
        val time = addTime_et.text
        val expectedsalary = addSalary_et.text
        val requirement = addRequirements_et.text.toString()
        val contactno =addContactNo_et.text

        if(inputcheck(firstname,lastname,emailid,locality,city,time,expectedsalary,requirement,contactno)){
            val user = User(0,firstname,lastname,emailid,locality,city,Integer.parseInt(time.toString()),Integer.parseInt(expectedsalary.toString()),requirement,Integer.parseInt(contactno.toString()))

            mUserViewModel.addUser(user)
            Toast.makeText(requireContext(),"Successfully added",Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_addFragmentUser_to_listFragmentUser)
        }
        else{
            Toast.makeText(requireContext(),"Please fill out all details",Toast.LENGTH_LONG).show()
        }

    }

    private fun inputcheck(
        firstname: String,
        lastname: String,
        emailid: String,
        locality: String,
        city: String,
        time: Editable,
        expectedsalary: Editable,
        requirements: String,
        contactno: Editable ): Boolean{
        return !(TextUtils.isEmpty(firstname) && TextUtils.isEmpty(lastname) && TextUtils.isEmpty(emailid) && TextUtils.isEmpty(locality) && TextUtils.isEmpty(city) && time.isEmpty() && expectedsalary.isEmpty() && TextUtils.isEmpty(requirements) && contactno.isEmpty())
    }
}