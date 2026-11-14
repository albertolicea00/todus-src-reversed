package cu.todus.android.uiCompose.shared.pagerStateIndicator;

import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
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
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.paging.LoadState;
import androidx.paging.compose.LazyPagingItems;
import cu.todus.android.R;
import cu.todus.android.constants.Service;
import cu.todus.android.uiCompose.shared.pagerStateIndicator.PagerStateIndicatorKt;
import cu.z17.views.label.Z17LabelKt;
import cu.z17.views.loader.Z17SimpleCircleLoaderKt;
import defpackage.l;
import defpackage.r;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.y;
import l0.j;
import lb.a;
import lb.o;
import p0.e;
import p0.n;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0093\u0001\u0010\f\u001a\u00020\u00022\u0019\b\u0002\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000¢\u0006\u0002\b\u00032%\b\u0002\u0010\u0007\u001a\u001f\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0006\u0012\u0004\u0012\u00020\u00020\u0005¢\u0006\u0002\b\u00032\u0019\b\u0002\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000¢\u0006\u0002\b\u00032\u0019\b\u0002\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000¢\u0006\u0002\b\u00032\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\nH\u0007¢\u0006\u0004\b\f\u0010\r\u001a\u0019\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u0017\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0011\u0010\u0012\u001a'\u0010\u0014\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\u0007¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u0019\u0010\u0016\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0016\u0010\u0010¨\u0006\u0019²\u0006\u000e\u0010\u0018\u001a\u0004\u0018\u00010\u00178\nX\u008a\u0084\u0002"}, d2 = {"Lkotlin/Function1;", "Landroidx/compose/ui/Modifier;", "Lua/k0;", "Landroidx/compose/runtime/Composable;", "pageLoader", "Lkotlin/Function2;", "Lkotlin/Function0;", "errorMessage", "loadingNextPageItem", "emptyPage", "Landroidx/paging/compose/LazyPagingItems;", Service.Endpoint.LINKED_DEVICES_LIST, "PagerStateIndicator", "(Lkotlin/jvm/functions/Function3;Llb/o;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Landroidx/paging/compose/LazyPagingItems;Landroidx/compose/runtime/Composer;II)V", "modifier", "PageLoaderDefault", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "LoadingNextPageItemDefault", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)V", "onClickRetry", "ErrorMessageDefault", "(Landroidx/compose/ui/Modifier;Llb/a;Landroidx/compose/runtime/Composer;II)V", "EmptyStateDefault", "Ll0/j;", "emptyAnimation", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class PagerStateIndicatorKt {
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void EmptyStateDefault(Modifier modifier, Composer composer, final int i10, final int i11) {
        Modifier modifier2;
        int i12;
        final Modifier modifier3;
        Composer composerStartRestartGroup = composer.startRestartGroup(67312751);
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
        if (composerStartRestartGroup.shouldExecute((i12 & 3) != 2, i12 & 1)) {
            Modifier modifier4 = i13 != 0 ? Modifier.INSTANCE : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(67312751, i12, -1, "cu.todus.android.uiCompose.shared.pagerStateIndicator.EmptyStateDefault (PagerStateIndicator.kt:142)");
            }
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getCenter(), false);
            int iA = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier4);
            ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
            a constructor = companion.getConstructor();
            if (!r.a(composerStartRestartGroup.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM5176constructorimpl = Updater.m5176constructorimpl(composerStartRestartGroup);
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, companion.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl, companion.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion.getSetModifier());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            p0.l lVarQ = p0.r.q(n.a.a(n.a.b(R.raw.generic_empty_animation)), null, null, null, null, null, composerStartRestartGroup, 0, 62);
            Modifier modifierM1769size3ABfNKs = SizeKt.m1769size3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(200));
            j jVarEmptyStateDefault$lambda$0$0 = EmptyStateDefault$lambda$0$0(lVarQ);
            modifier3 = modifier4;
            e.a(jVarEmptyStateDefault$lambda$0$0, modifierM1769size3ABfNKs, false, false, null, 0.0f, 0, false, false, false, false, null, false, false, null, null, null, false, false, null, false, null, composerStartRestartGroup, 48, 0, 0, 4194300);
            composerStartRestartGroup = composerStartRestartGroup;
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: t8.h
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PagerStateIndicatorKt.EmptyStateDefault$lambda$1(modifier3, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final j EmptyStateDefault$lambda$0$0(p0.l lVar) {
        return (j) lVar.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 EmptyStateDefault$lambda$1(Modifier modifier, int i10, int i11, Composer composer, int i12) {
        EmptyStateDefault(modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return k0.f43947a;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void ErrorMessageDefault(Modifier modifier, final a onClickRetry, Composer composer, final int i10, final int i11) {
        Modifier modifier2;
        int i12;
        Composer composer2;
        final Modifier modifier3;
        y.i(onClickRetry, "onClickRetry");
        Composer composerStartRestartGroup = composer.startRestartGroup(1786286376);
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
            i12 |= composerStartRestartGroup.changedInstance(onClickRetry) ? 32 : 16;
        }
        if (composerStartRestartGroup.shouldExecute((i12 & 19) != 18, i12 & 1)) {
            Modifier modifier4 = i13 != 0 ? Modifier.INSTANCE : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1786286376, i12, -1, "cu.todus.android.uiCompose.shared.pagerStateIndicator.ErrorMessageDefault (PagerStateIndicator.kt:119)");
            }
            Modifier modifierM1725padding3ABfNKs = PaddingKt.m1725padding3ABfNKs(modifier4, Dp.m8823constructorimpl(10));
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getCenter(), Alignment.INSTANCE.getCenterHorizontally(), composerStartRestartGroup, 54);
            int iA = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1725padding3ABfNKs);
            ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
            a constructor = companion.getConstructor();
            if (!r.a(composerStartRestartGroup.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM5176constructorimpl = Updater.m5176constructorimpl(composerStartRestartGroup);
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyColumnMeasurePolicy, companion.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl, companion.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            composer2 = composerStartRestartGroup;
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, StringResources_androidKt.stringResource(R.string.network_error, composerStartRestartGroup, 0), null, 0L, 0, 0, composer2, 0, 61);
            modifier3 = modifier4;
            IconButtonKt.IconButton(onClickRetry, null, false, null, null, null, ComposableSingletons$PagerStateIndicatorKt.INSTANCE.getLambda$529467836$app_productionPFast(), composer2, ((i12 >> 3) & 14) | 1572864, 62);
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            modifier3 = modifier2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: t8.f
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PagerStateIndicatorKt.ErrorMessageDefault$lambda$1(modifier3, onClickRetry, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 ErrorMessageDefault$lambda$1(Modifier modifier, a aVar, int i10, int i11, Composer composer, int i12) {
        ErrorMessageDefault(modifier, aVar, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return k0.f43947a;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void LoadingNextPageItemDefault(final Modifier modifier, Composer composer, final int i10) {
        int i11;
        y.i(modifier, "modifier");
        Composer composerStartRestartGroup = composer.startRestartGroup(1524645886);
        if ((i10 & 6) == 0) {
            i11 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i10;
        } else {
            i11 = i10;
        }
        if (composerStartRestartGroup.shouldExecute((i11 & 3) != 2, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1524645886, i11, -1, "cu.todus.android.uiCompose.shared.pagerStateIndicator.LoadingNextPageItemDefault (PagerStateIndicator.kt:106)");
            }
            Z17SimpleCircleLoaderKt.m10265Z17SimpleCircleLoaderZij2fk(SizeKt.wrapContentWidth$default(PaddingKt.m1725padding3ABfNKs(SizeKt.fillMaxWidth$default(modifier, 0.0f, 1, null), Dp.m8823constructorimpl(10)), Alignment.INSTANCE.getCenterHorizontally(), false, 2, null), 0.0f, 0.0f, 0L, composerStartRestartGroup, 0, 14);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: t8.i
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PagerStateIndicatorKt.LoadingNextPageItemDefault$lambda$0(modifier, i10, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 LoadingNextPageItemDefault$lambda$0(Modifier modifier, int i10, Composer composer, int i11) {
        LoadingNextPageItemDefault(modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1));
        return k0.f43947a;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void PageLoaderDefault(final Modifier modifier, Composer composer, final int i10, final int i11) {
        int i12;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(2034831729);
        int i13 = i11 & 1;
        if (i13 != 0) {
            i12 = i10 | 6;
        } else if ((i10 & 6) == 0) {
            i12 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i10;
        } else {
            i12 = i10;
        }
        if (composerStartRestartGroup.shouldExecute((i12 & 3) != 2, i12 & 1)) {
            if (i13 != 0) {
                modifier = Modifier.INSTANCE;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2034831729, i12, -1, "cu.todus.android.uiCompose.shared.pagerStateIndicator.PageLoaderDefault (PagerStateIndicator.kt:93)");
            }
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getCenter(), Alignment.INSTANCE.getCenterHorizontally(), composerStartRestartGroup, 54);
            int iA = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier);
            ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
            a constructor = companion.getConstructor();
            if (!r.a(composerStartRestartGroup.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM5176constructorimpl = Updater.m5176constructorimpl(composerStartRestartGroup);
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyColumnMeasurePolicy, companion.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl, companion.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, StringResources_androidKt.stringResource(R.string.loading_hint, composerStartRestartGroup, 0), null, 0L, 0, 0, composerStartRestartGroup, 0, 61);
            Z17SimpleCircleLoaderKt.m10265Z17SimpleCircleLoaderZij2fk(PaddingKt.m1729paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m8823constructorimpl(10), 0.0f, 0.0f, 13, null), 0.0f, 0.0f, 0L, composerStartRestartGroup, 6, 14);
            composer2 = composerStartRestartGroup;
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: t8.g
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PagerStateIndicatorKt.PageLoaderDefault$lambda$1(modifier, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 PageLoaderDefault$lambda$1(Modifier modifier, int i10, int i11, Composer composer, int i12) {
        PageLoaderDefault(modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return k0.f43947a;
    }

    /* JADX WARN: Code duplicated, block: B:26:0x004f  */
    /* JADX WARN: Code duplicated, block: B:28:0x0054  */
    /* JADX WARN: Code duplicated, block: B:30:0x0058  */
    /* JADX WARN: Code duplicated, block: B:32:0x0060  */
    /* JADX WARN: Code duplicated, block: B:33:0x0063  */
    /* JADX WARN: Code duplicated, block: B:37:0x006a  */
    /* JADX WARN: Code duplicated, block: B:39:0x006f  */
    /* JADX WARN: Code duplicated, block: B:41:0x0073  */
    /* JADX WARN: Code duplicated, block: B:43:0x007b  */
    /* JADX WARN: Code duplicated, block: B:44:0x007e  */
    /* JADX WARN: Code duplicated, block: B:48:0x0085  */
    /* JADX WARN: Code duplicated, block: B:50:0x008b  */
    /* JADX WARN: Code duplicated, block: B:51:0x0090  */
    /* JADX WARN: Code duplicated, block: B:53:0x0096  */
    /* JADX WARN: Code duplicated, block: B:54:0x0099  */
    /* JADX WARN: Code duplicated, block: B:58:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:62:0x00b1 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:63:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:64:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:66:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:67:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:69:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:70:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:72:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:75:0x00de  */
    /* JADX WARN: Code duplicated, block: B:78:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:81:0x0104  */
    /* JADX WARN: Code duplicated, block: B:84:0x01b8  */
    /* JADX WARN: Code duplicated, block: B:87:0x01c8  */
    /* JADX WARN: Code duplicated, block: B:90:0x01ea  */
    /* JADX WARN: Code duplicated, block: B:92:0x01f3  */
    /* JADX WARN: Code duplicated, block: B:95:0x0200  */
    /* JADX WARN: Code duplicated, block: B:97:? A[RETURN, SYNTHETIC] */
    @Composable
    @ComposableInferredTarget(scheme = "[0[0][0][0][0]]")
    public static final void PagerStateIndicator(Function3 function3, o oVar, Function3 function4, Function3 function5, final LazyPagingItems<?> list, Composer composer, final int i10, final int i11) {
        Function3 function6;
        int i12;
        o oVar2;
        int i13;
        Function3 function7;
        int i14;
        int i15;
        Function3 function3M10087getLambda$1208785958$app_productionPFast;
        int i16;
        boolean z10;
        final Function3 function8;
        final o oVarM10088getLambda$2139246109$app_productionPFast;
        final Function3 function9;
        final Function3 function10;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        final Function3 lambda$1043743468$app_productionPFast;
        final Function3 lambda$1044445317$app_productionPFast;
        boolean z11;
        boolean z12;
        boolean zChangedInstance;
        int i17;
        y.i(list, "list");
        Composer composerStartRestartGroup = composer.startRestartGroup(-449344365);
        int i18 = i11 & 1;
        if (i18 != 0) {
            i12 = i10 | 6;
            function6 = function3;
        } else if ((i10 & 6) == 0) {
            function6 = function3;
            i12 = (composerStartRestartGroup.changedInstance(function6) ? 4 : 2) | i10;
        } else {
            function6 = function3;
            i12 = i10;
        }
        int i19 = i11 & 2;
        if (i19 == 0) {
            if ((i10 & 48) == 0) {
                oVar2 = oVar;
                i12 |= composerStartRestartGroup.changedInstance(oVar2) ? 32 : 16;
            }
            i13 = i11 & 4;
            if (i13 != 0) {
                if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                    function7 = function4;
                    if (composerStartRestartGroup.changedInstance(function7)) {
                        i14 = 256;
                    } else {
                        i14 = 128;
                    }
                    i12 |= i14;
                }
                i15 = i11 & 8;
                if (i15 != 0) {
                    if ((i10 & 3072) == 0) {
                        function3M10087getLambda$1208785958$app_productionPFast = function5;
                        if (composerStartRestartGroup.changedInstance(function3M10087getLambda$1208785958$app_productionPFast)) {
                            i16 = 2048;
                        } else {
                            i16 = 1024;
                        }
                        i12 |= i16;
                    }
                    if ((i10 & 24576) == 0) {
                        if ((32768 & i10) == 0) {
                            zChangedInstance = composerStartRestartGroup.changed(list);
                        } else {
                            zChangedInstance = composerStartRestartGroup.changedInstance(list);
                        }
                        if (zChangedInstance) {
                            i17 = 16384;
                        } else {
                            i17 = 8192;
                        }
                        i12 |= i17;
                    }
                    if ((i12 & 9363) != 9362) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z10, i12 & 1)) {
                        if (i18 != 0) {
                            lambda$1043743468$app_productionPFast = ComposableSingletons$PagerStateIndicatorKt.INSTANCE.getLambda$1043743468$app_productionPFast();
                        } else {
                            lambda$1043743468$app_productionPFast = function6;
                        }
                        if (i19 != 0) {
                            oVarM10088getLambda$2139246109$app_productionPFast = ComposableSingletons$PagerStateIndicatorKt.INSTANCE.m10088getLambda$2139246109$app_productionPFast();
                        } else {
                            oVarM10088getLambda$2139246109$app_productionPFast = oVar2;
                        }
                        if (i13 != 0) {
                            lambda$1044445317$app_productionPFast = ComposableSingletons$PagerStateIndicatorKt.INSTANCE.getLambda$1044445317$app_productionPFast();
                        } else {
                            lambda$1044445317$app_productionPFast = function7;
                        }
                        if (i15 != 0) {
                            function3M10087getLambda$1208785958$app_productionPFast = ComposableSingletons$PagerStateIndicatorKt.INSTANCE.m10087getLambda$1208785958$app_productionPFast();
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-449344365, i12, -1, "cu.todus.android.uiCompose.shared.pagerStateIndicator.PagerStateIndicator (PagerStateIndicator.kt:43)");
                        }
                        EnterTransition enterTransitionFadeIn$default = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null);
                        ExitTransition exitTransitionFadeOut$default = EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null);
                        if ((list.getLoadState().getRefresh() instanceof LoadState.Loading) || list.getItemCount() >= 1) {
                            z11 = false;
                        } else {
                            z11 = true;
                        }
                        final Function3 function11 = function3M10087getLambda$1208785958$app_productionPFast;
                        Function3 function12 = lambda$1043743468$app_productionPFast;
                        AnimatedVisibilityKt.AnimatedVisibility(z11, (Modifier) null, enterTransitionFadeIn$default, exitTransitionFadeOut$default, (String) null, ComposableLambdaKt.rememberComposableLambda(-1975032038, true, new Function3() { // from class: t8.l
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return PagerStateIndicatorKt.PagerStateIndicator$lambda$0$0(lambda$1043743468$app_productionPFast, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, 200064, 18);
                        AnimatedVisibilityKt.AnimatedVisibility(list.getLoadState().getRefresh() instanceof LoadState.Error, (Modifier) null, EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null), EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null), (String) null, ComposableLambdaKt.rememberComposableLambda(877053905, true, new Function3() { // from class: t8.m
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return PagerStateIndicatorKt.PagerStateIndicator$lambda$0$1(oVarM10088getLambda$2139246109$app_productionPFast, list, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, 200064, 18);
                        AnimatedVisibilityKt.AnimatedVisibility(list.getLoadState().getAppend() instanceof LoadState.Loading, (Modifier) null, EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null), EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null), (String) null, ComposableLambdaKt.rememberComposableLambda(366041746, true, new Function3() { // from class: t8.n
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return PagerStateIndicatorKt.PagerStateIndicator$lambda$0$2(lambda$1044445317$app_productionPFast, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, 200064, 18);
                        AnimatedVisibilityKt.AnimatedVisibility(list.getLoadState().getAppend() instanceof LoadState.Error, (Modifier) null, EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null), EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null), (String) null, ComposableLambdaKt.rememberComposableLambda(-144970413, true, new Function3() { // from class: t8.o
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return PagerStateIndicatorKt.PagerStateIndicator$lambda$0$3(oVarM10088getLambda$2139246109$app_productionPFast, list, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, 200064, 18);
                        EnterTransition enterTransitionFadeIn$default2 = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null);
                        ExitTransition exitTransitionFadeOut$default2 = EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null);
                        if ((list.getLoadState().getAppend() instanceof LoadState.NotLoading) || !list.getLoadState().getAppend().getEndOfPaginationReached()) {
                            z12 = false;
                        } else {
                            z12 = true;
                        }
                        AnimatedVisibilityKt.AnimatedVisibility(z12, (Modifier) null, enterTransitionFadeIn$default2, exitTransitionFadeOut$default2, (String) null, ComposableLambdaKt.rememberComposableLambda(-655982572, true, new Function3() { // from class: t8.p
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return PagerStateIndicatorKt.PagerStateIndicator$lambda$0$4(list, function11, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, 200064, 18);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        Function3 function13 = lambda$1044445317$app_productionPFast;
                        function10 = function11;
                        function9 = function13;
                        function8 = function12;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        function8 = function6;
                        oVarM10088getLambda$2139246109$app_productionPFast = oVar2;
                        function9 = function7;
                        function10 = function3M10087getLambda$1208785958$app_productionPFast;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: t8.q
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return PagerStateIndicatorKt.PagerStateIndicator$lambda$1(function8, oVarM10088getLambda$2139246109$app_productionPFast, function9, function10, list, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i12 |= 3072;
                function3M10087getLambda$1208785958$app_productionPFast = function5;
                if ((i10 & 24576) == 0) {
                    if ((32768 & i10) == 0) {
                        zChangedInstance = composerStartRestartGroup.changed(list);
                    } else {
                        zChangedInstance = composerStartRestartGroup.changedInstance(list);
                    }
                    if (zChangedInstance) {
                        i17 = 16384;
                    } else {
                        i17 = 8192;
                    }
                    i12 |= i17;
                }
                if ((i12 & 9363) != 9362) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z10, i12 & 1)) {
                    if (i18 != 0) {
                        lambda$1043743468$app_productionPFast = ComposableSingletons$PagerStateIndicatorKt.INSTANCE.getLambda$1043743468$app_productionPFast();
                    } else {
                        lambda$1043743468$app_productionPFast = function6;
                    }
                    if (i19 != 0) {
                        oVarM10088getLambda$2139246109$app_productionPFast = ComposableSingletons$PagerStateIndicatorKt.INSTANCE.m10088getLambda$2139246109$app_productionPFast();
                    } else {
                        oVarM10088getLambda$2139246109$app_productionPFast = oVar2;
                    }
                    if (i13 != 0) {
                        lambda$1044445317$app_productionPFast = ComposableSingletons$PagerStateIndicatorKt.INSTANCE.getLambda$1044445317$app_productionPFast();
                    } else {
                        lambda$1044445317$app_productionPFast = function7;
                    }
                    if (i15 != 0) {
                        function3M10087getLambda$1208785958$app_productionPFast = ComposableSingletons$PagerStateIndicatorKt.INSTANCE.m10087getLambda$1208785958$app_productionPFast();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-449344365, i12, -1, "cu.todus.android.uiCompose.shared.pagerStateIndicator.PagerStateIndicator (PagerStateIndicator.kt:43)");
                    }
                    EnterTransition enterTransitionFadeIn$default3 = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null);
                    ExitTransition exitTransitionFadeOut$default3 = EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null);
                    if (list.getLoadState().getRefresh() instanceof LoadState.Loading) {
                        z11 = false;
                    } else {
                        z11 = false;
                    }
                    final Function3 function14 = function3M10087getLambda$1208785958$app_productionPFast;
                    Function3 function15 = lambda$1043743468$app_productionPFast;
                    AnimatedVisibilityKt.AnimatedVisibility(z11, (Modifier) null, enterTransitionFadeIn$default3, exitTransitionFadeOut$default3, (String) null, ComposableLambdaKt.rememberComposableLambda(-1975032038, true, new Function3() { // from class: t8.l
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return PagerStateIndicatorKt.PagerStateIndicator$lambda$0$0(lambda$1043743468$app_productionPFast, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, 200064, 18);
                    AnimatedVisibilityKt.AnimatedVisibility(list.getLoadState().getRefresh() instanceof LoadState.Error, (Modifier) null, EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null), EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null), (String) null, ComposableLambdaKt.rememberComposableLambda(877053905, true, new Function3() { // from class: t8.m
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return PagerStateIndicatorKt.PagerStateIndicator$lambda$0$1(oVarM10088getLambda$2139246109$app_productionPFast, list, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, 200064, 18);
                    AnimatedVisibilityKt.AnimatedVisibility(list.getLoadState().getAppend() instanceof LoadState.Loading, (Modifier) null, EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null), EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null), (String) null, ComposableLambdaKt.rememberComposableLambda(366041746, true, new Function3() { // from class: t8.n
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return PagerStateIndicatorKt.PagerStateIndicator$lambda$0$2(lambda$1044445317$app_productionPFast, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, 200064, 18);
                    AnimatedVisibilityKt.AnimatedVisibility(list.getLoadState().getAppend() instanceof LoadState.Error, (Modifier) null, EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null), EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null), (String) null, ComposableLambdaKt.rememberComposableLambda(-144970413, true, new Function3() { // from class: t8.o
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return PagerStateIndicatorKt.PagerStateIndicator$lambda$0$3(oVarM10088getLambda$2139246109$app_productionPFast, list, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, 200064, 18);
                    EnterTransition enterTransitionFadeIn$default4 = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null);
                    ExitTransition exitTransitionFadeOut$default4 = EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null);
                    if (list.getLoadState().getAppend() instanceof LoadState.NotLoading) {
                        z12 = false;
                    } else {
                        z12 = false;
                    }
                    AnimatedVisibilityKt.AnimatedVisibility(z12, (Modifier) null, enterTransitionFadeIn$default4, exitTransitionFadeOut$default4, (String) null, ComposableLambdaKt.rememberComposableLambda(-655982572, true, new Function3() { // from class: t8.p
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return PagerStateIndicatorKt.PagerStateIndicator$lambda$0$4(list, function14, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, 200064, 18);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    Function3 function16 = lambda$1044445317$app_productionPFast;
                    function10 = function14;
                    function9 = function16;
                    function8 = function15;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    function8 = function6;
                    oVarM10088getLambda$2139246109$app_productionPFast = oVar2;
                    function9 = function7;
                    function10 = function3M10087getLambda$1208785958$app_productionPFast;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: t8.q
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return PagerStateIndicatorKt.PagerStateIndicator$lambda$1(function8, oVarM10088getLambda$2139246109$app_productionPFast, function9, function10, list, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i12 |= RendererCapabilities.DECODER_SUPPORT_MASK;
            function7 = function4;
            i15 = i11 & 8;
            if (i15 != 0) {
                if ((i10 & 3072) == 0) {
                    function3M10087getLambda$1208785958$app_productionPFast = function5;
                    if (composerStartRestartGroup.changedInstance(function3M10087getLambda$1208785958$app_productionPFast)) {
                        i16 = 2048;
                    } else {
                        i16 = 1024;
                    }
                    i12 |= i16;
                }
                if ((i10 & 24576) == 0) {
                    if ((32768 & i10) == 0) {
                        zChangedInstance = composerStartRestartGroup.changed(list);
                    } else {
                        zChangedInstance = composerStartRestartGroup.changedInstance(list);
                    }
                    if (zChangedInstance) {
                        i17 = 16384;
                    } else {
                        i17 = 8192;
                    }
                    i12 |= i17;
                }
                if ((i12 & 9363) != 9362) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z10, i12 & 1)) {
                    if (i18 != 0) {
                        lambda$1043743468$app_productionPFast = ComposableSingletons$PagerStateIndicatorKt.INSTANCE.getLambda$1043743468$app_productionPFast();
                    } else {
                        lambda$1043743468$app_productionPFast = function6;
                    }
                    if (i19 != 0) {
                        oVarM10088getLambda$2139246109$app_productionPFast = ComposableSingletons$PagerStateIndicatorKt.INSTANCE.m10088getLambda$2139246109$app_productionPFast();
                    } else {
                        oVarM10088getLambda$2139246109$app_productionPFast = oVar2;
                    }
                    if (i13 != 0) {
                        lambda$1044445317$app_productionPFast = ComposableSingletons$PagerStateIndicatorKt.INSTANCE.getLambda$1044445317$app_productionPFast();
                    } else {
                        lambda$1044445317$app_productionPFast = function7;
                    }
                    if (i15 != 0) {
                        function3M10087getLambda$1208785958$app_productionPFast = ComposableSingletons$PagerStateIndicatorKt.INSTANCE.m10087getLambda$1208785958$app_productionPFast();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-449344365, i12, -1, "cu.todus.android.uiCompose.shared.pagerStateIndicator.PagerStateIndicator (PagerStateIndicator.kt:43)");
                    }
                    EnterTransition enterTransitionFadeIn$default5 = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null);
                    ExitTransition exitTransitionFadeOut$default5 = EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null);
                    if (list.getLoadState().getRefresh() instanceof LoadState.Loading) {
                        z11 = false;
                    } else {
                        z11 = false;
                    }
                    final Function3 function17 = function3M10087getLambda$1208785958$app_productionPFast;
                    Function3 function18 = lambda$1043743468$app_productionPFast;
                    AnimatedVisibilityKt.AnimatedVisibility(z11, (Modifier) null, enterTransitionFadeIn$default5, exitTransitionFadeOut$default5, (String) null, ComposableLambdaKt.rememberComposableLambda(-1975032038, true, new Function3() { // from class: t8.l
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return PagerStateIndicatorKt.PagerStateIndicator$lambda$0$0(lambda$1043743468$app_productionPFast, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, 200064, 18);
                    AnimatedVisibilityKt.AnimatedVisibility(list.getLoadState().getRefresh() instanceof LoadState.Error, (Modifier) null, EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null), EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null), (String) null, ComposableLambdaKt.rememberComposableLambda(877053905, true, new Function3() { // from class: t8.m
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return PagerStateIndicatorKt.PagerStateIndicator$lambda$0$1(oVarM10088getLambda$2139246109$app_productionPFast, list, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, 200064, 18);
                    AnimatedVisibilityKt.AnimatedVisibility(list.getLoadState().getAppend() instanceof LoadState.Loading, (Modifier) null, EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null), EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null), (String) null, ComposableLambdaKt.rememberComposableLambda(366041746, true, new Function3() { // from class: t8.n
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return PagerStateIndicatorKt.PagerStateIndicator$lambda$0$2(lambda$1044445317$app_productionPFast, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, 200064, 18);
                    AnimatedVisibilityKt.AnimatedVisibility(list.getLoadState().getAppend() instanceof LoadState.Error, (Modifier) null, EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null), EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null), (String) null, ComposableLambdaKt.rememberComposableLambda(-144970413, true, new Function3() { // from class: t8.o
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return PagerStateIndicatorKt.PagerStateIndicator$lambda$0$3(oVarM10088getLambda$2139246109$app_productionPFast, list, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, 200064, 18);
                    EnterTransition enterTransitionFadeIn$default6 = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null);
                    ExitTransition exitTransitionFadeOut$default6 = EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null);
                    if (list.getLoadState().getAppend() instanceof LoadState.NotLoading) {
                        z12 = false;
                    } else {
                        z12 = false;
                    }
                    AnimatedVisibilityKt.AnimatedVisibility(z12, (Modifier) null, enterTransitionFadeIn$default6, exitTransitionFadeOut$default6, (String) null, ComposableLambdaKt.rememberComposableLambda(-655982572, true, new Function3() { // from class: t8.p
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return PagerStateIndicatorKt.PagerStateIndicator$lambda$0$4(list, function17, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, 200064, 18);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    Function3 function19 = lambda$1044445317$app_productionPFast;
                    function10 = function17;
                    function9 = function19;
                    function8 = function18;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    function8 = function6;
                    oVarM10088getLambda$2139246109$app_productionPFast = oVar2;
                    function9 = function7;
                    function10 = function3M10087getLambda$1208785958$app_productionPFast;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: t8.q
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return PagerStateIndicatorKt.PagerStateIndicator$lambda$1(function8, oVarM10088getLambda$2139246109$app_productionPFast, function9, function10, list, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i12 |= 3072;
            function3M10087getLambda$1208785958$app_productionPFast = function5;
            if ((i10 & 24576) == 0) {
                if ((32768 & i10) == 0) {
                    zChangedInstance = composerStartRestartGroup.changed(list);
                } else {
                    zChangedInstance = composerStartRestartGroup.changedInstance(list);
                }
                if (zChangedInstance) {
                    i17 = 16384;
                } else {
                    i17 = 8192;
                }
                i12 |= i17;
            }
            if ((i12 & 9363) != 9362) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z10, i12 & 1)) {
                if (i18 != 0) {
                    lambda$1043743468$app_productionPFast = ComposableSingletons$PagerStateIndicatorKt.INSTANCE.getLambda$1043743468$app_productionPFast();
                } else {
                    lambda$1043743468$app_productionPFast = function6;
                }
                if (i19 != 0) {
                    oVarM10088getLambda$2139246109$app_productionPFast = ComposableSingletons$PagerStateIndicatorKt.INSTANCE.m10088getLambda$2139246109$app_productionPFast();
                } else {
                    oVarM10088getLambda$2139246109$app_productionPFast = oVar2;
                }
                if (i13 != 0) {
                    lambda$1044445317$app_productionPFast = ComposableSingletons$PagerStateIndicatorKt.INSTANCE.getLambda$1044445317$app_productionPFast();
                } else {
                    lambda$1044445317$app_productionPFast = function7;
                }
                if (i15 != 0) {
                    function3M10087getLambda$1208785958$app_productionPFast = ComposableSingletons$PagerStateIndicatorKt.INSTANCE.m10087getLambda$1208785958$app_productionPFast();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-449344365, i12, -1, "cu.todus.android.uiCompose.shared.pagerStateIndicator.PagerStateIndicator (PagerStateIndicator.kt:43)");
                }
                EnterTransition enterTransitionFadeIn$default7 = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null);
                ExitTransition exitTransitionFadeOut$default7 = EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null);
                if (list.getLoadState().getRefresh() instanceof LoadState.Loading) {
                    z11 = false;
                } else {
                    z11 = false;
                }
                final Function3 function110 = function3M10087getLambda$1208785958$app_productionPFast;
                Function3 function111 = lambda$1043743468$app_productionPFast;
                AnimatedVisibilityKt.AnimatedVisibility(z11, (Modifier) null, enterTransitionFadeIn$default7, exitTransitionFadeOut$default7, (String) null, ComposableLambdaKt.rememberComposableLambda(-1975032038, true, new Function3() { // from class: t8.l
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return PagerStateIndicatorKt.PagerStateIndicator$lambda$0$0(lambda$1043743468$app_productionPFast, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 200064, 18);
                AnimatedVisibilityKt.AnimatedVisibility(list.getLoadState().getRefresh() instanceof LoadState.Error, (Modifier) null, EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null), EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null), (String) null, ComposableLambdaKt.rememberComposableLambda(877053905, true, new Function3() { // from class: t8.m
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return PagerStateIndicatorKt.PagerStateIndicator$lambda$0$1(oVarM10088getLambda$2139246109$app_productionPFast, list, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 200064, 18);
                AnimatedVisibilityKt.AnimatedVisibility(list.getLoadState().getAppend() instanceof LoadState.Loading, (Modifier) null, EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null), EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null), (String) null, ComposableLambdaKt.rememberComposableLambda(366041746, true, new Function3() { // from class: t8.n
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return PagerStateIndicatorKt.PagerStateIndicator$lambda$0$2(lambda$1044445317$app_productionPFast, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 200064, 18);
                AnimatedVisibilityKt.AnimatedVisibility(list.getLoadState().getAppend() instanceof LoadState.Error, (Modifier) null, EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null), EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null), (String) null, ComposableLambdaKt.rememberComposableLambda(-144970413, true, new Function3() { // from class: t8.o
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return PagerStateIndicatorKt.PagerStateIndicator$lambda$0$3(oVarM10088getLambda$2139246109$app_productionPFast, list, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 200064, 18);
                EnterTransition enterTransitionFadeIn$default8 = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null);
                ExitTransition exitTransitionFadeOut$default8 = EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null);
                if (list.getLoadState().getAppend() instanceof LoadState.NotLoading) {
                    z12 = false;
                } else {
                    z12 = false;
                }
                AnimatedVisibilityKt.AnimatedVisibility(z12, (Modifier) null, enterTransitionFadeIn$default8, exitTransitionFadeOut$default8, (String) null, ComposableLambdaKt.rememberComposableLambda(-655982572, true, new Function3() { // from class: t8.p
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return PagerStateIndicatorKt.PagerStateIndicator$lambda$0$4(list, function110, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 200064, 18);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                Function3 function112 = lambda$1044445317$app_productionPFast;
                function10 = function110;
                function9 = function112;
                function8 = function111;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                function8 = function6;
                oVarM10088getLambda$2139246109$app_productionPFast = oVar2;
                function9 = function7;
                function10 = function3M10087getLambda$1208785958$app_productionPFast;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: t8.q
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return PagerStateIndicatorKt.PagerStateIndicator$lambda$1(function8, oVarM10088getLambda$2139246109$app_productionPFast, function9, function10, list, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i12 |= 48;
        oVar2 = oVar;
        i13 = i11 & 4;
        if (i13 != 0) {
            if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                function7 = function4;
                if (composerStartRestartGroup.changedInstance(function7)) {
                    i14 = 256;
                } else {
                    i14 = 128;
                }
                i12 |= i14;
            }
            i15 = i11 & 8;
            if (i15 != 0) {
                if ((i10 & 3072) == 0) {
                    function3M10087getLambda$1208785958$app_productionPFast = function5;
                    if (composerStartRestartGroup.changedInstance(function3M10087getLambda$1208785958$app_productionPFast)) {
                        i16 = 2048;
                    } else {
                        i16 = 1024;
                    }
                    i12 |= i16;
                }
                if ((i10 & 24576) == 0) {
                    if ((32768 & i10) == 0) {
                        zChangedInstance = composerStartRestartGroup.changed(list);
                    } else {
                        zChangedInstance = composerStartRestartGroup.changedInstance(list);
                    }
                    if (zChangedInstance) {
                        i17 = 16384;
                    } else {
                        i17 = 8192;
                    }
                    i12 |= i17;
                }
                if ((i12 & 9363) != 9362) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z10, i12 & 1)) {
                    if (i18 != 0) {
                        lambda$1043743468$app_productionPFast = ComposableSingletons$PagerStateIndicatorKt.INSTANCE.getLambda$1043743468$app_productionPFast();
                    } else {
                        lambda$1043743468$app_productionPFast = function6;
                    }
                    if (i19 != 0) {
                        oVarM10088getLambda$2139246109$app_productionPFast = ComposableSingletons$PagerStateIndicatorKt.INSTANCE.m10088getLambda$2139246109$app_productionPFast();
                    } else {
                        oVarM10088getLambda$2139246109$app_productionPFast = oVar2;
                    }
                    if (i13 != 0) {
                        lambda$1044445317$app_productionPFast = ComposableSingletons$PagerStateIndicatorKt.INSTANCE.getLambda$1044445317$app_productionPFast();
                    } else {
                        lambda$1044445317$app_productionPFast = function7;
                    }
                    if (i15 != 0) {
                        function3M10087getLambda$1208785958$app_productionPFast = ComposableSingletons$PagerStateIndicatorKt.INSTANCE.m10087getLambda$1208785958$app_productionPFast();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-449344365, i12, -1, "cu.todus.android.uiCompose.shared.pagerStateIndicator.PagerStateIndicator (PagerStateIndicator.kt:43)");
                    }
                    EnterTransition enterTransitionFadeIn$default9 = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null);
                    ExitTransition exitTransitionFadeOut$default9 = EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null);
                    if (list.getLoadState().getRefresh() instanceof LoadState.Loading) {
                        z11 = false;
                    } else {
                        z11 = false;
                    }
                    final Function3 function113 = function3M10087getLambda$1208785958$app_productionPFast;
                    Function3 function114 = lambda$1043743468$app_productionPFast;
                    AnimatedVisibilityKt.AnimatedVisibility(z11, (Modifier) null, enterTransitionFadeIn$default9, exitTransitionFadeOut$default9, (String) null, ComposableLambdaKt.rememberComposableLambda(-1975032038, true, new Function3() { // from class: t8.l
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return PagerStateIndicatorKt.PagerStateIndicator$lambda$0$0(lambda$1043743468$app_productionPFast, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, 200064, 18);
                    AnimatedVisibilityKt.AnimatedVisibility(list.getLoadState().getRefresh() instanceof LoadState.Error, (Modifier) null, EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null), EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null), (String) null, ComposableLambdaKt.rememberComposableLambda(877053905, true, new Function3() { // from class: t8.m
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return PagerStateIndicatorKt.PagerStateIndicator$lambda$0$1(oVarM10088getLambda$2139246109$app_productionPFast, list, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, 200064, 18);
                    AnimatedVisibilityKt.AnimatedVisibility(list.getLoadState().getAppend() instanceof LoadState.Loading, (Modifier) null, EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null), EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null), (String) null, ComposableLambdaKt.rememberComposableLambda(366041746, true, new Function3() { // from class: t8.n
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return PagerStateIndicatorKt.PagerStateIndicator$lambda$0$2(lambda$1044445317$app_productionPFast, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, 200064, 18);
                    AnimatedVisibilityKt.AnimatedVisibility(list.getLoadState().getAppend() instanceof LoadState.Error, (Modifier) null, EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null), EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null), (String) null, ComposableLambdaKt.rememberComposableLambda(-144970413, true, new Function3() { // from class: t8.o
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return PagerStateIndicatorKt.PagerStateIndicator$lambda$0$3(oVarM10088getLambda$2139246109$app_productionPFast, list, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, 200064, 18);
                    EnterTransition enterTransitionFadeIn$default10 = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null);
                    ExitTransition exitTransitionFadeOut$default10 = EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null);
                    if (list.getLoadState().getAppend() instanceof LoadState.NotLoading) {
                        z12 = false;
                    } else {
                        z12 = false;
                    }
                    AnimatedVisibilityKt.AnimatedVisibility(z12, (Modifier) null, enterTransitionFadeIn$default10, exitTransitionFadeOut$default10, (String) null, ComposableLambdaKt.rememberComposableLambda(-655982572, true, new Function3() { // from class: t8.p
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return PagerStateIndicatorKt.PagerStateIndicator$lambda$0$4(list, function113, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, 200064, 18);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    Function3 function115 = lambda$1044445317$app_productionPFast;
                    function10 = function113;
                    function9 = function115;
                    function8 = function114;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    function8 = function6;
                    oVarM10088getLambda$2139246109$app_productionPFast = oVar2;
                    function9 = function7;
                    function10 = function3M10087getLambda$1208785958$app_productionPFast;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: t8.q
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return PagerStateIndicatorKt.PagerStateIndicator$lambda$1(function8, oVarM10088getLambda$2139246109$app_productionPFast, function9, function10, list, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i12 |= 3072;
            function3M10087getLambda$1208785958$app_productionPFast = function5;
            if ((i10 & 24576) == 0) {
                if ((32768 & i10) == 0) {
                    zChangedInstance = composerStartRestartGroup.changed(list);
                } else {
                    zChangedInstance = composerStartRestartGroup.changedInstance(list);
                }
                if (zChangedInstance) {
                    i17 = 16384;
                } else {
                    i17 = 8192;
                }
                i12 |= i17;
            }
            if ((i12 & 9363) != 9362) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z10, i12 & 1)) {
                if (i18 != 0) {
                    lambda$1043743468$app_productionPFast = ComposableSingletons$PagerStateIndicatorKt.INSTANCE.getLambda$1043743468$app_productionPFast();
                } else {
                    lambda$1043743468$app_productionPFast = function6;
                }
                if (i19 != 0) {
                    oVarM10088getLambda$2139246109$app_productionPFast = ComposableSingletons$PagerStateIndicatorKt.INSTANCE.m10088getLambda$2139246109$app_productionPFast();
                } else {
                    oVarM10088getLambda$2139246109$app_productionPFast = oVar2;
                }
                if (i13 != 0) {
                    lambda$1044445317$app_productionPFast = ComposableSingletons$PagerStateIndicatorKt.INSTANCE.getLambda$1044445317$app_productionPFast();
                } else {
                    lambda$1044445317$app_productionPFast = function7;
                }
                if (i15 != 0) {
                    function3M10087getLambda$1208785958$app_productionPFast = ComposableSingletons$PagerStateIndicatorKt.INSTANCE.m10087getLambda$1208785958$app_productionPFast();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-449344365, i12, -1, "cu.todus.android.uiCompose.shared.pagerStateIndicator.PagerStateIndicator (PagerStateIndicator.kt:43)");
                }
                EnterTransition enterTransitionFadeIn$default11 = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null);
                ExitTransition exitTransitionFadeOut$default11 = EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null);
                if (list.getLoadState().getRefresh() instanceof LoadState.Loading) {
                    z11 = false;
                } else {
                    z11 = false;
                }
                final Function3 function116 = function3M10087getLambda$1208785958$app_productionPFast;
                Function3 function117 = lambda$1043743468$app_productionPFast;
                AnimatedVisibilityKt.AnimatedVisibility(z11, (Modifier) null, enterTransitionFadeIn$default11, exitTransitionFadeOut$default11, (String) null, ComposableLambdaKt.rememberComposableLambda(-1975032038, true, new Function3() { // from class: t8.l
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return PagerStateIndicatorKt.PagerStateIndicator$lambda$0$0(lambda$1043743468$app_productionPFast, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 200064, 18);
                AnimatedVisibilityKt.AnimatedVisibility(list.getLoadState().getRefresh() instanceof LoadState.Error, (Modifier) null, EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null), EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null), (String) null, ComposableLambdaKt.rememberComposableLambda(877053905, true, new Function3() { // from class: t8.m
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return PagerStateIndicatorKt.PagerStateIndicator$lambda$0$1(oVarM10088getLambda$2139246109$app_productionPFast, list, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 200064, 18);
                AnimatedVisibilityKt.AnimatedVisibility(list.getLoadState().getAppend() instanceof LoadState.Loading, (Modifier) null, EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null), EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null), (String) null, ComposableLambdaKt.rememberComposableLambda(366041746, true, new Function3() { // from class: t8.n
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return PagerStateIndicatorKt.PagerStateIndicator$lambda$0$2(lambda$1044445317$app_productionPFast, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 200064, 18);
                AnimatedVisibilityKt.AnimatedVisibility(list.getLoadState().getAppend() instanceof LoadState.Error, (Modifier) null, EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null), EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null), (String) null, ComposableLambdaKt.rememberComposableLambda(-144970413, true, new Function3() { // from class: t8.o
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return PagerStateIndicatorKt.PagerStateIndicator$lambda$0$3(oVarM10088getLambda$2139246109$app_productionPFast, list, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 200064, 18);
                EnterTransition enterTransitionFadeIn$default12 = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null);
                ExitTransition exitTransitionFadeOut$default12 = EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null);
                if (list.getLoadState().getAppend() instanceof LoadState.NotLoading) {
                    z12 = false;
                } else {
                    z12 = false;
                }
                AnimatedVisibilityKt.AnimatedVisibility(z12, (Modifier) null, enterTransitionFadeIn$default12, exitTransitionFadeOut$default12, (String) null, ComposableLambdaKt.rememberComposableLambda(-655982572, true, new Function3() { // from class: t8.p
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return PagerStateIndicatorKt.PagerStateIndicator$lambda$0$4(list, function116, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 200064, 18);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                Function3 function118 = lambda$1044445317$app_productionPFast;
                function10 = function116;
                function9 = function118;
                function8 = function117;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                function8 = function6;
                oVarM10088getLambda$2139246109$app_productionPFast = oVar2;
                function9 = function7;
                function10 = function3M10087getLambda$1208785958$app_productionPFast;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: t8.q
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return PagerStateIndicatorKt.PagerStateIndicator$lambda$1(function8, oVarM10088getLambda$2139246109$app_productionPFast, function9, function10, list, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i12 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        function7 = function4;
        i15 = i11 & 8;
        if (i15 != 0) {
            if ((i10 & 3072) == 0) {
                function3M10087getLambda$1208785958$app_productionPFast = function5;
                if (composerStartRestartGroup.changedInstance(function3M10087getLambda$1208785958$app_productionPFast)) {
                    i16 = 2048;
                } else {
                    i16 = 1024;
                }
                i12 |= i16;
            }
            if ((i10 & 24576) == 0) {
                if ((32768 & i10) == 0) {
                    zChangedInstance = composerStartRestartGroup.changed(list);
                } else {
                    zChangedInstance = composerStartRestartGroup.changedInstance(list);
                }
                if (zChangedInstance) {
                    i17 = 16384;
                } else {
                    i17 = 8192;
                }
                i12 |= i17;
            }
            if ((i12 & 9363) != 9362) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z10, i12 & 1)) {
                if (i18 != 0) {
                    lambda$1043743468$app_productionPFast = ComposableSingletons$PagerStateIndicatorKt.INSTANCE.getLambda$1043743468$app_productionPFast();
                } else {
                    lambda$1043743468$app_productionPFast = function6;
                }
                if (i19 != 0) {
                    oVarM10088getLambda$2139246109$app_productionPFast = ComposableSingletons$PagerStateIndicatorKt.INSTANCE.m10088getLambda$2139246109$app_productionPFast();
                } else {
                    oVarM10088getLambda$2139246109$app_productionPFast = oVar2;
                }
                if (i13 != 0) {
                    lambda$1044445317$app_productionPFast = ComposableSingletons$PagerStateIndicatorKt.INSTANCE.getLambda$1044445317$app_productionPFast();
                } else {
                    lambda$1044445317$app_productionPFast = function7;
                }
                if (i15 != 0) {
                    function3M10087getLambda$1208785958$app_productionPFast = ComposableSingletons$PagerStateIndicatorKt.INSTANCE.m10087getLambda$1208785958$app_productionPFast();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-449344365, i12, -1, "cu.todus.android.uiCompose.shared.pagerStateIndicator.PagerStateIndicator (PagerStateIndicator.kt:43)");
                }
                EnterTransition enterTransitionFadeIn$default13 = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null);
                ExitTransition exitTransitionFadeOut$default13 = EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null);
                if (list.getLoadState().getRefresh() instanceof LoadState.Loading) {
                    z11 = false;
                } else {
                    z11 = false;
                }
                final Function3 function119 = function3M10087getLambda$1208785958$app_productionPFast;
                Function3 function1110 = lambda$1043743468$app_productionPFast;
                AnimatedVisibilityKt.AnimatedVisibility(z11, (Modifier) null, enterTransitionFadeIn$default13, exitTransitionFadeOut$default13, (String) null, ComposableLambdaKt.rememberComposableLambda(-1975032038, true, new Function3() { // from class: t8.l
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return PagerStateIndicatorKt.PagerStateIndicator$lambda$0$0(lambda$1043743468$app_productionPFast, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 200064, 18);
                AnimatedVisibilityKt.AnimatedVisibility(list.getLoadState().getRefresh() instanceof LoadState.Error, (Modifier) null, EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null), EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null), (String) null, ComposableLambdaKt.rememberComposableLambda(877053905, true, new Function3() { // from class: t8.m
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return PagerStateIndicatorKt.PagerStateIndicator$lambda$0$1(oVarM10088getLambda$2139246109$app_productionPFast, list, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 200064, 18);
                AnimatedVisibilityKt.AnimatedVisibility(list.getLoadState().getAppend() instanceof LoadState.Loading, (Modifier) null, EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null), EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null), (String) null, ComposableLambdaKt.rememberComposableLambda(366041746, true, new Function3() { // from class: t8.n
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return PagerStateIndicatorKt.PagerStateIndicator$lambda$0$2(lambda$1044445317$app_productionPFast, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 200064, 18);
                AnimatedVisibilityKt.AnimatedVisibility(list.getLoadState().getAppend() instanceof LoadState.Error, (Modifier) null, EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null), EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null), (String) null, ComposableLambdaKt.rememberComposableLambda(-144970413, true, new Function3() { // from class: t8.o
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return PagerStateIndicatorKt.PagerStateIndicator$lambda$0$3(oVarM10088getLambda$2139246109$app_productionPFast, list, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 200064, 18);
                EnterTransition enterTransitionFadeIn$default14 = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null);
                ExitTransition exitTransitionFadeOut$default14 = EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null);
                if (list.getLoadState().getAppend() instanceof LoadState.NotLoading) {
                    z12 = false;
                } else {
                    z12 = false;
                }
                AnimatedVisibilityKt.AnimatedVisibility(z12, (Modifier) null, enterTransitionFadeIn$default14, exitTransitionFadeOut$default14, (String) null, ComposableLambdaKt.rememberComposableLambda(-655982572, true, new Function3() { // from class: t8.p
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return PagerStateIndicatorKt.PagerStateIndicator$lambda$0$4(list, function119, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 200064, 18);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                Function3 function1111 = lambda$1044445317$app_productionPFast;
                function10 = function119;
                function9 = function1111;
                function8 = function1110;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                function8 = function6;
                oVarM10088getLambda$2139246109$app_productionPFast = oVar2;
                function9 = function7;
                function10 = function3M10087getLambda$1208785958$app_productionPFast;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: t8.q
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return PagerStateIndicatorKt.PagerStateIndicator$lambda$1(function8, oVarM10088getLambda$2139246109$app_productionPFast, function9, function10, list, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i12 |= 3072;
        function3M10087getLambda$1208785958$app_productionPFast = function5;
        if ((i10 & 24576) == 0) {
            if ((32768 & i10) == 0) {
                zChangedInstance = composerStartRestartGroup.changed(list);
            } else {
                zChangedInstance = composerStartRestartGroup.changedInstance(list);
            }
            if (zChangedInstance) {
                i17 = 16384;
            } else {
                i17 = 8192;
            }
            i12 |= i17;
        }
        if ((i12 & 9363) != 9362) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z10, i12 & 1)) {
            if (i18 != 0) {
                lambda$1043743468$app_productionPFast = ComposableSingletons$PagerStateIndicatorKt.INSTANCE.getLambda$1043743468$app_productionPFast();
            } else {
                lambda$1043743468$app_productionPFast = function6;
            }
            if (i19 != 0) {
                oVarM10088getLambda$2139246109$app_productionPFast = ComposableSingletons$PagerStateIndicatorKt.INSTANCE.m10088getLambda$2139246109$app_productionPFast();
            } else {
                oVarM10088getLambda$2139246109$app_productionPFast = oVar2;
            }
            if (i13 != 0) {
                lambda$1044445317$app_productionPFast = ComposableSingletons$PagerStateIndicatorKt.INSTANCE.getLambda$1044445317$app_productionPFast();
            } else {
                lambda$1044445317$app_productionPFast = function7;
            }
            if (i15 != 0) {
                function3M10087getLambda$1208785958$app_productionPFast = ComposableSingletons$PagerStateIndicatorKt.INSTANCE.m10087getLambda$1208785958$app_productionPFast();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-449344365, i12, -1, "cu.todus.android.uiCompose.shared.pagerStateIndicator.PagerStateIndicator (PagerStateIndicator.kt:43)");
            }
            EnterTransition enterTransitionFadeIn$default15 = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null);
            ExitTransition exitTransitionFadeOut$default15 = EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null);
            if (list.getLoadState().getRefresh() instanceof LoadState.Loading) {
                z11 = false;
            } else {
                z11 = false;
            }
            final Function3 function1112 = function3M10087getLambda$1208785958$app_productionPFast;
            Function3 function1113 = lambda$1043743468$app_productionPFast;
            AnimatedVisibilityKt.AnimatedVisibility(z11, (Modifier) null, enterTransitionFadeIn$default15, exitTransitionFadeOut$default15, (String) null, ComposableLambdaKt.rememberComposableLambda(-1975032038, true, new Function3() { // from class: t8.l
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return PagerStateIndicatorKt.PagerStateIndicator$lambda$0$0(lambda$1043743468$app_productionPFast, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 200064, 18);
            AnimatedVisibilityKt.AnimatedVisibility(list.getLoadState().getRefresh() instanceof LoadState.Error, (Modifier) null, EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null), EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null), (String) null, ComposableLambdaKt.rememberComposableLambda(877053905, true, new Function3() { // from class: t8.m
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return PagerStateIndicatorKt.PagerStateIndicator$lambda$0$1(oVarM10088getLambda$2139246109$app_productionPFast, list, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 200064, 18);
            AnimatedVisibilityKt.AnimatedVisibility(list.getLoadState().getAppend() instanceof LoadState.Loading, (Modifier) null, EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null), EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null), (String) null, ComposableLambdaKt.rememberComposableLambda(366041746, true, new Function3() { // from class: t8.n
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return PagerStateIndicatorKt.PagerStateIndicator$lambda$0$2(lambda$1044445317$app_productionPFast, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 200064, 18);
            AnimatedVisibilityKt.AnimatedVisibility(list.getLoadState().getAppend() instanceof LoadState.Error, (Modifier) null, EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null), EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null), (String) null, ComposableLambdaKt.rememberComposableLambda(-144970413, true, new Function3() { // from class: t8.o
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return PagerStateIndicatorKt.PagerStateIndicator$lambda$0$3(oVarM10088getLambda$2139246109$app_productionPFast, list, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 200064, 18);
            EnterTransition enterTransitionFadeIn$default16 = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null);
            ExitTransition exitTransitionFadeOut$default16 = EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null);
            if (list.getLoadState().getAppend() instanceof LoadState.NotLoading) {
                z12 = false;
            } else {
                z12 = false;
            }
            AnimatedVisibilityKt.AnimatedVisibility(z12, (Modifier) null, enterTransitionFadeIn$default16, exitTransitionFadeOut$default16, (String) null, ComposableLambdaKt.rememberComposableLambda(-655982572, true, new Function3() { // from class: t8.p
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return PagerStateIndicatorKt.PagerStateIndicator$lambda$0$4(list, function1112, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 200064, 18);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            Function3 function1114 = lambda$1044445317$app_productionPFast;
            function10 = function1112;
            function9 = function1114;
            function8 = function1113;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            function8 = function6;
            oVarM10088getLambda$2139246109$app_productionPFast = oVar2;
            function9 = function7;
            function10 = function3M10087getLambda$1208785958$app_productionPFast;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: t8.q
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PagerStateIndicatorKt.PagerStateIndicator$lambda$1(function8, oVarM10088getLambda$2139246109$app_productionPFast, function9, function10, list, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    public static final k0 PagerStateIndicator$lambda$0$0(Function3 function3, AnimatedVisibilityScope AnimatedVisibility, Composer composer, int i10) {
        y.i(AnimatedVisibility, "$this$AnimatedVisibility");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1975032038, i10, -1, "cu.todus.android.uiCompose.shared.pagerStateIndicator.PagerStateIndicator.<anonymous>.<anonymous> (PagerStateIndicator.kt:50)");
        }
        function3.invoke(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    public static final k0 PagerStateIndicator$lambda$0$1(o oVar, final LazyPagingItems lazyPagingItems, AnimatedVisibilityScope AnimatedVisibility, Composer composer, int i10) {
        y.i(AnimatedVisibility, "$this$AnimatedVisibility");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(877053905, i10, -1, "cu.todus.android.uiCompose.shared.pagerStateIndicator.PagerStateIndicator.<anonymous>.<anonymous> (PagerStateIndicator.kt:58)");
        }
        Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
        boolean zChangedInstance = composer.changedInstance(lazyPagingItems);
        Object objRememberedValue = composer.rememberedValue();
        if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new a() { // from class: t8.k
                @Override // lb.a
                public final Object invoke() {
                    return PagerStateIndicatorKt.PagerStateIndicator$lambda$0$1$0$0(lazyPagingItems);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        oVar.invoke(modifierFillMaxSize$default, (a) objRememberedValue, composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 PagerStateIndicator$lambda$0$1$0$0(LazyPagingItems lazyPagingItems) {
        lazyPagingItems.retry();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    public static final k0 PagerStateIndicator$lambda$0$2(Function3 function3, AnimatedVisibilityScope AnimatedVisibility, Composer composer, int i10) {
        y.i(AnimatedVisibility, "$this$AnimatedVisibility");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(366041746, i10, -1, "cu.todus.android.uiCompose.shared.pagerStateIndicator.PagerStateIndicator.<anonymous>.<anonymous> (PagerStateIndicator.kt:68)");
        }
        function3.invoke(Modifier.INSTANCE, composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    public static final k0 PagerStateIndicator$lambda$0$3(o oVar, final LazyPagingItems lazyPagingItems, AnimatedVisibilityScope AnimatedVisibility, Composer composer, int i10) {
        y.i(AnimatedVisibility, "$this$AnimatedVisibility");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-144970413, i10, -1, "cu.todus.android.uiCompose.shared.pagerStateIndicator.PagerStateIndicator.<anonymous>.<anonymous> (PagerStateIndicator.kt:76)");
        }
        Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
        boolean zChangedInstance = composer.changedInstance(lazyPagingItems);
        Object objRememberedValue = composer.rememberedValue();
        if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new a() { // from class: t8.j
                @Override // lb.a
                public final Object invoke() {
                    return PagerStateIndicatorKt.PagerStateIndicator$lambda$0$3$0$0(lazyPagingItems);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        oVar.invoke(modifierFillMaxSize$default, (a) objRememberedValue, composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 PagerStateIndicator$lambda$0$3$0$0(LazyPagingItems lazyPagingItems) {
        lazyPagingItems.retry();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    public static final k0 PagerStateIndicator$lambda$0$4(LazyPagingItems lazyPagingItems, Function3 function3, AnimatedVisibilityScope AnimatedVisibility, Composer composer, int i10) {
        y.i(AnimatedVisibility, "$this$AnimatedVisibility");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-655982572, i10, -1, "cu.todus.android.uiCompose.shared.pagerStateIndicator.PagerStateIndicator.<anonymous>.<anonymous> (PagerStateIndicator.kt:86)");
        }
        if (lazyPagingItems.getItemCount() < 1) {
            composer.startReplaceGroup(960942581);
            function3.invoke(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), composer, 6);
        } else {
            composer.startReplaceGroup(-275519346);
        }
        composer.endReplaceGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 PagerStateIndicator$lambda$1(Function3 function3, o oVar, Function3 function4, Function3 function5, LazyPagingItems lazyPagingItems, int i10, int i11, Composer composer, int i12) {
        PagerStateIndicator(function3, oVar, function4, function5, lazyPagingItems, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return k0.f43947a;
    }
}
