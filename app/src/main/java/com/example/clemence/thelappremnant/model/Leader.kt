package com.example.clemence.thelappremnant.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Leader (
        var name: String,
        var bio: String,
        var stat: String,
        var image: String,
        var id: String) : Parcelable