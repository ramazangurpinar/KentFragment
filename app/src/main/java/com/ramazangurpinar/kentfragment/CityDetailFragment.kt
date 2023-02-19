package com.ramazangurpinar.kentfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.ramazangurpinar.kentfragment.databinding.FragmentCityBinding
import com.ramazangurpinar.kentfragment.databinding.FragmentCityDetailBinding


class CityDetailFragment : Fragment() {

    private var _binding: FragmentCityDetailBinding? = null
    private val binding get() = _binding!!
    var name = ""
    var country = ""
    var imageCity = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            name = CityDetailFragmentArgs.fromBundle(it).nameTextArg
            country = CityDetailFragmentArgs.fromBundle(it).countryTextArg
            imageCity = CityDetailFragmentArgs.fromBundle(it).imageCityViewArgs
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCityDetailBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.nameText.text = name
        binding.countryText.text = country
        binding.imageCityView.setImageResource(imageCity)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}