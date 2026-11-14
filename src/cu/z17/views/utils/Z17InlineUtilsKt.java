package cu.z17.views.utils;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.net.Uri;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.BlurKt;
import androidx.compose.ui.draw.BlurredEdgeTreatment;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.unit.Dp;
import androidx.media3.extractor.text.ttml.TtmlNode;
import androidx.p001lifecycle.Lifecycle;
import androidx.p001lifecycle.LifecycleEventObserver;
import androidx.p001lifecycle.LifecycleOwner;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import ke.u;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.y;
import le.a0;
import le.d0;
import pe.d1;
import pe.m0;
import ua.k0;
import ua.v;
import ua.z;
import va.g0;
import va.w;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0004\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0004\u0010\u0003\u001a\u0011\u0010\u0005\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0005\u0010\u0003\u001a\u0011\u0010\u0006\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0006\u0010\u0003\u001a\u001b\u0010\f\u001a\u00020\u0007*\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000b\u001a\u001b\u0010\u000e\u001a\u00020\u0007*\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\r\u0010\u000b\u001a\u001b\u0010\u0014\u001a\u00020\u000f*\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u0019\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016*\u00020\u0015H\u0007¢\u0006\u0004\b\u0018\u0010\u0019\u001a)\u0010\u001e\u001a\u00020\u001c2\u0018\u0010\u001d\u001a\u0014\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u001c0\u001aH\u0007¢\u0006\u0004\b\u001e\u0010\u001f\u001a\u0011\u0010\"\u001a\u00020!*\u00020 ¢\u0006\u0004\b\"\u0010#\u001a\u0011\u0010$\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b$\u0010\u0003\u001a\u0011\u0010%\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b%\u0010\u0003\u001a\u0011\u0010&\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b&\u0010\u0003\u001a\u0017\u0010(\u001a\u00020\u00002\u0006\u0010'\u001a\u00020\u0000H\u0002¢\u0006\u0004\b(\u0010)\u001a3\u00101\u001a\u000200*\u00020\u00002\u0006\u0010+\u001a\u00020*2\u0006\u0010-\u001a\u00020,2\u0006\u0010.\u001a\u00020,2\b\b\u0002\u0010/\u001a\u00020\u0001¢\u0006\u0004\b1\u00102\u001a\u0011\u00103\u001a\u00020\u0000*\u00020*¢\u0006\u0004\b3\u00104\u001a\u0011\u00103\u001a\u00020\u0000*\u00020\b¢\u0006\u0004\b3\u00105\u001a\u0011\u00106\u001a\u00020\u0000*\u00020*¢\u0006\u0004\b6\u00104\u001a\u0011\u00108\u001a\u000207*\u000200¢\u0006\u0004\b8\u00109\u001a \u0010<\u001a\u000e\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020,0;*\u00020:H\u0086@¢\u0006\u0004\b<\u0010=\u001a \u0010<\u001a\u000e\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020,0;*\u00020>H\u0086@¢\u0006\u0004\b<\u0010?\"\u001d\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00000@8\u0006¢\u0006\f\n\u0004\bA\u0010B\u001a\u0004\bC\u0010D¨\u0006E"}, d2 = {"", "", "isAnUrl", "(Ljava/lang/String;)Z", "isAMention", "isAPhoneNUmber", "isTag", "Landroidx/compose/ui/graphics/Color;", "", "amount", "lighter-DxMtmZc", "(JF)J", "lighter", "darker-DxMtmZc", "darker", "Landroidx/compose/ui/Modifier;", "Landroidx/compose/ui/unit/Dp;", "radius", "cristalBlur-3ABfNKs", "(Landroidx/compose/ui/Modifier;F)Landroidx/compose/ui/Modifier;", "cristalBlur", "Landroidx/lifecycle/Lifecycle;", "Landroidx/compose/runtime/State;", "Landroidx/lifecycle/Lifecycle$Event;", "observeAsState", "(Landroidx/lifecycle/Lifecycle;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "Lkotlin/Function2;", "Landroidx/lifecycle/LifecycleOwner;", "Lua/k0;", "onEvent", "ComposableLifecycle", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "Landroid/content/Context;", "Landroid/app/Activity;", "findActivity", "(Landroid/content/Context;)Landroid/app/Activity;", "hasMarkdown", "hasLatex", "hasHtml", "text", "nameInitials", "(Ljava/lang/String;)Ljava/lang/String;", "", "textColor", "", "height", "width", TtmlNode.TEXT_EMPHASIS_MARK_CIRCLE, "Landroid/graphics/Bitmap;", "asBitmap", "(Ljava/lang/String;JIIZ)Landroid/graphics/Bitmap;", "convertToMS", "(J)Ljava/lang/String;", "(F)Ljava/lang/String;", "convertToByteSize", "", "convertToByteArray", "(Landroid/graphics/Bitmap;)[B", "Ljava/io/File;", "Lkotlin/Pair;", "getBounds", "(Ljava/io/File;Lab/e;)Ljava/lang/Object;", "Landroid/net/Uri;", "(Landroid/net/Uri;Lab/e;)Ljava/lang/Object;", "", "sizeName", "[Ljava/lang/String;", "getSizeName", "()[Ljava/lang/String;", "views_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class Z17InlineUtilsKt {
    private static final String[] sizeName = {"B", "KB", "MB", "GB", "TB", "PB", "EB", "ZB", "YB"};

    /* JADX INFO: renamed from: cu.z17.views.utils.Z17InlineUtilsKt$getBounds$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.z17.views.utils.Z17InlineUtilsKt$getBounds$2", f = "Z17InlineUtils.kt", l = {}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lpe/m0;", "Lkotlin/Pair;", "", "<anonymous>", "(Lpe/m0;)Lkotlin/Pair;"}, k = 3, mv = {2, 2, 0})
    public static final class AnonymousClass2 extends cb.m implements Function2 {
        final /* synthetic */ File $this_getBounds;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(File file, ab.e<? super AnonymousClass2> eVar) {
            super(2, eVar);
            this.$this_getBounds = file;
        }

        @Override // cb.a
        public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
            return new AnonymousClass2(this.$this_getBounds, eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            int i10;
            bb.b.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v.b(obj);
            int i11 = 0;
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeFile(this.$this_getBounds.getAbsolutePath(), options);
                i10 = options.outHeight;
                try {
                    i11 = options.outWidth;
                } catch (Exception e10) {
                    e = e10;
                    e.printStackTrace();
                }
            } catch (Exception e11) {
                e = e11;
                i10 = 0;
            }
            return z.a(cb.b.d(i11), cb.b.d(i10));
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(m0 m0Var, ab.e<? super Pair<Integer, Integer>> eVar) {
            return ((AnonymousClass2) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
        }
    }

    /* JADX INFO: renamed from: cu.z17.views.utils.Z17InlineUtilsKt$getBounds$4, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.z17.views.utils.Z17InlineUtilsKt$getBounds$4", f = "Z17InlineUtils.kt", l = {}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lpe/m0;", "Lkotlin/Pair;", "", "<anonymous>", "(Lpe/m0;)Lkotlin/Pair;"}, k = 3, mv = {2, 2, 0})
    public static final class AnonymousClass4 extends cb.m implements Function2 {
        final /* synthetic */ Uri $this_getBounds;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(Uri uri, ab.e<? super AnonymousClass4> eVar) {
            super(2, eVar);
            this.$this_getBounds = uri;
        }

        @Override // cb.a
        public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
            return new AnonymousClass4(this.$this_getBounds, eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            int i10;
            bb.b.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v.b(obj);
            int i11 = 0;
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeFile(new File(this.$this_getBounds.getPath()).getAbsolutePath(), options);
                i10 = options.outHeight;
                try {
                    i11 = options.outWidth;
                } catch (Exception e10) {
                    e = e10;
                    e.printStackTrace();
                }
            } catch (Exception e11) {
                e = e11;
                i10 = 0;
            }
            return z.a(cb.b.d(i11), cb.b.d(i10));
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(m0 m0Var, ab.e<? super Pair<Integer, Integer>> eVar) {
            return ((AnonymousClass4) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
        }
    }

    @Composable
    public static final void ComposableLifecycle(final Function2 onEvent, Composer composer, final int i10) {
        int i11;
        y.i(onEvent, "onEvent");
        Composer composerStartRestartGroup = composer.startRestartGroup(218726738);
        if ((i10 & 6) == 0) {
            i11 = (composerStartRestartGroup.changedInstance(onEvent) ? 4 : 2) | i10;
        } else {
            i11 = i10;
        }
        if (composerStartRestartGroup.shouldExecute((i11 & 3) != 2, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(218726738, i11, -1, "cu.z17.views.utils.ComposableLifecycle (Z17InlineUtils.kt:130)");
            }
            final LifecycleOwner lifecycleOwner = (LifecycleOwner) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner());
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(lifecycleOwner) | ((i11 & 14) == 4);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: cu.z17.views.utils.m
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Z17InlineUtilsKt.ComposableLifecycle$lambda$8$lambda$7(lifecycleOwner, onEvent, (DisposableEffectScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            EffectsKt.DisposableEffect(lifecycleOwner, (Function1) objRememberedValue, composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.utils.n
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return Z17InlineUtilsKt.ComposableLifecycle$lambda$9(onEvent, i10, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult ComposableLifecycle$lambda$8$lambda$7(final LifecycleOwner lifecycleOwner, final Function2 function2, DisposableEffectScope DisposableEffect) {
        y.i(DisposableEffect, "$this$DisposableEffect");
        final LifecycleEventObserver lifecycleEventObserver = new LifecycleEventObserver() { // from class: cu.z17.views.utils.o
            @Override // androidx.p001lifecycle.LifecycleEventObserver
            public final void onStateChanged(LifecycleOwner lifecycleOwner2, Lifecycle.Event event) {
                Z17InlineUtilsKt.ComposableLifecycle$lambda$8$lambda$7$lambda$5(function2, lifecycleOwner2, event);
            }
        };
        lifecycleOwner.getLifecycleRegistry().addObserver(lifecycleEventObserver);
        return new DisposableEffectResult() { // from class: cu.z17.views.utils.Z17InlineUtilsKt$ComposableLifecycle$lambda$8$lambda$7$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                lifecycleOwner.getLifecycleRegistry().removeObserver(lifecycleEventObserver);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ComposableLifecycle$lambda$8$lambda$7$lambda$5(Function2 function2, LifecycleOwner source, Lifecycle.Event event) {
        y.i(source, "source");
        y.i(event, "event");
        function2.invoke(source, event);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 ComposableLifecycle$lambda$9(Function2 function2, int i10, Composer composer, int i11) {
        ComposableLifecycle(function2, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1));
        return k0.f43947a;
    }

    public static final Bitmap asBitmap(String str, long j10, int i10, int i11, boolean z10) {
        y.i(str, "<this>");
        try {
            String strNameInitials = nameInitials(str);
            int iJ = rb.k.j(i11, i10) / 3;
            Paint paint = new Paint();
            paint.setColor(-1);
            paint.setAntiAlias(true);
            paint.setFakeBoldText(false);
            paint.setStyle(Paint.Style.FILL);
            paint.setTextSize(iJ);
            paint.setTextAlign(Paint.Align.CENTER);
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i11, i10, Bitmap.Config.ARGB_8888);
            y.h(bitmapCreateBitmap, "createBitmap(...)");
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            if (z10) {
                Paint paint2 = new Paint();
                paint2.setColor((int) j10);
                k0 k0Var = k0.f43947a;
                canvas.drawCircle(i11 / 2, i10 / 2, i11 / 2, paint2);
            } else {
                Paint paint3 = new Paint();
                paint3.setColor((int) j10);
                k0 k0Var2 = k0.f43947a;
                canvas.drawRect(i11 / 2, i10 / 2, i11 / 2, i10 / 2, paint3);
            }
            canvas.drawText(strNameInitials, i11 / 2, (i10 / 2) - ((paint.descent() + paint.ascent()) / 2), paint);
            return bitmapCreateBitmap;
        } catch (Exception unused) {
            Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(15, 15, Bitmap.Config.ARGB_8888);
            y.h(bitmapCreateBitmap2, "createBitmap(...)");
            return bitmapCreateBitmap2;
        }
    }

    public static /* synthetic */ Bitmap asBitmap$default(String str, long j10, int i10, int i11, boolean z10, int i12, Object obj) {
        if ((i12 & 8) != 0) {
            z10 = true;
        }
        return asBitmap(str, j10, i10, i11, z10);
    }

    public static final byte[] convertToByteArray(Bitmap bitmap) {
        y.i(bitmap, "<this>");
        int byteCount = bitmap.getByteCount();
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(byteCount);
        byte[] bArr = new byte[byteCount];
        bitmap.copyPixelsToBuffer(byteBufferAllocate);
        byteBufferAllocate.rewind();
        byteBufferAllocate.get(bArr);
        return bArr;
    }

    public static final String convertToByteSize(long j10) {
        if (j10 <= 0) {
            return "0 B";
        }
        double d10 = j10;
        int iFloor = (int) Math.floor(Math.log10(d10) / Math.log10(1024.0d));
        String str = String.format("%s %s", Arrays.copyOf(new Object[]{Integer.valueOf(nb.c.c(d10 / Math.pow(1024.0d, iFloor))), sizeName[iFloor]}, 2));
        y.h(str, "format(...)");
        return str;
    }

    public static final String convertToMS(long j10) {
        long j11 = 60;
        long j12 = j10 / j11;
        long j13 = j12 / j11;
        if (j13 > 0) {
            return j13 + "h " + (j12 % j11) + "m " + (j10 % j11) + "s";
        }
        if (j12 <= 0) {
            return j10 + "s";
        }
        return j12 + "m " + (j10 % j11) + "s";
    }

    /* JADX INFO: renamed from: cristalBlur-3ABfNKs, reason: not valid java name */
    public static final Modifier m10305cristalBlur3ABfNKs(Modifier cristalBlur, float f10) {
        y.i(cristalBlur, "$this$cristalBlur");
        return BackgroundKt.background$default(BlurKt.m5427blurF8QBwvs(cristalBlur, f10, BlurredEdgeTreatment.INSTANCE.m5437getUnboundedGoahg()), Brush.Companion.m5823radialGradientP_VxKs$default(Brush.INSTANCE, w.q(Color.m5856boximpl(ColorKt.Color(318767103)), Color.m5856boximpl(ColorKt.Color(3758096383L)), Color.m5856boximpl(ColorKt.Color(2684354559L))), Offset.INSTANCE.m5640getInfiniteF1C5BW0(), 2200.0f, 0, 8, (Object) null), null, 0.0f, 6, null);
    }

    /* JADX INFO: renamed from: cristalBlur-3ABfNKs$default, reason: not valid java name */
    public static /* synthetic */ Modifier m10306cristalBlur3ABfNKs$default(Modifier modifier, float f10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            f10 = Dp.m8823constructorimpl(28);
        }
        return m10305cristalBlur3ABfNKs(modifier, f10);
    }

    /* JADX INFO: renamed from: darker-DxMtmZc, reason: not valid java name */
    public static final long m10307darkerDxMtmZc(long j10, float f10) {
        float f11 = 1 - f10;
        return ColorKt.Color$default(rb.k.n(Color.m5872getRedimpl(j10) * f11, 0.0f, 1.0f), rb.k.n(Color.m5871getGreenimpl(j10) * f11, 0.0f, 1.0f), rb.k.n(Color.m5869getBlueimpl(j10) * f11, 0.0f, 1.0f), Color.m5868getAlphaimpl(j10), null, 16, null);
    }

    /* JADX INFO: renamed from: darker-DxMtmZc$default, reason: not valid java name */
    public static /* synthetic */ long m10308darkerDxMtmZc$default(long j10, float f10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            f10 = 0.1f;
        }
        return m10307darkerDxMtmZc(j10, f10);
    }

    public static final Activity findActivity(Context context) {
        y.i(context, "<this>");
        while (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
            context = ((ContextWrapper) context).getBaseContext();
            y.h(context, "getBaseContext(...)");
        }
        throw new IllegalStateException("Permissions should be called in the context of an Activity");
    }

    public static final Object getBounds(File file, ab.e<? super Pair<Integer, Integer>> eVar) {
        return pe.i.g(d1.b(), new AnonymousClass2(file, null), eVar);
    }

    public static final String[] getSizeName() {
        return sizeName;
    }

    public static final boolean hasHtml(String str) {
        y.i(str, "<this>");
        return Pattern.compile("\\<(.*?)\\>").matcher(str).find();
    }

    public static final boolean hasLatex(String str) {
        y.i(str, "<this>");
        return Pattern.compile("(?s)\\\\\\[.*?\\\\]|\\$\\$.*?\\$\\$|\\\\\\(.*?\\\\\\)").matcher(str).find();
    }

    public static final boolean hasMarkdown(String str) {
        y.i(str, "<this>");
        if (!d0.a0(str, "# ", false, 2, null)) {
            return false;
        }
        while (true) {
            boolean z10 = false;
            for (String str2 : w.q("/(#+)(.*)/", "/\\[([^\\[]+)\\]\\(([^\\)]+)\\)/", "/(\\*\\*|__)(.*?)\\1/", "/<\\/blockquote><blockquote>/", "/(\\*|_)(.*?)\\1/", "/\\~\\~(.*?)\\~\\~/", "/\\:\"(.*?)\"\\:/", "/`(.*?)`/", "/\n\\*(.*)/", "/\n[0-9]+\\.(.*)/", "/\n(&gt;|\\>)(.*)/", "/\n-{5,}/", "/\n([^\n]+)\n/", "/<\\/ul>\\s?<ul>/", "/<\\/ol>\\s?<ol>/")) {
                if (z10 || Pattern.compile("").matcher(str).find()) {
                    z10 = true;
                }
            }
            return z10;
        }
    }

    public static final boolean isAMention(String str) {
        y.i(str, "<this>");
        return Pattern.compile("@[A-Za-z0-9]+").matcher(str).find();
    }

    public static final boolean isAPhoneNUmber(String str) {
        y.i(str, "<this>");
        return Pattern.compile("^\\+?\\d{1,3}[-.\\s]?(\\d{2,3}[-.\\s]?){2}\\d{3,}\\D*$").matcher(str).find();
    }

    public static final boolean isAnUrl(String str) {
        y.i(str, "<this>");
        return Pattern.compile("^https?:\\/\\/(?:www\\.)?[-a-zA-Z0-9@:%._\\+~#=]{1,256}\\.[a-zA-Z0-9()]{1,6}\\b(?:[-a-zA-Z0-9()@:%_\\+.~#?&\\/=]*)$").matcher(str).find() || Pattern.compile("^[-a-zA-Z0-9@:%._\\+~#=]{1,256}\\.[a-zA-Z0-9()]{1,6}\\b(?:[-a-zA-Z0-9()@:%_\\+.~#?&\\/=]*)$").matcher(str).find();
    }

    public static final boolean isTag(String str) {
        y.i(str, "<this>");
        return a0.U(str, "#", false, 2, null);
    }

    /* JADX INFO: renamed from: lighter-DxMtmZc, reason: not valid java name */
    public static final long m10309lighterDxMtmZc(long j10, float f10) {
        float fM5872getRedimpl = Color.m5872getRedimpl(j10);
        float fM5871getGreenimpl = Color.m5871getGreenimpl(j10);
        float fM5869getBlueimpl = Color.m5869getBlueimpl(j10);
        return ColorKt.Color$default(fM5872getRedimpl + ((1.0f - fM5872getRedimpl) * f10), fM5871getGreenimpl + ((1.0f - fM5871getGreenimpl) * f10), fM5869getBlueimpl + ((1.0f - fM5869getBlueimpl) * f10), Color.m5868getAlphaimpl(j10), null, 16, null);
    }

    /* JADX INFO: renamed from: lighter-DxMtmZc$default, reason: not valid java name */
    public static /* synthetic */ long m10310lighterDxMtmZc$default(long j10, float f10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            f10 = 0.1f;
        }
        return m10309lighterDxMtmZc(j10, f10);
    }

    private static final String nameInitials(String str) {
        String upperCase;
        if (str.length() == 0) {
            return "?";
        }
        String str2 = "";
        String strL = new le.m("[^A-Za-z0-9 ]").l(str, "");
        List listS0 = d0.S0(strL, new String[]{" "}, false, 0, 6, null);
        if (listS0.size() > 1) {
            Iterator it = u.Q(u.F(g0.g0(listS0), new Function1() { // from class: cu.z17.views.utils.j
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return Boolean.valueOf(Z17InlineUtilsKt.nameInitials$lambda$11((String) obj));
                }
            }), new Function1() { // from class: cu.z17.views.utils.k
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return Z17InlineUtilsKt.nameInitials$lambda$12((String) obj);
                }
            }).iterator();
            while (it.hasNext()) {
                str2 = ((Object) str2) + ((String) it.next());
            }
            strL = str2;
        }
        if (strL.length() > 2) {
            String strSubstring = strL.substring(0, 2);
            y.h(strSubstring, "substring(...)");
            Locale ROOT = Locale.ROOT;
            y.h(ROOT, "ROOT");
            upperCase = strSubstring.toUpperCase(ROOT);
        } else {
            Locale ROOT2 = Locale.ROOT;
            y.h(ROOT2, "ROOT");
            upperCase = strL.toUpperCase(ROOT2);
        }
        y.h(upperCase, "toUpperCase(...)");
        return upperCase;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean nameInitials$lambda$11(String it) {
        y.i(it, "it");
        return it.length() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String nameInitials$lambda$12(String it) {
        y.i(it, "it");
        return String.valueOf(it.charAt(0));
    }

    @Composable
    public static final State<Lifecycle.Event> observeAsState(final Lifecycle lifecycle, Composer composer, int i10) {
        y.i(lifecycle, "<this>");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-950200863, i10, -1, "cu.z17.views.utils.observeAsState (Z17InlineUtils.kt:113)");
        }
        Object objRememberedValue = composer.rememberedValue();
        Composer.Companion companion = Composer.INSTANCE;
        if (objRememberedValue == companion.getEmpty()) {
            objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Lifecycle.Event.ON_ANY, null, 2, null);
            composer.updateRememberedValue(objRememberedValue);
        }
        final MutableState mutableState = (MutableState) objRememberedValue;
        boolean zChangedInstance = composer.changedInstance(lifecycle);
        Object objRememberedValue2 = composer.rememberedValue();
        if (zChangedInstance || objRememberedValue2 == companion.getEmpty()) {
            objRememberedValue2 = new Function1() { // from class: cu.z17.views.utils.l
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return Z17InlineUtilsKt.observeAsState$lambda$4$lambda$3(lifecycle, mutableState, (DisposableEffectScope) obj);
                }
            };
            composer.updateRememberedValue(objRememberedValue2);
        }
        EffectsKt.DisposableEffect(lifecycle, (Function1) objRememberedValue2, composer, i10 & 14);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return mutableState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult observeAsState$lambda$4$lambda$3(final Lifecycle lifecycle, final MutableState mutableState, DisposableEffectScope DisposableEffect) {
        y.i(DisposableEffect, "$this$DisposableEffect");
        final LifecycleEventObserver lifecycleEventObserver = new LifecycleEventObserver() { // from class: cu.z17.views.utils.p
            @Override // androidx.p001lifecycle.LifecycleEventObserver
            public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                Z17InlineUtilsKt.observeAsState$lambda$4$lambda$3$lambda$1(mutableState, lifecycleOwner, event);
            }
        };
        lifecycle.addObserver(lifecycleEventObserver);
        return new DisposableEffectResult() { // from class: cu.z17.views.utils.Z17InlineUtilsKt$observeAsState$lambda$4$lambda$3$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                lifecycle.removeObserver(lifecycleEventObserver);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void observeAsState$lambda$4$lambda$3$lambda$1(MutableState mutableState, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        y.i(lifecycleOwner, "<unused var>");
        y.i(event, "event");
        mutableState.setValue(event);
    }

    public static final Object getBounds(Uri uri, ab.e<? super Pair<Integer, Integer>> eVar) {
        return pe.i.g(d1.b(), new AnonymousClass4(uri, null), eVar);
    }

    public static final String convertToMS(float f10) {
        return convertToMS((long) f10);
    }
}
