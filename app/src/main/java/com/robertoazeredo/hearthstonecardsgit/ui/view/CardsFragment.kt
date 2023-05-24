package com.robertoazeredo.hearthstonecardsgit.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.SnapHelper
import com.robertoazeredo.hearthstonecardsgit.databinding.FragmentCardsBinding
import com.robertoazeredo.hearthstonecardsgit.ui.adapter.CardsAdapter
import com.robertoazeredo.hearthstonecardsgit.ui.viewmodel.CardsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CardsFragment : Fragment() {

    private lateinit var binding: FragmentCardsBinding
    private val viewModel: CardsViewModel by viewModels()

    private val adapter by lazy {
        CardsAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCardsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View , savedInstanceState: Bundle?) {
        super.onViewCreated(view , savedInstanceState)
        if (viewModel.cards.value == null) {
            viewModel.getCards()
        }

        setupLayout()
        setupListeners()
        setupObservables()
    }

    private fun setupLayout() {
        binding.rcCards.adapter = adapter

        val snapHelper: SnapHelper = LinearSnapHelper()
        snapHelper.attachToRecyclerView(binding.rcCards)
    }

    private fun setupListeners() {
        adapter.itemClick = { card ->
               findNavController().navigate(
                   CardsFragmentDirections.actionCardsFragmentToCardDetailFragment()
               )
            }
    }

    private fun setupObservables() {
        viewModel.cards.observe(viewLifecycleOwner) { cards ->
            if (!cards.isNullOrEmpty()) {
                adapter.insertCards(cards)
            } else {
                Toast.makeText(context, "Lista vazia", Toast.LENGTH_SHORT).show()
            }
            binding.progressBar.visibility = View.INVISIBLE
        }

        viewModel.error.observe(viewLifecycleOwner) { error ->
            Toast.makeText(context, error, Toast.LENGTH_SHORT).show()

            binding.progressBar.visibility = View.INVISIBLE
        }
    }
}