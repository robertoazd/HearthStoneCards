package com.robertoazeredo.hearthstonecards.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.robertoazeredo.hearthstonecards.data.model.CardResponse
import com.robertoazeredo.hearthstonecards.databinding.ItemCardBinding

class CardsAdapter(
    var itemClick: (card: CardResponse) -> Unit = {}
) : RecyclerView.Adapter<CardsAdapter.CardViewHolder>() {

    private var cards: List<CardResponse> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup , viewType: Int): CardViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemCardBinding.inflate(layoutInflater, parent, false)
        return CardViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CardViewHolder , position: Int) {
        holder.bind(cards[position], itemClick)
    }

    override fun getItemCount() = cards.size

    fun insertCards(cards: List<CardResponse>) {
        notifyItemRangeRemoved(0, this.cards.size)
        this.cards = cards
        notifyItemInserted(this.cards.size)
    }

    class CardViewHolder(
        private val binding: ItemCardBinding
    ) : RecyclerView.ViewHolder(binding.root){

        fun bind(card: CardResponse, itemClick: (card: CardResponse) -> Unit = {}) {
            Glide.with(binding.root.context).load(card.imageCard).into(binding.imageCard)
            binding.root.setOnClickListener{
                itemClick.invoke(card)
            }
        }
    }

}