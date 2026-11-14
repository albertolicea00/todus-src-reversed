package cu.todus.android.data.rest.entity;

import androidx.annotation.Keep;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 1)
@Keep
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcu/todus/android/data/rest/entity/Contact;", "", "mail", "", "phone", "site", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getMail", "()Ljava/lang/String;", "getPhone", "getSite", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class Contact {
    public static final int $stable = 0;
    private final String mail;
    private final String phone;
    private final String site;

    public Contact(String mail, String phone, String site) {
        y.i(mail, "mail");
        y.i(phone, "phone");
        y.i(site, "site");
        this.mail = mail;
        this.phone = phone;
        this.site = site;
    }

    public static /* synthetic */ Contact copy$default(Contact contact, String str, String str2, String str3, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = contact.mail;
        }
        if ((i10 & 2) != 0) {
            str2 = contact.phone;
        }
        if ((i10 & 4) != 0) {
            str3 = contact.site;
        }
        return contact.copy(str, str2, str3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getMail() {
        return this.mail;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getPhone() {
        return this.phone;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getSite() {
        return this.site;
    }

    public final Contact copy(String mail, String phone, String site) {
        y.i(mail, "mail");
        y.i(phone, "phone");
        y.i(site, "site");
        return new Contact(mail, phone, site);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Contact)) {
            return false;
        }
        Contact contact = (Contact) other;
        return y.d(this.mail, contact.mail) && y.d(this.phone, contact.phone) && y.d(this.site, contact.site);
    }

    public final String getMail() {
        return this.mail;
    }

    public final String getPhone() {
        return this.phone;
    }

    public final String getSite() {
        return this.site;
    }

    public int hashCode() {
        return (((this.mail.hashCode() * 31) + this.phone.hashCode()) * 31) + this.site.hashCode();
    }

    public String toString() {
        return "Contact(mail=" + this.mail + ", phone=" + this.phone + ", site=" + this.site + ")";
    }
}
