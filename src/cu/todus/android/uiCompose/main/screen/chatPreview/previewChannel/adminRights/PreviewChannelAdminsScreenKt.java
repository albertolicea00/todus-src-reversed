package cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel.adminRights;

import ab.i;
import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
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
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
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
import androidx.compose.ui.draw.AlphaKt;
import androidx.compose.ui.draw.ShadowKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import androidx.media3.common.C;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.navigation.NavHostController;
import androidx.p001lifecycle.HasDefaultViewModelProviderFactory;
import androidx.p001lifecycle.Lifecycle;
import androidx.p001lifecycle.LifecycleOwner;
import androidx.p001lifecycle.ViewModel;
import androidx.p001lifecycle.ViewModelProvider;
import androidx.p001lifecycle.ViewModelStoreOwner;
import androidx.p001lifecycle.p002compose.FlowExtKt;
import androidx.p001lifecycle.viewmodel.CreationExtras;
import androidx.p001lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.p001lifecycle.viewmodel.compose.ViewModelKt;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import cu.todus.android.R;
import cu.todus.android.data.wrapper.FlowsState;
import cu.todus.android.uiCompose.loading.screen.LoadingScreenKt;
import cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel.PreviewChannelAdminsParams;
import cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel.PreviewChannelViewModel;
import cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel.adminRights.PreviewChannelAdminsScreenKt;
import cu.todus.android.uiCompose.theme.Other;
import cu.todus.android.utils.ColorGenerator;
import cu.z17.views.button.Z17ButtonsKt;
import cu.z17.views.check.Z17CheckKt;
import cu.z17.views.label.Z17LabelKt;
import cu.z17.views.picture.Z17PictureAvatarKt;
import cu.z17.views.picture.Z17PictureKt;
import cu.z17.views.scaffold.Z17ScaffoldKt;
import cu.z17.views.topBar.Z17TopBarKt;
import cu.z17.views.utils.Z17InlineUtilsKt;
import defpackage.l;
import defpackage.r;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.y;
import kotlin.jvm.internal.z0;
import lb.a;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\u001a)\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b\u001a\u001f\u0010\u000b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u000b\u0010\f\u001a;\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00060\u000f2\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u001f²\u0006\u0012\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\r0\u00158\nX\u008a\u0084\u0002²\u0006\u000e\u0010\u0017\u001a\u00020\r8\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\u0018\u001a\u00020\r8\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\u0019\u001a\u00020\r8\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\u001a\u001a\u00020\r8\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\u001b\u001a\u00020\r8\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\u001c\u001a\u00020\r8\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\u001d\u001a\u00020\r8\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\u001e\u001a\u00020\r8\n@\nX\u008a\u008e\u0002"}, d2 = {"Landroidx/navigation/NavHostController;", "navHostController", "", "params", "Lcu/todus/android/uiCompose/main/screen/chatPreview/previewChannel/PreviewChannelViewModel;", "viewModel", "Lua/k0;", "PreviewChannelAdminsScreen", "(Landroidx/navigation/NavHostController;Ljava/lang/String;Lcu/todus/android/uiCompose/main/screen/chatPreview/previewChannel/PreviewChannelViewModel;Landroidx/compose/runtime/Composer;II)V", "name", "image", "SubscriberCard", "(Ljava/lang/String;Ljava/lang/String;Landroidx/compose/runtime/Composer;I)V", "", AppMeasurementSdk.ConditionalUserProperty.ACTIVE, "Lkotlin/Function1;", "onChange", "title", "description", "RightItem", "(ZLkotlin/jvm/functions/Function1;Ljava/lang/String;Ljava/lang/String;Landroidx/compose/runtime/Composer;I)V", "Lcu/todus/android/data/wrapper/FlowsState;", "expelSubscriber", "isLoading", "showSave", "aa", "pm", "ci", "iwl", "dom", "eom", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class PreviewChannelAdminsScreenKt {
    /* JADX WARN: Code duplicated, block: B:56:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:59:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:62:0x010d  */
    /* JADX WARN: Code duplicated, block: B:65:0x0157  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void PreviewChannelAdminsScreen(final NavHostController navHostController, final String params, PreviewChannelViewModel previewChannelViewModel, Composer composer, final int i10, final int i11) {
        int i12;
        PreviewChannelViewModel previewChannelViewModel2;
        final PreviewChannelViewModel previewChannelViewModel3;
        Object objRememberedValue;
        Composer.Companion companion;
        Object objRememberedValue2;
        y.i(navHostController, "navHostController");
        y.i(params, "params");
        Composer composerStartRestartGroup = composer.startRestartGroup(1768410239);
        if ((i10 & 6) == 0) {
            i12 = (composerStartRestartGroup.changedInstance(navHostController) ? 4 : 2) | i10;
        } else {
            i12 = i10;
        }
        if ((i10 & 48) == 0) {
            i12 |= composerStartRestartGroup.changed(params) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            if ((i11 & 4) == 0) {
                previewChannelViewModel2 = previewChannelViewModel;
                int i13 = composerStartRestartGroup.changedInstance(previewChannelViewModel2) ? 256 : 128;
                i12 |= i13;
            } else {
                previewChannelViewModel2 = previewChannelViewModel;
            }
            i12 |= i13;
        } else {
            previewChannelViewModel2 = previewChannelViewModel;
        }
        if (composerStartRestartGroup.shouldExecute((i12 & 147) != 146, i12 & 1)) {
            composerStartRestartGroup.startDefaults();
            if ((i10 & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                if ((i11 & 4) != 0) {
                    ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composerStartRestartGroup, 6);
                    if (current == null) {
                        throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                    }
                    ViewModel viewModel = ViewModelKt.viewModel(z0.b(PreviewChannelViewModel.class), current, (String) null, (ViewModelProvider.Factory) null, current instanceof HasDefaultViewModelProviderFactory ? ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras() : CreationExtras.Empty.INSTANCE, composerStartRestartGroup, 0, 0);
                    composerStartRestartGroup = composerStartRestartGroup;
                    previewChannelViewModel2 = (PreviewChannelViewModel) viewModel;
                    i12 &= -897;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1768410239, i12, -1, "cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel.adminRights.PreviewChannelAdminsScreen (PreviewChannelAdminsScreen.kt:64)");
                }
                ScaffoldState scaffoldStateRememberScaffoldState = ScaffoldKt.rememberScaffoldState(null, null, composerStartRestartGroup, r9, 3);
                final ScrollState scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, r9, r10);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                companion = Composer.INSTANCE;
                if (objRememberedValue == companion.getEmpty()) {
                    objRememberedValue = (PreviewChannelAdminsParams) previewChannelViewModel2.getGson().j(params, PreviewChannelAdminsParams.class);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                final PreviewChannelAdminsParams previewChannelAdminsParams = (PreviewChannelAdminsParams) objRememberedValue;
                final State stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(previewChannelViewModel2.getExpelSubscriber(), (LifecycleOwner) null, (Lifecycle.State) null, (i) null, composerStartRestartGroup, 0, 7);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == companion.getEmpty()) {
                    objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                final MutableState mutableState = (MutableState) objRememberedValue2;
                final PreviewChannelViewModel previewChannelViewModel4 = previewChannelViewModel2;
                Composer composer2 = composerStartRestartGroup;
                Z17ScaffoldKt.m10301Z17BaseScaffoldueL0Wzs(ComposableLambdaKt.rememberComposableLambda(60222667, r10, new Function3() { // from class: w7.h
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return PreviewChannelAdminsScreenKt.PreviewChannelAdminsScreen$lambda$5(navHostController, (TopAppBarScrollBehavior) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), false, true, false, null, null, 0L, scaffoldStateRememberScaffoldState, null, ComposableLambdaKt.rememberComposableLambda(-897249655, true, new Function3() { // from class: w7.i
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return PreviewChannelAdminsScreenKt.PreviewChannelAdminsScreen$lambda$6(scrollStateRememberScrollState, previewChannelAdminsParams, stateCollectAsStateWithLifecycle, navHostController, previewChannelViewModel4, mutableState, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composer2, 805306806, 376);
                composerStartRestartGroup = composer2;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                previewChannelViewModel3 = previewChannelViewModel4;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i11 & 4) != 0) {
                    i12 &= -897;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1768410239, i12, -1, "cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel.adminRights.PreviewChannelAdminsScreen (PreviewChannelAdminsScreen.kt:64)");
            }
            ScaffoldState scaffoldStateRememberScaffoldState2 = ScaffoldKt.rememberScaffoldState(null, null, composerStartRestartGroup, r9, 3);
            final ScrollState scrollStateRememberScrollState2 = ScrollKt.rememberScrollState(0, composerStartRestartGroup, r9, r10);
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            companion = Composer.INSTANCE;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = (PreviewChannelAdminsParams) previewChannelViewModel2.getGson().j(params, PreviewChannelAdminsParams.class);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final PreviewChannelAdminsParams previewChannelAdminsParams2 = (PreviewChannelAdminsParams) objRememberedValue;
            final State stateCollectAsStateWithLifecycle2 = FlowExtKt.collectAsStateWithLifecycle(previewChannelViewModel2.getExpelSubscriber(), (LifecycleOwner) null, (Lifecycle.State) null, (i) null, composerStartRestartGroup, 0, 7);
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            final MutableState mutableState2 = (MutableState) objRememberedValue2;
            final PreviewChannelViewModel previewChannelViewModel5 = previewChannelViewModel2;
            Composer composer3 = composerStartRestartGroup;
            Z17ScaffoldKt.m10301Z17BaseScaffoldueL0Wzs(ComposableLambdaKt.rememberComposableLambda(60222667, r10, new Function3() { // from class: w7.h
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return PreviewChannelAdminsScreenKt.PreviewChannelAdminsScreen$lambda$5(navHostController, (TopAppBarScrollBehavior) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), false, true, false, null, null, 0L, scaffoldStateRememberScaffoldState2, null, ComposableLambdaKt.rememberComposableLambda(-897249655, true, new Function3() { // from class: w7.i
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return PreviewChannelAdminsScreenKt.PreviewChannelAdminsScreen$lambda$6(scrollStateRememberScrollState2, previewChannelAdminsParams2, stateCollectAsStateWithLifecycle2, navHostController, previewChannelViewModel5, mutableState2, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composer3, 805306806, 376);
            composerStartRestartGroup = composer3;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            previewChannelViewModel3 = previewChannelViewModel5;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            previewChannelViewModel3 = previewChannelViewModel2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: w7.j
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PreviewChannelAdminsScreenKt.PreviewChannelAdminsScreen$lambda$7(navHostController, params, previewChannelViewModel3, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final FlowsState<Boolean> PreviewChannelAdminsScreen$lambda$1(State<FlowsState<Boolean>> state) {
        return state.getValue();
    }

    private static final boolean PreviewChannelAdminsScreen$lambda$3(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void PreviewChannelAdminsScreen$lambda$4(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 PreviewChannelAdminsScreen$lambda$5(final NavHostController navHostController, TopAppBarScrollBehavior it, Composer composer, int i10) {
        int i11;
        y.i(it, "it");
        if ((i10 & 6) == 0) {
            i11 = i10 | (composer.changed(it) ? 4 : 2);
        } else {
            i11 = i10;
        }
        if (composer.shouldExecute((i11 & 19) != 18, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(60222667, i11, -1, "cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel.adminRights.PreviewChannelAdminsScreen.<anonymous> (PreviewChannelAdminsScreen.kt:84)");
            }
            Function2 function2M9915getLambda$450179938$app_productionPFast = ComposableSingletons$PreviewChannelAdminsScreenKt.INSTANCE.m9915getLambda$450179938$app_productionPFast();
            boolean zChangedInstance = composer.changedInstance(navHostController);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new a() { // from class: w7.f
                    @Override // lb.a
                    public final Object invoke() {
                        return PreviewChannelAdminsScreenKt.PreviewChannelAdminsScreen$lambda$5$0$0(navHostController);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            Z17TopBarKt.m10304Z17TopBardW2gCk(function2M9915getLambda$450179938$app_productionPFast, it, false, null, false, navHostController, (a) objRememberedValue, null, 0L, 0L, 0.0f, composer, ((i11 << 3) & 112) | 6, 0, 1948);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 PreviewChannelAdminsScreen$lambda$5$0$0(NavHostController navHostController) {
        navHostController.navigateUp();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 PreviewChannelAdminsScreen$lambda$6(ScrollState scrollState, final PreviewChannelAdminsParams previewChannelAdminsParams, State state, final NavHostController navHostController, final PreviewChannelViewModel previewChannelViewModel, final MutableState mutableState, Modifier it, Composer composer, int i10) {
        int i11;
        String strStringResource;
        final MutableState mutableState2;
        final MutableState mutableState3;
        Composer composer2 = composer;
        y.i(it, "it");
        if ((i10 & 6) == 0) {
            i11 = i10 | (composer2.changed(it) ? 4 : 2);
        } else {
            i11 = i10;
        }
        if (composer2.shouldExecute((i11 & 19) != 18, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-897249655, i11, -1, "cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel.adminRights.PreviewChannelAdminsScreen.<anonymous> (PreviewChannelAdminsScreen.kt:100)");
            }
            Object objRememberedValue = composer2.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(previewChannelAdminsParams.getRights().contains("aa")), null, 2, null);
                composer2.updateRememberedValue(objRememberedValue);
            }
            final MutableState mutableState4 = (MutableState) objRememberedValue;
            Object objRememberedValue2 = composer2.rememberedValue();
            if (objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(previewChannelAdminsParams.getRights().contains("aa")), null, 2, null);
                composer2.updateRememberedValue(objRememberedValue2);
            }
            final MutableState mutableState5 = (MutableState) objRememberedValue2;
            Object objRememberedValue3 = composer2.rememberedValue();
            if (objRememberedValue3 == companion.getEmpty()) {
                objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(previewChannelAdminsParams.getRights().contains("pm")), null, 2, null);
                composer2.updateRememberedValue(objRememberedValue3);
            }
            final MutableState mutableState6 = (MutableState) objRememberedValue3;
            Object objRememberedValue4 = composer2.rememberedValue();
            if (objRememberedValue4 == companion.getEmpty()) {
                objRememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(previewChannelAdminsParams.getRights().contains("ci")), null, 2, null);
                composer2.updateRememberedValue(objRememberedValue4);
            }
            final MutableState mutableState7 = (MutableState) objRememberedValue4;
            Object objRememberedValue5 = composer2.rememberedValue();
            if (objRememberedValue5 == companion.getEmpty()) {
                objRememberedValue5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(previewChannelAdminsParams.getRights().contains("iwl")), null, 2, null);
                composer2.updateRememberedValue(objRememberedValue5);
            }
            final MutableState mutableState8 = (MutableState) objRememberedValue5;
            Object objRememberedValue6 = composer2.rememberedValue();
            if (objRememberedValue6 == companion.getEmpty()) {
                objRememberedValue6 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(previewChannelAdminsParams.getRights().contains("dom")), null, 2, null);
                composer2.updateRememberedValue(objRememberedValue6);
            }
            final MutableState mutableState9 = (MutableState) objRememberedValue6;
            Object objRememberedValue7 = composer2.rememberedValue();
            if (objRememberedValue7 == companion.getEmpty()) {
                objRememberedValue7 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(previewChannelAdminsParams.getRights().contains("eom")), null, 2, null);
                composer2.updateRememberedValue(objRememberedValue7);
            }
            final MutableState mutableState10 = (MutableState) objRememberedValue7;
            float f10 = 20;
            Modifier modifierVerticalScroll$default = ScrollKt.verticalScroll$default(PaddingKt.m1727paddingVpY3zN4$default(it, Dp.m8823constructorimpl(f10), 0.0f, 2, null), scrollState, false, null, false, 14, null);
            Arrangement arrangement = Arrangement.INSTANCE;
            Arrangement.Vertical top = arrangement.getTop();
            Alignment.Companion companion2 = Alignment.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(top, companion2.getStart(), composer2, 0);
            int iA = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
            CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer2, modifierVerticalScroll$default);
            ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
            a constructor = companion3.getConstructor();
            if (!r.a(composer2.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                composer2.createNode(constructor);
            } else {
                composer2.useNode();
            }
            Composer composerM5176constructorimpl = Updater.m5176constructorimpl(composer2);
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyColumnMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion3.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl, companion3.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion3.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            SubscriberCard(previewChannelAdminsParams.getPartner().getName(), previewChannelAdminsParams.getPartner().getPicture(), composer2, 0);
            int i12 = 6;
            if (y.d(PreviewChannelAdminsScreen$lambda$1(state).getData(), Boolean.TRUE)) {
                composer2.startReplaceGroup(-2036726966);
                Modifier modifierFillMaxHeight$default = SizeKt.fillMaxHeight$default(Modifier.INSTANCE, 0.0f, 1, null);
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion2.getCenter(), false);
                int iA2 = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
                CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer2, modifierFillMaxHeight$default);
                a constructor2 = companion3.getConstructor();
                if (!r.a(composer2.getApplier())) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor2);
                } else {
                    composer2.useNode();
                }
                Composer composerM5176constructorimpl2 = Updater.m5176constructorimpl(composer2);
                Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy, companion3.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
                Updater.m5180initimpl(composerM5176constructorimpl2, Integer.valueOf(iA2), companion3.getSetCompositeKeyHash());
                Updater.m5182reconcileimpl(composerM5176constructorimpl2, companion3.getApplyOnDeactivatedNodeAssertion());
                Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier2, companion3.getSetModifier());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                boolean zChangedInstance = composer2.changedInstance(navHostController);
                Object objRememberedValue8 = composer2.rememberedValue();
                if (zChangedInstance || objRememberedValue8 == companion.getEmpty()) {
                    objRememberedValue8 = new a() { // from class: w7.p
                        @Override // lb.a
                        public final Object invoke() {
                            return PreviewChannelAdminsScreenKt.PreviewChannelAdminsScreen$lambda$6$21$0$0$0(navHostController);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue8);
                }
                Z17ButtonsKt.Z17PrimaryButton(null, (a) objRememberedValue8, StringResources_androidKt.stringResource(R.string.go_back, composer2, 0), null, true, false, composer2, 24576, 41);
                composer2.endNode();
                composer2.endReplaceGroup();
            } else {
                composer2.startReplaceGroup(-2036111864);
                Arrangement.HorizontalOrVertical spaceBetween = arrangement.getSpaceBetween();
                Modifier.Companion companion4 = Modifier.INSTANCE;
                Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(companion4, 0.0f, 1, null);
                MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(spaceBetween, companion2.getTop(), composer2, 6);
                int iA3 = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
                CompositionLocalMap currentCompositionLocalMap3 = composer2.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composer2, modifierFillMaxWidth$default);
                a constructor3 = companion3.getConstructor();
                if (!r.a(composer2.getApplier())) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor3);
                } else {
                    composer2.useNode();
                }
                Composer composerM5176constructorimpl3 = Updater.m5176constructorimpl(composer2);
                Updater.m5184setimpl(composerM5176constructorimpl3, measurePolicyRowMeasurePolicy, companion3.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl3, currentCompositionLocalMap3, companion3.getSetResolvedCompositionLocals());
                Updater.m5180initimpl(composerM5176constructorimpl3, Integer.valueOf(iA3), companion3.getSetCompositeKeyHash());
                Updater.m5182reconcileimpl(composerM5176constructorimpl3, companion3.getApplyOnDeactivatedNodeAssertion());
                Updater.m5184setimpl(composerM5176constructorimpl3, modifierMaterializeModifier3, companion3.getSetModifier());
                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                Modifier modifierA = e3.a(rowScopeInstance, companion4, 0.4f, false, 2, null);
                boolean zChangedInstance2 = composer2.changedInstance(previewChannelViewModel);
                Object objRememberedValue9 = composer2.rememberedValue();
                if (zChangedInstance2 || objRememberedValue9 == companion.getEmpty()) {
                    objRememberedValue9 = new a() { // from class: w7.q
                        @Override // lb.a
                        public final Object invoke() {
                            return PreviewChannelAdminsScreenKt.PreviewChannelAdminsScreen$lambda$6$21$1$0$0(previewChannelViewModel, previewChannelAdminsParams, mutableState);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue9);
                }
                float f11 = 2;
                Modifier modifierM1725padding3ABfNKs = PaddingKt.m1725padding3ABfNKs(ClickableKt.m1240clickableoSLSa3U$default(modifierA, false, null, null, null, (a) objRememberedValue9, 15, null), Dp.m8823constructorimpl(f11));
                float fM8823constructorimpl = Dp.m8823constructorimpl(1);
                MaterialTheme materialTheme = MaterialTheme.INSTANCE;
                int i13 = MaterialTheme.$stable;
                float f12 = 15;
                float f13 = 10;
                Modifier modifierM1727paddingVpY3zN4$default = PaddingKt.m1727paddingVpY3zN4$default(BorderKt.m1216borderxT4_qwU(modifierM1725padding3ABfNKs, fM8823constructorimpl, materialTheme.getColorScheme(composer2, i13).getOnSurface(), RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(f12))), 0.0f, Dp.m8823constructorimpl(f13), 1, null);
                String strStringResource2 = StringResources_androidKt.stringResource(R.string.expel, composer2, 0);
                TextStyle bodyMedium = materialTheme.getTypography(composer2, i13).getBodyMedium();
                TextAlign.Companion companion5 = TextAlign.INSTANCE;
                Z17LabelKt.m10262Z17LabelfWhpE4E(modifierM1727paddingVpY3zN4$default, strStringResource2, TextStyle.m8271copyp1EtxEg$default(bodyMedium, 0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, companion5.m8692getCentere0LSkKk(), 0, 0L, null, null, null, 0, 0, null, 16744447, null), materialTheme.getColorScheme(composer2, i13).getOnBackground(), 0, 0, composer2, 0, 48);
                Modifier modifierA2 = e3.a(rowScopeInstance, companion4, 0.4f, false, 2, null);
                Object objRememberedValue10 = composer2.rememberedValue();
                if (objRememberedValue10 == companion.getEmpty()) {
                    objRememberedValue10 = new a() { // from class: w7.r
                        @Override // lb.a
                        public final Object invoke() {
                            return PreviewChannelAdminsScreenKt.PreviewChannelAdminsScreen$lambda$6$21$1$1$0(mutableState5, mutableState6, mutableState7, mutableState8, mutableState9, mutableState10, mutableState4);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue10);
                }
                Modifier modifierM1727paddingVpY3zN4$default2 = PaddingKt.m1727paddingVpY3zN4$default(BackgroundKt.m1204backgroundbw27NRU(PaddingKt.m1725padding3ABfNKs(ClickableKt.m1240clickableoSLSa3U$default(modifierA2, false, null, null, null, (a) objRememberedValue10, 15, null), Dp.m8823constructorimpl(f11)), materialTheme.getColorScheme(composer2, i13).getOnSurface(), RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(f12))), 0.0f, Dp.m8823constructorimpl(f13), 1, null);
                if (PreviewChannelAdminsScreen$lambda$6$4(mutableState5) || PreviewChannelAdminsScreen$lambda$6$7(mutableState6) || PreviewChannelAdminsScreen$lambda$6$10(mutableState7) || PreviewChannelAdminsScreen$lambda$6$13(mutableState8) || PreviewChannelAdminsScreen$lambda$6$16(mutableState9) || PreviewChannelAdminsScreen$lambda$6$19(mutableState10)) {
                    composer2.startReplaceGroup(987464981);
                    strStringResource = StringResources_androidKt.stringResource(R.string.remove_admin, composer2, 0);
                    composer2.endReplaceGroup();
                } else {
                    composer2.startReplaceGroup(987468179);
                    strStringResource = StringResources_androidKt.stringResource(R.string.make_admin, composer2, 0);
                    composer2.endReplaceGroup();
                }
                Z17LabelKt.m10262Z17LabelfWhpE4E(modifierM1727paddingVpY3zN4$default2, strStringResource, TextStyle.m8271copyp1EtxEg$default(materialTheme.getTypography(composer2, i13).getBodyMedium(), 0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, companion5.m8692getCentere0LSkKk(), 0, 0L, null, null, null, 0, 0, null, 16744447, null), materialTheme.getColorScheme(composer2, i13).getBackground(), 0, 0, composer2, 0, 48);
                composer2.endNode();
                i12 = 6;
                SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion4, Dp.m8823constructorimpl(f10)), composer2, 6);
                boolean zPreviewChannelAdminsScreen$lambda$6$4 = PreviewChannelAdminsScreen$lambda$6$4(mutableState5);
                Object objRememberedValue11 = composer2.rememberedValue();
                if (objRememberedValue11 == companion.getEmpty()) {
                    objRememberedValue11 = new Function1() { // from class: w7.s
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return PreviewChannelAdminsScreenKt.PreviewChannelAdminsScreen$lambda$6$21$2$0(mutableState5, mutableState4, ((Boolean) obj).booleanValue());
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue11);
                }
                RightItem(zPreviewChannelAdminsScreen$lambda$6$4, (Function1) objRememberedValue11, StringResources_androidKt.stringResource(R.string.add_admins, composer2, 0), StringResources_androidKt.stringResource(R.string.add_admins_desc, composer2, 0), composer2, 48);
                boolean zPreviewChannelAdminsScreen$lambda$6$7 = PreviewChannelAdminsScreen$lambda$6$7(mutableState6);
                Object objRememberedValue12 = composer2.rememberedValue();
                if (objRememberedValue12 == companion.getEmpty()) {
                    objRememberedValue12 = new Function1() { // from class: w7.t
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return PreviewChannelAdminsScreenKt.PreviewChannelAdminsScreen$lambda$6$21$3$0(mutableState6, mutableState4, ((Boolean) obj).booleanValue());
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue12);
                }
                RightItem(zPreviewChannelAdminsScreen$lambda$6$7, (Function1) objRememberedValue12, StringResources_androidKt.stringResource(R.string.publish, composer2, 0), StringResources_androidKt.stringResource(R.string.publish_desc, composer2, 0), composer2, 48);
                boolean zPreviewChannelAdminsScreen$lambda$6$10 = PreviewChannelAdminsScreen$lambda$6$10(mutableState7);
                Object objRememberedValue13 = composer2.rememberedValue();
                if (objRememberedValue13 == companion.getEmpty()) {
                    objRememberedValue13 = new Function1() { // from class: w7.u
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return PreviewChannelAdminsScreenKt.PreviewChannelAdminsScreen$lambda$6$21$4$0(mutableState7, mutableState4, ((Boolean) obj).booleanValue());
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue13);
                }
                RightItem(zPreviewChannelAdminsScreen$lambda$6$10, (Function1) objRememberedValue13, StringResources_androidKt.stringResource(R.string.change_info, composer2, 0), StringResources_androidKt.stringResource(R.string.change_info_desc, composer2, 0), composer2, 48);
                boolean zPreviewChannelAdminsScreen$lambda$6$13 = PreviewChannelAdminsScreen$lambda$6$13(mutableState8);
                Object objRememberedValue14 = composer2.rememberedValue();
                if (objRememberedValue14 == companion.getEmpty()) {
                    objRememberedValue14 = new Function1() { // from class: w7.c
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return PreviewChannelAdminsScreenKt.PreviewChannelAdminsScreen$lambda$6$21$5$0(mutableState8, mutableState4, ((Boolean) obj).booleanValue());
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue14);
                }
                RightItem(zPreviewChannelAdminsScreen$lambda$6$13, (Function1) objRememberedValue14, StringResources_androidKt.stringResource(R.string.invitation_link, composer2, 0), StringResources_androidKt.stringResource(R.string.invitation_link_desc, composer2, 0), composer2, 48);
                boolean zPreviewChannelAdminsScreen$lambda$6$16 = PreviewChannelAdminsScreen$lambda$6$16(mutableState9);
                Object objRememberedValue15 = composer2.rememberedValue();
                if (objRememberedValue15 == companion.getEmpty()) {
                    mutableState2 = mutableState9;
                    objRememberedValue15 = new Function1() { // from class: w7.m
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return PreviewChannelAdminsScreenKt.PreviewChannelAdminsScreen$lambda$6$21$6$0(mutableState2, mutableState4, ((Boolean) obj).booleanValue());
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue15);
                } else {
                    mutableState2 = mutableState9;
                }
                RightItem(zPreviewChannelAdminsScreen$lambda$6$16, (Function1) objRememberedValue15, StringResources_androidKt.stringResource(R.string.delete_other_messages, composer2, 0), StringResources_androidKt.stringResource(R.string.delete_other_messages_desc, composer2, 0), composer2, 48);
                boolean zPreviewChannelAdminsScreen$lambda$6$19 = PreviewChannelAdminsScreen$lambda$6$19(mutableState10);
                Object objRememberedValue16 = composer2.rememberedValue();
                if (objRememberedValue16 == companion.getEmpty()) {
                    mutableState3 = mutableState10;
                    objRememberedValue16 = new Function1() { // from class: w7.n
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return PreviewChannelAdminsScreenKt.PreviewChannelAdminsScreen$lambda$6$21$7$0(mutableState3, mutableState4, ((Boolean) obj).booleanValue());
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue16);
                } else {
                    mutableState3 = mutableState10;
                }
                RightItem(zPreviewChannelAdminsScreen$lambda$6$19, (Function1) objRememberedValue16, StringResources_androidKt.stringResource(R.string.edit_other_messages, composer2, 0), StringResources_androidKt.stringResource(R.string.edit_other_messages_desc, composer2, 0), composer2, 48);
                SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion4, Dp.m8823constructorimpl(f10)), composer2, 6);
                AnimatedVisibilityKt.AnimatedVisibility(columnScopeInstance, PreviewChannelAdminsScreen$lambda$6$1(mutableState4), (Modifier) null, (EnterTransition) null, (ExitTransition) null, (String) null, ComposableLambdaKt.rememberComposableLambda(618826711, true, new Function3() { // from class: w7.o
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return PreviewChannelAdminsScreenKt.PreviewChannelAdminsScreen$lambda$6$21$8(previewChannelViewModel, previewChannelAdminsParams, mutableState, mutableState5, mutableState6, mutableState7, mutableState8, mutableState2, mutableState3, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composer2, 54), composer2, 1572870, 30);
                composer2 = composer2;
                composer2.endReplaceGroup();
            }
            SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(30)), composer2, i12);
            composer2.endNode();
            if (PreviewChannelAdminsScreen$lambda$3(mutableState)) {
                composer2.startReplaceGroup(1031770198);
                LoadingScreenKt.LoadingWall(composer2, 0);
            } else {
                composer2.startReplaceGroup(1920117561);
            }
            composer2.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    private static final boolean PreviewChannelAdminsScreen$lambda$6$1(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final boolean PreviewChannelAdminsScreen$lambda$6$10(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void PreviewChannelAdminsScreen$lambda$6$11(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    private static final boolean PreviewChannelAdminsScreen$lambda$6$13(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void PreviewChannelAdminsScreen$lambda$6$14(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    private static final boolean PreviewChannelAdminsScreen$lambda$6$16(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void PreviewChannelAdminsScreen$lambda$6$17(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    private static final boolean PreviewChannelAdminsScreen$lambda$6$19(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void PreviewChannelAdminsScreen$lambda$6$2(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    private static final void PreviewChannelAdminsScreen$lambda$6$20(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 PreviewChannelAdminsScreen$lambda$6$21$0$0$0(NavHostController navHostController) {
        navHostController.navigateUp();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 PreviewChannelAdminsScreen$lambda$6$21$1$0$0(PreviewChannelViewModel previewChannelViewModel, PreviewChannelAdminsParams previewChannelAdminsParams, final MutableState mutableState) {
        PreviewChannelAdminsScreen$lambda$4(mutableState, true);
        previewChannelViewModel.expelSubscriber(previewChannelAdminsParams.getChId(), previewChannelAdminsParams.getPartner().getId(), new a() { // from class: w7.l
            @Override // lb.a
            public final Object invoke() {
                return PreviewChannelAdminsScreenKt.PreviewChannelAdminsScreen$lambda$6$21$1$0$0$0(mutableState);
            }
        });
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 PreviewChannelAdminsScreen$lambda$6$21$1$0$0$0(MutableState mutableState) {
        PreviewChannelAdminsScreen$lambda$4(mutableState, false);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 PreviewChannelAdminsScreen$lambda$6$21$1$1$0(MutableState mutableState, MutableState mutableState2, MutableState mutableState3, MutableState mutableState4, MutableState mutableState5, MutableState mutableState6, MutableState mutableState7) {
        if (PreviewChannelAdminsScreen$lambda$6$4(mutableState) || PreviewChannelAdminsScreen$lambda$6$7(mutableState2) || PreviewChannelAdminsScreen$lambda$6$10(mutableState3) || PreviewChannelAdminsScreen$lambda$6$13(mutableState4) || PreviewChannelAdminsScreen$lambda$6$16(mutableState5) || PreviewChannelAdminsScreen$lambda$6$19(mutableState6)) {
            PreviewChannelAdminsScreen$lambda$6$5(mutableState, false);
            PreviewChannelAdminsScreen$lambda$6$8(mutableState2, false);
            PreviewChannelAdminsScreen$lambda$6$11(mutableState3, false);
            PreviewChannelAdminsScreen$lambda$6$14(mutableState4, false);
            PreviewChannelAdminsScreen$lambda$6$17(mutableState5, false);
            PreviewChannelAdminsScreen$lambda$6$20(mutableState6, false);
        } else {
            PreviewChannelAdminsScreen$lambda$6$5(mutableState, true);
            PreviewChannelAdminsScreen$lambda$6$8(mutableState2, true);
            PreviewChannelAdminsScreen$lambda$6$11(mutableState3, true);
            PreviewChannelAdminsScreen$lambda$6$14(mutableState4, true);
            PreviewChannelAdminsScreen$lambda$6$17(mutableState5, true);
            PreviewChannelAdminsScreen$lambda$6$20(mutableState6, true);
        }
        PreviewChannelAdminsScreen$lambda$6$2(mutableState7, true);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 PreviewChannelAdminsScreen$lambda$6$21$2$0(MutableState mutableState, MutableState mutableState2, boolean z10) {
        PreviewChannelAdminsScreen$lambda$6$5(mutableState, z10);
        PreviewChannelAdminsScreen$lambda$6$2(mutableState2, true);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 PreviewChannelAdminsScreen$lambda$6$21$3$0(MutableState mutableState, MutableState mutableState2, boolean z10) {
        PreviewChannelAdminsScreen$lambda$6$8(mutableState, z10);
        PreviewChannelAdminsScreen$lambda$6$2(mutableState2, true);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 PreviewChannelAdminsScreen$lambda$6$21$4$0(MutableState mutableState, MutableState mutableState2, boolean z10) {
        PreviewChannelAdminsScreen$lambda$6$11(mutableState, z10);
        PreviewChannelAdminsScreen$lambda$6$2(mutableState2, true);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 PreviewChannelAdminsScreen$lambda$6$21$5$0(MutableState mutableState, MutableState mutableState2, boolean z10) {
        PreviewChannelAdminsScreen$lambda$6$14(mutableState, z10);
        PreviewChannelAdminsScreen$lambda$6$2(mutableState2, true);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 PreviewChannelAdminsScreen$lambda$6$21$6$0(MutableState mutableState, MutableState mutableState2, boolean z10) {
        PreviewChannelAdminsScreen$lambda$6$17(mutableState, z10);
        PreviewChannelAdminsScreen$lambda$6$2(mutableState2, true);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 PreviewChannelAdminsScreen$lambda$6$21$7$0(MutableState mutableState, MutableState mutableState2, boolean z10) {
        PreviewChannelAdminsScreen$lambda$6$20(mutableState, z10);
        PreviewChannelAdminsScreen$lambda$6$2(mutableState2, true);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 PreviewChannelAdminsScreen$lambda$6$21$8(final PreviewChannelViewModel previewChannelViewModel, final PreviewChannelAdminsParams previewChannelAdminsParams, final MutableState mutableState, final MutableState mutableState2, final MutableState mutableState3, final MutableState mutableState4, final MutableState mutableState5, final MutableState mutableState6, final MutableState mutableState7, AnimatedVisibilityScope AnimatedVisibility, Composer composer, int i10) {
        y.i(AnimatedVisibility, "$this$AnimatedVisibility");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(618826711, i10, -1, "cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel.adminRights.PreviewChannelAdminsScreen.<anonymous>.<anonymous>.<anonymous> (PreviewChannelAdminsScreen.kt:284)");
        }
        boolean zChangedInstance = composer.changedInstance(previewChannelViewModel);
        Object objRememberedValue = composer.rememberedValue();
        if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            a aVar = new a() { // from class: w7.k
                @Override // lb.a
                public final Object invoke() {
                    return PreviewChannelAdminsScreenKt.PreviewChannelAdminsScreen$lambda$6$21$8$0$0(previewChannelViewModel, previewChannelAdminsParams, mutableState, mutableState2, mutableState3, mutableState4, mutableState5, mutableState6, mutableState7);
                }
            };
            composer.updateRememberedValue(aVar);
            objRememberedValue = aVar;
        }
        Z17ButtonsKt.Z17PrimaryButton(null, (a) objRememberedValue, StringResources_androidKt.stringResource(R.string.save, composer, 0), null, true, false, composer, 24576, 41);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 PreviewChannelAdminsScreen$lambda$6$21$8$0$0(PreviewChannelViewModel previewChannelViewModel, PreviewChannelAdminsParams previewChannelAdminsParams, final MutableState mutableState, MutableState mutableState2, MutableState mutableState3, MutableState mutableState4, MutableState mutableState5, MutableState mutableState6, MutableState mutableState7) {
        PreviewChannelAdminsScreen$lambda$4(mutableState, true);
        ArrayList arrayList = new ArrayList();
        if (PreviewChannelAdminsScreen$lambda$6$4(mutableState2)) {
            arrayList.add("aa");
        }
        if (PreviewChannelAdminsScreen$lambda$6$7(mutableState3)) {
            arrayList.add("pm");
        }
        if (PreviewChannelAdminsScreen$lambda$6$10(mutableState4)) {
            arrayList.add("ci");
        }
        if (PreviewChannelAdminsScreen$lambda$6$13(mutableState5)) {
            arrayList.add("iwl");
        }
        if (PreviewChannelAdminsScreen$lambda$6$16(mutableState6)) {
            arrayList.add("dom");
        }
        if (PreviewChannelAdminsScreen$lambda$6$19(mutableState7)) {
            arrayList.add("eom");
        }
        previewChannelViewModel.updateAdminRights(previewChannelAdminsParams.getPartner().getId(), previewChannelAdminsParams.getChId(), arrayList, new a() { // from class: w7.b
            @Override // lb.a
            public final Object invoke() {
                return PreviewChannelAdminsScreenKt.PreviewChannelAdminsScreen$lambda$6$21$8$0$0$0(mutableState);
            }
        });
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 PreviewChannelAdminsScreen$lambda$6$21$8$0$0$0(MutableState mutableState) {
        PreviewChannelAdminsScreen$lambda$4(mutableState, false);
        return k0.f43947a;
    }

    private static final boolean PreviewChannelAdminsScreen$lambda$6$4(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void PreviewChannelAdminsScreen$lambda$6$5(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    private static final boolean PreviewChannelAdminsScreen$lambda$6$7(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void PreviewChannelAdminsScreen$lambda$6$8(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 PreviewChannelAdminsScreen$lambda$7(NavHostController navHostController, String str, PreviewChannelViewModel previewChannelViewModel, int i10, int i11, Composer composer, int i12) {
        PreviewChannelAdminsScreen(navHostController, str, previewChannelViewModel, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return k0.f43947a;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void RightItem(final boolean z10, final Function1 onChange, final String title, final String description, Composer composer, final int i10) {
        boolean z11;
        int i11;
        y.i(onChange, "onChange");
        y.i(title, "title");
        y.i(description, "description");
        Composer composerStartRestartGroup = composer.startRestartGroup(-872088565);
        if ((i10 & 6) == 0) {
            z11 = z10;
            i11 = (composerStartRestartGroup.changed(z11) ? 4 : 2) | i10;
        } else {
            z11 = z10;
            i11 = i10;
        }
        if ((i10 & 48) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(onChange) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i11 |= composerStartRestartGroup.changed(title) ? 256 : 128;
        }
        if ((i10 & 3072) == 0) {
            i11 |= composerStartRestartGroup.changed(description) ? 2048 : 1024;
        }
        int i12 = i11;
        if (composerStartRestartGroup.shouldExecute((i12 & 1171) != 1170, i12 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-872088565, i12, -1, "cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel.adminRights.RightItem (PreviewChannelAdminsScreen.kt:388)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            Modifier modifierM1727paddingVpY3zN4$default = PaddingKt.m1727paddingVpY3zN4$default(companion, 0.0f, Dp.m8823constructorimpl(8), 1, null);
            Alignment.Companion companion2 = Alignment.INSTANCE;
            Alignment.Vertical centerVertically = companion2.getCenterVertically();
            Arrangement arrangement = Arrangement.INSTANCE;
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getStart(), centerVertically, composerStartRestartGroup, 48);
            int iA = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1727paddingVpY3zN4$default);
            ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
            a constructor = companion3.getConstructor();
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
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyRowMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion3.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl, companion3.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion3.getSetModifier());
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            Z17CheckKt.Z17Check(null, z11, onChange, composerStartRestartGroup, (i12 << 3) & 1008, 1);
            SpacerKt.Spacer(SizeKt.m1774width3ABfNKs(companion, Dp.m8823constructorimpl(10)), composerStartRestartGroup, 6);
            Modifier modifierA = e3.a(rowScopeInstance, companion, 1.0f, false, 2, null);
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(arrangement.getTop(), companion2.getStart(), composerStartRestartGroup, 0);
            int iA2 = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierA);
            a constructor2 = companion3.getConstructor();
            if (!r.a(composerStartRestartGroup.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor2);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM5176constructorimpl2 = Updater.m5176constructorimpl(composerStartRestartGroup);
            Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyColumnMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl2, Integer.valueOf(iA2), companion3.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl2, companion3.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier2, companion3.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            MaterialTheme materialTheme = MaterialTheme.INSTANCE;
            int i13 = MaterialTheme.$stable;
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, title, materialTheme.getTypography(composerStartRestartGroup, i13).getBodyLarge(), 0L, 0, 0, composerStartRestartGroup, (i12 >> 3) & 112, 57);
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, description, materialTheme.getTypography(composerStartRestartGroup, i13).getBodySmall(), 0L, 0, 0, composerStartRestartGroup, (i12 >> 6) & 112, 57);
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: w7.g
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PreviewChannelAdminsScreenKt.RightItem$lambda$1(z10, onChange, title, description, i10, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 RightItem$lambda$1(boolean z10, Function1 function1, String str, String str2, int i10, Composer composer, int i11) {
        RightItem(z10, function1, str, str2, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1));
        return k0.f43947a;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void SubscriberCard(String str, String str2, Composer composer, final int i10) {
        int i11;
        final String name = str;
        final String image = str2;
        y.i(name, "name");
        y.i(image, "image");
        Composer composerStartRestartGroup = composer.startRestartGroup(1812702407);
        if ((i10 & 6) == 0) {
            i11 = i10 | (composerStartRestartGroup.changed(name) ? 4 : 2);
        } else {
            i11 = i10;
        }
        if ((i10 & 48) == 0) {
            i11 |= composerStartRestartGroup.changed(image) ? 32 : 16;
        }
        if (composerStartRestartGroup.shouldExecute((i11 & 19) != 18, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1812702407, i11, -1, "cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel.adminRights.SubscriberCard (PreviewChannelAdminsScreen.kt:322)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            float f10 = 10;
            float f11 = 15;
            Modifier modifierM5480shadows4CzXII$default = ShadowKt.m5480shadows4CzXII$default(PaddingKt.m1727paddingVpY3zN4$default(companion, 0.0f, Dp.m8823constructorimpl(f10), 1, null), Dp.m8823constructorimpl(3), RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(f11)), false, 0L, 0L, 28, null);
            Other other = Other.INSTANCE;
            Modifier modifierM1204backgroundbw27NRU = BackgroundKt.m1204backgroundbw27NRU(modifierM5480shadows4CzXII$default, other.m10111getGreen0d7_KjU(), RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(f11)));
            Arrangement arrangement = Arrangement.INSTANCE;
            Arrangement.Vertical top = arrangement.getTop();
            Alignment.Companion companion2 = Alignment.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(top, companion2.getStart(), composerStartRestartGroup, 0);
            int iA = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1204backgroundbw27NRU);
            ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
            a constructor = companion3.getConstructor();
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
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyColumnMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion3.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl, companion3.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion3.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion2.getCenter(), false);
            int iA2 = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
            a constructor2 = companion3.getConstructor();
            if (!r.a(composerStartRestartGroup.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor2);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM5176constructorimpl2 = Updater.m5176constructorimpl(composerStartRestartGroup);
            Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl2, Integer.valueOf(iA2), companion3.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl2, companion3.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier2, companion3.getSetModifier());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            Modifier modifierM1755height3ABfNKs = SizeKt.m1755height3ABfNKs(SizeKt.fillMaxWidth$default(PaddingKt.m1727paddingVpY3zN4$default(companion, 0.0f, Dp.m8823constructorimpl(20), 1, null), 0.0f, 1, null), Dp.m8823constructorimpl(f10));
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: w7.d
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return PreviewChannelAdminsScreenKt.SubscriberCard$lambda$0$0$0$0((DrawScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            CanvasKt.Canvas(modifierM1755height3ABfNKs, (Function1) objRememberedValue, composerStartRestartGroup, 54);
            composerStartRestartGroup.endNode();
            Modifier modifierM1729paddingqDBjuR0$default = PaddingKt.m1729paddingqDBjuR0$default(companion, 0.0f, 0.0f, 0.0f, Dp.m8823constructorimpl(f10), 7, null);
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getStart(), companion2.getCenterVertically(), composerStartRestartGroup, 48);
            int iA3 = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1729paddingqDBjuR0$default);
            a constructor3 = companion3.getConstructor();
            if (!r.a(composerStartRestartGroup.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor3);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM5176constructorimpl3 = Updater.m5176constructorimpl(composerStartRestartGroup);
            Updater.m5184setimpl(composerM5176constructorimpl3, measurePolicyRowMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl3, currentCompositionLocalMap3, companion3.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl3, Integer.valueOf(iA3), companion3.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl3, companion3.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl3, modifierMaterializeModifier3, companion3.getSetModifier());
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            Z17PictureAvatarKt.m10277Z17PictureAvatarajT4Zlk(SizeKt.m1769size3ABfNKs(PaddingKt.m1727paddingVpY3zN4$default(companion, Dp.m8823constructorimpl(f10), 0.0f, 2, null), Dp.m8823constructorimpl(40)), str2, Color.m5856boximpl(ColorKt.Color(ColorGenerator.INSTANCE.getMATERIAL().getColor(name))), null, "", 0, 50, false, null, name, true, 0, composerStartRestartGroup, ((i11 << 27) & C.ENCODING_PCM_DOUBLE) | (i11 & 112) | 1597446, 6, 2472);
            name = str;
            Z17LabelKt.m10262Z17LabelfWhpE4E(e3.a(rowScopeInstance, companion, 1.0f, false, 2, null), name, TextStyle.m8271copyp1EtxEg$default(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyLarge(), 0L, 0L, FontWeight.INSTANCE.getSemiBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777211, null), 0L, 1, 0, composerStartRestartGroup, ((i11 << 3) & 112) | 24576, 40);
            image = str2;
            Z17PictureKt.m10278Z17BasePictureC8z9wKI(AlphaKt.alpha(SizeKt.m1769size3ABfNKs(PaddingKt.m1727paddingVpY3zN4$default(companion, Dp.m8823constructorimpl(f10), 0.0f, 2, null), Dp.m8823constructorimpl(50)), 0.2f), Integer.valueOf(R.drawable.icon), null, ColorFilter.Companion.m5907tintxETnrds$default(ColorFilter.INSTANCE, Z17InlineUtilsKt.m10309lighterDxMtmZc(other.m10111getGreen0d7_KjU(), 0.6f), 0, 2, null), null, null, 0, null, null, composerStartRestartGroup, 6, XMPPTCPConnection.PacketWriter.QUEUE_SIZE);
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: w7.e
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PreviewChannelAdminsScreenKt.SubscriberCard$lambda$1(name, image, i10, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 SubscriberCard$lambda$0$0$0$0(DrawScope Canvas) {
        y.i(Canvas, "$this$Canvas");
        DrawScope.CC.M(Canvas, Z17InlineUtilsKt.m10307darkerDxMtmZc(Other.INSTANCE.m10111getGreen0d7_KjU(), 0.2f), 0L, 0L, 0.0f, null, null, 0, 126, null);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 SubscriberCard$lambda$1(String str, String str2, int i10, Composer composer, int i11) {
        SubscriberCard(str, str2, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1));
        return k0.f43947a;
    }
}
