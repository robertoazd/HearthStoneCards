package com.robertoazeredo.hearthstonecards.data.model

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class CardResponse(

    @Json(name = "img")
    val imageCard: String?,
    @Json(name = "name")
    val name: String?,
    @Json(name = "flavor")
    val flavor: String?,
    @Json(name = "text")
    val text: String?,
    @Json(name = "cardSet")
    val cardSet: String?,
    @Json(name = "type")
    val type: String?,
    @Json(name = "faction")
    val faction: String?,
    @Json(name = "rarity")
    val rarity: String?,
    @Json(name = "attack")
    val attack: Int?,
    @Json(name = "cost")
    val cost: Int?,
    @Json(name = "health")
    val health: Int?
) : Parcelable