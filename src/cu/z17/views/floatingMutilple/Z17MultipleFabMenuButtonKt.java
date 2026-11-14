package cu.z17.views.floatingMutilple;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.FloatingActionButtonDefaults;
import androidx.compose.material3.FloatingActionButtonElevation;
import androidx.compose.material3.FloatingActionButtonKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.unit.Dp;
import androidx.media3.exoplayer.RendererCapabilities;
import cu.z17.views.floatingMutilple.Z17MultipleFabMenuButtonKt;
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
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001aI\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0007H\u0007¢\u0006\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Landroidx/compose/ui/Modifier;", "modifier", "Lcu/z17/views/floatingMutilple/Z17MultipleFabObj;", "item", "Lkotlin/Function1;", "Lua/k0;", "onClick", "Landroidx/compose/ui/graphics/Color;", "containerColor", "iconColor", "Z17MultipleFabMenuButton-x3qM97A", "(Landroidx/compose/ui/Modifier;Lcu/z17/views/floatingMutilple/Z17MultipleFabObj;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/graphics/Color;Landroidx/compose/ui/graphics/Color;Landroidx/compose/runtime/Composer;II)V", "Z17MultipleFabMenuButton", "views_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class Z17MultipleFabMenuButtonKt {
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* JADX INFO: renamed from: Z17MultipleFabMenuButton-x3qM97A, reason: not valid java name */
    public static final void m10139Z17MultipleFabMenuButtonx3qM97A(Modifier modifier, final Z17MultipleFabObj item, final Function1 onClick, final Color color, final Color color2, Composer composer, final int i10, final int i11) {
        Modifier modifier2;
        int i12;
        final Modifier modifier3;
        long jM5876unboximpl;
        y.i(item, "item");
        y.i(onClick, "onClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(-255892642);
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
            i12 |= composerStartRestartGroup.changedInstance(item) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i12 |= composerStartRestartGroup.changedInstance(onClick) ? 256 : 128;
        }
        if ((i10 & 3072) == 0) {
            i12 |= composerStartRestartGroup.changed(color) ? 2048 : 1024;
        }
        if ((i10 & 24576) == 0) {
            i12 |= composerStartRestartGroup.changed(color2) ? 16384 : 8192;
        }
        if (composerStartRestartGroup.shouldExecute((i12 & 9363) != 9362, i12 & 1)) {
            Modifier modifier4 = i13 != 0 ? Modifier.INSTANCE : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-255892642, i12, -1, "cu.z17.views.floatingMutilple.Z17MultipleFabMenuButton (Z17MultipleFabMenuButton.kt:21)");
            }
            boolean z10 = false;
            int i14 = i12;
            FloatingActionButtonElevation floatingActionButtonElevationM3243elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m3243elevationxZ9QkE(Dp.m8823constructorimpl(0), 0.0f, 0.0f, 0.0f, composerStartRestartGroup, (FloatingActionButtonDefaults.$stable << 12) | 6, 14);
            RoundedCornerShape circleShape = RoundedCornerShapeKt.getCircleShape();
            if (color == null) {
                composerStartRestartGroup.startReplaceGroup(-1099677147);
                jM5876unboximpl = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimary();
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-1099678511);
                composerStartRestartGroup.endReplaceGroup();
                jM5876unboximpl = color.m5876unboximpl();
            }
            long j10 = jM5876unboximpl;
            if ((i14 & 896) == 256) {
                z10 = true;
            }
            boolean zChangedInstance = z10 | composerStartRestartGroup.changedInstance(item);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new a() { // from class: d9.d
                    @Override // lb.a
                    public final Object invoke() {
                        return Z17MultipleFabMenuButtonKt.Z17MultipleFabMenuButton_x3qM97A$lambda$1$lambda$0(onClick, item);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            Modifier modifier5 = modifier4;
            FloatingActionButtonKt.m3252FloatingActionButtonXz6DiA((a) objRememberedValue, modifier5, circleShape, j10, 0L, floatingActionButtonElevationM3243elevationxZ9QkE, null, ComposableLambdaKt.rememberComposableLambda(721039584, true, new Function2() { // from class: d9.e
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return Z17MultipleFabMenuButtonKt.Z17MultipleFabMenuButton_x3qM97A$lambda$2(item, color2, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i14 << 3) & 112) | 12582912, 80);
            composerStartRestartGroup = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier5;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: d9.f
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return Z17MultipleFabMenuButtonKt.Z17MultipleFabMenuButton_x3qM97A$lambda$3(modifier3, item, onClick, color, color2, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 Z17MultipleFabMenuButton_x3qM97A$lambda$1$lambda$0(Function1 function1, Z17MultipleFabObj z17MultipleFabObj) {
        function1.invoke(z17MultipleFabObj);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 Z17MultipleFabMenuButton_x3qM97A$lambda$2(Z17MultipleFabObj z17MultipleFabObj, Color color, Composer composer, int i10) {
        long jM5876unboximpl;
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(721039584, i10, -1, "cu.z17.views.floatingMutilple.Z17MultipleFabMenuButton.<anonymous> (Z17MultipleFabMenuButton.kt:32)");
            }
            Object icon = z17MultipleFabObj.getIcon();
            Modifier modifierM1769size3ABfNKs = SizeKt.m1769size3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(24));
            ColorFilter.Companion companion = ColorFilter.INSTANCE;
            if (color == null) {
                composer.startReplaceGroup(1429312298);
                jM5876unboximpl = MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getBackground();
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(1429311089);
                composer.endReplaceGroup();
                jM5876unboximpl = color.m5876unboximpl();
            }
            Z17PictureKt.m10278Z17BasePictureC8z9wKI(modifierM1769size3ABfNKs, icon, null, ColorFilter.Companion.m5907tintxETnrds$default(companion, jM5876unboximpl, 0, 2, null), null, null, 0, null, null, composer, 6, XMPPTCPConnection.PacketWriter.QUEUE_SIZE);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 Z17MultipleFabMenuButton_x3qM97A$lambda$3(Modifier modifier, Z17MultipleFabObj z17MultipleFabObj, Function1 function1, Color color, Color color2, int i10, int i11, Composer composer, int i12) {
        m10139Z17MultipleFabMenuButtonx3qM97A(modifier, z17MultipleFabObj, function1, color, color2, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return k0.f43947a;
    }
}
