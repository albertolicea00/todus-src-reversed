package cu.todus.android.db.typeconverter;

import android.net.Uri;
import androidx.compose.runtime.internal.StabilityInferred;
import java.lang.reflect.Type;
import kotlin.Metadata;
import v5.k;
import v5.p;
import v5.q;
import v5.r;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 1)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J-\u0010\u000b\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcu/todus/android/db/typeconverter/UriSerializer;", "Lv5/r;", "Landroid/net/Uri;", "<init>", "()V", "src", "Ljava/lang/reflect/Type;", "typeOfSrc", "Lv5/q;", "context", "Lv5/k;", "serialize", "(Landroid/net/Uri;Ljava/lang/reflect/Type;Lv5/q;)Lv5/k;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class UriSerializer implements r {
    public static final int $stable = 0;

    @Override // v5.r
    public k serialize(Uri src, Type typeOfSrc, q context) {
        return new p(String.valueOf(src));
    }
}
