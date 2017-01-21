package com.library.beeloadingview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.view.View;

/**
 * Created by xiangcheng on 17/1/16.
 */

public class BeeView extends View {

    private static final int DEFAULT_POLYGON = 6;
    private Path mPath;
    private PointF[] mPoint;
    //用最长的宽来表示view的宽度，从第六个点到第三个点
    private float size = 170.0f;
    private Paint mPaint;

    private int color = Color.parseColor("#E91E63");

    public void setColor(int color) {
        this.color = color;
        mPaint.setColor(color);
        invalidate();
    }

    public BeeView(Context context) {
        super(context);
        init();
    }

    public BeeView(Context context, float size) {
        super(context);
        this.size = size;
        init();
    }

    private void init() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(color);
        mPaint.setStrokeWidth(4);
        mPaint.setStyle(Paint.Style.FILL);
        mPath = new Path();
        mPoint = new PointF[DEFAULT_POLYGON];
        //这里的0.866约等于2分之根号3
        mPoint[0] = new PointF(size / 4, 0);
        mPoint[1] = new PointF(size * 3 / 4, 0);
        mPoint[2] = new PointF(size, size * 0.866f / 2);
        mPoint[3] = new PointF(size * 3 / 4, size * 0.866f);
        mPoint[4] = new PointF(size / 4, size * 0.866f);
        mPoint[5] = new PointF(0, size * 0.866f / 2);
        mPath.moveTo(mPoint[0].x, mPoint[0].y);
        mPath.lineTo(mPoint[1].x, mPoint[1].y);
        mPath.lineTo(mPoint[2].x, mPoint[2].y);
        mPath.lineTo(mPoint[3].x, mPoint[3].y);
        mPath.lineTo(mPoint[4].x, mPoint[4].y);
        mPath.lineTo(mPoint[5].x, mPoint[5].y);
        mPath.lineTo(mPoint[0].x, mPoint[0].y);
        mPath.close();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(mPath, mPaint);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension((int) getItemWidth(), (int) getItemWidth());
    }

    public float getItemWidth() {
        return mPoint[2].x;
    }
}
