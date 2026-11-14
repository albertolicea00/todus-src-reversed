package cu.todus.android.uiCompose.main.screen.socialProfile;

import androidx.compose.material3.MaterialTheme;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.res.StringResources_androidKt;
import cu.todus.android.R;
import cu.z17.views.label.Z17LabelKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
public final class ComposableSingletons$SocialProfileScreenKt {
    public static final ComposableSingletons$SocialProfileScreenKt INSTANCE = new ComposableSingletons$SocialProfileScreenKt();

    /* JADX INFO: renamed from: lambda$-1890213888, reason: not valid java name */
    private static Function2 f267lambda$1890213888 = ComposableLambdaKt.composableLambdaInstance(-1890213888, false, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.socialProfile.a
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$SocialProfileScreenKt.lambda__1890213888$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 lambda__1890213888$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1890213888, i10, -1, "cu.todus.android.uiCompose.main.screen.socialProfile.ComposableSingletons$SocialProfileScreenKt.lambda$-1890213888.<anonymous> (SocialProfileScreen.kt:112)");
            }
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, StringResources_androidKt.stringResource(R.string.social_profile, composer, 0), MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getTitleSmall(), 0L, 0, 0, composer, 0, 57);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: renamed from: getLambda$-1890213888$app_productionPFast, reason: not valid java name */
    public final Function2 m9984getLambda$1890213888$app_productionPFast() {
        return f267lambda$1890213888;
    }
}
