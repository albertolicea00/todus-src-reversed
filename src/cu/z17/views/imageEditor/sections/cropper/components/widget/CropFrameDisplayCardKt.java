package cu.z17.views.imageEditor.sections.cropper.components.widget;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.AspectRatioKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.EditKt;
import androidx.compose.material.icons.outlined.FavoriteBorderKt;
import androidx.compose.material.icons.outlined.ImageKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.CacheDrawScope;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.OutlineKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.media3.common.C;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.media3.extractor.text.ttml.TtmlNode;
import androidx.media3.muxer.MuxerUtil;
import androidx.profileinstaller.ProfileVerifier;
import cu.z17.views.imageEditor.sections.cropper.components.model.CropOutline;
import cu.z17.views.imageEditor.sections.cropper.components.model.CropPath;
import cu.z17.views.imageEditor.sections.cropper.components.model.CropShape;
import cu.z17.views.imageEditor.sections.cropper.components.util.DimensionUtilKt;
import defpackage.r;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.y;
import le.d0;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aw\u0010\u0016\u001a\u00020\u00122\b\b\u0002\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0007¢\u0006\u0004\b\u0014\u0010\u0015\u001a:\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u00062\u0011\u0010\u0019\u001a\r\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\b\u0018H\u0003¢\u0006\u0004\b\u001a\u0010\u001b¨\u0006\u001d"}, d2 = {"Landroidx/compose/ui/Modifier;", "modifier", "", "editable", "", "scale", "Landroidx/compose/ui/graphics/Color;", "contentColor", "outlineColor", "editButtonBackgroundColor", "editButtonContentColor", "Landroidx/compose/ui/unit/TextUnit;", TtmlNode.ATTR_TTS_FONT_SIZE, "", "title", "Lcu/z17/views/imageEditor/sections/cropper/components/model/CropOutline;", "cropOutline", "Lkotlin/Function0;", "Lua/k0;", "onClick", "CropFrameDisplayCard-ID6zVqo", "(Landroidx/compose/ui/Modifier;ZFJJJJJLjava/lang/String;Lcu/z17/views/imageEditor/sections/cropper/components/model/CropOutline;Llb/a;Landroidx/compose/runtime/Composer;III)V", "CropFrameDisplayCard", "color", "Landroidx/compose/runtime/Composable;", "content", "CropFrameDisplay-FNF3uiM", "(Landroidx/compose/ui/Modifier;Lcu/z17/views/imageEditor/sections/cropper/components/model/CropOutline;JLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "CropFrameDisplay", "views_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class CropFrameDisplayCardKt {
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: CropFrameDisplay-FNF3uiM, reason: not valid java name */
    private static final void m10238CropFrameDisplayFNF3uiM(final Modifier modifier, final CropOutline cropOutline, final long j10, final Function2 function2, Composer composer, final int i10) {
        int i11;
        Composer composerStartRestartGroup = composer.startRestartGroup(459760544);
        if ((i10 & 6) == 0) {
            i11 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i10;
        } else {
            i11 = i10;
        }
        if ((i10 & 48) == 0) {
            i11 |= (i10 & 64) == 0 ? composerStartRestartGroup.changed(cropOutline) : composerStartRestartGroup.changedInstance(cropOutline) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i11 |= composerStartRestartGroup.changed(j10) ? 256 : 128;
        }
        if ((i10 & 3072) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(function2) ? 2048 : 1024;
        }
        if (composerStartRestartGroup.shouldExecute((i11 & 1171) != 1170, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(459760544, i11, -1, "cu.z17.views.imageEditor.sections.cropper.components.widget.CropFrameDisplay (CropFrameDisplayCard.kt:131)");
            }
            final Density density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            final LayoutDirection layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            if (cropOutline instanceof CropShape) {
                composerStartRestartGroup.startReplaceGroup(75995402);
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                Composer.Companion companion = Composer.INSTANCE;
                if (objRememberedValue == companion.getEmpty()) {
                    objRememberedValue = ((CropShape) cropOutline).getShape();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                final Shape shape = (Shape) objRememberedValue;
                boolean zChanged = composerStartRestartGroup.changed(layoutDirection.ordinal()) | composerStartRestartGroup.changed(density) | ((i11 & 896) == 256);
                Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (zChanged || objRememberedValue2 == companion.getEmpty()) {
                    Function1 function1 = new Function1() { // from class: cu.z17.views.imageEditor.sections.cropper.components.widget.j
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return CropFrameDisplayCardKt.CropFrameDisplay_FNF3uiM$lambda$15$lambda$14(shape, layoutDirection, density, j10, (CacheDrawScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(function1);
                    objRememberedValue2 = function1;
                }
                Modifier modifierDrawWithCache = DrawModifierKt.drawWithCache(modifier, (Function1) objRememberedValue2);
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopEnd(), r13);
                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierDrawWithCache);
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
                function2.invoke(composerStartRestartGroup, Integer.valueOf((i11 >> 9) & 14));
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceGroup();
            } else if (cropOutline instanceof CropPath) {
                composerStartRestartGroup.startReplaceGroup(77224180);
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopEnd(), false);
                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier);
                ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
                lb.a constructor2 = companion3.getConstructor();
                if (!r.a(composerStartRestartGroup.getApplier())) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor2);
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM5176constructorimpl2 = Updater.m5176constructorimpl(composerStartRestartGroup);
                Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy2, companion3.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
                Function2 setCompositeKeyHash2 = companion3.getSetCompositeKeyHash();
                if (composerM5176constructorimpl2.getInserting() || !y.d(composerM5176constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                    composerM5176constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    composerM5176constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                }
                Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier2, companion3.getSetModifier());
                IconKt.m3298Iconww6aTOc(FavoriteBorderKt.getFavoriteBorder(Icons.Outlined.INSTANCE), "Crop with Path", BoxScopeInstance.INSTANCE.matchParentSize(Modifier.INSTANCE), j10, composerStartRestartGroup, ((i11 << 3) & 7168) | 48, 0);
                function2.invoke(composerStartRestartGroup, Integer.valueOf((i11 >> 9) & 14));
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(77667511);
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopEnd(), false);
                int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier);
                ComposeUiNode.Companion companion4 = ComposeUiNode.INSTANCE;
                lb.a constructor3 = companion4.getConstructor();
                if (!r.a(composerStartRestartGroup.getApplier())) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor3);
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM5176constructorimpl3 = Updater.m5176constructorimpl(composerStartRestartGroup);
                Updater.m5184setimpl(composerM5176constructorimpl3, measurePolicyMaybeCachedBoxMeasurePolicy3, companion4.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl3, currentCompositionLocalMap3, companion4.getSetResolvedCompositionLocals());
                Function2 setCompositeKeyHash3 = companion4.getSetCompositeKeyHash();
                if (composerM5176constructorimpl3.getInserting() || !y.d(composerM5176constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                    composerM5176constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                    composerM5176constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                }
                Updater.m5184setimpl(composerM5176constructorimpl3, modifierMaterializeModifier3, companion4.getSetModifier());
                IconKt.m3298Iconww6aTOc(ImageKt.getImage(Icons.Outlined.INSTANCE), "Crop with Image Mask", BoxScopeInstance.INSTANCE.matchParentSize(Modifier.INSTANCE), j10, composerStartRestartGroup, ((i11 << 3) & 7168) | 48, 0);
                function2.invoke(composerStartRestartGroup, Integer.valueOf((i11 >> 9) & 14));
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.imageEditor.sections.cropper.components.widget.k
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CropFrameDisplayCardKt.CropFrameDisplay_FNF3uiM$lambda$19(modifier, cropOutline, j10, function2, i10, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0135  */
    /* JADX WARN: Code duplicated, block: B:107:0x0148  */
    /* JADX WARN: Code duplicated, block: B:110:0x0151  */
    /* JADX WARN: Code duplicated, block: B:125:0x0184 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:126:0x0186  */
    /* JADX WARN: Code duplicated, block: B:127:0x0189  */
    /* JADX WARN: Code duplicated, block: B:130:0x018e  */
    /* JADX WARN: Code duplicated, block: B:131:0x019f  */
    /* JADX WARN: Code duplicated, block: B:134:0x01a7  */
    /* JADX WARN: Code duplicated, block: B:137:0x01b9  */
    /* JADX WARN: Code duplicated, block: B:138:0x01c9  */
    /* JADX WARN: Code duplicated, block: B:140:0x01cd  */
    /* JADX WARN: Code duplicated, block: B:142:0x01d5  */
    /* JADX WARN: Code duplicated, block: B:145:0x01e1  */
    /* JADX WARN: Code duplicated, block: B:148:0x0233  */
    /* JADX WARN: Code duplicated, block: B:151:0x023f  */
    /* JADX WARN: Code duplicated, block: B:152:0x0243  */
    /* JADX WARN: Code duplicated, block: B:157:0x0272  */
    /* JADX WARN: Code duplicated, block: B:160:0x0291  */
    /* JADX WARN: Code duplicated, block: B:161:0x0293  */
    /* JADX WARN: Code duplicated, block: B:166:0x02a2  */
    /* JADX WARN: Code duplicated, block: B:169:0x02db  */
    /* JADX WARN: Code duplicated, block: B:172:0x02e7  */
    /* JADX WARN: Code duplicated, block: B:173:0x02eb  */
    /* JADX WARN: Code duplicated, block: B:178:0x0318  */
    /* JADX WARN: Code duplicated, block: B:181:0x037e  */
    /* JADX WARN: Code duplicated, block: B:183:0x03bd  */
    /* JADX WARN: Code duplicated, block: B:186:0x03d0  */
    /* JADX WARN: Code duplicated, block: B:188:0x03e0  */
    /* JADX WARN: Code duplicated, block: B:191:0x03f4  */
    /* JADX WARN: Code duplicated, block: B:193:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:78:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:80:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:81:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:85:0x0109  */
    /* JADX WARN: Code duplicated, block: B:87:0x010f  */
    /* JADX WARN: Code duplicated, block: B:88:0x0114  */
    /* JADX WARN: Code duplicated, block: B:90:0x011a  */
    /* JADX WARN: Code duplicated, block: B:91:0x011d  */
    /* JADX WARN: Code duplicated, block: B:95:0x0125  */
    /* JADX WARN: Code duplicated, block: B:97:0x012b  */
    /* JADX WARN: Code duplicated, block: B:98:0x012e  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* JADX INFO: renamed from: CropFrameDisplayCard-ID6zVqo, reason: not valid java name */
    public static final void m10239CropFrameDisplayCardID6zVqo(Modifier modifier, final boolean z10, final float f10, long j10, final long j11, long j12, long j13, long j14, final String title, final CropOutline cropOutline, final lb.a onClick, Composer composer, final int i10, final int i11, final int i12) {
        Modifier modifier2;
        int i13;
        boolean z11;
        long tertiary;
        int i14;
        int i15;
        boolean z12;
        final long j15;
        Composer composer2;
        final Modifier modifier3;
        final long j16;
        final long j17;
        final long j18;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier modifier4;
        long surface;
        long onTertiary;
        long sp;
        int i16;
        long j19;
        int currentCompositeKeyHash;
        lb.a constructor;
        Composer composerM5176constructorimpl;
        Function2 setCompositeKeyHash;
        boolean z13;
        Object objRememberedValue;
        int currentCompositeKeyHash2;
        lb.a constructor2;
        Composer composerM5176constructorimpl2;
        Function2 setCompositeKeyHash2;
        int i17;
        int i18;
        int i19;
        Composer composer3;
        int i20;
        boolean zChangedInstance;
        int i21;
        int i22;
        y.i(title, "title");
        y.i(cropOutline, "cropOutline");
        y.i(onClick, "onClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(-708391474);
        int i23 = i12 & 1;
        if (i23 != 0) {
            i13 = i10 | 6;
            modifier2 = modifier;
        } else if ((i10 & 6) == 0) {
            modifier2 = modifier;
            i13 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i10;
        } else {
            modifier2 = modifier;
            i13 = i10;
        }
        if ((i10 & 48) == 0) {
            z11 = z10;
            i13 |= composerStartRestartGroup.changed(z11) ? 32 : 16;
        } else {
            z11 = z10;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i13 |= composerStartRestartGroup.changed(f10) ? 256 : 128;
        }
        if ((i10 & 3072) == 0) {
            i13 |= ((i12 & 8) == 0 && composerStartRestartGroup.changed(j10)) ? 2048 : 1024;
        }
        if ((i10 & 24576) == 0) {
            i13 |= composerStartRestartGroup.changed(j11) ? 16384 : 8192;
        }
        if ((i10 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            tertiary = j12;
            i13 |= ((i12 & 32) == 0 && composerStartRestartGroup.changed(tertiary)) ? 131072 : 65536;
        } else {
            tertiary = j12;
        }
        if ((i10 & 1572864) == 0) {
            i13 |= ((i12 & 64) == 0 && composerStartRestartGroup.changed(j13)) ? 1048576 : 524288;
        }
        int i24 = i12 & 128;
        if (i24 == 0) {
            i14 = i24;
            if ((12582912 & i10) == 0) {
                i13 |= composerStartRestartGroup.changed(j14) ? 8388608 : 4194304;
            }
            if ((i10 & 100663296) == 0) {
                if (composerStartRestartGroup.changed(title)) {
                    i22 = 67108864;
                } else {
                    i22 = 33554432;
                }
                i13 |= i22;
            }
            if ((i10 & 805306368) == 0) {
                if ((i10 & 1073741824) == 0) {
                    zChangedInstance = composerStartRestartGroup.changed(cropOutline);
                } else {
                    zChangedInstance = composerStartRestartGroup.changedInstance(cropOutline);
                }
                if (zChangedInstance) {
                    i21 = C.BUFFER_FLAG_LAST_SAMPLE;
                } else {
                    i21 = 268435456;
                }
                i13 |= i21;
            }
            if ((i11 & 6) == 0) {
                if (composerStartRestartGroup.changedInstance(onClick)) {
                    i20 = 4;
                } else {
                    i20 = 2;
                }
                i15 = i11 | i20;
            } else {
                i15 = i11;
            }
            if ((306783379 & i13) == 306783378 || (i15 & 3) != 2) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z12, i13 & 1)) {
                composerStartRestartGroup.startDefaults();
                if ((i10 & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    if (i23 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if ((i12 & 8) != 0) {
                        surface = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getSurface();
                        i13 &= -7169;
                    } else {
                        surface = j10;
                    }
                    if ((i12 & 32) != 0) {
                        tertiary = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getTertiary();
                        i13 &= -458753;
                    }
                    if ((i12 & 64) != 0) {
                        onTertiary = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnTertiary();
                        i13 &= -3670017;
                    } else {
                        onTertiary = j13;
                    }
                    if (i14 != 0) {
                        sp = TextUnitKt.getSp(12);
                    } else {
                        sp = j14;
                    }
                    i16 = i13;
                    j19 = onTertiary;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    if ((i12 & 8) != 0) {
                        i13 &= -7169;
                    }
                    if ((i12 & 32) != 0) {
                        i13 &= -458753;
                    }
                    if ((i12 & 64) != 0) {
                        i13 &= -3670017;
                    }
                    surface = j10;
                    sp = j14;
                    modifier4 = modifier2;
                    i16 = i13;
                    j19 = j13;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-708391474, i16, i15, "cu.z17.views.imageEditor.sections.cropper.components.widget.CropFrameDisplayCard (CropFrameDisplayCard.kt:47)");
                }
                Modifier modifier5 = modifier4;
                long j20 = surface;
                float f11 = 4;
                Modifier modifierM1725padding3ABfNKs = PaddingKt.m1725padding3ABfNKs(BackgroundKt.m1205backgroundbw27NRU$default(modifier5, j20, null, 2, null), Dp.m8823constructorimpl(f11));
                Alignment.Companion companion = Alignment.INSTANCE;
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion.getCenter(), false);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1725padding3ABfNKs);
                ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                constructor = companion2.getConstructor();
                if (!r.a(composerStartRestartGroup.getApplier())) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerM5176constructorimpl = Updater.m5176constructorimpl(composerStartRestartGroup);
                final long j21 = j19;
                Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, companion2.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
                setCompositeKeyHash = companion2.getSetCompositeKeyHash();
                if (composerM5176constructorimpl.getInserting() || !y.d(composerM5176constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion2.getSetModifier());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                Modifier.Companion companion3 = Modifier.INSTANCE;
                if ((i16 & 896) == 256) {
                    z13 = true;
                } else {
                    z13 = false;
                }
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (z13 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: cu.z17.views.imageEditor.sections.cropper.components.widget.g
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return CropFrameDisplayCardKt.CropFrameDisplayCard_ID6zVqo$lambda$9$lambda$1$lambda$0(f10, (GraphicsLayerScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                Modifier modifierGraphicsLayer = GraphicsLayerModifierKt.graphicsLayer(companion3, (Function1) objRememberedValue);
                MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), companion.getCenterHorizontally(), composerStartRestartGroup, 48);
                currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierGraphicsLayer);
                constructor2 = companion2.getConstructor();
                if (!r.a(composerStartRestartGroup.getApplier())) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor2);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerM5176constructorimpl2 = Updater.m5176constructorimpl(composerStartRestartGroup);
                Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyColumnMeasurePolicy, companion2.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap2, companion2.getSetResolvedCompositionLocals());
                setCompositeKeyHash2 = companion2.getSetCompositeKeyHash();
                if (composerM5176constructorimpl2.getInserting() || !y.d(composerM5176constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                    composerM5176constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    composerM5176constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                }
                Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier2, companion2.getSetModifier());
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                Modifier modifierAspectRatio$default = AspectRatioKt.aspectRatio$default(PaddingKt.m1725padding3ABfNKs(SizeKt.fillMaxWidth$default(companion3, 0.0f, 1, null), Dp.m8823constructorimpl(f11)), 1.0f, false, 2, null);
                final long j22 = tertiary;
                final boolean z14 = z11;
                i17 = i16;
                i18 = i17 >> 24;
                i19 = (i17 >> 6) & 896;
                composer3 = composerStartRestartGroup;
                m10238CropFrameDisplayFNF3uiM(modifierAspectRatio$default, cropOutline, j11, ComposableLambdaKt.rememberComposableLambda(393565727, true, new Function2() { // from class: cu.z17.views.imageEditor.sections.cropper.components.widget.h
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return CropFrameDisplayCardKt.CropFrameDisplayCard_ID6zVqo$lambda$9$lambda$8$lambda$7(z14, f10, onClick, j22, j21, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composer3, (i18 & 112) | 3078 | i19);
                if (d0.q0(title)) {
                    composer3.startReplaceGroup(1079182104);
                } else {
                    composer3.startReplaceGroup(1083507317);
                    TextKt.m3848Text4IGK_g(title, (Modifier) null, j11, sp, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m8750getEllipsisgIe3tQ8(), false, 1, 0, (Function1) null, (TextStyle) null, composer3, (i18 & 14) | i19 | ((i17 >> 12) & 7168), 3120, 120818);
                    composer3 = composer3;
                }
                composer3.endReplaceGroup();
                composer3.endNode();
                composer3.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer2 = composer3;
                modifier3 = modifier5;
                j18 = sp;
                j17 = j20;
                j16 = j22;
                j15 = j21;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                j15 = j13;
                composer2 = composerStartRestartGroup;
                modifier3 = modifier2;
                j16 = tertiary;
                j17 = j10;
                j18 = j14;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.imageEditor.sections.cropper.components.widget.i
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return CropFrameDisplayCardKt.CropFrameDisplayCard_ID6zVqo$lambda$10(modifier3, z10, f10, j17, j11, j16, j15, j18, title, cropOutline, onClick, i10, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i13 |= 12582912;
        i14 = i24;
        if ((i10 & 100663296) == 0) {
            if (composerStartRestartGroup.changed(title)) {
                i22 = 67108864;
            } else {
                i22 = 33554432;
            }
            i13 |= i22;
        }
        if ((i10 & 805306368) == 0) {
            if ((i10 & 1073741824) == 0) {
                zChangedInstance = composerStartRestartGroup.changed(cropOutline);
            } else {
                zChangedInstance = composerStartRestartGroup.changedInstance(cropOutline);
            }
            if (zChangedInstance) {
                i21 = C.BUFFER_FLAG_LAST_SAMPLE;
            } else {
                i21 = 268435456;
            }
            i13 |= i21;
        }
        if ((i11 & 6) == 0) {
            if (composerStartRestartGroup.changedInstance(onClick)) {
                i20 = 4;
            } else {
                i20 = 2;
            }
            i15 = i11 | i20;
        } else {
            i15 = i11;
        }
        if ((306783379 & i13) == 306783378) {
            z12 = true;
        } else {
            z12 = true;
        }
        if (composerStartRestartGroup.shouldExecute(z12, i13 & 1)) {
            composerStartRestartGroup.startDefaults();
            if ((i10 & 1) != 0) {
                if (i23 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if ((i12 & 8) != 0) {
                    surface = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getSurface();
                    i13 &= -7169;
                } else {
                    surface = j10;
                }
                if ((i12 & 32) != 0) {
                    tertiary = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getTertiary();
                    i13 &= -458753;
                }
                if ((i12 & 64) != 0) {
                    onTertiary = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnTertiary();
                    i13 &= -3670017;
                } else {
                    onTertiary = j13;
                }
                if (i14 != 0) {
                    sp = TextUnitKt.getSp(12);
                } else {
                    sp = j14;
                }
                i16 = i13;
                j19 = onTertiary;
            } else {
                if (i23 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if ((i12 & 8) != 0) {
                    surface = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getSurface();
                    i13 &= -7169;
                } else {
                    surface = j10;
                }
                if ((i12 & 32) != 0) {
                    tertiary = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getTertiary();
                    i13 &= -458753;
                }
                if ((i12 & 64) != 0) {
                    onTertiary = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnTertiary();
                    i13 &= -3670017;
                } else {
                    onTertiary = j13;
                }
                if (i14 != 0) {
                    sp = TextUnitKt.getSp(12);
                } else {
                    sp = j14;
                }
                i16 = i13;
                j19 = onTertiary;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-708391474, i16, i15, "cu.z17.views.imageEditor.sections.cropper.components.widget.CropFrameDisplayCard (CropFrameDisplayCard.kt:47)");
            }
            Modifier modifier6 = modifier4;
            long j23 = surface;
            float f12 = 4;
            Modifier modifierM1725padding3ABfNKs2 = PaddingKt.m1725padding3ABfNKs(BackgroundKt.m1205backgroundbw27NRU$default(modifier6, j23, null, 2, null), Dp.m8823constructorimpl(f12));
            Alignment.Companion companion4 = Alignment.INSTANCE;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(companion4.getCenter(), false);
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1725padding3ABfNKs2);
            ComposeUiNode.Companion companion5 = ComposeUiNode.INSTANCE;
            constructor = companion5.getConstructor();
            if (!r.a(composerStartRestartGroup.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            composerM5176constructorimpl = Updater.m5176constructorimpl(composerStartRestartGroup);
            final long j24 = j19;
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy2, companion5.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap3, companion5.getSetResolvedCompositionLocals());
            setCompositeKeyHash = companion5.getSetCompositeKeyHash();
            if (composerM5176constructorimpl.getInserting()) {
                composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            } else {
                composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier3, companion5.getSetModifier());
            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
            Modifier.Companion companion6 = Modifier.INSTANCE;
            if ((i16 & 896) == 256) {
                z13 = true;
            } else {
                z13 = false;
            }
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z13) {
                objRememberedValue = new Function1() { // from class: cu.z17.views.imageEditor.sections.cropper.components.widget.g
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return CropFrameDisplayCardKt.CropFrameDisplayCard_ID6zVqo$lambda$9$lambda$1$lambda$0(f10, (GraphicsLayerScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = new Function1() { // from class: cu.z17.views.imageEditor.sections.cropper.components.widget.g
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return CropFrameDisplayCardKt.CropFrameDisplayCard_ID6zVqo$lambda$9$lambda$1$lambda$0(f10, (GraphicsLayerScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            Modifier modifierGraphicsLayer2 = GraphicsLayerModifierKt.graphicsLayer(companion6, (Function1) objRememberedValue);
            MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), companion4.getCenterHorizontally(), composerStartRestartGroup, 48);
            currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierGraphicsLayer2);
            constructor2 = companion5.getConstructor();
            if (!r.a(composerStartRestartGroup.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor2);
            } else {
                composerStartRestartGroup.useNode();
            }
            composerM5176constructorimpl2 = Updater.m5176constructorimpl(composerStartRestartGroup);
            Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyColumnMeasurePolicy2, companion5.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap4, companion5.getSetResolvedCompositionLocals());
            setCompositeKeyHash2 = companion5.getSetCompositeKeyHash();
            if (composerM5176constructorimpl2.getInserting()) {
                composerM5176constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                composerM5176constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            } else {
                composerM5176constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                composerM5176constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier4, companion5.getSetModifier());
            ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
            Modifier modifierAspectRatio$default2 = AspectRatioKt.aspectRatio$default(PaddingKt.m1725padding3ABfNKs(SizeKt.fillMaxWidth$default(companion6, 0.0f, 1, null), Dp.m8823constructorimpl(f12)), 1.0f, false, 2, null);
            final long j25 = tertiary;
            final boolean z15 = z11;
            i17 = i16;
            i18 = i17 >> 24;
            i19 = (i17 >> 6) & 896;
            composer3 = composerStartRestartGroup;
            m10238CropFrameDisplayFNF3uiM(modifierAspectRatio$default2, cropOutline, j11, ComposableLambdaKt.rememberComposableLambda(393565727, true, new Function2() { // from class: cu.z17.views.imageEditor.sections.cropper.components.widget.h
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CropFrameDisplayCardKt.CropFrameDisplayCard_ID6zVqo$lambda$9$lambda$8$lambda$7(z15, f10, onClick, j25, j24, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composer3, (i18 & 112) | 3078 | i19);
            if (d0.q0(title)) {
                composer3.startReplaceGroup(1083507317);
                TextKt.m3848Text4IGK_g(title, (Modifier) null, j11, sp, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m8750getEllipsisgIe3tQ8(), false, 1, 0, (Function1) null, (TextStyle) null, composer3, (i18 & 14) | i19 | ((i17 >> 12) & 7168), 3120, 120818);
                composer3 = composer3;
            } else {
                composer3.startReplaceGroup(1079182104);
            }
            composer3.endReplaceGroup();
            composer3.endNode();
            composer3.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer2 = composer3;
            modifier3 = modifier6;
            j18 = sp;
            j17 = j23;
            j16 = j25;
            j15 = j24;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            j15 = j13;
            composer2 = composerStartRestartGroup;
            modifier3 = modifier2;
            j16 = tertiary;
            j17 = j10;
            j18 = j14;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.imageEditor.sections.cropper.components.widget.i
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CropFrameDisplayCardKt.CropFrameDisplayCard_ID6zVqo$lambda$10(modifier3, z10, f10, j17, j11, j16, j15, j18, title, cropOutline, onClick, i10, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 CropFrameDisplayCard_ID6zVqo$lambda$10(Modifier modifier, boolean z10, float f10, long j10, long j11, long j12, long j13, long j14, String str, CropOutline cropOutline, lb.a aVar, int i10, int i11, int i12, Composer composer, int i13) {
        m10239CropFrameDisplayCardID6zVqo(modifier, z10, f10, j10, j11, j12, j13, j14, str, cropOutline, aVar, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), RecomposeScopeImplKt.updateChangedFlags(i11), i12);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 CropFrameDisplayCard_ID6zVqo$lambda$9$lambda$1$lambda$0(float f10, GraphicsLayerScope graphicsLayer) {
        y.i(graphicsLayer, "$this$graphicsLayer");
        graphicsLayer.setScaleX(f10);
        graphicsLayer.setScaleY(f10);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 CropFrameDisplayCard_ID6zVqo$lambda$9$lambda$8$lambda$7(boolean z10, final float f10, final lb.a aVar, long j10, long j11, Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(393565727, i10, -1, "cu.z17.views.imageEditor.sections.cropper.components.widget.CropFrameDisplayCard.<anonymous>.<anonymous>.<anonymous> (CropFrameDisplayCard.kt:74)");
            }
            if (z10) {
                composer.startReplaceGroup(-544064886);
                Modifier.Companion companion = Modifier.INSTANCE;
                boolean zChanged = composer.changed(f10);
                Object objRememberedValue = composer.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: cu.z17.views.imageEditor.sections.cropper.components.widget.d
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return CropFrameDisplayCardKt.CropFrameDisplayCard_ID6zVqo$lambda$9$lambda$8$lambda$7$lambda$4$lambda$3(f10, (GraphicsLayerScope) obj);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                Modifier modifierGraphicsLayer = GraphicsLayerModifierKt.graphicsLayer(companion, (Function1) objRememberedValue);
                boolean zChanged2 = composer.changed(aVar);
                Object objRememberedValue2 = composer.rememberedValue();
                if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new lb.a() { // from class: cu.z17.views.imageEditor.sections.cropper.components.widget.e
                        @Override // lb.a
                        public final Object invoke() {
                            return CropFrameDisplayCardKt.CropFrameDisplayCard_ID6zVqo$lambda$9$lambda$8$lambda$7$lambda$6$lambda$5(aVar);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue2);
                }
                IconKt.m3298Iconww6aTOc(EditKt.getEdit(Icons.INSTANCE.getDefault()), "Edit", PaddingKt.m1725padding3ABfNKs(SizeKt.m1769size3ABfNKs(BackgroundKt.m1204backgroundbw27NRU(PaddingKt.m1725padding3ABfNKs(ClickableKt.m1238clickableXHw0xAI$default(modifierGraphicsLayer, false, null, null, (lb.a) objRememberedValue2, 7, null), Dp.m8823constructorimpl(8)), j10, RoundedCornerShapeKt.getCircleShape()), Dp.m8823constructorimpl(20)), Dp.m8823constructorimpl(4)), j11, composer, 48, 0);
            } else {
                composer.startReplaceGroup(-546860125);
            }
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 CropFrameDisplayCard_ID6zVqo$lambda$9$lambda$8$lambda$7$lambda$4$lambda$3(float f10, GraphicsLayerScope graphicsLayer) {
        y.i(graphicsLayer, "$this$graphicsLayer");
        float fScale = DimensionUtilKt.scale(0.9f, 1.0f, rb.k.d(f10, 0.9f), 0.0f, 1.0f);
        graphicsLayer.setScaleX(fScale);
        graphicsLayer.setScaleY(fScale);
        graphicsLayer.getDensity();
        float fMo1345toPx0680j_4 = graphicsLayer.mo1345toPx0680j_4(Dp.m8823constructorimpl(12));
        graphicsLayer.setTranslationX(fMo1345toPx0680j_4);
        graphicsLayer.setTranslationY(-fMo1345toPx0680j_4);
        graphicsLayer.setClip(true);
        graphicsLayer.setShape(RoundedCornerShapeKt.getCircleShape());
        graphicsLayer.getDensity();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 CropFrameDisplayCard_ID6zVqo$lambda$9$lambda$8$lambda$7$lambda$6$lambda$5(lb.a aVar) {
        aVar.invoke();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DrawResult CropFrameDisplay_FNF3uiM$lambda$15$lambda$14(Shape shape, LayoutDirection layoutDirection, Density density, final long j10, CacheDrawScope drawWithCache) {
        y.i(drawWithCache, "$this$drawWithCache");
        final Outline outlineMo1261createOutlinePq9zytI = shape.mo1261createOutlinePq9zytI(drawWithCache.m5441getSizeNHjbRc(), layoutDirection, density);
        return drawWithCache.onDrawWithContent(new Function1() { // from class: cu.z17.views.imageEditor.sections.cropper.components.widget.f
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return CropFrameDisplayCardKt.CropFrameDisplay_FNF3uiM$lambda$15$lambda$14$lambda$13(outlineMo1261createOutlinePq9zytI, j10, (ContentDrawScope) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 CropFrameDisplay_FNF3uiM$lambda$15$lambda$14$lambda$13(Outline outline, long j10, ContentDrawScope onDrawWithContent) {
        y.i(onDrawWithContent, "$this$onDrawWithContent");
        float fIntBitsToFloat = Float.intBitsToFloat((int) (onDrawWithContent.mo6334getSizeNHjbRc() >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (onDrawWithContent.mo6334getSizeNHjbRc() & MuxerUtil.UNSIGNED_INT_MAX_VALUE));
        Rect rect = outline.getRect();
        float right = rect.getRight() - rect.getLeft();
        Rect rect2 = outline.getRect();
        float bottom = rect2.getBottom() - rect2.getTop();
        float f10 = 2;
        float f11 = (fIntBitsToFloat - right) / f10;
        float f12 = (fIntBitsToFloat2 - bottom) / f10;
        onDrawWithContent.getDrawContext().getTransform().translate(f11, f12);
        try {
            OutlineKt.m6118drawOutlinewDX37Ww$default(onDrawWithContent, outline, j10, 0.0f, new Stroke(onDrawWithContent.mo1345toPx0680j_4(Dp.m8823constructorimpl(4)), 0.0f, 0, 0, null, 30, null), null, 0, 52, null);
            onDrawWithContent.getDrawContext().getTransform().translate(-f11, -f12);
            onDrawWithContent.drawContent();
            return k0.f43947a;
        } catch (Throwable th2) {
            onDrawWithContent.getDrawContext().getTransform().translate(-f11, -f12);
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 CropFrameDisplay_FNF3uiM$lambda$19(Modifier modifier, CropOutline cropOutline, long j10, Function2 function2, int i10, Composer composer, int i11) {
        m10238CropFrameDisplayFNF3uiM(modifier, cropOutline, j10, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1));
        return k0.f43947a;
    }
}
