package cu.todus.android.uiCompose.start.screen.firstOpen;

import androidx.compose.foundation.pager.PagerScope;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.jvm.internal.y;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
public final class ComposableSingletons$FirstOpenScreensKt {
    public static final ComposableSingletons$FirstOpenScreensKt INSTANCE = new ComposableSingletons$FirstOpenScreensKt();
    private static lb.o lambda$632535929 = ComposableLambdaKt.composableLambdaInstance(632535929, false, new lb.o() { // from class: cu.todus.android.uiCompose.start.screen.firstOpen.d
        @Override // lb.o
        public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
            return ComposableSingletons$FirstOpenScreensKt.lambda_632535929$lambda$0((PagerScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 lambda_632535929$lambda$0(PagerScope HorizontalPager, int i10, Composer composer, int i11) {
        y.i(HorizontalPager, "$this$HorizontalPager");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(632535929, i11, -1, "cu.todus.android.uiCompose.start.screen.firstOpen.ComposableSingletons$FirstOpenScreensKt.lambda$632535929.<anonymous> (FirstOpenScreens.kt:103)");
        }
        FirstOpenScreensKt.PageUi(PagesKt.getOnboardPages().get(i10), composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return k0.f43947a;
    }

    public final lb.o getLambda$632535929$app_productionPFast() {
        return lambda$632535929;
    }
}
