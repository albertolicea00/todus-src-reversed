package cu.todus.android.data.rest.entity;

import androidx.annotation.Keep;
import androidx.compose.runtime.internal.StabilityInferred;
import cu.todus.android.data.db.entity.toDus.User;
import kotlin.Metadata;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 1)
@Keep
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0018\u001a\u00020\u0019HÖ\u0081\u0004J\n\u0010\u001a\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001b"}, d2 = {"Lcu/todus/android/data/rest/entity/Info;", "", User.COLUMN_ALIAS, "", "contact", "Lcu/todus/android/data/rest/entity/Contact;", "description", "name", "<init>", "(Ljava/lang/String;Lcu/todus/android/data/rest/entity/Contact;Ljava/lang/String;Ljava/lang/String;)V", "getAlias", "()Ljava/lang/String;", "getContact", "()Lcu/todus/android/data/rest/entity/Contact;", "getDescription", "getName", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class Info {
    public static final int $stable = 0;
    private final String alias;
    private final Contact contact;
    private final String description;
    private final String name;

    public Info(String alias, Contact contact, String description, String name) {
        y.i(alias, "alias");
        y.i(contact, "contact");
        y.i(description, "description");
        y.i(name, "name");
        this.alias = alias;
        this.contact = contact;
        this.description = description;
        this.name = name;
    }

    public static /* synthetic */ Info copy$default(Info info, String str, Contact contact, String str2, String str3, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = info.alias;
        }
        if ((i10 & 2) != 0) {
            contact = info.contact;
        }
        if ((i10 & 4) != 0) {
            str2 = info.description;
        }
        if ((i10 & 8) != 0) {
            str3 = info.name;
        }
        return info.copy(str, contact, str2, str3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getAlias() {
        return this.alias;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Contact getContact() {
        return this.contact;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public final Info copy(String alias, Contact contact, String description, String name) {
        y.i(alias, "alias");
        y.i(contact, "contact");
        y.i(description, "description");
        y.i(name, "name");
        return new Info(alias, contact, description, name);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Info)) {
            return false;
        }
        Info info = (Info) other;
        return y.d(this.alias, info.alias) && y.d(this.contact, info.contact) && y.d(this.description, info.description) && y.d(this.name, info.name);
    }

    public final String getAlias() {
        return this.alias;
    }

    public final Contact getContact() {
        return this.contact;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        return (((((this.alias.hashCode() * 31) + this.contact.hashCode()) * 31) + this.description.hashCode()) * 31) + this.name.hashCode();
    }

    public String toString() {
        return "Info(alias=" + this.alias + ", contact=" + this.contact + ", description=" + this.description + ", name=" + this.name + ")";
    }
}
