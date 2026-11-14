package cu.todus.android.di;

import android.content.Context;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.media3.extractor.ts.PsExtractor;
import androidx.media3.extractor.ts.TsExtractor;
import androidx.media3.muxer.WebmConstants;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import cu.todus.android.constants.Service;
import cu.todus.android.data.db.entity.toDus.UserRoomJoin;
import cu.todus.android.data.preferences.AliveWelcomeMessageDataPreferences;
import cu.todus.android.data.preferences.AppState;
import cu.todus.android.data.preferences.AppStateStep;
import cu.todus.android.data.preferences.CallQuality;
import cu.todus.android.data.preferences.DataPreferences;
import cu.todus.android.data.preferences.Owner;
import cu.todus.android.data.preferences.ReactionsSelected;
import cu.todus.android.data.preferences.RootEnvironment;
import cu.todus.android.migration.ToDus2Migration;
import cu.todus.android.migration.legacy.SharedPreferencesStorage;
import cu.z17.preferences.Z17Preferences;
import cu.z17.singledi.SingletonInitializer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.y;
import le.d0;
import pe.d1;
import pe.e2;
import pe.m0;
import pe.n0;
import te.p0;
import ua.k0;
import ua.v;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b \b\u0007\u0018\u0000 o2\u00020\u0001:\u0001oB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fH\u0086@¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0086@¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u000fH\u0086@¢\u0006\u0004\b\u0017\u0010\u000eJ\u0010\u0010\u0018\u001a\u00020\u0011H\u0086@¢\u0006\u0004\b\u0018\u0010\u000eJ\u0013\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00110\u0014¢\u0006\u0004\b\u0019\u0010\u0016J\u0018\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u0011H\u0086@¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001e\u001a\u00020\u001dH\u0086@¢\u0006\u0004\b\u001e\u0010\u000eJ\u0018\u0010\u001f\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u001dH\u0086@¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010!\u001a\u00020\u001dH\u0086@¢\u0006\u0004\b!\u0010\u000eJ\u0018\u0010\"\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u001dH\u0086@¢\u0006\u0004\b\"\u0010 J\u0018\u0010%\u001a\u00020\u00112\u0006\u0010$\u001a\u00020#H\u0086@¢\u0006\u0004\b%\u0010&J\u0013\u0010'\u001a\b\u0012\u0004\u0012\u00020#0\u0014¢\u0006\u0004\b'\u0010\u0016J\u0010\u0010(\u001a\u00020#H\u0086@¢\u0006\u0004\b(\u0010\u000eJ\u0013\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00110\u0014¢\u0006\u0004\b)\u0010\u0016J\u0018\u0010*\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u0011H\u0086@¢\u0006\u0004\b*\u0010\u001cJ\u0013\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00110\u0014¢\u0006\u0004\b+\u0010\u0016J\u0018\u0010,\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u0011H\u0086@¢\u0006\u0004\b,\u0010\u001cJ\u0013\u0010.\u001a\b\u0012\u0004\u0012\u00020-0\u0014¢\u0006\u0004\b.\u0010\u0016J\u0018\u0010/\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020-H\u0086@¢\u0006\u0004\b/\u00100J\u0010\u00101\u001a\u00020-H\u0086@¢\u0006\u0004\b1\u0010\u000eJ\u0013\u00102\u001a\b\u0012\u0004\u0012\u00020-0\u0014¢\u0006\u0004\b2\u0010\u0016J\u0018\u00103\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020-H\u0086@¢\u0006\u0004\b3\u00100J\u0018\u00106\u001a\u00020\u00112\u0006\u00105\u001a\u000204H\u0086@¢\u0006\u0004\b6\u00107J\u0010\u00108\u001a\u000204H\u0086@¢\u0006\u0004\b8\u0010\u000eJ\u0018\u0010;\u001a\u00020\u00112\u0006\u0010:\u001a\u000209H\u0086@¢\u0006\u0004\b;\u0010<J\u0010\u0010=\u001a\u000209H\u0086@¢\u0006\u0004\b=\u0010\u000eJ\u0010\u0010>\u001a\u00020\u0011H\u0086@¢\u0006\u0004\b>\u0010\u000eJ\u0018\u0010?\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u0011H\u0086@¢\u0006\u0004\b?\u0010\u001cJ\u0010\u0010@\u001a\u00020-H\u0086@¢\u0006\u0004\b@\u0010\u000eJ\u0018\u0010A\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020-H\u0086@¢\u0006\u0004\bA\u00100J\u0018\u0010C\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020BH\u0086@¢\u0006\u0004\bC\u0010DJ\u0010\u0010E\u001a\u00020BH\u0086@¢\u0006\u0004\bE\u0010\u000eJ\u001b\u0010G\u001a\u0010\u0012\f\u0012\n F*\u0004\u0018\u00010B0B0\u0014¢\u0006\u0004\bG\u0010\u0016J\u0013\u0010H\u001a\b\u0012\u0004\u0012\u00020\u00110\u0014¢\u0006\u0004\bH\u0010\u0016J\u0010\u0010I\u001a\u00020\u0011H\u0086@¢\u0006\u0004\bI\u0010\u000eJ\u0018\u0010J\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u0011H\u0086@¢\u0006\u0004\bJ\u0010\u001cJ\u001b\u0010L\u001a\u0010\u0012\f\u0012\n F*\u0004\u0018\u00010K0K0\u0014¢\u0006\u0004\bL\u0010\u0016J\u0010\u0010M\u001a\u00020KH\u0086@¢\u0006\u0004\bM\u0010\u000eJ\u0018\u0010N\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020KH\u0086@¢\u0006\u0004\bN\u0010OJ\u0018\u0010Q\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020PH\u0086@¢\u0006\u0004\bQ\u0010RJ\u0010\u0010S\u001a\u00020PH\u0086@¢\u0006\u0004\bS\u0010\u000eJ\u0013\u0010T\u001a\b\u0012\u0004\u0012\u00020\u00110\u0014¢\u0006\u0004\bT\u0010\u0016J\u0018\u0010U\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u0011H\u0086@¢\u0006\u0004\bU\u0010\u001cR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010VR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010WR\u0014\u0010X\u001a\u00020\u001d8\u0002X\u0082D¢\u0006\u0006\n\u0004\bX\u0010YR\u0014\u0010Z\u001a\u00020\u001d8\u0002X\u0082D¢\u0006\u0006\n\u0004\bZ\u0010YR\u0014\u0010[\u001a\u00020\u001d8\u0002X\u0082D¢\u0006\u0006\n\u0004\b[\u0010YR\u0014\u0010\\\u001a\u00020\u001d8\u0002X\u0082D¢\u0006\u0006\n\u0004\b\\\u0010YR\u0014\u0010]\u001a\u00020\u001d8\u0002X\u0082D¢\u0006\u0006\n\u0004\b]\u0010YR\u0014\u0010^\u001a\u00020\u001d8\u0002X\u0082D¢\u0006\u0006\n\u0004\b^\u0010YR\u0014\u0010_\u001a\u00020\u001d8\u0002X\u0082D¢\u0006\u0006\n\u0004\b_\u0010YR\u0014\u0010`\u001a\u00020\u001d8\u0002X\u0082D¢\u0006\u0006\n\u0004\b`\u0010YR\u0014\u0010a\u001a\u00020\u001d8\u0002X\u0082D¢\u0006\u0006\n\u0004\ba\u0010YR\u0014\u0010b\u001a\u00020\u001d8\u0002X\u0082D¢\u0006\u0006\n\u0004\bb\u0010YR\u0014\u0010c\u001a\u00020\u001d8\u0002X\u0082D¢\u0006\u0006\n\u0004\bc\u0010YR\u0014\u0010d\u001a\u00020\u001d8\u0002X\u0082D¢\u0006\u0006\n\u0004\bd\u0010YR\u0014\u0010e\u001a\u00020\u001d8\u0002X\u0082D¢\u0006\u0006\n\u0004\be\u0010YR\u0016\u0010f\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bf\u0010gR\u0016\u0010h\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bh\u0010iR\u0014\u0010j\u001a\u00020\u001d8\u0002X\u0082D¢\u0006\u0006\n\u0004\bj\u0010YR\u0014\u0010k\u001a\u00020\u001d8\u0002X\u0082D¢\u0006\u0006\n\u0004\bk\u0010YR\u0014\u0010l\u001a\u00020\u001d8\u0002X\u0082D¢\u0006\u0006\n\u0004\bl\u0010YR\u0014\u0010m\u001a\u00020\u001d8\u0002X\u0082D¢\u0006\u0006\n\u0004\bm\u0010YR\u0014\u0010n\u001a\u00020\u001d8\u0002X\u0082D¢\u0006\u0006\n\u0004\bn\u0010Y¨\u0006p"}, d2 = {"Lcu/todus/android/di/PreferencesModule;", "", "Landroid/content/Context;", "context", "Lv5/f;", "gson", "<init>", "(Landroid/content/Context;Lv5/f;)V", "appContext", "Lcu/z17/preferences/Z17Preferences;", "providePreferences", "(Landroid/content/Context;)Lcu/z17/preferences/Z17Preferences;", "Lua/k0;", "clearPreferences", "(Lab/e;)Ljava/lang/Object;", "Lcu/todus/android/data/preferences/Owner;", UserRoomJoin.AFFILIATION_OWNER, "", "saveOwner", "(Lcu/todus/android/data/preferences/Owner;Lab/e;)Ljava/lang/Object;", "Lte/h;", "ownerFlow", "()Lte/h;", "getOwner", "setBannedUser", "getSecretReady", AppMeasurementSdk.ConditionalUserProperty.VALUE, "setSecretReady", "(ZLab/e;)Ljava/lang/Object;", "", "getSecretCode", "setSecretCode", "(Ljava/lang/String;Lab/e;)Ljava/lang/Object;", "getSecretClean", "setSecretClean", "Lcu/todus/android/data/preferences/DataPreferences;", "dataPreferences", "saveDataPreferences", "(Lcu/todus/android/data/preferences/DataPreferences;Lab/e;)Ljava/lang/Object;", "dataPreferencesFlow", "getDataPreferences", "getSentryState", "setSentryState", "getAliasSelectedState", "setAliasSelectedState", "", "getThemeSelectedState", "setThemeSelectedState", "(ILab/e;)Ljava/lang/Object;", "getCatalogueVersion", "getCatalogueVersionFlow", "setCatalogueVersion", "Lcu/todus/android/data/preferences/AliveWelcomeMessageDataPreferences;", "aliveWelcomeMessageDataPreferences", "saveAliveWelcomeMessageDataPreferences", "(Lcu/todus/android/data/preferences/AliveWelcomeMessageDataPreferences;Lab/e;)Ljava/lang/Object;", "getAliveWelcomeMessageDataPreferences", "Lcu/todus/android/data/preferences/ReactionsSelected;", "reactionsSelected", "saveReactionsSelected", "(Lcu/todus/android/data/preferences/ReactionsSelected;Lab/e;)Ljava/lang/Object;", "getReactionsSelected", "getIsValidCertificated", "setIsValidCertificate", "getLastVersion", "setLastVersion", "Lcu/todus/android/data/preferences/RootEnvironment;", "setRootEnvironment", "(Lcu/todus/android/data/preferences/RootEnvironment;Lab/e;)Ljava/lang/Object;", "getRootEnvironment", "kotlin.jvm.PlatformType", "getRootEnvironmentFlow", "getRequestModeFlow", "getRequestMode", "setRequestMode", "Lcu/todus/android/data/preferences/AppState;", "getAppStateFlow", "getAppState", "setAppState", "(Lcu/todus/android/data/preferences/AppState;Lab/e;)Ljava/lang/Object;", "Lcu/todus/android/data/preferences/CallQuality;", "setCallQuality", "(Lcu/todus/android/data/preferences/CallQuality;Lab/e;)Ljava/lang/Object;", "getCallQuality", "getBatterySettingsShowedFlow", "setBatterySettingsShowed", "Landroid/content/Context;", "Lv5/f;", "KEY_OWNER", "Ljava/lang/String;", "KEY_SECRET_ROOM_READY", "KEY_SECRET_ROOM_CODE", "KEY_SECRET_ROOM_CLEAN_CODE", "KEY_DATA_PREFERENCES", "KEY_SENTRY_ACTIVE", "KEY_ALIAS_SELECTED", "KEY_THEME_SELECTED", "KEY_CATALOGUE_VERSION", "KEY_ALIVE_WELCOME_MESSAGE_DATA_PREFERENCES", "KEY_REACTIONS_SELECTED", "KEY_VALID_CERTIFICATE", "KEY_LAST_VERSION", "preferences", "Lcu/z17/preferences/Z17Preferences;", "wasChangedThisTime", "Z", "keyRootUrl", "keyRequestMode", "keyPhoneState", "keyCallQuality", "keyBatterySettingsShowed", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class PreferencesModule {
    private final String KEY_ALIAS_SELECTED;
    private final String KEY_ALIVE_WELCOME_MESSAGE_DATA_PREFERENCES;
    private final String KEY_CATALOGUE_VERSION;
    private final String KEY_DATA_PREFERENCES;
    private final String KEY_LAST_VERSION;
    private final String KEY_OWNER;
    private final String KEY_REACTIONS_SELECTED;
    private final String KEY_SECRET_ROOM_CLEAN_CODE;
    private final String KEY_SECRET_ROOM_CODE;
    private final String KEY_SECRET_ROOM_READY;
    private final String KEY_SENTRY_ACTIVE;
    private final String KEY_THEME_SELECTED;
    private final String KEY_VALID_CERTIFICATE;
    private final Context context;
    private final v5.f gson;
    private final String keyBatterySettingsShowed;
    private final String keyCallQuality;
    private final String keyPhoneState;
    private final String keyRequestMode;
    private final String keyRootUrl;
    private Z17Preferences preferences;
    private boolean wasChangedThisTime;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: renamed from: cu.todus.android.di.PreferencesModule$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.di.PreferencesModule$1", f = "PreferencesModule.kt", l = {392}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
    public static final class AnonymousClass1 extends cb.m implements Function2 {
        int label;

        /* JADX INFO: renamed from: cu.todus.android.di.PreferencesModule$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        @cb.f(c = "cu.todus.android.di.PreferencesModule$1$1", f = "PreferencesModule.kt", l = {}, m = "invokeSuspend", v = 2)
        @Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "it", "Lua/k0;", "<anonymous>", "(I)V"}, k = 3, mv = {2, 3, 0})
        public static final class C02001 extends cb.m implements Function2 {
            int label;
            final /* synthetic */ PreferencesModule this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C02001(PreferencesModule preferencesModule, ab.e<? super C02001> eVar) {
                super(2, eVar);
                this.this$0 = preferencesModule;
            }

            @Override // cb.a
            public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
                return new C02001(this.this$0, eVar);
            }

            public final Object invoke(int i10, ab.e<? super k0> eVar) {
                return ((C02001) create(Integer.valueOf(i10), eVar)).invokeSuspend(k0.f43947a);
            }

            @Override // cb.a
            public final Object invokeSuspend(Object obj) {
                bb.b.g();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v.b(obj);
                new SharedPreferencesStorage(this.this$0.context, ToDus2Migration.SHARED_PREFERENCES_NAME_1).clean();
                new SharedPreferencesStorage(this.this$0.context, ToDus2Migration.SHARED_PREFERENCES_NAME_2).clean();
                return k0.f43947a;
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                return invoke(((Number) obj).intValue(), (ab.e<? super k0>) obj2);
            }
        }

        public AnonymousClass1(ab.e<? super AnonymousClass1> eVar) {
            super(2, eVar);
        }

        @Override // cb.a
        public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
            return PreferencesModule.this.new AnonymousClass1(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                v.b(obj);
                p0 errorFlow = PreferencesModule.this.preferences.getErrorFlow();
                C02001 c02001 = new C02001(PreferencesModule.this, null);
                this.label = 1;
                if (te.j.k(errorFlow, c02001, this) == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v.b(obj);
            }
            return k0.f43947a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
            return ((AnonymousClass1) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcu/todus/android/di/PreferencesModule$Companion;", "Lcu/z17/singledi/SingletonInitializer;", "Lcu/todus/android/di/PreferencesModule;", "<init>", "()V", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion extends SingletonInitializer<PreferencesModule> {
        public /* synthetic */ Companion(kotlin.jvm.internal.p pVar) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.di.PreferencesModule$getAliveWelcomeMessageDataPreferences$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.di.PreferencesModule", f = "PreferencesModule.kt", l = {221}, m = "getAliveWelcomeMessageDataPreferences", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C09861 extends cb.d {
        int label;
        /* synthetic */ Object result;

        public C09861(ab.e<? super C09861> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PreferencesModule.this.getAliveWelcomeMessageDataPreferences(this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.di.PreferencesModule$getAppState$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.di.PreferencesModule", f = "PreferencesModule.kt", l = {337}, m = "getAppState", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C09871 extends cb.d {
        int label;
        /* synthetic */ Object result;

        public C09871(ab.e<? super C09871> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PreferencesModule.this.getAppState(this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.di.PreferencesModule$getCallQuality$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.di.PreferencesModule", f = "PreferencesModule.kt", l = {362}, m = "getCallQuality", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C09881 extends cb.d {
        int label;
        /* synthetic */ Object result;

        public C09881(ab.e<? super C09881> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PreferencesModule.this.getCallQuality(this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.di.PreferencesModule$getDataPreferences$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.di.PreferencesModule", f = "PreferencesModule.kt", l = {WebmConstants.MkvEbmlElement.BLOCK_GROUP}, m = "getDataPreferences", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C09891 extends cb.d {
        int label;
        /* synthetic */ Object result;

        public C09891(ab.e<? super C09891> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PreferencesModule.this.getDataPreferences(this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.di.PreferencesModule$getOwner$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.di.PreferencesModule", f = "PreferencesModule.kt", l = {100}, m = "getOwner", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C09901 extends cb.d {
        int label;
        /* synthetic */ Object result;

        public C09901(ab.e<? super C09901> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PreferencesModule.this.getOwner(this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.di.PreferencesModule$getReactionsSelected$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.di.PreferencesModule", f = "PreferencesModule.kt", l = {PsExtractor.VIDEO_STREAM_MASK}, m = "getReactionsSelected", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C09911 extends cb.d {
        int label;
        /* synthetic */ Object result;

        public C09911(ab.e<? super C09911> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PreferencesModule.this.getReactionsSelected(this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.di.PreferencesModule$getRootEnvironment$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.di.PreferencesModule", f = "PreferencesModule.kt", l = {282}, m = "getRootEnvironment", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C09921 extends cb.d {
        int label;
        /* synthetic */ Object result;

        public C09921(ab.e<? super C09921> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PreferencesModule.this.getRootEnvironment(this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.di.PreferencesModule$saveAliveWelcomeMessageDataPreferences$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.di.PreferencesModule", f = "PreferencesModule.kt", l = {213}, m = "saveAliveWelcomeMessageDataPreferences", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C09931 extends cb.d {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C09931(ab.e<? super C09931> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PreferencesModule.this.saveAliveWelcomeMessageDataPreferences(null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.di.PreferencesModule$saveDataPreferences$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.di.PreferencesModule", f = "PreferencesModule.kt", l = {146}, m = "saveDataPreferences", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C09941 extends cb.d {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C09941(ab.e<? super C09941> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PreferencesModule.this.saveDataPreferences(null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.di.PreferencesModule$saveOwner$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.di.PreferencesModule", f = "PreferencesModule.kt", l = {86}, m = "saveOwner", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C09951 extends cb.d {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C09951(ab.e<? super C09951> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PreferencesModule.this.saveOwner(null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.di.PreferencesModule$saveReactionsSelected$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.di.PreferencesModule", f = "PreferencesModule.kt", l = {232}, m = "saveReactionsSelected", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C09961 extends cb.d {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C09961(ab.e<? super C09961> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PreferencesModule.this.saveReactionsSelected(null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.di.PreferencesModule$setAliasSelectedState$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.di.PreferencesModule", f = "PreferencesModule.kt", l = {WebmConstants.MkvEbmlElement.CUE_TRACK_POSITIONS}, m = "setAliasSelectedState", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C09971 extends cb.d {
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        public C09971(ab.e<? super C09971> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PreferencesModule.this.setAliasSelectedState(false, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.di.PreferencesModule$setAppState$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.di.PreferencesModule", f = "PreferencesModule.kt", l = {349}, m = "setAppState", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C09981 extends cb.d {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C09981(ab.e<? super C09981> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PreferencesModule.this.setAppState(null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.di.PreferencesModule$setBannedUser$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.di.PreferencesModule", f = "PreferencesModule.kt", l = {111}, m = "setBannedUser", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C09991 extends cb.d {
        int label;
        /* synthetic */ Object result;

        public C09991(ab.e<? super C09991> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PreferencesModule.this.setBannedUser(this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.di.PreferencesModule$setBatterySettingsShowed$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.di.PreferencesModule", f = "PreferencesModule.kt", l = {380}, m = "setBatterySettingsShowed", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C10001 extends cb.d {
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        public C10001(ab.e<? super C10001> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PreferencesModule.this.setBatterySettingsShowed(false, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.di.PreferencesModule$setCatalogueVersion$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.di.PreferencesModule", f = "PreferencesModule.kt", l = {205}, m = "setCatalogueVersion", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C10011 extends cb.d {
        int I$0;
        int label;
        /* synthetic */ Object result;

        public C10011(ab.e<? super C10011> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PreferencesModule.this.setCatalogueVersion(0, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.di.PreferencesModule$setIsValidCertificate$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.di.PreferencesModule", f = "PreferencesModule.kt", l = {257}, m = "setIsValidCertificate", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C10021 extends cb.d {
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        public C10021(ab.e<? super C10021> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PreferencesModule.this.setIsValidCertificate(false, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.di.PreferencesModule$setLastVersion$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.di.PreferencesModule", f = "PreferencesModule.kt", l = {269}, m = "setLastVersion", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C10031 extends cb.d {
        int I$0;
        int label;
        /* synthetic */ Object result;

        public C10031(ab.e<? super C10031> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PreferencesModule.this.setLastVersion(0, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.di.PreferencesModule$setRequestMode$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.di.PreferencesModule", f = "PreferencesModule.kt", l = {321}, m = "setRequestMode", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C10041 extends cb.d {
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        public C10041(ab.e<? super C10041> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PreferencesModule.this.setRequestMode(false, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.di.PreferencesModule$setSecretClean$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.di.PreferencesModule", f = "PreferencesModule.kt", l = {TsExtractor.TS_STREAM_TYPE_DTS}, m = "setSecretClean", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C10051 extends cb.d {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C10051(ab.e<? super C10051> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PreferencesModule.this.setSecretClean(null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.di.PreferencesModule$setSecretCode$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.di.PreferencesModule", f = "PreferencesModule.kt", l = {TsExtractor.TS_STREAM_TYPE_HDMV_DTS}, m = "setSecretCode", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C10061 extends cb.d {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C10061(ab.e<? super C10061> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PreferencesModule.this.setSecretCode(null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.di.PreferencesModule$setSecretReady$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.di.PreferencesModule", f = "PreferencesModule.kt", l = {122}, m = "setSecretReady", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C10071 extends cb.d {
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        public C10071(ab.e<? super C10071> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PreferencesModule.this.setSecretReady(false, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.di.PreferencesModule$setSentryState$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.di.PreferencesModule", f = "PreferencesModule.kt", l = {173}, m = "setSentryState", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C10081 extends cb.d {
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        public C10081(ab.e<? super C10081> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PreferencesModule.this.setSentryState(false, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.di.PreferencesModule$setThemeSelectedState$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.di.PreferencesModule", f = "PreferencesModule.kt", l = {193}, m = "setThemeSelectedState", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C10091 extends cb.d {
        int I$0;
        int label;
        /* synthetic */ Object result;

        public C10091(ab.e<? super C10091> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PreferencesModule.this.setThemeSelectedState(0, this);
        }
    }

    public PreferencesModule(Context context, v5.f gson) {
        y.i(context, "context");
        y.i(gson, "gson");
        this.context = context;
        this.gson = gson;
        this.KEY_OWNER = UserRoomJoin.AFFILIATION_OWNER;
        this.KEY_SECRET_ROOM_READY = "key_secret_room_ready"; // pragma: allowlist secret
        this.KEY_SECRET_ROOM_CODE = "key_secret_room_code"; // pragma: allowlist secret
        this.KEY_SECRET_ROOM_CLEAN_CODE = "key_secret_room_clean"; // pragma: allowlist secret
        this.KEY_DATA_PREFERENCES = "key_data_preferences";
        this.KEY_SENTRY_ACTIVE = "key_sentry_active";
        this.KEY_ALIAS_SELECTED = "key_alias_selected";
        this.KEY_THEME_SELECTED = "key_theme_selected";
        this.KEY_CATALOGUE_VERSION = "key_catalogue_version";
        this.KEY_ALIVE_WELCOME_MESSAGE_DATA_PREFERENCES = "key_welcome_message_data_preferences";
        this.KEY_REACTIONS_SELECTED = "key_reactions_selected";
        this.KEY_VALID_CERTIFICATE = "key_valid_certificate";
        this.KEY_LAST_VERSION = "key_last_version";
        this.keyRootUrl = "KEY_ROOT_ENVIRONMENT";
        this.keyRequestMode = "KEY_REQUEST_MODE";
        this.keyPhoneState = "KEY_PHONE_STATE";
        this.keyCallQuality = "KEY_CALL_QUALITY";
        this.keyBatterySettingsShowed = "KEY_BATTERY_SETTINGS_SHOWED";
        this.preferences = providePreferences(context);
        pe.k.d(n0.a(d1.b().plus(e2.b(null, 1, null))), null, null, new AnonymousClass1(null), 3, null);
    }

    private final Z17Preferences providePreferences(Context appContext) {
        return new Z17Preferences(appContext);
    }

    public final Object clearPreferences(ab.e<? super k0> eVar) {
        Object objResetAll = this.preferences.resetAll(eVar);
        return objResetAll == bb.b.g() ? objResetAll : k0.f43947a;
    }

    public final te.h dataPreferencesFlow() {
        final te.h hVarFlowValueOf = this.preferences.flowValueOf(this.KEY_DATA_PREFERENCES, "");
        return new te.h() { // from class: cu.todus.android.di.PreferencesModule$dataPreferencesFlow$$inlined$map$1

            /* JADX INFO: renamed from: cu.todus.android.di.PreferencesModule$dataPreferencesFlow$$inlined$map$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
            @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
            public static final class AnonymousClass2<T> implements te.i {
                final /* synthetic */ te.i $this_unsafeFlow;
                final /* synthetic */ PreferencesModule this$0;

                /* JADX INFO: renamed from: cu.todus.android.di.PreferencesModule$dataPreferencesFlow$$inlined$map$1$2$1, reason: invalid class name */
                @cb.f(c = "cu.todus.android.di.PreferencesModule$dataPreferencesFlow$$inlined$map$1$2", f = "PreferencesModule.kt", l = {50}, m = "emit", v = 2)
                @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
                public static final class AnonymousClass1 extends cb.d {
                    int I$0;
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(ab.e eVar) {
                        super(eVar);
                    }

                    @Override // cb.a
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(te.i iVar, PreferencesModule preferencesModule) {
                    this.$this_unsafeFlow = iVar;
                    this.this$0 = preferencesModule;
                }

                /* JADX WARN: Code duplicated, block: B:7:0x0017  */
                @Override // te.i
                public final Object emit(Object obj, ab.e eVar) {
                    AnonymousClass1 anonymousClass1;
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
                        te.i iVar = this.$this_unsafeFlow;
                        String str = (String) obj;
                        DataPreferences dataPreferences = d0.q0(str) ? new DataPreferences(false, false, false, false, false, false, false, false, false, false, null, 0, null, 8191, null) : (DataPreferences) this.this$0.gson.j(str, DataPreferences.class);
                        anonymousClass1.L$0 = cb.l.a(obj);
                        anonymousClass1.L$1 = cb.l.a(anonymousClass1);
                        anonymousClass1.L$2 = cb.l.a(obj);
                        anonymousClass1.L$3 = cb.l.a(iVar);
                        anonymousClass1.I$0 = 0;
                        anonymousClass1.label = 1;
                        if (iVar.emit(dataPreferences, anonymousClass1) == objG) {
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
            public Object collect(te.i iVar, ab.e eVar) {
                Object objCollect = hVarFlowValueOf.collect(new AnonymousClass2(iVar, this), eVar);
                return objCollect == bb.b.g() ? objCollect : k0.f43947a;
            }
        };
    }

    public final te.h getAliasSelectedState() {
        return this.preferences.flowValueOf(this.KEY_ALIAS_SELECTED, false);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object getAliveWelcomeMessageDataPreferences(ab.e<? super AliveWelcomeMessageDataPreferences> eVar) {
        C09861 c09861;
        if (eVar instanceof C09861) {
            c09861 = (C09861) eVar;
            int i10 = c09861.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c09861.label = i10 - Integer.MIN_VALUE;
            } else {
                c09861 = new C09861(eVar);
            }
        } else {
            c09861 = new C09861(eVar);
        }
        Object objRetrieve = c09861.result;
        Object objG = bb.b.g();
        int i11 = c09861.label;
        if (i11 == 0) {
            v.b(objRetrieve);
            Z17Preferences z17Preferences = this.preferences;
            String str = this.KEY_ALIVE_WELCOME_MESSAGE_DATA_PREFERENCES;
            c09861.label = 1;
            objRetrieve = z17Preferences.retrieve(str, "", c09861);
            if (objRetrieve == objG) {
                return objG;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v.b(objRetrieve);
        }
        String str2 = (String) objRetrieve;
        if (d0.q0(str2)) {
            return new AliveWelcomeMessageDataPreferences(false, 0, 0, 7, null);
        }
        Object objJ = this.gson.j(str2, AliveWelcomeMessageDataPreferences.class);
        y.h(objJ, "fromJson(...)");
        return (AliveWelcomeMessageDataPreferences) objJ;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object getAppState(ab.e<? super AppState> eVar) {
        C09871 c09871;
        if (eVar instanceof C09871) {
            c09871 = (C09871) eVar;
            int i10 = c09871.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c09871.label = i10 - Integer.MIN_VALUE;
            } else {
                c09871 = new C09871(eVar);
            }
        } else {
            c09871 = new C09871(eVar);
        }
        Object objRetrieve = c09871.result;
        Object objG = bb.b.g();
        int i11 = c09871.label;
        if (i11 == 0) {
            v.b(objRetrieve);
            Z17Preferences z17Preferences = this.preferences;
            String str = this.keyPhoneState;
            c09871.label = 1;
            objRetrieve = z17Preferences.retrieve(str, "", c09871);
            if (objRetrieve == objG) {
                return objG;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v.b(objRetrieve);
        }
        String str2 = (String) objRetrieve;
        if (d0.q0(str2)) {
            return new AppState(null, null, null, 0, 0L, 31, null);
        }
        Object objJ = this.gson.j(str2, AppState.class);
        y.h(objJ, "fromJson(...)");
        return (AppState) objJ;
    }

    public final te.h getAppStateFlow() {
        final te.h hVarFlowValueOf = this.preferences.flowValueOf(this.keyPhoneState, "");
        return new te.h() { // from class: cu.todus.android.di.PreferencesModule$getAppStateFlow$$inlined$map$1

            /* JADX INFO: renamed from: cu.todus.android.di.PreferencesModule$getAppStateFlow$$inlined$map$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
            @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
            public static final class AnonymousClass2<T> implements te.i {
                final /* synthetic */ te.i $this_unsafeFlow;
                final /* synthetic */ PreferencesModule this$0;

                /* JADX INFO: renamed from: cu.todus.android.di.PreferencesModule$getAppStateFlow$$inlined$map$1$2$1, reason: invalid class name */
                @cb.f(c = "cu.todus.android.di.PreferencesModule$getAppStateFlow$$inlined$map$1$2", f = "PreferencesModule.kt", l = {50}, m = "emit", v = 2)
                @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
                public static final class AnonymousClass1 extends cb.d {
                    int I$0;
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(ab.e eVar) {
                        super(eVar);
                    }

                    @Override // cb.a
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(te.i iVar, PreferencesModule preferencesModule) {
                    this.$this_unsafeFlow = iVar;
                    this.this$0 = preferencesModule;
                }

                /* JADX WARN: Code duplicated, block: B:7:0x0017  */
                @Override // te.i
                public final Object emit(Object obj, ab.e eVar) {
                    AnonymousClass1 anonymousClass1;
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
                        te.i iVar = this.$this_unsafeFlow;
                        String str = (String) obj;
                        AppState appState = d0.q0(str) ? new AppState(null, null, null, 0, 0L, 31, null) : (AppState) this.this$0.gson.j(str, AppState.class);
                        anonymousClass1.L$0 = cb.l.a(obj);
                        anonymousClass1.L$1 = cb.l.a(anonymousClass1);
                        anonymousClass1.L$2 = cb.l.a(obj);
                        anonymousClass1.L$3 = cb.l.a(iVar);
                        anonymousClass1.I$0 = 0;
                        anonymousClass1.label = 1;
                        if (iVar.emit(appState, anonymousClass1) == objG) {
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
            public Object collect(te.i iVar, ab.e eVar) {
                Object objCollect = hVarFlowValueOf.collect(new AnonymousClass2(iVar, this), eVar);
                return objCollect == bb.b.g() ? objCollect : k0.f43947a;
            }
        };
    }

    public final te.h getBatterySettingsShowedFlow() {
        return this.preferences.flowValueOf(this.keyBatterySettingsShowed, false);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object getCallQuality(ab.e<? super CallQuality> eVar) {
        C09881 c09881;
        if (eVar instanceof C09881) {
            c09881 = (C09881) eVar;
            int i10 = c09881.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c09881.label = i10 - Integer.MIN_VALUE;
            } else {
                c09881 = new C09881(eVar);
            }
        } else {
            c09881 = new C09881(eVar);
        }
        Object objRetrieve = c09881.result;
        Object objG = bb.b.g();
        int i11 = c09881.label;
        if (i11 == 0) {
            v.b(objRetrieve);
            Z17Preferences z17Preferences = this.preferences;
            String str = this.keyCallQuality;
            c09881.label = 1;
            objRetrieve = z17Preferences.retrieve(str, "", c09881);
            if (objRetrieve == objG) {
                return objG;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v.b(objRetrieve);
        }
        String str2 = (String) objRetrieve;
        if (d0.q0(str2)) {
            return new CallQuality(0, 0, 3, null);
        }
        Object objJ = this.gson.j(str2, CallQuality.class);
        y.h(objJ, "fromJson(...)");
        return (CallQuality) objJ;
    }

    public final Object getCatalogueVersion(ab.e<? super Integer> eVar) {
        return this.preferences.retrieve(this.KEY_CATALOGUE_VERSION, 0, eVar);
    }

    public final te.h getCatalogueVersionFlow() {
        return this.preferences.flowValueOf(this.KEY_CATALOGUE_VERSION, 0);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    public final Object getDataPreferences(ab.e<? super DataPreferences> eVar) {
        C09891 c09891;
        if (eVar instanceof C09891) {
            c09891 = (C09891) eVar;
            int i10 = c09891.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c09891.label = i10 - Integer.MIN_VALUE;
            } else {
                c09891 = new C09891(eVar);
            }
        } else {
            c09891 = new C09891(eVar);
        }
        Object objRetrieve = c09891.result;
        Object objG = bb.b.g();
        int i11 = c09891.label;
        if (i11 == 0) {
            v.b(objRetrieve);
            Z17Preferences z17Preferences = this.preferences;
            String str = this.KEY_DATA_PREFERENCES;
            c09891.label = 1;
            objRetrieve = z17Preferences.retrieve(str, "", c09891);
            if (objRetrieve == objG) {
                return objG;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v.b(objRetrieve);
        }
        String str2 = (String) objRetrieve;
        if (d0.q0(str2)) {
            return new DataPreferences(false, false, false, false, false, false, false, false, false, false, null, 0, null, 8191, null);
        }
        Object objJ = this.gson.j(str2, DataPreferences.class);
        y.h(objJ, "fromJson(...)");
        return (DataPreferences) objJ;
    }

    public final Object getIsValidCertificated(ab.e<? super Boolean> eVar) {
        return this.preferences.retrieve(this.KEY_VALID_CERTIFICATE, true, eVar);
    }

    public final Object getLastVersion(ab.e<? super Integer> eVar) {
        return this.preferences.retrieve(this.KEY_LAST_VERSION, 30101, eVar);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object getOwner(ab.e<? super Owner> eVar) {
        C09901 c09901;
        if (eVar instanceof C09901) {
            c09901 = (C09901) eVar;
            int i10 = c09901.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c09901.label = i10 - Integer.MIN_VALUE;
            } else {
                c09901 = new C09901(eVar);
            }
        } else {
            c09901 = new C09901(eVar);
        }
        Object objRetrieve = c09901.result;
        Object objG = bb.b.g();
        int i11 = c09901.label;
        if (i11 == 0) {
            v.b(objRetrieve);
            Z17Preferences z17Preferences = this.preferences;
            String str = this.KEY_OWNER;
            c09901.label = 1;
            objRetrieve = z17Preferences.retrieve(str, "", c09901);
            if (objRetrieve == objG) {
                return objG;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v.b(objRetrieve);
        }
        String str2 = (String) objRetrieve;
        if (d0.q0(str2)) {
            return null;
        }
        return (Owner) this.gson.j(str2, Owner.class);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object getReactionsSelected(ab.e<? super ReactionsSelected> eVar) {
        C09911 c09911;
        if (eVar instanceof C09911) {
            c09911 = (C09911) eVar;
            int i10 = c09911.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c09911.label = i10 - Integer.MIN_VALUE;
            } else {
                c09911 = new C09911(eVar);
            }
        } else {
            c09911 = new C09911(eVar);
        }
        Object objRetrieve = c09911.result;
        Object objG = bb.b.g();
        int i11 = c09911.label;
        if (i11 == 0) {
            v.b(objRetrieve);
            Z17Preferences z17Preferences = this.preferences;
            String str = this.KEY_REACTIONS_SELECTED;
            c09911.label = 1;
            objRetrieve = z17Preferences.retrieve(str, "", c09911);
            if (objRetrieve == objG) {
                return objG;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v.b(objRetrieve);
        }
        String str2 = (String) objRetrieve;
        if (d0.q0(str2)) {
            return new ReactionsSelected(null, 1, null);
        }
        Object objJ = this.gson.j(str2, ReactionsSelected.class);
        y.h(objJ, "fromJson(...)");
        return (ReactionsSelected) objJ;
    }

    public final Object getRequestMode(ab.e<? super Boolean> eVar) {
        return this.preferences.retrieve(this.keyRequestMode, false, eVar);
    }

    public final te.h getRequestModeFlow() {
        return this.preferences.flowValueOf(this.keyRequestMode, false);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object getRootEnvironment(ab.e<? super RootEnvironment> eVar) {
        C09921 c09921;
        if (eVar instanceof C09921) {
            c09921 = (C09921) eVar;
            int i10 = c09921.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c09921.label = i10 - Integer.MIN_VALUE;
            } else {
                c09921 = new C09921(eVar);
            }
        } else {
            c09921 = new C09921(eVar);
        }
        Object objRetrieve = c09921.result;
        Object objG = bb.b.g();
        int i11 = c09921.label;
        if (i11 == 0) {
            v.b(objRetrieve);
            Z17Preferences z17Preferences = this.preferences;
            String str = this.keyRootUrl;
            c09921.label = 1;
            objRetrieve = z17Preferences.retrieve(str, "", c09921);
            if (objRetrieve == objG) {
                return objG;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v.b(objRetrieve);
        }
        String str2 = (String) objRetrieve;
        if (d0.q0(str2)) {
            return new RootEnvironment(Service.ApplicationEnvironment.PROD_2, "");
        }
        Object objJ = this.gson.j(str2, RootEnvironment.class);
        y.h(objJ, "fromJson(...)");
        return (RootEnvironment) objJ;
    }

    public final te.h getRootEnvironmentFlow() {
        final te.h hVarFlowValueOf = this.preferences.flowValueOf(this.keyRootUrl, "");
        return new te.h() { // from class: cu.todus.android.di.PreferencesModule$getRootEnvironmentFlow$$inlined$map$1

            /* JADX INFO: renamed from: cu.todus.android.di.PreferencesModule$getRootEnvironmentFlow$$inlined$map$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
            @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
            public static final class AnonymousClass2<T> implements te.i {
                final /* synthetic */ te.i $this_unsafeFlow;
                final /* synthetic */ PreferencesModule this$0;

                /* JADX INFO: renamed from: cu.todus.android.di.PreferencesModule$getRootEnvironmentFlow$$inlined$map$1$2$1, reason: invalid class name */
                @cb.f(c = "cu.todus.android.di.PreferencesModule$getRootEnvironmentFlow$$inlined$map$1$2", f = "PreferencesModule.kt", l = {ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG, 50}, m = "emit", v = 2)
                @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
                public static final class AnonymousClass1 extends cb.d {
                    int I$0;
                    int I$1;
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    Object L$4;
                    Object L$5;
                    Object L$6;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(ab.e eVar) {
                        super(eVar);
                    }

                    @Override // cb.a
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(te.i iVar, PreferencesModule preferencesModule) {
                    this.$this_unsafeFlow = iVar;
                    this.this$0 = preferencesModule;
                }

                /* JADX WARN: Code duplicated, block: B:7:0x0013  */
                /* JADX WARN: Code restructure failed: missing block: B:25:0x00f4, code lost:
                
                    if (r2.emit(r5, r0) == r1) goto L26;
                 */
                @Override // te.i
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object emit(java.lang.Object r12, ab.e r13) {
                    /*
                        Method dump skipped, instruction units count: 250
                        To view this dump add '--comments-level debug' option
                    */
                    throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.di.PreferencesModule$getRootEnvironmentFlow$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, ab.e):java.lang.Object");
                }
            }

            @Override // te.h
            public Object collect(te.i iVar, ab.e eVar) {
                Object objCollect = hVarFlowValueOf.collect(new AnonymousClass2(iVar, this), eVar);
                return objCollect == bb.b.g() ? objCollect : k0.f43947a;
            }
        };
    }

    public final Object getSecretClean(ab.e<? super String> eVar) {
        return this.preferences.retrieve(this.KEY_SECRET_ROOM_CLEAN_CODE, "1234", eVar);
    }

    public final Object getSecretCode(ab.e<? super String> eVar) {
        return this.preferences.retrieve(this.KEY_SECRET_ROOM_CODE, "1234", eVar);
    }

    public final te.h getSecretReady() {
        return this.preferences.flowValueOf(this.KEY_SECRET_ROOM_READY, false);
    }

    public final te.h getSentryState() {
        return this.preferences.flowValueOf(this.KEY_SENTRY_ACTIVE, false);
    }

    public final te.h getThemeSelectedState() {
        return this.preferences.flowValueOf(this.KEY_THEME_SELECTED, 0);
    }

    public final te.h ownerFlow() {
        final te.h hVarFlowValueOf = this.preferences.flowValueOf(this.KEY_OWNER, "");
        return new te.h() { // from class: cu.todus.android.di.PreferencesModule$ownerFlow$$inlined$map$1

            /* JADX INFO: renamed from: cu.todus.android.di.PreferencesModule$ownerFlow$$inlined$map$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
            @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
            public static final class AnonymousClass2<T> implements te.i {
                final /* synthetic */ te.i $this_unsafeFlow;
                final /* synthetic */ PreferencesModule this$0;

                /* JADX INFO: renamed from: cu.todus.android.di.PreferencesModule$ownerFlow$$inlined$map$1$2$1, reason: invalid class name */
                @cb.f(c = "cu.todus.android.di.PreferencesModule$ownerFlow$$inlined$map$1$2", f = "PreferencesModule.kt", l = {50}, m = "emit", v = 2)
                @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
                public static final class AnonymousClass1 extends cb.d {
                    int I$0;
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(ab.e eVar) {
                        super(eVar);
                    }

                    @Override // cb.a
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(te.i iVar, PreferencesModule preferencesModule) {
                    this.$this_unsafeFlow = iVar;
                    this.this$0 = preferencesModule;
                }

                /* JADX WARN: Code duplicated, block: B:7:0x0013  */
                @Override // te.i
                public final Object emit(Object obj, ab.e eVar) {
                    AnonymousClass1 anonymousClass1;
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
                        te.i iVar = this.$this_unsafeFlow;
                        String str = (String) obj;
                        Owner owner = d0.q0(str) ? null : (Owner) this.this$0.gson.j(str, Owner.class);
                        anonymousClass1.L$0 = cb.l.a(obj);
                        anonymousClass1.L$1 = cb.l.a(anonymousClass1);
                        anonymousClass1.L$2 = cb.l.a(obj);
                        anonymousClass1.L$3 = cb.l.a(iVar);
                        anonymousClass1.I$0 = 0;
                        anonymousClass1.label = 1;
                        if (iVar.emit(owner, anonymousClass1) == objG) {
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
            public Object collect(te.i iVar, ab.e eVar) {
                Object objCollect = hVarFlowValueOf.collect(new AnonymousClass2(iVar, this), eVar);
                return objCollect == bb.b.g() ? objCollect : k0.f43947a;
            }
        };
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object saveAliveWelcomeMessageDataPreferences(AliveWelcomeMessageDataPreferences aliveWelcomeMessageDataPreferences, ab.e<? super Boolean> eVar) {
        C09931 c09931;
        if (eVar instanceof C09931) {
            c09931 = (C09931) eVar;
            int i10 = c09931.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c09931.label = i10 - Integer.MIN_VALUE;
            } else {
                c09931 = new C09931(eVar);
            }
        } else {
            c09931 = new C09931(eVar);
        }
        Object obj = c09931.result;
        Object objG = bb.b.g();
        int i11 = c09931.label;
        if (i11 == 0) {
            v.b(obj);
            Z17Preferences z17Preferences = this.preferences;
            String str = this.KEY_ALIVE_WELCOME_MESSAGE_DATA_PREFERENCES;
            String strT = this.gson.t(aliveWelcomeMessageDataPreferences);
            y.h(strT, "toJson(...)");
            c09931.L$0 = cb.l.a(aliveWelcomeMessageDataPreferences);
            c09931.label = 1;
            if (z17Preferences.store(str, strT, c09931) == objG) {
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
    public final Object saveDataPreferences(DataPreferences dataPreferences, ab.e<? super Boolean> eVar) {
        C09941 c09941;
        if (eVar instanceof C09941) {
            c09941 = (C09941) eVar;
            int i10 = c09941.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c09941.label = i10 - Integer.MIN_VALUE;
            } else {
                c09941 = new C09941(eVar);
            }
        } else {
            c09941 = new C09941(eVar);
        }
        Object obj = c09941.result;
        Object objG = bb.b.g();
        int i11 = c09941.label;
        if (i11 == 0) {
            v.b(obj);
            Z17Preferences z17Preferences = this.preferences;
            String str = this.KEY_DATA_PREFERENCES;
            String strT = this.gson.t(dataPreferences);
            y.h(strT, "toJson(...)");
            c09941.L$0 = cb.l.a(dataPreferences);
            c09941.label = 1;
            if (z17Preferences.store(str, strT, c09941) == objG) {
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
    public final Object saveOwner(Owner owner, ab.e<? super Boolean> eVar) {
        C09951 c09951;
        if (eVar instanceof C09951) {
            c09951 = (C09951) eVar;
            int i10 = c09951.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c09951.label = i10 - Integer.MIN_VALUE;
            } else {
                c09951 = new C09951(eVar);
            }
        } else {
            c09951 = new C09951(eVar);
        }
        Object obj = c09951.result;
        Object objG = bb.b.g();
        int i11 = c09951.label;
        if (i11 == 0) {
            v.b(obj);
            Z17Preferences z17Preferences = this.preferences;
            String str = this.KEY_OWNER;
            String strT = this.gson.t(owner);
            y.h(strT, "toJson(...)");
            c09951.L$0 = cb.l.a(owner);
            c09951.label = 1;
            if (z17Preferences.store(str, strT, c09951) == objG) {
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
    public final Object saveReactionsSelected(ReactionsSelected reactionsSelected, ab.e<? super Boolean> eVar) {
        C09961 c09961;
        if (eVar instanceof C09961) {
            c09961 = (C09961) eVar;
            int i10 = c09961.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c09961.label = i10 - Integer.MIN_VALUE;
            } else {
                c09961 = new C09961(eVar);
            }
        } else {
            c09961 = new C09961(eVar);
        }
        Object obj = c09961.result;
        Object objG = bb.b.g();
        int i11 = c09961.label;
        if (i11 == 0) {
            v.b(obj);
            Z17Preferences z17Preferences = this.preferences;
            String str = this.KEY_REACTIONS_SELECTED;
            String strT = this.gson.t(reactionsSelected);
            y.h(strT, "toJson(...)");
            c09961.L$0 = cb.l.a(reactionsSelected);
            c09961.label = 1;
            if (z17Preferences.store(str, strT, c09961) == objG) {
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
    public final Object setAliasSelectedState(boolean z10, ab.e<? super Boolean> eVar) {
        C09971 c09971;
        if (eVar instanceof C09971) {
            c09971 = (C09971) eVar;
            int i10 = c09971.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c09971.label = i10 - Integer.MIN_VALUE;
            } else {
                c09971 = new C09971(eVar);
            }
        } else {
            c09971 = new C09971(eVar);
        }
        Object obj = c09971.result;
        Object objG = bb.b.g();
        int i11 = c09971.label;
        if (i11 == 0) {
            v.b(obj);
            Z17Preferences z17Preferences = this.preferences;
            String str = this.KEY_ALIAS_SELECTED;
            c09971.Z$0 = z10;
            c09971.label = 1;
            if (z17Preferences.store(str, z10, c09971) == objG) {
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
    public final Object setAppState(AppState appState, ab.e<? super Boolean> eVar) {
        C09981 c09981;
        if (eVar instanceof C09981) {
            c09981 = (C09981) eVar;
            int i10 = c09981.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c09981.label = i10 - Integer.MIN_VALUE;
            } else {
                c09981 = new C09981(eVar);
            }
        } else {
            c09981 = new C09981(eVar);
        }
        Object obj = c09981.result;
        Object objG = bb.b.g();
        int i11 = c09981.label;
        if (i11 == 0) {
            v.b(obj);
            Z17Preferences z17Preferences = this.preferences;
            String str = this.keyPhoneState;
            String strT = this.gson.t(appState);
            y.h(strT, "toJson(...)");
            c09981.L$0 = cb.l.a(appState);
            c09981.label = 1;
            if (z17Preferences.store(str, strT, c09981) == objG) {
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
    public final Object setBannedUser(ab.e<? super Boolean> eVar) {
        C09991 c09991;
        if (eVar instanceof C09991) {
            c09991 = (C09991) eVar;
            int i10 = c09991.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c09991.label = i10 - Integer.MIN_VALUE;
            } else {
                c09991 = new C09991(eVar);
            }
        } else {
            c09991 = new C09991(eVar);
        }
        Object obj = c09991.result;
        Object objG = bb.b.g();
        int i11 = c09991.label;
        if (i11 == 0) {
            v.b(obj);
            AppState appState = new AppState(AppStateStep.BANNED, null, null, 0, 0L, 30, null);
            c09991.label = 1;
            if (setAppState(appState, c09991) == objG) {
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
    public final Object setBatterySettingsShowed(boolean z10, ab.e<? super Boolean> eVar) {
        C10001 c10001;
        if (eVar instanceof C10001) {
            c10001 = (C10001) eVar;
            int i10 = c10001.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c10001.label = i10 - Integer.MIN_VALUE;
            } else {
                c10001 = new C10001(eVar);
            }
        } else {
            c10001 = new C10001(eVar);
        }
        Object obj = c10001.result;
        Object objG = bb.b.g();
        int i11 = c10001.label;
        if (i11 == 0) {
            v.b(obj);
            Z17Preferences z17Preferences = this.preferences;
            String str = this.keyBatterySettingsShowed;
            c10001.Z$0 = z10;
            c10001.label = 1;
            if (z17Preferences.store(str, z10, c10001) == objG) {
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

    public final Object setCallQuality(CallQuality callQuality, ab.e<? super k0> eVar) {
        Z17Preferences z17Preferences = this.preferences;
        String str = this.keyCallQuality;
        String strT = this.gson.t(callQuality);
        y.h(strT, "toJson(...)");
        Object objStore = z17Preferences.store(str, strT, (ab.e<? super Boolean>) eVar);
        return objStore == bb.b.g() ? objStore : k0.f43947a;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object setCatalogueVersion(int i10, ab.e<? super Boolean> eVar) {
        C10011 c10011;
        if (eVar instanceof C10011) {
            c10011 = (C10011) eVar;
            int i11 = c10011.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                c10011.label = i11 - Integer.MIN_VALUE;
            } else {
                c10011 = new C10011(eVar);
            }
        } else {
            c10011 = new C10011(eVar);
        }
        Object obj = c10011.result;
        Object objG = bb.b.g();
        int i12 = c10011.label;
        if (i12 == 0) {
            v.b(obj);
            Z17Preferences z17Preferences = this.preferences;
            String str = this.KEY_CATALOGUE_VERSION;
            c10011.I$0 = i10;
            c10011.label = 1;
            if (z17Preferences.store(str, i10, (ab.e<? super Boolean>) c10011) == objG) {
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
    public final Object setIsValidCertificate(boolean z10, ab.e<? super Boolean> eVar) {
        C10021 c10021;
        if (eVar instanceof C10021) {
            c10021 = (C10021) eVar;
            int i10 = c10021.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c10021.label = i10 - Integer.MIN_VALUE;
            } else {
                c10021 = new C10021(eVar);
            }
        } else {
            c10021 = new C10021(eVar);
        }
        Object obj = c10021.result;
        Object objG = bb.b.g();
        int i11 = c10021.label;
        if (i11 == 0) {
            v.b(obj);
            if (!this.wasChangedThisTime) {
                Z17Preferences z17Preferences = this.preferences;
                String str = this.KEY_VALID_CERTIFICATE;
                c10021.Z$0 = z10;
                c10021.label = 1;
                if (z17Preferences.store(str, z10, c10021) == objG) {
                    return objG;
                }
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v.b(obj);
        }
        this.wasChangedThisTime = true;
        return cb.b.a(true);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object setLastVersion(int i10, ab.e<? super Boolean> eVar) {
        C10031 c10031;
        if (eVar instanceof C10031) {
            c10031 = (C10031) eVar;
            int i11 = c10031.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                c10031.label = i11 - Integer.MIN_VALUE;
            } else {
                c10031 = new C10031(eVar);
            }
        } else {
            c10031 = new C10031(eVar);
        }
        Object obj = c10031.result;
        Object objG = bb.b.g();
        int i12 = c10031.label;
        if (i12 == 0) {
            v.b(obj);
            Z17Preferences z17Preferences = this.preferences;
            String str = this.KEY_LAST_VERSION;
            c10031.I$0 = i10;
            c10031.label = 1;
            if (z17Preferences.store(str, i10, (ab.e<? super Boolean>) c10031) == objG) {
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
    public final Object setRequestMode(boolean z10, ab.e<? super Boolean> eVar) {
        C10041 c10041;
        if (eVar instanceof C10041) {
            c10041 = (C10041) eVar;
            int i10 = c10041.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c10041.label = i10 - Integer.MIN_VALUE;
            } else {
                c10041 = new C10041(eVar);
            }
        } else {
            c10041 = new C10041(eVar);
        }
        Object obj = c10041.result;
        Object objG = bb.b.g();
        int i11 = c10041.label;
        if (i11 == 0) {
            v.b(obj);
            Z17Preferences z17Preferences = this.preferences;
            String str = this.keyRequestMode;
            c10041.Z$0 = z10;
            c10041.label = 1;
            if (z17Preferences.store(str, z10, c10041) == objG) {
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

    public final Object setRootEnvironment(RootEnvironment rootEnvironment, ab.e<? super k0> eVar) {
        Z17Preferences z17Preferences = this.preferences;
        String str = this.keyRootUrl;
        String strT = this.gson.t(rootEnvironment);
        y.h(strT, "toJson(...)");
        Object objStore = z17Preferences.store(str, strT, (ab.e<? super Boolean>) eVar);
        return objStore == bb.b.g() ? objStore : k0.f43947a;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object setSecretClean(String str, ab.e<? super Boolean> eVar) {
        C10051 c10051;
        if (eVar instanceof C10051) {
            c10051 = (C10051) eVar;
            int i10 = c10051.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c10051.label = i10 - Integer.MIN_VALUE;
            } else {
                c10051 = new C10051(eVar);
            }
        } else {
            c10051 = new C10051(eVar);
        }
        Object obj = c10051.result;
        Object objG = bb.b.g();
        int i11 = c10051.label;
        if (i11 == 0) {
            v.b(obj);
            Z17Preferences z17Preferences = this.preferences;
            String str2 = this.KEY_SECRET_ROOM_CLEAN_CODE;
            c10051.L$0 = cb.l.a(str);
            c10051.label = 1;
            if (z17Preferences.store(str2, str, c10051) == objG) {
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
    public final Object setSecretCode(String str, ab.e<? super Boolean> eVar) {
        C10061 c10061;
        if (eVar instanceof C10061) {
            c10061 = (C10061) eVar;
            int i10 = c10061.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c10061.label = i10 - Integer.MIN_VALUE;
            } else {
                c10061 = new C10061(eVar);
            }
        } else {
            c10061 = new C10061(eVar);
        }
        Object obj = c10061.result;
        Object objG = bb.b.g();
        int i11 = c10061.label;
        if (i11 == 0) {
            v.b(obj);
            Z17Preferences z17Preferences = this.preferences;
            String str2 = this.KEY_SECRET_ROOM_CODE;
            c10061.L$0 = cb.l.a(str);
            c10061.label = 1;
            if (z17Preferences.store(str2, str, c10061) == objG) {
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
    public final Object setSecretReady(boolean z10, ab.e<? super Boolean> eVar) {
        C10071 c10071;
        if (eVar instanceof C10071) {
            c10071 = (C10071) eVar;
            int i10 = c10071.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c10071.label = i10 - Integer.MIN_VALUE;
            } else {
                c10071 = new C10071(eVar);
            }
        } else {
            c10071 = new C10071(eVar);
        }
        Object obj = c10071.result;
        Object objG = bb.b.g();
        int i11 = c10071.label;
        if (i11 == 0) {
            v.b(obj);
            Z17Preferences z17Preferences = this.preferences;
            String str = this.KEY_SECRET_ROOM_READY;
            c10071.Z$0 = z10;
            c10071.label = 1;
            if (z17Preferences.store(str, z10, c10071) == objG) {
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
    public final Object setSentryState(boolean z10, ab.e<? super Boolean> eVar) {
        C10081 c10081;
        if (eVar instanceof C10081) {
            c10081 = (C10081) eVar;
            int i10 = c10081.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c10081.label = i10 - Integer.MIN_VALUE;
            } else {
                c10081 = new C10081(eVar);
            }
        } else {
            c10081 = new C10081(eVar);
        }
        Object obj = c10081.result;
        Object objG = bb.b.g();
        int i11 = c10081.label;
        if (i11 == 0) {
            v.b(obj);
            Z17Preferences z17Preferences = this.preferences;
            String str = this.KEY_SENTRY_ACTIVE;
            c10081.Z$0 = z10;
            c10081.label = 1;
            if (z17Preferences.store(str, z10, c10081) == objG) {
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
    public final Object setThemeSelectedState(int i10, ab.e<? super Boolean> eVar) {
        C10091 c10091;
        if (eVar instanceof C10091) {
            c10091 = (C10091) eVar;
            int i11 = c10091.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                c10091.label = i11 - Integer.MIN_VALUE;
            } else {
                c10091 = new C10091(eVar);
            }
        } else {
            c10091 = new C10091(eVar);
        }
        Object obj = c10091.result;
        Object objG = bb.b.g();
        int i12 = c10091.label;
        if (i12 == 0) {
            v.b(obj);
            Z17Preferences z17Preferences = this.preferences;
            String str = this.KEY_THEME_SELECTED;
            c10091.I$0 = i10;
            c10091.label = 1;
            if (z17Preferences.store(str, i10, (ab.e<? super Boolean>) c10091) == objG) {
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
}
