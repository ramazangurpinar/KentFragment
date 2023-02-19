package com.ramazangurpinar.kentfragment

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import androidx.recyclerview.widget.RecyclerView
import com.ramazangurpinar.kentfragment.databinding.RecyclerRowBinding

class LandmarkAdapter(
    val landmarkList : ArrayList<Landmark>,
    val listener : OnItemClickListener
    ) :
    RecyclerView.Adapter<LandmarkAdapter.LandmarkHolder>() {

    inner class LandmarkHolder(val binding: RecyclerRowBinding) :
        RecyclerView.ViewHolder(binding.root),
        View.OnClickListener
    {

        init {
            binding.root.setOnClickListener(this)
        }
        override fun onClick(v: View?) {
            val position: Int = adapterPosition

            if(position != RecyclerView.NO_POSITION) {
                listener.onItemClick(position)
            }
        }

    }

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LandmarkHolder {
        val binding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return LandmarkHolder(binding)
    }

    override fun onBindViewHolder(holder: LandmarkHolder, position: Int) {
        holder.binding.recyclerViewTextView.text = landmarkList.get(position).name
    }


    override fun getItemCount(): Int {
        return landmarkList.size
    }

}