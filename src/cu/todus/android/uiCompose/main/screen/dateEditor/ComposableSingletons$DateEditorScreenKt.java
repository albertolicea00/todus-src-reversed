package cu.todus.android.uiCompose.main.screen.dateEditor;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import cu.todus.android.R;
import cu.z17.views.label.Z17LabelKt;
import cu.z17.views.picture.Z17PictureKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
public final class ComposableSingletons$DateEditorScreenKt {
    public static final ComposableSingletons$DateEditorScreenKt INSTANCE = new ComposableSingletons$DateEditorScreenKt();

    /* JADX INFO: renamed from: lambda$-88496036, reason: not valid java name */
    private static Function2 f226lambda$88496036 = ComposableLambdaKt.composableLambdaInstance(-88496036, false, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.dateEditor.a
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$DateEditorScreenKt.lambda__88496036$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-1329001695, reason: not valid java name */
    private static Function2 f224lambda$1329001695 = ComposableLambdaKt.composableLambdaInstance(-1329001695, false, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.dateEditor.b
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$DateEditorScreenKt.lambda__1329001695$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-377169856, reason: not valid java name */
    private static Function2 f225lambda$377169856 = ComposableLambdaKt.composableLambdaInstance(-377169856, false, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.dateEditor.c
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$DateEditorScreenKt.lambda__377169856$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 lambda__1329001695$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1329001695, i10, -1, "cu.todus.android.uiCompose.main.screen.dateEditor.ComposableSingletons$DateEditorScreenKt.lambda$-1329001695.<anonymous> (DateEditorScreen.kt:131)");
            }
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, StringResources_androidKt.stringResource(R.string.send, composer, 0), null, Color.INSTANCE.m5903getWhite0d7_KjU(), 0, 0, composer, 3072, 53);
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
    public static final k0 lambda__377169856$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-377169856, i10, -1, "cu.todus.android.uiCompose.main.screen.dateEditor.ComposableSingletons$DateEditorScreenKt.lambda$-377169856.<anonymous> (DateEditorScreen.kt:137)");
            }
            Z17PictureKt.m10278Z17BasePictureC8z9wKI(SizeKt.m1769size3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(25)), Integer.valueOf(R.drawable.send_icon), null, ColorFilter.Companion.m5907tintxETnrds$default(ColorFilter.INSTANCE, Color.INSTANCE.m5903getWhite0d7_KjU(), 0, 2, null), null, "Send", 0, null, null, composer, 199686, 468);
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
    public static final k0 lambda__88496036$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-88496036, i10, -1, "cu.todus.android.uiCompose.main.screen.dateEditor.ComposableSingletons$DateEditorScreenKt.lambda$-88496036.<anonymous> (DateEditorScreen.kt:116)");
            }
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, StringResources_androidKt.stringResource(R.string.create_date, composer, 0), MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getTitleSmall(), 0L, 0, 0, composer, 0, 57);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: renamed from: getLambda$-1329001695$app_productionPFast, reason: not valid java name */
    public final Function2 m9933getLambda$1329001695$app_productionPFast() {
        return f224lambda$1329001695;
    }

    /* JADX INFO: renamed from: getLambda$-377169856$app_productionPFast, reason: not valid java name */
    public final Function2 m9934getLambda$377169856$app_productionPFast() {
        return f225lambda$377169856;
    }

    /* JADX INFO: renamed from: getLambda$-88496036$app_productionPFast, reason: not valid java name */
    public final Function2 m9935getLambda$88496036$app_productionPFast() {
        return f226lambda$88496036;
    }
}
