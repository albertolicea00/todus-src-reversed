package cu.z17.views.form;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.res.StringResources_androidKt;
import cu.z17.views.R;
import cu.z17.views.button.Z17ButtonsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$Z17FormKt {
    public static final ComposableSingletons$Z17FormKt INSTANCE = new ComposableSingletons$Z17FormKt();
    private static Function3 lambda$699739717 = ComposableLambdaKt.composableLambdaInstance(699739717, false, new Function3() { // from class: cu.z17.views.form.d
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$Z17FormKt.lambda_699739717$lambda$2((lb.a) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 lambda_699739717$lambda$2(final lb.a onSubmit, Composer composer, int i10) {
        kotlin.jvm.internal.y.i(onSubmit, "onSubmit");
        if ((i10 & 6) == 0) {
            i10 |= composer.changedInstance(onSubmit) ? 4 : 2;
        }
        if (composer.shouldExecute((i10 & 19) != 18, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(699739717, i10, -1, "cu.z17.views.form.ComposableSingletons$Z17FormKt.lambda$699739717.<anonymous> (Z17Form.kt:37)");
            }
            boolean z10 = (i10 & 14) == 4;
            Object objRememberedValue = composer.rememberedValue();
            if (z10 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new lb.a() { // from class: cu.z17.views.form.c
                    @Override // lb.a
                    public final Object invoke() {
                        return ComposableSingletons$Z17FormKt.lambda_699739717$lambda$2$lambda$1$lambda$0(onSubmit);
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
    public static final ua.k0 lambda_699739717$lambda$2$lambda$1$lambda$0(lb.a aVar) {
        aVar.invoke();
        return ua.k0.f43947a;
    }

    public final Function3 getLambda$699739717$views_release() {
        return lambda$699739717;
    }
}
