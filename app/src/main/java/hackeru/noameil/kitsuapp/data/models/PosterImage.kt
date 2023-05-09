package hackeru.noameil.kitsuapp.data.models

import com.google.gson.annotations.SerializedName

data class PosterImage(
    @SerializedName("tiny")
    val tinyPoster: String,
    @SerializedName("small")
    val smallPoster: String,
    @SerializedName("medium")
    val mediumPoster: String,
    @SerializedName("large")
    val largePoster: String,
    @SerializedName("original")
    val originalPoster: String
)
