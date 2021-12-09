package com.mina.github.search.models.repository

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class License(

    @SerializedName("key") var key: String? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("spdx_id") var spdxId: String? = null,
    @SerializedName("url") var url: String? = null,
    @SerializedName("node_id") var nodeId: String? = null

) : Parcelable