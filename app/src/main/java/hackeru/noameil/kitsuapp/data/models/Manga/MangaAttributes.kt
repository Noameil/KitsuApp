package hackeru.noameil.kitsuapp.data.models.Manga

import com.google.gson.annotations.SerializedName
import hackeru.noameil.kitsuapp.data.models.PosterImage
import hackeru.noameil.kitsuapp.data.models.Titles
import hackeru.noameil.kitsuapp.data.models.mangaModels.enums.EnumAgeRating
import hackeru.noameil.kitsuapp.data.models.mangaModels.enums.EnumStatus

data class MangaAttributes(
    @SerializedName("id")
    val mangaId: Int,
    @SerializedName("description")
    val description: String,
    @SerializedName("synopsis")
    val synopsis: String,
    @SerializedName("titles")
    val titles: Titles,
    @SerializedName("averageRating")
    val avgRating: Double,
    @SerializedName("userCount")
    val userCount: Long?,
    @SerializedName("favoritesCount")
    val favoritesCount: Long?,
    @SerializedName("startDate")
    val startDate: String,
    @SerializedName("endDate")
    val endDate: String?,
    @SerializedName("nextRelease")
    val nextRelease: String?,
    @SerializedName("popularityRank")
    val popularityRank: Long,
    @SerializedName("ratingRank")
    val ratingRank: Long,
    @SerializedName("ageRating")
    val enumAgeRating: EnumAgeRating,
    @SerializedName("ageRatingGuide")
    val ageRatingGuide: String?,
    @SerializedName("status")
    val status: EnumStatus,
    @SerializedName("posterImage")
    val posterImage: PosterImage,
    @SerializedName("chapterCount")
    val chapterCount: Long?,
    @SerializedName("volumeCount")
    val volumeCount: Long
)
