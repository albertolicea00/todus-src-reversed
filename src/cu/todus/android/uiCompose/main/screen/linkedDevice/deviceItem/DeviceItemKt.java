package cu.todus.android.uiCompose.main.screen.linkedDevice.deviceItem;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.CardDefaults;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableLongState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotLongStateKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ScaleKt;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import androidx.constraintlayout.compose.ConstrainScope;
import androidx.constraintlayout.compose.ConstrainedLayoutReference;
import androidx.constraintlayout.compose.ConstraintLayoutKt;
import androidx.constraintlayout.compose.ConstraintSet;
import androidx.constraintlayout.compose.ConstraintSetScope;
import androidx.constraintlayout.compose.EditableJSONLayout;
import androidx.constraintlayout.compose.LayoutInformationReceiver;
import androidx.constraintlayout.compose.Measurer2;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.profileinstaller.ProfileVerifier;
import cu.todus.android.R;
import cu.todus.android.data.db.entity.toDus.LinkedDevice;
import cu.todus.android.uiCompose.theme.Other;
import cu.z17.views.label.Z17LabelKt;
import cu.z17.views.picture.Z17PictureKt;
import defpackage.r;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.e0;
import kotlin.jvm.internal.y;
import le.d0;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u001a!\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\u001a!\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\u0001\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\t\u0010\n\u001a!\u0010\u000b\u001a\u00020\u00042\b\b\u0002\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u000b\u0010\u0006¨\u0006\f"}, d2 = {"Landroidx/compose/ui/Modifier;", "modifier", "Lcu/todus/android/data/db/entity/toDus/LinkedDevice;", "lD", "Lua/k0;", "DeviceItem", "(Landroidx/compose/ui/Modifier;Lcu/todus/android/data/db/entity/toDus/LinkedDevice;Landroidx/compose/runtime/Composer;II)V", "", LinkedDevice.COLUMN_DEVICE, "DeviceIcon", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)V", "State", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class DeviceItemKt {
    @Composable
    public static final void DeviceIcon(Modifier modifier, final String device, Composer composer, final int i10, final int i11) {
        Modifier modifier2;
        int i12;
        final Modifier modifier3;
        int i13;
        y.i(device, "device");
        Composer composerStartRestartGroup = composer.startRestartGroup(1266921381);
        int i14 = i11 & 1;
        if (i14 != 0) {
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
            i12 |= composerStartRestartGroup.changed(device) ? 32 : 16;
        }
        if (composerStartRestartGroup.shouldExecute((i12 & 19) != 18, i12 & 1)) {
            Modifier modifier4 = i14 != 0 ? Modifier.INSTANCE : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1266921381, i12, -1, "cu.todus.android.uiCompose.main.screen.linkedDevice.deviceItem.DeviceIcon (DeviceItem.kt:102)");
            }
            if (d0.a0(device, "firefox", false, 2, null)) {
                i13 = R.drawable.firefox_ico;
            } else if (d0.a0(device, "edge", false, 2, null)) {
                i13 = R.drawable.edge_ico;
            } else {
                i13 = d0.a0(device, "chrome", false, 2, null) ? R.drawable.chrome_ico : R.drawable.internet_ico;
            }
            Modifier modifierLayoutId = LayoutIdKt.layoutId(SizeKt.m1769size3ABfNKs(modifier4, Dp.m8823constructorimpl(50)), "icon");
            Integer numValueOf = Integer.valueOf(i13);
            modifier3 = modifier4;
            Z17PictureKt.m10278Z17BasePictureC8z9wKI(modifierLayoutId, numValueOf, null, null, null, null, 0, null, null, composerStartRestartGroup, 0, TypedValues.PositionType.TYPE_CURVE_FIT);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.linkedDevice.deviceItem.f
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DeviceItemKt.DeviceIcon$lambda$0(modifier3, device, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 DeviceIcon$lambda$0(Modifier modifier, String str, int i10, int i11, Composer composer, int i12) {
        DeviceIcon(modifier, str, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return k0.f43947a;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void DeviceItem(Modifier modifier, final LinkedDevice lD, Composer composer, final int i10, final int i11) {
        final Modifier modifier2;
        int i12;
        y.i(lD, "lD");
        Composer composerStartRestartGroup = composer.startRestartGroup(2128660301);
        int i13 = i11 & 1;
        if (i13 != 0) {
            i12 = i10 | 6;
            modifier2 = modifier;
        } else if ((i10 & 6) == 0) {
            modifier2 = modifier;
            i12 = i10 | (composerStartRestartGroup.changed(modifier2) ? 4 : 2);
        } else {
            modifier2 = modifier;
            i12 = i10;
        }
        if ((i10 & 48) == 0) {
            i12 |= composerStartRestartGroup.changed(lD) ? 32 : 16;
        }
        if (composerStartRestartGroup.shouldExecute((i12 & 19) != 18, i12 & 1)) {
            Modifier modifier3 = i13 != 0 ? Modifier.INSTANCE : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2128660301, i12, -1, "cu.todus.android.uiCompose.main.screen.linkedDevice.deviceItem.DeviceItem (DeviceItem.kt:29)");
            }
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.linkedDevice.deviceItem.g
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DeviceItemKt.DeviceItem$lambda$0$0((ConstraintSetScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final ConstraintSet ConstraintSet = ConstraintLayoutKt.ConstraintSet((Function1) objRememberedValue);
            Modifier modifier4 = modifier3;
            CardKt.Card(PaddingKt.m1727paddingVpY3zN4$default(SizeKt.fillMaxWidth$default(modifier3, 0.0f, 1, null), 0.0f, Dp.m8823constructorimpl(5), 1, null), null, CardDefaults.INSTANCE.m2922cardColorsro_MJ88(MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground(), 0L, 0L, 0L, composerStartRestartGroup, CardDefaults.$stable << 12, 14), null, null, ComposableLambdaKt.rememberComposableLambda(1735193919, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.linkedDevice.deviceItem.h
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return DeviceItemKt.DeviceItem$lambda$1(ConstraintSet, lD, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 26);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier4;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.linkedDevice.deviceItem.i
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DeviceItemKt.DeviceItem$lambda$2(modifier2, lD, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 DeviceItem$lambda$0$0(ConstraintSetScope ConstraintSet) {
        y.i(ConstraintSet, "$this$ConstraintSet");
        final ConstrainedLayoutReference constrainedLayoutReferenceCreateRefFor = ConstraintSet.createRefFor("icon");
        final ConstrainedLayoutReference constrainedLayoutReferenceCreateRefFor2 = ConstraintSet.createRefFor(LinkedDevice.COLUMN_DEVICE);
        final ConstrainedLayoutReference constrainedLayoutReferenceCreateRefFor3 = ConstraintSet.createRefFor("date");
        ConstrainedLayoutReference constrainedLayoutReferenceCreateRefFor4 = ConstraintSet.createRefFor("state");
        ConstraintSet.constrain(constrainedLayoutReferenceCreateRefFor, new Function1() { // from class: cu.todus.android.uiCompose.main.screen.linkedDevice.deviceItem.b
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DeviceItemKt.DeviceItem$lambda$0$0$0((ConstrainScope) obj);
            }
        });
        ConstraintSet.constrain(constrainedLayoutReferenceCreateRefFor2, new Function1() { // from class: cu.todus.android.uiCompose.main.screen.linkedDevice.deviceItem.c
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DeviceItemKt.DeviceItem$lambda$0$0$1(constrainedLayoutReferenceCreateRefFor, (ConstrainScope) obj);
            }
        });
        ConstraintSet.constrain(constrainedLayoutReferenceCreateRefFor3, new Function1() { // from class: cu.todus.android.uiCompose.main.screen.linkedDevice.deviceItem.d
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DeviceItemKt.DeviceItem$lambda$0$0$2(constrainedLayoutReferenceCreateRefFor2, constrainedLayoutReferenceCreateRefFor, (ConstrainScope) obj);
            }
        });
        ConstraintSet.constrain(constrainedLayoutReferenceCreateRefFor4, new Function1() { // from class: cu.todus.android.uiCompose.main.screen.linkedDevice.deviceItem.e
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DeviceItemKt.DeviceItem$lambda$0$0$3(constrainedLayoutReferenceCreateRefFor3, constrainedLayoutReferenceCreateRefFor, (ConstrainScope) obj);
            }
        });
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 DeviceItem$lambda$0$0$0(ConstrainScope constrain) {
        y.i(constrain, "$this$constrain");
        androidx.constraintlayout.compose.e.b(constrain.getTop(), constrain.getParent().getTop(), 0.0f, 0.0f, 6, null);
        androidx.constraintlayout.compose.e.b(constrain.getBottom(), constrain.getParent().getBottom(), 0.0f, 0.0f, 6, null);
        androidx.constraintlayout.compose.h.a(constrain.getStart(), constrain.getParent().getStart(), 0.0f, 0.0f, 6, null);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 DeviceItem$lambda$0$0$1(ConstrainedLayoutReference constrainedLayoutReference, ConstrainScope constrain) {
        y.i(constrain, "$this$constrain");
        androidx.constraintlayout.compose.e.b(constrain.getTop(), constrain.getParent().getTop(), 0.0f, 0.0f, 6, null);
        androidx.constraintlayout.compose.h.a(constrain.getStart(), constrainedLayoutReference.getEnd(), 0.0f, 0.0f, 6, null);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 DeviceItem$lambda$0$0$2(ConstrainedLayoutReference constrainedLayoutReference, ConstrainedLayoutReference constrainedLayoutReference2, ConstrainScope constrain) {
        y.i(constrain, "$this$constrain");
        androidx.constraintlayout.compose.e.b(constrain.getTop(), constrainedLayoutReference.getBottom(), 0.0f, 0.0f, 6, null);
        androidx.constraintlayout.compose.h.a(constrain.getStart(), constrainedLayoutReference2.getEnd(), 0.0f, 0.0f, 6, null);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 DeviceItem$lambda$0$0$3(ConstrainedLayoutReference constrainedLayoutReference, ConstrainedLayoutReference constrainedLayoutReference2, ConstrainScope constrain) {
        y.i(constrain, "$this$constrain");
        androidx.constraintlayout.compose.e.b(constrain.getTop(), constrainedLayoutReference.getBottom(), 0.0f, 0.0f, 6, null);
        androidx.constraintlayout.compose.h.a(constrain.getStart(), constrainedLayoutReference2.getEnd(), 0.0f, 0.0f, 6, null);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 DeviceItem$lambda$1(final ConstraintSet constraintSet, LinkedDevice linkedDevice, ColumnScope Card, Composer composer, int i10) {
        y.i(Card, "$this$Card");
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1735193919, i10, -1, "cu.todus.android.uiCompose.main.screen.linkedDevice.deviceItem.DeviceItem.<anonymous> (DeviceItem.kt:66)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null);
            composer.startReplaceGroup(-1998673515);
            Object objRememberedValue = composer.rememberedValue();
            Composer.Companion companion2 = Composer.INSTANCE;
            if (objRememberedValue == companion2.getEmpty()) {
                objRememberedValue = SnapshotLongStateKt.mutableLongStateOf(0L);
                composer.updateRememberedValue(objRememberedValue);
            }
            MutableLongState mutableLongState = (MutableLongState) objRememberedValue;
            Object objRememberedValue2 = composer.rememberedValue();
            if (objRememberedValue2 == companion2.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt.mutableStateOf(k0.f43947a, SnapshotStateKt.neverEqualPolicy());
                composer.updateRememberedValue(objRememberedValue2);
            }
            final MutableState mutableState = (MutableState) objRememberedValue2;
            Density density = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
            Object objRememberedValue3 = composer.rememberedValue();
            if (objRememberedValue3 == companion2.getEmpty()) {
                objRememberedValue3 = new Measurer2(density);
                composer.updateRememberedValue(objRememberedValue3);
            }
            final Measurer2 measurer2 = (Measurer2) objRememberedValue3;
            final int i11 = 257;
            boolean zChangedInstance = composer.changedInstance(measurer2) | composer.changed(constraintSet) | composer.changed(257);
            Object objRememberedValue4 = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue4 == companion2.getEmpty()) {
                objRememberedValue4 = new MeasurePolicy() { // from class: cu.todus.android.uiCompose.main.screen.linkedDevice.deviceItem.DeviceItemKt$DeviceItem$lambda$1$$inlined$ConstraintLayout$4

                    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.linkedDevice.deviceItem.DeviceItemKt$DeviceItem$lambda$1$$inlined$ConstraintLayout$4$1, reason: invalid class name */
                    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
                    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0005\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Landroidx/compose/ui/layout/Placeable$PlacementScope;", "Lua/k0;", "invoke", "(Landroidx/compose/ui/layout/Placeable$PlacementScope;)V", "androidx/constraintlayout/compose/ConstraintLayoutKt$ConstraintLayout$measurePolicy$2$1$1", "<anonymous>"}, k = 3, mv = {2, 3, 0})
                    public static final class AnonymousClass1 extends e0 implements Function1 {
                        final /* synthetic */ List $measurables;
                        final /* synthetic */ Measurer2 $measurer;
                        final /* synthetic */ Map $placeableMap;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        public AnonymousClass1(Measurer2 measurer2, List list, Map map) {
                            super(1);
                            this.$measurer = measurer2;
                            this.$measurables = list;
                            this.$placeableMap = map;
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((Placeable.PlacementScope) obj);
                            return k0.f43947a;
                        }

                        public final void invoke(Placeable.PlacementScope placementScope) {
                            this.$measurer.performLayout(placementScope, this.$measurables, this.$placeableMap);
                        }
                    }

                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    public /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i12) {
                        return androidx.compose.ui.layout.h.a(this, intrinsicMeasureScope, list, i12);
                    }

                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    public /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i12) {
                        return androidx.compose.ui.layout.h.b(this, intrinsicMeasureScope, list, i12);
                    }

                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    /* JADX INFO: renamed from: measure-3p2s80s */
                    public final MeasureResult mo983measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j10) {
                        LinkedHashMap linkedHashMap = new LinkedHashMap();
                        mutableState.getValue();
                        long jM9231performMeasureDjhGOtQ = measurer2.m9231performMeasureDjhGOtQ(j10, measureScope.getLayoutDirection(), constraintSet, list, linkedHashMap, i11);
                        return MeasureScope.CC.s(measureScope, IntSize.m8990getWidthimpl(jM9231performMeasureDjhGOtQ), IntSize.m8989getHeightimpl(jM9231performMeasureDjhGOtQ), null, new AnonymousClass1(measurer2, list, linkedHashMap), 4, null);
                    }

                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    public /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i12) {
                        return androidx.compose.ui.layout.h.c(this, intrinsicMeasureScope, list, i12);
                    }

                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    public /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i12) {
                        return androidx.compose.ui.layout.h.d(this, intrinsicMeasureScope, list, i12);
                    }
                };
                composer.updateRememberedValue(objRememberedValue4);
            }
            MeasurePolicy measurePolicy = (MeasurePolicy) objRememberedValue4;
            if (constraintSet instanceof EditableJSONLayout) {
                ((EditableJSONLayout) constraintSet).setUpdateFlag(mutableLongState);
            }
            measurer2.addLayoutInformationReceiver(constraintSet instanceof LayoutInformationReceiver ? (LayoutInformationReceiver) constraintSet : null);
            if (Float.isNaN(measurer2.getForcedScaleFactor())) {
                composer.startReplaceGroup(-1996827620);
                boolean zChangedInstance2 = composer.changedInstance(measurer2);
                Object objRememberedValue5 = composer.rememberedValue();
                if (zChangedInstance2 || objRememberedValue5 == companion2.getEmpty()) {
                    objRememberedValue5 = new DeviceItemKt$DeviceItem$lambda$1$$inlined$ConstraintLayout$7(measurer2);
                    composer.updateRememberedValue(objRememberedValue5);
                }
                LayoutKt.MultiMeasureLayout(SemanticsModifierKt.semantics$default(modifierFillMaxWidth$default, false, (Function1) objRememberedValue5, 1, null), ComposableLambdaKt.rememberComposableLambda(-207512644, true, new DeviceItemKt$DeviceItem$lambda$1$$inlined$ConstraintLayout$8(mutableState, linkedDevice), composer, 54), measurePolicy, composer, 48, 0);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-1997256040);
                Modifier modifierScale = ScaleKt.scale(modifierFillMaxWidth$default, measurer2.getForcedScaleFactor());
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
                CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, companion);
                ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
                lb.a constructor = companion3.getConstructor();
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
                Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, companion3.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
                Function2 setCompositeKeyHash = companion3.getSetCompositeKeyHash();
                if (composerM5176constructorimpl.getInserting() || !y.d(composerM5176constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion3.getSetModifier());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                boolean zChangedInstance3 = composer.changedInstance(measurer2);
                Object objRememberedValue6 = composer.rememberedValue();
                if (zChangedInstance3 || objRememberedValue6 == companion2.getEmpty()) {
                    objRememberedValue6 = new DeviceItemKt$DeviceItem$lambda$1$$inlined$ConstraintLayout$5(measurer2);
                    composer.updateRememberedValue(objRememberedValue6);
                }
                LayoutKt.MultiMeasureLayout(SemanticsModifierKt.semantics$default(modifierScale, false, (Function1) objRememberedValue6, 1, null), ComposableLambdaKt.rememberComposableLambda(1131308473, true, new DeviceItemKt$DeviceItem$lambda$1$$inlined$ConstraintLayout$6(linkedDevice), composer, 54), measurePolicy, composer, 48, 0);
                composer.endNode();
                composer.endReplaceGroup();
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
    public static final k0 DeviceItem$lambda$2(Modifier modifier, LinkedDevice linkedDevice, int i10, int i11, Composer composer, int i12) {
        DeviceItem(modifier, linkedDevice, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return k0.f43947a;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void State(Modifier modifier, final LinkedDevice lD, Composer composer, final int i10, final int i11) {
        Modifier modifier2;
        int i12;
        final Modifier modifier3;
        String strStringResource;
        long jM10111getGreen0d7_KjU;
        y.i(lD, "lD");
        Composer composerStartRestartGroup = composer.startRestartGroup(1637616097);
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
            i12 |= composerStartRestartGroup.changed(lD) ? 32 : 16;
        }
        if (composerStartRestartGroup.shouldExecute((i12 & 19) != 18, i12 & 1)) {
            modifier3 = i13 != 0 ? Modifier.INSTANCE : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1637616097, i12, -1, "cu.todus.android.uiCompose.main.screen.linkedDevice.deviceItem.State (DeviceItem.kt:118)");
            }
            int state = lD.getState();
            if (state == 0) {
                composerStartRestartGroup.startReplaceGroup(1791044584);
                strStringResource = StringResources_androidKt.stringResource(R.string.is_active, composerStartRestartGroup, 0);
                composerStartRestartGroup.endReplaceGroup();
            } else if (state != 1) {
                composerStartRestartGroup.startReplaceGroup(-312053025);
                composerStartRestartGroup.endReplaceGroup();
                strStringResource = "";
            } else {
                composerStartRestartGroup.startReplaceGroup(1791047176);
                strStringResource = StringResources_androidKt.stringResource(R.string.is_closed, composerStartRestartGroup, 0);
                composerStartRestartGroup.endReplaceGroup();
            }
            String str = strStringResource;
            TextStyle bodySmall = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodySmall();
            int state2 = lD.getState();
            if (state2 != 0) {
                jM10111getGreen0d7_KjU = state2 != 1 ? Other.INSTANCE.m10118getRed0d7_KjU() : Other.INSTANCE.m10118getRed0d7_KjU();
            } else {
                jM10111getGreen0d7_KjU = Other.INSTANCE.m10111getGreen0d7_KjU();
            }
            Z17LabelKt.m10262Z17LabelfWhpE4E(modifier3, str, TextStyle.m8271copyp1EtxEg$default(bodySmall, jM10111getGreen0d7_KjU, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null), 0L, 0, 0, composerStartRestartGroup, i12 & 14, 56);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.linkedDevice.deviceItem.a
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DeviceItemKt.State$lambda$0(modifier3, lD, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 State$lambda$0(Modifier modifier, LinkedDevice linkedDevice, int i10, int i11, Composer composer, int i12) {
        State(modifier, linkedDevice, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return k0.f43947a;
    }
}
