package cu.todus.android.uiCompose.main.screen.statusEditor.pages.textEditor;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import cu.todus.android.R;
import cu.todus.android.uiCompose.main.screen.statusEditor.pages.textEditor.ComposableSingletons$TextEditorKt;
import cu.z17.views.picture.Z17PictureKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
public final class ComposableSingletons$TextEditorKt {
    public static final ComposableSingletons$TextEditorKt INSTANCE = new ComposableSingletons$TextEditorKt();

    /* JADX INFO: renamed from: lambda$-1516086273, reason: not valid java name */
    private static Function2 f270lambda$1516086273 = ComposableLambdaKt.composableLambdaInstance(-1516086273, false, new Function2() { // from class: h8.a
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$TextEditorKt.lambda__1516086273$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2 lambda$824330792 = ComposableLambdaKt.composableLambdaInstance(824330792, false, new Function2() { // from class: h8.b
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$TextEditorKt.lambda_824330792$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-1673186041, reason: not valid java name */
    private static Function2 f271lambda$1673186041 = ComposableLambdaKt.composableLambdaInstance(-1673186041, false, new Function2() { // from class: h8.c
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$TextEditorKt.lambda__1673186041$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2 lambda$1247733699 = ComposableLambdaKt.composableLambdaInstance(1247733699, false, new Function2() { // from class: h8.d
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$TextEditorKt.lambda_1247733699$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 lambda_1247733699$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1247733699, i10, -1, "cu.todus.android.uiCompose.main.screen.statusEditor.pages.textEditor.ComposableSingletons$TextEditorKt.lambda$1247733699.<anonymous> (TextEditor.kt:174)");
            }
            Z17PictureKt.m10278Z17BasePictureC8z9wKI(SizeKt.m1769size3ABfNKs(PaddingKt.m1725padding3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(3)), Dp.m8823constructorimpl(35)), Integer.valueOf(R.drawable.send_icon), null, ColorFilter.Companion.m5907tintxETnrds$default(ColorFilter.INSTANCE, Color.m5865copywmQWz5c$default(Color.INSTANCE.m5903getWhite0d7_KjU(), 0.8f, 0.0f, 0.0f, 0.0f, 14, null), 0, 2, null), null, null, 0, null, null, composer, 3078, XMPPTCPConnection.PacketWriter.QUEUE_SIZE);
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
    public static final k0 lambda_824330792$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(824330792, i10, -1, "cu.todus.android.uiCompose.main.screen.statusEditor.pages.textEditor.ComposableSingletons$TextEditorKt.lambda$824330792.<anonymous> (TextEditor.kt:130)");
            }
            Z17PictureKt.m10278Z17BasePictureC8z9wKI(SizeKt.m1769size3ABfNKs(PaddingKt.m1725padding3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(3)), Dp.m8823constructorimpl(25)), Integer.valueOf(R.drawable.font_selector), null, null, null, null, 0, null, null, composer, 6, TypedValues.PositionType.TYPE_CURVE_FIT);
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
    public static final k0 lambda__1516086273$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1516086273, i10, -1, "cu.todus.android.uiCompose.main.screen.statusEditor.pages.textEditor.ComposableSingletons$TextEditorKt.lambda$-1516086273.<anonymous> (TextEditor.kt:108)");
            }
            Z17PictureKt.m10278Z17BasePictureC8z9wKI(SizeKt.m1769size3ABfNKs(PaddingKt.m1725padding3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(3)), Dp.m8823constructorimpl(25)), Integer.valueOf(R.drawable.color_selector), null, null, null, null, 0, null, null, composer, 6, TypedValues.PositionType.TYPE_CURVE_FIT);
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
    public static final k0 lambda__1673186041$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1673186041, i10, -1, "cu.todus.android.uiCompose.main.screen.statusEditor.pages.textEditor.ComposableSingletons$TextEditorKt.lambda$-1673186041.<anonymous> (TextEditor.kt:152)");
            }
            Z17PictureKt.m10278Z17BasePictureC8z9wKI(SizeKt.m1769size3ABfNKs(PaddingKt.m1725padding3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(3)), Dp.m8823constructorimpl(25)), Integer.valueOf(R.drawable.font_color_selector), null, null, null, null, 0, null, null, composer, 6, TypedValues.PositionType.TYPE_CURVE_FIT);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: renamed from: getLambda$-1516086273$app_productionPFast, reason: not valid java name */
    public final Function2 m9988getLambda$1516086273$app_productionPFast() {
        return f270lambda$1516086273;
    }

    /* JADX INFO: renamed from: getLambda$-1673186041$app_productionPFast, reason: not valid java name */
    public final Function2 m9989getLambda$1673186041$app_productionPFast() {
        return f271lambda$1673186041;
    }

    public final Function2 getLambda$1247733699$app_productionPFast() {
        return lambda$1247733699;
    }

    public final Function2 getLambda$824330792$app_productionPFast() {
        return lambda$824330792;
    }
}
