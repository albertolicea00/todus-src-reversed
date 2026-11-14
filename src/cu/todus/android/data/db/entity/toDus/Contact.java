package cu.todus.android.data.db.entity.toDus;

import androidx.compose.runtime.Immutable;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
@Entity
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0087\b\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\t\u0010\nJ\u0014\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H\u0096\u0082\u0004J\n\u0010\u0015\u001a\u00020\u0016H\u0096\u0080\u0004J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003JG\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\n\u0010\u001e\u001a\u00020\u0003HÖ\u0081\u0004R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006 "}, d2 = {"Lcu/todus/android/data/db/entity/toDus/Contact;", "", "phone", "", "uid", Contact.COLUMN_FULL_NAME, Contact.COLUMN_PHONE_TYPE, Contact.COLUMN_PHOTO_URI, "state", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getPhone", "()Ljava/lang/String;", "getUid", "getFName", "getPhoneType", "getPhotoUri", "getState", "equals", "", "other", "hashCode", "", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "toString", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class Contact {
    public static final int $stable = 0;
    public static final String COLUMN_FULL_NAME = "fName";
    public static final String COLUMN_PHONE = "phone";
    public static final String COLUMN_PHONE_TYPE = "phoneType";
    public static final String COLUMN_PHOTO_URI = "photoUri";
    public static final String COLUMN_STATE = "state";
    public static final String COLUMN_UID = "uid";
    public static final String PENDING_DELETE = "pending_delete";
    public static final String TABLE_NAME = "contact";
    public static final String UPLOADED = "uploaded";
    public static final String WAITING = "waiting";
    private final String fName;

    @PrimaryKey
    private final String phone;
    private final String phoneType;
    private final String photoUri;
    private final String state;
    private final String uid;

    public Contact(String phone, String uid, String fName, String phoneType, String photoUri, String str) {
        y.i(phone, "phone");
        y.i(uid, "uid");
        y.i(fName, "fName");
        y.i(phoneType, "phoneType");
        y.i(photoUri, "photoUri");
        this.phone = phone;
        this.uid = uid;
        this.fName = fName;
        this.phoneType = phoneType;
        this.photoUri = photoUri;
        this.state = str;
    }

    public static /* synthetic */ Contact copy$default(Contact contact, String str, String str2, String str3, String str4, String str5, String str6, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = contact.phone;
        }
        if ((i10 & 2) != 0) {
            str2 = contact.uid;
        }
        if ((i10 & 4) != 0) {
            str3 = contact.fName;
        }
        if ((i10 & 8) != 0) {
            str4 = contact.phoneType;
        }
        if ((i10 & 16) != 0) {
            str5 = contact.photoUri;
        }
        if ((i10 & 32) != 0) {
            str6 = contact.state;
        }
        String str7 = str5;
        String str8 = str6;
        return contact.copy(str, str2, str3, str4, str7, str8);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getPhone() {
        return this.phone;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getUid() {
        return this.uid;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getFName() {
        return this.fName;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getPhoneType() {
        return this.phoneType;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getPhotoUri() {
        return this.photoUri;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getState() {
        return this.state;
    }

    public final Contact copy(String phone, String uid, String fName, String phoneType, String photoUri, String state) {
        y.i(phone, "phone");
        y.i(uid, "uid");
        y.i(fName, "fName");
        y.i(phoneType, "phoneType");
        y.i(photoUri, "photoUri");
        return new Contact(phone, uid, fName, phoneType, photoUri, state);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!y.d(Contact.class, other != null ? other.getClass() : null)) {
            return false;
        }
        y.g(other, "null cannot be cast to non-null type cu.todus.android.data.db.entity.toDus.Contact");
        Contact contact = (Contact) other;
        if (y.d(this.phone, contact.phone) && y.d(this.fName, contact.fName) && y.d(this.phoneType, contact.phoneType)) {
            return y.d(this.photoUri, contact.photoUri);
        }
        return false;
    }

    public final String getFName() {
        return this.fName;
    }

    public final String getPhone() {
        return this.phone;
    }

    public final String getPhoneType() {
        return this.phoneType;
    }

    public final String getPhotoUri() {
        return this.photoUri;
    }

    public final String getState() {
        return this.state;
    }

    public final String getUid() {
        return this.uid;
    }

    public int hashCode() {
        return (((((this.phone.hashCode() * 31) + this.fName.hashCode()) * 31) + this.phoneType.hashCode()) * 31) + this.photoUri.hashCode();
    }

    public String toString() {
        return "Contact(phone=" + this.phone + ", uid=" + this.uid + ", fName=" + this.fName + ", phoneType=" + this.phoneType + ", photoUri=" + this.photoUri + ", state=" + this.state + ")";
    }

    public /* synthetic */ Contact(String str, String str2, String str3, String str4, String str5, String str6, int i10, p pVar) {
        this(str, str2, str3, (i10 & 8) != 0 ? "" : str4, (i10 & 16) != 0 ? "" : str5, (i10 & 32) != 0 ? UPLOADED : str6);
    }
}
