package cu.todus.android.data.rest.entity;

import androidx.camera.camera2.adapter.r;
import androidx.compose.runtime.Immutable;
import cu.todus.android.constants.Service;
import cu.todus.android.data.preferences.RootEnvironment;
import cu.todus.android.volatileState.AppVolatileState;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;
import le.a0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u001c\b\u0087\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\rJ\u0006\u0010\u0018\u001a\u00020\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001d\u001a\u00020\tHÆ\u0003J\t\u0010\u001e\u001a\u00020\tHÆ\u0003J\t\u0010\u001f\u001a\u00020\u0007HÆ\u0003JO\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\u0007HÆ\u0001J\u0014\u0010!\u001a\u00020\u00072\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010#\u001a\u00020\tHÖ\u0081\u0004J\n\u0010$\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0011\u0010\u000b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013¨\u0006%"}, d2 = {"Lcu/todus/android/data/rest/entity/StickerPack;", "", "name", "", "title", "thumb", "animated", "", "count", "", "offset", "hasNext", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZIIZ)V", "getName", "()Ljava/lang/String;", "getTitle", "getThumb", "getAnimated", "()Z", "getCount", "()I", "getOffset", "getHasNext", "previewFileUrl", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "toString", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class StickerPack {
    public static final int $stable = 0;
    private final boolean animated;
    private final int count;
    private final boolean hasNext;
    private final String name;
    private final int offset;
    private final String thumb;
    private final String title;

    public StickerPack(String name, String title, String thumb, boolean z10, int i10, int i11, boolean z11) {
        y.i(name, "name");
        y.i(title, "title");
        y.i(thumb, "thumb");
        this.name = name;
        this.title = title;
        this.thumb = thumb;
        this.animated = z10;
        this.count = i10;
        this.offset = i11;
        this.hasNext = z11;
    }

    public static /* synthetic */ StickerPack copy$default(StickerPack stickerPack, String str, String str2, String str3, boolean z10, int i10, int i11, boolean z11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            str = stickerPack.name;
        }
        if ((i12 & 2) != 0) {
            str2 = stickerPack.title;
        }
        if ((i12 & 4) != 0) {
            str3 = stickerPack.thumb;
        }
        if ((i12 & 8) != 0) {
            z10 = stickerPack.animated;
        }
        if ((i12 & 16) != 0) {
            i10 = stickerPack.count;
        }
        if ((i12 & 32) != 0) {
            i11 = stickerPack.offset;
        }
        if ((i12 & 64) != 0) {
            z11 = stickerPack.hasNext;
        }
        int i13 = i11;
        boolean z12 = z11;
        int i14 = i10;
        String str4 = str3;
        return stickerPack.copy(str, str2, str4, z10, i14, i13, z12);
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
    public final boolean getAnimated() {
        return this.animated;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getCount() {
        return this.count;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getOffset() {
        return this.offset;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getHasNext() {
        return this.hasNext;
    }

    public final StickerPack copy(String name, String title, String thumb, boolean animated, int count, int offset, boolean hasNext) {
        y.i(name, "name");
        y.i(title, "title");
        y.i(thumb, "thumb");
        return new StickerPack(name, title, thumb, animated, count, offset, hasNext);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StickerPack)) {
            return false;
        }
        StickerPack stickerPack = (StickerPack) other;
        return y.d(this.name, stickerPack.name) && y.d(this.title, stickerPack.title) && y.d(this.thumb, stickerPack.thumb) && this.animated == stickerPack.animated && this.count == stickerPack.count && this.offset == stickerPack.offset && this.hasNext == stickerPack.hasNext;
    }

    public final boolean getAnimated() {
        return this.animated;
    }

    public final int getCount() {
        return this.count;
    }

    public final boolean getHasNext() {
        return this.hasNext;
    }

    public final String getName() {
        return this.name;
    }

    public final int getOffset() {
        return this.offset;
    }

    public final String getThumb() {
        return this.thumb;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        return (((((((((((this.name.hashCode() * 31) + this.title.hashCode()) * 31) + this.thumb.hashCode()) * 31) + r.a(this.animated)) * 31) + this.count) * 31) + this.offset) * 31) + r.a(this.hasNext);
    }

    public final String previewFileUrl() {
        Service.ApplicationEnvironment applicationEnvironment;
        RootEnvironment rootEnvironment;
        Service service = Service.INSTANCE;
        AppVolatileState instanceOrNull = AppVolatileState.INSTANCE.getInstanceOrNull();
        if (instanceOrNull == null || (rootEnvironment = instanceOrNull.getRootEnvironment()) == null || (applicationEnvironment = rootEnvironment.getApplicationEnvironment()) == null) {
            applicationEnvironment = Service.ApplicationEnvironment.PROD_2;
        }
        return service.provideStickersUrl(applicationEnvironment) + a0.O(this.thumb, ".tgs", ".json", false, 4, null);
    }

    public String toString() {
        return "StickerPack(name=" + this.name + ", title=" + this.title + ", thumb=" + this.thumb + ", animated=" + this.animated + ", count=" + this.count + ", offset=" + this.offset + ", hasNext=" + this.hasNext + ")";
    }

    public /* synthetic */ StickerPack(String str, String str2, String str3, boolean z10, int i10, int i11, boolean z11, int i12, p pVar) {
        this(str, str2, str3, (i12 & 8) != 0 ? true : z10, (i12 & 16) != 0 ? 1 : i10, (i12 & 32) != 0 ? 0 : i11, (i12 & 64) != 0 ? true : z11);
    }
}
