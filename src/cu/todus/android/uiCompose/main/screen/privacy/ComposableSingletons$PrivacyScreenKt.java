package cu.todus.android.uiCompose.main.screen.privacy;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.outlined.CloseKt;
import androidx.compose.material.icons.outlined.RefreshKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import cu.todus.android.R;
import cu.z17.views.label.Z17LabelKt;
import cu.z17.views.picture.Z17PictureKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
public final class ComposableSingletons$PrivacyScreenKt {
    public static final ComposableSingletons$PrivacyScreenKt INSTANCE = new ComposableSingletons$PrivacyScreenKt();
    private static Function2 lambda$1419631669 = ComposableLambdaKt.composableLambdaInstance(1419631669, false, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.privacy.a
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$PrivacyScreenKt.lambda_1419631669$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-421551034, reason: not valid java name */
    private static Function2 f238lambda$421551034 = ComposableLambdaKt.composableLambdaInstance(-421551034, false, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.privacy.b
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$PrivacyScreenKt.lambda__421551034$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2 lambda$342309648 = ComposableLambdaKt.composableLambdaInstance(342309648, false, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.privacy.c
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$PrivacyScreenKt.lambda_342309648$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-1826065194, reason: not valid java name */
    private static Function3 f236lambda$1826065194 = ComposableLambdaKt.composableLambdaInstance(-1826065194, false, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.privacy.d
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$PrivacyScreenKt.lambda__1826065194$lambda$0((LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-315878643, reason: not valid java name */
    private static Function3 f237lambda$315878643 = ComposableLambdaKt.composableLambdaInstance(-315878643, false, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.privacy.e
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$PrivacyScreenKt.lambda__315878643$lambda$0((LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 lambda_1419631669$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1419631669, i10, -1, "cu.todus.android.uiCompose.main.screen.privacy.ComposableSingletons$PrivacyScreenKt.lambda$1419631669.<anonymous> (PrivacyScreen.kt:102)");
            }
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, StringResources_androidKt.stringResource(R.string.privacy, composer, 0), MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getTitleSmall(), 0L, 0, 0, composer, 0, 57);
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
    public static final ua.k0 lambda_342309648$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(342309648, i10, -1, "cu.todus.android.uiCompose.main.screen.privacy.ComposableSingletons$PrivacyScreenKt.lambda$342309648.<anonymous> (PrivacyScreen.kt:450)");
            }
            IconKt.m3298Iconww6aTOc(CloseKt.getClose(Icons.Outlined.INSTANCE), "", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOnBackground(), composer, 48, 4);
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
    public static final ua.k0 lambda__1826065194$lambda$0(LazyItemScope item, Composer composer, int i10) {
        kotlin.jvm.internal.y.i(item, "$this$item");
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1826065194, i10, -1, "cu.todus.android.uiCompose.main.screen.privacy.ComposableSingletons$PrivacyScreenKt.lambda$-1826065194.<anonymous> (PrivacyScreen.kt:463)");
            }
            SpacerKt.Spacer(SizeKt.m1769size3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(20)), composer, 6);
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
    public static final ua.k0 lambda__315878643$lambda$0(LazyItemScope item, Composer composer, int i10) {
        kotlin.jvm.internal.y.i(item, "$this$item");
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-315878643, i10, -1, "cu.todus.android.uiCompose.main.screen.privacy.ComposableSingletons$PrivacyScreenKt.lambda$-315878643.<anonymous> (PrivacyScreen.kt:481)");
            }
            SpacerKt.Spacer(SizeKt.m1769size3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(20)), composer, 6);
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
    public static final ua.k0 lambda__421551034$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-421551034, i10, -1, "cu.todus.android.uiCompose.main.screen.privacy.ComposableSingletons$PrivacyScreenKt.lambda$-421551034.<anonymous> (PrivacyScreen.kt:340)");
            }
            Z17PictureKt.m10278Z17BasePictureC8z9wKI(SizeKt.m1769size3ABfNKs(PaddingKt.m1725padding3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(3)), Dp.m8823constructorimpl(35)), RefreshKt.getRefresh(Icons.Outlined.INSTANCE), null, ColorFilter.Companion.m5907tintxETnrds$default(ColorFilter.INSTANCE, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOnBackground(), 0, 2, null), null, null, 0, null, null, composer, 6, XMPPTCPConnection.PacketWriter.QUEUE_SIZE);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: renamed from: getLambda$-1826065194$app_productionPFast, reason: not valid java name */
    public final Function3 m9949getLambda$1826065194$app_productionPFast() {
        return f236lambda$1826065194;
    }

    /* JADX INFO: renamed from: getLambda$-315878643$app_productionPFast, reason: not valid java name */
    public final Function3 m9950getLambda$315878643$app_productionPFast() {
        return f237lambda$315878643;
    }

    /* JADX INFO: renamed from: getLambda$-421551034$app_productionPFast, reason: not valid java name */
    public final Function2 m9951getLambda$421551034$app_productionPFast() {
        return f238lambda$421551034;
    }

    public final Function2 getLambda$1419631669$app_productionPFast() {
        return lambda$1419631669;
    }

    public final Function2 getLambda$342309648$app_productionPFast() {
        return lambda$342309648;
    }
}
