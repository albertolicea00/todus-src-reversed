package cu.z17.views.map;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.jvm.internal.y;
import org.osmdroid.views.MapView;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes7.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B!\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ'\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0016R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001b\u001a\u00020\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001d\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"Lcu/z17/views/map/AccuracyOverlay;", "Lorg/osmdroid/views/overlay/d;", "Lbi/d;", "location", "", "accuracyInMeters", "", "accuracyColor", "<init>", "(Lbi/d;FI)V", "Lorg/osmdroid/views/MapView;", "view", "Lua/k0;", "onDetach", "(Lorg/osmdroid/views/MapView;)V", "Landroid/graphics/Canvas;", "c", "map", "", "shadow", "draw", "(Landroid/graphics/Canvas;Lorg/osmdroid/views/MapView;Z)V", "Lbi/d;", "Landroid/graphics/Paint;", "accuracyPaint", "Landroid/graphics/Paint;", "Landroid/graphics/Point;", "screenCoords", "Landroid/graphics/Point;", "accuracy", "F", "views_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AccuracyOverlay extends org.osmdroid.views.overlay.d {
    public static final int $stable = 8;
    private float accuracy;
    private final bi.d location;
    private Paint accuracyPaint = new Paint();
    private final Point screenCoords = new Point();

    public AccuracyOverlay(bi.d dVar, float f10, int i10) {
        this.location = dVar;
        this.accuracy = f10;
        Paint paint = this.accuracyPaint;
        y.f(paint);
        paint.setStrokeWidth(2.0f);
        Paint paint2 = this.accuracyPaint;
        y.f(paint2);
        paint2.setColor(i10);
        Paint paint3 = this.accuracyPaint;
        y.f(paint3);
        paint3.setAntiAlias(true);
    }

    @Override // org.osmdroid.views.overlay.d
    public void draw(Canvas c10, MapView map, boolean shadow) {
        y.i(c10, "c");
        y.i(map, "map");
        if (shadow || this.location == null) {
            return;
        }
        ci.c cVarM10367getProjection = map.m10367getProjection();
        cVarM10367getProjection.M(this.location, this.screenCoords);
        float f10 = this.accuracy;
        if (f10 > 0.0f) {
            float fE = cVarM10367getProjection.E(f10);
            Paint paint = this.accuracyPaint;
            y.f(paint);
            paint.setAntiAlias(false);
            Paint paint2 = this.accuracyPaint;
            y.f(paint2);
            paint2.setAlpha(30);
            Paint paint3 = this.accuracyPaint;
            y.f(paint3);
            paint3.setStyle(Paint.Style.FILL);
            Point point = this.screenCoords;
            float f11 = point.x;
            float f12 = point.y;
            Paint paint4 = this.accuracyPaint;
            y.f(paint4);
            c10.drawCircle(f11, f12, fE, paint4);
            Paint paint5 = this.accuracyPaint;
            y.f(paint5);
            paint5.setAntiAlias(true);
            Paint paint6 = this.accuracyPaint;
            y.f(paint6);
            paint6.setAlpha(150);
            Paint paint7 = this.accuracyPaint;
            y.f(paint7);
            paint7.setStyle(Paint.Style.STROKE);
            Point point2 = this.screenCoords;
            float f13 = point2.x;
            float f14 = point2.y;
            Paint paint8 = this.accuracyPaint;
            y.f(paint8);
            c10.drawCircle(f13, f14, fE, paint8);
        }
    }

    @Override // org.osmdroid.views.overlay.d
    public void onDetach(MapView view) {
        this.accuracyPaint = null;
    }
}
