package cu.z17.singledi;

import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcu/z17/singledi/SinglediException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "<init>", "()V", "singledi_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SinglediException extends Exception {
    public SinglediException() {
        super("Instance requested before created. Be sure to use createInstance method on your main App class.");
    }
}
