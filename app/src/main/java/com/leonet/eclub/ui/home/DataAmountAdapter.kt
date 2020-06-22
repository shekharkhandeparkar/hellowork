package com.leonet.eclub.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.leonet.eclub.databinding.DataAmountRowBinding

class DataAmountAdapter(
    private val recordDataList: List<String>,
    val clickListener: (String) -> Unit
) :
    RecyclerView.Adapter<DataAmountAdapter.DataAmountViewHolder>() {

    class DataAmountViewHolder(private val cardNumberRowBinding: DataAmountRowBinding) :
        RecyclerView.ViewHolder(cardNumberRowBinding.root) {
        fun bind(data: String) {
//            cardNumberRowBinding.recordsData = data
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DataAmountViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = DataAmountRowBinding.inflate(layoutInflater, parent, false)
        return DataAmountViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DataAmountViewHolder, position: Int) {
        holder.bind(recordDataList[position])
        holder.itemView.setOnClickListener { clickListener(recordDataList[position]) }
    }

    override fun getItemCount() = recordDataList.size
}