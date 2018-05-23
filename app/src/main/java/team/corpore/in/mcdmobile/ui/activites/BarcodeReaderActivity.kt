package team.corpore.`in`.mcdmobile.ui.activites

import android.content.Context
import android.content.Intent
import android.util.Log
import android.util.SparseArray
import android.widget.Toast
import com.google.android.gms.vision.barcode.Barcode
import info.androidhive.barcode.BarcodeReader
import kotlinx.android.synthetic.main.activity_barcode_reader.*
import team.corpore.`in`.mcdmobile.R

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
        ControlDroneActivity.openActivity(this, barcode.displayValue)
    }

    override fun onScanError(errorMessage: String) {
        Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show()
    }
}