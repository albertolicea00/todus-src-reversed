package cu.todus.android.uiCompose.main.screen.rooms.request;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import cu.todus.android.R;
import cu.todus.android.uiCompose.main.screen.rooms.request.ComposableSingletons$RequestRoomsScreenKt;
import cu.z17.views.label.Z17LabelKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.y;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
public final class ComposableSingletons$RequestRoomsScreenKt {
    public static final ComposableSingletons$RequestRoomsScreenKt INSTANCE = new ComposableSingletons$RequestRoomsScreenKt();

    /* JADX INFO: renamed from: lambda$-429275005, reason: not valid java name */
    private static Function2 f255lambda$429275005 = ComposableLambdaKt.composableLambdaInstance(-429275005, false, new Function2() { // from class: b8.a
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$RequestRoomsScreenKt.lambda__429275005$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function3 lambda$1792024121 = ComposableLambdaKt.composableLambdaInstance(1792024121, false, new Function3() { // from class: b8.b
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$RequestRoomsScreenKt.lambda_1792024121$lambda$0((LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });
    private static Function3 lambda$32905217 = ComposableLambdaKt.composableLambdaInstance(32905217, false, new Function3() { // from class: b8.c
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$RequestRoomsScreenKt.lambda_32905217$lambda$0((LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 lambda_1792024121$lambda$0(LazyItemScope item, Composer composer, int i10) {
        y.i(item, "$this$item");
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1792024121, i10, -1, "cu.todus.android.uiCompose.main.screen.rooms.request.ComposableSingletons$RequestRoomsScreenKt.lambda$1792024121.<anonymous> (RequestRoomsScreen.kt:82)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion, Dp.m8823constructorimpl(5)), composer, 6);
            float f10 = 20;
            Modifier modifierM1725padding3ABfNKs = PaddingKt.m1725padding3ABfNKs(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), Dp.m8823constructorimpl(f10));
            MaterialTheme materialTheme = MaterialTheme.INSTANCE;
            int i11 = MaterialTheme.$stable;
            Z17LabelKt.m10262Z17LabelfWhpE4E(PaddingKt.m1725padding3ABfNKs(BackgroundKt.m1204backgroundbw27NRU(modifierM1725padding3ABfNKs, Color.m5865copywmQWz5c$default(materialTheme.getColorScheme(composer, i11).getOnBackground(), 0.2f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(10))), Dp.m8823constructorimpl(f10)), StringResources_androidKt.stringResource(R.string.keep_pressed_to_accept_request, composer, 0), TextStyle.m8271copyp1EtxEg$default(materialTheme.getTypography(composer, i11).getBodyMedium(), 0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, TextAlign.INSTANCE.m8692getCentere0LSkKk(), 0, 0L, null, null, null, 0, 0, null, 16744447, null), 0L, 0, 0, composer, 0, 56);
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
    public static final k0 lambda_32905217$lambda$0(LazyItemScope item, Composer composer, int i10) {
        y.i(item, "$this$item");
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(32905217, i10, -1, "cu.todus.android.uiCompose.main.screen.rooms.request.ComposableSingletons$RequestRoomsScreenKt.lambda$32905217.<anonymous> (RequestRoomsScreen.kt:179)");
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

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 lambda__429275005$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-429275005, i10, -1, "cu.todus.android.uiCompose.main.screen.rooms.request.ComposableSingletons$RequestRoomsScreenKt.lambda$-429275005.<anonymous> (RequestRoomsScreen.kt:57)");
            }
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, StringResources_androidKt.stringResource(R.string.requests, composer, 0), MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getTitleSmall(), 0L, 0, 0, composer, 0, 57);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: renamed from: getLambda$-429275005$app_productionPFast, reason: not valid java name */
    public final Function2 m9970getLambda$429275005$app_productionPFast() {
        return f255lambda$429275005;
    }

    public final Function3 getLambda$1792024121$app_productionPFast() {
        return lambda$1792024121;
    }

    public final Function3 getLambda$32905217$app_productionPFast() {
        return lambda$32905217;
    }
}
