package cu.todus.android.uiCompose.main.screen.rooms.secret;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import cu.todus.android.R;
import cu.z17.views.label.Z17LabelKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.y;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
public final class ComposableSingletons$SecretRoomsScreenKt {
    public static final ComposableSingletons$SecretRoomsScreenKt INSTANCE = new ComposableSingletons$SecretRoomsScreenKt();
    private static Function2 lambda$1952694652 = ComposableLambdaKt.composableLambdaInstance(1952694652, false, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.rooms.secret.a
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$SecretRoomsScreenKt.lambda_1952694652$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function3 lambda$1763974442 = ComposableLambdaKt.composableLambdaInstance(1763974442, false, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.rooms.secret.b
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$SecretRoomsScreenKt.lambda_1763974442$lambda$0((LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-401680798, reason: not valid java name */
    private static Function3 f256lambda$401680798 = ComposableLambdaKt.composableLambdaInstance(-401680798, false, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.rooms.secret.c
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$SecretRoomsScreenKt.lambda__401680798$lambda$0((LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 lambda_1763974442$lambda$0(LazyItemScope item, Composer composer, int i10) {
        y.i(item, "$this$item");
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1763974442, i10, -1, "cu.todus.android.uiCompose.main.screen.rooms.secret.ComposableSingletons$SecretRoomsScreenKt.lambda$1763974442.<anonymous> (SecretRoomsScreen.kt:127)");
            }
            SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(5)), composer, 6);
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
    public static final k0 lambda_1952694652$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1952694652, i10, -1, "cu.todus.android.uiCompose.main.screen.rooms.secret.ComposableSingletons$SecretRoomsScreenKt.lambda$1952694652.<anonymous> (SecretRoomsScreen.kt:107)");
            }
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, StringResources_androidKt.stringResource(R.string.secret_folder, composer, 0), MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getTitleSmall(), 0L, 0, 0, composer, 0, 57);
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
    public static final k0 lambda__401680798$lambda$0(LazyItemScope item, Composer composer, int i10) {
        y.i(item, "$this$item");
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-401680798, i10, -1, "cu.todus.android.uiCompose.main.screen.rooms.secret.ComposableSingletons$SecretRoomsScreenKt.lambda$-401680798.<anonymous> (SecretRoomsScreen.kt:213)");
            }
            SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(100)), composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: renamed from: getLambda$-401680798$app_productionPFast, reason: not valid java name */
    public final Function3 m9971getLambda$401680798$app_productionPFast() {
        return f256lambda$401680798;
    }

    public final Function3 getLambda$1763974442$app_productionPFast() {
        return lambda$1763974442;
    }

    public final Function2 getLambda$1952694652$app_productionPFast() {
        return lambda$1952694652;
    }
}
