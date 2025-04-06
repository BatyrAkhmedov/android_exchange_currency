package com.example.currency.presentation.recycler_view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.currency.databinding.CurrencyListItemBinding
import com.example.currency.presentation.model.CurrencyUiModel

class CurrencyAdapter() :
    ListAdapter<CurrencyUiModel, CurrencyVH>(CurrencyDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrencyVH {
        val binding =
            CurrencyListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CurrencyVH(binding)
    }

    override fun onBindViewHolder(holder: CurrencyVH, position: Int) {
        val currency = getItem(position)
        holder.bind(currency)
    }

}