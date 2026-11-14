package cu.z17.preferences;

import ab.e;
import androidx.datastore.preferences.core.Preferences;
import androidx.exifinterface.media.ExifInterface;
import cb.d;
import cb.f;
import cb.l;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import ef.t;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.w;
import kotlin.jvm.internal.y;
import te.b0;
import te.h;
import te.i;
import ua.k0;
import ua.v;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J!\u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lte/h;", "Lte/i;", "collector", "Lua/k0;", "collect", "(Lte/i;Lab/e;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PreferencesRepositoryImpl$secureMap$$inlined$map$1 implements h {
    final /* synthetic */ Object $default$inlined;
    final /* synthetic */ Function1 $fetchValue$inlined;
    final /* synthetic */ h $this_unsafeTransform$inlined;
    final /* synthetic */ PreferencesRepositoryImpl this$0;

    /* JADX INFO: renamed from: cu.z17.preferences.PreferencesRepositoryImpl$secureMap$$inlined$map$1$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "R", AppMeasurementSdk.ConditionalUserProperty.VALUE, "Lua/k0;", "emit", "(Ljava/lang/Object;Lab/e;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {2, 2, 0})
    public static final class AnonymousClass2<T> implements i {
        final /* synthetic */ Object $default$inlined;
        final /* synthetic */ Function1 $fetchValue$inlined;
        final /* synthetic */ i $this_unsafeFlow;
        final /* synthetic */ PreferencesRepositoryImpl this$0;

        /* JADX INFO: renamed from: cu.z17.preferences.PreferencesRepositoryImpl$secureMap$$inlined$map$1$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        @f(c = "cu.z17.preferences.PreferencesRepositoryImpl$secureMap$$inlined$map$1$2", f = "PreferencesRepositoryImpl.kt", l = {223}, m = "emit")
        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        public static final class AnonymousClass1 extends d {
            int I$0;
            Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            int label;
            /* synthetic */ Object result;

            public AnonymousClass1(e eVar) {
                super(eVar);
            }

            @Override // cb.a
            public final Object invokeSuspend(Object obj) {
                this.result = obj;
                this.label |= Integer.MIN_VALUE;
                return AnonymousClass2.this.emit(null, this);
            }
        }

        public AnonymousClass2(i iVar, Function1 function1, PreferencesRepositoryImpl preferencesRepositoryImpl, Object obj) {
            this.$this_unsafeFlow = iVar;
            this.$fetchValue$inlined = function1;
            this.this$0 = preferencesRepositoryImpl;
            this.$default$inlined = obj;
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        @Override // te.i
        public final Object emit(Object obj, e eVar) {
            AnonymousClass1 anonymousClass1;
            Object objA;
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
            Object obj2 = anonymousClass1.result;
            Object objG = bb.b.g();
            int i11 = anonymousClass1.label;
            if (i11 == 0) {
                v.b(obj2);
                i iVar = this.$this_unsafeFlow;
                try {
                    String str = (String) this.$fetchValue$inlined.invoke((Preferences) obj);
                    if (str != null) {
                        String strDecrypt = this.this$0.encryption.decrypt(str);
                        kf.b bVarB = kf.v.b(null, PreferencesRepositoryImpl$secureMap$1$1.INSTANCE, 1, null);
                        y.n(6, ExifInterface.GPS_DIRECTION_TRUE);
                        ef.b bVarD = t.d(null);
                        y.g(bVarD, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                        y.f(strDecrypt);
                        objA = bVarB.a(bVarD, strDecrypt);
                    } else {
                        objA = this.$default$inlined;
                    }
                } catch (Exception unused) {
                    b0 b0Var = this.this$0.errors;
                    b0Var.setValue(cb.b.d(((Number) b0Var.getValue()).intValue() + 1));
                    objA = this.$default$inlined;
                }
                anonymousClass1.L$0 = l.a(obj);
                anonymousClass1.L$1 = l.a(anonymousClass1);
                anonymousClass1.L$2 = l.a(obj);
                anonymousClass1.L$3 = l.a(iVar);
                anonymousClass1.I$0 = 0;
                anonymousClass1.label = 1;
                if (iVar.emit(objA, anonymousClass1) == objG) {
                    return objG;
                }
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v.b(obj2);
            }
            return k0.f43947a;
        }

        public final Object emit$$forInline(Object obj, e eVar) {
            Object objA;
            w.c(4);
            new AnonymousClass1(eVar);
            w.c(5);
            i iVar = this.$this_unsafeFlow;
            try {
                String str = (String) this.$fetchValue$inlined.invoke((Preferences) obj);
                if (str != null) {
                    String strDecrypt = this.this$0.encryption.decrypt(str);
                    kf.b bVarB = kf.v.b(null, PreferencesRepositoryImpl$secureMap$1$1.INSTANCE, 1, null);
                    y.n(6, ExifInterface.GPS_DIRECTION_TRUE);
                    ef.b bVarD = t.d(null);
                    y.g(bVarD, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                    y.f(strDecrypt);
                    objA = bVarB.a(bVarD, strDecrypt);
                } else {
                    objA = this.$default$inlined;
                }
            } catch (Exception unused) {
                b0 b0Var = this.this$0.errors;
                b0Var.setValue(Integer.valueOf(((Number) b0Var.getValue()).intValue() + 1));
                objA = this.$default$inlined;
            }
            w.c(0);
            iVar.emit(objA, eVar);
            w.c(1);
            return k0.f43947a;
        }
    }

    public PreferencesRepositoryImpl$secureMap$$inlined$map$1(h hVar, Function1 function1, PreferencesRepositoryImpl preferencesRepositoryImpl, Object obj) {
        this.$this_unsafeTransform$inlined = hVar;
        this.$fetchValue$inlined = function1;
        this.this$0 = preferencesRepositoryImpl;
        this.$default$inlined = obj;
    }

    @Override // te.h
    public Object collect(i iVar, e eVar) {
        h hVar = this.$this_unsafeTransform$inlined;
        y.m();
        Object objCollect = hVar.collect(new AnonymousClass2(iVar, this.$fetchValue$inlined, this.this$0, this.$default$inlined), eVar);
        return objCollect == bb.b.g() ? objCollect : k0.f43947a;
    }

    public Object collect$$forInline(i iVar, e eVar) {
        w.c(4);
        new d(eVar) { // from class: cu.z17.preferences.PreferencesRepositoryImpl$secureMap$$inlined$map$1.1
            int label;
            /* synthetic */ Object result;

            @Override // cb.a
            public final Object invokeSuspend(Object obj) {
                this.result = obj;
                this.label |= Integer.MIN_VALUE;
                return PreferencesRepositoryImpl$secureMap$$inlined$map$1.this.collect(null, this);
            }
        };
        w.c(5);
        h hVar = this.$this_unsafeTransform$inlined;
        y.m();
        AnonymousClass2 anonymousClass2 = new AnonymousClass2(iVar, this.$fetchValue$inlined, this.this$0, this.$default$inlined);
        w.c(0);
        hVar.collect(anonymousClass2, eVar);
        w.c(1);
        return k0.f43947a;
    }
}
