package cu.todus.android.s3.upload;

import kotlin.Metadata;
import pe.m0;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
public final class UploadDataSource$Companion$directUpload$2<T> implements te.i {
    final /* synthetic */ m0 $scope;

    public UploadDataSource$Companion$directUpload$2(m0 m0Var) {
        this.$scope = m0Var;
    }

    /* JADX WARN: Code duplicated, block: B:24:0x006a  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0058, code lost:
    
        if (pe.w0.b(100, r0) == r1) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0076, code lost:
    
        if (pe.w0.b(100, r0) == r1) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object emit(cu.todus.android.s3.upload.DirectUploadState r9, ab.e<? super ua.k0> r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof cu.todus.android.s3.upload.UploadDataSource$Companion$directUpload$2$emit$1
            if (r0 == 0) goto L13
            r0 = r10
            cu.todus.android.s3.upload.UploadDataSource$Companion$directUpload$2$emit$1 r0 = (cu.todus.android.s3.upload.UploadDataSource$Companion$directUpload$2$emit$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            cu.todus.android.s3.upload.UploadDataSource$Companion$directUpload$2$emit$1 r0 = new cu.todus.android.s3.upload.UploadDataSource$Companion$directUpload$2$emit$1
            r0.<init>(r8, r10)
        L18:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = bb.b.g()
            int r2 = r0.label
            r3 = 100
            r5 = 2
            r6 = 0
            r7 = 1
            if (r2 == 0) goto L43
            if (r2 == r7) goto L3b
            if (r2 != r5) goto L33
            java.lang.Object r9 = r0.L$0
            cu.todus.android.s3.upload.DirectUploadState r9 = (cu.todus.android.s3.upload.DirectUploadState) r9
            ua.v.b(r10)
            goto L79
        L33:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L3b:
            java.lang.Object r9 = r0.L$0
            cu.todus.android.s3.upload.DirectUploadState r9 = (cu.todus.android.s3.upload.DirectUploadState) r9
            ua.v.b(r10)
            goto L5b
        L43:
            ua.v.b(r10)
            r9.getStatus()
            int r10 = r9.getStatus()
            r2 = 3
            if (r10 != r2) goto L64
            r0.L$0 = r9
            r0.label = r7
            java.lang.Object r10 = pe.w0.b(r3, r0)
            if (r10 != r1) goto L5b
            goto L78
        L5b:
            pe.m0 r10 = r8.$scope
            ab.i r10 = r10.getCoroutineContext()
            pe.d2.e(r10, r6, r7, r6)
        L64:
            int r10 = r9.getStatus()
            if (r10 != r5) goto L82
            java.lang.Object r9 = cb.l.a(r9)
            r0.L$0 = r9
            r0.label = r5
            java.lang.Object r9 = pe.w0.b(r3, r0)
            if (r9 != r1) goto L79
        L78:
            return r1
        L79:
            pe.m0 r9 = r8.$scope
            ab.i r9 = r9.getCoroutineContext()
            pe.d2.e(r9, r6, r7, r6)
        L82:
            ua.k0 r9 = ua.k0.f43947a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.s3.upload.UploadDataSource$Companion$directUpload$2.emit(cu.todus.android.s3.upload.DirectUploadState, ab.e):java.lang.Object");
    }

    @Override // te.i
    public /* bridge */ /* synthetic */ Object emit(Object obj, ab.e eVar) {
        return emit((DirectUploadState) obj, (ab.e<? super k0>) eVar);
    }
}
