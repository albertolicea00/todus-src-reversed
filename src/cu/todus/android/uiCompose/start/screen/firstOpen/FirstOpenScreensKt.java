package cu.todus.android.uiCompose.start.screen.firstOpen;

import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.e3;
import androidx.compose.foundation.layout.x;
import androidx.compose.foundation.pager.PagerKt;
import androidx.compose.foundation.pager.PagerState;
import androidx.compose.foundation.pager.PagerStateKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.SurfaceKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.navigation.NavController;
import androidx.navigation.NavHostController;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigator;
import androidx.profileinstaller.ProfileVerifier;
import cu.todus.android.R;
import cu.todus.android.uiCompose.navigation.NavLinks;
import cu.z17.views.button.Z17ButtonsKt;
import cu.z17.views.label.Z17LabelKt;
import cu.z17.views.pagerIndicator.Z17PagerIndicatorKt;
import cu.z17.views.picture.Z17PictureKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.y;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;
import org.jivesoftware.smackx.xdatalayout.packet.DataLayout;
import pe.m0;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u0007\u0010\b\u001a\u001d\u0010\u000b\u001a\u00020\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\tH\u0007¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Landroidx/navigation/NavHostController;", "navHostController", "Lua/k0;", "FirstOpenScreen", "(Landroidx/navigation/NavHostController;Landroidx/compose/runtime/Composer;I)V", "Lcu/todus/android/uiCompose/start/screen/firstOpen/Page;", DataLayout.ELEMENT, "PageUi", "(Lcu/todus/android/uiCompose/start/screen/firstOpen/Page;Landroidx/compose/runtime/Composer;I)V", "Lkotlin/Function0;", "goWelcome", "FirstStartPageController", "(Llb/a;Landroidx/compose/runtime/Composer;I)V", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class FirstOpenScreensKt {
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void FirstOpenScreen(final NavHostController navHostController, Composer composer, final int i10) {
        int i11;
        y.i(navHostController, "navHostController");
        Composer composerStartRestartGroup = composer.startRestartGroup(-828379860);
        if ((i10 & 6) == 0) {
            i11 = (composerStartRestartGroup.changedInstance(navHostController) ? 4 : 2) | i10;
        } else {
            i11 = i10;
        }
        if (composerStartRestartGroup.shouldExecute((i11 & 3) != 2, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-828379860, i11, -1, "cu.todus.android.uiCompose.start.screen.firstOpen.FirstOpenScreen (FirstOpenScreens.kt:41)");
            }
            SurfaceKt.m3707SurfaceT9BRK9s(null, null, MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground(), 0L, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(370444871, true, new Function2() { // from class: cu.todus.android.uiCompose.start.screen.firstOpen.h
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FirstOpenScreensKt.FirstOpenScreen$lambda$0(navHostController, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 12582912, 123);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.start.screen.firstOpen.i
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FirstOpenScreensKt.FirstOpenScreen$lambda$1(navHostController, i10, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 FirstOpenScreen$lambda$0(final NavHostController navHostController, Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(370444871, i10, -1, "cu.todus.android.uiCompose.start.screen.firstOpen.FirstOpenScreen.<anonymous> (FirstOpenScreens.kt:45)");
            }
            boolean zChangedInstance = composer.changedInstance(navHostController);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.start.screen.firstOpen.k
                    @Override // lb.a
                    public final Object invoke() {
                        return FirstOpenScreensKt.FirstOpenScreen$lambda$0$0$0(navHostController);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            FirstStartPageController((lb.a) objRememberedValue, composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 FirstOpenScreen$lambda$0$0$0(NavHostController navHostController) {
        NavController.navigate$default((NavController) navHostController, NavLinks.WELCOME, (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 FirstOpenScreen$lambda$1(NavHostController navHostController, int i10, Composer composer, int i11) {
        FirstOpenScreen(navHostController, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1));
        return k0.f43947a;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void FirstStartPageController(lb.a goWelcome, Composer composer, final int i10) {
        int i11;
        final lb.a aVar;
        y.i(goWelcome, "goWelcome");
        Composer composerStartRestartGroup = composer.startRestartGroup(300369424);
        if ((i10 & 6) == 0) {
            i11 = i10 | (composerStartRestartGroup.changedInstance(goWelcome) ? 4 : 2);
        } else {
            i11 = i10;
        }
        if (composerStartRestartGroup.shouldExecute((i11 & 3) != 2, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(300369424, i11, -1, "cu.todus.android.uiCompose.start.screen.firstOpen.FirstStartPageController (FirstOpenScreens.kt:87)");
            }
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = EffectsKt.createCompositionCoroutineScope(ab.j.f643c, composerStartRestartGroup);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final m0 m0Var = (m0) objRememberedValue;
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.start.screen.firstOpen.l
                    @Override // lb.a
                    public final Object invoke() {
                        return Integer.valueOf(FirstOpenScreensKt.FirstStartPageController$lambda$0$0());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            final PagerState pagerStateRememberPagerState = PagerStateKt.rememberPagerState(0, 0.0f, (lb.a) objRememberedValue2, composerStartRestartGroup, 390, 2);
            Modifier.Companion companion2 = Modifier.INSTANCE;
            Arrangement.Vertical top = Arrangement.INSTANCE.getTop();
            Alignment.Companion companion3 = Alignment.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(top, companion3.getStart(), composerStartRestartGroup, 0);
            int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion2);
            ComposeUiNode.Companion companion4 = ComposeUiNode.INSTANCE;
            lb.a constructor = companion4.getConstructor();
            if (!defpackage.r.a(composerStartRestartGroup.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM5176constructorimpl = Updater.m5176constructorimpl(composerStartRestartGroup);
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyColumnMeasurePolicy, companion4.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion4.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion4.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl, companion4.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion4.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            PagerKt.m1961HorizontalPager8jOkeI(pagerStateRememberPagerState, x.a(columnScopeInstance, SizeKt.fillMaxSize$default(companion2, 0.0f, 1, null), 1.0f, false, 2, null), null, null, 0, 0.0f, null, null, false, false, null, null, null, null, ComposableSingletons$FirstOpenScreensKt.INSTANCE.getLambda$632535929$app_productionPFast(), composerStartRestartGroup, 0, 24576, 16380);
            Z17PagerIndicatorKt.m10266Z17PagerIndicatorD_W6g9U(pagerStateRememberPagerState, PaddingKt.m1725padding3ABfNKs(columnScopeInstance.align(companion2, companion3.getCenterHorizontally()), Dp.m8823constructorimpl(8)), null, Color.INSTANCE.m5900getRed0d7_KjU(), 0L, 0.0f, 0.0f, 0.0f, null, composerStartRestartGroup, 3072, XMPPTCPConnection.PacketWriter.QUEUE_SIZE);
            composerStartRestartGroup = composerStartRestartGroup;
            Modifier modifierM1725padding3ABfNKs = PaddingKt.m1725padding3ABfNKs(companion2, Dp.m8823constructorimpl(20));
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion3.getTopStart(), false);
            int iA2 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1725padding3ABfNKs);
            lb.a constructor2 = companion4.getConstructor();
            if (!defpackage.r.a(composerStartRestartGroup.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor2);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM5176constructorimpl2 = Updater.m5176constructorimpl(composerStartRestartGroup);
            Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy, companion4.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap2, companion4.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl2, Integer.valueOf(iA2), companion4.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl2, companion4.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier2, companion4.getSetModifier());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            boolean z10 = pagerStateRememberPagerState.getCurrentPage() != pagerStateRememberPagerState.getPageCount() + (-1);
            TweenSpec tweenSpecTween$default = AnimationSpecKt.tween$default(300, 0, null, 6, null);
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == companion.getEmpty()) {
                objRememberedValue3 = new Function1() { // from class: cu.todus.android.uiCompose.start.screen.firstOpen.m
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Integer.valueOf(FirstOpenScreensKt.FirstStartPageController$lambda$1$0$0$0(((Integer) obj).intValue()));
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            EnterTransition enterTransitionPlus = EnterExitTransitionKt.slideInHorizontally(tweenSpecTween$default, (Function1) objRememberedValue3).plus(EnterExitTransitionKt.fadeIn$default(AnimationSpecKt.tween$default(300, 0, null, 6, null), 0.0f, 2, null));
            TweenSpec tweenSpecTween$default2 = AnimationSpecKt.tween$default(300, 0, null, 6, null);
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue4 == companion.getEmpty()) {
                objRememberedValue4 = new Function1() { // from class: cu.todus.android.uiCompose.start.screen.firstOpen.n
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Integer.valueOf(FirstOpenScreensKt.FirstStartPageController$lambda$1$0$1$0(((Integer) obj).intValue()));
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            aVar = goWelcome;
            AnimatedVisibilityKt.AnimatedVisibility(z10, (Modifier) null, enterTransitionPlus, EnterExitTransitionKt.slideOutHorizontally(tweenSpecTween$default2, (Function1) objRememberedValue4).plus(EnterExitTransitionKt.fadeOut$default(AnimationSpecKt.tween$default(300, 0, null, 6, null), 0.0f, 2, null)), (String) null, ComposableLambdaKt.rememberComposableLambda(-151401924, true, new Function3() { // from class: cu.todus.android.uiCompose.start.screen.firstOpen.o
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return FirstOpenScreensKt.FirstStartPageController$lambda$1$0$2(aVar, m0Var, pagerStateRememberPagerState, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 18);
            boolean z11 = pagerStateRememberPagerState.getCurrentPage() == pagerStateRememberPagerState.getPageCount() + (-1);
            TweenSpec tweenSpecTween$default3 = AnimationSpecKt.tween$default(300, 0, null, 6, null);
            Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue5 == companion.getEmpty()) {
                objRememberedValue5 = new Function1() { // from class: cu.todus.android.uiCompose.start.screen.firstOpen.p
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Integer.valueOf(FirstOpenScreensKt.FirstStartPageController$lambda$1$0$3$0(((Integer) obj).intValue()));
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            }
            EnterTransition enterTransitionPlus2 = EnterExitTransitionKt.slideInHorizontally(tweenSpecTween$default3, (Function1) objRememberedValue5).plus(EnterExitTransitionKt.fadeIn$default(AnimationSpecKt.tween$default(300, 0, null, 6, null), 0.0f, 2, null));
            TweenSpec tweenSpecTween$default4 = AnimationSpecKt.tween$default(300, 0, null, 6, null);
            Object objRememberedValue6 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue6 == companion.getEmpty()) {
                objRememberedValue6 = new Function1() { // from class: cu.todus.android.uiCompose.start.screen.firstOpen.q
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Integer.valueOf(FirstOpenScreensKt.FirstStartPageController$lambda$1$0$4$0(((Integer) obj).intValue()));
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
            }
            AnimatedVisibilityKt.AnimatedVisibility(z11, (Modifier) null, enterTransitionPlus2, EnterExitTransitionKt.slideOutHorizontally(tweenSpecTween$default4, (Function1) objRememberedValue6).plus(EnterExitTransitionKt.fadeOut$default(AnimationSpecKt.tween$default(300, 0, null, 6, null), 0.0f, 2, null)), (String) null, ComposableLambdaKt.rememberComposableLambda(269643813, true, new Function3() { // from class: cu.todus.android.uiCompose.start.screen.firstOpen.r
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return FirstOpenScreensKt.FirstStartPageController$lambda$1$0$5(aVar, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 18);
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            aVar = goWelcome;
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.start.screen.firstOpen.s
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FirstOpenScreensKt.FirstStartPageController$lambda$2(aVar, i10, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int FirstStartPageController$lambda$0$0() {
        return PagesKt.getOnboardPages().size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int FirstStartPageController$lambda$1$0$0$0(int i10) {
        return 300;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int FirstStartPageController$lambda$1$0$1$0(int i10) {
        return -300;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 FirstStartPageController$lambda$1$0$2(final lb.a aVar, final m0 m0Var, final PagerState pagerState, AnimatedVisibilityScope AnimatedVisibility, Composer composer, int i10) {
        y.i(AnimatedVisibility, "$this$AnimatedVisibility");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-151401924, i10, -1, "cu.todus.android.uiCompose.start.screen.firstOpen.FirstStartPageController.<anonymous>.<anonymous>.<anonymous> (FirstOpenScreens.kt:126)");
        }
        Modifier.Companion companion = Modifier.INSTANCE;
        MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getTop(), composer, 0);
        int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
        CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, companion);
        ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
        lb.a constructor = companion2.getConstructor();
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
        Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyRowMeasurePolicy, companion2.getSetMeasurePolicy());
        Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
        Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion2.getSetCompositeKeyHash());
        Updater.m5182reconcileimpl(composerM5176constructorimpl, companion2.getApplyOnDeactivatedNodeAssertion());
        Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion2.getSetModifier());
        RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
        Modifier modifierA = e3.a(rowScopeInstance, companion, 1.0f, false, 2, null);
        boolean zChanged = composer.changed(aVar);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.start.screen.firstOpen.f
                @Override // lb.a
                public final Object invoke() {
                    return FirstOpenScreensKt.FirstStartPageController$lambda$1$0$2$0$0$0(aVar);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        Z17ButtonsKt.Z17SecondaryButton(modifierA, (lb.a) objRememberedValue, StringResources_androidKt.stringResource(R.string.skip, composer, 0), null, false, false, composer, 0, 56);
        SpacerKt.Spacer(SizeKt.m1774width3ABfNKs(companion, Dp.m8823constructorimpl(10)), composer, 6);
        Modifier modifierA2 = e3.a(rowScopeInstance, companion, 1.0f, false, 2, null);
        boolean zChangedInstance = composer.changedInstance(m0Var) | composer.changed(pagerState);
        Object objRememberedValue2 = composer.rememberedValue();
        if (zChangedInstance || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.start.screen.firstOpen.g
                @Override // lb.a
                public final Object invoke() {
                    return FirstOpenScreensKt.FirstStartPageController$lambda$1$0$2$0$1$0(m0Var, pagerState);
                }
            };
            composer.updateRememberedValue(objRememberedValue2);
        }
        Z17ButtonsKt.Z17PrimaryButton(modifierA2, (lb.a) objRememberedValue2, StringResources_androidKt.stringResource(R.string.next, composer, 0), null, false, false, composer, 0, 56);
        composer.endNode();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 FirstStartPageController$lambda$1$0$2$0$0$0(lb.a aVar) {
        aVar.invoke();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 FirstStartPageController$lambda$1$0$2$0$1$0(m0 m0Var, PagerState pagerState) {
        pe.k.d(m0Var, null, null, new FirstOpenScreensKt$FirstStartPageController$1$1$3$1$2$1$1(pagerState, null), 3, null);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int FirstStartPageController$lambda$1$0$3$0(int i10) {
        return 300;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int FirstStartPageController$lambda$1$0$4$0(int i10) {
        return -300;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 FirstStartPageController$lambda$1$0$5(final lb.a aVar, AnimatedVisibilityScope AnimatedVisibility, Composer composer, int i10) {
        y.i(AnimatedVisibility, "$this$AnimatedVisibility");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(269643813, i10, -1, "cu.todus.android.uiCompose.start.screen.firstOpen.FirstStartPageController.<anonymous>.<anonymous>.<anonymous> (FirstOpenScreens.kt:160)");
        }
        boolean zChanged = composer.changed(aVar);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.start.screen.firstOpen.j
                @Override // lb.a
                public final Object invoke() {
                    return FirstOpenScreensKt.FirstStartPageController$lambda$1$0$5$0$0(aVar);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        Z17ButtonsKt.Z17PrimaryButton(null, (lb.a) objRememberedValue, StringResources_androidKt.stringResource(R.string.begin_start, composer, 0), null, true, false, composer, 24576, 41);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 FirstStartPageController$lambda$1$0$5$0$0(lb.a aVar) {
        aVar.invoke();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 FirstStartPageController$lambda$2(lb.a aVar, int i10, Composer composer, int i11) {
        FirstStartPageController(aVar, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1));
        return k0.f43947a;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void PageUi(final Page page, Composer composer, final int i10) {
        int i11;
        y.i(page, "page");
        Composer composerStartRestartGroup = composer.startRestartGroup(-129164389);
        if ((i10 & 6) == 0) {
            i11 = (composerStartRestartGroup.changed(page) ? 4 : 2) | i10;
        } else {
            i11 = i10;
        }
        if (composerStartRestartGroup.shouldExecute((i11 & 3) != 2, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-129164389, i11, -1, "cu.todus.android.uiCompose.start.screen.firstOpen.PageUi (FirstOpenScreens.kt:54)");
            }
            Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
            Modifier.Companion companion = Modifier.INSTANCE;
            float f10 = 20;
            Modifier modifierM1725padding3ABfNKs = PaddingKt.m1725padding3ABfNKs(companion, Dp.m8823constructorimpl(f10));
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), centerHorizontally, composerStartRestartGroup, 48);
            int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1725padding3ABfNKs);
            ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
            lb.a constructor = companion2.getConstructor();
            if (!defpackage.r.a(composerStartRestartGroup.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM5176constructorimpl = Updater.m5176constructorimpl(composerStartRestartGroup);
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyColumnMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion2.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl, companion2.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion2.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            Z17PictureKt.m10278Z17BasePictureC8z9wKI(SizeKt.fillMaxWidth$default(x.a(columnScopeInstance, companion, 3.0f, false, 2, null), 0.0f, 1, null), Integer.valueOf(page.getImage()), null, null, null, null, 0, null, null, composerStartRestartGroup, 0, TypedValues.PositionType.TYPE_CURVE_FIT);
            composerStartRestartGroup = composerStartRestartGroup;
            SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion, Dp.m8823constructorimpl(f10)), composerStartRestartGroup, 6);
            String strStringResource = StringResources_androidKt.stringResource(page.getTitle(), composerStartRestartGroup, 0);
            MaterialTheme materialTheme = MaterialTheme.INSTANCE;
            int i12 = MaterialTheme.$stable;
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, strStringResource, materialTheme.getTypography(composerStartRestartGroup, i12).getTitleLarge(), 0L, 0, 0, composerStartRestartGroup, 0, 57);
            SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion, Dp.m8823constructorimpl(8)), composerStartRestartGroup, 6);
            String strStringResource2 = StringResources_androidKt.stringResource(page.getDescription(), composerStartRestartGroup, 0);
            TextStyle textStyleM8271copyp1EtxEg$default = TextStyle.m8271copyp1EtxEg$default(materialTheme.getTypography(composerStartRestartGroup, i12).getBodyMedium(), 0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, TextAlign.INSTANCE.m8692getCentere0LSkKk(), 0, 0L, null, null, null, 0, 0, null, 16744447, null);
            float f11 = 10;
            Z17LabelKt.m10262Z17LabelfWhpE4E(x.a(columnScopeInstance, PaddingKt.m1729paddingqDBjuR0$default(companion, Dp.m8823constructorimpl(f11), 0.0f, Dp.m8823constructorimpl(f11), 0.0f, 10, null), 1.0f, false, 2, null), strStringResource2, textStyleM8271copyp1EtxEg$default, 0L, 0, 0, composerStartRestartGroup, 0, 56);
            SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion, Dp.m8823constructorimpl(12)), composerStartRestartGroup, 6);
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.start.screen.firstOpen.e
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FirstOpenScreensKt.PageUi$lambda$1(page, i10, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 PageUi$lambda$1(Page page, int i10, Composer composer, int i11) {
        PageUi(page, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1));
        return k0.f43947a;
    }
}
