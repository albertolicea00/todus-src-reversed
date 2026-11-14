package cu.todus.android.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.webkit.MimeTypeMap;
import androidx.compose.foundation.pager.PagerState;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.core.app.NotificationManagerCompat;
import androidx.p001lifecycle.Lifecycle;
import androidx.p001lifecycle.LifecycleEventObserver;
import androidx.p001lifecycle.LifecycleOwner;
import cu.todus.android.R;
import cu.todus.android.data.db.entity.configs.Heritage;
import cu.todus.android.data.db.entity.toDus.Attachment;
import cu.todus.android.data.db.entity.toDus.Message;
import cu.todus.android.data.db.entity.toDus.Room;
import cu.todus.android.data.db.entity.toDus.User;
import cu.todus.android.data.db.pojo.MessageWithPartnerWithReactions;
import cu.todus.android.data.db.pojo.MessageWithPartnerWithRoomWithReactions;
import cu.todus.android.data.db.pojo.RoomItemView;
import cu.todus.android.data.db.pojo.content.AudioContent;
import cu.todus.android.data.db.pojo.content.ButtonContent;
import cu.todus.android.data.db.pojo.content.CallContent;
import cu.todus.android.data.db.pojo.content.ContactContent;
import cu.todus.android.data.db.pojo.content.Content;
import cu.todus.android.data.db.pojo.content.DeletedContent;
import cu.todus.android.data.db.pojo.content.EventContent;
import cu.todus.android.data.db.pojo.content.FileContent;
import cu.todus.android.data.db.pojo.content.GifContent;
import cu.todus.android.data.db.pojo.content.ImageContent;
import cu.todus.android.data.db.pojo.content.LinkEntity;
import cu.todus.android.data.db.pojo.content.LinkInfoContent;
import cu.todus.android.data.db.pojo.content.LocationContent;
import cu.todus.android.data.db.pojo.content.StickerContent;
import cu.todus.android.data.db.pojo.content.VideoContent;
import cu.todus.android.data.db.pojo.content.VoiceContent;
import cu.todus.android.data.db.pojo.info.MessagePayload;
import cu.todus.android.domain.Domain;
import cu.todus.android.image.ImageLoader;
import cu.todus.android.notification.ConfigProcessor;
import cu.todus.android.notification.notifications.MessageNotification;
import cu.todus.android.uiCompose.main.screen.chat.item.MessageItemType;
import cu.todus.android.uiCompose.theme.Other;
import cu.todus.android.xmpp.XMPPUtils;
import defpackage.r;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.y;
import le.d0;
import ua.v;
import va.w;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0004\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0004\u0010\u0003\u001a\u0011\u0010\u0005\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0005\u0010\u0003\u001a\u0013\u0010\b\u001a\u00020\u0007*\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\t\u001a\u0019\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b*\u00020\nH\u0007¢\u0006\u0004\b\r\u0010\u000e\u001a\u0011\u0010\u0011\u001a\u00020\u0010*\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u0011\u0010\u0011\u001a\u00020\u0010*\u00020\u0013¢\u0006\u0004\b\u0011\u0010\u0014\u001a\u0011\u0010\u0015\u001a\u00020\u000f*\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u0011\u0010\u0017\u001a\u00020\u0001*\u00020\u000f¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u0011\u0010\u0019\u001a\u00020\u0001*\u00020\u000f¢\u0006\u0004\b\u0019\u0010\u0018\u001a)\u0010\u001f\u001a\u00020\u0007*\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u0007¢\u0006\u0004\b\u001f\u0010 \u001a)\u0010\u001f\u001a\u00020\u0007*\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u0007¢\u0006\u0004\b\u001f\u0010!\u001a-\u0010#\u001a\u00020\"*\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u001b2\b\b\u0002\u0010\u001d\u001a\u00020\u00072\b\b\u0002\u0010\u001e\u001a\u00020\u0007¢\u0006\u0004\b#\u0010$\u001a7\u0010)\u001a\u00020\"*\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u001b2\b\b\u0002\u0010&\u001a\u00020%2\b\b\u0002\u0010'\u001a\u00020\u00072\b\b\u0002\u0010(\u001a\u00020\u0007¢\u0006\u0004\b)\u0010*\u001a\u0013\u0010+\u001a\u00020%*\u0004\u0018\u00010\u0007¢\u0006\u0004\b+\u0010,\u001a\u0013\u0010-\u001a\u00020%*\u0004\u0018\u00010\u0007¢\u0006\u0004\b-\u0010,\u001a\u0013\u00102\u001a\u00020/*\u00020.H\u0007¢\u0006\u0004\b0\u00101\u001a\u0013\u00104\u001a\u00020.*\u000203H\u0007¢\u0006\u0004\b4\u00105\u001a\u0016\u00107\u001a\u0004\u0018\u00010\u0001*\u000206H\u0086@¢\u0006\u0004\b7\u00108\u001a\u0016\u00109\u001a\u0004\u0018\u00010\u0001*\u000206H\u0086@¢\u0006\u0004\b9\u00108\u001a\u0011\u0010:\u001a\u00020\u0001*\u00020\u001b¢\u0006\u0004\b:\u0010;¨\u0006<"}, d2 = {"Ljava/io/File;", "", "isVideo", "(Ljava/io/File;)Z", "isAudio", "isImage", "", "", "toJson", "(Ljava/lang/Object;)Ljava/lang/String;", "Landroidx/lifecycle/Lifecycle;", "Landroidx/compose/runtime/State;", "Landroidx/lifecycle/Lifecycle$Event;", "observeAsState", "(Landroidx/lifecycle/Lifecycle;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "Lcu/todus/android/data/db/pojo/MessageWithPartnerWithReactions;", "Lcu/todus/android/uiCompose/main/screen/chat/item/MessageItemType;", "getItemMsgType", "(Lcu/todus/android/data/db/pojo/MessageWithPartnerWithReactions;)Lcu/todus/android/uiCompose/main/screen/chat/item/MessageItemType;", "Lcu/todus/android/data/db/pojo/MessageWithPartnerWithRoomWithReactions;", "(Lcu/todus/android/data/db/pojo/MessageWithPartnerWithRoomWithReactions;)Lcu/todus/android/uiCompose/main/screen/chat/item/MessageItemType;", "toMessageWithPartner", "(Lcu/todus/android/data/db/pojo/MessageWithPartnerWithRoomWithReactions;)Lcu/todus/android/data/db/pojo/MessageWithPartnerWithReactions;", "hasBackground", "(Lcu/todus/android/data/db/pojo/MessageWithPartnerWithReactions;)Z", "hasReactions", "Lcu/todus/android/data/db/pojo/RoomItemView;", "Landroid/content/Context;", "context", "ownerId", "ownerAlias", "toShortMsg", "(Lcu/todus/android/data/db/pojo/RoomItemView;Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "(Lcu/todus/android/data/db/pojo/MessageWithPartnerWithReactions;Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "Lcu/todus/android/notification/notifications/MessageNotification;", "toNotification", "(Lcu/todus/android/data/db/pojo/MessageWithPartnerWithRoomWithReactions;Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Lcu/todus/android/notification/notifications/MessageNotification;", "", "createAt", "senderAlias", "senderImage", "toReactedNotification", "(Lcu/todus/android/data/db/pojo/MessageWithPartnerWithRoomWithReactions;Landroid/content/Context;JLjava/lang/String;Ljava/lang/String;)Lcu/todus/android/notification/notifications/MessageNotification;", "toLong0OnError", "(Ljava/lang/String;)J", "toLongMaxOnError", "Landroidx/compose/ui/unit/Dp;", "", "dpToPx-8Feqmps", "(FLandroidx/compose/runtime/Composer;I)F", "dpToPx", "", "pxToDp", "(ILandroidx/compose/runtime/Composer;I)F", "Landroidx/compose/foundation/pager/PagerState;", "goBack", "(Landroidx/compose/foundation/pager/PagerState;Lab/e;)Ljava/lang/Object;", "goNext", "areNotificationsEnabled", "(Landroid/content/Context;)Z", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class ExtensionFunsKt {

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

    /* JADX INFO: renamed from: cu.todus.android.utils.ExtensionFunsKt$goBack$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.utils.ExtensionFunsKt", f = "ExtensionFuns.kt", l = {586}, m = "goBack", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class AnonymousClass1 extends cb.d {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(ab.e<? super AnonymousClass1> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ExtensionFunsKt.goBack(null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.utils.ExtensionFunsKt$goNext$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.utils.ExtensionFunsKt", f = "ExtensionFuns.kt", l = {594, 598}, m = "goNext", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C13411 extends cb.d {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C13411(ab.e<? super C13411> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ExtensionFunsKt.goNext(null, this);
        }
    }

    public static final boolean areNotificationsEnabled(Context context) {
        y.i(context, "<this>");
        return NotificationManagerCompat.from(context).areNotificationsEnabled();
    }

    @Composable
    /* JADX INFO: renamed from: dpToPx-8Feqmps, reason: not valid java name */
    public static final float m10123dpToPx8Feqmps(float f10, Composer composer, int i10) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-215426803, i10, -1, "cu.todus.android.utils.dpToPx (ExtensionFuns.kt:574)");
        }
        float fMo1345toPx0680j_4 = ((Density) composer.consume(CompositionLocalsKt.getLocalDensity())).mo1345toPx0680j_4(f10);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return fMo1345toPx0680j_4;
    }

    /* JADX WARN: Code duplicated, block: B:86:0x015a  */
    /* JADX WARN: Code duplicated, block: B:88:0x0168  */
    public static final MessageItemType getItemMsgType(MessageWithPartnerWithReactions messageWithPartnerWithReactions) {
        y.i(messageWithPartnerWithReactions, "<this>");
        List<Attachment> attachments = messageWithPartnerWithReactions.getAttachments();
        if (!r.a(attachments) || !attachments.isEmpty()) {
            for (Attachment attachment : attachments) {
                if (attachment.getType() == 16 && (attachment.getContent() instanceof DeletedContent)) {
                    return MessageItemType.DELETE;
                }
            }
        }
        List<Attachment> attachments2 = messageWithPartnerWithReactions.getAttachments();
        if (!r.a(attachments2) || !attachments2.isEmpty()) {
            for (Attachment attachment2 : attachments2) {
                if (attachment2.getContent().getType() == 21 && (attachment2.getContent() instanceof ButtonContent)) {
                    return MessageItemType.BUTTON;
                }
            }
        }
        List<Attachment> attachments3 = messageWithPartnerWithReactions.getAttachments();
        if (!r.a(attachments3) || !attachments3.isEmpty()) {
            for (Attachment attachment3 : attachments3) {
                if (attachment3.getContent().getType() == 32 && (attachment3.getContent() instanceof CallContent)) {
                    return MessageItemType.CALL;
                }
            }
        }
        List<Attachment> attachments4 = messageWithPartnerWithReactions.getAttachments();
        if (!r.a(attachments4) || !attachments4.isEmpty()) {
            for (Attachment attachment4 : attachments4) {
                if (attachment4.getContent().getType() == 20) {
                    Content content = attachment4.getContent();
                    y.g(content, "null cannot be cast to non-null type cu.todus.android.data.db.pojo.content.LinkInfoContent");
                    if (((LinkInfoContent) content).getDownloadedInfo()) {
                        LinkEntity linkEntity = ((LinkInfoContent) attachment4.getContent()).getLinkEntity();
                        if ((linkEntity != null ? linkEntity.getDescription() : null) != null) {
                            return MessageItemType.LINKS;
                        }
                    } else {
                        continue;
                    }
                }
            }
        }
        if (messageWithPartnerWithReactions.getMessage().getPayload() == null) {
            if (!messageWithPartnerWithReactions.getAttachments().isEmpty()) {
                List<Attachment> attachments5 = messageWithPartnerWithReactions.getAttachments();
                if (!r.a(attachments5) || !attachments5.isEmpty()) {
                    Iterator<T> it = attachments5.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            Attachment attachment5 = (Attachment) it.next();
                            if (attachment5.getType() == 11 || attachment5.getType() == 14 || attachment5.getType() == 15 || attachment5.getType() == 9 || attachment5.getType() == 20) {
                            }
                        } else if (!d0.q0(messageWithPartnerWithReactions.getMessage().getContent())) {
                            return MessageItemType.MESSAGE;
                        }
                    }
                } else if (!d0.q0(messageWithPartnerWithReactions.getMessage().getContent())) {
                    return MessageItemType.MESSAGE;
                }
            } else if (!d0.q0(messageWithPartnerWithReactions.getMessage().getContent())) {
                return MessageItemType.MESSAGE;
            }
        }
        List<Attachment> attachments6 = messageWithPartnerWithReactions.getAttachments();
        if (!r.a(attachments6) || !attachments6.isEmpty()) {
            for (Attachment attachment6 : attachments6) {
                if (attachment6.getType() == 13 && (attachment6.getContent() instanceof StickerContent)) {
                    return MessageItemType.STICKER;
                }
            }
        }
        List<Attachment> attachments7 = messageWithPartnerWithReactions.getAttachments();
        if (!r.a(attachments7) || !attachments7.isEmpty()) {
            for (Attachment attachment7 : attachments7) {
                if (attachment7.getContent().getType() == 1 && (attachment7.getContent() instanceof ImageContent)) {
                    return MessageItemType.IMAGE;
                }
            }
        }
        List<Attachment> attachments8 = messageWithPartnerWithReactions.getAttachments();
        if (!r.a(attachments8) || !attachments8.isEmpty()) {
            for (Attachment attachment8 : attachments8) {
                if (attachment8.getType() == 7 && (attachment8.getContent() instanceof GifContent)) {
                    return MessageItemType.GIF;
                }
            }
        }
        List<Attachment> attachments9 = messageWithPartnerWithReactions.getAttachments();
        if (!r.a(attachments9) || !attachments9.isEmpty()) {
            for (Attachment attachment9 : attachments9) {
                if (attachment9.getType() == 4 && (attachment9.getContent() instanceof VoiceContent)) {
                    return MessageItemType.VOICE;
                }
            }
        }
        List<Attachment> attachments10 = messageWithPartnerWithReactions.getAttachments();
        if (!r.a(attachments10) || !attachments10.isEmpty()) {
            for (Attachment attachment10 : attachments10) {
                if (attachment10.getContent().getType() == 3 && (attachment10.getContent() instanceof AudioContent)) {
                    return MessageItemType.AUDIO;
                }
            }
        }
        List<Attachment> attachments11 = messageWithPartnerWithReactions.getAttachments();
        if (!r.a(attachments11) || !attachments11.isEmpty()) {
            for (Attachment attachment11 : attachments11) {
                if (attachment11.getType() == 2 && (attachment11.getContent() instanceof VideoContent)) {
                    return MessageItemType.VIDEO;
                }
            }
        }
        List<Attachment> attachments12 = messageWithPartnerWithReactions.getAttachments();
        if (!r.a(attachments12) || !attachments12.isEmpty()) {
            for (Attachment attachment12 : attachments12) {
                if (attachment12.getType() == 6 && (attachment12.getContent() instanceof ContactContent)) {
                    return MessageItemType.CONTACT;
                }
            }
        }
        List<Attachment> attachments13 = messageWithPartnerWithReactions.getAttachments();
        if (!r.a(attachments13) || !attachments13.isEmpty()) {
            for (Attachment attachment13 : attachments13) {
                if (attachment13.getType() == 5 && (attachment13.getContent() instanceof FileContent)) {
                    return MessageItemType.FILE;
                }
            }
        }
        List<Attachment> attachments14 = messageWithPartnerWithReactions.getAttachments();
        if (!r.a(attachments14) || !attachments14.isEmpty()) {
            for (Attachment attachment14 : attachments14) {
                if (attachment14.getType() == 8 && (attachment14.getContent() instanceof EventContent)) {
                    return MessageItemType.EVENT;
                }
            }
        }
        List<Attachment> attachments15 = messageWithPartnerWithReactions.getAttachments();
        if (!r.a(attachments15) || !attachments15.isEmpty()) {
            for (Attachment attachment15 : attachments15) {
                if (attachment15.getType() == 10 && (attachment15.getContent() instanceof LocationContent)) {
                    return MessageItemType.LOCATION;
                }
            }
        }
        return (messageWithPartnerWithReactions.getAttachments().isEmpty() && messageWithPartnerWithReactions.getMessage().getContent().length() == 0) ? MessageItemType.DELAYED_MESSAGE : MessageItemType.EMPTY_MESSAGE;
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0014  */
    public static final Object goBack(PagerState pagerState, ab.e<? super Boolean> eVar) {
        AnonymousClass1 anonymousClass1;
        if (eVar instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) eVar;
            int i10 = anonymousClass1.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i10 - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(eVar);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(eVar);
        }
        AnonymousClass1 anonymousClass2 = anonymousClass1;
        Object obj = anonymousClass2.result;
        Object objG = bb.b.g();
        int i11 = anonymousClass2.label;
        if (i11 == 0) {
            v.b(obj);
            if (pagerState.getCurrentPage() == 0) {
                return null;
            }
            int currentPage = pagerState.getCurrentPage() - 1;
            anonymousClass2.L$0 = cb.l.a(pagerState);
            anonymousClass2.label = 1;
            if (PagerState.animateScrollToPage$default(pagerState, currentPage, 0.0f, null, anonymousClass2, 6, null) == objG) {
                return objG;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v.b(obj);
        }
        return cb.b.a(true);
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x005c, code lost:
    
        if (r10 == r0) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0079, code lost:
    
        if (androidx.compose.foundation.pager.PagerState.animateScrollToPage$default(r9, r10, 0.0f, null, r5, 6, null) == r0) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object goNext(androidx.compose.foundation.pager.PagerState r9, ab.e<? super java.lang.Boolean> r10) {
        /*
            boolean r0 = r10 instanceof cu.todus.android.utils.ExtensionFunsKt.C13411
            if (r0 == 0) goto L14
            r0 = r10
            cu.todus.android.utils.ExtensionFunsKt$goNext$1 r0 = (cu.todus.android.utils.ExtensionFunsKt.C13411) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.label = r1
        L12:
            r5 = r0
            goto L1a
        L14:
            cu.todus.android.utils.ExtensionFunsKt$goNext$1 r0 = new cu.todus.android.utils.ExtensionFunsKt$goNext$1
            r0.<init>(r10)
            goto L12
        L1a:
            java.lang.Object r10 = r5.result
            java.lang.Object r0 = bb.b.g()
            int r1 = r5.label
            r2 = 2
            r8 = 1
            if (r1 == 0) goto L42
            if (r1 == r8) goto L3a
            if (r1 != r2) goto L32
            java.lang.Object r9 = r5.L$0
            androidx.compose.foundation.pager.PagerState r9 = (androidx.compose.foundation.pager.PagerState) r9
            ua.v.b(r10)
            goto L7c
        L32:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L3a:
            java.lang.Object r9 = r5.L$0
            androidx.compose.foundation.pager.PagerState r9 = (androidx.compose.foundation.pager.PagerState) r9
            ua.v.b(r10)
            goto L5f
        L42:
            ua.v.b(r10)
            int r10 = r9.getCurrentPage()
            int r1 = r9.getPageCount()
            int r1 = r1 - r8
            if (r10 != r1) goto L62
            java.lang.Object r10 = cb.l.a(r9)
            r5.L$0 = r10
            r5.label = r8
            java.lang.Object r10 = goBack(r9, r5)
            if (r10 != r0) goto L5f
            goto L7b
        L5f:
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            return r10
        L62:
            int r10 = r9.getCurrentPage()
            int r10 = r10 + r8
            java.lang.Object r1 = cb.l.a(r9)
            r5.L$0 = r1
            r5.label = r2
            r3 = 0
            r4 = 0
            r6 = 6
            r7 = 0
            r1 = r9
            r2 = r10
            java.lang.Object r9 = androidx.compose.foundation.pager.PagerState.animateScrollToPage$default(r1, r2, r3, r4, r5, r6, r7)
            if (r9 != r0) goto L7c
        L7b:
            return r0
        L7c:
            java.lang.Boolean r9 = cb.b.a(r8)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.utils.ExtensionFunsKt.goNext(androidx.compose.foundation.pager.PagerState, ab.e):java.lang.Object");
    }

    public static final boolean hasBackground(MessageWithPartnerWithReactions messageWithPartnerWithReactions) {
        y.i(messageWithPartnerWithReactions, "<this>");
        switch (WhenMappings.$EnumSwitchMapping$0[getItemMsgType(messageWithPartnerWithReactions).ordinal()]) {
            case 1:
            case 3:
            case 12:
            case 13:
            case 15:
            case 17:
                return true;
            case 2:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 14:
            case 16:
                return false;
            default:
                throw new ua.r();
        }
    }

    public static final boolean hasReactions(MessageWithPartnerWithReactions messageWithPartnerWithReactions) {
        y.i(messageWithPartnerWithReactions, "<this>");
        switch (WhenMappings.$EnumSwitchMapping$0[getItemMsgType(messageWithPartnerWithReactions).ordinal()]) {
            case 1:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 11:
            case 12:
            case 13:
                return true;
            case 2:
            case 10:
            case 14:
            case 15:
            case 16:
            case 17:
                return false;
            default:
                throw new ua.r();
        }
    }

    public static final boolean isAudio(File file) {
        y.i(file, "<this>");
        String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(hb.l.h(file));
        if (mimeTypeFromExtension != null) {
            return d0.a0(mimeTypeFromExtension, "audio", false, 2, null);
        }
        return false;
    }

    public static final boolean isImage(File file) {
        y.i(file, "<this>");
        String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(hb.l.h(file));
        if (mimeTypeFromExtension != null) {
            return d0.a0(mimeTypeFromExtension, "image", false, 2, null);
        }
        return false;
    }

    public static final boolean isVideo(File file) {
        y.i(file, "<this>");
        String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(hb.l.h(file));
        if (mimeTypeFromExtension != null) {
            return d0.a0(mimeTypeFromExtension, "video", false, 2, null);
        }
        return false;
    }

    @Composable
    public static final State<Lifecycle.Event> observeAsState(final Lifecycle lifecycle, Composer composer, int i10) {
        y.i(lifecycle, "<this>");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(561155754, i10, -1, "cu.todus.android.utils.observeAsState (ExtensionFuns.kt:69)");
        }
        Object objRememberedValue = composer.rememberedValue();
        Composer.Companion companion = Composer.INSTANCE;
        if (objRememberedValue == companion.getEmpty()) {
            objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Lifecycle.Event.ON_ANY, null, 2, null);
            composer.updateRememberedValue(objRememberedValue);
        }
        final MutableState mutableState = (MutableState) objRememberedValue;
        boolean zChangedInstance = composer.changedInstance(lifecycle);
        Object objRememberedValue2 = composer.rememberedValue();
        if (zChangedInstance || objRememberedValue2 == companion.getEmpty()) {
            objRememberedValue2 = new Function1() { // from class: cu.todus.android.utils.f
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return ExtensionFunsKt.observeAsState$lambda$1$0(lifecycle, mutableState, (DisposableEffectScope) obj);
                }
            };
            composer.updateRememberedValue(objRememberedValue2);
        }
        EffectsKt.DisposableEffect(lifecycle, (Function1) objRememberedValue2, composer, i10 & 14);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return mutableState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult observeAsState$lambda$1$0(final Lifecycle lifecycle, final MutableState mutableState, DisposableEffectScope DisposableEffect) {
        y.i(DisposableEffect, "$this$DisposableEffect");
        final LifecycleEventObserver lifecycleEventObserver = new LifecycleEventObserver() { // from class: cu.todus.android.utils.e
            @Override // androidx.p001lifecycle.LifecycleEventObserver
            public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                ExtensionFunsKt.observeAsState$lambda$1$0$0(mutableState, lifecycleOwner, event);
            }
        };
        lifecycle.addObserver(lifecycleEventObserver);
        return new DisposableEffectResult() { // from class: cu.todus.android.utils.ExtensionFunsKt$observeAsState$lambda$1$0$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                lifecycle.removeObserver(lifecycleEventObserver);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void observeAsState$lambda$1$0$0(MutableState mutableState, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        y.i(lifecycleOwner, "<unused var>");
        y.i(event, "event");
        mutableState.setValue(event);
    }

    @Composable
    public static final float pxToDp(int i10, Composer composer, int i11) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-926572964, i11, -1, "cu.todus.android.utils.pxToDp (ExtensionFuns.kt:578)");
        }
        float fMo1342toDpu2uoSUM = ((Density) composer.consume(CompositionLocalsKt.getLocalDensity())).mo1342toDpu2uoSUM(i10);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return fMo1342toDpu2uoSUM;
    }

    public static final String toJson(Object obj) {
        String strT = new v5.f().t(obj);
        y.h(strT, "toJson(...)");
        return strT;
    }

    public static final long toLong0OnError(String str) {
        if (str == null) {
            return 0L;
        }
        try {
            return Long.parseLong(str);
        } catch (Exception unused) {
            return 0L;
        }
    }

    public static final long toLongMaxOnError(String str) {
        if (str == null) {
            return Long.MAX_VALUE;
        }
        try {
            return Long.parseLong(str);
        } catch (Exception unused) {
            return 0L;
        }
    }

    public static final MessageWithPartnerWithReactions toMessageWithPartner(MessageWithPartnerWithRoomWithReactions messageWithPartnerWithRoomWithReactions) {
        y.i(messageWithPartnerWithRoomWithReactions, "<this>");
        return new MessageWithPartnerWithReactions(messageWithPartnerWithRoomWithReactions.getMessage(), messageWithPartnerWithRoomWithReactions.getSenderUser(), messageWithPartnerWithRoomWithReactions.getSenderContact(), messageWithPartnerWithRoomWithReactions.getAttachments(), null, 16, null);
    }

    public static final MessageNotification toNotification(MessageWithPartnerWithRoomWithReactions messageWithPartnerWithRoomWithReactions, Context context, String ownerId, String ownerAlias) {
        String roomName;
        String picture;
        Bitmap circleImage$default;
        String photoUrl;
        String picture2;
        String picture3;
        String photoUrl2;
        String picture4;
        y.i(messageWithPartnerWithRoomWithReactions, "<this>");
        y.i(context, "context");
        y.i(ownerId, "ownerId");
        y.i(ownerAlias, "ownerAlias");
        XMPPUtils xMPPUtils = XMPPUtils.INSTANCE;
        Heritage heritageBuildHeritageGroup = xMPPUtils.isMUC(messageWithPartnerWithRoomWithReactions.getMessage().getRoomId()) ? ConfigProcessor.INSTANCE.buildHeritageGroup(messageWithPartnerWithRoomWithReactions.getMessage().getRoomId()) : ConfigProcessor.INSTANCE.buildHeritagePrivateChat(messageWithPartnerWithRoomWithReactions.getMessage().getRoomId());
        String id2 = messageWithPartnerWithRoomWithReactions.getMessage().getId();
        String roomId = messageWithPartnerWithRoomWithReactions.getMessage().getRoomId();
        String roomName2 = messageWithPartnerWithRoomWithReactions.getRoomName();
        if (y.d(messageWithPartnerWithRoomWithReactions.getMessage().getUserSender(), ownerId)) {
            roomName = context.getResources().getString(R.string.f20195me);
        } else {
            roomName = xMPPUtils.isChannel(messageWithPartnerWithRoomWithReactions.getMessage().getRoomId()) ? messageWithPartnerWithRoomWithReactions.getRoomName() : messageWithPartnerWithRoomWithReactions.getSenderAlias();
        }
        String str = roomName;
        ImageLoader imageLoader = ImageLoader.INSTANCE;
        Room senderRoom = messageWithPartnerWithRoomWithReactions.getSenderRoom();
        String str2 = (senderRoom == null || (picture4 = senderRoom.getPicture()) == null) ? "" : picture4;
        String roomName3 = messageWithPartnerWithRoomWithReactions.getRoomName();
        ColorGenerator.Companion companion = ColorGenerator.INSTANCE;
        Bitmap circleImage$default2 = ImageLoader.getCircleImage$default(imageLoader, context, str2, roomName3, companion.getMATERIAL().getColor(messageWithPartnerWithRoomWithReactions.getRoomName()), false, 16, null);
        if (y.d(messageWithPartnerWithRoomWithReactions.getMessage().getUserSender(), ownerId)) {
            User senderUser = messageWithPartnerWithRoomWithReactions.getSenderUser();
            if (senderUser == null || (photoUrl2 = senderUser.getPhotoUrl()) == null) {
                Room senderRoom2 = messageWithPartnerWithRoomWithReactions.getSenderRoom();
                picture3 = senderRoom2 != null ? senderRoom2.getPicture() : "";
            } else {
                picture3 = photoUrl2;
            }
            String string = context.getResources().getString(R.string.f20195me);
            y.h(string, "getString(...)");
            circleImage$default = ImageLoader.getCircleImage$default(imageLoader, context, picture3, string, ColorKt.m5920toArgb8_81llA(Other.INSTANCE.m10118getRed0d7_KjU()), false, 16, null);
        } else if (xMPPUtils.isChannel(messageWithPartnerWithRoomWithReactions.getMessage().getRoomId())) {
            Room senderRoom3 = messageWithPartnerWithRoomWithReactions.getSenderRoom();
            circleImage$default = ImageLoader.getCircleImage$default(imageLoader, context, (senderRoom3 == null || (picture2 = senderRoom3.getPicture()) == null) ? "" : picture2, messageWithPartnerWithRoomWithReactions.getRoomName(), companion.getMATERIAL().getColor(messageWithPartnerWithRoomWithReactions.getRoomName()), false, 16, null);
        } else {
            User senderUser2 = messageWithPartnerWithRoomWithReactions.getSenderUser();
            if (senderUser2 == null || (photoUrl = senderUser2.getPhotoUrl()) == null) {
                Room senderRoom4 = messageWithPartnerWithRoomWithReactions.getSenderRoom();
                picture = senderRoom4 != null ? senderRoom4.getPicture() : "";
            } else {
                picture = photoUrl;
            }
            circleImage$default = ImageLoader.getCircleImage$default(imageLoader, context, picture, messageWithPartnerWithRoomWithReactions.getSenderAlias(), companion.getMATERIAL().getColor(messageWithPartnerWithRoomWithReactions.getSenderAlias()), false, 16, null);
        }
        return new MessageNotification(heritageBuildHeritageGroup, roomId, roomName2, str, circleImage$default2, circleImage$default, id2, Domain.INSTANCE.createShorMsg(messageWithPartnerWithRoomWithReactions.getMessage(), messageWithPartnerWithRoomWithReactions.getAttachments(), messageWithPartnerWithRoomWithReactions.getMessage().getPayload(), context, ownerId, messageWithPartnerWithRoomWithReactions.getSenderAlias()), messageWithPartnerWithRoomWithReactions.getMessage().getCreateAt(), false, false, !xMPPUtils.isChannel(messageWithPartnerWithRoomWithReactions.getMessage().getRoomId()), 1024, null);
    }

    public static /* synthetic */ MessageNotification toNotification$default(MessageWithPartnerWithRoomWithReactions messageWithPartnerWithRoomWithReactions, Context context, String str, String str2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str = "";
        }
        if ((i10 & 4) != 0) {
            str2 = "";
        }
        return toNotification(messageWithPartnerWithRoomWithReactions, context, str, str2);
    }

    public static final MessageNotification toReactedNotification(MessageWithPartnerWithRoomWithReactions messageWithPartnerWithRoomWithReactions, Context context, long j10, String senderAlias, String senderImage) {
        String picture;
        y.i(messageWithPartnerWithRoomWithReactions, "<this>");
        y.i(context, "context");
        y.i(senderAlias, "senderAlias");
        y.i(senderImage, "senderImage");
        XMPPUtils xMPPUtils = XMPPUtils.INSTANCE;
        Heritage heritageBuildHeritageGroup = xMPPUtils.isMUC(messageWithPartnerWithRoomWithReactions.getMessage().getRoomId()) ? ConfigProcessor.INSTANCE.buildHeritageGroup(messageWithPartnerWithRoomWithReactions.getMessage().getRoomId()) : ConfigProcessor.INSTANCE.buildHeritagePrivateChat(messageWithPartnerWithRoomWithReactions.getMessage().getRoomId());
        String id2 = messageWithPartnerWithRoomWithReactions.getMessage().getId();
        String roomId = messageWithPartnerWithRoomWithReactions.getMessage().getRoomId();
        String roomName = messageWithPartnerWithRoomWithReactions.getRoomName();
        ImageLoader imageLoader = ImageLoader.INSTANCE;
        Room senderRoom = messageWithPartnerWithRoomWithReactions.getSenderRoom();
        if (senderRoom == null || (picture = senderRoom.getPicture()) == null) {
            picture = "";
        }
        String roomName2 = messageWithPartnerWithRoomWithReactions.getRoomName();
        ColorGenerator.Companion companion = ColorGenerator.INSTANCE;
        Bitmap circleImage$default = ImageLoader.getCircleImage$default(imageLoader, context, picture, roomName2, companion.getMATERIAL().getColor(messageWithPartnerWithRoomWithReactions.getRoomName()), false, 16, null);
        Bitmap circleImage$default2 = ImageLoader.getCircleImage$default(imageLoader, context, senderImage, senderAlias, companion.getMATERIAL().getColor(senderAlias), false, 16, null);
        String string = context.getString(R.string.react_to_this_msg);
        y.h(string, "getString(...)");
        return new MessageNotification(heritageBuildHeritageGroup, roomId, roomName, senderAlias, circleImage$default, circleImage$default2, id2, string, j10, false, true, !xMPPUtils.isChannel(messageWithPartnerWithRoomWithReactions.getMessage().getRoomId()));
    }

    public static /* synthetic */ MessageNotification toReactedNotification$default(MessageWithPartnerWithRoomWithReactions messageWithPartnerWithRoomWithReactions, Context context, long j10, String str, String str2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            j10 = 0;
        }
        return toReactedNotification(messageWithPartnerWithRoomWithReactions, context, j10, (i10 & 4) != 0 ? "" : str, (i10 & 8) != 0 ? "" : str2);
    }

    public static final String toShortMsg(RoomItemView roomItemView, Context context, String ownerId, String ownerAlias) {
        String senderAlias;
        List<Attachment> listN;
        String senderAlias2;
        Message message;
        Message message2;
        y.i(roomItemView, "<this>");
        y.i(context, "context");
        y.i(ownerId, "ownerId");
        y.i(ownerAlias, "ownerAlias");
        MessageWithPartnerWithReactions lastMessage = roomItemView.getLastMessage();
        MessagePayload payload = null;
        String str = "";
        if (y.d((lastMessage == null || (message2 = lastMessage.getMessage()) == null) ? null : message2.getUserSender(), ownerId)) {
            senderAlias = context.getResources().getString(R.string.f20195me);
            y.f(senderAlias);
        } else {
            MessageWithPartnerWithReactions lastMessage2 = roomItemView.getLastMessage();
            if (lastMessage2 == null || (senderAlias = lastMessage2.getSenderAlias()) == null) {
                senderAlias = "";
            }
        }
        if (roomItemView.getRoom().getType() == 2) {
            senderAlias = "";
        }
        if (roomItemView.getLastMessage() != null) {
            if (((roomItemView.getRoom().getType() != 0 && roomItemView.getRoom().getType() != 3) || !y.d(roomItemView.getLastMessage().getMessage().getUserSender(), ownerId)) && roomItemView.getLastMessage().getMessage().getPayload() == null && roomItemView.getRoom().getType() != 3) {
                str = senderAlias;
            }
            senderAlias = str;
        }
        if (!d0.q0(senderAlias)) {
            senderAlias = senderAlias + ": ";
        }
        Domain domain = Domain.INSTANCE;
        MessageWithPartnerWithReactions lastMessage3 = roomItemView.getLastMessage();
        Message message3 = lastMessage3 != null ? lastMessage3.getMessage() : null;
        MessageWithPartnerWithReactions lastMessage4 = roomItemView.getLastMessage();
        if (lastMessage4 == null || (listN = lastMessage4.getAttachments()) == null) {
            listN = w.n();
        }
        List<Attachment> list = listN;
        MessageWithPartnerWithReactions lastMessage5 = roomItemView.getLastMessage();
        if (lastMessage5 != null && (message = lastMessage5.getMessage()) != null) {
            payload = message.getPayload();
        }
        MessagePayload messagePayload = payload;
        MessageWithPartnerWithReactions lastMessage6 = roomItemView.getLastMessage();
        if (lastMessage6 == null || (senderAlias2 = lastMessage6.getSenderAlias()) == null) {
            senderAlias2 = "...";
        }
        return senderAlias + domain.createShorMsg(message3, list, messagePayload, context, ownerAlias, senderAlias2);
    }

    public static final String toShortMsg(MessageWithPartnerWithReactions messageWithPartnerWithReactions, Context context, String ownerId, String ownerAlias) {
        y.i(messageWithPartnerWithReactions, "<this>");
        y.i(context, "context");
        y.i(ownerId, "ownerId");
        y.i(ownerAlias, "ownerAlias");
        return Domain.INSTANCE.createShorMsg(messageWithPartnerWithReactions.getMessage(), messageWithPartnerWithReactions.getAttachments(), messageWithPartnerWithReactions.getMessage().getPayload(), context, ownerId, messageWithPartnerWithReactions.getSenderAlias());
    }

    public static final MessageItemType getItemMsgType(MessageWithPartnerWithRoomWithReactions messageWithPartnerWithRoomWithReactions) {
        y.i(messageWithPartnerWithRoomWithReactions, "<this>");
        return getItemMsgType(new MessageWithPartnerWithReactions(messageWithPartnerWithRoomWithReactions.getMessage(), messageWithPartnerWithRoomWithReactions.getSenderUser(), messageWithPartnerWithRoomWithReactions.getSenderContact(), messageWithPartnerWithRoomWithReactions.getAttachments(), null, 16, null));
    }
}
