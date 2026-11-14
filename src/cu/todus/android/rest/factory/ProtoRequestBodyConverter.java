package cu.todus.android.rest.factory;

import com.google.protobuf.MessageLite;
import java.io.IOException;
import mi.i;
import nf.a0;
import nf.f0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
final class ProtoRequestBodyConverter<T extends MessageLite> implements i {
    private static final a0 MEDIA_TYPE = a0.g("application/x-protobuf");

    @Override // mi.i
    public f0 convert(T t10) throws IOException {
        return f0.e(t10.toByteArray(), MEDIA_TYPE);
    }
}
