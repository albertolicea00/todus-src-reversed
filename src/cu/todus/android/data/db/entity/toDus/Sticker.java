package cu.todus.android.data.db.entity.toDus;

import androidx.camera.camera2.adapter.r;
import androidx.compose.runtime.Immutable;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import cu.todus.android.constants.Service;
import cu.todus.android.data.preferences.RootEnvironment;
import cu.todus.android.volatileState.AppVolatileState;
import defpackage.l;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
@Entity(foreignKeys = {@ForeignKey(childColumns = {Sticker.COLUMN_PACK_NAME}, entity = StickerPack.class, onDelete = 5, onUpdate = 5, parentColumns = {"name"})}, tableName = "sticker")
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0016\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u0000 #2\u00020\u0001:\u0001#B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u0006\u0010\u0016\u001a\u00020\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\bHÆ\u0003J\t\u0010\u001c\u001a\u00020\nHÆ\u0003JE\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0014\u0010\u001e\u001a\u00020\b2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010 \u001a\u00020!HÖ\u0081\u0004J\n\u0010\"\u001a\u00020\u0003HÖ\u0081\u0004R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006$"}, d2 = {"Lcu/todus/android/data/db/entity/toDus/Sticker;", "", "id", "", Sticker.COLUMN_PACK_NAME, "name", "folder", Sticker.COLUMN_FAVORITE, "", Sticker.COLUMN_LAST_USE, "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZJ)V", "getId", "()Ljava/lang/String;", "getPackName", "getName", "getFolder", "getFavorite", "()Z", "getLastUse", "()J", "getUrl", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class Sticker {
    public static final int $stable = 0;
    public static final String COLUMN_FAVORITE = "favorite";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_LAST_USE = "lastUse";
    public static final String COLUMN_PACK_NAME = "packName";
    public static final String TABLE_NAME = "sticker";
    private final boolean favorite;
    private final String folder;

    @PrimaryKey
    private final String id;
    private final long lastUse;
    private final String name;
    private final String packName;

    public Sticker(String id2, String packName, String name, String folder, boolean z10, long j10) {
        y.i(id2, "id");
        y.i(packName, "packName");
        y.i(name, "name");
        y.i(folder, "folder");
        this.id = id2;
        this.packName = packName;
        this.name = name;
        this.folder = folder;
        this.favorite = z10;
        this.lastUse = j10;
    }

    public static /* synthetic */ Sticker copy$default(Sticker sticker, String str, String str2, String str3, String str4, boolean z10, long j10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = sticker.id;
        }
        if ((i10 & 2) != 0) {
            str2 = sticker.packName;
        }
        if ((i10 & 4) != 0) {
            str3 = sticker.name;
        }
        if ((i10 & 8) != 0) {
            str4 = sticker.folder;
        }
        if ((i10 & 16) != 0) {
            z10 = sticker.favorite;
        }
        if ((i10 & 32) != 0) {
            j10 = sticker.lastUse;
        }
        long j11 = j10;
        boolean z11 = z10;
        String str5 = str3;
        return sticker.copy(str, str2, str5, str4, z11, j11);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getPackName() {
        return this.packName;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getFolder() {
        return this.folder;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getFavorite() {
        return this.favorite;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final long getLastUse() {
        return this.lastUse;
    }

    public final Sticker copy(String id2, String packName, String name, String folder, boolean favorite, long lastUse) {
        y.i(id2, "id");
        y.i(packName, "packName");
        y.i(name, "name");
        y.i(folder, "folder");
        return new Sticker(id2, packName, name, folder, favorite, lastUse);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Sticker)) {
            return false;
        }
        Sticker sticker = (Sticker) other;
        return y.d(this.id, sticker.id) && y.d(this.packName, sticker.packName) && y.d(this.name, sticker.name) && y.d(this.folder, sticker.folder) && this.favorite == sticker.favorite && this.lastUse == sticker.lastUse;
    }

    public final boolean getFavorite() {
        return this.favorite;
    }

    public final String getFolder() {
        return this.folder;
    }

    public final String getId() {
        return this.id;
    }

    public final long getLastUse() {
        return this.lastUse;
    }

    public final String getName() {
        return this.name;
    }

    public final String getPackName() {
        return this.packName;
    }

    public final String getUrl() {
        Service.ApplicationEnvironment applicationEnvironment;
        RootEnvironment rootEnvironment;
        Service service = Service.INSTANCE;
        AppVolatileState instanceOrNull = AppVolatileState.INSTANCE.getInstanceOrNull();
        if (instanceOrNull == null || (rootEnvironment = instanceOrNull.getRootEnvironment()) == null || (applicationEnvironment = rootEnvironment.getApplicationEnvironment()) == null) {
            applicationEnvironment = Service.ApplicationEnvironment.PROD_2;
        }
        return service.provideStickersUrl(applicationEnvironment) + this.id;
    }

    public int hashCode() {
        return (((((((((this.id.hashCode() * 31) + this.packName.hashCode()) * 31) + this.name.hashCode()) * 31) + this.folder.hashCode()) * 31) + r.a(this.favorite)) * 31) + l.a(this.lastUse);
    }

    public String toString() {
        return "Sticker(id=" + this.id + ", packName=" + this.packName + ", name=" + this.name + ", folder=" + this.folder + ", favorite=" + this.favorite + ", lastUse=" + this.lastUse + ")";
    }

    public /* synthetic */ Sticker(String str, String str2, String str3, String str4, boolean z10, long j10, int i10, p pVar) {
        this(str, str2, str3, str4, (i10 & 16) != 0 ? false : z10, (i10 & 32) != 0 ? 0L : j10);
    }
}
