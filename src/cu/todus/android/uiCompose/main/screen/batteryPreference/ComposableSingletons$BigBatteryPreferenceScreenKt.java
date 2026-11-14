package cu.todus.android.uiCompose.main.screen.batteryPreference;

import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.outlined.InfoKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.res.StringResources_androidKt;
import cu.todus.android.R;
import cu.todus.android.uiCompose.theme.Other;
import cu.z17.views.label.Z17LabelKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
public final class ComposableSingletons$BigBatteryPreferenceScreenKt {
    public static final ComposableSingletons$BigBatteryPreferenceScreenKt INSTANCE = new ComposableSingletons$BigBatteryPreferenceScreenKt();

    /* JADX INFO: renamed from: lambda$-1431904817, reason: not valid java name */
    private static Function2 f167lambda$1431904817 = ComposableLambdaKt.composableLambdaInstance(-1431904817, false, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.batteryPreference.m0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$BigBatteryPreferenceScreenKt.lambda__1431904817$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2 lambda$1858314337 = ComposableLambdaKt.composableLambdaInstance(1858314337, false, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.batteryPreference.n0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$BigBatteryPreferenceScreenKt.lambda_1858314337$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 lambda_1858314337$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1858314337, i10, -1, "cu.todus.android.uiCompose.main.screen.batteryPreference.ComposableSingletons$BigBatteryPreferenceScreenKt.lambda$1858314337.<anonymous> (BigBatteryPreferenceScreen.kt:86)");
            }
            IconKt.m3298Iconww6aTOc(InfoKt.getInfo(Icons.Outlined.INSTANCE), "", (Modifier) null, Other.INSTANCE.m10118getRed0d7_KjU(), composer, 48, 4);
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
    public static final ua.k0 lambda__1431904817$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1431904817, i10, -1, "cu.todus.android.uiCompose.main.screen.batteryPreference.ComposableSingletons$BigBatteryPreferenceScreenKt.lambda$-1431904817.<anonymous> (BigBatteryPreferenceScreen.kt:71)");
            }
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, StringResources_androidKt.stringResource(R.string.battery_preference, composer, 0), MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getTitleSmall(), 0L, 0, 0, composer, 0, 57);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: renamed from: getLambda$-1431904817$app_productionPFast, reason: not valid java name */
    public final Function2 m9838getLambda$1431904817$app_productionPFast() {
        return f167lambda$1431904817;
    }

    public final Function2 getLambda$1858314337$app_productionPFast() {
        return lambda$1858314337;
    }
}
