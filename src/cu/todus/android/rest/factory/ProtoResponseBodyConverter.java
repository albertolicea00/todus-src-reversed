package cu.todus.android.rest.factory;

import android.util.Log;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import java.io.IOException;
import javax.annotation.Nullable;
import mi.i;
import nf.h0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
final class ProtoResponseBodyConverter<T extends MessageLite> implements i {
    private static final String TAG = "ProtoConverter";
    private final Parser<T> parser;

    @Nullable
    private final ExtensionRegistryLite registry;

    public ProtoResponseBodyConverter(Parser<T> parser, @Nullable ExtensionRegistryLite extensionRegistryLite) {
        this.parser = parser;
        this.registry = extensionRegistryLite;
    }

    @Override // mi.i
    @Nullable
    public T convert(@Nullable h0 h0Var) {
        try {
            if (h0Var == null) {
                return null;
            }
            try {
                byte[] bArrA = h0Var.a();
                if (bArrA != null && bArrA.length != 0) {
                    ExtensionRegistryLite extensionRegistryLite = this.registry;
                    T from = extensionRegistryLite != null ? this.parser.parseFrom(bArrA, extensionRegistryLite) : this.parser.parseFrom(bArrA);
                    h0Var.close();
                    return from;
                }
                h0Var.close();
                return null;
            } catch (Throwable th2) {
                try {
                    h0Var.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
                throw th2;
            }
        } catch (InvalidProtocolBufferException e10) {
            Log.w(TAG, "Error parsing protobuf: " + e10.getMessage(), e10);
            return null;
        } catch (IOException e11) {
            Log.w(TAG, "IOException during protobuf parsing: " + e11.getMessage(), e11);
            return null;
        } catch (NullPointerException e12) {
            Log.w(TAG, "NullPointerException during protobuf parsing: " + e12.getMessage(), e12);
            return null;
        } catch (Exception e13) {
            Log.e(TAG, "Unexpected error parsing protobuf: " + e13.getMessage(), e13);
            return null;
        }
    }
}
