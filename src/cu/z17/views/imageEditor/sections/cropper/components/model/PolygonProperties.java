package cu.z17.views.imageEditor.sections.cropper.components.model;

import androidx.compose.runtime.Immutable;
import androidx.compose.ui.geometry.Offset;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0010\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ.\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u000bJ\u001a\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001c\u001a\u0004\b\u001d\u0010\u000bR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001e\u001a\u0004\b\u001f\u0010\rR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010 \u001a\u0004\b!\u0010\u000f¨\u0006\""}, d2 = {"Lcu/z17/views/imageEditor/sections/cropper/components/model/PolygonProperties;", "", "", "sides", "", "angle", "Landroidx/compose/ui/geometry/Offset;", "offset", "<init>", "(IFJLkotlin/jvm/internal/p;)V", "component1", "()I", "component2", "()F", "component3-F1C5BW0", "()J", "component3", "copy-0AR0LA0", "(IFJ)Lcu/z17/views/imageEditor/sections/cropper/components/model/PolygonProperties;", "copy", "", "toString", "()Ljava/lang/String;", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getSides", "F", "getAngle", "J", "getOffset-F1C5BW0", "views_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class PolygonProperties {
    public static final int $stable = 0;
    private final float angle;
    private final long offset;
    private final int sides;

    public /* synthetic */ PolygonProperties(int i10, float f10, long j10, p pVar) {
        this(i10, f10, j10);
    }

    /* JADX INFO: renamed from: copy-0AR0LA0$default, reason: not valid java name */
    public static /* synthetic */ PolygonProperties m10189copy0AR0LA0$default(PolygonProperties polygonProperties, int i10, float f10, long j10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = polygonProperties.sides;
        }
        if ((i11 & 2) != 0) {
            f10 = polygonProperties.angle;
        }
        if ((i11 & 4) != 0) {
            j10 = polygonProperties.offset;
        }
        return polygonProperties.m10191copy0AR0LA0(i10, f10, j10);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getSides() {
        return this.sides;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final float getAngle() {
        return this.angle;
    }

    /* JADX INFO: renamed from: component3-F1C5BW0, reason: not valid java name and from getter */
    public final long getOffset() {
        return this.offset;
    }

    /* JADX INFO: renamed from: copy-0AR0LA0, reason: not valid java name */
    public final PolygonProperties m10191copy0AR0LA0(int sides, float angle, long offset) {
        return new PolygonProperties(sides, angle, offset, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PolygonProperties)) {
            return false;
        }
        PolygonProperties polygonProperties = (PolygonProperties) other;
        return this.sides == polygonProperties.sides && Float.compare(this.angle, polygonProperties.angle) == 0 && Offset.m5623equalsimpl0(this.offset, polygonProperties.offset);
    }

    public final float getAngle() {
        return this.angle;
    }

    /* JADX INFO: renamed from: getOffset-F1C5BW0, reason: not valid java name */
    public final long m10192getOffsetF1C5BW0() {
        return this.offset;
    }

    public final int getSides() {
        return this.sides;
    }

    public int hashCode() {
        return (((this.sides * 31) + Float.floatToIntBits(this.angle)) * 31) + Offset.m5628hashCodeimpl(this.offset);
    }

    public String toString() {
        return "PolygonProperties(sides=" + this.sides + ", angle=" + this.angle + ", offset=" + Offset.m5634toStringimpl(this.offset) + ")";
    }

    private PolygonProperties(int i10, float f10, long j10) {
        this.sides = i10;
        this.angle = f10;
        this.offset = j10;
    }

    public /* synthetic */ PolygonProperties(int i10, float f10, long j10, int i11, p pVar) {
        this((i11 & 1) != 0 ? 6 : i10, (i11 & 2) != 0 ? 0.0f : f10, (i11 & 4) != 0 ? Offset.INSTANCE.m5642getZeroF1C5BW0() : j10, null);
    }
}
