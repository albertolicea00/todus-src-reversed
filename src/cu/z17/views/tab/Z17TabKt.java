package cu.z17.views.tab;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.MenuKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.TabKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import androidx.media3.exoplayer.RendererCapabilities;
import cu.z17.views.label.Z17LabelKt;
import cu.z17.views.tab.Z17TabKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.y;
import lb.a;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a-\u0010\u0007\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lkotlin/Function0;", "Lua/k0;", "onClick", "", "selected", "", "title", "Z17Tab", "(Llb/a;ZLjava/lang/String;Landroidx/compose/runtime/Composer;I)V", "views_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class Z17TabKt {
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void Z17Tab(final a onClick, final boolean z10, final String title, Composer composer, final int i10) {
        int i11;
        y.i(onClick, "onClick");
        y.i(title, "title");
        Composer composerStartRestartGroup = composer.startRestartGroup(1852139876);
        if ((i10 & 6) == 0) {
            i11 = (composerStartRestartGroup.changedInstance(onClick) ? 4 : 2) | i10;
        } else {
            i11 = i10;
        }
        if ((i10 & 48) == 0) {
            i11 |= composerStartRestartGroup.changed(z10) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i11 |= composerStartRestartGroup.changed(title) ? 256 : 128;
        }
        if (composerStartRestartGroup.shouldExecute((i11 & 147) != 146, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1852139876, i11, -1, "cu.z17.views.tab.Z17Tab (Z17Tab.kt:19)");
            }
            composerStartRestartGroup.startReplaceGroup(z10 ? 1789965360 : 1789966768);
            final long onBackground = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnBackground();
            composerStartRestartGroup.endReplaceGroup();
            composerStartRestartGroup.startReplaceGroup(z10 ? 1789969847 : 1789971917);
            long jM5865copywmQWz5c$default = Color.m5865copywmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnBackground(), 0.05f, 0.0f, 0.0f, 0.0f, 14, null);
            composerStartRestartGroup.endReplaceGroup();
            float f10 = 15;
            TabKt.m3740TabbogVsAg(z10, onClick, BackgroundKt.m1205backgroundbw27NRU$default(ClipKt.clip(BackgroundKt.m1205backgroundbw27NRU$default(Modifier.INSTANCE, MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground(), null, 2, null), RoundedCornerShapeKt.m2017RoundedCornerShapea9UjIt4$default(Dp.m8823constructorimpl(f10), Dp.m8823constructorimpl(f10), 0.0f, 0.0f, 12, null)), jM5865copywmQWz5c$default, null, 2, null), false, 0L, 0L, null, ComposableLambdaKt.rememberComposableLambda(-1088154735, true, new Function3() { // from class: r9.a
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return Z17TabKt.Z17Tab$lambda$0(title, onBackground, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i11 >> 3) & 14) | 12582912 | ((i11 << 3) & 112), MenuKt.InTransitionDuration);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: r9.b
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return Z17TabKt.Z17Tab$lambda$1(onClick, z10, title, i10, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 Z17Tab$lambda$0(String str, long j10, ColumnScope Tab, Composer composer, int i10) {
        y.i(Tab, "$this$Tab");
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1088154735, i10, -1, "cu.z17.views.tab.Z17Tab.<anonymous> (Z17Tab.kt:38)");
            }
            Z17LabelKt.m10262Z17LabelfWhpE4E(SizeKt.fillMaxWidth$default(SizeKt.m1755height3ABfNKs(PaddingKt.m1729paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m8823constructorimpl(10), 0.0f, Dp.m8823constructorimpl(5), 5, null), Dp.m8823constructorimpl(30)), 0.0f, 1, null), str, TextStyle.m8271copyp1EtxEg$default(MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getBodyMedium(), 0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, TextAlign.INSTANCE.m8692getCentere0LSkKk(), 0, 0L, null, null, null, 0, 0, null, 16744447, null), j10, 0, 0, composer, 6, 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 Z17Tab$lambda$1(a aVar, boolean z10, String str, int i10, Composer composer, int i11) {
        Z17Tab(aVar, z10, str, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1));
        return k0.f43947a;
    }
}
