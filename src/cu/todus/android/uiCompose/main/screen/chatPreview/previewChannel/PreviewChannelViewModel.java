package cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel;

import android.net.Uri;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.location.LocationRequestCompat;
import androidx.media3.extractor.ts.TsExtractor;
import androidx.p001lifecycle.ViewModelKt;
import androidx.paging.CachedPagingDataKt;
import androidx.paging.Pager;
import androidx.paging.PagingConfig;
import androidx.paging.PagingSource;
import cu.todus.android.R;
import cu.todus.android.data.db.entity.toDus.Room;
import cu.todus.android.data.db.entity.toDus.UserRoomJoin;
import cu.todus.android.data.preferences.Owner;
import cu.todus.android.data.wrapper.FlowsState;
import cu.todus.android.di.MainModule;
import cu.todus.android.exceptions.ToDusException;
import cu.todus.android.repositories.MainRepository;
import cu.todus.android.repositories.RoomsRepository;
import cu.todus.android.uiCompose.shared.insideNotification.Cause;
import cu.todus.android.uiCompose.shared.insideNotification.InsideNotificationState;
import cu.todus.android.uiCompose.shared.pagingSource.ResultPagingSource;
import cu.todus.android.utils.CoroutineUtilsKt;
import cu.todus.android.viewModel.ToDusViewModel;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.jivesoftware.smackx.mam.element.MamElements;
import pe.d1;
import te.r0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0002H\u0082@¢\u0006\u0004\b\b\u0010\tJ\r\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ#\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00022\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0011\u0010\u0005J#\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00022\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\r¢\u0006\u0004\b\u0013\u0010\u0010J#\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00022\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\r¢\u0006\u0004\b\u0015\u0010\u0010JQ\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00192\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\r2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00070\r¢\u0006\u0004\b\u001c\u0010\u001dJ9\u0010!\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00020\u001f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\r¢\u0006\u0004\b!\u0010\"J+\u0010$\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\u00022\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\r¢\u0006\u0004\b$\u0010%J\u0015\u0010&\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b&\u0010\u0005J\u0015\u0010'\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0002¢\u0006\u0004\b'\u0010\u0005R\u0014\u0010)\u001a\u00020(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010,\u001a\u00020+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0017\u0010/\u001a\u00020.8\u0006¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102R\u001a\u00104\u001a\b\u0012\u0004\u0012\u00020\u0019038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u00105R\u001d\u00107\u001a\b\u0012\u0004\u0012\u00020\u0019068\u0006¢\u0006\f\n\u0004\b7\u00108\u001a\u0004\b7\u00109R\u001a\u0010:\u001a\b\u0012\u0004\u0012\u00020\u0019038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b:\u00105R\u001d\u0010;\u001a\b\u0012\u0004\u0012\u00020\u0019068\u0006¢\u0006\f\n\u0004\b;\u00108\u001a\u0004\b;\u00109R\u001c\u0010=\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010<038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b=\u00105R\u001f\u0010>\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010<068\u0006¢\u0006\f\n\u0004\b>\u00108\u001a\u0004\b?\u00109R\u001a\u0010@\u001a\b\u0012\u0004\u0012\u00020\u0002038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b@\u00105R \u0010A\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u001f038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bA\u00105R#\u0010B\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u001f068\u0006¢\u0006\f\n\u0004\bB\u00108\u001a\u0004\bC\u00109R\u001a\u0010D\u001a\b\u0012\u0004\u0012\u00020\u0002038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bD\u00105R\u001d\u0010E\u001a\b\u0012\u0004\u0012\u00020\u0002068\u0006¢\u0006\f\n\u0004\bE\u00108\u001a\u0004\bF\u00109R \u0010H\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020G0\u001f038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bH\u00105R#\u0010I\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020G0\u001f068\u0006¢\u0006\f\n\u0004\bI\u00108\u001a\u0004\bJ\u00109R\u0014\u0010L\u001a\u00020K8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bL\u0010MR#\u0010Q\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020P0O0N8\u0006¢\u0006\f\n\u0004\bQ\u0010R\u001a\u0004\bS\u0010TR \u0010V\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190U038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bV\u00105R#\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190U068\u0006¢\u0006\f\n\u0004\b$\u00108\u001a\u0004\bW\u00109¨\u0006X"}, d2 = {"Lcu/todus/android/uiCompose/main/screen/chatPreview/previewChannel/PreviewChannelViewModel;", "Lcu/todus/android/viewModel/ToDusViewModel;", "", "chId", "<init>", "(Ljava/lang/String;)V", "uid", "Lua/k0;", "setAffiliation", "(Ljava/lang/String;Lab/e;)Ljava/lang/Object;", "Lcu/todus/android/data/preferences/Owner;", UserRoomJoin.AFFILIATION_OWNER, "()Lcu/todus/android/data/preferences/Owner;", "Lkotlin/Function0;", "onComplete", "createChannelLink", "(Ljava/lang/String;Llb/a;)V", "loadAdminChannels", "onLoaded", "loadPreviewChannel", "roomId", "leaveAndDeleteChannel", "newName", "newInfo", "newImage", "", "isDeletingImage", "onError", "updateChannel", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLlb/a;Llb/a;)V", "adminId", "", "newRights", "updateAdminRights", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Llb/a;)V", "userId", "expelSubscriber", "(Ljava/lang/String;Ljava/lang/String;Llb/a;)V", "changeSecretState", "changeMuteValue", "Lcu/todus/android/repositories/MainRepository;", "mainRepository", "Lcu/todus/android/repositories/MainRepository;", "Lcu/todus/android/repositories/RoomsRepository;", "roomsRepository", "Lcu/todus/android/repositories/RoomsRepository;", "Lv5/f;", "gson", "Lv5/f;", "getGson", "()Lv5/f;", "Lte/b0;", "_isSecret", "Lte/b0;", "Lte/p0;", "isSecret", "Lte/p0;", "()Lte/p0;", "_isMuted", Room.COLUMN_MUTED, "Lcu/todus/android/data/db/entity/toDus/Room;", "_previewChannel", "previewChannel", "getPreviewChannel", "_affiliationChannel", "_rightsChannel", "rightsChannel", "getRightsChannel", "_linkChannel", "linkChannel", "getLinkChannel", "Lcu/todus/android/data/xmpp/ChannelAdmin;", "_adminsChannel", "adminsChannel", "getAdminsChannel", "Landroidx/paging/PagingConfig;", "subscribersPagingConfig", "Landroidx/paging/PagingConfig;", "Lte/h;", "Landroidx/paging/PagingData;", "Lcu/todus/android/data/db/pojo/ChannelSubscriber;", "subscribers", "Lte/h;", "getSubscribers", "()Lte/h;", "Lcu/todus/android/data/wrapper/FlowsState;", "_expelSubscriber", "getExpelSubscriber", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class PreviewChannelViewModel extends ToDusViewModel {
    public static final int $stable = 8;
    private final te.b0 _adminsChannel;
    private final te.b0 _affiliationChannel;
    private final te.b0 _expelSubscriber;
    private final te.b0 _isMuted;
    private final te.b0 _isSecret;
    private final te.b0 _linkChannel;
    private final te.b0 _previewChannel;
    private final te.b0 _rightsChannel;
    private final te.p0 adminsChannel;
    private final te.p0 expelSubscriber;
    private final v5.f gson;
    private final te.p0 isMuted;
    private final te.p0 isSecret;
    private final te.p0 linkChannel;
    private final MainRepository mainRepository;
    private final te.p0 previewChannel;
    private final te.p0 rightsChannel;
    private final RoomsRepository roomsRepository;
    private final te.h subscribers;
    private final PagingConfig subscribersPagingConfig;

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel.PreviewChannelViewModel$changeMuteValue$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel.PreviewChannelViewModel$changeMuteValue$1", f = "PreviewChannelViewModel.kt", l = {283}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class AnonymousClass1 extends cb.m implements Function1 {
        final /* synthetic */ String $roomId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str, ab.e<? super AnonymousClass1> eVar) {
            super(1, eVar);
            this.$roomId = str;
        }

        @Override // cb.a
        public final ab.e<ua.k0> create(ab.e<?> eVar) {
            return PreviewChannelViewModel.this.new AnonymousClass1(this.$roomId, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super ua.k0> eVar) {
            return ((AnonymousClass1) create(eVar)).invokeSuspend(ua.k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                ua.v.b(obj);
                RoomsRepository roomsRepository = PreviewChannelViewModel.this.roomsRepository;
                String str = this.$roomId;
                this.label = 1;
                if (roomsRepository.changeMuteValue(str, this) == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ua.v.b(obj);
            }
            return ua.k0.f43947a;
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel.PreviewChannelViewModel$changeSecretState$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel.PreviewChannelViewModel$changeSecretState$1", f = "PreviewChannelViewModel.kt", l = {277}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C12551 extends cb.m implements Function1 {
        final /* synthetic */ String $uid;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12551(String str, ab.e<? super C12551> eVar) {
            super(1, eVar);
            this.$uid = str;
        }

        @Override // cb.a
        public final ab.e<ua.k0> create(ab.e<?> eVar) {
            return PreviewChannelViewModel.this.new C12551(this.$uid, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super ua.k0> eVar) {
            return ((C12551) create(eVar)).invokeSuspend(ua.k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                ua.v.b(obj);
                RoomsRepository roomsRepository = PreviewChannelViewModel.this.roomsRepository;
                String str = this.$uid;
                this.label = 1;
                if (roomsRepository.changeSecretState(str, this) == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ua.v.b(obj);
            }
            return ua.k0.f43947a;
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel.PreviewChannelViewModel$createChannelLink$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel.PreviewChannelViewModel$createChannelLink$1", f = "PreviewChannelViewModel.kt", l = {ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C12561 extends cb.m implements Function1 {
        final /* synthetic */ lb.a $onComplete;
        final /* synthetic */ String $uid;
        int label;

        /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel.PreviewChannelViewModel$createChannelLink$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        @cb.f(c = "cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel.PreviewChannelViewModel$createChannelLink$1$2", f = "PreviewChannelViewModel.kt", l = {}, m = "invokeSuspend", v = 2)
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
        public static final class AnonymousClass2 extends cb.m implements Function2 {
            final /* synthetic */ lb.a $onComplete;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass2(lb.a aVar, ab.e<? super AnonymousClass2> eVar) {
                super(2, eVar);
                this.$onComplete = aVar;
            }

            @Override // cb.a
            public final ab.e<ua.k0> create(Object obj, ab.e<?> eVar) {
                return new AnonymousClass2(this.$onComplete, eVar);
            }

            @Override // cb.a
            public final Object invokeSuspend(Object obj) {
                bb.b.g();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ua.v.b(obj);
                this.$onComplete.invoke();
                return ua.k0.f43947a;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(pe.m0 m0Var, ab.e<? super ua.k0> eVar) {
                return ((AnonymousClass2) create(m0Var, eVar)).invokeSuspend(ua.k0.f43947a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12561(String str, lb.a aVar, ab.e<? super C12561> eVar) {
            super(1, eVar);
            this.$uid = str;
            this.$onComplete = aVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final ua.k0 invokeSuspend$lambda$0(PreviewChannelViewModel previewChannelViewModel, String str, lb.a aVar) {
            previewChannelViewModel.createChannelLink(str, aVar);
            return ua.k0.f43947a;
        }

        @Override // cb.a
        public final ab.e<ua.k0> create(ab.e<?> eVar) {
            return PreviewChannelViewModel.this.new C12561(this.$uid, this.$onComplete, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super ua.k0> eVar) {
            return ((C12561) create(eVar)).invokeSuspend(ua.k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                ua.v.b(obj);
                MainRepository mainRepository = PreviewChannelViewModel.this.mainRepository;
                String str = this.$uid;
                this.label = 1;
                obj = mainRepository.createChannelLink(str, this);
                if (obj == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ua.v.b(obj);
            }
            if (((Boolean) obj).booleanValue()) {
                MainRepository mainRepository2 = PreviewChannelViewModel.this.mainRepository;
                String string = UUID.randomUUID().toString();
                kotlin.jvm.internal.y.h(string, "toString(...)");
                String strO = le.a0.O(string, "-", "", false, 4, null);
                Cause cause = Cause.CORRECT;
                String string2 = MainModule.INSTANCE.getInstance().getAppContext().getString(R.string.new_link_created);
                kotlin.jvm.internal.y.h(string2, "getString(...)");
                mainRepository2.addNewNotification(new InsideNotificationState(strO, cause, string2));
            } else {
                Function1 setError = PreviewChannelViewModel.this.mainRepository.getSetError();
                String string3 = MainModule.INSTANCE.getInstance().getAppContext().getString(R.string.new_link_not_created);
                kotlin.jvm.internal.y.h(string3, "getString(...)");
                final PreviewChannelViewModel previewChannelViewModel = PreviewChannelViewModel.this;
                final String str2 = this.$uid;
                final lb.a aVar = this.$onComplete;
                setError.invoke(new ToDusException(string3, new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel.o0
                    @Override // lb.a
                    public final Object invoke() {
                        return PreviewChannelViewModel.C12561.invokeSuspend$lambda$0(previewChannelViewModel, str2, aVar);
                    }
                }, true));
            }
            pe.k.d(ViewModelKt.getViewModelScope(PreviewChannelViewModel.this), d1.c(), null, new AnonymousClass2(this.$onComplete, null), 2, null);
            return ua.k0.f43947a;
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel.PreviewChannelViewModel$expelSubscriber$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel.PreviewChannelViewModel$expelSubscriber$1", f = "PreviewChannelViewModel.kt", l = {263}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C12571 extends cb.m implements Function1 {
        final /* synthetic */ String $chId;
        final /* synthetic */ lb.a $onComplete;
        final /* synthetic */ String $userId;
        int label;

        /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel.PreviewChannelViewModel$expelSubscriber$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        @cb.f(c = "cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel.PreviewChannelViewModel$expelSubscriber$1$1", f = "PreviewChannelViewModel.kt", l = {}, m = "invokeSuspend", v = 2)
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
        public static final class C02271 extends cb.m implements Function2 {
            final /* synthetic */ lb.a $onComplete;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C02271(lb.a aVar, ab.e<? super C02271> eVar) {
                super(2, eVar);
                this.$onComplete = aVar;
            }

            @Override // cb.a
            public final ab.e<ua.k0> create(Object obj, ab.e<?> eVar) {
                return new C02271(this.$onComplete, eVar);
            }

            @Override // cb.a
            public final Object invokeSuspend(Object obj) {
                bb.b.g();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ua.v.b(obj);
                this.$onComplete.invoke();
                return ua.k0.f43947a;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(pe.m0 m0Var, ab.e<? super ua.k0> eVar) {
                return ((C02271) create(m0Var, eVar)).invokeSuspend(ua.k0.f43947a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12571(String str, String str2, lb.a aVar, ab.e<? super C12571> eVar) {
            super(1, eVar);
            this.$chId = str;
            this.$userId = str2;
            this.$onComplete = aVar;
        }

        @Override // cb.a
        public final ab.e<ua.k0> create(ab.e<?> eVar) {
            return PreviewChannelViewModel.this.new C12571(this.$chId, this.$userId, this.$onComplete, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super ua.k0> eVar) {
            return ((C12571) create(eVar)).invokeSuspend(ua.k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                ua.v.b(obj);
                MainRepository mainRepository = PreviewChannelViewModel.this.mainRepository;
                String str = this.$chId;
                String str2 = this.$userId;
                this.label = 1;
                obj = mainRepository.expelSubscriber(str, str2, this);
                if (obj == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ua.v.b(obj);
            }
            PreviewChannelViewModel.this._expelSubscriber.setValue(FlowsState.INSTANCE.success(cb.b.a(((Boolean) obj).booleanValue())));
            pe.k.d(ViewModelKt.getViewModelScope(PreviewChannelViewModel.this), d1.c(), null, new C02271(this.$onComplete, null), 2, null);
            return ua.k0.f43947a;
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel.PreviewChannelViewModel$leaveAndDeleteChannel$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel.PreviewChannelViewModel$leaveAndDeleteChannel$1", f = "PreviewChannelViewModel.kt", l = {137, TsExtractor.TS_STREAM_TYPE_DTS_UHD, 145}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C12581 extends cb.m implements Function1 {
        final /* synthetic */ lb.a $onComplete;
        final /* synthetic */ String $roomId;
        boolean Z$0;
        int label;

        /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel.PreviewChannelViewModel$leaveAndDeleteChannel$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        @cb.f(c = "cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel.PreviewChannelViewModel$leaveAndDeleteChannel$1$1", f = "PreviewChannelViewModel.kt", l = {}, m = "invokeSuspend", v = 2)
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
        public static final class C02281 extends cb.m implements Function2 {
            final /* synthetic */ lb.a $onComplete;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C02281(lb.a aVar, ab.e<? super C02281> eVar) {
                super(2, eVar);
                this.$onComplete = aVar;
            }

            @Override // cb.a
            public final ab.e<ua.k0> create(Object obj, ab.e<?> eVar) {
                return new C02281(this.$onComplete, eVar);
            }

            @Override // cb.a
            public final Object invokeSuspend(Object obj) {
                bb.b.g();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ua.v.b(obj);
                this.$onComplete.invoke();
                return ua.k0.f43947a;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(pe.m0 m0Var, ab.e<? super ua.k0> eVar) {
                return ((C02281) create(m0Var, eVar)).invokeSuspend(ua.k0.f43947a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12581(String str, lb.a aVar, ab.e<? super C12581> eVar) {
            super(1, eVar);
            this.$roomId = str;
            this.$onComplete = aVar;
        }

        @Override // cb.a
        public final ab.e<ua.k0> create(ab.e<?> eVar) {
            return PreviewChannelViewModel.this.new C12581(this.$roomId, this.$onComplete, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super ua.k0> eVar) {
            return ((C12581) create(eVar)).invokeSuspend(ua.k0.f43947a);
        }

        /* JADX WARN: Code duplicated, block: B:19:0x0050  */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x006f, code lost:
        
            if (pe.w0.b(300, r11) == r0) goto L22;
         */
        @Override // cb.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r12) {
            /*
                r11 = this;
                java.lang.Object r0 = bb.b.g()
                int r1 = r11.label
                r2 = 300(0x12c, double:1.48E-321)
                r4 = 3
                r5 = 2
                r6 = 1
                if (r1 == 0) goto L29
                if (r1 == r6) goto L25
                if (r1 == r5) goto L1f
                if (r1 != r4) goto L17
                ua.v.b(r12)
                goto L72
            L17:
                java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r12.<init>(r0)
                throw r12
            L1f:
                boolean r1 = r11.Z$0
                ua.v.b(r12)
                goto L4e
            L25:
                ua.v.b(r12)
                goto L3d
            L29:
                ua.v.b(r12)
                cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel.PreviewChannelViewModel r12 = cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel.PreviewChannelViewModel.this
                cu.todus.android.repositories.MainRepository r12 = cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel.PreviewChannelViewModel.access$getMainRepository$p(r12)
                java.lang.String r1 = r11.$roomId
                r11.label = r6
                java.lang.Object r12 = r12.leaveChannel(r1, r11)
                if (r12 != r0) goto L3d
                goto L71
            L3d:
                java.lang.Boolean r12 = (java.lang.Boolean) r12
                boolean r1 = r12.booleanValue()
                r11.Z$0 = r1
                r11.label = r5
                java.lang.Object r12 = pe.w0.b(r2, r11)
                if (r12 != r0) goto L4e
                goto L71
            L4e:
                if (r1 == 0) goto L67
                cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel.PreviewChannelViewModel r12 = cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel.PreviewChannelViewModel.this
                pe.m0 r5 = androidx.p001lifecycle.ViewModelKt.getViewModelScope(r12)
                pe.k2 r6 = pe.d1.c()
                cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel.PreviewChannelViewModel$leaveAndDeleteChannel$1$1 r8 = new cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel.PreviewChannelViewModel$leaveAndDeleteChannel$1$1
                lb.a r12 = r11.$onComplete
                r7 = 0
                r8.<init>(r12, r7)
                r9 = 2
                r10 = 0
                pe.i.d(r5, r6, r7, r8, r9, r10)
            L67:
                r11.Z$0 = r1
                r11.label = r4
                java.lang.Object r12 = pe.w0.b(r2, r11)
                if (r12 != r0) goto L72
            L71:
                return r0
            L72:
                ua.k0 r12 = ua.k0.f43947a
                return r12
            */
            throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel.PreviewChannelViewModel.C12581.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel.PreviewChannelViewModel$loadAdminChannels$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel.PreviewChannelViewModel$loadAdminChannels$1", f = "PreviewChannelViewModel.kt", l = {94}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C12591 extends cb.m implements Function1 {
        final /* synthetic */ String $uid;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12591(String str, ab.e<? super C12591> eVar) {
            super(1, eVar);
            this.$uid = str;
        }

        @Override // cb.a
        public final ab.e<ua.k0> create(ab.e<?> eVar) {
            return PreviewChannelViewModel.this.new C12591(this.$uid, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super ua.k0> eVar) {
            return ((C12591) create(eVar)).invokeSuspend(ua.k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                ua.v.b(obj);
                MainRepository mainRepository = PreviewChannelViewModel.this.mainRepository;
                String str = this.$uid;
                this.label = 1;
                obj = mainRepository.getChannelAdmins(str, this);
                if (obj == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ua.v.b(obj);
            }
            Object objN = (ArrayList) obj;
            te.b0 b0Var = PreviewChannelViewModel.this._adminsChannel;
            if (objN == null) {
                objN = va.w.n();
            }
            b0Var.setValue(objN);
            return ua.k0.f43947a;
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel.PreviewChannelViewModel$loadPreviewChannel$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel.PreviewChannelViewModel$loadPreviewChannel$1", f = "PreviewChannelViewModel.kt", l = {110, 114}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
    public static final class C12601 extends cb.m implements Function2 {
        final /* synthetic */ lb.a $onLoaded;
        final /* synthetic */ String $uid;
        Object L$0;
        int label;

        /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel.PreviewChannelViewModel$loadPreviewChannel$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        @cb.f(c = "cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel.PreviewChannelViewModel$loadPreviewChannel$1$1", f = "PreviewChannelViewModel.kt", l = {117}, m = "invokeSuspend", v = 2)
        @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcu/todus/android/data/db/entity/toDus/Room;", MamElements.MamResultExtension.ELEMENT, "Lua/k0;", "<anonymous>", "(Lcu/todus/android/data/db/entity/toDus/Room;)V"}, k = 3, mv = {2, 3, 0})
        public static final class C02291 extends cb.m implements Function2 {
            final /* synthetic */ lb.a $onLoaded;
            final /* synthetic */ String $uid;
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ PreviewChannelViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C02291(PreviewChannelViewModel previewChannelViewModel, String str, lb.a aVar, ab.e<? super C02291> eVar) {
                super(2, eVar);
                this.this$0 = previewChannelViewModel;
                this.$uid = str;
                this.$onLoaded = aVar;
            }

            @Override // cb.a
            public final ab.e<ua.k0> create(Object obj, ab.e<?> eVar) {
                C02291 c02291 = new C02291(this.this$0, this.$uid, this.$onLoaded, eVar);
                c02291.L$0 = obj;
                return c02291;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Room room, ab.e<? super ua.k0> eVar) {
                return ((C02291) create(room, eVar)).invokeSuspend(ua.k0.f43947a);
            }

            @Override // cb.a
            public final Object invokeSuspend(Object obj) {
                String str;
                List<String> listN;
                Map<String, String> config;
                Room room = (Room) this.L$0;
                Object objG = bb.b.g();
                int i10 = this.label;
                if (i10 == 0) {
                    ua.v.b(obj);
                    this.this$0._previewChannel.setValue(room);
                    PreviewChannelViewModel previewChannelViewModel = this.this$0;
                    String str2 = this.$uid;
                    this.L$0 = room;
                    this.label = 1;
                    if (previewChannelViewModel.setAffiliation(str2, this) == objG) {
                        return objG;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ua.v.b(obj);
                }
                te.b0 b0Var = this.this$0._linkChannel;
                if (((room == null || (config = room.getConfig()) == null) ? null : config.get(Room.CONFIG_SHARE_LINK)) != null) {
                    str = "https://chat.todus.cu/@" + ((Object) room.getConfig().get(Room.CONFIG_SHARE_LINK));
                } else {
                    str = "";
                }
                b0Var.setValue(str);
                this.this$0._isSecret.setValue(cb.b.a(room != null ? room.getSecret() : false));
                this.this$0._isMuted.setValue(cb.b.a(room != null ? room.isMuted() : false));
                te.b0 b0Var2 = this.this$0._rightsChannel;
                if (room == null || (listN = room.getRights()) == null) {
                    listN = va.w.n();
                }
                b0Var2.setValue(listN);
                this.$onLoaded.invoke();
                return ua.k0.f43947a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12601(String str, lb.a aVar, ab.e<? super C12601> eVar) {
            super(2, eVar);
            this.$uid = str;
            this.$onLoaded = aVar;
        }

        @Override // cb.a
        public final ab.e<ua.k0> create(Object obj, ab.e<?> eVar) {
            return PreviewChannelViewModel.this.new C12601(this.$uid, this.$onLoaded, eVar);
        }

        /* JADX WARN: Code restructure failed: missing block: B:17:0x0069, code lost:
        
            if (te.j.k(r1, r3, r8) == r0) goto L18;
         */
        @Override // cb.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r9) {
            /*
                r8 = this;
                java.lang.Object r0 = bb.b.g()
                int r1 = r8.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L22
                if (r1 == r3) goto L1e
                if (r1 != r2) goto L16
                java.lang.Object r0 = r8.L$0
                java.lang.String r0 = (java.lang.String) r0
                ua.v.b(r9)
                goto L6c
            L16:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r0)
                throw r9
            L1e:
                ua.v.b(r9)
                goto L36
            L22:
                ua.v.b(r9)
                cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel.PreviewChannelViewModel r9 = cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel.PreviewChannelViewModel.this
                cu.todus.android.repositories.RoomsRepository r9 = cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel.PreviewChannelViewModel.access$getRoomsRepository$p(r9)
                java.lang.String r1 = r8.$uid
                r8.label = r3
                java.lang.Object r9 = r9.getAffiliationOnRoom(r1, r8)
                if (r9 != r0) goto L36
                goto L6b
            L36:
                java.lang.String r9 = (java.lang.String) r9
                if (r9 != 0) goto L3c
                java.lang.String r9 = "none"
            L3c:
                cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel.PreviewChannelViewModel r1 = cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel.PreviewChannelViewModel.this
                te.b0 r1 = cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel.PreviewChannelViewModel.access$get_affiliationChannel$p(r1)
                r1.setValue(r9)
                cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel.PreviewChannelViewModel r1 = cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel.PreviewChannelViewModel.this
                cu.todus.android.repositories.MainRepository r1 = cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel.PreviewChannelViewModel.access$getMainRepository$p(r1)
                java.lang.String r3 = r8.$uid
                te.h r1 = r1.getRoomByIdFlow(r3)
                cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel.PreviewChannelViewModel$loadPreviewChannel$1$1 r3 = new cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel.PreviewChannelViewModel$loadPreviewChannel$1$1
                cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel.PreviewChannelViewModel r4 = cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel.PreviewChannelViewModel.this
                java.lang.String r5 = r8.$uid
                lb.a r6 = r8.$onLoaded
                r7 = 0
                r3.<init>(r4, r5, r6, r7)
                java.lang.Object r9 = cb.l.a(r9)
                r8.L$0 = r9
                r8.label = r2
                java.lang.Object r9 = te.j.k(r1, r3, r8)
                if (r9 != r0) goto L6c
            L6b:
                return r0
            L6c:
                ua.k0 r9 = ua.k0.f43947a
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel.PreviewChannelViewModel.C12601.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(pe.m0 m0Var, ab.e<? super ua.k0> eVar) {
            return ((C12601) create(m0Var, eVar)).invokeSuspend(ua.k0.f43947a);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel.PreviewChannelViewModel$setAffiliation$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel.PreviewChannelViewModel", f = "PreviewChannelViewModel.kt", l = {LocationRequestCompat.QUALITY_BALANCED_POWER_ACCURACY}, m = "setAffiliation", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C12611 extends cb.d {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C12611(ab.e<? super C12611> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PreviewChannelViewModel.this.setAffiliation(null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel.PreviewChannelViewModel$updateAdminRights$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel.PreviewChannelViewModel$updateAdminRights$1", f = "PreviewChannelViewModel.kt", l = {233}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C12621 extends cb.m implements Function1 {
        final /* synthetic */ String $adminId;
        final /* synthetic */ String $chId;
        final /* synthetic */ List<String> $newRights;
        final /* synthetic */ lb.a $onComplete;
        int label;

        /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel.PreviewChannelViewModel$updateAdminRights$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        @cb.f(c = "cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel.PreviewChannelViewModel$updateAdminRights$1$1", f = "PreviewChannelViewModel.kt", l = {}, m = "invokeSuspend", v = 2)
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
        public static final class C02301 extends cb.m implements Function2 {
            final /* synthetic */ lb.a $onComplete;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C02301(lb.a aVar, ab.e<? super C02301> eVar) {
                super(2, eVar);
                this.$onComplete = aVar;
            }

            @Override // cb.a
            public final ab.e<ua.k0> create(Object obj, ab.e<?> eVar) {
                return new C02301(this.$onComplete, eVar);
            }

            @Override // cb.a
            public final Object invokeSuspend(Object obj) {
                bb.b.g();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ua.v.b(obj);
                this.$onComplete.invoke();
                return ua.k0.f43947a;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(pe.m0 m0Var, ab.e<? super ua.k0> eVar) {
                return ((C02301) create(m0Var, eVar)).invokeSuspend(ua.k0.f43947a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12621(String str, String str2, List<String> list, lb.a aVar, ab.e<? super C12621> eVar) {
            super(1, eVar);
            this.$adminId = str;
            this.$chId = str2;
            this.$newRights = list;
            this.$onComplete = aVar;
        }

        @Override // cb.a
        public final ab.e<ua.k0> create(ab.e<?> eVar) {
            return PreviewChannelViewModel.this.new C12621(this.$adminId, this.$chId, this.$newRights, this.$onComplete, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super ua.k0> eVar) {
            return ((C12621) create(eVar)).invokeSuspend(ua.k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                ua.v.b(obj);
                MainRepository mainRepository = PreviewChannelViewModel.this.mainRepository;
                String str = this.$adminId;
                String str2 = this.$chId;
                List<String> list = this.$newRights;
                this.label = 1;
                obj = mainRepository.updateAdminRights(str, str2, list, this);
                if (obj == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ua.v.b(obj);
            }
            if (((Boolean) obj).booleanValue()) {
                MainRepository mainRepository2 = PreviewChannelViewModel.this.mainRepository;
                String string = UUID.randomUUID().toString();
                kotlin.jvm.internal.y.h(string, "toString(...)");
                String strO = le.a0.O(string, "-", "", false, 4, null);
                Cause cause = Cause.CORRECT;
                String string2 = MainModule.INSTANCE.getInstance().getAppContext().getString(R.string.admin_rights_updated);
                kotlin.jvm.internal.y.h(string2, "getString(...)");
                mainRepository2.addNewNotification(new InsideNotificationState(strO, cause, string2));
            } else {
                MainRepository mainRepository3 = PreviewChannelViewModel.this.mainRepository;
                String string3 = UUID.randomUUID().toString();
                kotlin.jvm.internal.y.h(string3, "toString(...)");
                String strO2 = le.a0.O(string3, "-", "", false, 4, null);
                Cause cause2 = Cause.ERROR;
                String string4 = MainModule.INSTANCE.getInstance().getAppContext().getString(R.string.action_not_complete);
                kotlin.jvm.internal.y.h(string4, "getString(...)");
                mainRepository3.addNewNotification(new InsideNotificationState(strO2, cause2, string4));
            }
            pe.k.d(ViewModelKt.getViewModelScope(PreviewChannelViewModel.this), d1.c(), null, new C02301(this.$onComplete, null), 2, null);
            return ua.k0.f43947a;
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel.PreviewChannelViewModel$updateChannel$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel.PreviewChannelViewModel$updateChannel$1", f = "PreviewChannelViewModel.kt", l = {162}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C12631 extends cb.m implements Function1 {
        final /* synthetic */ boolean $isDeletingImage;
        final /* synthetic */ String $newImage;
        final /* synthetic */ String $newInfo;
        final /* synthetic */ String $newName;
        final /* synthetic */ lb.a $onComplete;
        final /* synthetic */ lb.a $onError;
        final /* synthetic */ String $roomId;
        int label;

        /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel.PreviewChannelViewModel$updateChannel$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        @cb.f(c = "cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel.PreviewChannelViewModel$updateChannel$1$1", f = "PreviewChannelViewModel.kt", l = {}, m = "invokeSuspend", v = 2)
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
        public static final class C02311 extends cb.m implements Function2 {
            final /* synthetic */ lb.a $onComplete;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C02311(lb.a aVar, ab.e<? super C02311> eVar) {
                super(2, eVar);
                this.$onComplete = aVar;
            }

            @Override // cb.a
            public final ab.e<ua.k0> create(Object obj, ab.e<?> eVar) {
                return new C02311(this.$onComplete, eVar);
            }

            @Override // cb.a
            public final Object invokeSuspend(Object obj) {
                bb.b.g();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ua.v.b(obj);
                this.$onComplete.invoke();
                return ua.k0.f43947a;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(pe.m0 m0Var, ab.e<? super ua.k0> eVar) {
                return ((C02311) create(m0Var, eVar)).invokeSuspend(ua.k0.f43947a);
            }
        }

        /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel.PreviewChannelViewModel$updateChannel$1$3, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        @cb.f(c = "cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel.PreviewChannelViewModel$updateChannel$1$3", f = "PreviewChannelViewModel.kt", l = {}, m = "invokeSuspend", v = 2)
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
        public static final class AnonymousClass3 extends cb.m implements Function2 {
            final /* synthetic */ lb.a $onError;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass3(lb.a aVar, ab.e<? super AnonymousClass3> eVar) {
                super(2, eVar);
                this.$onError = aVar;
            }

            @Override // cb.a
            public final ab.e<ua.k0> create(Object obj, ab.e<?> eVar) {
                return new AnonymousClass3(this.$onError, eVar);
            }

            @Override // cb.a
            public final Object invokeSuspend(Object obj) {
                bb.b.g();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ua.v.b(obj);
                this.$onError.invoke();
                return ua.k0.f43947a;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(pe.m0 m0Var, ab.e<? super ua.k0> eVar) {
                return ((AnonymousClass3) create(m0Var, eVar)).invokeSuspend(ua.k0.f43947a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12631(String str, String str2, String str3, String str4, boolean z10, lb.a aVar, lb.a aVar2, ab.e<? super C12631> eVar) {
            super(1, eVar);
            this.$newImage = str;
            this.$newName = str2;
            this.$newInfo = str3;
            this.$roomId = str4;
            this.$isDeletingImage = z10;
            this.$onComplete = aVar;
            this.$onError = aVar2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final ua.k0 invokeSuspend$lambda$0(PreviewChannelViewModel previewChannelViewModel, String str, String str2, String str3, String str4, boolean z10, lb.a aVar, lb.a aVar2) {
            previewChannelViewModel.updateChannel(str, str2, str3, str4, z10, aVar, aVar2);
            return ua.k0.f43947a;
        }

        @Override // cb.a
        public final ab.e<ua.k0> create(ab.e<?> eVar) {
            return PreviewChannelViewModel.this.new C12631(this.$newImage, this.$newName, this.$newInfo, this.$roomId, this.$isDeletingImage, this.$onComplete, this.$onError, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super ua.k0> eVar) {
            return ((C12631) create(eVar)).invokeSuspend(ua.k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objUpdateChannelInfo;
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                ua.v.b(obj);
                MainRepository mainRepository = PreviewChannelViewModel.this.mainRepository;
                Uri uri = this.$newImage.length() == 0 ? null : Uri.parse(this.$newImage);
                String str = this.$newName;
                String str2 = this.$newInfo;
                String str3 = this.$roomId;
                boolean z10 = this.$isDeletingImage;
                this.label = 1;
                objUpdateChannelInfo = mainRepository.updateChannelInfo(str, uri, str2, str3, z10, this);
                if (objUpdateChannelInfo == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ua.v.b(obj);
                objUpdateChannelInfo = obj;
            }
            if (((Boolean) objUpdateChannelInfo).booleanValue()) {
                MainRepository mainRepository2 = PreviewChannelViewModel.this.mainRepository;
                String string = UUID.randomUUID().toString();
                kotlin.jvm.internal.y.h(string, "toString(...)");
                String strO = le.a0.O(string, "-", "", false, 4, null);
                Cause cause = Cause.CORRECT;
                String string2 = MainModule.INSTANCE.getInstance().getAppContext().getString(R.string.information_updated);
                kotlin.jvm.internal.y.h(string2, "getString(...)");
                mainRepository2.addNewNotification(new InsideNotificationState(strO, cause, string2));
                pe.k.d(ViewModelKt.getViewModelScope(PreviewChannelViewModel.this), d1.c(), null, new C02311(this.$onComplete, null), 2, null);
            } else {
                Function1 setError = PreviewChannelViewModel.this.mainRepository.getSetError();
                String string3 = MainModule.INSTANCE.getInstance().getAppContext().getString(R.string.error_trying_update);
                kotlin.jvm.internal.y.h(string3, "getString(...)");
                final PreviewChannelViewModel previewChannelViewModel = PreviewChannelViewModel.this;
                final String str4 = this.$roomId;
                final String str5 = this.$newName;
                final String str6 = this.$newInfo;
                final String str7 = this.$newImage;
                final boolean z11 = this.$isDeletingImage;
                final lb.a aVar = this.$onComplete;
                final lb.a aVar2 = this.$onError;
                setError.invoke(new ToDusException(string3, new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel.p0
                    @Override // lb.a
                    public final Object invoke() {
                        return PreviewChannelViewModel.C12631.invokeSuspend$lambda$0(previewChannelViewModel, str4, str5, str6, str7, z11, aVar, aVar2);
                    }
                }, true));
                pe.k.d(ViewModelKt.getViewModelScope(PreviewChannelViewModel.this), d1.c(), null, new AnonymousClass3(this.$onError, null), 2, null);
            }
            return ua.k0.f43947a;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PreviewChannelViewModel() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object setAffiliation(String str, ab.e<? super ua.k0> eVar) {
        C12611 c12611;
        if (eVar instanceof C12611) {
            c12611 = (C12611) eVar;
            int i10 = c12611.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c12611.label = i10 - Integer.MIN_VALUE;
            } else {
                c12611 = new C12611(eVar);
            }
        } else {
            c12611 = new C12611(eVar);
        }
        Object affiliationOnRoom = c12611.result;
        Object objG = bb.b.g();
        int i11 = c12611.label;
        if (i11 == 0) {
            ua.v.b(affiliationOnRoom);
            RoomsRepository roomsRepository = this.roomsRepository;
            c12611.L$0 = cb.l.a(str);
            c12611.label = 1;
            affiliationOnRoom = roomsRepository.getAffiliationOnRoom(str, c12611);
            if (affiliationOnRoom == objG) {
                return objG;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ua.v.b(affiliationOnRoom);
        }
        String str2 = (String) affiliationOnRoom;
        if (str2 == null) {
            str2 = "none";
        }
        this._affiliationChannel.setValue(str2);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PagingSource subscribers$lambda$0(PreviewChannelViewModel previewChannelViewModel, String str) {
        return new ResultPagingSource(new PreviewChannelViewModel$subscribers$1$pagingSource$1(previewChannelViewModel, str, null), previewChannelViewModel.subscribersPagingConfig.pageSize);
    }

    public final void changeMuteValue(String roomId) {
        kotlin.jvm.internal.y.i(roomId, "roomId");
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(roomId, null), 3, null);
    }

    public final void changeSecretState(String uid) {
        kotlin.jvm.internal.y.i(uid, "uid");
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new C12551(uid, null), 3, null);
    }

    public final void createChannelLink(String uid, lb.a onComplete) {
        kotlin.jvm.internal.y.i(uid, "uid");
        kotlin.jvm.internal.y.i(onComplete, "onComplete");
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new C12561(uid, onComplete, null), 3, null);
    }

    public final void expelSubscriber(String chId, String userId, lb.a onComplete) {
        kotlin.jvm.internal.y.i(chId, "chId");
        kotlin.jvm.internal.y.i(userId, "userId");
        kotlin.jvm.internal.y.i(onComplete, "onComplete");
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new C12571(chId, userId, onComplete, null), 3, null);
    }

    public final te.p0 getAdminsChannel() {
        return this.adminsChannel;
    }

    public final te.p0 getExpelSubscriber() {
        return this.expelSubscriber;
    }

    public final v5.f getGson() {
        return this.gson;
    }

    public final te.p0 getLinkChannel() {
        return this.linkChannel;
    }

    public final te.p0 getPreviewChannel() {
        return this.previewChannel;
    }

    public final te.p0 getRightsChannel() {
        return this.rightsChannel;
    }

    public final te.h getSubscribers() {
        return this.subscribers;
    }

    /* JADX INFO: renamed from: isMuted, reason: from getter */
    public final te.p0 getIsMuted() {
        return this.isMuted;
    }

    /* JADX INFO: renamed from: isSecret, reason: from getter */
    public final te.p0 getIsSecret() {
        return this.isSecret;
    }

    public final void leaveAndDeleteChannel(String roomId, lb.a onComplete) {
        kotlin.jvm.internal.y.i(roomId, "roomId");
        kotlin.jvm.internal.y.i(onComplete, "onComplete");
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new C12581(roomId, onComplete, null), 3, null);
    }

    public final void loadAdminChannels(String uid) {
        kotlin.jvm.internal.y.i(uid, "uid");
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new C12591(uid, null), 3, null);
    }

    public final void loadPreviewChannel(String uid, lb.a onLoaded) {
        kotlin.jvm.internal.y.i(uid, "uid");
        kotlin.jvm.internal.y.i(onLoaded, "onLoaded");
        pe.k.d(ViewModelKt.getViewModelScope(this), null, null, new C12601(uid, onLoaded, null), 3, null);
    }

    public final Owner owner() {
        return (Owner) this.mainRepository.getOwner().invoke();
    }

    public final void updateAdminRights(String adminId, String chId, List<String> newRights, lb.a onComplete) {
        kotlin.jvm.internal.y.i(adminId, "adminId");
        kotlin.jvm.internal.y.i(chId, "chId");
        kotlin.jvm.internal.y.i(newRights, "newRights");
        kotlin.jvm.internal.y.i(onComplete, "onComplete");
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new C12621(adminId, chId, newRights, onComplete, null), 3, null);
    }

    public final void updateChannel(String roomId, String newName, String newInfo, String newImage, boolean isDeletingImage, lb.a onComplete, lb.a onError) {
        kotlin.jvm.internal.y.i(roomId, "roomId");
        kotlin.jvm.internal.y.i(newName, "newName");
        kotlin.jvm.internal.y.i(newInfo, "newInfo");
        kotlin.jvm.internal.y.i(newImage, "newImage");
        kotlin.jvm.internal.y.i(onComplete, "onComplete");
        kotlin.jvm.internal.y.i(onError, "onError");
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new C12631(newImage, newName, newInfo, roomId, isDeletingImage, onComplete, onError, null), 3, null);
    }

    public PreviewChannelViewModel(final String chId) {
        kotlin.jvm.internal.y.i(chId, "chId");
        this.mainRepository = MainRepository.INSTANCE.getInstance();
        this.roomsRepository = RoomsRepository.INSTANCE.getInstance();
        this.gson = MainModule.INSTANCE.getInstance().getGson();
        Boolean bool = Boolean.FALSE;
        te.b0 b0VarA = r0.a(bool);
        this._isSecret = b0VarA;
        this.isSecret = te.j.b(b0VarA);
        te.b0 b0VarA2 = r0.a(bool);
        this._isMuted = b0VarA2;
        this.isMuted = te.j.b(b0VarA2);
        te.b0 b0VarA3 = r0.a(null);
        this._previewChannel = b0VarA3;
        this.previewChannel = te.j.b(b0VarA3);
        this._affiliationChannel = r0.a("");
        te.b0 b0VarA4 = r0.a(va.w.n());
        this._rightsChannel = b0VarA4;
        this.rightsChannel = te.j.b(b0VarA4);
        te.b0 b0VarA5 = r0.a("");
        this._linkChannel = b0VarA5;
        this.linkChannel = te.j.b(b0VarA5);
        te.b0 b0VarA6 = r0.a(va.w.n());
        this._adminsChannel = b0VarA6;
        this.adminsChannel = te.j.b(b0VarA6);
        PagingConfig pagingConfig = new PagingConfig(20, 20, true, 40, Integer.MAX_VALUE, 0, 32, null);
        this.subscribersPagingConfig = pagingConfig;
        this.subscribers = CachedPagingDataKt.cachedIn(new Pager(pagingConfig, null, new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel.n0
            @Override // lb.a
            public final Object invoke() {
                return PreviewChannelViewModel.subscribers$lambda$0(this.f25681c, chId);
            }
        }, 2, null).getFlow(), ViewModelKt.getViewModelScope(this));
        te.b0 b0VarA7 = r0.a(FlowsState.INSTANCE.notRequested());
        this._expelSubscriber = b0VarA7;
        this.expelSubscriber = te.j.b(b0VarA7);
    }

    public /* synthetic */ PreviewChannelViewModel(String str, int i10, kotlin.jvm.internal.p pVar) {
        this((i10 & 1) != 0 ? "" : str);
    }
}
