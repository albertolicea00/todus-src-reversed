package cu.todus.android.uiCompose.main.screen.chat.details;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
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
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.window.AndroidDialog_androidKt;
import androidx.media3.exoplayer.RendererCapabilities;
import cu.todus.android.data.db.pojo.Friend;
import cu.todus.android.data.db.pojo.content.TemplateContent;
import cu.todus.android.data.util.MediaUtil;
import cu.todus.android.di.MainModule;
import cu.todus.android.uiCompose.main.screen.chat.component.ChatParams;
import cu.todus.android.uiCompose.navigation.NavLinks;
import cu.todus.android.utils.IntentUtil;
import cu.z17.views.label.Z17LabelKt;
import cu.z17.views.permission.PermissionNeedIt;
import cu.z17.views.permission.PermissionsRequesterState;
import cu.z17.views.permission.PermissionsResult;
import cu.z17.views.permission.Z17PermissionRequesterKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a9\u0010\b\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u0005H\u0007¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcu/todus/android/data/db/pojo/Friend;", "friend", "Lkotlin/Function0;", "Lua/k0;", "handleClose", "Lkotlin/Function1;", "", "navigateTo", "DetailsDialogForContactCard", "(Lcu/todus/android/data/db/pojo/Friend;Llb/a;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class DetailsDialogForContactCardKt {
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void DetailsDialogForContactCard(final Friend friend, final lb.a aVar, final Function1 navigateTo, Composer composer, final int i10) {
        int i11;
        final Friend friend2;
        final Function1 function1;
        Composer composer2;
        final lb.a handleClose = aVar;
        kotlin.jvm.internal.y.i(friend, "friend");
        kotlin.jvm.internal.y.i(handleClose, "handleClose");
        kotlin.jvm.internal.y.i(navigateTo, "navigateTo");
        Composer composerStartRestartGroup = composer.startRestartGroup(171167348);
        if ((i10 & 6) == 0) {
            i11 = (composerStartRestartGroup.changed(friend) ? 4 : 2) | i10;
        } else {
            i11 = i10;
        }
        if ((i10 & 48) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(handleClose) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(navigateTo) ? 256 : 128;
        }
        int i12 = i11;
        if (composerStartRestartGroup.shouldExecute((i12 & 147) != 146, i12 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(171167348, i12, -1, "cu.todus.android.uiCompose.main.screen.chat.details.DetailsDialogForContactCard (DetailsDialogForContactCard.kt:48)");
            }
            final Context context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (objRememberedValue == companion.getEmpty()) {
                Object systemService = context.getSystemService("clipboard");
                kotlin.jvm.internal.y.g(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
                objRememberedValue = (ClipboardManager) systemService;
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final ClipboardManager clipboardManager = (ClipboardManager) objRememberedValue;
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new PermissionsRequesterState(null, false, va.v.e(PermissionNeedIt.CALLS), 1, null), null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            final MutableState mutableState = (MutableState) objRememberedValue2;
            Function2 function2 = new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.details.o
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DetailsDialogForContactCardKt.DetailsDialogForContactCard$lambda$2(mutableState, context, friend, aVar, navigateTo, clipboardManager, (Composer) obj, ((Integer) obj2).intValue());
                }
            };
            friend2 = friend;
            function1 = navigateTo;
            handleClose = aVar;
            composer2 = composerStartRestartGroup;
            AndroidDialog_androidKt.Dialog(handleClose, null, ComposableLambdaKt.rememberComposableLambda(185270987, true, function2, composerStartRestartGroup, 54), composer2, ((i12 >> 3) & 14) | RendererCapabilities.DECODER_SUPPORT_MASK, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            friend2 = friend;
            function1 = navigateTo;
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.details.p
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DetailsDialogForContactCardKt.DetailsDialogForContactCard$lambda$3(friend2, handleClose, function1, i10, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 DetailsDialogForContactCard$lambda$2(MutableState mutableState, final Context context, final Friend friend, final lb.a aVar, final Function1 function1, final ClipboardManager clipboardManager, Composer composer, int i10) {
        final MutableState mutableState2;
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(185270987, i10, -1, "cu.todus.android.uiCompose.main.screen.chat.details.DetailsDialogForContactCard.<anonymous> (DetailsDialogForContactCard.kt:65)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            Modifier modifierWrapContentSize$default = SizeKt.wrapContentSize$default(companion, null, false, 3, null);
            RoundedCornerShape roundedCornerShapeM2015RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(15));
            MaterialTheme materialTheme = MaterialTheme.INSTANCE;
            int i11 = MaterialTheme.$stable;
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(PaddingKt.m1725padding3ABfNKs(BackgroundKt.m1204backgroundbw27NRU(modifierWrapContentSize$default, materialTheme.getColorScheme(composer, i11).getBackground(), roundedCornerShapeM2015RoundedCornerShape0680j_4), Dp.m8823constructorimpl(10)), 0.0f, 1, null);
            Arrangement arrangement = Arrangement.INSTANCE;
            Arrangement.Vertical top = arrangement.getTop();
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
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, friend.getName(), materialTheme.getTypography(composer, i11).getLabelLarge(), 0L, 0, 0, composer, 0, 57);
            Modifier modifierFillMaxWidth$default2 = SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null);
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getSpaceAround(), companion2.getTop(), composer, 6);
            int iA2 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer, modifierFillMaxWidth$default2);
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
            Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyRowMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl2, Integer.valueOf(iA2), companion3.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl2, companion3.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier2, companion3.getSetModifier());
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            boolean zChangedInstance = composer.changedInstance(context) | composer.changed(friend) | composer.changed(aVar);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.details.g
                    @Override // lb.a
                    public final Object invoke() {
                        return DetailsDialogForContactCardKt.DetailsDialogForContactCard$lambda$2$0$0$0$0(context, friend, aVar);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            float f10 = 3;
            Modifier modifierM1725padding3ABfNKs = PaddingKt.m1725padding3ABfNKs(companion, Dp.m8823constructorimpl(f10));
            ComposableSingletons$DetailsDialogForContactCardKt composableSingletons$DetailsDialogForContactCardKt = ComposableSingletons$DetailsDialogForContactCardKt.INSTANCE;
            IconButtonKt.IconButton((lb.a) objRememberedValue, modifierM1725padding3ABfNKs, false, null, null, null, composableSingletons$DetailsDialogForContactCardKt.m9886getLambda$869839549$app_productionPFast(), composer, 1572912, 60);
            boolean zChanged = composer.changed(friend) | composer.changed(function1) | composer.changedInstance(context) | composer.changed(aVar);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.details.h
                    @Override // lb.a
                    public final Object invoke() {
                        return DetailsDialogForContactCardKt.DetailsDialogForContactCard$lambda$2$0$0$1$0(friend, function1, context, aVar);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            IconButtonKt.IconButton((lb.a) objRememberedValue2, PaddingKt.m1725padding3ABfNKs(companion, Dp.m8823constructorimpl(f10)), false, null, null, null, composableSingletons$DetailsDialogForContactCardKt.m9884getLambda$759591942$app_productionPFast(), composer, 1572912, 60);
            boolean zChangedInstance2 = composer.changedInstance(context) | composer.changed(friend) | composer.changed(aVar);
            Object objRememberedValue3 = composer.rememberedValue();
            if (zChangedInstance2 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                mutableState2 = mutableState;
                objRememberedValue3 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.details.i
                    @Override // lb.a
                    public final Object invoke() {
                        return DetailsDialogForContactCardKt.DetailsDialogForContactCard$lambda$2$0$0$2$0(mutableState2, context, friend, aVar);
                    }
                };
                composer.updateRememberedValue(objRememberedValue3);
            } else {
                mutableState2 = mutableState;
            }
            IconButtonKt.IconButton((lb.a) objRememberedValue3, PaddingKt.m1725padding3ABfNKs(companion, Dp.m8823constructorimpl(f10)), false, null, null, null, composableSingletons$DetailsDialogForContactCardKt.getLambda$382755643$app_productionPFast(), composer, 1572912, 60);
            boolean zChanged2 = composer.changed(friend) | composer.changedInstance(clipboardManager) | composer.changed(aVar);
            Object objRememberedValue4 = composer.rememberedValue();
            if (zChanged2 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.details.j
                    @Override // lb.a
                    public final Object invoke() {
                        return DetailsDialogForContactCardKt.DetailsDialogForContactCard$lambda$2$0$0$3$0(friend, clipboardManager, aVar);
                    }
                };
                composer.updateRememberedValue(objRememberedValue4);
            }
            final MutableState mutableState3 = mutableState2;
            IconButtonKt.IconButton((lb.a) objRememberedValue4, PaddingKt.m1725padding3ABfNKs(companion, Dp.m8823constructorimpl(f10)), false, null, null, null, composableSingletons$DetailsDialogForContactCardKt.getLambda$1525103228$app_productionPFast(), composer, 1572912, 60);
            le.a0.O(friend.getContact().getPhone(), "-", "", false, 4, null).getClass();
            composer.startReplaceGroup(-1170655843);
            composer.endReplaceGroup();
            composer.endNode();
            composer.endNode();
            PermissionsRequesterState permissionsRequesterState = (PermissionsRequesterState) mutableState3.getValue();
            Object objRememberedValue5 = composer.rememberedValue();
            Composer.Companion companion4 = Composer.INSTANCE;
            if (objRememberedValue5 == companion4.getEmpty()) {
                objRememberedValue5 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.details.k
                    @Override // lb.a
                    public final Object invoke() {
                        return DetailsDialogForContactCardKt.DetailsDialogForContactCard$lambda$2$1$0(mutableState3);
                    }
                };
                composer.updateRememberedValue(objRememberedValue5);
            }
            lb.a aVar2 = (lb.a) objRememberedValue5;
            Object objRememberedValue6 = composer.rememberedValue();
            if (objRememberedValue6 == companion4.getEmpty()) {
                objRememberedValue6 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.details.l
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DetailsDialogForContactCardKt.DetailsDialogForContactCard$lambda$2$2$0(mutableState3, (PermissionsResult) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue6);
            }
            Z17PermissionRequesterKt.Z17PermissionChecker(null, aVar2, permissionsRequesterState, (Function1) objRememberedValue6, composableSingletons$DetailsDialogForContactCardKt.getLambda$1107380331$app_productionPFast(), composer, 27696, 1);
            PermissionsRequesterState permissionsRequesterState2 = (PermissionsRequesterState) mutableState3.getValue();
            String packageName = context.getPackageName();
            kotlin.jvm.internal.y.h(packageName, "getPackageName(...)");
            Object objRememberedValue7 = composer.rememberedValue();
            if (objRememberedValue7 == companion4.getEmpty()) {
                objRememberedValue7 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.details.m
                    @Override // lb.a
                    public final Object invoke() {
                        return DetailsDialogForContactCardKt.DetailsDialogForContactCard$lambda$2$3$0(mutableState3);
                    }
                };
                composer.updateRememberedValue(objRememberedValue7);
            }
            lb.a aVar3 = (lb.a) objRememberedValue7;
            Object objRememberedValue8 = composer.rememberedValue();
            if (objRememberedValue8 == companion4.getEmpty()) {
                objRememberedValue8 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.details.n
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DetailsDialogForContactCardKt.DetailsDialogForContactCard$lambda$2$4$0(mutableState3, (PermissionsResult) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue8);
            }
            Z17PermissionRequesterKt.Z17PermissionRequester(permissionsRequesterState2, aVar3, (Function1) objRememberedValue8, packageName, composer, 432);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 DetailsDialogForContactCard$lambda$2$0$0$0$0(Context context, Friend friend, lb.a aVar) {
        IntentUtil.addContact$default(IntentUtil.INSTANCE, context, friend.getName(), friend.getContact().getPhone(), null, 8, null);
        aVar.invoke();
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 DetailsDialogForContactCard$lambda$2$0$0$1$0(Friend friend, Function1 function1, Context context, lb.a aVar) {
        if (friend.getUser() != null) {
            NavLinks navLinks = NavLinks.INSTANCE;
            String strT = MainModule.INSTANCE.getInstance().getGson().t(new ChatParams(friend.getId(), 0, null, 0, 12, null));
            kotlin.jvm.internal.y.h(strT, "toJson(...)");
            function1.invoke(navLinks.goChat(0, strT));
        } else {
            IntentUtil.INSTANCE.openSendText(context, friend.getContact().getPhone());
        }
        aVar.invoke();
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 DetailsDialogForContactCard$lambda$2$0$0$2$0(MutableState mutableState, Context context, Friend friend, lb.a aVar) {
        Integer state = ((PermissionsRequesterState) mutableState.getValue()).getPermissionsResult().getState();
        if (state != null && state.intValue() == 2) {
            IntentUtil.INSTANCE.operatorCall(context, friend.getContact().getPhone());
            aVar.invoke();
        } else {
            mutableState.setValue(PermissionsRequesterState.copy$default((PermissionsRequesterState) mutableState.getValue(), null, true, null, 5, null));
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 DetailsDialogForContactCard$lambda$2$0$0$3$0(Friend friend, ClipboardManager clipboardManager, lb.a aVar) {
        clipboardManager.setPrimaryClip(ClipData.newPlainText(TemplateContent.NUMBER_TYPE, friend.getContact().getPhone()));
        aVar.invoke();
        return ua.k0.f43947a;
    }

    private static final ua.k0 DetailsDialogForContactCard$lambda$2$0$0$4$0(Friend friend, Context context) {
        try {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.SEND");
            intent.setType(MediaUtil.TEXT);
            intent.putExtra("android.intent.extra.TEXT", "TRANSFERMOVIL_ETECSA,TRANSFERENCIA," + le.a0.O(friend.getContact().getPhone(), "-", "", false, 4, null) + "," + friend.getContact().getFName());
            context.startActivity(intent);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 DetailsDialogForContactCard$lambda$2$1$0(MutableState mutableState) {
        mutableState.setValue(PermissionsRequesterState.copy$default((PermissionsRequesterState) mutableState.getValue(), null, true, null, 5, null));
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 DetailsDialogForContactCard$lambda$2$2$0(MutableState mutableState, PermissionsResult result) {
        kotlin.jvm.internal.y.i(result, "result");
        PermissionsRequesterState permissionsRequesterState = (PermissionsRequesterState) mutableState.getValue();
        Integer state = result.getState();
        mutableState.setValue(PermissionsRequesterState.copy$default(permissionsRequesterState, result, state == null || state.intValue() != 2, null, 4, null));
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 DetailsDialogForContactCard$lambda$2$3$0(MutableState mutableState) {
        mutableState.setValue(PermissionsRequesterState.copy$default((PermissionsRequesterState) mutableState.getValue(), null, false, null, 5, null));
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 DetailsDialogForContactCard$lambda$2$4$0(MutableState mutableState, PermissionsResult result) {
        kotlin.jvm.internal.y.i(result, "result");
        mutableState.setValue(PermissionsRequesterState.copy$default((PermissionsRequesterState) mutableState.getValue(), result, false, null, 6, null));
        Integer state = result.getState();
        if (state != null && state.intValue() == 2) {
            mutableState.setValue(PermissionsRequesterState.copy$default((PermissionsRequesterState) mutableState.getValue(), null, false, null, 5, null));
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 DetailsDialogForContactCard$lambda$3(Friend friend, lb.a aVar, Function1 function1, int i10, Composer composer, int i11) {
        DetailsDialogForContactCard(friend, aVar, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1));
        return ua.k0.f43947a;
    }
}
