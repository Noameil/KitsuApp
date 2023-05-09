package hackeru.noameil.kitsuapp.ui.anime

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import hackeru.noameil.kitsuapp.data.models.Anime.Anime
import hackeru.noameil.kitsuapp.data.models.Anime.AnimeResponse
import hackeru.noameil.kitsuapp.services.KitsuService
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AnimeViewModel : ViewModel() {

    private val _trendingAnime = MutableLiveData<List<Anime>>()
    val trendingAnime: LiveData<List<Anime>> = _trendingAnime

    private val _latestAnime = MutableLiveData<List<Anime>>()
    val latestAnime: LiveData<List<Anime>> = _latestAnime

    init {
        val kitsuService = KitsuService.create()

        viewModelScope.launch {
            val trendingAnimeResponse = kitsuService.trendingAnime()
            _trendingAnime.postValue(trendingAnimeResponse.data)

            val newAnimeResponse = kitsuService.newAnime()
            _latestAnime.postValue(newAnimeResponse.data)
        }
    }
}