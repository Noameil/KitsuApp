package hackeru.noameil.kitsuapp.services

import hackeru.noameil.kitsuapp.data.models.Anime.AnimeResponse
import hackeru.noameil.kitsuapp.data.models.Manga.MangaResponse
import hackeru.noameil.kitsuapp.utils.TokenInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

//https://kitsu.io/api/edge/

interface KitsuService {
    //Manga:
    @GET("manga")
    suspend fun getMangas(): MangaResponse

    @GET("manga")
    suspend fun getMangaForPage(@Query("page") page:Int) : MangaResponse

    @GET("trending/manga")
    suspend fun trendingManga(): MangaResponse

    @GET("manga?sort=-CreatedAt")
    suspend fun newManga(): MangaResponse

    //Anime:
    @GET("anime")
    suspend fun getAnime(): Call<AnimeResponse>

    @GET("trending/anime")
    suspend fun trendingAnime(): AnimeResponse

    @GET("anime?sort=-CreatedAt")
    suspend fun newAnime(): AnimeResponse

    companion object{
        fun create(): KitsuService {
            val logger = HttpLoggingInterceptor()
            logger.level = HttpLoggingInterceptor.Level.BODY

            val httpClient = OkHttpClient.Builder()
                .addInterceptor(TokenInterceptor())
                .addInterceptor(logger)
                .build()

            return Retrofit.Builder()
                .baseUrl("https://kitsu.io/api/edge/")
                .client(httpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(KitsuService::class.java)
        }
    }
}