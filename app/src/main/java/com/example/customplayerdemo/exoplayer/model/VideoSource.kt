package com.example.customplayerdemo.exoplayer.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class VideoSource constructor(
        var videos: List<SingleVideo>? = null,
        var selectedSourceIndex: Int = 0
) : Parcelable {

    @Parcelize
    data class SingleVideo(var url: String? = null,

    ) : Parcelable
}

