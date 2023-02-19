package com.ramazangurpinar.kentfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ramazangurpinar.kentfragment.databinding.FragmentCityBinding
import com.ramazangurpinar.kentfragment.databinding.RecyclerRowBinding


class CityFragment : Fragment(),LandmarkAdapter.OnItemClickListener {

    private var _binding: FragmentCityBinding? = null
    private val binding get() = _binding!!
    private lateinit var landmarkList: ArrayList<Landmark>
    private var selectedPosition = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        landmarkList = ArrayList<Landmark>()

        // Data
        val pisa = Landmark("Pisa","Italy",R.drawable.pisa)
        val eyfel = Landmark("Eyfel","Fransa",R.drawable.eyfel)
        val londonBridge = Landmark("London Bridge","UK",R.drawable.londonbridge)
        val tajmahal = Landmark("Taj Mahal","Hindistan",R.drawable.tajmahal)

        landmarkList.add(pisa)
        landmarkList.add(eyfel)
        landmarkList.add(londonBridge)
        landmarkList.add(tajmahal)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCityBinding.inflate(inflater, container, false)
        val view = binding.root
        binding.recyclerView.layoutManager = LinearLayoutManager(this.context)
        val landmarkAdapter = LandmarkAdapter(landmarkList, this)
        binding.recyclerView.adapter =landmarkAdapter
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    override fun onItemClick(position: Int) {
        println("Item $position clicked")
        val clickedItem = landmarkList[position]
        selectedPosition = position
        println(" "+clickedItem.country+" "+clickedItem.name)

        val action = CityFragmentDirections.actionCityFragmentToCityDetailFragment(clickedItem.country,clickedItem.name,clickedItem.image)
        Navigation.findNavController(this.requireView()).navigate(action)
    }

}