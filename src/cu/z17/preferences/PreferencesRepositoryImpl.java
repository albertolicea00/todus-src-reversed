package cu.z17.preferences;

import ab.e;
import android.annotation.SuppressLint;
import android.content.Context;
import android.security.keystore.KeyGenParameterSpec;
import androidx.camera.video.AudioStats;
import androidx.compose.runtime.ComposerKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.datastore.core.DataStore;
import androidx.datastore.preferences.core.MutablePreferences;
import androidx.datastore.preferences.core.Preferences;
import androidx.datastore.preferences.core.PreferencesKeys;
import androidx.datastore.preferences.core.PreferencesKt;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.extractor.ts.TsExtractor;
import androidx.media3.muxer.WebmConstants;
import androidx.security.crypto.MasterKey;
import cb.d;
import cb.f;
import cb.l;
import cb.m;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.android.gms.stats.CodePackage;
import cu.z17.preferences.encription.Encryption;
import ef.t;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.w;
import kotlin.jvm.internal.y;
import kotlin.jvm.internal.z0;
import org.jivesoftware.smackx.bookmarks.Bookmarks;
import te.b0;
import te.h;
import te.i;
import te.j;
import te.p0;
import te.r0;
import ua.k0;
import ua.v;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0003¢\u0006\u0004\b\n\u0010\u000bJH\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\r\"\u0006\b\u0000\u0010\f\u0018\u0001*\b\u0012\u0004\u0012\u00020\u00050\r2\u0016\b\u0004\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\t0\u000e2\u0006\u0010\u0010\u001a\u00028\u0000H\u0082\b¢\u0006\u0004\b\u0011\u0010\u0012JF\u0010\u0018\u001a\u00020\u0016\"\u0006\b\u0000\u0010\f\u0018\u0001*\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0013\u001a\u00028\u00002\u001a\b\u0004\u0010\u0017\u001a\u0014\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00160\u0014H\u0082H¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0016H\u0086@¢\u0006\u0004\b\u001a\u0010\u001bJ%\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\t0\r2\u0006\u0010\u001c\u001a\u00020\t2\b\b\u0002\u0010\u0010\u001a\u00020\t¢\u0006\u0004\b\u001d\u0010\u001eJ \u0010 \u001a\u00020\u001f2\u0006\u0010\u001c\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\tH\u0086@¢\u0006\u0004\b \u0010!J\"\u0010\"\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\t2\b\b\u0002\u0010\u0010\u001a\u00020\tH\u0086@¢\u0006\u0004\b\"\u0010!J%\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020#0\r2\u0006\u0010\u001c\u001a\u00020\t2\b\b\u0002\u0010\u0010\u001a\u00020#¢\u0006\u0004\b\u001d\u0010$J \u0010 \u001a\u00020\u001f2\u0006\u0010\u001c\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020#H\u0086@¢\u0006\u0004\b \u0010%J\"\u0010\"\u001a\u00020#2\u0006\u0010\u001c\u001a\u00020\t2\b\b\u0002\u0010\u0010\u001a\u00020#H\u0086@¢\u0006\u0004\b\"\u0010%J%\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020&0\r2\u0006\u0010\u001c\u001a\u00020\t2\b\b\u0002\u0010\u0010\u001a\u00020&¢\u0006\u0004\b\u001d\u0010'J \u0010 \u001a\u00020\u001f2\u0006\u0010\u001c\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020&H\u0086@¢\u0006\u0004\b \u0010(J\"\u0010\"\u001a\u00020&2\u0006\u0010\u001c\u001a\u00020\t2\b\b\u0002\u0010\u0010\u001a\u00020&H\u0086@¢\u0006\u0004\b\"\u0010(J%\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020)0\r2\u0006\u0010\u001c\u001a\u00020\t2\b\b\u0002\u0010\u0010\u001a\u00020)¢\u0006\u0004\b\u001d\u0010*J \u0010 \u001a\u00020\u001f2\u0006\u0010\u001c\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020)H\u0086@¢\u0006\u0004\b \u0010+J\"\u0010\"\u001a\u00020)2\u0006\u0010\u001c\u001a\u00020\t2\b\b\u0002\u0010\u0010\u001a\u00020)H\u0086@¢\u0006\u0004\b\"\u0010+J%\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\r2\u0006\u0010\u001c\u001a\u00020\t2\b\b\u0002\u0010\u0010\u001a\u00020\u001f¢\u0006\u0004\b\u001d\u0010,J \u0010 \u001a\u00020\u001f2\u0006\u0010\u001c\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u001fH\u0086@¢\u0006\u0004\b \u0010-J\"\u0010\"\u001a\u00020\u001f2\u0006\u0010\u001c\u001a\u00020\t2\b\b\u0002\u0010\u0010\u001a\u00020\u001fH\u0086@¢\u0006\u0004\b\"\u0010-R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010.R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010/R\u001c\u00101\u001a\n 0*\u0004\u0018\u00010\t0\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u0014\u00103\u001a\u00020\t8\u0002X\u0082D¢\u0006\u0006\n\u0004\b3\u00102R\u0014\u00105\u001a\u0002048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u0014\u00108\u001a\u0002078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u00109R\u001a\u0010;\u001a\b\u0012\u0004\u0012\u00020#0:8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u0010<R\u001d\u0010>\u001a\b\u0012\u0004\u0012\u00020#0=8\u0006¢\u0006\f\n\u0004\b>\u0010?\u001a\u0004\b@\u0010A¨\u0006B"}, d2 = {"Lcu/z17/preferences/PreferencesRepositoryImpl;", "", "Landroid/content/Context;", "context", "Landroidx/datastore/core/DataStore;", "Landroidx/datastore/preferences/core/Preferences;", Bookmarks.ELEMENT, "<init>", "(Landroid/content/Context;Landroidx/datastore/core/DataStore;)V", "", "createMasterKey", "(Landroid/content/Context;)Ljava/lang/String;", ExifInterface.GPS_DIRECTION_TRUE, "Lte/h;", "Lkotlin/Function1;", "fetchValue", "default", "secureMap", "(Lte/h;Lkotlin/jvm/functions/Function1;Ljava/lang/Object;)Lte/h;", AppMeasurementSdk.ConditionalUserProperty.VALUE, "Lkotlin/Function2;", "Landroidx/datastore/preferences/core/MutablePreferences;", "Lua/k0;", "editStore", "secureEdit", "(Landroidx/datastore/core/DataStore;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Lab/e;)Ljava/lang/Object;", "resetAll", "(Lab/e;)Ljava/lang/Object;", "keyName", "flowValueOf", "(Ljava/lang/String;Ljava/lang/String;)Lte/h;", "", "store", "(Ljava/lang/String;Ljava/lang/String;Lab/e;)Ljava/lang/Object;", "retrieve", "", "(Ljava/lang/String;I)Lte/h;", "(Ljava/lang/String;ILab/e;)Ljava/lang/Object;", "", "(Ljava/lang/String;D)Lte/h;", "(Ljava/lang/String;DLab/e;)Ljava/lang/Object;", "", "(Ljava/lang/String;J)Lte/h;", "(Ljava/lang/String;JLab/e;)Ljava/lang/Object;", "(Ljava/lang/String;Z)Lte/h;", "(Ljava/lang/String;ZLab/e;)Ljava/lang/Object;", "Landroid/content/Context;", "Landroidx/datastore/core/DataStore;", "kotlin.jvm.PlatformType", "TAG", "Ljava/lang/String;", "salt", "", "iv", "[B", "Lcu/z17/preferences/encription/Encryption;", "encryption", "Lcu/z17/preferences/encription/Encryption;", "Lte/b0;", "errors", "Lte/b0;", "Lte/p0;", "errorFlow", "Lte/p0;", "getErrorFlow", "()Lte/p0;", "preferences_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public class PreferencesRepositoryImpl {
    private final String TAG;
    private final Context context;
    private final Encryption encryption;
    private final p0 errorFlow;
    private final b0 errors;
    private final byte[] iv;
    private final String salt;
    private final DataStore<Preferences> storage;

    /* JADX INFO: renamed from: cu.z17.preferences.PreferencesRepositoryImpl$flowValueOf$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @f(c = "cu.z17.preferences.PreferencesRepositoryImpl$flowValueOf$1", f = "PreferencesRepositoryImpl.kt", l = {115, 118}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004*\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lte/i;", "Landroidx/datastore/preferences/core/Preferences;", "", "it", "Lua/k0;", "<anonymous>", "(Lte/i;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 2, 0})
    public static final class AnonymousClass1 extends m implements Function3 {
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;

        public AnonymousClass1(e<? super AnonymousClass1> eVar) {
            super(3, eVar);
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x0040, code lost:
        
            if (r0.emit(r7, r6) == r2) goto L17;
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x0066, code lost:
        
            if (r0.emit(r7, r6) == r2) goto L17;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x0068, code lost:
        
            return r2;
         */
        @Override // cb.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) {
            /*
                r6 = this;
                java.lang.Object r0 = r6.L$0
                te.i r0 = (te.i) r0
                java.lang.Object r1 = r6.L$1
                java.lang.Throwable r1 = (java.lang.Throwable) r1
                java.lang.Object r2 = bb.b.g()
                int r3 = r6.label
                r4 = 2
                r5 = 1
                if (r3 == 0) goto L23
                if (r3 == r5) goto L1f
                if (r3 != r4) goto L17
                goto L1f
            L17:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r0)
                throw r7
            L1f:
                ua.v.b(r7)
                goto L69
            L23:
                ua.v.b(r7)
                boolean r7 = r1 instanceof java.io.IOException
                if (r7 == 0) goto L43
                androidx.datastore.preferences.core.Preferences r7 = androidx.datastore.preferences.core.PreferencesFactory.createEmpty()
                java.lang.Object r3 = cb.l.a(r0)
                r6.L$0 = r3
                java.lang.Object r1 = cb.l.a(r1)
                r6.L$1 = r1
                r6.label = r5
                java.lang.Object r7 = r0.emit(r7, r6)
                if (r7 != r2) goto L69
                goto L68
            L43:
                cu.z17.preferences.PreferencesRepositoryImpl r7 = cu.z17.preferences.PreferencesRepositoryImpl.this
                java.lang.String r7 = cu.z17.preferences.PreferencesRepositoryImpl.access$getTAG$p(r7)
                java.lang.String r3 = r1.toString()
                android.util.Log.e(r7, r3)
                androidx.datastore.preferences.core.Preferences r7 = androidx.datastore.preferences.core.PreferencesFactory.createEmpty()
                java.lang.Object r3 = cb.l.a(r0)
                r6.L$0 = r3
                java.lang.Object r1 = cb.l.a(r1)
                r6.L$1 = r1
                r6.label = r4
                java.lang.Object r7 = r0.emit(r7, r6)
                if (r7 != r2) goto L69
            L68:
                return r2
            L69:
                ua.k0 r7 = ua.k0.f43947a
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: cu.z17.preferences.PreferencesRepositoryImpl.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(i iVar, Throwable th2, e<? super k0> eVar) {
            AnonymousClass1 anonymousClass1 = PreferencesRepositoryImpl.this.new AnonymousClass1(eVar);
            anonymousClass1.L$0 = iVar;
            anonymousClass1.L$1 = th2;
            return anonymousClass1.invokeSuspend(k0.f43947a);
        }
    }

    /* JADX INFO: renamed from: cu.z17.preferences.PreferencesRepositoryImpl$flowValueOf$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @f(c = "cu.z17.preferences.PreferencesRepositoryImpl$flowValueOf$3", f = "PreferencesRepositoryImpl.kt", l = {158, WebmConstants.MkvEbmlElement.BLOCK}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004*\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lte/i;", "Landroidx/datastore/preferences/core/Preferences;", "", "it", "Lua/k0;", "<anonymous>", "(Lte/i;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 2, 0})
    public static final class AnonymousClass3 extends m implements Function3 {
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;

        public AnonymousClass3(e<? super AnonymousClass3> eVar) {
            super(3, eVar);
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x0040, code lost:
        
            if (r0.emit(r7, r6) == r2) goto L17;
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x0066, code lost:
        
            if (r0.emit(r7, r6) == r2) goto L17;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x0068, code lost:
        
            return r2;
         */
        @Override // cb.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) {
            /*
                r6 = this;
                java.lang.Object r0 = r6.L$0
                te.i r0 = (te.i) r0
                java.lang.Object r1 = r6.L$1
                java.lang.Throwable r1 = (java.lang.Throwable) r1
                java.lang.Object r2 = bb.b.g()
                int r3 = r6.label
                r4 = 2
                r5 = 1
                if (r3 == 0) goto L23
                if (r3 == r5) goto L1f
                if (r3 != r4) goto L17
                goto L1f
            L17:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r0)
                throw r7
            L1f:
                ua.v.b(r7)
                goto L69
            L23:
                ua.v.b(r7)
                boolean r7 = r1 instanceof java.io.IOException
                if (r7 == 0) goto L43
                androidx.datastore.preferences.core.Preferences r7 = androidx.datastore.preferences.core.PreferencesFactory.createEmpty()
                java.lang.Object r3 = cb.l.a(r0)
                r6.L$0 = r3
                java.lang.Object r1 = cb.l.a(r1)
                r6.L$1 = r1
                r6.label = r5
                java.lang.Object r7 = r0.emit(r7, r6)
                if (r7 != r2) goto L69
                goto L68
            L43:
                cu.z17.preferences.PreferencesRepositoryImpl r7 = cu.z17.preferences.PreferencesRepositoryImpl.this
                java.lang.String r7 = cu.z17.preferences.PreferencesRepositoryImpl.access$getTAG$p(r7)
                java.lang.String r3 = r1.toString()
                android.util.Log.e(r7, r3)
                androidx.datastore.preferences.core.Preferences r7 = androidx.datastore.preferences.core.PreferencesFactory.createEmpty()
                java.lang.Object r3 = cb.l.a(r0)
                r6.L$0 = r3
                java.lang.Object r1 = cb.l.a(r1)
                r6.L$1 = r1
                r6.label = r4
                java.lang.Object r7 = r0.emit(r7, r6)
                if (r7 != r2) goto L69
            L68:
                return r2
            L69:
                ua.k0 r7 = ua.k0.f43947a
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: cu.z17.preferences.PreferencesRepositoryImpl.AnonymousClass3.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(i iVar, Throwable th2, e<? super k0> eVar) {
            AnonymousClass3 anonymousClass3 = PreferencesRepositoryImpl.this.new AnonymousClass3(eVar);
            anonymousClass3.L$0 = iVar;
            anonymousClass3.L$1 = th2;
            return anonymousClass3.invokeSuspend(k0.f43947a);
        }
    }

    /* JADX INFO: renamed from: cu.z17.preferences.PreferencesRepositoryImpl$flowValueOf$5, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @f(c = "cu.z17.preferences.PreferencesRepositoryImpl$flowValueOf$5", f = "PreferencesRepositoryImpl.kt", l = {ComposerKt.providerKey, 204}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004*\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lte/i;", "Landroidx/datastore/preferences/core/Preferences;", "", "it", "Lua/k0;", "<anonymous>", "(Lte/i;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 2, 0})
    public static final class AnonymousClass5 extends m implements Function3 {
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;

        public AnonymousClass5(e<? super AnonymousClass5> eVar) {
            super(3, eVar);
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x0040, code lost:
        
            if (r0.emit(r7, r6) == r2) goto L17;
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x0066, code lost:
        
            if (r0.emit(r7, r6) == r2) goto L17;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x0068, code lost:
        
            return r2;
         */
        @Override // cb.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) {
            /*
                r6 = this;
                java.lang.Object r0 = r6.L$0
                te.i r0 = (te.i) r0
                java.lang.Object r1 = r6.L$1
                java.lang.Throwable r1 = (java.lang.Throwable) r1
                java.lang.Object r2 = bb.b.g()
                int r3 = r6.label
                r4 = 2
                r5 = 1
                if (r3 == 0) goto L23
                if (r3 == r5) goto L1f
                if (r3 != r4) goto L17
                goto L1f
            L17:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r0)
                throw r7
            L1f:
                ua.v.b(r7)
                goto L69
            L23:
                ua.v.b(r7)
                boolean r7 = r1 instanceof java.io.IOException
                if (r7 == 0) goto L43
                androidx.datastore.preferences.core.Preferences r7 = androidx.datastore.preferences.core.PreferencesFactory.createEmpty()
                java.lang.Object r3 = cb.l.a(r0)
                r6.L$0 = r3
                java.lang.Object r1 = cb.l.a(r1)
                r6.L$1 = r1
                r6.label = r5
                java.lang.Object r7 = r0.emit(r7, r6)
                if (r7 != r2) goto L69
                goto L68
            L43:
                cu.z17.preferences.PreferencesRepositoryImpl r7 = cu.z17.preferences.PreferencesRepositoryImpl.this
                java.lang.String r7 = cu.z17.preferences.PreferencesRepositoryImpl.access$getTAG$p(r7)
                java.lang.String r3 = r1.toString()
                android.util.Log.e(r7, r3)
                androidx.datastore.preferences.core.Preferences r7 = androidx.datastore.preferences.core.PreferencesFactory.createEmpty()
                java.lang.Object r3 = cb.l.a(r0)
                r6.L$0 = r3
                java.lang.Object r1 = cb.l.a(r1)
                r6.L$1 = r1
                r6.label = r4
                java.lang.Object r7 = r0.emit(r7, r6)
                if (r7 != r2) goto L69
            L68:
                return r2
            L69:
                ua.k0 r7 = ua.k0.f43947a
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: cu.z17.preferences.PreferencesRepositoryImpl.AnonymousClass5.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(i iVar, Throwable th2, e<? super k0> eVar) {
            AnonymousClass5 anonymousClass5 = PreferencesRepositoryImpl.this.new AnonymousClass5(eVar);
            anonymousClass5.L$0 = iVar;
            anonymousClass5.L$1 = th2;
            return anonymousClass5.invokeSuspend(k0.f43947a);
        }
    }

    /* JADX INFO: renamed from: cu.z17.preferences.PreferencesRepositoryImpl$flowValueOf$7, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @f(c = "cu.z17.preferences.PreferencesRepositoryImpl$flowValueOf$7", f = "PreferencesRepositoryImpl.kt", l = {244, WebmConstants.MkvEbmlElement.CUE_TRACK}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004*\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lte/i;", "Landroidx/datastore/preferences/core/Preferences;", "", "it", "Lua/k0;", "<anonymous>", "(Lte/i;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 2, 0})
    public static final class AnonymousClass7 extends m implements Function3 {
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;

        public AnonymousClass7(e<? super AnonymousClass7> eVar) {
            super(3, eVar);
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x0040, code lost:
        
            if (r0.emit(r7, r6) == r2) goto L17;
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x0066, code lost:
        
            if (r0.emit(r7, r6) == r2) goto L17;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x0068, code lost:
        
            return r2;
         */
        @Override // cb.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) {
            /*
                r6 = this;
                java.lang.Object r0 = r6.L$0
                te.i r0 = (te.i) r0
                java.lang.Object r1 = r6.L$1
                java.lang.Throwable r1 = (java.lang.Throwable) r1
                java.lang.Object r2 = bb.b.g()
                int r3 = r6.label
                r4 = 2
                r5 = 1
                if (r3 == 0) goto L23
                if (r3 == r5) goto L1f
                if (r3 != r4) goto L17
                goto L1f
            L17:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r0)
                throw r7
            L1f:
                ua.v.b(r7)
                goto L69
            L23:
                ua.v.b(r7)
                boolean r7 = r1 instanceof java.io.IOException
                if (r7 == 0) goto L43
                androidx.datastore.preferences.core.Preferences r7 = androidx.datastore.preferences.core.PreferencesFactory.createEmpty()
                java.lang.Object r3 = cb.l.a(r0)
                r6.L$0 = r3
                java.lang.Object r1 = cb.l.a(r1)
                r6.L$1 = r1
                r6.label = r5
                java.lang.Object r7 = r0.emit(r7, r6)
                if (r7 != r2) goto L69
                goto L68
            L43:
                cu.z17.preferences.PreferencesRepositoryImpl r7 = cu.z17.preferences.PreferencesRepositoryImpl.this
                java.lang.String r7 = cu.z17.preferences.PreferencesRepositoryImpl.access$getTAG$p(r7)
                java.lang.String r3 = r1.toString()
                android.util.Log.e(r7, r3)
                androidx.datastore.preferences.core.Preferences r7 = androidx.datastore.preferences.core.PreferencesFactory.createEmpty()
                java.lang.Object r3 = cb.l.a(r0)
                r6.L$0 = r3
                java.lang.Object r1 = cb.l.a(r1)
                r6.L$1 = r1
                r6.label = r4
                java.lang.Object r7 = r0.emit(r7, r6)
                if (r7 != r2) goto L69
            L68:
                return r2
            L69:
                ua.k0 r7 = ua.k0.f43947a
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: cu.z17.preferences.PreferencesRepositoryImpl.AnonymousClass7.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(i iVar, Throwable th2, e<? super k0> eVar) {
            AnonymousClass7 anonymousClass7 = PreferencesRepositoryImpl.this.new AnonymousClass7(eVar);
            anonymousClass7.L$0 = iVar;
            anonymousClass7.L$1 = th2;
            return anonymousClass7.invokeSuspend(k0.f43947a);
        }
    }

    /* JADX INFO: renamed from: cu.z17.preferences.PreferencesRepositoryImpl$flowValueOf$9, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @f(c = "cu.z17.preferences.PreferencesRepositoryImpl$flowValueOf$9", f = "PreferencesRepositoryImpl.kt", l = {287, 290}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004*\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lte/i;", "Landroidx/datastore/preferences/core/Preferences;", "", "it", "Lua/k0;", "<anonymous>", "(Lte/i;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 2, 0})
    public static final class AnonymousClass9 extends m implements Function3 {
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;

        public AnonymousClass9(e<? super AnonymousClass9> eVar) {
            super(3, eVar);
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x0040, code lost:
        
            if (r0.emit(r7, r6) == r2) goto L17;
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x0066, code lost:
        
            if (r0.emit(r7, r6) == r2) goto L17;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x0068, code lost:
        
            return r2;
         */
        @Override // cb.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) {
            /*
                r6 = this;
                java.lang.Object r0 = r6.L$0
                te.i r0 = (te.i) r0
                java.lang.Object r1 = r6.L$1
                java.lang.Throwable r1 = (java.lang.Throwable) r1
                java.lang.Object r2 = bb.b.g()
                int r3 = r6.label
                r4 = 2
                r5 = 1
                if (r3 == 0) goto L23
                if (r3 == r5) goto L1f
                if (r3 != r4) goto L17
                goto L1f
            L17:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r0)
                throw r7
            L1f:
                ua.v.b(r7)
                goto L69
            L23:
                ua.v.b(r7)
                boolean r7 = r1 instanceof java.io.IOException
                if (r7 == 0) goto L43
                androidx.datastore.preferences.core.Preferences r7 = androidx.datastore.preferences.core.PreferencesFactory.createEmpty()
                java.lang.Object r3 = cb.l.a(r0)
                r6.L$0 = r3
                java.lang.Object r1 = cb.l.a(r1)
                r6.L$1 = r1
                r6.label = r5
                java.lang.Object r7 = r0.emit(r7, r6)
                if (r7 != r2) goto L69
                goto L68
            L43:
                cu.z17.preferences.PreferencesRepositoryImpl r7 = cu.z17.preferences.PreferencesRepositoryImpl.this
                java.lang.String r7 = cu.z17.preferences.PreferencesRepositoryImpl.access$getTAG$p(r7)
                java.lang.String r3 = r1.toString()
                android.util.Log.e(r7, r3)
                androidx.datastore.preferences.core.Preferences r7 = androidx.datastore.preferences.core.PreferencesFactory.createEmpty()
                java.lang.Object r3 = cb.l.a(r0)
                r6.L$0 = r3
                java.lang.Object r1 = cb.l.a(r1)
                r6.L$1 = r1
                r6.label = r4
                java.lang.Object r7 = r0.emit(r7, r6)
                if (r7 != r2) goto L69
            L68:
                return r2
            L69:
                ua.k0 r7 = ua.k0.f43947a
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: cu.z17.preferences.PreferencesRepositoryImpl.AnonymousClass9.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(i iVar, Throwable th2, e<? super k0> eVar) {
            AnonymousClass9 anonymousClass9 = PreferencesRepositoryImpl.this.new AnonymousClass9(eVar);
            anonymousClass9.L$0 = iVar;
            anonymousClass9.L$1 = th2;
            return anonymousClass9.invokeSuspend(k0.f43947a);
        }
    }

    /* JADX INFO: renamed from: cu.z17.preferences.PreferencesRepositoryImpl$resetAll$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @f(c = "cu.z17.preferences.PreferencesRepositoryImpl$resetAll$2", f = "PreferencesRepositoryImpl.kt", l = {}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroidx/datastore/preferences/core/MutablePreferences;", "it", "Lua/k0;", "<anonymous>", "(Landroidx/datastore/preferences/core/MutablePreferences;)V"}, k = 3, mv = {2, 2, 0})
    public static final class AnonymousClass2 extends m implements Function2 {
        /* synthetic */ Object L$0;
        int label;

        public AnonymousClass2(e<? super AnonymousClass2> eVar) {
            super(2, eVar);
        }

        @Override // cb.a
        public final e<k0> create(Object obj, e<?> eVar) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(eVar);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(MutablePreferences mutablePreferences, e<? super k0> eVar) {
            return ((AnonymousClass2) create(mutablePreferences, eVar)).invokeSuspend(k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            MutablePreferences mutablePreferences = (MutablePreferences) this.L$0;
            bb.b.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v.b(obj);
            mutablePreferences.clear();
            return k0.f43947a;
        }
    }

    /* JADX INFO: renamed from: cu.z17.preferences.PreferencesRepositoryImpl$retrieve$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @f(c = "cu.z17.preferences.PreferencesRepositoryImpl", f = "PreferencesRepositoryImpl.kt", l = {145}, m = "retrieve")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class C15181 extends d {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C15181(e<? super C15181> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PreferencesRepositoryImpl.this.retrieve((String) null, (String) null, this);
        }
    }

    /* JADX INFO: renamed from: cu.z17.preferences.PreferencesRepositoryImpl$retrieve$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @f(c = "cu.z17.preferences.PreferencesRepositoryImpl", f = "PreferencesRepositoryImpl.kt", l = {TsExtractor.TS_PACKET_SIZE}, m = "retrieve")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class C15192 extends d {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C15192(e<? super C15192> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PreferencesRepositoryImpl.this.retrieve((String) null, 0, (e<? super Integer>) this);
        }
    }

    /* JADX INFO: renamed from: cu.z17.preferences.PreferencesRepositoryImpl$retrieve$3, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @f(c = "cu.z17.preferences.PreferencesRepositoryImpl", f = "PreferencesRepositoryImpl.kt", l = {WebmConstants.MkvEbmlElement.TIMESTAMP}, m = "retrieve")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class C15203 extends d {
        double D$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C15203(e<? super C15203> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PreferencesRepositoryImpl.this.retrieve((String) null, AudioStats.AUDIO_AMPLITUDE_NONE, this);
        }
    }

    /* JADX INFO: renamed from: cu.z17.preferences.PreferencesRepositoryImpl$retrieve$4, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @f(c = "cu.z17.preferences.PreferencesRepositoryImpl", f = "PreferencesRepositoryImpl.kt", l = {274}, m = "retrieve")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class AnonymousClass4 extends d {
        long J$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass4(e<? super AnonymousClass4> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PreferencesRepositoryImpl.this.retrieve((String) null, 0L, (e<? super Long>) this);
        }
    }

    /* JADX INFO: renamed from: cu.z17.preferences.PreferencesRepositoryImpl$retrieve$5, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @f(c = "cu.z17.preferences.PreferencesRepositoryImpl", f = "PreferencesRepositoryImpl.kt", l = {TypedValues.AttributesType.TYPE_EASING}, m = "retrieve")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class C15215 extends d {
        Object L$0;
        Object L$1;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        public C15215(e<? super C15215> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PreferencesRepositoryImpl.this.retrieve((String) null, false, (e<? super Boolean>) this);
        }
    }

    /* JADX INFO: renamed from: cu.z17.preferences.PreferencesRepositoryImpl$secureEdit$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @f(c = "cu.z17.preferences.PreferencesRepositoryImpl$secureEdit$2", f = "PreferencesRepositoryImpl.kt", l = {}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroidx/datastore/preferences/core/MutablePreferences;", "it", "Lua/k0;", "<anonymous>", "(Landroidx/datastore/preferences/core/MutablePreferences;)V"}, k = 3, mv = {2, 2, 0})
    public static final class C15222 extends m implements Function2 {
        final /* synthetic */ Function2 $editStore;
        final /* synthetic */ T $value;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C15222(T t10, Function2 function2, e<? super C15222> eVar) {
            super(2, eVar);
            this.$value = t10;
            this.$editStore = function2;
        }

        @Override // cb.a
        public final e<k0> create(Object obj, e<?> eVar) {
            C15222 c15222 = PreferencesRepositoryImpl.this.new C15222(this.$value, this.$editStore, eVar);
            c15222.L$0 = obj;
            return c15222;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(MutablePreferences mutablePreferences, e<? super k0> eVar) {
            return ((C15222) create(mutablePreferences, eVar)).invokeSuspend(k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            MutablePreferences mutablePreferences = (MutablePreferences) this.L$0;
            bb.b.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v.b(obj);
            Encryption encryption = PreferencesRepositoryImpl.this.encryption;
            kf.b.a aVar = kf.b.f36355d;
            y.n(6, ExifInterface.GPS_DIRECTION_TRUE);
            ef.b bVarD = t.d(null);
            y.g(bVarD, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
            String strEncryptOrNull = encryption.encryptOrNull(aVar.b(bVarD, this.$value));
            Function2 function2 = this.$editStore;
            y.f(strEncryptOrNull);
            function2.invoke(mutablePreferences, strEncryptOrNull);
            return k0.f43947a;
        }

        public final Object invokeSuspend$$forInline(Object obj) {
            MutablePreferences mutablePreferences = (MutablePreferences) this.L$0;
            w.c(10);
            Encryption encryption = PreferencesRepositoryImpl.this.encryption;
            kf.b.a aVar = kf.b.f36355d;
            y.n(6, ExifInterface.GPS_DIRECTION_TRUE);
            ef.b bVarD = t.d(null);
            y.g(bVarD, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
            String strEncryptOrNull = encryption.encryptOrNull(aVar.b(bVarD, this.$value));
            Function2 function2 = this.$editStore;
            y.f(strEncryptOrNull);
            function2.invoke(mutablePreferences, strEncryptOrNull);
            return k0.f43947a;
        }
    }

    /* JADX INFO: renamed from: cu.z17.preferences.PreferencesRepositoryImpl$store$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @f(c = "cu.z17.preferences.PreferencesRepositoryImpl", f = "PreferencesRepositoryImpl.kt", l = {322}, m = "store")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class C15231 extends d {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        public C15231(e<? super C15231> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PreferencesRepositoryImpl.this.store((String) null, (String) null, this);
        }
    }

    /* JADX INFO: renamed from: cu.z17.preferences.PreferencesRepositoryImpl$store$3, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @f(c = "cu.z17.preferences.PreferencesRepositoryImpl", f = "PreferencesRepositoryImpl.kt", l = {322}, m = "store")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class C15243 extends d {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        public C15243(e<? super C15243> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PreferencesRepositoryImpl.this.store((String) null, 0, (e<? super Boolean>) this);
        }
    }

    /* JADX INFO: renamed from: cu.z17.preferences.PreferencesRepositoryImpl$store$5, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @f(c = "cu.z17.preferences.PreferencesRepositoryImpl", f = "PreferencesRepositoryImpl.kt", l = {322}, m = "store")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class C15255 extends d {
        double D$0;
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        public C15255(e<? super C15255> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PreferencesRepositoryImpl.this.store((String) null, AudioStats.AUDIO_AMPLITUDE_NONE, this);
        }
    }

    /* JADX INFO: renamed from: cu.z17.preferences.PreferencesRepositoryImpl$store$7, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @f(c = "cu.z17.preferences.PreferencesRepositoryImpl", f = "PreferencesRepositoryImpl.kt", l = {322}, m = "store")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class C15267 extends d {
        int I$0;
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        public C15267(e<? super C15267> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PreferencesRepositoryImpl.this.store((String) null, 0L, (e<? super Boolean>) this);
        }
    }

    /* JADX INFO: renamed from: cu.z17.preferences.PreferencesRepositoryImpl$store$9, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @f(c = "cu.z17.preferences.PreferencesRepositoryImpl", f = "PreferencesRepositoryImpl.kt", l = {322}, m = "store")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class C15279 extends d {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        public C15279(e<? super C15279> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PreferencesRepositoryImpl.this.store((String) null, false, (e<? super Boolean>) this);
        }
    }

    public PreferencesRepositoryImpl(Context context, DataStore<Preferences> storage) {
        y.i(context, "context");
        y.i(storage, "storage");
        this.context = context;
        this.storage = storage;
        this.TAG = getClass().getSimpleName();
        this.salt = "android-preferences";
        byte[] bArr = new byte[16];
        this.iv = bArr;
        Encryption encryption = Encryption.getDefault(createMasterKey(context), "android-preferences", bArr);
        y.h(encryption, "getDefault(...)");
        this.encryption = encryption;
        b0 b0VarA = r0.a(0);
        this.errors = b0VarA;
        this.errorFlow = j.b(b0VarA);
    }

    @SuppressLint({"HardwareIds"})
    private final String createMasterKey(Context context) {
        KeyGenParameterSpec keyGenParameterSpecBuild = new KeyGenParameterSpec.Builder(MasterKey.DEFAULT_MASTER_KEY_ALIAS, 3).setBlockModes(CodePackage.GCM).setEncryptionPaddings("NoPadding").setKeySize(256).build();
        y.h(keyGenParameterSpecBuild, "build(...)");
        String string = new MasterKey.Builder(context).setKeyGenParameterSpec(keyGenParameterSpecBuild).build().toString();
        y.h(string, "toString(...)");
        return string;
    }

    public static /* synthetic */ h flowValueOf$default(PreferencesRepositoryImpl preferencesRepositoryImpl, String str, String str2, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: flowValueOf");
        }
        if ((i10 & 2) != 0) {
            str2 = "";
        }
        return preferencesRepositoryImpl.flowValueOf(str, str2);
    }

    public static /* synthetic */ Object retrieve$default(PreferencesRepositoryImpl preferencesRepositoryImpl, String str, String str2, e eVar, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: retrieve");
        }
        if ((i10 & 2) != 0) {
            str2 = "";
        }
        return preferencesRepositoryImpl.retrieve(str, str2, (e<? super String>) eVar);
    }

    private final /* synthetic */ <T> Object secureEdit(DataStore<Preferences> dataStore, T t10, Function2 function2, e<? super k0> eVar) {
        y.m();
        C15222 c15222 = new C15222(t10, function2, null);
        w.c(0);
        PreferencesKt.edit(dataStore, c15222, eVar);
        w.c(1);
        return k0.f43947a;
    }

    private final /* synthetic */ <T> h secureMap(h hVar, Function1 function1, T t10) {
        y.m();
        return new PreferencesRepositoryImpl$secureMap$$inlined$map$1(hVar, function1, this, t10);
    }

    public final h flowValueOf(String keyName, final String str) {
        y.i(keyName, "keyName");
        y.i(str, "default");
        final Preferences.Key<String> keyStringKey = PreferencesKeys.stringKey(keyName);
        final h hVarG = j.g(this.storage.getData(), new AnonymousClass1(null));
        return new h() { // from class: cu.z17.preferences.PreferencesRepositoryImpl$flowValueOf$$inlined$secureMap$1

            /* JADX INFO: renamed from: cu.z17.preferences.PreferencesRepositoryImpl$flowValueOf$$inlined$secureMap$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
            @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "R", AppMeasurementSdk.ConditionalUserProperty.VALUE, "Lua/k0;", "emit", "(Ljava/lang/Object;Lab/e;)Ljava/lang/Object;", "cu/z17/preferences/PreferencesRepositoryImpl$secureMap$$inlined$map$1$2", "<anonymous>"}, k = 3, mv = {2, 2, 0})
            public static final class AnonymousClass2<T> implements i {
                final /* synthetic */ Object $default$inlined;
                final /* synthetic */ Preferences.Key $key$inlined;
                final /* synthetic */ i $this_unsafeFlow;
                final /* synthetic */ PreferencesRepositoryImpl this$0;

                /* JADX INFO: renamed from: cu.z17.preferences.PreferencesRepositoryImpl$flowValueOf$$inlined$secureMap$1$2$1, reason: invalid class name */
                /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
                @f(c = "cu.z17.preferences.PreferencesRepositoryImpl$flowValueOf$$inlined$secureMap$1$2", f = "PreferencesRepositoryImpl.kt", l = {223}, m = "emit")
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                public static final class AnonymousClass1 extends d {
                    int I$0;
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(e eVar) {
                        super(eVar);
                    }

                    @Override // cb.a
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(i iVar, PreferencesRepositoryImpl preferencesRepositoryImpl, Object obj, Preferences.Key key) {
                    this.$this_unsafeFlow = iVar;
                    this.this$0 = preferencesRepositoryImpl;
                    this.$default$inlined = obj;
                    this.$key$inlined = key;
                }

                /* JADX WARN: Code duplicated, block: B:7:0x0013  */
                @Override // te.i
                public final Object emit(Object obj, e eVar) {
                    AnonymousClass1 anonymousClass1;
                    Object objA;
                    if (eVar instanceof AnonymousClass1) {
                        anonymousClass1 = (AnonymousClass1) eVar;
                        int i10 = anonymousClass1.label;
                        if ((i10 & Integer.MIN_VALUE) != 0) {
                            anonymousClass1.label = i10 - Integer.MIN_VALUE;
                        } else {
                            anonymousClass1 = new AnonymousClass1(eVar);
                        }
                    } else {
                        anonymousClass1 = new AnonymousClass1(eVar);
                    }
                    Object obj2 = anonymousClass1.result;
                    Object objG = bb.b.g();
                    int i11 = anonymousClass1.label;
                    if (i11 == 0) {
                        v.b(obj2);
                        i iVar = this.$this_unsafeFlow;
                        try {
                            String str = (String) ((Preferences) obj).get(this.$key$inlined);
                            if (str != null) {
                                String strDecrypt = this.this$0.encryption.decrypt(str);
                                kf.b bVarB = kf.v.b(null, PreferencesRepositoryImpl$secureMap$1$1.INSTANCE, 1, null);
                                ef.b bVarD = t.d(z0.m(String.class));
                                y.g(bVarD, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                                y.f(strDecrypt);
                                objA = bVarB.a(bVarD, strDecrypt);
                            } else {
                                objA = this.$default$inlined;
                            }
                        } catch (Exception unused) {
                            b0 b0Var = this.this$0.errors;
                            b0Var.setValue(cb.b.d(((Number) b0Var.getValue()).intValue() + 1));
                            objA = this.$default$inlined;
                        }
                        anonymousClass1.L$0 = l.a(obj);
                        anonymousClass1.L$1 = l.a(anonymousClass1);
                        anonymousClass1.L$2 = l.a(obj);
                        anonymousClass1.L$3 = l.a(iVar);
                        anonymousClass1.I$0 = 0;
                        anonymousClass1.label = 1;
                        if (iVar.emit(objA, anonymousClass1) == objG) {
                            return objG;
                        }
                    } else {
                        if (i11 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        v.b(obj2);
                    }
                    return k0.f43947a;
                }
            }

            @Override // te.h
            public Object collect(i iVar, e eVar) {
                Object objCollect = hVarG.collect(new AnonymousClass2(iVar, this, str, keyStringKey), eVar);
                return objCollect == bb.b.g() ? objCollect : k0.f43947a;
            }
        };
    }

    public final p0 getErrorFlow() {
        return this.errorFlow;
    }

    public final Object resetAll(e<? super k0> eVar) {
        Object objEdit = PreferencesKt.edit(this.storage, new AnonymousClass2(null), eVar);
        return objEdit == bb.b.g() ? objEdit : k0.f43947a;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object retrieve(String str, final String str2, e<? super String> eVar) {
        C15181 c15181;
        if (eVar instanceof C15181) {
            c15181 = (C15181) eVar;
            int i10 = c15181.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c15181.label = i10 - Integer.MIN_VALUE;
            } else {
                c15181 = new C15181(eVar);
            }
        } else {
            c15181 = new C15181(eVar);
        }
        Object objX = c15181.result;
        Object objG = bb.b.g();
        int i11 = c15181.label;
        if (i11 == 0) {
            v.b(objX);
            final Preferences.Key<String> keyStringKey = PreferencesKeys.stringKey(str);
            final h hVarG = j.g(this.storage.getData(), new PreferencesRepositoryImpl$retrieve$value$1(this, null));
            h hVar = new h() { // from class: cu.z17.preferences.PreferencesRepositoryImpl$retrieve$$inlined$secureMap$1

                /* JADX INFO: renamed from: cu.z17.preferences.PreferencesRepositoryImpl$retrieve$$inlined$secureMap$1$2, reason: invalid class name */
                /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
                @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "R", AppMeasurementSdk.ConditionalUserProperty.VALUE, "Lua/k0;", "emit", "(Ljava/lang/Object;Lab/e;)Ljava/lang/Object;", "cu/z17/preferences/PreferencesRepositoryImpl$secureMap$$inlined$map$1$2", "<anonymous>"}, k = 3, mv = {2, 2, 0})
                public static final class AnonymousClass2<T> implements i {
                    final /* synthetic */ Object $default$inlined;
                    final /* synthetic */ Preferences.Key $key$inlined;
                    final /* synthetic */ i $this_unsafeFlow;
                    final /* synthetic */ PreferencesRepositoryImpl this$0;

                    /* JADX INFO: renamed from: cu.z17.preferences.PreferencesRepositoryImpl$retrieve$$inlined$secureMap$1$2$1, reason: invalid class name */
                    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
                    @f(c = "cu.z17.preferences.PreferencesRepositoryImpl$retrieve$$inlined$secureMap$1$2", f = "PreferencesRepositoryImpl.kt", l = {223}, m = "emit")
                    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                    public static final class AnonymousClass1 extends d {
                        int I$0;
                        Object L$0;
                        Object L$1;
                        Object L$2;
                        Object L$3;
                        int label;
                        /* synthetic */ Object result;

                        public AnonymousClass1(e eVar) {
                            super(eVar);
                        }

                        @Override // cb.a
                        public final Object invokeSuspend(Object obj) {
                            this.result = obj;
                            this.label |= Integer.MIN_VALUE;
                            return AnonymousClass2.this.emit(null, this);
                        }
                    }

                    public AnonymousClass2(i iVar, PreferencesRepositoryImpl preferencesRepositoryImpl, Object obj, Preferences.Key key) {
                        this.$this_unsafeFlow = iVar;
                        this.this$0 = preferencesRepositoryImpl;
                        this.$default$inlined = obj;
                        this.$key$inlined = key;
                    }

                    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
                    @Override // te.i
                    public final Object emit(Object obj, e eVar) {
                        AnonymousClass1 anonymousClass1;
                        Object objA;
                        if (eVar instanceof AnonymousClass1) {
                            anonymousClass1 = (AnonymousClass1) eVar;
                            int i10 = anonymousClass1.label;
                            if ((i10 & Integer.MIN_VALUE) != 0) {
                                anonymousClass1.label = i10 - Integer.MIN_VALUE;
                            } else {
                                anonymousClass1 = new AnonymousClass1(eVar);
                            }
                        } else {
                            anonymousClass1 = new AnonymousClass1(eVar);
                        }
                        Object obj2 = anonymousClass1.result;
                        Object objG = bb.b.g();
                        int i11 = anonymousClass1.label;
                        if (i11 == 0) {
                            v.b(obj2);
                            i iVar = this.$this_unsafeFlow;
                            try {
                                String str = (String) ((Preferences) obj).get(this.$key$inlined);
                                if (str != null) {
                                    String strDecrypt = this.this$0.encryption.decrypt(str);
                                    kf.b bVarB = kf.v.b(null, PreferencesRepositoryImpl$secureMap$1$1.INSTANCE, 1, null);
                                    ef.b bVarD = t.d(z0.m(String.class));
                                    y.g(bVarD, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                                    y.f(strDecrypt);
                                    objA = bVarB.a(bVarD, strDecrypt);
                                } else {
                                    objA = this.$default$inlined;
                                }
                            } catch (Exception unused) {
                                b0 b0Var = this.this$0.errors;
                                b0Var.setValue(cb.b.d(((Number) b0Var.getValue()).intValue() + 1));
                                objA = this.$default$inlined;
                            }
                            anonymousClass1.L$0 = l.a(obj);
                            anonymousClass1.L$1 = l.a(anonymousClass1);
                            anonymousClass1.L$2 = l.a(obj);
                            anonymousClass1.L$3 = l.a(iVar);
                            anonymousClass1.I$0 = 0;
                            anonymousClass1.label = 1;
                            if (iVar.emit(objA, anonymousClass1) == objG) {
                                return objG;
                            }
                        } else {
                            if (i11 != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            v.b(obj2);
                        }
                        return k0.f43947a;
                    }
                }

                @Override // te.h
                public Object collect(i iVar, e eVar2) {
                    Object objCollect = hVarG.collect(new AnonymousClass2(iVar, this, str2, keyStringKey), eVar2);
                    return objCollect == bb.b.g() ? objCollect : k0.f43947a;
                }
            };
            c15181.L$0 = l.a(str);
            c15181.L$1 = l.a(str2);
            c15181.L$2 = l.a(keyStringKey);
            c15181.label = 1;
            objX = j.x(hVar, c15181);
            if (objX == objG) {
                return objG;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v.b(objX);
        }
        return (String) objX;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object store(String str, String str2, e<? super Boolean> eVar) {
        C15231 c15231;
        if (eVar instanceof C15231) {
            c15231 = (C15231) eVar;
            int i10 = c15231.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c15231.label = i10 - Integer.MIN_VALUE;
            } else {
                c15231 = new C15231(eVar);
            }
        } else {
            c15231 = new C15231(eVar);
        }
        Object obj = c15231.result;
        Object objG = bb.b.g();
        int i11 = c15231.label;
        if (i11 == 0) {
            v.b(obj);
            Preferences.Key<String> keyStringKey = PreferencesKeys.stringKey(str);
            DataStore<Preferences> dataStore = this.storage;
            PreferencesRepositoryImpl$store$$inlined$secureEdit$1 preferencesRepositoryImpl$store$$inlined$secureEdit$1 = new PreferencesRepositoryImpl$store$$inlined$secureEdit$1(this, str2, null, keyStringKey);
            c15231.L$0 = l.a(str);
            c15231.L$1 = l.a(str2);
            c15231.L$2 = l.a(keyStringKey);
            c15231.L$3 = l.a(this);
            c15231.L$4 = l.a(dataStore);
            c15231.L$5 = l.a(str2);
            c15231.I$0 = 0;
            c15231.label = 1;
            if (PreferencesKt.edit(dataStore, preferencesRepositoryImpl$store$$inlined$secureEdit$1, c15231) == objG) {
                return objG;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v.b(obj);
        }
        return cb.b.a(true);
    }

    public static /* synthetic */ h flowValueOf$default(PreferencesRepositoryImpl preferencesRepositoryImpl, String str, int i10, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: flowValueOf");
        }
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        return preferencesRepositoryImpl.flowValueOf(str, i10);
    }

    public static /* synthetic */ Object retrieve$default(PreferencesRepositoryImpl preferencesRepositoryImpl, String str, int i10, e eVar, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: retrieve");
        }
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        return preferencesRepositoryImpl.retrieve(str, i10, (e<? super Integer>) eVar);
    }

    public static /* synthetic */ h flowValueOf$default(PreferencesRepositoryImpl preferencesRepositoryImpl, String str, double d10, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: flowValueOf");
        }
        if ((i10 & 2) != 0) {
            d10 = AudioStats.AUDIO_AMPLITUDE_NONE;
        }
        return preferencesRepositoryImpl.flowValueOf(str, d10);
    }

    public static /* synthetic */ Object retrieve$default(PreferencesRepositoryImpl preferencesRepositoryImpl, String str, double d10, e eVar, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: retrieve");
        }
        if ((i10 & 2) != 0) {
            d10 = AudioStats.AUDIO_AMPLITUDE_NONE;
        }
        return preferencesRepositoryImpl.retrieve(str, d10, (e<? super Double>) eVar);
    }

    public static /* synthetic */ h flowValueOf$default(PreferencesRepositoryImpl preferencesRepositoryImpl, String str, long j10, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: flowValueOf");
        }
        if ((i10 & 2) != 0) {
            j10 = 0;
        }
        return preferencesRepositoryImpl.flowValueOf(str, j10);
    }

    public static /* synthetic */ Object retrieve$default(PreferencesRepositoryImpl preferencesRepositoryImpl, String str, long j10, e eVar, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: retrieve");
        }
        if ((i10 & 2) != 0) {
            j10 = 0;
        }
        return preferencesRepositoryImpl.retrieve(str, j10, (e<? super Long>) eVar);
    }

    public final h flowValueOf(String keyName, int i10) {
        y.i(keyName, "keyName");
        final Preferences.Key<String> keyStringKey = PreferencesKeys.stringKey(keyName);
        final h hVarG = j.g(this.storage.getData(), new AnonymousClass3(null));
        final Integer numValueOf = Integer.valueOf(i10);
        return new h() { // from class: cu.z17.preferences.PreferencesRepositoryImpl$flowValueOf$$inlined$secureMap$2

            /* JADX INFO: renamed from: cu.z17.preferences.PreferencesRepositoryImpl$flowValueOf$$inlined$secureMap$2$2, reason: invalid class name */
            /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
            @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "R", AppMeasurementSdk.ConditionalUserProperty.VALUE, "Lua/k0;", "emit", "(Ljava/lang/Object;Lab/e;)Ljava/lang/Object;", "cu/z17/preferences/PreferencesRepositoryImpl$secureMap$$inlined$map$1$2", "<anonymous>"}, k = 3, mv = {2, 2, 0})
            public static final class AnonymousClass2<T> implements i {
                final /* synthetic */ Object $default$inlined;
                final /* synthetic */ Preferences.Key $key$inlined;
                final /* synthetic */ i $this_unsafeFlow;
                final /* synthetic */ PreferencesRepositoryImpl this$0;

                /* JADX INFO: renamed from: cu.z17.preferences.PreferencesRepositoryImpl$flowValueOf$$inlined$secureMap$2$2$1, reason: invalid class name */
                /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
                @f(c = "cu.z17.preferences.PreferencesRepositoryImpl$flowValueOf$$inlined$secureMap$2$2", f = "PreferencesRepositoryImpl.kt", l = {223}, m = "emit")
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                public static final class AnonymousClass1 extends d {
                    int I$0;
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(e eVar) {
                        super(eVar);
                    }

                    @Override // cb.a
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(i iVar, PreferencesRepositoryImpl preferencesRepositoryImpl, Object obj, Preferences.Key key) {
                    this.$this_unsafeFlow = iVar;
                    this.this$0 = preferencesRepositoryImpl;
                    this.$default$inlined = obj;
                    this.$key$inlined = key;
                }

                /* JADX WARN: Code duplicated, block: B:7:0x0013  */
                @Override // te.i
                public final Object emit(Object obj, e eVar) {
                    AnonymousClass1 anonymousClass1;
                    Object objA;
                    if (eVar instanceof AnonymousClass1) {
                        anonymousClass1 = (AnonymousClass1) eVar;
                        int i10 = anonymousClass1.label;
                        if ((i10 & Integer.MIN_VALUE) != 0) {
                            anonymousClass1.label = i10 - Integer.MIN_VALUE;
                        } else {
                            anonymousClass1 = new AnonymousClass1(eVar);
                        }
                    } else {
                        anonymousClass1 = new AnonymousClass1(eVar);
                    }
                    Object obj2 = anonymousClass1.result;
                    Object objG = bb.b.g();
                    int i11 = anonymousClass1.label;
                    if (i11 == 0) {
                        v.b(obj2);
                        i iVar = this.$this_unsafeFlow;
                        try {
                            String str = (String) ((Preferences) obj).get(this.$key$inlined);
                            if (str != null) {
                                String strDecrypt = this.this$0.encryption.decrypt(str);
                                kf.b bVarB = kf.v.b(null, PreferencesRepositoryImpl$secureMap$1$1.INSTANCE, 1, null);
                                ef.b bVarD = t.d(z0.m(Integer.TYPE));
                                y.g(bVarD, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                                y.f(strDecrypt);
                                objA = bVarB.a(bVarD, strDecrypt);
                            } else {
                                objA = this.$default$inlined;
                            }
                        } catch (Exception unused) {
                            b0 b0Var = this.this$0.errors;
                            b0Var.setValue(cb.b.d(((Number) b0Var.getValue()).intValue() + 1));
                            objA = this.$default$inlined;
                        }
                        anonymousClass1.L$0 = l.a(obj);
                        anonymousClass1.L$1 = l.a(anonymousClass1);
                        anonymousClass1.L$2 = l.a(obj);
                        anonymousClass1.L$3 = l.a(iVar);
                        anonymousClass1.I$0 = 0;
                        anonymousClass1.label = 1;
                        if (iVar.emit(objA, anonymousClass1) == objG) {
                            return objG;
                        }
                    } else {
                        if (i11 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        v.b(obj2);
                    }
                    return k0.f43947a;
                }
            }

            @Override // te.h
            public Object collect(i iVar, e eVar) {
                Object objCollect = hVarG.collect(new AnonymousClass2(iVar, this, numValueOf, keyStringKey), eVar);
                return objCollect == bb.b.g() ? objCollect : k0.f43947a;
            }
        };
    }

    public static /* synthetic */ h flowValueOf$default(PreferencesRepositoryImpl preferencesRepositoryImpl, String str, boolean z10, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: flowValueOf");
        }
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return preferencesRepositoryImpl.flowValueOf(str, z10);
    }

    public static /* synthetic */ Object retrieve$default(PreferencesRepositoryImpl preferencesRepositoryImpl, String str, boolean z10, e eVar, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: retrieve");
        }
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return preferencesRepositoryImpl.retrieve(str, z10, (e<? super Boolean>) eVar);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object store(String str, int i10, e<? super Boolean> eVar) {
        C15243 c15243;
        if (eVar instanceof C15243) {
            c15243 = (C15243) eVar;
            int i11 = c15243.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                c15243.label = i11 - Integer.MIN_VALUE;
            } else {
                c15243 = new C15243(eVar);
            }
        } else {
            c15243 = new C15243(eVar);
        }
        Object obj = c15243.result;
        Object objG = bb.b.g();
        int i12 = c15243.label;
        if (i12 == 0) {
            v.b(obj);
            Preferences.Key<String> keyStringKey = PreferencesKeys.stringKey(str);
            DataStore<Preferences> dataStore = this.storage;
            Integer numD = cb.b.d(i10);
            PreferencesRepositoryImpl$store$$inlined$secureEdit$2 preferencesRepositoryImpl$store$$inlined$secureEdit$2 = new PreferencesRepositoryImpl$store$$inlined$secureEdit$2(this, numD, null, keyStringKey);
            c15243.L$0 = l.a(str);
            c15243.L$1 = l.a(keyStringKey);
            c15243.L$2 = l.a(this);
            c15243.L$3 = l.a(dataStore);
            c15243.L$4 = l.a(numD);
            c15243.I$0 = i10;
            c15243.I$1 = 0;
            c15243.label = 1;
            if (PreferencesKt.edit(dataStore, preferencesRepositoryImpl$store$$inlined$secureEdit$2, c15243) == objG) {
                return objG;
            }
        } else {
            if (i12 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v.b(obj);
        }
        return cb.b.a(true);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object retrieve(String str, int i10, e<? super Integer> eVar) {
        C15192 c15192;
        if (eVar instanceof C15192) {
            c15192 = (C15192) eVar;
            int i11 = c15192.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                c15192.label = i11 - Integer.MIN_VALUE;
            } else {
                c15192 = new C15192(eVar);
            }
        } else {
            c15192 = new C15192(eVar);
        }
        Object objX = c15192.result;
        Object objG = bb.b.g();
        int i12 = c15192.label;
        if (i12 == 0) {
            v.b(objX);
            final Preferences.Key<String> keyStringKey = PreferencesKeys.stringKey(str);
            final h hVarG = j.g(this.storage.getData(), new PreferencesRepositoryImpl$retrieve$value$3(this, null));
            final Integer numD = cb.b.d(i10);
            h hVar = new h() { // from class: cu.z17.preferences.PreferencesRepositoryImpl$retrieve$$inlined$secureMap$2

                /* JADX INFO: renamed from: cu.z17.preferences.PreferencesRepositoryImpl$retrieve$$inlined$secureMap$2$2, reason: invalid class name */
                /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
                @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "R", AppMeasurementSdk.ConditionalUserProperty.VALUE, "Lua/k0;", "emit", "(Ljava/lang/Object;Lab/e;)Ljava/lang/Object;", "cu/z17/preferences/PreferencesRepositoryImpl$secureMap$$inlined$map$1$2", "<anonymous>"}, k = 3, mv = {2, 2, 0})
                public static final class AnonymousClass2<T> implements i {
                    final /* synthetic */ Object $default$inlined;
                    final /* synthetic */ Preferences.Key $key$inlined;
                    final /* synthetic */ i $this_unsafeFlow;
                    final /* synthetic */ PreferencesRepositoryImpl this$0;

                    /* JADX INFO: renamed from: cu.z17.preferences.PreferencesRepositoryImpl$retrieve$$inlined$secureMap$2$2$1, reason: invalid class name */
                    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
                    @f(c = "cu.z17.preferences.PreferencesRepositoryImpl$retrieve$$inlined$secureMap$2$2", f = "PreferencesRepositoryImpl.kt", l = {223}, m = "emit")
                    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                    public static final class AnonymousClass1 extends d {
                        int I$0;
                        Object L$0;
                        Object L$1;
                        Object L$2;
                        Object L$3;
                        int label;
                        /* synthetic */ Object result;

                        public AnonymousClass1(e eVar) {
                            super(eVar);
                        }

                        @Override // cb.a
                        public final Object invokeSuspend(Object obj) {
                            this.result = obj;
                            this.label |= Integer.MIN_VALUE;
                            return AnonymousClass2.this.emit(null, this);
                        }
                    }

                    public AnonymousClass2(i iVar, PreferencesRepositoryImpl preferencesRepositoryImpl, Object obj, Preferences.Key key) {
                        this.$this_unsafeFlow = iVar;
                        this.this$0 = preferencesRepositoryImpl;
                        this.$default$inlined = obj;
                        this.$key$inlined = key;
                    }

                    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
                    @Override // te.i
                    public final Object emit(Object obj, e eVar) {
                        AnonymousClass1 anonymousClass1;
                        Object objA;
                        if (eVar instanceof AnonymousClass1) {
                            anonymousClass1 = (AnonymousClass1) eVar;
                            int i10 = anonymousClass1.label;
                            if ((i10 & Integer.MIN_VALUE) != 0) {
                                anonymousClass1.label = i10 - Integer.MIN_VALUE;
                            } else {
                                anonymousClass1 = new AnonymousClass1(eVar);
                            }
                        } else {
                            anonymousClass1 = new AnonymousClass1(eVar);
                        }
                        Object obj2 = anonymousClass1.result;
                        Object objG = bb.b.g();
                        int i11 = anonymousClass1.label;
                        if (i11 == 0) {
                            v.b(obj2);
                            i iVar = this.$this_unsafeFlow;
                            try {
                                String str = (String) ((Preferences) obj).get(this.$key$inlined);
                                if (str != null) {
                                    String strDecrypt = this.this$0.encryption.decrypt(str);
                                    kf.b bVarB = kf.v.b(null, PreferencesRepositoryImpl$secureMap$1$1.INSTANCE, 1, null);
                                    ef.b bVarD = t.d(z0.m(Integer.TYPE));
                                    y.g(bVarD, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                                    y.f(strDecrypt);
                                    objA = bVarB.a(bVarD, strDecrypt);
                                } else {
                                    objA = this.$default$inlined;
                                }
                            } catch (Exception unused) {
                                b0 b0Var = this.this$0.errors;
                                b0Var.setValue(cb.b.d(((Number) b0Var.getValue()).intValue() + 1));
                                objA = this.$default$inlined;
                            }
                            anonymousClass1.L$0 = l.a(obj);
                            anonymousClass1.L$1 = l.a(anonymousClass1);
                            anonymousClass1.L$2 = l.a(obj);
                            anonymousClass1.L$3 = l.a(iVar);
                            anonymousClass1.I$0 = 0;
                            anonymousClass1.label = 1;
                            if (iVar.emit(objA, anonymousClass1) == objG) {
                                return objG;
                            }
                        } else {
                            if (i11 != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            v.b(obj2);
                        }
                        return k0.f43947a;
                    }
                }

                @Override // te.h
                public Object collect(i iVar, e eVar2) {
                    Object objCollect = hVarG.collect(new AnonymousClass2(iVar, this, numD, keyStringKey), eVar2);
                    return objCollect == bb.b.g() ? objCollect : k0.f43947a;
                }
            };
            c15192.L$0 = l.a(str);
            c15192.L$1 = l.a(keyStringKey);
            c15192.I$0 = i10;
            c15192.label = 1;
            objX = j.x(hVar, c15192);
            if (objX == objG) {
                return objG;
            }
        } else {
            if (i12 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v.b(objX);
        }
        return cb.b.d(((Number) objX).intValue());
    }

    public final h flowValueOf(String keyName, double d10) {
        y.i(keyName, "keyName");
        final Preferences.Key<String> keyStringKey = PreferencesKeys.stringKey(keyName);
        final h hVarG = j.g(this.storage.getData(), new AnonymousClass5(null));
        final Double dValueOf = Double.valueOf(d10);
        return new h() { // from class: cu.z17.preferences.PreferencesRepositoryImpl$flowValueOf$$inlined$secureMap$3

            /* JADX INFO: renamed from: cu.z17.preferences.PreferencesRepositoryImpl$flowValueOf$$inlined$secureMap$3$2, reason: invalid class name */
            /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
            @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "R", AppMeasurementSdk.ConditionalUserProperty.VALUE, "Lua/k0;", "emit", "(Ljava/lang/Object;Lab/e;)Ljava/lang/Object;", "cu/z17/preferences/PreferencesRepositoryImpl$secureMap$$inlined$map$1$2", "<anonymous>"}, k = 3, mv = {2, 2, 0})
            public static final class AnonymousClass2<T> implements i {
                final /* synthetic */ Object $default$inlined;
                final /* synthetic */ Preferences.Key $key$inlined;
                final /* synthetic */ i $this_unsafeFlow;
                final /* synthetic */ PreferencesRepositoryImpl this$0;

                /* JADX INFO: renamed from: cu.z17.preferences.PreferencesRepositoryImpl$flowValueOf$$inlined$secureMap$3$2$1, reason: invalid class name */
                /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
                @f(c = "cu.z17.preferences.PreferencesRepositoryImpl$flowValueOf$$inlined$secureMap$3$2", f = "PreferencesRepositoryImpl.kt", l = {223}, m = "emit")
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                public static final class AnonymousClass1 extends d {
                    int I$0;
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(e eVar) {
                        super(eVar);
                    }

                    @Override // cb.a
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(i iVar, PreferencesRepositoryImpl preferencesRepositoryImpl, Object obj, Preferences.Key key) {
                    this.$this_unsafeFlow = iVar;
                    this.this$0 = preferencesRepositoryImpl;
                    this.$default$inlined = obj;
                    this.$key$inlined = key;
                }

                /* JADX WARN: Code duplicated, block: B:7:0x0013  */
                @Override // te.i
                public final Object emit(Object obj, e eVar) {
                    AnonymousClass1 anonymousClass1;
                    Object objA;
                    if (eVar instanceof AnonymousClass1) {
                        anonymousClass1 = (AnonymousClass1) eVar;
                        int i10 = anonymousClass1.label;
                        if ((i10 & Integer.MIN_VALUE) != 0) {
                            anonymousClass1.label = i10 - Integer.MIN_VALUE;
                        } else {
                            anonymousClass1 = new AnonymousClass1(eVar);
                        }
                    } else {
                        anonymousClass1 = new AnonymousClass1(eVar);
                    }
                    Object obj2 = anonymousClass1.result;
                    Object objG = bb.b.g();
                    int i11 = anonymousClass1.label;
                    if (i11 == 0) {
                        v.b(obj2);
                        i iVar = this.$this_unsafeFlow;
                        try {
                            String str = (String) ((Preferences) obj).get(this.$key$inlined);
                            if (str != null) {
                                String strDecrypt = this.this$0.encryption.decrypt(str);
                                kf.b bVarB = kf.v.b(null, PreferencesRepositoryImpl$secureMap$1$1.INSTANCE, 1, null);
                                ef.b bVarD = t.d(z0.m(Double.TYPE));
                                y.g(bVarD, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                                y.f(strDecrypt);
                                objA = bVarB.a(bVarD, strDecrypt);
                            } else {
                                objA = this.$default$inlined;
                            }
                        } catch (Exception unused) {
                            b0 b0Var = this.this$0.errors;
                            b0Var.setValue(cb.b.d(((Number) b0Var.getValue()).intValue() + 1));
                            objA = this.$default$inlined;
                        }
                        anonymousClass1.L$0 = l.a(obj);
                        anonymousClass1.L$1 = l.a(anonymousClass1);
                        anonymousClass1.L$2 = l.a(obj);
                        anonymousClass1.L$3 = l.a(iVar);
                        anonymousClass1.I$0 = 0;
                        anonymousClass1.label = 1;
                        if (iVar.emit(objA, anonymousClass1) == objG) {
                            return objG;
                        }
                    } else {
                        if (i11 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        v.b(obj2);
                    }
                    return k0.f43947a;
                }
            }

            @Override // te.h
            public Object collect(i iVar, e eVar) {
                Object objCollect = hVarG.collect(new AnonymousClass2(iVar, this, dValueOf, keyStringKey), eVar);
                return objCollect == bb.b.g() ? objCollect : k0.f43947a;
            }
        };
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object store(String str, double d10, e<? super Boolean> eVar) {
        C15255 c15255;
        if (eVar instanceof C15255) {
            c15255 = (C15255) eVar;
            int i10 = c15255.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c15255.label = i10 - Integer.MIN_VALUE;
            } else {
                c15255 = new C15255(eVar);
            }
        } else {
            c15255 = new C15255(eVar);
        }
        Object obj = c15255.result;
        Object objG = bb.b.g();
        int i11 = c15255.label;
        if (i11 == 0) {
            v.b(obj);
            Preferences.Key<String> keyStringKey = PreferencesKeys.stringKey(str);
            DataStore<Preferences> dataStore = this.storage;
            Double dB = cb.b.b(d10);
            PreferencesRepositoryImpl$store$$inlined$secureEdit$3 preferencesRepositoryImpl$store$$inlined$secureEdit$3 = new PreferencesRepositoryImpl$store$$inlined$secureEdit$3(this, dB, null, keyStringKey);
            c15255.L$0 = l.a(str);
            c15255.L$1 = l.a(keyStringKey);
            c15255.L$2 = l.a(this);
            c15255.L$3 = l.a(dataStore);
            c15255.L$4 = l.a(dB);
            c15255.D$0 = d10;
            c15255.I$0 = 0;
            c15255.label = 1;
            if (PreferencesKt.edit(dataStore, preferencesRepositoryImpl$store$$inlined$secureEdit$3, c15255) == objG) {
                return objG;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v.b(obj);
        }
        return cb.b.a(true);
    }

    public final h flowValueOf(String keyName, long j10) {
        y.i(keyName, "keyName");
        final Preferences.Key<String> keyStringKey = PreferencesKeys.stringKey(keyName);
        final h hVarG = j.g(this.storage.getData(), new AnonymousClass7(null));
        final Long lValueOf = Long.valueOf(j10);
        return new h() { // from class: cu.z17.preferences.PreferencesRepositoryImpl$flowValueOf$$inlined$secureMap$4

            /* JADX INFO: renamed from: cu.z17.preferences.PreferencesRepositoryImpl$flowValueOf$$inlined$secureMap$4$2, reason: invalid class name */
            /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
            @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "R", AppMeasurementSdk.ConditionalUserProperty.VALUE, "Lua/k0;", "emit", "(Ljava/lang/Object;Lab/e;)Ljava/lang/Object;", "cu/z17/preferences/PreferencesRepositoryImpl$secureMap$$inlined$map$1$2", "<anonymous>"}, k = 3, mv = {2, 2, 0})
            public static final class AnonymousClass2<T> implements i {
                final /* synthetic */ Object $default$inlined;
                final /* synthetic */ Preferences.Key $key$inlined;
                final /* synthetic */ i $this_unsafeFlow;
                final /* synthetic */ PreferencesRepositoryImpl this$0;

                /* JADX INFO: renamed from: cu.z17.preferences.PreferencesRepositoryImpl$flowValueOf$$inlined$secureMap$4$2$1, reason: invalid class name */
                /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
                @f(c = "cu.z17.preferences.PreferencesRepositoryImpl$flowValueOf$$inlined$secureMap$4$2", f = "PreferencesRepositoryImpl.kt", l = {223}, m = "emit")
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                public static final class AnonymousClass1 extends d {
                    int I$0;
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(e eVar) {
                        super(eVar);
                    }

                    @Override // cb.a
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(i iVar, PreferencesRepositoryImpl preferencesRepositoryImpl, Object obj, Preferences.Key key) {
                    this.$this_unsafeFlow = iVar;
                    this.this$0 = preferencesRepositoryImpl;
                    this.$default$inlined = obj;
                    this.$key$inlined = key;
                }

                /* JADX WARN: Code duplicated, block: B:7:0x0013  */
                @Override // te.i
                public final Object emit(Object obj, e eVar) {
                    AnonymousClass1 anonymousClass1;
                    Object objA;
                    if (eVar instanceof AnonymousClass1) {
                        anonymousClass1 = (AnonymousClass1) eVar;
                        int i10 = anonymousClass1.label;
                        if ((i10 & Integer.MIN_VALUE) != 0) {
                            anonymousClass1.label = i10 - Integer.MIN_VALUE;
                        } else {
                            anonymousClass1 = new AnonymousClass1(eVar);
                        }
                    } else {
                        anonymousClass1 = new AnonymousClass1(eVar);
                    }
                    Object obj2 = anonymousClass1.result;
                    Object objG = bb.b.g();
                    int i11 = anonymousClass1.label;
                    if (i11 == 0) {
                        v.b(obj2);
                        i iVar = this.$this_unsafeFlow;
                        try {
                            String str = (String) ((Preferences) obj).get(this.$key$inlined);
                            if (str != null) {
                                String strDecrypt = this.this$0.encryption.decrypt(str);
                                kf.b bVarB = kf.v.b(null, PreferencesRepositoryImpl$secureMap$1$1.INSTANCE, 1, null);
                                ef.b bVarD = t.d(z0.m(Long.TYPE));
                                y.g(bVarD, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                                y.f(strDecrypt);
                                objA = bVarB.a(bVarD, strDecrypt);
                            } else {
                                objA = this.$default$inlined;
                            }
                        } catch (Exception unused) {
                            b0 b0Var = this.this$0.errors;
                            b0Var.setValue(cb.b.d(((Number) b0Var.getValue()).intValue() + 1));
                            objA = this.$default$inlined;
                        }
                        anonymousClass1.L$0 = l.a(obj);
                        anonymousClass1.L$1 = l.a(anonymousClass1);
                        anonymousClass1.L$2 = l.a(obj);
                        anonymousClass1.L$3 = l.a(iVar);
                        anonymousClass1.I$0 = 0;
                        anonymousClass1.label = 1;
                        if (iVar.emit(objA, anonymousClass1) == objG) {
                            return objG;
                        }
                    } else {
                        if (i11 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        v.b(obj2);
                    }
                    return k0.f43947a;
                }
            }

            @Override // te.h
            public Object collect(i iVar, e eVar) {
                Object objCollect = hVarG.collect(new AnonymousClass2(iVar, this, lValueOf, keyStringKey), eVar);
                return objCollect == bb.b.g() ? objCollect : k0.f43947a;
            }
        };
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object retrieve(String str, double d10, e<? super Double> eVar) {
        C15203 c15203;
        if (eVar instanceof C15203) {
            c15203 = (C15203) eVar;
            int i10 = c15203.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c15203.label = i10 - Integer.MIN_VALUE;
            } else {
                c15203 = new C15203(eVar);
            }
        } else {
            c15203 = new C15203(eVar);
        }
        Object objX = c15203.result;
        Object objG = bb.b.g();
        int i11 = c15203.label;
        if (i11 == 0) {
            v.b(objX);
            final Preferences.Key<String> keyStringKey = PreferencesKeys.stringKey(str);
            final h hVarG = j.g(this.storage.getData(), new PreferencesRepositoryImpl$retrieve$value$5(this, null));
            final Double dB = cb.b.b(d10);
            h hVar = new h() { // from class: cu.z17.preferences.PreferencesRepositoryImpl$retrieve$$inlined$secureMap$3

                /* JADX INFO: renamed from: cu.z17.preferences.PreferencesRepositoryImpl$retrieve$$inlined$secureMap$3$2, reason: invalid class name */
                /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
                @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "R", AppMeasurementSdk.ConditionalUserProperty.VALUE, "Lua/k0;", "emit", "(Ljava/lang/Object;Lab/e;)Ljava/lang/Object;", "cu/z17/preferences/PreferencesRepositoryImpl$secureMap$$inlined$map$1$2", "<anonymous>"}, k = 3, mv = {2, 2, 0})
                public static final class AnonymousClass2<T> implements i {
                    final /* synthetic */ Object $default$inlined;
                    final /* synthetic */ Preferences.Key $key$inlined;
                    final /* synthetic */ i $this_unsafeFlow;
                    final /* synthetic */ PreferencesRepositoryImpl this$0;

                    /* JADX INFO: renamed from: cu.z17.preferences.PreferencesRepositoryImpl$retrieve$$inlined$secureMap$3$2$1, reason: invalid class name */
                    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
                    @f(c = "cu.z17.preferences.PreferencesRepositoryImpl$retrieve$$inlined$secureMap$3$2", f = "PreferencesRepositoryImpl.kt", l = {223}, m = "emit")
                    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                    public static final class AnonymousClass1 extends d {
                        int I$0;
                        Object L$0;
                        Object L$1;
                        Object L$2;
                        Object L$3;
                        int label;
                        /* synthetic */ Object result;

                        public AnonymousClass1(e eVar) {
                            super(eVar);
                        }

                        @Override // cb.a
                        public final Object invokeSuspend(Object obj) {
                            this.result = obj;
                            this.label |= Integer.MIN_VALUE;
                            return AnonymousClass2.this.emit(null, this);
                        }
                    }

                    public AnonymousClass2(i iVar, PreferencesRepositoryImpl preferencesRepositoryImpl, Object obj, Preferences.Key key) {
                        this.$this_unsafeFlow = iVar;
                        this.this$0 = preferencesRepositoryImpl;
                        this.$default$inlined = obj;
                        this.$key$inlined = key;
                    }

                    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
                    @Override // te.i
                    public final Object emit(Object obj, e eVar) {
                        AnonymousClass1 anonymousClass1;
                        Object objA;
                        if (eVar instanceof AnonymousClass1) {
                            anonymousClass1 = (AnonymousClass1) eVar;
                            int i10 = anonymousClass1.label;
                            if ((i10 & Integer.MIN_VALUE) != 0) {
                                anonymousClass1.label = i10 - Integer.MIN_VALUE;
                            } else {
                                anonymousClass1 = new AnonymousClass1(eVar);
                            }
                        } else {
                            anonymousClass1 = new AnonymousClass1(eVar);
                        }
                        Object obj2 = anonymousClass1.result;
                        Object objG = bb.b.g();
                        int i11 = anonymousClass1.label;
                        if (i11 == 0) {
                            v.b(obj2);
                            i iVar = this.$this_unsafeFlow;
                            try {
                                String str = (String) ((Preferences) obj).get(this.$key$inlined);
                                if (str != null) {
                                    String strDecrypt = this.this$0.encryption.decrypt(str);
                                    kf.b bVarB = kf.v.b(null, PreferencesRepositoryImpl$secureMap$1$1.INSTANCE, 1, null);
                                    ef.b bVarD = t.d(z0.m(Double.TYPE));
                                    y.g(bVarD, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                                    y.f(strDecrypt);
                                    objA = bVarB.a(bVarD, strDecrypt);
                                } else {
                                    objA = this.$default$inlined;
                                }
                            } catch (Exception unused) {
                                b0 b0Var = this.this$0.errors;
                                b0Var.setValue(cb.b.d(((Number) b0Var.getValue()).intValue() + 1));
                                objA = this.$default$inlined;
                            }
                            anonymousClass1.L$0 = l.a(obj);
                            anonymousClass1.L$1 = l.a(anonymousClass1);
                            anonymousClass1.L$2 = l.a(obj);
                            anonymousClass1.L$3 = l.a(iVar);
                            anonymousClass1.I$0 = 0;
                            anonymousClass1.label = 1;
                            if (iVar.emit(objA, anonymousClass1) == objG) {
                                return objG;
                            }
                        } else {
                            if (i11 != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            v.b(obj2);
                        }
                        return k0.f43947a;
                    }
                }

                @Override // te.h
                public Object collect(i iVar, e eVar2) {
                    Object objCollect = hVarG.collect(new AnonymousClass2(iVar, this, dB, keyStringKey), eVar2);
                    return objCollect == bb.b.g() ? objCollect : k0.f43947a;
                }
            };
            c15203.L$0 = l.a(str);
            c15203.L$1 = l.a(keyStringKey);
            c15203.D$0 = d10;
            c15203.label = 1;
            objX = j.x(hVar, c15203);
            if (objX == objG) {
                return objG;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v.b(objX);
        }
        return cb.b.b(((Number) objX).doubleValue());
    }

    public final h flowValueOf(String keyName, boolean z10) {
        y.i(keyName, "keyName");
        final Preferences.Key<String> keyStringKey = PreferencesKeys.stringKey(keyName);
        final h hVarG = j.g(this.storage.getData(), new AnonymousClass9(null));
        final Boolean boolValueOf = Boolean.valueOf(z10);
        return new h() { // from class: cu.z17.preferences.PreferencesRepositoryImpl$flowValueOf$$inlined$secureMap$5

            /* JADX INFO: renamed from: cu.z17.preferences.PreferencesRepositoryImpl$flowValueOf$$inlined$secureMap$5$2, reason: invalid class name */
            /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
            @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "R", AppMeasurementSdk.ConditionalUserProperty.VALUE, "Lua/k0;", "emit", "(Ljava/lang/Object;Lab/e;)Ljava/lang/Object;", "cu/z17/preferences/PreferencesRepositoryImpl$secureMap$$inlined$map$1$2", "<anonymous>"}, k = 3, mv = {2, 2, 0})
            public static final class AnonymousClass2<T> implements i {
                final /* synthetic */ Object $default$inlined;
                final /* synthetic */ Preferences.Key $key$inlined;
                final /* synthetic */ i $this_unsafeFlow;
                final /* synthetic */ PreferencesRepositoryImpl this$0;

                /* JADX INFO: renamed from: cu.z17.preferences.PreferencesRepositoryImpl$flowValueOf$$inlined$secureMap$5$2$1, reason: invalid class name */
                /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
                @f(c = "cu.z17.preferences.PreferencesRepositoryImpl$flowValueOf$$inlined$secureMap$5$2", f = "PreferencesRepositoryImpl.kt", l = {223}, m = "emit")
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                public static final class AnonymousClass1 extends d {
                    int I$0;
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(e eVar) {
                        super(eVar);
                    }

                    @Override // cb.a
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(i iVar, PreferencesRepositoryImpl preferencesRepositoryImpl, Object obj, Preferences.Key key) {
                    this.$this_unsafeFlow = iVar;
                    this.this$0 = preferencesRepositoryImpl;
                    this.$default$inlined = obj;
                    this.$key$inlined = key;
                }

                /* JADX WARN: Code duplicated, block: B:7:0x0013  */
                @Override // te.i
                public final Object emit(Object obj, e eVar) {
                    AnonymousClass1 anonymousClass1;
                    Object objA;
                    if (eVar instanceof AnonymousClass1) {
                        anonymousClass1 = (AnonymousClass1) eVar;
                        int i10 = anonymousClass1.label;
                        if ((i10 & Integer.MIN_VALUE) != 0) {
                            anonymousClass1.label = i10 - Integer.MIN_VALUE;
                        } else {
                            anonymousClass1 = new AnonymousClass1(eVar);
                        }
                    } else {
                        anonymousClass1 = new AnonymousClass1(eVar);
                    }
                    Object obj2 = anonymousClass1.result;
                    Object objG = bb.b.g();
                    int i11 = anonymousClass1.label;
                    if (i11 == 0) {
                        v.b(obj2);
                        i iVar = this.$this_unsafeFlow;
                        try {
                            String str = (String) ((Preferences) obj).get(this.$key$inlined);
                            if (str != null) {
                                String strDecrypt = this.this$0.encryption.decrypt(str);
                                kf.b bVarB = kf.v.b(null, PreferencesRepositoryImpl$secureMap$1$1.INSTANCE, 1, null);
                                ef.b bVarD = t.d(z0.m(Boolean.TYPE));
                                y.g(bVarD, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                                y.f(strDecrypt);
                                objA = bVarB.a(bVarD, strDecrypt);
                            } else {
                                objA = this.$default$inlined;
                            }
                        } catch (Exception unused) {
                            b0 b0Var = this.this$0.errors;
                            b0Var.setValue(cb.b.d(((Number) b0Var.getValue()).intValue() + 1));
                            objA = this.$default$inlined;
                        }
                        anonymousClass1.L$0 = l.a(obj);
                        anonymousClass1.L$1 = l.a(anonymousClass1);
                        anonymousClass1.L$2 = l.a(obj);
                        anonymousClass1.L$3 = l.a(iVar);
                        anonymousClass1.I$0 = 0;
                        anonymousClass1.label = 1;
                        if (iVar.emit(objA, anonymousClass1) == objG) {
                            return objG;
                        }
                    } else {
                        if (i11 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        v.b(obj2);
                    }
                    return k0.f43947a;
                }
            }

            @Override // te.h
            public Object collect(i iVar, e eVar) {
                Object objCollect = hVarG.collect(new AnonymousClass2(iVar, this, boolValueOf, keyStringKey), eVar);
                return objCollect == bb.b.g() ? objCollect : k0.f43947a;
            }
        };
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object store(String str, long j10, e<? super Boolean> eVar) {
        C15267 c15267;
        if (eVar instanceof C15267) {
            c15267 = (C15267) eVar;
            int i10 = c15267.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c15267.label = i10 - Integer.MIN_VALUE;
            } else {
                c15267 = new C15267(eVar);
            }
        } else {
            c15267 = new C15267(eVar);
        }
        Object obj = c15267.result;
        Object objG = bb.b.g();
        int i11 = c15267.label;
        if (i11 == 0) {
            v.b(obj);
            Preferences.Key<String> keyStringKey = PreferencesKeys.stringKey(str);
            DataStore<Preferences> dataStore = this.storage;
            Long lE = cb.b.e(j10);
            PreferencesRepositoryImpl$store$$inlined$secureEdit$4 preferencesRepositoryImpl$store$$inlined$secureEdit$4 = new PreferencesRepositoryImpl$store$$inlined$secureEdit$4(this, lE, null, keyStringKey);
            c15267.L$0 = l.a(str);
            c15267.L$1 = l.a(keyStringKey);
            c15267.L$2 = l.a(this);
            c15267.L$3 = l.a(dataStore);
            c15267.L$4 = l.a(lE);
            c15267.J$0 = j10;
            c15267.I$0 = 0;
            c15267.label = 1;
            if (PreferencesKt.edit(dataStore, preferencesRepositoryImpl$store$$inlined$secureEdit$4, c15267) == objG) {
                return objG;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v.b(obj);
        }
        return cb.b.a(true);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object retrieve(String str, long j10, e<? super Long> eVar) {
        AnonymousClass4 anonymousClass4;
        if (eVar instanceof AnonymousClass4) {
            anonymousClass4 = (AnonymousClass4) eVar;
            int i10 = anonymousClass4.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                anonymousClass4.label = i10 - Integer.MIN_VALUE;
            } else {
                anonymousClass4 = new AnonymousClass4(eVar);
            }
        } else {
            anonymousClass4 = new AnonymousClass4(eVar);
        }
        Object objX = anonymousClass4.result;
        Object objG = bb.b.g();
        int i11 = anonymousClass4.label;
        if (i11 == 0) {
            v.b(objX);
            final Preferences.Key<String> keyStringKey = PreferencesKeys.stringKey(str);
            final h hVarG = j.g(this.storage.getData(), new PreferencesRepositoryImpl$retrieve$value$7(this, null));
            final Long lE = cb.b.e(j10);
            h hVar = new h() { // from class: cu.z17.preferences.PreferencesRepositoryImpl$retrieve$$inlined$secureMap$4

                /* JADX INFO: renamed from: cu.z17.preferences.PreferencesRepositoryImpl$retrieve$$inlined$secureMap$4$2, reason: invalid class name */
                /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
                @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "R", AppMeasurementSdk.ConditionalUserProperty.VALUE, "Lua/k0;", "emit", "(Ljava/lang/Object;Lab/e;)Ljava/lang/Object;", "cu/z17/preferences/PreferencesRepositoryImpl$secureMap$$inlined$map$1$2", "<anonymous>"}, k = 3, mv = {2, 2, 0})
                public static final class AnonymousClass2<T> implements i {
                    final /* synthetic */ Object $default$inlined;
                    final /* synthetic */ Preferences.Key $key$inlined;
                    final /* synthetic */ i $this_unsafeFlow;
                    final /* synthetic */ PreferencesRepositoryImpl this$0;

                    /* JADX INFO: renamed from: cu.z17.preferences.PreferencesRepositoryImpl$retrieve$$inlined$secureMap$4$2$1, reason: invalid class name */
                    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
                    @f(c = "cu.z17.preferences.PreferencesRepositoryImpl$retrieve$$inlined$secureMap$4$2", f = "PreferencesRepositoryImpl.kt", l = {223}, m = "emit")
                    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                    public static final class AnonymousClass1 extends d {
                        int I$0;
                        Object L$0;
                        Object L$1;
                        Object L$2;
                        Object L$3;
                        int label;
                        /* synthetic */ Object result;

                        public AnonymousClass1(e eVar) {
                            super(eVar);
                        }

                        @Override // cb.a
                        public final Object invokeSuspend(Object obj) {
                            this.result = obj;
                            this.label |= Integer.MIN_VALUE;
                            return AnonymousClass2.this.emit(null, this);
                        }
                    }

                    public AnonymousClass2(i iVar, PreferencesRepositoryImpl preferencesRepositoryImpl, Object obj, Preferences.Key key) {
                        this.$this_unsafeFlow = iVar;
                        this.this$0 = preferencesRepositoryImpl;
                        this.$default$inlined = obj;
                        this.$key$inlined = key;
                    }

                    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
                    @Override // te.i
                    public final Object emit(Object obj, e eVar) {
                        AnonymousClass1 anonymousClass1;
                        Object objA;
                        if (eVar instanceof AnonymousClass1) {
                            anonymousClass1 = (AnonymousClass1) eVar;
                            int i10 = anonymousClass1.label;
                            if ((i10 & Integer.MIN_VALUE) != 0) {
                                anonymousClass1.label = i10 - Integer.MIN_VALUE;
                            } else {
                                anonymousClass1 = new AnonymousClass1(eVar);
                            }
                        } else {
                            anonymousClass1 = new AnonymousClass1(eVar);
                        }
                        Object obj2 = anonymousClass1.result;
                        Object objG = bb.b.g();
                        int i11 = anonymousClass1.label;
                        if (i11 == 0) {
                            v.b(obj2);
                            i iVar = this.$this_unsafeFlow;
                            try {
                                String str = (String) ((Preferences) obj).get(this.$key$inlined);
                                if (str != null) {
                                    String strDecrypt = this.this$0.encryption.decrypt(str);
                                    kf.b bVarB = kf.v.b(null, PreferencesRepositoryImpl$secureMap$1$1.INSTANCE, 1, null);
                                    ef.b bVarD = t.d(z0.m(Long.TYPE));
                                    y.g(bVarD, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                                    y.f(strDecrypt);
                                    objA = bVarB.a(bVarD, strDecrypt);
                                } else {
                                    objA = this.$default$inlined;
                                }
                            } catch (Exception unused) {
                                b0 b0Var = this.this$0.errors;
                                b0Var.setValue(cb.b.d(((Number) b0Var.getValue()).intValue() + 1));
                                objA = this.$default$inlined;
                            }
                            anonymousClass1.L$0 = l.a(obj);
                            anonymousClass1.L$1 = l.a(anonymousClass1);
                            anonymousClass1.L$2 = l.a(obj);
                            anonymousClass1.L$3 = l.a(iVar);
                            anonymousClass1.I$0 = 0;
                            anonymousClass1.label = 1;
                            if (iVar.emit(objA, anonymousClass1) == objG) {
                                return objG;
                            }
                        } else {
                            if (i11 != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            v.b(obj2);
                        }
                        return k0.f43947a;
                    }
                }

                @Override // te.h
                public Object collect(i iVar, e eVar2) {
                    Object objCollect = hVarG.collect(new AnonymousClass2(iVar, this, lE, keyStringKey), eVar2);
                    return objCollect == bb.b.g() ? objCollect : k0.f43947a;
                }
            };
            anonymousClass4.L$0 = l.a(str);
            anonymousClass4.L$1 = l.a(keyStringKey);
            anonymousClass4.J$0 = j10;
            anonymousClass4.label = 1;
            objX = j.x(hVar, anonymousClass4);
            if (objX == objG) {
                return objG;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v.b(objX);
        }
        return cb.b.e(((Number) objX).longValue());
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object store(String str, boolean z10, e<? super Boolean> eVar) {
        C15279 c15279;
        if (eVar instanceof C15279) {
            c15279 = (C15279) eVar;
            int i10 = c15279.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c15279.label = i10 - Integer.MIN_VALUE;
            } else {
                c15279 = new C15279(eVar);
            }
        } else {
            c15279 = new C15279(eVar);
        }
        Object obj = c15279.result;
        Object objG = bb.b.g();
        int i11 = c15279.label;
        if (i11 == 0) {
            v.b(obj);
            Preferences.Key<String> keyStringKey = PreferencesKeys.stringKey(str);
            DataStore<Preferences> dataStore = this.storage;
            Boolean boolA = cb.b.a(z10);
            PreferencesRepositoryImpl$store$$inlined$secureEdit$5 preferencesRepositoryImpl$store$$inlined$secureEdit$5 = new PreferencesRepositoryImpl$store$$inlined$secureEdit$5(this, boolA, null, keyStringKey);
            c15279.L$0 = l.a(str);
            c15279.L$1 = l.a(keyStringKey);
            c15279.L$2 = l.a(this);
            c15279.L$3 = l.a(dataStore);
            c15279.L$4 = l.a(boolA);
            c15279.Z$0 = z10;
            c15279.I$0 = 0;
            c15279.label = 1;
            if (PreferencesKt.edit(dataStore, preferencesRepositoryImpl$store$$inlined$secureEdit$5, c15279) == objG) {
                return objG;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v.b(obj);
        }
        return cb.b.a(true);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object retrieve(String str, boolean z10, e<? super Boolean> eVar) {
        C15215 c15215;
        if (eVar instanceof C15215) {
            c15215 = (C15215) eVar;
            int i10 = c15215.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c15215.label = i10 - Integer.MIN_VALUE;
            } else {
                c15215 = new C15215(eVar);
            }
        } else {
            c15215 = new C15215(eVar);
        }
        Object objX = c15215.result;
        Object objG = bb.b.g();
        int i11 = c15215.label;
        if (i11 == 0) {
            v.b(objX);
            final Preferences.Key<String> keyStringKey = PreferencesKeys.stringKey(str);
            final h hVarG = j.g(this.storage.getData(), new PreferencesRepositoryImpl$retrieve$value$9(this, null));
            final Boolean boolA = cb.b.a(z10);
            h hVar = new h() { // from class: cu.z17.preferences.PreferencesRepositoryImpl$retrieve$$inlined$secureMap$5

                /* JADX INFO: renamed from: cu.z17.preferences.PreferencesRepositoryImpl$retrieve$$inlined$secureMap$5$2, reason: invalid class name */
                /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
                @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "R", AppMeasurementSdk.ConditionalUserProperty.VALUE, "Lua/k0;", "emit", "(Ljava/lang/Object;Lab/e;)Ljava/lang/Object;", "cu/z17/preferences/PreferencesRepositoryImpl$secureMap$$inlined$map$1$2", "<anonymous>"}, k = 3, mv = {2, 2, 0})
                public static final class AnonymousClass2<T> implements i {
                    final /* synthetic */ Object $default$inlined;
                    final /* synthetic */ Preferences.Key $key$inlined;
                    final /* synthetic */ i $this_unsafeFlow;
                    final /* synthetic */ PreferencesRepositoryImpl this$0;

                    /* JADX INFO: renamed from: cu.z17.preferences.PreferencesRepositoryImpl$retrieve$$inlined$secureMap$5$2$1, reason: invalid class name */
                    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
                    @f(c = "cu.z17.preferences.PreferencesRepositoryImpl$retrieve$$inlined$secureMap$5$2", f = "PreferencesRepositoryImpl.kt", l = {223}, m = "emit")
                    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                    public static final class AnonymousClass1 extends d {
                        int I$0;
                        Object L$0;
                        Object L$1;
                        Object L$2;
                        Object L$3;
                        int label;
                        /* synthetic */ Object result;

                        public AnonymousClass1(e eVar) {
                            super(eVar);
                        }

                        @Override // cb.a
                        public final Object invokeSuspend(Object obj) {
                            this.result = obj;
                            this.label |= Integer.MIN_VALUE;
                            return AnonymousClass2.this.emit(null, this);
                        }
                    }

                    public AnonymousClass2(i iVar, PreferencesRepositoryImpl preferencesRepositoryImpl, Object obj, Preferences.Key key) {
                        this.$this_unsafeFlow = iVar;
                        this.this$0 = preferencesRepositoryImpl;
                        this.$default$inlined = obj;
                        this.$key$inlined = key;
                    }

                    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
                    @Override // te.i
                    public final Object emit(Object obj, e eVar) {
                        AnonymousClass1 anonymousClass1;
                        Object objA;
                        if (eVar instanceof AnonymousClass1) {
                            anonymousClass1 = (AnonymousClass1) eVar;
                            int i10 = anonymousClass1.label;
                            if ((i10 & Integer.MIN_VALUE) != 0) {
                                anonymousClass1.label = i10 - Integer.MIN_VALUE;
                            } else {
                                anonymousClass1 = new AnonymousClass1(eVar);
                            }
                        } else {
                            anonymousClass1 = new AnonymousClass1(eVar);
                        }
                        Object obj2 = anonymousClass1.result;
                        Object objG = bb.b.g();
                        int i11 = anonymousClass1.label;
                        if (i11 == 0) {
                            v.b(obj2);
                            i iVar = this.$this_unsafeFlow;
                            try {
                                String str = (String) ((Preferences) obj).get(this.$key$inlined);
                                if (str != null) {
                                    String strDecrypt = this.this$0.encryption.decrypt(str);
                                    kf.b bVarB = kf.v.b(null, PreferencesRepositoryImpl$secureMap$1$1.INSTANCE, 1, null);
                                    ef.b bVarD = t.d(z0.m(Boolean.TYPE));
                                    y.g(bVarD, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                                    y.f(strDecrypt);
                                    objA = bVarB.a(bVarD, strDecrypt);
                                } else {
                                    objA = this.$default$inlined;
                                }
                            } catch (Exception unused) {
                                b0 b0Var = this.this$0.errors;
                                b0Var.setValue(cb.b.d(((Number) b0Var.getValue()).intValue() + 1));
                                objA = this.$default$inlined;
                            }
                            anonymousClass1.L$0 = l.a(obj);
                            anonymousClass1.L$1 = l.a(anonymousClass1);
                            anonymousClass1.L$2 = l.a(obj);
                            anonymousClass1.L$3 = l.a(iVar);
                            anonymousClass1.I$0 = 0;
                            anonymousClass1.label = 1;
                            if (iVar.emit(objA, anonymousClass1) == objG) {
                                return objG;
                            }
                        } else {
                            if (i11 != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            v.b(obj2);
                        }
                        return k0.f43947a;
                    }
                }

                @Override // te.h
                public Object collect(i iVar, e eVar2) {
                    Object objCollect = hVarG.collect(new AnonymousClass2(iVar, this, boolA, keyStringKey), eVar2);
                    return objCollect == bb.b.g() ? objCollect : k0.f43947a;
                }
            };
            c15215.L$0 = l.a(str);
            c15215.L$1 = l.a(keyStringKey);
            c15215.Z$0 = z10;
            c15215.label = 1;
            objX = j.x(hVar, c15215);
            if (objX == objG) {
                return objG;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v.b(objX);
        }
        return cb.b.a(((Boolean) objX).booleanValue());
    }
}
