package cu.todus.android.uiCompose.main.screen.pubEditor;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.foundation.pager.PagerKt;
import androidx.compose.foundation.pager.PagerScope;
import androidx.compose.foundation.pager.PagerState;
import androidx.compose.foundation.pager.PagerStateKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.MenuKt;
import androidx.compose.material.ScaffoldKt;
import androidx.compose.material.ScaffoldState;
import androidx.compose.material.TextKt;
import androidx.compose.material3.AppBarKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.TabKt;
import androidx.compose.material3.TabRowKt;
import androidx.compose.material3.TopAppBarDefaults;
import androidx.compose.material3.TopAppBarScrollBehavior;
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
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.navigation.NavHostController;
import androidx.p001lifecycle.HasDefaultViewModelProviderFactory;
import androidx.p001lifecycle.ViewModelProvider;
import androidx.p001lifecycle.ViewModelStoreOwner;
import androidx.p001lifecycle.viewmodel.CreationExtras;
import androidx.p001lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.p001lifecycle.viewmodel.compose.ViewModelKt;
import cu.z17.views.scaffold.Z17ScaffoldKt;
import cu.z17.views.topBar.Z17TopBarKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u001a)\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b\u001a-\u0010\u000e\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Landroidx/navigation/NavHostController;", "navHostController", "", "uid", "Lcu/todus/android/uiCompose/main/screen/pubEditor/PubEditorViewModel;", "viewModel", "Lua/k0;", "PubEditorScreen", "(Landroidx/navigation/NavHostController;Ljava/lang/String;Lcu/todus/android/uiCompose/main/screen/pubEditor/PubEditorViewModel;Landroidx/compose/runtime/Composer;II)V", "Lkotlin/Function0;", "onClick", "", "selected", "title", "TabItemEditorScreen", "(Llb/a;ZLjava/lang/String;Landroidx/compose/runtime/Composer;I)V", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class PublicationEditorScreenKt {
    /* JADX WARN: Code duplicated, block: B:58:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:61:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:64:0x0127  */
    /* JADX WARN: Code duplicated, block: B:67:0x0147  */
    /* JADX WARN: Code duplicated, block: B:70:0x0191  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void PubEditorScreen(final NavHostController navHostController, final String uid, PubEditorViewModel pubEditorViewModel, Composer composer, final int i10, final int i11) {
        int i12;
        PubEditorViewModel pubEditorViewModel2;
        final PubEditorViewModel pubEditorViewModel3;
        final List listQ;
        Object objRememberedValue;
        Composer.Companion companion;
        Object objRememberedValue2;
        Object objRememberedValue3;
        kotlin.jvm.internal.y.i(navHostController, "navHostController");
        kotlin.jvm.internal.y.i(uid, "uid");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1169930286);
        if ((i10 & 6) == 0) {
            i12 = (composerStartRestartGroup.changedInstance(navHostController) ? 4 : 2) | i10;
        } else {
            i12 = i10;
        }
        if ((i10 & 48) == 0) {
            i12 |= composerStartRestartGroup.changed(uid) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            if ((i11 & 4) == 0) {
                pubEditorViewModel2 = pubEditorViewModel;
                int i13 = composerStartRestartGroup.changedInstance(pubEditorViewModel2) ? 256 : 128;
                i12 |= i13;
            } else {
                pubEditorViewModel2 = pubEditorViewModel;
            }
            i12 |= i13;
        } else {
            pubEditorViewModel2 = pubEditorViewModel;
        }
        if (composerStartRestartGroup.shouldExecute((i12 & 147) != 146, i12 & 1)) {
            composerStartRestartGroup.startDefaults();
            if ((i10 & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                if ((i11 & 4) != 0) {
                    ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composerStartRestartGroup, 6);
                    if (current == null) {
                        throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                    }
                    pubEditorViewModel2 = (PubEditorViewModel) ViewModelKt.viewModel(kotlin.jvm.internal.z0.b(PubEditorViewModel.class), current, (String) null, (ViewModelProvider.Factory) null, current instanceof HasDefaultViewModelProviderFactory ? ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras() : CreationExtras.Empty.INSTANCE, composerStartRestartGroup, 0, 0);
                    i12 &= -897;
                }
                final PubEditorViewModel pubEditorViewModel4 = pubEditorViewModel2;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1169930286, i12, -1, "cu.todus.android.uiCompose.main.screen.pubEditor.PubEditorScreen (PublicationEditorScreen.kt:48)");
                }
                ScaffoldState scaffoldStateRememberScaffoldState = ScaffoldKt.rememberScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                listQ = va.w.q(new TabModel("Editor"), new TabModel("Preview"));
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                companion = Composer.INSTANCE;
                if (objRememberedValue == companion.getEmpty()) {
                    objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new TextFieldValue("", 0L, (TextRange) null, 6, (kotlin.jvm.internal.p) null), null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                final MutableState mutableState = (MutableState) objRememberedValue;
                final SoftwareKeyboardController softwareKeyboardController = (SoftwareKeyboardController) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalSoftwareKeyboardController());
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == companion.getEmpty()) {
                    objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.pubEditor.y0
                        @Override // lb.a
                        public final Object invoke() {
                            return Integer.valueOf(listQ.size());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                final PagerState pagerStateRememberPagerState = PagerStateKt.rememberPagerState(0, 0.0f, (lb.a) objRememberedValue2, composerStartRestartGroup, 390, 2);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue3 == companion.getEmpty()) {
                    objRememberedValue3 = EffectsKt.createCompositionCoroutineScope(ab.j.f643c, composerStartRestartGroup);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                final pe.m0 m0Var = (pe.m0) objRememberedValue3;
                Z17ScaffoldKt.m10301Z17BaseScaffoldueL0Wzs(ComposableLambdaKt.rememberComposableLambda(252293150, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.pubEditor.z0
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return PublicationEditorScreenKt.PubEditorScreen$lambda$2(navHostController, (TopAppBarScrollBehavior) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), false, false, false, null, null, 0L, scaffoldStateRememberScaffoldState, null, ComposableLambdaKt.rememberComposableLambda(-759855652, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.pubEditor.a1
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return PublicationEditorScreenKt.PubEditorScreen$lambda$3(pagerStateRememberPagerState, softwareKeyboardController, listQ, m0Var, mutableState, pubEditorViewModel4, uid, navHostController, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 805306806, 376);
                composerStartRestartGroup = composerStartRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                pubEditorViewModel3 = pubEditorViewModel4;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i11 & 4) != 0) {
                    i12 &= -897;
                }
            }
            final PubEditorViewModel pubEditorViewModel5 = pubEditorViewModel2;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1169930286, i12, -1, "cu.todus.android.uiCompose.main.screen.pubEditor.PubEditorScreen (PublicationEditorScreen.kt:48)");
            }
            ScaffoldState scaffoldStateRememberScaffoldState2 = ScaffoldKt.rememberScaffoldState(null, null, composerStartRestartGroup, 0, 3);
            listQ = va.w.q(new TabModel("Editor"), new TabModel("Preview"));
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            companion = Composer.INSTANCE;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new TextFieldValue("", 0L, (TextRange) null, 6, (kotlin.jvm.internal.p) null), null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final MutableState mutableState2 = (MutableState) objRememberedValue;
            final SoftwareKeyboardController softwareKeyboardController2 = (SoftwareKeyboardController) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalSoftwareKeyboardController());
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.pubEditor.y0
                    @Override // lb.a
                    public final Object invoke() {
                        return Integer.valueOf(listQ.size());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            final PagerState pagerStateRememberPagerState2 = PagerStateKt.rememberPagerState(0, 0.0f, (lb.a) objRememberedValue2, composerStartRestartGroup, 390, 2);
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == companion.getEmpty()) {
                objRememberedValue3 = EffectsKt.createCompositionCoroutineScope(ab.j.f643c, composerStartRestartGroup);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            final pe.m0 m0Var2 = (pe.m0) objRememberedValue3;
            Z17ScaffoldKt.m10301Z17BaseScaffoldueL0Wzs(ComposableLambdaKt.rememberComposableLambda(252293150, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.pubEditor.z0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return PublicationEditorScreenKt.PubEditorScreen$lambda$2(navHostController, (TopAppBarScrollBehavior) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), false, false, false, null, null, 0L, scaffoldStateRememberScaffoldState2, null, ComposableLambdaKt.rememberComposableLambda(-759855652, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.pubEditor.a1
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return PublicationEditorScreenKt.PubEditorScreen$lambda$3(pagerStateRememberPagerState2, softwareKeyboardController2, listQ, m0Var2, mutableState2, pubEditorViewModel5, uid, navHostController, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 805306806, 376);
            composerStartRestartGroup = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            pubEditorViewModel3 = pubEditorViewModel5;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            pubEditorViewModel3 = pubEditorViewModel2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.pubEditor.b1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PublicationEditorScreenKt.PubEditorScreen$lambda$4(navHostController, uid, pubEditorViewModel3, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 PubEditorScreen$lambda$2(final NavHostController navHostController, TopAppBarScrollBehavior it, Composer composer, int i10) {
        kotlin.jvm.internal.y.i(it, "it");
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(252293150, i10, -1, "cu.todus.android.uiCompose.main.screen.pubEditor.PubEditorScreen.<anonymous> (PublicationEditorScreen.kt:68)");
            }
            Function2 function2M9959getLambda$2110152207$app_productionPFast = ComposableSingletons$PublicationEditorScreenKt.INSTANCE.m9959getLambda$2110152207$app_productionPFast();
            TopAppBarScrollBehavior topAppBarScrollBehaviorPinnedScrollBehavior = TopAppBarDefaults.INSTANCE.pinnedScrollBehavior(AppBarKt.rememberTopAppBarState(0.0f, 0.0f, 0.0f, composer, 0, 7), null, composer, TopAppBarDefaults.$stable << 6, 2);
            boolean zChangedInstance = composer.changedInstance(navHostController);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.pubEditor.g1
                    @Override // lb.a
                    public final Object invoke() {
                        return PublicationEditorScreenKt.PubEditorScreen$lambda$2$0$0(navHostController);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            Z17TopBarKt.m10304Z17TopBardW2gCk(function2M9959getLambda$2110152207$app_productionPFast, topAppBarScrollBehaviorPinnedScrollBehavior, false, null, false, navHostController, (lb.a) objRememberedValue, null, 0L, 0L, Dp.m8823constructorimpl(0), composer, 6, 6, 924);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 PubEditorScreen$lambda$2$0$0(NavHostController navHostController) {
        navHostController.navigateUp();
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 PubEditorScreen$lambda$3(final PagerState pagerState, final SoftwareKeyboardController softwareKeyboardController, final List list, final pe.m0 m0Var, final MutableState mutableState, final PubEditorViewModel pubEditorViewModel, final String str, final NavHostController navHostController, Modifier it, Composer composer, int i10) {
        int i11;
        kotlin.jvm.internal.y.i(it, "it");
        if ((i10 & 6) == 0) {
            i11 = i10 | (composer.changed(it) ? 4 : 2);
        } else {
            i11 = i10;
        }
        if (composer.shouldExecute((i11 & 19) != 18, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-759855652, i11, -1, "cu.todus.android.uiCompose.main.screen.pubEditor.PubEditorScreen.<anonymous> (PublicationEditorScreen.kt:84)");
            }
            Modifier modifierImePadding = WindowInsetsPadding_androidKt.imePadding(it);
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer, 0);
            int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierImePadding);
            ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
            lb.a constructor = companion.getConstructor();
            if (!defpackage.r.a(composer.getApplier())) {
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
            Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl, companion.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            int currentPage = pagerState.getCurrentPage();
            Modifier.Companion companion2 = Modifier.INSTANCE;
            TabRowKt.m3761TabRowpAZo6Ak(currentPage, BackgroundKt.m1205backgroundbw27NRU$default(companion2, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getBackground(), null, 2, null), 0L, 0L, null, null, ComposableLambdaKt.rememberComposableLambda(-1754955122, true, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.pubEditor.e1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PublicationEditorScreenKt.PubEditorScreen$lambda$3$0$0(list, softwareKeyboardController, m0Var, pagerState, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, 1572864, 60);
            PagerKt.m1961HorizontalPager8jOkeI(pagerState, androidx.compose.foundation.layout.x.a(columnScopeInstance, companion2, 1.0f, false, 2, null), null, null, 0, 0.0f, null, null, false, false, null, null, null, null, ComposableLambdaKt.rememberComposableLambda(62572613, true, new lb.o() { // from class: cu.todus.android.uiCompose.main.screen.pubEditor.f1
                @Override // lb.o
                public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    return PublicationEditorScreenKt.PubEditorScreen$lambda$3$0$1(mutableState, pubEditorViewModel, str, navHostController, (PagerScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
                }
            }, composer, 54), composer, 0, 24576, 16380);
            Integer numValueOf = Integer.valueOf(pagerState.getCurrentPage());
            boolean zChanged = composer.changed(softwareKeyboardController);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new PublicationEditorScreenKt$PubEditorScreen$2$1$3$1(softwareKeyboardController, null);
                composer.updateRememberedValue(objRememberedValue);
            }
            EffectsKt.LaunchedEffect(numValueOf, (Function2) objRememberedValue, composer, 0);
            composer.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 PubEditorScreen$lambda$3$0$0(List list, final SoftwareKeyboardController softwareKeyboardController, final pe.m0 m0Var, final PagerState pagerState, Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1754955122, i10, -1, "cu.todus.android.uiCompose.main.screen.pubEditor.PubEditorScreen.<anonymous>.<anonymous>.<anonymous> (PublicationEditorScreen.kt:89)");
            }
            final int i11 = 0;
            for (Object obj : list) {
                int i12 = i11 + 1;
                if (i11 < 0) {
                    va.w.x();
                }
                TabModel tabModel = (TabModel) obj;
                boolean zChanged = composer.changed(softwareKeyboardController) | composer.changedInstance(m0Var) | composer.changed(pagerState) | composer.changed(i11);
                Object objRememberedValue = composer.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.pubEditor.x0
                        @Override // lb.a
                        public final Object invoke() {
                            return PublicationEditorScreenKt.PubEditorScreen$lambda$3$0$0$0$0$0(softwareKeyboardController, m0Var, pagerState, i11);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                TabItemEditorScreen((lb.a) objRememberedValue, pagerState.getCurrentPage() == i11, tabModel.getTitle(), composer, 0);
                i11 = i12;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 PubEditorScreen$lambda$3$0$0$0$0$0(SoftwareKeyboardController softwareKeyboardController, pe.m0 m0Var, PagerState pagerState, int i10) {
        if (softwareKeyboardController != null) {
            softwareKeyboardController.hide();
        }
        pe.k.d(m0Var, null, null, new PublicationEditorScreenKt$PubEditorScreen$2$1$1$1$1$1$1(pagerState, i10, null), 3, null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 PubEditorScreen$lambda$3$0$1(MutableState mutableState, final PubEditorViewModel pubEditorViewModel, final String str, final NavHostController navHostController, PagerScope HorizontalPager, int i10, Composer composer, int i11) {
        kotlin.jvm.internal.y.i(HorizontalPager, "$this$HorizontalPager");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(62572613, i11, -1, "cu.todus.android.uiCompose.main.screen.pubEditor.PubEditorScreen.<anonymous>.<anonymous>.<anonymous> (PublicationEditorScreen.kt:106)");
        }
        if (i10 == 0) {
            composer.startReplaceGroup(84988641);
            MDEditorFunKt.MDEditorFun(mutableState, composer, 6);
            composer.endReplaceGroup();
        } else if (i10 != 1) {
            composer.startReplaceGroup(85589917);
            composer.endReplaceGroup();
        } else {
            composer.startReplaceGroup(85118469);
            boolean zChangedInstance = composer.changedInstance(pubEditorViewModel) | composer.changed(str) | composer.changedInstance(navHostController);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.pubEditor.w0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return PublicationEditorScreenKt.PubEditorScreen$lambda$3$0$1$0$0(pubEditorViewModel, str, navHostController, (String) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            EditorPreviewKt.PreviewTab(mutableState, (Function1) objRememberedValue, composer, 6);
            composer.endReplaceGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 PubEditorScreen$lambda$3$0$1$0$0(PubEditorViewModel pubEditorViewModel, String str, NavHostController navHostController, String msg) {
        kotlin.jvm.internal.y.i(msg, "msg");
        pubEditorViewModel.sendMessage(msg, str);
        navHostController.navigateUp();
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 PubEditorScreen$lambda$4(NavHostController navHostController, String str, PubEditorViewModel pubEditorViewModel, int i10, int i11, Composer composer, int i12) {
        PubEditorScreen(navHostController, str, pubEditorViewModel, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return ua.k0.f43947a;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void TabItemEditorScreen(final lb.a onClick, final boolean z10, final String title, Composer composer, final int i10) {
        int i11;
        final String str;
        long onBackground;
        int i12;
        Object obj;
        float f10;
        kotlin.jvm.internal.y.i(onClick, "onClick");
        kotlin.jvm.internal.y.i(title, "title");
        Composer composerStartRestartGroup = composer.startRestartGroup(-2079390592);
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
        int i13 = i11;
        if (composerStartRestartGroup.shouldExecute((i13 & 147) != 146, i13 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2079390592, i13, -1, "cu.todus.android.uiCompose.main.screen.pubEditor.TabItemEditorScreen (PublicationEditorScreen.kt:137)");
            }
            final float fM8823constructorimpl = Dp.m8823constructorimpl(30);
            final float fM8823constructorimpl2 = Dp.m8823constructorimpl(5);
            composerStartRestartGroup.startReplaceGroup(z10 ? -1134559380 : -1134557972);
            final long onBackground2 = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnBackground();
            composerStartRestartGroup.endReplaceGroup();
            if (z10) {
                composerStartRestartGroup.startReplaceGroup(-1134554925);
                onBackground = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnBackground();
                i12 = 14;
                obj = null;
                f10 = 0.05f;
            } else {
                composerStartRestartGroup.startReplaceGroup(-1134552856);
                onBackground = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnBackground();
                i12 = 14;
                obj = null;
                f10 = 0.2f;
            }
            long jM5865copywmQWz5c$default = Color.m5865copywmQWz5c$default(onBackground, f10, 0.0f, 0.0f, 0.0f, i12, obj);
            composerStartRestartGroup.endReplaceGroup();
            float f11 = 16;
            str = title;
            TabKt.m3740TabbogVsAg(z10, onClick, BackgroundKt.m1205backgroundbw27NRU$default(ClipKt.clip(BackgroundKt.m1205backgroundbw27NRU$default(Modifier.INSTANCE, MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground(), null, 2, null), RoundedCornerShapeKt.m2017RoundedCornerShapea9UjIt4$default(Dp.m8823constructorimpl(f11), Dp.m8823constructorimpl(f11), 0.0f, 0.0f, 12, null)), jM5865copywmQWz5c$default, null, 2, null), false, 0L, 0L, null, ComposableLambdaKt.rememberComposableLambda(442133997, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.pubEditor.c1
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj2, Object obj3, Object obj4) {
                    return PublicationEditorScreenKt.TabItemEditorScreen$lambda$0(fM8823constructorimpl2, fM8823constructorimpl, title, onBackground2, (ColumnScope) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i13 >> 3) & 14) | 12582912 | ((i13 << 3) & 112), MenuKt.InTransitionDuration);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            str = title;
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.pubEditor.d1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return PublicationEditorScreenKt.TabItemEditorScreen$lambda$1(onClick, z10, str, i10, (Composer) obj2, ((Integer) obj3).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 TabItemEditorScreen$lambda$0(float f10, float f11, String str, long j10, ColumnScope Tab, Composer composer, int i10) {
        kotlin.jvm.internal.y.i(Tab, "$this$Tab");
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(442133997, i10, -1, "cu.todus.android.uiCompose.main.screen.pubEditor.TabItemEditorScreen.<anonymous> (PublicationEditorScreen.kt:157)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(SizeKt.m1755height3ABfNKs(PaddingKt.m1729paddingqDBjuR0$default(companion, 0.0f, Dp.m8823constructorimpl(10), 0.0f, f10, 5, null), f11), 0.0f, 1, null);
            Alignment.Companion companion2 = Alignment.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), companion2.getCenterHorizontally(), composer, 48);
            int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierFillMaxWidth$default);
            ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
            lb.a constructor = companion3.getConstructor();
            if (!defpackage.r.a(composer.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor);
            } else {
                composer.useNode();
            }
            Composer composerM5176constructorimpl = Updater.m5176constructorimpl(composer);
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyColumnMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion3.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl, companion3.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion3.getSetModifier());
            TextKt.m2800Text4IGK_g(str, ColumnScopeInstance.INSTANCE.align(companion, companion2.getCenterHorizontally()), j10, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer, 0, 0, 131064);
            composer.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 TabItemEditorScreen$lambda$1(lb.a aVar, boolean z10, String str, int i10, Composer composer, int i11) {
        TabItemEditorScreen(aVar, z10, str, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1));
        return ua.k0.f43947a;
    }
}
