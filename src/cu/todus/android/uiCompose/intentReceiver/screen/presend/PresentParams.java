package cu.todus.android.uiCompose.intentReceiver.screen.presend;

import androidx.compose.runtime.Immutable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0004HÆ\u0003J-\u0010\u0013\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0004HÆ\u0001J\u0014\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0017\u001a\u00020\u0006HÖ\u0081\u0004J\n\u0010\u0018\u001a\u00020\u0004HÖ\u0081\u0004R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcu/todus/android/uiCompose/intentReceiver/screen/presend/PresentParams;", "", "ids", "", "", "type", "", "path", "<init>", "(Ljava/util/List;ILjava/lang/String;)V", "getIds", "()Ljava/util/List;", "getType", "()I", "getPath", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class PresentParams {
    public static final int $stable = 0;
    private final List<String> ids;
    private final String path;
    private final int type;

    public PresentParams(List<String> ids, int i10, String path) {
        y.i(ids, "ids");
        y.i(path, "path");
        this.ids = ids;
        this.type = i10;
        this.path = path;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PresentParams copy$default(PresentParams presentParams, List list, int i10, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            list = presentParams.ids;
        }
        if ((i11 & 2) != 0) {
            i10 = presentParams.type;
        }
        if ((i11 & 4) != 0) {
            str = presentParams.path;
        }
        return presentParams.copy(list, i10, str);
    }

    public final List<String> component1() {
        return this.ids;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getPath() {
        return this.path;
    }

    public final PresentParams copy(List<String> ids, int type, String path) {
        y.i(ids, "ids");
        y.i(path, "path");
        return new PresentParams(ids, type, path);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PresentParams)) {
            return false;
        }
        PresentParams presentParams = (PresentParams) other;
        return y.d(this.ids, presentParams.ids) && this.type == presentParams.type && y.d(this.path, presentParams.path);
    }

    public final List<String> getIds() {
        return this.ids;
    }

    public final String getPath() {
        return this.path;
    }

    public final int getType() {
        return this.type;
    }

    public int hashCode() {
        return (((this.ids.hashCode() * 31) + this.type) * 31) + this.path.hashCode();
    }

    public String toString() {
        return "PresentParams(ids=" + this.ids + ", type=" + this.type + ", path=" + this.path + ")";
    }
}
