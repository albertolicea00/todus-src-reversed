package cu.z17.views.loader;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.InfiniteRepeatableSpec;
import androidx.compose.animation.core.InfiniteTransition;
import androidx.compose.animation.core.InfiniteTransitionKt;
import androidx.compose.animation.core.RepeatMode;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Brush;
import androidx.media3.muxer.MuxerUtil;
import androidx.window.core.layout.WindowSizeClass;
import cu.z17.views.loader.Z17ShimmerLoaderKt;
import cu.z17.views.picture.Z17PictureSourceKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.y;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\u001a\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001f\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b²\u0006\f\u0010\n\u001a\u00020\t8\nX\u008a\u0084\u0002"}, d2 = {"Landroidx/compose/ui/Modifier;", "modifier", "Lua/k0;", "Z17Shimmer", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/ui/graphics/Brush;", "brush", "ShimmerItem", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Brush;Landroidx/compose/runtime/Composer;I)V", "", "translateAnim", "views_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class Z17ShimmerLoaderKt {
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void ShimmerItem(Modifier modifier, Brush brush, Composer composer, final int i10) {
        int i11;
        final Modifier modifier2;
        final Brush brush2;
        y.i(modifier, "modifier");
        y.i(brush, "brush");
        Composer composerStartRestartGroup = composer.startRestartGroup(537836942);
        if ((i10 & 6) == 0) {
            i11 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i10;
        } else {
            i11 = i10;
        }
        if ((i10 & 48) == 0) {
            i11 |= composerStartRestartGroup.changed(brush) ? 32 : 16;
        }
        if (composerStartRestartGroup.shouldExecute((i11 & 19) != 18, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(537836942, i11, -1, "cu.z17.views.loader.ShimmerItem (Z17ShimmerLoader.kt:59)");
            }
            modifier2 = modifier;
            brush2 = brush;
            SpacerKt.Spacer(BackgroundKt.background$default(modifier2, brush2, null, 0.0f, 6, null), composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            modifier2 = modifier;
            brush2 = brush;
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: m9.b
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return Z17ShimmerLoaderKt.ShimmerItem$lambda$2(modifier2, brush2, i10, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 ShimmerItem$lambda$2(Modifier modifier, Brush brush, int i10, Composer composer, int i11) {
        ShimmerItem(modifier, brush, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1));
        return k0.f43947a;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void Z17Shimmer(final Modifier modifier, Composer composer, final int i10) {
        int i11;
        y.i(modifier, "modifier");
        Composer composerStartRestartGroup = composer.startRestartGroup(-927961705);
        if ((i10 & 6) == 0) {
            i11 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i10;
        } else {
            i11 = i10;
        }
        if (composerStartRestartGroup.shouldExecute((i11 & 3) != 2, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-927961705, i11, -1, "cu.z17.views.loader.Z17Shimmer (Z17ShimmerLoader.kt:20)");
            }
            State<Float> stateAnimateFloat = InfiniteTransitionKt.animateFloat(InfiniteTransitionKt.rememberInfiniteTransition("", composerStartRestartGroup, 6, 0), 0.0f, 1000.0f, AnimationSpecKt.m1114infiniteRepeatable9IiC70o$default(AnimationSpecKt.tween$default(WindowSizeClass.WIDTH_DP_LARGE_LOWER_BOUND, 0, EasingKt.getFastOutSlowInEasing(), 2, null), RepeatMode.Reverse, 0L, 4, null), "", composerStartRestartGroup, InfiniteTransition.$stable | 25008 | (InfiniteRepeatableSpec.$stable << 9), 0);
            ShimmerItem(modifier, Brush.Companion.m5821linearGradientmHitzGk$default(Brush.INSTANCE, Z17PictureSourceKt.getShimmerColorShades(), Offset.m5618constructorimpl((((long) Float.floatToRawIntBits(10.0f)) << 32) | (((long) Float.floatToRawIntBits(10.0f)) & MuxerUtil.UNSIGNED_INT_MAX_VALUE)), Offset.m5618constructorimpl((((long) Float.floatToRawIntBits(Z17Shimmer$lambda$0(stateAnimateFloat))) << 32) | (((long) Float.floatToRawIntBits(Z17Shimmer$lambda$0(stateAnimateFloat))) & MuxerUtil.UNSIGNED_INT_MAX_VALUE)), 0, 8, (Object) null), composerStartRestartGroup, i11 & 14);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: m9.a
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return Z17ShimmerLoaderKt.Z17Shimmer$lambda$1(modifier, i10, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final float Z17Shimmer$lambda$0(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 Z17Shimmer$lambda$1(Modifier modifier, int i10, Composer composer, int i11) {
        Z17Shimmer(modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1));
        return k0.f43947a;
    }
}
