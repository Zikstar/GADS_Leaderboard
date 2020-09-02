package com.isaac.gadsleaderboard


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.isaac.gadsleaderboard.fragments.LeaderBoardFragment
import com.isaac.gadsleaderboard.fragments.LeaderBoardFragmentDirections
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.custom_toolbar.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar_lead as Toolbar?)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        submit_button.setOnClickListener {
            val action = LeaderBoardFragmentDirections.actionLeaderBoardFragmentToSubmissionFragment()
            navController.navigate(action)
        }

        iv_back.setOnClickListener {
            onBackPressed()
        }
    }

    fun adjustToolbarBasedOnFragment(fragmentId: Int){
        if(fragmentId == Constants.FRAGMENT_LEADERSHIP){
            toolbar_leadership.visibility = View.VISIBLE
            toolbar_submission.visibility = View.GONE
        } else{
            toolbar_leadership.visibility = View.GONE
            toolbar_submission.visibility = View.VISIBLE
        }
    }
}