package cu.todus.android.uiCompose.main.screen.joinRoom;

import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.outlined.ArrowBackIosKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
public final class ComposableSingletons$JoinRoomScreenKt {
    public static final ComposableSingletons$JoinRoomScreenKt INSTANCE = new ComposableSingletons$JoinRoomScreenKt();

    /* JADX INFO: renamed from: lambda$-1187883574, reason: not valid java name */
    private static Function2 f229lambda$1187883574 = ComposableLambdaKt.composableLambdaInstance(-1187883574, false, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.joinRoom.a
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$JoinRoomScreenKt.lambda__1187883574$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2 lambda$886053660 = ComposableLambdaKt.composableLambdaInstance(886053660, false, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.joinRoom.b
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$JoinRoomScreenKt.lambda_886053660$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 lambda_886053660$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(886053660, i10, -1, "cu.todus.android.uiCompose.main.screen.joinRoom.ComposableSingletons$JoinRoomScreenKt.lambda$886053660.<anonymous> (JoinRoomScreen.kt:240)");
            }
            IconKt.m3298Iconww6aTOc(ArrowBackIosKt.getArrowBackIos(Icons.Outlined.INSTANCE), "", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOnBackground(), composer, 48, 4);
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
    public static final k0 lambda__1187883574$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1187883574, i10, -1, "cu.todus.android.uiCompose.main.screen.joinRoom.ComposableSingletons$JoinRoomScreenKt.lambda$-1187883574.<anonymous> (JoinRoomScreen.kt:90)");
            }
            IconKt.m3298Iconww6aTOc(ArrowBackIosKt.getArrowBackIos(Icons.Outlined.INSTANCE), "", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOnBackground(), composer, 48, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: renamed from: getLambda$-1187883574$app_productionPFast, reason: not valid java name */
    public final Function2 m9938getLambda$1187883574$app_productionPFast() {
        return f229lambda$1187883574;
    }

    public final Function2 getLambda$886053660$app_productionPFast() {
        return lambda$886053660;
    }
}
