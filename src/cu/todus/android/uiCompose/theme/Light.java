package cu.todus.android.uiCompose.theme;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 1)
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0013\u0010\u000b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007R\u0013\u0010\r\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u000e\u0010\u0007R\u0013\u0010\u000f\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0010\u0010\u0007R\u0013\u0010\u0011\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0012\u0010\u0007R\u0013\u0010\u0013\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0014\u0010\u0007R\u0013\u0010\u0015\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0016\u0010\u0007R\u0013\u0010\u0017\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0018\u0010\u0007¨\u0006\u0019"}, d2 = {"Lcu/todus/android/uiCompose/theme/Light;", "", "<init>", "()V", "primary", "Landroidx/compose/ui/graphics/Color;", "getPrimary-0d7_KjU", "()J", "J", "secondary", "getSecondary-0d7_KjU", "surface", "getSurface-0d7_KjU", "onSurface", "getOnSurface-0d7_KjU", "background", "getBackground-0d7_KjU", "onBackground", "getOnBackground-0d7_KjU", "tertiary", "getTertiary-0d7_KjU", "onTertiary", "getOnTertiary-0d7_KjU", "inversePrimary", "getInversePrimary-0d7_KjU", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class Light {
    public static final int $stable = 0;
    public static final Light INSTANCE = new Light();
    private static final long primary = ColorKt.Color(4290190364L);
    private static final long secondary = ColorKt.Color(4286513152L);
    private static final long surface = ColorKt.Color(4293940549L);
    private static final long onSurface = ColorKt.Color(4285887861L);
    private static final long background = Color.INSTANCE.m5903getWhite0d7_KjU();
    private static final long onBackground = ColorKt.Color(4280361249L);
    private static final long tertiary = ColorKt.Color(4287466893L);
    private static final long onTertiary = ColorKt.Color(4293388263L);
    private static final long inversePrimary = ColorKt.Color(4294762718L);

    private Light() {
    }

    /* JADX INFO: renamed from: getBackground-0d7_KjU, reason: not valid java name */
    public final long m10100getBackground0d7_KjU() {
        return background;
    }

    /* JADX INFO: renamed from: getInversePrimary-0d7_KjU, reason: not valid java name */
    public final long m10101getInversePrimary0d7_KjU() {
        return inversePrimary;
    }

    /* JADX INFO: renamed from: getOnBackground-0d7_KjU, reason: not valid java name */
    public final long m10102getOnBackground0d7_KjU() {
        return onBackground;
    }

    /* JADX INFO: renamed from: getOnSurface-0d7_KjU, reason: not valid java name */
    public final long m10103getOnSurface0d7_KjU() {
        return onSurface;
    }

    /* JADX INFO: renamed from: getOnTertiary-0d7_KjU, reason: not valid java name */
    public final long m10104getOnTertiary0d7_KjU() {
        return onTertiary;
    }

    /* JADX INFO: renamed from: getPrimary-0d7_KjU, reason: not valid java name */
    public final long m10105getPrimary0d7_KjU() {
        return primary;
    }

    /* JADX INFO: renamed from: getSecondary-0d7_KjU, reason: not valid java name */
    public final long m10106getSecondary0d7_KjU() {
        return secondary;
    }

    /* JADX INFO: renamed from: getSurface-0d7_KjU, reason: not valid java name */
    public final long m10107getSurface0d7_KjU() {
        return surface;
    }

    /* JADX INFO: renamed from: getTertiary-0d7_KjU, reason: not valid java name */
    public final long m10108getTertiary0d7_KjU() {
        return tertiary;
    }
}
