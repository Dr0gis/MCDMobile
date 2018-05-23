package team.corpore.`in`.mcdmobile.ui.activites

import android.util.SparseArray
import com.google.android.gms.vision.barcode.Barcode
import info.androidhive.barcode.BarcodeReader
import team.corpore.`in`.mcdmobile.R

class BarcodeReaderActivity : BaseActivity(), BarcodeReader.BarcodeReaderListener {

    override fun getViewId(): Int = R.layout.activity_barcode_reader

    override fun init() {

    }

    override fun onOpenKeyboard() {

    }

    override fun onHideKeyboard() {

    }

    override fun onBitmapScanned(sparseArray: SparseArray<Barcode>?) {

    }

    override fun onScannedMultiple(barcodes: MutableList<Barcode>?) {

    }

    override fun onCameraPermissionDenied() {

    }

    override fun onScanned(barcode: Barcode?) {

    }

    override fun onScanError(errorMessage: String?) {

    }
}