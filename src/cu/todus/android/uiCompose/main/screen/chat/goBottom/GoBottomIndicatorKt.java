package cu.todus.android.uiCompose.main.screen.chat.goBottom;

import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ScaleKt;
import androidx.compose.ui.unit.Dp;
import androidx.media3.exoplayer.RendererCapabilities;
import cu.todus.android.uiCompose.main.screen.chat.goBottom.GoBottomIndicatorKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.y;
import lb.a;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a-\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Landroidx/compose/ui/Modifier;", "modifier", "", "enable", "Lkotlin/Function0;", "Lua/k0;", "goBottom", "GoBottomIndicator", "(Landroidx/compose/ui/Modifier;ZLlb/a;Landroidx/compose/runtime/Composer;I)V", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class GoBottomIndicatorKt {
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void GoBottomIndicator(Modifier modifier, boolean z10, final a goBottom, Composer composer, final int i10) {
        int i11;
        final Modifier modifier2;
        final boolean z11;
        y.i(modifier, "modifier");
        y.i(goBottom, "goBottom");
        Composer composerStartRestartGroup = composer.startRestartGroup(-212697277);
        if ((i10 & 6) == 0) {
            i11 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i10;
        } else {
            i11 = i10;
        }
        if ((i10 & 48) == 0) {
            i11 |= composerStartRestartGroup.changed(z10) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(goBottom) ? 256 : 128;
        }
        if (composerStartRestartGroup.shouldExecute((i11 & 147) != 146, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-212697277, i11, -1, "cu.todus.android.uiCompose.main.screen.chat.goBottom.GoBottomIndicator (GoBottomIndicator.kt:22)");
            }
            modifier2 = modifier;
            z11 = z10;
            AnimatedVisibilityKt.AnimatedVisibility(z11, modifier2, EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null), EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null), (String) null, ComposableLambdaKt.rememberComposableLambda(-528304277, true, new Function3() { // from class: r7.b
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return GoBottomIndicatorKt.GoBottomIndicator$lambda$0(goBottom, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i11 >> 3) & 14) | 200064 | ((i11 << 3) & 112), 16);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            modifier2 = modifier;
            z11 = z10;
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: r7.c
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return GoBottomIndicatorKt.GoBottomIndicator$lambda$1(modifier2, z11, goBottom, i10, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 GoBottomIndicator$lambda$0(final a aVar, AnimatedVisibilityScope AnimatedVisibility, Composer composer, int i10) {
        y.i(AnimatedVisibility, "$this$AnimatedVisibility");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-528304277, i10, -1, "cu.todus.android.uiCompose.main.screen.chat.goBottom.GoBottomIndicator.<anonymous> (GoBottomIndicator.kt:29)");
        }
        Modifier modifierM1204backgroundbw27NRU = BackgroundKt.m1204backgroundbw27NRU(PaddingKt.m1725padding3ABfNKs(ScaleKt.scale(Modifier.INSTANCE, 0.75f), Dp.m8823constructorimpl(5)), MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getSurface(), RoundedCornerShapeKt.getCircleShape());
        boolean zChanged = composer.changed(aVar);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new a() { // from class: r7.d
                @Override // lb.a
                public final Object invoke() {
                    return GoBottomIndicatorKt.GoBottomIndicator$lambda$0$0$0(aVar);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        IconButtonKt.IconButton((a) objRememberedValue, modifierM1204backgroundbw27NRU, false, null, null, null, ComposableSingletons$GoBottomIndicatorKt.INSTANCE.getLambda$1816906893$app_productionPFast(), composer, 1572864, 60);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 GoBottomIndicator$lambda$0$0$0(a aVar) {
        aVar.invoke();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 GoBottomIndicator$lambda$1(Modifier modifier, boolean z10, a aVar, int i10, Composer composer, int i11) {
        GoBottomIndicator(modifier, z10, aVar, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1));
        return k0.f43947a;
    }
}
