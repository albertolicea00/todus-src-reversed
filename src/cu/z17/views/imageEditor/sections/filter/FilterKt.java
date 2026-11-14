package cu.z17.views.imageEditor.sections.filter;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.exoplayer.RendererCapabilities;
import cb.m;
import cu.z17.views.picture.Z17PictureKt;
import defpackage.r;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.y;
import pe.d1;
import pe.m0;
import ua.k0;
import ua.v;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aG\u0010\t\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00000\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0018\u0010\b\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00000\u0002\u0012\u0004\u0012\u00020\u00070\u0006H\u0007¢\u0006\u0004\b\t\u0010\n\u001a \u0010\u000e\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0000H\u0086@¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Landroid/graphics/Bitmap;", "bitmap", "", "filteredBitmaps", "", "filterSelected", "Lkotlin/Function1;", "Lua/k0;", "onFiltersLoad", "Filter", "(Landroid/graphics/Bitmap;Ljava/util/List;ILkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "Landroid/graphics/ColorMatrix;", "cm", "sourceBitmap", "getBitmapFromColorMatrix", "(Landroid/graphics/ColorMatrix;Landroid/graphics/Bitmap;Lab/e;)Ljava/lang/Object;", "views_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class FilterKt {

    /* JADX INFO: renamed from: cu.z17.views.imageEditor.sections.filter.FilterKt$getBitmapFromColorMatrix$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.z17.views.imageEditor.sections.filter.FilterKt$getBitmapFromColorMatrix$2", f = "Filter.kt", l = {}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Landroid/graphics/Bitmap;", "<anonymous>", "(Lpe/m0;)Landroid/graphics/Bitmap;"}, k = 3, mv = {2, 2, 0})
    public static final class AnonymousClass2 extends m implements Function2 {
        final /* synthetic */ ColorMatrix $cm;
        final /* synthetic */ Bitmap $sourceBitmap;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Bitmap bitmap, ColorMatrix colorMatrix, ab.e<? super AnonymousClass2> eVar) {
            super(2, eVar);
            this.$sourceBitmap = bitmap;
            this.$cm = colorMatrix;
        }

        @Override // cb.a
        public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
            return new AnonymousClass2(this.$sourceBitmap, this.$cm, eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            bb.b.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v.b(obj);
            Bitmap bitmapCopy = this.$sourceBitmap.copy(Bitmap.Config.ARGB_8888, true);
            y.h(bitmapCopy, "copy(...)");
            int width = bitmapCopy.getWidth();
            int height = bitmapCopy.getHeight();
            Bitmap.Config config = bitmapCopy.getConfig();
            y.f(config);
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width, height, config);
            y.h(bitmapCreateBitmap, "createBitmap(...)");
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            Paint paint = new Paint();
            paint.setColorFilter(new ColorMatrixColorFilter(this.$cm));
            canvas.drawBitmap(bitmapCopy, 0.0f, 0.0f, paint);
            return bitmapCreateBitmap;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(m0 m0Var, ab.e<? super Bitmap> eVar) {
            return ((AnonymousClass2) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
        }
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void Filter(final Bitmap bitmap, final List<Bitmap> filteredBitmaps, final int i10, final Function1 onFiltersLoad, Composer composer, final int i11) {
        int i12;
        Object objM5856boximpl;
        y.i(bitmap, "bitmap");
        y.i(filteredBitmaps, "filteredBitmaps");
        y.i(onFiltersLoad, "onFiltersLoad");
        Composer composerStartRestartGroup = composer.startRestartGroup(115845225);
        if ((i11 & 6) == 0) {
            i12 = (composerStartRestartGroup.changedInstance(bitmap) ? 4 : 2) | i11;
        } else {
            i12 = i11;
        }
        if ((i11 & 48) == 0) {
            i12 |= composerStartRestartGroup.changedInstance(filteredBitmaps) ? 32 : 16;
        }
        if ((i11 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i12 |= composerStartRestartGroup.changed(i10) ? 256 : 128;
        }
        if ((i11 & 3072) == 0) {
            i12 |= composerStartRestartGroup.changedInstance(onFiltersLoad) ? 2048 : 1024;
        }
        if (composerStartRestartGroup.shouldExecute((i12 & 1171) != 1170, i12 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(115845225, i12, -1, "cu.z17.views.imageEditor.sections.filter.Filter (Filter.kt:25)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
            ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
            lb.a constructor = companion2.getConstructor();
            if (!r.a(composerStartRestartGroup.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM5176constructorimpl = Updater.m5176constructorimpl(composerStartRestartGroup);
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash = companion2.getSetCompositeKeyHash();
            if (composerM5176constructorimpl.getInserting() || !y.d(composerM5176constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion2.getSetModifier());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(companion, 0.0f, 1, null);
            if (i10 != -1) {
                objM5856boximpl = i10 != 0 ? filteredBitmaps.get(i10 - 1) : bitmap;
            } else {
                objM5856boximpl = Color.m5856boximpl(Color.INSTANCE.m5901getTransparent0d7_KjU());
            }
            int i13 = i12;
            Z17PictureKt.m10278Z17BasePictureC8z9wKI(modifierFillMaxSize$default, objM5856boximpl, Color.m5856boximpl(MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground()), null, null, null, 0, null, null, composerStartRestartGroup, 6, TypedValues.PositionType.TYPE_PERCENT_HEIGHT);
            k0 k0Var = k0.f43947a;
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(filteredBitmaps) | composerStartRestartGroup.changedInstance(bitmap) | ((i13 & 7168) == 2048);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new FilterKt$Filter$1$1$1(filteredBitmaps, bitmap, onFiltersLoad, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            EffectsKt.LaunchedEffect(k0Var, (Function2) objRememberedValue, composerStartRestartGroup, 6);
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.imageEditor.sections.filter.f
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FilterKt.Filter$lambda$2(bitmap, filteredBitmaps, i10, onFiltersLoad, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 Filter$lambda$2(Bitmap bitmap, List list, int i10, Function1 function1, int i11, Composer composer, int i12) {
        Filter(bitmap, list, i10, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i11 | 1));
        return k0.f43947a;
    }

    public static final Object getBitmapFromColorMatrix(ColorMatrix colorMatrix, Bitmap bitmap, ab.e<? super Bitmap> eVar) {
        return pe.i.g(d1.a(), new AnonymousClass2(bitmap, colorMatrix, null), eVar);
    }
}
