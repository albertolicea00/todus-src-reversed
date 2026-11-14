package cu.z17.views.pickerDateTime;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material3.DatePickerKt;
import androidx.compose.material3.DatePickerState;
import androidx.compose.material3.TimePickerKt;
import androidx.compose.material3.TimePickerState;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import androidx.media3.exoplayer.RendererCapabilities;
import cu.z17.views.R;
import cu.z17.views.button.Z17ButtonsKt;
import cu.z17.views.dialogs.Z17DialogsKt;
import cu.z17.views.pickerDateTime.Z17PickerDateTimeKt;
import defpackage.r;
import java.util.Calendar;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.y;
import lb.a;
import lb.p;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u001aQ\u0010\b\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022*\u0010\u0007\u001a&\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u0005H\u0007¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"", "show", "Lkotlin/Function0;", "Lua/k0;", "onCancel", "Lkotlin/Function5;", "", "onSelected", "Z17PickerDateTime", "(ZLlb/a;Llb/p;Landroidx/compose/runtime/Composer;I)V", "views_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class Z17PickerDateTimeKt {
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void Z17PickerDateTime(final boolean z10, final a onCancel, final p onSelected, Composer composer, final int i10) {
        int i11;
        Composer composer2;
        y.i(onCancel, "onCancel");
        y.i(onSelected, "onSelected");
        Composer composerStartRestartGroup = composer.startRestartGroup(-822378008);
        if ((i10 & 6) == 0) {
            i11 = (composerStartRestartGroup.changed(z10) ? 4 : 2) | i10;
        } else {
            i11 = i10;
        }
        if ((i10 & 48) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(onCancel) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(onSelected) ? 256 : 128;
        }
        if (composerStartRestartGroup.shouldExecute((i11 & 147) != 146, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-822378008, i11, -1, "cu.z17.views.pickerDateTime.Z17PickerDateTime (Z17PickerDateTime.kt:31)");
            }
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (objRememberedValue == companion.getEmpty()) {
                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(new Date().getTime());
                calendar.add(6, 1);
                objRememberedValue = Long.valueOf(calendar.getTimeInMillis());
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final long jLongValue = ((Number) objRememberedValue).longValue();
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.TRUE, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            final MutableState mutableState = (MutableState) objRememberedValue2;
            final DatePickerState datePickerStateM3133rememberDatePickerStateEU0dCGE = DatePickerKt.m3133rememberDatePickerStateEU0dCGE(Long.valueOf(jLongValue), null, null, 0, null, composerStartRestartGroup, 6, 30);
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == companion.getEmpty()) {
                objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            final MutableState mutableState2 = (MutableState) objRememberedValue3;
            final TimePickerState timePickerStateRememberTimePickerState = TimePickerKt.rememberTimePickerState(0, 0, false, composerStartRestartGroup, 0, 7);
            composer2 = composerStartRestartGroup;
            if (z10) {
                composer2.startReplaceGroup(-968955404);
                boolean zBooleanValue = ((Boolean) mutableState.getValue()).booleanValue();
                Object objRememberedValue4 = composer2.rememberedValue();
                if (objRememberedValue4 == companion.getEmpty()) {
                    objRememberedValue4 = new a() { // from class: o9.c
                        @Override // lb.a
                        public final Object invoke() {
                            return Z17PickerDateTimeKt.Z17PickerDateTime$lambda$4$lambda$3(mutableState);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue4);
                }
                Z17DialogsKt.Z17CustomDialog(zBooleanValue, (a) objRememberedValue4, ComposableLambdaKt.rememberComposableLambda(871248159, true, new Function3() { // from class: o9.d
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return Z17PickerDateTimeKt.Z17PickerDateTime$lambda$11(datePickerStateM3133rememberDatePickerStateEU0dCGE, onCancel, mutableState, mutableState2, (lb.a) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composer2, 54), composer2, 432);
                boolean zBooleanValue2 = ((Boolean) mutableState2.getValue()).booleanValue();
                Object objRememberedValue5 = composer2.rememberedValue();
                if (objRememberedValue5 == companion.getEmpty()) {
                    objRememberedValue5 = new a() { // from class: o9.e
                        @Override // lb.a
                        public final Object invoke() {
                            return Z17PickerDateTimeKt.Z17PickerDateTime$lambda$13$lambda$12(mutableState2);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue5);
                }
                Z17DialogsKt.Z17CustomDialog(zBooleanValue2, (a) objRememberedValue5, ComposableLambdaKt.rememberComposableLambda(-7635256, true, new Function3() { // from class: o9.f
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return Z17PickerDateTimeKt.Z17PickerDateTime$lambda$20(timePickerStateRememberTimePickerState, onCancel, datePickerStateM3133rememberDatePickerStateEU0dCGE, onSelected, mutableState2, jLongValue, (lb.a) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composer2, 54), composer2, 432);
            } else {
                composer2.startReplaceGroup(-970818566);
            }
            composer2.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: o9.g
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return Z17PickerDateTimeKt.Z17PickerDateTime$lambda$21(z10, onCancel, onSelected, i10, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 Z17PickerDateTime$lambda$11(DatePickerState datePickerState, final a aVar, final MutableState mutableState, final MutableState mutableState2, a it, Composer composer, int i10) {
        y.i(it, "it");
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(871248159, i10, -1, "cu.z17.views.pickerDateTime.Z17PickerDateTime.<anonymous> (Z17PickerDateTime.kt:58)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            Arrangement arrangement = Arrangement.INSTANCE;
            Arrangement.Vertical top = arrangement.getTop();
            Alignment.Companion companion2 = Alignment.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(top, companion2.getStart(), composer, 0);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, companion);
            ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
            a constructor = companion3.getConstructor();
            if (!r.a(composer.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor);
            } else {
                composer.useNode();
            }
            Composer composerM5176constructorimpl = Updater.m5176constructorimpl(composer);
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyColumnMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash = companion3.getSetCompositeKeyHash();
            if (composerM5176constructorimpl.getInserting() || !y.d(composerM5176constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion3.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            DatePickerKt.DatePicker(datePickerState, SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), null, null, null, false, null, composer, 27696, 100);
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null);
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getEnd(), companion2.getTop(), composer, 6);
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer, modifierFillMaxWidth$default);
            a constructor2 = companion3.getConstructor();
            if (!r.a(composer.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor2);
            } else {
                composer.useNode();
            }
            Composer composerM5176constructorimpl2 = Updater.m5176constructorimpl(composer);
            Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyRowMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash2 = companion3.getSetCompositeKeyHash();
            if (composerM5176constructorimpl2.getInserting() || !y.d(composerM5176constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                composerM5176constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                composerM5176constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier2, companion3.getSetModifier());
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            String strStringResource = StringResources_androidKt.stringResource(R.string.cancel, composer, 0);
            boolean zChanged = composer.changed(aVar);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new a() { // from class: o9.h
                    @Override // lb.a
                    public final Object invoke() {
                        return Z17PickerDateTimeKt.Z17PickerDateTime$lambda$11$lambda$10$lambda$9$lambda$6$lambda$5(mutableState, aVar);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            Z17ButtonsKt.Z17SecondaryDialogButton(null, (a) objRememberedValue, strStringResource, null, false, false, false, composer, 0, 121);
            SpacerKt.Spacer(SizeKt.m1774width3ABfNKs(companion, Dp.m8823constructorimpl(10)), composer, 6);
            String strStringResource2 = StringResources_androidKt.stringResource(R.string.continue_label, composer, 0);
            Object objRememberedValue2 = composer.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new a() { // from class: o9.i
                    @Override // lb.a
                    public final Object invoke() {
                        return Z17PickerDateTimeKt.Z17PickerDateTime$lambda$11$lambda$10$lambda$9$lambda$8$lambda$7(mutableState, mutableState2);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            Z17ButtonsKt.Z17PrimaryDialogButton(null, (a) objRememberedValue2, strStringResource2, null, false, false, false, composer, 48, 121);
            composer.endNode();
            composer.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 Z17PickerDateTime$lambda$11$lambda$10$lambda$9$lambda$6$lambda$5(MutableState mutableState, a aVar) {
        mutableState.setValue(Boolean.FALSE);
        aVar.invoke();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 Z17PickerDateTime$lambda$11$lambda$10$lambda$9$lambda$8$lambda$7(MutableState mutableState, MutableState mutableState2) {
        mutableState.setValue(Boolean.FALSE);
        mutableState2.setValue(Boolean.TRUE);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 Z17PickerDateTime$lambda$13$lambda$12(MutableState mutableState) {
        mutableState.setValue(Boolean.FALSE);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 Z17PickerDateTime$lambda$20(final TimePickerState timePickerState, final a aVar, final DatePickerState datePickerState, final p pVar, MutableState mutableState, final long j10, a it, Composer composer, int i10) {
        final MutableState mutableState2;
        y.i(it, "it");
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-7635256, i10, -1, "cu.z17.views.pickerDateTime.Z17PickerDateTime.<anonymous> (Z17PickerDateTime.kt:93)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            Arrangement arrangement = Arrangement.INSTANCE;
            Arrangement.Vertical top = arrangement.getTop();
            Alignment.Companion companion2 = Alignment.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(top, companion2.getStart(), composer, 0);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, companion);
            ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
            a constructor = companion3.getConstructor();
            if (!r.a(composer.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor);
            } else {
                composer.useNode();
            }
            Composer composerM5176constructorimpl = Updater.m5176constructorimpl(composer);
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyColumnMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash = companion3.getSetCompositeKeyHash();
            if (composerM5176constructorimpl.getInserting() || !y.d(composerM5176constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion3.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            TimePickerKt.m3890TimePickermT9BvqQ(timePickerState, null, null, 0, composer, 0, 14);
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null);
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getEnd(), companion2.getTop(), composer, 6);
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer, modifierFillMaxWidth$default);
            a constructor2 = companion3.getConstructor();
            if (!r.a(composer.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor2);
            } else {
                composer.useNode();
            }
            Composer composerM5176constructorimpl2 = Updater.m5176constructorimpl(composer);
            Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyRowMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash2 = companion3.getSetCompositeKeyHash();
            if (composerM5176constructorimpl2.getInserting() || !y.d(composerM5176constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                composerM5176constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                composerM5176constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier2, companion3.getSetModifier());
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            String strStringResource = StringResources_androidKt.stringResource(R.string.cancel, composer, 0);
            boolean zChanged = composer.changed(aVar);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                mutableState2 = mutableState;
                objRememberedValue = new a() { // from class: o9.a
                    @Override // lb.a
                    public final Object invoke() {
                        return Z17PickerDateTimeKt.Z17PickerDateTime$lambda$20$lambda$19$lambda$18$lambda$15$lambda$14(mutableState2, aVar);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            } else {
                mutableState2 = mutableState;
            }
            Z17ButtonsKt.Z17SecondaryDialogButton(null, (a) objRememberedValue, strStringResource, null, false, false, false, composer, 0, 121);
            SpacerKt.Spacer(SizeKt.m1774width3ABfNKs(companion, Dp.m8823constructorimpl(10)), composer, 6);
            String strStringResource2 = StringResources_androidKt.stringResource(R.string.ok, composer, 0);
            boolean zChanged2 = composer.changed(datePickerState) | composer.changed(pVar) | composer.changedInstance(timePickerState);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                a aVar2 = new a() { // from class: o9.b
                    @Override // lb.a
                    public final Object invoke() {
                        return Z17PickerDateTimeKt.Z17PickerDateTime$lambda$20$lambda$19$lambda$18$lambda$17$lambda$16(mutableState2, datePickerState, j10, pVar, timePickerState);
                    }
                };
                composer.updateRememberedValue(aVar2);
                objRememberedValue2 = aVar2;
            }
            Z17ButtonsKt.Z17PrimaryDialogButton(null, (a) objRememberedValue2, strStringResource2, null, false, false, false, composer, 0, 121);
            composer.endNode();
            composer.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 Z17PickerDateTime$lambda$20$lambda$19$lambda$18$lambda$15$lambda$14(MutableState mutableState, a aVar) {
        mutableState.setValue(Boolean.FALSE);
        aVar.invoke();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 Z17PickerDateTime$lambda$20$lambda$19$lambda$18$lambda$17$lambda$16(MutableState mutableState, DatePickerState datePickerState, long j10, p pVar, TimePickerState timePickerState) {
        mutableState.setValue(Boolean.FALSE);
        Calendar calendar = Calendar.getInstance();
        Long selectedDateMillis = datePickerState.getSelectedDateMillis();
        if (selectedDateMillis != null) {
            j10 = selectedDateMillis.longValue();
        }
        calendar.setTime(new Date(j10));
        int i10 = calendar.get(5);
        pVar.invoke(Integer.valueOf(calendar.get(1)), Integer.valueOf(calendar.get(2) + 1), Integer.valueOf(i10), Integer.valueOf(timePickerState.getHour()), Integer.valueOf(timePickerState.getMinute()));
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 Z17PickerDateTime$lambda$21(boolean z10, a aVar, p pVar, int i10, Composer composer, int i11) {
        Z17PickerDateTime(z10, aVar, pVar, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1));
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 Z17PickerDateTime$lambda$4$lambda$3(MutableState mutableState) {
        mutableState.setValue(Boolean.FALSE);
        return k0.f43947a;
    }
}
