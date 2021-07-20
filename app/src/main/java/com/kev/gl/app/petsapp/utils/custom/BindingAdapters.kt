package com.kev.gl.app.petsapp.utils.custom

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso

/**
 * @author Kevin Villalobos
 */
/**
 * ImageView extension
 *
 * Loads an image using Picasso
 *
 * @param url The image url that is being loaded.
 * @param placeholder Drawable resource
 * */
@BindingAdapter("imageUrl", "placeHolder", requireAll = false)
fun ImageView.setImageUrl(url: String?, placeholder: Drawable? = null) {
    Picasso.get()
        .load(url).apply {
            placeholder?.let {
                this.placeholder(placeholder)
            }
        }
        .into(this)
}
