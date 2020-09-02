package com.isaac.gadsleaderboard.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.isaac.gadsleaderboard.Constants
import com.isaac.gadsleaderboard.MainActivity
import com.isaac.gadsleaderboard.MainViewModel
import com.isaac.gadsleaderboard.R
import kotlinx.android.synthetic.main.custom_toolbar.*
import kotlinx.android.synthetic.main.fragment_submission.*

class SubmissionFragment : Fragment() {
    private lateinit var mainActivity: MainActivity
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_submission, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainActivity.adjustToolbarBasedOnFragment(Constants.FRAGMENT_SUBMISSION)
        mainViewModel.responseLiveData.observe(viewLifecycleOwner, Observer { response ->
            if(response.isSuccessful){
                Log.i("Post Form gads", "Successful")
                val raw = response.raw()
            }else{
                Log.i("Post Form gads", "Failure to post gads")
            }
        })

        btn_submit_project.setOnClickListener {
            val firstName = editTextFirstName.text.toString().trim()
            val lastName = editTextLastName.text.toString().trim()
            val email = editTextTextEmailAddress.text.toString().trim()
            val projectLink = editTextProjectLink.text.toString().trim()

            mainViewModel.submitProjectDetails(firstName, lastName, email, projectLink)
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is MainActivity) {
            mainActivity = context
        }
    }
}