package cu.todus.android.rest.factory;

import androidx.compose.runtime.internal.StabilityInferred;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.y;
import mi.b0;
import mi.i;
import nf.h0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J9\u0010\r\u001a\f\u0012\u0004\u0012\u00020\f\u0012\u0002\b\u00030\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u000e\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u00062\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcu/todus/android/rest/factory/NullOnEmptyConverterFactory;", "Lmi/i$a;", "<init>", "()V", "Ljava/lang/reflect/Type;", "type", "", "", "annotations", "Lmi/b0;", "retrofit", "Lmi/i;", "Lnf/h0;", "responseBodyConverter", "(Ljava/lang/reflect/Type;[Ljava/lang/annotation/Annotation;Lmi/b0;)Lmi/i;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class NullOnEmptyConverterFactory extends i.a {
    public static final int $stable = 8;

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object responseBodyConverter$lambda$0(i iVar, h0 h0Var) {
        if (h0Var.h() != 0) {
            return iVar.convert(h0Var);
        }
        h0Var.close();
        return null;
    }

    @Override // mi.i.a
    public i responseBodyConverter(Type type, Annotation[] annotations, b0 retrofit) {
        y.i(type, "type");
        y.i(annotations, "annotations");
        y.i(retrofit, "retrofit");
        final i iVarF = retrofit.f(this, type, annotations);
        y.h(iVarF, "nextResponseBodyConverter(...)");
        return new i() { // from class: cu.todus.android.rest.factory.a
            @Override // mi.i
            public final Object convert(Object obj) {
                return NullOnEmptyConverterFactory.responseBodyConverter$lambda$0(iVarF, (h0) obj);
            }
        };
    }
}
