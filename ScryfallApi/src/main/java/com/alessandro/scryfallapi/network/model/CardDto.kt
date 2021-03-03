package com.alessandro.scryfallapi.network.model

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CardDto(
    @Expose
    @SerializedName("id")
    val id: String,
    @Expose
    @SerializedName("image_uris")
    val imageDto: ImageDto
) : Parcelable

@Parcelize
data class ImageDto(
    @Expose
    @SerializedName("small")
    val small: String,
    @Expose
    @SerializedName("normal")
    val normal: String,
    @Expose
    @SerializedName("large")
    val large: String,
    @Expose
    @SerializedName("png")
    val png: String,
    @Expose
    @SerializedName("art_crop")
    val art_crop: String,
    @Expose
    @SerializedName("border_crop")
    val border_crop: String,
) : Parcelable

