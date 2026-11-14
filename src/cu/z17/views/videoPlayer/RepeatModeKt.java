package cu.z17.views.videoPlayer;

import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\n\u0010\u0003\u001a\u00020\u0002*\u00020\u0001¨\u0006\u0004"}, d2 = {"toExoPlayerRepeatMode", "", "Lcu/z17/views/videoPlayer/RepeatMode;", "toRepeatMode", "views_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class RepeatModeKt {

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[RepeatMode.values().length];
            try {
                iArr[RepeatMode.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[RepeatMode.ALL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[RepeatMode.ONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final int toExoPlayerRepeatMode(RepeatMode repeatMode) {
        kotlin.jvm.internal.y.i(repeatMode, "<this>");
        int i10 = WhenMappings.$EnumSwitchMapping$0[repeatMode.ordinal()];
        if (i10 == 1) {
            return 0;
        }
        if (i10 == 2) {
            return 2;
        }
        if (i10 == 3) {
            return 1;
        }
        throw new ua.r();
    }

    public static final RepeatMode toRepeatMode(int i10) {
        if (i10 < 0 || i10 >= 3) {
            throw new IllegalStateException("This is not ExoPlayer repeat mode.");
        }
        if (i10 == 0) {
            return RepeatMode.NONE;
        }
        if (i10 == 1) {
            return RepeatMode.ONE;
        }
        if (i10 == 2) {
            return RepeatMode.ALL;
        }
        throw new IllegalStateException("This is not ExoPlayer repeat mode.");
    }
}
