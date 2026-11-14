package cu.todus.android.uiCompose.main.screen.rooms.toolbar;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.outlined.DeleteOutlineKt;
import androidx.compose.material.icons.outlined.PushPinKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.unit.Dp;
import cu.z17.views.picture.Z17PictureKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
public final class ComposableSingletons$RoomsActionsTopBarKt {
    public static final ComposableSingletons$RoomsActionsTopBarKt INSTANCE = new ComposableSingletons$RoomsActionsTopBarKt();
    private static Function2 lambda$1183857615 = ComposableLambdaKt.composableLambdaInstance(1183857615, false, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.rooms.toolbar.a
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$RoomsActionsTopBarKt.lambda_1183857615$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2 lambda$587663255 = ComposableLambdaKt.composableLambdaInstance(587663255, false, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.rooms.toolbar.b
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$RoomsActionsTopBarKt.lambda_587663255$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 lambda_1183857615$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1183857615, i10, -1, "cu.todus.android.uiCompose.main.screen.rooms.toolbar.ComposableSingletons$RoomsActionsTopBarKt.lambda$1183857615.<anonymous> (RoomsActionsTopBar.kt:43)");
            }
            IconKt.m3298Iconww6aTOc(PushPinKt.getPushPin(Icons.Outlined.INSTANCE), "", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOnBackground(), composer, 48, 4);
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
    public static final k0 lambda_587663255$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(587663255, i10, -1, "cu.todus.android.uiCompose.main.screen.rooms.toolbar.ComposableSingletons$RoomsActionsTopBarKt.lambda$587663255.<anonymous> (RoomsActionsTopBar.kt:69)");
            }
            Z17PictureKt.m10278Z17BasePictureC8z9wKI(SizeKt.m1769size3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(24)), DeleteOutlineKt.getDeleteOutline(Icons.Outlined.INSTANCE), null, ColorFilter.Companion.m5907tintxETnrds$default(ColorFilter.INSTANCE, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOnBackground(), 0, 2, null), null, null, 0, null, null, composer, 6, XMPPTCPConnection.PacketWriter.QUEUE_SIZE);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    public final Function2 getLambda$1183857615$app_productionPFast() {
        return lambda$1183857615;
    }

    public final Function2 getLambda$587663255$app_productionPFast() {
        return lambda$587663255;
    }
}
