package com.dinesh.android.kotlin.app.user_interface

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View
import android.widget.ProgressBar
class CustomProgressBar @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = android.R.attr.progressBarStyleHorizontal
) : ProgressBar(context, attrs, defStyleAttr) {

    private var mPaint: Paint = Paint()
    private var mRectF: RectF = RectF()
    private var mRadius: Float = 0.toFloat()
    private var mRectWidth: Float = 0.toFloat()

    init {
        mPaint.isAntiAlias = true
        mPaint.style = Paint.Style.STROKE
        mPaint.color = Color.BLUE
        mPaint.strokeWidth = 5f
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        mRectF.left = 0f + mPaint.strokeWidth / 2
        mRectF.top = 0f + mPaint.strokeWidth / 2
        mRectF.right = width - mPaint.strokeWidth / 2
        mRectF.bottom = height - mPaint.strokeWidth / 2
        mRadius = (height - mPaint.strokeWidth) / 2
        mRectWidth = (width - height) + mPaint.strokeWidth
        canvas.drawRoundRect(mRectF, mRadius, mRadius, mPaint)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val width = View.MeasureSpec.getSize(widthMeasureSpec)
        val height = View.MeasureSpec.getSize(heightMeasureSpec)
        setMeasuredDimension(width, height)
    }
}


/*

        val progressDialog = ProgressDialog(this)
        progressDialog.setMessage("Loading...")
        progressDialog.setCancelable(false)
        progressDialog.progress = 50
        progressDialog.show()


 */