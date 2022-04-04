package com.joblogic.todoapp.utils

import android.graphics.drawable.AnimationDrawable
import android.os.Build
import android.text.Html
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.databinding.BindingAdapter


val TAG = "BindingAdapters"






@BindingAdapter("app:visibleIfTrue")
fun visibleIfTrue(view: View, isVisible: Boolean) {
    view.visibility = if (isVisible) View.VISIBLE else View.GONE
    if (isVisible) view.requestFocus()
}

@BindingAdapter("app:enableIfTrue")
fun enableIfTrue(view: View, isEnable: Boolean) {
    view.isEnabled = isEnable
}

@BindingAdapter("app:playAnimation")
fun playAnimation(view: ImageView, isPlay: Boolean) {
    val frameAnimation: AnimationDrawable = view.background as AnimationDrawable
    if (isPlay) frameAnimation.start() else frameAnimation.stop()
}





@BindingAdapter("app:setText")
fun setText(view: View, text: String) {
    if (view is TextView) {
        view.text = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            Html.fromHtml(text, Html.FROM_HTML_MODE_LEGACY).toString()
        } else {
            Html.fromHtml(text).toString()
        }
    } else if (view is AppCompatButton) {
        view.text = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            Html.fromHtml(text, Html.FROM_HTML_MODE_LEGACY).toString()
        } else {
            Html.fromHtml(text).toString()
        }
    }
}
