package peruapps.movies.ui.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import peruapps.movies.R

class ListMoviesAdapter : RecyclerView.Adapter<ListMoviesAdapter.ListMoviesViewHolder>() {

    inner class ListMoviesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ListMoviesViewHolder (
        LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
    )
    override fun getItemCount() = 10

    override fun onBindViewHolder(holder: ListMoviesViewHolder, position: Int) {
        //TODO("Not yet implemented")
    }
}