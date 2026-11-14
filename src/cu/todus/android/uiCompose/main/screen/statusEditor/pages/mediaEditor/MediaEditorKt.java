package cu.todus.android.uiCompose.main.screen.statusEditor.pages.mediaEditor;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.media3.exoplayer.RendererCapabilities;
import cu.todus.android.uiCompose.main.screen.statusEditor.pages.mediaEditor.MediaEditorKt;
import cu.todus.android.uiCompose.shared.camera.CameraKt;
import cu.todus.android.uiCompose.shared.camera.CameraParams;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.y;
import lb.a;
import ua.k0;
import va.g0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a[\u0010\n\u001a\u00020\u00052\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\u0018\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00022\u0018\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00022\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\bH\u0007¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcu/todus/android/uiCompose/shared/camera/CameraParams;", "initialValue", "Lkotlin/Function2;", "Ljava/io/File;", "", "Lua/k0;", "onCreateImageContent", "onCreateVideoContent", "Lkotlin/Function0;", "onCancel", "MediaEditor", "(Lcu/todus/android/uiCompose/shared/camera/CameraParams;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Llb/a;Landroidx/compose/runtime/Composer;I)V", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class MediaEditorKt {
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void MediaEditor(final CameraParams cameraParams, final Function2 onCreateImageContent, final Function2 onCreateVideoContent, final a onCancel, Composer composer, final int i10) {
        int i11;
        Composer composer2;
        y.i(onCreateImageContent, "onCreateImageContent");
        y.i(onCreateVideoContent, "onCreateVideoContent");
        y.i(onCancel, "onCancel");
        Composer composerStartRestartGroup = composer.startRestartGroup(-213390556);
        if ((i10 & 6) == 0) {
            i11 = (composerStartRestartGroup.changed(cameraParams) ? 4 : 2) | i10;
        } else {
            i11 = i10;
        }
        if ((i10 & 48) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(onCreateImageContent) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(onCreateVideoContent) ? 256 : 128;
        }
        if ((i10 & 3072) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(onCancel) ? 2048 : 1024;
        }
        if (composerStartRestartGroup.shouldExecute((i11 & 1171) != 1170, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-213390556, i11, -1, "cu.todus.android.uiCompose.main.screen.statusEditor.pages.mediaEditor.MediaEditor (MediaEditor.kt:21)");
            }
            Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
            CameraParams cameraParams2 = cameraParams == null ? new CameraParams(null, null, 0L, 7, null) : cameraParams;
            boolean z10 = (i11 & 896) == 256;
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z10 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function2() { // from class: f8.a
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return MediaEditorKt.MediaEditor$lambda$0$0(onCreateVideoContent, (List) obj, (String) obj2);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            Function2 function2 = (Function2) objRememberedValue;
            boolean z11 = (i11 & 112) == 32;
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (z11 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function2() { // from class: f8.b
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return MediaEditorKt.MediaEditor$lambda$1$0(onCreateImageContent, (List) obj, (String) obj2);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            composer2 = composerStartRestartGroup;
            CameraKt.Camera(modifierFillMaxSize$default, cameraParams2, false, false, false, true, 60000L, function2, (Function2) objRememberedValue2, null, onCancel, onCancel, composer2, 1769478, ((i11 >> 9) & 14) | ((i11 >> 6) & 112), 540);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: f8.c
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return MediaEditorKt.MediaEditor$lambda$2(cameraParams, onCreateImageContent, onCreateVideoContent, onCancel, i10, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 MediaEditor$lambda$0$0(Function2 function2, List files, String content) {
        y.i(files, "files");
        y.i(content, "content");
        function2.invoke(g0.w0(files), content);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 MediaEditor$lambda$1$0(Function2 function2, List files, String content) {
        y.i(files, "files");
        y.i(content, "content");
        function2.invoke(g0.w0(files), content);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 MediaEditor$lambda$2(CameraParams cameraParams, Function2 function2, Function2 function3, a aVar, int i10, Composer composer, int i11) {
        MediaEditor(cameraParams, function2, function3, aVar, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1));
        return k0.f43947a;
    }
}
