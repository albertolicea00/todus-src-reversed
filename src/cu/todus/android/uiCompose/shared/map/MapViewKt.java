package cu.todus.android.uiCompose.shared.map;

import ab.i;
import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import androidx.camera.video.AudioStats;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.p001lifecycle.Lifecycle;
import androidx.p001lifecycle.LifecycleOwner;
import androidx.p001lifecycle.p002compose.FlowExtKt;
import cu.todus.android.location.LocationDataSource;
import cu.todus.android.uiCompose.shared.map.MapViewKt;
import cu.z17.views.map.Z17MapMarker;
import cu.z17.views.map.Z17MapViewKt;
import cu.z17.views.permission.PermissionNeedIt;
import cu.z17.views.permission.Z17PermissionRequesterKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.y;
import lb.a;
import ua.k0;
import va.g0;
import va.v;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a3\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\u0001\u001a\u00020\u00002\u0018\b\u0002\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\r²\u0006\u000e\u0010\n\u001a\u00020\t8\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\f\u001a\u0004\u0018\u00010\u000b8\nX\u008a\u0084\u0002"}, d2 = {"Landroidx/compose/ui/Modifier;", "modifier", "Ljava/util/ArrayList;", "Lcu/z17/views/map/Z17MapMarker;", "Lkotlin/collections/ArrayList;", "markers", "Lua/k0;", "MapView", "(Landroidx/compose/ui/Modifier;Ljava/util/ArrayList;Landroidx/compose/runtime/Composer;II)V", "", "permissionsGranted", "Landroid/location/Location;", "userMapLocation", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class MapViewKt {
    /* JADX WARN: Code duplicated, block: B:49:0x0093  */
    /* JADX WARN: Code duplicated, block: B:52:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:55:0x00db  */
    /* JADX WARN: Code duplicated, block: B:58:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:61:0x0105  */
    /* JADX WARN: Code duplicated, block: B:63:0x011c  */
    /* JADX WARN: Code duplicated, block: B:64:0x0127  */
    /* JADX WARN: Code duplicated, block: B:67:0x0133  */
    /* JADX WARN: Code duplicated, block: B:69:0x015f  */
    /* JADX WARN: Code duplicated, block: B:71:0x0178  */
    /* JADX WARN: Code duplicated, block: B:75:0x01a1  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    @SuppressLint({"MissingPermission", "MutableCollectionMutableState"})
    public static final void MapView(Modifier modifier, ArrayList<Z17MapMarker> arrayList, Composer composer, final int i10, final int i11) {
        Modifier modifier2;
        int i12;
        final ArrayList<Z17MapMarker> arrayList2;
        final Modifier modifier3;
        Modifier modifier4;
        ArrayList<Z17MapMarker> arrayList3;
        int i13;
        Object objRememberedValue;
        Composer.Companion companion;
        final MutableState mutableState;
        final State stateCollectAsStateWithLifecycle;
        Context context;
        Object objRememberedValue2;
        State state;
        Object objRememberedValue3;
        Object obj;
        final SnapshotStateList snapshotStateList;
        Object objRememberedValue4;
        String id2;
        Object objRememberedValue5;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1504318653);
        int i14 = i11 & 1;
        if (i14 != 0) {
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
            if ((i11 & 2) == 0) {
                arrayList2 = arrayList;
                int i15 = composerStartRestartGroup.changedInstance(arrayList2) ? 32 : 16;
                i12 |= i15;
            } else {
                arrayList2 = arrayList;
            }
            i12 |= i15;
        } else {
            arrayList2 = arrayList;
        }
        if (composerStartRestartGroup.shouldExecute((i12 & 19) != 18, i12 & 1)) {
            composerStartRestartGroup.startDefaults();
            if ((i10 & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                Modifier modifier5 = i14 != 0 ? Modifier.INSTANCE : modifier2;
                if ((i11 & 2) != 0) {
                    modifier4 = modifier5;
                    arrayList3 = new ArrayList<>();
                    i13 = i12 & (-113);
                } else {
                    modifier4 = modifier5;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1504318653, i13, -1, "cu.todus.android.uiCompose.shared.map.MapView (MapView.kt:24)");
                }
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                companion = Composer.INSTANCE;
                if (objRememberedValue == companion.getEmpty()) {
                    objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                mutableState = (MutableState) objRememberedValue;
                stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(LocationDataSource.INSTANCE.getInstance().getCurrentLocationFlow(), (LifecycleOwner) null, (Lifecycle.State) null, (i) null, composerStartRestartGroup, 0, 7);
                context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == companion.getEmpty()) {
                    objRememberedValue2 = SnapshotStateKt.derivedStateOf(new a() { // from class: q8.a
                        @Override // lb.a
                        public final Object invoke() {
                            return MapViewKt.MapView$lambda$4$0(stateCollectAsStateWithLifecycle);
                        }
                    });
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                state = (State) objRememberedValue2;
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                obj = objRememberedValue3;
                if (objRememberedValue3 == companion.getEmpty()) {
                    SnapshotStateList snapshotStateListMutableStateListOf = SnapshotStateKt.mutableStateListOf();
                    snapshotStateListMutableStateListOf.addAll(arrayList3);
                    composerStartRestartGroup.updateRememberedValue(snapshotStateListMutableStateListOf);
                    obj = snapshotStateListMutableStateListOf;
                }
                snapshotStateList = (SnapshotStateList) obj;
                if (MapView$lambda$1(mutableState)) {
                    composerStartRestartGroup.startReplaceGroup(-1467186867);
                    Z17MapMarker z17MapMarker = (Z17MapMarker) state.getValue();
                    int i16 = i13;
                    List list = snapshotStateList.toList();
                    if (arrayList3.isEmpty()) {
                        id2 = "";
                    } else {
                        id2 = ((Z17MapMarker) g0.w0(arrayList3)).getId();
                    }
                    objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue5 == companion.getEmpty()) {
                        objRememberedValue5 = new Function1() { // from class: q8.b
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return MapViewKt.MapView$lambda$6$0(snapshotStateList, (Z17MapMarker) obj2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    }
                    Modifier modifier6 = modifier4;
                    Z17MapViewKt.Z17MapView(modifier6, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, false, id2, z17MapMarker, list, (Function1) objRememberedValue5, composerStartRestartGroup, (i16 & 14) | 100687872 | (Z17MapMarker.$stable << 18), 14);
                    modifier3 = modifier6;
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    modifier3 = modifier4;
                    composerStartRestartGroup.startReplaceGroup(-1466442433);
                    List listE = v.e(PermissionNeedIt.LOCATION);
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue4 == companion.getEmpty()) {
                        objRememberedValue4 = new a() { // from class: q8.c
                            @Override // lb.a
                            public final Object invoke() {
                                return MapViewKt.MapView$lambda$7$0(mutableState);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    String packageName = context.getPackageName();
                    y.h(packageName, "getPackageName(...)");
                    Z17PermissionRequesterKt.Z17PermissionCheckerAndRequester(null, null, listE, (a) objRememberedValue4, null, packageName, null, composerStartRestartGroup, 3456, 83);
                    composerStartRestartGroup.endReplaceGroup();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                arrayList2 = arrayList3;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i11 & 2) != 0) {
                    i12 &= -113;
                }
                modifier4 = modifier2;
            }
            i13 = i12;
            arrayList3 = arrayList2;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1504318653, i13, -1, "cu.todus.android.uiCompose.shared.map.MapView (MapView.kt:24)");
            }
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            companion = Composer.INSTANCE;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            mutableState = (MutableState) objRememberedValue;
            stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(LocationDataSource.INSTANCE.getInstance().getCurrentLocationFlow(), (LifecycleOwner) null, (Lifecycle.State) null, (i) null, composerStartRestartGroup, 0, 7);
            context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt.derivedStateOf(new a() { // from class: q8.a
                    @Override // lb.a
                    public final Object invoke() {
                        return MapViewKt.MapView$lambda$4$0(stateCollectAsStateWithLifecycle);
                    }
                });
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            state = (State) objRememberedValue2;
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            obj = objRememberedValue3;
            if (objRememberedValue3 == companion.getEmpty()) {
                SnapshotStateList snapshotStateListMutableStateListOf2 = SnapshotStateKt.mutableStateListOf();
                snapshotStateListMutableStateListOf2.addAll(arrayList3);
                composerStartRestartGroup.updateRememberedValue(snapshotStateListMutableStateListOf2);
                obj = snapshotStateListMutableStateListOf2;
            }
            snapshotStateList = (SnapshotStateList) obj;
            if (MapView$lambda$1(mutableState)) {
                composerStartRestartGroup.startReplaceGroup(-1467186867);
                Z17MapMarker z17MapMarker2 = (Z17MapMarker) state.getValue();
                int i17 = i13;
                List list2 = snapshotStateList.toList();
                if (arrayList3.isEmpty()) {
                    id2 = ((Z17MapMarker) g0.w0(arrayList3)).getId();
                } else {
                    id2 = "";
                }
                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue5 == companion.getEmpty()) {
                    objRememberedValue5 = new Function1() { // from class: q8.b
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return MapViewKt.MapView$lambda$6$0(snapshotStateList, (Z17MapMarker) obj2);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                Modifier modifier7 = modifier4;
                Z17MapViewKt.Z17MapView(modifier7, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, false, id2, z17MapMarker2, list2, (Function1) objRememberedValue5, composerStartRestartGroup, (i17 & 14) | 100687872 | (Z17MapMarker.$stable << 18), 14);
                modifier3 = modifier7;
                composerStartRestartGroup.endReplaceGroup();
            } else {
                modifier3 = modifier4;
                composerStartRestartGroup.startReplaceGroup(-1466442433);
                List listE2 = v.e(PermissionNeedIt.LOCATION);
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue4 == companion.getEmpty()) {
                    objRememberedValue4 = new a() { // from class: q8.c
                        @Override // lb.a
                        public final Object invoke() {
                            return MapViewKt.MapView$lambda$7$0(mutableState);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                String packageName2 = context.getPackageName();
                y.h(packageName2, "getPackageName(...)");
                Z17PermissionRequesterKt.Z17PermissionCheckerAndRequester(null, null, listE2, (a) objRememberedValue4, null, packageName2, null, composerStartRestartGroup, 3456, 83);
                composerStartRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            arrayList2 = arrayList3;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: q8.d
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return MapViewKt.MapView$lambda$8(modifier3, arrayList2, i10, i11, (Composer) obj2, ((Integer) obj3).intValue());
                }
            });
        }
    }

    private static final boolean MapView$lambda$1(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void MapView$lambda$2(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    private static final Location MapView$lambda$3(State<? extends Location> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Z17MapMarker MapView$lambda$4$0(State state) {
        if (MapView$lambda$3(state) == null) {
            return null;
        }
        Location locationMapView$lambda$3 = MapView$lambda$3(state);
        y.f(locationMapView$lambda$3);
        double latitude = locationMapView$lambda$3.getLatitude();
        Location locationMapView$lambda$4 = MapView$lambda$3(state);
        y.f(locationMapView$lambda$4);
        double longitude = locationMapView$lambda$4.getLongitude();
        Location locationMapView$lambda$5 = MapView$lambda$3(state);
        y.f(locationMapView$lambda$5);
        double altitude = locationMapView$lambda$5.getAltitude();
        Location locationMapView$lambda$6 = MapView$lambda$3(state);
        y.f(locationMapView$lambda$6);
        return new Z17MapMarker("0", latitude, longitude, altitude, MapView$lambda$3(state), Float.valueOf(locationMapView$lambda$6.getAccuracy()), 0, 64, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 MapView$lambda$6$0(SnapshotStateList snapshotStateList, Z17MapMarker marker) {
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
    public static final k0 MapView$lambda$7$0(MutableState mutableState) {
        MapView$lambda$2(mutableState, true);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 MapView$lambda$8(Modifier modifier, ArrayList arrayList, int i10, int i11, Composer composer, int i12) {
        MapView(modifier, arrayList, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return k0.f43947a;
    }
}
