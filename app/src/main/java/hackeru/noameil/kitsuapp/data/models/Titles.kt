package hackeru.noameil.kitsuapp.data.models

import com.google.gson.annotations.SerializedName

data class Titles(
    @SerializedName("en")
    val english: String?,
    @SerializedName("en_jp")
    val japaneseEnglish: String?,
    @SerializedName("ja_jp")
    val japanese: String?
)
