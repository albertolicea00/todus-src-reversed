package cu.z17.compress;

import ab.i;
import android.content.Context;
import android.graphics.Bitmap;
import cb.f;
import cb.m;
import cu.z17.compress.constraint.Compression;
import cu.z17.compress.constraint.Constraint;
import cu.z17.compress.constraint.DefaultConstraintKt;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.y;
import org.jivesoftware.smack.compress.packet.Compress;
import pe.d1;
import pe.e2;
import pe.m0;
import ua.k0;
import ua.v;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JJ\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\n2\u0014\b\u0002\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fH\u0086@¢\u0006\u0004\b\u0010\u0010\u0011J@\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\n2\u0014\b\u0002\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fH\u0086@¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcu/z17/compress/Compressor;", "", "<init>", "()V", "Landroid/content/Context;", "context", "Ljava/io/File;", "imageFile", "", "returnToDefault", "Lab/i;", "coroutineContext", "Lkotlin/Function1;", "Lcu/z17/compress/constraint/Compression;", "Lua/k0;", "compressionPatch", Compress.ELEMENT, "(Landroid/content/Context;Ljava/io/File;ZLab/i;Lkotlin/jvm/functions/Function1;Lab/e;)Ljava/lang/Object;", "Landroid/graphics/Bitmap;", "compressAndGetBitmap", "(Landroid/content/Context;Ljava/io/File;Lab/i;Lkotlin/jvm/functions/Function1;Lab/e;)Ljava/lang/Object;", "compress_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class Compressor {
    public static final Compressor INSTANCE = new Compressor();

    /* JADX INFO: renamed from: cu.z17.compress.Compressor$compress$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @f(c = "cu.z17.compress.Compressor$compress$3", f = "Compressor.kt", l = {}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Ljava/io/File;", "<anonymous>", "(Lpe/m0;)Ljava/io/File;"}, k = 3, mv = {2, 2, 0})
    public static final class AnonymousClass3 extends m implements Function2 {
        final /* synthetic */ Function1 $compressionPatch;
        final /* synthetic */ Context $context;
        final /* synthetic */ File $imageFile;
        final /* synthetic */ boolean $returnToDefault;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(Function1 function1, Context context, File file, boolean z10, ab.e<? super AnonymousClass3> eVar) {
            super(2, eVar);
            this.$compressionPatch = function1;
            this.$context = context;
            this.$imageFile = file;
            this.$returnToDefault = z10;
        }

        @Override // cb.a
        public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
            return new AnonymousClass3(this.$compressionPatch, this.$context, this.$imageFile, this.$returnToDefault, eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            bb.b.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v.b(obj);
            Compression compression = new Compression();
            this.$compressionPatch.invoke(compression);
            File fileCopyToCache = UtilKt.copyToCache(this.$context, this.$imageFile);
            for (Constraint constraint : compression.getConstraints$compress_release()) {
                while (!constraint.isSatisfied(fileCopyToCache)) {
                    fileCopyToCache = constraint.satisfy(fileCopyToCache);
                }
            }
            if (!this.$returnToDefault) {
                return fileCopyToCache;
            }
            this.$imageFile.delete();
            CompressorKt.copyFileUsingStream(fileCopyToCache, this.$imageFile);
            fileCopyToCache.delete();
            return new File(this.$imageFile.getPath());
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(m0 m0Var, ab.e<? super File> eVar) {
            return ((AnonymousClass3) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
        }
    }

    /* JADX INFO: renamed from: cu.z17.compress.Compressor$compressAndGetBitmap$3, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @f(c = "cu.z17.compress.Compressor$compressAndGetBitmap$3", f = "Compressor.kt", l = {}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Landroid/graphics/Bitmap;", "<anonymous>", "(Lpe/m0;)Landroid/graphics/Bitmap;"}, k = 3, mv = {2, 2, 0})
    public static final class C15173 extends m implements Function2 {
        final /* synthetic */ Function1 $compressionPatch;
        final /* synthetic */ Context $context;
        final /* synthetic */ File $imageFile;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C15173(Function1 function1, Context context, File file, ab.e<? super C15173> eVar) {
            super(2, eVar);
            this.$compressionPatch = function1;
            this.$context = context;
            this.$imageFile = file;
        }

        @Override // cb.a
        public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
            return new C15173(this.$compressionPatch, this.$context, this.$imageFile, eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            bb.b.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v.b(obj);
            Compression compression = new Compression();
            this.$compressionPatch.invoke(compression);
            File fileCopyToCache = UtilKt.copyToCache(this.$context, this.$imageFile);
            for (Constraint constraint : compression.getConstraints$compress_release()) {
                while (!constraint.isSatisfied(fileCopyToCache)) {
                    fileCopyToCache = constraint.satisfy(fileCopyToCache);
                }
            }
            return UtilKt.loadBitmap(fileCopyToCache);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(m0 m0Var, ab.e<? super Bitmap> eVar) {
            return ((C15173) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
        }
    }

    private Compressor() {
    }

    public static /* synthetic */ Object compress$default(Compressor compressor, Context context, File file, boolean z10, i iVar, Function1 function1, ab.e eVar, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        boolean z11 = z10;
        if ((i10 & 8) != 0) {
            iVar = d1.b();
        }
        i iVar2 = iVar;
        if ((i10 & 16) != 0) {
            function1 = new Function1() { // from class: cu.z17.compress.b
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return Compressor.compress$lambda$0((Compression) obj2);
                }
            };
        }
        return compressor.compress(context, file, z11, iVar2, function1, eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 compress$lambda$0(Compression compression) {
        y.i(compression, "<this>");
        DefaultConstraintKt.default$default(compression, 0, 0, null, 0, 15, null);
        return k0.f43947a;
    }

    public static /* synthetic */ Object compressAndGetBitmap$default(Compressor compressor, Context context, File file, i iVar, Function1 function1, ab.e eVar, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            iVar = d1.b();
        }
        i iVar2 = iVar;
        if ((i10 & 8) != 0) {
            function1 = new Function1() { // from class: cu.z17.compress.a
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return Compressor.compressAndGetBitmap$lambda$1((Compression) obj2);
                }
            };
        }
        return compressor.compressAndGetBitmap(context, file, iVar2, function1, eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 compressAndGetBitmap$lambda$1(Compression compression) {
        y.i(compression, "<this>");
        DefaultConstraintKt.default$default(compression, 0, 0, null, 0, 15, null);
        return k0.f43947a;
    }

    public final Object compress(Context context, File file, boolean z10, i iVar, Function1 function1, ab.e<? super File> eVar) {
        return pe.i.g(iVar.plus(e2.b(null, 1, null)), new AnonymousClass3(function1, context, file, z10, null), eVar);
    }

    public final Object compressAndGetBitmap(Context context, File file, i iVar, Function1 function1, ab.e<? super Bitmap> eVar) {
        return pe.i.g(iVar.plus(e2.b(null, 1, null)), new C15173(function1, context, file, null), eVar);
    }
}
