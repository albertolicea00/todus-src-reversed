package cu.todus.android.di;

import android.content.Context;
import android.net.Uri;
import androidx.compose.runtime.internal.StabilityInferred;
import com.google.firebase.analytics.FirebaseAnalytics;
import cu.todus.android.data.db.pojo.content.Content;
import cu.todus.android.data.db.pojo.info.MessagePayload;
import cu.todus.android.data.db.pojo.messageentity.MessageEntity;
import cu.todus.android.db.typeconverter.ContentDeserializer;
import cu.todus.android.db.typeconverter.ContentSerializer;
import cu.todus.android.db.typeconverter.MessageEntityDeserializer;
import cu.todus.android.db.typeconverter.MessageEntitySerializer;
import cu.todus.android.db.typeconverter.MessageInfoDeserializer;
import cu.todus.android.db.typeconverter.MessageInfoSerializer;
import cu.todus.android.db.typeconverter.UriDeserializer;
import cu.todus.android.db.typeconverter.UriSerializer;
import cu.todus.android.media.recorder.AndroidAudioRecorder;
import cu.todus.android.rest.BaseDataSource;
import cu.z17.singledi.SingletonInitializer;
import kotlin.Metadata;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0007\u0018\u0000 !2\u00020\u0001:\u0001!B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0013\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0017\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\fR\u0017\u0010\u001a\u001a\u00020\u00108\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001e\u001a\u0004\b\u001f\u0010 ¨\u0006\""}, d2 = {"Lcu/todus/android/di/MainModule;", "", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "appContext", "Lb4/f;", "provideFirebase", "(Landroid/content/Context;)Lb4/f;", "Lv5/f;", "provideGson", "()Lv5/f;", "Lcu/todus/android/media/recorder/AndroidAudioRecorder;", "providesAudioRecorder", "(Landroid/content/Context;)Lcu/todus/android/media/recorder/AndroidAudioRecorder;", "Lcu/todus/android/rest/BaseDataSource;", "provideBaseDataSource", "(Landroid/content/Context;)Lcu/todus/android/rest/BaseDataSource;", "firebaseApp", "Lb4/f;", "getFirebaseApp", "()Lb4/f;", "gson", "Lv5/f;", "getGson", "baseDataSource", "Lcu/todus/android/rest/BaseDataSource;", "getBaseDataSource", "()Lcu/todus/android/rest/BaseDataSource;", "Landroid/content/Context;", "getAppContext", "()Landroid/content/Context;", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class MainModule {
    private final Context appContext;
    private final BaseDataSource baseDataSource;
    private final b4.f firebaseApp;
    private final v5.f gson;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcu/todus/android/di/MainModule$Companion;", "Lcu/z17/singledi/SingletonInitializer;", "Lcu/todus/android/di/MainModule;", "<init>", "()V", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion extends SingletonInitializer<MainModule> {
        public /* synthetic */ Companion(kotlin.jvm.internal.p pVar) {
            this();
        }

        private Companion() {
        }
    }

    public MainModule(Context context) {
        y.i(context, "context");
        this.appContext = context;
        this.firebaseApp = provideFirebase(context);
        this.gson = provideGson();
        this.baseDataSource = provideBaseDataSource(context);
    }

    private final BaseDataSource provideBaseDataSource(Context appContext) {
        return new BaseDataSource(appContext);
    }

    private final b4.f provideFirebase(Context appContext) {
        i4.h.b().d(false);
        FirebaseAnalytics.getInstance(appContext).a(false);
        b4.f.q(appContext);
        b4.f fVarL = b4.f.l();
        y.h(fVarL, "getInstance(...)");
        return fVarL;
    }

    private final v5.f provideGson() {
        v5.f fVarB = new v5.g().d(Uri.class, new UriSerializer()).d(Uri.class, new UriDeserializer()).d(MessageEntity.class, new MessageEntityDeserializer()).d(MessageEntity.class, new MessageEntitySerializer()).d(Content.class, new ContentDeserializer()).d(Content.class, new ContentSerializer()).d(MessagePayload.class, new MessageInfoSerializer()).d(MessagePayload.class, new MessageInfoDeserializer()).d(Uri.class, new UriSerializer()).d(Uri.class, new UriDeserializer()).b();
        y.h(fVarB, "create(...)");
        return fVarB;
    }

    private final AndroidAudioRecorder providesAudioRecorder(Context appContext) {
        return new AndroidAudioRecorder(appContext);
    }

    public final Context getAppContext() {
        return this.appContext;
    }

    public final BaseDataSource getBaseDataSource() {
        return this.baseDataSource;
    }

    public final b4.f getFirebaseApp() {
        return this.firebaseApp;
    }

    public final v5.f getGson() {
        return this.gson;
    }
}
