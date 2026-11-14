package cu.todus.android.uiCompose.main.screen.pubEditor;

import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material.DividerKt;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.OutlinedTextFieldKt;
import androidx.compose.material3.TextFieldColors;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.TextFieldValueKt;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.unit.Dp;
import androidx.exifinterface.media.ExifInterface;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001d\u0010\u0004\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Landroidx/compose/runtime/MutableState;", "Landroidx/compose/ui/text/input/TextFieldValue;", "textFieldValue", "Lua/k0;", "MDEditorFun", "(Landroidx/compose/runtime/MutableState;Landroidx/compose/runtime/Composer;I)V", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class MDEditorFunKt {
    /* JADX WARN: Code duplicated, block: B:114:0x067a A[PHI: r2 r3 r4 r5 r17
      0x067a: PHI (r2v41 kotlin.jvm.internal.y0) = 
      (r2v12 kotlin.jvm.internal.y0)
      (r2v13 kotlin.jvm.internal.y0)
      (r2v14 kotlin.jvm.internal.y0)
      (r2v17 kotlin.jvm.internal.y0)
      (r2v18 kotlin.jvm.internal.y0)
      (r2v21 kotlin.jvm.internal.y0)
      (r2v24 kotlin.jvm.internal.y0)
      (r2v27 kotlin.jvm.internal.y0)
      (r2v28 kotlin.jvm.internal.y0)
      (r2v32 kotlin.jvm.internal.y0)
      (r2v33 kotlin.jvm.internal.y0)
      (r2v42 kotlin.jvm.internal.y0)
     binds: [B:113:0x0678, B:109:0x05ff, B:105:0x05a6, B:101:0x0555, B:97:0x0511, B:93:0x04cd, B:89:0x0489, B:85:0x0438, B:81:0x03e7, B:65:0x02ba, B:61:0x0261, B:53:0x01f0] A[DONT_GENERATE, DONT_INLINE]
      0x067a: PHI (r3v36 androidx.compose.runtime.State) = 
      (r3v8 androidx.compose.runtime.State)
      (r3v9 androidx.compose.runtime.State)
      (r3v10 androidx.compose.runtime.State)
      (r3v13 androidx.compose.runtime.State)
      (r3v14 androidx.compose.runtime.State)
      (r3v17 androidx.compose.runtime.State)
      (r3v20 androidx.compose.runtime.State)
      (r3v23 androidx.compose.runtime.State)
      (r3v24 androidx.compose.runtime.State)
      (r3v28 androidx.compose.runtime.State)
      (r3v29 androidx.compose.runtime.State)
      (r3v37 androidx.compose.runtime.State)
     binds: [B:113:0x0678, B:109:0x05ff, B:105:0x05a6, B:101:0x0555, B:97:0x0511, B:93:0x04cd, B:89:0x0489, B:85:0x0438, B:81:0x03e7, B:65:0x02ba, B:61:0x0261, B:53:0x01f0] A[DONT_GENERATE, DONT_INLINE]
      0x067a: PHI (r4v26 androidx.compose.runtime.State) = 
      (r4v6 androidx.compose.runtime.State)
      (r4v7 androidx.compose.runtime.State)
      (r4v8 androidx.compose.runtime.State)
      (r4v9 androidx.compose.runtime.State)
      (r4v10 androidx.compose.runtime.State)
      (r4v11 androidx.compose.runtime.State)
      (r4v12 androidx.compose.runtime.State)
      (r4v13 androidx.compose.runtime.State)
      (r4v14 androidx.compose.runtime.State)
      (r4v18 androidx.compose.runtime.State)
      (r4v19 androidx.compose.runtime.State)
      (r4v27 androidx.compose.runtime.State)
     binds: [B:113:0x0678, B:109:0x05ff, B:105:0x05a6, B:101:0x0555, B:97:0x0511, B:93:0x04cd, B:89:0x0489, B:85:0x0438, B:81:0x03e7, B:65:0x02ba, B:61:0x0261, B:53:0x01f0] A[DONT_GENERATE, DONT_INLINE]
      0x067a: PHI (r5v56 char) = 
      (r5v3 char)
      (r5v5 char)
      (r5v6 char)
      (r5v11 char)
      (r5v16 char)
      (r5v20 char)
      (r5v24 char)
      (r5v28 char)
      (r5v33 char)
      (r5v41 char)
      (r5v43 char)
      (r5v57 char)
     binds: [B:113:0x0678, B:109:0x05ff, B:105:0x05a6, B:101:0x0555, B:97:0x0511, B:93:0x04cd, B:89:0x0489, B:85:0x0438, B:81:0x03e7, B:65:0x02ba, B:61:0x0261, B:53:0x01f0] A[DONT_GENERATE, DONT_INLINE]
      0x067a: PHI (r17v25 int) = 
      (r17v6 int)
      (r17v7 int)
      (r17v8 int)
      (r17v9 int)
      (r17v10 int)
      (r17v11 int)
      (r17v12 int)
      (r17v13 int)
      (r17v14 int)
      (r17v18 int)
      (r17v19 int)
      (r17v26 int)
     binds: [B:113:0x0678, B:109:0x05ff, B:105:0x05a6, B:101:0x0555, B:97:0x0511, B:93:0x04cd, B:89:0x0489, B:85:0x0438, B:81:0x03e7, B:65:0x02ba, B:61:0x0261, B:53:0x01f0] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:61:0x0261 A[PHI: r2 r3 r4 r7 r17
      0x0261: PHI (r2v33 kotlin.jvm.internal.y0) = 
      (r2v29 kotlin.jvm.internal.y0)
      (r2v30 kotlin.jvm.internal.y0)
      (r2v31 kotlin.jvm.internal.y0)
      (r2v34 kotlin.jvm.internal.y0)
     binds: [B:77:0x0399, B:73:0x034d, B:69:0x0315, B:60:0x025f] A[DONT_GENERATE, DONT_INLINE]
      0x0261: PHI (r3v29 androidx.compose.runtime.State) = 
      (r3v25 androidx.compose.runtime.State)
      (r3v26 androidx.compose.runtime.State)
      (r3v27 androidx.compose.runtime.State)
      (r3v30 androidx.compose.runtime.State)
     binds: [B:77:0x0399, B:73:0x034d, B:69:0x0315, B:60:0x025f] A[DONT_GENERATE, DONT_INLINE]
      0x0261: PHI (r4v19 androidx.compose.runtime.State) = 
      (r4v15 androidx.compose.runtime.State)
      (r4v16 androidx.compose.runtime.State)
      (r4v17 androidx.compose.runtime.State)
      (r4v20 androidx.compose.runtime.State)
     binds: [B:77:0x0399, B:73:0x034d, B:69:0x0315, B:60:0x025f] A[DONT_GENERATE, DONT_INLINE]
      0x0261: PHI (r7v58 char) = (r7v46 char), (r7v48 char), (r7v51 char), (r7v59 char) binds: [B:77:0x0399, B:73:0x034d, B:69:0x0315, B:60:0x025f] A[DONT_GENERATE, DONT_INLINE]
      0x0261: PHI (r17v19 int) = (r17v15 int), (r17v16 int), (r17v17 int), (r17v20 int) binds: [B:77:0x0399, B:73:0x034d, B:69:0x0315, B:60:0x025f] A[DONT_GENERATE, DONT_INLINE]] */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void MDEditorFun(final MutableState<TextFieldValue> mutableState, Composer composer, final int i10) {
        final kotlin.jvm.internal.y0 y0Var;
        final State state;
        final State state2;
        int i11;
        char c10;
        char c11;
        final MutableState<TextFieldValue> textFieldValue = mutableState;
        kotlin.jvm.internal.y.i(textFieldValue, "textFieldValue");
        Composer composerStartRestartGroup = composer.startRestartGroup(1164024914);
        int i12 = (i10 & 6) == 0 ? i10 | (composerStartRestartGroup.changed(textFieldValue) ? 4 : 2) : i10;
        if (composerStartRestartGroup.shouldExecute((i12 & 3) != 2, i12 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1164024914, i12, -1, "cu.todus.android.uiCompose.main.screen.pubEditor.MDEditorFun (MDEditorFun.kt:43)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            Arrangement arrangement = Arrangement.INSTANCE;
            Arrangement.Vertical top = arrangement.getTop();
            Alignment.Companion companion2 = Alignment.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(top, companion2.getStart(), composerStartRestartGroup, 0);
            int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
            ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
            lb.a constructor = companion3.getConstructor();
            if (!defpackage.r.a(composerStartRestartGroup.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM5176constructorimpl = Updater.m5176constructorimpl(composerStartRestartGroup);
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyColumnMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion3.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl, companion3.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion3.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            Composer.Companion companion4 = Composer.INSTANCE;
            if (objRememberedValue == companion4.getEmpty()) {
                objRememberedValue = 8000;
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final int iIntValue = ((Number) objRememberedValue).intValue();
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == companion4.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt.derivedStateOf(new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.pubEditor.e0
                    @Override // lb.a
                    public final Object invoke() {
                        return MDEditorFunKt.MDEditorFun$lambda$0$1$0(textFieldValue, iIntValue);
                    }
                });
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            State state3 = (State) objRememberedValue2;
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == companion4.getEmpty()) {
                objRememberedValue3 = SnapshotStateKt.derivedStateOf(new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.pubEditor.g0
                    @Override // lb.a
                    public final Object invoke() {
                        return MDEditorFunKt.MDEditorFun$lambda$0$2$0(textFieldValue, iIntValue);
                    }
                });
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            State state4 = (State) objRememberedValue3;
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue4 == companion4.getEmpty()) {
                objRememberedValue4 = SnapshotStateKt.derivedStateOf(new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.pubEditor.h0
                    @Override // lb.a
                    public final Object invoke() {
                        return MDEditorFunKt.MDEditorFun$lambda$0$3$0(textFieldValue);
                    }
                });
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            final State state5 = (State) objRememberedValue4;
            final kotlin.jvm.internal.y0 y0Var2 = new kotlin.jvm.internal.y0();
            ScrollState scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
            Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue5 == companion4.getEmpty()) {
                objRememberedValue5 = va.w.q("H1", "H2", "H3", "Divider", "Bold", "Italic", "BoldItalic", ExifInterface.GPS_DIRECTION_TRUE, "Divider", "quote", "line", "Link", "Code", "Divider", "ListBulled", "Divider", "Clean");
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            }
            List<String> list = (List) objRememberedValue5;
            Modifier modifierHorizontalScroll$default = ScrollKt.horizontalScroll$default(companion, scrollStateRememberScrollState, false, null, false, 14, null);
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getStart(), companion2.getTop(), composerStartRestartGroup, 0);
            int iA2 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierHorizontalScroll$default);
            lb.a constructor2 = companion3.getConstructor();
            if (!defpackage.r.a(composerStartRestartGroup.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor2);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM5176constructorimpl2 = Updater.m5176constructorimpl(composerStartRestartGroup);
            Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyRowMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl2, Integer.valueOf(iA2), companion3.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl2, companion3.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier2, companion3.getSetModifier());
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            composerStartRestartGroup.startReplaceGroup(-1242792200);
            for (String str : list) {
                switch (str.hashCode()) {
                    case -2094913968:
                        y0Var = y0Var2;
                        state = state3;
                        state2 = state4;
                        i11 = i12;
                        c10 = 4;
                        if (str.equals("Italic")) {
                            composerStartRestartGroup.startReplaceGroup(-1569421360);
                            textFieldValue = mutableState;
                            IconButtonKt.IconButton(new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.pubEditor.d0
                                @Override // lb.a
                                public final Object invoke() {
                                    return MDEditorFunKt.MDEditorFun$lambda$0$5$0$5(state5, y0Var, state, state2, textFieldValue);
                                }
                            }, PaddingKt.m1729paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, Dp.m8823constructorimpl(2), 0.0f, 11, null), false, null, null, null, ComposableSingletons$MDEditorFunKt.INSTANCE.m9957getLambda$383700030$app_productionPFast(), composerStartRestartGroup, 1572912, 60);
                            composerStartRestartGroup.endReplaceGroup();
                            ua.k0 k0Var = ua.k0.f43947a;
                        } else {
                            composerStartRestartGroup.startReplaceGroup(-1392241574);
                            composerStartRestartGroup.endReplaceGroup();
                            ua.k0 k0Var2 = ua.k0.f43947a;
                            textFieldValue = mutableState;
                        }
                        break;
                    case -955995399:
                        y0Var = y0Var2;
                        state = state3;
                        state2 = state4;
                        i11 = i12;
                        c10 = 4;
                        if (str.equals("Divider")) {
                            composerStartRestartGroup.startReplaceGroup(-1409434050);
                            float f10 = 8;
                            Composer composer2 = composerStartRestartGroup;
                            DividerKt.m2630DivideroMI9zvI(SizeKt.m1774width3ABfNKs(SizeKt.m1755height3ABfNKs(PaddingKt.m1729paddingqDBjuR0$default(Modifier.INSTANCE, Dp.m8823constructorimpl(f10), Dp.m8823constructorimpl(12), Dp.m8823constructorimpl(f10), 0.0f, 8, null), Dp.m8823constructorimpl(20)), Dp.m8823constructorimpl(2)), Color.m5865copywmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnBackground(), 0.3f, 0.0f, 0.0f, 0.0f, 14, null), 0.0f, 0.0f, composer2, 0, 12);
                            composerStartRestartGroup = composer2;
                            composerStartRestartGroup.endReplaceGroup();
                            ua.k0 k0Var3 = ua.k0.f43947a;
                        } else {
                            composerStartRestartGroup.startReplaceGroup(-1392241574);
                            composerStartRestartGroup.endReplaceGroup();
                            ua.k0 k0Var4 = ua.k0.f43947a;
                        }
                        textFieldValue = mutableState;
                        break;
                    case -638311290:
                        y0Var = y0Var2;
                        state = state3;
                        state2 = state4;
                        i11 = i12;
                        c10 = 4;
                        if (str.equals("ListNumbered")) {
                            composerStartRestartGroup.startReplaceGroup(-1569201737);
                            lb.a aVar = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.pubEditor.r0
                                @Override // lb.a
                                public final Object invoke() {
                                    return MDEditorFunKt.MDEditorFun$lambda$0$5$0$10(state5, state, y0Var, state2, mutableState);
                                }
                            };
                            state = state;
                            y0Var = y0Var;
                            c10 = 4;
                            IconButtonKt.IconButton(aVar, PaddingKt.m1729paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, Dp.m8823constructorimpl(2), 0.0f, 11, null), false, null, null, null, ComposableSingletons$MDEditorFunKt.INSTANCE.m9958getLambda$391667732$app_productionPFast(), composerStartRestartGroup, 1572912, 60);
                            composerStartRestartGroup.endReplaceGroup();
                            ua.k0 k0Var5 = ua.k0.f43947a;
                        } else {
                            composerStartRestartGroup.startReplaceGroup(-1392241574);
                            composerStartRestartGroup.endReplaceGroup();
                            ua.k0 k0Var6 = ua.k0.f43947a;
                        }
                        textFieldValue = mutableState;
                        break;
                    case 84:
                        y0Var = y0Var2;
                        state = state3;
                        state2 = state4;
                        i11 = i12;
                        c10 = 4;
                        if (str.equals(ExifInterface.GPS_DIRECTION_TRUE)) {
                            composerStartRestartGroup.startReplaceGroup(-1569323589);
                            c10 = 4;
                            IconButtonKt.IconButton(new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.pubEditor.o0
                                @Override // lb.a
                                public final Object invoke() {
                                    return MDEditorFunKt.MDEditorFun$lambda$0$5$0$7(state5, y0Var, state, state2, mutableState);
                                }
                            }, PaddingKt.m1729paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, Dp.m8823constructorimpl(2), 0.0f, 11, null), false, null, null, null, ComposableSingletons$MDEditorFunKt.INSTANCE.getLambda$933065728$app_productionPFast(), composerStartRestartGroup, 1572912, 60);
                            composerStartRestartGroup.endReplaceGroup();
                            ua.k0 k0Var7 = ua.k0.f43947a;
                        } else {
                            composerStartRestartGroup.startReplaceGroup(-1392241574);
                            composerStartRestartGroup.endReplaceGroup();
                            ua.k0 k0Var8 = ua.k0.f43947a;
                        }
                        textFieldValue = mutableState;
                        break;
                    case 2281:
                        y0Var = y0Var2;
                        state = state3;
                        state2 = state4;
                        i11 = i12;
                        c10 = 4;
                        if (str.equals("H1")) {
                            composerStartRestartGroup.startReplaceGroup(-1569747996);
                            lb.a aVar2 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.pubEditor.j0
                                @Override // lb.a
                                public final Object invoke() {
                                    return MDEditorFunKt.MDEditorFun$lambda$0$5$0$1(state5, state, y0Var, state2, mutableState);
                                }
                            };
                            state = state;
                            y0Var = y0Var;
                            c10 = 4;
                            IconButtonKt.IconButton(aVar2, null, false, null, null, null, ComposableSingletons$MDEditorFunKt.INSTANCE.getLambda$619352871$app_productionPFast(), composerStartRestartGroup, 1572864, 62);
                            composerStartRestartGroup.endReplaceGroup();
                            ua.k0 k0Var9 = ua.k0.f43947a;
                        } else {
                            composerStartRestartGroup.startReplaceGroup(-1392241574);
                            composerStartRestartGroup.endReplaceGroup();
                            ua.k0 k0Var10 = ua.k0.f43947a;
                        }
                        textFieldValue = mutableState;
                        break;
                    case 2282:
                        y0Var = y0Var2;
                        state = state3;
                        state2 = state4;
                        i11 = i12;
                        c10 = 4;
                        if (str.equals("H2")) {
                            composerStartRestartGroup.startReplaceGroup(-1569660093);
                            lb.a aVar3 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.pubEditor.k0
                                @Override // lb.a
                                public final Object invoke() {
                                    return MDEditorFunKt.MDEditorFun$lambda$0$5$0$2(state5, state, y0Var, state2, mutableState);
                                }
                            };
                            state = state;
                            y0Var = y0Var;
                            c10 = 4;
                            IconButtonKt.IconButton(aVar3, null, false, null, null, null, ComposableSingletons$MDEditorFunKt.INSTANCE.getLambda$1277735750$app_productionPFast(), composerStartRestartGroup, 1572864, 62);
                            composerStartRestartGroup.endReplaceGroup();
                            ua.k0 k0Var11 = ua.k0.f43947a;
                        } else {
                            composerStartRestartGroup.startReplaceGroup(-1392241574);
                            composerStartRestartGroup.endReplaceGroup();
                            ua.k0 k0Var12 = ua.k0.f43947a;
                        }
                        textFieldValue = mutableState;
                        break;
                    case 2283:
                        y0Var = y0Var2;
                        state = state3;
                        state2 = state4;
                        i11 = i12;
                        c10 = 4;
                        if (str.equals("H3")) {
                            composerStartRestartGroup.startReplaceGroup(-1569572249);
                            lb.a aVar4 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.pubEditor.l0
                                @Override // lb.a
                                public final Object invoke() {
                                    return MDEditorFunKt.MDEditorFun$lambda$0$5$0$3(state5, state, y0Var, state2, mutableState);
                                }
                            };
                            state = state;
                            y0Var = y0Var;
                            c10 = 4;
                            IconButtonKt.IconButton(aVar4, null, false, null, null, null, ComposableSingletons$MDEditorFunKt.INSTANCE.getLambda$1936118629$app_productionPFast(), composerStartRestartGroup, 1572864, 62);
                            composerStartRestartGroup.endReplaceGroup();
                            ua.k0 k0Var13 = ua.k0.f43947a;
                        } else {
                            composerStartRestartGroup.startReplaceGroup(-1392241574);
                            composerStartRestartGroup.endReplaceGroup();
                            ua.k0 k0Var14 = ua.k0.f43947a;
                        }
                        textFieldValue = mutableState;
                        break;
                    case 2076325:
                        y0Var = y0Var2;
                        state = state3;
                        state2 = state4;
                        i11 = i12;
                        c10 = 4;
                        if (str.equals("Bold")) {
                            composerStartRestartGroup.startReplaceGroup(-1569470897);
                            c10 = 4;
                            IconButtonKt.IconButton(new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.pubEditor.m0
                                @Override // lb.a
                                public final Object invoke() {
                                    return MDEditorFunKt.MDEditorFun$lambda$0$5$0$4(state5, y0Var, state, state2, mutableState);
                                }
                            }, PaddingKt.m1729paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, Dp.m8823constructorimpl(2), 0.0f, 11, null), false, null, null, null, ComposableSingletons$MDEditorFunKt.INSTANCE.m9954getLambda$1042082909$app_productionPFast(), composerStartRestartGroup, 1572912, 60);
                            composerStartRestartGroup.endReplaceGroup();
                            ua.k0 k0Var15 = ua.k0.f43947a;
                        } else {
                            composerStartRestartGroup.startReplaceGroup(-1392241574);
                            composerStartRestartGroup.endReplaceGroup();
                            ua.k0 k0Var16 = ua.k0.f43947a;
                        }
                        textFieldValue = mutableState;
                        break;
                    case 2105869:
                        y0Var = y0Var2;
                        state = state3;
                        state2 = state4;
                        i11 = i12;
                        c10 = 4;
                        if (str.equals("Code")) {
                            composerStartRestartGroup.startReplaceGroup(-1568974781);
                            c10 = 4;
                            IconButtonKt.IconButton(new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.pubEditor.u0
                                @Override // lb.a
                                public final Object invoke() {
                                    return MDEditorFunKt.MDEditorFun$lambda$0$5$0$13(state5, y0Var, state, state2, mutableState);
                                }
                            }, PaddingKt.m1729paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, Dp.m8823constructorimpl(8), 0.0f, 11, null), false, null, null, null, ComposableSingletons$MDEditorFunKt.INSTANCE.getLambda$1583480905$app_productionPFast(), composerStartRestartGroup, 1572912, 60);
                            composerStartRestartGroup.endReplaceGroup();
                            ua.k0 k0Var17 = ua.k0.f43947a;
                        } else {
                            composerStartRestartGroup.startReplaceGroup(-1392241574);
                            composerStartRestartGroup.endReplaceGroup();
                            ua.k0 k0Var18 = ua.k0.f43947a;
                        }
                        textFieldValue = mutableState;
                        break;
                    case 2368538:
                        y0Var = y0Var2;
                        state = state3;
                        state2 = state4;
                        i11 = i12;
                        c11 = 4;
                        if (str.equals("Link")) {
                            composerStartRestartGroup.startReplaceGroup(-1569025446);
                            c10 = 4;
                            IconButtonKt.IconButton(new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.pubEditor.t0
                                @Override // lb.a
                                public final Object invoke() {
                                    return MDEditorFunKt.MDEditorFun$lambda$0$5$0$12(state5, y0Var, state, state2, textFieldValue);
                                }
                            }, PaddingKt.m1729paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, Dp.m8823constructorimpl(8), 0.0f, 11, null), false, null, null, null, ComposableSingletons$MDEditorFunKt.INSTANCE.getLambda$925098026$app_productionPFast(), composerStartRestartGroup, 1572912, 60);
                            composerStartRestartGroup.endReplaceGroup();
                            ua.k0 k0Var19 = ua.k0.f43947a;
                        } else {
                            c10 = c11;
                            composerStartRestartGroup.startReplaceGroup(-1392241574);
                            composerStartRestartGroup.endReplaceGroup();
                            ua.k0 k0Var110 = ua.k0.f43947a;
                        }
                        textFieldValue = mutableState;
                        break;
                    case 3321844:
                        y0Var = y0Var2;
                        state = state3;
                        state2 = state4;
                        i11 = i12;
                        c11 = 4;
                        if (str.equals("line")) {
                            composerStartRestartGroup.startReplaceGroup(-1569276512);
                            IconButtonKt.IconButton(new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.pubEditor.p0
                                @Override // lb.a
                                public final Object invoke() {
                                    return MDEditorFunKt.MDEditorFun$lambda$0$5$0$8(y0Var, state, state2, textFieldValue);
                                }
                            }, PaddingKt.m1729paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, Dp.m8823constructorimpl(2), 0.0f, 11, null), false, null, null, null, ComposableSingletons$MDEditorFunKt.INSTANCE.getLambda$1591448607$app_productionPFast(), composerStartRestartGroup, 1572912, 60);
                            composerStartRestartGroup.endReplaceGroup();
                            ua.k0 k0Var20 = ua.k0.f43947a;
                        } else {
                            c10 = c11;
                            composerStartRestartGroup.startReplaceGroup(-1392241574);
                            composerStartRestartGroup.endReplaceGroup();
                            ua.k0 k0Var111 = ua.k0.f43947a;
                            textFieldValue = mutableState;
                        }
                        break;
                    case 65193513:
                        y0Var = y0Var2;
                        state = state3;
                        state2 = state4;
                        i11 = i12;
                        c11 = 4;
                        if (str.equals("Clean")) {
                            composerStartRestartGroup.startReplaceGroup(-1569769840);
                            IconButtonKt.IconButton(new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.pubEditor.i0
                                @Override // lb.a
                                public final Object invoke() {
                                    return MDEditorFunKt.MDEditorFun$lambda$0$5$0$0(y0Var, textFieldValue);
                                }
                            }, null, false, null, null, null, ComposableSingletons$MDEditorFunKt.INSTANCE.m9956getLambda$1576111490$app_productionPFast(), composerStartRestartGroup, 1572864, 62);
                            composerStartRestartGroup.endReplaceGroup();
                            ua.k0 k0Var21 = ua.k0.f43947a;
                        } else {
                            c10 = c11;
                            composerStartRestartGroup.startReplaceGroup(-1392241574);
                            composerStartRestartGroup.endReplaceGroup();
                            ua.k0 k0Var112 = ua.k0.f43947a;
                            textFieldValue = mutableState;
                        }
                        break;
                    case 107953788:
                        y0Var = y0Var2;
                        state = state3;
                        state2 = state4;
                        i11 = i12;
                        c10 = 4;
                        if (str.equals("quote")) {
                            composerStartRestartGroup.startReplaceGroup(-1569251284);
                            textFieldValue = mutableState;
                            IconButtonKt.IconButton(new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.pubEditor.q0
                                @Override // lb.a
                                public final Object invoke() {
                                    return MDEditorFunKt.MDEditorFun$lambda$0$5$0$9(state5, y0Var, state, state2, textFieldValue);
                                }
                            }, PaddingKt.m1729paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, Dp.m8823constructorimpl(2), 0.0f, 11, null), false, null, null, null, ComposableSingletons$MDEditorFunKt.INSTANCE.m9955getLambda$1050050611$app_productionPFast(), composerStartRestartGroup, 1572912, 60);
                            composerStartRestartGroup.endReplaceGroup();
                            ua.k0 k0Var22 = ua.k0.f43947a;
                        } else {
                            composerStartRestartGroup.startReplaceGroup(-1392241574);
                            composerStartRestartGroup.endReplaceGroup();
                            ua.k0 k0Var113 = ua.k0.f43947a;
                            textFieldValue = mutableState;
                        }
                        break;
                    case 1152091445:
                        y0Var = y0Var2;
                        state = state3;
                        state2 = state4;
                        i11 = i12;
                        c11 = 4;
                        if (str.equals("BoldItalic")) {
                            composerStartRestartGroup.startReplaceGroup(-1569372518);
                            c10 = 4;
                            IconButtonKt.IconButton(new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.pubEditor.n0
                                @Override // lb.a
                                public final Object invoke() {
                                    return MDEditorFunKt.MDEditorFun$lambda$0$5$0$6(state5, y0Var, state, state2, mutableState);
                                }
                            }, PaddingKt.m1729paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, Dp.m8823constructorimpl(2), 0.0f, 11, null), false, null, null, null, ComposableSingletons$MDEditorFunKt.INSTANCE.getLambda$274682849$app_productionPFast(), composerStartRestartGroup, 1572912, 60);
                            composerStartRestartGroup.endReplaceGroup();
                            ua.k0 k0Var23 = ua.k0.f43947a;
                        } else {
                            c10 = c11;
                            composerStartRestartGroup.startReplaceGroup(-1392241574);
                            composerStartRestartGroup.endReplaceGroup();
                            ua.k0 k0Var114 = ua.k0.f43947a;
                        }
                        textFieldValue = mutableState;
                        break;
                    case 1872523088:
                        if (str.equals("ListBulled")) {
                            composerStartRestartGroup.startReplaceGroup(-1569112656);
                            final State state6 = state3;
                            state2 = state4;
                            lb.a aVar5 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.pubEditor.s0
                                @Override // lb.a
                                public final Object invoke() {
                                    return MDEditorFunKt.MDEditorFun$lambda$0$5$0$11(state5, state6, y0Var2, state2, textFieldValue);
                                }
                            };
                            kotlin.jvm.internal.y0 y0Var3 = y0Var2;
                            state = state6;
                            y0Var = y0Var3;
                            i11 = i12;
                            IconButtonKt.IconButton(aVar5, PaddingKt.m1729paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, Dp.m8823constructorimpl(8), 0.0f, 11, null), false, null, null, null, ComposableSingletons$MDEditorFunKt.INSTANCE.getLambda$266715147$app_productionPFast(), composerStartRestartGroup, 1572912, 60);
                            composerStartRestartGroup.endReplaceGroup();
                            ua.k0 k0Var24 = ua.k0.f43947a;
                        }
                        textFieldValue = mutableState;
                    default:
                        y0Var = y0Var2;
                        state = state3;
                        state2 = state4;
                        i11 = i12;
                        c10 = 4;
                        composerStartRestartGroup.startReplaceGroup(-1392241574);
                        composerStartRestartGroup.endReplaceGroup();
                        ua.k0 k0Var115 = ua.k0.f43947a;
                        textFieldValue = mutableState;
                        break;
                }
                state4 = state2;
                i12 = i11;
                state3 = state;
                y0Var2 = y0Var;
            }
            composerStartRestartGroup.endReplaceGroup();
            composerStartRestartGroup.endNode();
            TextFieldValue value = textFieldValue.getValue();
            Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(PaddingKt.m1725padding3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(8)), 0.0f, 1, null);
            boolean z10 = (i12 & 14) == 4;
            Object objRememberedValue6 = composerStartRestartGroup.rememberedValue();
            if (z10 || objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue6 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.pubEditor.v0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return MDEditorFunKt.MDEditorFun$lambda$0$6$0(textFieldValue, (TextFieldValue) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
            }
            Composer composer3 = composerStartRestartGroup;
            OutlinedTextFieldKt.OutlinedTextField(value, (Function1) objRememberedValue6, modifierFillMaxSize$default, false, false, (TextStyle) null, ComposableSingletons$MDEditorFunKt.INSTANCE.getLambda$1844921282$app_productionPFast(), (Function2) null, (Function2) null, (Function2) null, (Function2) null, (Function2) null, (Function2) null, false, (VisualTransformation) null, (KeyboardOptions) null, (KeyboardActions) null, false, 0, 0, (MutableInteractionSource) null, (Shape) null, (TextFieldColors) null, composer3, 1573248, 0, 0, 8388536);
            composerStartRestartGroup = composer3;
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.pubEditor.f0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return MDEditorFunKt.MDEditorFun$lambda$1(textFieldValue, i10, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AnnotatedString MDEditorFun$lambda$0$1$0(MutableState mutableState, int i10) {
        return TextFieldValueKt.getTextBeforeSelection((TextFieldValue) mutableState.getValue(), i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AnnotatedString MDEditorFun$lambda$0$2$0(MutableState mutableState, int i10) {
        return TextFieldValueKt.getTextAfterSelection((TextFieldValue) mutableState.getValue(), i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AnnotatedString MDEditorFun$lambda$0$3$0(MutableState mutableState) {
        return TextFieldValueKt.getSelectedText((TextFieldValue) mutableState.getValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 MDEditorFun$lambda$0$5$0$0(kotlin.jvm.internal.y0 y0Var, MutableState mutableState) {
        y0Var.f36634c = "";
        mutableState.setValue(new TextFieldValue((String) y0Var.f36634c, 0L, (TextRange) null, 6, (kotlin.jvm.internal.p) null));
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 MDEditorFun$lambda$0$5$0$1(State state, State state2, kotlin.jvm.internal.y0 y0Var, State state3, MutableState mutableState) {
        if (((CharSequence) state.getValue()).length() == 0) {
            if (((CharSequence) state2.getValue()).length() == 0) {
                y0Var.f36634c = ((AnnotatedString) state2.getValue()).getText() + "# [Title] \n" + ((AnnotatedString) state3.getValue()).getText();
                mutableState.setValue(new TextFieldValue((String) y0Var.f36634c, TextRangeKt.TextRange(((AnnotatedString) state2.getValue()).length() + 2, ((AnnotatedString) state2.getValue()).length() + 9), (TextRange) null, 4, (kotlin.jvm.internal.p) null));
            } else {
                y0Var.f36634c = ((AnnotatedString) state2.getValue()).getText() + "\n# [Title]" + ((AnnotatedString) state3.getValue()).getText();
                mutableState.setValue(new TextFieldValue((String) y0Var.f36634c, TextRangeKt.TextRange(((AnnotatedString) state2.getValue()).length() + 3, ((AnnotatedString) state2.getValue()).length() + 10), (TextRange) null, 4, (kotlin.jvm.internal.p) null));
            }
        } else if (((CharSequence) state2.getValue()).length() == 0) {
            y0Var.f36634c = ((AnnotatedString) state2.getValue()).getText() + "# " + ((AnnotatedString) state.getValue()).getText() + "\n" + ((AnnotatedString) state3.getValue()).getText();
            mutableState.setValue(new TextFieldValue((String) y0Var.f36634c, TextRangeKt.TextRange(((AnnotatedString) state2.getValue()).length() + ((AnnotatedString) state.getValue()).length() + 3), (TextRange) null, 4, (kotlin.jvm.internal.p) null));
        } else {
            y0Var.f36634c = ((AnnotatedString) state2.getValue()).getText() + "\n# " + ((AnnotatedString) state.getValue()).getText() + "\n" + ((AnnotatedString) state3.getValue()).getText();
            mutableState.setValue(new TextFieldValue((String) y0Var.f36634c, TextRangeKt.TextRange(((AnnotatedString) state2.getValue()).length() + ((AnnotatedString) state.getValue()).length() + 4), (TextRange) null, 4, (kotlin.jvm.internal.p) null));
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 MDEditorFun$lambda$0$5$0$10(State state, State state2, kotlin.jvm.internal.y0 y0Var, State state3, MutableState mutableState) {
        if (((CharSequence) state.getValue()).length() == 0) {
            if (((CharSequence) state2.getValue()).length() == 0) {
                y0Var.f36634c = ((AnnotatedString) state2.getValue()).getText() + "1. [texto]\n" + ((AnnotatedString) state3.getValue()).getText();
                mutableState.setValue(new TextFieldValue((String) y0Var.f36634c, TextRangeKt.TextRange(((AnnotatedString) state2.getValue()).length() + 3, ((AnnotatedString) state2.getValue()).length() + 10), (TextRange) null, 4, (kotlin.jvm.internal.p) null));
            } else {
                y0Var.f36634c = ((AnnotatedString) state2.getValue()).getText() + "\n1. [texto]\n" + ((AnnotatedString) state3.getValue()).getText();
                mutableState.setValue(new TextFieldValue((String) y0Var.f36634c, TextRangeKt.TextRange(((AnnotatedString) state2.getValue()).length() + 4, ((AnnotatedString) state2.getValue()).length() + 11), (TextRange) null, 4, (kotlin.jvm.internal.p) null));
            }
        } else if (((CharSequence) state2.getValue()).length() == 0) {
            y0Var.f36634c = ((AnnotatedString) state2.getValue()).getText() + "1. " + ((AnnotatedString) state.getValue()).getText() + "\n" + ((AnnotatedString) state3.getValue()).getText();
            mutableState.setValue(new TextFieldValue((String) y0Var.f36634c, TextRangeKt.TextRange(((AnnotatedString) state2.getValue()).length() + ((AnnotatedString) state.getValue()).length() + 4), (TextRange) null, 4, (kotlin.jvm.internal.p) null));
        } else {
            y0Var.f36634c = ((AnnotatedString) state2.getValue()).getText() + "\n1. " + ((AnnotatedString) state.getValue()).getText() + "\n" + ((AnnotatedString) state3.getValue()).getText();
            mutableState.setValue(new TextFieldValue((String) y0Var.f36634c, TextRangeKt.TextRange(((AnnotatedString) state2.getValue()).length() + ((AnnotatedString) state.getValue()).length() + 5), (TextRange) null, 4, (kotlin.jvm.internal.p) null));
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 MDEditorFun$lambda$0$5$0$11(State state, State state2, kotlin.jvm.internal.y0 y0Var, State state3, MutableState mutableState) {
        if (((CharSequence) state.getValue()).length() == 0) {
            if (((CharSequence) state2.getValue()).length() == 0) {
                y0Var.f36634c = ((AnnotatedString) state2.getValue()).getText() + "+ [texto]\n" + ((AnnotatedString) state3.getValue()).getText();
                mutableState.setValue(new TextFieldValue((String) y0Var.f36634c, TextRangeKt.TextRange(((AnnotatedString) state2.getValue()).length() + 2, ((AnnotatedString) state2.getValue()).length() + 9), (TextRange) null, 4, (kotlin.jvm.internal.p) null));
            } else {
                y0Var.f36634c = ((AnnotatedString) state2.getValue()).getText() + "\n+ [texto]\n" + ((AnnotatedString) state3.getValue()).getText();
                mutableState.setValue(new TextFieldValue((String) y0Var.f36634c, TextRangeKt.TextRange(((AnnotatedString) state2.getValue()).length() + 3, ((AnnotatedString) state2.getValue()).length() + 10), (TextRange) null, 4, (kotlin.jvm.internal.p) null));
            }
        } else if (((CharSequence) state2.getValue()).length() == 0) {
            y0Var.f36634c = ((AnnotatedString) state2.getValue()).getText() + "+ " + ((AnnotatedString) state.getValue()).getText() + "\n" + ((AnnotatedString) state3.getValue()).getText();
            mutableState.setValue(new TextFieldValue((String) y0Var.f36634c, TextRangeKt.TextRange(((AnnotatedString) state2.getValue()).length() + ((AnnotatedString) state.getValue()).length() + 3), (TextRange) null, 4, (kotlin.jvm.internal.p) null));
        } else {
            y0Var.f36634c = ((AnnotatedString) state2.getValue()).getText() + "\n+ " + ((AnnotatedString) state.getValue()).getText() + "\n" + ((AnnotatedString) state3.getValue()).getText();
            mutableState.setValue(new TextFieldValue((String) y0Var.f36634c, TextRangeKt.TextRange(((AnnotatedString) state2.getValue()).length() + ((AnnotatedString) state.getValue()).length() + 4), (TextRange) null, 4, (kotlin.jvm.internal.p) null));
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 MDEditorFun$lambda$0$5$0$12(State state, kotlin.jvm.internal.y0 y0Var, State state2, State state3, MutableState mutableState) {
        if (((CharSequence) state.getValue()).length() == 0) {
            y0Var.f36634c = ((AnnotatedString) state2.getValue()).getText() + "[texto](http://www.todus.cu)" + state3.getValue();
            mutableState.setValue(new TextFieldValue((String) y0Var.f36634c, TextRangeKt.TextRange(((AnnotatedString) state2.getValue()).length() + 1, ((AnnotatedString) state2.getValue()).length() + 6), (TextRange) null, 4, (kotlin.jvm.internal.p) null));
        } else {
            y0Var.f36634c = ((AnnotatedString) state2.getValue()).getText() + "[" + state.getValue() + "](http://www.todus.cu)" + state3.getValue();
            mutableState.setValue(new TextFieldValue((String) y0Var.f36634c, TextRangeKt.TextRange(((AnnotatedString) state2.getValue()).length() + ((AnnotatedString) state.getValue()).length() + 10, ((AnnotatedString) state2.getValue()).length() + ((AnnotatedString) state.getValue()).length() + 22), (TextRange) null, 4, (kotlin.jvm.internal.p) null));
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 MDEditorFun$lambda$0$5$0$13(State state, kotlin.jvm.internal.y0 y0Var, State state2, State state3, MutableState mutableState) {
        if (((CharSequence) state.getValue()).length() == 0) {
            y0Var.f36634c = ((AnnotatedString) state2.getValue()).getText() + "\n``\n[type code]\n``\n" + state3.getValue();
            mutableState.setValue(new TextFieldValue((String) y0Var.f36634c, TextRangeKt.TextRange(((AnnotatedString) state2.getValue()).length() + 4, ((AnnotatedString) state2.getValue()).length() + 15), (TextRange) null, 4, (kotlin.jvm.internal.p) null));
        } else {
            y0Var.f36634c = ((AnnotatedString) state2.getValue()).getText() + "\n``\n" + state.getValue() + "\n``\n" + state3.getValue();
            mutableState.setValue(new TextFieldValue((String) y0Var.f36634c, TextRangeKt.TextRange(((AnnotatedString) state2.getValue()).length() + ((AnnotatedString) state.getValue()).length() + 6), (TextRange) null, 4, (kotlin.jvm.internal.p) null));
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 MDEditorFun$lambda$0$5$0$2(State state, State state2, kotlin.jvm.internal.y0 y0Var, State state3, MutableState mutableState) {
        if (((CharSequence) state.getValue()).length() == 0) {
            if (((CharSequence) state2.getValue()).length() == 0) {
                y0Var.f36634c = ((AnnotatedString) state2.getValue()).getText() + "## [Title]\n" + ((AnnotatedString) state3.getValue()).getText();
                mutableState.setValue(new TextFieldValue((String) y0Var.f36634c, TextRangeKt.TextRange(((AnnotatedString) state2.getValue()).length() + 3, ((AnnotatedString) state2.getValue()).length() + 10), (TextRange) null, 4, (kotlin.jvm.internal.p) null));
            } else {
                y0Var.f36634c = ((AnnotatedString) state2.getValue()).getText() + "\n## [Title]\n" + ((AnnotatedString) state3.getValue()).getText();
                mutableState.setValue(new TextFieldValue((String) y0Var.f36634c, TextRangeKt.TextRange(((AnnotatedString) state2.getValue()).length() + 4, ((AnnotatedString) state2.getValue()).length() + 11), (TextRange) null, 4, (kotlin.jvm.internal.p) null));
            }
        } else if (((CharSequence) state2.getValue()).length() == 0) {
            y0Var.f36634c = ((AnnotatedString) state2.getValue()).getText() + "## " + ((AnnotatedString) state.getValue()).getText() + "\n" + ((AnnotatedString) state3.getValue()).getText();
            mutableState.setValue(new TextFieldValue((String) y0Var.f36634c, TextRangeKt.TextRange(((AnnotatedString) state2.getValue()).length() + ((AnnotatedString) state.getValue()).length() + 4), (TextRange) null, 4, (kotlin.jvm.internal.p) null));
        } else {
            y0Var.f36634c = ((AnnotatedString) state2.getValue()).getText() + "\n## " + ((AnnotatedString) state.getValue()).getText() + "\n" + ((AnnotatedString) state3.getValue()).getText();
            mutableState.setValue(new TextFieldValue((String) y0Var.f36634c, TextRangeKt.TextRange(((AnnotatedString) state2.getValue()).length() + ((AnnotatedString) state.getValue()).length() + 5), (TextRange) null, 4, (kotlin.jvm.internal.p) null));
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 MDEditorFun$lambda$0$5$0$3(State state, State state2, kotlin.jvm.internal.y0 y0Var, State state3, MutableState mutableState) {
        if (((CharSequence) state.getValue()).length() == 0) {
            if (((CharSequence) state2.getValue()).length() == 0) {
                y0Var.f36634c = ((AnnotatedString) state2.getValue()).getText() + "### [Title]\n" + ((AnnotatedString) state3.getValue()).getText();
                mutableState.setValue(new TextFieldValue((String) y0Var.f36634c, TextRangeKt.TextRange(((AnnotatedString) state2.getValue()).length() + 4, ((AnnotatedString) state2.getValue()).length() + 11), (TextRange) null, 4, (kotlin.jvm.internal.p) null));
            } else {
                y0Var.f36634c = ((AnnotatedString) state2.getValue()).getText() + "\n### [Title]\n" + ((AnnotatedString) state3.getValue()).getText();
                mutableState.setValue(new TextFieldValue((String) y0Var.f36634c, TextRangeKt.TextRange(((AnnotatedString) state2.getValue()).length() + 5, ((AnnotatedString) state2.getValue()).length() + 12), (TextRange) null, 4, (kotlin.jvm.internal.p) null));
            }
        } else if (((CharSequence) state2.getValue()).length() == 0) {
            y0Var.f36634c = ((AnnotatedString) state2.getValue()).getText() + "### " + ((AnnotatedString) state.getValue()).getText() + "\n" + ((AnnotatedString) state3.getValue()).getText();
            mutableState.setValue(new TextFieldValue((String) y0Var.f36634c, TextRangeKt.TextRange(((AnnotatedString) state2.getValue()).length() + ((AnnotatedString) state.getValue()).length() + 5), (TextRange) null, 4, (kotlin.jvm.internal.p) null));
        } else {
            y0Var.f36634c = ((AnnotatedString) state2.getValue()).getText() + "\n### " + ((AnnotatedString) state.getValue()).getText() + "\n" + ((AnnotatedString) state3.getValue()).getText();
            mutableState.setValue(new TextFieldValue((String) y0Var.f36634c, TextRangeKt.TextRange(((AnnotatedString) state2.getValue()).length() + ((AnnotatedString) state.getValue()).length() + 6), (TextRange) null, 4, (kotlin.jvm.internal.p) null));
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 MDEditorFun$lambda$0$5$0$4(State state, kotlin.jvm.internal.y0 y0Var, State state2, State state3, MutableState mutableState) {
        if (((CharSequence) state.getValue()).length() == 0) {
            y0Var.f36634c = ((AnnotatedString) state2.getValue()).getText() + " **[texto]** " + ((AnnotatedString) state3.getValue()).getText() + ((AnnotatedString) state3.getValue()).getText();
            mutableState.setValue(new TextFieldValue((String) y0Var.f36634c, TextRangeKt.TextRange(((AnnotatedString) state2.getValue()).length() + 3, ((AnnotatedString) state2.getValue()).length() + 10), (TextRange) null, 4, (kotlin.jvm.internal.p) null));
        } else {
            y0Var.f36634c = ((AnnotatedString) state2.getValue()).getText() + " **" + ((AnnotatedString) state.getValue()).getText() + "** " + ((AnnotatedString) state3.getValue()).getText();
            mutableState.setValue(new TextFieldValue((String) y0Var.f36634c, TextRangeKt.TextRange(((AnnotatedString) state2.getValue()).length() + ((AnnotatedString) state.getValue()).length() + 4), (TextRange) null, 4, (kotlin.jvm.internal.p) null));
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 MDEditorFun$lambda$0$5$0$5(State state, kotlin.jvm.internal.y0 y0Var, State state2, State state3, MutableState mutableState) {
        if (((CharSequence) state.getValue()).length() == 0) {
            y0Var.f36634c = ((AnnotatedString) state2.getValue()).getText() + " *[texto]* " + ((AnnotatedString) state3.getValue()).getText();
            mutableState.setValue(new TextFieldValue((String) y0Var.f36634c, TextRangeKt.TextRange(((AnnotatedString) state2.getValue()).length() + 2, ((AnnotatedString) state2.getValue()).length() + 9), (TextRange) null, 4, (kotlin.jvm.internal.p) null));
        } else {
            y0Var.f36634c = ((AnnotatedString) state2.getValue()).getText() + " *" + ((AnnotatedString) state.getValue()).getText() + "* " + ((AnnotatedString) state3.getValue()).getText();
            mutableState.setValue(new TextFieldValue((String) y0Var.f36634c, TextRangeKt.TextRange(((AnnotatedString) state2.getValue()).length() + ((AnnotatedString) state.getValue()).length() + 5), (TextRange) null, 4, (kotlin.jvm.internal.p) null));
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 MDEditorFun$lambda$0$5$0$6(State state, kotlin.jvm.internal.y0 y0Var, State state2, State state3, MutableState mutableState) {
        if (((CharSequence) state.getValue()).length() == 0) {
            y0Var.f36634c = ((AnnotatedString) state2.getValue()).getText() + " ***[texto]***" + ((AnnotatedString) state3.getValue()).getText();
            mutableState.setValue(new TextFieldValue((String) y0Var.f36634c, TextRangeKt.TextRange(((AnnotatedString) state2.getValue()).length() + 4, ((AnnotatedString) state2.getValue()).length() + 11), (TextRange) null, 4, (kotlin.jvm.internal.p) null));
        } else {
            y0Var.f36634c = ((AnnotatedString) state2.getValue()).getText() + "***" + ((AnnotatedString) state.getValue()).getText() + "***" + ((AnnotatedString) state3.getValue()).getText();
            mutableState.setValue(new TextFieldValue((String) y0Var.f36634c, TextRangeKt.TextRange(((AnnotatedString) state2.getValue()).length() + ((AnnotatedString) state.getValue()).length() + 6), (TextRange) null, 4, (kotlin.jvm.internal.p) null));
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 MDEditorFun$lambda$0$5$0$7(State state, kotlin.jvm.internal.y0 y0Var, State state2, State state3, MutableState mutableState) {
        if (((CharSequence) state.getValue()).length() == 0) {
            y0Var.f36634c = ((AnnotatedString) state2.getValue()).getText() + " ~~[texto]~~" + ((AnnotatedString) state3.getValue()).getText();
            mutableState.setValue(new TextFieldValue((String) y0Var.f36634c, TextRangeKt.TextRange(((AnnotatedString) state2.getValue()).length() + 3, ((AnnotatedString) state2.getValue()).length() + 10), (TextRange) null, 4, (kotlin.jvm.internal.p) null));
        } else {
            y0Var.f36634c = ((AnnotatedString) state2.getValue()).getText() + "~~" + ((AnnotatedString) state.getValue()).getText() + "~~" + ((AnnotatedString) state3.getValue()).getText();
            mutableState.setValue(new TextFieldValue((String) y0Var.f36634c, TextRangeKt.TextRange(((AnnotatedString) state2.getValue()).length() + ((AnnotatedString) state.getValue()).length() + 4), (TextRange) null, 4, (kotlin.jvm.internal.p) null));
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 MDEditorFun$lambda$0$5$0$8(kotlin.jvm.internal.y0 y0Var, State state, State state2, MutableState mutableState) {
        y0Var.f36634c = ((AnnotatedString) state.getValue()).getText() + "\n\n---\n\n" + ((AnnotatedString) state2.getValue()).getText();
        mutableState.setValue(new TextFieldValue((String) y0Var.f36634c, TextRangeKt.TextRange(((AnnotatedString) state.getValue()).length() + 7), (TextRange) null, 4, (kotlin.jvm.internal.p) null));
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 MDEditorFun$lambda$0$5$0$9(State state, kotlin.jvm.internal.y0 y0Var, State state2, State state3, MutableState mutableState) {
        if (((CharSequence) state.getValue()).length() == 0) {
            y0Var.f36634c = ((AnnotatedString) state2.getValue()).getText() + "\n> [texto]" + ((AnnotatedString) state3.getValue()).getText();
            mutableState.setValue(new TextFieldValue((String) y0Var.f36634c, TextRangeKt.TextRange(((AnnotatedString) state2.getValue()).length() + 3, ((AnnotatedString) state2.getValue()).length() + 10), (TextRange) null, 4, (kotlin.jvm.internal.p) null));
        } else {
            y0Var.f36634c = ((AnnotatedString) state2.getValue()).getText() + "\n> " + ((AnnotatedString) state.getValue()).getText() + "\n" + ((AnnotatedString) state3.getValue()).getText();
            mutableState.setValue(new TextFieldValue((String) y0Var.f36634c, TextRangeKt.TextRange(((AnnotatedString) state2.getValue()).length() + ((AnnotatedString) state.getValue()).length() + 4), (TextRange) null, 4, (kotlin.jvm.internal.p) null));
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 MDEditorFun$lambda$0$6$0(MutableState mutableState, TextFieldValue it) {
        kotlin.jvm.internal.y.i(it, "it");
        mutableState.setValue(it);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 MDEditorFun$lambda$1(MutableState mutableState, int i10, Composer composer, int i11) {
        MDEditorFun(mutableState, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1));
        return ua.k0.f43947a;
    }
}
