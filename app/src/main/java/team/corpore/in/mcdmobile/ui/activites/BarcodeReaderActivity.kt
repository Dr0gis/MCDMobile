package team.corpore.`in`.mcdmobile.ui.activites

import android.content.Context
import android.content.Intent
import android.util.SparseArray
import android.widget.Toast
import com.google.android.gms.vision.barcode.Barcode
import info.androidhive.barcode.BarcodeReader
import kotlinx.android.synthetic.main.activity_barcode_reader.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import team.corpore.`in`.mcdmobile.R
import team.corpore.`in`.mcdmobile.net.RetrofitClient
import team.corpore.`in`.mcdmobile.net.model.ActivateDroneRequest
import team.corpore.`in`.mcdmobile.utils.SharedUtils

class BarcodeReaderActivity : BaseActivity(), BarcodeReader.BarcodeReaderListener {
    companion object {
        fun openActivity(context: Context) {
            val intent = Intent(context, BarcodeReaderActivity::class.java)
            context.startActivity(intent)
        }
    }

    private var barcodeReader: BarcodeReader? = null

    override fun getViewId(): Int = R.layout.activity_barcode_reader

    override fun init() {
        barcodeReader = barcodeScannerF as BarcodeReader
    }

    override fun onOpenKeyboard() {

    }

    override fun onHideKeyboard() {

    }

    override fun onBitmapScanned(sparseArray: SparseArray<Barcode>) {

    }

    override fun onScannedMultiple(barcodes: MutableList<Barcode>) {

    }

    override fun onCameraPermissionDenied() {
        finish()
    }

    override fun onScanned(barcode: Barcode) {
        RetrofitClient.getInstance().getService().activateDrone(ActivateDroneRequest(SharedUtils.getToken(), barcode.displayValue)).enqueue(object: Callback<Void> {
            override fun onFailure(call: Call<Void>, t: Throwable) {
                Toast.makeText(this@BarcodeReaderActivity, t.message, Toast.LENGTH_SHORT).show()
            }
            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                if (response.isSuccessful) {
                    ControlDroneActivity.openActivity(this@BarcodeReaderActivity, barcode.displayValue)
                }
                else {
                    Toast.makeText(this@BarcodeReaderActivity, response.message() + " | " + response.errorBody()!!.string() + " | ", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }

    override fun onScanError(errorMessage: String) {
        Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show()
    }
}