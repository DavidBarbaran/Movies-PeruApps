package peruapps.movies.ui.movie

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class MovieModel(
    val id: Int? = 0,
    val detail: MovieDetailModel? = null,
    var isShimmer: Boolean = false
) : Parcelable