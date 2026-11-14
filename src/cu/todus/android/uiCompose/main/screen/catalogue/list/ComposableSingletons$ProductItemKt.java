package cu.todus.android.uiCompose.main.screen.catalogue.list;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.outlined.DeleteKt;
import androidx.compose.material.icons.outlined.EditKt;
import androidx.compose.material.icons.outlined.ShareKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.unit.Dp;
import cu.todus.android.uiCompose.main.screen.catalogue.list.ComposableSingletons$ProductItemKt;
import cu.z17.views.picture.Z17PictureKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
public final class ComposableSingletons$ProductItemKt {
    public static final ComposableSingletons$ProductItemKt INSTANCE = new ComposableSingletons$ProductItemKt();

    /* JADX INFO: renamed from: lambda$-2147322427, reason: not valid java name */
    private static Function2 f174lambda$2147322427 = ComposableLambdaKt.composableLambdaInstance(-2147322427, false, new Function2() { // from class: o7.a
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$ProductItemKt.lambda__2147322427$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-1912907204, reason: not valid java name */
    private static Function2 f173lambda$1912907204 = ComposableLambdaKt.composableLambdaInstance(-1912907204, false, new Function2() { // from class: o7.b
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$ProductItemKt.lambda__1912907204$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-690304579, reason: not valid java name */
    private static Function2 f175lambda$690304579 = ComposableLambdaKt.composableLambdaInstance(-690304579, false, new Function2() { // from class: o7.c
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$ProductItemKt.lambda__690304579$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 lambda__1912907204$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1912907204, i10, -1, "cu.todus.android.uiCompose.main.screen.catalogue.list.ComposableSingletons$ProductItemKt.lambda$-1912907204.<anonymous> (ProductItem.kt:123)");
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

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 lambda__2147322427$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2147322427, i10, -1, "cu.todus.android.uiCompose.main.screen.catalogue.list.ComposableSingletons$ProductItemKt.lambda$-2147322427.<anonymous> (ProductItem.kt:111)");
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
    public static final k0 lambda__690304579$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-690304579, i10, -1, "cu.todus.android.uiCompose.main.screen.catalogue.list.ComposableSingletons$ProductItemKt.lambda$-690304579.<anonymous> (ProductItem.kt:135)");
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

    /* JADX INFO: renamed from: getLambda$-1912907204$app_productionPFast, reason: not valid java name */
    public final Function2 m9844getLambda$1912907204$app_productionPFast() {
        return f173lambda$1912907204;
    }

    /* JADX INFO: renamed from: getLambda$-2147322427$app_productionPFast, reason: not valid java name */
    public final Function2 m9845getLambda$2147322427$app_productionPFast() {
        return f174lambda$2147322427;
    }

    /* JADX INFO: renamed from: getLambda$-690304579$app_productionPFast, reason: not valid java name */
    public final Function2 m9846getLambda$690304579$app_productionPFast() {
        return f175lambda$690304579;
    }
}
