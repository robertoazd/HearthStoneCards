package com.robertoazeredo.hearthstonecardsgit.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.robertoazeredo.hearthstonecardsgit.databinding.FragmentCardsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CardsFragment : Fragment() {

    private lateinit var binding: FragmentCardsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCardsBinding.inflate(inflater, container, false)
        return binding.root
    }

}