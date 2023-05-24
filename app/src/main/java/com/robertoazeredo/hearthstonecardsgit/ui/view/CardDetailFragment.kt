package com.robertoazeredo.hearthstonecardsgit.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.robertoazeredo.hearthstonecardsgit.R
import com.robertoazeredo.hearthstonecardsgit.databinding.FragmentCardDetailBinding
import kotlin.contracts.contract

class CardDetailFragment : Fragment() {

    private val args: CardDetailFragmentArgs by navArgs()
    private lateinit var binding: FragmentCardDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater , container: ViewGroup? ,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCardDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View , savedInstanceState: Bundle?) {
        super.onViewCreated(view , savedInstanceState)
        println(args.card)
    }
}