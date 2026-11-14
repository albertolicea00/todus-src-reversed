package cu.todus.android.uiCompose.main.screen.nearPeople;

import android.content.Context;
import androidx.camera.video.AudioStats;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.LazyListStateKt;
import androidx.compose.material.ScaffoldKt;
import androidx.compose.material.ScaffoldState;
import androidx.compose.material3.IconButtonKt;
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
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.navigation.NavHostController;
import androidx.navigation.NavOptionsBuilder;
import androidx.p001lifecycle.HasDefaultViewModelProviderFactory;
import androidx.p001lifecycle.Lifecycle;
import androidx.p001lifecycle.LifecycleOwner;
import androidx.p001lifecycle.ViewModelProvider;
import androidx.p001lifecycle.ViewModelStoreOwner;
import androidx.p001lifecycle.p002compose.FlowExtKt;
import androidx.p001lifecycle.viewmodel.CreationExtras;
import androidx.p001lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.p001lifecycle.viewmodel.compose.ViewModelKt;
import androidx.paging.compose.LazyPagingItems;
import androidx.paging.compose.LazyPagingItemsKt;
import cu.todus.android.R;
import cu.todus.android.data.db.pojo.NearPartner;
import cu.todus.android.data.wrapper.FlowsState;
import cu.todus.android.data.wrapper.Status;
import cu.todus.android.uiCompose.main.screen.chat.component.ChatParams;
import cu.todus.android.uiCompose.navigation.NavLinks;
import cu.todus.android.uiCompose.shared.userCommonList.UserCommonListKt;
import cu.z17.views.loader.Z17SimpleCircleLoaderKt;
import cu.z17.views.permission.PermissionNeedIt;
import cu.z17.views.permission.Z17PermissionRequesterKt;
import cu.z17.views.picture.Z17PictureKt;
import cu.z17.views.scaffold.Z17ScaffoldKt;
import cu.z17.views.textToggle.Z17TextToggleKt;
import cu.z17.views.topBar.Z17TopBarKt;
import defpackage.r;
import java.text.DecimalFormat;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.y;
import kotlin.jvm.internal.z0;
import ua.k0;
import va.v;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a!\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000b\u001aA\u0010\u0013\u001a\u00020\u00042\u000e\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\f2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00040\u000f2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u0011H\u0007¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0017²\u0006\u000e\u0010\u0015\u001a\u00020\r8\n@\nX\u008a\u008e\u0002²\u0006\u0012\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\r0\f8\nX\u008a\u0084\u0002"}, d2 = {"Landroidx/navigation/NavHostController;", "navHostController", "Lcu/todus/android/uiCompose/main/screen/nearPeople/NearPeopleViewModel;", "viewModel", "Lua/k0;", "NearPeopleScreen", "(Landroidx/navigation/NavHostController;Lcu/todus/android/uiCompose/main/screen/nearPeople/NearPeopleViewModel;Landroidx/compose/runtime/Composer;II)V", "", "distance", "", "distanceText", "(D)Ljava/lang/String;", "Lcu/todus/android/data/wrapper/FlowsState;", "", "locationActive", "Lkotlin/Function1;", "locationChange", "Lkotlin/Function0;", "refresh", "NearPeopleHeader", "(Lcu/todus/android/data/wrapper/FlowsState;Lkotlin/jvm/functions/Function1;Llb/a;Landroidx/compose/runtime/Composer;I)V", "permissionsGranted", "nearActive", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class NearPeopleScreenKt {

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Status.values().length];
            try {
                iArr[Status.LOADING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Status.SUCCESS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void NearPeopleHeader(final FlowsState<Boolean> locationActive, final Function1 locationChange, final lb.a refresh, Composer composer, final int i10) {
        int i11;
        y.i(locationActive, "locationActive");
        y.i(locationChange, "locationChange");
        y.i(refresh, "refresh");
        Composer composerStartRestartGroup = composer.startRestartGroup(1232418426);
        if ((i10 & 6) == 0) {
            i11 = ((i10 & 8) == 0 ? composerStartRestartGroup.changed(locationActive) : composerStartRestartGroup.changedInstance(locationActive) ? 4 : 2) | i10;
        } else {
            i11 = i10;
        }
        if ((i10 & 48) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(locationChange) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(refresh) ? 256 : 128;
        }
        if (composerStartRestartGroup.shouldExecute((i11 & 147) != 146, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1232418426, i11, -1, "cu.todus.android.uiCompose.main.screen.nearPeople.NearPeopleHeader (NearPeopleScreen.kt:143)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null);
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getCenterHorizontally(), composerStartRestartGroup, 48);
            int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxWidth$default);
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
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyColumnMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion2.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl, companion2.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion2.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            int i12 = i11;
            Z17PictureKt.m10278Z17BasePictureC8z9wKI(SizeKt.fillMaxWidth$default(SizeKt.m1755height3ABfNKs(companion, Dp.m8823constructorimpl(200)), 0.0f, 1, null), Integer.valueOf(R.drawable.near_people_banner), null, null, null, null, 0, null, null, composerStartRestartGroup, 6, TypedValues.PositionType.TYPE_CURVE_FIT);
            composerStartRestartGroup = composerStartRestartGroup;
            int i13 = WhenMappings.$EnumSwitchMapping$0[locationActive.getStatus().ordinal()];
            if (i13 == 1) {
                composerStartRestartGroup.startReplaceGroup(-771848325);
                Z17SimpleCircleLoaderKt.m10265Z17SimpleCircleLoaderZij2fk(null, 0.0f, 0.0f, 0L, composerStartRestartGroup, 0, 15);
                composerStartRestartGroup = composerStartRestartGroup;
                composerStartRestartGroup.endReplaceGroup();
            } else if (i13 != 2) {
                composerStartRestartGroup.startReplaceGroup(-770949759);
                boolean z10 = (i12 & 896) == 256;
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (z10 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.nearPeople.i
                        @Override // lb.a
                        public final Object invoke() {
                            return NearPeopleScreenKt.NearPeopleHeader$lambda$0$1$0(refresh);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                IconButtonKt.IconButton((lb.a) objRememberedValue, null, false, null, null, null, ComposableSingletons$NearPeopleScreenKt.INSTANCE.getLambda$242181455$app_productionPFast(), composerStartRestartGroup, 1572864, 62);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-771739453);
                Modifier modifierM1725padding3ABfNKs = PaddingKt.m1725padding3ABfNKs(companion, Dp.m8823constructorimpl(20));
                Boolean data = locationActive.getData();
                boolean zBooleanValue = data != null ? data.booleanValue() : false;
                boolean z11 = (i12 & 112) == 32;
                Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (z11 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.nearPeople.h
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return NearPeopleScreenKt.NearPeopleHeader$lambda$0$0$0(locationChange, ((Boolean) obj).booleanValue());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                Z17TextToggleKt.Z17TextToggle(modifierM1725padding3ABfNKs, zBooleanValue, (Function1) objRememberedValue2, ComposableSingletons$NearPeopleScreenKt.INSTANCE.getLambda$751352676$app_productionPFast(), StringResources_androidKt.stringResource(R.string.sharing_real_time_location, composerStartRestartGroup, 0), null, null, composerStartRestartGroup, 3078, 96);
                composerStartRestartGroup.endReplaceGroup();
            }
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.nearPeople.j
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NearPeopleScreenKt.NearPeopleHeader$lambda$1(locationActive, locationChange, refresh, i10, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 NearPeopleHeader$lambda$0$0$0(Function1 function1, boolean z10) {
        function1.invoke(Boolean.valueOf(z10));
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 NearPeopleHeader$lambda$0$1$0(lb.a aVar) {
        aVar.invoke();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 NearPeopleHeader$lambda$1(FlowsState flowsState, Function1 function1, lb.a aVar, int i10, Composer composer, int i11) {
        NearPeopleHeader(flowsState, function1, aVar, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1));
        return k0.f43947a;
    }

    /* JADX WARN: Code duplicated, block: B:51:0x00af  */
    /* JADX WARN: Code duplicated, block: B:54:0x00f7  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void NearPeopleScreen(final NavHostController navHostController, NearPeopleViewModel nearPeopleViewModel, Composer composer, final int i10, final int i11) {
        int i12;
        NearPeopleViewModel nearPeopleViewModel2;
        final NearPeopleViewModel nearPeopleViewModel3;
        final NearPeopleViewModel nearPeopleViewModel4;
        y.i(navHostController, "navHostController");
        Composer composerStartRestartGroup = composer.startRestartGroup(-2136625072);
        if ((i10 & 6) == 0) {
            i12 = (composerStartRestartGroup.changedInstance(navHostController) ? 4 : 2) | i10;
        } else {
            i12 = i10;
        }
        if ((i10 & 48) == 0) {
            if ((i11 & 2) == 0) {
                nearPeopleViewModel2 = nearPeopleViewModel;
                int i13 = composerStartRestartGroup.changedInstance(nearPeopleViewModel2) ? 32 : 16;
                i12 |= i13;
            } else {
                nearPeopleViewModel2 = nearPeopleViewModel;
            }
            i12 |= i13;
        } else {
            nearPeopleViewModel2 = nearPeopleViewModel;
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
                    nearPeopleViewModel4 = (NearPeopleViewModel) ViewModelKt.viewModel(z0.b(NearPeopleViewModel.class), current, (String) null, (ViewModelProvider.Factory) null, current instanceof HasDefaultViewModelProviderFactory ? ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras() : CreationExtras.Empty.INSTANCE, composerStartRestartGroup, 0, 0);
                    i14 &= -113;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2136625072, i14, -1, "cu.todus.android.uiCompose.main.screen.nearPeople.NearPeopleScreen (NearPeopleScreen.kt:54)");
                }
                ScaffoldState scaffoldStateRememberScaffoldState = ScaffoldKt.rememberScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                final Context context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1414627452, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.nearPeople.o
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return NearPeopleScreenKt.NearPeopleScreen$lambda$0(navHostController, (TopAppBarScrollBehavior) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54);
                ComposableLambda composableLambdaRememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(1867437190, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.nearPeople.e
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return NearPeopleScreenKt.NearPeopleScreen$lambda$1(nearPeopleViewModel4, navHostController, context, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54);
                nearPeopleViewModel3 = nearPeopleViewModel4;
                Z17ScaffoldKt.m10301Z17BaseScaffoldueL0Wzs(composableLambdaRememberComposableLambda, false, false, false, null, null, 0L, scaffoldStateRememberScaffoldState, null, composableLambdaRememberComposableLambda2, composerStartRestartGroup, 805306806, 376);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i11 & 2) != 0) {
                    i14 &= -113;
                }
            }
            nearPeopleViewModel4 = nearPeopleViewModel2;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2136625072, i14, -1, "cu.todus.android.uiCompose.main.screen.nearPeople.NearPeopleScreen (NearPeopleScreen.kt:54)");
            }
            ScaffoldState scaffoldStateRememberScaffoldState2 = ScaffoldKt.rememberScaffoldState(null, null, composerStartRestartGroup, 0, 3);
            final Context context2 = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
            ComposableLambda composableLambdaRememberComposableLambda3 = ComposableLambdaKt.rememberComposableLambda(-1414627452, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.nearPeople.o
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return NearPeopleScreenKt.NearPeopleScreen$lambda$0(navHostController, (TopAppBarScrollBehavior) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54);
            ComposableLambda composableLambdaRememberComposableLambda4 = ComposableLambdaKt.rememberComposableLambda(1867437190, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.nearPeople.e
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return NearPeopleScreenKt.NearPeopleScreen$lambda$1(nearPeopleViewModel4, navHostController, context2, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54);
            nearPeopleViewModel3 = nearPeopleViewModel4;
            Z17ScaffoldKt.m10301Z17BaseScaffoldueL0Wzs(composableLambdaRememberComposableLambda3, false, false, false, null, null, 0L, scaffoldStateRememberScaffoldState2, null, composableLambdaRememberComposableLambda4, composerStartRestartGroup, 805306806, 376);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            nearPeopleViewModel3 = nearPeopleViewModel2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.nearPeople.f
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NearPeopleScreenKt.NearPeopleScreen$lambda$2(navHostController, nearPeopleViewModel3, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 NearPeopleScreen$lambda$0(NavHostController navHostController, TopAppBarScrollBehavior it, Composer composer, int i10) {
        y.i(it, "it");
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1414627452, i10, -1, "cu.todus.android.uiCompose.main.screen.nearPeople.NearPeopleScreen.<anonymous> (NearPeopleScreen.kt:64)");
            }
            Z17TopBarKt.m10304Z17TopBardW2gCk(ComposableSingletons$NearPeopleScreenKt.INSTANCE.m9946getLambda$308055151$app_productionPFast(), null, false, null, false, navHostController, null, null, 0L, 0L, 0.0f, composer, 6, 0, 2014);
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
    public static final k0 NearPeopleScreen$lambda$1(final NearPeopleViewModel nearPeopleViewModel, final NavHostController navHostController, final Context context, Modifier it, Composer composer, int i10) {
        int i11;
        y.i(it, "it");
        if ((i10 & 6) == 0) {
            i11 = i10 | (composer.changed(it) ? 4 : 2);
        } else {
            i11 = i10;
        }
        if (composer.shouldExecute((i11 & 19) != 18, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1867437190, i11, -1, "cu.todus.android.uiCompose.main.screen.nearPeople.NearPeopleScreen.<anonymous> (NearPeopleScreen.kt:75)");
            }
            Object objRememberedValue = composer.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                composer.updateRememberedValue(objRememberedValue);
            }
            final MutableState mutableState = (MutableState) objRememberedValue;
            LazyListState lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composer, 0, 3);
            LazyPagingItems lazyPagingItemsCollectAsLazyPagingItems = LazyPagingItemsKt.collectAsLazyPagingItems(nearPeopleViewModel.getNearPeople(), null, composer, 0, 1);
            final State stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(nearPeopleViewModel.getNearActive(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composer, 0, 7);
            Modifier modifierFillMaxHeight$default = SizeKt.fillMaxHeight$default(it, 0.0f, 1, null);
            String nameWithDomain = nearPeopleViewModel.owner().getNameWithDomain();
            boolean zChangedInstance = composer.changedInstance(navHostController);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.nearPeople.k
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return NearPeopleScreenKt.NearPeopleScreen$lambda$1$4$0(navHostController, (NearPartner) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            Function1 function1 = (Function1) objRememberedValue2;
            Object objRememberedValue3 = composer.rememberedValue();
            if (objRememberedValue3 == companion.getEmpty()) {
                objRememberedValue3 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.nearPeople.l
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return NearPeopleScreenKt.NearPeopleScreen$lambda$1$5$0((NearPartner) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue3);
            }
            Function1 function2 = (Function1) objRememberedValue3;
            ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(176670700, true, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.nearPeople.m
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NearPeopleScreenKt.NearPeopleScreen$lambda$1$6(nearPeopleViewModel, context, mutableState, stateCollectAsStateWithLifecycle, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54);
            Object objRememberedValue4 = composer.rememberedValue();
            if (objRememberedValue4 == companion.getEmpty()) {
                objRememberedValue4 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.nearPeople.n
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return NearPeopleScreenKt.NearPeopleScreen$lambda$1$7$0((NearPartner) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue4);
            }
            UserCommonListKt.UserCommonList(modifierFillMaxHeight$default, lazyListStateRememberLazyListState, lazyPagingItemsCollectAsLazyPagingItems, function1, function2, composableLambdaRememberComposableLambda, nameWithDomain, (Function1) objRememberedValue4, null, composer, (LazyPagingItems.$stable << 6) | 12804096, 256);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    private static final boolean NearPeopleScreen$lambda$1$1(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void NearPeopleScreen$lambda$1$2(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    private static final FlowsState<Boolean> NearPeopleScreen$lambda$1$3(State<FlowsState<Boolean>> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 NearPeopleScreen$lambda$1$4$0(NavHostController navHostController, NearPartner userCommon) {
        y.i(userCommon, "userCommon");
        ChatParams chatParams = new ChatParams(userCommon.getId(), 0, null, 0, 12, null);
        NavLinks navLinks = NavLinks.INSTANCE;
        int type = chatParams.getType();
        String strT = new v5.f().t(chatParams);
        y.h(strT, "toJson(...)");
        navHostController.navigate(navLinks.goChat(type, strT), new Function1() { // from class: cu.todus.android.uiCompose.main.screen.nearPeople.d
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return NearPeopleScreenKt.NearPeopleScreen$lambda$1$4$0$0((NavOptionsBuilder) obj);
            }
        });
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 NearPeopleScreen$lambda$1$4$0$0(NavOptionsBuilder navigate) {
        y.i(navigate, "$this$navigate");
        NavOptionsBuilder.popUpTo$default(navigate, NavLinks.HOME, (Function1) null, 2, (Object) null);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 NearPeopleScreen$lambda$1$5$0(NearPartner it) {
        y.i(it, "it");
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 NearPeopleScreen$lambda$1$6(NearPeopleViewModel nearPeopleViewModel, Context context, final MutableState mutableState, State state, Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(176670700, i10, -1, "cu.todus.android.uiCompose.main.screen.nearPeople.NearPeopleScreen.<anonymous>.<anonymous> (NearPeopleScreen.kt:109)");
            }
            if (NearPeopleScreen$lambda$1$1(mutableState)) {
                composer.startReplaceGroup(-2018146935);
                FlowsState<Boolean> flowsStateNearPeopleScreen$lambda$1$3 = NearPeopleScreen$lambda$1$3(state);
                boolean zChangedInstance = composer.changedInstance(nearPeopleViewModel);
                Object objRememberedValue = composer.rememberedValue();
                if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new NearPeopleScreenKt$NearPeopleScreen$2$3$1$1(nearPeopleViewModel);
                    composer.updateRememberedValue(objRememberedValue);
                }
                Function1 function1 = (Function1) ((sb.h) objRememberedValue);
                boolean zChangedInstance2 = composer.changedInstance(nearPeopleViewModel);
                Object objRememberedValue2 = composer.rememberedValue();
                if (zChangedInstance2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new NearPeopleScreenKt$NearPeopleScreen$2$3$2$1(nearPeopleViewModel);
                    composer.updateRememberedValue(objRememberedValue2);
                }
                NearPeopleHeader(flowsStateNearPeopleScreen$lambda$1$3, function1, (lb.a) ((sb.h) objRememberedValue2), composer, FlowsState.$stable);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(1862166838);
                composer.endReplaceGroup();
            }
            List listE = v.e(PermissionNeedIt.LOCATION);
            Object objRememberedValue3 = composer.rememberedValue();
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.nearPeople.g
                    @Override // lb.a
                    public final Object invoke() {
                        return NearPeopleScreenKt.NearPeopleScreen$lambda$1$6$2$0(mutableState);
                    }
                };
                composer.updateRememberedValue(objRememberedValue3);
            }
            String packageName = context.getPackageName();
            y.h(packageName, "getPackageName(...)");
            Z17PermissionRequesterKt.Z17PermissionCheckerAndRequester(null, null, listE, (lb.a) objRememberedValue3, null, packageName, null, composer, 3456, 83);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 NearPeopleScreen$lambda$1$6$2$0(MutableState mutableState) {
        NearPeopleScreen$lambda$1$2(mutableState, true);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String NearPeopleScreen$lambda$1$7$0(NearPartner nearPartner) {
        return distanceText(nearPartner != null ? nearPartner.getDistance() : AudioStats.AUDIO_AMPLITUDE_NONE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 NearPeopleScreen$lambda$2(NavHostController navHostController, NearPeopleViewModel nearPeopleViewModel, int i10, int i11, Composer composer, int i12) {
        NearPeopleScreen(navHostController, nearPeopleViewModel, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return k0.f43947a;
    }

    private static final String distanceText(double d10) {
        if (d10 <= 1000.0d) {
            return ((int) d10) + " m ";
        }
        return new DecimalFormat("#.##").format(d10 / 1000.0d) + " km ";
    }
}
