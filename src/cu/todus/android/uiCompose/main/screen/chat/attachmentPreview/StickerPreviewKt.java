package cu.todus.android.uiCompose.main.screen.chat.attachmentPreview;

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
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import cu.todus.android.R;
import cu.todus.android.data.db.entity.toDus.Attachment;
import cu.todus.android.data.db.entity.toDus.Sticker;
import cu.todus.android.data.db.pojo.content.Content;
import cu.todus.android.data.db.pojo.content.StickerContent;
import cu.todus.android.uiCompose.main.screen.chat.item.MessageAction;
import cu.todus.android.uiCompose.main.screen.chat.item.content.StickerContentKt;
import cu.z17.views.button.Z17ButtonsKt;
import cu.z17.views.label.Z17LabelKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import pe.a2;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a+\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0007¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcu/todus/android/data/db/entity/toDus/Attachment;", "attachment", "Lkotlin/Function1;", "", "Lua/k0;", "goSticker", "StickerPreview", "(Lcu/todus/android/data/db/entity/toDus/Attachment;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class StickerPreviewKt {
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void StickerPreview(final Attachment attachment, final Function1 goSticker, Composer composer, final int i10) {
        int i11;
        Composer composer2;
        kotlin.jvm.internal.y.i(attachment, "attachment");
        kotlin.jvm.internal.y.i(goSticker, "goSticker");
        Composer composerStartRestartGroup = composer.startRestartGroup(626988286);
        if ((i10 & 6) == 0) {
            i11 = (composerStartRestartGroup.changed(attachment) ? 4 : 2) | i10;
        } else {
            i11 = i10;
        }
        if ((i10 & 48) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(goSticker) ? 32 : 16;
        }
        int i12 = i11;
        if (composerStartRestartGroup.shouldExecute((i12 & 19) != 18, i12 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(626988286, i12, -1, "cu.todus.android.uiCompose.main.screen.chat.attachmentPreview.StickerPreview (StickerPreview.kt:35)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(companion, 0.0f, 1, null);
            Alignment.Companion companion2 = Alignment.INSTANCE;
            Alignment.Horizontal centerHorizontally = companion2.getCenterHorizontally();
            Arrangement arrangement = Arrangement.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(arrangement.getTop(), centerHorizontally, composerStartRestartGroup, 48);
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
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyColumnMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion3.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl, companion3.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion3.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            Composer.Companion companion4 = Composer.INSTANCE;
            if (objRememberedValue == companion4.getEmpty()) {
                objRememberedValue = EffectsKt.createCompositionCoroutineScope(ab.j.f643c, composerStartRestartGroup);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final pe.m0 m0Var = (pe.m0) objRememberedValue;
            Modifier modifierA = androidx.compose.foundation.layout.x.a(columnScopeInstance, companion, 1.0f, false, 2, null);
            MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(arrangement.getCenter(), companion2.getStart(), composerStartRestartGroup, 6);
            int iA2 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierA);
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
            Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyColumnMeasurePolicy2, companion3.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl2, Integer.valueOf(iA2), companion3.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl2, companion3.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier2, companion3.getSetModifier());
            Modifier modifierM1769size3ABfNKs = SizeKt.m1769size3ABfNKs(companion, Dp.m8823constructorimpl(220));
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == companion4.getEmpty()) {
                objRememberedValue2 = new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.attachmentPreview.h0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return StickerPreviewKt.StickerPreview$lambda$0$0$0$0((MessageAction) obj, ((Integer) obj2).intValue());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            Function2 function2 = (Function2) objRememberedValue2;
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == companion4.getEmpty()) {
                objRememberedValue3 = new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.attachmentPreview.l0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return StickerPreviewKt.StickerPreview$lambda$0$0$1$0((MessageAction) obj, ((Integer) obj2).intValue());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            Content content = attachment.getContent();
            kotlin.jvm.internal.y.g(content, "null cannot be cast to non-null type cu.todus.android.data.db.pojo.content.StickerContent");
            StickerContentKt.StickerView(modifierM1769size3ABfNKs, function2, (Function2) objRememberedValue3, ((StickerContent) content).urlFile(), composerStartRestartGroup, 438, 0);
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, StringResources_androidKt.stringResource(R.string.collection, composerStartRestartGroup, 0) + ": " + ((StickerContent) attachment.getContent()).getFolder(), MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getTitleMedium(), 0L, 0, 0, composerStartRestartGroup, 0, 57);
            composerStartRestartGroup.endNode();
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue4 == companion4.getEmpty()) {
                objRememberedValue4 = SnapshotStateKt.mutableStateListOf();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            final SnapshotStateList snapshotStateList = (SnapshotStateList) objRememberedValue4;
            LazyListState lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
            Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue5 == companion4.getEmpty()) {
                objRememberedValue5 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.attachmentPreview.m0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return StickerPreviewKt.StickerPreview$lambda$0$2$0(snapshotStateList, (LazyListScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            }
            LazyDslKt.LazyRow(null, lazyListStateRememberLazyListState, null, false, null, null, null, false, null, (Function1) objRememberedValue5, composerStartRestartGroup, 805306368, 509);
            Modifier modifierM1725padding3ABfNKs = PaddingKt.m1725padding3ABfNKs(companion, Dp.m8823constructorimpl(20));
            int i13 = i12 & 14;
            boolean z10 = (i13 == 4) | ((i12 & 112) == 32);
            Object objRememberedValue6 = composerStartRestartGroup.rememberedValue();
            if (z10 || objRememberedValue6 == companion4.getEmpty()) {
                objRememberedValue6 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.attachmentPreview.n0
                    @Override // lb.a
                    public final Object invoke() {
                        return StickerPreviewKt.StickerPreview$lambda$0$3$0(goSticker, attachment);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
            }
            Z17ButtonsKt.Z17PrimaryButton(modifierM1725padding3ABfNKs, (lb.a) objRememberedValue6, StringResources_androidKt.stringResource(R.string.see_in_stickers, composerStartRestartGroup, 0), null, true, false, composerStartRestartGroup, 24582, 40);
            composer2 = composerStartRestartGroup;
            ua.k0 k0Var = ua.k0.f43947a;
            boolean zChangedInstance = composer2.changedInstance(m0Var) | (i13 == 4);
            Object objRememberedValue7 = composer2.rememberedValue();
            if (zChangedInstance || objRememberedValue7 == companion4.getEmpty()) {
                objRememberedValue7 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.attachmentPreview.o0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return StickerPreviewKt.StickerPreview$lambda$0$4$0(m0Var, attachment, snapshotStateList, (DisposableEffectScope) obj);
                    }
                };
                composer2.updateRememberedValue(objRememberedValue7);
            }
            EffectsKt.DisposableEffect(k0Var, (Function1) objRememberedValue7, composer2, 6);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.attachmentPreview.p0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StickerPreviewKt.StickerPreview$lambda$1(attachment, goSticker, i10, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 StickerPreview$lambda$0$0$0$0(MessageAction messageAction, int i10) {
        kotlin.jvm.internal.y.i(messageAction, "messageAction");
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 StickerPreview$lambda$0$0$1$0(MessageAction messageAction, int i10) {
        kotlin.jvm.internal.y.i(messageAction, "messageAction");
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 StickerPreview$lambda$0$2$0(final SnapshotStateList snapshotStateList, LazyListScope LazyRow) {
        kotlin.jvm.internal.y.i(LazyRow, "$this$LazyRow");
        LazyRow.items(snapshotStateList.size(), new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.attachmentPreview.i0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return StickerPreviewKt.StickerPreview$lambda$0$2$0$0(snapshotStateList, ((Integer) obj).intValue());
            }
        }, new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.attachmentPreview.j0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return StickerPreviewKt.StickerPreview$lambda$0$2$0$1(((Integer) obj).intValue());
            }
        }, ComposableLambdaKt.composableLambdaInstance(-503974328, true, new lb.o() { // from class: cu.todus.android.uiCompose.main.screen.chat.attachmentPreview.k0
            @Override // lb.o
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return StickerPreviewKt.StickerPreview$lambda$0$2$0$2(snapshotStateList, (LazyItemScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
            }
        }));
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object StickerPreview$lambda$0$2$0$0(SnapshotStateList snapshotStateList, int i10) {
        return ((Sticker) snapshotStateList.get(i10)).getId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object StickerPreview$lambda$0$2$0$1(int i10) {
        return "sticker";
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 StickerPreview$lambda$0$2$0$2(SnapshotStateList snapshotStateList, LazyItemScope items, int i10, Composer composer, int i11) {
        kotlin.jvm.internal.y.i(items, "$this$items");
        if ((i11 & 48) == 0) {
            i11 |= composer.changed(i10) ? 32 : 16;
        }
        if (composer.shouldExecute((i11 & 145) != 144, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-503974328, i11, -1, "cu.todus.android.uiCompose.main.screen.chat.attachmentPreview.StickerPreview.<anonymous>.<anonymous>.<anonymous>.<anonymous> (StickerPreview.kt:74)");
            }
            Sticker sticker = (Sticker) snapshotStateList.get(i10);
            Modifier modifierM1769size3ABfNKs = SizeKt.m1769size3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(80));
            String url = sticker.getUrl();
            boolean favorite = sticker.getFavorite();
            String id2 = sticker.getId();
            Object objRememberedValue = composer.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.attachmentPreview.q0
                    @Override // lb.a
                    public final Object invoke() {
                        return ua.k0.f43947a;
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            lb.a aVar = (lb.a) objRememberedValue;
            Object objRememberedValue2 = composer.rememberedValue();
            if (objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.attachmentPreview.r0
                    @Override // lb.a
                    public final Object invoke() {
                        return ua.k0.f43947a;
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            lb.a aVar2 = (lb.a) objRememberedValue2;
            Object objRememberedValue3 = composer.rememberedValue();
            if (objRememberedValue3 == companion.getEmpty()) {
                objRememberedValue3 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.attachmentPreview.s0
                    @Override // lb.a
                    public final Object invoke() {
                        return ua.k0.f43947a;
                    }
                };
                composer.updateRememberedValue(objRememberedValue3);
            }
            lb.a aVar3 = (lb.a) objRememberedValue3;
            Object objRememberedValue4 = composer.rememberedValue();
            if (objRememberedValue4 == companion.getEmpty()) {
                objRememberedValue4 = new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.attachmentPreview.t0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return StickerPreviewKt.StickerPreview$lambda$0$2$0$2$3$0((String) obj, ((Boolean) obj2).booleanValue());
                    }
                };
                composer.updateRememberedValue(objRememberedValue4);
            }
            StickerContentKt.StickerViewForList(modifierM1769size3ABfNKs, aVar, aVar2, aVar3, id2, url, favorite, (Function2) objRememberedValue4, composer, 12586422, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 StickerPreview$lambda$0$2$0$2$3$0(String str, boolean z10) {
        kotlin.jvm.internal.y.i(str, "<unused var>");
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 StickerPreview$lambda$0$3$0(Function1 function1, Attachment attachment) {
        Content content = attachment.getContent();
        kotlin.jvm.internal.y.g(content, "null cannot be cast to non-null type cu.todus.android.data.db.pojo.content.StickerContent");
        function1.invoke(((StickerContent) content).getFolder());
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult StickerPreview$lambda$0$4$0(pe.m0 m0Var, Attachment attachment, SnapshotStateList snapshotStateList, DisposableEffectScope DisposableEffect) {
        kotlin.jvm.internal.y.i(DisposableEffect, "$this$DisposableEffect");
        final a2 a2VarD = pe.k.d(m0Var, pe.d1.b(), null, new StickerPreviewKt$StickerPreview$1$4$1$job$1(attachment, snapshotStateList, null), 2, null);
        return new DisposableEffectResult() { // from class: cu.todus.android.uiCompose.main.screen.chat.attachmentPreview.StickerPreviewKt$StickerPreview$lambda$0$4$0$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                a2.a.a(a2VarD, null, 1, null);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 StickerPreview$lambda$1(Attachment attachment, Function1 function1, int i10, Composer composer, int i11) {
        StickerPreview(attachment, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1));
        return ua.k0.f43947a;
    }
}
