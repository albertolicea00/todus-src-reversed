package cu.todus.android.data.preferences;

import androidx.compose.runtime.Immutable;
import cu.todus.android.constants.Service;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;
import va.w;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0014\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0004HÖ\u0081\u0004R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0011"}, d2 = {"Lcu/todus/android/data/preferences/ReactionsSelected;", "", Service.Endpoint.LINKED_DEVICES_LIST, "", "", "<init>", "(Ljava/util/List;)V", "getList", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class ReactionsSelected {
    public static final int $stable = 0;
    private final List<String> list;

    /* JADX WARN: Multi-variable type inference failed */
    public ReactionsSelected() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ReactionsSelected copy$default(ReactionsSelected reactionsSelected, List list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = reactionsSelected.list;
        }
        return reactionsSelected.copy(list);
    }

    public final List<String> component1() {
        return this.list;
    }

    public final ReactionsSelected copy(List<String> list) {
        y.i(list, "list");
        return new ReactionsSelected(list);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof ReactionsSelected) && y.d(this.list, ((ReactionsSelected) other).list);
    }

    public final List<String> getList() {
        return this.list;
    }

    public int hashCode() {
        return this.list.hashCode();
    }

    public String toString() {
        return "ReactionsSelected(list=" + this.list + ")";
    }

    public ReactionsSelected(List<String> list) {
        y.i(list, "list");
        this.list = list;
    }

    public /* synthetic */ ReactionsSelected(List list, int i10, p pVar) {
        this((i10 & 1) != 0 ? w.n() : list);
    }
}
