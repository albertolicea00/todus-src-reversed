package cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.outlined.CheckKt;
import androidx.compose.material.icons.outlined.CloseKt;
import androidx.compose.material.icons.outlined.NotificationsNoneKt;
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
import cu.z17.views.R;
import cu.z17.views.button.Z17ButtonsKt;
import cu.z17.views.picture.Z17PictureKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
public final class ComposableSingletons$PreviewGroupScreenKt {
    public static final ComposableSingletons$PreviewGroupScreenKt INSTANCE = new ComposableSingletons$PreviewGroupScreenKt();
    private static Function2 lambda$1490944705 = ComposableLambdaKt.composableLambdaInstance(1490944705, false, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.a
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$PreviewGroupScreenKt.lambda_1490944705$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2 lambda$670657214 = ComposableLambdaKt.composableLambdaInstance(670657214, false, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.b
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$PreviewGroupScreenKt.lambda_670657214$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function3 lambda$1914186243 = ComposableLambdaKt.composableLambdaInstance(1914186243, false, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.c
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$PreviewGroupScreenKt.lambda_1914186243$lambda$0((lb.a) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });
    private static Function2 lambda$735879078 = ComposableLambdaKt.composableLambdaInstance(735879078, false, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.d
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$PreviewGroupScreenKt.lambda_735879078$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-1878924412, reason: not valid java name */
    private static Function2 f210lambda$1878924412 = ComposableLambdaKt.composableLambdaInstance(-1878924412, false, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.e
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$PreviewGroupScreenKt.lambda__1878924412$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-1686499347, reason: not valid java name */
    private static Function2 f209lambda$1686499347 = ComposableLambdaKt.composableLambdaInstance(-1686499347, false, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.f
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$PreviewGroupScreenKt.lambda__1686499347$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 lambda_1490944705$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1490944705, i10, -1, "cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.ComposableSingletons$PreviewGroupScreenKt.lambda$1490944705.<anonymous> (PreviewGroupScreen.kt:394)");
            }
            Z17PictureKt.m10278Z17BasePictureC8z9wKI(SizeKt.m1769size3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(25)), CheckKt.getCheck(Icons.Outlined.INSTANCE), null, ColorFilter.Companion.m5907tintxETnrds$default(ColorFilter.INSTANCE, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getBackground(), 0, 2, null), null, "complete action btn", 0, null, null, composer, 196614, 468);
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
    public static final ua.k0 lambda_1914186243$lambda$0(final lb.a onSubmit, Composer composer, int i10) {
        kotlin.jvm.internal.y.i(onSubmit, "onSubmit");
        if ((i10 & 6) == 0) {
            i10 |= composer.changedInstance(onSubmit) ? 4 : 2;
        }
        if (composer.shouldExecute((i10 & 19) != 18, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1914186243, i10, -1, "cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.ComposableSingletons$PreviewGroupScreenKt.lambda$1914186243.<anonymous> (PreviewGroupScreen.kt:444)");
            }
            boolean z10 = (i10 & 14) == 4;
            Object objRememberedValue = composer.rememberedValue();
            if (z10 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.g
                    @Override // lb.a
                    public final Object invoke() {
                        return ComposableSingletons$PreviewGroupScreenKt.lambda_1914186243$lambda$0$0$0(onSubmit);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            Z17ButtonsKt.Z17PrimaryButton(null, (lb.a) objRememberedValue, StringResources_androidKt.stringResource(R.string.submit, composer, 0), null, true, false, composer, 24576, 41);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 lambda_1914186243$lambda$0$0$0(lb.a aVar) {
        aVar.invoke();
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 lambda_670657214$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(670657214, i10, -1, "cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.ComposableSingletons$PreviewGroupScreenKt.lambda$670657214.<anonymous> (PreviewGroupScreen.kt:431)");
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
    public static final ua.k0 lambda_735879078$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(735879078, i10, -1, "cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.ComposableSingletons$PreviewGroupScreenKt.lambda$735879078.<anonymous> (PreviewGroupScreen.kt:715)");
            }
            Z17PictureKt.m10278Z17BasePictureC8z9wKI(SizeKt.m1769size3ABfNKs(PaddingKt.m1725padding3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(20)), Dp.m8823constructorimpl(24)), NotificationsNoneKt.getNotificationsNone(Icons.Outlined.INSTANCE), null, ColorFilter.Companion.m5907tintxETnrds$default(ColorFilter.INSTANCE, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOnBackground(), 0, 2, null), null, null, 0, null, null, composer, 6, XMPPTCPConnection.PacketWriter.QUEUE_SIZE);
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
    public static final ua.k0 lambda__1686499347$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1686499347, i10, -1, "cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.ComposableSingletons$PreviewGroupScreenKt.lambda$-1686499347.<anonymous> (PreviewGroupScreen.kt:1020)");
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
    public static final ua.k0 lambda__1878924412$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1878924412, i10, -1, "cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.ComposableSingletons$PreviewGroupScreenKt.lambda$-1878924412.<anonymous> (PreviewGroupScreen.kt:995)");
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: renamed from: getLambda$-1686499347$app_productionPFast, reason: not valid java name */
    public final Function2 m9916getLambda$1686499347$app_productionPFast() {
        return f209lambda$1686499347;
    }

    /* JADX INFO: renamed from: getLambda$-1878924412$app_productionPFast, reason: not valid java name */
    public final Function2 m9917getLambda$1878924412$app_productionPFast() {
        return f210lambda$1878924412;
    }

    public final Function2 getLambda$1490944705$app_productionPFast() {
        return lambda$1490944705;
    }

    public final Function3 getLambda$1914186243$app_productionPFast() {
        return lambda$1914186243;
    }

    public final Function2 getLambda$670657214$app_productionPFast() {
        return lambda$670657214;
    }

    public final Function2 getLambda$735879078$app_productionPFast() {
        return lambda$735879078;
    }
}
