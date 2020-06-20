package peruapps.movies.ui.util

import android.util.Patterns

fun CharSequence?.isNotValidEmail() =
    isNullOrEmpty() || !Patterns.EMAIL_ADDRESS.matcher(this).matches()