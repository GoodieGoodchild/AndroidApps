package com.example.android.marsphotos

import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.android.marsphotos.network.MarsApiService
import com.example.android.marsphotos.network.MarsPhoto
import com.example.android.marsphotos.overview.PhotoGridAdapter

class BindingAdapters {

    @BindingAdapter("imageUrl")
    fun bindImage(imgView: ImageView, imgUrl: String?) {
        imgUrl?.let {
            val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()
            imgView.load(imgUri)
        }
    }

    @BindingAdapter("marsApiStatus")
    fun bindStatus(statusImageView: ImageView,
                   status: MarsApiService?) {
    }

    @BindingAdapter("listData")
    fun bindRecyclerView(recyclerView: RecyclerView,
                         data: List<MarsPhoto>?) {
        val adapter = recyclerView.adapter as PhotoGridAdapter
        adapter.submitList(data)
    }

}