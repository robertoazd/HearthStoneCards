package com.robertoazeredo.hearthstonecardsgit.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.robertoazeredo.hearthstonecardsgit.databinding.FragmentCardsBinding
import com.robertoazeredo.hearthstonecardsgit.ui.viewmodel.CardsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CardsFragment : Fragment() {

    private lateinit var binding: FragmentCardsBinding
    private val viewModel: CardsViewModel by viewModels()

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
    }

    
}