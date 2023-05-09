package hackeru.noameil.kitsuapp.ui.anime

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import hackeru.noameil.kitsuapp.R
import hackeru.noameil.kitsuapp.adapters.AnimeAdapter
import hackeru.noameil.kitsuapp.databinding.FragmentAnimeBinding

class AnimeFragment : Fragment() {

    private var _binding: FragmentAnimeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val animeViewModel =
            ViewModelProvider(this).get(AnimeViewModel::class.java)

        _binding = FragmentAnimeBinding.inflate(inflater, container, false)

        animeViewModel.trendingAnime.observe(viewLifecycleOwner) {
            println("Trending size:  ${it.size}")
            val adapter = AnimeAdapter(it) { clickedAnime ->
                val asStringAnime = Gson().toJson(clickedAnime)
                findNavController()
                    .navigate(R.id.action_anime_to_anime_description, bundleOf(Pair("anime",asStringAnime)))
            }
            binding.recyclerTrendingAnime.adapter = adapter
            binding.recyclerTrendingAnime.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        }

        animeViewModel.latestAnime.observe(viewLifecycleOwner) {
            val adapter = AnimeAdapter(it) { clickedAnime ->

            }
            println("Latest size:  ${it.size}")
            binding.recyclerLatestAnime.adapter = adapter
            binding.recyclerLatestAnime.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        }

        binding.descriptionButtonAnime.setOnClickListener {
            findNavController().navigate(R.id.action_anime_to_anime_description)
        }

//        binding.recyclerTrendingAnime.setOnClickListener{
//            val animeTitle = binding.recyclerTrendingAnime
//        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}