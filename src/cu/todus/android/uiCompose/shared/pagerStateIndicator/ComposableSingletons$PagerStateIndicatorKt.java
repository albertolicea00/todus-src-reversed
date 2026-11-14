package cu.todus.android.uiCompose.shared.pagerStateIndicator;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.outlined.RefreshKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.unit.Dp;
import cu.todus.android.uiCompose.shared.pagerStateIndicator.ComposableSingletons$PagerStateIndicatorKt;
import cu.z17.views.picture.Z17PictureKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.y;
import lb.a;
import lb.o;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
public final class ComposableSingletons$PagerStateIndicatorKt {
    public static final ComposableSingletons$PagerStateIndicatorKt INSTANCE = new ComposableSingletons$PagerStateIndicatorKt();
    private static Function3 lambda$1043743468 = ComposableLambdaKt.composableLambdaInstance(1043743468, false, new Function3() { // from class: t8.a
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$PagerStateIndicatorKt.lambda_1043743468$lambda$0((Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-2139246109, reason: not valid java name */
    private static o f364lambda$2139246109 = ComposableLambdaKt.composableLambdaInstance(-2139246109, false, new o() { // from class: t8.b
        @Override // lb.o
        public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
            return ComposableSingletons$PagerStateIndicatorKt.lambda__2139246109$lambda$0((Modifier) obj, (lb.a) obj2, (Composer) obj3, ((Integer) obj4).intValue());
        }
    });
    private static Function3 lambda$1044445317 = ComposableLambdaKt.composableLambdaInstance(1044445317, false, new Function3() { // from class: t8.c
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$PagerStateIndicatorKt.lambda_1044445317$lambda$0((Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-1208785958, reason: not valid java name */
    private static Function3 f363lambda$1208785958 = ComposableLambdaKt.composableLambdaInstance(-1208785958, false, new Function3() { // from class: t8.d
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$PagerStateIndicatorKt.lambda__1208785958$lambda$0((Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });
    private static Function2 lambda$529467836 = ComposableLambdaKt.composableLambdaInstance(529467836, false, new Function2() { // from class: t8.e
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$PagerStateIndicatorKt.lambda_529467836$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 lambda_1043743468$lambda$0(Modifier it, Composer composer, int i10) {
        y.i(it, "it");
        if ((i10 & 6) == 0) {
            i10 |= composer.changed(it) ? 4 : 2;
        }
        if (composer.shouldExecute((i10 & 19) != 18, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1043743468, i10, -1, "cu.todus.android.uiCompose.shared.pagerStateIndicator.ComposableSingletons$PagerStateIndicatorKt.lambda$1043743468.<anonymous> (PagerStateIndicator.kt:36)");
            }
            PagerStateIndicatorKt.PageLoaderDefault(it, composer, i10 & 14, 0);
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
    public static final k0 lambda_1044445317$lambda$0(Modifier it, Composer composer, int i10) {
        y.i(it, "it");
        if ((i10 & 6) == 0) {
            i10 |= composer.changed(it) ? 4 : 2;
        }
        if (composer.shouldExecute((i10 & 19) != 18, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1044445317, i10, -1, "cu.todus.android.uiCompose.shared.pagerStateIndicator.ComposableSingletons$PagerStateIndicatorKt.lambda$1044445317.<anonymous> (PagerStateIndicator.kt:40)");
            }
            PagerStateIndicatorKt.LoadingNextPageItemDefault(it, composer, i10 & 14);
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
    public static final k0 lambda_529467836$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(529467836, i10, -1, "cu.todus.android.uiCompose.shared.pagerStateIndicator.ComposableSingletons$PagerStateIndicatorKt.lambda$529467836.<anonymous> (PagerStateIndicator.kt:130)");
            }
            Z17PictureKt.m10278Z17BasePictureC8z9wKI(SizeKt.m1769size3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(24)), RefreshKt.getRefresh(Icons.Outlined.INSTANCE), null, ColorFilter.Companion.m5907tintxETnrds$default(ColorFilter.INSTANCE, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getPrimary(), 0, 2, null), null, null, 0, null, null, composer, 6, XMPPTCPConnection.PacketWriter.QUEUE_SIZE);
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
    public static final k0 lambda__1208785958$lambda$0(Modifier it, Composer composer, int i10) {
        y.i(it, "it");
        if ((i10 & 6) == 0) {
            i10 |= composer.changed(it) ? 4 : 2;
        }
        if (composer.shouldExecute((i10 & 19) != 18, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1208785958, i10, -1, "cu.todus.android.uiCompose.shared.pagerStateIndicator.ComposableSingletons$PagerStateIndicatorKt.lambda$-1208785958.<anonymous> (PagerStateIndicator.kt:41)");
            }
            PagerStateIndicatorKt.EmptyStateDefault(it, composer, i10 & 14, 0);
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
    public static final k0 lambda__2139246109$lambda$0(Modifier m10, a r10, Composer composer, int i10) {
        int i11;
        y.i(m10, "m");
        y.i(r10, "r");
        if ((i10 & 6) == 0) {
            i11 = (composer.changed(m10) ? 4 : 2) | i10;
        } else {
            i11 = i10;
        }
        if ((i10 & 48) == 0) {
            i11 |= composer.changedInstance(r10) ? 32 : 16;
        }
        if (composer.shouldExecute((i11 & 147) != 146, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2139246109, i11, -1, "cu.todus.android.uiCompose.shared.pagerStateIndicator.ComposableSingletons$PagerStateIndicatorKt.lambda$-2139246109.<anonymous> (PagerStateIndicator.kt:38)");
            }
            PagerStateIndicatorKt.ErrorMessageDefault(m10, r10, composer, i11 & 126, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: renamed from: getLambda$-1208785958$app_productionPFast, reason: not valid java name */
    public final Function3 m10087getLambda$1208785958$app_productionPFast() {
        return f363lambda$1208785958;
    }

    /* JADX INFO: renamed from: getLambda$-2139246109$app_productionPFast, reason: not valid java name */
    public final o m10088getLambda$2139246109$app_productionPFast() {
        return f364lambda$2139246109;
    }

    public final Function3 getLambda$1043743468$app_productionPFast() {
        return lambda$1043743468;
    }

    public final Function3 getLambda$1044445317$app_productionPFast() {
        return lambda$1044445317;
    }

    public final Function2 getLambda$529467836$app_productionPFast() {
        return lambda$529467836;
    }
}
