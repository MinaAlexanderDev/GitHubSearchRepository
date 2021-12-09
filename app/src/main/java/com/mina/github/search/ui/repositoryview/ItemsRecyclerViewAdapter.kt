package com.mina.github.search.ui.repositoryview

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.mina.github.R
import com.mina.github.databinding.ListItemRepositoryBinding

import com.mina.github.search.models.repository.Items


class ItemsRecyclerViewAdapter : PagingDataAdapter<Items,
        ItemsRecyclerViewAdapter.ImageViewHolder>(diffCallback) {
    inner class ImageViewHolder(binding: ListItemRepositoryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private var imgAvatar: ImageView = itemView.findViewById(R.id.img_avatar)
        private var tvUserName: TextView = itemView.findViewById(R.id.tv_item_userName)
        private var tvMessage: TextView = itemView.findViewById(R.id.tv_item_title)
//        private var tvId: TextView = itemView.findViewById(R.id.tv_item_id)

        fun bind(user: Items) {
            tvUserName.text = user.fullName
            tvMessage.text = user.description
//            tvId.text = user.id.toString()

            Glide.with(imgAvatar)
                .load(user.owner?.avatarUrl)
                .centerCrop()
                .transition(DrawableTransitionOptions.withCrossFade())
                .error(R.drawable.ic_error)
                .into(imgAvatar)
        }
    }


    companion object {

        val diffCallback = object : DiffUtil.ItemCallback<Items>() {
            override fun areItemsTheSame(oldItem: Items, newItem: Items): Boolean {
                return oldItem.id == oldItem.id
            }

            override fun areContentsTheSame(oldItem: Items, newItem: Items): Boolean {
                return oldItem.id == oldItem.id
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {

        return ImageViewHolder(
            ListItemRepositoryBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {

        val currChar = getItem(position)
//        Log.e("bind"," currChar : ${currChar}")
        if (currChar != null) {
            holder.bind(currChar)
        }
    }

}