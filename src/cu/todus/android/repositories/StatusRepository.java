package cu.todus.android.repositories;

import android.content.Context;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.location.LocationRequestCompat;
import androidx.media3.extractor.metadata.dvbsi.AppInfoTableDecoder;
import androidx.media3.extractor.ts.TsExtractor;
import androidx.media3.muxer.WebmConstants;
import androidx.paging.PagingSource;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import cu.todus.android.data.db.entity.toDus.Status;
import cu.todus.android.data.db.entity.toDus.UserRoomJoin;
import cu.todus.android.data.db.pojo.StatusForPagination;
import cu.todus.android.data.db.pojo.StatusWithPartnersOrRooms;
import cu.todus.android.data.db.pojo.content.statusContent.StatusImageContent;
import cu.todus.android.data.db.pojo.content.statusContent.StatusVideoContent;
import cu.todus.android.data.preferences.Owner;
import cu.todus.android.data.util.MediaUtil;
import cu.todus.android.db.dao.toDus.ReactionDao;
import cu.todus.android.db.dao.toDus.StatusDao;
import cu.todus.android.di.DatabaseModule;
import cu.todus.android.image.blurhash.BlurHash;
import cu.todus.android.utils.ThumbnailGenerator;
import cu.z17.singledi.SingletonInitializer;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import org.jivesoftware.smackx.xdatalayout.packet.DataLayout;
import pe.d1;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 X2\u00020\u0001:\u0001XB\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0013\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\f¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\f¢\u0006\u0004\b\u000f\u0010\u000eJ\u0019\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0004\b\u0010\u0010\u000bJ\u0019\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0004\b\u0011\u0010\u000bJ\u0018\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0012H\u0086@¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0017H\u0086@¢\u0006\u0004\b\u0018\u0010\u0019JD\u0010\u001f\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001a2*\b\u0002\u0010\u001e\u001a$\b\u0001\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u001d\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001cH\u0086@¢\u0006\u0004\b\u001f\u0010 J \u0010\"\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\bH\u0086@¢\u0006\u0004\b\"\u0010#J\u0018\u0010$\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001aH\u0086@¢\u0006\u0004\b$\u0010%J\u0010\u0010&\u001a\u00020\u0017H\u0086@¢\u0006\u0004\b&\u0010\u0019J\u001a\u0010'\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u001b\u001a\u00020\u001aH\u0086@¢\u0006\u0004\b'\u0010%J\u0019\u0010)\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0(0\f¢\u0006\u0004\b)\u0010\u000eJ \u0010+\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010*\u001a\u00020\u001aH\u0086@¢\u0006\u0004\b+\u0010,J\u001d\u0010.\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010-0\f2\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b.\u0010/J!\u00101\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00072\u0006\u00100\u001a\u00020\u001a¢\u0006\u0004\b1\u00102J \u00107\u001a\u0002062\u0006\u00103\u001a\u00020\u001a2\u0006\u00105\u001a\u000204H\u0086@¢\u0006\u0004\b7\u00108J(\u0010=\u001a\u00020<2\u0006\u0010:\u001a\u0002092\u0006\u00103\u001a\u00020\u001a2\u0006\u0010;\u001a\u000204H\u0086@¢\u0006\u0004\b=\u0010>J$\u0010A\u001a\u000e\u0012\u0004\u0012\u00020@\u0012\u0004\u0012\u00020\b0?2\u0006\u0010\u001b\u001a\u00020\u001aH\u0086@¢\u0006\u0004\bA\u0010%J(\u0010C\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0006\u0012\u0004\u0018\u00010\u001a0?2\u0006\u0010B\u001a\u00020\u001aH\u0086@¢\u0006\u0004\bC\u0010%J\u001d\u0010D\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\f2\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\bD\u0010/J\u0018\u0010E\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001aH\u0086@¢\u0006\u0004\bE\u0010%J\u0018\u0010F\u001a\u00020@2\u0006\u0010\u001b\u001a\u00020\u001aH\u0086@¢\u0006\u0004\bF\u0010%J.\u0010K\u001a\b\u0012\u0004\u0012\u00020J0(2\u0006\u0010G\u001a\u00020\u001a2\u0006\u0010H\u001a\u00020\b2\u0006\u0010I\u001a\u00020\bH\u0086@¢\u0006\u0004\bK\u0010LR\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010M\u001a\u0004\bN\u0010OR\u0014\u0010Q\u001a\u00020P8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bQ\u0010RR\u0014\u0010T\u001a\u00020S8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bT\u0010UR\u0018\u0010V\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bV\u0010W¨\u0006Y"}, d2 = {"Lcu/todus/android/repositories/StatusRepository;", "", "Lkotlin/Function0;", "Lcu/todus/android/data/preferences/Owner;", UserRoomJoin.AFFILIATION_OWNER, "<init>", "(Llb/a;)V", "Landroidx/paging/PagingSource;", "", "Lcu/todus/android/data/db/pojo/StatusWithPartnersOrRooms;", "otherStatus", "()Landroidx/paging/PagingSource;", "Lte/h;", "otherStatusCount", "()Lte/h;", "ownerLastStatus", "otherStatusInverted", "ownerStatus", "Lcu/todus/android/data/db/entity/toDus/Status;", "status", "", "insertOwnerStatus", "(Lcu/todus/android/data/db/entity/toDus/Status;Lab/e;)Ljava/lang/Object;", "Lua/k0;", "setAsClosed", "(Lab/e;)Ljava/lang/Object;", "", "statusId", "Lkotlin/Function3;", "Lab/e;", "wasSeenNow", "setAsSeen", "(Ljava/lang/String;Lkotlin/jvm/functions/Function3;Lab/e;)Ljava/lang/Object;", "state", "updateStatusState", "(Ljava/lang/String;ILab/e;)Ljava/lang/Object;", "prepareToUnpostStatus", "(Ljava/lang/String;Lab/e;)Ljava/lang/Object;", "remove48HStatuses", "getStatusById", "", "getRoomsWithStatusUnseen", AppMeasurementSdk.ConditionalUserProperty.VALUE, "sendReaction", "(Ljava/lang/String;Ljava/lang/String;Lab/e;)Ljava/lang/Object;", "Lcu/todus/android/data/db/entity/toDus/Reaction;", "checkReaction", "(Ljava/lang/String;)Lte/h;", "uid", "profileStatus", "(Ljava/lang/String;)Landroidx/paging/PagingSource;", "textContent", "Ljava/io/File;", "imageFile", "Lcu/todus/android/data/db/pojo/content/statusContent/StatusImageContent;", "prepareImageStatus", "(Ljava/lang/String;Ljava/io/File;Lab/e;)Ljava/lang/Object;", "Landroid/content/Context;", "context", "videoFile", "Lcu/todus/android/data/db/pojo/content/statusContent/StatusVideoContent;", "prepareVideoStatus", "(Landroid/content/Context;Ljava/lang/String;Ljava/io/File;Lab/e;)Ljava/lang/Object;", "Lkotlin/Pair;", "", "getPositionById", "roomId", "getLastStatusPosition", "getViewsCount", "deleteLocalById", "replyStatus", "first", DataLayout.ELEMENT, "pageSize", "Lcu/todus/android/data/db/pojo/StatusForPagination;", "getStatusPaginated", "(Ljava/lang/String;IILab/e;)Ljava/lang/Object;", "Llb/a;", "getOwner", "()Llb/a;", "Lcu/todus/android/db/dao/toDus/StatusDao;", "statusDao", "Lcu/todus/android/db/dao/toDus/StatusDao;", "Lcu/todus/android/db/dao/toDus/ReactionDao;", "reactionDao", "Lcu/todus/android/db/dao/toDus/ReactionDao;", "itemToRetrieve", "Lcu/todus/android/data/db/pojo/StatusWithPartnersOrRooms;", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class StatusRepository {
    private StatusWithPartnersOrRooms itemToRetrieve;
    private final lb.a owner;
    private final ReactionDao reactionDao;
    private final StatusDao statusDao;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcu/todus/android/repositories/StatusRepository$Companion;", "Lcu/z17/singledi/SingletonInitializer;", "Lcu/todus/android/repositories/StatusRepository;", "<init>", "()V", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion extends SingletonInitializer<StatusRepository> {
        public /* synthetic */ Companion(kotlin.jvm.internal.p pVar) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.repositories.StatusRepository$getLastStatusPosition$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.repositories.StatusRepository", f = "StatusRepository.kt", l = {211, 214}, m = "getLastStatusPosition", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class AnonymousClass1 extends cb.d {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(ab.e<? super AnonymousClass1> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StatusRepository.this.getLastStatusPosition(null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.repositories.StatusRepository$getPositionById$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.repositories.StatusRepository", f = "StatusRepository.kt", l = {191, 193, 195}, m = "getPositionById", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C11391 extends cb.d {
        Object L$0;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        public C11391(ab.e<? super C11391> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StatusRepository.this.getPositionById(null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.repositories.StatusRepository$getStatusById$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.repositories.StatusRepository", f = "StatusRepository.kt", l = {LocationRequestCompat.QUALITY_LOW_POWER}, m = "getStatusById", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C11401 extends cb.d {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C11401(ab.e<? super C11401> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StatusRepository.this.getStatusById(null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.repositories.StatusRepository$getStatusPaginated$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.repositories.StatusRepository", f = "StatusRepository.kt", l = {266, 281}, m = "getStatusPaginated", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C11411 extends cb.d {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C11411(ab.e<? super C11411> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StatusRepository.this.getStatusPaginated(null, 0, 0, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.repositories.StatusRepository$prepareImageStatus$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.repositories.StatusRepository$prepareImageStatus$2", f = "StatusRepository.kt", l = {}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lcu/todus/android/data/db/pojo/content/statusContent/StatusImageContent;", "<anonymous>", "(Lpe/m0;)Lcu/todus/android/data/db/pojo/content/statusContent/StatusImageContent;"}, k = 3, mv = {2, 3, 0})
    public static final class AnonymousClass2 extends cb.m implements Function2 {
        final /* synthetic */ File $imageFile;
        final /* synthetic */ String $textContent;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(File file, String str, ab.e<? super AnonymousClass2> eVar) {
            super(2, eVar);
            this.$imageFile = file;
            this.$textContent = str;
        }

        @Override // cb.a
        public final ab.e<ua.k0> create(Object obj, ab.e<?> eVar) {
            return new AnonymousClass2(this.$imageFile, this.$textContent, eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            String strEncode;
            bb.b.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ua.v.b(obj);
            try {
                strEncode = BlurHash.encode(MediaUtil.generateImageThumbnail$default(MediaUtil.INSTANCE, new File(this.$imageFile.getPath()), 0.0f, 2, null));
            } catch (Exception e10) {
                e10.printStackTrace();
                strEncode = "";
            }
            String str = strEncode;
            MediaUtil mediaUtil = MediaUtil.INSTANCE;
            String absolutePath = this.$imageFile.getAbsolutePath();
            kotlin.jvm.internal.y.h(absolutePath, "getAbsolutePath(...)");
            Pair<Long, Long> imageWidthHeight = mediaUtil.getImageWidthHeight(absolutePath);
            kotlin.jvm.internal.y.f(str);
            long jLongValue = imageWidthHeight.getFirst().longValue();
            long jLongValue2 = imageWidthHeight.getSecond().longValue();
            String name = this.$imageFile.getName();
            kotlin.jvm.internal.y.h(name, "getName(...)");
            String path = this.$imageFile.getPath();
            kotlin.jvm.internal.y.h(path, "getPath(...)");
            return new StatusImageContent(str, jLongValue, jLongValue2, this.$textContent, name, path, "", this.$imageFile.length(), null, 256, null);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(pe.m0 m0Var, ab.e<? super StatusImageContent> eVar) {
            return ((AnonymousClass2) create(m0Var, eVar)).invokeSuspend(ua.k0.f43947a);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.repositories.StatusRepository$prepareVideoStatus$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.repositories.StatusRepository$prepareVideoStatus$2", f = "StatusRepository.kt", l = {TsExtractor.TS_STREAM_TYPE_AC4}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lcu/todus/android/data/db/pojo/content/statusContent/StatusVideoContent;", "<anonymous>", "(Lpe/m0;)Lcu/todus/android/data/db/pojo/content/statusContent/StatusVideoContent;"}, k = 3, mv = {2, 3, 0})
    public static final class C11422 extends cb.m implements Function2 {
        final /* synthetic */ Context $context;
        final /* synthetic */ String $textContent;
        final /* synthetic */ File $videoFile;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C11422(File file, Context context, String str, ab.e<? super C11422> eVar) {
            super(2, eVar);
            this.$videoFile = file;
            this.$context = context;
            this.$textContent = str;
        }

        @Override // cb.a
        public final ab.e<ua.k0> create(Object obj, ab.e<?> eVar) {
            return new C11422(this.$videoFile, this.$context, this.$textContent, eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objGenerateVideoThumbnailInFile;
            String path;
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                ua.v.b(obj);
                ThumbnailGenerator thumbnailGenerator = ThumbnailGenerator.INSTANCE;
                String path2 = this.$videoFile.getPath();
                kotlin.jvm.internal.y.h(path2, "getPath(...)");
                this.label = 1;
                objGenerateVideoThumbnailInFile = thumbnailGenerator.generateVideoThumbnailInFile(path2, this);
                if (objGenerateVideoThumbnailInFile == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ua.v.b(obj);
                objGenerateVideoThumbnailInFile = obj;
            }
            File file = (File) objGenerateVideoThumbnailInFile;
            long durationFromFile = MediaUtil.INSTANCE.getDurationFromFile(this.$context, this.$videoFile);
            if (file == null || (path = file.getPath()) == null) {
                path = "";
            }
            String str = path;
            String name = this.$videoFile.getName();
            kotlin.jvm.internal.y.h(name, "getName(...)");
            String path3 = this.$videoFile.getPath();
            kotlin.jvm.internal.y.h(path3, "getPath(...)");
            return new StatusVideoContent(str, durationFromFile, this.$textContent, false, null, name, path3, "", this.$videoFile.length(), null, 536, null);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(pe.m0 m0Var, ab.e<? super StatusVideoContent> eVar) {
            return ((C11422) create(m0Var, eVar)).invokeSuspend(ua.k0.f43947a);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.repositories.StatusRepository$remove48HStatuses$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.repositories.StatusRepository", f = "StatusRepository.kt", l = {87, 99, 100}, m = "remove48HStatuses", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C11431 extends cb.d {
        long J$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C11431(ab.e<? super C11431> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StatusRepository.this.remove48HStatuses(this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.repositories.StatusRepository$replyStatus$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.repositories.StatusRepository", f = "StatusRepository.kt", l = {WebmConstants.MkvEbmlElement.TIMESTAMP, 234}, m = "replyStatus", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C11441 extends cb.d {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C11441(ab.e<? super C11441> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StatusRepository.this.replyStatus(null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.repositories.StatusRepository$sendReaction$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.repositories.StatusRepository", f = "StatusRepository.kt", l = {113, AppInfoTableDecoder.APPLICATION_INFORMATION_TABLE_ID}, m = "sendReaction", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C11451 extends cb.d {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C11451(ab.e<? super C11451> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StatusRepository.this.sendReaction(null, null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.repositories.StatusRepository$setAsSeen$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.repositories.StatusRepository", f = "StatusRepository.kt", l = {56, 59, TsExtractor.TS_SYNC_BYTE, WebmConstants.MAX_META_SEEK_SIZE}, m = "setAsSeen", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C11461 extends cb.d {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C11461(ab.e<? super C11461> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StatusRepository.this.setAsSeen(null, null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.repositories.StatusRepository$setAsSeen$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.repositories.StatusRepository$setAsSeen$2", f = "StatusRepository.kt", l = {}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "<unused var>", "Lua/k0;", "<anonymous>", "(Ljava/lang/String;Ljava/lang/String;)V"}, k = 3, mv = {2, 3, 0})
    public static final class C11472 extends cb.m implements Function3 {
        int label;

        public C11472(ab.e<? super C11472> eVar) {
            super(3, eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            bb.b.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ua.v.b(obj);
            return ua.k0.f43947a;
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(String str, String str2, ab.e<? super ua.k0> eVar) {
            return new C11472(eVar).invokeSuspend(ua.k0.f43947a);
        }
    }

    public StatusRepository(lb.a owner) {
        kotlin.jvm.internal.y.i(owner, "owner");
        this.owner = owner;
        DatabaseModule.Companion companion = DatabaseModule.INSTANCE;
        this.statusDao = companion.getInstance().getStatusDao();
        this.reactionDao = companion.getInstance().getReactionDao();
    }

    public static /* synthetic */ Object setAsSeen$default(StatusRepository statusRepository, String str, Function3 function3, ab.e eVar, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            function3 = new C11472(null);
        }
        return statusRepository.setAsSeen(str, function3, eVar);
    }

    public final te.h checkReaction(String statusId) {
        kotlin.jvm.internal.y.i(statusId, "statusId");
        return this.reactionDao.getReactionsByEntityFlow(statusId, ((Owner) this.owner.invoke()).getNameWithDomain());
    }

    public final Object deleteLocalById(String str, ab.e<? super ua.k0> eVar) {
        Object objDeleteById = this.statusDao.deleteById(str, eVar);
        return objDeleteById == bb.b.g() ? objDeleteById : ua.k0.f43947a;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object getLastStatusPosition(String str, ab.e<? super Pair<Integer, String>> eVar) {
        AnonymousClass1 anonymousClass1;
        String str2;
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
        Object lastStatusId = anonymousClass1.result;
        Object objG = bb.b.g();
        int i11 = anonymousClass1.label;
        if (i11 == 0) {
            ua.v.b(lastStatusId);
            StatusDao statusDao = this.statusDao;
            anonymousClass1.L$0 = cb.l.a(str);
            anonymousClass1.label = 1;
            lastStatusId = statusDao.getLastStatusId(str, anonymousClass1);
            if (lastStatusId != objG) {
            }
            return objG;
        }
        if (i11 == 1) {
            str = (String) anonymousClass1.L$0;
            ua.v.b(lastStatusId);
        } else {
            if (i11 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            str2 = (String) anonymousClass1.L$1;
            ua.v.b(lastStatusId);
        }
        return ua.z.a(((Pair) lastStatusId).getSecond(), str2);
        String str3 = (String) lastStatusId;
        if (str3 == null) {
            return ua.z.a(null, null);
        }
        anonymousClass1.L$0 = cb.l.a(str);
        anonymousClass1.L$1 = str3;
        anonymousClass1.label = 2;
        Object positionById = getPositionById(str3, anonymousClass1);
        if (positionById != objG) {
            lastStatusId = positionById;
            str2 = str3;
            return ua.z.a(((Pair) lastStatusId).getSecond(), str2);
        }
        return objG;
    }

    public final lb.a getOwner() {
        return this.owner;
    }

    /* JADX WARN: Code duplicated, block: B:39:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object getPositionById(String str, ab.e<? super Pair<Boolean, Integer>> eVar) {
        C11391 c11391;
        String str2;
        boolean z10;
        List list;
        int iIndexOf;
        if (eVar instanceof C11391) {
            c11391 = (C11391) eVar;
            int i10 = c11391.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c11391.label = i10 - Integer.MIN_VALUE;
            } else {
                c11391 = new C11391(eVar);
            }
        } else {
            c11391 = new C11391(eVar);
        }
        Object statusById = c11391.result;
        Object objG = bb.b.g();
        int i11 = c11391.label;
        if (i11 == 0) {
            ua.v.b(statusById);
            StatusDao statusDao = this.statusDao;
            c11391.L$0 = str;
            c11391.label = 1;
            statusById = statusDao.getStatusById(str, c11391);
            if (statusById != objG) {
            }
            return objG;
        }
        if (i11 != 1) {
            if (i11 == 2) {
                z10 = c11391.Z$0;
                str2 = (String) c11391.L$0;
                ua.v.b(statusById);
                list = (List) statusById;
                iIndexOf = list.indexOf(str2);
                if (z10) {
                    iIndexOf = 0;
                }
                return ua.z.a(cb.b.a(z10), cb.b.d(iIndexOf));
            }
            if (i11 != 3) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            z10 = c11391.Z$0;
            str2 = (String) c11391.L$0;
            ua.v.b(statusById);
            list = (List) statusById;
            iIndexOf = list.indexOf(str2);
            if (z10 && (iIndexOf = iIndexOf - 1) <= 0) {
                iIndexOf = 0;
            }
            return ua.z.a(cb.b.a(z10), cb.b.d(iIndexOf));
        }
        str = (String) c11391.L$0;
        ua.v.b(statusById);
        Status status = (Status) statusById;
        boolean zD = kotlin.jvm.internal.y.d(status != null ? status.getRepliedId() : null, ((Owner) this.owner.invoke()).getNameWithDomain());
        if (zD) {
            StatusDao statusDao2 = this.statusDao;
            String nameWithDomain = ((Owner) this.owner.invoke()).getNameWithDomain();
            c11391.L$0 = str;
            c11391.Z$0 = zD;
            c11391.label = 3;
            Object ownerStatusList = statusDao2.getOwnerStatusList(nameWithDomain, c11391);
            if (ownerStatusList != objG) {
                str2 = str;
                z10 = zD;
                statusById = ownerStatusList;
                list = (List) statusById;
                iIndexOf = list.indexOf(str2);
                if (z10) {
                    iIndexOf = 0;
                }
                return ua.z.a(cb.b.a(z10), cb.b.d(iIndexOf));
            }
        } else {
            StatusDao statusDao3 = this.statusDao;
            String nameWithDomain2 = ((Owner) this.owner.invoke()).getNameWithDomain();
            c11391.L$0 = str;
            c11391.Z$0 = zD;
            c11391.label = 2;
            Object otherStatusList = statusDao3.getOtherStatusList(nameWithDomain2, c11391);
            if (otherStatusList != objG) {
                str2 = str;
                z10 = zD;
                statusById = otherStatusList;
                list = (List) statusById;
                iIndexOf = list.indexOf(str2);
                if (z10) {
                    iIndexOf = 0;
                }
                return ua.z.a(cb.b.a(z10), cb.b.d(iIndexOf));
            }
        }
        return objG;
    }

    public final te.h getRoomsWithStatusUnseen() {
        return this.statusDao.getRoomsWithStatusUnseen(((Owner) this.owner.invoke()).getNameWithDomain());
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object getStatusById(String str, ab.e<? super Status> eVar) {
        C11401 c11401;
        if (eVar instanceof C11401) {
            c11401 = (C11401) eVar;
            int i10 = c11401.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c11401.label = i10 - Integer.MIN_VALUE;
            } else {
                c11401 = new C11401(eVar);
            }
        } else {
            c11401 = new C11401(eVar);
        }
        Object statusById = c11401.result;
        Object objG = bb.b.g();
        int i11 = c11401.label;
        if (i11 == 0) {
            ua.v.b(statusById);
            StatusDao statusDao = this.statusDao;
            c11401.L$0 = cb.l.a(str);
            c11401.label = 1;
            statusById = statusDao.getStatusById(str, c11401);
            if (statusById == objG) {
                return objG;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ua.v.b(statusById);
        }
        return (Status) statusById;
    }

    /* JADX WARN: Code duplicated, block: B:36:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:45:0x0103  */
    /* JADX WARN: Code duplicated, block: B:47:0x0115  */
    /* JADX WARN: Code duplicated, block: B:8:0x0018  */
    public final Object getStatusPaginated(String str, int i10, int i11, ab.e<? super List<StatusForPagination>> eVar) {
        C11411 c11411;
        String str2;
        int i12;
        ArrayList arrayList;
        int i13;
        ArrayList arrayList2;
        String str3;
        StatusWithPartnersOrRooms statusWithPartnersOrRooms;
        StatusForPagination statusForPagination;
        StatusWithPartnersOrRooms status;
        Status status2;
        if (eVar instanceof C11411) {
            c11411 = (C11411) eVar;
            int i14 = c11411.label;
            if ((i14 & Integer.MIN_VALUE) != 0) {
                c11411.label = i14 - Integer.MIN_VALUE;
            } else {
                c11411 = new C11411(eVar);
            }
        } else {
            c11411 = new C11411(eVar);
        }
        C11411 c11412 = c11411;
        Object statusFullDataById = c11412.result;
        Object objG = bb.b.g();
        int i15 = c11412.label;
        String id2 = null;
        if (i15 == 0) {
            ua.v.b(statusFullDataById);
            ArrayList arrayList3 = new ArrayList();
            StatusDao statusDao = this.statusDao;
            String nameWithDomain = ((Owner) this.owner.invoke()).getNameWithDomain();
            c11412.L$0 = str;
            c11412.L$1 = arrayList3;
            c11412.I$0 = i10;
            c11412.I$1 = i11;
            c11412.label = 1;
            Object otherStatusListPaginated = statusDao.getOtherStatusListPaginated(str, nameWithDomain, i11, i10, c11412);
            if (otherStatusListPaginated != objG) {
                str2 = str;
                i12 = i10;
                arrayList = arrayList3;
                statusFullDataById = otherStatusListPaginated;
                i13 = i11;
            }
            return objG;
        }
        if (i15 == 1) {
            i13 = c11412.I$1;
            i12 = c11412.I$0;
            arrayList = (ArrayList) c11412.L$1;
            str2 = (String) c11412.L$0;
            ua.v.b(statusFullDataById);
        } else {
            if (i15 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            arrayList2 = (ArrayList) c11412.L$1;
            str3 = (String) c11412.L$0;
            ua.v.b(statusFullDataById);
        }
        statusWithPartnersOrRooms = (StatusWithPartnersOrRooms) statusFullDataById;
        if (statusWithPartnersOrRooms != null) {
            statusForPagination = (StatusForPagination) va.g0.y0(arrayList2);
            if (statusForPagination != null && (status = statusForPagination.getStatus()) != null && (status2 = status.getStatus()) != null) {
                id2 = status2.getId();
            }
            if (!kotlin.jvm.internal.y.d(id2, str3)) {
                this.itemToRetrieve = ((StatusForPagination) va.g0.w0(arrayList2)).getStatus();
                if (!arrayList2.isEmpty()) {
                    arrayList2.set(0, new StatusForPagination(0, statusWithPartnersOrRooms));
                }
            }
        }
        return arrayList2;
        Iterable iterable = (Iterable) statusFullDataById;
        ArrayList arrayList4 = new ArrayList(va.x.y(iterable, 10));
        int i16 = 0;
        for (Object obj : iterable) {
            int i17 = i16 + 1;
            if (i16 < 0) {
                va.w.x();
            }
            arrayList4.add(new StatusForPagination(i16, (StatusWithPartnersOrRooms) obj));
            i16 = i17;
        }
        arrayList.addAll(arrayList4);
        if (i12 != 0) {
            if (this.itemToRetrieve != null && arrayList.size() < i13) {
                int size = arrayList.size();
                StatusWithPartnersOrRooms statusWithPartnersOrRooms2 = this.itemToRetrieve;
                kotlin.jvm.internal.y.f(statusWithPartnersOrRooms2);
                arrayList.add(new StatusForPagination(size, statusWithPartnersOrRooms2));
            }
            return arrayList;
        }
        this.itemToRetrieve = null;
        StatusDao statusDao2 = this.statusDao;
        c11412.L$0 = str2;
        c11412.L$1 = arrayList;
        c11412.L$2 = cb.l.a(arrayList4);
        c11412.I$0 = i12;
        c11412.I$1 = i13;
        c11412.label = 2;
        statusFullDataById = statusDao2.getStatusFullDataById(str2, c11412);
        if (statusFullDataById != objG) {
            arrayList2 = arrayList;
            str3 = str2;
            statusWithPartnersOrRooms = (StatusWithPartnersOrRooms) statusFullDataById;
            if (statusWithPartnersOrRooms != null) {
                statusForPagination = (StatusForPagination) va.g0.y0(arrayList2);
                if (statusForPagination != null) {
                    id2 = status2.getId();
                }
                if (!kotlin.jvm.internal.y.d(id2, str3)) {
                    this.itemToRetrieve = ((StatusForPagination) va.g0.w0(arrayList2)).getStatus();
                    if (!arrayList2.isEmpty()) {
                        arrayList2.set(0, new StatusForPagination(0, statusWithPartnersOrRooms));
                    }
                }
            }
            return arrayList2;
        }
        return objG;
    }

    public final te.h getViewsCount(String statusId) {
        kotlin.jvm.internal.y.i(statusId, "statusId");
        return this.reactionDao.getReactionsCountByEntityFlow(statusId);
    }

    public final Object insertOwnerStatus(Status status, ab.e<? super Long> eVar) {
        return this.statusDao.insert(status, eVar);
    }

    public final PagingSource<Integer, StatusWithPartnersOrRooms> otherStatus() {
        return this.statusDao.otherStatusPaging(((Owner) this.owner.invoke()).getNameWithDomain());
    }

    public final te.h otherStatusCount() {
        return this.statusDao.otherStatusCount(((Owner) this.owner.invoke()).getNameWithDomain());
    }

    public final PagingSource<Integer, StatusWithPartnersOrRooms> otherStatusInverted() {
        return this.statusDao.otherStatusPagingInverted(((Owner) this.owner.invoke()).getNameWithDomain());
    }

    public final te.h ownerLastStatus() {
        return this.statusDao.ownerLastStatus(((Owner) this.owner.invoke()).getNameWithDomain());
    }

    public final PagingSource<Integer, StatusWithPartnersOrRooms> ownerStatus() {
        return this.statusDao.ownerStatusPaging(((Owner) this.owner.invoke()).getNameWithDomain());
    }

    public final Object prepareImageStatus(String str, File file, ab.e<? super StatusImageContent> eVar) {
        return pe.i.g(d1.b(), new AnonymousClass2(file, str, null), eVar);
    }

    public final Object prepareToUnpostStatus(String str, ab.e<? super ua.k0> eVar) {
        Object asDeleted = this.statusDao.setAsDeleted(str, eVar);
        return asDeleted == bb.b.g() ? asDeleted : ua.k0.f43947a;
    }

    public final Object prepareVideoStatus(Context context, String str, File file, ab.e<? super StatusVideoContent> eVar) {
        return pe.i.g(d1.b(), new C11422(file, context, str, null), eVar);
    }

    public final PagingSource<Integer, StatusWithPartnersOrRooms> profileStatus(String uid) {
        kotlin.jvm.internal.y.i(uid, "uid");
        return this.statusDao.profileStatusPaging(uid);
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0131, code lost:
    
        if (cu.todus.android.db.dao.toDus.c3.a(r12, r3, null, r5, 2, null) == r0) goto L48;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object remove48HStatuses(ab.e<? super ua.k0> r12) throws cu.z17.singledi.SinglediException {
        /*
            Method dump skipped, instruction units count: 311
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.repositories.StatusRepository.remove48HStatuses(ab.e):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00c9, code lost:
    
        if (r1.insert(r8, r2) == r3) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object replyStatus(java.lang.String r29, ab.e<? super java.lang.Boolean> r30) {
        /*
            Method dump skipped, instruction units count: 215
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.repositories.StatusRepository.replyStatus(java.lang.String, ab.e):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00b6, code lost:
    
        if (r1.insert(r7, r3) == r4) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object sendReaction(java.lang.String r19, java.lang.String r20, ab.e<? super ua.k0> r21) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r2 = r21
            boolean r3 = r2 instanceof cu.todus.android.repositories.StatusRepository.C11451
            if (r3 == 0) goto L19
            r3 = r2
            cu.todus.android.repositories.StatusRepository$sendReaction$1 r3 = (cu.todus.android.repositories.StatusRepository.C11451) r3
            int r4 = r3.label
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r6 = r4 & r5
            if (r6 == 0) goto L19
            int r4 = r4 - r5
            r3.label = r4
            goto L1e
        L19:
            cu.todus.android.repositories.StatusRepository$sendReaction$1 r3 = new cu.todus.android.repositories.StatusRepository$sendReaction$1
            r3.<init>(r2)
        L1e:
            java.lang.Object r2 = r3.result
            java.lang.Object r4 = bb.b.g()
            int r5 = r3.label
            r6 = 2
            r7 = 1
            if (r5 == 0) goto L55
            if (r5 == r7) goto L47
            if (r5 != r6) goto L3f
            java.lang.Object r1 = r3.L$2
            cu.todus.android.data.db.entity.toDus.Status r1 = (cu.todus.android.data.db.entity.toDus.Status) r1
            java.lang.Object r1 = r3.L$1
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r1 = r3.L$0
            java.lang.String r1 = (java.lang.String) r1
            ua.v.b(r2)
            goto Lb9
        L3f:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L47:
            java.lang.Object r1 = r3.L$1
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r5 = r3.L$0
            java.lang.String r5 = (java.lang.String) r5
            ua.v.b(r2)
            r12 = r1
            r9 = r5
            goto L6a
        L55:
            ua.v.b(r2)
            r3.L$0 = r1
            r2 = r20
            r3.L$1 = r2
            r3.label = r7
            java.lang.Object r5 = r0.getStatusById(r1, r3)
            if (r5 != r4) goto L67
            goto Lb8
        L67:
            r9 = r1
            r12 = r2
            r2 = r5
        L6a:
            cu.todus.android.data.db.entity.toDus.Status r2 = (cu.todus.android.data.db.entity.toDus.Status) r2
            if (r2 == 0) goto Lbc
            cu.todus.android.db.dao.toDus.ReactionDao r1 = r0.reactionDao
            cu.todus.android.data.db.entity.toDus.Reaction r7 = new cu.todus.android.data.db.entity.toDus.Reaction
            cu.todus.android.data.db.entity.toDus.Reaction$Companion r5 = cu.todus.android.data.db.entity.toDus.Reaction.INSTANCE
            lb.a r8 = r0.owner
            java.lang.Object r8 = r8.invoke()
            cu.todus.android.data.preferences.Owner r8 = (cu.todus.android.data.preferences.Owner) r8
            java.lang.String r8 = r8.getNameWithDomain()
            java.lang.String r8 = r5.buildId(r9, r8)
            lb.a r5 = r0.owner
            java.lang.Object r5 = r5.invoke()
            cu.todus.android.data.preferences.Owner r5 = (cu.todus.android.data.preferences.Owner) r5
            java.lang.String r10 = r5.getNameWithDomain()
            java.lang.String r11 = r2.getRepliedId()
            r16 = 64
            r17 = 0
            r13 = 1
            r14 = 0
            r7.<init>(r8, r9, r10, r11, r12, r13, r14, r16, r17)
            java.lang.Object r5 = cb.l.a(r9)
            r3.L$0 = r5
            java.lang.Object r5 = cb.l.a(r12)
            r3.L$1 = r5
            java.lang.Object r2 = cb.l.a(r2)
            r3.L$2 = r2
            r3.label = r6
            java.lang.Object r1 = r1.insert(r7, r3)
            if (r1 != r4) goto Lb9
        Lb8:
            return r4
        Lb9:
            ua.k0 r1 = ua.k0.f43947a
            return r1
        Lbc:
            ua.k0 r1 = ua.k0.f43947a
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.repositories.StatusRepository.sendReaction(java.lang.String, java.lang.String, ab.e):java.lang.Object");
    }

    public final Object setAsClosed(ab.e<? super ua.k0> eVar) {
        Object asClosed = this.statusDao.setAsClosed(eVar);
        return asClosed == bb.b.g() ? asClosed : ua.k0.f43947a;
    }

    /* JADX WARN: Code duplicated, block: B:34:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:37:0x010b  */
    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x012c, code lost:
    
        if (r5.invoke(r2, r8, r3) == r4) goto L40;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object setAsSeen(java.lang.String r21, kotlin.jvm.functions.Function3 r22, ab.e<? super ua.k0> r23) {
        /*
            Method dump skipped, instruction units count: 309
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.repositories.StatusRepository.setAsSeen(java.lang.String, kotlin.jvm.functions.Function3, ab.e):java.lang.Object");
    }

    public final Object updateStatusState(String str, int i10, ab.e<? super ua.k0> eVar) {
        Object objChangeStatusState = this.statusDao.changeStatusState(str, i10, eVar);
        return objChangeStatusState == bb.b.g() ? objChangeStatusState : ua.k0.f43947a;
    }
}
