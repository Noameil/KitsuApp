package hackeru.noameil.kitsuapp.ui.anime

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.google.gson.Gson
import hackeru.noameil.kitsuapp.R
import hackeru.noameil.kitsuapp.data.models.Anime.Anime
import hackeru.noameil.kitsuapp.databinding.FragmentAnimeDescriptionBinding

class AnimeDescriptionFragment : Fragment() {

    private var _binding: FragmentAnimeDescriptionBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private lateinit var animeViewModel: AnimeViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
         animeViewModel =
            ViewModelProvider(this).get(AnimeViewModel::class.java)

        _binding = FragmentAnimeDescriptionBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.backToAnime.setOnClickListener {
            findNavController().navigate(R.id.action_anime_description_to_anime)
        }

        arguments?.let {
            val anime = Gson().fromJson(it.getString("anime"),Anime::class.java)
            binding.animeTitleText.text = anime.attributes.titles.english
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}