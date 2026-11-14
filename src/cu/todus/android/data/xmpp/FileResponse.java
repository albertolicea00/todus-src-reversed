package cu.todus.android.data.xmpp;

import androidx.compose.runtime.internal.StabilityInferred;
import cu.todus.android.data.rest.BaseResponse;
import kotlin.Metadata;
import kotlin.jvm.internal.y;
import org.jivesoftware.smackx.mam.element.MamElements;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001:\u0001\u000fB7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Lcu/todus/android/data/xmpp/FileResponse;", "Lcu/todus/android/data/rest/BaseResponse;", "success", "", "message", "error", "errorType", MamElements.MamResultExtension.ELEMENT, "Lcu/todus/android/data/xmpp/FileResponse$FileResult;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcu/todus/android/data/xmpp/FileResponse$FileResult;)V", "getResult", "()Lcu/todus/android/data/xmpp/FileResponse$FileResult;", "setResult", "(Lcu/todus/android/data/xmpp/FileResponse$FileResult;)V", "FileResult", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class FileResponse extends BaseResponse {
    public static final int $stable = 8;
    private FileResult result;

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @StabilityInferred(parameters = 0)
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcu/todus/android/data/xmpp/FileResponse$FileResult;", "", "get", "", "put", "wasError", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Z)V", "getGet", "()Ljava/lang/String;", "setGet", "(Ljava/lang/String;)V", "getPut", "setPut", "getWasError", "()Z", "setWasError", "(Z)V", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class FileResult {
        public static final int $stable = 8;
        private String get;
        private String put;
        private boolean wasError;

        public FileResult(String get, String put, boolean z10) {
            y.i(get, "get");
            y.i(put, "put");
            this.get = get;
            this.put = put;
            this.wasError = z10;
        }

        public final String getGet() {
            return this.get;
        }

        public final String getPut() {
            return this.put;
        }

        public final boolean getWasError() {
            return this.wasError;
        }

        public final void setGet(String str) {
            y.i(str, "<set-?>");
            this.get = str;
        }

        public final void setPut(String str) {
            y.i(str, "<set-?>");
            this.put = str;
        }

        public final void setWasError(boolean z10) {
            this.wasError = z10;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileResponse(String success, String str, String str2, String str3, FileResult fileResult) {
        super(success, str, str2, str3);
        y.i(success, "success");
        this.result = fileResult;
    }

    public final FileResult getResult() {
        return this.result;
    }

    public final void setResult(FileResult fileResult) {
        this.result = fileResult;
    }
}
