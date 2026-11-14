package cu.z17.views.imageEditor.sections.cropper.components;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import cu.z17.views.imageEditor.sections.cropper.components.crop.CropAgent;
import cu.z17.views.imageEditor.sections.cropper.components.model.CropOutline;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import pe.d1;
import pe.m0;
import pe.w0;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@cb.f(c = "cu.z17.views.imageEditor.sections.cropper.components.ImageCropperKt$Crop$1$1", f = "ImageCropper.kt", l = {}, m = "invokeSuspend")
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 2, 0})
public final class ImageCropperKt$Crop$1$1 extends cb.m implements Function2 {
    final /* synthetic */ boolean $crop;
    final /* synthetic */ CropAgent $cropAgent;
    final /* synthetic */ CropOutline $cropOutline;
    final /* synthetic */ Rect $cropRect;
    final /* synthetic */ Density $density;
    final /* synthetic */ LayoutDirection $layoutDirection;
    final /* synthetic */ lb.a $onCropStart;
    final /* synthetic */ Function1 $onCropSuccess;
    final /* synthetic */ IntSize $requiredSize;
    final /* synthetic */ ImageBitmap $scaledImageBitmap;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: renamed from: cu.z17.views.imageEditor.sections.cropper.components.ImageCropperKt$Crop$1$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.z17.views.imageEditor.sections.cropper.components.ImageCropperKt$Crop$1$1$1", f = "ImageCropper.kt", l = {338, 346}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lte/i;", "Landroidx/compose/ui/graphics/ImageBitmap;", "Lua/k0;", "<anonymous>", "(Lte/i;)V"}, k = 3, mv = {2, 2, 0})
    public static final class AnonymousClass1 extends cb.m implements Function2 {
        final /* synthetic */ CropAgent $cropAgent;
        final /* synthetic */ CropOutline $cropOutline;
        final /* synthetic */ Rect $cropRect;
        final /* synthetic */ Density $density;
        final /* synthetic */ LayoutDirection $layoutDirection;
        final /* synthetic */ IntSize $requiredSize;
        final /* synthetic */ ImageBitmap $scaledImageBitmap;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(CropAgent cropAgent, ImageBitmap imageBitmap, Rect rect, CropOutline cropOutline, LayoutDirection layoutDirection, Density density, IntSize intSize, ab.e<? super AnonymousClass1> eVar) {
            super(2, eVar);
            this.$cropAgent = cropAgent;
            this.$scaledImageBitmap = imageBitmap;
            this.$cropRect = rect;
            this.$cropOutline = cropOutline;
            this.$layoutDirection = layoutDirection;
            this.$density = density;
            this.$requiredSize = intSize;
        }

        @Override // cb.a
        public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$cropAgent, this.$scaledImageBitmap, this.$cropRect, this.$cropOutline, this.$layoutDirection, this.$density, this.$requiredSize, eVar);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x0067, code lost:
        
            if (r0.emit(r2, r11) == r1) goto L17;
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x007c, code lost:
        
            if (r0.emit(r12, r11) == r1) goto L17;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x007e, code lost:
        
            return r1;
         */
        @Override // cb.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r12) {
            /*
                r11 = this;
                java.lang.Object r0 = r11.L$0
                te.i r0 = (te.i) r0
                java.lang.Object r1 = bb.b.g()
                int r2 = r11.label
                r3 = 2
                r4 = 1
                if (r2 == 0) goto L23
                if (r2 == r4) goto L1b
                if (r2 != r3) goto L13
                goto L1b
            L13:
                java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r12.<init>(r0)
                throw r12
            L1b:
                java.lang.Object r0 = r11.L$1
                androidx.compose.ui.graphics.ImageBitmap r0 = (androidx.compose.ui.graphics.ImageBitmap) r0
                ua.v.b(r12)
                goto L7f
            L23:
                ua.v.b(r12)
                cu.z17.views.imageEditor.sections.cropper.components.crop.CropAgent r5 = r11.$cropAgent
                androidx.compose.ui.graphics.ImageBitmap r6 = r11.$scaledImageBitmap
                androidx.compose.ui.geometry.Rect r7 = r11.$cropRect
                cu.z17.views.imageEditor.sections.cropper.components.model.CropOutline r8 = r11.$cropOutline
                androidx.compose.ui.unit.LayoutDirection r9 = r11.$layoutDirection
                androidx.compose.ui.unit.Density r10 = r11.$density
                androidx.compose.ui.graphics.ImageBitmap r12 = r5.crop(r6, r7, r8, r9, r10)
                androidx.compose.ui.unit.IntSize r2 = r11.$requiredSize
                if (r2 == 0) goto L6a
                cu.z17.views.imageEditor.sections.cropper.components.crop.CropAgent r3 = r11.$cropAgent
                long r5 = r2.m8994unboximpl()
                r2 = 32
                long r5 = r5 >> r2
                int r2 = (int) r5
                androidx.compose.ui.unit.IntSize r5 = r11.$requiredSize
                long r5 = r5.m8994unboximpl()
                r7 = 4294967295(0xffffffff, double:2.1219957905E-314)
                long r5 = r5 & r7
                int r5 = (int) r5
                androidx.compose.ui.graphics.ImageBitmap r2 = r3.resize(r12, r2, r5)
                java.lang.Object r3 = cb.l.a(r0)
                r11.L$0 = r3
                java.lang.Object r12 = cb.l.a(r12)
                r11.L$1 = r12
                r11.label = r4
                java.lang.Object r12 = r0.emit(r2, r11)
                if (r12 != r1) goto L7f
                goto L7e
            L6a:
                java.lang.Object r2 = cb.l.a(r0)
                r11.L$0 = r2
                java.lang.Object r2 = cb.l.a(r12)
                r11.L$1 = r2
                r11.label = r3
                java.lang.Object r12 = r0.emit(r12, r11)
                if (r12 != r1) goto L7f
            L7e:
                return r1
            L7f:
                ua.k0 r12 = ua.k0.f43947a
                return r12
            */
            throw new UnsupportedOperationException("Method not decompiled: cu.z17.views.imageEditor.sections.cropper.components.ImageCropperKt$Crop$1$1.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(te.i iVar, ab.e<? super k0> eVar) {
            return ((AnonymousClass1) create(iVar, eVar)).invokeSuspend(k0.f43947a);
        }
    }

    /* JADX INFO: renamed from: cu.z17.views.imageEditor.sections.cropper.components.ImageCropperKt$Crop$1$1$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.z17.views.imageEditor.sections.cropper.components.ImageCropperKt$Crop$1$1$2", f = "ImageCropper.kt", l = {352}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lte/i;", "Landroidx/compose/ui/graphics/ImageBitmap;", "Lua/k0;", "<anonymous>", "(Lte/i;)V"}, k = 3, mv = {2, 2, 0})
    public static final class AnonymousClass2 extends cb.m implements Function2 {
        final /* synthetic */ lb.a $onCropStart;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(lb.a aVar, ab.e<? super AnonymousClass2> eVar) {
            super(2, eVar);
            this.$onCropStart = aVar;
        }

        @Override // cb.a
        public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
            return new AnonymousClass2(this.$onCropStart, eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                ua.v.b(obj);
                this.$onCropStart.invoke();
                this.label = 1;
                if (w0.b(400L, this) == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ua.v.b(obj);
            }
            return k0.f43947a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(te.i iVar, ab.e<? super k0> eVar) {
            return ((AnonymousClass2) create(iVar, eVar)).invokeSuspend(k0.f43947a);
        }
    }

    /* JADX INFO: renamed from: cu.z17.views.imageEditor.sections.cropper.components.ImageCropperKt$Crop$1$1$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.z17.views.imageEditor.sections.cropper.components.ImageCropperKt$Crop$1$1$3", f = "ImageCropper.kt", l = {}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroidx/compose/ui/graphics/ImageBitmap;", "it", "Lua/k0;", "<anonymous>", "(Landroidx/compose/ui/graphics/ImageBitmap;)V"}, k = 3, mv = {2, 2, 0})
    public static final class AnonymousClass3 extends cb.m implements Function2 {
        final /* synthetic */ Function1 $onCropSuccess;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(Function1 function1, ab.e<? super AnonymousClass3> eVar) {
            super(2, eVar);
            this.$onCropSuccess = function1;
        }

        @Override // cb.a
        public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
            AnonymousClass3 anonymousClass3 = new AnonymousClass3(this.$onCropSuccess, eVar);
            anonymousClass3.L$0 = obj;
            return anonymousClass3;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(ImageBitmap imageBitmap, ab.e<? super k0> eVar) {
            return ((AnonymousClass3) create(imageBitmap, eVar)).invokeSuspend(k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            ImageBitmap imageBitmap = (ImageBitmap) this.L$0;
            bb.b.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ua.v.b(obj);
            this.$onCropSuccess.invoke(imageBitmap);
            return k0.f43947a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageCropperKt$Crop$1$1(boolean z10, CropAgent cropAgent, ImageBitmap imageBitmap, Rect rect, CropOutline cropOutline, LayoutDirection layoutDirection, Density density, IntSize intSize, lb.a aVar, Function1 function1, ab.e<? super ImageCropperKt$Crop$1$1> eVar) {
        super(2, eVar);
        this.$crop = z10;
        this.$cropAgent = cropAgent;
        this.$scaledImageBitmap = imageBitmap;
        this.$cropRect = rect;
        this.$cropOutline = cropOutline;
        this.$layoutDirection = layoutDirection;
        this.$density = density;
        this.$requiredSize = intSize;
        this.$onCropStart = aVar;
        this.$onCropSuccess = function1;
    }

    @Override // cb.a
    public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
        ImageCropperKt$Crop$1$1 imageCropperKt$Crop$1$1 = new ImageCropperKt$Crop$1$1(this.$crop, this.$cropAgent, this.$scaledImageBitmap, this.$cropRect, this.$cropOutline, this.$layoutDirection, this.$density, this.$requiredSize, this.$onCropStart, this.$onCropSuccess, eVar);
        imageCropperKt$Crop$1$1.L$0 = obj;
        return imageCropperKt$Crop$1$1;
    }

    @Override // cb.a
    public final Object invokeSuspend(Object obj) {
        m0 m0Var = (m0) this.L$0;
        bb.b.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ua.v.b(obj);
        if (this.$crop) {
            te.j.F(te.j.K(te.j.L(te.j.E(te.j.B(new AnonymousClass1(this.$cropAgent, this.$scaledImageBitmap, this.$cropRect, this.$cropOutline, this.$layoutDirection, this.$density, this.$requiredSize, null)), d1.a()), new AnonymousClass2(this.$onCropStart, null)), new AnonymousClass3(this.$onCropSuccess, null)), m0Var);
        }
        return k0.f43947a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
        return ((ImageCropperKt$Crop$1$1) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
    }
}
