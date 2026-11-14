package cu.z17.views.imageEditor.sections;

import android.graphics.Bitmap;
import android.net.Uri;
import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.media3.exoplayer.RendererCapabilities;
import cu.todus.android.xmpp.iq.privacy.PrivacyGetIQ;
import cu.z17.views.imageEditor.sections.EditorAnimateVisibilityKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.y;
import lb.a;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a@\u0010\t\u001a\u00020\u00032\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0002\b\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0007¢\u0006\u0004\b\t\u0010\n\u001a@\u0010\t\u001a\u00020\u00032\b\u0010\u0001\u001a\u0004\u0018\u00010\u000b2\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0002\b\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0007¢\u0006\u0004\b\t\u0010\f¨\u0006\r"}, d2 = {"Landroid/graphics/Bitmap;", PrivacyGetIQ.PRIVACY_PROFILE_LAST, "Lkotlin/Function1;", "Lua/k0;", "Landroidx/compose/runtime/Composable;", "content", "Lkotlin/Function0;", "", "show", "EditorAnimateVisibility", "(Landroid/graphics/Bitmap;Lkotlin/jvm/functions/Function3;Llb/a;Landroidx/compose/runtime/Composer;I)V", "Landroid/net/Uri;", "(Landroid/net/Uri;Lkotlin/jvm/functions/Function3;Llb/a;Landroidx/compose/runtime/Composer;I)V", "views_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class EditorAnimateVisibilityKt {
    @Composable
    @ComposableInferredTarget(scheme = "[0[0]]")
    public static final void EditorAnimateVisibility(final Bitmap bitmap, final Function3 content, final a show, Composer composer, final int i10) {
        int i11;
        y.i(content, "content");
        y.i(show, "show");
        Composer composerStartRestartGroup = composer.startRestartGroup(320896771);
        if ((i10 & 6) == 0) {
            i11 = (composerStartRestartGroup.changedInstance(bitmap) ? 4 : 2) | i10;
        } else {
            i11 = i10;
        }
        if ((i10 & 48) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(content) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(show) ? 256 : 128;
        }
        if (composerStartRestartGroup.shouldExecute((i11 & 147) != 146, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(320896771, i11, -1, "cu.z17.views.imageEditor.sections.EditorAnimateVisibility (EditorAnimateVisibility.kt:15)");
            }
            AnimatedVisibilityKt.AnimatedVisibility(((Boolean) show.invoke()).booleanValue(), (Modifier) null, EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null), EnterExitTransitionKt.fadeOut$default(AnimationSpecKt.tween$default(100, 0, null, 6, null), 0.0f, 2, null), (String) null, ComposableLambdaKt.rememberComposableLambda(-243829285, true, new Function3() { // from class: e9.c
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return EditorAnimateVisibilityKt.EditorAnimateVisibility$lambda$1(bitmap, content, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 200064, 18);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: e9.d
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return EditorAnimateVisibilityKt.EditorAnimateVisibility$lambda$2(bitmap, content, show, i10, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    public static final k0 EditorAnimateVisibility$lambda$1(Bitmap bitmap, Function3 function3, AnimatedVisibilityScope AnimatedVisibility, Composer composer, int i10) {
        y.i(AnimatedVisibility, "$this$AnimatedVisibility");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-243829285, i10, -1, "cu.z17.views.imageEditor.sections.EditorAnimateVisibility.<anonymous> (EditorAnimateVisibility.kt:21)");
        }
        if (bitmap == null) {
            composer.startReplaceGroup(-1128514817);
        } else {
            composer.startReplaceGroup(-1128514816);
            function3.invoke(bitmap, composer, 0);
        }
        composer.endReplaceGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 EditorAnimateVisibility$lambda$2(Bitmap bitmap, Function3 function3, a aVar, int i10, Composer composer, int i11) {
        EditorAnimateVisibility(bitmap, function3, aVar, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1));
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    public static final k0 EditorAnimateVisibility$lambda$4(Uri uri, Function3 function3, AnimatedVisibilityScope AnimatedVisibility, Composer composer, int i10) {
        y.i(AnimatedVisibility, "$this$AnimatedVisibility");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(149015342, i10, -1, "cu.z17.views.imageEditor.sections.EditorAnimateVisibility.<anonymous> (EditorAnimateVisibility.kt:38)");
        }
        if (uri == null) {
            composer.startReplaceGroup(-1680113460);
        } else {
            composer.startReplaceGroup(-1680113459);
            function3.invoke(uri, composer, 0);
        }
        composer.endReplaceGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 EditorAnimateVisibility$lambda$5(Uri uri, Function3 function3, a aVar, int i10, Composer composer, int i11) {
        EditorAnimateVisibility(uri, function3, aVar, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1));
        return k0.f43947a;
    }

    @Composable
    @ComposableInferredTarget(scheme = "[0[0]]")
    public static final void EditorAnimateVisibility(final Uri uri, final Function3 content, final a show, Composer composer, final int i10) {
        int i11;
        y.i(content, "content");
        y.i(show, "show");
        Composer composerStartRestartGroup = composer.startRestartGroup(464622342);
        if ((i10 & 6) == 0) {
            i11 = (composerStartRestartGroup.changedInstance(uri) ? 4 : 2) | i10;
        } else {
            i11 = i10;
        }
        if ((i10 & 48) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(content) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(show) ? 256 : 128;
        }
        if (composerStartRestartGroup.shouldExecute((i11 & 147) != 146, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(464622342, i11, -1, "cu.z17.views.imageEditor.sections.EditorAnimateVisibility (EditorAnimateVisibility.kt:32)");
            }
            AnimatedVisibilityKt.AnimatedVisibility(((Boolean) show.invoke()).booleanValue(), (Modifier) null, EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null), EnterExitTransitionKt.fadeOut$default(AnimationSpecKt.tween$default(100, 0, null, 6, null), 0.0f, 2, null), (String) null, ComposableLambdaKt.rememberComposableLambda(149015342, true, new Function3() { // from class: e9.a
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return EditorAnimateVisibilityKt.EditorAnimateVisibility$lambda$4(uri, content, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 200064, 18);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: e9.b
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return EditorAnimateVisibilityKt.EditorAnimateVisibility$lambda$5(uri, content, show, i10, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
