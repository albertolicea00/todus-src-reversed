package cu.todus.android.uiCompose.main.screen.createGroup;

import android.net.Uri;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.p001lifecycle.ViewModelKt;
import androidx.paging.CachedPagingDataKt;
import androidx.paging.Pager;
import androidx.paging.PagingConfig;
import androidx.paging.PagingSource;
import cu.todus.android.R;
import cu.todus.android.data.db.entity.toDus.User;
import cu.todus.android.data.db.entity.toDus.UserRoomJoin;
import cu.todus.android.data.db.pojo.Friend;
import cu.todus.android.data.preferences.Owner;
import cu.todus.android.di.MainModule;
import cu.todus.android.exceptions.ToDusException;
import cu.todus.android.repositories.MainRepository;
import cu.todus.android.repositories.UsersRepository;
import cu.todus.android.uiCompose.shared.insideNotification.Cause;
import cu.todus.android.uiCompose.shared.insideNotification.InsideNotificationState;
import cu.todus.android.utils.CoroutineUtilsKt;
import cu.todus.android.viewModel.ToDusViewModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import pe.d1;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t2\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\u0007H\u0086@¢\u0006\u0004\b\u000f\u0010\u0010JI\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u0011\u001a\u00020\u00072\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\r\u0010\u001c\u001a\u00020\u0017¢\u0006\u0004\b\u001c\u0010\u0003R\u0014\u0010\u001e\u001a\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010!\u001a\u00020 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0017\u0010$\u001a\u00020#8\u0006¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u0014\u0010)\u001a\u00020(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*¨\u0006+"}, d2 = {"Lcu/todus/android/uiCompose/main/screen/createGroup/CreateGroupViewModel;", "Lcu/todus/android/viewModel/ToDusViewModel;", "<init>", "()V", "Lcu/todus/android/data/preferences/Owner;", UserRoomJoin.AFFILIATION_OWNER, "()Lcu/todus/android/data/preferences/Owner;", "", "filter", "Lte/h;", "Landroidx/paging/PagingData;", "Lcu/todus/android/data/db/pojo/Friend;", "friendsOnDbNoHeaders", "(Ljava/lang/String;)Lte/h;", "friendId", "getFriendById", "(Ljava/lang/String;Lab/e;)Ljava/lang/Object;", "groupName", "", "members", "Landroid/net/Uri;", "imageUri", "Lkotlin/Function0;", "Lua/k0;", "onComplete", "onError", "createGroup", "(Ljava/lang/String;Ljava/util/List;Landroid/net/Uri;Llb/a;Llb/a;)V", "updateContactList", "Lcu/todus/android/repositories/MainRepository;", "mainRepository", "Lcu/todus/android/repositories/MainRepository;", "Lcu/todus/android/repositories/UsersRepository;", "usersRepository", "Lcu/todus/android/repositories/UsersRepository;", "Lv5/f;", "gson", "Lv5/f;", "getGson", "()Lv5/f;", "Landroidx/paging/PagingConfig;", "pagerConfigs", "Landroidx/paging/PagingConfig;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class CreateGroupViewModel extends ToDusViewModel {
    public static final int $stable = 8;
    private final MainRepository mainRepository = MainRepository.INSTANCE.getInstance();
    private final UsersRepository usersRepository = UsersRepository.INSTANCE.getInstance();
    private final v5.f gson = MainModule.INSTANCE.getInstance().getGson();
    private final PagingConfig pagerConfigs = new PagingConfig(30, 30, true, 60, Integer.MAX_VALUE, 0, 32, null);

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.createGroup.CreateGroupViewModel$createGroup$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.createGroup.CreateGroupViewModel$createGroup$1", f = "CreateGroupViewModel.kt", l = {ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class AnonymousClass1 extends cb.m implements Function1 {
        final /* synthetic */ String $groupName;
        final /* synthetic */ Uri $imageUri;
        final /* synthetic */ List<Friend> $members;
        final /* synthetic */ lb.a $onComplete;
        final /* synthetic */ lb.a $onError;
        int label;

        /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.createGroup.CreateGroupViewModel$createGroup$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        @cb.f(c = "cu.todus.android.uiCompose.main.screen.createGroup.CreateGroupViewModel$createGroup$1$1", f = "CreateGroupViewModel.kt", l = {}, m = "invokeSuspend", v = 2)
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
        public static final class C02381 extends cb.m implements Function2 {
            final /* synthetic */ lb.a $onComplete;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C02381(lb.a aVar, ab.e<? super C02381> eVar) {
                super(2, eVar);
                this.$onComplete = aVar;
            }

            @Override // cb.a
            public final ab.e<ua.k0> create(Object obj, ab.e<?> eVar) {
                return new C02381(this.$onComplete, eVar);
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
                return ((C02381) create(m0Var, eVar)).invokeSuspend(ua.k0.f43947a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str, List<Friend> list, Uri uri, lb.a aVar, lb.a aVar2, ab.e<? super AnonymousClass1> eVar) {
            super(1, eVar);
            this.$groupName = str;
            this.$members = list;
            this.$imageUri = uri;
            this.$onError = aVar;
            this.$onComplete = aVar2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final ua.k0 invokeSuspend$lambda$2(CreateGroupViewModel createGroupViewModel, String str, List list, Uri uri, lb.a aVar, lb.a aVar2) {
            createGroupViewModel.createGroup(str, list, uri, aVar, aVar2);
            return ua.k0.f43947a;
        }

        @Override // cb.a
        public final ab.e<ua.k0> create(ab.e<?> eVar) {
            return CreateGroupViewModel.this.new AnonymousClass1(this.$groupName, this.$members, this.$imageUri, this.$onError, this.$onComplete, eVar);
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
                MainRepository mainRepository = CreateGroupViewModel.this.mainRepository;
                String str = this.$groupName;
                List<Friend> list = this.$members;
                ArrayList<User> arrayList = new ArrayList(va.x.y(list, 10));
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(((Friend) it.next()).getUser());
                }
                ArrayList arrayList2 = new ArrayList();
                for (User user : arrayList) {
                    if (user != null) {
                        arrayList2.add(user);
                    }
                }
                Uri uri = this.$imageUri;
                this.label = 1;
                obj = mainRepository.createGroup(str, arrayList2, uri, this);
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
                pe.k.d(ViewModelKt.getViewModelScope(CreateGroupViewModel.this), d1.c(), null, new C02381(this.$onComplete, null), 2, null);
                MainRepository mainRepository2 = CreateGroupViewModel.this.mainRepository;
                String string = UUID.randomUUID().toString();
                kotlin.jvm.internal.y.h(string, "toString(...)");
                String strO = le.a0.O(string, "-", "", false, 4, null);
                Cause cause = Cause.CONGRATS;
                String string2 = MainModule.INSTANCE.getInstance().getAppContext().getString(R.string.you_group_has_been_created);
                kotlin.jvm.internal.y.h(string2, "getString(...)");
                mainRepository2.addNewNotification(new InsideNotificationState(strO, cause, string2));
            } else {
                Function1 setError = CreateGroupViewModel.this.mainRepository.getSetError();
                String string3 = MainModule.INSTANCE.getInstance().getAppContext().getString(R.string.group_has_not_been_created);
                kotlin.jvm.internal.y.h(string3, "getString(...)");
                final CreateGroupViewModel createGroupViewModel = CreateGroupViewModel.this;
                final String str2 = this.$groupName;
                final List<Friend> list2 = this.$members;
                final Uri uri2 = this.$imageUri;
                final lb.a aVar = this.$onComplete;
                final lb.a aVar2 = this.$onError;
                setError.invoke(new ToDusException(string3, new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.createGroup.c1
                    @Override // lb.a
                    public final Object invoke() {
                        return CreateGroupViewModel.AnonymousClass1.invokeSuspend$lambda$2(createGroupViewModel, str2, list2, uri2, aVar, aVar2);
                    }
                }, true));
                this.$onError.invoke();
            }
            return ua.k0.f43947a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PagingSource friendsOnDbNoHeaders$lambda$0(CreateGroupViewModel createGroupViewModel, String str) {
        return createGroupViewModel.usersRepository.getFriends(str);
    }

    public final void createGroup(String groupName, List<Friend> members, Uri imageUri, lb.a onComplete, lb.a onError) {
        kotlin.jvm.internal.y.i(groupName, "groupName");
        kotlin.jvm.internal.y.i(members, "members");
        kotlin.jvm.internal.y.i(onComplete, "onComplete");
        kotlin.jvm.internal.y.i(onError, "onError");
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(groupName, members, imageUri, onError, onComplete, null), 3, null);
    }

    public final te.h friendsOnDbNoHeaders(final String filter) {
        kotlin.jvm.internal.y.i(filter, "filter");
        return CachedPagingDataKt.cachedIn(new Pager(this.pagerConfigs, null, new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.createGroup.b1
            @Override // lb.a
            public final Object invoke() {
                return CreateGroupViewModel.friendsOnDbNoHeaders$lambda$0(this.f26146c, filter);
            }
        }, 2, null).getFlow(), ViewModelKt.getViewModelScope(this));
    }

    public final Object getFriendById(String str, ab.e<? super Friend> eVar) {
        return this.mainRepository.getFriendById(str, eVar);
    }

    public final v5.f getGson() {
        return this.gson;
    }

    public final Owner owner() {
        return (Owner) this.mainRepository.getOwner().invoke();
    }

    public final void updateContactList() {
        MainRepository.initRosterLoad$default(this.mainRepository, false, 1, null);
    }
}
