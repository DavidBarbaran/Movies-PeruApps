package peruapps.movies.ui.movie

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class MovieDetailModel(
    val title: String,
    val description: String,
    val image: String
) : Parcelable