package team.corpore.`in`.mcdmobile.ui.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_used_drones.view.*
import team.corpore.`in`.mcdmobile.R
import team.corpore.`in`.mcdmobile.net.model.UsedDronesModelResponse

class UsedDronesRecyclerAdapter(list: ArrayList<UsedDronesModelResponse>, clickListener: DroneListener) : RecyclerView.Adapter<UsedDronesRecyclerAdapter.VH>() {

    interface DroneListener {
        fun onDroneClick(position: Int)
    }

    private var listDrones = ArrayList<UsedDronesModelResponse>()
    private var clickListener: DroneListener

    init {
        this.listDrones = list
        this.clickListener = clickListener
    }

    fun setData(list: ArrayList<UsedDronesModelResponse>) {
        listDrones.clear()
        listDrones.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_used_drones, parent, false)

        return VH(view)
    }

    override fun getItemCount() = listDrones.size

    override fun onBindViewHolder(holder: VH, position: Int) {
        with (holder.itemView) {
            droneNameTV.text = listDrones[position].name
            dateTV.text = listDrones[position].datetime.toString()
        }
    }

    inner class VH(itemView: View) : RecyclerView.ViewHolder(itemView) {

        init {
            with(itemView) {
                setOnClickListener {
                    clickListener.onDroneClick(adapterPosition)
                }
            }
        }

    }
}