package cu.todus.android.data.xmpp;

import androidx.camera.camera2.adapter.r;
import androidx.compose.runtime.Immutable;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001J\u0014\u0010\u0013\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0015\u001a\u00020\u0006HÖ\u0081\u0004J\n\u0010\u0016\u001a\u00020\u0017HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0018"}, d2 = {"Lcu/todus/android/data/xmpp/FollowState;", "", "isFollowed", "", "isFollowingU", "followersCount", "", "followingCount", "<init>", "(ZZII)V", "()Z", "getFollowersCount", "()I", "getFollowingCount", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class FollowState {
    public static final int $stable = 0;
    private final int followersCount;
    private final int followingCount;
    private final boolean isFollowed;
    private final boolean isFollowingU;

    public FollowState(boolean z10, boolean z11, int i10, int i11) {
        this.isFollowed = z10;
        this.isFollowingU = z11;
        this.followersCount = i10;
        this.followingCount = i11;
    }

    public static /* synthetic */ FollowState copy$default(FollowState followState, boolean z10, boolean z11, int i10, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            z10 = followState.isFollowed;
        }
        if ((i12 & 2) != 0) {
            z11 = followState.isFollowingU;
        }
        if ((i12 & 4) != 0) {
            i10 = followState.followersCount;
        }
        if ((i12 & 8) != 0) {
            i11 = followState.followingCount;
        }
        return followState.copy(z10, z11, i10, i11);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getIsFollowed() {
        return this.isFollowed;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getIsFollowingU() {
        return this.isFollowingU;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getFollowersCount() {
        return this.followersCount;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getFollowingCount() {
        return this.followingCount;
    }

    public final FollowState copy(boolean isFollowed, boolean isFollowingU, int followersCount, int followingCount) {
        return new FollowState(isFollowed, isFollowingU, followersCount, followingCount);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FollowState)) {
            return false;
        }
        FollowState followState = (FollowState) other;
        return this.isFollowed == followState.isFollowed && this.isFollowingU == followState.isFollowingU && this.followersCount == followState.followersCount && this.followingCount == followState.followingCount;
    }

    public final int getFollowersCount() {
        return this.followersCount;
    }

    public final int getFollowingCount() {
        return this.followingCount;
    }

    public int hashCode() {
        return (((((r.a(this.isFollowed) * 31) + r.a(this.isFollowingU)) * 31) + this.followersCount) * 31) + this.followingCount;
    }

    public final boolean isFollowed() {
        return this.isFollowed;
    }

    public final boolean isFollowingU() {
        return this.isFollowingU;
    }

    public String toString() {
        return "FollowState(isFollowed=" + this.isFollowed + ", isFollowingU=" + this.isFollowingU + ", followersCount=" + this.followersCount + ", followingCount=" + this.followingCount + ")";
    }
}
