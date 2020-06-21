package peruapps.movies.ui.movie

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class MovieModel(
    val id: Int,
    val detail: MovieDetailModel
) : Parcelable