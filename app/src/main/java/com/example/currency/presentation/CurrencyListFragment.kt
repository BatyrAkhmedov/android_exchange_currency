package com.example.currency.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.currency.databinding.FragmentCurrencyListBinding
import com.example.currency.dependency
import com.example.currency.presentation.recycler_view.CurrencyAdapter
import com.example.currency.presentation.util.animateVisibility


class CurrencyListFragment : Fragment() {
    private var _binding: FragmentCurrencyListBinding? = null
    private val binding get() = _binding!!
    private val viewModel: CurrencyViewModel by viewModels{ CurrencyViewModel.createFactory(requireContext().dependency) }
    private lateinit var currencyAdapter: CurrencyAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentCurrencyListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        currencyAdapter = CurrencyAdapter()
        binding.recyclerView.adapter = currencyAdapter
        setObservers()
        setListeners()
    }

    private fun setObservers() {
        viewModel.isLoading.observe(viewLifecycleOwner) { isLoading ->
            binding.progressBar.animateVisibility(isLoading)
        }
        viewModel.currencies.observe(viewLifecycleOwner) { currencies ->
            currencyAdapter.submitList(currencies)
        }
    }

    private fun setListeners() {
        binding.buttonRefresh.setOnClickListener {
            viewModel.refreshCurrencies()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}