package cu.z17.views.spinner;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes7.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J'\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\f¨\u0006\u001c"}, d2 = {"Lcu/z17/views/spinner/Z17NameIdItem;", "", "stringId", "", "intId", "", "text", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getStringId", "()Ljava/lang/String;", "setStringId", "(Ljava/lang/String;)V", "getIntId", "()I", "setIntId", "(I)V", "getText", "setText", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "views_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class Z17NameIdItem {
    public static final int $stable = 8;
    private int intId;
    private String stringId;
    private String text;

    public Z17NameIdItem(String stringId, int i10, String text) {
        y.i(stringId, "stringId");
        y.i(text, "text");
        this.stringId = stringId;
        this.intId = i10;
        this.text = text;
    }

    public static /* synthetic */ Z17NameIdItem copy$default(Z17NameIdItem z17NameIdItem, String str, int i10, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = z17NameIdItem.stringId;
        }
        if ((i11 & 2) != 0) {
            i10 = z17NameIdItem.intId;
        }
        if ((i11 & 4) != 0) {
            str2 = z17NameIdItem.text;
        }
        return z17NameIdItem.copy(str, i10, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getStringId() {
        return this.stringId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getIntId() {
        return this.intId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getText() {
        return this.text;
    }

    public final Z17NameIdItem copy(String stringId, int intId, String text) {
        y.i(stringId, "stringId");
        y.i(text, "text");
        return new Z17NameIdItem(stringId, intId, text);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Z17NameIdItem)) {
            return false;
        }
        Z17NameIdItem z17NameIdItem = (Z17NameIdItem) other;
        return y.d(this.stringId, z17NameIdItem.stringId) && this.intId == z17NameIdItem.intId && y.d(this.text, z17NameIdItem.text);
    }

    public final int getIntId() {
        return this.intId;
    }

    public final String getStringId() {
        return this.stringId;
    }

    public final String getText() {
        return this.text;
    }

    public int hashCode() {
        return (((this.stringId.hashCode() * 31) + this.intId) * 31) + this.text.hashCode();
    }

    public final void setIntId(int i10) {
        this.intId = i10;
    }

    public final void setStringId(String str) {
        y.i(str, "<set-?>");
        this.stringId = str;
    }

    public final void setText(String str) {
        y.i(str, "<set-?>");
        this.text = str;
    }

    public String toString() {
        return "Z17NameIdItem(stringId=" + this.stringId + ", intId=" + this.intId + ", text=" + this.text + ")";
    }

    public /* synthetic */ Z17NameIdItem(String str, int i10, String str2, int i11, p pVar) {
        this((i11 & 1) != 0 ? "" : str, (i11 & 2) != 0 ? -1 : i10, str2);
    }
}
