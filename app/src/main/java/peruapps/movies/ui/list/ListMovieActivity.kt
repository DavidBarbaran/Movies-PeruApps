package peruapps.movies.ui.list

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_list_movie.*
import peruapps.movies.R

class ListMovieActivity : AppCompatActivity() {

    private var loading = true
    var pastVisiblesItems = 0
    var visibleItemCount:Int = 0
    var totalItemCount:Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_movie)

        val snapHelper = PagerSnapHelper()
        snapHelper.attachToRecyclerView(moviesRecycler)

        val adapter = ListMoviesAdapter()
        moviesRecycler.adapter = adapter

        moviesRecycler.addOnScrollListener(object : RecyclerView.OnScrollListener() {

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
               // super.onScrolled(recyclerView, dx, dy)
                val mLayoutManager = recyclerView.layoutManager as LinearLayoutManager
                if(dx > 0)
                {
                    visibleItemCount = mLayoutManager.childCount;
                    totalItemCount = mLayoutManager.itemCount;
                    pastVisiblesItems = mLayoutManager.findLastCompletelyVisibleItemPosition();
                    Log.e("DATA_SCROLL", "$visibleItemCount - $totalItemCount - $pastVisiblesItems")

                    if (loading)
                    {
                        if ( pastVisiblesItems + 1 >= totalItemCount)
                        {
                            //loading = false;
                            Log.e("END_SCROLL", "TRUE")
                            //Do pagination.. i.e. fetch new data
                        }
                    }
                }


            }
        })
    }
}