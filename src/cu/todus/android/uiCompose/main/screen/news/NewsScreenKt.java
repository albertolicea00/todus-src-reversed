package cu.todus.android.uiCompose.main.screen.news;

import android.content.Context;
import android.graphics.Color;
import android.text.format.DateFormat;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ScrollKt;
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
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.ModalBottomSheetKt;
import androidx.compose.material.ModalBottomSheetState;
import androidx.compose.material.ModalBottomSheetValue;
import androidx.compose.material.ScaffoldKt;
import androidx.compose.material.ScaffoldState;
import androidx.compose.material3.MaterialTheme;
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
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.FrameMetricsAggregator;
import androidx.navigation.NavHostController;
import androidx.p001lifecycle.HasDefaultViewModelProviderFactory;
import androidx.p001lifecycle.ViewModelProvider;
import androidx.p001lifecycle.ViewModelStoreOwner;
import androidx.p001lifecycle.viewmodel.CreationExtras;
import androidx.p001lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.p001lifecycle.viewmodel.compose.ViewModelKt;
import cu.todus.android.R;
import cu.todus.android.data.rest.entity.NewEntity;
import cu.todus.android.uiCompose.main.screen.chat.item.MessageAction;
import cu.todus.android.uiCompose.main.screen.chat.item.content.TextContentKt;
import cu.todus.android.uiCompose.shared.modal.ModalKt;
import cu.todus.android.uiCompose.theme.Light;
import cu.todus.android.utils.ColorGenerator;
import cu.todus.android.utils.DateFormatter;
import cu.todus.android.utils.IntentUtil;
import cu.z17.views.button.Z17ButtonsKt;
import cu.z17.views.label.Z17LabelKt;
import cu.z17.views.picture.Z17PictureAvatarKt;
import cu.z17.views.picture.Z17PictureKt;
import cu.z17.views.scaffold.Z17ScaffoldKt;
import cu.z17.views.topBar.Z17TopBarKt;
import defpackage.r;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.y;
import kotlin.jvm.internal.z0;
import lb.o;
import pe.m0;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a!\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroidx/navigation/NavHostController;", "navHostController", "Lcu/todus/android/uiCompose/main/screen/news/NewsViewModel;", "viewModel", "Lua/k0;", "NewsScreen", "(Landroidx/navigation/NavHostController;Lcu/todus/android/uiCompose/main/screen/news/NewsViewModel;Landroidx/compose/runtime/Composer;II)V", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class NewsScreenKt {
    /* JADX WARN: Code duplicated, block: B:20:0x0040  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void NewsScreen(final NavHostController navHostController, NewsViewModel newsViewModel, Composer composer, final int i10, final int i11) {
        int i12;
        Composer composer2;
        int i13;
        final NewsViewModel newsViewModel2 = newsViewModel;
        y.i(navHostController, "navHostController");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1826452712);
        if ((i10 & 6) == 0) {
            i12 = (composerStartRestartGroup.changedInstance(navHostController) ? 4 : 2) | i10;
        } else {
            i12 = i10;
        }
        if ((i10 & 48) == 0) {
            if ((i11 & 2) != 0) {
                i13 = 16;
            } else {
                if ((i10 & 64) == 0 ? composerStartRestartGroup.changed(newsViewModel2) : composerStartRestartGroup.changedInstance(newsViewModel2)) {
                    i13 = 32;
                } else {
                    i13 = 16;
                }
            }
            i12 |= i13;
        }
        int i14 = i12;
        if (composerStartRestartGroup.shouldExecute((i14 & 19) != 18, i14 & 1)) {
            composerStartRestartGroup.startDefaults();
            if ((i10 & 1) != 0 && !composerStartRestartGroup.getDefaultsInvalid()) {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i11 & 2) != 0) {
                    i14 &= -113;
                }
            } else if ((i11 & 2) != 0) {
                ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composerStartRestartGroup, 6);
                if (current == null) {
                    throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                }
                newsViewModel2 = (NewsViewModel) ViewModelKt.viewModel(z0.b(NewsViewModel.class), current, (String) null, (ViewModelProvider.Factory) null, current instanceof HasDefaultViewModelProviderFactory ? ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras() : CreationExtras.Empty.INSTANCE, composerStartRestartGroup, 0, 0);
                i14 &= -113;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1826452712, i14, -1, "cu.todus.android.uiCompose.main.screen.news.NewsScreen (NewsScreen.kt:61)");
            }
            ScaffoldState scaffoldStateRememberScaffoldState = ScaffoldKt.rememberScaffoldState(null, null, composerStartRestartGroup, 0, 3);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = EffectsKt.createCompositionCoroutineScope(ab.j.f643c, composerStartRestartGroup);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final m0 m0Var = (m0) objRememberedValue;
            composer2 = composerStartRestartGroup;
            Z17ScaffoldKt.m10301Z17BaseScaffoldueL0Wzs(ComposableLambdaKt.rememberComposableLambda(-2056473012, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.news.k
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return NewsScreenKt.NewsScreen$lambda$0(navHostController, (TopAppBarScrollBehavior) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), false, false, false, null, null, 0L, scaffoldStateRememberScaffoldState, null, ComposableLambdaKt.rememberComposableLambda(-127045298, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.news.l
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return NewsScreenKt.NewsScreen$lambda$1(newsViewModel2, m0Var, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composer2, 805306806, 376);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.news.m
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NewsScreenKt.NewsScreen$lambda$2(navHostController, newsViewModel2, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 NewsScreen$lambda$0(NavHostController navHostController, TopAppBarScrollBehavior it, Composer composer, int i10) {
        y.i(it, "it");
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2056473012, i10, -1, "cu.todus.android.uiCompose.main.screen.news.NewsScreen.<anonymous> (NewsScreen.kt:71)");
            }
            Z17TopBarKt.m10304Z17TopBardW2gCk(ComposableSingletons$NewsScreenKt.INSTANCE.m9948getLambda$207699623$app_productionPFast(), null, false, null, false, navHostController, null, null, 0L, 0L, 0.0f, composer, 6, 0, 2014);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 NewsScreen$lambda$1(final NewsViewModel newsViewModel, final m0 m0Var, Modifier it, Composer composer, int i10) {
        y.i(it, "it");
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-127045298, i10, -1, "cu.todus.android.uiCompose.main.screen.news.NewsScreen.<anonymous> (NewsScreen.kt:82)");
            }
            Object objRememberedValue = composer.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                composer.updateRememberedValue(objRememberedValue);
            }
            final MutableState mutableState = (MutableState) objRememberedValue;
            final ModalBottomSheetState modalBottomSheetStateRememberModalBottomSheetState = ModalBottomSheetKt.rememberModalBottomSheetState(ModalBottomSheetValue.Hidden, null, null, false, composer, 6, 14);
            boolean zChangedInstance = composer.changedInstance(newsViewModel) | composer.changedInstance(m0Var) | composer.changedInstance(modalBottomSheetStateRememberModalBottomSheetState);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.news.i
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return NewsScreenKt.NewsScreen$lambda$1$1$0(newsViewModel, m0Var, modalBottomSheetStateRememberModalBottomSheetState, mutableState, (LazyListScope) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            LazyDslKt.LazyColumn(null, null, null, false, null, null, null, false, null, (Function1) objRememberedValue2, composer, 0, FrameMetricsAggregator.EVERY_DURATION);
            ModalKt.Modal(modalBottomSheetStateRememberModalBottomSheetState, ComposableLambdaKt.rememberComposableLambda(564797743, true, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.news.j
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NewsScreenKt.NewsScreen$lambda$1$2(mutableState, modalBottomSheetStateRememberModalBottomSheetState, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, ModalBottomSheetState.$stable | 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 NewsScreen$lambda$1$1$0(final NewsViewModel newsViewModel, final m0 m0Var, final ModalBottomSheetState modalBottomSheetState, final MutableState mutableState, LazyListScope LazyColumn) {
        y.i(LazyColumn, "$this$LazyColumn");
        LazyListScope.CC.o(LazyColumn, newsViewModel.getMucks().size(), null, null, ComposableLambdaKt.composableLambdaInstance(-1565369364, true, new o() { // from class: cu.todus.android.uiCompose.main.screen.news.h
            @Override // lb.o
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return NewsScreenKt.NewsScreen$lambda$1$1$0$0(newsViewModel, m0Var, modalBottomSheetState, mutableState, (LazyItemScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 6, null);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 NewsScreen$lambda$1$1$0$0(NewsViewModel newsViewModel, final m0 m0Var, final ModalBottomSheetState modalBottomSheetState, final MutableState mutableState, LazyItemScope items, int i10, Composer composer, int i11) {
        y.i(items, "$this$items");
        if ((i11 & 48) == 0) {
            i11 |= composer.changed(i10) ? 32 : 16;
        }
        if (composer.shouldExecute((i11 & 145) != 144, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1565369364, i11, -1, "cu.todus.android.uiCompose.main.screen.news.NewsScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (NewsScreen.kt:90)");
            }
            final NewEntity newEntity = newsViewModel.getMucks().get(i10);
            boolean zChanged = composer.changed(newEntity) | composer.changedInstance(m0Var) | composer.changedInstance(modalBottomSheetState);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.news.d
                    @Override // lb.a
                    public final Object invoke() {
                        return NewsScreenKt.NewsScreen$lambda$1$1$0$0$0$0(mutableState, newEntity, m0Var, modalBottomSheetState);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            NewsItemKt.NewsItem(newEntity, (lb.a) objRememberedValue, composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 NewsScreen$lambda$1$1$0$0$0$0(MutableState mutableState, NewEntity newEntity, m0 m0Var, ModalBottomSheetState modalBottomSheetState) {
        mutableState.setValue(newEntity);
        pe.k.d(m0Var, null, null, new NewsScreenKt$NewsScreen$2$1$1$1$1$1$1(modalBottomSheetState, null), 3, null);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 NewsScreen$lambda$1$2(MutableState mutableState, ModalBottomSheetState modalBottomSheetState, Composer composer, int i10) {
        String color;
        Shape shapeM2017RoundedCornerShapea9UjIt4$default;
        String color2;
        int i11;
        Composer composer2;
        MaterialTheme materialTheme;
        Modifier.Companion companion;
        int i12;
        Composer composer3 = composer;
        if (composer3.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(564797743, i10, -1, "cu.todus.android.uiCompose.main.screen.news.NewsScreen.<anonymous>.<anonymous> (NewsScreen.kt:104)");
            }
            Modifier.Companion companion2 = Modifier.INSTANCE;
            NewEntity newEntity = (NewEntity) mutableState.getValue();
            if (newEntity == null || (color = newEntity.getColor()) == null) {
                color = "#FFF2C5";
            }
            long jColor = ColorKt.Color(Color.parseColor(color));
            if (modalBottomSheetState.getCurrentValue() == ModalBottomSheetValue.Expanded) {
                shapeM2017RoundedCornerShapea9UjIt4$default = RectangleShapeKt.getRectangleShape();
            } else {
                float f10 = 15;
                shapeM2017RoundedCornerShapea9UjIt4$default = RoundedCornerShapeKt.m2017RoundedCornerShapea9UjIt4$default(Dp.m8823constructorimpl(f10), Dp.m8823constructorimpl(f10), 0.0f, 0.0f, 12, null);
            }
            Modifier modifierVerticalScroll$default = ScrollKt.verticalScroll$default(PaddingKt.m1725padding3ABfNKs(BackgroundKt.m1204backgroundbw27NRU(companion2, jColor, shapeM2017RoundedCornerShapea9UjIt4$default), Dp.m8823constructorimpl(20)), ScrollKt.rememberScrollState(0, composer3, 0, 1), false, null, false, 14, null);
            Arrangement arrangement = Arrangement.INSTANCE;
            Arrangement.Vertical top = arrangement.getTop();
            Alignment.Companion companion3 = Alignment.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(top, companion3.getStart(), composer3, 0);
            int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer3, 0));
            CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer3, modifierVerticalScroll$default);
            ComposeUiNode.Companion companion4 = ComposeUiNode.INSTANCE;
            lb.a constructor = companion4.getConstructor();
            if (!r.a(composer3.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composer3.startReusableNode();
            if (composer3.getInserting()) {
                composer3.createNode(constructor);
            } else {
                composer3.useNode();
            }
            Composer composerM5176constructorimpl = Updater.m5176constructorimpl(composer3);
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyColumnMeasurePolicy, companion4.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion4.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion4.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl, companion4.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion4.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            NewEntity newEntity2 = (NewEntity) mutableState.getValue();
            if (newEntity2 == null) {
                composer3.startReplaceGroup(881758951);
                composer3.endReplaceGroup();
            } else {
                composer3.startReplaceGroup(881758952);
                final Context context = (Context) composer3.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                Modifier modifierM1755height3ABfNKs = SizeKt.m1755height3ABfNKs(SizeKt.fillMaxWidth$default(companion2, 0.0f, 1, null), Dp.m8823constructorimpl(40));
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion3.getCenter(), false);
                int iA2 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer3, 0));
                CompositionLocalMap currentCompositionLocalMap2 = composer3.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer3, modifierM1755height3ABfNKs);
                lb.a constructor2 = companion4.getConstructor();
                if (!r.a(composer3.getApplier())) {
                    ComposablesKt.invalidApplier();
                }
                composer3.startReusableNode();
                if (composer3.getInserting()) {
                    composer3.createNode(constructor2);
                } else {
                    composer3.useNode();
                }
                Composer composerM5176constructorimpl2 = Updater.m5176constructorimpl(composer3);
                Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy, companion4.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap2, companion4.getSetResolvedCompositionLocals());
                Updater.m5180initimpl(composerM5176constructorimpl2, Integer.valueOf(iA2), companion4.getSetCompositeKeyHash());
                Updater.m5182reconcileimpl(composerM5176constructorimpl2, companion4.getApplyOnDeactivatedNodeAssertion());
                Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier2, companion4.getSetModifier());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                float f11 = 5;
                float f12 = 10;
                BoxKt.Box(BackgroundKt.m1205backgroundbw27NRU$default(ClipKt.clip(SizeKt.m1771sizeVpY3zN4(companion2, Dp.m8823constructorimpl(50), Dp.m8823constructorimpl(f11)), RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(f12))), ColorKt.Color(4293454056L), null, 2, null), composer3, 0);
                composer3.endNode();
                String title = newEntity2.getTitle();
                MaterialTheme materialTheme2 = MaterialTheme.INSTANCE;
                int i13 = MaterialTheme.$stable;
                TextStyle titleLarge = materialTheme2.getTypography(composer3, i13).getTitleLarge();
                Light light = Light.INSTANCE;
                Z17LabelKt.m10262Z17LabelfWhpE4E(null, title, titleLarge, light.m10102getOnBackground0d7_KjU(), 0, 0, composer3, 0, 49);
                SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion2, Dp.m8823constructorimpl(f11)), composer3, 6);
                String imagePreview = newEntity2.getImagePreview();
                if (imagePreview == null) {
                    composer3.startReplaceGroup(-1790684567);
                    composer3.endReplaceGroup();
                    i11 = 6;
                } else {
                    composer3.startReplaceGroup(-1790684566);
                    Modifier modifierM1755height3ABfNKs2 = SizeKt.m1755height3ABfNKs(SizeKt.fillMaxWidth$default(companion2, 0.0f, 1, null), Dp.m8823constructorimpl(200));
                    NewEntity newEntity3 = (NewEntity) mutableState.getValue();
                    if (newEntity3 == null || (color2 = newEntity3.getColor()) == null) {
                        color2 = "#FFF2C5";
                    }
                    i11 = 6;
                    Z17PictureKt.m10278Z17BasePictureC8z9wKI(modifierM1755height3ABfNKs2, imagePreview, androidx.compose.ui.graphics.Color.m5856boximpl(ColorKt.Color(Color.parseColor(color2))), null, null, null, 0, null, null, composer, 6, TypedValues.PositionType.TYPE_PERCENT_HEIGHT);
                    composer3 = composer;
                    SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion2, Dp.m8823constructorimpl(f12)), composer3, 6);
                    k0 k0Var = k0.f43947a;
                    composer3.endReplaceGroup();
                }
                SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion2, Dp.m8823constructorimpl(f12)), composer3, i11);
                Z17LabelKt.m10262Z17LabelfWhpE4E(null, DateFormatter.INSTANCE.format(new Date(newEntity2.getReleaseDate()), DateFormat.is24HourFormat(context) ? DateFormatter.Template.TIME : DateFormatter.Template.STRING_TIME_DAY_MONTH_YEAR), TextStyle.m8271copyp1EtxEg$default(materialTheme2.getTypography(composer3, i13).getLabelSmall(), 0L, TextUnitKt.getSp(12), null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777213, null), light.m10102getOnBackground0d7_KjU(), 0, 0, composer3, 0, 49);
                SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion2, Dp.m8823constructorimpl(f11)), composer3, i11);
                Modifier modifierM1727paddingVpY3zN4$default = PaddingKt.m1727paddingVpY3zN4$default(SizeKt.fillMaxWidth$default(companion2, 0.0f, 1, null), 0.0f, Dp.m8823constructorimpl(f11), 1, null);
                MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getSpaceBetween(), companion3.getCenterVertically(), composer3, 54);
                int iA3 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer3, 0));
                CompositionLocalMap currentCompositionLocalMap3 = composer3.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composer3, modifierM1727paddingVpY3zN4$default);
                lb.a constructor3 = companion4.getConstructor();
                if (!r.a(composer3.getApplier())) {
                    ComposablesKt.invalidApplier();
                }
                composer3.startReusableNode();
                if (composer3.getInserting()) {
                    composer3.createNode(constructor3);
                } else {
                    composer3.useNode();
                }
                Composer composerM5176constructorimpl3 = Updater.m5176constructorimpl(composer3);
                Updater.m5184setimpl(composerM5176constructorimpl3, measurePolicyRowMeasurePolicy, companion4.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl3, currentCompositionLocalMap3, companion4.getSetResolvedCompositionLocals());
                Updater.m5180initimpl(composerM5176constructorimpl3, Integer.valueOf(iA3), companion4.getSetCompositeKeyHash());
                Updater.m5182reconcileimpl(composerM5176constructorimpl3, companion4.getApplyOnDeactivatedNodeAssertion());
                Updater.m5184setimpl(composerM5176constructorimpl3, modifierMaterializeModifier3, companion4.getSetModifier());
                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                String authorImage = newEntity2.getAuthorImage();
                if (authorImage == null) {
                    composer3.startReplaceGroup(-1230942401);
                    composer3.endReplaceGroup();
                    composer2 = composer3;
                    i12 = i13;
                    companion = companion2;
                    materialTheme = materialTheme2;
                } else {
                    composer3.startReplaceGroup(-1230942400);
                    composer2 = composer;
                    materialTheme = materialTheme2;
                    companion = companion2;
                    i12 = i13;
                    Z17PictureAvatarKt.m10277Z17PictureAvatarajT4Zlk(SizeKt.m1769size3ABfNKs(companion2, Dp.m8823constructorimpl(55)), authorImage, androidx.compose.ui.graphics.Color.m5856boximpl(ColorKt.Color(ColorGenerator.INSTANCE.getMATERIAL().getColor(authorImage))), null, null, 0, null, false, null, newEntity2.getAuthor(), true, 0, composer2, 6, 6, 2552);
                    k0 k0Var2 = k0.f43947a;
                    composer2.endReplaceGroup();
                }
                Modifier.Companion companion5 = companion;
                SpacerKt.Spacer(SizeKt.m1774width3ABfNKs(companion5, Dp.m8823constructorimpl(f12)), composer2, 6);
                Modifier modifierA = e3.a(rowScopeInstance, companion5, 1.0f, false, 2, null);
                MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(arrangement.getTop(), companion3.getStart(), composer2, 0);
                int iA4 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
                CompositionLocalMap currentCompositionLocalMap4 = composer2.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composer2, modifierA);
                lb.a constructor4 = companion4.getConstructor();
                if (!r.a(composer2.getApplier())) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor4);
                } else {
                    composer2.useNode();
                }
                Composer composerM5176constructorimpl4 = Updater.m5176constructorimpl(composer2);
                Updater.m5184setimpl(composerM5176constructorimpl4, measurePolicyColumnMeasurePolicy2, companion4.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl4, currentCompositionLocalMap4, companion4.getSetResolvedCompositionLocals());
                Updater.m5180initimpl(composerM5176constructorimpl4, Integer.valueOf(iA4), companion4.getSetCompositeKeyHash());
                Updater.m5182reconcileimpl(composerM5176constructorimpl4, companion4.getApplyOnDeactivatedNodeAssertion());
                Updater.m5184setimpl(composerM5176constructorimpl4, modifierMaterializeModifier4, companion4.getSetModifier());
                MaterialTheme materialTheme3 = materialTheme;
                int i14 = i12;
                Composer composer4 = composer2;
                Z17LabelKt.m10262Z17LabelfWhpE4E(null, StringResources_androidKt.stringResource(R.string.published_by, composer2, 0), materialTheme3.getTypography(composer2, i14).getBodySmall(), light.m10102getOnBackground0d7_KjU(), 0, 0, composer4, 0, 49);
                Z17LabelKt.m10262Z17LabelfWhpE4E(null, newEntity2.getAuthor(), TextStyle.m8271copyp1EtxEg$default(materialTheme3.getTypography(composer4, i14).getTitleSmall(), 0L, TextUnitKt.getSp(16), null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777213, null), light.m10102getOnBackground0d7_KjU(), 0, 0, composer4, 0, 49);
                composer4.endNode();
                SpacerKt.Spacer(SizeKt.m1774width3ABfNKs(companion5, Dp.m8823constructorimpl(f12)), composer4, 6);
                final String configSource = newEntity2.getConfigSource();
                if (configSource == null) {
                    composer4.startReplaceGroup(-1229496220);
                    composer4.endReplaceGroup();
                } else {
                    composer4.startReplaceGroup(-1229496219);
                    boolean zChangedInstance = composer4.changedInstance(context) | composer4.changed(configSource);
                    Object objRememberedValue = composer4.rememberedValue();
                    if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.news.e
                            @Override // lb.a
                            public final Object invoke() {
                                return NewsScreenKt.NewsScreen$lambda$1$2$0$0$2$2$0$0(context, configSource);
                            }
                        };
                        composer4.updateRememberedValue(objRememberedValue);
                    }
                    Z17ButtonsKt.Z17PrimaryButton(null, (lb.a) objRememberedValue, StringResources_androidKt.stringResource(R.string.origin, composer4, 0), null, false, false, composer, 0, 57);
                    composer4 = composer;
                    k0 k0Var3 = k0.f43947a;
                    composer4.endReplaceGroup();
                }
                composer4.endNode();
                SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion5, Dp.m8823constructorimpl(f12)), composer4, 6);
                String body = newEntity2.getBody();
                long jM10102getOnBackground0d7_KjU = light.m10102getOnBackground0d7_KjU();
                Object objRememberedValue2 = composer4.rememberedValue();
                Composer.Companion companion6 = Composer.INSTANCE;
                if (objRememberedValue2 == companion6.getEmpty()) {
                    objRememberedValue2 = new Function2() { // from class: cu.todus.android.uiCompose.main.screen.news.f
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return NewsScreenKt.NewsScreen$lambda$1$2$0$0$3$0((MessageAction) obj, ((Integer) obj2).intValue());
                        }
                    };
                    composer4.updateRememberedValue(objRememberedValue2);
                }
                Function2 function2 = (Function2) objRememberedValue2;
                Object objRememberedValue3 = composer4.rememberedValue();
                if (objRememberedValue3 == companion6.getEmpty()) {
                    objRememberedValue3 = new Function2() { // from class: cu.todus.android.uiCompose.main.screen.news.g
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return NewsScreenKt.NewsScreen$lambda$1$2$0$0$4$0((MessageAction) obj, ((Integer) obj2).intValue());
                        }
                    };
                    composer4.updateRememberedValue(objRememberedValue3);
                }
                TextContentKt.m9893TextContentOadGlvw(body, jM10102getOnBackground0d7_KjU, function2, (Function2) objRememberedValue3, Integer.MAX_VALUE, null, composer4, 28032, 32);
                k0 k0Var4 = k0.f43947a;
                composer.endReplaceGroup();
            }
            composer.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 NewsScreen$lambda$1$2$0$0$2$2$0$0(Context context, String str) {
        IntentUtil.INSTANCE.showWeb(context, str);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 NewsScreen$lambda$1$2$0$0$3$0(MessageAction p10, int i10) {
        y.i(p10, "p1");
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 NewsScreen$lambda$1$2$0$0$4$0(MessageAction p10, int i10) {
        y.i(p10, "p1");
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 NewsScreen$lambda$2(NavHostController navHostController, NewsViewModel newsViewModel, int i10, int i11, Composer composer, int i12) {
        NewsScreen(navHostController, newsViewModel, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return k0.f43947a;
    }
}
