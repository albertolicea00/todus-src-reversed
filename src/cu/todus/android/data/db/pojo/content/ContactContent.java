package cu.todus.android.data.db.pojo.content;

import androidx.compose.runtime.Immutable;
import cu.todus.android.data.db.entity.toDus.Contact;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0014\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0096\u0082\u0004J\n\u0010\u0012\u001a\u00020\u0013H\u0096\u0080\u0004J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J1\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\n\u0010\u0019\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u001a"}, d2 = {"Lcu/todus/android/data/db/pojo/content/ContactContent;", "Lcu/todus/android/data/db/pojo/content/Content;", "phone", "", Contact.COLUMN_FULL_NAME, Contact.COLUMN_PHONE_TYPE, "photo", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getPhone", "()Ljava/lang/String;", "getFName", "getPhoneType", "getPhoto", "equals", "", "other", "", "hashCode", "", "component1", "component2", "component3", "component4", "copy", "toString", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class ContactContent extends Content {
    public static final int $stable = 0;
    private final String fName;
    private final String phone;
    private final String phoneType;
    private final String photo;

    public ContactContent() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ ContactContent copy$default(ContactContent contactContent, String str, String str2, String str3, String str4, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = contactContent.phone;
        }
        if ((i10 & 2) != 0) {
            str2 = contactContent.fName;
        }
        if ((i10 & 4) != 0) {
            str3 = contactContent.phoneType;
        }
        if ((i10 & 8) != 0) {
            str4 = contactContent.photo;
        }
        return contactContent.copy(str, str2, str3, str4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getPhone() {
        return this.phone;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getFName() {
        return this.fName;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getPhoneType() {
        return this.phoneType;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getPhoto() {
        return this.photo;
    }

    public final ContactContent copy(String phone, String fName, String phoneType, String photo) {
        y.i(phone, "phone");
        y.i(fName, "fName");
        y.i(phoneType, "phoneType");
        y.i(photo, "photo");
        return new ContactContent(phone, fName, phoneType, photo);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ContactContent)) {
            return false;
        }
        ContactContent contactContent = (ContactContent) other;
        if (y.d(this.phone, contactContent.phone) && y.d(this.fName, contactContent.fName) && y.d(this.phoneType, contactContent.phoneType)) {
            return y.d(this.photo, contactContent.photo);
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

    public final String getPhoto() {
        return this.photo;
    }

    public int hashCode() {
        return (((((this.phone.hashCode() * 31) + this.fName.hashCode()) * 31) + this.phoneType.hashCode()) * 31) + this.photo.hashCode();
    }

    public String toString() {
        return "ContactContent(phone=" + this.phone + ", fName=" + this.fName + ", phoneType=" + this.phoneType + ", photo=" + this.photo + ")";
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContactContent(String phone, String fName, String phoneType, String photo) {
        super(6);
        y.i(phone, "phone");
        y.i(fName, "fName");
        y.i(phoneType, "phoneType");
        y.i(photo, "photo");
        this.phone = phone;
        this.fName = fName;
        this.phoneType = phoneType;
        this.photo = photo;
    }

    public /* synthetic */ ContactContent(String str, String str2, String str3, String str4, int i10, p pVar) {
        this((i10 & 1) != 0 ? "" : str, (i10 & 2) != 0 ? "" : str2, (i10 & 4) != 0 ? "" : str3, (i10 & 8) != 0 ? "" : str4);
    }
}
