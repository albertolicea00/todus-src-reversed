package cu.todus.android.uiCompose.player;

import ab.i;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.p000activity.ComponentActivity;
import androidx.p000activity.compose.ComponentActivityKt;
import androidx.p001lifecycle.Lifecycle;
import androidx.p001lifecycle.LifecycleOwner;
import androidx.p001lifecycle.p002compose.FlowExtKt;
import androidx.p001lifecycle.p002compose.LocalLifecycleOwnerKt;
import cu.todus.android.ToDusApp;
import cu.todus.android.alive.AliveUtility;
import cu.todus.android.data.preferences.DataPreferences;
import cu.todus.android.repositories.MainRepository;
import cu.todus.android.uiCompose.navigation.NavLinks;
import cu.todus.android.uiCompose.player.PlayerActivity;
import cu.todus.android.uiCompose.theme.ThemeKt;
import cu.todus.android.uiCompose.theme.WindowSize;
import cu.todus.android.uiCompose.theme.WindowsSizeUtilKt;
import cu.todus.android.volatileState.AppVolatileState;
import cu.todus.android.xmpp.ConnectionState;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;
import te.b0;
import ua.k0;
import v5.f;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\t\u0010\u0003J\u000f\u0010\n\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\n\u0010\u0003¨\u0006\u000e²\u0006\f\u0010\r\u001a\u00020\f8\nX\u008a\u0084\u0002"}, d2 = {"Lcu/todus/android/uiCompose/player/PlayerActivity;", "Landroidx/activity/ComponentActivity;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", "Lua/k0;", "onCreate", "(Landroid/os/Bundle;)V", "onResume", "onStop", "Companion", "", "themeSelected", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class PlayerActivity extends ComponentActivity {
    public static final String ACTIVITY_NAME = "player";
    private static final String DEFAULT_PARAMS;
    public static final String PLAYER_PARAMS_KEY = "player_params_key";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JA\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0011\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0012¨\u0006\u0017"}, d2 = {"Lcu/todus/android/uiCompose/player/PlayerActivity$Companion;", "", "<init>", "()V", "Landroid/content/Context;", "context", "", "isLiveEvent", "", "url", "path", "Lkotlin/Pair;", "", "pipScale", "Lua/k0;", "openPlayerActivity", "(Landroid/content/Context;ZLjava/lang/String;Ljava/lang/String;Lkotlin/Pair;)V", "DEFAULT_PARAMS", "Ljava/lang/String;", "getDEFAULT_PARAMS", "()Ljava/lang/String;", "PLAYER_PARAMS_KEY", "ACTIVITY_NAME", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(p pVar) {
            this();
        }

        public final String getDEFAULT_PARAMS() {
            return PlayerActivity.DEFAULT_PARAMS;
        }

        public final void openPlayerActivity(Context context, boolean isLiveEvent, String url, String path, Pair<Integer, Integer> pipScale) {
            y.i(context, "context");
            y.i(url, "url");
            y.i(path, "path");
            y.i(pipScale, "pipScale");
            Intent intent = new Intent(context, (Class<?>) PlayerActivity.class);
            Bundle bundle = new Bundle();
            NavLinks navLinks = NavLinks.INSTANCE;
            String strT = new f().t(new PlayerParams(isLiveEvent, url, path, pipScale));
            y.h(strT, "toJson(...)");
            bundle.putString(PlayerActivity.PLAYER_PARAMS_KEY, navLinks.encode(strT));
            intent.putExtras(bundle);
            context.startActivity(intent);
        }

        private Companion() {
        }
    }

    static {
        NavLinks navLinks = NavLinks.INSTANCE;
        String strT = new f().t(new PlayerParams(false, "https://stream.todus.cu/vs/353b33bfce", null, null, 13, null));
        y.h(strT, "toJson(...)");
        DEFAULT_PARAMS = navLinks.encode(strT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 onCreate$lambda$0(final PlayerParams playerParams, Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-154642827, i10, -1, "cu.todus.android.uiCompose.player.PlayerActivity.onCreate.<anonymous> (PlayerActivity.kt:39)");
            }
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>) LocalLifecycleOwnerKt.getLocalLifecycleOwner().provides(composer.consume(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner())), ComposableLambdaKt.rememberComposableLambda(1017944501, true, new Function2() { // from class: l8.b
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PlayerActivity.onCreate$lambda$0$0(playerParams, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, ProvidedValue.$stable | 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 onCreate$lambda$0$0(final PlayerParams playerParams, Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1017944501, i10, -1, "cu.todus.android.uiCompose.player.PlayerActivity.onCreate.<anonymous>.<anonymous> (PlayerActivity.kt:42)");
            }
            ThemeKt.ToDusAppTheme(onCreate$lambda$0$0$0(FlowExtKt.collectAsStateWithLifecycle(AppVolatileState.INSTANCE.getInstance().getThemeSelected(), (LifecycleOwner) null, (Lifecycle.State) null, (i) null, composer, 0, 7)), WindowsSizeUtilKt.rememberWindowSizeClass(composer, 0) == WindowSize.Expanded, ComposableLambdaKt.rememberComposableLambda(22305939, true, new Function2() { // from class: l8.c
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PlayerActivity.onCreate$lambda$0$0$1(playerParams, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, RendererCapabilities.DECODER_SUPPORT_MASK, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    private static final int onCreate$lambda$0$0$0(State<Integer> state) {
        return state.getValue().intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 onCreate$lambda$0$0$1(PlayerParams playerParams, Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(22305939, i10, -1, "cu.todus.android.uiCompose.player.PlayerActivity.onCreate.<anonymous>.<anonymous>.<anonymous> (PlayerActivity.kt:50)");
            }
            y.f(playerParams);
            PlayerAppKt.PlayerApp(playerParams, composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    @Override // androidx.p000activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        String string;
        super.onCreate(savedInstanceState);
        requestWindowFeature(1);
        NavLinks navLinks = NavLinks.INSTANCE;
        Bundle extras = getIntent().getExtras();
        if (extras == null || (string = extras.getString(PLAYER_PARAMS_KEY, DEFAULT_PARAMS)) == null) {
            string = DEFAULT_PARAMS;
        }
        String strDecode = navLinks.decode(string);
        getWindow().addFlags(128);
        final PlayerParams playerParams = (PlayerParams) new f().j(strDecode, PlayerParams.class);
        ComponentActivityKt.setContent$default(this, null, ComposableLambdaKt.composableLambdaInstance(-154642827, true, new Function2() { // from class: l8.a
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return PlayerActivity.onCreate$lambda$0(playerParams, (Composer) obj, ((Integer) obj2).intValue());
            }
        }), 1, null);
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        AliveUtility aliveUtility = AliveUtility.INSTANCE;
        Context applicationContext = getApplicationContext();
        y.h(applicationContext, "getApplicationContext(...)");
        aliveUtility.stopService(applicationContext);
    }

    @Override // android.app.Activity
    public void onStop() {
        b0 connectionState;
        ConnectionState connectionState2;
        String aliveConfiguration;
        super.onStop();
        getWindow().clearFlags(128);
        MainRepository instanceOrNull = MainRepository.INSTANCE.getInstanceOrNull();
        if (instanceOrNull == null || (connectionState = instanceOrNull.getConnectionState()) == null || (connectionState2 = (ConnectionState) connectionState.getValue()) == null || !connectionState2.isConnected()) {
            return;
        }
        Context applicationContext = getApplicationContext();
        y.g(applicationContext, "null cannot be cast to non-null type cu.todus.android.ToDusApp");
        ToDusApp toDusApp = (ToDusApp) applicationContext;
        AppVolatileState instanceOrNull2 = AppVolatileState.INSTANCE.getInstanceOrNull();
        if (instanceOrNull2 == null || (aliveConfiguration = instanceOrNull2.getAliveConfiguration()) == null) {
            aliveConfiguration = DataPreferences.CON_ECO;
        }
        toDusApp.manageAlive(aliveConfiguration, true);
    }
}
