package team.corpore.`in`.mcdmobile.ui.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_used_drones.view.*
import team.corpore.`in`.mcdmobile.R

class UsedDronesRecyclerAdapter(list: ArrayList<String>) : RecyclerView.Adapter<UsedDronesRecyclerAdapter.VH>() {

    private var listDrones = ArrayList<String>()

    init {
        listDrones = list
    }

    fun setData(list: ArrayList<String>) {
        listDrones = list
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_used_drones, parent, false)

        return VH(view)
    }

    override fun getItemCount() = listDrones.size

    override fun onBindViewHolder(holder: VH, position: Int) {
        with (holder.itemView) {
            itemTV.text = listDrones[position]
        }
    }

    inner class VH(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }
}