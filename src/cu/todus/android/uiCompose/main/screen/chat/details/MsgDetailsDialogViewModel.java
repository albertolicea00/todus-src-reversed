package cu.todus.android.uiCompose.main.screen.chat.details;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.p001lifecycle.ViewModelKt;
import androidx.paging.CachedPagingDataKt;
import androidx.paging.Pager;
import androidx.paging.PagingConfig;
import androidx.paging.PagingSource;
import cu.todus.android.data.db.entity.toDus.Attachment;
import cu.todus.android.data.db.entity.toDus.Room;
import cu.todus.android.data.db.entity.toDus.User;
import cu.todus.android.data.db.pojo.MessageWithPartnerWithReactions;
import cu.todus.android.data.db.pojo.MessageWithPartnerWithRoomWithReactions;
import cu.todus.android.data.db.pojo.content.Content;
import cu.todus.android.data.db.pojo.content.ReplyMsgContent;
import cu.todus.android.data.preferences.Owner;
import cu.todus.android.di.MainModule;
import cu.todus.android.repositories.MainRepository;
import cu.todus.android.repositories.RoomsRepository;
import cu.todus.android.utils.CoroutineUtilsKt;
import cu.todus.android.utils.ExtensionFunsKt;
import cu.todus.android.viewModel.ToDusViewModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t2\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\rJ!\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\n0\t2\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u000f\u0010\rJ\u0015\u0010\u0011\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0017\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u001d\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001a0\u001d8\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u0014\u0010#\u001a\u00020\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$¨\u0006%"}, d2 = {"Lcu/todus/android/uiCompose/main/screen/chat/details/MsgDetailsDialogViewModel;", "Lcu/todus/android/viewModel/ToDusViewModel;", "<init>", "()V", "Lcu/todus/android/data/preferences/Owner;", "getOwner", "()Lcu/todus/android/data/preferences/Owner;", "", Room.COLUMN_LAST_MSG, "Lte/h;", "Landroidx/paging/PagingData;", "Lcu/todus/android/data/db/pojo/ReactionWithPartner;", "reactionsFromMsg", "(Ljava/lang/String;)Lte/h;", "Lcu/todus/android/data/db/pojo/MarkerWithPartner;", "markersFromMsg", "Lua/k0;", "loadData", "(Ljava/lang/String;)V", "Lcu/todus/android/repositories/MainRepository;", "mainRepository", "Lcu/todus/android/repositories/MainRepository;", "Lcu/todus/android/repositories/RoomsRepository;", "roomsRepository", "Lcu/todus/android/repositories/RoomsRepository;", "Lte/b0;", "Lcu/todus/android/uiCompose/main/screen/chat/details/MsgDetailsDialogState;", "_detailsState", "Lte/b0;", "Lte/p0;", "detailsState", "Lte/p0;", "getDetailsState", "()Lte/p0;", "Landroidx/paging/PagingConfig;", "reactionsPagingConfig", "Landroidx/paging/PagingConfig;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class MsgDetailsDialogViewModel extends ToDusViewModel {
    public static final int $stable = 8;
    private final te.b0 _detailsState;
    private final te.p0 detailsState;
    private final PagingConfig reactionsPagingConfig;
    private final MainRepository mainRepository = MainRepository.INSTANCE.getInstance();
    private final RoomsRepository roomsRepository = RoomsRepository.INSTANCE.getInstance();

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.chat.details.MsgDetailsDialogViewModel$loadData$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.chat.details.MsgDetailsDialogViewModel$loadData$1", f = "MsgDetailsDialogViewModel.kt", l = {50, ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF, 56}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class AnonymousClass1 extends cb.m implements Function1 {
        final /* synthetic */ String $msgId;
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str, ab.e<? super AnonymousClass1> eVar) {
            super(1, eVar);
            this.$msgId = str;
        }

        @Override // cb.a
        public final ab.e<ua.k0> create(ab.e<?> eVar) {
            return MsgDetailsDialogViewModel.this.new AnonymousClass1(this.$msgId, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super ua.k0> eVar) {
            return ((AnonymousClass1) create(eVar)).invokeSuspend(ua.k0.f43947a);
        }

        /* JADX WARN: Code duplicated, block: B:39:0x00d8  */
        /* JADX WARN: Code duplicated, block: B:42:0x00ff  */
        /* JADX WARN: Code duplicated, block: B:46:0x0121  */
        /* JADX WARN: Code duplicated, block: B:55:0x016b  */
        /* JADX WARN: Code duplicated, block: B:58:0x018c  */
        /* JADX WARN: Code duplicated, block: B:60:0x0196  */
        /* JADX WARN: Code duplicated, block: B:68:0x012e A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:70:0x011b A[SYNTHETIC] */
        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object fullMsgDataById;
            MessageWithPartnerWithRoomWithReactions messageWithPartnerWithRoomWithReactionsCopy$default;
            List<Attachment> attachments;
            Attachment attachment;
            int i10;
            Object msgById;
            MsgDetailsDialogViewModel msgDetailsDialogViewModel;
            MessageWithPartnerWithRoomWithReactions messageWithPartnerWithRoomWithReactions;
            Attachment attachment2;
            MessageWithPartnerWithReactions messageWithPartnerWithReactions;
            Object msgPosition;
            MessageWithPartnerWithReactions messageWithPartnerWithReactions2;
            MsgDetailsDialogViewModel msgDetailsDialogViewModel2;
            Attachment attachment3;
            ArrayList arrayList;
            User senderUser;
            String userSender;
            String senderAlias;
            Object objG = bb.b.g();
            int i11 = this.label;
            if (i11 == 0) {
                ua.v.b(obj);
                MainRepository mainRepository = MsgDetailsDialogViewModel.this.mainRepository;
                String str = this.$msgId;
                this.label = 1;
                fullMsgDataById = mainRepository.getFullMsgDataById(str, this);
                if (fullMsgDataById != objG) {
                }
                return objG;
            }
            if (i11 == 1) {
                ua.v.b(obj);
                fullMsgDataById = obj;
            } else {
                if (i11 == 2) {
                    int i12 = this.I$0;
                    Attachment attachment4 = (Attachment) this.L$2;
                    messageWithPartnerWithRoomWithReactions = (MessageWithPartnerWithRoomWithReactions) this.L$1;
                    msgDetailsDialogViewModel = (MsgDetailsDialogViewModel) this.L$0;
                    ua.v.b(obj);
                    i10 = i12;
                    attachment2 = attachment4;
                    msgById = obj;
                    messageWithPartnerWithReactions = (MessageWithPartnerWithReactions) msgById;
                    if (messageWithPartnerWithReactions != null) {
                        RoomsRepository roomsRepository = msgDetailsDialogViewModel.roomsRepository;
                        String roomId = messageWithPartnerWithReactions.getMessage().getRoomId();
                        String id2 = messageWithPartnerWithReactions.getMessage().getId();
                        this.L$0 = msgDetailsDialogViewModel;
                        this.L$1 = messageWithPartnerWithRoomWithReactions;
                        this.L$2 = attachment2;
                        this.L$3 = messageWithPartnerWithReactions;
                        this.I$0 = i10;
                        this.label = 3;
                        msgPosition = roomsRepository.getMsgPosition(roomId, id2, this);
                        if (msgPosition != objG) {
                            messageWithPartnerWithReactions2 = messageWithPartnerWithReactions;
                            msgDetailsDialogViewModel2 = msgDetailsDialogViewModel;
                        }
                        return objG;
                    }
                    MsgDetailsDialogViewModel msgDetailsDialogViewModel3 = MsgDetailsDialogViewModel.this;
                    msgDetailsDialogViewModel3._detailsState.setValue(MsgDetailsDialogState.copy$default((MsgDetailsDialogState) msgDetailsDialogViewModel3._detailsState.getValue(), false, messageWithPartnerWithRoomWithReactions, null, 4, null));
                    return ua.k0.f43947a;
                }
                if (i11 != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                messageWithPartnerWithReactions2 = (MessageWithPartnerWithReactions) this.L$3;
                attachment2 = (Attachment) this.L$2;
                MessageWithPartnerWithRoomWithReactions messageWithPartnerWithRoomWithReactions2 = (MessageWithPartnerWithRoomWithReactions) this.L$1;
                msgDetailsDialogViewModel2 = (MsgDetailsDialogViewModel) this.L$0;
                ua.v.b(obj);
                messageWithPartnerWithRoomWithReactions = messageWithPartnerWithRoomWithReactions2;
                msgPosition = obj;
            }
            attachment3 = attachment2;
            int iIntValue = ((Number) msgPosition).intValue();
            ArrayList arrayList2 = new ArrayList();
            List<Attachment> attachments2 = messageWithPartnerWithRoomWithReactions.getAttachments();
            arrayList = new ArrayList();
            for (Object obj2 : attachments2) {
                if (((Attachment) obj2).getType() != 9) {
                    arrayList.add(obj2);
                }
            }
            arrayList2.addAll(arrayList);
            ReplyMsgContent replyMsgContent = (ReplyMsgContent) attachment3.getContent();
            String shortMsg = ExtensionFunsKt.toShortMsg(messageWithPartnerWithReactions2, MainModule.INSTANCE.getInstance().getAppContext(), msgDetailsDialogViewModel2.getOwner().getNameWithDomain(), msgDetailsDialogViewModel2.getOwner().getAlias());
            senderUser = messageWithPartnerWithReactions2.getSenderUser();
            if (senderUser != null || (userSender = senderUser.getUsername()) == null) {
                userSender = messageWithPartnerWithReactions2.getMessage().getUserSender();
            }
            String str2 = userSender;
            if (kotlin.jvm.internal.y.d(((ReplyMsgContent) attachment3.getContent()).getSenderId(), msgDetailsDialogViewModel2.getOwner().getNameWithDomain())) {
                senderAlias = msgDetailsDialogViewModel2.getOwner().getAlias();
            } else {
                senderAlias = messageWithPartnerWithReactions2.getSenderAlias();
            }
            arrayList2.add(Attachment.copy$default(attachment3, null, null, ReplyMsgContent.copy$default(replyMsgContent, null, false, shortMsg, str2, senderAlias, iIntValue, messageWithPartnerWithReactions2.getMessage().getCreateAt(), true, false, null, null, 1795, null), 0, 0, false, 59, null));
            messageWithPartnerWithRoomWithReactionsCopy$default = MessageWithPartnerWithRoomWithReactions.copy$default(messageWithPartnerWithRoomWithReactions, null, null, null, arrayList2, null, null, 55, null);
            messageWithPartnerWithRoomWithReactions = messageWithPartnerWithRoomWithReactionsCopy$default;
            MsgDetailsDialogViewModel msgDetailsDialogViewModel4 = MsgDetailsDialogViewModel.this;
            msgDetailsDialogViewModel4._detailsState.setValue(MsgDetailsDialogState.copy$default((MsgDetailsDialogState) msgDetailsDialogViewModel4._detailsState.getValue(), false, messageWithPartnerWithRoomWithReactions, null, 4, null));
            return ua.k0.f43947a;
            MsgDetailsDialogViewModel msgDetailsDialogViewModel5 = MsgDetailsDialogViewModel.this;
            messageWithPartnerWithRoomWithReactionsCopy$default = (MessageWithPartnerWithRoomWithReactions) fullMsgDataById;
            if (messageWithPartnerWithRoomWithReactionsCopy$default != null && (attachments = messageWithPartnerWithRoomWithReactionsCopy$default.getAttachments()) != null && !attachments.isEmpty()) {
                Iterator<T> it = attachments.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (((Attachment) it.next()).getType() == 9) {
                            Iterator<T> it2 = messageWithPartnerWithRoomWithReactionsCopy$default.getAttachments().iterator();
                            do {
                                if (!it2.hasNext()) {
                                    throw new NoSuchElementException("Collection contains no element matching the predicate.");
                                }
                                attachment = (Attachment) it2.next();
                            } while (attachment.getType() != 9);
                            MainRepository mainRepository2 = msgDetailsDialogViewModel5.mainRepository;
                            Content content = attachment.getContent();
                            kotlin.jvm.internal.y.g(content, "null cannot be cast to non-null type cu.todus.android.data.db.pojo.content.ReplyMsgContent");
                            String msgId = ((ReplyMsgContent) content).getMsgId();
                            this.L$0 = msgDetailsDialogViewModel5;
                            this.L$1 = messageWithPartnerWithRoomWithReactionsCopy$default;
                            this.L$2 = attachment;
                            i10 = 0;
                            this.I$0 = 0;
                            this.label = 2;
                            msgById = mainRepository2.getMsgById(msgId, this);
                            if (msgById != objG) {
                                msgDetailsDialogViewModel = msgDetailsDialogViewModel5;
                                messageWithPartnerWithRoomWithReactions = messageWithPartnerWithRoomWithReactionsCopy$default;
                                attachment2 = attachment;
                                messageWithPartnerWithReactions = (MessageWithPartnerWithReactions) msgById;
                                if (messageWithPartnerWithReactions != null) {
                                    RoomsRepository roomsRepository2 = msgDetailsDialogViewModel.roomsRepository;
                                    String roomId2 = messageWithPartnerWithReactions.getMessage().getRoomId();
                                    String id3 = messageWithPartnerWithReactions.getMessage().getId();
                                    this.L$0 = msgDetailsDialogViewModel;
                                    this.L$1 = messageWithPartnerWithRoomWithReactions;
                                    this.L$2 = attachment2;
                                    this.L$3 = messageWithPartnerWithReactions;
                                    this.I$0 = i10;
                                    this.label = 3;
                                    msgPosition = roomsRepository2.getMsgPosition(roomId2, id3, this);
                                    if (msgPosition != objG) {
                                        messageWithPartnerWithReactions2 = messageWithPartnerWithReactions;
                                        msgDetailsDialogViewModel2 = msgDetailsDialogViewModel;
                                        attachment3 = attachment2;
                                        int iIntValue2 = ((Number) msgPosition).intValue();
                                        ArrayList arrayList3 = new ArrayList();
                                        List<Attachment> attachments3 = messageWithPartnerWithRoomWithReactions.getAttachments();
                                        arrayList = new ArrayList();
                                        while (r3.hasNext()) {
                                            if (((Attachment) obj2).getType() != 9) {
                                                arrayList.add(obj2);
                                            }
                                        }
                                        arrayList3.addAll(arrayList);
                                        ReplyMsgContent replyMsgContent2 = (ReplyMsgContent) attachment3.getContent();
                                        String shortMsg2 = ExtensionFunsKt.toShortMsg(messageWithPartnerWithReactions2, MainModule.INSTANCE.getInstance().getAppContext(), msgDetailsDialogViewModel2.getOwner().getNameWithDomain(), msgDetailsDialogViewModel2.getOwner().getAlias());
                                        senderUser = messageWithPartnerWithReactions2.getSenderUser();
                                        if (senderUser != null) {
                                            userSender = messageWithPartnerWithReactions2.getMessage().getUserSender();
                                        } else {
                                            userSender = messageWithPartnerWithReactions2.getMessage().getUserSender();
                                        }
                                        String str3 = userSender;
                                        if (kotlin.jvm.internal.y.d(((ReplyMsgContent) attachment3.getContent()).getSenderId(), msgDetailsDialogViewModel2.getOwner().getNameWithDomain())) {
                                            senderAlias = msgDetailsDialogViewModel2.getOwner().getAlias();
                                        } else {
                                            senderAlias = messageWithPartnerWithReactions2.getSenderAlias();
                                        }
                                        arrayList3.add(Attachment.copy$default(attachment3, null, null, ReplyMsgContent.copy$default(replyMsgContent2, null, false, shortMsg2, str3, senderAlias, iIntValue2, messageWithPartnerWithReactions2.getMessage().getCreateAt(), true, false, null, null, 1795, null), 0, 0, false, 59, null));
                                        messageWithPartnerWithRoomWithReactionsCopy$default = MessageWithPartnerWithRoomWithReactions.copy$default(messageWithPartnerWithRoomWithReactions, null, null, null, arrayList3, null, null, 55, null);
                                    }
                                }
                                MsgDetailsDialogViewModel msgDetailsDialogViewModel6 = MsgDetailsDialogViewModel.this;
                                msgDetailsDialogViewModel6._detailsState.setValue(MsgDetailsDialogState.copy$default((MsgDetailsDialogState) msgDetailsDialogViewModel6._detailsState.getValue(), false, messageWithPartnerWithRoomWithReactions, null, 4, null));
                                return ua.k0.f43947a;
                            }
                            return objG;
                        }
                    }
                }
            }
            messageWithPartnerWithRoomWithReactions = messageWithPartnerWithRoomWithReactionsCopy$default;
            MsgDetailsDialogViewModel msgDetailsDialogViewModel7 = MsgDetailsDialogViewModel.this;
            msgDetailsDialogViewModel7._detailsState.setValue(MsgDetailsDialogState.copy$default((MsgDetailsDialogState) msgDetailsDialogViewModel7._detailsState.getValue(), false, messageWithPartnerWithRoomWithReactions, null, 4, null));
            return ua.k0.f43947a;
        }
    }

    public MsgDetailsDialogViewModel() {
        te.b0 b0VarA = te.r0.a(new MsgDetailsDialogState(false, null, null, 7, null));
        this._detailsState = b0VarA;
        this.detailsState = te.j.b(b0VarA);
        this.reactionsPagingConfig = new PagingConfig(30, 30, true, 60, Integer.MAX_VALUE, 0, 32, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PagingSource markersFromMsg$lambda$0(MsgDetailsDialogViewModel msgDetailsDialogViewModel, String str) {
        return msgDetailsDialogViewModel.mainRepository.getMarkersFromMsg(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PagingSource reactionsFromMsg$lambda$0(MsgDetailsDialogViewModel msgDetailsDialogViewModel, String str) {
        return msgDetailsDialogViewModel.mainRepository.getReactionsByEntityId(str);
    }

    public final te.p0 getDetailsState() {
        return this.detailsState;
    }

    public final Owner getOwner() {
        return (Owner) this.mainRepository.getOwner().invoke();
    }

    public final void loadData(String msgId) {
        kotlin.jvm.internal.y.i(msgId, "msgId");
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(msgId, null), 3, null);
    }

    public final te.h markersFromMsg(final String msgId) {
        kotlin.jvm.internal.y.i(msgId, "msgId");
        return CachedPagingDataKt.cachedIn(new Pager(this.reactionsPagingConfig, null, new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.details.w0
            @Override // lb.a
            public final Object invoke() {
                return MsgDetailsDialogViewModel.markersFromMsg$lambda$0(this.f24701c, msgId);
            }
        }, 2, null).getFlow(), ViewModelKt.getViewModelScope(this));
    }

    public final te.h reactionsFromMsg(final String msgId) {
        kotlin.jvm.internal.y.i(msgId, "msgId");
        return CachedPagingDataKt.cachedIn(new Pager(this.reactionsPagingConfig, null, new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.details.x0
            @Override // lb.a
            public final Object invoke() {
                return MsgDetailsDialogViewModel.reactionsFromMsg$lambda$0(this.f24710c, msgId);
            }
        }, 2, null).getFlow(), ViewModelKt.getViewModelScope(this));
    }
}
