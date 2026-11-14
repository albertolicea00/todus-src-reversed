package cu.z17.views.imageEditor.sections.filter;

import android.graphics.Bitmap;
import android.graphics.ColorMatrix;
import androidx.compose.ui.spatial.RectListKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import cb.m;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import pe.m0;
import ua.k0;
import ua.v;
import va.w;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@cb.f(c = "cu.z17.views.imageEditor.sections.filter.FilterKt$Filter$1$1$1", f = "Filter.kt", l = {37, ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX, RectListKt.BitOffsetForFocusable, 68, 80, 92}, m = "invokeSuspend")
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 2, 0})
public final class FilterKt$Filter$1$1$1 extends m implements Function2 {
    final /* synthetic */ Bitmap $bitmap;
    final /* synthetic */ List<Bitmap> $filteredBitmaps;
    final /* synthetic */ Function1 $onFiltersLoad;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilterKt$Filter$1$1$1(List<Bitmap> list, Bitmap bitmap, Function1 function1, ab.e<? super FilterKt$Filter$1$1$1> eVar) {
        super(2, eVar);
        this.$filteredBitmaps = list;
        this.$bitmap = bitmap;
        this.$onFiltersLoad = function1;
    }

    @Override // cb.a
    public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
        return new FilterKt$Filter$1$1$1(this.$filteredBitmaps, this.$bitmap, this.$onFiltersLoad, eVar);
    }

    /* JADX WARN: Code duplicated, block: B:20:0x00ae A[PHI: r1 r15
      0x00ae: PHI (r1v5 android.graphics.Bitmap) = (r1v4 android.graphics.Bitmap), (r1v7 android.graphics.Bitmap) binds: [B:18:0x00aa, B:10:0x0066] A[DONT_GENERATE, DONT_INLINE]
      0x00ae: PHI (r15v8 java.lang.Object) = (r15v7 java.lang.Object), (r15v0 java.lang.Object) binds: [B:18:0x00aa, B:10:0x0066] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:23:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:27:0x00ec A[PHI: r1 r9 r10 r15
      0x00ec: PHI (r1v12 android.graphics.Bitmap) = (r1v9 android.graphics.Bitmap), (r1v15 android.graphics.Bitmap) binds: [B:25:0x00e9, B:8:0x0047] A[DONT_GENERATE, DONT_INLINE]
      0x00ec: PHI (r9v9 android.graphics.Bitmap) = (r9v5 android.graphics.Bitmap), (r9v12 android.graphics.Bitmap) binds: [B:25:0x00e9, B:8:0x0047] A[DONT_GENERATE, DONT_INLINE]
      0x00ec: PHI (r10v6 android.graphics.Bitmap) = (r10v4 android.graphics.Bitmap), (r10v9 android.graphics.Bitmap) binds: [B:25:0x00e9, B:8:0x0047] A[DONT_GENERATE, DONT_INLINE]
      0x00ec: PHI (r15v14 java.lang.Object) = (r15v13 java.lang.Object), (r15v0 java.lang.Object) binds: [B:25:0x00e9, B:8:0x0047] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:30:0x010b  */
    /* JADX WARN: Code duplicated, block: B:34:0x0132  */
    @Override // cb.a
    public final Object invokeSuspend(Object obj) {
        Bitmap bitmap;
        Bitmap bitmap2;
        Object bitmapFromColorMatrix;
        Bitmap bitmap3;
        Bitmap bitmap4;
        Bitmap bitmap5;
        Bitmap bitmap6;
        Object bitmapFromColorMatrix2;
        Bitmap bitmap7;
        Bitmap bitmap8;
        Bitmap bitmap9;
        Bitmap bitmap10;
        Bitmap bitmap11;
        Object bitmapFromColorMatrix3;
        Bitmap bitmap12;
        Bitmap bitmap13;
        Bitmap bitmap14;
        Bitmap bitmap15;
        Object objG = bb.b.g();
        switch (this.label) {
            case 0:
                v.b(obj);
                if (this.$filteredBitmaps.isEmpty()) {
                    ColorMatrix colorMatrix = new ColorMatrix(new float[]{0.393f, 0.769f, 0.189f, 0.0f, 0.0f, 0.349f, 0.686f, 0.168f, 0.0f, 0.0f, 0.272f, 0.534f, 0.131f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f});
                    Bitmap bitmap16 = this.$bitmap;
                    this.label = 1;
                    obj = FilterKt.getBitmapFromColorMatrix(colorMatrix, bitmap16, this);
                    if (obj != objG) {
                        bitmap = (Bitmap) obj;
                        ColorMatrix colorMatrix2 = new ColorMatrix(new float[]{1.3f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.3f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.3f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f});
                        Bitmap bitmap17 = this.$bitmap;
                        this.L$0 = bitmap;
                        this.label = 2;
                        obj = FilterKt.getBitmapFromColorMatrix(colorMatrix2, bitmap17, this);
                        if (obj != objG) {
                            bitmap2 = (Bitmap) obj;
                            ColorMatrix colorMatrix3 = new ColorMatrix();
                            colorMatrix3.setSaturation(1.5f);
                            Bitmap bitmap18 = this.$bitmap;
                            this.L$0 = bitmap;
                            this.L$1 = bitmap2;
                            this.label = 3;
                            bitmapFromColorMatrix = FilterKt.getBitmapFromColorMatrix(colorMatrix3, bitmap18, this);
                            if (bitmapFromColorMatrix != objG) {
                                bitmap3 = bitmap2;
                                obj = bitmapFromColorMatrix;
                                bitmap4 = bitmap;
                                bitmap5 = (Bitmap) obj;
                                ColorMatrix colorMatrix4 = new ColorMatrix(new float[]{1.0f, 0.0f, 0.0f, 0.0f, 100.0f, 0.0f, 1.0f, 0.0f, 0.0f, 100.0f, 0.0f, 0.0f, 1.0f, 0.0f, 100.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f});
                                Bitmap bitmap19 = this.$bitmap;
                                this.L$0 = bitmap4;
                                this.L$1 = bitmap3;
                                this.L$2 = bitmap5;
                                this.label = 4;
                                obj = FilterKt.getBitmapFromColorMatrix(colorMatrix4, bitmap19, this);
                                if (obj != objG) {
                                    bitmap6 = (Bitmap) obj;
                                    ColorMatrix colorMatrix5 = new ColorMatrix(new float[]{1.0f, 0.0f, 0.0f, 0.0f, -100.0f, 0.0f, 1.0f, 0.0f, 0.0f, -100.0f, 0.0f, 0.0f, 1.0f, 0.0f, -100.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f});
                                    Bitmap bitmap20 = this.$bitmap;
                                    this.L$0 = bitmap4;
                                    this.L$1 = bitmap3;
                                    this.L$2 = bitmap5;
                                    this.L$3 = bitmap6;
                                    this.label = 5;
                                    bitmapFromColorMatrix2 = FilterKt.getBitmapFromColorMatrix(colorMatrix5, bitmap20, this);
                                    if (bitmapFromColorMatrix2 != objG) {
                                        Bitmap bitmap21 = bitmap5;
                                        bitmap7 = bitmap6;
                                        obj = bitmapFromColorMatrix2;
                                        bitmap8 = bitmap4;
                                        bitmap9 = bitmap3;
                                        bitmap10 = bitmap21;
                                        bitmap11 = (Bitmap) obj;
                                        ColorMatrix colorMatrix6 = new ColorMatrix(new float[]{0.33f, 0.33f, 0.33f, 0.0f, 0.0f, 0.33f, 0.33f, 0.33f, 0.0f, 0.0f, 0.33f, 0.33f, 0.33f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f});
                                        Bitmap bitmap22 = this.$bitmap;
                                        this.L$0 = bitmap8;
                                        this.L$1 = bitmap9;
                                        this.L$2 = bitmap10;
                                        this.L$3 = bitmap7;
                                        this.L$4 = bitmap11;
                                        this.label = 6;
                                        bitmapFromColorMatrix3 = FilterKt.getBitmapFromColorMatrix(colorMatrix6, bitmap22, this);
                                        if (bitmapFromColorMatrix3 != objG) {
                                            bitmap12 = bitmap11;
                                            obj = bitmapFromColorMatrix3;
                                            bitmap13 = bitmap10;
                                            bitmap14 = bitmap9;
                                            bitmap15 = bitmap8;
                                            this.$onFiltersLoad.invoke(w.q(bitmap15, (Bitmap) obj, bitmap14, bitmap13, bitmap7, bitmap12));
                                        }
                                    }
                                }
                            }
                        }
                    }
                    return objG;
                }
                return k0.f43947a;
            case 1:
                v.b(obj);
                bitmap = (Bitmap) obj;
                ColorMatrix colorMatrix7 = new ColorMatrix(new float[]{1.3f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.3f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.3f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f});
                Bitmap bitmap110 = this.$bitmap;
                this.L$0 = bitmap;
                this.label = 2;
                obj = FilterKt.getBitmapFromColorMatrix(colorMatrix7, bitmap110, this);
                if (obj != objG) {
                    bitmap2 = (Bitmap) obj;
                    ColorMatrix colorMatrix8 = new ColorMatrix();
                    colorMatrix8.setSaturation(1.5f);
                    Bitmap bitmap111 = this.$bitmap;
                    this.L$0 = bitmap;
                    this.L$1 = bitmap2;
                    this.label = 3;
                    bitmapFromColorMatrix = FilterKt.getBitmapFromColorMatrix(colorMatrix8, bitmap111, this);
                    if (bitmapFromColorMatrix != objG) {
                        bitmap3 = bitmap2;
                        obj = bitmapFromColorMatrix;
                        bitmap4 = bitmap;
                        bitmap5 = (Bitmap) obj;
                        ColorMatrix colorMatrix9 = new ColorMatrix(new float[]{1.0f, 0.0f, 0.0f, 0.0f, 100.0f, 0.0f, 1.0f, 0.0f, 0.0f, 100.0f, 0.0f, 0.0f, 1.0f, 0.0f, 100.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f});
                        Bitmap bitmap112 = this.$bitmap;
                        this.L$0 = bitmap4;
                        this.L$1 = bitmap3;
                        this.L$2 = bitmap5;
                        this.label = 4;
                        obj = FilterKt.getBitmapFromColorMatrix(colorMatrix9, bitmap112, this);
                        if (obj != objG) {
                            bitmap6 = (Bitmap) obj;
                            ColorMatrix colorMatrix10 = new ColorMatrix(new float[]{1.0f, 0.0f, 0.0f, 0.0f, -100.0f, 0.0f, 1.0f, 0.0f, 0.0f, -100.0f, 0.0f, 0.0f, 1.0f, 0.0f, -100.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f});
                            Bitmap bitmap23 = this.$bitmap;
                            this.L$0 = bitmap4;
                            this.L$1 = bitmap3;
                            this.L$2 = bitmap5;
                            this.L$3 = bitmap6;
                            this.label = 5;
                            bitmapFromColorMatrix2 = FilterKt.getBitmapFromColorMatrix(colorMatrix10, bitmap23, this);
                            if (bitmapFromColorMatrix2 != objG) {
                                Bitmap bitmap24 = bitmap5;
                                bitmap7 = bitmap6;
                                obj = bitmapFromColorMatrix2;
                                bitmap8 = bitmap4;
                                bitmap9 = bitmap3;
                                bitmap10 = bitmap24;
                                bitmap11 = (Bitmap) obj;
                                ColorMatrix colorMatrix11 = new ColorMatrix(new float[]{0.33f, 0.33f, 0.33f, 0.0f, 0.0f, 0.33f, 0.33f, 0.33f, 0.0f, 0.0f, 0.33f, 0.33f, 0.33f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f});
                                Bitmap bitmap25 = this.$bitmap;
                                this.L$0 = bitmap8;
                                this.L$1 = bitmap9;
                                this.L$2 = bitmap10;
                                this.L$3 = bitmap7;
                                this.L$4 = bitmap11;
                                this.label = 6;
                                bitmapFromColorMatrix3 = FilterKt.getBitmapFromColorMatrix(colorMatrix11, bitmap25, this);
                                if (bitmapFromColorMatrix3 != objG) {
                                    bitmap12 = bitmap11;
                                    obj = bitmapFromColorMatrix3;
                                    bitmap13 = bitmap10;
                                    bitmap14 = bitmap9;
                                    bitmap15 = bitmap8;
                                    this.$onFiltersLoad.invoke(w.q(bitmap15, (Bitmap) obj, bitmap14, bitmap13, bitmap7, bitmap12));
                                    return k0.f43947a;
                                }
                            }
                        }
                    }
                }
                return objG;
            case 2:
                bitmap = (Bitmap) this.L$0;
                v.b(obj);
                bitmap2 = (Bitmap) obj;
                ColorMatrix colorMatrix12 = new ColorMatrix();
                colorMatrix12.setSaturation(1.5f);
                Bitmap bitmap113 = this.$bitmap;
                this.L$0 = bitmap;
                this.L$1 = bitmap2;
                this.label = 3;
                bitmapFromColorMatrix = FilterKt.getBitmapFromColorMatrix(colorMatrix12, bitmap113, this);
                if (bitmapFromColorMatrix != objG) {
                    bitmap3 = bitmap2;
                    obj = bitmapFromColorMatrix;
                    bitmap4 = bitmap;
                    bitmap5 = (Bitmap) obj;
                    ColorMatrix colorMatrix13 = new ColorMatrix(new float[]{1.0f, 0.0f, 0.0f, 0.0f, 100.0f, 0.0f, 1.0f, 0.0f, 0.0f, 100.0f, 0.0f, 0.0f, 1.0f, 0.0f, 100.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f});
                    Bitmap bitmap114 = this.$bitmap;
                    this.L$0 = bitmap4;
                    this.L$1 = bitmap3;
                    this.L$2 = bitmap5;
                    this.label = 4;
                    obj = FilterKt.getBitmapFromColorMatrix(colorMatrix13, bitmap114, this);
                    if (obj != objG) {
                        bitmap6 = (Bitmap) obj;
                        ColorMatrix colorMatrix14 = new ColorMatrix(new float[]{1.0f, 0.0f, 0.0f, 0.0f, -100.0f, 0.0f, 1.0f, 0.0f, 0.0f, -100.0f, 0.0f, 0.0f, 1.0f, 0.0f, -100.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f});
                        Bitmap bitmap26 = this.$bitmap;
                        this.L$0 = bitmap4;
                        this.L$1 = bitmap3;
                        this.L$2 = bitmap5;
                        this.L$3 = bitmap6;
                        this.label = 5;
                        bitmapFromColorMatrix2 = FilterKt.getBitmapFromColorMatrix(colorMatrix14, bitmap26, this);
                        if (bitmapFromColorMatrix2 != objG) {
                            Bitmap bitmap27 = bitmap5;
                            bitmap7 = bitmap6;
                            obj = bitmapFromColorMatrix2;
                            bitmap8 = bitmap4;
                            bitmap9 = bitmap3;
                            bitmap10 = bitmap27;
                            bitmap11 = (Bitmap) obj;
                            ColorMatrix colorMatrix15 = new ColorMatrix(new float[]{0.33f, 0.33f, 0.33f, 0.0f, 0.0f, 0.33f, 0.33f, 0.33f, 0.0f, 0.0f, 0.33f, 0.33f, 0.33f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f});
                            Bitmap bitmap28 = this.$bitmap;
                            this.L$0 = bitmap8;
                            this.L$1 = bitmap9;
                            this.L$2 = bitmap10;
                            this.L$3 = bitmap7;
                            this.L$4 = bitmap11;
                            this.label = 6;
                            bitmapFromColorMatrix3 = FilterKt.getBitmapFromColorMatrix(colorMatrix15, bitmap28, this);
                            if (bitmapFromColorMatrix3 != objG) {
                                bitmap12 = bitmap11;
                                obj = bitmapFromColorMatrix3;
                                bitmap13 = bitmap10;
                                bitmap14 = bitmap9;
                                bitmap15 = bitmap8;
                                this.$onFiltersLoad.invoke(w.q(bitmap15, (Bitmap) obj, bitmap14, bitmap13, bitmap7, bitmap12));
                                return k0.f43947a;
                            }
                        }
                    }
                }
                return objG;
            case 3:
                Bitmap bitmap29 = (Bitmap) this.L$1;
                Bitmap bitmap30 = (Bitmap) this.L$0;
                v.b(obj);
                bitmap4 = bitmap30;
                bitmap3 = bitmap29;
                bitmap5 = (Bitmap) obj;
                ColorMatrix colorMatrix16 = new ColorMatrix(new float[]{1.0f, 0.0f, 0.0f, 0.0f, 100.0f, 0.0f, 1.0f, 0.0f, 0.0f, 100.0f, 0.0f, 0.0f, 1.0f, 0.0f, 100.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f});
                Bitmap bitmap115 = this.$bitmap;
                this.L$0 = bitmap4;
                this.L$1 = bitmap3;
                this.L$2 = bitmap5;
                this.label = 4;
                obj = FilterKt.getBitmapFromColorMatrix(colorMatrix16, bitmap115, this);
                if (obj != objG) {
                    bitmap6 = (Bitmap) obj;
                    ColorMatrix colorMatrix17 = new ColorMatrix(new float[]{1.0f, 0.0f, 0.0f, 0.0f, -100.0f, 0.0f, 1.0f, 0.0f, 0.0f, -100.0f, 0.0f, 0.0f, 1.0f, 0.0f, -100.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f});
                    Bitmap bitmap210 = this.$bitmap;
                    this.L$0 = bitmap4;
                    this.L$1 = bitmap3;
                    this.L$2 = bitmap5;
                    this.L$3 = bitmap6;
                    this.label = 5;
                    bitmapFromColorMatrix2 = FilterKt.getBitmapFromColorMatrix(colorMatrix17, bitmap210, this);
                    if (bitmapFromColorMatrix2 != objG) {
                        Bitmap bitmap211 = bitmap5;
                        bitmap7 = bitmap6;
                        obj = bitmapFromColorMatrix2;
                        bitmap8 = bitmap4;
                        bitmap9 = bitmap3;
                        bitmap10 = bitmap211;
                        bitmap11 = (Bitmap) obj;
                        ColorMatrix colorMatrix18 = new ColorMatrix(new float[]{0.33f, 0.33f, 0.33f, 0.0f, 0.0f, 0.33f, 0.33f, 0.33f, 0.0f, 0.0f, 0.33f, 0.33f, 0.33f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f});
                        Bitmap bitmap212 = this.$bitmap;
                        this.L$0 = bitmap8;
                        this.L$1 = bitmap9;
                        this.L$2 = bitmap10;
                        this.L$3 = bitmap7;
                        this.L$4 = bitmap11;
                        this.label = 6;
                        bitmapFromColorMatrix3 = FilterKt.getBitmapFromColorMatrix(colorMatrix18, bitmap212, this);
                        if (bitmapFromColorMatrix3 != objG) {
                            bitmap12 = bitmap11;
                            obj = bitmapFromColorMatrix3;
                            bitmap13 = bitmap10;
                            bitmap14 = bitmap9;
                            bitmap15 = bitmap8;
                            this.$onFiltersLoad.invoke(w.q(bitmap15, (Bitmap) obj, bitmap14, bitmap13, bitmap7, bitmap12));
                            return k0.f43947a;
                        }
                    }
                }
                return objG;
            case 4:
                bitmap5 = (Bitmap) this.L$2;
                bitmap3 = (Bitmap) this.L$1;
                bitmap4 = (Bitmap) this.L$0;
                v.b(obj);
                bitmap6 = (Bitmap) obj;
                ColorMatrix colorMatrix19 = new ColorMatrix(new float[]{1.0f, 0.0f, 0.0f, 0.0f, -100.0f, 0.0f, 1.0f, 0.0f, 0.0f, -100.0f, 0.0f, 0.0f, 1.0f, 0.0f, -100.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f});
                Bitmap bitmap213 = this.$bitmap;
                this.L$0 = bitmap4;
                this.L$1 = bitmap3;
                this.L$2 = bitmap5;
                this.L$3 = bitmap6;
                this.label = 5;
                bitmapFromColorMatrix2 = FilterKt.getBitmapFromColorMatrix(colorMatrix19, bitmap213, this);
                if (bitmapFromColorMatrix2 != objG) {
                    Bitmap bitmap214 = bitmap5;
                    bitmap7 = bitmap6;
                    obj = bitmapFromColorMatrix2;
                    bitmap8 = bitmap4;
                    bitmap9 = bitmap3;
                    bitmap10 = bitmap214;
                    bitmap11 = (Bitmap) obj;
                    ColorMatrix colorMatrix110 = new ColorMatrix(new float[]{0.33f, 0.33f, 0.33f, 0.0f, 0.0f, 0.33f, 0.33f, 0.33f, 0.0f, 0.0f, 0.33f, 0.33f, 0.33f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f});
                    Bitmap bitmap215 = this.$bitmap;
                    this.L$0 = bitmap8;
                    this.L$1 = bitmap9;
                    this.L$2 = bitmap10;
                    this.L$3 = bitmap7;
                    this.L$4 = bitmap11;
                    this.label = 6;
                    bitmapFromColorMatrix3 = FilterKt.getBitmapFromColorMatrix(colorMatrix110, bitmap215, this);
                    if (bitmapFromColorMatrix3 != objG) {
                        bitmap12 = bitmap11;
                        obj = bitmapFromColorMatrix3;
                        bitmap13 = bitmap10;
                        bitmap14 = bitmap9;
                        bitmap15 = bitmap8;
                        this.$onFiltersLoad.invoke(w.q(bitmap15, (Bitmap) obj, bitmap14, bitmap13, bitmap7, bitmap12));
                        return k0.f43947a;
                    }
                }
                return objG;
            case 5:
                bitmap7 = (Bitmap) this.L$3;
                bitmap10 = (Bitmap) this.L$2;
                bitmap9 = (Bitmap) this.L$1;
                bitmap8 = (Bitmap) this.L$0;
                v.b(obj);
                bitmap11 = (Bitmap) obj;
                ColorMatrix colorMatrix111 = new ColorMatrix(new float[]{0.33f, 0.33f, 0.33f, 0.0f, 0.0f, 0.33f, 0.33f, 0.33f, 0.0f, 0.0f, 0.33f, 0.33f, 0.33f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f});
                Bitmap bitmap216 = this.$bitmap;
                this.L$0 = bitmap8;
                this.L$1 = bitmap9;
                this.L$2 = bitmap10;
                this.L$3 = bitmap7;
                this.L$4 = bitmap11;
                this.label = 6;
                bitmapFromColorMatrix3 = FilterKt.getBitmapFromColorMatrix(colorMatrix111, bitmap216, this);
                if (bitmapFromColorMatrix3 != objG) {
                    bitmap12 = bitmap11;
                    obj = bitmapFromColorMatrix3;
                    bitmap13 = bitmap10;
                    bitmap14 = bitmap9;
                    bitmap15 = bitmap8;
                    this.$onFiltersLoad.invoke(w.q(bitmap15, (Bitmap) obj, bitmap14, bitmap13, bitmap7, bitmap12));
                    return k0.f43947a;
                }
                return objG;
            case 6:
                bitmap12 = (Bitmap) this.L$4;
                bitmap7 = (Bitmap) this.L$3;
                bitmap13 = (Bitmap) this.L$2;
                bitmap14 = (Bitmap) this.L$1;
                bitmap15 = (Bitmap) this.L$0;
                v.b(obj);
                this.$onFiltersLoad.invoke(w.q(bitmap15, (Bitmap) obj, bitmap14, bitmap13, bitmap7, bitmap12));
                return k0.f43947a;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
        return ((FilterKt$Filter$1$1$1) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
    }
}
