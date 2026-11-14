package cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.outlined.CloseKt;
import androidx.compose.material.icons.outlined.NotificationsNoneKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import cu.z17.views.R;
import cu.z17.views.button.Z17ButtonsKt;
import cu.z17.views.picture.Z17PictureKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
public final class ComposableSingletons$PreviewChannelScreenKt {
    public static final ComposableSingletons$PreviewChannelScreenKt INSTANCE = new ComposableSingletons$PreviewChannelScreenKt();
    private static Function2 lambda$702545133 = ComposableLambdaKt.composableLambdaInstance(702545133, false, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel.b
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$PreviewChannelScreenKt.lambda_702545133$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function3 lambda$2067900210 = ComposableLambdaKt.composableLambdaInstance(2067900210, false, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel.c
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$PreviewChannelScreenKt.lambda_2067900210$lambda$0((lb.a) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-1866655172, reason: not valid java name */
    private static Function2 f207lambda$1866655172 = ComposableLambdaKt.composableLambdaInstance(-1866655172, false, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel.d
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$PreviewChannelScreenKt.lambda__1866655172$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 lambda_2067900210$lambda$0(final lb.a onSubmit, Composer composer, int i10) {
        kotlin.jvm.internal.y.i(onSubmit, "onSubmit");
        if ((i10 & 6) == 0) {
            i10 |= composer.changedInstance(onSubmit) ? 4 : 2;
        }
        if (composer.shouldExecute((i10 & 19) != 18, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2067900210, i10, -1, "cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel.ComposableSingletons$PreviewChannelScreenKt.lambda$2067900210.<anonymous> (PreviewChannelScreen.kt:359)");
            }
            boolean z10 = (i10 & 14) == 4;
            Object objRememberedValue = composer.rememberedValue();
            if (z10 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel.a
                    @Override // lb.a
                    public final Object invoke() {
                        return ComposableSingletons$PreviewChannelScreenKt.lambda_2067900210$lambda$0$0$0(onSubmit);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            Z17ButtonsKt.Z17PrimaryButton(null, (lb.a) objRememberedValue, StringResources_androidKt.stringResource(R.string.submit, composer, 0), null, true, false, composer, 24576, 41);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 lambda_2067900210$lambda$0$0$0(lb.a aVar) {
        aVar.invoke();
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 lambda_702545133$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(702545133, i10, -1, "cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel.ComposableSingletons$PreviewChannelScreenKt.lambda$702545133.<anonymous> (PreviewChannelScreen.kt:345)");
            }
            IconKt.m3298Iconww6aTOc(CloseKt.getClose(Icons.Outlined.INSTANCE), "", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOnBackground(), composer, 48, 4);
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
    public static final ua.k0 lambda__1866655172$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1866655172, i10, -1, "cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel.ComposableSingletons$PreviewChannelScreenKt.lambda$-1866655172.<anonymous> (PreviewChannelScreen.kt:548)");
            }
            Z17PictureKt.m10278Z17BasePictureC8z9wKI(SizeKt.m1769size3ABfNKs(PaddingKt.m1725padding3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(20)), Dp.m8823constructorimpl(24)), NotificationsNoneKt.getNotificationsNone(Icons.Outlined.INSTANCE), null, ColorFilter.Companion.m5907tintxETnrds$default(ColorFilter.INSTANCE, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOnBackground(), 0, 2, null), null, null, 0, null, null, composer, 6, XMPPTCPConnection.PacketWriter.QUEUE_SIZE);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: renamed from: getLambda$-1866655172$app_productionPFast, reason: not valid java name */
    public final Function2 m9914getLambda$1866655172$app_productionPFast() {
        return f207lambda$1866655172;
    }

    public final Function3 getLambda$2067900210$app_productionPFast() {
        return lambda$2067900210;
    }

    public final Function2 getLambda$702545133$app_productionPFast() {
        return lambda$702545133;
    }
}
