package cu.z17.views.spinner;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.AndroidMenu_androidKt;
import androidx.compose.material3.ExposedDropdownMenuBoxScope;
import androidx.compose.material3.ExposedDropdownMenu_androidKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.MenuAnchorType;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.exoplayer.RendererCapabilities;
import cu.z17.views.label.Z17LabelKt;
import cu.z17.views.spinner.Z17SpinnerKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.y;
import lb.a;
import ua.k0;
import va.w;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\u001aS\u0010\r\u001a\u00020\u00072\b\b\u0002\u0010\u0001\u001a\u00020\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\t2\b\b\u0002\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\r\u0010\u000e\u001ag\u0010\u0012\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u000f2\b\b\u0002\u0010\u0001\u001a\u00020\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00070\u00052\u0006\u0010\u0010\u001a\u00028\u00002\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0016²\u0006\u000e\u0010\u0015\u001a\u00020\u00148\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\u0015\u001a\u00020\u00148\n@\nX\u008a\u008e\u0002"}, d2 = {"Landroidx/compose/ui/Modifier;", "modifier", "", "Lcu/z17/views/spinner/Z17NameIdItem;", "options", "Lkotlin/Function1;", "", "Lua/k0;", "handleSelection", "Landroidx/compose/runtime/MutableState;", "selectedOptionText", "Landroidx/compose/ui/text/TextStyle;", "style", "Z17Spinner", "(Landroidx/compose/ui/Modifier;Ljava/util/List;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/MutableState;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/runtime/Composer;II)V", ExifInterface.GPS_DIRECTION_TRUE, "selectedOption", "getTitle", "Z17Spinner2", "(Landroidx/compose/ui/Modifier;Ljava/util/List;Lkotlin/jvm/functions/Function1;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/runtime/Composer;II)V", "", "expanded", "views_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class Z17SpinnerKt {
    /* JADX WARN: Code duplicated, block: B:67:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:70:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:73:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:76:0x0129  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void Z17Spinner(Modifier modifier, final List<Z17NameIdItem> options, final Function1 handleSelection, final MutableState<String> selectedOptionText, TextStyle textStyle, Composer composer, final int i10, final int i11) {
        int i12;
        TextStyle textStyle2;
        final Modifier modifier2;
        final TextStyle textStyle3;
        final TextStyle titleSmall;
        Modifier modifier3;
        int i13;
        Object objRememberedValue;
        Composer.Companion companion;
        final MutableState mutableState;
        Object objRememberedValue2;
        y.i(options, "options");
        y.i(handleSelection, "handleSelection");
        y.i(selectedOptionText, "selectedOptionText");
        Composer composerStartRestartGroup = composer.startRestartGroup(2038446586);
        int i14 = i11 & 1;
        if (i14 != 0) {
            i12 = i10 | 6;
        } else if ((i10 & 6) == 0) {
            i12 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i10;
        } else {
            i12 = i10;
        }
        if ((i10 & 48) == 0) {
            i12 |= composerStartRestartGroup.changedInstance(options) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i12 |= composerStartRestartGroup.changedInstance(handleSelection) ? 256 : 128;
        }
        if ((i10 & 3072) == 0) {
            i12 |= composerStartRestartGroup.changed(selectedOptionText) ? 2048 : 1024;
        }
        if ((i10 & 24576) == 0) {
            if ((i11 & 16) == 0) {
                textStyle2 = textStyle;
                int i15 = composerStartRestartGroup.changed(textStyle2) ? 16384 : 8192;
                i12 |= i15;
            } else {
                textStyle2 = textStyle;
            }
            i12 |= i15;
        } else {
            textStyle2 = textStyle;
        }
        if (composerStartRestartGroup.shouldExecute((i12 & 9363) != 9362, i12 & 1)) {
            composerStartRestartGroup.startDefaults();
            if ((i10 & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                if (i14 != 0) {
                    modifier = Modifier.INSTANCE;
                }
                if ((i11 & 16) != 0) {
                    titleSmall = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getTitleSmall();
                    modifier3 = modifier;
                    i13 = i12 & (-57345);
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2038446586, i13, -1, "cu.z17.views.spinner.Z17Spinner (Z17Spinner.kt:25)");
                }
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                companion = Composer.INSTANCE;
                if (objRememberedValue == companion.getEmpty()) {
                    objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                mutableState = (MutableState) objRememberedValue;
                boolean zZ17Spinner$lambda$1 = Z17Spinner$lambda$1(mutableState);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == companion.getEmpty()) {
                    objRememberedValue2 = new Function1() { // from class: q9.g
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return Z17SpinnerKt.Z17Spinner$lambda$4$lambda$3(mutableState, ((Boolean) obj).booleanValue());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                ExposedDropdownMenu_androidKt.ExposedDropdownMenuBox(zZ17Spinner$lambda$1, (Function1) objRememberedValue2, modifier3, ComposableLambdaKt.rememberComposableLambda(1016615076, true, new Function3() { // from class: q9.h
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return Z17SpinnerKt.Z17Spinner$lambda$12(selectedOptionText, titleSmall, mutableState, options, handleSelection, (ExposedDropdownMenuBoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i13 << 6) & 896) | 3120, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                textStyle3 = titleSmall;
                modifier2 = modifier3;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i11 & 16) != 0) {
                    i12 &= -57345;
                }
            }
            modifier3 = modifier;
            i13 = i12;
            titleSmall = textStyle2;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2038446586, i13, -1, "cu.z17.views.spinner.Z17Spinner (Z17Spinner.kt:25)");
            }
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            companion = Composer.INSTANCE;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            mutableState = (MutableState) objRememberedValue;
            boolean zZ17Spinner$lambda$2 = Z17Spinner$lambda$1(mutableState);
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: q9.g
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Z17SpinnerKt.Z17Spinner$lambda$4$lambda$3(mutableState, ((Boolean) obj).booleanValue());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ExposedDropdownMenu_androidKt.ExposedDropdownMenuBox(zZ17Spinner$lambda$2, (Function1) objRememberedValue2, modifier3, ComposableLambdaKt.rememberComposableLambda(1016615076, true, new Function3() { // from class: q9.h
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return Z17SpinnerKt.Z17Spinner$lambda$12(selectedOptionText, titleSmall, mutableState, options, handleSelection, (ExposedDropdownMenuBoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i13 << 6) & 896) | 3120, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            textStyle3 = titleSmall;
            modifier2 = modifier3;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            modifier2 = modifier;
            textStyle3 = textStyle2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: q9.i
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return Z17SpinnerKt.Z17Spinner$lambda$13(modifier2, options, handleSelection, selectedOptionText, textStyle3, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final boolean Z17Spinner$lambda$1(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 Z17Spinner$lambda$12(final MutableState mutableState, TextStyle textStyle, final MutableState mutableState2, final List list, final Function1 function1, ExposedDropdownMenuBoxScope ExposedDropdownMenuBox, Composer composer, int i10) {
        int i11;
        y.i(ExposedDropdownMenuBox, "$this$ExposedDropdownMenuBox");
        if ((i10 & 6) == 0) {
            i11 = i10 | ((i10 & 8) == 0 ? composer.changed(ExposedDropdownMenuBox) : composer.changedInstance(ExposedDropdownMenuBox) ? 4 : 2);
        } else {
            i11 = i10;
        }
        if (composer.shouldExecute((i11 & 19) != 18, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1016615076, i11, -1, "cu.z17.views.spinner.Z17Spinner.<anonymous> (Z17Spinner.kt:35)");
            }
            String str = (String) mutableState.getValue();
            TextStyle textStyleM8271copyp1EtxEg$default = TextStyle.m8271copyp1EtxEg$default(textStyle, 0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, TextAlign.INSTANCE.m8692getCentere0LSkKk(), 0, 0L, null, null, null, 0, 0, null, 16744447, null);
            Modifier.Companion companion = Modifier.INSTANCE;
            Z17LabelKt.m10262Z17LabelfWhpE4E(SizeKt.fillMaxWidth$default(ExposedDropdownMenuBox.menuAnchor-fsE2BvY(companion, MenuAnchorType.Companion.getPrimaryNotEditable-Mg6Rgbw(), true), 0.0f, 1, null), str, textStyleM8271copyp1EtxEg$default, 0L, 0, 0, composer, 0, 56);
            Modifier modifierM1205backgroundbw27NRU$default = BackgroundKt.m1205backgroundbw27NRU$default(companion, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getBackground(), null, 2, null);
            boolean zZ17Spinner$lambda$1 = Z17Spinner$lambda$1(mutableState2);
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new a() { // from class: q9.l
                    @Override // lb.a
                    public final Object invoke() {
                        return Z17SpinnerKt.Z17Spinner$lambda$12$lambda$6$lambda$5(mutableState2);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ExposedDropdownMenuBox.m3204ExposedDropdownMenuvNxi1II(zZ17Spinner$lambda$1, (a) objRememberedValue, modifierM1205backgroundbw27NRU$default, null, false, null, 0L, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-1646954586, true, new Function3() { // from class: q9.m
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return Z17SpinnerKt.Z17Spinner$lambda$12$lambda$11(list, mutableState, function1, mutableState2, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), composer, 48, (ExposedDropdownMenuBoxScope.$stable << 3) | 6 | ((i11 << 3) & 112), 1016);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 Z17Spinner$lambda$12$lambda$11(List list, final MutableState mutableState, final Function1 function1, final MutableState mutableState2, ColumnScope ExposedDropdownMenu, Composer composer, int i10) {
        Composer composer2 = composer;
        y.i(ExposedDropdownMenu, "$this$ExposedDropdownMenu");
        int i11 = 0;
        if (composer2.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1646954586, i10, -1, "cu.z17.views.spinner.Z17Spinner.<anonymous>.<anonymous> (Z17Spinner.kt:50)");
            }
            for (Object obj : list) {
                int i12 = i11 + 1;
                if (i11 < 0) {
                    w.x();
                }
                final Z17NameIdItem z17NameIdItem = (Z17NameIdItem) obj;
                Modifier modifierM1754defaultMinSizeVpY3zN4$default = SizeKt.m1754defaultMinSizeVpY3zN4$default(Modifier.INSTANCE, Dp.m8823constructorimpl(1), 0.0f, 2, null);
                MaterialTheme materialTheme = MaterialTheme.INSTANCE;
                int i13 = MaterialTheme.$stable;
                Modifier modifierM1216borderxT4_qwU = BorderKt.m1216borderxT4_qwU(BackgroundKt.m1205backgroundbw27NRU$default(modifierM1754defaultMinSizeVpY3zN4$default, materialTheme.getColorScheme(composer2, i13).getBackground(), null, 2, null), Dp.m8823constructorimpl((float) 0.5d), materialTheme.getColorScheme(composer2, i13).getOnBackground(), RectangleShapeKt.getRectangleShape());
                ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-793596472, true, new Function2() { // from class: q9.j
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj2, Object obj3) {
                        return Z17SpinnerKt.Z17Spinner$lambda$12$lambda$11$lambda$10$lambda$7(z17NameIdItem, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composer2, 54);
                boolean zChanged = composer2.changed(mutableState) | composer2.changedInstance(z17NameIdItem) | composer2.changed(function1);
                Object objRememberedValue = composer2.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new a() { // from class: q9.k
                        @Override // lb.a
                        public final Object invoke() {
                            return Z17SpinnerKt.Z17Spinner$lambda$12$lambda$11$lambda$10$lambda$9$lambda$8(mutableState, z17NameIdItem, function1, mutableState2);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue);
                }
                AndroidMenu_androidKt.DropdownMenuItem(composableLambdaRememberComposableLambda, (a) objRememberedValue, modifierM1216borderxT4_qwU, null, null, false, null, null, null, composer2, 6, TypedValues.PositionType.TYPE_PERCENT_HEIGHT);
                composer2 = composer;
                i11 = i12;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 Z17Spinner$lambda$12$lambda$11$lambda$10$lambda$7(Z17NameIdItem z17NameIdItem, Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-793596472, i10, -1, "cu.z17.views.spinner.Z17Spinner.<anonymous>.<anonymous>.<anonymous>.<anonymous> (Z17Spinner.kt:65)");
            }
            String text = z17NameIdItem.getText();
            MaterialTheme materialTheme = MaterialTheme.INSTANCE;
            int i11 = MaterialTheme.$stable;
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, text, TextStyle.m8271copyp1EtxEg$default(materialTheme.getTypography(composer, i11).getBodyMedium(), materialTheme.getColorScheme(composer, i11).getOnSurface(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null), 0L, 0, 0, composer, 0, 57);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 Z17Spinner$lambda$12$lambda$11$lambda$10$lambda$9$lambda$8(MutableState mutableState, Z17NameIdItem z17NameIdItem, Function1 function1, MutableState mutableState2) {
        mutableState.setValue(z17NameIdItem.getText());
        Z17Spinner$lambda$2(mutableState2, false);
        function1.invoke(z17NameIdItem.getStringId());
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 Z17Spinner$lambda$12$lambda$6$lambda$5(MutableState mutableState) {
        Z17Spinner$lambda$2(mutableState, false);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 Z17Spinner$lambda$13(Modifier modifier, List list, Function1 function1, MutableState mutableState, TextStyle textStyle, int i10, int i11, Composer composer, int i12) {
        Z17Spinner(modifier, list, function1, mutableState, textStyle, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return k0.f43947a;
    }

    private static final void Z17Spinner$lambda$2(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 Z17Spinner$lambda$4$lambda$3(MutableState mutableState, boolean z10) {
        Z17Spinner$lambda$2(mutableState, !Z17Spinner$lambda$1(mutableState));
        return k0.f43947a;
    }

    /* JADX WARN: Code duplicated, block: B:77:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:80:0x0102  */
    /* JADX WARN: Code duplicated, block: B:83:0x011d  */
    /* JADX WARN: Code duplicated, block: B:86:0x014d  */
    @Composable
    public static final <T> void Z17Spinner2(Modifier modifier, final List<? extends T> options, final Function1 handleSelection, final T t10, final Function1 getTitle, TextStyle textStyle, Composer composer, final int i10, final int i11) {
        int i12;
        TextStyle textStyle2;
        final Modifier modifier2;
        final TextStyle textStyle3;
        Modifier modifier3;
        final TextStyle titleSmall;
        Object objRememberedValue;
        Composer.Companion companion;
        final MutableState mutableState;
        Object objRememberedValue2;
        y.i(options, "options");
        y.i(handleSelection, "handleSelection");
        y.i(getTitle, "getTitle");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1533916934);
        int i13 = i11 & 1;
        if (i13 != 0) {
            i12 = i10 | 6;
        } else if ((i10 & 6) == 0) {
            i12 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i10;
        } else {
            i12 = i10;
        }
        if ((i10 & 48) == 0) {
            i12 |= composerStartRestartGroup.changedInstance(options) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i12 |= composerStartRestartGroup.changedInstance(handleSelection) ? 256 : 128;
        }
        if ((i10 & 3072) == 0) {
            i12 |= (i10 & 4096) == 0 ? composerStartRestartGroup.changed(t10) : composerStartRestartGroup.changedInstance(t10) ? 2048 : 1024;
        }
        if ((i10 & 24576) == 0) {
            i12 |= composerStartRestartGroup.changedInstance(getTitle) ? 16384 : 8192;
        }
        if ((196608 & i10) == 0) {
            if ((i11 & 32) == 0) {
                textStyle2 = textStyle;
                int i14 = composerStartRestartGroup.changed(textStyle2) ? 131072 : 65536;
                i12 |= i14;
            } else {
                textStyle2 = textStyle;
            }
            i12 |= i14;
        } else {
            textStyle2 = textStyle;
        }
        if (composerStartRestartGroup.shouldExecute((74899 & i12) != 74898, i12 & 1)) {
            composerStartRestartGroup.startDefaults();
            if ((i10 & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                if (i13 != 0) {
                    modifier = Modifier.INSTANCE;
                }
                if ((i11 & 32) != 0) {
                    i12 &= -458753;
                    modifier3 = modifier;
                    titleSmall = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getTitleSmall();
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1533916934, i12, -1, "cu.z17.views.spinner.Z17Spinner2 (Z17Spinner.kt:86)");
                }
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                companion = Composer.INSTANCE;
                if (objRememberedValue == companion.getEmpty()) {
                    objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                mutableState = (MutableState) objRememberedValue;
                int i15 = i12;
                boolean zZ17Spinner2$lambda$15 = Z17Spinner2$lambda$15(mutableState);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == companion.getEmpty()) {
                    objRememberedValue2 = new Function1() { // from class: q9.n
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return Z17SpinnerKt.Z17Spinner2$lambda$18$lambda$17(mutableState, ((Boolean) obj).booleanValue());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                ExposedDropdownMenu_androidKt.ExposedDropdownMenuBox(zZ17Spinner2$lambda$15, (Function1) objRememberedValue2, modifier3, ComposableLambdaKt.rememberComposableLambda(1739218852, true, new Function3() { // from class: q9.b
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return Z17SpinnerKt.Z17Spinner2$lambda$26(getTitle, t10, titleSmall, mutableState, options, handleSelection, (ExposedDropdownMenuBoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i15 << 6) & 896) | 3120, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                textStyle3 = titleSmall;
                modifier2 = modifier3;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i11 & 32) != 0) {
                    i12 &= -458753;
                }
            }
            modifier3 = modifier;
            titleSmall = textStyle2;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1533916934, i12, -1, "cu.z17.views.spinner.Z17Spinner2 (Z17Spinner.kt:86)");
            }
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            companion = Composer.INSTANCE;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            mutableState = (MutableState) objRememberedValue;
            int i16 = i12;
            boolean zZ17Spinner2$lambda$16 = Z17Spinner2$lambda$15(mutableState);
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: q9.n
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Z17SpinnerKt.Z17Spinner2$lambda$18$lambda$17(mutableState, ((Boolean) obj).booleanValue());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ExposedDropdownMenu_androidKt.ExposedDropdownMenuBox(zZ17Spinner2$lambda$16, (Function1) objRememberedValue2, modifier3, ComposableLambdaKt.rememberComposableLambda(1739218852, true, new Function3() { // from class: q9.b
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return Z17SpinnerKt.Z17Spinner2$lambda$26(getTitle, t10, titleSmall, mutableState, options, handleSelection, (ExposedDropdownMenuBoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i16 << 6) & 896) | 3120, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            textStyle3 = titleSmall;
            modifier2 = modifier3;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            modifier2 = modifier;
            textStyle3 = textStyle2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: q9.c
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return Z17SpinnerKt.Z17Spinner2$lambda$27(modifier2, options, handleSelection, t10, getTitle, textStyle3, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final boolean Z17Spinner2$lambda$15(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void Z17Spinner2$lambda$16(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 Z17Spinner2$lambda$18$lambda$17(MutableState mutableState, boolean z10) {
        Z17Spinner2$lambda$16(mutableState, !Z17Spinner2$lambda$15(mutableState));
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 Z17Spinner2$lambda$26(final Function1 function1, Object obj, TextStyle textStyle, final MutableState mutableState, final List list, final Function1 function2, ExposedDropdownMenuBoxScope ExposedDropdownMenuBox, Composer composer, int i10) {
        int i11;
        y.i(ExposedDropdownMenuBox, "$this$ExposedDropdownMenuBox");
        if ((i10 & 6) == 0) {
            i11 = i10 | ((i10 & 8) == 0 ? composer.changed(ExposedDropdownMenuBox) : composer.changedInstance(ExposedDropdownMenuBox) ? 4 : 2);
        } else {
            i11 = i10;
        }
        if (composer.shouldExecute((i11 & 19) != 18, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1739218852, i11, -1, "cu.z17.views.spinner.Z17Spinner2.<anonymous> (Z17Spinner.kt:96)");
            }
            String str = (String) function1.invoke(obj);
            TextStyle textStyleM8271copyp1EtxEg$default = TextStyle.m8271copyp1EtxEg$default(textStyle, 0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, TextAlign.INSTANCE.m8692getCentere0LSkKk(), 0, 0L, null, null, null, 0, 0, null, 16744447, null);
            Modifier.Companion companion = Modifier.INSTANCE;
            Z17LabelKt.m10262Z17LabelfWhpE4E(SizeKt.fillMaxWidth$default(ExposedDropdownMenuBox.menuAnchor-fsE2BvY(companion, MenuAnchorType.Companion.getPrimaryNotEditable-Mg6Rgbw(), true), 0.0f, 1, null), str, textStyleM8271copyp1EtxEg$default, 0L, 0, 0, composer, 0, 56);
            Modifier modifierM1205backgroundbw27NRU$default = BackgroundKt.m1205backgroundbw27NRU$default(companion, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getBackground(), null, 2, null);
            boolean zZ17Spinner2$lambda$15 = Z17Spinner2$lambda$15(mutableState);
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new a() { // from class: q9.d
                    @Override // lb.a
                    public final Object invoke() {
                        return Z17SpinnerKt.Z17Spinner2$lambda$26$lambda$20$lambda$19(mutableState);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ExposedDropdownMenuBox.m3204ExposedDropdownMenuvNxi1II(zZ17Spinner2$lambda$15, (a) objRememberedValue, modifierM1205backgroundbw27NRU$default, null, false, null, 0L, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-924350810, true, new Function3() { // from class: q9.e
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj2, Object obj3, Object obj4) {
                    return Z17SpinnerKt.Z17Spinner2$lambda$26$lambda$25(list, function2, function1, mutableState, (ColumnScope) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                }
            }, composer, 54), composer, 48, (ExposedDropdownMenuBoxScope.$stable << 3) | 6 | ((i11 << 3) & 112), 1016);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 Z17Spinner2$lambda$26$lambda$20$lambda$19(MutableState mutableState) {
        Z17Spinner2$lambda$16(mutableState, false);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 Z17Spinner2$lambda$26$lambda$25(List list, final Function1 function1, final Function1 function2, final MutableState mutableState, ColumnScope ExposedDropdownMenu, Composer composer, int i10) {
        Composer composer2 = composer;
        y.i(ExposedDropdownMenu, "$this$ExposedDropdownMenu");
        int i11 = 0;
        if (composer2.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-924350810, i10, -1, "cu.z17.views.spinner.Z17Spinner2.<anonymous>.<anonymous> (Z17Spinner.kt:111)");
            }
            for (final Object obj : list) {
                int i12 = i11 + 1;
                if (i11 < 0) {
                    w.x();
                }
                Modifier modifierM1754defaultMinSizeVpY3zN4$default = SizeKt.m1754defaultMinSizeVpY3zN4$default(Modifier.INSTANCE, Dp.m8823constructorimpl(1), 0.0f, 2, null);
                MaterialTheme materialTheme = MaterialTheme.INSTANCE;
                int i13 = MaterialTheme.$stable;
                Modifier modifierM1216borderxT4_qwU = BorderKt.m1216borderxT4_qwU(BackgroundKt.m1205backgroundbw27NRU$default(modifierM1754defaultMinSizeVpY3zN4$default, materialTheme.getColorScheme(composer2, i13).getBackground(), null, 2, null), Dp.m8823constructorimpl((float) 0.5d), materialTheme.getColorScheme(composer2, i13).getOnBackground(), RectangleShapeKt.getRectangleShape());
                ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-267652541, true, new Function2() { // from class: q9.a
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj2, Object obj3) {
                        return Z17SpinnerKt.Z17Spinner2$lambda$26$lambda$25$lambda$24$lambda$21(function2, obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composer2, 54);
                boolean zChanged = composer2.changed(function1) | composer2.changedInstance(obj);
                Object objRememberedValue = composer2.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new a() { // from class: q9.f
                        @Override // lb.a
                        public final Object invoke() {
                            return Z17SpinnerKt.Z17Spinner2$lambda$26$lambda$25$lambda$24$lambda$23$lambda$22(function1, obj, mutableState);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue);
                }
                AndroidMenu_androidKt.DropdownMenuItem(composableLambdaRememberComposableLambda, (a) objRememberedValue, modifierM1216borderxT4_qwU, null, null, false, null, null, null, composer2, 6, TypedValues.PositionType.TYPE_PERCENT_HEIGHT);
                composer2 = composer;
                i11 = i12;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 Z17Spinner2$lambda$26$lambda$25$lambda$24$lambda$21(Function1 function1, Object obj, Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-267652541, i10, -1, "cu.z17.views.spinner.Z17Spinner2.<anonymous>.<anonymous>.<anonymous>.<anonymous> (Z17Spinner.kt:125)");
            }
            String str = (String) function1.invoke(obj);
            MaterialTheme materialTheme = MaterialTheme.INSTANCE;
            int i11 = MaterialTheme.$stable;
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, str, TextStyle.m8271copyp1EtxEg$default(materialTheme.getTypography(composer, i11).getBodyMedium(), materialTheme.getColorScheme(composer, i11).getOnSurface(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null), 0L, 0, 0, composer, 0, 57);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 Z17Spinner2$lambda$26$lambda$25$lambda$24$lambda$23$lambda$22(Function1 function1, Object obj, MutableState mutableState) {
        Z17Spinner2$lambda$16(mutableState, false);
        function1.invoke(obj);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 Z17Spinner2$lambda$27(Modifier modifier, List list, Function1 function1, Object obj, Function1 function2, TextStyle textStyle, int i10, int i11, Composer composer, int i12) {
        Z17Spinner2(modifier, list, function1, obj, function2, textStyle, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return k0.f43947a;
    }
}
