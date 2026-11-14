package cu.todus.android.uiCompose.intentReceiver.screen.presend;

import android.content.Context;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
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
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.navigation.NavHostController;
import androidx.p001lifecycle.HasDefaultViewModelProviderFactory;
import androidx.p001lifecycle.ViewModelProvider;
import androidx.p001lifecycle.ViewModelStoreOwner;
import androidx.p001lifecycle.viewmodel.CreationExtras;
import androidx.p001lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.p001lifecycle.viewmodel.compose.ViewModelKt;
import cu.todus.android.data.util.MediaUtil;
import cu.todus.android.domain.handlers.Send;
import cu.todus.android.uiCompose.intentReceiver.screen.presend.PresentScreenKt;
import cu.todus.android.uiCompose.intentReceiver.screen.sendTo.SendToViewModel;
import cu.todus.android.uiCompose.loading.screen.LoadingScreenKt;
import cu.todus.android.uiCompose.shared.camera.CameraKt;
import cu.todus.android.uiCompose.shared.camera.CameraParams;
import cu.z17.views.utils.Z17InlineUtilsKt;
import defpackage.l;
import defpackage.r;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.y;
import kotlin.jvm.internal.z0;
import lb.a;
import ua.k0;
import va.g0;
import va.w;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a)\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b²\u0006\u000e\u0010\n\u001a\u00020\t8\n@\nX\u008a\u008e\u0002"}, d2 = {"Landroidx/navigation/NavHostController;", "navHostController", "", "params", "Lcu/todus/android/uiCompose/intentReceiver/screen/sendTo/SendToViewModel;", "viewModel", "Lua/k0;", "PresentScreen", "(Landroidx/navigation/NavHostController;Ljava/lang/String;Lcu/todus/android/uiCompose/intentReceiver/screen/sendTo/SendToViewModel;Landroidx/compose/runtime/Composer;II)V", "", "isLoading", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class PresentScreenKt {
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void PresentScreen(final NavHostController navHostController, final String params, SendToViewModel sendToViewModel, Composer composer, final int i10, final int i11) {
        int i12;
        SendToViewModel sendToViewModel2;
        final SendToViewModel sendToViewModel3;
        y.i(navHostController, "navHostController");
        y.i(params, "params");
        Composer composerStartRestartGroup = composer.startRestartGroup(2047768073);
        if ((i10 & 48) == 0) {
            i12 = (composerStartRestartGroup.changed(params) ? 32 : 16) | i10;
        } else {
            i12 = i10;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            if ((i11 & 4) == 0) {
                sendToViewModel2 = sendToViewModel;
                int i13 = composerStartRestartGroup.changedInstance(sendToViewModel2) ? 256 : 128;
                i12 |= i13;
            } else {
                sendToViewModel2 = sendToViewModel;
            }
            i12 |= i13;
        } else {
            sendToViewModel2 = sendToViewModel;
        }
        if (composerStartRestartGroup.shouldExecute((i12 & 145) != 144, i12 & 1)) {
            composerStartRestartGroup.startDefaults();
            if ((i10 & 1) != 0 && !composerStartRestartGroup.getDefaultsInvalid()) {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i11 & 4) != 0) {
                    i12 &= -897;
                }
            } else if ((i11 & 4) != 0) {
                ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composerStartRestartGroup, 6);
                if (current == null) {
                    throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                }
                sendToViewModel2 = (SendToViewModel) ViewModelKt.viewModel(z0.b(SendToViewModel.class), current, (String) null, (ViewModelProvider.Factory) null, current instanceof HasDefaultViewModelProviderFactory ? ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras() : CreationExtras.Empty.INSTANCE, composerStartRestartGroup, 0, 0);
                i12 &= -897;
            }
            SendToViewModel sendToViewModel4 = sendToViewModel2;
            int i14 = i12;
            sendToViewModel3 = sendToViewModel4;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2047768073, i14, -1, "cu.todus.android.uiCompose.intentReceiver.screen.presend.PresentScreen (PresentScreen.kt:27)");
            }
            final Context context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = (PresentParams) sendToViewModel3.getGson().j(params, PresentParams.class);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final PresentParams presentParams = (PresentParams) objRememberedValue;
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            final MutableState mutableState = (MutableState) objRememberedValue2;
            Modifier.Companion companion2 = Modifier.INSTANCE;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            int iA = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion2);
            ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
            a constructor = companion3.getConstructor();
            if (!r.a(composerStartRestartGroup.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM5176constructorimpl = Updater.m5176constructorimpl(composerStartRestartGroup);
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion3.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl, companion3.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion3.getSetModifier());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(companion2, 0.0f, 1, null);
            Integer numValueOf = Integer.valueOf(presentParams.getType());
            String path = presentParams.getPath();
            long durationFromFile = 0;
            if (presentParams.getType() == 2) {
                try {
                    durationFromFile = MediaUtil.INSTANCE.getDurationFromFile(context, new File(presentParams.getPath()));
                } catch (Exception unused) {
                }
            }
            CameraParams cameraParams = new CameraParams(numValueOf, path, durationFromFile);
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(sendToViewModel3) | composerStartRestartGroup.changedInstance(context);
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function2() { // from class: k7.c
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return PresentScreenKt.PresentScreen$lambda$4$0$0(sendToViewModel3, presentParams, context, mutableState, (List) obj, (String) obj2);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            Function2 function2 = (Function2) objRememberedValue3;
            boolean zChangedInstance2 = composerStartRestartGroup.changedInstance(sendToViewModel3) | composerStartRestartGroup.changedInstance(context);
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance2 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = new Function2() { // from class: k7.d
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return PresentScreenKt.PresentScreen$lambda$4$1$0(sendToViewModel3, presentParams, context, mutableState, (List) obj, (String) obj2);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            Function2 function3 = (Function2) objRememberedValue4;
            boolean zChangedInstance3 = composerStartRestartGroup.changedInstance(context);
            Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance3 || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue5 = new a() { // from class: k7.e
                    @Override // lb.a
                    public final Object invoke() {
                        return PresentScreenKt.PresentScreen$lambda$4$2$0(context);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            }
            a aVar = (a) objRememberedValue5;
            boolean zChangedInstance4 = composerStartRestartGroup.changedInstance(context);
            Object objRememberedValue6 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance4 || objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue6 = new a() { // from class: k7.f
                    @Override // lb.a
                    public final Object invoke() {
                        return PresentScreenKt.PresentScreen$lambda$4$3$0(context);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
            }
            CameraKt.Camera(modifierFillMaxSize$default, cameraParams, false, false, false, false, 0L, function2, function3, null, aVar, (a) objRememberedValue6, composerStartRestartGroup, 6, 0, 636);
            composerStartRestartGroup = composerStartRestartGroup;
            if (PresentScreen$lambda$2(mutableState)) {
                composerStartRestartGroup.startReplaceGroup(-913264752);
                LoadingScreenKt.LoadingWall(composerStartRestartGroup, 0);
            } else {
                composerStartRestartGroup.startReplaceGroup(1753576255);
            }
            composerStartRestartGroup.endReplaceGroup();
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            sendToViewModel3 = sendToViewModel2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: k7.g
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PresentScreenKt.PresentScreen$lambda$5(navHostController, params, sendToViewModel3, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final boolean PresentScreen$lambda$2(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void PresentScreen$lambda$3(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 PresentScreen$lambda$4$0$0(SendToViewModel sendToViewModel, PresentParams presentParams, final Context context, MutableState mutableState, List files, String content) {
        y.i(files, "files");
        y.i(content, "content");
        PresentScreen$lambda$3(mutableState, true);
        List<String> ids = presentParams.getIds();
        String path = ((File) g0.w0(files)).getPath();
        y.h(path, "getPath(...)");
        sendToViewModel.sendTo(ids, w.q(new Send(4, path), new Send(1, content)), context, new a() { // from class: k7.b
            @Override // lb.a
            public final Object invoke() {
                return PresentScreenKt.PresentScreen$lambda$4$0$0$0(context);
            }
        });
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 PresentScreen$lambda$4$0$0$0(Context context) {
        Z17InlineUtilsKt.findActivity(context).finish();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 PresentScreen$lambda$4$1$0(SendToViewModel sendToViewModel, PresentParams presentParams, final Context context, MutableState mutableState, List files, String content) {
        y.i(files, "files");
        y.i(content, "content");
        PresentScreen$lambda$3(mutableState, true);
        List<String> ids = presentParams.getIds();
        String path = ((File) g0.w0(files)).getPath();
        y.h(path, "getPath(...)");
        sendToViewModel.sendTo(ids, w.q(new Send(2, path), new Send(1, content)), context, new a() { // from class: k7.a
            @Override // lb.a
            public final Object invoke() {
                return PresentScreenKt.PresentScreen$lambda$4$1$0$0(context);
            }
        });
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 PresentScreen$lambda$4$1$0$0(Context context) {
        Z17InlineUtilsKt.findActivity(context).finish();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 PresentScreen$lambda$4$2$0(Context context) {
        Z17InlineUtilsKt.findActivity(context).finish();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 PresentScreen$lambda$4$3$0(Context context) {
        Z17InlineUtilsKt.findActivity(context).finish();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 PresentScreen$lambda$5(NavHostController navHostController, String str, SendToViewModel sendToViewModel, int i10, int i11, Composer composer, int i12) {
        PresentScreen(navHostController, str, sendToViewModel, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return k0.f43947a;
    }
}
