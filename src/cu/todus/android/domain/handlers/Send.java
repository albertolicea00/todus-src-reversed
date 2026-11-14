package cu.todus.android.domain.handlers;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.compose.runtime.internal.StabilityInferred;
import cu.todus.android.uiCompose.main.screen.chat.component.ChatParams;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 1)
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0016\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u0006\u0010\nJ\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\u0010R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0015\u001a\u0004\b\u0016\u0010\u0012¨\u0006\u0018"}, d2 = {"Lcu/todus/android/domain/handlers/Send;", "Landroid/os/Parcelable;", "", "type", "", ChatParams.TOSEND, "<init>", "(ILjava/lang/String;)V", "Landroid/os/Parcel;", "parcel", "(Landroid/os/Parcel;)V", "flags", "Lua/k0;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "toString", "()Ljava/lang/String;", "I", "getType", "Ljava/lang/String;", "getToSend", "CREATOR", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class Send implements Parcelable {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: CREATOR, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int FORWARD_MESSAGE = 3;
    public static final int SHARE_AUDIO = 5;
    public static final int SHARE_CATALOG = 8;
    public static final int SHARE_FILE = 6;
    public static final int SHARE_IMAGE = 2;
    public static final int SHARE_NEW_MESSAGE = 9;
    public static final int SHARE_PAYMENT = 7;
    public static final int SHARE_TEXT = 1;
    public static final int SHARE_VIDEO = 4;
    private final String toSend;
    private final int type;

    /* JADX INFO: renamed from: cu.todus.android.domain.handlers.Send$CREATOR, reason: from kotlin metadata */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001d\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¢\u0006\u0002\u0010\fR\u000e\u0010\r\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcu/todus/android/domain/handlers/Send$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcu/todus/android/domain/handlers/Send;", "<init>", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcu/todus/android/domain/handlers/Send;", "SHARE_TEXT", "SHARE_IMAGE", "FORWARD_MESSAGE", "SHARE_VIDEO", "SHARE_AUDIO", "SHARE_FILE", "SHARE_PAYMENT", "SHARE_CATALOG", "SHARE_NEW_MESSAGE", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion implements Parcelable.Creator<Send> {
        public /* synthetic */ Companion(p pVar) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Send createFromParcel(Parcel parcel) {
            y.i(parcel, "parcel");
            return new Send(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Send[] newArray(int size) {
            return new Send[size];
        }
    }

    public Send(int i10, String toSend) {
        y.i(toSend, "toSend");
        this.type = i10;
        this.toSend = toSend;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final String getToSend() {
        return this.toSend;
    }

    public final int getType() {
        return this.type;
    }

    public String toString() {
        return "Send(type=" + this.type + ", toSend='" + this.toSend + "')";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        y.i(parcel, "parcel");
        parcel.writeInt(this.type);
        parcel.writeString(this.toSend);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public Send(Parcel parcel) {
        y.i(parcel, "parcel");
        int i10 = parcel.readInt();
        String string = parcel.readString();
        this(i10, string == null ? "" : string);
    }
}
