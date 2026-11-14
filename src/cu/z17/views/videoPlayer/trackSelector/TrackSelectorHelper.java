package cu.z17.views.videoPlayer.trackSelector;

import android.content.Context;
import androidx.annotation.OptIn;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.exoplayer.source.TrackGroupArray;
import androidx.media3.exoplayer.trackselection.DefaultTrackSelector;
import androidx.media3.exoplayer.trackselection.MappingTrackSelector;
import androidx.media3.ui.DefaultTrackNameProvider;
import j$.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.y;
import le.d0;
import le.z;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes7.dex */
@StabilityInferred(parameters = 0)
@OptIn(markerClass = {UnstableApi.class})
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0015R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0016R\u0016\u0010\u0017\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0019\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u0018\u001a\u0004\b\u001a\u0010\u000f¨\u0006\u001c"}, d2 = {"Lcu/z17/views/videoPlayer/trackSelector/TrackSelectorHelper;", "", "Landroid/content/Context;", "context", "Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector;", "trackSelector", "<init>", "(Landroid/content/Context;Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector;)V", "", "trackType", "", "trackTypeToName", "(I)Ljava/lang/String;", "Lcu/z17/views/videoPlayer/trackSelector/TripleTrackSave;", "loadTrackData", "()Lcu/z17/views/videoPlayer/trackSelector/TripleTrackSave;", "Lcu/z17/views/videoPlayer/trackSelector/TrackElement;", "trackElement", "Lua/k0;", "selectTrack", "(Lcu/z17/views/videoPlayer/trackSelector/TrackElement;)V", "Landroid/content/Context;", "Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector;", "_tripleTrackSave", "Lcu/z17/views/videoPlayer/trackSelector/TripleTrackSave;", "tripleTrackSave", "getTripleTrackSave", "Companion", "views_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class TrackSelectorHelper {
    public static final int $stable;
    private static final String TAG;
    private TripleTrackSave _tripleTrackSave;
    private final Context context;
    private final DefaultTrackSelector trackSelector;
    private final TripleTrackSave tripleTrackSave;

    static {
        Companion companion = new Companion(null);
        INSTANCE = companion;
        $stable = 8;
        TAG = companion.getClass().getSimpleName();
    }

    public TrackSelectorHelper(Context context, DefaultTrackSelector trackSelector) {
        y.i(context, "context");
        y.i(trackSelector, "trackSelector");
        this.context = context;
        this.trackSelector = trackSelector;
        TripleTrackSave tripleTrackSave = new TripleTrackSave(null, null, null, 7, null);
        this._tripleTrackSave = tripleTrackSave;
        this.tripleTrackSave = tripleTrackSave;
    }

    private final String trackTypeToName(int trackType) {
        if (trackType == 1) {
            return "TRACK_TYPE_AUDIO";
        }
        if (trackType != 2) {
            return trackType != 3 ? "Invalid track type" : "TRACK_TYPE_TEXT";
        }
        return "TRACK_TYPE_VIDEO";
    }

    public final TripleTrackSave getTripleTrackSave() {
        return this.tripleTrackSave;
    }

    public final TripleTrackSave loadTrackData() {
        int i10;
        String str;
        FormatVideoResolution formatVideoResolution;
        this._tripleTrackSave = new TripleTrackSave(null, null, null, 7, null);
        MappingTrackSelector.MappedTrackInfo currentMappedTrackInfo = this.trackSelector.getCurrentMappedTrackInfo();
        if (currentMappedTrackInfo != null) {
            int rendererCount = currentMappedTrackInfo.getRendererCount();
            for (int i11 = 0; i11 < rendererCount; i11++) {
                int rendererType = currentMappedTrackInfo.getRendererType(i11);
                TrackGroupArray trackGroups = currentMappedTrackInfo.getTrackGroups(i11);
                y.h(trackGroups, "getTrackGroups(...)");
                trackTypeToName(rendererType);
                Objects.toString(trackGroups);
                int i12 = trackGroups.length;
                for (int i13 = 0; i13 < i12; i13++) {
                    int i14 = 0;
                    for (int i15 = trackGroups.get(i13).length; i14 < i15; i15 = i10) {
                        String trackName = new DefaultTrackNameProvider(this.context.getResources()).getTrackName(trackGroups.get(i13).getFormat(i14));
                        y.h(trackName, "getTrackName(...)");
                        if (rendererType == 1) {
                            i10 = i15;
                            this._tripleTrackSave = this._tripleTrackSave.addAudioTrack(new TrackElement(1, i14, i13, trackName, new FormatAudioPreferred(trackName)));
                        } else if (rendererType == 2) {
                            i10 = i15;
                            try {
                                str = trackName;
                                try {
                                    Integer numV = z.v((String) d0.S0((CharSequence) d0.S0(str, new String[]{","}, false, 0, 6, null).get(0), new String[]{" × "}, false, 0, 6, null).get(0));
                                    int iIntValue = numV != null ? numV.intValue() : 100;
                                    str = trackName;
                                    Integer numV2 = z.v((String) d0.S0((CharSequence) d0.S0(str, new String[]{","}, false, 0, 6, null).get(0), new String[]{" × "}, false, 0, 6, null).get(1));
                                    formatVideoResolution = new FormatVideoResolution(iIntValue, numV2 != null ? numV2.intValue() : 100);
                                } catch (Exception unused) {
                                    formatVideoResolution = null;
                                }
                            } catch (Exception unused2) {
                                str = trackName;
                            }
                            this._tripleTrackSave = this._tripleTrackSave.addVideoTrack(new TrackElement(2, i14, i13, str, formatVideoResolution));
                        } else if (rendererType != 3) {
                            i10 = i15;
                        } else {
                            i10 = i15;
                            this._tripleTrackSave = this._tripleTrackSave.addSubsTrack(new TrackElement(3, i14, i13, trackName, new FormatSubsPreferred(trackName)));
                        }
                        i14++;
                    }
                }
            }
        }
        return this._tripleTrackSave;
    }

    public final void selectTrack(TrackElement trackElement) {
        DefaultTrackSelector.Parameters.Builder preferredAudioLanguage;
        y.i(trackElement, "trackElement");
        int trackType = trackElement.getTrackType();
        if (trackType == 1) {
            DefaultTrackSelector.Parameters.Builder builderBuildUponParameters = this.trackSelector.buildUponParameters();
            FormatData trackFormatData = trackElement.getTrackFormatData();
            y.g(trackFormatData, "null cannot be cast to non-null type cu.z17.views.videoPlayer.trackSelector.FormatAudioPreferred");
            preferredAudioLanguage = builderBuildUponParameters.setPreferredAudioLanguage(((FormatAudioPreferred) trackFormatData).getAudio());
        } else if (trackType == 2) {
            DefaultTrackSelector.Parameters.Builder builderBuildUponParameters2 = this.trackSelector.buildUponParameters();
            FormatData trackFormatData2 = trackElement.getTrackFormatData();
            y.g(trackFormatData2, "null cannot be cast to non-null type cu.z17.views.videoPlayer.trackSelector.FormatVideoResolution");
            preferredAudioLanguage = builderBuildUponParameters2.setMaxVideoSize(((FormatVideoResolution) trackFormatData2).getWidth(), ((FormatVideoResolution) trackElement.getTrackFormatData()).getHeight());
        } else if (trackType != 3) {
            preferredAudioLanguage = this.trackSelector.buildUponParameters();
        } else {
            DefaultTrackSelector.Parameters.Builder builderBuildUponParameters3 = this.trackSelector.buildUponParameters();
            FormatData trackFormatData3 = trackElement.getTrackFormatData();
            y.g(trackFormatData3, "null cannot be cast to non-null type cu.z17.views.videoPlayer.trackSelector.FormatSubsPreferred");
            preferredAudioLanguage = builderBuildUponParameters3.setPreferredTextLanguage(((FormatSubsPreferred) trackFormatData3).getLanguage());
        }
        y.f(preferredAudioLanguage);
        this.trackSelector.setParameters(preferredAudioLanguage);
    }
}
