package cu.z17.views.utils;

import android.graphics.Bitmap;
import androidx.compose.runtime.internal.StabilityInferred;
import cu.z17.compress.UtilKt;
import java.io.File;
import java.io.FileOutputStream;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.y0;
import pe.d1;
import pe.m0;
import ua.k0;
import ua.v;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes7.dex */
@StabilityInferred(parameters = 1)
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JP\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0082@¢\u0006\u0004\b\u0010\u0010\u0011J\"\u0010\u0016\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0086@¢\u0006\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcu/z17/views/utils/ThumbnailGenerator;", "", "<init>", "()V", "Landroid/graphics/Bitmap;", "bitmap", "Ljava/io/File;", "destination", "Landroid/graphics/Bitmap$CompressFormat;", "format", "", "quality", "Lkotlin/Function0;", "Lua/k0;", "onComplete", "onError", "saveBitmap", "(Landroid/graphics/Bitmap;Ljava/io/File;Landroid/graphics/Bitmap$CompressFormat;ILlb/a;Llb/a;Lab/e;)Ljava/lang/Object;", "", "videoPath", "Landroid/content/Context;", "context", "generateVideoThumbnailInFile", "(Ljava/lang/String;Landroid/content/Context;Lab/e;)Ljava/lang/Object;", "views_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ThumbnailGenerator {
    public static final int $stable = 0;
    public static final ThumbnailGenerator INSTANCE = new ThumbnailGenerator();

    /* JADX INFO: renamed from: cu.z17.views.utils.ThumbnailGenerator$generateVideoThumbnailInFile$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.z17.views.utils.ThumbnailGenerator", f = "ThumbnailGenerator.kt", l = {36, 37}, m = "generateVideoThumbnailInFile")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class AnonymousClass1 extends cb.d {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(ab.e<? super AnonymousClass1> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ThumbnailGenerator.this.generateVideoThumbnailInFile(null, null, this);
        }
    }

    /* JADX INFO: renamed from: cu.z17.views.utils.ThumbnailGenerator$saveBitmap$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.z17.views.utils.ThumbnailGenerator$saveBitmap$2", f = "ThumbnailGenerator.kt", l = {}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "", "<anonymous>", "(Lpe/m0;)Ljava/lang/Object;"}, k = 3, mv = {2, 2, 0})
    public static final class AnonymousClass2 extends cb.m implements Function2 {
        final /* synthetic */ Bitmap $bitmap;
        final /* synthetic */ File $destination;
        final /* synthetic */ Bitmap.CompressFormat $format;
        final /* synthetic */ lb.a $onComplete;
        final /* synthetic */ lb.a $onError;
        final /* synthetic */ int $quality;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(File file, Bitmap bitmap, Bitmap.CompressFormat compressFormat, int i10, lb.a aVar, lb.a aVar2, ab.e<? super AnonymousClass2> eVar) {
            super(2, eVar);
            this.$destination = file;
            this.$bitmap = bitmap;
            this.$format = compressFormat;
            this.$quality = i10;
            this.$onError = aVar;
            this.$onComplete = aVar2;
        }

        @Override // cb.a
        public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
            return new AnonymousClass2(this.$destination, this.$bitmap, this.$format, this.$quality, this.$onError, this.$onComplete, eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            FileOutputStream fileOutputStream;
            Throwable th2;
            bb.b.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v.b(obj);
            File parentFile = this.$destination.getParentFile();
            if (parentFile != null) {
                cb.b.a(parentFile.mkdirs());
            }
            FileOutputStream fileOutputStream2 = null;
            try {
                try {
                    fileOutputStream = new FileOutputStream(this.$destination.getAbsolutePath());
                    try {
                        Boolean boolA = cb.b.a(this.$bitmap.compress(this.$format, this.$quality, fileOutputStream));
                        fileOutputStream.flush();
                        fileOutputStream.close();
                        this.$onComplete.invoke();
                        return boolA;
                    } catch (Exception unused) {
                        fileOutputStream2 = fileOutputStream;
                        this.$onError.invoke();
                        k0 k0Var = k0.f43947a;
                        if (fileOutputStream2 != null) {
                            fileOutputStream2.flush();
                            fileOutputStream2.close();
                        }
                        this.$onComplete.invoke();
                        return k0Var;
                    } catch (Throwable th3) {
                        th2 = th3;
                        if (fileOutputStream != null) {
                            fileOutputStream.flush();
                            fileOutputStream.close();
                        }
                        this.$onComplete.invoke();
                        throw th2;
                    }
                } catch (Throwable th4) {
                    fileOutputStream = fileOutputStream2;
                    th2 = th4;
                }
            } catch (Exception unused2) {
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(m0 m0Var, ab.e<Object> eVar) {
            return ((AnonymousClass2) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
        }
    }

    private ThumbnailGenerator() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 generateVideoThumbnailInFile$lambda$2$lambda$1(y0 y0Var) {
        y0Var.f36634c = null;
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object saveBitmap(Bitmap bitmap, File file, Bitmap.CompressFormat compressFormat, int i10, lb.a aVar, lb.a aVar2, ab.e<? super k0> eVar) {
        Object objG = pe.i.g(d1.b(), new AnonymousClass2(file, bitmap, compressFormat, i10, aVar2, aVar, null), eVar);
        return objG == bb.b.g() ? objG : k0.f43947a;
    }

    public static /* synthetic */ Object saveBitmap$default(ThumbnailGenerator thumbnailGenerator, Bitmap bitmap, File file, Bitmap.CompressFormat compressFormat, int i10, lb.a aVar, lb.a aVar2, ab.e eVar, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            compressFormat = UtilKt.compressFormat(file);
        }
        Bitmap.CompressFormat compressFormat2 = compressFormat;
        if ((i11 & 8) != 0) {
            i10 = 100;
        }
        return thumbnailGenerator.saveBitmap(bitmap, file, compressFormat2, i10, aVar, aVar2, eVar);
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0169, code lost:
    
        if (saveBitmap$default(r1, r14, (java.io.File) r4, null, 0, r6, r7, r6, 12, null) == r0) goto L39;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object generateVideoThumbnailInFile(java.lang.String r12, android.content.Context r13, ab.e<? super java.io.File> r14) {
        /*
            Method dump skipped, instruction units count: 367
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.z17.views.utils.ThumbnailGenerator.generateVideoThumbnailInFile(java.lang.String, android.content.Context, ab.e):java.lang.Object");
    }
}
