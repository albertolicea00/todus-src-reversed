package cu.todus.android.uiCompose.main.screen.chat.placeholder;

import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.g;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import cu.todus.android.uiCompose.main.screen.chat.placeholder.ComposableSingletons$ChatPlaceholderKt;
import kotlin.Metadata;
import kotlin.jvm.internal.y;
import lb.o;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
public final class ComposableSingletons$ChatPlaceholderKt {
    public static final ComposableSingletons$ChatPlaceholderKt INSTANCE = new ComposableSingletons$ChatPlaceholderKt();
    private static o lambda$1663671971 = ComposableLambdaKt.composableLambdaInstance(1663671971, false, new o() { // from class: s7.f
        @Override // lb.o
        public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
            return ComposableSingletons$ChatPlaceholderKt.lambda_1663671971$lambda$0((LazyItemScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 lambda_1663671971$lambda$0(LazyItemScope items, int i10, Composer composer, int i11) {
        int i12;
        y.i(items, "$this$items");
        if ((i11 & 6) == 0) {
            i12 = (composer.changed(items) ? 4 : 2) | i11;
        } else {
            i12 = i11;
        }
        if ((i11 & 48) == 0) {
            i12 |= composer.changed(i10) ? 32 : 16;
        }
        if (composer.shouldExecute((i12 & 147) != 146, i12 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1663671971, i12, -1, "cu.todus.android.uiCompose.main.screen.chat.placeholder.ComposableSingletons$ChatPlaceholderKt.lambda$1663671971.<anonymous> (ChatPlaceholder.kt:33)");
            }
            if (i10 % 2 == 0) {
                composer.startReplaceGroup(-1470871941);
                ChatPlaceholderKt.OutgoingMsgPlaceholder(g.c(items, Modifier.INSTANCE, null, null, null, 2, null), composer, 0);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-1470703301);
                ChatPlaceholderKt.IncomingMsgPlaceholder(g.c(items, Modifier.INSTANCE, null, null, null, 2, null), composer, 0);
                composer.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    public final o getLambda$1663671971$app_productionPFast() {
        return lambda$1663671971;
    }
}
