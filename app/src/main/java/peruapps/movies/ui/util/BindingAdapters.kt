package peruapps.movies.ui.util

import android.graphics.drawable.Drawable
import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.signature.ObjectKey
import peruapps.movies.ui.movie.MovieModel

@BindingAdapter("image")
fun loadImage(
    view: AppCompatImageView,
    movie: MovieModel
) {
    Glide.with(view.context).load(movie.detail.image).dontTransform()
        .signature(ObjectKey(movie.id.toString()))
        .into(view)
}

@BindingAdapter("imageCircle")
fun loadImageCircular(
    view: AppCompatImageView,
    image: Drawable
) {
    Glide.with(view.context).load(image).circleCrop()
        .into(view)
}