package com.isaac.gadsleaderboard.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.isaac.gadsleaderboard.data.models.LearnerHoursResponseItem
import com.isaac.gadsleaderboard.databinding.LearnerItemHourBinding
import java.util.ArrayList

class LearnersByHourAdapter(private val topLearners: ArrayList<LearnerHoursResponseItem>) :
    RecyclerView.Adapter<LearnersByHourViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LearnersByHourViewHolder {
        return LearnersByHourViewHolder(
            LearnerItemHourBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun getItemCount(): Int {
        return topLearners.size
    }

    override fun onBindViewHolder(holder: LearnersByHourViewHolder, position: Int) {
        holder.binding.learnerInfoHour = topLearners[position]
    }
}

@BindingAdapter("imageUrl")
fun loadImage(view: ImageView, imageUrl: String) {
    Glide.with(view).load(imageUrl).into(view);
}

@BindingAdapter("learnHours", "country")
fun setLearningHoursSubText(
    tvSubText: TextView,
    learningHours: Int, country: String
) {
    val concat = "$learningHours learning hours, $country"
    tvSubText.text = concat
}

class LearnersByHourViewHolder(val binding: LearnerItemHourBinding) :
    RecyclerView.ViewHolder(binding.root)