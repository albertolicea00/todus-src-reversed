package cu.todus.android.utils.betterypermissionhelper;

import ab.e;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.os.Build;
import android.os.PowerManager;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.media3.extractor.text.ttml.TtmlNode;
import cb.f;
import cb.m;
import cu.todus.android.utils.betterypermissionhelper.utils.ApplicationUtilsKt;
import defpackage.r;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;
import te.h;
import te.i;
import te.j;
import ua.k0;
import ua.z;
import va.v;
import va.w;
import va.w0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b&\b\u0007\u0018\u0000 b2\u00020\u0001:\u0001bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ'\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000b\u0010\nJ'\u0010\f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\f\u0010\nJ'\u0010\r\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\r\u0010\nJ'\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000e\u0010\nJ'\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000f\u0010\nJ'\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0010\u0010\nJ'\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0011\u0010\nJ'\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0012\u0010\nJ'\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0013\u0010\nJ!\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u001f\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001bH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ'\u0010!\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020\u001b2\u0006\u0010\b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b!\u0010\"J;\u0010%\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020\u001b2\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001b0#2\u0006\u0010\b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b%\u0010&J3\u0010(\u001a\u00020\u00142\u0006\u0010'\u001a\u00020\u001b2\u0006\u0010\b\u001a\u00020\u00062\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001b0#H\u0002¢\u0006\u0004\b(\u0010)J\u001f\u0010*\u001a\u00020\u00142\u0006\u0010'\u001a\u00020\u001b2\u0006\u0010\b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b*\u0010+J\u001f\u0010,\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0014H\u0002¢\u0006\u0004\b,\u0010-J%\u00100\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00140.H\u0002¢\u0006\u0004\b0\u00101J%\u00102\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00140.H\u0002¢\u0006\u0004\b2\u00101J;\u00104\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u001b0.2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00140.2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b4\u00105J-\u00107\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u00140.2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b7\u00108J)\u00109\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b9\u0010\nJ\u001f\u0010;\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010:\u001a\u00020\u0006¢\u0006\u0004\b;\u0010<J%\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00060=2\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010:\u001a\u00020\u0006¢\u0006\u0004\b>\u0010?R\u0014\u0010@\u001a\u00020\u001b8\u0002X\u0082D¢\u0006\u0006\n\u0004\b@\u0010AR\u0014\u0010B\u001a\u00020\u001b8\u0002X\u0082D¢\u0006\u0006\n\u0004\bB\u0010AR\u0014\u0010C\u001a\u00020\u001b8\u0002X\u0082D¢\u0006\u0006\n\u0004\bC\u0010AR\u0014\u0010D\u001a\u00020\u001b8\u0002X\u0082D¢\u0006\u0006\n\u0004\bD\u0010AR\u0014\u0010E\u001a\u00020\u001b8\u0002X\u0082D¢\u0006\u0006\n\u0004\bE\u0010AR\u0014\u0010F\u001a\u00020\u001b8\u0002X\u0082D¢\u0006\u0006\n\u0004\bF\u0010AR\u0014\u0010G\u001a\u00020\u001b8\u0002X\u0082D¢\u0006\u0006\n\u0004\bG\u0010AR\u0014\u0010H\u001a\u00020\u001b8\u0002X\u0082D¢\u0006\u0006\n\u0004\bH\u0010AR\u0014\u0010I\u001a\u00020\u001b8\u0002X\u0082D¢\u0006\u0006\n\u0004\bI\u0010AR\u0014\u0010J\u001a\u00020\u001b8\u0002X\u0082D¢\u0006\u0006\n\u0004\bJ\u0010AR\u0014\u0010K\u001a\u00020\u001b8\u0002X\u0082D¢\u0006\u0006\n\u0004\bK\u0010AR\u0014\u0010L\u001a\u00020\u001b8\u0002X\u0082D¢\u0006\u0006\n\u0004\bL\u0010AR\u0014\u0010M\u001a\u00020\u001b8\u0002X\u0082D¢\u0006\u0006\n\u0004\bM\u0010AR\u0014\u0010N\u001a\u00020\u001b8\u0002X\u0082D¢\u0006\u0006\n\u0004\bN\u0010AR\u0014\u0010O\u001a\u00020\u001b8\u0002X\u0082D¢\u0006\u0006\n\u0004\bO\u0010AR\u0014\u0010P\u001a\u00020\u001b8\u0002X\u0082D¢\u0006\u0006\n\u0004\bP\u0010AR\u0014\u0010Q\u001a\u00020\u001b8\u0002X\u0082D¢\u0006\u0006\n\u0004\bQ\u0010AR\u0014\u0010R\u001a\u00020\u001b8\u0002X\u0082D¢\u0006\u0006\n\u0004\bR\u0010AR\u0014\u0010S\u001a\u00020\u001b8\u0002X\u0082D¢\u0006\u0006\n\u0004\bS\u0010AR\u0014\u0010T\u001a\u00020\u001b8\u0002X\u0082D¢\u0006\u0006\n\u0004\bT\u0010AR\u0014\u0010U\u001a\u00020\u001b8\u0002X\u0082D¢\u0006\u0006\n\u0004\bU\u0010AR\u0014\u0010V\u001a\u00020\u001b8\u0002X\u0082D¢\u0006\u0006\n\u0004\bV\u0010AR\u0014\u0010W\u001a\u00020\u001b8\u0002X\u0082D¢\u0006\u0006\n\u0004\bW\u0010AR\u0014\u0010X\u001a\u00020\u001b8\u0002X\u0082D¢\u0006\u0006\n\u0004\bX\u0010AR\u0014\u0010Y\u001a\u00020\u001b8\u0002X\u0082D¢\u0006\u0006\n\u0004\bY\u0010AR\u0014\u0010Z\u001a\u00020\u001b8\u0002X\u0082D¢\u0006\u0006\n\u0004\bZ\u0010AR\u0014\u0010[\u001a\u00020\u001b8\u0002X\u0082D¢\u0006\u0006\n\u0004\b[\u0010AR\u0014\u0010\\\u001a\u00020\u001b8\u0002X\u0082D¢\u0006\u0006\n\u0004\b\\\u0010AR\u0014\u0010]\u001a\u00020\u001b8\u0002X\u0082D¢\u0006\u0006\n\u0004\b]\u0010AR\u0014\u0010^\u001a\u00020\u001b8\u0002X\u0082D¢\u0006\u0006\n\u0004\b^\u0010AR\u0014\u0010_\u001a\u00020\u001b8\u0002X\u0082D¢\u0006\u0006\n\u0004\b_\u0010AR\u001a\u0010`\u001a\b\u0012\u0004\u0012\u00020\u001b0.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b`\u0010a¨\u0006c"}, d2 = {"Lcu/todus/android/utils/betterypermissionhelper/BatteryPermissionHelper;", "", "<init>", "()V", "Landroid/content/Context;", "context", "", "open", "newTask", "startForHtc", "(Landroid/content/Context;ZZ)Z", "startForHuawei", "startForLetv", "startForMeizu", "startForOppo", "launchOppoAppInfo", "startForSamsung", "startForXiaomi", "startForZte", "startDefault", "Landroid/content/Intent;", "getActionDozeMode", "(Landroid/content/Context;Z)Landroid/content/Intent;", "intent", "Lua/k0;", "startIntent", "(Landroid/content/Context;Landroid/content/Intent;)V", "", "targetPackage", "isPackageExists", "(Landroid/content/Context;Ljava/lang/String;)Z", "packageName", "componentName", "getIntent", "(Ljava/lang/String;Ljava/lang/String;Z)Landroid/content/Intent;", "", "extras", "getIntentWithExtras", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Z)Landroid/content/Intent;", "intentAction", "getIntentFromActionWithExtras", "(Ljava/lang/String;ZLjava/util/Map;)Landroid/content/Intent;", "getIntentFromAction", "(Ljava/lang/String;Z)Landroid/content/Intent;", "isActivityFound", "(Landroid/content/Context;Landroid/content/Intent;)Z", "", "intents", "areActivitiesFound", "(Landroid/content/Context;Ljava/util/List;)Z", "startScreen", "packages", TtmlNode.START, "(Landroid/content/Context;Ljava/util/List;Ljava/util/List;Z)Z", "intentActions", "startFromAction", "(Landroid/content/Context;Ljava/util/List;Z)Z", "getPermission", "onlyIfSupported", "isBatterySaverPermissionAvailable", "(Landroid/content/Context;Z)Z", "Lte/h;", "isBatterySaverPermissionAvailableFlow", "(Landroid/content/Context;Z)Lte/h;", "BRAND_HTC", "Ljava/lang/String;", "PACKAGE_HTC_MAIN", "PACKAGE_HTC_COMPONENT", "BRAND_HUAWEI", "PACKAGE_HUAWEI_MAIN", "PACKAGE_HUAWEI_ACTION", "BRAND_LETV", "PACKAGE_LETV_MAIN", "PACKAGE_LETV_COMPONENT", "BRAND_MEIZU", "PACKAGE_MEIZU_MAIN", "PACKAGE_MEIZU_COMPONENT", "PACKAGE_MEIZU_ACTION", "BRAND_OPPO", "PACKAGE_OPPO_MAIN", "PACKAGE_OPPO_COMPONENT", "PACKAGE_OPPO_COMPONENT_FALLBACK", "BRAND_SAMSUNG", "PACKAGE_SAMSUNG_MAIN", "PACKAGE_SAMSUNG_FALLBACK", "PACKAGE_SAMSUNG_COMPONENT", "PACKAGE_SAMSUNG_COMPONENT_FALLBACK", "PACKAGE_SAMSUNG_ACTION", "BRAND_XIAOMI", "BRAND_XIAOMI_POCO", "BRAND_XIAOMI_REDMI", "PACKAGE_XIAOMI_MAIN", "PACKAGE_XIAOMI_COMPONENT", "BRAND_ZTE", "PACKAGE_ZTE_MAIN", "PACKAGE_ZTE_COMPONENT", "PACKAGES_TO_CHECK_FOR_PERMISSION", "Ljava/util/List;", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class BatteryPermissionHelper {
    private static volatile BatteryPermissionHelper instance;
    private final String BRAND_HTC;
    private final String BRAND_HUAWEI;
    private final String BRAND_LETV;
    private final String BRAND_MEIZU;
    private final String BRAND_OPPO;
    private final String BRAND_SAMSUNG;
    private final String BRAND_XIAOMI;
    private final String BRAND_XIAOMI_POCO;
    private final String BRAND_XIAOMI_REDMI;
    private final String BRAND_ZTE;
    private final List<String> PACKAGES_TO_CHECK_FOR_PERMISSION;
    private final String PACKAGE_HTC_COMPONENT;
    private final String PACKAGE_HTC_MAIN;
    private final String PACKAGE_HUAWEI_ACTION;
    private final String PACKAGE_HUAWEI_MAIN;
    private final String PACKAGE_LETV_COMPONENT;
    private final String PACKAGE_LETV_MAIN;
    private final String PACKAGE_MEIZU_ACTION;
    private final String PACKAGE_MEIZU_COMPONENT;
    private final String PACKAGE_MEIZU_MAIN;
    private final String PACKAGE_OPPO_COMPONENT;
    private final String PACKAGE_OPPO_COMPONENT_FALLBACK;
    private final String PACKAGE_OPPO_MAIN;
    private final String PACKAGE_SAMSUNG_ACTION;
    private final String PACKAGE_SAMSUNG_COMPONENT;
    private final String PACKAGE_SAMSUNG_COMPONENT_FALLBACK;
    private final String PACKAGE_SAMSUNG_FALLBACK;
    private final String PACKAGE_SAMSUNG_MAIN;
    private final String PACKAGE_XIAOMI_COMPONENT;
    private final String PACKAGE_XIAOMI_MAIN;
    private final String PACKAGE_ZTE_COMPONENT;
    private final String PACKAGE_ZTE_MAIN;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0006\u001a\u00020\u0005R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcu/todus/android/utils/betterypermissionhelper/BatteryPermissionHelper$Companion;", "", "<init>", "()V", "instance", "Lcu/todus/android/utils/betterypermissionhelper/BatteryPermissionHelper;", "getInstance", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(p pVar) {
            this();
        }

        public final BatteryPermissionHelper getInstance() {
            BatteryPermissionHelper batteryPermissionHelper;
            BatteryPermissionHelper batteryPermissionHelper2 = BatteryPermissionHelper.instance;
            if (batteryPermissionHelper2 != null) {
                return batteryPermissionHelper2;
            }
            synchronized (this) {
                batteryPermissionHelper = BatteryPermissionHelper.instance;
                if (batteryPermissionHelper == null) {
                    batteryPermissionHelper = new BatteryPermissionHelper(null);
                    BatteryPermissionHelper.instance = batteryPermissionHelper;
                }
            }
            return batteryPermissionHelper;
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.utils.betterypermissionhelper.BatteryPermissionHelper$isBatterySaverPermissionAvailableFlow$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @f(c = "cu.todus.android.utils.betterypermissionhelper.BatteryPermissionHelper$isBatterySaverPermissionAvailableFlow$1", f = "BatteryPermissionHelper.kt", l = {271, 273, 290, 298, 302}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lte/i;", "", "Lua/k0;", "<anonymous>", "(Lte/i;)V"}, k = 3, mv = {2, 3, 0})
    public static final class AnonymousClass1 extends m implements Function2 {
        final /* synthetic */ Context $context;
        final /* synthetic */ boolean $onlyIfSupported;
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        final /* synthetic */ BatteryPermissionHelper this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Context context, BatteryPermissionHelper batteryPermissionHelper, boolean z10, e<? super AnonymousClass1> eVar) {
            super(2, eVar);
            this.$context = context;
            this.this$0 = batteryPermissionHelper;
            this.$onlyIfSupported = z10;
        }

        @Override // cb.a
        public final e<k0> create(Object obj, e<?> eVar) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$context, this.this$0, this.$onlyIfSupported, eVar);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        /* JADX WARN: Code duplicated, block: B:21:0x005a  */
        /* JADX WARN: Code duplicated, block: B:29:0x0095 A[Catch: Exception -> 0x0041, TryCatch #0 {Exception -> 0x0041, blocks: (B:14:0x003d, B:26:0x0078, B:27:0x008f, B:29:0x0095, B:32:0x00aa, B:34:0x00b8, B:36:0x00bc, B:38:0x00d0, B:42:0x00f7, B:19:0x0056), top: B:48:0x0013 }] */
        /* JADX WARN: Code duplicated, block: B:31:0x00a9  */
        /* JADX WARN: Code duplicated, block: B:42:0x00f7 A[Catch: Exception -> 0x0041, TRY_LEAVE, TryCatch #0 {Exception -> 0x0041, blocks: (B:14:0x003d, B:26:0x0078, B:27:0x008f, B:29:0x0095, B:32:0x00aa, B:34:0x00b8, B:36:0x00bc, B:38:0x00d0, B:42:0x00f7, B:19:0x0056), top: B:48:0x0013 }] */
        /* JADX WARN: Code restructure failed: missing block: B:24:0x0074, code lost:
        
            if (pe.w0.b(1000, r21) == r3) goto L47;
         */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x00f5 -> B:23:0x0062). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x0136 -> B:23:0x0062). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x0154 -> B:23:0x0062). Please report as a decompilation issue!!! */
        @Override // cb.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r22) {
            /*
                Method dump skipped, instruction units count: 343
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.utils.betterypermissionhelper.BatteryPermissionHelper.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(i iVar, e<? super k0> eVar) {
            return ((AnonymousClass1) create(iVar, eVar)).invokeSuspend(k0.f43947a);
        }
    }

    public /* synthetic */ BatteryPermissionHelper(p pVar) {
        this();
    }

    private final boolean areActivitiesFound(Context context, List<? extends Intent> intents) {
        if (r.a(intents) && intents.isEmpty()) {
            return false;
        }
        Iterator<T> it = intents.iterator();
        while (it.hasNext()) {
            if (isActivityFound(context, (Intent) it.next())) {
                return true;
            }
        }
        return false;
    }

    private final Intent getActionDozeMode(Context context, boolean newTask) {
        if (Build.VERSION.SDK_INT < 24) {
            return null;
        }
        Object systemService = context.getSystemService("power");
        y.g(systemService, "null cannot be cast to non-null type android.os.PowerManager");
        if (((PowerManager) systemService).isIgnoringBatteryOptimizations(context.getPackageName())) {
            return null;
        }
        Intent intentFromAction = getIntentFromAction("android.settings.IGNORE_BATTERY_OPTIMIZATION_SETTINGS", newTask);
        intentFromAction.setData(Uri.parse("package:" + context.getPackageName()));
        return intentFromAction;
    }

    private final Intent getIntent(String packageName, String componentName, boolean newTask) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(packageName, componentName));
        if (newTask) {
            intent.addFlags(268435456);
        }
        return intent;
    }

    private final Intent getIntentFromAction(String intentAction, boolean newTask) {
        Intent intent = new Intent();
        intent.setAction(intentAction);
        if (newTask) {
            intent.addFlags(268435456);
        }
        return intent;
    }

    private final Intent getIntentFromActionWithExtras(String intentAction, boolean newTask, Map<String, String> extras) {
        Intent intent = new Intent();
        intent.setAction(intentAction);
        if (newTask) {
            intent.addFlags(268435456);
        }
        for (Map.Entry<String, String> entry : extras.entrySet()) {
            intent.putExtra(entry.getKey(), entry.getValue());
        }
        return intent;
    }

    private final Intent getIntentWithExtras(String packageName, String componentName, Map<String, String> extras, boolean newTask) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(packageName, componentName));
        if (newTask) {
            intent.addFlags(268435456);
        }
        for (Map.Entry<String, String> entry : extras.entrySet()) {
            intent.putExtra(entry.getKey(), entry.getValue());
        }
        return intent;
    }

    public static /* synthetic */ boolean getPermission$default(BatteryPermissionHelper batteryPermissionHelper, Context context, boolean z10, boolean z11, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = true;
        }
        if ((i10 & 4) != 0) {
            z11 = false;
        }
        return batteryPermissionHelper.getPermission(context, z10, z11);
    }

    private final boolean isActivityFound(Context context, Intent intent) {
        return !ApplicationUtilsKt.getIntentActivities$default(context, intent, 0, 2, null).isEmpty();
    }

    public static /* synthetic */ boolean isBatterySaverPermissionAvailable$default(BatteryPermissionHelper batteryPermissionHelper, Context context, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return batteryPermissionHelper.isBatterySaverPermissionAvailable(context, z10);
    }

    public static /* synthetic */ h isBatterySaverPermissionAvailableFlow$default(BatteryPermissionHelper batteryPermissionHelper, Context context, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return batteryPermissionHelper.isBatterySaverPermissionAvailableFlow(context, z10);
    }

    private final boolean isPackageExists(Context context, String targetPackage) {
        List<ApplicationInfo> installedApplications = context.getPackageManager().getInstalledApplications(0);
        y.h(installedApplications, "getInstalledApplications(...)");
        Iterator<ApplicationInfo> it = installedApplications.iterator();
        while (it.hasNext()) {
            if (y.d(it.next().packageName, targetPackage)) {
                return true;
            }
        }
        return false;
    }

    private final boolean launchOppoAppInfo(Context context, boolean open, boolean newTask) {
        try {
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.addCategory("android.intent.category.DEFAULT");
            intent.setData(Uri.parse("package:" + context.getPackageName()));
            if (!open) {
                return isActivityFound(context, intent);
            }
            context.startActivity(intent);
            return true;
        } catch (Exception e10) {
            e10.printStackTrace();
            return false;
        }
    }

    private final boolean start(Context context, List<String> packages, List<? extends Intent> intents, boolean open) {
        if (r.a(packages) && packages.isEmpty()) {
            return false;
        }
        Iterator<T> it = packages.iterator();
        while (it.hasNext()) {
            if (isPackageExists(context, (String) it.next())) {
                return open ? startScreen(context, intents) : areActivitiesFound(context, intents);
            }
        }
        return false;
    }

    private final boolean startDefault(Context context, boolean open, boolean newTask) throws Exception {
        Intent actionDozeMode = getActionDozeMode(context, newTask);
        if (actionDozeMode != null) {
            return startFromAction(context, v.e(actionDozeMode), open);
        }
        Intent intent = new Intent();
        intent.setAction("android.settings.IGNORE_BATTERY_OPTIMIZATION_SETTINGS");
        startIntent(context, intent);
        return false;
    }

    private final boolean startForHtc(Context context, boolean open, boolean newTask) {
        return start(context, v.e(this.PACKAGE_HTC_MAIN), v.e(getIntent(this.PACKAGE_HTC_MAIN, this.PACKAGE_HTC_COMPONENT, newTask)), open);
    }

    private final boolean startForHuawei(Context context, boolean open, boolean newTask) {
        return startFromAction(context, v.e(getIntentFromAction(this.PACKAGE_HUAWEI_ACTION, newTask)), open);
    }

    private final boolean startForLetv(Context context, boolean open, boolean newTask) {
        return start(context, v.e(this.PACKAGE_LETV_MAIN), v.e(getIntent(this.PACKAGE_LETV_MAIN, this.PACKAGE_LETV_COMPONENT, newTask)), open);
    }

    private final boolean startForMeizu(Context context, boolean open, boolean newTask) {
        return start(context, v.e(this.PACKAGE_MEIZU_MAIN), v.e(getIntent(this.PACKAGE_MEIZU_MAIN, this.PACKAGE_MEIZU_COMPONENT, newTask)), open) || startFromAction(context, v.e(getIntentFromAction(this.PACKAGE_MEIZU_ACTION, newTask)), open);
    }

    private final boolean startForOppo(Context context, boolean open, boolean newTask) {
        if (start(context, v.e(this.PACKAGE_OPPO_MAIN), w.q(getIntent(this.PACKAGE_OPPO_MAIN, this.PACKAGE_OPPO_COMPONENT, newTask), getIntent(this.PACKAGE_OPPO_MAIN, this.PACKAGE_OPPO_COMPONENT_FALLBACK, newTask)), open)) {
            return true;
        }
        return launchOppoAppInfo(context, open, newTask);
    }

    private final boolean startForSamsung(Context context, boolean open, boolean newTask) {
        return startFromAction(context, v.e(getIntentFromAction(this.PACKAGE_SAMSUNG_ACTION, newTask)), open) || start(context, w.q(this.PACKAGE_SAMSUNG_MAIN, this.PACKAGE_SAMSUNG_FALLBACK), w.q(getIntent(this.PACKAGE_SAMSUNG_MAIN, this.PACKAGE_SAMSUNG_COMPONENT, newTask), getIntent(this.PACKAGE_SAMSUNG_MAIN, this.PACKAGE_SAMSUNG_COMPONENT_FALLBACK, newTask)), open);
    }

    private final boolean startForXiaomi(Context context, boolean open, boolean newTask) {
        return start(context, v.e(this.PACKAGE_XIAOMI_MAIN), v.e(getIntentWithExtras(this.PACKAGE_XIAOMI_MAIN, this.PACKAGE_XIAOMI_COMPONENT, w0.l(z.a("package_name", context.getPackageName()), z.a("package_label", ApplicationUtilsKt.getApplicationName(context))), newTask)), open);
    }

    private final boolean startForZte(Context context, boolean open, boolean newTask) {
        return start(context, v.e(this.PACKAGE_ZTE_MAIN), v.e(getIntent(this.PACKAGE_ZTE_MAIN, this.PACKAGE_ZTE_COMPONENT, newTask)), open);
    }

    private final boolean startFromAction(Context context, List<? extends Intent> intentActions, boolean open) {
        return open ? startScreen(context, intentActions) : areActivitiesFound(context, intentActions);
    }

    private final void startIntent(Context context, Intent intent) throws Exception {
        try {
            context.startActivity(intent);
        } catch (Exception e10) {
            e10.printStackTrace();
            throw e10;
        }
    }

    private final boolean startScreen(Context context, List<? extends Intent> intents) throws Exception {
        for (Intent intent : intents) {
            if (isActivityFound(context, intent)) {
                startIntent(context, intent);
                return true;
            }
        }
        Intent intent2 = new Intent();
        intent2.setAction("android.settings.IGNORE_BATTERY_OPTIMIZATION_SETTINGS");
        startIntent(context, intent2);
        return false;
    }

    public final boolean getPermission(Context context, boolean open, boolean newTask) {
        y.i(context, "context");
        try {
            String BRAND = Build.BRAND;
            y.h(BRAND, "BRAND");
            Locale ROOT = Locale.ROOT;
            y.h(ROOT, "ROOT");
            String lowerCase = BRAND.toLowerCase(ROOT);
            y.h(lowerCase, "toLowerCase(...)");
            if (y.d(lowerCase, this.BRAND_HTC)) {
                return startForHtc(context, open, newTask);
            }
            if (y.d(lowerCase, this.BRAND_HUAWEI)) {
                return startForHuawei(context, open, newTask);
            }
            if (y.d(lowerCase, this.BRAND_MEIZU)) {
                return startForMeizu(context, open, newTask);
            }
            if (y.d(lowerCase, this.BRAND_OPPO)) {
                return startForOppo(context, open, newTask);
            }
            if (y.d(lowerCase, this.BRAND_SAMSUNG)) {
                return startForSamsung(context, open, newTask);
            }
            if (!y.d(lowerCase, this.BRAND_XIAOMI) && !y.d(lowerCase, this.BRAND_XIAOMI_POCO) && !y.d(lowerCase, this.BRAND_XIAOMI_REDMI)) {
                if (y.d(lowerCase, this.BRAND_ZTE)) {
                    return startForZte(context, open, newTask);
                }
                return y.d(lowerCase, this.BRAND_LETV) ? startForLetv(context, open, newTask) : startDefault(context, open, newTask);
            }
            return startForXiaomi(context, open, newTask);
        } catch (Exception unused) {
            return false;
        }
    }

    public final boolean isBatterySaverPermissionAvailable(Context context, boolean onlyIfSupported) {
        y.i(context, "context");
        List<ApplicationInfo> installedApplications = context.getPackageManager().getInstalledApplications(0);
        y.h(installedApplications, "getInstalledApplications(...)");
        Iterator<ApplicationInfo> it = installedApplications.iterator();
        while (it.hasNext()) {
            if (this.PACKAGES_TO_CHECK_FOR_PERMISSION.contains(it.next().packageName)) {
                if (!onlyIfSupported) {
                    return true;
                }
                Context context2 = context;
                if (getPermission$default(this, context2, false, false, 4, null)) {
                    return true;
                }
                context = context2;
            }
        }
        return false;
    }

    public final h isBatterySaverPermissionAvailableFlow(Context context, boolean onlyIfSupported) {
        y.i(context, "context");
        return j.B(new AnonymousClass1(context, this, onlyIfSupported, null));
    }

    private BatteryPermissionHelper() {
        this.BRAND_HTC = "htc";
        this.PACKAGE_HTC_MAIN = "com.htc.pitroad";
        this.PACKAGE_HTC_COMPONENT = "com.htc.pitroad.landingpage.activity.LandingPageActivity";
        this.BRAND_HUAWEI = "huawei";
        this.PACKAGE_HUAWEI_MAIN = "com.huawei.systemmanager";
        this.PACKAGE_HUAWEI_ACTION = "huawei.intent.action.HSM_PROTECTED_APPS";
        this.BRAND_LETV = "letv";
        this.PACKAGE_LETV_MAIN = "com.letv.android.letvsafe";
        this.PACKAGE_LETV_COMPONENT = "com.letv.android.letvsafe.BackgroundAppManageActivity";
        this.BRAND_MEIZU = "meizu";
        this.PACKAGE_MEIZU_MAIN = "com.meizu.safe";
        this.PACKAGE_MEIZU_COMPONENT = "com.meizu.safe.powerui.PowerAppPermissionActivity";
        this.PACKAGE_MEIZU_ACTION = "com.meizu.power.PowerAppKilledNotification";
        this.BRAND_OPPO = "oppo";
        this.PACKAGE_OPPO_MAIN = "com.coloros.oppoguardelf";
        this.PACKAGE_OPPO_COMPONENT = "com.coloros.powermanager.fuelgaue.PowerConsumptionActivity";
        this.PACKAGE_OPPO_COMPONENT_FALLBACK = "com.coloros.powermanager.fuelgaue.PowerUsageModelActivity";
        this.BRAND_SAMSUNG = "samsung";
        this.PACKAGE_SAMSUNG_MAIN = "com.samsung.android.lool";
        this.PACKAGE_SAMSUNG_FALLBACK = "com.samsung.android.sm_cn";
        this.PACKAGE_SAMSUNG_COMPONENT = "com.samsung.android.sm.ui.battery.BatteryActivity";
        this.PACKAGE_SAMSUNG_COMPONENT_FALLBACK = "com.samsung.android.sm.ui.battery.BatteryActivity";
        this.PACKAGE_SAMSUNG_ACTION = "com.samsung.android.sm.ACTION_BATTERY";
        this.BRAND_XIAOMI = "xiaomi";
        this.BRAND_XIAOMI_POCO = "poco";
        this.BRAND_XIAOMI_REDMI = "redmi";
        this.PACKAGE_XIAOMI_MAIN = "com.miui.powerkeeper";
        this.PACKAGE_XIAOMI_COMPONENT = "com.miui.powerkeeper.ui.HiddenAppsConfigActivity";
        this.BRAND_ZTE = "zte";
        this.PACKAGE_ZTE_MAIN = "com.zte.heartyservice";
        this.PACKAGE_ZTE_COMPONENT = "com.zte.heartyservice.setting.ClearAppSettingsActivity";
        this.PACKAGES_TO_CHECK_FOR_PERMISSION = w.q("com.htc.pitroad", "com.huawei.systemmanager", "com.letv.android.letvsafe", "com.meizu.safe", "com.coloros.oppoguardelf", "com.samsung.android.lool", "com.miui.powerkeeper", "com.zte.heartyservice");
    }
}
