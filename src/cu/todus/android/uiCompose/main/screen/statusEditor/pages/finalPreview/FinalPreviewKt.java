package cu.todus.android.uiCompose.main.screen.statusEditor.pages.finalPreview;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
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
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.LazyListStateKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.automirrored.outlined.KeyboardArrowRightKt;
import androidx.compose.material.icons.outlined.ClearKt;
import androidx.compose.material.icons.outlined.PeopleAltKt;
import androidx.compose.material3.DividerKt;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.MaterialTheme;
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
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.p001lifecycle.Lifecycle;
import androidx.p001lifecycle.LifecycleOwner;
import androidx.p001lifecycle.p002compose.FlowExtKt;
import androidx.paging.compose.LazyFoundationExtensionsKt;
import androidx.paging.compose.LazyPagingItems;
import androidx.paging.compose.LazyPagingItemsKt;
import cu.todus.android.R;
import cu.todus.android.data.db.entity.toDus.Status;
import cu.todus.android.data.db.pojo.Partner;
import cu.todus.android.data.db.pojo.content.Content;
import cu.todus.android.data.db.pojo.content.statusContent.StatusImageContent;
import cu.todus.android.data.db.pojo.content.statusContent.StatusTextContent;
import cu.todus.android.data.db.pojo.content.statusContent.StatusVideoContent;
import cu.todus.android.data.db.pojo.messageentity.MentionName;
import cu.todus.android.data.db.pojo.messageentity.MessageEntity;
import cu.todus.android.data.wrapper.FlowsState;
import cu.todus.android.uiCompose.loading.screen.LoadingScreenKt;
import cu.todus.android.uiCompose.main.screen.chat.mentionList.MentionItemModel;
import cu.todus.android.uiCompose.main.screen.statusEditor.StatusEditorViewModel;
import cu.todus.android.uiCompose.main.screen.statusList.StatusItemKt;
import cu.todus.android.uiCompose.main.screen.usersDisplay.openWith.OpenWithScreenKt;
import cu.todus.android.uiCompose.main.screen.usersDisplay.toolbar.SearchContactTopBarKt;
import cu.todus.android.uiCompose.theme.Other;
import cu.todus.android.utils.ColorGenerator;
import cu.z17.views.button.Z17ButtonsKt;
import cu.z17.views.dialogs.Z17DialogsKt;
import cu.z17.views.inputText.Z17InputTextKt;
import cu.z17.views.label.Z17LabelKt;
import cu.z17.views.picture.Z17PictureAvatarKt;
import cu.z17.views.picture.Z17PictureKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import le.d0;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;
import org.jivesoftware.smackx.xhtmlim.XHTMLText;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a-\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b\u001aC\u0010\u0011\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0007¢\u0006\u0004\b\u0011\u0010\u0012\u001a9\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00002\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00050\u00132\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0007¢\u0006\u0004\b\u0017\u0010\u0018¨\u0006$²\u0006\u000e\u0010\u001a\u001a\u00020\u00198\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\u001b\u001a\u00020\r8\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\u001c\u001a\u00020\r8\n@\nX\u008a\u008e\u0002²\u0006\f\u0010\u001d\u001a\u00020\r8\nX\u008a\u0084\u0002²\u0006\u000e\u0010\u001e\u001a\u00020\u000b8\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\u001f\u001a\u00020\u000b8\n@\nX\u008a\u008e\u0002²\u0006\u0012\u0010\"\u001a\b\u0012\u0004\u0012\u00020!0 8\nX\u008a\u0084\u0002²\u0006\f\u0010#\u001a\u00020\r8\nX\u008a\u0084\u0002"}, d2 = {"Lcu/todus/android/uiCompose/main/screen/statusEditor/StatusEditorViewModel;", "viewModel", "Lcu/todus/android/data/db/pojo/content/Content;", "statusContent", "Lkotlin/Function0;", "Lua/k0;", "goBack", "FinalPreview", "(Lcu/todus/android/uiCompose/main/screen/statusEditor/StatusEditorViewModel;Lcu/todus/android/data/db/pojo/content/Content;Llb/a;Landroidx/compose/runtime/Composer;I)V", "", XHTMLText.IMG, "", "label", "", "selected", "onAction", "onUndo", "StatusExtraBtn", "(Ljava/lang/Object;Ljava/lang/String;ZLlb/a;Llb/a;Landroidx/compose/runtime/Composer;I)V", "Lkotlin/Function1;", "Lcu/todus/android/uiCompose/main/screen/chat/mentionList/MentionItemModel;", "onSelected", "close", "AddCollaboratorDialog", "(Lcu/todus/android/uiCompose/main/screen/statusEditor/StatusEditorViewModel;Lkotlin/jvm/functions/Function1;Llb/a;Landroidx/compose/runtime/Composer;I)V", "Lcu/todus/android/data/db/entity/toDus/Status;", "status", "isLoading", "showAddCollaboratorDialog", "hasCollaborators", "textContent", "filter", "Lcu/todus/android/data/wrapper/FlowsState;", "Lcu/todus/android/data/db/pojo/Partner;", "partnerRequest", "showList", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class FinalPreviewKt {
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void AddCollaboratorDialog(final StatusEditorViewModel viewModel, final Function1 onSelected, final lb.a close, Composer composer, final int i10) {
        int i11;
        Composer composer2;
        MutableState mutableState;
        ab.e eVar;
        int i12;
        int i13;
        kotlin.jvm.internal.y.i(viewModel, "viewModel");
        kotlin.jvm.internal.y.i(onSelected, "onSelected");
        kotlin.jvm.internal.y.i(close, "close");
        Composer composerStartRestartGroup = composer.startRestartGroup(1778887677);
        if ((i10 & 6) == 0) {
            i11 = ((i10 & 8) == 0 ? composerStartRestartGroup.changed(viewModel) : composerStartRestartGroup.changedInstance(viewModel) ? 4 : 2) | i10;
        } else {
            i11 = i10;
        }
        if ((i10 & 48) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(onSelected) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(close) ? 256 : 128;
        }
        if (composerStartRestartGroup.shouldExecute((i11 & 147) != 146, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1778887677, i11, -1, "cu.todus.android.uiCompose.main.screen.statusEditor.pages.finalPreview.AddCollaboratorDialog (FinalPreview.kt:361)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            Modifier modifierM1756heightInVpY3zN4 = SizeKt.m1756heightInVpY3zN4(PaddingKt.m1725padding3ABfNKs(companion, Dp.m8823constructorimpl(8)), Dp.m8823constructorimpl(0), Dp.m8823constructorimpl(200));
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
            int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1756heightInVpY3zN4);
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
            LazyListState lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            Composer.Companion companion3 = Composer.INSTANCE;
            if (objRememberedValue == companion3.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final MutableState mutableState2 = (MutableState) objRememberedValue;
            final LazyPagingItems lazyPagingItemsCollectAsLazyPagingItems = LazyPagingItemsKt.collectAsLazyPagingItems(viewModel.partnersForMention(le.a0.O(d0.q1(AddCollaboratorDialog$lambda$0$1(mutableState2)).toString(), "@", "", false, 4, null)), null, composerStartRestartGroup, 0, 1);
            int i14 = i11;
            final State stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(viewModel.getRequestingPartner(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composerStartRestartGroup, 0, 7);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == companion3.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt.derivedStateOf(new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.statusEditor.pages.finalPreview.a
                    @Override // lb.a
                    public final Object invoke() {
                        return Boolean.valueOf(FinalPreviewKt.AddCollaboratorDialog$lambda$0$4$0(mutableState2));
                    }
                });
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            State state = (State) objRememberedValue2;
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == companion3.getEmpty()) {
                objRememberedValue3 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.statusEditor.pages.finalPreview.l
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return FinalPreviewKt.AddCollaboratorDialog$lambda$0$6$0(mutableState2, (String) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            Function1 function1 = (Function1) objRememberedValue3;
            boolean z10 = (i14 & 896) == 256;
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (z10 || objRememberedValue4 == companion3.getEmpty()) {
                objRememberedValue4 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.statusEditor.pages.finalPreview.t
                    @Override // lb.a
                    public final Object invoke() {
                        return FinalPreviewKt.AddCollaboratorDialog$lambda$0$7$0(close, mutableState2);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            SearchContactTopBarKt.SearchInput(function1, (lb.a) objRememberedValue4, AddCollaboratorDialog$lambda$0$1(mutableState2), composerStartRestartGroup, 6);
            SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion, Dp.m8823constructorimpl(10)), composerStartRestartGroup, 6);
            if (AddCollaboratorDialog$lambda$0$5(state)) {
                composerStartRestartGroup.startReplaceGroup(-1423980903);
                Modifier modifierM1205backgroundbw27NRU$default = BackgroundKt.m1205backgroundbw27NRU$default(companion, MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground(), null, 2, null);
                boolean zChanged = composerStartRestartGroup.changed(stateCollectAsStateWithLifecycle) | composerStartRestartGroup.changedInstance(lazyPagingItemsCollectAsLazyPagingItems) | ((i14 & 112) == 32);
                Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (zChanged || objRememberedValue5 == companion3.getEmpty()) {
                    objRememberedValue5 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.statusEditor.pages.finalPreview.u
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return FinalPreviewKt.AddCollaboratorDialog$lambda$0$8$0(lazyPagingItemsCollectAsLazyPagingItems, mutableState2, stateCollectAsStateWithLifecycle, onSelected, (LazyListScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                mutableState = mutableState2;
                eVar = null;
                i12 = 1;
                LazyDslKt.LazyColumn(modifierM1205backgroundbw27NRU$default, lazyListStateRememberLazyListState, null, false, null, null, null, false, null, (Function1) objRememberedValue5, composerStartRestartGroup, 0, TypedValues.PositionType.TYPE_CURVE_FIT);
                composerStartRestartGroup.endReplaceGroup();
                composer2 = composerStartRestartGroup;
                i13 = 0;
            } else {
                mutableState = mutableState2;
                eVar = null;
                i12 = 1;
                composerStartRestartGroup.startReplaceGroup(-1421669388);
                i13 = 0;
                Z17LabelKt.m10262Z17LabelfWhpE4E(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), StringResources_androidKt.stringResource(R.string.to_search_by_todusid, composerStartRestartGroup, 0), TextStyle.m8271copyp1EtxEg$default(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getLabelMedium(), 0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, TextAlign.INSTANCE.m8692getCentere0LSkKk(), 0, 0L, null, null, null, 0, 0, null, 16744447, null), 0L, 0, 0, composerStartRestartGroup, 6, 56);
                composer2 = composerStartRestartGroup;
                composer2.endReplaceGroup();
            }
            String strAddCollaboratorDialog$lambda$0$1 = AddCollaboratorDialog$lambda$0$1(mutableState);
            if ((r12 & 14) != 4 && ((i14 & 8) == 0 || !composer2.changedInstance(viewModel))) {
                i12 = i13;
            }
            Object objRememberedValue6 = composer2.rememberedValue();
            if (i12 != 0 || objRememberedValue6 == companion3.getEmpty()) {
                objRememberedValue6 = new FinalPreviewKt$AddCollaboratorDialog$1$4$1(viewModel, mutableState, eVar);
                composer2.updateRememberedValue(objRememberedValue6);
            }
            EffectsKt.LaunchedEffect(strAddCollaboratorDialog$lambda$0$1, (Function2) objRememberedValue6, composer2, i13);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.statusEditor.pages.finalPreview.v
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FinalPreviewKt.AddCollaboratorDialog$lambda$1(viewModel, onSelected, close, i10, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String AddCollaboratorDialog$lambda$0$1(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final FlowsState<Partner> AddCollaboratorDialog$lambda$0$3(State<FlowsState<Partner>> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean AddCollaboratorDialog$lambda$0$4$0(MutableState mutableState) {
        return AddCollaboratorDialog$lambda$0$1(mutableState).length() > 2;
    }

    private static final boolean AddCollaboratorDialog$lambda$0$5(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 AddCollaboratorDialog$lambda$0$6$0(MutableState mutableState, String it) {
        kotlin.jvm.internal.y.i(it, "it");
        mutableState.setValue(it);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 AddCollaboratorDialog$lambda$0$7$0(lb.a aVar, MutableState mutableState) {
        mutableState.setValue("");
        aVar.invoke();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 AddCollaboratorDialog$lambda$0$8$0(final LazyPagingItems lazyPagingItems, final MutableState mutableState, final State state, final Function1 function1, LazyListScope LazyColumn) {
        kotlin.jvm.internal.y.i(LazyColumn, "$this$LazyColumn");
        LazyListScope.CC.m(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(-959217193, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.statusEditor.pages.finalPreview.m
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return FinalPreviewKt.AddCollaboratorDialog$lambda$0$8$0$0(mutableState, state, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }), 3, null);
        LazyColumn.items(lazyPagingItems.getItemCount(), LazyFoundationExtensionsKt.itemKey(lazyPagingItems, new Function1() { // from class: cu.todus.android.uiCompose.main.screen.statusEditor.pages.finalPreview.n
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FinalPreviewKt.AddCollaboratorDialog$lambda$0$8$0$1((MentionItemModel) obj);
            }
        }), LazyFoundationExtensionsKt.itemContentType(lazyPagingItems, new Function1() { // from class: cu.todus.android.uiCompose.main.screen.statusEditor.pages.finalPreview.o
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FinalPreviewKt.AddCollaboratorDialog$lambda$0$8$0$2((MentionItemModel) obj);
            }
        }), ComposableLambdaKt.composableLambdaInstance(1217022638, true, new lb.o() { // from class: cu.todus.android.uiCompose.main.screen.statusEditor.pages.finalPreview.p
            @Override // lb.o
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return FinalPreviewKt.AddCollaboratorDialog$lambda$0$8$0$3(lazyPagingItems, function1, (LazyItemScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
            }
        }));
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 AddCollaboratorDialog$lambda$0$8$0$0(MutableState mutableState, State state, LazyItemScope item, Composer composer, int i10) {
        kotlin.jvm.internal.y.i(item, "$this$item");
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-959217193, i10, -1, "cu.todus.android.uiCompose.main.screen.statusEditor.pages.finalPreview.AddCollaboratorDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous> (FinalPreview.kt:405)");
            }
            boolean zU = le.a0.U(AddCollaboratorDialog$lambda$0$1(mutableState), "@", false, 2, null);
            Partner data = AddCollaboratorDialog$lambda$0$3(state).getData();
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.statusEditor.pages.finalPreview.q
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return FinalPreviewKt.AddCollaboratorDialog$lambda$0$8$0$0$0$0((String) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            OpenWithScreenKt.UserByToDusId(zU, data, (Function1) objRememberedValue, composer, RendererCapabilities.DECODER_SUPPORT_MASK);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 AddCollaboratorDialog$lambda$0$8$0$0$0$0(String it) {
        kotlin.jvm.internal.y.i(it, "it");
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object AddCollaboratorDialog$lambda$0$8$0$1(MentionItemModel i10) {
        kotlin.jvm.internal.y.i(i10, "i");
        return i10.getId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object AddCollaboratorDialog$lambda$0$8$0$2(MentionItemModel it) {
        kotlin.jvm.internal.y.i(it, "it");
        return "item";
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 AddCollaboratorDialog$lambda$0$8$0$3(LazyPagingItems lazyPagingItems, final Function1 function1, LazyItemScope items, int i10, Composer composer, int i11) {
        int i12;
        kotlin.jvm.internal.y.i(items, "$this$items");
        if ((i11 & 48) == 0) {
            i12 = i11 | (composer.changed(i10) ? 32 : 16);
        } else {
            i12 = i11;
        }
        if (composer.shouldExecute((i12 & 145) != 144, i12 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1217022638, i12, -1, "cu.todus.android.uiCompose.main.screen.statusEditor.pages.finalPreview.AddCollaboratorDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous> (FinalPreview.kt:418)");
            }
            final MentionItemModel mentionItemModel = (MentionItemModel) lazyPagingItems.get(i10);
            if (mentionItemModel == null) {
                composer.startReplaceGroup(-1792374097);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-1792374096);
                Modifier.Companion companion = Modifier.INSTANCE;
                Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(PaddingKt.m1727paddingVpY3zN4$default(companion, 0.0f, Dp.m8823constructorimpl(3), 1, null), 0.0f, 1, null);
                boolean zChanged = composer.changed(function1) | composer.changed(mentionItemModel);
                Object objRememberedValue = composer.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.statusEditor.pages.finalPreview.r
                        @Override // lb.a
                        public final Object invoke() {
                            return FinalPreviewKt.AddCollaboratorDialog$lambda$0$8$0$3$0$0$0(function1, mentionItemModel);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                Modifier modifierM1240clickableoSLSa3U$default = ClickableKt.m1240clickableoSLSa3U$default(modifierFillMaxWidth$default, false, null, null, null, (lb.a) objRememberedValue, 15, null);
                MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.m1613spacedBy0680j_4(Dp.m8823constructorimpl(10)), Alignment.INSTANCE.getCenterVertically(), composer, 54);
                int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
                CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierM1240clickableoSLSa3U$default);
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
                Z17PictureAvatarKt.m10277Z17PictureAvatarajT4Zlk(SizeKt.m1769size3ABfNKs(companion, Dp.m8823constructorimpl(30)), mentionItemModel.getPicture(), Color.m5856boximpl(ColorKt.Color(ColorGenerator.INSTANCE.getMATERIAL().getColor(mentionItemModel.getDisplayName()))), null, null, 0, null, false, null, mentionItemModel.getDisplayName(), true, 0, composer, 6, 6, 2552);
                String displayName = mentionItemModel.getDisplayName();
                MaterialTheme materialTheme = MaterialTheme.INSTANCE;
                int i13 = MaterialTheme.$stable;
                Z17LabelKt.m10262Z17LabelfWhpE4E(null, displayName, materialTheme.getTypography(composer, i13).getBodySmall(), 0L, 0, 0, composer, 0, 57);
                Z17LabelKt.m10262Z17LabelfWhpE4E(null, "@" + mentionItemModel.getToDusId(), materialTheme.getTypography(composer, i13).getLabelSmall(), 0L, 1, 0, composer, 24576, 41);
                composer.endNode();
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
    public static final k0 AddCollaboratorDialog$lambda$0$8$0$3$0$0$0(Function1 function1, MentionItemModel mentionItemModel) {
        function1.invoke(mentionItemModel);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 AddCollaboratorDialog$lambda$1(StatusEditorViewModel statusEditorViewModel, Function1 function1, lb.a aVar, int i10, Composer composer, int i11) {
        AddCollaboratorDialog(statusEditorViewModel, function1, aVar, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1));
        return k0.f43947a;
    }

    /* JADX WARN: Code duplicated, block: B:118:0x04be  */
    /* JADX WARN: Code duplicated, block: B:119:0x04c0  */
    /* JADX WARN: Code duplicated, block: B:126:0x04d4  */
    /* JADX WARN: Code duplicated, block: B:129:0x050e  */
    /* JADX WARN: Code duplicated, block: B:131:0x051b  */
    /* JADX WARN: Code duplicated, block: B:134:0x0530  */
    /* JADX WARN: Code duplicated, block: B:137:0x0559  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void FinalPreview(StatusEditorViewModel viewModel, Content content, lb.a goBack, Composer composer, final int i10) {
        int i11;
        final StatusEditorViewModel statusEditorViewModel;
        final lb.a aVar;
        Composer composer2;
        Modifier.Companion companion;
        Composer composer3;
        int i12;
        BoxScopeInstance boxScopeInstance;
        int i13;
        SnapshotMutationPolicy snapshotMutationPolicy;
        Object obj;
        boolean z10;
        boolean z11;
        Object objRememberedValue;
        final MutableState mutableState;
        MutableState mutableState2;
        Object objRememberedValue2;
        String str;
        final Content statusContent = content;
        kotlin.jvm.internal.y.i(viewModel, "viewModel");
        kotlin.jvm.internal.y.i(statusContent, "statusContent");
        kotlin.jvm.internal.y.i(goBack, "goBack");
        Composer composerStartRestartGroup = composer.startRestartGroup(-64052450);
        if ((i10 & 6) == 0) {
            i11 = ((i10 & 8) == 0 ? composerStartRestartGroup.changed(viewModel) : composerStartRestartGroup.changedInstance(viewModel) ? 4 : 2) | i10;
        } else {
            i11 = i10;
        }
        if ((i10 & 48) == 0) {
            i11 |= composerStartRestartGroup.changed(statusContent) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(goBack) ? 256 : 128;
        }
        if (composerStartRestartGroup.shouldExecute((i11 & 147) != 146, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-64052450, i11, -1, "cu.todus.android.uiCompose.main.screen.statusEditor.pages.finalPreview.FinalPreview (FinalPreview.kt:75)");
            }
            Modifier.Companion companion2 = Modifier.INSTANCE;
            Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(companion2, 0.0f, 1, null);
            Alignment.Companion companion3 = Alignment.INSTANCE;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion3.getTopStart(), false);
            int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxSize$default);
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
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, companion4.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion4.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion4.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl, companion4.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion4.getSetModifier());
            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
            c1.d.c(va.w.g("android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"), null, composerStartRestartGroup, 0, 2);
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            Composer.Companion companion5 = Composer.INSTANCE;
            if (objRememberedValue3 == companion5.getEmpty()) {
                if (statusContent instanceof StatusImageContent) {
                    str = Status.IMG_TYPE;
                } else {
                    str = statusContent instanceof StatusVideoContent ? Status.VIDEO_TYPE : Status.TEXT_TYPE;
                }
                i13 = 2;
                companion = companion2;
                i12 = i11;
                boxScopeInstance = boxScopeInstance2;
                snapshotMutationPolicy = null;
                objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new Status("", "", "", 0L, true, false, true, str, statusContent, false, false, va.w.n(), statusContent instanceof StatusTextContent ? 1 : 2, "", 0, 0, 0, 116232, null), null, 2, null);
                composer3 = composerStartRestartGroup;
                composer3.updateRememberedValue(objRememberedValue3);
            } else {
                companion = companion2;
                composer3 = composerStartRestartGroup;
                i12 = i11;
                boxScopeInstance = boxScopeInstance2;
                i13 = 2;
                snapshotMutationPolicy = null;
            }
            final MutableState mutableState3 = (MutableState) objRememberedValue3;
            Object objRememberedValue4 = composer3.rememberedValue();
            if (objRememberedValue4 == companion5.getEmpty()) {
                objRememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, snapshotMutationPolicy, i13, snapshotMutationPolicy);
                composer3.updateRememberedValue(objRememberedValue4);
            }
            MutableState mutableState4 = (MutableState) objRememberedValue4;
            Object objRememberedValue5 = composer3.rememberedValue();
            if (objRememberedValue5 == companion5.getEmpty()) {
                objRememberedValue5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, snapshotMutationPolicy, i13, snapshotMutationPolicy);
                composer3.updateRememberedValue(objRememberedValue5);
            }
            final MutableState mutableState5 = (MutableState) objRememberedValue5;
            boolean zChanged = composer3.changed(FinalPreview$lambda$0$1(mutableState3).getMessageEntities().size());
            Object objRememberedValue6 = composer3.rememberedValue();
            if (zChanged || objRememberedValue6 == companion5.getEmpty()) {
                objRememberedValue6 = SnapshotStateKt.derivedStateOf(new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.statusEditor.pages.finalPreview.a0
                    @Override // lb.a
                    public final Object invoke() {
                        return Boolean.valueOf(FinalPreviewKt.FinalPreview$lambda$0$9$0(mutableState3));
                    }
                });
                composer3.updateRememberedValue(objRememberedValue6);
            }
            Modifier.Companion companion6 = companion;
            float f10 = 20;
            Modifier modifierM1727paddingVpY3zN4$default = PaddingKt.m1727paddingVpY3zN4$default(SizeKt.fillMaxSize$default(companion6, 0.0f, 1, snapshotMutationPolicy), Dp.m8823constructorimpl(f10), 0.0f, i13, snapshotMutationPolicy);
            Arrangement arrangement = Arrangement.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(arrangement.getTop(), companion3.getStart(), composer3, 0);
            int iA2 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer3, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composer3.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer3, modifierM1727paddingVpY3zN4$default);
            lb.a constructor2 = companion4.getConstructor();
            if (!defpackage.r.a(composer3.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composer3.startReusableNode();
            if (composer3.getInserting()) {
                composer3.createNode(constructor2);
            } else {
                composer3.useNode();
            }
            Composer composerM5176constructorimpl2 = Updater.m5176constructorimpl(composer3);
            Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyColumnMeasurePolicy, companion4.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap2, companion4.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl2, Integer.valueOf(iA2), companion4.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl2, companion4.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier2, companion4.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            float f11 = 10;
            SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion6, Dp.m8823constructorimpl(f11)), composer3, 6);
            Composer composer4 = composer3;
            StatusItemKt.StatusItem(columnScopeInstance.align(companion6, companion3.getCenterHorizontally()), FinalPreview$lambda$0$1(mutableState3).getContent(), true, false, false, false, 150, true, null, composer4, 14156160, 312);
            Composer composer5 = composer4;
            SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion6, Dp.m8823constructorimpl(f11)), composer5, 6);
            String textContent = FinalPreview$lambda$0$1(mutableState3).getTextContent();
            if (textContent == null) {
                composer5.startReplaceGroup(898442192);
                composer5.endReplaceGroup();
            } else {
                composer5.startReplaceGroup(898442193);
                Object objRememberedValue7 = composer5.rememberedValue();
                if (objRememberedValue7 == companion5.getEmpty()) {
                    obj = null;
                    objRememberedValue7 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(textContent, null, 2, null);
                    composer5.updateRememberedValue(objRememberedValue7);
                } else {
                    obj = null;
                }
                final MutableState mutableState6 = (MutableState) objRememberedValue7;
                Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(companion6, 0.0f, 1, obj);
                String strFinalPreview$lambda$0$11$0$1 = FinalPreview$lambda$0$11$0$1(mutableState6);
                String strStringResource = StringResources_androidKt.stringResource(R.string.whats_on_your_mind, composer5, 0);
                Object objRememberedValue8 = composer5.rememberedValue();
                if (objRememberedValue8 == companion5.getEmpty()) {
                    objRememberedValue8 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.statusEditor.pages.finalPreview.b
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return FinalPreviewKt.FinalPreview$lambda$0$11$0$3$0(mutableState6, (String) obj2);
                        }
                    };
                    composer5.updateRememberedValue(objRememberedValue8);
                }
                Z17InputTextKt.m10251Z17InputTextf9_u2OI(modifierFillMaxWidth$default, strFinalPreview$lambda$0$11$0$1, 4, 3, strStringResource, null, (Function1) objRememberedValue8, null, null, 0, 0, 0L, 0L, 0L, 0L, 0L, null, false, null, false, composer5, 1576326, 0, 1048480);
                composer5 = composer5;
                k0 k0Var = k0.f43947a;
                composer5.endReplaceGroup();
            }
            SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion6, Dp.m8823constructorimpl(f11)), composer5, 6);
            Composer composer6 = composer5;
            DividerKt.m3177HorizontalDivider9IZ8Weo(null, 0.0f, 0L, composer6, 0, 7);
            float f12 = 5;
            SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion6, Dp.m8823constructorimpl(f12)), composer6, 6);
            ImageVector peopleAlt = PeopleAltKt.getPeopleAlt(Icons.Outlined.INSTANCE);
            String strStringResource2 = StringResources_androidKt.stringResource(R.string.anyone_can_respond, composer6, 0);
            boolean canRespond = FinalPreview$lambda$0$1(mutableState3).getCanRespond();
            Object objRememberedValue9 = composer6.rememberedValue();
            if (objRememberedValue9 == companion5.getEmpty()) {
                objRememberedValue9 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.statusEditor.pages.finalPreview.c
                    @Override // lb.a
                    public final Object invoke() {
                        return FinalPreviewKt.FinalPreview$lambda$0$11$1$0(mutableState3);
                    }
                };
                composer6.updateRememberedValue(objRememberedValue9);
            }
            lb.a aVar2 = (lb.a) objRememberedValue9;
            Object objRememberedValue10 = composer6.rememberedValue();
            if (objRememberedValue10 == companion5.getEmpty()) {
                objRememberedValue10 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.statusEditor.pages.finalPreview.d
                    @Override // lb.a
                    public final Object invoke() {
                        return FinalPreviewKt.FinalPreview$lambda$0$11$2$0(mutableState3);
                    }
                };
                composer6.updateRememberedValue(objRememberedValue10);
            }
            StatusExtraBtn(peopleAlt, strStringResource2, canRespond, aVar2, (lb.a) objRememberedValue10, composer6, 27648);
            SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion6, Dp.m8823constructorimpl(f12)), composer6, 6);
            Integer numValueOf = Integer.valueOf(R.drawable.cuba_map);
            String strStringResource3 = StringResources_androidKt.stringResource(R.string.public_, composer6, 0);
            boolean zIsPublic = FinalPreview$lambda$0$1(mutableState3).isPublic();
            Object objRememberedValue11 = composer6.rememberedValue();
            if (objRememberedValue11 == companion5.getEmpty()) {
                objRememberedValue11 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.statusEditor.pages.finalPreview.e
                    @Override // lb.a
                    public final Object invoke() {
                        return FinalPreviewKt.FinalPreview$lambda$0$11$3$0(mutableState3);
                    }
                };
                composer6.updateRememberedValue(objRememberedValue11);
            }
            lb.a aVar3 = (lb.a) objRememberedValue11;
            Object objRememberedValue12 = composer6.rememberedValue();
            if (objRememberedValue12 == companion5.getEmpty()) {
                objRememberedValue12 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.statusEditor.pages.finalPreview.f
                    @Override // lb.a
                    public final Object invoke() {
                        return FinalPreviewKt.FinalPreview$lambda$0$11$4$0(mutableState3);
                    }
                };
                composer6.updateRememberedValue(objRememberedValue12);
            }
            StatusExtraBtn(numValueOf, strStringResource3, zIsPublic, aVar3, (lb.a) objRememberedValue12, composer6, 27648);
            SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion6, Dp.m8823constructorimpl(100)), composer6, 6);
            composer6.endNode();
            Modifier modifierAlign = boxScopeInstance.align(PaddingKt.m1727paddingVpY3zN4$default(companion6, Dp.m8823constructorimpl(f10), 0.0f, 2, null), companion3.getBottomCenter());
            MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(arrangement.getTop(), companion3.getStart(), composer6, 0);
            int iA3 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer6, 0));
            CompositionLocalMap currentCompositionLocalMap3 = composer6.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composer6, modifierAlign);
            lb.a constructor3 = companion4.getConstructor();
            if (!defpackage.r.a(composer6.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composer6.startReusableNode();
            if (composer6.getInserting()) {
                composer6.createNode(constructor3);
            } else {
                composer6.useNode();
            }
            Composer composerM5176constructorimpl3 = Updater.m5176constructorimpl(composer6);
            Updater.m5184setimpl(composerM5176constructorimpl3, measurePolicyColumnMeasurePolicy2, companion4.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl3, currentCompositionLocalMap3, companion4.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl3, Integer.valueOf(iA3), companion4.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl3, companion4.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl3, modifierMaterializeModifier3, companion4.getSetModifier());
            SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion6, Dp.m8823constructorimpl(f12)), composer6, 6);
            DividerKt.m3177HorizontalDivider9IZ8Weo(null, 0.0f, 0L, composer6, 0, 7);
            SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion6, Dp.m8823constructorimpl(f11)), composer6, 6);
            int i14 = i12;
            if ((i14 & 14) != 4) {
                statusEditorViewModel = viewModel;
                boolean z12 = (i14 & 8) != 0 && composer6.changedInstance(statusEditorViewModel);
                if ((i14 & 896) == 256) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                z11 = z10 | z12;
                objRememberedValue = composer6.rememberedValue();
                if (!z11 || objRememberedValue == companion5.getEmpty()) {
                    aVar = goBack;
                    mutableState = mutableState4;
                    objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.statusEditor.pages.finalPreview.g
                        @Override // lb.a
                        public final Object invoke() {
                            return FinalPreviewKt.FinalPreview$lambda$0$12$0$0(statusEditorViewModel, mutableState, mutableState3, aVar);
                        }
                    };
                    composer6.updateRememberedValue(objRememberedValue);
                } else {
                    aVar = goBack;
                    mutableState = mutableState4;
                }
                mutableState2 = mutableState;
                Z17ButtonsKt.Z17PrimaryButton(null, (lb.a) objRememberedValue, StringResources_androidKt.stringResource(R.string.share, composer6, 0), null, true, false, composer6, 24576, 41);
                composer2 = composer6;
                SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion6, Dp.m8823constructorimpl(f10)), composer2, 6);
                composer2.endNode();
                if (FinalPreview$lambda$0$4(mutableState2)) {
                    composer2.startReplaceGroup(2021713073);
                    LoadingScreenKt.LoadingWall(composer2, 0);
                } else {
                    composer2.startReplaceGroup(-1751391682);
                }
                composer2.endReplaceGroup();
                boolean zFinalPreview$lambda$0$7 = FinalPreview$lambda$0$7(mutableState5);
                objRememberedValue2 = composer2.rememberedValue();
                if (objRememberedValue2 == companion5.getEmpty()) {
                    objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.statusEditor.pages.finalPreview.x
                        @Override // lb.a
                        public final Object invoke() {
                            return FinalPreviewKt.FinalPreview$lambda$0$13$0(mutableState5);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue2);
                }
                Z17DialogsKt.Z17CustomDialog(zFinalPreview$lambda$0$7, (lb.a) objRememberedValue2, ComposableLambdaKt.rememberComposableLambda(1040933618, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.statusEditor.pages.finalPreview.y
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj2, Object obj3, Object obj4) {
                        return FinalPreviewKt.FinalPreview$lambda$0$14(statusEditorViewModel, mutableState3, (lb.a) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                    }
                }, composer2, 54), composer2, 432);
                composer2.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                statusEditorViewModel = viewModel;
            }
            if ((i14 & 896) == 256) {
                z10 = true;
            } else {
                z10 = false;
            }
            z11 = z10 | z12;
            objRememberedValue = composer6.rememberedValue();
            if (z11) {
                aVar = goBack;
                mutableState = mutableState4;
                objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.statusEditor.pages.finalPreview.g
                    @Override // lb.a
                    public final Object invoke() {
                        return FinalPreviewKt.FinalPreview$lambda$0$12$0$0(statusEditorViewModel, mutableState, mutableState3, aVar);
                    }
                };
                composer6.updateRememberedValue(objRememberedValue);
            } else {
                aVar = goBack;
                mutableState = mutableState4;
                objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.statusEditor.pages.finalPreview.g
                    @Override // lb.a
                    public final Object invoke() {
                        return FinalPreviewKt.FinalPreview$lambda$0$12$0$0(statusEditorViewModel, mutableState, mutableState3, aVar);
                    }
                };
                composer6.updateRememberedValue(objRememberedValue);
            }
            mutableState2 = mutableState;
            Z17ButtonsKt.Z17PrimaryButton(null, (lb.a) objRememberedValue, StringResources_androidKt.stringResource(R.string.share, composer6, 0), null, true, false, composer6, 24576, 41);
            composer2 = composer6;
            SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion6, Dp.m8823constructorimpl(f10)), composer2, 6);
            composer2.endNode();
            if (FinalPreview$lambda$0$4(mutableState2)) {
                composer2.startReplaceGroup(2021713073);
                LoadingScreenKt.LoadingWall(composer2, 0);
            } else {
                composer2.startReplaceGroup(-1751391682);
            }
            composer2.endReplaceGroup();
            boolean zFinalPreview$lambda$0$8 = FinalPreview$lambda$0$7(mutableState5);
            objRememberedValue2 = composer2.rememberedValue();
            if (objRememberedValue2 == companion5.getEmpty()) {
                objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.statusEditor.pages.finalPreview.x
                    @Override // lb.a
                    public final Object invoke() {
                        return FinalPreviewKt.FinalPreview$lambda$0$13$0(mutableState5);
                    }
                };
                composer2.updateRememberedValue(objRememberedValue2);
            }
            Z17DialogsKt.Z17CustomDialog(zFinalPreview$lambda$0$8, (lb.a) objRememberedValue2, ComposableLambdaKt.rememberComposableLambda(1040933618, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.statusEditor.pages.finalPreview.y
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj2, Object obj3, Object obj4) {
                    return FinalPreviewKt.FinalPreview$lambda$0$14(statusEditorViewModel, mutableState3, (lb.a) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                }
            }, composer2, 54), composer2, 432);
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            statusEditorViewModel = viewModel;
            aVar = goBack;
            composer2 = composerStartRestartGroup;
            statusContent = statusContent;
            composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.statusEditor.pages.finalPreview.z
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return FinalPreviewKt.FinalPreview$lambda$1(statusEditorViewModel, statusContent, aVar, i10, (Composer) obj2, ((Integer) obj3).intValue());
                }
            });
        }
    }

    private static final Status FinalPreview$lambda$0$1(MutableState<Status> mutableState) {
        return mutableState.getValue();
    }

    private static final String FinalPreview$lambda$0$11$0$1(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 FinalPreview$lambda$0$11$0$3$0(MutableState mutableState, String it) {
        kotlin.jvm.internal.y.i(it, "it");
        mutableState.setValue(it);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 FinalPreview$lambda$0$11$1$0(MutableState mutableState) {
        mutableState.setValue(Status.copy$default(FinalPreview$lambda$0$1(mutableState), null, null, null, 0L, false, false, true, null, null, false, false, null, 0, null, 0, 0, 0, 131007, null));
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 FinalPreview$lambda$0$11$2$0(MutableState mutableState) {
        mutableState.setValue(Status.copy$default(FinalPreview$lambda$0$1(mutableState), null, null, null, 0L, false, false, false, null, null, false, false, null, 0, null, 0, 0, 0, 131007, null));
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 FinalPreview$lambda$0$11$3$0(MutableState mutableState) {
        mutableState.setValue(Status.copy$default(FinalPreview$lambda$0$1(mutableState), null, null, null, 0L, true, false, false, null, null, false, false, null, 0, null, 0, 0, 0, 131055, null));
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 FinalPreview$lambda$0$11$4$0(MutableState mutableState) {
        mutableState.setValue(Status.copy$default(FinalPreview$lambda$0$1(mutableState), null, null, null, 0L, false, false, false, null, null, false, false, null, 0, null, 0, 0, 0, 131055, null));
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 FinalPreview$lambda$0$12$0$0(StatusEditorViewModel statusEditorViewModel, final MutableState mutableState, MutableState mutableState2, final lb.a aVar) {
        FinalPreview$lambda$0$5(mutableState, true);
        statusEditorViewModel.sendStatus(FinalPreview$lambda$0$1(mutableState2), "", new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.statusEditor.pages.finalPreview.w
            @Override // lb.a
            public final Object invoke() {
                return FinalPreviewKt.FinalPreview$lambda$0$12$0$0$0(aVar, mutableState);
            }
        });
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 FinalPreview$lambda$0$12$0$0$0(lb.a aVar, MutableState mutableState) {
        aVar.invoke();
        FinalPreview$lambda$0$5(mutableState, false);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 FinalPreview$lambda$0$13$0(MutableState mutableState) {
        FinalPreview$lambda$0$8(mutableState, false);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 FinalPreview$lambda$0$14(StatusEditorViewModel statusEditorViewModel, final MutableState mutableState, final lb.a it, Composer composer, int i10) {
        kotlin.jvm.internal.y.i(it, "it");
        if ((i10 & 6) == 0) {
            i10 |= composer.changedInstance(it) ? 4 : 2;
        }
        if (composer.shouldExecute((i10 & 19) != 18, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1040933618, i10, -1, "cu.todus.android.uiCompose.main.screen.statusEditor.pages.finalPreview.FinalPreview.<anonymous>.<anonymous> (FinalPreview.kt:290)");
            }
            boolean z10 = (i10 & 14) == 4;
            Object objRememberedValue = composer.rememberedValue();
            if (z10 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.statusEditor.pages.finalPreview.s
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return FinalPreviewKt.FinalPreview$lambda$0$14$0$0(it, mutableState, (MentionItemModel) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            AddCollaboratorDialog(statusEditorViewModel, (Function1) objRememberedValue, it, composer, StatusEditorViewModel.$stable | ((i10 << 6) & 896));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 FinalPreview$lambda$0$14$0$0(lb.a aVar, MutableState mutableState, MentionItemModel newMention) {
        kotlin.jvm.internal.y.i(newMention, "newMention");
        Status statusFinalPreview$lambda$0$1 = FinalPreview$lambda$0$1(mutableState);
        ArrayList arrayList = new ArrayList();
        List<MessageEntity> messageEntities = FinalPreview$lambda$0$1(mutableState).getMessageEntities();
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : messageEntities) {
            MessageEntity messageEntity = (MessageEntity) obj;
            kotlin.jvm.internal.y.g(messageEntity, "null cannot be cast to non-null type cu.todus.android.data.db.pojo.messageentity.MentionName");
            if (!kotlin.jvm.internal.y.d(((MentionName) messageEntity).getToDusId(), newMention.getToDusId())) {
                arrayList2.add(obj);
            }
        }
        arrayList.addAll(arrayList2);
        arrayList.add(new MentionName(newMention.getId(), newMention.getToDusId(), 0, newMention.getToDusId().length(), newMention.getToDusId()));
        k0 k0Var = k0.f43947a;
        mutableState.setValue(Status.copy$default(statusFinalPreview$lambda$0$1, null, null, null, 0L, false, false, false, null, null, false, false, arrayList, 0, null, 0, 0, 0, 129023, null));
        aVar.invoke();
        return k0.f43947a;
    }

    private static final boolean FinalPreview$lambda$0$4(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void FinalPreview$lambda$0$5(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    private static final boolean FinalPreview$lambda$0$7(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void FinalPreview$lambda$0$8(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean FinalPreview$lambda$0$9$0(MutableState mutableState) {
        return !FinalPreview$lambda$0$1(mutableState).getMessageEntities().isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 FinalPreview$lambda$1(StatusEditorViewModel statusEditorViewModel, Content content, lb.a aVar, int i10, Composer composer, int i11) {
        FinalPreview(statusEditorViewModel, content, aVar, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1));
        return k0.f43947a;
    }

    @Composable
    public static final void StatusExtraBtn(final Object img, final String label, boolean z10, lb.a aVar, lb.a aVar2, Composer composer, final int i10) {
        int i11;
        long onBackground;
        final boolean z11 = z10;
        final lb.a onAction = aVar;
        final lb.a onUndo = aVar2;
        kotlin.jvm.internal.y.i(img, "img");
        kotlin.jvm.internal.y.i(label, "label");
        kotlin.jvm.internal.y.i(onAction, "onAction");
        kotlin.jvm.internal.y.i(onUndo, "onUndo");
        Composer composerStartRestartGroup = composer.startRestartGroup(303730323);
        if ((i10 & 6) == 0) {
            i11 = (composerStartRestartGroup.changedInstance(img) ? 4 : 2) | i10;
        } else {
            i11 = i10;
        }
        if ((i10 & 48) == 0) {
            i11 |= composerStartRestartGroup.changed(label) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i11 |= composerStartRestartGroup.changed(z11) ? 256 : 128;
        }
        if ((i10 & 3072) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(onAction) ? 2048 : 1024;
        }
        if ((i10 & 24576) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(onUndo) ? 16384 : 8192;
        }
        if (composerStartRestartGroup.shouldExecute((i11 & 9363) != 9362, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(303730323, i11, -1, "cu.todus.android.uiCompose.main.screen.statusEditor.pages.finalPreview.StatusExtraBtn (FinalPreview.kt:323)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            int i12 = i11 & 7168;
            boolean z12 = i12 == 2048;
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z12 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.statusEditor.pages.finalPreview.h
                    @Override // lb.a
                    public final Object invoke() {
                        return FinalPreviewKt.StatusExtraBtn$lambda$0$0(onAction);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            Modifier modifierM1240clickableoSLSa3U$default = ClickableKt.m1240clickableoSLSa3U$default(companion, false, null, null, null, (lb.a) objRememberedValue, 15, null);
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getCenterVertically(), composerStartRestartGroup, 48);
            int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1240clickableoSLSa3U$default);
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
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyRowMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion2.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl, companion2.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion2.getSetModifier());
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            Modifier modifierM1769size3ABfNKs = SizeKt.m1769size3ABfNKs(companion, Dp.m8823constructorimpl(30));
            ColorFilter.Companion companion3 = ColorFilter.INSTANCE;
            if (z11) {
                composerStartRestartGroup.startReplaceGroup(1743580278);
                onBackground = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimary();
            } else {
                composerStartRestartGroup.startReplaceGroup(1743581531);
                onBackground = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnBackground();
            }
            composerStartRestartGroup.endReplaceGroup();
            int i13 = i11;
            Z17PictureKt.m10278Z17BasePictureC8z9wKI(modifierM1769size3ABfNKs, img, null, ColorFilter.Companion.m5907tintxETnrds$default(companion3, onBackground, 0, 2, null), null, null, 0, null, null, composerStartRestartGroup, ((i11 << 3) & 112) | 6, XMPPTCPConnection.PacketWriter.QUEUE_SIZE);
            SpacerKt.Spacer(SizeKt.m1774width3ABfNKs(companion, Dp.m8823constructorimpl(10)), composerStartRestartGroup, 6);
            Z17LabelKt.m10262Z17LabelfWhpE4E(e3.a(rowScopeInstance, companion, 1.0f, false, 2, null), label, null, 0L, 0, 0, composerStartRestartGroup, i13 & 112, 60);
            SpacerKt.Spacer(SizeKt.m1774width3ABfNKs(companion, Dp.m8823constructorimpl(5)), composerStartRestartGroup, 6);
            boolean z13 = ((57344 & i13) == 16384) | ((i13 & 896) == 256) | (i12 == 2048);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (z13 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                z11 = z10;
                onAction = aVar;
                onUndo = aVar2;
                objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.statusEditor.pages.finalPreview.i
                    @Override // lb.a
                    public final Object invoke() {
                        return FinalPreviewKt.StatusExtraBtn$lambda$1$0$0(z11, onUndo, onAction);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            } else {
                z11 = z10;
                onAction = aVar;
                onUndo = aVar2;
            }
            IconButtonKt.IconButton((lb.a) objRememberedValue2, null, false, null, null, null, ComposableLambdaKt.rememberComposableLambda(-945513519, true, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.statusEditor.pages.finalPreview.j
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FinalPreviewKt.StatusExtraBtn$lambda$1$1(z11, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 1572864, 62);
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
            final boolean z14 = z11;
            final lb.a aVar3 = onAction;
            final lb.a aVar4 = onUndo;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.statusEditor.pages.finalPreview.k
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FinalPreviewKt.StatusExtraBtn$lambda$2(img, label, z14, aVar3, aVar4, i10, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 StatusExtraBtn$lambda$0$0(lb.a aVar) {
        aVar.invoke();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 StatusExtraBtn$lambda$1$0$0(boolean z10, lb.a aVar, lb.a aVar2) {
        if (z10) {
            aVar.invoke();
        } else {
            aVar2.invoke();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 StatusExtraBtn$lambda$1$1(boolean z10, Composer composer, int i10) {
        long jM10112getGrey0d7_KjU;
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-945513519, i10, -1, "cu.todus.android.uiCompose.main.screen.statusEditor.pages.finalPreview.StatusExtraBtn.<anonymous>.<anonymous> (FinalPreview.kt:347)");
            }
            Modifier modifierM1769size3ABfNKs = SizeKt.m1769size3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(24));
            ImageVector clear = z10 ? ClearKt.getClear(Icons.Outlined.INSTANCE) : KeyboardArrowRightKt.getKeyboardArrowRight(Icons.AutoMirrored.Outlined.INSTANCE);
            ColorFilter.Companion companion = ColorFilter.INSTANCE;
            if (z10) {
                composer.startReplaceGroup(1894584184);
                jM10112getGrey0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getPrimary();
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(1894584789);
                composer.endReplaceGroup();
                jM10112getGrey0d7_KjU = Other.INSTANCE.m10112getGrey0d7_KjU();
            }
            Z17PictureKt.m10278Z17BasePictureC8z9wKI(modifierM1769size3ABfNKs, clear, null, ColorFilter.Companion.m5907tintxETnrds$default(companion, jM10112getGrey0d7_KjU, 0, 2, null), null, null, 0, null, null, composer, 6, XMPPTCPConnection.PacketWriter.QUEUE_SIZE);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 StatusExtraBtn$lambda$2(Object obj, String str, boolean z10, lb.a aVar, lb.a aVar2, int i10, Composer composer, int i11) {
        StatusExtraBtn(obj, str, z10, aVar, aVar2, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1));
        return k0.f43947a;
    }
}
