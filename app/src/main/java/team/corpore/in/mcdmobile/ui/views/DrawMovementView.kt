package team.corpore.`in`.mcdmobile.ui.views

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.support.v4.content.ContextCompat
import android.util.AttributeSet
import android.view.View
import team.corpore.`in`.mcdmobile.R
import team.corpore.`in`.mcdmobile.net.model.DroneMovementModelResponse
import team.corpore.`in`.mcdmobile.utils.DeviceDimensionsHelper

class DrawMovementView : View {

    private val drawPaint = Paint()
    private val countZoneX = 8
    private val countZoneY = 8
    private val droneMovementsList = ArrayList<DroneMovementModelResponse>()

    constructor(context: Context) : this(context, null) {

    }
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0) {

    }
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init()
    }

    private fun init() {
        setupPaint()
    }

    fun setData(droneMovementsList: ArrayList<DroneMovementModelResponse>) {
        this.droneMovementsList.clear()
        this.droneMovementsList.addAll(droneMovementsList)
        postInvalidate()
    }

    private fun setupPaint() {
        drawPaint.isAntiAlias = true
        drawPaint.style = Paint.Style.STROKE
    }

    private fun setBlueColor() {
        drawPaint.color = ContextCompat.getColor(context, R.color.color_blue)
        val strokeWidth = DeviceDimensionsHelper.convertDpToPixel(dp = 2f, context = context)
        drawPaint.strokeWidth = strokeWidth
    }
    private fun setGreyColor() {
        drawPaint.color = ContextCompat.getColor(context, R.color.color_separator)
        val strokeWidth = DeviceDimensionsHelper.convertDpToPixel(dp = 1f, context = context)
        drawPaint.strokeWidth = strokeWidth
    }

    override fun onDraw(canvas: Canvas) {
        drawBrackets(canvas)
        drawLines(canvas)
    }

    private fun drawBrackets(canvas: Canvas) {
        setGreyColor()
        val widthInPx = width
        val heightInPx = height

        for (i in 1 until countZoneX) {
            val startX = (widthInPx / countZoneX).toFloat() * i
            val startY = 0f
            val stopX = (widthInPx / countZoneX).toFloat() * i
            val stopY =  heightInPx.toFloat()
            canvas.drawLine(startX, startY, stopX, stopY, drawPaint)
        }
        for (i in 1 until countZoneY) {
            val startX = 0f
            val startY = (heightInPx / countZoneX).toFloat() * i
            val stopX = widthInPx.toFloat()
            val stopY =  (heightInPx / countZoneX).toFloat() * i
            canvas.drawLine(startX, startY, stopX, stopY, drawPaint)
        }
    }

    private fun drawLines(canvas: Canvas) {
        setBlueColor()

        val widthInPx = width
        val heightInPx = height

        var i = 1
        while (i < droneMovementsList.size - 1) {
            val startX = (widthInPx / countZoneX * (droneMovementsList[i].x + 1) - (widthInPx / countZoneX / 2)).toFloat()
            val startY = (heightInPx / countZoneY * (droneMovementsList[i].y + 1)  - (heightInPx / countZoneY / 2)).toFloat()
            val stopX = (widthInPx / countZoneX * (droneMovementsList[i + 1].x + 1) - (widthInPx / countZoneX / 2)).toFloat()
            val stopY = (heightInPx / countZoneY * (droneMovementsList[i + 1].y + 1)  - (heightInPx / countZoneY / 2)).toFloat()
            canvas.drawLine(startX, startY, stopX, stopY, drawPaint)
            ++i
        }
    }
}