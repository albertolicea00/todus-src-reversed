package cu.todus.android.uiCompose.main.screen.dataPreferences;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.outlined.AudioFileKt;
import androidx.compose.material.icons.outlined.ImageKt;
import androidx.compose.material.icons.outlined.InsertDriveFileKt;
import androidx.compose.material.icons.outlined.VideoFileKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.SliderState;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import cu.todus.android.R;
import cu.todus.android.uiCompose.theme.Other;
import cu.z17.views.label.Z17LabelKt;
import cu.z17.views.picture.Z17PictureKt;
import cu.z17.views.utils.Z17InlineUtilsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
public final class ComposableSingletons$DataPreferencesScreenKt {
    public static final ComposableSingletons$DataPreferencesScreenKt INSTANCE = new ComposableSingletons$DataPreferencesScreenKt();
    private static Function2 lambda$331152681 = ComposableLambdaKt.composableLambdaInstance(331152681, false, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.dataPreferences.a
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$DataPreferencesScreenKt.lambda_331152681$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2 lambda$1096798119 = ComposableLambdaKt.composableLambdaInstance(1096798119, false, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.dataPreferences.h
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$DataPreferencesScreenKt.lambda_1096798119$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2 lambda$562341982 = ComposableLambdaKt.composableLambdaInstance(562341982, false, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.dataPreferences.i
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$DataPreferencesScreenKt.lambda_562341982$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2 lambda$1659659871 = ComposableLambdaKt.composableLambdaInstance(1659659871, false, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.dataPreferences.j
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$DataPreferencesScreenKt.lambda_1659659871$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-1537989536, reason: not valid java name */
    private static Function2 f220lambda$1537989536 = ComposableLambdaKt.composableLambdaInstance(-1537989536, false, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.dataPreferences.k
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$DataPreferencesScreenKt.lambda__1537989536$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-440671647, reason: not valid java name */
    private static Function2 f223lambda$440671647 = ComposableLambdaKt.composableLambdaInstance(-440671647, false, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.dataPreferences.l
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$DataPreferencesScreenKt.lambda__440671647$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2 lambda$656646242 = ComposableLambdaKt.composableLambdaInstance(656646242, false, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.dataPreferences.m
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$DataPreferencesScreenKt.lambda_656646242$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2 lambda$1753964131 = ComposableLambdaKt.composableLambdaInstance(1753964131, false, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.dataPreferences.b
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$DataPreferencesScreenKt.lambda_1753964131$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-1443685276, reason: not valid java name */
    private static Function2 f219lambda$1443685276 = ComposableLambdaKt.composableLambdaInstance(-1443685276, false, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.dataPreferences.c
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$DataPreferencesScreenKt.lambda__1443685276$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-346367387, reason: not valid java name */
    private static Function2 f222lambda$346367387 = ComposableLambdaKt.composableLambdaInstance(-346367387, false, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.dataPreferences.d
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$DataPreferencesScreenKt.lambda__346367387$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2 lambda$750950502 = ComposableLambdaKt.composableLambdaInstance(750950502, false, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.dataPreferences.e
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$DataPreferencesScreenKt.lambda_750950502$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function3 lambda$1587491476 = ComposableLambdaKt.composableLambdaInstance(1587491476, false, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.dataPreferences.f
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$DataPreferencesScreenKt.lambda_1587491476$lambda$0(((Integer) obj).intValue(), (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-1960766284, reason: not valid java name */
    private static Function3 f221lambda$1960766284 = ComposableLambdaKt.composableLambdaInstance(-1960766284, false, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.dataPreferences.g
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$DataPreferencesScreenKt.lambda__1960766284$lambda$0((SliderState) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 lambda_1096798119$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1096798119, i10, -1, "cu.todus.android.uiCompose.main.screen.dataPreferences.ComposableSingletons$DataPreferencesScreenKt.lambda$1096798119.<anonymous> (DataPreferencesScreen.kt:140)");
            }
            Z17PictureKt.m10278Z17BasePictureC8z9wKI(PaddingKt.m1725padding3ABfNKs(BackgroundKt.m1204backgroundbw27NRU(SizeKt.m1769size3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(40)), Color.m5865copywmQWz5c$default(Other.INSTANCE.m10118getRed0d7_KjU(), 0.7f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.getCircleShape()), Dp.m8823constructorimpl(10)), ImageKt.getImage(Icons.Outlined.INSTANCE), null, ColorFilter.Companion.m5907tintxETnrds$default(ColorFilter.INSTANCE, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getBackground(), 0, 2, null), null, null, 0, null, null, composer, 0, XMPPTCPConnection.PacketWriter.QUEUE_SIZE);
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
    public static final k0 lambda_1587491476$lambda$0(int i10, Composer composer, int i11) {
        int i12;
        if ((i11 & 6) == 0) {
            i12 = i11 | (composer.changed(i10) ? 4 : 2);
        } else {
            i12 = i11;
        }
        if (composer.shouldExecute((i12 & 19) != 18, i12 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1587491476, i12, -1, "cu.todus.android.uiCompose.main.screen.dataPreferences.ComposableSingletons$DataPreferencesScreenKt.lambda$1587491476.<anonymous> (DataPreferencesScreen.kt:459)");
            }
            defpackage.s sVar = defpackage.s.f41954a;
            String strD = defpackage.b0.D(i10, 3.0f);
            long jM5901getTransparent0d7_KjU = Color.INSTANCE.m5901getTransparent0d7_KjU();
            float fM8823constructorimpl = Dp.m8823constructorimpl(40);
            Modifier.Companion companion = Modifier.INSTANCE;
            Brush.Companion companion2 = Brush.INSTANCE;
            MaterialTheme materialTheme = MaterialTheme.INSTANCE;
            int i13 = MaterialTheme.$stable;
            sVar.j(strD, BackgroundKt.background$default(companion, Brush.Companion.m5821linearGradientmHitzGk$default(companion2, va.w.q(Color.m5856boximpl(Z17InlineUtilsKt.m10309lighterDxMtmZc(materialTheme.getColorScheme(composer, i13).getPrimary(), 0.5f)), Color.m5856boximpl(materialTheme.getColorScheme(composer, i13).getPrimary())), 0L, 0L, 0, 14, (Object) null), RoundedCornerShapeKt.getCircleShape(), 0.0f, 4, null), jM5901getTransparent0d7_KjU, fM8823constructorimpl, null, null, composer, 1576320, 48);
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
    public static final k0 lambda_1659659871$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1659659871, i10, -1, "cu.todus.android.uiCompose.main.screen.dataPreferences.ComposableSingletons$DataPreferencesScreenKt.lambda$1659659871.<anonymous> (DataPreferencesScreen.kt:184)");
            }
            Z17PictureKt.m10278Z17BasePictureC8z9wKI(PaddingKt.m1725padding3ABfNKs(BackgroundKt.m1204backgroundbw27NRU(SizeKt.m1769size3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(40)), Color.m5865copywmQWz5c$default(Other.INSTANCE.m10118getRed0d7_KjU(), 0.7f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.getCircleShape()), Dp.m8823constructorimpl(10)), AudioFileKt.getAudioFile(Icons.Outlined.INSTANCE), null, ColorFilter.Companion.m5907tintxETnrds$default(ColorFilter.INSTANCE, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getBackground(), 0, 2, null), null, null, 0, null, null, composer, 0, XMPPTCPConnection.PacketWriter.QUEUE_SIZE);
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
    public static final k0 lambda_1753964131$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1753964131, i10, -1, "cu.todus.android.uiCompose.main.screen.dataPreferences.ComposableSingletons$DataPreferencesScreenKt.lambda$1753964131.<anonymous> (DataPreferencesScreen.kt:283)");
            }
            Z17PictureKt.m10278Z17BasePictureC8z9wKI(PaddingKt.m1725padding3ABfNKs(BackgroundKt.m1204backgroundbw27NRU(SizeKt.m1769size3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(40)), Color.m5865copywmQWz5c$default(Other.INSTANCE.m10118getRed0d7_KjU(), 0.7f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.getCircleShape()), Dp.m8823constructorimpl(10)), VideoFileKt.getVideoFile(Icons.Outlined.INSTANCE), null, ColorFilter.Companion.m5907tintxETnrds$default(ColorFilter.INSTANCE, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getBackground(), 0, 2, null), null, null, 0, null, null, composer, 0, XMPPTCPConnection.PacketWriter.QUEUE_SIZE);
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
    public static final k0 lambda_331152681$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(331152681, i10, -1, "cu.todus.android.uiCompose.main.screen.dataPreferences.ComposableSingletons$DataPreferencesScreenKt.lambda$331152681.<anonymous> (DataPreferencesScreen.kt:71)");
            }
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, StringResources_androidKt.stringResource(R.string.data_usage_and_storage, composer, 0), MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getTitleSmall(), 0L, 0, 0, composer, 0, 57);
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
    public static final k0 lambda_562341982$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(562341982, i10, -1, "cu.todus.android.uiCompose.main.screen.dataPreferences.ComposableSingletons$DataPreferencesScreenKt.lambda$562341982.<anonymous> (DataPreferencesScreen.kt:162)");
            }
            Z17PictureKt.m10278Z17BasePictureC8z9wKI(PaddingKt.m1725padding3ABfNKs(BackgroundKt.m1204backgroundbw27NRU(SizeKt.m1769size3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(40)), Color.m5865copywmQWz5c$default(Other.INSTANCE.m10118getRed0d7_KjU(), 0.7f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.getCircleShape()), Dp.m8823constructorimpl(10)), VideoFileKt.getVideoFile(Icons.Outlined.INSTANCE), null, ColorFilter.Companion.m5907tintxETnrds$default(ColorFilter.INSTANCE, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getBackground(), 0, 2, null), null, null, 0, null, null, composer, 0, XMPPTCPConnection.PacketWriter.QUEUE_SIZE);
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
    public static final k0 lambda_656646242$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(656646242, i10, -1, "cu.todus.android.uiCompose.main.screen.dataPreferences.ComposableSingletons$DataPreferencesScreenKt.lambda$656646242.<anonymous> (DataPreferencesScreen.kt:261)");
            }
            Z17PictureKt.m10278Z17BasePictureC8z9wKI(PaddingKt.m1725padding3ABfNKs(BackgroundKt.m1204backgroundbw27NRU(SizeKt.m1769size3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(40)), Color.m5865copywmQWz5c$default(Other.INSTANCE.m10118getRed0d7_KjU(), 0.7f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.getCircleShape()), Dp.m8823constructorimpl(10)), ImageKt.getImage(Icons.Outlined.INSTANCE), null, ColorFilter.Companion.m5907tintxETnrds$default(ColorFilter.INSTANCE, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getBackground(), 0, 2, null), null, null, 0, null, null, composer, 0, XMPPTCPConnection.PacketWriter.QUEUE_SIZE);
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
    public static final k0 lambda_750950502$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(750950502, i10, -1, "cu.todus.android.uiCompose.main.screen.dataPreferences.ComposableSingletons$DataPreferencesScreenKt.lambda$750950502.<anonymous> (DataPreferencesScreen.kt:349)");
            }
            Z17PictureKt.m10278Z17BasePictureC8z9wKI(PaddingKt.m1725padding3ABfNKs(BackgroundKt.m1204backgroundbw27NRU(SizeKt.m1769size3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(40)), Color.m5865copywmQWz5c$default(Other.INSTANCE.m10118getRed0d7_KjU(), 0.7f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.getCircleShape()), Dp.m8823constructorimpl(10)), InsertDriveFileKt.getInsertDriveFile(Icons.Outlined.INSTANCE), null, ColorFilter.Companion.m5907tintxETnrds$default(ColorFilter.INSTANCE, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getBackground(), 0, 2, null), null, null, 0, null, null, composer, 0, XMPPTCPConnection.PacketWriter.QUEUE_SIZE);
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
    public static final k0 lambda__1443685276$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1443685276, i10, -1, "cu.todus.android.uiCompose.main.screen.dataPreferences.ComposableSingletons$DataPreferencesScreenKt.lambda$-1443685276.<anonymous> (DataPreferencesScreen.kt:305)");
            }
            Z17PictureKt.m10278Z17BasePictureC8z9wKI(PaddingKt.m1725padding3ABfNKs(BackgroundKt.m1204backgroundbw27NRU(SizeKt.m1769size3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(40)), Color.m5865copywmQWz5c$default(Other.INSTANCE.m10118getRed0d7_KjU(), 0.7f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.getCircleShape()), Dp.m8823constructorimpl(10)), AudioFileKt.getAudioFile(Icons.Outlined.INSTANCE), null, ColorFilter.Companion.m5907tintxETnrds$default(ColorFilter.INSTANCE, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getBackground(), 0, 2, null), null, null, 0, null, null, composer, 0, XMPPTCPConnection.PacketWriter.QUEUE_SIZE);
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
    public static final k0 lambda__1537989536$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1537989536, i10, -1, "cu.todus.android.uiCompose.main.screen.dataPreferences.ComposableSingletons$DataPreferencesScreenKt.lambda$-1537989536.<anonymous> (DataPreferencesScreen.kt:206)");
            }
            Z17PictureKt.m10278Z17BasePictureC8z9wKI(PaddingKt.m1725padding3ABfNKs(BackgroundKt.m1204backgroundbw27NRU(SizeKt.m1769size3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(40)), Color.m5865copywmQWz5c$default(Other.INSTANCE.m10118getRed0d7_KjU(), 0.7f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.getCircleShape()), Dp.m8823constructorimpl(10)), AudioFileKt.getAudioFile(Icons.Outlined.INSTANCE), null, ColorFilter.Companion.m5907tintxETnrds$default(ColorFilter.INSTANCE, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getBackground(), 0, 2, null), null, null, 0, null, null, composer, 0, XMPPTCPConnection.PacketWriter.QUEUE_SIZE);
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
    public static final k0 lambda__1960766284$lambda$0(SliderState sliderState, Composer composer, int i10) {
        int i11;
        kotlin.jvm.internal.y.i(sliderState, "sliderState");
        if ((i10 & 6) == 0) {
            i11 = i10 | ((i10 & 8) == 0 ? composer.changed(sliderState) : composer.changedInstance(sliderState) ? 4 : 2);
        } else {
            i11 = i10;
        }
        if (composer.shouldExecute((i11 & 19) != 18, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1960766284, i11, -1, "cu.todus.android.uiCompose.main.screen.dataPreferences.ComposableSingletons$DataPreferencesScreenKt.lambda$-1960766284.<anonymous> (DataPreferencesScreen.kt:476)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            Modifier modifierC = defpackage.b0.C(companion, 0.0f, null, 3, null);
            float fM8823constructorimpl = Dp.m8823constructorimpl(1);
            Color.Companion companion2 = Color.INSTANCE;
            Modifier modifierM1725padding3ABfNKs = PaddingKt.m1725padding3ABfNKs(BackgroundKt.m1205backgroundbw27NRU$default(BorderKt.m1216borderxT4_qwU(modifierC, fM8823constructorimpl, Color.m5865copywmQWz5c$default(companion2.m5898getLightGray0d7_KjU(), 0.4f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.getCircleShape()), companion2.m5903getWhite0d7_KjU(), null, 2, null), Dp.m8823constructorimpl((float) 3.5d));
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getCenterStart(), false);
            int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierM1725padding3ABfNKs);
            ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
            lb.a constructor = companion3.getConstructor();
            if (!defpackage.r.a(composer.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor);
            } else {
                composer.useNode();
            }
            Composer composerM5176constructorimpl = Updater.m5176constructorimpl(composer);
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion3.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl, companion3.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion3.getSetModifier());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            Modifier modifierZ = defpackage.b0.z(companion, sliderState, 0.0f, null, 6, null);
            Brush.Companion companion4 = Brush.INSTANCE;
            Other other = Other.INSTANCE;
            BoxKt.Box(BackgroundKt.background$default(modifierZ, Brush.Companion.m5821linearGradientmHitzGk$default(companion4, va.w.q(Color.m5856boximpl(Color.m5865copywmQWz5c$default(other.m10111getGreen0d7_KjU(), 0.7f, 0.0f, 0.0f, 0.0f, 14, null)), Color.m5856boximpl(Color.m5865copywmQWz5c$default(other.m10118getRed0d7_KjU(), 0.7f, 0.0f, 0.0f, 0.0f, 14, null))), 0L, 0L, 0, 14, (Object) null), null, 0.0f, 6, null), composer, 0);
            composer.endNode();
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
    public static final k0 lambda__346367387$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-346367387, i10, -1, "cu.todus.android.uiCompose.main.screen.dataPreferences.ComposableSingletons$DataPreferencesScreenKt.lambda$-346367387.<anonymous> (DataPreferencesScreen.kt:327)");
            }
            Z17PictureKt.m10278Z17BasePictureC8z9wKI(PaddingKt.m1725padding3ABfNKs(BackgroundKt.m1204backgroundbw27NRU(SizeKt.m1769size3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(40)), Color.m5865copywmQWz5c$default(Other.INSTANCE.m10118getRed0d7_KjU(), 0.7f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.getCircleShape()), Dp.m8823constructorimpl(10)), AudioFileKt.getAudioFile(Icons.Outlined.INSTANCE), null, ColorFilter.Companion.m5907tintxETnrds$default(ColorFilter.INSTANCE, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getBackground(), 0, 2, null), null, null, 0, null, null, composer, 0, XMPPTCPConnection.PacketWriter.QUEUE_SIZE);
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
    public static final k0 lambda__440671647$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-440671647, i10, -1, "cu.todus.android.uiCompose.main.screen.dataPreferences.ComposableSingletons$DataPreferencesScreenKt.lambda$-440671647.<anonymous> (DataPreferencesScreen.kt:228)");
            }
            Z17PictureKt.m10278Z17BasePictureC8z9wKI(PaddingKt.m1725padding3ABfNKs(BackgroundKt.m1204backgroundbw27NRU(SizeKt.m1769size3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(40)), Color.m5865copywmQWz5c$default(Other.INSTANCE.m10118getRed0d7_KjU(), 0.7f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.getCircleShape()), Dp.m8823constructorimpl(10)), androidx.compose.material.icons.automirrored.outlined.InsertDriveFileKt.getInsertDriveFile(Icons.AutoMirrored.Outlined.INSTANCE), null, ColorFilter.Companion.m5907tintxETnrds$default(ColorFilter.INSTANCE, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getBackground(), 0, 2, null), null, null, 0, null, null, composer, 0, XMPPTCPConnection.PacketWriter.QUEUE_SIZE);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: renamed from: getLambda$-1443685276$app_productionPFast, reason: not valid java name */
    public final Function2 m9928getLambda$1443685276$app_productionPFast() {
        return f219lambda$1443685276;
    }

    /* JADX INFO: renamed from: getLambda$-1537989536$app_productionPFast, reason: not valid java name */
    public final Function2 m9929getLambda$1537989536$app_productionPFast() {
        return f220lambda$1537989536;
    }

    /* JADX INFO: renamed from: getLambda$-1960766284$app_productionPFast, reason: not valid java name */
    public final Function3 m9930getLambda$1960766284$app_productionPFast() {
        return f221lambda$1960766284;
    }

    /* JADX INFO: renamed from: getLambda$-346367387$app_productionPFast, reason: not valid java name */
    public final Function2 m9931getLambda$346367387$app_productionPFast() {
        return f222lambda$346367387;
    }

    /* JADX INFO: renamed from: getLambda$-440671647$app_productionPFast, reason: not valid java name */
    public final Function2 m9932getLambda$440671647$app_productionPFast() {
        return f223lambda$440671647;
    }

    public final Function2 getLambda$1096798119$app_productionPFast() {
        return lambda$1096798119;
    }

    public final Function3 getLambda$1587491476$app_productionPFast() {
        return lambda$1587491476;
    }

    public final Function2 getLambda$1659659871$app_productionPFast() {
        return lambda$1659659871;
    }

    public final Function2 getLambda$1753964131$app_productionPFast() {
        return lambda$1753964131;
    }

    public final Function2 getLambda$331152681$app_productionPFast() {
        return lambda$331152681;
    }

    public final Function2 getLambda$562341982$app_productionPFast() {
        return lambda$562341982;
    }

    public final Function2 getLambda$656646242$app_productionPFast() {
        return lambda$656646242;
    }

    public final Function2 getLambda$750950502$app_productionPFast() {
        return lambda$750950502;
    }
}
