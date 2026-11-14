package cu.todus.android.data.db.pojo.content;

import androidx.camera.camera2.adapter.r;
import androidx.compose.runtime.Immutable;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcu/todus/android/data/db/pojo/content/LinkInfoContent;", "Lcu/todus/android/data/db/pojo/content/Content;", "downloadedInfo", "", "linkEntity", "Lcu/todus/android/data/db/pojo/content/LinkEntity;", "<init>", "(ZLcu/todus/android/data/db/pojo/content/LinkEntity;)V", "getDownloadedInfo", "()Z", "getLinkEntity", "()Lcu/todus/android/data/db/pojo/content/LinkEntity;", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class LinkInfoContent extends Content {
    public static final int $stable = 0;
    private final boolean downloadedInfo;
    private final LinkEntity linkEntity;

    /* JADX WARN: Multi-variable type inference failed */
    public LinkInfoContent() {
        this(false, null, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ LinkInfoContent copy$default(LinkInfoContent linkInfoContent, boolean z10, LinkEntity linkEntity, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = linkInfoContent.downloadedInfo;
        }
        if ((i10 & 2) != 0) {
            linkEntity = linkInfoContent.linkEntity;
        }
        return linkInfoContent.copy(z10, linkEntity);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getDownloadedInfo() {
        return this.downloadedInfo;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final LinkEntity getLinkEntity() {
        return this.linkEntity;
    }

    public final LinkInfoContent copy(boolean downloadedInfo, LinkEntity linkEntity) {
        return new LinkInfoContent(downloadedInfo, linkEntity);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LinkInfoContent)) {
            return false;
        }
        LinkInfoContent linkInfoContent = (LinkInfoContent) other;
        return this.downloadedInfo == linkInfoContent.downloadedInfo && y.d(this.linkEntity, linkInfoContent.linkEntity);
    }

    public final boolean getDownloadedInfo() {
        return this.downloadedInfo;
    }

    public final LinkEntity getLinkEntity() {
        return this.linkEntity;
    }

    public int hashCode() {
        int iA = r.a(this.downloadedInfo) * 31;
        LinkEntity linkEntity = this.linkEntity;
        return iA + (linkEntity == null ? 0 : linkEntity.hashCode());
    }

    public String toString() {
        return "LinkInfoContent(downloadedInfo=" + this.downloadedInfo + ", linkEntity=" + this.linkEntity + ")";
    }

    public LinkInfoContent(boolean z10, LinkEntity linkEntity) {
        super(20);
        this.downloadedInfo = z10;
        this.linkEntity = linkEntity;
    }

    public /* synthetic */ LinkInfoContent(boolean z10, LinkEntity linkEntity, int i10, p pVar) {
        this((i10 & 1) != 0 ? false : z10, (i10 & 2) != 0 ? null : linkEntity);
    }
}
