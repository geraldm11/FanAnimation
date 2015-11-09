package com.example.gerald.fananimation;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;

/**
 * Created by gerald on 11/9/2015.
 */
public class FanAnimation extends View {
    private final String TAG = getClass().getSimpleName();
    private final boolean D = Log.isLoggable(TAG, Log.DEBUG);

    private int mDesiredWidth = 400;
    private int mDesiredHeight = 400;

    private Bitmap mPole;
    private Bitmap mRotor;
    private Paint mTurbine;
    public  static float mSpeed = 0f;
    private float mRotation = 359f;
    private Context mContext;

    public FanAnimation(Context context) {
        super(context);
        if (D) {
            Log.v(TAG, "FanAnimation :context :" + context);
        }
        mContext = context;
        init();
    }

    public FanAnimation(Context context, AttributeSet attrs) {
        super(context, attrs);
        if (D) {
            Log.v(TAG, "FanAnimation :context :" + context + "attrs:" + attrs);
        }
        mContext = context;
        init();
    }

    public FanAnimation(Context context, AttributeSet attrs, int defaultStyle) {
        super(context, attrs, defaultStyle);
        if (D) {
            Log.v(TAG, "FanAnimation :context :" + context + "attrs:" + attrs + "defaultStyle: " + defaultStyle);
        }
        mContext = context;
        init();
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent event) {
        if (D) {
            Log.v(TAG, "dispatchPopulateAccessibilityEvent: event:" + event);
        }
        event.getText().add("fast");
        return true;
    }

    private void init() {
        if (D) {
            Log.v(TAG, "init");
        }
        mPole = BitmapFactory.decodeResource(getResources(), R.drawable.body);
        mRotor = BitmapFactory.decodeResource(getResources(), R.drawable.azul);

        mTurbine = new Paint(Paint.ANTI_ALIAS_FLAG);
        mTurbine.setStyle(Paint.Style.FILL);

        mDesiredWidth = Math.max(mPole.getWidth(), mRotor.getWidth()) + 50;
        mDesiredHeight = Math.max(mPole.getHeight(), mRotor.getWidth()) + 40;

        AccessibilityManager accessibilityManager = (AccessibilityManager) mContext.getSystemService(Context.ACCESSIBILITY_SERVICE);
        if (accessibilityManager.isEnabled()) {
            sendAccessibilityEvent(AccessibilityEvent.TYPE_VIEW_TEXT_CHANGED);
        }

    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int x = 0;
        int y = 0;
        canvas.drawBitmap(mPole, x, mRotor.getHeight() / 2, mTurbine);
        canvas.drawBitmap(mRotor, rotate(mRotor, x, y), mTurbine);
        canvas.drawBitmap(mRotor, rotate(mRotor, x, y), mTurbine);
        invalidate();

    }

    public Matrix rotate(Bitmap bm, int x, int y) {
        Matrix mtx = new Matrix();
        mtx.postRotate(mRotation, bm.getWidth()/2 , bm.getHeight() / 2);
        mtx.postTranslate(120,200);
        mRotation -= mSpeed;
        return mtx;
    }

}






