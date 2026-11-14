package cu.todus.android.uiCompose.main.screen.chat.item.content;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.MenuKt;
import androidx.compose.material3.DividerKt;
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
import androidx.compose.ui.draw.ShadowKt;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.window.AndroidPopup_androidKt;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.media3.muxer.MuxerUtil;
import androidx.profileinstaller.ProfileVerifier;
import cu.todus.android.R;
import cu.todus.android.data.db.entity.toDus.Attachment;
import cu.todus.android.data.db.pojo.MessageWithPartnerWithReactions;
import cu.todus.android.data.db.pojo.content.Content;
import cu.todus.android.data.db.pojo.content.StickerContent;
import cu.todus.android.data.rest.entity.NewEntity;
import cu.z17.views.label.Z17LabelKt;
import cu.z17.views.picture.Z17PictureKt;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\u001aK\u0010\b\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00002\u0018\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00022\u0018\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0002H\u0007¢\u0006\u0004\b\b\u0010\t\u001aU\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\n2\u0018\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00022\u0018\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00022\u0006\u0010\r\u001a\u00020\fH\u0007¢\u0006\u0004\b\u000e\u0010\u000f\u001au\u0010\u0016\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\n2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00102\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u00102\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00132\u0018\u0010\u0015\u001a\u0014\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00050\u0002H\u0007¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u0017\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0007¢\u0006\u0004\b\u0018\u0010\u0019\u001aG\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00132\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00050\u001a2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00050\u00102\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00050\u0010H\u0007¢\u0006\u0004\b\u001e\u0010\u001f¨\u0006%²\u0006\u000e\u0010!\u001a\u0004\u0018\u00010 8\nX\u008a\u0084\u0002²\u0006\f\u0010#\u001a\u00020\"8\nX\u008a\u0084\u0002²\u0006\u000e\u0010$\u001a\u00020\u00138\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010!\u001a\u0004\u0018\u00010 8\nX\u008a\u0084\u0002²\u0006\f\u0010#\u001a\u00020\"8\nX\u008a\u0084\u0002²\u0006\u000e\u0010!\u001a\u0004\u0018\u00010 8\nX\u008a\u0084\u0002²\u0006\f\u0010#\u001a\u00020\"8\nX\u008a\u0084\u0002"}, d2 = {"Lcu/todus/android/data/db/pojo/MessageWithPartnerWithReactions;", "msg", "Lkotlin/Function2;", "Lcu/todus/android/uiCompose/main/screen/chat/item/MessageAction;", "", "Lua/k0;", "onClick", "onLongClick", "StickerContent", "(Lcu/todus/android/data/db/pojo/MessageWithPartnerWithReactions;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/ui/Modifier;", "modifier", "", NewEntity.NEWS_CONFIG_SOURCE, "StickerView", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)V", "Lkotlin/Function0;", "onGoMore", "id", "", "isFavorite", "onChangeStickerFavoriteStatus", "StickerViewForList", "(Landroidx/compose/ui/Modifier;Llb/a;Llb/a;Llb/a;Ljava/lang/String;Ljava/lang/String;ZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "StickerPlaceholder", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)V", "Lkotlin/Function1;", "onChangeFavoriteState", "goPacks", "close", "StickerListContextAction", "(ZLkotlin/jvm/functions/Function1;Llb/a;Llb/a;Landroidx/compose/runtime/Composer;I)V", "Ll0/j;", "composition", "", "progress", "showContextAction", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class StickerContentKt {
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void StickerContent(final MessageWithPartnerWithReactions msg, Function2 onClick, Function2 onLongClick, Composer composer, final int i10) {
        int i11;
        final Function2 function2;
        final Function2 function3;
        kotlin.jvm.internal.y.i(msg, "msg");
        kotlin.jvm.internal.y.i(onClick, "onClick");
        kotlin.jvm.internal.y.i(onLongClick, "onLongClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(391634234);
        if ((i10 & 6) == 0) {
            i11 = (composerStartRestartGroup.changed(msg) ? 4 : 2) | i10;
        } else {
            i11 = i10;
        }
        if ((i10 & 48) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(onClick) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(onLongClick) ? 256 : 128;
        }
        if (composerStartRestartGroup.shouldExecute((i11 & 147) != 146, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(391634234, i11, -1, "cu.todus.android.uiCompose.main.screen.chat.item.content.StickerContent (StickerContent.kt:43)");
            }
            Modifier modifierM1769size3ABfNKs = SizeKt.m1769size3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(MenuKt.InTransitionDuration));
            Iterator<T> it = msg.getAttachments().iterator();
            while (true) {
                if (!it.hasNext()) {
                    throw new NoSuchElementException("Collection contains no element matching the predicate.");
                }
                Attachment attachment = (Attachment) it.next();
                if (attachment.getType() == 13 && (attachment.getContent() instanceof StickerContent)) {
                    Content content = attachment.getContent();
                    kotlin.jvm.internal.y.g(content, "null cannot be cast to non-null type cu.todus.android.data.db.pojo.content.StickerContent");
                    function2 = onClick;
                    function3 = onLongClick;
                    StickerView(modifierM1769size3ABfNKs, function2, function3, ((StickerContent) content).urlFile(), composerStartRestartGroup, (i11 & 112) | 6 | (i11 & 896), 0);
                    if (!ComposerKt.isTraceInProgress()) {
                        break;
                    }
                    ComposerKt.traceEventEnd();
                    break;
                }
                onClick = onClick;
                onLongClick = onLongClick;
            }
        } else {
            function2 = onClick;
            function3 = onLongClick;
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.item.content.o1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StickerContentKt.StickerContent$lambda$1(msg, function2, function3, i10, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 StickerContent$lambda$1(MessageWithPartnerWithReactions messageWithPartnerWithReactions, Function2 function2, Function2 function3, int i10, Composer composer, int i11) {
        StickerContent(messageWithPartnerWithReactions, function2, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1));
        return ua.k0.f43947a;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void StickerListContextAction(final boolean z10, final Function1 onChangeFavoriteState, final lb.a goPacks, final lb.a close, Composer composer, final int i10) {
        int i11;
        kotlin.jvm.internal.y.i(onChangeFavoriteState, "onChangeFavoriteState");
        kotlin.jvm.internal.y.i(goPacks, "goPacks");
        kotlin.jvm.internal.y.i(close, "close");
        Composer composerStartRestartGroup = composer.startRestartGroup(720323876);
        if ((i10 & 6) == 0) {
            i11 = (composerStartRestartGroup.changed(z10) ? 4 : 2) | i10;
        } else {
            i11 = i10;
        }
        if ((i10 & 48) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(onChangeFavoriteState) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(goPacks) ? 256 : 128;
        }
        if ((i10 & 3072) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(close) ? 2048 : 1024;
        }
        if (composerStartRestartGroup.shouldExecute((i11 & 1171) != 1170, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(720323876, i11, -1, "cu.todus.android.uiCompose.main.screen.chat.item.content.StickerListContextAction (StickerContent.kt:210)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            float f10 = 5;
            float f11 = 15;
            Modifier modifierM5480shadows4CzXII$default = ShadowKt.m5480shadows4CzXII$default(PaddingKt.m1725padding3ABfNKs(SizeKt.m1775widthInVpY3zN4(companion, Dp.m8823constructorimpl(0), Dp.m8823constructorimpl(200)), Dp.m8823constructorimpl(f10)), Dp.m8823constructorimpl(2), RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(f11)), false, 0L, 0L, 28, null);
            MaterialTheme materialTheme = MaterialTheme.INSTANCE;
            int i12 = MaterialTheme.$stable;
            Modifier modifierM1726paddingVpY3zN4 = PaddingKt.m1726paddingVpY3zN4(BackgroundKt.m1204backgroundbw27NRU(modifierM5480shadows4CzXII$default, materialTheme.getColorScheme(composerStartRestartGroup, i12).getBackground(), RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(f11))), Dp.m8823constructorimpl(10), Dp.m8823constructorimpl(f10));
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
            int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1726paddingVpY3zN4);
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
            int i13 = i11 & 7168;
            boolean z11 = ((i11 & 14) == 4) | ((i11 & 112) == 32) | (i13 == 2048);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z11 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.item.content.b2
                    @Override // lb.a
                    public final Object invoke() {
                        return StickerContentKt.StickerListContextAction$lambda$0$0$0(onChangeFavoriteState, z10, close);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            Z17LabelKt.m10262Z17LabelfWhpE4E(PaddingKt.m1727paddingVpY3zN4$default(ClickableKt.m1240clickableoSLSa3U$default(companion, false, null, null, null, (lb.a) objRememberedValue, 15, null), 0.0f, Dp.m8823constructorimpl(f10), 1, null), StringResources_androidKt.stringResource(!z10 ? R.string.favorite : R.string.remove_from_favorite, composerStartRestartGroup, 0), materialTheme.getTypography(composerStartRestartGroup, i12).getBodyLarge(), 0L, 0, 0, composerStartRestartGroup, 0, 56);
            DividerKt.m3177HorizontalDivider9IZ8Weo(null, 0.0f, 0L, composerStartRestartGroup, 0, 7);
            boolean z12 = (i13 == 2048) | ((i11 & 896) == 256);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (z12 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.item.content.c2
                    @Override // lb.a
                    public final Object invoke() {
                        return StickerContentKt.StickerListContextAction$lambda$0$1$0(goPacks, close);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            Z17LabelKt.m10262Z17LabelfWhpE4E(PaddingKt.m1727paddingVpY3zN4$default(ClickableKt.m1240clickableoSLSa3U$default(companion, false, null, null, null, (lb.a) objRememberedValue2, 15, null), 0.0f, Dp.m8823constructorimpl(f10), 1, null), StringResources_androidKt.stringResource(R.string.more, composerStartRestartGroup, 0), materialTheme.getTypography(composerStartRestartGroup, i12).getBodyLarge(), 0L, 0, 0, composerStartRestartGroup, 0, 56);
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.item.content.p1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StickerContentKt.StickerListContextAction$lambda$1(z10, onChangeFavoriteState, goPacks, close, i10, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 StickerListContextAction$lambda$0$0$0(Function1 function1, boolean z10, lb.a aVar) {
        function1.invoke(Boolean.valueOf(!z10));
        aVar.invoke();
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 StickerListContextAction$lambda$0$1$0(lb.a aVar, lb.a aVar2) {
        aVar.invoke();
        aVar2.invoke();
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 StickerListContextAction$lambda$1(boolean z10, Function1 function1, lb.a aVar, lb.a aVar2, int i10, Composer composer, int i11) {
        StickerListContextAction(z10, function1, aVar, aVar2, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1));
        return ua.k0.f43947a;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void StickerPlaceholder(final Modifier modifier, Composer composer, final int i10) {
        int i11;
        kotlin.jvm.internal.y.i(modifier, "modifier");
        Composer composerStartRestartGroup = composer.startRestartGroup(2128232230);
        if ((i10 & 6) == 0) {
            i11 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i10;
        } else {
            i11 = i10;
        }
        if (composerStartRestartGroup.shouldExecute((i11 & 3) != 2, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2128232230, i11, -1, "cu.todus.android.uiCompose.main.screen.chat.item.content.StickerPlaceholder (StickerContent.kt:186)");
            }
            p0.l lVarQ = p0.r.q(p0.n.a.a(p0.n.a.b(cu.z17.views.R.raw.sticker_placeholder)), null, null, null, null, null, composerStartRestartGroup, 0, 62);
            final p0.i iVarC = p0.a.c(StickerPlaceholder$lambda$0(lVarQ), false, false, false, null, 0.0f, Integer.MAX_VALUE, null, false, false, composerStartRestartGroup, 1572864, 958);
            Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(modifier, 0.0f, 1, null);
            l0.j jVarStickerPlaceholder$lambda$0 = StickerPlaceholder$lambda$0(lVarQ);
            boolean zChanged = composerStartRestartGroup.changed(iVarC);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.item.content.z1
                    @Override // lb.a
                    public final Object invoke() {
                        return Float.valueOf(StickerContentKt.StickerPlaceholder$lambda$1(iVarC));
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            p0.e.b(jVarStickerPlaceholder$lambda$0, (lb.a) objRememberedValue, modifierFillMaxSize$default, false, false, false, false, null, false, null, null, null, false, false, null, null, false, composerStartRestartGroup, 0, 0, 131064);
            composerStartRestartGroup = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.item.content.a2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StickerContentKt.StickerPlaceholder$lambda$3(modifier, i10, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final l0.j StickerPlaceholder$lambda$0(p0.l lVar) {
        return (l0.j) lVar.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float StickerPlaceholder$lambda$1(p0.i iVar) {
        return ((Number) iVar.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 StickerPlaceholder$lambda$3(Modifier modifier, int i10, Composer composer, int i11) {
        StickerPlaceholder(modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1));
        return ua.k0.f43947a;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void StickerView(Modifier modifier, final Function2 onClick, final Function2 onLongClick, final String source, Composer composer, final int i10, final int i11) {
        Modifier modifier2;
        int i12;
        final Modifier modifier3;
        Modifier modifier4;
        kotlin.jvm.internal.y.i(onClick, "onClick");
        kotlin.jvm.internal.y.i(onLongClick, "onLongClick");
        kotlin.jvm.internal.y.i(source, "source");
        Composer composerStartRestartGroup = composer.startRestartGroup(-117928405);
        int i13 = i11 & 1;
        if (i13 != 0) {
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
            i12 |= composerStartRestartGroup.changedInstance(onClick) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i12 |= composerStartRestartGroup.changedInstance(onLongClick) ? 256 : 128;
        }
        if ((i10 & 3072) == 0) {
            i12 |= composerStartRestartGroup.changed(source) ? 2048 : 1024;
        }
        int i14 = i12;
        if (composerStartRestartGroup.shouldExecute((i14 & 1171) != 1170, i14 & 1)) {
            Modifier modifier5 = i13 != 0 ? Modifier.INSTANCE : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-117928405, i14, -1, "cu.todus.android.uiCompose.main.screen.chat.item.content.StickerView (StickerContent.kt:58)");
            }
            if (le.d0.a0(source, ".tgs", false, 2, null) || le.d0.a0(source, ".json", false, 2, null)) {
                Modifier modifier6 = modifier5;
                composerStartRestartGroup.startReplaceGroup(78486935);
                p0.l lVarQ = p0.r.q(p0.n.b.a(p0.n.b.b(le.a0.O(source, ".tgs", ".json", false, 4, null))), null, null, null, source, null, composerStartRestartGroup, (i14 << 3) & 57344, 46);
                final p0.i iVarC = p0.a.c(StickerView$lambda$0(lVarQ), false, false, false, null, 0.0f, 1, null, false, false, composerStartRestartGroup, 1572864, 958);
                boolean z10 = ((i14 & 896) == 256) | ((i14 & 112) == 32);
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (z10 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new StickerContentKt$StickerView$1$1(onLongClick, onClick);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                modifier4 = modifier6;
                Modifier modifierPointerInput = SuspendingPointerInputFilterKt.pointerInput(modifier4, onClick, (PointerInputEventHandler) objRememberedValue);
                l0.j jVarStickerView$lambda$0 = StickerView$lambda$0(lVarQ);
                boolean zChanged = composerStartRestartGroup.changed(iVarC);
                Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.item.content.u1
                        @Override // lb.a
                        public final Object invoke() {
                            return Float.valueOf(StickerContentKt.StickerView$lambda$1(iVarC));
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                p0.e.b(jVarStickerView$lambda$0, (lb.a) objRememberedValue2, modifierPointerInput, false, false, false, false, null, false, null, null, null, false, false, null, null, false, composerStartRestartGroup, 0, 0, 131064);
                composerStartRestartGroup = composerStartRestartGroup;
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(79444680);
                boolean z11 = ((i14 & 896) == 256) | ((i14 & 112) == 32);
                Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (z11 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = new StickerContentKt$StickerView$3$1(onLongClick, onClick);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                Z17PictureKt.m10278Z17BasePictureC8z9wKI(SuspendingPointerInputFilterKt.pointerInput(modifier5, onClick, (PointerInputEventHandler) objRememberedValue3), source, null, null, null, "sticker", 0, null, null, composerStartRestartGroup, ((i14 >> 6) & 112) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 476);
                composerStartRestartGroup = composerStartRestartGroup;
                composerStartRestartGroup.endReplaceGroup();
                modifier4 = modifier5;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.item.content.v1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StickerContentKt.StickerView$lambda$5(modifier3, onClick, onLongClick, source, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final l0.j StickerView$lambda$0(p0.l lVar) {
        return (l0.j) lVar.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float StickerView$lambda$1(p0.i iVar) {
        return ((Number) iVar.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 StickerView$lambda$5(Modifier modifier, Function2 function2, Function2 function3, String str, int i10, int i11, Composer composer, int i12) {
        StickerView(modifier, function2, function3, str, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return ua.k0.f43947a;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void StickerViewForList(Modifier modifier, final lb.a onClick, final lb.a onLongClick, final lb.a onGoMore, final String id2, final String source, final boolean z10, final Function2 onChangeStickerFavoriteStatus, Composer composer, final int i10, final int i11) {
        Modifier modifier2;
        int i12;
        int i13;
        final Modifier modifier3;
        int i14;
        boolean z11;
        kotlin.jvm.internal.y.i(onClick, "onClick");
        kotlin.jvm.internal.y.i(onLongClick, "onLongClick");
        kotlin.jvm.internal.y.i(onGoMore, "onGoMore");
        kotlin.jvm.internal.y.i(id2, "id");
        kotlin.jvm.internal.y.i(source, "source");
        kotlin.jvm.internal.y.i(onChangeStickerFavoriteStatus, "onChangeStickerFavoriteStatus");
        Composer composerStartRestartGroup = composer.startRestartGroup(-165560473);
        int i15 = i11 & 1;
        if (i15 != 0) {
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
            i12 |= composerStartRestartGroup.changedInstance(onClick) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i12 |= composerStartRestartGroup.changedInstance(onLongClick) ? 256 : 128;
        }
        if ((i10 & 3072) == 0) {
            i12 |= composerStartRestartGroup.changedInstance(onGoMore) ? 2048 : 1024;
        }
        if ((i10 & 24576) == 0) {
            i12 |= composerStartRestartGroup.changed(id2) ? 16384 : 8192;
        }
        if ((i10 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            i12 |= composerStartRestartGroup.changed(source) ? 131072 : 65536;
        }
        int i16 = i12;
        if ((i10 & 1572864) == 0) {
            i13 = i16 | (composerStartRestartGroup.changed(z10) ? 1048576 : 524288);
        } else {
            i13 = i16;
        }
        if ((i10 & 12582912) == 0) {
            i13 |= composerStartRestartGroup.changedInstance(onChangeStickerFavoriteStatus) ? 8388608 : 4194304;
        }
        int i17 = i13;
        if (composerStartRestartGroup.shouldExecute((i17 & 4793491) != 4793490, i17 & 1)) {
            Modifier modifier4 = i15 != 0 ? Modifier.INSTANCE : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-165560473, i17, -1, "cu.todus.android.uiCompose.main.screen.chat.item.content.StickerViewForList (StickerContent.kt:114)");
            }
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier4);
            ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
            lb.a constructor = companion.getConstructor();
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
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, companion.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl, companion.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion.getSetModifier());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            Composer.Companion companion2 = Composer.INSTANCE;
            if (objRememberedValue == companion2.getEmpty()) {
                i14 = 2;
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                i14 = 2;
            }
            final MutableState mutableState = (MutableState) objRememberedValue;
            if (le.d0.a0(source, ".tgs", false, i14, null) || le.d0.a0(source, ".json", false, i14, null)) {
                composerStartRestartGroup.startReplaceGroup(508639985);
                p0.l lVarQ = p0.r.q(p0.n.b.a(p0.n.b.b(le.a0.O(source, ".tgs", ".json", false, 4, null))), null, null, null, source, null, composerStartRestartGroup, (i17 >> 3) & 57344, 46);
                final p0.i iVarC = p0.a.c(StickerViewForList$lambda$0$3(lVarQ), false, false, false, null, 0.0f, 1, null, false, false, composerStartRestartGroup, 1572864, 958);
                Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                boolean z12 = ((i17 & 112) == 32) | ((i17 & 896) == 256);
                Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (z12 || objRememberedValue2 == companion2.getEmpty()) {
                    objRememberedValue2 = new StickerContentKt$StickerViewForList$1$1$1(onLongClick, mutableState, onClick);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                Modifier modifierPointerInput = SuspendingPointerInputFilterKt.pointerInput(modifierFillMaxSize$default, onClick, (PointerInputEventHandler) objRememberedValue2);
                l0.j jVarStickerViewForList$lambda$0$3 = StickerViewForList$lambda$0$3(lVarQ);
                boolean zChanged = composerStartRestartGroup.changed(iVarC);
                Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (zChanged || objRememberedValue3 == companion2.getEmpty()) {
                    objRememberedValue3 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.item.content.q1
                        @Override // lb.a
                        public final Object invoke() {
                            return Float.valueOf(StickerContentKt.StickerViewForList$lambda$0$4(iVarC));
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                z11 = true;
                p0.e.b(jVarStickerViewForList$lambda$0$3, (lb.a) objRememberedValue3, modifierPointerInput, false, false, false, false, null, false, null, null, null, false, false, null, null, false, composerStartRestartGroup, 0, 0, 131064);
                composerStartRestartGroup = composerStartRestartGroup;
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(509616299);
                Modifier modifierFillMaxSize$default2 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                boolean z13 = ((i17 & 896) == 256) | ((i17 & 112) == 32);
                Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (z13 || objRememberedValue4 == companion2.getEmpty()) {
                    objRememberedValue4 = new StickerContentKt$StickerViewForList$1$3$1(onLongClick, mutableState, onClick);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                z11 = true;
                Z17PictureKt.m10278Z17BasePictureC8z9wKI(SuspendingPointerInputFilterKt.pointerInput(modifierFillMaxSize$default2, onClick, (PointerInputEventHandler) objRememberedValue4), source, null, null, null, "sticker", 0, null, null, composerStartRestartGroup, ((i17 >> 12) & 112) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 476);
                composerStartRestartGroup.endReplaceGroup();
                composerStartRestartGroup = composerStartRestartGroup;
            }
            if (StickerViewForList$lambda$0$1(mutableState)) {
                composerStartRestartGroup.startReplaceGroup(510261471);
                long jM8941constructorimpl = IntOffset.m8941constructorimpl((((long) 0) << 32) | (((long) (-150)) & MuxerUtil.UNSIGNED_INT_MAX_VALUE));
                Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue5 == companion2.getEmpty()) {
                    objRememberedValue5 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.item.content.r1
                        @Override // lb.a
                        public final Object invoke() {
                            return StickerContentKt.StickerViewForList$lambda$0$8$0(mutableState);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                AndroidPopup_androidKt.m9081PopupK5zGePQ(null, jM8941constructorimpl, (lb.a) objRememberedValue5, null, ComposableLambdaKt.rememberComposableLambda(1283157426, z11, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.item.content.s1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return StickerContentKt.StickerViewForList$lambda$0$9(z10, onChangeStickerFavoriteStatus, id2, onGoMore, mutableState, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 25008, 9);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(510704833);
                composerStartRestartGroup.endReplaceGroup();
            }
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.item.content.t1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StickerContentKt.StickerViewForList$lambda$1(modifier3, onClick, onLongClick, onGoMore, id2, source, z10, onChangeStickerFavoriteStatus, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final boolean StickerViewForList$lambda$0$1(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void StickerViewForList$lambda$0$2(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    private static final l0.j StickerViewForList$lambda$0$3(p0.l lVar) {
        return (l0.j) lVar.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float StickerViewForList$lambda$0$4(p0.i iVar) {
        return ((Number) iVar.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 StickerViewForList$lambda$0$8$0(MutableState mutableState) {
        StickerViewForList$lambda$0$2(mutableState, false);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 StickerViewForList$lambda$0$9(boolean z10, final Function2 function2, final String str, final lb.a aVar, final MutableState mutableState, Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1283157426, i10, -1, "cu.todus.android.uiCompose.main.screen.chat.item.content.StickerViewForList.<anonymous>.<anonymous> (StickerContent.kt:173)");
            }
            boolean zChanged = composer.changed(function2) | composer.changed(str);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.item.content.w1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return StickerContentKt.StickerViewForList$lambda$0$9$0$0(function2, str, ((Boolean) obj).booleanValue());
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            Function1 function1 = (Function1) objRememberedValue;
            boolean zChanged2 = composer.changed(aVar);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.item.content.x1
                    @Override // lb.a
                    public final Object invoke() {
                        return StickerContentKt.StickerViewForList$lambda$0$9$1$0(aVar);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            lb.a aVar2 = (lb.a) objRememberedValue2;
            Object objRememberedValue3 = composer.rememberedValue();
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.item.content.y1
                    @Override // lb.a
                    public final Object invoke() {
                        return StickerContentKt.StickerViewForList$lambda$0$9$2$0(mutableState);
                    }
                };
                composer.updateRememberedValue(objRememberedValue3);
            }
            StickerListContextAction(z10, function1, aVar2, (lb.a) objRememberedValue3, composer, 3072);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 StickerViewForList$lambda$0$9$0$0(Function2 function2, String str, boolean z10) {
        function2.invoke(str, Boolean.valueOf(z10));
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 StickerViewForList$lambda$0$9$1$0(lb.a aVar) {
        aVar.invoke();
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 StickerViewForList$lambda$0$9$2$0(MutableState mutableState) {
        StickerViewForList$lambda$0$2(mutableState, false);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 StickerViewForList$lambda$1(Modifier modifier, lb.a aVar, lb.a aVar2, lb.a aVar3, String str, String str2, boolean z10, Function2 function2, int i10, int i11, Composer composer, int i12) {
        StickerViewForList(modifier, aVar, aVar2, aVar3, str, str2, z10, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return ua.k0.f43947a;
    }
}
