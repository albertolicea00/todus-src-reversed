package cu.todus.android.uiCompose.main.screen.rooms.home;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.automirrored.outlined.ChatKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import cu.todus.android.R;
import cu.z17.views.label.Z17LabelKt;
import cu.z17.views.picture.Z17PictureKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
public final class ComposableSingletons$BigHomeScreenKt {
    public static final ComposableSingletons$BigHomeScreenKt INSTANCE = new ComposableSingletons$BigHomeScreenKt();

    /* JADX INFO: renamed from: lambda$-1627418366, reason: not valid java name */
    private static Function2 f251lambda$1627418366 = ComposableLambdaKt.composableLambdaInstance(-1627418366, false, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.rooms.home.n0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$BigHomeScreenKt.lambda__1627418366$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2 lambda$519148099 = ComposableLambdaKt.composableLambdaInstance(519148099, false, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.rooms.home.o0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$BigHomeScreenKt.lambda_519148099$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-158894958, reason: not valid java name */
    private static Function3 f250lambda$158894958 = ComposableLambdaKt.composableLambdaInstance(-158894958, false, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.rooms.home.p0
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$BigHomeScreenKt.lambda__158894958$lambda$0((LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 lambda_519148099$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(519148099, i10, -1, "cu.todus.android.uiCompose.main.screen.rooms.home.ComposableSingletons$BigHomeScreenKt.lambda$519148099.<anonymous> (BigHomeScreen.kt:353)");
            }
            Z17PictureKt.m10278Z17BasePictureC8z9wKI(SizeKt.m1769size3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(25)), ChatKt.getChat(Icons.AutoMirrored.Outlined.INSTANCE), null, ColorFilter.Companion.m5907tintxETnrds$default(ColorFilter.INSTANCE, Color.INSTANCE.m5903getWhite0d7_KjU(), 0, 2, null), null, "Open new chat", 0, null, null, composer, 199686, 468);
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
    public static final ua.k0 lambda__158894958$lambda$0(LazyItemScope item, Composer composer, int i10) {
        kotlin.jvm.internal.y.i(item, "$this$item");
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-158894958, i10, -1, "cu.todus.android.uiCompose.main.screen.rooms.home.ComposableSingletons$BigHomeScreenKt.lambda$-158894958.<anonymous> (BigHomeScreen.kt:643)");
            }
            SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(100)), composer, 6);
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
    public static final ua.k0 lambda__1627418366$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1627418366, i10, -1, "cu.todus.android.uiCompose.main.screen.rooms.home.ComposableSingletons$BigHomeScreenKt.lambda$-1627418366.<anonymous> (BigHomeScreen.kt:347)");
            }
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, StringResources_androidKt.stringResource(R.string.new_chat, composer, 0), null, Color.INSTANCE.m5903getWhite0d7_KjU(), 0, 0, composer, 3072, 53);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: renamed from: getLambda$-158894958$app_productionPFast, reason: not valid java name */
    public final Function3 m9965getLambda$158894958$app_productionPFast() {
        return f250lambda$158894958;
    }

    /* JADX INFO: renamed from: getLambda$-1627418366$app_productionPFast, reason: not valid java name */
    public final Function2 m9966getLambda$1627418366$app_productionPFast() {
        return f251lambda$1627418366;
    }

    public final Function2 getLambda$519148099$app_productionPFast() {
        return lambda$519148099;
    }
}
