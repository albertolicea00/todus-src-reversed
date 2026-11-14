package cu.z17.views.imageEditor.sections.viewer;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.outlined.CropKt;
import androidx.compose.material.icons.outlined.Rotate90DegreesCwKt;
import androidx.compose.material.icons.outlined.TextFieldsKt;
import androidx.compose.material.icons.outlined.UndoKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.unit.Dp;
import cu.z17.views.R;
import cu.z17.views.imageEditor.sections.viewer.ComposableSingletons$ViewerTopBarKt;
import cu.z17.views.picture.Z17PictureKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$ViewerTopBarKt {
    public static final ComposableSingletons$ViewerTopBarKt INSTANCE = new ComposableSingletons$ViewerTopBarKt();

    /* JADX INFO: renamed from: lambda$-1213123548, reason: not valid java name */
    private static Function2 f381lambda$1213123548 = ComposableLambdaKt.composableLambdaInstance(-1213123548, false, new Function2() { // from class: k9.a
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$ViewerTopBarKt.lambda__1213123548$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2 lambda$372825563 = ComposableLambdaKt.composableLambdaInstance(372825563, false, new Function2() { // from class: k9.b
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$ViewerTopBarKt.lambda_372825563$lambda$1((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-1709725796, reason: not valid java name */
    private static Function2 f383lambda$1709725796 = ComposableLambdaKt.composableLambdaInstance(-1709725796, false, new Function2() { // from class: k9.c
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$ViewerTopBarKt.lambda__1709725796$lambda$2((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2 lambda$502690141 = ComposableLambdaKt.composableLambdaInstance(502690141, false, new Function2() { // from class: k9.d
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$ViewerTopBarKt.lambda_502690141$lambda$3((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-1579861218, reason: not valid java name */
    private static Function2 f382lambda$1579861218 = ComposableLambdaKt.composableLambdaInstance(-1579861218, false, new Function2() { // from class: k9.e
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$ViewerTopBarKt.lambda__1579861218$lambda$4((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 lambda_372825563$lambda$1(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(372825563, i10, -1, "cu.z17.views.imageEditor.sections.viewer.ComposableSingletons$ViewerTopBarKt.lambda$372825563.<anonymous> (ViewerTopBar.kt:81)");
            }
            Z17PictureKt.m10278Z17BasePictureC8z9wKI(SizeKt.m1769size3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(25)), TextFieldsKt.getTextFields(Icons.Outlined.INSTANCE), null, ColorFilter.Companion.m5907tintxETnrds$default(ColorFilter.INSTANCE, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOnBackground(), 0, 2, null), null, null, 0, null, null, composer, 6, XMPPTCPConnection.PacketWriter.QUEUE_SIZE);
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
    public static final k0 lambda_502690141$lambda$3(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(502690141, i10, -1, "cu.z17.views.imageEditor.sections.viewer.ComposableSingletons$ViewerTopBarKt.lambda$502690141.<anonymous> (ViewerTopBar.kt:122)");
            }
            Z17PictureKt.m10278Z17BasePictureC8z9wKI(SizeKt.m1769size3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(25)), CropKt.getCrop(Icons.Outlined.INSTANCE), null, ColorFilter.Companion.m5907tintxETnrds$default(ColorFilter.INSTANCE, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOnBackground(), 0, 2, null), null, null, 0, null, null, composer, 6, XMPPTCPConnection.PacketWriter.QUEUE_SIZE);
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
    public static final k0 lambda__1213123548$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1213123548, i10, -1, "cu.z17.views.imageEditor.sections.viewer.ComposableSingletons$ViewerTopBarKt.lambda$-1213123548.<anonymous> (ViewerTopBar.kt:61)");
            }
            Z17PictureKt.m10278Z17BasePictureC8z9wKI(SizeKt.m1769size3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(25)), UndoKt.getUndo(Icons.Outlined.INSTANCE), null, ColorFilter.Companion.m5907tintxETnrds$default(ColorFilter.INSTANCE, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOnBackground(), 0, 2, null), null, null, 0, null, null, composer, 6, XMPPTCPConnection.PacketWriter.QUEUE_SIZE);
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
    public static final k0 lambda__1579861218$lambda$4(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1579861218, i10, -1, "cu.z17.views.imageEditor.sections.viewer.ComposableSingletons$ViewerTopBarKt.lambda$-1579861218.<anonymous> (ViewerTopBar.kt:142)");
            }
            Z17PictureKt.m10278Z17BasePictureC8z9wKI(SizeKt.m1769size3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(25)), Rotate90DegreesCwKt.getRotate90DegreesCw(Icons.Outlined.INSTANCE), null, ColorFilter.Companion.m5907tintxETnrds$default(ColorFilter.INSTANCE, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOnBackground(), 0, 2, null), null, null, 0, null, null, composer, 6, XMPPTCPConnection.PacketWriter.QUEUE_SIZE);
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
    public static final k0 lambda__1709725796$lambda$2(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1709725796, i10, -1, "cu.z17.views.imageEditor.sections.viewer.ComposableSingletons$ViewerTopBarKt.lambda$-1709725796.<anonymous> (ViewerTopBar.kt:101)");
            }
            Z17PictureKt.m10278Z17BasePictureC8z9wKI(SizeKt.m1769size3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(25)), Integer.valueOf(R.drawable.filter), null, ColorFilter.Companion.m5907tintxETnrds$default(ColorFilter.INSTANCE, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOnBackground(), 0, 2, null), null, null, 0, null, null, composer, 6, XMPPTCPConnection.PacketWriter.QUEUE_SIZE);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: renamed from: getLambda$-1213123548$views_release, reason: not valid java name */
    public final Function2 m10248getLambda$1213123548$views_release() {
        return f381lambda$1213123548;
    }

    /* JADX INFO: renamed from: getLambda$-1579861218$views_release, reason: not valid java name */
    public final Function2 m10249getLambda$1579861218$views_release() {
        return f382lambda$1579861218;
    }

    /* JADX INFO: renamed from: getLambda$-1709725796$views_release, reason: not valid java name */
    public final Function2 m10250getLambda$1709725796$views_release() {
        return f383lambda$1709725796;
    }

    public final Function2 getLambda$372825563$views_release() {
        return lambda$372825563;
    }

    public final Function2 getLambda$502690141$views_release() {
        return lambda$502690141;
    }
}
