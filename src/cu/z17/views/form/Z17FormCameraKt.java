package cu.z17.views.form;

import android.net.Uri;
import androidx.compose.foundation.BackgroundKt;
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
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.foundation.layout.e3;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.MaterialTheme;
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
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.common.C;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.p000activity.compose.ActivityResultRegistryKt;
import androidx.p000activity.compose.ManagedActivityResultLauncher;
import androidx.p000activity.result.contract.ActivityResultContracts;
import androidx.profileinstaller.ProfileVerifier;
import cu.z17.views.R;
import cu.z17.views.button.Z17ButtonsKt;
import cu.z17.views.camera.ResultType;
import cu.z17.views.camera.Z17CameraKt;
import cu.z17.views.picture.Z17PictureKt;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001ak\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\n2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\nH\u0007¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u0011²\u0006\u000e\u0010\u0010\u001a\u00020\u000f8\n@\nX\u008a\u008e\u0002"}, d2 = {"Landroidx/compose/ui/Modifier;", "modifier", "", "type", "", "rootPath", "initialValue", "Lkotlin/Function0;", "Lua/k0;", "onClose", "Lkotlin/Function1;", "onRequestRealPath", "onSelected", "Z17FormCamera", "(Landroidx/compose/ui/Modifier;ILjava/lang/String;Ljava/lang/String;Llb/a;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "Lcu/z17/views/form/Z17FormCameraState;", "state", "views_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class Z17FormCameraKt {

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[Z17FormCameraStep.values().length];
            try {
                iArr[Z17FormCameraStep.SHOOTING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Z17FormCameraStep.PREVIEW.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Z17FormCameraStep.EDITING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[ResultType.values().length];
            try {
                iArr2[ResultType.VIDEO.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[ResultType.PHOTO.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[ResultType.DELETE.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    /* JADX WARN: Code duplicated, block: B:102:0x01c7  */
    /* JADX WARN: Code duplicated, block: B:104:0x01cd  */
    /* JADX WARN: Code duplicated, block: B:107:0x0225  */
    /* JADX WARN: Code duplicated, block: B:110:0x0231  */
    /* JADX WARN: Code duplicated, block: B:111:0x0235  */
    /* JADX WARN: Code duplicated, block: B:114:0x0256  */
    /* JADX WARN: Code duplicated, block: B:116:0x0264  */
    /* JADX WARN: Code duplicated, block: B:119:0x02b5  */
    /* JADX WARN: Code duplicated, block: B:122:0x02c1  */
    /* JADX WARN: Code duplicated, block: B:123:0x02c5  */
    /* JADX WARN: Code duplicated, block: B:126:0x02e4  */
    /* JADX WARN: Code duplicated, block: B:128:0x02f2  */
    /* JADX WARN: Code duplicated, block: B:131:0x0311  */
    /* JADX WARN: Code duplicated, block: B:132:0x0313  */
    /* JADX WARN: Code duplicated, block: B:135:0x031a  */
    /* JADX WARN: Code duplicated, block: B:137:0x0320  */
    /* JADX WARN: Code duplicated, block: B:140:0x0369  */
    /* JADX WARN: Code duplicated, block: B:142:0x036c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:143:0x036e  */
    /* JADX WARN: Code duplicated, block: B:145:0x037b  */
    /* JADX WARN: Code duplicated, block: B:147:0x038a  */
    /* JADX WARN: Code duplicated, block: B:148:0x0396  */
    /* JADX WARN: Code duplicated, block: B:150:0x03a6  */
    /* JADX WARN: Code duplicated, block: B:152:0x03ac  */
    /* JADX WARN: Code duplicated, block: B:156:0x03e5  */
    /* JADX WARN: Code duplicated, block: B:158:0x03e8 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:159:0x03ea  */
    /* JADX WARN: Code duplicated, block: B:161:0x03f9  */
    /* JADX WARN: Code duplicated, block: B:163:0x0409  */
    /* JADX WARN: Code duplicated, block: B:165:0x0452  */
    /* JADX WARN: Code duplicated, block: B:166:0x0454  */
    /* JADX WARN: Code duplicated, block: B:169:0x045b  */
    /* JADX WARN: Code duplicated, block: B:171:0x0461  */
    /* JADX WARN: Code duplicated, block: B:173:0x0488  */
    /* JADX WARN: Code duplicated, block: B:175:0x04aa  */
    /* JADX WARN: Code duplicated, block: B:176:0x04ac  */
    /* JADX WARN: Code duplicated, block: B:179:0x04dd  */
    /* JADX WARN: Code duplicated, block: B:183:0x0515  */
    /* JADX WARN: Code duplicated, block: B:185:0x051f  */
    /* JADX WARN: Code duplicated, block: B:188:0x052d  */
    /* JADX WARN: Code duplicated, block: B:190:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:26:0x0064  */
    /* JADX WARN: Code duplicated, block: B:28:0x006a  */
    /* JADX WARN: Code duplicated, block: B:29:0x006d  */
    /* JADX WARN: Code duplicated, block: B:33:0x0074  */
    /* JADX WARN: Code duplicated, block: B:35:0x0079  */
    /* JADX WARN: Code duplicated, block: B:37:0x007d  */
    /* JADX WARN: Code duplicated, block: B:39:0x0085  */
    /* JADX WARN: Code duplicated, block: B:40:0x0088  */
    /* JADX WARN: Code duplicated, block: B:44:0x008f  */
    /* JADX WARN: Code duplicated, block: B:46:0x0095  */
    /* JADX WARN: Code duplicated, block: B:47:0x0098  */
    /* JADX WARN: Code duplicated, block: B:51:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:53:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:54:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:58:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:60:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:61:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:65:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:66:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:69:0x00d1 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:70:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:71:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:73:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:75:0x00df  */
    /* JADX WARN: Code duplicated, block: B:76:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:79:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:82:0x0131  */
    /* JADX WARN: Code duplicated, block: B:85:0x013d  */
    /* JADX WARN: Code duplicated, block: B:86:0x0141  */
    /* JADX WARN: Code duplicated, block: B:89:0x0160  */
    /* JADX WARN: Code duplicated, block: B:91:0x016e  */
    /* JADX WARN: Code duplicated, block: B:94:0x0192  */
    /* JADX WARN: Code duplicated, block: B:95:0x01ac  */
    /* JADX WARN: Code duplicated, block: B:98:0x01be  */
    /* JADX WARN: Code duplicated, block: B:99:0x01c0  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void Z17FormCamera(Modifier modifier, int i10, final String rootPath, String str, final lb.a onClose, final Function1 onRequestRealPath, final Function1 onSelected, Composer composer, final int i11, final int i12) {
        Modifier modifier2;
        int i13;
        int i14;
        int i15;
        int i16;
        boolean z10;
        Composer composer2;
        final String str2;
        final int i17;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier modifier3;
        String str3;
        int currentCompositeKeyHash;
        lb.a constructor;
        Composer composerM5176constructorimpl;
        Function2 setCompositeKeyHash;
        Object objRememberedValue;
        Composer.Companion companion;
        String str4;
        int i18;
        final MutableState mutableState;
        boolean z11;
        Object objRememberedValue2;
        final ManagedActivityResultLauncher managedActivityResultLauncherRememberLauncherForActivityResult;
        Modifier.Companion companion2;
        int currentCompositeKeyHash2;
        lb.a constructor2;
        Composer composerM5176constructorimpl2;
        Function2 setCompositeKeyHash2;
        ColumnScopeInstance columnScopeInstance;
        int currentCompositeKeyHash3;
        lb.a constructor3;
        Composer composerM5176constructorimpl3;
        Function2 setCompositeKeyHash3;
        boolean z12;
        Object objRememberedValue3;
        ComposableSingletons$Z17FormCameraKt composableSingletons$Z17FormCameraKt;
        Composer composer3;
        int i19;
        boolean zChangedInstance;
        Object objRememberedValue4;
        int i20;
        boolean z13;
        Object objRememberedValue5;
        Composer composer4;
        boolean z14;
        Object objRememberedValue6;
        int i21;
        int i22;
        int i23;
        int i24;
        kotlin.jvm.internal.y.i(rootPath, "rootPath");
        kotlin.jvm.internal.y.i(onClose, "onClose");
        kotlin.jvm.internal.y.i(onRequestRealPath, "onRequestRealPath");
        kotlin.jvm.internal.y.i(onSelected, "onSelected");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1922330802);
        int i25 = i12 & 1;
        if (i25 != 0) {
            i13 = i11 | 6;
            modifier2 = modifier;
        } else if ((i11 & 6) == 0) {
            modifier2 = modifier;
            i13 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i11;
        } else {
            modifier2 = modifier;
            i13 = i11;
        }
        int i26 = i12 & 2;
        if (i26 == 0) {
            if ((i11 & 48) == 0) {
                i14 = i10;
                i13 |= composerStartRestartGroup.changed(i14) ? 32 : 16;
            }
            if ((i11 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                if (composerStartRestartGroup.changed(rootPath)) {
                    i24 = 256;
                } else {
                    i24 = 128;
                }
                i13 |= i24;
            }
            i15 = i12 & 8;
            if (i15 != 0) {
                if ((i11 & 3072) == 0) {
                    if (composerStartRestartGroup.changed(str)) {
                        i16 = 2048;
                    } else {
                        i16 = 1024;
                    }
                    i13 |= i16;
                }
                if ((i11 & 24576) == 0) {
                    if (composerStartRestartGroup.changedInstance(onClose)) {
                        i23 = 16384;
                    } else {
                        i23 = 8192;
                    }
                    i13 |= i23;
                }
                if ((196608 & i11) == 0) {
                    if (composerStartRestartGroup.changedInstance(onRequestRealPath)) {
                        i22 = 131072;
                    } else {
                        i22 = 65536;
                    }
                    i13 |= i22;
                }
                if ((1572864 & i11) == 0) {
                    if (composerStartRestartGroup.changedInstance(onSelected)) {
                        i21 = 1048576;
                    } else {
                        i21 = 524288;
                    }
                    i13 |= i21;
                }
                if ((599187 & i13) != 599186) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z10, i13 & 1)) {
                    if (i25 != 0) {
                        modifier3 = Modifier.INSTANCE;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i26 != 0) {
                        i14 = 1;
                    }
                    if (i15 != 0) {
                        str3 = "";
                    } else {
                        str3 = str;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1922330802, i13, -1, "cu.z17.views.form.Z17FormCamera (Z17FormCamera.kt:48)");
                    }
                    MaterialTheme materialTheme = MaterialTheme.INSTANCE;
                    int i27 = MaterialTheme.$stable;
                    Modifier modifierSafeContentPadding = WindowInsetsPadding_androidKt.safeContentPadding(BackgroundKt.m1205backgroundbw27NRU$default(modifier3, materialTheme.getColorScheme(composerStartRestartGroup, i27).getBackground(), null, 2, null));
                    Alignment.Companion companion3 = Alignment.INSTANCE;
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion3.getTopStart(), false);
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierSafeContentPadding);
                    ComposeUiNode.Companion companion4 = ComposeUiNode.INSTANCE;
                    constructor = companion4.getConstructor();
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
                    Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, companion4.getSetMeasurePolicy());
                    Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion4.getSetResolvedCompositionLocals());
                    setCompositeKeyHash = companion4.getSetCompositeKeyHash();
                    if (composerM5176constructorimpl.getInserting() || !kotlin.jvm.internal.y.d(composerM5176constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion4.getSetModifier());
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    companion = Composer.INSTANCE;
                    if (objRememberedValue == companion.getEmpty()) {
                        str4 = str3;
                        i18 = i14;
                        objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new Z17FormCameraState(str4, i18, null, 4, null), null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        str4 = str3;
                        i18 = i14;
                    }
                    mutableState = (MutableState) objRememberedValue;
                    ActivityResultContracts.GetContent getContent = new ActivityResultContracts.GetContent();
                    if ((458752 & i13) == 131072) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (z11 || objRememberedValue2 == companion.getEmpty()) {
                        objRememberedValue2 = new Function1() { // from class: cu.z17.views.form.t
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return Z17FormCameraKt.Z17FormCamera$lambda$16$lambda$5$lambda$4(onRequestRealPath, mutableState, (Uri) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    managedActivityResultLauncherRememberLauncherForActivityResult = ActivityResultRegistryKt.rememberLauncherForActivityResult(getContent, (Function1) objRememberedValue2, composerStartRestartGroup, 0);
                    companion2 = Modifier.INSTANCE;
                    Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(BackgroundKt.m1205backgroundbw27NRU$default(companion2, materialTheme.getColorScheme(composerStartRestartGroup, i27).getBackground(), null, 2, null), 0.0f, 1, null);
                    Arrangement arrangement = Arrangement.INSTANCE;
                    MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(arrangement.getTop(), companion3.getStart(), composerStartRestartGroup, 0);
                    currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxSize$default);
                    constructor2 = companion4.getConstructor();
                    if (!defpackage.r.a(composerStartRestartGroup.getApplier())) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor2);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    composerM5176constructorimpl2 = Updater.m5176constructorimpl(composerStartRestartGroup);
                    Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyColumnMeasurePolicy, companion4.getSetMeasurePolicy());
                    Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap2, companion4.getSetResolvedCompositionLocals());
                    setCompositeKeyHash2 = companion4.getSetCompositeKeyHash();
                    if (composerM5176constructorimpl2.getInserting() || !kotlin.jvm.internal.y.d(composerM5176constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                        composerM5176constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                        composerM5176constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                    }
                    Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier2, companion4.getSetModifier());
                    columnScopeInstance = ColumnScopeInstance.INSTANCE;
                    Modifier modifierM1725padding3ABfNKs = PaddingKt.m1725padding3ABfNKs(SizeKt.fillMaxWidth$default(companion2, 0.0f, 1, null), Dp.m8823constructorimpl(5));
                    MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getStart(), companion3.getCenterVertically(), composerStartRestartGroup, 48);
                    currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1725padding3ABfNKs);
                    constructor3 = companion4.getConstructor();
                    if (!defpackage.r.a(composerStartRestartGroup.getApplier())) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor3);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    composerM5176constructorimpl3 = Updater.m5176constructorimpl(composerStartRestartGroup);
                    Updater.m5184setimpl(composerM5176constructorimpl3, measurePolicyRowMeasurePolicy, companion4.getSetMeasurePolicy());
                    Updater.m5184setimpl(composerM5176constructorimpl3, currentCompositionLocalMap3, companion4.getSetResolvedCompositionLocals());
                    setCompositeKeyHash3 = companion4.getSetCompositeKeyHash();
                    if (composerM5176constructorimpl3.getInserting() || !kotlin.jvm.internal.y.d(composerM5176constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                        composerM5176constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                        composerM5176constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                    }
                    Updater.m5184setimpl(composerM5176constructorimpl3, modifierMaterializeModifier3, companion4.getSetModifier());
                    RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                    if ((57344 & i13) == 16384) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (z12 || objRememberedValue3 == companion.getEmpty()) {
                        objRememberedValue3 = new lb.a() { // from class: cu.z17.views.form.u
                            @Override // lb.a
                            public final Object invoke() {
                                return Z17FormCameraKt.Z17FormCamera$lambda$16$lambda$15$lambda$10$lambda$7$lambda$6(onClose, mutableState);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    composableSingletons$Z17FormCameraKt = ComposableSingletons$Z17FormCameraKt.INSTANCE;
                    IconButtonKt.IconButton((lb.a) objRememberedValue3, null, false, null, null, composableSingletons$Z17FormCameraKt.m10144getLambda$1870006581$views_release(), composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 30);
                    composer3 = composerStartRestartGroup;
                    SpacerKt.Spacer(e3.a(rowScopeInstance, companion2, 1.0f, false, 2, null), composer3, 0);
                    Z17FormCameraStep step = Z17FormCamera$lambda$16$lambda$1(mutableState).getStep();
                    int[] iArr = WhenMappings.$EnumSwitchMapping$0;
                    i19 = iArr[step.ordinal()];
                    if (i19 != 1) {
                        composer3.startReplaceGroup(2123552315);
                        zChangedInstance = composer3.changedInstance(managedActivityResultLauncherRememberLauncherForActivityResult);
                        objRememberedValue4 = composer3.rememberedValue();
                        if (zChangedInstance || objRememberedValue4 == companion.getEmpty()) {
                            objRememberedValue4 = new lb.a() { // from class: cu.z17.views.form.v
                                @Override // lb.a
                                public final Object invoke() {
                                    return Z17FormCameraKt.Z17FormCamera$lambda$16$lambda$15$lambda$10$lambda$9$lambda$8(managedActivityResultLauncherRememberLauncherForActivityResult);
                                }
                            };
                            composer3.updateRememberedValue(objRememberedValue4);
                        }
                        IconButtonKt.IconButton((lb.a) objRememberedValue4, null, false, null, null, composableSingletons$Z17FormCameraKt.m10143getLambda$1158477629$views_release(), composer3, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 30);
                        composer3 = composer3;
                        composer3.endReplaceGroup();
                        ua.k0 k0Var = ua.k0.f43947a;
                    } else if (i19 != 2) {
                        composer3.startReplaceGroup(2124150460);
                        composer3.endReplaceGroup();
                        ua.k0 k0Var2 = ua.k0.f43947a;
                    } else {
                        if (i19 == 3) {
                            composer3.startReplaceGroup(-485689665);
                            composer3.endReplaceGroup();
                            throw new ua.r();
                        }
                        composer3.startReplaceGroup(2124224178);
                        composer3.endReplaceGroup();
                        ua.k0 k0Var3 = ua.k0.f43947a;
                    }
                    composer3.endNode();
                    i20 = iArr[Z17FormCamera$lambda$16$lambda$1(mutableState).getStep().ordinal()];
                    if (i20 != 1) {
                        composer3.startReplaceGroup(-135378438);
                        Modifier modifierA = androidx.compose.foundation.layout.x.a(columnScopeInstance, companion2, 1.0f, false, 2, null);
                        if (Z17FormCamera$lambda$16$lambda$1(mutableState).getType() == 2) {
                            z13 = true;
                        } else {
                            z13 = false;
                        }
                        String str5 = rootPath + Z17FormCamera$lambda$16$newImageName();
                        String str6 = rootPath + Z17FormCamera$lambda$16$newVideoName();
                        objRememberedValue5 = composer3.rememberedValue();
                        if (objRememberedValue5 == companion.getEmpty()) {
                            objRememberedValue5 = new lb.o() { // from class: cu.z17.views.form.w
                                @Override // lb.o
                                public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                                    return Z17FormCameraKt.Z17FormCamera$lambda$16$lambda$15$lambda$12$lambda$11(mutableState, (String) obj, (ResultType) obj2, ((Long) obj3).longValue(), ((Float) obj4).floatValue());
                                }
                            };
                            composer3.updateRememberedValue(objRememberedValue5);
                        }
                        Z17CameraKt.Z17Camera(modifierA, str5, str6, z13, null, null, null, onClose, (lb.o) objRememberedValue5, onClose, false, composer3, ((i13 << 9) & 29360128) | 100663296 | ((i13 << 15) & C.ENCODING_PCM_DOUBLE), 6, 112);
                        composer2 = composer3;
                        composer2.endReplaceGroup();
                    } else {
                        if (i20 != 2) {
                            if (i20 != 3) {
                                composer3.startReplaceGroup(-1666936492);
                                composer3.endReplaceGroup();
                                throw new ua.r();
                            }
                            composer3.startReplaceGroup(-1666881264);
                            composer3.endReplaceGroup();
                            throw new ua.s(null, 1, null);
                        }
                        composer3.startReplaceGroup(-134212032);
                        composer4 = composer3;
                        Z17PictureKt.m10278Z17BasePictureC8z9wKI(androidx.compose.foundation.layout.x.a(columnScopeInstance, companion2, 1.0f, false, 2, null), Z17FormCamera$lambda$16$lambda$1(mutableState).getValue(), null, null, null, null, 0, null, null, composer4, 0, TypedValues.PositionType.TYPE_CURVE_FIT);
                        Modifier modifierM1727paddingVpY3zN4$default = PaddingKt.m1727paddingVpY3zN4$default(companion2, 0.0f, Dp.m8823constructorimpl(10), 1, null);
                        if ((3670016 & i13) == 1048576) {
                            z14 = true;
                        } else {
                            z14 = false;
                        }
                        objRememberedValue6 = composer4.rememberedValue();
                        if (z14 || objRememberedValue6 == companion.getEmpty()) {
                            objRememberedValue6 = new lb.a() { // from class: cu.z17.views.form.x
                                @Override // lb.a
                                public final Object invoke() {
                                    return Z17FormCameraKt.Z17FormCamera$lambda$16$lambda$15$lambda$14$lambda$13(onSelected, mutableState);
                                }
                            };
                            composer4.updateRememberedValue(objRememberedValue6);
                        }
                        String strStringResource = StringResources_androidKt.stringResource(R.string.accept, composer4, 0);
                        composer2 = composer4;
                        Z17ButtonsKt.Z17PrimaryButton(modifierM1727paddingVpY3zN4$default, (lb.a) objRememberedValue6, strStringResource, null, true, false, composer2, 24582, 40);
                        composer2.endReplaceGroup();
                    }
                    composer2.endNode();
                    composer2.endNode();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier2 = modifier3;
                    str2 = str4;
                    i17 = i18;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    str2 = str;
                    i17 = i14;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final Modifier modifier4 = modifier2;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.form.y
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return Z17FormCameraKt.Z17FormCamera$lambda$17(modifier4, i17, rootPath, str2, onClose, onRequestRealPath, onSelected, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i13 |= 3072;
            if ((i11 & 24576) == 0) {
                if (composerStartRestartGroup.changedInstance(onClose)) {
                    i23 = 16384;
                } else {
                    i23 = 8192;
                }
                i13 |= i23;
            }
            if ((196608 & i11) == 0) {
                if (composerStartRestartGroup.changedInstance(onRequestRealPath)) {
                    i22 = 131072;
                } else {
                    i22 = 65536;
                }
                i13 |= i22;
            }
            if ((1572864 & i11) == 0) {
                if (composerStartRestartGroup.changedInstance(onSelected)) {
                    i21 = 1048576;
                } else {
                    i21 = 524288;
                }
                i13 |= i21;
            }
            if ((599187 & i13) != 599186) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z10, i13 & 1)) {
                if (i25 != 0) {
                    modifier3 = Modifier.INSTANCE;
                } else {
                    modifier3 = modifier2;
                }
                if (i26 != 0) {
                    i14 = 1;
                }
                if (i15 != 0) {
                    str3 = "";
                } else {
                    str3 = str;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1922330802, i13, -1, "cu.z17.views.form.Z17FormCamera (Z17FormCamera.kt:48)");
                }
                MaterialTheme materialTheme2 = MaterialTheme.INSTANCE;
                int i28 = MaterialTheme.$stable;
                Modifier modifierSafeContentPadding2 = WindowInsetsPadding_androidKt.safeContentPadding(BackgroundKt.m1205backgroundbw27NRU$default(modifier3, materialTheme2.getColorScheme(composerStartRestartGroup, i28).getBackground(), null, 2, null));
                Alignment.Companion companion5 = Alignment.INSTANCE;
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(companion5.getTopStart(), false);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierSafeContentPadding2);
                ComposeUiNode.Companion companion6 = ComposeUiNode.INSTANCE;
                constructor = companion6.getConstructor();
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
                Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy2, companion6.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap4, companion6.getSetResolvedCompositionLocals());
                setCompositeKeyHash = companion6.getSetCompositeKeyHash();
                if (composerM5176constructorimpl.getInserting()) {
                    composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                } else {
                    composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier4, companion6.getSetModifier());
                BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                companion = Composer.INSTANCE;
                if (objRememberedValue == companion.getEmpty()) {
                    str4 = str3;
                    i18 = i14;
                    objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new Z17FormCameraState(str4, i18, null, 4, null), null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    str4 = str3;
                    i18 = i14;
                }
                mutableState = (MutableState) objRememberedValue;
                ActivityResultContracts.GetContent getContent2 = new ActivityResultContracts.GetContent();
                if ((458752 & i13) == 131072) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (z11) {
                    objRememberedValue2 = new Function1() { // from class: cu.z17.views.form.t
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return Z17FormCameraKt.Z17FormCamera$lambda$16$lambda$5$lambda$4(onRequestRealPath, mutableState, (Uri) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new Function1() { // from class: cu.z17.views.form.t
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return Z17FormCameraKt.Z17FormCamera$lambda$16$lambda$5$lambda$4(onRequestRealPath, mutableState, (Uri) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                managedActivityResultLauncherRememberLauncherForActivityResult = ActivityResultRegistryKt.rememberLauncherForActivityResult(getContent2, (Function1) objRememberedValue2, composerStartRestartGroup, 0);
                companion2 = Modifier.INSTANCE;
                Modifier modifierFillMaxSize$default2 = SizeKt.fillMaxSize$default(BackgroundKt.m1205backgroundbw27NRU$default(companion2, materialTheme2.getColorScheme(composerStartRestartGroup, i28).getBackground(), null, 2, null), 0.0f, 1, null);
                Arrangement arrangement2 = Arrangement.INSTANCE;
                MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(arrangement2.getTop(), companion5.getStart(), composerStartRestartGroup, 0);
                currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap5 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier5 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxSize$default2);
                constructor2 = companion6.getConstructor();
                if (!defpackage.r.a(composerStartRestartGroup.getApplier())) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor2);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerM5176constructorimpl2 = Updater.m5176constructorimpl(composerStartRestartGroup);
                Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyColumnMeasurePolicy2, companion6.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap5, companion6.getSetResolvedCompositionLocals());
                setCompositeKeyHash2 = companion6.getSetCompositeKeyHash();
                if (composerM5176constructorimpl2.getInserting()) {
                    composerM5176constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    composerM5176constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                } else {
                    composerM5176constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    composerM5176constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                }
                Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier5, companion6.getSetModifier());
                columnScopeInstance = ColumnScopeInstance.INSTANCE;
                Modifier modifierM1725padding3ABfNKs2 = PaddingKt.m1725padding3ABfNKs(SizeKt.fillMaxWidth$default(companion2, 0.0f, 1, null), Dp.m8823constructorimpl(5));
                MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(arrangement2.getStart(), companion5.getCenterVertically(), composerStartRestartGroup, 48);
                currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap6 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier6 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1725padding3ABfNKs2);
                constructor3 = companion6.getConstructor();
                if (!defpackage.r.a(composerStartRestartGroup.getApplier())) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor3);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerM5176constructorimpl3 = Updater.m5176constructorimpl(composerStartRestartGroup);
                Updater.m5184setimpl(composerM5176constructorimpl3, measurePolicyRowMeasurePolicy2, companion6.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl3, currentCompositionLocalMap6, companion6.getSetResolvedCompositionLocals());
                setCompositeKeyHash3 = companion6.getSetCompositeKeyHash();
                if (composerM5176constructorimpl3.getInserting()) {
                    composerM5176constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                    composerM5176constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                } else {
                    composerM5176constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                    composerM5176constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                }
                Updater.m5184setimpl(composerM5176constructorimpl3, modifierMaterializeModifier6, companion6.getSetModifier());
                RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
                if ((57344 & i13) == 16384) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (z12) {
                    objRememberedValue3 = new lb.a() { // from class: cu.z17.views.form.u
                        @Override // lb.a
                        public final Object invoke() {
                            return Z17FormCameraKt.Z17FormCamera$lambda$16$lambda$15$lambda$10$lambda$7$lambda$6(onClose, mutableState);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new lb.a() { // from class: cu.z17.views.form.u
                        @Override // lb.a
                        public final Object invoke() {
                            return Z17FormCameraKt.Z17FormCamera$lambda$16$lambda$15$lambda$10$lambda$7$lambda$6(onClose, mutableState);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                composableSingletons$Z17FormCameraKt = ComposableSingletons$Z17FormCameraKt.INSTANCE;
                IconButtonKt.IconButton((lb.a) objRememberedValue3, null, false, null, null, composableSingletons$Z17FormCameraKt.m10144getLambda$1870006581$views_release(), composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 30);
                composer3 = composerStartRestartGroup;
                SpacerKt.Spacer(e3.a(rowScopeInstance2, companion2, 1.0f, false, 2, null), composer3, 0);
                Z17FormCameraStep step2 = Z17FormCamera$lambda$16$lambda$1(mutableState).getStep();
                int[] iArr2 = WhenMappings.$EnumSwitchMapping$0;
                i19 = iArr2[step2.ordinal()];
                if (i19 != 1) {
                    composer3.startReplaceGroup(2123552315);
                    zChangedInstance = composer3.changedInstance(managedActivityResultLauncherRememberLauncherForActivityResult);
                    objRememberedValue4 = composer3.rememberedValue();
                    if (zChangedInstance) {
                        objRememberedValue4 = new lb.a() { // from class: cu.z17.views.form.v
                            @Override // lb.a
                            public final Object invoke() {
                                return Z17FormCameraKt.Z17FormCamera$lambda$16$lambda$15$lambda$10$lambda$9$lambda$8(managedActivityResultLauncherRememberLauncherForActivityResult);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue4);
                    } else {
                        objRememberedValue4 = new lb.a() { // from class: cu.z17.views.form.v
                            @Override // lb.a
                            public final Object invoke() {
                                return Z17FormCameraKt.Z17FormCamera$lambda$16$lambda$15$lambda$10$lambda$9$lambda$8(managedActivityResultLauncherRememberLauncherForActivityResult);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue4);
                    }
                    IconButtonKt.IconButton((lb.a) objRememberedValue4, null, false, null, null, composableSingletons$Z17FormCameraKt.m10143getLambda$1158477629$views_release(), composer3, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 30);
                    composer3 = composer3;
                    composer3.endReplaceGroup();
                    ua.k0 k0Var4 = ua.k0.f43947a;
                } else if (i19 != 2) {
                    composer3.startReplaceGroup(2124150460);
                    composer3.endReplaceGroup();
                    ua.k0 k0Var5 = ua.k0.f43947a;
                } else {
                    if (i19 == 3) {
                        composer3.startReplaceGroup(-485689665);
                        composer3.endReplaceGroup();
                        throw new ua.r();
                    }
                    composer3.startReplaceGroup(2124224178);
                    composer3.endReplaceGroup();
                    ua.k0 k0Var6 = ua.k0.f43947a;
                }
                composer3.endNode();
                i20 = iArr2[Z17FormCamera$lambda$16$lambda$1(mutableState).getStep().ordinal()];
                if (i20 != 1) {
                    composer3.startReplaceGroup(-135378438);
                    Modifier modifierA2 = androidx.compose.foundation.layout.x.a(columnScopeInstance, companion2, 1.0f, false, 2, null);
                    if (Z17FormCamera$lambda$16$lambda$1(mutableState).getType() == 2) {
                        z13 = true;
                    } else {
                        z13 = false;
                    }
                    String str7 = rootPath + Z17FormCamera$lambda$16$newImageName();
                    String str8 = rootPath + Z17FormCamera$lambda$16$newVideoName();
                    objRememberedValue5 = composer3.rememberedValue();
                    if (objRememberedValue5 == companion.getEmpty()) {
                        objRememberedValue5 = new lb.o() { // from class: cu.z17.views.form.w
                            @Override // lb.o
                            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                                return Z17FormCameraKt.Z17FormCamera$lambda$16$lambda$15$lambda$12$lambda$11(mutableState, (String) obj, (ResultType) obj2, ((Long) obj3).longValue(), ((Float) obj4).floatValue());
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue5);
                    }
                    Z17CameraKt.Z17Camera(modifierA2, str7, str8, z13, null, null, null, onClose, (lb.o) objRememberedValue5, onClose, false, composer3, ((i13 << 9) & 29360128) | 100663296 | ((i13 << 15) & C.ENCODING_PCM_DOUBLE), 6, 112);
                    composer2 = composer3;
                    composer2.endReplaceGroup();
                } else {
                    if (i20 != 2) {
                        if (i20 != 3) {
                            composer3.startReplaceGroup(-1666936492);
                            composer3.endReplaceGroup();
                            throw new ua.r();
                        }
                        composer3.startReplaceGroup(-1666881264);
                        composer3.endReplaceGroup();
                        throw new ua.s(null, 1, null);
                    }
                    composer3.startReplaceGroup(-134212032);
                    composer4 = composer3;
                    Z17PictureKt.m10278Z17BasePictureC8z9wKI(androidx.compose.foundation.layout.x.a(columnScopeInstance, companion2, 1.0f, false, 2, null), Z17FormCamera$lambda$16$lambda$1(mutableState).getValue(), null, null, null, null, 0, null, null, composer4, 0, TypedValues.PositionType.TYPE_CURVE_FIT);
                    Modifier modifierM1727paddingVpY3zN4$default2 = PaddingKt.m1727paddingVpY3zN4$default(companion2, 0.0f, Dp.m8823constructorimpl(10), 1, null);
                    if ((3670016 & i13) == 1048576) {
                        z14 = true;
                    } else {
                        z14 = false;
                    }
                    objRememberedValue6 = composer4.rememberedValue();
                    if (z14) {
                        objRememberedValue6 = new lb.a() { // from class: cu.z17.views.form.x
                            @Override // lb.a
                            public final Object invoke() {
                                return Z17FormCameraKt.Z17FormCamera$lambda$16$lambda$15$lambda$14$lambda$13(onSelected, mutableState);
                            }
                        };
                        composer4.updateRememberedValue(objRememberedValue6);
                    } else {
                        objRememberedValue6 = new lb.a() { // from class: cu.z17.views.form.x
                            @Override // lb.a
                            public final Object invoke() {
                                return Z17FormCameraKt.Z17FormCamera$lambda$16$lambda$15$lambda$14$lambda$13(onSelected, mutableState);
                            }
                        };
                        composer4.updateRememberedValue(objRememberedValue6);
                    }
                    String strStringResource2 = StringResources_androidKt.stringResource(R.string.accept, composer4, 0);
                    composer2 = composer4;
                    Z17ButtonsKt.Z17PrimaryButton(modifierM1727paddingVpY3zN4$default2, (lb.a) objRememberedValue6, strStringResource2, null, true, false, composer2, 24582, 40);
                    composer2.endReplaceGroup();
                }
                composer2.endNode();
                composer2.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = modifier3;
                str2 = str4;
                i17 = i18;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                str2 = str;
                i17 = i14;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final Modifier modifier5 = modifier2;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.form.y
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return Z17FormCameraKt.Z17FormCamera$lambda$17(modifier5, i17, rootPath, str2, onClose, onRequestRealPath, onSelected, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i13 |= 48;
        i14 = i10;
        if ((i11 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            if (composerStartRestartGroup.changed(rootPath)) {
                i24 = 256;
            } else {
                i24 = 128;
            }
            i13 |= i24;
        }
        i15 = i12 & 8;
        if (i15 != 0) {
            if ((i11 & 3072) == 0) {
                if (composerStartRestartGroup.changed(str)) {
                    i16 = 2048;
                } else {
                    i16 = 1024;
                }
                i13 |= i16;
            }
            if ((i11 & 24576) == 0) {
                if (composerStartRestartGroup.changedInstance(onClose)) {
                    i23 = 16384;
                } else {
                    i23 = 8192;
                }
                i13 |= i23;
            }
            if ((196608 & i11) == 0) {
                if (composerStartRestartGroup.changedInstance(onRequestRealPath)) {
                    i22 = 131072;
                } else {
                    i22 = 65536;
                }
                i13 |= i22;
            }
            if ((1572864 & i11) == 0) {
                if (composerStartRestartGroup.changedInstance(onSelected)) {
                    i21 = 1048576;
                } else {
                    i21 = 524288;
                }
                i13 |= i21;
            }
            if ((599187 & i13) != 599186) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z10, i13 & 1)) {
                if (i25 != 0) {
                    modifier3 = Modifier.INSTANCE;
                } else {
                    modifier3 = modifier2;
                }
                if (i26 != 0) {
                    i14 = 1;
                }
                if (i15 != 0) {
                    str3 = "";
                } else {
                    str3 = str;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1922330802, i13, -1, "cu.z17.views.form.Z17FormCamera (Z17FormCamera.kt:48)");
                }
                MaterialTheme materialTheme3 = MaterialTheme.INSTANCE;
                int i29 = MaterialTheme.$stable;
                Modifier modifierSafeContentPadding3 = WindowInsetsPadding_androidKt.safeContentPadding(BackgroundKt.m1205backgroundbw27NRU$default(modifier3, materialTheme3.getColorScheme(composerStartRestartGroup, i29).getBackground(), null, 2, null));
                Alignment.Companion companion7 = Alignment.INSTANCE;
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(companion7.getTopStart(), false);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap7 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier7 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierSafeContentPadding3);
                ComposeUiNode.Companion companion8 = ComposeUiNode.INSTANCE;
                constructor = companion8.getConstructor();
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
                Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy3, companion8.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap7, companion8.getSetResolvedCompositionLocals());
                setCompositeKeyHash = companion8.getSetCompositeKeyHash();
                if (composerM5176constructorimpl.getInserting()) {
                    composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                } else {
                    composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier7, companion8.getSetModifier());
                BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                companion = Composer.INSTANCE;
                if (objRememberedValue == companion.getEmpty()) {
                    str4 = str3;
                    i18 = i14;
                    objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new Z17FormCameraState(str4, i18, null, 4, null), null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    str4 = str3;
                    i18 = i14;
                }
                mutableState = (MutableState) objRememberedValue;
                ActivityResultContracts.GetContent getContent3 = new ActivityResultContracts.GetContent();
                if ((458752 & i13) == 131072) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (z11) {
                    objRememberedValue2 = new Function1() { // from class: cu.z17.views.form.t
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return Z17FormCameraKt.Z17FormCamera$lambda$16$lambda$5$lambda$4(onRequestRealPath, mutableState, (Uri) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new Function1() { // from class: cu.z17.views.form.t
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return Z17FormCameraKt.Z17FormCamera$lambda$16$lambda$5$lambda$4(onRequestRealPath, mutableState, (Uri) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                managedActivityResultLauncherRememberLauncherForActivityResult = ActivityResultRegistryKt.rememberLauncherForActivityResult(getContent3, (Function1) objRememberedValue2, composerStartRestartGroup, 0);
                companion2 = Modifier.INSTANCE;
                Modifier modifierFillMaxSize$default3 = SizeKt.fillMaxSize$default(BackgroundKt.m1205backgroundbw27NRU$default(companion2, materialTheme3.getColorScheme(composerStartRestartGroup, i29).getBackground(), null, 2, null), 0.0f, 1, null);
                Arrangement arrangement3 = Arrangement.INSTANCE;
                MeasurePolicy measurePolicyColumnMeasurePolicy3 = ColumnKt.columnMeasurePolicy(arrangement3.getTop(), companion7.getStart(), composerStartRestartGroup, 0);
                currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap8 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier8 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxSize$default3);
                constructor2 = companion8.getConstructor();
                if (!defpackage.r.a(composerStartRestartGroup.getApplier())) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor2);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerM5176constructorimpl2 = Updater.m5176constructorimpl(composerStartRestartGroup);
                Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyColumnMeasurePolicy3, companion8.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap8, companion8.getSetResolvedCompositionLocals());
                setCompositeKeyHash2 = companion8.getSetCompositeKeyHash();
                if (composerM5176constructorimpl2.getInserting()) {
                    composerM5176constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    composerM5176constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                } else {
                    composerM5176constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    composerM5176constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                }
                Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier8, companion8.getSetModifier());
                columnScopeInstance = ColumnScopeInstance.INSTANCE;
                Modifier modifierM1725padding3ABfNKs3 = PaddingKt.m1725padding3ABfNKs(SizeKt.fillMaxWidth$default(companion2, 0.0f, 1, null), Dp.m8823constructorimpl(5));
                MeasurePolicy measurePolicyRowMeasurePolicy3 = RowKt.rowMeasurePolicy(arrangement3.getStart(), companion7.getCenterVertically(), composerStartRestartGroup, 48);
                currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap9 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier9 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1725padding3ABfNKs3);
                constructor3 = companion8.getConstructor();
                if (!defpackage.r.a(composerStartRestartGroup.getApplier())) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor3);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerM5176constructorimpl3 = Updater.m5176constructorimpl(composerStartRestartGroup);
                Updater.m5184setimpl(composerM5176constructorimpl3, measurePolicyRowMeasurePolicy3, companion8.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl3, currentCompositionLocalMap9, companion8.getSetResolvedCompositionLocals());
                setCompositeKeyHash3 = companion8.getSetCompositeKeyHash();
                if (composerM5176constructorimpl3.getInserting()) {
                    composerM5176constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                    composerM5176constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                } else {
                    composerM5176constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                    composerM5176constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                }
                Updater.m5184setimpl(composerM5176constructorimpl3, modifierMaterializeModifier9, companion8.getSetModifier());
                RowScopeInstance rowScopeInstance3 = RowScopeInstance.INSTANCE;
                if ((57344 & i13) == 16384) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (z12) {
                    objRememberedValue3 = new lb.a() { // from class: cu.z17.views.form.u
                        @Override // lb.a
                        public final Object invoke() {
                            return Z17FormCameraKt.Z17FormCamera$lambda$16$lambda$15$lambda$10$lambda$7$lambda$6(onClose, mutableState);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new lb.a() { // from class: cu.z17.views.form.u
                        @Override // lb.a
                        public final Object invoke() {
                            return Z17FormCameraKt.Z17FormCamera$lambda$16$lambda$15$lambda$10$lambda$7$lambda$6(onClose, mutableState);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                composableSingletons$Z17FormCameraKt = ComposableSingletons$Z17FormCameraKt.INSTANCE;
                IconButtonKt.IconButton((lb.a) objRememberedValue3, null, false, null, null, composableSingletons$Z17FormCameraKt.m10144getLambda$1870006581$views_release(), composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 30);
                composer3 = composerStartRestartGroup;
                SpacerKt.Spacer(e3.a(rowScopeInstance3, companion2, 1.0f, false, 2, null), composer3, 0);
                Z17FormCameraStep step3 = Z17FormCamera$lambda$16$lambda$1(mutableState).getStep();
                int[] iArr3 = WhenMappings.$EnumSwitchMapping$0;
                i19 = iArr3[step3.ordinal()];
                if (i19 != 1) {
                    composer3.startReplaceGroup(2123552315);
                    zChangedInstance = composer3.changedInstance(managedActivityResultLauncherRememberLauncherForActivityResult);
                    objRememberedValue4 = composer3.rememberedValue();
                    if (zChangedInstance) {
                        objRememberedValue4 = new lb.a() { // from class: cu.z17.views.form.v
                            @Override // lb.a
                            public final Object invoke() {
                                return Z17FormCameraKt.Z17FormCamera$lambda$16$lambda$15$lambda$10$lambda$9$lambda$8(managedActivityResultLauncherRememberLauncherForActivityResult);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue4);
                    } else {
                        objRememberedValue4 = new lb.a() { // from class: cu.z17.views.form.v
                            @Override // lb.a
                            public final Object invoke() {
                                return Z17FormCameraKt.Z17FormCamera$lambda$16$lambda$15$lambda$10$lambda$9$lambda$8(managedActivityResultLauncherRememberLauncherForActivityResult);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue4);
                    }
                    IconButtonKt.IconButton((lb.a) objRememberedValue4, null, false, null, null, composableSingletons$Z17FormCameraKt.m10143getLambda$1158477629$views_release(), composer3, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 30);
                    composer3 = composer3;
                    composer3.endReplaceGroup();
                    ua.k0 k0Var7 = ua.k0.f43947a;
                } else if (i19 != 2) {
                    composer3.startReplaceGroup(2124150460);
                    composer3.endReplaceGroup();
                    ua.k0 k0Var8 = ua.k0.f43947a;
                } else {
                    if (i19 == 3) {
                        composer3.startReplaceGroup(-485689665);
                        composer3.endReplaceGroup();
                        throw new ua.r();
                    }
                    composer3.startReplaceGroup(2124224178);
                    composer3.endReplaceGroup();
                    ua.k0 k0Var9 = ua.k0.f43947a;
                }
                composer3.endNode();
                i20 = iArr3[Z17FormCamera$lambda$16$lambda$1(mutableState).getStep().ordinal()];
                if (i20 != 1) {
                    composer3.startReplaceGroup(-135378438);
                    Modifier modifierA3 = androidx.compose.foundation.layout.x.a(columnScopeInstance, companion2, 1.0f, false, 2, null);
                    if (Z17FormCamera$lambda$16$lambda$1(mutableState).getType() == 2) {
                        z13 = true;
                    } else {
                        z13 = false;
                    }
                    String str9 = rootPath + Z17FormCamera$lambda$16$newImageName();
                    String str10 = rootPath + Z17FormCamera$lambda$16$newVideoName();
                    objRememberedValue5 = composer3.rememberedValue();
                    if (objRememberedValue5 == companion.getEmpty()) {
                        objRememberedValue5 = new lb.o() { // from class: cu.z17.views.form.w
                            @Override // lb.o
                            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                                return Z17FormCameraKt.Z17FormCamera$lambda$16$lambda$15$lambda$12$lambda$11(mutableState, (String) obj, (ResultType) obj2, ((Long) obj3).longValue(), ((Float) obj4).floatValue());
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue5);
                    }
                    Z17CameraKt.Z17Camera(modifierA3, str9, str10, z13, null, null, null, onClose, (lb.o) objRememberedValue5, onClose, false, composer3, ((i13 << 9) & 29360128) | 100663296 | ((i13 << 15) & C.ENCODING_PCM_DOUBLE), 6, 112);
                    composer2 = composer3;
                    composer2.endReplaceGroup();
                } else {
                    if (i20 != 2) {
                        if (i20 != 3) {
                            composer3.startReplaceGroup(-1666936492);
                            composer3.endReplaceGroup();
                            throw new ua.r();
                        }
                        composer3.startReplaceGroup(-1666881264);
                        composer3.endReplaceGroup();
                        throw new ua.s(null, 1, null);
                    }
                    composer3.startReplaceGroup(-134212032);
                    composer4 = composer3;
                    Z17PictureKt.m10278Z17BasePictureC8z9wKI(androidx.compose.foundation.layout.x.a(columnScopeInstance, companion2, 1.0f, false, 2, null), Z17FormCamera$lambda$16$lambda$1(mutableState).getValue(), null, null, null, null, 0, null, null, composer4, 0, TypedValues.PositionType.TYPE_CURVE_FIT);
                    Modifier modifierM1727paddingVpY3zN4$default3 = PaddingKt.m1727paddingVpY3zN4$default(companion2, 0.0f, Dp.m8823constructorimpl(10), 1, null);
                    if ((3670016 & i13) == 1048576) {
                        z14 = true;
                    } else {
                        z14 = false;
                    }
                    objRememberedValue6 = composer4.rememberedValue();
                    if (z14) {
                        objRememberedValue6 = new lb.a() { // from class: cu.z17.views.form.x
                            @Override // lb.a
                            public final Object invoke() {
                                return Z17FormCameraKt.Z17FormCamera$lambda$16$lambda$15$lambda$14$lambda$13(onSelected, mutableState);
                            }
                        };
                        composer4.updateRememberedValue(objRememberedValue6);
                    } else {
                        objRememberedValue6 = new lb.a() { // from class: cu.z17.views.form.x
                            @Override // lb.a
                            public final Object invoke() {
                                return Z17FormCameraKt.Z17FormCamera$lambda$16$lambda$15$lambda$14$lambda$13(onSelected, mutableState);
                            }
                        };
                        composer4.updateRememberedValue(objRememberedValue6);
                    }
                    String strStringResource3 = StringResources_androidKt.stringResource(R.string.accept, composer4, 0);
                    composer2 = composer4;
                    Z17ButtonsKt.Z17PrimaryButton(modifierM1727paddingVpY3zN4$default3, (lb.a) objRememberedValue6, strStringResource3, null, true, false, composer2, 24582, 40);
                    composer2.endReplaceGroup();
                }
                composer2.endNode();
                composer2.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = modifier3;
                str2 = str4;
                i17 = i18;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                str2 = str;
                i17 = i14;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final Modifier modifier6 = modifier2;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.form.y
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return Z17FormCameraKt.Z17FormCamera$lambda$17(modifier6, i17, rootPath, str2, onClose, onRequestRealPath, onSelected, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i13 |= 3072;
        if ((i11 & 24576) == 0) {
            if (composerStartRestartGroup.changedInstance(onClose)) {
                i23 = 16384;
            } else {
                i23 = 8192;
            }
            i13 |= i23;
        }
        if ((196608 & i11) == 0) {
            if (composerStartRestartGroup.changedInstance(onRequestRealPath)) {
                i22 = 131072;
            } else {
                i22 = 65536;
            }
            i13 |= i22;
        }
        if ((1572864 & i11) == 0) {
            if (composerStartRestartGroup.changedInstance(onSelected)) {
                i21 = 1048576;
            } else {
                i21 = 524288;
            }
            i13 |= i21;
        }
        if ((599187 & i13) != 599186) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z10, i13 & 1)) {
            if (i25 != 0) {
                modifier3 = Modifier.INSTANCE;
            } else {
                modifier3 = modifier2;
            }
            if (i26 != 0) {
                i14 = 1;
            }
            if (i15 != 0) {
                str3 = "";
            } else {
                str3 = str;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1922330802, i13, -1, "cu.z17.views.form.Z17FormCamera (Z17FormCamera.kt:48)");
            }
            MaterialTheme materialTheme4 = MaterialTheme.INSTANCE;
            int i210 = MaterialTheme.$stable;
            Modifier modifierSafeContentPadding4 = WindowInsetsPadding_androidKt.safeContentPadding(BackgroundKt.m1205backgroundbw27NRU$default(modifier3, materialTheme4.getColorScheme(composerStartRestartGroup, i210).getBackground(), null, 2, null));
            Alignment.Companion companion9 = Alignment.INSTANCE;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy4 = BoxKt.maybeCachedBoxMeasurePolicy(companion9.getTopStart(), false);
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap10 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier10 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierSafeContentPadding4);
            ComposeUiNode.Companion companion10 = ComposeUiNode.INSTANCE;
            constructor = companion10.getConstructor();
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
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy4, companion10.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap10, companion10.getSetResolvedCompositionLocals());
            setCompositeKeyHash = companion10.getSetCompositeKeyHash();
            if (composerM5176constructorimpl.getInserting()) {
                composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            } else {
                composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier10, companion10.getSetModifier());
            BoxScopeInstance boxScopeInstance4 = BoxScopeInstance.INSTANCE;
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            companion = Composer.INSTANCE;
            if (objRememberedValue == companion.getEmpty()) {
                str4 = str3;
                i18 = i14;
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new Z17FormCameraState(str4, i18, null, 4, null), null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                str4 = str3;
                i18 = i14;
            }
            mutableState = (MutableState) objRememberedValue;
            ActivityResultContracts.GetContent getContent4 = new ActivityResultContracts.GetContent();
            if ((458752 & i13) == 131072) {
                z11 = true;
            } else {
                z11 = false;
            }
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (z11) {
                objRememberedValue2 = new Function1() { // from class: cu.z17.views.form.t
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Z17FormCameraKt.Z17FormCamera$lambda$16$lambda$5$lambda$4(onRequestRealPath, mutableState, (Uri) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            } else {
                objRememberedValue2 = new Function1() { // from class: cu.z17.views.form.t
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Z17FormCameraKt.Z17FormCamera$lambda$16$lambda$5$lambda$4(onRequestRealPath, mutableState, (Uri) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            managedActivityResultLauncherRememberLauncherForActivityResult = ActivityResultRegistryKt.rememberLauncherForActivityResult(getContent4, (Function1) objRememberedValue2, composerStartRestartGroup, 0);
            companion2 = Modifier.INSTANCE;
            Modifier modifierFillMaxSize$default4 = SizeKt.fillMaxSize$default(BackgroundKt.m1205backgroundbw27NRU$default(companion2, materialTheme4.getColorScheme(composerStartRestartGroup, i210).getBackground(), null, 2, null), 0.0f, 1, null);
            Arrangement arrangement4 = Arrangement.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy4 = ColumnKt.columnMeasurePolicy(arrangement4.getTop(), companion9.getStart(), composerStartRestartGroup, 0);
            currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap11 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier11 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxSize$default4);
            constructor2 = companion10.getConstructor();
            if (!defpackage.r.a(composerStartRestartGroup.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor2);
            } else {
                composerStartRestartGroup.useNode();
            }
            composerM5176constructorimpl2 = Updater.m5176constructorimpl(composerStartRestartGroup);
            Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyColumnMeasurePolicy4, companion10.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap11, companion10.getSetResolvedCompositionLocals());
            setCompositeKeyHash2 = companion10.getSetCompositeKeyHash();
            if (composerM5176constructorimpl2.getInserting()) {
                composerM5176constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                composerM5176constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            } else {
                composerM5176constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                composerM5176constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier11, companion10.getSetModifier());
            columnScopeInstance = ColumnScopeInstance.INSTANCE;
            Modifier modifierM1725padding3ABfNKs4 = PaddingKt.m1725padding3ABfNKs(SizeKt.fillMaxWidth$default(companion2, 0.0f, 1, null), Dp.m8823constructorimpl(5));
            MeasurePolicy measurePolicyRowMeasurePolicy4 = RowKt.rowMeasurePolicy(arrangement4.getStart(), companion9.getCenterVertically(), composerStartRestartGroup, 48);
            currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap12 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier12 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1725padding3ABfNKs4);
            constructor3 = companion10.getConstructor();
            if (!defpackage.r.a(composerStartRestartGroup.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor3);
            } else {
                composerStartRestartGroup.useNode();
            }
            composerM5176constructorimpl3 = Updater.m5176constructorimpl(composerStartRestartGroup);
            Updater.m5184setimpl(composerM5176constructorimpl3, measurePolicyRowMeasurePolicy4, companion10.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl3, currentCompositionLocalMap12, companion10.getSetResolvedCompositionLocals());
            setCompositeKeyHash3 = companion10.getSetCompositeKeyHash();
            if (composerM5176constructorimpl3.getInserting()) {
                composerM5176constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                composerM5176constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
            } else {
                composerM5176constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                composerM5176constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
            }
            Updater.m5184setimpl(composerM5176constructorimpl3, modifierMaterializeModifier12, companion10.getSetModifier());
            RowScopeInstance rowScopeInstance4 = RowScopeInstance.INSTANCE;
            if ((57344 & i13) == 16384) {
                z12 = true;
            } else {
                z12 = false;
            }
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (z12) {
                objRememberedValue3 = new lb.a() { // from class: cu.z17.views.form.u
                    @Override // lb.a
                    public final Object invoke() {
                        return Z17FormCameraKt.Z17FormCamera$lambda$16$lambda$15$lambda$10$lambda$7$lambda$6(onClose, mutableState);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            } else {
                objRememberedValue3 = new lb.a() { // from class: cu.z17.views.form.u
                    @Override // lb.a
                    public final Object invoke() {
                        return Z17FormCameraKt.Z17FormCamera$lambda$16$lambda$15$lambda$10$lambda$7$lambda$6(onClose, mutableState);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            composableSingletons$Z17FormCameraKt = ComposableSingletons$Z17FormCameraKt.INSTANCE;
            IconButtonKt.IconButton((lb.a) objRememberedValue3, null, false, null, null, composableSingletons$Z17FormCameraKt.m10144getLambda$1870006581$views_release(), composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 30);
            composer3 = composerStartRestartGroup;
            SpacerKt.Spacer(e3.a(rowScopeInstance4, companion2, 1.0f, false, 2, null), composer3, 0);
            Z17FormCameraStep step4 = Z17FormCamera$lambda$16$lambda$1(mutableState).getStep();
            int[] iArr4 = WhenMappings.$EnumSwitchMapping$0;
            i19 = iArr4[step4.ordinal()];
            if (i19 != 1) {
                composer3.startReplaceGroup(2123552315);
                zChangedInstance = composer3.changedInstance(managedActivityResultLauncherRememberLauncherForActivityResult);
                objRememberedValue4 = composer3.rememberedValue();
                if (zChangedInstance) {
                    objRememberedValue4 = new lb.a() { // from class: cu.z17.views.form.v
                        @Override // lb.a
                        public final Object invoke() {
                            return Z17FormCameraKt.Z17FormCamera$lambda$16$lambda$15$lambda$10$lambda$9$lambda$8(managedActivityResultLauncherRememberLauncherForActivityResult);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue4);
                } else {
                    objRememberedValue4 = new lb.a() { // from class: cu.z17.views.form.v
                        @Override // lb.a
                        public final Object invoke() {
                            return Z17FormCameraKt.Z17FormCamera$lambda$16$lambda$15$lambda$10$lambda$9$lambda$8(managedActivityResultLauncherRememberLauncherForActivityResult);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue4);
                }
                IconButtonKt.IconButton((lb.a) objRememberedValue4, null, false, null, null, composableSingletons$Z17FormCameraKt.m10143getLambda$1158477629$views_release(), composer3, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 30);
                composer3 = composer3;
                composer3.endReplaceGroup();
                ua.k0 k0Var10 = ua.k0.f43947a;
            } else if (i19 != 2) {
                composer3.startReplaceGroup(2124150460);
                composer3.endReplaceGroup();
                ua.k0 k0Var11 = ua.k0.f43947a;
            } else {
                if (i19 == 3) {
                    composer3.startReplaceGroup(-485689665);
                    composer3.endReplaceGroup();
                    throw new ua.r();
                }
                composer3.startReplaceGroup(2124224178);
                composer3.endReplaceGroup();
                ua.k0 k0Var12 = ua.k0.f43947a;
            }
            composer3.endNode();
            i20 = iArr4[Z17FormCamera$lambda$16$lambda$1(mutableState).getStep().ordinal()];
            if (i20 != 1) {
                composer3.startReplaceGroup(-135378438);
                Modifier modifierA4 = androidx.compose.foundation.layout.x.a(columnScopeInstance, companion2, 1.0f, false, 2, null);
                if (Z17FormCamera$lambda$16$lambda$1(mutableState).getType() == 2) {
                    z13 = true;
                } else {
                    z13 = false;
                }
                String str11 = rootPath + Z17FormCamera$lambda$16$newImageName();
                String str12 = rootPath + Z17FormCamera$lambda$16$newVideoName();
                objRememberedValue5 = composer3.rememberedValue();
                if (objRememberedValue5 == companion.getEmpty()) {
                    objRememberedValue5 = new lb.o() { // from class: cu.z17.views.form.w
                        @Override // lb.o
                        public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            return Z17FormCameraKt.Z17FormCamera$lambda$16$lambda$15$lambda$12$lambda$11(mutableState, (String) obj, (ResultType) obj2, ((Long) obj3).longValue(), ((Float) obj4).floatValue());
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue5);
                }
                Z17CameraKt.Z17Camera(modifierA4, str11, str12, z13, null, null, null, onClose, (lb.o) objRememberedValue5, onClose, false, composer3, ((i13 << 9) & 29360128) | 100663296 | ((i13 << 15) & C.ENCODING_PCM_DOUBLE), 6, 112);
                composer2 = composer3;
                composer2.endReplaceGroup();
            } else {
                if (i20 != 2) {
                    if (i20 != 3) {
                        composer3.startReplaceGroup(-1666936492);
                        composer3.endReplaceGroup();
                        throw new ua.r();
                    }
                    composer3.startReplaceGroup(-1666881264);
                    composer3.endReplaceGroup();
                    throw new ua.s(null, 1, null);
                }
                composer3.startReplaceGroup(-134212032);
                composer4 = composer3;
                Z17PictureKt.m10278Z17BasePictureC8z9wKI(androidx.compose.foundation.layout.x.a(columnScopeInstance, companion2, 1.0f, false, 2, null), Z17FormCamera$lambda$16$lambda$1(mutableState).getValue(), null, null, null, null, 0, null, null, composer4, 0, TypedValues.PositionType.TYPE_CURVE_FIT);
                Modifier modifierM1727paddingVpY3zN4$default4 = PaddingKt.m1727paddingVpY3zN4$default(companion2, 0.0f, Dp.m8823constructorimpl(10), 1, null);
                if ((3670016 & i13) == 1048576) {
                    z14 = true;
                } else {
                    z14 = false;
                }
                objRememberedValue6 = composer4.rememberedValue();
                if (z14) {
                    objRememberedValue6 = new lb.a() { // from class: cu.z17.views.form.x
                        @Override // lb.a
                        public final Object invoke() {
                            return Z17FormCameraKt.Z17FormCamera$lambda$16$lambda$15$lambda$14$lambda$13(onSelected, mutableState);
                        }
                    };
                    composer4.updateRememberedValue(objRememberedValue6);
                } else {
                    objRememberedValue6 = new lb.a() { // from class: cu.z17.views.form.x
                        @Override // lb.a
                        public final Object invoke() {
                            return Z17FormCameraKt.Z17FormCamera$lambda$16$lambda$15$lambda$14$lambda$13(onSelected, mutableState);
                        }
                    };
                    composer4.updateRememberedValue(objRememberedValue6);
                }
                String strStringResource4 = StringResources_androidKt.stringResource(R.string.accept, composer4, 0);
                composer2 = composer4;
                Z17ButtonsKt.Z17PrimaryButton(modifierM1727paddingVpY3zN4$default4, (lb.a) objRememberedValue6, strStringResource4, null, true, false, composer2, 24582, 40);
                composer2.endReplaceGroup();
            }
            composer2.endNode();
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier3;
            str2 = str4;
            i17 = i18;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            str2 = str;
            i17 = i14;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier7 = modifier2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.form.y
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return Z17FormCameraKt.Z17FormCamera$lambda$17(modifier7, i17, rootPath, str2, onClose, onRequestRealPath, onSelected, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final Z17FormCameraState Z17FormCamera$lambda$16$lambda$1(MutableState<Z17FormCameraState> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 Z17FormCamera$lambda$16$lambda$15$lambda$10$lambda$7$lambda$6(lb.a aVar, MutableState mutableState) {
        int i10 = WhenMappings.$EnumSwitchMapping$0[Z17FormCamera$lambda$16$lambda$1(mutableState).getStep().ordinal()];
        if (i10 == 1) {
            aVar.invoke();
        } else if (i10 == 2) {
            mutableState.setValue(Z17FormCameraState.copy$default(Z17FormCamera$lambda$16$lambda$1(mutableState), null, 0, Z17FormCameraStep.SHOOTING, 3, null));
        } else {
            if (i10 != 3) {
                throw new ua.r();
            }
            mutableState.setValue(Z17FormCameraState.copy$default(Z17FormCamera$lambda$16$lambda$1(mutableState), null, 0, Z17FormCameraStep.PREVIEW, 3, null));
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 Z17FormCamera$lambda$16$lambda$15$lambda$10$lambda$9$lambda$8(ManagedActivityResultLauncher managedActivityResultLauncher) {
        managedActivityResultLauncher.launch("image/*");
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 Z17FormCamera$lambda$16$lambda$15$lambda$12$lambda$11(MutableState mutableState, String path, ResultType resultType, long j10, float f10) {
        kotlin.jvm.internal.y.i(path, "path");
        kotlin.jvm.internal.y.i(resultType, "resultType");
        int i10 = WhenMappings.$EnumSwitchMapping$1[resultType.ordinal()];
        if (i10 != 1) {
            if (i10 == 2) {
                mutableState.setValue(Z17FormCameraState.copy$default(Z17FormCamera$lambda$16$lambda$1(mutableState), path, 0, Z17FormCameraStep.PREVIEW, 2, null));
            } else if (i10 != 3) {
                throw new ua.r();
            }
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 Z17FormCamera$lambda$16$lambda$15$lambda$14$lambda$13(Function1 function1, MutableState mutableState) {
        function1.invoke(Z17FormCamera$lambda$16$lambda$1(mutableState).getValue());
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 Z17FormCamera$lambda$16$lambda$5$lambda$4(Function1 function1, MutableState mutableState, Uri uri) {
        String path;
        if (uri != null && (path = uri.getPath()) != null) {
            mutableState.setValue(Z17FormCameraState.copy$default(Z17FormCamera$lambda$16$lambda$1(mutableState), (String) function1.invoke(path), 0, Z17FormCameraStep.PREVIEW, 2, null));
        }
        return ua.k0.f43947a;
    }

    private static final String Z17FormCamera$lambda$16$newImageName() {
        return new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss", Locale.US).format(new Date()) + ".jpeg";
    }

    private static final String Z17FormCamera$lambda$16$newVideoName() {
        return new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss", Locale.US).format(new Date()) + ".mp4";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 Z17FormCamera$lambda$17(Modifier modifier, int i10, String str, String str2, lb.a aVar, Function1 function1, Function1 function2, int i11, int i12, Composer composer, int i13) {
        Z17FormCamera(modifier, i10, str, str2, aVar, function1, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i11 | 1), i12);
        return ua.k0.f43947a;
    }
}
