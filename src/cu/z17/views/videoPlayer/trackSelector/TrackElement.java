package cu.z17.views.videoPlayer.trackSelector;

import androidx.compose.runtime.Immutable;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes7.dex */
@Immutable
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0014\u001a\u00020\u0007H\u0016J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\tHÆ\u0003J=\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001f"}, d2 = {"Lcu/z17/views/videoPlayer/trackSelector/TrackElement;", "", "trackType", "", "index", "trackItem", "trackStringData", "", "trackFormatData", "Lcu/z17/views/videoPlayer/trackSelector/FormatData;", "<init>", "(IIILjava/lang/String;Lcu/z17/views/videoPlayer/trackSelector/FormatData;)V", "getTrackType", "()I", "getIndex", "getTrackItem", "getTrackStringData", "()Ljava/lang/String;", "getTrackFormatData", "()Lcu/z17/views/videoPlayer/trackSelector/FormatData;", "toString", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "views_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class TrackElement {
    public static final int $stable = 0;
    private final int index;
    private final FormatData trackFormatData;
    private final int trackItem;
    private final String trackStringData;
    private final int trackType;

    public TrackElement(int i10, int i11, int i12, String trackStringData, FormatData formatData) {
        y.i(trackStringData, "trackStringData");
        this.trackType = i10;
        this.index = i11;
        this.trackItem = i12;
        this.trackStringData = trackStringData;
        this.trackFormatData = formatData;
    }

    public static /* synthetic */ TrackElement copy$default(TrackElement trackElement, int i10, int i11, int i12, String str, FormatData formatData, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            i10 = trackElement.trackType;
        }
        if ((i13 & 2) != 0) {
            i11 = trackElement.index;
        }
        if ((i13 & 4) != 0) {
            i12 = trackElement.trackItem;
        }
        if ((i13 & 8) != 0) {
            str = trackElement.trackStringData;
        }
        if ((i13 & 16) != 0) {
            formatData = trackElement.trackFormatData;
        }
        FormatData formatData2 = formatData;
        int i14 = i12;
        return trackElement.copy(i10, i11, i14, str, formatData2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getTrackType() {
        return this.trackType;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getIndex() {
        return this.index;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getTrackItem() {
        return this.trackItem;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getTrackStringData() {
        return this.trackStringData;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final FormatData getTrackFormatData() {
        return this.trackFormatData;
    }

    public final TrackElement copy(int trackType, int index, int trackItem, String trackStringData, FormatData trackFormatData) {
        y.i(trackStringData, "trackStringData");
        return new TrackElement(trackType, index, trackItem, trackStringData, trackFormatData);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackElement)) {
            return false;
        }
        TrackElement trackElement = (TrackElement) other;
        return this.trackType == trackElement.trackType && this.index == trackElement.index && this.trackItem == trackElement.trackItem && y.d(this.trackStringData, trackElement.trackStringData) && y.d(this.trackFormatData, trackElement.trackFormatData);
    }

    public final int getIndex() {
        return this.index;
    }

    public final FormatData getTrackFormatData() {
        return this.trackFormatData;
    }

    public final int getTrackItem() {
        return this.trackItem;
    }

    public final String getTrackStringData() {
        return this.trackStringData;
    }

    public final int getTrackType() {
        return this.trackType;
    }

    public int hashCode() {
        int iHashCode = ((((((this.trackType * 31) + this.index) * 31) + this.trackItem) * 31) + this.trackStringData.hashCode()) * 31;
        FormatData formatData = this.trackFormatData;
        return iHashCode + (formatData == null ? 0 : formatData.hashCode());
    }

    public String toString() {
        return "trackType: " + this.trackType + ", index: " + this.index + ", trackItem: " + this.trackItem + ", trackStringData: " + this.trackStringData + ", trackFormatData: " + this.trackFormatData;
    }

    public /* synthetic */ TrackElement(int i10, int i11, int i12, String str, FormatData formatData, int i13, p pVar) {
        this(i10, (i13 & 2) != 0 ? 0 : i11, (i13 & 4) != 0 ? 0 : i12, (i13 & 8) != 0 ? "" : str, formatData);
    }
}
