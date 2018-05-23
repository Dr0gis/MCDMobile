package team.corpore.`in`.mcdmobile.ui.activites

import android.content.Context
import android.content.Intent
import team.corpore.`in`.mcdmobile.R
import team.corpore.`in`.mcdmobile.utils.Constants

class ControlDroneActivity : BaseActivity() {
    companion object {
        fun openActivity(context: Context, qrCodeDrone: String) {
            val intent = Intent(context, ControlDroneActivity::class.java)
            intent.putExtra(Constants.QRCODE_DRONE, qrCodeDrone)
            context.startActivity(intent)
        }
    }

    var qrCodeDrone: String? = null

    override fun getViewId() = R.layout.activity_control_drone

    override fun init() {
        qrCodeDrone = intent.extras.getString(Constants.QRCODE_DRONE)
    }

    override fun onOpenKeyboard() {

    }

    override fun onHideKeyboard() {

    }
}