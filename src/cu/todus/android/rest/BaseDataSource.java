package cu.todus.android.rest;

import ab.e;
import android.content.Context;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.container.MdtaMetadataEntry;
import androidx.media3.muxer.WebmConstants;
import cb.d;
import cb.f;
import cu.todus.android.data.wrapper.DataWrapper;
import cu.todus.android.di.PreferencesModule;
import cu.todus.android.exceptions.AuthenticationException;
import cu.todus.android.volatileState.AppVolatileState;
import java.net.ConnectException;
import javax.net.ssl.SSLHandshakeException;
import kotlin.Metadata;
import kotlin.jvm.internal.y;
import mi.p;
import ua.v;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0017\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J(\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\n\"\u0004\b\u0000\u0010\u00062\n\u0010\t\u001a\u00060\u0007j\u0002`\bH\u0082@¢\u0006\u0004\b\u000b\u0010\fJ>\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\n\"\u0004\b\u0000\u0010\u00062 \u0010\u0010\u001a\u001c\b\u0001\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000f0\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00010\rH\u0086@¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcu/todus/android/rest/BaseDataSource;", "", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/lang/Exception;", "Lkotlin/Exception;", "error", "Lcu/todus/android/data/wrapper/DataWrapper;", "handleError", "(Ljava/lang/Exception;Lab/e;)Ljava/lang/Object;", "Lkotlin/Function1;", "Lab/e;", "Lmi/a0;", "requestFunc", "handleFlowRequest", "(Lkotlin/jvm/functions/Function1;Lab/e;)Ljava/lang/Object;", "Landroid/content/Context;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public class BaseDataSource {
    public static final int $stable = 8;
    private final Context context;

    /* JADX INFO: renamed from: cu.todus.android.rest.BaseDataSource$handleError$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @f(c = "cu.todus.android.rest.BaseDataSource", f = "BaseDataSource.kt", l = {WebmConstants.MAX_META_SEEK_SIZE, MdtaMetadataEntry.TYPE_INDICATOR_UNSIGNED_INT64}, m = "handleError", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class AnonymousClass1<T> extends d {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(e<? super AnonymousClass1> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return BaseDataSource.this.handleError(null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.rest.BaseDataSource$handleFlowRequest$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @f(c = "cu.todus.android.rest.BaseDataSource", f = "BaseDataSource.kt", l = {20, 38}, m = "handleFlowRequest", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C11511<T> extends d {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C11511(e<? super C11511> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return BaseDataSource.this.handleFlowRequest(null, this);
        }
    }

    public BaseDataSource(Context context) {
        y.i(context, "context");
        this.context = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:58:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final <T> Object handleError(Exception exc, e<? super DataWrapper<T>> eVar) {
        AnonymousClass1 anonymousClass1;
        Exception exc2;
        if (eVar instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) eVar;
            int i10 = anonymousClass1.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i10 - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(eVar);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(eVar);
        }
        Object isValidCertificate = anonymousClass1.result;
        Object objG = bb.b.g();
        int i11 = anonymousClass1.label;
        if (i11 == 0) {
            v.b(isValidCertificate);
            if (exc instanceof NullPointerException) {
                return new DataWrapper(null, exc, false, TypedValues.PositionType.TYPE_TRANSITION_EASING, 4, null);
            }
            if (exc instanceof p) {
                return new DataWrapper(null, exc, false, ((p) exc).a(), 4, null);
            }
            if (exc instanceof AuthenticationException) {
                return new DataWrapper(null, exc, false, TypedValues.CycleType.TYPE_CURVE_FIT, 4, null);
            }
            if (exc instanceof ConnectException) {
                return new DataWrapper(null, exc, false, TypedValues.PositionType.TYPE_DRAWPATH, 4, null);
            }
            if (!(exc instanceof SSLHandshakeException)) {
                return new DataWrapper(null, new ConnectException(exc.getMessage()), false, TypedValues.PositionType.TYPE_PERCENT_WIDTH, 4, null);
            }
            AppVolatileState.Companion companion = AppVolatileState.INSTANCE;
            AppVolatileState instanceOrNull = companion.getInstanceOrNull();
            if (instanceOrNull == null || !instanceOrNull.getIsCertificateValid()) {
                AppVolatileState instanceOrNull2 = companion.getInstanceOrNull();
                if (instanceOrNull2 != null) {
                    instanceOrNull2.setCertificateValid(true);
                }
                PreferencesModule instanceOrNull3 = PreferencesModule.INSTANCE.getInstanceOrNull();
                if (instanceOrNull3 != null) {
                    anonymousClass1.L$0 = exc;
                    anonymousClass1.label = 2;
                    isValidCertificate = instanceOrNull3.setIsValidCertificate(true, anonymousClass1);
                    if (isValidCertificate != objG) {
                        exc2 = exc;
                    }
                    return objG;
                }
                exc2 = exc;
            } else {
                AppVolatileState instanceOrNull4 = companion.getInstanceOrNull();
                if (instanceOrNull4 != null) {
                    instanceOrNull4.setCertificateValid(false);
                }
                PreferencesModule instanceOrNull5 = PreferencesModule.INSTANCE.getInstanceOrNull();
                if (instanceOrNull5 != null) {
                    anonymousClass1.L$0 = exc;
                    anonymousClass1.label = 1;
                    isValidCertificate = instanceOrNull5.setIsValidCertificate(false, anonymousClass1);
                    if (isValidCertificate != objG) {
                        exc2 = exc;
                    }
                    return objG;
                }
                exc2 = exc;
            }
        } else if (i11 == 1) {
            exc2 = (Exception) anonymousClass1.L$0;
            v.b(isValidCertificate);
        } else {
            if (i11 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            exc2 = (Exception) anonymousClass1.L$0;
            v.b(isValidCertificate);
        }
        return new DataWrapper(null, new ConnectException(exc2.getMessage()), false, TypedValues.PositionType.TYPE_CURVE_FIT, 4, null);
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00cf, code lost:
    
        if (r0 == r1) goto L39;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final <T> java.lang.Object handleFlowRequest(kotlin.jvm.functions.Function1 r13, ab.e<? super cu.todus.android.data.wrapper.DataWrapper<T>> r14) {
        /*
            Method dump skipped, instruction units count: 213
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.rest.BaseDataSource.handleFlowRequest(kotlin.jvm.functions.Function1, ab.e):java.lang.Object");
    }
}
