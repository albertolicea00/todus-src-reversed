package cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.media3.extractor.ts.TsExtractor;
import androidx.media3.muxer.WebmConstants;
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
import cu.todus.android.data.xmpp.AddMembersToGroupResponse;
import cu.todus.android.data.xmpp.AdminGroupActionsResponse;
import cu.todus.android.di.MainModule;
import cu.todus.android.exceptions.ToDusException;
import cu.todus.android.repositories.MainRepository;
import cu.todus.android.repositories.RoomsRepository;
import cu.todus.android.repositories.UsersRepository;
import cu.todus.android.uiCompose.shared.insideNotification.Cause;
import cu.todus.android.uiCompose.shared.insideNotification.InsideNotificationState;
import cu.todus.android.utils.CoroutineUtilsKt;
import cu.todus.android.viewModel.ToDusViewModel;
import cu.z17.views.utils.Z17MutableListFlow;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.jivesoftware.smackx.mam.element.MamElements;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0082@¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\n\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ#\u0010\u000f\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00042\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0086@¢\u0006\u0004\b\u0011\u0010\bJ#\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\r¢\u0006\u0004\b\u0013\u0010\u0010J!\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00150\u00142\u0006\u0010\f\u001a\u00020\u0004¢\u0006\u0004\b\u0017\u0010\u0018J1\u0010\u001a\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00042\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00060\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\r¢\u0006\u0004\b\u001a\u0010\u001bJ\u0015\u0010\u001c\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0004¢\u0006\u0004\b\u001c\u0010\u001dJ]\u0010$\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00042\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00042\u0006\u0010\"\u001a\u00020!2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\r2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00060\r¢\u0006\u0004\b$\u0010%J+\u0010'\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u00042\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\r¢\u0006\u0004\b'\u0010(J\u0015\u0010)\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0004¢\u0006\u0004\b)\u0010\u001dJ\u0015\u0010*\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b*\u0010\u001dJ\u0015\u0010+\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0004¢\u0006\u0004\b+\u0010\u001dJ9\u0010-\u001a\u00020\u00062\u0006\u0010,\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\r2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00060\r¢\u0006\u0004\b-\u0010.J9\u0010/\u001a\u00020\u00062\u0006\u0010,\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\r2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00060\r¢\u0006\u0004\b/\u0010.J!\u00102\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002010\u00150\u00142\u0006\u00100\u001a\u00020\u0004¢\u0006\u0004\b2\u0010\u0018J!\u00104\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002030\u00150\u00142\u0006\u00100\u001a\u00020\u0004¢\u0006\u0004\b4\u0010\u0018J1\u00107\u001a\u00020\u00062\u0006\u0010,\u001a\u00020\u00042\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u0004052\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\r¢\u0006\u0004\b7\u00108R\u0014\u0010:\u001a\u0002098\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b:\u0010;R\u0014\u0010=\u001a\u00020<8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b=\u0010>R\u0014\u0010@\u001a\u00020?8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b@\u0010AR\u0014\u0010C\u001a\u00020B8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bC\u0010DR\u0017\u0010F\u001a\u00020E8\u0006¢\u0006\f\n\u0004\bF\u0010G\u001a\u0004\bH\u0010IR\u001a\u0010K\u001a\b\u0012\u0004\u0012\u00020!0J8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bK\u0010LR\u001d\u0010N\u001a\b\u0012\u0004\u0012\u00020!0M8\u0006¢\u0006\f\n\u0004\bN\u0010O\u001a\u0004\bN\u0010PR\u001a\u0010Q\u001a\b\u0012\u0004\u0012\u00020!0J8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bQ\u0010LR\u001d\u0010R\u001a\b\u0012\u0004\u0012\u00020!0M8\u0006¢\u0006\f\n\u0004\bR\u0010O\u001a\u0004\bR\u0010PR \u0010T\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040S0J8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bT\u0010LR#\u0010U\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040S0M8\u0006¢\u0006\f\n\u0004\bU\u0010O\u001a\u0004\bV\u0010PR\u001a\u0010W\u001a\b\u0012\u0004\u0012\u00020\u00040J8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bW\u0010LR\u001d\u0010X\u001a\b\u0012\u0004\u0012\u00020\u00040M8\u0006¢\u0006\f\n\u0004\bX\u0010O\u001a\u0004\bY\u0010PR\u001c\u0010[\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010Z0J8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b[\u0010LR\u001f\u0010\\\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010Z0M8\u0006¢\u0006\f\n\u0004\b\\\u0010O\u001a\u0004\b]\u0010PR\u001a\u0010_\u001a\b\u0012\u0004\u0012\u00020^0J8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b_\u0010LR\u001d\u0010`\u001a\b\u0012\u0004\u0012\u00020^0M8\u0006¢\u0006\f\n\u0004\b`\u0010O\u001a\u0004\ba\u0010PR\u001d\u0010c\u001a\b\u0012\u0004\u0012\u00020\u00040b8\u0006¢\u0006\f\n\u0004\bc\u0010d\u001a\u0004\be\u0010fR\u0014\u0010g\u001a\u00020B8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bg\u0010D¨\u0006h"}, d2 = {"Lcu/todus/android/uiCompose/main/screen/chatPreview/previewGroup/PreviewGroupViewModel;", "Lcu/todus/android/viewModel/ToDusViewModel;", "<init>", "()V", "", "uid", "Lua/k0;", "setGroupLink", "(Ljava/lang/String;Lab/e;)Ljava/lang/Object;", "Lcu/todus/android/data/preferences/Owner;", UserRoomJoin.AFFILIATION_OWNER, "()Lcu/todus/android/data/preferences/Owner;", "roomId", "Lkotlin/Function0;", "onComplete", "createGroupLink", "(Ljava/lang/String;Llb/a;)V", "setAffiliation", "onLoaded", "loadPreviewGroup", "Lte/h;", "Landroidx/paging/PagingData;", "Lcu/todus/android/data/db/pojo/RoomMember;", "members", "(Ljava/lang/String;)Lte/h;", "onLeave", "leaveAndDeleteGroup", "(Ljava/lang/String;Llb/a;Llb/a;)V", "clearDeleteGroup", "(Ljava/lang/String;)V", "newName", "newInfo", "newImage", "", "isDeleting", "onError", "updateGroup", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLlb/a;Llb/a;)V", "memberId", "expelMember", "(Ljava/lang/String;Ljava/lang/String;Llb/a;)V", "clearHistory", "changeSecretState", "changeMuteValue", "groupId", "promoteToGroupAdmin", "(Ljava/lang/String;Ljava/lang/String;Llb/a;Llb/a;)V", "demoteFromGroupAdmin", "filter", "Lcu/todus/android/data/db/pojo/Friend;", "friendsOnDb", "Lcu/todus/android/data/db/pojo/Partner;", "usersOnDb", "", "newMembers", "addMembers", "(Ljava/lang/String;Ljava/util/List;Llb/a;)V", "Lcu/todus/android/repositories/MainRepository;", "mainRepository", "Lcu/todus/android/repositories/MainRepository;", "Lcu/todus/android/repositories/RoomsRepository;", "roomsRepository", "Lcu/todus/android/repositories/RoomsRepository;", "Lcu/todus/android/repositories/UsersRepository;", "usersRepository", "Lcu/todus/android/repositories/UsersRepository;", "Landroidx/paging/PagingConfig;", "pagerConfigs", "Landroidx/paging/PagingConfig;", "Lv5/f;", "gson", "Lv5/f;", "getGson", "()Lv5/f;", "Lte/b0;", "_isSecret", "Lte/b0;", "Lte/p0;", "isSecret", "Lte/p0;", "()Lte/p0;", "_isMuted", Room.COLUMN_MUTED, "Lcu/todus/android/data/wrapper/FlowsState;", "_link", "link", "getLink", "_affiliationGroup", "affiliationGroup", "getAffiliationGroup", "Lcu/todus/android/data/db/entity/toDus/Room;", "_previewGroup", "previewGroup", "getPreviewGroup", "", "_memberCount", "memberCount", "getMemberCount", "Lcu/z17/views/utils/Z17MutableListFlow;", "membersInGroup", "Lcu/z17/views/utils/Z17MutableListFlow;", "getMembersInGroup", "()Lcu/z17/views/utils/Z17MutableListFlow;", "contactsPagingConfig", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class PreviewGroupViewModel extends ToDusViewModel {
    public static final int $stable = 8;
    private final te.b0 _affiliationGroup;
    private final te.b0 _isMuted;
    private final te.b0 _isSecret;
    private final te.b0 _link;
    private final te.b0 _memberCount;
    private final te.b0 _previewGroup;
    private final te.p0 affiliationGroup;
    private final PagingConfig contactsPagingConfig;
    private final te.p0 isMuted;
    private final te.p0 isSecret;
    private final te.p0 link;
    private final te.p0 memberCount;
    private final Z17MutableListFlow<String> membersInGroup;
    private final te.p0 previewGroup;
    private final MainRepository mainRepository = MainRepository.INSTANCE.getInstance();
    private final RoomsRepository roomsRepository = RoomsRepository.INSTANCE.getInstance();
    private final UsersRepository usersRepository = UsersRepository.INSTANCE.getInstance();
    private final PagingConfig pagerConfigs = new PagingConfig(30, 30, true, 60, Integer.MAX_VALUE, 0, 32, null);
    private final v5.f gson = MainModule.INSTANCE.getInstance().getGson();

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.PreviewGroupViewModel$addMembers$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.PreviewGroupViewModel$addMembers$1", f = "PreviewGroupViewModel.kt", l = {408}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class AnonymousClass1 extends cb.m implements Function1 {
        final /* synthetic */ String $groupId;
        final /* synthetic */ List<String> $newMembers;
        final /* synthetic */ lb.a $onComplete;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str, List<String> list, lb.a aVar, ab.e<? super AnonymousClass1> eVar) {
            super(1, eVar);
            this.$groupId = str;
            this.$newMembers = list;
            this.$onComplete = aVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final ua.k0 invokeSuspend$lambda$0(PreviewGroupViewModel previewGroupViewModel, String str, List list, lb.a aVar) {
            previewGroupViewModel.addMembers(str, list, aVar);
            return ua.k0.f43947a;
        }

        @Override // cb.a
        public final ab.e<ua.k0> create(ab.e<?> eVar) {
            return PreviewGroupViewModel.this.new AnonymousClass1(this.$groupId, this.$newMembers, this.$onComplete, eVar);
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
                MainRepository mainRepository = PreviewGroupViewModel.this.mainRepository;
                String str = this.$groupId;
                List<String> list = this.$newMembers;
                this.label = 1;
                obj = mainRepository.addNewMembers(str, list, this);
                if (obj == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ua.v.b(obj);
            }
            int code = ((AddMembersToGroupResponse) obj).getCode();
            if (code == 0) {
                Function1 setError = PreviewGroupViewModel.this.mainRepository.getSetError();
                String string = MainModule.INSTANCE.getInstance().getAppContext().getString(R.string.network_error);
                kotlin.jvm.internal.y.h(string, "getString(...)");
                final PreviewGroupViewModel previewGroupViewModel = PreviewGroupViewModel.this;
                final String str2 = this.$groupId;
                final List<String> list2 = this.$newMembers;
                final lb.a aVar = this.$onComplete;
                setError.invoke(new ToDusException(string, new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.b2
                    @Override // lb.a
                    public final Object invoke() {
                        return PreviewGroupViewModel.AnonymousClass1.invokeSuspend$lambda$0(previewGroupViewModel, str2, list2, aVar);
                    }
                }, true));
            } else if (code == 1) {
                String string2 = UUID.randomUUID().toString();
                kotlin.jvm.internal.y.h(string2, "toString(...)");
                String strO = le.a0.O(string2, "-", "", false, 4, null);
                Cause cause = Cause.ERROR;
                String string3 = MainModule.INSTANCE.getInstance().getAppContext().getString(R.string.cannot_add_all_members);
                kotlin.jvm.internal.y.h(string3, "getString(...)");
                new InsideNotificationState(strO, cause, string3);
            } else if (code == 2) {
                String string4 = UUID.randomUUID().toString();
                kotlin.jvm.internal.y.h(string4, "toString(...)");
                String strO2 = le.a0.O(string4, "-", "", false, 4, null);
                Cause cause2 = Cause.CORRECT;
                String string5 = MainModule.INSTANCE.getInstance().getAppContext().getString(R.string.all_members_added);
                kotlin.jvm.internal.y.h(string5, "getString(...)");
                new InsideNotificationState(strO2, cause2, string5);
            } else if (code == 3) {
                String string6 = UUID.randomUUID().toString();
                kotlin.jvm.internal.y.h(string6, "toString(...)");
                String strO3 = le.a0.O(string6, "-", "", false, 4, null);
                Cause cause3 = Cause.ERROR;
                String string7 = MainModule.INSTANCE.getInstance().getAppContext().getString(R.string.no_member_added);
                kotlin.jvm.internal.y.h(string7, "getString(...)");
                new InsideNotificationState(strO3, cause3, string7);
            } else if (code == 4) {
                String string8 = UUID.randomUUID().toString();
                kotlin.jvm.internal.y.h(string8, "toString(...)");
                String strO4 = le.a0.O(string8, "-", "", false, 4, null);
                Cause cause4 = Cause.ERROR;
                String string9 = MainModule.INSTANCE.getInstance().getAppContext().getString(R.string.group_action_not_allowed);
                kotlin.jvm.internal.y.h(string9, "getString(...)");
                new InsideNotificationState(strO4, cause4, string9);
            }
            this.$onComplete.invoke();
            return ua.k0.f43947a;
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.PreviewGroupViewModel$changeMuteValue$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.PreviewGroupViewModel$changeMuteValue$1", f = "PreviewGroupViewModel.kt", l = {280}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C12641 extends cb.m implements Function1 {
        final /* synthetic */ String $roomId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12641(String str, ab.e<? super C12641> eVar) {
            super(1, eVar);
            this.$roomId = str;
        }

        @Override // cb.a
        public final ab.e<ua.k0> create(ab.e<?> eVar) {
            return PreviewGroupViewModel.this.new C12641(this.$roomId, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super ua.k0> eVar) {
            return ((C12641) create(eVar)).invokeSuspend(ua.k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                ua.v.b(obj);
                RoomsRepository roomsRepository = PreviewGroupViewModel.this.roomsRepository;
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

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.PreviewGroupViewModel$changeSecretState$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.PreviewGroupViewModel$changeSecretState$1", f = "PreviewGroupViewModel.kt", l = {274}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C12651 extends cb.m implements Function1 {
        final /* synthetic */ String $uid;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12651(String str, ab.e<? super C12651> eVar) {
            super(1, eVar);
            this.$uid = str;
        }

        @Override // cb.a
        public final ab.e<ua.k0> create(ab.e<?> eVar) {
            return PreviewGroupViewModel.this.new C12651(this.$uid, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super ua.k0> eVar) {
            return ((C12651) create(eVar)).invokeSuspend(ua.k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                ua.v.b(obj);
                RoomsRepository roomsRepository = PreviewGroupViewModel.this.roomsRepository;
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

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.PreviewGroupViewModel$clearDeleteGroup$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.PreviewGroupViewModel$clearDeleteGroup$1", f = "PreviewGroupViewModel.kt", l = {178}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C12661 extends cb.m implements Function1 {
        final /* synthetic */ String $roomId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12661(String str, ab.e<? super C12661> eVar) {
            super(1, eVar);
            this.$roomId = str;
        }

        @Override // cb.a
        public final ab.e<ua.k0> create(ab.e<?> eVar) {
            return PreviewGroupViewModel.this.new C12661(this.$roomId, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super ua.k0> eVar) {
            return ((C12661) create(eVar)).invokeSuspend(ua.k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                ua.v.b(obj);
                RoomsRepository roomsRepository = PreviewGroupViewModel.this.roomsRepository;
                String str = this.$roomId;
                this.label = 1;
                if (roomsRepository.clearAndDeleteRoom(str, this) == objG) {
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

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.PreviewGroupViewModel$clearHistory$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.PreviewGroupViewModel$clearHistory$1", f = "PreviewGroupViewModel.kt", l = {268}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C12671 extends cb.m implements Function1 {
        final /* synthetic */ String $roomId;
        Object L$0;
        int label;
        final /* synthetic */ PreviewGroupViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12671(String str, PreviewGroupViewModel previewGroupViewModel, ab.e<? super C12671> eVar) {
            super(1, eVar);
            this.$roomId = str;
            this.this$0 = previewGroupViewModel;
        }

        @Override // cb.a
        public final ab.e<ua.k0> create(ab.e<?> eVar) {
            return new C12671(this.$roomId, this.this$0, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super ua.k0> eVar) {
            return ((C12671) create(eVar)).invokeSuspend(ua.k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                ua.v.b(obj);
                ArrayList arrayListG = va.w.g(this.$roomId);
                MainRepository mainRepository = this.this$0.mainRepository;
                this.L$0 = cb.l.a(arrayListG);
                this.label = 1;
                if (mainRepository.clearHistoryFromRooms(arrayListG, this) == objG) {
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

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.PreviewGroupViewModel$createGroupLink$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.PreviewGroupViewModel$createGroupLink$1", f = "PreviewGroupViewModel.kt", l = {63}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C12681 extends cb.m implements Function1 {
        final /* synthetic */ lb.a $onComplete;
        final /* synthetic */ String $roomId;
        int label;

        /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.PreviewGroupViewModel$createGroupLink$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        @cb.f(c = "cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.PreviewGroupViewModel$createGroupLink$1$2", f = "PreviewGroupViewModel.kt", l = {}, m = "invokeSuspend", v = 2)
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
        public C12681(String str, lb.a aVar, ab.e<? super C12681> eVar) {
            super(1, eVar);
            this.$roomId = str;
            this.$onComplete = aVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final ua.k0 invokeSuspend$lambda$0(PreviewGroupViewModel previewGroupViewModel, String str, lb.a aVar) {
            previewGroupViewModel.createGroupLink(str, aVar);
            return ua.k0.f43947a;
        }

        @Override // cb.a
        public final ab.e<ua.k0> create(ab.e<?> eVar) {
            return PreviewGroupViewModel.this.new C12681(this.$roomId, this.$onComplete, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super ua.k0> eVar) {
            return ((C12681) create(eVar)).invokeSuspend(ua.k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                ua.v.b(obj);
                MainRepository mainRepository = PreviewGroupViewModel.this.mainRepository;
                String str = this.$roomId;
                this.label = 1;
                obj = mainRepository.createGroupLink(str, this);
                if (obj == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ua.v.b(obj);
            }
            if (((Pair) obj) != null) {
                MainRepository mainRepository2 = PreviewGroupViewModel.this.mainRepository;
                String string = UUID.randomUUID().toString();
                kotlin.jvm.internal.y.h(string, "toString(...)");
                String strO = le.a0.O(string, "-", "", false, 4, null);
                Cause cause = Cause.CORRECT;
                String string2 = MainModule.INSTANCE.getInstance().getAppContext().getString(R.string.new_link_created);
                kotlin.jvm.internal.y.h(string2, "getString(...)");
                mainRepository2.addNewNotification(new InsideNotificationState(strO, cause, string2));
            } else {
                Function1 setError = PreviewGroupViewModel.this.mainRepository.getSetError();
                String string3 = MainModule.INSTANCE.getInstance().getAppContext().getString(R.string.new_link_not_created);
                kotlin.jvm.internal.y.h(string3, "getString(...)");
                final PreviewGroupViewModel previewGroupViewModel = PreviewGroupViewModel.this;
                final String str2 = this.$roomId;
                final lb.a aVar = this.$onComplete;
                setError.invoke(new ToDusException(string3, new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.c2
                    @Override // lb.a
                    public final Object invoke() {
                        return PreviewGroupViewModel.C12681.invokeSuspend$lambda$0(previewGroupViewModel, str2, aVar);
                    }
                }, true));
            }
            pe.k.d(ViewModelKt.getViewModelScope(PreviewGroupViewModel.this), pe.d1.c(), null, new AnonymousClass2(this.$onComplete, null), 2, null);
            return ua.k0.f43947a;
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.PreviewGroupViewModel$demoteFromGroupAdmin$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.PreviewGroupViewModel$demoteFromGroupAdmin$1", f = "PreviewGroupViewModel.kt", l = {340}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C12691 extends cb.m implements Function1 {
        final /* synthetic */ String $groupId;
        final /* synthetic */ lb.a $onComplete;
        final /* synthetic */ lb.a $onError;
        final /* synthetic */ String $uid;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12691(String str, String str2, lb.a aVar, lb.a aVar2, ab.e<? super C12691> eVar) {
            super(1, eVar);
            this.$groupId = str;
            this.$uid = str2;
            this.$onError = aVar;
            this.$onComplete = aVar2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final ua.k0 invokeSuspend$lambda$0(PreviewGroupViewModel previewGroupViewModel, String str, String str2, lb.a aVar, lb.a aVar2) {
            previewGroupViewModel.demoteFromGroupAdmin(str, str2, aVar, aVar2);
            return ua.k0.f43947a;
        }

        @Override // cb.a
        public final ab.e<ua.k0> create(ab.e<?> eVar) {
            return PreviewGroupViewModel.this.new C12691(this.$groupId, this.$uid, this.$onError, this.$onComplete, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super ua.k0> eVar) {
            return ((C12691) create(eVar)).invokeSuspend(ua.k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                ua.v.b(obj);
                MainRepository mainRepository = PreviewGroupViewModel.this.mainRepository;
                String str = this.$groupId;
                String str2 = this.$uid;
                this.label = 1;
                obj = mainRepository.demoteFromAdmin(str, str2, this);
                if (obj == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ua.v.b(obj);
            }
            int code = ((AdminGroupActionsResponse) obj).getCode();
            if (code == 0) {
                Function1 setError = PreviewGroupViewModel.this.mainRepository.getSetError();
                String string = MainModule.INSTANCE.getInstance().getAppContext().getString(R.string.network_error);
                kotlin.jvm.internal.y.h(string, "getString(...)");
                final PreviewGroupViewModel previewGroupViewModel = PreviewGroupViewModel.this;
                final String str3 = this.$groupId;
                final String str4 = this.$uid;
                final lb.a aVar = this.$onComplete;
                final lb.a aVar2 = this.$onError;
                setError.invoke(new ToDusException(string, new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.d2
                    @Override // lb.a
                    public final Object invoke() {
                        return PreviewGroupViewModel.C12691.invokeSuspend$lambda$0(previewGroupViewModel, str3, str4, aVar, aVar2);
                    }
                }, true));
                this.$onError.invoke();
            } else if (code == 1) {
                String string2 = UUID.randomUUID().toString();
                kotlin.jvm.internal.y.h(string2, "toString(...)");
                String strO = le.a0.O(string2, "-", "", false, 4, null);
                Cause cause = Cause.ERROR;
                String string3 = MainModule.INSTANCE.getInstance().getAppContext().getString(R.string.cannot_removed_admin);
                kotlin.jvm.internal.y.h(string3, "getString(...)");
                new InsideNotificationState(strO, cause, string3);
                this.$onError.invoke();
            } else if (code == 2) {
                String string4 = UUID.randomUUID().toString();
                kotlin.jvm.internal.y.h(string4, "toString(...)");
                String strO2 = le.a0.O(string4, "-", "", false, 4, null);
                Cause cause2 = Cause.CORRECT;
                String string5 = MainModule.INSTANCE.getInstance().getAppContext().getString(R.string.admin_eliminated);
                kotlin.jvm.internal.y.h(string5, "getString(...)");
                new InsideNotificationState(strO2, cause2, string5);
                this.$onComplete.invoke();
            }
            return ua.k0.f43947a;
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.PreviewGroupViewModel$expelMember$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.PreviewGroupViewModel$expelMember$1", f = "PreviewGroupViewModel.kt", l = {256}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C12701 extends cb.m implements Function1 {
        final /* synthetic */ String $memberId;
        final /* synthetic */ lb.a $onComplete;
        final /* synthetic */ String $roomId;
        int label;

        /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.PreviewGroupViewModel$expelMember$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        @cb.f(c = "cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.PreviewGroupViewModel$expelMember$1$1", f = "PreviewGroupViewModel.kt", l = {}, m = "invokeSuspend", v = 2)
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
        public static final class C02321 extends cb.m implements Function2 {
            final /* synthetic */ lb.a $onComplete;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C02321(lb.a aVar, ab.e<? super C02321> eVar) {
                super(2, eVar);
                this.$onComplete = aVar;
            }

            @Override // cb.a
            public final ab.e<ua.k0> create(Object obj, ab.e<?> eVar) {
                return new C02321(this.$onComplete, eVar);
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
                return ((C02321) create(m0Var, eVar)).invokeSuspend(ua.k0.f43947a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12701(String str, String str2, lb.a aVar, ab.e<? super C12701> eVar) {
            super(1, eVar);
            this.$roomId = str;
            this.$memberId = str2;
            this.$onComplete = aVar;
        }

        @Override // cb.a
        public final ab.e<ua.k0> create(ab.e<?> eVar) {
            return PreviewGroupViewModel.this.new C12701(this.$roomId, this.$memberId, this.$onComplete, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super ua.k0> eVar) {
            return ((C12701) create(eVar)).invokeSuspend(ua.k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                ua.v.b(obj);
                MainRepository mainRepository = PreviewGroupViewModel.this.mainRepository;
                String str = this.$roomId;
                String str2 = this.$memberId;
                this.label = 1;
                if (mainRepository.expelMember(str, str2, this) == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ua.v.b(obj);
            }
            pe.k.d(ViewModelKt.getViewModelScope(PreviewGroupViewModel.this), pe.d1.c(), null, new C02321(this.$onComplete, null), 2, null);
            return ua.k0.f43947a;
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.PreviewGroupViewModel$leaveAndDeleteGroup$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.PreviewGroupViewModel$leaveAndDeleteGroup$1", f = "PreviewGroupViewModel.kt", l = {WebmConstants.MkvEbmlElement.BLOCK_GROUP, 162, 168}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C12711 extends cb.m implements Function1 {
        final /* synthetic */ lb.a $onComplete;
        final /* synthetic */ lb.a $onLeave;
        final /* synthetic */ String $roomId;
        boolean Z$0;
        int label;

        /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.PreviewGroupViewModel$leaveAndDeleteGroup$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        @cb.f(c = "cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.PreviewGroupViewModel$leaveAndDeleteGroup$1$1", f = "PreviewGroupViewModel.kt", l = {}, m = "invokeSuspend", v = 2)
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
        public static final class C02331 extends cb.m implements Function2 {
            final /* synthetic */ lb.a $onLeave;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C02331(lb.a aVar, ab.e<? super C02331> eVar) {
                super(2, eVar);
                this.$onLeave = aVar;
            }

            @Override // cb.a
            public final ab.e<ua.k0> create(Object obj, ab.e<?> eVar) {
                return new C02331(this.$onLeave, eVar);
            }

            @Override // cb.a
            public final Object invokeSuspend(Object obj) {
                bb.b.g();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ua.v.b(obj);
                this.$onLeave.invoke();
                return ua.k0.f43947a;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(pe.m0 m0Var, ab.e<? super ua.k0> eVar) {
                return ((C02331) create(m0Var, eVar)).invokeSuspend(ua.k0.f43947a);
            }
        }

        /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.PreviewGroupViewModel$leaveAndDeleteGroup$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        @cb.f(c = "cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.PreviewGroupViewModel$leaveAndDeleteGroup$1$2", f = "PreviewGroupViewModel.kt", l = {}, m = "invokeSuspend", v = 2)
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
        public C12711(String str, lb.a aVar, lb.a aVar2, ab.e<? super C12711> eVar) {
            super(1, eVar);
            this.$roomId = str;
            this.$onLeave = aVar;
            this.$onComplete = aVar2;
        }

        @Override // cb.a
        public final ab.e<ua.k0> create(ab.e<?> eVar) {
            return PreviewGroupViewModel.this.new C12711(this.$roomId, this.$onLeave, this.$onComplete, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super ua.k0> eVar) {
            return ((C12711) create(eVar)).invokeSuspend(ua.k0.f43947a);
        }

        /* JADX WARN: Code duplicated, block: B:19:0x0051  */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x0070, code lost:
        
            if (pe.w0.b(300, r12) == r0) goto L22;
         */
        @Override // cb.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r13) {
            /*
                r12 = this;
                java.lang.Object r0 = bb.b.g()
                int r1 = r12.label
                r2 = 0
                r3 = 300(0x12c, double:1.48E-321)
                r5 = 3
                r6 = 2
                r7 = 1
                if (r1 == 0) goto L2a
                if (r1 == r7) goto L26
                if (r1 == r6) goto L20
                if (r1 != r5) goto L18
                ua.v.b(r13)
                goto L73
            L18:
                java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r13.<init>(r0)
                throw r13
            L20:
                boolean r1 = r12.Z$0
                ua.v.b(r13)
                goto L4f
            L26:
                ua.v.b(r13)
                goto L3e
            L2a:
                ua.v.b(r13)
                cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.PreviewGroupViewModel r13 = cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.PreviewGroupViewModel.this
                cu.todus.android.repositories.MainRepository r13 = cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.PreviewGroupViewModel.access$getMainRepository$p(r13)
                java.lang.String r1 = r12.$roomId
                r12.label = r7
                java.lang.Object r13 = r13.leaveGroup(r1, r12)
                if (r13 != r0) goto L3e
                goto L72
            L3e:
                java.lang.Boolean r13 = (java.lang.Boolean) r13
                boolean r1 = r13.booleanValue()
                r12.Z$0 = r1
                r12.label = r6
                java.lang.Object r13 = pe.w0.b(r3, r12)
                if (r13 != r0) goto L4f
                goto L72
            L4f:
                if (r1 == 0) goto L68
                cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.PreviewGroupViewModel r13 = cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.PreviewGroupViewModel.this
                pe.m0 r6 = androidx.p001lifecycle.ViewModelKt.getViewModelScope(r13)
                pe.k2 r7 = pe.d1.c()
                cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.PreviewGroupViewModel$leaveAndDeleteGroup$1$1 r9 = new cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.PreviewGroupViewModel$leaveAndDeleteGroup$1$1
                lb.a r13 = r12.$onLeave
                r9.<init>(r13, r2)
                r10 = 2
                r11 = 0
                r8 = 0
                pe.i.d(r6, r7, r8, r9, r10, r11)
            L68:
                r12.Z$0 = r1
                r12.label = r5
                java.lang.Object r13 = pe.w0.b(r3, r12)
                if (r13 != r0) goto L73
            L72:
                return r0
            L73:
                cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.PreviewGroupViewModel r13 = cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.PreviewGroupViewModel.this
                pe.m0 r3 = androidx.p001lifecycle.ViewModelKt.getViewModelScope(r13)
                pe.k2 r4 = pe.d1.c()
                cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.PreviewGroupViewModel$leaveAndDeleteGroup$1$2 r6 = new cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.PreviewGroupViewModel$leaveAndDeleteGroup$1$2
                lb.a r13 = r12.$onComplete
                r6.<init>(r13, r2)
                r7 = 2
                r8 = 0
                r5 = 0
                pe.i.d(r3, r4, r5, r6, r7, r8)
                ua.k0 r13 = ua.k0.f43947a
                return r13
            */
            throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.PreviewGroupViewModel.C12711.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.PreviewGroupViewModel$loadPreviewGroup$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.PreviewGroupViewModel$loadPreviewGroup$1", f = "PreviewGroupViewModel.kt", l = {124}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
    public static final class C12721 extends cb.m implements Function2 {
        final /* synthetic */ lb.a $onLoaded;
        final /* synthetic */ String $uid;
        int label;

        /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.PreviewGroupViewModel$loadPreviewGroup$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        @cb.f(c = "cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.PreviewGroupViewModel$loadPreviewGroup$1$1", f = "PreviewGroupViewModel.kt", l = {TsExtractor.TS_STREAM_TYPE_E_AC3, 137}, m = "invokeSuspend", v = 2)
        @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcu/todus/android/data/db/entity/toDus/Room;", MamElements.MamResultExtension.ELEMENT, "Lua/k0;", "<anonymous>", "(Lcu/todus/android/data/db/entity/toDus/Room;)V"}, k = 3, mv = {2, 3, 0})
        public static final class C02341 extends cb.m implements Function2 {
            final /* synthetic */ lb.a $onLoaded;
            final /* synthetic */ String $uid;
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ PreviewGroupViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C02341(PreviewGroupViewModel previewGroupViewModel, lb.a aVar, String str, ab.e<? super C02341> eVar) {
                super(2, eVar);
                this.this$0 = previewGroupViewModel;
                this.$onLoaded = aVar;
                this.$uid = str;
            }

            @Override // cb.a
            public final ab.e<ua.k0> create(Object obj, ab.e<?> eVar) {
                C02341 c02341 = new C02341(this.this$0, this.$onLoaded, this.$uid, eVar);
                c02341.L$0 = obj;
                return c02341;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Room room, ab.e<? super ua.k0> eVar) {
                return ((C02341) create(room, eVar)).invokeSuspend(ua.k0.f43947a);
            }

            /* JADX WARN: Code restructure failed: missing block: B:21:0x007f, code lost:
            
                if (r7.setGroupLink(r2, r6) == r1) goto L22;
             */
            @Override // cb.a
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r7) {
                /*
                    r6 = this;
                    java.lang.Object r0 = r6.L$0
                    cu.todus.android.data.db.entity.toDus.Room r0 = (cu.todus.android.data.db.entity.toDus.Room) r0
                    java.lang.Object r1 = bb.b.g()
                    int r2 = r6.label
                    r3 = 2
                    r4 = 1
                    if (r2 == 0) goto L22
                    if (r2 == r4) goto L1e
                    if (r2 != r3) goto L16
                    ua.v.b(r7)
                    goto L82
                L16:
                    java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r7.<init>(r0)
                    throw r7
                L1e:
                    ua.v.b(r7)
                    goto L6f
                L22:
                    ua.v.b(r7)
                    cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.PreviewGroupViewModel r7 = r6.this$0
                    te.b0 r7 = cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.PreviewGroupViewModel.access$get_isSecret$p(r7)
                    r2 = 0
                    if (r0 == 0) goto L33
                    boolean r5 = r0.getSecret()
                    goto L34
                L33:
                    r5 = r2
                L34:
                    java.lang.Boolean r5 = cb.b.a(r5)
                    r7.setValue(r5)
                    cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.PreviewGroupViewModel r7 = r6.this$0
                    te.b0 r7 = cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.PreviewGroupViewModel.access$get_isMuted$p(r7)
                    if (r0 == 0) goto L47
                    boolean r2 = r0.isMuted()
                L47:
                    java.lang.Boolean r2 = cb.b.a(r2)
                    r7.setValue(r2)
                    cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.PreviewGroupViewModel r7 = r6.this$0
                    te.b0 r7 = cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.PreviewGroupViewModel.access$get_previewGroup$p(r7)
                    r7.setValue(r0)
                    lb.a r7 = r6.$onLoaded
                    r7.invoke()
                    cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.PreviewGroupViewModel r7 = r6.this$0
                    java.lang.String r2 = r6.$uid
                    java.lang.Object r5 = cb.l.a(r0)
                    r6.L$0 = r5
                    r6.label = r4
                    java.lang.Object r7 = r7.setAffiliation(r2, r6)
                    if (r7 != r1) goto L6f
                    goto L81
                L6f:
                    cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.PreviewGroupViewModel r7 = r6.this$0
                    java.lang.String r2 = r6.$uid
                    java.lang.Object r0 = cb.l.a(r0)
                    r6.L$0 = r0
                    r6.label = r3
                    java.lang.Object r7 = cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.PreviewGroupViewModel.access$setGroupLink(r7, r2, r6)
                    if (r7 != r1) goto L82
                L81:
                    return r1
                L82:
                    ua.k0 r7 = ua.k0.f43947a
                    return r7
                */
                throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.PreviewGroupViewModel.C12721.C02341.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12721(String str, lb.a aVar, ab.e<? super C12721> eVar) {
            super(2, eVar);
            this.$uid = str;
            this.$onLoaded = aVar;
        }

        @Override // cb.a
        public final ab.e<ua.k0> create(Object obj, ab.e<?> eVar) {
            return PreviewGroupViewModel.this.new C12721(this.$uid, this.$onLoaded, eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                ua.v.b(obj);
                te.h roomByIdFlow = PreviewGroupViewModel.this.mainRepository.getRoomByIdFlow(this.$uid);
                C02341 c02341 = new C02341(PreviewGroupViewModel.this, this.$onLoaded, this.$uid, null);
                this.label = 1;
                if (te.j.k(roomByIdFlow, c02341, this) == objG) {
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

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(pe.m0 m0Var, ab.e<? super ua.k0> eVar) {
            return ((C12721) create(m0Var, eVar)).invokeSuspend(ua.k0.f43947a);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.PreviewGroupViewModel$loadPreviewGroup$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.PreviewGroupViewModel$loadPreviewGroup$2", f = "PreviewGroupViewModel.kt", l = {142}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
    public static final class AnonymousClass2 extends cb.m implements Function2 {
        final /* synthetic */ String $uid;
        int label;

        /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.PreviewGroupViewModel$loadPreviewGroup$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
        public static final class AnonymousClass1<T> implements te.i {
            final /* synthetic */ PreviewGroupViewModel this$0;

            public AnonymousClass1(PreviewGroupViewModel previewGroupViewModel) {
                this.this$0 = previewGroupViewModel;
            }

            @Override // te.i
            public /* bridge */ /* synthetic */ Object emit(Object obj, ab.e eVar) {
                return emit((List<String>) obj, (ab.e<? super ua.k0>) eVar);
            }

            /* JADX WARN: Code duplicated, block: B:7:0x0013  */
            public final Object emit(List<String> list, ab.e<? super ua.k0> eVar) {
                PreviewGroupViewModel$loadPreviewGroup$2$1$emit$1 previewGroupViewModel$loadPreviewGroup$2$1$emit$1;
                if (eVar instanceof PreviewGroupViewModel$loadPreviewGroup$2$1$emit$1) {
                    previewGroupViewModel$loadPreviewGroup$2$1$emit$1 = (PreviewGroupViewModel$loadPreviewGroup$2$1$emit$1) eVar;
                    int i10 = previewGroupViewModel$loadPreviewGroup$2$1$emit$1.label;
                    if ((i10 & Integer.MIN_VALUE) != 0) {
                        previewGroupViewModel$loadPreviewGroup$2$1$emit$1.label = i10 - Integer.MIN_VALUE;
                    } else {
                        previewGroupViewModel$loadPreviewGroup$2$1$emit$1 = new PreviewGroupViewModel$loadPreviewGroup$2$1$emit$1(this, eVar);
                    }
                } else {
                    previewGroupViewModel$loadPreviewGroup$2$1$emit$1 = new PreviewGroupViewModel$loadPreviewGroup$2$1$emit$1(this, eVar);
                }
                Object obj = previewGroupViewModel$loadPreviewGroup$2$1$emit$1.result;
                Object objG = bb.b.g();
                int i11 = previewGroupViewModel$loadPreviewGroup$2$1$emit$1.label;
                if (i11 == 0) {
                    ua.v.b(obj);
                    this.this$0._memberCount.setValue(cb.b.d(list.size()));
                    this.this$0.getMembersInGroup().removeAll();
                    previewGroupViewModel$loadPreviewGroup$2$1$emit$1.L$0 = list;
                    previewGroupViewModel$loadPreviewGroup$2$1$emit$1.label = 1;
                    if (pe.w0.b(10L, previewGroupViewModel$loadPreviewGroup$2$1$emit$1) == objG) {
                        return objG;
                    }
                } else {
                    if (i11 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    list = (List) previewGroupViewModel$loadPreviewGroup$2$1$emit$1.L$0;
                    ua.v.b(obj);
                }
                this.this$0.getMembersInGroup().addAll(list);
                return ua.k0.f43947a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(String str, ab.e<? super AnonymousClass2> eVar) {
            super(2, eVar);
            this.$uid = str;
        }

        @Override // cb.a
        public final ab.e<ua.k0> create(Object obj, ab.e<?> eVar) {
            return PreviewGroupViewModel.this.new AnonymousClass2(this.$uid, eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                ua.v.b(obj);
                te.h hVarGroupMemberIds = PreviewGroupViewModel.this.roomsRepository.groupMemberIds(this.$uid);
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(PreviewGroupViewModel.this);
                this.label = 1;
                if (hVarGroupMemberIds.collect(anonymousClass1, this) == objG) {
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

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(pe.m0 m0Var, ab.e<? super ua.k0> eVar) {
            return ((AnonymousClass2) create(m0Var, eVar)).invokeSuspend(ua.k0.f43947a);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.PreviewGroupViewModel$promoteToGroupAdmin$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.PreviewGroupViewModel$promoteToGroupAdmin$1", f = "PreviewGroupViewModel.kt", l = {291}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C12731 extends cb.m implements Function1 {
        final /* synthetic */ String $groupId;
        final /* synthetic */ lb.a $onComplete;
        final /* synthetic */ lb.a $onError;
        final /* synthetic */ String $uid;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12731(String str, String str2, lb.a aVar, lb.a aVar2, ab.e<? super C12731> eVar) {
            super(1, eVar);
            this.$groupId = str;
            this.$uid = str2;
            this.$onError = aVar;
            this.$onComplete = aVar2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final ua.k0 invokeSuspend$lambda$0(PreviewGroupViewModel previewGroupViewModel, String str, String str2, lb.a aVar, lb.a aVar2) {
            previewGroupViewModel.promoteToGroupAdmin(str, str2, aVar, aVar2);
            return ua.k0.f43947a;
        }

        @Override // cb.a
        public final ab.e<ua.k0> create(ab.e<?> eVar) {
            return PreviewGroupViewModel.this.new C12731(this.$groupId, this.$uid, this.$onError, this.$onComplete, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super ua.k0> eVar) {
            return ((C12731) create(eVar)).invokeSuspend(ua.k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                ua.v.b(obj);
                MainRepository mainRepository = PreviewGroupViewModel.this.mainRepository;
                String str = this.$groupId;
                String str2 = this.$uid;
                this.label = 1;
                obj = mainRepository.promoteToAdmin(str, str2, this);
                if (obj == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ua.v.b(obj);
            }
            int code = ((AdminGroupActionsResponse) obj).getCode();
            if (code == 0) {
                Function1 setError = PreviewGroupViewModel.this.mainRepository.getSetError();
                String string = MainModule.INSTANCE.getInstance().getAppContext().getString(R.string.network_error);
                kotlin.jvm.internal.y.h(string, "getString(...)");
                final PreviewGroupViewModel previewGroupViewModel = PreviewGroupViewModel.this;
                final String str3 = this.$groupId;
                final String str4 = this.$uid;
                final lb.a aVar = this.$onComplete;
                final lb.a aVar2 = this.$onError;
                setError.invoke(new ToDusException(string, new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.e2
                    @Override // lb.a
                    public final Object invoke() {
                        return PreviewGroupViewModel.C12731.invokeSuspend$lambda$0(previewGroupViewModel, str3, str4, aVar, aVar2);
                    }
                }, true));
                this.$onError.invoke();
            } else if (code == 1) {
                String string2 = UUID.randomUUID().toString();
                kotlin.jvm.internal.y.h(string2, "toString(...)");
                String strO = le.a0.O(string2, "-", "", false, 4, null);
                Cause cause = Cause.ERROR;
                String string3 = MainModule.INSTANCE.getInstance().getAppContext().getString(R.string.cannot_promote_user);
                kotlin.jvm.internal.y.h(string3, "getString(...)");
                new InsideNotificationState(strO, cause, string3);
                this.$onError.invoke();
            } else if (code == 2) {
                String string4 = UUID.randomUUID().toString();
                kotlin.jvm.internal.y.h(string4, "toString(...)");
                String strO2 = le.a0.O(string4, "-", "", false, 4, null);
                Cause cause2 = Cause.CORRECT;
                String string5 = MainModule.INSTANCE.getInstance().getAppContext().getString(R.string.user_promoted);
                kotlin.jvm.internal.y.h(string5, "getString(...)");
                new InsideNotificationState(strO2, cause2, string5);
                this.$onComplete.invoke();
            }
            return ua.k0.f43947a;
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.PreviewGroupViewModel$setAffiliation$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.PreviewGroupViewModel", f = "PreviewGroupViewModel.kt", l = {AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY}, m = "setAffiliation", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C12741 extends cb.d {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C12741(ab.e<? super C12741> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PreviewGroupViewModel.this.setAffiliation(null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.PreviewGroupViewModel$setGroupLink$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.PreviewGroupViewModel", f = "PreviewGroupViewModel.kt", l = {93}, m = "setGroupLink", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C12751 extends cb.d {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C12751(ab.e<? super C12751> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PreviewGroupViewModel.this.setGroupLink(null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.PreviewGroupViewModel$updateGroup$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.PreviewGroupViewModel$updateGroup$1", f = "PreviewGroupViewModel.kt", l = {198, 208, 216, 224}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C12761 extends cb.m implements Function1 {
        final /* synthetic */ boolean $isDeleting;
        final /* synthetic */ String $newImage;
        final /* synthetic */ String $newInfo;
        final /* synthetic */ String $newName;
        final /* synthetic */ lb.a $onComplete;
        final /* synthetic */ lb.a $onError;
        final /* synthetic */ String $roomId;
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        final /* synthetic */ PreviewGroupViewModel this$0;

        /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.PreviewGroupViewModel$updateGroup$1$3, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        @cb.f(c = "cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.PreviewGroupViewModel$updateGroup$1$3", f = "PreviewGroupViewModel.kt", l = {}, m = "invokeSuspend", v = 2)
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
        public static final class AnonymousClass3 extends cb.m implements Function2 {
            final /* synthetic */ lb.a $onComplete;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass3(lb.a aVar, ab.e<? super AnonymousClass3> eVar) {
                super(2, eVar);
                this.$onComplete = aVar;
            }

            @Override // cb.a
            public final ab.e<ua.k0> create(Object obj, ab.e<?> eVar) {
                return new AnonymousClass3(this.$onComplete, eVar);
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
                return ((AnonymousClass3) create(m0Var, eVar)).invokeSuspend(ua.k0.f43947a);
            }
        }

        /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.PreviewGroupViewModel$updateGroup$1$4, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        @cb.f(c = "cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.PreviewGroupViewModel$updateGroup$1$4", f = "PreviewGroupViewModel.kt", l = {}, m = "invokeSuspend", v = 2)
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
        public static final class AnonymousClass4 extends cb.m implements Function2 {
            final /* synthetic */ lb.a $onError;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass4(lb.a aVar, ab.e<? super AnonymousClass4> eVar) {
                super(2, eVar);
                this.$onError = aVar;
            }

            @Override // cb.a
            public final ab.e<ua.k0> create(Object obj, ab.e<?> eVar) {
                return new AnonymousClass4(this.$onError, eVar);
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
                return ((AnonymousClass4) create(m0Var, eVar)).invokeSuspend(ua.k0.f43947a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12761(String str, PreviewGroupViewModel previewGroupViewModel, String str2, boolean z10, String str3, String str4, lb.a aVar, lb.a aVar2, ab.e<? super C12761> eVar) {
            super(1, eVar);
            this.$newImage = str;
            this.this$0 = previewGroupViewModel;
            this.$roomId = str2;
            this.$isDeleting = z10;
            this.$newName = str3;
            this.$newInfo = str4;
            this.$onComplete = aVar;
            this.$onError = aVar2;
        }

        @Override // cb.a
        public final ab.e<ua.k0> create(ab.e<?> eVar) {
            return new C12761(this.$newImage, this.this$0, this.$roomId, this.$isDeleting, this.$newName, this.$newInfo, this.$onComplete, this.$onError, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super ua.k0> eVar) {
            return ((C12761) create(eVar)).invokeSuspend(ua.k0.f43947a);
        }

        /* JADX WARN: Code duplicated, block: B:26:0x00a2  */
        /* JADX WARN: Code duplicated, block: B:29:0x00bd  */
        /* JADX WARN: Code duplicated, block: B:32:0x00c6  */
        /* JADX WARN: Code duplicated, block: B:33:0x00cc  */
        /* JADX WARN: Code duplicated, block: B:36:0x00d1  */
        /* JADX WARN: Code duplicated, block: B:39:0x00f3  */
        /* JADX WARN: Code duplicated, block: B:42:0x00fc  */
        /* JADX WARN: Code duplicated, block: B:43:0x0102  */
        /* JADX WARN: Code duplicated, block: B:46:0x0107  */
        /* JADX WARN: Code duplicated, block: B:49:0x0129  */
        /* JADX WARN: Code duplicated, block: B:52:0x0133  */
        /* JADX WARN: Code duplicated, block: B:56:0x0143  */
        /* JADX WARN: Code duplicated, block: B:57:0x0198  */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x008d, code lost:
        
            if (r11 == r0) goto L48;
         */
        @Override // cb.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r11) {
            /*
                Method dump skipped, instruction units count: 477
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.PreviewGroupViewModel.C12761.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public PreviewGroupViewModel() {
        Boolean bool = Boolean.FALSE;
        te.b0 b0VarA = te.r0.a(bool);
        this._isSecret = b0VarA;
        this.isSecret = te.j.b(b0VarA);
        te.b0 b0VarA2 = te.r0.a(bool);
        this._isMuted = b0VarA2;
        this.isMuted = te.j.b(b0VarA2);
        te.b0 b0VarA3 = te.r0.a(FlowsState.INSTANCE.notRequested());
        this._link = b0VarA3;
        this.link = te.j.b(b0VarA3);
        te.b0 b0VarA4 = te.r0.a("");
        this._affiliationGroup = b0VarA4;
        this.affiliationGroup = te.j.b(b0VarA4);
        te.b0 b0VarA5 = te.r0.a(null);
        this._previewGroup = b0VarA5;
        this.previewGroup = te.j.b(b0VarA5);
        te.b0 b0VarA6 = te.r0.a(0);
        this._memberCount = b0VarA6;
        this.memberCount = te.j.b(b0VarA6);
        this.membersInGroup = new Z17MutableListFlow<>(null, 1, null);
        this.contactsPagingConfig = new PagingConfig(30, 30, true, 60, Integer.MAX_VALUE, 0, 32, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PagingSource friendsOnDb$lambda$0(PreviewGroupViewModel previewGroupViewModel, String str) {
        return previewGroupViewModel.usersRepository.getFriends(le.a0.O(str, "@", "", false, 4, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PagingSource members$lambda$0(PreviewGroupViewModel previewGroupViewModel, String str) {
        return previewGroupViewModel.roomsRepository.getMembers(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object setGroupLink(String str, ab.e<? super ua.k0> eVar) {
        C12751 c12751;
        if (eVar instanceof C12751) {
            c12751 = (C12751) eVar;
            int i10 = c12751.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c12751.label = i10 - Integer.MIN_VALUE;
            } else {
                c12751 = new C12751(eVar);
            }
        } else {
            c12751 = new C12751(eVar);
        }
        Object orCreateGroupLink = c12751.result;
        Object objG = bb.b.g();
        int i11 = c12751.label;
        if (i11 == 0) {
            ua.v.b(orCreateGroupLink);
            if (kotlin.jvm.internal.y.d(this.affiliationGroup.getValue(), UserRoomJoin.AFFILIATION_OWNER)) {
                MainRepository mainRepository = this.mainRepository;
                c12751.L$0 = cb.l.a(str);
                c12751.label = 1;
                orCreateGroupLink = mainRepository.getOrCreateGroupLink(str, c12751);
                if (orCreateGroupLink == objG) {
                    return objG;
                }
            }
            return ua.k0.f43947a;
        }
        if (i11 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ua.v.b(orCreateGroupLink);
        Pair pair = (Pair) orCreateGroupLink;
        if (pair != null && ((CharSequence) pair.getSecond()).length() > 0) {
            this._link.setValue(FlowsState.INSTANCE.success("https://chat.todus.cu/" + pair.getSecond()));
        }
        return ua.k0.f43947a;
    }

    public static /* synthetic */ void updateGroup$default(PreviewGroupViewModel previewGroupViewModel, String str, String str2, String str3, String str4, boolean z10, lb.a aVar, lb.a aVar2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = null;
        }
        if ((i10 & 4) != 0) {
            str3 = null;
        }
        if ((i10 & 8) != 0) {
            str4 = null;
        }
        previewGroupViewModel.updateGroup(str, str2, str3, str4, z10, aVar, aVar2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PagingSource usersOnDb$lambda$0(PreviewGroupViewModel previewGroupViewModel, String str) {
        return previewGroupViewModel.usersRepository.getOtherUsers(le.a0.O(str, "@", "", false, 4, null));
    }

    public final void addMembers(String groupId, List<String> newMembers, lb.a onComplete) {
        kotlin.jvm.internal.y.i(groupId, "groupId");
        kotlin.jvm.internal.y.i(newMembers, "newMembers");
        kotlin.jvm.internal.y.i(onComplete, "onComplete");
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(groupId, newMembers, onComplete, null), 3, null);
    }

    public final void changeMuteValue(String roomId) {
        kotlin.jvm.internal.y.i(roomId, "roomId");
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new C12641(roomId, null), 3, null);
    }

    public final void changeSecretState(String uid) {
        kotlin.jvm.internal.y.i(uid, "uid");
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new C12651(uid, null), 3, null);
    }

    public final void clearDeleteGroup(String roomId) {
        kotlin.jvm.internal.y.i(roomId, "roomId");
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new C12661(roomId, null), 3, null);
    }

    public final void clearHistory(String roomId) {
        kotlin.jvm.internal.y.i(roomId, "roomId");
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new C12671(roomId, this, null), 3, null);
    }

    public final void createGroupLink(String roomId, lb.a onComplete) {
        kotlin.jvm.internal.y.i(roomId, "roomId");
        kotlin.jvm.internal.y.i(onComplete, "onComplete");
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new C12681(roomId, onComplete, null), 3, null);
    }

    public final void demoteFromGroupAdmin(String groupId, String uid, lb.a onComplete, lb.a onError) {
        kotlin.jvm.internal.y.i(groupId, "groupId");
        kotlin.jvm.internal.y.i(uid, "uid");
        kotlin.jvm.internal.y.i(onComplete, "onComplete");
        kotlin.jvm.internal.y.i(onError, "onError");
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new C12691(groupId, uid, onError, onComplete, null), 3, null);
    }

    public final void expelMember(String roomId, String memberId, lb.a onComplete) {
        kotlin.jvm.internal.y.i(roomId, "roomId");
        kotlin.jvm.internal.y.i(memberId, "memberId");
        kotlin.jvm.internal.y.i(onComplete, "onComplete");
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new C12701(roomId, memberId, onComplete, null), 3, null);
    }

    public final te.h friendsOnDb(final String filter) {
        kotlin.jvm.internal.y.i(filter, "filter");
        return CachedPagingDataKt.cachedIn(new Pager(this.contactsPagingConfig, null, new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.y1
            @Override // lb.a
            public final Object invoke() {
                return PreviewGroupViewModel.friendsOnDb$lambda$0(this.f25972c, filter);
            }
        }, 2, null).getFlow(), ViewModelKt.getViewModelScope(this));
    }

    public final te.p0 getAffiliationGroup() {
        return this.affiliationGroup;
    }

    public final v5.f getGson() {
        return this.gson;
    }

    public final te.p0 getLink() {
        return this.link;
    }

    public final te.p0 getMemberCount() {
        return this.memberCount;
    }

    public final Z17MutableListFlow<String> getMembersInGroup() {
        return this.membersInGroup;
    }

    public final te.p0 getPreviewGroup() {
        return this.previewGroup;
    }

    /* JADX INFO: renamed from: isMuted, reason: from getter */
    public final te.p0 getIsMuted() {
        return this.isMuted;
    }

    /* JADX INFO: renamed from: isSecret, reason: from getter */
    public final te.p0 getIsSecret() {
        return this.isSecret;
    }

    public final void leaveAndDeleteGroup(String roomId, lb.a onLeave, lb.a onComplete) {
        kotlin.jvm.internal.y.i(roomId, "roomId");
        kotlin.jvm.internal.y.i(onLeave, "onLeave");
        kotlin.jvm.internal.y.i(onComplete, "onComplete");
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new C12711(roomId, onLeave, onComplete, null), 3, null);
    }

    public final void loadPreviewGroup(String uid, lb.a onLoaded) {
        kotlin.jvm.internal.y.i(uid, "uid");
        kotlin.jvm.internal.y.i(onLoaded, "onLoaded");
        pe.k.d(ViewModelKt.getViewModelScope(this), null, null, new C12721(uid, onLoaded, null), 3, null);
        pe.k.d(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass2(uid, null), 3, null);
    }

    public final te.h members(final String roomId) {
        kotlin.jvm.internal.y.i(roomId, "roomId");
        return CachedPagingDataKt.cachedIn(new Pager(this.pagerConfigs, null, new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.z1
            @Override // lb.a
            public final Object invoke() {
                return PreviewGroupViewModel.members$lambda$0(this.f25980c, roomId);
            }
        }, 2, null).getFlow(), ViewModelKt.getViewModelScope(this));
    }

    public final Owner owner() {
        return (Owner) this.mainRepository.getOwner().invoke();
    }

    public final void promoteToGroupAdmin(String groupId, String uid, lb.a onComplete, lb.a onError) {
        kotlin.jvm.internal.y.i(groupId, "groupId");
        kotlin.jvm.internal.y.i(uid, "uid");
        kotlin.jvm.internal.y.i(onComplete, "onComplete");
        kotlin.jvm.internal.y.i(onError, "onError");
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new C12731(groupId, uid, onError, onComplete, null), 3, null);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object setAffiliation(String str, ab.e<? super ua.k0> eVar) {
        C12741 c12741;
        if (eVar instanceof C12741) {
            c12741 = (C12741) eVar;
            int i10 = c12741.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c12741.label = i10 - Integer.MIN_VALUE;
            } else {
                c12741 = new C12741(eVar);
            }
        } else {
            c12741 = new C12741(eVar);
        }
        Object affiliationOnRoom = c12741.result;
        Object objG = bb.b.g();
        int i11 = c12741.label;
        if (i11 == 0) {
            ua.v.b(affiliationOnRoom);
            RoomsRepository roomsRepository = this.roomsRepository;
            c12741.L$0 = cb.l.a(str);
            c12741.label = 1;
            affiliationOnRoom = roomsRepository.getAffiliationOnRoom(str, c12741);
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
        this._affiliationGroup.setValue(str2);
        return ua.k0.f43947a;
    }

    public final void updateGroup(String roomId, String newName, String newInfo, String newImage, boolean isDeleting, lb.a onComplete, lb.a onError) {
        kotlin.jvm.internal.y.i(roomId, "roomId");
        kotlin.jvm.internal.y.i(onComplete, "onComplete");
        kotlin.jvm.internal.y.i(onError, "onError");
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new C12761(newImage, this, roomId, isDeleting, newName, newInfo, onComplete, onError, null), 3, null);
    }

    public final te.h usersOnDb(final String filter) {
        kotlin.jvm.internal.y.i(filter, "filter");
        return CachedPagingDataKt.cachedIn(new Pager(this.contactsPagingConfig, null, new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.a2
            @Override // lb.a
            public final Object invoke() {
                return PreviewGroupViewModel.usersOnDb$lambda$0(this.f25758c, filter);
            }
        }, 2, null).getFlow(), ViewModelKt.getViewModelScope(this));
    }
}
