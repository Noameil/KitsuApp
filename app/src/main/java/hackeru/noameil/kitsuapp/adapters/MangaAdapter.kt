package hackeru.noameil.kitsuapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import hackeru.noameil.kitsuapp.data.models.Manga.Manga
import hackeru.noameil.kitsuapp.databinding.MangaItemBinding

private const val DEFAULT_POSTER = "https://media.kitsu.io/manga/poster_images/14916/tiny.jpg?1491099787"

class MangaAdapter(val mangas: List<Manga>): RecyclerView.Adapter<MangaAdapter.VHManga>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VHManga {
        return VHManga(
            MangaItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun getItemCount() = mangas.size

    override fun onBindViewHolder(holder: VHManga, position: Int) {
        val manga = mangas[position]
        holder.binding.titleText.text = manga.attributes.titles.english
            ?: manga.attributes.titles.japaneseEnglish
        Picasso.get().load(manga.attributes.posterImage.tinyPoster ?: DEFAULT_POSTER)
            .into(holder.binding.mangaPoster)
    }

    class VHManga(val binding: MangaItemBinding): RecyclerView.ViewHolder(binding.root)

}