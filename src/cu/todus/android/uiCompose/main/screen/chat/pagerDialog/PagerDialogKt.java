package cu.todus.android.uiCompose.main.screen.chat.pagerDialog;

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
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.LazyListStateKt;
import androidx.compose.foundation.pager.PagerKt;
import androidx.compose.foundation.pager.PagerScope;
import androidx.compose.foundation.pager.PagerState;
import androidx.compose.foundation.pager.PagerStateKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.focus.FocusRequesterModifierKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.window.AndroidDialog_androidKt;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.p001lifecycle.HasDefaultViewModelProviderFactory;
import androidx.p001lifecycle.Lifecycle;
import androidx.p001lifecycle.LifecycleOwner;
import androidx.p001lifecycle.ViewModelProvider;
import androidx.p001lifecycle.ViewModelStoreOwner;
import androidx.p001lifecycle.p002compose.FlowExtKt;
import androidx.p001lifecycle.viewmodel.CreationExtras;
import androidx.p001lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.p001lifecycle.viewmodel.compose.ViewModelKt;
import androidx.paging.compose.LazyPagingItems;
import androidx.profileinstaller.ProfileVerifier;
import cu.todus.android.R;
import cu.todus.android.data.db.pojo.Friend;
import cu.todus.android.data.db.pojo.content.TemplateContent;
import cu.todus.android.uiCompose.shared.userCommonList.UserCommonListKt;
import cu.z17.views.button.Z17ButtonsKt;
import cu.z17.views.dialogs.Z17DialogsKt;
import cu.z17.views.inputText.Z17InputTextKt;
import cu.z17.views.label.Z17LabelKt;
import cu.z17.views.pagerIndicator.Z17PagerIndicatorKt;
import cu.z17.views.utils.Z17MutableListFlow;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.y;
import kotlin.jvm.internal.z0;
import le.a0;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;
import pe.m0;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001ak\u0010\u0010\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\t\u001a\u00020\b2\u0018\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\n2\b\b\u0002\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\u000f\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u0010\u0010\u0011\u001aI\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\b2\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u00152\u0006\u0010\u0017\u001a\u00020\u000b2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\u0007¢\u0006\u0004\b\u0019\u0010\u001a¨\u0006\u001c²\u0006\u000e\u0010\u001b\u001a\u00020\u000b8\n@\nX\u008a\u008e\u0002"}, d2 = {"Lkotlin/Function0;", "Lua/k0;", "close", "Lcu/todus/android/uiCompose/main/screen/chat/pagerDialog/PagerDialogData;", "pagerDialogData", "Landroidx/paging/compose/LazyPagingItems;", "Lcu/todus/android/data/db/pojo/Friend;", "friends", "", "ownerId", "Lkotlin/Function2;", "", "completeAction", "completeActionText", "Lcu/todus/android/uiCompose/main/screen/chat/pagerDialog/PagerDialogViewModel;", "viewModel", "PagerDialog", "(Llb/a;Lcu/todus/android/uiCompose/main/screen/chat/pagerDialog/PagerDialogData;Landroidx/paging/compose/LazyPagingItems;Ljava/lang/String;Lkotlin/jvm/functions/Function2;Ljava/lang/String;Lcu/todus/android/uiCompose/main/screen/chat/pagerDialog/PagerDialogViewModel;Landroidx/compose/runtime/Composer;II)V", "Lcu/todus/android/data/db/pojo/content/TemplateContent;", "templateContent", "actualValue", "Lkotlin/Function1;", "onChange", "isCurrent", "onSelectContact", "DialogStep", "(Lcu/todus/android/data/db/pojo/content/TemplateContent;Ljava/lang/String;Lkotlin/jvm/functions/Function1;ZLlb/a;Landroidx/compose/runtime/Composer;I)V", "showContactSelection", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class PagerDialogKt {
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void DialogStep(final TemplateContent templateContent, final String actualValue, final Function1 onChange, final boolean z10, final lb.a onSelectContact, Composer composer, final int i10) {
        int i11;
        y.i(templateContent, "templateContent");
        y.i(actualValue, "actualValue");
        y.i(onChange, "onChange");
        y.i(onSelectContact, "onSelectContact");
        Composer composerStartRestartGroup = composer.startRestartGroup(-260861850);
        if ((i10 & 6) == 0) {
            i11 = (composerStartRestartGroup.changed(templateContent) ? 4 : 2) | i10;
        } else {
            i11 = i10;
        }
        if ((i10 & 48) == 0) {
            i11 |= composerStartRestartGroup.changed(actualValue) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(onChange) ? 256 : 128;
        }
        if ((i10 & 3072) == 0) {
            i11 |= composerStartRestartGroup.changed(z10) ? 2048 : 1024;
        }
        if ((i10 & 24576) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(onSelectContact) ? 16384 : 8192;
        }
        if (composerStartRestartGroup.shouldExecute((i11 & 9363) != 9362, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-260861850, i11, -1, "cu.todus.android.uiCompose.main.screen.chat.pagerDialog.DialogStep (PagerDialog.kt:237)");
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
                objRememberedValue = new FocusRequester();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final FocusRequester focusRequester = (FocusRequester) objRememberedValue;
            int i12 = i11;
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, templateContent.getTitle(), MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getLabelMedium(), 0L, 0, 0, composerStartRestartGroup, 0, 57);
            SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion, Dp.m8823constructorimpl(5)), composerStartRestartGroup, 6);
            ComposableLambda composableLambdaRememberComposableLambda = null;
            Modifier modifierFocusRequester = FocusRequesterModifierKt.focusRequester(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), focusRequester);
            int iM8499getDecimalPjHm6EE = (y.d(templateContent.getType(), "contact") || y.d(templateContent.getType(), TemplateContent.NUMBER_TYPE)) ? KeyboardType.INSTANCE.m8499getDecimalPjHm6EE() : KeyboardType.INSTANCE.m8505getTextPjHm6EE();
            String label = templateContent.getLabel();
            int minLines = templateContent.getMinLines() == 0 ? 1 : templateContent.getMinLines();
            int minLines2 = templateContent.getMinLines() == 0 ? 1 : templateContent.getMinLines();
            if (y.d(templateContent.getType(), "contact")) {
                composerStartRestartGroup.startReplaceGroup(1153765801);
                composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1407813527, true, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.pagerDialog.m
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return PagerDialogKt.DialogStep$lambda$0$1(onSelectContact, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(1154180301);
                composerStartRestartGroup.endReplaceGroup();
            }
            Z17InputTextKt.m10251Z17InputTextf9_u2OI(modifierFocusRequester, actualValue, minLines, minLines2, label, null, onChange, null, composableLambdaRememberComposableLambda, 0, iM8499getDecimalPjHm6EE, 0L, 0L, 0L, 0L, 0L, null, false, null, false, composerStartRestartGroup, (i12 & 112) | ((i12 << 12) & 3670016), 0, 1047200);
            composerStartRestartGroup = composerStartRestartGroup;
            boolean z11 = (i12 & 7168) == 2048;
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (z11 || objRememberedValue2 == companion3.getEmpty()) {
                objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.pagerDialog.n
                    @Override // lb.a
                    public final Object invoke() {
                        return PagerDialogKt.DialogStep$lambda$0$2$0(z10, focusRequester);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            EffectsKt.SideEffect((lb.a) objRememberedValue2, composerStartRestartGroup, 0);
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.pagerDialog.o
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PagerDialogKt.DialogStep$lambda$1(templateContent, actualValue, onChange, z10, onSelectContact, i10, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 DialogStep$lambda$0$1(final lb.a aVar, Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1407813527, i10, -1, "cu.todus.android.uiCompose.main.screen.chat.pagerDialog.DialogStep.<anonymous>.<anonymous> (PagerDialog.kt:255)");
            }
            boolean zChanged = composer.changed(aVar);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.pagerDialog.e
                    @Override // lb.a
                    public final Object invoke() {
                        return PagerDialogKt.DialogStep$lambda$0$1$0$0(aVar);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            IconButtonKt.IconButton((lb.a) objRememberedValue, null, false, null, null, null, ComposableSingletons$PagerDialogKt.INSTANCE.m9900getLambda$813633095$app_productionPFast(), composer, 1572864, 62);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 DialogStep$lambda$0$1$0$0(lb.a aVar) {
        aVar.invoke();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 DialogStep$lambda$0$2$0(boolean z10, FocusRequester focusRequester) {
        if (z10) {
            FocusRequester.m5530requestFocus3ESFkO8$default(focusRequester, 0, 1, null);
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 DialogStep$lambda$1(TemplateContent templateContent, String str, Function1 function1, boolean z10, lb.a aVar, int i10, Composer composer, int i11) {
        DialogStep(templateContent, str, function1, z10, aVar, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1));
        return k0.f43947a;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x015b  */
    /* JADX WARN: Code duplicated, block: B:103:0x0193  */
    /* JADX WARN: Code duplicated, block: B:106:0x019f  */
    /* JADX WARN: Code duplicated, block: B:107:0x01a3  */
    /* JADX WARN: Code duplicated, block: B:110:0x01df  */
    /* JADX WARN: Code duplicated, block: B:113:0x01f2  */
    /* JADX WARN: Code duplicated, block: B:114:0x01f4  */
    /* JADX WARN: Code duplicated, block: B:119:0x0201  */
    /* JADX WARN: Code duplicated, block: B:122:0x0226  */
    /* JADX WARN: Code duplicated, block: B:125:0x0237  */
    /* JADX WARN: Code duplicated, block: B:128:0x024c  */
    /* JADX WARN: Code duplicated, block: B:129:0x0251  */
    /* JADX WARN: Code duplicated, block: B:132:0x026c A[LOOP:0: B:131:0x026a->B:132:0x026c, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:143:0x02a3  */
    /* JADX WARN: Code duplicated, block: B:144:0x02a6  */
    /* JADX WARN: Code duplicated, block: B:149:0x02b8  */
    /* JADX WARN: Code duplicated, block: B:151:0x02eb  */
    /* JADX WARN: Code duplicated, block: B:154:0x02fc  */
    /* JADX WARN: Code duplicated, block: B:62:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:99:0x0153  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void PagerDialog(final lb.a close, final PagerDialogData pagerDialogData, final LazyPagingItems<Friend> friends, final String ownerId, final Function2 completeAction, String str, PagerDialogViewModel pagerDialogViewModel, Composer composer, final int i10, final int i11) {
        String strStringResource;
        Composer composer2;
        final PagerDialogViewModel pagerDialogViewModel2;
        final String str2;
        PagerDialogViewModel pagerDialogViewModel3;
        final String str3;
        lb.a constructor;
        Object objRememberedValue;
        Composer.Companion companion;
        boolean z10;
        Object objRememberedValue2;
        Composer composer3;
        Object objRememberedValue3;
        Z17MutableListFlow<String> stepsData;
        te.h value;
        int size;
        ArrayList arrayList;
        int i12;
        boolean z11;
        boolean z12;
        Object objRememberedValue4;
        int i13;
        final PagerDialogViewModel pagerDialogViewModel4 = pagerDialogViewModel;
        y.i(close, "close");
        y.i(friends, "friends");
        y.i(ownerId, "ownerId");
        y.i(completeAction, "completeAction");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1053535434);
        int i14 = (i10 & 6) == 0 ? (composerStartRestartGroup.changedInstance(close) ? 4 : 2) | i10 : i10;
        if ((i10 & 48) == 0) {
            i14 |= composerStartRestartGroup.changed(pagerDialogData) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i14 |= (i10 & 512) == 0 ? composerStartRestartGroup.changed(friends) : composerStartRestartGroup.changedInstance(friends) ? 256 : 128;
        }
        if ((i10 & 3072) == 0) {
            i14 |= composerStartRestartGroup.changed(ownerId) ? 2048 : 1024;
        }
        if ((i10 & 24576) == 0) {
            i14 |= composerStartRestartGroup.changedInstance(completeAction) ? 16384 : 8192;
        }
        if ((196608 & i10) == 0) {
            if ((i11 & 32) == 0) {
                strStringResource = str;
                int i15 = composerStartRestartGroup.changed(strStringResource) ? 131072 : 65536;
                i14 |= i15;
            } else {
                strStringResource = str;
            }
            i14 |= i15;
        } else {
            strStringResource = str;
        }
        if ((i10 & 1572864) == 0) {
            if ((i11 & 64) != 0) {
                i13 = 524288;
            } else if ((2097152 & i10) == 0 ? composerStartRestartGroup.changed(pagerDialogViewModel4) : composerStartRestartGroup.changedInstance(pagerDialogViewModel4)) {
                i13 = 1048576;
            } else {
                i13 = 524288;
            }
            i14 |= i13;
        }
        if (composerStartRestartGroup.shouldExecute((599187 & i14) != 599186, i14 & 1)) {
            composerStartRestartGroup.startDefaults();
            if ((i10 & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                if ((i11 & 32) != 0) {
                    strStringResource = StringResources_androidKt.stringResource(R.string.send, composerStartRestartGroup, 0);
                    i14 &= -458753;
                }
                if ((i11 & 64) != 0) {
                    ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composerStartRestartGroup, 6);
                    if (current == null) {
                        throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                    }
                    composer2 = composerStartRestartGroup;
                    pagerDialogViewModel4 = (PagerDialogViewModel) ViewModelKt.viewModel(z0.b(PagerDialogViewModel.class), current, (String) null, (ViewModelProvider.Factory) null, current instanceof HasDefaultViewModelProviderFactory ? ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras() : CreationExtras.Empty.INSTANCE, composerStartRestartGroup, 0, 0);
                    i14 &= -3670017;
                }
                composer2.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1053535434, i14, -1, "cu.todus.android.uiCompose.main.screen.chat.pagerDialog.PagerDialog (PagerDialog.kt:64)");
                }
                if (pagerDialogData != null) {
                    composer2.startReplaceGroup(1164750382);
                    Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getCenter(), false);
                    int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
                    CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer2, modifierFillMaxSize$default);
                    ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                    constructor = companion2.getConstructor();
                    if (!defpackage.r.a(composer2.getApplier())) {
                        ComposablesKt.invalidApplier();
                    }
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                        composer2.createNode(constructor);
                    } else {
                        composer2.useNode();
                    }
                    Composer composerM5176constructorimpl = Updater.m5176constructorimpl(composer2);
                    Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, companion2.getSetMeasurePolicy());
                    Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
                    Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion2.getSetCompositeKeyHash());
                    Updater.m5182reconcileimpl(composerM5176constructorimpl, companion2.getApplyOnDeactivatedNodeAssertion());
                    Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion2.getSetModifier());
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                    objRememberedValue = composer2.rememberedValue();
                    companion = Composer.INSTANCE;
                    if (objRememberedValue == companion.getEmpty()) {
                        objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                        composer2.updateRememberedValue(objRememberedValue);
                    }
                    final MutableState mutableState = (MutableState) objRememberedValue;
                    if ((i14 & 112) == 32) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    objRememberedValue2 = composer2.rememberedValue();
                    if (z10 || objRememberedValue2 == companion.getEmpty()) {
                        objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.pagerDialog.p
                            @Override // lb.a
                            public final Object invoke() {
                                return Integer.valueOf(PagerDialogKt.PagerDialog$lambda$0$3$0(pagerDialogData));
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue2);
                    }
                    composer3 = composer2;
                    final PagerState pagerStateRememberPagerState = PagerStateKt.rememberPagerState(0, 0.0f, (lb.a) objRememberedValue2, composer3, 6, 2);
                    objRememberedValue3 = composer3.rememberedValue();
                    if (objRememberedValue3 == companion.getEmpty()) {
                        objRememberedValue3 = EffectsKt.createCompositionCoroutineScope(ab.j.f643c, composer3);
                        composer3.updateRememberedValue(objRememberedValue3);
                    }
                    final m0 m0Var = (m0) objRememberedValue3;
                    if (pagerDialogViewModel4.getStepsData() == null) {
                        pagerDialogViewModel4.setInitSteps(pagerDialogData.getButtonTemplate().getMsgSteps().size());
                    }
                    stepsData = pagerDialogViewModel4.getStepsData();
                    if (stepsData != null) {
                        value = stepsData.getValue();
                    } else {
                        value = null;
                    }
                    y.f(value);
                    size = pagerDialogData.getButtonTemplate().getMsgSteps().size();
                    te.h hVar = value;
                    arrayList = new ArrayList(size);
                    for (i12 = 0; i12 < size; i12++) {
                        arrayList.add("");
                    }
                    final State stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(hVar, arrayList, (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composer3, 0, 14);
                    composer2 = composer3;
                    boolean z13 = (((3670016 & i14) ^ 1572864) <= 1048576 && composer2.changedInstance(pagerDialogViewModel4)) || (i14 & 1572864) == 1048576;
                    if ((i14 & 14) == 4) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    z12 = z13 | z11;
                    objRememberedValue4 = composer2.rememberedValue();
                    if (z12 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue4 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.pagerDialog.q
                            @Override // lb.a
                            public final Object invoke() {
                                return PagerDialogKt.PagerDialog$lambda$0$5$0(pagerDialogViewModel4, close);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue4);
                    }
                    str3 = strStringResource;
                    final PagerDialogViewModel pagerDialogViewModel5 = pagerDialogViewModel4;
                    pagerDialogViewModel3 = pagerDialogViewModel5;
                    AndroidDialog_androidKt.Dialog((lb.a) objRememberedValue4, null, ComposableLambdaKt.rememberComposableLambda(628698798, true, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.pagerDialog.r
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return PagerDialogKt.PagerDialog$lambda$0$6(pagerDialogData, pagerStateRememberPagerState, stateCollectAsStateWithLifecycle, pagerDialogViewModel5, mutableState, friends, ownerId, m0Var, completeAction, str3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composer2, 54), composer2, RendererCapabilities.DECODER_SUPPORT_MASK, 2);
                    composer2.endNode();
                    composer2.endReplaceGroup();
                } else {
                    pagerDialogViewModel3 = pagerDialogViewModel4;
                    str3 = strStringResource;
                    composer2.startReplaceGroup(1754219724);
                    composer2.endReplaceGroup();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                pagerDialogViewModel2 = pagerDialogViewModel3;
                str2 = str3;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i11 & 32) != 0) {
                    i14 &= -458753;
                }
                if ((i11 & 64) != 0) {
                    i14 &= -3670017;
                }
            }
            composer2 = composerStartRestartGroup;
            composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1053535434, i14, -1, "cu.todus.android.uiCompose.main.screen.chat.pagerDialog.PagerDialog (PagerDialog.kt:64)");
            }
            if (pagerDialogData != null) {
                composer2.startReplaceGroup(1164750382);
                Modifier modifierFillMaxSize$default2 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getCenter(), false);
                int iA2 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
                CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer2, modifierFillMaxSize$default2);
                ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
                constructor = companion3.getConstructor();
                if (!defpackage.r.a(composer2.getApplier())) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor);
                } else {
                    composer2.useNode();
                }
                Composer composerM5176constructorimpl2 = Updater.m5176constructorimpl(composer2);
                Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy2, companion3.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
                Updater.m5180initimpl(composerM5176constructorimpl2, Integer.valueOf(iA2), companion3.getSetCompositeKeyHash());
                Updater.m5182reconcileimpl(composerM5176constructorimpl2, companion3.getApplyOnDeactivatedNodeAssertion());
                Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier2, companion3.getSetModifier());
                BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                objRememberedValue = composer2.rememberedValue();
                companion = Composer.INSTANCE;
                if (objRememberedValue == companion.getEmpty()) {
                    objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                    composer2.updateRememberedValue(objRememberedValue);
                }
                final MutableState mutableState2 = (MutableState) objRememberedValue;
                if ((i14 & 112) == 32) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                objRememberedValue2 = composer2.rememberedValue();
                if (z10) {
                    objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.pagerDialog.p
                        @Override // lb.a
                        public final Object invoke() {
                            return Integer.valueOf(PagerDialogKt.PagerDialog$lambda$0$3$0(pagerDialogData));
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.pagerDialog.p
                        @Override // lb.a
                        public final Object invoke() {
                            return Integer.valueOf(PagerDialogKt.PagerDialog$lambda$0$3$0(pagerDialogData));
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue2);
                }
                composer3 = composer2;
                final PagerState pagerStateRememberPagerState2 = PagerStateKt.rememberPagerState(0, 0.0f, (lb.a) objRememberedValue2, composer3, 6, 2);
                objRememberedValue3 = composer3.rememberedValue();
                if (objRememberedValue3 == companion.getEmpty()) {
                    objRememberedValue3 = EffectsKt.createCompositionCoroutineScope(ab.j.f643c, composer3);
                    composer3.updateRememberedValue(objRememberedValue3);
                }
                final m0 m0Var2 = (m0) objRememberedValue3;
                if (pagerDialogViewModel4.getStepsData() == null) {
                    pagerDialogViewModel4.setInitSteps(pagerDialogData.getButtonTemplate().getMsgSteps().size());
                }
                stepsData = pagerDialogViewModel4.getStepsData();
                if (stepsData != null) {
                    value = stepsData.getValue();
                } else {
                    value = null;
                }
                y.f(value);
                size = pagerDialogData.getButtonTemplate().getMsgSteps().size();
                te.h hVar2 = value;
                arrayList = new ArrayList(size);
                while (i12 < size) {
                    arrayList.add("");
                }
                final State stateCollectAsStateWithLifecycle2 = FlowExtKt.collectAsStateWithLifecycle(hVar2, arrayList, (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composer3, 0, 14);
                composer2 = composer3;
                if (((3670016 & i14) ^ 1572864) <= 1048576) {
                }
                if ((i14 & 14) == 4) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                z12 = z13 | z11;
                objRememberedValue4 = composer2.rememberedValue();
                if (z12) {
                    objRememberedValue4 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.pagerDialog.q
                        @Override // lb.a
                        public final Object invoke() {
                            return PagerDialogKt.PagerDialog$lambda$0$5$0(pagerDialogViewModel4, close);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue4);
                } else {
                    objRememberedValue4 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.pagerDialog.q
                        @Override // lb.a
                        public final Object invoke() {
                            return PagerDialogKt.PagerDialog$lambda$0$5$0(pagerDialogViewModel4, close);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue4);
                }
                str3 = strStringResource;
                final PagerDialogViewModel pagerDialogViewModel6 = pagerDialogViewModel4;
                pagerDialogViewModel3 = pagerDialogViewModel6;
                AndroidDialog_androidKt.Dialog((lb.a) objRememberedValue4, null, ComposableLambdaKt.rememberComposableLambda(628698798, true, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.pagerDialog.r
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return PagerDialogKt.PagerDialog$lambda$0$6(pagerDialogData, pagerStateRememberPagerState2, stateCollectAsStateWithLifecycle2, pagerDialogViewModel6, mutableState2, friends, ownerId, m0Var2, completeAction, str3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composer2, 54), composer2, RendererCapabilities.DECODER_SUPPORT_MASK, 2);
                composer2.endNode();
                composer2.endReplaceGroup();
            } else {
                pagerDialogViewModel3 = pagerDialogViewModel4;
                str3 = strStringResource;
                composer2.startReplaceGroup(1754219724);
                composer2.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            pagerDialogViewModel2 = pagerDialogViewModel3;
            str2 = str3;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            pagerDialogViewModel2 = pagerDialogViewModel4;
            str2 = strStringResource;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.pagerDialog.s
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PagerDialogKt.PagerDialog$lambda$1(close, pagerDialogData, friends, ownerId, completeAction, str2, pagerDialogViewModel2, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final boolean PagerDialog$lambda$0$1(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void PagerDialog$lambda$0$2(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int PagerDialog$lambda$0$3$0(PagerDialogData pagerDialogData) {
        return pagerDialogData.getButtonTemplate().getMsgSteps().size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 PagerDialog$lambda$0$5$0(PagerDialogViewModel pagerDialogViewModel, lb.a aVar) {
        pagerDialogViewModel.close();
        aVar.invoke();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 PagerDialog$lambda$0$6(final PagerDialogData pagerDialogData, final PagerState pagerState, final State state, final PagerDialogViewModel pagerDialogViewModel, final MutableState mutableState, final LazyPagingItems lazyPagingItems, final String str, m0 m0Var, final Function2 function2, String str2, Composer composer, int i10) {
        final m0 m0Var2;
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(628698798, i10, -1, "cu.todus.android.uiCompose.main.screen.chat.pagerDialog.PagerDialog.<anonymous>.<anonymous> (PagerDialog.kt:92)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null);
            MaterialTheme materialTheme = MaterialTheme.INSTANCE;
            int i11 = MaterialTheme.$stable;
            float f10 = 10;
            Modifier modifierM1725padding3ABfNKs = PaddingKt.m1725padding3ABfNKs(BackgroundKt.m1204backgroundbw27NRU(modifierFillMaxWidth$default, materialTheme.getColorScheme(composer, i11).getBackground(), RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(15))), Dp.m8823constructorimpl(f10));
            Alignment.Companion companion2 = Alignment.INSTANCE;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion2.getTopStart(), false);
            int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierM1725padding3ABfNKs);
            ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
            lb.a constructor = companion3.getConstructor();
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
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion3.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl, companion3.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion3.getSetModifier());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            Arrangement arrangement = Arrangement.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(arrangement.getTop(), companion2.getStart(), composer, 0);
            int iA2 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer, companion);
            lb.a constructor2 = companion3.getConstructor();
            if (!defpackage.r.a(composer.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor2);
            } else {
                composer.useNode();
            }
            Composer composerM5176constructorimpl2 = Updater.m5176constructorimpl(composer);
            Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyColumnMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl2, Integer.valueOf(iA2), companion3.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl2, companion3.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier2, companion3.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            Z17LabelKt.m10262Z17LabelfWhpE4E(PaddingKt.m1729paddingqDBjuR0$default(companion, Dp.m8823constructorimpl(f10), 0.0f, 0.0f, 0.0f, 14, null), pagerDialogData.getTitle(), materialTheme.getTypography(composer, i11).getTitleLarge(), 0L, 0, 0, composer, 6, 56);
            SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion, Dp.m8823constructorimpl(f10)), composer, 6);
            PagerKt.m1961HorizontalPager8jOkeI(pagerState, SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), null, null, 0, 0.0f, null, null, false, false, null, null, null, null, ComposableLambdaKt.rememberComposableLambda(-1984416341, true, new lb.o() { // from class: cu.todus.android.uiCompose.main.screen.chat.pagerDialog.t
                @Override // lb.o
                public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    return PagerDialogKt.PagerDialog$lambda$0$6$0$0$0(pagerDialogData, state, pagerDialogViewModel, pagerState, mutableState, lazyPagingItems, str, (PagerScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
                }
            }, composer, 54), composer, 48, 24576, 16380);
            SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion, Dp.m8823constructorimpl(f10)), composer, 6);
            Modifier modifierFillMaxWidth$default2 = SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null);
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getCenter(), companion2.getCenterVertically(), composer, 54);
            int iA3 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap3 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composer, modifierFillMaxWidth$default2);
            lb.a constructor3 = companion3.getConstructor();
            if (!defpackage.r.a(composer.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor3);
            } else {
                composer.useNode();
            }
            Composer composerM5176constructorimpl3 = Updater.m5176constructorimpl(composer);
            Updater.m5184setimpl(composerM5176constructorimpl3, measurePolicyRowMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl3, currentCompositionLocalMap3, companion3.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl3, Integer.valueOf(iA3), companion3.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl3, companion3.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl3, modifierMaterializeModifier3, companion3.getSetModifier());
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            if (pagerState.getCurrentPage() != 0) {
                composer.startReplaceGroup(1197755317);
                m0Var2 = m0Var;
                boolean zChangedInstance = composer.changedInstance(m0Var2) | composer.changed(pagerState);
                Object objRememberedValue = composer.rememberedValue();
                if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.pagerDialog.u
                        @Override // lb.a
                        public final Object invoke() {
                            return PagerDialogKt.PagerDialog$lambda$0$6$0$0$1$0$0(m0Var2, pagerState);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                IconButtonKt.IconButton((lb.a) objRememberedValue, null, false, null, null, null, ComposableSingletons$PagerDialogKt.INSTANCE.m9899getLambda$492641465$app_productionPFast(), composer, 1572864, 62);
                composer.endReplaceGroup();
            } else {
                m0Var2 = m0Var;
                composer.startReplaceGroup(-1523884332);
                composer.endReplaceGroup();
            }
            Z17PagerIndicatorKt.m10266Z17PagerIndicatorD_W6g9U(pagerState, PaddingKt.m1725padding3ABfNKs(companion, Dp.m8823constructorimpl(8)), null, Color.INSTANCE.m5900getRed0d7_KjU(), 0L, 0.0f, 0.0f, 0.0f, null, composer, 3120, XMPPTCPConnection.PacketWriter.QUEUE_SIZE);
            if (pagerState.getCurrentPage() != pagerDialogData.getButtonTemplate().getMsgSteps().size() - 1) {
                composer.startReplaceGroup(1197779941);
                boolean zChangedInstance2 = composer.changedInstance(m0Var2) | composer.changed(pagerState);
                Object objRememberedValue2 = composer.rememberedValue();
                if (zChangedInstance2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.pagerDialog.v
                        @Override // lb.a
                        public final Object invoke() {
                            return PagerDialogKt.PagerDialog$lambda$0$6$0$0$1$1$0(m0Var2, pagerState);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue2);
                }
                IconButtonKt.IconButton((lb.a) objRememberedValue2, null, false, null, null, null, ComposableSingletons$PagerDialogKt.INSTANCE.m9901getLambda$90254850$app_productionPFast(), composer, 1572864, 62);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-1522989362);
                boolean zChanged = composer.changed(pagerDialogData) | composer.changed(state) | composer.changed(function2) | composer.changedInstance(pagerDialogViewModel);
                Object objRememberedValue3 = composer.rememberedValue();
                if (zChanged || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.pagerDialog.w
                        @Override // lb.a
                        public final Object invoke() {
                            return PagerDialogKt.PagerDialog$lambda$0$6$0$0$1$2$0(pagerDialogData, function2, pagerDialogViewModel, state);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue3);
                }
                Z17ButtonsKt.Z17SecondaryDialogButton(null, (lb.a) objRememberedValue3, str2, null, false, true, false, composer, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 89);
                composer.endReplaceGroup();
            }
            composer.endNode();
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
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 PagerDialog$lambda$0$6$0$0$0(PagerDialogData pagerDialogData, State state, final PagerDialogViewModel pagerDialogViewModel, PagerState pagerState, final MutableState mutableState, final LazyPagingItems lazyPagingItems, final String str, PagerScope HorizontalPager, final int i10, Composer composer, int i11) {
        y.i(HorizontalPager, "$this$HorizontalPager");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1984416341, i11, -1, "cu.todus.android.uiCompose.main.screen.chat.pagerDialog.PagerDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (PagerDialog.kt:115)");
        }
        TemplateContent templateContent = pagerDialogData.getButtonTemplate().getMsgSteps().get(i10);
        String str2 = (String) ((List) state.getValue()).get(i10);
        boolean z10 = false;
        boolean zChangedInstance = composer.changedInstance(pagerDialogViewModel) | ((((i11 & 112) ^ 48) > 32 && composer.changed(i10)) || (i11 & 48) == 32);
        Object objRememberedValue = composer.rememberedValue();
        if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.pagerDialog.x
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return PagerDialogKt.PagerDialog$lambda$0$6$0$0$0$0$0(pagerDialogViewModel, i10, (String) obj);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        Function1 function1 = (Function1) objRememberedValue;
        if (i10 == pagerState.getCurrentPage() && !pagerState.isScrollInProgress()) {
            z10 = true;
        }
        Object objRememberedValue2 = composer.rememberedValue();
        Composer.Companion companion = Composer.INSTANCE;
        if (objRememberedValue2 == companion.getEmpty()) {
            objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.pagerDialog.f
                @Override // lb.a
                public final Object invoke() {
                    return PagerDialogKt.PagerDialog$lambda$0$6$0$0$0$1$0(mutableState);
                }
            };
            composer.updateRememberedValue(objRememberedValue2);
        }
        DialogStep(templateContent, str2, function1, z10, (lb.a) objRememberedValue2, composer, 24576);
        boolean zPagerDialog$lambda$0$1 = PagerDialog$lambda$0$1(mutableState);
        Object objRememberedValue3 = composer.rememberedValue();
        if (objRememberedValue3 == companion.getEmpty()) {
            objRememberedValue3 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.pagerDialog.g
                @Override // lb.a
                public final Object invoke() {
                    return PagerDialogKt.PagerDialog$lambda$0$6$0$0$0$2$0(mutableState);
                }
            };
            composer.updateRememberedValue(objRememberedValue3);
        }
        Z17DialogsKt.Z17CustomDialog(zPagerDialog$lambda$0$1, (lb.a) objRememberedValue3, ComposableLambdaKt.rememberComposableLambda(-878838791, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.chat.pagerDialog.h
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return PagerDialogKt.PagerDialog$lambda$0$6$0$0$0$3(lazyPagingItems, pagerDialogViewModel, i10, str, (lb.a) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }, composer, 54), composer, 432);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 PagerDialog$lambda$0$6$0$0$0$0$0(PagerDialogViewModel pagerDialogViewModel, int i10, String newValue) {
        y.i(newValue, "newValue");
        Z17MutableListFlow<String> stepsData = pagerDialogViewModel.getStepsData();
        if (stepsData != null) {
            stepsData.change(newValue, i10);
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 PagerDialog$lambda$0$6$0$0$0$1$0(MutableState mutableState) {
        PagerDialog$lambda$0$2(mutableState, true);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 PagerDialog$lambda$0$6$0$0$0$2$0(MutableState mutableState) {
        PagerDialog$lambda$0$2(mutableState, false);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 PagerDialog$lambda$0$6$0$0$0$3(LazyPagingItems lazyPagingItems, final PagerDialogViewModel pagerDialogViewModel, final int i10, String str, final lb.a onClose, Composer composer, int i11) {
        int i12;
        y.i(onClose, "onClose");
        if ((i11 & 6) == 0) {
            i12 = i11 | (composer.changedInstance(onClose) ? 4 : 2);
        } else {
            i12 = i11;
        }
        if (composer.shouldExecute((i12 & 19) != 18, i12 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-878838791, i12, -1, "cu.todus.android.uiCompose.main.screen.chat.pagerDialog.PagerDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (PagerDialog.kt:132)");
            }
            LazyListState lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composer, 0, 3);
            Modifier.Companion companion = Modifier.INSTANCE;
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null);
            Arrangement.Vertical top = Arrangement.INSTANCE.getTop();
            Alignment.Companion companion2 = Alignment.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(top, companion2.getStart(), composer, 0);
            int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierFillMaxWidth$default);
            ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
            lb.a constructor = companion3.getConstructor();
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
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyColumnMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion3.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl, companion3.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion3.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            int i13 = i12 & 14;
            boolean z10 = i13 == 4;
            Object objRememberedValue = composer.rememberedValue();
            if (z10 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.pagerDialog.i
                    @Override // lb.a
                    public final Object invoke() {
                        return PagerDialogKt.PagerDialog$lambda$0$6$0$0$0$3$0$0$0(onClose);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            IconButtonKt.IconButton((lb.a) objRememberedValue, columnScopeInstance.align(PaddingKt.m1727paddingVpY3zN4$default(companion, Dp.m8823constructorimpl(20), 0.0f, 2, null), companion2.getEnd()), false, null, null, null, ComposableSingletons$PagerDialogKt.INSTANCE.m9898getLambda$1294825587$app_productionPFast(), composer, 1572864, 60);
            Modifier modifierM1755height3ABfNKs = SizeKt.m1755height3ABfNKs(companion, Dp.m8823constructorimpl(300));
            boolean zChangedInstance = composer.changedInstance(pagerDialogViewModel) | composer.changed(i10) | (i13 == 4);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.pagerDialog.j
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return PagerDialogKt.PagerDialog$lambda$0$6$0$0$0$3$0$1$0(pagerDialogViewModel, i10, onClose, (Friend) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            Function1 function1 = (Function1) objRememberedValue2;
            Object objRememberedValue3 = composer.rememberedValue();
            Composer.Companion companion4 = Composer.INSTANCE;
            if (objRememberedValue3 == companion4.getEmpty()) {
                objRememberedValue3 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.pagerDialog.k
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return PagerDialogKt.PagerDialog$lambda$0$6$0$0$0$3$0$2$0((Friend) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue3);
            }
            Function1 function2 = (Function1) objRememberedValue3;
            Object objRememberedValue4 = composer.rememberedValue();
            if (objRememberedValue4 == companion4.getEmpty()) {
                objRememberedValue4 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.pagerDialog.l
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return PagerDialogKt.PagerDialog$lambda$0$6$0$0$0$3$0$3$0((Friend) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue4);
            }
            UserCommonListKt.UserCommonList(modifierM1755height3ABfNKs, lazyListStateRememberLazyListState, lazyPagingItems, function1, function2, null, str, (Function1) objRememberedValue4, null, composer, (LazyPagingItems.$stable << 6) | 12607494, 288);
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
    public static final k0 PagerDialog$lambda$0$6$0$0$0$3$0$0$0(lb.a aVar) {
        aVar.invoke();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 PagerDialog$lambda$0$6$0$0$0$3$0$1$0(PagerDialogViewModel pagerDialogViewModel, int i10, lb.a aVar, Friend userCommon) {
        y.i(userCommon, "userCommon");
        Z17MutableListFlow<String> stepsData = pagerDialogViewModel.getStepsData();
        if (stepsData != null) {
            stepsData.change(userCommon.getContact().getPhone(), i10);
        }
        aVar.invoke();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 PagerDialog$lambda$0$6$0$0$0$3$0$2$0(Friend userCommon) {
        y.i(userCommon, "userCommon");
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String PagerDialog$lambda$0$6$0$0$0$3$0$3$0(Friend friend) {
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 PagerDialog$lambda$0$6$0$0$1$0$0(m0 m0Var, PagerState pagerState) {
        pe.k.d(m0Var, null, null, new PagerDialogKt$PagerDialog$1$2$1$1$2$1$1$1(pagerState, null), 3, null);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 PagerDialog$lambda$0$6$0$0$1$1$0(m0 m0Var, PagerState pagerState) {
        pe.k.d(m0Var, null, null, new PagerDialogKt$PagerDialog$1$2$1$1$2$2$1$1(pagerState, null), 3, null);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 PagerDialog$lambda$0$6$0$0$1$2$0(PagerDialogData pagerDialogData, Function2 function2, PagerDialogViewModel pagerDialogViewModel, State state) {
        String msgPlaceholder = pagerDialogData.getButtonTemplate().getMsgPlaceholder();
        String strO = msgPlaceholder;
        for (TemplateContent templateContent : pagerDialogData.getButtonTemplate().getMsgSteps()) {
            strO = a0.O(strO, "%" + templateContent.getStep() + "%", (String) ((List) state.getValue()).get(templateContent.getStep()), false, 4, null);
        }
        function2.invoke(strO, Boolean.valueOf(pagerDialogData.getAutoSend()));
        pagerDialogViewModel.close();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 PagerDialog$lambda$1(lb.a aVar, PagerDialogData pagerDialogData, LazyPagingItems lazyPagingItems, String str, Function2 function2, String str2, PagerDialogViewModel pagerDialogViewModel, int i10, int i11, Composer composer, int i12) {
        PagerDialog(aVar, pagerDialogData, lazyPagingItems, str, function2, str2, pagerDialogViewModel, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return k0.f43947a;
    }
}
