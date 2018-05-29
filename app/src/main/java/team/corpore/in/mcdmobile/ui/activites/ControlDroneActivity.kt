package team.corpore.`in`.mcdmobile.ui.activites

import android.content.Context
import android.content.Intent
import com.obd.infrared.InfraRed
import com.obd.infrared.log.LogToConsole
import com.obd.infrared.patterns.PatternAdapter
import com.obd.infrared.patterns.PatternConverter
import com.obd.infrared.patterns.PatternType
import com.obd.infrared.transmit.TransmitInfo
import kotlinx.android.synthetic.main.activity_control_drone.*
import team.corpore.`in`.mcdmobile.R
import team.corpore.`in`.mcdmobile.utils.Constants

class ControlDroneActivity : BaseActivity() {
    companion object {
        fun openActivity(context: Context, qrCodeDrone: String) {
            val intent = Intent(context, ControlDroneActivity::class.java)
            intent.putExtra(Constants.QRCODE_DRONE, qrCodeDrone)
            context.startActivity(intent)
        }

        private val TAG = ControlDroneActivity::class.java.simpleName
    }

    private var qrCodeDrone: String? = null
    private var infraRed: InfraRed? = null
    private var patterns: Array<TransmitInfo>? = null
    private val topIndex = 0
    private val bottomIndex = 1
    private val leftIndex = 2
    private val forwardIndex = 3
    private val rightIndex = 4
    private val backIndex = 5
    private val disableIndex = 6

    override fun getViewId() = R.layout.activity_control_drone

    override fun init() {
        qrCodeDrone = intent.extras.getString(Constants.QRCODE_DRONE)

        initRi()

        moveTopACB.setOnClickListener {
            val transmitInfo: TransmitInfo = patterns!![topIndex]
            infraRed!!.transmit(transmitInfo)
        }
        moveBottomACB.setOnClickListener {
            val transmitInfo: TransmitInfo = patterns!![bottomIndex]
            infraRed!!.transmit(transmitInfo)
        }
        moveLeftACB.setOnClickListener {
            val transmitInfo: TransmitInfo = patterns!![leftIndex]
            infraRed!!.transmit(transmitInfo)
        }
        moveForwardACB.setOnClickListener {
            val transmitInfo: TransmitInfo = patterns!![forwardIndex]
            infraRed!!.transmit(transmitInfo)
        }
        moveRightACB.setOnClickListener {
            val transmitInfo: TransmitInfo = patterns!![rightIndex]
            infraRed!!.transmit(transmitInfo)
        }
        moveBackACB.setOnClickListener {
            val transmitInfo: TransmitInfo = patterns!![backIndex]
            infraRed!!.transmit(transmitInfo)
        }
        disableACB.setOnClickListener {
            val transmitInfo: TransmitInfo = patterns!![disableIndex]
            infraRed!!.transmit(transmitInfo)
        }
    }

    fun initRi() {
        val log = LogToConsole(TAG);
        infraRed = InfraRed(this, log)
        val transmitterType = infraRed!!.detect()
        infraRed!!.createTransmitter(transmitterType)

        val rawPatterns = ArrayList<PatternConverter>()
        rawPatterns.add(topIndex, PatternConverter(PatternType.Cycles, 38000,494, 114, 38, 38, 38, 38, 38, 38, 38, 38, 38, 38, 38, 114, 38, 1))
        rawPatterns.add(bottomIndex, PatternConverter(PatternType.Cycles, 38000,23, 494, 214, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 214, 48, 1))
        rawPatterns.add(leftIndex, PatternConverter(PatternType.Cycles, 38000,177, 54, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 54, 18, 18, 123))
        rawPatterns.add(forwardIndex, PatternConverter(PatternType.Cycles, 38000,494, 414, 68, 68, 68, 68, 68, 68, 68, 68, 68, 68, 68, 414, 68, 1, 234))
        rawPatterns.add(rightIndex, PatternConverter(PatternType.Cycles, 38000,99, 494, 514, 78, 78, 78, 78, 78, 78, 100, 78, 78, 78, 78, 514, 78, 12, 345))
        rawPatterns.add(backIndex, PatternConverter(PatternType.Cycles, 38000,494, 614, 88, 88, 88, 88, 88, 88, 88, 88, 88, 88, 614, 38, 21, 56))
        rawPatterns.add(disableIndex, PatternConverter(PatternType.Cycles, 38000,494, 614, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 614, 38, 21, 56))

        val patternAdapter = PatternAdapter(log, transmitterType)

        val transmitInfoArray = Array<TransmitInfo>(rawPatterns.size) {
            patternAdapter.createTransmitInfo(rawPatterns[it])
        }
        this.patterns = transmitInfoArray
    }

    override fun onOpenKeyboard() {

    }

    override fun onHideKeyboard() {

    }

    override fun onResume() {
        super.onResume()
        infraRed!!.start()
    }

    override fun onDestroy() {
        super.onDestroy()

        infraRed!!.stop()
    }
}