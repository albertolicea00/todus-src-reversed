package cu.todus.android.uiCompose.main.screen.catalogue.form;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.outlined.CheckKt;
import androidx.compose.material.icons.outlined.LocationOnKt;
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
public final class ComposableSingletons$CatalogueFormScreenKt {
    public static final ComposableSingletons$CatalogueFormScreenKt INSTANCE = new ComposableSingletons$CatalogueFormScreenKt();

    /* JADX INFO: renamed from: lambda$-87413011, reason: not valid java name */
    private static Function2 f172lambda$87413011 = ComposableLambdaKt.composableLambdaInstance(-87413011, false, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.catalogue.form.q0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$CatalogueFormScreenKt.lambda__87413011$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-1681876598, reason: not valid java name */
    private static Function2 f171lambda$1681876598 = ComposableLambdaKt.composableLambdaInstance(-1681876598, false, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.catalogue.form.r0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$CatalogueFormScreenKt.lambda__1681876598$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 lambda__1681876598$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1681876598, i10, -1, "cu.todus.android.uiCompose.main.screen.catalogue.form.ComposableSingletons$CatalogueFormScreenKt.lambda$-1681876598.<anonymous> (CatalogueFormScreen.kt:569)");
            }
            Z17PictureKt.m10278Z17BasePictureC8z9wKI(SizeKt.m1769size3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(25)), CheckKt.getCheck(Icons.Outlined.INSTANCE), null, ColorFilter.Companion.m5907tintxETnrds$default(ColorFilter.INSTANCE, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getBackground(), 0, 2, null), null, "create product btn", 0, null, null, composer, 196614, 468);
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
    public static final ua.k0 lambda__87413011$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-87413011, i10, -1, "cu.todus.android.uiCompose.main.screen.catalogue.form.ComposableSingletons$CatalogueFormScreenKt.lambda$-87413011.<anonymous> (CatalogueFormScreen.kt:497)");
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

    /* JADX INFO: renamed from: getLambda$-1681876598$app_productionPFast, reason: not valid java name */
    public final Function2 m9842getLambda$1681876598$app_productionPFast() {
        return f171lambda$1681876598;
    }

    /* JADX INFO: renamed from: getLambda$-87413011$app_productionPFast, reason: not valid java name */
    public final Function2 m9843getLambda$87413011$app_productionPFast() {
        return f172lambda$87413011;
    }
}
