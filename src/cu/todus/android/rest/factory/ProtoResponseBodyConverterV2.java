package cu.todus.android.rest.factory;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.y;
import mi.i;
import nf.h0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000\u0003B\u001f\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\f\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\rR\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u000eR\u0016\u0010\b\u001a\u0004\u0018\u00010\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcu/todus/android/rest/factory/ProtoResponseBodyConverterV2;", "Lcom/google/protobuf/MessageLite;", ExifInterface.GPS_DIRECTION_TRUE, "Lmi/i;", "Lnf/h0;", "Lcom/google/protobuf/Parser;", "parser", "Lcom/google/protobuf/ExtensionRegistryLite;", "registry", "<init>", "(Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)V", AppMeasurementSdk.ConditionalUserProperty.VALUE, "convert", "(Lnf/h0;)Lcom/google/protobuf/MessageLite;", "Lcom/google/protobuf/Parser;", "Lcom/google/protobuf/ExtensionRegistryLite;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ProtoResponseBodyConverterV2<T extends MessageLite> implements i {
    public static final int $stable = 8;
    private final Parser<T> parser;
    private final ExtensionRegistryLite registry;

    public ProtoResponseBodyConverterV2(Parser<T> parser, ExtensionRegistryLite extensionRegistryLite) {
        y.i(parser, "parser");
        this.parser = parser;
        this.registry = extensionRegistryLite;
    }

    @Override // mi.i
    public T convert(h0 value) {
        y.i(value, "value");
        T from = null;
        try {
            try {
                byte[] bArrA = value.a();
                if (bArrA.length != 0) {
                    ExtensionRegistryLite extensionRegistryLite = this.registry;
                    from = extensionRegistryLite != null ? this.parser.parseFrom(bArrA, extensionRegistryLite) : this.parser.parseFrom(bArrA);
                }
            } catch (Exception e10) {
                System.err.println("Error parsing protobuf message: " + e10.getMessage());
                e10.printStackTrace();
            }
            try {
                value.close();
            } catch (IOException unused) {
            }
            return from;
        } catch (Throwable th2) {
            try {
                value.close();
            } catch (IOException unused2) {
            }
            throw th2;
        }
    }
}
