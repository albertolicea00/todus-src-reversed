package cu.z17.views.form;

import android.content.Context;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.LazyListStateKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.profileinstaller.ProfileVerifier;
import cu.z17.views.loader.Z17SimpleCircleLoaderKt;
import cu.z17.views.permission.PermissionNeedIt;
import cu.z17.views.permission.Z17PermissionRequesterKt;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import va.v0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u001aÈ\u0001\u0010\u0012\u001a\u00020\u00072\b\b\u0002\u0010\u0001\u001a\u00020\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u001f\b\u0002\u0010\t\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\b\b2.\u0010\r\u001a*\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\nj\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b`\f\u0012\u0004\u0012\u00020\u00070\u00052.\u0010\u000e\u001a*\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\nj\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b`\f\u0012\u0004\u0012\u00020\u00070\u00052\u0014\b\u0002\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u0010H\u0007¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u001b²\u0006\u000e\u0010\u0015\u001a\u00020\u00148\n@\nX\u008a\u008e\u0002²\u0006\f\u0010\u0016\u001a\u00020\u00148\nX\u008a\u0084\u0002²\u0006\u000e\u0010\u0017\u001a\u00020\u00148\n@\nX\u008a\u008e\u0002²\u0006\"\u0010\u001a\u001a\u0016\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00188\n@\nX\u008a\u008e\u0002"}, d2 = {"Landroidx/compose/ui/Modifier;", "modifier", "", "Lcu/z17/views/form/FormItemRequest;", "initialRequest", "Lkotlin/Function1;", "Lkotlin/Function0;", "Lua/k0;", "Landroidx/compose/runtime/Composable;", "submitBtn", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "onComplete", "onUpdated", "onRequestRealPath", "Lcu/z17/views/form/Z17FormConfigs;", "configs", "Z17Form", "(Landroidx/compose/ui/Modifier;Ljava/util/List;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lcu/z17/views/form/Z17FormConfigs;Landroidx/compose/runtime/Composer;II)V", "", "permissionsGranted", "isLoading", "isChecked", "Lua/y;", "", "cameraDisplaying", "views_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class Z17FormKt {
    /* JADX WARN: Code duplicated, block: B:101:0x01ca  */
    /* JADX WARN: Code duplicated, block: B:102:0x01ce  */
    /* JADX WARN: Code duplicated, block: B:107:0x01fb  */
    /* JADX WARN: Code duplicated, block: B:109:0x0234  */
    /* JADX WARN: Code duplicated, block: B:111:0x0263  */
    /* JADX WARN: Code duplicated, block: B:114:0x026f  */
    /* JADX WARN: Code duplicated, block: B:115:0x0273  */
    /* JADX WARN: Code duplicated, block: B:120:0x02a2  */
    /* JADX WARN: Code duplicated, block: B:123:0x02c9  */
    /* JADX WARN: Code duplicated, block: B:124:0x02d3  */
    /* JADX WARN: Code duplicated, block: B:127:0x02e0  */
    /* JADX WARN: Code duplicated, block: B:128:0x02e2  */
    /* JADX WARN: Code duplicated, block: B:131:0x02ee  */
    /* JADX WARN: Code duplicated, block: B:132:0x02f0  */
    /* JADX WARN: Code duplicated, block: B:135:0x02f8  */
    /* JADX WARN: Code duplicated, block: B:136:0x02fa  */
    /* JADX WARN: Code duplicated, block: B:141:0x0308  */
    /* JADX WARN: Code duplicated, block: B:146:0x0356  */
    /* JADX WARN: Code duplicated, block: B:148:0x0362  */
    /* JADX WARN: Code duplicated, block: B:150:0x0374  */
    /* JADX WARN: Code duplicated, block: B:151:0x0380  */
    /* JADX WARN: Code duplicated, block: B:158:0x03a6  */
    /* JADX WARN: Code duplicated, block: B:161:0x03b3  */
    /* JADX WARN: Code duplicated, block: B:162:0x03be  */
    /* JADX WARN: Code duplicated, block: B:165:0x03cd  */
    /* JADX WARN: Code duplicated, block: B:168:0x03ed  */
    /* JADX WARN: Code duplicated, block: B:171:0x040f  */
    /* JADX WARN: Code duplicated, block: B:174:0x0435  */
    /* JADX WARN: Code duplicated, block: B:180:0x0455  */
    /* JADX WARN: Code duplicated, block: B:183:0x046b  */
    /* JADX WARN: Code duplicated, block: B:186:0x0474  */
    /* JADX WARN: Code duplicated, block: B:189:0x0484  */
    /* JADX WARN: Code duplicated, block: B:191:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:33:0x006d  */
    /* JADX WARN: Code duplicated, block: B:35:0x0073  */
    /* JADX WARN: Code duplicated, block: B:36:0x0076  */
    /* JADX WARN: Code duplicated, block: B:40:0x007d  */
    /* JADX WARN: Code duplicated, block: B:42:0x0083  */
    /* JADX WARN: Code duplicated, block: B:43:0x0086  */
    /* JADX WARN: Code duplicated, block: B:47:0x008f  */
    /* JADX WARN: Code duplicated, block: B:48:0x0094  */
    /* JADX WARN: Code duplicated, block: B:50:0x009a  */
    /* JADX WARN: Code duplicated, block: B:52:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:53:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:57:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:58:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:61:0x00bc A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:62:0x00be  */
    /* JADX WARN: Code duplicated, block: B:63:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:65:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:67:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:69:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:71:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:74:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:75:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:78:0x0104  */
    /* JADX WARN: Code duplicated, block: B:81:0x0120  */
    /* JADX WARN: Code duplicated, block: B:84:0x0135  */
    /* JADX WARN: Code duplicated, block: B:87:0x0149  */
    /* JADX WARN: Code duplicated, block: B:90:0x0160  */
    /* JADX WARN: Code duplicated, block: B:93:0x0178  */
    /* JADX WARN: Code duplicated, block: B:96:0x018c  */
    /* JADX WARN: Code duplicated, block: B:98:0x01be  */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    public static final void Z17Form(Modifier modifier, final List<FormItemRequest> initialRequest, Function3 function3, final Function1 onComplete, final Function1 onUpdated, Function1 function1, Z17FormConfigs z17FormConfigs, Composer composer, final int i10, final int i11) {
        Modifier modifier2;
        int i12;
        final Function3 lambda$699739717$views_release;
        int i13;
        Function1 function2;
        int i14;
        boolean z10;
        List<FormItemRequest> list;
        Composer composer2;
        final Z17FormConfigs z17FormConfigs2;
        Modifier modifier3;
        final Function3 function4;
        final Function1 function5;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier modifier4;
        Function1 function6;
        Z17FormConfigs z17FormConfigs3;
        Context context;
        Object objRememberedValue;
        Composer.Companion companion;
        final pe.m0 m0Var;
        Object objRememberedValue2;
        final SnapshotStateList snapshotStateList;
        Object objRememberedValue3;
        final MutableState mutableState;
        Object objRememberedValue4;
        State state;
        Object objRememberedValue5;
        final MutableState mutableState2;
        int currentCompositeKeyHash;
        lb.a constructor;
        Composer composerM5176constructorimpl;
        Function2 setCompositeKeyHash;
        Object objRememberedValue6;
        final MutableState mutableState3;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        Object obj;
        Modifier modifier5;
        int i15;
        final SnapshotStateList snapshotStateList2;
        int i16;
        SnapshotStateList snapshotStateList3;
        ab.e eVar;
        int i17;
        Object objRememberedValue7;
        ua.y yVarZ17Form$lambda$38$lambda$17;
        int iIntValue;
        ua.y yVarZ17Form$lambda$38$lambda$18;
        String str;
        Object objRememberedValue8;
        final MutableState mutableState4;
        Object objRememberedValue9;
        boolean zChangedInstance;
        Object objRememberedValue10;
        int currentCompositeKeyHash2;
        lb.a constructor2;
        Composer composerM5176constructorimpl2;
        Function2 setCompositeKeyHash2;
        Object objRememberedValue11;
        int i18;
        int i19;
        kotlin.jvm.internal.y.i(initialRequest, "initialRequest");
        kotlin.jvm.internal.y.i(onComplete, "onComplete");
        kotlin.jvm.internal.y.i(onUpdated, "onUpdated");
        Composer composerStartRestartGroup = composer.startRestartGroup(218285199);
        int i20 = i11 & 1;
        if (i20 != 0) {
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
            i12 |= composerStartRestartGroup.changedInstance(initialRequest) ? 32 : 16;
        }
        int i21 = i11 & 4;
        if (i21 == 0) {
            if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                lambda$699739717$views_release = function3;
                i12 |= composerStartRestartGroup.changedInstance(lambda$699739717$views_release) ? 256 : 128;
            }
            if ((i10 & 3072) == 0) {
                if (composerStartRestartGroup.changedInstance(onComplete)) {
                    i19 = 2048;
                } else {
                    i19 = 1024;
                }
                i12 |= i19;
            }
            if ((i10 & 24576) == 0) {
                if (composerStartRestartGroup.changedInstance(onUpdated)) {
                    i18 = 16384;
                } else {
                    i18 = 8192;
                }
                i12 |= i18;
            }
            i13 = i11 & 32;
            if (i13 != 0) {
                i12 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                function2 = function1;
            } else {
                function2 = function1;
                if ((i10 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changedInstance(function2)) {
                        i14 = 131072;
                    } else {
                        i14 = 65536;
                    }
                    i12 |= i14;
                }
            }
            if ((i12 & 74899) != 74898) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z10, i12 & 1)) {
                if (i20 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (i21 != 0) {
                    lambda$699739717$views_release = ComposableSingletons$Z17FormKt.INSTANCE.getLambda$699739717$views_release();
                }
                if (i13 != 0) {
                    objRememberedValue11 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue11 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue11 = new Function1() { // from class: cu.z17.views.form.g0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return Z17FormKt.Z17Form$lambda$1$lambda$0((String) obj2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue11);
                    }
                    function6 = (Function1) objRememberedValue11;
                } else {
                    function6 = function2;
                }
                if ((i11 & 64) != 0) {
                    z17FormConfigs3 = new Z17FormConfigs(false, null, null, 7, null);
                } else {
                    z17FormConfigs3 = z17FormConfigs;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(218285199, i12, -1, "cu.z17.views.form.Z17Form (Z17Form.kt:49)");
                }
                context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                companion = Composer.INSTANCE;
                if (objRememberedValue == companion.getEmpty()) {
                    objRememberedValue = EffectsKt.createCompositionCoroutineScope(ab.j.f643c, composerStartRestartGroup);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                m0Var = (pe.m0) objRememberedValue;
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == companion.getEmpty()) {
                    objRememberedValue2 = SnapshotStateKt.mutableStateListOf();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                snapshotStateList = (SnapshotStateList) objRememberedValue2;
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue3 == companion.getEmpty()) {
                    objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                mutableState = (MutableState) objRememberedValue3;
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue4 == companion.getEmpty()) {
                    objRememberedValue4 = SnapshotStateKt.derivedStateOf(new lb.a() { // from class: cu.z17.views.form.h0
                        @Override // lb.a
                        public final Object invoke() {
                            return Boolean.valueOf(Z17FormKt.Z17Form$lambda$7$lambda$6(snapshotStateList, initialRequest));
                        }
                    });
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                state = (State) objRememberedValue4;
                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue5 == companion.getEmpty()) {
                    MutableState mutableStateMutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default);
                    objRememberedValue5 = mutableStateMutableStateOf$default;
                }
                mutableState2 = (MutableState) objRememberedValue5;
                if (Z17Form$lambda$8(state)) {
                    composerStartRestartGroup.startReplaceGroup(355700904);
                    Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(modifier4, 0.0f, 1, null);
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getCenter(), false);
                    currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxSize$default);
                    ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                    constructor2 = companion2.getConstructor();
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
                    Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy, companion2.getSetMeasurePolicy());
                    Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
                    setCompositeKeyHash2 = companion2.getSetCompositeKeyHash();
                    if (composerM5176constructorimpl2.getInserting() || !kotlin.jvm.internal.y.d(composerM5176constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                        composerM5176constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                        composerM5176constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                    }
                    Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier, companion2.getSetModifier());
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                    Z17SimpleCircleLoaderKt.m10265Z17SimpleCircleLoaderZij2fk(null, 0.0f, 0.0f, 0L, composerStartRestartGroup, 0, 15);
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceGroup();
                    eVar = null;
                    snapshotStateList3 = snapshotStateList;
                    lambda$699739717$views_release = lambda$699739717$views_release;
                    composer2 = composerStartRestartGroup;
                    function2 = function6;
                    modifier3 = modifier4;
                } else {
                    composerStartRestartGroup.startReplaceGroup(355944285);
                    int i22 = i12 & 14;
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier4);
                    ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
                    constructor = companion3.getConstructor();
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
                    Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy2, companion3.getSetMeasurePolicy());
                    Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
                    setCompositeKeyHash = companion3.getSetCompositeKeyHash();
                    if (composerM5176constructorimpl.getInserting() || !kotlin.jvm.internal.y.d(composerM5176constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier2, companion3.getSetModifier());
                    BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                    LazyListState lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                    objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue6 == companion.getEmpty()) {
                        objRememberedValue6 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                    }
                    mutableState3 = (MutableState) objRememberedValue6;
                    if ((i12 & 57344) == 16384) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    boolean zChangedInstance2 = z11 | composerStartRestartGroup.changedInstance(m0Var);
                    if ((i12 & 896) == 256) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    boolean z15 = z12 | zChangedInstance2;
                    if ((i12 & 7168) == 2048) {
                        z13 = true;
                    } else {
                        z13 = false;
                    }
                    z14 = z15 | z13;
                    Object objRememberedValue12 = composerStartRestartGroup.rememberedValue();
                    if (!z14 || objRememberedValue12 == companion.getEmpty()) {
                        modifier5 = modifier4;
                        i15 = 1;
                        snapshotStateList2 = snapshotStateList;
                        obj = new Function1() { // from class: cu.z17.views.form.i0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return Z17FormKt.Z17Form$lambda$38$lambda$31$lambda$30(snapshotStateList2, onUpdated, m0Var, mutableState2, mutableState3, lambda$699739717$views_release, onComplete, (LazyListScope) obj2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(obj);
                    } else {
                        modifier5 = modifier4;
                        obj = objRememberedValue12;
                        snapshotStateList2 = snapshotStateList;
                        i15 = 1;
                    }
                    Function1 function7 = (Function1) obj;
                    Modifier modifier6 = modifier5;
                    i16 = i12;
                    snapshotStateList3 = snapshotStateList2;
                    eVar = null;
                    i17 = i15;
                    LazyDslKt.LazyColumn(modifier6, lazyListStateRememberLazyListState, null, false, null, null, null, false, null, function7, composerStartRestartGroup, i22, TypedValues.PositionType.TYPE_CURVE_FIT);
                    composer2 = composerStartRestartGroup;
                    modifier3 = modifier6;
                    if (Z17Form$lambda$38$lambda$17(mutableState3) != null) {
                        composer2.startReplaceGroup(-1382321129);
                        if (Z17Form$lambda$4(mutableState)) {
                            composer2.startReplaceGroup(-1382277388);
                            Modifier modifierFillMaxSize$default2 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, i17, null);
                            yVarZ17Form$lambda$38$lambda$17 = Z17Form$lambda$38$lambda$17(mutableState3);
                            if (yVarZ17Form$lambda$38$lambda$17 != null) {
                                iIntValue = ((Number) yVarZ17Form$lambda$38$lambda$17.g()).intValue();
                            } else {
                                iIntValue = i17;
                            }
                            String path = new File(context.getCacheDir(), "/form_photo/").getPath();
                            kotlin.jvm.internal.y.h(path, "getPath(...)");
                            yVarZ17Form$lambda$38$lambda$18 = Z17Form$lambda$38$lambda$17(mutableState3);
                            if (yVarZ17Form$lambda$38$lambda$18 != null || (str = (String) yVarZ17Form$lambda$38$lambda$18.h()) == null) {
                                str = "";
                            }
                            String str2 = str;
                            objRememberedValue8 = composer2.rememberedValue();
                            if (objRememberedValue8 == companion.getEmpty()) {
                                mutableState4 = mutableState3;
                                objRememberedValue8 = new lb.a() { // from class: cu.z17.views.form.j0
                                    @Override // lb.a
                                    public final Object invoke() {
                                        return Z17FormKt.Z17Form$lambda$38$lambda$33$lambda$32(mutableState4);
                                    }
                                };
                                composer2.updateRememberedValue(objRememberedValue8);
                            } else {
                                mutableState4 = mutableState3;
                            }
                            lb.a aVar = (lb.a) objRememberedValue8;
                            objRememberedValue9 = composer2.rememberedValue();
                            if (objRememberedValue9 == companion.getEmpty()) {
                                objRememberedValue9 = new Function1() { // from class: cu.z17.views.form.k0
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj2) {
                                        return Z17FormKt.Z17Form$lambda$38$lambda$35$lambda$34(mutableState4, (String) obj2);
                                    }
                                };
                                composer2.updateRememberedValue(objRememberedValue9);
                            }
                            Function1 function8 = function6;
                            Z17FormCameraKt.Z17FormCamera(modifierFillMaxSize$default2, iIntValue, path, str2, aVar, function8, (Function1) objRememberedValue9, composer2, (i16 & 458752) | 1597446, 0);
                            function2 = function8;
                        } else {
                            function2 = function6;
                            composer2.startReplaceGroup(-1387708247);
                        }
                        composer2.endReplaceGroup();
                        PermissionNeedIt[] permissionNeedItArr = new PermissionNeedIt[3];
                        permissionNeedItArr[0] = PermissionNeedIt.STORAGE;
                        permissionNeedItArr[i17] = PermissionNeedIt.CAMERA;
                        permissionNeedItArr[2] = PermissionNeedIt.RECORD_AUDIO;
                        List listQ = va.w.q(permissionNeedItArr);
                        objRememberedValue7 = composer2.rememberedValue();
                        if (objRememberedValue7 == companion.getEmpty()) {
                            objRememberedValue7 = new lb.a() { // from class: cu.z17.views.form.l0
                                @Override // lb.a
                                public final Object invoke() {
                                    return Z17FormKt.Z17Form$lambda$38$lambda$37$lambda$36(mutableState);
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue7);
                        }
                        String packageName = context.getPackageName();
                        kotlin.jvm.internal.y.h(packageName, "getPackageName(...)");
                        Z17PermissionRequesterKt.Z17PermissionCheckerAndRequester(null, null, listQ, (lb.a) objRememberedValue7, null, packageName, null, composer2, 1576320, 19);
                    } else {
                        function2 = function6;
                        composer2.startReplaceGroup(-1387708247);
                    }
                    composer2.endReplaceGroup();
                    composer2.endNode();
                    composer2.endReplaceGroup();
                }
                ua.k0 k0Var = ua.k0.f43947a;
                list = initialRequest;
                zChangedInstance = composer2.changedInstance(list);
                objRememberedValue10 = composer2.rememberedValue();
                if (zChangedInstance || objRememberedValue10 == companion.getEmpty()) {
                    objRememberedValue10 = new Z17FormKt$Z17Form$4$1(snapshotStateList3, list, eVar);
                    composer2.updateRememberedValue(objRememberedValue10);
                }
                EffectsKt.LaunchedEffect(k0Var, (Function2) objRememberedValue10, composer2, 6);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function4 = lambda$699739717$views_release;
                z17FormConfigs2 = z17FormConfigs3;
            } else {
                list = initialRequest;
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                z17FormConfigs2 = z17FormConfigs;
                modifier3 = modifier2;
                function4 = lambda$699739717$views_release;
            }
            function5 = function2;
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final List<FormItemRequest> list2 = list;
                final Modifier modifier7 = modifier3;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.form.m0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj2, Object obj3) {
                        return Z17FormKt.Z17Form$lambda$40(modifier7, list2, function4, onComplete, onUpdated, function5, z17FormConfigs2, i10, i11, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                });
            }
        }
        i12 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        lambda$699739717$views_release = function3;
        if ((i10 & 3072) == 0) {
            if (composerStartRestartGroup.changedInstance(onComplete)) {
                i19 = 2048;
            } else {
                i19 = 1024;
            }
            i12 |= i19;
        }
        if ((i10 & 24576) == 0) {
            if (composerStartRestartGroup.changedInstance(onUpdated)) {
                i18 = 16384;
            } else {
                i18 = 8192;
            }
            i12 |= i18;
        }
        i13 = i11 & 32;
        if (i13 != 0) {
            i12 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            function2 = function1;
        } else {
            function2 = function1;
            if ((i10 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                if (composerStartRestartGroup.changedInstance(function2)) {
                    i14 = 131072;
                } else {
                    i14 = 65536;
                }
                i12 |= i14;
            }
        }
        if ((i12 & 74899) != 74898) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z10, i12 & 1)) {
            if (i20 != 0) {
                modifier4 = Modifier.INSTANCE;
            } else {
                modifier4 = modifier2;
            }
            if (i21 != 0) {
                lambda$699739717$views_release = ComposableSingletons$Z17FormKt.INSTANCE.getLambda$699739717$views_release();
            }
            if (i13 != 0) {
                objRememberedValue11 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue11 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue11 = new Function1() { // from class: cu.z17.views.form.g0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return Z17FormKt.Z17Form$lambda$1$lambda$0((String) obj2);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue11);
                }
                function6 = (Function1) objRememberedValue11;
            } else {
                function6 = function2;
            }
            if ((i11 & 64) != 0) {
                z17FormConfigs3 = new Z17FormConfigs(false, null, null, 7, null);
            } else {
                z17FormConfigs3 = z17FormConfigs;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(218285199, i12, -1, "cu.z17.views.form.Z17Form (Z17Form.kt:49)");
            }
            context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            companion = Composer.INSTANCE;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = EffectsKt.createCompositionCoroutineScope(ab.j.f643c, composerStartRestartGroup);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            m0Var = (pe.m0) objRememberedValue;
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt.mutableStateListOf();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            snapshotStateList = (SnapshotStateList) objRememberedValue2;
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == companion.getEmpty()) {
                objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            mutableState = (MutableState) objRememberedValue3;
            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue4 == companion.getEmpty()) {
                objRememberedValue4 = SnapshotStateKt.derivedStateOf(new lb.a() { // from class: cu.z17.views.form.h0
                    @Override // lb.a
                    public final Object invoke() {
                        return Boolean.valueOf(Z17FormKt.Z17Form$lambda$7$lambda$6(snapshotStateList, initialRequest));
                    }
                });
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            state = (State) objRememberedValue4;
            objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue5 == companion.getEmpty()) {
                MutableState mutableStateMutableStateOf$default2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default2);
                objRememberedValue5 = mutableStateMutableStateOf$default2;
            }
            mutableState2 = (MutableState) objRememberedValue5;
            if (Z17Form$lambda$8(state)) {
                composerStartRestartGroup.startReplaceGroup(355700904);
                Modifier modifierFillMaxSize$default3 = SizeKt.fillMaxSize$default(modifier4, 0.0f, 1, null);
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getCenter(), false);
                currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxSize$default3);
                ComposeUiNode.Companion companion4 = ComposeUiNode.INSTANCE;
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
                Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy3, companion4.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap3, companion4.getSetResolvedCompositionLocals());
                setCompositeKeyHash2 = companion4.getSetCompositeKeyHash();
                if (composerM5176constructorimpl2.getInserting()) {
                    composerM5176constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    composerM5176constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                } else {
                    composerM5176constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    composerM5176constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                }
                Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier3, companion4.getSetModifier());
                BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
                Z17SimpleCircleLoaderKt.m10265Z17SimpleCircleLoaderZij2fk(null, 0.0f, 0.0f, 0L, composerStartRestartGroup, 0, 15);
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceGroup();
                eVar = null;
                snapshotStateList3 = snapshotStateList;
                lambda$699739717$views_release = lambda$699739717$views_release;
                composer2 = composerStartRestartGroup;
                function2 = function6;
                modifier3 = modifier4;
            } else {
                composerStartRestartGroup.startReplaceGroup(355944285);
                int i23 = i12 & 14;
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy4 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier4);
                ComposeUiNode.Companion companion5 = ComposeUiNode.INSTANCE;
                constructor = companion5.getConstructor();
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
                Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy4, companion5.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap4, companion5.getSetResolvedCompositionLocals());
                setCompositeKeyHash = companion5.getSetCompositeKeyHash();
                if (composerM5176constructorimpl.getInserting()) {
                    composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                } else {
                    composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier4, companion5.getSetModifier());
                BoxScopeInstance boxScopeInstance4 = BoxScopeInstance.INSTANCE;
                LazyListState lazyListStateRememberLazyListState2 = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue6 == companion.getEmpty()) {
                    objRememberedValue6 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                }
                mutableState3 = (MutableState) objRememberedValue6;
                if ((i12 & 57344) == 16384) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                boolean zChangedInstance3 = z11 | composerStartRestartGroup.changedInstance(m0Var);
                if ((i12 & 896) == 256) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                boolean z16 = z12 | zChangedInstance3;
                if ((i12 & 7168) == 2048) {
                    z13 = true;
                } else {
                    z13 = false;
                }
                z14 = z16 | z13;
                Object objRememberedValue13 = composerStartRestartGroup.rememberedValue();
                if (z14) {
                    modifier5 = modifier4;
                    i15 = 1;
                    snapshotStateList2 = snapshotStateList;
                    obj = new Function1() { // from class: cu.z17.views.form.i0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return Z17FormKt.Z17Form$lambda$38$lambda$31$lambda$30(snapshotStateList2, onUpdated, m0Var, mutableState2, mutableState3, lambda$699739717$views_release, onComplete, (LazyListScope) obj2);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(obj);
                } else {
                    modifier5 = modifier4;
                    i15 = 1;
                    snapshotStateList2 = snapshotStateList;
                    obj = new Function1() { // from class: cu.z17.views.form.i0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return Z17FormKt.Z17Form$lambda$38$lambda$31$lambda$30(snapshotStateList2, onUpdated, m0Var, mutableState2, mutableState3, lambda$699739717$views_release, onComplete, (LazyListScope) obj2);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(obj);
                }
                Function1 function9 = (Function1) obj;
                Modifier modifier8 = modifier5;
                i16 = i12;
                snapshotStateList3 = snapshotStateList2;
                eVar = null;
                i17 = i15;
                LazyDslKt.LazyColumn(modifier8, lazyListStateRememberLazyListState2, null, false, null, null, null, false, null, function9, composerStartRestartGroup, i23, TypedValues.PositionType.TYPE_CURVE_FIT);
                composer2 = composerStartRestartGroup;
                modifier3 = modifier8;
                if (Z17Form$lambda$38$lambda$17(mutableState3) != null) {
                    composer2.startReplaceGroup(-1382321129);
                    if (Z17Form$lambda$4(mutableState)) {
                        composer2.startReplaceGroup(-1382277388);
                        Modifier modifierFillMaxSize$default4 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, i17, null);
                        yVarZ17Form$lambda$38$lambda$17 = Z17Form$lambda$38$lambda$17(mutableState3);
                        if (yVarZ17Form$lambda$38$lambda$17 != null) {
                            iIntValue = ((Number) yVarZ17Form$lambda$38$lambda$17.g()).intValue();
                        } else {
                            iIntValue = i17;
                        }
                        String path2 = new File(context.getCacheDir(), "/form_photo/").getPath();
                        kotlin.jvm.internal.y.h(path2, "getPath(...)");
                        yVarZ17Form$lambda$38$lambda$18 = Z17Form$lambda$38$lambda$17(mutableState3);
                        if (yVarZ17Form$lambda$38$lambda$18 != null) {
                            str = "";
                        } else {
                            str = "";
                        }
                        String str3 = str;
                        objRememberedValue8 = composer2.rememberedValue();
                        if (objRememberedValue8 == companion.getEmpty()) {
                            mutableState4 = mutableState3;
                            objRememberedValue8 = new lb.a() { // from class: cu.z17.views.form.j0
                                @Override // lb.a
                                public final Object invoke() {
                                    return Z17FormKt.Z17Form$lambda$38$lambda$33$lambda$32(mutableState4);
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue8);
                        } else {
                            mutableState4 = mutableState3;
                        }
                        lb.a aVar2 = (lb.a) objRememberedValue8;
                        objRememberedValue9 = composer2.rememberedValue();
                        if (objRememberedValue9 == companion.getEmpty()) {
                            objRememberedValue9 = new Function1() { // from class: cu.z17.views.form.k0
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj2) {
                                    return Z17FormKt.Z17Form$lambda$38$lambda$35$lambda$34(mutableState4, (String) obj2);
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue9);
                        }
                        Function1 function10 = function6;
                        Z17FormCameraKt.Z17FormCamera(modifierFillMaxSize$default4, iIntValue, path2, str3, aVar2, function10, (Function1) objRememberedValue9, composer2, (i16 & 458752) | 1597446, 0);
                        function2 = function10;
                    } else {
                        function2 = function6;
                        composer2.startReplaceGroup(-1387708247);
                    }
                    composer2.endReplaceGroup();
                    PermissionNeedIt[] permissionNeedItArr2 = new PermissionNeedIt[3];
                    permissionNeedItArr2[0] = PermissionNeedIt.STORAGE;
                    permissionNeedItArr2[i17] = PermissionNeedIt.CAMERA;
                    permissionNeedItArr2[2] = PermissionNeedIt.RECORD_AUDIO;
                    List listQ2 = va.w.q(permissionNeedItArr2);
                    objRememberedValue7 = composer2.rememberedValue();
                    if (objRememberedValue7 == companion.getEmpty()) {
                        objRememberedValue7 = new lb.a() { // from class: cu.z17.views.form.l0
                            @Override // lb.a
                            public final Object invoke() {
                                return Z17FormKt.Z17Form$lambda$38$lambda$37$lambda$36(mutableState);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue7);
                    }
                    String packageName2 = context.getPackageName();
                    kotlin.jvm.internal.y.h(packageName2, "getPackageName(...)");
                    Z17PermissionRequesterKt.Z17PermissionCheckerAndRequester(null, null, listQ2, (lb.a) objRememberedValue7, null, packageName2, null, composer2, 1576320, 19);
                } else {
                    function2 = function6;
                    composer2.startReplaceGroup(-1387708247);
                }
                composer2.endReplaceGroup();
                composer2.endNode();
                composer2.endReplaceGroup();
            }
            ua.k0 k0Var2 = ua.k0.f43947a;
            list = initialRequest;
            zChangedInstance = composer2.changedInstance(list);
            objRememberedValue10 = composer2.rememberedValue();
            if (zChangedInstance) {
                objRememberedValue10 = new Z17FormKt$Z17Form$4$1(snapshotStateList3, list, eVar);
                composer2.updateRememberedValue(objRememberedValue10);
            } else {
                objRememberedValue10 = new Z17FormKt$Z17Form$4$1(snapshotStateList3, list, eVar);
                composer2.updateRememberedValue(objRememberedValue10);
            }
            EffectsKt.LaunchedEffect(k0Var2, (Function2) objRememberedValue10, composer2, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            function4 = lambda$699739717$views_release;
            z17FormConfigs2 = z17FormConfigs3;
        } else {
            list = initialRequest;
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            z17FormConfigs2 = z17FormConfigs;
            modifier3 = modifier2;
            function4 = lambda$699739717$views_release;
        }
        function5 = function2;
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final List list3 = list;
            final Modifier modifier9 = modifier3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.form.m0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return Z17FormKt.Z17Form$lambda$40(modifier9, list3, function4, onComplete, onUpdated, function5, z17FormConfigs2, i10, i11, (Composer) obj2, ((Integer) obj3).intValue());
                }
            });
        }
    }

    private static final void Z17Form$checkForm(SnapshotStateList<FormItemRequest> snapshotStateList, Function1 function1, MutableState<Boolean> mutableState) {
        boolean z10;
        Iterator<FormItemRequest> it = snapshotStateList.iterator();
        loop0: while (true) {
            z10 = true;
            while (true) {
                if (!it.hasNext()) {
                    break loop0;
                }
                FormItemRequest next = it.next();
                if (kotlin.jvm.internal.y.d(next.getOkRegex(), UtilRegex.CANNOT_BE_EMPTY)) {
                    if (z10 && !le.d0.q0(next.getValue())) {
                        break;
                    }
                    z10 = false;
                } else if (kotlin.jvm.internal.y.d(next.getOkRegex(), "")) {
                    continue;
                } else {
                    le.m mVar = new le.m(next.getOkRegex());
                    if (z10 && mVar.k(next.getValue())) {
                        break;
                    }
                    z10 = false;
                }
            }
        }
        Z17Form$lambda$12(mutableState, true);
        if (z10) {
            LinkedHashMap linkedHashMap = new LinkedHashMap(rb.k.e(v0.e(va.x.y(snapshotStateList, 10)), 16));
            for (FormItemRequest formItemRequest : snapshotStateList) {
                Pair pairA = ua.z.a(formItemRequest.getId(), formItemRequest.getValue());
                linkedHashMap.put(pairA.getFirst(), pairA.getSecond());
            }
            function1.invoke(linkedHashMap);
        }
    }

    private static final void Z17Form$handleChange(SnapshotStateList<FormItemRequest> snapshotStateList, Function1 function1, int i10, FormItemRequest formItemRequest) {
        snapshotStateList.set(i10, formItemRequest);
        LinkedHashMap linkedHashMap = new LinkedHashMap(rb.k.e(v0.e(va.x.y(snapshotStateList, 10)), 16));
        for (FormItemRequest formItemRequest2 : snapshotStateList) {
            Pair pairA = ua.z.a(formItemRequest2.getId(), formItemRequest2.getValue());
            linkedHashMap.put(pairA.getFirst(), pairA.getSecond());
        }
        function1.invoke(linkedHashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String Z17Form$lambda$1$lambda$0(String it) {
        kotlin.jvm.internal.y.i(it, "it");
        return it;
    }

    private static final boolean Z17Form$lambda$11(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void Z17Form$lambda$12(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String Z17Form$lambda$38$clearImage(MutableState<ua.y> mutableState) {
        String str;
        ua.y yVarZ17Form$lambda$38$lambda$17 = Z17Form$lambda$38$lambda$17(mutableState);
        if (yVarZ17Form$lambda$38$lambda$17 == null || (str = (String) yVarZ17Form$lambda$38$lambda$17.h()) == null) {
            str = "";
        }
        mutableState.setValue(null);
        return str;
    }

    private static final void Z17Form$lambda$38$getImage(pe.m0 m0Var, MutableState<ua.y> mutableState, int i10) {
        pe.k.d(m0Var, null, null, new Z17FormKt$Z17Form$3$getImage$1(i10, mutableState, null), 3, null);
    }

    private static final ua.y Z17Form$lambda$38$lambda$17(MutableState<ua.y> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 Z17Form$lambda$38$lambda$31$lambda$30(final SnapshotStateList snapshotStateList, final Function1 function1, final pe.m0 m0Var, final MutableState mutableState, final MutableState mutableState2, final Function3 function3, final Function1 function2, LazyListScope LazyColumn) {
        kotlin.jvm.internal.y.i(LazyColumn, "$this$LazyColumn");
        LazyListScope.CC.o(LazyColumn, snapshotStateList.size(), new Function1() { // from class: cu.z17.views.form.b0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Z17FormKt.Z17Form$lambda$38$lambda$31$lambda$30$lambda$19(snapshotStateList, ((Integer) obj).intValue());
            }
        }, null, ComposableLambdaKt.composableLambdaInstance(1766261975, true, new lb.o() { // from class: cu.z17.views.form.c0
            @Override // lb.o
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return Z17FormKt.Z17Form$lambda$38$lambda$31$lambda$30$lambda$25(snapshotStateList, function1, m0Var, mutableState, mutableState2, (LazyItemScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 4, null);
        LazyListScope.CC.m(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(1900038478, true, new Function3() { // from class: cu.z17.views.form.d0
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return Z17FormKt.Z17Form$lambda$38$lambda$31$lambda$30$lambda$29(function3, function2, snapshotStateList, mutableState, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }), 3, null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object Z17Form$lambda$38$lambda$31$lambda$30$lambda$19(SnapshotStateList snapshotStateList, int i10) {
        return ((FormItemRequest) snapshotStateList.get(i10)).getId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 Z17Form$lambda$38$lambda$31$lambda$30$lambda$25(final SnapshotStateList snapshotStateList, final Function1 function1, final pe.m0 m0Var, final MutableState mutableState, final MutableState mutableState2, LazyItemScope items, final int i10, Composer composer, int i11) {
        int i12;
        kotlin.jvm.internal.y.i(items, "$this$items");
        if ((i11 & 6) == 0) {
            i12 = i11 | (composer.changed(items) ? 4 : 2);
        } else {
            i12 = i11;
        }
        if ((i11 & 48) == 0) {
            i12 |= composer.changed(i10) ? 32 : 16;
        }
        int i13 = i12;
        if (composer.shouldExecute((i13 & 147) != 146, i13 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1766261975, i13, -1, "cu.z17.views.form.Z17Form.<anonymous>.<anonymous>.<anonymous>.<anonymous> (Z17Form.kt:134)");
            }
            Pair pairA = null;
            boolean z10 = true;
            Modifier modifierM1727paddingVpY3zN4$default = PaddingKt.m1727paddingVpY3zN4$default(androidx.compose.foundation.lazy.g.c(items, Modifier.INSTANCE, null, null, null, 7, null), 0.0f, Dp.m8823constructorimpl(10), 1, null);
            FormItemRequest formItemRequest = (FormItemRequest) snapshotStateList.get(i10);
            boolean zZ17Form$lambda$11 = Z17Form$lambda$11(mutableState);
            int i14 = i13 & 112;
            boolean zChanged = composer.changed(function1) | (i14 == 32);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: cu.z17.views.form.e0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Z17FormKt.Z17Form$lambda$38$lambda$31$lambda$30$lambda$25$lambda$21$lambda$20(i10, snapshotStateList, function1, mutableState, (FormItemRequest) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            Function1 function2 = (Function1) objRememberedValue;
            ua.y yVarZ17Form$lambda$38$lambda$17 = Z17Form$lambda$38$lambda$17(mutableState2);
            if (yVarZ17Form$lambda$38$lambda$17 != null && ((Number) yVarZ17Form$lambda$38$lambda$17.f()).intValue() == i10) {
                ua.y yVarZ17Form$lambda$38$lambda$18 = Z17Form$lambda$38$lambda$17(mutableState2);
                if ((yVarZ17Form$lambda$38$lambda$18 != null ? (String) yVarZ17Form$lambda$38$lambda$18.h() : null) != null) {
                    ua.y yVarZ17Form$lambda$38$lambda$19 = Z17Form$lambda$38$lambda$17(mutableState2);
                    kotlin.jvm.internal.y.f(yVarZ17Form$lambda$38$lambda$19);
                    Object objF = yVarZ17Form$lambda$38$lambda$19.f();
                    ua.y yVarZ17Form$lambda$38$lambda$110 = Z17Form$lambda$38$lambda$17(mutableState2);
                    kotlin.jvm.internal.y.f(yVarZ17Form$lambda$38$lambda$110);
                    pairA = ua.z.a(objF, yVarZ17Form$lambda$38$lambda$110.h());
                }
            }
            boolean zChangedInstance = composer.changedInstance(m0Var);
            if (i14 != 32) {
                z10 = false;
            }
            boolean z11 = zChangedInstance | z10;
            Object objRememberedValue2 = composer.rememberedValue();
            if (z11 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new lb.a() { // from class: cu.z17.views.form.f0
                    @Override // lb.a
                    public final Object invoke() {
                        return Z17FormKt.Z17Form$lambda$38$lambda$31$lambda$30$lambda$25$lambda$23$lambda$22(i10, m0Var, mutableState2);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            lb.a aVar = (lb.a) objRememberedValue2;
            Object objRememberedValue3 = composer.rememberedValue();
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Z17FormKt$Z17Form$3$1$1$2$3$1(mutableState2);
                composer.updateRememberedValue(objRememberedValue3);
            }
            FormItemViewKt.FormItemView(modifierM1727paddingVpY3zN4$default, formItemRequest, zZ17Form$lambda$11, function2, pairA, aVar, (lb.a) objRememberedValue3, composer, 1572864, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 Z17Form$lambda$38$lambda$31$lambda$30$lambda$25$lambda$21$lambda$20(int i10, SnapshotStateList snapshotStateList, Function1 function1, MutableState mutableState, FormItemRequest upd) {
        kotlin.jvm.internal.y.i(upd, "upd");
        Z17Form$handleChange(snapshotStateList, function1, i10, upd);
        Z17Form$lambda$12(mutableState, false);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 Z17Form$lambda$38$lambda$31$lambda$30$lambda$25$lambda$23$lambda$22(int i10, pe.m0 m0Var, MutableState mutableState) {
        Z17Form$lambda$38$getImage(m0Var, mutableState, i10);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 Z17Form$lambda$38$lambda$31$lambda$30$lambda$29(Function3 function3, final Function1 function1, final SnapshotStateList snapshotStateList, final MutableState mutableState, LazyItemScope item, Composer composer, int i10) {
        kotlin.jvm.internal.y.i(item, "$this$item");
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1900038478, i10, -1, "cu.z17.views.form.Z17Form.<anonymous>.<anonymous>.<anonymous>.<anonymous> (Z17Form.kt:156)");
            }
            Modifier modifierM1727paddingVpY3zN4$default = PaddingKt.m1727paddingVpY3zN4$default(Modifier.INSTANCE, 0.0f, Dp.m8823constructorimpl(10), 1, null);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierM1727paddingVpY3zN4$default);
            ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
            lb.a constructor = companion.getConstructor();
            if (!defpackage.r.a(composer.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor);
            } else {
                composer.useNode();
            }
            Composer composerM5176constructorimpl = Updater.m5176constructorimpl(composer);
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, companion.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash = companion.getSetCompositeKeyHash();
            if (composerM5176constructorimpl.getInserting() || !kotlin.jvm.internal.y.d(composerM5176constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion.getSetModifier());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            boolean zChanged = composer.changed(function1);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new lb.a() { // from class: cu.z17.views.form.a0
                    @Override // lb.a
                    public final Object invoke() {
                        return Z17FormKt.Z17Form$lambda$38$lambda$31$lambda$30$lambda$29$lambda$28$lambda$27$lambda$26(snapshotStateList, function1, mutableState);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            function3.invoke(objRememberedValue, composer, 0);
            composer.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 Z17Form$lambda$38$lambda$31$lambda$30$lambda$29$lambda$28$lambda$27$lambda$26(SnapshotStateList snapshotStateList, Function1 function1, MutableState mutableState) {
        Z17Form$checkForm(snapshotStateList, function1, mutableState);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 Z17Form$lambda$38$lambda$33$lambda$32(MutableState mutableState) {
        mutableState.setValue(null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 Z17Form$lambda$38$lambda$35$lambda$34(MutableState mutableState, String it) {
        kotlin.jvm.internal.y.i(it, "it");
        ua.y yVarZ17Form$lambda$38$lambda$17 = Z17Form$lambda$38$lambda$17(mutableState);
        mutableState.setValue(yVarZ17Form$lambda$38$lambda$17 != null ? ua.y.e(yVarZ17Form$lambda$38$lambda$17, null, null, it, 3, null) : null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 Z17Form$lambda$38$lambda$37$lambda$36(MutableState mutableState) {
        Z17Form$lambda$5(mutableState, true);
        return ua.k0.f43947a;
    }

    private static final boolean Z17Form$lambda$4(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 Z17Form$lambda$40(Modifier modifier, List list, Function3 function3, Function1 function1, Function1 function2, Function1 function4, Z17FormConfigs z17FormConfigs, int i10, int i11, Composer composer, int i12) {
        Z17Form(modifier, list, function3, function1, function2, function4, z17FormConfigs, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return ua.k0.f43947a;
    }

    private static final void Z17Form$lambda$5(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Z17Form$lambda$7$lambda$6(SnapshotStateList snapshotStateList, List list) {
        return snapshotStateList.isEmpty() && !list.isEmpty();
    }

    private static final boolean Z17Form$lambda$8(State<Boolean> state) {
        return state.getValue().booleanValue();
    }
}
