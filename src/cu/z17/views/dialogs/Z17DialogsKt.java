package cu.z17.views.dialogs;

import android.R;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.AndroidAlertDialog_androidKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.window.AndroidDialog_androidKt;
import androidx.media3.exoplayer.RendererCapabilities;
import cu.z17.views.button.Z17ButtonsKt;
import cu.z17.views.dialogs.Z17DialogsKt;
import cu.z17.views.label.Z17LabelKt;
import defpackage.r;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.y;
import lb.a;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001ag\u0010\f\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\f\u0010\r\u001ag\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\u000e\u0010\r\u001aD\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u001d\u0010\u0011\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00030\u000f¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"", "openDialog", "Lkotlin/Function0;", "Lua/k0;", "onClose", "yesAction", "noAction", "", "title", "description", "yes", "no", "Z17DialogWithActions", "(ZLlb/a;Llb/a;Llb/a;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)V", "Z17DialogWithActionsCustom", "Lkotlin/Function1;", "Landroidx/compose/runtime/Composable;", "content", "Z17CustomDialog", "(ZLlb/a;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "views_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class Z17DialogsKt {
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    public static final void Z17CustomDialog(final boolean z10, final a onClose, final Function3 content, Composer composer, final int i10) {
        int i11;
        y.i(onClose, "onClose");
        y.i(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1150851697);
        if ((i10 & 6) == 0) {
            i11 = (composerStartRestartGroup.changed(z10) ? 4 : 2) | i10;
        } else {
            i11 = i10;
        }
        if ((i10 & 48) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(onClose) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(content) ? 256 : 128;
        }
        if (composerStartRestartGroup.shouldExecute((i11 & 147) != 146, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1150851697, i11, -1, "cu.z17.views.dialogs.Z17CustomDialog (Z17Dialogs.kt:127)");
            }
            if (z10) {
                composerStartRestartGroup.startReplaceGroup(2133087447);
                boolean z11 = (i11 & 112) == 32;
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (z11 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new a() { // from class: c9.t
                        @Override // lb.a
                        public final Object invoke() {
                            return Z17DialogsKt.Z17CustomDialog$lambda$27$lambda$26(onClose);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                AndroidDialog_androidKt.Dialog((a) objRememberedValue, null, ComposableLambdaKt.rememberComposableLambda(1527956381, true, new Function2() { // from class: c9.u
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return Z17DialogsKt.Z17CustomDialog$lambda$31(content, onClose, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, RendererCapabilities.DECODER_SUPPORT_MASK, 2);
            } else {
                composerStartRestartGroup.startReplaceGroup(1697052627);
            }
            composerStartRestartGroup.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: c9.v
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return Z17DialogsKt.Z17CustomDialog$lambda$32(z10, onClose, content, i10, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 Z17CustomDialog$lambda$27$lambda$26(a aVar) {
        aVar.invoke();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 Z17CustomDialog$lambda$31(Function3 function3, final a aVar, Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1527956381, i10, -1, "cu.z17.views.dialogs.Z17CustomDialog.<anonymous> (Z17Dialogs.kt:134)");
            }
            Modifier modifierM1204backgroundbw27NRU = BackgroundKt.m1204backgroundbw27NRU(SizeKt.fillMaxWidth$default(WindowInsetsPadding_androidKt.safeContentPadding(Modifier.INSTANCE), 0.0f, 1, null), MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getBackground(), RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(15)));
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierM1204backgroundbw27NRU);
            ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
            a constructor = companion.getConstructor();
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
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, companion.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash = companion.getSetCompositeKeyHash();
            if (composerM5176constructorimpl.getInserting() || !y.d(composerM5176constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion.getSetModifier());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            boolean zChanged = composer.changed(aVar);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new a() { // from class: c9.c
                    @Override // lb.a
                    public final Object invoke() {
                        return Z17DialogsKt.Z17CustomDialog$lambda$31$lambda$30$lambda$29$lambda$28(aVar);
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
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 Z17CustomDialog$lambda$31$lambda$30$lambda$29$lambda$28(a aVar) {
        aVar.invoke();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 Z17CustomDialog$lambda$32(boolean z10, a aVar, Function3 function3, int i10, Composer composer, int i11) {
        Z17CustomDialog(z10, aVar, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1));
        return k0.f43947a;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x013c  */
    /* JADX WARN: Code duplicated, block: B:102:0x014a  */
    /* JADX WARN: Code duplicated, block: B:105:0x0156  */
    /* JADX WARN: Code duplicated, block: B:107:0x0161  */
    /* JADX WARN: Code duplicated, block: B:109:0x017f  */
    /* JADX WARN: Code duplicated, block: B:114:0x018f  */
    /* JADX WARN: Code duplicated, block: B:117:0x01f1  */
    /* JADX WARN: Code duplicated, block: B:120:0x0200  */
    /* JADX WARN: Code duplicated, block: B:122:0x0206  */
    /* JADX WARN: Code duplicated, block: B:125:0x0213  */
    /* JADX WARN: Code duplicated, block: B:127:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:37:0x007a  */
    /* JADX WARN: Code duplicated, block: B:39:0x0080  */
    /* JADX WARN: Code duplicated, block: B:40:0x0083  */
    /* JADX WARN: Code duplicated, block: B:44:0x008b  */
    /* JADX WARN: Code duplicated, block: B:46:0x0091  */
    /* JADX WARN: Code duplicated, block: B:47:0x0094  */
    /* JADX WARN: Code duplicated, block: B:51:0x009c  */
    /* JADX WARN: Code duplicated, block: B:53:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:55:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:56:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:59:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:62:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:64:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:66:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:67:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:70:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:73:0x00db  */
    /* JADX WARN: Code duplicated, block: B:74:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:77:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:89:0x010e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:90:0x0110  */
    /* JADX WARN: Code duplicated, block: B:92:0x011c  */
    /* JADX WARN: Code duplicated, block: B:94:0x0127  */
    /* JADX WARN: Code duplicated, block: B:97:0x012d  */
    /* JADX WARN: Code duplicated, block: B:98:0x0137  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void Z17DialogWithActions(final boolean z10, final a onClose, final a yesAction, a aVar, final String title, final String description, String str, String str2, Composer composer, final int i10, final int i11) {
        int i12;
        a aVar2;
        String str3;
        String str4;
        boolean z11;
        Composer composer2;
        final a aVar3;
        final String str5;
        final String str6;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        final a aVar4;
        String strStringResource;
        int i13;
        final String strStringResource2;
        Object objRememberedValue;
        boolean z12;
        Object objRememberedValue2;
        int i14;
        int i15;
        y.i(onClose, "onClose");
        y.i(yesAction, "yesAction");
        y.i(title, "title");
        y.i(description, "description");
        Composer composerStartRestartGroup = composer.startRestartGroup(-145698427);
        if ((i10 & 6) == 0) {
            i12 = (composerStartRestartGroup.changed(z10) ? 4 : 2) | i10;
        } else {
            i12 = i10;
        }
        if ((i10 & 48) == 0) {
            i12 |= composerStartRestartGroup.changedInstance(onClose) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i12 |= composerStartRestartGroup.changedInstance(yesAction) ? 256 : 128;
        }
        int i16 = i11 & 8;
        if (i16 == 0) {
            if ((i10 & 3072) == 0) {
                aVar2 = aVar;
                i12 |= composerStartRestartGroup.changedInstance(aVar2) ? 2048 : 1024;
            }
            if ((i10 & 24576) == 0) {
                if (composerStartRestartGroup.changed(title)) {
                    i15 = 16384;
                } else {
                    i15 = 8192;
                }
                i12 |= i15;
            }
            if ((196608 & i10) == 0) {
                if (composerStartRestartGroup.changed(description)) {
                    i14 = 131072;
                } else {
                    i14 = 65536;
                }
                i12 |= i14;
            }
            if ((1572864 & i10) == 0) {
                if ((i11 & 64) == 0) {
                    str3 = str;
                    int i17 = composerStartRestartGroup.changed(str3) ? 1048576 : 524288;
                    i12 |= i17;
                } else {
                    str3 = str;
                }
                i12 |= i17;
            } else {
                str3 = str;
            }
            if ((12582912 & i10) == 0) {
                if ((i11 & 128) == 0) {
                    str4 = str2;
                    int i18 = composerStartRestartGroup.changed(str4) ? 8388608 : 4194304;
                    i12 |= i18;
                } else {
                    str4 = str2;
                }
                i12 |= i18;
            } else {
                str4 = str2;
            }
            if ((4793491 & i12) != 4793490) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z11, i12 & 1)) {
                composerStartRestartGroup.startDefaults();
                if ((i10 & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    if (i16 != 0) {
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new a() { // from class: c9.a
                                @Override // lb.a
                                public final Object invoke() {
                                    return k0.f43947a;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        aVar4 = (a) objRememberedValue;
                    } else {
                        aVar4 = aVar2;
                    }
                    if ((i11 & 64) != 0) {
                        strStringResource = StringResources_androidKt.stringResource(R.string.ok, composerStartRestartGroup, 6);
                        i12 &= -3670017;
                    } else {
                        strStringResource = str3;
                    }
                    if ((i11 & 128) != 0) {
                        i13 = i12 & (-29360129);
                        str5 = strStringResource;
                        strStringResource2 = StringResources_androidKt.stringResource(R.string.cancel, composerStartRestartGroup, 6);
                    } else {
                        i13 = i12;
                        str5 = strStringResource;
                        strStringResource2 = str4;
                    }
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    if ((i11 & 64) != 0) {
                        i12 &= -3670017;
                    }
                    if ((i11 & 128) != 0) {
                        i12 &= -29360129;
                    }
                    aVar4 = aVar2;
                    strStringResource2 = str4;
                    i13 = i12;
                    str5 = str3;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-145698427, i13, -1, "cu.z17.views.dialogs.Z17DialogWithActions (Z17Dialogs.kt:28)");
                }
                if (z10) {
                    composerStartRestartGroup.startReplaceGroup(1710478491);
                    Modifier modifierSafeContentPadding = WindowInsetsPadding_androidKt.safeContentPadding(Modifier.INSTANCE);
                    long background = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground();
                    z12 = (i13 & 112) == 32;
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (z12 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = new a() { // from class: c9.l
                            @Override // lb.a
                            public final Object invoke() {
                                return Z17DialogsKt.Z17DialogWithActions$lambda$3$lambda$2(onClose);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    AndroidAlertDialog_androidKt.m2844AlertDialogOix01E0((a) objRememberedValue2, ComposableLambdaKt.rememberComposableLambda(335166552, true, new Function2() { // from class: c9.o
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return Z17DialogsKt.Z17DialogWithActions$lambda$6(yesAction, onClose, str5, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), modifierSafeContentPadding, ComposableLambdaKt.rememberComposableLambda(-354664938, true, new Function2() { // from class: c9.p
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return Z17DialogsKt.Z17DialogWithActions$lambda$9(onClose, aVar4, strStringResource2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), null, ComposableLambdaKt.rememberComposableLambda(-1044496428, true, new Function2() { // from class: c9.q
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return Z17DialogsKt.Z17DialogWithActions$lambda$10(title, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), ComposableLambdaKt.rememberComposableLambda(-1389412173, true, new Function2() { // from class: c9.r
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return Z17DialogsKt.Z17DialogWithActions$lambda$11(description, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), null, background, 0L, 0L, 0L, 0.0f, null, composerStartRestartGroup, 1772592, 0, 16016);
                    composer2 = composerStartRestartGroup;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.startReplaceGroup(1709371357);
                }
                composer2.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                aVar3 = aVar4;
                str6 = strStringResource2;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                aVar3 = aVar2;
                str5 = str3;
                str6 = str4;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: c9.s
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return Z17DialogsKt.Z17DialogWithActions$lambda$12(z10, onClose, yesAction, aVar3, title, description, str5, str6, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i12 |= 3072;
        aVar2 = aVar;
        if ((i10 & 24576) == 0) {
            if (composerStartRestartGroup.changed(title)) {
                i15 = 16384;
            } else {
                i15 = 8192;
            }
            i12 |= i15;
        }
        if ((196608 & i10) == 0) {
            if (composerStartRestartGroup.changed(description)) {
                i14 = 131072;
            } else {
                i14 = 65536;
            }
            i12 |= i14;
        }
        if ((1572864 & i10) == 0) {
            if ((i11 & 64) == 0) {
                str3 = str;
                if (composerStartRestartGroup.changed(str3)) {
                }
                i12 |= i17;
            } else {
                str3 = str;
            }
            i12 |= i17;
        } else {
            str3 = str;
        }
        if ((12582912 & i10) == 0) {
            if ((i11 & 128) == 0) {
                str4 = str2;
                if (composerStartRestartGroup.changed(str4)) {
                }
                i12 |= i18;
            } else {
                str4 = str2;
            }
            i12 |= i18;
        } else {
            str4 = str2;
        }
        if ((4793491 & i12) != 4793490) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z11, i12 & 1)) {
            composerStartRestartGroup.startDefaults();
            if ((i10 & 1) != 0) {
                if (i16 != 0) {
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new a() { // from class: c9.a
                            @Override // lb.a
                            public final Object invoke() {
                                return k0.f43947a;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    aVar4 = (a) objRememberedValue;
                } else {
                    aVar4 = aVar2;
                }
                if ((i11 & 64) != 0) {
                    strStringResource = StringResources_androidKt.stringResource(R.string.ok, composerStartRestartGroup, 6);
                    i12 &= -3670017;
                } else {
                    strStringResource = str3;
                }
                if ((i11 & 128) != 0) {
                    i13 = i12 & (-29360129);
                    str5 = strStringResource;
                    strStringResource2 = StringResources_androidKt.stringResource(R.string.cancel, composerStartRestartGroup, 6);
                } else {
                    i13 = i12;
                    str5 = strStringResource;
                    strStringResource2 = str4;
                }
            } else {
                if (i16 != 0) {
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new a() { // from class: c9.a
                            @Override // lb.a
                            public final Object invoke() {
                                return k0.f43947a;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    aVar4 = (a) objRememberedValue;
                } else {
                    aVar4 = aVar2;
                }
                if ((i11 & 64) != 0) {
                    strStringResource = StringResources_androidKt.stringResource(R.string.ok, composerStartRestartGroup, 6);
                    i12 &= -3670017;
                } else {
                    strStringResource = str3;
                }
                if ((i11 & 128) != 0) {
                    i13 = i12 & (-29360129);
                    str5 = strStringResource;
                    strStringResource2 = StringResources_androidKt.stringResource(R.string.cancel, composerStartRestartGroup, 6);
                } else {
                    i13 = i12;
                    str5 = strStringResource;
                    strStringResource2 = str4;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-145698427, i13, -1, "cu.z17.views.dialogs.Z17DialogWithActions (Z17Dialogs.kt:28)");
            }
            if (z10) {
                composerStartRestartGroup.startReplaceGroup(1710478491);
                Modifier modifierSafeContentPadding2 = WindowInsetsPadding_androidKt.safeContentPadding(Modifier.INSTANCE);
                long background2 = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground();
                if ((i13 & 112) == 32) {
                }
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (z12) {
                    objRememberedValue2 = new a() { // from class: c9.l
                        @Override // lb.a
                        public final Object invoke() {
                            return Z17DialogsKt.Z17DialogWithActions$lambda$3$lambda$2(onClose);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new a() { // from class: c9.l
                        @Override // lb.a
                        public final Object invoke() {
                            return Z17DialogsKt.Z17DialogWithActions$lambda$3$lambda$2(onClose);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                AndroidAlertDialog_androidKt.m2844AlertDialogOix01E0((a) objRememberedValue2, ComposableLambdaKt.rememberComposableLambda(335166552, true, new Function2() { // from class: c9.o
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return Z17DialogsKt.Z17DialogWithActions$lambda$6(yesAction, onClose, str5, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), modifierSafeContentPadding2, ComposableLambdaKt.rememberComposableLambda(-354664938, true, new Function2() { // from class: c9.p
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return Z17DialogsKt.Z17DialogWithActions$lambda$9(onClose, aVar4, strStringResource2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), null, ComposableLambdaKt.rememberComposableLambda(-1044496428, true, new Function2() { // from class: c9.q
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return Z17DialogsKt.Z17DialogWithActions$lambda$10(title, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), ComposableLambdaKt.rememberComposableLambda(-1389412173, true, new Function2() { // from class: c9.r
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return Z17DialogsKt.Z17DialogWithActions$lambda$11(description, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), null, background2, 0L, 0L, 0L, 0.0f, null, composerStartRestartGroup, 1772592, 0, 16016);
                composer2 = composerStartRestartGroup;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.startReplaceGroup(1709371357);
            }
            composer2.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            aVar3 = aVar4;
            str6 = strStringResource2;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            aVar3 = aVar2;
            str5 = str3;
            str6 = str4;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: c9.s
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return Z17DialogsKt.Z17DialogWithActions$lambda$12(z10, onClose, yesAction, aVar3, title, description, str5, str6, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 Z17DialogWithActions$lambda$10(String str, Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1044496428, i10, -1, "cu.z17.views.dialogs.Z17DialogWithActions.<anonymous> (Z17Dialogs.kt:40)");
            }
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, str, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getTitleMedium(), 0L, 0, 0, composer, 0, 57);
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
    public static final k0 Z17DialogWithActions$lambda$11(String str, Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1389412173, i10, -1, "cu.z17.views.dialogs.Z17DialogWithActions.<anonymous> (Z17Dialogs.kt:46)");
            }
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, str, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getBodyMedium(), 0L, 0, 0, composer, 0, 57);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 Z17DialogWithActions$lambda$12(boolean z10, a aVar, a aVar2, a aVar3, String str, String str2, String str3, String str4, int i10, int i11, Composer composer, int i12) {
        Z17DialogWithActions(z10, aVar, aVar2, aVar3, str, str2, str3, str4, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 Z17DialogWithActions$lambda$3$lambda$2(a aVar) {
        aVar.invoke();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 Z17DialogWithActions$lambda$6(final a aVar, final a aVar2, String str, Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(335166552, i10, -1, "cu.z17.views.dialogs.Z17DialogWithActions.<anonymous> (Z17Dialogs.kt:52)");
            }
            boolean zChanged = composer.changed(aVar) | composer.changed(aVar2);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new a() { // from class: c9.m
                    @Override // lb.a
                    public final Object invoke() {
                        return Z17DialogsKt.Z17DialogWithActions$lambda$6$lambda$5$lambda$4(aVar, aVar2);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            Z17ButtonsKt.Z17PrimaryDialogButton(null, (a) objRememberedValue, str, null, false, false, false, composer, 0, 121);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 Z17DialogWithActions$lambda$6$lambda$5$lambda$4(a aVar, a aVar2) {
        aVar.invoke();
        aVar2.invoke();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 Z17DialogWithActions$lambda$9(final a aVar, final a aVar2, String str, Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-354664938, i10, -1, "cu.z17.views.dialogs.Z17DialogWithActions.<anonymous> (Z17Dialogs.kt:60)");
            }
            boolean zChanged = composer.changed(aVar) | composer.changed(aVar2);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new a() { // from class: c9.d
                    @Override // lb.a
                    public final Object invoke() {
                        return Z17DialogsKt.Z17DialogWithActions$lambda$9$lambda$8$lambda$7(aVar, aVar2);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            Z17ButtonsKt.Z17SecondaryDialogButton(null, (a) objRememberedValue, str, null, false, false, false, composer, 0, 121);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 Z17DialogWithActions$lambda$9$lambda$8$lambda$7(a aVar, a aVar2) {
        aVar.invoke();
        aVar2.invoke();
        return k0.f43947a;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x013c  */
    /* JADX WARN: Code duplicated, block: B:102:0x014a  */
    /* JADX WARN: Code duplicated, block: B:105:0x0156  */
    /* JADX WARN: Code duplicated, block: B:107:0x0161  */
    /* JADX WARN: Code duplicated, block: B:109:0x017f  */
    /* JADX WARN: Code duplicated, block: B:114:0x018f  */
    /* JADX WARN: Code duplicated, block: B:117:0x01f1  */
    /* JADX WARN: Code duplicated, block: B:120:0x0200  */
    /* JADX WARN: Code duplicated, block: B:122:0x0206  */
    /* JADX WARN: Code duplicated, block: B:125:0x0213  */
    /* JADX WARN: Code duplicated, block: B:127:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:37:0x007a  */
    /* JADX WARN: Code duplicated, block: B:39:0x0080  */
    /* JADX WARN: Code duplicated, block: B:40:0x0083  */
    /* JADX WARN: Code duplicated, block: B:44:0x008b  */
    /* JADX WARN: Code duplicated, block: B:46:0x0091  */
    /* JADX WARN: Code duplicated, block: B:47:0x0094  */
    /* JADX WARN: Code duplicated, block: B:51:0x009c  */
    /* JADX WARN: Code duplicated, block: B:53:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:55:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:56:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:59:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:62:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:64:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:66:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:67:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:70:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:73:0x00db  */
    /* JADX WARN: Code duplicated, block: B:74:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:77:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:89:0x010e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:90:0x0110  */
    /* JADX WARN: Code duplicated, block: B:92:0x011c  */
    /* JADX WARN: Code duplicated, block: B:94:0x0127  */
    /* JADX WARN: Code duplicated, block: B:97:0x012d  */
    /* JADX WARN: Code duplicated, block: B:98:0x0137  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void Z17DialogWithActionsCustom(final boolean z10, final a onClose, final a yesAction, a aVar, final String title, final String description, String str, String str2, Composer composer, final int i10, final int i11) {
        int i12;
        a aVar2;
        String str3;
        String str4;
        boolean z11;
        Composer composer2;
        final a aVar3;
        final String str5;
        final String str6;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        final a aVar4;
        String strStringResource;
        int i13;
        final String strStringResource2;
        Object objRememberedValue;
        boolean z12;
        Object objRememberedValue2;
        int i14;
        int i15;
        y.i(onClose, "onClose");
        y.i(yesAction, "yesAction");
        y.i(title, "title");
        y.i(description, "description");
        Composer composerStartRestartGroup = composer.startRestartGroup(-961264620);
        if ((i10 & 6) == 0) {
            i12 = (composerStartRestartGroup.changed(z10) ? 4 : 2) | i10;
        } else {
            i12 = i10;
        }
        if ((i10 & 48) == 0) {
            i12 |= composerStartRestartGroup.changedInstance(onClose) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i12 |= composerStartRestartGroup.changedInstance(yesAction) ? 256 : 128;
        }
        int i16 = i11 & 8;
        if (i16 == 0) {
            if ((i10 & 3072) == 0) {
                aVar2 = aVar;
                i12 |= composerStartRestartGroup.changedInstance(aVar2) ? 2048 : 1024;
            }
            if ((i10 & 24576) == 0) {
                if (composerStartRestartGroup.changed(title)) {
                    i15 = 16384;
                } else {
                    i15 = 8192;
                }
                i12 |= i15;
            }
            if ((196608 & i10) == 0) {
                if (composerStartRestartGroup.changed(description)) {
                    i14 = 131072;
                } else {
                    i14 = 65536;
                }
                i12 |= i14;
            }
            if ((1572864 & i10) == 0) {
                if ((i11 & 64) == 0) {
                    str3 = str;
                    int i17 = composerStartRestartGroup.changed(str3) ? 1048576 : 524288;
                    i12 |= i17;
                } else {
                    str3 = str;
                }
                i12 |= i17;
            } else {
                str3 = str;
            }
            if ((12582912 & i10) == 0) {
                if ((i11 & 128) == 0) {
                    str4 = str2;
                    int i18 = composerStartRestartGroup.changed(str4) ? 8388608 : 4194304;
                    i12 |= i18;
                } else {
                    str4 = str2;
                }
                i12 |= i18;
            } else {
                str4 = str2;
            }
            if ((4793491 & i12) != 4793490) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z11, i12 & 1)) {
                composerStartRestartGroup.startDefaults();
                if ((i10 & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    if (i16 != 0) {
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new a() { // from class: c9.e
                                @Override // lb.a
                                public final Object invoke() {
                                    return k0.f43947a;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        aVar4 = (a) objRememberedValue;
                    } else {
                        aVar4 = aVar2;
                    }
                    if ((i11 & 64) != 0) {
                        strStringResource = StringResources_androidKt.stringResource(R.string.ok, composerStartRestartGroup, 6);
                        i12 &= -3670017;
                    } else {
                        strStringResource = str3;
                    }
                    if ((i11 & 128) != 0) {
                        i13 = i12 & (-29360129);
                        str5 = strStringResource;
                        strStringResource2 = StringResources_androidKt.stringResource(R.string.cancel, composerStartRestartGroup, 6);
                    } else {
                        i13 = i12;
                        str5 = strStringResource;
                        strStringResource2 = str4;
                    }
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    if ((i11 & 64) != 0) {
                        i12 &= -3670017;
                    }
                    if ((i11 & 128) != 0) {
                        i12 &= -29360129;
                    }
                    aVar4 = aVar2;
                    strStringResource2 = str4;
                    i13 = i12;
                    str5 = str3;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-961264620, i13, -1, "cu.z17.views.dialogs.Z17DialogWithActionsCustom (Z17Dialogs.kt:80)");
                }
                if (z10) {
                    composerStartRestartGroup.startReplaceGroup(1808022252);
                    Modifier modifierSafeContentPadding = WindowInsetsPadding_androidKt.safeContentPadding(Modifier.INSTANCE);
                    long background = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground();
                    z12 = (i13 & 112) == 32;
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (z12 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = new a() { // from class: c9.f
                            @Override // lb.a
                            public final Object invoke() {
                                return Z17DialogsKt.Z17DialogWithActionsCustom$lambda$16$lambda$15(onClose);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    AndroidAlertDialog_androidKt.m2844AlertDialogOix01E0((a) objRememberedValue2, ComposableLambdaKt.rememberComposableLambda(-286718809, true, new Function2() { // from class: c9.g
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return Z17DialogsKt.Z17DialogWithActionsCustom$lambda$19(yesAction, onClose, str5, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), modifierSafeContentPadding, ComposableLambdaKt.rememberComposableLambda(-1117372443, true, new Function2() { // from class: c9.h
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return Z17DialogsKt.Z17DialogWithActionsCustom$lambda$22(aVar4, onClose, strStringResource2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), null, ComposableLambdaKt.rememberComposableLambda(-1948026077, true, new Function2() { // from class: c9.i
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return Z17DialogsKt.Z17DialogWithActionsCustom$lambda$23(title, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), ComposableLambdaKt.rememberComposableLambda(1931614402, true, new Function2() { // from class: c9.j
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return Z17DialogsKt.Z17DialogWithActionsCustom$lambda$24(description, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), null, background, 0L, 0L, 0L, 0.0f, null, composerStartRestartGroup, 1772592, 0, 16016);
                    composer2 = composerStartRestartGroup;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.startReplaceGroup(1805292206);
                }
                composer2.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                aVar3 = aVar4;
                str6 = strStringResource2;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                aVar3 = aVar2;
                str5 = str3;
                str6 = str4;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: c9.k
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return Z17DialogsKt.Z17DialogWithActionsCustom$lambda$25(z10, onClose, yesAction, aVar3, title, description, str5, str6, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i12 |= 3072;
        aVar2 = aVar;
        if ((i10 & 24576) == 0) {
            if (composerStartRestartGroup.changed(title)) {
                i15 = 16384;
            } else {
                i15 = 8192;
            }
            i12 |= i15;
        }
        if ((196608 & i10) == 0) {
            if (composerStartRestartGroup.changed(description)) {
                i14 = 131072;
            } else {
                i14 = 65536;
            }
            i12 |= i14;
        }
        if ((1572864 & i10) == 0) {
            if ((i11 & 64) == 0) {
                str3 = str;
                if (composerStartRestartGroup.changed(str3)) {
                }
                i12 |= i17;
            } else {
                str3 = str;
            }
            i12 |= i17;
        } else {
            str3 = str;
        }
        if ((12582912 & i10) == 0) {
            if ((i11 & 128) == 0) {
                str4 = str2;
                if (composerStartRestartGroup.changed(str4)) {
                }
                i12 |= i18;
            } else {
                str4 = str2;
            }
            i12 |= i18;
        } else {
            str4 = str2;
        }
        if ((4793491 & i12) != 4793490) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z11, i12 & 1)) {
            composerStartRestartGroup.startDefaults();
            if ((i10 & 1) != 0) {
                if (i16 != 0) {
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new a() { // from class: c9.e
                            @Override // lb.a
                            public final Object invoke() {
                                return k0.f43947a;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    aVar4 = (a) objRememberedValue;
                } else {
                    aVar4 = aVar2;
                }
                if ((i11 & 64) != 0) {
                    strStringResource = StringResources_androidKt.stringResource(R.string.ok, composerStartRestartGroup, 6);
                    i12 &= -3670017;
                } else {
                    strStringResource = str3;
                }
                if ((i11 & 128) != 0) {
                    i13 = i12 & (-29360129);
                    str5 = strStringResource;
                    strStringResource2 = StringResources_androidKt.stringResource(R.string.cancel, composerStartRestartGroup, 6);
                } else {
                    i13 = i12;
                    str5 = strStringResource;
                    strStringResource2 = str4;
                }
            } else {
                if (i16 != 0) {
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new a() { // from class: c9.e
                            @Override // lb.a
                            public final Object invoke() {
                                return k0.f43947a;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    aVar4 = (a) objRememberedValue;
                } else {
                    aVar4 = aVar2;
                }
                if ((i11 & 64) != 0) {
                    strStringResource = StringResources_androidKt.stringResource(R.string.ok, composerStartRestartGroup, 6);
                    i12 &= -3670017;
                } else {
                    strStringResource = str3;
                }
                if ((i11 & 128) != 0) {
                    i13 = i12 & (-29360129);
                    str5 = strStringResource;
                    strStringResource2 = StringResources_androidKt.stringResource(R.string.cancel, composerStartRestartGroup, 6);
                } else {
                    i13 = i12;
                    str5 = strStringResource;
                    strStringResource2 = str4;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-961264620, i13, -1, "cu.z17.views.dialogs.Z17DialogWithActionsCustom (Z17Dialogs.kt:80)");
            }
            if (z10) {
                composerStartRestartGroup.startReplaceGroup(1808022252);
                Modifier modifierSafeContentPadding2 = WindowInsetsPadding_androidKt.safeContentPadding(Modifier.INSTANCE);
                long background2 = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground();
                if ((i13 & 112) == 32) {
                }
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (z12) {
                    objRememberedValue2 = new a() { // from class: c9.f
                        @Override // lb.a
                        public final Object invoke() {
                            return Z17DialogsKt.Z17DialogWithActionsCustom$lambda$16$lambda$15(onClose);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new a() { // from class: c9.f
                        @Override // lb.a
                        public final Object invoke() {
                            return Z17DialogsKt.Z17DialogWithActionsCustom$lambda$16$lambda$15(onClose);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                AndroidAlertDialog_androidKt.m2844AlertDialogOix01E0((a) objRememberedValue2, ComposableLambdaKt.rememberComposableLambda(-286718809, true, new Function2() { // from class: c9.g
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return Z17DialogsKt.Z17DialogWithActionsCustom$lambda$19(yesAction, onClose, str5, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), modifierSafeContentPadding2, ComposableLambdaKt.rememberComposableLambda(-1117372443, true, new Function2() { // from class: c9.h
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return Z17DialogsKt.Z17DialogWithActionsCustom$lambda$22(aVar4, onClose, strStringResource2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), null, ComposableLambdaKt.rememberComposableLambda(-1948026077, true, new Function2() { // from class: c9.i
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return Z17DialogsKt.Z17DialogWithActionsCustom$lambda$23(title, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), ComposableLambdaKt.rememberComposableLambda(1931614402, true, new Function2() { // from class: c9.j
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return Z17DialogsKt.Z17DialogWithActionsCustom$lambda$24(description, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), null, background2, 0L, 0L, 0L, 0.0f, null, composerStartRestartGroup, 1772592, 0, 16016);
                composer2 = composerStartRestartGroup;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.startReplaceGroup(1805292206);
            }
            composer2.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            aVar3 = aVar4;
            str6 = strStringResource2;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            aVar3 = aVar2;
            str5 = str3;
            str6 = str4;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: c9.k
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return Z17DialogsKt.Z17DialogWithActionsCustom$lambda$25(z10, onClose, yesAction, aVar3, title, description, str5, str6, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 Z17DialogWithActionsCustom$lambda$16$lambda$15(a aVar) {
        aVar.invoke();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 Z17DialogWithActionsCustom$lambda$19(final a aVar, final a aVar2, String str, Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-286718809, i10, -1, "cu.z17.views.dialogs.Z17DialogWithActionsCustom.<anonymous> (Z17Dialogs.kt:104)");
            }
            boolean zChanged = composer.changed(aVar) | composer.changed(aVar2);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new a() { // from class: c9.b
                    @Override // lb.a
                    public final Object invoke() {
                        return Z17DialogsKt.Z17DialogWithActionsCustom$lambda$19$lambda$18$lambda$17(aVar, aVar2);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            Z17ButtonsKt.Z17PrimaryDialogButton(null, (a) objRememberedValue, str, null, false, false, false, composer, 0, 121);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 Z17DialogWithActionsCustom$lambda$19$lambda$18$lambda$17(a aVar, a aVar2) {
        aVar.invoke();
        aVar2.invoke();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 Z17DialogWithActionsCustom$lambda$22(final a aVar, final a aVar2, String str, Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1117372443, i10, -1, "cu.z17.views.dialogs.Z17DialogWithActionsCustom.<anonymous> (Z17Dialogs.kt:112)");
            }
            boolean zChanged = composer.changed(aVar) | composer.changed(aVar2);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new a() { // from class: c9.n
                    @Override // lb.a
                    public final Object invoke() {
                        return Z17DialogsKt.Z17DialogWithActionsCustom$lambda$22$lambda$21$lambda$20(aVar, aVar2);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            Z17ButtonsKt.Z17SecondaryDialogButton(null, (a) objRememberedValue, str, null, false, false, false, composer, 0, 121);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 Z17DialogWithActionsCustom$lambda$22$lambda$21$lambda$20(a aVar, a aVar2) {
        aVar.invoke();
        aVar2.invoke();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 Z17DialogWithActionsCustom$lambda$23(String str, Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1948026077, i10, -1, "cu.z17.views.dialogs.Z17DialogWithActionsCustom.<anonymous> (Z17Dialogs.kt:92)");
            }
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, str, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getTitleMedium(), 0L, 0, 0, composer, 0, 57);
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
    public static final k0 Z17DialogWithActionsCustom$lambda$24(String str, Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1931614402, i10, -1, "cu.z17.views.dialogs.Z17DialogWithActionsCustom.<anonymous> (Z17Dialogs.kt:98)");
            }
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, str, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getBodyMedium(), 0L, 0, 0, composer, 0, 57);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 Z17DialogWithActionsCustom$lambda$25(boolean z10, a aVar, a aVar2, a aVar3, String str, String str2, String str3, String str4, int i10, int i11, Composer composer, int i12) {
        Z17DialogWithActionsCustom(z10, aVar, aVar2, aVar3, str, str2, str3, str4, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return k0.f43947a;
    }
}
