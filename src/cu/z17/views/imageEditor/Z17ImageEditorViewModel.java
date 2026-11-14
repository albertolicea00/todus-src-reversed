package cu.z17.views.imageEditor;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.widget.Toast;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.p001lifecycle.ViewModel;
import androidx.p001lifecycle.ViewModelKt;
import cu.z17.compress.Compressor;
import cu.z17.compress.UtilKt;
import cu.z17.compress.constraint.Compression;
import cu.z17.compress.constraint.SizeConstraintKt;
import cu.z17.views.R;
import cu.z17.views.camera.Z17CameraModule;
import cu.z17.views.imageEditor.sections.rotater.RotaterKt;
import cu.z17.views.utils.Z17MutableListFlow;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.y0;
import org.jivesoftware.smackx.muc.packet.MUCInitialPresence;
import pe.d1;
import te.r0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ-\u0010\u0011\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0006¢\u0006\u0004\b\u0014\u0010\u0015J\u001d\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001a0\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u001d\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001a0!8\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u001d\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00040&8\u0006¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R(\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00040&8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b+\u0010(\u001a\u0004\b,\u0010*\"\u0004\b-\u0010.¨\u0006/"}, d2 = {"Lcu/z17/views/imageEditor/Z17ImageEditorViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "Landroid/graphics/Bitmap;", "imageBitmap", "", "imagePathToSave", "Lua/k0;", "setBitmap", "(Landroid/graphics/Bitmap;Ljava/lang/String;)V", "Landroid/net/Uri;", "imageUri", "", "firstCompression", "", "initialRotation", "loadBitmap", "(Landroid/net/Uri;Ljava/lang/String;ZF)V", "imagePath", "requestStepBack", "(Ljava/lang/String;)V", "Landroid/content/Context;", "context", "requestCompress", "(Ljava/lang/String;Landroid/content/Context;)V", "Lcu/z17/views/imageEditor/Z17EditorState;", "z17EditorState", "requestState", "(Lcu/z17/views/imageEditor/Z17EditorState;)V", "Lte/b0;", "_currentState", "Lte/b0;", "Lte/p0;", "currentState", "Lte/p0;", "getCurrentState", "()Lte/p0;", "Lcu/z17/views/utils/Z17MutableListFlow;", MUCInitialPresence.History.ELEMENT, "Lcu/z17/views/utils/Z17MutableListFlow;", "getHistory", "()Lcu/z17/views/utils/Z17MutableListFlow;", "filteredBitmaps", "getFilteredBitmaps", "setFilteredBitmaps", "(Lcu/z17/views/utils/Z17MutableListFlow;)V", "views_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class Z17ImageEditorViewModel extends ViewModel {
    public static final int $stable = 8;
    private final te.b0 _currentState;
    private final te.p0 currentState;
    private Z17MutableListFlow<Bitmap> filteredBitmaps;
    private final Z17MutableListFlow<Bitmap> history;

    /* JADX INFO: renamed from: cu.z17.views.imageEditor.Z17ImageEditorViewModel$loadBitmap$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.z17.views.imageEditor.Z17ImageEditorViewModel$loadBitmap$1", f = "Z17ImageEditorViewModel.kt", l = {74}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 2, 0})
    public static final class AnonymousClass1 extends cb.m implements Function2 {
        final /* synthetic */ boolean $firstCompression;
        final /* synthetic */ String $imagePathToSave;
        final /* synthetic */ Uri $imageUri;
        final /* synthetic */ float $initialRotation;
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        final /* synthetic */ Z17ImageEditorViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Uri uri, Z17ImageEditorViewModel z17ImageEditorViewModel, float f10, String str, boolean z10, ab.e<? super AnonymousClass1> eVar) {
            super(2, eVar);
            this.$imageUri = uri;
            this.this$0 = z17ImageEditorViewModel;
            this.$initialRotation = f10;
            this.$imagePathToSave = str;
            this.$firstCompression = z10;
        }

        @Override // cb.a
        public final ab.e<ua.k0> create(Object obj, ab.e<?> eVar) {
            return new AnonymousClass1(this.$imageUri, this.this$0, this.$initialRotation, this.$imagePathToSave, this.$firstCompression, eVar);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Z17ImageEditorViewModel z17ImageEditorViewModel;
            y0 y0Var;
            Object objG = bb.b.g();
            int i10 = this.label;
            try {
                try {
                    if (i10 == 0) {
                        ua.v.b(obj);
                        String path = this.$imageUri.getPath();
                        if (path != null) {
                            Uri uri = this.$imageUri;
                            float f10 = this.$initialRotation;
                            Z17ImageEditorViewModel z17ImageEditorViewModel2 = this.this$0;
                            String str = this.$imagePathToSave;
                            boolean z10 = this.$firstCompression;
                            y0 y0Var2 = new y0();
                            String path2 = uri.getPath();
                            if (path2 == null) {
                                path2 = "/";
                            }
                            Bitmap bitmapLoadBitmap = UtilKt.loadBitmap(new File(path2));
                            y0Var2.f36634c = bitmapLoadBitmap;
                            if (f10 != 0.0f) {
                                y0Var2.f36634c = RotaterKt.rotate(bitmapLoadBitmap, f10);
                            }
                            pe.k0 k0VarB = d1.b();
                            Z17ImageEditorViewModel$loadBitmap$1$1$1 z17ImageEditorViewModel$loadBitmap$1$1$1 = new Z17ImageEditorViewModel$loadBitmap$1$1$1(str, y0Var2, z10, null);
                            this.L$0 = z17ImageEditorViewModel2;
                            this.L$1 = cb.l.a(path);
                            this.L$2 = y0Var2;
                            this.I$0 = 0;
                            this.label = 1;
                            if (pe.i.g(k0VarB, z17ImageEditorViewModel$loadBitmap$1$1$1, this) == objG) {
                                return objG;
                            }
                            z17ImageEditorViewModel = z17ImageEditorViewModel2;
                            y0Var = y0Var2;
                        }
                        this.this$0._currentState.setValue(Z17EditorState.VIEW);
                        return ua.k0.f43947a;
                    }
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    y0Var = (y0) this.L$2;
                    z17ImageEditorViewModel = (Z17ImageEditorViewModel) this.L$0;
                    ua.v.b(obj);
                    z17ImageEditorViewModel.getHistory().add(y0Var.f36634c);
                } catch (Exception e10) {
                    e10.printStackTrace();
                    ua.k0 k0Var = ua.k0.f43947a;
                }
                this.this$0._currentState.setValue(Z17EditorState.VIEW);
            } catch (Exception e11) {
                e11.printStackTrace();
                this.this$0._currentState.setValue(Z17EditorState.ERROR);
            }
            return ua.k0.f43947a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(pe.m0 m0Var, ab.e<? super ua.k0> eVar) {
            return ((AnonymousClass1) create(m0Var, eVar)).invokeSuspend(ua.k0.f43947a);
        }
    }

    /* JADX INFO: renamed from: cu.z17.views.imageEditor.Z17ImageEditorViewModel$requestCompress$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.z17.views.imageEditor.Z17ImageEditorViewModel$requestCompress$1", f = "Z17ImageEditorViewModel.kt", l = {140}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 2, 0})
    public static final class C15281 extends cb.m implements Function2 {
        final /* synthetic */ Context $context;
        final /* synthetic */ String $imagePathToSave;
        int label;

        /* JADX INFO: renamed from: cu.z17.views.imageEditor.Z17ImageEditorViewModel$requestCompress$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        @cb.f(c = "cu.z17.views.imageEditor.Z17ImageEditorViewModel$requestCompress$1$1", f = "Z17ImageEditorViewModel.kt", l = {147}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "", "<anonymous>", "(Lpe/m0;)Ljava/lang/Object;"}, k = 3, mv = {2, 2, 0})
        public static final class C02771 extends cb.m implements Function2 {
            final /* synthetic */ Context $context;
            final /* synthetic */ String $imagePathToSave;
            long J$0;
            Object L$0;
            int label;
            final /* synthetic */ Z17ImageEditorViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C02771(String str, Context context, Z17ImageEditorViewModel z17ImageEditorViewModel, ab.e<? super C02771> eVar) {
                super(2, eVar);
                this.$imagePathToSave = str;
                this.$context = context;
                this.this$0 = z17ImageEditorViewModel;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final ua.k0 invokeSuspend$lambda$0(long j10, Compression compression) {
                SizeConstraintKt.size(compression, j10 / ((long) 4), 10, 10);
                return ua.k0.f43947a;
            }

            @Override // cb.a
            public final ab.e<ua.k0> create(Object obj, ab.e<?> eVar) {
                return new C02771(this.$imagePathToSave, this.$context, this.this$0, eVar);
            }

            @Override // cb.a
            public final Object invokeSuspend(Object obj) {
                C02771 c02771;
                long j10;
                Exception exc;
                Object objG = bb.b.g();
                int i10 = this.label;
                if (i10 == 0) {
                    ua.v.b(obj);
                    try {
                        File file = new File(this.$imagePathToSave);
                        final long length = file.length();
                        Compressor compressor = Compressor.INSTANCE;
                        Context context = this.$context;
                        Function1 function1 = new Function1() { // from class: cu.z17.views.imageEditor.p0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return Z17ImageEditorViewModel.C15281.C02771.invokeSuspend$lambda$0(length, (Compression) obj2);
                            }
                        };
                        this.L$0 = cb.l.a(file);
                        this.J$0 = length;
                        this.label = 1;
                        c02771 = this;
                        try {
                            obj = Compressor.compress$default(compressor, context, file, true, null, function1, c02771, 8, null);
                            if (obj == objG) {
                                return objG;
                            }
                            j10 = length;
                        } catch (Exception e10) {
                            e = e10;
                            exc = e;
                            exc.printStackTrace();
                            return ua.k0.f43947a;
                        }
                    } catch (Exception e11) {
                        e = e11;
                        exc = e;
                        exc.printStackTrace();
                        return ua.k0.f43947a;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    j10 = this.J$0;
                    try {
                        ua.v.b(obj);
                        c02771 = this;
                    } catch (Exception e12) {
                        exc = e12;
                        exc.printStackTrace();
                        return ua.k0.f43947a;
                    }
                }
                File file2 = (File) obj;
                if (file2.length() > j10) {
                    Context context2 = c02771.$context;
                    Toast.makeText(context2, context2.getText(R.string.cannot_compressed_this_time), 0).show();
                }
                return c02771.this$0.getHistory().add(UtilKt.loadBitmap(file2));
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(pe.m0 m0Var, ab.e<Object> eVar) {
                return ((C02771) create(m0Var, eVar)).invokeSuspend(ua.k0.f43947a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C15281(String str, Context context, ab.e<? super C15281> eVar) {
            super(2, eVar);
            this.$imagePathToSave = str;
            this.$context = context;
        }

        @Override // cb.a
        public final ab.e<ua.k0> create(Object obj, ab.e<?> eVar) {
            return Z17ImageEditorViewModel.this.new C15281(this.$imagePathToSave, this.$context, eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                ua.v.b(obj);
                Z17ImageEditorViewModel.this._currentState.setValue(Z17EditorState.LOADING);
                pe.k0 k0VarB = d1.b();
                C02771 c02771 = new C02771(this.$imagePathToSave, this.$context, Z17ImageEditorViewModel.this, null);
                this.label = 1;
                if (pe.i.g(k0VarB, c02771, this) == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ua.v.b(obj);
            }
            Z17ImageEditorViewModel.this._currentState.setValue(Z17EditorState.VIEW);
            return ua.k0.f43947a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(pe.m0 m0Var, ab.e<? super ua.k0> eVar) {
            return ((C15281) create(m0Var, eVar)).invokeSuspend(ua.k0.f43947a);
        }
    }

    /* JADX INFO: renamed from: cu.z17.views.imageEditor.Z17ImageEditorViewModel$requestStepBack$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.z17.views.imageEditor.Z17ImageEditorViewModel$requestStepBack$1", f = "Z17ImageEditorViewModel.kt", l = {115}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 2, 0})
    public static final class C15291 extends cb.m implements Function2 {
        final /* synthetic */ String $imagePath;
        Object L$0;
        int label;

        /* JADX INFO: renamed from: cu.z17.views.imageEditor.Z17ImageEditorViewModel$requestStepBack$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        @cb.f(c = "cu.z17.views.imageEditor.Z17ImageEditorViewModel$requestStepBack$1$1", f = "Z17ImageEditorViewModel.kt", l = {117}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 2, 0})
        public static final class C02781 extends cb.m implements Function2 {
            final /* synthetic */ File $file;
            Object L$0;
            int label;
            final /* synthetic */ Z17ImageEditorViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C02781(File file, Z17ImageEditorViewModel z17ImageEditorViewModel, ab.e<? super C02781> eVar) {
                super(2, eVar);
                this.$file = file;
                this.this$0 = z17ImageEditorViewModel;
            }

            @Override // cb.a
            public final ab.e<ua.k0> create(Object obj, ab.e<?> eVar) {
                return new C02781(this.$file, this.this$0, eVar);
            }

            @Override // cb.a
            public final Object invokeSuspend(Object obj) throws IOException {
                FileOutputStream fileOutputStream;
                Object objG = bb.b.g();
                int i10 = this.label;
                if (i10 == 0) {
                    ua.v.b(obj);
                    FileOutputStream fileOutputStream2 = new FileOutputStream(this.$file);
                    te.h value = this.this$0.getHistory().getValue();
                    this.L$0 = fileOutputStream2;
                    this.label = 1;
                    Object objX = te.j.x(value, this);
                    if (objX == objG) {
                        return objG;
                    }
                    fileOutputStream = fileOutputStream2;
                    obj = objX;
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    fileOutputStream = (FileOutputStream) this.L$0;
                    ua.v.b(obj);
                }
                Bitmap bitmap = (Bitmap) va.g0.K0((List) obj);
                if (bitmap != null) {
                    Bitmap.CompressFormat defaultFormat = Z17CameraModule.INSTANCE.getInstance().getDefaultFormat();
                    if (defaultFormat == null) {
                        defaultFormat = Build.VERSION.SDK_INT >= 30 ? Bitmap.CompressFormat.WEBP_LOSSY : Bitmap.CompressFormat.WEBP;
                    }
                    cb.b.a(bitmap.compress(defaultFormat, 90, fileOutputStream));
                }
                fileOutputStream.flush();
                fileOutputStream.close();
                return ua.k0.f43947a;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(pe.m0 m0Var, ab.e<? super ua.k0> eVar) {
                return ((C02781) create(m0Var, eVar)).invokeSuspend(ua.k0.f43947a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C15291(String str, ab.e<? super C15291> eVar) {
            super(2, eVar);
            this.$imagePath = str;
        }

        @Override // cb.a
        public final ab.e<ua.k0> create(Object obj, ab.e<?> eVar) {
            return Z17ImageEditorViewModel.this.new C15291(this.$imagePath, eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = bb.b.g();
            int i10 = this.label;
            try {
                if (i10 == 0) {
                    ua.v.b(obj);
                    Z17ImageEditorViewModel.this.getHistory().removeLast();
                    File file = new File(this.$imagePath);
                    pe.k0 k0VarB = d1.b();
                    C02781 c02781 = new C02781(file, Z17ImageEditorViewModel.this, null);
                    this.L$0 = cb.l.a(file);
                    this.label = 1;
                    if (pe.i.g(k0VarB, c02781, this) == objG) {
                        return objG;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ua.v.b(obj);
                }
            } catch (Exception e10) {
                e10.printStackTrace();
            }
            Z17ImageEditorViewModel.this._currentState.setValue(Z17EditorState.VIEW);
            return ua.k0.f43947a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(pe.m0 m0Var, ab.e<? super ua.k0> eVar) {
            return ((C15291) create(m0Var, eVar)).invokeSuspend(ua.k0.f43947a);
        }
    }

    /* JADX INFO: renamed from: cu.z17.views.imageEditor.Z17ImageEditorViewModel$setBitmap$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.z17.views.imageEditor.Z17ImageEditorViewModel$setBitmap$1", f = "Z17ImageEditorViewModel.kt", l = {37}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 2, 0})
    public static final class C15301 extends cb.m implements Function2 {
        final /* synthetic */ Bitmap $imageBitmap;
        final /* synthetic */ String $imagePathToSave;
        int label;

        /* JADX INFO: renamed from: cu.z17.views.imageEditor.Z17ImageEditorViewModel$setBitmap$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        @cb.f(c = "cu.z17.views.imageEditor.Z17ImageEditorViewModel$setBitmap$1$1", f = "Z17ImageEditorViewModel.kt", l = {}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 2, 0})
        public static final class C02791 extends cb.m implements Function2 {
            final /* synthetic */ Bitmap $imageBitmap;
            final /* synthetic */ String $imagePathToSave;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C02791(String str, Bitmap bitmap, ab.e<? super C02791> eVar) {
                super(2, eVar);
                this.$imagePathToSave = str;
                this.$imageBitmap = bitmap;
            }

            @Override // cb.a
            public final ab.e<ua.k0> create(Object obj, ab.e<?> eVar) {
                return new C02791(this.$imagePathToSave, this.$imageBitmap, eVar);
            }

            @Override // cb.a
            public final Object invokeSuspend(Object obj) throws IOException {
                bb.b.g();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ua.v.b(obj);
                FileOutputStream fileOutputStream = new FileOutputStream(new File(this.$imagePathToSave));
                Bitmap bitmap = this.$imageBitmap;
                Bitmap.CompressFormat defaultFormat = Z17CameraModule.INSTANCE.getInstance().getDefaultFormat();
                if (defaultFormat == null) {
                    defaultFormat = Build.VERSION.SDK_INT >= 30 ? Bitmap.CompressFormat.WEBP_LOSSY : Bitmap.CompressFormat.WEBP;
                }
                bitmap.compress(defaultFormat, 90, fileOutputStream);
                fileOutputStream.flush();
                fileOutputStream.close();
                return ua.k0.f43947a;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(pe.m0 m0Var, ab.e<? super ua.k0> eVar) {
                return ((C02791) create(m0Var, eVar)).invokeSuspend(ua.k0.f43947a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C15301(String str, Bitmap bitmap, ab.e<? super C15301> eVar) {
            super(2, eVar);
            this.$imagePathToSave = str;
            this.$imageBitmap = bitmap;
        }

        @Override // cb.a
        public final ab.e<ua.k0> create(Object obj, ab.e<?> eVar) {
            return Z17ImageEditorViewModel.this.new C15301(this.$imagePathToSave, this.$imageBitmap, eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = bb.b.g();
            int i10 = this.label;
            try {
                if (i10 == 0) {
                    ua.v.b(obj);
                    pe.k0 k0VarB = d1.b();
                    C02791 c02791 = new C02791(this.$imagePathToSave, this.$imageBitmap, null);
                    this.label = 1;
                    if (pe.i.g(k0VarB, c02791, this) == objG) {
                        return objG;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ua.v.b(obj);
                }
            } catch (Exception e10) {
                e10.printStackTrace();
            }
            Z17ImageEditorViewModel.this._currentState.setValue(Z17EditorState.VIEW);
            return ua.k0.f43947a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(pe.m0 m0Var, ab.e<? super ua.k0> eVar) {
            return ((C15301) create(m0Var, eVar)).invokeSuspend(ua.k0.f43947a);
        }
    }

    public Z17ImageEditorViewModel() {
        te.b0 b0VarA = r0.a(Z17EditorState.LOADING);
        this._currentState = b0VarA;
        this.currentState = te.j.b(b0VarA);
        this.history = new Z17MutableListFlow<>(va.w.n());
        this.filteredBitmaps = new Z17MutableListFlow<>(null, 1, null);
    }

    public final te.p0 getCurrentState() {
        return this.currentState;
    }

    public final Z17MutableListFlow<Bitmap> getFilteredBitmaps() {
        return this.filteredBitmaps;
    }

    public final Z17MutableListFlow<Bitmap> getHistory() {
        return this.history;
    }

    public final void loadBitmap(Uri imageUri, String imagePathToSave, boolean firstCompression, float initialRotation) {
        kotlin.jvm.internal.y.i(imageUri, "imageUri");
        kotlin.jvm.internal.y.i(imagePathToSave, "imagePathToSave");
        pe.k.d(ViewModelKt.getViewModelScope(this), d1.b(), null, new AnonymousClass1(imageUri, this, initialRotation, imagePathToSave, firstCompression, null), 2, null);
    }

    public final void requestCompress(String imagePathToSave, Context context) {
        kotlin.jvm.internal.y.i(imagePathToSave, "imagePathToSave");
        kotlin.jvm.internal.y.i(context, "context");
        pe.k.d(ViewModelKt.getViewModelScope(this), d1.b(), null, new C15281(imagePathToSave, context, null), 2, null);
    }

    public final void requestState(Z17EditorState z17EditorState) {
        kotlin.jvm.internal.y.i(z17EditorState, "z17EditorState");
        this._currentState.setValue(z17EditorState);
    }

    public final void requestStepBack(String imagePath) {
        kotlin.jvm.internal.y.i(imagePath, "imagePath");
        this._currentState.setValue(Z17EditorState.LOADING);
        pe.k.d(ViewModelKt.getViewModelScope(this), d1.b(), null, new C15291(imagePath, null), 2, null);
    }

    public final void setBitmap(Bitmap imageBitmap, String imagePathToSave) {
        kotlin.jvm.internal.y.i(imageBitmap, "imageBitmap");
        kotlin.jvm.internal.y.i(imagePathToSave, "imagePathToSave");
        this._currentState.setValue(Z17EditorState.LOADING);
        this.history.add(imageBitmap);
        pe.k.d(ViewModelKt.getViewModelScope(this), d1.b(), null, new C15301(imagePathToSave, imageBitmap, null), 2, null);
    }

    public final void setFilteredBitmaps(Z17MutableListFlow<Bitmap> z17MutableListFlow) {
        kotlin.jvm.internal.y.i(z17MutableListFlow, "<set-?>");
        this.filteredBitmaps = z17MutableListFlow;
    }
}
