package cu.z17.views.utils;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.y;
import te.b0;
import te.r0;
import va.g0;
import va.w;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes7.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0017\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ!\u0010\r\u001a\u00020\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0004\b\r\u0010\u000eJ#\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u000f\u001a\u00028\u00002\u0006\u0010\u0010\u001a\u00020\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u001b\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u000f\u001a\u00028\u0000¢\u0006\u0004\b\u0013\u0010\u0014J!\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003¢\u0006\u0004\b\u0013\u0010\u0016J\u001b\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u000f\u001a\u00028\u0000¢\u0006\u0004\b\u0017\u0010\u0014J!\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003¢\u0006\u0004\b\u0018\u0010\u0016J'\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0004\b\u0019\u0010\u001aJ\r\u0010\u0019\u001a\u00020\u001b¢\u0006\u0004\b\u0019\u0010\u001cJ\u001b\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u0010\u001a\u00020\u0007¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b!\u0010 R \u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R#\u0010&\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030%8\u0006¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)¨\u0006*"}, d2 = {"Lcu/z17/views/utils/Z17MutableListFlow;", ExifInterface.GPS_DIRECTION_TRUE, "", "", "initial", "<init>", "(Ljava/util/List;)V", "", "getSize", "()I", "Lkotlin/Function1;", "", "condition", "contains", "(Lkotlin/jvm/functions/Function1;)Z", "element", "index", "change", "(Ljava/lang/Object;I)Ljava/util/List;", "set", "(Ljava/lang/Object;)Ljava/util/List;", "elements", "(Ljava/util/List;)Ljava/util/List;", "add", "addAll", "removeAll", "(Lkotlin/jvm/functions/Function1;)Ljava/util/List;", "Lua/k0;", "()V", "removeAt", "(I)Ljava/util/List;", "removeLast", "()Ljava/lang/Object;", "removeFirst", "Lte/b0;", "mutableList", "Lte/b0;", "Lte/h;", AppMeasurementSdk.ConditionalUserProperty.VALUE, "Lte/h;", "getValue", "()Lte/h;", "views_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class Z17MutableListFlow<T> {
    public static final int $stable = 8;
    private final b0 mutableList;
    private final te.h value;

    /* JADX WARN: Multi-variable type inference failed */
    public Z17MutableListFlow() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean removeAll$lambda$1(Function1 function1, Object obj) {
        return ((Boolean) function1.invoke(obj)).booleanValue();
    }

    public final List<T> add(T element) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll((Collection) this.mutableList.getValue());
        arrayList.add(element);
        this.mutableList.setValue(g0.o1(arrayList));
        return (List) this.mutableList.getValue();
    }

    public final List<T> addAll(List<? extends T> elements) {
        y.i(elements, "elements");
        ArrayList arrayList = new ArrayList();
        arrayList.addAll((Collection) this.mutableList.getValue());
        arrayList.addAll(elements);
        this.mutableList.setValue(g0.o1(arrayList));
        return (List) this.mutableList.getValue();
    }

    public final List<T> change(T element, int index) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll((Collection) this.mutableList.getValue());
        arrayList.set(index, element);
        this.mutableList.setValue(g0.o1(arrayList));
        return (List) this.mutableList.getValue();
    }

    public final boolean contains(Function1 condition) {
        y.i(condition, "condition");
        Iterator<T> it = ((Iterable) this.mutableList.getValue()).iterator();
        boolean zBooleanValue = false;
        while (it.hasNext()) {
            zBooleanValue = ((Boolean) condition.invoke(it.next())).booleanValue();
        }
        return zBooleanValue;
    }

    public final int getSize() {
        return ((List) this.mutableList.getValue()).size();
    }

    public final te.h getValue() {
        return this.value;
    }

    public final List<T> removeAll(final Function1 condition) {
        y.i(condition, "condition");
        ArrayList arrayList = new ArrayList();
        arrayList.addAll((Collection) this.mutableList.getValue());
        va.b0.N(arrayList, new Function1() { // from class: cu.z17.views.utils.s
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(Z17MutableListFlow.removeAll$lambda$1(condition, obj));
            }
        });
        this.mutableList.setValue(g0.o1(arrayList));
        return (List) this.mutableList.getValue();
    }

    public final List<T> removeAt(int index) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll((Collection) this.mutableList.getValue());
        if (index < arrayList.size()) {
            arrayList.remove(index);
            this.mutableList.setValue(g0.o1(arrayList));
        }
        return (List) this.mutableList.getValue();
    }

    public final T removeFirst() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll((Collection) this.mutableList.getValue());
        if (arrayList.size() <= 0) {
            return null;
        }
        T t10 = (T) arrayList.remove(0);
        this.mutableList.setValue(g0.o1(arrayList));
        return t10;
    }

    public final T removeLast() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll((Collection) this.mutableList.getValue());
        if (arrayList.size() <= 0) {
            return null;
        }
        T t10 = (T) arrayList.remove(arrayList.size() - 1);
        this.mutableList.setValue(g0.o1(arrayList));
        return t10;
    }

    public final List<T> set(T element) {
        this.mutableList.setValue(g0.o1(w.g(element)));
        return (List) this.mutableList.getValue();
    }

    public Z17MutableListFlow(List<? extends T> initial) {
        y.i(initial, "initial");
        this.mutableList = r0.a(initial);
        this.value = te.j.B(new Z17MutableListFlow$value$1(this, null));
    }

    public final List<T> set(List<? extends T> elements) {
        y.i(elements, "elements");
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(elements);
        this.mutableList.setValue(g0.o1(arrayList));
        return (List) this.mutableList.getValue();
    }

    public /* synthetic */ Z17MutableListFlow(List list, int i10, kotlin.jvm.internal.p pVar) {
        this((i10 & 1) != 0 ? w.n() : list);
    }

    public final void removeAll() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll((Collection) this.mutableList.getValue());
        arrayList.clear();
        this.mutableList.setValue(g0.o1(arrayList));
    }
}
