package cu.todus.android.s3.upload;

import androidx.compose.runtime.internal.StabilityInferred;
import cu.todus.android.xmpp.extension.file.ExtensionFile;
import java.io.File;
import java.net.URL;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;
import pe.m0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0012\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R(\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcu/todus/android/s3/upload/DirectUploadCallbackFlow;", "", "Ljava/net/URL;", "url", "Ljava/io/File;", ExtensionFile.ELEMENT, "Lcu/todus/android/s3/upload/DirectUploadState;", "directUploadState", "Lpe/m0;", "scope", "", "header", "<init>", "(Ljava/net/URL;Ljava/io/File;Lcu/todus/android/s3/upload/DirectUploadState;Lpe/m0;Ljava/lang/String;)V", "Lua/k0;", "stop", "()V", "", "hasToClose", "Z", "Lte/h;", "callbackFlow", "Lte/h;", "getCallbackFlow", "()Lte/h;", "setCallbackFlow", "(Lte/h;)V", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class DirectUploadCallbackFlow {
    public static final int $stable = 8;
    private te.h callbackFlow;
    private boolean hasToClose;

    public DirectUploadCallbackFlow(URL url, File file, DirectUploadState directUploadState, m0 scope, String header) {
        y.i(url, "url");
        y.i(file, "file");
        y.i(directUploadState, "directUploadState");
        y.i(scope, "scope");
        y.i(header, "header");
        this.callbackFlow = te.j.f(te.j.e(new DirectUploadCallbackFlow$callbackFlow$1(file, url, scope, header, directUploadState, this, null)));
    }

    public final te.h getCallbackFlow() {
        return this.callbackFlow;
    }

    public final void setCallbackFlow(te.h hVar) {
        y.i(hVar, "<set-?>");
        this.callbackFlow = hVar;
    }

    public final void stop() {
        this.hasToClose = true;
    }

    public /* synthetic */ DirectUploadCallbackFlow(URL url, File file, DirectUploadState directUploadState, m0 m0Var, String str, int i10, p pVar) {
        this(url, file, directUploadState, m0Var, (i10 & 16) != 0 ? "HTTP-Upload" : str);
    }
}
