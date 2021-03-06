package com.isaac.gadsleaderboard.data.models

import com.google.gson.annotations.SerializedName

data class LearnerHoursResponseItem(
    @SerializedName("badgeUrl")
    val badgeUrl: String,
    @SerializedName("country")
    val country: String,
    @SerializedName("hours")
    val hours: Int,
    @SerializedName("name")
    val name: String
)