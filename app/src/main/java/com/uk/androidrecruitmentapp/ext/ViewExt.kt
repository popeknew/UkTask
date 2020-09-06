package com.uk.androidrecruitmentapp.ext

import android.view.View
import androidx.annotation.StringRes
import com.google.android.material.snackbar.Snackbar

fun View.setVisible(visible: Boolean, goneOnNotVisible: Boolean = false) {
    visibility =
            if (visible) View.VISIBLE else (if (goneOnNotVisible) View.GONE else View.INVISIBLE)
}

fun View.snackbar(@StringRes messageID: Int, short: Boolean) {
    Snackbar.make(
            this,
            messageID,
            if (short) Snackbar.LENGTH_SHORT else Snackbar.LENGTH_LONG
    ).show()
}