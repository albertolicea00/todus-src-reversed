package cu.todus.android.data.db.pojo;

import androidx.compose.runtime.Immutable;
import androidx.room.Embedded;
import androidx.room.Relation;
import cu.todus.android.data.db.entity.toDus.Sticker;
import cu.todus.android.data.db.entity.toDus.StickerPack;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;
import va.w;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0014\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0016HÖ\u0081\u0004R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcu/todus/android/data/db/pojo/StickerGroup;", "", StickerPack.TABLE_NAME, "Lcu/todus/android/data/db/entity/toDus/StickerPack;", "items", "", "Lcu/todus/android/data/db/entity/toDus/Sticker;", "<init>", "(Lcu/todus/android/data/db/entity/toDus/StickerPack;Ljava/util/List;)V", "getStickerPack", "()Lcu/todus/android/data/db/entity/toDus/StickerPack;", "getItems", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class StickerGroup {
    public static final int $stable = 0;

    @Relation(entity = Sticker.class, entityColumn = Sticker.COLUMN_PACK_NAME, parentColumn = "name")
    private final List<Sticker> items;

    @Embedded
    private final StickerPack stickerPack;

    public StickerGroup(StickerPack stickerPack, List<Sticker> items) {
        y.i(stickerPack, "stickerPack");
        y.i(items, "items");
        this.stickerPack = stickerPack;
        this.items = items;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ StickerGroup copy$default(StickerGroup stickerGroup, StickerPack stickerPack, List list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            stickerPack = stickerGroup.stickerPack;
        }
        if ((i10 & 2) != 0) {
            list = stickerGroup.items;
        }
        return stickerGroup.copy(stickerPack, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final StickerPack getStickerPack() {
        return this.stickerPack;
    }

    public final List<Sticker> component2() {
        return this.items;
    }

    public final StickerGroup copy(StickerPack stickerPack, List<Sticker> items) {
        y.i(stickerPack, "stickerPack");
        y.i(items, "items");
        return new StickerGroup(stickerPack, items);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StickerGroup)) {
            return false;
        }
        StickerGroup stickerGroup = (StickerGroup) other;
        return y.d(this.stickerPack, stickerGroup.stickerPack) && y.d(this.items, stickerGroup.items);
    }

    public final List<Sticker> getItems() {
        return this.items;
    }

    public final StickerPack getStickerPack() {
        return this.stickerPack;
    }

    public int hashCode() {
        return (this.stickerPack.hashCode() * 31) + this.items.hashCode();
    }

    public String toString() {
        return "StickerGroup(stickerPack=" + this.stickerPack + ", items=" + this.items + ")";
    }

    public /* synthetic */ StickerGroup(StickerPack stickerPack, List list, int i10, p pVar) {
        this(stickerPack, (i10 & 2) != 0 ? w.n() : list);
    }
}
