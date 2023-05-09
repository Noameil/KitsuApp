package hackeru.noameil.kitsuapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import hackeru.noameil.kitsuapp.data.models.Anime.Anime
import hackeru.noameil.kitsuapp.databinding.AnimeItemBinding

private const val DEFAULT_POSTER = "https://media.kitsu.io/anime/poster_images/1/tiny.jpg?1431697256"

class AnimeAdapter(val animes: List<Anime>,
val onAnimeClicked : (Anime) -> Unit): RecyclerView.Adapter<AnimeAdapter.VHAnime>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VHAnime {
        return VHAnime(
            AnimeItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun getItemCount() = animes.size

    override fun onBindViewHolder(holder: VHAnime, position: Int) {
        val anime = animes[position]
        holder.binding.titleText.text = anime.attributes.titles.english
            ?: anime.attributes.titles.japaneseEnglish
        Picasso.get().load(anime.attributes.posterImage.tinyPoster ?: DEFAULT_POSTER)
            .into(holder.binding.animePoster)

        holder.binding.root.setOnClickListener {
            onAnimeClicked.invoke(anime)
        }
    }

    class VHAnime(val binding: AnimeItemBinding) : RecyclerView.ViewHolder(binding.root)

}