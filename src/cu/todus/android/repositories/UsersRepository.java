package cu.todus.android.repositories;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.paging.PagingSource;
import cu.todus.android.data.db.entity.toDus.UserRoomJoin;
import cu.todus.android.data.db.pojo.Friend;
import cu.todus.android.data.db.pojo.Partner;
import cu.todus.android.data.preferences.Owner;
import cu.todus.android.db.dao.toDus.ContactDao;
import cu.todus.android.db.dao.toDus.UserDao;
import cu.todus.android.di.DatabaseModule;
import cu.z17.singledi.SingletonInitializer;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 1)
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t2\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\rJ!\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000e0\t2\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u000f\u0010\rJ\u0019\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000e0\t¢\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000e0\t2\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0012\u0010\rR\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0017\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001a\u001a\u00020\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006\u001d"}, d2 = {"Lcu/todus/android/repositories/UsersRepository;", "", "Lkotlin/Function0;", "Lcu/todus/android/data/preferences/Owner;", UserRoomJoin.AFFILIATION_OWNER, "<init>", "(Llb/a;)V", "", "filter", "Landroidx/paging/PagingSource;", "", "Lcu/todus/android/data/db/pojo/Friend;", "getFriends", "(Ljava/lang/String;)Landroidx/paging/PagingSource;", "Lcu/todus/android/data/db/pojo/Partner;", "getOtherUsers", "getBlocked", "()Landroidx/paging/PagingSource;", "getAllPartners", "Llb/a;", "getOwner", "()Llb/a;", "Lcu/todus/android/db/dao/toDus/UserDao;", "userDao", "Lcu/todus/android/db/dao/toDus/UserDao;", "Lcu/todus/android/db/dao/toDus/ContactDao;", "contactDao", "Lcu/todus/android/db/dao/toDus/ContactDao;", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class UsersRepository {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final ContactDao contactDao;
    private final lb.a owner;
    private final UserDao userDao;

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcu/todus/android/repositories/UsersRepository$Companion;", "Lcu/z17/singledi/SingletonInitializer;", "Lcu/todus/android/repositories/UsersRepository;", "<init>", "()V", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion extends SingletonInitializer<UsersRepository> {
        public /* synthetic */ Companion(kotlin.jvm.internal.p pVar) {
            this();
        }

        private Companion() {
        }
    }

    public UsersRepository(lb.a owner) {
        kotlin.jvm.internal.y.i(owner, "owner");
        this.owner = owner;
        DatabaseModule.Companion companion = DatabaseModule.INSTANCE;
        this.userDao = companion.getInstance().getUserDao();
        this.contactDao = companion.getInstance().getContactDao();
    }

    public final PagingSource<Integer, Partner> getAllPartners(String filter) {
        kotlin.jvm.internal.y.i(filter, "filter");
        return this.userDao.getAllPartners(filter, ((Owner) this.owner.invoke()).getNameWithDomain());
    }

    public final PagingSource<Integer, Partner> getBlocked() {
        return this.userDao.getBlockedPartners();
    }

    public final PagingSource<Integer, Friend> getFriends(String filter) {
        kotlin.jvm.internal.y.i(filter, "filter");
        return this.contactDao.getFriends(filter, ((Owner) this.owner.invoke()).getNameWithDomain());
    }

    public final PagingSource<Integer, Partner> getOtherUsers(String filter) {
        kotlin.jvm.internal.y.i(filter, "filter");
        return this.userDao.getOtherUsers(filter, ((Owner) this.owner.invoke()).getNameWithDomain());
    }

    public final lb.a getOwner() {
        return this.owner;
    }
}
