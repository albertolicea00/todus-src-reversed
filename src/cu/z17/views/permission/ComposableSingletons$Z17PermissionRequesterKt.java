package cu.z17.views.permission;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.outlined.CallKt;
import androidx.compose.material.icons.outlined.CameraAltKt;
import androidx.compose.material.icons.outlined.CloseKt;
import androidx.compose.material.icons.outlined.ContactsKt;
import androidx.compose.material.icons.outlined.FolderKt;
import androidx.compose.material.icons.outlined.LocationOnKt;
import androidx.compose.material.icons.outlined.MicKt;
import androidx.compose.material.icons.outlined.NotificationsKt;
import androidx.compose.material.icons.outlined.SmsKt;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$Z17PermissionRequesterKt {
    public static final ComposableSingletons$Z17PermissionRequesterKt INSTANCE = new ComposableSingletons$Z17PermissionRequesterKt();

    /* JADX INFO: renamed from: lambda$-354748021, reason: not valid java name */
    private static Function2 f387lambda$354748021 = ComposableLambdaKt.composableLambdaInstance(-354748021, false, new Function2() { // from class: cu.z17.views.permission.a
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$Z17PermissionRequesterKt.lambda__354748021$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-856282252, reason: not valid java name */
    private static Function2 f389lambda$856282252 = ComposableLambdaKt.composableLambdaInstance(-856282252, false, new Function2() { // from class: cu.z17.views.permission.b
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$Z17PermissionRequesterKt.lambda__856282252$lambda$1((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-910502293, reason: not valid java name */
    private static Function2 f390lambda$910502293 = ComposableLambdaKt.composableLambdaInstance(-910502293, false, new Function2() { // from class: cu.z17.views.permission.c
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$Z17PermissionRequesterKt.lambda__910502293$lambda$2((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-1950794132, reason: not valid java name */
    private static Function2 f386lambda$1950794132 = ComposableLambdaKt.composableLambdaInstance(-1950794132, false, new Function2() { // from class: cu.z17.views.permission.d
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$Z17PermissionRequesterKt.lambda__1950794132$lambda$3((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2 lambda$1303881325 = ComposableLambdaKt.composableLambdaInstance(1303881325, false, new Function2() { // from class: cu.z17.views.permission.e
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$Z17PermissionRequesterKt.lambda_1303881325$lambda$4((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2 lambda$263589486 = ComposableLambdaKt.composableLambdaInstance(263589486, false, new Function2() { // from class: cu.z17.views.permission.f
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$Z17PermissionRequesterKt.lambda_263589486$lambda$5((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-776702353, reason: not valid java name */
    private static Function2 f388lambda$776702353 = ComposableLambdaKt.composableLambdaInstance(-776702353, false, new Function2() { // from class: cu.z17.views.permission.g
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$Z17PermissionRequesterKt.lambda__776702353$lambda$6((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-1816994192, reason: not valid java name */
    private static Function2 f385lambda$1816994192 = ComposableLambdaKt.composableLambdaInstance(-1816994192, false, new Function2() { // from class: cu.z17.views.permission.h
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$Z17PermissionRequesterKt.lambda__1816994192$lambda$7((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2 lambda$1437681265 = ComposableLambdaKt.composableLambdaInstance(1437681265, false, new Function2() { // from class: cu.z17.views.permission.i
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$Z17PermissionRequesterKt.lambda_1437681265$lambda$8((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 lambda_1303881325$lambda$4(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1303881325, i10, -1, "cu.z17.views.permission.ComposableSingletons$Z17PermissionRequesterKt.lambda$1303881325.<anonymous> (Z17PermissionRequester.kt:706)");
            }
            Z17PictureKt.m10278Z17BasePictureC8z9wKI(SizeKt.m1769size3ABfNKs(PaddingKt.m1725padding3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(8)), Dp.m8823constructorimpl(24)), SmsKt.getSms(Icons.Outlined.INSTANCE), null, ColorFilter.Companion.m5907tintxETnrds$default(ColorFilter.INSTANCE, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOnBackground(), 0, 2, null), null, null, 0, null, null, composer, 6, XMPPTCPConnection.PacketWriter.QUEUE_SIZE);
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
    public static final ua.k0 lambda_1437681265$lambda$8(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1437681265, i10, -1, "cu.z17.views.permission.ComposableSingletons$Z17PermissionRequesterKt.lambda$1437681265.<anonymous> (Z17PermissionRequester.kt:836)");
            }
            Z17PictureKt.m10278Z17BasePictureC8z9wKI(SizeKt.m1769size3ABfNKs(PaddingKt.m1725padding3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(8)), Dp.m8823constructorimpl(24)), NotificationsKt.getNotifications(Icons.Outlined.INSTANCE), null, ColorFilter.Companion.m5907tintxETnrds$default(ColorFilter.INSTANCE, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOnBackground(), 0, 2, null), null, null, 0, null, null, composer, 6, XMPPTCPConnection.PacketWriter.QUEUE_SIZE);
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
    public static final ua.k0 lambda_263589486$lambda$5(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(263589486, i10, -1, "cu.z17.views.permission.ComposableSingletons$Z17PermissionRequesterKt.lambda$263589486.<anonymous> (Z17PermissionRequester.kt:738)");
            }
            Z17PictureKt.m10278Z17BasePictureC8z9wKI(SizeKt.m1769size3ABfNKs(PaddingKt.m1725padding3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(8)), Dp.m8823constructorimpl(24)), CallKt.getCall(Icons.Outlined.INSTANCE), null, ColorFilter.Companion.m5907tintxETnrds$default(ColorFilter.INSTANCE, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOnBackground(), 0, 2, null), null, null, 0, null, null, composer, 6, XMPPTCPConnection.PacketWriter.QUEUE_SIZE);
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
    public static final ua.k0 lambda__1816994192$lambda$7(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1816994192, i10, -1, "cu.z17.views.permission.ComposableSingletons$Z17PermissionRequesterKt.lambda$-1816994192.<anonymous> (Z17PermissionRequester.kt:802)");
            }
            Z17PictureKt.m10278Z17BasePictureC8z9wKI(SizeKt.m1769size3ABfNKs(PaddingKt.m1725padding3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(8)), Dp.m8823constructorimpl(24)), CameraAltKt.getCameraAlt(Icons.Outlined.INSTANCE), null, ColorFilter.Companion.m5907tintxETnrds$default(ColorFilter.INSTANCE, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOnBackground(), 0, 2, null), null, null, 0, null, null, composer, 6, XMPPTCPConnection.PacketWriter.QUEUE_SIZE);
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
    public static final ua.k0 lambda__1950794132$lambda$3(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1950794132, i10, -1, "cu.z17.views.permission.ComposableSingletons$Z17PermissionRequesterKt.lambda$-1950794132.<anonymous> (Z17PermissionRequester.kt:674)");
            }
            Z17PictureKt.m10278Z17BasePictureC8z9wKI(SizeKt.m1769size3ABfNKs(PaddingKt.m1725padding3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(8)), Dp.m8823constructorimpl(24)), LocationOnKt.getLocationOn(Icons.Outlined.INSTANCE), null, ColorFilter.Companion.m5907tintxETnrds$default(ColorFilter.INSTANCE, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOnBackground(), 0, 2, null), null, null, 0, null, null, composer, 6, XMPPTCPConnection.PacketWriter.QUEUE_SIZE);
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
    public static final ua.k0 lambda__354748021$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-354748021, i10, -1, "cu.z17.views.permission.ComposableSingletons$Z17PermissionRequesterKt.lambda$-354748021.<anonymous> (Z17PermissionRequester.kt:443)");
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
    public static final ua.k0 lambda__776702353$lambda$6(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-776702353, i10, -1, "cu.z17.views.permission.ComposableSingletons$Z17PermissionRequesterKt.lambda$-776702353.<anonymous> (Z17PermissionRequester.kt:770)");
            }
            Z17PictureKt.m10278Z17BasePictureC8z9wKI(SizeKt.m1769size3ABfNKs(PaddingKt.m1725padding3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(8)), Dp.m8823constructorimpl(24)), MicKt.getMic(Icons.Outlined.INSTANCE), null, ColorFilter.Companion.m5907tintxETnrds$default(ColorFilter.INSTANCE, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOnBackground(), 0, 2, null), null, null, 0, null, null, composer, 6, XMPPTCPConnection.PacketWriter.QUEUE_SIZE);
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
    public static final ua.k0 lambda__856282252$lambda$1(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-856282252, i10, -1, "cu.z17.views.permission.ComposableSingletons$Z17PermissionRequesterKt.lambda$-856282252.<anonymous> (Z17PermissionRequester.kt:591)");
            }
            Z17PictureKt.m10278Z17BasePictureC8z9wKI(SizeKt.m1769size3ABfNKs(PaddingKt.m1725padding3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(8)), Dp.m8823constructorimpl(24)), ContactsKt.getContacts(Icons.Outlined.INSTANCE), null, ColorFilter.Companion.m5907tintxETnrds$default(ColorFilter.INSTANCE, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOnBackground(), 0, 2, null), null, null, 0, null, null, composer, 6, XMPPTCPConnection.PacketWriter.QUEUE_SIZE);
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
    public static final ua.k0 lambda__910502293$lambda$2(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-910502293, i10, -1, "cu.z17.views.permission.ComposableSingletons$Z17PermissionRequesterKt.lambda$-910502293.<anonymous> (Z17PermissionRequester.kt:642)");
            }
            Z17PictureKt.m10278Z17BasePictureC8z9wKI(SizeKt.m1769size3ABfNKs(PaddingKt.m1725padding3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(8)), Dp.m8823constructorimpl(24)), FolderKt.getFolder(Icons.Outlined.INSTANCE), null, ColorFilter.Companion.m5907tintxETnrds$default(ColorFilter.INSTANCE, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOnBackground(), 0, 2, null), null, null, 0, null, null, composer, 6, XMPPTCPConnection.PacketWriter.QUEUE_SIZE);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: renamed from: getLambda$-1816994192$views_release, reason: not valid java name */
    public final Function2 m10269getLambda$1816994192$views_release() {
        return f385lambda$1816994192;
    }

    /* JADX INFO: renamed from: getLambda$-1950794132$views_release, reason: not valid java name */
    public final Function2 m10270getLambda$1950794132$views_release() {
        return f386lambda$1950794132;
    }

    /* JADX INFO: renamed from: getLambda$-354748021$views_release, reason: not valid java name */
    public final Function2 m10271getLambda$354748021$views_release() {
        return f387lambda$354748021;
    }

    /* JADX INFO: renamed from: getLambda$-776702353$views_release, reason: not valid java name */
    public final Function2 m10272getLambda$776702353$views_release() {
        return f388lambda$776702353;
    }

    /* JADX INFO: renamed from: getLambda$-856282252$views_release, reason: not valid java name */
    public final Function2 m10273getLambda$856282252$views_release() {
        return f389lambda$856282252;
    }

    /* JADX INFO: renamed from: getLambda$-910502293$views_release, reason: not valid java name */
    public final Function2 m10274getLambda$910502293$views_release() {
        return f390lambda$910502293;
    }

    public final Function2 getLambda$1303881325$views_release() {
        return lambda$1303881325;
    }

    public final Function2 getLambda$1437681265$views_release() {
        return lambda$1437681265;
    }

    public final Function2 getLambda$263589486$views_release() {
        return lambda$263589486;
    }
}
