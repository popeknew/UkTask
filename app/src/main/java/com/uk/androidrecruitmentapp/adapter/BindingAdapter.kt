package com.uk.androidrecruitmentapp.adapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.uk.androidrecruitmentapp.R
import kotlinx.android.synthetic.main.layout_progressbar.view.*

@BindingAdapter("setAvatar")
fun ImageView.setAvatar(url: String) {

    val circularProgressDrawable = CircularProgressDrawable(context)
    circularProgressDrawable.strokeWidth = 5f
    circularProgressDrawable.centerRadius = 30f
    circularProgressDrawable.start()

    Glide
            .with(this)
            .load(url)
            .placeholder(circularProgressDrawable)
            .centerCrop()
            .into(this)
}
