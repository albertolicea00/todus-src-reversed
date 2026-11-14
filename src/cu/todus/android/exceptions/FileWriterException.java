package cu.todus.android.exceptions;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcu/todus/android/exceptions/FileWriterException;", "Lcu/todus/android/exceptions/ToDusException;", "<init>", "()V", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class FileWriterException extends ToDusException {
    public static final int $stable = 8;

    public FileWriterException() {
        super("write file error", null, false, 6, null);
    }
}
