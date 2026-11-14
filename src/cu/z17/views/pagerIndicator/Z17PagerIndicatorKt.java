package cu.z17.views.pagerIndicator;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.pager.PagerState;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.ContentAlpha;
import androidx.compose.material.ContentAlphaKt;
import androidx.compose.material.ContentColorKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.media3.muxer.MuxerUtil;
import androidx.profileinstaller.ProfileVerifier;
import cu.z17.views.pagerIndicator.Z17PagerIndicatorKt;
import defpackage.r;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.y;
import lb.a;
import rb.k;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001as\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\n2\b\b\u0002\u0010\u000f\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Landroidx/compose/foundation/pager/PagerState;", "pagerState", "Landroidx/compose/ui/Modifier;", "modifier", "Lkotlin/Function1;", "", "pageIndexMapping", "Landroidx/compose/ui/graphics/Color;", "activeColor", "inactiveColor", "Landroidx/compose/ui/unit/Dp;", "indicatorWidth", "indicatorHeight", "spacing", "Landroidx/compose/ui/graphics/Shape;", "indicatorShape", "Lua/k0;", "Z17PagerIndicator-D_W6g9U", "(Landroidx/compose/foundation/pager/PagerState;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;JJFFFLandroidx/compose/ui/graphics/Shape;Landroidx/compose/runtime/Composer;II)V", "Z17PagerIndicator", "views_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class Z17PagerIndicatorKt {
    /* JADX WARN: Code duplicated, block: B:102:0x0121  */
    /* JADX WARN: Code duplicated, block: B:104:0x0134  */
    /* JADX WARN: Code duplicated, block: B:123:0x0164 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:124:0x0166  */
    /* JADX WARN: Code duplicated, block: B:126:0x016b  */
    /* JADX WARN: Code duplicated, block: B:128:0x0177  */
    /* JADX WARN: Code duplicated, block: B:132:0x0186  */
    /* JADX WARN: Code duplicated, block: B:135:0x01b8  */
    /* JADX WARN: Code duplicated, block: B:136:0x01d1  */
    /* JADX WARN: Code duplicated, block: B:138:0x01d4  */
    /* JADX WARN: Code duplicated, block: B:139:0x01dc  */
    /* JADX WARN: Code duplicated, block: B:142:0x01e2  */
    /* JADX WARN: Code duplicated, block: B:145:0x01e9  */
    /* JADX WARN: Code duplicated, block: B:146:0x01ee  */
    /* JADX WARN: Code duplicated, block: B:149:0x01f5  */
    /* JADX WARN: Code duplicated, block: B:151:0x0200  */
    /* JADX WARN: Code duplicated, block: B:154:0x020c  */
    /* JADX WARN: Code duplicated, block: B:157:0x0240  */
    /* JADX WARN: Code duplicated, block: B:160:0x024c  */
    /* JADX WARN: Code duplicated, block: B:161:0x0250  */
    /* JADX WARN: Code duplicated, block: B:164:0x0271  */
    /* JADX WARN: Code duplicated, block: B:166:0x027f  */
    /* JADX WARN: Code duplicated, block: B:169:0x02e3  */
    /* JADX WARN: Code duplicated, block: B:172:0x02ef  */
    /* JADX WARN: Code duplicated, block: B:173:0x02f3  */
    /* JADX WARN: Code duplicated, block: B:176:0x0312  */
    /* JADX WARN: Code duplicated, block: B:178:0x0320  */
    /* JADX WARN: Code duplicated, block: B:181:0x034c A[LOOP:0: B:180:0x034a->B:181:0x034c, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:184:0x0361  */
    /* JADX WARN: Code duplicated, block: B:185:0x0364  */
    /* JADX WARN: Code duplicated, block: B:189:0x036b  */
    /* JADX WARN: Code duplicated, block: B:192:0x037f  */
    /* JADX WARN: Code duplicated, block: B:196:0x038b  */
    /* JADX WARN: Code duplicated, block: B:199:0x03a5  */
    /* JADX WARN: Code duplicated, block: B:200:0x03ac  */
    /* JADX WARN: Code duplicated, block: B:203:0x03bf  */
    /* JADX WARN: Code duplicated, block: B:206:0x03cc  */
    /* JADX WARN: Code duplicated, block: B:209:0x03e2  */
    /* JADX WARN: Code duplicated, block: B:212:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:23:0x0043  */
    /* JADX WARN: Code duplicated, block: B:25:0x0048  */
    /* JADX WARN: Code duplicated, block: B:27:0x004c  */
    /* JADX WARN: Code duplicated, block: B:29:0x0054  */
    /* JADX WARN: Code duplicated, block: B:30:0x0057  */
    /* JADX WARN: Code duplicated, block: B:34:0x005e  */
    /* JADX WARN: Code duplicated, block: B:36:0x0062  */
    /* JADX WARN: Code duplicated, block: B:38:0x006a  */
    /* JADX WARN: Code duplicated, block: B:39:0x006d  */
    /* JADX WARN: Code duplicated, block: B:42:0x0073  */
    /* JADX WARN: Code duplicated, block: B:45:0x0079  */
    /* JADX WARN: Code duplicated, block: B:47:0x007d  */
    /* JADX WARN: Code duplicated, block: B:49:0x0085  */
    /* JADX WARN: Code duplicated, block: B:50:0x0088  */
    /* JADX WARN: Code duplicated, block: B:53:0x008f  */
    /* JADX WARN: Code duplicated, block: B:56:0x0097  */
    /* JADX WARN: Code duplicated, block: B:57:0x009c  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:61:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:62:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:66:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:68:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:71:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:73:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:76:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:78:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:81:0x00e0 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:84:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:87:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:89:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:92:0x00fe A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:95:0x0105  */
    /* JADX WARN: Code duplicated, block: B:98:0x0115  */
    /* JADX WARN: Code duplicated, block: B:99:0x0118  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* JADX INFO: renamed from: Z17PagerIndicator-D_W6g9U, reason: not valid java name */
    public static final void m10266Z17PagerIndicatorD_W6g9U(final PagerState pagerState, Modifier modifier, Function1 function1, long j10, long j11, float f10, float f11, float f12, Shape shape, Composer composer, final int i10, final int i11) {
        Modifier modifier2;
        int i12;
        final Function1 function2;
        int i13;
        long jM5865copywmQWz5c$default;
        long j12;
        int i14;
        int i15;
        float f13;
        boolean z10;
        Modifier modifier3;
        final Function1 function3;
        final long j13;
        final float f14;
        final Shape shape2;
        final float f15;
        final float f16;
        final long j14;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        long j15;
        long jM5865copywmQWz5c$default2;
        float fM8823constructorimpl;
        int i16;
        float f17;
        Shape circleShape;
        Object objRememberedValue;
        int currentCompositeKeyHash;
        a constructor;
        Composer composerM5176constructorimpl;
        long j16;
        Function2 setCompositeKeyHash;
        final int iMo1339roundToPx0680j_4;
        final int iMo1339roundToPx0680j_5;
        int currentCompositeKeyHash2;
        a constructor2;
        Composer composerM5176constructorimpl2;
        Function2 setCompositeKeyHash2;
        Modifier modifierM1204backgroundbw27NRU;
        int pageCount;
        int i17;
        Modifier modifierM1204backgroundbw27NRU2;
        boolean z11;
        boolean zChanged;
        Object objRememberedValue2;
        final PagerState pagerState2;
        long j17;
        int i18;
        y.i(pagerState, "pagerState");
        Composer composerStartRestartGroup = composer.startRestartGroup(1850246713);
        int i19 = (i10 & 6) == 0 ? (composerStartRestartGroup.changed(pagerState) ? 4 : 2) | i10 : i10;
        int i20 = i11 & 2;
        if (i20 == 0) {
            if ((i10 & 48) == 0) {
                modifier2 = modifier;
                i19 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            i12 = i11 & 4;
            if (i12 != 0) {
                if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                    function2 = function1;
                    if (composerStartRestartGroup.changedInstance(function2)) {
                        i13 = 256;
                    } else {
                        i13 = 128;
                    }
                    i19 |= i13;
                }
                if ((i10 & 3072) == 0) {
                    if ((i11 & 8) == 0) {
                        jM5865copywmQWz5c$default = j10;
                        int i21 = composerStartRestartGroup.changed(jM5865copywmQWz5c$default) ? 2048 : 1024;
                        i19 |= i21;
                    } else {
                        jM5865copywmQWz5c$default = j10;
                    }
                    i19 |= i21;
                } else {
                    jM5865copywmQWz5c$default = j10;
                }
                if ((i10 & 24576) == 0) {
                    if ((i11 & 16) == 0) {
                        j12 = j11;
                        int i22 = composerStartRestartGroup.changed(j12) ? 16384 : 8192;
                        i19 |= i22;
                    } else {
                        j12 = j11;
                    }
                    i19 |= i22;
                } else {
                    j12 = j11;
                }
                i14 = i11 & 32;
                if (i14 != 0) {
                    i19 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((i10 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changed(f10)) {
                        i15 = 131072;
                    } else {
                        i15 = 65536;
                    }
                    i19 |= i15;
                }
                if ((i10 & 1572864) == 0) {
                    f13 = f11;
                    if ((i11 & 64) == 0 || !composerStartRestartGroup.changed(f13)) {
                        i18 = 524288;
                    } else {
                        i18 = 1048576;
                    }
                    i19 |= i18;
                } else {
                    f13 = f11;
                }
                if ((i10 & 12582912) != 0) {
                    i19 |= ((i11 & 128) == 0 || !composerStartRestartGroup.changed(f12)) ? 4194304 : 8388608;
                }
                if ((i10 & 100663296) != 0) {
                    i19 |= ((i11 & 256) == 0 || !composerStartRestartGroup.changed(shape)) ? 33554432 : 67108864;
                }
                if ((i19 & 38347923) != 38347922) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z10, i19 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    if ((i10 & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        if (i20 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i12 != 0) {
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new Function1() { // from class: n9.a
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return Integer.valueOf(Z17PagerIndicatorKt.Z17PagerIndicator_D_W6g9U$lambda$1$lambda$0(((Integer) obj).intValue()));
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            function2 = (Function1) objRememberedValue;
                        }
                        if ((i11 & 8) != 0) {
                            jM5865copywmQWz5c$default = Color.m5865copywmQWz5c$default(((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m5876unboximpl(), ((Number) composerStartRestartGroup.consume(ContentAlphaKt.getLocalContentAlpha())).floatValue(), 0.0f, 0.0f, 0.0f, 14, null);
                            i19 &= -7169;
                        }
                        j15 = jM5865copywmQWz5c$default;
                        if ((i11 & 16) != 0) {
                            jM5865copywmQWz5c$default2 = Color.m5865copywmQWz5c$default(j15, ContentAlpha.INSTANCE.getDisabled(composerStartRestartGroup, ContentAlpha.$stable), 0.0f, 0.0f, 0.0f, 14, null);
                            i19 &= -57345;
                        } else {
                            jM5865copywmQWz5c$default2 = j12;
                        }
                        if (i14 != 0) {
                            fM8823constructorimpl = Dp.m8823constructorimpl(8);
                        } else {
                            fM8823constructorimpl = f10;
                        }
                        if ((i11 & 64) != 0) {
                            i19 &= -3670017;
                            f13 = fM8823constructorimpl;
                        }
                        if ((i11 & 128) != 0) {
                            i16 = i19 & (-29360129);
                            f17 = fM8823constructorimpl;
                        } else {
                            i16 = i19;
                            f17 = f12;
                        }
                        if ((i11 & 256) != 0) {
                            i16 = (-234881025) & i16;
                            circleShape = RoundedCornerShapeKt.getCircleShape();
                        } else {
                            circleShape = shape;
                        }
                        j12 = jM5865copywmQWz5c$default2;
                        jM5865copywmQWz5c$default = j15;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i11 & 8) != 0) {
                            i19 &= -7169;
                        }
                        if ((i11 & 16) != 0) {
                            i19 &= -57345;
                        }
                        if ((i11 & 64) != 0) {
                            i19 &= -3670017;
                        }
                        if ((i11 & 128) != 0) {
                            i19 &= -29360129;
                        }
                        if ((i11 & 256) != 0) {
                            i19 &= -234881025;
                        }
                        fM8823constructorimpl = f10;
                        circleShape = shape;
                        i16 = i19;
                        f17 = f12;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1850246713, i16, -1, "cu.z17.views.pagerIndicator.Z17PagerIndicator (Z17PagerIndicator.kt:38)");
                    }
                    Alignment.Companion companion = Alignment.INSTANCE;
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion.getCenterStart(), false);
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier2);
                    ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                    modifier3 = modifier2;
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
                    j16 = jM5865copywmQWz5c$default;
                    Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, companion2.getSetMeasurePolicy());
                    Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
                    setCompositeKeyHash = companion2.getSetCompositeKeyHash();
                    if (composerM5176constructorimpl.getInserting() || !y.d(composerM5176constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion2.getSetModifier());
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                    iMo1339roundToPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo1339roundToPx0680j_4(fM8823constructorimpl);
                    iMo1339roundToPx0680j_5 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo1339roundToPx0680j_4(f17);
                    Arrangement.HorizontalOrVertical horizontalOrVerticalM1613spacedBy0680j_4 = Arrangement.INSTANCE.m1613spacedBy0680j_4(f17);
                    Alignment.Vertical centerVertically = companion.getCenterVertically();
                    Modifier.Companion companion3 = Modifier.INSTANCE;
                    MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(horizontalOrVerticalM1613spacedBy0680j_4, centerVertically, composerStartRestartGroup, 48);
                    currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    float f18 = f17;
                    Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion3);
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
                    Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyRowMeasurePolicy, companion2.getSetMeasurePolicy());
                    Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap2, companion2.getSetResolvedCompositionLocals());
                    setCompositeKeyHash2 = companion2.getSetCompositeKeyHash();
                    if (composerM5176constructorimpl2.getInserting() || !y.d(composerM5176constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                        composerM5176constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                        composerM5176constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                    }
                    Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier2, companion2.getSetModifier());
                    RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                    modifierM1204backgroundbw27NRU = BackgroundKt.m1204backgroundbw27NRU(SizeKt.m1771sizeVpY3zN4(companion3, fM8823constructorimpl, f13), j12, circleShape);
                    composerStartRestartGroup.startReplaceGroup(1893218582);
                    pageCount = pagerState.getPageCount();
                    for (i17 = 0; i17 < pageCount; i17++) {
                        BoxKt.Box(modifierM1204backgroundbw27NRU, composerStartRestartGroup, 0);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    composerStartRestartGroup.endNode();
                    modifierM1204backgroundbw27NRU2 = Modifier.INSTANCE;
                    if ((i16 & 896) == 256) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    zChanged = z11 | ((i16 & 14) == 4) | composerStartRestartGroup.changed(iMo1339roundToPx0680j_5) | composerStartRestartGroup.changed(iMo1339roundToPx0680j_4);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        pagerState2 = pagerState;
                        objRememberedValue2 = new Function1() { // from class: n9.b
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return Z17PagerIndicatorKt.Z17PagerIndicator_D_W6g9U$lambda$8$lambda$7$lambda$6(function2, pagerState2, iMo1339roundToPx0680j_5, iMo1339roundToPx0680j_4, (Density) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        pagerState2 = pagerState;
                    }
                    Modifier modifierM1771sizeVpY3zN4 = SizeKt.m1771sizeVpY3zN4(OffsetKt.offset(modifierM1204backgroundbw27NRU2, (Function1) objRememberedValue2), fM8823constructorimpl, f13);
                    if (pagerState2.getPageCount() > 0) {
                        j17 = j16;
                        modifierM1204backgroundbw27NRU2 = BackgroundKt.m1204backgroundbw27NRU(modifierM1204backgroundbw27NRU2, j17, circleShape);
                    } else {
                        j17 = j16;
                    }
                    BoxKt.Box(modifierM1771sizeVpY3zN4.then(modifierM1204backgroundbw27NRU2), composerStartRestartGroup, 0);
                    composerStartRestartGroup.endNode();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    shape2 = circleShape;
                    j13 = j17;
                    function3 = function2;
                    f14 = f18;
                    f15 = f13;
                    f16 = fM8823constructorimpl;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    function3 = function2;
                    j13 = jM5865copywmQWz5c$default;
                    f14 = f12;
                    shape2 = shape;
                    f15 = f13;
                    f16 = f10;
                }
                j14 = j12;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final Modifier modifier4 = modifier3;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: n9.c
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return Z17PagerIndicatorKt.Z17PagerIndicator_D_W6g9U$lambda$9(pagerState, modifier4, function3, j13, j14, f16, f15, f14, shape2, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i19 |= RendererCapabilities.DECODER_SUPPORT_MASK;
            function2 = function1;
            if ((i10 & 3072) == 0) {
                if ((i11 & 8) == 0) {
                    jM5865copywmQWz5c$default = j10;
                    if (composerStartRestartGroup.changed(jM5865copywmQWz5c$default)) {
                    }
                    i19 |= i21;
                } else {
                    jM5865copywmQWz5c$default = j10;
                }
                i19 |= i21;
            } else {
                jM5865copywmQWz5c$default = j10;
            }
            if ((i10 & 24576) == 0) {
                if ((i11 & 16) == 0) {
                    j12 = j11;
                    if (composerStartRestartGroup.changed(j12)) {
                    }
                    i19 |= i22;
                } else {
                    j12 = j11;
                }
                i19 |= i22;
            } else {
                j12 = j11;
            }
            i14 = i11 & 32;
            if (i14 != 0) {
                i19 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            } else if ((i10 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                if (composerStartRestartGroup.changed(f10)) {
                    i15 = 131072;
                } else {
                    i15 = 65536;
                }
                i19 |= i15;
            }
            if ((i10 & 1572864) == 0) {
                f13 = f11;
                if ((i11 & 64) == 0) {
                    i18 = 524288;
                } else {
                    i18 = 524288;
                }
                i19 |= i18;
            } else {
                f13 = f11;
            }
            if ((i10 & 12582912) != 0) {
                i19 |= ((i11 & 128) == 0 || !composerStartRestartGroup.changed(f12)) ? 4194304 : 8388608;
            }
            if ((i10 & 100663296) != 0) {
                i19 |= ((i11 & 256) == 0 || !composerStartRestartGroup.changed(shape)) ? 33554432 : 67108864;
            }
            if ((i19 & 38347923) != 38347922) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z10, i19 & 1)) {
                composerStartRestartGroup.startDefaults();
                if ((i10 & 1) != 0) {
                    if (i20 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i12 != 0) {
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new Function1() { // from class: n9.a
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return Integer.valueOf(Z17PagerIndicatorKt.Z17PagerIndicator_D_W6g9U$lambda$1$lambda$0(((Integer) obj).intValue()));
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        function2 = (Function1) objRememberedValue;
                    }
                    if ((i11 & 8) != 0) {
                        jM5865copywmQWz5c$default = Color.m5865copywmQWz5c$default(((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m5876unboximpl(), ((Number) composerStartRestartGroup.consume(ContentAlphaKt.getLocalContentAlpha())).floatValue(), 0.0f, 0.0f, 0.0f, 14, null);
                        i19 &= -7169;
                    }
                    j15 = jM5865copywmQWz5c$default;
                    if ((i11 & 16) != 0) {
                        jM5865copywmQWz5c$default2 = Color.m5865copywmQWz5c$default(j15, ContentAlpha.INSTANCE.getDisabled(composerStartRestartGroup, ContentAlpha.$stable), 0.0f, 0.0f, 0.0f, 14, null);
                        i19 &= -57345;
                    } else {
                        jM5865copywmQWz5c$default2 = j12;
                    }
                    if (i14 != 0) {
                        fM8823constructorimpl = Dp.m8823constructorimpl(8);
                    } else {
                        fM8823constructorimpl = f10;
                    }
                    if ((i11 & 64) != 0) {
                        i19 &= -3670017;
                        f13 = fM8823constructorimpl;
                    }
                    if ((i11 & 128) != 0) {
                        i16 = i19 & (-29360129);
                        f17 = fM8823constructorimpl;
                    } else {
                        i16 = i19;
                        f17 = f12;
                    }
                    if ((i11 & 256) != 0) {
                        i16 = (-234881025) & i16;
                        circleShape = RoundedCornerShapeKt.getCircleShape();
                    } else {
                        circleShape = shape;
                    }
                    j12 = jM5865copywmQWz5c$default2;
                    jM5865copywmQWz5c$default = j15;
                } else {
                    if (i20 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i12 != 0) {
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new Function1() { // from class: n9.a
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return Integer.valueOf(Z17PagerIndicatorKt.Z17PagerIndicator_D_W6g9U$lambda$1$lambda$0(((Integer) obj).intValue()));
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        function2 = (Function1) objRememberedValue;
                    }
                    if ((i11 & 8) != 0) {
                        jM5865copywmQWz5c$default = Color.m5865copywmQWz5c$default(((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m5876unboximpl(), ((Number) composerStartRestartGroup.consume(ContentAlphaKt.getLocalContentAlpha())).floatValue(), 0.0f, 0.0f, 0.0f, 14, null);
                        i19 &= -7169;
                    }
                    j15 = jM5865copywmQWz5c$default;
                    if ((i11 & 16) != 0) {
                        jM5865copywmQWz5c$default2 = Color.m5865copywmQWz5c$default(j15, ContentAlpha.INSTANCE.getDisabled(composerStartRestartGroup, ContentAlpha.$stable), 0.0f, 0.0f, 0.0f, 14, null);
                        i19 &= -57345;
                    } else {
                        jM5865copywmQWz5c$default2 = j12;
                    }
                    if (i14 != 0) {
                        fM8823constructorimpl = Dp.m8823constructorimpl(8);
                    } else {
                        fM8823constructorimpl = f10;
                    }
                    if ((i11 & 64) != 0) {
                        i19 &= -3670017;
                        f13 = fM8823constructorimpl;
                    }
                    if ((i11 & 128) != 0) {
                        i16 = i19 & (-29360129);
                        f17 = fM8823constructorimpl;
                    } else {
                        i16 = i19;
                        f17 = f12;
                    }
                    if ((i11 & 256) != 0) {
                        i16 = (-234881025) & i16;
                        circleShape = RoundedCornerShapeKt.getCircleShape();
                    } else {
                        circleShape = shape;
                    }
                    j12 = jM5865copywmQWz5c$default2;
                    jM5865copywmQWz5c$default = j15;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1850246713, i16, -1, "cu.z17.views.pagerIndicator.Z17PagerIndicator (Z17PagerIndicator.kt:38)");
                }
                Alignment.Companion companion4 = Alignment.INSTANCE;
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(companion4.getCenterStart(), false);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier2);
                ComposeUiNode.Companion companion5 = ComposeUiNode.INSTANCE;
                modifier3 = modifier2;
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
                j16 = jM5865copywmQWz5c$default;
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
                iMo1339roundToPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo1339roundToPx0680j_4(fM8823constructorimpl);
                iMo1339roundToPx0680j_5 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo1339roundToPx0680j_4(f17);
                Arrangement.HorizontalOrVertical horizontalOrVerticalM1613spacedBy0680j_5 = Arrangement.INSTANCE.m1613spacedBy0680j_4(f17);
                Alignment.Vertical centerVertically2 = companion4.getCenterVertically();
                Modifier.Companion companion6 = Modifier.INSTANCE;
                MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(horizontalOrVerticalM1613spacedBy0680j_5, centerVertically2, composerStartRestartGroup, 48);
                currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                float f19 = f17;
                Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion6);
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
                Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyRowMeasurePolicy2, companion5.getSetMeasurePolicy());
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
                RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
                modifierM1204backgroundbw27NRU = BackgroundKt.m1204backgroundbw27NRU(SizeKt.m1771sizeVpY3zN4(companion6, fM8823constructorimpl, f13), j12, circleShape);
                composerStartRestartGroup.startReplaceGroup(1893218582);
                pageCount = pagerState.getPageCount();
                while (i17 < pageCount) {
                    BoxKt.Box(modifierM1204backgroundbw27NRU, composerStartRestartGroup, 0);
                }
                composerStartRestartGroup.endReplaceGroup();
                composerStartRestartGroup.endNode();
                modifierM1204backgroundbw27NRU2 = Modifier.INSTANCE;
                if ((i16 & 896) == 256) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                zChanged = z11 | ((i16 & 14) == 4) | composerStartRestartGroup.changed(iMo1339roundToPx0680j_5) | composerStartRestartGroup.changed(iMo1339roundToPx0680j_4);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    pagerState2 = pagerState;
                    objRememberedValue2 = new Function1() { // from class: n9.b
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return Z17PagerIndicatorKt.Z17PagerIndicator_D_W6g9U$lambda$8$lambda$7$lambda$6(function2, pagerState2, iMo1339roundToPx0680j_5, iMo1339roundToPx0680j_4, (Density) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    pagerState2 = pagerState;
                    objRememberedValue2 = new Function1() { // from class: n9.b
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return Z17PagerIndicatorKt.Z17PagerIndicator_D_W6g9U$lambda$8$lambda$7$lambda$6(function2, pagerState2, iMo1339roundToPx0680j_5, iMo1339roundToPx0680j_4, (Density) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                Modifier modifierM1771sizeVpY3zN5 = SizeKt.m1771sizeVpY3zN4(OffsetKt.offset(modifierM1204backgroundbw27NRU2, (Function1) objRememberedValue2), fM8823constructorimpl, f13);
                if (pagerState2.getPageCount() > 0) {
                    j17 = j16;
                    modifierM1204backgroundbw27NRU2 = BackgroundKt.m1204backgroundbw27NRU(modifierM1204backgroundbw27NRU2, j17, circleShape);
                } else {
                    j17 = j16;
                }
                BoxKt.Box(modifierM1771sizeVpY3zN5.then(modifierM1204backgroundbw27NRU2), composerStartRestartGroup, 0);
                composerStartRestartGroup.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                shape2 = circleShape;
                j13 = j17;
                function3 = function2;
                f14 = f19;
                f15 = f13;
                f16 = fM8823constructorimpl;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                function3 = function2;
                j13 = jM5865copywmQWz5c$default;
                f14 = f12;
                shape2 = shape;
                f15 = f13;
                f16 = f10;
            }
            j14 = j12;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final Modifier modifier5 = modifier3;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: n9.c
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return Z17PagerIndicatorKt.Z17PagerIndicator_D_W6g9U$lambda$9(pagerState, modifier5, function3, j13, j14, f16, f15, f14, shape2, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i19 |= 48;
        modifier2 = modifier;
        i12 = i11 & 4;
        if (i12 != 0) {
            if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                function2 = function1;
                if (composerStartRestartGroup.changedInstance(function2)) {
                    i13 = 256;
                } else {
                    i13 = 128;
                }
                i19 |= i13;
            }
            if ((i10 & 3072) == 0) {
                if ((i11 & 8) == 0) {
                    jM5865copywmQWz5c$default = j10;
                    if (composerStartRestartGroup.changed(jM5865copywmQWz5c$default)) {
                    }
                    i19 |= i21;
                } else {
                    jM5865copywmQWz5c$default = j10;
                }
                i19 |= i21;
            } else {
                jM5865copywmQWz5c$default = j10;
            }
            if ((i10 & 24576) == 0) {
                if ((i11 & 16) == 0) {
                    j12 = j11;
                    if (composerStartRestartGroup.changed(j12)) {
                    }
                    i19 |= i22;
                } else {
                    j12 = j11;
                }
                i19 |= i22;
            } else {
                j12 = j11;
            }
            i14 = i11 & 32;
            if (i14 != 0) {
                i19 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            } else if ((i10 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                if (composerStartRestartGroup.changed(f10)) {
                    i15 = 131072;
                } else {
                    i15 = 65536;
                }
                i19 |= i15;
            }
            if ((i10 & 1572864) == 0) {
                f13 = f11;
                if ((i11 & 64) == 0) {
                    i18 = 524288;
                } else {
                    i18 = 524288;
                }
                i19 |= i18;
            } else {
                f13 = f11;
            }
            if ((i10 & 12582912) != 0) {
                i19 |= ((i11 & 128) == 0 || !composerStartRestartGroup.changed(f12)) ? 4194304 : 8388608;
            }
            if ((i10 & 100663296) != 0) {
                i19 |= ((i11 & 256) == 0 || !composerStartRestartGroup.changed(shape)) ? 33554432 : 67108864;
            }
            if ((i19 & 38347923) != 38347922) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z10, i19 & 1)) {
                composerStartRestartGroup.startDefaults();
                if ((i10 & 1) != 0) {
                    if (i20 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i12 != 0) {
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new Function1() { // from class: n9.a
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return Integer.valueOf(Z17PagerIndicatorKt.Z17PagerIndicator_D_W6g9U$lambda$1$lambda$0(((Integer) obj).intValue()));
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        function2 = (Function1) objRememberedValue;
                    }
                    if ((i11 & 8) != 0) {
                        jM5865copywmQWz5c$default = Color.m5865copywmQWz5c$default(((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m5876unboximpl(), ((Number) composerStartRestartGroup.consume(ContentAlphaKt.getLocalContentAlpha())).floatValue(), 0.0f, 0.0f, 0.0f, 14, null);
                        i19 &= -7169;
                    }
                    j15 = jM5865copywmQWz5c$default;
                    if ((i11 & 16) != 0) {
                        jM5865copywmQWz5c$default2 = Color.m5865copywmQWz5c$default(j15, ContentAlpha.INSTANCE.getDisabled(composerStartRestartGroup, ContentAlpha.$stable), 0.0f, 0.0f, 0.0f, 14, null);
                        i19 &= -57345;
                    } else {
                        jM5865copywmQWz5c$default2 = j12;
                    }
                    if (i14 != 0) {
                        fM8823constructorimpl = Dp.m8823constructorimpl(8);
                    } else {
                        fM8823constructorimpl = f10;
                    }
                    if ((i11 & 64) != 0) {
                        i19 &= -3670017;
                        f13 = fM8823constructorimpl;
                    }
                    if ((i11 & 128) != 0) {
                        i16 = i19 & (-29360129);
                        f17 = fM8823constructorimpl;
                    } else {
                        i16 = i19;
                        f17 = f12;
                    }
                    if ((i11 & 256) != 0) {
                        i16 = (-234881025) & i16;
                        circleShape = RoundedCornerShapeKt.getCircleShape();
                    } else {
                        circleShape = shape;
                    }
                    j12 = jM5865copywmQWz5c$default2;
                    jM5865copywmQWz5c$default = j15;
                } else {
                    if (i20 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i12 != 0) {
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new Function1() { // from class: n9.a
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return Integer.valueOf(Z17PagerIndicatorKt.Z17PagerIndicator_D_W6g9U$lambda$1$lambda$0(((Integer) obj).intValue()));
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        function2 = (Function1) objRememberedValue;
                    }
                    if ((i11 & 8) != 0) {
                        jM5865copywmQWz5c$default = Color.m5865copywmQWz5c$default(((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m5876unboximpl(), ((Number) composerStartRestartGroup.consume(ContentAlphaKt.getLocalContentAlpha())).floatValue(), 0.0f, 0.0f, 0.0f, 14, null);
                        i19 &= -7169;
                    }
                    j15 = jM5865copywmQWz5c$default;
                    if ((i11 & 16) != 0) {
                        jM5865copywmQWz5c$default2 = Color.m5865copywmQWz5c$default(j15, ContentAlpha.INSTANCE.getDisabled(composerStartRestartGroup, ContentAlpha.$stable), 0.0f, 0.0f, 0.0f, 14, null);
                        i19 &= -57345;
                    } else {
                        jM5865copywmQWz5c$default2 = j12;
                    }
                    if (i14 != 0) {
                        fM8823constructorimpl = Dp.m8823constructorimpl(8);
                    } else {
                        fM8823constructorimpl = f10;
                    }
                    if ((i11 & 64) != 0) {
                        i19 &= -3670017;
                        f13 = fM8823constructorimpl;
                    }
                    if ((i11 & 128) != 0) {
                        i16 = i19 & (-29360129);
                        f17 = fM8823constructorimpl;
                    } else {
                        i16 = i19;
                        f17 = f12;
                    }
                    if ((i11 & 256) != 0) {
                        i16 = (-234881025) & i16;
                        circleShape = RoundedCornerShapeKt.getCircleShape();
                    } else {
                        circleShape = shape;
                    }
                    j12 = jM5865copywmQWz5c$default2;
                    jM5865copywmQWz5c$default = j15;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1850246713, i16, -1, "cu.z17.views.pagerIndicator.Z17PagerIndicator (Z17PagerIndicator.kt:38)");
                }
                Alignment.Companion companion7 = Alignment.INSTANCE;
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(companion7.getCenterStart(), false);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap5 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier5 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier2);
                ComposeUiNode.Companion companion8 = ComposeUiNode.INSTANCE;
                modifier3 = modifier2;
                constructor = companion8.getConstructor();
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
                j16 = jM5865copywmQWz5c$default;
                Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy3, companion8.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap5, companion8.getSetResolvedCompositionLocals());
                setCompositeKeyHash = companion8.getSetCompositeKeyHash();
                if (composerM5176constructorimpl.getInserting()) {
                    composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                } else {
                    composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier5, companion8.getSetModifier());
                BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
                iMo1339roundToPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo1339roundToPx0680j_4(fM8823constructorimpl);
                iMo1339roundToPx0680j_5 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo1339roundToPx0680j_4(f17);
                Arrangement.HorizontalOrVertical horizontalOrVerticalM1613spacedBy0680j_6 = Arrangement.INSTANCE.m1613spacedBy0680j_4(f17);
                Alignment.Vertical centerVertically3 = companion7.getCenterVertically();
                Modifier.Companion companion9 = Modifier.INSTANCE;
                MeasurePolicy measurePolicyRowMeasurePolicy3 = RowKt.rowMeasurePolicy(horizontalOrVerticalM1613spacedBy0680j_6, centerVertically3, composerStartRestartGroup, 48);
                currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap6 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                float f110 = f17;
                Modifier modifierMaterializeModifier6 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion9);
                constructor2 = companion8.getConstructor();
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
                Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyRowMeasurePolicy3, companion8.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap6, companion8.getSetResolvedCompositionLocals());
                setCompositeKeyHash2 = companion8.getSetCompositeKeyHash();
                if (composerM5176constructorimpl2.getInserting()) {
                    composerM5176constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    composerM5176constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                } else {
                    composerM5176constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    composerM5176constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                }
                Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier6, companion8.getSetModifier());
                RowScopeInstance rowScopeInstance3 = RowScopeInstance.INSTANCE;
                modifierM1204backgroundbw27NRU = BackgroundKt.m1204backgroundbw27NRU(SizeKt.m1771sizeVpY3zN4(companion9, fM8823constructorimpl, f13), j12, circleShape);
                composerStartRestartGroup.startReplaceGroup(1893218582);
                pageCount = pagerState.getPageCount();
                while (i17 < pageCount) {
                    BoxKt.Box(modifierM1204backgroundbw27NRU, composerStartRestartGroup, 0);
                }
                composerStartRestartGroup.endReplaceGroup();
                composerStartRestartGroup.endNode();
                modifierM1204backgroundbw27NRU2 = Modifier.INSTANCE;
                if ((i16 & 896) == 256) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                zChanged = z11 | ((i16 & 14) == 4) | composerStartRestartGroup.changed(iMo1339roundToPx0680j_5) | composerStartRestartGroup.changed(iMo1339roundToPx0680j_4);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    pagerState2 = pagerState;
                    objRememberedValue2 = new Function1() { // from class: n9.b
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return Z17PagerIndicatorKt.Z17PagerIndicator_D_W6g9U$lambda$8$lambda$7$lambda$6(function2, pagerState2, iMo1339roundToPx0680j_5, iMo1339roundToPx0680j_4, (Density) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    pagerState2 = pagerState;
                    objRememberedValue2 = new Function1() { // from class: n9.b
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return Z17PagerIndicatorKt.Z17PagerIndicator_D_W6g9U$lambda$8$lambda$7$lambda$6(function2, pagerState2, iMo1339roundToPx0680j_5, iMo1339roundToPx0680j_4, (Density) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                Modifier modifierM1771sizeVpY3zN6 = SizeKt.m1771sizeVpY3zN4(OffsetKt.offset(modifierM1204backgroundbw27NRU2, (Function1) objRememberedValue2), fM8823constructorimpl, f13);
                if (pagerState2.getPageCount() > 0) {
                    j17 = j16;
                    modifierM1204backgroundbw27NRU2 = BackgroundKt.m1204backgroundbw27NRU(modifierM1204backgroundbw27NRU2, j17, circleShape);
                } else {
                    j17 = j16;
                }
                BoxKt.Box(modifierM1771sizeVpY3zN6.then(modifierM1204backgroundbw27NRU2), composerStartRestartGroup, 0);
                composerStartRestartGroup.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                shape2 = circleShape;
                j13 = j17;
                function3 = function2;
                f14 = f110;
                f15 = f13;
                f16 = fM8823constructorimpl;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                function3 = function2;
                j13 = jM5865copywmQWz5c$default;
                f14 = f12;
                shape2 = shape;
                f15 = f13;
                f16 = f10;
            }
            j14 = j12;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final Modifier modifier6 = modifier3;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: n9.c
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return Z17PagerIndicatorKt.Z17PagerIndicator_D_W6g9U$lambda$9(pagerState, modifier6, function3, j13, j14, f16, f15, f14, shape2, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i19 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        function2 = function1;
        if ((i10 & 3072) == 0) {
            if ((i11 & 8) == 0) {
                jM5865copywmQWz5c$default = j10;
                if (composerStartRestartGroup.changed(jM5865copywmQWz5c$default)) {
                }
                i19 |= i21;
            } else {
                jM5865copywmQWz5c$default = j10;
            }
            i19 |= i21;
        } else {
            jM5865copywmQWz5c$default = j10;
        }
        if ((i10 & 24576) == 0) {
            if ((i11 & 16) == 0) {
                j12 = j11;
                if (composerStartRestartGroup.changed(j12)) {
                }
                i19 |= i22;
            } else {
                j12 = j11;
            }
            i19 |= i22;
        } else {
            j12 = j11;
        }
        i14 = i11 & 32;
        if (i14 != 0) {
            i19 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        } else if ((i10 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            if (composerStartRestartGroup.changed(f10)) {
                i15 = 131072;
            } else {
                i15 = 65536;
            }
            i19 |= i15;
        }
        if ((i10 & 1572864) == 0) {
            f13 = f11;
            if ((i11 & 64) == 0) {
                i18 = 524288;
            } else {
                i18 = 524288;
            }
            i19 |= i18;
        } else {
            f13 = f11;
        }
        if ((i10 & 12582912) != 0) {
            i19 |= ((i11 & 128) == 0 || !composerStartRestartGroup.changed(f12)) ? 4194304 : 8388608;
        }
        if ((i10 & 100663296) != 0) {
            i19 |= ((i11 & 256) == 0 || !composerStartRestartGroup.changed(shape)) ? 33554432 : 67108864;
        }
        if ((i19 & 38347923) != 38347922) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z10, i19 & 1)) {
            composerStartRestartGroup.startDefaults();
            if ((i10 & 1) != 0) {
                if (i20 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i12 != 0) {
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function1() { // from class: n9.a
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return Integer.valueOf(Z17PagerIndicatorKt.Z17PagerIndicator_D_W6g9U$lambda$1$lambda$0(((Integer) obj).intValue()));
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    function2 = (Function1) objRememberedValue;
                }
                if ((i11 & 8) != 0) {
                    jM5865copywmQWz5c$default = Color.m5865copywmQWz5c$default(((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m5876unboximpl(), ((Number) composerStartRestartGroup.consume(ContentAlphaKt.getLocalContentAlpha())).floatValue(), 0.0f, 0.0f, 0.0f, 14, null);
                    i19 &= -7169;
                }
                j15 = jM5865copywmQWz5c$default;
                if ((i11 & 16) != 0) {
                    jM5865copywmQWz5c$default2 = Color.m5865copywmQWz5c$default(j15, ContentAlpha.INSTANCE.getDisabled(composerStartRestartGroup, ContentAlpha.$stable), 0.0f, 0.0f, 0.0f, 14, null);
                    i19 &= -57345;
                } else {
                    jM5865copywmQWz5c$default2 = j12;
                }
                if (i14 != 0) {
                    fM8823constructorimpl = Dp.m8823constructorimpl(8);
                } else {
                    fM8823constructorimpl = f10;
                }
                if ((i11 & 64) != 0) {
                    i19 &= -3670017;
                    f13 = fM8823constructorimpl;
                }
                if ((i11 & 128) != 0) {
                    i16 = i19 & (-29360129);
                    f17 = fM8823constructorimpl;
                } else {
                    i16 = i19;
                    f17 = f12;
                }
                if ((i11 & 256) != 0) {
                    i16 = (-234881025) & i16;
                    circleShape = RoundedCornerShapeKt.getCircleShape();
                } else {
                    circleShape = shape;
                }
                j12 = jM5865copywmQWz5c$default2;
                jM5865copywmQWz5c$default = j15;
            } else {
                if (i20 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i12 != 0) {
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function1() { // from class: n9.a
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return Integer.valueOf(Z17PagerIndicatorKt.Z17PagerIndicator_D_W6g9U$lambda$1$lambda$0(((Integer) obj).intValue()));
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    function2 = (Function1) objRememberedValue;
                }
                if ((i11 & 8) != 0) {
                    jM5865copywmQWz5c$default = Color.m5865copywmQWz5c$default(((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m5876unboximpl(), ((Number) composerStartRestartGroup.consume(ContentAlphaKt.getLocalContentAlpha())).floatValue(), 0.0f, 0.0f, 0.0f, 14, null);
                    i19 &= -7169;
                }
                j15 = jM5865copywmQWz5c$default;
                if ((i11 & 16) != 0) {
                    jM5865copywmQWz5c$default2 = Color.m5865copywmQWz5c$default(j15, ContentAlpha.INSTANCE.getDisabled(composerStartRestartGroup, ContentAlpha.$stable), 0.0f, 0.0f, 0.0f, 14, null);
                    i19 &= -57345;
                } else {
                    jM5865copywmQWz5c$default2 = j12;
                }
                if (i14 != 0) {
                    fM8823constructorimpl = Dp.m8823constructorimpl(8);
                } else {
                    fM8823constructorimpl = f10;
                }
                if ((i11 & 64) != 0) {
                    i19 &= -3670017;
                    f13 = fM8823constructorimpl;
                }
                if ((i11 & 128) != 0) {
                    i16 = i19 & (-29360129);
                    f17 = fM8823constructorimpl;
                } else {
                    i16 = i19;
                    f17 = f12;
                }
                if ((i11 & 256) != 0) {
                    i16 = (-234881025) & i16;
                    circleShape = RoundedCornerShapeKt.getCircleShape();
                } else {
                    circleShape = shape;
                }
                j12 = jM5865copywmQWz5c$default2;
                jM5865copywmQWz5c$default = j15;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1850246713, i16, -1, "cu.z17.views.pagerIndicator.Z17PagerIndicator (Z17PagerIndicator.kt:38)");
            }
            Alignment.Companion companion10 = Alignment.INSTANCE;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy4 = BoxKt.maybeCachedBoxMeasurePolicy(companion10.getCenterStart(), false);
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap7 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier7 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier2);
            ComposeUiNode.Companion companion11 = ComposeUiNode.INSTANCE;
            modifier3 = modifier2;
            constructor = companion11.getConstructor();
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
            j16 = jM5865copywmQWz5c$default;
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy4, companion11.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap7, companion11.getSetResolvedCompositionLocals());
            setCompositeKeyHash = companion11.getSetCompositeKeyHash();
            if (composerM5176constructorimpl.getInserting()) {
                composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            } else {
                composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier7, companion11.getSetModifier());
            BoxScopeInstance boxScopeInstance4 = BoxScopeInstance.INSTANCE;
            iMo1339roundToPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo1339roundToPx0680j_4(fM8823constructorimpl);
            iMo1339roundToPx0680j_5 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo1339roundToPx0680j_4(f17);
            Arrangement.HorizontalOrVertical horizontalOrVerticalM1613spacedBy0680j_7 = Arrangement.INSTANCE.m1613spacedBy0680j_4(f17);
            Alignment.Vertical centerVertically4 = companion10.getCenterVertically();
            Modifier.Companion companion12 = Modifier.INSTANCE;
            MeasurePolicy measurePolicyRowMeasurePolicy4 = RowKt.rowMeasurePolicy(horizontalOrVerticalM1613spacedBy0680j_7, centerVertically4, composerStartRestartGroup, 48);
            currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap8 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            float f111 = f17;
            Modifier modifierMaterializeModifier8 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion12);
            constructor2 = companion11.getConstructor();
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
            Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyRowMeasurePolicy4, companion11.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap8, companion11.getSetResolvedCompositionLocals());
            setCompositeKeyHash2 = companion11.getSetCompositeKeyHash();
            if (composerM5176constructorimpl2.getInserting()) {
                composerM5176constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                composerM5176constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            } else {
                composerM5176constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                composerM5176constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier8, companion11.getSetModifier());
            RowScopeInstance rowScopeInstance4 = RowScopeInstance.INSTANCE;
            modifierM1204backgroundbw27NRU = BackgroundKt.m1204backgroundbw27NRU(SizeKt.m1771sizeVpY3zN4(companion12, fM8823constructorimpl, f13), j12, circleShape);
            composerStartRestartGroup.startReplaceGroup(1893218582);
            pageCount = pagerState.getPageCount();
            while (i17 < pageCount) {
                BoxKt.Box(modifierM1204backgroundbw27NRU, composerStartRestartGroup, 0);
            }
            composerStartRestartGroup.endReplaceGroup();
            composerStartRestartGroup.endNode();
            modifierM1204backgroundbw27NRU2 = Modifier.INSTANCE;
            if ((i16 & 896) == 256) {
                z11 = true;
            } else {
                z11 = false;
            }
            zChanged = z11 | ((i16 & 14) == 4) | composerStartRestartGroup.changed(iMo1339roundToPx0680j_5) | composerStartRestartGroup.changed(iMo1339roundToPx0680j_4);
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChanged) {
                pagerState2 = pagerState;
                objRememberedValue2 = new Function1() { // from class: n9.b
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Z17PagerIndicatorKt.Z17PagerIndicator_D_W6g9U$lambda$8$lambda$7$lambda$6(function2, pagerState2, iMo1339roundToPx0680j_5, iMo1339roundToPx0680j_4, (Density) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            } else {
                pagerState2 = pagerState;
                objRememberedValue2 = new Function1() { // from class: n9.b
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Z17PagerIndicatorKt.Z17PagerIndicator_D_W6g9U$lambda$8$lambda$7$lambda$6(function2, pagerState2, iMo1339roundToPx0680j_5, iMo1339roundToPx0680j_4, (Density) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            Modifier modifierM1771sizeVpY3zN7 = SizeKt.m1771sizeVpY3zN4(OffsetKt.offset(modifierM1204backgroundbw27NRU2, (Function1) objRememberedValue2), fM8823constructorimpl, f13);
            if (pagerState2.getPageCount() > 0) {
                j17 = j16;
                modifierM1204backgroundbw27NRU2 = BackgroundKt.m1204backgroundbw27NRU(modifierM1204backgroundbw27NRU2, j17, circleShape);
            } else {
                j17 = j16;
            }
            BoxKt.Box(modifierM1771sizeVpY3zN7.then(modifierM1204backgroundbw27NRU2), composerStartRestartGroup, 0);
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            shape2 = circleShape;
            j13 = j17;
            function3 = function2;
            f14 = f111;
            f15 = f13;
            f16 = fM8823constructorimpl;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
            function3 = function2;
            j13 = jM5865copywmQWz5c$default;
            f14 = f12;
            shape2 = shape;
            f15 = f13;
            f16 = f10;
        }
        j14 = j12;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier7 = modifier3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: n9.c
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return Z17PagerIndicatorKt.Z17PagerIndicator_D_W6g9U$lambda$9(pagerState, modifier7, function3, j13, j14, f16, f15, f14, shape2, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IntOffset Z17PagerIndicator_D_W6g9U$lambda$8$lambda$7$lambda$6(Function1 function1, PagerState pagerState, int i10, int i11, Density offset) {
        y.i(offset, "$this$offset");
        int iIntValue = ((Number) function1.invoke(Integer.valueOf(pagerState.getCurrentPage()))).intValue();
        float currentPageOffsetFraction = pagerState.getCurrentPageOffsetFraction();
        return IntOffset.m8938boximpl(IntOffset.m8941constructorimpl((((long) ((int) ((i10 + i11) * k.n(((((Number) function1.invoke(Integer.valueOf(pagerState.getCurrentPage() + ((int) Math.signum(currentPageOffsetFraction))))).intValue() - iIntValue) * Math.abs(currentPageOffsetFraction)) + iIntValue, 0.0f, k.e(pagerState.getPageCount() - 1, 0))))) << 32) | (((long) 0) & MuxerUtil.UNSIGNED_INT_MAX_VALUE)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 Z17PagerIndicator_D_W6g9U$lambda$9(PagerState pagerState, Modifier modifier, Function1 function1, long j10, long j11, float f10, float f11, float f12, Shape shape, int i10, int i11, Composer composer, int i12) {
        m10266Z17PagerIndicatorD_W6g9U(pagerState, modifier, function1, j10, j11, f10, f11, f12, shape, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int Z17PagerIndicator_D_W6g9U$lambda$1$lambda$0(int i10) {
        return i10;
    }
}
