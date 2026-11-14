package cu.todus.android.uiCompose.main.screen.chat.attachmentPreview;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.automirrored.outlined.ArrowBackKt;
import androidx.compose.material.icons.automirrored.outlined.ArrowForwardKt;
import androidx.compose.material.icons.outlined.ClearKt;
import androidx.compose.material.icons.outlined.FitScreenKt;
import androidx.compose.material.icons.outlined.MoreVertKt;
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

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
public final class ComposableSingletons$AttachmentPreviewKt {
    public static final ComposableSingletons$AttachmentPreviewKt INSTANCE = new ComposableSingletons$AttachmentPreviewKt();

    /* JADX INFO: renamed from: lambda$-1098294812, reason: not valid java name */
    private static Function2 f181lambda$1098294812 = ComposableLambdaKt.composableLambdaInstance(-1098294812, false, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.attachmentPreview.v
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$AttachmentPreviewKt.lambda__1098294812$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2 lambda$836435099 = ComposableLambdaKt.composableLambdaInstance(836435099, false, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.attachmentPreview.w
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$AttachmentPreviewKt.lambda_836435099$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-866094319, reason: not valid java name */
    private static Function2 f183lambda$866094319 = ComposableLambdaKt.composableLambdaInstance(-866094319, false, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.attachmentPreview.x
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$AttachmentPreviewKt.lambda__866094319$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2 lambda$1629990130 = ComposableLambdaKt.composableLambdaInstance(1629990130, false, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.attachmentPreview.y
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$AttachmentPreviewKt.lambda_1629990130$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-1990818405, reason: not valid java name */
    private static Function2 f182lambda$1990818405 = ComposableLambdaKt.composableLambdaInstance(-1990818405, false, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.attachmentPreview.z
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$AttachmentPreviewKt.lambda__1990818405$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 lambda_1629990130$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1629990130, i10, -1, "cu.todus.android.uiCompose.main.screen.chat.attachmentPreview.ComposableSingletons$AttachmentPreviewKt.lambda$1629990130.<anonymous> (AttachmentPreview.kt:347)");
            }
            Z17PictureKt.m10278Z17BasePictureC8z9wKI(SizeKt.m1769size3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(24)), FitScreenKt.getFitScreen(Icons.Outlined.INSTANCE), null, ColorFilter.Companion.m5907tintxETnrds$default(ColorFilter.INSTANCE, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOnBackground(), 0, 2, null), null, null, 0, null, null, composer, 6, XMPPTCPConnection.PacketWriter.QUEUE_SIZE);
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
    public static final ua.k0 lambda_836435099$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(836435099, i10, -1, "cu.todus.android.uiCompose.main.screen.chat.attachmentPreview.ComposableSingletons$AttachmentPreviewKt.lambda$836435099.<anonymous> (AttachmentPreview.kt:255)");
            }
            IconKt.m3298Iconww6aTOc(ArrowForwardKt.getArrowForward(Icons.AutoMirrored.Outlined.INSTANCE), "", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOnBackground(), composer, 48, 4);
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
    public static final ua.k0 lambda__1098294812$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1098294812, i10, -1, "cu.todus.android.uiCompose.main.screen.chat.attachmentPreview.ComposableSingletons$AttachmentPreviewKt.lambda$-1098294812.<anonymous> (AttachmentPreview.kt:224)");
            }
            IconKt.m3298Iconww6aTOc(ArrowBackKt.getArrowBack(Icons.AutoMirrored.Outlined.INSTANCE), "", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOnBackground(), composer, 48, 4);
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
    public static final ua.k0 lambda__1990818405$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1990818405, i10, -1, "cu.todus.android.uiCompose.main.screen.chat.attachmentPreview.ComposableSingletons$AttachmentPreviewKt.lambda$-1990818405.<anonymous> (AttachmentPreview.kt:359)");
            }
            Z17PictureKt.m10278Z17BasePictureC8z9wKI(SizeKt.m1769size3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(24)), MoreVertKt.getMoreVert(Icons.Outlined.INSTANCE), null, ColorFilter.Companion.m5907tintxETnrds$default(ColorFilter.INSTANCE, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOnBackground(), 0, 2, null), null, null, 0, null, null, composer, 6, XMPPTCPConnection.PacketWriter.QUEUE_SIZE);
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
    public static final ua.k0 lambda__866094319$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-866094319, i10, -1, "cu.todus.android.uiCompose.main.screen.chat.attachmentPreview.ComposableSingletons$AttachmentPreviewKt.lambda$-866094319.<anonymous> (AttachmentPreview.kt:334)");
            }
            Z17PictureKt.m10278Z17BasePictureC8z9wKI(SizeKt.m1769size3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(24)), ClearKt.getClear(Icons.Outlined.INSTANCE), null, ColorFilter.Companion.m5907tintxETnrds$default(ColorFilter.INSTANCE, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOnBackground(), 0, 2, null), null, null, 0, null, null, composer, 6, XMPPTCPConnection.PacketWriter.QUEUE_SIZE);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: renamed from: getLambda$-1098294812$app_productionPFast, reason: not valid java name */
    public final Function2 m9852getLambda$1098294812$app_productionPFast() {
        return f181lambda$1098294812;
    }

    /* JADX INFO: renamed from: getLambda$-1990818405$app_productionPFast, reason: not valid java name */
    public final Function2 m9853getLambda$1990818405$app_productionPFast() {
        return f182lambda$1990818405;
    }

    /* JADX INFO: renamed from: getLambda$-866094319$app_productionPFast, reason: not valid java name */
    public final Function2 m9854getLambda$866094319$app_productionPFast() {
        return f183lambda$866094319;
    }

    public final Function2 getLambda$1629990130$app_productionPFast() {
        return lambda$1629990130;
    }

    public final Function2 getLambda$836435099$app_productionPFast() {
        return lambda$836435099;
    }
}
