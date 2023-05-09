package hackeru.noameil.kitsuapp.data.models.Anime

import hackeru.noameil.kitsuapp.data.models.Links
import hackeru.noameil.kitsuapp.data.models.Meta

data class AnimeResponse(
    val data: List<Anime>,
    val links: Links,
    val meta: Meta
)
