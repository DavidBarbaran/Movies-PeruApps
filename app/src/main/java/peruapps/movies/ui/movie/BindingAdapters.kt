package peruapps.movies.ui.movie

import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.signature.ObjectKey

@BindingAdapter("image")
fun loadImage(
    view: AppCompatImageView,
    image: String
) {
    Glide.with(view.context).load(image)
        .signature(ObjectKey(System.currentTimeMillis().toString()))
        .into(view)
}