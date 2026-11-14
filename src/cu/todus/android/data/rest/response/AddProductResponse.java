package cu.todus.android.data.rest.response;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 1)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0010\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0011\u001a\u00020\u0012HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcu/todus/android/data/rest/response/AddProductResponse;", "", "id", "", "version", "<init>", "(II)V", "getId", "()I", "getVersion", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class AddProductResponse {
    public static final int $stable = 0;
    private final int id;
    private final int version;

    public AddProductResponse(int i10, int i11) {
        this.id = i10;
        this.version = i11;
    }

    public static /* synthetic */ AddProductResponse copy$default(AddProductResponse addProductResponse, int i10, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = addProductResponse.id;
        }
        if ((i12 & 2) != 0) {
            i11 = addProductResponse.version;
        }
        return addProductResponse.copy(i10, i11);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getVersion() {
        return this.version;
    }

    public final AddProductResponse copy(int id2, int version) {
        return new AddProductResponse(id2, version);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AddProductResponse)) {
            return false;
        }
        AddProductResponse addProductResponse = (AddProductResponse) other;
        return this.id == addProductResponse.id && this.version == addProductResponse.version;
    }

    public final int getId() {
        return this.id;
    }

    public final int getVersion() {
        return this.version;
    }

    public int hashCode() {
        return (this.id * 31) + this.version;
    }

    public String toString() {
        return "AddProductResponse(id=" + this.id + ", version=" + this.version + ")";
    }
}
