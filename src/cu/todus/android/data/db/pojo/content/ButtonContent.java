package cu.todus.android.data.db.pojo.content;

import androidx.compose.runtime.Immutable;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\n\b\u0017\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcu/todus/android/data/db/pojo/content/ButtonContent;", "Lcu/todus/android/data/db/pojo/content/Content;", "btnTitle", "", "btnDesc", "msgCmd", "msgContent", "btnSize", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;F)V", "getBtnTitle", "()Ljava/lang/String;", "getBtnDesc", "getMsgCmd", "getMsgContent", "getBtnSize", "()F", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public class ButtonContent extends Content {
    public static final int $stable = 0;
    private final String btnDesc;
    private final float btnSize;
    private final String btnTitle;
    private final String msgCmd;
    private final String msgContent;

    public ButtonContent() {
        this(null, null, null, null, 0.0f, 31, null);
    }

    public final String getBtnDesc() {
        return this.btnDesc;
    }

    public final float getBtnSize() {
        return this.btnSize;
    }

    public final String getBtnTitle() {
        return this.btnTitle;
    }

    public final String getMsgCmd() {
        return this.msgCmd;
    }

    public final String getMsgContent() {
        return this.msgContent;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ButtonContent(String btnTitle, String btnDesc, String msgCmd, String msgContent, float f10) {
        super(21);
        y.i(btnTitle, "btnTitle");
        y.i(btnDesc, "btnDesc");
        y.i(msgCmd, "msgCmd");
        y.i(msgContent, "msgContent");
        this.btnTitle = btnTitle;
        this.btnDesc = btnDesc;
        this.msgCmd = msgCmd;
        this.msgContent = msgContent;
        this.btnSize = f10;
    }

    public /* synthetic */ ButtonContent(String str, String str2, String str3, String str4, float f10, int i10, p pVar) {
        this((i10 & 1) != 0 ? "" : str, (i10 & 2) != 0 ? "" : str2, (i10 & 4) != 0 ? "" : str3, (i10 & 8) != 0 ? "" : str4, (i10 & 16) != 0 ? 0.82f : f10);
    }
}
