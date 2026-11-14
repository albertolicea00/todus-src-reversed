package cu.z17.views.floatingMutilple;

import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.profileinstaller.ProfileVerifier;
import cu.z17.views.floatingMutilple.Z17MultipleFabMenuKt;
import cu.z17.views.floatingMutilple.Z17MultipleFabObj;
import defpackage.r;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.y;
import lb.a;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a=\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0007¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Landroidx/compose/ui/Modifier;", "modifier", "", "visible", "", "Lcu/z17/views/floatingMutilple/Z17MultipleFabObj;", "items", "Lkotlin/Function0;", "Lua/k0;", "onClick", "Z17MultipleFabMenu", "(Landroidx/compose/ui/Modifier;ZLjava/util/List;Llb/a;Landroidx/compose/runtime/Composer;II)V", "views_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class Z17MultipleFabMenuKt {
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void Z17MultipleFabMenu(Modifier modifier, final boolean z10, final List<Z17MultipleFabObj> items, final a onClick, Composer composer, final int i10, final int i11) {
        Modifier modifier2;
        int i12;
        boolean z11;
        final Modifier modifier3;
        y.i(items, "items");
        y.i(onClick, "onClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(1570284279);
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
            z11 = z10;
            i12 |= composerStartRestartGroup.changed(z11) ? 32 : 16;
        } else {
            z11 = z10;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i12 |= composerStartRestartGroup.changedInstance(items) ? 256 : 128;
        }
        if ((i10 & 3072) == 0) {
            i12 |= composerStartRestartGroup.changedInstance(onClick) ? 2048 : 1024;
        }
        if (composerStartRestartGroup.shouldExecute((i12 & 1171) != 1170, i12 & 1)) {
            modifier3 = i13 != 0 ? Modifier.INSTANCE : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1570284279, i12, -1, "cu.z17.views.floatingMutilple.Z17MultipleFabMenu (Z17MultipleFabMenu.kt:23)");
            }
            AnimatedVisibilityKt.AnimatedVisibility(z11, (Modifier) null, EnterExitTransitionKt.expandVertically$default(AnimationSpecKt.tween$default(300, 0, EasingKt.getLinearEasing(), 2, null), null, false, null, 14, null).plus(EnterExitTransitionKt.fadeIn$default(AnimationSpecKt.tween$default(300, 0, EasingKt.getLinearEasing(), 2, null), 0.0f, 2, null)), EnterExitTransitionKt.shrinkVertically$default(AnimationSpecKt.tween$default(300, 0, EasingKt.getLinearEasing(), 2, null), null, false, null, 14, null).plus(EnterExitTransitionKt.fadeOut$default(AnimationSpecKt.tween$default(300, 0, EasingKt.getLinearEasing(), 2, null), 0.0f, 2, null)), (String) null, ComposableLambdaKt.rememberComposableLambda(2085497631, true, new Function3() { // from class: d9.h
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return Z17MultipleFabMenuKt.Z17MultipleFabMenu$lambda$4(modifier3, items, onClick, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i12 >> 3) & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 18);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: d9.i
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return Z17MultipleFabMenuKt.Z17MultipleFabMenu$lambda$5(modifier3, z10, items, onClick, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 Z17MultipleFabMenu$lambda$4(Modifier modifier, List list, final a aVar, AnimatedVisibilityScope AnimatedVisibility, Composer composer, int i10) {
        y.i(AnimatedVisibility, "$this$AnimatedVisibility");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2085497631, i10, -1, "cu.z17.views.floatingMutilple.Z17MultipleFabMenu.<anonymous> (Z17MultipleFabMenu.kt:49)");
        }
        Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(modifier, 0.0f, 1, null);
        MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.m1613spacedBy0680j_4(Dp.m8823constructorimpl(16)), Alignment.INSTANCE.getEnd(), composer, 54);
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
        CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierFillMaxWidth$default);
        ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
        a constructor = companion.getConstructor();
        if (!r.a(composer.getApplier())) {
            ComposablesKt.invalidApplier();
        }
        composer.startReusableNode();
        if (composer.getInserting()) {
            composer.createNode(constructor);
        } else {
            composer.useNode();
        }
        Composer composerM5176constructorimpl = Updater.m5176constructorimpl(composer);
        Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyColumnMeasurePolicy, companion.getSetMeasurePolicy());
        Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
        Function2 setCompositeKeyHash = companion.getSetCompositeKeyHash();
        if (composerM5176constructorimpl.getInserting() || !y.d(composerM5176constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
            composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
        }
        Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion.getSetModifier());
        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
        composer.startReplaceGroup(-1225723591);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            final Z17MultipleFabObj z17MultipleFabObj = (Z17MultipleFabObj) it.next();
            boolean zChanged = composer.changed(aVar) | composer.changedInstance(z17MultipleFabObj);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: d9.j
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Z17MultipleFabMenuKt.Z17MultipleFabMenu$lambda$4$lambda$3$lambda$2$lambda$1$lambda$0(aVar, z17MultipleFabObj, (Z17MultipleFabObj) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            Z17MultipleFabMenuItemKt.Z17MultipleFabMenuItem(null, z17MultipleFabObj, (Function1) objRememberedValue, composer, 0, 1);
        }
        composer.endReplaceGroup();
        composer.endNode();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 Z17MultipleFabMenu$lambda$4$lambda$3$lambda$2$lambda$1$lambda$0(a aVar, Z17MultipleFabObj z17MultipleFabObj, Z17MultipleFabObj it) {
        y.i(it, "it");
        aVar.invoke();
        z17MultipleFabObj.getAction().invoke();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 Z17MultipleFabMenu$lambda$5(Modifier modifier, boolean z10, List list, a aVar, int i10, int i11, Composer composer, int i12) {
        Z17MultipleFabMenu(modifier, z10, list, aVar, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return k0.f43947a;
    }
}
