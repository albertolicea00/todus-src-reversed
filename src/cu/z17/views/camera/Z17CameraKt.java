package cu.z17.views.camera;

import android.content.Context;
import android.content.res.Configuration;
import androidx.camera.view.PreviewView;
import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.PauseCircleFilledKt;
import androidx.compose.material.icons.filled.PlayCircleFilledKt;
import androidx.compose.material.icons.outlined.CameraAltKt;
import androidx.compose.material.icons.outlined.CameraswitchKt;
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
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableLongState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotLongStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.draw.RotateKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.viewinterop.AndroidView_androidKt;
import androidx.media3.common.C;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.p001lifecycle.HasDefaultViewModelProviderFactory;
import androidx.p001lifecycle.Lifecycle;
import androidx.p001lifecycle.LifecycleOwner;
import androidx.p001lifecycle.ViewModel;
import androidx.p001lifecycle.ViewModelStoreOwner;
import androidx.p001lifecycle.p002compose.FlowExtKt;
import androidx.p001lifecycle.viewmodel.CreationExtras;
import androidx.p001lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.p001lifecycle.viewmodel.compose.ViewModelKt;
import androidx.profileinstaller.ProfileVerifier;
import cu.z17.views.button.Z17ButtonsKt;
import cu.z17.views.label.Z17LabelKt;
import cu.z17.views.picture.Z17PictureKt;
import cu.z17.views.utils.Z17InlineUtilsKt;
import defpackage.r;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.y;
import kotlin.jvm.internal.z0;
import lb.o;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u009d\u0001\u0010\u0017\u001a\u00020\u000e2\b\b\u0002\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2$\u0010\u0014\u001a \u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u000e0\u00102\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\b\b\u0002\u0010\u0016\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u0017\u0010\u0018¨\u0006#²\u0006\u000e\u0010\u0019\u001a\u00020\u00058\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\u001a\u001a\u00020\u00128\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\u001b\u001a\u00020\u00058\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\u001c\u001a\u00020\u00138\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\u001d\u001a\u00020\u00138\n@\nX\u008a\u008e\u0002²\u0006\f\u0010\u001e\u001a\u00020\u00138\nX\u008a\u0084\u0002²\u0006\f\u0010 \u001a\u00020\u001f8\nX\u008a\u0084\u0002²\u0006\f\u0010\"\u001a\u00020!8\nX\u008a\u0084\u0002"}, d2 = {"Landroidx/compose/ui/Modifier;", "modifier", "", "imagePathToSave", "videoPathToSave", "", "isVideo", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Lcu/z17/views/camera/Z17CameraViewModel;", "viewModel", "Landroid/content/Context;", "context", "Lkotlin/Function0;", "Lua/k0;", "onClose", "Lkotlin/Function4;", "Lcu/z17/views/camera/ResultType;", "", "", "onResult", "onError", "showCloseBtn", "Z17Camera", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;Ljava/lang/String;ZLandroidx/lifecycle/LifecycleOwner;Lcu/z17/views/camera/Z17CameraViewModel;Landroid/content/Context;Llb/a;Llb/o;Llb/a;ZLandroidx/compose/runtime/Composer;III)V", "isFlashLightOn", "currentRecordTime", "isFrontCamera", "actualRotation", "rotationStateOnlyForAnimation", "animateRotation", "Lcu/z17/views/camera/CaptureState;", "captureResult", "Lcu/z17/views/camera/RecordingState;", "recordState", "views_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class Z17CameraKt {
    /* JADX WARN: Code duplicated, block: B:101:0x0134  */
    /* JADX WARN: Code duplicated, block: B:104:0x0142  */
    /* JADX WARN: Code duplicated, block: B:108:0x014a  */
    /* JADX WARN: Code duplicated, block: B:111:0x0153  */
    /* JADX WARN: Code duplicated, block: B:113:0x015e  */
    /* JADX WARN: Code duplicated, block: B:126:0x018c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:127:0x018e  */
    /* JADX WARN: Code duplicated, block: B:128:0x0191  */
    /* JADX WARN: Code duplicated, block: B:130:0x0195  */
    /* JADX WARN: Code duplicated, block: B:131:0x0197  */
    /* JADX WARN: Code duplicated, block: B:134:0x019c  */
    /* JADX WARN: Code duplicated, block: B:137:0x01ab  */
    /* JADX WARN: Code duplicated, block: B:139:0x01c7  */
    /* JADX WARN: Code duplicated, block: B:141:0x01cb  */
    /* JADX WARN: Code duplicated, block: B:143:0x01d5  */
    /* JADX WARN: Code duplicated, block: B:145:0x01f7  */
    /* JADX WARN: Code duplicated, block: B:147:0x01ff  */
    /* JADX WARN: Code duplicated, block: B:150:0x0208  */
    /* JADX WARN: Code duplicated, block: B:152:0x0218  */
    /* JADX WARN: Code duplicated, block: B:154:0x0220  */
    /* JADX WARN: Code duplicated, block: B:157:0x022e  */
    /* JADX WARN: Code duplicated, block: B:160:0x0244  */
    /* JADX WARN: Code duplicated, block: B:162:0x0271  */
    /* JADX WARN: Code duplicated, block: B:165:0x027d  */
    /* JADX WARN: Code duplicated, block: B:166:0x0281  */
    /* JADX WARN: Code duplicated, block: B:169:0x02a2  */
    /* JADX WARN: Code duplicated, block: B:171:0x02b0  */
    /* JADX WARN: Code duplicated, block: B:174:0x02dd  */
    /* JADX WARN: Code duplicated, block: B:177:0x02f2  */
    /* JADX WARN: Code duplicated, block: B:180:0x0308  */
    /* JADX WARN: Code duplicated, block: B:183:0x031f  */
    /* JADX WARN: Code duplicated, block: B:184:0x032d  */
    /* JADX WARN: Code duplicated, block: B:187:0x0341  */
    /* JADX WARN: Code duplicated, block: B:190:0x0354  */
    /* JADX WARN: Code duplicated, block: B:193:0x03cc  */
    /* JADX WARN: Code duplicated, block: B:194:0x03d8  */
    /* JADX WARN: Code duplicated, block: B:197:0x03f2  */
    /* JADX WARN: Code duplicated, block: B:199:0x03f8  */
    /* JADX WARN: Code duplicated, block: B:204:0x0430  */
    /* JADX WARN: Code duplicated, block: B:205:0x0433  */
    /* JADX WARN: Code duplicated, block: B:208:0x043f  */
    /* JADX WARN: Code duplicated, block: B:209:0x0441  */
    /* JADX WARN: Code duplicated, block: B:212:0x0453  */
    /* JADX WARN: Code duplicated, block: B:213:0x0455  */
    /* JADX WARN: Code duplicated, block: B:216:0x045e  */
    /* JADX WARN: Code duplicated, block: B:220:0x047c  */
    /* JADX WARN: Code duplicated, block: B:223:0x04b7  */
    /* JADX WARN: Code duplicated, block: B:224:0x04b9  */
    /* JADX WARN: Code duplicated, block: B:227:0x04c1  */
    /* JADX WARN: Code duplicated, block: B:228:0x04c3  */
    /* JADX WARN: Code duplicated, block: B:231:0x04d0  */
    /* JADX WARN: Code duplicated, block: B:235:0x04dc  */
    /* JADX WARN: Code duplicated, block: B:238:0x04ff  */
    /* JADX WARN: Code duplicated, block: B:240:0x0505  */
    /* JADX WARN: Code duplicated, block: B:243:0x052b  */
    /* JADX WARN: Code duplicated, block: B:245:0x0548  */
    /* JADX WARN: Code duplicated, block: B:246:0x054a  */
    /* JADX WARN: Code duplicated, block: B:249:0x0552  */
    /* JADX WARN: Code duplicated, block: B:251:0x0558  */
    /* JADX WARN: Code duplicated, block: B:254:0x057f  */
    /* JADX WARN: Code duplicated, block: B:256:0x0587  */
    /* JADX WARN: Code duplicated, block: B:258:0x05e1  */
    /* JADX WARN: Code duplicated, block: B:261:0x0637  */
    /* JADX WARN: Code duplicated, block: B:264:0x0643  */
    /* JADX WARN: Code duplicated, block: B:265:0x0647  */
    /* JADX WARN: Code duplicated, block: B:268:0x0666  */
    /* JADX WARN: Code duplicated, block: B:270:0x0674  */
    /* JADX WARN: Code duplicated, block: B:273:0x06cd  */
    /* JADX WARN: Code duplicated, block: B:277:0x06d7  */
    /* JADX WARN: Code duplicated, block: B:280:0x0716  */
    /* JADX WARN: Code duplicated, block: B:283:0x0722  */
    /* JADX WARN: Code duplicated, block: B:284:0x0726  */
    /* JADX WARN: Code duplicated, block: B:287:0x0745  */
    /* JADX WARN: Code duplicated, block: B:289:0x0753  */
    /* JADX WARN: Code duplicated, block: B:292:0x0779  */
    /* JADX WARN: Code duplicated, block: B:294:0x0782  */
    /* JADX WARN: Code duplicated, block: B:297:0x07bb  */
    /* JADX WARN: Code duplicated, block: B:301:0x07c7  */
    /* JADX WARN: Code duplicated, block: B:304:0x0804  */
    /* JADX WARN: Code duplicated, block: B:305:0x0809  */
    /* JADX WARN: Code duplicated, block: B:308:0x0836  */
    /* JADX WARN: Code duplicated, block: B:311:0x0842  */
    /* JADX WARN: Code duplicated, block: B:312:0x0846  */
    /* JADX WARN: Code duplicated, block: B:315:0x0865  */
    /* JADX WARN: Code duplicated, block: B:317:0x0873  */
    /* JADX WARN: Code duplicated, block: B:320:0x0892  */
    /* JADX WARN: Code duplicated, block: B:321:0x0894  */
    /* JADX WARN: Code duplicated, block: B:324:0x08ac  */
    /* JADX WARN: Code duplicated, block: B:328:0x08b6  */
    /* JADX WARN: Code duplicated, block: B:331:0x08e8  */
    /* JADX WARN: Code duplicated, block: B:335:0x08f3  */
    /* JADX WARN: Code duplicated, block: B:338:0x092f  */
    /* JADX WARN: Code duplicated, block: B:340:0x0963  */
    /* JADX WARN: Code duplicated, block: B:344:0x0975  */
    /* JADX WARN: Code duplicated, block: B:347:0x098b  */
    /* JADX WARN: Code duplicated, block: B:351:0x0997  */
    /* JADX WARN: Code duplicated, block: B:354:0x09c5  */
    /* JADX WARN: Code duplicated, block: B:356:0x09cb  */
    /* JADX WARN: Code duplicated, block: B:359:0x09e1  */
    /* JADX WARN: Code duplicated, block: B:362:0x09f6  */
    /* JADX WARN: Code duplicated, block: B:364:0x0a05  */
    /* JADX WARN: Code duplicated, block: B:367:0x0a1a  */
    /* JADX WARN: Code duplicated, block: B:369:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:40:0x008e  */
    /* JADX WARN: Code duplicated, block: B:42:0x0092  */
    /* JADX WARN: Code duplicated, block: B:44:0x009a  */
    /* JADX WARN: Code duplicated, block: B:45:0x009d  */
    /* JADX WARN: Code duplicated, block: B:48:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:51:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:56:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:58:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:61:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:66:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:68:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:71:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:73:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:74:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:78:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:80:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:81:0x0100  */
    /* JADX WARN: Code duplicated, block: B:85:0x010a  */
    /* JADX WARN: Code duplicated, block: B:87:0x0110  */
    /* JADX WARN: Code duplicated, block: B:88:0x0113  */
    /* JADX WARN: Code duplicated, block: B:92:0x011b  */
    /* JADX WARN: Code duplicated, block: B:94:0x0120  */
    /* JADX WARN: Code duplicated, block: B:96:0x0126  */
    /* JADX WARN: Code duplicated, block: B:98:0x012c  */
    /* JADX WARN: Code duplicated, block: B:99:0x012f  */
    /* JADX WARN: Instruction removed from duplicated block: B:137:0x01ab, please report this as an issue */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void Z17Camera(Modifier modifier, final String imagePathToSave, final String videoPathToSave, boolean z10, LifecycleOwner lifecycleOwner, Z17CameraViewModel z17CameraViewModel, Context context, final lb.a onClose, final o onResult, final lb.a onError, boolean z11, Composer composer, final int i10, final int i11, final int i12) {
        int i13;
        boolean z12;
        LifecycleOwner lifecycleOwner2;
        Context context2;
        int i14;
        int i15;
        int i16;
        int i17;
        boolean z13;
        final Modifier modifier2;
        final boolean z14;
        Composer composer2;
        final Context context3;
        final LifecycleOwner lifecycleOwner3;
        final boolean z15;
        final Z17CameraViewModel z17CameraViewModel2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier modifier3;
        boolean z16;
        Composer composer3;
        Z17CameraViewModel z17CameraViewModel3;
        boolean z17;
        Modifier modifier4;
        int i18;
        boolean z18;
        String str;
        Z17CameraViewModelFactory z17CameraViewModelFactory;
        ViewModelStoreOwner current;
        CreationExtras defaultViewModelCreationExtras;
        Z17CameraViewModel z17CameraViewModel4;
        final Context context4;
        final boolean z19;
        Composer composer4;
        LifecycleOwner lifecycleOwner4;
        Alignment.Companion companion;
        int currentCompositeKeyHash;
        lb.a constructor;
        Composer composerM5176constructorimpl;
        int i19;
        Function2 setCompositeKeyHash;
        BoxScopeInstance boxScopeInstance;
        final Configuration configuration;
        Object objRememberedValue;
        Composer.Companion companion2;
        final PreviewView previewView;
        Object objRememberedValue2;
        MutableState mutableState;
        Object objRememberedValue3;
        MutableLongState mutableLongState;
        Object objRememberedValue4;
        Object objRememberedValue5;
        MutableFloatState mutableFloatState;
        Object objRememberedValue6;
        MutableFloatState mutableFloatState2;
        Composer composer5;
        State stateCollectAsStateWithLifecycle;
        State stateCollectAsStateWithLifecycle2;
        Object objRememberedValue7;
        Composer composer6;
        boolean zChangedInstance;
        Object objRememberedValue8;
        State state;
        MutableLongState mutableLongState2;
        Context context5;
        MutableFloatState mutableFloatState3;
        int i20;
        boolean z20;
        boolean z21;
        boolean z22;
        boolean z23;
        Object objRememberedValue9;
        Composer composer7;
        int i21;
        int i22;
        final Z17CameraViewModel z17CameraViewModel5;
        State state2;
        final State state3;
        boolean z24;
        boolean z25;
        boolean zChangedInstance2;
        Object objRememberedValue10;
        MutableLongState mutableLongState3;
        boolean zChangedInstance3;
        Object objRememberedValue11;
        Modifier.Companion companion3;
        Composer composer8;
        int currentCompositeKeyHash2;
        lb.a constructor2;
        Composer composerM5176constructorimpl2;
        Function2 setCompositeKeyHash2;
        float f10;
        boolean zChangedInstance4;
        Object objRememberedValue12;
        final MutableState mutableState2;
        int currentCompositeKeyHash3;
        lb.a constructor3;
        Composer composerM5176constructorimpl3;
        Function2 setCompositeKeyHash3;
        ImageVector flashOff;
        boolean z26;
        Color.Companion companion4;
        float fM8823constructorimpl;
        int currentCompositeKeyHash4;
        lb.a constructor4;
        Composer composerM5176constructorimpl4;
        Function2 setCompositeKeyHash4;
        int i23;
        boolean z27;
        boolean zChangedInstance5;
        Object objRememberedValue13;
        boolean z28;
        final LifecycleOwner lifecycleOwner5;
        int i24;
        boolean z29;
        boolean zChangedInstance6;
        Object z17CameraKt$Z17Camera$1$8$1;
        boolean zChangedInstance7;
        Object objRememberedValue14;
        boolean z30;
        boolean z31;
        Object objRememberedValue15;
        int i25;
        int i26;
        int i27;
        int i28;
        int i29;
        y.i(imagePathToSave, "imagePathToSave");
        y.i(videoPathToSave, "videoPathToSave");
        y.i(onClose, "onClose");
        y.i(onResult, "onResult");
        y.i(onError, "onError");
        Composer composerStartRestartGroup = composer.startRestartGroup(1860373471);
        int i30 = i12 & 1;
        if (i30 != 0) {
            i13 = i10 | 6;
        } else if ((i10 & 6) == 0) {
            i13 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i10;
        } else {
            i13 = i10;
        }
        if ((i10 & 48) == 0) {
            i13 |= composerStartRestartGroup.changed(imagePathToSave) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i13 |= composerStartRestartGroup.changed(videoPathToSave) ? 256 : 128;
        }
        int i31 = i12 & 8;
        if (i31 == 0) {
            if ((i10 & 3072) == 0) {
                z12 = z10;
                i13 |= composerStartRestartGroup.changed(z12) ? 2048 : 1024;
            }
            if ((i10 & 24576) == 0) {
                if ((i12 & 16) == 0) {
                    lifecycleOwner2 = lifecycleOwner;
                    int i32 = composerStartRestartGroup.changedInstance(lifecycleOwner2) ? 16384 : 8192;
                    i13 |= i32;
                } else {
                    lifecycleOwner2 = lifecycleOwner;
                }
                i13 |= i32;
            } else {
                lifecycleOwner2 = lifecycleOwner;
            }
            if ((i10 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) != 0) {
                if ((i12 & 32) == 0 || !composerStartRestartGroup.changedInstance(z17CameraViewModel)) {
                    i29 = 65536;
                } else {
                    i29 = 131072;
                }
                i13 |= i29;
            }
            if ((i10 & 1572864) == 0) {
                context2 = context;
                if ((i12 & 64) == 0 || !composerStartRestartGroup.changedInstance(context2)) {
                    i28 = 524288;
                } else {
                    i28 = 1048576;
                }
                i13 |= i28;
            } else {
                context2 = context;
            }
            if ((i10 & 12582912) == 0) {
                if (composerStartRestartGroup.changedInstance(onClose)) {
                    i27 = 8388608;
                } else {
                    i27 = 4194304;
                }
                i13 |= i27;
            }
            if ((i10 & 100663296) == 0) {
                if (composerStartRestartGroup.changedInstance(onResult)) {
                    i26 = 67108864;
                } else {
                    i26 = 33554432;
                }
                i13 |= i26;
            }
            if ((i10 & 805306368) == 0) {
                if (composerStartRestartGroup.changedInstance(onError)) {
                    i25 = C.BUFFER_FLAG_LAST_SAMPLE;
                } else {
                    i25 = 268435456;
                }
                i13 |= i25;
            }
            i14 = i12 & 1024;
            if (i14 != 0) {
                if ((i11 & 6) == 0) {
                    if (composerStartRestartGroup.changed(z11)) {
                        i16 = 4;
                    } else {
                        i16 = 2;
                    }
                    i17 = i11 | i16;
                } else {
                    i15 = i11;
                }
                if ((i13 & 306783379) == 306783378 || (i15 & 3) != 2) {
                    z13 = true;
                } else {
                    z13 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z13, i13 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    if ((i10 & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        if (i30 != 0) {
                            modifier3 = Modifier.INSTANCE;
                        } else {
                            modifier3 = modifier;
                        }
                        if (i31 != 0) {
                            z16 = false;
                        } else {
                            z16 = z12;
                        }
                        if ((i12 & 16) != 0) {
                            lifecycleOwner2 = (LifecycleOwner) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner());
                            i13 &= -57345;
                        }
                        if ((i12 & 32) != 0) {
                            str = imagePathToSave + videoPathToSave;
                            z17CameraViewModelFactory = new Z17CameraViewModelFactory(imagePathToSave, videoPathToSave);
                            current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composerStartRestartGroup, 6);
                            if (current == null) {
                                throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                            }
                            if (current instanceof HasDefaultViewModelProviderFactory) {
                                defaultViewModelCreationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                            } else {
                                defaultViewModelCreationExtras = CreationExtras.Empty.INSTANCE;
                            }
                            ViewModel viewModel = ViewModelKt.viewModel(z0.b(Z17CameraViewModel.class), current, str, z17CameraViewModelFactory, defaultViewModelCreationExtras, composerStartRestartGroup, 0, 0);
                            composer3 = composerStartRestartGroup;
                            z17CameraViewModel3 = (Z17CameraViewModel) viewModel;
                            i13 &= -458753;
                        } else {
                            composer3 = composerStartRestartGroup;
                            z17CameraViewModel3 = z17CameraViewModel;
                        }
                        if ((i12 & 64) != 0) {
                            context2 = (Context) composer3.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                            i13 &= -3670017;
                        }
                        if (i14 != 0) {
                            z17 = true;
                        } else {
                            z17 = z11;
                        }
                        modifier4 = modifier3;
                        i18 = i13;
                        z18 = z16;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i12 & 16) != 0) {
                            i13 &= -57345;
                        }
                        if ((i12 & 32) != 0) {
                            i13 &= -458753;
                        }
                        if ((i12 & 64) != 0) {
                            i13 &= -3670017;
                        }
                        z17CameraViewModel3 = z17CameraViewModel;
                        z17 = z11;
                        composer3 = composerStartRestartGroup;
                        lifecycleOwner2 = lifecycleOwner2;
                        i18 = i13;
                        z18 = z12;
                        modifier4 = modifier;
                    }
                    composer3.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1860373471, i18, i15, "cu.z17.views.camera.Z17Camera (Z17Camera.kt:85)");
                    }
                    if (Z17CameraModule.INSTANCE.getInstance().getCanUseCamera()) {
                        composer3.startReplaceGroup(1112544640);
                        companion = Alignment.INSTANCE;
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion.getTopStart(), false);
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                        CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer3, modifier4);
                        ComposeUiNode.Companion companion5 = ComposeUiNode.INSTANCE;
                        constructor = companion5.getConstructor();
                        if (!r.a(composer3.getApplier())) {
                            ComposablesKt.invalidApplier();
                        }
                        composer3.startReusableNode();
                        if (composer3.getInserting()) {
                            composer3.createNode(constructor);
                        } else {
                            composer3.useNode();
                        }
                        composerM5176constructorimpl = Updater.m5176constructorimpl(composer3);
                        i19 = i18;
                        Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, companion5.getSetMeasurePolicy());
                        Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion5.getSetResolvedCompositionLocals());
                        setCompositeKeyHash = companion5.getSetCompositeKeyHash();
                        if (composerM5176constructorimpl.getInserting() || !y.d(composerM5176constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                            composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion5.getSetModifier());
                        boxScopeInstance = BoxScopeInstance.INSTANCE;
                        configuration = (Configuration) composer3.consume(AndroidCompositionLocals_androidKt.getLocalConfiguration());
                        objRememberedValue = composer3.rememberedValue();
                        companion2 = Composer.INSTANCE;
                        if (objRememberedValue == companion2.getEmpty()) {
                            objRememberedValue = new PreviewView(context2);
                            composer3.updateRememberedValue(objRememberedValue);
                        }
                        previewView = (PreviewView) objRememberedValue;
                        objRememberedValue2 = composer3.rememberedValue();
                        if (objRememberedValue2 == companion2.getEmpty()) {
                            objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                            composer3.updateRememberedValue(objRememberedValue2);
                        }
                        mutableState = (MutableState) objRememberedValue2;
                        objRememberedValue3 = composer3.rememberedValue();
                        if (objRememberedValue3 == companion2.getEmpty()) {
                            objRememberedValue3 = SnapshotLongStateKt.mutableLongStateOf(0L);
                            composer3.updateRememberedValue(objRememberedValue3);
                        }
                        mutableLongState = (MutableLongState) objRememberedValue3;
                        objRememberedValue4 = composer3.rememberedValue();
                        if (objRememberedValue4 == companion2.getEmpty()) {
                            objRememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                            composer3.updateRememberedValue(objRememberedValue4);
                        }
                        final MutableState mutableState3 = (MutableState) objRememberedValue4;
                        objRememberedValue5 = composer3.rememberedValue();
                        if (objRememberedValue5 == companion2.getEmpty()) {
                            objRememberedValue5 = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
                            composer3.updateRememberedValue(objRememberedValue5);
                        }
                        mutableFloatState = (MutableFloatState) objRememberedValue5;
                        objRememberedValue6 = composer3.rememberedValue();
                        if (objRememberedValue6 == companion2.getEmpty()) {
                            objRememberedValue6 = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
                            composer3.updateRememberedValue(objRememberedValue6);
                        }
                        mutableFloatState2 = (MutableFloatState) objRememberedValue6;
                        composer5 = composer3;
                        final State<Float> stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(mutableFloatState2.getFloatValue(), null, 0.0f, "ar", null, composer5, 3072, 22);
                        stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(z17CameraViewModel3.getCaptureResult(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composer5, 0, 7);
                        stateCollectAsStateWithLifecycle2 = FlowExtKt.collectAsStateWithLifecycle(z17CameraViewModel3.getRecordingResult(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composer5, 0, 7);
                        Float fValueOf = Float.valueOf(mutableFloatState.getFloatValue());
                        objRememberedValue7 = composer5.rememberedValue();
                        if (objRememberedValue7 == companion2.getEmpty()) {
                            objRememberedValue7 = new Z17CameraKt$Z17Camera$1$1$1(mutableFloatState, mutableFloatState2, null);
                            composer6 = composer5;
                            composer6.updateRememberedValue(objRememberedValue7);
                        } else {
                            composer6 = composer5;
                        }
                        EffectsKt.LaunchedEffect(fValueOf, (Function2) objRememberedValue7, composer6, 0);
                        k0 k0Var = k0.f43947a;
                        zChangedInstance = composer6.changedInstance(context2) | composer6.changed(stateCollectAsStateWithLifecycle2);
                        objRememberedValue8 = composer6.rememberedValue();
                        if (!zChangedInstance || objRememberedValue8 == companion2.getEmpty()) {
                            state = stateCollectAsStateWithLifecycle2;
                            mutableLongState2 = mutableLongState;
                            context5 = context2;
                            Z17CameraKt$Z17Camera$1$2$1 z17CameraKt$Z17Camera$1$2$1 = new Z17CameraKt$Z17Camera$1$2$1(context5, mutableFloatState, state, mutableLongState2, null);
                            mutableFloatState3 = mutableFloatState;
                            composer6.updateRememberedValue(z17CameraKt$Z17Camera$1$2$1);
                            objRememberedValue8 = z17CameraKt$Z17Camera$1$2$1;
                        } else {
                            mutableLongState2 = mutableLongState;
                            context5 = context2;
                            state = stateCollectAsStateWithLifecycle2;
                            mutableFloatState3 = mutableFloatState;
                        }
                        EffectsKt.LaunchedEffect(k0Var, (Function2) objRememberedValue8, composer6, 6);
                        CaptureState captureStateZ17Camera$lambda$47$lambda$17 = Z17Camera$lambda$47$lambda$17(stateCollectAsStateWithLifecycle);
                        boolean zChanged = composer6.changed(stateCollectAsStateWithLifecycle);
                        i20 = i19 & 234881024;
                        if (i20 == 67108864) {
                            z20 = true;
                        } else {
                            z20 = false;
                        }
                        boolean z32 = zChanged | z20;
                        if ((i19 & 112) == 32) {
                            z21 = true;
                        } else {
                            z21 = false;
                        }
                        boolean zChangedInstance8 = z32 | z21 | composer6.changedInstance(z17CameraViewModel3);
                        if ((i19 & C.ENCODING_PCM_DOUBLE) == 536870912) {
                            z22 = true;
                        } else {
                            z22 = false;
                        }
                        z23 = zChangedInstance8 | z22;
                        objRememberedValue9 = composer6.rememberedValue();
                        if (!z23 || objRememberedValue9 == companion2.getEmpty()) {
                            composer7 = composer6;
                            i21 = i20;
                            i22 = 67108864;
                            z17CameraViewModel5 = z17CameraViewModel3;
                            Z17CameraKt$Z17Camera$1$3$1 z17CameraKt$Z17Camera$1$3$1 = new Z17CameraKt$Z17Camera$1$3$1(onResult, imagePathToSave, z17CameraViewModel5, onError, stateCollectAsStateWithLifecycle, mutableFloatState3, null);
                            state2 = stateCollectAsStateWithLifecycle;
                            composer7.updateRememberedValue(z17CameraKt$Z17Camera$1$3$1);
                            objRememberedValue9 = z17CameraKt$Z17Camera$1$3$1;
                        } else {
                            state2 = stateCollectAsStateWithLifecycle;
                            composer7 = composer6;
                            i21 = i20;
                            i22 = 67108864;
                            z17CameraViewModel5 = z17CameraViewModel3;
                        }
                        EffectsKt.LaunchedEffect(captureStateZ17Camera$lambda$47$lambda$17, (Function2) objRememberedValue9, composer7, 0);
                        RecordingState recordingStateZ17Camera$lambda$47$lambda$18 = Z17Camera$lambda$47$lambda$18(state);
                        state3 = state;
                        boolean zChanged2 = composer7.changed(state3);
                        if (i21 == i22) {
                            z24 = true;
                        } else {
                            z24 = false;
                        }
                        boolean z33 = zChanged2 | z24;
                        if ((i19 & 896) == 256) {
                            z25 = true;
                        } else {
                            z25 = false;
                        }
                        zChangedInstance2 = z33 | z25 | composer7.changedInstance(z17CameraViewModel5);
                        objRememberedValue10 = composer7.rememberedValue();
                        if (!zChangedInstance2 || objRememberedValue10 == companion2.getEmpty()) {
                            MutableLongState mutableLongState4 = mutableLongState2;
                            Z17CameraKt$Z17Camera$1$4$1 z17CameraKt$Z17Camera$1$4$1 = new Z17CameraKt$Z17Camera$1$4$1(onResult, videoPathToSave, z17CameraViewModel5, state3, mutableLongState4, mutableFloatState3, null);
                            mutableLongState3 = mutableLongState4;
                            composer7.updateRememberedValue(z17CameraKt$Z17Camera$1$4$1);
                            objRememberedValue10 = z17CameraKt$Z17Camera$1$4$1;
                        } else {
                            mutableLongState3 = mutableLongState2;
                        }
                        EffectsKt.LaunchedEffect(recordingStateZ17Camera$lambda$47$lambda$18, (Function2) objRememberedValue10, composer7, 0);
                        zChangedInstance3 = composer7.changedInstance(previewView);
                        objRememberedValue11 = composer7.rememberedValue();
                        if (zChangedInstance3 || objRememberedValue11 == companion2.getEmpty()) {
                            objRememberedValue11 = new Function1() { // from class: cu.z17.views.camera.b
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return Z17CameraKt.Z17Camera$lambda$47$lambda$24$lambda$23(previewView, (Context) obj);
                                }
                            };
                            composer7.updateRememberedValue(objRememberedValue11);
                        }
                        companion3 = Modifier.INSTANCE;
                        composer8 = composer7;
                        AndroidView_androidKt.AndroidView((Function1) objRememberedValue11, SizeKt.fillMaxSize$default(companion3, 0.0f, 1, null), null, composer8, 48, 4);
                        if (z17) {
                            composer8.startReplaceGroup(-1432532383);
                            Modifier modifierAlign = boxScopeInstance.align(WindowInsetsPadding_androidKt.safeContentPadding(companion3), companion.getTopStart());
                            boolean zChangedInstance9 = composer8.changedInstance(z17CameraViewModel5);
                            if ((29360128 & i19) == 8388608) {
                                z30 = true;
                            } else {
                                z30 = false;
                            }
                            z31 = zChangedInstance9 | z30;
                            objRememberedValue15 = composer8.rememberedValue();
                            if (z31 || objRememberedValue15 == companion2.getEmpty()) {
                                objRememberedValue15 = new lb.a() { // from class: cu.z17.views.camera.e
                                    @Override // lb.a
                                    public final Object invoke() {
                                        return Z17CameraKt.Z17Camera$lambda$47$lambda$26$lambda$25(z17CameraViewModel5, onClose);
                                    }
                                };
                                composer8.updateRememberedValue(objRememberedValue15);
                            }
                            IconButtonKt.IconButton((lb.a) objRememberedValue15, modifierAlign, false, null, null, ComposableSingletons$Z17CameraKt.INSTANCE.m10134getLambda$1809404936$views_release(), composer8, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 28);
                            composer4 = composer8;
                        } else {
                            composer4 = composer8;
                            composer4.startReplaceGroup(-1439926782);
                        }
                        composer4.endReplaceGroup();
                        if (z18 != 0) {
                            composer4.startReplaceGroup(-1431891179);
                            String strConvertToMS = Z17InlineUtilsKt.convertToMS(mutableLongState3.getLongValue());
                            Modifier modifierM1725padding3ABfNKs = PaddingKt.m1725padding3ABfNKs(r43.align(companion3, companion.getTopEnd()), Dp.m8823constructorimpl(20));
                            Color.Companion companion6 = Color.INSTANCE;
                            float f11 = 5;
                            Z17LabelKt.m10262Z17LabelfWhpE4E(PaddingKt.m1726paddingVpY3zN4(BackgroundKt.m1204backgroundbw27NRU(modifierM1725padding3ABfNKs, companion6.m5892getBlack0d7_KjU(), RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(f11))), Dp.m8823constructorimpl(f11), Dp.m8823constructorimpl(3)), strConvertToMS, null, companion6.m5903getWhite0d7_KjU(), 0, 0, composer4, 3072, 52);
                        } else {
                            composer4.startReplaceGroup(-1439926782);
                        }
                        composer4.endReplaceGroup();
                        float f12 = 20;
                        Modifier modifierM1729paddingqDBjuR0$default = PaddingKt.m1729paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(r43.align(companion3, companion.getBottomCenter()), 0.0f, 1, null), Dp.m8823constructorimpl(f12), 0.0f, Dp.m8823constructorimpl(f12), Dp.m8823constructorimpl(f12), 2, null);
                        MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getSpaceBetween(), companion.getCenterVertically(), composer4, 54);
                        currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                        CompositionLocalMap currentCompositionLocalMap2 = composer4.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer4, modifierM1729paddingqDBjuR0$default);
                        constructor2 = companion5.getConstructor();
                        if (!r.a(composer4.getApplier())) {
                            ComposablesKt.invalidApplier();
                        }
                        composer4.startReusableNode();
                        if (composer4.getInserting()) {
                            composer4.createNode(constructor2);
                        } else {
                            composer4.useNode();
                        }
                        composerM5176constructorimpl2 = Updater.m5176constructorimpl(composer4);
                        Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyRowMeasurePolicy, companion5.getSetMeasurePolicy());
                        Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap2, companion5.getSetResolvedCompositionLocals());
                        setCompositeKeyHash2 = companion5.getSetCompositeKeyHash();
                        if (composerM5176constructorimpl2.getInserting() || !y.d(composerM5176constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                            composerM5176constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                            composerM5176constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                        }
                        Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier2, companion5.getSetModifier());
                        RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                        MaterialTheme materialTheme = MaterialTheme.INSTANCE;
                        int i33 = MaterialTheme.$stable;
                        f10 = 10;
                        Modifier modifierClip = ClipKt.clip(PaddingKt.m1725padding3ABfNKs(BackgroundKt.m1204backgroundbw27NRU(companion3, Color.m5865copywmQWz5c$default(materialTheme.getColorScheme(composer4, i33).getBackground(), 0.3f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.getCircleShape()), Dp.m8823constructorimpl(f10)), RoundedCornerShapeKt.getCircleShape());
                        zChangedInstance4 = composer4.changedInstance(z17CameraViewModel5);
                        objRememberedValue12 = composer4.rememberedValue();
                        if (!zChangedInstance4 || objRememberedValue12 == companion2.getEmpty()) {
                            mutableState2 = mutableState;
                            objRememberedValue12 = new lb.a() { // from class: cu.z17.views.camera.f
                                @Override // lb.a
                                public final Object invoke() {
                                    return Z17CameraKt.Z17Camera$lambda$47$lambda$42$lambda$28$lambda$27(z17CameraViewModel5, mutableState2);
                                }
                            };
                            composer4.updateRememberedValue(objRememberedValue12);
                        } else {
                            mutableState2 = mutableState;
                        }
                        Modifier modifierM1238clickableXHw0xAI$default = ClickableKt.m1238clickableXHw0xAI$default(modifierClip, false, null, null, (lb.a) objRememberedValue12, 7, null);
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(companion.getCenter(), false);
                        currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                        CompositionLocalMap currentCompositionLocalMap3 = composer4.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composer4, modifierM1238clickableXHw0xAI$default);
                        constructor3 = companion5.getConstructor();
                        if (!r.a(composer4.getApplier())) {
                            ComposablesKt.invalidApplier();
                        }
                        composer4.startReusableNode();
                        if (composer4.getInserting()) {
                            composer4.createNode(constructor3);
                        } else {
                            composer4.useNode();
                        }
                        composerM5176constructorimpl3 = Updater.m5176constructorimpl(composer4);
                        Updater.m5184setimpl(composerM5176constructorimpl3, measurePolicyMaybeCachedBoxMeasurePolicy2, companion5.getSetMeasurePolicy());
                        Updater.m5184setimpl(composerM5176constructorimpl3, currentCompositionLocalMap3, companion5.getSetResolvedCompositionLocals());
                        setCompositeKeyHash3 = companion5.getSetCompositeKeyHash();
                        if (composerM5176constructorimpl3.getInserting() || !y.d(composerM5176constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                            composerM5176constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                            composerM5176constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                        }
                        Updater.m5184setimpl(composerM5176constructorimpl3, modifierMaterializeModifier3, companion5.getSetModifier());
                        Modifier modifierM1769size3ABfNKs = SizeKt.m1769size3ABfNKs(companion3, Dp.m8823constructorimpl(25));
                        if (Z17Camera$lambda$47$lambda$2(mutableState2)) {
                            flashOff = FlashOnKt.getFlashOn(Icons.Outlined.INSTANCE);
                        } else {
                            flashOff = FlashOffKt.getFlashOff(Icons.Outlined.INSTANCE);
                        }
                        Z17PictureKt.m10278Z17BasePictureC8z9wKI(modifierM1769size3ABfNKs, flashOff, null, ColorFilter.Companion.m5907tintxETnrds$default(ColorFilter.INSTANCE, materialTheme.getColorScheme(composer4, i33).getOnBackground(), 0, 2, null), null, null, 0, null, null, composer4, 6, XMPPTCPConnection.PacketWriter.QUEUE_SIZE);
                        composer4.endNode();
                        if (Z17Camera$lambda$47$lambda$18(state3) != RecordingState.RECORDING || Z17Camera$lambda$47$lambda$18(state3) == RecordingState.PAUSE) {
                            z26 = true;
                        } else {
                            z26 = false;
                        }
                        AnimatedVisibilityKt.AnimatedVisibility(rowScopeInstance, z26, (Modifier) null, (EnterTransition) null, (ExitTransition) null, (String) null, ComposableLambdaKt.rememberComposableLambda(-381832644, true, new Function3() { // from class: cu.z17.views.camera.g
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return Z17CameraKt.Z17Camera$lambda$47$lambda$42$lambda$33(state3, z17CameraViewModel5, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composer4, 54), composer4, 1572870, 30);
                        float fM8823constructorimpl2 = Dp.m8823constructorimpl(4);
                        companion4 = Color.INSTANCE;
                        Modifier modifierM1216borderxT4_qwU = BorderKt.m1216borderxT4_qwU(companion3, fM8823constructorimpl2, companion4.m5903getWhite0d7_KjU(), RoundedCornerShapeKt.getCircleShape());
                        if (z18 != 0) {
                            fM8823constructorimpl = Dp.m8823constructorimpl(f10);
                        } else {
                            fM8823constructorimpl = Dp.m8823constructorimpl(5);
                        }
                        Modifier modifierM1725padding3ABfNKs2 = PaddingKt.m1725padding3ABfNKs(modifierM1216borderxT4_qwU, fM8823constructorimpl);
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(companion.getCenter(), false);
                        currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                        CompositionLocalMap currentCompositionLocalMap4 = composer4.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composer4, modifierM1725padding3ABfNKs2);
                        constructor4 = companion5.getConstructor();
                        if (!r.a(composer4.getApplier())) {
                            ComposablesKt.invalidApplier();
                        }
                        composer4.startReusableNode();
                        if (composer4.getInserting()) {
                            composer4.createNode(constructor4);
                        } else {
                            composer4.useNode();
                        }
                        composerM5176constructorimpl4 = Updater.m5176constructorimpl(composer4);
                        Updater.m5184setimpl(composerM5176constructorimpl4, measurePolicyMaybeCachedBoxMeasurePolicy3, companion5.getSetMeasurePolicy());
                        Updater.m5184setimpl(composerM5176constructorimpl4, currentCompositionLocalMap4, companion5.getSetResolvedCompositionLocals());
                        setCompositeKeyHash4 = companion5.getSetCompositeKeyHash();
                        if (composerM5176constructorimpl4.getInserting() || !y.d(composerM5176constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                            composerM5176constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                            composerM5176constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
                        }
                        Updater.m5184setimpl(composerM5176constructorimpl4, modifierMaterializeModifier4, companion5.getSetModifier());
                        Modifier modifierBounceClick = Z17ButtonsKt.bounceClick(companion3);
                        i23 = i19 & 7168;
                        if (i23 == 2048) {
                            z27 = true;
                        } else {
                            z27 = false;
                        }
                        context4 = context5;
                        zChangedInstance5 = z27 | composer4.changedInstance(z17CameraViewModel5) | composer4.changedInstance(context4) | composer4.changed(state3);
                        objRememberedValue13 = composer4.rememberedValue();
                        if (!zChangedInstance5 || objRememberedValue13 == companion2.getEmpty()) {
                            z19 = z18;
                            objRememberedValue13 = new lb.a() { // from class: cu.z17.views.camera.h
                                @Override // lb.a
                                public final Object invoke() {
                                    return Z17CameraKt.Z17Camera$lambda$47$lambda$42$lambda$37$lambda$35$lambda$34(z19, z17CameraViewModel5, context4, state3);
                                }
                            };
                            composer4.updateRememberedValue(objRememberedValue13);
                        } else {
                            z19 = z18;
                        }
                        IconButtonKt.IconButton((lb.a) objRememberedValue13, modifierBounceClick, false, null, null, ComposableLambdaKt.rememberComposableLambda(1107306238, true, new Function2() { // from class: cu.z17.views.camera.i
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return Z17CameraKt.Z17Camera$lambda$47$lambda$42$lambda$37$lambda$36(z19, state3, stateAnimateFloatAsState, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composer4, 54), composer4, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 28);
                        composer4.endNode();
                        if (z19 || Z17Camera$lambda$47$lambda$18(state3) == RecordingState.NOT_REQUESTED) {
                            z28 = true;
                        } else {
                            z28 = false;
                        }
                        final boolean z34 = z19;
                        final Z17CameraViewModel z17CameraViewModel6 = z17CameraViewModel5;
                        lifecycleOwner5 = lifecycleOwner2;
                        AnimatedVisibilityKt.AnimatedVisibility(rowScopeInstance, z28, (Modifier) null, (EnterTransition) null, (ExitTransition) null, (String) null, ComposableLambdaKt.rememberComposableLambda(-892834829, true, new Function3() { // from class: cu.z17.views.camera.j
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return Z17CameraKt.Z17Camera$lambda$47$lambda$42$lambda$41(z34, z17CameraViewModel6, previewView, lifecycleOwner5, mutableState3, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composer4, 54), composer4, 1572870, 30);
                        composer4.endNode();
                        if (Z17Camera$lambda$47$lambda$17(state2) == CaptureState.SAVING) {
                            composer4.startReplaceGroup(-1015799063);
                            z29 = true;
                            i24 = 6;
                            BoxKt.Box(BackgroundKt.m1205backgroundbw27NRU$default(SizeKt.fillMaxSize$default(companion3, 0.0f, 1, null), Color.m5865copywmQWz5c$default(companion4.m5892getBlack0d7_KjU(), 0.2f, 0.0f, 0.0f, 0.0f, 14, null), null, 2, null), composer4, 6);
                        } else {
                            i24 = 6;
                            z29 = true;
                            composer4.startReplaceGroup(-1439926782);
                        }
                        composer4.endReplaceGroup();
                        Boolean boolValueOf = Boolean.valueOf(z19);
                        if (i23 != 2048) {
                            z29 = false;
                        }
                        zChangedInstance6 = composer4.changedInstance(z17CameraViewModel5) | z29 | composer4.changedInstance(previewView) | composer4.changedInstance(lifecycleOwner5);
                        Object objRememberedValue16 = composer4.rememberedValue();
                        if (!zChangedInstance6 || objRememberedValue16 == companion2.getEmpty()) {
                            Z17CameraViewModel z17CameraViewModel7 = z17CameraViewModel5;
                            lifecycleOwner4 = lifecycleOwner5;
                            z17CameraKt$Z17Camera$1$8$1 = new Z17CameraKt$Z17Camera$1$8$1(z19, z17CameraViewModel7, previewView, lifecycleOwner4, null);
                            z17CameraViewModel4 = z17CameraViewModel7;
                            composer4.updateRememberedValue(z17CameraKt$Z17Camera$1$8$1);
                        } else {
                            z17CameraKt$Z17Camera$1$8$1 = objRememberedValue16;
                            z17CameraViewModel4 = z17CameraViewModel5;
                            lifecycleOwner4 = lifecycleOwner5;
                        }
                        EffectsKt.LaunchedEffect(boolValueOf, (Function2) z17CameraKt$Z17Camera$1$8$1, composer4, (i19 >> 9) & 14);
                        zChangedInstance7 = composer4.changedInstance(configuration) | composer4.changedInstance(context4);
                        objRememberedValue14 = composer4.rememberedValue();
                        if (zChangedInstance7 || objRememberedValue14 == companion2.getEmpty()) {
                            objRememberedValue14 = new Function1() { // from class: cu.z17.views.camera.k
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return Z17CameraKt.Z17Camera$lambda$47$lambda$46$lambda$45(configuration, context4, (DisposableEffectScope) obj);
                                }
                            };
                            composer4.updateRememberedValue(objRememberedValue14);
                        }
                        EffectsKt.DisposableEffect(k0Var, (Function1) objRememberedValue14, composer4, i24);
                        composer4.endNode();
                    } else {
                        z17CameraViewModel4 = z17CameraViewModel3;
                        context4 = context2;
                        modifier4 = modifier4;
                        z19 = z18;
                        composer4 = composer3;
                        lifecycleOwner4 = lifecycleOwner2;
                        composer4.startReplaceGroup(125040547);
                    }
                    composer4.endReplaceGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer2 = composer4;
                    z15 = z19;
                    context3 = context4;
                    lifecycleOwner3 = lifecycleOwner4;
                    modifier2 = modifier4;
                    z14 = z17;
                    z17CameraViewModel2 = z17CameraViewModel4;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier2 = modifier;
                    z14 = z11;
                    composer2 = composerStartRestartGroup;
                    context3 = context2;
                    lifecycleOwner3 = lifecycleOwner2;
                    z15 = z12;
                    z17CameraViewModel2 = z17CameraViewModel;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.camera.l
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return Z17CameraKt.Z17Camera$lambda$48(modifier2, imagePathToSave, videoPathToSave, z15, lifecycleOwner3, z17CameraViewModel2, context3, onClose, onResult, onError, z14, i10, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i17 = i11 | 6;
            i15 = i17;
            if ((i13 & 306783379) == 306783378) {
                z13 = true;
            } else {
                z13 = true;
            }
            if (composerStartRestartGroup.shouldExecute(z13, i13 & 1)) {
                composerStartRestartGroup.startDefaults();
                if ((i10 & 1) != 0) {
                    if (i30 != 0) {
                        modifier3 = Modifier.INSTANCE;
                    } else {
                        modifier3 = modifier;
                    }
                    if (i31 != 0) {
                        z16 = false;
                    } else {
                        z16 = z12;
                    }
                    if ((i12 & 16) != 0) {
                        lifecycleOwner2 = (LifecycleOwner) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner());
                        i13 &= -57345;
                    }
                    if ((i12 & 32) != 0) {
                        str = imagePathToSave + videoPathToSave;
                        z17CameraViewModelFactory = new Z17CameraViewModelFactory(imagePathToSave, videoPathToSave);
                        current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composerStartRestartGroup, 6);
                        if (current == null) {
                            throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                        }
                        if (current instanceof HasDefaultViewModelProviderFactory) {
                            defaultViewModelCreationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                        } else {
                            defaultViewModelCreationExtras = CreationExtras.Empty.INSTANCE;
                        }
                        ViewModel viewModel2 = ViewModelKt.viewModel(z0.b(Z17CameraViewModel.class), current, str, z17CameraViewModelFactory, defaultViewModelCreationExtras, composerStartRestartGroup, 0, 0);
                        composer3 = composerStartRestartGroup;
                        z17CameraViewModel3 = (Z17CameraViewModel) viewModel2;
                        i13 &= -458753;
                    } else {
                        composer3 = composerStartRestartGroup;
                        z17CameraViewModel3 = z17CameraViewModel;
                    }
                    if ((i12 & 64) != 0) {
                        context2 = (Context) composer3.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                        i13 &= -3670017;
                    }
                    if (i14 != 0) {
                        z17 = true;
                    } else {
                        z17 = z11;
                    }
                    modifier4 = modifier3;
                    i18 = i13;
                    z18 = z16;
                } else {
                    if (i30 != 0) {
                        modifier3 = Modifier.INSTANCE;
                    } else {
                        modifier3 = modifier;
                    }
                    if (i31 != 0) {
                        z16 = false;
                    } else {
                        z16 = z12;
                    }
                    if ((i12 & 16) != 0) {
                        lifecycleOwner2 = (LifecycleOwner) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner());
                        i13 &= -57345;
                    }
                    if ((i12 & 32) != 0) {
                        str = imagePathToSave + videoPathToSave;
                        z17CameraViewModelFactory = new Z17CameraViewModelFactory(imagePathToSave, videoPathToSave);
                        current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composerStartRestartGroup, 6);
                        if (current == null) {
                            throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                        }
                        if (current instanceof HasDefaultViewModelProviderFactory) {
                            defaultViewModelCreationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                        } else {
                            defaultViewModelCreationExtras = CreationExtras.Empty.INSTANCE;
                        }
                        ViewModel viewModel3 = ViewModelKt.viewModel(z0.b(Z17CameraViewModel.class), current, str, z17CameraViewModelFactory, defaultViewModelCreationExtras, composerStartRestartGroup, 0, 0);
                        composer3 = composerStartRestartGroup;
                        z17CameraViewModel3 = (Z17CameraViewModel) viewModel3;
                        i13 &= -458753;
                    } else {
                        composer3 = composerStartRestartGroup;
                        z17CameraViewModel3 = z17CameraViewModel;
                    }
                    if ((i12 & 64) != 0) {
                        context2 = (Context) composer3.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                        i13 &= -3670017;
                    }
                    if (i14 != 0) {
                        z17 = true;
                    } else {
                        z17 = z11;
                    }
                    modifier4 = modifier3;
                    i18 = i13;
                    z18 = z16;
                }
                composer3.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1860373471, i18, i15, "cu.z17.views.camera.Z17Camera (Z17Camera.kt:85)");
                }
                if (Z17CameraModule.INSTANCE.getInstance().getCanUseCamera()) {
                    composer3.startReplaceGroup(1112544640);
                    companion = Alignment.INSTANCE;
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy4 = BoxKt.maybeCachedBoxMeasurePolicy(companion.getTopStart(), false);
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                    CompositionLocalMap currentCompositionLocalMap5 = composer3.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier5 = ComposedModifierKt.materializeModifier(composer3, modifier4);
                    ComposeUiNode.Companion companion7 = ComposeUiNode.INSTANCE;
                    constructor = companion7.getConstructor();
                    if (!r.a(composer3.getApplier())) {
                        ComposablesKt.invalidApplier();
                    }
                    composer3.startReusableNode();
                    if (composer3.getInserting()) {
                        composer3.createNode(constructor);
                    } else {
                        composer3.useNode();
                    }
                    composerM5176constructorimpl = Updater.m5176constructorimpl(composer3);
                    i19 = i18;
                    Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy4, companion7.getSetMeasurePolicy());
                    Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap5, companion7.getSetResolvedCompositionLocals());
                    setCompositeKeyHash = companion7.getSetCompositeKeyHash();
                    if (composerM5176constructorimpl.getInserting()) {
                        composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    } else {
                        composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier5, companion7.getSetModifier());
                    boxScopeInstance = BoxScopeInstance.INSTANCE;
                    configuration = (Configuration) composer3.consume(AndroidCompositionLocals_androidKt.getLocalConfiguration());
                    objRememberedValue = composer3.rememberedValue();
                    companion2 = Composer.INSTANCE;
                    if (objRememberedValue == companion2.getEmpty()) {
                        objRememberedValue = new PreviewView(context2);
                        composer3.updateRememberedValue(objRememberedValue);
                    }
                    previewView = (PreviewView) objRememberedValue;
                    objRememberedValue2 = composer3.rememberedValue();
                    if (objRememberedValue2 == companion2.getEmpty()) {
                        objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                        composer3.updateRememberedValue(objRememberedValue2);
                    }
                    mutableState = (MutableState) objRememberedValue2;
                    objRememberedValue3 = composer3.rememberedValue();
                    if (objRememberedValue3 == companion2.getEmpty()) {
                        objRememberedValue3 = SnapshotLongStateKt.mutableLongStateOf(0L);
                        composer3.updateRememberedValue(objRememberedValue3);
                    }
                    mutableLongState = (MutableLongState) objRememberedValue3;
                    objRememberedValue4 = composer3.rememberedValue();
                    if (objRememberedValue4 == companion2.getEmpty()) {
                        objRememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                        composer3.updateRememberedValue(objRememberedValue4);
                    }
                    final MutableState mutableState4 = (MutableState) objRememberedValue4;
                    objRememberedValue5 = composer3.rememberedValue();
                    if (objRememberedValue5 == companion2.getEmpty()) {
                        objRememberedValue5 = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
                        composer3.updateRememberedValue(objRememberedValue5);
                    }
                    mutableFloatState = (MutableFloatState) objRememberedValue5;
                    objRememberedValue6 = composer3.rememberedValue();
                    if (objRememberedValue6 == companion2.getEmpty()) {
                        objRememberedValue6 = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
                        composer3.updateRememberedValue(objRememberedValue6);
                    }
                    mutableFloatState2 = (MutableFloatState) objRememberedValue6;
                    composer5 = composer3;
                    final State stateAnimateFloatAsState2 = AnimateAsStateKt.animateFloatAsState(mutableFloatState2.getFloatValue(), null, 0.0f, "ar", null, composer5, 3072, 22);
                    stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(z17CameraViewModel3.getCaptureResult(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composer5, 0, 7);
                    stateCollectAsStateWithLifecycle2 = FlowExtKt.collectAsStateWithLifecycle(z17CameraViewModel3.getRecordingResult(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composer5, 0, 7);
                    Float fValueOf2 = Float.valueOf(mutableFloatState.getFloatValue());
                    objRememberedValue7 = composer5.rememberedValue();
                    if (objRememberedValue7 == companion2.getEmpty()) {
                        objRememberedValue7 = new Z17CameraKt$Z17Camera$1$1$1(mutableFloatState, mutableFloatState2, null);
                        composer6 = composer5;
                        composer6.updateRememberedValue(objRememberedValue7);
                    } else {
                        composer6 = composer5;
                    }
                    EffectsKt.LaunchedEffect(fValueOf2, (Function2) objRememberedValue7, composer6, 0);
                    k0 k0Var2 = k0.f43947a;
                    zChangedInstance = composer6.changedInstance(context2) | composer6.changed(stateCollectAsStateWithLifecycle2);
                    objRememberedValue8 = composer6.rememberedValue();
                    if (zChangedInstance) {
                        state = stateCollectAsStateWithLifecycle2;
                        mutableLongState2 = mutableLongState;
                        context5 = context2;
                        Z17CameraKt$Z17Camera$1$2$1 z17CameraKt$Z17Camera$1$2$2 = new Z17CameraKt$Z17Camera$1$2$1(context5, mutableFloatState, state, mutableLongState2, null);
                        mutableFloatState3 = mutableFloatState;
                        composer6.updateRememberedValue(z17CameraKt$Z17Camera$1$2$2);
                        objRememberedValue8 = z17CameraKt$Z17Camera$1$2$2;
                    } else {
                        state = stateCollectAsStateWithLifecycle2;
                        mutableLongState2 = mutableLongState;
                        context5 = context2;
                        Z17CameraKt$Z17Camera$1$2$1 z17CameraKt$Z17Camera$1$2$3 = new Z17CameraKt$Z17Camera$1$2$1(context5, mutableFloatState, state, mutableLongState2, null);
                        mutableFloatState3 = mutableFloatState;
                        composer6.updateRememberedValue(z17CameraKt$Z17Camera$1$2$3);
                        objRememberedValue8 = z17CameraKt$Z17Camera$1$2$3;
                    }
                    EffectsKt.LaunchedEffect(k0Var2, (Function2) objRememberedValue8, composer6, 6);
                    CaptureState captureStateZ17Camera$lambda$47$lambda$18 = Z17Camera$lambda$47$lambda$17(stateCollectAsStateWithLifecycle);
                    boolean zChanged3 = composer6.changed(stateCollectAsStateWithLifecycle);
                    i20 = i19 & 234881024;
                    if (i20 == 67108864) {
                        z20 = true;
                    } else {
                        z20 = false;
                    }
                    boolean z35 = zChanged3 | z20;
                    if ((i19 & 112) == 32) {
                        z21 = true;
                    } else {
                        z21 = false;
                    }
                    boolean zChangedInstance10 = z35 | z21 | composer6.changedInstance(z17CameraViewModel3);
                    if ((i19 & C.ENCODING_PCM_DOUBLE) == 536870912) {
                        z22 = true;
                    } else {
                        z22 = false;
                    }
                    z23 = zChangedInstance10 | z22;
                    objRememberedValue9 = composer6.rememberedValue();
                    if (z23) {
                        composer7 = composer6;
                        i21 = i20;
                        i22 = 67108864;
                        z17CameraViewModel5 = z17CameraViewModel3;
                        Z17CameraKt$Z17Camera$1$3$1 z17CameraKt$Z17Camera$1$3$2 = new Z17CameraKt$Z17Camera$1$3$1(onResult, imagePathToSave, z17CameraViewModel5, onError, stateCollectAsStateWithLifecycle, mutableFloatState3, null);
                        state2 = stateCollectAsStateWithLifecycle;
                        composer7.updateRememberedValue(z17CameraKt$Z17Camera$1$3$2);
                        objRememberedValue9 = z17CameraKt$Z17Camera$1$3$2;
                    } else {
                        composer7 = composer6;
                        i21 = i20;
                        i22 = 67108864;
                        z17CameraViewModel5 = z17CameraViewModel3;
                        Z17CameraKt$Z17Camera$1$3$1 z17CameraKt$Z17Camera$1$3$3 = new Z17CameraKt$Z17Camera$1$3$1(onResult, imagePathToSave, z17CameraViewModel5, onError, stateCollectAsStateWithLifecycle, mutableFloatState3, null);
                        state2 = stateCollectAsStateWithLifecycle;
                        composer7.updateRememberedValue(z17CameraKt$Z17Camera$1$3$3);
                        objRememberedValue9 = z17CameraKt$Z17Camera$1$3$3;
                    }
                    EffectsKt.LaunchedEffect(captureStateZ17Camera$lambda$47$lambda$18, (Function2) objRememberedValue9, composer7, 0);
                    RecordingState recordingStateZ17Camera$lambda$47$lambda$19 = Z17Camera$lambda$47$lambda$18(state);
                    state3 = state;
                    boolean zChanged4 = composer7.changed(state3);
                    if (i21 == i22) {
                        z24 = true;
                    } else {
                        z24 = false;
                    }
                    boolean z36 = zChanged4 | z24;
                    if ((i19 & 896) == 256) {
                        z25 = true;
                    } else {
                        z25 = false;
                    }
                    zChangedInstance2 = z36 | z25 | composer7.changedInstance(z17CameraViewModel5);
                    objRememberedValue10 = composer7.rememberedValue();
                    if (zChangedInstance2) {
                        MutableLongState mutableLongState5 = mutableLongState2;
                        Z17CameraKt$Z17Camera$1$4$1 z17CameraKt$Z17Camera$1$4$2 = new Z17CameraKt$Z17Camera$1$4$1(onResult, videoPathToSave, z17CameraViewModel5, state3, mutableLongState5, mutableFloatState3, null);
                        mutableLongState3 = mutableLongState5;
                        composer7.updateRememberedValue(z17CameraKt$Z17Camera$1$4$2);
                        objRememberedValue10 = z17CameraKt$Z17Camera$1$4$2;
                    } else {
                        MutableLongState mutableLongState6 = mutableLongState2;
                        Z17CameraKt$Z17Camera$1$4$1 z17CameraKt$Z17Camera$1$4$3 = new Z17CameraKt$Z17Camera$1$4$1(onResult, videoPathToSave, z17CameraViewModel5, state3, mutableLongState6, mutableFloatState3, null);
                        mutableLongState3 = mutableLongState6;
                        composer7.updateRememberedValue(z17CameraKt$Z17Camera$1$4$3);
                        objRememberedValue10 = z17CameraKt$Z17Camera$1$4$3;
                    }
                    EffectsKt.LaunchedEffect(recordingStateZ17Camera$lambda$47$lambda$19, (Function2) objRememberedValue10, composer7, 0);
                    zChangedInstance3 = composer7.changedInstance(previewView);
                    objRememberedValue11 = composer7.rememberedValue();
                    if (zChangedInstance3) {
                        objRememberedValue11 = new Function1() { // from class: cu.z17.views.camera.b
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return Z17CameraKt.Z17Camera$lambda$47$lambda$24$lambda$23(previewView, (Context) obj);
                            }
                        };
                        composer7.updateRememberedValue(objRememberedValue11);
                    } else {
                        objRememberedValue11 = new Function1() { // from class: cu.z17.views.camera.b
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return Z17CameraKt.Z17Camera$lambda$47$lambda$24$lambda$23(previewView, (Context) obj);
                            }
                        };
                        composer7.updateRememberedValue(objRememberedValue11);
                    }
                    companion3 = Modifier.INSTANCE;
                    composer8 = composer7;
                    AndroidView_androidKt.AndroidView((Function1) objRememberedValue11, SizeKt.fillMaxSize$default(companion3, 0.0f, 1, null), null, composer8, 48, 4);
                    if (z17) {
                        composer8.startReplaceGroup(-1432532383);
                        Modifier modifierAlign2 = boxScopeInstance.align(WindowInsetsPadding_androidKt.safeContentPadding(companion3), companion.getTopStart());
                        boolean zChangedInstance11 = composer8.changedInstance(z17CameraViewModel5);
                        if ((29360128 & i19) == 8388608) {
                            z30 = true;
                        } else {
                            z30 = false;
                        }
                        z31 = zChangedInstance11 | z30;
                        objRememberedValue15 = composer8.rememberedValue();
                        if (z31) {
                            objRememberedValue15 = new lb.a() { // from class: cu.z17.views.camera.e
                                @Override // lb.a
                                public final Object invoke() {
                                    return Z17CameraKt.Z17Camera$lambda$47$lambda$26$lambda$25(z17CameraViewModel5, onClose);
                                }
                            };
                            composer8.updateRememberedValue(objRememberedValue15);
                        } else {
                            objRememberedValue15 = new lb.a() { // from class: cu.z17.views.camera.e
                                @Override // lb.a
                                public final Object invoke() {
                                    return Z17CameraKt.Z17Camera$lambda$47$lambda$26$lambda$25(z17CameraViewModel5, onClose);
                                }
                            };
                            composer8.updateRememberedValue(objRememberedValue15);
                        }
                        IconButtonKt.IconButton((lb.a) objRememberedValue15, modifierAlign2, false, null, null, ComposableSingletons$Z17CameraKt.INSTANCE.m10134getLambda$1809404936$views_release(), composer8, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 28);
                        composer4 = composer8;
                    } else {
                        composer4 = composer8;
                        composer4.startReplaceGroup(-1439926782);
                    }
                    composer4.endReplaceGroup();
                    if (z18 != 0) {
                        composer4.startReplaceGroup(-1431891179);
                        String strConvertToMS2 = Z17InlineUtilsKt.convertToMS(mutableLongState3.getLongValue());
                        Modifier modifierM1725padding3ABfNKs3 = PaddingKt.m1725padding3ABfNKs(r43.align(companion3, companion.getTopEnd()), Dp.m8823constructorimpl(20));
                        Color.Companion companion8 = Color.INSTANCE;
                        float f13 = 5;
                        Z17LabelKt.m10262Z17LabelfWhpE4E(PaddingKt.m1726paddingVpY3zN4(BackgroundKt.m1204backgroundbw27NRU(modifierM1725padding3ABfNKs3, companion8.m5892getBlack0d7_KjU(), RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(f13))), Dp.m8823constructorimpl(f13), Dp.m8823constructorimpl(3)), strConvertToMS2, null, companion8.m5903getWhite0d7_KjU(), 0, 0, composer4, 3072, 52);
                    } else {
                        composer4.startReplaceGroup(-1439926782);
                    }
                    composer4.endReplaceGroup();
                    float f14 = 20;
                    Modifier modifierM1729paddingqDBjuR0$default2 = PaddingKt.m1729paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(r43.align(companion3, companion.getBottomCenter()), 0.0f, 1, null), Dp.m8823constructorimpl(f14), 0.0f, Dp.m8823constructorimpl(f14), Dp.m8823constructorimpl(f14), 2, null);
                    MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getSpaceBetween(), companion.getCenterVertically(), composer4, 54);
                    currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                    CompositionLocalMap currentCompositionLocalMap6 = composer4.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier6 = ComposedModifierKt.materializeModifier(composer4, modifierM1729paddingqDBjuR0$default2);
                    constructor2 = companion7.getConstructor();
                    if (!r.a(composer4.getApplier())) {
                        ComposablesKt.invalidApplier();
                    }
                    composer4.startReusableNode();
                    if (composer4.getInserting()) {
                        composer4.createNode(constructor2);
                    } else {
                        composer4.useNode();
                    }
                    composerM5176constructorimpl2 = Updater.m5176constructorimpl(composer4);
                    Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyRowMeasurePolicy2, companion7.getSetMeasurePolicy());
                    Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap6, companion7.getSetResolvedCompositionLocals());
                    setCompositeKeyHash2 = companion7.getSetCompositeKeyHash();
                    if (composerM5176constructorimpl2.getInserting()) {
                        composerM5176constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                        composerM5176constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                    } else {
                        composerM5176constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                        composerM5176constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                    }
                    Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier6, companion7.getSetModifier());
                    RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
                    MaterialTheme materialTheme2 = MaterialTheme.INSTANCE;
                    int i34 = MaterialTheme.$stable;
                    f10 = 10;
                    Modifier modifierClip2 = ClipKt.clip(PaddingKt.m1725padding3ABfNKs(BackgroundKt.m1204backgroundbw27NRU(companion3, Color.m5865copywmQWz5c$default(materialTheme2.getColorScheme(composer4, i34).getBackground(), 0.3f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.getCircleShape()), Dp.m8823constructorimpl(f10)), RoundedCornerShapeKt.getCircleShape());
                    zChangedInstance4 = composer4.changedInstance(z17CameraViewModel5);
                    objRememberedValue12 = composer4.rememberedValue();
                    if (zChangedInstance4) {
                        mutableState2 = mutableState;
                        objRememberedValue12 = new lb.a() { // from class: cu.z17.views.camera.f
                            @Override // lb.a
                            public final Object invoke() {
                                return Z17CameraKt.Z17Camera$lambda$47$lambda$42$lambda$28$lambda$27(z17CameraViewModel5, mutableState2);
                            }
                        };
                        composer4.updateRememberedValue(objRememberedValue12);
                    } else {
                        mutableState2 = mutableState;
                        objRememberedValue12 = new lb.a() { // from class: cu.z17.views.camera.f
                            @Override // lb.a
                            public final Object invoke() {
                                return Z17CameraKt.Z17Camera$lambda$47$lambda$42$lambda$28$lambda$27(z17CameraViewModel5, mutableState2);
                            }
                        };
                        composer4.updateRememberedValue(objRememberedValue12);
                    }
                    Modifier modifierM1238clickableXHw0xAI$default2 = ClickableKt.m1238clickableXHw0xAI$default(modifierClip2, false, null, null, (lb.a) objRememberedValue12, 7, null);
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy5 = BoxKt.maybeCachedBoxMeasurePolicy(companion.getCenter(), false);
                    currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                    CompositionLocalMap currentCompositionLocalMap7 = composer4.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier7 = ComposedModifierKt.materializeModifier(composer4, modifierM1238clickableXHw0xAI$default2);
                    constructor3 = companion7.getConstructor();
                    if (!r.a(composer4.getApplier())) {
                        ComposablesKt.invalidApplier();
                    }
                    composer4.startReusableNode();
                    if (composer4.getInserting()) {
                        composer4.createNode(constructor3);
                    } else {
                        composer4.useNode();
                    }
                    composerM5176constructorimpl3 = Updater.m5176constructorimpl(composer4);
                    Updater.m5184setimpl(composerM5176constructorimpl3, measurePolicyMaybeCachedBoxMeasurePolicy5, companion7.getSetMeasurePolicy());
                    Updater.m5184setimpl(composerM5176constructorimpl3, currentCompositionLocalMap7, companion7.getSetResolvedCompositionLocals());
                    setCompositeKeyHash3 = companion7.getSetCompositeKeyHash();
                    if (composerM5176constructorimpl3.getInserting()) {
                        composerM5176constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                        composerM5176constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                    } else {
                        composerM5176constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                        composerM5176constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                    }
                    Updater.m5184setimpl(composerM5176constructorimpl3, modifierMaterializeModifier7, companion7.getSetModifier());
                    Modifier modifierM1769size3ABfNKs2 = SizeKt.m1769size3ABfNKs(companion3, Dp.m8823constructorimpl(25));
                    if (Z17Camera$lambda$47$lambda$2(mutableState2)) {
                        flashOff = FlashOnKt.getFlashOn(Icons.Outlined.INSTANCE);
                    } else {
                        flashOff = FlashOffKt.getFlashOff(Icons.Outlined.INSTANCE);
                    }
                    Z17PictureKt.m10278Z17BasePictureC8z9wKI(modifierM1769size3ABfNKs2, flashOff, null, ColorFilter.Companion.m5907tintxETnrds$default(ColorFilter.INSTANCE, materialTheme2.getColorScheme(composer4, i34).getOnBackground(), 0, 2, null), null, null, 0, null, null, composer4, 6, XMPPTCPConnection.PacketWriter.QUEUE_SIZE);
                    composer4.endNode();
                    if (Z17Camera$lambda$47$lambda$18(state3) != RecordingState.RECORDING) {
                        z26 = true;
                    } else {
                        z26 = true;
                    }
                    AnimatedVisibilityKt.AnimatedVisibility(rowScopeInstance2, z26, (Modifier) null, (EnterTransition) null, (ExitTransition) null, (String) null, ComposableLambdaKt.rememberComposableLambda(-381832644, true, new Function3() { // from class: cu.z17.views.camera.g
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return Z17CameraKt.Z17Camera$lambda$47$lambda$42$lambda$33(state3, z17CameraViewModel5, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composer4, 54), composer4, 1572870, 30);
                    float fM8823constructorimpl3 = Dp.m8823constructorimpl(4);
                    companion4 = Color.INSTANCE;
                    Modifier modifierM1216borderxT4_qwU2 = BorderKt.m1216borderxT4_qwU(companion3, fM8823constructorimpl3, companion4.m5903getWhite0d7_KjU(), RoundedCornerShapeKt.getCircleShape());
                    if (z18 != 0) {
                        fM8823constructorimpl = Dp.m8823constructorimpl(f10);
                    } else {
                        fM8823constructorimpl = Dp.m8823constructorimpl(5);
                    }
                    Modifier modifierM1725padding3ABfNKs4 = PaddingKt.m1725padding3ABfNKs(modifierM1216borderxT4_qwU2, fM8823constructorimpl);
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy6 = BoxKt.maybeCachedBoxMeasurePolicy(companion.getCenter(), false);
                    currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                    CompositionLocalMap currentCompositionLocalMap8 = composer4.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier8 = ComposedModifierKt.materializeModifier(composer4, modifierM1725padding3ABfNKs4);
                    constructor4 = companion7.getConstructor();
                    if (!r.a(composer4.getApplier())) {
                        ComposablesKt.invalidApplier();
                    }
                    composer4.startReusableNode();
                    if (composer4.getInserting()) {
                        composer4.createNode(constructor4);
                    } else {
                        composer4.useNode();
                    }
                    composerM5176constructorimpl4 = Updater.m5176constructorimpl(composer4);
                    Updater.m5184setimpl(composerM5176constructorimpl4, measurePolicyMaybeCachedBoxMeasurePolicy6, companion7.getSetMeasurePolicy());
                    Updater.m5184setimpl(composerM5176constructorimpl4, currentCompositionLocalMap8, companion7.getSetResolvedCompositionLocals());
                    setCompositeKeyHash4 = companion7.getSetCompositeKeyHash();
                    if (composerM5176constructorimpl4.getInserting()) {
                        composerM5176constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                        composerM5176constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
                    } else {
                        composerM5176constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                        composerM5176constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
                    }
                    Updater.m5184setimpl(composerM5176constructorimpl4, modifierMaterializeModifier8, companion7.getSetModifier());
                    Modifier modifierBounceClick2 = Z17ButtonsKt.bounceClick(companion3);
                    i23 = i19 & 7168;
                    if (i23 == 2048) {
                        z27 = true;
                    } else {
                        z27 = false;
                    }
                    context4 = context5;
                    zChangedInstance5 = z27 | composer4.changedInstance(z17CameraViewModel5) | composer4.changedInstance(context4) | composer4.changed(state3);
                    objRememberedValue13 = composer4.rememberedValue();
                    if (zChangedInstance5) {
                        z19 = z18;
                        objRememberedValue13 = new lb.a() { // from class: cu.z17.views.camera.h
                            @Override // lb.a
                            public final Object invoke() {
                                return Z17CameraKt.Z17Camera$lambda$47$lambda$42$lambda$37$lambda$35$lambda$34(z19, z17CameraViewModel5, context4, state3);
                            }
                        };
                        composer4.updateRememberedValue(objRememberedValue13);
                    } else {
                        z19 = z18;
                        objRememberedValue13 = new lb.a() { // from class: cu.z17.views.camera.h
                            @Override // lb.a
                            public final Object invoke() {
                                return Z17CameraKt.Z17Camera$lambda$47$lambda$42$lambda$37$lambda$35$lambda$34(z19, z17CameraViewModel5, context4, state3);
                            }
                        };
                        composer4.updateRememberedValue(objRememberedValue13);
                    }
                    IconButtonKt.IconButton((lb.a) objRememberedValue13, modifierBounceClick2, false, null, null, ComposableLambdaKt.rememberComposableLambda(1107306238, true, new Function2() { // from class: cu.z17.views.camera.i
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return Z17CameraKt.Z17Camera$lambda$47$lambda$42$lambda$37$lambda$36(z19, state3, stateAnimateFloatAsState2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composer4, 54), composer4, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 28);
                    composer4.endNode();
                    if (z19) {
                        z28 = true;
                    } else {
                        z28 = true;
                    }
                    final boolean z37 = z19;
                    final Z17CameraViewModel z17CameraViewModel8 = z17CameraViewModel5;
                    lifecycleOwner5 = lifecycleOwner2;
                    AnimatedVisibilityKt.AnimatedVisibility(rowScopeInstance2, z28, (Modifier) null, (EnterTransition) null, (ExitTransition) null, (String) null, ComposableLambdaKt.rememberComposableLambda(-892834829, true, new Function3() { // from class: cu.z17.views.camera.j
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return Z17CameraKt.Z17Camera$lambda$47$lambda$42$lambda$41(z37, z17CameraViewModel8, previewView, lifecycleOwner5, mutableState4, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composer4, 54), composer4, 1572870, 30);
                    composer4.endNode();
                    if (Z17Camera$lambda$47$lambda$17(state2) == CaptureState.SAVING) {
                        composer4.startReplaceGroup(-1015799063);
                        z29 = true;
                        i24 = 6;
                        BoxKt.Box(BackgroundKt.m1205backgroundbw27NRU$default(SizeKt.fillMaxSize$default(companion3, 0.0f, 1, null), Color.m5865copywmQWz5c$default(companion4.m5892getBlack0d7_KjU(), 0.2f, 0.0f, 0.0f, 0.0f, 14, null), null, 2, null), composer4, 6);
                    } else {
                        i24 = 6;
                        z29 = true;
                        composer4.startReplaceGroup(-1439926782);
                    }
                    composer4.endReplaceGroup();
                    Boolean boolValueOf2 = Boolean.valueOf(z19);
                    if (i23 != 2048) {
                        z29 = false;
                    }
                    zChangedInstance6 = composer4.changedInstance(z17CameraViewModel5) | z29 | composer4.changedInstance(previewView) | composer4.changedInstance(lifecycleOwner5);
                    Object objRememberedValue17 = composer4.rememberedValue();
                    if (zChangedInstance6) {
                        Z17CameraViewModel z17CameraViewModel9 = z17CameraViewModel5;
                        lifecycleOwner4 = lifecycleOwner5;
                        z17CameraKt$Z17Camera$1$8$1 = new Z17CameraKt$Z17Camera$1$8$1(z19, z17CameraViewModel9, previewView, lifecycleOwner4, null);
                        z17CameraViewModel4 = z17CameraViewModel9;
                        composer4.updateRememberedValue(z17CameraKt$Z17Camera$1$8$1);
                    } else {
                        Z17CameraViewModel z17CameraViewModel10 = z17CameraViewModel5;
                        lifecycleOwner4 = lifecycleOwner5;
                        z17CameraKt$Z17Camera$1$8$1 = new Z17CameraKt$Z17Camera$1$8$1(z19, z17CameraViewModel10, previewView, lifecycleOwner4, null);
                        z17CameraViewModel4 = z17CameraViewModel10;
                        composer4.updateRememberedValue(z17CameraKt$Z17Camera$1$8$1);
                    }
                    EffectsKt.LaunchedEffect(boolValueOf2, (Function2) z17CameraKt$Z17Camera$1$8$1, composer4, (i19 >> 9) & 14);
                    zChangedInstance7 = composer4.changedInstance(configuration) | composer4.changedInstance(context4);
                    objRememberedValue14 = composer4.rememberedValue();
                    if (zChangedInstance7) {
                        objRememberedValue14 = new Function1() { // from class: cu.z17.views.camera.k
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return Z17CameraKt.Z17Camera$lambda$47$lambda$46$lambda$45(configuration, context4, (DisposableEffectScope) obj);
                            }
                        };
                        composer4.updateRememberedValue(objRememberedValue14);
                    } else {
                        objRememberedValue14 = new Function1() { // from class: cu.z17.views.camera.k
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return Z17CameraKt.Z17Camera$lambda$47$lambda$46$lambda$45(configuration, context4, (DisposableEffectScope) obj);
                            }
                        };
                        composer4.updateRememberedValue(objRememberedValue14);
                    }
                    EffectsKt.DisposableEffect(k0Var2, (Function1) objRememberedValue14, composer4, i24);
                    composer4.endNode();
                } else {
                    z17CameraViewModel4 = z17CameraViewModel3;
                    context4 = context2;
                    modifier4 = modifier4;
                    z19 = z18;
                    composer4 = composer3;
                    lifecycleOwner4 = lifecycleOwner2;
                    composer4.startReplaceGroup(125040547);
                }
                composer4.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer2 = composer4;
                z15 = z19;
                context3 = context4;
                lifecycleOwner3 = lifecycleOwner4;
                modifier2 = modifier4;
                z14 = z17;
                z17CameraViewModel2 = z17CameraViewModel4;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier2 = modifier;
                z14 = z11;
                composer2 = composerStartRestartGroup;
                context3 = context2;
                lifecycleOwner3 = lifecycleOwner2;
                z15 = z12;
                z17CameraViewModel2 = z17CameraViewModel;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.camera.l
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return Z17CameraKt.Z17Camera$lambda$48(modifier2, imagePathToSave, videoPathToSave, z15, lifecycleOwner3, z17CameraViewModel2, context3, onClose, onResult, onError, z14, i10, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i13 |= 3072;
        z12 = z10;
        if ((i10 & 24576) == 0) {
            if ((i12 & 16) == 0) {
                lifecycleOwner2 = lifecycleOwner;
                if (composerStartRestartGroup.changedInstance(lifecycleOwner2)) {
                }
                i13 |= i32;
            } else {
                lifecycleOwner2 = lifecycleOwner;
            }
            i13 |= i32;
        } else {
            lifecycleOwner2 = lifecycleOwner;
        }
        if ((i10 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) != 0) {
            if ((i12 & 32) == 0) {
                i29 = 65536;
            } else {
                i29 = 65536;
            }
            i13 |= i29;
        }
        if ((i10 & 1572864) == 0) {
            context2 = context;
            if ((i12 & 64) == 0) {
                i28 = 524288;
            } else {
                i28 = 524288;
            }
            i13 |= i28;
        } else {
            context2 = context;
        }
        if ((i10 & 12582912) == 0) {
            if (composerStartRestartGroup.changedInstance(onClose)) {
                i27 = 8388608;
            } else {
                i27 = 4194304;
            }
            i13 |= i27;
        }
        if ((i10 & 100663296) == 0) {
            if (composerStartRestartGroup.changedInstance(onResult)) {
                i26 = 67108864;
            } else {
                i26 = 33554432;
            }
            i13 |= i26;
        }
        if ((i10 & 805306368) == 0) {
            if (composerStartRestartGroup.changedInstance(onError)) {
                i25 = C.BUFFER_FLAG_LAST_SAMPLE;
            } else {
                i25 = 268435456;
            }
            i13 |= i25;
        }
        i14 = i12 & 1024;
        if (i14 != 0) {
            if ((i11 & 6) == 0) {
                if (composerStartRestartGroup.changed(z11)) {
                    i16 = 4;
                } else {
                    i16 = 2;
                }
                i17 = i11 | i16;
            } else {
                i15 = i11;
            }
            if ((i13 & 306783379) == 306783378) {
                z13 = true;
            } else {
                z13 = true;
            }
            if (composerStartRestartGroup.shouldExecute(z13, i13 & 1)) {
                composerStartRestartGroup.startDefaults();
                if ((i10 & 1) != 0) {
                    if (i30 != 0) {
                        modifier3 = Modifier.INSTANCE;
                    } else {
                        modifier3 = modifier;
                    }
                    if (i31 != 0) {
                        z16 = false;
                    } else {
                        z16 = z12;
                    }
                    if ((i12 & 16) != 0) {
                        lifecycleOwner2 = (LifecycleOwner) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner());
                        i13 &= -57345;
                    }
                    if ((i12 & 32) != 0) {
                        str = imagePathToSave + videoPathToSave;
                        z17CameraViewModelFactory = new Z17CameraViewModelFactory(imagePathToSave, videoPathToSave);
                        current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composerStartRestartGroup, 6);
                        if (current == null) {
                            throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                        }
                        if (current instanceof HasDefaultViewModelProviderFactory) {
                            defaultViewModelCreationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                        } else {
                            defaultViewModelCreationExtras = CreationExtras.Empty.INSTANCE;
                        }
                        ViewModel viewModel4 = ViewModelKt.viewModel(z0.b(Z17CameraViewModel.class), current, str, z17CameraViewModelFactory, defaultViewModelCreationExtras, composerStartRestartGroup, 0, 0);
                        composer3 = composerStartRestartGroup;
                        z17CameraViewModel3 = (Z17CameraViewModel) viewModel4;
                        i13 &= -458753;
                    } else {
                        composer3 = composerStartRestartGroup;
                        z17CameraViewModel3 = z17CameraViewModel;
                    }
                    if ((i12 & 64) != 0) {
                        context2 = (Context) composer3.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                        i13 &= -3670017;
                    }
                    if (i14 != 0) {
                        z17 = true;
                    } else {
                        z17 = z11;
                    }
                    modifier4 = modifier3;
                    i18 = i13;
                    z18 = z16;
                } else {
                    if (i30 != 0) {
                        modifier3 = Modifier.INSTANCE;
                    } else {
                        modifier3 = modifier;
                    }
                    if (i31 != 0) {
                        z16 = false;
                    } else {
                        z16 = z12;
                    }
                    if ((i12 & 16) != 0) {
                        lifecycleOwner2 = (LifecycleOwner) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner());
                        i13 &= -57345;
                    }
                    if ((i12 & 32) != 0) {
                        str = imagePathToSave + videoPathToSave;
                        z17CameraViewModelFactory = new Z17CameraViewModelFactory(imagePathToSave, videoPathToSave);
                        current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composerStartRestartGroup, 6);
                        if (current == null) {
                            throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                        }
                        if (current instanceof HasDefaultViewModelProviderFactory) {
                            defaultViewModelCreationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                        } else {
                            defaultViewModelCreationExtras = CreationExtras.Empty.INSTANCE;
                        }
                        ViewModel viewModel5 = ViewModelKt.viewModel(z0.b(Z17CameraViewModel.class), current, str, z17CameraViewModelFactory, defaultViewModelCreationExtras, composerStartRestartGroup, 0, 0);
                        composer3 = composerStartRestartGroup;
                        z17CameraViewModel3 = (Z17CameraViewModel) viewModel5;
                        i13 &= -458753;
                    } else {
                        composer3 = composerStartRestartGroup;
                        z17CameraViewModel3 = z17CameraViewModel;
                    }
                    if ((i12 & 64) != 0) {
                        context2 = (Context) composer3.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                        i13 &= -3670017;
                    }
                    if (i14 != 0) {
                        z17 = true;
                    } else {
                        z17 = z11;
                    }
                    modifier4 = modifier3;
                    i18 = i13;
                    z18 = z16;
                }
                composer3.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1860373471, i18, i15, "cu.z17.views.camera.Z17Camera (Z17Camera.kt:85)");
                }
                if (Z17CameraModule.INSTANCE.getInstance().getCanUseCamera()) {
                    composer3.startReplaceGroup(1112544640);
                    companion = Alignment.INSTANCE;
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy7 = BoxKt.maybeCachedBoxMeasurePolicy(companion.getTopStart(), false);
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                    CompositionLocalMap currentCompositionLocalMap9 = composer3.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier9 = ComposedModifierKt.materializeModifier(composer3, modifier4);
                    ComposeUiNode.Companion companion9 = ComposeUiNode.INSTANCE;
                    constructor = companion9.getConstructor();
                    if (!r.a(composer3.getApplier())) {
                        ComposablesKt.invalidApplier();
                    }
                    composer3.startReusableNode();
                    if (composer3.getInserting()) {
                        composer3.createNode(constructor);
                    } else {
                        composer3.useNode();
                    }
                    composerM5176constructorimpl = Updater.m5176constructorimpl(composer3);
                    i19 = i18;
                    Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy7, companion9.getSetMeasurePolicy());
                    Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap9, companion9.getSetResolvedCompositionLocals());
                    setCompositeKeyHash = companion9.getSetCompositeKeyHash();
                    if (composerM5176constructorimpl.getInserting()) {
                        composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    } else {
                        composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier9, companion9.getSetModifier());
                    boxScopeInstance = BoxScopeInstance.INSTANCE;
                    configuration = (Configuration) composer3.consume(AndroidCompositionLocals_androidKt.getLocalConfiguration());
                    objRememberedValue = composer3.rememberedValue();
                    companion2 = Composer.INSTANCE;
                    if (objRememberedValue == companion2.getEmpty()) {
                        objRememberedValue = new PreviewView(context2);
                        composer3.updateRememberedValue(objRememberedValue);
                    }
                    previewView = (PreviewView) objRememberedValue;
                    objRememberedValue2 = composer3.rememberedValue();
                    if (objRememberedValue2 == companion2.getEmpty()) {
                        objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                        composer3.updateRememberedValue(objRememberedValue2);
                    }
                    mutableState = (MutableState) objRememberedValue2;
                    objRememberedValue3 = composer3.rememberedValue();
                    if (objRememberedValue3 == companion2.getEmpty()) {
                        objRememberedValue3 = SnapshotLongStateKt.mutableLongStateOf(0L);
                        composer3.updateRememberedValue(objRememberedValue3);
                    }
                    mutableLongState = (MutableLongState) objRememberedValue3;
                    objRememberedValue4 = composer3.rememberedValue();
                    if (objRememberedValue4 == companion2.getEmpty()) {
                        objRememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                        composer3.updateRememberedValue(objRememberedValue4);
                    }
                    final MutableState mutableState5 = (MutableState) objRememberedValue4;
                    objRememberedValue5 = composer3.rememberedValue();
                    if (objRememberedValue5 == companion2.getEmpty()) {
                        objRememberedValue5 = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
                        composer3.updateRememberedValue(objRememberedValue5);
                    }
                    mutableFloatState = (MutableFloatState) objRememberedValue5;
                    objRememberedValue6 = composer3.rememberedValue();
                    if (objRememberedValue6 == companion2.getEmpty()) {
                        objRememberedValue6 = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
                        composer3.updateRememberedValue(objRememberedValue6);
                    }
                    mutableFloatState2 = (MutableFloatState) objRememberedValue6;
                    composer5 = composer3;
                    final State stateAnimateFloatAsState3 = AnimateAsStateKt.animateFloatAsState(mutableFloatState2.getFloatValue(), null, 0.0f, "ar", null, composer5, 3072, 22);
                    stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(z17CameraViewModel3.getCaptureResult(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composer5, 0, 7);
                    stateCollectAsStateWithLifecycle2 = FlowExtKt.collectAsStateWithLifecycle(z17CameraViewModel3.getRecordingResult(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composer5, 0, 7);
                    Float fValueOf3 = Float.valueOf(mutableFloatState.getFloatValue());
                    objRememberedValue7 = composer5.rememberedValue();
                    if (objRememberedValue7 == companion2.getEmpty()) {
                        objRememberedValue7 = new Z17CameraKt$Z17Camera$1$1$1(mutableFloatState, mutableFloatState2, null);
                        composer6 = composer5;
                        composer6.updateRememberedValue(objRememberedValue7);
                    } else {
                        composer6 = composer5;
                    }
                    EffectsKt.LaunchedEffect(fValueOf3, (Function2) objRememberedValue7, composer6, 0);
                    k0 k0Var3 = k0.f43947a;
                    zChangedInstance = composer6.changedInstance(context2) | composer6.changed(stateCollectAsStateWithLifecycle2);
                    objRememberedValue8 = composer6.rememberedValue();
                    if (zChangedInstance) {
                        state = stateCollectAsStateWithLifecycle2;
                        mutableLongState2 = mutableLongState;
                        context5 = context2;
                        Z17CameraKt$Z17Camera$1$2$1 z17CameraKt$Z17Camera$1$2$4 = new Z17CameraKt$Z17Camera$1$2$1(context5, mutableFloatState, state, mutableLongState2, null);
                        mutableFloatState3 = mutableFloatState;
                        composer6.updateRememberedValue(z17CameraKt$Z17Camera$1$2$4);
                        objRememberedValue8 = z17CameraKt$Z17Camera$1$2$4;
                    } else {
                        state = stateCollectAsStateWithLifecycle2;
                        mutableLongState2 = mutableLongState;
                        context5 = context2;
                        Z17CameraKt$Z17Camera$1$2$1 z17CameraKt$Z17Camera$1$2$5 = new Z17CameraKt$Z17Camera$1$2$1(context5, mutableFloatState, state, mutableLongState2, null);
                        mutableFloatState3 = mutableFloatState;
                        composer6.updateRememberedValue(z17CameraKt$Z17Camera$1$2$5);
                        objRememberedValue8 = z17CameraKt$Z17Camera$1$2$5;
                    }
                    EffectsKt.LaunchedEffect(k0Var3, (Function2) objRememberedValue8, composer6, 6);
                    CaptureState captureStateZ17Camera$lambda$47$lambda$19 = Z17Camera$lambda$47$lambda$17(stateCollectAsStateWithLifecycle);
                    boolean zChanged5 = composer6.changed(stateCollectAsStateWithLifecycle);
                    i20 = i19 & 234881024;
                    if (i20 == 67108864) {
                        z20 = true;
                    } else {
                        z20 = false;
                    }
                    boolean z38 = zChanged5 | z20;
                    if ((i19 & 112) == 32) {
                        z21 = true;
                    } else {
                        z21 = false;
                    }
                    boolean zChangedInstance12 = z38 | z21 | composer6.changedInstance(z17CameraViewModel3);
                    if ((i19 & C.ENCODING_PCM_DOUBLE) == 536870912) {
                        z22 = true;
                    } else {
                        z22 = false;
                    }
                    z23 = zChangedInstance12 | z22;
                    objRememberedValue9 = composer6.rememberedValue();
                    if (z23) {
                        composer7 = composer6;
                        i21 = i20;
                        i22 = 67108864;
                        z17CameraViewModel5 = z17CameraViewModel3;
                        Z17CameraKt$Z17Camera$1$3$1 z17CameraKt$Z17Camera$1$3$4 = new Z17CameraKt$Z17Camera$1$3$1(onResult, imagePathToSave, z17CameraViewModel5, onError, stateCollectAsStateWithLifecycle, mutableFloatState3, null);
                        state2 = stateCollectAsStateWithLifecycle;
                        composer7.updateRememberedValue(z17CameraKt$Z17Camera$1$3$4);
                        objRememberedValue9 = z17CameraKt$Z17Camera$1$3$4;
                    } else {
                        composer7 = composer6;
                        i21 = i20;
                        i22 = 67108864;
                        z17CameraViewModel5 = z17CameraViewModel3;
                        Z17CameraKt$Z17Camera$1$3$1 z17CameraKt$Z17Camera$1$3$5 = new Z17CameraKt$Z17Camera$1$3$1(onResult, imagePathToSave, z17CameraViewModel5, onError, stateCollectAsStateWithLifecycle, mutableFloatState3, null);
                        state2 = stateCollectAsStateWithLifecycle;
                        composer7.updateRememberedValue(z17CameraKt$Z17Camera$1$3$5);
                        objRememberedValue9 = z17CameraKt$Z17Camera$1$3$5;
                    }
                    EffectsKt.LaunchedEffect(captureStateZ17Camera$lambda$47$lambda$19, (Function2) objRememberedValue9, composer7, 0);
                    RecordingState recordingStateZ17Camera$lambda$47$lambda$110 = Z17Camera$lambda$47$lambda$18(state);
                    state3 = state;
                    boolean zChanged6 = composer7.changed(state3);
                    if (i21 == i22) {
                        z24 = true;
                    } else {
                        z24 = false;
                    }
                    boolean z39 = zChanged6 | z24;
                    if ((i19 & 896) == 256) {
                        z25 = true;
                    } else {
                        z25 = false;
                    }
                    zChangedInstance2 = z39 | z25 | composer7.changedInstance(z17CameraViewModel5);
                    objRememberedValue10 = composer7.rememberedValue();
                    if (zChangedInstance2) {
                        MutableLongState mutableLongState7 = mutableLongState2;
                        Z17CameraKt$Z17Camera$1$4$1 z17CameraKt$Z17Camera$1$4$4 = new Z17CameraKt$Z17Camera$1$4$1(onResult, videoPathToSave, z17CameraViewModel5, state3, mutableLongState7, mutableFloatState3, null);
                        mutableLongState3 = mutableLongState7;
                        composer7.updateRememberedValue(z17CameraKt$Z17Camera$1$4$4);
                        objRememberedValue10 = z17CameraKt$Z17Camera$1$4$4;
                    } else {
                        MutableLongState mutableLongState8 = mutableLongState2;
                        Z17CameraKt$Z17Camera$1$4$1 z17CameraKt$Z17Camera$1$4$5 = new Z17CameraKt$Z17Camera$1$4$1(onResult, videoPathToSave, z17CameraViewModel5, state3, mutableLongState8, mutableFloatState3, null);
                        mutableLongState3 = mutableLongState8;
                        composer7.updateRememberedValue(z17CameraKt$Z17Camera$1$4$5);
                        objRememberedValue10 = z17CameraKt$Z17Camera$1$4$5;
                    }
                    EffectsKt.LaunchedEffect(recordingStateZ17Camera$lambda$47$lambda$110, (Function2) objRememberedValue10, composer7, 0);
                    zChangedInstance3 = composer7.changedInstance(previewView);
                    objRememberedValue11 = composer7.rememberedValue();
                    if (zChangedInstance3) {
                        objRememberedValue11 = new Function1() { // from class: cu.z17.views.camera.b
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return Z17CameraKt.Z17Camera$lambda$47$lambda$24$lambda$23(previewView, (Context) obj);
                            }
                        };
                        composer7.updateRememberedValue(objRememberedValue11);
                    } else {
                        objRememberedValue11 = new Function1() { // from class: cu.z17.views.camera.b
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return Z17CameraKt.Z17Camera$lambda$47$lambda$24$lambda$23(previewView, (Context) obj);
                            }
                        };
                        composer7.updateRememberedValue(objRememberedValue11);
                    }
                    companion3 = Modifier.INSTANCE;
                    composer8 = composer7;
                    AndroidView_androidKt.AndroidView((Function1) objRememberedValue11, SizeKt.fillMaxSize$default(companion3, 0.0f, 1, null), null, composer8, 48, 4);
                    if (z17) {
                        composer8.startReplaceGroup(-1432532383);
                        Modifier modifierAlign3 = boxScopeInstance.align(WindowInsetsPadding_androidKt.safeContentPadding(companion3), companion.getTopStart());
                        boolean zChangedInstance13 = composer8.changedInstance(z17CameraViewModel5);
                        if ((29360128 & i19) == 8388608) {
                            z30 = true;
                        } else {
                            z30 = false;
                        }
                        z31 = zChangedInstance13 | z30;
                        objRememberedValue15 = composer8.rememberedValue();
                        if (z31) {
                            objRememberedValue15 = new lb.a() { // from class: cu.z17.views.camera.e
                                @Override // lb.a
                                public final Object invoke() {
                                    return Z17CameraKt.Z17Camera$lambda$47$lambda$26$lambda$25(z17CameraViewModel5, onClose);
                                }
                            };
                            composer8.updateRememberedValue(objRememberedValue15);
                        } else {
                            objRememberedValue15 = new lb.a() { // from class: cu.z17.views.camera.e
                                @Override // lb.a
                                public final Object invoke() {
                                    return Z17CameraKt.Z17Camera$lambda$47$lambda$26$lambda$25(z17CameraViewModel5, onClose);
                                }
                            };
                            composer8.updateRememberedValue(objRememberedValue15);
                        }
                        IconButtonKt.IconButton((lb.a) objRememberedValue15, modifierAlign3, false, null, null, ComposableSingletons$Z17CameraKt.INSTANCE.m10134getLambda$1809404936$views_release(), composer8, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 28);
                        composer4 = composer8;
                    } else {
                        composer4 = composer8;
                        composer4.startReplaceGroup(-1439926782);
                    }
                    composer4.endReplaceGroup();
                    if (z18 != 0) {
                        composer4.startReplaceGroup(-1431891179);
                        String strConvertToMS3 = Z17InlineUtilsKt.convertToMS(mutableLongState3.getLongValue());
                        Modifier modifierM1725padding3ABfNKs5 = PaddingKt.m1725padding3ABfNKs(r43.align(companion3, companion.getTopEnd()), Dp.m8823constructorimpl(20));
                        Color.Companion companion10 = Color.INSTANCE;
                        float f15 = 5;
                        Z17LabelKt.m10262Z17LabelfWhpE4E(PaddingKt.m1726paddingVpY3zN4(BackgroundKt.m1204backgroundbw27NRU(modifierM1725padding3ABfNKs5, companion10.m5892getBlack0d7_KjU(), RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(f15))), Dp.m8823constructorimpl(f15), Dp.m8823constructorimpl(3)), strConvertToMS3, null, companion10.m5903getWhite0d7_KjU(), 0, 0, composer4, 3072, 52);
                    } else {
                        composer4.startReplaceGroup(-1439926782);
                    }
                    composer4.endReplaceGroup();
                    float f16 = 20;
                    Modifier modifierM1729paddingqDBjuR0$default3 = PaddingKt.m1729paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(r43.align(companion3, companion.getBottomCenter()), 0.0f, 1, null), Dp.m8823constructorimpl(f16), 0.0f, Dp.m8823constructorimpl(f16), Dp.m8823constructorimpl(f16), 2, null);
                    MeasurePolicy measurePolicyRowMeasurePolicy3 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getSpaceBetween(), companion.getCenterVertically(), composer4, 54);
                    currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                    CompositionLocalMap currentCompositionLocalMap10 = composer4.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier10 = ComposedModifierKt.materializeModifier(composer4, modifierM1729paddingqDBjuR0$default3);
                    constructor2 = companion9.getConstructor();
                    if (!r.a(composer4.getApplier())) {
                        ComposablesKt.invalidApplier();
                    }
                    composer4.startReusableNode();
                    if (composer4.getInserting()) {
                        composer4.createNode(constructor2);
                    } else {
                        composer4.useNode();
                    }
                    composerM5176constructorimpl2 = Updater.m5176constructorimpl(composer4);
                    Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyRowMeasurePolicy3, companion9.getSetMeasurePolicy());
                    Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap10, companion9.getSetResolvedCompositionLocals());
                    setCompositeKeyHash2 = companion9.getSetCompositeKeyHash();
                    if (composerM5176constructorimpl2.getInserting()) {
                        composerM5176constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                        composerM5176constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                    } else {
                        composerM5176constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                        composerM5176constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                    }
                    Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier10, companion9.getSetModifier());
                    RowScopeInstance rowScopeInstance3 = RowScopeInstance.INSTANCE;
                    MaterialTheme materialTheme3 = MaterialTheme.INSTANCE;
                    int i35 = MaterialTheme.$stable;
                    f10 = 10;
                    Modifier modifierClip3 = ClipKt.clip(PaddingKt.m1725padding3ABfNKs(BackgroundKt.m1204backgroundbw27NRU(companion3, Color.m5865copywmQWz5c$default(materialTheme3.getColorScheme(composer4, i35).getBackground(), 0.3f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.getCircleShape()), Dp.m8823constructorimpl(f10)), RoundedCornerShapeKt.getCircleShape());
                    zChangedInstance4 = composer4.changedInstance(z17CameraViewModel5);
                    objRememberedValue12 = composer4.rememberedValue();
                    if (zChangedInstance4) {
                        mutableState2 = mutableState;
                        objRememberedValue12 = new lb.a() { // from class: cu.z17.views.camera.f
                            @Override // lb.a
                            public final Object invoke() {
                                return Z17CameraKt.Z17Camera$lambda$47$lambda$42$lambda$28$lambda$27(z17CameraViewModel5, mutableState2);
                            }
                        };
                        composer4.updateRememberedValue(objRememberedValue12);
                    } else {
                        mutableState2 = mutableState;
                        objRememberedValue12 = new lb.a() { // from class: cu.z17.views.camera.f
                            @Override // lb.a
                            public final Object invoke() {
                                return Z17CameraKt.Z17Camera$lambda$47$lambda$42$lambda$28$lambda$27(z17CameraViewModel5, mutableState2);
                            }
                        };
                        composer4.updateRememberedValue(objRememberedValue12);
                    }
                    Modifier modifierM1238clickableXHw0xAI$default3 = ClickableKt.m1238clickableXHw0xAI$default(modifierClip3, false, null, null, (lb.a) objRememberedValue12, 7, null);
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy8 = BoxKt.maybeCachedBoxMeasurePolicy(companion.getCenter(), false);
                    currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                    CompositionLocalMap currentCompositionLocalMap11 = composer4.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier11 = ComposedModifierKt.materializeModifier(composer4, modifierM1238clickableXHw0xAI$default3);
                    constructor3 = companion9.getConstructor();
                    if (!r.a(composer4.getApplier())) {
                        ComposablesKt.invalidApplier();
                    }
                    composer4.startReusableNode();
                    if (composer4.getInserting()) {
                        composer4.createNode(constructor3);
                    } else {
                        composer4.useNode();
                    }
                    composerM5176constructorimpl3 = Updater.m5176constructorimpl(composer4);
                    Updater.m5184setimpl(composerM5176constructorimpl3, measurePolicyMaybeCachedBoxMeasurePolicy8, companion9.getSetMeasurePolicy());
                    Updater.m5184setimpl(composerM5176constructorimpl3, currentCompositionLocalMap11, companion9.getSetResolvedCompositionLocals());
                    setCompositeKeyHash3 = companion9.getSetCompositeKeyHash();
                    if (composerM5176constructorimpl3.getInserting()) {
                        composerM5176constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                        composerM5176constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                    } else {
                        composerM5176constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                        composerM5176constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                    }
                    Updater.m5184setimpl(composerM5176constructorimpl3, modifierMaterializeModifier11, companion9.getSetModifier());
                    Modifier modifierM1769size3ABfNKs3 = SizeKt.m1769size3ABfNKs(companion3, Dp.m8823constructorimpl(25));
                    if (Z17Camera$lambda$47$lambda$2(mutableState2)) {
                        flashOff = FlashOnKt.getFlashOn(Icons.Outlined.INSTANCE);
                    } else {
                        flashOff = FlashOffKt.getFlashOff(Icons.Outlined.INSTANCE);
                    }
                    Z17PictureKt.m10278Z17BasePictureC8z9wKI(modifierM1769size3ABfNKs3, flashOff, null, ColorFilter.Companion.m5907tintxETnrds$default(ColorFilter.INSTANCE, materialTheme3.getColorScheme(composer4, i35).getOnBackground(), 0, 2, null), null, null, 0, null, null, composer4, 6, XMPPTCPConnection.PacketWriter.QUEUE_SIZE);
                    composer4.endNode();
                    if (Z17Camera$lambda$47$lambda$18(state3) != RecordingState.RECORDING) {
                        z26 = true;
                    } else {
                        z26 = true;
                    }
                    AnimatedVisibilityKt.AnimatedVisibility(rowScopeInstance3, z26, (Modifier) null, (EnterTransition) null, (ExitTransition) null, (String) null, ComposableLambdaKt.rememberComposableLambda(-381832644, true, new Function3() { // from class: cu.z17.views.camera.g
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return Z17CameraKt.Z17Camera$lambda$47$lambda$42$lambda$33(state3, z17CameraViewModel5, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composer4, 54), composer4, 1572870, 30);
                    float fM8823constructorimpl4 = Dp.m8823constructorimpl(4);
                    companion4 = Color.INSTANCE;
                    Modifier modifierM1216borderxT4_qwU3 = BorderKt.m1216borderxT4_qwU(companion3, fM8823constructorimpl4, companion4.m5903getWhite0d7_KjU(), RoundedCornerShapeKt.getCircleShape());
                    if (z18 != 0) {
                        fM8823constructorimpl = Dp.m8823constructorimpl(f10);
                    } else {
                        fM8823constructorimpl = Dp.m8823constructorimpl(5);
                    }
                    Modifier modifierM1725padding3ABfNKs6 = PaddingKt.m1725padding3ABfNKs(modifierM1216borderxT4_qwU3, fM8823constructorimpl);
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy9 = BoxKt.maybeCachedBoxMeasurePolicy(companion.getCenter(), false);
                    currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                    CompositionLocalMap currentCompositionLocalMap12 = composer4.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier12 = ComposedModifierKt.materializeModifier(composer4, modifierM1725padding3ABfNKs6);
                    constructor4 = companion9.getConstructor();
                    if (!r.a(composer4.getApplier())) {
                        ComposablesKt.invalidApplier();
                    }
                    composer4.startReusableNode();
                    if (composer4.getInserting()) {
                        composer4.createNode(constructor4);
                    } else {
                        composer4.useNode();
                    }
                    composerM5176constructorimpl4 = Updater.m5176constructorimpl(composer4);
                    Updater.m5184setimpl(composerM5176constructorimpl4, measurePolicyMaybeCachedBoxMeasurePolicy9, companion9.getSetMeasurePolicy());
                    Updater.m5184setimpl(composerM5176constructorimpl4, currentCompositionLocalMap12, companion9.getSetResolvedCompositionLocals());
                    setCompositeKeyHash4 = companion9.getSetCompositeKeyHash();
                    if (composerM5176constructorimpl4.getInserting()) {
                        composerM5176constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                        composerM5176constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
                    } else {
                        composerM5176constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                        composerM5176constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
                    }
                    Updater.m5184setimpl(composerM5176constructorimpl4, modifierMaterializeModifier12, companion9.getSetModifier());
                    Modifier modifierBounceClick3 = Z17ButtonsKt.bounceClick(companion3);
                    i23 = i19 & 7168;
                    if (i23 == 2048) {
                        z27 = true;
                    } else {
                        z27 = false;
                    }
                    context4 = context5;
                    zChangedInstance5 = z27 | composer4.changedInstance(z17CameraViewModel5) | composer4.changedInstance(context4) | composer4.changed(state3);
                    objRememberedValue13 = composer4.rememberedValue();
                    if (zChangedInstance5) {
                        z19 = z18;
                        objRememberedValue13 = new lb.a() { // from class: cu.z17.views.camera.h
                            @Override // lb.a
                            public final Object invoke() {
                                return Z17CameraKt.Z17Camera$lambda$47$lambda$42$lambda$37$lambda$35$lambda$34(z19, z17CameraViewModel5, context4, state3);
                            }
                        };
                        composer4.updateRememberedValue(objRememberedValue13);
                    } else {
                        z19 = z18;
                        objRememberedValue13 = new lb.a() { // from class: cu.z17.views.camera.h
                            @Override // lb.a
                            public final Object invoke() {
                                return Z17CameraKt.Z17Camera$lambda$47$lambda$42$lambda$37$lambda$35$lambda$34(z19, z17CameraViewModel5, context4, state3);
                            }
                        };
                        composer4.updateRememberedValue(objRememberedValue13);
                    }
                    IconButtonKt.IconButton((lb.a) objRememberedValue13, modifierBounceClick3, false, null, null, ComposableLambdaKt.rememberComposableLambda(1107306238, true, new Function2() { // from class: cu.z17.views.camera.i
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return Z17CameraKt.Z17Camera$lambda$47$lambda$42$lambda$37$lambda$36(z19, state3, stateAnimateFloatAsState3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composer4, 54), composer4, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 28);
                    composer4.endNode();
                    if (z19) {
                        z28 = true;
                    } else {
                        z28 = true;
                    }
                    final boolean z310 = z19;
                    final Z17CameraViewModel z17CameraViewModel11 = z17CameraViewModel5;
                    lifecycleOwner5 = lifecycleOwner2;
                    AnimatedVisibilityKt.AnimatedVisibility(rowScopeInstance3, z28, (Modifier) null, (EnterTransition) null, (ExitTransition) null, (String) null, ComposableLambdaKt.rememberComposableLambda(-892834829, true, new Function3() { // from class: cu.z17.views.camera.j
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return Z17CameraKt.Z17Camera$lambda$47$lambda$42$lambda$41(z310, z17CameraViewModel11, previewView, lifecycleOwner5, mutableState5, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composer4, 54), composer4, 1572870, 30);
                    composer4.endNode();
                    if (Z17Camera$lambda$47$lambda$17(state2) == CaptureState.SAVING) {
                        composer4.startReplaceGroup(-1015799063);
                        z29 = true;
                        i24 = 6;
                        BoxKt.Box(BackgroundKt.m1205backgroundbw27NRU$default(SizeKt.fillMaxSize$default(companion3, 0.0f, 1, null), Color.m5865copywmQWz5c$default(companion4.m5892getBlack0d7_KjU(), 0.2f, 0.0f, 0.0f, 0.0f, 14, null), null, 2, null), composer4, 6);
                    } else {
                        i24 = 6;
                        z29 = true;
                        composer4.startReplaceGroup(-1439926782);
                    }
                    composer4.endReplaceGroup();
                    Boolean boolValueOf3 = Boolean.valueOf(z19);
                    if (i23 != 2048) {
                        z29 = false;
                    }
                    zChangedInstance6 = composer4.changedInstance(z17CameraViewModel5) | z29 | composer4.changedInstance(previewView) | composer4.changedInstance(lifecycleOwner5);
                    Object objRememberedValue18 = composer4.rememberedValue();
                    if (zChangedInstance6) {
                        Z17CameraViewModel z17CameraViewModel12 = z17CameraViewModel5;
                        lifecycleOwner4 = lifecycleOwner5;
                        z17CameraKt$Z17Camera$1$8$1 = new Z17CameraKt$Z17Camera$1$8$1(z19, z17CameraViewModel12, previewView, lifecycleOwner4, null);
                        z17CameraViewModel4 = z17CameraViewModel12;
                        composer4.updateRememberedValue(z17CameraKt$Z17Camera$1$8$1);
                    } else {
                        Z17CameraViewModel z17CameraViewModel13 = z17CameraViewModel5;
                        lifecycleOwner4 = lifecycleOwner5;
                        z17CameraKt$Z17Camera$1$8$1 = new Z17CameraKt$Z17Camera$1$8$1(z19, z17CameraViewModel13, previewView, lifecycleOwner4, null);
                        z17CameraViewModel4 = z17CameraViewModel13;
                        composer4.updateRememberedValue(z17CameraKt$Z17Camera$1$8$1);
                    }
                    EffectsKt.LaunchedEffect(boolValueOf3, (Function2) z17CameraKt$Z17Camera$1$8$1, composer4, (i19 >> 9) & 14);
                    zChangedInstance7 = composer4.changedInstance(configuration) | composer4.changedInstance(context4);
                    objRememberedValue14 = composer4.rememberedValue();
                    if (zChangedInstance7) {
                        objRememberedValue14 = new Function1() { // from class: cu.z17.views.camera.k
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return Z17CameraKt.Z17Camera$lambda$47$lambda$46$lambda$45(configuration, context4, (DisposableEffectScope) obj);
                            }
                        };
                        composer4.updateRememberedValue(objRememberedValue14);
                    } else {
                        objRememberedValue14 = new Function1() { // from class: cu.z17.views.camera.k
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return Z17CameraKt.Z17Camera$lambda$47$lambda$46$lambda$45(configuration, context4, (DisposableEffectScope) obj);
                            }
                        };
                        composer4.updateRememberedValue(objRememberedValue14);
                    }
                    EffectsKt.DisposableEffect(k0Var3, (Function1) objRememberedValue14, composer4, i24);
                    composer4.endNode();
                } else {
                    z17CameraViewModel4 = z17CameraViewModel3;
                    context4 = context2;
                    modifier4 = modifier4;
                    z19 = z18;
                    composer4 = composer3;
                    lifecycleOwner4 = lifecycleOwner2;
                    composer4.startReplaceGroup(125040547);
                }
                composer4.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer2 = composer4;
                z15 = z19;
                context3 = context4;
                lifecycleOwner3 = lifecycleOwner4;
                modifier2 = modifier4;
                z14 = z17;
                z17CameraViewModel2 = z17CameraViewModel4;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier2 = modifier;
                z14 = z11;
                composer2 = composerStartRestartGroup;
                context3 = context2;
                lifecycleOwner3 = lifecycleOwner2;
                z15 = z12;
                z17CameraViewModel2 = z17CameraViewModel;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.camera.l
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return Z17CameraKt.Z17Camera$lambda$48(modifier2, imagePathToSave, videoPathToSave, z15, lifecycleOwner3, z17CameraViewModel2, context3, onClose, onResult, onError, z14, i10, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i17 = i11 | 6;
        i15 = i17;
        if ((i13 & 306783379) == 306783378) {
            z13 = true;
        } else {
            z13 = true;
        }
        if (composerStartRestartGroup.shouldExecute(z13, i13 & 1)) {
            composerStartRestartGroup.startDefaults();
            if ((i10 & 1) != 0) {
                if (i30 != 0) {
                    modifier3 = Modifier.INSTANCE;
                } else {
                    modifier3 = modifier;
                }
                if (i31 != 0) {
                    z16 = false;
                } else {
                    z16 = z12;
                }
                if ((i12 & 16) != 0) {
                    lifecycleOwner2 = (LifecycleOwner) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner());
                    i13 &= -57345;
                }
                if ((i12 & 32) != 0) {
                    str = imagePathToSave + videoPathToSave;
                    z17CameraViewModelFactory = new Z17CameraViewModelFactory(imagePathToSave, videoPathToSave);
                    current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composerStartRestartGroup, 6);
                    if (current == null) {
                        throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                    }
                    if (current instanceof HasDefaultViewModelProviderFactory) {
                        defaultViewModelCreationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                    } else {
                        defaultViewModelCreationExtras = CreationExtras.Empty.INSTANCE;
                    }
                    ViewModel viewModel6 = ViewModelKt.viewModel(z0.b(Z17CameraViewModel.class), current, str, z17CameraViewModelFactory, defaultViewModelCreationExtras, composerStartRestartGroup, 0, 0);
                    composer3 = composerStartRestartGroup;
                    z17CameraViewModel3 = (Z17CameraViewModel) viewModel6;
                    i13 &= -458753;
                } else {
                    composer3 = composerStartRestartGroup;
                    z17CameraViewModel3 = z17CameraViewModel;
                }
                if ((i12 & 64) != 0) {
                    context2 = (Context) composer3.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                    i13 &= -3670017;
                }
                if (i14 != 0) {
                    z17 = true;
                } else {
                    z17 = z11;
                }
                modifier4 = modifier3;
                i18 = i13;
                z18 = z16;
            } else {
                if (i30 != 0) {
                    modifier3 = Modifier.INSTANCE;
                } else {
                    modifier3 = modifier;
                }
                if (i31 != 0) {
                    z16 = false;
                } else {
                    z16 = z12;
                }
                if ((i12 & 16) != 0) {
                    lifecycleOwner2 = (LifecycleOwner) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner());
                    i13 &= -57345;
                }
                if ((i12 & 32) != 0) {
                    str = imagePathToSave + videoPathToSave;
                    z17CameraViewModelFactory = new Z17CameraViewModelFactory(imagePathToSave, videoPathToSave);
                    current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composerStartRestartGroup, 6);
                    if (current == null) {
                        throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                    }
                    if (current instanceof HasDefaultViewModelProviderFactory) {
                        defaultViewModelCreationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                    } else {
                        defaultViewModelCreationExtras = CreationExtras.Empty.INSTANCE;
                    }
                    ViewModel viewModel7 = ViewModelKt.viewModel(z0.b(Z17CameraViewModel.class), current, str, z17CameraViewModelFactory, defaultViewModelCreationExtras, composerStartRestartGroup, 0, 0);
                    composer3 = composerStartRestartGroup;
                    z17CameraViewModel3 = (Z17CameraViewModel) viewModel7;
                    i13 &= -458753;
                } else {
                    composer3 = composerStartRestartGroup;
                    z17CameraViewModel3 = z17CameraViewModel;
                }
                if ((i12 & 64) != 0) {
                    context2 = (Context) composer3.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                    i13 &= -3670017;
                }
                if (i14 != 0) {
                    z17 = true;
                } else {
                    z17 = z11;
                }
                modifier4 = modifier3;
                i18 = i13;
                z18 = z16;
            }
            composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1860373471, i18, i15, "cu.z17.views.camera.Z17Camera (Z17Camera.kt:85)");
            }
            if (Z17CameraModule.INSTANCE.getInstance().getCanUseCamera()) {
                composer3.startReplaceGroup(1112544640);
                companion = Alignment.INSTANCE;
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy10 = BoxKt.maybeCachedBoxMeasurePolicy(companion.getTopStart(), false);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                CompositionLocalMap currentCompositionLocalMap13 = composer3.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier13 = ComposedModifierKt.materializeModifier(composer3, modifier4);
                ComposeUiNode.Companion companion11 = ComposeUiNode.INSTANCE;
                constructor = companion11.getConstructor();
                if (!r.a(composer3.getApplier())) {
                    ComposablesKt.invalidApplier();
                }
                composer3.startReusableNode();
                if (composer3.getInserting()) {
                    composer3.createNode(constructor);
                } else {
                    composer3.useNode();
                }
                composerM5176constructorimpl = Updater.m5176constructorimpl(composer3);
                i19 = i18;
                Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy10, companion11.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap13, companion11.getSetResolvedCompositionLocals());
                setCompositeKeyHash = companion11.getSetCompositeKeyHash();
                if (composerM5176constructorimpl.getInserting()) {
                    composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                } else {
                    composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier13, companion11.getSetModifier());
                boxScopeInstance = BoxScopeInstance.INSTANCE;
                configuration = (Configuration) composer3.consume(AndroidCompositionLocals_androidKt.getLocalConfiguration());
                objRememberedValue = composer3.rememberedValue();
                companion2 = Composer.INSTANCE;
                if (objRememberedValue == companion2.getEmpty()) {
                    objRememberedValue = new PreviewView(context2);
                    composer3.updateRememberedValue(objRememberedValue);
                }
                previewView = (PreviewView) objRememberedValue;
                objRememberedValue2 = composer3.rememberedValue();
                if (objRememberedValue2 == companion2.getEmpty()) {
                    objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                    composer3.updateRememberedValue(objRememberedValue2);
                }
                mutableState = (MutableState) objRememberedValue2;
                objRememberedValue3 = composer3.rememberedValue();
                if (objRememberedValue3 == companion2.getEmpty()) {
                    objRememberedValue3 = SnapshotLongStateKt.mutableLongStateOf(0L);
                    composer3.updateRememberedValue(objRememberedValue3);
                }
                mutableLongState = (MutableLongState) objRememberedValue3;
                objRememberedValue4 = composer3.rememberedValue();
                if (objRememberedValue4 == companion2.getEmpty()) {
                    objRememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                    composer3.updateRememberedValue(objRememberedValue4);
                }
                final MutableState mutableState6 = (MutableState) objRememberedValue4;
                objRememberedValue5 = composer3.rememberedValue();
                if (objRememberedValue5 == companion2.getEmpty()) {
                    objRememberedValue5 = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
                    composer3.updateRememberedValue(objRememberedValue5);
                }
                mutableFloatState = (MutableFloatState) objRememberedValue5;
                objRememberedValue6 = composer3.rememberedValue();
                if (objRememberedValue6 == companion2.getEmpty()) {
                    objRememberedValue6 = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
                    composer3.updateRememberedValue(objRememberedValue6);
                }
                mutableFloatState2 = (MutableFloatState) objRememberedValue6;
                composer5 = composer3;
                final State stateAnimateFloatAsState4 = AnimateAsStateKt.animateFloatAsState(mutableFloatState2.getFloatValue(), null, 0.0f, "ar", null, composer5, 3072, 22);
                stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(z17CameraViewModel3.getCaptureResult(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composer5, 0, 7);
                stateCollectAsStateWithLifecycle2 = FlowExtKt.collectAsStateWithLifecycle(z17CameraViewModel3.getRecordingResult(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composer5, 0, 7);
                Float fValueOf4 = Float.valueOf(mutableFloatState.getFloatValue());
                objRememberedValue7 = composer5.rememberedValue();
                if (objRememberedValue7 == companion2.getEmpty()) {
                    objRememberedValue7 = new Z17CameraKt$Z17Camera$1$1$1(mutableFloatState, mutableFloatState2, null);
                    composer6 = composer5;
                    composer6.updateRememberedValue(objRememberedValue7);
                } else {
                    composer6 = composer5;
                }
                EffectsKt.LaunchedEffect(fValueOf4, (Function2) objRememberedValue7, composer6, 0);
                k0 k0Var4 = k0.f43947a;
                zChangedInstance = composer6.changedInstance(context2) | composer6.changed(stateCollectAsStateWithLifecycle2);
                objRememberedValue8 = composer6.rememberedValue();
                if (zChangedInstance) {
                    state = stateCollectAsStateWithLifecycle2;
                    mutableLongState2 = mutableLongState;
                    context5 = context2;
                    Z17CameraKt$Z17Camera$1$2$1 z17CameraKt$Z17Camera$1$2$6 = new Z17CameraKt$Z17Camera$1$2$1(context5, mutableFloatState, state, mutableLongState2, null);
                    mutableFloatState3 = mutableFloatState;
                    composer6.updateRememberedValue(z17CameraKt$Z17Camera$1$2$6);
                    objRememberedValue8 = z17CameraKt$Z17Camera$1$2$6;
                } else {
                    state = stateCollectAsStateWithLifecycle2;
                    mutableLongState2 = mutableLongState;
                    context5 = context2;
                    Z17CameraKt$Z17Camera$1$2$1 z17CameraKt$Z17Camera$1$2$7 = new Z17CameraKt$Z17Camera$1$2$1(context5, mutableFloatState, state, mutableLongState2, null);
                    mutableFloatState3 = mutableFloatState;
                    composer6.updateRememberedValue(z17CameraKt$Z17Camera$1$2$7);
                    objRememberedValue8 = z17CameraKt$Z17Camera$1$2$7;
                }
                EffectsKt.LaunchedEffect(k0Var4, (Function2) objRememberedValue8, composer6, 6);
                CaptureState captureStateZ17Camera$lambda$47$lambda$110 = Z17Camera$lambda$47$lambda$17(stateCollectAsStateWithLifecycle);
                boolean zChanged7 = composer6.changed(stateCollectAsStateWithLifecycle);
                i20 = i19 & 234881024;
                if (i20 == 67108864) {
                    z20 = true;
                } else {
                    z20 = false;
                }
                boolean z311 = zChanged7 | z20;
                if ((i19 & 112) == 32) {
                    z21 = true;
                } else {
                    z21 = false;
                }
                boolean zChangedInstance14 = z311 | z21 | composer6.changedInstance(z17CameraViewModel3);
                if ((i19 & C.ENCODING_PCM_DOUBLE) == 536870912) {
                    z22 = true;
                } else {
                    z22 = false;
                }
                z23 = zChangedInstance14 | z22;
                objRememberedValue9 = composer6.rememberedValue();
                if (z23) {
                    composer7 = composer6;
                    i21 = i20;
                    i22 = 67108864;
                    z17CameraViewModel5 = z17CameraViewModel3;
                    Z17CameraKt$Z17Camera$1$3$1 z17CameraKt$Z17Camera$1$3$6 = new Z17CameraKt$Z17Camera$1$3$1(onResult, imagePathToSave, z17CameraViewModel5, onError, stateCollectAsStateWithLifecycle, mutableFloatState3, null);
                    state2 = stateCollectAsStateWithLifecycle;
                    composer7.updateRememberedValue(z17CameraKt$Z17Camera$1$3$6);
                    objRememberedValue9 = z17CameraKt$Z17Camera$1$3$6;
                } else {
                    composer7 = composer6;
                    i21 = i20;
                    i22 = 67108864;
                    z17CameraViewModel5 = z17CameraViewModel3;
                    Z17CameraKt$Z17Camera$1$3$1 z17CameraKt$Z17Camera$1$3$7 = new Z17CameraKt$Z17Camera$1$3$1(onResult, imagePathToSave, z17CameraViewModel5, onError, stateCollectAsStateWithLifecycle, mutableFloatState3, null);
                    state2 = stateCollectAsStateWithLifecycle;
                    composer7.updateRememberedValue(z17CameraKt$Z17Camera$1$3$7);
                    objRememberedValue9 = z17CameraKt$Z17Camera$1$3$7;
                }
                EffectsKt.LaunchedEffect(captureStateZ17Camera$lambda$47$lambda$110, (Function2) objRememberedValue9, composer7, 0);
                RecordingState recordingStateZ17Camera$lambda$47$lambda$111 = Z17Camera$lambda$47$lambda$18(state);
                state3 = state;
                boolean zChanged8 = composer7.changed(state3);
                if (i21 == i22) {
                    z24 = true;
                } else {
                    z24 = false;
                }
                boolean z312 = zChanged8 | z24;
                if ((i19 & 896) == 256) {
                    z25 = true;
                } else {
                    z25 = false;
                }
                zChangedInstance2 = z312 | z25 | composer7.changedInstance(z17CameraViewModel5);
                objRememberedValue10 = composer7.rememberedValue();
                if (zChangedInstance2) {
                    MutableLongState mutableLongState9 = mutableLongState2;
                    Z17CameraKt$Z17Camera$1$4$1 z17CameraKt$Z17Camera$1$4$6 = new Z17CameraKt$Z17Camera$1$4$1(onResult, videoPathToSave, z17CameraViewModel5, state3, mutableLongState9, mutableFloatState3, null);
                    mutableLongState3 = mutableLongState9;
                    composer7.updateRememberedValue(z17CameraKt$Z17Camera$1$4$6);
                    objRememberedValue10 = z17CameraKt$Z17Camera$1$4$6;
                } else {
                    MutableLongState mutableLongState10 = mutableLongState2;
                    Z17CameraKt$Z17Camera$1$4$1 z17CameraKt$Z17Camera$1$4$7 = new Z17CameraKt$Z17Camera$1$4$1(onResult, videoPathToSave, z17CameraViewModel5, state3, mutableLongState10, mutableFloatState3, null);
                    mutableLongState3 = mutableLongState10;
                    composer7.updateRememberedValue(z17CameraKt$Z17Camera$1$4$7);
                    objRememberedValue10 = z17CameraKt$Z17Camera$1$4$7;
                }
                EffectsKt.LaunchedEffect(recordingStateZ17Camera$lambda$47$lambda$111, (Function2) objRememberedValue10, composer7, 0);
                zChangedInstance3 = composer7.changedInstance(previewView);
                objRememberedValue11 = composer7.rememberedValue();
                if (zChangedInstance3) {
                    objRememberedValue11 = new Function1() { // from class: cu.z17.views.camera.b
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return Z17CameraKt.Z17Camera$lambda$47$lambda$24$lambda$23(previewView, (Context) obj);
                        }
                    };
                    composer7.updateRememberedValue(objRememberedValue11);
                } else {
                    objRememberedValue11 = new Function1() { // from class: cu.z17.views.camera.b
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return Z17CameraKt.Z17Camera$lambda$47$lambda$24$lambda$23(previewView, (Context) obj);
                        }
                    };
                    composer7.updateRememberedValue(objRememberedValue11);
                }
                companion3 = Modifier.INSTANCE;
                composer8 = composer7;
                AndroidView_androidKt.AndroidView((Function1) objRememberedValue11, SizeKt.fillMaxSize$default(companion3, 0.0f, 1, null), null, composer8, 48, 4);
                if (z17) {
                    composer8.startReplaceGroup(-1432532383);
                    Modifier modifierAlign4 = boxScopeInstance.align(WindowInsetsPadding_androidKt.safeContentPadding(companion3), companion.getTopStart());
                    boolean zChangedInstance15 = composer8.changedInstance(z17CameraViewModel5);
                    if ((29360128 & i19) == 8388608) {
                        z30 = true;
                    } else {
                        z30 = false;
                    }
                    z31 = zChangedInstance15 | z30;
                    objRememberedValue15 = composer8.rememberedValue();
                    if (z31) {
                        objRememberedValue15 = new lb.a() { // from class: cu.z17.views.camera.e
                            @Override // lb.a
                            public final Object invoke() {
                                return Z17CameraKt.Z17Camera$lambda$47$lambda$26$lambda$25(z17CameraViewModel5, onClose);
                            }
                        };
                        composer8.updateRememberedValue(objRememberedValue15);
                    } else {
                        objRememberedValue15 = new lb.a() { // from class: cu.z17.views.camera.e
                            @Override // lb.a
                            public final Object invoke() {
                                return Z17CameraKt.Z17Camera$lambda$47$lambda$26$lambda$25(z17CameraViewModel5, onClose);
                            }
                        };
                        composer8.updateRememberedValue(objRememberedValue15);
                    }
                    IconButtonKt.IconButton((lb.a) objRememberedValue15, modifierAlign4, false, null, null, ComposableSingletons$Z17CameraKt.INSTANCE.m10134getLambda$1809404936$views_release(), composer8, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 28);
                    composer4 = composer8;
                } else {
                    composer4 = composer8;
                    composer4.startReplaceGroup(-1439926782);
                }
                composer4.endReplaceGroup();
                if (z18 != 0) {
                    composer4.startReplaceGroup(-1431891179);
                    String strConvertToMS4 = Z17InlineUtilsKt.convertToMS(mutableLongState3.getLongValue());
                    Modifier modifierM1725padding3ABfNKs7 = PaddingKt.m1725padding3ABfNKs(r43.align(companion3, companion.getTopEnd()), Dp.m8823constructorimpl(20));
                    Color.Companion companion12 = Color.INSTANCE;
                    float f17 = 5;
                    Z17LabelKt.m10262Z17LabelfWhpE4E(PaddingKt.m1726paddingVpY3zN4(BackgroundKt.m1204backgroundbw27NRU(modifierM1725padding3ABfNKs7, companion12.m5892getBlack0d7_KjU(), RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(f17))), Dp.m8823constructorimpl(f17), Dp.m8823constructorimpl(3)), strConvertToMS4, null, companion12.m5903getWhite0d7_KjU(), 0, 0, composer4, 3072, 52);
                } else {
                    composer4.startReplaceGroup(-1439926782);
                }
                composer4.endReplaceGroup();
                float f18 = 20;
                Modifier modifierM1729paddingqDBjuR0$default4 = PaddingKt.m1729paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(r43.align(companion3, companion.getBottomCenter()), 0.0f, 1, null), Dp.m8823constructorimpl(f18), 0.0f, Dp.m8823constructorimpl(f18), Dp.m8823constructorimpl(f18), 2, null);
                MeasurePolicy measurePolicyRowMeasurePolicy4 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getSpaceBetween(), companion.getCenterVertically(), composer4, 54);
                currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                CompositionLocalMap currentCompositionLocalMap14 = composer4.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier14 = ComposedModifierKt.materializeModifier(composer4, modifierM1729paddingqDBjuR0$default4);
                constructor2 = companion11.getConstructor();
                if (!r.a(composer4.getApplier())) {
                    ComposablesKt.invalidApplier();
                }
                composer4.startReusableNode();
                if (composer4.getInserting()) {
                    composer4.createNode(constructor2);
                } else {
                    composer4.useNode();
                }
                composerM5176constructorimpl2 = Updater.m5176constructorimpl(composer4);
                Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyRowMeasurePolicy4, companion11.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap14, companion11.getSetResolvedCompositionLocals());
                setCompositeKeyHash2 = companion11.getSetCompositeKeyHash();
                if (composerM5176constructorimpl2.getInserting()) {
                    composerM5176constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    composerM5176constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                } else {
                    composerM5176constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    composerM5176constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                }
                Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier14, companion11.getSetModifier());
                RowScopeInstance rowScopeInstance4 = RowScopeInstance.INSTANCE;
                MaterialTheme materialTheme4 = MaterialTheme.INSTANCE;
                int i36 = MaterialTheme.$stable;
                f10 = 10;
                Modifier modifierClip4 = ClipKt.clip(PaddingKt.m1725padding3ABfNKs(BackgroundKt.m1204backgroundbw27NRU(companion3, Color.m5865copywmQWz5c$default(materialTheme4.getColorScheme(composer4, i36).getBackground(), 0.3f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.getCircleShape()), Dp.m8823constructorimpl(f10)), RoundedCornerShapeKt.getCircleShape());
                zChangedInstance4 = composer4.changedInstance(z17CameraViewModel5);
                objRememberedValue12 = composer4.rememberedValue();
                if (zChangedInstance4) {
                    mutableState2 = mutableState;
                    objRememberedValue12 = new lb.a() { // from class: cu.z17.views.camera.f
                        @Override // lb.a
                        public final Object invoke() {
                            return Z17CameraKt.Z17Camera$lambda$47$lambda$42$lambda$28$lambda$27(z17CameraViewModel5, mutableState2);
                        }
                    };
                    composer4.updateRememberedValue(objRememberedValue12);
                } else {
                    mutableState2 = mutableState;
                    objRememberedValue12 = new lb.a() { // from class: cu.z17.views.camera.f
                        @Override // lb.a
                        public final Object invoke() {
                            return Z17CameraKt.Z17Camera$lambda$47$lambda$42$lambda$28$lambda$27(z17CameraViewModel5, mutableState2);
                        }
                    };
                    composer4.updateRememberedValue(objRememberedValue12);
                }
                Modifier modifierM1238clickableXHw0xAI$default4 = ClickableKt.m1238clickableXHw0xAI$default(modifierClip4, false, null, null, (lb.a) objRememberedValue12, 7, null);
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy11 = BoxKt.maybeCachedBoxMeasurePolicy(companion.getCenter(), false);
                currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                CompositionLocalMap currentCompositionLocalMap15 = composer4.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier15 = ComposedModifierKt.materializeModifier(composer4, modifierM1238clickableXHw0xAI$default4);
                constructor3 = companion11.getConstructor();
                if (!r.a(composer4.getApplier())) {
                    ComposablesKt.invalidApplier();
                }
                composer4.startReusableNode();
                if (composer4.getInserting()) {
                    composer4.createNode(constructor3);
                } else {
                    composer4.useNode();
                }
                composerM5176constructorimpl3 = Updater.m5176constructorimpl(composer4);
                Updater.m5184setimpl(composerM5176constructorimpl3, measurePolicyMaybeCachedBoxMeasurePolicy11, companion11.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl3, currentCompositionLocalMap15, companion11.getSetResolvedCompositionLocals());
                setCompositeKeyHash3 = companion11.getSetCompositeKeyHash();
                if (composerM5176constructorimpl3.getInserting()) {
                    composerM5176constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                    composerM5176constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                } else {
                    composerM5176constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                    composerM5176constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                }
                Updater.m5184setimpl(composerM5176constructorimpl3, modifierMaterializeModifier15, companion11.getSetModifier());
                Modifier modifierM1769size3ABfNKs4 = SizeKt.m1769size3ABfNKs(companion3, Dp.m8823constructorimpl(25));
                if (Z17Camera$lambda$47$lambda$2(mutableState2)) {
                    flashOff = FlashOnKt.getFlashOn(Icons.Outlined.INSTANCE);
                } else {
                    flashOff = FlashOffKt.getFlashOff(Icons.Outlined.INSTANCE);
                }
                Z17PictureKt.m10278Z17BasePictureC8z9wKI(modifierM1769size3ABfNKs4, flashOff, null, ColorFilter.Companion.m5907tintxETnrds$default(ColorFilter.INSTANCE, materialTheme4.getColorScheme(composer4, i36).getOnBackground(), 0, 2, null), null, null, 0, null, null, composer4, 6, XMPPTCPConnection.PacketWriter.QUEUE_SIZE);
                composer4.endNode();
                if (Z17Camera$lambda$47$lambda$18(state3) != RecordingState.RECORDING) {
                    z26 = true;
                } else {
                    z26 = true;
                }
                AnimatedVisibilityKt.AnimatedVisibility(rowScopeInstance4, z26, (Modifier) null, (EnterTransition) null, (ExitTransition) null, (String) null, ComposableLambdaKt.rememberComposableLambda(-381832644, true, new Function3() { // from class: cu.z17.views.camera.g
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return Z17CameraKt.Z17Camera$lambda$47$lambda$42$lambda$33(state3, z17CameraViewModel5, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composer4, 54), composer4, 1572870, 30);
                float fM8823constructorimpl5 = Dp.m8823constructorimpl(4);
                companion4 = Color.INSTANCE;
                Modifier modifierM1216borderxT4_qwU4 = BorderKt.m1216borderxT4_qwU(companion3, fM8823constructorimpl5, companion4.m5903getWhite0d7_KjU(), RoundedCornerShapeKt.getCircleShape());
                if (z18 != 0) {
                    fM8823constructorimpl = Dp.m8823constructorimpl(f10);
                } else {
                    fM8823constructorimpl = Dp.m8823constructorimpl(5);
                }
                Modifier modifierM1725padding3ABfNKs8 = PaddingKt.m1725padding3ABfNKs(modifierM1216borderxT4_qwU4, fM8823constructorimpl);
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy12 = BoxKt.maybeCachedBoxMeasurePolicy(companion.getCenter(), false);
                currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                CompositionLocalMap currentCompositionLocalMap16 = composer4.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier16 = ComposedModifierKt.materializeModifier(composer4, modifierM1725padding3ABfNKs8);
                constructor4 = companion11.getConstructor();
                if (!r.a(composer4.getApplier())) {
                    ComposablesKt.invalidApplier();
                }
                composer4.startReusableNode();
                if (composer4.getInserting()) {
                    composer4.createNode(constructor4);
                } else {
                    composer4.useNode();
                }
                composerM5176constructorimpl4 = Updater.m5176constructorimpl(composer4);
                Updater.m5184setimpl(composerM5176constructorimpl4, measurePolicyMaybeCachedBoxMeasurePolicy12, companion11.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl4, currentCompositionLocalMap16, companion11.getSetResolvedCompositionLocals());
                setCompositeKeyHash4 = companion11.getSetCompositeKeyHash();
                if (composerM5176constructorimpl4.getInserting()) {
                    composerM5176constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                    composerM5176constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
                } else {
                    composerM5176constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                    composerM5176constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
                }
                Updater.m5184setimpl(composerM5176constructorimpl4, modifierMaterializeModifier16, companion11.getSetModifier());
                Modifier modifierBounceClick4 = Z17ButtonsKt.bounceClick(companion3);
                i23 = i19 & 7168;
                if (i23 == 2048) {
                    z27 = true;
                } else {
                    z27 = false;
                }
                context4 = context5;
                zChangedInstance5 = z27 | composer4.changedInstance(z17CameraViewModel5) | composer4.changedInstance(context4) | composer4.changed(state3);
                objRememberedValue13 = composer4.rememberedValue();
                if (zChangedInstance5) {
                    z19 = z18;
                    objRememberedValue13 = new lb.a() { // from class: cu.z17.views.camera.h
                        @Override // lb.a
                        public final Object invoke() {
                            return Z17CameraKt.Z17Camera$lambda$47$lambda$42$lambda$37$lambda$35$lambda$34(z19, z17CameraViewModel5, context4, state3);
                        }
                    };
                    composer4.updateRememberedValue(objRememberedValue13);
                } else {
                    z19 = z18;
                    objRememberedValue13 = new lb.a() { // from class: cu.z17.views.camera.h
                        @Override // lb.a
                        public final Object invoke() {
                            return Z17CameraKt.Z17Camera$lambda$47$lambda$42$lambda$37$lambda$35$lambda$34(z19, z17CameraViewModel5, context4, state3);
                        }
                    };
                    composer4.updateRememberedValue(objRememberedValue13);
                }
                IconButtonKt.IconButton((lb.a) objRememberedValue13, modifierBounceClick4, false, null, null, ComposableLambdaKt.rememberComposableLambda(1107306238, true, new Function2() { // from class: cu.z17.views.camera.i
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return Z17CameraKt.Z17Camera$lambda$47$lambda$42$lambda$37$lambda$36(z19, state3, stateAnimateFloatAsState4, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composer4, 54), composer4, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 28);
                composer4.endNode();
                if (z19) {
                    z28 = true;
                } else {
                    z28 = true;
                }
                final boolean z313 = z19;
                final Z17CameraViewModel z17CameraViewModel14 = z17CameraViewModel5;
                lifecycleOwner5 = lifecycleOwner2;
                AnimatedVisibilityKt.AnimatedVisibility(rowScopeInstance4, z28, (Modifier) null, (EnterTransition) null, (ExitTransition) null, (String) null, ComposableLambdaKt.rememberComposableLambda(-892834829, true, new Function3() { // from class: cu.z17.views.camera.j
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return Z17CameraKt.Z17Camera$lambda$47$lambda$42$lambda$41(z313, z17CameraViewModel14, previewView, lifecycleOwner5, mutableState6, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composer4, 54), composer4, 1572870, 30);
                composer4.endNode();
                if (Z17Camera$lambda$47$lambda$17(state2) == CaptureState.SAVING) {
                    composer4.startReplaceGroup(-1015799063);
                    z29 = true;
                    i24 = 6;
                    BoxKt.Box(BackgroundKt.m1205backgroundbw27NRU$default(SizeKt.fillMaxSize$default(companion3, 0.0f, 1, null), Color.m5865copywmQWz5c$default(companion4.m5892getBlack0d7_KjU(), 0.2f, 0.0f, 0.0f, 0.0f, 14, null), null, 2, null), composer4, 6);
                } else {
                    i24 = 6;
                    z29 = true;
                    composer4.startReplaceGroup(-1439926782);
                }
                composer4.endReplaceGroup();
                Boolean boolValueOf4 = Boolean.valueOf(z19);
                if (i23 != 2048) {
                    z29 = false;
                }
                zChangedInstance6 = composer4.changedInstance(z17CameraViewModel5) | z29 | composer4.changedInstance(previewView) | composer4.changedInstance(lifecycleOwner5);
                Object objRememberedValue19 = composer4.rememberedValue();
                if (zChangedInstance6) {
                    Z17CameraViewModel z17CameraViewModel15 = z17CameraViewModel5;
                    lifecycleOwner4 = lifecycleOwner5;
                    z17CameraKt$Z17Camera$1$8$1 = new Z17CameraKt$Z17Camera$1$8$1(z19, z17CameraViewModel15, previewView, lifecycleOwner4, null);
                    z17CameraViewModel4 = z17CameraViewModel15;
                    composer4.updateRememberedValue(z17CameraKt$Z17Camera$1$8$1);
                } else {
                    Z17CameraViewModel z17CameraViewModel16 = z17CameraViewModel5;
                    lifecycleOwner4 = lifecycleOwner5;
                    z17CameraKt$Z17Camera$1$8$1 = new Z17CameraKt$Z17Camera$1$8$1(z19, z17CameraViewModel16, previewView, lifecycleOwner4, null);
                    z17CameraViewModel4 = z17CameraViewModel16;
                    composer4.updateRememberedValue(z17CameraKt$Z17Camera$1$8$1);
                }
                EffectsKt.LaunchedEffect(boolValueOf4, (Function2) z17CameraKt$Z17Camera$1$8$1, composer4, (i19 >> 9) & 14);
                zChangedInstance7 = composer4.changedInstance(configuration) | composer4.changedInstance(context4);
                objRememberedValue14 = composer4.rememberedValue();
                if (zChangedInstance7) {
                    objRememberedValue14 = new Function1() { // from class: cu.z17.views.camera.k
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return Z17CameraKt.Z17Camera$lambda$47$lambda$46$lambda$45(configuration, context4, (DisposableEffectScope) obj);
                        }
                    };
                    composer4.updateRememberedValue(objRememberedValue14);
                } else {
                    objRememberedValue14 = new Function1() { // from class: cu.z17.views.camera.k
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return Z17CameraKt.Z17Camera$lambda$47$lambda$46$lambda$45(configuration, context4, (DisposableEffectScope) obj);
                        }
                    };
                    composer4.updateRememberedValue(objRememberedValue14);
                }
                EffectsKt.DisposableEffect(k0Var4, (Function1) objRememberedValue14, composer4, i24);
                composer4.endNode();
            } else {
                z17CameraViewModel4 = z17CameraViewModel3;
                context4 = context2;
                modifier4 = modifier4;
                z19 = z18;
                composer4 = composer3;
                lifecycleOwner4 = lifecycleOwner2;
                composer4.startReplaceGroup(125040547);
            }
            composer4.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer2 = composer4;
            z15 = z19;
            context3 = context4;
            lifecycleOwner3 = lifecycleOwner4;
            modifier2 = modifier4;
            z14 = z17;
            z17CameraViewModel2 = z17CameraViewModel4;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            modifier2 = modifier;
            z14 = z11;
            composer2 = composerStartRestartGroup;
            context3 = context2;
            lifecycleOwner3 = lifecycleOwner2;
            z15 = z12;
            z17CameraViewModel2 = z17CameraViewModel;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.camera.l
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return Z17CameraKt.Z17Camera$lambda$48(modifier2, imagePathToSave, videoPathToSave, z15, lifecycleOwner3, z17CameraViewModel2, context3, onClose, onResult, onError, z14, i10, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void Z17Camera$lambda$47$handleFlashLight(Z17CameraViewModel z17CameraViewModel, MutableState<Boolean> mutableState) {
        Z17Camera$lambda$47$lambda$3(mutableState, !Z17Camera$lambda$47$lambda$2(mutableState));
        z17CameraViewModel.handleFlashMode(Z17Camera$lambda$47$lambda$2(mutableState));
    }

    private static final float Z17Camera$lambda$47$lambda$16(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CaptureState Z17Camera$lambda$47$lambda$17(State<? extends CaptureState> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RecordingState Z17Camera$lambda$47$lambda$18(State<? extends RecordingState> state) {
        return state.getValue();
    }

    private static final boolean Z17Camera$lambda$47$lambda$2(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PreviewView Z17Camera$lambda$47$lambda$24$lambda$23(PreviewView previewView, Context it) {
        y.i(it, "it");
        return previewView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 Z17Camera$lambda$47$lambda$26$lambda$25(Z17CameraViewModel z17CameraViewModel, lb.a aVar) throws Throwable {
        z17CameraViewModel.cancelRecord();
        aVar.invoke();
        return k0.f43947a;
    }

    private static final void Z17Camera$lambda$47$lambda$3(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 Z17Camera$lambda$47$lambda$42$lambda$28$lambda$27(Z17CameraViewModel z17CameraViewModel, MutableState mutableState) {
        Z17Camera$lambda$47$handleFlashLight(z17CameraViewModel, mutableState);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 Z17Camera$lambda$47$lambda$42$lambda$33(final State state, final Z17CameraViewModel z17CameraViewModel, AnimatedVisibilityScope AnimatedVisibility, Composer composer, int i10) {
        y.i(AnimatedVisibility, "$this$AnimatedVisibility");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-381832644, i10, -1, "cu.z17.views.camera.Z17Camera.<anonymous>.<anonymous>.<anonymous> (Z17Camera.kt:254)");
        }
        Modifier modifierBounceClick = Z17ButtonsKt.bounceClick(SizeKt.m1769size3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(40)));
        boolean zChanged = composer.changed(state) | composer.changedInstance(z17CameraViewModel);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new lb.a() { // from class: cu.z17.views.camera.c
                @Override // lb.a
                public final Object invoke() {
                    return Z17CameraKt.Z17Camera$lambda$47$lambda$42$lambda$33$lambda$31$lambda$30(z17CameraViewModel, state);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        IconButtonKt.IconButton((lb.a) objRememberedValue, modifierBounceClick, false, null, null, ComposableLambdaKt.rememberComposableLambda(1188029721, true, new Function2() { // from class: cu.z17.views.camera.d
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return Z17CameraKt.Z17Camera$lambda$47$lambda$42$lambda$33$lambda$32(state, (Composer) obj, ((Integer) obj2).intValue());
            }
        }, composer, 54), composer, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 28);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 Z17Camera$lambda$47$lambda$42$lambda$33$lambda$31$lambda$30(Z17CameraViewModel z17CameraViewModel, State state) {
        if (Z17Camera$lambda$47$lambda$18(state) == RecordingState.PAUSE) {
            z17CameraViewModel.resumeRecord();
        } else {
            z17CameraViewModel.pauseRecord();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 Z17Camera$lambda$47$lambda$42$lambda$33$lambda$32(State state, Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1188029721, i10, -1, "cu.z17.views.camera.Z17Camera.<anonymous>.<anonymous>.<anonymous>.<anonymous> (Z17Camera.kt:262)");
            }
            Z17PictureKt.m10278Z17BasePictureC8z9wKI(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), Z17Camera$lambda$47$lambda$18(state) == RecordingState.PAUSE ? PlayCircleFilledKt.getPlayCircleFilled(Icons.Filled.INSTANCE) : PauseCircleFilledKt.getPauseCircleFilled(Icons.Filled.INSTANCE), null, ColorFilter.Companion.m5907tintxETnrds$default(ColorFilter.INSTANCE, ColorKt.Color(4291176488L), 0, 2, null), null, null, 0, null, null, composer, 3078, XMPPTCPConnection.PacketWriter.QUEUE_SIZE);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 Z17Camera$lambda$47$lambda$42$lambda$37$lambda$35$lambda$34(boolean z10, Z17CameraViewModel z17CameraViewModel, Context context, State state) throws Throwable {
        if (!z10) {
            z17CameraViewModel.captureAndSaveImage(context);
        } else if (Z17Camera$lambda$47$lambda$18(state) == RecordingState.NOT_REQUESTED) {
            z17CameraViewModel.startVideoRecord(context);
        } else {
            z17CameraViewModel.stopRecord();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 Z17Camera$lambda$47$lambda$42$lambda$37$lambda$36(boolean z10, State state, State state2, Composer composer, int i10) {
        long jM5903getWhite0d7_KjU;
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1107306238, i10, -1, "cu.z17.views.camera.Z17Camera.<anonymous>.<anonymous>.<anonymous>.<anonymous> (Z17Camera.kt:297)");
            }
            if (z10) {
                composer.startReplaceGroup(-1883609074);
                Modifier modifierM1725padding3ABfNKs = PaddingKt.m1725padding3ABfNKs(SizeKt.m1769size3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(50)), Dp.m8823constructorimpl(5));
                if (Z17Camera$lambda$47$lambda$18(state) == RecordingState.RECORDING) {
                    composer.startReplaceGroup(-1030582075);
                    jM5903getWhite0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getPrimary();
                    composer.endReplaceGroup();
                } else {
                    composer.startReplaceGroup(-1030581469);
                    composer.endReplaceGroup();
                    jM5903getWhite0d7_KjU = Color.INSTANCE.m5903getWhite0d7_KjU();
                }
                BoxKt.Box(BackgroundKt.m1204backgroundbw27NRU(modifierM1725padding3ABfNKs, jM5903getWhite0d7_KjU, RoundedCornerShapeKt.getCircleShape()), composer, 0);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-1030574647);
                Modifier modifierM1769size3ABfNKs = SizeKt.m1769size3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(40));
                Color.Companion companion = Color.INSTANCE;
                Z17PictureKt.m10278Z17BasePictureC8z9wKI(RotateKt.rotate(PaddingKt.m1725padding3ABfNKs(BackgroundKt.m1204backgroundbw27NRU(modifierM1769size3ABfNKs, companion.m5903getWhite0d7_KjU(), RoundedCornerShapeKt.getCircleShape()), Dp.m8823constructorimpl(10)), Z17Camera$lambda$47$lambda$16(state2)), CameraAltKt.getCameraAlt(Icons.Outlined.INSTANCE), null, ColorFilter.Companion.m5907tintxETnrds$default(ColorFilter.INSTANCE, companion.m5892getBlack0d7_KjU(), 0, 2, null), null, null, 0, null, null, composer, 3072, XMPPTCPConnection.PacketWriter.QUEUE_SIZE);
                composer.endReplaceGroup();
            }
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
    public static final k0 Z17Camera$lambda$47$lambda$42$lambda$41(final boolean z10, final Z17CameraViewModel z17CameraViewModel, final PreviewView previewView, final LifecycleOwner lifecycleOwner, final MutableState mutableState, AnimatedVisibilityScope AnimatedVisibility, Composer composer, int i10) {
        y.i(AnimatedVisibility, "$this$AnimatedVisibility");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-892834829, i10, -1, "cu.z17.views.camera.Z17Camera.<anonymous>.<anonymous>.<anonymous> (Z17Camera.kt:326)");
        }
        Modifier.Companion companion = Modifier.INSTANCE;
        MaterialTheme materialTheme = MaterialTheme.INSTANCE;
        int i11 = MaterialTheme.$stable;
        Modifier modifierM1725padding3ABfNKs = PaddingKt.m1725padding3ABfNKs(BackgroundKt.m1204backgroundbw27NRU(companion, Color.m5865copywmQWz5c$default(materialTheme.getColorScheme(composer, i11).getBackground(), 0.3f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.getCircleShape()), Dp.m8823constructorimpl(10));
        boolean zChanged = composer.changed(z10) | composer.changedInstance(z17CameraViewModel) | composer.changedInstance(previewView) | composer.changedInstance(lifecycleOwner);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            lb.a aVar = new lb.a() { // from class: cu.z17.views.camera.m
                @Override // lb.a
                public final Object invoke() {
                    return Z17CameraKt.Z17Camera$lambda$47$lambda$42$lambda$41$lambda$39$lambda$38(z10, z17CameraViewModel, previewView, lifecycleOwner, mutableState);
                }
            };
            composer.updateRememberedValue(aVar);
            objRememberedValue = aVar;
        }
        Modifier modifierM1238clickableXHw0xAI$default = ClickableKt.m1238clickableXHw0xAI$default(modifierM1725padding3ABfNKs, false, null, null, (lb.a) objRememberedValue, 7, null);
        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getCenter(), false);
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
        CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierM1238clickableXHw0xAI$default);
        ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
        lb.a constructor = companion2.getConstructor();
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
        Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, companion2.getSetMeasurePolicy());
        Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
        Function2 setCompositeKeyHash = companion2.getSetCompositeKeyHash();
        if (composerM5176constructorimpl.getInserting() || !y.d(composerM5176constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
            composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
        }
        Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion2.getSetModifier());
        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
        Z17PictureKt.m10278Z17BasePictureC8z9wKI(SizeKt.m1769size3ABfNKs(companion, Dp.m8823constructorimpl(25)), CameraswitchKt.getCameraswitch(Icons.Outlined.INSTANCE), null, ColorFilter.Companion.m5907tintxETnrds$default(ColorFilter.INSTANCE, materialTheme.getColorScheme(composer, i11).getOnBackground(), 0, 2, null), null, null, 0, null, null, composer, 6, XMPPTCPConnection.PacketWriter.QUEUE_SIZE);
        composer.endNode();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 Z17Camera$lambda$47$lambda$42$lambda$41$lambda$39$lambda$38(boolean z10, Z17CameraViewModel z17CameraViewModel, PreviewView previewView, LifecycleOwner lifecycleOwner, MutableState mutableState) {
        if (Z17Camera$lambda$47$lambda$8(mutableState)) {
            Z17CameraModule.INSTANCE.getInstance().changeToBackCamera();
        } else {
            Z17CameraModule.INSTANCE.getInstance().changeToFrontCamera();
        }
        Z17Camera$lambda$47$lambda$9(mutableState, !Z17Camera$lambda$47$lambda$8(mutableState));
        if (z10) {
            z17CameraViewModel.showVideoCamera(previewView, lifecycleOwner);
        } else {
            z17CameraViewModel.showCamera(previewView, lifecycleOwner);
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult Z17Camera$lambda$47$lambda$46$lambda$45(Configuration configuration, final Context context, DisposableEffectScope DisposableEffect) {
        y.i(DisposableEffect, "$this$DisposableEffect");
        final int i10 = configuration.orientation;
        return new DisposableEffectResult() { // from class: cu.z17.views.camera.Z17CameraKt$Z17Camera$lambda$47$lambda$46$lambda$45$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                Z17CameraModule.INSTANCE.getInstance().getProcessCameraProvider().unbindAll();
                try {
                    Z17InlineUtilsKt.findActivity(context).setRequestedOrientation(i10);
                } catch (Exception e10) {
                    e10.printStackTrace();
                }
            }
        };
    }

    private static final boolean Z17Camera$lambda$47$lambda$8(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void Z17Camera$lambda$47$lambda$9(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 Z17Camera$lambda$48(Modifier modifier, String str, String str2, boolean z10, LifecycleOwner lifecycleOwner, Z17CameraViewModel z17CameraViewModel, Context context, lb.a aVar, o oVar, lb.a aVar2, boolean z11, int i10, int i11, int i12, Composer composer, int i13) {
        Z17Camera(modifier, str, str2, z10, lifecycleOwner, z17CameraViewModel, context, aVar, oVar, aVar2, z11, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), RecomposeScopeImplKt.updateChangedFlags(i11), i12);
        return k0.f43947a;
    }
}
