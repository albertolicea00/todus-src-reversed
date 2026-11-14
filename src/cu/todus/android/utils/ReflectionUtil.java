package cu.todus.android.utils;

import androidx.compose.runtime.internal.StabilityInferred;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import kotlin.Metadata;
import kotlin.jvm.internal.y;
import org.jivesoftware.smackx.xdata.FormField;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 1)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\t\u001a\u00020\b2\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcu/todus/android/utils/ReflectionUtil;", "", "<init>", "()V", "Ljava/lang/Class;", "clazz", "", "fieldName", "Ljava/lang/reflect/Field;", "getField", "(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/reflect/Field;", FormField.ELEMENT, "Lua/k0;", "makeAccessible", "(Ljava/lang/reflect/Field;)V", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ReflectionUtil {
    public static final int $stable = 0;
    public static final ReflectionUtil INSTANCE = new ReflectionUtil();

    private ReflectionUtil() {
    }

    public final Field getField(Class<?> clazz, String fieldName) throws NoSuchFieldException {
        y.i(clazz, "clazz");
        y.i(fieldName, "fieldName");
        try {
            Field declaredField = clazz.getDeclaredField(fieldName);
            y.f(declaredField);
            return declaredField;
        } catch (NoSuchFieldException e10) {
            Class<? super Object> superclass = clazz.getSuperclass();
            if (superclass != null) {
                return getField(superclass, fieldName);
            }
            throw e10;
        }
    }

    public final void makeAccessible(Field field) {
        y.i(field, "field");
        if (Modifier.isPublic(field.getModifiers()) && Modifier.isPublic(field.getDeclaringClass().getModifiers())) {
            return;
        }
        field.setAccessible(true);
    }
}
