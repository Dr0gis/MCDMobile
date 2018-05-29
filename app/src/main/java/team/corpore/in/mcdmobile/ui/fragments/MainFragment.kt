package team.corpore.`in`.mcdmobile.ui.fragments

import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import team.corpore.`in`.mcdmobile.R
import team.corpore.`in`.mcdmobile.net.RetrofitClient
import team.corpore.`in`.mcdmobile.net.model.UsedDronesModelResponse
import team.corpore.`in`.mcdmobile.ui.activites.BarcodeReaderActivity
import team.corpore.`in`.mcdmobile.ui.activites.DroneMovementActivity
import team.corpore.`in`.mcdmobile.ui.adapters.UsedDronesRecyclerAdapter
import team.corpore.`in`.mcdmobile.utils.SharedUtils

class MainFragment : MainBaseFragment() {

    var usedDronesRecyclerAdapter : UsedDronesRecyclerAdapter? = null
    val usedDronesList = ArrayList<UsedDronesModelResponse>()

    override fun getViewId() = R.layout.fragment_main

    override fun onResume() {
        super.onResume()

        RetrofitClient.getInstance().getService().getUsedDrones(SharedUtils.getToken()).enqueue(object: Callback<ArrayList<UsedDronesModelResponse>> {
            override fun onFailure(call: Call<ArrayList<UsedDronesModelResponse>>, t: Throwable) {
                Toast.makeText(context, t.message, Toast.LENGTH_SHORT).show()
            }
            override fun onResponse(call: Call<ArrayList<UsedDronesModelResponse>>, response: Response<ArrayList<UsedDronesModelResponse>>) {
                if (response.isSuccessful) {
                    usedDronesRecyclerAdapter!!.setData(response.body()!!)
                }
                else {
                    Toast.makeText(context, response.message() + " | " + response.errorBody()!!.string() + " | ", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }

    override fun init() {
        usedDronesRecyclerAdapter = UsedDronesRecyclerAdapter(usedDronesList, object : UsedDronesRecyclerAdapter.DroneListener {
            override fun onDroneClick(position: Int) {
                DroneMovementActivity.openActivity(context!!, usedDronesList[position].idDroneActivation)
            }
        })
        usedDronesRV.adapter = usedDronesRecyclerAdapter

        activateDroneACB.setOnClickListener {
            BarcodeReaderActivity.openActivity(context!!)
        }
    }
}