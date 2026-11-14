package cu.todus.android.s3.upload;

import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.media3.extractor.ts.PsExtractor;
import androidx.media3.muxer.WebmConstants;
import cb.l;
import cb.m;
import cu.todus.android.data.db.entity.toDus.Attachment;
import cu.todus.android.data.db.entity.toDus.Room;
import cu.todus.android.data.db.pojo.content.AudioContent;
import cu.todus.android.data.db.pojo.content.Content;
import cu.todus.android.data.db.pojo.content.FileContent;
import cu.todus.android.data.db.pojo.content.GifContent;
import cu.todus.android.data.db.pojo.content.ImageContent;
import cu.todus.android.data.db.pojo.content.VideoContent;
import cu.todus.android.data.db.pojo.content.VoiceContent;
import cu.todus.android.data.xmpp.FileResponse;
import cu.todus.android.di.RetrofitModule;
import cu.todus.android.notification.NotificationManager;
import cu.todus.android.rest.TokenAuthenticator;
import cu.todus.android.s3.AttS3State;
import cu.todus.android.s3.S3State;
import cu.todus.android.utils.CoroutineUtilsKt;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.u0;
import kotlin.jvm.internal.x0;
import kotlin.jvm.internal.y;
import kotlin.jvm.internal.y0;
import lb.o;
import nf.a0;
import nf.c0;
import nf.e0;
import nf.f0;
import nf.g0;
import pe.a2;
import pe.d1;
import pe.e2;
import pe.k;
import pe.m0;
import pe.n0;
import re.s;
import re.u;
import te.b0;
import te.p0;
import te.r0;
import ua.k0;
import ua.n;
import ua.v;
import va.w;
import va.x;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 42\u00020\u0001:\u00014B±\u0001\u00120\u0010\b\u001a,\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0002\u0012\"\u0010\f\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\t\u0012(\u0010\u000e\u001a$\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\r0\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\t\u0012(\u0010\u0010\u001a$\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0018\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0003H\u0082@¢\u0006\u0004\b\u0018\u0010\u0019J\u0018\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0003H\u0082@¢\u0006\u0004\b\u001a\u0010\u0019J(\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\nH\u0082@¢\u0006\u0004\b\u001e\u0010\u001fJ\r\u0010 \u001a\u00020\u000b¢\u0006\u0004\b \u0010!J\u0015\u0010\"\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0003¢\u0006\u0004\b\"\u0010#J\u0015\u0010$\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0003¢\u0006\u0004\b$\u0010#R>\u0010\b\u001a,\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010%R0\u0010\f\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010&R6\u0010\u000e\u001a$\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\r0\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010&R6\u0010\u0010\u001a$\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010'R\u0014\u0010)\u001a\u00020(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R \u0010-\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020,0\r0+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.R#\u00100\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020,0\r0/8\u0006¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103¨\u00065"}, d2 = {"Lcu/todus/android/s3/upload/UploadDataSource;", "", "Lkotlin/Function4;", "", "", "", "Lab/e;", "Lcu/todus/android/data/xmpp/FileResponse$FileResult;", "getPutUrl", "Lkotlin/Function2;", "Lcu/todus/android/data/db/entity/toDus/Attachment;", "Lua/k0;", "updateAttachment", "", "getAttachments", "Lkotlin/Function3;", "updateMsgStatus", "<init>", "(Llb/o;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;)V", Room.COLUMN_LAST_MSG, "Lcu/todus/android/s3/AttS3State;", "newAtt", "upsertAttS3State", "(Ljava/lang/String;Lcu/todus/android/s3/AttS3State;)V", "startProcess", "(Ljava/lang/String;Lab/e;)Ljava/lang/Object;", "uploadMessage", "cloudType", "totalSize", "attachment", "upload", "(IJLcu/todus/android/data/db/entity/toDus/Attachment;Lab/e;)Ljava/lang/Object;", "cancelAll", "()V", "enqueueUpload", "(Ljava/lang/String;)V", "cancelUpload", "Llb/o;", "Lkotlin/jvm/functions/Function2;", "Lkotlin/jvm/functions/Function3;", "Lpe/m0;", "coroutineScope", "Lpe/m0;", "Lte/b0;", "Lcu/todus/android/s3/S3State;", "_uploadQueue", "Lte/b0;", "Lte/p0;", "uploadQueue", "Lte/p0;", "getUploadQueue", "()Lte/p0;", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class UploadDataSource {
    public static final String UPLOAD_DATA_SOURCE_TAG = "UPLOAD_V2_TAG";
    private final b0 _uploadQueue;
    private final m0 coroutineScope;
    private final Function2 getAttachments;
    private final o getPutUrl;
    private final Function2 updateAttachment;
    private final Function3 updateMsgStatus;
    private final p0 uploadQueue;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private static final n sharedHttpClient$delegate = ua.o.a(new lb.a() { // from class: cu.todus.android.s3.upload.c
        @Override // lb.a
        public final Object invoke() {
            return UploadDataSource.sharedHttpClient_delegate$lambda$0();
        }
    });

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0086@¢\u0006\u0004\b\b\u0010\tR\u001b\u0010\u000f\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcu/todus/android/s3/upload/UploadDataSource$Companion;", "", "<init>", "()V", "", "urlPath", "filePath", "", "directUpload", "(Ljava/lang/String;Ljava/lang/String;Lab/e;)Ljava/lang/Object;", "Lnf/c0;", "sharedHttpClient$delegate", "Lua/n;", "getSharedHttpClient", "()Lnf/c0;", "sharedHttpClient", "UPLOAD_DATA_SOURCE_TAG", "Ljava/lang/String;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(p pVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final c0 getSharedHttpClient() {
            return (c0) UploadDataSource.sharedHttpClient$delegate.getValue();
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0017  */
        public final Object directUpload(String str, String str2, ab.e<? super Boolean> eVar) {
            UploadDataSource$Companion$directUpload$1 uploadDataSource$Companion$directUpload$1;
            DirectUploadState directUploadState;
            if (eVar instanceof UploadDataSource$Companion$directUpload$1) {
                uploadDataSource$Companion$directUpload$1 = (UploadDataSource$Companion$directUpload$1) eVar;
                int i10 = uploadDataSource$Companion$directUpload$1.label;
                if ((i10 & Integer.MIN_VALUE) != 0) {
                    uploadDataSource$Companion$directUpload$1.label = i10 - Integer.MIN_VALUE;
                } else {
                    uploadDataSource$Companion$directUpload$1 = new UploadDataSource$Companion$directUpload$1(this, eVar);
                }
            } else {
                uploadDataSource$Companion$directUpload$1 = new UploadDataSource$Companion$directUpload$1(this, eVar);
            }
            Object obj = uploadDataSource$Companion$directUpload$1.result;
            Object objG = bb.b.g();
            int i11 = uploadDataSource$Companion$directUpload$1.label;
            if (i11 == 0) {
                v.b(obj);
                m0 m0VarA = n0.a(d1.b().plus(e2.b(null, 1, null)));
                DirectUploadState directUploadState2 = new DirectUploadState(0L, 0L, 0.0f, 0.0f, 0, 31, null);
                URL url = new URL(str);
                File file = new File(str2);
                DirectUploadCallbackFlow directUploadCallbackFlow = new DirectUploadCallbackFlow(url, file, directUploadState2, m0VarA, null, 16, null);
                te.h callbackFlow = directUploadCallbackFlow.getCallbackFlow();
                UploadDataSource$Companion$directUpload$2 uploadDataSource$Companion$directUpload$2 = new UploadDataSource$Companion$directUpload$2(m0VarA);
                uploadDataSource$Companion$directUpload$1.L$0 = l.a(str);
                uploadDataSource$Companion$directUpload$1.L$1 = l.a(str2);
                uploadDataSource$Companion$directUpload$1.L$2 = l.a(m0VarA);
                uploadDataSource$Companion$directUpload$1.L$3 = directUploadState2;
                uploadDataSource$Companion$directUpload$1.L$4 = l.a(url);
                uploadDataSource$Companion$directUpload$1.L$5 = l.a(file);
                uploadDataSource$Companion$directUpload$1.L$6 = l.a(directUploadCallbackFlow);
                uploadDataSource$Companion$directUpload$1.label = 1;
                if (callbackFlow.collect(uploadDataSource$Companion$directUpload$2, uploadDataSource$Companion$directUpload$1) == objG) {
                    return objG;
                }
                directUploadState = directUploadState2;
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                directUploadState = (DirectUploadState) uploadDataSource$Companion$directUpload$1.L$3;
                v.b(obj);
            }
            return cb.b.a(directUploadState.getStatus() == 2);
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.s3.upload.UploadDataSource$cancelAll$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.s3.upload.UploadDataSource$cancelAll$1", f = "UploadDataSource.kt", l = {113, 112}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class AnonymousClass1 extends m implements Function1 {
        Object L$0;
        int label;

        public AnonymousClass1(ab.e<? super AnonymousClass1> eVar) {
            super(1, eVar);
        }

        @Override // cb.a
        public final ab.e<k0> create(ab.e<?> eVar) {
            return UploadDataSource.this.new AnonymousClass1(eVar);
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
                cu.todus.android.s3.upload.UploadDataSource r13 = cu.todus.android.s3.upload.UploadDataSource.this
                te.b0 r1 = cu.todus.android.s3.upload.UploadDataSource.access$get_uploadQueue$p(r13)
                cu.todus.android.s3.upload.UploadDataSource r13 = cu.todus.android.s3.upload.UploadDataSource.this
                te.b0 r13 = cu.todus.android.s3.upload.UploadDataSource.access$get_uploadQueue$p(r13)
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
            throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.s3.upload.UploadDataSource.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.s3.upload.UploadDataSource$cancelUpload$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.s3.upload.UploadDataSource$cancelUpload$1", f = "UploadDataSource.kt", l = {446, 445}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C11781 extends m implements Function1 {
        final /* synthetic */ String $msgId;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C11781(String str, ab.e<? super C11781> eVar) {
            super(1, eVar);
            this.$msgId = str;
        }

        @Override // cb.a
        public final ab.e<k0> create(ab.e<?> eVar) {
            return UploadDataSource.this.new C11781(this.$msgId, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super k0> eVar) {
            return ((C11781) create(eVar)).invokeSuspend(k0.f43947a);
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
                cu.todus.android.s3.upload.UploadDataSource r14 = cu.todus.android.s3.upload.UploadDataSource.this
                te.b0 r1 = cu.todus.android.s3.upload.UploadDataSource.access$get_uploadQueue$p(r14)
                cu.todus.android.s3.upload.UploadDataSource r14 = cu.todus.android.s3.upload.UploadDataSource.this
                te.b0 r14 = cu.todus.android.s3.upload.UploadDataSource.access$get_uploadQueue$p(r14)
                r13.L$0 = r1
                r13.label = r3
                java.lang.Object r14 = te.j.x(r14, r13)
                if (r14 != r0) goto L3c
                goto L80
            L3c:
                java.lang.Iterable r14 = (java.lang.Iterable) r14
                java.lang.String r3 = r13.$msgId
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
            throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.s3.upload.UploadDataSource.C11781.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.s3.upload.UploadDataSource$enqueueUpload$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.s3.upload.UploadDataSource$enqueueUpload$1", f = "UploadDataSource.kt", l = {WebmConstants.MkvEbmlElement.BLOCK_DURATION, WebmConstants.MkvEbmlElement.BLOCK_MORE}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C11791 extends m implements Function1 {
        final /* synthetic */ String $msgId;
        Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C11791(String str, ab.e<? super C11791> eVar) {
            super(1, eVar);
            this.$msgId = str;
        }

        @Override // cb.a
        public final ab.e<k0> create(ab.e<?> eVar) {
            return UploadDataSource.this.new C11791(this.$msgId, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super k0> eVar) {
            return ((C11791) create(eVar)).invokeSuspend(k0.f43947a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:31:0x00b0, code lost:
        
            if (r15.startProcess(r2, r14) == r0) goto L32;
         */
        @Override // cb.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r15) {
            /*
                Method dump skipped, instruction units count: 213
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.s3.upload.UploadDataSource.C11791.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.s3.upload.UploadDataSource$startProcess$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.s3.upload.UploadDataSource", f = "UploadDataSource.kt", l = {141, 146}, m = "startProcess", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C11801 extends cb.d {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C11801(ab.e<? super C11801> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return UploadDataSource.this.startProcess(null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.s3.upload.UploadDataSource$upload$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.s3.upload.UploadDataSource$upload$2", f = "UploadDataSource.kt", l = {276, 321, 435}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lre/u;", "", "Lua/k0;", "<anonymous>", "(Lre/u;)V"}, k = 3, mv = {2, 3, 0})
    public static final class AnonymousClass2 extends m implements Function2 {
        final /* synthetic */ Attachment $attachment;
        final /* synthetic */ y0 $call;
        final /* synthetic */ int $cloudType;
        final /* synthetic */ String $contentName;
        final /* synthetic */ m0 $downloadScope;
        final /* synthetic */ u0 $isSuccess;
        final /* synthetic */ x0 $lastUIUpdateTime;
        final /* synthetic */ NotificationManager $notifManager;
        final /* synthetic */ long $totalSize;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        final /* synthetic */ UploadDataSource this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(m0 m0Var, UploadDataSource uploadDataSource, int i10, long j10, Attachment attachment, y0 y0Var, u0 u0Var, NotificationManager notificationManager, x0 x0Var, String str, ab.e<? super AnonymousClass2> eVar) {
            super(2, eVar);
            this.$downloadScope = m0Var;
            this.this$0 = uploadDataSource;
            this.$cloudType = i10;
            this.$totalSize = j10;
            this.$attachment = attachment;
            this.$call = y0Var;
            this.$isSuccess = u0Var;
            this.$notifManager = notificationManager;
            this.$lastUIUpdateTime = x0Var;
            this.$contentName = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invokeSuspend$close(m0 m0Var, u uVar, y0 y0Var, u0 u0Var, NotificationManager notificationManager, Attachment attachment) {
            k.d(m0Var, null, null, new UploadDataSource$upload$2$close$1(uVar, y0Var, u0Var, notificationManager, attachment, null), 3, null);
        }

        @Override // cb.a
        public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$downloadScope, this.this$0, this.$cloudType, this.$totalSize, this.$attachment, this.$call, this.$isSuccess, this.$notifManager, this.$lastUIUpdateTime, this.$contentName, eVar);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        /* JADX WARN: Code duplicated, block: B:49:? A[RETURN, SYNTHETIC] */
        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            a2 a2VarLaunchWithContext$default;
            Object objInvoke;
            a2 a2Var;
            FileResponse.FileResult fileResult;
            int i10;
            final u uVar;
            Content contentRebuild$default;
            Attachment attachmentCopy$default;
            a2 a2Var2;
            FileResponse.FileResult fileResult2;
            lb.a aVar;
            u uVar2 = (u) this.L$0;
            Object objG = bb.b.g();
            int i11 = this.label;
            if (i11 == 0) {
                v.b(obj);
                m0 m0Var = this.$downloadScope;
                a2VarLaunchWithContext$default = CoroutineUtilsKt.launchWithContext$default(m0Var, null, null, new UploadDataSource$upload$2$cancelWatcherJob$1(this.this$0, uVar2, this.$attachment, m0Var, this.$call, this.$isSuccess, this.$notifManager, null), 3, null);
                o oVar = this.this$0.getPutUrl;
                Integer numD = cb.b.d(this.$cloudType);
                Long lE = cb.b.e(this.$totalSize);
                this.L$0 = uVar2;
                this.L$1 = a2VarLaunchWithContext$default;
                this.label = 1;
                objInvoke = oVar.invoke("", numD, lE, this);
                if (objInvoke != objG) {
                }
                uVar2 = uVar2;
                return objG;
            }
            if (i11 == 1) {
                a2VarLaunchWithContext$default = (a2) this.L$1;
                v.b(obj);
                objInvoke = obj;
            } else if (i11 == 2) {
                attachmentCopy$default = (Attachment) this.L$3;
                FileResponse.FileResult fileResult3 = (FileResponse.FileResult) this.L$2;
                a2 a2Var3 = (a2) this.L$1;
                v.b(obj);
                fileResult2 = fileResult3;
                a2Var2 = a2Var3;
                final Attachment attachment = attachmentCopy$default;
                f0 f0VarB = f0.f38560a.b(new File(((FileContent) this.$attachment.getContent()).getPath()), a0.f38429e.b("application/octet-stream"));
                final u uVar3 = uVar2;
                final UploadDataSource uploadDataSource = this.this$0;
                final Attachment attachment2 = this.$attachment;
                final m0 m0Var2 = this.$downloadScope;
                final x0 x0Var = this.$lastUIUpdateTime;
                final NotificationManager notificationManager = this.$notifManager;
                final String str = this.$contentName;
                final long j10 = this.$totalSize;
                io.github.lizhangqu.coreprogress.d dVar = new io.github.lizhangqu.coreprogress.d() { // from class: cu.todus.android.s3.upload.UploadDataSource$upload$2$requestBody$1
                    @Override // io.github.lizhangqu.coreprogress.d
                    public void onProgressChanged(long numBytes, long totalBytes, float percent, float speed) {
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        x0 x0Var2 = x0Var;
                        if (jCurrentTimeMillis - x0Var2.f36633c > 500) {
                            x0Var2.f36633c = jCurrentTimeMillis;
                            notificationManager.showUploadProgress(attachment2.getMsg(), attachment2.getId(), str, numBytes, j10, false);
                        }
                        uploadDataSource.upsertAttS3State(attachment2.getMsg(), new AttS3State(attachment2.getId(), numBytes, totalBytes));
                        k.d(m0Var2, null, null, new UploadDataSource$upload$2$requestBody$1$onProgressChanged$1(uVar3, null), 3, null);
                    }

                    @Override // io.github.lizhangqu.coreprogress.d
                    public void onProgressFinish() {
                        super.onProgressFinish();
                    }

                    @Override // io.github.lizhangqu.coreprogress.d
                    public void onProgressStart(long totalBytes) {
                        super.onProgressStart(totalBytes);
                        uploadDataSource.upsertAttS3State(attachment2.getMsg(), new AttS3State(attachment2.getId(), 0L, totalBytes));
                        k.d(m0Var2, null, null, new UploadDataSource$upload$2$requestBody$1$onProgressStart$1(uVar3, null), 3, null);
                    }
                };
                uVar = uVar3;
                f0 f0VarA = io.github.lizhangqu.coreprogress.b.a(f0VarB, dVar);
                e0.a aVarT = new e0.a().t(new URL(fileResult2.getPut()));
                y.f(f0VarA);
                this.$call.f36634c = UploadDataSource.INSTANCE.getSharedHttpClient().a(aVarT.o(f0VarA).b());
                final y0 y0Var = this.$call;
                nf.e eVar = (nf.e) y0Var.f36634c;
                final m0 m0Var3 = this.$downloadScope;
                final u0 u0Var = this.$isSuccess;
                final NotificationManager notificationManager2 = this.$notifManager;
                final Attachment attachment3 = this.$attachment;
                final String str2 = this.$contentName;
                final long j11 = this.$totalSize;
                final a2 a2Var4 = a2Var2;
                final UploadDataSource uploadDataSource2 = this.this$0;
                i10 = 3;
                eVar.j(new nf.f() { // from class: cu.todus.android.s3.upload.UploadDataSource.upload.2.1
                    @Override // nf.f
                    public void onFailure(nf.e call, IOException e10) {
                        y.i(call, "call");
                        y.i(e10, "e");
                        m0 m0Var4 = m0Var3;
                        k.d(m0Var4, null, null, new UploadDataSource$upload$2$1$onFailure$1(a2Var4, uVar, m0Var4, y0Var, u0Var, notificationManager2, attachment3, null), 3, null);
                    }

                    @Override // nf.f
                    public void onResponse(nf.e call, g0 response) throws IOException {
                        y.i(call, "call");
                        y.i(response, "response");
                        response.j();
                        m0 m0Var4 = m0Var3;
                        k.d(m0Var4, null, null, new UploadDataSource$upload$2$1$onResponse$1(a2Var4, response, uVar, u0Var, notificationManager2, attachment3, str2, j11, uploadDataSource2, attachment, m0Var4, y0Var, null), 3, null);
                    }
                });
                a2Var = a2Var4;
                fileResult = fileResult2;
                aVar = new lb.a() { // from class: cu.todus.android.s3.upload.f
                    @Override // lb.a
                    public final Object invoke() {
                        return k0.f43947a;
                    }
                };
                this.L$0 = l.a(uVar);
                this.L$1 = l.a(a2Var);
                this.L$2 = l.a(fileResult);
                this.L$3 = null;
                this.label = i10;
                if (s.a(uVar, aVar, this) == objG) {
                    return objG;
                }
            } else {
                if (i11 != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v.b(obj);
            }
            return k0.f43947a;
            uVar2 = uVar2;
            a2Var = a2VarLaunchWithContext$default;
            fileResult = (FileResponse.FileResult) objInvoke;
            if (fileResult != null) {
                fileResult.getPut();
            }
            if (fileResult != null && !fileResult.getWasError()) {
                Attachment attachment4 = this.$attachment;
                int type = attachment4.getType();
                if (type == 1) {
                    Content content = this.$attachment.getContent();
                    y.g(content, "null cannot be cast to non-null type cu.todus.android.data.db.pojo.content.ImageContent");
                    contentRebuild$default = ImageContent.rebuild$default((ImageContent) content, ((ImageContent) this.$attachment.getContent()).getThumbnail(), ((ImageContent) this.$attachment.getContent()).getWidth(), ((ImageContent) this.$attachment.getContent()).getHeight(), null, null, fileResult.getGet(), 0L, null, 216, null);
                } else if (type == 2) {
                    Content content2 = this.$attachment.getContent();
                    y.g(content2, "null cannot be cast to non-null type cu.todus.android.data.db.pojo.content.VideoContent");
                    contentRebuild$default = VideoContent.rebuild$default((VideoContent) content2, ((VideoContent) this.$attachment.getContent()).getThumbnail(), ((VideoContent) this.$attachment.getContent()).getDuration(), ((VideoContent) this.$attachment.getContent()).getWidth(), ((VideoContent) this.$attachment.getContent()).getHeight(), null, null, fileResult.getGet(), 0L, null, 432, null);
                } else if (type == 3) {
                    Content content3 = this.$attachment.getContent();
                    y.g(content3, "null cannot be cast to non-null type cu.todus.android.data.db.pojo.content.AudioContent");
                    contentRebuild$default = AudioContent.rebuild$default((AudioContent) content3, ((AudioContent) this.$attachment.getContent()).getDuration(), (String) null, (String) null, fileResult.getGet(), 0L, (String) null, 54, (Object) null);
                } else if (type == 4) {
                    Content content4 = this.$attachment.getContent();
                    y.g(content4, "null cannot be cast to non-null type cu.todus.android.data.db.pojo.content.VoiceContent");
                    contentRebuild$default = VoiceContent.rebuild$default((VoiceContent) content4, ((VoiceContent) this.$attachment.getContent()).getDuration(), ((VoiceContent) this.$attachment.getContent()).getWaveSample(), (String) null, fileResult.getGet(), 0L, (String) null, 52, (Object) null);
                } else if (type != 7) {
                    Content content5 = this.$attachment.getContent();
                    y.g(content5, "null cannot be cast to non-null type cu.todus.android.data.db.pojo.content.FileContent");
                    contentRebuild$default = FileContent.rebuild$default((FileContent) content5, null, null, fileResult.getGet(), 0L, null, 0, 59, null);
                } else {
                    Content content6 = this.$attachment.getContent();
                    y.g(content6, "null cannot be cast to non-null type cu.todus.android.data.db.pojo.content.GifContent");
                    contentRebuild$default = GifContent.rebuild$default((GifContent) content6, ((GifContent) this.$attachment.getContent()).getThumbnail(), ((GifContent) this.$attachment.getContent()).getWidth(), ((GifContent) this.$attachment.getContent()).getHeight(), null, null, fileResult.getGet(), 0L, null, 216, null);
                }
                attachmentCopy$default = Attachment.copy$default(attachment4, null, null, contentRebuild$default, 0, 0, false, 59, null);
                Function2 function2 = this.this$0.updateAttachment;
                this.L$0 = uVar2;
                this.L$1 = a2Var;
                this.L$2 = fileResult;
                this.L$3 = attachmentCopy$default;
                this.label = 2;
                if (function2.invoke(attachmentCopy$default, this) != objG) {
                    a2Var2 = a2Var;
                    fileResult2 = fileResult;
                    final Attachment attachment5 = attachmentCopy$default;
                    f0 f0VarB2 = f0.f38560a.b(new File(((FileContent) this.$attachment.getContent()).getPath()), a0.f38429e.b("application/octet-stream"));
                    final u uVar4 = uVar2;
                    final UploadDataSource uploadDataSource3 = this.this$0;
                    final Attachment attachment6 = this.$attachment;
                    final m0 m0Var4 = this.$downloadScope;
                    final x0 x0Var2 = this.$lastUIUpdateTime;
                    final NotificationManager notificationManager3 = this.$notifManager;
                    final String str3 = this.$contentName;
                    final long j12 = this.$totalSize;
                    io.github.lizhangqu.coreprogress.d dVar2 = new io.github.lizhangqu.coreprogress.d() { // from class: cu.todus.android.s3.upload.UploadDataSource$upload$2$requestBody$1
                        @Override // io.github.lizhangqu.coreprogress.d
                        public void onProgressChanged(long numBytes, long totalBytes, float percent, float speed) {
                            long jCurrentTimeMillis = System.currentTimeMillis();
                            x0 x0Var3 = x0Var2;
                            if (jCurrentTimeMillis - x0Var3.f36633c > 500) {
                                x0Var3.f36633c = jCurrentTimeMillis;
                                notificationManager3.showUploadProgress(attachment6.getMsg(), attachment6.getId(), str3, numBytes, j12, false);
                            }
                            uploadDataSource3.upsertAttS3State(attachment6.getMsg(), new AttS3State(attachment6.getId(), numBytes, totalBytes));
                            k.d(m0Var4, null, null, new UploadDataSource$upload$2$requestBody$1$onProgressChanged$1(uVar4, null), 3, null);
                        }

                        @Override // io.github.lizhangqu.coreprogress.d
                        public void onProgressFinish() {
                            super.onProgressFinish();
                        }

                        @Override // io.github.lizhangqu.coreprogress.d
                        public void onProgressStart(long totalBytes) {
                            super.onProgressStart(totalBytes);
                            uploadDataSource3.upsertAttS3State(attachment6.getMsg(), new AttS3State(attachment6.getId(), 0L, totalBytes));
                            k.d(m0Var4, null, null, new UploadDataSource$upload$2$requestBody$1$onProgressStart$1(uVar4, null), 3, null);
                        }
                    };
                    uVar = uVar4;
                    f0 f0VarA2 = io.github.lizhangqu.coreprogress.b.a(f0VarB2, dVar2);
                    e0.a aVarT2 = new e0.a().t(new URL(fileResult2.getPut()));
                    y.f(f0VarA2);
                    this.$call.f36634c = UploadDataSource.INSTANCE.getSharedHttpClient().a(aVarT2.o(f0VarA2).b());
                    final y0 y0Var2 = this.$call;
                    nf.e eVar2 = (nf.e) y0Var2.f36634c;
                    final m0 m0Var5 = this.$downloadScope;
                    final u0 u0Var2 = this.$isSuccess;
                    final NotificationManager notificationManager4 = this.$notifManager;
                    final Attachment attachment7 = this.$attachment;
                    final String str4 = this.$contentName;
                    final long j13 = this.$totalSize;
                    final a2 a2Var5 = a2Var2;
                    final UploadDataSource uploadDataSource4 = this.this$0;
                    i10 = 3;
                    eVar2.j(new nf.f() { // from class: cu.todus.android.s3.upload.UploadDataSource.upload.2.1
                        @Override // nf.f
                        public void onFailure(nf.e call, IOException e10) {
                            y.i(call, "call");
                            y.i(e10, "e");
                            m0 m0Var6 = m0Var5;
                            k.d(m0Var6, null, null, new UploadDataSource$upload$2$1$onFailure$1(a2Var5, uVar, m0Var6, y0Var2, u0Var2, notificationManager4, attachment7, null), 3, null);
                        }

                        @Override // nf.f
                        public void onResponse(nf.e call, g0 response) throws IOException {
                            y.i(call, "call");
                            y.i(response, "response");
                            response.j();
                            m0 m0Var6 = m0Var5;
                            k.d(m0Var6, null, null, new UploadDataSource$upload$2$1$onResponse$1(a2Var5, response, uVar, u0Var2, notificationManager4, attachment7, str4, j13, uploadDataSource4, attachment5, m0Var6, y0Var2, null), 3, null);
                        }
                    });
                    a2Var = a2Var5;
                    fileResult = fileResult2;
                }
                uVar2 = uVar2;
                return objG;
            }
            u uVar5 = uVar2;
            i10 = 3;
            a2.a.a(a2Var, null, 1, null);
            invokeSuspend$close(this.$downloadScope, uVar5, this.$call, this.$isSuccess, this.$notifManager, this.$attachment);
            uVar = uVar5;
            aVar = new lb.a() { // from class: cu.todus.android.s3.upload.f
                @Override // lb.a
                public final Object invoke() {
                    return k0.f43947a;
                }
            };
            this.L$0 = l.a(uVar);
            this.L$1 = l.a(a2Var);
            this.L$2 = l.a(fileResult);
            this.L$3 = null;
            this.label = i10;
            if (s.a(uVar, aVar, this) == objG) {
                return objG;
            }
            return k0.f43947a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(u uVar, ab.e<? super k0> eVar) {
            return ((AnonymousClass2) create(uVar, eVar)).invokeSuspend(k0.f43947a);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.s3.upload.UploadDataSource$upload$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.s3.upload.UploadDataSource$upload$3", f = "UploadDataSource.kt", l = {}, m = "invokeSuspend", v = 2)
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

    /* JADX INFO: renamed from: cu.todus.android.s3.upload.UploadDataSource$uploadMessage$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.s3.upload.UploadDataSource", f = "UploadDataSource.kt", l = {WebmConstants.MkvEbmlElement.TRACK_ENTRY, WebmConstants.MkvEbmlElement.CUE_TIME, PsExtractor.AUDIO_STREAM, ComposerKt.reuseKey, 214, 221, 227, 226}, m = "uploadMessage", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C11811 extends cb.d {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;
        /* synthetic */ Object result;

        public C11811(ab.e<? super C11811> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return UploadDataSource.this.uploadMessage(null, this);
        }
    }

    public UploadDataSource(o getPutUrl, Function2 updateAttachment, Function2 getAttachments, Function3 updateMsgStatus) {
        y.i(getPutUrl, "getPutUrl");
        y.i(updateAttachment, "updateAttachment");
        y.i(getAttachments, "getAttachments");
        y.i(updateMsgStatus, "updateMsgStatus");
        this.getPutUrl = getPutUrl;
        this.updateAttachment = updateAttachment;
        this.getAttachments = getAttachments;
        this.updateMsgStatus = updateMsgStatus;
        this.coroutineScope = n0.a(d1.b().plus(e2.b(null, 1, null)));
        b0 b0VarA = r0.a(w.n());
        this._uploadQueue = b0VarA;
        this.uploadQueue = te.j.b(b0VarA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final c0 sharedHttpClient_delegate$lambda$0() {
        c0.a aVarA = new c0().A();
        Pair<SSLSocketFactory, X509TrustManager> pairAllowAllCertificated = RetrofitModule.INSTANCE.allowAllCertificated();
        if (pairAllowAllCertificated != null) {
            aVarA.Q(pairAllowAllCertificated.getFirst(), pairAllowAllCertificated.getSecond());
            aVarA.M(new HostnameVerifier() { // from class: cu.todus.android.s3.upload.d
                @Override // javax.net.ssl.HostnameVerifier
                public final boolean verify(String str, SSLSession sSLSession) {
                    return UploadDataSource.sharedHttpClient_delegate$lambda$0$0$0$0(str, sSLSession);
                }
            });
        }
        aVarA.O(false);
        aVarA.a(TokenAuthenticator.INSTANCE.headerWithAuth("HTTP-Upload", true));
        return aVarA.d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean sharedHttpClient_delegate$lambda$0$0$0$0(String str, SSLSession sSLSession) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0090, code lost:
    
        if (uploadMessage(r7, r0) == r1) goto L30;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object startProcess(java.lang.String r6, ab.e<? super ua.k0> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof cu.todus.android.s3.upload.UploadDataSource.C11801
            if (r0 == 0) goto L13
            r0 = r7
            cu.todus.android.s3.upload.UploadDataSource$startProcess$1 r0 = (cu.todus.android.s3.upload.UploadDataSource.C11801) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            cu.todus.android.s3.upload.UploadDataSource$startProcess$1 r0 = new cu.todus.android.s3.upload.UploadDataSource$startProcess$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = bb.b.g()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L44
            if (r2 == r4) goto L3c
            if (r2 != r3) goto L34
            java.lang.Object r6 = r0.L$1
            cu.todus.android.s3.S3State r6 = (cu.todus.android.s3.S3State) r6
            java.lang.Object r6 = r0.L$0
            java.lang.String r6 = (java.lang.String) r6
            ua.v.b(r7)
            goto L93
        L34:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3c:
            java.lang.Object r6 = r0.L$0
            java.lang.String r6 = (java.lang.String) r6
            ua.v.b(r7)
            goto L54
        L44:
            ua.v.b(r7)
            te.b0 r7 = r5._uploadQueue
            r0.L$0 = r6
            r0.label = r4
            java.lang.Object r7 = te.j.x(r7, r0)
            if (r7 != r1) goto L54
            goto L92
        L54:
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.Iterator r7 = r7.iterator()
        L5a:
            boolean r2 = r7.hasNext()
            if (r2 == 0) goto L72
            java.lang.Object r2 = r7.next()
            r4 = r2
            cu.todus.android.s3.S3State r4 = (cu.todus.android.s3.S3State) r4
            java.lang.String r4 = r4.getItemId()
            boolean r4 = kotlin.jvm.internal.y.d(r4, r6)
            if (r4 == 0) goto L5a
            goto L73
        L72:
            r2 = 0
        L73:
            cu.todus.android.s3.S3State r2 = (cu.todus.android.s3.S3State) r2
            if (r2 == 0) goto L96
            r2.toString()
            java.lang.String r7 = r2.getItemId()
            java.lang.Object r6 = cb.l.a(r6)
            r0.L$0 = r6
            java.lang.Object r6 = cb.l.a(r2)
            r0.L$1 = r6
            r0.label = r3
            java.lang.Object r6 = r5.uploadMessage(r7, r0)
            if (r6 != r1) goto L93
        L92:
            return r1
        L93:
            ua.k0 r6 = ua.k0.f43947a
            return r6
        L96:
            ua.k0 r6 = ua.k0.f43947a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.s3.upload.UploadDataSource.startProcess(java.lang.String, ab.e):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object upload(int i10, long j10, Attachment attachment, ab.e<? super k0> eVar) {
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
        Object objJ = te.j.j(te.j.g(te.j.f(te.j.e(new AnonymousClass2(m0VarA, this, i10, j10, attachment, y0Var, u0Var, NotificationManager.INSTANCE.getInstance(), x0Var, name, null))), new AnonymousClass3(null)), eVar);
        return objJ == bb.b.g() ? objJ : k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:117:0x015e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:27:0x0103  */
    /* JADX WARN: Code duplicated, block: B:30:0x0134  */
    /* JADX WARN: Code duplicated, block: B:34:0x0149  */
    /* JADX WARN: Code duplicated, block: B:41:0x0164  */
    /* JADX WARN: Code duplicated, block: B:52:0x01aa  */
    /* JADX WARN: Code duplicated, block: B:57:0x01b3  */
    /* JADX WARN: Code duplicated, block: B:58:0x01b5  */
    /* JADX WARN: Code duplicated, block: B:60:0x01b9  */
    /* JADX WARN: Code duplicated, block: B:61:0x01bb  */
    /* JADX WARN: Code duplicated, block: B:63:0x01bf  */
    /* JADX WARN: Code duplicated, block: B:64:0x01c1  */
    /* JADX WARN: Code duplicated, block: B:68:0x0200  */
    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:68:0x0200 -> B:69:0x0205). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:71:0x020a -> B:70:0x0208). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object uploadMessage(java.lang.String r26, ab.e<? super ua.k0> r27) {
        /*
            Method dump skipped, instruction units count: 786
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.s3.upload.UploadDataSource.uploadMessage(java.lang.String, ab.e):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean uploadMessage$lambda$2$0(String str, S3State it) {
        y.i(it, "it");
        return y.d(it.getItemId(), str);
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
                        listW0 = va.g0.W0(s3StateCopy$default.getAttList(), newAtt);
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

    public final void cancelUpload(String msgId) {
        y.i(msgId, "msgId");
        CoroutineUtilsKt.launchWithContext$default(this.coroutineScope, null, null, new C11781(msgId, null), 3, null);
    }

    public final void enqueueUpload(String msgId) {
        y.i(msgId, "msgId");
        CoroutineUtilsKt.launchWithContext$default(this.coroutineScope, null, null, new C11791(msgId, null), 3, null);
    }

    public final p0 getUploadQueue() {
        return this.uploadQueue;
    }
}
