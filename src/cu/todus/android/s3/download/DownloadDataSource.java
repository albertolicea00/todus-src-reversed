package cu.todus.android.s3.download;

import ab.e;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.extractor.ts.TsExtractor;
import cb.d;
import cb.f;
import cb.m;
import cu.todus.android.data.db.entity.toDus.Attachment;
import cu.todus.android.data.db.pojo.content.Content;
import cu.todus.android.data.db.pojo.content.FileContent;
import cu.todus.android.notification.NotificationManager;
import cu.todus.android.s3.AttS3State;
import cu.todus.android.s3.S3State;
import cu.todus.android.utils.CoroutineUtilsKt;
import java.util.ArrayList;
import java.util.List;
import javax.net.ssl.SSLSession;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.u0;
import kotlin.jvm.internal.x0;
import kotlin.jvm.internal.y;
import kotlin.jvm.internal.y0;
import pe.d1;
import pe.e2;
import pe.k;
import pe.m0;
import pe.n0;
import re.u;
import te.b0;
import te.i;
import te.j;
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
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 .2\u00020\u0001:\u0001.Bw\u0012$\u0010\u0005\u001a \b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0002\u0012\"\u0010\b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0002\u0012$\u0010\t\u001a \b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u000f\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u0011\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0003H\u0082@¢\u0006\u0004\b\u0011\u0010\u0012J \u0010\u0014\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0003H\u0082@¢\u0006\u0004\b\u0014\u0010\u0015J \u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0003H\u0082@¢\u0006\u0004\b\u0017\u0010\u0018J\r\u0010\u0019\u001a\u00020\u0007¢\u0006\u0004\b\u0019\u0010\u001aJ\u001d\u0010\u001b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u001d\u0010\u001d\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0003¢\u0006\u0004\b\u001d\u0010\u001cJ\u0015\u0010\u001e\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0003¢\u0006\u0004\b\u001e\u0010\u001fR2\u0010\u0005\u001a \b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010 R0\u0010\b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010 R2\u0010\t\u001a \b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010 R\u0014\u0010\"\u001a\u00020!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R \u0010'\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020&0%0$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R#\u0010*\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020&0%0)8\u0006¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-¨\u0006/"}, d2 = {"Lcu/todus/android/s3/download/DownloadDataSource;", "", "Lkotlin/Function2;", "", "Lab/e;", "getGetUrl", "Lcu/todus/android/data/db/entity/toDus/Attachment;", "Lua/k0;", "updateAttachment", "getAttById", "<init>", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;)V", "attId", "Lcu/todus/android/s3/AttS3State;", "newAtt", "upsertAttS3State", "(Ljava/lang/String;Lcu/todus/android/s3/AttS3State;)V", "startProcess", "(Ljava/lang/String;Lab/e;)Ljava/lang/Object;", "folderPath", "downloadFile", "(Ljava/lang/String;Ljava/lang/String;Lab/e;)Ljava/lang/Object;", "attachment", "download", "(Lcu/todus/android/data/db/entity/toDus/Attachment;Ljava/lang/String;Lab/e;)Ljava/lang/Object;", "cancelAll", "()V", "checkMessageInDownloadQueueOrCanceled", "(Ljava/lang/String;Ljava/lang/String;)V", "putMessageInDownloadQueue", "cancelDownload", "(Ljava/lang/String;)V", "Lkotlin/jvm/functions/Function2;", "Lpe/m0;", "coroutineScope", "Lpe/m0;", "Lte/b0;", "", "Lcu/todus/android/s3/S3State;", "_downloadQueue", "Lte/b0;", "Lte/p0;", "downloadQueue", "Lte/p0;", "getDownloadQueue", "()Lte/p0;", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class DownloadDataSource {
    public static final String DOWNLOAD_DATA_SOURCE_TAG = "DOWNLOAD_V2_TAG";
    private final b0 _downloadQueue;
    private final m0 coroutineScope;
    private final p0 downloadQueue;
    private final Function2 getAttById;
    private final Function2 getGetUrl;
    private final Function2 updateAttachment;
    public static final int $stable = 8;

    /* JADX INFO: renamed from: cu.todus.android.s3.download.DownloadDataSource$cancelAll$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @f(c = "cu.todus.android.s3.download.DownloadDataSource$cancelAll$1", f = "DownloadDataSource.kt", l = {69, 68}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class AnonymousClass1 extends m implements Function1 {
        Object L$0;
        int label;

        public AnonymousClass1(e<? super AnonymousClass1> eVar) {
            super(1, eVar);
        }

        @Override // cb.a
        public final e<k0> create(e<?> eVar) {
            return DownloadDataSource.this.new AnonymousClass1(eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(e<? super k0> eVar) {
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
                cu.todus.android.s3.download.DownloadDataSource r13 = cu.todus.android.s3.download.DownloadDataSource.this
                te.b0 r1 = cu.todus.android.s3.download.DownloadDataSource.access$get_downloadQueue$p(r13)
                cu.todus.android.s3.download.DownloadDataSource r13 = cu.todus.android.s3.download.DownloadDataSource.this
                te.b0 r13 = cu.todus.android.s3.download.DownloadDataSource.access$get_downloadQueue$p(r13)
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
            throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.s3.download.DownloadDataSource.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.s3.download.DownloadDataSource$cancelDownload$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @f(c = "cu.todus.android.s3.download.DownloadDataSource$cancelDownload$1", f = "DownloadDataSource.kt", l = {}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C11731 extends m implements Function1 {
        final /* synthetic */ String $attId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C11731(String str, e<? super C11731> eVar) {
            super(1, eVar);
            this.$attId = str;
        }

        @Override // cb.a
        public final e<k0> create(e<?> eVar) {
            return DownloadDataSource.this.new C11731(this.$attId, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(e<? super k0> eVar) {
            return ((C11731) create(eVar)).invokeSuspend(k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object value;
            ArrayList arrayList;
            bb.b.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v.b(obj);
            b0 b0Var = DownloadDataSource.this._downloadQueue;
            String str = this.$attId;
            do {
                value = b0Var.getValue();
                List<S3State> list = (List) value;
                arrayList = new ArrayList(x.y(list, 10));
                for (S3State s3StateCopy$default : list) {
                    if (y.d(s3StateCopy$default.getItemId(), str)) {
                        s3StateCopy$default = S3State.copy$default(s3StateCopy$default, null, false, null, null, 13, null);
                    }
                    arrayList.add(s3StateCopy$default);
                }
            } while (!b0Var.g(value, arrayList));
            return k0.f43947a;
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.s3.download.DownloadDataSource$checkMessageInDownloadQueueOrCanceled$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @f(c = "cu.todus.android.s3.download.DownloadDataSource$checkMessageInDownloadQueueOrCanceled$1", f = "DownloadDataSource.kt", l = {122, 123, 124, TsExtractor.TS_STREAM_TYPE_HDMV_DTS, TsExtractor.TS_STREAM_TYPE_AC3, 133}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C11741 extends m implements Function1 {
        final /* synthetic */ String $attId;
        final /* synthetic */ String $folderPath;
        Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C11741(String str, String str2, e<? super C11741> eVar) {
            super(1, eVar);
            this.$attId = str;
            this.$folderPath = str2;
        }

        @Override // cb.a
        public final e<k0> create(e<?> eVar) {
            return DownloadDataSource.this.new C11741(this.$attId, this.$folderPath, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(e<? super k0> eVar) {
            return ((C11741) create(eVar)).invokeSuspend(k0.f43947a);
        }

        /* JADX WARN: Code duplicated, block: B:18:0x0071 A[PHI: r13
          0x0071: PHI (r13v8 java.lang.Object) = (r13v7 java.lang.Object), (r13v0 java.lang.Object) binds: [B:16:0x006d, B:10:0x0037] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:21:0x007f  */
        /* JADX WARN: Code duplicated, block: B:26:0x0094  */
        /* JADX WARN: Code duplicated, block: B:29:0x00a6 A[PHI: r13
          0x00a6: PHI (r13v14 java.lang.Object) = (r13v13 java.lang.Object), (r13v0 java.lang.Object) binds: [B:27:0x00a2, B:9:0x0032] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:31:0x00aa  */
        /* JADX WARN: Code duplicated, block: B:33:0x00b3  */
        /* JADX WARN: Code duplicated, block: B:40:0x00de  */
        /* JADX WARN: Code duplicated, block: B:44:0x0109  */
        /* JADX WARN: Code duplicated, block: B:50:0x0091 A[SYNTHETIC] */
        /* JADX WARN: Code restructure failed: missing block: B:46:0x011b, code lost:
        
            if (r13.startProcess(r2, r12) == r0) goto L47;
         */
        @Override // cb.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r13) {
            /*
                Method dump skipped, instruction units count: 308
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.s3.download.DownloadDataSource.C11741.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.s3.download.DownloadDataSource$download$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @f(c = "cu.todus.android.s3.download.DownloadDataSource$download$2", f = "DownloadDataSource.kt", l = {321, 329, 346, 585, 594}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lre/u;", "", "Lua/k0;", "<anonymous>", "(Lre/u;)V"}, k = 3, mv = {2, 3, 0})
    public static final class AnonymousClass2 extends m implements Function2 {
        final /* synthetic */ Attachment $attachment;
        final /* synthetic */ y0 $call;
        final /* synthetic */ String $contentName;
        final /* synthetic */ m0 $downloadScope;
        final /* synthetic */ String $folderPath;
        final /* synthetic */ u0 $isSuccess;
        final /* synthetic */ x0 $lastUIUpdateTime;
        final /* synthetic */ NotificationManager $sysNotifier;
        long J$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        final /* synthetic */ DownloadDataSource this$0;

        /* JADX INFO: renamed from: cu.todus.android.s3.download.DownloadDataSource$download$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        @f(c = "cu.todus.android.s3.download.DownloadDataSource$download$2$1", f = "DownloadDataSource.kt", l = {304, 305, 313}, m = "invokeSuspend", v = 2)
        @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
        public static final class AnonymousClass1 extends m implements Function1 {
            final /* synthetic */ u $$this$callbackFlow;
            final /* synthetic */ Attachment $attObj;
            final /* synthetic */ Attachment $attachment;
            final /* synthetic */ y0 $call;
            final /* synthetic */ m0 $downloadScope;
            final /* synthetic */ u0 $isSuccess;
            final /* synthetic */ NotificationManager $sysNotifier;
            int I$0;
            Object L$0;
            int label;
            final /* synthetic */ DownloadDataSource this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(DownloadDataSource downloadDataSource, Attachment attachment, Attachment attachment2, m0 m0Var, y0 y0Var, u0 u0Var, NotificationManager notificationManager, u uVar, e<? super AnonymousClass1> eVar) {
                super(1, eVar);
                this.this$0 = downloadDataSource;
                this.$attObj = attachment;
                this.$attachment = attachment2;
                this.$downloadScope = m0Var;
                this.$call = y0Var;
                this.$isSuccess = u0Var;
                this.$sysNotifier = notificationManager;
                this.$$this$callbackFlow = uVar;
            }

            @Override // cb.a
            public final e<k0> create(e<?> eVar) {
                return new AnonymousClass1(this.this$0, this.$attObj, this.$attachment, this.$downloadScope, this.$call, this.$isSuccess, this.$sysNotifier, this.$$this$callbackFlow, eVar);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(e<? super k0> eVar) {
                return ((AnonymousClass1) create(eVar)).invokeSuspend(k0.f43947a);
            }

            /* JADX WARN: Code duplicated, block: B:14:0x003b  */
            /* JADX WARN: Code duplicated, block: B:17:0x004a A[PHI: r2
              0x004a: PHI (r2v8 int) = (r2v9 int), (r2v11 int) binds: [B:15:0x0047, B:11:0x002f] A[DONT_GENERATE, DONT_INLINE]] */
            /* JADX WARN: Code duplicated, block: B:20:0x005b A[PHI: r2 r7
              0x005b: PHI (r2v2 int) = (r2v8 int), (r2v12 int) binds: [B:18:0x0058, B:10:0x0027] A[DONT_GENERATE, DONT_INLINE]
              0x005b: PHI (r7v0 java.lang.Object) = (r7v6 java.lang.Object), (r7v10 java.lang.Object) binds: [B:18:0x0058, B:10:0x0027] A[DONT_GENERATE, DONT_INLINE]] */
            /* JADX WARN: Code duplicated, block: B:23:0x0069  */
            /* JADX WARN: Code duplicated, block: B:29:0x0085  */
            /* JADX WARN: Code duplicated, block: B:30:0x0087  */
            /* JADX WARN: Code duplicated, block: B:32:0x008d  */
            /* JADX WARN: Code duplicated, block: B:35:0x00b5  */
            /* JADX WARN: Code duplicated, block: B:39:0x007f A[SYNTHETIC] */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x0085 -> B:13:0x0039). Please report as a decompilation issue!!! */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x008b -> B:13:0x0039). Please report as a decompilation issue!!! */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x00b5 -> B:36:0x00b6). Please report as a decompilation issue!!! */
            /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
                jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
                	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
                	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
                	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
                */
            @Override // cb.a
            public final java.lang.Object invokeSuspend(java.lang.Object r20) {
                /*
                    Method dump skipped, instruction units count: 204
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.s3.download.DownloadDataSource.AnonymousClass2.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Attachment attachment, m0 m0Var, String str, DownloadDataSource downloadDataSource, y0 y0Var, u0 u0Var, NotificationManager notificationManager, x0 x0Var, String str2, e<? super AnonymousClass2> eVar) {
            super(2, eVar);
            this.$attachment = attachment;
            this.$downloadScope = m0Var;
            this.$folderPath = str;
            this.this$0 = downloadDataSource;
            this.$call = y0Var;
            this.$isSuccess = u0Var;
            this.$sysNotifier = notificationManager;
            this.$lastUIUpdateTime = x0Var;
            this.$contentName = str2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invokeSuspend$close(m0 m0Var, y0 y0Var, DownloadDataSource downloadDataSource, u0 u0Var, NotificationManager notificationManager, Attachment attachment, u uVar) {
            k.d(m0Var, null, null, new DownloadDataSource$download$2$close$1(y0Var, downloadDataSource, u0Var, notificationManager, attachment, uVar, null), 3, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean invokeSuspend$lambda$1$0$0(String str, SSLSession sSLSession) {
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final k0 invokeSuspend$lambda$2(m0 m0Var) {
            n0.d(m0Var, null, 1, null);
            return k0.f43947a;
        }

        @Override // cb.a
        public final e<k0> create(Object obj, e<?> eVar) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$attachment, this.$downloadScope, this.$folderPath, this.this$0, this.$call, this.$isSuccess, this.$sysNotifier, this.$lastUIUpdateTime, this.$contentName, eVar);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        /* JADX WARN: Code duplicated, block: B:54:0x03b7  */
        /* JADX WARN: Code duplicated, block: B:63:0x0419  */
        /* JADX WARN: Code duplicated, block: B:64:0x0421  */
        /* JADX WARN: Code duplicated, block: B:67:0x0429  */
        /* JADX WARN: Code duplicated, block: B:79:0x04be  */
        /* JADX WARN: Code duplicated, block: B:82:0x0503  */
        /* JADX WARN: Code duplicated, block: B:94:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Code restructure failed: missing block: B:73:0x0496, code lost:
        
            if (r7.invoke(r2, r44) == r3) goto L46;
         */
        /* JADX WARN: Instruction removed from duplicated block: B:82:0x0503, please report this as an issue */
        @Override // cb.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r45) {
            /*
                Method dump skipped, instruction units count: 1587
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.s3.download.DownloadDataSource.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(u uVar, e<? super k0> eVar) {
            return ((AnonymousClass2) create(uVar, eVar)).invokeSuspend(k0.f43947a);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.s3.download.DownloadDataSource$download$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @f(c = "cu.todus.android.s3.download.DownloadDataSource$download$3", f = "DownloadDataSource.kt", l = {}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004*\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lte/i;", "", "", "it", "Lua/k0;", "<anonymous>", "(Lte/i;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 3, 0})
    public static final class AnonymousClass3 extends m implements Function3 {
        /* synthetic */ Object L$0;
        int label;

        public AnonymousClass3(e<? super AnonymousClass3> eVar) {
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
        public final Object invoke(i iVar, Throwable th2, e<? super k0> eVar) {
            AnonymousClass3 anonymousClass3 = new AnonymousClass3(eVar);
            anonymousClass3.L$0 = th2;
            return anonymousClass3.invokeSuspend(k0.f43947a);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.s3.download.DownloadDataSource$downloadFile$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @f(c = "cu.todus.android.s3.download.DownloadDataSource", f = "DownloadDataSource.kt", l = {162, 205}, m = "downloadFile", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C11751 extends d {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C11751(e<? super C11751> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DownloadDataSource.this.downloadFile(null, null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.s3.download.DownloadDataSource$putMessageInDownloadQueue$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @f(c = "cu.todus.android.s3.download.DownloadDataSource$putMessageInDownloadQueue$1", f = "DownloadDataSource.kt", l = {144, 145, 148, 147, 151}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C11761 extends m implements Function1 {
        final /* synthetic */ String $attId;
        final /* synthetic */ String $folderPath;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C11761(String str, String str2, e<? super C11761> eVar) {
            super(1, eVar);
            this.$attId = str;
            this.$folderPath = str2;
        }

        @Override // cb.a
        public final e<k0> create(e<?> eVar) {
            return DownloadDataSource.this.new C11761(this.$attId, this.$folderPath, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(e<? super k0> eVar) {
            return ((C11761) create(eVar)).invokeSuspend(k0.f43947a);
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
            throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.s3.download.DownloadDataSource.C11761.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.s3.download.DownloadDataSource$startProcess$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @f(c = "cu.todus.android.s3.download.DownloadDataSource", f = "DownloadDataSource.kt", l = {TypedValues.TYPE_TARGET, 106, 110, AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY}, m = "startProcess", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C11771 extends d {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C11771(e<? super C11771> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DownloadDataSource.this.startProcess(null, this);
        }
    }

    public DownloadDataSource(Function2 getGetUrl, Function2 updateAttachment, Function2 getAttById) {
        y.i(getGetUrl, "getGetUrl");
        y.i(updateAttachment, "updateAttachment");
        y.i(getAttById, "getAttById");
        this.getGetUrl = getGetUrl;
        this.updateAttachment = updateAttachment;
        this.getAttById = getAttById;
        this.coroutineScope = n0.a(d1.b().plus(e2.b(null, 1, null)));
        b0 b0VarA = r0.a(w.n());
        this._downloadQueue = b0VarA;
        this.downloadQueue = j.b(b0VarA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object download(Attachment attachment, String str, e<? super k0> eVar) {
        String name;
        m0 m0VarA = n0.a(d1.b().plus(e2.b(null, 1, null)));
        y0 y0Var = new y0();
        x0 x0Var = new x0();
        u0 u0Var = new u0();
        Content content = attachment.getContent();
        FileContent fileContent = content instanceof FileContent ? (FileContent) content : null;
        if (fileContent == null || (name = fileContent.getName()) == null) {
            name = "Archivo";
        }
        Object objJ = j.j(j.g(j.f(j.e(new AnonymousClass2(attachment, m0VarA, str, this, y0Var, u0Var, NotificationManager.INSTANCE.getInstance(), x0Var, name, null))), new AnonymousClass3(null)), eVar);
        return objJ == bb.b.g() ? objJ : k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:42:0x0131  */
    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0173, code lost:
    
        if (download(r2, r1, r3) == r4) goto L51;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object downloadFile(java.lang.String r20, java.lang.String r21, ab.e<? super ua.k0> r22) {
        /*
            Method dump skipped, instruction units count: 380
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.s3.download.DownloadDataSource.downloadFile(java.lang.String, java.lang.String, ab.e):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:38:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00fa, code lost:
    
        if (r11.emit(r12, r0) == r1) goto L41;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object startProcess(java.lang.String r11, ab.e<? super ua.k0> r12) {
        /*
            Method dump skipped, instruction units count: 259
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.s3.download.DownloadDataSource.startProcess(java.lang.String, ab.e):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean startProcess$lambda$1$0(S3State s3State, S3State it) {
        y.i(it, "it");
        return y.d(it.getItemId(), s3State.getItemId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void upsertAttS3State(String attId, AttS3State newAtt) {
        Object value;
        ArrayList arrayList;
        List listW0;
        b0 b0Var = this._downloadQueue;
        do {
            value = b0Var.getValue();
            List<S3State> list = (List) value;
            arrayList = new ArrayList(x.y(list, 10));
            for (S3State s3StateCopy$default : list) {
                if (y.d(s3StateCopy$default.getItemId(), attId)) {
                    if (((AttS3State) g0.y0(s3StateCopy$default.getAttList())) != null) {
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

    public final void cancelDownload(String attId) {
        y.i(attId, "attId");
        CoroutineUtilsKt.launchWithContext$default(this.coroutineScope, null, null, new C11731(attId, null), 3, null);
    }

    public final void checkMessageInDownloadQueueOrCanceled(String attId, String folderPath) {
        y.i(attId, "attId");
        y.i(folderPath, "folderPath");
        CoroutineUtilsKt.launchWithContext$default(this.coroutineScope, null, null, new C11741(attId, folderPath, null), 3, null);
    }

    public final p0 getDownloadQueue() {
        return this.downloadQueue;
    }

    public final void putMessageInDownloadQueue(String attId, String folderPath) {
        y.i(attId, "attId");
        y.i(folderPath, "folderPath");
        CoroutineUtilsKt.launchWithContext$default(this.coroutineScope, null, null, new C11761(attId, folderPath, null), 3, null);
    }
}
