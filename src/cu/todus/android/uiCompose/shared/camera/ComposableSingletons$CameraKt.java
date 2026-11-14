package cu.todus.android.uiCompose.shared.camera;

import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.outlined.CheckKt;
import androidx.compose.material.icons.outlined.CloseKt;
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
public final class ComposableSingletons$CameraKt {
    public static final ComposableSingletons$CameraKt INSTANCE = new ComposableSingletons$CameraKt();
    private static Function2 lambda$1719014175 = ComposableLambdaKt.composableLambdaInstance(1719014175, false, new Function2() { // from class: cu.todus.android.uiCompose.shared.camera.f1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$CameraKt.lambda_1719014175$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-499839851, reason: not valid java name */
    private static Function3 f361lambda$499839851 = ComposableLambdaKt.composableLambdaInstance(-499839851, false, new Function3() { // from class: cu.todus.android.uiCompose.shared.camera.g1
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$CameraKt.lambda__499839851$lambda$0((AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-1772970275, reason: not valid java name */
    private static Function3 f358lambda$1772970275 = ComposableLambdaKt.composableLambdaInstance(-1772970275, false, new Function3() { // from class: cu.todus.android.uiCompose.shared.camera.h1
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$CameraKt.lambda__1772970275$lambda$0((AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-261707810, reason: not valid java name */
    private static Function2 f359lambda$261707810 = ComposableLambdaKt.composableLambdaInstance(-261707810, false, new Function2() { // from class: cu.todus.android.uiCompose.shared.camera.i1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$CameraKt.lambda__261707810$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-3494998, reason: not valid java name */
    private static Function2 f360lambda$3494998 = ComposableLambdaKt.composableLambdaInstance(-3494998, false, new Function2() { // from class: cu.todus.android.uiCompose.shared.camera.j1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$CameraKt.lambda__3494998$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 lambda_1719014175$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1719014175, i10, -1, "cu.todus.android.uiCompose.shared.camera.ComposableSingletons$CameraKt.lambda$1719014175.<anonymous> (Camera.kt:164)");
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
    public static final ua.k0 lambda__1772970275$lambda$0(AnimatedVisibilityScope AnimatedVisibility, Composer composer, int i10) {
        kotlin.jvm.internal.y.i(AnimatedVisibility, "$this$AnimatedVisibility");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1772970275, i10, -1, "cu.todus.android.uiCompose.shared.camera.ComposableSingletons$CameraKt.lambda$-1772970275.<anonymous> (Camera.kt:676)");
        }
        Modifier.Companion companion = Modifier.INSTANCE;
        MaterialTheme materialTheme = MaterialTheme.INSTANCE;
        int i11 = MaterialTheme.$stable;
        Z17LabelKt.m10262Z17LabelfWhpE4E(PaddingKt.m1725padding3ABfNKs(BackgroundKt.m1205backgroundbw27NRU$default(companion, materialTheme.getColorScheme(composer, i11).getBackground(), null, 2, null), Dp.m8823constructorimpl(10)), StringResources_androidKt.stringResource(R.string.video, composer, 0), null, materialTheme.getColorScheme(composer, i11).getBackground(), 0, 0, composer, 0, 52);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 lambda__261707810$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-261707810, i10, -1, "cu.todus.android.uiCompose.shared.camera.ComposableSingletons$CameraKt.lambda$-261707810.<anonymous> (Camera.kt:770)");
            }
            Z17PictureKt.m10278Z17BasePictureC8z9wKI(SizeKt.m1769size3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(24)), CheckKt.getCheck(Icons.Outlined.INSTANCE), null, ColorFilter.Companion.m5907tintxETnrds$default(ColorFilter.INSTANCE, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOnBackground(), 0, 2, null), null, null, 0, null, null, composer, 6, XMPPTCPConnection.PacketWriter.QUEUE_SIZE);
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
    public static final ua.k0 lambda__3494998$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-3494998, i10, -1, "cu.todus.android.uiCompose.shared.camera.ComposableSingletons$CameraKt.lambda$-3494998.<anonymous> (Camera.kt:866)");
            }
            Z17PictureKt.m10278Z17BasePictureC8z9wKI(SizeKt.m1769size3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(24)), CheckKt.getCheck(Icons.Outlined.INSTANCE), null, ColorFilter.Companion.m5907tintxETnrds$default(ColorFilter.INSTANCE, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOnBackground(), 0, 2, null), null, null, 0, null, null, composer, 6, XMPPTCPConnection.PacketWriter.QUEUE_SIZE);
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
    public static final ua.k0 lambda__499839851$lambda$0(AnimatedVisibilityScope AnimatedVisibility, Composer composer, int i10) {
        kotlin.jvm.internal.y.i(AnimatedVisibility, "$this$AnimatedVisibility");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-499839851, i10, -1, "cu.todus.android.uiCompose.shared.camera.ComposableSingletons$CameraKt.lambda$-499839851.<anonymous> (Camera.kt:631)");
        }
        Modifier.Companion companion = Modifier.INSTANCE;
        MaterialTheme materialTheme = MaterialTheme.INSTANCE;
        int i11 = MaterialTheme.$stable;
        Z17LabelKt.m10262Z17LabelfWhpE4E(PaddingKt.m1725padding3ABfNKs(BackgroundKt.m1205backgroundbw27NRU$default(companion, materialTheme.getColorScheme(composer, i11).getBackground(), null, 2, null), Dp.m8823constructorimpl(10)), StringResources_androidKt.stringResource(R.string.camera, composer, 0), null, materialTheme.getColorScheme(composer, i11).getBackground(), 0, 0, composer, 0, 52);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: renamed from: getLambda$-1772970275$app_productionPFast, reason: not valid java name */
    public final Function3 m10081getLambda$1772970275$app_productionPFast() {
        return f358lambda$1772970275;
    }

    /* JADX INFO: renamed from: getLambda$-261707810$app_productionPFast, reason: not valid java name */
    public final Function2 m10082getLambda$261707810$app_productionPFast() {
        return f359lambda$261707810;
    }

    /* JADX INFO: renamed from: getLambda$-3494998$app_productionPFast, reason: not valid java name */
    public final Function2 m10083getLambda$3494998$app_productionPFast() {
        return f360lambda$3494998;
    }

    /* JADX INFO: renamed from: getLambda$-499839851$app_productionPFast, reason: not valid java name */
    public final Function3 m10084getLambda$499839851$app_productionPFast() {
        return f361lambda$499839851;
    }

    public final Function2 getLambda$1719014175$app_productionPFast() {
        return lambda$1719014175;
    }
}
