package cu.z17.singledi;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.y;
import lb.a;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001b\u0010\u0007\u001a\u00028\u00002\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00028\u0000¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u000b\u0010\nJ\r\u0010\r\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u0004R\u0018\u0010\u000e\u001a\u0004\u0018\u00018\u00008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcu/z17/singledi/SingletonInitializer;", "", ExifInterface.GPS_DIRECTION_TRUE, "<init>", "()V", "Lkotlin/Function0;", "creator", "createInstance", "(Llb/a;)Ljava/lang/Object;", "getInstance", "()Ljava/lang/Object;", "getInstanceOrNull", "Lua/k0;", "deleteInstance", "instance", "Ljava/lang/Object;", "singledi_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public class SingletonInitializer<T> {
    private volatile T instance;

    public final T createInstance(a creator) {
        T t10;
        y.i(creator, "creator");
        T t11 = this.instance;
        if (t11 != null) {
            return t11;
        }
        synchronized (this) {
            t10 = this.instance;
            if (t10 == null) {
                t10 = (T) creator.invoke();
                this.instance = t10;
            }
        }
        return t10;
    }

    public final void deleteInstance() {
        this.instance = null;
    }

    public final T getInstance() throws SinglediException {
        if (this.instance == null) {
            throw new SinglediException();
        }
        T t10 = this.instance;
        y.f(t10);
        return t10;
    }

    public final T getInstanceOrNull() {
        return this.instance;
    }
}
