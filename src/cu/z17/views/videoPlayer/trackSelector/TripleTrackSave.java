package cu.z17.views.videoPlayer.trackSelector;

import androidx.compose.runtime.Immutable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;
import ua.k0;
import va.w;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes7.dex */
@Immutable
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0004J\u000e\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0004J\u000e\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0004J\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J9\u0010\u0014\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\n¨\u0006\u001c"}, d2 = {"Lcu/z17/views/videoPlayer/trackSelector/TripleTrackSave;", "", "videoTracks", "", "Lcu/z17/views/videoPlayer/trackSelector/TrackElement;", "audioTracks", "subsTracks", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getVideoTracks", "()Ljava/util/List;", "getAudioTracks", "getSubsTracks", "addVideoTrack", "trackElement", "addAudioTrack", "addSubsTrack", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "views_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class TripleTrackSave {
    public static final int $stable = 0;
    private final List<TrackElement> audioTracks;
    private final List<TrackElement> subsTracks;
    private final List<TrackElement> videoTracks;

    public TripleTrackSave() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TripleTrackSave copy$default(TripleTrackSave tripleTrackSave, List list, List list2, List list3, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = tripleTrackSave.videoTracks;
        }
        if ((i10 & 2) != 0) {
            list2 = tripleTrackSave.audioTracks;
        }
        if ((i10 & 4) != 0) {
            list3 = tripleTrackSave.subsTracks;
        }
        return tripleTrackSave.copy(list, list2, list3);
    }

    public final TripleTrackSave addAudioTrack(TrackElement trackElement) {
        y.i(trackElement, "trackElement");
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.audioTracks);
        arrayList.add(trackElement);
        k0 k0Var = k0.f43947a;
        return copy$default(this, null, arrayList, null, 5, null);
    }

    public final TripleTrackSave addSubsTrack(TrackElement trackElement) {
        y.i(trackElement, "trackElement");
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.subsTracks);
        arrayList.add(trackElement);
        k0 k0Var = k0.f43947a;
        return copy$default(this, null, null, arrayList, 3, null);
    }

    public final TripleTrackSave addVideoTrack(TrackElement trackElement) {
        y.i(trackElement, "trackElement");
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.videoTracks);
        arrayList.add(trackElement);
        return copy$default(this, arrayList, null, null, 6, null);
    }

    public final List<TrackElement> component1() {
        return this.videoTracks;
    }

    public final List<TrackElement> component2() {
        return this.audioTracks;
    }

    public final List<TrackElement> component3() {
        return this.subsTracks;
    }

    public final TripleTrackSave copy(List<TrackElement> videoTracks, List<TrackElement> audioTracks, List<TrackElement> subsTracks) {
        y.i(videoTracks, "videoTracks");
        y.i(audioTracks, "audioTracks");
        y.i(subsTracks, "subsTracks");
        return new TripleTrackSave(videoTracks, audioTracks, subsTracks);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TripleTrackSave)) {
            return false;
        }
        TripleTrackSave tripleTrackSave = (TripleTrackSave) other;
        return y.d(this.videoTracks, tripleTrackSave.videoTracks) && y.d(this.audioTracks, tripleTrackSave.audioTracks) && y.d(this.subsTracks, tripleTrackSave.subsTracks);
    }

    public final List<TrackElement> getAudioTracks() {
        return this.audioTracks;
    }

    public final List<TrackElement> getSubsTracks() {
        return this.subsTracks;
    }

    public final List<TrackElement> getVideoTracks() {
        return this.videoTracks;
    }

    public int hashCode() {
        return (((this.videoTracks.hashCode() * 31) + this.audioTracks.hashCode()) * 31) + this.subsTracks.hashCode();
    }

    public String toString() {
        return "TripleTrackSave(videoTracks=" + this.videoTracks + ", audioTracks=" + this.audioTracks + ", subsTracks=" + this.subsTracks + ")";
    }

    public TripleTrackSave(List<TrackElement> videoTracks, List<TrackElement> audioTracks, List<TrackElement> subsTracks) {
        y.i(videoTracks, "videoTracks");
        y.i(audioTracks, "audioTracks");
        y.i(subsTracks, "subsTracks");
        this.videoTracks = videoTracks;
        this.audioTracks = audioTracks;
        this.subsTracks = subsTracks;
    }

    public /* synthetic */ TripleTrackSave(List list, List list2, List list3, int i10, p pVar) {
        this((i10 & 1) != 0 ? w.n() : list, (i10 & 2) != 0 ? w.n() : list2, (i10 & 4) != 0 ? w.n() : list3);
    }
}
