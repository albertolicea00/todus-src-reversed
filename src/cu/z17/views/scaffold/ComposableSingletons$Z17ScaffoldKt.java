package cu.z17.views.scaffold;

import androidx.compose.material3.TopAppBarScrollBehavior;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import cu.z17.views.scaffold.ComposableSingletons$Z17ScaffoldKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.y;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$Z17ScaffoldKt {
    public static final ComposableSingletons$Z17ScaffoldKt INSTANCE = new ComposableSingletons$Z17ScaffoldKt();
    private static Function3 lambda$1574519439 = ComposableLambdaKt.composableLambdaInstance(1574519439, false, new Function3() { // from class: p9.a
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$Z17ScaffoldKt.lambda_1574519439$lambda$0((TopAppBarScrollBehavior) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });
    private static Function2 lambda$1427295215 = ComposableLambdaKt.composableLambdaInstance(1427295215, false, new Function2() { // from class: p9.b
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$Z17ScaffoldKt.lambda_1427295215$lambda$1((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2 lambda$311076088 = ComposableLambdaKt.composableLambdaInstance(311076088, false, new Function2() { // from class: p9.c
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$Z17ScaffoldKt.lambda_311076088$lambda$2((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    public static final k0 lambda_1427295215$lambda$1(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1427295215, i10, -1, "cu.z17.views.scaffold.ComposableSingletons$Z17ScaffoldKt.lambda$1427295215.<anonymous> (Z17Scaffold.kt:28)");
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
    @Composable
    public static final k0 lambda_1574519439$lambda$0(TopAppBarScrollBehavior it, Composer composer, int i10) {
        y.i(it, "it");
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1574519439, i10, -1, "cu.z17.views.scaffold.ComposableSingletons$Z17ScaffoldKt.lambda$1574519439.<anonymous> (Z17Scaffold.kt:24)");
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
    @Composable
    public static final k0 lambda_311076088$lambda$2(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(311076088, i10, -1, "cu.z17.views.scaffold.ComposableSingletons$Z17ScaffoldKt.lambda$311076088.<anonymous> (Z17Scaffold.kt:83)");
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    public final Function2 getLambda$1427295215$views_release() {
        return lambda$1427295215;
    }

    public final Function3 getLambda$1574519439$views_release() {
        return lambda$1574519439;
    }

    public final Function2 getLambda$311076088$views_release() {
        return lambda$311076088;
    }
}
