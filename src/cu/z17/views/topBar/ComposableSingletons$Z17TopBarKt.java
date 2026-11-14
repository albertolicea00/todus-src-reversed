package cu.z17.views.topBar;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import cu.z17.views.topBar.ComposableSingletons$Z17TopBarKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.y;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$Z17TopBarKt {
    public static final ComposableSingletons$Z17TopBarKt INSTANCE = new ComposableSingletons$Z17TopBarKt();
    private static Function2 lambda$1069247008 = ComposableLambdaKt.composableLambdaInstance(1069247008, false, new Function2() { // from class: t9.a
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$Z17TopBarKt.lambda_1069247008$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-1566705363, reason: not valid java name */
    private static Function3 f391lambda$1566705363 = ComposableLambdaKt.composableLambdaInstance(-1566705363, false, new Function3() { // from class: t9.b
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$Z17TopBarKt.lambda__1566705363$lambda$1((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-337125894, reason: not valid java name */
    private static Function3 f392lambda$337125894 = ComposableLambdaKt.composableLambdaInstance(-337125894, false, new Function3() { // from class: t9.c
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$Z17TopBarKt.lambda__337125894$lambda$2((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    public static final k0 lambda_1069247008$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1069247008, i10, -1, "cu.z17.views.topBar.ComposableSingletons$Z17TopBarKt.lambda$1069247008.<anonymous> (Z17TopBar.kt:25)");
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
    public static final k0 lambda__1566705363$lambda$1(RowScope rowScope, Composer composer, int i10) {
        y.i(rowScope, "<this>");
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1566705363, i10, -1, "cu.z17.views.topBar.ComposableSingletons$Z17TopBarKt.lambda$-1566705363.<anonymous> (Z17TopBar.kt:28)");
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
    public static final k0 lambda__337125894$lambda$2(RowScope TopAppBar, Composer composer, int i10) {
        y.i(TopAppBar, "$this$TopAppBar");
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-337125894, i10, -1, "cu.z17.views.topBar.ComposableSingletons$Z17TopBarKt.lambda$-337125894.<anonymous> (Z17TopBar.kt:43)");
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: renamed from: getLambda$-1566705363$views_release, reason: not valid java name */
    public final Function3 m10302getLambda$1566705363$views_release() {
        return f391lambda$1566705363;
    }

    /* JADX INFO: renamed from: getLambda$-337125894$views_release, reason: not valid java name */
    public final Function3 m10303getLambda$337125894$views_release() {
        return f392lambda$337125894;
    }

    public final Function2 getLambda$1069247008$views_release() {
        return lambda$1069247008;
    }
}
