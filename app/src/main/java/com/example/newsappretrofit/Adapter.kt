package com.example.newsappretrofit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.newsappretrofit.model.News
import com.example.newsappretrofit.model.Results
import com.squareup.picasso.Picasso
import org.w3c.dom.Text

class Adapter (list : List<News>) : RecyclerView.Adapter<Adapter.ViewHolder>() {
    var list : List<News>
    init {
        this.list=list
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var title = itemView.findViewById<TextView>(R.id.newsTitle)
        var description = itemView.findViewById<TextView>(R.id.newsDescription)
        var image = itemView.findViewById<ImageView>(R.id.newsImage)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_news,parent,false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title.setText(list.get(position).title)
        holder.description.setText(list.get(position).description)
        if(list[position].image_url != null){
            Picasso.get()
                .load(list[position].image_url)
                .resize(800, 800)
                .centerCrop()
                .into(holder.image)
        } else {
            Picasso.get()
                .load("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTN0neuoQP1nuyt-TtkqkLsaZQQHGHgIz1TDkiShd10UA&s")
                .into(holder.image)
        }

    }
}