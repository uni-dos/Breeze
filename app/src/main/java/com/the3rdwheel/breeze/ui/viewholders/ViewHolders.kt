package com.the3rdwheel.breeze.ui.viewholders

import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import androidx.emoji.widget.EmojiTextView
import androidx.recyclerview.widget.RecyclerView
import com.the3rdwheel.breeze.R

class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val mTitle: EmojiTextView = itemView.findViewById(R.id.postTitle)
    val mAuthor: EmojiTextView = itemView.findViewById(R.id.postAuthor)
    val mSubReddit: EmojiTextView = itemView.findViewById(R.id.postSubbreddit)

}

class LoadingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val postLoading: ProgressBar = itemView.findViewById(R.id.postLoading)
}


class PostErrorViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val retryButton: Button = itemView.findViewById(R.id.footer_error_button)
}