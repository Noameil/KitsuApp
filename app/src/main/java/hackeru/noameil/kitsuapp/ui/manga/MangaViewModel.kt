package hackeru.noameil.kitsuapp.ui.manga

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import hackeru.noameil.kitsuapp.adapters.MangaAdapter
import hackeru.noameil.kitsuapp.data.models.Manga.Manga
import hackeru.noameil.kitsuapp.data.models.Manga.MangaResponse
import hackeru.noameil.kitsuapp.services.KitsuService
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MangaViewModel : ViewModel() {

    private val _mangas = MutableLiveData<HashMap<Int,MangaResponse>>(HashMap())
    val mangas: LiveData<HashMap<Int,MangaResponse>> = _mangas

    private val _currentPage = MutableLiveData(1)
    val currentPage: LiveData<Int> = _currentPage

    init {
        val kitsuService = KitsuService.create()

        viewModelScope.launch {
            val mangaResponse = kitsuService.getMangas()
            val map = HashMap<Int,MangaResponse>()
            map[1] = mangaResponse
            _mangas.postValue(map)
        }
    }

    /*fun nextPage(page: Int) {
        if(mangas.value !=null && mangas.value!!.contains(page)) {
            _currentPage.postValue(page)
        } else {
            val kitsuService = KitsuService.create()
            viewModelScope.launch {
                val response = kitsuService.getMangaForPage(page)
                mangas.value!![page] = response
                _currentPage.postValue(page)
            }
        }
    }*/
}