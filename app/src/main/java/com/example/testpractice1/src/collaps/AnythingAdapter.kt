package com.example.testpractice1.src.collaps

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testpractice1.databinding.ItemCollapsAnythingBinding

private lateinit var binding : ItemCollapsAnythingBinding

class AnythingAdapter(private val data: ArrayList<Anything>) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        binding = ItemCollapsAnythingBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder) {
            is ViewHolder -> holder.bind(data[position])
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class ViewHolder(private val binding: ItemCollapsAnythingBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data:Anything) {
            binding.itemCollapsTvTitle.text = data.title
            binding.itemCollapsTvSubtitle.text = data.subtitle
        }
    }
}