package cu.todus.android.uiCompose.main.screen.chat.input;

import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.unit.Dp;
import cu.todus.android.R;
import cu.z17.views.picture.Z17PictureKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
public final class ComposableSingletons$ChatSendButtonKt {
    public static final ComposableSingletons$ChatSendButtonKt INSTANCE = new ComposableSingletons$ChatSendButtonKt();
    private static Function3 lambda$714620195 = ComposableLambdaKt.composableLambdaInstance(714620195, false, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.chat.input.z
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$ChatSendButtonKt.lambda_714620195$lambda$0((AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-1109401766, reason: not valid java name */
    private static Function3 f192lambda$1109401766 = ComposableLambdaKt.composableLambdaInstance(-1109401766, false, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.chat.input.a0
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$ChatSendButtonKt.lambda__1109401766$lambda$0((AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 lambda_714620195$lambda$0(AnimatedVisibilityScope AnimatedVisibility, Composer composer, int i10) {
        kotlin.jvm.internal.y.i(AnimatedVisibility, "$this$AnimatedVisibility");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(714620195, i10, -1, "cu.todus.android.uiCompose.main.screen.chat.input.ComposableSingletons$ChatSendButtonKt.lambda$714620195.<anonymous> (ChatSendButton.kt:128)");
        }
        Z17PictureKt.m10278Z17BasePictureC8z9wKI(SizeKt.m1769size3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(22)), Integer.valueOf(R.drawable.mic_icon), null, ColorFilter.Companion.m5907tintxETnrds$default(ColorFilter.INSTANCE, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getBackground(), 0, 2, null), null, null, 0, null, null, composer, 6, XMPPTCPConnection.PacketWriter.QUEUE_SIZE);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 lambda__1109401766$lambda$0(AnimatedVisibilityScope AnimatedVisibility, Composer composer, int i10) {
        kotlin.jvm.internal.y.i(AnimatedVisibility, "$this$AnimatedVisibility");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1109401766, i10, -1, "cu.todus.android.uiCompose.main.screen.chat.input.ComposableSingletons$ChatSendButtonKt.lambda$-1109401766.<anonymous> (ChatSendButton.kt:140)");
        }
        Z17PictureKt.m10278Z17BasePictureC8z9wKI(OffsetKt.m1685offsetVpY3zN4$default(SizeKt.m1769size3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(22)), Dp.m8823constructorimpl(2), 0.0f, 2, null), Integer.valueOf(R.drawable.send_icon), null, ColorFilter.Companion.m5907tintxETnrds$default(ColorFilter.INSTANCE, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getBackground(), 0, 2, null), null, null, 0, null, null, composer, 6, XMPPTCPConnection.PacketWriter.QUEUE_SIZE);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: renamed from: getLambda$-1109401766$app_productionPFast, reason: not valid java name */
    public final Function3 m9888getLambda$1109401766$app_productionPFast() {
        return f192lambda$1109401766;
    }

    public final Function3 getLambda$714620195$app_productionPFast() {
        return lambda$714620195;
    }
}
