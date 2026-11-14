package cu.z17.views.imageEditor.sections.cropper.components.widget;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.AspectRatioKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.TextKt;
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
import androidx.compose.ui.draw.CacheDrawScope;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.OutlineKt;
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
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.media3.muxer.MuxerUtil;
import cu.z17.views.imageEditor.sections.cropper.components.model.CropAspectRatio;
import defpackage.r;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.y;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aQ\u0010\u000e\u001a\u00020\n2\b\b\u0002\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u001c\b\u0002\u0010\u000b\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007H\u0007¢\u0006\u0004\b\f\u0010\r¨\u0006\u000f"}, d2 = {"Landroidx/compose/ui/Modifier;", "modifier", "Landroidx/compose/ui/graphics/Color;", "contentColor", "color", "Lcu/z17/views/imageEditor/sections/cropper/components/model/CropAspectRatio;", "cropAspectRatio", "Lkotlin/Function1;", "", "", "Lua/k0;", "onClick", "AspectRatioSelectionCard-DTcfvLk", "(Landroidx/compose/ui/Modifier;JJLcu/z17/views/imageEditor/sections/cropper/components/model/CropAspectRatio;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "AspectRatioSelectionCard", "views_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class AspectRatioSlectionCardKt {
    /* JADX WARN: Code duplicated, block: B:100:0x01e8  */
    /* JADX WARN: Code duplicated, block: B:103:0x0235  */
    /* JADX WARN: Code duplicated, block: B:104:0x0237  */
    /* JADX WARN: Code duplicated, block: B:107:0x024c  */
    /* JADX WARN: Code duplicated, block: B:108:0x024f  */
    /* JADX WARN: Code duplicated, block: B:113:0x0261  */
    /* JADX WARN: Code duplicated, block: B:118:0x02a8  */
    /* JADX WARN: Code duplicated, block: B:121:0x02b4  */
    /* JADX WARN: Code duplicated, block: B:122:0x02b8  */
    /* JADX WARN: Code duplicated, block: B:127:0x02e5  */
    /* JADX WARN: Code duplicated, block: B:130:0x0327  */
    /* JADX WARN: Code duplicated, block: B:132:0x0366  */
    /* JADX WARN: Code duplicated, block: B:135:0x0379  */
    /* JADX WARN: Code duplicated, block: B:137:0x0382  */
    /* JADX WARN: Code duplicated, block: B:140:0x038f  */
    /* JADX WARN: Code duplicated, block: B:142:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:51:0x008f  */
    /* JADX WARN: Code duplicated, block: B:52:0x0091  */
    /* JADX WARN: Code duplicated, block: B:55:0x009a  */
    /* JADX WARN: Code duplicated, block: B:65:0x00b7 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:66:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:67:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:70:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:73:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:76:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:79:0x0126  */
    /* JADX WARN: Code duplicated, block: B:82:0x0132  */
    /* JADX WARN: Code duplicated, block: B:83:0x0136  */
    /* JADX WARN: Code duplicated, block: B:88:0x0163  */
    /* JADX WARN: Code duplicated, block: B:91:0x01a9  */
    /* JADX WARN: Code duplicated, block: B:94:0x01b5  */
    /* JADX WARN: Code duplicated, block: B:95:0x01b9  */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v3, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* JADX INFO: renamed from: AspectRatioSelectionCard-DTcfvLk, reason: not valid java name */
    public static final void m10237AspectRatioSelectionCardDTcfvLk(Modifier modifier, long j10, final long j11, final CropAspectRatio cropAspectRatio, Function1 function1, Composer composer, final int i10, final int i11) {
        Modifier modifier2;
        int i12;
        long surface;
        Function1 function2;
        boolean z10;
        Composer composer2;
        final Modifier modifier3;
        final long j12;
        final Function1 function3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier modifier4;
        Modifier modifier5;
        long j13;
        int i13;
        int currentCompositeKeyHash;
        lb.a constructor;
        Composer composerM5176constructorimpl;
        Function2 setCompositeKeyHash;
        int currentCompositeKeyHash2;
        lb.a constructor2;
        Composer composerM5176constructorimpl2;
        Function2 setCompositeKeyHash2;
        final Density density;
        final LayoutDirection layoutDirection;
        boolean z11;
        int i14;
        boolean z12;
        boolean z13;
        Object objRememberedValue;
        ?? r10;
        int currentCompositeKeyHash3;
        lb.a constructor3;
        Composer composerM5176constructorimpl3;
        Function2 setCompositeKeyHash3;
        y.i(cropAspectRatio, "cropAspectRatio");
        Composer composerStartRestartGroup = composer.startRestartGroup(1460564537);
        int i15 = i11 & 1;
        if (i15 != 0) {
            i12 = i10 | 6;
            modifier2 = modifier;
        } else if ((i10 & 6) == 0) {
            modifier2 = modifier;
            i12 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i10;
        } else {
            modifier2 = modifier;
            i12 = i10;
        }
        if ((i10 & 48) == 0) {
            if ((i11 & 2) == 0) {
                surface = j10;
                int i16 = composerStartRestartGroup.changed(surface) ? 32 : 16;
                i12 |= i16;
            } else {
                surface = j10;
            }
            i12 |= i16;
        } else {
            surface = j10;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i12 |= composerStartRestartGroup.changed(j11) ? 256 : 128;
        }
        if ((i10 & 3072) == 0) {
            i12 |= composerStartRestartGroup.changed(cropAspectRatio) ? 2048 : 1024;
        }
        int i17 = i11 & 16;
        if (i17 == 0) {
            if ((i10 & 24576) == 0) {
                function2 = function1;
                i12 |= composerStartRestartGroup.changedInstance(function2) ? 16384 : 8192;
            }
            if ((i12 & 9363) != 9362) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z10, i12 & 1)) {
                composerStartRestartGroup.startDefaults();
                if ((i10 & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    if (i15 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if ((i11 & 2) != 0) {
                        i12 &= -113;
                        surface = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getSurface();
                    }
                    modifier5 = modifier4;
                    j13 = surface;
                    if (i17 != 0) {
                        function2 = null;
                    }
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    if ((i11 & 2) != 0) {
                        i12 &= -113;
                    }
                    modifier5 = modifier2;
                    j13 = surface;
                }
                i13 = i12;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1460564537, i13, -1, "cu.z17.views.imageEditor.sections.cropper.components.widget.AspectRatioSelectionCard (AspectRatioSlectionCard.kt:27)");
                }
                Modifier modifier6 = modifier5;
                long j14 = j13;
                float f10 = 4;
                Modifier modifierM1725padding3ABfNKs = PaddingKt.m1725padding3ABfNKs(BackgroundKt.m1205backgroundbw27NRU$default(modifier5, j13, null, 2, null), Dp.m8823constructorimpl(f10));
                Alignment.Companion companion = Alignment.INSTANCE;
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion.getTopStart(), false);
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
                Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, companion2.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
                setCompositeKeyHash = companion2.getSetCompositeKeyHash();
                if (composerM5176constructorimpl.getInserting() || !y.d(composerM5176constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion2.getSetModifier());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                Alignment.Horizontal centerHorizontally = companion.getCenterHorizontally();
                Modifier.Companion companion3 = Modifier.INSTANCE;
                MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), centerHorizontally, composerStartRestartGroup, 48);
                currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
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
                Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyColumnMeasurePolicy, companion2.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap2, companion2.getSetResolvedCompositionLocals());
                setCompositeKeyHash2 = companion2.getSetCompositeKeyHash();
                if (composerM5176constructorimpl2.getInserting() || !y.d(composerM5176constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                    composerM5176constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    composerM5176constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                }
                Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier2, companion2.getSetModifier());
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                Modifier modifierAspectRatio$default = AspectRatioKt.aspectRatio$default(PaddingKt.m1725padding3ABfNKs(SizeKt.fillMaxWidth$default(companion3, 0.0f, 1, null), Dp.m8823constructorimpl(f10)), 1.0f, false, 2, null);
                if ((i13 & 7168) == 2048) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                boolean zChanged = composerStartRestartGroup.changed(layoutDirection.ordinal()) | z11 | composerStartRestartGroup.changed(density);
                i14 = i13 & 896;
                if (i14 == 256) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                z13 = zChanged | z12;
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z13 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    r10 = 0;
                    Function1 function4 = new Function1() { // from class: cu.z17.views.imageEditor.sections.cropper.components.widget.a
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return AspectRatioSlectionCardKt.AspectRatioSelectionCard_DTcfvLk$lambda$6$lambda$5$lambda$3$lambda$2(cropAspectRatio, layoutDirection, density, j11, (CacheDrawScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(function4);
                    objRememberedValue = function4;
                } else {
                    r10 = 0;
                }
                Modifier modifierDrawWithCache = DrawModifierKt.drawWithCache(modifierAspectRatio$default, (Function1) objRememberedValue);
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(companion.getCenter(), r10);
                currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, r10);
                CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierDrawWithCache);
                constructor3 = companion2.getConstructor();
                if (!r.a(composerStartRestartGroup.getApplier())) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor3);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerM5176constructorimpl3 = Updater.m5176constructorimpl(composerStartRestartGroup);
                Updater.m5184setimpl(composerM5176constructorimpl3, measurePolicyMaybeCachedBoxMeasurePolicy2, companion2.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl3, currentCompositionLocalMap3, companion2.getSetResolvedCompositionLocals());
                setCompositeKeyHash3 = companion2.getSetCompositeKeyHash();
                if (composerM5176constructorimpl3.getInserting() || !y.d(composerM5176constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                    composerM5176constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                    composerM5176constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                }
                Updater.m5184setimpl(composerM5176constructorimpl3, modifierMaterializeModifier3, companion2.getSetModifier());
                Function1 function5 = function2;
                composer2 = composerStartRestartGroup;
                GridImageLayoutKt.m10240GridImageLayout942rkJo(PaddingKt.m1725padding3ABfNKs(boxScopeInstance.matchParentSize(companion3), Dp.m8823constructorimpl(5)), cropAspectRatio.getIcons(), 0.0f, function5, composer2, (i13 >> 3) & 7168, 4);
                composer2.endNode();
                if (cropAspectRatio.getTitle().length() > 0) {
                    composer2.startReplaceGroup(1502311106);
                    TextKt.m3848Text4IGK_g(cropAspectRatio.getTitle(), (Modifier) null, j11, TextUnitKt.getSp(14), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer2, i14 | 3072, 0, 131058);
                } else {
                    composer2.startReplaceGroup(1499498693);
                }
                composer2.endReplaceGroup();
                composer2.endNode();
                composer2.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function3 = function5;
                modifier3 = modifier6;
                j12 = j14;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
                j12 = surface;
                function3 = function2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.imageEditor.sections.cropper.components.widget.b
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AspectRatioSlectionCardKt.AspectRatioSelectionCard_DTcfvLk$lambda$7(modifier3, j12, j11, cropAspectRatio, function3, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i12 |= 24576;
        function2 = function1;
        if ((i12 & 9363) != 9362) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z10, i12 & 1)) {
            composerStartRestartGroup.startDefaults();
            if ((i10 & 1) != 0) {
                if (i15 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if ((i11 & 2) != 0) {
                    i12 &= -113;
                    surface = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getSurface();
                }
                modifier5 = modifier4;
                j13 = surface;
                if (i17 != 0) {
                    function2 = null;
                }
            } else {
                if (i15 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if ((i11 & 2) != 0) {
                    i12 &= -113;
                    surface = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getSurface();
                }
                modifier5 = modifier4;
                j13 = surface;
                if (i17 != 0) {
                    function2 = null;
                }
            }
            i13 = i12;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1460564537, i13, -1, "cu.z17.views.imageEditor.sections.cropper.components.widget.AspectRatioSelectionCard (AspectRatioSlectionCard.kt:27)");
            }
            Modifier modifier7 = modifier5;
            long j15 = j13;
            float f11 = 4;
            Modifier modifierM1725padding3ABfNKs2 = PaddingKt.m1725padding3ABfNKs(BackgroundKt.m1205backgroundbw27NRU$default(modifier5, j13, null, 2, null), Dp.m8823constructorimpl(f11));
            Alignment.Companion companion4 = Alignment.INSTANCE;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(companion4.getTopStart(), false);
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1725padding3ABfNKs2);
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
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy3, companion5.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap4, companion5.getSetResolvedCompositionLocals());
            setCompositeKeyHash = companion5.getSetCompositeKeyHash();
            if (composerM5176constructorimpl.getInserting()) {
                composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            } else {
                composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier4, companion5.getSetModifier());
            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
            Alignment.Horizontal centerHorizontally2 = companion4.getCenterHorizontally();
            Modifier.Companion companion6 = Modifier.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), centerHorizontally2, composerStartRestartGroup, 48);
            currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap5 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier5 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion6);
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
            Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap5, companion5.getSetResolvedCompositionLocals());
            setCompositeKeyHash2 = companion5.getSetCompositeKeyHash();
            if (composerM5176constructorimpl2.getInserting()) {
                composerM5176constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                composerM5176constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            } else {
                composerM5176constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                composerM5176constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier5, companion5.getSetModifier());
            ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
            density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            Modifier modifierAspectRatio$default2 = AspectRatioKt.aspectRatio$default(PaddingKt.m1725padding3ABfNKs(SizeKt.fillMaxWidth$default(companion6, 0.0f, 1, null), Dp.m8823constructorimpl(f11)), 1.0f, false, 2, null);
            if ((i13 & 7168) == 2048) {
                z11 = true;
            } else {
                z11 = false;
            }
            boolean zChanged2 = composerStartRestartGroup.changed(layoutDirection.ordinal()) | z11 | composerStartRestartGroup.changed(density);
            i14 = i13 & 896;
            if (i14 == 256) {
                z12 = true;
            } else {
                z12 = false;
            }
            z13 = zChanged2 | z12;
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z13) {
                r10 = 0;
                Function1 function6 = new Function1() { // from class: cu.z17.views.imageEditor.sections.cropper.components.widget.a
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return AspectRatioSlectionCardKt.AspectRatioSelectionCard_DTcfvLk$lambda$6$lambda$5$lambda$3$lambda$2(cropAspectRatio, layoutDirection, density, j11, (CacheDrawScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(function6);
                objRememberedValue = function6;
            } else {
                r10 = 0;
                Function1 function7 = new Function1() { // from class: cu.z17.views.imageEditor.sections.cropper.components.widget.a
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return AspectRatioSlectionCardKt.AspectRatioSelectionCard_DTcfvLk$lambda$6$lambda$5$lambda$3$lambda$2(cropAspectRatio, layoutDirection, density, j11, (CacheDrawScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(function7);
                objRememberedValue = function7;
            }
            Modifier modifierDrawWithCache2 = DrawModifierKt.drawWithCache(modifierAspectRatio$default2, (Function1) objRememberedValue);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy4 = BoxKt.maybeCachedBoxMeasurePolicy(companion4.getCenter(), r10);
            currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, r10);
            CompositionLocalMap currentCompositionLocalMap6 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier6 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierDrawWithCache2);
            constructor3 = companion5.getConstructor();
            if (!r.a(composerStartRestartGroup.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor3);
            } else {
                composerStartRestartGroup.useNode();
            }
            composerM5176constructorimpl3 = Updater.m5176constructorimpl(composerStartRestartGroup);
            Updater.m5184setimpl(composerM5176constructorimpl3, measurePolicyMaybeCachedBoxMeasurePolicy4, companion5.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl3, currentCompositionLocalMap6, companion5.getSetResolvedCompositionLocals());
            setCompositeKeyHash3 = companion5.getSetCompositeKeyHash();
            if (composerM5176constructorimpl3.getInserting()) {
                composerM5176constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                composerM5176constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
            } else {
                composerM5176constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                composerM5176constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
            }
            Updater.m5184setimpl(composerM5176constructorimpl3, modifierMaterializeModifier6, companion5.getSetModifier());
            Function1 function8 = function2;
            composer2 = composerStartRestartGroup;
            GridImageLayoutKt.m10240GridImageLayout942rkJo(PaddingKt.m1725padding3ABfNKs(boxScopeInstance2.matchParentSize(companion6), Dp.m8823constructorimpl(5)), cropAspectRatio.getIcons(), 0.0f, function8, composer2, (i13 >> 3) & 7168, 4);
            composer2.endNode();
            if (cropAspectRatio.getTitle().length() > 0) {
                composer2.startReplaceGroup(1502311106);
                TextKt.m3848Text4IGK_g(cropAspectRatio.getTitle(), (Modifier) null, j11, TextUnitKt.getSp(14), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer2, i14 | 3072, 0, 131058);
            } else {
                composer2.startReplaceGroup(1499498693);
            }
            composer2.endReplaceGroup();
            composer2.endNode();
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            function3 = function8;
            modifier3 = modifier7;
            j12 = j15;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            modifier3 = modifier2;
            j12 = surface;
            function3 = function2;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.imageEditor.sections.cropper.components.widget.b
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AspectRatioSlectionCardKt.AspectRatioSelectionCard_DTcfvLk$lambda$7(modifier3, j12, j11, cropAspectRatio, function3, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DrawResult AspectRatioSelectionCard_DTcfvLk$lambda$6$lambda$5$lambda$3$lambda$2(CropAspectRatio cropAspectRatio, LayoutDirection layoutDirection, Density density, final long j10, CacheDrawScope drawWithCache) {
        y.i(drawWithCache, "$this$drawWithCache");
        final Outline outlineMo1261createOutlinePq9zytI = cropAspectRatio.getShape().mo1261createOutlinePq9zytI(drawWithCache.m5441getSizeNHjbRc(), layoutDirection, density);
        final float fIntBitsToFloat = Float.intBitsToFloat((int) (drawWithCache.m5441getSizeNHjbRc() >> 32));
        final float fIntBitsToFloat2 = Float.intBitsToFloat((int) (drawWithCache.m5441getSizeNHjbRc() & MuxerUtil.UNSIGNED_INT_MAX_VALUE));
        Rect rect = outlineMo1261createOutlinePq9zytI.getRect();
        final float right = rect.getRight() - rect.getLeft();
        Rect rect2 = outlineMo1261createOutlinePq9zytI.getRect();
        final float bottom = rect2.getBottom() - rect2.getTop();
        return drawWithCache.onDrawWithContent(new Function1() { // from class: cu.z17.views.imageEditor.sections.cropper.components.widget.c
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AspectRatioSlectionCardKt.AspectRatioSelectionCard_DTcfvLk$lambda$6$lambda$5$lambda$3$lambda$2$lambda$1(fIntBitsToFloat, right, fIntBitsToFloat2, bottom, outlineMo1261createOutlinePq9zytI, j10, (ContentDrawScope) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 AspectRatioSelectionCard_DTcfvLk$lambda$6$lambda$5$lambda$3$lambda$2$lambda$1(float f10, float f11, float f12, float f13, Outline outline, long j10, ContentDrawScope onDrawWithContent) {
        y.i(onDrawWithContent, "$this$onDrawWithContent");
        float f14 = f10 - f11;
        float f15 = 2;
        float f16 = f14 / f15;
        float f17 = (f12 - f13) / f15;
        onDrawWithContent.getDrawContext().getTransform().translate(f16, f17);
        try {
            OutlineKt.m6118drawOutlinewDX37Ww$default(onDrawWithContent, outline, j10, 0.0f, new Stroke(onDrawWithContent.mo1345toPx0680j_4(Dp.m8823constructorimpl(3)), 0.0f, 0, 0, null, 30, null), null, 0, 52, null);
            onDrawWithContent.getDrawContext().getTransform().translate(-f16, -f17);
            onDrawWithContent.drawContent();
            return k0.f43947a;
        } catch (Throwable th2) {
            onDrawWithContent.getDrawContext().getTransform().translate(-f16, -f17);
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 AspectRatioSelectionCard_DTcfvLk$lambda$7(Modifier modifier, long j10, long j11, CropAspectRatio cropAspectRatio, Function1 function1, int i10, int i11, Composer composer, int i12) {
        m10237AspectRatioSelectionCardDTcfvLk(modifier, j10, j11, cropAspectRatio, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return k0.f43947a;
    }
}
