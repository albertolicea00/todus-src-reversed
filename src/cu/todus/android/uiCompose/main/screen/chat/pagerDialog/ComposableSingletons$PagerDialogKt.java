package cu.todus.android.uiCompose.main.screen.chat.pagerDialog;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.outlined.ArrowBackKt;
import androidx.compose.material.icons.outlined.ArrowForwardKt;
import androidx.compose.material.icons.outlined.CloseKt;
import androidx.compose.material.icons.outlined.ContactsKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import cu.z17.views.picture.Z17PictureKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
public final class ComposableSingletons$PagerDialogKt {
    public static final ComposableSingletons$PagerDialogKt INSTANCE = new ComposableSingletons$PagerDialogKt();

    /* JADX INFO: renamed from: lambda$-1294825587, reason: not valid java name */
    private static Function2 f197lambda$1294825587 = ComposableLambdaKt.composableLambdaInstance(-1294825587, false, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.pagerDialog.a
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$PagerDialogKt.lambda__1294825587$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-492641465, reason: not valid java name */
    private static Function2 f198lambda$492641465 = ComposableLambdaKt.composableLambdaInstance(-492641465, false, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.pagerDialog.b
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$PagerDialogKt.lambda__492641465$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-90254850, reason: not valid java name */
    private static Function2 f200lambda$90254850 = ComposableLambdaKt.composableLambdaInstance(-90254850, false, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.pagerDialog.c
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$PagerDialogKt.lambda__90254850$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-813633095, reason: not valid java name */
    private static Function2 f199lambda$813633095 = ComposableLambdaKt.composableLambdaInstance(-813633095, false, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.pagerDialog.d
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$PagerDialogKt.lambda__813633095$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 lambda__1294825587$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1294825587, i10, -1, "cu.todus.android.uiCompose.main.screen.chat.pagerDialog.ComposableSingletons$PagerDialogKt.lambda$-1294825587.<anonymous> (PagerDialog.kt:143)");
            }
            IconKt.m3298Iconww6aTOc(CloseKt.getClose(Icons.Outlined.INSTANCE), "", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOnBackground(), composer, 48, 4);
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
    public static final k0 lambda__492641465$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-492641465, i10, -1, "cu.todus.android.uiCompose.main.screen.chat.pagerDialog.ComposableSingletons$PagerDialogKt.lambda$-492641465.<anonymous> (PagerDialog.kt:183)");
            }
            Z17PictureKt.m10278Z17BasePictureC8z9wKI(SizeKt.m1769size3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(20)), ArrowBackKt.getArrowBack(Icons.Outlined.INSTANCE), null, null, null, null, 0, null, null, composer, 6, TypedValues.PositionType.TYPE_CURVE_FIT);
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
    public static final k0 lambda__813633095$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-813633095, i10, -1, "cu.todus.android.uiCompose.main.screen.chat.pagerDialog.ComposableSingletons$PagerDialogKt.lambda$-813633095.<anonymous> (PagerDialog.kt:260)");
            }
            Z17PictureKt.m10278Z17BasePictureC8z9wKI(SizeKt.m1769size3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(24)), ContactsKt.getContacts(Icons.Outlined.INSTANCE), null, null, null, null, 0, null, null, composer, 6, TypedValues.PositionType.TYPE_CURVE_FIT);
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
    public static final k0 lambda__90254850$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-90254850, i10, -1, "cu.todus.android.uiCompose.main.screen.chat.pagerDialog.ComposableSingletons$PagerDialogKt.lambda$-90254850.<anonymous> (PagerDialog.kt:200)");
            }
            Z17PictureKt.m10278Z17BasePictureC8z9wKI(SizeKt.m1769size3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(20)), ArrowForwardKt.getArrowForward(Icons.Outlined.INSTANCE), null, null, null, null, 0, null, null, composer, 6, TypedValues.PositionType.TYPE_CURVE_FIT);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: renamed from: getLambda$-1294825587$app_productionPFast, reason: not valid java name */
    public final Function2 m9898getLambda$1294825587$app_productionPFast() {
        return f197lambda$1294825587;
    }

    /* JADX INFO: renamed from: getLambda$-492641465$app_productionPFast, reason: not valid java name */
    public final Function2 m9899getLambda$492641465$app_productionPFast() {
        return f198lambda$492641465;
    }

    /* JADX INFO: renamed from: getLambda$-813633095$app_productionPFast, reason: not valid java name */
    public final Function2 m9900getLambda$813633095$app_productionPFast() {
        return f199lambda$813633095;
    }

    /* JADX INFO: renamed from: getLambda$-90254850$app_productionPFast, reason: not valid java name */
    public final Function2 m9901getLambda$90254850$app_productionPFast() {
        return f200lambda$90254850;
    }
}
