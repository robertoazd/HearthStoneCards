package com.robertoazeredo.hearthstonecardsgit.ui.view

import android.os.Build
import android.os.Bundle
import android.text.Html
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
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
        setupLayout()
    }

    private fun setupLayout() {

        val card = args.card
        Glide.with(requireContext()).load(card.imageCard).into(binding.ivCard)

        binding.tvName.text = getString(R.string.name_format, card.name)

        if (!card.flavor.isNullOrEmpty()) {
            binding.tvFlavor.text = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                Html.fromHtml(getString(R.string.flavor_format, card.flavor), Html.FROM_HTML_MODE_COMPACT)
            } else {
                Html.fromHtml(getString(R.string.flavor_format, card.flavor))
            }
        } else {
            binding.tvFlavor.visibility = View.GONE
        }

        if (!card.text.isNullOrEmpty()) {
            binding.tvText.text = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                Html.fromHtml(getString(R.string.text_format, card.text), Html.FROM_HTML_MODE_COMPACT)
            } else {
                Html.fromHtml(getString(R.string.text_format, card.text))
            }
        } else {
            binding.tvText.visibility = View.GONE
        }

        if (!card.cardSet.isNullOrEmpty()) {
            binding.tvCardSet.text = getString(R.string.cardSet_format, card.cardSet)
        } else {
            binding.tvCardSet.visibility = View.GONE
        }

        if (!card.type.isNullOrEmpty()) {
            binding.tvType.text = getString(R.string.type_format, card.type)
        } else {
            binding.tvType.visibility = View.GONE
        }

        if (!card.faction.isNullOrEmpty()) {
            binding.tvFaction.text = getString(R.string.faction_format, card.faction)
        } else {
            binding.tvFaction.visibility = View.GONE
        }

        if (!card.rarity.isNullOrEmpty()) {
            binding.tvRarity.text = getString(R.string.rarity_format, card.rarity)
        } else {
            binding.tvRarity.visibility = View.GONE
        }

        binding.tvAttack.text = getString(R.string.attack_format, card.attack.toString())
        binding.tvCost.text = getString(R.string.cost_format, card.cost.toString())
        binding.tvHealth.text = getString(R.string.health_format, card.health.toString())

    }
}