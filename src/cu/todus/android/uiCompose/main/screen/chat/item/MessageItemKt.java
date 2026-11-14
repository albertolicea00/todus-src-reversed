package cu.todus.android.uiCompose.main.screen.chat.item;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
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
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.window.AndroidPopup_androidKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.common.C;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.profileinstaller.ProfileVerifier;
import cu.todus.android.R;
import cu.todus.android.data.db.entity.toDus.Attachment;
import cu.todus.android.data.db.entity.toDus.Reaction;
import cu.todus.android.data.db.pojo.MessageWithPartnerWithReactions;
import cu.todus.android.data.db.pojo.content.Content;
import cu.todus.android.data.db.pojo.content.ReplyMsgContent;
import cu.todus.android.uiCompose.main.screen.chat.item.content.AudioContentKt;
import cu.todus.android.uiCompose.main.screen.chat.item.content.ButtonContentKt;
import cu.todus.android.uiCompose.main.screen.chat.item.content.CallContentKt;
import cu.todus.android.uiCompose.main.screen.chat.item.content.ContactContentKt;
import cu.todus.android.uiCompose.main.screen.chat.item.content.DelayedContentKt;
import cu.todus.android.uiCompose.main.screen.chat.item.content.DeleteContentKt;
import cu.todus.android.uiCompose.main.screen.chat.item.content.EventContentKt;
import cu.todus.android.uiCompose.main.screen.chat.item.content.FileContentKt;
import cu.todus.android.uiCompose.main.screen.chat.item.content.GifContentKt;
import cu.todus.android.uiCompose.main.screen.chat.item.content.ImageContentKt;
import cu.todus.android.uiCompose.main.screen.chat.item.content.LinksContentKt;
import cu.todus.android.uiCompose.main.screen.chat.item.content.LocationContentKt;
import cu.todus.android.uiCompose.main.screen.chat.item.content.NoCompatibleContentKt;
import cu.todus.android.uiCompose.main.screen.chat.item.content.StickerContentKt;
import cu.todus.android.uiCompose.main.screen.chat.item.content.TextContentKt;
import cu.todus.android.uiCompose.main.screen.chat.item.content.VideoContentKt;
import cu.todus.android.uiCompose.main.screen.chat.item.content.VoiceContentKt;
import cu.todus.android.uiCompose.main.screen.statusList.StatusItemKt;
import cu.todus.android.utils.ColorGenerator;
import cu.todus.android.utils.ExtensionFunsKt;
import cu.todus.android.volatileState.AppVolatileState;
import cu.todus.android.xmpp.XMPPUtils;
import cu.z17.views.label.Z17LabelKt;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\u001a\u00ad\u0002\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0018\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\u000b2\u0018\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\u000b2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000e0\u00112\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\u00112\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u000e0\u00112\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000e0\u00112\u0006\u0010\u0017\u001a\u00020\u00072\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000e0\u00112\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00192\u0006\u0010\u001b\u001a\u00020\u00072\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000e0\u00112\u001a\b\u0002\u0010\u001d\u001a\u0014\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000e0\u000bH\u0007¢\u0006\u0004\b\u001e\u0010\u001f\u001a}\u0010 \u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0018\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\u000b2\u0018\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\u000b2\u0018\u0010\u001d\u001a\u0014\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000e0\u000bH\u0007¢\u0006\u0004\b \u0010!\u001aG\u0010\"\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\u00112\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000e0\u0011H\u0007¢\u0006\u0004\b\"\u0010#¨\u0006%²\u0006\u000e\u0010$\u001a\u00020\u00078\n@\nX\u008a\u008e\u0002"}, d2 = {"Landroidx/compose/ui/Modifier;", "modifier", "Lcu/todus/android/data/db/pojo/MessageWithPartnerWithReactions;", "msg", "", "ownerId", "ownerToken", "", "isSecret", "isFirst", "isSelected", "Lkotlin/Function2;", "Lcu/todus/android/uiCompose/main/screen/chat/item/MessageAction;", "", "Lua/k0;", "onClick", "onLongClick", "Lkotlin/Function1;", "onGroupMemberNameClicked", "onClickOnReply", "Lcu/todus/android/data/db/entity/toDus/Message;", "displaySingleMsgRead", "onClickOnStatus", "canReact", "onReacted", "Lkotlin/Function0;", "onEditReactSelection", "canReply", "onReply", "onMsgEntityClick", "MessageItem", "(Landroidx/compose/ui/Modifier;Lcu/todus/android/data/db/pojo/MessageWithPartnerWithReactions;Ljava/lang/String;Ljava/lang/String;ZZZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;ZLkotlin/jvm/functions/Function1;Llb/a;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "MessageContent", "(Lcu/todus/android/data/db/pojo/MessageWithPartnerWithReactions;Ljava/lang/String;Ljava/lang/String;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "ReplyQuote", "(Ljava/lang/String;Lcu/todus/android/data/db/pojo/MessageWithPartnerWithReactions;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "showReaction", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class MessageItemKt {

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[MessageItemType.values().length];
            try {
                iArr[MessageItemType.LINKS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MessageItemType.EMPTY_MESSAGE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[MessageItemType.MESSAGE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[MessageItemType.STICKER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[MessageItemType.IMAGE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[MessageItemType.GIF.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[MessageItemType.VOICE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[MessageItemType.AUDIO.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[MessageItemType.VIDEO.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[MessageItemType.CONTACT.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[MessageItemType.FILE.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[MessageItemType.EVENT.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[MessageItemType.LOCATION.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr[MessageItemType.BUTTON.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr[MessageItemType.CALL.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr[MessageItemType.DELAYED_MESSAGE.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                iArr[MessageItemType.DELETE.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void MessageContent(final MessageWithPartnerWithReactions msg, final String ownerId, final String ownerToken, final boolean z10, final Function2 onClick, final Function2 onLongClick, final Function2 onMsgEntityClick, Composer composer, final int i10) {
        int i11;
        kotlin.jvm.internal.y.i(msg, "msg");
        kotlin.jvm.internal.y.i(ownerId, "ownerId");
        kotlin.jvm.internal.y.i(ownerToken, "ownerToken");
        kotlin.jvm.internal.y.i(onClick, "onClick");
        kotlin.jvm.internal.y.i(onLongClick, "onLongClick");
        kotlin.jvm.internal.y.i(onMsgEntityClick, "onMsgEntityClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(913012115);
        if ((i10 & 6) == 0) {
            i11 = (composerStartRestartGroup.changed(msg) ? 4 : 2) | i10;
        } else {
            i11 = i10;
        }
        if ((i10 & 48) == 0) {
            i11 |= composerStartRestartGroup.changed(ownerId) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i11 |= composerStartRestartGroup.changed(ownerToken) ? 256 : 128;
        }
        if ((i10 & 3072) == 0) {
            i11 |= composerStartRestartGroup.changed(z10) ? 2048 : 1024;
        }
        if ((i10 & 24576) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(onClick) ? 16384 : 8192;
        }
        if ((196608 & i10) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(onLongClick) ? 131072 : 65536;
        }
        if ((1572864 & i10) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(onMsgEntityClick) ? 1048576 : 524288;
        }
        if (composerStartRestartGroup.shouldExecute((599187 & i11) != 599186, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(913012115, i11, -1, "cu.todus.android.uiCompose.main.screen.chat.item.MessageContent (MessageItem.kt:246)");
            }
            switch (WhenMappings.$EnumSwitchMapping$0[ExtensionFunsKt.getItemMsgType(msg).ordinal()]) {
                case 1:
                    composerStartRestartGroup.startReplaceGroup(-483601057);
                    int i12 = i11 >> 9;
                    LinksContentKt.LinksContent(msg, onClick, onLongClick, onMsgEntityClick, composerStartRestartGroup, (i11 & 14) | (i12 & 112) | (i12 & 896) | (i12 & 7168), 0);
                    composerStartRestartGroup = composerStartRestartGroup;
                    composerStartRestartGroup.endReplaceGroup();
                    break;
                case 2:
                    composerStartRestartGroup.startReplaceGroup(-483332318);
                    NoCompatibleContentKt.NoCompatibleContent(composerStartRestartGroup, 0);
                    composerStartRestartGroup.endReplaceGroup();
                    break;
                case 3:
                    composerStartRestartGroup.startReplaceGroup(-483226391);
                    TextContentKt.m9893TextContentOadGlvw(msg.getMessage().getContent(), 0L, onClick, onLongClick, 0, onMsgEntityClick, composerStartRestartGroup, ((i11 >> 6) & 8064) | ((i11 >> 3) & 458752), 18);
                    composerStartRestartGroup = composerStartRestartGroup;
                    composerStartRestartGroup.endReplaceGroup();
                    break;
                case 4:
                    composerStartRestartGroup.startReplaceGroup(-482944942);
                    int i13 = i11 >> 9;
                    StickerContentKt.StickerContent(msg, onClick, onLongClick, composerStartRestartGroup, (i11 & 14) | (i13 & 112) | (i13 & 896));
                    composerStartRestartGroup.endReplaceGroup();
                    break;
                case 5:
                    composerStartRestartGroup.startReplaceGroup(-482733801);
                    int i14 = i11 >> 6;
                    ImageContentKt.ImageContent(msg, ownerId, onClick, onLongClick, z10, onMsgEntityClick, composerStartRestartGroup, (i11 & 126) | (i14 & 896) | (i14 & 7168) | ((i11 << 3) & 57344) | ((i11 >> 3) & 458752), 0);
                    composerStartRestartGroup.endReplaceGroup();
                    break;
                case 6:
                    composerStartRestartGroup.startReplaceGroup(-482412362);
                    int i15 = i11 >> 9;
                    GifContentKt.GifContent(msg, onClick, onLongClick, composerStartRestartGroup, (i11 & 14) | (i15 & 112) | (i15 & 896));
                    composerStartRestartGroup.endReplaceGroup();
                    break;
                case 7:
                    composerStartRestartGroup.startReplaceGroup(-482206708);
                    int i16 = i11 >> 6;
                    VoiceContentKt.VoiceContent(msg, ownerId, onClick, onLongClick, z10, composerStartRestartGroup, (i11 & 126) | (i16 & 896) | (i16 & 7168) | ((i11 << 3) & 57344));
                    composerStartRestartGroup = composerStartRestartGroup;
                    composerStartRestartGroup.endReplaceGroup();
                    break;
                case 8:
                    composerStartRestartGroup.startReplaceGroup(-481928297);
                    int i17 = i11 >> 6;
                    AudioContentKt.AudioContent(msg, ownerId, onClick, onLongClick, z10, onMsgEntityClick, composerStartRestartGroup, (i11 & 126) | (i17 & 896) | (i17 & 7168) | ((i11 << 3) & 57344) | ((i11 >> 3) & 458752), 0);
                    composerStartRestartGroup.endReplaceGroup();
                    break;
                case 9:
                    composerStartRestartGroup.startReplaceGroup(-481598953);
                    int i18 = i11 >> 6;
                    VideoContentKt.VideoContent(msg, ownerId, onClick, onLongClick, z10, onMsgEntityClick, composerStartRestartGroup, (i11 & 126) | (i18 & 896) | (i18 & 7168) | ((i11 << 3) & 57344) | ((i11 >> 3) & 458752), 0);
                    composerStartRestartGroup.endReplaceGroup();
                    break;
                case 10:
                    composerStartRestartGroup.startReplaceGroup(-481269454);
                    int i19 = i11 >> 9;
                    ContactContentKt.ContactContent(msg, onClick, onLongClick, composerStartRestartGroup, (i11 & 14) | (i19 & 112) | (i19 & 896));
                    composerStartRestartGroup.endReplaceGroup();
                    break;
                case 11:
                    composerStartRestartGroup.startReplaceGroup(-481060328);
                    int i20 = i11 >> 3;
                    FileContentKt.FileContent(msg, ownerId, z10, onClick, onLongClick, onMsgEntityClick, composerStartRestartGroup, (i11 & 126) | (i20 & 896) | (i20 & 7168) | (i20 & 57344) | (i20 & 458752), 0);
                    composerStartRestartGroup.endReplaceGroup();
                    break;
                case 12:
                    composerStartRestartGroup.startReplaceGroup(-480735820);
                    int i21 = i11 >> 9;
                    EventContentKt.EventContent(msg, onClick, onLongClick, composerStartRestartGroup, (i11 & 14) | (i21 & 112) | (i21 & 896));
                    composerStartRestartGroup.endReplaceGroup();
                    break;
                case 13:
                    composerStartRestartGroup.startReplaceGroup(-480523191);
                    int i22 = i11 >> 6;
                    LocationContentKt.LocationContent(msg, ownerToken, onClick, onLongClick, composerStartRestartGroup, (i11 & 14) | ((i11 >> 3) & 112) | (i22 & 896) | (i22 & 7168));
                    composerStartRestartGroup.endReplaceGroup();
                    break;
                case 14:
                    composerStartRestartGroup.startReplaceGroup(-480272866);
                    int i23 = i11 >> 9;
                    ButtonContentKt.ButtonContent(msg, onClick, onLongClick, onMsgEntityClick, composerStartRestartGroup, (i11 & 14) | (i23 & 112) | (i23 & 896) | (i23 & 7168), 0);
                    composerStartRestartGroup.endReplaceGroup();
                    break;
                case 15:
                    composerStartRestartGroup.startReplaceGroup(-480016558);
                    int i24 = i11 >> 9;
                    CallContentKt.CallContent(msg, onClick, onLongClick, ownerId, composerStartRestartGroup, (i11 & 14) | (i24 & 112) | (i24 & 896) | ((i11 << 6) & 7168), 0);
                    composerStartRestartGroup.endReplaceGroup();
                    break;
                case 16:
                    composerStartRestartGroup.startReplaceGroup(-479770201);
                    DelayedContentKt.DelayedContent(composerStartRestartGroup, 0);
                    composerStartRestartGroup.endReplaceGroup();
                    break;
                case 17:
                    composerStartRestartGroup.startReplaceGroup(-479676984);
                    DeleteContentKt.DeleteContent(composerStartRestartGroup, 0);
                    composerStartRestartGroup.endReplaceGroup();
                    break;
                default:
                    composerStartRestartGroup.startReplaceGroup(-479621277);
                    composerStartRestartGroup.endReplaceGroup();
                    break;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.item.o
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return MessageItemKt.MessageContent$lambda$0(msg, ownerId, ownerToken, z10, onClick, onLongClick, onMsgEntityClick, i10, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 MessageContent$lambda$0(MessageWithPartnerWithReactions messageWithPartnerWithReactions, String str, String str2, boolean z10, Function2 function2, Function2 function3, Function2 function4, int i10, Composer composer, int i11) {
        MessageContent(messageWithPartnerWithReactions, str, str2, z10, function2, function3, function4, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1));
        return ua.k0.f43947a;
    }

    /* JADX WARN: Code duplicated, block: B:167:0x0299  */
    /* JADX WARN: Code duplicated, block: B:168:0x029c  */
    /* JADX WARN: Code duplicated, block: B:173:0x02ac  */
    /* JADX WARN: Code duplicated, block: B:176:0x02bf  */
    /* JADX WARN: Code duplicated, block: B:177:0x02c2  */
    /* JADX WARN: Code duplicated, block: B:180:0x02cc  */
    /* JADX WARN: Code duplicated, block: B:181:0x02cf  */
    /* JADX WARN: Code duplicated, block: B:186:0x02e0  */
    /* JADX WARN: Code duplicated, block: B:189:0x02f2  */
    /* JADX WARN: Code duplicated, block: B:191:0x02f7  */
    /* JADX WARN: Code duplicated, block: B:193:0x02fc  */
    /* JADX WARN: Code duplicated, block: B:198:0x030e  */
    /* JADX WARN: Code duplicated, block: B:201:0x035c  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void MessageItem(final Modifier modifier, final MessageWithPartnerWithReactions msg, final String ownerId, final String ownerToken, final boolean z10, final boolean z11, final boolean z12, final Function2 onClick, final Function2 onLongClick, final Function1 onGroupMemberNameClicked, final Function1 onClickOnReply, final Function1 displaySingleMsgRead, final Function1 onClickOnStatus, final boolean z13, final Function1 onReacted, final lb.a onEditReactSelection, final boolean z14, final Function1 onReply, Function2 function2, Composer composer, final int i10, final int i11, final int i12) {
        int i13;
        int i14;
        Composer composer2;
        final Function2 function3;
        final Function2 function4;
        boolean z15;
        boolean z16;
        boolean z17;
        Object objRememberedValue;
        boolean z18;
        int i15;
        boolean z19;
        boolean z20;
        Object objRememberedValue2;
        boolean z21;
        boolean z22;
        Object objRememberedValue3;
        kotlin.jvm.internal.y.i(modifier, "modifier");
        kotlin.jvm.internal.y.i(msg, "msg");
        kotlin.jvm.internal.y.i(ownerId, "ownerId");
        kotlin.jvm.internal.y.i(ownerToken, "ownerToken");
        kotlin.jvm.internal.y.i(onClick, "onClick");
        kotlin.jvm.internal.y.i(onLongClick, "onLongClick");
        kotlin.jvm.internal.y.i(onGroupMemberNameClicked, "onGroupMemberNameClicked");
        kotlin.jvm.internal.y.i(onClickOnReply, "onClickOnReply");
        kotlin.jvm.internal.y.i(displaySingleMsgRead, "displaySingleMsgRead");
        kotlin.jvm.internal.y.i(onClickOnStatus, "onClickOnStatus");
        kotlin.jvm.internal.y.i(onReacted, "onReacted");
        kotlin.jvm.internal.y.i(onEditReactSelection, "onEditReactSelection");
        kotlin.jvm.internal.y.i(onReply, "onReply");
        Composer composerStartRestartGroup = composer.startRestartGroup(1673154380);
        if ((i10 & 6) == 0) {
            i13 = i10 | (composerStartRestartGroup.changed(modifier) ? 4 : 2);
        } else {
            i13 = i10;
        }
        if ((i10 & 48) == 0) {
            i13 |= composerStartRestartGroup.changed(msg) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i13 |= composerStartRestartGroup.changed(ownerId) ? 256 : 128;
        }
        if ((i10 & 3072) == 0) {
            i13 |= composerStartRestartGroup.changed(ownerToken) ? 2048 : 1024;
        }
        if ((i10 & 24576) == 0) {
            i13 |= composerStartRestartGroup.changed(z10) ? 16384 : 8192;
        }
        if ((i10 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            i13 |= composerStartRestartGroup.changed(z11) ? 131072 : 65536;
        }
        if ((i10 & 1572864) == 0) {
            i13 |= composerStartRestartGroup.changed(z12) ? 1048576 : 524288;
        }
        if ((i10 & 12582912) == 0) {
            i13 |= composerStartRestartGroup.changedInstance(onClick) ? 8388608 : 4194304;
        }
        if ((i10 & 100663296) == 0) {
            i13 |= composerStartRestartGroup.changedInstance(onLongClick) ? 67108864 : 33554432;
        }
        if ((i10 & 805306368) == 0) {
            i13 |= composerStartRestartGroup.changedInstance(onGroupMemberNameClicked) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
        }
        int i16 = i13;
        if ((i11 & 6) == 0) {
            i14 = i11 | (composerStartRestartGroup.changedInstance(onClickOnReply) ? 4 : 2);
        } else {
            i14 = i11;
        }
        if ((i11 & 48) == 0) {
            i14 |= composerStartRestartGroup.changedInstance(displaySingleMsgRead) ? 32 : 16;
        }
        if ((i11 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i14 |= composerStartRestartGroup.changedInstance(onClickOnStatus) ? 256 : 128;
        }
        if ((i11 & 3072) == 0) {
            i14 |= composerStartRestartGroup.changed(z13) ? 2048 : 1024;
        }
        if ((i11 & 24576) == 0) {
            i14 |= composerStartRestartGroup.changedInstance(onReacted) ? 16384 : 8192;
        }
        if ((i11 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            i14 |= composerStartRestartGroup.changedInstance(onEditReactSelection) ? 131072 : 65536;
        }
        if ((i11 & 1572864) == 0) {
            i14 |= composerStartRestartGroup.changed(z14) ? 1048576 : 524288;
        }
        if ((i11 & 12582912) == 0) {
            i14 |= composerStartRestartGroup.changedInstance(onReply) ? 8388608 : 4194304;
        }
        int i17 = i12 & 262144;
        if (i17 != 0) {
            i14 |= 100663296;
        } else if ((i11 & 100663296) == 0) {
            i14 |= composerStartRestartGroup.changedInstance(function2) ? 67108864 : 33554432;
        }
        int i18 = i14;
        if (composerStartRestartGroup.shouldExecute(((i16 & 306783379) == 306783378 && (38347923 & i18) == 38347922) ? false : true, i16 & 1)) {
            if (i17 != 0) {
                Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue4 = new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.item.v
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return MessageItemKt.MessageItem$lambda$0$0((MessageAction) obj, (String) obj2);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                function4 = (Function2) objRememberedValue4;
            } else {
                function4 = function2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1673154380, i16, i18, "cu.todus.android.uiCompose.main.screen.chat.item.MessageItem (MessageItem.kt:92)");
            }
            Alignment topEnd = kotlin.jvm.internal.y.d(ownerId, msg.getMessage().getUserSender()) ? Alignment.INSTANCE.getTopEnd() : Alignment.INSTANCE.getTopStart();
            if (z14) {
                z15 = true;
                if (!va.w.q(4, -1, 0, 7).contains(Integer.valueOf(msg.getMessage().getState()))) {
                    z16 = true;
                }
                if ((i16 & 29360128) == 8388608) {
                    z17 = z15;
                } else {
                    z17 = false;
                }
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (z17 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.item.w
                        @Override // lb.a
                        public final Object invoke() {
                            return MessageItemKt.MessageItem$lambda$1$0(onClick);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                lb.a aVar = (lb.a) objRememberedValue;
                if ((234881024 & i16) == 67108864) {
                    z18 = z15;
                } else {
                    z18 = false;
                }
                i15 = i16 & 112;
                if (i15 == 32) {
                    z19 = z15;
                } else {
                    z19 = false;
                }
                z20 = z19 | z18;
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (z20 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.item.x
                        @Override // lb.a
                        public final Object invoke() {
                            return MessageItemKt.MessageItem$lambda$2$0(onLongClick, msg);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                lb.a aVar2 = (lb.a) objRememberedValue2;
                if ((i18 & 29360128) == 8388608) {
                    z21 = z15;
                } else {
                    z21 = false;
                }
                z22 = z21 | (i15 == 32 ? z15 : false);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (z22 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.item.l
                        @Override // lb.a
                        public final Object invoke() {
                            return MessageItemKt.MessageItem$lambda$3$0(onReply, msg);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                MessageContainerKt.ChatItemBox(modifier, aVar, aVar2, z16, (lb.a) objRememberedValue3, topEnd, ComposableLambdaKt.rememberComposableLambda(701785542, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.chat.item.m
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return MessageItemKt.MessageItem$lambda$4(onLongClick, z13, msg, onClick, ownerId, z11, z12, displaySingleMsgRead, onGroupMemberNameClicked, onClickOnReply, onClickOnStatus, ownerToken, z10, function4, onReacted, onEditReactSelection, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, (i16 & 14) | 1572864, 0);
                composer2 = composerStartRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function3 = function4;
            } else {
                z15 = true;
            }
            z16 = false;
            if ((i16 & 29360128) == 8388608) {
                z17 = z15;
            } else {
                z17 = false;
            }
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z17) {
                objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.item.w
                    @Override // lb.a
                    public final Object invoke() {
                        return MessageItemKt.MessageItem$lambda$1$0(onClick);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.item.w
                    @Override // lb.a
                    public final Object invoke() {
                        return MessageItemKt.MessageItem$lambda$1$0(onClick);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            lb.a aVar3 = (lb.a) objRememberedValue;
            if ((234881024 & i16) == 67108864) {
                z18 = z15;
            } else {
                z18 = false;
            }
            i15 = i16 & 112;
            if (i15 == 32) {
                z19 = z15;
            } else {
                z19 = false;
            }
            z20 = z19 | z18;
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (z20) {
                objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.item.x
                    @Override // lb.a
                    public final Object invoke() {
                        return MessageItemKt.MessageItem$lambda$2$0(onLongClick, msg);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            } else {
                objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.item.x
                    @Override // lb.a
                    public final Object invoke() {
                        return MessageItemKt.MessageItem$lambda$2$0(onLongClick, msg);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            lb.a aVar4 = (lb.a) objRememberedValue2;
            if ((i18 & 29360128) == 8388608) {
                z21 = z15;
            } else {
                z21 = false;
            }
            z22 = z21 | (i15 == 32 ? z15 : false);
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (z22) {
                objRememberedValue3 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.item.l
                    @Override // lb.a
                    public final Object invoke() {
                        return MessageItemKt.MessageItem$lambda$3$0(onReply, msg);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            } else {
                objRememberedValue3 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.item.l
                    @Override // lb.a
                    public final Object invoke() {
                        return MessageItemKt.MessageItem$lambda$3$0(onReply, msg);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            MessageContainerKt.ChatItemBox(modifier, aVar3, aVar4, z16, (lb.a) objRememberedValue3, topEnd, ComposableLambdaKt.rememberComposableLambda(701785542, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.chat.item.m
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return MessageItemKt.MessageItem$lambda$4(onLongClick, z13, msg, onClick, ownerId, z11, z12, displaySingleMsgRead, onGroupMemberNameClicked, onClickOnReply, onClickOnStatus, ownerToken, z10, function4, onReacted, onEditReactSelection, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, (i16 & 14) | 1572864, 0);
            composer2 = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            function3 = function4;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            function3 = function2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.item.n
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return MessageItemKt.MessageItem$lambda$5(modifier, msg, ownerId, ownerToken, z10, z11, z12, onClick, onLongClick, onGroupMemberNameClicked, onClickOnReply, displaySingleMsgRead, onClickOnStatus, z13, onReacted, onEditReactSelection, z14, onReply, function3, i10, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 MessageItem$lambda$0$0(MessageAction messageAction, String str) {
        kotlin.jvm.internal.y.i(messageAction, "<unused var>");
        kotlin.jvm.internal.y.i(str, "<unused var>");
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 MessageItem$lambda$1$0(Function2 function2) {
        function2.invoke(MessageAction.REGULAR_CLICK, 0);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 MessageItem$lambda$2$0(Function2 function2, MessageWithPartnerWithReactions messageWithPartnerWithReactions) {
        function2.invoke(messageWithPartnerWithReactions, 0);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 MessageItem$lambda$3$0(Function1 function1, MessageWithPartnerWithReactions messageWithPartnerWithReactions) {
        function1.invoke(messageWithPartnerWithReactions);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:79:0x01d2  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 MessageItem$lambda$4(Function2 function2, final boolean z10, final MessageWithPartnerWithReactions messageWithPartnerWithReactions, Function2 function3, final String str, boolean z11, boolean z12, Function1 function1, Function1 function4, Function1 function5, Function1 function6, String str2, boolean z13, Function2 function7, final Function1 function8, final lb.a aVar, Modifier it, Composer composer, int i10) {
        int i11;
        long jM5901getTransparent0d7_KjU;
        long jM5865copywmQWz5c$default;
        Composer composer2;
        boolean z14;
        int i12;
        Object obj;
        ab.e eVar;
        MutableState<String> showingReplyTo;
        MutableState<String> showingReplyTo2;
        Function2 function9 = function2;
        kotlin.jvm.internal.y.i(it, "it");
        if ((i10 & 6) == 0) {
            i11 = i10 | (composer.changed(it) ? 4 : 2);
        } else {
            i11 = i10;
        }
        if (composer.shouldExecute((i11 & 19) != 18, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(701785542, i11, -1, "cu.todus.android.uiCompose.main.screen.chat.item.MessageItem.<anonymous> (MessageItem.kt:112)");
            }
            Object objRememberedValue = composer.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                composer.updateRememberedValue(objRememberedValue);
            }
            final MutableState mutableState = (MutableState) objRememberedValue;
            boolean zChanged = composer.changed(z10) | composer.changed(function9) | composer.changed(messageWithPartnerWithReactions) | composer.changed(function3);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChanged || objRememberedValue2 == companion.getEmpty()) {
                MessageItemKt$MessageItem$5$1$1 messageItemKt$MessageItem$5$1$1 = new MessageItemKt$MessageItem$5$1$1(z10, function9, messageWithPartnerWithReactions, mutableState, function3);
                composer.updateRememberedValue(messageItemKt$MessageItem$5$1$1);
                objRememberedValue2 = messageItemKt$MessageItem$5$1$1;
            }
            Modifier modifierM1728paddingqDBjuR0 = PaddingKt.m1728paddingqDBjuR0(SuspendingPointerInputFilterKt.pointerInput(it, function9, (PointerInputEventHandler) objRememberedValue2), Dp.m8823constructorimpl(kotlin.jvm.internal.y.d(str, messageWithPartnerWithReactions.getMessage().getUserSender()) ? 80 : 8), Dp.m8823constructorimpl(z11 ? 6 : 2), Dp.m8823constructorimpl(!kotlin.jvm.internal.y.d(str, messageWithPartnerWithReactions.getMessage().getUserSender()) ? 80 : 8), Dp.m8823constructorimpl(2));
            if (ExtensionFunsKt.hasBackground(messageWithPartnerWithReactions) && !kotlin.jvm.internal.y.d(str, messageWithPartnerWithReactions.getMessage().getUserSender())) {
                composer.startReplaceGroup(106073200);
                jM5901getTransparent0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOnTertiary();
                composer.endReplaceGroup();
            } else if (ExtensionFunsKt.hasBackground(messageWithPartnerWithReactions) && kotlin.jvm.internal.y.d(str, messageWithPartnerWithReactions.getMessage().getUserSender())) {
                composer.startReplaceGroup(106077300);
                jM5901getTransparent0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getInversePrimary();
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(106078897);
                composer.endReplaceGroup();
                jM5901getTransparent0d7_KjU = Color.INSTANCE.m5901getTransparent0d7_KjU();
            }
            float f10 = 15;
            Modifier modifierM1204backgroundbw27NRU = BackgroundKt.m1204backgroundbw27NRU(modifierM1728paddingqDBjuR0, jM5901getTransparent0d7_KjU, RoundedCornerShapeKt.m2016RoundedCornerShapea9UjIt4(Dp.m8823constructorimpl((!z11 || kotlin.jvm.internal.y.d(str, messageWithPartnerWithReactions.getMessage().getUserSender())) ? 15 : 0), Dp.m8823constructorimpl((z11 && kotlin.jvm.internal.y.d(str, messageWithPartnerWithReactions.getMessage().getUserSender())) ? 0 : 15), Dp.m8823constructorimpl(f10), Dp.m8823constructorimpl(f10)));
            float fM8823constructorimpl = Dp.m8823constructorimpl(1);
            if (z12) {
                composer.startReplaceGroup(106098310);
                jM5865copywmQWz5c$default = Color.m5865copywmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOnBackground(), 0.8f, 0.0f, 0.0f, 0.0f, 14, null);
                composer.endReplaceGroup();
            } else {
                AppVolatileState instanceOrNull = AppVolatileState.INSTANCE.getInstanceOrNull();
                if (kotlin.jvm.internal.y.d((instanceOrNull == null || (showingReplyTo2 = instanceOrNull.getShowingReplyTo()) == null) ? null : showingReplyTo2.getValue(), messageWithPartnerWithReactions.getMessage().getId())) {
                    composer.startReplaceGroup(106098310);
                    jM5865copywmQWz5c$default = Color.m5865copywmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOnBackground(), 0.8f, 0.0f, 0.0f, 0.0f, 14, null);
                    composer.endReplaceGroup();
                } else {
                    composer.startReplaceGroup(106101686);
                    jM5865copywmQWz5c$default = Color.m5865copywmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getBackground(), 0.0f, 0.0f, 0.0f, 0.0f, 14, null);
                    composer.endReplaceGroup();
                }
            }
            Modifier modifierM1216borderxT4_qwU = BorderKt.m1216borderxT4_qwU(modifierM1204backgroundbw27NRU, fM8823constructorimpl, jM5865copywmQWz5c$default, RoundedCornerShapeKt.m2016RoundedCornerShapea9UjIt4((!z11 || kotlin.jvm.internal.y.d(str, messageWithPartnerWithReactions.getMessage().getUserSender())) ? Dp.m8823constructorimpl(f10) : Dp.m8823constructorimpl(0), (z11 && kotlin.jvm.internal.y.d(str, messageWithPartnerWithReactions.getMessage().getUserSender())) ? Dp.m8823constructorimpl(0) : Dp.m8823constructorimpl(f10), Dp.m8823constructorimpl(f10), Dp.m8823constructorimpl(f10)));
            float f11 = 8;
            Modifier modifierM1728paddingqDBjuR1 = PaddingKt.m1728paddingqDBjuR0(modifierM1216borderxT4_qwU, Dp.m8823constructorimpl(f10), Dp.m8823constructorimpl(f11), Dp.m8823constructorimpl(f10), Dp.m8823constructorimpl(f11));
            Arrangement.Vertical top = Arrangement.INSTANCE.getTop();
            Alignment.Companion companion2 = Alignment.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(top, companion2.getStart(), composer, 0);
            int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierM1728paddingqDBjuR1);
            ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
            lb.a constructor = companion3.getConstructor();
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
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyColumnMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion3.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl, companion3.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion3.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            if (XMPPUtils.INSTANCE.isMUC(messageWithPartnerWithReactions.getMessage().getRoomId()) && z11 && !kotlin.jvm.internal.y.d(str, messageWithPartnerWithReactions.getMessage().getUserSender())) {
                composer.startReplaceGroup(679783707);
                Modifier.Companion companion4 = Modifier.INSTANCE;
                boolean zChanged2 = composer.changed(z10) | composer.changed(function9) | composer.changed(messageWithPartnerWithReactions) | composer.changed(function4);
                Object objRememberedValue3 = composer.rememberedValue();
                if (zChanged2 || objRememberedValue3 == companion.getEmpty()) {
                    MessageItemKt$MessageItem$5$2$1$1 messageItemKt$MessageItem$5$2$1$1 = new MessageItemKt$MessageItem$5$2$1$1(z10, function9, messageWithPartnerWithReactions, mutableState, function4);
                    composer.updateRememberedValue(messageItemKt$MessageItem$5$2$1$1);
                    objRememberedValue3 = messageItemKt$MessageItem$5$2$1$1;
                }
                z14 = true;
                i12 = 6;
                obj = null;
                Z17LabelKt.m10262Z17LabelfWhpE4E(SuspendingPointerInputFilterKt.pointerInput(companion4, function9, (PointerInputEventHandler) objRememberedValue3), messageWithPartnerWithReactions.getSenderAlias(), TextStyle.m8271copyp1EtxEg$default(MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getBodyMedium(), 0L, 0L, FontWeight.INSTANCE.getSemiBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777211, null), ColorKt.Color(ColorGenerator.INSTANCE.getMATERIAL().getColor(messageWithPartnerWithReactions.getSenderAlias())), 1, 25, composer, 221184, 0);
                composer2 = composer;
                composer2.endReplaceGroup();
            } else {
                function9 = function9;
                composer2 = composer;
                z14 = true;
                i12 = 6;
                obj = null;
                composer2.startReplaceGroup(680686086);
                composer2.endReplaceGroup();
            }
            int i13 = i12;
            boolean z15 = z14;
            final Function2 function10 = function9;
            Composer composer3 = composer2;
            ReplyQuote(str, messageWithPartnerWithReactions, function5, function6, composer3, 0);
            boolean zChanged3 = composer3.changed(z10) | composer3.changed(function10) | composer3.changed(messageWithPartnerWithReactions);
            Object objRememberedValue4 = composer3.rememberedValue();
            if (zChanged3 || objRememberedValue4 == companion.getEmpty()) {
                objRememberedValue4 = new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.item.s
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj2, Object obj3) {
                        return MessageItemKt.MessageItem$lambda$4$4$1$0(z10, function10, messageWithPartnerWithReactions, mutableState, (MessageAction) obj2, ((Integer) obj3).intValue());
                    }
                };
                composer3.updateRememberedValue(objRememberedValue4);
            }
            MessageContent(messageWithPartnerWithReactions, str, str2, z13, function3, (Function2) objRememberedValue4, function7, composer3, 0);
            if (kotlin.jvm.internal.y.d(str, messageWithPartnerWithReactions.getMessage().getUserSender())) {
                composer3.startReplaceGroup(437622472);
                MsgStatusKt.OutgoingMsgStatus(columnScopeInstance.align(Modifier.INSTANCE, companion2.getEnd()), messageWithPartnerWithReactions, composer3, 0);
                composer3.endReplaceGroup();
            } else {
                composer3.startReplaceGroup(437625959);
                MsgStatusKt.IncomingMsgStatus(Modifier.INSTANCE, messageWithPartnerWithReactions, composer3, i13);
                composer3.endReplaceGroup();
            }
            composer3.endNode();
            if (MessageItem$lambda$4$1(mutableState) && z10) {
                composer3.startReplaceGroup(106180825);
                Alignment centerEnd = !kotlin.jvm.internal.y.d(str, messageWithPartnerWithReactions.getMessage().getUserSender()) ? companion2.getCenterEnd() : companion2.getCenterStart();
                Object objRememberedValue5 = composer3.rememberedValue();
                if (objRememberedValue5 == companion.getEmpty()) {
                    objRememberedValue5 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.item.t
                        @Override // lb.a
                        public final Object invoke() {
                            return MessageItemKt.MessageItem$lambda$4$5$0(mutableState);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue5);
                }
                AndroidPopup_androidKt.m9081PopupK5zGePQ(centerEnd, 0L, (lb.a) objRememberedValue5, null, ComposableLambdaKt.rememberComposableLambda(1447649822, z15, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.item.u
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj2, Object obj3) {
                        return MessageItemKt.MessageItem$lambda$4$6(messageWithPartnerWithReactions, function8, aVar, str, mutableState, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composer3, 54), composer3, 24960, 10);
                composer3.endReplaceGroup();
            } else {
                composer3.startReplaceGroup(-1002759172);
                composer3.endReplaceGroup();
            }
            ua.k0 k0Var = ua.k0.f43947a;
            boolean zChanged4 = composer3.changed(function1) | composer3.changed(messageWithPartnerWithReactions);
            Object objRememberedValue6 = composer3.rememberedValue();
            if (zChanged4 || objRememberedValue6 == companion.getEmpty()) {
                eVar = null;
                objRememberedValue6 = new MessageItemKt$MessageItem$5$5$1(function1, messageWithPartnerWithReactions, null);
                composer3.updateRememberedValue(objRememberedValue6);
            } else {
                eVar = null;
            }
            EffectsKt.LaunchedEffect(k0Var, (Function2) objRememberedValue6, composer3, i13);
            AppVolatileState instanceOrNull2 = AppVolatileState.INSTANCE.getInstanceOrNull();
            String value = (instanceOrNull2 == null || (showingReplyTo = instanceOrNull2.getShowingReplyTo()) == null) ? eVar : showingReplyTo.getValue();
            boolean zChanged5 = composer3.changed(messageWithPartnerWithReactions);
            Object objRememberedValue7 = composer3.rememberedValue();
            if (zChanged5 || objRememberedValue7 == companion.getEmpty()) {
                objRememberedValue7 = new MessageItemKt$MessageItem$5$6$1(messageWithPartnerWithReactions, eVar);
                composer3.updateRememberedValue(objRememberedValue7);
            }
            EffectsKt.LaunchedEffect(value, (Function2) objRememberedValue7, composer3, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return ua.k0.f43947a;
    }

    private static final boolean MessageItem$lambda$4$1(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void MessageItem$lambda$4$2(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 MessageItem$lambda$4$4$1$0(boolean z10, Function2 function2, MessageWithPartnerWithReactions messageWithPartnerWithReactions, MutableState mutableState, MessageAction messageAction, int i10) {
        kotlin.jvm.internal.y.i(messageAction, "<unused var>");
        if (z10) {
            MessageItem$lambda$4$2(mutableState, true);
        }
        function2.invoke(messageWithPartnerWithReactions, Integer.valueOf(i10));
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 MessageItem$lambda$4$5$0(MutableState mutableState) {
        MessageItem$lambda$4$2(mutableState, false);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 MessageItem$lambda$4$6(MessageWithPartnerWithReactions messageWithPartnerWithReactions, final Function1 function1, lb.a aVar, String str, final MutableState mutableState, Composer composer, int i10) {
        Object next;
        String reactionContent;
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1447649822, i10, -1, "cu.todus.android.uiCompose.main.screen.chat.item.MessageItem.<anonymous>.<anonymous> (MessageItem.kt:216)");
            }
            Iterator<T> it = messageWithPartnerWithReactions.getReactions().iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!kotlin.jvm.internal.y.d(((Reaction) next).getUserId(), str));
            Reaction reaction = (Reaction) next;
            if (reaction == null || (reactionContent = reaction.getReactionContent()) == null) {
                reactionContent = "";
            }
            boolean zChanged = composer.changed(function1);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.item.r
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return MessageItemKt.MessageItem$lambda$4$6$1$0(function1, mutableState, (String) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ReactionsKt.ReactionsRow((Function1) objRememberedValue, aVar, reactionContent, composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 MessageItem$lambda$4$6$1$0(Function1 function1, MutableState mutableState, String it) {
        kotlin.jvm.internal.y.i(it, "it");
        MessageItem$lambda$4$2(mutableState, false);
        function1.invoke(it);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 MessageItem$lambda$5(Modifier modifier, MessageWithPartnerWithReactions messageWithPartnerWithReactions, String str, String str2, boolean z10, boolean z11, boolean z12, Function2 function2, Function2 function3, Function1 function1, Function1 function4, Function1 function5, Function1 function6, boolean z13, Function1 function7, lb.a aVar, boolean z14, Function1 function8, Function2 function9, int i10, int i11, int i12, Composer composer, int i13) {
        MessageItem(modifier, messageWithPartnerWithReactions, str, str2, z10, z11, z12, function2, function3, function1, function4, function5, function6, z13, function7, aVar, z14, function8, function9, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), RecomposeScopeImplKt.updateChangedFlags(i11), i12);
        return ua.k0.f43947a;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void ReplyQuote(final String ownerId, final MessageWithPartnerWithReactions msg, final Function1 onClickOnReply, Function1 function1, Composer composer, final int i10) {
        int i11;
        Object next;
        Modifier modifierM1240clickableoSLSa3U$default;
        Modifier.Companion companion;
        float f10;
        long jColor;
        final Function1 onClickOnStatus = function1;
        kotlin.jvm.internal.y.i(ownerId, "ownerId");
        kotlin.jvm.internal.y.i(msg, "msg");
        kotlin.jvm.internal.y.i(onClickOnReply, "onClickOnReply");
        kotlin.jvm.internal.y.i(onClickOnStatus, "onClickOnStatus");
        Composer composerStartRestartGroup = composer.startRestartGroup(-620676964);
        if ((i10 & 6) == 0) {
            i11 = (composerStartRestartGroup.changed(ownerId) ? 4 : 2) | i10;
        } else {
            i11 = i10;
        }
        if ((i10 & 48) == 0) {
            i11 |= composerStartRestartGroup.changed(msg) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(onClickOnReply) ? 256 : 128;
        }
        if ((i10 & 3072) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(onClickOnStatus) ? 2048 : 1024;
        }
        if (composerStartRestartGroup.shouldExecute((i11 & 1171) != 1170, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-620676964, i11, -1, "cu.todus.android.uiCompose.main.screen.chat.item.ReplyQuote (MessageItem.kt:420)");
            }
            Iterator<T> it = msg.getAttachments().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                Attachment attachment = (Attachment) next;
                if (attachment.getContent().getType() == 9 && (attachment.getContent() instanceof ReplyMsgContent)) {
                    break;
                }
            }
            Attachment attachment2 = (Attachment) next;
            final Content content = attachment2 != null ? attachment2.getContent() : null;
            if (content == null) {
                composerStartRestartGroup.startReplaceGroup(-752870169);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-752870168);
                ReplyMsgContent replyMsgContent = (ReplyMsgContent) content;
                if (replyMsgContent.getPosition() > -1) {
                    composerStartRestartGroup.startReplaceGroup(1692667317);
                    Modifier.Companion companion2 = Modifier.INSTANCE;
                    boolean zChanged = composerStartRestartGroup.changed(content) | ((i11 & 896) == 256);
                    Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.item.k
                            @Override // lb.a
                            public final Object invoke() {
                                return MessageItemKt.ReplyQuote$lambda$1$0$0(content, onClickOnReply);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    modifierM1240clickableoSLSa3U$default = ClickableKt.m1240clickableoSLSa3U$default(companion2, false, null, null, null, (lb.a) objRememberedValue, 15, null);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(1692672632);
                    composerStartRestartGroup.endReplaceGroup();
                    modifierM1240clickableoSLSa3U$default = Modifier.INSTANCE;
                }
                Arrangement arrangement = Arrangement.INSTANCE;
                Arrangement.Vertical top = arrangement.getTop();
                Alignment.Companion companion3 = Alignment.INSTANCE;
                MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(top, companion3.getStart(), composerStartRestartGroup, 0);
                int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1240clickableoSLSa3U$default);
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
                Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyColumnMeasurePolicy, companion4.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion4.getSetResolvedCompositionLocals());
                Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion4.getSetCompositeKeyHash());
                Updater.m5182reconcileimpl(composerM5176constructorimpl, companion4.getApplyOnDeactivatedNodeAssertion());
                Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion4.getSetModifier());
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                Modifier.Companion companion5 = Modifier.INSTANCE;
                float f11 = 5;
                SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion5, Dp.m8823constructorimpl(f11)), composerStartRestartGroup, 6);
                if (replyMsgContent.getFound()) {
                    composerStartRestartGroup.startReplaceGroup(-1413403468);
                    MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getStart(), companion3.getTop(), composerStartRestartGroup, 0);
                    int iA2 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion5);
                    lb.a constructor2 = companion4.getConstructor();
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
                    Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyRowMeasurePolicy, companion4.getSetMeasurePolicy());
                    Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap2, companion4.getSetResolvedCompositionLocals());
                    Updater.m5180initimpl(composerM5176constructorimpl2, Integer.valueOf(iA2), companion4.getSetCompositeKeyHash());
                    Updater.m5182reconcileimpl(composerM5176constructorimpl2, companion4.getApplyOnDeactivatedNodeAssertion());
                    Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier2, companion4.getSetModifier());
                    RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                    Modifier modifierM1774width3ABfNKs = SizeKt.m1774width3ABfNKs(SizeKt.m1755height3ABfNKs(PaddingKt.m1729paddingqDBjuR0$default(companion5, 0.0f, 0.0f, Dp.m8823constructorimpl(f11), 0.0f, 11, null), Dp.m8823constructorimpl(50)), Dp.m8823constructorimpl(4));
                    if (kotlin.jvm.internal.y.d(replyMsgContent.getSenderId(), ownerId)) {
                        composerStartRestartGroup.startReplaceGroup(-894607124);
                        jColor = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimary();
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-894606588);
                        composerStartRestartGroup.endReplaceGroup();
                        jColor = ColorKt.Color(ColorGenerator.INSTANCE.getMATERIAL().getColor(replyMsgContent.getSenderId()));
                    }
                    Modifier modifierM1204backgroundbw27NRU = BackgroundKt.m1204backgroundbw27NRU(modifierM1774width3ABfNKs, jColor, RoundedCornerShapeKt.m2017RoundedCornerShapea9UjIt4$default(Dp.m8823constructorimpl(f11), 0.0f, 0.0f, Dp.m8823constructorimpl(f11), 6, null));
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion3.getTopStart(), false);
                    int iA3 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1204backgroundbw27NRU);
                    lb.a constructor3 = companion4.getConstructor();
                    if (!defpackage.r.a(composerStartRestartGroup.getApplier())) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor3);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM5176constructorimpl3 = Updater.m5176constructorimpl(composerStartRestartGroup);
                    Updater.m5184setimpl(composerM5176constructorimpl3, measurePolicyMaybeCachedBoxMeasurePolicy, companion4.getSetMeasurePolicy());
                    Updater.m5184setimpl(composerM5176constructorimpl3, currentCompositionLocalMap3, companion4.getSetResolvedCompositionLocals());
                    Updater.m5180initimpl(composerM5176constructorimpl3, Integer.valueOf(iA3), companion4.getSetCompositeKeyHash());
                    Updater.m5182reconcileimpl(composerM5176constructorimpl3, companion4.getApplyOnDeactivatedNodeAssertion());
                    Updater.m5184setimpl(composerM5176constructorimpl3, modifierMaterializeModifier3, companion4.getSetModifier());
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                    composerStartRestartGroup.endNode();
                    MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(arrangement.getTop(), companion3.getStart(), composerStartRestartGroup, 0);
                    int iA4 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion5);
                    lb.a constructor4 = companion4.getConstructor();
                    if (!defpackage.r.a(composerStartRestartGroup.getApplier())) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor4);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM5176constructorimpl4 = Updater.m5176constructorimpl(composerStartRestartGroup);
                    Updater.m5184setimpl(composerM5176constructorimpl4, measurePolicyColumnMeasurePolicy2, companion4.getSetMeasurePolicy());
                    Updater.m5184setimpl(composerM5176constructorimpl4, currentCompositionLocalMap4, companion4.getSetResolvedCompositionLocals());
                    Updater.m5180initimpl(composerM5176constructorimpl4, Integer.valueOf(iA4), companion4.getSetCompositeKeyHash());
                    Updater.m5182reconcileimpl(composerM5176constructorimpl4, companion4.getApplyOnDeactivatedNodeAssertion());
                    Updater.m5184setimpl(composerM5176constructorimpl4, modifierMaterializeModifier4, companion4.getSetModifier());
                    String senderAlias = replyMsgContent.getSenderAlias();
                    MaterialTheme materialTheme = MaterialTheme.INSTANCE;
                    int i12 = MaterialTheme.$stable;
                    int i13 = i11;
                    f10 = f11;
                    Z17LabelKt.m10262Z17LabelfWhpE4E(null, senderAlias, materialTheme.getTypography(composerStartRestartGroup, i12).getBodyMedium(), ColorKt.Color(ColorGenerator.INSTANCE.getMATERIAL().getColor(replyMsgContent.getSenderAlias())), 1, 15, composerStartRestartGroup, 221184, 1);
                    Z17LabelKt.m10262Z17LabelfWhpE4E(PaddingKt.m1729paddingqDBjuR0$default(companion5, 0.0f, 0.0f, Dp.m8823constructorimpl(f10), Dp.m8823constructorimpl(10), 3, null), replyMsgContent.getShortMsg(), materialTheme.getTypography(composerStartRestartGroup, i12).getLabelSmall(), 0L, 1, 0, composerStartRestartGroup, 24576, 40);
                    if (!replyMsgContent.isStatus() || replyMsgContent.getStatusContent() == null) {
                        onClickOnStatus = function1;
                        composerStartRestartGroup.startReplaceGroup(1264375079);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(1263879203);
                        Modifier modifierClip = ClipKt.clip(companion5, RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(15)));
                        boolean zChanged2 = ((i13 & 7168) == 2048) | composerStartRestartGroup.changed(content);
                        Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            onClickOnStatus = function1;
                            objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.item.p
                                @Override // lb.a
                                public final Object invoke() {
                                    return MessageItemKt.ReplyQuote$lambda$1$1$0$1$0$0(onClickOnStatus, content);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        } else {
                            onClickOnStatus = function1;
                        }
                        StatusItemKt.StatusItem(ClickableKt.m1240clickableoSLSa3U$default(modifierClip, false, null, null, null, (lb.a) objRememberedValue2, 15, null), replyMsgContent.getStatusContent(), true, false, false, false, 0, false, null, composerStartRestartGroup, RendererCapabilities.DECODER_SUPPORT_MASK, TypedValues.PositionType.TYPE_PERCENT_HEIGHT);
                        composerStartRestartGroup = composerStartRestartGroup;
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceGroup();
                    companion = companion5;
                } else {
                    companion = companion5;
                    f10 = f11;
                    composerStartRestartGroup.startReplaceGroup(-1411472664);
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(companion3.getTopStart(), false);
                    int iA5 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap5 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier5 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
                    lb.a constructor5 = companion4.getConstructor();
                    if (!defpackage.r.a(composerStartRestartGroup.getApplier())) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor5);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM5176constructorimpl5 = Updater.m5176constructorimpl(composerStartRestartGroup);
                    Updater.m5184setimpl(composerM5176constructorimpl5, measurePolicyMaybeCachedBoxMeasurePolicy2, companion4.getSetMeasurePolicy());
                    Updater.m5184setimpl(composerM5176constructorimpl5, currentCompositionLocalMap5, companion4.getSetResolvedCompositionLocals());
                    Updater.m5180initimpl(composerM5176constructorimpl5, Integer.valueOf(iA5), companion4.getSetCompositeKeyHash());
                    Updater.m5182reconcileimpl(composerM5176constructorimpl5, companion4.getApplyOnDeactivatedNodeAssertion());
                    Updater.m5184setimpl(composerM5176constructorimpl5, modifierMaterializeModifier5, companion4.getSetModifier());
                    BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                    Z17LabelKt.m10262Z17LabelfWhpE4E(PaddingKt.m1729paddingqDBjuR0$default(companion, 0.0f, 0.0f, 0.0f, Dp.m8823constructorimpl(10), 7, null), StringResources_androidKt.stringResource(R.string.message_not_found, composerStartRestartGroup, 0), null, MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getTertiary(), 0, 0, composerStartRestartGroup, 6, 52);
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceGroup();
                }
                SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion, Dp.m8823constructorimpl(f10)), composerStartRestartGroup, 6);
                composerStartRestartGroup.endNode();
                ua.k0 k0Var = ua.k0.f43947a;
                composerStartRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.item.q
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return MessageItemKt.ReplyQuote$lambda$2(ownerId, msg, onClickOnReply, onClickOnStatus, i10, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ReplyQuote$lambda$1$0$0(Content content, Function1 function1) {
        AppVolatileState instanceOrNull = AppVolatileState.INSTANCE.getInstanceOrNull();
        if (instanceOrNull != null) {
            instanceOrNull.showReply(((ReplyMsgContent) content).getMsgId());
        }
        function1.invoke(Integer.valueOf(((ReplyMsgContent) content).getPosition()));
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ReplyQuote$lambda$1$1$0$1$0$0(Function1 function1, Content content) {
        String statusId = ((ReplyMsgContent) content).getStatusId();
        if (statusId == null) {
            statusId = "";
        }
        function1.invoke(statusId);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ReplyQuote$lambda$2(String str, MessageWithPartnerWithReactions messageWithPartnerWithReactions, Function1 function1, Function1 function2, int i10, Composer composer, int i11) {
        ReplyQuote(str, messageWithPartnerWithReactions, function1, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1));
        return ua.k0.f43947a;
    }
}
