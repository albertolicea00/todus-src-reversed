package cu.todus.android.uiCompose.main.screen.statusEditor.pages.ownerStatus;

import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.e3;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.LazyListStateKt;
import androidx.compose.foundation.lazy.g;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.DividerKt;
import androidx.compose.material3.IconButtonKt;
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
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.paging.compose.LazyFoundationExtensionsKt;
import androidx.paging.compose.LazyPagingItems;
import cu.todus.android.R;
import cu.todus.android.data.db.pojo.StatusWithPartnersOrRooms;
import cu.todus.android.uiCompose.main.screen.statusEditor.pages.ownerStatus.OwnerStatusKt;
import cu.todus.android.uiCompose.main.screen.statusList.StatusItemKt;
import cu.todus.android.uiCompose.shared.pagerStateIndicator.PagerStateIndicatorKt;
import cu.todus.android.uiCompose.theme.Other;
import cu.todus.android.utils.DateFormatter;
import cu.z17.views.dialogs.Z17DialogsKt;
import cu.z17.views.floatingMutilple.Z17MultipleFabObj;
import cu.z17.views.floatingMutilple.Z17MultipleFabViewKt;
import cu.z17.views.label.Z17LabelKt;
import cu.z17.views.loader.Z17SimpleCircleLoaderKt;
import defpackage.l;
import defpackage.r;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.y;
import lb.a;
import lb.o;
import ua.k0;
import va.w;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u001au\u0010\u000e\u001a\u00020\u00032\u0018\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00002\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00030\u00052\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\u0006\u0010\r\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u000e\u0010\u000f\u001aC\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\b2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\u0006\u0010\r\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0017²\u0006\u0010\u0010\u0016\u001a\u0004\u0018\u00010\b8\n@\nX\u008a\u008e\u0002"}, d2 = {"Lkotlin/Function2;", "", "", "Lua/k0;", "onPreview", "Lkotlin/Function1;", "onDelete", "Landroidx/paging/compose/LazyPagingItems;", "Lcu/todus/android/data/db/pojo/StatusWithPartnersOrRooms;", "status", "onSelect", "Lkotlin/Function0;", "onRetrySend", "ownerId", "OwnerStatus", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Landroidx/paging/compose/LazyPagingItems;Lkotlin/jvm/functions/Function1;Llb/a;Ljava/lang/String;Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/ui/Modifier;", "modifier", "item", "onClick", "OwnerStatusItem", "(Landroidx/compose/ui/Modifier;Lcu/todus/android/data/db/pojo/StatusWithPartnersOrRooms;Llb/a;Llb/a;Ljava/lang/String;Landroidx/compose/runtime/Composer;I)V", "itemToDelete", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class OwnerStatusKt {
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void OwnerStatus(final Function2 onPreview, final Function1 onDelete, final LazyPagingItems<StatusWithPartnersOrRooms> status, final Function1 onSelect, final a onRetrySend, final String ownerId, Composer composer, final int i10) {
        int i11;
        Object obj;
        y.i(onPreview, "onPreview");
        y.i(onDelete, "onDelete");
        y.i(status, "status");
        y.i(onSelect, "onSelect");
        y.i(onRetrySend, "onRetrySend");
        y.i(ownerId, "ownerId");
        Composer composerStartRestartGroup = composer.startRestartGroup(-740430078);
        if ((i10 & 6) == 0) {
            i11 = (composerStartRestartGroup.changedInstance(onPreview) ? 4 : 2) | i10;
        } else {
            i11 = i10;
        }
        if ((i10 & 48) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(onDelete) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i11 |= (i10 & 512) == 0 ? composerStartRestartGroup.changed(status) : composerStartRestartGroup.changedInstance(status) ? 256 : 128;
        }
        if ((i10 & 3072) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(onSelect) ? 2048 : 1024;
        }
        if ((i10 & 24576) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(onRetrySend) ? 16384 : 8192;
        }
        if ((196608 & i10) == 0) {
            i11 |= composerStartRestartGroup.changed(ownerId) ? 131072 : 65536;
        }
        int i12 = i11;
        if (composerStartRestartGroup.shouldExecute((74899 & i12) != 74898, i12 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-740430078, i12, -1, "cu.todus.android.uiCompose.main.screen.statusEditor.pages.ownerStatus.OwnerStatus (OwnerStatus.kt:63)");
            }
            LazyListState lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            int iA = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
            ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
            a constructor = companion2.getConstructor();
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
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion2.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl, companion2.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion2.getSetModifier());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            Composer.Companion companion3 = Composer.INSTANCE;
            if (objRememberedValue == companion3.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final MutableState mutableState = (MutableState) objRememberedValue;
            float f10 = 20;
            Modifier modifierM1727paddingVpY3zN4$default = PaddingKt.m1727paddingVpY3zN4$default(SizeKt.fillMaxHeight$default(companion, 0.0f, 1, null), Dp.m8823constructorimpl(f10), 0.0f, 2, null);
            PaddingValues paddingValuesM1718PaddingValues0680j_4 = PaddingKt.m1718PaddingValues0680j_4(Dp.m8823constructorimpl(5));
            boolean z10 = ((i12 & 896) == 256 || ((i12 & 512) != 0 && composerStartRestartGroup.changedInstance(status))) | ((57344 & i12) == 16384) | ((i12 & 14) == 4) | ((458752 & i12) == 131072);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (z10 || objRememberedValue2 == companion3.getEmpty()) {
                obj = new Function1() { // from class: g8.j
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return OwnerStatusKt.OwnerStatus$lambda$0$3$0(status, onRetrySend, onPreview, ownerId, mutableState, (LazyListScope) obj2);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(obj);
            } else {
                obj = objRememberedValue2;
            }
            LazyDslKt.LazyColumn(modifierM1727paddingVpY3zN4$default, lazyListStateRememberLazyListState, paddingValuesM1718PaddingValues0680j_4, false, null, null, null, false, null, (Function1) obj, composerStartRestartGroup, 390, TypedValues.PositionType.TYPE_PERCENT_HEIGHT);
            Modifier modifierM1725padding3ABfNKs = PaddingKt.m1725padding3ABfNKs(companion, Dp.m8823constructorimpl(f10));
            String strStringResource = StringResources_androidKt.stringResource(R.string.text, composerStartRestartGroup, 0);
            Integer numValueOf = Integer.valueOf(R.drawable.text_t);
            int i13 = i12 & 7168;
            boolean z11 = i13 == 2048;
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (z11 || objRememberedValue3 == companion3.getEmpty()) {
                objRememberedValue3 = new a() { // from class: g8.k
                    @Override // lb.a
                    public final Object invoke() {
                        return OwnerStatusKt.OwnerStatus$lambda$0$4$0(onSelect);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            Z17MultipleFabObj z17MultipleFabObj = new Z17MultipleFabObj("1", strStringResource, numValueOf, null, null, (a) objRememberedValue3, 24, null);
            String str = StringResources_androidKt.stringResource(R.string.image, composerStartRestartGroup, 0) + " - " + StringResources_androidKt.stringResource(R.string.video, composerStartRestartGroup, 0);
            Integer numValueOf2 = Integer.valueOf(R.drawable.camera_status_type);
            boolean z12 = i13 == 2048;
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (z12 || objRememberedValue4 == companion3.getEmpty()) {
                objRememberedValue4 = new a() { // from class: g8.l
                    @Override // lb.a
                    public final Object invoke() {
                        return OwnerStatusKt.OwnerStatus$lambda$0$5$0(onSelect);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            Z17MultipleFabViewKt.m10142Z17MultipleViewjA1GFJw(w.q(z17MultipleFabObj, new Z17MultipleFabObj(ExifInterface.GPS_MEASUREMENT_2D, str, numValueOf2, null, null, (a) objRememberedValue4, 24, null)), modifierM1725padding3ABfNKs, null, 0L, 0L, composerStartRestartGroup, Z17MultipleFabObj.$stable | 48, 28);
            boolean z13 = OwnerStatus$lambda$0$1(mutableState) != null;
            Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue5 == companion3.getEmpty()) {
                objRememberedValue5 = new a() { // from class: g8.m
                    @Override // lb.a
                    public final Object invoke() {
                        return OwnerStatusKt.OwnerStatus$lambda$0$6$0(mutableState);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            }
            a aVar = (a) objRememberedValue5;
            boolean z14 = (i12 & 112) == 32;
            Object objRememberedValue6 = composerStartRestartGroup.rememberedValue();
            if (z14 || objRememberedValue6 == companion3.getEmpty()) {
                objRememberedValue6 = new a() { // from class: g8.n
                    @Override // lb.a
                    public final Object invoke() {
                        return OwnerStatusKt.OwnerStatus$lambda$0$7$0(onDelete, mutableState);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
            }
            Z17DialogsKt.Z17DialogWithActions(z13, aVar, (a) objRememberedValue6, null, StringResources_androidKt.stringResource(R.string.delete_status, composerStartRestartGroup, 0), StringResources_androidKt.stringResource(R.string.u_wish_to_delete_status, composerStartRestartGroup, 0), null, null, composerStartRestartGroup, 48, 200);
            composerStartRestartGroup = composerStartRestartGroup;
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: g8.o
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return OwnerStatusKt.OwnerStatus$lambda$1(onPreview, onDelete, status, onSelect, onRetrySend, ownerId, i10, (Composer) obj2, ((Integer) obj3).intValue());
                }
            });
        }
    }

    private static final StatusWithPartnersOrRooms OwnerStatus$lambda$0$1(MutableState<StatusWithPartnersOrRooms> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 OwnerStatus$lambda$0$3$0(final LazyPagingItems lazyPagingItems, final a aVar, final Function2 function2, final String str, final MutableState mutableState, LazyListScope LazyColumn) {
        y.i(LazyColumn, "$this$LazyColumn");
        ComposableSingletons$OwnerStatusKt composableSingletons$OwnerStatusKt = ComposableSingletons$OwnerStatusKt.INSTANCE;
        LazyListScope.CC.m(LazyColumn, null, null, composableSingletons$OwnerStatusKt.getLambda$1144821149$app_productionPFast(), 3, null);
        LazyColumn.items(lazyPagingItems.getItemCount(), LazyFoundationExtensionsKt.itemKey(lazyPagingItems, new Function1() { // from class: g8.e
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return OwnerStatusKt.OwnerStatus$lambda$0$3$0$0((StatusWithPartnersOrRooms) obj);
            }
        }), LazyFoundationExtensionsKt.itemContentType(lazyPagingItems, new Function1() { // from class: g8.f
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return OwnerStatusKt.OwnerStatus$lambda$0$3$0$1((StatusWithPartnersOrRooms) obj);
            }
        }), ComposableLambdaKt.composableLambdaInstance(1301414054, true, new o() { // from class: g8.g
            @Override // lb.o
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return OwnerStatusKt.OwnerStatus$lambda$0$3$0$2(lazyPagingItems, aVar, function2, str, mutableState, (LazyItemScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
            }
        }));
        LazyListScope.CC.m(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(-1703990764, true, new Function3() { // from class: g8.h
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return OwnerStatusKt.OwnerStatus$lambda$0$3$0$3(lazyPagingItems, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }), 3, null);
        LazyListScope.CC.m(LazyColumn, null, null, composableSingletons$OwnerStatusKt.m9987getLambda$660202795$app_productionPFast(), 3, null);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object OwnerStatus$lambda$0$3$0$0(StatusWithPartnersOrRooms s10) {
        y.i(s10, "s");
        return s10.getStatus().getId() + s10.getStatus().getViewCount();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object OwnerStatus$lambda$0$3$0$1(StatusWithPartnersOrRooms i10) {
        y.i(i10, "i");
        return "item";
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 OwnerStatus$lambda$0$3$0$2(LazyPagingItems lazyPagingItems, final a aVar, final Function2 function2, String str, final MutableState mutableState, LazyItemScope items, final int i10, Composer composer, int i11) {
        int i12;
        y.i(items, "$this$items");
        if ((i11 & 6) == 0) {
            i12 = i11 | (composer.changed(items) ? 4 : 2);
        } else {
            i12 = i11;
        }
        if ((i11 & 48) == 0) {
            i12 |= composer.changed(i10) ? 32 : 16;
        }
        int i13 = i12;
        if (composer.shouldExecute((i13 & 147) != 146, i13 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1301414054, i13, -1, "cu.todus.android.uiCompose.main.screen.statusEditor.pages.ownerStatus.OwnerStatus.<anonymous>.<anonymous>.<anonymous>.<anonymous> (OwnerStatus.kt:97)");
            }
            final StatusWithPartnersOrRooms statusWithPartnersOrRooms = (StatusWithPartnersOrRooms) lazyPagingItems.get(i10);
            if (statusWithPartnersOrRooms != null) {
                composer.startReplaceGroup(-243592597);
                Modifier modifierC = g.c(items, Modifier.INSTANCE, null, null, null, 2, null);
                boolean zChanged = composer.changed(statusWithPartnersOrRooms) | composer.changed(aVar) | composer.changed(function2) | ((i13 & 112) == 32);
                Object objRememberedValue = composer.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new a() { // from class: g8.p
                        @Override // lb.a
                        public final Object invoke() {
                            return OwnerStatusKt.OwnerStatus$lambda$0$3$0$2$0$0(statusWithPartnersOrRooms, aVar, function2, i10);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                a aVar2 = (a) objRememberedValue;
                boolean zChanged2 = composer.changed(statusWithPartnersOrRooms);
                Object objRememberedValue2 = composer.rememberedValue();
                if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new a() { // from class: g8.q
                        @Override // lb.a
                        public final Object invoke() {
                            return OwnerStatusKt.OwnerStatus$lambda$0$3$0$2$1$0(statusWithPartnersOrRooms, mutableState);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue2);
                }
                OwnerStatusItem(modifierC, statusWithPartnersOrRooms, aVar2, (a) objRememberedValue2, str, composer, 0);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(823445753);
                StatusItemKt.StatusPlaceholder(composer, 0);
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
    public static final k0 OwnerStatus$lambda$0$3$0$2$0$0(StatusWithPartnersOrRooms statusWithPartnersOrRooms, a aVar, Function2 function2, int i10) {
        if (statusWithPartnersOrRooms.getStatus().getUploadState() == 3) {
            aVar.invoke();
        } else {
            function2.invoke(Integer.valueOf(i10), statusWithPartnersOrRooms.getStatus().getId());
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 OwnerStatus$lambda$0$3$0$2$1$0(StatusWithPartnersOrRooms statusWithPartnersOrRooms, MutableState mutableState) {
        mutableState.setValue(statusWithPartnersOrRooms);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    public static final k0 OwnerStatus$lambda$0$3$0$3(LazyPagingItems lazyPagingItems, LazyItemScope item, Composer composer, int i10) {
        y.i(item, "$this$item");
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1703990764, i10, -1, "cu.todus.android.uiCompose.main.screen.statusEditor.pages.ownerStatus.OwnerStatus.<anonymous>.<anonymous>.<anonymous>.<anonymous> (OwnerStatus.kt:117)");
            }
            PagerStateIndicatorKt.PagerStateIndicator(null, null, null, null, lazyPagingItems, composer, LazyPagingItems.$stable << 12, 15);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 OwnerStatus$lambda$0$4$0(Function1 function1) {
        function1.invoke(1);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 OwnerStatus$lambda$0$5$0(Function1 function1) {
        function1.invoke(2);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 OwnerStatus$lambda$0$6$0(MutableState mutableState) {
        mutableState.setValue(null);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 OwnerStatus$lambda$0$7$0(Function1 function1, MutableState mutableState) {
        StatusWithPartnersOrRooms statusWithPartnersOrRoomsOwnerStatus$lambda$0$1 = OwnerStatus$lambda$0$1(mutableState);
        y.f(statusWithPartnersOrRoomsOwnerStatus$lambda$0$1);
        function1.invoke(statusWithPartnersOrRoomsOwnerStatus$lambda$0$1.getStatus().getId());
        mutableState.setValue(null);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 OwnerStatus$lambda$1(Function2 function2, Function1 function1, LazyPagingItems lazyPagingItems, Function1 function3, a aVar, String str, int i10, Composer composer, int i11) {
        OwnerStatus(function2, function1, lazyPagingItems, function3, aVar, str, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1));
        return k0.f43947a;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x044a  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void OwnerStatusItem(final Modifier modifier, final StatusWithPartnersOrRooms item, final a onClick, final a onDelete, final String ownerId, Composer composer, final int i10) {
        int i11;
        Modifier.Companion companion;
        int i12;
        y.i(modifier, "modifier");
        y.i(item, "item");
        y.i(onClick, "onClick");
        y.i(onDelete, "onDelete");
        y.i(ownerId, "ownerId");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1085878894);
        if ((i10 & 6) == 0) {
            i11 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i10;
        } else {
            i11 = i10;
        }
        if ((i10 & 48) == 0) {
            i11 |= composerStartRestartGroup.changed(item) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(onClick) ? 256 : 128;
        }
        if ((i10 & 3072) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(onDelete) ? 2048 : 1024;
        }
        if ((i10 & 24576) == 0) {
            i11 |= composerStartRestartGroup.changed(ownerId) ? 16384 : 8192;
        }
        if (composerStartRestartGroup.shouldExecute((i11 & 9363) != 9362, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1085878894, i11, -1, "cu.todus.android.uiCompose.main.screen.statusEditor.pages.ownerStatus.OwnerStatusItem (OwnerStatus.kt:162)");
            }
            Arrangement arrangement = Arrangement.INSTANCE;
            Arrangement.Vertical top = arrangement.getTop();
            Alignment.Companion companion2 = Alignment.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(top, companion2.getStart(), composerStartRestartGroup, 0);
            int iA = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier);
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
            Modifier.Companion companion4 = Modifier.INSTANCE;
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(companion4, 0.0f, 1, null);
            boolean z10 = (i11 & 896) == 256;
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z10 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new a() { // from class: g8.d
                    @Override // lb.a
                    public final Object invoke() {
                        return OwnerStatusKt.OwnerStatusItem$lambda$0$0$0(onClick);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            Modifier modifierM1240clickableoSLSa3U$default = ClickableKt.m1240clickableoSLSa3U$default(modifierFillMaxWidth$default, false, null, null, null, (a) objRememberedValue, 15, null);
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getStart(), companion2.getCenterVertically(), composerStartRestartGroup, 48);
            int iA2 = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1240clickableoSLSa3U$default);
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
            Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyRowMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl2, Integer.valueOf(iA2), companion3.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl2, companion3.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier2, companion3.getSetModifier());
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            StatusItemKt.StatusItem(ClipKt.clip(companion4, RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(15))), item.getStatus().getContent(), true, false, false, false, 0, y.d(item.getStatus().getCreatorId(), item.getStatus().getRepliedId()) && y.d(item.getStatus().getCreatorId(), ownerId), null, composerStartRestartGroup, RendererCapabilities.DECODER_SUPPORT_MASK, 376);
            SpacerKt.Spacer(SizeKt.m1774width3ABfNKs(companion4, Dp.m8823constructorimpl(20)), composerStartRestartGroup, 6);
            if (item.getStatus().isDelete()) {
                composerStartRestartGroup.startReplaceGroup(-570393928);
                Modifier modifierA = e3.a(rowScopeInstance, companion4, 1.0f, false, 2, null);
                companion = companion4;
                Z17LabelKt.m10262Z17LabelfWhpE4E(modifierA, StringResources_androidKt.stringResource(R.string.deleting, composerStartRestartGroup, 0), null, Other.INSTANCE.m10110getError0d7_KjU(), 0, 0, composerStartRestartGroup, 0, 52);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                companion = companion4;
                if (item.getStatus().getUploadState() == 5) {
                    composerStartRestartGroup.startReplaceGroup(-570076457);
                    Z17LabelKt.m10262Z17LabelfWhpE4E(e3.a(rowScopeInstance, companion, 1.0f, false, 2, null), StringResources_androidKt.stringResource(R.string.processing, composerStartRestartGroup, 0), null, Other.INSTANCE.m10109getBlue0d7_KjU(), 0, 0, composerStartRestartGroup, 0, 52);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    if (item.getStatus().getUploadState() == 0) {
                        composerStartRestartGroup.startReplaceGroup(-569759017);
                        Modifier modifierA2 = e3.a(rowScopeInstance, companion, 1.0f, false, 2, null);
                        MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(arrangement.getTop(), companion2.getStart(), composerStartRestartGroup, 0);
                        int iA3 = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierA2);
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
                        Updater.m5184setimpl(composerM5176constructorimpl3, measurePolicyColumnMeasurePolicy2, companion3.getSetMeasurePolicy());
                        Updater.m5184setimpl(composerM5176constructorimpl3, currentCompositionLocalMap3, companion3.getSetResolvedCompositionLocals());
                        Updater.m5180initimpl(composerM5176constructorimpl3, Integer.valueOf(iA3), companion3.getSetCompositeKeyHash());
                        Updater.m5182reconcileimpl(composerM5176constructorimpl3, companion3.getApplyOnDeactivatedNodeAssertion());
                        Updater.m5184setimpl(composerM5176constructorimpl3, modifierMaterializeModifier3, companion3.getSetModifier());
                        Z17LabelKt.m10262Z17LabelfWhpE4E(null, item.getStatus().getViewCount() + " " + StringResources_androidKt.pluralStringResource(R.plurals.views, item.getStatus().getViewCount(), composerStartRestartGroup, 0), MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getTitleSmall(), 0L, 0, 0, composerStartRestartGroup, 0, 57);
                        Z17LabelKt.m10262Z17LabelfWhpE4E(null, DateFormatter.INSTANCE.prettyFormatter(item.getStatus().getCreatedAt()), null, 0L, 0, 0, composerStartRestartGroup, 0, 61);
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceGroup();
                        companion = companion;
                        i12 = 3;
                    } else if (item.getStatus().getUploadState() == 3) {
                        composerStartRestartGroup.startReplaceGroup(-569137808);
                        Modifier modifierA3 = e3.a(rowScopeInstance, companion, 1.0f, false, 2, null);
                        companion = companion;
                        Z17LabelKt.m10262Z17LabelfWhpE4E(modifierA3, StringResources_androidKt.stringResource(R.string.publishing_error, composerStartRestartGroup, 0), null, Other.INSTANCE.m10110getError0d7_KjU(), 0, 0, composerStartRestartGroup, 0, 52);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        companion = companion;
                        composerStartRestartGroup.startReplaceGroup(-568869193);
                        i12 = 3;
                        i11 = i11;
                        Z17SimpleCircleLoaderKt.m10265Z17SimpleCircleLoaderZij2fk(SizeKt.m1769size3ABfNKs(companion, Dp.m8823constructorimpl(24)), 0.0f, 0.0f, 0L, composerStartRestartGroup, 6, 14);
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    IconButtonKt.IconButton(onDelete, null, false, null, null, null, ComposableSingletons$OwnerStatusKt.INSTANCE.m9986getLambda$1877089766$app_productionPFast(), composerStartRestartGroup, ((i11 >> 9) & 14) | 1572864, 62);
                    composerStartRestartGroup.endNode();
                    SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion, Dp.m8823constructorimpl(i12)), composerStartRestartGroup, 6);
                    DividerKt.m3177HorizontalDivider9IZ8Weo(PaddingKt.m1729paddingqDBjuR0$default(companion, 0.0f, 0.0f, 0.0f, Dp.m8823constructorimpl(4), 7, null), 0.0f, 0L, composerStartRestartGroup, 6, 6);
                    composerStartRestartGroup = composerStartRestartGroup;
                    composerStartRestartGroup.endNode();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }
            i12 = 3;
            IconButtonKt.IconButton(onDelete, null, false, null, null, null, ComposableSingletons$OwnerStatusKt.INSTANCE.m9986getLambda$1877089766$app_productionPFast(), composerStartRestartGroup, ((i11 >> 9) & 14) | 1572864, 62);
            composerStartRestartGroup.endNode();
            SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion, Dp.m8823constructorimpl(i12)), composerStartRestartGroup, 6);
            DividerKt.m3177HorizontalDivider9IZ8Weo(PaddingKt.m1729paddingqDBjuR0$default(companion, 0.0f, 0.0f, 0.0f, Dp.m8823constructorimpl(4), 7, null), 0.0f, 0L, composerStartRestartGroup, 6, 6);
            composerStartRestartGroup = composerStartRestartGroup;
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: g8.i
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return OwnerStatusKt.OwnerStatusItem$lambda$1(modifier, item, onClick, onDelete, ownerId, i10, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 OwnerStatusItem$lambda$0$0$0(a aVar) {
        aVar.invoke();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 OwnerStatusItem$lambda$1(Modifier modifier, StatusWithPartnersOrRooms statusWithPartnersOrRooms, a aVar, a aVar2, String str, int i10, Composer composer, int i11) {
        OwnerStatusItem(modifier, statusWithPartnersOrRooms, aVar, aVar2, str, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1));
        return k0.f43947a;
    }
}
