package cu.todus.android.contact;

import ab.e;
import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.ContactsContract;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.content.ContextCompat;
import bb.b;
import cb.f;
import cb.m;
import cu.todus.android.data.db.entity.toDus.Contact;
import cu.z17.singledi.SingletonInitializer;
import hb.c;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;
import le.a0;
import le.d0;
import pe.d1;
import pe.i;
import pe.m0;
import ua.k0;
import ua.v;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0087@¢\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0010R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcu/todus/android/contact/ContactDataSource;", "", "Landroid/content/Context;", "context", "", "countryCode", "<init>", "(Landroid/content/Context;I)V", Contact.COLUMN_PHONE_TYPE, "", "getPhoneTypeLabel", "(I)Ljava/lang/String;", "", "Lcu/todus/android/data/db/entity/toDus/Contact;", "getContacts", "(Lab/e;)Ljava/lang/Object;", "Landroid/content/Context;", "I", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ContactDataSource {
    private final Context context;
    private final int countryCode;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private static final String[] projectionPhones = {"contact_id", "data1", "data2", "data3"};
    private static final String[] projectionNames = {"contact_id", "data2", "data3", "display_name", "data5", "photo_uri"};

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\bR\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\b¨\u0006\n"}, d2 = {"Lcu/todus/android/contact/ContactDataSource$Companion;", "Lcu/z17/singledi/SingletonInitializer;", "Lcu/todus/android/contact/ContactDataSource;", "<init>", "()V", "projectionPhones", "", "", "[Ljava/lang/String;", "projectionNames", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion extends SingletonInitializer<ContactDataSource> {
        public /* synthetic */ Companion(p pVar) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.contact.ContactDataSource$getContacts$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @f(c = "cu.todus.android.contact.ContactDataSource$getContacts$2", f = "ContactDataSource.kt", l = {}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lpe/m0;", "", "Lcu/todus/android/data/db/entity/toDus/Contact;", "<anonymous>", "(Lpe/m0;)Ljava/util/List;"}, k = 3, mv = {2, 3, 0})
    public static final class AnonymousClass2 extends m implements Function2 {
        int label;

        public AnonymousClass2(e<? super AnonymousClass2> eVar) {
            super(2, eVar);
        }

        @Override // cb.a
        public final e<k0> create(Object obj, e<?> eVar) {
            return ContactDataSource.this.new AnonymousClass2(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) throws IllegalAccessException, IOException, InvocationTargetException {
            b.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v.b(obj);
            HashMap map = new HashMap();
            if (ContextCompat.checkSelfPermission(ContactDataSource.this.context, "android.permission.READ_CONTACTS") == 0) {
                ContentResolver contentResolver = ContactDataSource.this.context.getContentResolver();
                y.h(contentResolver, "getContentResolver(...)");
                Cursor cursorQuery = contentResolver.query(ContactsContract.Contacts.CONTENT_URI, null, null, null, "display_name ASC");
                if (cursorQuery != null) {
                    ContactDataSource contactDataSource = ContactDataSource.this;
                    while (cursorQuery.moveToNext()) {
                        try {
                            try {
                                String string = cursorQuery.getString(cursorQuery.getColumnIndex("_id"));
                                String string2 = cursorQuery.getString(cursorQuery.getColumnIndex("display_name"));
                                Cursor cursorQuery2 = contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, "contact_id = ?", new String[]{string}, null);
                                if (cursorQuery2 != null) {
                                    while (cursorQuery2.moveToNext()) {
                                        try {
                                            String string3 = cursorQuery2.getString(cursorQuery2.getColumnIndex("data1"));
                                            int i10 = cursorQuery2.getInt(cursorQuery2.getColumnIndex("data2"));
                                            y.f(string3);
                                            if (!d0.q0(string3)) {
                                                y.f(string2);
                                                if (!d0.q0(string2)) {
                                                    y.f(string3);
                                                    if (!a0.U(string3, "+", false, 2, null)) {
                                                        string3 = contactDataSource.countryCode + string3;
                                                    }
                                                    String str = string3;
                                                    y.f(str);
                                                    String strO = a0.O(a0.O(a0.O(str, "+", "", false, 4, null), "-", "", false, 4, null), " ", "", false, 4, null);
                                                    map.put(strO, new Contact(strO, strO + "@im.todus.cu", string2, contactDataSource.getPhoneTypeLabel(i10), null, Contact.WAITING, 16, null));
                                                }
                                            }
                                        } catch (Throwable th2) {
                                            try {
                                                throw th2;
                                            } catch (Throwable th3) {
                                                c.a(cursorQuery2, th2);
                                                throw th3;
                                            }
                                        }
                                    }
                                    k0 k0Var = k0.f43947a;
                                    c.a(cursorQuery2, null);
                                } else {
                                    continue;
                                }
                            } catch (Exception e10) {
                                e10.printStackTrace();
                            }
                        } catch (Throwable th4) {
                            try {
                                throw th4;
                            } catch (Throwable th5) {
                                c.a(cursorQuery, th4);
                                throw th5;
                            }
                        }
                    }
                    k0 k0Var2 = k0.f43947a;
                    c.a(cursorQuery, null);
                }
            }
            ArrayList arrayList = new ArrayList(map.size());
            Iterator it = map.entrySet().iterator();
            while (it.hasNext()) {
                arrayList.add((Contact) ((Map.Entry) it.next()).getValue());
            }
            return arrayList;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(m0 m0Var, e<? super List<Contact>> eVar) {
            return ((AnonymousClass2) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
        }
    }

    public ContactDataSource(Context context, int i10) {
        y.i(context, "context");
        this.context = context;
        this.countryCode = i10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getPhoneTypeLabel(int phoneType) {
        if (phoneType == 1) {
            return "Home";
        }
        if (phoneType == 2) {
            return "Mobile";
        }
        if (phoneType != 3) {
            return phoneType != 7 ? "Unknown" : "Other";
        }
        return "Work";
    }

    @SuppressLint({"Range"})
    public final Object getContacts(e<? super List<Contact>> eVar) {
        return i.g(d1.b(), new AnonymousClass2(null), eVar);
    }
}
