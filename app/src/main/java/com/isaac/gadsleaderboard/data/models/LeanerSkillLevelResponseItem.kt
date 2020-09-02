package com.isaac.gadsleaderboard.data.models


import com.google.gson.annotations.SerializedName

data class LeanerSkillLevelResponseItem(
    @SerializedName("badgeUrl")
    val badgeUrl: String,
    @SerializedName("country")
    val country: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("score")
    val score: Int
)