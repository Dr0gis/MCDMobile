package team.corpore.`in`.mcdmobile.ui.fragments

import kotlinx.android.synthetic.main.fragment_main.*
import team.corpore.`in`.mcdmobile.R
import team.corpore.`in`.mcdmobile.ui.activites.BarcodeReaderActivity
import team.corpore.`in`.mcdmobile.ui.adapters.UsedDronesRecyclerAdapter

class MainFragment : MainBaseFragment() {

    override fun getViewId(): Int = R.layout.fragment_main

    override fun init() {
        val usedDronesList = ArrayList<String>()
        usedDronesList.add("item 1")
        usedDronesList.add("item 2")
        usedDronesList.add("item 3")
        usedDronesList.add("item 4")
        usedDronesList.add("item 5")

        usedDronesRV.adapter = UsedDronesRecyclerAdapter(usedDronesList, object : UsedDronesRecyclerAdapter.DroneListener {
            override fun onDroneClick(position: Int) {

            }
        })

        activateDroneACB.setOnClickListener {
            BarcodeReaderActivity.openActivity(context!!)
        }
    }
}