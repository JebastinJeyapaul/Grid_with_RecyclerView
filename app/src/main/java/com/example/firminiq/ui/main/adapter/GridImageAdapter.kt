package com.example.firminiq.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.widget.ImageViewCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.firminiq.R
import com.example.firminiq.ui.main.model.GridItem
import com.example.firminiq.ui.main.view.MainFragment

class GridImageAdapter(private val gridItemClickListener: GridItemClickListener): RecyclerView.Adapter<GridImageAdapter.ViewHolder>() {

    private var gridItem: List<GridItem> = arrayListOf()
    fun setGridItem(gridItem: List<GridItem>) {
        this.gridItem = gridItem
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.grid_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(gridItem[position], gridItemClickListener)
    }

    override fun getItemCount(): Int {
        return gridItem.size
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bindItems(item: GridItem, gridItemClickListener: GridItemClickListener) {
            val gridItemTitle = itemView.findViewById(R.id.gridItemText) as TextView
            gridItemTitle.text = item.imageName

            val gridItemImage = itemView.findViewById(R.id.gridItemImage) as AppCompatImageView
            gridItemImage.setImageResource(item.imageId)
            gridItemImage.setOnClickListener { gridItemClickListener.onGridItemClicked(item.imageId, item.imageName) }
        }
    }

    interface GridItemClickListener{
        fun onGridItemClicked(imageId: Int, imageTitle: String)
    }
}