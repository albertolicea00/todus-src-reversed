package cu.todus.android.uiCompose.main.screen.createGroup;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.outlined.NavigateNextKt;
import androidx.compose.material.icons.outlined.SearchKt;
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
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
public final class ComposableSingletons$CreateGroupStep1SelectionScreenKt {
    public static final ComposableSingletons$CreateGroupStep1SelectionScreenKt INSTANCE = new ComposableSingletons$CreateGroupStep1SelectionScreenKt();

    /* JADX INFO: renamed from: lambda$-1337285110, reason: not valid java name */
    private static Function2 f216lambda$1337285110 = ComposableLambdaKt.composableLambdaInstance(-1337285110, false, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.createGroup.c
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$CreateGroupStep1SelectionScreenKt.lambda__1337285110$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-240721379, reason: not valid java name */
    private static Function2 f217lambda$240721379 = ComposableLambdaKt.composableLambdaInstance(-240721379, false, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.createGroup.d
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$CreateGroupStep1SelectionScreenKt.lambda__240721379$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2 lambda$689225661 = ComposableLambdaKt.composableLambdaInstance(689225661, false, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.createGroup.e
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$CreateGroupStep1SelectionScreenKt.lambda_689225661$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-1179961497, reason: not valid java name */
    private static Function3 f215lambda$1179961497 = ComposableLambdaKt.composableLambdaInstance(-1179961497, false, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.createGroup.f
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$CreateGroupStep1SelectionScreenKt.lambda__1179961497$lambda$0((LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });
    private static Function3 lambda$369711966 = ComposableLambdaKt.composableLambdaInstance(369711966, false, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.createGroup.g
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$CreateGroupStep1SelectionScreenKt.lambda_369711966$lambda$0((LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 lambda_369711966$lambda$0(LazyItemScope item, Composer composer, int i10) {
        kotlin.jvm.internal.y.i(item, "$this$item");
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(369711966, i10, -1, "cu.todus.android.uiCompose.main.screen.createGroup.ComposableSingletons$CreateGroupStep1SelectionScreenKt.lambda$369711966.<anonymous> (CreateGroupStep1SelectionScreen.kt:208)");
            }
            SpacerKt.Spacer(SizeKt.m1769size3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(20)), composer, 6);
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
    public static final ua.k0 lambda_689225661$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(689225661, i10, -1, "cu.todus.android.uiCompose.main.screen.createGroup.ComposableSingletons$CreateGroupStep1SelectionScreenKt.lambda$689225661.<anonymous> (CreateGroupStep1SelectionScreen.kt:152)");
            }
            Z17PictureKt.m10278Z17BasePictureC8z9wKI(SizeKt.m1769size3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(25)), NavigateNextKt.getNavigateNext(Icons.Outlined.INSTANCE), null, ColorFilter.Companion.m5907tintxETnrds$default(ColorFilter.INSTANCE, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getBackground(), 0, 2, null), null, "Next screen", 0, null, null, composer, 196614, 468);
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
    public static final ua.k0 lambda__1179961497$lambda$0(LazyItemScope item, Composer composer, int i10) {
        kotlin.jvm.internal.y.i(item, "$this$item");
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1179961497, i10, -1, "cu.todus.android.uiCompose.main.screen.createGroup.ComposableSingletons$CreateGroupStep1SelectionScreenKt.lambda$-1179961497.<anonymous> (CreateGroupStep1SelectionScreen.kt:191)");
            }
            SpacerKt.Spacer(SizeKt.m1769size3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(20)), composer, 6);
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
    public static final ua.k0 lambda__1337285110$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1337285110, i10, -1, "cu.todus.android.uiCompose.main.screen.createGroup.ComposableSingletons$CreateGroupStep1SelectionScreenKt.lambda$-1337285110.<anonymous> (CreateGroupStep1SelectionScreen.kt:116)");
            }
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, StringResources_androidKt.stringResource(R.string.select_members, composer, 0), MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getTitleSmall(), 0L, 0, 0, composer, 0, 57);
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
    public static final ua.k0 lambda__240721379$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-240721379, i10, -1, "cu.todus.android.uiCompose.main.screen.createGroup.ComposableSingletons$CreateGroupStep1SelectionScreenKt.lambda$-240721379.<anonymous> (CreateGroupStep1SelectionScreen.kt:126)");
            }
            IconKt.m3298Iconww6aTOc(SearchKt.getSearch(Icons.Outlined.INSTANCE), "", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOnBackground(), composer, 48, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: renamed from: getLambda$-1179961497$app_productionPFast, reason: not valid java name */
    public final Function3 m9923getLambda$1179961497$app_productionPFast() {
        return f215lambda$1179961497;
    }

    /* JADX INFO: renamed from: getLambda$-1337285110$app_productionPFast, reason: not valid java name */
    public final Function2 m9924getLambda$1337285110$app_productionPFast() {
        return f216lambda$1337285110;
    }

    /* JADX INFO: renamed from: getLambda$-240721379$app_productionPFast, reason: not valid java name */
    public final Function2 m9925getLambda$240721379$app_productionPFast() {
        return f217lambda$240721379;
    }

    public final Function3 getLambda$369711966$app_productionPFast() {
        return lambda$369711966;
    }

    public final Function2 getLambda$689225661$app_productionPFast() {
        return lambda$689225661;
    }
}
