package cu.z17.views.videoPlayer;

import androidx.compose.runtime.Stable;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes7.dex */
@Stable
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcu/z17/views/videoPlayer/RepeatMode;", "", "rawValue", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "NONE", "ONE", "ALL", "views_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public enum RepeatMode {
    NONE("none"),
    ONE("one"),
    ALL("all");

    private static final /* synthetic */ db.a $ENTRIES = db.b.a(values());

    RepeatMode(String str) {
    }

    public static db.a getEntries() {
        return $ENTRIES;
    }
}
