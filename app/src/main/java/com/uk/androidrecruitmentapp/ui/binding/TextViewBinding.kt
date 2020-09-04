package com.uk.androidrecruitmentapp.ui.binding

import android.annotation.SuppressLint
import android.widget.TextView
import androidx.databinding.BindingAdapter
import java.text.SimpleDateFormat
import java.util.*

class TextViewBinding {
    private val formatter = SimpleDateFormat("HH:mm", Locale.getDefault())

    @SuppressLint("SetTextI18n")
    @BindingAdapter("date")
    fun TextView.date(prefix: String) {
        val date = formatter.format("dateProvider.dateNow().time")
        this.text = "$prefix $date"
    }
}