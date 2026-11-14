package cu.todus.android.uiCompose.main.screen.chat.component;

import androidx.compose.runtime.Immutable;
import cu.todus.android.domain.handlers.Send;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0014\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcu/todus/android/uiCompose/main/screen/chat/component/SendToParams;", "", ChatParams.TOSEND, "", "Lcu/todus/android/domain/handlers/Send;", "<init>", "(Ljava/util/List;)V", "getToSend", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class SendToParams {
    public static final int $stable = 0;
    private final List<Send> toSend;

    public SendToParams(List<Send> toSend) {
        y.i(toSend, "toSend");
        this.toSend = toSend;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SendToParams copy$default(SendToParams sendToParams, List list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = sendToParams.toSend;
        }
        return sendToParams.copy(list);
    }

    public final List<Send> component1() {
        return this.toSend;
    }

    public final SendToParams copy(List<Send> toSend) {
        y.i(toSend, "toSend");
        return new SendToParams(toSend);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof SendToParams) && y.d(this.toSend, ((SendToParams) other).toSend);
    }

    public final List<Send> getToSend() {
        return this.toSend;
    }

    public int hashCode() {
        return this.toSend.hashCode();
    }

    public String toString() {
        return "SendToParams(toSend=" + this.toSend + ")";
    }
}
