package cu.z17.views.pdfViewer;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.pdf.PdfRenderer;
import android.net.Uri;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxWithConstraintsKt;
import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.x;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.unit.Dp;
import androidx.media3.exoplayer.RendererCapabilities;
import coil.memory.MemoryCache;
import cu.z17.views.utils.Z17CoilDecoders;
import defpackage.r;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.y;
import pe.a2;
import pe.d1;
import pe.m0;
import ua.k0;
import ua.z;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a3\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\b\u0010\t¨\u0006\u0011²\u0006\u000e\u0010\u000b\u001a\u0004\u0018\u00010\n8\nX\u008a\u0084\u0002²\u0006\f\u0010\r\u001a\u00020\f8\nX\u008a\u0084\u0002²\u0006\u001c\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000e8\n@\nX\u008a\u008e\u0002"}, d2 = {"Landroidx/compose/ui/Modifier;", "modifier", "Landroid/net/Uri;", "uri", "", "zoomable", "horizontal", "Lua/k0;", "Z17PdfViewer", "(Landroidx/compose/ui/Modifier;Landroid/net/Uri;ZZLandroidx/compose/runtime/Composer;II)V", "Landroid/graphics/pdf/PdfRenderer;", "renderer", "", "pageCount", "Lkotlin/Pair;", "Landroid/graphics/Bitmap;", "actualPage", "views_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class Z17PdfViewerKt {
    /* JADX WARN: Code duplicated, block: B:100:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:41:0x0078  */
    /* JADX WARN: Code duplicated, block: B:42:0x007a  */
    /* JADX WARN: Code duplicated, block: B:45:0x0083 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:46:0x0085  */
    /* JADX WARN: Code duplicated, block: B:47:0x0088  */
    /* JADX WARN: Code duplicated, block: B:49:0x008b  */
    /* JADX WARN: Code duplicated, block: B:52:0x0092  */
    /* JADX WARN: Code duplicated, block: B:55:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:58:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:59:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:64:0x0101  */
    /* JADX WARN: Code duplicated, block: B:67:0x0124  */
    /* JADX WARN: Code duplicated, block: B:70:0x013a  */
    /* JADX WARN: Code duplicated, block: B:75:0x015d  */
    /* JADX WARN: Code duplicated, block: B:80:0x0183  */
    /* JADX WARN: Code duplicated, block: B:83:0x019b  */
    /* JADX WARN: Code duplicated, block: B:86:0x01c3  */
    /* JADX WARN: Code duplicated, block: B:89:0x021e  */
    /* JADX WARN: Code duplicated, block: B:92:0x0236  */
    /* JADX WARN: Code duplicated, block: B:95:0x023c  */
    /* JADX WARN: Code duplicated, block: B:98:0x0248  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void Z17PdfViewer(Modifier modifier, final Uri uri, final boolean z10, boolean z11, Composer composer, final int i10, final int i11) {
        Modifier modifier2;
        int i12;
        boolean z12;
        boolean z13;
        Composer composer2;
        final Modifier modifier3;
        final boolean z14;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier modifier4;
        int currentCompositeKeyHash;
        lb.a constructor;
        Composer composerM5176constructorimpl;
        Function2 setCompositeKeyHash;
        Object objRememberedValue;
        Composer.Companion companion;
        m0 m0Var;
        Object objRememberedValue2;
        final af.a aVar;
        boolean zChangedInstance;
        Object objRememberedValue3;
        final State stateProduceState;
        boolean zChanged;
        Object objRememberedValue4;
        Object objRememberedValue5;
        final MutableState mutableState;
        Object objRememberedValue6;
        Object objRememberedValue7;
        y.i(uri, "uri");
        Composer composerStartRestartGroup = composer.startRestartGroup(889454991);
        int i13 = i11 & 1;
        if (i13 != 0) {
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
            i12 |= composerStartRestartGroup.changedInstance(uri) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i12 |= composerStartRestartGroup.changed(z10) ? 256 : 128;
        }
        int i14 = i11 & 8;
        if (i14 == 0) {
            if ((i10 & 3072) == 0) {
                z12 = z11;
                i12 |= composerStartRestartGroup.changed(z12) ? 2048 : 1024;
            }
            if ((i12 & 1171) != 1170) {
                z13 = true;
            } else {
                z13 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z13, i12 & 1)) {
                if (i13 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (i14 != 0) {
                    z12 = true;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(889454991, i12, -1, "cu.z17.views.pdfViewer.Z17PdfViewer (Z17PdfViewer.kt:37)");
                }
                MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier4);
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
                Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyColumnMeasurePolicy, companion2.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
                setCompositeKeyHash = companion2.getSetCompositeKeyHash();
                if (composerM5176constructorimpl.getInserting() || !y.d(composerM5176constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion2.getSetModifier());
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                companion = Composer.INSTANCE;
                if (objRememberedValue == companion.getEmpty()) {
                    objRememberedValue = EffectsKt.createCompositionCoroutineScope(ab.j.f643c, composerStartRestartGroup);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                m0Var = (m0) objRememberedValue;
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == companion.getEmpty()) {
                    objRememberedValue2 = af.g.b(false, 1, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                aVar = (af.a) objRememberedValue2;
                zChangedInstance = composerStartRestartGroup.changedInstance(m0Var) | composerStartRestartGroup.changedInstance(uri) | composerStartRestartGroup.changedInstance(aVar);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance || objRememberedValue3 == companion.getEmpty()) {
                    objRememberedValue3 = new Z17PdfViewerKt$Z17PdfViewer$1$renderer$2$1(m0Var, uri, aVar, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                stateProduceState = SnapshotStateKt.produceState((Object) null, uri, (Function2) objRememberedValue3, composerStartRestartGroup, (i12 & 112) | 6);
                zChanged = composerStartRestartGroup.changed(Z17PdfViewer$lambda$16$lambda$2(stateProduceState));
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (zChanged || objRememberedValue4 == companion.getEmpty()) {
                    objRememberedValue4 = SnapshotStateKt.derivedStateOf(new lb.a() { // from class: cu.z17.views.pdfViewer.g
                        @Override // lb.a
                        public final Object invoke() {
                            return Integer.valueOf(Z17PdfViewerKt.Z17PdfViewer$lambda$16$lambda$4$lambda$3(stateProduceState));
                        }
                    });
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                final State state = (State) objRememberedValue4;
                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue5 == companion.getEmpty()) {
                    objRememberedValue5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new Pair(0, null), null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                mutableState = (MutableState) objRememberedValue5;
                final Context context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue6 == companion.getEmpty()) {
                    objRememberedValue6 = EffectsKt.createCompositionCoroutineScope(ab.j.f643c, composerStartRestartGroup);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                }
                final m0 m0Var2 = (m0) objRememberedValue6;
                final Modifier modifier5 = modifier4;
                final boolean z15 = z12;
                z12 = z15;
                composer2 = composerStartRestartGroup;
                BoxWithConstraintsKt.BoxWithConstraints(x.a(columnScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), null, false, ComposableLambdaKt.rememberComposableLambda(1382829379, true, new Function3() { // from class: cu.z17.views.pdfViewer.h
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return Z17PdfViewerKt.Z17PdfViewer$lambda$16$lambda$13(z15, modifier5, uri, context, z10, state, m0Var2, aVar, stateProduceState, mutableState, (BoxWithConstraintsScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composer2, 3072, 6);
                int iIntValue = Z17PdfViewer$lambda$16$lambda$7(mutableState).getFirst().intValue();
                int iZ17PdfViewer$lambda$16$lambda$5 = Z17PdfViewer$lambda$16$lambda$5(state);
                objRememberedValue7 = composer2.rememberedValue();
                if (objRememberedValue7 == companion.getEmpty()) {
                    objRememberedValue7 = new Function1() { // from class: cu.z17.views.pdfViewer.i
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return Z17PdfViewerKt.Z17PdfViewer$lambda$16$lambda$15$lambda$14(mutableState, ((Integer) obj).intValue());
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue7);
                }
                PdfControlsKt.PdfControls(iIntValue, iZ17PdfViewer$lambda$16$lambda$5, (Function1) objRememberedValue7, composer2, RendererCapabilities.DECODER_SUPPORT_MASK);
                composer2.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier5;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
            }
            z14 = z12;
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.pdfViewer.j
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return Z17PdfViewerKt.Z17PdfViewer$lambda$17(modifier3, uri, z10, z14, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i12 |= 3072;
        z12 = z11;
        if ((i12 & 1171) != 1170) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z13, i12 & 1)) {
            if (i13 != 0) {
                modifier4 = Modifier.INSTANCE;
            } else {
                modifier4 = modifier2;
            }
            if (i14 != 0) {
                z12 = true;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(889454991, i12, -1, "cu.z17.views.pdfViewer.Z17PdfViewer (Z17PdfViewer.kt:37)");
            }
            MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier4);
            ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
            constructor = companion3.getConstructor();
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
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyColumnMeasurePolicy2, companion3.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
            setCompositeKeyHash = companion3.getSetCompositeKeyHash();
            if (composerM5176constructorimpl.getInserting()) {
                composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            } else {
                composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier2, companion3.getSetModifier());
            ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            companion = Composer.INSTANCE;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = EffectsKt.createCompositionCoroutineScope(ab.j.f643c, composerStartRestartGroup);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            m0Var = (m0) objRememberedValue;
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = af.g.b(false, 1, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            aVar = (af.a) objRememberedValue2;
            zChangedInstance = composerStartRestartGroup.changedInstance(m0Var) | composerStartRestartGroup.changedInstance(uri) | composerStartRestartGroup.changedInstance(aVar);
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance) {
                objRememberedValue3 = new Z17PdfViewerKt$Z17PdfViewer$1$renderer$2$1(m0Var, uri, aVar, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            } else {
                objRememberedValue3 = new Z17PdfViewerKt$Z17PdfViewer$1$renderer$2$1(m0Var, uri, aVar, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            stateProduceState = SnapshotStateKt.produceState((Object) null, uri, (Function2) objRememberedValue3, composerStartRestartGroup, (i12 & 112) | 6);
            zChanged = composerStartRestartGroup.changed(Z17PdfViewer$lambda$16$lambda$2(stateProduceState));
            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (zChanged) {
                objRememberedValue4 = SnapshotStateKt.derivedStateOf(new lb.a() { // from class: cu.z17.views.pdfViewer.g
                    @Override // lb.a
                    public final Object invoke() {
                        return Integer.valueOf(Z17PdfViewerKt.Z17PdfViewer$lambda$16$lambda$4$lambda$3(stateProduceState));
                    }
                });
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            } else {
                objRememberedValue4 = SnapshotStateKt.derivedStateOf(new lb.a() { // from class: cu.z17.views.pdfViewer.g
                    @Override // lb.a
                    public final Object invoke() {
                        return Integer.valueOf(Z17PdfViewerKt.Z17PdfViewer$lambda$16$lambda$4$lambda$3(stateProduceState));
                    }
                });
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            final State state2 = (State) objRememberedValue4;
            objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue5 == companion.getEmpty()) {
                objRememberedValue5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new Pair(0, null), null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            }
            mutableState = (MutableState) objRememberedValue5;
            final Context context2 = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
            objRememberedValue6 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue6 == companion.getEmpty()) {
                objRememberedValue6 = EffectsKt.createCompositionCoroutineScope(ab.j.f643c, composerStartRestartGroup);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
            }
            final m0 m0Var3 = (m0) objRememberedValue6;
            final Modifier modifier6 = modifier4;
            final boolean z16 = z12;
            z12 = z16;
            composer2 = composerStartRestartGroup;
            BoxWithConstraintsKt.BoxWithConstraints(x.a(columnScopeInstance2, Modifier.INSTANCE, 1.0f, false, 2, null), null, false, ComposableLambdaKt.rememberComposableLambda(1382829379, true, new Function3() { // from class: cu.z17.views.pdfViewer.h
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return Z17PdfViewerKt.Z17PdfViewer$lambda$16$lambda$13(z16, modifier6, uri, context2, z10, state2, m0Var3, aVar, stateProduceState, mutableState, (BoxWithConstraintsScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composer2, 3072, 6);
            int iIntValue2 = Z17PdfViewer$lambda$16$lambda$7(mutableState).getFirst().intValue();
            int iZ17PdfViewer$lambda$16$lambda$6 = Z17PdfViewer$lambda$16$lambda$5(state2);
            objRememberedValue7 = composer2.rememberedValue();
            if (objRememberedValue7 == companion.getEmpty()) {
                objRememberedValue7 = new Function1() { // from class: cu.z17.views.pdfViewer.i
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Z17PdfViewerKt.Z17PdfViewer$lambda$16$lambda$15$lambda$14(mutableState, ((Integer) obj).intValue());
                    }
                };
                composer2.updateRememberedValue(objRememberedValue7);
            }
            PdfControlsKt.PdfControls(iIntValue2, iZ17PdfViewer$lambda$16$lambda$6, (Function1) objRememberedValue7, composer2, RendererCapabilities.DECODER_SUPPORT_MASK);
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier6;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            modifier3 = modifier2;
        }
        z14 = z12;
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.pdfViewer.j
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return Z17PdfViewerKt.Z17PdfViewer$lambda$17(modifier3, uri, z10, z14, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 Z17PdfViewer$lambda$16$lambda$13(boolean z10, Modifier modifier, final Uri uri, Context context, boolean z11, final State state, final m0 m0Var, final af.a aVar, final State state2, final MutableState mutableState, BoxWithConstraintsScope BoxWithConstraints, Composer composer, int i10) {
        int i11;
        y.i(BoxWithConstraints, "$this$BoxWithConstraints");
        if ((i10 & 6) == 0) {
            i11 = i10 | (composer.changed(BoxWithConstraints) ? 4 : 2);
        } else {
            i11 = i10;
        }
        if (composer.shouldExecute((i11 & 19) != 18, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1382829379, i11, -1, "cu.z17.views.pdfViewer.Z17PdfViewer.<anonymous>.<anonymous> (Z17PdfViewer.kt:67)");
            }
            final float fMo1635getMaxWidthD9Ej5fM = BoxWithConstraints.mo1635getMaxWidthD9Ej5fM();
            final float fM8823constructorimpl = Dp.m8823constructorimpl(((float) Math.sqrt(2.0f)) * fMo1635getMaxWidthD9Ej5fM);
            if (z10) {
                composer.startReplaceGroup(-1456150185);
                PagePdfViewerKt.m10268PagePdfViewerYlGCr2M(modifier, Z17PdfViewer$lambda$16$lambda$7(mutableState), uri + "-" + Z17PdfViewer$lambda$16$lambda$7(mutableState).getFirst(), fMo1635getMaxWidthD9Ej5fM, fM8823constructorimpl, context, z11, composer, 0, 0);
            } else {
                composer.startReplaceGroup(-1458579841);
            }
            composer.endReplaceGroup();
            Integer first = Z17PdfViewer$lambda$16$lambda$7(mutableState).getFirst();
            Integer numValueOf = Integer.valueOf(Z17PdfViewer$lambda$16$lambda$5(state));
            boolean zChangedInstance = composer.changedInstance(uri) | composer.changed(state) | composer.changedInstance(m0Var) | composer.changed(fMo1635getMaxWidthD9Ej5fM) | composer.changed(fM8823constructorimpl) | composer.changedInstance(aVar) | composer.changed(state2);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                Function1 function1 = new Function1() { // from class: cu.z17.views.pdfViewer.k
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Z17PdfViewerKt.Z17PdfViewer$lambda$16$lambda$13$lambda$12$lambda$11(uri, m0Var, mutableState, state, fMo1635getMaxWidthD9Ej5fM, fM8823constructorimpl, aVar, state2, (DisposableEffectScope) obj);
                    }
                };
                composer.updateRememberedValue(function1);
                objRememberedValue = function1;
            }
            EffectsKt.DisposableEffect(first, numValueOf, (Function1) objRememberedValue, composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0045  */
    public static final DisposableEffectResult Z17PdfViewer$lambda$16$lambda$13$lambda$12$lambda$11(Uri uri, m0 m0Var, MutableState mutableState, State state, float f10, float f11, af.a aVar, State state2, DisposableEffectScope DisposableEffect) {
        Bitmap bitmap;
        y.i(DisposableEffect, "$this$DisposableEffect");
        MemoryCache memoryCache = Z17CoilDecoders.INSTANCE.getInstance().getImageLoader().getMemoryCache();
        if (memoryCache != null) {
            MemoryCache.Value value = memoryCache.get(new MemoryCache.Key(uri + "-" + Z17PdfViewer$lambda$16$lambda$7(mutableState).getFirst(), null, 2, null));
            if (value != null) {
                bitmap = value.getBitmap();
            } else {
                bitmap = null;
            }
        } else {
            bitmap = null;
        }
        if (bitmap != null) {
            mutableState.setValue(Pair.copy$default(Z17PdfViewer$lambda$16$lambda$7(mutableState), null, bitmap, 1, null));
        } else if (Z17PdfViewer$lambda$16$lambda$5(state) > Z17PdfViewer$lambda$16$lambda$7(mutableState).getFirst().intValue()) {
            final a2 a2VarD = pe.k.d(m0Var, d1.b(), null, new Z17PdfViewerKt$Z17PdfViewer$1$1$1$1$job$1(f10, f11, aVar, state2, mutableState, null), 2, null);
            new DisposableEffectResult() { // from class: cu.z17.views.pdfViewer.Z17PdfViewerKt$Z17PdfViewer$lambda$16$lambda$13$lambda$12$lambda$11$$inlined$onDispose$1
                @Override // androidx.compose.runtime.DisposableEffectResult
                public void dispose() {
                    a2.a.a(a2VarD, null, 1, null);
                }
            };
        }
        return new DisposableEffectResult() { // from class: cu.z17.views.pdfViewer.Z17PdfViewerKt$Z17PdfViewer$lambda$16$lambda$13$lambda$12$lambda$11$$inlined$onDispose$2
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 Z17PdfViewer$lambda$16$lambda$15$lambda$14(MutableState mutableState, int i10) {
        mutableState.setValue(z.a(Integer.valueOf(i10), null));
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PdfRenderer Z17PdfViewer$lambda$16$lambda$2(State<PdfRenderer> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int Z17PdfViewer$lambda$16$lambda$4$lambda$3(State state) {
        PdfRenderer pdfRendererZ17PdfViewer$lambda$16$lambda$2 = Z17PdfViewer$lambda$16$lambda$2(state);
        if (pdfRendererZ17PdfViewer$lambda$16$lambda$2 != null) {
            return pdfRendererZ17PdfViewer$lambda$16$lambda$2.getPageCount();
        }
        return 0;
    }

    private static final int Z17PdfViewer$lambda$16$lambda$5(State<Integer> state) {
        return state.getValue().intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Pair<Integer, Bitmap> Z17PdfViewer$lambda$16$lambda$7(MutableState<Pair<Integer, Bitmap>> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 Z17PdfViewer$lambda$17(Modifier modifier, Uri uri, boolean z10, boolean z11, int i10, int i11, Composer composer, int i12) {
        Z17PdfViewer(modifier, uri, z10, z11, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return k0.f43947a;
    }
}
