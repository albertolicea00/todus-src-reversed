package cu.z17.views.picturesAlbum.data;

import android.net.Uri;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes7.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÀ\u0003¢\u0006\u0004\b\u0017\u0010\u000fJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÀ\u0003¢\u0006\u0004\b\u001a\u0010\u000fJ\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0007HÀ\u0003¢\u0006\u0002\b\u001cJH\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u001eJ\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\b\u001a\u0004\u0018\u00010\u0005X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0013\u0010\u000fR\u0016\u0010\t\u001a\u0004\u0018\u00010\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012¨\u0006%"}, d2 = {"Lcu/z17/views/picturesAlbum/data/AlbumImage;", "", "uri", "Landroid/net/Uri;", "dateTaken", "", "displayName", "", "id", "folderName", "<init>", "(Landroid/net/Uri;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;)V", "getUri", "()Landroid/net/Uri;", "getDateTaken$views_release", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getDisplayName", "()Ljava/lang/String;", "getId$views_release", "getFolderName$views_release", "component1", "component2", "component2$views_release", "component3", "component4", "component4$views_release", "component5", "component5$views_release", "copy", "(Landroid/net/Uri;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;)Lcu/z17/views/picturesAlbum/data/AlbumImage;", "equals", "", "other", "hashCode", "", "toString", "views_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class AlbumImage {
    public static final int $stable = 8;
    private final Long dateTaken;
    private final String displayName;
    private final String folderName;
    private final Long id;
    private final Uri uri;

    public AlbumImage(Uri uri, Long l10, String str, Long l11, String str2) {
        y.i(uri, "uri");
        this.uri = uri;
        this.dateTaken = l10;
        this.displayName = str;
        this.id = l11;
        this.folderName = str2;
    }

    public static /* synthetic */ AlbumImage copy$default(AlbumImage albumImage, Uri uri, Long l10, String str, Long l11, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            uri = albumImage.uri;
        }
        if ((i10 & 2) != 0) {
            l10 = albumImage.dateTaken;
        }
        if ((i10 & 4) != 0) {
            str = albumImage.displayName;
        }
        if ((i10 & 8) != 0) {
            l11 = albumImage.id;
        }
        if ((i10 & 16) != 0) {
            str2 = albumImage.folderName;
        }
        String str3 = str2;
        String str4 = str;
        return albumImage.copy(uri, l10, str4, l11, str3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Uri getUri() {
        return this.uri;
    }

    /* JADX INFO: renamed from: component2$views_release, reason: from getter */
    public final Long getDateTaken() {
        return this.dateTaken;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getDisplayName() {
        return this.displayName;
    }

    /* JADX INFO: renamed from: component4$views_release, reason: from getter */
    public final Long getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component5$views_release, reason: from getter */
    public final String getFolderName() {
        return this.folderName;
    }

    public final AlbumImage copy(Uri uri, Long dateTaken, String displayName, Long id2, String folderName) {
        y.i(uri, "uri");
        return new AlbumImage(uri, dateTaken, displayName, id2, folderName);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AlbumImage)) {
            return false;
        }
        AlbumImage albumImage = (AlbumImage) other;
        return y.d(this.uri, albumImage.uri) && y.d(this.dateTaken, albumImage.dateTaken) && y.d(this.displayName, albumImage.displayName) && y.d(this.id, albumImage.id) && y.d(this.folderName, albumImage.folderName);
    }

    public final Long getDateTaken$views_release() {
        return this.dateTaken;
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    public final String getFolderName$views_release() {
        return this.folderName;
    }

    public final Long getId$views_release() {
        return this.id;
    }

    public final Uri getUri() {
        return this.uri;
    }

    public int hashCode() {
        int iHashCode = this.uri.hashCode() * 31;
        Long l10 = this.dateTaken;
        int iHashCode2 = (iHashCode + (l10 == null ? 0 : l10.hashCode())) * 31;
        String str = this.displayName;
        int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        Long l11 = this.id;
        int iHashCode4 = (iHashCode3 + (l11 == null ? 0 : l11.hashCode())) * 31;
        String str2 = this.folderName;
        return iHashCode4 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "AlbumImage(uri=" + this.uri + ", dateTaken=" + this.dateTaken + ", displayName=" + this.displayName + ", id=" + this.id + ", folderName=" + this.folderName + ")";
    }
}
