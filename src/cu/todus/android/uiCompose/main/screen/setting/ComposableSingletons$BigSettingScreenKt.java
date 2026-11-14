package cu.todus.android.uiCompose.main.screen.setting;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.outlined.MarkChatReadKt;
import androidx.compose.material.icons.outlined.SettingsKt;
import androidx.compose.material.icons.outlined.ShareKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import cu.todus.android.R;
import cu.todus.android.uiCompose.theme.Other;
import cu.z17.views.label.Z17LabelKt;
import cu.z17.views.picture.Z17PictureKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
public final class ComposableSingletons$BigSettingScreenKt {
    public static final ComposableSingletons$BigSettingScreenKt INSTANCE = new ComposableSingletons$BigSettingScreenKt();

    /* JADX INFO: renamed from: lambda$-923420529, reason: not valid java name */
    private static Function2 f265lambda$923420529 = ComposableLambdaKt.composableLambdaInstance(-923420529, false, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.setting.c0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$BigSettingScreenKt.lambda__923420529$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2 lambda$1195215196 = ComposableLambdaKt.composableLambdaInstance(1195215196, false, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.setting.d0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$BigSettingScreenKt.lambda_1195215196$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2 lambda$490924960 = ComposableLambdaKt.composableLambdaInstance(490924960, false, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.setting.e0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$BigSettingScreenKt.lambda_490924960$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2 lambda$1831489815 = ComposableLambdaKt.composableLambdaInstance(1831489815, false, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.setting.f0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$BigSettingScreenKt.lambda_1831489815$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function3 lambda$271672036 = ComposableLambdaKt.composableLambdaInstance(271672036, false, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.setting.g0
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$BigSettingScreenKt.lambda_271672036$lambda$0((Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 lambda_1195215196$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1195215196, i10, -1, "cu.todus.android.uiCompose.main.screen.setting.ComposableSingletons$BigSettingScreenKt.lambda$1195215196.<anonymous> (BigSettingScreen.kt:118)");
            }
            IconKt.m3298Iconww6aTOc(ShareKt.getShare(Icons.Outlined.INSTANCE), "", (Modifier) null, 0L, composer, 48, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 lambda_1831489815$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1831489815, i10, -1, "cu.todus.android.uiCompose.main.screen.setting.ComposableSingletons$BigSettingScreenKt.lambda$1831489815.<anonymous> (BigSettingScreen.kt:296)");
            }
            Z17PictureKt.m10278Z17BasePictureC8z9wKI(PaddingKt.m1725padding3ABfNKs(BackgroundKt.m1204backgroundbw27NRU(SizeKt.m1769size3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(40)), Color.m5865copywmQWz5c$default(Other.INSTANCE.m10118getRed0d7_KjU(), 0.7f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.getCircleShape()), Dp.m8823constructorimpl(10)), SettingsKt.getSettings(Icons.Outlined.INSTANCE), null, ColorFilter.Companion.m5907tintxETnrds$default(ColorFilter.INSTANCE, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getBackground(), 0, 2, null), null, null, 0, null, null, composer, 0, XMPPTCPConnection.PacketWriter.QUEUE_SIZE);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 lambda_271672036$lambda$0(Modifier it, Composer composer, int i10) {
        kotlin.jvm.internal.y.i(it, "it");
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(271672036, i10, -1, "cu.todus.android.uiCompose.main.screen.setting.ComposableSingletons$BigSettingScreenKt.lambda$271672036.<anonymous> (BigSettingScreen.kt:351)");
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 lambda_490924960$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(490924960, i10, -1, "cu.todus.android.uiCompose.main.screen.setting.ComposableSingletons$BigSettingScreenKt.lambda$490924960.<anonymous> (BigSettingScreen.kt:268)");
            }
            Z17PictureKt.m10278Z17BasePictureC8z9wKI(PaddingKt.m1725padding3ABfNKs(BackgroundKt.m1204backgroundbw27NRU(SizeKt.m1769size3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(40)), Color.m5865copywmQWz5c$default(Other.INSTANCE.m10118getRed0d7_KjU(), 0.7f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.getCircleShape()), Dp.m8823constructorimpl(10)), MarkChatReadKt.getMarkChatRead(Icons.Outlined.INSTANCE), null, ColorFilter.Companion.m5907tintxETnrds$default(ColorFilter.INSTANCE, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getBackground(), 0, 2, null), null, null, 0, null, null, composer, 0, XMPPTCPConnection.PacketWriter.QUEUE_SIZE);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 lambda__923420529$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-923420529, i10, -1, "cu.todus.android.uiCompose.main.screen.setting.ComposableSingletons$BigSettingScreenKt.lambda$-923420529.<anonymous> (BigSettingScreen.kt:99)");
            }
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, StringResources_androidKt.stringResource(R.string.settings, composer, 0), MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getTitleSmall(), 0L, 0, 0, composer, 0, 57);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: renamed from: getLambda$-923420529$app_productionPFast, reason: not valid java name */
    public final Function2 m9981getLambda$923420529$app_productionPFast() {
        return f265lambda$923420529;
    }

    public final Function2 getLambda$1195215196$app_productionPFast() {
        return lambda$1195215196;
    }

    public final Function2 getLambda$1831489815$app_productionPFast() {
        return lambda$1831489815;
    }

    public final Function3 getLambda$271672036$app_productionPFast() {
        return lambda$271672036;
    }

    public final Function2 getLambda$490924960$app_productionPFast() {
        return lambda$490924960;
    }
}
