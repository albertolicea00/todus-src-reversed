package cu.todus.android.repositories;

import androidx.compose.runtime.internal.StabilityInferred;
import cu.todus.android.data.db.entity.cache.BotShortcut;
import cu.todus.android.db.dao.cache.BotShortcutDao;
import cu.todus.android.di.DatabaseModule;
import cu.todus.android.utils.CoroutineUtilsKt;
import cu.z17.singledi.SingletonInitializer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import pe.d1;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0086@¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0086@¢\u0006\u0004\b\u000b\u0010\fJ\u0013\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u0013\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\r¢\u0006\u0004\b\u0010\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R$\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0014j\b\u0012\u0004\u0012\u00020\u0004`\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R$\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0014j\b\u0012\u0004\u0012\u00020\u0004`\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcu/todus/android/repositories/BotShortcutRepository;", "", "<init>", "()V", "Lcu/todus/android/data/db/entity/cache/BotShortcut;", "obj", "Lua/k0;", "insertBotShortCut", "(Lcu/todus/android/data/db/entity/cache/BotShortcut;Lab/e;)Ljava/lang/Object;", "", "botShortcutId", "deleteBotShortcutById", "(Ljava/lang/String;Lab/e;)Ljava/lang/Object;", "", "getHomeShortcuts", "()Ljava/util/List;", "getAttachmentShortcuts", "Lcu/todus/android/db/dao/cache/BotShortcutDao;", "botShortcutDao", "Lcu/todus/android/db/dao/cache/BotShortcutDao;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "homeShortcuts", "Ljava/util/ArrayList;", "attachmentShortcuts", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class BotShortcutRepository {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private final BotShortcutDao botShortcutDao = DatabaseModule.INSTANCE.getInstance().getBotShortcutDao();
    private final ArrayList<BotShortcut> homeShortcuts = new ArrayList<>();
    private final ArrayList<BotShortcut> attachmentShortcuts = new ArrayList<>();

    /* JADX INFO: renamed from: cu.todus.android.repositories.BotShortcutRepository$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.repositories.BotShortcutRepository$1", f = "BotShortcutRepository.kt", l = {21, 22}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class AnonymousClass1 extends cb.m implements Function1 {
        Object L$0;
        int label;

        public AnonymousClass1(ab.e<? super AnonymousClass1> eVar) {
            super(1, eVar);
        }

        @Override // cb.a
        public final ab.e<ua.k0> create(ab.e<?> eVar) {
            return BotShortcutRepository.this.new AnonymousClass1(eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super ua.k0> eVar) {
            return ((AnonymousClass1) create(eVar)).invokeSuspend(ua.k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            ArrayList arrayList;
            ArrayList arrayList2;
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                ua.v.b(obj);
                arrayList = BotShortcutRepository.this.homeShortcuts;
                BotShortcutDao botShortcutDao = BotShortcutRepository.this.botShortcutDao;
                this.L$0 = arrayList;
                this.label = 1;
                obj = botShortcutDao.getShortcutsByLocation(BotShortcut.LOCATION_HOME_FLOATING, this);
                if (obj != objG) {
                }
                return objG;
            }
            if (i10 == 1) {
                arrayList = (ArrayList) this.L$0;
                ua.v.b(obj);
            } else {
                if (i10 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                arrayList2 = (ArrayList) this.L$0;
                ua.v.b(obj);
            }
            arrayList2.addAll((Collection) obj);
            return ua.k0.f43947a;
            arrayList.addAll((Collection) obj);
            ArrayList arrayList3 = BotShortcutRepository.this.attachmentShortcuts;
            BotShortcutDao botShortcutDao2 = BotShortcutRepository.this.botShortcutDao;
            this.L$0 = arrayList3;
            this.label = 2;
            Object shortcutsByLocation = botShortcutDao2.getShortcutsByLocation(BotShortcut.LOCATION_ATTACHMENT_SELECTOR, this);
            if (shortcutsByLocation != objG) {
                arrayList2 = arrayList3;
                obj = shortcutsByLocation;
                arrayList2.addAll((Collection) obj);
                return ua.k0.f43947a;
            }
            return objG;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcu/todus/android/repositories/BotShortcutRepository$Companion;", "Lcu/z17/singledi/SingletonInitializer;", "Lcu/todus/android/repositories/BotShortcutRepository;", "<init>", "()V", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion extends SingletonInitializer<BotShortcutRepository> {
        public /* synthetic */ Companion(kotlin.jvm.internal.p pVar) {
            this();
        }

        private Companion() {
        }
    }

    public BotShortcutRepository() {
        CoroutineUtilsKt.launchWithContext$default(pe.n0.a(d1.b()), null, null, new AnonymousClass1(null), 3, null);
    }

    public final Object deleteBotShortcutById(String str, ab.e<? super ua.k0> eVar) {
        Object objDeleteById = this.botShortcutDao.deleteById(str, eVar);
        return objDeleteById == bb.b.g() ? objDeleteById : ua.k0.f43947a;
    }

    public final List<BotShortcut> getAttachmentShortcuts() {
        return va.g0.o1(this.homeShortcuts);
    }

    public final List<BotShortcut> getHomeShortcuts() {
        return va.g0.o1(this.homeShortcuts);
    }

    public final Object insertBotShortCut(BotShortcut botShortcut, ab.e<? super ua.k0> eVar) {
        String location = botShortcut.getLocation();
        if (kotlin.jvm.internal.y.d(location, BotShortcut.LOCATION_HOME_FLOATING)) {
            this.homeShortcuts.add(botShortcut);
        } else if (kotlin.jvm.internal.y.d(location, BotShortcut.LOCATION_ATTACHMENT_SELECTOR)) {
            this.attachmentShortcuts.add(botShortcut);
        }
        Object objInsert = this.botShortcutDao.insert(botShortcut, (ab.e<? super Long>) eVar);
        return objInsert == bb.b.g() ? objInsert : ua.k0.f43947a;
    }
}
