package com.isaac.gadsleaderboard.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.isaac.gadsleaderboard.data.models.LeanerSkillLevelResponseItem
import com.isaac.gadsleaderboard.databinding.LearnerItemSkillBinding
import java.util.*

class LearnersBySkillAdapter(private val topLearners: ArrayList<LeanerSkillLevelResponseItem>) :
    RecyclerView.Adapter<LearnerBySkillViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LearnerBySkillViewHolder {
        return LearnerBySkillViewHolder(
            LearnerItemSkillBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun getItemCount(): Int {
        return topLearners.size
    }

    override fun onBindViewHolder(holder: LearnerBySkillViewHolder, position: Int) {
        holder.binding.learnerInfoSkill = topLearners[position]
    }
}

@BindingAdapter("skillLevel", "country")
fun setLearnerSkillSubText(
    tvSubText: TextView,
    skillLevel: Int, country: String
) {
    val concat = "$skillLevel skill IQ score, $country"
    tvSubText.text = concat
}

class LearnerBySkillViewHolder(val binding: LearnerItemSkillBinding) :
    RecyclerView.ViewHolder(binding.root)