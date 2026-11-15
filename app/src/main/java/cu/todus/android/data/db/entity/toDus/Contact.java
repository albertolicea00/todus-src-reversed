package cu.todus.android.data.db.entity.toDus;

import androidx.compose.runtime.Immutable;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import java.util.Objects;

/**
 * Room entity representing a synchronized address-book contact entry.
 *
 * @obfuscated_class cu.todus.android.data.db.entity.toDus.Contact
 */
@Immutable
@Entity(tableName = Contact.TABLE_NAME)
public final class Contact {

    public static final String TABLE_NAME = "contact";

    public static final String COLUMN_PHONE = "phone";
    public static final String COLUMN_UID = "uid";
    public static final String COLUMN_FULL_NAME = "fName";
    public static final String COLUMN_PHONE_TYPE = "phoneType";
    public static final String COLUMN_PHOTO_URI = "photoUri";
    public static final String COLUMN_STATE = "state";

    public static final String UPLOADED = "uploaded";
    public static final String WAITING = "waiting";
    public static final String PENDING_DELETE = "pending_delete";

    @PrimaryKey
    private final String phone;
    private final String uid;
    private final String fName;
    private final String phoneType;
    private final String photoUri;
    private final String state;

    public Contact(String phone, String uid, String fName) {
        this(phone, uid, fName, "", "", UPLOADED);
    }

    public Contact(
            String phone,
            String uid,
            String fName,
            String phoneType,
            String photoUri,
            String state
    ) {
        this.phone = Objects.requireNonNull(phone, "phone");
        this.uid = Objects.requireNonNull(uid, "uid");
        this.fName = Objects.requireNonNull(fName, "fName");
        this.phoneType = Objects.requireNonNull(phoneType, "phoneType");
        this.photoUri = Objects.requireNonNull(photoUri, "photoUri");
        this.state = state;
    }

    public String getPhone() {
        return phone;
    }

    public String getUid() {
        return uid;
    }

    public String getFName() {
        return fName;
    }

    public String getPhoneType() {
        return phoneType;
    }

    public String getPhotoUri() {
        return photoUri;
    }

    public String getState() {
        return state;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || Contact.class != other.getClass()) {
            return false;
        }
        Contact that = (Contact) other;
        return Objects.equals(phone, that.phone)
                && Objects.equals(fName, that.fName)
                && Objects.equals(phoneType, that.phoneType)
                && Objects.equals(photoUri, that.photoUri);
    }

    @Override
    public int hashCode() {
        return Objects.hash(phone, fName, phoneType, photoUri);
    }

    @Override
    public String toString() {
        return "Contact(phone=" + phone
                + ", uid=" + uid
                + ", fName=" + fName
                + ", phoneType=" + phoneType
                + ", photoUri=" + photoUri
                + ", state=" + state + ")";
    }
}
