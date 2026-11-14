package cu.todus.android.uiCompose.main.screen.chat.component;

import androidx.compose.runtime.Immutable;
import cu.todus.android.domain.handlers.Send;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0087\b\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J7\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001b\u001a\u00020\u0005HÖ\u0081\u0004J\n\u0010\u001c\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000f¨\u0006\u001e"}, d2 = {"Lcu/todus/android/uiCompose/main/screen/chat/component/ChatParams;", "", "uid", "", "type", "", ChatParams.TOSEND, "", "Lcu/todus/android/domain/handlers/Send;", "initialPosition", "<init>", "(Ljava/lang/String;ILjava/util/List;I)V", "getUid", "()Ljava/lang/String;", "getType", "()I", "getToSend", "()Ljava/util/List;", "getInitialPosition", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class ChatParams {
    public static final int $stable = 0;
    public static final String FROM_DIRECT_REPLY = "from_direct_reply";
    public static final String TOSEND = "toSend";
    public static final String TYPE = "type";
    public static final String UID = "uid";
    private final int initialPosition;
    private final List<Send> toSend;
    private final int type;
    private final String uid;

    public ChatParams(String uid, int i10, List<Send> toSend, int i11) {
        y.i(uid, "uid");
        y.i(toSend, "toSend");
        this.uid = uid;
        this.type = i10;
        this.toSend = toSend;
        this.initialPosition = i11;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ChatParams copy$default(ChatParams chatParams, String str, int i10, List list, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            str = chatParams.uid;
        }
        if ((i12 & 2) != 0) {
            i10 = chatParams.type;
        }
        if ((i12 & 4) != 0) {
            list = chatParams.toSend;
        }
        if ((i12 & 8) != 0) {
            i11 = chatParams.initialPosition;
        }
        return chatParams.copy(str, i10, list, i11);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getUid() {
        return this.uid;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getType() {
        return this.type;
    }

    public final List<Send> component3() {
        return this.toSend;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getInitialPosition() {
        return this.initialPosition;
    }

    public final ChatParams copy(String uid, int type, List<Send> toSend, int initialPosition) {
        y.i(uid, "uid");
        y.i(toSend, "toSend");
        return new ChatParams(uid, type, toSend, initialPosition);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChatParams)) {
            return false;
        }
        ChatParams chatParams = (ChatParams) other;
        return y.d(this.uid, chatParams.uid) && this.type == chatParams.type && y.d(this.toSend, chatParams.toSend) && this.initialPosition == chatParams.initialPosition;
    }

    public final int getInitialPosition() {
        return this.initialPosition;
    }

    public final List<Send> getToSend() {
        return this.toSend;
    }

    public final int getType() {
        return this.type;
    }

    public final String getUid() {
        return this.uid;
    }

    public int hashCode() {
        return (((((this.uid.hashCode() * 31) + this.type) * 31) + this.toSend.hashCode()) * 31) + this.initialPosition;
    }

    public String toString() {
        return "ChatParams(uid=" + this.uid + ", type=" + this.type + ", toSend=" + this.toSend + ", initialPosition=" + this.initialPosition + ")";
    }

    public /* synthetic */ ChatParams(String str, int i10, List list, int i11, int i12, p pVar) {
        this(str, i10, (i12 & 4) != 0 ? new ArrayList() : list, (i12 & 8) != 0 ? 0 : i11);
    }
}
