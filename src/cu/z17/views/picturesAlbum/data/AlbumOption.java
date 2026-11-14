package cu.z17.views.picturesAlbum.data;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.jvm.internal.y;
import lb.a;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes7.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0006\u0010\u0007R\u0017\u0010\u0002\u001a\u00020\u00018\u0006¢\u0006\f\n\u0004\b\u0002\u0010\b\u001a\u0004\b\t\u0010\nR\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcu/z17/views/picturesAlbum/data/AlbumOption;", "", "preview", "Lkotlin/Function0;", "Lua/k0;", "function", "<init>", "(Ljava/lang/Object;Llb/a;)V", "Ljava/lang/Object;", "getPreview", "()Ljava/lang/Object;", "Llb/a;", "getFunction", "()Llb/a;", "views_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AlbumOption {
    public static final int $stable = 8;
    private final a function;
    private final Object preview;

    public AlbumOption(Object preview, a function) {
        y.i(preview, "preview");
        y.i(function, "function");
        this.preview = preview;
        this.function = function;
    }

    public final a getFunction() {
        return this.function;
    }

    public final Object getPreview() {
        return this.preview;
    }
}
