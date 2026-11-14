package cu.z17.views.form;

import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.CheckboxKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.RadioButtonKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.compose.ui.unit.Dp;
import androidx.media3.common.C;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.profileinstaller.ProfileVerifier;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import cu.z17.views.inputText.Z17InputTextKt;
import cu.z17.views.label.Z17LabelKt;
import cu.z17.views.picture.Z17PictureKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u001ao\u0010\u0010\u001a\u00020\u00072\b\b\u0002\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u00062\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\t2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\r2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\rH\u0007¢\u0006\u0004\b\u0010\u0010\u0011\u001aE\u0010\u0019\u001a\u00020\u00072\b\b\u0002\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u000b2\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\nH\u0001¢\u0006\u0004\b\u0017\u0010\u0018\u001aE\u0010\u001b\u001a\u00020\u00072\b\b\u0002\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u000b2\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\nH\u0001¢\u0006\u0004\b\u001a\u0010\u0018\u001aC\u0010\u001e\u001a\u00020\u00072\b\b\u0002\u0010\u0001\u001a\u00020\u00002\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001c2\u0006\u0010\u0012\u001a\u00020\u000b2\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00070\u0006H\u0001¢\u0006\u0004\b\u001e\u0010\u001f\u001aC\u0010 \u001a\u00020\u00072\b\b\u0002\u0010\u0001\u001a\u00020\u00002\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001c2\u0006\u0010\u0012\u001a\u00020\u000b2\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00070\u0006H\u0001¢\u0006\u0004\b \u0010\u001f\u001ae\u0010%\u001a\u00020\u00072\b\b\u0002\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u000b2\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00070\r2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\r2\u0006\u0010$\u001a\u00020#H\u0001¢\u0006\u0004\b%\u0010&\u001ae\u0010'\u001a\u00020\u00072\b\b\u0002\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u000b2\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00070\r2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\r2\u0006\u0010$\u001a\u00020#H\u0001¢\u0006\u0004\b'\u0010&¨\u0006,²\u0006\f\u0010(\u001a\u00020\u00048\nX\u008a\u0084\u0002²\u0006\f\u0010)\u001a\u00020\u00048\nX\u008a\u0084\u0002²\u0006\f\u0010*\u001a\u00020\u00048\nX\u008a\u0084\u0002²\u0006\f\u0010+\u001a\u00020\u00048\nX\u008a\u0084\u0002"}, d2 = {"Landroidx/compose/ui/Modifier;", "modifier", "Lcu/z17/views/form/FormItemRequest;", "formItemRequest", "", "isChecked", "Lkotlin/Function1;", "Lua/k0;", "updateItem", "Lkotlin/Pair;", "", "", "cameraDisplaying", "Lkotlin/Function0;", "getImage", "clearImage", "FormItemView", "(Landroidx/compose/ui/Modifier;Lcu/z17/views/form/FormItemRequest;ZLkotlin/jvm/functions/Function1;Lkotlin/Pair;Llb/a;Llb/a;Landroidx/compose/runtime/Composer;II)V", AppMeasurementSdk.ConditionalUserProperty.VALUE, "onValueChange", "Landroidx/compose/ui/text/input/KeyboardType;", "inputType", "limit", "Field-Tu1Tvio", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;Lkotlin/jvm/functions/Function1;IILandroidx/compose/runtime/Composer;II)V", "Field", "LargeField-Tu1Tvio", "LargeField", "", "selectionList", "SingleSelection", "(Landroidx/compose/ui/Modifier;Ljava/util/List;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "MultipleSelection", "onPeakRequest", "valueInSelection", "Lcu/z17/views/form/ImageForm;", "imageForm", "ImageFiled", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Llb/a;Ljava/lang/String;Llb/a;Lcu/z17/views/form/ImageForm;Landroidx/compose/runtime/Composer;II)V", "LargeImageFiled", "showError", "showLabel", "showDescription", "isCheck", "views_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class FormItemViewKt {

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[FormItemType.values().length];
            try {
                iArr[FormItemType.NUMBER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FormItemType.TEXT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[FormItemType.IMAGE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[FormItemType.LARGE_TEXT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[FormItemType.LARGE_IMAGE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[FormItemType.SIMPLE_SELECTION.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[FormItemType.MULTIPLE_SELECTION.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[ImageForm.values().length];
            try {
                iArr2[ImageForm.CIRCLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr2[ImageForm.SQUARE.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr2[ImageForm.ROUND_CORNERS.ordinal()] = 3;
            } catch (NoSuchFieldError unused10) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* JADX INFO: renamed from: Field-Tu1Tvio, reason: not valid java name */
    public static final void m10145FieldTu1Tvio(Modifier modifier, final String value, final Function1 onValueChange, final int i10, final int i11, Composer composer, final int i12, final int i13) {
        Modifier modifier2;
        int i14;
        Composer composer2;
        final Modifier modifier3;
        kotlin.jvm.internal.y.i(value, "value");
        kotlin.jvm.internal.y.i(onValueChange, "onValueChange");
        Composer composerStartRestartGroup = composer.startRestartGroup(57444807);
        int i15 = i13 & 1;
        if (i15 != 0) {
            i14 = i12 | 6;
            modifier2 = modifier;
        } else if ((i12 & 6) == 0) {
            modifier2 = modifier;
            i14 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i12;
        } else {
            modifier2 = modifier;
            i14 = i12;
        }
        if ((i12 & 48) == 0) {
            i14 |= composerStartRestartGroup.changed(value) ? 32 : 16;
        }
        if ((i12 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i14 |= composerStartRestartGroup.changedInstance(onValueChange) ? 256 : 128;
        }
        if ((i12 & 3072) == 0) {
            i14 |= composerStartRestartGroup.changed(i10) ? 2048 : 1024;
        }
        if ((i12 & 24576) == 0) {
            i14 |= composerStartRestartGroup.changed(i11) ? 16384 : 8192;
        }
        if (composerStartRestartGroup.shouldExecute((i14 & 9363) != 9362, i14 & 1)) {
            Modifier modifier4 = i15 != 0 ? Modifier.INSTANCE : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(57444807, i14, -1, "cu.z17.views.form.Field (FormItemView.kt:201)");
            }
            composer2 = composerStartRestartGroup;
            Z17InputTextKt.m10251Z17InputTextf9_u2OI(modifier4, value, 0, 0, null, null, onValueChange, null, null, i11, i10, 0L, 0L, 0L, 0L, 0L, null, false, null, false, composer2, (i14 & 126) | ((i14 << 12) & 3670016) | ((i14 << 15) & C.ENCODING_PCM_DOUBLE), (i14 >> 9) & 14, 1046972);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            modifier3 = modifier2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.form.j
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FormItemViewKt.Field_Tu1Tvio$lambda$21(modifier3, value, onValueChange, i10, i11, i12, i13, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 Field_Tu1Tvio$lambda$21(Modifier modifier, String str, Function1 function1, int i10, int i11, int i12, int i13, Composer composer, int i14) {
        m10145FieldTu1Tvio(modifier, str, function1, i10, i11, composer, RecomposeScopeImplKt.updateChangedFlags(i12 | 1), i13);
        return ua.k0.f43947a;
    }

    /* JADX WARN: Code duplicated, block: B:242:0x0635  */
    /* JADX WARN: Code duplicated, block: B:244:0x0672  */
    /* JADX WARN: Code duplicated, block: B:247:0x067f  */
    /* JADX WARN: Code duplicated, block: B:248:0x0682  */
    /* JADX WARN: Code duplicated, block: B:252:0x0688  */
    /* JADX WARN: Code duplicated, block: B:255:0x0692  */
    /* JADX WARN: Code duplicated, block: B:257:0x0698  */
    /* JADX WARN: Code duplicated, block: B:260:0x06b3  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void FormItemView(Modifier modifier, final FormItemRequest formItemRequest, final boolean z10, final Function1 updateItem, final Pair<Integer, String> pair, final lb.a getImage, final lb.a clearImage, Composer composer, final int i10, final int i11) {
        Modifier modifier2;
        int i12;
        final Modifier modifier3;
        boolean z11;
        int i13;
        int i14;
        int i15;
        int i16;
        boolean z12;
        boolean z13;
        Object objRememberedValue;
        kotlin.jvm.internal.y.i(formItemRequest, "formItemRequest");
        kotlin.jvm.internal.y.i(updateItem, "updateItem");
        kotlin.jvm.internal.y.i(getImage, "getImage");
        kotlin.jvm.internal.y.i(clearImage, "clearImage");
        Composer composerStartRestartGroup = composer.startRestartGroup(305394498);
        int i17 = i11 & 1;
        if (i17 != 0) {
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
            i12 |= composerStartRestartGroup.changed(formItemRequest) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i12 |= composerStartRestartGroup.changed(z10) ? 256 : 128;
        }
        if ((i10 & 3072) == 0) {
            i12 |= composerStartRestartGroup.changedInstance(updateItem) ? 2048 : 1024;
        }
        if ((i10 & 24576) == 0) {
            i12 |= composerStartRestartGroup.changed(pair) ? 16384 : 8192;
        }
        if ((196608 & i10) == 0) {
            i12 |= composerStartRestartGroup.changedInstance(getImage) ? 131072 : 65536;
        }
        if ((1572864 & i10) == 0) {
            i12 |= composerStartRestartGroup.changedInstance(clearImage) ? 1048576 : 524288;
        }
        if (composerStartRestartGroup.shouldExecute((599187 & i12) != 599186, i12 & 1)) {
            Modifier modifier4 = i17 != 0 ? Modifier.INSTANCE : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(305394498, i12, -1, "cu.z17.views.form.FormItemView (FormItemView.kt:45)");
            }
            Alignment.Companion companion = Alignment.INSTANCE;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion.getTopStart(), false);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier4);
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
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash = companion2.getSetCompositeKeyHash();
            if (composerM5176constructorimpl.getInserting() || !kotlin.jvm.internal.y.d(composerM5176constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion2.getSetModifier());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            boolean z14 = (i12 & 896) == 256;
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (z14 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt.derivedStateOf(new lb.a() { // from class: cu.z17.views.form.p
                    @Override // lb.a
                    public final Object invoke() {
                        return Boolean.valueOf(FormItemViewKt.FormItemView$lambda$19$lambda$1$lambda$0(formItemRequest, z10));
                    }
                });
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            State state = (State) objRememberedValue2;
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            Composer.Companion companion3 = Composer.INSTANCE;
            if (objRememberedValue3 == companion3.getEmpty()) {
                objRememberedValue3 = SnapshotStateKt.derivedStateOf(new lb.a() { // from class: cu.z17.views.form.q
                    @Override // lb.a
                    public final Object invoke() {
                        return Boolean.valueOf(FormItemViewKt.FormItemView$lambda$19$lambda$4$lambda$3(formItemRequest));
                    }
                });
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            State state2 = (State) objRememberedValue3;
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue4 == companion3.getEmpty()) {
                objRememberedValue4 = SnapshotStateKt.derivedStateOf(new lb.a() { // from class: cu.z17.views.form.r
                    @Override // lb.a
                    public final Object invoke() {
                        return Boolean.valueOf(FormItemViewKt.FormItemView$lambda$19$lambda$7$lambda$6(formItemRequest));
                    }
                });
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            State state3 = (State) objRememberedValue4;
            Arrangement arrangement = Arrangement.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(arrangement.getTop(), companion.getStart(), composerStartRestartGroup, 0);
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier4);
            lb.a constructor2 = companion2.getConstructor();
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
            Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyColumnMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap2, companion2.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash2 = companion2.getSetCompositeKeyHash();
            if (composerM5176constructorimpl2.getInserting() || !kotlin.jvm.internal.y.d(composerM5176constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                composerM5176constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                composerM5176constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier2, companion2.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            Modifier.Companion companion4 = Modifier.INSTANCE;
            float f10 = 5;
            Modifier modifierM1729paddingqDBjuR0$default = PaddingKt.m1729paddingqDBjuR0$default(PaddingKt.m1729paddingqDBjuR0$default(companion4, Dp.m8823constructorimpl(f10), 0.0f, 0.0f, 0.0f, 14, null), 0.0f, 0.0f, 0.0f, Dp.m8823constructorimpl(f10), 7, null);
            MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(arrangement.getTop(), companion.getStart(), composerStartRestartGroup, 0);
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1729paddingqDBjuR0$default);
            lb.a constructor3 = companion2.getConstructor();
            if (!defpackage.r.a(composerStartRestartGroup.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor3);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM5176constructorimpl3 = Updater.m5176constructorimpl(composerStartRestartGroup);
            Updater.m5184setimpl(composerM5176constructorimpl3, measurePolicyColumnMeasurePolicy2, companion2.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl3, currentCompositionLocalMap3, companion2.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash3 = companion2.getSetCompositeKeyHash();
            if (composerM5176constructorimpl3.getInserting() || !kotlin.jvm.internal.y.d(composerM5176constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                composerM5176constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                composerM5176constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
            }
            Updater.m5184setimpl(composerM5176constructorimpl3, modifierMaterializeModifier3, companion2.getSetModifier());
            if (FormItemView$lambda$19$lambda$5(state2)) {
                composerStartRestartGroup.startReplaceGroup(2050101100);
                i13 = 2048;
                z11 = false;
                i14 = 32;
                Z17LabelKt.m10262Z17LabelfWhpE4E(null, formItemRequest.getLabel(), TextStyle.m8271copyp1EtxEg$default(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyLarge(), 0L, 0L, FontWeight.INSTANCE.getBlack(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777211, null), 0L, 0, 0, composerStartRestartGroup, 0, 57);
                composerStartRestartGroup = composerStartRestartGroup;
            } else {
                z11 = false;
                i13 = 2048;
                i14 = 32;
                composerStartRestartGroup.startReplaceGroup(-874387918);
            }
            composerStartRestartGroup.endReplaceGroup();
            if (FormItemView$lambda$19$lambda$8(state3)) {
                composerStartRestartGroup.startReplaceGroup(2050108942);
                Composer composer2 = composerStartRestartGroup;
                Z17LabelKt.m10262Z17LabelfWhpE4E(null, formItemRequest.getDescription(), MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodySmall(), 0L, 0, 0, composer2, 0, 57);
                composerStartRestartGroup = composer2;
            } else {
                composerStartRestartGroup.startReplaceGroup(-874387918);
            }
            composerStartRestartGroup.endReplaceGroup();
            composerStartRestartGroup.endNode();
            switch (WhenMappings.$EnumSwitchMapping$0[formItemRequest.getType().ordinal()]) {
                case 1:
                    i15 = i14;
                    i16 = i12;
                    composerStartRestartGroup.startReplaceGroup(-1981805533);
                    Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(companion4, formItemRequest.getDisplaySize());
                    String value = formItemRequest.getValue();
                    boolean z15 = ((i16 & 112) == i15) | ((i16 & 7168) == i13);
                    Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (z15 || objRememberedValue5 == companion3.getEmpty()) {
                        objRememberedValue5 = new FormItemViewKt$FormItemView$1$1$2$1(updateItem, formItemRequest);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    }
                    Composer composer3 = composerStartRestartGroup;
                    m10145FieldTu1Tvio(modifierFillMaxWidth, value, (Function1) objRememberedValue5, KeyboardType.INSTANCE.m8501getNumberPjHm6EE(), formItemRequest.getLimit(), composer3, 3072, 0);
                    composerStartRestartGroup = composer3;
                    composerStartRestartGroup.endReplaceGroup();
                    ua.k0 k0Var = ua.k0.f43947a;
                    if (FormItemView$lambda$19$lambda$2(state)) {
                        composerStartRestartGroup.startReplaceGroup(1875835414);
                        Z17LabelKt.m10262Z17LabelfWhpE4E(PaddingKt.m1729paddingqDBjuR0$default(companion4, Dp.m8823constructorimpl(f10), 0.0f, 0.0f, 0.0f, 14, null), formItemRequest.getErrorLabel(), MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodySmall(), Color.INSTANCE.m5900getRed0d7_KjU(), 0, 0, composerStartRestartGroup, 3078, 48);
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-1985340804);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    ua.k0 k0Var2 = ua.k0.f43947a;
                    if ((i16 & 112) == i15) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    z13 = z12 | ((i16 & 7168) == i13);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (z13 || objRememberedValue == companion3.getEmpty()) {
                        objRememberedValue = new FormItemViewKt$FormItemView$1$1$9$1(formItemRequest, updateItem, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    EffectsKt.LaunchedEffect(k0Var2, (Function2) objRememberedValue, composerStartRestartGroup, 6);
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endNode();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier4;
                    break;
                case 2:
                    i15 = i14;
                    i16 = i12;
                    composerStartRestartGroup.startReplaceGroup(-1981392923);
                    Modifier modifierFillMaxWidth2 = SizeKt.fillMaxWidth(companion4, formItemRequest.getDisplaySize());
                    String value2 = formItemRequest.getValue();
                    boolean z16 = ((i16 & 112) == i15) | ((i16 & 7168) == i13);
                    Object objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                    if (z16 || objRememberedValue6 == companion3.getEmpty()) {
                        objRememberedValue6 = new FormItemViewKt$FormItemView$1$1$3$1(updateItem, formItemRequest);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                    }
                    Composer composer4 = composerStartRestartGroup;
                    m10145FieldTu1Tvio(modifierFillMaxWidth2, value2, (Function1) objRememberedValue6, KeyboardType.INSTANCE.m8505getTextPjHm6EE(), formItemRequest.getLimit(), composer4, 3072, 0);
                    composerStartRestartGroup = composer4;
                    composerStartRestartGroup.endReplaceGroup();
                    ua.k0 k0Var3 = ua.k0.f43947a;
                    if (FormItemView$lambda$19$lambda$2(state)) {
                        composerStartRestartGroup.startReplaceGroup(1875835414);
                        Z17LabelKt.m10262Z17LabelfWhpE4E(PaddingKt.m1729paddingqDBjuR0$default(companion4, Dp.m8823constructorimpl(f10), 0.0f, 0.0f, 0.0f, 14, null), formItemRequest.getErrorLabel(), MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodySmall(), Color.INSTANCE.m5900getRed0d7_KjU(), 0, 0, composerStartRestartGroup, 3078, 48);
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-1985340804);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    ua.k0 k0Var4 = ua.k0.f43947a;
                    if ((i16 & 112) == i15) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    z13 = z12 | ((i16 & 7168) == i13);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (z13) {
                        objRememberedValue = new FormItemViewKt$FormItemView$1$1$9$1(formItemRequest, updateItem, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new FormItemViewKt$FormItemView$1$1$9$1(formItemRequest, updateItem, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    EffectsKt.LaunchedEffect(k0Var4, (Function2) objRememberedValue, composerStartRestartGroup, 6);
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endNode();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier4;
                    break;
                case 3:
                    i15 = i14;
                    i16 = i12;
                    composerStartRestartGroup.startReplaceGroup(-1980977306);
                    Modifier modifierFillMaxWidth3 = SizeKt.fillMaxWidth(companion4, formItemRequest.getDisplaySize());
                    String value3 = formItemRequest.getValue();
                    boolean z17 = ((i16 & 112) == i15) | ((i16 & 7168) == i13);
                    Object objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                    if (z17 || objRememberedValue7 == companion3.getEmpty()) {
                        objRememberedValue7 = new FormItemViewKt$FormItemView$1$1$4$1(updateItem, formItemRequest);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                    }
                    ImageFiled(modifierFillMaxWidth3, value3, (Function1) objRememberedValue7, getImage, pair != null ? pair.getSecond() : null, clearImage, formItemRequest.getImageForm(), composerStartRestartGroup, ((i16 >> 6) & 7168) | ((i16 >> 3) & 458752), 0);
                    composerStartRestartGroup.endReplaceGroup();
                    ua.k0 k0Var5 = ua.k0.f43947a;
                    if (FormItemView$lambda$19$lambda$2(state)) {
                        composerStartRestartGroup.startReplaceGroup(1875835414);
                        Z17LabelKt.m10262Z17LabelfWhpE4E(PaddingKt.m1729paddingqDBjuR0$default(companion4, Dp.m8823constructorimpl(f10), 0.0f, 0.0f, 0.0f, 14, null), formItemRequest.getErrorLabel(), MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodySmall(), Color.INSTANCE.m5900getRed0d7_KjU(), 0, 0, composerStartRestartGroup, 3078, 48);
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-1985340804);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    ua.k0 k0Var6 = ua.k0.f43947a;
                    if ((i16 & 112) == i15) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    z13 = z12 | ((i16 & 7168) == i13);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (z13) {
                        objRememberedValue = new FormItemViewKt$FormItemView$1$1$9$1(formItemRequest, updateItem, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new FormItemViewKt$FormItemView$1$1$9$1(formItemRequest, updateItem, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    EffectsKt.LaunchedEffect(k0Var6, (Function2) objRememberedValue, composerStartRestartGroup, 6);
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endNode();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier4;
                    break;
                case 4:
                    i15 = i14;
                    i16 = i12;
                    composerStartRestartGroup.startReplaceGroup(-1980438464);
                    Modifier modifierFillMaxWidth4 = SizeKt.fillMaxWidth(companion4, formItemRequest.getDisplaySize());
                    String value4 = formItemRequest.getValue();
                    boolean z18 = ((i16 & 112) == i15) | ((i16 & 7168) == i13);
                    Object objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                    if (z18 || objRememberedValue8 == companion3.getEmpty()) {
                        objRememberedValue8 = new FormItemViewKt$FormItemView$1$1$5$1(updateItem, formItemRequest);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                    }
                    Composer composer5 = composerStartRestartGroup;
                    m10146LargeFieldTu1Tvio(modifierFillMaxWidth4, value4, (Function1) objRememberedValue8, KeyboardType.INSTANCE.m8505getTextPjHm6EE(), formItemRequest.getLimit(), composer5, 3072, 0);
                    composerStartRestartGroup = composer5;
                    composerStartRestartGroup.endReplaceGroup();
                    ua.k0 k0Var7 = ua.k0.f43947a;
                    if (FormItemView$lambda$19$lambda$2(state)) {
                        composerStartRestartGroup.startReplaceGroup(1875835414);
                        Z17LabelKt.m10262Z17LabelfWhpE4E(PaddingKt.m1729paddingqDBjuR0$default(companion4, Dp.m8823constructorimpl(f10), 0.0f, 0.0f, 0.0f, 14, null), formItemRequest.getErrorLabel(), MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodySmall(), Color.INSTANCE.m5900getRed0d7_KjU(), 0, 0, composerStartRestartGroup, 3078, 48);
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-1985340804);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    ua.k0 k0Var8 = ua.k0.f43947a;
                    if ((i16 & 112) == i15) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    z13 = z12 | ((i16 & 7168) == i13);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (z13) {
                        objRememberedValue = new FormItemViewKt$FormItemView$1$1$9$1(formItemRequest, updateItem, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new FormItemViewKt$FormItemView$1$1$9$1(formItemRequest, updateItem, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    EffectsKt.LaunchedEffect(k0Var8, (Function2) objRememberedValue, composerStartRestartGroup, 6);
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endNode();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier4;
                    break;
                case 5:
                    composerStartRestartGroup.startReplaceGroup(-1980011935);
                    Modifier modifierFillMaxWidth5 = SizeKt.fillMaxWidth(companion4, formItemRequest.getDisplaySize());
                    String value5 = formItemRequest.getValue();
                    boolean z19 = ((i12 & 112) == i14) | ((i12 & 7168) == i13);
                    Object objRememberedValue9 = composerStartRestartGroup.rememberedValue();
                    if (z19 || objRememberedValue9 == companion3.getEmpty()) {
                        objRememberedValue9 = new FormItemViewKt$FormItemView$1$1$6$1(updateItem, formItemRequest);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
                    }
                    i15 = i14;
                    i16 = i12;
                    LargeImageFiled(modifierFillMaxWidth5, value5, (Function1) objRememberedValue9, getImage, pair != null ? pair.getSecond() : null, clearImage, formItemRequest.getImageForm(), composerStartRestartGroup, ((i12 >> 6) & 7168) | ((i12 >> 3) & 458752), 0);
                    composerStartRestartGroup.endReplaceGroup();
                    ua.k0 k0Var9 = ua.k0.f43947a;
                    if (FormItemView$lambda$19$lambda$2(state)) {
                        composerStartRestartGroup.startReplaceGroup(1875835414);
                        Z17LabelKt.m10262Z17LabelfWhpE4E(PaddingKt.m1729paddingqDBjuR0$default(companion4, Dp.m8823constructorimpl(f10), 0.0f, 0.0f, 0.0f, 14, null), formItemRequest.getErrorLabel(), MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodySmall(), Color.INSTANCE.m5900getRed0d7_KjU(), 0, 0, composerStartRestartGroup, 3078, 48);
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-1985340804);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    ua.k0 k0Var10 = ua.k0.f43947a;
                    if ((i16 & 112) == i15) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    z13 = z12 | ((i16 & 7168) == i13);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (z13) {
                        objRememberedValue = new FormItemViewKt$FormItemView$1$1$9$1(formItemRequest, updateItem, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new FormItemViewKt$FormItemView$1$1$9$1(formItemRequest, updateItem, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    EffectsKt.LaunchedEffect(k0Var10, (Function2) objRememberedValue, composerStartRestartGroup, 6);
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endNode();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier4;
                    break;
                case 6:
                    composerStartRestartGroup.startReplaceGroup(-1979463390);
                    Modifier modifierFillMaxWidth6 = SizeKt.fillMaxWidth(companion4, formItemRequest.getDisplaySize());
                    String value6 = formItemRequest.getValue();
                    List<String> selectionList = formItemRequest.getSelectionList();
                    boolean z20 = ((i12 & 112) == i14) | ((i12 & 7168) == i13);
                    Object objRememberedValue10 = composerStartRestartGroup.rememberedValue();
                    if (z20 || objRememberedValue10 == companion3.getEmpty()) {
                        objRememberedValue10 = new FormItemViewKt$FormItemView$1$1$7$1(updateItem, formItemRequest);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue10);
                    }
                    Composer composer6 = composerStartRestartGroup;
                    SingleSelection(modifierFillMaxWidth6, selectionList, value6, (Function1) objRememberedValue10, composer6, 0, 0);
                    composerStartRestartGroup = composer6;
                    composerStartRestartGroup.endReplaceGroup();
                    ua.k0 k0Var11 = ua.k0.f43947a;
                    i15 = i14;
                    i16 = i12;
                    if (FormItemView$lambda$19$lambda$2(state)) {
                        composerStartRestartGroup.startReplaceGroup(1875835414);
                        Z17LabelKt.m10262Z17LabelfWhpE4E(PaddingKt.m1729paddingqDBjuR0$default(companion4, Dp.m8823constructorimpl(f10), 0.0f, 0.0f, 0.0f, 14, null), formItemRequest.getErrorLabel(), MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodySmall(), Color.INSTANCE.m5900getRed0d7_KjU(), 0, 0, composerStartRestartGroup, 3078, 48);
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-1985340804);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    ua.k0 k0Var12 = ua.k0.f43947a;
                    if ((i16 & 112) == i15) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    z13 = z12 | ((i16 & 7168) == i13);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (z13) {
                        objRememberedValue = new FormItemViewKt$FormItemView$1$1$9$1(formItemRequest, updateItem, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new FormItemViewKt$FormItemView$1$1$9$1(formItemRequest, updateItem, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    EffectsKt.LaunchedEffect(k0Var12, (Function2) objRememberedValue, composerStartRestartGroup, 6);
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endNode();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier4;
                    break;
                case 7:
                    composerStartRestartGroup.startReplaceGroup(-1979067520);
                    Modifier modifierFillMaxWidth7 = SizeKt.fillMaxWidth(companion4, formItemRequest.getDisplaySize());
                    String value7 = formItemRequest.getValue();
                    List<String> selectionList2 = formItemRequest.getSelectionList();
                    boolean z21 = ((i12 & 112) == i14) | ((i12 & 7168) == i13 ? true : z11);
                    Object objRememberedValue11 = composerStartRestartGroup.rememberedValue();
                    if (z21 || objRememberedValue11 == companion3.getEmpty()) {
                        objRememberedValue11 = new FormItemViewKt$FormItemView$1$1$8$1(updateItem, formItemRequest);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue11);
                    }
                    Composer composer7 = composerStartRestartGroup;
                    MultipleSelection(modifierFillMaxWidth7, selectionList2, value7, (Function1) objRememberedValue11, composer7, 0, 0);
                    composerStartRestartGroup = composer7;
                    composerStartRestartGroup.endReplaceGroup();
                    ua.k0 k0Var13 = ua.k0.f43947a;
                    i15 = i14;
                    i16 = i12;
                    if (FormItemView$lambda$19$lambda$2(state)) {
                        composerStartRestartGroup.startReplaceGroup(1875835414);
                        Z17LabelKt.m10262Z17LabelfWhpE4E(PaddingKt.m1729paddingqDBjuR0$default(companion4, Dp.m8823constructorimpl(f10), 0.0f, 0.0f, 0.0f, 14, null), formItemRequest.getErrorLabel(), MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodySmall(), Color.INSTANCE.m5900getRed0d7_KjU(), 0, 0, composerStartRestartGroup, 3078, 48);
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-1985340804);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    ua.k0 k0Var14 = ua.k0.f43947a;
                    if ((i16 & 112) == i15) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    z13 = z12 | ((i16 & 7168) == i13);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (z13) {
                        objRememberedValue = new FormItemViewKt$FormItemView$1$1$9$1(formItemRequest, updateItem, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new FormItemViewKt$FormItemView$1$1$9$1(formItemRequest, updateItem, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    EffectsKt.LaunchedEffect(k0Var14, (Function2) objRememberedValue, composerStartRestartGroup, 6);
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endNode();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier4;
                    break;
                default:
                    composerStartRestartGroup.startReplaceGroup(1875734046);
                    composerStartRestartGroup.endReplaceGroup();
                    throw new ua.r();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.form.s
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FormItemViewKt.FormItemView$lambda$20(modifier3, formItemRequest, z10, updateItem, pair, getImage, clearImage, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void FormItemView$lambda$19$handleChange(Function1 function1, FormItemRequest formItemRequest, String str) {
        function1.invoke(FormItemRequest.copy$default(formItemRequest, null, null, null, null, str, null, null, 0, 0.0f, null, null, 2031, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean FormItemView$lambda$19$lambda$1$lambda$0(FormItemRequest formItemRequest, boolean z10) {
        if (kotlin.jvm.internal.y.d(formItemRequest.getOkRegex(), "")) {
            return false;
        }
        if (kotlin.jvm.internal.y.d(formItemRequest.getOkRegex(), UtilRegex.CANNOT_BE_EMPTY)) {
            return z10 && le.d0.q0(formItemRequest.getValue());
        }
        return z10 && !new le.m(formItemRequest.getOkRegex()).k(formItemRequest.getValue());
    }

    private static final boolean FormItemView$lambda$19$lambda$2(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean FormItemView$lambda$19$lambda$4$lambda$3(FormItemRequest formItemRequest) {
        return !le.d0.q0(formItemRequest.getLabel());
    }

    private static final boolean FormItemView$lambda$19$lambda$5(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean FormItemView$lambda$19$lambda$7$lambda$6(FormItemRequest formItemRequest) {
        return !le.d0.q0(formItemRequest.getDescription());
    }

    private static final boolean FormItemView$lambda$19$lambda$8(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 FormItemView$lambda$20(Modifier modifier, FormItemRequest formItemRequest, boolean z10, Function1 function1, Pair pair, lb.a aVar, lb.a aVar2, int i10, int i11, Composer composer, int i12) {
        FormItemView(modifier, formItemRequest, z10, function1, pair, aVar, aVar2, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return ua.k0.f43947a;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x01b8  */
    /* JADX WARN: Code duplicated, block: B:101:0x01c2  */
    /* JADX WARN: Code duplicated, block: B:103:0x01c8  */
    /* JADX WARN: Code duplicated, block: B:104:0x01cd  */
    /* JADX WARN: Code duplicated, block: B:107:0x01e7  */
    /* JADX WARN: Code duplicated, block: B:108:0x01e9  */
    /* JADX WARN: Code duplicated, block: B:113:0x01f8  */
    /* JADX WARN: Code duplicated, block: B:116:0x0218  */
    /* JADX WARN: Code duplicated, block: B:118:0x0220  */
    /* JADX WARN: Code duplicated, block: B:121:0x024c  */
    /* JADX WARN: Code duplicated, block: B:122:0x024f  */
    /* JADX WARN: Code duplicated, block: B:125:0x0257  */
    /* JADX WARN: Code duplicated, block: B:126:0x025a  */
    /* JADX WARN: Code duplicated, block: B:129:0x0264  */
    /* JADX WARN: Code duplicated, block: B:130:0x0267  */
    /* JADX WARN: Code duplicated, block: B:137:0x027c  */
    /* JADX WARN: Code duplicated, block: B:140:0x0299  */
    /* JADX WARN: Code duplicated, block: B:142:0x02a0  */
    /* JADX WARN: Code duplicated, block: B:145:0x02ac  */
    /* JADX WARN: Code duplicated, block: B:147:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:47:0x009e  */
    /* JADX WARN: Code duplicated, block: B:49:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:50:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:54:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:56:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:57:0x00be  */
    /* JADX WARN: Code duplicated, block: B:61:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:62:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:65:0x00da A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:66:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:67:0x00df  */
    /* JADX WARN: Code duplicated, block: B:69:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:72:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:75:0x0116  */
    /* JADX WARN: Code duplicated, block: B:78:0x0122  */
    /* JADX WARN: Code duplicated, block: B:79:0x0126  */
    /* JADX WARN: Code duplicated, block: B:84:0x0153  */
    /* JADX WARN: Code duplicated, block: B:87:0x0184  */
    /* JADX WARN: Code duplicated, block: B:89:0x0187 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:90:0x0189  */
    /* JADX WARN: Code duplicated, block: B:91:0x0193  */
    /* JADX WARN: Code duplicated, block: B:93:0x0199  */
    /* JADX WARN: Code duplicated, block: B:94:0x019e  */
    /* JADX WARN: Code duplicated, block: B:97:0x01b3  */
    /* JADX WARN: Code duplicated, block: B:99:0x01b6 A[DONT_INVERT] */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void ImageFiled(Modifier modifier, final String value, Function1 function1, final lb.a onPeakRequest, String str, final lb.a clearImage, final ImageForm imageForm, Composer composer, final int i10, final int i11) {
        int i12;
        String str2;
        int i13;
        boolean z10;
        final Modifier modifier2;
        final String str3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier modifier3;
        int currentCompositeKeyHash;
        lb.a constructor;
        Composer composerM5176constructorimpl;
        Function2 setCompositeKeyHash;
        int i14;
        Shape circleShape;
        int i15;
        Shape circleShape2;
        boolean z11;
        Object objRememberedValue;
        ContentScale inside;
        String str4;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        Object objRememberedValue2;
        int i16;
        int i17;
        Function1 onValueChange = function1;
        kotlin.jvm.internal.y.i(value, "value");
        kotlin.jvm.internal.y.i(onValueChange, "onValueChange");
        kotlin.jvm.internal.y.i(onPeakRequest, "onPeakRequest");
        kotlin.jvm.internal.y.i(clearImage, "clearImage");
        kotlin.jvm.internal.y.i(imageForm, "imageForm");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1910252008);
        int i18 = i11 & 1;
        if (i18 != 0) {
            i12 = i10 | 6;
        } else if ((i10 & 6) == 0) {
            i12 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i10;
        } else {
            i12 = i10;
        }
        if ((i10 & 48) == 0) {
            i12 |= composerStartRestartGroup.changed(value) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i12 |= composerStartRestartGroup.changedInstance(onValueChange) ? 256 : 128;
        }
        if ((i10 & 3072) == 0) {
            i12 |= composerStartRestartGroup.changedInstance(onPeakRequest) ? 2048 : 1024;
        }
        int i19 = i11 & 16;
        if (i19 == 0) {
            if ((i10 & 24576) == 0) {
                str2 = str;
                i12 |= composerStartRestartGroup.changed(str2) ? 16384 : 8192;
            }
            if ((i10 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                if (composerStartRestartGroup.changedInstance(clearImage)) {
                    i17 = 131072;
                } else {
                    i17 = 65536;
                }
                i12 |= i17;
            }
            if ((i10 & 1572864) == 0) {
                if (composerStartRestartGroup.changed(imageForm.ordinal())) {
                    i16 = 1048576;
                } else {
                    i16 = 524288;
                }
                i12 |= i16;
            }
            i13 = i12;
            if ((599187 & i13) != 599186) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z10, i13 & 1)) {
                if (i18 != 0) {
                    modifier3 = Modifier.INSTANCE;
                } else {
                    modifier3 = modifier;
                }
                if (i19 != 0) {
                    str2 = null;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1910252008, i13, -1, "cu.z17.views.form.ImageFiled (FormItemView.kt:321)");
                }
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier3);
                ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
                constructor = companion.getConstructor();
                if (!defpackage.r.a(composerStartRestartGroup.getApplier())) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerM5176constructorimpl = Updater.m5176constructorimpl(composerStartRestartGroup);
                Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, companion.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
                setCompositeKeyHash = companion.getSetCompositeKeyHash();
                if (composerM5176constructorimpl.getInserting() || !kotlin.jvm.internal.y.d(composerM5176constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion.getSetModifier());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                Modifier modifierM1769size3ABfNKs = SizeKt.m1769size3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(100));
                int[] iArr = WhenMappings.$EnumSwitchMapping$1;
                i14 = iArr[imageForm.ordinal()];
                if (i14 != 1) {
                    circleShape = RoundedCornerShapeKt.getCircleShape();
                } else if (i14 != 2) {
                    circleShape = RectangleShapeKt.getRectangleShape();
                } else {
                    if (i14 == 3) {
                        throw new ua.r();
                    }
                    circleShape = RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(8));
                }
                Modifier modifierClip = ClipKt.clip(modifierM1769size3ABfNKs, circleShape);
                float fM8823constructorimpl = Dp.m8823constructorimpl(1);
                i15 = iArr[imageForm.ordinal()];
                if (i15 != 1) {
                    circleShape2 = RoundedCornerShapeKt.getCircleShape();
                } else if (i15 != 2) {
                    circleShape2 = RectangleShapeKt.getRectangleShape();
                } else {
                    if (i15 == 3) {
                        throw new ua.r();
                    }
                    circleShape2 = RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(8));
                }
                Modifier modifierM1216borderxT4_qwU = BorderKt.m1216borderxT4_qwU(modifierClip, fM8823constructorimpl, MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimary(), circleShape2);
                if ((i13 & 7168) == 2048) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (z11 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new lb.a() { // from class: cu.z17.views.form.h
                        @Override // lb.a
                        public final Object invoke() {
                            return FormItemViewKt.ImageFiled$lambda$46$lambda$44$lambda$43(onPeakRequest);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                Modifier modifierM1238clickableXHw0xAI$default = ClickableKt.m1238clickableXHw0xAI$default(modifierM1216borderxT4_qwU, false, null, null, (lb.a) objRememberedValue, 7, null);
                if (le.d0.q0(value)) {
                    inside = ContentScale.INSTANCE.getInside();
                } else {
                    inside = ContentScale.INSTANCE.getCrop();
                }
                Modifier modifier4 = modifier3;
                str4 = str2;
                Z17PictureKt.m10278Z17BasePictureC8z9wKI(modifierM1238clickableXHw0xAI$default, value, null, null, inside, null, 0, null, null, composerStartRestartGroup, i13 & 112, 492);
                if ((57344 & i13) == 16384) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                if ((i13 & 896) == 256) {
                    z13 = true;
                } else {
                    z13 = false;
                }
                boolean z16 = z13 | z12;
                if ((458752 & i13) == 131072) {
                    z14 = true;
                } else {
                    z14 = false;
                }
                z15 = z16 | z14;
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!z15 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    onValueChange = function1;
                    objRememberedValue2 = new FormItemViewKt$ImageFiled$1$2$1(str4, onValueChange, clearImage, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    onValueChange = function1;
                }
                EffectsKt.LaunchedEffect(str4, (Function2) objRememberedValue2, composerStartRestartGroup, (i13 >> 12) & 14);
                composerStartRestartGroup.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                str3 = str4;
                modifier2 = modifier4;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier2 = modifier;
                str3 = str2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final Function1 function2 = onValueChange;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.form.i
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return FormItemViewKt.ImageFiled$lambda$47(modifier2, value, function2, onPeakRequest, str3, clearImage, imageForm, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i12 |= 24576;
        str2 = str;
        if ((i10 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            if (composerStartRestartGroup.changedInstance(clearImage)) {
                i17 = 131072;
            } else {
                i17 = 65536;
            }
            i12 |= i17;
        }
        if ((i10 & 1572864) == 0) {
            if (composerStartRestartGroup.changed(imageForm.ordinal())) {
                i16 = 1048576;
            } else {
                i16 = 524288;
            }
            i12 |= i16;
        }
        i13 = i12;
        if ((599187 & i13) != 599186) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z10, i13 & 1)) {
            if (i18 != 0) {
                modifier3 = Modifier.INSTANCE;
            } else {
                modifier3 = modifier;
            }
            if (i19 != 0) {
                str2 = null;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1910252008, i13, -1, "cu.z17.views.form.ImageFiled (FormItemView.kt:321)");
            }
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier3);
            ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
            constructor = companion2.getConstructor();
            if (!defpackage.r.a(composerStartRestartGroup.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            composerM5176constructorimpl = Updater.m5176constructorimpl(composerStartRestartGroup);
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy2, companion2.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap2, companion2.getSetResolvedCompositionLocals());
            setCompositeKeyHash = companion2.getSetCompositeKeyHash();
            if (composerM5176constructorimpl.getInserting()) {
                composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            } else {
                composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier2, companion2.getSetModifier());
            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
            Modifier modifierM1769size3ABfNKs2 = SizeKt.m1769size3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(100));
            int[] iArr2 = WhenMappings.$EnumSwitchMapping$1;
            i14 = iArr2[imageForm.ordinal()];
            if (i14 != 1) {
                circleShape = RoundedCornerShapeKt.getCircleShape();
            } else if (i14 != 2) {
                circleShape = RectangleShapeKt.getRectangleShape();
            } else {
                if (i14 == 3) {
                    throw new ua.r();
                }
                circleShape = RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(8));
            }
            Modifier modifierClip2 = ClipKt.clip(modifierM1769size3ABfNKs2, circleShape);
            float fM8823constructorimpl2 = Dp.m8823constructorimpl(1);
            i15 = iArr2[imageForm.ordinal()];
            if (i15 != 1) {
                circleShape2 = RoundedCornerShapeKt.getCircleShape();
            } else if (i15 != 2) {
                circleShape2 = RectangleShapeKt.getRectangleShape();
            } else {
                if (i15 == 3) {
                    throw new ua.r();
                }
                circleShape2 = RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(8));
            }
            Modifier modifierM1216borderxT4_qwU2 = BorderKt.m1216borderxT4_qwU(modifierClip2, fM8823constructorimpl2, MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimary(), circleShape2);
            if ((i13 & 7168) == 2048) {
                z11 = true;
            } else {
                z11 = false;
            }
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z11) {
                objRememberedValue = new lb.a() { // from class: cu.z17.views.form.h
                    @Override // lb.a
                    public final Object invoke() {
                        return FormItemViewKt.ImageFiled$lambda$46$lambda$44$lambda$43(onPeakRequest);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = new lb.a() { // from class: cu.z17.views.form.h
                    @Override // lb.a
                    public final Object invoke() {
                        return FormItemViewKt.ImageFiled$lambda$46$lambda$44$lambda$43(onPeakRequest);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            Modifier modifierM1238clickableXHw0xAI$default2 = ClickableKt.m1238clickableXHw0xAI$default(modifierM1216borderxT4_qwU2, false, null, null, (lb.a) objRememberedValue, 7, null);
            if (le.d0.q0(value)) {
                inside = ContentScale.INSTANCE.getCrop();
            } else {
                inside = ContentScale.INSTANCE.getInside();
            }
            Modifier modifier5 = modifier3;
            str4 = str2;
            Z17PictureKt.m10278Z17BasePictureC8z9wKI(modifierM1238clickableXHw0xAI$default2, value, null, null, inside, null, 0, null, null, composerStartRestartGroup, i13 & 112, 492);
            if ((57344 & i13) == 16384) {
                z12 = true;
            } else {
                z12 = false;
            }
            if ((i13 & 896) == 256) {
                z13 = true;
            } else {
                z13 = false;
            }
            boolean z17 = z13 | z12;
            if ((458752 & i13) == 131072) {
                z14 = true;
            } else {
                z14 = false;
            }
            z15 = z17 | z14;
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (z15) {
                onValueChange = function1;
                objRememberedValue2 = new FormItemViewKt$ImageFiled$1$2$1(str4, onValueChange, clearImage, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            } else {
                onValueChange = function1;
                objRememberedValue2 = new FormItemViewKt$ImageFiled$1$2$1(str4, onValueChange, clearImage, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            EffectsKt.LaunchedEffect(str4, (Function2) objRememberedValue2, composerStartRestartGroup, (i13 >> 12) & 14);
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            str3 = str4;
            modifier2 = modifier5;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            modifier2 = modifier;
            str3 = str2;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Function1 function3 = onValueChange;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.form.i
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FormItemViewKt.ImageFiled$lambda$47(modifier2, value, function3, onPeakRequest, str3, clearImage, imageForm, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ImageFiled$lambda$46$lambda$44$lambda$43(lb.a aVar) {
        aVar.invoke();
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ImageFiled$lambda$47(Modifier modifier, String str, Function1 function1, lb.a aVar, String str2, lb.a aVar2, ImageForm imageForm, int i10, int i11, Composer composer, int i12) {
        ImageFiled(modifier, str, function1, aVar, str2, aVar2, imageForm, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return ua.k0.f43947a;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* JADX INFO: renamed from: LargeField-Tu1Tvio, reason: not valid java name */
    public static final void m10146LargeFieldTu1Tvio(Modifier modifier, final String value, final Function1 onValueChange, final int i10, final int i11, Composer composer, final int i12, final int i13) {
        Modifier modifier2;
        int i14;
        Composer composer2;
        final Modifier modifier3;
        kotlin.jvm.internal.y.i(value, "value");
        kotlin.jvm.internal.y.i(onValueChange, "onValueChange");
        Composer composerStartRestartGroup = composer.startRestartGroup(-58309498);
        int i15 = i13 & 1;
        if (i15 != 0) {
            i14 = i12 | 6;
            modifier2 = modifier;
        } else if ((i12 & 6) == 0) {
            modifier2 = modifier;
            i14 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i12;
        } else {
            modifier2 = modifier;
            i14 = i12;
        }
        if ((i12 & 48) == 0) {
            i14 |= composerStartRestartGroup.changed(value) ? 32 : 16;
        }
        if ((i12 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i14 |= composerStartRestartGroup.changedInstance(onValueChange) ? 256 : 128;
        }
        if ((i12 & 3072) == 0) {
            i14 |= composerStartRestartGroup.changed(i10) ? 2048 : 1024;
        }
        if ((i12 & 24576) == 0) {
            i14 |= composerStartRestartGroup.changed(i11) ? 16384 : 8192;
        }
        if (composerStartRestartGroup.shouldExecute((i14 & 9363) != 9362, i14 & 1)) {
            Modifier modifier4 = i15 != 0 ? Modifier.INSTANCE : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-58309498, i14, -1, "cu.z17.views.form.LargeField (FormItemView.kt:218)");
            }
            composer2 = composerStartRestartGroup;
            Z17InputTextKt.m10251Z17InputTextf9_u2OI(modifier4, value, 4, 4, null, null, onValueChange, null, null, i11, i10, 0L, 0L, 0L, 0L, 0L, null, false, null, false, composer2, (i14 & 14) | 3456 | (i14 & 112) | ((i14 << 12) & 3670016) | ((i14 << 15) & C.ENCODING_PCM_DOUBLE), (i14 >> 9) & 14, 1046960);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            modifier3 = modifier2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.form.o
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FormItemViewKt.LargeField_Tu1Tvio$lambda$22(modifier3, value, onValueChange, i10, i11, i12, i13, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 LargeField_Tu1Tvio$lambda$22(Modifier modifier, String str, Function1 function1, int i10, int i11, int i12, int i13, Composer composer, int i14) {
        m10146LargeFieldTu1Tvio(modifier, str, function1, i10, i11, composer, RecomposeScopeImplKt.updateChangedFlags(i12 | 1), i13);
        return ua.k0.f43947a;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x01bd A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:101:0x01bf  */
    /* JADX WARN: Code duplicated, block: B:102:0x01c9  */
    /* JADX WARN: Code duplicated, block: B:104:0x01cf  */
    /* JADX WARN: Code duplicated, block: B:105:0x01d4  */
    /* JADX WARN: Code duplicated, block: B:108:0x01ee  */
    /* JADX WARN: Code duplicated, block: B:109:0x01f0  */
    /* JADX WARN: Code duplicated, block: B:114:0x01ff  */
    /* JADX WARN: Code duplicated, block: B:117:0x021f  */
    /* JADX WARN: Code duplicated, block: B:119:0x0227  */
    /* JADX WARN: Code duplicated, block: B:122:0x0255  */
    /* JADX WARN: Code duplicated, block: B:123:0x0258  */
    /* JADX WARN: Code duplicated, block: B:126:0x0260  */
    /* JADX WARN: Code duplicated, block: B:127:0x0263  */
    /* JADX WARN: Code duplicated, block: B:130:0x026d  */
    /* JADX WARN: Code duplicated, block: B:131:0x0270  */
    /* JADX WARN: Code duplicated, block: B:138:0x0285  */
    /* JADX WARN: Code duplicated, block: B:141:0x02a2  */
    /* JADX WARN: Code duplicated, block: B:143:0x02a9  */
    /* JADX WARN: Code duplicated, block: B:146:0x02b6  */
    /* JADX WARN: Code duplicated, block: B:148:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:47:0x009e  */
    /* JADX WARN: Code duplicated, block: B:49:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:50:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:54:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:56:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:57:0x00be  */
    /* JADX WARN: Code duplicated, block: B:61:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:62:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:65:0x00d9 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:66:0x00db  */
    /* JADX WARN: Code duplicated, block: B:67:0x00de  */
    /* JADX WARN: Code duplicated, block: B:70:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:73:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:76:0x0116  */
    /* JADX WARN: Code duplicated, block: B:79:0x0122  */
    /* JADX WARN: Code duplicated, block: B:80:0x0126  */
    /* JADX WARN: Code duplicated, block: B:85:0x0153  */
    /* JADX WARN: Code duplicated, block: B:88:0x018a  */
    /* JADX WARN: Code duplicated, block: B:90:0x018d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:91:0x018f  */
    /* JADX WARN: Code duplicated, block: B:92:0x0199  */
    /* JADX WARN: Code duplicated, block: B:94:0x019f  */
    /* JADX WARN: Code duplicated, block: B:95:0x01a4  */
    /* JADX WARN: Code duplicated, block: B:98:0x01ba  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void LargeImageFiled(Modifier modifier, final String value, Function1 onValueChange, final lb.a onPeakRequest, String str, final lb.a clearImage, final ImageForm imageForm, Composer composer, final int i10, final int i11) {
        int i12;
        String str2;
        int i13;
        boolean z10;
        final Function1 function1;
        final Modifier modifier2;
        final String str3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier modifier3;
        int currentCompositeKeyHash;
        lb.a constructor;
        Composer composerM5176constructorimpl;
        Function2 setCompositeKeyHash;
        int i14;
        Shape circleShape;
        int i15;
        Shape circleShape2;
        boolean z11;
        Object objRememberedValue;
        ContentScale inside;
        String str4;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        Object objRememberedValue2;
        int i16;
        int i17;
        kotlin.jvm.internal.y.i(value, "value");
        kotlin.jvm.internal.y.i(onValueChange, "onValueChange");
        kotlin.jvm.internal.y.i(onPeakRequest, "onPeakRequest");
        kotlin.jvm.internal.y.i(clearImage, "clearImage");
        kotlin.jvm.internal.y.i(imageForm, "imageForm");
        Composer composerStartRestartGroup = composer.startRestartGroup(448030777);
        int i18 = i11 & 1;
        if (i18 != 0) {
            i12 = i10 | 6;
        } else if ((i10 & 6) == 0) {
            i12 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i10;
        } else {
            i12 = i10;
        }
        if ((i10 & 48) == 0) {
            i12 |= composerStartRestartGroup.changed(value) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i12 |= composerStartRestartGroup.changedInstance(onValueChange) ? 256 : 128;
        }
        if ((i10 & 3072) == 0) {
            i12 |= composerStartRestartGroup.changedInstance(onPeakRequest) ? 2048 : 1024;
        }
        int i19 = i11 & 16;
        if (i19 == 0) {
            if ((i10 & 24576) == 0) {
                str2 = str;
                i12 |= composerStartRestartGroup.changed(str2) ? 16384 : 8192;
            }
            if ((i10 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                if (composerStartRestartGroup.changedInstance(clearImage)) {
                    i17 = 131072;
                } else {
                    i17 = 65536;
                }
                i12 |= i17;
            }
            if ((i10 & 1572864) == 0) {
                if (composerStartRestartGroup.changed(imageForm.ordinal())) {
                    i16 = 1048576;
                } else {
                    i16 = 524288;
                }
                i12 |= i16;
            }
            i13 = i12;
            if ((599187 & i13) != 599186) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z10, i13 & 1)) {
                if (i18 != 0) {
                    modifier3 = Modifier.INSTANCE;
                } else {
                    modifier3 = modifier;
                }
                if (i19 != 0) {
                    str2 = null;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(448030777, i13, -1, "cu.z17.views.form.LargeImageFiled (FormItemView.kt:365)");
                }
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier3);
                ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
                constructor = companion.getConstructor();
                if (!defpackage.r.a(composerStartRestartGroup.getApplier())) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerM5176constructorimpl = Updater.m5176constructorimpl(composerStartRestartGroup);
                Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, companion.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
                setCompositeKeyHash = companion.getSetCompositeKeyHash();
                if (composerM5176constructorimpl.getInserting() || !kotlin.jvm.internal.y.d(composerM5176constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion.getSetModifier());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(SizeKt.m1755height3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(100)), 0.0f, 1, null);
                int[] iArr = WhenMappings.$EnumSwitchMapping$1;
                i14 = iArr[imageForm.ordinal()];
                if (i14 != 1) {
                    circleShape = RoundedCornerShapeKt.getCircleShape();
                } else if (i14 != 2) {
                    circleShape = RectangleShapeKt.getRectangleShape();
                } else {
                    if (i14 == 3) {
                        throw new ua.r();
                    }
                    circleShape = RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(8));
                }
                Modifier modifierClip = ClipKt.clip(modifierFillMaxWidth$default, circleShape);
                float fM8823constructorimpl = Dp.m8823constructorimpl(1);
                i15 = iArr[imageForm.ordinal()];
                if (i15 != 1) {
                    circleShape2 = RoundedCornerShapeKt.getCircleShape();
                } else if (i15 != 2) {
                    circleShape2 = RectangleShapeKt.getRectangleShape();
                } else {
                    if (i15 == 3) {
                        throw new ua.r();
                    }
                    circleShape2 = RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(8));
                }
                Modifier modifierM1216borderxT4_qwU = BorderKt.m1216borderxT4_qwU(modifierClip, fM8823constructorimpl, MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimary(), circleShape2);
                if ((i13 & 7168) == 2048) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (z11 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new lb.a() { // from class: cu.z17.views.form.f
                        @Override // lb.a
                        public final Object invoke() {
                            return FormItemViewKt.LargeImageFiled$lambda$51$lambda$49$lambda$48(onPeakRequest);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                Modifier modifierM1238clickableXHw0xAI$default = ClickableKt.m1238clickableXHw0xAI$default(modifierM1216borderxT4_qwU, false, null, null, (lb.a) objRememberedValue, 7, null);
                if (le.d0.q0(value)) {
                    inside = ContentScale.INSTANCE.getInside();
                } else {
                    inside = ContentScale.INSTANCE.getCrop();
                }
                Modifier modifier4 = modifier3;
                str4 = str2;
                Z17PictureKt.m10278Z17BasePictureC8z9wKI(modifierM1238clickableXHw0xAI$default, value, null, null, inside, null, 0, null, null, composerStartRestartGroup, i13 & 112, 492);
                if ((57344 & i13) == 16384) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                if ((i13 & 896) == 256) {
                    z13 = true;
                } else {
                    z13 = false;
                }
                boolean z16 = z13 | z12;
                if ((458752 & i13) == 131072) {
                    z14 = true;
                } else {
                    z14 = false;
                }
                z15 = z16 | z14;
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!z15 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    function1 = onValueChange;
                    objRememberedValue2 = new FormItemViewKt$LargeImageFiled$1$2$1(str4, function1, clearImage, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    function1 = onValueChange;
                }
                EffectsKt.LaunchedEffect(str4, (Function2) objRememberedValue2, composerStartRestartGroup, (i13 >> 12) & 14);
                composerStartRestartGroup.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                str3 = str4;
                modifier2 = modifier4;
            } else {
                function1 = onValueChange;
                composerStartRestartGroup.skipToGroupEnd();
                modifier2 = modifier;
                str3 = str2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.form.g
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return FormItemViewKt.LargeImageFiled$lambda$52(modifier2, value, function1, onPeakRequest, str3, clearImage, imageForm, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i12 |= 24576;
        str2 = str;
        if ((i10 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            if (composerStartRestartGroup.changedInstance(clearImage)) {
                i17 = 131072;
            } else {
                i17 = 65536;
            }
            i12 |= i17;
        }
        if ((i10 & 1572864) == 0) {
            if (composerStartRestartGroup.changed(imageForm.ordinal())) {
                i16 = 1048576;
            } else {
                i16 = 524288;
            }
            i12 |= i16;
        }
        i13 = i12;
        if ((599187 & i13) != 599186) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z10, i13 & 1)) {
            if (i18 != 0) {
                modifier3 = Modifier.INSTANCE;
            } else {
                modifier3 = modifier;
            }
            if (i19 != 0) {
                str2 = null;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(448030777, i13, -1, "cu.z17.views.form.LargeImageFiled (FormItemView.kt:365)");
            }
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier3);
            ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
            constructor = companion2.getConstructor();
            if (!defpackage.r.a(composerStartRestartGroup.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            composerM5176constructorimpl = Updater.m5176constructorimpl(composerStartRestartGroup);
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy2, companion2.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap2, companion2.getSetResolvedCompositionLocals());
            setCompositeKeyHash = companion2.getSetCompositeKeyHash();
            if (composerM5176constructorimpl.getInserting()) {
                composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            } else {
                composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier2, companion2.getSetModifier());
            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
            Modifier modifierFillMaxWidth$default2 = SizeKt.fillMaxWidth$default(SizeKt.m1755height3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(100)), 0.0f, 1, null);
            int[] iArr2 = WhenMappings.$EnumSwitchMapping$1;
            i14 = iArr2[imageForm.ordinal()];
            if (i14 != 1) {
                circleShape = RoundedCornerShapeKt.getCircleShape();
            } else if (i14 != 2) {
                circleShape = RectangleShapeKt.getRectangleShape();
            } else {
                if (i14 == 3) {
                    throw new ua.r();
                }
                circleShape = RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(8));
            }
            Modifier modifierClip2 = ClipKt.clip(modifierFillMaxWidth$default2, circleShape);
            float fM8823constructorimpl2 = Dp.m8823constructorimpl(1);
            i15 = iArr2[imageForm.ordinal()];
            if (i15 != 1) {
                circleShape2 = RoundedCornerShapeKt.getCircleShape();
            } else if (i15 != 2) {
                circleShape2 = RectangleShapeKt.getRectangleShape();
            } else {
                if (i15 == 3) {
                    throw new ua.r();
                }
                circleShape2 = RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(8));
            }
            Modifier modifierM1216borderxT4_qwU2 = BorderKt.m1216borderxT4_qwU(modifierClip2, fM8823constructorimpl2, MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimary(), circleShape2);
            if ((i13 & 7168) == 2048) {
                z11 = true;
            } else {
                z11 = false;
            }
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z11) {
                objRememberedValue = new lb.a() { // from class: cu.z17.views.form.f
                    @Override // lb.a
                    public final Object invoke() {
                        return FormItemViewKt.LargeImageFiled$lambda$51$lambda$49$lambda$48(onPeakRequest);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = new lb.a() { // from class: cu.z17.views.form.f
                    @Override // lb.a
                    public final Object invoke() {
                        return FormItemViewKt.LargeImageFiled$lambda$51$lambda$49$lambda$48(onPeakRequest);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            Modifier modifierM1238clickableXHw0xAI$default2 = ClickableKt.m1238clickableXHw0xAI$default(modifierM1216borderxT4_qwU2, false, null, null, (lb.a) objRememberedValue, 7, null);
            if (le.d0.q0(value)) {
                inside = ContentScale.INSTANCE.getCrop();
            } else {
                inside = ContentScale.INSTANCE.getInside();
            }
            Modifier modifier5 = modifier3;
            str4 = str2;
            Z17PictureKt.m10278Z17BasePictureC8z9wKI(modifierM1238clickableXHw0xAI$default2, value, null, null, inside, null, 0, null, null, composerStartRestartGroup, i13 & 112, 492);
            if ((57344 & i13) == 16384) {
                z12 = true;
            } else {
                z12 = false;
            }
            if ((i13 & 896) == 256) {
                z13 = true;
            } else {
                z13 = false;
            }
            boolean z17 = z13 | z12;
            if ((458752 & i13) == 131072) {
                z14 = true;
            } else {
                z14 = false;
            }
            z15 = z17 | z14;
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (z15) {
                function1 = onValueChange;
                objRememberedValue2 = new FormItemViewKt$LargeImageFiled$1$2$1(str4, function1, clearImage, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            } else {
                function1 = onValueChange;
                objRememberedValue2 = new FormItemViewKt$LargeImageFiled$1$2$1(str4, function1, clearImage, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            EffectsKt.LaunchedEffect(str4, (Function2) objRememberedValue2, composerStartRestartGroup, (i13 >> 12) & 14);
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            str3 = str4;
            modifier2 = modifier5;
        } else {
            function1 = onValueChange;
            composerStartRestartGroup.skipToGroupEnd();
            modifier2 = modifier;
            str3 = str2;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.form.g
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FormItemViewKt.LargeImageFiled$lambda$52(modifier2, value, function1, onPeakRequest, str3, clearImage, imageForm, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 LargeImageFiled$lambda$51$lambda$49$lambda$48(lb.a aVar) {
        aVar.invoke();
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 LargeImageFiled$lambda$52(Modifier modifier, String str, Function1 function1, lb.a aVar, String str2, lb.a aVar2, ImageForm imageForm, int i10, int i11, Composer composer, int i12) {
        LargeImageFiled(modifier, str, function1, aVar, str2, aVar2, imageForm, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return ua.k0.f43947a;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void MultipleSelection(Modifier modifier, final List<String> selectionList, final String value, final Function1 onValueChange, Composer composer, final int i10, final int i11) {
        Modifier modifier2;
        int i12;
        final Modifier modifier3;
        kotlin.jvm.internal.y.i(selectionList, "selectionList");
        kotlin.jvm.internal.y.i(value, "value");
        kotlin.jvm.internal.y.i(onValueChange, "onValueChange");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1581223585);
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
            i12 |= composerStartRestartGroup.changedInstance(selectionList) ? 32 : 16;
        }
        int i14 = 256;
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i12 |= composerStartRestartGroup.changed(value) ? 256 : 128;
        }
        if ((i10 & 3072) == 0) {
            i12 |= composerStartRestartGroup.changedInstance(onValueChange) ? 2048 : 1024;
        }
        int i15 = 0;
        if (composerStartRestartGroup.shouldExecute((i12 & 1171) != 1170, i12 & 1)) {
            Modifier modifier4 = i13 != 0 ? Modifier.INSTANCE : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1581223585, i12, -1, "cu.z17.views.form.MultipleSelection (FormItemView.kt:264)");
            }
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier4);
            ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
            lb.a constructor = companion.getConstructor();
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
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyColumnMeasurePolicy, companion.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash = companion.getSetCompositeKeyHash();
            if (composerM5176constructorimpl.getInserting() || !kotlin.jvm.internal.y.d(composerM5176constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            composerStartRestartGroup.startReplaceGroup(582870901);
            Iterator it = selectionList.iterator();
            final int i16 = 0;
            while (it.hasNext()) {
                Object next = it.next();
                int i17 = i16 + 1;
                if (i16 < 0) {
                    va.w.x();
                }
                String str = (String) next;
                int i18 = i12 & 896;
                int i19 = i18 == i14 ? 1 : i15;
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (i19 != 0 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = SnapshotStateKt.derivedStateOf(new lb.a() { // from class: cu.z17.views.form.e
                        @Override // lb.a
                        public final Object invoke() {
                            return Boolean.valueOf(FormItemViewKt.MultipleSelection$lambda$41$lambda$40$lambda$35$lambda$34(value, i16));
                        }
                    });
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                State state = (State) objRememberedValue;
                Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                Modifier.Companion companion2 = Modifier.INSTANCE;
                Iterator it2 = it;
                MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composerStartRestartGroup, 48);
                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, i15);
                CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion2);
                ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
                Modifier modifier5 = modifier4;
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
                Function2 setCompositeKeyHash2 = companion3.getSetCompositeKeyHash();
                if (composerM5176constructorimpl2.getInserting() || !kotlin.jvm.internal.y.d(composerM5176constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                    composerM5176constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    composerM5176constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                }
                Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier2, companion3.getSetModifier());
                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                boolean zMultipleSelection$lambda$41$lambda$40$lambda$36 = MultipleSelection$lambda$41$lambda$40$lambda$36(state);
                boolean zChanged = (i18 == 256) | ((i12 & 7168) == 2048) | composerStartRestartGroup.changed(i16);
                Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new Function1() { // from class: cu.z17.views.form.k
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return FormItemViewKt.MultipleSelection$lambda$41$lambda$40$lambda$39$lambda$38$lambda$37(i16, value, onValueChange, ((Boolean) obj).booleanValue());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                CheckboxKt.Checkbox(zMultipleSelection$lambda$41$lambda$40$lambda$36, (Function1) objRememberedValue2, null, false, null, null, composerStartRestartGroup, 0, 60);
                SpacerKt.Spacer(PaddingKt.m1727paddingVpY3zN4$default(companion2, Dp.m8823constructorimpl(5), 0.0f, 2, null), composerStartRestartGroup, 6);
                Composer composer2 = composerStartRestartGroup;
                Z17LabelKt.m10262Z17LabelfWhpE4E(null, str, MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyLarge(), 0L, 0, 0, composer2, 0, 57);
                composerStartRestartGroup = composer2;
                composerStartRestartGroup.endNode();
                i12 = i12;
                i14 = 256;
                i16 = i17;
                i15 = 0;
                modifier4 = modifier5;
                it = it2;
            }
            Modifier modifier6 = modifier4;
            composerStartRestartGroup.endReplaceGroup();
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier6;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.form.l
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FormItemViewKt.MultipleSelection$lambda$42(modifier3, selectionList, value, onValueChange, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void MultipleSelection$lambda$41$handleAdd(String str, Function1 function1, int i10) {
        List listS0 = le.d0.S0(str, new String[]{","}, false, 0, 6, null);
        ArrayList arrayList = new ArrayList();
        Iterator it = listS0.iterator();
        while (it.hasNext()) {
            Integer numV = le.z.v((String) it.next());
            if (numV != null) {
                arrayList.add(numV);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        arrayList2.addAll(arrayList);
        arrayList2.add(Integer.valueOf(i10));
        function1.invoke(va.g0.G0(arrayList2, ",", null, null, 0, null, null, 62, null));
    }

    private static final void MultipleSelection$lambda$41$handleRemove(String str, Function1 function1, int i10) {
        List listS0 = le.d0.S0(str, new String[]{","}, false, 0, 6, null);
        ArrayList arrayList = new ArrayList();
        Iterator it = listS0.iterator();
        while (it.hasNext()) {
            Integer numV = le.z.v((String) it.next());
            if (numV != null) {
                arrayList.add(numV);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        arrayList2.addAll(arrayList);
        arrayList2.remove(Integer.valueOf(i10));
        function1.invoke(va.g0.G0(arrayList2, ",", null, null, 0, null, null, 62, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean MultipleSelection$lambda$41$lambda$40$lambda$35$lambda$34(String str, int i10) {
        List listS0 = le.d0.S0(str, new String[]{","}, false, 0, 6, null);
        ArrayList arrayList = new ArrayList();
        Iterator it = listS0.iterator();
        while (it.hasNext()) {
            Integer numV = le.z.v((String) it.next());
            if (numV != null) {
                arrayList.add(numV);
            }
        }
        return arrayList.contains(Integer.valueOf(i10));
    }

    private static final boolean MultipleSelection$lambda$41$lambda$40$lambda$36(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 MultipleSelection$lambda$41$lambda$40$lambda$39$lambda$38$lambda$37(int i10, String str, Function1 function1, boolean z10) {
        if (z10) {
            MultipleSelection$lambda$41$handleAdd(str, function1, i10);
        } else {
            MultipleSelection$lambda$41$handleRemove(str, function1, i10);
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 MultipleSelection$lambda$42(Modifier modifier, List list, String str, Function1 function1, int i10, int i11, Composer composer, int i12) {
        MultipleSelection(modifier, list, str, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return ua.k0.f43947a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void SingleSelection(Modifier modifier, final List<String> selectionList, final String value, final Function1 onValueChange, Composer composer, final int i10, final int i11) {
        Modifier modifier2;
        int i12;
        final Modifier modifier3;
        kotlin.jvm.internal.y.i(selectionList, "selectionList");
        kotlin.jvm.internal.y.i(value, "value");
        kotlin.jvm.internal.y.i(onValueChange, "onValueChange");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1179305193);
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
            i12 |= composerStartRestartGroup.changedInstance(selectionList) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i12 |= composerStartRestartGroup.changed(value) ? 256 : 128;
        }
        if ((i10 & 3072) == 0) {
            i12 |= composerStartRestartGroup.changedInstance(onValueChange) ? 2048 : 1024;
        }
        int i14 = 0;
        if (composerStartRestartGroup.shouldExecute((i12 & 1171) != 1170, i12 & 1)) {
            modifier3 = i13 != 0 ? Modifier.INSTANCE : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1179305193, i12, -1, "cu.z17.views.form.SingleSelection (FormItemView.kt:236)");
            }
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier3);
            ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
            lb.a constructor = companion.getConstructor();
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
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyColumnMeasurePolicy, companion.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash = companion.getSetCompositeKeyHash();
            if (composerM5176constructorimpl.getInserting() || !kotlin.jvm.internal.y.d(composerM5176constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            composerStartRestartGroup.startReplaceGroup(-777525441);
            Iterator it = selectionList.iterator();
            final int i15 = 0;
            while (it.hasNext()) {
                Object next = it.next();
                int i16 = i15 + 1;
                if (i15 < 0) {
                    va.w.x();
                }
                String str = (String) next;
                Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                Modifier.Companion companion2 = Modifier.INSTANCE;
                MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composerStartRestartGroup, 48);
                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, i14);
                CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                int i17 = i14;
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion2);
                ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
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
                Iterator it2 = it;
                Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyRowMeasurePolicy, companion3.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
                Function2 setCompositeKeyHash2 = companion3.getSetCompositeKeyHash();
                if (composerM5176constructorimpl2.getInserting() || !kotlin.jvm.internal.y.d(composerM5176constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                    composerM5176constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    composerM5176constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                }
                Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier2, companion3.getSetModifier());
                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                Integer numV = le.z.v(value);
                if (numV == null) {
                    numV = Integer.valueOf(i17);
                }
                int i18 = i15 == numV.intValue() ? 1 : i17;
                int i19 = ((i12 & 7168) == 2048 ? 1 : i17) | (composerStartRestartGroup.changed(i15) ? 1 : 0);
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (i19 != 0 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new lb.a() { // from class: cu.z17.views.form.m
                        @Override // lb.a
                        public final Object invoke() {
                            return FormItemViewKt.SingleSelection$lambda$27$lambda$26$lambda$25$lambda$24$lambda$23(onValueChange, i15);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                RadioButtonKt.RadioButton(i18, (lb.a) objRememberedValue, null, false, null, null, composerStartRestartGroup, 0, 60);
                SpacerKt.Spacer(PaddingKt.m1727paddingVpY3zN4$default(companion2, Dp.m8823constructorimpl(5), 0.0f, 2, null), composerStartRestartGroup, 6);
                Composer composer2 = composerStartRestartGroup;
                Z17LabelKt.m10262Z17LabelfWhpE4E(null, str, MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyLarge(), 0L, 0, 0, composer2, 0, 57);
                composerStartRestartGroup = composer2;
                composerStartRestartGroup.endNode();
                it = it2;
                i15 = i16;
                i14 = i17;
                i12 = i12;
            }
            composerStartRestartGroup.endReplaceGroup();
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.form.n
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FormItemViewKt.SingleSelection$lambda$28(modifier3, selectionList, value, onValueChange, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 SingleSelection$lambda$27$lambda$26$lambda$25$lambda$24$lambda$23(Function1 function1, int i10) {
        function1.invoke(String.valueOf(i10));
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 SingleSelection$lambda$28(Modifier modifier, List list, String str, Function1 function1, int i10, int i11, Composer composer, int i12) {
        SingleSelection(modifier, list, str, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return ua.k0.f43947a;
    }
}
