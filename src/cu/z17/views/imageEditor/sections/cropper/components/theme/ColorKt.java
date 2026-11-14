package cu.z17.views.imageEditor.sections.cropper.components.theme;

import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\"\u0013\u0010\u0000\u001a\u00020\u0001¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0002\u0010\u0003\"\u0013\u0010\u0005\u001a\u00020\u0001¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0006\u0010\u0003\"\u0013\u0010\u0007\u001a\u00020\u0001¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\b\u0010\u0003¨\u0006\t"}, d2 = {"DefaultBackgroundColor", "Landroidx/compose/ui/graphics/Color;", "getDefaultBackgroundColor", "()J", "J", "DefaultOverlayColor", "getDefaultOverlayColor", "DefaultHandleColor", "getDefaultHandleColor", "views_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ColorKt {
    private static final long DefaultBackgroundColor = androidx.compose.ui.graphics.ColorKt.Color(2566914048L);
    private static final long DefaultHandleColor;
    private static final long DefaultOverlayColor;

    static {
        Color.Companion companion = Color.INSTANCE;
        DefaultOverlayColor = companion.m5896getGray0d7_KjU();
        DefaultHandleColor = companion.m5903getWhite0d7_KjU();
    }

    public static final long getDefaultBackgroundColor() {
        return DefaultBackgroundColor;
    }

    public static final long getDefaultHandleColor() {
        return DefaultHandleColor;
    }

    public static final long getDefaultOverlayColor() {
        return DefaultOverlayColor;
    }
}
