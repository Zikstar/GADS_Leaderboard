package com.isaac.gadsleaderboard.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayoutMediator
import com.isaac.gadsleaderboard.Constants
import com.isaac.gadsleaderboard.MainActivity
import com.isaac.gadsleaderboard.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.custom_toolbar.*
import kotlinx.android.synthetic.main.fragment_leader_board.*

val dashboardOptions = listOf("Learning Leaders", "Skill IQ Leaders")

class LeaderBoardFragment : Fragment() {
    private lateinit var mainActivity: MainActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_leader_board, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainActivity.adjustToolbarBasedOnFragment(Constants.FRAGMENT_LEADERSHIP)
        vpager_leaderboard.adapter = LeaderPageAdapter(this)
        TabLayoutMediator(tab_layout, vpager_leaderboard){
            tab, position -> tab.text = dashboardOptions[position]
        }.attach()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is MainActivity){
            mainActivity = context
        }
    }

}

class LeaderPageAdapter(fragment: Fragment) : FragmentStateAdapter(fragment){
    override fun getItemCount(): Int {
        return dashboardOptions.size
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 ->  LearningLeadersFragment()
            else -> SkillLeadersFragment()
        }
    }

}