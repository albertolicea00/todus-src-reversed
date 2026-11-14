package cu.z17.views.imageEditor.sections.text;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.PixelCopy;
import android.view.PixelCopy$OnPixelCopyFinishedListener;
import android.view.View;
import android.view.Window;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.AndroidImageBitmap_androidKt;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import cu.z17.views.utils.Z17InlineUtilsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.y;
import pe.m0;
import pe.w0;
import ua.k0;
import ua.v;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@cb.f(c = "cu.z17.views.imageEditor.sections.text.TextKt$Text$1$getAndSaveView$1", f = "Text.kt", l = {119}, m = "invokeSuspend")
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 2, 0})
public final class TextKt$Text$1$getAndSaveView$1 extends cb.m implements Function2 {
    final /* synthetic */ MutableState<Rect> $capturingViewBounds$delegate;
    final /* synthetic */ Context $context;
    final /* synthetic */ FocusRequester $focusRequester;
    final /* synthetic */ MutableState<Boolean> $isEditing$delegate;
    final /* synthetic */ SoftwareKeyboardController $keyboardController;
    final /* synthetic */ Function1 $onTextSuccess;
    final /* synthetic */ View $view;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextKt$Text$1$getAndSaveView$1(FocusRequester focusRequester, SoftwareKeyboardController softwareKeyboardController, MutableState<Boolean> mutableState, MutableState<Rect> mutableState2, View view, Context context, Function1 function1, ab.e<? super TextKt$Text$1$getAndSaveView$1> eVar) {
        super(2, eVar);
        this.$focusRequester = focusRequester;
        this.$keyboardController = softwareKeyboardController;
        this.$isEditing$delegate = mutableState;
        this.$capturingViewBounds$delegate = mutableState2;
        this.$view = view;
        this.$context = context;
        this.$onTextSuccess = function1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invokeSuspend$lambda$2$lambda$0(Function1 function1, Bitmap bitmap, int i10) {
        if (i10 == 0) {
            function1.invoke(AndroidImageBitmap_androidKt.asImageBitmap(bitmap));
        }
    }

    @Override // cb.a
    public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
        return new TextKt$Text$1$getAndSaveView$1(this.$focusRequester, this.$keyboardController, this.$isEditing$delegate, this.$capturingViewBounds$delegate, this.$view, this.$context, this.$onTextSuccess, eVar);
    }

    @Override // cb.a
    public final Object invokeSuspend(Object obj) {
        Object objG = bb.b.g();
        int i10 = this.label;
        if (i10 == 0) {
            v.b(obj);
            TextKt.Text$lambda$33$lambda$6(this.$isEditing$delegate, false);
            this.$focusRequester.freeFocus();
            SoftwareKeyboardController softwareKeyboardController = this.$keyboardController;
            if (softwareKeyboardController != null) {
                softwareKeyboardController.hide();
            }
            this.label = 1;
            if (w0.b(600L, this) == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v.b(obj);
        }
        Rect rectText$lambda$33$lambda$8 = TextKt.Text$lambda$33$lambda$8(this.$capturingViewBounds$delegate);
        if (rectText$lambda$33$lambda$8 != null) {
            View view = this.$view;
            Context context = this.$context;
            final Function1 function1 = this.$onTextSuccess;
            if (Build.VERSION.SDK_INT >= 26) {
                final Bitmap bitmapCreateBitmap = Bitmap.createBitmap(nb.c.d(rectText$lambda$33$lambda$8.getRight() - rectText$lambda$33$lambda$8.getLeft()), nb.c.d(rectText$lambda$33$lambda$8.getBottom() - rectText$lambda$33$lambda$8.getTop()), Bitmap.Config.ARGB_8888);
                y.h(bitmapCreateBitmap, "createBitmap(...)");
                int[] iArr = new int[2];
                view.getLocationInWindow(iArr);
                Window window = Z17InlineUtilsKt.findActivity(context).getWindow();
                int i11 = iArr[0];
                PixelCopy.request(window, new android.graphics.Rect(i11, iArr[1], nb.c.d(rectText$lambda$33$lambda$8.getRight() - rectText$lambda$33$lambda$8.getLeft()) + i11, iArr[1] + nb.c.d(rectText$lambda$33$lambda$8.getBottom() - rectText$lambda$33$lambda$8.getTop())), bitmapCreateBitmap, new PixelCopy$OnPixelCopyFinishedListener() { // from class: cu.z17.views.imageEditor.sections.text.r
                    public final void onPixelCopyFinished(int i12) {
                        TextKt$Text$1$getAndSaveView$1.invokeSuspend$lambda$2$lambda$0(function1, bitmapCreateBitmap, i12);
                    }
                }, new Handler(Looper.getMainLooper()));
            } else {
                Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(nb.c.d(rectText$lambda$33$lambda$8.getRight() - rectText$lambda$33$lambda$8.getLeft()), nb.c.d(rectText$lambda$33$lambda$8.getBottom() - rectText$lambda$33$lambda$8.getTop()), Bitmap.Config.ARGB_8888);
                y.h(bitmapCreateBitmap2, "createBitmap(...)");
                Canvas canvas = new Canvas(bitmapCreateBitmap2);
                canvas.translate(-rectText$lambda$33$lambda$8.getLeft(), -rectText$lambda$33$lambda$8.getTop());
                view.draw(canvas);
                function1.invoke(AndroidImageBitmap_androidKt.asImageBitmap(bitmapCreateBitmap2));
            }
        }
        return k0.f43947a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
        return ((TextKt$Text$1$getAndSaveView$1) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
    }
}
