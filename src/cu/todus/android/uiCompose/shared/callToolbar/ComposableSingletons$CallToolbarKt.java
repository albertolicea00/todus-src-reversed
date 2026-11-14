package cu.todus.android.uiCompose.shared.callToolbar;

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
import cu.todus.android.R;
import cu.z17.views.picture.Z17PictureKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.y;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
public final class ComposableSingletons$CallToolbarKt {
    public static final ComposableSingletons$CallToolbarKt INSTANCE = new ComposableSingletons$CallToolbarKt();
    private static Function3 lambda$2136723829 = ComposableLambdaKt.composableLambdaInstance(2136723829, false, new Function3() { // from class: cu.todus.android.uiCompose.shared.callToolbar.s
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$CallToolbarKt.lambda_2136723829$lambda$0((Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });
    private static Function2 lambda$13791996 = ComposableLambdaKt.composableLambdaInstance(13791996, false, new Function2() { // from class: cu.todus.android.uiCompose.shared.callToolbar.t
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$CallToolbarKt.lambda_13791996$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2 lambda$1121261669 = ComposableLambdaKt.composableLambdaInstance(1121261669, false, new Function2() { // from class: cu.todus.android.uiCompose.shared.callToolbar.u
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$CallToolbarKt.lambda_1121261669$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-294605695, reason: not valid java name */
    private static Function2 f357lambda$294605695 = ComposableLambdaKt.composableLambdaInstance(-294605695, false, new Function2() { // from class: cu.todus.android.uiCompose.shared.callToolbar.v
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$CallToolbarKt.lambda__294605695$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-1604345224, reason: not valid java name */
    private static Function2 f356lambda$1604345224 = ComposableLambdaKt.composableLambdaInstance(-1604345224, false, new Function2() { // from class: cu.todus.android.uiCompose.shared.callToolbar.w
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$CallToolbarKt.lambda__1604345224$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 lambda_1121261669$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1121261669, i10, -1, "cu.todus.android.uiCompose.shared.callToolbar.ComposableSingletons$CallToolbarKt.lambda$1121261669.<anonymous> (CallToolbar.kt:274)");
            }
            Z17PictureKt.m10278Z17BasePictureC8z9wKI(SizeKt.m1769size3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(24)), Integer.valueOf(R.drawable.call_start), null, ColorFilter.Companion.m5907tintxETnrds$default(ColorFilter.INSTANCE, Color.INSTANCE.m5903getWhite0d7_KjU(), 0, 2, null), null, null, 0, null, null, composer, 3078, XMPPTCPConnection.PacketWriter.QUEUE_SIZE);
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
    public static final k0 lambda_13791996$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(13791996, i10, -1, "cu.todus.android.uiCompose.shared.callToolbar.ComposableSingletons$CallToolbarKt.lambda$13791996.<anonymous> (CallToolbar.kt:261)");
            }
            Z17PictureKt.m10278Z17BasePictureC8z9wKI(SizeKt.m1769size3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(20)), Integer.valueOf(R.drawable.call_end), null, ColorFilter.Companion.m5907tintxETnrds$default(ColorFilter.INSTANCE, Color.INSTANCE.m5903getWhite0d7_KjU(), 0, 2, null), null, null, 0, null, null, composer, 3078, XMPPTCPConnection.PacketWriter.QUEUE_SIZE);
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
    public static final k0 lambda_2136723829$lambda$0(Modifier it, Composer composer, int i10) {
        y.i(it, "it");
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2136723829, i10, -1, "cu.todus.android.uiCompose.shared.callToolbar.ComposableSingletons$CallToolbarKt.lambda$2136723829.<anonymous> (CallToolbar.kt:197)");
            }
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
    public static final k0 lambda__1604345224$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1604345224, i10, -1, "cu.todus.android.uiCompose.shared.callToolbar.ComposableSingletons$CallToolbarKt.lambda$-1604345224.<anonymous> (CallToolbar.kt:338)");
            }
            Z17PictureKt.m10278Z17BasePictureC8z9wKI(SizeKt.m1769size3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(24)), Integer.valueOf(R.drawable.call_start), null, ColorFilter.Companion.m5907tintxETnrds$default(ColorFilter.INSTANCE, Color.INSTANCE.m5903getWhite0d7_KjU(), 0, 2, null), null, null, 0, null, null, composer, 3078, XMPPTCPConnection.PacketWriter.QUEUE_SIZE);
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
    public static final k0 lambda__294605695$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-294605695, i10, -1, "cu.todus.android.uiCompose.shared.callToolbar.ComposableSingletons$CallToolbarKt.lambda$-294605695.<anonymous> (CallToolbar.kt:325)");
            }
            Z17PictureKt.m10278Z17BasePictureC8z9wKI(SizeKt.m1769size3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(20)), Integer.valueOf(R.drawable.call_end), null, ColorFilter.Companion.m5907tintxETnrds$default(ColorFilter.INSTANCE, Color.INSTANCE.m5903getWhite0d7_KjU(), 0, 2, null), null, null, 0, null, null, composer, 3078, XMPPTCPConnection.PacketWriter.QUEUE_SIZE);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: renamed from: getLambda$-1604345224$app_productionPFast, reason: not valid java name */
    public final Function2 m10079getLambda$1604345224$app_productionPFast() {
        return f356lambda$1604345224;
    }

    /* JADX INFO: renamed from: getLambda$-294605695$app_productionPFast, reason: not valid java name */
    public final Function2 m10080getLambda$294605695$app_productionPFast() {
        return f357lambda$294605695;
    }

    public final Function2 getLambda$1121261669$app_productionPFast() {
        return lambda$1121261669;
    }

    public final Function2 getLambda$13791996$app_productionPFast() {
        return lambda$13791996;
    }

    public final Function3 getLambda$2136723829$app_productionPFast() {
        return lambda$2136723829;
    }
}
