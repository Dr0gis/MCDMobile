package team.corpore.`in`.mcdmobile.ui.activites

import android.content.Context
import android.content.Intent
import android.widget.Toast
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.android.synthetic.main.activity_drone_movement.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import team.corpore.`in`.mcdmobile.R
import team.corpore.`in`.mcdmobile.net.RetrofitClient
import team.corpore.`in`.mcdmobile.net.model.DroneMovementModelResponse
import team.corpore.`in`.mcdmobile.net.model.UsedDronesModelResponse
import team.corpore.`in`.mcdmobile.utils.Constants
import team.corpore.`in`.mcdmobile.utils.SharedUtils
import java.util.*

class DroneMovementActivity : BaseActivity(), OnMapReadyCallback {
    companion object {
        fun openActivity(context: Context, idDrone: Int) {
            val intent = Intent(context, DroneMovementActivity::class.java)
            intent.putExtra(Constants.ID_DRONE_ACTIVATION, idDrone)
            context.startActivity(intent)
        }
    }

    private var idDroneActivation : Int? = null
    private lateinit var map: GoogleMap

    override fun getViewId() = R.layout.activity_drone_movement

    override fun init() {
        getDataFromIntent()

        (mapF as SupportMapFragment).getMapAsync(this)

        /*val droneMovementsList = ArrayList<DroneMovementModelResponse>()
        droneMovementsList.add(DroneMovementModelResponse(1, 1, Date(), 0, 0, 0))
        droneMovementsList.add(DroneMovementModelResponse(1, 1, Date(), 0, 1, 0))
        droneMovementsList.add(DroneMovementModelResponse(1, 1, Date(), 1, 1, 0))
        droneMovementsList.add(DroneMovementModelResponse(1, 1, Date(), 1, 2, 0))
        droneMovementsList.add(DroneMovementModelResponse(1, 1, Date(), 1, 3, 0))
        droneMovementsList.add(DroneMovementModelResponse(1, 1, Date(), 2, 3, 0))
        droneMovementsList.add(DroneMovementModelResponse(1, 1, Date(), 3, 3, 0))*/

        RetrofitClient.getInstance().getService().getDroneMovements(SharedUtils.getToken(), idDroneActivation!!).enqueue(object: Callback<ArrayList<DroneMovementModelResponse>> {
            override fun onFailure(call: Call<ArrayList<DroneMovementModelResponse>>, t: Throwable) {
                Toast.makeText(this@DroneMovementActivity, t.message, Toast.LENGTH_SHORT).show()
            }
            override fun onResponse(call: Call<ArrayList<DroneMovementModelResponse>>, response: Response<ArrayList<DroneMovementModelResponse>>) {
                if (response.isSuccessful) {
                    wayDroneDMV.setData(response.body()!!)
                }
                else {
                    Toast.makeText(this@DroneMovementActivity, response.message() + " | " + response.errorBody()!!.string() + " | ", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }

    override fun onOpenKeyboard() {

    }

    override fun onHideKeyboard() {

    }

    private fun getDataFromIntent() {
        idDroneActivation = intent.extras.getInt(Constants.ID_DRONE_ACTIVATION)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap
    }
}