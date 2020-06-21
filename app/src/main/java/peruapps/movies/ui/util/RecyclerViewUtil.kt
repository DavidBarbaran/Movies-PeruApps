package peruapps.movies.ui.util

import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

inline fun RecyclerView.onEndless(crossinline onEndless: () -> Unit) {

    var pastVisiblesItems: Int
    var visibleItemCount: Int
    var totalItemCount: Int

    addOnScrollListener(object : RecyclerView.OnScrollListener() {
        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            // super.onScrolled(recyclerView, dx, dy)
            val mLayoutManager = recyclerView.layoutManager as LinearLayoutManager
            if (dx > 0) {
                visibleItemCount = mLayoutManager.childCount;
                totalItemCount = mLayoutManager.itemCount;
                pastVisiblesItems = mLayoutManager.findLastCompletelyVisibleItemPosition();
                Log.e("DATA_SCROLL", "$visibleItemCount - $totalItemCount - $pastVisiblesItems")

                if (pastVisiblesItems + 1 >= totalItemCount) {
                    //loading = false;
                    onEndless()
                    Log.e("END_SCROLL", "TRUE")
                    //Do pagination.. i.e. fetch new data
                }
            }
        }
    })
}