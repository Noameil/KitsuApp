package hackeru.noameil.kitsuapp.ui.manga

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import hackeru.noameil.kitsuapp.R
import hackeru.noameil.kitsuapp.databinding.FragmentMangaDescriptionBinding

class MangaDescriptionFragment : Fragment() {

    private var _binding: FragmentMangaDescriptionBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val mangaViewModel =
            ViewModelProvider(this).get(MangaViewModel::class.java)

        _binding = FragmentMangaDescriptionBinding.inflate(inflater, container, false)

        binding.backToManga.setOnClickListener {
            findNavController().navigate(R.id.action_manga_description_to_manga)
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}