package cu.todus.android.uiCompose.main.screen.catalogue.preview;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.outlined.ContentCopyKt;
import androidx.compose.material.icons.outlined.DeleteKt;
import androidx.compose.material.icons.outlined.EditKt;
import androidx.compose.material.icons.outlined.ShareKt;
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
import cu.todus.android.R;
import cu.z17.views.label.Z17LabelKt;
import cu.z17.views.picture.Z17PictureKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
public final class ComposableSingletons$ProductPreviewScreenKt {
    public static final ComposableSingletons$ProductPreviewScreenKt INSTANCE = new ComposableSingletons$ProductPreviewScreenKt();
    private static Function2 lambda$1442136908 = ComposableLambdaKt.composableLambdaInstance(1442136908, false, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.catalogue.preview.a
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$ProductPreviewScreenKt.lambda_1442136908$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-1850927923, reason: not valid java name */
    private static Function2 f179lambda$1850927923 = ComposableLambdaKt.composableLambdaInstance(-1850927923, false, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.catalogue.preview.b
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$ProductPreviewScreenKt.lambda__1850927923$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-815352458, reason: not valid java name */
    private static Function2 f180lambda$815352458 = ComposableLambdaKt.composableLambdaInstance(-815352458, false, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.catalogue.preview.c
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$ProductPreviewScreenKt.lambda__815352458$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2 lambda$556130773 = ComposableLambdaKt.composableLambdaInstance(556130773, false, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.catalogue.preview.d
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$ProductPreviewScreenKt.lambda_556130773$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2 lambda$223641225 = ComposableLambdaKt.composableLambdaInstance(223641225, false, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.catalogue.preview.e
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$ProductPreviewScreenKt.lambda_223641225$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2 lambda$1092458354 = ComposableLambdaKt.composableLambdaInstance(1092458354, false, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.catalogue.preview.f
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$ProductPreviewScreenKt.lambda_1092458354$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 lambda_1092458354$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1092458354, i10, -1, "cu.todus.android.uiCompose.main.screen.catalogue.preview.ComposableSingletons$ProductPreviewScreenKt.lambda$1092458354.<anonymous> (ProductPreviewScreen.kt:519)");
            }
            IconKt.m3298Iconww6aTOc(ShareKt.getShare(Icons.Outlined.INSTANCE), "", SizeKt.m1769size3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(30)), MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOnBackground(), composer, 432, 0);
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
    public static final k0 lambda_1442136908$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1442136908, i10, -1, "cu.todus.android.uiCompose.main.screen.catalogue.preview.ComposableSingletons$ProductPreviewScreenKt.lambda$1442136908.<anonymous> (ProductPreviewScreen.kt:129)");
            }
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, StringResources_androidKt.stringResource(R.string.details, composer, 0), MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getTitleSmall(), 0L, 0, 0, composer, 0, 57);
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
    public static final k0 lambda_223641225$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(223641225, i10, -1, "cu.todus.android.uiCompose.main.screen.catalogue.preview.ComposableSingletons$ProductPreviewScreenKt.lambda$223641225.<anonymous> (ProductPreviewScreen.kt:492)");
            }
            IconKt.m3298Iconww6aTOc(ContentCopyKt.getContentCopy(Icons.Outlined.INSTANCE), "", SizeKt.m1769size3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(30)), MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOnBackground(), composer, 432, 0);
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
    public static final k0 lambda_556130773$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(556130773, i10, -1, "cu.todus.android.uiCompose.main.screen.catalogue.preview.ComposableSingletons$ProductPreviewScreenKt.lambda$556130773.<anonymous> (ProductPreviewScreen.kt:435)");
            }
            Z17PictureKt.m10278Z17BasePictureC8z9wKI(SizeKt.m1769size3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(20)), DeleteKt.getDelete(Icons.Outlined.INSTANCE), null, ColorFilter.Companion.m5907tintxETnrds$default(ColorFilter.INSTANCE, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getPrimary(), 0, 2, null), null, "delete btn", 0, null, null, composer, 196614, 468);
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
    public static final k0 lambda__1850927923$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1850927923, i10, -1, "cu.todus.android.uiCompose.main.screen.catalogue.preview.ComposableSingletons$ProductPreviewScreenKt.lambda$-1850927923.<anonymous> (ProductPreviewScreen.kt:401)");
            }
            Z17PictureKt.m10278Z17BasePictureC8z9wKI(SizeKt.m1769size3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(20)), ShareKt.getShare(Icons.Outlined.INSTANCE), null, ColorFilter.Companion.m5907tintxETnrds$default(ColorFilter.INSTANCE, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOnBackground(), 0, 2, null), null, "share btn", 0, null, null, composer, 196614, 468);
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
    public static final k0 lambda__815352458$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-815352458, i10, -1, "cu.todus.android.uiCompose.main.screen.catalogue.preview.ComposableSingletons$ProductPreviewScreenKt.lambda$-815352458.<anonymous> (ProductPreviewScreen.kt:423)");
            }
            Z17PictureKt.m10278Z17BasePictureC8z9wKI(SizeKt.m1769size3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(20)), EditKt.getEdit(Icons.Outlined.INSTANCE), null, ColorFilter.Companion.m5907tintxETnrds$default(ColorFilter.INSTANCE, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOnBackground(), 0, 2, null), null, "edit btn", 0, null, null, composer, 196614, 468);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: renamed from: getLambda$-1850927923$app_productionPFast, reason: not valid java name */
    public final Function2 m9850getLambda$1850927923$app_productionPFast() {
        return f179lambda$1850927923;
    }

    /* JADX INFO: renamed from: getLambda$-815352458$app_productionPFast, reason: not valid java name */
    public final Function2 m9851getLambda$815352458$app_productionPFast() {
        return f180lambda$815352458;
    }

    public final Function2 getLambda$1092458354$app_productionPFast() {
        return lambda$1092458354;
    }

    public final Function2 getLambda$1442136908$app_productionPFast() {
        return lambda$1442136908;
    }

    public final Function2 getLambda$223641225$app_productionPFast() {
        return lambda$223641225;
    }

    public final Function2 getLambda$556130773$app_productionPFast() {
        return lambda$556130773;
    }
}
