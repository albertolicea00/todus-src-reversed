package cu.todus.android.uiCompose.player;

import androidx.camera.camera2.adapter.r;
import androidx.compose.runtime.Immutable;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;
import ua.z;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0012\b\u0087\b\u0018\u00002\u00020\u0001B;\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\u0015\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J=\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\bHÆ\u0001J\u0014\u0010\u0017\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0019\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\u001a\u001a\u00020\u0005HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u001d\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001b"}, d2 = {"Lcu/todus/android/uiCompose/player/PlayerParams;", "", "isLiveEvent", "", "url", "", "path", "pipScale", "Lkotlin/Pair;", "", "<init>", "(ZLjava/lang/String;Ljava/lang/String;Lkotlin/Pair;)V", "()Z", "getUrl", "()Ljava/lang/String;", "getPath", "getPipScale", "()Lkotlin/Pair;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class PlayerParams {
    public static final int $stable = 0;
    private final boolean isLiveEvent;
    private final String path;
    private final Pair<Integer, Integer> pipScale;
    private final String url;

    public PlayerParams() {
        this(false, null, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PlayerParams copy$default(PlayerParams playerParams, boolean z10, String str, String str2, Pair pair, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = playerParams.isLiveEvent;
        }
        if ((i10 & 2) != 0) {
            str = playerParams.url;
        }
        if ((i10 & 4) != 0) {
            str2 = playerParams.path;
        }
        if ((i10 & 8) != 0) {
            pair = playerParams.pipScale;
        }
        return playerParams.copy(z10, str, str2, pair);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getIsLiveEvent() {
        return this.isLiveEvent;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getPath() {
        return this.path;
    }

    public final Pair<Integer, Integer> component4() {
        return this.pipScale;
    }

    public final PlayerParams copy(boolean isLiveEvent, String url, String path, Pair<Integer, Integer> pipScale) {
        y.i(url, "url");
        y.i(path, "path");
        y.i(pipScale, "pipScale");
        return new PlayerParams(isLiveEvent, url, path, pipScale);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PlayerParams)) {
            return false;
        }
        PlayerParams playerParams = (PlayerParams) other;
        return this.isLiveEvent == playerParams.isLiveEvent && y.d(this.url, playerParams.url) && y.d(this.path, playerParams.path) && y.d(this.pipScale, playerParams.pipScale);
    }

    public final String getPath() {
        return this.path;
    }

    public final Pair<Integer, Integer> getPipScale() {
        return this.pipScale;
    }

    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        return (((((r.a(this.isLiveEvent) * 31) + this.url.hashCode()) * 31) + this.path.hashCode()) * 31) + this.pipScale.hashCode();
    }

    public final boolean isLiveEvent() {
        return this.isLiveEvent;
    }

    public String toString() {
        return "PlayerParams(isLiveEvent=" + this.isLiveEvent + ", url=" + this.url + ", path=" + this.path + ", pipScale=" + this.pipScale + ")";
    }

    public PlayerParams(boolean z10, String url, String path, Pair<Integer, Integer> pipScale) {
        y.i(url, "url");
        y.i(path, "path");
        y.i(pipScale, "pipScale");
        this.isLiveEvent = z10;
        this.url = url;
        this.path = path;
        this.pipScale = pipScale;
    }

    public /* synthetic */ PlayerParams(boolean z10, String str, String str2, Pair pair, int i10, p pVar) {
        this((i10 & 1) != 0 ? false : z10, (i10 & 2) != 0 ? "" : str, (i10 & 4) != 0 ? "" : str2, (i10 & 8) != 0 ? z.a(16, 9) : pair);
    }
}
