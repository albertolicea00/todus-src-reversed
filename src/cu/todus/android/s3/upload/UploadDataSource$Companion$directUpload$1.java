package cu.todus.android.s3.upload;

import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@cb.f(c = "cu.todus.android.s3.upload.UploadDataSource$Companion", f = "UploadDataSource.kt", l = {87}, m = "directUpload", v = 2)
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
public final class UploadDataSource$Companion$directUpload$1 extends cb.d {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ UploadDataSource.Companion this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UploadDataSource$Companion$directUpload$1(UploadDataSource.Companion companion, ab.e<? super UploadDataSource$Companion$directUpload$1> eVar) {
        super(eVar);
        this.this$0 = companion;
    }

    @Override // cb.a
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.directUpload(null, null, this);
    }
}
