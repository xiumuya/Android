package cn.itcast.specialeffect;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
public class TranslateView extends View {
    public TranslateView(Context context) {
        super(context);
    }
    public TranslateView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    public TranslateView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        Bitmap bitmap = BitmapFactory.decodeResource(this.getResources(),
                R.drawable.husky);
        Matrix matrix = new Matrix();
        matrix.setTranslate(100,100);
        canvas.drawBitmap(bitmap, matrix, paint);
    }
}
