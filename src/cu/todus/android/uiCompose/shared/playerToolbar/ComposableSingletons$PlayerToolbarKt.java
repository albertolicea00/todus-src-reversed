package cu.todus.android.uiCompose.shared.playerToolbar;

import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.outlined.CancelKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import cu.todus.android.uiCompose.shared.playerToolbar.ComposableSingletons$PlayerToolbarKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
public final class ComposableSingletons$PlayerToolbarKt {
    public static final ComposableSingletons$PlayerToolbarKt INSTANCE = new ComposableSingletons$PlayerToolbarKt();

    /* JADX INFO: renamed from: lambda$-238085072, reason: not valid java name */
    private static Function2 f365lambda$238085072 = ComposableLambdaKt.composableLambdaInstance(-238085072, false, new Function2() { // from class: u8.a
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$PlayerToolbarKt.lambda__238085072$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 lambda__238085072$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-238085072, i10, -1, "cu.todus.android.uiCompose.shared.playerToolbar.ComposableSingletons$PlayerToolbarKt.lambda$-238085072.<anonymous> (PlayerToolbar.kt:134)");
            }
            IconKt.m3298Iconww6aTOc(CancelKt.getCancel(Icons.Outlined.INSTANCE), "", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getPrimary(), composer, 48, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: renamed from: getLambda$-238085072$app_productionPFast, reason: not valid java name */
    public final Function2 m10089getLambda$238085072$app_productionPFast() {
        return f365lambda$238085072;
    }
}
