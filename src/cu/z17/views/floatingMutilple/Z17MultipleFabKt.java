package cu.z17.views.floatingMutilple;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.FloatingActionButtonDefaults;
import androidx.compose.material3.FloatingActionButtonElevation;
import androidx.compose.material3.FloatingActionButtonKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.RotateKt;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.motion.widget.Key;
import androidx.media3.exoplayer.RendererCapabilities;
import cu.z17.views.floatingMutilple.Z17MultipleFabKt;
import cu.z17.views.picture.Z17PictureKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.y;
import lb.a;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\u001aU\u0010\u0010\u001a\u00020\u00072\b\b\u0002\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\fH\u0007¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Landroidx/compose/ui/Modifier;", "modifier", "Lcu/z17/views/floatingMutilple/Z17MultipleFabState;", "state", "", Key.ROTATION, "Lkotlin/Function1;", "Lua/k0;", "onClick", "Landroidx/compose/ui/graphics/Color;", "iconColor", "buttonColor", "", "baseIcon", "Z17MultipleFab-nBX6wN0", "(Landroidx/compose/ui/Modifier;Lcu/z17/views/floatingMutilple/Z17MultipleFabState;FLkotlin/jvm/functions/Function1;JJLjava/lang/Object;Landroidx/compose/runtime/Composer;II)V", "Z17MultipleFab", "views_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class Z17MultipleFabKt {
    @Composable
    /* JADX INFO: renamed from: Z17MultipleFab-nBX6wN0, reason: not valid java name */
    public static final void m10138Z17MultipleFabnBX6wN0(Modifier modifier, final Z17MultipleFabState state, final float f10, final Function1 onClick, final long j10, final long j11, final Object baseIcon, Composer composer, final int i10, final int i11) {
        Modifier modifier2;
        int i12;
        Composer composer2;
        final Modifier modifier3;
        y.i(state, "state");
        y.i(onClick, "onClick");
        y.i(baseIcon, "baseIcon");
        Composer composerStartRestartGroup = composer.startRestartGroup(-863740662);
        int i13 = i11 & 1;
        if (i13 != 0) {
            i12 = i10 | 6;
            modifier2 = modifier;
        } else if ((i10 & 6) == 0) {
            modifier2 = modifier;
            i12 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i10;
        } else {
            modifier2 = modifier;
            i12 = i10;
        }
        if ((i10 & 48) == 0) {
            i12 |= composerStartRestartGroup.changed(state.ordinal()) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i12 |= composerStartRestartGroup.changed(f10) ? 256 : 128;
        }
        if ((i10 & 3072) == 0) {
            i12 |= composerStartRestartGroup.changedInstance(onClick) ? 2048 : 1024;
        }
        if ((i10 & 24576) == 0) {
            i12 |= composerStartRestartGroup.changed(j10) ? 16384 : 8192;
        }
        if ((196608 & i10) == 0) {
            i12 |= composerStartRestartGroup.changed(j11) ? 131072 : 65536;
        }
        if ((1572864 & i10) == 0) {
            i12 |= composerStartRestartGroup.changedInstance(baseIcon) ? 1048576 : 524288;
        }
        if (composerStartRestartGroup.shouldExecute((599187 & i12) != 599186, i12 & 1)) {
            Modifier modifier4 = i13 != 0 ? Modifier.INSTANCE : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-863740662, i12, -1, "cu.z17.views.floatingMutilple.Z17MultipleFab (Z17MultipleFab.kt:23)");
            }
            Modifier modifierRotate = RotateKt.rotate(modifier4, f10);
            int i14 = i12;
            boolean z10 = false;
            FloatingActionButtonElevation floatingActionButtonElevationM3243elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m3243elevationxZ9QkE(Dp.m8823constructorimpl(0), 0.0f, 0.0f, 0.0f, composerStartRestartGroup, (FloatingActionButtonDefaults.$stable << 12) | 6, 14);
            RoundedCornerShape circleShape = RoundedCornerShapeKt.getCircleShape();
            boolean z11 = (i14 & 7168) == 2048;
            if ((i14 & 112) == 32) {
                z10 = true;
            }
            boolean z12 = z11 | z10;
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z12 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new a() { // from class: d9.a
                    @Override // lb.a
                    public final Object invoke() {
                        return Z17MultipleFabKt.Z17MultipleFab_nBX6wN0$lambda$1$lambda$0(onClick, state);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composer2 = composerStartRestartGroup;
            FloatingActionButtonKt.m3252FloatingActionButtonXz6DiA((a) objRememberedValue, modifierRotate, circleShape, j11, 0L, floatingActionButtonElevationM3243elevationxZ9QkE, null, ComposableLambdaKt.rememberComposableLambda(2027801740, true, new Function2() { // from class: d9.b
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return Z17MultipleFabKt.Z17MultipleFab_nBX6wN0$lambda$2(j10, baseIcon, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composer2, ((i14 >> 6) & 7168) | 12582912, 80);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            modifier3 = modifier2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: d9.c
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return Z17MultipleFabKt.Z17MultipleFab_nBX6wN0$lambda$3(modifier3, state, f10, onClick, j10, j11, baseIcon, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 Z17MultipleFab_nBX6wN0$lambda$1$lambda$0(Function1 function1, Z17MultipleFabState z17MultipleFabState) {
        Z17MultipleFabState z17MultipleFabState2 = Z17MultipleFabState.EXPANDED;
        if (z17MultipleFabState == z17MultipleFabState2) {
            z17MultipleFabState2 = Z17MultipleFabState.COLLAPSED;
        }
        function1.invoke(z17MultipleFabState2);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    public static final k0 Z17MultipleFab_nBX6wN0$lambda$2(long j10, Object obj, Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2027801740, i10, -1, "cu.z17.views.floatingMutilple.Z17MultipleFab.<anonymous> (Z17MultipleFab.kt:40)");
            }
            Z17PictureKt.m10278Z17BasePictureC8z9wKI(SizeKt.m1769size3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(24)), obj, null, ColorFilter.Companion.m5907tintxETnrds$default(ColorFilter.INSTANCE, j10, 0, 2, null), null, null, 0, null, null, composer, 6, XMPPTCPConnection.PacketWriter.QUEUE_SIZE);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 Z17MultipleFab_nBX6wN0$lambda$3(Modifier modifier, Z17MultipleFabState z17MultipleFabState, float f10, Function1 function1, long j10, long j11, Object obj, int i10, int i11, Composer composer, int i12) {
        m10138Z17MultipleFabnBX6wN0(modifier, z17MultipleFabState, f10, function1, j10, j11, obj, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return k0.f43947a;
    }
}
