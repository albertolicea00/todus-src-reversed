package cu.todus.android.s3.upload;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.spatial.RectListKt;
import androidx.core.location.LocationRequestCompat;
import androidx.media3.extractor.metadata.dvbsi.AppInfoTableDecoder;
import androidx.media3.extractor.ts.TsExtractor;
import androidx.media3.muxer.WebmConstants;
import cb.l;
import cb.m;
import cu.todus.android.data.db.entity.toDus.Room;
import cu.todus.android.data.db.entity.toDus.Status;
import cu.todus.android.data.xmpp.FileResponse;
import cu.todus.android.s3.AttS3State;
import cu.todus.android.s3.S3State;
import cu.todus.android.utils.CoroutineUtilsKt;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLSession;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.y;
import kotlin.jvm.internal.y0;
import lb.o;
import pe.d1;
import pe.e2;
import pe.k;
import pe.m0;
import pe.n0;
import re.u;
import te.b0;
import te.p0;
import te.r0;
import ua.k0;
import ua.v;
import va.g0;
import va.w;
import va.x;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 42\u00020\u0001:\u00014B\u0083\u0001\u00120\u0010\b\u001a,\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0002\u0012\"\u0010\f\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\t\u0012$\u0010\r\u001a \b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\t¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0018\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0003H\u0082@¢\u0006\u0004\b\u0015\u0010\u0016J\u0018\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u0003H\u0082@¢\u0006\u0004\b\u0018\u0010\u0016J(\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\nH\u0082@¢\u0006\u0004\b\u001c\u0010\u001dJ\u0018\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u0003H\u0082@¢\u0006\u0004\b\u001f\u0010\u0016J\r\u0010 \u001a\u00020\u000b¢\u0006\u0004\b \u0010!J\u0015\u0010\"\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u0003¢\u0006\u0004\b\"\u0010#J\u0015\u0010$\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u0003¢\u0006\u0004\b$\u0010#R>\u0010\b\u001a,\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010%R0\u0010\f\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010&R2\u0010\r\u001a \b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010&R\u0014\u0010(\u001a\u00020'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)R \u0010-\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020,0+0*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.R#\u00100\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020,0+0/8\u0006¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103¨\u00065"}, d2 = {"Lcu/todus/android/s3/upload/UploadStatusDataSource;", "", "Lkotlin/Function4;", "", "", "", "Lab/e;", "Lcu/todus/android/data/xmpp/FileResponse$FileResult;", "getPutUrl", "Lkotlin/Function2;", "Lcu/todus/android/data/db/entity/toDus/Status;", "Lua/k0;", "updateStatus", "getStatus", "<init>", "(Llb/o;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;)V", Room.COLUMN_LAST_MSG, "Lcu/todus/android/s3/AttS3State;", "newAtt", "upsertAttS3State", "(Ljava/lang/String;Lcu/todus/android/s3/AttS3State;)V", "startProcess", "(Ljava/lang/String;Lab/e;)Ljava/lang/Object;", "statusId", "uploadStatus", "cloudType", "totalSize", "status", "upload", "(IJLcu/todus/android/data/db/entity/toDus/Status;Lab/e;)Ljava/lang/Object;", "imagePath", "directUploadThumbnail", "cancelAll", "()V", "putStatusInUploadQueue", "(Ljava/lang/String;)V", "cancelUpload", "Llb/o;", "Lkotlin/jvm/functions/Function2;", "Lpe/m0;", "coroutineScope", "Lpe/m0;", "Lte/b0;", "", "Lcu/todus/android/s3/S3State;", "_uploadQueue", "Lte/b0;", "Lte/p0;", "uploadQueue", "Lte/p0;", "getUploadQueue", "()Lte/p0;", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class UploadStatusDataSource {
    public static final String UPLOAD_STATUS_TAG = "UPLOAD_STATUS_TAG";
    private final b0 _uploadQueue;
    private final m0 coroutineScope;
    private final o getPutUrl;
    private final Function2 getStatus;
    private final Function2 updateStatus;
    private final p0 uploadQueue;
    public static final int $stable = 8;

    /* JADX INFO: renamed from: cu.todus.android.s3.upload.UploadStatusDataSource$cancelAll$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.s3.upload.UploadStatusDataSource$cancelAll$1", f = "UploadStatusDataSource.kt", l = {RectListKt.BitOffsetForGesturable, RectListKt.BitOffsetForFocusable}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class AnonymousClass1 extends m implements Function1 {
        Object L$0;
        int label;

        public AnonymousClass1(ab.e<? super AnonymousClass1> eVar) {
            super(1, eVar);
        }

        @Override // cb.a
        public final ab.e<k0> create(ab.e<?> eVar) {
            return UploadStatusDataSource.this.new AnonymousClass1(eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super k0> eVar) {
            return ((AnonymousClass1) create(eVar)).invokeSuspend(k0.f43947a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x0072, code lost:
        
            if (r1.emit(r3, r12) == r0) goto L19;
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
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L22
                if (r1 == r3) goto L1a
                if (r1 != r2) goto L12
                ua.v.b(r13)
                goto L75
            L12:
                java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r13.<init>(r0)
                throw r13
            L1a:
                java.lang.Object r1 = r12.L$0
                te.b0 r1 = (te.b0) r1
                ua.v.b(r13)
                goto L3c
            L22:
                ua.v.b(r13)
                cu.todus.android.s3.upload.UploadStatusDataSource r13 = cu.todus.android.s3.upload.UploadStatusDataSource.this
                te.b0 r1 = cu.todus.android.s3.upload.UploadStatusDataSource.access$get_uploadQueue$p(r13)
                cu.todus.android.s3.upload.UploadStatusDataSource r13 = cu.todus.android.s3.upload.UploadStatusDataSource.this
                te.b0 r13 = cu.todus.android.s3.upload.UploadStatusDataSource.access$get_uploadQueue$p(r13)
                r12.L$0 = r1
                r12.label = r3
                java.lang.Object r13 = te.j.x(r13, r12)
                if (r13 != r0) goto L3c
                goto L74
            L3c:
                java.lang.Iterable r13 = (java.lang.Iterable) r13
                java.util.ArrayList r3 = new java.util.ArrayList
                r4 = 10
                int r4 = va.x.y(r13, r4)
                r3.<init>(r4)
                java.util.Iterator r13 = r13.iterator()
            L4d:
                boolean r4 = r13.hasNext()
                if (r4 == 0) goto L69
                java.lang.Object r4 = r13.next()
                r5 = r4
                cu.todus.android.s3.S3State r5 = (cu.todus.android.s3.S3State) r5
                r10 = 13
                r11 = 0
                r6 = 0
                r7 = 0
                r8 = 0
                r9 = 0
                cu.todus.android.s3.S3State r4 = cu.todus.android.s3.S3State.copy$default(r5, r6, r7, r8, r9, r10, r11)
                r3.add(r4)
                goto L4d
            L69:
                r13 = 0
                r12.L$0 = r13
                r12.label = r2
                java.lang.Object r13 = r1.emit(r3, r12)
                if (r13 != r0) goto L75
            L74:
                return r0
            L75:
                ua.k0 r13 = ua.k0.f43947a
                return r13
            */
            throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.s3.upload.UploadStatusDataSource.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.s3.upload.UploadStatusDataSource$cancelUpload$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.s3.upload.UploadStatusDataSource$cancelUpload$1", f = "UploadStatusDataSource.kt", l = {374, 373}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C11821 extends m implements Function1 {
        final /* synthetic */ String $statusId;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C11821(String str, ab.e<? super C11821> eVar) {
            super(1, eVar);
            this.$statusId = str;
        }

        @Override // cb.a
        public final ab.e<k0> create(ab.e<?> eVar) {
            return UploadStatusDataSource.this.new C11821(this.$statusId, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super k0> eVar) {
            return ((C11821) create(eVar)).invokeSuspend(k0.f43947a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:21:0x007e, code lost:
        
            if (r1.emit(r4, r13) == r0) goto L22;
         */
        @Override // cb.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r14) {
            /*
                r13 = this;
                java.lang.Object r0 = bb.b.g()
                int r1 = r13.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L22
                if (r1 == r3) goto L1a
                if (r1 != r2) goto L12
                ua.v.b(r14)
                goto L81
            L12:
                java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r14.<init>(r0)
                throw r14
            L1a:
                java.lang.Object r1 = r13.L$0
                te.b0 r1 = (te.b0) r1
                ua.v.b(r14)
                goto L3c
            L22:
                ua.v.b(r14)
                cu.todus.android.s3.upload.UploadStatusDataSource r14 = cu.todus.android.s3.upload.UploadStatusDataSource.this
                te.b0 r1 = cu.todus.android.s3.upload.UploadStatusDataSource.access$get_uploadQueue$p(r14)
                cu.todus.android.s3.upload.UploadStatusDataSource r14 = cu.todus.android.s3.upload.UploadStatusDataSource.this
                te.b0 r14 = cu.todus.android.s3.upload.UploadStatusDataSource.access$get_uploadQueue$p(r14)
                r13.L$0 = r1
                r13.label = r3
                java.lang.Object r14 = te.j.x(r14, r13)
                if (r14 != r0) goto L3c
                goto L80
            L3c:
                java.lang.Iterable r14 = (java.lang.Iterable) r14
                java.lang.String r3 = r13.$statusId
                java.util.ArrayList r4 = new java.util.ArrayList
                r5 = 10
                int r5 = va.x.y(r14, r5)
                r4.<init>(r5)
                java.util.Iterator r14 = r14.iterator()
            L4f:
                boolean r5 = r14.hasNext()
                if (r5 == 0) goto L75
                java.lang.Object r5 = r14.next()
                r6 = r5
                cu.todus.android.s3.S3State r6 = (cu.todus.android.s3.S3State) r6
                java.lang.String r5 = r6.getItemId()
                boolean r5 = kotlin.jvm.internal.y.d(r5, r3)
                if (r5 == 0) goto L71
                r11 = 13
                r12 = 0
                r7 = 0
                r8 = 0
                r9 = 0
                r10 = 0
                cu.todus.android.s3.S3State r6 = cu.todus.android.s3.S3State.copy$default(r6, r7, r8, r9, r10, r11, r12)
            L71:
                r4.add(r6)
                goto L4f
            L75:
                r14 = 0
                r13.L$0 = r14
                r13.label = r2
                java.lang.Object r14 = r1.emit(r4, r13)
                if (r14 != r0) goto L81
            L80:
                return r0
            L81:
                ua.k0 r14 = ua.k0.f43947a
                return r14
            */
            throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.s3.upload.UploadStatusDataSource.C11821.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.s3.upload.UploadStatusDataSource$directUploadThumbnail$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.s3.upload.UploadStatusDataSource", f = "UploadStatusDataSource.kt", l = {352, 359}, m = "directUploadThumbnail", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C11831 extends cb.d {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C11831(ab.e<? super C11831> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return UploadStatusDataSource.this.directUploadThumbnail(null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.s3.upload.UploadStatusDataSource$putStatusInUploadQueue$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.s3.upload.UploadStatusDataSource$putStatusInUploadQueue$1", f = "UploadStatusDataSource.kt", l = {113, 114, 117, AppInfoTableDecoder.APPLICATION_INFORMATION_TABLE_ID, 119}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C11841 extends m implements Function1 {
        final /* synthetic */ String $statusId;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C11841(String str, ab.e<? super C11841> eVar) {
            super(1, eVar);
            this.$statusId = str;
        }

        @Override // cb.a
        public final ab.e<k0> create(ab.e<?> eVar) {
            return UploadStatusDataSource.this.new C11841(this.$statusId, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super k0> eVar) {
            return ((C11841) create(eVar)).invokeSuspend(k0.f43947a);
        }

        /* JADX WARN: Code duplicated, block: B:25:0x0080  */
        /* JADX WARN: Code duplicated, block: B:30:0x0095  */
        /* JADX WARN: Code duplicated, block: B:33:0x00ac A[PHI: r2 r5
          0x00ac: PHI (r2v14 te.b0) = (r2v13 te.b0), (r2v23 te.b0) binds: [B:31:0x00a9, B:13:0x002c] A[DONT_GENERATE, DONT_INLINE]
          0x00ac: PHI (r5v2 java.lang.Object) = (r5v1 java.lang.Object), (r5v5 java.lang.Object) binds: [B:31:0x00a9, B:13:0x002c] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:36:0x00cd  */
        /* JADX WARN: Code duplicated, block: B:39:0x00da  */
        /* JADX WARN: Code duplicated, block: B:42:0x0092 A[SYNTHETIC] */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x00d7, code lost:
        
            if (r2.startProcess(r4, r16) == r1) goto L38;
         */
        @Override // cb.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r17) {
            /*
                Method dump skipped, instruction units count: 228
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.s3.upload.UploadStatusDataSource.C11841.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.s3.upload.UploadStatusDataSource$startProcess$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.s3.upload.UploadStatusDataSource", f = "UploadStatusDataSource.kt", l = {94, 99, 103, LocationRequestCompat.QUALITY_BALANCED_POWER_ACCURACY}, m = "startProcess", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C11851 extends cb.d {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C11851(ab.e<? super C11851> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return UploadStatusDataSource.this.startProcess(null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.s3.upload.UploadStatusDataSource$upload$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.s3.upload.UploadStatusDataSource$upload$2", f = "UploadStatusDataSource.kt", l = {TsExtractor.TS_PACKET_SIZE, 191, 224, 343}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lre/u;", "", "Lua/k0;", "<anonymous>", "(Lre/u;)V"}, k = 3, mv = {2, 3, 0})
    public static final class AnonymousClass2 extends m implements Function2 {
        final /* synthetic */ y0 $call;
        final /* synthetic */ int $cloudType;
        final /* synthetic */ m0 $downloadScope;
        final /* synthetic */ Status $status;
        final /* synthetic */ long $totalSize;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        final /* synthetic */ UploadStatusDataSource this$0;

        /* JADX INFO: renamed from: cu.todus.android.s3.upload.UploadStatusDataSource$upload$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        @cb.f(c = "cu.todus.android.s3.upload.UploadStatusDataSource$upload$2$1", f = "UploadStatusDataSource.kt", l = {WebmConstants.MkvEbmlElement.TRACK_ENTRY, 175}, m = "invokeSuspend", v = 2)
        @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
        public static final class AnonymousClass1 extends m implements Function1 {
            final /* synthetic */ u $$this$callbackFlow;
            final /* synthetic */ y0 $call;
            final /* synthetic */ m0 $downloadScope;
            final /* synthetic */ Status $status;
            int label;
            final /* synthetic */ UploadStatusDataSource this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(UploadStatusDataSource uploadStatusDataSource, Status status, m0 m0Var, u uVar, y0 y0Var, ab.e<? super AnonymousClass1> eVar) {
                super(1, eVar);
                this.this$0 = uploadStatusDataSource;
                this.$status = status;
                this.$downloadScope = m0Var;
                this.$$this$callbackFlow = uVar;
                this.$call = y0Var;
            }

            @Override // cb.a
            public final ab.e<k0> create(ab.e<?> eVar) {
                return new AnonymousClass1(this.this$0, this.$status, this.$downloadScope, this.$$this$callbackFlow, this.$call, eVar);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(ab.e<? super k0> eVar) {
                return ((AnonymousClass1) create(eVar)).invokeSuspend(k0.f43947a);
            }

            /* JADX WARN: Code duplicated, block: B:14:0x002c  */
            /* JADX WARN: Code restructure failed: missing block: B:15:0x0038, code lost:
            
                if (r8 == r0) goto L16;
             */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x0038 -> B:17:0x003b). Please report as a decompilation issue!!! */
            @Override // cb.a
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r8) {
                /*
                    r7 = this;
                    java.lang.Object r0 = bb.b.g()
                    int r1 = r7.label
                    r2 = 2
                    r3 = 1
                    if (r1 == 0) goto L1e
                    if (r1 == r3) goto L1a
                    if (r1 != r2) goto L12
                    ua.v.b(r8)
                    goto L3b
                L12:
                    java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r8.<init>(r0)
                    throw r8
                L1a:
                    ua.v.b(r8)
                    goto L2c
                L1e:
                    ua.v.b(r8)
                L21:
                    r7.label = r3
                    r4 = 100
                    java.lang.Object r8 = pe.w0.b(r4, r7)
                    if (r8 != r0) goto L2c
                    goto L3a
                L2c:
                    cu.todus.android.s3.upload.UploadStatusDataSource r8 = r7.this$0
                    te.b0 r8 = cu.todus.android.s3.upload.UploadStatusDataSource.access$get_uploadQueue$p(r8)
                    r7.label = r2
                    java.lang.Object r8 = te.j.x(r8, r7)
                    if (r8 != r0) goto L3b
                L3a:
                    return r0
                L3b:
                    java.lang.Iterable r8 = (java.lang.Iterable) r8
                    cu.todus.android.data.db.entity.toDus.Status r1 = r7.$status
                    java.util.Iterator r8 = r8.iterator()
                L43:
                    boolean r4 = r8.hasNext()
                    if (r4 == 0) goto L5f
                    java.lang.Object r4 = r8.next()
                    r5 = r4
                    cu.todus.android.s3.S3State r5 = (cu.todus.android.s3.S3State) r5
                    java.lang.String r5 = r5.getItemId()
                    java.lang.String r6 = r1.getId()
                    boolean r5 = kotlin.jvm.internal.y.d(r5, r6)
                    if (r5 == 0) goto L43
                    goto L60
                L5f:
                    r4 = 0
                L60:
                    cu.todus.android.s3.S3State r4 = (cu.todus.android.s3.S3State) r4
                    if (r4 == 0) goto L21
                    boolean r8 = r4.getRun()
                    if (r8 != 0) goto L21
                    pe.m0 r8 = r7.$downloadScope
                    cu.todus.android.s3.upload.UploadStatusDataSource r1 = r7.this$0
                    re.u r4 = r7.$$this$callbackFlow
                    kotlin.jvm.internal.y0 r5 = r7.$call
                    cu.todus.android.data.db.entity.toDus.Status r6 = r7.$status
                    cu.todus.android.s3.upload.UploadStatusDataSource.AnonymousClass2.access$invokeSuspend$close(r8, r1, r4, r5, r6)
                    goto L21
                */
                throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.s3.upload.UploadStatusDataSource.AnonymousClass2.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(m0 m0Var, Status status, UploadStatusDataSource uploadStatusDataSource, int i10, long j10, y0 y0Var, ab.e<? super AnonymousClass2> eVar) {
            super(2, eVar);
            this.$downloadScope = m0Var;
            this.$status = status;
            this.this$0 = uploadStatusDataSource;
            this.$cloudType = i10;
            this.$totalSize = j10;
            this.$call = y0Var;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invokeSuspend$close(m0 m0Var, UploadStatusDataSource uploadStatusDataSource, u uVar, y0 y0Var, Status status) {
            k.d(m0Var, null, null, new UploadStatusDataSource$upload$2$close$1(uploadStatusDataSource, uVar, y0Var, status, null), 3, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean invokeSuspend$lambda$0$0$0(String str, SSLSession sSLSession) {
            return true;
        }

        @Override // cb.a
        public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$downloadScope, this.$status, this.this$0, this.$cloudType, this.$totalSize, this.$call, eVar);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        /* JADX WARN: Code duplicated, block: B:14:0x0051 A[PHI: r2 r3 r6
          0x0051: PHI (r2v11 java.lang.String) = (r2v8 java.lang.String), (r2v29 java.lang.String) binds: [B:24:0x00c8, B:13:0x0047] A[DONT_GENERATE, DONT_INLINE]
          0x0051: PHI (r3v8 java.lang.Object) = (r3v7 java.lang.Object), (r3v24 java.lang.Object) binds: [B:24:0x00c8, B:13:0x0047] A[DONT_GENERATE, DONT_INLINE]
          0x0051: PHI (r6v3 re.u) = (r6v1 re.u), (r6v9 re.u) binds: [B:24:0x00c8, B:13:0x0047] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:28:0x00d0  */
        /* JADX WARN: Code duplicated, block: B:30:0x00d5  */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x00a4, code lost:
        
            if (r2 == r1) goto L50;
         */
        /* JADX WARN: Code restructure failed: missing block: B:41:0x01fb, code lost:
        
            if (r4.invoke(r2, r37) == r1) goto L50;
         */
        /* JADX WARN: Code restructure failed: missing block: B:49:0x02d0, code lost:
        
            if (re.s.a(r6, r2, r37) == r1) goto L50;
         */
        @Override // cb.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r38) {
            /*
                Method dump skipped, instruction units count: 726
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.s3.upload.UploadStatusDataSource.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(u uVar, ab.e<? super k0> eVar) {
            return ((AnonymousClass2) create(uVar, eVar)).invokeSuspend(k0.f43947a);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.s3.upload.UploadStatusDataSource$upload$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.s3.upload.UploadStatusDataSource$upload$3", f = "UploadStatusDataSource.kt", l = {}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004*\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lte/i;", "", "", "it", "Lua/k0;", "<anonymous>", "(Lte/i;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 3, 0})
    public static final class AnonymousClass3 extends m implements Function3 {
        /* synthetic */ Object L$0;
        int label;

        public AnonymousClass3(ab.e<? super AnonymousClass3> eVar) {
            super(3, eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Throwable th2 = (Throwable) this.L$0;
            bb.b.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v.b(obj);
            String.valueOf(th2);
            return k0.f43947a;
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(te.i iVar, Throwable th2, ab.e<? super k0> eVar) {
            AnonymousClass3 anonymousClass3 = new AnonymousClass3(eVar);
            anonymousClass3.L$0 = th2;
            return anonymousClass3.invokeSuspend(k0.f43947a);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.s3.upload.UploadStatusDataSource$uploadStatus$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.s3.upload.UploadStatusDataSource", f = "UploadStatusDataSource.kt", l = {TsExtractor.TS_STREAM_TYPE_AC3, TsExtractor.TS_STREAM_TYPE_E_AC3}, m = "uploadStatus", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C11861 extends cb.d {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C11861(ab.e<? super C11861> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return UploadStatusDataSource.this.uploadStatus(null, this);
        }
    }

    public UploadStatusDataSource(o getPutUrl, Function2 updateStatus, Function2 getStatus) {
        y.i(getPutUrl, "getPutUrl");
        y.i(updateStatus, "updateStatus");
        y.i(getStatus, "getStatus");
        this.getPutUrl = getPutUrl;
        this.updateStatus = updateStatus;
        this.getStatus = getStatus;
        this.coroutineScope = n0.a(d1.b().plus(e2.b(null, 1, null)));
        b0 b0VarA = r0.a(w.n());
        this._uploadQueue = b0VarA;
        this.uploadQueue = te.j.b(b0VarA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:29:0x0095  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object directUploadThumbnail(String str, ab.e<? super String> eVar) {
        C11831 c11831;
        FileResponse.FileResult fileResult;
        if (eVar instanceof C11831) {
            c11831 = (C11831) eVar;
            int i10 = c11831.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c11831.label = i10 - Integer.MIN_VALUE;
            } else {
                c11831 = new C11831(eVar);
            }
        } else {
            c11831 = new C11831(eVar);
        }
        Object objInvoke = c11831.result;
        Object objG = bb.b.g();
        int i11 = c11831.label;
        if (i11 == 0) {
            v.b(objInvoke);
            o oVar = this.getPutUrl;
            Integer numD = cb.b.d(11);
            Long lE = cb.b.e(new File(str).length());
            c11831.L$0 = str;
            c11831.label = 1;
            objInvoke = oVar.invoke("", numD, lE, c11831);
            if (objInvoke != objG) {
            }
            return objG;
        }
        if (i11 == 1) {
            str = (String) c11831.L$0;
            v.b(objInvoke);
        } else {
            if (i11 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            fileResult = (FileResponse.FileResult) c11831.L$1;
            v.b(objInvoke);
        }
        if (((Boolean) objInvoke).booleanValue()) {
            return fileResult.getGet();
        }
        return "";
        FileResponse.FileResult fileResult2 = (FileResponse.FileResult) objInvoke;
        if (fileResult2 != null && !fileResult2.getWasError()) {
            UploadDataSource.Companion companion = UploadDataSource.INSTANCE;
            String put = fileResult2.getPut();
            c11831.L$0 = l.a(str);
            c11831.L$1 = fileResult2;
            c11831.label = 2;
            Object objDirectUpload = companion.directUpload(put, str, c11831);
            if (objDirectUpload != objG) {
                objInvoke = objDirectUpload;
                fileResult = fileResult2;
                if (((Boolean) objInvoke).booleanValue()) {
                    return fileResult.getGet();
                }
            }
            return objG;
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:38:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00f6, code lost:
    
        if (r10.emit(r11, r0) == r1) goto L41;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object startProcess(java.lang.String r10, ab.e<? super ua.k0> r11) {
        /*
            Method dump skipped, instruction units count: 255
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.s3.upload.UploadStatusDataSource.startProcess(java.lang.String, ab.e):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean startProcess$lambda$1$0(S3State s3State, S3State it) {
        y.i(it, "it");
        return y.d(it.getItemId(), s3State.getItemId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object upload(int i10, long j10, Status status, ab.e<? super k0> eVar) {
        Object objJ = te.j.j(te.j.g(te.j.f(te.j.e(new AnonymousClass2(n0.a(d1.b().plus(e2.b(null, 1, null))), status, this, i10, j10, new y0(), null))), new AnonymousClass3(null)), eVar);
        return objJ == bb.b.g() ? objJ : k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:8:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x009e, code lost:
    
        if (upload(r2, r7, r5, r6) == r0) goto L34;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object uploadStatus(java.lang.String r10, ab.e<? super ua.k0> r11) {
        /*
            r9 = this;
            boolean r0 = r11 instanceof cu.todus.android.s3.upload.UploadStatusDataSource.C11861
            if (r0 == 0) goto L14
            r0 = r11
            cu.todus.android.s3.upload.UploadStatusDataSource$uploadStatus$1 r0 = (cu.todus.android.s3.upload.UploadStatusDataSource.C11861) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.label = r1
        L12:
            r6 = r0
            goto L1a
        L14:
            cu.todus.android.s3.upload.UploadStatusDataSource$uploadStatus$1 r0 = new cu.todus.android.s3.upload.UploadStatusDataSource$uploadStatus$1
            r0.<init>(r11)
            goto L12
        L1a:
            java.lang.Object r11 = r6.result
            java.lang.Object r0 = bb.b.g()
            int r1 = r6.label
            r2 = 1
            r3 = 2
            if (r1 == 0) goto L47
            if (r1 == r2) goto L3f
            if (r1 != r3) goto L37
            java.lang.Object r10 = r6.L$1
            cu.todus.android.data.db.entity.toDus.Status r10 = (cu.todus.android.data.db.entity.toDus.Status) r10
            java.lang.Object r10 = r6.L$0
            java.lang.String r10 = (java.lang.String) r10
            ua.v.b(r11)
            goto La1
        L37:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L3f:
            java.lang.Object r10 = r6.L$0
            java.lang.String r10 = (java.lang.String) r10
            ua.v.b(r11)
            goto L5b
        L47:
            ua.v.b(r11)
            kotlin.jvm.functions.Function2 r11 = r9.getStatus
            java.lang.Object r1 = cb.l.a(r10)
            r6.L$0 = r1
            r6.label = r2
            java.lang.Object r11 = r11.invoke(r10, r6)
            if (r11 != r0) goto L5b
            goto La0
        L5b:
            r5 = r11
            cu.todus.android.data.db.entity.toDus.Status r5 = (cu.todus.android.data.db.entity.toDus.Status) r5
            if (r5 == 0) goto La4
            int r11 = r5.getUploadState()
            if (r11 != r3) goto La4
            cu.todus.android.data.db.pojo.content.Content r11 = r5.getContent()
            boolean r1 = r11 instanceof cu.todus.android.data.db.pojo.content.statusContent.StatusImageContent
            if (r1 == 0) goto L72
            r11 = 11
        L70:
            r2 = r11
            goto L7b
        L72:
            boolean r11 = r11 instanceof cu.todus.android.data.db.pojo.content.statusContent.StatusVideoContent
            if (r11 == 0) goto L79
            r11 = 10
            goto L70
        L79:
            r11 = 0
            goto L70
        L7b:
            cu.todus.android.data.db.pojo.content.Content r11 = r5.getContent()
            java.lang.String r1 = "null cannot be cast to non-null type cu.todus.android.data.db.pojo.content.FileContent"
            kotlin.jvm.internal.y.g(r11, r1)
            cu.todus.android.data.db.pojo.content.FileContent r11 = (cu.todus.android.data.db.pojo.content.FileContent) r11
            long r7 = r11.getSize()
            java.lang.Object r10 = cb.l.a(r10)
            r6.L$0 = r10
            java.lang.Object r10 = cb.l.a(r5)
            r6.L$1 = r10
            r6.label = r3
            r1 = r9
            r3 = r7
            java.lang.Object r10 = r1.upload(r2, r3, r5, r6)
            if (r10 != r0) goto La1
        La0:
            return r0
        La1:
            ua.k0 r10 = ua.k0.f43947a
            return r10
        La4:
            ua.k0 r10 = ua.k0.f43947a
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.s3.upload.UploadStatusDataSource.uploadStatus(java.lang.String, ab.e):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void upsertAttS3State(String msgId, AttS3State newAtt) {
        Object value;
        ArrayList arrayList;
        Object next;
        List listW0;
        b0 b0Var = this._uploadQueue;
        do {
            value = b0Var.getValue();
            List<S3State> list = (List) value;
            arrayList = new ArrayList(x.y(list, 10));
            for (S3State s3StateCopy$default : list) {
                if (y.d(s3StateCopy$default.getItemId(), msgId)) {
                    Iterator<T> it = s3StateCopy$default.getAttList().iterator();
                    do {
                        if (!it.hasNext()) {
                            next = null;
                            break;
                        }
                        next = it.next();
                    } while (!y.d(((AttS3State) next).getSubItemId(), newAtt.getSubItemId()));
                    if (((AttS3State) next) != null) {
                        List<AttS3State> attList = s3StateCopy$default.getAttList();
                        listW0 = new ArrayList(x.y(attList, 10));
                        for (AttS3State attS3State : attList) {
                            if (y.d(attS3State.getSubItemId(), newAtt.getSubItemId())) {
                                attS3State = newAtt;
                            }
                            listW0.add(attS3State);
                        }
                    } else {
                        listW0 = g0.W0(s3StateCopy$default.getAttList(), newAtt);
                    }
                    s3StateCopy$default = S3State.copy$default(s3StateCopy$default, null, false, listW0, null, 11, null);
                }
                arrayList.add(s3StateCopy$default);
            }
        } while (!b0Var.g(value, arrayList));
    }

    public final void cancelAll() {
        CoroutineUtilsKt.launchWithContext$default(this.coroutineScope, null, null, new AnonymousClass1(null), 3, null);
    }

    public final void cancelUpload(String statusId) {
        y.i(statusId, "statusId");
        CoroutineUtilsKt.launchWithContext$default(this.coroutineScope, null, null, new C11821(statusId, null), 3, null);
    }

    public final p0 getUploadQueue() {
        return this.uploadQueue;
    }

    public final void putStatusInUploadQueue(String statusId) {
        y.i(statusId, "statusId");
        CoroutineUtilsKt.launchWithContext$default(this.coroutineScope, null, null, new C11841(statusId, null), 3, null);
    }
}
