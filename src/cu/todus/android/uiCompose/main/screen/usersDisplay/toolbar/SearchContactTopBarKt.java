package cu.todus.android.uiCompose.main.screen.usersDisplay.toolbar;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.e3;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.focus.FocusRequesterModifierKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.navigation.NavHostController;
import cu.z17.views.inputText.Z17InputTextKt;
import cu.z17.views.topBar.Z17TopBarKt;
import defpackage.l;
import defpackage.r;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.y;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u001a9\u0010\b\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u0005H\u0007¢\u0006\u0004\b\b\u0010\t\u001a9\u0010\u000b\u001a\u00020\u00032\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\n\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r²\u0006\u000e\u0010\n\u001a\u00020\u00068\n@\nX\u008a\u008e\u0002"}, d2 = {"Landroidx/navigation/NavHostController;", "navHostController", "Lkotlin/Function0;", "Lua/k0;", "onClose", "Lkotlin/Function1;", "", "onSearch", "SearchContactTopBar", "(Landroidx/navigation/NavHostController;Llb/a;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "filter", "SearchInput", "(Lkotlin/jvm/functions/Function1;Llb/a;Ljava/lang/String;Landroidx/compose/runtime/Composer;I)V", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class SearchContactTopBarKt {
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void SearchContactTopBar(final NavHostController navHostController, final lb.a onClose, final Function1 onSearch, Composer composer, final int i10) {
        int i11;
        y.i(navHostController, "navHostController");
        y.i(onClose, "onClose");
        y.i(onSearch, "onSearch");
        Composer composerStartRestartGroup = composer.startRestartGroup(1872943654);
        if ((i10 & 6) == 0) {
            i11 = (composerStartRestartGroup.changedInstance(navHostController) ? 4 : 2) | i10;
        } else {
            i11 = i10;
        }
        if ((i10 & 48) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(onClose) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(onSearch) ? 256 : 128;
        }
        if (composerStartRestartGroup.shouldExecute((i11 & 147) != 146, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1872943654, i11, -1, "cu.todus.android.uiCompose.main.screen.usersDisplay.toolbar.SearchContactTopBar (SearchContactTopBar.kt:33)");
            }
            Function2 function2M10000getLambda$1751361229$app_productionPFast = ComposableSingletons$SearchContactTopBarKt.INSTANCE.m10000getLambda$1751361229$app_productionPFast();
            ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1418514018, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.usersDisplay.toolbar.i
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return SearchContactTopBarKt.SearchContactTopBar$lambda$0(onSearch, onClose, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54);
            boolean z10 = (i11 & 112) == 32;
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z10 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.usersDisplay.toolbar.j
                    @Override // lb.a
                    public final Object invoke() {
                        return SearchContactTopBarKt.SearchContactTopBar$lambda$1$0(onClose);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            Z17TopBarKt.m10304Z17TopBardW2gCk(function2M10000getLambda$1751361229$app_productionPFast, null, false, composableLambdaRememberComposableLambda, false, navHostController, (lb.a) objRememberedValue, null, 0L, 0L, Dp.m8823constructorimpl(4), composerStartRestartGroup, ((i11 << 15) & 458752) | 27654, 6, TypedValues.Custom.TYPE_COLOR);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.usersDisplay.toolbar.k
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SearchContactTopBarKt.SearchContactTopBar$lambda$2(navHostController, onClose, onSearch, i10, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 SearchContactTopBar$lambda$0(final Function1 function1, final lb.a aVar, RowScope Z17TopBar, Composer composer, int i10) {
        y.i(Z17TopBar, "$this$Z17TopBar");
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1418514018, i10, -1, "cu.todus.android.uiCompose.main.screen.usersDisplay.toolbar.SearchContactTopBar.<anonymous> (SearchContactTopBar.kt:37)");
            }
            Object objRememberedValue = composer.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
                composer.updateRememberedValue(objRememberedValue);
            }
            final MutableState mutableState = (MutableState) objRememberedValue;
            boolean zChanged = composer.changed(function1);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChanged || objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.usersDisplay.toolbar.g
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return SearchContactTopBarKt.SearchContactTopBar$lambda$0$3$0(function1, mutableState, (String) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            Function1 function2 = (Function1) objRememberedValue2;
            boolean zChanged2 = composer.changed(aVar);
            Object objRememberedValue3 = composer.rememberedValue();
            if (zChanged2 || objRememberedValue3 == companion.getEmpty()) {
                objRememberedValue3 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.usersDisplay.toolbar.h
                    @Override // lb.a
                    public final Object invoke() {
                        return SearchContactTopBarKt.SearchContactTopBar$lambda$0$4$0(aVar, mutableState);
                    }
                };
                composer.updateRememberedValue(objRememberedValue3);
            }
            SearchInput(function2, (lb.a) objRememberedValue3, SearchContactTopBar$lambda$0$1(mutableState), composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    private static final String SearchContactTopBar$lambda$0$1(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 SearchContactTopBar$lambda$0$3$0(Function1 function1, MutableState mutableState, String it) {
        y.i(it, "it");
        mutableState.setValue(it);
        function1.invoke(SearchContactTopBar$lambda$0$1(mutableState));
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 SearchContactTopBar$lambda$0$4$0(lb.a aVar, MutableState mutableState) {
        mutableState.setValue("");
        aVar.invoke();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 SearchContactTopBar$lambda$1$0(lb.a aVar) {
        aVar.invoke();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 SearchContactTopBar$lambda$2(NavHostController navHostController, lb.a aVar, Function1 function1, int i10, Composer composer, int i11) {
        SearchContactTopBar(navHostController, aVar, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1));
        return k0.f43947a;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void SearchInput(final Function1 onSearch, final lb.a onClose, final String filter, Composer composer, final int i10) {
        int i11;
        y.i(onSearch, "onSearch");
        y.i(onClose, "onClose");
        y.i(filter, "filter");
        Composer composerStartRestartGroup = composer.startRestartGroup(-741418598);
        if ((i10 & 6) == 0) {
            i11 = (composerStartRestartGroup.changedInstance(onSearch) ? 4 : 2) | i10;
        } else {
            i11 = i10;
        }
        if ((i10 & 48) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(onClose) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i11 |= composerStartRestartGroup.changed(filter) ? 256 : 128;
        }
        if (composerStartRestartGroup.shouldExecute((i11 & 147) != 146, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-741418598, i11, -1, "cu.todus.android.uiCompose.main.screen.usersDisplay.toolbar.SearchInput (SearchContactTopBar.kt:64)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getTop(), composerStartRestartGroup, 0);
            int iA = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
            ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
            lb.a constructor = companion2.getConstructor();
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
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyRowMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion2.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl, companion2.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion2.getSetModifier());
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            Composer.Companion companion3 = Composer.INSTANCE;
            if (objRememberedValue == companion3.getEmpty()) {
                objRememberedValue = new FocusRequester();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            FocusRequester focusRequester = (FocusRequester) objRememberedValue;
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(PaddingKt.m1729paddingqDBjuR0$default(e3.a(rowScopeInstance, FocusRequesterModifierKt.focusRequester(companion, focusRequester), 1.0f, false, 2, null), Dp.m8823constructorimpl(20), 0.0f, 0.0f, 0.0f, 14, null), 0.0f, 1, null);
            RoundedCornerShape circleShape = RoundedCornerShapeKt.getCircleShape();
            boolean z10 = (i11 & 14) == 4;
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (z10 || objRememberedValue2 == companion3.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.usersDisplay.toolbar.d
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return SearchContactTopBarKt.SearchInput$lambda$0$1$0(onSearch, (String) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposableSingletons$SearchContactTopBarKt composableSingletons$SearchContactTopBarKt = ComposableSingletons$SearchContactTopBarKt.INSTANCE;
            Z17InputTextKt.m10251Z17InputTextf9_u2OI(modifierFillMaxWidth$default, filter, 1, 0, null, null, (Function1) objRememberedValue2, composableSingletons$SearchContactTopBarKt.getLambda$961044201$app_productionPFast(), null, 0, 0, 0L, 0L, 0L, 0L, 0L, null, false, circleShape, false, composerStartRestartGroup, ((i11 >> 3) & 112) | 12583296, 0, 786232);
            composerStartRestartGroup = composerStartRestartGroup;
            boolean z11 = (i11 & 112) == 32;
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (z11 || objRememberedValue3 == companion3.getEmpty()) {
                objRememberedValue3 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.usersDisplay.toolbar.e
                    @Override // lb.a
                    public final Object invoke() {
                        return SearchContactTopBarKt.SearchInput$lambda$0$2$0(onClose);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            IconButtonKt.IconButton((lb.a) objRememberedValue3, PaddingKt.m1727paddingVpY3zN4$default(companion, Dp.m8823constructorimpl(5), 0.0f, 2, null), false, null, null, null, composableSingletons$SearchContactTopBarKt.m10001getLambda$748205796$app_productionPFast(), composerStartRestartGroup, 1572912, 60);
            k0 k0Var = k0.f43947a;
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue4 == companion3.getEmpty()) {
                objRememberedValue4 = new SearchContactTopBarKt$SearchInput$1$3$1(focusRequester, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            EffectsKt.LaunchedEffect(k0Var, (Function2) objRememberedValue4, composerStartRestartGroup, 6);
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.usersDisplay.toolbar.f
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SearchContactTopBarKt.SearchInput$lambda$1(onSearch, onClose, filter, i10, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 SearchInput$lambda$0$1$0(Function1 function1, String it) {
        y.i(it, "it");
        function1.invoke(it);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 SearchInput$lambda$0$2$0(lb.a aVar) {
        aVar.invoke();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 SearchInput$lambda$1(Function1 function1, lb.a aVar, String str, int i10, Composer composer, int i11) {
        SearchInput(function1, aVar, str, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1));
        return k0.f43947a;
    }
}
