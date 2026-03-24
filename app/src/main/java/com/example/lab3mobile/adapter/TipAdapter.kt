package com.example.lab3mobile.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.lab3mobile.R
import com.example.lab3mobile.model.Tip

class TipAdapter(
    private val tips: List<Tip>,
    private val layoutManagerType: Int
) : RecyclerView.Adapter<TipAdapter.TipViewHolder>() {

    companion object {
        const val LAYOUT_MANAGER_VERTICAL = 1
        const val LAYOUT_MANAGER_HORIZONTAL = 2
        const val LAYOUT_MANAGER_GRID = 3
    }

    class TipViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cardView: CardView = itemView.findViewById(R.id.cardView)
        val ivTipImage: ImageView = itemView.findViewById(R.id.ivTipImage)
        val tvDay: TextView = itemView.findViewById(R.id.tvDay)
        val tvTitle: TextView = itemView.findViewById(R.id.tvTitle)
        val tvDescription: TextView = itemView.findViewById(R.id.tvDescription)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TipViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_tip, parent, false)
        return TipViewHolder(view)
    }

    override fun onBindViewHolder(holder: TipViewHolder, position: Int) {
        val tip = tips[position]

        holder.tvDay.text = "День ${tip.day}"
        holder.tvTitle.text = tip.title
        holder.tvDescription.text = tip.description
        holder.ivTipImage.setImageResource(tip.imageResId)

        val layoutParams = holder.cardView.layoutParams
        when (layoutManagerType) {
            LAYOUT_MANAGER_HORIZONTAL -> {
                layoutParams.width = 400
                layoutParams.height = ViewGroup.LayoutParams.WRAP_CONTENT
            }
            LAYOUT_MANAGER_GRID -> {
                layoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT
                layoutParams.height = ViewGroup.LayoutParams.WRAP_CONTENT
            }
        }
        holder.cardView.layoutParams = layoutParams
    }

    override fun getItemCount() = tips.size
}