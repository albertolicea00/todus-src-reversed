package cu.todus.android.uiCompose.main.screen.chat.stickers;

import android.view.View;
import android.view.ViewTreeObserver;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.LazyListStateKt;
import androidx.compose.foundation.lazy.grid.GridCells;
import androidx.compose.foundation.lazy.grid.LazyGridDslKt;
import androidx.compose.foundation.lazy.grid.LazyGridItemScope;
import androidx.compose.foundation.lazy.grid.LazyGridScope;
import androidx.compose.foundation.lazy.grid.LazyGridState;
import androidx.compose.foundation.lazy.grid.LazyGridStateKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.outlined.AddKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.paging.compose.LazyFoundationExtensionsKt;
import androidx.paging.compose.LazyPagingItems;
import cu.todus.android.R;
import cu.todus.android.data.db.entity.toDus.Sticker;
import cu.todus.android.data.db.pojo.StickerGroup;
import cu.todus.android.uiCompose.main.screen.chat.item.content.StickerContentKt;
import cu.z17.views.label.Z17LabelKt;
import cu.z17.views.picture.Z17PictureKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0003\u001au\u0010\u000f\u001a\u00020\u00072\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00002\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00070\t2\u0018\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00070\u000bH\u0007¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u000f\u0010\u0011\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\u0011\u0010\u0012\u001aY\u0010\u0014\u001a\u00020\u00072\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00070\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0018\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00070\u000bH\u0007¢\u0006\u0004\b\u0014\u0010\u0015\u001aY\u0010\u0016\u001a\u00020\u00072\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00070\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0018\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00070\u000bH\u0007¢\u0006\u0004\b\u0016\u0010\u0015\u001aY\u0010\u0017\u001a\u00020\u00072\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00002\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00070\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0018\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00070\u000bH\u0007¢\u0006\u0004\b\u0017\u0010\u0015\u001a%\u0010\u0019\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0018\u001a\u00020\rH\u0007¢\u0006\u0004\b\u0019\u0010\u001a¨\u0006\u001e²\u0006\u000e\u0010\u001c\u001a\u00020\u001b8\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\u001d\u001a\u00020\r8\n@\nX\u008a\u008e\u0002"}, d2 = {"Landroidx/paging/compose/LazyPagingItems;", "Lcu/todus/android/data/db/entity/toDus/Sticker;", "recentStickers", "favoriteStickers", "Lcu/todus/android/data/db/pojo/StickerGroup;", "allStickers", "Lkotlin/Function0;", "Lua/k0;", "openAddStickers", "Lkotlin/Function1;", "onStickerSelected", "Lkotlin/Function2;", "", "", "onChangeStickerFavoriteStatus", "GroupsContainer", "(Landroidx/paging/compose/LazyPagingItems;Landroidx/paging/compose/LazyPagingItems;Landroidx/paging/compose/LazyPagingItems;Llb/a;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "OnKeyboardClosedEffect", "(Landroidx/compose/runtime/Composer;I)V", "onClick", "RecentStickers", "(Landroidx/paging/compose/LazyPagingItems;Lkotlin/jvm/functions/Function1;Llb/a;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "FavoriteStickers", "AllStickersContainer", "show", "AddNewStickers", "(Llb/a;ZLandroidx/compose/runtime/Composer;I)V", "", "groupSelected", "showAdd", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class GroupsContainerKt {
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void AddNewStickers(final lb.a openAddStickers, boolean z10, Composer composer, final int i10) {
        int i11;
        final boolean z11;
        MutableState mutableState;
        boolean z12;
        kotlin.jvm.internal.y.i(openAddStickers, "openAddStickers");
        Composer composerStartRestartGroup = composer.startRestartGroup(1949515915);
        if ((i10 & 6) == 0) {
            i11 = i10 | (composerStartRestartGroup.changedInstance(openAddStickers) ? 4 : 2);
        } else {
            i11 = i10;
        }
        if ((i10 & 48) == 0) {
            i11 |= composerStartRestartGroup.changed(z10) ? 32 : 16;
        }
        if (composerStartRestartGroup.shouldExecute((i11 & 19) != 18, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1949515915, i11, -1, "cu.todus.android.uiCompose.main.screen.chat.stickers.AddNewStickers (GroupsContainer.kt:294)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(companion, 0.0f, 1, null);
            Alignment.Companion companion2 = Alignment.INSTANCE;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion2.getTopStart(), false);
            int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxSize$default);
            ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
            lb.a constructor = companion3.getConstructor();
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
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion3.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl, companion3.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion3.getSetModifier());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            Composer.Companion companion4 = Composer.INSTANCE;
            if (objRememberedValue == companion4.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            MutableState mutableState2 = (MutableState) objRememberedValue;
            if (AddNewStickers$lambda$0$1(mutableState2)) {
                composerStartRestartGroup.startReplaceGroup(1004075411);
                Modifier modifierFillMaxSize$default2 = SizeKt.fillMaxSize$default(companion, 0.0f, 1, null);
                boolean z13 = (i11 & 14) == 4;
                Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (z13 || objRememberedValue2 == companion4.getEmpty()) {
                    objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.stickers.k
                        @Override // lb.a
                        public final Object invoke() {
                            return GroupsContainerKt.AddNewStickers$lambda$0$3$0(openAddStickers);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                Modifier modifierM1240clickableoSLSa3U$default = ClickableKt.m1240clickableoSLSa3U$default(modifierFillMaxSize$default2, false, null, null, null, (lb.a) objRememberedValue2, 15, null);
                MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getCenter(), companion2.getCenterHorizontally(), composerStartRestartGroup, 54);
                int iA2 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1240clickableoSLSa3U$default);
                lb.a constructor2 = companion3.getConstructor();
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
                Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyColumnMeasurePolicy, companion3.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
                Updater.m5180initimpl(composerM5176constructorimpl2, Integer.valueOf(iA2), companion3.getSetCompositeKeyHash());
                Updater.m5182reconcileimpl(composerM5176constructorimpl2, companion3.getApplyOnDeactivatedNodeAssertion());
                Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier2, companion3.getSetModifier());
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                Modifier modifierM1769size3ABfNKs = SizeKt.m1769size3ABfNKs(companion, Dp.m8823constructorimpl(50));
                ImageVector add = AddKt.getAdd(Icons.Outlined.INSTANCE);
                ColorFilter.Companion companion5 = ColorFilter.INSTANCE;
                MaterialTheme materialTheme = MaterialTheme.INSTANCE;
                int i12 = MaterialTheme.$stable;
                z12 = false;
                mutableState = mutableState2;
                Z17PictureKt.m10278Z17BasePictureC8z9wKI(modifierM1769size3ABfNKs, add, null, ColorFilter.Companion.m5907tintxETnrds$default(companion5, materialTheme.getColorScheme(composerStartRestartGroup, i12).getOnBackground(), 0, 2, null), null, null, 0, null, null, composerStartRestartGroup, 6, XMPPTCPConnection.PacketWriter.QUEUE_SIZE);
                Z17LabelKt.m10262Z17LabelfWhpE4E(null, StringResources_androidKt.stringResource(R.string.add, composerStartRestartGroup, 0), materialTheme.getTypography(composerStartRestartGroup, i12).getLabelSmall(), 0L, 0, 0, composerStartRestartGroup, 0, 57);
                composerStartRestartGroup = composerStartRestartGroup;
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceGroup();
            } else {
                mutableState = mutableState2;
                z12 = false;
                composerStartRestartGroup.startReplaceGroup(1004823069);
                composerStartRestartGroup.endReplaceGroup();
            }
            Boolean boolValueOf = Boolean.valueOf(z10);
            boolean z14 = (i11 & 112) == 32 ? true : z12;
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (z14 || objRememberedValue3 == companion4.getEmpty()) {
                z11 = z10;
                objRememberedValue3 = new GroupsContainerKt$AddNewStickers$1$3$1(z11, mutableState, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            } else {
                z11 = z10;
            }
            EffectsKt.LaunchedEffect(boolValueOf, (Function2) objRememberedValue3, composerStartRestartGroup, (i11 >> 3) & 14);
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            z11 = z10;
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.stickers.m
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return GroupsContainerKt.AddNewStickers$lambda$1(openAddStickers, z11, i10, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final boolean AddNewStickers$lambda$0$1(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void AddNewStickers$lambda$0$2(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 AddNewStickers$lambda$0$3$0(lb.a aVar) {
        aVar.invoke();
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 AddNewStickers$lambda$1(lb.a aVar, boolean z10, int i10, Composer composer, int i11) {
        AddNewStickers(aVar, z10, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1));
        return ua.k0.f43947a;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void AllStickersContainer(final LazyPagingItems<StickerGroup> allStickers, final Function1 onClick, final lb.a openAddStickers, final Function2 onChangeStickerFavoriteStatus, Composer composer, final int i10) {
        int i11;
        kotlin.jvm.internal.y.i(allStickers, "allStickers");
        kotlin.jvm.internal.y.i(onClick, "onClick");
        kotlin.jvm.internal.y.i(openAddStickers, "openAddStickers");
        kotlin.jvm.internal.y.i(onChangeStickerFavoriteStatus, "onChangeStickerFavoriteStatus");
        Composer composerStartRestartGroup = composer.startRestartGroup(740417075);
        if ((i10 & 6) == 0) {
            i11 = ((i10 & 8) == 0 ? composerStartRestartGroup.changed(allStickers) : composerStartRestartGroup.changedInstance(allStickers) ? 4 : 2) | i10;
        } else {
            i11 = i10;
        }
        if ((i10 & 48) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(onClick) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(openAddStickers) ? 256 : 128;
        }
        if ((i10 & 3072) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(onChangeStickerFavoriteStatus) ? 2048 : 1024;
        }
        if (composerStartRestartGroup.shouldExecute((i11 & 1171) != 1170, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(740417075, i11, -1, "cu.todus.android.uiCompose.main.screen.chat.stickers.AllStickersContainer (GroupsContainer.kt:238)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
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
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion2.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl, companion2.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion2.getSetModifier());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            LazyListState lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
            PaddingValues paddingValuesM1718PaddingValues0680j_4 = PaddingKt.m1718PaddingValues0680j_4(Dp.m8823constructorimpl(5));
            boolean z10 = ((i11 & 14) == 4 || ((i11 & 8) != 0 && composerStartRestartGroup.changedInstance(allStickers))) | ((i11 & 112) == 32) | ((i11 & 896) == 256) | ((i11 & 7168) == 2048);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z10 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.stickers.x
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return GroupsContainerKt.AllStickersContainer$lambda$0$0$0(allStickers, onClick, openAddStickers, onChangeStickerFavoriteStatus, (LazyListScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            int i12 = i11;
            LazyDslKt.LazyColumn(null, lazyListStateRememberLazyListState, paddingValuesM1718PaddingValues0680j_4, false, null, null, null, false, null, (Function1) objRememberedValue, composerStartRestartGroup, RendererCapabilities.DECODER_SUPPORT_MASK, TypedValues.PositionType.TYPE_SIZE_PERCENT);
            composerStartRestartGroup = composerStartRestartGroup;
            AddNewStickers(openAddStickers, allStickers.getItemCount() == 0, composerStartRestartGroup, (i12 >> 6) & 14);
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.stickers.y
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return GroupsContainerKt.AllStickersContainer$lambda$1(allStickers, onClick, openAddStickers, onChangeStickerFavoriteStatus, i10, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 AllStickersContainer$lambda$0$0$0(final LazyPagingItems lazyPagingItems, final Function1 function1, final lb.a aVar, final Function2 function2, LazyListScope LazyColumn) {
        kotlin.jvm.internal.y.i(LazyColumn, "$this$LazyColumn");
        LazyColumn.items(lazyPagingItems.getItemCount(), LazyFoundationExtensionsKt.itemKey(lazyPagingItems, new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.stickers.s
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return GroupsContainerKt.AllStickersContainer$lambda$0$0$0$0((StickerGroup) obj);
            }
        }), LazyFoundationExtensionsKt.itemContentType(lazyPagingItems, new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.stickers.t
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return GroupsContainerKt.AllStickersContainer$lambda$0$0$0$1((StickerGroup) obj);
            }
        }), ComposableLambdaKt.composableLambdaInstance(-523399665, true, new lb.o() { // from class: cu.todus.android.uiCompose.main.screen.chat.stickers.u
            @Override // lb.o
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return GroupsContainerKt.AllStickersContainer$lambda$0$0$0$2(lazyPagingItems, function1, aVar, function2, (LazyItemScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
            }
        }));
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object AllStickersContainer$lambda$0$0$0$0(StickerGroup s10) {
        kotlin.jvm.internal.y.i(s10, "s");
        return s10.getStickerPack().getName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object AllStickersContainer$lambda$0$0$0$1(StickerGroup it) {
        kotlin.jvm.internal.y.i(it, "it");
        return "sticker";
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 AllStickersContainer$lambda$0$0$0$2(LazyPagingItems lazyPagingItems, final Function1 function1, final lb.a aVar, final Function2 function2, LazyItemScope items, int i10, Composer composer, int i11) {
        int i12;
        kotlin.jvm.internal.y.i(items, "$this$items");
        if ((i11 & 48) == 0) {
            i12 = i11 | (composer.changed(i10) ? 32 : 16);
        } else {
            i12 = i11;
        }
        if (composer.shouldExecute((i12 & 145) != 144, i12 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-523399665, i12, -1, "cu.todus.android.uiCompose.main.screen.chat.stickers.AllStickersContainer.<anonymous>.<anonymous>.<anonymous>.<anonymous> (GroupsContainer.kt:251)");
            }
            final StickerGroup stickerGroup = (StickerGroup) lazyPagingItems.get(i10);
            if (stickerGroup != null) {
                composer.startReplaceGroup(-1868017609);
                LazyListState lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composer, 0, 3);
                PaddingValues paddingValuesM1718PaddingValues0680j_4 = PaddingKt.m1718PaddingValues0680j_4(Dp.m8823constructorimpl(5));
                boolean zChanged = composer.changed(stickerGroup) | composer.changed(function1) | composer.changed(aVar) | composer.changed(function2);
                Object objRememberedValue = composer.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.stickers.b0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return GroupsContainerKt.AllStickersContainer$lambda$0$0$0$2$0$0(stickerGroup, function1, aVar, function2, (LazyListScope) obj);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                LazyDslKt.LazyRow(null, lazyListStateRememberLazyListState, paddingValuesM1718PaddingValues0680j_4, false, null, null, null, false, null, (Function1) objRememberedValue, composer, RendererCapabilities.DECODER_SUPPORT_MASK, TypedValues.PositionType.TYPE_SIZE_PERCENT);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-1866813724);
                StickerContentKt.StickerPlaceholder(Modifier.INSTANCE, composer, 6);
                composer.endReplaceGroup();
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
    public static final ua.k0 AllStickersContainer$lambda$0$0$0$2$0$0(final StickerGroup stickerGroup, final Function1 function1, final lb.a aVar, final Function2 function2, LazyListScope LazyRow) {
        kotlin.jvm.internal.y.i(LazyRow, "$this$LazyRow");
        LazyListScope.CC.o(LazyRow, stickerGroup.getItems().size(), null, null, ComposableLambdaKt.composableLambdaInstance(413856000, true, new lb.o() { // from class: cu.todus.android.uiCompose.main.screen.chat.stickers.b
            @Override // lb.o
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return GroupsContainerKt.AllStickersContainer$lambda$0$0$0$2$0$0$0(stickerGroup, function1, aVar, function2, (LazyItemScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 6, null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 AllStickersContainer$lambda$0$0$0$2$0$0$0(StickerGroup stickerGroup, final Function1 function1, final lb.a aVar, Function2 function2, LazyItemScope items, int i10, Composer composer, int i11) {
        int i12;
        kotlin.jvm.internal.y.i(items, "$this$items");
        if ((i11 & 48) == 0) {
            i12 = i11 | (composer.changed(i10) ? 32 : 16);
        } else {
            i12 = i11;
        }
        if (composer.shouldExecute((i12 & 145) != 144, i12 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(413856000, i12, -1, "cu.todus.android.uiCompose.main.screen.chat.stickers.AllStickersContainer.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (GroupsContainer.kt:263)");
            }
            final Sticker sticker = stickerGroup.getItems().get(i10);
            Modifier modifierM1769size3ABfNKs = SizeKt.m1769size3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(80));
            String url = sticker.getUrl();
            boolean favorite = sticker.getFavorite();
            String id2 = sticker.getId();
            boolean zChanged = composer.changed(function1) | composer.changed(sticker);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.stickers.h
                    @Override // lb.a
                    public final Object invoke() {
                        return GroupsContainerKt.AllStickersContainer$lambda$0$0$0$2$0$0$0$0$0(function1, sticker);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            lb.a aVar2 = (lb.a) objRememberedValue;
            Object objRememberedValue2 = composer.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.stickers.i
                    @Override // lb.a
                    public final Object invoke() {
                        return ua.k0.f43947a;
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            lb.a aVar3 = (lb.a) objRememberedValue2;
            boolean zChanged2 = composer.changed(aVar);
            Object objRememberedValue3 = composer.rememberedValue();
            if (zChanged2 || objRememberedValue3 == companion.getEmpty()) {
                objRememberedValue3 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.stickers.j
                    @Override // lb.a
                    public final Object invoke() {
                        return GroupsContainerKt.AllStickersContainer$lambda$0$0$0$2$0$0$0$2$0(aVar);
                    }
                };
                composer.updateRememberedValue(objRememberedValue3);
            }
            StickerContentKt.StickerViewForList(modifierM1769size3ABfNKs, aVar2, aVar3, (lb.a) objRememberedValue3, id2, url, favorite, function2, composer, 390, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 AllStickersContainer$lambda$0$0$0$2$0$0$0$0$0(Function1 function1, Sticker sticker) {
        function1.invoke(sticker);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 AllStickersContainer$lambda$0$0$0$2$0$0$0$2$0(lb.a aVar) {
        aVar.invoke();
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 AllStickersContainer$lambda$1(LazyPagingItems lazyPagingItems, Function1 function1, lb.a aVar, Function2 function2, int i10, Composer composer, int i11) {
        AllStickersContainer(lazyPagingItems, function1, aVar, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1));
        return ua.k0.f43947a;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void FavoriteStickers(final LazyPagingItems<Sticker> favoriteStickers, final Function1 onClick, final lb.a openAddStickers, final Function2 onChangeStickerFavoriteStatus, Composer composer, final int i10) {
        int i11;
        kotlin.jvm.internal.y.i(favoriteStickers, "favoriteStickers");
        kotlin.jvm.internal.y.i(onClick, "onClick");
        kotlin.jvm.internal.y.i(openAddStickers, "openAddStickers");
        kotlin.jvm.internal.y.i(onChangeStickerFavoriteStatus, "onChangeStickerFavoriteStatus");
        Composer composerStartRestartGroup = composer.startRestartGroup(1795548955);
        if ((i10 & 6) == 0) {
            i11 = ((i10 & 8) == 0 ? composerStartRestartGroup.changed(favoriteStickers) : composerStartRestartGroup.changedInstance(favoriteStickers) ? 4 : 2) | i10;
        } else {
            i11 = i10;
        }
        if ((i10 & 48) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(onClick) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(openAddStickers) ? 256 : 128;
        }
        if ((i10 & 3072) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(onChangeStickerFavoriteStatus) ? 2048 : 1024;
        }
        if (composerStartRestartGroup.shouldExecute((i11 & 1171) != 1170, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1795548955, i11, -1, "cu.todus.android.uiCompose.main.screen.chat.stickers.FavoriteStickers (GroupsContainer.kt:193)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
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
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion2.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl, companion2.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion2.getSetModifier());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            LazyGridState lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
            GridCells.Fixed fixed = new GridCells.Fixed(3);
            boolean z10 = ((i11 & 14) == 4 || ((i11 & 8) != 0 && composerStartRestartGroup.changedInstance(favoriteStickers))) | ((i11 & 112) == 32) | ((i11 & 896) == 256) | ((i11 & 7168) == 2048);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z10 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.stickers.z
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return GroupsContainerKt.FavoriteStickers$lambda$0$0$0(favoriteStickers, onClick, openAddStickers, onChangeStickerFavoriteStatus, (LazyGridScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            int i12 = i11;
            LazyGridDslKt.LazyVerticalGrid(fixed, null, lazyGridStateRememberLazyGridState, null, false, null, null, null, false, null, (Function1) objRememberedValue, composerStartRestartGroup, 0, 0, 1018);
            composerStartRestartGroup = composerStartRestartGroup;
            AddNewStickers(openAddStickers, favoriteStickers.getItemCount() == 0, composerStartRestartGroup, (i12 >> 6) & 14);
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.stickers.a0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return GroupsContainerKt.FavoriteStickers$lambda$1(favoriteStickers, onClick, openAddStickers, onChangeStickerFavoriteStatus, i10, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 FavoriteStickers$lambda$0$0$0(final LazyPagingItems lazyPagingItems, final Function1 function1, final lb.a aVar, final Function2 function2, LazyGridScope LazyVerticalGrid) {
        kotlin.jvm.internal.y.i(LazyVerticalGrid, "$this$LazyVerticalGrid");
        LazyGridScope.CC.b(LazyVerticalGrid, lazyPagingItems.getItemCount(), LazyFoundationExtensionsKt.itemKey(lazyPagingItems, new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.stickers.p
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return GroupsContainerKt.FavoriteStickers$lambda$0$0$0$0((Sticker) obj);
            }
        }), null, LazyFoundationExtensionsKt.itemContentType(lazyPagingItems, new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.stickers.q
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return GroupsContainerKt.FavoriteStickers$lambda$0$0$0$1((Sticker) obj);
            }
        }), ComposableLambdaKt.composableLambdaInstance(-1245424144, true, new lb.o() { // from class: cu.todus.android.uiCompose.main.screen.chat.stickers.r
            @Override // lb.o
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return GroupsContainerKt.FavoriteStickers$lambda$0$0$0$2(lazyPagingItems, function1, aVar, function2, (LazyGridItemScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 4, null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object FavoriteStickers$lambda$0$0$0$0(Sticker s10) {
        kotlin.jvm.internal.y.i(s10, "s");
        return s10.getId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object FavoriteStickers$lambda$0$0$0$1(Sticker it) {
        kotlin.jvm.internal.y.i(it, "it");
        return "sticker";
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 FavoriteStickers$lambda$0$0$0$2(LazyPagingItems lazyPagingItems, final Function1 function1, final lb.a aVar, Function2 function2, LazyGridItemScope items, int i10, Composer composer, int i11) {
        int i12;
        kotlin.jvm.internal.y.i(items, "$this$items");
        if ((i11 & 48) == 0) {
            i12 = i11 | (composer.changed(i10) ? 32 : 16);
        } else {
            i12 = i11;
        }
        if (composer.shouldExecute((i12 & 145) != 144, i12 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1245424144, i12, -1, "cu.todus.android.uiCompose.main.screen.chat.stickers.FavoriteStickers.<anonymous>.<anonymous>.<anonymous>.<anonymous> (GroupsContainer.kt:203)");
            }
            final Sticker sticker = (Sticker) lazyPagingItems.get(i10);
            if (sticker != null) {
                composer.startReplaceGroup(1791922629);
                Modifier modifierM1769size3ABfNKs = SizeKt.m1769size3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(80));
                String url = sticker.getUrl();
                boolean favorite = sticker.getFavorite();
                String id2 = sticker.getId();
                boolean zChanged = composer.changed(function1) | composer.changed(sticker);
                Object objRememberedValue = composer.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.stickers.a
                        @Override // lb.a
                        public final Object invoke() {
                            return GroupsContainerKt.FavoriteStickers$lambda$0$0$0$2$0$0(function1, sticker);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                lb.a aVar2 = (lb.a) objRememberedValue;
                Object objRememberedValue2 = composer.rememberedValue();
                Composer.Companion companion = Composer.INSTANCE;
                if (objRememberedValue2 == companion.getEmpty()) {
                    objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.stickers.l
                        @Override // lb.a
                        public final Object invoke() {
                            return ua.k0.f43947a;
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue2);
                }
                lb.a aVar3 = (lb.a) objRememberedValue2;
                boolean zChanged2 = composer.changed(aVar);
                Object objRememberedValue3 = composer.rememberedValue();
                if (zChanged2 || objRememberedValue3 == companion.getEmpty()) {
                    objRememberedValue3 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.stickers.w
                        @Override // lb.a
                        public final Object invoke() {
                            return GroupsContainerKt.FavoriteStickers$lambda$0$0$0$2$2$0(aVar);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue3);
                }
                StickerContentKt.StickerViewForList(modifierM1769size3ABfNKs, aVar2, aVar3, (lb.a) objRememberedValue3, id2, url, favorite, function2, composer, 390, 0);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(1792576419);
                StickerContentKt.StickerPlaceholder(Modifier.INSTANCE, composer, 6);
                composer.endReplaceGroup();
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
    public static final ua.k0 FavoriteStickers$lambda$0$0$0$2$0$0(Function1 function1, Sticker sticker) {
        function1.invoke(sticker);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 FavoriteStickers$lambda$0$0$0$2$2$0(lb.a aVar) {
        aVar.invoke();
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 FavoriteStickers$lambda$1(LazyPagingItems lazyPagingItems, Function1 function1, lb.a aVar, Function2 function2, int i10, Composer composer, int i11) {
        FavoriteStickers(lazyPagingItems, function1, aVar, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1));
        return ua.k0.f43947a;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void GroupsContainer(final LazyPagingItems<Sticker> recentStickers, final LazyPagingItems<Sticker> favoriteStickers, final LazyPagingItems<StickerGroup> allStickers, final lb.a openAddStickers, final Function1 onStickerSelected, final Function2 onChangeStickerFavoriteStatus, Composer composer, final int i10) {
        int i11;
        Composer composer2;
        kotlin.jvm.internal.y.i(recentStickers, "recentStickers");
        kotlin.jvm.internal.y.i(favoriteStickers, "favoriteStickers");
        kotlin.jvm.internal.y.i(allStickers, "allStickers");
        kotlin.jvm.internal.y.i(openAddStickers, "openAddStickers");
        kotlin.jvm.internal.y.i(onStickerSelected, "onStickerSelected");
        kotlin.jvm.internal.y.i(onChangeStickerFavoriteStatus, "onChangeStickerFavoriteStatus");
        Composer composerStartRestartGroup = composer.startRestartGroup(1615957410);
        if ((i10 & 6) == 0) {
            i11 = ((i10 & 8) == 0 ? composerStartRestartGroup.changed(recentStickers) : composerStartRestartGroup.changedInstance(recentStickers) ? 4 : 2) | i10;
        } else {
            i11 = i10;
        }
        if ((i10 & 48) == 0) {
            i11 |= (i10 & 64) == 0 ? composerStartRestartGroup.changed(favoriteStickers) : composerStartRestartGroup.changedInstance(favoriteStickers) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i11 |= (i10 & 512) == 0 ? composerStartRestartGroup.changed(allStickers) : composerStartRestartGroup.changedInstance(allStickers) ? 256 : 128;
        }
        if ((i10 & 3072) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(openAddStickers) ? 2048 : 1024;
        }
        if ((i10 & 24576) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(onStickerSelected) ? 16384 : 8192;
        }
        if ((196608 & i10) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(onChangeStickerFavoriteStatus) ? 131072 : 65536;
        }
        if (composerStartRestartGroup.shouldExecute((74899 & i11) != 74898, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1615957410, i11, -1, "cu.todus.android.uiCompose.main.screen.chat.stickers.GroupsContainer (GroupsContainer.kt:60)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            Modifier modifierM1205backgroundbw27NRU$default = BackgroundKt.m1205backgroundbw27NRU$default(SizeKt.m1755height3ABfNKs(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), Dp.m8823constructorimpl(250)), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground(), null, 2, null);
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getCenterHorizontally(), composerStartRestartGroup, 48);
            int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1205backgroundbw27NRU$default);
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
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            Composer.Companion companion3 = Composer.INSTANCE;
            if (objRememberedValue == companion3.getEmpty()) {
                objRememberedValue = SnapshotIntStateKt.mutableIntStateOf(0);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final MutableIntState mutableIntState = (MutableIntState) objRememberedValue;
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == companion3.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.stickers.f
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return GroupsContainerKt.GroupsContainer$lambda$0$3$0(mutableIntState, ((Integer) obj).intValue());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            TripleChipKt.TripleChip((Function1) objRememberedValue2, mutableIntState.getIntValue(), composerStartRestartGroup, 6);
            SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion, Dp.m8823constructorimpl(2)), composerStartRestartGroup, 6);
            int intValue = mutableIntState.getIntValue();
            if (intValue == 0) {
                composer2 = composerStartRestartGroup;
                composer2.startReplaceGroup(-994978854);
                RecentStickers(recentStickers, onStickerSelected, openAddStickers, onChangeStickerFavoriteStatus, composer2, LazyPagingItems.$stable | (i11 & 14) | ((i11 >> 9) & 112) | ((i11 >> 3) & 896) | ((i11 >> 6) & 7168));
                composer2.endReplaceGroup();
            } else if (intValue == 1) {
                composerStartRestartGroup.startReplaceGroup(-994658252);
                int i12 = i11 >> 3;
                FavoriteStickers(favoriteStickers, onStickerSelected, openAddStickers, onChangeStickerFavoriteStatus, composerStartRestartGroup, LazyPagingItems.$stable | (i12 & 14) | ((i11 >> 9) & 112) | (i12 & 896) | ((i11 >> 6) & 7168));
                composer2 = composerStartRestartGroup;
                composer2.endReplaceGroup();
            } else if (intValue != 2) {
                composerStartRestartGroup.startReplaceGroup(-994030006);
                composerStartRestartGroup.endReplaceGroup();
                composer2 = composerStartRestartGroup;
            } else {
                composerStartRestartGroup.startReplaceGroup(-994332070);
                int i13 = i11 >> 6;
                AllStickersContainer(allStickers, onStickerSelected, openAddStickers, onChangeStickerFavoriteStatus, composerStartRestartGroup, LazyPagingItems.$stable | (i13 & 14) | ((i11 >> 9) & 112) | ((i11 >> 3) & 896) | (i13 & 7168));
                composer2 = composerStartRestartGroup;
                composer2.endReplaceGroup();
            }
            OnKeyboardClosedEffect(composer2, 0);
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.stickers.g
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return GroupsContainerKt.GroupsContainer$lambda$1(recentStickers, favoriteStickers, allStickers, openAddStickers, onStickerSelected, onChangeStickerFavoriteStatus, i10, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 GroupsContainer$lambda$0$3$0(MutableIntState mutableIntState, int i10) {
        mutableIntState.setIntValue(i10);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 GroupsContainer$lambda$1(LazyPagingItems lazyPagingItems, LazyPagingItems lazyPagingItems2, LazyPagingItems lazyPagingItems3, lb.a aVar, Function1 function1, Function2 function2, int i10, Composer composer, int i11) {
        GroupsContainer(lazyPagingItems, lazyPagingItems2, lazyPagingItems3, aVar, function1, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1));
        return ua.k0.f43947a;
    }

    @Composable
    public static final void OnKeyboardClosedEffect(Composer composer, final int i10) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-1587024525);
        if (composerStartRestartGroup.shouldExecute(i10 != 0, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1587024525, i10, -1, "cu.todus.android.uiCompose.main.screen.chat.stickers.OnKeyboardClosedEffect (GroupsContainer.kt:110)");
            }
            final View view = (View) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalView());
            final ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            final SoftwareKeyboardController softwareKeyboardController = (SoftwareKeyboardController) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalSoftwareKeyboardController());
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(view) | composerStartRestartGroup.changed(softwareKeyboardController) | composerStartRestartGroup.changedInstance(viewTreeObserver);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.stickers.n
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return GroupsContainerKt.OnKeyboardClosedEffect$lambda$0$0(viewTreeObserver, view, softwareKeyboardController, (DisposableEffectScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            EffectsKt.DisposableEffect(viewTreeObserver, (Function1) objRememberedValue, composerStartRestartGroup, 0);
            ua.k0 k0Var = ua.k0.f43947a;
            boolean zChanged = composerStartRestartGroup.changed(softwareKeyboardController);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new GroupsContainerKt$OnKeyboardClosedEffect$2$1(softwareKeyboardController, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            EffectsKt.LaunchedEffect(k0Var, (Function2) objRememberedValue2, composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.stickers.o
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return GroupsContainerKt.OnKeyboardClosedEffect$lambda$2(i10, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult OnKeyboardClosedEffect$lambda$0$0(final ViewTreeObserver viewTreeObserver, final View view, final SoftwareKeyboardController softwareKeyboardController, DisposableEffectScope DisposableEffect) {
        kotlin.jvm.internal.y.i(DisposableEffect, "$this$DisposableEffect");
        final ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: cu.todus.android.uiCompose.main.screen.chat.stickers.v
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                GroupsContainerKt.OnKeyboardClosedEffect$lambda$0$0$0(view, softwareKeyboardController);
            }
        };
        viewTreeObserver.addOnGlobalLayoutListener(onGlobalLayoutListener);
        return new DisposableEffectResult() { // from class: cu.todus.android.uiCompose.main.screen.chat.stickers.GroupsContainerKt$OnKeyboardClosedEffect$lambda$0$0$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                viewTreeObserver.removeOnGlobalLayoutListener(onGlobalLayoutListener);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void OnKeyboardClosedEffect$lambda$0$0$0(View view, SoftwareKeyboardController softwareKeyboardController) {
        WindowInsetsCompat rootWindowInsets = ViewCompat.getRootWindowInsets(view);
        if (!(rootWindowInsets != null ? rootWindowInsets.isVisible(WindowInsetsCompat.Type.ime()) : true) || softwareKeyboardController == null) {
            return;
        }
        softwareKeyboardController.hide();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 OnKeyboardClosedEffect$lambda$2(int i10, Composer composer, int i11) {
        OnKeyboardClosedEffect(composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1));
        return ua.k0.f43947a;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void RecentStickers(final LazyPagingItems<Sticker> recentStickers, final Function1 onClick, final lb.a openAddStickers, final Function2 onChangeStickerFavoriteStatus, Composer composer, final int i10) {
        int i11;
        kotlin.jvm.internal.y.i(recentStickers, "recentStickers");
        kotlin.jvm.internal.y.i(onClick, "onClick");
        kotlin.jvm.internal.y.i(openAddStickers, "openAddStickers");
        kotlin.jvm.internal.y.i(onChangeStickerFavoriteStatus, "onChangeStickerFavoriteStatus");
        Composer composerStartRestartGroup = composer.startRestartGroup(192962778);
        if ((i10 & 6) == 0) {
            i11 = ((i10 & 8) == 0 ? composerStartRestartGroup.changed(recentStickers) : composerStartRestartGroup.changedInstance(recentStickers) ? 4 : 2) | i10;
        } else {
            i11 = i10;
        }
        if ((i10 & 48) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(onClick) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(openAddStickers) ? 256 : 128;
        }
        if ((i10 & 3072) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(onChangeStickerFavoriteStatus) ? 2048 : 1024;
        }
        if (composerStartRestartGroup.shouldExecute((i11 & 1171) != 1170, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(192962778, i11, -1, "cu.todus.android.uiCompose.main.screen.chat.stickers.RecentStickers (GroupsContainer.kt:140)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
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
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion2.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl, companion2.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion2.getSetModifier());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            LazyGridState lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
            GridCells.Fixed fixed = new GridCells.Fixed(3);
            boolean z10 = ((i11 & 896) == 256) | ((i11 & 14) == 4 || ((i11 & 8) != 0 && composerStartRestartGroup.changedInstance(recentStickers))) | ((i11 & 112) == 32) | ((i11 & 7168) == 2048);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z10 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.stickers.g0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return GroupsContainerKt.RecentStickers$lambda$0$0$0(recentStickers, openAddStickers, onClick, onChangeStickerFavoriteStatus, (LazyGridScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            int i12 = i11;
            LazyGridDslKt.LazyVerticalGrid(fixed, null, lazyGridStateRememberLazyGridState, null, false, null, null, null, false, null, (Function1) objRememberedValue, composerStartRestartGroup, 0, 0, 1018);
            composerStartRestartGroup = composerStartRestartGroup;
            AddNewStickers(openAddStickers, recentStickers.getItemCount() == 0, composerStartRestartGroup, (i12 >> 6) & 14);
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.stickers.h0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return GroupsContainerKt.RecentStickers$lambda$1(recentStickers, onClick, openAddStickers, onChangeStickerFavoriteStatus, i10, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 RecentStickers$lambda$0$0$0(final LazyPagingItems lazyPagingItems, final lb.a aVar, final Function1 function1, final Function2 function2, LazyGridScope LazyVerticalGrid) {
        kotlin.jvm.internal.y.i(LazyVerticalGrid, "$this$LazyVerticalGrid");
        LazyGridScope.CC.a(LazyVerticalGrid, null, null, null, ComposableLambdaKt.composableLambdaInstance(652898376, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.chat.stickers.c0
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return GroupsContainerKt.RecentStickers$lambda$0$0$0$0(aVar, lazyPagingItems, (LazyGridItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }), 7, null);
        LazyGridScope.CC.b(LazyVerticalGrid, lazyPagingItems.getItemCount(), LazyFoundationExtensionsKt.itemKey(lazyPagingItems, new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.stickers.d0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return GroupsContainerKt.RecentStickers$lambda$0$0$0$1((Sticker) obj);
            }
        }), null, LazyFoundationExtensionsKt.itemContentType(lazyPagingItems, new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.stickers.e0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return GroupsContainerKt.RecentStickers$lambda$0$0$0$2((Sticker) obj);
            }
        }), ComposableLambdaKt.composableLambdaInstance(793149679, true, new lb.o() { // from class: cu.todus.android.uiCompose.main.screen.chat.stickers.f0
            @Override // lb.o
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return GroupsContainerKt.RecentStickers$lambda$0$0$0$3(lazyPagingItems, function1, aVar, function2, (LazyGridItemScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 4, null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 RecentStickers$lambda$0$0$0$0(lb.a aVar, LazyPagingItems lazyPagingItems, LazyGridItemScope item, Composer composer, int i10) {
        kotlin.jvm.internal.y.i(item, "$this$item");
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(652898376, i10, -1, "cu.todus.android.uiCompose.main.screen.chat.stickers.RecentStickers.<anonymous>.<anonymous>.<anonymous>.<anonymous> (GroupsContainer.kt:146)");
            }
            AddNewStickers(aVar, lazyPagingItems.getItemCount() != 0, composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object RecentStickers$lambda$0$0$0$1(Sticker s10) {
        kotlin.jvm.internal.y.i(s10, "s");
        return s10.getId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object RecentStickers$lambda$0$0$0$2(Sticker it) {
        kotlin.jvm.internal.y.i(it, "it");
        return "sticker";
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 RecentStickers$lambda$0$0$0$3(LazyPagingItems lazyPagingItems, final Function1 function1, final lb.a aVar, Function2 function2, LazyGridItemScope items, int i10, Composer composer, int i11) {
        int i12;
        kotlin.jvm.internal.y.i(items, "$this$items");
        if ((i11 & 48) == 0) {
            i12 = i11 | (composer.changed(i10) ? 32 : 16);
        } else {
            i12 = i11;
        }
        if (composer.shouldExecute((i12 & 145) != 144, i12 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(793149679, i12, -1, "cu.todus.android.uiCompose.main.screen.chat.stickers.RecentStickers.<anonymous>.<anonymous>.<anonymous>.<anonymous> (GroupsContainer.kt:158)");
            }
            final Sticker sticker = (Sticker) lazyPagingItems.get(i10);
            if (sticker != null) {
                composer.startReplaceGroup(2107117190);
                Modifier modifierM1769size3ABfNKs = SizeKt.m1769size3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(80));
                String url = sticker.getUrl();
                boolean favorite = sticker.getFavorite();
                String id2 = sticker.getId();
                boolean zChanged = composer.changed(function1) | composer.changed(sticker);
                Object objRememberedValue = composer.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.stickers.c
                        @Override // lb.a
                        public final Object invoke() {
                            return GroupsContainerKt.RecentStickers$lambda$0$0$0$3$0$0(function1, sticker);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                lb.a aVar2 = (lb.a) objRememberedValue;
                Object objRememberedValue2 = composer.rememberedValue();
                Composer.Companion companion = Composer.INSTANCE;
                if (objRememberedValue2 == companion.getEmpty()) {
                    objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.stickers.d
                        @Override // lb.a
                        public final Object invoke() {
                            return ua.k0.f43947a;
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue2);
                }
                lb.a aVar3 = (lb.a) objRememberedValue2;
                boolean zChanged2 = composer.changed(aVar);
                Object objRememberedValue3 = composer.rememberedValue();
                if (zChanged2 || objRememberedValue3 == companion.getEmpty()) {
                    objRememberedValue3 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.stickers.e
                        @Override // lb.a
                        public final Object invoke() {
                            return GroupsContainerKt.RecentStickers$lambda$0$0$0$3$2$0(aVar);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue3);
                }
                StickerContentKt.StickerViewForList(modifierM1769size3ABfNKs, aVar2, aVar3, (lb.a) objRememberedValue3, id2, url, favorite, function2, composer, 390, 0);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(2107770980);
                StickerContentKt.StickerPlaceholder(Modifier.INSTANCE, composer, 6);
                composer.endReplaceGroup();
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
    public static final ua.k0 RecentStickers$lambda$0$0$0$3$0$0(Function1 function1, Sticker sticker) {
        function1.invoke(sticker);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 RecentStickers$lambda$0$0$0$3$2$0(lb.a aVar) {
        aVar.invoke();
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 RecentStickers$lambda$1(LazyPagingItems lazyPagingItems, Function1 function1, lb.a aVar, Function2 function2, int i10, Composer composer, int i11) {
        RecentStickers(lazyPagingItems, function1, aVar, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1));
        return ua.k0.f43947a;
    }
}
