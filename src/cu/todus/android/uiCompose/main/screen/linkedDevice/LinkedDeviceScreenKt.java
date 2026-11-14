package cu.todus.android.uiCompose.main.screen.linkedDevice;

import android.content.Context;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.LazyListStateKt;
import androidx.compose.material.ScaffoldKt;
import androidx.compose.material3.AppBarKt;
import androidx.compose.material3.MaterialTheme;
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
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.navigation.NavHostController;
import androidx.p001lifecycle.HasDefaultViewModelProviderFactory;
import androidx.p001lifecycle.Lifecycle;
import androidx.p001lifecycle.LifecycleOwner;
import androidx.p001lifecycle.ViewModelProvider;
import androidx.p001lifecycle.ViewModelStoreOwner;
import androidx.p001lifecycle.p002compose.FlowExtKt;
import androidx.p001lifecycle.viewmodel.CreationExtras;
import androidx.p001lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.p001lifecycle.viewmodel.compose.ViewModelKt;
import androidx.paging.compose.LazyFoundationExtensionsKt;
import androidx.paging.compose.LazyPagingItems;
import androidx.paging.compose.LazyPagingItemsKt;
import cu.todus.android.R;
import cu.todus.android.data.db.entity.toDus.LinkedDevice;
import cu.todus.android.exceptions.NotCorrectQrException;
import cu.todus.android.uiCompose.main.screen.linkedDevice.deviceItem.DeviceItemKt;
import cu.todus.android.utils.IntentUtil;
import cu.z17.views.button.Z17ButtonsKt;
import cu.z17.views.dialogs.Z17DialogsKt;
import cu.z17.views.label.Z17ClickableLabelClickType;
import cu.z17.views.label.Z17ClickableLabelKt;
import cu.z17.views.label.Z17LabelKt;
import cu.z17.views.picture.Z17PictureKt;
import cu.z17.views.qr.Z17QRScannerKt;
import cu.z17.views.scaffold.Z17ScaffoldKt;
import cu.z17.views.topBar.Z17TopBarKt;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.y;
import kotlin.jvm.internal.z0;
import te.b0;
import ua.k0;
import va.w;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a!\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t²\u0006\u000e\u0010\b\u001a\u00020\u00078\n@\nX\u008a\u008e\u0002"}, d2 = {"Landroidx/navigation/NavHostController;", "navHostController", "Lcu/todus/android/uiCompose/main/screen/linkedDevice/LinkedDeviceViewModel;", "viewModel", "Lua/k0;", "LinkedDeviceScreen", "(Landroidx/navigation/NavHostController;Lcu/todus/android/uiCompose/main/screen/linkedDevice/LinkedDeviceViewModel;Landroidx/compose/runtime/Composer;II)V", "", "qrReaderOpen", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class LinkedDeviceScreenKt {
    /* JADX WARN: Code duplicated, block: B:51:0x00af  */
    /* JADX WARN: Code duplicated, block: B:54:0x00f0  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void LinkedDeviceScreen(final NavHostController navHostController, LinkedDeviceViewModel linkedDeviceViewModel, Composer composer, final int i10, final int i11) {
        int i12;
        LinkedDeviceViewModel linkedDeviceViewModel2;
        final LinkedDeviceViewModel linkedDeviceViewModel3;
        final LinkedDeviceViewModel linkedDeviceViewModel4;
        y.i(navHostController, "navHostController");
        Composer composerStartRestartGroup = composer.startRestartGroup(804969120);
        if ((i10 & 6) == 0) {
            i12 = (composerStartRestartGroup.changedInstance(navHostController) ? 4 : 2) | i10;
        } else {
            i12 = i10;
        }
        if ((i10 & 48) == 0) {
            if ((i11 & 2) == 0) {
                linkedDeviceViewModel2 = linkedDeviceViewModel;
                int i13 = composerStartRestartGroup.changedInstance(linkedDeviceViewModel2) ? 32 : 16;
                i12 |= i13;
            } else {
                linkedDeviceViewModel2 = linkedDeviceViewModel;
            }
            i12 |= i13;
        } else {
            linkedDeviceViewModel2 = linkedDeviceViewModel;
        }
        int i14 = i12;
        if (composerStartRestartGroup.shouldExecute((i14 & 19) != 18, i14 & 1)) {
            composerStartRestartGroup.startDefaults();
            if ((i10 & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                if ((i11 & 2) != 0) {
                    ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composerStartRestartGroup, 6);
                    if (current == null) {
                        throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                    }
                    linkedDeviceViewModel4 = (LinkedDeviceViewModel) ViewModelKt.viewModel(z0.b(LinkedDeviceViewModel.class), current, (String) null, (ViewModelProvider.Factory) null, current instanceof HasDefaultViewModelProviderFactory ? ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras() : CreationExtras.Empty.INSTANCE, composerStartRestartGroup, 0, 0);
                    i14 &= -113;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(804969120, i14, -1, "cu.todus.android.uiCompose.main.screen.linkedDevice.LinkedDeviceScreen (LinkedDeviceScreen.kt:60)");
                }
                linkedDeviceViewModel3 = linkedDeviceViewModel4;
                Z17ScaffoldKt.m10301Z17BaseScaffoldueL0Wzs(ComposableLambdaKt.rememberComposableLambda(1185625556, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.linkedDevice.b
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return LinkedDeviceScreenKt.LinkedDeviceScreen$lambda$0(navHostController, (TopAppBarScrollBehavior) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), false, false, false, null, null, 0L, ScaffoldKt.rememberScaffoldState(null, null, composerStartRestartGroup, 0, 3), null, ComposableLambdaKt.rememberComposableLambda(1269786838, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.linkedDevice.i
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return LinkedDeviceScreenKt.LinkedDeviceScreen$lambda$1(linkedDeviceViewModel4, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 805306806, 376);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i11 & 2) != 0) {
                    i14 &= -113;
                }
            }
            linkedDeviceViewModel4 = linkedDeviceViewModel2;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(804969120, i14, -1, "cu.todus.android.uiCompose.main.screen.linkedDevice.LinkedDeviceScreen (LinkedDeviceScreen.kt:60)");
            }
            linkedDeviceViewModel3 = linkedDeviceViewModel4;
            Z17ScaffoldKt.m10301Z17BaseScaffoldueL0Wzs(ComposableLambdaKt.rememberComposableLambda(1185625556, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.linkedDevice.b
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return LinkedDeviceScreenKt.LinkedDeviceScreen$lambda$0(navHostController, (TopAppBarScrollBehavior) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), false, false, false, null, null, 0L, ScaffoldKt.rememberScaffoldState(null, null, composerStartRestartGroup, 0, 3), null, ComposableLambdaKt.rememberComposableLambda(1269786838, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.linkedDevice.i
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return LinkedDeviceScreenKt.LinkedDeviceScreen$lambda$1(linkedDeviceViewModel4, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 805306806, 376);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            linkedDeviceViewModel3 = linkedDeviceViewModel2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.linkedDevice.j
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return LinkedDeviceScreenKt.LinkedDeviceScreen$lambda$2(navHostController, linkedDeviceViewModel3, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 LinkedDeviceScreen$lambda$0(final NavHostController navHostController, TopAppBarScrollBehavior it, Composer composer, int i10) {
        y.i(it, "it");
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1185625556, i10, -1, "cu.todus.android.uiCompose.main.screen.linkedDevice.LinkedDeviceScreen.<anonymous> (LinkedDeviceScreen.kt:66)");
            }
            Function2 lambda$367381729$app_productionPFast = ComposableSingletons$LinkedDeviceScreenKt.INSTANCE.getLambda$367381729$app_productionPFast();
            TopAppBarScrollBehavior topAppBarScrollBehaviorPinnedScrollBehavior = TopAppBarDefaults.INSTANCE.pinnedScrollBehavior(AppBarKt.rememberTopAppBarState(0.0f, 0.0f, 0.0f, composer, 0, 7), null, composer, TopAppBarDefaults.$stable << 6, 2);
            boolean zChangedInstance = composer.changedInstance(navHostController);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.linkedDevice.k
                    @Override // lb.a
                    public final Object invoke() {
                        return LinkedDeviceScreenKt.LinkedDeviceScreen$lambda$0$0$0(navHostController);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            Z17TopBarKt.m10304Z17TopBardW2gCk(lambda$367381729$app_productionPFast, topAppBarScrollBehaviorPinnedScrollBehavior, false, null, false, navHostController, (lb.a) objRememberedValue, null, 0L, 0L, 0.0f, composer, 6, 0, 1948);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 LinkedDeviceScreen$lambda$0$0$0(NavHostController navHostController) {
        navHostController.navigateUp();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 LinkedDeviceScreen$lambda$1(final LinkedDeviceViewModel linkedDeviceViewModel, Modifier it, Composer composer, int i10) {
        int i11;
        y.i(it, "it");
        if ((i10 & 6) == 0) {
            i11 = i10 | (composer.changed(it) ? 4 : 2);
        } else {
            i11 = i10;
        }
        if (composer.shouldExecute((i11 & 19) != 18, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1269786838, i11, -1, "cu.todus.android.uiCompose.main.screen.linkedDevice.LinkedDeviceScreen.<anonymous> (LinkedDeviceScreen.kt:81)");
            }
            final Context context = (Context) composer.consume(AndroidCompositionLocals_androidKt.getLocalContext());
            final LazyPagingItems lazyPagingItemsCollectAsLazyPagingItems = LazyPagingItemsKt.collectAsLazyPagingItems(linkedDeviceViewModel.getLinkedDevices(), null, composer, 0, 1);
            State stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(linkedDeviceViewModel.getActualDevice(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composer, 0, 7);
            LazyListState lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composer, 0, 3);
            Object objRememberedValue = composer.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                composer.updateRememberedValue(objRememberedValue);
            }
            final MutableState mutableState = (MutableState) objRememberedValue;
            Object objRememberedValue2 = composer.rememberedValue();
            if (objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                composer.updateRememberedValue(objRememberedValue2);
            }
            final MutableState mutableState2 = (MutableState) objRememberedValue2;
            final c1.a aVarC = c1.d.c(w.g("android.permission.CAMERA"), null, composer, 0, 2);
            Modifier modifierFillMaxHeight$default = SizeKt.fillMaxHeight$default(PaddingKt.m1727paddingVpY3zN4$default(it, Dp.m8823constructorimpl(20), 0.0f, 2, null), 0.0f, 1, null);
            boolean zChangedInstance = composer.changedInstance(linkedDeviceViewModel) | composer.changedInstance(context) | composer.changed(aVarC) | composer.changedInstance(lazyPagingItemsCollectAsLazyPagingItems);
            Object objRememberedValue3 = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue3 == companion.getEmpty()) {
                Object obj = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.linkedDevice.p
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return LinkedDeviceScreenKt.LinkedDeviceScreen$lambda$1$4$0(lazyPagingItemsCollectAsLazyPagingItems, context, aVarC, linkedDeviceViewModel, mutableState2, mutableState, (LazyListScope) obj2);
                    }
                };
                composer.updateRememberedValue(obj);
                objRememberedValue3 = obj;
            }
            LazyDslKt.LazyColumn(modifierFillMaxHeight$default, lazyListStateRememberLazyListState, null, false, null, null, null, false, null, (Function1) objRememberedValue3, composer, 0, TypedValues.PositionType.TYPE_CURVE_FIT);
            composer.startReplaceGroup(494574372);
            String strStringResource = StringResources_androidKt.stringResource(R.string.please_confirm, composer, 0);
            String strStringResource2 = StringResources_androidKt.stringResource(R.string.you_are_about_to_logout_from, composer, 0);
            String device = ((LinkedDevice) stateCollectAsStateWithLifecycle.getValue()).getDevice();
            Locale locale = Locale.getDefault();
            y.h(locale, "getDefault(...)");
            String upperCase = device.toUpperCase(locale);
            y.h(upperCase, "toUpperCase(...)");
            String str = strStringResource2 + " " + upperCase;
            String strStringResource3 = StringResources_androidKt.stringResource(R.string.no, composer, 0);
            boolean zBooleanValue = ((Boolean) mutableState.getValue()).booleanValue();
            Object objRememberedValue4 = composer.rememberedValue();
            if (objRememberedValue4 == companion.getEmpty()) {
                objRememberedValue4 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.linkedDevice.q
                    @Override // lb.a
                    public final Object invoke() {
                        return LinkedDeviceScreenKt.LinkedDeviceScreen$lambda$1$5$0$0(mutableState);
                    }
                };
                composer.updateRememberedValue(objRememberedValue4);
            }
            lb.a aVar = (lb.a) objRememberedValue4;
            boolean zChangedInstance2 = composer.changedInstance(linkedDeviceViewModel);
            Object objRememberedValue5 = composer.rememberedValue();
            if (zChangedInstance2 || objRememberedValue5 == companion.getEmpty()) {
                objRememberedValue5 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.linkedDevice.c
                    @Override // lb.a
                    public final Object invoke() {
                        return LinkedDeviceScreenKt.LinkedDeviceScreen$lambda$1$5$1$0(linkedDeviceViewModel);
                    }
                };
                composer.updateRememberedValue(objRememberedValue5);
            }
            Z17DialogsKt.Z17DialogWithActions(zBooleanValue, aVar, (lb.a) objRememberedValue5, null, strStringResource, str, null, strStringResource3, composer, 48, 72);
            composer.endReplaceGroup();
            k0 k0Var = k0.f43947a;
            boolean zChangedInstance3 = composer.changedInstance(linkedDeviceViewModel);
            Object objRememberedValue6 = composer.rememberedValue();
            if (zChangedInstance3 || objRememberedValue6 == companion.getEmpty()) {
                objRememberedValue6 = new LinkedDeviceScreenKt$LinkedDeviceScreen$2$3$1(linkedDeviceViewModel, null);
                composer.updateRememberedValue(objRememberedValue6);
            }
            EffectsKt.LaunchedEffect(k0Var, (Function2) objRememberedValue6, composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    private static final boolean LinkedDeviceScreen$lambda$1$2(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void LinkedDeviceScreen$lambda$1$3(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 LinkedDeviceScreen$lambda$1$4$0(final LazyPagingItems lazyPagingItems, final Context context, final c1.a aVar, final LinkedDeviceViewModel linkedDeviceViewModel, final MutableState mutableState, final MutableState mutableState2, LazyListScope LazyColumn) {
        y.i(LazyColumn, "$this$LazyColumn");
        LazyListScope.CC.m(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(-1866744213, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.linkedDevice.e
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return LinkedDeviceScreenKt.LinkedDeviceScreen$lambda$1$4$0$0(context, aVar, linkedDeviceViewModel, mutableState, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }), 3, null);
        LazyColumn.items(lazyPagingItems.getItemCount(), LazyFoundationExtensionsKt.itemKey(lazyPagingItems, new Function1() { // from class: cu.todus.android.uiCompose.main.screen.linkedDevice.f
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return LinkedDeviceScreenKt.LinkedDeviceScreen$lambda$1$4$0$1((LinkedDevice) obj);
            }
        }), LazyFoundationExtensionsKt.itemContentType(lazyPagingItems, new Function1() { // from class: cu.todus.android.uiCompose.main.screen.linkedDevice.g
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return LinkedDeviceScreenKt.LinkedDeviceScreen$lambda$1$4$0$2((LinkedDevice) obj);
            }
        }), ComposableLambdaKt.composableLambdaInstance(-1024304268, true, new lb.o() { // from class: cu.todus.android.uiCompose.main.screen.linkedDevice.h
            @Override // lb.o
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return LinkedDeviceScreenKt.LinkedDeviceScreen$lambda$1$4$0$3(lazyPagingItems, linkedDeviceViewModel, mutableState2, (LazyItemScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
            }
        }));
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 LinkedDeviceScreen$lambda$1$4$0$0(final Context context, final c1.a aVar, final LinkedDeviceViewModel linkedDeviceViewModel, final MutableState mutableState, LazyItemScope item, Composer composer, int i10) {
        Modifier.Companion companion;
        Object obj;
        Composer composer2 = composer;
        y.i(item, "$this$item");
        if (composer2.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1866744213, i10, -1, "cu.todus.android.uiCompose.main.screen.linkedDevice.LinkedDeviceScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (LinkedDeviceScreen.kt:121)");
            }
            Modifier.Companion companion2 = Modifier.INSTANCE;
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(companion2, 0.0f, 1, null);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getCenter(), false);
            int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
            CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer2, modifierFillMaxWidth$default);
            ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
            lb.a constructor = companion3.getConstructor();
            if (!defpackage.r.a(composer2.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                composer2.createNode(constructor);
            } else {
                composer2.useNode();
            }
            Composer composerM5176constructorimpl = Updater.m5176constructorimpl(composer2);
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion3.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl, companion3.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion3.getSetModifier());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            if (LinkedDeviceScreen$lambda$1$2(mutableState)) {
                companion = companion2;
                obj = null;
                composer2.startReplaceGroup(1007605311);
                boolean zChangedInstance = composer2.changedInstance(linkedDeviceViewModel);
                Object objRememberedValue = composer2.rememberedValue();
                if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.linkedDevice.l
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return LinkedDeviceScreenKt.LinkedDeviceScreen$lambda$1$4$0$0$0$0$0(linkedDeviceViewModel, mutableState, (String) obj2);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue);
                }
                Function1 function1 = (Function1) objRememberedValue;
                Object objRememberedValue2 = composer2.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.linkedDevice.m
                        @Override // lb.a
                        public final Object invoke() {
                            return LinkedDeviceScreenKt.LinkedDeviceScreen$lambda$1$4$0$0$0$1$0(mutableState);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue2);
                }
                Z17QRScannerKt.m10300Z17QRScannerHYR8e34(null, function1, (lb.a) objRememberedValue2, null, false, 0.0f, composer2, RendererCapabilities.DECODER_SUPPORT_MASK, 57);
                composer2.endReplaceGroup();
            } else {
                composer2.startReplaceGroup(1007374857);
                Z17PictureKt.m10278Z17BasePictureC8z9wKI(SizeKt.m1769size3ABfNKs(companion2, Dp.m8823constructorimpl(200)), Integer.valueOf(R.drawable.devices_picture), null, null, null, null, 0, null, null, composer, 6, TypedValues.PositionType.TYPE_CURVE_FIT);
                composer2 = composer;
                composer2.endReplaceGroup();
                obj = null;
                companion = companion2;
            }
            composer2.endNode();
            float f10 = 20;
            Modifier modifierM1727paddingVpY3zN4$default = PaddingKt.m1727paddingVpY3zN4$default(companion, Dp.m8823constructorimpl(f10), r5, 2, obj);
            String strStringResource = StringResources_androidKt.stringResource(R.string.use_todus_in_other_device, composer2, 0);
            MaterialTheme materialTheme = MaterialTheme.INSTANCE;
            int i11 = MaterialTheme.$stable;
            TextStyle titleLarge = materialTheme.getTypography(composer2, i11).getTitleLarge();
            TextAlign.Companion companion4 = TextAlign.INSTANCE;
            Z17LabelKt.m10262Z17LabelfWhpE4E(modifierM1727paddingVpY3zN4$default, strStringResource, TextStyle.m8271copyp1EtxEg$default(titleLarge, 0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, companion4.m8692getCentere0LSkKk(), 0, 0L, null, null, null, 0, 0, null, 16744447, null), 0L, 0, 0, composer, 6, 56);
            SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion, Dp.m8823constructorimpl(10)), composer, 6);
            Modifier modifierM1727paddingVpY3zN4$default2 = PaddingKt.m1727paddingVpY3zN4$default(companion, Dp.m8823constructorimpl(f10), r5, 2, obj);
            String strStringResource2 = StringResources_androidKt.stringResource(R.string.use_todus_in_other_device_text, composer, 0);
            long primary = materialTheme.getColorScheme(composer, i11).getPrimary();
            TextStyle textStyleM8271copyp1EtxEg$default = TextStyle.m8271copyp1EtxEg$default(materialTheme.getTypography(composer, i11).getBodyLarge(), 0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, companion4.m8692getCentere0LSkKk(), 0, 0L, null, null, null, 0, 0, null, 16744447, null);
            boolean zChangedInstance2 = composer.changedInstance(context);
            Object objRememberedValue3 = composer.rememberedValue();
            if (zChangedInstance2 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function2() { // from class: cu.todus.android.uiCompose.main.screen.linkedDevice.n
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj2, Object obj3) {
                        return LinkedDeviceScreenKt.LinkedDeviceScreen$lambda$1$4$0$0$1$0(context, (Z17ClickableLabelClickType) obj2, (String) obj3);
                    }
                };
                composer.updateRememberedValue(objRememberedValue3);
            }
            Modifier.Companion companion5 = companion;
            Z17ClickableLabelKt.m10257Z17ClickableLabel0nDMI0(modifierM1727paddingVpY3zN4$default2, textStyleM8271copyp1EtxEg$default, strStringResource2, (Function2) objRememberedValue3, null, 0, 0, primary, 0L, composer, 6, 368);
            SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion5, Dp.m8823constructorimpl(15)), composer, 6);
            Modifier modifierM1727paddingVpY3zN4$default3 = PaddingKt.m1727paddingVpY3zN4$default(companion5, Dp.m8823constructorimpl(f10), 0.0f, 2, obj);
            boolean zChanged = composer.changed(aVar);
            Object objRememberedValue4 = composer.rememberedValue();
            if (zChanged || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.linkedDevice.o
                    @Override // lb.a
                    public final Object invoke() {
                        return LinkedDeviceScreenKt.LinkedDeviceScreen$lambda$1$4$0$0$2$0(aVar, mutableState);
                    }
                };
                composer.updateRememberedValue(objRememberedValue4);
            }
            Z17ButtonsKt.Z17PrimaryButton(modifierM1727paddingVpY3zN4$default3, (lb.a) objRememberedValue4, StringResources_androidKt.stringResource(R.string.link_a_device, composer, 0), null, true, false, composer, 24582, 40);
            SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion5, Dp.m8823constructorimpl(5)), composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 LinkedDeviceScreen$lambda$1$4$0$0$0$0$0(LinkedDeviceViewModel linkedDeviceViewModel, MutableState mutableState, String s10) {
        y.i(s10, "s");
        LinkedDeviceScreen$lambda$1$handleQR(linkedDeviceViewModel, s10);
        LinkedDeviceScreen$lambda$1$3(mutableState, false);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 LinkedDeviceScreen$lambda$1$4$0$0$0$1$0(MutableState mutableState) {
        LinkedDeviceScreen$lambda$1$3(mutableState, false);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 LinkedDeviceScreen$lambda$1$4$0$0$1$0(Context context, Z17ClickableLabelClickType type, String s10) {
        y.i(type, "type");
        y.i(s10, "s");
        if (type == Z17ClickableLabelClickType.LINK) {
            IntentUtil.INSTANCE.showWeb(context, s10);
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 LinkedDeviceScreen$lambda$1$4$0$0$2$0(c1.a aVar, MutableState mutableState) {
        if (aVar.a()) {
            LinkedDeviceScreen$lambda$1$3(mutableState, true);
        } else {
            aVar.b();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object LinkedDeviceScreen$lambda$1$4$0$1(LinkedDevice lD) {
        y.i(lD, "lD");
        return lD.getId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object LinkedDeviceScreen$lambda$1$4$0$2(LinkedDevice i10) {
        y.i(i10, "i");
        return "item";
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 LinkedDeviceScreen$lambda$1$4$0$3(LazyPagingItems lazyPagingItems, final LinkedDeviceViewModel linkedDeviceViewModel, final MutableState mutableState, LazyItemScope items, int i10, Composer composer, int i11) {
        int i12;
        y.i(items, "$this$items");
        if ((i11 & 48) == 0) {
            i12 = i11 | (composer.changed(i10) ? 32 : 16);
        } else {
            i12 = i11;
        }
        if (composer.shouldExecute((i12 & 145) != 144, i12 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1024304268, i12, -1, "cu.todus.android.uiCompose.main.screen.linkedDevice.LinkedDeviceScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (LinkedDeviceScreen.kt:187)");
            }
            final LinkedDevice linkedDevice = (LinkedDevice) lazyPagingItems.get(i10);
            if (linkedDevice == null) {
                composer.startReplaceGroup(694278071);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(694278072);
                Modifier.Companion companion = Modifier.INSTANCE;
                boolean zChangedInstance = composer.changedInstance(linkedDeviceViewModel) | composer.changed(linkedDevice);
                Object objRememberedValue = composer.rememberedValue();
                if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.linkedDevice.d
                        @Override // lb.a
                        public final Object invoke() {
                            return LinkedDeviceScreenKt.LinkedDeviceScreen$lambda$1$4$0$3$0$0$0(linkedDeviceViewModel, linkedDevice, mutableState);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                DeviceItemKt.DeviceItem(ClickableKt.m1240clickableoSLSa3U$default(companion, false, null, null, null, (lb.a) objRememberedValue, 15, null), linkedDevice, composer, 0, 0);
                composer.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 LinkedDeviceScreen$lambda$1$4$0$3$0$0$0(LinkedDeviceViewModel linkedDeviceViewModel, LinkedDevice linkedDevice, MutableState mutableState) {
        linkedDeviceViewModel.getActualDevice().setValue(linkedDevice);
        mutableState.setValue(Boolean.TRUE);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 LinkedDeviceScreen$lambda$1$5$0$0(MutableState mutableState) {
        mutableState.setValue(Boolean.FALSE);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 LinkedDeviceScreen$lambda$1$5$1$0(LinkedDeviceViewModel linkedDeviceViewModel) {
        linkedDeviceViewModel.logoutDevice();
        return k0.f43947a;
    }

    private static final void LinkedDeviceScreen$lambda$1$handleQR(LinkedDeviceViewModel linkedDeviceViewModel, String str) {
        try {
            LinkedDevice linkedDevice = (LinkedDevice) new v5.f().j(str, LinkedDevice.class);
            b0 actualDevice = linkedDeviceViewModel.getActualDevice();
            y.f(linkedDevice);
            actualDevice.setValue(linkedDevice);
            linkedDeviceViewModel.linkNewDevice(linkedDevice.getUrl());
        } catch (Exception unused) {
            linkedDeviceViewModel.setError(new NotCorrectQrException());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 LinkedDeviceScreen$lambda$2(NavHostController navHostController, LinkedDeviceViewModel linkedDeviceViewModel, int i10, int i11, Composer composer, int i12) {
        LinkedDeviceScreen(navHostController, linkedDeviceViewModel, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return k0.f43947a;
    }
}
