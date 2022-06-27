package com.example.siriofsociety.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.siriofsociety.R

class ExplorerAdapter(private var mListener: onItemClickListener): RecyclerView.Adapter<ExplorerAdapter.ViewHolder>() {
    val titles = arrayOf("Table", "Chair", "Sofa", "Armchair", "Desk")
    val images = arrayOf(R.drawable.ic_table, R.drawable.ic_chair, R.drawable.ic_sofa, R.drawable.ic_bed, R.drawable.ic_desk)

/*    private lateinit var mListener : onItemClickListener*/

    interface onItemClickListener {
        fun onItemClick(position : Int)
    }

    fun setOnItemClickListener(listener: onItemClickListener) {
        mListener = listener
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context).inflate(R.layout.explorer_categories_list_item, viewGroup, false)
        return ViewHolder(v, mListener)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.explorerTitle.text = titles[i]
        viewHolder.explorerImage.setImageResource(images[i])
    }

    override fun getItemCount(): Int {
        return titles.size
    }
    inner class ViewHolder(itemView: View, listener: onItemClickListener): RecyclerView.ViewHolder(itemView) {
        var explorerImage: ImageView
        var explorerTitle: TextView

        init {
            explorerImage = itemView.findViewById(R.id.explorer_image)
            explorerTitle = itemView.findViewById(R.id.explorer_title)
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }
    }
}