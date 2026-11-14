package cu.todus.android.rest.factory;

import androidx.compose.runtime.internal.StabilityInferred;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;
import mi.b0;
import mi.i;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0013\b\u0002\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J%\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\b2\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u0006H\u0002¢\u0006\u0004\b\n\u0010\u000bJ;\u0010\u0014\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0012\u0002\b\u0003\u0018\u00010\u00122\u0006\u0010\u0007\u001a\u00020\f2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0014\u0010\u0015JG\u0010\u0019\u001a\u000e\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00122\u0006\u0010\u0007\u001a\u00020\f2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0019\u0010\u001aR\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001b¨\u0006\u001d"}, d2 = {"Lcu/todus/android/rest/factory/ProtobufConverterFactoryV2;", "Lmi/i$a;", "Lcom/google/protobuf/ExtensionRegistryLite;", "registry", "<init>", "(Lcom/google/protobuf/ExtensionRegistryLite;)V", "Ljava/lang/Class;", "type", "Lcom/google/protobuf/Parser;", "Lcom/google/protobuf/MessageLite;", "getParser", "(Ljava/lang/Class;)Lcom/google/protobuf/Parser;", "Ljava/lang/reflect/Type;", "", "", "annotations", "Lmi/b0;", "retrofit", "Lmi/i;", "Lnf/h0;", "responseBodyConverter", "(Ljava/lang/reflect/Type;[Ljava/lang/annotation/Annotation;Lmi/b0;)Lmi/i;", "parameterAnnotations", "methodAnnotations", "Lnf/f0;", "requestBodyConverter", "(Ljava/lang/reflect/Type;[Ljava/lang/annotation/Annotation;[Ljava/lang/annotation/Annotation;Lmi/b0;)Lmi/i;", "Lcom/google/protobuf/ExtensionRegistryLite;", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ProtobufConverterFactoryV2 extends i.a {
    private final ExtensionRegistryLite registry;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u0010\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b¨\u0006\t"}, d2 = {"Lcu/todus/android/rest/factory/ProtobufConverterFactoryV2$Companion;", "", "<init>", "()V", "create", "Lcu/todus/android/rest/factory/ProtobufConverterFactoryV2;", "createWithRegistry", "registry", "Lcom/google/protobuf/ExtensionRegistryLite;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(p pVar) {
            this();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final ProtobufConverterFactoryV2 create() {
            return new ProtobufConverterFactoryV2(null, 0 == true ? 1 : 0);
        }

        public final ProtobufConverterFactoryV2 createWithRegistry(ExtensionRegistryLite registry) {
            return new ProtobufConverterFactoryV2(registry, null);
        }

        private Companion() {
        }
    }

    public /* synthetic */ ProtobufConverterFactoryV2(ExtensionRegistryLite extensionRegistryLite, p pVar) {
        this(extensionRegistryLite);
    }

    private final Parser<MessageLite> getParser(Class<?> type) {
        try {
            try {
                try {
                    Object objInvoke = type.getDeclaredMethod("parser", null).invoke(null, null);
                    y.g(objInvoke, "null cannot be cast to non-null type com.google.protobuf.Parser<com.google.protobuf.MessageLite?>");
                    return (Parser) objInvoke;
                } catch (Exception unused) {
                    throw new IllegalArgumentException("Found a protobuf message but " + type.getName() + " had no parser() method or PARSER field.");
                }
            } catch (Exception unused2) {
                throw new IllegalArgumentException("Found a protobuf message but " + type.getName() + " had no parser() method or PARSER field.");
            }
        } catch (IllegalAccessException unused3) {
            Object obj = type.getDeclaredField("PARSER").get(null);
            y.g(obj, "null cannot be cast to non-null type com.google.protobuf.Parser<com.google.protobuf.MessageLite?>");
            return (Parser) obj;
        } catch (NoSuchMethodException unused4) {
            Object obj2 = type.getDeclaredField("PARSER").get(null);
            y.g(obj2, "null cannot be cast to non-null type com.google.protobuf.Parser<com.google.protobuf.MessageLite?>");
            return (Parser) obj2;
        } catch (InvocationTargetException e10) {
            throw new RuntimeException(e10.getCause());
        }
    }

    @Override // mi.i.a
    public i requestBodyConverter(Type type, Annotation[] parameterAnnotations, Annotation[] methodAnnotations, b0 retrofit) {
        y.i(type, "type");
        y.i(parameterAnnotations, "parameterAnnotations");
        y.i(methodAnnotations, "methodAnnotations");
        y.i(retrofit, "retrofit");
        if ((type instanceof Class) && MessageLite.class.isAssignableFrom((Class) type)) {
            return new ProtoRequestBodyConverter();
        }
        return null;
    }

    @Override // mi.i.a
    public i responseBodyConverter(Type type, Annotation[] annotations, b0 retrofit) {
        Parser<MessageLite> parser;
        y.i(type, "type");
        y.i(annotations, "annotations");
        y.i(retrofit, "retrofit");
        if (!(type instanceof Class)) {
            return null;
        }
        Class<?> cls = (Class) type;
        if (MessageLite.class.isAssignableFrom(cls) && (parser = getParser(cls)) != null) {
            return new ProtoResponseBodyConverterV2(parser, this.registry);
        }
        return null;
    }

    private ProtobufConverterFactoryV2(ExtensionRegistryLite extensionRegistryLite) {
        this.registry = extensionRegistryLite;
    }
}
