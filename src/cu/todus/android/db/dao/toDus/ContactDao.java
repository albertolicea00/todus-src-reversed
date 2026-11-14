package cu.todus.android.db.dao.toDus;

import androidx.paging.PagingSource;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.RewriteQueriesToDropUnusedColumns;
import cu.todus.android.constants.Service;
import cu.todus.android.data.db.entity.toDus.Contact;
import cu.todus.android.data.db.pojo.Friend;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Dao
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001J\u001e\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H§@¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H§@¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\f\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000b\u001a\u00020\nH§@¢\u0006\u0004\b\f\u0010\rJ\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H§@¢\u0006\u0004\b\u000e\u0010\tJ\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H§@¢\u0006\u0004\b\u000f\u0010\tJ\u001e\u0010\u0011\u001a\u00020\u00052\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\u0002H§@¢\u0006\u0004\b\u0011\u0010\u0007J\u0016\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H§@¢\u0006\u0004\b\u0012\u0010\tJ\u001e\u0010\u0014\u001a\u00020\u00052\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\n0\u0002H§@¢\u0006\u0004\b\u0014\u0010\u0007J\u001e\u0010\u0017\u001a\u00020\u00162\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\n0\u0002H§@¢\u0006\u0004\b\u0017\u0010\u0007J+\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u001b0\u001a2\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\nH'¢\u0006\u0004\b\u001c\u0010\u001dJ\u001a\u0010\u001f\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001e\u001a\u00020\nH§@¢\u0006\u0004\b\u001f\u0010\rJ\u001e\u0010 \u001a\b\u0012\u0004\u0012\u00020\n0\u00022\u0006\u0010\u0019\u001a\u00020\nH§@¢\u0006\u0004\b \u0010\r¨\u0006!À\u0006\u0003"}, d2 = {"Lcu/todus/android/db/dao/toDus/ContactDao;", "", "", "Lcu/todus/android/data/db/entity/toDus/Contact;", "contacts", "Lua/k0;", "insert", "(Ljava/util/List;Lab/e;)Ljava/lang/Object;", "getAll", "(Lab/e;)Ljava/lang/Object;", "", "phone", "getByPhone", "(Ljava/lang/String;Lab/e;)Ljava/lang/Object;", "getAllUploaded", "getAllWaiting", "contactPhones", "updatedToUploaded", "getContactsNotInUser", "phones", "deleteByPhones", Service.Endpoint.LINKED_DEVICES_LIST, "", "getIn", "filter", "ownerId", "Landroidx/paging/PagingSource;", "Lcu/todus/android/data/db/pojo/Friend;", "getFriends", "(Ljava/lang/String;Ljava/lang/String;)Landroidx/paging/PagingSource;", "friendId", "getFriendById", "getFriendsIds", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
@RewriteQueriesToDropUnusedColumns
public interface ContactDao {
    @Query("DELETE FROM contact WHERE phone IN (:phones)")
    Object deleteByPhones(List<String> list, ab.e<? super ua.k0> eVar);

    @Query("SELECT * FROM contact")
    Object getAll(ab.e<? super List<Contact>> eVar);

    @Query("SELECT * FROM contact WHERE state = 'uploaded'")
    Object getAllUploaded(ab.e<? super List<Contact>> eVar);

    @Query("SELECT * FROM contact WHERE state = 'waiting'")
    Object getAllWaiting(ab.e<? super List<Contact>> eVar);

    @Query("SELECT * FROM contact WHERE phone = :phone LIMIT 1")
    Object getByPhone(String str, ab.e<? super Contact> eVar);

    @Query("\n        SELECT * FROM contact \n        WHERE NOT EXISTS (\n            SELECT 1 FROM user \n            WHERE user.username = contact.phone\n        )\n    ")
    Object getContactsNotInUser(ab.e<? super List<Contact>> eVar);

    @Query("SELECT * FROM contact WHERE uid = :friendId LIMIT 1")
    Object getFriendById(String str, ab.e<? super Friend> eVar);

    @Query("\n        SELECT c.* FROM contact as c \n        JOIN user as u ON c.uid = u.uid \n        WHERE c.uid != :ownerId \n        AND u.uid IS NOT NULL \n        AND (c.fName LIKE '%' || :filter || '%' OR c.phone LIKE '%' || :filter || '%') \n        ORDER BY c.fName COLLATE NOCASE ASC\n    ")
    PagingSource<Integer, Friend> getFriends(String filter, String ownerId);

    @Query("SELECT c.uid FROM contact c, user u WHERE u.uid == c.uid AND u.uid != :ownerId")
    Object getFriendsIds(String str, ab.e<? super List<String>> eVar);

    @Query("SELECT COUNT(*) FROM contact WHERE phone IN (:list)")
    Object getIn(List<String> list, ab.e<? super Integer> eVar);

    @Insert(onConflict = 1)
    Object insert(List<Contact> list, ab.e<? super ua.k0> eVar);

    @Query("UPDATE contact SET state = 'uploaded' WHERE phone IN (:contactPhones)")
    Object updatedToUploaded(List<String> list, ab.e<? super ua.k0> eVar);
}
