package cu.z17.views.zoomables;

import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.media3.muxer.MuxerUtil;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.y;
import org.jivesoftware.smackx.disco.packet.DiscoverItems;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a;\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a\u0017\u0010\t\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\t\u0010\n\u001a\u001b\u0010\u000f\u001a\u00020\u000e*\u00020\u000b2\u0006\u0010\r\u001a\u00020\fH\u0000¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcu/z17/views/zoomables/ZoomLevel;", "zoomLevel", "", "initial", "min", "max", "Lkotlin/Pair;", "calculateZoom", "(Lcu/z17/views/zoomables/ZoomLevel;FFF)Lkotlin/Pair;", "getNextZoomLevel", "(Lcu/z17/views/zoomables/ZoomLevel;)Lcu/z17/views/zoomables/ZoomLevel;", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "Lcu/z17/views/zoomables/ZoomState;", "zoomState", "Lua/k0;", DiscoverItems.Item.UPDATE_ACTION, "(Landroidx/compose/ui/graphics/GraphicsLayerScope;Lcu/z17/views/zoomables/ZoomState;)V", "views_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ZoomUtilKt {

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ZoomLevel.values().length];
            try {
                iArr[ZoomLevel.Mid.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ZoomLevel.Max.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final Pair<ZoomLevel, Float> calculateZoom(ZoomLevel zoomLevel, float f10, float f11, float f12) {
        ZoomLevel zoomLevel2;
        y.i(zoomLevel, "zoomLevel");
        int i10 = WhenMappings.$EnumSwitchMapping$0[zoomLevel.ordinal()];
        if (i10 == 1) {
            zoomLevel2 = ZoomLevel.Max;
            f10 = rb.k.i(f12, 3.0f);
        } else if (i10 != 2) {
            zoomLevel2 = ZoomLevel.Mid;
            if (f11 == f10) {
                f10 = (f11 + rb.k.i(f12, 3.0f)) / 2;
            }
        } else {
            zoomLevel2 = ZoomLevel.Min;
            if (f11 != f10) {
                f10 = f11;
            }
        }
        return new Pair<>(zoomLevel2, Float.valueOf(f10));
    }

    public static final ZoomLevel getNextZoomLevel(ZoomLevel zoomLevel) {
        y.i(zoomLevel, "zoomLevel");
        int i10 = WhenMappings.$EnumSwitchMapping$0[zoomLevel.ordinal()];
        if (i10 != 1) {
            return i10 != 2 ? ZoomLevel.Mid : ZoomLevel.Min;
        }
        return ZoomLevel.Max;
    }

    public static final void update(GraphicsLayerScope graphicsLayerScope, ZoomState zoomState) {
        y.i(graphicsLayerScope, "<this>");
        y.i(zoomState, "zoomState");
        float zoom = zoomState.getZoom();
        graphicsLayerScope.setScaleX(zoom);
        graphicsLayerScope.setScaleY(zoom);
        long jM10345getPanF1C5BW0 = zoomState.m10345getPanF1C5BW0();
        float fIntBitsToFloat = Float.intBitsToFloat((int) (jM10345getPanF1C5BW0 >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (jM10345getPanF1C5BW0 & MuxerUtil.UNSIGNED_INT_MAX_VALUE));
        graphicsLayerScope.setTranslationX(fIntBitsToFloat);
        graphicsLayerScope.setTranslationY(fIntBitsToFloat2);
        graphicsLayerScope.setRotationZ(zoomState.getRotation());
    }
}
