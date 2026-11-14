package cu.todus.android.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import androidx.compose.runtime.internal.StabilityInferred;
import cu.todus.android.data.db.pojo.content.ContactContent;
import kotlin.Metadata;
import kotlin.jvm.internal.y;
import le.a0;
import le.d0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 1)
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcu/todus/android/utils/ContactUtil;", "", "<init>", "()V", "loadContact", "Lcu/todus/android/data/db/pojo/content/ContactContent;", "context", "Landroid/content/Context;", "contactData", "Landroid/net/Uri;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ContactUtil {
    public static final int $stable = 0;
    public static final ContactUtil INSTANCE = new ContactUtil();

    private ContactUtil() {
    }

    @SuppressLint({"Range"})
    public final ContactContent loadContact(Context context, Uri contactData) {
        String str;
        y.i(context, "context");
        y.i(contactData, "contactData");
        try {
            Cursor cursorQuery = context.getContentResolver().query(contactData, null, null, null, null);
            String string = "";
            if (cursorQuery == null || !cursorQuery.moveToFirst()) {
                str = "";
            } else {
                String string2 = cursorQuery.getString(cursorQuery.getColumnIndex("display_name"));
                y.h(string2, "getString(...)");
                if (string2.length() > 128) {
                    string2 = string2.substring(0, 128);
                    y.h(string2, "substring(...)");
                }
                String string3 = cursorQuery.getString(cursorQuery.getColumnIndex("_id"));
                Integer numValueOf = Integer.valueOf(cursorQuery.getString(cursorQuery.getColumnIndex("has_phone_number")));
                if (numValueOf != null && numValueOf.intValue() == 1) {
                    Cursor cursorQuery2 = context.getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, "contact_id = " + string3, null, null);
                    if (cursorQuery2 != null && cursorQuery2.moveToNext()) {
                        string = cursorQuery2.getString(cursorQuery2.getColumnIndex("data1"));
                        y.h(string, "getString(...)");
                        if (string.length() > 32) {
                            String strSubstring = string.substring(0, 32);
                            y.h(strSubstring, "substring(...)");
                            string = strSubstring;
                        }
                    }
                    if (cursorQuery2 != null) {
                        cursorQuery2.close();
                    }
                }
                str = string;
                string = string2;
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return new ContactContent(a0.O(a0.O(d0.q1(str).toString(), " ", "", false, 4, null), "-", "", false, 4, null), string, null, null, 12, null);
        } catch (Exception e10) {
            e10.printStackTrace();
            return null;
        }
    }
}
