package cu.todus.android.uiCompose.main.screen.manageStickers;

import androidx.compose.runtime.Immutable;
import kotlin.Metadata;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\r\u001a\u00020\u000eHÖ\u0081\u0004J\n\u0010\u000f\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcu/todus/android/uiCompose/main/screen/manageStickers/ManageStickersParams;", "", "pack", "", "<init>", "(Ljava/lang/String;)V", "getPack", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class ManageStickersParams {
    public static final int $stable = 0;
    private final String pack;

    /* JADX WARN: Multi-variable type inference failed */
    public ManageStickersParams() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ ManageStickersParams copy$default(ManageStickersParams manageStickersParams, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = manageStickersParams.pack;
        }
        return manageStickersParams.copy(str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getPack() {
        return this.pack;
    }

    public final ManageStickersParams copy(String pack) {
        y.i(pack, "pack");
        return new ManageStickersParams(pack);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof ManageStickersParams) && y.d(this.pack, ((ManageStickersParams) other).pack);
    }

    public final String getPack() {
        return this.pack;
    }

    public int hashCode() {
        return this.pack.hashCode();
    }

    public String toString() {
        return "ManageStickersParams(pack=" + this.pack + ")";
    }

    public ManageStickersParams(String pack) {
        y.i(pack, "pack");
        this.pack = pack;
    }

    public /* synthetic */ ManageStickersParams(String str, int i10, kotlin.jvm.internal.p pVar) {
        this((i10 & 1) != 0 ? "" : str);
    }
}
