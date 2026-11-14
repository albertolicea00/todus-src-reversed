package cu.z17.compress.zip;

import ab.e;
import bb.b;
import cb.d;
import cb.f;
import cb.l;
import cb.m;
import hb.c;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.y;
import le.a0;
import pe.d1;
import pe.i;
import pe.m0;
import ua.k0;
import ua.v;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0086@¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcu/z17/compress/zip/ZipManager;", "", "<init>", "()V", "Ljava/io/File;", "zipFile", "", "destinationPath", "", "decompressZipFile", "(Ljava/io/File;Ljava/lang/String;Lab/e;)Ljava/lang/Object;", "compress_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ZipManager {

    /* JADX INFO: renamed from: cu.z17.compress.zip.ZipManager$decompressZipFile$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @f(c = "cu.z17.compress.zip.ZipManager", f = "ZipManager.kt", l = {14}, m = "decompressZipFile")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class AnonymousClass1 extends d {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(e<? super AnonymousClass1> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ZipManager.this.decompressZipFile(null, null, this);
        }
    }

    /* JADX INFO: renamed from: cu.z17.compress.zip.ZipManager$decompressZipFile$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @f(c = "cu.z17.compress.zip.ZipManager$decompressZipFile$2", f = "ZipManager.kt", l = {}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "", "<anonymous>", "(Lpe/m0;)Z"}, k = 3, mv = {2, 2, 0})
    public static final class AnonymousClass2 extends m implements Function2 {
        final /* synthetic */ String $destinationPath;
        final /* synthetic */ File $zipFile;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(File file, String str, e<? super AnonymousClass2> eVar) {
            super(2, eVar);
            this.$zipFile = file;
            this.$destinationPath = str;
        }

        @Override // cb.a
        public final e<k0> create(Object obj, e<?> eVar) {
            return new AnonymousClass2(this.$zipFile, this.$destinationPath, eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) throws IllegalAccessException, IOException, InvocationTargetException {
            b.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v.b(obj);
            byte[] bArr = new byte[4096];
            FileInputStream fileInputStream = new FileInputStream(this.$zipFile);
            String str = this.$destinationPath;
            try {
                ZipInputStream zipInputStream = new ZipInputStream(fileInputStream);
                try {
                    ZipEntry nextEntry = zipInputStream.getNextEntry();
                    while (nextEntry != null) {
                        String name = nextEntry.getName();
                        File file = new File(str, name);
                        y.f(name);
                        if (!a0.U(name, ".", false, 2, null) && !a0.U(name, "__", false, 2, null)) {
                            if (nextEntry.isDirectory()) {
                                cb.b.a(file.mkdirs());
                            } else {
                                File parentFile = file.getParentFile();
                                if (parentFile != null) {
                                    cb.b.a(parentFile.mkdirs());
                                }
                                FileOutputStream fileOutputStream = new FileOutputStream(file);
                                while (true) {
                                    try {
                                        int i10 = zipInputStream.read(bArr);
                                        if (i10 == -1) {
                                            break;
                                        }
                                        fileOutputStream.write(bArr, 0, i10);
                                    } catch (Throwable th2) {
                                        try {
                                            throw th2;
                                        } catch (Throwable th3) {
                                            c.a(fileOutputStream, th2);
                                            throw th3;
                                        }
                                    }
                                }
                                k0 k0Var = k0.f43947a;
                                c.a(fileOutputStream, null);
                            }
                            nextEntry = zipInputStream.getNextEntry();
                        }
                    }
                    k0 k0Var2 = k0.f43947a;
                    c.a(zipInputStream, null);
                    c.a(fileInputStream, null);
                    return cb.b.a(true);
                } catch (Throwable th4) {
                    try {
                        throw th4;
                    } catch (Throwable th5) {
                        c.a(zipInputStream, th4);
                        throw th5;
                    }
                }
            } catch (Throwable th6) {
                try {
                    throw th6;
                } catch (Throwable th7) {
                    c.a(fileInputStream, th6);
                    throw th7;
                }
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(m0 m0Var, e<? super Boolean> eVar) {
            return ((AnonymousClass2) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object decompressZipFile(File file, String str, e<? super Boolean> eVar) {
        AnonymousClass1 anonymousClass1;
        boolean zBooleanValue;
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
        Object objG = anonymousClass1.result;
        Object objG2 = b.g();
        int i11 = anonymousClass1.label;
        try {
            if (i11 == 0) {
                v.b(objG);
                pe.k0 k0VarB = d1.b();
                AnonymousClass2 anonymousClass2 = new AnonymousClass2(file, str, null);
                anonymousClass1.L$0 = l.a(file);
                anonymousClass1.L$1 = l.a(str);
                anonymousClass1.label = 1;
                objG = i.g(k0VarB, anonymousClass2, anonymousClass1);
                if (objG == objG2) {
                    return objG2;
                }
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v.b(objG);
            }
            zBooleanValue = ((Boolean) objG).booleanValue();
        } catch (Exception e10) {
            e10.printStackTrace();
            zBooleanValue = false;
        }
        return cb.b.a(zBooleanValue);
    }
}
