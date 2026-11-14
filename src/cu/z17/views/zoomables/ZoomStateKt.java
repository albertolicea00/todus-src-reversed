package cu.z17.views.zoomables;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.y;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0002\u001ai\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rH\u0007¢\u0006\u0002\u0010\u000e\u001aq\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\rH\u0007¢\u0006\u0002\u0010\u0010\u001au\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\b2\u0016\u0010\u0011\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\r0\u0012\"\u0004\u0018\u00010\rH\u0007¢\u0006\u0002\u0010\u0013¨\u0006\u0014"}, d2 = {"rememberZoomState", "Lcu/z17/views/zoomables/ZoomState;", "initialZoom", "", "initialRotation", "minZoom", "maxZoom", "zoomable", "", "pannable", "rotatable", "limitPan", "key1", "", "(FFFFZZZZLjava/lang/Object;Landroidx/compose/runtime/Composer;II)Lcu/z17/views/zoomables/ZoomState;", "key2", "(FFFFZZZZLjava/lang/Object;Ljava/lang/Object;Landroidx/compose/runtime/Composer;II)Lcu/z17/views/zoomables/ZoomState;", "keys", "", "(FFFFZZZZ[Ljava/lang/Object;Landroidx/compose/runtime/Composer;II)Lcu/z17/views/zoomables/ZoomState;", "views_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ZoomStateKt {
    @Composable
    public static final ZoomState rememberZoomState(float f10, float f11, float f12, float f13, boolean z10, boolean z11, boolean z12, boolean z13, Object obj, Composer composer, int i10, int i11) {
        if ((i11 & 1) != 0) {
            f10 = 1.0f;
        }
        if ((i11 & 2) != 0) {
            f11 = 0.0f;
        }
        if ((i11 & 4) != 0) {
            f12 = 1.0f;
        }
        if ((i11 & 8) != 0) {
            f13 = 5.0f;
        }
        if ((i11 & 16) != 0) {
            z10 = true;
        }
        if ((i11 & 32) != 0) {
            z11 = true;
        }
        if ((i11 & 64) != 0) {
            z12 = false;
        }
        if ((i11 & 128) != 0) {
            z13 = false;
        }
        if ((i11 & 256) != 0) {
            obj = k0.f43947a;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1664204549, i10, -1, "cu.z17.views.zoomables.rememberZoomState (ZoomState.kt:34)");
        }
        boolean zChanged = composer.changed(obj);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            boolean z14 = z13;
            boolean z15 = z12;
            boolean z16 = z11;
            boolean z17 = z10;
            float f14 = f13;
            ZoomState zoomState = new ZoomState(f10, f11, f12, f14, z17, z16, z15, z14);
            composer.updateRememberedValue(zoomState);
            objRememberedValue = zoomState;
        }
        ZoomState zoomState2 = (ZoomState) objRememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return zoomState2;
    }

    @Composable
    public static final ZoomState rememberZoomState(float f10, float f11, float f12, float f13, boolean z10, boolean z11, boolean z12, boolean z13, Object obj, Object obj2, Composer composer, int i10, int i11) {
        if ((i11 & 1) != 0) {
            f10 = 1.0f;
        }
        if ((i11 & 2) != 0) {
            f11 = 0.0f;
        }
        if ((i11 & 4) != 0) {
            f12 = 1.0f;
        }
        if ((i11 & 8) != 0) {
            f13 = 5.0f;
        }
        if ((i11 & 16) != 0) {
            z10 = true;
        }
        if ((i11 & 32) != 0) {
            z11 = true;
        }
        if ((i11 & 64) != 0) {
            z12 = false;
        }
        if ((i11 & 128) != 0) {
            z13 = false;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-546644389, i10, -1, "cu.z17.views.zoomables.rememberZoomState (ZoomState.kt:79)");
        }
        boolean zChanged = composer.changed(obj) | composer.changed(obj2);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            boolean z14 = z13;
            boolean z15 = z12;
            boolean z16 = z11;
            boolean z17 = z10;
            float f14 = f13;
            ZoomState zoomState = new ZoomState(f10, f11, f12, f14, z17, z16, z15, z14);
            composer.updateRememberedValue(zoomState);
            objRememberedValue = zoomState;
        }
        ZoomState zoomState2 = (ZoomState) objRememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return zoomState2;
    }

    @Composable
    public static final ZoomState rememberZoomState(float f10, float f11, float f12, float f13, boolean z10, boolean z11, boolean z12, boolean z13, Object[] keys, Composer composer, int i10, int i11) {
        y.i(keys, "keys");
        if ((i11 & 1) != 0) {
            f10 = 1.0f;
        }
        if ((i11 & 2) != 0) {
            f11 = 0.0f;
        }
        if ((i11 & 4) != 0) {
            f12 = 1.0f;
        }
        if ((i11 & 8) != 0) {
            f13 = 5.0f;
        }
        if ((i11 & 16) != 0) {
            z10 = true;
        }
        if ((i11 & 32) != 0) {
            z11 = true;
        }
        if ((i11 & 64) != 0) {
            z12 = false;
        }
        if ((i11 & 128) != 0) {
            z13 = false;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-285548370, i10, -1, "cu.z17.views.zoomables.rememberZoomState (ZoomState.kt:122)");
        }
        boolean zChanged = false;
        for (Object obj : Arrays.copyOf(keys, keys.length)) {
            zChanged |= composer.changed(obj);
        }
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            boolean z14 = z13;
            boolean z15 = z12;
            boolean z16 = z11;
            boolean z17 = z10;
            ZoomState zoomState = new ZoomState(f10, f11, f12, f13, z17, z16, z15, z14);
            composer.updateRememberedValue(zoomState);
            objRememberedValue = zoomState;
        }
        ZoomState zoomState2 = (ZoomState) objRememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return zoomState2;
    }
}
