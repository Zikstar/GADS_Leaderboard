package com.isaac.gadsleaderboard.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.isaac.gadsleaderboard.MainViewModel
import com.isaac.gadsleaderboard.R
import com.isaac.gadsleaderboard.adapters.LearnersByHourAdapter
import com.isaac.gadsleaderboard.adapters.LearnersBySkillAdapter
import kotlinx.android.synthetic.main.fragment_skill_leaders.*

class SkillLeadersFragment : Fragment() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_skill_leaders, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.learnersBySkillIQ.observe(viewLifecycleOwner, Observer {
            rv_learners_skill.adapter = LearnersBySkillAdapter(it)
        })
    }

}