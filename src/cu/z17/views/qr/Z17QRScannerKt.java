package cu.z17.views.qr;

import android.app.Activity;
import android.content.Context;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.outlined.FlashOffKt;
import androidx.compose.material.icons.outlined.FlashOnKt;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.MaterialTheme;
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
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.viewinterop.AndroidView_androidKt;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.profileinstaller.ProfileVerifier;
import com.journeyapps.barcodescanner.DecoratedBarcodeView;
import cu.z17.views.button.Z17ButtonsKt;
import cu.z17.views.picture.Z17PictureKt;
import defpackage.r;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.y;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001aY\u0010\u000f\u001a\u00020\u00042\b\b\u0002\u0010\u0001\u001a\u00020\u00002\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00062\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u0012²\u0006\u000e\u0010\u0010\u001a\u00020\t8\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\u0011\u001a\u00020\t8\n@\nX\u008a\u008e\u0002"}, d2 = {"Landroidx/compose/ui/Modifier;", "modifier", "Lkotlin/Function1;", "", "Lua/k0;", "handleCorrectScan", "Lkotlin/Function0;", "handleCancelScan", "cancelText", "", "showCancel", "Landroidx/compose/ui/unit/Dp;", "size", "Z17QRScanner-HYR8e34", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Llb/a;Ljava/lang/String;ZFLandroidx/compose/runtime/Composer;II)V", "Z17QRScanner", "scanFlag", "torchFlag", "views_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class Z17QRScannerKt {
    /* JADX WARN: Code duplicated, block: B:102:0x01ca  */
    /* JADX WARN: Code duplicated, block: B:104:0x01f0  */
    /* JADX WARN: Code duplicated, block: B:105:0x01f4  */
    /* JADX WARN: Code duplicated, block: B:107:0x020b  */
    /* JADX WARN: Code duplicated, block: B:110:0x0234  */
    /* JADX WARN: Code duplicated, block: B:113:0x0240  */
    /* JADX WARN: Code duplicated, block: B:114:0x0244  */
    /* JADX WARN: Code duplicated, block: B:117:0x0263  */
    /* JADX WARN: Code duplicated, block: B:119:0x0271  */
    /* JADX WARN: Code duplicated, block: B:122:0x0292  */
    /* JADX WARN: Code duplicated, block: B:124:0x0298  */
    /* JADX WARN: Code duplicated, block: B:127:0x02b0  */
    /* JADX WARN: Code duplicated, block: B:130:0x02d0  */
    /* JADX WARN: Code duplicated, block: B:133:0x030e  */
    /* JADX WARN: Code duplicated, block: B:135:0x0318  */
    /* JADX WARN: Code duplicated, block: B:136:0x031a  */
    /* JADX WARN: Code duplicated, block: B:139:0x0321  */
    /* JADX WARN: Code duplicated, block: B:141:0x0327  */
    /* JADX WARN: Code duplicated, block: B:144:0x034c  */
    /* JADX WARN: Code duplicated, block: B:147:0x0362  */
    /* JADX WARN: Code duplicated, block: B:149:0x0368  */
    /* JADX WARN: Code duplicated, block: B:152:0x037e  */
    /* JADX WARN: Code duplicated, block: B:154:0x0388  */
    /* JADX WARN: Code duplicated, block: B:157:0x0397  */
    /* JADX WARN: Code duplicated, block: B:159:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:40:0x0076  */
    /* JADX WARN: Code duplicated, block: B:42:0x007b  */
    /* JADX WARN: Code duplicated, block: B:44:0x007f  */
    /* JADX WARN: Code duplicated, block: B:46:0x0087  */
    /* JADX WARN: Code duplicated, block: B:47:0x008a  */
    /* JADX WARN: Code duplicated, block: B:51:0x0093  */
    /* JADX WARN: Code duplicated, block: B:53:0x0097  */
    /* JADX WARN: Code duplicated, block: B:55:0x009a  */
    /* JADX WARN: Code duplicated, block: B:57:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:58:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:62:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:63:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:66:0x00bf A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:67:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:68:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:70:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:71:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:73:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:74:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:76:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:77:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:80:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:83:0x011d  */
    /* JADX WARN: Code duplicated, block: B:86:0x0129  */
    /* JADX WARN: Code duplicated, block: B:87:0x012d  */
    /* JADX WARN: Code duplicated, block: B:90:0x014c  */
    /* JADX WARN: Code duplicated, block: B:92:0x015a  */
    /* JADX WARN: Code duplicated, block: B:95:0x0188  */
    /* JADX WARN: Code duplicated, block: B:96:0x0193  */
    /* JADX WARN: Code duplicated, block: B:99:0x01a0  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* JADX INFO: renamed from: Z17QRScanner-HYR8e34, reason: not valid java name */
    public static final void m10300Z17QRScannerHYR8e34(Modifier modifier, final Function1 handleCorrectScan, final lb.a handleCancelScan, String str, boolean z10, float f10, Composer composer, final int i10, final int i11) {
        Modifier modifier2;
        int i12;
        String str2;
        int i13;
        int i14;
        int i15;
        int i16;
        boolean z11;
        final boolean z12;
        final float f11;
        final Modifier modifier3;
        final String str3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier modifier4;
        String str4;
        boolean z13;
        float fM8823constructorimpl;
        int currentCompositeKeyHash;
        lb.a constructor;
        Composer composerM5176constructorimpl;
        Function2 setCompositeKeyHash;
        Context context;
        Object objRememberedValue;
        Composer.Companion companion;
        int i17;
        final MutableState mutableState;
        Object objRememberedValue2;
        final MutableState mutableState2;
        final e6.e eVar;
        Object objRememberedValue3;
        final DecoratedBarcodeView decoratedBarcodeView;
        int currentCompositeKeyHash2;
        lb.a constructor2;
        Composer composerM5176constructorimpl2;
        Function2 setCompositeKeyHash2;
        boolean zChangedInstance;
        Object objRememberedValue4;
        Object objRememberedValue5;
        Object objRememberedValue6;
        int i18;
        String str5;
        boolean zChangedInstance2;
        Object objRememberedValue7;
        boolean z14;
        Object objRememberedValue8;
        final DecoratedBarcodeView decoratedBarcodeView2;
        y.i(handleCorrectScan, "handleCorrectScan");
        y.i(handleCancelScan, "handleCancelScan");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1827776452);
        int i19 = i11 & 1;
        if (i19 != 0) {
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
            i12 |= composerStartRestartGroup.changedInstance(handleCorrectScan) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i12 |= composerStartRestartGroup.changedInstance(handleCancelScan) ? 256 : 128;
        }
        int i20 = i11 & 8;
        if (i20 == 0) {
            if ((i10 & 3072) == 0) {
                str2 = str;
                i12 |= composerStartRestartGroup.changed(str2) ? 2048 : 1024;
            }
            i13 = i11 & 16;
            if (i13 != 0) {
                if ((i10 & 24576) == 0) {
                    if (composerStartRestartGroup.changed(z10)) {
                        i14 = 16384;
                    } else {
                        i14 = 8192;
                    }
                    i12 |= i14;
                }
                i15 = i11 & 32;
                if (i15 != 0) {
                    if ((196608 & i10) == 0) {
                        if (composerStartRestartGroup.changed(f10)) {
                            i16 = 131072;
                        } else {
                            i16 = 65536;
                        }
                        i12 |= i16;
                    }
                    if ((i12 & 74899) != 74898) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z11, i12 & 1)) {
                        if (i19 != 0) {
                            modifier4 = Modifier.INSTANCE;
                        } else {
                            modifier4 = modifier2;
                        }
                        if (i20 != 0) {
                            str4 = "Cancel";
                        } else {
                            str4 = str2;
                        }
                        if (i13 != 0) {
                            z13 = false;
                        } else {
                            z13 = z10;
                        }
                        if (i15 != 0) {
                            fM8823constructorimpl = Dp.m8823constructorimpl(250);
                        } else {
                            fM8823constructorimpl = f10;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1827776452, i12, -1, "cu.z17.views.qr.Z17QRScanner (Z17QRScanner.kt:41)");
                        }
                        Arrangement.HorizontalOrVertical spaceBetween = Arrangement.INSTANCE.getSpaceBetween();
                        Alignment.Companion companion2 = Alignment.INSTANCE;
                        MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(spaceBetween, companion2.getCenterHorizontally(), composerStartRestartGroup, 54);
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier4);
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
                        Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyColumnMeasurePolicy, companion3.getSetMeasurePolicy());
                        Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
                        setCompositeKeyHash = companion3.getSetCompositeKeyHash();
                        if (composerM5176constructorimpl.getInserting() || !y.d(composerM5176constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                            composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion3.getSetModifier());
                        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                        context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        companion = Composer.INSTANCE;
                        if (objRememberedValue == companion.getEmpty()) {
                            i17 = 2;
                            objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            i17 = 2;
                        }
                        mutableState = (MutableState) objRememberedValue;
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == companion.getEmpty()) {
                            objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, i17, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        mutableState2 = (MutableState) objRememberedValue2;
                        Object objConsume = composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                        y.g(objConsume, "null cannot be cast to non-null type android.app.Activity");
                        eVar = new e6.e((Activity) objConsume);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue3 == companion.getEmpty()) {
                            decoratedBarcodeView2 = new DecoratedBarcodeView(context);
                            y.g(context, "null cannot be cast to non-null type android.app.Activity");
                            Activity activity = (Activity) context;
                            com.journeyapps.barcodescanner.a aVar = new com.journeyapps.barcodescanner.a(activity, decoratedBarcodeView2);
                            aVar.p(activity.getIntent(), null);
                            decoratedBarcodeView2.setStatusText("");
                            aVar.l();
                            if (Z17QRScanner_HYR8e34$lambda$23$lambda$4(mutableState2)) {
                                decoratedBarcodeView2.k();
                            } else {
                                decoratedBarcodeView2.j();
                            }
                            decoratedBarcodeView2.b(new a7.b() { // from class: cu.z17.views.qr.a
                                @Override // a7.b
                                public /* synthetic */ void a(List list) {
                                    a7.a.a(this, list);
                                }

                                @Override // a7.b
                                public final void b(a7.c cVar) {
                                    Z17QRScannerKt.Z17QRScanner_HYR8e34$lambda$23$lambda$9$lambda$8$lambda$7(decoratedBarcodeView2, mutableState, mutableState2, eVar, handleCorrectScan, cVar);
                                }
                            });
                            decoratedBarcodeView2.i();
                            composerStartRestartGroup.updateRememberedValue(decoratedBarcodeView2);
                            objRememberedValue3 = decoratedBarcodeView2;
                        }
                        decoratedBarcodeView = (DecoratedBarcodeView) objRememberedValue3;
                        Modifier.Companion companion4 = Modifier.INSTANCE;
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion2.getTopStart(), false);
                        currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion4);
                        constructor2 = companion3.getConstructor();
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
                        Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy, companion3.getSetMeasurePolicy());
                        Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
                        setCompositeKeyHash2 = companion3.getSetCompositeKeyHash();
                        if (composerM5176constructorimpl2.getInserting() || !y.d(composerM5176constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                            composerM5176constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                            composerM5176constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                        }
                        Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier2, companion3.getSetModifier());
                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                        zChangedInstance = composerStartRestartGroup.changedInstance(decoratedBarcodeView);
                        objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        if (zChangedInstance || objRememberedValue4 == companion.getEmpty()) {
                            objRememberedValue4 = new Function1() { // from class: cu.z17.views.qr.b
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return Z17QRScannerKt.Z17QRScanner_HYR8e34$lambda$23$lambda$17$lambda$11$lambda$10(decoratedBarcodeView, (Context) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        }
                        Function1 function1 = (Function1) objRememberedValue4;
                        Modifier modifierM1769size3ABfNKs = SizeKt.m1769size3ABfNKs(companion4, fM8823constructorimpl);
                        objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue5 == companion.getEmpty()) {
                            objRememberedValue5 = new Function1() { // from class: cu.z17.views.qr.c
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return Z17QRScannerKt.Z17QRScanner_HYR8e34$lambda$23$lambda$17$lambda$13$lambda$12(mutableState2, (DecoratedBarcodeView) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                        }
                        Function1 function2 = (Function1) objRememberedValue5;
                        float f12 = fM8823constructorimpl;
                        AndroidView_androidKt.AndroidView(function1, modifierM1769size3ABfNKs, function2, composerStartRestartGroup, RendererCapabilities.DECODER_SUPPORT_MASK, 0);
                        objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue6 == companion.getEmpty()) {
                            objRememberedValue6 = new lb.a() { // from class: cu.z17.views.qr.d
                                @Override // lb.a
                                public final Object invoke() {
                                    return Z17QRScannerKt.Z17QRScanner_HYR8e34$lambda$23$lambda$17$lambda$15$lambda$14(mutableState2);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                        }
                        ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1801712811, true, new Function2() { // from class: cu.z17.views.qr.e
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return Z17QRScannerKt.Z17QRScanner_HYR8e34$lambda$23$lambda$17$lambda$16(mutableState2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                        i18 = i12;
                        Modifier modifier5 = modifier4;
                        IconButtonKt.IconButton((lb.a) objRememberedValue6, null, false, null, null, composableLambdaRememberComposableLambda, composerStartRestartGroup, 196614, 30);
                        composerStartRestartGroup = composerStartRestartGroup;
                        composerStartRestartGroup.endNode();
                        SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion4, Dp.m8823constructorimpl(5)), composerStartRestartGroup, 6);
                        if (z13) {
                            composerStartRestartGroup.startReplaceGroup(1843897229);
                            if ((i18 & 896) == 256) {
                                z14 = true;
                            } else {
                                z14 = false;
                            }
                            objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                            if (z14 || objRememberedValue8 == companion.getEmpty()) {
                                objRememberedValue8 = new lb.a() { // from class: cu.z17.views.qr.f
                                    @Override // lb.a
                                    public final Object invoke() {
                                        return Z17QRScannerKt.Z17QRScanner_HYR8e34$lambda$23$lambda$19$lambda$18(handleCancelScan);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                            }
                            str5 = str4;
                            Z17ButtonsKt.Z17SecondaryDialogButton(null, (lb.a) objRememberedValue8, str5, null, false, false, false, composerStartRestartGroup, (i18 >> 3) & 896, 121);
                            composerStartRestartGroup = composerStartRestartGroup;
                        } else {
                            str5 = str4;
                            composerStartRestartGroup.startReplaceGroup(1322436080);
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        k0 k0Var = k0.f43947a;
                        zChangedInstance2 = composerStartRestartGroup.changedInstance(decoratedBarcodeView);
                        objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                        if (zChangedInstance2 || objRememberedValue7 == companion.getEmpty()) {
                            objRememberedValue7 = new Function1() { // from class: cu.z17.views.qr.g
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return Z17QRScannerKt.Z17QRScanner_HYR8e34$lambda$23$lambda$22$lambda$21(decoratedBarcodeView, (DisposableEffectScope) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                        }
                        EffectsKt.DisposableEffect(k0Var, (Function1) objRememberedValue7, composerStartRestartGroup, 6);
                        composerStartRestartGroup.endNode();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        f11 = f12;
                        str3 = str5;
                        z12 = z13;
                        modifier3 = modifier5;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        z12 = z10;
                        f11 = f10;
                        modifier3 = modifier2;
                        str3 = str2;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.qr.h
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return Z17QRScannerKt.Z17QRScanner_HYR8e34$lambda$24(modifier3, handleCorrectScan, handleCancelScan, str3, z12, f11, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i12 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                if ((i12 & 74899) != 74898) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z11, i12 & 1)) {
                    if (i19 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i20 != 0) {
                        str4 = "Cancel";
                    } else {
                        str4 = str2;
                    }
                    if (i13 != 0) {
                        z13 = false;
                    } else {
                        z13 = z10;
                    }
                    if (i15 != 0) {
                        fM8823constructorimpl = Dp.m8823constructorimpl(250);
                    } else {
                        fM8823constructorimpl = f10;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1827776452, i12, -1, "cu.z17.views.qr.Z17QRScanner (Z17QRScanner.kt:41)");
                    }
                    Arrangement.HorizontalOrVertical spaceBetween2 = Arrangement.INSTANCE.getSpaceBetween();
                    Alignment.Companion companion5 = Alignment.INSTANCE;
                    MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(spaceBetween2, companion5.getCenterHorizontally(), composerStartRestartGroup, 54);
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier4);
                    ComposeUiNode.Companion companion6 = ComposeUiNode.INSTANCE;
                    constructor = companion6.getConstructor();
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
                    Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyColumnMeasurePolicy2, companion6.getSetMeasurePolicy());
                    Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap3, companion6.getSetResolvedCompositionLocals());
                    setCompositeKeyHash = companion6.getSetCompositeKeyHash();
                    if (composerM5176constructorimpl.getInserting()) {
                        composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    } else {
                        composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier3, companion6.getSetModifier());
                    ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
                    context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    companion = Composer.INSTANCE;
                    if (objRememberedValue == companion.getEmpty()) {
                        i17 = 2;
                        objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        i17 = 2;
                    }
                    mutableState = (MutableState) objRememberedValue;
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == companion.getEmpty()) {
                        objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, i17, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    mutableState2 = (MutableState) objRememberedValue2;
                    Object objConsume2 = composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                    y.g(objConsume2, "null cannot be cast to non-null type android.app.Activity");
                    eVar = new e6.e((Activity) objConsume2);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue3 == companion.getEmpty()) {
                        decoratedBarcodeView2 = new DecoratedBarcodeView(context);
                        y.g(context, "null cannot be cast to non-null type android.app.Activity");
                        Activity activity2 = (Activity) context;
                        com.journeyapps.barcodescanner.a aVar2 = new com.journeyapps.barcodescanner.a(activity2, decoratedBarcodeView2);
                        aVar2.p(activity2.getIntent(), null);
                        decoratedBarcodeView2.setStatusText("");
                        aVar2.l();
                        if (Z17QRScanner_HYR8e34$lambda$23$lambda$4(mutableState2)) {
                            decoratedBarcodeView2.k();
                        } else {
                            decoratedBarcodeView2.j();
                        }
                        decoratedBarcodeView2.b(new a7.b() { // from class: cu.z17.views.qr.a
                            @Override // a7.b
                            public /* synthetic */ void a(List list) {
                                a7.a.a(this, list);
                            }

                            @Override // a7.b
                            public final void b(a7.c cVar) {
                                Z17QRScannerKt.Z17QRScanner_HYR8e34$lambda$23$lambda$9$lambda$8$lambda$7(decoratedBarcodeView2, mutableState, mutableState2, eVar, handleCorrectScan, cVar);
                            }
                        });
                        decoratedBarcodeView2.i();
                        composerStartRestartGroup.updateRememberedValue(decoratedBarcodeView2);
                        objRememberedValue3 = decoratedBarcodeView2;
                    }
                    decoratedBarcodeView = (DecoratedBarcodeView) objRememberedValue3;
                    Modifier.Companion companion7 = Modifier.INSTANCE;
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(companion5.getTopStart(), false);
                    currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion7);
                    constructor2 = companion6.getConstructor();
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
                    Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy2, companion6.getSetMeasurePolicy());
                    Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap4, companion6.getSetResolvedCompositionLocals());
                    setCompositeKeyHash2 = companion6.getSetCompositeKeyHash();
                    if (composerM5176constructorimpl2.getInserting()) {
                        composerM5176constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                        composerM5176constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                    } else {
                        composerM5176constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                        composerM5176constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                    }
                    Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier4, companion6.getSetModifier());
                    BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                    zChangedInstance = composerStartRestartGroup.changedInstance(decoratedBarcodeView);
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (zChangedInstance) {
                        objRememberedValue4 = new Function1() { // from class: cu.z17.views.qr.b
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return Z17QRScannerKt.Z17QRScanner_HYR8e34$lambda$23$lambda$17$lambda$11$lambda$10(decoratedBarcodeView, (Context) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    } else {
                        objRememberedValue4 = new Function1() { // from class: cu.z17.views.qr.b
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return Z17QRScannerKt.Z17QRScanner_HYR8e34$lambda$23$lambda$17$lambda$11$lambda$10(decoratedBarcodeView, (Context) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    Function1 function3 = (Function1) objRememberedValue4;
                    Modifier modifierM1769size3ABfNKs2 = SizeKt.m1769size3ABfNKs(companion7, fM8823constructorimpl);
                    objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue5 == companion.getEmpty()) {
                        objRememberedValue5 = new Function1() { // from class: cu.z17.views.qr.c
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return Z17QRScannerKt.Z17QRScanner_HYR8e34$lambda$23$lambda$17$lambda$13$lambda$12(mutableState2, (DecoratedBarcodeView) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    }
                    Function1 function4 = (Function1) objRememberedValue5;
                    float f13 = fM8823constructorimpl;
                    AndroidView_androidKt.AndroidView(function3, modifierM1769size3ABfNKs2, function4, composerStartRestartGroup, RendererCapabilities.DECODER_SUPPORT_MASK, 0);
                    objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue6 == companion.getEmpty()) {
                        objRememberedValue6 = new lb.a() { // from class: cu.z17.views.qr.d
                            @Override // lb.a
                            public final Object invoke() {
                                return Z17QRScannerKt.Z17QRScanner_HYR8e34$lambda$23$lambda$17$lambda$15$lambda$14(mutableState2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                    }
                    ComposableLambda composableLambdaRememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(-1801712811, true, new Function2() { // from class: cu.z17.views.qr.e
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return Z17QRScannerKt.Z17QRScanner_HYR8e34$lambda$23$lambda$17$lambda$16(mutableState2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                    i18 = i12;
                    Modifier modifier6 = modifier4;
                    IconButtonKt.IconButton((lb.a) objRememberedValue6, null, false, null, null, composableLambdaRememberComposableLambda2, composerStartRestartGroup, 196614, 30);
                    composerStartRestartGroup = composerStartRestartGroup;
                    composerStartRestartGroup.endNode();
                    SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion7, Dp.m8823constructorimpl(5)), composerStartRestartGroup, 6);
                    if (z13) {
                        composerStartRestartGroup.startReplaceGroup(1843897229);
                        if ((i18 & 896) == 256) {
                            z14 = true;
                        } else {
                            z14 = false;
                        }
                        objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                        if (z14) {
                            objRememberedValue8 = new lb.a() { // from class: cu.z17.views.qr.f
                                @Override // lb.a
                                public final Object invoke() {
                                    return Z17QRScannerKt.Z17QRScanner_HYR8e34$lambda$23$lambda$19$lambda$18(handleCancelScan);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                        } else {
                            objRememberedValue8 = new lb.a() { // from class: cu.z17.views.qr.f
                                @Override // lb.a
                                public final Object invoke() {
                                    return Z17QRScannerKt.Z17QRScanner_HYR8e34$lambda$23$lambda$19$lambda$18(handleCancelScan);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                        }
                        str5 = str4;
                        Z17ButtonsKt.Z17SecondaryDialogButton(null, (lb.a) objRememberedValue8, str5, null, false, false, false, composerStartRestartGroup, (i18 >> 3) & 896, 121);
                        composerStartRestartGroup = composerStartRestartGroup;
                    } else {
                        str5 = str4;
                        composerStartRestartGroup.startReplaceGroup(1322436080);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    k0 k0Var2 = k0.f43947a;
                    zChangedInstance2 = composerStartRestartGroup.changedInstance(decoratedBarcodeView);
                    objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                    if (zChangedInstance2) {
                        objRememberedValue7 = new Function1() { // from class: cu.z17.views.qr.g
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return Z17QRScannerKt.Z17QRScanner_HYR8e34$lambda$23$lambda$22$lambda$21(decoratedBarcodeView, (DisposableEffectScope) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                    } else {
                        objRememberedValue7 = new Function1() { // from class: cu.z17.views.qr.g
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return Z17QRScannerKt.Z17QRScanner_HYR8e34$lambda$23$lambda$22$lambda$21(decoratedBarcodeView, (DisposableEffectScope) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                    }
                    EffectsKt.DisposableEffect(k0Var2, (Function1) objRememberedValue7, composerStartRestartGroup, 6);
                    composerStartRestartGroup.endNode();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    f11 = f13;
                    str3 = str5;
                    z12 = z13;
                    modifier3 = modifier6;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    z12 = z10;
                    f11 = f10;
                    modifier3 = modifier2;
                    str3 = str2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.qr.h
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return Z17QRScannerKt.Z17QRScanner_HYR8e34$lambda$24(modifier3, handleCorrectScan, handleCancelScan, str3, z12, f11, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i12 |= 24576;
            i15 = i11 & 32;
            if (i15 != 0) {
                if ((196608 & i10) == 0) {
                    if (composerStartRestartGroup.changed(f10)) {
                        i16 = 131072;
                    } else {
                        i16 = 65536;
                    }
                    i12 |= i16;
                }
                if ((i12 & 74899) != 74898) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z11, i12 & 1)) {
                    if (i19 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i20 != 0) {
                        str4 = "Cancel";
                    } else {
                        str4 = str2;
                    }
                    if (i13 != 0) {
                        z13 = false;
                    } else {
                        z13 = z10;
                    }
                    if (i15 != 0) {
                        fM8823constructorimpl = Dp.m8823constructorimpl(250);
                    } else {
                        fM8823constructorimpl = f10;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1827776452, i12, -1, "cu.z17.views.qr.Z17QRScanner (Z17QRScanner.kt:41)");
                    }
                    Arrangement.HorizontalOrVertical spaceBetween3 = Arrangement.INSTANCE.getSpaceBetween();
                    Alignment.Companion companion8 = Alignment.INSTANCE;
                    MeasurePolicy measurePolicyColumnMeasurePolicy3 = ColumnKt.columnMeasurePolicy(spaceBetween3, companion8.getCenterHorizontally(), composerStartRestartGroup, 54);
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap5 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier5 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier4);
                    ComposeUiNode.Companion companion9 = ComposeUiNode.INSTANCE;
                    constructor = companion9.getConstructor();
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
                    Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyColumnMeasurePolicy3, companion9.getSetMeasurePolicy());
                    Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap5, companion9.getSetResolvedCompositionLocals());
                    setCompositeKeyHash = companion9.getSetCompositeKeyHash();
                    if (composerM5176constructorimpl.getInserting()) {
                        composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    } else {
                        composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier5, companion9.getSetModifier());
                    ColumnScopeInstance columnScopeInstance3 = ColumnScopeInstance.INSTANCE;
                    context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    companion = Composer.INSTANCE;
                    if (objRememberedValue == companion.getEmpty()) {
                        i17 = 2;
                        objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        i17 = 2;
                    }
                    mutableState = (MutableState) objRememberedValue;
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == companion.getEmpty()) {
                        objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, i17, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    mutableState2 = (MutableState) objRememberedValue2;
                    Object objConsume3 = composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                    y.g(objConsume3, "null cannot be cast to non-null type android.app.Activity");
                    eVar = new e6.e((Activity) objConsume3);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue3 == companion.getEmpty()) {
                        decoratedBarcodeView2 = new DecoratedBarcodeView(context);
                        y.g(context, "null cannot be cast to non-null type android.app.Activity");
                        Activity activity3 = (Activity) context;
                        com.journeyapps.barcodescanner.a aVar3 = new com.journeyapps.barcodescanner.a(activity3, decoratedBarcodeView2);
                        aVar3.p(activity3.getIntent(), null);
                        decoratedBarcodeView2.setStatusText("");
                        aVar3.l();
                        if (Z17QRScanner_HYR8e34$lambda$23$lambda$4(mutableState2)) {
                            decoratedBarcodeView2.k();
                        } else {
                            decoratedBarcodeView2.j();
                        }
                        decoratedBarcodeView2.b(new a7.b() { // from class: cu.z17.views.qr.a
                            @Override // a7.b
                            public /* synthetic */ void a(List list) {
                                a7.a.a(this, list);
                            }

                            @Override // a7.b
                            public final void b(a7.c cVar) {
                                Z17QRScannerKt.Z17QRScanner_HYR8e34$lambda$23$lambda$9$lambda$8$lambda$7(decoratedBarcodeView2, mutableState, mutableState2, eVar, handleCorrectScan, cVar);
                            }
                        });
                        decoratedBarcodeView2.i();
                        composerStartRestartGroup.updateRememberedValue(decoratedBarcodeView2);
                        objRememberedValue3 = decoratedBarcodeView2;
                    }
                    decoratedBarcodeView = (DecoratedBarcodeView) objRememberedValue3;
                    Modifier.Companion companion10 = Modifier.INSTANCE;
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(companion8.getTopStart(), false);
                    currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap6 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier6 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion10);
                    constructor2 = companion9.getConstructor();
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
                    Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy3, companion9.getSetMeasurePolicy());
                    Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap6, companion9.getSetResolvedCompositionLocals());
                    setCompositeKeyHash2 = companion9.getSetCompositeKeyHash();
                    if (composerM5176constructorimpl2.getInserting()) {
                        composerM5176constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                        composerM5176constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                    } else {
                        composerM5176constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                        composerM5176constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                    }
                    Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier6, companion9.getSetModifier());
                    BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
                    zChangedInstance = composerStartRestartGroup.changedInstance(decoratedBarcodeView);
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (zChangedInstance) {
                        objRememberedValue4 = new Function1() { // from class: cu.z17.views.qr.b
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return Z17QRScannerKt.Z17QRScanner_HYR8e34$lambda$23$lambda$17$lambda$11$lambda$10(decoratedBarcodeView, (Context) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    } else {
                        objRememberedValue4 = new Function1() { // from class: cu.z17.views.qr.b
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return Z17QRScannerKt.Z17QRScanner_HYR8e34$lambda$23$lambda$17$lambda$11$lambda$10(decoratedBarcodeView, (Context) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    Function1 function5 = (Function1) objRememberedValue4;
                    Modifier modifierM1769size3ABfNKs3 = SizeKt.m1769size3ABfNKs(companion10, fM8823constructorimpl);
                    objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue5 == companion.getEmpty()) {
                        objRememberedValue5 = new Function1() { // from class: cu.z17.views.qr.c
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return Z17QRScannerKt.Z17QRScanner_HYR8e34$lambda$23$lambda$17$lambda$13$lambda$12(mutableState2, (DecoratedBarcodeView) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    }
                    Function1 function6 = (Function1) objRememberedValue5;
                    float f14 = fM8823constructorimpl;
                    AndroidView_androidKt.AndroidView(function5, modifierM1769size3ABfNKs3, function6, composerStartRestartGroup, RendererCapabilities.DECODER_SUPPORT_MASK, 0);
                    objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue6 == companion.getEmpty()) {
                        objRememberedValue6 = new lb.a() { // from class: cu.z17.views.qr.d
                            @Override // lb.a
                            public final Object invoke() {
                                return Z17QRScannerKt.Z17QRScanner_HYR8e34$lambda$23$lambda$17$lambda$15$lambda$14(mutableState2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                    }
                    ComposableLambda composableLambdaRememberComposableLambda3 = ComposableLambdaKt.rememberComposableLambda(-1801712811, true, new Function2() { // from class: cu.z17.views.qr.e
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return Z17QRScannerKt.Z17QRScanner_HYR8e34$lambda$23$lambda$17$lambda$16(mutableState2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                    i18 = i12;
                    Modifier modifier7 = modifier4;
                    IconButtonKt.IconButton((lb.a) objRememberedValue6, null, false, null, null, composableLambdaRememberComposableLambda3, composerStartRestartGroup, 196614, 30);
                    composerStartRestartGroup = composerStartRestartGroup;
                    composerStartRestartGroup.endNode();
                    SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion10, Dp.m8823constructorimpl(5)), composerStartRestartGroup, 6);
                    if (z13) {
                        composerStartRestartGroup.startReplaceGroup(1843897229);
                        if ((i18 & 896) == 256) {
                            z14 = true;
                        } else {
                            z14 = false;
                        }
                        objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                        if (z14) {
                            objRememberedValue8 = new lb.a() { // from class: cu.z17.views.qr.f
                                @Override // lb.a
                                public final Object invoke() {
                                    return Z17QRScannerKt.Z17QRScanner_HYR8e34$lambda$23$lambda$19$lambda$18(handleCancelScan);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                        } else {
                            objRememberedValue8 = new lb.a() { // from class: cu.z17.views.qr.f
                                @Override // lb.a
                                public final Object invoke() {
                                    return Z17QRScannerKt.Z17QRScanner_HYR8e34$lambda$23$lambda$19$lambda$18(handleCancelScan);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                        }
                        str5 = str4;
                        Z17ButtonsKt.Z17SecondaryDialogButton(null, (lb.a) objRememberedValue8, str5, null, false, false, false, composerStartRestartGroup, (i18 >> 3) & 896, 121);
                        composerStartRestartGroup = composerStartRestartGroup;
                    } else {
                        str5 = str4;
                        composerStartRestartGroup.startReplaceGroup(1322436080);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    k0 k0Var3 = k0.f43947a;
                    zChangedInstance2 = composerStartRestartGroup.changedInstance(decoratedBarcodeView);
                    objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                    if (zChangedInstance2) {
                        objRememberedValue7 = new Function1() { // from class: cu.z17.views.qr.g
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return Z17QRScannerKt.Z17QRScanner_HYR8e34$lambda$23$lambda$22$lambda$21(decoratedBarcodeView, (DisposableEffectScope) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                    } else {
                        objRememberedValue7 = new Function1() { // from class: cu.z17.views.qr.g
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return Z17QRScannerKt.Z17QRScanner_HYR8e34$lambda$23$lambda$22$lambda$21(decoratedBarcodeView, (DisposableEffectScope) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                    }
                    EffectsKt.DisposableEffect(k0Var3, (Function1) objRememberedValue7, composerStartRestartGroup, 6);
                    composerStartRestartGroup.endNode();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    f11 = f14;
                    str3 = str5;
                    z12 = z13;
                    modifier3 = modifier7;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    z12 = z10;
                    f11 = f10;
                    modifier3 = modifier2;
                    str3 = str2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.qr.h
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return Z17QRScannerKt.Z17QRScanner_HYR8e34$lambda$24(modifier3, handleCorrectScan, handleCancelScan, str3, z12, f11, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i12 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            if ((i12 & 74899) != 74898) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z11, i12 & 1)) {
                if (i19 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (i20 != 0) {
                    str4 = "Cancel";
                } else {
                    str4 = str2;
                }
                if (i13 != 0) {
                    z13 = false;
                } else {
                    z13 = z10;
                }
                if (i15 != 0) {
                    fM8823constructorimpl = Dp.m8823constructorimpl(250);
                } else {
                    fM8823constructorimpl = f10;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1827776452, i12, -1, "cu.z17.views.qr.Z17QRScanner (Z17QRScanner.kt:41)");
                }
                Arrangement.HorizontalOrVertical spaceBetween4 = Arrangement.INSTANCE.getSpaceBetween();
                Alignment.Companion companion11 = Alignment.INSTANCE;
                MeasurePolicy measurePolicyColumnMeasurePolicy4 = ColumnKt.columnMeasurePolicy(spaceBetween4, companion11.getCenterHorizontally(), composerStartRestartGroup, 54);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap7 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier7 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier4);
                ComposeUiNode.Companion companion12 = ComposeUiNode.INSTANCE;
                constructor = companion12.getConstructor();
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
                Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyColumnMeasurePolicy4, companion12.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap7, companion12.getSetResolvedCompositionLocals());
                setCompositeKeyHash = companion12.getSetCompositeKeyHash();
                if (composerM5176constructorimpl.getInserting()) {
                    composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                } else {
                    composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier7, companion12.getSetModifier());
                ColumnScopeInstance columnScopeInstance4 = ColumnScopeInstance.INSTANCE;
                context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                companion = Composer.INSTANCE;
                if (objRememberedValue == companion.getEmpty()) {
                    i17 = 2;
                    objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    i17 = 2;
                }
                mutableState = (MutableState) objRememberedValue;
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == companion.getEmpty()) {
                    objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, i17, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                mutableState2 = (MutableState) objRememberedValue2;
                Object objConsume4 = composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                y.g(objConsume4, "null cannot be cast to non-null type android.app.Activity");
                eVar = new e6.e((Activity) objConsume4);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue3 == companion.getEmpty()) {
                    decoratedBarcodeView2 = new DecoratedBarcodeView(context);
                    y.g(context, "null cannot be cast to non-null type android.app.Activity");
                    Activity activity4 = (Activity) context;
                    com.journeyapps.barcodescanner.a aVar4 = new com.journeyapps.barcodescanner.a(activity4, decoratedBarcodeView2);
                    aVar4.p(activity4.getIntent(), null);
                    decoratedBarcodeView2.setStatusText("");
                    aVar4.l();
                    if (Z17QRScanner_HYR8e34$lambda$23$lambda$4(mutableState2)) {
                        decoratedBarcodeView2.k();
                    } else {
                        decoratedBarcodeView2.j();
                    }
                    decoratedBarcodeView2.b(new a7.b() { // from class: cu.z17.views.qr.a
                        @Override // a7.b
                        public /* synthetic */ void a(List list) {
                            a7.a.a(this, list);
                        }

                        @Override // a7.b
                        public final void b(a7.c cVar) {
                            Z17QRScannerKt.Z17QRScanner_HYR8e34$lambda$23$lambda$9$lambda$8$lambda$7(decoratedBarcodeView2, mutableState, mutableState2, eVar, handleCorrectScan, cVar);
                        }
                    });
                    decoratedBarcodeView2.i();
                    composerStartRestartGroup.updateRememberedValue(decoratedBarcodeView2);
                    objRememberedValue3 = decoratedBarcodeView2;
                }
                decoratedBarcodeView = (DecoratedBarcodeView) objRememberedValue3;
                Modifier.Companion companion13 = Modifier.INSTANCE;
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy4 = BoxKt.maybeCachedBoxMeasurePolicy(companion11.getTopStart(), false);
                currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap8 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier8 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion13);
                constructor2 = companion12.getConstructor();
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
                Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy4, companion12.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap8, companion12.getSetResolvedCompositionLocals());
                setCompositeKeyHash2 = companion12.getSetCompositeKeyHash();
                if (composerM5176constructorimpl2.getInserting()) {
                    composerM5176constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    composerM5176constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                } else {
                    composerM5176constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    composerM5176constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                }
                Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier8, companion12.getSetModifier());
                BoxScopeInstance boxScopeInstance4 = BoxScopeInstance.INSTANCE;
                zChangedInstance = composerStartRestartGroup.changedInstance(decoratedBarcodeView);
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance) {
                    objRememberedValue4 = new Function1() { // from class: cu.z17.views.qr.b
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return Z17QRScannerKt.Z17QRScanner_HYR8e34$lambda$23$lambda$17$lambda$11$lambda$10(decoratedBarcodeView, (Context) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                } else {
                    objRememberedValue4 = new Function1() { // from class: cu.z17.views.qr.b
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return Z17QRScannerKt.Z17QRScanner_HYR8e34$lambda$23$lambda$17$lambda$11$lambda$10(decoratedBarcodeView, (Context) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                Function1 function7 = (Function1) objRememberedValue4;
                Modifier modifierM1769size3ABfNKs4 = SizeKt.m1769size3ABfNKs(companion13, fM8823constructorimpl);
                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue5 == companion.getEmpty()) {
                    objRememberedValue5 = new Function1() { // from class: cu.z17.views.qr.c
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return Z17QRScannerKt.Z17QRScanner_HYR8e34$lambda$23$lambda$17$lambda$13$lambda$12(mutableState2, (DecoratedBarcodeView) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                Function1 function8 = (Function1) objRememberedValue5;
                float f15 = fM8823constructorimpl;
                AndroidView_androidKt.AndroidView(function7, modifierM1769size3ABfNKs4, function8, composerStartRestartGroup, RendererCapabilities.DECODER_SUPPORT_MASK, 0);
                objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue6 == companion.getEmpty()) {
                    objRememberedValue6 = new lb.a() { // from class: cu.z17.views.qr.d
                        @Override // lb.a
                        public final Object invoke() {
                            return Z17QRScannerKt.Z17QRScanner_HYR8e34$lambda$23$lambda$17$lambda$15$lambda$14(mutableState2);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                }
                ComposableLambda composableLambdaRememberComposableLambda4 = ComposableLambdaKt.rememberComposableLambda(-1801712811, true, new Function2() { // from class: cu.z17.views.qr.e
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return Z17QRScannerKt.Z17QRScanner_HYR8e34$lambda$23$lambda$17$lambda$16(mutableState2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54);
                i18 = i12;
                Modifier modifier8 = modifier4;
                IconButtonKt.IconButton((lb.a) objRememberedValue6, null, false, null, null, composableLambdaRememberComposableLambda4, composerStartRestartGroup, 196614, 30);
                composerStartRestartGroup = composerStartRestartGroup;
                composerStartRestartGroup.endNode();
                SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion13, Dp.m8823constructorimpl(5)), composerStartRestartGroup, 6);
                if (z13) {
                    composerStartRestartGroup.startReplaceGroup(1843897229);
                    if ((i18 & 896) == 256) {
                        z14 = true;
                    } else {
                        z14 = false;
                    }
                    objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                    if (z14) {
                        objRememberedValue8 = new lb.a() { // from class: cu.z17.views.qr.f
                            @Override // lb.a
                            public final Object invoke() {
                                return Z17QRScannerKt.Z17QRScanner_HYR8e34$lambda$23$lambda$19$lambda$18(handleCancelScan);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                    } else {
                        objRememberedValue8 = new lb.a() { // from class: cu.z17.views.qr.f
                            @Override // lb.a
                            public final Object invoke() {
                                return Z17QRScannerKt.Z17QRScanner_HYR8e34$lambda$23$lambda$19$lambda$18(handleCancelScan);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                    }
                    str5 = str4;
                    Z17ButtonsKt.Z17SecondaryDialogButton(null, (lb.a) objRememberedValue8, str5, null, false, false, false, composerStartRestartGroup, (i18 >> 3) & 896, 121);
                    composerStartRestartGroup = composerStartRestartGroup;
                } else {
                    str5 = str4;
                    composerStartRestartGroup.startReplaceGroup(1322436080);
                }
                composerStartRestartGroup.endReplaceGroup();
                k0 k0Var4 = k0.f43947a;
                zChangedInstance2 = composerStartRestartGroup.changedInstance(decoratedBarcodeView);
                objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance2) {
                    objRememberedValue7 = new Function1() { // from class: cu.z17.views.qr.g
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return Z17QRScannerKt.Z17QRScanner_HYR8e34$lambda$23$lambda$22$lambda$21(decoratedBarcodeView, (DisposableEffectScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                } else {
                    objRememberedValue7 = new Function1() { // from class: cu.z17.views.qr.g
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return Z17QRScannerKt.Z17QRScanner_HYR8e34$lambda$23$lambda$22$lambda$21(decoratedBarcodeView, (DisposableEffectScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                }
                EffectsKt.DisposableEffect(k0Var4, (Function1) objRememberedValue7, composerStartRestartGroup, 6);
                composerStartRestartGroup.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                f11 = f15;
                str3 = str5;
                z12 = z13;
                modifier3 = modifier8;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                z12 = z10;
                f11 = f10;
                modifier3 = modifier2;
                str3 = str2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.qr.h
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return Z17QRScannerKt.Z17QRScanner_HYR8e34$lambda$24(modifier3, handleCorrectScan, handleCancelScan, str3, z12, f11, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i12 |= 3072;
        str2 = str;
        i13 = i11 & 16;
        if (i13 != 0) {
            if ((i10 & 24576) == 0) {
                if (composerStartRestartGroup.changed(z10)) {
                    i14 = 16384;
                } else {
                    i14 = 8192;
                }
                i12 |= i14;
            }
            i15 = i11 & 32;
            if (i15 != 0) {
                if ((196608 & i10) == 0) {
                    if (composerStartRestartGroup.changed(f10)) {
                        i16 = 131072;
                    } else {
                        i16 = 65536;
                    }
                    i12 |= i16;
                }
                if ((i12 & 74899) != 74898) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z11, i12 & 1)) {
                    if (i19 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i20 != 0) {
                        str4 = "Cancel";
                    } else {
                        str4 = str2;
                    }
                    if (i13 != 0) {
                        z13 = false;
                    } else {
                        z13 = z10;
                    }
                    if (i15 != 0) {
                        fM8823constructorimpl = Dp.m8823constructorimpl(250);
                    } else {
                        fM8823constructorimpl = f10;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1827776452, i12, -1, "cu.z17.views.qr.Z17QRScanner (Z17QRScanner.kt:41)");
                    }
                    Arrangement.HorizontalOrVertical spaceBetween5 = Arrangement.INSTANCE.getSpaceBetween();
                    Alignment.Companion companion14 = Alignment.INSTANCE;
                    MeasurePolicy measurePolicyColumnMeasurePolicy5 = ColumnKt.columnMeasurePolicy(spaceBetween5, companion14.getCenterHorizontally(), composerStartRestartGroup, 54);
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap9 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier9 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier4);
                    ComposeUiNode.Companion companion15 = ComposeUiNode.INSTANCE;
                    constructor = companion15.getConstructor();
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
                    Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyColumnMeasurePolicy5, companion15.getSetMeasurePolicy());
                    Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap9, companion15.getSetResolvedCompositionLocals());
                    setCompositeKeyHash = companion15.getSetCompositeKeyHash();
                    if (composerM5176constructorimpl.getInserting()) {
                        composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    } else {
                        composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier9, companion15.getSetModifier());
                    ColumnScopeInstance columnScopeInstance5 = ColumnScopeInstance.INSTANCE;
                    context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    companion = Composer.INSTANCE;
                    if (objRememberedValue == companion.getEmpty()) {
                        i17 = 2;
                        objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        i17 = 2;
                    }
                    mutableState = (MutableState) objRememberedValue;
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == companion.getEmpty()) {
                        objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, i17, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    mutableState2 = (MutableState) objRememberedValue2;
                    Object objConsume5 = composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                    y.g(objConsume5, "null cannot be cast to non-null type android.app.Activity");
                    eVar = new e6.e((Activity) objConsume5);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue3 == companion.getEmpty()) {
                        decoratedBarcodeView2 = new DecoratedBarcodeView(context);
                        y.g(context, "null cannot be cast to non-null type android.app.Activity");
                        Activity activity5 = (Activity) context;
                        com.journeyapps.barcodescanner.a aVar5 = new com.journeyapps.barcodescanner.a(activity5, decoratedBarcodeView2);
                        aVar5.p(activity5.getIntent(), null);
                        decoratedBarcodeView2.setStatusText("");
                        aVar5.l();
                        if (Z17QRScanner_HYR8e34$lambda$23$lambda$4(mutableState2)) {
                            decoratedBarcodeView2.k();
                        } else {
                            decoratedBarcodeView2.j();
                        }
                        decoratedBarcodeView2.b(new a7.b() { // from class: cu.z17.views.qr.a
                            @Override // a7.b
                            public /* synthetic */ void a(List list) {
                                a7.a.a(this, list);
                            }

                            @Override // a7.b
                            public final void b(a7.c cVar) {
                                Z17QRScannerKt.Z17QRScanner_HYR8e34$lambda$23$lambda$9$lambda$8$lambda$7(decoratedBarcodeView2, mutableState, mutableState2, eVar, handleCorrectScan, cVar);
                            }
                        });
                        decoratedBarcodeView2.i();
                        composerStartRestartGroup.updateRememberedValue(decoratedBarcodeView2);
                        objRememberedValue3 = decoratedBarcodeView2;
                    }
                    decoratedBarcodeView = (DecoratedBarcodeView) objRememberedValue3;
                    Modifier.Companion companion16 = Modifier.INSTANCE;
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy5 = BoxKt.maybeCachedBoxMeasurePolicy(companion14.getTopStart(), false);
                    currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap10 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier10 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion16);
                    constructor2 = companion15.getConstructor();
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
                    Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy5, companion15.getSetMeasurePolicy());
                    Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap10, companion15.getSetResolvedCompositionLocals());
                    setCompositeKeyHash2 = companion15.getSetCompositeKeyHash();
                    if (composerM5176constructorimpl2.getInserting()) {
                        composerM5176constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                        composerM5176constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                    } else {
                        composerM5176constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                        composerM5176constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                    }
                    Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier10, companion15.getSetModifier());
                    BoxScopeInstance boxScopeInstance5 = BoxScopeInstance.INSTANCE;
                    zChangedInstance = composerStartRestartGroup.changedInstance(decoratedBarcodeView);
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (zChangedInstance) {
                        objRememberedValue4 = new Function1() { // from class: cu.z17.views.qr.b
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return Z17QRScannerKt.Z17QRScanner_HYR8e34$lambda$23$lambda$17$lambda$11$lambda$10(decoratedBarcodeView, (Context) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    } else {
                        objRememberedValue4 = new Function1() { // from class: cu.z17.views.qr.b
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return Z17QRScannerKt.Z17QRScanner_HYR8e34$lambda$23$lambda$17$lambda$11$lambda$10(decoratedBarcodeView, (Context) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    Function1 function9 = (Function1) objRememberedValue4;
                    Modifier modifierM1769size3ABfNKs5 = SizeKt.m1769size3ABfNKs(companion16, fM8823constructorimpl);
                    objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue5 == companion.getEmpty()) {
                        objRememberedValue5 = new Function1() { // from class: cu.z17.views.qr.c
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return Z17QRScannerKt.Z17QRScanner_HYR8e34$lambda$23$lambda$17$lambda$13$lambda$12(mutableState2, (DecoratedBarcodeView) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    }
                    Function1 function10 = (Function1) objRememberedValue5;
                    float f16 = fM8823constructorimpl;
                    AndroidView_androidKt.AndroidView(function9, modifierM1769size3ABfNKs5, function10, composerStartRestartGroup, RendererCapabilities.DECODER_SUPPORT_MASK, 0);
                    objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue6 == companion.getEmpty()) {
                        objRememberedValue6 = new lb.a() { // from class: cu.z17.views.qr.d
                            @Override // lb.a
                            public final Object invoke() {
                                return Z17QRScannerKt.Z17QRScanner_HYR8e34$lambda$23$lambda$17$lambda$15$lambda$14(mutableState2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                    }
                    ComposableLambda composableLambdaRememberComposableLambda5 = ComposableLambdaKt.rememberComposableLambda(-1801712811, true, new Function2() { // from class: cu.z17.views.qr.e
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return Z17QRScannerKt.Z17QRScanner_HYR8e34$lambda$23$lambda$17$lambda$16(mutableState2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                    i18 = i12;
                    Modifier modifier9 = modifier4;
                    IconButtonKt.IconButton((lb.a) objRememberedValue6, null, false, null, null, composableLambdaRememberComposableLambda5, composerStartRestartGroup, 196614, 30);
                    composerStartRestartGroup = composerStartRestartGroup;
                    composerStartRestartGroup.endNode();
                    SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion16, Dp.m8823constructorimpl(5)), composerStartRestartGroup, 6);
                    if (z13) {
                        composerStartRestartGroup.startReplaceGroup(1843897229);
                        if ((i18 & 896) == 256) {
                            z14 = true;
                        } else {
                            z14 = false;
                        }
                        objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                        if (z14) {
                            objRememberedValue8 = new lb.a() { // from class: cu.z17.views.qr.f
                                @Override // lb.a
                                public final Object invoke() {
                                    return Z17QRScannerKt.Z17QRScanner_HYR8e34$lambda$23$lambda$19$lambda$18(handleCancelScan);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                        } else {
                            objRememberedValue8 = new lb.a() { // from class: cu.z17.views.qr.f
                                @Override // lb.a
                                public final Object invoke() {
                                    return Z17QRScannerKt.Z17QRScanner_HYR8e34$lambda$23$lambda$19$lambda$18(handleCancelScan);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                        }
                        str5 = str4;
                        Z17ButtonsKt.Z17SecondaryDialogButton(null, (lb.a) objRememberedValue8, str5, null, false, false, false, composerStartRestartGroup, (i18 >> 3) & 896, 121);
                        composerStartRestartGroup = composerStartRestartGroup;
                    } else {
                        str5 = str4;
                        composerStartRestartGroup.startReplaceGroup(1322436080);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    k0 k0Var5 = k0.f43947a;
                    zChangedInstance2 = composerStartRestartGroup.changedInstance(decoratedBarcodeView);
                    objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                    if (zChangedInstance2) {
                        objRememberedValue7 = new Function1() { // from class: cu.z17.views.qr.g
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return Z17QRScannerKt.Z17QRScanner_HYR8e34$lambda$23$lambda$22$lambda$21(decoratedBarcodeView, (DisposableEffectScope) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                    } else {
                        objRememberedValue7 = new Function1() { // from class: cu.z17.views.qr.g
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return Z17QRScannerKt.Z17QRScanner_HYR8e34$lambda$23$lambda$22$lambda$21(decoratedBarcodeView, (DisposableEffectScope) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                    }
                    EffectsKt.DisposableEffect(k0Var5, (Function1) objRememberedValue7, composerStartRestartGroup, 6);
                    composerStartRestartGroup.endNode();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    f11 = f16;
                    str3 = str5;
                    z12 = z13;
                    modifier3 = modifier9;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    z12 = z10;
                    f11 = f10;
                    modifier3 = modifier2;
                    str3 = str2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.qr.h
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return Z17QRScannerKt.Z17QRScanner_HYR8e34$lambda$24(modifier3, handleCorrectScan, handleCancelScan, str3, z12, f11, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i12 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            if ((i12 & 74899) != 74898) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z11, i12 & 1)) {
                if (i19 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (i20 != 0) {
                    str4 = "Cancel";
                } else {
                    str4 = str2;
                }
                if (i13 != 0) {
                    z13 = false;
                } else {
                    z13 = z10;
                }
                if (i15 != 0) {
                    fM8823constructorimpl = Dp.m8823constructorimpl(250);
                } else {
                    fM8823constructorimpl = f10;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1827776452, i12, -1, "cu.z17.views.qr.Z17QRScanner (Z17QRScanner.kt:41)");
                }
                Arrangement.HorizontalOrVertical spaceBetween6 = Arrangement.INSTANCE.getSpaceBetween();
                Alignment.Companion companion17 = Alignment.INSTANCE;
                MeasurePolicy measurePolicyColumnMeasurePolicy6 = ColumnKt.columnMeasurePolicy(spaceBetween6, companion17.getCenterHorizontally(), composerStartRestartGroup, 54);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap11 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier11 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier4);
                ComposeUiNode.Companion companion18 = ComposeUiNode.INSTANCE;
                constructor = companion18.getConstructor();
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
                Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyColumnMeasurePolicy6, companion18.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap11, companion18.getSetResolvedCompositionLocals());
                setCompositeKeyHash = companion18.getSetCompositeKeyHash();
                if (composerM5176constructorimpl.getInserting()) {
                    composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                } else {
                    composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier11, companion18.getSetModifier());
                ColumnScopeInstance columnScopeInstance6 = ColumnScopeInstance.INSTANCE;
                context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                companion = Composer.INSTANCE;
                if (objRememberedValue == companion.getEmpty()) {
                    i17 = 2;
                    objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    i17 = 2;
                }
                mutableState = (MutableState) objRememberedValue;
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == companion.getEmpty()) {
                    objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, i17, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                mutableState2 = (MutableState) objRememberedValue2;
                Object objConsume6 = composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                y.g(objConsume6, "null cannot be cast to non-null type android.app.Activity");
                eVar = new e6.e((Activity) objConsume6);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue3 == companion.getEmpty()) {
                    decoratedBarcodeView2 = new DecoratedBarcodeView(context);
                    y.g(context, "null cannot be cast to non-null type android.app.Activity");
                    Activity activity6 = (Activity) context;
                    com.journeyapps.barcodescanner.a aVar6 = new com.journeyapps.barcodescanner.a(activity6, decoratedBarcodeView2);
                    aVar6.p(activity6.getIntent(), null);
                    decoratedBarcodeView2.setStatusText("");
                    aVar6.l();
                    if (Z17QRScanner_HYR8e34$lambda$23$lambda$4(mutableState2)) {
                        decoratedBarcodeView2.k();
                    } else {
                        decoratedBarcodeView2.j();
                    }
                    decoratedBarcodeView2.b(new a7.b() { // from class: cu.z17.views.qr.a
                        @Override // a7.b
                        public /* synthetic */ void a(List list) {
                            a7.a.a(this, list);
                        }

                        @Override // a7.b
                        public final void b(a7.c cVar) {
                            Z17QRScannerKt.Z17QRScanner_HYR8e34$lambda$23$lambda$9$lambda$8$lambda$7(decoratedBarcodeView2, mutableState, mutableState2, eVar, handleCorrectScan, cVar);
                        }
                    });
                    decoratedBarcodeView2.i();
                    composerStartRestartGroup.updateRememberedValue(decoratedBarcodeView2);
                    objRememberedValue3 = decoratedBarcodeView2;
                }
                decoratedBarcodeView = (DecoratedBarcodeView) objRememberedValue3;
                Modifier.Companion companion19 = Modifier.INSTANCE;
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy6 = BoxKt.maybeCachedBoxMeasurePolicy(companion17.getTopStart(), false);
                currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap12 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier12 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion19);
                constructor2 = companion18.getConstructor();
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
                Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy6, companion18.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap12, companion18.getSetResolvedCompositionLocals());
                setCompositeKeyHash2 = companion18.getSetCompositeKeyHash();
                if (composerM5176constructorimpl2.getInserting()) {
                    composerM5176constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    composerM5176constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                } else {
                    composerM5176constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    composerM5176constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                }
                Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier12, companion18.getSetModifier());
                BoxScopeInstance boxScopeInstance6 = BoxScopeInstance.INSTANCE;
                zChangedInstance = composerStartRestartGroup.changedInstance(decoratedBarcodeView);
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance) {
                    objRememberedValue4 = new Function1() { // from class: cu.z17.views.qr.b
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return Z17QRScannerKt.Z17QRScanner_HYR8e34$lambda$23$lambda$17$lambda$11$lambda$10(decoratedBarcodeView, (Context) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                } else {
                    objRememberedValue4 = new Function1() { // from class: cu.z17.views.qr.b
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return Z17QRScannerKt.Z17QRScanner_HYR8e34$lambda$23$lambda$17$lambda$11$lambda$10(decoratedBarcodeView, (Context) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                Function1 function11 = (Function1) objRememberedValue4;
                Modifier modifierM1769size3ABfNKs6 = SizeKt.m1769size3ABfNKs(companion19, fM8823constructorimpl);
                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue5 == companion.getEmpty()) {
                    objRememberedValue5 = new Function1() { // from class: cu.z17.views.qr.c
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return Z17QRScannerKt.Z17QRScanner_HYR8e34$lambda$23$lambda$17$lambda$13$lambda$12(mutableState2, (DecoratedBarcodeView) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                Function1 function12 = (Function1) objRememberedValue5;
                float f17 = fM8823constructorimpl;
                AndroidView_androidKt.AndroidView(function11, modifierM1769size3ABfNKs6, function12, composerStartRestartGroup, RendererCapabilities.DECODER_SUPPORT_MASK, 0);
                objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue6 == companion.getEmpty()) {
                    objRememberedValue6 = new lb.a() { // from class: cu.z17.views.qr.d
                        @Override // lb.a
                        public final Object invoke() {
                            return Z17QRScannerKt.Z17QRScanner_HYR8e34$lambda$23$lambda$17$lambda$15$lambda$14(mutableState2);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                }
                ComposableLambda composableLambdaRememberComposableLambda6 = ComposableLambdaKt.rememberComposableLambda(-1801712811, true, new Function2() { // from class: cu.z17.views.qr.e
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return Z17QRScannerKt.Z17QRScanner_HYR8e34$lambda$23$lambda$17$lambda$16(mutableState2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54);
                i18 = i12;
                Modifier modifier10 = modifier4;
                IconButtonKt.IconButton((lb.a) objRememberedValue6, null, false, null, null, composableLambdaRememberComposableLambda6, composerStartRestartGroup, 196614, 30);
                composerStartRestartGroup = composerStartRestartGroup;
                composerStartRestartGroup.endNode();
                SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion19, Dp.m8823constructorimpl(5)), composerStartRestartGroup, 6);
                if (z13) {
                    composerStartRestartGroup.startReplaceGroup(1843897229);
                    if ((i18 & 896) == 256) {
                        z14 = true;
                    } else {
                        z14 = false;
                    }
                    objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                    if (z14) {
                        objRememberedValue8 = new lb.a() { // from class: cu.z17.views.qr.f
                            @Override // lb.a
                            public final Object invoke() {
                                return Z17QRScannerKt.Z17QRScanner_HYR8e34$lambda$23$lambda$19$lambda$18(handleCancelScan);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                    } else {
                        objRememberedValue8 = new lb.a() { // from class: cu.z17.views.qr.f
                            @Override // lb.a
                            public final Object invoke() {
                                return Z17QRScannerKt.Z17QRScanner_HYR8e34$lambda$23$lambda$19$lambda$18(handleCancelScan);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                    }
                    str5 = str4;
                    Z17ButtonsKt.Z17SecondaryDialogButton(null, (lb.a) objRememberedValue8, str5, null, false, false, false, composerStartRestartGroup, (i18 >> 3) & 896, 121);
                    composerStartRestartGroup = composerStartRestartGroup;
                } else {
                    str5 = str4;
                    composerStartRestartGroup.startReplaceGroup(1322436080);
                }
                composerStartRestartGroup.endReplaceGroup();
                k0 k0Var6 = k0.f43947a;
                zChangedInstance2 = composerStartRestartGroup.changedInstance(decoratedBarcodeView);
                objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance2) {
                    objRememberedValue7 = new Function1() { // from class: cu.z17.views.qr.g
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return Z17QRScannerKt.Z17QRScanner_HYR8e34$lambda$23$lambda$22$lambda$21(decoratedBarcodeView, (DisposableEffectScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                } else {
                    objRememberedValue7 = new Function1() { // from class: cu.z17.views.qr.g
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return Z17QRScannerKt.Z17QRScanner_HYR8e34$lambda$23$lambda$22$lambda$21(decoratedBarcodeView, (DisposableEffectScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                }
                EffectsKt.DisposableEffect(k0Var6, (Function1) objRememberedValue7, composerStartRestartGroup, 6);
                composerStartRestartGroup.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                f11 = f17;
                str3 = str5;
                z12 = z13;
                modifier3 = modifier10;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                z12 = z10;
                f11 = f10;
                modifier3 = modifier2;
                str3 = str2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.qr.h
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return Z17QRScannerKt.Z17QRScanner_HYR8e34$lambda$24(modifier3, handleCorrectScan, handleCancelScan, str3, z12, f11, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i12 |= 24576;
        i15 = i11 & 32;
        if (i15 != 0) {
            if ((196608 & i10) == 0) {
                if (composerStartRestartGroup.changed(f10)) {
                    i16 = 131072;
                } else {
                    i16 = 65536;
                }
                i12 |= i16;
            }
            if ((i12 & 74899) != 74898) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z11, i12 & 1)) {
                if (i19 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (i20 != 0) {
                    str4 = "Cancel";
                } else {
                    str4 = str2;
                }
                if (i13 != 0) {
                    z13 = false;
                } else {
                    z13 = z10;
                }
                if (i15 != 0) {
                    fM8823constructorimpl = Dp.m8823constructorimpl(250);
                } else {
                    fM8823constructorimpl = f10;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1827776452, i12, -1, "cu.z17.views.qr.Z17QRScanner (Z17QRScanner.kt:41)");
                }
                Arrangement.HorizontalOrVertical spaceBetween7 = Arrangement.INSTANCE.getSpaceBetween();
                Alignment.Companion companion110 = Alignment.INSTANCE;
                MeasurePolicy measurePolicyColumnMeasurePolicy7 = ColumnKt.columnMeasurePolicy(spaceBetween7, companion110.getCenterHorizontally(), composerStartRestartGroup, 54);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap13 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier13 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier4);
                ComposeUiNode.Companion companion111 = ComposeUiNode.INSTANCE;
                constructor = companion111.getConstructor();
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
                Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyColumnMeasurePolicy7, companion111.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap13, companion111.getSetResolvedCompositionLocals());
                setCompositeKeyHash = companion111.getSetCompositeKeyHash();
                if (composerM5176constructorimpl.getInserting()) {
                    composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                } else {
                    composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier13, companion111.getSetModifier());
                ColumnScopeInstance columnScopeInstance7 = ColumnScopeInstance.INSTANCE;
                context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                companion = Composer.INSTANCE;
                if (objRememberedValue == companion.getEmpty()) {
                    i17 = 2;
                    objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    i17 = 2;
                }
                mutableState = (MutableState) objRememberedValue;
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == companion.getEmpty()) {
                    objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, i17, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                mutableState2 = (MutableState) objRememberedValue2;
                Object objConsume7 = composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                y.g(objConsume7, "null cannot be cast to non-null type android.app.Activity");
                eVar = new e6.e((Activity) objConsume7);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue3 == companion.getEmpty()) {
                    decoratedBarcodeView2 = new DecoratedBarcodeView(context);
                    y.g(context, "null cannot be cast to non-null type android.app.Activity");
                    Activity activity7 = (Activity) context;
                    com.journeyapps.barcodescanner.a aVar7 = new com.journeyapps.barcodescanner.a(activity7, decoratedBarcodeView2);
                    aVar7.p(activity7.getIntent(), null);
                    decoratedBarcodeView2.setStatusText("");
                    aVar7.l();
                    if (Z17QRScanner_HYR8e34$lambda$23$lambda$4(mutableState2)) {
                        decoratedBarcodeView2.k();
                    } else {
                        decoratedBarcodeView2.j();
                    }
                    decoratedBarcodeView2.b(new a7.b() { // from class: cu.z17.views.qr.a
                        @Override // a7.b
                        public /* synthetic */ void a(List list) {
                            a7.a.a(this, list);
                        }

                        @Override // a7.b
                        public final void b(a7.c cVar) {
                            Z17QRScannerKt.Z17QRScanner_HYR8e34$lambda$23$lambda$9$lambda$8$lambda$7(decoratedBarcodeView2, mutableState, mutableState2, eVar, handleCorrectScan, cVar);
                        }
                    });
                    decoratedBarcodeView2.i();
                    composerStartRestartGroup.updateRememberedValue(decoratedBarcodeView2);
                    objRememberedValue3 = decoratedBarcodeView2;
                }
                decoratedBarcodeView = (DecoratedBarcodeView) objRememberedValue3;
                Modifier.Companion companion112 = Modifier.INSTANCE;
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy7 = BoxKt.maybeCachedBoxMeasurePolicy(companion110.getTopStart(), false);
                currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap14 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier14 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion112);
                constructor2 = companion111.getConstructor();
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
                Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy7, companion111.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap14, companion111.getSetResolvedCompositionLocals());
                setCompositeKeyHash2 = companion111.getSetCompositeKeyHash();
                if (composerM5176constructorimpl2.getInserting()) {
                    composerM5176constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    composerM5176constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                } else {
                    composerM5176constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    composerM5176constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                }
                Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier14, companion111.getSetModifier());
                BoxScopeInstance boxScopeInstance7 = BoxScopeInstance.INSTANCE;
                zChangedInstance = composerStartRestartGroup.changedInstance(decoratedBarcodeView);
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance) {
                    objRememberedValue4 = new Function1() { // from class: cu.z17.views.qr.b
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return Z17QRScannerKt.Z17QRScanner_HYR8e34$lambda$23$lambda$17$lambda$11$lambda$10(decoratedBarcodeView, (Context) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                } else {
                    objRememberedValue4 = new Function1() { // from class: cu.z17.views.qr.b
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return Z17QRScannerKt.Z17QRScanner_HYR8e34$lambda$23$lambda$17$lambda$11$lambda$10(decoratedBarcodeView, (Context) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                Function1 function13 = (Function1) objRememberedValue4;
                Modifier modifierM1769size3ABfNKs7 = SizeKt.m1769size3ABfNKs(companion112, fM8823constructorimpl);
                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue5 == companion.getEmpty()) {
                    objRememberedValue5 = new Function1() { // from class: cu.z17.views.qr.c
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return Z17QRScannerKt.Z17QRScanner_HYR8e34$lambda$23$lambda$17$lambda$13$lambda$12(mutableState2, (DecoratedBarcodeView) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                Function1 function14 = (Function1) objRememberedValue5;
                float f18 = fM8823constructorimpl;
                AndroidView_androidKt.AndroidView(function13, modifierM1769size3ABfNKs7, function14, composerStartRestartGroup, RendererCapabilities.DECODER_SUPPORT_MASK, 0);
                objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue6 == companion.getEmpty()) {
                    objRememberedValue6 = new lb.a() { // from class: cu.z17.views.qr.d
                        @Override // lb.a
                        public final Object invoke() {
                            return Z17QRScannerKt.Z17QRScanner_HYR8e34$lambda$23$lambda$17$lambda$15$lambda$14(mutableState2);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                }
                ComposableLambda composableLambdaRememberComposableLambda7 = ComposableLambdaKt.rememberComposableLambda(-1801712811, true, new Function2() { // from class: cu.z17.views.qr.e
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return Z17QRScannerKt.Z17QRScanner_HYR8e34$lambda$23$lambda$17$lambda$16(mutableState2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54);
                i18 = i12;
                Modifier modifier11 = modifier4;
                IconButtonKt.IconButton((lb.a) objRememberedValue6, null, false, null, null, composableLambdaRememberComposableLambda7, composerStartRestartGroup, 196614, 30);
                composerStartRestartGroup = composerStartRestartGroup;
                composerStartRestartGroup.endNode();
                SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion112, Dp.m8823constructorimpl(5)), composerStartRestartGroup, 6);
                if (z13) {
                    composerStartRestartGroup.startReplaceGroup(1843897229);
                    if ((i18 & 896) == 256) {
                        z14 = true;
                    } else {
                        z14 = false;
                    }
                    objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                    if (z14) {
                        objRememberedValue8 = new lb.a() { // from class: cu.z17.views.qr.f
                            @Override // lb.a
                            public final Object invoke() {
                                return Z17QRScannerKt.Z17QRScanner_HYR8e34$lambda$23$lambda$19$lambda$18(handleCancelScan);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                    } else {
                        objRememberedValue8 = new lb.a() { // from class: cu.z17.views.qr.f
                            @Override // lb.a
                            public final Object invoke() {
                                return Z17QRScannerKt.Z17QRScanner_HYR8e34$lambda$23$lambda$19$lambda$18(handleCancelScan);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                    }
                    str5 = str4;
                    Z17ButtonsKt.Z17SecondaryDialogButton(null, (lb.a) objRememberedValue8, str5, null, false, false, false, composerStartRestartGroup, (i18 >> 3) & 896, 121);
                    composerStartRestartGroup = composerStartRestartGroup;
                } else {
                    str5 = str4;
                    composerStartRestartGroup.startReplaceGroup(1322436080);
                }
                composerStartRestartGroup.endReplaceGroup();
                k0 k0Var7 = k0.f43947a;
                zChangedInstance2 = composerStartRestartGroup.changedInstance(decoratedBarcodeView);
                objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance2) {
                    objRememberedValue7 = new Function1() { // from class: cu.z17.views.qr.g
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return Z17QRScannerKt.Z17QRScanner_HYR8e34$lambda$23$lambda$22$lambda$21(decoratedBarcodeView, (DisposableEffectScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                } else {
                    objRememberedValue7 = new Function1() { // from class: cu.z17.views.qr.g
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return Z17QRScannerKt.Z17QRScanner_HYR8e34$lambda$23$lambda$22$lambda$21(decoratedBarcodeView, (DisposableEffectScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                }
                EffectsKt.DisposableEffect(k0Var7, (Function1) objRememberedValue7, composerStartRestartGroup, 6);
                composerStartRestartGroup.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                f11 = f18;
                str3 = str5;
                z12 = z13;
                modifier3 = modifier11;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                z12 = z10;
                f11 = f10;
                modifier3 = modifier2;
                str3 = str2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.qr.h
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return Z17QRScannerKt.Z17QRScanner_HYR8e34$lambda$24(modifier3, handleCorrectScan, handleCancelScan, str3, z12, f11, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i12 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        if ((i12 & 74899) != 74898) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z11, i12 & 1)) {
            if (i19 != 0) {
                modifier4 = Modifier.INSTANCE;
            } else {
                modifier4 = modifier2;
            }
            if (i20 != 0) {
                str4 = "Cancel";
            } else {
                str4 = str2;
            }
            if (i13 != 0) {
                z13 = false;
            } else {
                z13 = z10;
            }
            if (i15 != 0) {
                fM8823constructorimpl = Dp.m8823constructorimpl(250);
            } else {
                fM8823constructorimpl = f10;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1827776452, i12, -1, "cu.z17.views.qr.Z17QRScanner (Z17QRScanner.kt:41)");
            }
            Arrangement.HorizontalOrVertical spaceBetween8 = Arrangement.INSTANCE.getSpaceBetween();
            Alignment.Companion companion113 = Alignment.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy8 = ColumnKt.columnMeasurePolicy(spaceBetween8, companion113.getCenterHorizontally(), composerStartRestartGroup, 54);
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap15 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier15 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier4);
            ComposeUiNode.Companion companion114 = ComposeUiNode.INSTANCE;
            constructor = companion114.getConstructor();
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
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyColumnMeasurePolicy8, companion114.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap15, companion114.getSetResolvedCompositionLocals());
            setCompositeKeyHash = companion114.getSetCompositeKeyHash();
            if (composerM5176constructorimpl.getInserting()) {
                composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            } else {
                composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier15, companion114.getSetModifier());
            ColumnScopeInstance columnScopeInstance8 = ColumnScopeInstance.INSTANCE;
            context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            companion = Composer.INSTANCE;
            if (objRememberedValue == companion.getEmpty()) {
                i17 = 2;
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                i17 = 2;
            }
            mutableState = (MutableState) objRememberedValue;
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, i17, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            mutableState2 = (MutableState) objRememberedValue2;
            Object objConsume8 = composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
            y.g(objConsume8, "null cannot be cast to non-null type android.app.Activity");
            eVar = new e6.e((Activity) objConsume8);
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == companion.getEmpty()) {
                decoratedBarcodeView2 = new DecoratedBarcodeView(context);
                y.g(context, "null cannot be cast to non-null type android.app.Activity");
                Activity activity8 = (Activity) context;
                com.journeyapps.barcodescanner.a aVar8 = new com.journeyapps.barcodescanner.a(activity8, decoratedBarcodeView2);
                aVar8.p(activity8.getIntent(), null);
                decoratedBarcodeView2.setStatusText("");
                aVar8.l();
                if (Z17QRScanner_HYR8e34$lambda$23$lambda$4(mutableState2)) {
                    decoratedBarcodeView2.k();
                } else {
                    decoratedBarcodeView2.j();
                }
                decoratedBarcodeView2.b(new a7.b() { // from class: cu.z17.views.qr.a
                    @Override // a7.b
                    public /* synthetic */ void a(List list) {
                        a7.a.a(this, list);
                    }

                    @Override // a7.b
                    public final void b(a7.c cVar) {
                        Z17QRScannerKt.Z17QRScanner_HYR8e34$lambda$23$lambda$9$lambda$8$lambda$7(decoratedBarcodeView2, mutableState, mutableState2, eVar, handleCorrectScan, cVar);
                    }
                });
                decoratedBarcodeView2.i();
                composerStartRestartGroup.updateRememberedValue(decoratedBarcodeView2);
                objRememberedValue3 = decoratedBarcodeView2;
            }
            decoratedBarcodeView = (DecoratedBarcodeView) objRememberedValue3;
            Modifier.Companion companion115 = Modifier.INSTANCE;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy8 = BoxKt.maybeCachedBoxMeasurePolicy(companion113.getTopStart(), false);
            currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap16 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier16 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion115);
            constructor2 = companion114.getConstructor();
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
            Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy8, companion114.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap16, companion114.getSetResolvedCompositionLocals());
            setCompositeKeyHash2 = companion114.getSetCompositeKeyHash();
            if (composerM5176constructorimpl2.getInserting()) {
                composerM5176constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                composerM5176constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            } else {
                composerM5176constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                composerM5176constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier16, companion114.getSetModifier());
            BoxScopeInstance boxScopeInstance8 = BoxScopeInstance.INSTANCE;
            zChangedInstance = composerStartRestartGroup.changedInstance(decoratedBarcodeView);
            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance) {
                objRememberedValue4 = new Function1() { // from class: cu.z17.views.qr.b
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Z17QRScannerKt.Z17QRScanner_HYR8e34$lambda$23$lambda$17$lambda$11$lambda$10(decoratedBarcodeView, (Context) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            } else {
                objRememberedValue4 = new Function1() { // from class: cu.z17.views.qr.b
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Z17QRScannerKt.Z17QRScanner_HYR8e34$lambda$23$lambda$17$lambda$11$lambda$10(decoratedBarcodeView, (Context) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            Function1 function15 = (Function1) objRememberedValue4;
            Modifier modifierM1769size3ABfNKs8 = SizeKt.m1769size3ABfNKs(companion115, fM8823constructorimpl);
            objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue5 == companion.getEmpty()) {
                objRememberedValue5 = new Function1() { // from class: cu.z17.views.qr.c
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Z17QRScannerKt.Z17QRScanner_HYR8e34$lambda$23$lambda$17$lambda$13$lambda$12(mutableState2, (DecoratedBarcodeView) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            }
            Function1 function16 = (Function1) objRememberedValue5;
            float f19 = fM8823constructorimpl;
            AndroidView_androidKt.AndroidView(function15, modifierM1769size3ABfNKs8, function16, composerStartRestartGroup, RendererCapabilities.DECODER_SUPPORT_MASK, 0);
            objRememberedValue6 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue6 == companion.getEmpty()) {
                objRememberedValue6 = new lb.a() { // from class: cu.z17.views.qr.d
                    @Override // lb.a
                    public final Object invoke() {
                        return Z17QRScannerKt.Z17QRScanner_HYR8e34$lambda$23$lambda$17$lambda$15$lambda$14(mutableState2);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
            }
            ComposableLambda composableLambdaRememberComposableLambda8 = ComposableLambdaKt.rememberComposableLambda(-1801712811, true, new Function2() { // from class: cu.z17.views.qr.e
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return Z17QRScannerKt.Z17QRScanner_HYR8e34$lambda$23$lambda$17$lambda$16(mutableState2, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54);
            i18 = i12;
            Modifier modifier12 = modifier4;
            IconButtonKt.IconButton((lb.a) objRememberedValue6, null, false, null, null, composableLambdaRememberComposableLambda8, composerStartRestartGroup, 196614, 30);
            composerStartRestartGroup = composerStartRestartGroup;
            composerStartRestartGroup.endNode();
            SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion115, Dp.m8823constructorimpl(5)), composerStartRestartGroup, 6);
            if (z13) {
                composerStartRestartGroup.startReplaceGroup(1843897229);
                if ((i18 & 896) == 256) {
                    z14 = true;
                } else {
                    z14 = false;
                }
                objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                if (z14) {
                    objRememberedValue8 = new lb.a() { // from class: cu.z17.views.qr.f
                        @Override // lb.a
                        public final Object invoke() {
                            return Z17QRScannerKt.Z17QRScanner_HYR8e34$lambda$23$lambda$19$lambda$18(handleCancelScan);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                } else {
                    objRememberedValue8 = new lb.a() { // from class: cu.z17.views.qr.f
                        @Override // lb.a
                        public final Object invoke() {
                            return Z17QRScannerKt.Z17QRScanner_HYR8e34$lambda$23$lambda$19$lambda$18(handleCancelScan);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                }
                str5 = str4;
                Z17ButtonsKt.Z17SecondaryDialogButton(null, (lb.a) objRememberedValue8, str5, null, false, false, false, composerStartRestartGroup, (i18 >> 3) & 896, 121);
                composerStartRestartGroup = composerStartRestartGroup;
            } else {
                str5 = str4;
                composerStartRestartGroup.startReplaceGroup(1322436080);
            }
            composerStartRestartGroup.endReplaceGroup();
            k0 k0Var8 = k0.f43947a;
            zChangedInstance2 = composerStartRestartGroup.changedInstance(decoratedBarcodeView);
            objRememberedValue7 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance2) {
                objRememberedValue7 = new Function1() { // from class: cu.z17.views.qr.g
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Z17QRScannerKt.Z17QRScanner_HYR8e34$lambda$23$lambda$22$lambda$21(decoratedBarcodeView, (DisposableEffectScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
            } else {
                objRememberedValue7 = new Function1() { // from class: cu.z17.views.qr.g
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Z17QRScannerKt.Z17QRScanner_HYR8e34$lambda$23$lambda$22$lambda$21(decoratedBarcodeView, (DisposableEffectScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
            }
            EffectsKt.DisposableEffect(k0Var8, (Function1) objRememberedValue7, composerStartRestartGroup, 6);
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            f11 = f19;
            str3 = str5;
            z12 = z13;
            modifier3 = modifier12;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            z12 = z10;
            f11 = f10;
            modifier3 = modifier2;
            str3 = str2;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.qr.h
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return Z17QRScannerKt.Z17QRScanner_HYR8e34$lambda$24(modifier3, handleCorrectScan, handleCancelScan, str3, z12, f11, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void Z17QRScanner_HYR8e34$lambda$23$handleTorch(MutableState<Boolean> mutableState) {
        Z17QRScanner_HYR8e34$lambda$23$lambda$5(mutableState, !Z17QRScanner_HYR8e34$lambda$23$lambda$4(mutableState));
    }

    private static final boolean Z17QRScanner_HYR8e34$lambda$23$lambda$1(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DecoratedBarcodeView Z17QRScanner_HYR8e34$lambda$23$lambda$17$lambda$11$lambda$10(DecoratedBarcodeView decoratedBarcodeView, Context it) {
        y.i(it, "it");
        return decoratedBarcodeView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 Z17QRScanner_HYR8e34$lambda$23$lambda$17$lambda$13$lambda$12(MutableState mutableState, DecoratedBarcodeView it) {
        y.i(it, "it");
        if (Z17QRScanner_HYR8e34$lambda$23$lambda$4(mutableState)) {
            it.k();
        } else {
            it.j();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 Z17QRScanner_HYR8e34$lambda$23$lambda$17$lambda$15$lambda$14(MutableState mutableState) {
        Z17QRScanner_HYR8e34$lambda$23$handleTorch(mutableState);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 Z17QRScanner_HYR8e34$lambda$23$lambda$17$lambda$16(MutableState mutableState, Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1801712811, i10, -1, "cu.z17.views.qr.Z17QRScanner.<anonymous>.<anonymous>.<anonymous> (Z17QRScanner.kt:100)");
            }
            Z17PictureKt.m10278Z17BasePictureC8z9wKI(SizeKt.m1769size3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(30)), Z17QRScanner_HYR8e34$lambda$23$lambda$4(mutableState) ? FlashOnKt.getFlashOn(Icons.Outlined.INSTANCE) : FlashOffKt.getFlashOff(Icons.Outlined.INSTANCE), null, ColorFilter.Companion.m5907tintxETnrds$default(ColorFilter.INSTANCE, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getSurface(), 0, 2, null), null, null, 0, null, null, composer, 6, XMPPTCPConnection.PacketWriter.QUEUE_SIZE);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 Z17QRScanner_HYR8e34$lambda$23$lambda$19$lambda$18(lb.a aVar) {
        aVar.invoke();
        return k0.f43947a;
    }

    private static final void Z17QRScanner_HYR8e34$lambda$23$lambda$2(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult Z17QRScanner_HYR8e34$lambda$23$lambda$22$lambda$21(final DecoratedBarcodeView decoratedBarcodeView, DisposableEffectScope DisposableEffect) {
        y.i(DisposableEffect, "$this$DisposableEffect");
        decoratedBarcodeView.i();
        return new DisposableEffectResult() { // from class: cu.z17.views.qr.Z17QRScannerKt$Z17QRScanner_HYR8e34$lambda$23$lambda$22$lambda$21$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                decoratedBarcodeView.g();
            }
        };
    }

    private static final boolean Z17QRScanner_HYR8e34$lambda$23$lambda$4(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void Z17QRScanner_HYR8e34$lambda$23$lambda$5(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z17QRScanner_HYR8e34$lambda$23$lambda$9$lambda$8$lambda$7(DecoratedBarcodeView decoratedBarcodeView, MutableState mutableState, MutableState mutableState2, e6.e eVar, Function1 function1, a7.c cVar) {
        if (Z17QRScanner_HYR8e34$lambda$23$lambda$1(mutableState)) {
            return;
        }
        if (Z17QRScanner_HYR8e34$lambda$23$lambda$4(mutableState2)) {
            decoratedBarcodeView.j();
        }
        if (cVar != null) {
            eVar.d();
            Z17QRScanner_HYR8e34$lambda$23$lambda$2(mutableState, true);
            String string = cVar.d().toString();
            y.h(string, "toString(...)");
            function1.invoke(string);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 Z17QRScanner_HYR8e34$lambda$24(Modifier modifier, Function1 function1, lb.a aVar, String str, boolean z10, float f10, int i10, int i11, Composer composer, int i12) {
        m10300Z17QRScannerHYR8e34(modifier, function1, aVar, str, z10, f10, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return k0.f43947a;
    }
}
