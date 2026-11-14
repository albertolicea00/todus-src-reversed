package cu.todus.android.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.ContactsContract;
import androidx.autofill.HintConstants;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.core.net.UriKt;
import androidx.fragment.app.Fragment;
import cu.todus.android.R;
import cu.todus.android.data.db.pojo.content.EventContent;
import cu.todus.android.data.db.pojo.content.TemplateContent;
import cu.todus.android.data.paths.DirectoryPaths;
import cu.todus.android.data.util.MediaUtil;
import cu.todus.android.di.MainModule;
import cu.todus.android.repositories.MainRepository;
import cu.todus.android.uiCompose.shared.insideNotification.Cause;
import cu.todus.android.uiCompose.shared.insideNotification.InsideNotificationState;
import cu.z17.singledi.SinglediException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.y;
import le.a0;
import le.d0;
import ua.k0;
import va.w;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 1)
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J7\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u0006¢\u0006\u0004\b\u0012\u0010\u0013J\u001d\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0006¢\u0006\u0004\b\u0015\u0010\u0013J\u001d\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u0006¢\u0006\u0004\b\u0017\u0010\u0013J3\u0010\u001b\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0018\u001a\u00020\u00062\b\b\u0002\u0010\u0019\u001a\u00020\u00062\b\b\u0002\u0010\u001a\u001a\u00020\u0006¢\u0006\u0004\b\u001b\u0010\u001cJ\u001d\u0010\u001f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u001f\u0010 J\u001d\u0010#\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020!¢\u0006\u0004\b#\u0010$J\u001d\u0010'\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020%¢\u0006\u0004\b'\u0010(J\u0015\u0010+\u001a\u00020\f2\u0006\u0010*\u001a\u00020)¢\u0006\u0004\b+\u0010,J\r\u0010.\u001a\u00020-¢\u0006\u0004\b.\u0010/J\r\u00100\u001a\u00020!¢\u0006\u0004\b0\u00101J\u001d\u00103\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u00102\u001a\u00020\u0006¢\u0006\u0004\b3\u0010\u0013J\u001d\u00106\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u00105\u001a\u000204¢\u0006\u0004\b6\u00107J%\u00109\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u00108\u001a\u00020\u0006¢\u0006\u0004\b9\u0010:J\u001d\u0010<\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010;\u001a\u00020\u0006¢\u0006\u0004\b<\u0010\u0013J9\u0010@\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f2\"\u0010?\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010%0>0=¢\u0006\u0004\b@\u0010A¨\u0006B"}, d2 = {"Lcu/todus/android/utils/IntentUtil;", "", "<init>", "()V", "Landroidx/fragment/app/Fragment;", "fragment", "", "type", "", "extraMimeType", "", "requestCode", "Lua/k0;", "selectMediaType", "(Landroidx/fragment/app/Fragment;Ljava/lang/String;[Ljava/lang/String;I)V", "Landroid/content/Context;", "context", "msg", "sendInvitation", "(Landroid/content/Context;Ljava/lang/String;)V", TemplateContent.NUMBER_TYPE, "openSendText", "url", "showWeb", "name", "phone", "title", "addContact", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Lcu/todus/android/data/db/pojo/content/EventContent;", "event", "addEvent", "(Landroid/content/Context;Lcu/todus/android/data/db/pojo/content/EventContent;)V", "Ljava/io/File;", "path", "open", "(Landroid/content/Context;Ljava/io/File;)V", "Landroid/net/Uri;", "uri", "openUri", "(Landroid/content/Context;Landroid/net/Uri;)V", "Landroid/app/Activity;", "activity", "openDownloads", "(Landroid/app/Activity;)V", "", "isSamsung", "()Z", "getDownloadsFile", "()Ljava/io/File;", "cell", "operatorCall", "Landroid/graphics/Bitmap;", "combineImages", "shareBitmap", "(Landroid/content/Context;Landroid/graphics/Bitmap;)V", "text", "shareText", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V", HintConstants.AUTOFILL_HINT_PHONE_NUMBER, "openContactCard", "", "Lua/y;", "itemToShare", "shareMessages", "(Landroid/content/Context;Ljava/util/List;)V", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class IntentUtil {
    public static final int $stable = 0;
    public static final IntentUtil INSTANCE = new IntentUtil();

    private IntentUtil() {
    }

    public static /* synthetic */ void addContact$default(IntentUtil intentUtil, Context context, String str, String str2, String str3, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str = "";
        }
        if ((i10 & 4) != 0) {
            str2 = "";
        }
        if ((i10 & 8) != 0) {
            str3 = "";
        }
        intentUtil.addContact(context, str, str2, str3);
    }

    private final void selectMediaType(Fragment fragment, String type, String[] extraMimeType, int requestCode) {
        Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType(type);
        fragment.startActivityForResult(intent, requestCode);
    }

    public static /* synthetic */ void sendInvitation$default(IntentUtil intentUtil, Context context, String str, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str = "";
        }
        intentUtil.sendInvitation(context, str);
    }

    public final void addContact(Context context, String name, String phone, String title) {
        y.i(context, "context");
        y.i(name, "name");
        y.i(phone, "phone");
        y.i(title, "title");
        try {
            Intent intent = new Intent("android.intent.action.INSERT");
            intent.setType("vnd.android.cursor.dir/contact");
            intent.putExtra("finishActivityOnSaveCompleted", true);
            intent.putExtra("phone", phone);
            intent.putExtra("name", name);
            intent.putExtra("job_title", title);
            context.startActivity(intent);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public final void addEvent(Context context, EventContent event) throws IllegalAccessException, SinglediException, IOException, InvocationTargetException {
        y.i(context, "context");
        y.i(event, "event");
        File newFile$default = DirectoryPaths.getNewFile$default(DirectoryPaths.INSTANCE.getInstance(), "cita" + Calendar.getInstance().getTimeInMillis() + ".ics", null, 2, null);
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(newFile$default), le.c.f37236b), 8192);
        try {
            bufferedWriter.write(event.getIcs());
            k0 k0Var = k0.f43947a;
            hb.c.a(bufferedWriter, null);
            File absoluteFile = newFile$default.getAbsoluteFile();
            y.h(absoluteFile, "getAbsoluteFile(...)");
            open(context, absoluteFile);
        } catch (Throwable th2) {
            try {
                throw th2;
            } catch (Throwable th3) {
                hb.c.a(bufferedWriter, th2);
                throw th3;
            }
        }
    }

    public final File getDownloadsFile() {
        File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        y.h(externalStoragePublicDirectory, "getExternalStoragePublicDirectory(...)");
        return externalStoragePublicDirectory;
    }

    public final boolean isSamsung() {
        String str = Build.MANUFACTURER;
        if (str == null) {
            return false;
        }
        Locale locale = Locale.getDefault();
        y.h(locale, "getDefault(...)");
        String lowerCase = str.toLowerCase(locale);
        y.h(lowerCase, "toLowerCase(...)");
        return y.d(lowerCase, "samsung");
    }

    public final void open(Context context, File path) {
        y.i(context, "context");
        y.i(path, "path");
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setFlags(3);
        try {
            Uri uriForFile = FileProvider.getUriForFile(context, context.getString(R.string.content_provider), path);
            MediaUtil mediaUtil = MediaUtil.INSTANCE;
            y.f(uriForFile);
            intent.setDataAndType(uriForFile, mediaUtil.getMimeType(context, uriForFile));
            if (intent.resolveActivity(context.getPackageManager()) != null) {
                context.startActivity(intent);
                return;
            }
            MainRepository instanceOrNull = MainRepository.INSTANCE.getInstanceOrNull();
            if (instanceOrNull != null) {
                String string = UUID.randomUUID().toString();
                y.h(string, "toString(...)");
                String strO = a0.O(string, "-", "", false, 4, null);
                Cause cause = Cause.ERROR;
                String string2 = MainModule.INSTANCE.getInstance().getAppContext().getString(R.string.no_app_available_for_open_file);
                y.h(string2, "getString(...)");
                instanceOrNull.addNewNotification(new InsideNotificationState(strO, cause, string2));
            }
        } catch (Exception e10) {
            e10.printStackTrace();
            MainRepository instanceOrNull2 = MainRepository.INSTANCE.getInstanceOrNull();
            if (instanceOrNull2 != null) {
                String string3 = UUID.randomUUID().toString();
                y.h(string3, "toString(...)");
                String strO2 = a0.O(string3, "-", "", false, 4, null);
                Cause cause2 = Cause.ERROR;
                String string4 = MainModule.INSTANCE.getInstance().getAppContext().getString(R.string.cant_open_file);
                y.h(string4, "getString(...)");
                instanceOrNull2.addNewNotification(new InsideNotificationState(strO2, cause2, string4));
            }
        }
    }

    public final void openContactCard(Context context, String phoneNumber) {
        y.i(context, "context");
        y.i(phoneNumber, "phoneNumber");
        Uri uri = ContactsContract.PhoneLookup.CONTENT_FILTER_URI;
        String strSubstring = phoneNumber.substring(2, phoneNumber.length());
        y.h(strSubstring, "substring(...)");
        Cursor cursorQuery = context.getContentResolver().query(Uri.withAppendedPath(uri, Uri.encode(strSubstring)), new String[]{"_id"}, null, null, null);
        if (cursorQuery == null || !cursorQuery.moveToFirst()) {
            return;
        }
        int columnIndex = cursorQuery.getColumnIndex("_id");
        if (columnIndex != -1) {
            String string = cursorQuery.getString(columnIndex);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.withAppendedPath(ContactsContract.Contacts.CONTENT_URI, string));
            context.startActivity(intent);
        }
        cursorQuery.close();
    }

    public final void openDownloads(Activity activity) {
        y.i(activity, "activity");
        if (!isSamsung()) {
            activity.startActivity(new Intent("android.intent.action.VIEW_DOWNLOADS"));
            return;
        }
        Intent launchIntentForPackage = activity.getPackageManager().getLaunchIntentForPackage("com.sec.android.app.myfiles");
        y.f(launchIntentForPackage);
        launchIntentForPackage.setAction("samsung.myfiles.intent.action.LAUNCH_MY_FILES");
        launchIntentForPackage.putExtra("samsung.myfiles.intent.extra.START_PATH", getDownloadsFile().getPath());
        activity.startActivity(launchIntentForPackage);
    }

    public final void openSendText(Context context, String number) {
        y.i(context, "context");
        y.i(number, "number");
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse("smsto:" + number));
            if (intent.resolveActivity(context.getPackageManager()) != null) {
                context.startActivity(intent);
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public final void openUri(Context context, Uri uri) {
        y.i(context, "context");
        y.i(uri, "uri");
        Uri uriForFile = FileProvider.getUriForFile(context, context.getApplicationContext().getPackageName() + ".provider", UriKt.toFile(uri));
        String path = uriForFile.getPath();
        if (path != null && a0.F(path, ".apk", false, 2, null)) {
            int i10 = Build.VERSION.SDK_INT;
            if (i10 >= 26) {
                Intent data = new Intent("android.settings.MANAGE_UNKNOWN_APP_SOURCES").setData(Uri.parse(String.format("package:%s", context.getPackageName())));
                y.h(data, "setData(...)");
                if (!context.getPackageManager().canRequestPackageInstalls()) {
                    context.startActivity(data);
                    return;
                }
                Intent intent = new Intent("android.intent.action.VIEW", uriForFile);
                intent.putExtra("android.intent.extra.NOT_UNKNOWN_SOURCE", true);
                intent.setDataAndType(uriForFile, "application/vnd.android.package-archive");
                intent.setFlags(268468224);
                intent.addFlags(1);
                context.startActivity(intent);
                return;
            }
            if (i10 < 24) {
                Intent intent2 = new Intent("android.intent.action.VIEW");
                intent2.setDataAndType(uriForFile, "application/vnd.android.package-archive");
                intent2.setFlags(268435456);
                context.startActivity(intent2);
                return;
            }
            Intent intent3 = new Intent("android.intent.action.INSTALL_PACKAGE");
            intent3.setDataAndType(uriForFile, "application/*");
            intent3.setFlags(268435456);
            intent3.addFlags(1);
            intent3.addFlags(2);
            context.startActivity(intent3);
            return;
        }
        Intent intent4 = new Intent("android.intent.action.VIEW");
        intent4.setFlags(3);
        try {
            MediaUtil mediaUtil = MediaUtil.INSTANCE;
            y.f(uriForFile);
            intent4.setDataAndType(uriForFile, mediaUtil.getMimeType(context, uriForFile));
            if (intent4.resolveActivity(context.getPackageManager()) != null) {
                context.startActivity(intent4);
                k0 k0Var = k0.f43947a;
                return;
            }
            MainRepository instanceOrNull = MainRepository.INSTANCE.getInstanceOrNull();
            if (instanceOrNull != null) {
                String string = UUID.randomUUID().toString();
                y.h(string, "toString(...)");
                String strO = a0.O(string, "-", "", false, 4, null);
                Cause cause = Cause.ERROR;
                String string2 = MainModule.INSTANCE.getInstance().getAppContext().getString(R.string.no_app_available_for_open_file);
                y.h(string2, "getString(...)");
                instanceOrNull.addNewNotification(new InsideNotificationState(strO, cause, string2));
                k0 k0Var2 = k0.f43947a;
            }
        } catch (Exception e10) {
            e10.printStackTrace();
            MainRepository instanceOrNull2 = MainRepository.INSTANCE.getInstanceOrNull();
            if (instanceOrNull2 != null) {
                String string3 = UUID.randomUUID().toString();
                y.h(string3, "toString(...)");
                String strO2 = a0.O(string3, "-", "", false, 4, null);
                Cause cause2 = Cause.ERROR;
                String string4 = MainModule.INSTANCE.getInstance().getAppContext().getString(R.string.cant_open_file);
                y.h(string4, "getString(...)");
                instanceOrNull2.addNewNotification(new InsideNotificationState(strO2, cause2, string4));
                k0 k0Var3 = k0.f43947a;
            }
        }
    }

    public final void operatorCall(Context context, String cell) {
        y.i(context, "context");
        y.i(cell, "cell");
        context.startActivity(new Intent("android.intent.action.CALL", Uri.parse("tel:" + cell)));
    }

    public final void sendInvitation(Context context, String msg) {
        y.i(context, "context");
        y.i(msg, "msg");
        if (d0.q0(msg)) {
            msg = context.getResources().getString(R.string.join_to_toDus) + " 🇨🇺. " + context.getResources().getString(R.string.todus_apklis_latest);
        }
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType(MediaUtil.TEXT);
        intent.putExtra("android.intent.extra.TEXT", msg);
        try {
            context.startActivity(Intent.createChooser(intent, msg));
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public final void shareBitmap(Context context, Bitmap combineImages) {
        y.i(context, "context");
        y.i(combineImages, "combineImages");
        File newImageFile$default = DirectoryPaths.getNewImageFile$default(DirectoryPaths.INSTANCE.getInstance(), false, 1, null);
        ImageUtils.INSTANCE.saveToFile(combineImages, newImageFile$default);
        open(context, newImageFile$default);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void shareMessages(Context context, List<? extends ua.y> itemToShare) {
        y.i(context, "context");
        y.i(itemToShare, "itemToShare");
        Intent intent = new Intent();
        intent.setAction("android.intent.action.SEND_MULTIPLE");
        for (ua.y yVar : itemToShare) {
            if (yVar.g() != null) {
                intent.putExtra("android.intent.extra.TEXT", (String) yVar.g());
            }
            if (yVar.h() != null) {
                intent.putExtra("android.intent.extra.STREAM", w.g(yVar.h()));
            }
        }
        intent.setType("*/*");
        Intent intentCreateChooser = Intent.createChooser(intent, "Compartir");
        intentCreateChooser.addFlags(268435456);
        try {
            ContextCompat.startActivity(context, intentCreateChooser, null);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public final void shareText(Context context, String title, String text) {
        y.i(context, "context");
        y.i(title, "title");
        y.i(text, "text");
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType(MediaUtil.TEXT);
        intent.putExtra("android.intent.extra.SUBJECT", title);
        intent.putExtra("android.intent.extra.TEXT", text);
        ContextCompat.startActivity(context, Intent.createChooser(intent, "Compartir"), null);
    }

    public final void showWeb(Context context, String url) {
        y.i(context, "context");
        y.i(url, "url");
        if (!d0.a0(url, "http", false, 2, null)) {
            url = "https://" + url;
        }
        try {
            context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(url)));
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }
}
