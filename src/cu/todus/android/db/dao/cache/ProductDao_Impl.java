package cu.todus.android.db.dao.cache;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.paging.PagingSource;
import androidx.room.EntityDeleteOrUpdateAdapter;
import androidx.room.EntityInsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomRawQuery;
import androidx.room.paging.LimitOffsetPagingSource;
import androidx.room.util.DBUtil;
import androidx.room.util.SQLiteStatementUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import cu.todus.android.data.db.entity.cache.Product;
import cu.todus.android.data.db.entity.toDus.User;
import cu.todus.android.db.typeconverter.ToDusTypeConverter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import org.jivesoftware.smackx.disco.packet.DiscoverItems;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 -2\u00020\u0001:\u0001-B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0096@¢\u0006\u0004\b\t\u0010\nJ\u001e\u0010\t\u001a\u00020\r2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u000bH\u0096@¢\u0006\u0004\b\t\u0010\u000eJ\u0018\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u0006H\u0096@¢\u0006\u0004\b\u000f\u0010\nJ+\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00060\u00132\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0018\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0014H\u0096@¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0014H\u0096@¢\u0006\u0004\b\u001a\u0010\u001bJ \u0010\u001f\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u0014H\u0096@¢\u0006\u0004\b\u001f\u0010 J\u0018\u0010!\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u0014H\u0096@¢\u0006\u0004\b!\u0010\u0019J\u0010\u0010\"\u001a\u00020\rH\u0096@¢\u0006\u0004\b\"\u0010\u001bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010#R\u001a\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00060$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010(\u001a\u00020'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u001a\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00060*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,¨\u0006."}, d2 = {"Lcu/todus/android/db/dao/cache/ProductDao_Impl;", "Lcu/todus/android/db/dao/cache/ProductDao;", "Landroidx/room/RoomDatabase;", "__db", "<init>", "(Landroidx/room/RoomDatabase;)V", "Lcu/todus/android/data/db/entity/cache/Product;", "obj", "", "insert", "(Lcu/todus/android/data/db/entity/cache/Product;Lab/e;)Ljava/lang/Object;", "", "objs", "Lua/k0;", "(Ljava/util/List;Lab/e;)Ljava/lang/Object;", DiscoverItems.Item.UPDATE_ACTION, "", "tag", "filter", "Landroidx/paging/PagingSource;", "", "getMyProductsPagingFiltered", "(Ljava/lang/String;Ljava/lang/String;)Landroidx/paging/PagingSource;", "id", "getProductById", "(ILab/e;)Ljava/lang/Object;", "getPublicCant", "(Lab/e;)Ljava/lang/Object;", "", "visibility", "productId", "setProductVisibility", "(ZILab/e;)Ljava/lang/Object;", "deleteById", "deleteAll", "Landroidx/room/RoomDatabase;", "Landroidx/room/EntityInsertAdapter;", "__insertAdapterOfProduct", "Landroidx/room/EntityInsertAdapter;", "Lcu/todus/android/db/typeconverter/ToDusTypeConverter;", "__toDusTypeConverter", "Lcu/todus/android/db/typeconverter/ToDusTypeConverter;", "Landroidx/room/EntityDeleteOrUpdateAdapter;", "__updateAdapterOfProduct", "Landroidx/room/EntityDeleteOrUpdateAdapter;", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ProductDao_Impl implements ProductDao {
    private final RoomDatabase __db;
    private final EntityInsertAdapter<Product> __insertAdapterOfProduct;
    private final ToDusTypeConverter __toDusTypeConverter;
    private final EntityDeleteOrUpdateAdapter<Product> __updateAdapterOfProduct;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0006\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcu/todus/android/db/dao/cache/ProductDao_Impl$Companion;", "", "<init>", "()V", "", "Lsb/d;", "getRequiredConverters", "()Ljava/util/List;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.p pVar) {
            this();
        }

        public final List<sb.d> getRequiredConverters() {
            return va.w.n();
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.db.dao.cache.ProductDao_Impl$getMyProductsPagingFiltered$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J&\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0094@¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"cu/todus/android/db/dao/cache/ProductDao_Impl$getMyProductsPagingFiltered$1", "Landroidx/room/paging/LimitOffsetPagingSource;", "Lcu/todus/android/data/db/entity/cache/Product;", "Landroidx/room/RoomRawQuery;", "limitOffsetQuery", "", "itemCount", "", "convertRows", "(Landroidx/room/RoomRawQuery;ILab/e;)Ljava/lang/Object;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class C09581 extends LimitOffsetPagingSource<Product> {
        final /* synthetic */ ProductDao_Impl this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C09581(RoomRawQuery roomRawQuery, ProductDao_Impl productDao_Impl, RoomDatabase roomDatabase, String[] strArr) {
            super(roomRawQuery, roomDatabase, strArr);
            this.this$0 = productDao_Impl;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final List convertRows$lambda$0(RoomRawQuery roomRawQuery, ProductDao_Impl productDao_Impl, SQLiteConnection _connection) {
            kotlin.jvm.internal.y.i(_connection, "_connection");
            SQLiteStatement sQLiteStatementPrepare = _connection.prepare(roomRawQuery.getSql());
            roomRawQuery.getBindingFunction().invoke(sQLiteStatementPrepare);
            try {
                int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "id");
                int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "createdAt");
                int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "description");
                int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "name");
                int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, User.COLUMN_PHOTO_URL);
                int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "price");
                int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "isPublic");
                int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "info");
                int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "offset");
                ArrayList arrayList = new ArrayList();
                while (sQLiteStatementPrepare.step()) {
                    int i10 = (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow);
                    String text = sQLiteStatementPrepare.getText(columnIndexOrThrow2);
                    String text2 = sQLiteStatementPrepare.getText(columnIndexOrThrow3);
                    String text3 = sQLiteStatementPrepare.getText(columnIndexOrThrow4);
                    String text4 = sQLiteStatementPrepare.getText(columnIndexOrThrow5);
                    double d10 = sQLiteStatementPrepare.getDouble(columnIndexOrThrow6);
                    boolean z10 = ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow7)) != 0;
                    String text5 = sQLiteStatementPrepare.isNull(columnIndexOrThrow8) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow8);
                    arrayList.add(new Product(i10, text, text2, text3, text4, d10, z10, text5 != null ? productDao_Impl.__toDusTypeConverter.toConfiguration(text5) : null, (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow9)));
                }
                return arrayList;
            } finally {
                sQLiteStatementPrepare.close();
            }
        }

        @Override // androidx.room.paging.LimitOffsetPagingSource
        public Object convertRows(final RoomRawQuery roomRawQuery, int i10, ab.e<? super List<? extends Product>> eVar) {
            RoomDatabase roomDatabase = this.this$0.__db;
            final ProductDao_Impl productDao_Impl = this.this$0;
            return DBUtil.performSuspending(roomDatabase, true, false, new Function1() { // from class: cu.todus.android.db.dao.cache.u
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return ProductDao_Impl.C09581.convertRows$lambda$0(roomRawQuery, productDao_Impl, (SQLiteConnection) obj);
                }
            }, eVar);
        }
    }

    public ProductDao_Impl(RoomDatabase __db) {
        kotlin.jvm.internal.y.i(__db, "__db");
        this.__toDusTypeConverter = new ToDusTypeConverter();
        this.__db = __db;
        this.__insertAdapterOfProduct = new EntityInsertAdapter<Product>() { // from class: cu.todus.android.db.dao.cache.ProductDao_Impl.1
            @Override // androidx.room.EntityInsertAdapter
            public String createQuery() {
                return "INSERT OR REPLACE INTO `product` (`id`,`createdAt`,`description`,`name`,`pictureUrl`,`price`,`isPublic`,`info`,`offset`) VALUES (?,?,?,?,?,?,?,?,?)";
            }

            @Override // androidx.room.EntityInsertAdapter
            public void bind(SQLiteStatement statement, Product entity) {
                kotlin.jvm.internal.y.i(statement, "statement");
                kotlin.jvm.internal.y.i(entity, "entity");
                statement.mo9385bindLong(1, entity.getId());
                statement.mo9387bindText(2, entity.getCreatedAt());
                statement.mo9387bindText(3, entity.getDescription());
                statement.mo9387bindText(4, entity.getName());
                statement.mo9387bindText(5, entity.getPictureUrl());
                statement.mo9384bindDouble(6, entity.getPrice());
                statement.mo9385bindLong(7, entity.isPublic() ? 1L : 0L);
                Map<String, String> info = entity.getInfo();
                String strFromConfiguration = info == null ? null : ProductDao_Impl.this.__toDusTypeConverter.fromConfiguration(info);
                if (strFromConfiguration == null) {
                    statement.mo9386bindNull(8);
                } else {
                    statement.mo9387bindText(8, strFromConfiguration);
                }
                statement.mo9385bindLong(9, entity.getOffset());
            }
        };
        this.__updateAdapterOfProduct = new EntityDeleteOrUpdateAdapter<Product>() { // from class: cu.todus.android.db.dao.cache.ProductDao_Impl.2
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            public String createQuery() {
                return "UPDATE OR ABORT `product` SET `id` = ?,`createdAt` = ?,`description` = ?,`name` = ?,`pictureUrl` = ?,`price` = ?,`isPublic` = ?,`info` = ?,`offset` = ? WHERE `id` = ?";
            }

            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            public void bind(SQLiteStatement statement, Product entity) {
                kotlin.jvm.internal.y.i(statement, "statement");
                kotlin.jvm.internal.y.i(entity, "entity");
                statement.mo9385bindLong(1, entity.getId());
                statement.mo9387bindText(2, entity.getCreatedAt());
                statement.mo9387bindText(3, entity.getDescription());
                statement.mo9387bindText(4, entity.getName());
                statement.mo9387bindText(5, entity.getPictureUrl());
                statement.mo9384bindDouble(6, entity.getPrice());
                statement.mo9385bindLong(7, entity.isPublic() ? 1L : 0L);
                Map<String, String> info = entity.getInfo();
                String strFromConfiguration = info == null ? null : ProductDao_Impl.this.__toDusTypeConverter.fromConfiguration(info);
                if (strFromConfiguration == null) {
                    statement.mo9386bindNull(8);
                } else {
                    statement.mo9387bindText(8, strFromConfiguration);
                }
                statement.mo9385bindLong(9, entity.getOffset());
                statement.mo9385bindLong(10, entity.getId());
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 deleteAll$lambda$0(String str, SQLiteConnection _connection) {
        kotlin.jvm.internal.y.i(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            sQLiteStatementPrepare.step();
            return k0.f43947a;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 deleteById$lambda$0(String str, int i10, SQLiteConnection _connection) {
        kotlin.jvm.internal.y.i(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            sQLiteStatementPrepare.mo9385bindLong(1, i10);
            sQLiteStatementPrepare.step();
            return k0.f43947a;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 getMyProductsPagingFiltered$lambda$0(String str, String str2, SQLiteStatement _stmt) {
        kotlin.jvm.internal.y.i(_stmt, "_stmt");
        _stmt.mo9387bindText(1, str);
        _stmt.mo9387bindText(2, str);
        _stmt.mo9387bindText(3, str2);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Product getProductById$lambda$0(String str, int i10, ProductDao_Impl productDao_Impl, SQLiteConnection _connection) {
        kotlin.jvm.internal.y.i(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            sQLiteStatementPrepare.mo9385bindLong(1, i10);
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "id");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "createdAt");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "description");
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "name");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, User.COLUMN_PHOTO_URL);
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "price");
            int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "isPublic");
            int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "info");
            int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "offset");
            if (!sQLiteStatementPrepare.step()) {
                throw new IllegalStateException("The query result was empty, but expected a single row to return a NON-NULL object of type 'cu.todus.android.`data`.db.entity.cache.Product'.");
            }
            int i11 = (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow);
            String text = sQLiteStatementPrepare.getText(columnIndexOrThrow2);
            String text2 = sQLiteStatementPrepare.getText(columnIndexOrThrow3);
            String text3 = sQLiteStatementPrepare.getText(columnIndexOrThrow4);
            String text4 = sQLiteStatementPrepare.getText(columnIndexOrThrow5);
            double d10 = sQLiteStatementPrepare.getDouble(columnIndexOrThrow6);
            boolean z10 = ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow7)) != 0;
            String text5 = sQLiteStatementPrepare.isNull(columnIndexOrThrow8) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow8);
            Product product = new Product(i11, text, text2, text3, text4, d10, z10, text5 != null ? productDao_Impl.__toDusTypeConverter.toConfiguration(text5) : null, (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow9));
            sQLiteStatementPrepare.close();
            return product;
        } catch (Throwable th2) {
            sQLiteStatementPrepare.close();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int getPublicCant$lambda$0(String str, SQLiteConnection _connection) {
        kotlin.jvm.internal.y.i(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            return sQLiteStatementPrepare.step() ? (int) sQLiteStatementPrepare.getLong(0) : 0;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long insert$lambda$0(ProductDao_Impl productDao_Impl, Product product, SQLiteConnection _connection) {
        kotlin.jvm.internal.y.i(_connection, "_connection");
        return productDao_Impl.__insertAdapterOfProduct.insertAndReturnId(_connection, product);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 insert$lambda$1(ProductDao_Impl productDao_Impl, List list, SQLiteConnection _connection) throws Exception {
        kotlin.jvm.internal.y.i(_connection, "_connection");
        productDao_Impl.__insertAdapterOfProduct.insert(_connection, list);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 setProductVisibility$lambda$0(String str, boolean z10, int i10, SQLiteConnection _connection) {
        kotlin.jvm.internal.y.i(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            sQLiteStatementPrepare.mo9385bindLong(1, z10 ? 1L : 0L);
            sQLiteStatementPrepare.mo9385bindLong(2, i10);
            sQLiteStatementPrepare.step();
            return k0.f43947a;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 update$lambda$0(ProductDao_Impl productDao_Impl, Product product, SQLiteConnection _connection) throws Exception {
        kotlin.jvm.internal.y.i(_connection, "_connection");
        productDao_Impl.__updateAdapterOfProduct.handle(_connection, product);
        return k0.f43947a;
    }

    @Override // cu.todus.android.db.dao.cache.ProductDao
    public Object deleteAll(ab.e<? super k0> eVar) {
        final String str = "DELETE FROM product";
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: cu.todus.android.db.dao.cache.p
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ProductDao_Impl.deleteAll$lambda$0(str, (SQLiteConnection) obj);
            }
        }, eVar);
        return objPerformSuspending == bb.b.g() ? objPerformSuspending : k0.f43947a;
    }

    @Override // cu.todus.android.db.dao.cache.ProductDao
    public Object deleteById(final int i10, ab.e<? super k0> eVar) {
        final String str = "DELETE FROM product WHERE id = ?";
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: cu.todus.android.db.dao.cache.t
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ProductDao_Impl.deleteById$lambda$0(str, i10, (SQLiteConnection) obj);
            }
        }, eVar);
        return objPerformSuspending == bb.b.g() ? objPerformSuspending : k0.f43947a;
    }

    @Override // cu.todus.android.db.dao.cache.ProductDao
    public PagingSource<Integer, Product> getMyProductsPagingFiltered(final String tag, final String filter) {
        kotlin.jvm.internal.y.i(tag, "tag");
        kotlin.jvm.internal.y.i(filter, "filter");
        return new C09581(new RoomRawQuery("SELECT * FROM product WHERE (name LIKE '%'||?||'%' OR description LIKE '%'||?||'%') OR (info is not null AND info LIKE '%'||?||'%')", new Function1() { // from class: cu.todus.android.db.dao.cache.l
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ProductDao_Impl.getMyProductsPagingFiltered$lambda$0(filter, tag, (SQLiteStatement) obj);
            }
        }), this, this.__db, new String[]{"product"});
    }

    @Override // cu.todus.android.db.dao.cache.ProductDao
    public Object getProductById(final int i10, ab.e<? super Product> eVar) {
        final String str = "SELECT * FROM product WHERE id = ?";
        return DBUtil.performSuspending(this.__db, true, false, new Function1() { // from class: cu.todus.android.db.dao.cache.o
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ProductDao_Impl.getProductById$lambda$0(str, i10, this, (SQLiteConnection) obj);
            }
        }, eVar);
    }

    @Override // cu.todus.android.db.dao.cache.ProductDao
    public Object getPublicCant(ab.e<? super Integer> eVar) {
        final String str = "SELECT COUNT(*) FROM product WHERE isPublic = 1";
        return DBUtil.performSuspending(this.__db, true, false, new Function1() { // from class: cu.todus.android.db.dao.cache.r
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Integer.valueOf(ProductDao_Impl.getPublicCant$lambda$0(str, (SQLiteConnection) obj));
            }
        }, eVar);
    }

    @Override // cu.todus.android.db.dao.cache.ProductDao
    public Object insert(final Product product, ab.e<? super Long> eVar) {
        return DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: cu.todus.android.db.dao.cache.m
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Long.valueOf(ProductDao_Impl.insert$lambda$0(this.f20262c, product, (SQLiteConnection) obj));
            }
        }, eVar);
    }

    @Override // cu.todus.android.db.dao.cache.ProductDao
    public Object setProductVisibility(final boolean z10, final int i10, ab.e<? super k0> eVar) {
        final String str = "UPDATE product SET isPublic = ? WHERE id = ?";
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: cu.todus.android.db.dao.cache.q
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ProductDao_Impl.setProductVisibility$lambda$0(str, z10, i10, (SQLiteConnection) obj);
            }
        }, eVar);
        return objPerformSuspending == bb.b.g() ? objPerformSuspending : k0.f43947a;
    }

    @Override // cu.todus.android.db.dao.cache.ProductDao
    public Object update(final Product product, ab.e<? super k0> eVar) {
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: cu.todus.android.db.dao.cache.n
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ProductDao_Impl.update$lambda$0(this.f20264c, product, (SQLiteConnection) obj);
            }
        }, eVar);
        return objPerformSuspending == bb.b.g() ? objPerformSuspending : k0.f43947a;
    }

    @Override // cu.todus.android.db.dao.cache.ProductDao
    public Object insert(final List<Product> list, ab.e<? super k0> eVar) {
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: cu.todus.android.db.dao.cache.s
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ProductDao_Impl.insert$lambda$1(this.f20274c, list, (SQLiteConnection) obj);
            }
        }, eVar);
        return objPerformSuspending == bb.b.g() ? objPerformSuspending : k0.f43947a;
    }
}
