package cu.todus.android.uiCompose.main.screen.chat.list;

import android.content.Context;
import android.net.Uri;
import androidx.compose.foundation.BackgroundKt;
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
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
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
import androidx.compose.ui.draw.AlphaKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import androidx.media3.common.C;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.paging.LoadState;
import androidx.paging.compose.LazyFoundationExtensionsKt;
import androidx.paging.compose.LazyPagingItems;
import androidx.profileinstaller.ProfileVerifier;
import cu.todus.android.R;
import cu.todus.android.data.db.entity.toDus.Attachment;
import cu.todus.android.data.db.entity.toDus.Message;
import cu.todus.android.data.db.pojo.MessageWithPartnerWithReactions;
import cu.todus.android.data.db.pojo.content.Content;
import cu.todus.android.data.db.pojo.content.LinkInfoContent;
import cu.todus.android.data.preferences.Owner;
import cu.todus.android.uiCompose.main.screen.chat.item.MessageAction;
import cu.todus.android.uiCompose.main.screen.chat.item.MessageItemKt;
import cu.todus.android.uiCompose.main.screen.chat.item.content.InfoContentKt;
import cu.todus.android.uiCompose.main.screen.chat.placeholder.ChatPlaceholderKt;
import cu.todus.android.uiCompose.shared.pagerStateIndicator.PagerStateIndicatorKt;
import cu.todus.android.utils.ExtensionFunsKt;
import cu.todus.android.xmpp.XMPPUtils;
import cu.z17.views.button.Z17ButtonsKt;
import cu.z17.views.label.Z17LabelKt;
import cu.z17.views.picture.Z17PictureKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.y;
import le.d0;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u009f\u0003\u0010'\u001a\u00020\u00122\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000b2\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\n2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00120\n2\u0006\u0010\u0015\u001a\u00020\f2\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00120\n2\u0006\u0010\u0017\u001a\u00020\f2\u001e\u0010\u0019\u001a\u001a\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00120\u00182\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00120\u00072\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00120\n2\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00120\n2\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00120\n2$\u0010!\u001a \u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00120\u001f2\u0018\u0010#\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00120\"2 \b\u0002\u0010$\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00120\u00182\u000e\b\u0002\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00120\u00072\u000e\b\u0002\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00120\u0007H\u0007¢\u0006\u0004\b'\u0010(¨\u0006.²\u0006\u000e\u0010)\u001a\u00020\f8\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010*\u001a\u00020\f8\n@\nX\u008a\u008e\u0002²\u0006\f\u0010+\u001a\u00020\f8\nX\u008a\u0084\u0002²\u0006\u000e\u0010-\u001a\u0004\u0018\u00010,8\nX\u008a\u0084\u0002"}, d2 = {"Landroidx/compose/ui/Modifier;", "modifier", "Landroidx/compose/foundation/lazy/LazyListState;", "lazyListState", "Landroidx/paging/compose/LazyPagingItems;", "Lcu/todus/android/data/db/pojo/MessageWithPartnerWithReactions;", Message.TABLE_NAME, "Lkotlin/Function0;", "Lcu/todus/android/data/preferences/Owner;", "getOwner", "Lkotlin/Function1;", "", "", "selectedContains", "isSecret", "chatId", "backgroundPath", "Lcu/todus/android/data/db/entity/toDus/Message;", "Lua/k0;", "displaySingleMsgRead", "loadLinkInfo", "canReply", "onReply", "canReact", "Lkotlin/Function3;", "onReacted", "onEditReactSelection", "onGroupMemberNameClicked", "", "onClickOnReply", "onClickOnStatus", "Lkotlin/Function4;", "Lcu/todus/android/uiCompose/main/screen/chat/item/MessageAction;", "onClick", "Lkotlin/Function2;", "onLongClick", "onMsgEntityClick", "visitCatalogue", "visitSocialProfile", "MsgList", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/LazyListState;Landroidx/paging/compose/LazyPagingItems;Llb/a;Lkotlin/jvm/functions/Function1;ZLjava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;ZLkotlin/jvm/functions/Function1;ZLkotlin/jvm/functions/Function3;Llb/a;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Llb/o;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Llb/a;Llb/a;Landroidx/compose/runtime/Composer;IIII)V", "extra", "showPageIndicator", "isSelected", "Ll0/j;", "emptyAnimation", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class MsgListKt {
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void MsgList(final Modifier modifier, final LazyListState lazyListState, final LazyPagingItems<MessageWithPartnerWithReactions> messages, final lb.a getOwner, final Function1 selectedContains, final boolean z10, final String chatId, final String backgroundPath, final Function1 displaySingleMsgRead, final Function1 loadLinkInfo, final boolean z11, final Function1 onReply, final boolean z12, final Function3 onReacted, final lb.a onEditReactSelection, final Function1 onGroupMemberNameClicked, final Function1 onClickOnReply, final Function1 onClickOnStatus, final lb.o onClick, final Function2 onLongClick, Function3 function3, lb.a aVar, lb.a aVar2, Composer composer, final int i10, final int i11, final int i12, final int i13) {
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        Composer composer2;
        final Function3 function4;
        final lb.a aVar3;
        final lb.a aVar4;
        Function3 function5;
        lb.a aVar5;
        lb.a aVar6;
        SnapshotMutationPolicy snapshotMutationPolicy;
        Composer composer3;
        final Function3 function6;
        final lb.a aVar7;
        boolean z13;
        MutableState mutableState;
        y.i(modifier, "modifier");
        y.i(lazyListState, "lazyListState");
        y.i(messages, "messages");
        y.i(getOwner, "getOwner");
        y.i(selectedContains, "selectedContains");
        y.i(chatId, "chatId");
        y.i(backgroundPath, "backgroundPath");
        y.i(displaySingleMsgRead, "displaySingleMsgRead");
        y.i(loadLinkInfo, "loadLinkInfo");
        y.i(onReply, "onReply");
        y.i(onReacted, "onReacted");
        y.i(onEditReactSelection, "onEditReactSelection");
        y.i(onGroupMemberNameClicked, "onGroupMemberNameClicked");
        y.i(onClickOnReply, "onClickOnReply");
        y.i(onClickOnStatus, "onClickOnStatus");
        y.i(onClick, "onClick");
        y.i(onLongClick, "onLongClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(1149684002);
        if ((i10 & 6) == 0) {
            i14 = i10 | (composerStartRestartGroup.changed(modifier) ? 4 : 2);
        } else {
            i14 = i10;
        }
        if ((i10 & 48) == 0) {
            i14 |= composerStartRestartGroup.changed(lazyListState) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i14 |= (i10 & 512) == 0 ? composerStartRestartGroup.changed(messages) : composerStartRestartGroup.changedInstance(messages) ? 256 : 128;
        }
        if ((i10 & 3072) == 0) {
            i14 |= composerStartRestartGroup.changedInstance(getOwner) ? 2048 : 1024;
        }
        if ((i10 & 24576) == 0) {
            i14 |= composerStartRestartGroup.changedInstance(selectedContains) ? 16384 : 8192;
        }
        if ((i10 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            i14 |= composerStartRestartGroup.changed(z10) ? 131072 : 65536;
        }
        if ((i10 & 1572864) == 0) {
            i14 |= composerStartRestartGroup.changed(chatId) ? 1048576 : 524288;
        }
        if ((i10 & 12582912) == 0) {
            i14 |= composerStartRestartGroup.changed(backgroundPath) ? 8388608 : 4194304;
        }
        if ((i10 & 100663296) == 0) {
            i14 |= composerStartRestartGroup.changedInstance(displaySingleMsgRead) ? 67108864 : 33554432;
        }
        if ((i10 & 805306368) == 0) {
            i14 |= composerStartRestartGroup.changedInstance(loadLinkInfo) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
        }
        int i19 = i14;
        if ((i11 & 6) == 0) {
            i15 = i11 | (composerStartRestartGroup.changed(z11) ? 4 : 2);
        } else {
            i15 = i11;
        }
        if ((i11 & 48) == 0) {
            i15 |= composerStartRestartGroup.changedInstance(onReply) ? 32 : 16;
        }
        if ((i11 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i15 |= composerStartRestartGroup.changed(z12) ? 256 : 128;
        }
        if ((i11 & 3072) == 0) {
            i15 |= composerStartRestartGroup.changedInstance(onReacted) ? 2048 : 1024;
        }
        if ((i11 & 24576) == 0) {
            i15 |= composerStartRestartGroup.changedInstance(onEditReactSelection) ? 16384 : 8192;
        }
        if ((i11 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            i15 |= composerStartRestartGroup.changedInstance(onGroupMemberNameClicked) ? 131072 : 65536;
        }
        if ((i11 & 1572864) == 0) {
            i15 |= composerStartRestartGroup.changedInstance(onClickOnReply) ? 1048576 : 524288;
        }
        if ((i11 & 12582912) == 0) {
            i15 |= composerStartRestartGroup.changedInstance(onClickOnStatus) ? 8388608 : 4194304;
        }
        if ((i11 & 100663296) == 0) {
            i15 |= composerStartRestartGroup.changedInstance(onClick) ? 67108864 : 33554432;
        }
        if ((i11 & 805306368) == 0) {
            i15 |= composerStartRestartGroup.changedInstance(onLongClick) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
        }
        int i20 = i15;
        int i21 = i13 & 1048576;
        if (i21 != 0) {
            i16 = i12;
            i17 = i16 | 6;
        } else {
            i16 = i12;
            if ((i16 & 6) == 0) {
                i17 = i16 | (composerStartRestartGroup.changedInstance(function3) ? 4 : 2);
            } else {
                i17 = i16;
            }
        }
        int i22 = i13 & 2097152;
        if (i22 != 0) {
            i17 |= 48;
        } else if ((i16 & 48) == 0) {
            i17 |= composerStartRestartGroup.changedInstance(aVar) ? 32 : 16;
        }
        int i23 = i17;
        int i24 = i13 & 4194304;
        if (i24 != 0) {
            i18 = i23 | RendererCapabilities.DECODER_SUPPORT_MASK;
        } else if ((i16 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i18 = i23 | (composerStartRestartGroup.changedInstance(aVar2) ? 256 : 128);
        } else {
            i18 = i23;
        }
        if (composerStartRestartGroup.shouldExecute(((i19 & 306783379) == 306783378 && (i20 & 306783379) == 306783378 && (i18 & 147) == 146) ? false : true, i19 & 1)) {
            if (i21 != 0) {
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function3() { // from class: cu.todus.android.uiCompose.main.screen.chat.list.o
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return MsgListKt.MsgList$lambda$0$0((MessageWithPartnerWithReactions) obj, (MessageAction) obj2, (String) obj3);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                function5 = (Function3) objRememberedValue;
            } else {
                function5 = function3;
            }
            if (i22 != 0) {
                Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.list.p
                        @Override // lb.a
                        public final Object invoke() {
                            return k0.f43947a;
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                aVar5 = (lb.a) objRememberedValue2;
            } else {
                aVar5 = aVar;
            }
            if (i24 != 0) {
                Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.list.q
                        @Override // lb.a
                        public final Object invoke() {
                            return k0.f43947a;
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                aVar6 = (lb.a) objRememberedValue3;
            } else {
                aVar6 = aVar2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1149684002, i19, i20, "cu.todus.android.uiCompose.main.screen.chat.list.MsgList (MsgList.kt:106)");
            }
            final lb.a aVar8 = aVar5;
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(modifier, 0.0f, 1, null);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxWidth$default);
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
            final Context context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            Composer.Companion companion2 = Composer.INSTANCE;
            if (objRememberedValue4 == companion2.getEmpty()) {
                snapshotMutationPolicy = null;
                objRememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            } else {
                snapshotMutationPolicy = null;
            }
            final MutableState mutableState2 = (MutableState) objRememberedValue4;
            Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue5 == companion2.getEmpty()) {
                objRememberedValue5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, snapshotMutationPolicy, 2, snapshotMutationPolicy);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            }
            final MutableState mutableState3 = (MutableState) objRememberedValue5;
            if (d0.q0(backgroundPath)) {
                composer3 = composerStartRestartGroup;
                composer3.startReplaceGroup(-1813668346);
                composer3.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-1813914362);
                Z17PictureKt.m10278Z17BasePictureC8z9wKI(AlphaKt.alpha(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, snapshotMutationPolicy), 0.2f), Uri.parse(backgroundPath), null, null, ContentScale.INSTANCE.getCrop(), null, 0, null, null, composerStartRestartGroup, 24582, 492);
                composer3 = composerStartRestartGroup;
                composer3.endReplaceGroup();
            }
            Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
            float f10 = 8;
            PaddingValues paddingValuesM1722PaddingValuesa9UjIt4$default = PaddingKt.m1722PaddingValuesa9UjIt4$default(0.0f, Dp.m8823constructorimpl(f10), 0.0f, Dp.m8823constructorimpl(f10), 5, null);
            boolean zChangedInstance = ((i20 & 112) == 32) | ((i19 & 896) == 256 || ((i19 & 512) != 0 && composer3.changedInstance(messages))) | ((i19 & C.ENCODING_PCM_DOUBLE) == 536870912) | composer3.changedInstance(context) | ((i19 & 7168) == 2048) | ((i19 & 57344) == 16384) | ((i20 & 896) == 256) | ((i19 & 458752) == 131072) | ((234881024 & i20) == 67108864) | ((i20 & C.ENCODING_PCM_DOUBLE) == 536870912) | ((i20 & 458752) == 131072) | ((3670016 & i20) == 1048576) | ((234881024 & i19) == 67108864) | ((29360128 & i20) == 8388608) | ((i20 & 7168) == 2048) | ((i20 & 57344) == 16384) | ((i20 & 14) == 4) | ((i18 & 14) == 4) | ((3670016 & i19) == 1048576) | ((i18 & 112) == 32) | ((i18 & 896) == 256);
            Object objRememberedValue6 = composer3.rememberedValue();
            if (zChangedInstance || objRememberedValue6 == companion2.getEmpty()) {
                function6 = function5;
                aVar7 = aVar6;
                z13 = true;
                objRememberedValue6 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.list.r
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return MsgListKt.MsgList$lambda$3$6$0(messages, loadLinkInfo, context, getOwner, z12, z10, onClick, onLongClick, onGroupMemberNameClicked, onClickOnReply, displaySingleMsgRead, onClickOnStatus, onReacted, onEditReactSelection, z11, onReply, function6, selectedContains, mutableState3, chatId, aVar8, aVar7, mutableState2, (LazyListScope) obj);
                    }
                };
                mutableState = mutableState2;
                composer3.updateRememberedValue(objRememberedValue6);
            } else {
                function6 = function5;
                aVar7 = aVar6;
                mutableState = mutableState2;
                z13 = true;
            }
            composer2 = composer3;
            LazyDslKt.LazyColumn(modifierFillMaxSize$default, lazyListState, paddingValuesM1722PaddingValuesa9UjIt4$default, true, null, null, null, false, null, (Function1) objRememberedValue6, composer2, (i19 & 112) | 3462, 496);
            if ((messages.getLoadState().getAppend() instanceof LoadState.NotLoading) && messages.getLoadState().getAppend().getEndOfPaginationReached() && !MsgList$lambda$3$1(mutableState)) {
                MsgList$lambda$3$2(mutableState, z13);
            }
            k0 k0Var = k0.f43947a;
            Object objRememberedValue7 = composer2.rememberedValue();
            if (objRememberedValue7 == companion2.getEmpty()) {
                objRememberedValue7 = new MsgListKt$MsgList$4$2$1(mutableState3, null);
                composer2.updateRememberedValue(objRememberedValue7);
            }
            EffectsKt.LaunchedEffect(k0Var, (Function2) objRememberedValue7, composer2, 6);
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            function4 = function6;
            aVar4 = aVar7;
            aVar3 = aVar8;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            function4 = function3;
            aVar3 = aVar;
            aVar4 = aVar2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.list.s
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return MsgListKt.MsgList$lambda$4(modifier, lazyListState, messages, getOwner, selectedContains, z10, chatId, backgroundPath, displaySingleMsgRead, loadLinkInfo, z11, onReply, z12, onReacted, onEditReactSelection, onGroupMemberNameClicked, onClickOnReply, onClickOnStatus, onClick, onLongClick, function4, aVar3, aVar4, i10, i11, i12, i13, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 MsgList$lambda$0$0(MessageWithPartnerWithReactions messageWithPartnerWithReactions, MessageAction messageAction, String str) {
        y.i(messageWithPartnerWithReactions, "<unused var>");
        y.i(messageAction, "<unused var>");
        y.i(str, "<unused var>");
        return k0.f43947a;
    }

    private static final boolean MsgList$lambda$3$1(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void MsgList$lambda$3$2(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    private static final boolean MsgList$lambda$3$4(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void MsgList$lambda$3$5(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 MsgList$lambda$3$6$0(final LazyPagingItems lazyPagingItems, final Function1 function1, final Context context, final lb.a aVar, final boolean z10, final boolean z11, final lb.o oVar, final Function2 function2, final Function1 function3, final Function1 function4, final Function1 function5, final Function1 function6, final Function3 function7, final lb.a aVar2, final boolean z12, final Function1 function8, final Function3 function9, final Function1 function10, MutableState mutableState, final String str, final lb.a aVar3, final lb.a aVar4, MutableState mutableState2, LazyListScope LazyColumn) {
        y.i(LazyColumn, "$this$LazyColumn");
        LazyColumn.items(lazyPagingItems.getItemCount(), LazyFoundationExtensionsKt.itemKey(lazyPagingItems, new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.list.k
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MsgListKt.MsgList$lambda$3$6$0$0((MessageWithPartnerWithReactions) obj);
            }
        }), LazyFoundationExtensionsKt.itemContentType(lazyPagingItems, new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.list.l
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MsgListKt.MsgList$lambda$3$6$0$1((MessageWithPartnerWithReactions) obj);
            }
        }), ComposableLambdaKt.composableLambdaInstance(718575358, true, new lb.o() { // from class: cu.todus.android.uiCompose.main.screen.chat.list.m
            @Override // lb.o
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return MsgListKt.MsgList$lambda$3$6$0$2(lazyPagingItems, function1, context, aVar, z10, z11, oVar, function2, function3, function4, function5, function6, function7, aVar2, z12, function8, function9, function10, (LazyItemScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
            }
        }));
        if (MsgList$lambda$3$4(mutableState)) {
            LazyListScope.CC.m(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(-846208980, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.chat.list.n
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return MsgListKt.MsgList$lambda$3$6$0$3(lazyPagingItems, str, aVar3, aVar4, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }), 3, null);
        }
        if (MsgList$lambda$3$1(mutableState2)) {
            LazyListScope.CC.m(LazyColumn, null, null, ComposableSingletons$MsgListKt.INSTANCE.m9896getLambda$76109163$app_productionPFast(), 3, null);
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object MsgList$lambda$3$6$0$0(MessageWithPartnerWithReactions m10) {
        y.i(m10, "m");
        return m10.getId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object MsgList$lambda$3$6$0$1(MessageWithPartnerWithReactions m10) {
        y.i(m10, "m");
        return ExtensionFunsKt.getItemMsgType(m10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 MsgList$lambda$3$6$0$2(LazyPagingItems lazyPagingItems, Function1 function1, Context context, final lb.a aVar, boolean z10, boolean z11, final lb.o oVar, final Function2 function2, Function1 function3, Function1 function4, Function1 function5, Function1 function6, final Function3 function7, lb.a aVar2, boolean z12, Function1 function8, final Function3 function9, final Function1 function10, LazyItemScope items, int i10, Composer composer, int i11) {
        Composer composer2;
        MessageWithPartnerWithReactions messageWithPartnerWithReactions;
        Message message;
        y.i(items, "$this$items");
        int i12 = (i11 & 6) == 0 ? i11 | (composer.changed(items) ? 4 : 2) : i11;
        if ((i11 & 48) == 0) {
            i12 |= composer.changed(i10) ? 32 : 16;
        }
        boolean z13 = false;
        if (composer.shouldExecute((i12 & 147) != 146, i12 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(718575358, i12, -1, "cu.todus.android.uiCompose.main.screen.chat.list.MsgList.<anonymous>.<anonymous>.<anonymous>.<anonymous> (MsgList.kt:139)");
            }
            int i13 = i10 + 1;
            String userSender = (lazyPagingItems.getItemCount() <= i13 || (messageWithPartnerWithReactions = (MessageWithPartnerWithReactions) lazyPagingItems.get(i13)) == null || (message = messageWithPartnerWithReactions.getMessage()) == null) ? null : message.getUserSender();
            final MessageWithPartnerWithReactions messageWithPartnerWithReactions2 = (MessageWithPartnerWithReactions) lazyPagingItems.get(i10);
            if (messageWithPartnerWithReactions2 != null) {
                composer.startReplaceGroup(961817903);
                List<Attachment> attachments = messageWithPartnerWithReactions2.getAttachments();
                if (!defpackage.r.a(attachments) || !attachments.isEmpty()) {
                    for (Attachment attachment : attachments) {
                        if (attachment.getType() == 20) {
                            Content content = attachment.getContent();
                            y.g(content, "null cannot be cast to non-null type cu.todus.android.data.db.pojo.content.LinkInfoContent");
                            if (!((LinkInfoContent) content).getDownloadedInfo()) {
                                function1.invoke(messageWithPartnerWithReactions2);
                                break;
                            }
                        }
                    }
                }
                if (messageWithPartnerWithReactions2.getMessage().getPayload() != null) {
                    composer.startReplaceGroup(-1571737631);
                    InfoContentKt.InfoContent(context, messageWithPartnerWithReactions2.getMessage().getPayload(), ((Owner) aVar.invoke()).getNameWithDomain(), messageWithPartnerWithReactions2.getSenderAlias(), composer, 0);
                    composer.endReplaceGroup();
                    composer2 = composer;
                } else {
                    composer.startReplaceGroup(-1571313923);
                    Object objRememberedValue = composer.rememberedValue();
                    Composer.Companion companion = Composer.INSTANCE;
                    if (objRememberedValue == companion.getEmpty()) {
                        objRememberedValue = SnapshotStateKt.derivedStateOf(new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.list.f
                            @Override // lb.a
                            public final Object invoke() {
                                return Boolean.valueOf(MsgListKt.MsgList$lambda$3$6$0$2$0$1$0(function10, messageWithPartnerWithReactions2));
                            }
                        });
                        composer.updateRememberedValue(objRememberedValue);
                    }
                    State state = (State) objRememberedValue;
                    Modifier modifierC = androidx.compose.foundation.lazy.g.c(items, SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), null, null, null, 2, null);
                    String nameWithDomain = ((Owner) aVar.invoke()).getNameWithDomain();
                    String password = ((Owner) aVar.invoke()).getPassword();
                    boolean z14 = !y.d(userSender, messageWithPartnerWithReactions2.getMessage().getUserSender());
                    boolean zMsgList$lambda$3$6$0$2$0$2 = MsgList$lambda$3$6$0$2$0$2(state);
                    if (z10 && ExtensionFunsKt.hasReactions(messageWithPartnerWithReactions2) && messageWithPartnerWithReactions2.available()) {
                        z13 = true;
                    }
                    boolean zChanged = composer.changed(oVar) | composer.changed(aVar) | composer.changed(messageWithPartnerWithReactions2);
                    Object objRememberedValue2 = composer.rememberedValue();
                    if (zChanged || objRememberedValue2 == companion.getEmpty()) {
                        objRememberedValue2 = new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.list.g
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return MsgListKt.MsgList$lambda$3$6$0$2$0$3$0(oVar, aVar, messageWithPartnerWithReactions2, (MessageAction) obj, ((Integer) obj2).intValue());
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue2);
                    }
                    Function2 function11 = (Function2) objRememberedValue2;
                    boolean zChanged2 = composer.changed(function2);
                    Object objRememberedValue3 = composer.rememberedValue();
                    if (zChanged2 || objRememberedValue3 == companion.getEmpty()) {
                        objRememberedValue3 = new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.list.h
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return MsgListKt.MsgList$lambda$3$6$0$2$0$4$0(function2, (MessageWithPartnerWithReactions) obj, ((Integer) obj2).intValue());
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue3);
                    }
                    Function2 function12 = (Function2) objRememberedValue3;
                    boolean zChanged3 = composer.changed(function7) | composer.changed(messageWithPartnerWithReactions2);
                    Object objRememberedValue4 = composer.rememberedValue();
                    if (zChanged3 || objRememberedValue4 == companion.getEmpty()) {
                        objRememberedValue4 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.list.i
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return MsgListKt.MsgList$lambda$3$6$0$2$0$5$0(function7, messageWithPartnerWithReactions2, (String) obj);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue4);
                    }
                    Function1 function13 = (Function1) objRememberedValue4;
                    boolean zChanged4 = composer.changed(function9) | composer.changed(messageWithPartnerWithReactions2);
                    Object objRememberedValue5 = composer.rememberedValue();
                    if (zChanged4 || objRememberedValue5 == companion.getEmpty()) {
                        objRememberedValue5 = new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.list.j
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return MsgListKt.MsgList$lambda$3$6$0$2$0$6$0(function9, messageWithPartnerWithReactions2, (MessageAction) obj, (String) obj2);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue5);
                    }
                    MessageItemKt.MessageItem(modifierC, messageWithPartnerWithReactions2, nameWithDomain, password, z11, z14, zMsgList$lambda$3$6$0$2$0$2, function11, function12, function3, function4, function5, function6, z13, function13, aVar2, z12, function8, (Function2) objRememberedValue5, composer, 0, 0, 0);
                    composer2 = composer;
                    composer2.endReplaceGroup();
                }
                composer2.endReplaceGroup();
            } else {
                composer.startReplaceGroup(964982693);
                ChatPlaceholderKt.RandomChatPlaceholder(composer, 0);
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
    public static final boolean MsgList$lambda$3$6$0$2$0$1$0(Function1 function1, MessageWithPartnerWithReactions messageWithPartnerWithReactions) {
        return ((Boolean) function1.invoke(messageWithPartnerWithReactions.getMessage().getId())).booleanValue();
    }

    private static final boolean MsgList$lambda$3$6$0$2$0$2(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 MsgList$lambda$3$6$0$2$0$3$0(lb.o oVar, lb.a aVar, MessageWithPartnerWithReactions messageWithPartnerWithReactions, MessageAction messageAction, int i10) {
        y.i(messageAction, "messageAction");
        oVar.invoke(Boolean.valueOf(y.d(((Owner) aVar.invoke()).getNameWithDomain(), messageWithPartnerWithReactions.getMessage().getUserSender())), messageAction, messageWithPartnerWithReactions, Integer.valueOf(i10));
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 MsgList$lambda$3$6$0$2$0$4$0(Function2 function2, MessageWithPartnerWithReactions a10, int i10) {
        y.i(a10, "a1");
        function2.invoke(a10, Integer.valueOf(i10));
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 MsgList$lambda$3$6$0$2$0$5$0(Function3 function3, MessageWithPartnerWithReactions messageWithPartnerWithReactions, String it) {
        y.i(it, "it");
        function3.invoke(messageWithPartnerWithReactions.getMessage().getRoomId(), messageWithPartnerWithReactions.getMessage().getId(), it);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 MsgList$lambda$3$6$0$2$0$6$0(Function3 function3, MessageWithPartnerWithReactions messageWithPartnerWithReactions, MessageAction messageAction, String value) {
        y.i(messageAction, "messageAction");
        y.i(value, "value");
        function3.invoke(messageWithPartnerWithReactions, messageAction, value);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 MsgList$lambda$3$6$0$3(LazyPagingItems lazyPagingItems, final String str, final lb.a aVar, final lb.a aVar2, LazyItemScope item, Composer composer, int i10) {
        y.i(item, "$this$item");
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-846208980, i10, -1, "cu.todus.android.uiCompose.main.screen.chat.list.MsgList.<anonymous>.<anonymous>.<anonymous>.<anonymous> (MsgList.kt:216)");
            }
            PagerStateIndicatorKt.PagerStateIndicator(ComposableSingletons$MsgListKt.INSTANCE.getLambda$2139340831$app_productionPFast(), null, null, ComposableLambdaKt.rememberComposableLambda(340570914, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.chat.list.e
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return MsgListKt.MsgList$lambda$3$6$0$3$0(str, aVar, aVar2, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), lazyPagingItems, composer, (LazyPagingItems.$stable << 12) | 3078, 6);
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
    public static final k0 MsgList$lambda$3$6$0$3$0(String str, lb.a aVar, lb.a aVar2, Modifier it, Composer composer, int i10) {
        int i11;
        y.i(it, "it");
        if ((i10 & 6) == 0) {
            i11 = i10 | (composer.changed(it) ? 4 : 2);
        } else {
            i11 = i10;
        }
        if (composer.shouldExecute((i11 & 19) != 18, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(340570914, i11, -1, "cu.todus.android.uiCompose.main.screen.chat.list.MsgList.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (MsgList.kt:222)");
            }
            XMPPUtils xMPPUtils = XMPPUtils.INSTANCE;
            p0.l lVarQ = p0.r.q(p0.n.a.a(p0.n.a.b(!xMPPUtils.isChannel(str) ? R.raw.empty_chat : R.raw.empty_channel)), null, null, null, null, null, composer, 0, 62);
            Alignment.Companion companion = Alignment.INSTANCE;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion.getCenter(), false);
            int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, it);
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
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion2.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl, companion2.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion2.getSetModifier());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            Alignment.Horizontal centerHorizontally = companion.getCenterHorizontally();
            Modifier.Companion companion3 = Modifier.INSTANCE;
            Arrangement arrangement = Arrangement.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(arrangement.getTop(), centerHorizontally, composer, 48);
            int iA2 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer, companion3);
            lb.a constructor2 = companion2.getConstructor();
            if (!defpackage.r.a(composer.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor2);
            } else {
                composer.useNode();
            }
            Composer composerM5176constructorimpl2 = Updater.m5176constructorimpl(composer);
            Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyColumnMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap2, companion2.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl2, Integer.valueOf(iA2), companion2.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl2, companion2.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier2, companion2.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            p0.e.a(MsgList$lambda$3$6$0$3$0$0(lVarQ), SizeKt.m1769size3ABfNKs(companion3, Dp.m8823constructorimpl(100)), false, false, null, 0.0f, Integer.MAX_VALUE, false, false, false, false, null, false, false, null, null, null, false, false, null, false, null, composer, 1572912, 0, 0, 4194236);
            float f10 = 20;
            Modifier modifierM1725padding3ABfNKs = PaddingKt.m1725padding3ABfNKs(SizeKt.fillMaxWidth$default(companion3, 0.0f, 1, null), Dp.m8823constructorimpl(f10));
            MaterialTheme materialTheme = MaterialTheme.INSTANCE;
            int i12 = MaterialTheme.$stable;
            Z17LabelKt.m10262Z17LabelfWhpE4E(PaddingKt.m1725padding3ABfNKs(BackgroundKt.m1204backgroundbw27NRU(modifierM1725padding3ABfNKs, Color.m5865copywmQWz5c$default(materialTheme.getColorScheme(composer, i12).getOnBackground(), 0.2f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(10))), Dp.m8823constructorimpl(f10)), StringResources_androidKt.stringResource(!xMPPUtils.isChannel(str) ? R.string.start_chatting_by_typing : R.string.pull_down_to_load_old_msgs, composer, 0), TextStyle.m8271copyp1EtxEg$default(materialTheme.getTypography(composer, i12).getBodyMedium(), 0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, TextAlign.INSTANCE.m8692getCentere0LSkKk(), 0, 0L, null, null, null, 0, 0, null, 16744447, null), 0L, 0, 0, composer, 0, 56);
            if (xMPPUtils.isUser(str)) {
                composer.startReplaceGroup(1971316989);
                Modifier modifierM1725padding3ABfNKs2 = PaddingKt.m1725padding3ABfNKs(SizeKt.fillMaxWidth$default(companion3, 0.0f, 1, null), Dp.m8823constructorimpl(f10));
                MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getSpaceBetween(), companion.getCenterVertically(), composer, 54);
                int iA3 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
                CompositionLocalMap currentCompositionLocalMap3 = composer.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composer, modifierM1725padding3ABfNKs2);
                lb.a constructor3 = companion2.getConstructor();
                if (!defpackage.r.a(composer.getApplier())) {
                    ComposablesKt.invalidApplier();
                }
                composer.startReusableNode();
                if (composer.getInserting()) {
                    composer.createNode(constructor3);
                } else {
                    composer.useNode();
                }
                Composer composerM5176constructorimpl3 = Updater.m5176constructorimpl(composer);
                Updater.m5184setimpl(composerM5176constructorimpl3, measurePolicyRowMeasurePolicy, companion2.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl3, currentCompositionLocalMap3, companion2.getSetResolvedCompositionLocals());
                Updater.m5180initimpl(composerM5176constructorimpl3, Integer.valueOf(iA3), companion2.getSetCompositeKeyHash());
                Updater.m5182reconcileimpl(composerM5176constructorimpl3, companion2.getApplyOnDeactivatedNodeAssertion());
                Updater.m5184setimpl(composerM5176constructorimpl3, modifierMaterializeModifier3, companion2.getSetModifier());
                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                String strStringResource = StringResources_androidKt.stringResource(R.string.visit_catalogue, composer, 0);
                ComposableSingletons$MsgListKt composableSingletons$MsgListKt = ComposableSingletons$MsgListKt.INSTANCE;
                Z17ButtonsKt.Z17SecondaryDialogButton(null, aVar, strStringResource, composableSingletons$MsgListKt.getLambda$1578902171$app_productionPFast(), false, false, false, composer, 3072, 113);
                Z17ButtonsKt.Z17SecondaryDialogButton(null, aVar2, StringResources_androidKt.stringResource(R.string.view_social, composer, 0), composableSingletons$MsgListKt.m9895getLambda$385672366$app_productionPFast(), false, false, false, composer, 3072, 113);
                composer.endNode();
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(1973544804);
                composer.endReplaceGroup();
            }
            composer.endNode();
            composer.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    private static final l0.j MsgList$lambda$3$6$0$3$0$0(p0.l lVar) {
        return (l0.j) lVar.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 MsgList$lambda$4(Modifier modifier, LazyListState lazyListState, LazyPagingItems lazyPagingItems, lb.a aVar, Function1 function1, boolean z10, String str, String str2, Function1 function2, Function1 function3, boolean z11, Function1 function4, boolean z12, Function3 function5, lb.a aVar2, Function1 function6, Function1 function7, Function1 function8, lb.o oVar, Function2 function9, Function3 function10, lb.a aVar3, lb.a aVar4, int i10, int i11, int i12, int i13, Composer composer, int i14) {
        MsgList(modifier, lazyListState, lazyPagingItems, aVar, function1, z10, str, str2, function2, function3, z11, function4, z12, function5, aVar2, function6, function7, function8, oVar, function9, function10, aVar3, aVar4, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), RecomposeScopeImplKt.updateChangedFlags(i11), RecomposeScopeImplKt.updateChangedFlags(i12), i13);
        return k0.f43947a;
    }
}
