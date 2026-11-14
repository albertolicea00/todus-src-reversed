package cu.todus.android.uiCompose.main.screen.qrReader;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.IconButtonKt;
import androidx.compose.material.IconKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.outlined.ContentCopyKt;
import androidx.compose.material.icons.outlined.RefreshKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import androidx.media3.exoplayer.RendererCapabilities;
import cu.todus.android.R;
import cu.todus.android.utils.IntentUtil;
import cu.z17.views.label.Z17ClickableLabelClickType;
import cu.z17.views.label.Z17ClickableLabelKt;
import cu.z17.views.label.Z17LabelKt;
import cu.z17.views.picture.Z17PictureKt;
import cu.z17.views.qr.Z17QRScannerKt;
import defpackage.r;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.y;
import le.d0;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;
import ua.k0;
import va.w;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
public final class ComposableSingletons$QrReaderScreenKt {
    public static final ComposableSingletons$QrReaderScreenKt INSTANCE = new ComposableSingletons$QrReaderScreenKt();

    /* JADX INFO: renamed from: lambda$-2065297021, reason: not valid java name */
    private static Function2 f247lambda$2065297021 = ComposableLambdaKt.composableLambdaInstance(-2065297021, false, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.qrReader.a
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$QrReaderScreenKt.lambda__2065297021$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-1722101248, reason: not valid java name */
    private static Function2 f246lambda$1722101248 = ComposableLambdaKt.composableLambdaInstance(-1722101248, false, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.qrReader.c
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$QrReaderScreenKt.lambda__1722101248$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2 lambda$2001727991 = ComposableLambdaKt.composableLambdaInstance(2001727991, false, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.qrReader.d
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$QrReaderScreenKt.lambda_2001727991$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2 lambda$59618936 = ComposableLambdaKt.composableLambdaInstance(59618936, false, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.qrReader.e
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$QrReaderScreenKt.lambda_59618936$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function3 lambda$102382264 = ComposableLambdaKt.composableLambdaInstance(102382264, false, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.qrReader.f
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$QrReaderScreenKt.lambda_102382264$lambda$0((Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Z17ClickableLabelClickType.values().length];
            try {
                iArr[Z17ClickableLabelClickType.LINK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 lambda_102382264$lambda$0(Modifier it, Composer composer, int i10) {
        int i11;
        int i12;
        ab.e eVar;
        final MutableState mutableState;
        y.i(it, "it");
        if ((i10 & 6) == 0) {
            i11 = i10 | (composer.changed(it) ? 4 : 2);
        } else {
            i11 = i10;
        }
        if (composer.shouldExecute((i11 & 19) != 18, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(102382264, i11, -1, "cu.todus.android.uiCompose.main.screen.qrReader.ComposableSingletons$QrReaderScreenKt.lambda$102382264.<anonymous> (QrReaderScreen.kt:72)");
            }
            final Context context = (Context) composer.consume(AndroidCompositionLocals_androidKt.getLocalContext());
            Object objRememberedValue = composer.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = EffectsKt.createCompositionCoroutineScope(ab.j.f643c, composer);
                composer.updateRememberedValue(objRememberedValue);
            }
            c1.a aVarC = c1.d.c(w.g("android.permission.CAMERA"), null, composer, 0, 2);
            Object objRememberedValue2 = composer.rememberedValue();
            if (objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                composer.updateRememberedValue(objRememberedValue2);
            }
            MutableState mutableState2 = (MutableState) objRememberedValue2;
            Object objRememberedValue3 = composer.rememberedValue();
            if (objRememberedValue3 == companion.getEmpty()) {
                objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
                composer.updateRememberedValue(objRememberedValue3);
            }
            final MutableState mutableState3 = (MutableState) objRememberedValue3;
            Object objRememberedValue4 = composer.rememberedValue();
            if (objRememberedValue4 == companion.getEmpty()) {
                Object systemService = context.getSystemService("clipboard");
                y.g(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
                objRememberedValue4 = (ClipboardManager) systemService;
                composer.updateRememberedValue(objRememberedValue4);
            }
            final ClipboardManager clipboardManager = (ClipboardManager) objRememberedValue4;
            final String strStringResource = StringResources_androidKt.stringResource(R.string.share, composer, 0);
            float f10 = 20;
            Modifier modifierM1725padding3ABfNKs = PaddingKt.m1725padding3ABfNKs(ScrollKt.verticalScroll$default(SizeKt.fillMaxSize$default(it, 0.0f, 1, null), ScrollKt.rememberScrollState(0, composer, 0, 1), false, null, false, 14, null), Dp.m8823constructorimpl(f10));
            Arrangement arrangement = Arrangement.INSTANCE;
            Arrangement.Vertical top = arrangement.getTop();
            Alignment.Companion companion2 = Alignment.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(top, companion2.getStart(), composer, 0);
            int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierM1725padding3ABfNKs);
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
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyColumnMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion3.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl, companion3.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion3.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            Modifier.Companion companion4 = Modifier.INSTANCE;
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(companion4, 0.0f, 1, null);
            MaterialTheme materialTheme = MaterialTheme.INSTANCE;
            int i13 = MaterialTheme.$stable;
            Z17LabelKt.m10262Z17LabelfWhpE4E(PaddingKt.m1725padding3ABfNKs(BackgroundKt.m1204backgroundbw27NRU(modifierFillMaxWidth$default, Color.m5865copywmQWz5c$default(materialTheme.getColorScheme(composer, i13).getOnBackground(), 0.2f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(10))), Dp.m8823constructorimpl(f10)), StringResources_androidKt.stringResource(R.string.focus_qr_to_read, composer, 0), TextStyle.m8271copyp1EtxEg$default(materialTheme.getTypography(composer, i13).getBodyMedium(), 0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, TextAlign.INSTANCE.m8692getCentere0LSkKk(), 0, 0L, null, null, null, 0, 0, null, 16744447, null), 0L, 0, 0, composer, 0, 56);
            Composer composer2 = composer;
            float f11 = 30;
            SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion4, Dp.m8823constructorimpl(f11)), composer2, 6);
            if (lambda_102382264$lambda$0$1(mutableState2) && d0.q0((CharSequence) mutableState3.getValue())) {
                composer2.startReplaceGroup(1645062696);
                Modifier modifierAlign = columnScopeInstance.align(companion4, companion2.getCenterHorizontally());
                boolean zChangedInstance = composer2.changedInstance(context);
                Object objRememberedValue5 = composer2.rememberedValue();
                if (zChangedInstance || objRememberedValue5 == companion.getEmpty()) {
                    objRememberedValue5 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.qrReader.g
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ComposableSingletons$QrReaderScreenKt.lambda_102382264$lambda$0$5$0$0(context, mutableState3, (String) obj);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue5);
                }
                Function1 function1 = (Function1) objRememberedValue5;
                Object objRememberedValue6 = composer2.rememberedValue();
                if (objRememberedValue6 == companion.getEmpty()) {
                    objRememberedValue6 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.qrReader.h
                        @Override // lb.a
                        public final Object invoke() {
                            return k0.f43947a;
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue6);
                }
                i12 = 6;
                Z17QRScannerKt.m10300Z17QRScannerHYR8e34(modifierAlign, function1, (lb.a) objRememberedValue6, null, false, 0.0f, composer, RendererCapabilities.DECODER_SUPPORT_MASK, 56);
                composer2 = composer;
                composer2.endReplaceGroup();
            } else {
                i12 = 6;
                composer2.startReplaceGroup(1645350996);
                composer2.endReplaceGroup();
            }
            SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion4, Dp.m8823constructorimpl(f11)), composer2, i12);
            String str = (String) mutableState3.getValue();
            TextStyle labelMedium = materialTheme.getTypography(composer2, i13).getLabelMedium();
            boolean zChangedInstance2 = composer2.changedInstance(context);
            Object objRememberedValue7 = composer2.rememberedValue();
            if (zChangedInstance2 || objRememberedValue7 == companion.getEmpty()) {
                objRememberedValue7 = new Function2() { // from class: cu.todus.android.uiCompose.main.screen.qrReader.i
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ComposableSingletons$QrReaderScreenKt.lambda_102382264$lambda$0$5$2$0(context, (Z17ClickableLabelClickType) obj, (String) obj2);
                    }
                };
                composer2.updateRememberedValue(objRememberedValue7);
            }
            Z17ClickableLabelKt.m10257Z17ClickableLabel0nDMI0(null, labelMedium, str, (Function2) objRememberedValue7, null, 0, 0, 0L, 0L, composer, 0, 497);
            SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion4, Dp.m8823constructorimpl(60)), composer, i12);
            if (d0.q0((CharSequence) mutableState3.getValue())) {
                eVar = null;
                composer.startReplaceGroup(1647562164);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(1646007266);
                eVar = null;
                Modifier modifierFillMaxWidth$default2 = SizeKt.fillMaxWidth$default(companion4, 0.0f, 1, null);
                MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getSpaceAround(), companion2.getTop(), composer, i12);
                int iA2 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
                CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer, modifierFillMaxWidth$default2);
                lb.a constructor2 = companion3.getConstructor();
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
                Updater.m5180initimpl(composerM5176constructorimpl2, Integer.valueOf(iA2), companion3.getSetCompositeKeyHash());
                Updater.m5182reconcileimpl(composerM5176constructorimpl2, companion3.getApplyOnDeactivatedNodeAssertion());
                Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier2, companion3.getSetModifier());
                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                boolean zChangedInstance3 = composer.changedInstance(clipboardManager);
                Object objRememberedValue8 = composer.rememberedValue();
                if (zChangedInstance3 || objRememberedValue8 == companion.getEmpty()) {
                    mutableState = mutableState3;
                    objRememberedValue8 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.qrReader.j
                        @Override // lb.a
                        public final Object invoke() {
                            return ComposableSingletons$QrReaderScreenKt.lambda_102382264$lambda$0$5$3$0$0(mutableState, clipboardManager);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue8);
                } else {
                    mutableState = mutableState3;
                }
                IconButtonKt.IconButton((lb.a) objRememberedValue8, null, false, null, f246lambda$1722101248, composer, 24576, 14);
                boolean zChangedInstance4 = composer.changedInstance(context) | composer.changed(strStringResource);
                Object objRememberedValue9 = composer.rememberedValue();
                if (zChangedInstance4 || objRememberedValue9 == companion.getEmpty()) {
                    objRememberedValue9 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.qrReader.k
                        @Override // lb.a
                        public final Object invoke() {
                            return ComposableSingletons$QrReaderScreenKt.lambda_102382264$lambda$0$5$3$1$0(context, strStringResource, mutableState);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue9);
                }
                IconButtonKt.IconButton((lb.a) objRememberedValue9, null, false, null, lambda$2001727991, composer, 24576, 14);
                Object objRememberedValue10 = composer.rememberedValue();
                if (objRememberedValue10 == companion.getEmpty()) {
                    objRememberedValue10 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.qrReader.b
                        @Override // lb.a
                        public final Object invoke() {
                            return ComposableSingletons$QrReaderScreenKt.lambda_102382264$lambda$0$5$3$2$0(mutableState);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue10);
                }
                IconButtonKt.IconButton((lb.a) objRememberedValue10, null, false, null, lambda$59618936, composer, 24582, 14);
                composer.endNode();
                composer.endReplaceGroup();
            }
            Boolean boolValueOf = Boolean.valueOf(aVarC.a());
            boolean zChanged = composer.changed(aVarC);
            Object objRememberedValue11 = composer.rememberedValue();
            if (zChanged || objRememberedValue11 == companion.getEmpty()) {
                objRememberedValue11 = new ComposableSingletons$QrReaderScreenKt$lambda$102382264$1$1$5$1(aVarC, mutableState2, eVar);
                composer.updateRememberedValue(objRememberedValue11);
            }
            EffectsKt.LaunchedEffect(boolValueOf, (Function2) objRememberedValue11, composer, 0);
            composer.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    private static final boolean lambda_102382264$lambda$0$1(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void lambda_102382264$lambda$0$2(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 lambda_102382264$lambda$0$5$0$0(Context context, MutableState mutableState, String s10) {
        y.i(s10, "s");
        lambda_102382264$lambda$0$handleQR(context, mutableState, s10);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 lambda_102382264$lambda$0$5$2$0(Context context, Z17ClickableLabelClickType type, String value) {
        y.i(type, "type");
        y.i(value, "value");
        if (WhenMappings.$EnumSwitchMapping$0[type.ordinal()] == 1) {
            IntentUtil.INSTANCE.showWeb(context, value);
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 lambda_102382264$lambda$0$5$3$0$0(MutableState mutableState, ClipboardManager clipboardManager) {
        clipboardManager.setPrimaryClip(ClipData.newPlainText("link", (CharSequence) mutableState.getValue()));
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 lambda_102382264$lambda$0$5$3$1$0(Context context, String str, MutableState mutableState) {
        lambda_102382264$lambda$0$shareThroughOtherApps(context, str, mutableState);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 lambda_102382264$lambda$0$5$3$2$0(MutableState mutableState) {
        mutableState.setValue("");
        return k0.f43947a;
    }

    private static final void lambda_102382264$lambda$0$handleQR(Context context, MutableState<String> mutableState, String str) {
        if (d0.a0(str, "chat.todus.cu/", false, 2, null)) {
            IntentUtil.INSTANCE.showWeb(context, str);
        }
        mutableState.setValue(str);
    }

    private static final void lambda_102382264$lambda$0$shareThroughOtherApps(Context context, String str, MutableState<String> mutableState) {
        IntentUtil.INSTANCE.shareText(context, str, mutableState.getValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 lambda_2001727991$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2001727991, i10, -1, "cu.todus.android.uiCompose.main.screen.qrReader.ComposableSingletons$QrReaderScreenKt.lambda$2001727991.<anonymous> (QrReaderScreen.kt:177)");
            }
            Z17PictureKt.m10278Z17BasePictureC8z9wKI(SizeKt.m1769size3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(30)), Integer.valueOf(R.drawable.send_icon), null, ColorFilter.Companion.m5907tintxETnrds$default(ColorFilter.INSTANCE, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getSurface(), 0, 2, null), null, null, 0, null, null, composer, 6, XMPPTCPConnection.PacketWriter.QUEUE_SIZE);
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
    public static final k0 lambda_59618936$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(59618936, i10, -1, "cu.todus.android.uiCompose.main.screen.qrReader.ComposableSingletons$QrReaderScreenKt.lambda$59618936.<anonymous> (QrReaderScreen.kt:187)");
            }
            IconKt.m2671Iconww6aTOc(RefreshKt.getRefresh(Icons.Outlined.INSTANCE), "Localized description", SizeKt.m1769size3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(30)), MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getSurface(), composer, 432, 0);
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
    public static final k0 lambda__1722101248$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1722101248, i10, -1, "cu.todus.android.uiCompose.main.screen.qrReader.ComposableSingletons$QrReaderScreenKt.lambda$-1722101248.<anonymous> (QrReaderScreen.kt:166)");
            }
            IconKt.m2671Iconww6aTOc(ContentCopyKt.getContentCopy(Icons.Outlined.INSTANCE), "Localized description", SizeKt.m1769size3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(30)), MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getSurface(), composer, 432, 0);
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
    public static final k0 lambda__2065297021$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2065297021, i10, -1, "cu.todus.android.uiCompose.main.screen.qrReader.ComposableSingletons$QrReaderScreenKt.lambda$-2065297021.<anonymous> (QrReaderScreen.kt:63)");
            }
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, StringResources_androidKt.stringResource(R.string.qr_reader, composer, 0), MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getTitleSmall(), 0L, 0, 0, composer, 0, 57);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: renamed from: getLambda$-1722101248$app_productionPFast, reason: not valid java name */
    public final Function2 m9960getLambda$1722101248$app_productionPFast() {
        return f246lambda$1722101248;
    }

    /* JADX INFO: renamed from: getLambda$-2065297021$app_productionPFast, reason: not valid java name */
    public final Function2 m9961getLambda$2065297021$app_productionPFast() {
        return f247lambda$2065297021;
    }

    public final Function3 getLambda$102382264$app_productionPFast() {
        return lambda$102382264;
    }

    public final Function2 getLambda$2001727991$app_productionPFast() {
        return lambda$2001727991;
    }

    public final Function2 getLambda$59618936$app_productionPFast() {
        return lambda$59618936;
    }
}
