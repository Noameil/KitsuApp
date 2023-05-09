package hackeru.noameil.kitsuapp.data.models.Manga

import hackeru.noameil.kitsuapp.data.models.Links
import hackeru.noameil.kitsuapp.data.models.Meta

data class MangaResponse(
    val data: List<Manga>,
    val links: Links,
    val meta: Meta
)
