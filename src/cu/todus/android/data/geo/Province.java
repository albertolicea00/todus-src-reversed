package cu.todus.android.data.geo;

import androidx.compose.runtime.Immutable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006HÆ\u0003J-\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006HÆ\u0001J\u0014\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0015\u001a\u00020\u0016HÖ\u0081\u0004J\n\u0010\u0017\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcu/todus/android/data/geo/Province;", "", "id", "", "name", "municipalities", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getId", "()Ljava/lang/String;", "getName", "getMunicipalities", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class Province {
    public static final int $stable = 0;
    private final String id;
    private final List<String> municipalities;
    private final String name;

    public Province(String id2, String name, List<String> municipalities) {
        y.i(id2, "id");
        y.i(name, "name");
        y.i(municipalities, "municipalities");
        this.id = id2;
        this.name = name;
        this.municipalities = municipalities;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Province copy$default(Province province, String str, String str2, List list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = province.id;
        }
        if ((i10 & 2) != 0) {
            str2 = province.name;
        }
        if ((i10 & 4) != 0) {
            list = province.municipalities;
        }
        return province.copy(str, str2, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public final List<String> component3() {
        return this.municipalities;
    }

    public final Province copy(String id2, String name, List<String> municipalities) {
        y.i(id2, "id");
        y.i(name, "name");
        y.i(municipalities, "municipalities");
        return new Province(id2, name, municipalities);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Province)) {
            return false;
        }
        Province province = (Province) other;
        return y.d(this.id, province.id) && y.d(this.name, province.name) && y.d(this.municipalities, province.municipalities);
    }

    public final String getId() {
        return this.id;
    }

    public final List<String> getMunicipalities() {
        return this.municipalities;
    }

    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        return (((this.id.hashCode() * 31) + this.name.hashCode()) * 31) + this.municipalities.hashCode();
    }

    public String toString() {
        return "Province(id=" + this.id + ", name=" + this.name + ", municipalities=" + this.municipalities + ")";
    }
}
