package cu.todus.android.data.db.pojo.content.statusContent;

import androidx.compose.runtime.Immutable;
import androidx.media3.extractor.text.ttml.TtmlNode;
import cu.todus.android.data.db.pojo.content.Content;
import kotlin.Metadata;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0083\u0004J\n\u0010\u0019\u001a\u00020\u0005HÖ\u0081\u0004J\n\u0010\u001a\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006\u001b"}, d2 = {"Lcu/todus/android/data/db/pojo/content/statusContent/StatusTextContent;", "Lcu/todus/android/data/db/pojo/content/Content;", "textContent", "", "fontColor", "", TtmlNode.ATTR_TTS_BACKGROUND_COLOR, "fontType", "<init>", "(Ljava/lang/String;III)V", "getTextContent", "()Ljava/lang/String;", "getFontColor", "()I", "getBackgroundColor", "getFontType", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class StatusTextContent extends Content {
    public static final int $stable = 0;
    private final int backgroundColor;
    private final int fontColor;
    private final int fontType;
    private final String textContent;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StatusTextContent(String textContent, int i10, int i11, int i12) {
        super(26);
        y.i(textContent, "textContent");
        this.textContent = textContent;
        this.fontColor = i10;
        this.backgroundColor = i11;
        this.fontType = i12;
    }

    public static /* synthetic */ StatusTextContent copy$default(StatusTextContent statusTextContent, String str, int i10, int i11, int i12, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            str = statusTextContent.textContent;
        }
        if ((i13 & 2) != 0) {
            i10 = statusTextContent.fontColor;
        }
        if ((i13 & 4) != 0) {
            i11 = statusTextContent.backgroundColor;
        }
        if ((i13 & 8) != 0) {
            i12 = statusTextContent.fontType;
        }
        return statusTextContent.copy(str, i10, i11, i12);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getTextContent() {
        return this.textContent;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getFontColor() {
        return this.fontColor;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getBackgroundColor() {
        return this.backgroundColor;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getFontType() {
        return this.fontType;
    }

    public final StatusTextContent copy(String textContent, int fontColor, int backgroundColor, int fontType) {
        y.i(textContent, "textContent");
        return new StatusTextContent(textContent, fontColor, backgroundColor, fontType);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StatusTextContent)) {
            return false;
        }
        StatusTextContent statusTextContent = (StatusTextContent) other;
        return y.d(this.textContent, statusTextContent.textContent) && this.fontColor == statusTextContent.fontColor && this.backgroundColor == statusTextContent.backgroundColor && this.fontType == statusTextContent.fontType;
    }

    public final int getBackgroundColor() {
        return this.backgroundColor;
    }

    public final int getFontColor() {
        return this.fontColor;
    }

    public final int getFontType() {
        return this.fontType;
    }

    public final String getTextContent() {
        return this.textContent;
    }

    public int hashCode() {
        return (((((this.textContent.hashCode() * 31) + this.fontColor) * 31) + this.backgroundColor) * 31) + this.fontType;
    }

    public String toString() {
        return "StatusTextContent(textContent=" + this.textContent + ", fontColor=" + this.fontColor + ", backgroundColor=" + this.backgroundColor + ", fontType=" + this.fontType + ")";
    }
}
