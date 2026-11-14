package cu.todus.android.uiCompose.main.screen.chat.details;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.outlined.CallKt;
import androidx.compose.material.icons.outlined.ChatKt;
import androidx.compose.material.icons.outlined.ContentCopyKt;
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
import cu.todus.android.R;
import cu.z17.views.picture.Z17PictureKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
public final class ComposableSingletons$DetailsDialogForContactCardKt {
    public static final ComposableSingletons$DetailsDialogForContactCardKt INSTANCE = new ComposableSingletons$DetailsDialogForContactCardKt();

    /* JADX INFO: renamed from: lambda$-869839549, reason: not valid java name */
    private static Function2 f191lambda$869839549 = ComposableLambdaKt.composableLambdaInstance(-869839549, false, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.details.a
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$DetailsDialogForContactCardKt.lambda__869839549$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-759591942, reason: not valid java name */
    private static Function2 f189lambda$759591942 = ComposableLambdaKt.composableLambdaInstance(-759591942, false, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.details.b
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$DetailsDialogForContactCardKt.lambda__759591942$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2 lambda$382755643 = ComposableLambdaKt.composableLambdaInstance(382755643, false, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.details.c
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$DetailsDialogForContactCardKt.lambda_382755643$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2 lambda$1525103228 = ComposableLambdaKt.composableLambdaInstance(1525103228, false, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.details.d
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$DetailsDialogForContactCardKt.lambda_1525103228$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-785764834, reason: not valid java name */
    private static Function2 f190lambda$785764834 = ComposableLambdaKt.composableLambdaInstance(-785764834, false, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.details.e
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$DetailsDialogForContactCardKt.lambda__785764834$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function3 lambda$1107380331 = ComposableLambdaKt.composableLambdaInstance(1107380331, false, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.chat.details.f
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$DetailsDialogForContactCardKt.lambda_1107380331$lambda$0((Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 lambda_1107380331$lambda$0(Modifier it, Composer composer, int i10) {
        kotlin.jvm.internal.y.i(it, "it");
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1107380331, i10, -1, "cu.todus.android.uiCompose.main.screen.chat.details.ComposableSingletons$DetailsDialogForContactCardKt.lambda$1107380331.<anonymous> (DetailsDialogForContactCard.kt:221)");
            }
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
    public static final ua.k0 lambda_1525103228$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1525103228, i10, -1, "cu.todus.android.uiCompose.main.screen.chat.details.ComposableSingletons$DetailsDialogForContactCardKt.lambda$1525103228.<anonymous> (DetailsDialogForContactCard.kt:165)");
            }
            IconKt.m3298Iconww6aTOc(ContentCopyKt.getContentCopy(Icons.Outlined.INSTANCE), "", SizeKt.m1769size3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(30)), MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOnBackground(), composer, 432, 0);
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
    public static final ua.k0 lambda_382755643$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(382755643, i10, -1, "cu.todus.android.uiCompose.main.screen.chat.details.ComposableSingletons$DetailsDialogForContactCardKt.lambda$382755643.<anonymous> (DetailsDialogForContactCard.kt:150)");
            }
            IconKt.m3298Iconww6aTOc(CallKt.getCall(Icons.Outlined.INSTANCE), "", SizeKt.m1769size3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(30)), MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOnBackground(), composer, 432, 0);
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
    public static final ua.k0 lambda__759591942$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-759591942, i10, -1, "cu.todus.android.uiCompose.main.screen.chat.details.ComposableSingletons$DetailsDialogForContactCardKt.lambda$-759591942.<anonymous> (DetailsDialogForContactCard.kt:126)");
            }
            IconKt.m3298Iconww6aTOc(ChatKt.getChat(Icons.Outlined.INSTANCE), "", SizeKt.m1769size3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(30)), MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOnBackground(), composer, 432, 0);
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
    public static final ua.k0 lambda__785764834$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-785764834, i10, -1, "cu.todus.android.uiCompose.main.screen.chat.details.ComposableSingletons$DetailsDialogForContactCardKt.lambda$-785764834.<anonymous> (DetailsDialogForContactCard.kt:199)");
            }
            Z17PictureKt.m10278Z17BasePictureC8z9wKI(SizeKt.m1769size3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(30)), Integer.valueOf(R.drawable.transfermovil_logo), null, null, null, "logo de transfermovil", 0, null, null, composer, 196614, 476);
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
    public static final ua.k0 lambda__869839549$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-869839549, i10, -1, "cu.todus.android.uiCompose.main.screen.chat.details.ComposableSingletons$DetailsDialogForContactCardKt.lambda$-869839549.<anonymous> (DetailsDialogForContactCard.kt:95)");
            }
            Z17PictureKt.m10278Z17BasePictureC8z9wKI(SizeKt.m1769size3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(30)), Integer.valueOf(R.drawable.useradd), null, ColorFilter.Companion.m5907tintxETnrds$default(ColorFilter.INSTANCE, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOnBackground(), 0, 2, null), null, null, 0, null, null, composer, 6, XMPPTCPConnection.PacketWriter.QUEUE_SIZE);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: renamed from: getLambda$-759591942$app_productionPFast, reason: not valid java name */
    public final Function2 m9884getLambda$759591942$app_productionPFast() {
        return f189lambda$759591942;
    }

    /* JADX INFO: renamed from: getLambda$-785764834$app_productionPFast, reason: not valid java name */
    public final Function2 m9885getLambda$785764834$app_productionPFast() {
        return f190lambda$785764834;
    }

    /* JADX INFO: renamed from: getLambda$-869839549$app_productionPFast, reason: not valid java name */
    public final Function2 m9886getLambda$869839549$app_productionPFast() {
        return f191lambda$869839549;
    }

    public final Function3 getLambda$1107380331$app_productionPFast() {
        return lambda$1107380331;
    }

    public final Function2 getLambda$1525103228$app_productionPFast() {
        return lambda$1525103228;
    }

    public final Function2 getLambda$382755643$app_productionPFast() {
        return lambda$382755643;
    }
}
