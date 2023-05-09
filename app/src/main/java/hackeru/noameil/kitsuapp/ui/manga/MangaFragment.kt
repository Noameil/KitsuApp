package hackeru.noameil.kitsuapp.ui.manga

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import hackeru.noameil.kitsuapp.adapters.MangaAdapter
import hackeru.noameil.kitsuapp.R
import hackeru.noameil.kitsuapp.databinding.FragmentMangaBinding


class MangaFragment : Fragment() {

    private var _binding: FragmentMangaBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val mangaViewModel =
            ViewModelProvider(this).get(MangaViewModel::class.java)

        _binding = FragmentMangaBinding.inflate(inflater, container, false)


        mangaViewModel.mangas.observe(viewLifecycleOwner) {
            val adapter = MangaAdapter(it)
            binding.recyclerTrendingManga.adapter = adapter
            binding.recyclerTrendingManga.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

//            binding.recyclerLatestManga.adapter = adapter
//            binding.recyclerLatestManga.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        }

        binding.descriptionButtonManga.setOnClickListener {
            findNavController().navigate(R.id.action_manga_to_manga_description)
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}