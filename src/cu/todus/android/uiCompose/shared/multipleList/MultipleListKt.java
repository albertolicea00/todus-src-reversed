package cu.todus.android.uiCompose.shared.multipleList;

import android.content.Context;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.LazyListStateKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.TabRowKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.paging.compose.LazyFoundationExtensionsKt;
import androidx.paging.compose.LazyPagingItems;
import cu.todus.android.R;
import cu.todus.android.data.db.entity.toDus.Room;
import cu.todus.android.data.db.pojo.Friend;
import cu.todus.android.data.db.pojo.RoomItemView;
import cu.todus.android.uiCompose.main.screen.rooms.roomItem.RoomItemKt;
import cu.todus.android.uiCompose.shared.userCommonList.UserCommonListKt;
import cu.z17.views.tab.Z17TabKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.y;
import le.d0;
import ua.k0;
import va.w;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\u001a¡\u0001\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0001\u001a\u00020\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00022\u001c\u0010\u000b\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\n0\b2\u001c\u0010\f\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\n0\b2\u0006\u0010\u000e\u001a\u00020\r2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\r0\u000f2\u0006\u0010\u0012\u001a\u00020\u0010H\u0007¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0018²\u0006\u000e\u0010\u0016\u001a\u00020\u00158\n@\nX\u008a\u008e\u0002²\u0006\f\u0010\u0017\u001a\u00020\u00158\nX\u008a\u0084\u0002"}, d2 = {"Landroidx/compose/ui/Modifier;", "modifier", "Landroidx/paging/compose/LazyPagingItems;", "Lcu/todus/android/data/db/pojo/RoomItemView;", "recent", Room.TABLE_NAME, "Lcu/todus/android/data/db/pojo/Friend;", "friends", "Lkotlin/Function2;", "Lcu/todus/android/data/db/pojo/UserCommon;", "Lua/k0;", "onClick", "onLongClick", "", "thereAreSelected", "Lkotlin/Function1;", "", "checkIfIsSelected", "ownerId", "MultipleList", "(Landroidx/compose/ui/Modifier;Landroidx/paging/compose/LazyPagingItems;Landroidx/paging/compose/LazyPagingItems;Landroidx/paging/compose/LazyPagingItems;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLkotlin/jvm/functions/Function1;Ljava/lang/String;Landroidx/compose/runtime/Composer;I)V", "", "tabIndex", "max", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class MultipleListKt {
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
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
    public static final void MultipleList(final Modifier modifier, final LazyPagingItems<RoomItemView> recent, final LazyPagingItems<RoomItemView> rooms, final LazyPagingItems<Friend> friends, final Function2 onClick, final Function2 onLongClick, boolean z10, Function1 function1, final String ownerId, Composer composer, final int i10) {
        int i11;
        final Function2 function2;
        int i12;
        MutableIntState mutableIntState;
        State state;
        ab.e eVar;
        boolean z11;
        boolean z12;
        z10 = z10;
        final Function1 checkIfIsSelected = function1;
        y.i(modifier, "modifier");
        y.i(recent, "recent");
        y.i(rooms, "rooms");
        y.i(friends, "friends");
        y.i(onClick, "onClick");
        y.i(onLongClick, "onLongClick");
        y.i(checkIfIsSelected, "checkIfIsSelected");
        y.i(ownerId, "ownerId");
        Composer composerStartRestartGroup = composer.startRestartGroup(1468940678);
        if ((i10 & 6) == 0) {
            i11 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i10;
        } else {
            i11 = i10;
        }
        if ((i10 & 48) == 0) {
            i11 |= (i10 & 64) == 0 ? composerStartRestartGroup.changed(recent) : composerStartRestartGroup.changedInstance(recent) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i11 |= (i10 & 512) == 0 ? composerStartRestartGroup.changed(rooms) : composerStartRestartGroup.changedInstance(rooms) ? 256 : 128;
        }
        if ((i10 & 3072) == 0) {
            i11 |= (i10 & 4096) == 0 ? composerStartRestartGroup.changed(friends) : composerStartRestartGroup.changedInstance(friends) ? 2048 : 1024;
        }
        if ((i10 & 24576) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(onClick) ? 16384 : 8192;
        }
        if ((196608 & i10) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(onLongClick) ? 131072 : 65536;
        }
        if ((1572864 & i10) == 0) {
            i11 |= composerStartRestartGroup.changed(z10) ? 1048576 : 524288;
        }
        if ((12582912 & i10) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(checkIfIsSelected) ? 8388608 : 4194304;
        }
        if ((100663296 & i10) == 0) {
            i11 |= composerStartRestartGroup.changed(ownerId) ? 67108864 : 33554432;
        }
        if (composerStartRestartGroup.shouldExecute((38347923 & i11) != 38347922, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1468940678, i11, -1, "cu.todus.android.uiCompose.shared.multipleList.MultipleList (MultipleList.kt:55)");
            }
            Context context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = SnapshotIntStateKt.mutableIntStateOf(0);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final MutableIntState mutableIntState2 = (MutableIntState) objRememberedValue;
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = w.q(context.getString(R.string.recent), context.getString(R.string.groups_and_channels), context.getString(R.string.contacts));
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            final List list = (List) objRememberedValue2;
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(modifier, 0.0f, 1, null);
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
            int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxWidth$default);
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
            int i13 = i11;
            int intValue = mutableIntState2.getIntValue();
            Modifier.Companion companion3 = Modifier.INSTANCE;
            TabRowKt.m3761TabRowpAZo6Ak(intValue, BackgroundKt.m1205backgroundbw27NRU$default(companion3, MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground(), null, 2, null), 0L, 0L, null, null, ComposableLambdaKt.rememberComposableLambda(137279252, true, new Function2() { // from class: cu.todus.android.uiCompose.shared.multipleList.m
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return MultipleListKt.MultipleList$lambda$4$0(list, mutableIntState2, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 1572864, 60);
            composerStartRestartGroup = composerStartRestartGroup;
            boolean zChanged = composerStartRestartGroup.changed(recent.getItemCount()) | composerStartRestartGroup.changed(rooms.getItemCount()) | composerStartRestartGroup.changed(friends.getItemCount());
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue3 == companion.getEmpty()) {
                objRememberedValue3 = SnapshotStateKt.derivedStateOf(new lb.a() { // from class: cu.todus.android.uiCompose.shared.multipleList.n
                    @Override // lb.a
                    public final Object invoke() {
                        return Integer.valueOf(MultipleListKt.MultipleList$lambda$4$1$0(recent, rooms, friends));
                    }
                });
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            State state2 = (State) objRememberedValue3;
            int intValue2 = mutableIntState2.getIntValue();
            if (intValue2 != 0) {
                if (intValue2 == 1) {
                    function2 = onLongClick;
                    i12 = i13;
                    mutableIntState = mutableIntState2;
                    state = state2;
                    eVar = null;
                    composerStartRestartGroup.startReplaceGroup(154797865);
                    LazyListState lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                    Modifier modifierFillMaxHeight$default = SizeKt.fillMaxHeight$default(companion3, 0.0f, 1, null);
                    boolean z13 = ((i12 & 29360128) == 8388608) | ((i12 & 896) == 256 || ((i12 & 512) != 0 && composerStartRestartGroup.changedInstance(rooms))) | ((i12 & 458752) == 131072) | ((i12 & 57344) == 16384);
                    Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (z13 || objRememberedValue4 == companion.getEmpty()) {
                        objRememberedValue4 = new Function1() { // from class: cu.todus.android.uiCompose.shared.multipleList.p
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return MultipleListKt.MultipleList$lambda$4$4$0(rooms, checkIfIsSelected, function2, onClick, (LazyListScope) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    z12 = true;
                    LazyDslKt.LazyColumn(modifierFillMaxHeight$default, lazyListStateRememberLazyListState, null, false, null, null, null, false, null, (Function1) objRememberedValue4, composerStartRestartGroup, 6, TypedValues.PositionType.TYPE_CURVE_FIT);
                    composerStartRestartGroup = composerStartRestartGroup;
                    composerStartRestartGroup.endReplaceGroup();
                    k0 k0Var = k0.f43947a;
                } else if (intValue2 != 2) {
                    composerStartRestartGroup.startReplaceGroup(158072550);
                    composerStartRestartGroup.endReplaceGroup();
                    k0 k0Var2 = k0.f43947a;
                    z11 = false;
                    function2 = onLongClick;
                    i12 = i13;
                    mutableIntState = mutableIntState2;
                    state = state2;
                    z12 = true;
                    eVar = null;
                    z10 = z10;
                } else {
                    composerStartRestartGroup.startReplaceGroup(157358217);
                    LazyListState lazyListStateRememberLazyListState2 = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                    Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(companion3, 0.0f, 1, null);
                    boolean z14 = (i13 & 57344) == 16384;
                    Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (z14 || objRememberedValue5 == companion.getEmpty()) {
                        objRememberedValue5 = new Function1() { // from class: cu.todus.android.uiCompose.shared.multipleList.q
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return MultipleListKt.MultipleList$lambda$4$5$0(onClick, (Friend) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    }
                    Function1 function3 = (Function1) objRememberedValue5;
                    boolean z15 = (i13 & 458752) == 131072;
                    Object objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                    if (z15 || objRememberedValue6 == companion.getEmpty()) {
                        objRememberedValue6 = new Function1() { // from class: cu.todus.android.uiCompose.shared.multipleList.r
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return MultipleListKt.MultipleList$lambda$4$6$0(onLongClick, (Friend) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                    }
                    Function1 function4 = (Function1) objRememberedValue6;
                    boolean z16 = (i13 & 29360128) == 8388608;
                    Object objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                    if (z16 || objRememberedValue7 == companion.getEmpty()) {
                        objRememberedValue7 = new Function1() { // from class: cu.todus.android.uiCompose.shared.multipleList.s
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return MultipleListKt.MultipleList$lambda$4$7$0(checkIfIsSelected, (Friend) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                    }
                    Function1 function5 = (Function1) objRememberedValue7;
                    int i14 = ((i13 >> 3) & 896) | (LazyPagingItems.$stable << 6) | 6 | ((i13 >> 6) & 3670016);
                    mutableIntState = mutableIntState2;
                    state = state2;
                    eVar = null;
                    UserCommonListKt.UserCommonList(modifierFillMaxSize$default, lazyListStateRememberLazyListState2, friends, function3, function4, null, ownerId, function5, null, composerStartRestartGroup, i14, 288);
                    composerStartRestartGroup.endReplaceGroup();
                    k0 k0Var3 = k0.f43947a;
                    function2 = onLongClick;
                    checkIfIsSelected = function1;
                    i12 = i13;
                    z12 = true;
                }
                z11 = false;
            } else {
                function2 = onLongClick;
                i12 = i13;
                mutableIntState = mutableIntState2;
                state = state2;
                eVar = null;
                z10 = z10;
                composerStartRestartGroup.startReplaceGroup(152216464);
                LazyListState lazyListStateRememberLazyListState3 = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                Modifier modifierFillMaxHeight$default2 = SizeKt.fillMaxHeight$default(companion3, 0.0f, 1, null);
                boolean z17 = ((i12 & 29360128) == 8388608) | ((i12 & 112) == 32 || ((i12 & 64) != 0 && composerStartRestartGroup.changedInstance(recent))) | ((i12 & 458752) == 131072) | ((i12 & 57344) == 16384);
                Object objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                if (z17 || objRememberedValue8 == companion.getEmpty()) {
                    objRememberedValue8 = new Function1() { // from class: cu.todus.android.uiCompose.shared.multipleList.o
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return MultipleListKt.MultipleList$lambda$4$3$0(recent, checkIfIsSelected, function2, onClick, (LazyListScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                }
                z11 = false;
                z12 = true;
                LazyDslKt.LazyColumn(modifierFillMaxHeight$default2, lazyListStateRememberLazyListState3, null, false, null, null, null, false, null, (Function1) objRememberedValue8, composerStartRestartGroup, 6, TypedValues.PositionType.TYPE_CURVE_FIT);
                composerStartRestartGroup = composerStartRestartGroup;
                composerStartRestartGroup.endReplaceGroup();
                k0 k0Var4 = k0.f43947a;
            }
            Integer numValueOf = Integer.valueOf(MultipleList$lambda$4$2(state));
            Boolean boolValueOf = Boolean.valueOf(z10);
            State state3 = state;
            boolean zChanged2 = composerStartRestartGroup.changed(state3);
            if ((i12 & 3670016) != 1048576) {
                z12 = z11;
            }
            boolean z18 = z12 | zChanged2;
            Object objRememberedValue9 = composerStartRestartGroup.rememberedValue();
            if (z18 || objRememberedValue9 == companion.getEmpty()) {
                objRememberedValue9 = new MultipleListKt$MultipleList$1$7$1(z10, mutableIntState, state3, eVar);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
            }
            EffectsKt.LaunchedEffect(numValueOf, boolValueOf, (Function2) objRememberedValue9, composerStartRestartGroup, (i12 >> 15) & 112);
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            function2 = onLongClick;
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Function1 function6 = checkIfIsSelected;
            final boolean z19 = z10;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.shared.multipleList.b
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return MultipleListKt.MultipleList$lambda$5(modifier, recent, rooms, friends, onClick, function2, z19, function6, ownerId, i10, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 MultipleList$lambda$4$0(List list, final MutableIntState mutableIntState, Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(137279252, i10, -1, "cu.todus.android.uiCompose.shared.multipleList.MultipleList.<anonymous>.<anonymous> (MultipleList.kt:74)");
            }
            final int i11 = 0;
            for (Object obj : list) {
                int i12 = i11 + 1;
                if (i11 < 0) {
                    w.x();
                }
                String str = (String) obj;
                y.f(str);
                boolean z10 = i11 == mutableIntState.getIntValue();
                boolean zChanged = composer.changed(i11);
                Object objRememberedValue = composer.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.shared.multipleList.l
                        @Override // lb.a
                        public final Object invoke() {
                            return MultipleListKt.MultipleList$lambda$4$0$0$0$0(i11, mutableIntState);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                Z17TabKt.Z17Tab((lb.a) objRememberedValue, z10, str, composer, 0);
                i11 = i12;
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
    public static final k0 MultipleList$lambda$4$0$0$0$0(int i10, MutableIntState mutableIntState) {
        mutableIntState.setIntValue(i10);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int MultipleList$lambda$4$1$0(LazyPagingItems lazyPagingItems, LazyPagingItems lazyPagingItems2, LazyPagingItems lazyPagingItems3) {
        if (lazyPagingItems.getItemCount() > 0) {
            return 0;
        }
        if (lazyPagingItems2.getItemCount() == 0 && lazyPagingItems3.getItemCount() == 0) {
            return 0;
        }
        int iMax = Math.max(lazyPagingItems2.getItemCount(), lazyPagingItems3.getItemCount());
        return (lazyPagingItems2.getItemCount() != iMax && lazyPagingItems3.getItemCount() == iMax) ? 2 : 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int MultipleList$lambda$4$2(State<Integer> state) {
        return state.getValue().intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 MultipleList$lambda$4$3$0(final LazyPagingItems lazyPagingItems, final Function1 function1, final Function2 function2, final Function2 function3, LazyListScope LazyColumn) {
        y.i(LazyColumn, "$this$LazyColumn");
        LazyColumn.items(lazyPagingItems.getItemCount(), LazyFoundationExtensionsKt.itemKey(lazyPagingItems, new Function1() { // from class: cu.todus.android.uiCompose.shared.multipleList.e
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MultipleListKt.MultipleList$lambda$4$3$0$0((RoomItemView) obj);
            }
        }), LazyFoundationExtensionsKt.itemContentType(lazyPagingItems, new Function1() { // from class: cu.todus.android.uiCompose.shared.multipleList.f
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MultipleListKt.MultipleList$lambda$4$3$0$1((RoomItemView) obj);
            }
        }), ComposableLambdaKt.composableLambdaInstance(-719640430, true, new lb.o() { // from class: cu.todus.android.uiCompose.shared.multipleList.g
            @Override // lb.o
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return MultipleListKt.MultipleList$lambda$4$3$0$2(lazyPagingItems, function1, function2, function3, (LazyItemScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
            }
        }));
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object MultipleList$lambda$4$3$0$0(RoomItemView r10) {
        y.i(r10, "r");
        return r10.getIdOnList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object MultipleList$lambda$4$3$0$1(RoomItemView it) {
        y.i(it, "it");
        return "item";
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 MultipleList$lambda$4$3$0$2(LazyPagingItems lazyPagingItems, Function1 function1, final Function2 function2, final Function2 function3, LazyItemScope items, int i10, Composer composer, int i11) {
        int i12;
        long jM5865copywmQWz5c$default;
        y.i(items, "$this$items");
        if ((i11 & 6) == 0) {
            i12 = i11 | (composer.changed(items) ? 4 : 2);
        } else {
            i12 = i11;
        }
        if ((i11 & 48) == 0) {
            i12 |= composer.changed(i10) ? 32 : 16;
        }
        if (composer.shouldExecute((i12 & 147) != 146, i12 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-719640430, i12, -1, "cu.todus.android.uiCompose.shared.multipleList.MultipleList.<anonymous>.<anonymous>.<anonymous>.<anonymous> (MultipleList.kt:121)");
            }
            final RoomItemView roomItemView = (RoomItemView) lazyPagingItems.get(i10);
            if (roomItemView != null) {
                composer.startReplaceGroup(1668847930);
                float f10 = 3;
                Modifier modifierM1729paddingqDBjuR0$default = PaddingKt.m1729paddingqDBjuR0$default(androidx.compose.foundation.lazy.g.c(items, Modifier.INSTANCE, null, null, null, 2, null), Dp.m8823constructorimpl(5), Dp.m8823constructorimpl(f10), 0.0f, Dp.m8823constructorimpl(f10), 4, null);
                if (((Boolean) function1.invoke(roomItemView.getRoom().getId())).booleanValue()) {
                    composer.startReplaceGroup(222909728);
                    jM5865copywmQWz5c$default = Color.m5865copywmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getTertiary(), 0.3f, 0.0f, 0.0f, 0.0f, 14, null);
                } else {
                    composer.startReplaceGroup(222907994);
                    jM5865copywmQWz5c$default = MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getBackground();
                }
                composer.endReplaceGroup();
                float f11 = 15;
                Modifier modifierM1204backgroundbw27NRU = BackgroundKt.m1204backgroundbw27NRU(modifierM1729paddingqDBjuR0$default, jM5865copywmQWz5c$default, RoundedCornerShapeKt.m2017RoundedCornerShapea9UjIt4$default(Dp.m8823constructorimpl(f11), 0.0f, 0.0f, Dp.m8823constructorimpl(f11), 6, null));
                boolean zChanged = composer.changed(function2) | composer.changed(roomItemView);
                Object objRememberedValue = composer.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.shared.multipleList.a
                        @Override // lb.a
                        public final Object invoke() {
                            return MultipleListKt.MultipleList$lambda$4$3$0$2$0$0$0(function2, roomItemView);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                lb.a aVar = (lb.a) objRememberedValue;
                boolean zChanged2 = composer.changed(function3) | composer.changed(roomItemView);
                Object objRememberedValue2 = composer.rememberedValue();
                if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.shared.multipleList.k
                        @Override // lb.a
                        public final Object invoke() {
                            return MultipleListKt.MultipleList$lambda$4$3$0$2$0$1$0(function3, roomItemView);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue2);
                }
                Modifier modifierM1250combinedClickablehoGz1lA$default = ClickableKt.m1250combinedClickablehoGz1lA$default(modifierM1204backgroundbw27NRU, false, null, null, null, aVar, null, false, null, (lb.a) objRememberedValue2, 239, null);
                composer.startReplaceGroup(-84668056);
                String name = roomItemView.getName();
                if (d0.q0(name)) {
                    name = StringResources_androidKt.stringResource(R.string.loading_hint, composer, 0);
                }
                composer.endReplaceGroup();
                RoomItemKt.SimpleRoomItem(modifierM1250combinedClickablehoGz1lA$default, name, roomItemView.getPhoto(), roomItemView.getRoom().getType(), composer, 0, 0);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-84658910);
                float f12 = 3;
                RoomItemKt.RoomItemPlaceholder(PaddingKt.m1729paddingqDBjuR0$default(Modifier.INSTANCE, Dp.m8823constructorimpl(5), Dp.m8823constructorimpl(f12), 0.0f, Dp.m8823constructorimpl(f12), 4, null), composer, 6);
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
    public static final k0 MultipleList$lambda$4$3$0$2$0$0$0(Function2 function2, RoomItemView roomItemView) {
        function2.invoke(null, roomItemView);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 MultipleList$lambda$4$3$0$2$0$1$0(Function2 function2, RoomItemView roomItemView) {
        function2.invoke(null, roomItemView);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 MultipleList$lambda$4$4$0(final LazyPagingItems lazyPagingItems, final Function1 function1, final Function2 function2, final Function2 function3, LazyListScope LazyColumn) {
        y.i(LazyColumn, "$this$LazyColumn");
        LazyColumn.items(lazyPagingItems.getItemCount(), LazyFoundationExtensionsKt.itemKey(lazyPagingItems, new Function1() { // from class: cu.todus.android.uiCompose.shared.multipleList.h
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MultipleListKt.MultipleList$lambda$4$4$0$0((RoomItemView) obj);
            }
        }), LazyFoundationExtensionsKt.itemContentType(lazyPagingItems, new Function1() { // from class: cu.todus.android.uiCompose.shared.multipleList.i
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MultipleListKt.MultipleList$lambda$4$4$0$1((RoomItemView) obj);
            }
        }), ComposableLambdaKt.composableLambdaInstance(307414459, true, new lb.o() { // from class: cu.todus.android.uiCompose.shared.multipleList.j
            @Override // lb.o
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return MultipleListKt.MultipleList$lambda$4$4$0$2(lazyPagingItems, function1, function2, function3, (LazyItemScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
            }
        }));
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object MultipleList$lambda$4$4$0$0(RoomItemView r10) {
        y.i(r10, "r");
        return r10.getIdOnList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object MultipleList$lambda$4$4$0$1(RoomItemView it) {
        y.i(it, "it");
        return "item";
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 MultipleList$lambda$4$4$0$2(LazyPagingItems lazyPagingItems, Function1 function1, final Function2 function2, final Function2 function3, LazyItemScope items, int i10, Composer composer, int i11) {
        int i12;
        long jM5865copywmQWz5c$default;
        y.i(items, "$this$items");
        if ((i11 & 6) == 0) {
            i12 = i11 | (composer.changed(items) ? 4 : 2);
        } else {
            i12 = i11;
        }
        if ((i11 & 48) == 0) {
            i12 |= composer.changed(i10) ? 32 : 16;
        }
        if (composer.shouldExecute((i12 & 147) != 146, i12 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(307414459, i12, -1, "cu.todus.android.uiCompose.shared.multipleList.MultipleList.<anonymous>.<anonymous>.<anonymous>.<anonymous> (MultipleList.kt:172)");
            }
            final RoomItemView roomItemView = (RoomItemView) lazyPagingItems.get(i10);
            if (roomItemView != null) {
                composer.startReplaceGroup(1314028433);
                float f10 = 3;
                Modifier modifierM1729paddingqDBjuR0$default = PaddingKt.m1729paddingqDBjuR0$default(androidx.compose.foundation.lazy.g.c(items, Modifier.INSTANCE, null, null, null, 2, null), Dp.m8823constructorimpl(5), Dp.m8823constructorimpl(f10), 0.0f, Dp.m8823constructorimpl(f10), 4, null);
                if (((Boolean) function1.invoke(roomItemView.getRoom().getId())).booleanValue()) {
                    composer.startReplaceGroup(-1665291127);
                    jM5865copywmQWz5c$default = Color.m5865copywmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getTertiary(), 0.3f, 0.0f, 0.0f, 0.0f, 14, null);
                } else {
                    composer.startReplaceGroup(-1665292861);
                    jM5865copywmQWz5c$default = MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getBackground();
                }
                composer.endReplaceGroup();
                float f11 = 15;
                Modifier modifierM1204backgroundbw27NRU = BackgroundKt.m1204backgroundbw27NRU(modifierM1729paddingqDBjuR0$default, jM5865copywmQWz5c$default, RoundedCornerShapeKt.m2017RoundedCornerShapea9UjIt4$default(Dp.m8823constructorimpl(f11), 0.0f, 0.0f, Dp.m8823constructorimpl(f11), 6, null));
                boolean zChanged = composer.changed(function2) | composer.changed(roomItemView);
                Object objRememberedValue = composer.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.shared.multipleList.c
                        @Override // lb.a
                        public final Object invoke() {
                            return MultipleListKt.MultipleList$lambda$4$4$0$2$0$0$0(function2, roomItemView);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                lb.a aVar = (lb.a) objRememberedValue;
                boolean zChanged2 = composer.changed(function3) | composer.changed(roomItemView);
                Object objRememberedValue2 = composer.rememberedValue();
                if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.shared.multipleList.d
                        @Override // lb.a
                        public final Object invoke() {
                            return MultipleListKt.MultipleList$lambda$4$4$0$2$0$1$0(function3, roomItemView);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue2);
                }
                Modifier modifierM1250combinedClickablehoGz1lA$default = ClickableKt.m1250combinedClickablehoGz1lA$default(modifierM1204backgroundbw27NRU, false, null, null, null, aVar, null, false, null, (lb.a) objRememberedValue2, 239, null);
                composer.startReplaceGroup(-927397839);
                String name = roomItemView.getName();
                if (d0.q0(name)) {
                    name = StringResources_androidKt.stringResource(R.string.loading_hint, composer, 0);
                }
                composer.endReplaceGroup();
                RoomItemKt.SimpleRoomItem(modifierM1250combinedClickablehoGz1lA$default, name, roomItemView.getPhoto(), roomItemView.getRoom().getType(), composer, 0, 0);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-927388693);
                float f12 = 3;
                RoomItemKt.RoomItemPlaceholder(PaddingKt.m1729paddingqDBjuR0$default(Modifier.INSTANCE, Dp.m8823constructorimpl(5), Dp.m8823constructorimpl(f12), 0.0f, Dp.m8823constructorimpl(f12), 4, null), composer, 6);
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
    public static final k0 MultipleList$lambda$4$4$0$2$0$0$0(Function2 function2, RoomItemView roomItemView) {
        function2.invoke(null, roomItemView);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 MultipleList$lambda$4$4$0$2$0$1$0(Function2 function2, RoomItemView roomItemView) {
        function2.invoke(null, roomItemView);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 MultipleList$lambda$4$5$0(Function2 function2, Friend userCommon) {
        y.i(userCommon, "userCommon");
        function2.invoke(userCommon, null);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 MultipleList$lambda$4$6$0(Function2 function2, Friend userCommon) {
        y.i(userCommon, "userCommon");
        function2.invoke(userCommon, null);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String MultipleList$lambda$4$7$0(Function1 function1, Friend friend) {
        String id2;
        if (friend == null || (id2 = friend.getId()) == null) {
            id2 = "";
        }
        return ((Boolean) function1.invoke(id2)).booleanValue() ? "✅" : "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 MultipleList$lambda$5(Modifier modifier, LazyPagingItems lazyPagingItems, LazyPagingItems lazyPagingItems2, LazyPagingItems lazyPagingItems3, Function2 function2, Function2 function3, boolean z10, Function1 function1, String str, int i10, Composer composer, int i11) {
        MultipleList(modifier, lazyPagingItems, lazyPagingItems2, lazyPagingItems3, function2, function3, z10, function1, str, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1));
        return k0.f43947a;
    }
}
