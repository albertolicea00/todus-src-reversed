package cu.todus.android.uiCompose.shared.animations.crossfade;

import androidx.compose.animation.CrossfadeKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.exifinterface.media.ExifInterface;
import cu.todus.android.uiCompose.shared.animations.crossfade.CrossFadeKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.y;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a6\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u00002\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0002\b\u0004H\u0007¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "targetState", "Lkotlin/Function1;", "Lua/k0;", "Landroidx/compose/runtime/Composable;", "content", "CrossFade", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class CrossFadeKt {
    @Composable
    public static final <T> void CrossFade(T t10, final Function3 content, Composer composer, final int i10) {
        final int i11;
        final T t11;
        y.i(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(1397500494);
        if ((i10 & 6) == 0) {
            i11 = ((i10 & 8) == 0 ? composerStartRestartGroup.changed(t10) : composerStartRestartGroup.changedInstance(t10) ? 4 : 2) | i10;
        } else {
            i11 = i10;
        }
        if ((i10 & 48) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(content) ? 32 : 16;
        }
        if (composerStartRestartGroup.shouldExecute((i11 & 19) != 18, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1397500494, i11, -1, "cu.todus.android.uiCompose.shared.animations.crossfade.CrossFade (CrossFade.kt:12)");
            }
            t11 = t10;
            CrossfadeKt.Crossfade(t11, (Modifier) null, AnimationSpecKt.tween$default(300, 0, EasingKt.getLinearEasing(), 2, null), "crossfade", ComposableLambdaKt.rememberComposableLambda(805332761, true, new Function3() { // from class: n8.a
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return CrossFadeKt.CrossFade$lambda$0(content, i11, obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, (i11 & 8) | 27648 | (i11 & 14), 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            t11 = t10;
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: n8.b
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CrossFadeKt.CrossFade$lambda$1(t11, content, i10, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    public static final k0 CrossFade$lambda$0(Function3 function3, int i10, Object obj, Composer composer, int i11) {
        if ((i11 & 6) == 0) {
            i11 |= (i11 & 8) == 0 ? composer.changed(obj) : composer.changedInstance(obj) ? 4 : 2;
        }
        if (composer.shouldExecute((i11 & 19) != 18, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(805332761, i11, -1, "cu.todus.android.uiCompose.shared.animations.crossfade.CrossFade.<anonymous> (CrossFade.kt:20)");
            }
            function3.invoke(obj, composer, Integer.valueOf((i10 & 8) | (i11 & 14)));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 CrossFade$lambda$1(Object obj, Function3 function3, int i10, Composer composer, int i11) {
        CrossFade(obj, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1));
        return k0.f43947a;
    }
}
