package cu.z17.views.imageEditor;

import android.graphics.Bitmap;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import cu.z17.views.imageEditor.sections.viewer.ViewerKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$Z17ImageEditorKt {
    public static final ComposableSingletons$Z17ImageEditorKt INSTANCE = new ComposableSingletons$Z17ImageEditorKt();

    /* JADX INFO: renamed from: lambda$-1781389051, reason: not valid java name */
    private static Function3 f376lambda$1781389051 = ComposableLambdaKt.composableLambdaInstance(-1781389051, false, new Function3() { // from class: cu.z17.views.imageEditor.a
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$Z17ImageEditorKt.lambda__1781389051$lambda$0((Bitmap) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 lambda__1781389051$lambda$0(Bitmap it, Composer composer, int i10) {
        kotlin.jvm.internal.y.i(it, "it");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1781389051, i10, -1, "cu.z17.views.imageEditor.ComposableSingletons$Z17ImageEditorKt.lambda$-1781389051.<anonymous> (Z17ImageEditor.kt:199)");
        }
        ViewerKt.Viewer(it, composer, i10 & 14);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: renamed from: getLambda$-1781389051$views_release, reason: not valid java name */
    public final Function3 m10147getLambda$1781389051$views_release() {
        return f376lambda$1781389051;
    }
}
