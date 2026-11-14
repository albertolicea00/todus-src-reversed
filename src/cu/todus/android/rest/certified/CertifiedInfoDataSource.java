package cu.todus.android.rest.certified;

import ab.e;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.app.NotificationCompat;
import bb.b;
import cb.f;
import cb.m;
import cu.todus.android.data.db.entity.toDus.Room;
import cu.todus.android.data.rest.entity.CardEntity;
import cu.todus.android.data.wrapper.DataWrapper;
import cu.todus.android.rest.BaseDataSource;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.y;
import mi.a0;
import ua.k0;
import ua.v;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J \u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n2\u0006\u0010\t\u001a\u00020\bH\u0086@¢\u0006\u0004\b\f\u0010\rJ \u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\n2\u0006\u0010\t\u001a\u00020\bH\u0086@¢\u0006\u0004\b\u000e\u0010\rJ \u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\n2\u0006\u0010\t\u001a\u00020\bH\u0086@¢\u0006\u0004\b\u000f\u0010\rJ \u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\n2\u0006\u0010\t\u001a\u00020\bH\u0086@¢\u0006\u0004\b\u0010\u0010\rR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0011R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcu/todus/android/rest/certified/CertifiedInfoDataSource;", "", "Lcu/todus/android/rest/certified/CertifiedInfoService;", NotificationCompat.CATEGORY_SERVICE, "Lcu/todus/android/rest/BaseDataSource;", "baseDataSource", "<init>", "(Lcu/todus/android/rest/certified/CertifiedInfoService;Lcu/todus/android/rest/BaseDataSource;)V", "", "uid", "Lcu/todus/android/data/wrapper/DataWrapper;", "Lcu/todus/android/data/rest/entity/CardEntity;", "getInfo", "(Ljava/lang/String;Lab/e;)Ljava/lang/Object;", "getInfoOrError", Room.CONFIG_SUBSCRIBED_STATE, "unSubscribe", "Lcu/todus/android/rest/certified/CertifiedInfoService;", "Lcu/todus/android/rest/BaseDataSource;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class CertifiedInfoDataSource {
    public static final int $stable = 8;
    private final BaseDataSource baseDataSource;
    private final CertifiedInfoService service;

    /* JADX INFO: renamed from: cu.todus.android.rest.certified.CertifiedInfoDataSource$getInfo$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @f(c = "cu.todus.android.rest.certified.CertifiedInfoDataSource$getInfo$2", f = "CertifiedInfoDataSource.kt", l = {12}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u0006\u0012\u0002\b\u00030\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lmi/a0;", "<anonymous>", "()Lmi/a0;"}, k = 3, mv = {2, 3, 0})
    public static final class AnonymousClass2 extends m implements Function1 {
        final /* synthetic */ String $uid;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(String str, e<? super AnonymousClass2> eVar) {
            super(1, eVar);
            this.$uid = str;
        }

        @Override // cb.a
        public final e<k0> create(e<?> eVar) {
            return CertifiedInfoDataSource.this.new AnonymousClass2(this.$uid, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(e<? super a0<?>> eVar) {
            return ((AnonymousClass2) create(eVar)).invokeSuspend(k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = b.g();
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v.b(obj);
                return obj;
            }
            v.b(obj);
            CertifiedInfoService certifiedInfoService = CertifiedInfoDataSource.this.service;
            String str = this.$uid;
            this.label = 1;
            Object info = certifiedInfoService.getInfo(str, this);
            return info == objG ? objG : info;
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.rest.certified.CertifiedInfoDataSource$getInfoOrError$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @f(c = "cu.todus.android.rest.certified.CertifiedInfoDataSource$getInfoOrError$2", f = "CertifiedInfoDataSource.kt", l = {16}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u0006\u0012\u0002\b\u00030\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lmi/a0;", "<anonymous>", "()Lmi/a0;"}, k = 3, mv = {2, 3, 0})
    public static final class C11672 extends m implements Function1 {
        final /* synthetic */ String $uid;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C11672(String str, e<? super C11672> eVar) {
            super(1, eVar);
            this.$uid = str;
        }

        @Override // cb.a
        public final e<k0> create(e<?> eVar) {
            return CertifiedInfoDataSource.this.new C11672(this.$uid, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(e<? super a0<?>> eVar) {
            return ((C11672) create(eVar)).invokeSuspend(k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = b.g();
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v.b(obj);
                return obj;
            }
            v.b(obj);
            CertifiedInfoService certifiedInfoService = CertifiedInfoDataSource.this.service;
            String str = this.$uid;
            this.label = 1;
            Object infoOrError = certifiedInfoService.getInfoOrError(str, this);
            return infoOrError == objG ? objG : infoOrError;
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.rest.certified.CertifiedInfoDataSource$subscribe$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @f(c = "cu.todus.android.rest.certified.CertifiedInfoDataSource$subscribe$2", f = "CertifiedInfoDataSource.kt", l = {20}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u0006\u0012\u0002\b\u00030\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lmi/a0;", "<anonymous>", "()Lmi/a0;"}, k = 3, mv = {2, 3, 0})
    public static final class C11682 extends m implements Function1 {
        final /* synthetic */ String $uid;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C11682(String str, e<? super C11682> eVar) {
            super(1, eVar);
            this.$uid = str;
        }

        @Override // cb.a
        public final e<k0> create(e<?> eVar) {
            return CertifiedInfoDataSource.this.new C11682(this.$uid, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(e<? super a0<?>> eVar) {
            return ((C11682) create(eVar)).invokeSuspend(k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = b.g();
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v.b(obj);
                return obj;
            }
            v.b(obj);
            CertifiedInfoService certifiedInfoService = CertifiedInfoDataSource.this.service;
            String str = this.$uid;
            this.label = 1;
            Object objSubscribe = certifiedInfoService.subscribe(str, this);
            return objSubscribe == objG ? objG : objSubscribe;
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.rest.certified.CertifiedInfoDataSource$unSubscribe$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @f(c = "cu.todus.android.rest.certified.CertifiedInfoDataSource$unSubscribe$2", f = "CertifiedInfoDataSource.kt", l = {24}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u0006\u0012\u0002\b\u00030\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lmi/a0;", "<anonymous>", "()Lmi/a0;"}, k = 3, mv = {2, 3, 0})
    public static final class C11692 extends m implements Function1 {
        final /* synthetic */ String $uid;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C11692(String str, e<? super C11692> eVar) {
            super(1, eVar);
            this.$uid = str;
        }

        @Override // cb.a
        public final e<k0> create(e<?> eVar) {
            return CertifiedInfoDataSource.this.new C11692(this.$uid, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(e<? super a0<?>> eVar) {
            return ((C11692) create(eVar)).invokeSuspend(k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = b.g();
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v.b(obj);
                return obj;
            }
            v.b(obj);
            CertifiedInfoService certifiedInfoService = CertifiedInfoDataSource.this.service;
            String str = this.$uid;
            this.label = 1;
            Object objUnSubscribe = certifiedInfoService.unSubscribe(str, this);
            return objUnSubscribe == objG ? objG : objUnSubscribe;
        }
    }

    public CertifiedInfoDataSource(CertifiedInfoService service, BaseDataSource baseDataSource) {
        y.i(service, "service");
        y.i(baseDataSource, "baseDataSource");
        this.service = service;
        this.baseDataSource = baseDataSource;
    }

    public final Object getInfo(String str, e<? super DataWrapper<CardEntity>> eVar) {
        return this.baseDataSource.handleFlowRequest(new AnonymousClass2(str, null), eVar);
    }

    public final Object getInfoOrError(String str, e<? super DataWrapper<Object>> eVar) {
        return this.baseDataSource.handleFlowRequest(new C11672(str, null), eVar);
    }

    public final Object subscribe(String str, e<? super DataWrapper<Object>> eVar) {
        return this.baseDataSource.handleFlowRequest(new C11682(str, null), eVar);
    }

    public final Object unSubscribe(String str, e<? super DataWrapper<Object>> eVar) {
        return this.baseDataSource.handleFlowRequest(new C11692(str, null), eVar);
    }
}
