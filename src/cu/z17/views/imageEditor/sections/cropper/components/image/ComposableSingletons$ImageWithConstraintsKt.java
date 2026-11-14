package cu.z17.views.imageEditor.sections.cropper.components.image;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import cu.z17.views.imageEditor.sections.cropper.components.image.ComposableSingletons$ImageWithConstraintsKt;
import cu.z17.views.imageEditor.sections.cropper.components.image.ImageScope;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.y;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$ImageWithConstraintsKt {
    public static final ComposableSingletons$ImageWithConstraintsKt INSTANCE = new ComposableSingletons$ImageWithConstraintsKt();

    /* JADX INFO: renamed from: lambda$-1210636210, reason: not valid java name */
    private static Function3 f378lambda$1210636210 = ComposableLambdaKt.composableLambdaInstance(-1210636210, false, new Function3() { // from class: h9.a
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$ImageWithConstraintsKt.lambda__1210636210$lambda$0((ImageScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    public static final k0 lambda__1210636210$lambda$0(ImageScope imageScope, Composer composer, int i10) {
        y.i(imageScope, "<this>");
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1210636210, i10, -1, "cu.z17.views.imageEditor.sections.cropper.components.image.ComposableSingletons$ImageWithConstraintsKt.lambda$-1210636210.<anonymous> (ImageWithConstraints.kt:75)");
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: renamed from: getLambda$-1210636210$views_release, reason: not valid java name */
    public final Function3 m10164getLambda$1210636210$views_release() {
        return f378lambda$1210636210;
    }
}
