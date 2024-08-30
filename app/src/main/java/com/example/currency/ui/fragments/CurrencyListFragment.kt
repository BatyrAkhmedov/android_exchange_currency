package com.example.currency.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.currency.R
import com.example.currency.ui.viewmodels.CurrencyViewModel
import com.example.currency.ui.adapters.CurrencyAdapter
import com.example.currency_lib.data.remote.CurrencyRepository
import com.example.currency_lib.domain.mappers.CurrencyMapper
import com.example.currency_lib.domain.usecase.GetCurrencyRatesUseCase


class CurrencyListFragment : Fragment() {

    private lateinit var currencyViewModel: CurrencyViewModel
    private lateinit var currencyAdapter: CurrencyAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_currency_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        currencyAdapter = CurrencyAdapter(requireContext(), emptyList())
        view.findViewById<RecyclerView>(R.id.recycler_view).apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = currencyAdapter
        }
        currencyViewModel = CurrencyViewModel (GetCurrencyRatesUseCase(CurrencyRepository()), CurrencyMapper())


        currencyViewModel.currencies.observe(viewLifecycleOwner, Observer { currencies ->
                currencyAdapter.updateData(currencies)
            })

        // Начинаем загрузку данных
        currencyViewModel.fetchCurrencies("09692c0129301bf0639076c92a9f7b2c", "USD,AUD,CAD,PLN,MXN")
    }


}