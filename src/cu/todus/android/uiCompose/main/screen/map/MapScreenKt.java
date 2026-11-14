package cu.todus.android.uiCompose.main.screen.map;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import androidx.camera.video.AudioStats;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.outlined.LocationOnKt;
import androidx.compose.material.icons.outlined.MyLocationKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import androidx.exifinterface.media.ExifInterface;
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
import cu.todus.android.R;
import cu.todus.android.location.LocationDataSource;
import cu.todus.android.uiCompose.main.screen.chat.component.ChatParams;
import cu.todus.android.uiCompose.shared.contrastToolbar.ContrastToolbarKt;
import cu.z17.views.floatingMutilple.Z17MultipleFabObj;
import cu.z17.views.floatingMutilple.Z17MultipleFabViewKt;
import cu.z17.views.label.Z17LabelKt;
import cu.z17.views.map.Z17MapMarker;
import cu.z17.views.map.Z17MapViewKt;
import cu.z17.views.permission.PermissionNeedIt;
import cu.z17.views.permission.Z17PermissionRequesterKt;
import defpackage.l;
import defpackage.r;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.y;
import kotlin.jvm.internal.z0;
import ua.k0;
import va.g0;
import va.v;
import va.w;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a)\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\r²\u0006\u000e\u0010\n\u001a\u00020\t8\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\f\u001a\u0004\u0018\u00010\u000b8\nX\u008a\u0084\u0002"}, d2 = {"Landroidx/navigation/NavHostController;", "navHostController", "", "params", "Lcu/todus/android/uiCompose/main/screen/map/MapViewModel;", "viewModel", "Lua/k0;", "MapScreen", "(Landroidx/navigation/NavHostController;Ljava/lang/String;Lcu/todus/android/uiCompose/main/screen/map/MapViewModel;Landroidx/compose/runtime/Composer;II)V", "", "permissionsGranted", "Landroid/location/Location;", "userMapLocation", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class MapScreenKt {
    /* JADX WARN: Code duplicated, block: B:100:0x02f0  */
    /* JADX WARN: Code duplicated, block: B:103:0x02fc  */
    /* JADX WARN: Code duplicated, block: B:104:0x0300  */
    /* JADX WARN: Code duplicated, block: B:109:0x0342  */
    /* JADX WARN: Code duplicated, block: B:112:0x0358  */
    /* JADX WARN: Code duplicated, block: B:114:0x036e  */
    /* JADX WARN: Code duplicated, block: B:116:0x039d  */
    /* JADX WARN: Code duplicated, block: B:119:0x03ae  */
    /* JADX WARN: Code duplicated, block: B:120:0x0454  */
    /* JADX WARN: Code duplicated, block: B:128:0x04a3  */
    /* JADX WARN: Code duplicated, block: B:131:0x04b5  */
    /* JADX WARN: Code duplicated, block: B:27:0x0056  */
    /* JADX WARN: Code duplicated, block: B:57:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:60:0x0116  */
    /* JADX WARN: Code duplicated, block: B:63:0x0122  */
    /* JADX WARN: Code duplicated, block: B:64:0x0126  */
    /* JADX WARN: Code duplicated, block: B:67:0x016e  */
    /* JADX WARN: Code duplicated, block: B:70:0x018a  */
    /* JADX WARN: Code duplicated, block: B:73:0x01be  */
    /* JADX WARN: Code duplicated, block: B:76:0x01d6  */
    /* JADX WARN: Code duplicated, block: B:79:0x01f0  */
    /* JADX WARN: Code duplicated, block: B:82:0x0216  */
    /* JADX WARN: Code duplicated, block: B:83:0x0233  */
    /* JADX WARN: Code duplicated, block: B:86:0x0252  */
    /* JADX WARN: Code duplicated, block: B:87:0x0255  */
    /* JADX WARN: Code duplicated, block: B:94:0x027c  */
    /* JADX WARN: Code duplicated, block: B:97:0x0289  */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    @SuppressLint({"MissingPermission", "MutableCollectionMutableState"})
    public static final void MapScreen(final NavHostController navHostController, final String params, MapViewModel mapViewModel, Composer composer, final int i10, final int i11) {
        int i12;
        final MapViewModel mapViewModel2;
        Composer composer2;
        Composer composer3;
        Modifier.Companion companion;
        MaterialTheme materialTheme;
        int i13;
        lb.a constructor;
        Context context;
        Object objRememberedValue;
        Composer.Companion companion2;
        final MapParams mapParams;
        Object objRememberedValue2;
        final MutableState mutableState;
        final State stateCollectAsStateWithLifecycle;
        Object objRememberedValue3;
        State state;
        Object objRememberedValue4;
        Object obj;
        final SnapshotStateList snapshotStateList;
        Object objRememberedValue5;
        final State state2;
        final String strStringResource;
        final String strStringResource2;
        Object objRememberedValue6;
        MapViewModel mapViewModel3;
        final State state3;
        State state4;
        final MapViewModel mapViewModel4;
        MapMotive motive;
        MapMotive mapMotive;
        boolean z10;
        String id2;
        Object objRememberedValue7;
        Composer composer4;
        lb.a constructor2;
        boolean zChangedInstance;
        Object objRememberedValue8;
        int i14;
        Modifier.Companion companion3;
        Composer composer5;
        Composer composer6;
        Composer composer7;
        Object objRememberedValue9;
        int i15;
        final NavHostController navHostController2 = navHostController;
        MapViewModel mapViewModel5 = mapViewModel;
        y.i(navHostController2, "navHostController");
        y.i(params, "params");
        Composer composerStartRestartGroup = composer.startRestartGroup(882435297);
        if ((i10 & 6) == 0) {
            i12 = (composerStartRestartGroup.changedInstance(navHostController2) ? 4 : 2) | i10;
        } else {
            i12 = i10;
        }
        if ((i10 & 48) == 0) {
            i12 |= composerStartRestartGroup.changed(params) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            if ((i11 & 4) != 0) {
                i15 = 128;
            } else {
                if ((i10 & 512) == 0 ? composerStartRestartGroup.changed(mapViewModel5) : composerStartRestartGroup.changedInstance(mapViewModel5)) {
                    i15 = 256;
                } else {
                    i15 = 128;
                }
            }
            i12 |= i15;
        }
        if (composerStartRestartGroup.shouldExecute((i12 & 147) != 146, i12 & 1)) {
            composerStartRestartGroup.startDefaults();
            if ((i10 & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                if ((i11 & 4) != 0) {
                    ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composerStartRestartGroup, 6);
                    if (current == null) {
                        throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                    }
                    ViewModel viewModel = ViewModelKt.viewModel(z0.b(MapViewModel.class), current, (String) null, (ViewModelProvider.Factory) null, current instanceof HasDefaultViewModelProviderFactory ? ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras() : CreationExtras.Empty.INSTANCE, composerStartRestartGroup, 0, 0);
                    composer3 = composerStartRestartGroup;
                    mapViewModel5 = (MapViewModel) viewModel;
                    i12 &= -897;
                }
                composer3.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(882435297, i12, -1, "cu.todus.android.uiCompose.main.screen.map.MapScreen (MapScreen.kt:47)");
                }
                companion = Modifier.INSTANCE;
                materialTheme = MaterialTheme.INSTANCE;
                i13 = MaterialTheme.$stable;
                Modifier modifierM1205backgroundbw27NRU$default = BackgroundKt.m1205backgroundbw27NRU$default(companion, materialTheme.getColorScheme(composer3, i13).getBackground(), null, 2, null);
                Alignment.Companion companion4 = Alignment.INSTANCE;
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion4.getTopStart(), r11);
                int iA = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer3, r11));
                CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer3, modifierM1205backgroundbw27NRU$default);
                ComposeUiNode.Companion companion5 = ComposeUiNode.INSTANCE;
                constructor = companion5.getConstructor();
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
                Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, companion5.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion5.getSetResolvedCompositionLocals());
                Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion5.getSetCompositeKeyHash());
                Updater.m5182reconcileimpl(composerM5176constructorimpl, companion5.getApplyOnDeactivatedNodeAssertion());
                Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion5.getSetModifier());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                context = (Context) composer3.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                objRememberedValue = composer3.rememberedValue();
                companion2 = Composer.INSTANCE;
                if (objRememberedValue == companion2.getEmpty()) {
                    objRememberedValue = (MapParams) mapViewModel5.getGson().j(params, MapParams.class);
                    composer3.updateRememberedValue(objRememberedValue);
                }
                mapParams = (MapParams) objRememberedValue;
                objRememberedValue2 = composer3.rememberedValue();
                if (objRememberedValue2 == companion2.getEmpty()) {
                    objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                    composer3.updateRememberedValue(objRememberedValue2);
                }
                mutableState = (MutableState) objRememberedValue2;
                stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(LocationDataSource.INSTANCE.getInstance().getCurrentLocationFlow(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composer3, 0, 7);
                objRememberedValue3 = composer3.rememberedValue();
                if (objRememberedValue3 == companion2.getEmpty()) {
                    objRememberedValue3 = SnapshotStateKt.derivedStateOf(new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.map.f
                        @Override // lb.a
                        public final Object invoke() {
                            return MapScreenKt.MapScreen$lambda$0$5$0(stateCollectAsStateWithLifecycle);
                        }
                    });
                    composer3.updateRememberedValue(objRememberedValue3);
                }
                state = (State) objRememberedValue3;
                objRememberedValue4 = composer3.rememberedValue();
                obj = objRememberedValue4;
                if (objRememberedValue4 == companion2.getEmpty()) {
                    SnapshotStateList snapshotStateListMutableStateListOf = SnapshotStateKt.mutableStateListOf();
                    snapshotStateListMutableStateListOf.addAll(mapParams.getMarkers());
                    composer3.updateRememberedValue(snapshotStateListMutableStateListOf);
                    obj = snapshotStateListMutableStateListOf;
                }
                snapshotStateList = (SnapshotStateList) obj;
                objRememberedValue5 = composer3.rememberedValue();
                if (objRememberedValue5 == companion2.getEmpty()) {
                    objRememberedValue5 = SnapshotStateKt.derivedStateOf(new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.map.g
                        @Override // lb.a
                        public final Object invoke() {
                            return MapScreenKt.MapScreen$lambda$0$7$0(snapshotStateList);
                        }
                    });
                    composer3.updateRememberedValue(objRememberedValue5);
                }
                state2 = (State) objRememberedValue5;
                strStringResource = StringResources_androidKt.stringResource(R.string.send_selected_location, composer3, r11);
                strStringResource2 = StringResources_androidKt.stringResource(R.string.send_current_location, composer3, 0);
                objRememberedValue6 = composer3.rememberedValue();
                mapViewModel3 = mapViewModel5;
                if (objRememberedValue6 == companion2.getEmpty()) {
                    state3 = state;
                    mapViewModel4 = mapViewModel3;
                    lb.a aVar = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.map.h
                        @Override // lb.a
                        public final Object invoke() {
                            return MapScreenKt.MapScreen$lambda$0$8$0(state2, state3, strStringResource, strStringResource2, mapViewModel4, mapParams, navHostController2);
                        }
                    };
                    state4 = state2;
                    navHostController2 = navHostController2;
                    objRememberedValue6 = SnapshotStateKt.derivedStateOf(aVar);
                    composer3.updateRememberedValue(objRememberedValue6);
                } else {
                    state3 = state;
                    state4 = state2;
                    mapViewModel4 = mapViewModel3;
                }
                State state5 = (State) objRememberedValue6;
                Z17MapMarker z17MapMarker = (Z17MapMarker) state3.getValue();
                List list = snapshotStateList.toList();
                motive = mapParams.getMotive();
                mapMotive = MapMotive.SELECT;
                if (motive == mapMotive) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                State state6 = state4;
                if (mapParams.getMotive() == MapMotive.SHOW || mapParams.getMarkers().isEmpty()) {
                    id2 = "0";
                } else {
                    id2 = ((Z17MapMarker) g0.w0(mapParams.getMarkers())).getId();
                }
                String str = id2;
                objRememberedValue7 = composer3.rememberedValue();
                if (objRememberedValue7 == companion2.getEmpty()) {
                    objRememberedValue7 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.map.i
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return MapScreenKt.MapScreen$lambda$0$9$0(snapshotStateList, (Z17MapMarker) obj2);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue7);
                }
                Composer composer8 = composer3;
                State state7 = state3;
                Z17MapViewKt.Z17MapView(null, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, z10, str, z17MapMarker, list, (Function1) objRememberedValue7, composer8, (Z17MapMarker.$stable << 18) | 100663296, 15);
                composer4 = composer8;
                Modifier modifierAlign = boxScopeInstance.align(companion, companion4.getTopStart());
                MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), companion4.getStart(), composer4, 0);
                int iA2 = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer4, 0));
                CompositionLocalMap currentCompositionLocalMap2 = composer4.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer4, modifierAlign);
                constructor2 = companion5.getConstructor();
                if (!r.a(composer4.getApplier())) {
                    ComposablesKt.invalidApplier();
                }
                composer4.startReusableNode();
                if (composer4.getInserting()) {
                    composer4.createNode(constructor2);
                } else {
                    composer4.useNode();
                }
                Composer composerM5176constructorimpl2 = Updater.m5176constructorimpl(composer4);
                MapViewModel mapViewModel6 = mapViewModel4;
                Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyColumnMeasurePolicy, companion5.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap2, companion5.getSetResolvedCompositionLocals());
                Updater.m5180initimpl(composerM5176constructorimpl2, Integer.valueOf(iA2), companion5.getSetCompositeKeyHash());
                Updater.m5182reconcileimpl(composerM5176constructorimpl2, companion5.getApplyOnDeactivatedNodeAssertion());
                Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier2, companion5.getSetModifier());
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                zChangedInstance = composer4.changedInstance(navHostController2);
                objRememberedValue8 = composer4.rememberedValue();
                if (zChangedInstance || objRememberedValue8 == companion2.getEmpty()) {
                    objRememberedValue8 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.map.j
                        @Override // lb.a
                        public final Object invoke() {
                            return MapScreenKt.MapScreen$lambda$0$10$0$0(navHostController2);
                        }
                    };
                    composer4.updateRememberedValue(objRememberedValue8);
                }
                ContrastToolbarKt.ContrastToolbar(null, (lb.a) objRememberedValue8, composer4, 0, 1);
                if (MapScreen$lambda$0$2(mutableState)) {
                    i14 = 1;
                    companion3 = companion;
                    composer4.startReplaceGroup(899800613);
                    composer4.endReplaceGroup();
                    composer5 = composer4;
                } else {
                    composer4.startReplaceGroup(-1217909091);
                    List listE = v.e(PermissionNeedIt.LOCATION);
                    objRememberedValue9 = composer4.rememberedValue();
                    if (objRememberedValue9 == companion2.getEmpty()) {
                        objRememberedValue9 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.map.k
                            @Override // lb.a
                            public final Object invoke() {
                                return MapScreenKt.MapScreen$lambda$0$10$1$0(mutableState);
                            }
                        };
                        composer4.updateRememberedValue(objRememberedValue9);
                    }
                    lb.a aVar2 = (lb.a) objRememberedValue9;
                    String packageName = context.getPackageName();
                    y.h(packageName, "getPackageName(...)");
                    companion3 = companion;
                    i14 = 1;
                    Z17PermissionRequesterKt.Z17PermissionCheckerAndRequester(null, null, listE, aVar2, null, packageName, null, composer4, 3456, 83);
                    Composer composer9 = composer4;
                    composer9.endReplaceGroup();
                    composer5 = composer9;
                }
                if (mapParams.getMotive() == mapMotive) {
                    composer5.startReplaceGroup(-1217897262);
                    float f10 = 20;
                    Composer composer10 = composer5;
                    Z17LabelKt.m10262Z17LabelfWhpE4E(PaddingKt.m1725padding3ABfNKs(BackgroundKt.m1204backgroundbw27NRU(PaddingKt.m1725padding3ABfNKs(SizeKt.fillMaxWidth$default(companion3, 0.0f, i14, null), Dp.m8823constructorimpl(f10)), Color.m5865copywmQWz5c$default(materialTheme.getColorScheme(composer5, i13).getOnBackground(), 0.2f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(10))), Dp.m8823constructorimpl(f10)), StringResources_androidKt.stringResource(R.string.for_select_point_distinct_from_current, composer5, 0), TextStyle.m8271copyp1EtxEg$default(materialTheme.getTypography(composer5, i13).getBodyMedium(), 0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, TextAlign.INSTANCE.m8692getCentere0LSkKk(), 0, 0L, null, null, null, 0, 0, null, 16744447, null), 0L, 0, 0, composer10, 0, 56);
                    Composer composer11 = composer10;
                    composer11.endReplaceGroup();
                    composer6 = composer11;
                } else {
                    composer5.startReplaceGroup(900464261);
                    composer5.endReplaceGroup();
                    composer6 = composer5;
                }
                composer6.endNode();
                if (mapParams.getMotive() == mapMotive || (state6.getValue() == null && state7.getValue() == null)) {
                    composer6.startReplaceGroup(96483451);
                    composer6.endReplaceGroup();
                    composer7 = composer6;
                } else {
                    composer6.startReplaceGroup(96303434);
                    Composer composer12 = composer6;
                    Z17MultipleFabViewKt.m10142Z17MultipleViewjA1GFJw((List) state5.getValue(), PaddingKt.m1725padding3ABfNKs(companion3, Dp.m8823constructorimpl(16)), Integer.valueOf(R.drawable.send_icon), 0L, 0L, composer12, 48, 24);
                    Composer composer13 = composer12;
                    composer13.endReplaceGroup();
                    composer7 = composer13;
                }
                composer7.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                mapViewModel2 = mapViewModel6;
                composer2 = composer7;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i11 & 4) != 0) {
                    i12 &= -897;
                }
            }
            composer3 = composerStartRestartGroup;
            composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(882435297, i12, -1, "cu.todus.android.uiCompose.main.screen.map.MapScreen (MapScreen.kt:47)");
            }
            companion = Modifier.INSTANCE;
            materialTheme = MaterialTheme.INSTANCE;
            i13 = MaterialTheme.$stable;
            Modifier modifierM1205backgroundbw27NRU$default2 = BackgroundKt.m1205backgroundbw27NRU$default(companion, materialTheme.getColorScheme(composer3, i13).getBackground(), null, 2, null);
            Alignment.Companion companion6 = Alignment.INSTANCE;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(companion6.getTopStart(), r11);
            int iA3 = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer3, r11));
            CompositionLocalMap currentCompositionLocalMap3 = composer3.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composer3, modifierM1205backgroundbw27NRU$default2);
            ComposeUiNode.Companion companion7 = ComposeUiNode.INSTANCE;
            constructor = companion7.getConstructor();
            if (!r.a(composer3.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composer3.startReusableNode();
            if (composer3.getInserting()) {
                composer3.createNode(constructor);
            } else {
                composer3.useNode();
            }
            Composer composerM5176constructorimpl3 = Updater.m5176constructorimpl(composer3);
            Updater.m5184setimpl(composerM5176constructorimpl3, measurePolicyMaybeCachedBoxMeasurePolicy2, companion7.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl3, currentCompositionLocalMap3, companion7.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl3, Integer.valueOf(iA3), companion7.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl3, companion7.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl3, modifierMaterializeModifier3, companion7.getSetModifier());
            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
            context = (Context) composer3.consume(AndroidCompositionLocals_androidKt.getLocalContext());
            objRememberedValue = composer3.rememberedValue();
            companion2 = Composer.INSTANCE;
            if (objRememberedValue == companion2.getEmpty()) {
                objRememberedValue = (MapParams) mapViewModel5.getGson().j(params, MapParams.class);
                composer3.updateRememberedValue(objRememberedValue);
            }
            mapParams = (MapParams) objRememberedValue;
            objRememberedValue2 = composer3.rememberedValue();
            if (objRememberedValue2 == companion2.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                composer3.updateRememberedValue(objRememberedValue2);
            }
            mutableState = (MutableState) objRememberedValue2;
            stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(LocationDataSource.INSTANCE.getInstance().getCurrentLocationFlow(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composer3, 0, 7);
            objRememberedValue3 = composer3.rememberedValue();
            if (objRememberedValue3 == companion2.getEmpty()) {
                objRememberedValue3 = SnapshotStateKt.derivedStateOf(new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.map.f
                    @Override // lb.a
                    public final Object invoke() {
                        return MapScreenKt.MapScreen$lambda$0$5$0(stateCollectAsStateWithLifecycle);
                    }
                });
                composer3.updateRememberedValue(objRememberedValue3);
            }
            state = (State) objRememberedValue3;
            objRememberedValue4 = composer3.rememberedValue();
            obj = objRememberedValue4;
            if (objRememberedValue4 == companion2.getEmpty()) {
                SnapshotStateList snapshotStateListMutableStateListOf2 = SnapshotStateKt.mutableStateListOf();
                snapshotStateListMutableStateListOf2.addAll(mapParams.getMarkers());
                composer3.updateRememberedValue(snapshotStateListMutableStateListOf2);
                obj = snapshotStateListMutableStateListOf2;
            }
            snapshotStateList = (SnapshotStateList) obj;
            objRememberedValue5 = composer3.rememberedValue();
            if (objRememberedValue5 == companion2.getEmpty()) {
                objRememberedValue5 = SnapshotStateKt.derivedStateOf(new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.map.g
                    @Override // lb.a
                    public final Object invoke() {
                        return MapScreenKt.MapScreen$lambda$0$7$0(snapshotStateList);
                    }
                });
                composer3.updateRememberedValue(objRememberedValue5);
            }
            state2 = (State) objRememberedValue5;
            strStringResource = StringResources_androidKt.stringResource(R.string.send_selected_location, composer3, r11);
            strStringResource2 = StringResources_androidKt.stringResource(R.string.send_current_location, composer3, 0);
            objRememberedValue6 = composer3.rememberedValue();
            mapViewModel3 = mapViewModel5;
            if (objRememberedValue6 == companion2.getEmpty()) {
                state3 = state;
                mapViewModel4 = mapViewModel3;
                lb.a aVar3 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.map.h
                    @Override // lb.a
                    public final Object invoke() {
                        return MapScreenKt.MapScreen$lambda$0$8$0(state2, state3, strStringResource, strStringResource2, mapViewModel4, mapParams, navHostController2);
                    }
                };
                state4 = state2;
                navHostController2 = navHostController2;
                objRememberedValue6 = SnapshotStateKt.derivedStateOf(aVar3);
                composer3.updateRememberedValue(objRememberedValue6);
            } else {
                state3 = state;
                state4 = state2;
                mapViewModel4 = mapViewModel3;
            }
            State state8 = (State) objRememberedValue6;
            Z17MapMarker z17MapMarker2 = (Z17MapMarker) state3.getValue();
            List list2 = snapshotStateList.toList();
            motive = mapParams.getMotive();
            mapMotive = MapMotive.SELECT;
            if (motive == mapMotive) {
                z10 = true;
            } else {
                z10 = false;
            }
            State state9 = state4;
            if (mapParams.getMotive() == MapMotive.SHOW) {
                id2 = "0";
            } else {
                id2 = "0";
            }
            String str2 = id2;
            objRememberedValue7 = composer3.rememberedValue();
            if (objRememberedValue7 == companion2.getEmpty()) {
                objRememberedValue7 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.map.i
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return MapScreenKt.MapScreen$lambda$0$9$0(snapshotStateList, (Z17MapMarker) obj2);
                    }
                };
                composer3.updateRememberedValue(objRememberedValue7);
            }
            Composer composer14 = composer3;
            State state10 = state3;
            Z17MapViewKt.Z17MapView(null, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, z10, str2, z17MapMarker2, list2, (Function1) objRememberedValue7, composer14, (Z17MapMarker.$stable << 18) | 100663296, 15);
            composer4 = composer14;
            Modifier modifierAlign2 = boxScopeInstance2.align(companion, companion6.getTopStart());
            MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), companion6.getStart(), composer4, 0);
            int iA4 = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer4, 0));
            CompositionLocalMap currentCompositionLocalMap4 = composer4.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composer4, modifierAlign2);
            constructor2 = companion7.getConstructor();
            if (!r.a(composer4.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composer4.startReusableNode();
            if (composer4.getInserting()) {
                composer4.createNode(constructor2);
            } else {
                composer4.useNode();
            }
            Composer composerM5176constructorimpl4 = Updater.m5176constructorimpl(composer4);
            MapViewModel mapViewModel7 = mapViewModel4;
            Updater.m5184setimpl(composerM5176constructorimpl4, measurePolicyColumnMeasurePolicy2, companion7.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl4, currentCompositionLocalMap4, companion7.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl4, Integer.valueOf(iA4), companion7.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl4, companion7.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl4, modifierMaterializeModifier4, companion7.getSetModifier());
            ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
            zChangedInstance = composer4.changedInstance(navHostController2);
            objRememberedValue8 = composer4.rememberedValue();
            if (zChangedInstance) {
                objRememberedValue8 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.map.j
                    @Override // lb.a
                    public final Object invoke() {
                        return MapScreenKt.MapScreen$lambda$0$10$0$0(navHostController2);
                    }
                };
                composer4.updateRememberedValue(objRememberedValue8);
            } else {
                objRememberedValue8 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.map.j
                    @Override // lb.a
                    public final Object invoke() {
                        return MapScreenKt.MapScreen$lambda$0$10$0$0(navHostController2);
                    }
                };
                composer4.updateRememberedValue(objRememberedValue8);
            }
            ContrastToolbarKt.ContrastToolbar(null, (lb.a) objRememberedValue8, composer4, 0, 1);
            if (MapScreen$lambda$0$2(mutableState)) {
                composer4.startReplaceGroup(-1217909091);
                List listE2 = v.e(PermissionNeedIt.LOCATION);
                objRememberedValue9 = composer4.rememberedValue();
                if (objRememberedValue9 == companion2.getEmpty()) {
                    objRememberedValue9 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.map.k
                        @Override // lb.a
                        public final Object invoke() {
                            return MapScreenKt.MapScreen$lambda$0$10$1$0(mutableState);
                        }
                    };
                    composer4.updateRememberedValue(objRememberedValue9);
                }
                lb.a aVar4 = (lb.a) objRememberedValue9;
                String packageName2 = context.getPackageName();
                y.h(packageName2, "getPackageName(...)");
                companion3 = companion;
                i14 = 1;
                Z17PermissionRequesterKt.Z17PermissionCheckerAndRequester(null, null, listE2, aVar4, null, packageName2, null, composer4, 3456, 83);
                Composer composer15 = composer4;
                composer15.endReplaceGroup();
                composer5 = composer15;
            } else {
                i14 = 1;
                companion3 = companion;
                composer4.startReplaceGroup(899800613);
                composer4.endReplaceGroup();
                composer5 = composer4;
            }
            if (mapParams.getMotive() == mapMotive) {
                composer5.startReplaceGroup(-1217897262);
                float f11 = 20;
                Composer composer16 = composer5;
                Z17LabelKt.m10262Z17LabelfWhpE4E(PaddingKt.m1725padding3ABfNKs(BackgroundKt.m1204backgroundbw27NRU(PaddingKt.m1725padding3ABfNKs(SizeKt.fillMaxWidth$default(companion3, 0.0f, i14, null), Dp.m8823constructorimpl(f11)), Color.m5865copywmQWz5c$default(materialTheme.getColorScheme(composer5, i13).getOnBackground(), 0.2f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(10))), Dp.m8823constructorimpl(f11)), StringResources_androidKt.stringResource(R.string.for_select_point_distinct_from_current, composer5, 0), TextStyle.m8271copyp1EtxEg$default(materialTheme.getTypography(composer5, i13).getBodyMedium(), 0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, TextAlign.INSTANCE.m8692getCentere0LSkKk(), 0, 0L, null, null, null, 0, 0, null, 16744447, null), 0L, 0, 0, composer16, 0, 56);
                Composer composer17 = composer16;
                composer17.endReplaceGroup();
                composer6 = composer17;
            } else {
                composer5.startReplaceGroup(900464261);
                composer5.endReplaceGroup();
                composer6 = composer5;
            }
            composer6.endNode();
            if (mapParams.getMotive() == mapMotive) {
                composer6.startReplaceGroup(96483451);
                composer6.endReplaceGroup();
                composer7 = composer6;
            } else {
                composer6.startReplaceGroup(96483451);
                composer6.endReplaceGroup();
                composer7 = composer6;
            }
            composer7.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            mapViewModel2 = mapViewModel7;
            composer2 = composer7;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            mapViewModel2 = mapViewModel5;
            composer2 = composerStartRestartGroup;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.map.b
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return MapScreenKt.MapScreen$lambda$1(navHostController, params, mapViewModel2, i10, i11, (Composer) obj2, ((Integer) obj3).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 MapScreen$lambda$0$10$0$0(NavHostController navHostController) {
        navHostController.navigateUp();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 MapScreen$lambda$0$10$1$0(MutableState mutableState) {
        MapScreen$lambda$0$3(mutableState, true);
        return k0.f43947a;
    }

    private static final boolean MapScreen$lambda$0$2(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void MapScreen$lambda$0$3(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    private static final Location MapScreen$lambda$0$4(State<? extends Location> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Z17MapMarker MapScreen$lambda$0$5$0(State state) {
        if (MapScreen$lambda$0$4(state) == null) {
            return null;
        }
        Location locationMapScreen$lambda$0$4 = MapScreen$lambda$0$4(state);
        y.f(locationMapScreen$lambda$0$4);
        double latitude = locationMapScreen$lambda$0$4.getLatitude();
        Location locationMapScreen$lambda$0$5 = MapScreen$lambda$0$4(state);
        y.f(locationMapScreen$lambda$0$5);
        double longitude = locationMapScreen$lambda$0$5.getLongitude();
        Location locationMapScreen$lambda$0$6 = MapScreen$lambda$0$4(state);
        y.f(locationMapScreen$lambda$0$6);
        double altitude = locationMapScreen$lambda$0$6.getAltitude();
        Location locationMapScreen$lambda$0$7 = MapScreen$lambda$0$4(state);
        y.f(locationMapScreen$lambda$0$7);
        return new Z17MapMarker("0", latitude, longitude, altitude, MapScreen$lambda$0$4(state), Float.valueOf(locationMapScreen$lambda$0$7.getAccuracy()), 0, 64, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Z17MapMarker MapScreen$lambda$0$7$0(SnapshotStateList snapshotStateList) {
        Object next;
        Iterator it = snapshotStateList.toList().iterator();
        while (it.hasNext()) {
            next = it.next();
            if (y.d(((Z17MapMarker) next).getId(), ChatParams.TOSEND)) {
                return (Z17MapMarker) next;
            }
        }
        next = null;
        return (Z17MapMarker) next;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List MapScreen$lambda$0$8$0(final State state, final State state2, String str, String str2, final MapViewModel mapViewModel, final MapParams mapParams, final NavHostController navHostController) {
        if (state.getValue() == null || state2.getValue() == null) {
            return state.getValue() != null ? v.e(new Z17MultipleFabObj("1", str, MyLocationKt.getMyLocation(Icons.Outlined.INSTANCE), null, null, new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.map.d
                @Override // lb.a
                public final Object invoke() {
                    return MapScreenKt.MapScreen$lambda$0$8$0$2(mapViewModel, mapParams, state, navHostController);
                }
            }, 24, null)) : v.e(new Z17MultipleFabObj(ExifInterface.GPS_MEASUREMENT_2D, str2, LocationOnKt.getLocationOn(Icons.Outlined.INSTANCE), null, null, new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.map.e
                @Override // lb.a
                public final Object invoke() {
                    return MapScreenKt.MapScreen$lambda$0$8$0$3(state2, navHostController, mapViewModel, mapParams);
                }
            }, 24, null));
        }
        Icons.Outlined outlined = Icons.Outlined.INSTANCE;
        return w.q(new Z17MultipleFabObj("1", str, MyLocationKt.getMyLocation(outlined), null, null, new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.map.a
            @Override // lb.a
            public final Object invoke() {
                return MapScreenKt.MapScreen$lambda$0$8$0$0(mapViewModel, mapParams, state, navHostController);
            }
        }, 24, null), new Z17MultipleFabObj(ExifInterface.GPS_MEASUREMENT_2D, str2, LocationOnKt.getLocationOn(outlined), null, null, new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.map.c
            @Override // lb.a
            public final Object invoke() {
                return MapScreenKt.MapScreen$lambda$0$8$0$1(state2, navHostController, mapViewModel, mapParams);
            }
        }, 24, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 MapScreen$lambda$0$8$0$0(MapViewModel mapViewModel, MapParams mapParams, State state, NavHostController navHostController) {
        String roomId = mapParams.getRoomId();
        Object value = state.getValue();
        y.f(value);
        mapViewModel.sendLocation(roomId, (Z17MapMarker) value, mapParams.getReplyMsgId());
        navHostController.navigateUp();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 MapScreen$lambda$0$8$0$1(State state, NavHostController navHostController, MapViewModel mapViewModel, MapParams mapParams) {
        Z17MapMarker z17MapMarker = (Z17MapMarker) state.getValue();
        if (z17MapMarker != null) {
            mapViewModel.sendLocation(mapParams.getRoomId(), z17MapMarker, mapParams.getReplyMsgId());
        }
        navHostController.navigateUp();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 MapScreen$lambda$0$8$0$2(MapViewModel mapViewModel, MapParams mapParams, State state, NavHostController navHostController) {
        String roomId = mapParams.getRoomId();
        Object value = state.getValue();
        y.f(value);
        mapViewModel.sendLocation(roomId, (Z17MapMarker) value, mapParams.getReplyMsgId());
        navHostController.navigateUp();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 MapScreen$lambda$0$8$0$3(State state, NavHostController navHostController, MapViewModel mapViewModel, MapParams mapParams) {
        Z17MapMarker z17MapMarker = (Z17MapMarker) state.getValue();
        if (z17MapMarker != null) {
            mapViewModel.sendLocation(mapParams.getRoomId(), z17MapMarker, mapParams.getReplyMsgId());
        }
        navHostController.navigateUp();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 MapScreen$lambda$0$9$0(SnapshotStateList snapshotStateList, Z17MapMarker marker) {
        y.i(marker, "marker");
        Iterator<T> it = snapshotStateList.iterator();
        int i10 = 0;
        while (true) {
            if (!it.hasNext()) {
                i10 = -1;
                break;
            }
            if (y.d(((Z17MapMarker) it.next()).getId(), marker.getId())) {
                break;
            }
            i10++;
        }
        if (i10 == -1) {
            snapshotStateList.add(marker);
        } else {
            snapshotStateList.remove(i10);
            if (i10 >= snapshotStateList.size() - 1) {
                snapshotStateList.add(marker);
            } else {
                snapshotStateList.add(i10, marker);
            }
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 MapScreen$lambda$1(NavHostController navHostController, String str, MapViewModel mapViewModel, int i10, int i11, Composer composer, int i12) {
        MapScreen(navHostController, str, mapViewModel, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return k0.f43947a;
    }
}
