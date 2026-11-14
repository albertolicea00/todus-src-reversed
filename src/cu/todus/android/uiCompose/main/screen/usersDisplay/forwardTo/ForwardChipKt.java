package cu.todus.android.uiCompose.main.screen.usersDisplay.forwardTo;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.ChipKt;
import androidx.compose.material3.FilterChipDefaults;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.SelectableChipColors;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Dp;
import cu.z17.views.label.Z17LabelKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.y;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a%\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"", "name", "Lkotlin/Function0;", "Lua/k0;", "onClick", "ForwardChip", "(Ljava/lang/String;Llb/a;Landroidx/compose/runtime/Composer;I)V", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class ForwardChipKt {
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void ForwardChip(String name, final lb.a onClick, Composer composer, final int i10) {
        int i11;
        final String str;
        Composer composer2;
        y.i(name, "name");
        y.i(onClick, "onClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1125793298);
        if ((i10 & 6) == 0) {
            i11 = i10 | (composerStartRestartGroup.changed(name) ? 4 : 2);
        } else {
            i11 = i10;
        }
        if ((i10 & 48) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(onClick) ? 32 : 16;
        }
        if (composerStartRestartGroup.shouldExecute((i11 & 19) != 18, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1125793298, i11, -1, "cu.todus.android.uiCompose.main.screen.usersDisplay.forwardTo.ForwardChip (ForwardChip.kt:17)");
            }
            Modifier modifierM1729paddingqDBjuR0$default = PaddingKt.m1729paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, Dp.m8823constructorimpl(3), 0.0f, 11, null);
            RoundedCornerShape roundedCornerShapeM2015RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(15));
            FilterChipDefaults filterChipDefaults = FilterChipDefaults.INSTANCE;
            MaterialTheme materialTheme = MaterialTheme.INSTANCE;
            int i12 = MaterialTheme.$stable;
            long background = materialTheme.getColorScheme(composerStartRestartGroup, i12).getBackground();
            int i13 = FilterChipDefaults.$stable;
            SelectableChipColors selectableChipColorsM3234elevatedFilterChipColorsXqyqHi0 = filterChipDefaults.m3234elevatedFilterChipColorsXqyqHi0(background, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, i13 << 6, 4094);
            BorderStroke borderStrokeM3236filterChipBorder_7El2pE = filterChipDefaults.m3236filterChipBorder_7El2pE(true, false, materialTheme.getColorScheme(composerStartRestartGroup, i12).getPrimary(), 0L, 0L, 0L, 0.0f, 0.0f, composerStartRestartGroup, (i13 << 24) | 54, 248);
            boolean z10 = (i11 & 112) == 32;
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z10 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.usersDisplay.forwardTo.d
                    @Override // lb.a
                    public final Object invoke() {
                        return ForwardChipKt.ForwardChip$lambda$0$0(onClick);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            str = name;
            composer2 = composerStartRestartGroup;
            ChipKt.ElevatedFilterChip(false, (lb.a) objRememberedValue, ComposableLambdaKt.rememberComposableLambda(-173499861, true, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.usersDisplay.forwardTo.e
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ForwardChipKt.ForwardChip$lambda$1(str, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), modifierM1729paddingqDBjuR0$default, false, null, null, roundedCornerShapeM2015RoundedCornerShape0680j_4, selectableChipColorsM3234elevatedFilterChipColorsXqyqHi0, null, borderStrokeM3236filterChipBorder_7El2pE, null, composer2, 3462, 0, 2672);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            str = name;
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.usersDisplay.forwardTo.f
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ForwardChipKt.ForwardChip$lambda$2(str, onClick, i10, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 ForwardChip$lambda$0$0(lb.a aVar) {
        aVar.invoke();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 ForwardChip$lambda$1(String str, Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-173499861, i10, -1, "cu.todus.android.uiCompose.main.screen.usersDisplay.forwardTo.ForwardChip.<anonymous> (ForwardChip.kt:32)");
            }
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, str, null, 0L, 0, 0, composer, 0, 61);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 ForwardChip$lambda$2(String str, lb.a aVar, int i10, Composer composer, int i11) {
        ForwardChip(str, aVar, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1));
        return k0.f43947a;
    }
}
