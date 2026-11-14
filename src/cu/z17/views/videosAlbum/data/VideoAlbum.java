package cu.z17.views.videosAlbum.data;

import android.graphics.Bitmap;
import android.net.Uri;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes7.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÀ\u0003¢\u0006\u0004\b\u001d\u0010\u0012J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0012\u0010\u001f\u001a\u0004\u0018\u00010\u0005HÀ\u0003¢\u0006\u0004\b \u0010\u0012J\u0010\u0010!\u001a\u0004\u0018\u00010\u0007HÀ\u0003¢\u0006\u0002\b\"J\u0010\u0010#\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0012J\u000b\u0010$\u001a\u0004\u0018\u00010\fHÆ\u0003J`\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0002\u0010&J\u0013\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010*\u001a\u00020+HÖ\u0001J\t\u0010,\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0018\u0010\b\u001a\u0004\u0018\u00010\u0005X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0016\u0010\u0012R\u0016\u0010\t\u001a\u0004\u0018\u00010\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0015\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0018\u0010\u0012R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006-"}, d2 = {"Lcu/z17/views/videosAlbum/data/VideoAlbum;", "", "uri", "Landroid/net/Uri;", "dateTaken", "", "displayName", "", "id", "folderName", TypedValues.TransitionType.S_DURATION, "thumbnail", "Landroid/graphics/Bitmap;", "<init>", "(Landroid/net/Uri;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Landroid/graphics/Bitmap;)V", "getUri", "()Landroid/net/Uri;", "getDateTaken$views_release", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getDisplayName", "()Ljava/lang/String;", "getId$views_release", "getFolderName$views_release", "getDuration", "getThumbnail", "()Landroid/graphics/Bitmap;", "component1", "component2", "component2$views_release", "component3", "component4", "component4$views_release", "component5", "component5$views_release", "component6", "component7", "copy", "(Landroid/net/Uri;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Landroid/graphics/Bitmap;)Lcu/z17/views/videosAlbum/data/VideoAlbum;", "equals", "", "other", "hashCode", "", "toString", "views_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class VideoAlbum {
    public static final int $stable = 8;
    private final Long dateTaken;
    private final String displayName;
    private final Long duration;
    private final String folderName;
    private final Long id;
    private final Bitmap thumbnail;
    private final Uri uri;

    public VideoAlbum(Uri uri, Long l10, String str, Long l11, String str2, Long l12, Bitmap bitmap) {
        y.i(uri, "uri");
        this.uri = uri;
        this.dateTaken = l10;
        this.displayName = str;
        this.id = l11;
        this.folderName = str2;
        this.duration = l12;
        this.thumbnail = bitmap;
    }

    public static /* synthetic */ VideoAlbum copy$default(VideoAlbum videoAlbum, Uri uri, Long l10, String str, Long l11, String str2, Long l12, Bitmap bitmap, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            uri = videoAlbum.uri;
        }
        if ((i10 & 2) != 0) {
            l10 = videoAlbum.dateTaken;
        }
        if ((i10 & 4) != 0) {
            str = videoAlbum.displayName;
        }
        if ((i10 & 8) != 0) {
            l11 = videoAlbum.id;
        }
        if ((i10 & 16) != 0) {
            str2 = videoAlbum.folderName;
        }
        if ((i10 & 32) != 0) {
            l12 = videoAlbum.duration;
        }
        if ((i10 & 64) != 0) {
            bitmap = videoAlbum.thumbnail;
        }
        Long l13 = l12;
        Bitmap bitmap2 = bitmap;
        String str3 = str2;
        String str4 = str;
        return videoAlbum.copy(uri, l10, str4, l11, str3, l13, bitmap2);
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

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Long getDuration() {
        return this.duration;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Bitmap getThumbnail() {
        return this.thumbnail;
    }

    public final VideoAlbum copy(Uri uri, Long dateTaken, String displayName, Long id2, String folderName, Long duration, Bitmap thumbnail) {
        y.i(uri, "uri");
        return new VideoAlbum(uri, dateTaken, displayName, id2, folderName, duration, thumbnail);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VideoAlbum)) {
            return false;
        }
        VideoAlbum videoAlbum = (VideoAlbum) other;
        return y.d(this.uri, videoAlbum.uri) && y.d(this.dateTaken, videoAlbum.dateTaken) && y.d(this.displayName, videoAlbum.displayName) && y.d(this.id, videoAlbum.id) && y.d(this.folderName, videoAlbum.folderName) && y.d(this.duration, videoAlbum.duration) && y.d(this.thumbnail, videoAlbum.thumbnail);
    }

    public final Long getDateTaken$views_release() {
        return this.dateTaken;
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    public final Long getDuration() {
        return this.duration;
    }

    public final String getFolderName$views_release() {
        return this.folderName;
    }

    public final Long getId$views_release() {
        return this.id;
    }

    public final Bitmap getThumbnail() {
        return this.thumbnail;
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
        int iHashCode5 = (iHashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Long l12 = this.duration;
        int iHashCode6 = (iHashCode5 + (l12 == null ? 0 : l12.hashCode())) * 31;
        Bitmap bitmap = this.thumbnail;
        return iHashCode6 + (bitmap != null ? bitmap.hashCode() : 0);
    }

    public String toString() {
        return "VideoAlbum(uri=" + this.uri + ", dateTaken=" + this.dateTaken + ", displayName=" + this.displayName + ", id=" + this.id + ", folderName=" + this.folderName + ", duration=" + this.duration + ", thumbnail=" + this.thumbnail + ")";
    }

    public /* synthetic */ VideoAlbum(Uri uri, Long l10, String str, Long l11, String str2, Long l12, Bitmap bitmap, int i10, p pVar) {
        this(uri, l10, str, l11, str2, l12, (i10 & 64) != 0 ? null : bitmap);
    }
}
