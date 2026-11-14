package cu.todus.android.uiCompose.main.screen.pubEditor;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.FlowLayoutKt;
import androidx.compose.foundation.layout.FlowRowScope;
import androidx.compose.foundation.layout.PaddingKt;
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
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
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
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001d\u0010\u0004\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Landroidx/compose/runtime/MutableState;", "Landroidx/compose/ui/text/input/TextFieldValue;", "textFieldValue", "Lua/k0;", "LateXEditorFun", "(Landroidx/compose/runtime/MutableState;Landroidx/compose/runtime/Composer;I)V", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class LateXEditorFunKt {
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void LateXEditorFun(final MutableState<TextFieldValue> textFieldValue, Composer composer, final int i10) {
        int i11;
        kotlin.jvm.internal.y.i(textFieldValue, "textFieldValue");
        Composer composerStartRestartGroup = composer.startRestartGroup(1645897186);
        if ((i10 & 6) == 0) {
            i11 = (composerStartRestartGroup.changed(textFieldValue) ? 4 : 2) | i10;
        } else {
            i11 = i10;
        }
        if (composerStartRestartGroup.shouldExecute((i11 & 3) != 2, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1645897186, i11, -1, "cu.todus.android.uiCompose.main.screen.pubEditor.LateXEditorFun (LateXEditorFun.kt:34)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
            int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
            ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
            lb.a constructor = companion2.getConstructor();
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
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyColumnMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion2.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl, companion2.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion2.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            Composer.Companion companion3 = Composer.INSTANCE;
            if (objRememberedValue == companion3.getEmpty()) {
                objRememberedValue = 8000;
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final int iIntValue = ((Number) objRememberedValue).intValue();
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == companion3.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt.derivedStateOf(new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.pubEditor.x
                    @Override // lb.a
                    public final Object invoke() {
                        return LateXEditorFunKt.LateXEditorFun$lambda$0$1$0(textFieldValue, iIntValue);
                    }
                });
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            final State state = (State) objRememberedValue2;
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == companion3.getEmpty()) {
                objRememberedValue3 = SnapshotStateKt.derivedStateOf(new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.pubEditor.y
                    @Override // lb.a
                    public final Object invoke() {
                        return LateXEditorFunKt.LateXEditorFun$lambda$0$2$0(textFieldValue, iIntValue);
                    }
                });
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            final State state2 = (State) objRememberedValue3;
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue4 == companion3.getEmpty()) {
                objRememberedValue4 = SnapshotStateKt.derivedStateOf(new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.pubEditor.z
                    @Override // lb.a
                    public final Object invoke() {
                        return LateXEditorFunKt.LateXEditorFun$lambda$0$3$0(textFieldValue);
                    }
                });
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            final State state3 = (State) objRememberedValue4;
            final kotlin.jvm.internal.y0 y0Var = new kotlin.jvm.internal.y0();
            Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue5 == companion3.getEmpty()) {
                objRememberedValue5 = va.w.q("H1", "Clean");
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            }
            final List list = (List) objRememberedValue5;
            ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-163296089, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.pubEditor.a0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return LateXEditorFunKt.LateXEditorFun$lambda$0$5(list, y0Var, textFieldValue, state, state3, state2, (FlowRowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54);
            int i12 = i11;
            FlowLayoutKt.FlowRow(null, null, null, null, 0, 0, composableLambdaRememberComposableLambda, composerStartRestartGroup, 1572864, 63);
            TextFieldValue value = textFieldValue.getValue();
            float f10 = 20;
            Modifier modifierM1725padding3ABfNKs = PaddingKt.m1725padding3ABfNKs(SizeKt.fillMaxSize$default(PaddingKt.m1727paddingVpY3zN4$default(companion, Dp.m8823constructorimpl(f10), 0.0f, 2, null), 0.0f, 1, null), Dp.m8823constructorimpl(f10));
            boolean z10 = (i12 & 14) == 4;
            Object objRememberedValue6 = composerStartRestartGroup.rememberedValue();
            if (z10 || objRememberedValue6 == companion3.getEmpty()) {
                objRememberedValue6 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.pubEditor.b0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return LateXEditorFunKt.LateXEditorFun$lambda$0$6$0(textFieldValue, (TextFieldValue) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
            }
            OutlinedTextFieldKt.OutlinedTextField(value, (Function1) objRememberedValue6, modifierM1725padding3ABfNKs, false, false, (TextStyle) null, ComposableSingletons$LateXEditorFunKt.INSTANCE.getLambda$1548794194$app_productionPFast(), (Function2) null, (Function2) null, (Function2) null, (Function2) null, (Function2) null, (Function2) null, false, (VisualTransformation) null, (KeyboardOptions) null, (KeyboardActions) null, false, 0, 0, (MutableInteractionSource) null, (Shape) null, (TextFieldColors) null, composerStartRestartGroup, 1573248, 0, 0, 8388536);
            composerStartRestartGroup = composerStartRestartGroup;
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.pubEditor.c0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return LateXEditorFunKt.LateXEditorFun$lambda$1(textFieldValue, i10, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AnnotatedString LateXEditorFun$lambda$0$1$0(MutableState mutableState, int i10) {
        return TextFieldValueKt.getTextBeforeSelection((TextFieldValue) mutableState.getValue(), i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AnnotatedString LateXEditorFun$lambda$0$2$0(MutableState mutableState, int i10) {
        return TextFieldValueKt.getTextAfterSelection((TextFieldValue) mutableState.getValue(), i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AnnotatedString LateXEditorFun$lambda$0$3$0(MutableState mutableState) {
        return TextFieldValueKt.getSelectedText((TextFieldValue) mutableState.getValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:31:0x00c1  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 LateXEditorFun$lambda$0$5(List list, final kotlin.jvm.internal.y0 y0Var, final MutableState mutableState, final State state, final State state2, final State state3, FlowRowScope FlowRow, Composer composer, int i10) {
        Composer composer2 = composer;
        kotlin.jvm.internal.y.i(FlowRow, "$this$FlowRow");
        if (composer2.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-163296089, i10, -1, "cu.todus.android.uiCompose.main.screen.pubEditor.LateXEditorFun.<anonymous>.<anonymous> (LateXEditorFun.kt:58)");
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                int iHashCode = str.hashCode();
                if (iHashCode != -955995399) {
                    if (iHashCode != 2281) {
                        if (iHashCode == 65193513 && str.equals("Clean")) {
                            composer2.startReplaceGroup(445525206);
                            IconButtonKt.IconButton(new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.pubEditor.v
                                @Override // lb.a
                                public final Object invoke() {
                                    return LateXEditorFunKt.LateXEditorFun$lambda$0$5$0$0(y0Var, mutableState, state);
                                }
                            }, null, false, null, null, null, ComposableSingletons$LateXEditorFunKt.INSTANCE.getLambda$1971341549$app_productionPFast(), composer2, 1572864, 62);
                            composer2.endReplaceGroup();
                        } else {
                            composer2.startReplaceGroup(930461611);
                            composer2.endReplaceGroup();
                        }
                    } else if (str.equals("H1")) {
                        composer2.startReplaceGroup(445555741);
                        IconButtonKt.IconButton(new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.pubEditor.w
                            @Override // lb.a
                            public final Object invoke() {
                                return LateXEditorFunKt.LateXEditorFun$lambda$0$5$0$1(state2, state, y0Var, state3, mutableState);
                            }
                        }, null, false, null, null, null, ComposableSingletons$LateXEditorFunKt.INSTANCE.m9953getLambda$2038592042$app_productionPFast(), composer2, 1572864, 62);
                        composer2.endReplaceGroup();
                    } else {
                        composer2.startReplaceGroup(930461611);
                        composer2.endReplaceGroup();
                    }
                } else if (str.equals("Divider")) {
                    composer2.startReplaceGroup(930054519);
                    float f10 = 8;
                    DividerKt.m2630DivideroMI9zvI(SizeKt.m1774width3ABfNKs(SizeKt.m1755height3ABfNKs(PaddingKt.m1729paddingqDBjuR0$default(Modifier.INSTANCE, Dp.m8823constructorimpl(f10), Dp.m8823constructorimpl(12), Dp.m8823constructorimpl(f10), 0.0f, 8, null), Dp.m8823constructorimpl(20)), Dp.m8823constructorimpl(2)), Color.m5865copywmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composer2, MaterialTheme.$stable).getOnBackground(), 0.3f, 0.0f, 0.0f, 0.0f, 14, null), 0.0f, 0.0f, composer, 0, 12);
                    composer.endReplaceGroup();
                } else {
                    composer2.startReplaceGroup(930461611);
                    composer2.endReplaceGroup();
                }
                composer2 = composer;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 LateXEditorFun$lambda$0$5$0$0(kotlin.jvm.internal.y0 y0Var, MutableState mutableState, State state) {
        y0Var.f36634c = "$$\n expresión \n$$";
        mutableState.setValue(new TextFieldValue((String) y0Var.f36634c, TextRangeKt.TextRange(((AnnotatedString) state.getValue()).length() + 4, ((AnnotatedString) state.getValue()).length() + 13), (TextRange) null, 4, (kotlin.jvm.internal.p) null));
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 LateXEditorFun$lambda$0$5$0$1(State state, State state2, kotlin.jvm.internal.y0 y0Var, State state3, MutableState mutableState) {
        if (((CharSequence) state.getValue()).length() == 0) {
            if (((CharSequence) state2.getValue()).length() == 0) {
                y0Var.f36634c = ((AnnotatedString) state2.getValue()).getText() + "# [Title]" + state3.getValue();
                mutableState.setValue(new TextFieldValue((String) y0Var.f36634c, TextRangeKt.TextRange(((AnnotatedString) state2.getValue()).length() + 2, ((AnnotatedString) state2.getValue()).length() + 9), (TextRange) null, 4, (kotlin.jvm.internal.p) null));
            } else {
                y0Var.f36634c = ((AnnotatedString) state2.getValue()).getText() + "\n# [Title]" + state3.getValue();
                mutableState.setValue(new TextFieldValue((String) y0Var.f36634c, TextRangeKt.TextRange(((AnnotatedString) state2.getValue()).length() + 3, ((AnnotatedString) state2.getValue()).length() + 10), (TextRange) null, 4, (kotlin.jvm.internal.p) null));
            }
        } else if (((CharSequence) state2.getValue()).length() == 0) {
            y0Var.f36634c = ((AnnotatedString) state2.getValue()).getText() + "# " + state + "\n" + state3.getValue();
            mutableState.setValue(new TextFieldValue((String) y0Var.f36634c, TextRangeKt.TextRange(((AnnotatedString) state2.getValue()).length() + ((AnnotatedString) state.getValue()).length() + 3), (TextRange) null, 4, (kotlin.jvm.internal.p) null));
        } else {
            y0Var.f36634c = ((AnnotatedString) state2.getValue()).getText() + "\n# " + state + "\n" + state3.getValue();
            mutableState.setValue(new TextFieldValue((String) y0Var.f36634c, TextRangeKt.TextRange(((AnnotatedString) state2.getValue()).length() + ((AnnotatedString) state.getValue()).length() + 4), (TextRange) null, 4, (kotlin.jvm.internal.p) null));
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 LateXEditorFun$lambda$0$6$0(MutableState mutableState, TextFieldValue it) {
        kotlin.jvm.internal.y.i(it, "it");
        mutableState.setValue(it);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 LateXEditorFun$lambda$1(MutableState mutableState, int i10, Composer composer, int i11) {
        LateXEditorFun(mutableState, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1));
        return ua.k0.f43947a;
    }
}
