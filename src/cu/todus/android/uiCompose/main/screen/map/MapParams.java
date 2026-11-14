package cu.todus.android.uiCompose.main.screen.map;

import androidx.compose.runtime.Immutable;
import cu.z17.views.map.Z17MapMarker;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0018\b\u0002\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0019\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nHÆ\u0003JC\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0018\b\u0002\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nHÆ\u0001J\u0014\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001c\u001a\u00020\u001dHÖ\u0081\u0004J\n\u0010\u001e\u001a\u00020\u0005HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R!\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001f"}, d2 = {"Lcu/todus/android/uiCompose/main/screen/map/MapParams;", "", "motive", "Lcu/todus/android/uiCompose/main/screen/map/MapMotive;", "roomId", "", "replyMsgId", "markers", "Ljava/util/ArrayList;", "Lcu/z17/views/map/Z17MapMarker;", "Lkotlin/collections/ArrayList;", "<init>", "(Lcu/todus/android/uiCompose/main/screen/map/MapMotive;Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;)V", "getMotive", "()Lcu/todus/android/uiCompose/main/screen/map/MapMotive;", "getRoomId", "()Ljava/lang/String;", "getReplyMsgId", "getMarkers", "()Ljava/util/ArrayList;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class MapParams {
    public static final int $stable = 0;
    private final ArrayList<Z17MapMarker> markers;
    private final MapMotive motive;
    private final String replyMsgId;
    private final String roomId;

    public MapParams(MapMotive motive, String roomId, String str, ArrayList<Z17MapMarker> markers) {
        y.i(motive, "motive");
        y.i(roomId, "roomId");
        y.i(markers, "markers");
        this.motive = motive;
        this.roomId = roomId;
        this.replyMsgId = str;
        this.markers = markers;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MapParams copy$default(MapParams mapParams, MapMotive mapMotive, String str, String str2, ArrayList arrayList, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            mapMotive = mapParams.motive;
        }
        if ((i10 & 2) != 0) {
            str = mapParams.roomId;
        }
        if ((i10 & 4) != 0) {
            str2 = mapParams.replyMsgId;
        }
        if ((i10 & 8) != 0) {
            arrayList = mapParams.markers;
        }
        return mapParams.copy(mapMotive, str, str2, arrayList);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final MapMotive getMotive() {
        return this.motive;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getRoomId() {
        return this.roomId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getReplyMsgId() {
        return this.replyMsgId;
    }

    public final ArrayList<Z17MapMarker> component4() {
        return this.markers;
    }

    public final MapParams copy(MapMotive motive, String roomId, String replyMsgId, ArrayList<Z17MapMarker> markers) {
        y.i(motive, "motive");
        y.i(roomId, "roomId");
        y.i(markers, "markers");
        return new MapParams(motive, roomId, replyMsgId, markers);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MapParams)) {
            return false;
        }
        MapParams mapParams = (MapParams) other;
        return this.motive == mapParams.motive && y.d(this.roomId, mapParams.roomId) && y.d(this.replyMsgId, mapParams.replyMsgId) && y.d(this.markers, mapParams.markers);
    }

    public final ArrayList<Z17MapMarker> getMarkers() {
        return this.markers;
    }

    public final MapMotive getMotive() {
        return this.motive;
    }

    public final String getReplyMsgId() {
        return this.replyMsgId;
    }

    public final String getRoomId() {
        return this.roomId;
    }

    public int hashCode() {
        int iHashCode = ((this.motive.hashCode() * 31) + this.roomId.hashCode()) * 31;
        String str = this.replyMsgId;
        return ((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.markers.hashCode();
    }

    public String toString() {
        return "MapParams(motive=" + this.motive + ", roomId=" + this.roomId + ", replyMsgId=" + this.replyMsgId + ", markers=" + this.markers + ")";
    }

    public /* synthetic */ MapParams(MapMotive mapMotive, String str, String str2, ArrayList arrayList, int i10, p pVar) {
        this(mapMotive, (i10 & 2) != 0 ? "" : str, (i10 & 4) != 0 ? null : str2, (i10 & 8) != 0 ? new ArrayList() : arrayList);
    }
}
