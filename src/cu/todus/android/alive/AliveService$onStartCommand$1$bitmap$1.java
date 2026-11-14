package cu.todus.android.alive;

import ab.e;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import androidx.compose.ui.spatial.RectListKt;
import cb.f;
import cb.m;
import java.io.IOException;
import java.net.URL;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import pe.d1;
import pe.i;
import pe.m0;
import ua.k0;
import ua.v;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@f(c = "cu.todus.android.alive.AliveService$onStartCommand$1$bitmap$1", f = "AliveService.kt", l = {RectListKt.BitOffsetForFocusable}, m = "invokeSuspend", v = 2)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Landroid/graphics/Bitmap;", "<anonymous>", "(Lpe/m0;)Landroid/graphics/Bitmap;"}, k = 3, mv = {2, 3, 0})
public final class AliveService$onStartCommand$1$bitmap$1 extends m implements Function2 {
    final /* synthetic */ String $image;
    int label;

    /* JADX INFO: renamed from: cu.todus.android.alive.AliveService$onStartCommand$1$bitmap$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @f(c = "cu.todus.android.alive.AliveService$onStartCommand$1$bitmap$1$1", f = "AliveService.kt", l = {}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Landroid/graphics/Bitmap;", "<anonymous>", "(Lpe/m0;)Landroid/graphics/Bitmap;"}, k = 3, mv = {2, 3, 0})
    public static final class AnonymousClass1 extends m implements Function2 {
        final /* synthetic */ String $image;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str, e<? super AnonymousClass1> eVar) {
            super(2, eVar);
            this.$image = str;
        }

        @Override // cb.a
        public final e<k0> create(Object obj, e<?> eVar) {
            return new AnonymousClass1(this.$image, eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            bb.b.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v.b(obj);
            try {
                return BitmapFactory.decodeStream(new URL(this.$image).openStream());
            } catch (IOException unused) {
                return null;
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(m0 m0Var, e<? super Bitmap> eVar) {
            return ((AnonymousClass1) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AliveService$onStartCommand$1$bitmap$1(String str, e<? super AliveService$onStartCommand$1$bitmap$1> eVar) {
        super(2, eVar);
        this.$image = str;
    }

    @Override // cb.a
    public final e<k0> create(Object obj, e<?> eVar) {
        return new AliveService$onStartCommand$1$bitmap$1(this.$image, eVar);
    }

    @Override // cb.a
    public final Object invokeSuspend(Object obj) {
        Object objG = bb.b.g();
        int i10 = this.label;
        if (i10 != 0) {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v.b(obj);
            return obj;
        }
        v.b(obj);
        pe.k0 k0VarB = d1.b();
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$image, null);
        this.label = 1;
        Object objG2 = i.g(k0VarB, anonymousClass1, this);
        return objG2 == objG ? objG : objG2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(m0 m0Var, e<? super Bitmap> eVar) {
        return ((AliveService$onStartCommand$1$bitmap$1) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
    }
}
