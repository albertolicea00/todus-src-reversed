package cu.todus.android.db.typeconverter;

import android.net.Uri;
import androidx.compose.runtime.internal.StabilityInferred;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.y;
import v5.i;
import v5.j;
import v5.k;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 1)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J+\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcu/todus/android/db/typeconverter/UriDeserializer;", "Lv5/j;", "Landroid/net/Uri;", "<init>", "()V", "Lv5/k;", "src", "Ljava/lang/reflect/Type;", "srcType", "Lv5/i;", "context", "deserialize", "(Lv5/k;Ljava/lang/reflect/Type;Lv5/i;)Landroid/net/Uri;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class UriDeserializer implements j {
    public static final int $stable = 0;

    @Override // v5.j
    public Uri deserialize(k src, Type srcType, i context) {
        y.i(src, "src");
        Uri uri = Uri.parse(src.f());
        y.h(uri, "parse(...)");
        return uri;
    }
}
