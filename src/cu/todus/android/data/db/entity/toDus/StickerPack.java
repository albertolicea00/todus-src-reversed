package cu.todus.android.data.db.entity.toDus;

import androidx.compose.runtime.Immutable;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import defpackage.l;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
@Entity(tableName = StickerPack.TABLE_NAME)
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0014\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0018\u001a\u00020\u0019HÖ\u0081\u0004J\n\u0010\u001a\u001a\u00020\u0003HÖ\u0081\u0004R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001c"}, d2 = {"Lcu/todus/android/data/db/entity/toDus/StickerPack;", "", "name", "", "title", "thumb", "createAt", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "getName", "()Ljava/lang/String;", "getTitle", "getThumb", "getCreateAt", "()J", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class StickerPack {
    public static final int $stable = 0;
    public static final String COLUMN_CREATE_AT = "createAt";
    public static final String COLUMN_NAME = "name";
    public static final String TABLE_NAME = "stickerPack";
    private final long createAt;

    @PrimaryKey
    private final String name;
    private final String thumb;
    private final String title;

    public StickerPack(String name, String title, String thumb, long j10) {
        y.i(name, "name");
        y.i(title, "title");
        y.i(thumb, "thumb");
        this.name = name;
        this.title = title;
        this.thumb = thumb;
        this.createAt = j10;
    }

    public static /* synthetic */ StickerPack copy$default(StickerPack stickerPack, String str, String str2, String str3, long j10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = stickerPack.name;
        }
        if ((i10 & 2) != 0) {
            str2 = stickerPack.title;
        }
        if ((i10 & 4) != 0) {
            str3 = stickerPack.thumb;
        }
        if ((i10 & 8) != 0) {
            j10 = stickerPack.createAt;
        }
        String str4 = str3;
        return stickerPack.copy(str, str2, str4, j10);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getThumb() {
        return this.thumb;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final long getCreateAt() {
        return this.createAt;
    }

    public final StickerPack copy(String name, String title, String thumb, long createAt) {
        y.i(name, "name");
        y.i(title, "title");
        y.i(thumb, "thumb");
        return new StickerPack(name, title, thumb, createAt);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StickerPack)) {
            return false;
        }
        StickerPack stickerPack = (StickerPack) other;
        return y.d(this.name, stickerPack.name) && y.d(this.title, stickerPack.title) && y.d(this.thumb, stickerPack.thumb) && this.createAt == stickerPack.createAt;
    }

    public final long getCreateAt() {
        return this.createAt;
    }

    public final String getName() {
        return this.name;
    }

    public final String getThumb() {
        return this.thumb;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        return (((((this.name.hashCode() * 31) + this.title.hashCode()) * 31) + this.thumb.hashCode()) * 31) + l.a(this.createAt);
    }

    public String toString() {
        return "StickerPack(name=" + this.name + ", title=" + this.title + ", thumb=" + this.thumb + ", createAt=" + this.createAt + ")";
    }

    public /* synthetic */ StickerPack(String str, String str2, String str3, long j10, int i10, p pVar) {
        this(str, str2, str3, (i10 & 8) != 0 ? new Date().getTime() : j10);
    }
}
