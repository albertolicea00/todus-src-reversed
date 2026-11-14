package cu.todus.android.uiCompose.shared.camera;

import android.content.Context;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import androidx.camera.video.VideoSpec;
import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.foundation.layout.e3;
import androidx.compose.foundation.pager.PagerKt;
import androidx.compose.foundation.pager.PagerScope;
import androidx.compose.foundation.pager.PagerState;
import androidx.compose.foundation.pager.PagerStateKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.MenuKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.outlined.DeleteOutlineKt;
import androidx.compose.material.icons.outlined.FolderKt;
import androidx.compose.material3.BottomSheetScaffoldKt;
import androidx.compose.material3.BottomSheetScaffoldState;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.common.C;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.p000activity.compose.ActivityResultRegistryKt;
import androidx.p000activity.compose.BackHandlerKt;
import androidx.p000activity.compose.ManagedActivityResultLauncher;
import androidx.p000activity.result.contract.ActivityResultContracts;
import androidx.profileinstaller.ProfileVerifier;
import cu.todus.android.data.paths.DirectoryPaths;
import cu.todus.android.data.util.MediaUtil;
import cu.todus.android.uiCompose.shared.modal.ModalKt;
import cu.z17.views.R;
import cu.z17.views.camera.ResultType;
import cu.z17.views.camera.Z17CameraKt;
import cu.z17.views.inputText.Z17InputTextKt;
import cu.z17.views.label.Z17LabelKt;
import cu.z17.views.label.Z17MarkdownLabelKt;
import cu.z17.views.permission.PermissionNeedIt;
import cu.z17.views.permission.PermissionsRequesterState;
import cu.z17.views.permission.PermissionsResult;
import cu.z17.views.permission.Z17PermissionRequesterKt;
import cu.z17.views.picturesAlbum.data.AlbumConfiguration;
import cu.z17.views.picturesAlbum.data.AlbumImage;
import cu.z17.views.picturesAlbum.data.AlbumOption;
import cu.z17.views.picturesAlbum.ui.Z17FullSizeAlbumKt;
import cu.z17.views.picturesAlbum.ui.Z17RowAlbumKt;
import cu.z17.views.videoEditor.VideoEditorConfigurations;
import cu.z17.views.videoEditor.Z17VideoEditorKt;
import cu.z17.views.videosAlbum.data.VideoAlbum;
import cu.z17.views.videosAlbum.data.VideoAlbumConfiguration;
import cu.z17.views.videosAlbum.ui.Z17FullSizeVideoAlbumKt;
import cu.z17.views.videosAlbum.ui.Z17RowVideoAlbumKt;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aÁ\u0001\u0010\u0016\u001a\u00020\u000f2\b\b\u0002\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\t2\u001e\u0010\u0010\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\u000b2\u001e\u0010\u0011\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\u000b2\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00122\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00122\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0012H\u0007¢\u0006\u0004\b\u0016\u0010\u0017\u001aÑ\u0001\u0010\u001b\u001a\u00020\u000f2\b\b\u0002\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u00042\u001e\u0010\u0010\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\u000b2\u001e\u0010\u0011\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\u000b2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00122\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00122\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00122\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000f0\u0019H\u0007¢\u0006\u0004\b\u001b\u0010\u001c\u001a\u008f\u0001\u0010#\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u000e2$\u0010\"\u001a \u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u000f0\u001f2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00122\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00122\u0006\u0010\u0018\u001a\u00020\u00042\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000f0\u0019H\u0007¢\u0006\u0004\b#\u0010$\u001am\u0010(\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010&\u001a\u00020!2\u0018\u0010\"\u001a\u0014\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\u000b2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00122\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0012H\u0007¢\u0006\u0004\b(\u0010)\u001am\u0010,\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010*\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u000e2\u0006\u0010+\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0018\u0010\"\u001a\u0014\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\u000b2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00122\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0012H\u0007¢\u0006\u0004\b,\u0010-¨\u00063²\u0006\u000e\u0010\u0018\u001a\u00020\u00048\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010%\u001a\u00020\u000e8\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010&\u001a\u00020!8\n@\nX\u008a\u008e\u0002²\u0006\u001a\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\t0.8\n@\nX\u008a\u008e\u0002²\u0006\u000e\u00100\u001a\u00020\u000e8\n@\nX\u008a\u008e\u0002²\u0006\u000e\u00101\u001a\u00020\u00048\n@\nX\u008a\u008e\u0002²\u0006\u000e\u00102\u001a\u00020\u00048\n@\nX\u008a\u008e\u0002²\u0006\u000e\u00100\u001a\u00020\u000e8\n@\nX\u008a\u008e\u0002²\u0006\u000e\u00101\u001a\u00020\u00048\n@\nX\u008a\u008e\u0002²\u0006\u000e\u00102\u001a\u00020\u00048\n@\nX\u008a\u008e\u0002"}, d2 = {"Landroidx/compose/ui/Modifier;", "modifier", "Lcu/todus/android/uiCompose/shared/camera/CameraParams;", "cameraParams", "", "showVideoOption", "enableImageFoot", "enableDeleteImage", "autoFirstCompression", "", "maxVideoDuration", "Lkotlin/Function2;", "", "Ljava/io/File;", "", "Lua/k0;", "sendVideos", "sendImages", "Lkotlin/Function0;", "onDelete", "onClose", "onError", "Camera", "(Landroidx/compose/ui/Modifier;Lcu/todus/android/uiCompose/shared/camera/CameraParams;ZZZZJLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Llb/a;Llb/a;Llb/a;Landroidx/compose/runtime/Composer;III)V", "isVideo", "Lkotlin/Function1;", "changeIsVideo", "CameraPager", "(Landroidx/compose/ui/Modifier;Lcu/todus/android/uiCompose/shared/camera/CameraParams;ZZZZJZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Llb/a;Llb/a;Llb/a;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;III)V", "imagePathToSave", "videoPathToSave", "Lkotlin/Function4;", "Lcu/z17/views/camera/ResultType;", "", "onResult", "CameraViewPage", "(ZZLjava/lang/String;Ljava/lang/String;Llb/o;Llb/a;Llb/a;ZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "imagePath", "initialRotation", "retry", "ImageEditorViewPage", "(ZLjava/lang/String;Ljava/lang/String;ZFLkotlin/jvm/functions/Function2;Llb/a;Llb/a;Landroidx/compose/runtime/Composer;I)V", "videoPath", TypedValues.TransitionType.S_DURATION, "VideoEditorViewPage", "(ZLjava/lang/String;Ljava/lang/String;JJLkotlin/jvm/functions/Function2;Llb/a;Llb/a;Landroidx/compose/runtime/Composer;I)V", "Lkotlin/Pair;", "videoPathAndDuration", "stringContent", "isReady", "wasEdited", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class CameraKt {

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ResultType.values().length];
            try {
                iArr[ResultType.VIDEO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ResultType.PHOTO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ResultType.DELETE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Code duplicated, block: B:100:0x013b  */
    /* JADX WARN: Code duplicated, block: B:104:0x0143  */
    /* JADX WARN: Code duplicated, block: B:106:0x0149  */
    /* JADX WARN: Code duplicated, block: B:107:0x014c  */
    /* JADX WARN: Code duplicated, block: B:109:0x0151  */
    /* JADX WARN: Code duplicated, block: B:112:0x0157  */
    /* JADX WARN: Code duplicated, block: B:114:0x015d  */
    /* JADX WARN: Code duplicated, block: B:115:0x0160  */
    /* JADX WARN: Code duplicated, block: B:119:0x0170  */
    /* JADX WARN: Code duplicated, block: B:123:0x0179  */
    /* JADX WARN: Code duplicated, block: B:126:0x0182 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:127:0x0184  */
    /* JADX WARN: Code duplicated, block: B:128:0x0189  */
    /* JADX WARN: Code duplicated, block: B:130:0x018d  */
    /* JADX WARN: Code duplicated, block: B:131:0x019f  */
    /* JADX WARN: Code duplicated, block: B:133:0x01a2  */
    /* JADX WARN: Code duplicated, block: B:134:0x01a4  */
    /* JADX WARN: Code duplicated, block: B:136:0x01a7  */
    /* JADX WARN: Code duplicated, block: B:138:0x01aa  */
    /* JADX WARN: Code duplicated, block: B:139:0x01ac  */
    /* JADX WARN: Code duplicated, block: B:141:0x01af  */
    /* JADX WARN: Code duplicated, block: B:142:0x01b1  */
    /* JADX WARN: Code duplicated, block: B:144:0x01b5  */
    /* JADX WARN: Code duplicated, block: B:145:0x01bb  */
    /* JADX WARN: Code duplicated, block: B:147:0x01bf  */
    /* JADX WARN: Code duplicated, block: B:149:0x01cb  */
    /* JADX WARN: Code duplicated, block: B:151:0x01d7  */
    /* JADX WARN: Code duplicated, block: B:154:0x01df  */
    /* JADX WARN: Code duplicated, block: B:157:0x01f9  */
    /* JADX WARN: Code duplicated, block: B:160:0x026e  */
    /* JADX WARN: Code duplicated, block: B:163:0x027a  */
    /* JADX WARN: Code duplicated, block: B:164:0x027e  */
    /* JADX WARN: Code duplicated, block: B:167:0x02bb  */
    /* JADX WARN: Code duplicated, block: B:170:0x02dc  */
    /* JADX WARN: Code duplicated, block: B:171:0x0314  */
    /* JADX WARN: Code duplicated, block: B:174:0x0334  */
    /* JADX WARN: Code duplicated, block: B:177:0x034a  */
    /* JADX WARN: Code duplicated, block: B:180:0x0396  */
    /* JADX WARN: Code duplicated, block: B:183:0x03aa  */
    /* JADX WARN: Code duplicated, block: B:186:0x03d6  */
    /* JADX WARN: Code duplicated, block: B:187:0x03e5  */
    /* JADX WARN: Code duplicated, block: B:191:0x0409  */
    /* JADX WARN: Code duplicated, block: B:196:0x0475  */
    /* JADX WARN: Code duplicated, block: B:198:0x047b  */
    /* JADX WARN: Code duplicated, block: B:201:0x0493  */
    /* JADX WARN: Code duplicated, block: B:203:0x049f  */
    /* JADX WARN: Code duplicated, block: B:206:0x04b2  */
    /* JADX WARN: Code duplicated, block: B:208:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:36:0x0083  */
    /* JADX WARN: Code duplicated, block: B:38:0x0088  */
    /* JADX WARN: Code duplicated, block: B:40:0x008c  */
    /* JADX WARN: Code duplicated, block: B:42:0x0094  */
    /* JADX WARN: Code duplicated, block: B:43:0x0097  */
    /* JADX WARN: Code duplicated, block: B:47:0x009f  */
    /* JADX WARN: Code duplicated, block: B:49:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:51:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:53:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:54:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:58:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:59:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:61:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:63:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:64:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:68:0x00db  */
    /* JADX WARN: Code duplicated, block: B:70:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:72:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:74:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:75:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:79:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:81:0x0103  */
    /* JADX WARN: Code duplicated, block: B:82:0x0106  */
    /* JADX WARN: Code duplicated, block: B:86:0x0110  */
    /* JADX WARN: Code duplicated, block: B:88:0x0116  */
    /* JADX WARN: Code duplicated, block: B:89:0x0119  */
    /* JADX WARN: Code duplicated, block: B:93:0x0123  */
    /* JADX WARN: Code duplicated, block: B:95:0x012a  */
    /* JADX WARN: Code duplicated, block: B:97:0x012e  */
    /* JADX WARN: Code duplicated, block: B:99:0x0138  */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void Camera(Modifier modifier, CameraParams cameraParams, boolean z10, boolean z11, boolean z12, boolean z13, long j10, final Function2 sendVideos, final Function2 sendImages, lb.a aVar, final lb.a onClose, final lb.a onError, Composer composer, final int i10, final int i11, final int i12) {
        Modifier modifier2;
        int i13;
        CameraParams cameraParams2;
        boolean z14;
        int i14;
        boolean z15;
        int i15;
        int i16;
        final boolean z16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        int i23;
        int i24;
        int i25;
        boolean z17;
        final long j11;
        final CameraParams cameraParams3;
        final Modifier modifier3;
        final boolean z18;
        final boolean z19;
        final boolean z20;
        final lb.a aVar2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier modifier4;
        CameraParams cameraParams4;
        boolean z21;
        boolean z22;
        boolean z23;
        long j12;
        Object objRememberedValue;
        Composer.Companion companion;
        CameraParams cameraParams5;
        lb.a constructor;
        boolean z24;
        Object objRememberedValue2;
        final MutableState mutableState;
        SoftwareKeyboardController softwareKeyboardController;
        Object objRememberedValue3;
        final MutableState mutableState2;
        Object objRememberedValue4;
        Object objRememberedValue5;
        boolean z25;
        boolean z26;
        Object objRememberedValue6;
        Object objRememberedValue7;
        Integer state;
        Object objRememberedValue8;
        boolean z27;
        long j13;
        boolean z28;
        boolean z29;
        CameraParams cameraParams6;
        boolean z30;
        boolean zChanged;
        Object objRememberedValue9;
        Object objRememberedValue10;
        int i26;
        int i27;
        int i28;
        int i29;
        kotlin.jvm.internal.y.i(sendVideos, "sendVideos");
        kotlin.jvm.internal.y.i(sendImages, "sendImages");
        kotlin.jvm.internal.y.i(onClose, "onClose");
        kotlin.jvm.internal.y.i(onError, "onError");
        Composer composerStartRestartGroup = composer.startRestartGroup(1559415396);
        int i30 = i12 & 1;
        if (i30 != 0) {
            i13 = i10 | 6;
            modifier2 = modifier;
        } else if ((i10 & 6) == 0) {
            modifier2 = modifier;
            i13 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i10;
        } else {
            modifier2 = modifier;
            i13 = i10;
        }
        int i31 = i12 & 2;
        if (i31 != 0) {
            i13 |= 48;
            cameraParams2 = cameraParams;
        } else {
            cameraParams2 = cameraParams;
            if ((i10 & 48) == 0) {
                i13 |= composerStartRestartGroup.changed(cameraParams2) ? 32 : 16;
            }
        }
        int i32 = i12 & 4;
        if (i32 == 0) {
            if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                z14 = z10;
                i13 |= composerStartRestartGroup.changed(z14) ? 256 : 128;
            }
            i14 = i12 & 8;
            if (i14 != 0) {
                if ((i10 & 3072) == 0) {
                    z15 = z11;
                    if (composerStartRestartGroup.changed(z15)) {
                        i15 = 2048;
                    } else {
                        i15 = 1024;
                    }
                    i13 |= i15;
                }
                i16 = i12 & 16;
                if (i16 != 0) {
                    if ((i10 & 24576) == 0) {
                        z16 = z12;
                        if (composerStartRestartGroup.changed(z16)) {
                            i17 = 16384;
                        } else {
                            i17 = 8192;
                        }
                        i13 |= i17;
                    }
                    i18 = i12 & 32;
                    if (i18 != 0) {
                        i13 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    } else if ((i10 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        if (composerStartRestartGroup.changed(z13)) {
                            i19 = 131072;
                        } else {
                            i19 = 65536;
                        }
                        i13 |= i19;
                    }
                    i20 = i12 & 64;
                    if (i20 != 0) {
                        if ((i10 & 1572864) == 0) {
                            if (composerStartRestartGroup.changed(j10)) {
                                i21 = 1048576;
                            } else {
                                i21 = 524288;
                            }
                            i13 |= i21;
                        }
                        if ((i10 & 12582912) == 0) {
                            if (composerStartRestartGroup.changedInstance(sendVideos)) {
                                i29 = 8388608;
                            } else {
                                i29 = 4194304;
                            }
                            i13 |= i29;
                        }
                        if ((i10 & 100663296) == 0) {
                            if (composerStartRestartGroup.changedInstance(sendImages)) {
                                i28 = 67108864;
                            } else {
                                i28 = 33554432;
                            }
                            i13 |= i28;
                        }
                        i22 = i12 & 512;
                        if (i22 != 0) {
                            if ((i10 & 805306368) == 0) {
                                if (composerStartRestartGroup.changedInstance(aVar)) {
                                    i23 = C.BUFFER_FLAG_LAST_SAMPLE;
                                } else {
                                    i23 = 268435456;
                                }
                                i13 |= i23;
                            }
                            if ((i11 & 6) == 0) {
                                if (composerStartRestartGroup.changedInstance(onClose)) {
                                    i27 = 4;
                                } else {
                                    i27 = 2;
                                }
                                i24 = i11 | i27;
                            } else {
                                i24 = i11;
                            }
                            if ((i11 & 48) == 0) {
                                if (composerStartRestartGroup.changedInstance(onError)) {
                                    i26 = 32;
                                } else {
                                    i26 = 16;
                                }
                                i24 |= i26;
                            }
                            i25 = i24;
                            if ((i13 & 306783379) == 306783378 || (i25 & 19) != 18) {
                                z17 = true;
                            } else {
                                z17 = false;
                            }
                            if (composerStartRestartGroup.shouldExecute(z17, i13 & 1)) {
                                if (i30 != 0) {
                                    modifier4 = Modifier.INSTANCE;
                                } else {
                                    modifier4 = modifier2;
                                }
                                if (i31 != 0) {
                                    cameraParams4 = new CameraParams(null, null, 0L, 7, null);
                                } else {
                                    cameraParams4 = cameraParams2;
                                }
                                if (i32 != 0) {
                                    z21 = true;
                                } else {
                                    z21 = z14;
                                }
                                if (i14 != 0) {
                                    z15 = true;
                                }
                                if (i16 != 0) {
                                    z22 = false;
                                } else {
                                    z22 = z16;
                                }
                                if (i18 != 0) {
                                    z23 = false;
                                } else {
                                    z23 = z13;
                                }
                                if (i20 != 0) {
                                    j12 = Long.MAX_VALUE;
                                } else {
                                    j12 = j10;
                                }
                                if (i22 != 0) {
                                    objRememberedValue10 = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue10 == Composer.INSTANCE.getEmpty()) {
                                        objRememberedValue10 = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.f
                                            @Override // lb.a
                                            public final Object invoke() {
                                                return ua.k0.f43947a;
                                            }
                                        };
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue10);
                                    }
                                    aVar2 = (lb.a) objRememberedValue10;
                                } else {
                                    aVar2 = aVar;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1559415396, i13, i25, "cu.todus.android.uiCompose.shared.camera.Camera (Camera.kt:107)");
                                }
                                Modifier modifierImePadding = WindowInsetsPadding_androidKt.imePadding(modifier4);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                companion = Composer.INSTANCE;
                                if (objRememberedValue == companion.getEmpty()) {
                                    objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.g
                                        @Override // lb.a
                                        public final Object invoke() {
                                            return ua.k0.f43947a;
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                Modifier modifierM1205backgroundbw27NRU$default = BackgroundKt.m1205backgroundbw27NRU$default(ClickableKt.m1240clickableoSLSa3U$default(modifierImePadding, false, null, null, null, (lb.a) objRememberedValue, 14, null), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground(), null, 2, null);
                                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                                int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1205backgroundbw27NRU$default);
                                ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                                cameraParams5 = cameraParams4;
                                constructor = companion2.getConstructor();
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
                                z24 = z21;
                                Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, companion2.getSetMeasurePolicy());
                                Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
                                Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion2.getSetCompositeKeyHash());
                                Updater.m5182reconcileimpl(composerM5176constructorimpl, companion2.getApplyOnDeactivatedNodeAssertion());
                                Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion2.getSetModifier());
                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue2 == companion.getEmpty()) {
                                    objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                                }
                                mutableState = (MutableState) objRememberedValue2;
                                softwareKeyboardController = (SoftwareKeyboardController) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalSoftwareKeyboardController());
                                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue3 == companion.getEmpty()) {
                                    objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new PermissionsRequesterState(null, false, va.w.q(PermissionNeedIt.STORAGE, PermissionNeedIt.CAMERA, PermissionNeedIt.RECORD_AUDIO), 1, null), null, 2, null);
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                                }
                                mutableState2 = (MutableState) objRememberedValue3;
                                Context context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                                PermissionsRequesterState permissionsRequesterState = (PermissionsRequesterState) mutableState2.getValue();
                                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue4 == companion.getEmpty()) {
                                    objRememberedValue4 = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.h
                                        @Override // lb.a
                                        public final Object invoke() {
                                            return CameraKt.Camera$lambda$2$4$0(mutableState2);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                                }
                                lb.a aVar3 = (lb.a) objRememberedValue4;
                                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue5 == companion.getEmpty()) {
                                    objRememberedValue5 = new Function1() { // from class: cu.todus.android.uiCompose.shared.camera.i
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            return CameraKt.Camera$lambda$2$5$0(mutableState2, (PermissionsResult) obj);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                                }
                                z25 = z22;
                                z26 = z23;
                                Z17PermissionRequesterKt.Z17PermissionChecker(null, aVar3, permissionsRequesterState, (Function1) objRememberedValue5, ComposableLambdaKt.rememberComposableLambda(930493182, true, new Function3() { // from class: cu.todus.android.uiCompose.shared.camera.j
                                    @Override // kotlin.jvm.functions.Function3
                                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                                        return CameraKt.Camera$lambda$2$6(mutableState2, onClose, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                    }
                                }, composerStartRestartGroup, 54), composerStartRestartGroup, 27696, 1);
                                PermissionsRequesterState permissionsRequesterState2 = (PermissionsRequesterState) mutableState2.getValue();
                                String packageName = context.getPackageName();
                                kotlin.jvm.internal.y.h(packageName, "getPackageName(...)");
                                objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue6 == companion.getEmpty()) {
                                    objRememberedValue6 = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.k
                                        @Override // lb.a
                                        public final Object invoke() {
                                            return CameraKt.Camera$lambda$2$7$0(mutableState2);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                                }
                                lb.a aVar4 = (lb.a) objRememberedValue6;
                                objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue7 == companion.getEmpty()) {
                                    objRememberedValue7 = new Function1() { // from class: cu.todus.android.uiCompose.shared.camera.m
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            return CameraKt.Camera$lambda$2$8$0(mutableState2, (PermissionsResult) obj);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                                }
                                Z17PermissionRequesterKt.Z17PermissionRequester(permissionsRequesterState2, aVar4, (Function1) objRememberedValue7, packageName, composerStartRestartGroup, 432);
                                state = ((PermissionsRequesterState) mutableState2.getValue()).getPermissionsResult().getState();
                                if (state == null && state.intValue() == 2) {
                                    composerStartRestartGroup.startReplaceGroup(-226627738);
                                    Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                                    boolean zCamera$lambda$2$1 = Camera$lambda$2$1(mutableState);
                                    objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue8 == companion.getEmpty()) {
                                        objRememberedValue8 = new Function1() { // from class: cu.todus.android.uiCompose.shared.camera.n
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Object invoke(Object obj) {
                                                return CameraKt.Camera$lambda$2$9$0(mutableState, ((Boolean) obj).booleanValue());
                                            }
                                        };
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                                    }
                                    Function1 function1 = (Function1) objRememberedValue8;
                                    int i33 = i13 << 3;
                                    int i34 = (i13 & 112) | 6 | (i13 & 896) | (i13 & 7168) | (57344 & i13) | (458752 & i13) | (3670016 & i13) | (234881024 & i33) | (i33 & C.ENCODING_PCM_DOUBLE);
                                    int i35 = i25 << 3;
                                    int i36 = ((i13 >> 27) & 14) | 3072 | (i35 & 112) | (i35 & 896);
                                    z27 = z15;
                                    j13 = j12;
                                    z28 = z24;
                                    z29 = z25;
                                    cameraParams6 = cameraParams5;
                                    z30 = z26;
                                    CameraPager(modifierFillMaxSize$default, cameraParams6, z28, z27, z29, z30, j13, zCamera$lambda$2$1, sendVideos, sendImages, aVar2, onClose, onError, function1, composerStartRestartGroup, i34, i36, 0);
                                    composerStartRestartGroup.endReplaceGroup();
                                } else {
                                    z27 = z15;
                                    j13 = j12;
                                    cameraParams6 = cameraParams5;
                                    z28 = z24;
                                    z29 = z25;
                                    z30 = z26;
                                    composerStartRestartGroup.startReplaceGroup(-225953116);
                                    composerStartRestartGroup.endReplaceGroup();
                                }
                                ua.k0 k0Var = ua.k0.f43947a;
                                zChanged = composerStartRestartGroup.changed(softwareKeyboardController);
                                objRememberedValue9 = composerStartRestartGroup.rememberedValue();
                                if (zChanged || objRememberedValue9 == companion.getEmpty()) {
                                    objRememberedValue9 = new CameraKt$Camera$3$7$1(softwareKeyboardController, null);
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
                                }
                                EffectsKt.LaunchedEffect(k0Var, (Function2) objRememberedValue9, composerStartRestartGroup, 6);
                                composerStartRestartGroup.endNode();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                j11 = j13;
                                z20 = z30;
                                z16 = z29;
                                z19 = z27;
                                z18 = z28;
                                cameraParams3 = cameraParams6;
                                modifier3 = modifier4;
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                j11 = j10;
                                cameraParams3 = cameraParams2;
                                modifier3 = modifier2;
                                z18 = z14;
                                z19 = z15;
                                z20 = z13;
                                aVar2 = aVar;
                            }
                            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup != null) {
                                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.shared.camera.o
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return CameraKt.Camera$lambda$3(modifier3, cameraParams3, z18, z19, z16, z20, j11, sendVideos, sendImages, aVar2, onClose, onError, i10, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                });
                            }
                        }
                        i13 |= 805306368;
                        if ((i11 & 6) == 0) {
                            if (composerStartRestartGroup.changedInstance(onClose)) {
                                i27 = 4;
                            } else {
                                i27 = 2;
                            }
                            i24 = i11 | i27;
                        } else {
                            i24 = i11;
                        }
                        if ((i11 & 48) == 0) {
                            if (composerStartRestartGroup.changedInstance(onError)) {
                                i26 = 32;
                            } else {
                                i26 = 16;
                            }
                            i24 |= i26;
                        }
                        i25 = i24;
                        if ((i13 & 306783379) == 306783378) {
                            z17 = true;
                        } else {
                            z17 = true;
                        }
                        if (composerStartRestartGroup.shouldExecute(z17, i13 & 1)) {
                            if (i30 != 0) {
                                modifier4 = Modifier.INSTANCE;
                            } else {
                                modifier4 = modifier2;
                            }
                            if (i31 != 0) {
                                cameraParams4 = new CameraParams(null, null, 0L, 7, null);
                            } else {
                                cameraParams4 = cameraParams2;
                            }
                            if (i32 != 0) {
                                z21 = true;
                            } else {
                                z21 = z14;
                            }
                            if (i14 != 0) {
                                z15 = true;
                            }
                            if (i16 != 0) {
                                z22 = false;
                            } else {
                                z22 = z16;
                            }
                            if (i18 != 0) {
                                z23 = false;
                            } else {
                                z23 = z13;
                            }
                            if (i20 != 0) {
                                j12 = Long.MAX_VALUE;
                            } else {
                                j12 = j10;
                            }
                            if (i22 != 0) {
                                objRememberedValue10 = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue10 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue10 = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.f
                                        @Override // lb.a
                                        public final Object invoke() {
                                            return ua.k0.f43947a;
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue10);
                                }
                                aVar2 = (lb.a) objRememberedValue10;
                            } else {
                                aVar2 = aVar;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1559415396, i13, i25, "cu.todus.android.uiCompose.shared.camera.Camera (Camera.kt:107)");
                            }
                            Modifier modifierImePadding2 = WindowInsetsPadding_androidKt.imePadding(modifier4);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            companion = Composer.INSTANCE;
                            if (objRememberedValue == companion.getEmpty()) {
                                objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.g
                                    @Override // lb.a
                                    public final Object invoke() {
                                        return ua.k0.f43947a;
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            Modifier modifierM1205backgroundbw27NRU$default2 = BackgroundKt.m1205backgroundbw27NRU$default(ClickableKt.m1240clickableoSLSa3U$default(modifierImePadding2, false, null, null, null, (lb.a) objRememberedValue, 14, null), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground(), null, 2, null);
                            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                            int iA2 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1205backgroundbw27NRU$default2);
                            ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
                            cameraParams5 = cameraParams4;
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
                            Composer composerM5176constructorimpl2 = Updater.m5176constructorimpl(composerStartRestartGroup);
                            z24 = z21;
                            Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy2, companion3.getSetMeasurePolicy());
                            Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
                            Updater.m5180initimpl(composerM5176constructorimpl2, Integer.valueOf(iA2), companion3.getSetCompositeKeyHash());
                            Updater.m5182reconcileimpl(composerM5176constructorimpl2, companion3.getApplyOnDeactivatedNodeAssertion());
                            Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier2, companion3.getSetModifier());
                            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue2 == companion.getEmpty()) {
                                objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            mutableState = (MutableState) objRememberedValue2;
                            softwareKeyboardController = (SoftwareKeyboardController) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalSoftwareKeyboardController());
                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue3 == companion.getEmpty()) {
                                objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new PermissionsRequesterState(null, false, va.w.q(PermissionNeedIt.STORAGE, PermissionNeedIt.CAMERA, PermissionNeedIt.RECORD_AUDIO), 1, null), null, 2, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            }
                            mutableState2 = (MutableState) objRememberedValue3;
                            Context context2 = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                            PermissionsRequesterState permissionsRequesterState3 = (PermissionsRequesterState) mutableState2.getValue();
                            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue4 == companion.getEmpty()) {
                                objRememberedValue4 = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.h
                                    @Override // lb.a
                                    public final Object invoke() {
                                        return CameraKt.Camera$lambda$2$4$0(mutableState2);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                            }
                            lb.a aVar5 = (lb.a) objRememberedValue4;
                            objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue5 == companion.getEmpty()) {
                                objRememberedValue5 = new Function1() { // from class: cu.todus.android.uiCompose.shared.camera.i
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return CameraKt.Camera$lambda$2$5$0(mutableState2, (PermissionsResult) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                            }
                            z25 = z22;
                            z26 = z23;
                            Z17PermissionRequesterKt.Z17PermissionChecker(null, aVar5, permissionsRequesterState3, (Function1) objRememberedValue5, ComposableLambdaKt.rememberComposableLambda(930493182, true, new Function3() { // from class: cu.todus.android.uiCompose.shared.camera.j
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return CameraKt.Camera$lambda$2$6(mutableState2, onClose, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, composerStartRestartGroup, 54), composerStartRestartGroup, 27696, 1);
                            PermissionsRequesterState permissionsRequesterState4 = (PermissionsRequesterState) mutableState2.getValue();
                            String packageName2 = context2.getPackageName();
                            kotlin.jvm.internal.y.h(packageName2, "getPackageName(...)");
                            objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue6 == companion.getEmpty()) {
                                objRememberedValue6 = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.k
                                    @Override // lb.a
                                    public final Object invoke() {
                                        return CameraKt.Camera$lambda$2$7$0(mutableState2);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                            }
                            lb.a aVar6 = (lb.a) objRememberedValue6;
                            objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue7 == companion.getEmpty()) {
                                objRememberedValue7 = new Function1() { // from class: cu.todus.android.uiCompose.shared.camera.m
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return CameraKt.Camera$lambda$2$8$0(mutableState2, (PermissionsResult) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                            }
                            Z17PermissionRequesterKt.Z17PermissionRequester(permissionsRequesterState4, aVar6, (Function1) objRememberedValue7, packageName2, composerStartRestartGroup, 432);
                            state = ((PermissionsRequesterState) mutableState2.getValue()).getPermissionsResult().getState();
                            if (state == null) {
                                z27 = z15;
                                j13 = j12;
                                cameraParams6 = cameraParams5;
                                z28 = z24;
                                z29 = z25;
                                z30 = z26;
                                composerStartRestartGroup.startReplaceGroup(-225953116);
                                composerStartRestartGroup.endReplaceGroup();
                            } else {
                                composerStartRestartGroup.startReplaceGroup(-226627738);
                                Modifier modifierFillMaxSize$default2 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                                boolean zCamera$lambda$2$2 = Camera$lambda$2$1(mutableState);
                                objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue8 == companion.getEmpty()) {
                                    objRememberedValue8 = new Function1() { // from class: cu.todus.android.uiCompose.shared.camera.n
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            return CameraKt.Camera$lambda$2$9$0(mutableState, ((Boolean) obj).booleanValue());
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                                }
                                Function1 function2 = (Function1) objRememberedValue8;
                                int i37 = i13 << 3;
                                int i38 = (i13 & 112) | 6 | (i13 & 896) | (i13 & 7168) | (57344 & i13) | (458752 & i13) | (3670016 & i13) | (234881024 & i37) | (i37 & C.ENCODING_PCM_DOUBLE);
                                int i39 = i25 << 3;
                                int i310 = ((i13 >> 27) & 14) | 3072 | (i39 & 112) | (i39 & 896);
                                z27 = z15;
                                j13 = j12;
                                z28 = z24;
                                z29 = z25;
                                cameraParams6 = cameraParams5;
                                z30 = z26;
                                CameraPager(modifierFillMaxSize$default2, cameraParams6, z28, z27, z29, z30, j13, zCamera$lambda$2$2, sendVideos, sendImages, aVar2, onClose, onError, function2, composerStartRestartGroup, i38, i310, 0);
                                composerStartRestartGroup.endReplaceGroup();
                            }
                            ua.k0 k0Var2 = ua.k0.f43947a;
                            zChanged = composerStartRestartGroup.changed(softwareKeyboardController);
                            objRememberedValue9 = composerStartRestartGroup.rememberedValue();
                            if (zChanged) {
                                objRememberedValue9 = new CameraKt$Camera$3$7$1(softwareKeyboardController, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
                            } else {
                                objRememberedValue9 = new CameraKt$Camera$3$7$1(softwareKeyboardController, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
                            }
                            EffectsKt.LaunchedEffect(k0Var2, (Function2) objRememberedValue9, composerStartRestartGroup, 6);
                            composerStartRestartGroup.endNode();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            j11 = j13;
                            z20 = z30;
                            z16 = z29;
                            z19 = z27;
                            z18 = z28;
                            cameraParams3 = cameraParams6;
                            modifier3 = modifier4;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            j11 = j10;
                            cameraParams3 = cameraParams2;
                            modifier3 = modifier2;
                            z18 = z14;
                            z19 = z15;
                            z20 = z13;
                            aVar2 = aVar;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.shared.camera.o
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return CameraKt.Camera$lambda$3(modifier3, cameraParams3, z18, z19, z16, z20, j11, sendVideos, sendImages, aVar2, onClose, onError, i10, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                        }
                    }
                    i13 |= 1572864;
                    if ((i10 & 12582912) == 0) {
                        if (composerStartRestartGroup.changedInstance(sendVideos)) {
                            i29 = 8388608;
                        } else {
                            i29 = 4194304;
                        }
                        i13 |= i29;
                    }
                    if ((i10 & 100663296) == 0) {
                        if (composerStartRestartGroup.changedInstance(sendImages)) {
                            i28 = 67108864;
                        } else {
                            i28 = 33554432;
                        }
                        i13 |= i28;
                    }
                    i22 = i12 & 512;
                    if (i22 != 0) {
                        if ((i10 & 805306368) == 0) {
                            if (composerStartRestartGroup.changedInstance(aVar)) {
                                i23 = C.BUFFER_FLAG_LAST_SAMPLE;
                            } else {
                                i23 = 268435456;
                            }
                            i13 |= i23;
                        }
                        if ((i11 & 6) == 0) {
                            if (composerStartRestartGroup.changedInstance(onClose)) {
                                i27 = 4;
                            } else {
                                i27 = 2;
                            }
                            i24 = i11 | i27;
                        } else {
                            i24 = i11;
                        }
                        if ((i11 & 48) == 0) {
                            if (composerStartRestartGroup.changedInstance(onError)) {
                                i26 = 32;
                            } else {
                                i26 = 16;
                            }
                            i24 |= i26;
                        }
                        i25 = i24;
                        if ((i13 & 306783379) == 306783378) {
                            z17 = true;
                        } else {
                            z17 = true;
                        }
                        if (composerStartRestartGroup.shouldExecute(z17, i13 & 1)) {
                            if (i30 != 0) {
                                modifier4 = Modifier.INSTANCE;
                            } else {
                                modifier4 = modifier2;
                            }
                            if (i31 != 0) {
                                cameraParams4 = new CameraParams(null, null, 0L, 7, null);
                            } else {
                                cameraParams4 = cameraParams2;
                            }
                            if (i32 != 0) {
                                z21 = true;
                            } else {
                                z21 = z14;
                            }
                            if (i14 != 0) {
                                z15 = true;
                            }
                            if (i16 != 0) {
                                z22 = false;
                            } else {
                                z22 = z16;
                            }
                            if (i18 != 0) {
                                z23 = false;
                            } else {
                                z23 = z13;
                            }
                            if (i20 != 0) {
                                j12 = Long.MAX_VALUE;
                            } else {
                                j12 = j10;
                            }
                            if (i22 != 0) {
                                objRememberedValue10 = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue10 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue10 = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.f
                                        @Override // lb.a
                                        public final Object invoke() {
                                            return ua.k0.f43947a;
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue10);
                                }
                                aVar2 = (lb.a) objRememberedValue10;
                            } else {
                                aVar2 = aVar;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1559415396, i13, i25, "cu.todus.android.uiCompose.shared.camera.Camera (Camera.kt:107)");
                            }
                            Modifier modifierImePadding3 = WindowInsetsPadding_androidKt.imePadding(modifier4);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            companion = Composer.INSTANCE;
                            if (objRememberedValue == companion.getEmpty()) {
                                objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.g
                                    @Override // lb.a
                                    public final Object invoke() {
                                        return ua.k0.f43947a;
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            Modifier modifierM1205backgroundbw27NRU$default3 = BackgroundKt.m1205backgroundbw27NRU$default(ClickableKt.m1240clickableoSLSa3U$default(modifierImePadding3, false, null, null, null, (lb.a) objRememberedValue, 14, null), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground(), null, 2, null);
                            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                            int iA3 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                            CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1205backgroundbw27NRU$default3);
                            ComposeUiNode.Companion companion4 = ComposeUiNode.INSTANCE;
                            cameraParams5 = cameraParams4;
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
                            Composer composerM5176constructorimpl3 = Updater.m5176constructorimpl(composerStartRestartGroup);
                            z24 = z21;
                            Updater.m5184setimpl(composerM5176constructorimpl3, measurePolicyMaybeCachedBoxMeasurePolicy3, companion4.getSetMeasurePolicy());
                            Updater.m5184setimpl(composerM5176constructorimpl3, currentCompositionLocalMap3, companion4.getSetResolvedCompositionLocals());
                            Updater.m5180initimpl(composerM5176constructorimpl3, Integer.valueOf(iA3), companion4.getSetCompositeKeyHash());
                            Updater.m5182reconcileimpl(composerM5176constructorimpl3, companion4.getApplyOnDeactivatedNodeAssertion());
                            Updater.m5184setimpl(composerM5176constructorimpl3, modifierMaterializeModifier3, companion4.getSetModifier());
                            BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue2 == companion.getEmpty()) {
                                objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            mutableState = (MutableState) objRememberedValue2;
                            softwareKeyboardController = (SoftwareKeyboardController) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalSoftwareKeyboardController());
                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue3 == companion.getEmpty()) {
                                objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new PermissionsRequesterState(null, false, va.w.q(PermissionNeedIt.STORAGE, PermissionNeedIt.CAMERA, PermissionNeedIt.RECORD_AUDIO), 1, null), null, 2, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            }
                            mutableState2 = (MutableState) objRememberedValue3;
                            Context context3 = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                            PermissionsRequesterState permissionsRequesterState5 = (PermissionsRequesterState) mutableState2.getValue();
                            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue4 == companion.getEmpty()) {
                                objRememberedValue4 = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.h
                                    @Override // lb.a
                                    public final Object invoke() {
                                        return CameraKt.Camera$lambda$2$4$0(mutableState2);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                            }
                            lb.a aVar7 = (lb.a) objRememberedValue4;
                            objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue5 == companion.getEmpty()) {
                                objRememberedValue5 = new Function1() { // from class: cu.todus.android.uiCompose.shared.camera.i
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return CameraKt.Camera$lambda$2$5$0(mutableState2, (PermissionsResult) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                            }
                            z25 = z22;
                            z26 = z23;
                            Z17PermissionRequesterKt.Z17PermissionChecker(null, aVar7, permissionsRequesterState5, (Function1) objRememberedValue5, ComposableLambdaKt.rememberComposableLambda(930493182, true, new Function3() { // from class: cu.todus.android.uiCompose.shared.camera.j
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return CameraKt.Camera$lambda$2$6(mutableState2, onClose, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, composerStartRestartGroup, 54), composerStartRestartGroup, 27696, 1);
                            PermissionsRequesterState permissionsRequesterState6 = (PermissionsRequesterState) mutableState2.getValue();
                            String packageName3 = context3.getPackageName();
                            kotlin.jvm.internal.y.h(packageName3, "getPackageName(...)");
                            objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue6 == companion.getEmpty()) {
                                objRememberedValue6 = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.k
                                    @Override // lb.a
                                    public final Object invoke() {
                                        return CameraKt.Camera$lambda$2$7$0(mutableState2);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                            }
                            lb.a aVar8 = (lb.a) objRememberedValue6;
                            objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue7 == companion.getEmpty()) {
                                objRememberedValue7 = new Function1() { // from class: cu.todus.android.uiCompose.shared.camera.m
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return CameraKt.Camera$lambda$2$8$0(mutableState2, (PermissionsResult) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                            }
                            Z17PermissionRequesterKt.Z17PermissionRequester(permissionsRequesterState6, aVar8, (Function1) objRememberedValue7, packageName3, composerStartRestartGroup, 432);
                            state = ((PermissionsRequesterState) mutableState2.getValue()).getPermissionsResult().getState();
                            if (state == null) {
                                z27 = z15;
                                j13 = j12;
                                cameraParams6 = cameraParams5;
                                z28 = z24;
                                z29 = z25;
                                z30 = z26;
                                composerStartRestartGroup.startReplaceGroup(-225953116);
                                composerStartRestartGroup.endReplaceGroup();
                            } else {
                                composerStartRestartGroup.startReplaceGroup(-226627738);
                                Modifier modifierFillMaxSize$default3 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                                boolean zCamera$lambda$2$3 = Camera$lambda$2$1(mutableState);
                                objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue8 == companion.getEmpty()) {
                                    objRememberedValue8 = new Function1() { // from class: cu.todus.android.uiCompose.shared.camera.n
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            return CameraKt.Camera$lambda$2$9$0(mutableState, ((Boolean) obj).booleanValue());
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                                }
                                Function1 function3 = (Function1) objRememberedValue8;
                                int i311 = i13 << 3;
                                int i312 = (i13 & 112) | 6 | (i13 & 896) | (i13 & 7168) | (57344 & i13) | (458752 & i13) | (3670016 & i13) | (234881024 & i311) | (i311 & C.ENCODING_PCM_DOUBLE);
                                int i313 = i25 << 3;
                                int i314 = ((i13 >> 27) & 14) | 3072 | (i313 & 112) | (i313 & 896);
                                z27 = z15;
                                j13 = j12;
                                z28 = z24;
                                z29 = z25;
                                cameraParams6 = cameraParams5;
                                z30 = z26;
                                CameraPager(modifierFillMaxSize$default3, cameraParams6, z28, z27, z29, z30, j13, zCamera$lambda$2$3, sendVideos, sendImages, aVar2, onClose, onError, function3, composerStartRestartGroup, i312, i314, 0);
                                composerStartRestartGroup.endReplaceGroup();
                            }
                            ua.k0 k0Var3 = ua.k0.f43947a;
                            zChanged = composerStartRestartGroup.changed(softwareKeyboardController);
                            objRememberedValue9 = composerStartRestartGroup.rememberedValue();
                            if (zChanged) {
                                objRememberedValue9 = new CameraKt$Camera$3$7$1(softwareKeyboardController, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
                            } else {
                                objRememberedValue9 = new CameraKt$Camera$3$7$1(softwareKeyboardController, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
                            }
                            EffectsKt.LaunchedEffect(k0Var3, (Function2) objRememberedValue9, composerStartRestartGroup, 6);
                            composerStartRestartGroup.endNode();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            j11 = j13;
                            z20 = z30;
                            z16 = z29;
                            z19 = z27;
                            z18 = z28;
                            cameraParams3 = cameraParams6;
                            modifier3 = modifier4;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            j11 = j10;
                            cameraParams3 = cameraParams2;
                            modifier3 = modifier2;
                            z18 = z14;
                            z19 = z15;
                            z20 = z13;
                            aVar2 = aVar;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.shared.camera.o
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return CameraKt.Camera$lambda$3(modifier3, cameraParams3, z18, z19, z16, z20, j11, sendVideos, sendImages, aVar2, onClose, onError, i10, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                        }
                    }
                    i13 |= 805306368;
                    if ((i11 & 6) == 0) {
                        if (composerStartRestartGroup.changedInstance(onClose)) {
                            i27 = 4;
                        } else {
                            i27 = 2;
                        }
                        i24 = i11 | i27;
                    } else {
                        i24 = i11;
                    }
                    if ((i11 & 48) == 0) {
                        if (composerStartRestartGroup.changedInstance(onError)) {
                            i26 = 32;
                        } else {
                            i26 = 16;
                        }
                        i24 |= i26;
                    }
                    i25 = i24;
                    if ((i13 & 306783379) == 306783378) {
                        z17 = true;
                    } else {
                        z17 = true;
                    }
                    if (composerStartRestartGroup.shouldExecute(z17, i13 & 1)) {
                        if (i30 != 0) {
                            modifier4 = Modifier.INSTANCE;
                        } else {
                            modifier4 = modifier2;
                        }
                        if (i31 != 0) {
                            cameraParams4 = new CameraParams(null, null, 0L, 7, null);
                        } else {
                            cameraParams4 = cameraParams2;
                        }
                        if (i32 != 0) {
                            z21 = true;
                        } else {
                            z21 = z14;
                        }
                        if (i14 != 0) {
                            z15 = true;
                        }
                        if (i16 != 0) {
                            z22 = false;
                        } else {
                            z22 = z16;
                        }
                        if (i18 != 0) {
                            z23 = false;
                        } else {
                            z23 = z13;
                        }
                        if (i20 != 0) {
                            j12 = Long.MAX_VALUE;
                        } else {
                            j12 = j10;
                        }
                        if (i22 != 0) {
                            objRememberedValue10 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue10 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue10 = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.f
                                    @Override // lb.a
                                    public final Object invoke() {
                                        return ua.k0.f43947a;
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue10);
                            }
                            aVar2 = (lb.a) objRememberedValue10;
                        } else {
                            aVar2 = aVar;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1559415396, i13, i25, "cu.todus.android.uiCompose.shared.camera.Camera (Camera.kt:107)");
                        }
                        Modifier modifierImePadding4 = WindowInsetsPadding_androidKt.imePadding(modifier4);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        companion = Composer.INSTANCE;
                        if (objRememberedValue == companion.getEmpty()) {
                            objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.g
                                @Override // lb.a
                                public final Object invoke() {
                                    return ua.k0.f43947a;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        Modifier modifierM1205backgroundbw27NRU$default4 = BackgroundKt.m1205backgroundbw27NRU$default(ClickableKt.m1240clickableoSLSa3U$default(modifierImePadding4, false, null, null, null, (lb.a) objRememberedValue, 14, null), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground(), null, 2, null);
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy4 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                        int iA4 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1205backgroundbw27NRU$default4);
                        ComposeUiNode.Companion companion5 = ComposeUiNode.INSTANCE;
                        cameraParams5 = cameraParams4;
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
                        Composer composerM5176constructorimpl4 = Updater.m5176constructorimpl(composerStartRestartGroup);
                        z24 = z21;
                        Updater.m5184setimpl(composerM5176constructorimpl4, measurePolicyMaybeCachedBoxMeasurePolicy4, companion5.getSetMeasurePolicy());
                        Updater.m5184setimpl(composerM5176constructorimpl4, currentCompositionLocalMap4, companion5.getSetResolvedCompositionLocals());
                        Updater.m5180initimpl(composerM5176constructorimpl4, Integer.valueOf(iA4), companion5.getSetCompositeKeyHash());
                        Updater.m5182reconcileimpl(composerM5176constructorimpl4, companion5.getApplyOnDeactivatedNodeAssertion());
                        Updater.m5184setimpl(composerM5176constructorimpl4, modifierMaterializeModifier4, companion5.getSetModifier());
                        BoxScopeInstance boxScopeInstance4 = BoxScopeInstance.INSTANCE;
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == companion.getEmpty()) {
                            objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        mutableState = (MutableState) objRememberedValue2;
                        softwareKeyboardController = (SoftwareKeyboardController) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalSoftwareKeyboardController());
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue3 == companion.getEmpty()) {
                            objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new PermissionsRequesterState(null, false, va.w.q(PermissionNeedIt.STORAGE, PermissionNeedIt.CAMERA, PermissionNeedIt.RECORD_AUDIO), 1, null), null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        mutableState2 = (MutableState) objRememberedValue3;
                        Context context4 = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                        PermissionsRequesterState permissionsRequesterState7 = (PermissionsRequesterState) mutableState2.getValue();
                        objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue4 == companion.getEmpty()) {
                            objRememberedValue4 = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.h
                                @Override // lb.a
                                public final Object invoke() {
                                    return CameraKt.Camera$lambda$2$4$0(mutableState2);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        }
                        lb.a aVar9 = (lb.a) objRememberedValue4;
                        objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue5 == companion.getEmpty()) {
                            objRememberedValue5 = new Function1() { // from class: cu.todus.android.uiCompose.shared.camera.i
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return CameraKt.Camera$lambda$2$5$0(mutableState2, (PermissionsResult) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                        }
                        z25 = z22;
                        z26 = z23;
                        Z17PermissionRequesterKt.Z17PermissionChecker(null, aVar9, permissionsRequesterState7, (Function1) objRememberedValue5, ComposableLambdaKt.rememberComposableLambda(930493182, true, new Function3() { // from class: cu.todus.android.uiCompose.shared.camera.j
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return CameraKt.Camera$lambda$2$6(mutableState2, onClose, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, 27696, 1);
                        PermissionsRequesterState permissionsRequesterState8 = (PermissionsRequesterState) mutableState2.getValue();
                        String packageName4 = context4.getPackageName();
                        kotlin.jvm.internal.y.h(packageName4, "getPackageName(...)");
                        objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue6 == companion.getEmpty()) {
                            objRememberedValue6 = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.k
                                @Override // lb.a
                                public final Object invoke() {
                                    return CameraKt.Camera$lambda$2$7$0(mutableState2);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                        }
                        lb.a aVar10 = (lb.a) objRememberedValue6;
                        objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue7 == companion.getEmpty()) {
                            objRememberedValue7 = new Function1() { // from class: cu.todus.android.uiCompose.shared.camera.m
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return CameraKt.Camera$lambda$2$8$0(mutableState2, (PermissionsResult) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                        }
                        Z17PermissionRequesterKt.Z17PermissionRequester(permissionsRequesterState8, aVar10, (Function1) objRememberedValue7, packageName4, composerStartRestartGroup, 432);
                        state = ((PermissionsRequesterState) mutableState2.getValue()).getPermissionsResult().getState();
                        if (state == null) {
                            z27 = z15;
                            j13 = j12;
                            cameraParams6 = cameraParams5;
                            z28 = z24;
                            z29 = z25;
                            z30 = z26;
                            composerStartRestartGroup.startReplaceGroup(-225953116);
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(-226627738);
                            Modifier modifierFillMaxSize$default4 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                            boolean zCamera$lambda$2$4 = Camera$lambda$2$1(mutableState);
                            objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue8 == companion.getEmpty()) {
                                objRememberedValue8 = new Function1() { // from class: cu.todus.android.uiCompose.shared.camera.n
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return CameraKt.Camera$lambda$2$9$0(mutableState, ((Boolean) obj).booleanValue());
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                            }
                            Function1 function4 = (Function1) objRememberedValue8;
                            int i315 = i13 << 3;
                            int i316 = (i13 & 112) | 6 | (i13 & 896) | (i13 & 7168) | (57344 & i13) | (458752 & i13) | (3670016 & i13) | (234881024 & i315) | (i315 & C.ENCODING_PCM_DOUBLE);
                            int i317 = i25 << 3;
                            int i318 = ((i13 >> 27) & 14) | 3072 | (i317 & 112) | (i317 & 896);
                            z27 = z15;
                            j13 = j12;
                            z28 = z24;
                            z29 = z25;
                            cameraParams6 = cameraParams5;
                            z30 = z26;
                            CameraPager(modifierFillMaxSize$default4, cameraParams6, z28, z27, z29, z30, j13, zCamera$lambda$2$4, sendVideos, sendImages, aVar2, onClose, onError, function4, composerStartRestartGroup, i316, i318, 0);
                            composerStartRestartGroup.endReplaceGroup();
                        }
                        ua.k0 k0Var4 = ua.k0.f43947a;
                        zChanged = composerStartRestartGroup.changed(softwareKeyboardController);
                        objRememberedValue9 = composerStartRestartGroup.rememberedValue();
                        if (zChanged) {
                            objRememberedValue9 = new CameraKt$Camera$3$7$1(softwareKeyboardController, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
                        } else {
                            objRememberedValue9 = new CameraKt$Camera$3$7$1(softwareKeyboardController, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
                        }
                        EffectsKt.LaunchedEffect(k0Var4, (Function2) objRememberedValue9, composerStartRestartGroup, 6);
                        composerStartRestartGroup.endNode();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        j11 = j13;
                        z20 = z30;
                        z16 = z29;
                        z19 = z27;
                        z18 = z28;
                        cameraParams3 = cameraParams6;
                        modifier3 = modifier4;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        j11 = j10;
                        cameraParams3 = cameraParams2;
                        modifier3 = modifier2;
                        z18 = z14;
                        z19 = z15;
                        z20 = z13;
                        aVar2 = aVar;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.shared.camera.o
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return CameraKt.Camera$lambda$3(modifier3, cameraParams3, z18, z19, z16, z20, j11, sendVideos, sendImages, aVar2, onClose, onError, i10, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i13 |= 24576;
                z16 = z12;
                i18 = i12 & 32;
                if (i18 != 0) {
                    i13 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((i10 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changed(z13)) {
                        i19 = 131072;
                    } else {
                        i19 = 65536;
                    }
                    i13 |= i19;
                }
                i20 = i12 & 64;
                if (i20 != 0) {
                    if ((i10 & 1572864) == 0) {
                        if (composerStartRestartGroup.changed(j10)) {
                            i21 = 1048576;
                        } else {
                            i21 = 524288;
                        }
                        i13 |= i21;
                    }
                    if ((i10 & 12582912) == 0) {
                        if (composerStartRestartGroup.changedInstance(sendVideos)) {
                            i29 = 8388608;
                        } else {
                            i29 = 4194304;
                        }
                        i13 |= i29;
                    }
                    if ((i10 & 100663296) == 0) {
                        if (composerStartRestartGroup.changedInstance(sendImages)) {
                            i28 = 67108864;
                        } else {
                            i28 = 33554432;
                        }
                        i13 |= i28;
                    }
                    i22 = i12 & 512;
                    if (i22 != 0) {
                        if ((i10 & 805306368) == 0) {
                            if (composerStartRestartGroup.changedInstance(aVar)) {
                                i23 = C.BUFFER_FLAG_LAST_SAMPLE;
                            } else {
                                i23 = 268435456;
                            }
                            i13 |= i23;
                        }
                        if ((i11 & 6) == 0) {
                            if (composerStartRestartGroup.changedInstance(onClose)) {
                                i27 = 4;
                            } else {
                                i27 = 2;
                            }
                            i24 = i11 | i27;
                        } else {
                            i24 = i11;
                        }
                        if ((i11 & 48) == 0) {
                            if (composerStartRestartGroup.changedInstance(onError)) {
                                i26 = 32;
                            } else {
                                i26 = 16;
                            }
                            i24 |= i26;
                        }
                        i25 = i24;
                        if ((i13 & 306783379) == 306783378) {
                            z17 = true;
                        } else {
                            z17 = true;
                        }
                        if (composerStartRestartGroup.shouldExecute(z17, i13 & 1)) {
                            if (i30 != 0) {
                                modifier4 = Modifier.INSTANCE;
                            } else {
                                modifier4 = modifier2;
                            }
                            if (i31 != 0) {
                                cameraParams4 = new CameraParams(null, null, 0L, 7, null);
                            } else {
                                cameraParams4 = cameraParams2;
                            }
                            if (i32 != 0) {
                                z21 = true;
                            } else {
                                z21 = z14;
                            }
                            if (i14 != 0) {
                                z15 = true;
                            }
                            if (i16 != 0) {
                                z22 = false;
                            } else {
                                z22 = z16;
                            }
                            if (i18 != 0) {
                                z23 = false;
                            } else {
                                z23 = z13;
                            }
                            if (i20 != 0) {
                                j12 = Long.MAX_VALUE;
                            } else {
                                j12 = j10;
                            }
                            if (i22 != 0) {
                                objRememberedValue10 = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue10 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue10 = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.f
                                        @Override // lb.a
                                        public final Object invoke() {
                                            return ua.k0.f43947a;
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue10);
                                }
                                aVar2 = (lb.a) objRememberedValue10;
                            } else {
                                aVar2 = aVar;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1559415396, i13, i25, "cu.todus.android.uiCompose.shared.camera.Camera (Camera.kt:107)");
                            }
                            Modifier modifierImePadding5 = WindowInsetsPadding_androidKt.imePadding(modifier4);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            companion = Composer.INSTANCE;
                            if (objRememberedValue == companion.getEmpty()) {
                                objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.g
                                    @Override // lb.a
                                    public final Object invoke() {
                                        return ua.k0.f43947a;
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            Modifier modifierM1205backgroundbw27NRU$default5 = BackgroundKt.m1205backgroundbw27NRU$default(ClickableKt.m1240clickableoSLSa3U$default(modifierImePadding5, false, null, null, null, (lb.a) objRememberedValue, 14, null), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground(), null, 2, null);
                            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy5 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                            int iA5 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                            CompositionLocalMap currentCompositionLocalMap5 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                            Modifier modifierMaterializeModifier5 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1205backgroundbw27NRU$default5);
                            ComposeUiNode.Companion companion6 = ComposeUiNode.INSTANCE;
                            cameraParams5 = cameraParams4;
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
                            Composer composerM5176constructorimpl5 = Updater.m5176constructorimpl(composerStartRestartGroup);
                            z24 = z21;
                            Updater.m5184setimpl(composerM5176constructorimpl5, measurePolicyMaybeCachedBoxMeasurePolicy5, companion6.getSetMeasurePolicy());
                            Updater.m5184setimpl(composerM5176constructorimpl5, currentCompositionLocalMap5, companion6.getSetResolvedCompositionLocals());
                            Updater.m5180initimpl(composerM5176constructorimpl5, Integer.valueOf(iA5), companion6.getSetCompositeKeyHash());
                            Updater.m5182reconcileimpl(composerM5176constructorimpl5, companion6.getApplyOnDeactivatedNodeAssertion());
                            Updater.m5184setimpl(composerM5176constructorimpl5, modifierMaterializeModifier5, companion6.getSetModifier());
                            BoxScopeInstance boxScopeInstance5 = BoxScopeInstance.INSTANCE;
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue2 == companion.getEmpty()) {
                                objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            mutableState = (MutableState) objRememberedValue2;
                            softwareKeyboardController = (SoftwareKeyboardController) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalSoftwareKeyboardController());
                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue3 == companion.getEmpty()) {
                                objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new PermissionsRequesterState(null, false, va.w.q(PermissionNeedIt.STORAGE, PermissionNeedIt.CAMERA, PermissionNeedIt.RECORD_AUDIO), 1, null), null, 2, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            }
                            mutableState2 = (MutableState) objRememberedValue3;
                            Context context5 = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                            PermissionsRequesterState permissionsRequesterState9 = (PermissionsRequesterState) mutableState2.getValue();
                            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue4 == companion.getEmpty()) {
                                objRememberedValue4 = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.h
                                    @Override // lb.a
                                    public final Object invoke() {
                                        return CameraKt.Camera$lambda$2$4$0(mutableState2);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                            }
                            lb.a aVar11 = (lb.a) objRememberedValue4;
                            objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue5 == companion.getEmpty()) {
                                objRememberedValue5 = new Function1() { // from class: cu.todus.android.uiCompose.shared.camera.i
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return CameraKt.Camera$lambda$2$5$0(mutableState2, (PermissionsResult) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                            }
                            z25 = z22;
                            z26 = z23;
                            Z17PermissionRequesterKt.Z17PermissionChecker(null, aVar11, permissionsRequesterState9, (Function1) objRememberedValue5, ComposableLambdaKt.rememberComposableLambda(930493182, true, new Function3() { // from class: cu.todus.android.uiCompose.shared.camera.j
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return CameraKt.Camera$lambda$2$6(mutableState2, onClose, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, composerStartRestartGroup, 54), composerStartRestartGroup, 27696, 1);
                            PermissionsRequesterState permissionsRequesterState10 = (PermissionsRequesterState) mutableState2.getValue();
                            String packageName5 = context5.getPackageName();
                            kotlin.jvm.internal.y.h(packageName5, "getPackageName(...)");
                            objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue6 == companion.getEmpty()) {
                                objRememberedValue6 = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.k
                                    @Override // lb.a
                                    public final Object invoke() {
                                        return CameraKt.Camera$lambda$2$7$0(mutableState2);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                            }
                            lb.a aVar12 = (lb.a) objRememberedValue6;
                            objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue7 == companion.getEmpty()) {
                                objRememberedValue7 = new Function1() { // from class: cu.todus.android.uiCompose.shared.camera.m
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return CameraKt.Camera$lambda$2$8$0(mutableState2, (PermissionsResult) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                            }
                            Z17PermissionRequesterKt.Z17PermissionRequester(permissionsRequesterState10, aVar12, (Function1) objRememberedValue7, packageName5, composerStartRestartGroup, 432);
                            state = ((PermissionsRequesterState) mutableState2.getValue()).getPermissionsResult().getState();
                            if (state == null) {
                                z27 = z15;
                                j13 = j12;
                                cameraParams6 = cameraParams5;
                                z28 = z24;
                                z29 = z25;
                                z30 = z26;
                                composerStartRestartGroup.startReplaceGroup(-225953116);
                                composerStartRestartGroup.endReplaceGroup();
                            } else {
                                composerStartRestartGroup.startReplaceGroup(-226627738);
                                Modifier modifierFillMaxSize$default5 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                                boolean zCamera$lambda$2$5 = Camera$lambda$2$1(mutableState);
                                objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue8 == companion.getEmpty()) {
                                    objRememberedValue8 = new Function1() { // from class: cu.todus.android.uiCompose.shared.camera.n
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            return CameraKt.Camera$lambda$2$9$0(mutableState, ((Boolean) obj).booleanValue());
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                                }
                                Function1 function5 = (Function1) objRememberedValue8;
                                int i319 = i13 << 3;
                                int i3110 = (i13 & 112) | 6 | (i13 & 896) | (i13 & 7168) | (57344 & i13) | (458752 & i13) | (3670016 & i13) | (234881024 & i319) | (i319 & C.ENCODING_PCM_DOUBLE);
                                int i3111 = i25 << 3;
                                int i3112 = ((i13 >> 27) & 14) | 3072 | (i3111 & 112) | (i3111 & 896);
                                z27 = z15;
                                j13 = j12;
                                z28 = z24;
                                z29 = z25;
                                cameraParams6 = cameraParams5;
                                z30 = z26;
                                CameraPager(modifierFillMaxSize$default5, cameraParams6, z28, z27, z29, z30, j13, zCamera$lambda$2$5, sendVideos, sendImages, aVar2, onClose, onError, function5, composerStartRestartGroup, i3110, i3112, 0);
                                composerStartRestartGroup.endReplaceGroup();
                            }
                            ua.k0 k0Var5 = ua.k0.f43947a;
                            zChanged = composerStartRestartGroup.changed(softwareKeyboardController);
                            objRememberedValue9 = composerStartRestartGroup.rememberedValue();
                            if (zChanged) {
                                objRememberedValue9 = new CameraKt$Camera$3$7$1(softwareKeyboardController, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
                            } else {
                                objRememberedValue9 = new CameraKt$Camera$3$7$1(softwareKeyboardController, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
                            }
                            EffectsKt.LaunchedEffect(k0Var5, (Function2) objRememberedValue9, composerStartRestartGroup, 6);
                            composerStartRestartGroup.endNode();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            j11 = j13;
                            z20 = z30;
                            z16 = z29;
                            z19 = z27;
                            z18 = z28;
                            cameraParams3 = cameraParams6;
                            modifier3 = modifier4;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            j11 = j10;
                            cameraParams3 = cameraParams2;
                            modifier3 = modifier2;
                            z18 = z14;
                            z19 = z15;
                            z20 = z13;
                            aVar2 = aVar;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.shared.camera.o
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return CameraKt.Camera$lambda$3(modifier3, cameraParams3, z18, z19, z16, z20, j11, sendVideos, sendImages, aVar2, onClose, onError, i10, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                        }
                    }
                    i13 |= 805306368;
                    if ((i11 & 6) == 0) {
                        if (composerStartRestartGroup.changedInstance(onClose)) {
                            i27 = 4;
                        } else {
                            i27 = 2;
                        }
                        i24 = i11 | i27;
                    } else {
                        i24 = i11;
                    }
                    if ((i11 & 48) == 0) {
                        if (composerStartRestartGroup.changedInstance(onError)) {
                            i26 = 32;
                        } else {
                            i26 = 16;
                        }
                        i24 |= i26;
                    }
                    i25 = i24;
                    if ((i13 & 306783379) == 306783378) {
                        z17 = true;
                    } else {
                        z17 = true;
                    }
                    if (composerStartRestartGroup.shouldExecute(z17, i13 & 1)) {
                        if (i30 != 0) {
                            modifier4 = Modifier.INSTANCE;
                        } else {
                            modifier4 = modifier2;
                        }
                        if (i31 != 0) {
                            cameraParams4 = new CameraParams(null, null, 0L, 7, null);
                        } else {
                            cameraParams4 = cameraParams2;
                        }
                        if (i32 != 0) {
                            z21 = true;
                        } else {
                            z21 = z14;
                        }
                        if (i14 != 0) {
                            z15 = true;
                        }
                        if (i16 != 0) {
                            z22 = false;
                        } else {
                            z22 = z16;
                        }
                        if (i18 != 0) {
                            z23 = false;
                        } else {
                            z23 = z13;
                        }
                        if (i20 != 0) {
                            j12 = Long.MAX_VALUE;
                        } else {
                            j12 = j10;
                        }
                        if (i22 != 0) {
                            objRememberedValue10 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue10 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue10 = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.f
                                    @Override // lb.a
                                    public final Object invoke() {
                                        return ua.k0.f43947a;
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue10);
                            }
                            aVar2 = (lb.a) objRememberedValue10;
                        } else {
                            aVar2 = aVar;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1559415396, i13, i25, "cu.todus.android.uiCompose.shared.camera.Camera (Camera.kt:107)");
                        }
                        Modifier modifierImePadding6 = WindowInsetsPadding_androidKt.imePadding(modifier4);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        companion = Composer.INSTANCE;
                        if (objRememberedValue == companion.getEmpty()) {
                            objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.g
                                @Override // lb.a
                                public final Object invoke() {
                                    return ua.k0.f43947a;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        Modifier modifierM1205backgroundbw27NRU$default6 = BackgroundKt.m1205backgroundbw27NRU$default(ClickableKt.m1240clickableoSLSa3U$default(modifierImePadding6, false, null, null, null, (lb.a) objRememberedValue, 14, null), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground(), null, 2, null);
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy6 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                        int iA6 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap6 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier6 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1205backgroundbw27NRU$default6);
                        ComposeUiNode.Companion companion7 = ComposeUiNode.INSTANCE;
                        cameraParams5 = cameraParams4;
                        constructor = companion7.getConstructor();
                        if (!defpackage.r.a(composerStartRestartGroup.getApplier())) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(constructor);
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        Composer composerM5176constructorimpl6 = Updater.m5176constructorimpl(composerStartRestartGroup);
                        z24 = z21;
                        Updater.m5184setimpl(composerM5176constructorimpl6, measurePolicyMaybeCachedBoxMeasurePolicy6, companion7.getSetMeasurePolicy());
                        Updater.m5184setimpl(composerM5176constructorimpl6, currentCompositionLocalMap6, companion7.getSetResolvedCompositionLocals());
                        Updater.m5180initimpl(composerM5176constructorimpl6, Integer.valueOf(iA6), companion7.getSetCompositeKeyHash());
                        Updater.m5182reconcileimpl(composerM5176constructorimpl6, companion7.getApplyOnDeactivatedNodeAssertion());
                        Updater.m5184setimpl(composerM5176constructorimpl6, modifierMaterializeModifier6, companion7.getSetModifier());
                        BoxScopeInstance boxScopeInstance6 = BoxScopeInstance.INSTANCE;
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == companion.getEmpty()) {
                            objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        mutableState = (MutableState) objRememberedValue2;
                        softwareKeyboardController = (SoftwareKeyboardController) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalSoftwareKeyboardController());
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue3 == companion.getEmpty()) {
                            objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new PermissionsRequesterState(null, false, va.w.q(PermissionNeedIt.STORAGE, PermissionNeedIt.CAMERA, PermissionNeedIt.RECORD_AUDIO), 1, null), null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        mutableState2 = (MutableState) objRememberedValue3;
                        Context context6 = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                        PermissionsRequesterState permissionsRequesterState11 = (PermissionsRequesterState) mutableState2.getValue();
                        objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue4 == companion.getEmpty()) {
                            objRememberedValue4 = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.h
                                @Override // lb.a
                                public final Object invoke() {
                                    return CameraKt.Camera$lambda$2$4$0(mutableState2);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        }
                        lb.a aVar13 = (lb.a) objRememberedValue4;
                        objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue5 == companion.getEmpty()) {
                            objRememberedValue5 = new Function1() { // from class: cu.todus.android.uiCompose.shared.camera.i
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return CameraKt.Camera$lambda$2$5$0(mutableState2, (PermissionsResult) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                        }
                        z25 = z22;
                        z26 = z23;
                        Z17PermissionRequesterKt.Z17PermissionChecker(null, aVar13, permissionsRequesterState11, (Function1) objRememberedValue5, ComposableLambdaKt.rememberComposableLambda(930493182, true, new Function3() { // from class: cu.todus.android.uiCompose.shared.camera.j
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return CameraKt.Camera$lambda$2$6(mutableState2, onClose, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, 27696, 1);
                        PermissionsRequesterState permissionsRequesterState12 = (PermissionsRequesterState) mutableState2.getValue();
                        String packageName6 = context6.getPackageName();
                        kotlin.jvm.internal.y.h(packageName6, "getPackageName(...)");
                        objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue6 == companion.getEmpty()) {
                            objRememberedValue6 = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.k
                                @Override // lb.a
                                public final Object invoke() {
                                    return CameraKt.Camera$lambda$2$7$0(mutableState2);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                        }
                        lb.a aVar14 = (lb.a) objRememberedValue6;
                        objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue7 == companion.getEmpty()) {
                            objRememberedValue7 = new Function1() { // from class: cu.todus.android.uiCompose.shared.camera.m
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return CameraKt.Camera$lambda$2$8$0(mutableState2, (PermissionsResult) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                        }
                        Z17PermissionRequesterKt.Z17PermissionRequester(permissionsRequesterState12, aVar14, (Function1) objRememberedValue7, packageName6, composerStartRestartGroup, 432);
                        state = ((PermissionsRequesterState) mutableState2.getValue()).getPermissionsResult().getState();
                        if (state == null) {
                            z27 = z15;
                            j13 = j12;
                            cameraParams6 = cameraParams5;
                            z28 = z24;
                            z29 = z25;
                            z30 = z26;
                            composerStartRestartGroup.startReplaceGroup(-225953116);
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(-226627738);
                            Modifier modifierFillMaxSize$default6 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                            boolean zCamera$lambda$2$6 = Camera$lambda$2$1(mutableState);
                            objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue8 == companion.getEmpty()) {
                                objRememberedValue8 = new Function1() { // from class: cu.todus.android.uiCompose.shared.camera.n
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return CameraKt.Camera$lambda$2$9$0(mutableState, ((Boolean) obj).booleanValue());
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                            }
                            Function1 function6 = (Function1) objRememberedValue8;
                            int i3113 = i13 << 3;
                            int i3114 = (i13 & 112) | 6 | (i13 & 896) | (i13 & 7168) | (57344 & i13) | (458752 & i13) | (3670016 & i13) | (234881024 & i3113) | (i3113 & C.ENCODING_PCM_DOUBLE);
                            int i3115 = i25 << 3;
                            int i3116 = ((i13 >> 27) & 14) | 3072 | (i3115 & 112) | (i3115 & 896);
                            z27 = z15;
                            j13 = j12;
                            z28 = z24;
                            z29 = z25;
                            cameraParams6 = cameraParams5;
                            z30 = z26;
                            CameraPager(modifierFillMaxSize$default6, cameraParams6, z28, z27, z29, z30, j13, zCamera$lambda$2$6, sendVideos, sendImages, aVar2, onClose, onError, function6, composerStartRestartGroup, i3114, i3116, 0);
                            composerStartRestartGroup.endReplaceGroup();
                        }
                        ua.k0 k0Var6 = ua.k0.f43947a;
                        zChanged = composerStartRestartGroup.changed(softwareKeyboardController);
                        objRememberedValue9 = composerStartRestartGroup.rememberedValue();
                        if (zChanged) {
                            objRememberedValue9 = new CameraKt$Camera$3$7$1(softwareKeyboardController, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
                        } else {
                            objRememberedValue9 = new CameraKt$Camera$3$7$1(softwareKeyboardController, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
                        }
                        EffectsKt.LaunchedEffect(k0Var6, (Function2) objRememberedValue9, composerStartRestartGroup, 6);
                        composerStartRestartGroup.endNode();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        j11 = j13;
                        z20 = z30;
                        z16 = z29;
                        z19 = z27;
                        z18 = z28;
                        cameraParams3 = cameraParams6;
                        modifier3 = modifier4;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        j11 = j10;
                        cameraParams3 = cameraParams2;
                        modifier3 = modifier2;
                        z18 = z14;
                        z19 = z15;
                        z20 = z13;
                        aVar2 = aVar;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.shared.camera.o
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return CameraKt.Camera$lambda$3(modifier3, cameraParams3, z18, z19, z16, z20, j11, sendVideos, sendImages, aVar2, onClose, onError, i10, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i13 |= 1572864;
                if ((i10 & 12582912) == 0) {
                    if (composerStartRestartGroup.changedInstance(sendVideos)) {
                        i29 = 8388608;
                    } else {
                        i29 = 4194304;
                    }
                    i13 |= i29;
                }
                if ((i10 & 100663296) == 0) {
                    if (composerStartRestartGroup.changedInstance(sendImages)) {
                        i28 = 67108864;
                    } else {
                        i28 = 33554432;
                    }
                    i13 |= i28;
                }
                i22 = i12 & 512;
                if (i22 != 0) {
                    if ((i10 & 805306368) == 0) {
                        if (composerStartRestartGroup.changedInstance(aVar)) {
                            i23 = C.BUFFER_FLAG_LAST_SAMPLE;
                        } else {
                            i23 = 268435456;
                        }
                        i13 |= i23;
                    }
                    if ((i11 & 6) == 0) {
                        if (composerStartRestartGroup.changedInstance(onClose)) {
                            i27 = 4;
                        } else {
                            i27 = 2;
                        }
                        i24 = i11 | i27;
                    } else {
                        i24 = i11;
                    }
                    if ((i11 & 48) == 0) {
                        if (composerStartRestartGroup.changedInstance(onError)) {
                            i26 = 32;
                        } else {
                            i26 = 16;
                        }
                        i24 |= i26;
                    }
                    i25 = i24;
                    if ((i13 & 306783379) == 306783378) {
                        z17 = true;
                    } else {
                        z17 = true;
                    }
                    if (composerStartRestartGroup.shouldExecute(z17, i13 & 1)) {
                        if (i30 != 0) {
                            modifier4 = Modifier.INSTANCE;
                        } else {
                            modifier4 = modifier2;
                        }
                        if (i31 != 0) {
                            cameraParams4 = new CameraParams(null, null, 0L, 7, null);
                        } else {
                            cameraParams4 = cameraParams2;
                        }
                        if (i32 != 0) {
                            z21 = true;
                        } else {
                            z21 = z14;
                        }
                        if (i14 != 0) {
                            z15 = true;
                        }
                        if (i16 != 0) {
                            z22 = false;
                        } else {
                            z22 = z16;
                        }
                        if (i18 != 0) {
                            z23 = false;
                        } else {
                            z23 = z13;
                        }
                        if (i20 != 0) {
                            j12 = Long.MAX_VALUE;
                        } else {
                            j12 = j10;
                        }
                        if (i22 != 0) {
                            objRememberedValue10 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue10 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue10 = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.f
                                    @Override // lb.a
                                    public final Object invoke() {
                                        return ua.k0.f43947a;
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue10);
                            }
                            aVar2 = (lb.a) objRememberedValue10;
                        } else {
                            aVar2 = aVar;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1559415396, i13, i25, "cu.todus.android.uiCompose.shared.camera.Camera (Camera.kt:107)");
                        }
                        Modifier modifierImePadding7 = WindowInsetsPadding_androidKt.imePadding(modifier4);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        companion = Composer.INSTANCE;
                        if (objRememberedValue == companion.getEmpty()) {
                            objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.g
                                @Override // lb.a
                                public final Object invoke() {
                                    return ua.k0.f43947a;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        Modifier modifierM1205backgroundbw27NRU$default7 = BackgroundKt.m1205backgroundbw27NRU$default(ClickableKt.m1240clickableoSLSa3U$default(modifierImePadding7, false, null, null, null, (lb.a) objRememberedValue, 14, null), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground(), null, 2, null);
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy7 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                        int iA7 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap7 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier7 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1205backgroundbw27NRU$default7);
                        ComposeUiNode.Companion companion8 = ComposeUiNode.INSTANCE;
                        cameraParams5 = cameraParams4;
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
                        Composer composerM5176constructorimpl7 = Updater.m5176constructorimpl(composerStartRestartGroup);
                        z24 = z21;
                        Updater.m5184setimpl(composerM5176constructorimpl7, measurePolicyMaybeCachedBoxMeasurePolicy7, companion8.getSetMeasurePolicy());
                        Updater.m5184setimpl(composerM5176constructorimpl7, currentCompositionLocalMap7, companion8.getSetResolvedCompositionLocals());
                        Updater.m5180initimpl(composerM5176constructorimpl7, Integer.valueOf(iA7), companion8.getSetCompositeKeyHash());
                        Updater.m5182reconcileimpl(composerM5176constructorimpl7, companion8.getApplyOnDeactivatedNodeAssertion());
                        Updater.m5184setimpl(composerM5176constructorimpl7, modifierMaterializeModifier7, companion8.getSetModifier());
                        BoxScopeInstance boxScopeInstance7 = BoxScopeInstance.INSTANCE;
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == companion.getEmpty()) {
                            objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        mutableState = (MutableState) objRememberedValue2;
                        softwareKeyboardController = (SoftwareKeyboardController) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalSoftwareKeyboardController());
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue3 == companion.getEmpty()) {
                            objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new PermissionsRequesterState(null, false, va.w.q(PermissionNeedIt.STORAGE, PermissionNeedIt.CAMERA, PermissionNeedIt.RECORD_AUDIO), 1, null), null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        mutableState2 = (MutableState) objRememberedValue3;
                        Context context7 = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                        PermissionsRequesterState permissionsRequesterState13 = (PermissionsRequesterState) mutableState2.getValue();
                        objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue4 == companion.getEmpty()) {
                            objRememberedValue4 = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.h
                                @Override // lb.a
                                public final Object invoke() {
                                    return CameraKt.Camera$lambda$2$4$0(mutableState2);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        }
                        lb.a aVar15 = (lb.a) objRememberedValue4;
                        objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue5 == companion.getEmpty()) {
                            objRememberedValue5 = new Function1() { // from class: cu.todus.android.uiCompose.shared.camera.i
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return CameraKt.Camera$lambda$2$5$0(mutableState2, (PermissionsResult) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                        }
                        z25 = z22;
                        z26 = z23;
                        Z17PermissionRequesterKt.Z17PermissionChecker(null, aVar15, permissionsRequesterState13, (Function1) objRememberedValue5, ComposableLambdaKt.rememberComposableLambda(930493182, true, new Function3() { // from class: cu.todus.android.uiCompose.shared.camera.j
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return CameraKt.Camera$lambda$2$6(mutableState2, onClose, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, 27696, 1);
                        PermissionsRequesterState permissionsRequesterState14 = (PermissionsRequesterState) mutableState2.getValue();
                        String packageName7 = context7.getPackageName();
                        kotlin.jvm.internal.y.h(packageName7, "getPackageName(...)");
                        objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue6 == companion.getEmpty()) {
                            objRememberedValue6 = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.k
                                @Override // lb.a
                                public final Object invoke() {
                                    return CameraKt.Camera$lambda$2$7$0(mutableState2);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                        }
                        lb.a aVar16 = (lb.a) objRememberedValue6;
                        objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue7 == companion.getEmpty()) {
                            objRememberedValue7 = new Function1() { // from class: cu.todus.android.uiCompose.shared.camera.m
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return CameraKt.Camera$lambda$2$8$0(mutableState2, (PermissionsResult) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                        }
                        Z17PermissionRequesterKt.Z17PermissionRequester(permissionsRequesterState14, aVar16, (Function1) objRememberedValue7, packageName7, composerStartRestartGroup, 432);
                        state = ((PermissionsRequesterState) mutableState2.getValue()).getPermissionsResult().getState();
                        if (state == null) {
                            z27 = z15;
                            j13 = j12;
                            cameraParams6 = cameraParams5;
                            z28 = z24;
                            z29 = z25;
                            z30 = z26;
                            composerStartRestartGroup.startReplaceGroup(-225953116);
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(-226627738);
                            Modifier modifierFillMaxSize$default7 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                            boolean zCamera$lambda$2$7 = Camera$lambda$2$1(mutableState);
                            objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue8 == companion.getEmpty()) {
                                objRememberedValue8 = new Function1() { // from class: cu.todus.android.uiCompose.shared.camera.n
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return CameraKt.Camera$lambda$2$9$0(mutableState, ((Boolean) obj).booleanValue());
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                            }
                            Function1 function7 = (Function1) objRememberedValue8;
                            int i3117 = i13 << 3;
                            int i3118 = (i13 & 112) | 6 | (i13 & 896) | (i13 & 7168) | (57344 & i13) | (458752 & i13) | (3670016 & i13) | (234881024 & i3117) | (i3117 & C.ENCODING_PCM_DOUBLE);
                            int i3119 = i25 << 3;
                            int i31110 = ((i13 >> 27) & 14) | 3072 | (i3119 & 112) | (i3119 & 896);
                            z27 = z15;
                            j13 = j12;
                            z28 = z24;
                            z29 = z25;
                            cameraParams6 = cameraParams5;
                            z30 = z26;
                            CameraPager(modifierFillMaxSize$default7, cameraParams6, z28, z27, z29, z30, j13, zCamera$lambda$2$7, sendVideos, sendImages, aVar2, onClose, onError, function7, composerStartRestartGroup, i3118, i31110, 0);
                            composerStartRestartGroup.endReplaceGroup();
                        }
                        ua.k0 k0Var7 = ua.k0.f43947a;
                        zChanged = composerStartRestartGroup.changed(softwareKeyboardController);
                        objRememberedValue9 = composerStartRestartGroup.rememberedValue();
                        if (zChanged) {
                            objRememberedValue9 = new CameraKt$Camera$3$7$1(softwareKeyboardController, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
                        } else {
                            objRememberedValue9 = new CameraKt$Camera$3$7$1(softwareKeyboardController, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
                        }
                        EffectsKt.LaunchedEffect(k0Var7, (Function2) objRememberedValue9, composerStartRestartGroup, 6);
                        composerStartRestartGroup.endNode();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        j11 = j13;
                        z20 = z30;
                        z16 = z29;
                        z19 = z27;
                        z18 = z28;
                        cameraParams3 = cameraParams6;
                        modifier3 = modifier4;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        j11 = j10;
                        cameraParams3 = cameraParams2;
                        modifier3 = modifier2;
                        z18 = z14;
                        z19 = z15;
                        z20 = z13;
                        aVar2 = aVar;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.shared.camera.o
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return CameraKt.Camera$lambda$3(modifier3, cameraParams3, z18, z19, z16, z20, j11, sendVideos, sendImages, aVar2, onClose, onError, i10, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i13 |= 805306368;
                if ((i11 & 6) == 0) {
                    if (composerStartRestartGroup.changedInstance(onClose)) {
                        i27 = 4;
                    } else {
                        i27 = 2;
                    }
                    i24 = i11 | i27;
                } else {
                    i24 = i11;
                }
                if ((i11 & 48) == 0) {
                    if (composerStartRestartGroup.changedInstance(onError)) {
                        i26 = 32;
                    } else {
                        i26 = 16;
                    }
                    i24 |= i26;
                }
                i25 = i24;
                if ((i13 & 306783379) == 306783378) {
                    z17 = true;
                } else {
                    z17 = true;
                }
                if (composerStartRestartGroup.shouldExecute(z17, i13 & 1)) {
                    if (i30 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i31 != 0) {
                        cameraParams4 = new CameraParams(null, null, 0L, 7, null);
                    } else {
                        cameraParams4 = cameraParams2;
                    }
                    if (i32 != 0) {
                        z21 = true;
                    } else {
                        z21 = z14;
                    }
                    if (i14 != 0) {
                        z15 = true;
                    }
                    if (i16 != 0) {
                        z22 = false;
                    } else {
                        z22 = z16;
                    }
                    if (i18 != 0) {
                        z23 = false;
                    } else {
                        z23 = z13;
                    }
                    if (i20 != 0) {
                        j12 = Long.MAX_VALUE;
                    } else {
                        j12 = j10;
                    }
                    if (i22 != 0) {
                        objRememberedValue10 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue10 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue10 = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.f
                                @Override // lb.a
                                public final Object invoke() {
                                    return ua.k0.f43947a;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue10);
                        }
                        aVar2 = (lb.a) objRememberedValue10;
                    } else {
                        aVar2 = aVar;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1559415396, i13, i25, "cu.todus.android.uiCompose.shared.camera.Camera (Camera.kt:107)");
                    }
                    Modifier modifierImePadding8 = WindowInsetsPadding_androidKt.imePadding(modifier4);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    companion = Composer.INSTANCE;
                    if (objRememberedValue == companion.getEmpty()) {
                        objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.g
                            @Override // lb.a
                            public final Object invoke() {
                                return ua.k0.f43947a;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    Modifier modifierM1205backgroundbw27NRU$default8 = BackgroundKt.m1205backgroundbw27NRU$default(ClickableKt.m1240clickableoSLSa3U$default(modifierImePadding8, false, null, null, null, (lb.a) objRememberedValue, 14, null), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground(), null, 2, null);
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy8 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                    int iA8 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap8 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier8 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1205backgroundbw27NRU$default8);
                    ComposeUiNode.Companion companion9 = ComposeUiNode.INSTANCE;
                    cameraParams5 = cameraParams4;
                    constructor = companion9.getConstructor();
                    if (!defpackage.r.a(composerStartRestartGroup.getApplier())) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM5176constructorimpl8 = Updater.m5176constructorimpl(composerStartRestartGroup);
                    z24 = z21;
                    Updater.m5184setimpl(composerM5176constructorimpl8, measurePolicyMaybeCachedBoxMeasurePolicy8, companion9.getSetMeasurePolicy());
                    Updater.m5184setimpl(composerM5176constructorimpl8, currentCompositionLocalMap8, companion9.getSetResolvedCompositionLocals());
                    Updater.m5180initimpl(composerM5176constructorimpl8, Integer.valueOf(iA8), companion9.getSetCompositeKeyHash());
                    Updater.m5182reconcileimpl(composerM5176constructorimpl8, companion9.getApplyOnDeactivatedNodeAssertion());
                    Updater.m5184setimpl(composerM5176constructorimpl8, modifierMaterializeModifier8, companion9.getSetModifier());
                    BoxScopeInstance boxScopeInstance8 = BoxScopeInstance.INSTANCE;
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == companion.getEmpty()) {
                        objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    mutableState = (MutableState) objRememberedValue2;
                    softwareKeyboardController = (SoftwareKeyboardController) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalSoftwareKeyboardController());
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue3 == companion.getEmpty()) {
                        objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new PermissionsRequesterState(null, false, va.w.q(PermissionNeedIt.STORAGE, PermissionNeedIt.CAMERA, PermissionNeedIt.RECORD_AUDIO), 1, null), null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    mutableState2 = (MutableState) objRememberedValue3;
                    Context context8 = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                    PermissionsRequesterState permissionsRequesterState15 = (PermissionsRequesterState) mutableState2.getValue();
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue4 == companion.getEmpty()) {
                        objRememberedValue4 = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.h
                            @Override // lb.a
                            public final Object invoke() {
                                return CameraKt.Camera$lambda$2$4$0(mutableState2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    lb.a aVar17 = (lb.a) objRememberedValue4;
                    objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue5 == companion.getEmpty()) {
                        objRememberedValue5 = new Function1() { // from class: cu.todus.android.uiCompose.shared.camera.i
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return CameraKt.Camera$lambda$2$5$0(mutableState2, (PermissionsResult) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    }
                    z25 = z22;
                    z26 = z23;
                    Z17PermissionRequesterKt.Z17PermissionChecker(null, aVar17, permissionsRequesterState15, (Function1) objRememberedValue5, ComposableLambdaKt.rememberComposableLambda(930493182, true, new Function3() { // from class: cu.todus.android.uiCompose.shared.camera.j
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return CameraKt.Camera$lambda$2$6(mutableState2, onClose, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, 27696, 1);
                    PermissionsRequesterState permissionsRequesterState16 = (PermissionsRequesterState) mutableState2.getValue();
                    String packageName8 = context8.getPackageName();
                    kotlin.jvm.internal.y.h(packageName8, "getPackageName(...)");
                    objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue6 == companion.getEmpty()) {
                        objRememberedValue6 = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.k
                            @Override // lb.a
                            public final Object invoke() {
                                return CameraKt.Camera$lambda$2$7$0(mutableState2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                    }
                    lb.a aVar18 = (lb.a) objRememberedValue6;
                    objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue7 == companion.getEmpty()) {
                        objRememberedValue7 = new Function1() { // from class: cu.todus.android.uiCompose.shared.camera.m
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return CameraKt.Camera$lambda$2$8$0(mutableState2, (PermissionsResult) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                    }
                    Z17PermissionRequesterKt.Z17PermissionRequester(permissionsRequesterState16, aVar18, (Function1) objRememberedValue7, packageName8, composerStartRestartGroup, 432);
                    state = ((PermissionsRequesterState) mutableState2.getValue()).getPermissionsResult().getState();
                    if (state == null) {
                        z27 = z15;
                        j13 = j12;
                        cameraParams6 = cameraParams5;
                        z28 = z24;
                        z29 = z25;
                        z30 = z26;
                        composerStartRestartGroup.startReplaceGroup(-225953116);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-226627738);
                        Modifier modifierFillMaxSize$default8 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                        boolean zCamera$lambda$2$8 = Camera$lambda$2$1(mutableState);
                        objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue8 == companion.getEmpty()) {
                            objRememberedValue8 = new Function1() { // from class: cu.todus.android.uiCompose.shared.camera.n
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return CameraKt.Camera$lambda$2$9$0(mutableState, ((Boolean) obj).booleanValue());
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                        }
                        Function1 function8 = (Function1) objRememberedValue8;
                        int i31111 = i13 << 3;
                        int i31112 = (i13 & 112) | 6 | (i13 & 896) | (i13 & 7168) | (57344 & i13) | (458752 & i13) | (3670016 & i13) | (234881024 & i31111) | (i31111 & C.ENCODING_PCM_DOUBLE);
                        int i31113 = i25 << 3;
                        int i31114 = ((i13 >> 27) & 14) | 3072 | (i31113 & 112) | (i31113 & 896);
                        z27 = z15;
                        j13 = j12;
                        z28 = z24;
                        z29 = z25;
                        cameraParams6 = cameraParams5;
                        z30 = z26;
                        CameraPager(modifierFillMaxSize$default8, cameraParams6, z28, z27, z29, z30, j13, zCamera$lambda$2$8, sendVideos, sendImages, aVar2, onClose, onError, function8, composerStartRestartGroup, i31112, i31114, 0);
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    ua.k0 k0Var8 = ua.k0.f43947a;
                    zChanged = composerStartRestartGroup.changed(softwareKeyboardController);
                    objRememberedValue9 = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue9 = new CameraKt$Camera$3$7$1(softwareKeyboardController, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
                    } else {
                        objRememberedValue9 = new CameraKt$Camera$3$7$1(softwareKeyboardController, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
                    }
                    EffectsKt.LaunchedEffect(k0Var8, (Function2) objRememberedValue9, composerStartRestartGroup, 6);
                    composerStartRestartGroup.endNode();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    j11 = j13;
                    z20 = z30;
                    z16 = z29;
                    z19 = z27;
                    z18 = z28;
                    cameraParams3 = cameraParams6;
                    modifier3 = modifier4;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    j11 = j10;
                    cameraParams3 = cameraParams2;
                    modifier3 = modifier2;
                    z18 = z14;
                    z19 = z15;
                    z20 = z13;
                    aVar2 = aVar;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.shared.camera.o
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return CameraKt.Camera$lambda$3(modifier3, cameraParams3, z18, z19, z16, z20, j11, sendVideos, sendImages, aVar2, onClose, onError, i10, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i13 |= 3072;
            z15 = z11;
            i16 = i12 & 16;
            if (i16 != 0) {
                if ((i10 & 24576) == 0) {
                    z16 = z12;
                    if (composerStartRestartGroup.changed(z16)) {
                        i17 = 16384;
                    } else {
                        i17 = 8192;
                    }
                    i13 |= i17;
                }
                i18 = i12 & 32;
                if (i18 != 0) {
                    i13 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((i10 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changed(z13)) {
                        i19 = 131072;
                    } else {
                        i19 = 65536;
                    }
                    i13 |= i19;
                }
                i20 = i12 & 64;
                if (i20 != 0) {
                    if ((i10 & 1572864) == 0) {
                        if (composerStartRestartGroup.changed(j10)) {
                            i21 = 1048576;
                        } else {
                            i21 = 524288;
                        }
                        i13 |= i21;
                    }
                    if ((i10 & 12582912) == 0) {
                        if (composerStartRestartGroup.changedInstance(sendVideos)) {
                            i29 = 8388608;
                        } else {
                            i29 = 4194304;
                        }
                        i13 |= i29;
                    }
                    if ((i10 & 100663296) == 0) {
                        if (composerStartRestartGroup.changedInstance(sendImages)) {
                            i28 = 67108864;
                        } else {
                            i28 = 33554432;
                        }
                        i13 |= i28;
                    }
                    i22 = i12 & 512;
                    if (i22 != 0) {
                        if ((i10 & 805306368) == 0) {
                            if (composerStartRestartGroup.changedInstance(aVar)) {
                                i23 = C.BUFFER_FLAG_LAST_SAMPLE;
                            } else {
                                i23 = 268435456;
                            }
                            i13 |= i23;
                        }
                        if ((i11 & 6) == 0) {
                            if (composerStartRestartGroup.changedInstance(onClose)) {
                                i27 = 4;
                            } else {
                                i27 = 2;
                            }
                            i24 = i11 | i27;
                        } else {
                            i24 = i11;
                        }
                        if ((i11 & 48) == 0) {
                            if (composerStartRestartGroup.changedInstance(onError)) {
                                i26 = 32;
                            } else {
                                i26 = 16;
                            }
                            i24 |= i26;
                        }
                        i25 = i24;
                        if ((i13 & 306783379) == 306783378) {
                            z17 = true;
                        } else {
                            z17 = true;
                        }
                        if (composerStartRestartGroup.shouldExecute(z17, i13 & 1)) {
                            if (i30 != 0) {
                                modifier4 = Modifier.INSTANCE;
                            } else {
                                modifier4 = modifier2;
                            }
                            if (i31 != 0) {
                                cameraParams4 = new CameraParams(null, null, 0L, 7, null);
                            } else {
                                cameraParams4 = cameraParams2;
                            }
                            if (i32 != 0) {
                                z21 = true;
                            } else {
                                z21 = z14;
                            }
                            if (i14 != 0) {
                                z15 = true;
                            }
                            if (i16 != 0) {
                                z22 = false;
                            } else {
                                z22 = z16;
                            }
                            if (i18 != 0) {
                                z23 = false;
                            } else {
                                z23 = z13;
                            }
                            if (i20 != 0) {
                                j12 = Long.MAX_VALUE;
                            } else {
                                j12 = j10;
                            }
                            if (i22 != 0) {
                                objRememberedValue10 = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue10 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue10 = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.f
                                        @Override // lb.a
                                        public final Object invoke() {
                                            return ua.k0.f43947a;
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue10);
                                }
                                aVar2 = (lb.a) objRememberedValue10;
                            } else {
                                aVar2 = aVar;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1559415396, i13, i25, "cu.todus.android.uiCompose.shared.camera.Camera (Camera.kt:107)");
                            }
                            Modifier modifierImePadding9 = WindowInsetsPadding_androidKt.imePadding(modifier4);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            companion = Composer.INSTANCE;
                            if (objRememberedValue == companion.getEmpty()) {
                                objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.g
                                    @Override // lb.a
                                    public final Object invoke() {
                                        return ua.k0.f43947a;
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            Modifier modifierM1205backgroundbw27NRU$default9 = BackgroundKt.m1205backgroundbw27NRU$default(ClickableKt.m1240clickableoSLSa3U$default(modifierImePadding9, false, null, null, null, (lb.a) objRememberedValue, 14, null), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground(), null, 2, null);
                            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy9 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                            int iA9 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                            CompositionLocalMap currentCompositionLocalMap9 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                            Modifier modifierMaterializeModifier9 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1205backgroundbw27NRU$default9);
                            ComposeUiNode.Companion companion10 = ComposeUiNode.INSTANCE;
                            cameraParams5 = cameraParams4;
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
                            Composer composerM5176constructorimpl9 = Updater.m5176constructorimpl(composerStartRestartGroup);
                            z24 = z21;
                            Updater.m5184setimpl(composerM5176constructorimpl9, measurePolicyMaybeCachedBoxMeasurePolicy9, companion10.getSetMeasurePolicy());
                            Updater.m5184setimpl(composerM5176constructorimpl9, currentCompositionLocalMap9, companion10.getSetResolvedCompositionLocals());
                            Updater.m5180initimpl(composerM5176constructorimpl9, Integer.valueOf(iA9), companion10.getSetCompositeKeyHash());
                            Updater.m5182reconcileimpl(composerM5176constructorimpl9, companion10.getApplyOnDeactivatedNodeAssertion());
                            Updater.m5184setimpl(composerM5176constructorimpl9, modifierMaterializeModifier9, companion10.getSetModifier());
                            BoxScopeInstance boxScopeInstance9 = BoxScopeInstance.INSTANCE;
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue2 == companion.getEmpty()) {
                                objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            mutableState = (MutableState) objRememberedValue2;
                            softwareKeyboardController = (SoftwareKeyboardController) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalSoftwareKeyboardController());
                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue3 == companion.getEmpty()) {
                                objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new PermissionsRequesterState(null, false, va.w.q(PermissionNeedIt.STORAGE, PermissionNeedIt.CAMERA, PermissionNeedIt.RECORD_AUDIO), 1, null), null, 2, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            }
                            mutableState2 = (MutableState) objRememberedValue3;
                            Context context9 = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                            PermissionsRequesterState permissionsRequesterState17 = (PermissionsRequesterState) mutableState2.getValue();
                            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue4 == companion.getEmpty()) {
                                objRememberedValue4 = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.h
                                    @Override // lb.a
                                    public final Object invoke() {
                                        return CameraKt.Camera$lambda$2$4$0(mutableState2);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                            }
                            lb.a aVar19 = (lb.a) objRememberedValue4;
                            objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue5 == companion.getEmpty()) {
                                objRememberedValue5 = new Function1() { // from class: cu.todus.android.uiCompose.shared.camera.i
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return CameraKt.Camera$lambda$2$5$0(mutableState2, (PermissionsResult) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                            }
                            z25 = z22;
                            z26 = z23;
                            Z17PermissionRequesterKt.Z17PermissionChecker(null, aVar19, permissionsRequesterState17, (Function1) objRememberedValue5, ComposableLambdaKt.rememberComposableLambda(930493182, true, new Function3() { // from class: cu.todus.android.uiCompose.shared.camera.j
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return CameraKt.Camera$lambda$2$6(mutableState2, onClose, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, composerStartRestartGroup, 54), composerStartRestartGroup, 27696, 1);
                            PermissionsRequesterState permissionsRequesterState18 = (PermissionsRequesterState) mutableState2.getValue();
                            String packageName9 = context9.getPackageName();
                            kotlin.jvm.internal.y.h(packageName9, "getPackageName(...)");
                            objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue6 == companion.getEmpty()) {
                                objRememberedValue6 = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.k
                                    @Override // lb.a
                                    public final Object invoke() {
                                        return CameraKt.Camera$lambda$2$7$0(mutableState2);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                            }
                            lb.a aVar110 = (lb.a) objRememberedValue6;
                            objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue7 == companion.getEmpty()) {
                                objRememberedValue7 = new Function1() { // from class: cu.todus.android.uiCompose.shared.camera.m
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return CameraKt.Camera$lambda$2$8$0(mutableState2, (PermissionsResult) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                            }
                            Z17PermissionRequesterKt.Z17PermissionRequester(permissionsRequesterState18, aVar110, (Function1) objRememberedValue7, packageName9, composerStartRestartGroup, 432);
                            state = ((PermissionsRequesterState) mutableState2.getValue()).getPermissionsResult().getState();
                            if (state == null) {
                                z27 = z15;
                                j13 = j12;
                                cameraParams6 = cameraParams5;
                                z28 = z24;
                                z29 = z25;
                                z30 = z26;
                                composerStartRestartGroup.startReplaceGroup(-225953116);
                                composerStartRestartGroup.endReplaceGroup();
                            } else {
                                composerStartRestartGroup.startReplaceGroup(-226627738);
                                Modifier modifierFillMaxSize$default9 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                                boolean zCamera$lambda$2$9 = Camera$lambda$2$1(mutableState);
                                objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue8 == companion.getEmpty()) {
                                    objRememberedValue8 = new Function1() { // from class: cu.todus.android.uiCompose.shared.camera.n
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            return CameraKt.Camera$lambda$2$9$0(mutableState, ((Boolean) obj).booleanValue());
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                                }
                                Function1 function9 = (Function1) objRememberedValue8;
                                int i31115 = i13 << 3;
                                int i31116 = (i13 & 112) | 6 | (i13 & 896) | (i13 & 7168) | (57344 & i13) | (458752 & i13) | (3670016 & i13) | (234881024 & i31115) | (i31115 & C.ENCODING_PCM_DOUBLE);
                                int i31117 = i25 << 3;
                                int i31118 = ((i13 >> 27) & 14) | 3072 | (i31117 & 112) | (i31117 & 896);
                                z27 = z15;
                                j13 = j12;
                                z28 = z24;
                                z29 = z25;
                                cameraParams6 = cameraParams5;
                                z30 = z26;
                                CameraPager(modifierFillMaxSize$default9, cameraParams6, z28, z27, z29, z30, j13, zCamera$lambda$2$9, sendVideos, sendImages, aVar2, onClose, onError, function9, composerStartRestartGroup, i31116, i31118, 0);
                                composerStartRestartGroup.endReplaceGroup();
                            }
                            ua.k0 k0Var9 = ua.k0.f43947a;
                            zChanged = composerStartRestartGroup.changed(softwareKeyboardController);
                            objRememberedValue9 = composerStartRestartGroup.rememberedValue();
                            if (zChanged) {
                                objRememberedValue9 = new CameraKt$Camera$3$7$1(softwareKeyboardController, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
                            } else {
                                objRememberedValue9 = new CameraKt$Camera$3$7$1(softwareKeyboardController, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
                            }
                            EffectsKt.LaunchedEffect(k0Var9, (Function2) objRememberedValue9, composerStartRestartGroup, 6);
                            composerStartRestartGroup.endNode();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            j11 = j13;
                            z20 = z30;
                            z16 = z29;
                            z19 = z27;
                            z18 = z28;
                            cameraParams3 = cameraParams6;
                            modifier3 = modifier4;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            j11 = j10;
                            cameraParams3 = cameraParams2;
                            modifier3 = modifier2;
                            z18 = z14;
                            z19 = z15;
                            z20 = z13;
                            aVar2 = aVar;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.shared.camera.o
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return CameraKt.Camera$lambda$3(modifier3, cameraParams3, z18, z19, z16, z20, j11, sendVideos, sendImages, aVar2, onClose, onError, i10, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                        }
                    }
                    i13 |= 805306368;
                    if ((i11 & 6) == 0) {
                        if (composerStartRestartGroup.changedInstance(onClose)) {
                            i27 = 4;
                        } else {
                            i27 = 2;
                        }
                        i24 = i11 | i27;
                    } else {
                        i24 = i11;
                    }
                    if ((i11 & 48) == 0) {
                        if (composerStartRestartGroup.changedInstance(onError)) {
                            i26 = 32;
                        } else {
                            i26 = 16;
                        }
                        i24 |= i26;
                    }
                    i25 = i24;
                    if ((i13 & 306783379) == 306783378) {
                        z17 = true;
                    } else {
                        z17 = true;
                    }
                    if (composerStartRestartGroup.shouldExecute(z17, i13 & 1)) {
                        if (i30 != 0) {
                            modifier4 = Modifier.INSTANCE;
                        } else {
                            modifier4 = modifier2;
                        }
                        if (i31 != 0) {
                            cameraParams4 = new CameraParams(null, null, 0L, 7, null);
                        } else {
                            cameraParams4 = cameraParams2;
                        }
                        if (i32 != 0) {
                            z21 = true;
                        } else {
                            z21 = z14;
                        }
                        if (i14 != 0) {
                            z15 = true;
                        }
                        if (i16 != 0) {
                            z22 = false;
                        } else {
                            z22 = z16;
                        }
                        if (i18 != 0) {
                            z23 = false;
                        } else {
                            z23 = z13;
                        }
                        if (i20 != 0) {
                            j12 = Long.MAX_VALUE;
                        } else {
                            j12 = j10;
                        }
                        if (i22 != 0) {
                            objRememberedValue10 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue10 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue10 = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.f
                                    @Override // lb.a
                                    public final Object invoke() {
                                        return ua.k0.f43947a;
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue10);
                            }
                            aVar2 = (lb.a) objRememberedValue10;
                        } else {
                            aVar2 = aVar;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1559415396, i13, i25, "cu.todus.android.uiCompose.shared.camera.Camera (Camera.kt:107)");
                        }
                        Modifier modifierImePadding10 = WindowInsetsPadding_androidKt.imePadding(modifier4);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        companion = Composer.INSTANCE;
                        if (objRememberedValue == companion.getEmpty()) {
                            objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.g
                                @Override // lb.a
                                public final Object invoke() {
                                    return ua.k0.f43947a;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        Modifier modifierM1205backgroundbw27NRU$default10 = BackgroundKt.m1205backgroundbw27NRU$default(ClickableKt.m1240clickableoSLSa3U$default(modifierImePadding10, false, null, null, null, (lb.a) objRememberedValue, 14, null), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground(), null, 2, null);
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy10 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                        int iA10 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap10 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier10 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1205backgroundbw27NRU$default10);
                        ComposeUiNode.Companion companion11 = ComposeUiNode.INSTANCE;
                        cameraParams5 = cameraParams4;
                        constructor = companion11.getConstructor();
                        if (!defpackage.r.a(composerStartRestartGroup.getApplier())) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(constructor);
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        Composer composerM5176constructorimpl10 = Updater.m5176constructorimpl(composerStartRestartGroup);
                        z24 = z21;
                        Updater.m5184setimpl(composerM5176constructorimpl10, measurePolicyMaybeCachedBoxMeasurePolicy10, companion11.getSetMeasurePolicy());
                        Updater.m5184setimpl(composerM5176constructorimpl10, currentCompositionLocalMap10, companion11.getSetResolvedCompositionLocals());
                        Updater.m5180initimpl(composerM5176constructorimpl10, Integer.valueOf(iA10), companion11.getSetCompositeKeyHash());
                        Updater.m5182reconcileimpl(composerM5176constructorimpl10, companion11.getApplyOnDeactivatedNodeAssertion());
                        Updater.m5184setimpl(composerM5176constructorimpl10, modifierMaterializeModifier10, companion11.getSetModifier());
                        BoxScopeInstance boxScopeInstance10 = BoxScopeInstance.INSTANCE;
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == companion.getEmpty()) {
                            objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        mutableState = (MutableState) objRememberedValue2;
                        softwareKeyboardController = (SoftwareKeyboardController) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalSoftwareKeyboardController());
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue3 == companion.getEmpty()) {
                            objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new PermissionsRequesterState(null, false, va.w.q(PermissionNeedIt.STORAGE, PermissionNeedIt.CAMERA, PermissionNeedIt.RECORD_AUDIO), 1, null), null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        mutableState2 = (MutableState) objRememberedValue3;
                        Context context10 = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                        PermissionsRequesterState permissionsRequesterState19 = (PermissionsRequesterState) mutableState2.getValue();
                        objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue4 == companion.getEmpty()) {
                            objRememberedValue4 = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.h
                                @Override // lb.a
                                public final Object invoke() {
                                    return CameraKt.Camera$lambda$2$4$0(mutableState2);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        }
                        lb.a aVar111 = (lb.a) objRememberedValue4;
                        objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue5 == companion.getEmpty()) {
                            objRememberedValue5 = new Function1() { // from class: cu.todus.android.uiCompose.shared.camera.i
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return CameraKt.Camera$lambda$2$5$0(mutableState2, (PermissionsResult) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                        }
                        z25 = z22;
                        z26 = z23;
                        Z17PermissionRequesterKt.Z17PermissionChecker(null, aVar111, permissionsRequesterState19, (Function1) objRememberedValue5, ComposableLambdaKt.rememberComposableLambda(930493182, true, new Function3() { // from class: cu.todus.android.uiCompose.shared.camera.j
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return CameraKt.Camera$lambda$2$6(mutableState2, onClose, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, 27696, 1);
                        PermissionsRequesterState permissionsRequesterState110 = (PermissionsRequesterState) mutableState2.getValue();
                        String packageName10 = context10.getPackageName();
                        kotlin.jvm.internal.y.h(packageName10, "getPackageName(...)");
                        objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue6 == companion.getEmpty()) {
                            objRememberedValue6 = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.k
                                @Override // lb.a
                                public final Object invoke() {
                                    return CameraKt.Camera$lambda$2$7$0(mutableState2);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                        }
                        lb.a aVar112 = (lb.a) objRememberedValue6;
                        objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue7 == companion.getEmpty()) {
                            objRememberedValue7 = new Function1() { // from class: cu.todus.android.uiCompose.shared.camera.m
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return CameraKt.Camera$lambda$2$8$0(mutableState2, (PermissionsResult) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                        }
                        Z17PermissionRequesterKt.Z17PermissionRequester(permissionsRequesterState110, aVar112, (Function1) objRememberedValue7, packageName10, composerStartRestartGroup, 432);
                        state = ((PermissionsRequesterState) mutableState2.getValue()).getPermissionsResult().getState();
                        if (state == null) {
                            z27 = z15;
                            j13 = j12;
                            cameraParams6 = cameraParams5;
                            z28 = z24;
                            z29 = z25;
                            z30 = z26;
                            composerStartRestartGroup.startReplaceGroup(-225953116);
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(-226627738);
                            Modifier modifierFillMaxSize$default10 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                            boolean zCamera$lambda$2$10 = Camera$lambda$2$1(mutableState);
                            objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue8 == companion.getEmpty()) {
                                objRememberedValue8 = new Function1() { // from class: cu.todus.android.uiCompose.shared.camera.n
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return CameraKt.Camera$lambda$2$9$0(mutableState, ((Boolean) obj).booleanValue());
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                            }
                            Function1 function10 = (Function1) objRememberedValue8;
                            int i31119 = i13 << 3;
                            int i311110 = (i13 & 112) | 6 | (i13 & 896) | (i13 & 7168) | (57344 & i13) | (458752 & i13) | (3670016 & i13) | (234881024 & i31119) | (i31119 & C.ENCODING_PCM_DOUBLE);
                            int i311111 = i25 << 3;
                            int i311112 = ((i13 >> 27) & 14) | 3072 | (i311111 & 112) | (i311111 & 896);
                            z27 = z15;
                            j13 = j12;
                            z28 = z24;
                            z29 = z25;
                            cameraParams6 = cameraParams5;
                            z30 = z26;
                            CameraPager(modifierFillMaxSize$default10, cameraParams6, z28, z27, z29, z30, j13, zCamera$lambda$2$10, sendVideos, sendImages, aVar2, onClose, onError, function10, composerStartRestartGroup, i311110, i311112, 0);
                            composerStartRestartGroup.endReplaceGroup();
                        }
                        ua.k0 k0Var10 = ua.k0.f43947a;
                        zChanged = composerStartRestartGroup.changed(softwareKeyboardController);
                        objRememberedValue9 = composerStartRestartGroup.rememberedValue();
                        if (zChanged) {
                            objRememberedValue9 = new CameraKt$Camera$3$7$1(softwareKeyboardController, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
                        } else {
                            objRememberedValue9 = new CameraKt$Camera$3$7$1(softwareKeyboardController, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
                        }
                        EffectsKt.LaunchedEffect(k0Var10, (Function2) objRememberedValue9, composerStartRestartGroup, 6);
                        composerStartRestartGroup.endNode();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        j11 = j13;
                        z20 = z30;
                        z16 = z29;
                        z19 = z27;
                        z18 = z28;
                        cameraParams3 = cameraParams6;
                        modifier3 = modifier4;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        j11 = j10;
                        cameraParams3 = cameraParams2;
                        modifier3 = modifier2;
                        z18 = z14;
                        z19 = z15;
                        z20 = z13;
                        aVar2 = aVar;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.shared.camera.o
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return CameraKt.Camera$lambda$3(modifier3, cameraParams3, z18, z19, z16, z20, j11, sendVideos, sendImages, aVar2, onClose, onError, i10, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i13 |= 1572864;
                if ((i10 & 12582912) == 0) {
                    if (composerStartRestartGroup.changedInstance(sendVideos)) {
                        i29 = 8388608;
                    } else {
                        i29 = 4194304;
                    }
                    i13 |= i29;
                }
                if ((i10 & 100663296) == 0) {
                    if (composerStartRestartGroup.changedInstance(sendImages)) {
                        i28 = 67108864;
                    } else {
                        i28 = 33554432;
                    }
                    i13 |= i28;
                }
                i22 = i12 & 512;
                if (i22 != 0) {
                    if ((i10 & 805306368) == 0) {
                        if (composerStartRestartGroup.changedInstance(aVar)) {
                            i23 = C.BUFFER_FLAG_LAST_SAMPLE;
                        } else {
                            i23 = 268435456;
                        }
                        i13 |= i23;
                    }
                    if ((i11 & 6) == 0) {
                        if (composerStartRestartGroup.changedInstance(onClose)) {
                            i27 = 4;
                        } else {
                            i27 = 2;
                        }
                        i24 = i11 | i27;
                    } else {
                        i24 = i11;
                    }
                    if ((i11 & 48) == 0) {
                        if (composerStartRestartGroup.changedInstance(onError)) {
                            i26 = 32;
                        } else {
                            i26 = 16;
                        }
                        i24 |= i26;
                    }
                    i25 = i24;
                    if ((i13 & 306783379) == 306783378) {
                        z17 = true;
                    } else {
                        z17 = true;
                    }
                    if (composerStartRestartGroup.shouldExecute(z17, i13 & 1)) {
                        if (i30 != 0) {
                            modifier4 = Modifier.INSTANCE;
                        } else {
                            modifier4 = modifier2;
                        }
                        if (i31 != 0) {
                            cameraParams4 = new CameraParams(null, null, 0L, 7, null);
                        } else {
                            cameraParams4 = cameraParams2;
                        }
                        if (i32 != 0) {
                            z21 = true;
                        } else {
                            z21 = z14;
                        }
                        if (i14 != 0) {
                            z15 = true;
                        }
                        if (i16 != 0) {
                            z22 = false;
                        } else {
                            z22 = z16;
                        }
                        if (i18 != 0) {
                            z23 = false;
                        } else {
                            z23 = z13;
                        }
                        if (i20 != 0) {
                            j12 = Long.MAX_VALUE;
                        } else {
                            j12 = j10;
                        }
                        if (i22 != 0) {
                            objRememberedValue10 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue10 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue10 = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.f
                                    @Override // lb.a
                                    public final Object invoke() {
                                        return ua.k0.f43947a;
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue10);
                            }
                            aVar2 = (lb.a) objRememberedValue10;
                        } else {
                            aVar2 = aVar;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1559415396, i13, i25, "cu.todus.android.uiCompose.shared.camera.Camera (Camera.kt:107)");
                        }
                        Modifier modifierImePadding11 = WindowInsetsPadding_androidKt.imePadding(modifier4);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        companion = Composer.INSTANCE;
                        if (objRememberedValue == companion.getEmpty()) {
                            objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.g
                                @Override // lb.a
                                public final Object invoke() {
                                    return ua.k0.f43947a;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        Modifier modifierM1205backgroundbw27NRU$default11 = BackgroundKt.m1205backgroundbw27NRU$default(ClickableKt.m1240clickableoSLSa3U$default(modifierImePadding11, false, null, null, null, (lb.a) objRememberedValue, 14, null), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground(), null, 2, null);
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy11 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                        int iA11 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap11 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier11 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1205backgroundbw27NRU$default11);
                        ComposeUiNode.Companion companion12 = ComposeUiNode.INSTANCE;
                        cameraParams5 = cameraParams4;
                        constructor = companion12.getConstructor();
                        if (!defpackage.r.a(composerStartRestartGroup.getApplier())) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(constructor);
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        Composer composerM5176constructorimpl11 = Updater.m5176constructorimpl(composerStartRestartGroup);
                        z24 = z21;
                        Updater.m5184setimpl(composerM5176constructorimpl11, measurePolicyMaybeCachedBoxMeasurePolicy11, companion12.getSetMeasurePolicy());
                        Updater.m5184setimpl(composerM5176constructorimpl11, currentCompositionLocalMap11, companion12.getSetResolvedCompositionLocals());
                        Updater.m5180initimpl(composerM5176constructorimpl11, Integer.valueOf(iA11), companion12.getSetCompositeKeyHash());
                        Updater.m5182reconcileimpl(composerM5176constructorimpl11, companion12.getApplyOnDeactivatedNodeAssertion());
                        Updater.m5184setimpl(composerM5176constructorimpl11, modifierMaterializeModifier11, companion12.getSetModifier());
                        BoxScopeInstance boxScopeInstance11 = BoxScopeInstance.INSTANCE;
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == companion.getEmpty()) {
                            objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        mutableState = (MutableState) objRememberedValue2;
                        softwareKeyboardController = (SoftwareKeyboardController) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalSoftwareKeyboardController());
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue3 == companion.getEmpty()) {
                            objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new PermissionsRequesterState(null, false, va.w.q(PermissionNeedIt.STORAGE, PermissionNeedIt.CAMERA, PermissionNeedIt.RECORD_AUDIO), 1, null), null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        mutableState2 = (MutableState) objRememberedValue3;
                        Context context11 = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                        PermissionsRequesterState permissionsRequesterState111 = (PermissionsRequesterState) mutableState2.getValue();
                        objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue4 == companion.getEmpty()) {
                            objRememberedValue4 = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.h
                                @Override // lb.a
                                public final Object invoke() {
                                    return CameraKt.Camera$lambda$2$4$0(mutableState2);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        }
                        lb.a aVar113 = (lb.a) objRememberedValue4;
                        objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue5 == companion.getEmpty()) {
                            objRememberedValue5 = new Function1() { // from class: cu.todus.android.uiCompose.shared.camera.i
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return CameraKt.Camera$lambda$2$5$0(mutableState2, (PermissionsResult) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                        }
                        z25 = z22;
                        z26 = z23;
                        Z17PermissionRequesterKt.Z17PermissionChecker(null, aVar113, permissionsRequesterState111, (Function1) objRememberedValue5, ComposableLambdaKt.rememberComposableLambda(930493182, true, new Function3() { // from class: cu.todus.android.uiCompose.shared.camera.j
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return CameraKt.Camera$lambda$2$6(mutableState2, onClose, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, 27696, 1);
                        PermissionsRequesterState permissionsRequesterState112 = (PermissionsRequesterState) mutableState2.getValue();
                        String packageName11 = context11.getPackageName();
                        kotlin.jvm.internal.y.h(packageName11, "getPackageName(...)");
                        objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue6 == companion.getEmpty()) {
                            objRememberedValue6 = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.k
                                @Override // lb.a
                                public final Object invoke() {
                                    return CameraKt.Camera$lambda$2$7$0(mutableState2);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                        }
                        lb.a aVar114 = (lb.a) objRememberedValue6;
                        objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue7 == companion.getEmpty()) {
                            objRememberedValue7 = new Function1() { // from class: cu.todus.android.uiCompose.shared.camera.m
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return CameraKt.Camera$lambda$2$8$0(mutableState2, (PermissionsResult) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                        }
                        Z17PermissionRequesterKt.Z17PermissionRequester(permissionsRequesterState112, aVar114, (Function1) objRememberedValue7, packageName11, composerStartRestartGroup, 432);
                        state = ((PermissionsRequesterState) mutableState2.getValue()).getPermissionsResult().getState();
                        if (state == null) {
                            z27 = z15;
                            j13 = j12;
                            cameraParams6 = cameraParams5;
                            z28 = z24;
                            z29 = z25;
                            z30 = z26;
                            composerStartRestartGroup.startReplaceGroup(-225953116);
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(-226627738);
                            Modifier modifierFillMaxSize$default11 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                            boolean zCamera$lambda$2$11 = Camera$lambda$2$1(mutableState);
                            objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue8 == companion.getEmpty()) {
                                objRememberedValue8 = new Function1() { // from class: cu.todus.android.uiCompose.shared.camera.n
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return CameraKt.Camera$lambda$2$9$0(mutableState, ((Boolean) obj).booleanValue());
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                            }
                            Function1 function11 = (Function1) objRememberedValue8;
                            int i311113 = i13 << 3;
                            int i311114 = (i13 & 112) | 6 | (i13 & 896) | (i13 & 7168) | (57344 & i13) | (458752 & i13) | (3670016 & i13) | (234881024 & i311113) | (i311113 & C.ENCODING_PCM_DOUBLE);
                            int i311115 = i25 << 3;
                            int i311116 = ((i13 >> 27) & 14) | 3072 | (i311115 & 112) | (i311115 & 896);
                            z27 = z15;
                            j13 = j12;
                            z28 = z24;
                            z29 = z25;
                            cameraParams6 = cameraParams5;
                            z30 = z26;
                            CameraPager(modifierFillMaxSize$default11, cameraParams6, z28, z27, z29, z30, j13, zCamera$lambda$2$11, sendVideos, sendImages, aVar2, onClose, onError, function11, composerStartRestartGroup, i311114, i311116, 0);
                            composerStartRestartGroup.endReplaceGroup();
                        }
                        ua.k0 k0Var11 = ua.k0.f43947a;
                        zChanged = composerStartRestartGroup.changed(softwareKeyboardController);
                        objRememberedValue9 = composerStartRestartGroup.rememberedValue();
                        if (zChanged) {
                            objRememberedValue9 = new CameraKt$Camera$3$7$1(softwareKeyboardController, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
                        } else {
                            objRememberedValue9 = new CameraKt$Camera$3$7$1(softwareKeyboardController, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
                        }
                        EffectsKt.LaunchedEffect(k0Var11, (Function2) objRememberedValue9, composerStartRestartGroup, 6);
                        composerStartRestartGroup.endNode();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        j11 = j13;
                        z20 = z30;
                        z16 = z29;
                        z19 = z27;
                        z18 = z28;
                        cameraParams3 = cameraParams6;
                        modifier3 = modifier4;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        j11 = j10;
                        cameraParams3 = cameraParams2;
                        modifier3 = modifier2;
                        z18 = z14;
                        z19 = z15;
                        z20 = z13;
                        aVar2 = aVar;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.shared.camera.o
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return CameraKt.Camera$lambda$3(modifier3, cameraParams3, z18, z19, z16, z20, j11, sendVideos, sendImages, aVar2, onClose, onError, i10, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i13 |= 805306368;
                if ((i11 & 6) == 0) {
                    if (composerStartRestartGroup.changedInstance(onClose)) {
                        i27 = 4;
                    } else {
                        i27 = 2;
                    }
                    i24 = i11 | i27;
                } else {
                    i24 = i11;
                }
                if ((i11 & 48) == 0) {
                    if (composerStartRestartGroup.changedInstance(onError)) {
                        i26 = 32;
                    } else {
                        i26 = 16;
                    }
                    i24 |= i26;
                }
                i25 = i24;
                if ((i13 & 306783379) == 306783378) {
                    z17 = true;
                } else {
                    z17 = true;
                }
                if (composerStartRestartGroup.shouldExecute(z17, i13 & 1)) {
                    if (i30 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i31 != 0) {
                        cameraParams4 = new CameraParams(null, null, 0L, 7, null);
                    } else {
                        cameraParams4 = cameraParams2;
                    }
                    if (i32 != 0) {
                        z21 = true;
                    } else {
                        z21 = z14;
                    }
                    if (i14 != 0) {
                        z15 = true;
                    }
                    if (i16 != 0) {
                        z22 = false;
                    } else {
                        z22 = z16;
                    }
                    if (i18 != 0) {
                        z23 = false;
                    } else {
                        z23 = z13;
                    }
                    if (i20 != 0) {
                        j12 = Long.MAX_VALUE;
                    } else {
                        j12 = j10;
                    }
                    if (i22 != 0) {
                        objRememberedValue10 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue10 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue10 = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.f
                                @Override // lb.a
                                public final Object invoke() {
                                    return ua.k0.f43947a;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue10);
                        }
                        aVar2 = (lb.a) objRememberedValue10;
                    } else {
                        aVar2 = aVar;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1559415396, i13, i25, "cu.todus.android.uiCompose.shared.camera.Camera (Camera.kt:107)");
                    }
                    Modifier modifierImePadding12 = WindowInsetsPadding_androidKt.imePadding(modifier4);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    companion = Composer.INSTANCE;
                    if (objRememberedValue == companion.getEmpty()) {
                        objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.g
                            @Override // lb.a
                            public final Object invoke() {
                                return ua.k0.f43947a;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    Modifier modifierM1205backgroundbw27NRU$default12 = BackgroundKt.m1205backgroundbw27NRU$default(ClickableKt.m1240clickableoSLSa3U$default(modifierImePadding12, false, null, null, null, (lb.a) objRememberedValue, 14, null), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground(), null, 2, null);
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy12 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                    int iA12 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap12 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier12 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1205backgroundbw27NRU$default12);
                    ComposeUiNode.Companion companion13 = ComposeUiNode.INSTANCE;
                    cameraParams5 = cameraParams4;
                    constructor = companion13.getConstructor();
                    if (!defpackage.r.a(composerStartRestartGroup.getApplier())) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM5176constructorimpl12 = Updater.m5176constructorimpl(composerStartRestartGroup);
                    z24 = z21;
                    Updater.m5184setimpl(composerM5176constructorimpl12, measurePolicyMaybeCachedBoxMeasurePolicy12, companion13.getSetMeasurePolicy());
                    Updater.m5184setimpl(composerM5176constructorimpl12, currentCompositionLocalMap12, companion13.getSetResolvedCompositionLocals());
                    Updater.m5180initimpl(composerM5176constructorimpl12, Integer.valueOf(iA12), companion13.getSetCompositeKeyHash());
                    Updater.m5182reconcileimpl(composerM5176constructorimpl12, companion13.getApplyOnDeactivatedNodeAssertion());
                    Updater.m5184setimpl(composerM5176constructorimpl12, modifierMaterializeModifier12, companion13.getSetModifier());
                    BoxScopeInstance boxScopeInstance12 = BoxScopeInstance.INSTANCE;
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == companion.getEmpty()) {
                        objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    mutableState = (MutableState) objRememberedValue2;
                    softwareKeyboardController = (SoftwareKeyboardController) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalSoftwareKeyboardController());
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue3 == companion.getEmpty()) {
                        objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new PermissionsRequesterState(null, false, va.w.q(PermissionNeedIt.STORAGE, PermissionNeedIt.CAMERA, PermissionNeedIt.RECORD_AUDIO), 1, null), null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    mutableState2 = (MutableState) objRememberedValue3;
                    Context context12 = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                    PermissionsRequesterState permissionsRequesterState113 = (PermissionsRequesterState) mutableState2.getValue();
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue4 == companion.getEmpty()) {
                        objRememberedValue4 = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.h
                            @Override // lb.a
                            public final Object invoke() {
                                return CameraKt.Camera$lambda$2$4$0(mutableState2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    lb.a aVar115 = (lb.a) objRememberedValue4;
                    objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue5 == companion.getEmpty()) {
                        objRememberedValue5 = new Function1() { // from class: cu.todus.android.uiCompose.shared.camera.i
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return CameraKt.Camera$lambda$2$5$0(mutableState2, (PermissionsResult) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    }
                    z25 = z22;
                    z26 = z23;
                    Z17PermissionRequesterKt.Z17PermissionChecker(null, aVar115, permissionsRequesterState113, (Function1) objRememberedValue5, ComposableLambdaKt.rememberComposableLambda(930493182, true, new Function3() { // from class: cu.todus.android.uiCompose.shared.camera.j
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return CameraKt.Camera$lambda$2$6(mutableState2, onClose, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, 27696, 1);
                    PermissionsRequesterState permissionsRequesterState114 = (PermissionsRequesterState) mutableState2.getValue();
                    String packageName12 = context12.getPackageName();
                    kotlin.jvm.internal.y.h(packageName12, "getPackageName(...)");
                    objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue6 == companion.getEmpty()) {
                        objRememberedValue6 = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.k
                            @Override // lb.a
                            public final Object invoke() {
                                return CameraKt.Camera$lambda$2$7$0(mutableState2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                    }
                    lb.a aVar116 = (lb.a) objRememberedValue6;
                    objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue7 == companion.getEmpty()) {
                        objRememberedValue7 = new Function1() { // from class: cu.todus.android.uiCompose.shared.camera.m
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return CameraKt.Camera$lambda$2$8$0(mutableState2, (PermissionsResult) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                    }
                    Z17PermissionRequesterKt.Z17PermissionRequester(permissionsRequesterState114, aVar116, (Function1) objRememberedValue7, packageName12, composerStartRestartGroup, 432);
                    state = ((PermissionsRequesterState) mutableState2.getValue()).getPermissionsResult().getState();
                    if (state == null) {
                        z27 = z15;
                        j13 = j12;
                        cameraParams6 = cameraParams5;
                        z28 = z24;
                        z29 = z25;
                        z30 = z26;
                        composerStartRestartGroup.startReplaceGroup(-225953116);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-226627738);
                        Modifier modifierFillMaxSize$default12 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                        boolean zCamera$lambda$2$12 = Camera$lambda$2$1(mutableState);
                        objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue8 == companion.getEmpty()) {
                            objRememberedValue8 = new Function1() { // from class: cu.todus.android.uiCompose.shared.camera.n
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return CameraKt.Camera$lambda$2$9$0(mutableState, ((Boolean) obj).booleanValue());
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                        }
                        Function1 function12 = (Function1) objRememberedValue8;
                        int i311117 = i13 << 3;
                        int i311118 = (i13 & 112) | 6 | (i13 & 896) | (i13 & 7168) | (57344 & i13) | (458752 & i13) | (3670016 & i13) | (234881024 & i311117) | (i311117 & C.ENCODING_PCM_DOUBLE);
                        int i311119 = i25 << 3;
                        int i3111110 = ((i13 >> 27) & 14) | 3072 | (i311119 & 112) | (i311119 & 896);
                        z27 = z15;
                        j13 = j12;
                        z28 = z24;
                        z29 = z25;
                        cameraParams6 = cameraParams5;
                        z30 = z26;
                        CameraPager(modifierFillMaxSize$default12, cameraParams6, z28, z27, z29, z30, j13, zCamera$lambda$2$12, sendVideos, sendImages, aVar2, onClose, onError, function12, composerStartRestartGroup, i311118, i3111110, 0);
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    ua.k0 k0Var12 = ua.k0.f43947a;
                    zChanged = composerStartRestartGroup.changed(softwareKeyboardController);
                    objRememberedValue9 = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue9 = new CameraKt$Camera$3$7$1(softwareKeyboardController, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
                    } else {
                        objRememberedValue9 = new CameraKt$Camera$3$7$1(softwareKeyboardController, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
                    }
                    EffectsKt.LaunchedEffect(k0Var12, (Function2) objRememberedValue9, composerStartRestartGroup, 6);
                    composerStartRestartGroup.endNode();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    j11 = j13;
                    z20 = z30;
                    z16 = z29;
                    z19 = z27;
                    z18 = z28;
                    cameraParams3 = cameraParams6;
                    modifier3 = modifier4;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    j11 = j10;
                    cameraParams3 = cameraParams2;
                    modifier3 = modifier2;
                    z18 = z14;
                    z19 = z15;
                    z20 = z13;
                    aVar2 = aVar;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.shared.camera.o
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return CameraKt.Camera$lambda$3(modifier3, cameraParams3, z18, z19, z16, z20, j11, sendVideos, sendImages, aVar2, onClose, onError, i10, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i13 |= 24576;
            z16 = z12;
            i18 = i12 & 32;
            if (i18 != 0) {
                i13 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            } else if ((i10 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                if (composerStartRestartGroup.changed(z13)) {
                    i19 = 131072;
                } else {
                    i19 = 65536;
                }
                i13 |= i19;
            }
            i20 = i12 & 64;
            if (i20 != 0) {
                if ((i10 & 1572864) == 0) {
                    if (composerStartRestartGroup.changed(j10)) {
                        i21 = 1048576;
                    } else {
                        i21 = 524288;
                    }
                    i13 |= i21;
                }
                if ((i10 & 12582912) == 0) {
                    if (composerStartRestartGroup.changedInstance(sendVideos)) {
                        i29 = 8388608;
                    } else {
                        i29 = 4194304;
                    }
                    i13 |= i29;
                }
                if ((i10 & 100663296) == 0) {
                    if (composerStartRestartGroup.changedInstance(sendImages)) {
                        i28 = 67108864;
                    } else {
                        i28 = 33554432;
                    }
                    i13 |= i28;
                }
                i22 = i12 & 512;
                if (i22 != 0) {
                    if ((i10 & 805306368) == 0) {
                        if (composerStartRestartGroup.changedInstance(aVar)) {
                            i23 = C.BUFFER_FLAG_LAST_SAMPLE;
                        } else {
                            i23 = 268435456;
                        }
                        i13 |= i23;
                    }
                    if ((i11 & 6) == 0) {
                        if (composerStartRestartGroup.changedInstance(onClose)) {
                            i27 = 4;
                        } else {
                            i27 = 2;
                        }
                        i24 = i11 | i27;
                    } else {
                        i24 = i11;
                    }
                    if ((i11 & 48) == 0) {
                        if (composerStartRestartGroup.changedInstance(onError)) {
                            i26 = 32;
                        } else {
                            i26 = 16;
                        }
                        i24 |= i26;
                    }
                    i25 = i24;
                    if ((i13 & 306783379) == 306783378) {
                        z17 = true;
                    } else {
                        z17 = true;
                    }
                    if (composerStartRestartGroup.shouldExecute(z17, i13 & 1)) {
                        if (i30 != 0) {
                            modifier4 = Modifier.INSTANCE;
                        } else {
                            modifier4 = modifier2;
                        }
                        if (i31 != 0) {
                            cameraParams4 = new CameraParams(null, null, 0L, 7, null);
                        } else {
                            cameraParams4 = cameraParams2;
                        }
                        if (i32 != 0) {
                            z21 = true;
                        } else {
                            z21 = z14;
                        }
                        if (i14 != 0) {
                            z15 = true;
                        }
                        if (i16 != 0) {
                            z22 = false;
                        } else {
                            z22 = z16;
                        }
                        if (i18 != 0) {
                            z23 = false;
                        } else {
                            z23 = z13;
                        }
                        if (i20 != 0) {
                            j12 = Long.MAX_VALUE;
                        } else {
                            j12 = j10;
                        }
                        if (i22 != 0) {
                            objRememberedValue10 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue10 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue10 = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.f
                                    @Override // lb.a
                                    public final Object invoke() {
                                        return ua.k0.f43947a;
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue10);
                            }
                            aVar2 = (lb.a) objRememberedValue10;
                        } else {
                            aVar2 = aVar;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1559415396, i13, i25, "cu.todus.android.uiCompose.shared.camera.Camera (Camera.kt:107)");
                        }
                        Modifier modifierImePadding13 = WindowInsetsPadding_androidKt.imePadding(modifier4);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        companion = Composer.INSTANCE;
                        if (objRememberedValue == companion.getEmpty()) {
                            objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.g
                                @Override // lb.a
                                public final Object invoke() {
                                    return ua.k0.f43947a;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        Modifier modifierM1205backgroundbw27NRU$default13 = BackgroundKt.m1205backgroundbw27NRU$default(ClickableKt.m1240clickableoSLSa3U$default(modifierImePadding13, false, null, null, null, (lb.a) objRememberedValue, 14, null), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground(), null, 2, null);
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy13 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                        int iA13 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap13 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier13 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1205backgroundbw27NRU$default13);
                        ComposeUiNode.Companion companion14 = ComposeUiNode.INSTANCE;
                        cameraParams5 = cameraParams4;
                        constructor = companion14.getConstructor();
                        if (!defpackage.r.a(composerStartRestartGroup.getApplier())) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(constructor);
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        Composer composerM5176constructorimpl13 = Updater.m5176constructorimpl(composerStartRestartGroup);
                        z24 = z21;
                        Updater.m5184setimpl(composerM5176constructorimpl13, measurePolicyMaybeCachedBoxMeasurePolicy13, companion14.getSetMeasurePolicy());
                        Updater.m5184setimpl(composerM5176constructorimpl13, currentCompositionLocalMap13, companion14.getSetResolvedCompositionLocals());
                        Updater.m5180initimpl(composerM5176constructorimpl13, Integer.valueOf(iA13), companion14.getSetCompositeKeyHash());
                        Updater.m5182reconcileimpl(composerM5176constructorimpl13, companion14.getApplyOnDeactivatedNodeAssertion());
                        Updater.m5184setimpl(composerM5176constructorimpl13, modifierMaterializeModifier13, companion14.getSetModifier());
                        BoxScopeInstance boxScopeInstance13 = BoxScopeInstance.INSTANCE;
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == companion.getEmpty()) {
                            objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        mutableState = (MutableState) objRememberedValue2;
                        softwareKeyboardController = (SoftwareKeyboardController) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalSoftwareKeyboardController());
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue3 == companion.getEmpty()) {
                            objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new PermissionsRequesterState(null, false, va.w.q(PermissionNeedIt.STORAGE, PermissionNeedIt.CAMERA, PermissionNeedIt.RECORD_AUDIO), 1, null), null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        mutableState2 = (MutableState) objRememberedValue3;
                        Context context13 = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                        PermissionsRequesterState permissionsRequesterState115 = (PermissionsRequesterState) mutableState2.getValue();
                        objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue4 == companion.getEmpty()) {
                            objRememberedValue4 = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.h
                                @Override // lb.a
                                public final Object invoke() {
                                    return CameraKt.Camera$lambda$2$4$0(mutableState2);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        }
                        lb.a aVar117 = (lb.a) objRememberedValue4;
                        objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue5 == companion.getEmpty()) {
                            objRememberedValue5 = new Function1() { // from class: cu.todus.android.uiCompose.shared.camera.i
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return CameraKt.Camera$lambda$2$5$0(mutableState2, (PermissionsResult) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                        }
                        z25 = z22;
                        z26 = z23;
                        Z17PermissionRequesterKt.Z17PermissionChecker(null, aVar117, permissionsRequesterState115, (Function1) objRememberedValue5, ComposableLambdaKt.rememberComposableLambda(930493182, true, new Function3() { // from class: cu.todus.android.uiCompose.shared.camera.j
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return CameraKt.Camera$lambda$2$6(mutableState2, onClose, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, 27696, 1);
                        PermissionsRequesterState permissionsRequesterState116 = (PermissionsRequesterState) mutableState2.getValue();
                        String packageName13 = context13.getPackageName();
                        kotlin.jvm.internal.y.h(packageName13, "getPackageName(...)");
                        objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue6 == companion.getEmpty()) {
                            objRememberedValue6 = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.k
                                @Override // lb.a
                                public final Object invoke() {
                                    return CameraKt.Camera$lambda$2$7$0(mutableState2);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                        }
                        lb.a aVar118 = (lb.a) objRememberedValue6;
                        objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue7 == companion.getEmpty()) {
                            objRememberedValue7 = new Function1() { // from class: cu.todus.android.uiCompose.shared.camera.m
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return CameraKt.Camera$lambda$2$8$0(mutableState2, (PermissionsResult) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                        }
                        Z17PermissionRequesterKt.Z17PermissionRequester(permissionsRequesterState116, aVar118, (Function1) objRememberedValue7, packageName13, composerStartRestartGroup, 432);
                        state = ((PermissionsRequesterState) mutableState2.getValue()).getPermissionsResult().getState();
                        if (state == null) {
                            z27 = z15;
                            j13 = j12;
                            cameraParams6 = cameraParams5;
                            z28 = z24;
                            z29 = z25;
                            z30 = z26;
                            composerStartRestartGroup.startReplaceGroup(-225953116);
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(-226627738);
                            Modifier modifierFillMaxSize$default13 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                            boolean zCamera$lambda$2$13 = Camera$lambda$2$1(mutableState);
                            objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue8 == companion.getEmpty()) {
                                objRememberedValue8 = new Function1() { // from class: cu.todus.android.uiCompose.shared.camera.n
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return CameraKt.Camera$lambda$2$9$0(mutableState, ((Boolean) obj).booleanValue());
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                            }
                            Function1 function13 = (Function1) objRememberedValue8;
                            int i3111111 = i13 << 3;
                            int i3111112 = (i13 & 112) | 6 | (i13 & 896) | (i13 & 7168) | (57344 & i13) | (458752 & i13) | (3670016 & i13) | (234881024 & i3111111) | (i3111111 & C.ENCODING_PCM_DOUBLE);
                            int i3111113 = i25 << 3;
                            int i3111114 = ((i13 >> 27) & 14) | 3072 | (i3111113 & 112) | (i3111113 & 896);
                            z27 = z15;
                            j13 = j12;
                            z28 = z24;
                            z29 = z25;
                            cameraParams6 = cameraParams5;
                            z30 = z26;
                            CameraPager(modifierFillMaxSize$default13, cameraParams6, z28, z27, z29, z30, j13, zCamera$lambda$2$13, sendVideos, sendImages, aVar2, onClose, onError, function13, composerStartRestartGroup, i3111112, i3111114, 0);
                            composerStartRestartGroup.endReplaceGroup();
                        }
                        ua.k0 k0Var13 = ua.k0.f43947a;
                        zChanged = composerStartRestartGroup.changed(softwareKeyboardController);
                        objRememberedValue9 = composerStartRestartGroup.rememberedValue();
                        if (zChanged) {
                            objRememberedValue9 = new CameraKt$Camera$3$7$1(softwareKeyboardController, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
                        } else {
                            objRememberedValue9 = new CameraKt$Camera$3$7$1(softwareKeyboardController, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
                        }
                        EffectsKt.LaunchedEffect(k0Var13, (Function2) objRememberedValue9, composerStartRestartGroup, 6);
                        composerStartRestartGroup.endNode();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        j11 = j13;
                        z20 = z30;
                        z16 = z29;
                        z19 = z27;
                        z18 = z28;
                        cameraParams3 = cameraParams6;
                        modifier3 = modifier4;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        j11 = j10;
                        cameraParams3 = cameraParams2;
                        modifier3 = modifier2;
                        z18 = z14;
                        z19 = z15;
                        z20 = z13;
                        aVar2 = aVar;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.shared.camera.o
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return CameraKt.Camera$lambda$3(modifier3, cameraParams3, z18, z19, z16, z20, j11, sendVideos, sendImages, aVar2, onClose, onError, i10, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i13 |= 805306368;
                if ((i11 & 6) == 0) {
                    if (composerStartRestartGroup.changedInstance(onClose)) {
                        i27 = 4;
                    } else {
                        i27 = 2;
                    }
                    i24 = i11 | i27;
                } else {
                    i24 = i11;
                }
                if ((i11 & 48) == 0) {
                    if (composerStartRestartGroup.changedInstance(onError)) {
                        i26 = 32;
                    } else {
                        i26 = 16;
                    }
                    i24 |= i26;
                }
                i25 = i24;
                if ((i13 & 306783379) == 306783378) {
                    z17 = true;
                } else {
                    z17 = true;
                }
                if (composerStartRestartGroup.shouldExecute(z17, i13 & 1)) {
                    if (i30 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i31 != 0) {
                        cameraParams4 = new CameraParams(null, null, 0L, 7, null);
                    } else {
                        cameraParams4 = cameraParams2;
                    }
                    if (i32 != 0) {
                        z21 = true;
                    } else {
                        z21 = z14;
                    }
                    if (i14 != 0) {
                        z15 = true;
                    }
                    if (i16 != 0) {
                        z22 = false;
                    } else {
                        z22 = z16;
                    }
                    if (i18 != 0) {
                        z23 = false;
                    } else {
                        z23 = z13;
                    }
                    if (i20 != 0) {
                        j12 = Long.MAX_VALUE;
                    } else {
                        j12 = j10;
                    }
                    if (i22 != 0) {
                        objRememberedValue10 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue10 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue10 = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.f
                                @Override // lb.a
                                public final Object invoke() {
                                    return ua.k0.f43947a;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue10);
                        }
                        aVar2 = (lb.a) objRememberedValue10;
                    } else {
                        aVar2 = aVar;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1559415396, i13, i25, "cu.todus.android.uiCompose.shared.camera.Camera (Camera.kt:107)");
                    }
                    Modifier modifierImePadding14 = WindowInsetsPadding_androidKt.imePadding(modifier4);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    companion = Composer.INSTANCE;
                    if (objRememberedValue == companion.getEmpty()) {
                        objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.g
                            @Override // lb.a
                            public final Object invoke() {
                                return ua.k0.f43947a;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    Modifier modifierM1205backgroundbw27NRU$default14 = BackgroundKt.m1205backgroundbw27NRU$default(ClickableKt.m1240clickableoSLSa3U$default(modifierImePadding14, false, null, null, null, (lb.a) objRememberedValue, 14, null), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground(), null, 2, null);
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy14 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                    int iA14 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap14 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier14 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1205backgroundbw27NRU$default14);
                    ComposeUiNode.Companion companion15 = ComposeUiNode.INSTANCE;
                    cameraParams5 = cameraParams4;
                    constructor = companion15.getConstructor();
                    if (!defpackage.r.a(composerStartRestartGroup.getApplier())) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM5176constructorimpl14 = Updater.m5176constructorimpl(composerStartRestartGroup);
                    z24 = z21;
                    Updater.m5184setimpl(composerM5176constructorimpl14, measurePolicyMaybeCachedBoxMeasurePolicy14, companion15.getSetMeasurePolicy());
                    Updater.m5184setimpl(composerM5176constructorimpl14, currentCompositionLocalMap14, companion15.getSetResolvedCompositionLocals());
                    Updater.m5180initimpl(composerM5176constructorimpl14, Integer.valueOf(iA14), companion15.getSetCompositeKeyHash());
                    Updater.m5182reconcileimpl(composerM5176constructorimpl14, companion15.getApplyOnDeactivatedNodeAssertion());
                    Updater.m5184setimpl(composerM5176constructorimpl14, modifierMaterializeModifier14, companion15.getSetModifier());
                    BoxScopeInstance boxScopeInstance14 = BoxScopeInstance.INSTANCE;
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == companion.getEmpty()) {
                        objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    mutableState = (MutableState) objRememberedValue2;
                    softwareKeyboardController = (SoftwareKeyboardController) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalSoftwareKeyboardController());
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue3 == companion.getEmpty()) {
                        objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new PermissionsRequesterState(null, false, va.w.q(PermissionNeedIt.STORAGE, PermissionNeedIt.CAMERA, PermissionNeedIt.RECORD_AUDIO), 1, null), null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    mutableState2 = (MutableState) objRememberedValue3;
                    Context context14 = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                    PermissionsRequesterState permissionsRequesterState117 = (PermissionsRequesterState) mutableState2.getValue();
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue4 == companion.getEmpty()) {
                        objRememberedValue4 = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.h
                            @Override // lb.a
                            public final Object invoke() {
                                return CameraKt.Camera$lambda$2$4$0(mutableState2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    lb.a aVar119 = (lb.a) objRememberedValue4;
                    objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue5 == companion.getEmpty()) {
                        objRememberedValue5 = new Function1() { // from class: cu.todus.android.uiCompose.shared.camera.i
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return CameraKt.Camera$lambda$2$5$0(mutableState2, (PermissionsResult) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    }
                    z25 = z22;
                    z26 = z23;
                    Z17PermissionRequesterKt.Z17PermissionChecker(null, aVar119, permissionsRequesterState117, (Function1) objRememberedValue5, ComposableLambdaKt.rememberComposableLambda(930493182, true, new Function3() { // from class: cu.todus.android.uiCompose.shared.camera.j
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return CameraKt.Camera$lambda$2$6(mutableState2, onClose, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, 27696, 1);
                    PermissionsRequesterState permissionsRequesterState118 = (PermissionsRequesterState) mutableState2.getValue();
                    String packageName14 = context14.getPackageName();
                    kotlin.jvm.internal.y.h(packageName14, "getPackageName(...)");
                    objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue6 == companion.getEmpty()) {
                        objRememberedValue6 = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.k
                            @Override // lb.a
                            public final Object invoke() {
                                return CameraKt.Camera$lambda$2$7$0(mutableState2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                    }
                    lb.a aVar1110 = (lb.a) objRememberedValue6;
                    objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue7 == companion.getEmpty()) {
                        objRememberedValue7 = new Function1() { // from class: cu.todus.android.uiCompose.shared.camera.m
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return CameraKt.Camera$lambda$2$8$0(mutableState2, (PermissionsResult) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                    }
                    Z17PermissionRequesterKt.Z17PermissionRequester(permissionsRequesterState118, aVar1110, (Function1) objRememberedValue7, packageName14, composerStartRestartGroup, 432);
                    state = ((PermissionsRequesterState) mutableState2.getValue()).getPermissionsResult().getState();
                    if (state == null) {
                        z27 = z15;
                        j13 = j12;
                        cameraParams6 = cameraParams5;
                        z28 = z24;
                        z29 = z25;
                        z30 = z26;
                        composerStartRestartGroup.startReplaceGroup(-225953116);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-226627738);
                        Modifier modifierFillMaxSize$default14 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                        boolean zCamera$lambda$2$14 = Camera$lambda$2$1(mutableState);
                        objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue8 == companion.getEmpty()) {
                            objRememberedValue8 = new Function1() { // from class: cu.todus.android.uiCompose.shared.camera.n
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return CameraKt.Camera$lambda$2$9$0(mutableState, ((Boolean) obj).booleanValue());
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                        }
                        Function1 function14 = (Function1) objRememberedValue8;
                        int i3111115 = i13 << 3;
                        int i3111116 = (i13 & 112) | 6 | (i13 & 896) | (i13 & 7168) | (57344 & i13) | (458752 & i13) | (3670016 & i13) | (234881024 & i3111115) | (i3111115 & C.ENCODING_PCM_DOUBLE);
                        int i3111117 = i25 << 3;
                        int i3111118 = ((i13 >> 27) & 14) | 3072 | (i3111117 & 112) | (i3111117 & 896);
                        z27 = z15;
                        j13 = j12;
                        z28 = z24;
                        z29 = z25;
                        cameraParams6 = cameraParams5;
                        z30 = z26;
                        CameraPager(modifierFillMaxSize$default14, cameraParams6, z28, z27, z29, z30, j13, zCamera$lambda$2$14, sendVideos, sendImages, aVar2, onClose, onError, function14, composerStartRestartGroup, i3111116, i3111118, 0);
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    ua.k0 k0Var14 = ua.k0.f43947a;
                    zChanged = composerStartRestartGroup.changed(softwareKeyboardController);
                    objRememberedValue9 = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue9 = new CameraKt$Camera$3$7$1(softwareKeyboardController, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
                    } else {
                        objRememberedValue9 = new CameraKt$Camera$3$7$1(softwareKeyboardController, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
                    }
                    EffectsKt.LaunchedEffect(k0Var14, (Function2) objRememberedValue9, composerStartRestartGroup, 6);
                    composerStartRestartGroup.endNode();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    j11 = j13;
                    z20 = z30;
                    z16 = z29;
                    z19 = z27;
                    z18 = z28;
                    cameraParams3 = cameraParams6;
                    modifier3 = modifier4;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    j11 = j10;
                    cameraParams3 = cameraParams2;
                    modifier3 = modifier2;
                    z18 = z14;
                    z19 = z15;
                    z20 = z13;
                    aVar2 = aVar;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.shared.camera.o
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return CameraKt.Camera$lambda$3(modifier3, cameraParams3, z18, z19, z16, z20, j11, sendVideos, sendImages, aVar2, onClose, onError, i10, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i13 |= 1572864;
            if ((i10 & 12582912) == 0) {
                if (composerStartRestartGroup.changedInstance(sendVideos)) {
                    i29 = 8388608;
                } else {
                    i29 = 4194304;
                }
                i13 |= i29;
            }
            if ((i10 & 100663296) == 0) {
                if (composerStartRestartGroup.changedInstance(sendImages)) {
                    i28 = 67108864;
                } else {
                    i28 = 33554432;
                }
                i13 |= i28;
            }
            i22 = i12 & 512;
            if (i22 != 0) {
                if ((i10 & 805306368) == 0) {
                    if (composerStartRestartGroup.changedInstance(aVar)) {
                        i23 = C.BUFFER_FLAG_LAST_SAMPLE;
                    } else {
                        i23 = 268435456;
                    }
                    i13 |= i23;
                }
                if ((i11 & 6) == 0) {
                    if (composerStartRestartGroup.changedInstance(onClose)) {
                        i27 = 4;
                    } else {
                        i27 = 2;
                    }
                    i24 = i11 | i27;
                } else {
                    i24 = i11;
                }
                if ((i11 & 48) == 0) {
                    if (composerStartRestartGroup.changedInstance(onError)) {
                        i26 = 32;
                    } else {
                        i26 = 16;
                    }
                    i24 |= i26;
                }
                i25 = i24;
                if ((i13 & 306783379) == 306783378) {
                    z17 = true;
                } else {
                    z17 = true;
                }
                if (composerStartRestartGroup.shouldExecute(z17, i13 & 1)) {
                    if (i30 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i31 != 0) {
                        cameraParams4 = new CameraParams(null, null, 0L, 7, null);
                    } else {
                        cameraParams4 = cameraParams2;
                    }
                    if (i32 != 0) {
                        z21 = true;
                    } else {
                        z21 = z14;
                    }
                    if (i14 != 0) {
                        z15 = true;
                    }
                    if (i16 != 0) {
                        z22 = false;
                    } else {
                        z22 = z16;
                    }
                    if (i18 != 0) {
                        z23 = false;
                    } else {
                        z23 = z13;
                    }
                    if (i20 != 0) {
                        j12 = Long.MAX_VALUE;
                    } else {
                        j12 = j10;
                    }
                    if (i22 != 0) {
                        objRememberedValue10 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue10 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue10 = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.f
                                @Override // lb.a
                                public final Object invoke() {
                                    return ua.k0.f43947a;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue10);
                        }
                        aVar2 = (lb.a) objRememberedValue10;
                    } else {
                        aVar2 = aVar;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1559415396, i13, i25, "cu.todus.android.uiCompose.shared.camera.Camera (Camera.kt:107)");
                    }
                    Modifier modifierImePadding15 = WindowInsetsPadding_androidKt.imePadding(modifier4);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    companion = Composer.INSTANCE;
                    if (objRememberedValue == companion.getEmpty()) {
                        objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.g
                            @Override // lb.a
                            public final Object invoke() {
                                return ua.k0.f43947a;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    Modifier modifierM1205backgroundbw27NRU$default15 = BackgroundKt.m1205backgroundbw27NRU$default(ClickableKt.m1240clickableoSLSa3U$default(modifierImePadding15, false, null, null, null, (lb.a) objRememberedValue, 14, null), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground(), null, 2, null);
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy15 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                    int iA15 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap15 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier15 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1205backgroundbw27NRU$default15);
                    ComposeUiNode.Companion companion16 = ComposeUiNode.INSTANCE;
                    cameraParams5 = cameraParams4;
                    constructor = companion16.getConstructor();
                    if (!defpackage.r.a(composerStartRestartGroup.getApplier())) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM5176constructorimpl15 = Updater.m5176constructorimpl(composerStartRestartGroup);
                    z24 = z21;
                    Updater.m5184setimpl(composerM5176constructorimpl15, measurePolicyMaybeCachedBoxMeasurePolicy15, companion16.getSetMeasurePolicy());
                    Updater.m5184setimpl(composerM5176constructorimpl15, currentCompositionLocalMap15, companion16.getSetResolvedCompositionLocals());
                    Updater.m5180initimpl(composerM5176constructorimpl15, Integer.valueOf(iA15), companion16.getSetCompositeKeyHash());
                    Updater.m5182reconcileimpl(composerM5176constructorimpl15, companion16.getApplyOnDeactivatedNodeAssertion());
                    Updater.m5184setimpl(composerM5176constructorimpl15, modifierMaterializeModifier15, companion16.getSetModifier());
                    BoxScopeInstance boxScopeInstance15 = BoxScopeInstance.INSTANCE;
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == companion.getEmpty()) {
                        objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    mutableState = (MutableState) objRememberedValue2;
                    softwareKeyboardController = (SoftwareKeyboardController) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalSoftwareKeyboardController());
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue3 == companion.getEmpty()) {
                        objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new PermissionsRequesterState(null, false, va.w.q(PermissionNeedIt.STORAGE, PermissionNeedIt.CAMERA, PermissionNeedIt.RECORD_AUDIO), 1, null), null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    mutableState2 = (MutableState) objRememberedValue3;
                    Context context15 = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                    PermissionsRequesterState permissionsRequesterState119 = (PermissionsRequesterState) mutableState2.getValue();
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue4 == companion.getEmpty()) {
                        objRememberedValue4 = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.h
                            @Override // lb.a
                            public final Object invoke() {
                                return CameraKt.Camera$lambda$2$4$0(mutableState2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    lb.a aVar1111 = (lb.a) objRememberedValue4;
                    objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue5 == companion.getEmpty()) {
                        objRememberedValue5 = new Function1() { // from class: cu.todus.android.uiCompose.shared.camera.i
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return CameraKt.Camera$lambda$2$5$0(mutableState2, (PermissionsResult) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    }
                    z25 = z22;
                    z26 = z23;
                    Z17PermissionRequesterKt.Z17PermissionChecker(null, aVar1111, permissionsRequesterState119, (Function1) objRememberedValue5, ComposableLambdaKt.rememberComposableLambda(930493182, true, new Function3() { // from class: cu.todus.android.uiCompose.shared.camera.j
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return CameraKt.Camera$lambda$2$6(mutableState2, onClose, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, 27696, 1);
                    PermissionsRequesterState permissionsRequesterState1110 = (PermissionsRequesterState) mutableState2.getValue();
                    String packageName15 = context15.getPackageName();
                    kotlin.jvm.internal.y.h(packageName15, "getPackageName(...)");
                    objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue6 == companion.getEmpty()) {
                        objRememberedValue6 = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.k
                            @Override // lb.a
                            public final Object invoke() {
                                return CameraKt.Camera$lambda$2$7$0(mutableState2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                    }
                    lb.a aVar1112 = (lb.a) objRememberedValue6;
                    objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue7 == companion.getEmpty()) {
                        objRememberedValue7 = new Function1() { // from class: cu.todus.android.uiCompose.shared.camera.m
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return CameraKt.Camera$lambda$2$8$0(mutableState2, (PermissionsResult) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                    }
                    Z17PermissionRequesterKt.Z17PermissionRequester(permissionsRequesterState1110, aVar1112, (Function1) objRememberedValue7, packageName15, composerStartRestartGroup, 432);
                    state = ((PermissionsRequesterState) mutableState2.getValue()).getPermissionsResult().getState();
                    if (state == null) {
                        z27 = z15;
                        j13 = j12;
                        cameraParams6 = cameraParams5;
                        z28 = z24;
                        z29 = z25;
                        z30 = z26;
                        composerStartRestartGroup.startReplaceGroup(-225953116);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-226627738);
                        Modifier modifierFillMaxSize$default15 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                        boolean zCamera$lambda$2$15 = Camera$lambda$2$1(mutableState);
                        objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue8 == companion.getEmpty()) {
                            objRememberedValue8 = new Function1() { // from class: cu.todus.android.uiCompose.shared.camera.n
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return CameraKt.Camera$lambda$2$9$0(mutableState, ((Boolean) obj).booleanValue());
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                        }
                        Function1 function15 = (Function1) objRememberedValue8;
                        int i3111119 = i13 << 3;
                        int i31111110 = (i13 & 112) | 6 | (i13 & 896) | (i13 & 7168) | (57344 & i13) | (458752 & i13) | (3670016 & i13) | (234881024 & i3111119) | (i3111119 & C.ENCODING_PCM_DOUBLE);
                        int i31111111 = i25 << 3;
                        int i31111112 = ((i13 >> 27) & 14) | 3072 | (i31111111 & 112) | (i31111111 & 896);
                        z27 = z15;
                        j13 = j12;
                        z28 = z24;
                        z29 = z25;
                        cameraParams6 = cameraParams5;
                        z30 = z26;
                        CameraPager(modifierFillMaxSize$default15, cameraParams6, z28, z27, z29, z30, j13, zCamera$lambda$2$15, sendVideos, sendImages, aVar2, onClose, onError, function15, composerStartRestartGroup, i31111110, i31111112, 0);
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    ua.k0 k0Var15 = ua.k0.f43947a;
                    zChanged = composerStartRestartGroup.changed(softwareKeyboardController);
                    objRememberedValue9 = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue9 = new CameraKt$Camera$3$7$1(softwareKeyboardController, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
                    } else {
                        objRememberedValue9 = new CameraKt$Camera$3$7$1(softwareKeyboardController, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
                    }
                    EffectsKt.LaunchedEffect(k0Var15, (Function2) objRememberedValue9, composerStartRestartGroup, 6);
                    composerStartRestartGroup.endNode();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    j11 = j13;
                    z20 = z30;
                    z16 = z29;
                    z19 = z27;
                    z18 = z28;
                    cameraParams3 = cameraParams6;
                    modifier3 = modifier4;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    j11 = j10;
                    cameraParams3 = cameraParams2;
                    modifier3 = modifier2;
                    z18 = z14;
                    z19 = z15;
                    z20 = z13;
                    aVar2 = aVar;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.shared.camera.o
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return CameraKt.Camera$lambda$3(modifier3, cameraParams3, z18, z19, z16, z20, j11, sendVideos, sendImages, aVar2, onClose, onError, i10, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i13 |= 805306368;
            if ((i11 & 6) == 0) {
                if (composerStartRestartGroup.changedInstance(onClose)) {
                    i27 = 4;
                } else {
                    i27 = 2;
                }
                i24 = i11 | i27;
            } else {
                i24 = i11;
            }
            if ((i11 & 48) == 0) {
                if (composerStartRestartGroup.changedInstance(onError)) {
                    i26 = 32;
                } else {
                    i26 = 16;
                }
                i24 |= i26;
            }
            i25 = i24;
            if ((i13 & 306783379) == 306783378) {
                z17 = true;
            } else {
                z17 = true;
            }
            if (composerStartRestartGroup.shouldExecute(z17, i13 & 1)) {
                if (i30 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (i31 != 0) {
                    cameraParams4 = new CameraParams(null, null, 0L, 7, null);
                } else {
                    cameraParams4 = cameraParams2;
                }
                if (i32 != 0) {
                    z21 = true;
                } else {
                    z21 = z14;
                }
                if (i14 != 0) {
                    z15 = true;
                }
                if (i16 != 0) {
                    z22 = false;
                } else {
                    z22 = z16;
                }
                if (i18 != 0) {
                    z23 = false;
                } else {
                    z23 = z13;
                }
                if (i20 != 0) {
                    j12 = Long.MAX_VALUE;
                } else {
                    j12 = j10;
                }
                if (i22 != 0) {
                    objRememberedValue10 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue10 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue10 = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.f
                            @Override // lb.a
                            public final Object invoke() {
                                return ua.k0.f43947a;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue10);
                    }
                    aVar2 = (lb.a) objRememberedValue10;
                } else {
                    aVar2 = aVar;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1559415396, i13, i25, "cu.todus.android.uiCompose.shared.camera.Camera (Camera.kt:107)");
                }
                Modifier modifierImePadding16 = WindowInsetsPadding_androidKt.imePadding(modifier4);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                companion = Composer.INSTANCE;
                if (objRememberedValue == companion.getEmpty()) {
                    objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.g
                        @Override // lb.a
                        public final Object invoke() {
                            return ua.k0.f43947a;
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                Modifier modifierM1205backgroundbw27NRU$default16 = BackgroundKt.m1205backgroundbw27NRU$default(ClickableKt.m1240clickableoSLSa3U$default(modifierImePadding16, false, null, null, null, (lb.a) objRememberedValue, 14, null), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground(), null, 2, null);
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy16 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                int iA16 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap16 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier16 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1205backgroundbw27NRU$default16);
                ComposeUiNode.Companion companion17 = ComposeUiNode.INSTANCE;
                cameraParams5 = cameraParams4;
                constructor = companion17.getConstructor();
                if (!defpackage.r.a(composerStartRestartGroup.getApplier())) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor);
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM5176constructorimpl16 = Updater.m5176constructorimpl(composerStartRestartGroup);
                z24 = z21;
                Updater.m5184setimpl(composerM5176constructorimpl16, measurePolicyMaybeCachedBoxMeasurePolicy16, companion17.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl16, currentCompositionLocalMap16, companion17.getSetResolvedCompositionLocals());
                Updater.m5180initimpl(composerM5176constructorimpl16, Integer.valueOf(iA16), companion17.getSetCompositeKeyHash());
                Updater.m5182reconcileimpl(composerM5176constructorimpl16, companion17.getApplyOnDeactivatedNodeAssertion());
                Updater.m5184setimpl(composerM5176constructorimpl16, modifierMaterializeModifier16, companion17.getSetModifier());
                BoxScopeInstance boxScopeInstance16 = BoxScopeInstance.INSTANCE;
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == companion.getEmpty()) {
                    objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                mutableState = (MutableState) objRememberedValue2;
                softwareKeyboardController = (SoftwareKeyboardController) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalSoftwareKeyboardController());
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue3 == companion.getEmpty()) {
                    objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new PermissionsRequesterState(null, false, va.w.q(PermissionNeedIt.STORAGE, PermissionNeedIt.CAMERA, PermissionNeedIt.RECORD_AUDIO), 1, null), null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                mutableState2 = (MutableState) objRememberedValue3;
                Context context16 = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                PermissionsRequesterState permissionsRequesterState1111 = (PermissionsRequesterState) mutableState2.getValue();
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue4 == companion.getEmpty()) {
                    objRememberedValue4 = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.h
                        @Override // lb.a
                        public final Object invoke() {
                            return CameraKt.Camera$lambda$2$4$0(mutableState2);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                lb.a aVar1113 = (lb.a) objRememberedValue4;
                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue5 == companion.getEmpty()) {
                    objRememberedValue5 = new Function1() { // from class: cu.todus.android.uiCompose.shared.camera.i
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return CameraKt.Camera$lambda$2$5$0(mutableState2, (PermissionsResult) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                z25 = z22;
                z26 = z23;
                Z17PermissionRequesterKt.Z17PermissionChecker(null, aVar1113, permissionsRequesterState1111, (Function1) objRememberedValue5, ComposableLambdaKt.rememberComposableLambda(930493182, true, new Function3() { // from class: cu.todus.android.uiCompose.shared.camera.j
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return CameraKt.Camera$lambda$2$6(mutableState2, onClose, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 27696, 1);
                PermissionsRequesterState permissionsRequesterState1112 = (PermissionsRequesterState) mutableState2.getValue();
                String packageName16 = context16.getPackageName();
                kotlin.jvm.internal.y.h(packageName16, "getPackageName(...)");
                objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue6 == companion.getEmpty()) {
                    objRememberedValue6 = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.k
                        @Override // lb.a
                        public final Object invoke() {
                            return CameraKt.Camera$lambda$2$7$0(mutableState2);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                }
                lb.a aVar1114 = (lb.a) objRememberedValue6;
                objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue7 == companion.getEmpty()) {
                    objRememberedValue7 = new Function1() { // from class: cu.todus.android.uiCompose.shared.camera.m
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return CameraKt.Camera$lambda$2$8$0(mutableState2, (PermissionsResult) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                }
                Z17PermissionRequesterKt.Z17PermissionRequester(permissionsRequesterState1112, aVar1114, (Function1) objRememberedValue7, packageName16, composerStartRestartGroup, 432);
                state = ((PermissionsRequesterState) mutableState2.getValue()).getPermissionsResult().getState();
                if (state == null) {
                    z27 = z15;
                    j13 = j12;
                    cameraParams6 = cameraParams5;
                    z28 = z24;
                    z29 = z25;
                    z30 = z26;
                    composerStartRestartGroup.startReplaceGroup(-225953116);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(-226627738);
                    Modifier modifierFillMaxSize$default16 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                    boolean zCamera$lambda$2$16 = Camera$lambda$2$1(mutableState);
                    objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue8 == companion.getEmpty()) {
                        objRememberedValue8 = new Function1() { // from class: cu.todus.android.uiCompose.shared.camera.n
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return CameraKt.Camera$lambda$2$9$0(mutableState, ((Boolean) obj).booleanValue());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                    }
                    Function1 function16 = (Function1) objRememberedValue8;
                    int i31111113 = i13 << 3;
                    int i31111114 = (i13 & 112) | 6 | (i13 & 896) | (i13 & 7168) | (57344 & i13) | (458752 & i13) | (3670016 & i13) | (234881024 & i31111113) | (i31111113 & C.ENCODING_PCM_DOUBLE);
                    int i31111115 = i25 << 3;
                    int i31111116 = ((i13 >> 27) & 14) | 3072 | (i31111115 & 112) | (i31111115 & 896);
                    z27 = z15;
                    j13 = j12;
                    z28 = z24;
                    z29 = z25;
                    cameraParams6 = cameraParams5;
                    z30 = z26;
                    CameraPager(modifierFillMaxSize$default16, cameraParams6, z28, z27, z29, z30, j13, zCamera$lambda$2$16, sendVideos, sendImages, aVar2, onClose, onError, function16, composerStartRestartGroup, i31111114, i31111116, 0);
                    composerStartRestartGroup.endReplaceGroup();
                }
                ua.k0 k0Var16 = ua.k0.f43947a;
                zChanged = composerStartRestartGroup.changed(softwareKeyboardController);
                objRememberedValue9 = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    objRememberedValue9 = new CameraKt$Camera$3$7$1(softwareKeyboardController, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
                } else {
                    objRememberedValue9 = new CameraKt$Camera$3$7$1(softwareKeyboardController, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
                }
                EffectsKt.LaunchedEffect(k0Var16, (Function2) objRememberedValue9, composerStartRestartGroup, 6);
                composerStartRestartGroup.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                j11 = j13;
                z20 = z30;
                z16 = z29;
                z19 = z27;
                z18 = z28;
                cameraParams3 = cameraParams6;
                modifier3 = modifier4;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                j11 = j10;
                cameraParams3 = cameraParams2;
                modifier3 = modifier2;
                z18 = z14;
                z19 = z15;
                z20 = z13;
                aVar2 = aVar;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.shared.camera.o
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return CameraKt.Camera$lambda$3(modifier3, cameraParams3, z18, z19, z16, z20, j11, sendVideos, sendImages, aVar2, onClose, onError, i10, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i13 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        z14 = z10;
        i14 = i12 & 8;
        if (i14 != 0) {
            if ((i10 & 3072) == 0) {
                z15 = z11;
                if (composerStartRestartGroup.changed(z15)) {
                    i15 = 2048;
                } else {
                    i15 = 1024;
                }
                i13 |= i15;
            }
            i16 = i12 & 16;
            if (i16 != 0) {
                if ((i10 & 24576) == 0) {
                    z16 = z12;
                    if (composerStartRestartGroup.changed(z16)) {
                        i17 = 16384;
                    } else {
                        i17 = 8192;
                    }
                    i13 |= i17;
                }
                i18 = i12 & 32;
                if (i18 != 0) {
                    i13 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((i10 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changed(z13)) {
                        i19 = 131072;
                    } else {
                        i19 = 65536;
                    }
                    i13 |= i19;
                }
                i20 = i12 & 64;
                if (i20 != 0) {
                    if ((i10 & 1572864) == 0) {
                        if (composerStartRestartGroup.changed(j10)) {
                            i21 = 1048576;
                        } else {
                            i21 = 524288;
                        }
                        i13 |= i21;
                    }
                    if ((i10 & 12582912) == 0) {
                        if (composerStartRestartGroup.changedInstance(sendVideos)) {
                            i29 = 8388608;
                        } else {
                            i29 = 4194304;
                        }
                        i13 |= i29;
                    }
                    if ((i10 & 100663296) == 0) {
                        if (composerStartRestartGroup.changedInstance(sendImages)) {
                            i28 = 67108864;
                        } else {
                            i28 = 33554432;
                        }
                        i13 |= i28;
                    }
                    i22 = i12 & 512;
                    if (i22 != 0) {
                        if ((i10 & 805306368) == 0) {
                            if (composerStartRestartGroup.changedInstance(aVar)) {
                                i23 = C.BUFFER_FLAG_LAST_SAMPLE;
                            } else {
                                i23 = 268435456;
                            }
                            i13 |= i23;
                        }
                        if ((i11 & 6) == 0) {
                            if (composerStartRestartGroup.changedInstance(onClose)) {
                                i27 = 4;
                            } else {
                                i27 = 2;
                            }
                            i24 = i11 | i27;
                        } else {
                            i24 = i11;
                        }
                        if ((i11 & 48) == 0) {
                            if (composerStartRestartGroup.changedInstance(onError)) {
                                i26 = 32;
                            } else {
                                i26 = 16;
                            }
                            i24 |= i26;
                        }
                        i25 = i24;
                        if ((i13 & 306783379) == 306783378) {
                            z17 = true;
                        } else {
                            z17 = true;
                        }
                        if (composerStartRestartGroup.shouldExecute(z17, i13 & 1)) {
                            if (i30 != 0) {
                                modifier4 = Modifier.INSTANCE;
                            } else {
                                modifier4 = modifier2;
                            }
                            if (i31 != 0) {
                                cameraParams4 = new CameraParams(null, null, 0L, 7, null);
                            } else {
                                cameraParams4 = cameraParams2;
                            }
                            if (i32 != 0) {
                                z21 = true;
                            } else {
                                z21 = z14;
                            }
                            if (i14 != 0) {
                                z15 = true;
                            }
                            if (i16 != 0) {
                                z22 = false;
                            } else {
                                z22 = z16;
                            }
                            if (i18 != 0) {
                                z23 = false;
                            } else {
                                z23 = z13;
                            }
                            if (i20 != 0) {
                                j12 = Long.MAX_VALUE;
                            } else {
                                j12 = j10;
                            }
                            if (i22 != 0) {
                                objRememberedValue10 = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue10 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue10 = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.f
                                        @Override // lb.a
                                        public final Object invoke() {
                                            return ua.k0.f43947a;
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue10);
                                }
                                aVar2 = (lb.a) objRememberedValue10;
                            } else {
                                aVar2 = aVar;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1559415396, i13, i25, "cu.todus.android.uiCompose.shared.camera.Camera (Camera.kt:107)");
                            }
                            Modifier modifierImePadding17 = WindowInsetsPadding_androidKt.imePadding(modifier4);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            companion = Composer.INSTANCE;
                            if (objRememberedValue == companion.getEmpty()) {
                                objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.g
                                    @Override // lb.a
                                    public final Object invoke() {
                                        return ua.k0.f43947a;
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            Modifier modifierM1205backgroundbw27NRU$default17 = BackgroundKt.m1205backgroundbw27NRU$default(ClickableKt.m1240clickableoSLSa3U$default(modifierImePadding17, false, null, null, null, (lb.a) objRememberedValue, 14, null), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground(), null, 2, null);
                            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy17 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                            int iA17 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                            CompositionLocalMap currentCompositionLocalMap17 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                            Modifier modifierMaterializeModifier17 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1205backgroundbw27NRU$default17);
                            ComposeUiNode.Companion companion18 = ComposeUiNode.INSTANCE;
                            cameraParams5 = cameraParams4;
                            constructor = companion18.getConstructor();
                            if (!defpackage.r.a(composerStartRestartGroup.getApplier())) {
                                ComposablesKt.invalidApplier();
                            }
                            composerStartRestartGroup.startReusableNode();
                            if (composerStartRestartGroup.getInserting()) {
                                composerStartRestartGroup.createNode(constructor);
                            } else {
                                composerStartRestartGroup.useNode();
                            }
                            Composer composerM5176constructorimpl17 = Updater.m5176constructorimpl(composerStartRestartGroup);
                            z24 = z21;
                            Updater.m5184setimpl(composerM5176constructorimpl17, measurePolicyMaybeCachedBoxMeasurePolicy17, companion18.getSetMeasurePolicy());
                            Updater.m5184setimpl(composerM5176constructorimpl17, currentCompositionLocalMap17, companion18.getSetResolvedCompositionLocals());
                            Updater.m5180initimpl(composerM5176constructorimpl17, Integer.valueOf(iA17), companion18.getSetCompositeKeyHash());
                            Updater.m5182reconcileimpl(composerM5176constructorimpl17, companion18.getApplyOnDeactivatedNodeAssertion());
                            Updater.m5184setimpl(composerM5176constructorimpl17, modifierMaterializeModifier17, companion18.getSetModifier());
                            BoxScopeInstance boxScopeInstance17 = BoxScopeInstance.INSTANCE;
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue2 == companion.getEmpty()) {
                                objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            mutableState = (MutableState) objRememberedValue2;
                            softwareKeyboardController = (SoftwareKeyboardController) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalSoftwareKeyboardController());
                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue3 == companion.getEmpty()) {
                                objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new PermissionsRequesterState(null, false, va.w.q(PermissionNeedIt.STORAGE, PermissionNeedIt.CAMERA, PermissionNeedIt.RECORD_AUDIO), 1, null), null, 2, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            }
                            mutableState2 = (MutableState) objRememberedValue3;
                            Context context17 = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                            PermissionsRequesterState permissionsRequesterState1113 = (PermissionsRequesterState) mutableState2.getValue();
                            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue4 == companion.getEmpty()) {
                                objRememberedValue4 = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.h
                                    @Override // lb.a
                                    public final Object invoke() {
                                        return CameraKt.Camera$lambda$2$4$0(mutableState2);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                            }
                            lb.a aVar1115 = (lb.a) objRememberedValue4;
                            objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue5 == companion.getEmpty()) {
                                objRememberedValue5 = new Function1() { // from class: cu.todus.android.uiCompose.shared.camera.i
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return CameraKt.Camera$lambda$2$5$0(mutableState2, (PermissionsResult) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                            }
                            z25 = z22;
                            z26 = z23;
                            Z17PermissionRequesterKt.Z17PermissionChecker(null, aVar1115, permissionsRequesterState1113, (Function1) objRememberedValue5, ComposableLambdaKt.rememberComposableLambda(930493182, true, new Function3() { // from class: cu.todus.android.uiCompose.shared.camera.j
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return CameraKt.Camera$lambda$2$6(mutableState2, onClose, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, composerStartRestartGroup, 54), composerStartRestartGroup, 27696, 1);
                            PermissionsRequesterState permissionsRequesterState1114 = (PermissionsRequesterState) mutableState2.getValue();
                            String packageName17 = context17.getPackageName();
                            kotlin.jvm.internal.y.h(packageName17, "getPackageName(...)");
                            objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue6 == companion.getEmpty()) {
                                objRememberedValue6 = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.k
                                    @Override // lb.a
                                    public final Object invoke() {
                                        return CameraKt.Camera$lambda$2$7$0(mutableState2);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                            }
                            lb.a aVar1116 = (lb.a) objRememberedValue6;
                            objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue7 == companion.getEmpty()) {
                                objRememberedValue7 = new Function1() { // from class: cu.todus.android.uiCompose.shared.camera.m
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return CameraKt.Camera$lambda$2$8$0(mutableState2, (PermissionsResult) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                            }
                            Z17PermissionRequesterKt.Z17PermissionRequester(permissionsRequesterState1114, aVar1116, (Function1) objRememberedValue7, packageName17, composerStartRestartGroup, 432);
                            state = ((PermissionsRequesterState) mutableState2.getValue()).getPermissionsResult().getState();
                            if (state == null) {
                                z27 = z15;
                                j13 = j12;
                                cameraParams6 = cameraParams5;
                                z28 = z24;
                                z29 = z25;
                                z30 = z26;
                                composerStartRestartGroup.startReplaceGroup(-225953116);
                                composerStartRestartGroup.endReplaceGroup();
                            } else {
                                composerStartRestartGroup.startReplaceGroup(-226627738);
                                Modifier modifierFillMaxSize$default17 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                                boolean zCamera$lambda$2$17 = Camera$lambda$2$1(mutableState);
                                objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue8 == companion.getEmpty()) {
                                    objRememberedValue8 = new Function1() { // from class: cu.todus.android.uiCompose.shared.camera.n
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            return CameraKt.Camera$lambda$2$9$0(mutableState, ((Boolean) obj).booleanValue());
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                                }
                                Function1 function17 = (Function1) objRememberedValue8;
                                int i31111117 = i13 << 3;
                                int i31111118 = (i13 & 112) | 6 | (i13 & 896) | (i13 & 7168) | (57344 & i13) | (458752 & i13) | (3670016 & i13) | (234881024 & i31111117) | (i31111117 & C.ENCODING_PCM_DOUBLE);
                                int i31111119 = i25 << 3;
                                int i311111110 = ((i13 >> 27) & 14) | 3072 | (i31111119 & 112) | (i31111119 & 896);
                                z27 = z15;
                                j13 = j12;
                                z28 = z24;
                                z29 = z25;
                                cameraParams6 = cameraParams5;
                                z30 = z26;
                                CameraPager(modifierFillMaxSize$default17, cameraParams6, z28, z27, z29, z30, j13, zCamera$lambda$2$17, sendVideos, sendImages, aVar2, onClose, onError, function17, composerStartRestartGroup, i31111118, i311111110, 0);
                                composerStartRestartGroup.endReplaceGroup();
                            }
                            ua.k0 k0Var17 = ua.k0.f43947a;
                            zChanged = composerStartRestartGroup.changed(softwareKeyboardController);
                            objRememberedValue9 = composerStartRestartGroup.rememberedValue();
                            if (zChanged) {
                                objRememberedValue9 = new CameraKt$Camera$3$7$1(softwareKeyboardController, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
                            } else {
                                objRememberedValue9 = new CameraKt$Camera$3$7$1(softwareKeyboardController, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
                            }
                            EffectsKt.LaunchedEffect(k0Var17, (Function2) objRememberedValue9, composerStartRestartGroup, 6);
                            composerStartRestartGroup.endNode();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            j11 = j13;
                            z20 = z30;
                            z16 = z29;
                            z19 = z27;
                            z18 = z28;
                            cameraParams3 = cameraParams6;
                            modifier3 = modifier4;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            j11 = j10;
                            cameraParams3 = cameraParams2;
                            modifier3 = modifier2;
                            z18 = z14;
                            z19 = z15;
                            z20 = z13;
                            aVar2 = aVar;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.shared.camera.o
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return CameraKt.Camera$lambda$3(modifier3, cameraParams3, z18, z19, z16, z20, j11, sendVideos, sendImages, aVar2, onClose, onError, i10, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                        }
                    }
                    i13 |= 805306368;
                    if ((i11 & 6) == 0) {
                        if (composerStartRestartGroup.changedInstance(onClose)) {
                            i27 = 4;
                        } else {
                            i27 = 2;
                        }
                        i24 = i11 | i27;
                    } else {
                        i24 = i11;
                    }
                    if ((i11 & 48) == 0) {
                        if (composerStartRestartGroup.changedInstance(onError)) {
                            i26 = 32;
                        } else {
                            i26 = 16;
                        }
                        i24 |= i26;
                    }
                    i25 = i24;
                    if ((i13 & 306783379) == 306783378) {
                        z17 = true;
                    } else {
                        z17 = true;
                    }
                    if (composerStartRestartGroup.shouldExecute(z17, i13 & 1)) {
                        if (i30 != 0) {
                            modifier4 = Modifier.INSTANCE;
                        } else {
                            modifier4 = modifier2;
                        }
                        if (i31 != 0) {
                            cameraParams4 = new CameraParams(null, null, 0L, 7, null);
                        } else {
                            cameraParams4 = cameraParams2;
                        }
                        if (i32 != 0) {
                            z21 = true;
                        } else {
                            z21 = z14;
                        }
                        if (i14 != 0) {
                            z15 = true;
                        }
                        if (i16 != 0) {
                            z22 = false;
                        } else {
                            z22 = z16;
                        }
                        if (i18 != 0) {
                            z23 = false;
                        } else {
                            z23 = z13;
                        }
                        if (i20 != 0) {
                            j12 = Long.MAX_VALUE;
                        } else {
                            j12 = j10;
                        }
                        if (i22 != 0) {
                            objRememberedValue10 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue10 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue10 = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.f
                                    @Override // lb.a
                                    public final Object invoke() {
                                        return ua.k0.f43947a;
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue10);
                            }
                            aVar2 = (lb.a) objRememberedValue10;
                        } else {
                            aVar2 = aVar;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1559415396, i13, i25, "cu.todus.android.uiCompose.shared.camera.Camera (Camera.kt:107)");
                        }
                        Modifier modifierImePadding18 = WindowInsetsPadding_androidKt.imePadding(modifier4);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        companion = Composer.INSTANCE;
                        if (objRememberedValue == companion.getEmpty()) {
                            objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.g
                                @Override // lb.a
                                public final Object invoke() {
                                    return ua.k0.f43947a;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        Modifier modifierM1205backgroundbw27NRU$default18 = BackgroundKt.m1205backgroundbw27NRU$default(ClickableKt.m1240clickableoSLSa3U$default(modifierImePadding18, false, null, null, null, (lb.a) objRememberedValue, 14, null), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground(), null, 2, null);
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy18 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                        int iA18 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap18 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier18 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1205backgroundbw27NRU$default18);
                        ComposeUiNode.Companion companion19 = ComposeUiNode.INSTANCE;
                        cameraParams5 = cameraParams4;
                        constructor = companion19.getConstructor();
                        if (!defpackage.r.a(composerStartRestartGroup.getApplier())) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(constructor);
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        Composer composerM5176constructorimpl18 = Updater.m5176constructorimpl(composerStartRestartGroup);
                        z24 = z21;
                        Updater.m5184setimpl(composerM5176constructorimpl18, measurePolicyMaybeCachedBoxMeasurePolicy18, companion19.getSetMeasurePolicy());
                        Updater.m5184setimpl(composerM5176constructorimpl18, currentCompositionLocalMap18, companion19.getSetResolvedCompositionLocals());
                        Updater.m5180initimpl(composerM5176constructorimpl18, Integer.valueOf(iA18), companion19.getSetCompositeKeyHash());
                        Updater.m5182reconcileimpl(composerM5176constructorimpl18, companion19.getApplyOnDeactivatedNodeAssertion());
                        Updater.m5184setimpl(composerM5176constructorimpl18, modifierMaterializeModifier18, companion19.getSetModifier());
                        BoxScopeInstance boxScopeInstance18 = BoxScopeInstance.INSTANCE;
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == companion.getEmpty()) {
                            objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        mutableState = (MutableState) objRememberedValue2;
                        softwareKeyboardController = (SoftwareKeyboardController) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalSoftwareKeyboardController());
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue3 == companion.getEmpty()) {
                            objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new PermissionsRequesterState(null, false, va.w.q(PermissionNeedIt.STORAGE, PermissionNeedIt.CAMERA, PermissionNeedIt.RECORD_AUDIO), 1, null), null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        mutableState2 = (MutableState) objRememberedValue3;
                        Context context18 = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                        PermissionsRequesterState permissionsRequesterState1115 = (PermissionsRequesterState) mutableState2.getValue();
                        objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue4 == companion.getEmpty()) {
                            objRememberedValue4 = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.h
                                @Override // lb.a
                                public final Object invoke() {
                                    return CameraKt.Camera$lambda$2$4$0(mutableState2);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        }
                        lb.a aVar1117 = (lb.a) objRememberedValue4;
                        objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue5 == companion.getEmpty()) {
                            objRememberedValue5 = new Function1() { // from class: cu.todus.android.uiCompose.shared.camera.i
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return CameraKt.Camera$lambda$2$5$0(mutableState2, (PermissionsResult) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                        }
                        z25 = z22;
                        z26 = z23;
                        Z17PermissionRequesterKt.Z17PermissionChecker(null, aVar1117, permissionsRequesterState1115, (Function1) objRememberedValue5, ComposableLambdaKt.rememberComposableLambda(930493182, true, new Function3() { // from class: cu.todus.android.uiCompose.shared.camera.j
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return CameraKt.Camera$lambda$2$6(mutableState2, onClose, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, 27696, 1);
                        PermissionsRequesterState permissionsRequesterState1116 = (PermissionsRequesterState) mutableState2.getValue();
                        String packageName18 = context18.getPackageName();
                        kotlin.jvm.internal.y.h(packageName18, "getPackageName(...)");
                        objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue6 == companion.getEmpty()) {
                            objRememberedValue6 = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.k
                                @Override // lb.a
                                public final Object invoke() {
                                    return CameraKt.Camera$lambda$2$7$0(mutableState2);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                        }
                        lb.a aVar1118 = (lb.a) objRememberedValue6;
                        objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue7 == companion.getEmpty()) {
                            objRememberedValue7 = new Function1() { // from class: cu.todus.android.uiCompose.shared.camera.m
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return CameraKt.Camera$lambda$2$8$0(mutableState2, (PermissionsResult) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                        }
                        Z17PermissionRequesterKt.Z17PermissionRequester(permissionsRequesterState1116, aVar1118, (Function1) objRememberedValue7, packageName18, composerStartRestartGroup, 432);
                        state = ((PermissionsRequesterState) mutableState2.getValue()).getPermissionsResult().getState();
                        if (state == null) {
                            z27 = z15;
                            j13 = j12;
                            cameraParams6 = cameraParams5;
                            z28 = z24;
                            z29 = z25;
                            z30 = z26;
                            composerStartRestartGroup.startReplaceGroup(-225953116);
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(-226627738);
                            Modifier modifierFillMaxSize$default18 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                            boolean zCamera$lambda$2$18 = Camera$lambda$2$1(mutableState);
                            objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue8 == companion.getEmpty()) {
                                objRememberedValue8 = new Function1() { // from class: cu.todus.android.uiCompose.shared.camera.n
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return CameraKt.Camera$lambda$2$9$0(mutableState, ((Boolean) obj).booleanValue());
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                            }
                            Function1 function18 = (Function1) objRememberedValue8;
                            int i311111111 = i13 << 3;
                            int i311111112 = (i13 & 112) | 6 | (i13 & 896) | (i13 & 7168) | (57344 & i13) | (458752 & i13) | (3670016 & i13) | (234881024 & i311111111) | (i311111111 & C.ENCODING_PCM_DOUBLE);
                            int i311111113 = i25 << 3;
                            int i311111114 = ((i13 >> 27) & 14) | 3072 | (i311111113 & 112) | (i311111113 & 896);
                            z27 = z15;
                            j13 = j12;
                            z28 = z24;
                            z29 = z25;
                            cameraParams6 = cameraParams5;
                            z30 = z26;
                            CameraPager(modifierFillMaxSize$default18, cameraParams6, z28, z27, z29, z30, j13, zCamera$lambda$2$18, sendVideos, sendImages, aVar2, onClose, onError, function18, composerStartRestartGroup, i311111112, i311111114, 0);
                            composerStartRestartGroup.endReplaceGroup();
                        }
                        ua.k0 k0Var18 = ua.k0.f43947a;
                        zChanged = composerStartRestartGroup.changed(softwareKeyboardController);
                        objRememberedValue9 = composerStartRestartGroup.rememberedValue();
                        if (zChanged) {
                            objRememberedValue9 = new CameraKt$Camera$3$7$1(softwareKeyboardController, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
                        } else {
                            objRememberedValue9 = new CameraKt$Camera$3$7$1(softwareKeyboardController, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
                        }
                        EffectsKt.LaunchedEffect(k0Var18, (Function2) objRememberedValue9, composerStartRestartGroup, 6);
                        composerStartRestartGroup.endNode();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        j11 = j13;
                        z20 = z30;
                        z16 = z29;
                        z19 = z27;
                        z18 = z28;
                        cameraParams3 = cameraParams6;
                        modifier3 = modifier4;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        j11 = j10;
                        cameraParams3 = cameraParams2;
                        modifier3 = modifier2;
                        z18 = z14;
                        z19 = z15;
                        z20 = z13;
                        aVar2 = aVar;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.shared.camera.o
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return CameraKt.Camera$lambda$3(modifier3, cameraParams3, z18, z19, z16, z20, j11, sendVideos, sendImages, aVar2, onClose, onError, i10, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i13 |= 1572864;
                if ((i10 & 12582912) == 0) {
                    if (composerStartRestartGroup.changedInstance(sendVideos)) {
                        i29 = 8388608;
                    } else {
                        i29 = 4194304;
                    }
                    i13 |= i29;
                }
                if ((i10 & 100663296) == 0) {
                    if (composerStartRestartGroup.changedInstance(sendImages)) {
                        i28 = 67108864;
                    } else {
                        i28 = 33554432;
                    }
                    i13 |= i28;
                }
                i22 = i12 & 512;
                if (i22 != 0) {
                    if ((i10 & 805306368) == 0) {
                        if (composerStartRestartGroup.changedInstance(aVar)) {
                            i23 = C.BUFFER_FLAG_LAST_SAMPLE;
                        } else {
                            i23 = 268435456;
                        }
                        i13 |= i23;
                    }
                    if ((i11 & 6) == 0) {
                        if (composerStartRestartGroup.changedInstance(onClose)) {
                            i27 = 4;
                        } else {
                            i27 = 2;
                        }
                        i24 = i11 | i27;
                    } else {
                        i24 = i11;
                    }
                    if ((i11 & 48) == 0) {
                        if (composerStartRestartGroup.changedInstance(onError)) {
                            i26 = 32;
                        } else {
                            i26 = 16;
                        }
                        i24 |= i26;
                    }
                    i25 = i24;
                    if ((i13 & 306783379) == 306783378) {
                        z17 = true;
                    } else {
                        z17 = true;
                    }
                    if (composerStartRestartGroup.shouldExecute(z17, i13 & 1)) {
                        if (i30 != 0) {
                            modifier4 = Modifier.INSTANCE;
                        } else {
                            modifier4 = modifier2;
                        }
                        if (i31 != 0) {
                            cameraParams4 = new CameraParams(null, null, 0L, 7, null);
                        } else {
                            cameraParams4 = cameraParams2;
                        }
                        if (i32 != 0) {
                            z21 = true;
                        } else {
                            z21 = z14;
                        }
                        if (i14 != 0) {
                            z15 = true;
                        }
                        if (i16 != 0) {
                            z22 = false;
                        } else {
                            z22 = z16;
                        }
                        if (i18 != 0) {
                            z23 = false;
                        } else {
                            z23 = z13;
                        }
                        if (i20 != 0) {
                            j12 = Long.MAX_VALUE;
                        } else {
                            j12 = j10;
                        }
                        if (i22 != 0) {
                            objRememberedValue10 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue10 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue10 = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.f
                                    @Override // lb.a
                                    public final Object invoke() {
                                        return ua.k0.f43947a;
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue10);
                            }
                            aVar2 = (lb.a) objRememberedValue10;
                        } else {
                            aVar2 = aVar;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1559415396, i13, i25, "cu.todus.android.uiCompose.shared.camera.Camera (Camera.kt:107)");
                        }
                        Modifier modifierImePadding19 = WindowInsetsPadding_androidKt.imePadding(modifier4);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        companion = Composer.INSTANCE;
                        if (objRememberedValue == companion.getEmpty()) {
                            objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.g
                                @Override // lb.a
                                public final Object invoke() {
                                    return ua.k0.f43947a;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        Modifier modifierM1205backgroundbw27NRU$default19 = BackgroundKt.m1205backgroundbw27NRU$default(ClickableKt.m1240clickableoSLSa3U$default(modifierImePadding19, false, null, null, null, (lb.a) objRememberedValue, 14, null), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground(), null, 2, null);
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy19 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                        int iA19 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap19 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier19 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1205backgroundbw27NRU$default19);
                        ComposeUiNode.Companion companion110 = ComposeUiNode.INSTANCE;
                        cameraParams5 = cameraParams4;
                        constructor = companion110.getConstructor();
                        if (!defpackage.r.a(composerStartRestartGroup.getApplier())) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(constructor);
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        Composer composerM5176constructorimpl19 = Updater.m5176constructorimpl(composerStartRestartGroup);
                        z24 = z21;
                        Updater.m5184setimpl(composerM5176constructorimpl19, measurePolicyMaybeCachedBoxMeasurePolicy19, companion110.getSetMeasurePolicy());
                        Updater.m5184setimpl(composerM5176constructorimpl19, currentCompositionLocalMap19, companion110.getSetResolvedCompositionLocals());
                        Updater.m5180initimpl(composerM5176constructorimpl19, Integer.valueOf(iA19), companion110.getSetCompositeKeyHash());
                        Updater.m5182reconcileimpl(composerM5176constructorimpl19, companion110.getApplyOnDeactivatedNodeAssertion());
                        Updater.m5184setimpl(composerM5176constructorimpl19, modifierMaterializeModifier19, companion110.getSetModifier());
                        BoxScopeInstance boxScopeInstance19 = BoxScopeInstance.INSTANCE;
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == companion.getEmpty()) {
                            objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        mutableState = (MutableState) objRememberedValue2;
                        softwareKeyboardController = (SoftwareKeyboardController) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalSoftwareKeyboardController());
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue3 == companion.getEmpty()) {
                            objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new PermissionsRequesterState(null, false, va.w.q(PermissionNeedIt.STORAGE, PermissionNeedIt.CAMERA, PermissionNeedIt.RECORD_AUDIO), 1, null), null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        mutableState2 = (MutableState) objRememberedValue3;
                        Context context19 = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                        PermissionsRequesterState permissionsRequesterState1117 = (PermissionsRequesterState) mutableState2.getValue();
                        objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue4 == companion.getEmpty()) {
                            objRememberedValue4 = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.h
                                @Override // lb.a
                                public final Object invoke() {
                                    return CameraKt.Camera$lambda$2$4$0(mutableState2);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        }
                        lb.a aVar1119 = (lb.a) objRememberedValue4;
                        objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue5 == companion.getEmpty()) {
                            objRememberedValue5 = new Function1() { // from class: cu.todus.android.uiCompose.shared.camera.i
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return CameraKt.Camera$lambda$2$5$0(mutableState2, (PermissionsResult) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                        }
                        z25 = z22;
                        z26 = z23;
                        Z17PermissionRequesterKt.Z17PermissionChecker(null, aVar1119, permissionsRequesterState1117, (Function1) objRememberedValue5, ComposableLambdaKt.rememberComposableLambda(930493182, true, new Function3() { // from class: cu.todus.android.uiCompose.shared.camera.j
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return CameraKt.Camera$lambda$2$6(mutableState2, onClose, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, 27696, 1);
                        PermissionsRequesterState permissionsRequesterState1118 = (PermissionsRequesterState) mutableState2.getValue();
                        String packageName19 = context19.getPackageName();
                        kotlin.jvm.internal.y.h(packageName19, "getPackageName(...)");
                        objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue6 == companion.getEmpty()) {
                            objRememberedValue6 = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.k
                                @Override // lb.a
                                public final Object invoke() {
                                    return CameraKt.Camera$lambda$2$7$0(mutableState2);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                        }
                        lb.a aVar11110 = (lb.a) objRememberedValue6;
                        objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue7 == companion.getEmpty()) {
                            objRememberedValue7 = new Function1() { // from class: cu.todus.android.uiCompose.shared.camera.m
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return CameraKt.Camera$lambda$2$8$0(mutableState2, (PermissionsResult) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                        }
                        Z17PermissionRequesterKt.Z17PermissionRequester(permissionsRequesterState1118, aVar11110, (Function1) objRememberedValue7, packageName19, composerStartRestartGroup, 432);
                        state = ((PermissionsRequesterState) mutableState2.getValue()).getPermissionsResult().getState();
                        if (state == null) {
                            z27 = z15;
                            j13 = j12;
                            cameraParams6 = cameraParams5;
                            z28 = z24;
                            z29 = z25;
                            z30 = z26;
                            composerStartRestartGroup.startReplaceGroup(-225953116);
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(-226627738);
                            Modifier modifierFillMaxSize$default19 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                            boolean zCamera$lambda$2$19 = Camera$lambda$2$1(mutableState);
                            objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue8 == companion.getEmpty()) {
                                objRememberedValue8 = new Function1() { // from class: cu.todus.android.uiCompose.shared.camera.n
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return CameraKt.Camera$lambda$2$9$0(mutableState, ((Boolean) obj).booleanValue());
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                            }
                            Function1 function19 = (Function1) objRememberedValue8;
                            int i311111115 = i13 << 3;
                            int i311111116 = (i13 & 112) | 6 | (i13 & 896) | (i13 & 7168) | (57344 & i13) | (458752 & i13) | (3670016 & i13) | (234881024 & i311111115) | (i311111115 & C.ENCODING_PCM_DOUBLE);
                            int i311111117 = i25 << 3;
                            int i311111118 = ((i13 >> 27) & 14) | 3072 | (i311111117 & 112) | (i311111117 & 896);
                            z27 = z15;
                            j13 = j12;
                            z28 = z24;
                            z29 = z25;
                            cameraParams6 = cameraParams5;
                            z30 = z26;
                            CameraPager(modifierFillMaxSize$default19, cameraParams6, z28, z27, z29, z30, j13, zCamera$lambda$2$19, sendVideos, sendImages, aVar2, onClose, onError, function19, composerStartRestartGroup, i311111116, i311111118, 0);
                            composerStartRestartGroup.endReplaceGroup();
                        }
                        ua.k0 k0Var19 = ua.k0.f43947a;
                        zChanged = composerStartRestartGroup.changed(softwareKeyboardController);
                        objRememberedValue9 = composerStartRestartGroup.rememberedValue();
                        if (zChanged) {
                            objRememberedValue9 = new CameraKt$Camera$3$7$1(softwareKeyboardController, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
                        } else {
                            objRememberedValue9 = new CameraKt$Camera$3$7$1(softwareKeyboardController, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
                        }
                        EffectsKt.LaunchedEffect(k0Var19, (Function2) objRememberedValue9, composerStartRestartGroup, 6);
                        composerStartRestartGroup.endNode();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        j11 = j13;
                        z20 = z30;
                        z16 = z29;
                        z19 = z27;
                        z18 = z28;
                        cameraParams3 = cameraParams6;
                        modifier3 = modifier4;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        j11 = j10;
                        cameraParams3 = cameraParams2;
                        modifier3 = modifier2;
                        z18 = z14;
                        z19 = z15;
                        z20 = z13;
                        aVar2 = aVar;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.shared.camera.o
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return CameraKt.Camera$lambda$3(modifier3, cameraParams3, z18, z19, z16, z20, j11, sendVideos, sendImages, aVar2, onClose, onError, i10, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i13 |= 805306368;
                if ((i11 & 6) == 0) {
                    if (composerStartRestartGroup.changedInstance(onClose)) {
                        i27 = 4;
                    } else {
                        i27 = 2;
                    }
                    i24 = i11 | i27;
                } else {
                    i24 = i11;
                }
                if ((i11 & 48) == 0) {
                    if (composerStartRestartGroup.changedInstance(onError)) {
                        i26 = 32;
                    } else {
                        i26 = 16;
                    }
                    i24 |= i26;
                }
                i25 = i24;
                if ((i13 & 306783379) == 306783378) {
                    z17 = true;
                } else {
                    z17 = true;
                }
                if (composerStartRestartGroup.shouldExecute(z17, i13 & 1)) {
                    if (i30 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i31 != 0) {
                        cameraParams4 = new CameraParams(null, null, 0L, 7, null);
                    } else {
                        cameraParams4 = cameraParams2;
                    }
                    if (i32 != 0) {
                        z21 = true;
                    } else {
                        z21 = z14;
                    }
                    if (i14 != 0) {
                        z15 = true;
                    }
                    if (i16 != 0) {
                        z22 = false;
                    } else {
                        z22 = z16;
                    }
                    if (i18 != 0) {
                        z23 = false;
                    } else {
                        z23 = z13;
                    }
                    if (i20 != 0) {
                        j12 = Long.MAX_VALUE;
                    } else {
                        j12 = j10;
                    }
                    if (i22 != 0) {
                        objRememberedValue10 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue10 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue10 = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.f
                                @Override // lb.a
                                public final Object invoke() {
                                    return ua.k0.f43947a;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue10);
                        }
                        aVar2 = (lb.a) objRememberedValue10;
                    } else {
                        aVar2 = aVar;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1559415396, i13, i25, "cu.todus.android.uiCompose.shared.camera.Camera (Camera.kt:107)");
                    }
                    Modifier modifierImePadding110 = WindowInsetsPadding_androidKt.imePadding(modifier4);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    companion = Composer.INSTANCE;
                    if (objRememberedValue == companion.getEmpty()) {
                        objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.g
                            @Override // lb.a
                            public final Object invoke() {
                                return ua.k0.f43947a;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    Modifier modifierM1205backgroundbw27NRU$default110 = BackgroundKt.m1205backgroundbw27NRU$default(ClickableKt.m1240clickableoSLSa3U$default(modifierImePadding110, false, null, null, null, (lb.a) objRememberedValue, 14, null), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground(), null, 2, null);
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy110 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                    int iA110 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap110 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier110 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1205backgroundbw27NRU$default110);
                    ComposeUiNode.Companion companion111 = ComposeUiNode.INSTANCE;
                    cameraParams5 = cameraParams4;
                    constructor = companion111.getConstructor();
                    if (!defpackage.r.a(composerStartRestartGroup.getApplier())) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM5176constructorimpl110 = Updater.m5176constructorimpl(composerStartRestartGroup);
                    z24 = z21;
                    Updater.m5184setimpl(composerM5176constructorimpl110, measurePolicyMaybeCachedBoxMeasurePolicy110, companion111.getSetMeasurePolicy());
                    Updater.m5184setimpl(composerM5176constructorimpl110, currentCompositionLocalMap110, companion111.getSetResolvedCompositionLocals());
                    Updater.m5180initimpl(composerM5176constructorimpl110, Integer.valueOf(iA110), companion111.getSetCompositeKeyHash());
                    Updater.m5182reconcileimpl(composerM5176constructorimpl110, companion111.getApplyOnDeactivatedNodeAssertion());
                    Updater.m5184setimpl(composerM5176constructorimpl110, modifierMaterializeModifier110, companion111.getSetModifier());
                    BoxScopeInstance boxScopeInstance110 = BoxScopeInstance.INSTANCE;
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == companion.getEmpty()) {
                        objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    mutableState = (MutableState) objRememberedValue2;
                    softwareKeyboardController = (SoftwareKeyboardController) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalSoftwareKeyboardController());
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue3 == companion.getEmpty()) {
                        objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new PermissionsRequesterState(null, false, va.w.q(PermissionNeedIt.STORAGE, PermissionNeedIt.CAMERA, PermissionNeedIt.RECORD_AUDIO), 1, null), null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    mutableState2 = (MutableState) objRememberedValue3;
                    Context context110 = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                    PermissionsRequesterState permissionsRequesterState1119 = (PermissionsRequesterState) mutableState2.getValue();
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue4 == companion.getEmpty()) {
                        objRememberedValue4 = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.h
                            @Override // lb.a
                            public final Object invoke() {
                                return CameraKt.Camera$lambda$2$4$0(mutableState2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    lb.a aVar11111 = (lb.a) objRememberedValue4;
                    objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue5 == companion.getEmpty()) {
                        objRememberedValue5 = new Function1() { // from class: cu.todus.android.uiCompose.shared.camera.i
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return CameraKt.Camera$lambda$2$5$0(mutableState2, (PermissionsResult) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    }
                    z25 = z22;
                    z26 = z23;
                    Z17PermissionRequesterKt.Z17PermissionChecker(null, aVar11111, permissionsRequesterState1119, (Function1) objRememberedValue5, ComposableLambdaKt.rememberComposableLambda(930493182, true, new Function3() { // from class: cu.todus.android.uiCompose.shared.camera.j
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return CameraKt.Camera$lambda$2$6(mutableState2, onClose, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, 27696, 1);
                    PermissionsRequesterState permissionsRequesterState11110 = (PermissionsRequesterState) mutableState2.getValue();
                    String packageName110 = context110.getPackageName();
                    kotlin.jvm.internal.y.h(packageName110, "getPackageName(...)");
                    objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue6 == companion.getEmpty()) {
                        objRememberedValue6 = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.k
                            @Override // lb.a
                            public final Object invoke() {
                                return CameraKt.Camera$lambda$2$7$0(mutableState2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                    }
                    lb.a aVar11112 = (lb.a) objRememberedValue6;
                    objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue7 == companion.getEmpty()) {
                        objRememberedValue7 = new Function1() { // from class: cu.todus.android.uiCompose.shared.camera.m
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return CameraKt.Camera$lambda$2$8$0(mutableState2, (PermissionsResult) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                    }
                    Z17PermissionRequesterKt.Z17PermissionRequester(permissionsRequesterState11110, aVar11112, (Function1) objRememberedValue7, packageName110, composerStartRestartGroup, 432);
                    state = ((PermissionsRequesterState) mutableState2.getValue()).getPermissionsResult().getState();
                    if (state == null) {
                        z27 = z15;
                        j13 = j12;
                        cameraParams6 = cameraParams5;
                        z28 = z24;
                        z29 = z25;
                        z30 = z26;
                        composerStartRestartGroup.startReplaceGroup(-225953116);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-226627738);
                        Modifier modifierFillMaxSize$default110 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                        boolean zCamera$lambda$2$110 = Camera$lambda$2$1(mutableState);
                        objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue8 == companion.getEmpty()) {
                            objRememberedValue8 = new Function1() { // from class: cu.todus.android.uiCompose.shared.camera.n
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return CameraKt.Camera$lambda$2$9$0(mutableState, ((Boolean) obj).booleanValue());
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                        }
                        Function1 function110 = (Function1) objRememberedValue8;
                        int i311111119 = i13 << 3;
                        int i3111111110 = (i13 & 112) | 6 | (i13 & 896) | (i13 & 7168) | (57344 & i13) | (458752 & i13) | (3670016 & i13) | (234881024 & i311111119) | (i311111119 & C.ENCODING_PCM_DOUBLE);
                        int i3111111111 = i25 << 3;
                        int i3111111112 = ((i13 >> 27) & 14) | 3072 | (i3111111111 & 112) | (i3111111111 & 896);
                        z27 = z15;
                        j13 = j12;
                        z28 = z24;
                        z29 = z25;
                        cameraParams6 = cameraParams5;
                        z30 = z26;
                        CameraPager(modifierFillMaxSize$default110, cameraParams6, z28, z27, z29, z30, j13, zCamera$lambda$2$110, sendVideos, sendImages, aVar2, onClose, onError, function110, composerStartRestartGroup, i3111111110, i3111111112, 0);
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    ua.k0 k0Var110 = ua.k0.f43947a;
                    zChanged = composerStartRestartGroup.changed(softwareKeyboardController);
                    objRememberedValue9 = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue9 = new CameraKt$Camera$3$7$1(softwareKeyboardController, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
                    } else {
                        objRememberedValue9 = new CameraKt$Camera$3$7$1(softwareKeyboardController, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
                    }
                    EffectsKt.LaunchedEffect(k0Var110, (Function2) objRememberedValue9, composerStartRestartGroup, 6);
                    composerStartRestartGroup.endNode();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    j11 = j13;
                    z20 = z30;
                    z16 = z29;
                    z19 = z27;
                    z18 = z28;
                    cameraParams3 = cameraParams6;
                    modifier3 = modifier4;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    j11 = j10;
                    cameraParams3 = cameraParams2;
                    modifier3 = modifier2;
                    z18 = z14;
                    z19 = z15;
                    z20 = z13;
                    aVar2 = aVar;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.shared.camera.o
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return CameraKt.Camera$lambda$3(modifier3, cameraParams3, z18, z19, z16, z20, j11, sendVideos, sendImages, aVar2, onClose, onError, i10, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i13 |= 24576;
            z16 = z12;
            i18 = i12 & 32;
            if (i18 != 0) {
                i13 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            } else if ((i10 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                if (composerStartRestartGroup.changed(z13)) {
                    i19 = 131072;
                } else {
                    i19 = 65536;
                }
                i13 |= i19;
            }
            i20 = i12 & 64;
            if (i20 != 0) {
                if ((i10 & 1572864) == 0) {
                    if (composerStartRestartGroup.changed(j10)) {
                        i21 = 1048576;
                    } else {
                        i21 = 524288;
                    }
                    i13 |= i21;
                }
                if ((i10 & 12582912) == 0) {
                    if (composerStartRestartGroup.changedInstance(sendVideos)) {
                        i29 = 8388608;
                    } else {
                        i29 = 4194304;
                    }
                    i13 |= i29;
                }
                if ((i10 & 100663296) == 0) {
                    if (composerStartRestartGroup.changedInstance(sendImages)) {
                        i28 = 67108864;
                    } else {
                        i28 = 33554432;
                    }
                    i13 |= i28;
                }
                i22 = i12 & 512;
                if (i22 != 0) {
                    if ((i10 & 805306368) == 0) {
                        if (composerStartRestartGroup.changedInstance(aVar)) {
                            i23 = C.BUFFER_FLAG_LAST_SAMPLE;
                        } else {
                            i23 = 268435456;
                        }
                        i13 |= i23;
                    }
                    if ((i11 & 6) == 0) {
                        if (composerStartRestartGroup.changedInstance(onClose)) {
                            i27 = 4;
                        } else {
                            i27 = 2;
                        }
                        i24 = i11 | i27;
                    } else {
                        i24 = i11;
                    }
                    if ((i11 & 48) == 0) {
                        if (composerStartRestartGroup.changedInstance(onError)) {
                            i26 = 32;
                        } else {
                            i26 = 16;
                        }
                        i24 |= i26;
                    }
                    i25 = i24;
                    if ((i13 & 306783379) == 306783378) {
                        z17 = true;
                    } else {
                        z17 = true;
                    }
                    if (composerStartRestartGroup.shouldExecute(z17, i13 & 1)) {
                        if (i30 != 0) {
                            modifier4 = Modifier.INSTANCE;
                        } else {
                            modifier4 = modifier2;
                        }
                        if (i31 != 0) {
                            cameraParams4 = new CameraParams(null, null, 0L, 7, null);
                        } else {
                            cameraParams4 = cameraParams2;
                        }
                        if (i32 != 0) {
                            z21 = true;
                        } else {
                            z21 = z14;
                        }
                        if (i14 != 0) {
                            z15 = true;
                        }
                        if (i16 != 0) {
                            z22 = false;
                        } else {
                            z22 = z16;
                        }
                        if (i18 != 0) {
                            z23 = false;
                        } else {
                            z23 = z13;
                        }
                        if (i20 != 0) {
                            j12 = Long.MAX_VALUE;
                        } else {
                            j12 = j10;
                        }
                        if (i22 != 0) {
                            objRememberedValue10 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue10 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue10 = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.f
                                    @Override // lb.a
                                    public final Object invoke() {
                                        return ua.k0.f43947a;
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue10);
                            }
                            aVar2 = (lb.a) objRememberedValue10;
                        } else {
                            aVar2 = aVar;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1559415396, i13, i25, "cu.todus.android.uiCompose.shared.camera.Camera (Camera.kt:107)");
                        }
                        Modifier modifierImePadding111 = WindowInsetsPadding_androidKt.imePadding(modifier4);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        companion = Composer.INSTANCE;
                        if (objRememberedValue == companion.getEmpty()) {
                            objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.g
                                @Override // lb.a
                                public final Object invoke() {
                                    return ua.k0.f43947a;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        Modifier modifierM1205backgroundbw27NRU$default111 = BackgroundKt.m1205backgroundbw27NRU$default(ClickableKt.m1240clickableoSLSa3U$default(modifierImePadding111, false, null, null, null, (lb.a) objRememberedValue, 14, null), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground(), null, 2, null);
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy111 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                        int iA111 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap111 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier111 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1205backgroundbw27NRU$default111);
                        ComposeUiNode.Companion companion112 = ComposeUiNode.INSTANCE;
                        cameraParams5 = cameraParams4;
                        constructor = companion112.getConstructor();
                        if (!defpackage.r.a(composerStartRestartGroup.getApplier())) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(constructor);
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        Composer composerM5176constructorimpl111 = Updater.m5176constructorimpl(composerStartRestartGroup);
                        z24 = z21;
                        Updater.m5184setimpl(composerM5176constructorimpl111, measurePolicyMaybeCachedBoxMeasurePolicy111, companion112.getSetMeasurePolicy());
                        Updater.m5184setimpl(composerM5176constructorimpl111, currentCompositionLocalMap111, companion112.getSetResolvedCompositionLocals());
                        Updater.m5180initimpl(composerM5176constructorimpl111, Integer.valueOf(iA111), companion112.getSetCompositeKeyHash());
                        Updater.m5182reconcileimpl(composerM5176constructorimpl111, companion112.getApplyOnDeactivatedNodeAssertion());
                        Updater.m5184setimpl(composerM5176constructorimpl111, modifierMaterializeModifier111, companion112.getSetModifier());
                        BoxScopeInstance boxScopeInstance111 = BoxScopeInstance.INSTANCE;
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == companion.getEmpty()) {
                            objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        mutableState = (MutableState) objRememberedValue2;
                        softwareKeyboardController = (SoftwareKeyboardController) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalSoftwareKeyboardController());
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue3 == companion.getEmpty()) {
                            objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new PermissionsRequesterState(null, false, va.w.q(PermissionNeedIt.STORAGE, PermissionNeedIt.CAMERA, PermissionNeedIt.RECORD_AUDIO), 1, null), null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        mutableState2 = (MutableState) objRememberedValue3;
                        Context context111 = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                        PermissionsRequesterState permissionsRequesterState11111 = (PermissionsRequesterState) mutableState2.getValue();
                        objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue4 == companion.getEmpty()) {
                            objRememberedValue4 = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.h
                                @Override // lb.a
                                public final Object invoke() {
                                    return CameraKt.Camera$lambda$2$4$0(mutableState2);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        }
                        lb.a aVar11113 = (lb.a) objRememberedValue4;
                        objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue5 == companion.getEmpty()) {
                            objRememberedValue5 = new Function1() { // from class: cu.todus.android.uiCompose.shared.camera.i
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return CameraKt.Camera$lambda$2$5$0(mutableState2, (PermissionsResult) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                        }
                        z25 = z22;
                        z26 = z23;
                        Z17PermissionRequesterKt.Z17PermissionChecker(null, aVar11113, permissionsRequesterState11111, (Function1) objRememberedValue5, ComposableLambdaKt.rememberComposableLambda(930493182, true, new Function3() { // from class: cu.todus.android.uiCompose.shared.camera.j
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return CameraKt.Camera$lambda$2$6(mutableState2, onClose, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, 27696, 1);
                        PermissionsRequesterState permissionsRequesterState11112 = (PermissionsRequesterState) mutableState2.getValue();
                        String packageName111 = context111.getPackageName();
                        kotlin.jvm.internal.y.h(packageName111, "getPackageName(...)");
                        objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue6 == companion.getEmpty()) {
                            objRememberedValue6 = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.k
                                @Override // lb.a
                                public final Object invoke() {
                                    return CameraKt.Camera$lambda$2$7$0(mutableState2);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                        }
                        lb.a aVar11114 = (lb.a) objRememberedValue6;
                        objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue7 == companion.getEmpty()) {
                            objRememberedValue7 = new Function1() { // from class: cu.todus.android.uiCompose.shared.camera.m
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return CameraKt.Camera$lambda$2$8$0(mutableState2, (PermissionsResult) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                        }
                        Z17PermissionRequesterKt.Z17PermissionRequester(permissionsRequesterState11112, aVar11114, (Function1) objRememberedValue7, packageName111, composerStartRestartGroup, 432);
                        state = ((PermissionsRequesterState) mutableState2.getValue()).getPermissionsResult().getState();
                        if (state == null) {
                            z27 = z15;
                            j13 = j12;
                            cameraParams6 = cameraParams5;
                            z28 = z24;
                            z29 = z25;
                            z30 = z26;
                            composerStartRestartGroup.startReplaceGroup(-225953116);
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(-226627738);
                            Modifier modifierFillMaxSize$default111 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                            boolean zCamera$lambda$2$111 = Camera$lambda$2$1(mutableState);
                            objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue8 == companion.getEmpty()) {
                                objRememberedValue8 = new Function1() { // from class: cu.todus.android.uiCompose.shared.camera.n
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return CameraKt.Camera$lambda$2$9$0(mutableState, ((Boolean) obj).booleanValue());
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                            }
                            Function1 function111 = (Function1) objRememberedValue8;
                            int i3111111113 = i13 << 3;
                            int i3111111114 = (i13 & 112) | 6 | (i13 & 896) | (i13 & 7168) | (57344 & i13) | (458752 & i13) | (3670016 & i13) | (234881024 & i3111111113) | (i3111111113 & C.ENCODING_PCM_DOUBLE);
                            int i3111111115 = i25 << 3;
                            int i3111111116 = ((i13 >> 27) & 14) | 3072 | (i3111111115 & 112) | (i3111111115 & 896);
                            z27 = z15;
                            j13 = j12;
                            z28 = z24;
                            z29 = z25;
                            cameraParams6 = cameraParams5;
                            z30 = z26;
                            CameraPager(modifierFillMaxSize$default111, cameraParams6, z28, z27, z29, z30, j13, zCamera$lambda$2$111, sendVideos, sendImages, aVar2, onClose, onError, function111, composerStartRestartGroup, i3111111114, i3111111116, 0);
                            composerStartRestartGroup.endReplaceGroup();
                        }
                        ua.k0 k0Var111 = ua.k0.f43947a;
                        zChanged = composerStartRestartGroup.changed(softwareKeyboardController);
                        objRememberedValue9 = composerStartRestartGroup.rememberedValue();
                        if (zChanged) {
                            objRememberedValue9 = new CameraKt$Camera$3$7$1(softwareKeyboardController, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
                        } else {
                            objRememberedValue9 = new CameraKt$Camera$3$7$1(softwareKeyboardController, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
                        }
                        EffectsKt.LaunchedEffect(k0Var111, (Function2) objRememberedValue9, composerStartRestartGroup, 6);
                        composerStartRestartGroup.endNode();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        j11 = j13;
                        z20 = z30;
                        z16 = z29;
                        z19 = z27;
                        z18 = z28;
                        cameraParams3 = cameraParams6;
                        modifier3 = modifier4;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        j11 = j10;
                        cameraParams3 = cameraParams2;
                        modifier3 = modifier2;
                        z18 = z14;
                        z19 = z15;
                        z20 = z13;
                        aVar2 = aVar;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.shared.camera.o
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return CameraKt.Camera$lambda$3(modifier3, cameraParams3, z18, z19, z16, z20, j11, sendVideos, sendImages, aVar2, onClose, onError, i10, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i13 |= 805306368;
                if ((i11 & 6) == 0) {
                    if (composerStartRestartGroup.changedInstance(onClose)) {
                        i27 = 4;
                    } else {
                        i27 = 2;
                    }
                    i24 = i11 | i27;
                } else {
                    i24 = i11;
                }
                if ((i11 & 48) == 0) {
                    if (composerStartRestartGroup.changedInstance(onError)) {
                        i26 = 32;
                    } else {
                        i26 = 16;
                    }
                    i24 |= i26;
                }
                i25 = i24;
                if ((i13 & 306783379) == 306783378) {
                    z17 = true;
                } else {
                    z17 = true;
                }
                if (composerStartRestartGroup.shouldExecute(z17, i13 & 1)) {
                    if (i30 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i31 != 0) {
                        cameraParams4 = new CameraParams(null, null, 0L, 7, null);
                    } else {
                        cameraParams4 = cameraParams2;
                    }
                    if (i32 != 0) {
                        z21 = true;
                    } else {
                        z21 = z14;
                    }
                    if (i14 != 0) {
                        z15 = true;
                    }
                    if (i16 != 0) {
                        z22 = false;
                    } else {
                        z22 = z16;
                    }
                    if (i18 != 0) {
                        z23 = false;
                    } else {
                        z23 = z13;
                    }
                    if (i20 != 0) {
                        j12 = Long.MAX_VALUE;
                    } else {
                        j12 = j10;
                    }
                    if (i22 != 0) {
                        objRememberedValue10 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue10 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue10 = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.f
                                @Override // lb.a
                                public final Object invoke() {
                                    return ua.k0.f43947a;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue10);
                        }
                        aVar2 = (lb.a) objRememberedValue10;
                    } else {
                        aVar2 = aVar;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1559415396, i13, i25, "cu.todus.android.uiCompose.shared.camera.Camera (Camera.kt:107)");
                    }
                    Modifier modifierImePadding112 = WindowInsetsPadding_androidKt.imePadding(modifier4);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    companion = Composer.INSTANCE;
                    if (objRememberedValue == companion.getEmpty()) {
                        objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.g
                            @Override // lb.a
                            public final Object invoke() {
                                return ua.k0.f43947a;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    Modifier modifierM1205backgroundbw27NRU$default112 = BackgroundKt.m1205backgroundbw27NRU$default(ClickableKt.m1240clickableoSLSa3U$default(modifierImePadding112, false, null, null, null, (lb.a) objRememberedValue, 14, null), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground(), null, 2, null);
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy112 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                    int iA112 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap112 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier112 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1205backgroundbw27NRU$default112);
                    ComposeUiNode.Companion companion113 = ComposeUiNode.INSTANCE;
                    cameraParams5 = cameraParams4;
                    constructor = companion113.getConstructor();
                    if (!defpackage.r.a(composerStartRestartGroup.getApplier())) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM5176constructorimpl112 = Updater.m5176constructorimpl(composerStartRestartGroup);
                    z24 = z21;
                    Updater.m5184setimpl(composerM5176constructorimpl112, measurePolicyMaybeCachedBoxMeasurePolicy112, companion113.getSetMeasurePolicy());
                    Updater.m5184setimpl(composerM5176constructorimpl112, currentCompositionLocalMap112, companion113.getSetResolvedCompositionLocals());
                    Updater.m5180initimpl(composerM5176constructorimpl112, Integer.valueOf(iA112), companion113.getSetCompositeKeyHash());
                    Updater.m5182reconcileimpl(composerM5176constructorimpl112, companion113.getApplyOnDeactivatedNodeAssertion());
                    Updater.m5184setimpl(composerM5176constructorimpl112, modifierMaterializeModifier112, companion113.getSetModifier());
                    BoxScopeInstance boxScopeInstance112 = BoxScopeInstance.INSTANCE;
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == companion.getEmpty()) {
                        objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    mutableState = (MutableState) objRememberedValue2;
                    softwareKeyboardController = (SoftwareKeyboardController) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalSoftwareKeyboardController());
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue3 == companion.getEmpty()) {
                        objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new PermissionsRequesterState(null, false, va.w.q(PermissionNeedIt.STORAGE, PermissionNeedIt.CAMERA, PermissionNeedIt.RECORD_AUDIO), 1, null), null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    mutableState2 = (MutableState) objRememberedValue3;
                    Context context112 = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                    PermissionsRequesterState permissionsRequesterState11113 = (PermissionsRequesterState) mutableState2.getValue();
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue4 == companion.getEmpty()) {
                        objRememberedValue4 = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.h
                            @Override // lb.a
                            public final Object invoke() {
                                return CameraKt.Camera$lambda$2$4$0(mutableState2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    lb.a aVar11115 = (lb.a) objRememberedValue4;
                    objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue5 == companion.getEmpty()) {
                        objRememberedValue5 = new Function1() { // from class: cu.todus.android.uiCompose.shared.camera.i
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return CameraKt.Camera$lambda$2$5$0(mutableState2, (PermissionsResult) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    }
                    z25 = z22;
                    z26 = z23;
                    Z17PermissionRequesterKt.Z17PermissionChecker(null, aVar11115, permissionsRequesterState11113, (Function1) objRememberedValue5, ComposableLambdaKt.rememberComposableLambda(930493182, true, new Function3() { // from class: cu.todus.android.uiCompose.shared.camera.j
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return CameraKt.Camera$lambda$2$6(mutableState2, onClose, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, 27696, 1);
                    PermissionsRequesterState permissionsRequesterState11114 = (PermissionsRequesterState) mutableState2.getValue();
                    String packageName112 = context112.getPackageName();
                    kotlin.jvm.internal.y.h(packageName112, "getPackageName(...)");
                    objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue6 == companion.getEmpty()) {
                        objRememberedValue6 = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.k
                            @Override // lb.a
                            public final Object invoke() {
                                return CameraKt.Camera$lambda$2$7$0(mutableState2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                    }
                    lb.a aVar11116 = (lb.a) objRememberedValue6;
                    objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue7 == companion.getEmpty()) {
                        objRememberedValue7 = new Function1() { // from class: cu.todus.android.uiCompose.shared.camera.m
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return CameraKt.Camera$lambda$2$8$0(mutableState2, (PermissionsResult) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                    }
                    Z17PermissionRequesterKt.Z17PermissionRequester(permissionsRequesterState11114, aVar11116, (Function1) objRememberedValue7, packageName112, composerStartRestartGroup, 432);
                    state = ((PermissionsRequesterState) mutableState2.getValue()).getPermissionsResult().getState();
                    if (state == null) {
                        z27 = z15;
                        j13 = j12;
                        cameraParams6 = cameraParams5;
                        z28 = z24;
                        z29 = z25;
                        z30 = z26;
                        composerStartRestartGroup.startReplaceGroup(-225953116);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-226627738);
                        Modifier modifierFillMaxSize$default112 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                        boolean zCamera$lambda$2$112 = Camera$lambda$2$1(mutableState);
                        objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue8 == companion.getEmpty()) {
                            objRememberedValue8 = new Function1() { // from class: cu.todus.android.uiCompose.shared.camera.n
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return CameraKt.Camera$lambda$2$9$0(mutableState, ((Boolean) obj).booleanValue());
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                        }
                        Function1 function112 = (Function1) objRememberedValue8;
                        int i3111111117 = i13 << 3;
                        int i3111111118 = (i13 & 112) | 6 | (i13 & 896) | (i13 & 7168) | (57344 & i13) | (458752 & i13) | (3670016 & i13) | (234881024 & i3111111117) | (i3111111117 & C.ENCODING_PCM_DOUBLE);
                        int i3111111119 = i25 << 3;
                        int i31111111110 = ((i13 >> 27) & 14) | 3072 | (i3111111119 & 112) | (i3111111119 & 896);
                        z27 = z15;
                        j13 = j12;
                        z28 = z24;
                        z29 = z25;
                        cameraParams6 = cameraParams5;
                        z30 = z26;
                        CameraPager(modifierFillMaxSize$default112, cameraParams6, z28, z27, z29, z30, j13, zCamera$lambda$2$112, sendVideos, sendImages, aVar2, onClose, onError, function112, composerStartRestartGroup, i3111111118, i31111111110, 0);
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    ua.k0 k0Var112 = ua.k0.f43947a;
                    zChanged = composerStartRestartGroup.changed(softwareKeyboardController);
                    objRememberedValue9 = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue9 = new CameraKt$Camera$3$7$1(softwareKeyboardController, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
                    } else {
                        objRememberedValue9 = new CameraKt$Camera$3$7$1(softwareKeyboardController, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
                    }
                    EffectsKt.LaunchedEffect(k0Var112, (Function2) objRememberedValue9, composerStartRestartGroup, 6);
                    composerStartRestartGroup.endNode();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    j11 = j13;
                    z20 = z30;
                    z16 = z29;
                    z19 = z27;
                    z18 = z28;
                    cameraParams3 = cameraParams6;
                    modifier3 = modifier4;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    j11 = j10;
                    cameraParams3 = cameraParams2;
                    modifier3 = modifier2;
                    z18 = z14;
                    z19 = z15;
                    z20 = z13;
                    aVar2 = aVar;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.shared.camera.o
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return CameraKt.Camera$lambda$3(modifier3, cameraParams3, z18, z19, z16, z20, j11, sendVideos, sendImages, aVar2, onClose, onError, i10, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i13 |= 1572864;
            if ((i10 & 12582912) == 0) {
                if (composerStartRestartGroup.changedInstance(sendVideos)) {
                    i29 = 8388608;
                } else {
                    i29 = 4194304;
                }
                i13 |= i29;
            }
            if ((i10 & 100663296) == 0) {
                if (composerStartRestartGroup.changedInstance(sendImages)) {
                    i28 = 67108864;
                } else {
                    i28 = 33554432;
                }
                i13 |= i28;
            }
            i22 = i12 & 512;
            if (i22 != 0) {
                if ((i10 & 805306368) == 0) {
                    if (composerStartRestartGroup.changedInstance(aVar)) {
                        i23 = C.BUFFER_FLAG_LAST_SAMPLE;
                    } else {
                        i23 = 268435456;
                    }
                    i13 |= i23;
                }
                if ((i11 & 6) == 0) {
                    if (composerStartRestartGroup.changedInstance(onClose)) {
                        i27 = 4;
                    } else {
                        i27 = 2;
                    }
                    i24 = i11 | i27;
                } else {
                    i24 = i11;
                }
                if ((i11 & 48) == 0) {
                    if (composerStartRestartGroup.changedInstance(onError)) {
                        i26 = 32;
                    } else {
                        i26 = 16;
                    }
                    i24 |= i26;
                }
                i25 = i24;
                if ((i13 & 306783379) == 306783378) {
                    z17 = true;
                } else {
                    z17 = true;
                }
                if (composerStartRestartGroup.shouldExecute(z17, i13 & 1)) {
                    if (i30 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i31 != 0) {
                        cameraParams4 = new CameraParams(null, null, 0L, 7, null);
                    } else {
                        cameraParams4 = cameraParams2;
                    }
                    if (i32 != 0) {
                        z21 = true;
                    } else {
                        z21 = z14;
                    }
                    if (i14 != 0) {
                        z15 = true;
                    }
                    if (i16 != 0) {
                        z22 = false;
                    } else {
                        z22 = z16;
                    }
                    if (i18 != 0) {
                        z23 = false;
                    } else {
                        z23 = z13;
                    }
                    if (i20 != 0) {
                        j12 = Long.MAX_VALUE;
                    } else {
                        j12 = j10;
                    }
                    if (i22 != 0) {
                        objRememberedValue10 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue10 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue10 = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.f
                                @Override // lb.a
                                public final Object invoke() {
                                    return ua.k0.f43947a;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue10);
                        }
                        aVar2 = (lb.a) objRememberedValue10;
                    } else {
                        aVar2 = aVar;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1559415396, i13, i25, "cu.todus.android.uiCompose.shared.camera.Camera (Camera.kt:107)");
                    }
                    Modifier modifierImePadding113 = WindowInsetsPadding_androidKt.imePadding(modifier4);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    companion = Composer.INSTANCE;
                    if (objRememberedValue == companion.getEmpty()) {
                        objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.g
                            @Override // lb.a
                            public final Object invoke() {
                                return ua.k0.f43947a;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    Modifier modifierM1205backgroundbw27NRU$default113 = BackgroundKt.m1205backgroundbw27NRU$default(ClickableKt.m1240clickableoSLSa3U$default(modifierImePadding113, false, null, null, null, (lb.a) objRememberedValue, 14, null), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground(), null, 2, null);
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy113 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                    int iA113 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap113 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier113 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1205backgroundbw27NRU$default113);
                    ComposeUiNode.Companion companion114 = ComposeUiNode.INSTANCE;
                    cameraParams5 = cameraParams4;
                    constructor = companion114.getConstructor();
                    if (!defpackage.r.a(composerStartRestartGroup.getApplier())) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM5176constructorimpl113 = Updater.m5176constructorimpl(composerStartRestartGroup);
                    z24 = z21;
                    Updater.m5184setimpl(composerM5176constructorimpl113, measurePolicyMaybeCachedBoxMeasurePolicy113, companion114.getSetMeasurePolicy());
                    Updater.m5184setimpl(composerM5176constructorimpl113, currentCompositionLocalMap113, companion114.getSetResolvedCompositionLocals());
                    Updater.m5180initimpl(composerM5176constructorimpl113, Integer.valueOf(iA113), companion114.getSetCompositeKeyHash());
                    Updater.m5182reconcileimpl(composerM5176constructorimpl113, companion114.getApplyOnDeactivatedNodeAssertion());
                    Updater.m5184setimpl(composerM5176constructorimpl113, modifierMaterializeModifier113, companion114.getSetModifier());
                    BoxScopeInstance boxScopeInstance113 = BoxScopeInstance.INSTANCE;
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == companion.getEmpty()) {
                        objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    mutableState = (MutableState) objRememberedValue2;
                    softwareKeyboardController = (SoftwareKeyboardController) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalSoftwareKeyboardController());
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue3 == companion.getEmpty()) {
                        objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new PermissionsRequesterState(null, false, va.w.q(PermissionNeedIt.STORAGE, PermissionNeedIt.CAMERA, PermissionNeedIt.RECORD_AUDIO), 1, null), null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    mutableState2 = (MutableState) objRememberedValue3;
                    Context context113 = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                    PermissionsRequesterState permissionsRequesterState11115 = (PermissionsRequesterState) mutableState2.getValue();
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue4 == companion.getEmpty()) {
                        objRememberedValue4 = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.h
                            @Override // lb.a
                            public final Object invoke() {
                                return CameraKt.Camera$lambda$2$4$0(mutableState2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    lb.a aVar11117 = (lb.a) objRememberedValue4;
                    objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue5 == companion.getEmpty()) {
                        objRememberedValue5 = new Function1() { // from class: cu.todus.android.uiCompose.shared.camera.i
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return CameraKt.Camera$lambda$2$5$0(mutableState2, (PermissionsResult) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    }
                    z25 = z22;
                    z26 = z23;
                    Z17PermissionRequesterKt.Z17PermissionChecker(null, aVar11117, permissionsRequesterState11115, (Function1) objRememberedValue5, ComposableLambdaKt.rememberComposableLambda(930493182, true, new Function3() { // from class: cu.todus.android.uiCompose.shared.camera.j
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return CameraKt.Camera$lambda$2$6(mutableState2, onClose, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, 27696, 1);
                    PermissionsRequesterState permissionsRequesterState11116 = (PermissionsRequesterState) mutableState2.getValue();
                    String packageName113 = context113.getPackageName();
                    kotlin.jvm.internal.y.h(packageName113, "getPackageName(...)");
                    objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue6 == companion.getEmpty()) {
                        objRememberedValue6 = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.k
                            @Override // lb.a
                            public final Object invoke() {
                                return CameraKt.Camera$lambda$2$7$0(mutableState2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                    }
                    lb.a aVar11118 = (lb.a) objRememberedValue6;
                    objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue7 == companion.getEmpty()) {
                        objRememberedValue7 = new Function1() { // from class: cu.todus.android.uiCompose.shared.camera.m
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return CameraKt.Camera$lambda$2$8$0(mutableState2, (PermissionsResult) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                    }
                    Z17PermissionRequesterKt.Z17PermissionRequester(permissionsRequesterState11116, aVar11118, (Function1) objRememberedValue7, packageName113, composerStartRestartGroup, 432);
                    state = ((PermissionsRequesterState) mutableState2.getValue()).getPermissionsResult().getState();
                    if (state == null) {
                        z27 = z15;
                        j13 = j12;
                        cameraParams6 = cameraParams5;
                        z28 = z24;
                        z29 = z25;
                        z30 = z26;
                        composerStartRestartGroup.startReplaceGroup(-225953116);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-226627738);
                        Modifier modifierFillMaxSize$default113 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                        boolean zCamera$lambda$2$113 = Camera$lambda$2$1(mutableState);
                        objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue8 == companion.getEmpty()) {
                            objRememberedValue8 = new Function1() { // from class: cu.todus.android.uiCompose.shared.camera.n
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return CameraKt.Camera$lambda$2$9$0(mutableState, ((Boolean) obj).booleanValue());
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                        }
                        Function1 function113 = (Function1) objRememberedValue8;
                        int i31111111111 = i13 << 3;
                        int i31111111112 = (i13 & 112) | 6 | (i13 & 896) | (i13 & 7168) | (57344 & i13) | (458752 & i13) | (3670016 & i13) | (234881024 & i31111111111) | (i31111111111 & C.ENCODING_PCM_DOUBLE);
                        int i31111111113 = i25 << 3;
                        int i31111111114 = ((i13 >> 27) & 14) | 3072 | (i31111111113 & 112) | (i31111111113 & 896);
                        z27 = z15;
                        j13 = j12;
                        z28 = z24;
                        z29 = z25;
                        cameraParams6 = cameraParams5;
                        z30 = z26;
                        CameraPager(modifierFillMaxSize$default113, cameraParams6, z28, z27, z29, z30, j13, zCamera$lambda$2$113, sendVideos, sendImages, aVar2, onClose, onError, function113, composerStartRestartGroup, i31111111112, i31111111114, 0);
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    ua.k0 k0Var113 = ua.k0.f43947a;
                    zChanged = composerStartRestartGroup.changed(softwareKeyboardController);
                    objRememberedValue9 = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue9 = new CameraKt$Camera$3$7$1(softwareKeyboardController, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
                    } else {
                        objRememberedValue9 = new CameraKt$Camera$3$7$1(softwareKeyboardController, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
                    }
                    EffectsKt.LaunchedEffect(k0Var113, (Function2) objRememberedValue9, composerStartRestartGroup, 6);
                    composerStartRestartGroup.endNode();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    j11 = j13;
                    z20 = z30;
                    z16 = z29;
                    z19 = z27;
                    z18 = z28;
                    cameraParams3 = cameraParams6;
                    modifier3 = modifier4;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    j11 = j10;
                    cameraParams3 = cameraParams2;
                    modifier3 = modifier2;
                    z18 = z14;
                    z19 = z15;
                    z20 = z13;
                    aVar2 = aVar;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.shared.camera.o
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return CameraKt.Camera$lambda$3(modifier3, cameraParams3, z18, z19, z16, z20, j11, sendVideos, sendImages, aVar2, onClose, onError, i10, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i13 |= 805306368;
            if ((i11 & 6) == 0) {
                if (composerStartRestartGroup.changedInstance(onClose)) {
                    i27 = 4;
                } else {
                    i27 = 2;
                }
                i24 = i11 | i27;
            } else {
                i24 = i11;
            }
            if ((i11 & 48) == 0) {
                if (composerStartRestartGroup.changedInstance(onError)) {
                    i26 = 32;
                } else {
                    i26 = 16;
                }
                i24 |= i26;
            }
            i25 = i24;
            if ((i13 & 306783379) == 306783378) {
                z17 = true;
            } else {
                z17 = true;
            }
            if (composerStartRestartGroup.shouldExecute(z17, i13 & 1)) {
                if (i30 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (i31 != 0) {
                    cameraParams4 = new CameraParams(null, null, 0L, 7, null);
                } else {
                    cameraParams4 = cameraParams2;
                }
                if (i32 != 0) {
                    z21 = true;
                } else {
                    z21 = z14;
                }
                if (i14 != 0) {
                    z15 = true;
                }
                if (i16 != 0) {
                    z22 = false;
                } else {
                    z22 = z16;
                }
                if (i18 != 0) {
                    z23 = false;
                } else {
                    z23 = z13;
                }
                if (i20 != 0) {
                    j12 = Long.MAX_VALUE;
                } else {
                    j12 = j10;
                }
                if (i22 != 0) {
                    objRememberedValue10 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue10 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue10 = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.f
                            @Override // lb.a
                            public final Object invoke() {
                                return ua.k0.f43947a;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue10);
                    }
                    aVar2 = (lb.a) objRememberedValue10;
                } else {
                    aVar2 = aVar;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1559415396, i13, i25, "cu.todus.android.uiCompose.shared.camera.Camera (Camera.kt:107)");
                }
                Modifier modifierImePadding114 = WindowInsetsPadding_androidKt.imePadding(modifier4);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                companion = Composer.INSTANCE;
                if (objRememberedValue == companion.getEmpty()) {
                    objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.g
                        @Override // lb.a
                        public final Object invoke() {
                            return ua.k0.f43947a;
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                Modifier modifierM1205backgroundbw27NRU$default114 = BackgroundKt.m1205backgroundbw27NRU$default(ClickableKt.m1240clickableoSLSa3U$default(modifierImePadding114, false, null, null, null, (lb.a) objRememberedValue, 14, null), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground(), null, 2, null);
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy114 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                int iA114 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap114 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier114 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1205backgroundbw27NRU$default114);
                ComposeUiNode.Companion companion115 = ComposeUiNode.INSTANCE;
                cameraParams5 = cameraParams4;
                constructor = companion115.getConstructor();
                if (!defpackage.r.a(composerStartRestartGroup.getApplier())) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor);
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM5176constructorimpl114 = Updater.m5176constructorimpl(composerStartRestartGroup);
                z24 = z21;
                Updater.m5184setimpl(composerM5176constructorimpl114, measurePolicyMaybeCachedBoxMeasurePolicy114, companion115.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl114, currentCompositionLocalMap114, companion115.getSetResolvedCompositionLocals());
                Updater.m5180initimpl(composerM5176constructorimpl114, Integer.valueOf(iA114), companion115.getSetCompositeKeyHash());
                Updater.m5182reconcileimpl(composerM5176constructorimpl114, companion115.getApplyOnDeactivatedNodeAssertion());
                Updater.m5184setimpl(composerM5176constructorimpl114, modifierMaterializeModifier114, companion115.getSetModifier());
                BoxScopeInstance boxScopeInstance114 = BoxScopeInstance.INSTANCE;
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == companion.getEmpty()) {
                    objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                mutableState = (MutableState) objRememberedValue2;
                softwareKeyboardController = (SoftwareKeyboardController) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalSoftwareKeyboardController());
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue3 == companion.getEmpty()) {
                    objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new PermissionsRequesterState(null, false, va.w.q(PermissionNeedIt.STORAGE, PermissionNeedIt.CAMERA, PermissionNeedIt.RECORD_AUDIO), 1, null), null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                mutableState2 = (MutableState) objRememberedValue3;
                Context context114 = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                PermissionsRequesterState permissionsRequesterState11117 = (PermissionsRequesterState) mutableState2.getValue();
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue4 == companion.getEmpty()) {
                    objRememberedValue4 = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.h
                        @Override // lb.a
                        public final Object invoke() {
                            return CameraKt.Camera$lambda$2$4$0(mutableState2);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                lb.a aVar11119 = (lb.a) objRememberedValue4;
                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue5 == companion.getEmpty()) {
                    objRememberedValue5 = new Function1() { // from class: cu.todus.android.uiCompose.shared.camera.i
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return CameraKt.Camera$lambda$2$5$0(mutableState2, (PermissionsResult) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                z25 = z22;
                z26 = z23;
                Z17PermissionRequesterKt.Z17PermissionChecker(null, aVar11119, permissionsRequesterState11117, (Function1) objRememberedValue5, ComposableLambdaKt.rememberComposableLambda(930493182, true, new Function3() { // from class: cu.todus.android.uiCompose.shared.camera.j
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return CameraKt.Camera$lambda$2$6(mutableState2, onClose, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 27696, 1);
                PermissionsRequesterState permissionsRequesterState11118 = (PermissionsRequesterState) mutableState2.getValue();
                String packageName114 = context114.getPackageName();
                kotlin.jvm.internal.y.h(packageName114, "getPackageName(...)");
                objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue6 == companion.getEmpty()) {
                    objRememberedValue6 = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.k
                        @Override // lb.a
                        public final Object invoke() {
                            return CameraKt.Camera$lambda$2$7$0(mutableState2);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                }
                lb.a aVar111110 = (lb.a) objRememberedValue6;
                objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue7 == companion.getEmpty()) {
                    objRememberedValue7 = new Function1() { // from class: cu.todus.android.uiCompose.shared.camera.m
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return CameraKt.Camera$lambda$2$8$0(mutableState2, (PermissionsResult) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                }
                Z17PermissionRequesterKt.Z17PermissionRequester(permissionsRequesterState11118, aVar111110, (Function1) objRememberedValue7, packageName114, composerStartRestartGroup, 432);
                state = ((PermissionsRequesterState) mutableState2.getValue()).getPermissionsResult().getState();
                if (state == null) {
                    z27 = z15;
                    j13 = j12;
                    cameraParams6 = cameraParams5;
                    z28 = z24;
                    z29 = z25;
                    z30 = z26;
                    composerStartRestartGroup.startReplaceGroup(-225953116);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(-226627738);
                    Modifier modifierFillMaxSize$default114 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                    boolean zCamera$lambda$2$114 = Camera$lambda$2$1(mutableState);
                    objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue8 == companion.getEmpty()) {
                        objRememberedValue8 = new Function1() { // from class: cu.todus.android.uiCompose.shared.camera.n
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return CameraKt.Camera$lambda$2$9$0(mutableState, ((Boolean) obj).booleanValue());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                    }
                    Function1 function114 = (Function1) objRememberedValue8;
                    int i31111111115 = i13 << 3;
                    int i31111111116 = (i13 & 112) | 6 | (i13 & 896) | (i13 & 7168) | (57344 & i13) | (458752 & i13) | (3670016 & i13) | (234881024 & i31111111115) | (i31111111115 & C.ENCODING_PCM_DOUBLE);
                    int i31111111117 = i25 << 3;
                    int i31111111118 = ((i13 >> 27) & 14) | 3072 | (i31111111117 & 112) | (i31111111117 & 896);
                    z27 = z15;
                    j13 = j12;
                    z28 = z24;
                    z29 = z25;
                    cameraParams6 = cameraParams5;
                    z30 = z26;
                    CameraPager(modifierFillMaxSize$default114, cameraParams6, z28, z27, z29, z30, j13, zCamera$lambda$2$114, sendVideos, sendImages, aVar2, onClose, onError, function114, composerStartRestartGroup, i31111111116, i31111111118, 0);
                    composerStartRestartGroup.endReplaceGroup();
                }
                ua.k0 k0Var114 = ua.k0.f43947a;
                zChanged = composerStartRestartGroup.changed(softwareKeyboardController);
                objRememberedValue9 = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    objRememberedValue9 = new CameraKt$Camera$3$7$1(softwareKeyboardController, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
                } else {
                    objRememberedValue9 = new CameraKt$Camera$3$7$1(softwareKeyboardController, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
                }
                EffectsKt.LaunchedEffect(k0Var114, (Function2) objRememberedValue9, composerStartRestartGroup, 6);
                composerStartRestartGroup.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                j11 = j13;
                z20 = z30;
                z16 = z29;
                z19 = z27;
                z18 = z28;
                cameraParams3 = cameraParams6;
                modifier3 = modifier4;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                j11 = j10;
                cameraParams3 = cameraParams2;
                modifier3 = modifier2;
                z18 = z14;
                z19 = z15;
                z20 = z13;
                aVar2 = aVar;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.shared.camera.o
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return CameraKt.Camera$lambda$3(modifier3, cameraParams3, z18, z19, z16, z20, j11, sendVideos, sendImages, aVar2, onClose, onError, i10, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i13 |= 3072;
        z15 = z11;
        i16 = i12 & 16;
        if (i16 != 0) {
            if ((i10 & 24576) == 0) {
                z16 = z12;
                if (composerStartRestartGroup.changed(z16)) {
                    i17 = 16384;
                } else {
                    i17 = 8192;
                }
                i13 |= i17;
            }
            i18 = i12 & 32;
            if (i18 != 0) {
                i13 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            } else if ((i10 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                if (composerStartRestartGroup.changed(z13)) {
                    i19 = 131072;
                } else {
                    i19 = 65536;
                }
                i13 |= i19;
            }
            i20 = i12 & 64;
            if (i20 != 0) {
                if ((i10 & 1572864) == 0) {
                    if (composerStartRestartGroup.changed(j10)) {
                        i21 = 1048576;
                    } else {
                        i21 = 524288;
                    }
                    i13 |= i21;
                }
                if ((i10 & 12582912) == 0) {
                    if (composerStartRestartGroup.changedInstance(sendVideos)) {
                        i29 = 8388608;
                    } else {
                        i29 = 4194304;
                    }
                    i13 |= i29;
                }
                if ((i10 & 100663296) == 0) {
                    if (composerStartRestartGroup.changedInstance(sendImages)) {
                        i28 = 67108864;
                    } else {
                        i28 = 33554432;
                    }
                    i13 |= i28;
                }
                i22 = i12 & 512;
                if (i22 != 0) {
                    if ((i10 & 805306368) == 0) {
                        if (composerStartRestartGroup.changedInstance(aVar)) {
                            i23 = C.BUFFER_FLAG_LAST_SAMPLE;
                        } else {
                            i23 = 268435456;
                        }
                        i13 |= i23;
                    }
                    if ((i11 & 6) == 0) {
                        if (composerStartRestartGroup.changedInstance(onClose)) {
                            i27 = 4;
                        } else {
                            i27 = 2;
                        }
                        i24 = i11 | i27;
                    } else {
                        i24 = i11;
                    }
                    if ((i11 & 48) == 0) {
                        if (composerStartRestartGroup.changedInstance(onError)) {
                            i26 = 32;
                        } else {
                            i26 = 16;
                        }
                        i24 |= i26;
                    }
                    i25 = i24;
                    if ((i13 & 306783379) == 306783378) {
                        z17 = true;
                    } else {
                        z17 = true;
                    }
                    if (composerStartRestartGroup.shouldExecute(z17, i13 & 1)) {
                        if (i30 != 0) {
                            modifier4 = Modifier.INSTANCE;
                        } else {
                            modifier4 = modifier2;
                        }
                        if (i31 != 0) {
                            cameraParams4 = new CameraParams(null, null, 0L, 7, null);
                        } else {
                            cameraParams4 = cameraParams2;
                        }
                        if (i32 != 0) {
                            z21 = true;
                        } else {
                            z21 = z14;
                        }
                        if (i14 != 0) {
                            z15 = true;
                        }
                        if (i16 != 0) {
                            z22 = false;
                        } else {
                            z22 = z16;
                        }
                        if (i18 != 0) {
                            z23 = false;
                        } else {
                            z23 = z13;
                        }
                        if (i20 != 0) {
                            j12 = Long.MAX_VALUE;
                        } else {
                            j12 = j10;
                        }
                        if (i22 != 0) {
                            objRememberedValue10 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue10 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue10 = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.f
                                    @Override // lb.a
                                    public final Object invoke() {
                                        return ua.k0.f43947a;
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue10);
                            }
                            aVar2 = (lb.a) objRememberedValue10;
                        } else {
                            aVar2 = aVar;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1559415396, i13, i25, "cu.todus.android.uiCompose.shared.camera.Camera (Camera.kt:107)");
                        }
                        Modifier modifierImePadding115 = WindowInsetsPadding_androidKt.imePadding(modifier4);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        companion = Composer.INSTANCE;
                        if (objRememberedValue == companion.getEmpty()) {
                            objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.g
                                @Override // lb.a
                                public final Object invoke() {
                                    return ua.k0.f43947a;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        Modifier modifierM1205backgroundbw27NRU$default115 = BackgroundKt.m1205backgroundbw27NRU$default(ClickableKt.m1240clickableoSLSa3U$default(modifierImePadding115, false, null, null, null, (lb.a) objRememberedValue, 14, null), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground(), null, 2, null);
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy115 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                        int iA115 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap115 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier115 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1205backgroundbw27NRU$default115);
                        ComposeUiNode.Companion companion116 = ComposeUiNode.INSTANCE;
                        cameraParams5 = cameraParams4;
                        constructor = companion116.getConstructor();
                        if (!defpackage.r.a(composerStartRestartGroup.getApplier())) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(constructor);
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        Composer composerM5176constructorimpl115 = Updater.m5176constructorimpl(composerStartRestartGroup);
                        z24 = z21;
                        Updater.m5184setimpl(composerM5176constructorimpl115, measurePolicyMaybeCachedBoxMeasurePolicy115, companion116.getSetMeasurePolicy());
                        Updater.m5184setimpl(composerM5176constructorimpl115, currentCompositionLocalMap115, companion116.getSetResolvedCompositionLocals());
                        Updater.m5180initimpl(composerM5176constructorimpl115, Integer.valueOf(iA115), companion116.getSetCompositeKeyHash());
                        Updater.m5182reconcileimpl(composerM5176constructorimpl115, companion116.getApplyOnDeactivatedNodeAssertion());
                        Updater.m5184setimpl(composerM5176constructorimpl115, modifierMaterializeModifier115, companion116.getSetModifier());
                        BoxScopeInstance boxScopeInstance115 = BoxScopeInstance.INSTANCE;
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == companion.getEmpty()) {
                            objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        mutableState = (MutableState) objRememberedValue2;
                        softwareKeyboardController = (SoftwareKeyboardController) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalSoftwareKeyboardController());
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue3 == companion.getEmpty()) {
                            objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new PermissionsRequesterState(null, false, va.w.q(PermissionNeedIt.STORAGE, PermissionNeedIt.CAMERA, PermissionNeedIt.RECORD_AUDIO), 1, null), null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        mutableState2 = (MutableState) objRememberedValue3;
                        Context context115 = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                        PermissionsRequesterState permissionsRequesterState11119 = (PermissionsRequesterState) mutableState2.getValue();
                        objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue4 == companion.getEmpty()) {
                            objRememberedValue4 = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.h
                                @Override // lb.a
                                public final Object invoke() {
                                    return CameraKt.Camera$lambda$2$4$0(mutableState2);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        }
                        lb.a aVar111111 = (lb.a) objRememberedValue4;
                        objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue5 == companion.getEmpty()) {
                            objRememberedValue5 = new Function1() { // from class: cu.todus.android.uiCompose.shared.camera.i
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return CameraKt.Camera$lambda$2$5$0(mutableState2, (PermissionsResult) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                        }
                        z25 = z22;
                        z26 = z23;
                        Z17PermissionRequesterKt.Z17PermissionChecker(null, aVar111111, permissionsRequesterState11119, (Function1) objRememberedValue5, ComposableLambdaKt.rememberComposableLambda(930493182, true, new Function3() { // from class: cu.todus.android.uiCompose.shared.camera.j
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return CameraKt.Camera$lambda$2$6(mutableState2, onClose, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, 27696, 1);
                        PermissionsRequesterState permissionsRequesterState111110 = (PermissionsRequesterState) mutableState2.getValue();
                        String packageName115 = context115.getPackageName();
                        kotlin.jvm.internal.y.h(packageName115, "getPackageName(...)");
                        objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue6 == companion.getEmpty()) {
                            objRememberedValue6 = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.k
                                @Override // lb.a
                                public final Object invoke() {
                                    return CameraKt.Camera$lambda$2$7$0(mutableState2);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                        }
                        lb.a aVar111112 = (lb.a) objRememberedValue6;
                        objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue7 == companion.getEmpty()) {
                            objRememberedValue7 = new Function1() { // from class: cu.todus.android.uiCompose.shared.camera.m
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return CameraKt.Camera$lambda$2$8$0(mutableState2, (PermissionsResult) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                        }
                        Z17PermissionRequesterKt.Z17PermissionRequester(permissionsRequesterState111110, aVar111112, (Function1) objRememberedValue7, packageName115, composerStartRestartGroup, 432);
                        state = ((PermissionsRequesterState) mutableState2.getValue()).getPermissionsResult().getState();
                        if (state == null) {
                            z27 = z15;
                            j13 = j12;
                            cameraParams6 = cameraParams5;
                            z28 = z24;
                            z29 = z25;
                            z30 = z26;
                            composerStartRestartGroup.startReplaceGroup(-225953116);
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(-226627738);
                            Modifier modifierFillMaxSize$default115 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                            boolean zCamera$lambda$2$115 = Camera$lambda$2$1(mutableState);
                            objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue8 == companion.getEmpty()) {
                                objRememberedValue8 = new Function1() { // from class: cu.todus.android.uiCompose.shared.camera.n
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return CameraKt.Camera$lambda$2$9$0(mutableState, ((Boolean) obj).booleanValue());
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                            }
                            Function1 function115 = (Function1) objRememberedValue8;
                            int i31111111119 = i13 << 3;
                            int i311111111110 = (i13 & 112) | 6 | (i13 & 896) | (i13 & 7168) | (57344 & i13) | (458752 & i13) | (3670016 & i13) | (234881024 & i31111111119) | (i31111111119 & C.ENCODING_PCM_DOUBLE);
                            int i311111111111 = i25 << 3;
                            int i311111111112 = ((i13 >> 27) & 14) | 3072 | (i311111111111 & 112) | (i311111111111 & 896);
                            z27 = z15;
                            j13 = j12;
                            z28 = z24;
                            z29 = z25;
                            cameraParams6 = cameraParams5;
                            z30 = z26;
                            CameraPager(modifierFillMaxSize$default115, cameraParams6, z28, z27, z29, z30, j13, zCamera$lambda$2$115, sendVideos, sendImages, aVar2, onClose, onError, function115, composerStartRestartGroup, i311111111110, i311111111112, 0);
                            composerStartRestartGroup.endReplaceGroup();
                        }
                        ua.k0 k0Var115 = ua.k0.f43947a;
                        zChanged = composerStartRestartGroup.changed(softwareKeyboardController);
                        objRememberedValue9 = composerStartRestartGroup.rememberedValue();
                        if (zChanged) {
                            objRememberedValue9 = new CameraKt$Camera$3$7$1(softwareKeyboardController, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
                        } else {
                            objRememberedValue9 = new CameraKt$Camera$3$7$1(softwareKeyboardController, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
                        }
                        EffectsKt.LaunchedEffect(k0Var115, (Function2) objRememberedValue9, composerStartRestartGroup, 6);
                        composerStartRestartGroup.endNode();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        j11 = j13;
                        z20 = z30;
                        z16 = z29;
                        z19 = z27;
                        z18 = z28;
                        cameraParams3 = cameraParams6;
                        modifier3 = modifier4;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        j11 = j10;
                        cameraParams3 = cameraParams2;
                        modifier3 = modifier2;
                        z18 = z14;
                        z19 = z15;
                        z20 = z13;
                        aVar2 = aVar;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.shared.camera.o
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return CameraKt.Camera$lambda$3(modifier3, cameraParams3, z18, z19, z16, z20, j11, sendVideos, sendImages, aVar2, onClose, onError, i10, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i13 |= 805306368;
                if ((i11 & 6) == 0) {
                    if (composerStartRestartGroup.changedInstance(onClose)) {
                        i27 = 4;
                    } else {
                        i27 = 2;
                    }
                    i24 = i11 | i27;
                } else {
                    i24 = i11;
                }
                if ((i11 & 48) == 0) {
                    if (composerStartRestartGroup.changedInstance(onError)) {
                        i26 = 32;
                    } else {
                        i26 = 16;
                    }
                    i24 |= i26;
                }
                i25 = i24;
                if ((i13 & 306783379) == 306783378) {
                    z17 = true;
                } else {
                    z17 = true;
                }
                if (composerStartRestartGroup.shouldExecute(z17, i13 & 1)) {
                    if (i30 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i31 != 0) {
                        cameraParams4 = new CameraParams(null, null, 0L, 7, null);
                    } else {
                        cameraParams4 = cameraParams2;
                    }
                    if (i32 != 0) {
                        z21 = true;
                    } else {
                        z21 = z14;
                    }
                    if (i14 != 0) {
                        z15 = true;
                    }
                    if (i16 != 0) {
                        z22 = false;
                    } else {
                        z22 = z16;
                    }
                    if (i18 != 0) {
                        z23 = false;
                    } else {
                        z23 = z13;
                    }
                    if (i20 != 0) {
                        j12 = Long.MAX_VALUE;
                    } else {
                        j12 = j10;
                    }
                    if (i22 != 0) {
                        objRememberedValue10 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue10 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue10 = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.f
                                @Override // lb.a
                                public final Object invoke() {
                                    return ua.k0.f43947a;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue10);
                        }
                        aVar2 = (lb.a) objRememberedValue10;
                    } else {
                        aVar2 = aVar;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1559415396, i13, i25, "cu.todus.android.uiCompose.shared.camera.Camera (Camera.kt:107)");
                    }
                    Modifier modifierImePadding116 = WindowInsetsPadding_androidKt.imePadding(modifier4);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    companion = Composer.INSTANCE;
                    if (objRememberedValue == companion.getEmpty()) {
                        objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.g
                            @Override // lb.a
                            public final Object invoke() {
                                return ua.k0.f43947a;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    Modifier modifierM1205backgroundbw27NRU$default116 = BackgroundKt.m1205backgroundbw27NRU$default(ClickableKt.m1240clickableoSLSa3U$default(modifierImePadding116, false, null, null, null, (lb.a) objRememberedValue, 14, null), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground(), null, 2, null);
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy116 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                    int iA116 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap116 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier116 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1205backgroundbw27NRU$default116);
                    ComposeUiNode.Companion companion117 = ComposeUiNode.INSTANCE;
                    cameraParams5 = cameraParams4;
                    constructor = companion117.getConstructor();
                    if (!defpackage.r.a(composerStartRestartGroup.getApplier())) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM5176constructorimpl116 = Updater.m5176constructorimpl(composerStartRestartGroup);
                    z24 = z21;
                    Updater.m5184setimpl(composerM5176constructorimpl116, measurePolicyMaybeCachedBoxMeasurePolicy116, companion117.getSetMeasurePolicy());
                    Updater.m5184setimpl(composerM5176constructorimpl116, currentCompositionLocalMap116, companion117.getSetResolvedCompositionLocals());
                    Updater.m5180initimpl(composerM5176constructorimpl116, Integer.valueOf(iA116), companion117.getSetCompositeKeyHash());
                    Updater.m5182reconcileimpl(composerM5176constructorimpl116, companion117.getApplyOnDeactivatedNodeAssertion());
                    Updater.m5184setimpl(composerM5176constructorimpl116, modifierMaterializeModifier116, companion117.getSetModifier());
                    BoxScopeInstance boxScopeInstance116 = BoxScopeInstance.INSTANCE;
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == companion.getEmpty()) {
                        objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    mutableState = (MutableState) objRememberedValue2;
                    softwareKeyboardController = (SoftwareKeyboardController) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalSoftwareKeyboardController());
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue3 == companion.getEmpty()) {
                        objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new PermissionsRequesterState(null, false, va.w.q(PermissionNeedIt.STORAGE, PermissionNeedIt.CAMERA, PermissionNeedIt.RECORD_AUDIO), 1, null), null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    mutableState2 = (MutableState) objRememberedValue3;
                    Context context116 = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                    PermissionsRequesterState permissionsRequesterState111111 = (PermissionsRequesterState) mutableState2.getValue();
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue4 == companion.getEmpty()) {
                        objRememberedValue4 = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.h
                            @Override // lb.a
                            public final Object invoke() {
                                return CameraKt.Camera$lambda$2$4$0(mutableState2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    lb.a aVar111113 = (lb.a) objRememberedValue4;
                    objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue5 == companion.getEmpty()) {
                        objRememberedValue5 = new Function1() { // from class: cu.todus.android.uiCompose.shared.camera.i
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return CameraKt.Camera$lambda$2$5$0(mutableState2, (PermissionsResult) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    }
                    z25 = z22;
                    z26 = z23;
                    Z17PermissionRequesterKt.Z17PermissionChecker(null, aVar111113, permissionsRequesterState111111, (Function1) objRememberedValue5, ComposableLambdaKt.rememberComposableLambda(930493182, true, new Function3() { // from class: cu.todus.android.uiCompose.shared.camera.j
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return CameraKt.Camera$lambda$2$6(mutableState2, onClose, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, 27696, 1);
                    PermissionsRequesterState permissionsRequesterState111112 = (PermissionsRequesterState) mutableState2.getValue();
                    String packageName116 = context116.getPackageName();
                    kotlin.jvm.internal.y.h(packageName116, "getPackageName(...)");
                    objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue6 == companion.getEmpty()) {
                        objRememberedValue6 = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.k
                            @Override // lb.a
                            public final Object invoke() {
                                return CameraKt.Camera$lambda$2$7$0(mutableState2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                    }
                    lb.a aVar111114 = (lb.a) objRememberedValue6;
                    objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue7 == companion.getEmpty()) {
                        objRememberedValue7 = new Function1() { // from class: cu.todus.android.uiCompose.shared.camera.m
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return CameraKt.Camera$lambda$2$8$0(mutableState2, (PermissionsResult) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                    }
                    Z17PermissionRequesterKt.Z17PermissionRequester(permissionsRequesterState111112, aVar111114, (Function1) objRememberedValue7, packageName116, composerStartRestartGroup, 432);
                    state = ((PermissionsRequesterState) mutableState2.getValue()).getPermissionsResult().getState();
                    if (state == null) {
                        z27 = z15;
                        j13 = j12;
                        cameraParams6 = cameraParams5;
                        z28 = z24;
                        z29 = z25;
                        z30 = z26;
                        composerStartRestartGroup.startReplaceGroup(-225953116);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-226627738);
                        Modifier modifierFillMaxSize$default116 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                        boolean zCamera$lambda$2$116 = Camera$lambda$2$1(mutableState);
                        objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue8 == companion.getEmpty()) {
                            objRememberedValue8 = new Function1() { // from class: cu.todus.android.uiCompose.shared.camera.n
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return CameraKt.Camera$lambda$2$9$0(mutableState, ((Boolean) obj).booleanValue());
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                        }
                        Function1 function116 = (Function1) objRememberedValue8;
                        int i311111111113 = i13 << 3;
                        int i311111111114 = (i13 & 112) | 6 | (i13 & 896) | (i13 & 7168) | (57344 & i13) | (458752 & i13) | (3670016 & i13) | (234881024 & i311111111113) | (i311111111113 & C.ENCODING_PCM_DOUBLE);
                        int i311111111115 = i25 << 3;
                        int i311111111116 = ((i13 >> 27) & 14) | 3072 | (i311111111115 & 112) | (i311111111115 & 896);
                        z27 = z15;
                        j13 = j12;
                        z28 = z24;
                        z29 = z25;
                        cameraParams6 = cameraParams5;
                        z30 = z26;
                        CameraPager(modifierFillMaxSize$default116, cameraParams6, z28, z27, z29, z30, j13, zCamera$lambda$2$116, sendVideos, sendImages, aVar2, onClose, onError, function116, composerStartRestartGroup, i311111111114, i311111111116, 0);
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    ua.k0 k0Var116 = ua.k0.f43947a;
                    zChanged = composerStartRestartGroup.changed(softwareKeyboardController);
                    objRememberedValue9 = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue9 = new CameraKt$Camera$3$7$1(softwareKeyboardController, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
                    } else {
                        objRememberedValue9 = new CameraKt$Camera$3$7$1(softwareKeyboardController, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
                    }
                    EffectsKt.LaunchedEffect(k0Var116, (Function2) objRememberedValue9, composerStartRestartGroup, 6);
                    composerStartRestartGroup.endNode();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    j11 = j13;
                    z20 = z30;
                    z16 = z29;
                    z19 = z27;
                    z18 = z28;
                    cameraParams3 = cameraParams6;
                    modifier3 = modifier4;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    j11 = j10;
                    cameraParams3 = cameraParams2;
                    modifier3 = modifier2;
                    z18 = z14;
                    z19 = z15;
                    z20 = z13;
                    aVar2 = aVar;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.shared.camera.o
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return CameraKt.Camera$lambda$3(modifier3, cameraParams3, z18, z19, z16, z20, j11, sendVideos, sendImages, aVar2, onClose, onError, i10, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i13 |= 1572864;
            if ((i10 & 12582912) == 0) {
                if (composerStartRestartGroup.changedInstance(sendVideos)) {
                    i29 = 8388608;
                } else {
                    i29 = 4194304;
                }
                i13 |= i29;
            }
            if ((i10 & 100663296) == 0) {
                if (composerStartRestartGroup.changedInstance(sendImages)) {
                    i28 = 67108864;
                } else {
                    i28 = 33554432;
                }
                i13 |= i28;
            }
            i22 = i12 & 512;
            if (i22 != 0) {
                if ((i10 & 805306368) == 0) {
                    if (composerStartRestartGroup.changedInstance(aVar)) {
                        i23 = C.BUFFER_FLAG_LAST_SAMPLE;
                    } else {
                        i23 = 268435456;
                    }
                    i13 |= i23;
                }
                if ((i11 & 6) == 0) {
                    if (composerStartRestartGroup.changedInstance(onClose)) {
                        i27 = 4;
                    } else {
                        i27 = 2;
                    }
                    i24 = i11 | i27;
                } else {
                    i24 = i11;
                }
                if ((i11 & 48) == 0) {
                    if (composerStartRestartGroup.changedInstance(onError)) {
                        i26 = 32;
                    } else {
                        i26 = 16;
                    }
                    i24 |= i26;
                }
                i25 = i24;
                if ((i13 & 306783379) == 306783378) {
                    z17 = true;
                } else {
                    z17 = true;
                }
                if (composerStartRestartGroup.shouldExecute(z17, i13 & 1)) {
                    if (i30 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i31 != 0) {
                        cameraParams4 = new CameraParams(null, null, 0L, 7, null);
                    } else {
                        cameraParams4 = cameraParams2;
                    }
                    if (i32 != 0) {
                        z21 = true;
                    } else {
                        z21 = z14;
                    }
                    if (i14 != 0) {
                        z15 = true;
                    }
                    if (i16 != 0) {
                        z22 = false;
                    } else {
                        z22 = z16;
                    }
                    if (i18 != 0) {
                        z23 = false;
                    } else {
                        z23 = z13;
                    }
                    if (i20 != 0) {
                        j12 = Long.MAX_VALUE;
                    } else {
                        j12 = j10;
                    }
                    if (i22 != 0) {
                        objRememberedValue10 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue10 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue10 = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.f
                                @Override // lb.a
                                public final Object invoke() {
                                    return ua.k0.f43947a;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue10);
                        }
                        aVar2 = (lb.a) objRememberedValue10;
                    } else {
                        aVar2 = aVar;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1559415396, i13, i25, "cu.todus.android.uiCompose.shared.camera.Camera (Camera.kt:107)");
                    }
                    Modifier modifierImePadding117 = WindowInsetsPadding_androidKt.imePadding(modifier4);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    companion = Composer.INSTANCE;
                    if (objRememberedValue == companion.getEmpty()) {
                        objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.g
                            @Override // lb.a
                            public final Object invoke() {
                                return ua.k0.f43947a;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    Modifier modifierM1205backgroundbw27NRU$default117 = BackgroundKt.m1205backgroundbw27NRU$default(ClickableKt.m1240clickableoSLSa3U$default(modifierImePadding117, false, null, null, null, (lb.a) objRememberedValue, 14, null), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground(), null, 2, null);
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy117 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                    int iA117 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap117 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier117 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1205backgroundbw27NRU$default117);
                    ComposeUiNode.Companion companion118 = ComposeUiNode.INSTANCE;
                    cameraParams5 = cameraParams4;
                    constructor = companion118.getConstructor();
                    if (!defpackage.r.a(composerStartRestartGroup.getApplier())) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM5176constructorimpl117 = Updater.m5176constructorimpl(composerStartRestartGroup);
                    z24 = z21;
                    Updater.m5184setimpl(composerM5176constructorimpl117, measurePolicyMaybeCachedBoxMeasurePolicy117, companion118.getSetMeasurePolicy());
                    Updater.m5184setimpl(composerM5176constructorimpl117, currentCompositionLocalMap117, companion118.getSetResolvedCompositionLocals());
                    Updater.m5180initimpl(composerM5176constructorimpl117, Integer.valueOf(iA117), companion118.getSetCompositeKeyHash());
                    Updater.m5182reconcileimpl(composerM5176constructorimpl117, companion118.getApplyOnDeactivatedNodeAssertion());
                    Updater.m5184setimpl(composerM5176constructorimpl117, modifierMaterializeModifier117, companion118.getSetModifier());
                    BoxScopeInstance boxScopeInstance117 = BoxScopeInstance.INSTANCE;
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == companion.getEmpty()) {
                        objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    mutableState = (MutableState) objRememberedValue2;
                    softwareKeyboardController = (SoftwareKeyboardController) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalSoftwareKeyboardController());
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue3 == companion.getEmpty()) {
                        objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new PermissionsRequesterState(null, false, va.w.q(PermissionNeedIt.STORAGE, PermissionNeedIt.CAMERA, PermissionNeedIt.RECORD_AUDIO), 1, null), null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    mutableState2 = (MutableState) objRememberedValue3;
                    Context context117 = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                    PermissionsRequesterState permissionsRequesterState111113 = (PermissionsRequesterState) mutableState2.getValue();
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue4 == companion.getEmpty()) {
                        objRememberedValue4 = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.h
                            @Override // lb.a
                            public final Object invoke() {
                                return CameraKt.Camera$lambda$2$4$0(mutableState2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    lb.a aVar111115 = (lb.a) objRememberedValue4;
                    objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue5 == companion.getEmpty()) {
                        objRememberedValue5 = new Function1() { // from class: cu.todus.android.uiCompose.shared.camera.i
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return CameraKt.Camera$lambda$2$5$0(mutableState2, (PermissionsResult) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    }
                    z25 = z22;
                    z26 = z23;
                    Z17PermissionRequesterKt.Z17PermissionChecker(null, aVar111115, permissionsRequesterState111113, (Function1) objRememberedValue5, ComposableLambdaKt.rememberComposableLambda(930493182, true, new Function3() { // from class: cu.todus.android.uiCompose.shared.camera.j
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return CameraKt.Camera$lambda$2$6(mutableState2, onClose, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, 27696, 1);
                    PermissionsRequesterState permissionsRequesterState111114 = (PermissionsRequesterState) mutableState2.getValue();
                    String packageName117 = context117.getPackageName();
                    kotlin.jvm.internal.y.h(packageName117, "getPackageName(...)");
                    objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue6 == companion.getEmpty()) {
                        objRememberedValue6 = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.k
                            @Override // lb.a
                            public final Object invoke() {
                                return CameraKt.Camera$lambda$2$7$0(mutableState2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                    }
                    lb.a aVar111116 = (lb.a) objRememberedValue6;
                    objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue7 == companion.getEmpty()) {
                        objRememberedValue7 = new Function1() { // from class: cu.todus.android.uiCompose.shared.camera.m
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return CameraKt.Camera$lambda$2$8$0(mutableState2, (PermissionsResult) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                    }
                    Z17PermissionRequesterKt.Z17PermissionRequester(permissionsRequesterState111114, aVar111116, (Function1) objRememberedValue7, packageName117, composerStartRestartGroup, 432);
                    state = ((PermissionsRequesterState) mutableState2.getValue()).getPermissionsResult().getState();
                    if (state == null) {
                        z27 = z15;
                        j13 = j12;
                        cameraParams6 = cameraParams5;
                        z28 = z24;
                        z29 = z25;
                        z30 = z26;
                        composerStartRestartGroup.startReplaceGroup(-225953116);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-226627738);
                        Modifier modifierFillMaxSize$default117 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                        boolean zCamera$lambda$2$117 = Camera$lambda$2$1(mutableState);
                        objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue8 == companion.getEmpty()) {
                            objRememberedValue8 = new Function1() { // from class: cu.todus.android.uiCompose.shared.camera.n
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return CameraKt.Camera$lambda$2$9$0(mutableState, ((Boolean) obj).booleanValue());
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                        }
                        Function1 function117 = (Function1) objRememberedValue8;
                        int i311111111117 = i13 << 3;
                        int i311111111118 = (i13 & 112) | 6 | (i13 & 896) | (i13 & 7168) | (57344 & i13) | (458752 & i13) | (3670016 & i13) | (234881024 & i311111111117) | (i311111111117 & C.ENCODING_PCM_DOUBLE);
                        int i311111111119 = i25 << 3;
                        int i3111111111110 = ((i13 >> 27) & 14) | 3072 | (i311111111119 & 112) | (i311111111119 & 896);
                        z27 = z15;
                        j13 = j12;
                        z28 = z24;
                        z29 = z25;
                        cameraParams6 = cameraParams5;
                        z30 = z26;
                        CameraPager(modifierFillMaxSize$default117, cameraParams6, z28, z27, z29, z30, j13, zCamera$lambda$2$117, sendVideos, sendImages, aVar2, onClose, onError, function117, composerStartRestartGroup, i311111111118, i3111111111110, 0);
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    ua.k0 k0Var117 = ua.k0.f43947a;
                    zChanged = composerStartRestartGroup.changed(softwareKeyboardController);
                    objRememberedValue9 = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue9 = new CameraKt$Camera$3$7$1(softwareKeyboardController, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
                    } else {
                        objRememberedValue9 = new CameraKt$Camera$3$7$1(softwareKeyboardController, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
                    }
                    EffectsKt.LaunchedEffect(k0Var117, (Function2) objRememberedValue9, composerStartRestartGroup, 6);
                    composerStartRestartGroup.endNode();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    j11 = j13;
                    z20 = z30;
                    z16 = z29;
                    z19 = z27;
                    z18 = z28;
                    cameraParams3 = cameraParams6;
                    modifier3 = modifier4;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    j11 = j10;
                    cameraParams3 = cameraParams2;
                    modifier3 = modifier2;
                    z18 = z14;
                    z19 = z15;
                    z20 = z13;
                    aVar2 = aVar;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.shared.camera.o
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return CameraKt.Camera$lambda$3(modifier3, cameraParams3, z18, z19, z16, z20, j11, sendVideos, sendImages, aVar2, onClose, onError, i10, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i13 |= 805306368;
            if ((i11 & 6) == 0) {
                if (composerStartRestartGroup.changedInstance(onClose)) {
                    i27 = 4;
                } else {
                    i27 = 2;
                }
                i24 = i11 | i27;
            } else {
                i24 = i11;
            }
            if ((i11 & 48) == 0) {
                if (composerStartRestartGroup.changedInstance(onError)) {
                    i26 = 32;
                } else {
                    i26 = 16;
                }
                i24 |= i26;
            }
            i25 = i24;
            if ((i13 & 306783379) == 306783378) {
                z17 = true;
            } else {
                z17 = true;
            }
            if (composerStartRestartGroup.shouldExecute(z17, i13 & 1)) {
                if (i30 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (i31 != 0) {
                    cameraParams4 = new CameraParams(null, null, 0L, 7, null);
                } else {
                    cameraParams4 = cameraParams2;
                }
                if (i32 != 0) {
                    z21 = true;
                } else {
                    z21 = z14;
                }
                if (i14 != 0) {
                    z15 = true;
                }
                if (i16 != 0) {
                    z22 = false;
                } else {
                    z22 = z16;
                }
                if (i18 != 0) {
                    z23 = false;
                } else {
                    z23 = z13;
                }
                if (i20 != 0) {
                    j12 = Long.MAX_VALUE;
                } else {
                    j12 = j10;
                }
                if (i22 != 0) {
                    objRememberedValue10 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue10 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue10 = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.f
                            @Override // lb.a
                            public final Object invoke() {
                                return ua.k0.f43947a;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue10);
                    }
                    aVar2 = (lb.a) objRememberedValue10;
                } else {
                    aVar2 = aVar;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1559415396, i13, i25, "cu.todus.android.uiCompose.shared.camera.Camera (Camera.kt:107)");
                }
                Modifier modifierImePadding118 = WindowInsetsPadding_androidKt.imePadding(modifier4);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                companion = Composer.INSTANCE;
                if (objRememberedValue == companion.getEmpty()) {
                    objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.g
                        @Override // lb.a
                        public final Object invoke() {
                            return ua.k0.f43947a;
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                Modifier modifierM1205backgroundbw27NRU$default118 = BackgroundKt.m1205backgroundbw27NRU$default(ClickableKt.m1240clickableoSLSa3U$default(modifierImePadding118, false, null, null, null, (lb.a) objRememberedValue, 14, null), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground(), null, 2, null);
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy118 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                int iA118 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap118 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier118 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1205backgroundbw27NRU$default118);
                ComposeUiNode.Companion companion119 = ComposeUiNode.INSTANCE;
                cameraParams5 = cameraParams4;
                constructor = companion119.getConstructor();
                if (!defpackage.r.a(composerStartRestartGroup.getApplier())) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor);
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM5176constructorimpl118 = Updater.m5176constructorimpl(composerStartRestartGroup);
                z24 = z21;
                Updater.m5184setimpl(composerM5176constructorimpl118, measurePolicyMaybeCachedBoxMeasurePolicy118, companion119.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl118, currentCompositionLocalMap118, companion119.getSetResolvedCompositionLocals());
                Updater.m5180initimpl(composerM5176constructorimpl118, Integer.valueOf(iA118), companion119.getSetCompositeKeyHash());
                Updater.m5182reconcileimpl(composerM5176constructorimpl118, companion119.getApplyOnDeactivatedNodeAssertion());
                Updater.m5184setimpl(composerM5176constructorimpl118, modifierMaterializeModifier118, companion119.getSetModifier());
                BoxScopeInstance boxScopeInstance118 = BoxScopeInstance.INSTANCE;
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == companion.getEmpty()) {
                    objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                mutableState = (MutableState) objRememberedValue2;
                softwareKeyboardController = (SoftwareKeyboardController) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalSoftwareKeyboardController());
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue3 == companion.getEmpty()) {
                    objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new PermissionsRequesterState(null, false, va.w.q(PermissionNeedIt.STORAGE, PermissionNeedIt.CAMERA, PermissionNeedIt.RECORD_AUDIO), 1, null), null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                mutableState2 = (MutableState) objRememberedValue3;
                Context context118 = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                PermissionsRequesterState permissionsRequesterState111115 = (PermissionsRequesterState) mutableState2.getValue();
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue4 == companion.getEmpty()) {
                    objRememberedValue4 = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.h
                        @Override // lb.a
                        public final Object invoke() {
                            return CameraKt.Camera$lambda$2$4$0(mutableState2);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                lb.a aVar111117 = (lb.a) objRememberedValue4;
                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue5 == companion.getEmpty()) {
                    objRememberedValue5 = new Function1() { // from class: cu.todus.android.uiCompose.shared.camera.i
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return CameraKt.Camera$lambda$2$5$0(mutableState2, (PermissionsResult) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                z25 = z22;
                z26 = z23;
                Z17PermissionRequesterKt.Z17PermissionChecker(null, aVar111117, permissionsRequesterState111115, (Function1) objRememberedValue5, ComposableLambdaKt.rememberComposableLambda(930493182, true, new Function3() { // from class: cu.todus.android.uiCompose.shared.camera.j
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return CameraKt.Camera$lambda$2$6(mutableState2, onClose, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 27696, 1);
                PermissionsRequesterState permissionsRequesterState111116 = (PermissionsRequesterState) mutableState2.getValue();
                String packageName118 = context118.getPackageName();
                kotlin.jvm.internal.y.h(packageName118, "getPackageName(...)");
                objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue6 == companion.getEmpty()) {
                    objRememberedValue6 = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.k
                        @Override // lb.a
                        public final Object invoke() {
                            return CameraKt.Camera$lambda$2$7$0(mutableState2);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                }
                lb.a aVar111118 = (lb.a) objRememberedValue6;
                objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue7 == companion.getEmpty()) {
                    objRememberedValue7 = new Function1() { // from class: cu.todus.android.uiCompose.shared.camera.m
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return CameraKt.Camera$lambda$2$8$0(mutableState2, (PermissionsResult) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                }
                Z17PermissionRequesterKt.Z17PermissionRequester(permissionsRequesterState111116, aVar111118, (Function1) objRememberedValue7, packageName118, composerStartRestartGroup, 432);
                state = ((PermissionsRequesterState) mutableState2.getValue()).getPermissionsResult().getState();
                if (state == null) {
                    z27 = z15;
                    j13 = j12;
                    cameraParams6 = cameraParams5;
                    z28 = z24;
                    z29 = z25;
                    z30 = z26;
                    composerStartRestartGroup.startReplaceGroup(-225953116);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(-226627738);
                    Modifier modifierFillMaxSize$default118 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                    boolean zCamera$lambda$2$118 = Camera$lambda$2$1(mutableState);
                    objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue8 == companion.getEmpty()) {
                        objRememberedValue8 = new Function1() { // from class: cu.todus.android.uiCompose.shared.camera.n
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return CameraKt.Camera$lambda$2$9$0(mutableState, ((Boolean) obj).booleanValue());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                    }
                    Function1 function118 = (Function1) objRememberedValue8;
                    int i3111111111111 = i13 << 3;
                    int i3111111111112 = (i13 & 112) | 6 | (i13 & 896) | (i13 & 7168) | (57344 & i13) | (458752 & i13) | (3670016 & i13) | (234881024 & i3111111111111) | (i3111111111111 & C.ENCODING_PCM_DOUBLE);
                    int i3111111111113 = i25 << 3;
                    int i3111111111114 = ((i13 >> 27) & 14) | 3072 | (i3111111111113 & 112) | (i3111111111113 & 896);
                    z27 = z15;
                    j13 = j12;
                    z28 = z24;
                    z29 = z25;
                    cameraParams6 = cameraParams5;
                    z30 = z26;
                    CameraPager(modifierFillMaxSize$default118, cameraParams6, z28, z27, z29, z30, j13, zCamera$lambda$2$118, sendVideos, sendImages, aVar2, onClose, onError, function118, composerStartRestartGroup, i3111111111112, i3111111111114, 0);
                    composerStartRestartGroup.endReplaceGroup();
                }
                ua.k0 k0Var118 = ua.k0.f43947a;
                zChanged = composerStartRestartGroup.changed(softwareKeyboardController);
                objRememberedValue9 = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    objRememberedValue9 = new CameraKt$Camera$3$7$1(softwareKeyboardController, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
                } else {
                    objRememberedValue9 = new CameraKt$Camera$3$7$1(softwareKeyboardController, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
                }
                EffectsKt.LaunchedEffect(k0Var118, (Function2) objRememberedValue9, composerStartRestartGroup, 6);
                composerStartRestartGroup.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                j11 = j13;
                z20 = z30;
                z16 = z29;
                z19 = z27;
                z18 = z28;
                cameraParams3 = cameraParams6;
                modifier3 = modifier4;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                j11 = j10;
                cameraParams3 = cameraParams2;
                modifier3 = modifier2;
                z18 = z14;
                z19 = z15;
                z20 = z13;
                aVar2 = aVar;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.shared.camera.o
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return CameraKt.Camera$lambda$3(modifier3, cameraParams3, z18, z19, z16, z20, j11, sendVideos, sendImages, aVar2, onClose, onError, i10, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i13 |= 24576;
        z16 = z12;
        i18 = i12 & 32;
        if (i18 != 0) {
            i13 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        } else if ((i10 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            if (composerStartRestartGroup.changed(z13)) {
                i19 = 131072;
            } else {
                i19 = 65536;
            }
            i13 |= i19;
        }
        i20 = i12 & 64;
        if (i20 != 0) {
            if ((i10 & 1572864) == 0) {
                if (composerStartRestartGroup.changed(j10)) {
                    i21 = 1048576;
                } else {
                    i21 = 524288;
                }
                i13 |= i21;
            }
            if ((i10 & 12582912) == 0) {
                if (composerStartRestartGroup.changedInstance(sendVideos)) {
                    i29 = 8388608;
                } else {
                    i29 = 4194304;
                }
                i13 |= i29;
            }
            if ((i10 & 100663296) == 0) {
                if (composerStartRestartGroup.changedInstance(sendImages)) {
                    i28 = 67108864;
                } else {
                    i28 = 33554432;
                }
                i13 |= i28;
            }
            i22 = i12 & 512;
            if (i22 != 0) {
                if ((i10 & 805306368) == 0) {
                    if (composerStartRestartGroup.changedInstance(aVar)) {
                        i23 = C.BUFFER_FLAG_LAST_SAMPLE;
                    } else {
                        i23 = 268435456;
                    }
                    i13 |= i23;
                }
                if ((i11 & 6) == 0) {
                    if (composerStartRestartGroup.changedInstance(onClose)) {
                        i27 = 4;
                    } else {
                        i27 = 2;
                    }
                    i24 = i11 | i27;
                } else {
                    i24 = i11;
                }
                if ((i11 & 48) == 0) {
                    if (composerStartRestartGroup.changedInstance(onError)) {
                        i26 = 32;
                    } else {
                        i26 = 16;
                    }
                    i24 |= i26;
                }
                i25 = i24;
                if ((i13 & 306783379) == 306783378) {
                    z17 = true;
                } else {
                    z17 = true;
                }
                if (composerStartRestartGroup.shouldExecute(z17, i13 & 1)) {
                    if (i30 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i31 != 0) {
                        cameraParams4 = new CameraParams(null, null, 0L, 7, null);
                    } else {
                        cameraParams4 = cameraParams2;
                    }
                    if (i32 != 0) {
                        z21 = true;
                    } else {
                        z21 = z14;
                    }
                    if (i14 != 0) {
                        z15 = true;
                    }
                    if (i16 != 0) {
                        z22 = false;
                    } else {
                        z22 = z16;
                    }
                    if (i18 != 0) {
                        z23 = false;
                    } else {
                        z23 = z13;
                    }
                    if (i20 != 0) {
                        j12 = Long.MAX_VALUE;
                    } else {
                        j12 = j10;
                    }
                    if (i22 != 0) {
                        objRememberedValue10 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue10 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue10 = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.f
                                @Override // lb.a
                                public final Object invoke() {
                                    return ua.k0.f43947a;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue10);
                        }
                        aVar2 = (lb.a) objRememberedValue10;
                    } else {
                        aVar2 = aVar;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1559415396, i13, i25, "cu.todus.android.uiCompose.shared.camera.Camera (Camera.kt:107)");
                    }
                    Modifier modifierImePadding119 = WindowInsetsPadding_androidKt.imePadding(modifier4);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    companion = Composer.INSTANCE;
                    if (objRememberedValue == companion.getEmpty()) {
                        objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.g
                            @Override // lb.a
                            public final Object invoke() {
                                return ua.k0.f43947a;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    Modifier modifierM1205backgroundbw27NRU$default119 = BackgroundKt.m1205backgroundbw27NRU$default(ClickableKt.m1240clickableoSLSa3U$default(modifierImePadding119, false, null, null, null, (lb.a) objRememberedValue, 14, null), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground(), null, 2, null);
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy119 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                    int iA119 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap119 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier119 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1205backgroundbw27NRU$default119);
                    ComposeUiNode.Companion companion1110 = ComposeUiNode.INSTANCE;
                    cameraParams5 = cameraParams4;
                    constructor = companion1110.getConstructor();
                    if (!defpackage.r.a(composerStartRestartGroup.getApplier())) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM5176constructorimpl119 = Updater.m5176constructorimpl(composerStartRestartGroup);
                    z24 = z21;
                    Updater.m5184setimpl(composerM5176constructorimpl119, measurePolicyMaybeCachedBoxMeasurePolicy119, companion1110.getSetMeasurePolicy());
                    Updater.m5184setimpl(composerM5176constructorimpl119, currentCompositionLocalMap119, companion1110.getSetResolvedCompositionLocals());
                    Updater.m5180initimpl(composerM5176constructorimpl119, Integer.valueOf(iA119), companion1110.getSetCompositeKeyHash());
                    Updater.m5182reconcileimpl(composerM5176constructorimpl119, companion1110.getApplyOnDeactivatedNodeAssertion());
                    Updater.m5184setimpl(composerM5176constructorimpl119, modifierMaterializeModifier119, companion1110.getSetModifier());
                    BoxScopeInstance boxScopeInstance119 = BoxScopeInstance.INSTANCE;
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == companion.getEmpty()) {
                        objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    mutableState = (MutableState) objRememberedValue2;
                    softwareKeyboardController = (SoftwareKeyboardController) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalSoftwareKeyboardController());
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue3 == companion.getEmpty()) {
                        objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new PermissionsRequesterState(null, false, va.w.q(PermissionNeedIt.STORAGE, PermissionNeedIt.CAMERA, PermissionNeedIt.RECORD_AUDIO), 1, null), null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    mutableState2 = (MutableState) objRememberedValue3;
                    Context context119 = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                    PermissionsRequesterState permissionsRequesterState111117 = (PermissionsRequesterState) mutableState2.getValue();
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue4 == companion.getEmpty()) {
                        objRememberedValue4 = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.h
                            @Override // lb.a
                            public final Object invoke() {
                                return CameraKt.Camera$lambda$2$4$0(mutableState2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    lb.a aVar111119 = (lb.a) objRememberedValue4;
                    objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue5 == companion.getEmpty()) {
                        objRememberedValue5 = new Function1() { // from class: cu.todus.android.uiCompose.shared.camera.i
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return CameraKt.Camera$lambda$2$5$0(mutableState2, (PermissionsResult) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    }
                    z25 = z22;
                    z26 = z23;
                    Z17PermissionRequesterKt.Z17PermissionChecker(null, aVar111119, permissionsRequesterState111117, (Function1) objRememberedValue5, ComposableLambdaKt.rememberComposableLambda(930493182, true, new Function3() { // from class: cu.todus.android.uiCompose.shared.camera.j
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return CameraKt.Camera$lambda$2$6(mutableState2, onClose, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, 27696, 1);
                    PermissionsRequesterState permissionsRequesterState111118 = (PermissionsRequesterState) mutableState2.getValue();
                    String packageName119 = context119.getPackageName();
                    kotlin.jvm.internal.y.h(packageName119, "getPackageName(...)");
                    objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue6 == companion.getEmpty()) {
                        objRememberedValue6 = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.k
                            @Override // lb.a
                            public final Object invoke() {
                                return CameraKt.Camera$lambda$2$7$0(mutableState2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                    }
                    lb.a aVar1111110 = (lb.a) objRememberedValue6;
                    objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue7 == companion.getEmpty()) {
                        objRememberedValue7 = new Function1() { // from class: cu.todus.android.uiCompose.shared.camera.m
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return CameraKt.Camera$lambda$2$8$0(mutableState2, (PermissionsResult) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                    }
                    Z17PermissionRequesterKt.Z17PermissionRequester(permissionsRequesterState111118, aVar1111110, (Function1) objRememberedValue7, packageName119, composerStartRestartGroup, 432);
                    state = ((PermissionsRequesterState) mutableState2.getValue()).getPermissionsResult().getState();
                    if (state == null) {
                        z27 = z15;
                        j13 = j12;
                        cameraParams6 = cameraParams5;
                        z28 = z24;
                        z29 = z25;
                        z30 = z26;
                        composerStartRestartGroup.startReplaceGroup(-225953116);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-226627738);
                        Modifier modifierFillMaxSize$default119 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                        boolean zCamera$lambda$2$119 = Camera$lambda$2$1(mutableState);
                        objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue8 == companion.getEmpty()) {
                            objRememberedValue8 = new Function1() { // from class: cu.todus.android.uiCompose.shared.camera.n
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return CameraKt.Camera$lambda$2$9$0(mutableState, ((Boolean) obj).booleanValue());
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                        }
                        Function1 function119 = (Function1) objRememberedValue8;
                        int i3111111111115 = i13 << 3;
                        int i3111111111116 = (i13 & 112) | 6 | (i13 & 896) | (i13 & 7168) | (57344 & i13) | (458752 & i13) | (3670016 & i13) | (234881024 & i3111111111115) | (i3111111111115 & C.ENCODING_PCM_DOUBLE);
                        int i3111111111117 = i25 << 3;
                        int i3111111111118 = ((i13 >> 27) & 14) | 3072 | (i3111111111117 & 112) | (i3111111111117 & 896);
                        z27 = z15;
                        j13 = j12;
                        z28 = z24;
                        z29 = z25;
                        cameraParams6 = cameraParams5;
                        z30 = z26;
                        CameraPager(modifierFillMaxSize$default119, cameraParams6, z28, z27, z29, z30, j13, zCamera$lambda$2$119, sendVideos, sendImages, aVar2, onClose, onError, function119, composerStartRestartGroup, i3111111111116, i3111111111118, 0);
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    ua.k0 k0Var119 = ua.k0.f43947a;
                    zChanged = composerStartRestartGroup.changed(softwareKeyboardController);
                    objRememberedValue9 = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue9 = new CameraKt$Camera$3$7$1(softwareKeyboardController, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
                    } else {
                        objRememberedValue9 = new CameraKt$Camera$3$7$1(softwareKeyboardController, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
                    }
                    EffectsKt.LaunchedEffect(k0Var119, (Function2) objRememberedValue9, composerStartRestartGroup, 6);
                    composerStartRestartGroup.endNode();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    j11 = j13;
                    z20 = z30;
                    z16 = z29;
                    z19 = z27;
                    z18 = z28;
                    cameraParams3 = cameraParams6;
                    modifier3 = modifier4;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    j11 = j10;
                    cameraParams3 = cameraParams2;
                    modifier3 = modifier2;
                    z18 = z14;
                    z19 = z15;
                    z20 = z13;
                    aVar2 = aVar;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.shared.camera.o
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return CameraKt.Camera$lambda$3(modifier3, cameraParams3, z18, z19, z16, z20, j11, sendVideos, sendImages, aVar2, onClose, onError, i10, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i13 |= 805306368;
            if ((i11 & 6) == 0) {
                if (composerStartRestartGroup.changedInstance(onClose)) {
                    i27 = 4;
                } else {
                    i27 = 2;
                }
                i24 = i11 | i27;
            } else {
                i24 = i11;
            }
            if ((i11 & 48) == 0) {
                if (composerStartRestartGroup.changedInstance(onError)) {
                    i26 = 32;
                } else {
                    i26 = 16;
                }
                i24 |= i26;
            }
            i25 = i24;
            if ((i13 & 306783379) == 306783378) {
                z17 = true;
            } else {
                z17 = true;
            }
            if (composerStartRestartGroup.shouldExecute(z17, i13 & 1)) {
                if (i30 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (i31 != 0) {
                    cameraParams4 = new CameraParams(null, null, 0L, 7, null);
                } else {
                    cameraParams4 = cameraParams2;
                }
                if (i32 != 0) {
                    z21 = true;
                } else {
                    z21 = z14;
                }
                if (i14 != 0) {
                    z15 = true;
                }
                if (i16 != 0) {
                    z22 = false;
                } else {
                    z22 = z16;
                }
                if (i18 != 0) {
                    z23 = false;
                } else {
                    z23 = z13;
                }
                if (i20 != 0) {
                    j12 = Long.MAX_VALUE;
                } else {
                    j12 = j10;
                }
                if (i22 != 0) {
                    objRememberedValue10 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue10 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue10 = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.f
                            @Override // lb.a
                            public final Object invoke() {
                                return ua.k0.f43947a;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue10);
                    }
                    aVar2 = (lb.a) objRememberedValue10;
                } else {
                    aVar2 = aVar;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1559415396, i13, i25, "cu.todus.android.uiCompose.shared.camera.Camera (Camera.kt:107)");
                }
                Modifier modifierImePadding1110 = WindowInsetsPadding_androidKt.imePadding(modifier4);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                companion = Composer.INSTANCE;
                if (objRememberedValue == companion.getEmpty()) {
                    objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.g
                        @Override // lb.a
                        public final Object invoke() {
                            return ua.k0.f43947a;
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                Modifier modifierM1205backgroundbw27NRU$default1110 = BackgroundKt.m1205backgroundbw27NRU$default(ClickableKt.m1240clickableoSLSa3U$default(modifierImePadding1110, false, null, null, null, (lb.a) objRememberedValue, 14, null), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground(), null, 2, null);
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy1110 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                int iA1110 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap1110 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier1110 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1205backgroundbw27NRU$default1110);
                ComposeUiNode.Companion companion1111 = ComposeUiNode.INSTANCE;
                cameraParams5 = cameraParams4;
                constructor = companion1111.getConstructor();
                if (!defpackage.r.a(composerStartRestartGroup.getApplier())) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor);
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM5176constructorimpl1110 = Updater.m5176constructorimpl(composerStartRestartGroup);
                z24 = z21;
                Updater.m5184setimpl(composerM5176constructorimpl1110, measurePolicyMaybeCachedBoxMeasurePolicy1110, companion1111.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl1110, currentCompositionLocalMap1110, companion1111.getSetResolvedCompositionLocals());
                Updater.m5180initimpl(composerM5176constructorimpl1110, Integer.valueOf(iA1110), companion1111.getSetCompositeKeyHash());
                Updater.m5182reconcileimpl(composerM5176constructorimpl1110, companion1111.getApplyOnDeactivatedNodeAssertion());
                Updater.m5184setimpl(composerM5176constructorimpl1110, modifierMaterializeModifier1110, companion1111.getSetModifier());
                BoxScopeInstance boxScopeInstance1110 = BoxScopeInstance.INSTANCE;
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == companion.getEmpty()) {
                    objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                mutableState = (MutableState) objRememberedValue2;
                softwareKeyboardController = (SoftwareKeyboardController) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalSoftwareKeyboardController());
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue3 == companion.getEmpty()) {
                    objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new PermissionsRequesterState(null, false, va.w.q(PermissionNeedIt.STORAGE, PermissionNeedIt.CAMERA, PermissionNeedIt.RECORD_AUDIO), 1, null), null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                mutableState2 = (MutableState) objRememberedValue3;
                Context context1110 = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                PermissionsRequesterState permissionsRequesterState111119 = (PermissionsRequesterState) mutableState2.getValue();
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue4 == companion.getEmpty()) {
                    objRememberedValue4 = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.h
                        @Override // lb.a
                        public final Object invoke() {
                            return CameraKt.Camera$lambda$2$4$0(mutableState2);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                lb.a aVar1111111 = (lb.a) objRememberedValue4;
                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue5 == companion.getEmpty()) {
                    objRememberedValue5 = new Function1() { // from class: cu.todus.android.uiCompose.shared.camera.i
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return CameraKt.Camera$lambda$2$5$0(mutableState2, (PermissionsResult) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                z25 = z22;
                z26 = z23;
                Z17PermissionRequesterKt.Z17PermissionChecker(null, aVar1111111, permissionsRequesterState111119, (Function1) objRememberedValue5, ComposableLambdaKt.rememberComposableLambda(930493182, true, new Function3() { // from class: cu.todus.android.uiCompose.shared.camera.j
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return CameraKt.Camera$lambda$2$6(mutableState2, onClose, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 27696, 1);
                PermissionsRequesterState permissionsRequesterState1111110 = (PermissionsRequesterState) mutableState2.getValue();
                String packageName1110 = context1110.getPackageName();
                kotlin.jvm.internal.y.h(packageName1110, "getPackageName(...)");
                objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue6 == companion.getEmpty()) {
                    objRememberedValue6 = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.k
                        @Override // lb.a
                        public final Object invoke() {
                            return CameraKt.Camera$lambda$2$7$0(mutableState2);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                }
                lb.a aVar1111112 = (lb.a) objRememberedValue6;
                objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue7 == companion.getEmpty()) {
                    objRememberedValue7 = new Function1() { // from class: cu.todus.android.uiCompose.shared.camera.m
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return CameraKt.Camera$lambda$2$8$0(mutableState2, (PermissionsResult) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                }
                Z17PermissionRequesterKt.Z17PermissionRequester(permissionsRequesterState1111110, aVar1111112, (Function1) objRememberedValue7, packageName1110, composerStartRestartGroup, 432);
                state = ((PermissionsRequesterState) mutableState2.getValue()).getPermissionsResult().getState();
                if (state == null) {
                    z27 = z15;
                    j13 = j12;
                    cameraParams6 = cameraParams5;
                    z28 = z24;
                    z29 = z25;
                    z30 = z26;
                    composerStartRestartGroup.startReplaceGroup(-225953116);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(-226627738);
                    Modifier modifierFillMaxSize$default1110 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                    boolean zCamera$lambda$2$1110 = Camera$lambda$2$1(mutableState);
                    objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue8 == companion.getEmpty()) {
                        objRememberedValue8 = new Function1() { // from class: cu.todus.android.uiCompose.shared.camera.n
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return CameraKt.Camera$lambda$2$9$0(mutableState, ((Boolean) obj).booleanValue());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                    }
                    Function1 function1110 = (Function1) objRememberedValue8;
                    int i3111111111119 = i13 << 3;
                    int i31111111111110 = (i13 & 112) | 6 | (i13 & 896) | (i13 & 7168) | (57344 & i13) | (458752 & i13) | (3670016 & i13) | (234881024 & i3111111111119) | (i3111111111119 & C.ENCODING_PCM_DOUBLE);
                    int i31111111111111 = i25 << 3;
                    int i31111111111112 = ((i13 >> 27) & 14) | 3072 | (i31111111111111 & 112) | (i31111111111111 & 896);
                    z27 = z15;
                    j13 = j12;
                    z28 = z24;
                    z29 = z25;
                    cameraParams6 = cameraParams5;
                    z30 = z26;
                    CameraPager(modifierFillMaxSize$default1110, cameraParams6, z28, z27, z29, z30, j13, zCamera$lambda$2$1110, sendVideos, sendImages, aVar2, onClose, onError, function1110, composerStartRestartGroup, i31111111111110, i31111111111112, 0);
                    composerStartRestartGroup.endReplaceGroup();
                }
                ua.k0 k0Var1110 = ua.k0.f43947a;
                zChanged = composerStartRestartGroup.changed(softwareKeyboardController);
                objRememberedValue9 = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    objRememberedValue9 = new CameraKt$Camera$3$7$1(softwareKeyboardController, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
                } else {
                    objRememberedValue9 = new CameraKt$Camera$3$7$1(softwareKeyboardController, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
                }
                EffectsKt.LaunchedEffect(k0Var1110, (Function2) objRememberedValue9, composerStartRestartGroup, 6);
                composerStartRestartGroup.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                j11 = j13;
                z20 = z30;
                z16 = z29;
                z19 = z27;
                z18 = z28;
                cameraParams3 = cameraParams6;
                modifier3 = modifier4;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                j11 = j10;
                cameraParams3 = cameraParams2;
                modifier3 = modifier2;
                z18 = z14;
                z19 = z15;
                z20 = z13;
                aVar2 = aVar;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.shared.camera.o
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return CameraKt.Camera$lambda$3(modifier3, cameraParams3, z18, z19, z16, z20, j11, sendVideos, sendImages, aVar2, onClose, onError, i10, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i13 |= 1572864;
        if ((i10 & 12582912) == 0) {
            if (composerStartRestartGroup.changedInstance(sendVideos)) {
                i29 = 8388608;
            } else {
                i29 = 4194304;
            }
            i13 |= i29;
        }
        if ((i10 & 100663296) == 0) {
            if (composerStartRestartGroup.changedInstance(sendImages)) {
                i28 = 67108864;
            } else {
                i28 = 33554432;
            }
            i13 |= i28;
        }
        i22 = i12 & 512;
        if (i22 != 0) {
            if ((i10 & 805306368) == 0) {
                if (composerStartRestartGroup.changedInstance(aVar)) {
                    i23 = C.BUFFER_FLAG_LAST_SAMPLE;
                } else {
                    i23 = 268435456;
                }
                i13 |= i23;
            }
            if ((i11 & 6) == 0) {
                if (composerStartRestartGroup.changedInstance(onClose)) {
                    i27 = 4;
                } else {
                    i27 = 2;
                }
                i24 = i11 | i27;
            } else {
                i24 = i11;
            }
            if ((i11 & 48) == 0) {
                if (composerStartRestartGroup.changedInstance(onError)) {
                    i26 = 32;
                } else {
                    i26 = 16;
                }
                i24 |= i26;
            }
            i25 = i24;
            if ((i13 & 306783379) == 306783378) {
                z17 = true;
            } else {
                z17 = true;
            }
            if (composerStartRestartGroup.shouldExecute(z17, i13 & 1)) {
                if (i30 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (i31 != 0) {
                    cameraParams4 = new CameraParams(null, null, 0L, 7, null);
                } else {
                    cameraParams4 = cameraParams2;
                }
                if (i32 != 0) {
                    z21 = true;
                } else {
                    z21 = z14;
                }
                if (i14 != 0) {
                    z15 = true;
                }
                if (i16 != 0) {
                    z22 = false;
                } else {
                    z22 = z16;
                }
                if (i18 != 0) {
                    z23 = false;
                } else {
                    z23 = z13;
                }
                if (i20 != 0) {
                    j12 = Long.MAX_VALUE;
                } else {
                    j12 = j10;
                }
                if (i22 != 0) {
                    objRememberedValue10 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue10 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue10 = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.f
                            @Override // lb.a
                            public final Object invoke() {
                                return ua.k0.f43947a;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue10);
                    }
                    aVar2 = (lb.a) objRememberedValue10;
                } else {
                    aVar2 = aVar;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1559415396, i13, i25, "cu.todus.android.uiCompose.shared.camera.Camera (Camera.kt:107)");
                }
                Modifier modifierImePadding1111 = WindowInsetsPadding_androidKt.imePadding(modifier4);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                companion = Composer.INSTANCE;
                if (objRememberedValue == companion.getEmpty()) {
                    objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.g
                        @Override // lb.a
                        public final Object invoke() {
                            return ua.k0.f43947a;
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                Modifier modifierM1205backgroundbw27NRU$default1111 = BackgroundKt.m1205backgroundbw27NRU$default(ClickableKt.m1240clickableoSLSa3U$default(modifierImePadding1111, false, null, null, null, (lb.a) objRememberedValue, 14, null), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground(), null, 2, null);
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy1111 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                int iA1111 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap1111 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier1111 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1205backgroundbw27NRU$default1111);
                ComposeUiNode.Companion companion1112 = ComposeUiNode.INSTANCE;
                cameraParams5 = cameraParams4;
                constructor = companion1112.getConstructor();
                if (!defpackage.r.a(composerStartRestartGroup.getApplier())) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor);
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM5176constructorimpl1111 = Updater.m5176constructorimpl(composerStartRestartGroup);
                z24 = z21;
                Updater.m5184setimpl(composerM5176constructorimpl1111, measurePolicyMaybeCachedBoxMeasurePolicy1111, companion1112.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl1111, currentCompositionLocalMap1111, companion1112.getSetResolvedCompositionLocals());
                Updater.m5180initimpl(composerM5176constructorimpl1111, Integer.valueOf(iA1111), companion1112.getSetCompositeKeyHash());
                Updater.m5182reconcileimpl(composerM5176constructorimpl1111, companion1112.getApplyOnDeactivatedNodeAssertion());
                Updater.m5184setimpl(composerM5176constructorimpl1111, modifierMaterializeModifier1111, companion1112.getSetModifier());
                BoxScopeInstance boxScopeInstance1111 = BoxScopeInstance.INSTANCE;
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == companion.getEmpty()) {
                    objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                mutableState = (MutableState) objRememberedValue2;
                softwareKeyboardController = (SoftwareKeyboardController) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalSoftwareKeyboardController());
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue3 == companion.getEmpty()) {
                    objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new PermissionsRequesterState(null, false, va.w.q(PermissionNeedIt.STORAGE, PermissionNeedIt.CAMERA, PermissionNeedIt.RECORD_AUDIO), 1, null), null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                mutableState2 = (MutableState) objRememberedValue3;
                Context context1111 = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                PermissionsRequesterState permissionsRequesterState1111111 = (PermissionsRequesterState) mutableState2.getValue();
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue4 == companion.getEmpty()) {
                    objRememberedValue4 = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.h
                        @Override // lb.a
                        public final Object invoke() {
                            return CameraKt.Camera$lambda$2$4$0(mutableState2);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                lb.a aVar1111113 = (lb.a) objRememberedValue4;
                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue5 == companion.getEmpty()) {
                    objRememberedValue5 = new Function1() { // from class: cu.todus.android.uiCompose.shared.camera.i
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return CameraKt.Camera$lambda$2$5$0(mutableState2, (PermissionsResult) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                z25 = z22;
                z26 = z23;
                Z17PermissionRequesterKt.Z17PermissionChecker(null, aVar1111113, permissionsRequesterState1111111, (Function1) objRememberedValue5, ComposableLambdaKt.rememberComposableLambda(930493182, true, new Function3() { // from class: cu.todus.android.uiCompose.shared.camera.j
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return CameraKt.Camera$lambda$2$6(mutableState2, onClose, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 27696, 1);
                PermissionsRequesterState permissionsRequesterState1111112 = (PermissionsRequesterState) mutableState2.getValue();
                String packageName1111 = context1111.getPackageName();
                kotlin.jvm.internal.y.h(packageName1111, "getPackageName(...)");
                objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue6 == companion.getEmpty()) {
                    objRememberedValue6 = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.k
                        @Override // lb.a
                        public final Object invoke() {
                            return CameraKt.Camera$lambda$2$7$0(mutableState2);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                }
                lb.a aVar1111114 = (lb.a) objRememberedValue6;
                objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue7 == companion.getEmpty()) {
                    objRememberedValue7 = new Function1() { // from class: cu.todus.android.uiCompose.shared.camera.m
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return CameraKt.Camera$lambda$2$8$0(mutableState2, (PermissionsResult) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                }
                Z17PermissionRequesterKt.Z17PermissionRequester(permissionsRequesterState1111112, aVar1111114, (Function1) objRememberedValue7, packageName1111, composerStartRestartGroup, 432);
                state = ((PermissionsRequesterState) mutableState2.getValue()).getPermissionsResult().getState();
                if (state == null) {
                    z27 = z15;
                    j13 = j12;
                    cameraParams6 = cameraParams5;
                    z28 = z24;
                    z29 = z25;
                    z30 = z26;
                    composerStartRestartGroup.startReplaceGroup(-225953116);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(-226627738);
                    Modifier modifierFillMaxSize$default1111 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                    boolean zCamera$lambda$2$1111 = Camera$lambda$2$1(mutableState);
                    objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue8 == companion.getEmpty()) {
                        objRememberedValue8 = new Function1() { // from class: cu.todus.android.uiCompose.shared.camera.n
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return CameraKt.Camera$lambda$2$9$0(mutableState, ((Boolean) obj).booleanValue());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                    }
                    Function1 function1111 = (Function1) objRememberedValue8;
                    int i31111111111113 = i13 << 3;
                    int i31111111111114 = (i13 & 112) | 6 | (i13 & 896) | (i13 & 7168) | (57344 & i13) | (458752 & i13) | (3670016 & i13) | (234881024 & i31111111111113) | (i31111111111113 & C.ENCODING_PCM_DOUBLE);
                    int i31111111111115 = i25 << 3;
                    int i31111111111116 = ((i13 >> 27) & 14) | 3072 | (i31111111111115 & 112) | (i31111111111115 & 896);
                    z27 = z15;
                    j13 = j12;
                    z28 = z24;
                    z29 = z25;
                    cameraParams6 = cameraParams5;
                    z30 = z26;
                    CameraPager(modifierFillMaxSize$default1111, cameraParams6, z28, z27, z29, z30, j13, zCamera$lambda$2$1111, sendVideos, sendImages, aVar2, onClose, onError, function1111, composerStartRestartGroup, i31111111111114, i31111111111116, 0);
                    composerStartRestartGroup.endReplaceGroup();
                }
                ua.k0 k0Var1111 = ua.k0.f43947a;
                zChanged = composerStartRestartGroup.changed(softwareKeyboardController);
                objRememberedValue9 = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    objRememberedValue9 = new CameraKt$Camera$3$7$1(softwareKeyboardController, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
                } else {
                    objRememberedValue9 = new CameraKt$Camera$3$7$1(softwareKeyboardController, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
                }
                EffectsKt.LaunchedEffect(k0Var1111, (Function2) objRememberedValue9, composerStartRestartGroup, 6);
                composerStartRestartGroup.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                j11 = j13;
                z20 = z30;
                z16 = z29;
                z19 = z27;
                z18 = z28;
                cameraParams3 = cameraParams6;
                modifier3 = modifier4;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                j11 = j10;
                cameraParams3 = cameraParams2;
                modifier3 = modifier2;
                z18 = z14;
                z19 = z15;
                z20 = z13;
                aVar2 = aVar;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.shared.camera.o
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return CameraKt.Camera$lambda$3(modifier3, cameraParams3, z18, z19, z16, z20, j11, sendVideos, sendImages, aVar2, onClose, onError, i10, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i13 |= 805306368;
        if ((i11 & 6) == 0) {
            if (composerStartRestartGroup.changedInstance(onClose)) {
                i27 = 4;
            } else {
                i27 = 2;
            }
            i24 = i11 | i27;
        } else {
            i24 = i11;
        }
        if ((i11 & 48) == 0) {
            if (composerStartRestartGroup.changedInstance(onError)) {
                i26 = 32;
            } else {
                i26 = 16;
            }
            i24 |= i26;
        }
        i25 = i24;
        if ((i13 & 306783379) == 306783378) {
            z17 = true;
        } else {
            z17 = true;
        }
        if (composerStartRestartGroup.shouldExecute(z17, i13 & 1)) {
            if (i30 != 0) {
                modifier4 = Modifier.INSTANCE;
            } else {
                modifier4 = modifier2;
            }
            if (i31 != 0) {
                cameraParams4 = new CameraParams(null, null, 0L, 7, null);
            } else {
                cameraParams4 = cameraParams2;
            }
            if (i32 != 0) {
                z21 = true;
            } else {
                z21 = z14;
            }
            if (i14 != 0) {
                z15 = true;
            }
            if (i16 != 0) {
                z22 = false;
            } else {
                z22 = z16;
            }
            if (i18 != 0) {
                z23 = false;
            } else {
                z23 = z13;
            }
            if (i20 != 0) {
                j12 = Long.MAX_VALUE;
            } else {
                j12 = j10;
            }
            if (i22 != 0) {
                objRememberedValue10 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue10 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue10 = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.f
                        @Override // lb.a
                        public final Object invoke() {
                            return ua.k0.f43947a;
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue10);
                }
                aVar2 = (lb.a) objRememberedValue10;
            } else {
                aVar2 = aVar;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1559415396, i13, i25, "cu.todus.android.uiCompose.shared.camera.Camera (Camera.kt:107)");
            }
            Modifier modifierImePadding1112 = WindowInsetsPadding_androidKt.imePadding(modifier4);
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            companion = Composer.INSTANCE;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.g
                    @Override // lb.a
                    public final Object invoke() {
                        return ua.k0.f43947a;
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            Modifier modifierM1205backgroundbw27NRU$default1112 = BackgroundKt.m1205backgroundbw27NRU$default(ClickableKt.m1240clickableoSLSa3U$default(modifierImePadding1112, false, null, null, null, (lb.a) objRememberedValue, 14, null), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground(), null, 2, null);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy1112 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            int iA1112 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap1112 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier1112 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1205backgroundbw27NRU$default1112);
            ComposeUiNode.Companion companion1113 = ComposeUiNode.INSTANCE;
            cameraParams5 = cameraParams4;
            constructor = companion1113.getConstructor();
            if (!defpackage.r.a(composerStartRestartGroup.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM5176constructorimpl1112 = Updater.m5176constructorimpl(composerStartRestartGroup);
            z24 = z21;
            Updater.m5184setimpl(composerM5176constructorimpl1112, measurePolicyMaybeCachedBoxMeasurePolicy1112, companion1113.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl1112, currentCompositionLocalMap1112, companion1113.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl1112, Integer.valueOf(iA1112), companion1113.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl1112, companion1113.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl1112, modifierMaterializeModifier1112, companion1113.getSetModifier());
            BoxScopeInstance boxScopeInstance1112 = BoxScopeInstance.INSTANCE;
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            mutableState = (MutableState) objRememberedValue2;
            softwareKeyboardController = (SoftwareKeyboardController) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalSoftwareKeyboardController());
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == companion.getEmpty()) {
                objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new PermissionsRequesterState(null, false, va.w.q(PermissionNeedIt.STORAGE, PermissionNeedIt.CAMERA, PermissionNeedIt.RECORD_AUDIO), 1, null), null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            mutableState2 = (MutableState) objRememberedValue3;
            Context context1112 = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
            PermissionsRequesterState permissionsRequesterState1111113 = (PermissionsRequesterState) mutableState2.getValue();
            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue4 == companion.getEmpty()) {
                objRememberedValue4 = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.h
                    @Override // lb.a
                    public final Object invoke() {
                        return CameraKt.Camera$lambda$2$4$0(mutableState2);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            lb.a aVar1111115 = (lb.a) objRememberedValue4;
            objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue5 == companion.getEmpty()) {
                objRememberedValue5 = new Function1() { // from class: cu.todus.android.uiCompose.shared.camera.i
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return CameraKt.Camera$lambda$2$5$0(mutableState2, (PermissionsResult) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            }
            z25 = z22;
            z26 = z23;
            Z17PermissionRequesterKt.Z17PermissionChecker(null, aVar1111115, permissionsRequesterState1111113, (Function1) objRememberedValue5, ComposableLambdaKt.rememberComposableLambda(930493182, true, new Function3() { // from class: cu.todus.android.uiCompose.shared.camera.j
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return CameraKt.Camera$lambda$2$6(mutableState2, onClose, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 27696, 1);
            PermissionsRequesterState permissionsRequesterState1111114 = (PermissionsRequesterState) mutableState2.getValue();
            String packageName1112 = context1112.getPackageName();
            kotlin.jvm.internal.y.h(packageName1112, "getPackageName(...)");
            objRememberedValue6 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue6 == companion.getEmpty()) {
                objRememberedValue6 = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.k
                    @Override // lb.a
                    public final Object invoke() {
                        return CameraKt.Camera$lambda$2$7$0(mutableState2);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
            }
            lb.a aVar1111116 = (lb.a) objRememberedValue6;
            objRememberedValue7 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue7 == companion.getEmpty()) {
                objRememberedValue7 = new Function1() { // from class: cu.todus.android.uiCompose.shared.camera.m
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return CameraKt.Camera$lambda$2$8$0(mutableState2, (PermissionsResult) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
            }
            Z17PermissionRequesterKt.Z17PermissionRequester(permissionsRequesterState1111114, aVar1111116, (Function1) objRememberedValue7, packageName1112, composerStartRestartGroup, 432);
            state = ((PermissionsRequesterState) mutableState2.getValue()).getPermissionsResult().getState();
            if (state == null) {
                z27 = z15;
                j13 = j12;
                cameraParams6 = cameraParams5;
                z28 = z24;
                z29 = z25;
                z30 = z26;
                composerStartRestartGroup.startReplaceGroup(-225953116);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-226627738);
                Modifier modifierFillMaxSize$default1112 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                boolean zCamera$lambda$2$1112 = Camera$lambda$2$1(mutableState);
                objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue8 == companion.getEmpty()) {
                    objRememberedValue8 = new Function1() { // from class: cu.todus.android.uiCompose.shared.camera.n
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return CameraKt.Camera$lambda$2$9$0(mutableState, ((Boolean) obj).booleanValue());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                }
                Function1 function1112 = (Function1) objRememberedValue8;
                int i31111111111117 = i13 << 3;
                int i31111111111118 = (i13 & 112) | 6 | (i13 & 896) | (i13 & 7168) | (57344 & i13) | (458752 & i13) | (3670016 & i13) | (234881024 & i31111111111117) | (i31111111111117 & C.ENCODING_PCM_DOUBLE);
                int i31111111111119 = i25 << 3;
                int i311111111111110 = ((i13 >> 27) & 14) | 3072 | (i31111111111119 & 112) | (i31111111111119 & 896);
                z27 = z15;
                j13 = j12;
                z28 = z24;
                z29 = z25;
                cameraParams6 = cameraParams5;
                z30 = z26;
                CameraPager(modifierFillMaxSize$default1112, cameraParams6, z28, z27, z29, z30, j13, zCamera$lambda$2$1112, sendVideos, sendImages, aVar2, onClose, onError, function1112, composerStartRestartGroup, i31111111111118, i311111111111110, 0);
                composerStartRestartGroup.endReplaceGroup();
            }
            ua.k0 k0Var1112 = ua.k0.f43947a;
            zChanged = composerStartRestartGroup.changed(softwareKeyboardController);
            objRememberedValue9 = composerStartRestartGroup.rememberedValue();
            if (zChanged) {
                objRememberedValue9 = new CameraKt$Camera$3$7$1(softwareKeyboardController, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
            } else {
                objRememberedValue9 = new CameraKt$Camera$3$7$1(softwareKeyboardController, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
            }
            EffectsKt.LaunchedEffect(k0Var1112, (Function2) objRememberedValue9, composerStartRestartGroup, 6);
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            j11 = j13;
            z20 = z30;
            z16 = z29;
            z19 = z27;
            z18 = z28;
            cameraParams3 = cameraParams6;
            modifier3 = modifier4;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            j11 = j10;
            cameraParams3 = cameraParams2;
            modifier3 = modifier2;
            z18 = z14;
            z19 = z15;
            z20 = z13;
            aVar2 = aVar;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.shared.camera.o
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CameraKt.Camera$lambda$3(modifier3, cameraParams3, z18, z19, z16, z20, j11, sendVideos, sendImages, aVar2, onClose, onError, i10, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final boolean Camera$lambda$2$1(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void Camera$lambda$2$2(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 Camera$lambda$2$4$0(MutableState mutableState) {
        mutableState.setValue(PermissionsRequesterState.copy$default((PermissionsRequesterState) mutableState.getValue(), null, true, null, 5, null));
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 Camera$lambda$2$5$0(MutableState mutableState, PermissionsResult result) {
        kotlin.jvm.internal.y.i(result, "result");
        PermissionsRequesterState permissionsRequesterState = (PermissionsRequesterState) mutableState.getValue();
        Integer state = result.getState();
        mutableState.setValue(PermissionsRequesterState.copy$default(permissionsRequesterState, result, state == null || state.intValue() != 2, null, 4, null));
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 Camera$lambda$2$6(final MutableState mutableState, final lb.a aVar, Modifier it, Composer composer, int i10) {
        kotlin.jvm.internal.y.i(it, "it");
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(930493182, i10, -1, "cu.todus.android.uiCompose.shared.camera.Camera.<anonymous>.<anonymous> (Camera.kt:149)");
            }
            Integer state = ((PermissionsRequesterState) mutableState.getValue()).getPermissionsResult().getState();
            if (state != null && state.intValue() == 4) {
                composer.startReplaceGroup(603590252);
                Modifier.Companion companion = Modifier.INSTANCE;
                Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(companion, 0.0f, 1, null);
                MaterialTheme materialTheme = MaterialTheme.INSTANCE;
                int i11 = MaterialTheme.$stable;
                Modifier modifierM1205backgroundbw27NRU$default = BackgroundKt.m1205backgroundbw27NRU$default(modifierFillMaxSize$default, materialTheme.getColorScheme(composer, i11).getBackground(), null, 2, null);
                Alignment.Companion companion2 = Alignment.INSTANCE;
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion2.getTopStart(), false);
                int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
                CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierM1205backgroundbw27NRU$default);
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
                boolean zChanged = composer.changed(aVar);
                Object objRememberedValue = composer.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.a1
                        @Override // lb.a
                        public final Object invoke() {
                            return CameraKt.Camera$lambda$2$6$0$0$0(aVar);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                float f10 = 20;
                IconButtonKt.IconButton((lb.a) objRememberedValue, boxScopeInstance.align(PaddingKt.m1725padding3ABfNKs(companion, Dp.m8823constructorimpl(f10)), companion2.getTopStart()), false, null, null, null, ComposableSingletons$CameraKt.INSTANCE.getLambda$1719014175$app_productionPFast(), composer, 1572864, 60);
                Modifier modifierM1725padding3ABfNKs = PaddingKt.m1725padding3ABfNKs(BackgroundKt.m1204backgroundbw27NRU(PaddingKt.m1725padding3ABfNKs(SizeKt.fillMaxWidth$default(boxScopeInstance.align(companion, companion2.getCenter()), 0.0f, 1, null), Dp.m8823constructorimpl(f10)), Color.m5865copywmQWz5c$default(materialTheme.getColorScheme(composer, i11).getOnBackground(), 0.2f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(10))), Dp.m8823constructorimpl(f10));
                String strStringResource = StringResources_androidKt.stringResource(R.string.required_permissions_were_not_granted, composer, 0);
                TextStyle textStyleM8271copyp1EtxEg$default = TextStyle.m8271copyp1EtxEg$default(materialTheme.getTypography(composer, i11).getBodyMedium(), 0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, TextAlign.INSTANCE.m8692getCentere0LSkKk(), 0, 0L, null, null, null, 0, 0, null, 16744447, null);
                Object objRememberedValue2 = composer.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.b1
                        @Override // lb.a
                        public final Object invoke() {
                            return CameraKt.Camera$lambda$2$6$0$1$0(mutableState);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue2);
                }
                Z17MarkdownLabelKt.Z17MarkdownLabel(modifierM1725padding3ABfNKs, strStringResource, textStyleM8271copyp1EtxEg$default, (lb.a) objRememberedValue2, null, composer, 3072, 16);
                composer.endNode();
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(605427684);
                composer.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 Camera$lambda$2$6$0$0$0(lb.a aVar) {
        aVar.invoke();
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 Camera$lambda$2$6$0$1$0(MutableState mutableState) {
        mutableState.setValue(PermissionsRequesterState.copy$default((PermissionsRequesterState) mutableState.getValue(), null, true, null, 5, null));
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 Camera$lambda$2$7$0(MutableState mutableState) {
        mutableState.setValue(PermissionsRequesterState.copy$default((PermissionsRequesterState) mutableState.getValue(), null, false, null, 5, null));
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 Camera$lambda$2$8$0(MutableState mutableState, PermissionsResult result) {
        kotlin.jvm.internal.y.i(result, "result");
        mutableState.setValue(PermissionsRequesterState.copy$default((PermissionsRequesterState) mutableState.getValue(), result, false, null, 6, null));
        Integer state = result.getState();
        if (state != null && state.intValue() == 2) {
            mutableState.setValue(PermissionsRequesterState.copy$default((PermissionsRequesterState) mutableState.getValue(), null, false, null, 5, null));
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 Camera$lambda$2$9$0(MutableState mutableState, boolean z10) {
        Camera$lambda$2$2(mutableState, z10);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 Camera$lambda$3(Modifier modifier, CameraParams cameraParams, boolean z10, boolean z11, boolean z12, boolean z13, long j10, Function2 function2, Function2 function3, lb.a aVar, lb.a aVar2, lb.a aVar3, int i10, int i11, int i12, Composer composer, int i13) {
        Camera(modifier, cameraParams, z10, z11, z12, z13, j10, function2, function3, aVar, aVar2, aVar3, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), RecomposeScopeImplKt.updateChangedFlags(i11), i12);
        return ua.k0.f43947a;
    }

    /* JADX WARN: Code duplicated, block: B:103:0x0150  */
    /* JADX WARN: Code duplicated, block: B:105:0x0156  */
    /* JADX WARN: Code duplicated, block: B:113:0x016e  */
    /* JADX WARN: Code duplicated, block: B:116:0x0177 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:117:0x0179  */
    /* JADX WARN: Code duplicated, block: B:118:0x017c  */
    /* JADX WARN: Code duplicated, block: B:120:0x0180  */
    /* JADX WARN: Code duplicated, block: B:123:0x0187  */
    /* JADX WARN: Code duplicated, block: B:126:0x01bb  */
    /* JADX WARN: Code duplicated, block: B:129:0x01c7  */
    /* JADX WARN: Code duplicated, block: B:130:0x01cb  */
    /* JADX WARN: Code duplicated, block: B:133:0x0203  */
    /* JADX WARN: Code duplicated, block: B:134:0x0209  */
    /* JADX WARN: Code duplicated, block: B:137:0x0216  */
    /* JADX WARN: Code duplicated, block: B:140:0x0236  */
    /* JADX WARN: Code duplicated, block: B:141:0x0238  */
    /* JADX WARN: Code duplicated, block: B:146:0x0245  */
    /* JADX WARN: Code duplicated, block: B:149:0x0261  */
    /* JADX WARN: Code duplicated, block: B:152:0x0277  */
    /* JADX WARN: Code duplicated, block: B:153:0x0279  */
    /* JADX WARN: Code duplicated, block: B:158:0x0286  */
    /* JADX WARN: Code duplicated, block: B:161:0x02a1  */
    /* JADX WARN: Code duplicated, block: B:164:0x02b7  */
    /* JADX WARN: Code duplicated, block: B:167:0x02d9  */
    /* JADX WARN: Code duplicated, block: B:168:0x02f3  */
    /* JADX WARN: Code duplicated, block: B:171:0x0377  */
    /* JADX WARN: Code duplicated, block: B:172:0x0379  */
    /* JADX WARN: Code duplicated, block: B:177:0x038c  */
    /* JADX WARN: Code duplicated, block: B:182:0x03ae  */
    /* JADX WARN: Code duplicated, block: B:183:0x03b0  */
    /* JADX WARN: Code duplicated, block: B:186:0x03b5  */
    /* JADX WARN: Code duplicated, block: B:187:0x03b7  */
    /* JADX WARN: Code duplicated, block: B:192:0x03d9  */
    /* JADX WARN: Code duplicated, block: B:197:0x03fa  */
    /* JADX WARN: Code duplicated, block: B:199:0x0402  */
    /* JADX WARN: Code duplicated, block: B:202:0x040f  */
    /* JADX WARN: Code duplicated, block: B:204:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:48:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:50:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:51:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:55:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:57:0x00df  */
    /* JADX WARN: Code duplicated, block: B:58:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:62:0x00ee  */
    /* JADX WARN: Code duplicated, block: B:64:0x00f4  */
    /* JADX WARN: Code duplicated, block: B:65:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:69:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:71:0x0105  */
    /* JADX WARN: Code duplicated, block: B:72:0x0108  */
    /* JADX WARN: Code duplicated, block: B:76:0x0110  */
    /* JADX WARN: Code duplicated, block: B:78:0x0116  */
    /* JADX WARN: Code duplicated, block: B:79:0x0119  */
    /* JADX WARN: Code duplicated, block: B:83:0x0121  */
    /* JADX WARN: Code duplicated, block: B:85:0x0127  */
    /* JADX WARN: Code duplicated, block: B:86:0x012a  */
    /* JADX WARN: Code duplicated, block: B:88:0x012f  */
    /* JADX WARN: Code duplicated, block: B:91:0x0134  */
    /* JADX WARN: Code duplicated, block: B:93:0x013a  */
    /* JADX WARN: Code duplicated, block: B:97:0x0142  */
    /* JADX WARN: Code duplicated, block: B:99:0x0148  */
    /* JADX WARN: Multi-variable type inference failed */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void CameraPager(Modifier modifier, final CameraParams cameraParams, final boolean z10, final boolean z11, boolean z12, final boolean z13, final long j10, final boolean z14, final Function2 sendVideos, final Function2 sendImages, final lb.a onDelete, final lb.a onClose, final lb.a onError, final Function1 changeIsVideo, Composer composer, final int i10, final int i11, final int i12) {
        int i13;
        boolean z15;
        int i14;
        int i15;
        int i16;
        boolean z16;
        Composer composer2;
        final Modifier modifier2;
        final boolean z17;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier modifier3;
        lb.a constructor;
        Integer type;
        int iIntValue;
        Object objRememberedValue;
        Composer.Companion companion;
        final PagerState pagerStateRememberPagerState;
        int i17;
        boolean z18;
        Object objRememberedValue2;
        final MutableState mutableState;
        Object objRememberedValue3;
        boolean z19;
        Object objRememberedValue4;
        final MutableState mutableState2;
        Object objRememberedValue5;
        final pe.m0 m0Var;
        Object objRememberedValue6;
        Object objRememberedValue7;
        int i18;
        int i19;
        int i20;
        int i21;
        final MutableState mutableState3;
        Object cameraKt$CameraPager$1$2$1;
        final MutableState mutableState4;
        final PagerState pagerState;
        int i22;
        int i23;
        boolean z20;
        Object objRememberedValue8;
        int i24;
        int i25;
        int i26;
        int i27;
        int i28;
        int i29;
        kotlin.jvm.internal.y.i(cameraParams, "cameraParams");
        kotlin.jvm.internal.y.i(sendVideos, "sendVideos");
        kotlin.jvm.internal.y.i(sendImages, "sendImages");
        kotlin.jvm.internal.y.i(onDelete, "onDelete");
        kotlin.jvm.internal.y.i(onClose, "onClose");
        kotlin.jvm.internal.y.i(onError, "onError");
        kotlin.jvm.internal.y.i(changeIsVideo, "changeIsVideo");
        Composer composerStartRestartGroup = composer.startRestartGroup(1532785848);
        int i30 = i12 & 1;
        if (i30 != 0) {
            i13 = i10 | 6;
        } else if ((i10 & 6) == 0) {
            i13 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i10;
        } else {
            i13 = i10;
        }
        if ((i10 & 48) == 0) {
            i13 |= composerStartRestartGroup.changed(cameraParams) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i13 |= composerStartRestartGroup.changed(z10) ? 256 : 128;
        }
        if ((i10 & 3072) == 0) {
            i13 |= composerStartRestartGroup.changed(z11) ? 2048 : 1024;
        }
        int i31 = i12 & 16;
        if (i31 == 0) {
            if ((i10 & 24576) == 0) {
                z15 = z12;
                i13 |= composerStartRestartGroup.changed(z15) ? 16384 : 8192;
            }
            if ((i10 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                if (composerStartRestartGroup.changed(z13)) {
                    i29 = 131072;
                } else {
                    i29 = 65536;
                }
                i13 |= i29;
            }
            if ((i10 & 1572864) == 0) {
                if (composerStartRestartGroup.changed(j10)) {
                    i28 = 1048576;
                } else {
                    i28 = 524288;
                }
                i13 |= i28;
            }
            if ((i10 & 12582912) == 0) {
                if (composerStartRestartGroup.changed(z14)) {
                    i27 = 8388608;
                } else {
                    i27 = 4194304;
                }
                i13 |= i27;
            }
            if ((100663296 & i10) == 0) {
                if (composerStartRestartGroup.changedInstance(sendVideos)) {
                    i26 = 67108864;
                } else {
                    i26 = 33554432;
                }
                i13 |= i26;
            }
            if ((805306368 & i10) == 0) {
                if (composerStartRestartGroup.changedInstance(sendImages)) {
                    i25 = C.BUFFER_FLAG_LAST_SAMPLE;
                } else {
                    i25 = 268435456;
                }
                i13 |= i25;
            }
            i14 = i13;
            if ((i11 & 6) == 0) {
                if (composerStartRestartGroup.changedInstance(onDelete)) {
                    i24 = 4;
                } else {
                    i24 = 2;
                }
                i15 = i11 | i24;
            } else {
                i15 = i11;
            }
            if ((i11 & 48) == 0) {
                i15 |= composerStartRestartGroup.changedInstance(onClose) ? 32 : 16;
            }
            if ((i11 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                i15 |= composerStartRestartGroup.changedInstance(onError) ? 256 : 128;
            }
            if ((i11 & 3072) == 0) {
                i15 |= composerStartRestartGroup.changedInstance(changeIsVideo) ? 2048 : 1024;
            }
            i16 = i15;
            if ((306783379 & i14) == 306783378 || (i16 & 1171) != 1170) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z16, i14 & 1)) {
                if (i30 != 0) {
                    modifier3 = Modifier.INSTANCE;
                } else {
                    modifier3 = modifier;
                }
                if (i31 != 0) {
                    z15 = false;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1532785848, i14, i16, "cu.todus.android.uiCompose.shared.camera.CameraPager (Camera.kt:263)");
                }
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier3);
                ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                Modifier modifier4 = modifier3;
                constructor = companion2.getConstructor();
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
                final boolean z21 = z15;
                Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, companion2.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
                Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion2.getSetCompositeKeyHash());
                Updater.m5182reconcileimpl(composerM5176constructorimpl, companion2.getApplyOnDeactivatedNodeAssertion());
                Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion2.getSetModifier());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                type = cameraParams.getType();
                if (type != null) {
                    iIntValue = type.intValue();
                } else {
                    iIntValue = 0;
                }
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                companion = Composer.INSTANCE;
                if (objRememberedValue == companion.getEmpty()) {
                    objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.t0
                        @Override // lb.a
                        public final Object invoke() {
                            return Integer.valueOf(CameraKt.CameraPager$lambda$0$0$0());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                pagerStateRememberPagerState = PagerStateKt.rememberPagerState(iIntValue, 0.0f, (lb.a) objRememberedValue, composerStartRestartGroup, RendererCapabilities.DECODER_SUPPORT_MASK, 2);
                Object[] objArr = new Object[0];
                i17 = i14 & 112;
                if (i17 == 32) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (z18 || objRememberedValue2 == companion.getEmpty()) {
                    objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.u0
                        @Override // lb.a
                        public final Object invoke() {
                            return CameraKt.CameraPager$lambda$0$1$0(cameraParams);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                mutableState = (MutableState) RememberSaveableKt.rememberSaveable(objArr, (lb.a) objRememberedValue2, composerStartRestartGroup, 0);
                Object[] objArr2 = new Object[0];
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue3 == companion.getEmpty()) {
                    objRememberedValue3 = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.v0
                        @Override // lb.a
                        public final Object invoke() {
                            return CameraKt.CameraPager$lambda$0$4$0();
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                final MutableFloatState mutableFloatState = (MutableFloatState) RememberSaveableKt.rememberSaveable(objArr2, (lb.a) objRememberedValue3, composerStartRestartGroup, 48);
                Object[] objArr3 = new Object[0];
                if (i17 == 32) {
                    z19 = true;
                } else {
                    z19 = false;
                }
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (z19 || objRememberedValue4 == companion.getEmpty()) {
                    objRememberedValue4 = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.w0
                        @Override // lb.a
                        public final Object invoke() {
                            return CameraKt.CameraPager$lambda$0$7$0(cameraParams);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                mutableState2 = (MutableState) RememberSaveableKt.rememberSaveable(objArr3, (lb.a) objRememberedValue4, composerStartRestartGroup, 0);
                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue5 == companion.getEmpty()) {
                    objRememberedValue5 = EffectsKt.createCompositionCoroutineScope(ab.j.f643c, composerStartRestartGroup);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                m0Var = (pe.m0) objRememberedValue5;
                objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue6 == companion.getEmpty()) {
                    objRememberedValue6 = DirectoryPaths.INSTANCE.getInstance().getNewImageFile(false).getPath();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                }
                final String str = (String) objRememberedValue6;
                objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue7 == companion.getEmpty()) {
                    String path = DirectoryPaths.INSTANCE.getInstance().getNewVideoFile(false).getPath();
                    composerStartRestartGroup.updateRememberedValue(path);
                    objRememberedValue7 = path;
                    i18 = 0;
                } else {
                    i18 = 0;
                }
                final String str2 = (String) objRememberedValue7;
                i19 = i18;
                PagerKt.m1961HorizontalPager8jOkeI(pagerStateRememberPagerState, null, null, null, 0, 0.0f, null, null, false, false, null, null, null, null, ComposableLambdaKt.rememberComposableLambda(988274495, true, new lb.o() { // from class: cu.todus.android.uiCompose.shared.camera.x0
                    @Override // lb.o
                    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        return CameraKt.CameraPager$lambda$0$12(str, str2, z10, z21, mutableFloatState, mutableState2, m0Var, pagerStateRememberPagerState, mutableState, onDelete, onClose, onError, z14, changeIsVideo, z11, z13, sendImages, j10, sendVideos, (PagerScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 100663296, 24576, 16126);
                composer2 = composerStartRestartGroup;
                Integer numValueOf = Integer.valueOf(pagerStateRememberPagerState.getCurrentPage());
                int i32 = (composer2.changed(pagerStateRememberPagerState) ? 1 : 0) | (composer2.changed(mutableState) ? 1 : 0);
                if ((i16 & 896) == 256) {
                    i20 = 1;
                } else {
                    i20 = i19;
                }
                i21 = i32 | i20 | (composer2.changed(mutableState2) ? 1 : 0);
                Object objRememberedValue9 = composer2.rememberedValue();
                if (i21 == 0 || objRememberedValue9 == companion.getEmpty()) {
                    mutableState3 = mutableState;
                    mutableState4 = mutableState2;
                    pagerState = pagerStateRememberPagerState;
                    cameraKt$CameraPager$1$2$1 = new CameraKt$CameraPager$1$2$1(pagerState, onError, mutableState3, mutableState4, null);
                    composer2.updateRememberedValue(cameraKt$CameraPager$1$2$1);
                } else {
                    mutableState3 = mutableState;
                    cameraKt$CameraPager$1$2$1 = objRememberedValue9;
                    mutableState4 = mutableState2;
                    pagerState = pagerStateRememberPagerState;
                }
                EffectsKt.LaunchedEffect(numValueOf, (Function2) cameraKt$CameraPager$1$2$1, composer2, i19);
                if (i17 == 32) {
                    i22 = 1;
                } else {
                    i22 = i19;
                }
                if ((i16 & 112) == 32) {
                    i23 = 1;
                } else {
                    i23 = i19;
                }
                z20 = (((((i22 | i23) | (composer2.changed(pagerState) ? 1 : 0)) == true ? 1 : 0) | (composer2.changed(mutableState3) ? 1 : 0)) | (composer2.changed(mutableState4) ? 1 : 0) ? 1 : 0) | (composer2.changedInstance(r3) ? 1 : 0);
                objRememberedValue8 = composer2.rememberedValue();
                if (z20 == 0 || objRememberedValue8 == companion.getEmpty()) {
                    lb.a aVar = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.y0
                        @Override // lb.a
                        public final Object invoke() {
                            return CameraKt.CameraPager$lambda$0$14$0(cameraParams, onClose, pagerState, m0Var, mutableState3, mutableState4);
                        }
                    };
                    composer2.updateRememberedValue(aVar);
                    objRememberedValue8 = aVar;
                }
                BackHandlerKt.BackHandler(i19, (lb.a) objRememberedValue8, composer2, i19, 1);
                composer2.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = modifier4;
                z17 = z21;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier2 = modifier;
                z17 = z15;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.shared.camera.z0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return CameraKt.CameraPager$lambda$1(modifier2, cameraParams, z10, z11, z17, z13, j10, z14, sendVideos, sendImages, onDelete, onClose, onError, changeIsVideo, i10, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i13 |= 24576;
        z15 = z12;
        if ((i10 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            if (composerStartRestartGroup.changed(z13)) {
                i29 = 131072;
            } else {
                i29 = 65536;
            }
            i13 |= i29;
        }
        if ((i10 & 1572864) == 0) {
            if (composerStartRestartGroup.changed(j10)) {
                i28 = 1048576;
            } else {
                i28 = 524288;
            }
            i13 |= i28;
        }
        if ((i10 & 12582912) == 0) {
            if (composerStartRestartGroup.changed(z14)) {
                i27 = 8388608;
            } else {
                i27 = 4194304;
            }
            i13 |= i27;
        }
        if ((100663296 & i10) == 0) {
            if (composerStartRestartGroup.changedInstance(sendVideos)) {
                i26 = 67108864;
            } else {
                i26 = 33554432;
            }
            i13 |= i26;
        }
        if ((805306368 & i10) == 0) {
            if (composerStartRestartGroup.changedInstance(sendImages)) {
                i25 = C.BUFFER_FLAG_LAST_SAMPLE;
            } else {
                i25 = 268435456;
            }
            i13 |= i25;
        }
        i14 = i13;
        if ((i11 & 6) == 0) {
            if (composerStartRestartGroup.changedInstance(onDelete)) {
                i24 = 4;
            } else {
                i24 = 2;
            }
            i15 = i11 | i24;
        } else {
            i15 = i11;
        }
        if ((i11 & 48) == 0) {
            i15 |= composerStartRestartGroup.changedInstance(onClose) ? 32 : 16;
        }
        if ((i11 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i15 |= composerStartRestartGroup.changedInstance(onError) ? 256 : 128;
        }
        if ((i11 & 3072) == 0) {
            i15 |= composerStartRestartGroup.changedInstance(changeIsVideo) ? 2048 : 1024;
        }
        i16 = i15;
        if ((306783379 & i14) == 306783378) {
            z16 = true;
        } else {
            z16 = true;
        }
        if (composerStartRestartGroup.shouldExecute(z16, i14 & 1)) {
            if (i30 != 0) {
                modifier3 = Modifier.INSTANCE;
            } else {
                modifier3 = modifier;
            }
            if (i31 != 0) {
                z15 = false;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1532785848, i14, i16, "cu.todus.android.uiCompose.shared.camera.CameraPager (Camera.kt:263)");
            }
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            int iA2 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier3);
            ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
            Modifier modifier5 = modifier3;
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
            Composer composerM5176constructorimpl2 = Updater.m5176constructorimpl(composerStartRestartGroup);
            final boolean z22 = z15;
            Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy2, companion3.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl2, Integer.valueOf(iA2), companion3.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl2, companion3.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier2, companion3.getSetModifier());
            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
            type = cameraParams.getType();
            if (type != null) {
                iIntValue = type.intValue();
            } else {
                iIntValue = 0;
            }
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            companion = Composer.INSTANCE;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.t0
                    @Override // lb.a
                    public final Object invoke() {
                        return Integer.valueOf(CameraKt.CameraPager$lambda$0$0$0());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            pagerStateRememberPagerState = PagerStateKt.rememberPagerState(iIntValue, 0.0f, (lb.a) objRememberedValue, composerStartRestartGroup, RendererCapabilities.DECODER_SUPPORT_MASK, 2);
            Object[] objArr4 = new Object[0];
            i17 = i14 & 112;
            if (i17 == 32) {
                z18 = true;
            } else {
                z18 = false;
            }
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (z18) {
                objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.u0
                    @Override // lb.a
                    public final Object invoke() {
                        return CameraKt.CameraPager$lambda$0$1$0(cameraParams);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            } else {
                objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.u0
                    @Override // lb.a
                    public final Object invoke() {
                        return CameraKt.CameraPager$lambda$0$1$0(cameraParams);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            mutableState = (MutableState) RememberSaveableKt.rememberSaveable(objArr4, (lb.a) objRememberedValue2, composerStartRestartGroup, 0);
            Object[] objArr5 = new Object[0];
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == companion.getEmpty()) {
                objRememberedValue3 = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.v0
                    @Override // lb.a
                    public final Object invoke() {
                        return CameraKt.CameraPager$lambda$0$4$0();
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            final MutableFloatState mutableFloatState2 = (MutableFloatState) RememberSaveableKt.rememberSaveable(objArr5, (lb.a) objRememberedValue3, composerStartRestartGroup, 48);
            Object[] objArr6 = new Object[0];
            if (i17 == 32) {
                z19 = true;
            } else {
                z19 = false;
            }
            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (z19) {
                objRememberedValue4 = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.w0
                    @Override // lb.a
                    public final Object invoke() {
                        return CameraKt.CameraPager$lambda$0$7$0(cameraParams);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            } else {
                objRememberedValue4 = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.w0
                    @Override // lb.a
                    public final Object invoke() {
                        return CameraKt.CameraPager$lambda$0$7$0(cameraParams);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            mutableState2 = (MutableState) RememberSaveableKt.rememberSaveable(objArr6, (lb.a) objRememberedValue4, composerStartRestartGroup, 0);
            objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue5 == companion.getEmpty()) {
                objRememberedValue5 = EffectsKt.createCompositionCoroutineScope(ab.j.f643c, composerStartRestartGroup);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            }
            m0Var = (pe.m0) objRememberedValue5;
            objRememberedValue6 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue6 == companion.getEmpty()) {
                objRememberedValue6 = DirectoryPaths.INSTANCE.getInstance().getNewImageFile(false).getPath();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
            }
            final String str3 = (String) objRememberedValue6;
            objRememberedValue7 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue7 == companion.getEmpty()) {
                String path2 = DirectoryPaths.INSTANCE.getInstance().getNewVideoFile(false).getPath();
                composerStartRestartGroup.updateRememberedValue(path2);
                objRememberedValue7 = path2;
                i18 = 0;
            } else {
                i18 = 0;
            }
            final String str4 = (String) objRememberedValue7;
            i19 = i18;
            PagerKt.m1961HorizontalPager8jOkeI(pagerStateRememberPagerState, null, null, null, 0, 0.0f, null, null, false, false, null, null, null, null, ComposableLambdaKt.rememberComposableLambda(988274495, true, new lb.o() { // from class: cu.todus.android.uiCompose.shared.camera.x0
                @Override // lb.o
                public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    return CameraKt.CameraPager$lambda$0$12(str3, str4, z10, z22, mutableFloatState2, mutableState2, m0Var, pagerStateRememberPagerState, mutableState, onDelete, onClose, onError, z14, changeIsVideo, z11, z13, sendImages, j10, sendVideos, (PagerScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 100663296, 24576, 16126);
            composer2 = composerStartRestartGroup;
            Integer numValueOf2 = Integer.valueOf(pagerStateRememberPagerState.getCurrentPage());
            int i33 = (composer2.changed(pagerStateRememberPagerState) ? 1 : 0) | (composer2.changed(mutableState) ? 1 : 0);
            if ((i16 & 896) == 256) {
                i20 = 1;
            } else {
                i20 = i19;
            }
            i21 = i33 | i20 | (composer2.changed(mutableState2) ? 1 : 0);
            Object objRememberedValue10 = composer2.rememberedValue();
            if (i21 == 0) {
                mutableState3 = mutableState;
                mutableState4 = mutableState2;
                pagerState = pagerStateRememberPagerState;
                cameraKt$CameraPager$1$2$1 = new CameraKt$CameraPager$1$2$1(pagerState, onError, mutableState3, mutableState4, null);
                composer2.updateRememberedValue(cameraKt$CameraPager$1$2$1);
            } else {
                mutableState3 = mutableState;
                mutableState4 = mutableState2;
                pagerState = pagerStateRememberPagerState;
                cameraKt$CameraPager$1$2$1 = new CameraKt$CameraPager$1$2$1(pagerState, onError, mutableState3, mutableState4, null);
                composer2.updateRememberedValue(cameraKt$CameraPager$1$2$1);
            }
            EffectsKt.LaunchedEffect(numValueOf2, (Function2) cameraKt$CameraPager$1$2$1, composer2, i19);
            if (i17 == 32) {
                i22 = 1;
            } else {
                i22 = i19;
            }
            if ((i16 & 112) == 32) {
                i23 = 1;
            } else {
                i23 = i19;
            }
            z20 = (((((i22 | i23) | (composer2.changed(pagerState) ? 1 : 0)) == true ? 1 : 0) | (composer2.changed(mutableState3) ? 1 : 0)) | (composer2.changed(mutableState4) ? 1 : 0) ? 1 : 0) | (composer2.changedInstance(r3) ? 1 : 0);
            objRememberedValue8 = composer2.rememberedValue();
            if (z20 == 0) {
                lb.a aVar2 = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.y0
                    @Override // lb.a
                    public final Object invoke() {
                        return CameraKt.CameraPager$lambda$0$14$0(cameraParams, onClose, pagerState, m0Var, mutableState3, mutableState4);
                    }
                };
                composer2.updateRememberedValue(aVar2);
                objRememberedValue8 = aVar2;
            } else {
                lb.a aVar3 = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.y0
                    @Override // lb.a
                    public final Object invoke() {
                        return CameraKt.CameraPager$lambda$0$14$0(cameraParams, onClose, pagerState, m0Var, mutableState3, mutableState4);
                    }
                };
                composer2.updateRememberedValue(aVar3);
                objRememberedValue8 = aVar3;
            }
            BackHandlerKt.BackHandler(i19, (lb.a) objRememberedValue8, composer2, i19, 1);
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier5;
            z17 = z22;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            modifier2 = modifier;
            z17 = z15;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.shared.camera.z0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CameraKt.CameraPager$lambda$1(modifier2, cameraParams, z10, z11, z17, z13, j10, z14, sendVideos, sendImages, onDelete, onClose, onError, changeIsVideo, i10, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int CameraPager$lambda$0$0$0() {
        return 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MutableState CameraPager$lambda$0$1$0(CameraParams cameraParams) {
        Integer type = cameraParams.getType();
        return SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((type == null || type.intValue() != 1 || cameraParams.getInitialPath() == null) ? "" : cameraParams.getInitialPath(), null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 CameraPager$lambda$0$12(String str, String str2, boolean z10, boolean z11, final MutableFloatState mutableFloatState, final MutableState mutableState, final pe.m0 m0Var, final PagerState pagerState, final MutableState mutableState2, final lb.a aVar, lb.a aVar2, lb.a aVar3, boolean z12, Function1 function1, boolean z13, boolean z14, final Function2 function2, long j10, final Function2 function3, PagerScope HorizontalPager, int i10, Composer composer, int i11) {
        Composer composer2 = composer;
        kotlin.jvm.internal.y.i(HorizontalPager, "$this$HorizontalPager");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(988274495, i11, -1, "cu.todus.android.uiCompose.shared.camera.CameraPager.<anonymous>.<anonymous> (Camera.kt:300)");
        }
        if (i10 == 0) {
            composer2.startReplaceGroup(-315236999);
            kotlin.jvm.internal.y.f(str);
            kotlin.jvm.internal.y.f(str2);
            boolean zChanged = composer2.changed(mutableFloatState) | composer2.changed(mutableState) | composer2.changedInstance(m0Var) | composer2.changed(pagerState) | composer2.changed(mutableState2) | composer2.changed(aVar);
            Object objRememberedValue = composer2.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                lb.o oVar = new lb.o() { // from class: cu.todus.android.uiCompose.shared.camera.z
                    @Override // lb.o
                    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        return CameraKt.CameraPager$lambda$0$12$0$0(m0Var, aVar, mutableFloatState, mutableState, pagerState, mutableState2, (String) obj, (ResultType) obj2, ((Long) obj3).longValue(), ((Float) obj4).floatValue());
                    }
                };
                composer2.updateRememberedValue(oVar);
                objRememberedValue = oVar;
            }
            CameraViewPage(z10, z11, str, str2, (lb.o) objRememberedValue, aVar2, aVar3, z12, function1, composer2, 0, 0);
            composer2 = composer2;
            composer2.endReplaceGroup();
        } else {
            composer2.startReplaceGroup(-313921917);
            composer2.endReplaceGroup();
        }
        if (i10 == 1) {
            composer2.startReplaceGroup(-313864939);
            String strCameraPager$lambda$0$2 = CameraPager$lambda$0$2(mutableState2);
            kotlin.jvm.internal.y.f(str);
            float floatValue = mutableFloatState.getFloatValue();
            boolean zChanged2 = composer2.changed(function2);
            Object objRememberedValue2 = composer2.rememberedValue();
            if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function2() { // from class: cu.todus.android.uiCompose.shared.camera.a0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return CameraKt.CameraPager$lambda$0$12$1$0(function2, (String) obj, (String) obj2);
                    }
                };
                composer2.updateRememberedValue(objRememberedValue2);
            }
            Function2 function4 = (Function2) objRememberedValue2;
            boolean zChanged3 = composer2.changed(mutableState2) | composer2.changedInstance(m0Var) | composer2.changed(pagerState);
            Object objRememberedValue3 = composer2.rememberedValue();
            if (zChanged3 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.b0
                    @Override // lb.a
                    public final Object invoke() {
                        return CameraKt.CameraPager$lambda$0$12$2$0(m0Var, mutableState2, pagerState);
                    }
                };
                composer2.updateRememberedValue(objRememberedValue3);
            }
            lb.a aVar4 = (lb.a) objRememberedValue3;
            boolean zChangedInstance = composer2.changedInstance(m0Var) | composer2.changed(pagerState);
            Object objRememberedValue4 = composer2.rememberedValue();
            if (zChangedInstance || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.c0
                    @Override // lb.a
                    public final Object invoke() {
                        return CameraKt.CameraPager$lambda$0$12$3$0(m0Var, pagerState);
                    }
                };
                composer2.updateRememberedValue(objRememberedValue4);
            }
            Composer composer3 = composer2;
            ImageEditorViewPage(z13, strCameraPager$lambda$0$2, str, z14, floatValue, function4, aVar4, (lb.a) objRememberedValue4, composer3, 0);
            composer2 = composer3;
            composer2.endReplaceGroup();
        } else {
            composer2.startReplaceGroup(-312990429);
            composer2.endReplaceGroup();
        }
        if (i10 == 2) {
            composer2.startReplaceGroup(-312937202);
            String first = CameraPager$lambda$0$8(mutableState).getFirst();
            kotlin.jvm.internal.y.f(str2);
            long jLongValue = CameraPager$lambda$0$8(mutableState).getSecond().longValue();
            boolean zChanged4 = composer2.changed(function3);
            Object objRememberedValue5 = composer2.rememberedValue();
            if (zChanged4 || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue5 = new Function2() { // from class: cu.todus.android.uiCompose.shared.camera.d0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return CameraKt.CameraPager$lambda$0$12$4$0(function3, (String) obj, (String) obj2);
                    }
                };
                composer2.updateRememberedValue(objRememberedValue5);
            }
            Function2 function5 = (Function2) objRememberedValue5;
            boolean zChanged5 = composer2.changed(mutableState) | composer2.changedInstance(m0Var) | composer2.changed(pagerState);
            Object objRememberedValue6 = composer2.rememberedValue();
            if (zChanged5 || objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue6 = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.e0
                    @Override // lb.a
                    public final Object invoke() {
                        return CameraKt.CameraPager$lambda$0$12$5$0(m0Var, mutableState, pagerState);
                    }
                };
                composer2.updateRememberedValue(objRememberedValue6);
            }
            VideoEditorViewPage(z13, first, str2, jLongValue, j10, function5, (lb.a) objRememberedValue6, aVar3, composer2, 0);
            composer2.endReplaceGroup();
        } else {
            composer2.startReplaceGroup(-312178973);
            composer2.endReplaceGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 CameraPager$lambda$0$12$0$0(pe.m0 m0Var, lb.a aVar, MutableFloatState mutableFloatState, MutableState mutableState, PagerState pagerState, MutableState mutableState2, String path, ResultType resultType, long j10, float f10) {
        kotlin.jvm.internal.y.i(path, "path");
        kotlin.jvm.internal.y.i(resultType, "resultType");
        mutableFloatState.setFloatValue(f10);
        int i10 = WhenMappings.$EnumSwitchMapping$0[resultType.ordinal()];
        if (i10 == 1) {
            mutableState.setValue(ua.z.a(path, Long.valueOf(j10)));
            pe.k.d(m0Var, null, null, new CameraKt$CameraPager$1$1$1$1$1(pagerState, null), 3, null);
        } else if (i10 == 2) {
            mutableState2.setValue(path);
            pe.k.d(m0Var, null, null, new CameraKt$CameraPager$1$1$1$1$2(pagerState, null), 3, null);
        } else {
            if (i10 != 3) {
                throw new ua.r();
            }
            aVar.invoke();
            ua.k0 k0Var = ua.k0.f43947a;
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 CameraPager$lambda$0$12$1$0(Function2 function2, String path, String stringContent) {
        kotlin.jvm.internal.y.i(path, "path");
        kotlin.jvm.internal.y.i(stringContent, "stringContent");
        function2.invoke(va.v.e(new File(path)), stringContent);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 CameraPager$lambda$0$12$2$0(pe.m0 m0Var, MutableState mutableState, PagerState pagerState) {
        mutableState.setValue("");
        pe.k.d(m0Var, null, null, new CameraKt$CameraPager$1$1$3$1$1(pagerState, null), 3, null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 CameraPager$lambda$0$12$3$0(pe.m0 m0Var, PagerState pagerState) {
        pe.k.d(m0Var, null, null, new CameraKt$CameraPager$1$1$4$1$1(pagerState, null), 3, null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 CameraPager$lambda$0$12$4$0(Function2 function2, String path, String stringContent) {
        kotlin.jvm.internal.y.i(path, "path");
        kotlin.jvm.internal.y.i(stringContent, "stringContent");
        function2.invoke(va.v.e(new File(path)), stringContent);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 CameraPager$lambda$0$12$5$0(pe.m0 m0Var, MutableState mutableState, PagerState pagerState) {
        mutableState.setValue(ua.z.a("", 0L));
        pe.k.d(m0Var, null, null, new CameraKt$CameraPager$1$1$6$1$1(pagerState, null), 3, null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 CameraPager$lambda$0$14$0(CameraParams cameraParams, lb.a aVar, PagerState pagerState, pe.m0 m0Var, MutableState mutableState, MutableState mutableState2) {
        if (cameraParams.getType() != null) {
            aVar.invoke();
        } else if (!pagerState.isScrollInProgress() && pagerState.getCurrentPage() == 0) {
            aVar.invoke();
        } else if (!pagerState.isScrollInProgress() && pagerState.getCurrentPage() == 1) {
            mutableState.setValue("");
            mutableState2.setValue(ua.z.a("", 0L));
            pe.k.d(m0Var, null, null, new CameraKt$CameraPager$1$3$1$1(pagerState, null), 3, null);
        } else if (!pagerState.isScrollInProgress() && pagerState.getCurrentPage() == 2) {
            mutableState.setValue("");
            mutableState2.setValue(ua.z.a("", 0L));
            pe.k.d(m0Var, null, null, new CameraKt$CameraPager$1$3$1$2(pagerState, null), 3, null);
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String CameraPager$lambda$0$2(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MutableFloatState CameraPager$lambda$0$4$0() {
        return PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MutableState CameraPager$lambda$0$7$0(CameraParams cameraParams) {
        long jValueOf;
        String initialPath;
        Integer type = cameraParams.getType();
        if (type == null || type.intValue() != 2 || cameraParams.getInitialPath() == null) {
            jValueOf = 0L;
            initialPath = "";
        } else {
            initialPath = cameraParams.getInitialPath();
            jValueOf = Long.valueOf(cameraParams.getVideoDuration());
        }
        return SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(ua.z.a(initialPath, jValueOf), null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Pair<String, Long> CameraPager$lambda$0$8(MutableState<Pair<String, Long>> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 CameraPager$lambda$1(Modifier modifier, CameraParams cameraParams, boolean z10, boolean z11, boolean z12, boolean z13, long j10, boolean z14, Function2 function2, Function2 function3, lb.a aVar, lb.a aVar2, lb.a aVar3, Function1 function1, int i10, int i11, int i12, Composer composer, int i13) {
        CameraPager(modifier, cameraParams, z10, z11, z12, z13, j10, z14, function2, function3, aVar, aVar2, aVar3, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), RecomposeScopeImplKt.updateChangedFlags(i11), i12);
        return ua.k0.f43947a;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0173  */
    /* JADX WARN: Code duplicated, block: B:103:0x01f8  */
    /* JADX WARN: Code duplicated, block: B:105:0x01fd  */
    /* JADX WARN: Code duplicated, block: B:108:0x0209  */
    /* JADX WARN: Code duplicated, block: B:110:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:23:0x0066  */
    /* JADX WARN: Code duplicated, block: B:25:0x006c  */
    /* JADX WARN: Code duplicated, block: B:26:0x006f  */
    /* JADX WARN: Code duplicated, block: B:30:0x0076  */
    /* JADX WARN: Code duplicated, block: B:32:0x007c  */
    /* JADX WARN: Code duplicated, block: B:33:0x007f  */
    /* JADX WARN: Code duplicated, block: B:37:0x0086  */
    /* JADX WARN: Code duplicated, block: B:39:0x008c  */
    /* JADX WARN: Code duplicated, block: B:40:0x008f  */
    /* JADX WARN: Code duplicated, block: B:44:0x0097  */
    /* JADX WARN: Code duplicated, block: B:46:0x009d  */
    /* JADX WARN: Code duplicated, block: B:47:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:51:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:53:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:54:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:58:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:60:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:61:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:63:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:66:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:68:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:69:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:73:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:74:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:77:0x00f0 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:78:0x00f2  */
    /* JADX WARN: Code duplicated, block: B:79:0x00f4  */
    /* JADX WARN: Code duplicated, block: B:82:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:85:0x012e  */
    /* JADX WARN: Code duplicated, block: B:86:0x0130  */
    /* JADX WARN: Code duplicated, block: B:91:0x0145  */
    /* JADX WARN: Code duplicated, block: B:94:0x0161  */
    /* JADX WARN: Code duplicated, block: B:95:0x0163  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void CameraViewPage(final boolean z10, boolean z11, final String imagePathToSave, final String videoPathToSave, final lb.o onResult, final lb.a onClose, final lb.a onError, final boolean z12, final Function1 changeIsVideo, Composer composer, final int i10, final int i11) {
        int i12;
        boolean z13;
        boolean z14;
        Composer composer2;
        final boolean z15;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        final boolean z16;
        final Context context;
        int i13;
        boolean z17;
        boolean zChangedInstance;
        Object objRememberedValue;
        boolean z18;
        boolean z19;
        Object objRememberedValue2;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        kotlin.jvm.internal.y.i(imagePathToSave, "imagePathToSave");
        kotlin.jvm.internal.y.i(videoPathToSave, "videoPathToSave");
        kotlin.jvm.internal.y.i(onResult, "onResult");
        kotlin.jvm.internal.y.i(onClose, "onClose");
        kotlin.jvm.internal.y.i(onError, "onError");
        kotlin.jvm.internal.y.i(changeIsVideo, "changeIsVideo");
        Composer composerStartRestartGroup = composer.startRestartGroup(-249591139);
        if ((i10 & 6) == 0) {
            i12 = (composerStartRestartGroup.changed(z10) ? 4 : 2) | i10;
        } else {
            i12 = i10;
        }
        int i21 = i11 & 2;
        if (i21 == 0) {
            if ((i10 & 48) == 0) {
                z13 = z11;
                i12 |= composerStartRestartGroup.changed(z13) ? 32 : 16;
            }
            if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                if (composerStartRestartGroup.changed(imagePathToSave)) {
                    i20 = 256;
                } else {
                    i20 = 128;
                }
                i12 |= i20;
            }
            if ((i10 & 3072) == 0) {
                if (composerStartRestartGroup.changed(videoPathToSave)) {
                    i19 = 2048;
                } else {
                    i19 = 1024;
                }
                i12 |= i19;
            }
            if ((i10 & 24576) == 0) {
                if (composerStartRestartGroup.changedInstance(onResult)) {
                    i18 = 16384;
                } else {
                    i18 = 8192;
                }
                i12 |= i18;
            }
            if ((196608 & i10) == 0) {
                if (composerStartRestartGroup.changedInstance(onClose)) {
                    i17 = 131072;
                } else {
                    i17 = 65536;
                }
                i12 |= i17;
            }
            if ((1572864 & i10) == 0) {
                if (composerStartRestartGroup.changedInstance(onError)) {
                    i16 = 1048576;
                } else {
                    i16 = 524288;
                }
                i12 |= i16;
            }
            if ((12582912 & i10) != 0) {
                if (composerStartRestartGroup.changed(z12)) {
                    i15 = 8388608;
                } else {
                    i15 = 4194304;
                }
                i12 |= i15;
            }
            if ((100663296 & i10) == 0) {
                if (composerStartRestartGroup.changedInstance(changeIsVideo)) {
                    i14 = 67108864;
                } else {
                    i14 = 33554432;
                }
                i12 |= i14;
            }
            if ((38347923 & i12) != 38347922) {
                z14 = true;
            } else {
                z14 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z14, i12 & 1)) {
                if (i21 != 0) {
                    z16 = false;
                } else {
                    z16 = z13;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-249591139, i12, -1, "cu.todus.android.uiCompose.shared.camera.CameraViewPage (Camera.kt:420)");
                }
                context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                BottomSheetScaffoldState bottomSheetScaffoldStateRememberBottomSheetScaffoldState = BottomSheetScaffoldKt.rememberBottomSheetScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                final int i22 = ((Configuration) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalConfiguration())).screenHeightDp;
                ActivityResultContracts.GetContent getContent = new ActivityResultContracts.GetContent();
                i13 = i12 & 57344;
                if (i13 == 16384) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                zChangedInstance = z17 | composerStartRestartGroup.changedInstance(context);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: cu.todus.android.uiCompose.shared.camera.a
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return CameraKt.CameraViewPage$lambda$0$0(onResult, context, (Uri) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                final ManagedActivityResultLauncher managedActivityResultLauncherRememberLauncherForActivityResult = ActivityResultRegistryKt.rememberLauncherForActivityResult(getContent, (Function1) objRememberedValue, composerStartRestartGroup, 0);
                ActivityResultContracts.GetContent getContent2 = new ActivityResultContracts.GetContent();
                boolean zChangedInstance2 = composerStartRestartGroup.changedInstance(context);
                if (i13 == 16384) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                z19 = z18 | zChangedInstance2;
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (z19 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new Function1() { // from class: cu.todus.android.uiCompose.shared.camera.l
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return CameraKt.CameraViewPage$lambda$1$0(context, onResult, (Uri) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                final ManagedActivityResultLauncher managedActivityResultLauncherRememberLauncherForActivityResult2 = ActivityResultRegistryKt.rememberLauncherForActivityResult(getContent2, (Function1) objRememberedValue2, composerStartRestartGroup, 0);
                Color.Companion companion = Color.INSTANCE;
                long jM5901getTransparent0d7_KjU = companion.m5901getTransparent0d7_KjU();
                long jM5901getTransparent0d7_KjU2 = companion.m5901getTransparent0d7_KjU();
                long jM5901getTransparent0d7_KjU3 = companion.m5901getTransparent0d7_KjU();
                long jM5901getTransparent0d7_KjU4 = companion.m5901getTransparent0d7_KjU();
                float f10 = 0;
                composer2 = composerStartRestartGroup;
                BottomSheetScaffoldKt.m2891BottomSheetScaffoldsdMYb0k(ComposableLambdaKt.rememberComposableLambda(485795372, true, new Function3() { // from class: cu.todus.android.uiCompose.shared.camera.w
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return CameraKt.CameraViewPage$lambda$2(i22, z12, onResult, context, z16, managedActivityResultLauncherRememberLauncherForActivityResult2, managedActivityResultLauncherRememberLauncherForActivityResult, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), null, bottomSheetScaffoldStateRememberBottomSheetScaffoldState, Dp.m8823constructorimpl(140), 0.0f, RectangleShapeKt.getRectangleShape(), jM5901getTransparent0d7_KjU, jM5901getTransparent0d7_KjU2, Dp.m8823constructorimpl(f10), Dp.m8823constructorimpl(f10), null, false, null, null, jM5901getTransparent0d7_KjU3, jM5901getTransparent0d7_KjU4, ComposableLambdaKt.rememberComposableLambda(1377650562, true, new Function3() { // from class: cu.todus.android.uiCompose.shared.camera.h0
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return CameraKt.CameraViewPage$lambda$3(imagePathToSave, videoPathToSave, z12, onClose, onResult, onError, z10, changeIsVideo, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composer2, 920325126, 1794054, 14354);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z15 = z16;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                z15 = z13;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.shared.camera.s0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return CameraKt.CameraViewPage$lambda$4(z10, z15, imagePathToSave, videoPathToSave, onResult, onClose, onError, z12, changeIsVideo, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i12 |= 48;
        z13 = z11;
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            if (composerStartRestartGroup.changed(imagePathToSave)) {
                i20 = 256;
            } else {
                i20 = 128;
            }
            i12 |= i20;
        }
        if ((i10 & 3072) == 0) {
            if (composerStartRestartGroup.changed(videoPathToSave)) {
                i19 = 2048;
            } else {
                i19 = 1024;
            }
            i12 |= i19;
        }
        if ((i10 & 24576) == 0) {
            if (composerStartRestartGroup.changedInstance(onResult)) {
                i18 = 16384;
            } else {
                i18 = 8192;
            }
            i12 |= i18;
        }
        if ((196608 & i10) == 0) {
            if (composerStartRestartGroup.changedInstance(onClose)) {
                i17 = 131072;
            } else {
                i17 = 65536;
            }
            i12 |= i17;
        }
        if ((1572864 & i10) == 0) {
            if (composerStartRestartGroup.changedInstance(onError)) {
                i16 = 1048576;
            } else {
                i16 = 524288;
            }
            i12 |= i16;
        }
        if ((12582912 & i10) != 0) {
            if (composerStartRestartGroup.changed(z12)) {
                i15 = 8388608;
            } else {
                i15 = 4194304;
            }
            i12 |= i15;
        }
        if ((100663296 & i10) == 0) {
            if (composerStartRestartGroup.changedInstance(changeIsVideo)) {
                i14 = 67108864;
            } else {
                i14 = 33554432;
            }
            i12 |= i14;
        }
        if ((38347923 & i12) != 38347922) {
            z14 = true;
        } else {
            z14 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z14, i12 & 1)) {
            if (i21 != 0) {
                z16 = false;
            } else {
                z16 = z13;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-249591139, i12, -1, "cu.todus.android.uiCompose.shared.camera.CameraViewPage (Camera.kt:420)");
            }
            context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
            BottomSheetScaffoldState bottomSheetScaffoldStateRememberBottomSheetScaffoldState2 = BottomSheetScaffoldKt.rememberBottomSheetScaffoldState(null, null, composerStartRestartGroup, 0, 3);
            final int i23 = ((Configuration) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalConfiguration())).screenHeightDp;
            ActivityResultContracts.GetContent getContent3 = new ActivityResultContracts.GetContent();
            i13 = i12 & 57344;
            if (i13 == 16384) {
                z17 = true;
            } else {
                z17 = false;
            }
            zChangedInstance = z17 | composerStartRestartGroup.changedInstance(context);
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance) {
                objRememberedValue = new Function1() { // from class: cu.todus.android.uiCompose.shared.camera.a
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return CameraKt.CameraViewPage$lambda$0$0(onResult, context, (Uri) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = new Function1() { // from class: cu.todus.android.uiCompose.shared.camera.a
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return CameraKt.CameraViewPage$lambda$0$0(onResult, context, (Uri) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final ManagedActivityResultLauncher managedActivityResultLauncherRememberLauncherForActivityResult3 = ActivityResultRegistryKt.rememberLauncherForActivityResult(getContent3, (Function1) objRememberedValue, composerStartRestartGroup, 0);
            ActivityResultContracts.GetContent getContent4 = new ActivityResultContracts.GetContent();
            boolean zChangedInstance3 = composerStartRestartGroup.changedInstance(context);
            if (i13 == 16384) {
                z18 = true;
            } else {
                z18 = false;
            }
            z19 = z18 | zChangedInstance3;
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (z19) {
                objRememberedValue2 = new Function1() { // from class: cu.todus.android.uiCompose.shared.camera.l
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return CameraKt.CameraViewPage$lambda$1$0(context, onResult, (Uri) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            } else {
                objRememberedValue2 = new Function1() { // from class: cu.todus.android.uiCompose.shared.camera.l
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return CameraKt.CameraViewPage$lambda$1$0(context, onResult, (Uri) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            final ManagedActivityResultLauncher managedActivityResultLauncherRememberLauncherForActivityResult4 = ActivityResultRegistryKt.rememberLauncherForActivityResult(getContent4, (Function1) objRememberedValue2, composerStartRestartGroup, 0);
            Color.Companion companion2 = Color.INSTANCE;
            long jM5901getTransparent0d7_KjU5 = companion2.m5901getTransparent0d7_KjU();
            long jM5901getTransparent0d7_KjU6 = companion2.m5901getTransparent0d7_KjU();
            long jM5901getTransparent0d7_KjU7 = companion2.m5901getTransparent0d7_KjU();
            long jM5901getTransparent0d7_KjU8 = companion2.m5901getTransparent0d7_KjU();
            float f11 = 0;
            composer2 = composerStartRestartGroup;
            BottomSheetScaffoldKt.m2891BottomSheetScaffoldsdMYb0k(ComposableLambdaKt.rememberComposableLambda(485795372, true, new Function3() { // from class: cu.todus.android.uiCompose.shared.camera.w
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return CameraKt.CameraViewPage$lambda$2(i23, z12, onResult, context, z16, managedActivityResultLauncherRememberLauncherForActivityResult4, managedActivityResultLauncherRememberLauncherForActivityResult3, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), null, bottomSheetScaffoldStateRememberBottomSheetScaffoldState2, Dp.m8823constructorimpl(140), 0.0f, RectangleShapeKt.getRectangleShape(), jM5901getTransparent0d7_KjU5, jM5901getTransparent0d7_KjU6, Dp.m8823constructorimpl(f11), Dp.m8823constructorimpl(f11), null, false, null, null, jM5901getTransparent0d7_KjU7, jM5901getTransparent0d7_KjU8, ComposableLambdaKt.rememberComposableLambda(1377650562, true, new Function3() { // from class: cu.todus.android.uiCompose.shared.camera.h0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return CameraKt.CameraViewPage$lambda$3(imagePathToSave, videoPathToSave, z12, onClose, onResult, onError, z10, changeIsVideo, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composer2, 920325126, 1794054, 14354);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            z15 = z16;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            z15 = z13;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.shared.camera.s0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CameraKt.CameraViewPage$lambda$4(z10, z15, imagePathToSave, videoPathToSave, onResult, onClose, onError, z12, changeIsVideo, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 CameraViewPage$lambda$0$0(lb.o oVar, Context context, Uri uri) {
        if (uri != null) {
            String path = MediaUtil.INSTANCE.getPath(context, uri);
            kotlin.jvm.internal.y.f(path);
            oVar.invoke(path, ResultType.PHOTO, 0L, Float.valueOf(0.0f));
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 CameraViewPage$lambda$1$0(Context context, lb.o oVar, Uri uri) {
        if (uri != null) {
            MediaUtil mediaUtil = MediaUtil.INSTANCE;
            String path = mediaUtil.getPath(context, uri);
            kotlin.jvm.internal.y.f(path);
            oVar.invoke(path, ResultType.VIDEO, Long.valueOf(mediaUtil.getDurationFromFile(context, new File(path)) * ((long) 1000)), Float.valueOf(0.0f));
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 CameraViewPage$lambda$2(int i10, boolean z10, final lb.o oVar, final Context context, boolean z11, final ManagedActivityResultLauncher managedActivityResultLauncher, final ManagedActivityResultLauncher managedActivityResultLauncher2, ColumnScope BottomSheetScaffold, Composer composer, int i11) {
        List listE;
        Composer composer2;
        List listE2;
        kotlin.jvm.internal.y.i(BottomSheetScaffold, "$this$BottomSheetScaffold");
        if (composer.shouldExecute((i11 & 17) != 16, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(485795372, i11, -1, "cu.todus.android.uiCompose.shared.camera.CameraViewPage.<anonymous> (Camera.kt:472)");
            }
            if (Build.VERSION.SDK_INT >= 30 ? Environment.isExternalStorageManager() : true) {
                composer.startReplaceGroup(-1709507207);
                Modifier.Companion companion = Modifier.INSTANCE;
                Modifier modifierM1755height3ABfNKs = SizeKt.m1755height3ABfNKs(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), Dp.m8823constructorimpl(140));
                Alignment.Companion companion2 = Alignment.INSTANCE;
                Alignment.Horizontal centerHorizontally = companion2.getCenterHorizontally();
                Arrangement arrangement = Arrangement.INSTANCE;
                MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(arrangement.getTop(), centerHorizontally, composer, 48);
                int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
                CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierM1755height3ABfNKs);
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
                ModalKt.ModalIndicator(composer, 0);
                if (z10) {
                    composer.startReplaceGroup(-779248408);
                    VideoAlbumConfiguration videoAlbumConfiguration = new VideoAlbumConfiguration(false);
                    boolean zChanged = composer.changed(oVar) | composer.changedInstance(context);
                    Object objRememberedValue = composer.rememberedValue();
                    if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function1() { // from class: cu.todus.android.uiCompose.shared.camera.j0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return CameraKt.CameraViewPage$lambda$2$0$0$0(oVar, context, (List) obj);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue);
                    }
                    Function1 function1 = (Function1) objRememberedValue;
                    if (z11) {
                        composer.startReplaceGroup(-779226650);
                        Icons.Outlined outlined = Icons.Outlined.INSTANCE;
                        ImageVector deleteOutline = DeleteOutlineKt.getDeleteOutline(outlined);
                        boolean zChanged2 = composer.changed(oVar);
                        Object objRememberedValue2 = composer.rememberedValue();
                        if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.k0
                                @Override // lb.a
                                public final Object invoke() {
                                    return CameraKt.CameraViewPage$lambda$2$0$1$0(oVar);
                                }
                            };
                            composer.updateRememberedValue(objRememberedValue2);
                        }
                        AlbumOption albumOption = new AlbumOption(deleteOutline, (lb.a) objRememberedValue2);
                        ImageVector folder = FolderKt.getFolder(outlined);
                        boolean zChangedInstance = composer.changedInstance(managedActivityResultLauncher);
                        Object objRememberedValue3 = composer.rememberedValue();
                        if (zChangedInstance || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue3 = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.l0
                                @Override // lb.a
                                public final Object invoke() {
                                    return CameraKt.CameraViewPage$lambda$2$0$2$0(managedActivityResultLauncher);
                                }
                            };
                            composer.updateRememberedValue(objRememberedValue3);
                        }
                        listE2 = va.w.q(albumOption, new AlbumOption(folder, (lb.a) objRememberedValue3));
                        composer.endReplaceGroup();
                    } else {
                        composer.startReplaceGroup(-779207045);
                        ImageVector folder2 = FolderKt.getFolder(Icons.Outlined.INSTANCE);
                        boolean zChangedInstance2 = composer.changedInstance(managedActivityResultLauncher);
                        Object objRememberedValue4 = composer.rememberedValue();
                        if (zChangedInstance2 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue4 = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.m0
                                @Override // lb.a
                                public final Object invoke() {
                                    return CameraKt.CameraViewPage$lambda$2$0$3$0(managedActivityResultLauncher);
                                }
                            };
                            composer.updateRememberedValue(objRememberedValue4);
                        }
                        listE2 = va.v.e(new AlbumOption(folder2, (lb.a) objRememberedValue4));
                        composer.endReplaceGroup();
                    }
                    List list = listE2;
                    boolean zChangedInstance3 = composer.changedInstance(context);
                    Object objRememberedValue5 = composer.rememberedValue();
                    if (zChangedInstance3 || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue5 = new Function1() { // from class: cu.todus.android.uiCompose.shared.camera.n0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return CameraKt.CameraViewPage$lambda$2$0$4$0(context, (String) obj);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue5);
                    }
                    Z17RowVideoAlbumKt.m10328Z17RowVideoAlbumPfoAEA0(null, videoAlbumConfiguration, function1, list, null, 0.0f, (Function1) objRememberedValue5, composer, VideoAlbumConfiguration.$stable << 3, 49);
                    composer2 = composer;
                    composer2.endReplaceGroup();
                } else {
                    composer.startReplaceGroup(-779189290);
                    AlbumConfiguration albumConfiguration = new AlbumConfiguration(false);
                    boolean zChanged3 = composer.changed(oVar) | composer.changedInstance(context);
                    Object objRememberedValue6 = composer.rememberedValue();
                    if (zChanged3 || objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue6 = new Function1() { // from class: cu.todus.android.uiCompose.shared.camera.o0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return CameraKt.CameraViewPage$lambda$2$0$5$0(oVar, context, (List) obj);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue6);
                    }
                    Function1 function2 = (Function1) objRememberedValue6;
                    if (z11) {
                        composer.startReplaceGroup(-779168218);
                        Icons.Outlined outlined2 = Icons.Outlined.INSTANCE;
                        ImageVector deleteOutline2 = DeleteOutlineKt.getDeleteOutline(outlined2);
                        boolean zChanged4 = composer.changed(oVar);
                        Object objRememberedValue7 = composer.rememberedValue();
                        if (zChanged4 || objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue7 = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.p0
                                @Override // lb.a
                                public final Object invoke() {
                                    return CameraKt.CameraViewPage$lambda$2$0$6$0(oVar);
                                }
                            };
                            composer.updateRememberedValue(objRememberedValue7);
                        }
                        AlbumOption albumOption2 = new AlbumOption(deleteOutline2, (lb.a) objRememberedValue7);
                        ImageVector folder3 = FolderKt.getFolder(outlined2);
                        boolean zChangedInstance4 = composer.changedInstance(managedActivityResultLauncher2);
                        Object objRememberedValue8 = composer.rememberedValue();
                        if (zChangedInstance4 || objRememberedValue8 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue8 = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.q0
                                @Override // lb.a
                                public final Object invoke() {
                                    return CameraKt.CameraViewPage$lambda$2$0$7$0(managedActivityResultLauncher2);
                                }
                            };
                            composer.updateRememberedValue(objRememberedValue8);
                        }
                        listE = va.w.q(albumOption2, new AlbumOption(folder3, (lb.a) objRememberedValue8));
                        composer.endReplaceGroup();
                    } else {
                        composer.startReplaceGroup(-779148613);
                        ImageVector folder4 = FolderKt.getFolder(Icons.Outlined.INSTANCE);
                        boolean zChangedInstance5 = composer.changedInstance(managedActivityResultLauncher2);
                        Object objRememberedValue9 = composer.rememberedValue();
                        if (zChangedInstance5 || objRememberedValue9 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue9 = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.r0
                                @Override // lb.a
                                public final Object invoke() {
                                    return CameraKt.CameraViewPage$lambda$2$0$8$0(managedActivityResultLauncher2);
                                }
                            };
                            composer.updateRememberedValue(objRememberedValue9);
                        }
                        listE = va.v.e(new AlbumOption(folder4, (lb.a) objRememberedValue9));
                        composer.endReplaceGroup();
                    }
                    Z17RowAlbumKt.m10297Z17RowAlbumHYR8e34(null, albumConfiguration, function2, listE, null, 0.0f, composer, AlbumConfiguration.$stable << 3, 49);
                    composer2 = composer;
                    composer2.endReplaceGroup();
                }
                composer2.endNode();
                Modifier modifierM1755height3ABfNKs2 = SizeKt.m1755height3ABfNKs(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), Dp.m8823constructorimpl(i10));
                MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(arrangement.getTop(), companion2.getCenterHorizontally(), composer2, 48);
                int iA2 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
                CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer2, modifierM1755height3ABfNKs2);
                lb.a constructor2 = companion3.getConstructor();
                if (!defpackage.r.a(composer2.getApplier())) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor2);
                } else {
                    composer2.useNode();
                }
                Composer composerM5176constructorimpl2 = Updater.m5176constructorimpl(composer2);
                Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyColumnMeasurePolicy2, companion3.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
                Updater.m5180initimpl(composerM5176constructorimpl2, Integer.valueOf(iA2), companion3.getSetCompositeKeyHash());
                Updater.m5182reconcileimpl(composerM5176constructorimpl2, companion3.getApplyOnDeactivatedNodeAssertion());
                Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier2, companion3.getSetModifier());
                if (z10) {
                    composer2.startReplaceGroup(1833562585);
                    Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(companion, 0.0f, 1, null);
                    VideoAlbumConfiguration videoAlbumConfiguration2 = new VideoAlbumConfiguration(false);
                    boolean zChanged5 = composer2.changed(oVar) | composer2.changedInstance(context);
                    Object objRememberedValue10 = composer2.rememberedValue();
                    if (zChanged5 || objRememberedValue10 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue10 = new Function1() { // from class: cu.todus.android.uiCompose.shared.camera.f0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return CameraKt.CameraViewPage$lambda$2$1$0$0(oVar, context, (List) obj);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue10);
                    }
                    Function1 function3 = (Function1) objRememberedValue10;
                    boolean zChangedInstance6 = composer2.changedInstance(context);
                    Object objRememberedValue11 = composer2.rememberedValue();
                    if (zChangedInstance6 || objRememberedValue11 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue11 = new Function1() { // from class: cu.todus.android.uiCompose.shared.camera.g0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return CameraKt.CameraViewPage$lambda$2$1$1$0(context, (String) obj);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue11);
                    }
                    Z17FullSizeVideoAlbumKt.m10325Z17FullSizeVideoAlbumPfoAEA0(modifierFillMaxSize$default, videoAlbumConfiguration2, function3, null, null, 0.0f, (Function1) objRememberedValue11, composer, (VideoAlbumConfiguration.$stable << 3) | 6, 56);
                    composer2 = composer;
                    composer2.endReplaceGroup();
                } else {
                    composer2.startReplaceGroup(1833593287);
                    Modifier modifierFillMaxSize$default2 = SizeKt.fillMaxSize$default(companion, 0.0f, 1, null);
                    AlbumConfiguration albumConfiguration2 = new AlbumConfiguration(false);
                    boolean zChanged6 = composer2.changed(oVar) | composer2.changedInstance(context);
                    Object objRememberedValue12 = composer2.rememberedValue();
                    if (zChanged6 || objRememberedValue12 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue12 = new Function1() { // from class: cu.todus.android.uiCompose.shared.camera.i0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return CameraKt.CameraViewPage$lambda$2$1$2$0(oVar, context, (List) obj);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue12);
                    }
                    Z17FullSizeAlbumKt.m10294Z17FullSizeAlbumWHejsw(modifierFillMaxSize$default2, albumConfiguration2, (Function1) objRememberedValue12, null, 0.0f, null, composer2, (AlbumConfiguration.$stable << 3) | 6, 56);
                    composer2.endReplaceGroup();
                }
                composer2.endNode();
                composer2.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-1704005482);
                composer.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 CameraViewPage$lambda$2$0$0$0(lb.o oVar, Context context, List it) {
        kotlin.jvm.internal.y.i(it, "it");
        String path = MediaUtil.INSTANCE.getPath(context, ((VideoAlbum) va.g0.w0(it)).getUri());
        kotlin.jvm.internal.y.f(path);
        ResultType resultType = ResultType.VIDEO;
        Long duration = ((VideoAlbum) va.g0.w0(it)).getDuration();
        kotlin.jvm.internal.y.f(duration);
        oVar.invoke(path, resultType, duration, Float.valueOf(0.0f));
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 CameraViewPage$lambda$2$0$1$0(lb.o oVar) {
        oVar.invoke("", ResultType.DELETE, 0L, Float.valueOf(0.0f));
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 CameraViewPage$lambda$2$0$2$0(ManagedActivityResultLauncher managedActivityResultLauncher) {
        managedActivityResultLauncher.launch(VideoSpec.MIME_TYPE_UNSPECIFIED);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 CameraViewPage$lambda$2$0$3$0(ManagedActivityResultLauncher managedActivityResultLauncher) {
        managedActivityResultLauncher.launch(VideoSpec.MIME_TYPE_UNSPECIFIED);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String CameraViewPage$lambda$2$0$4$0(Context context, String it) {
        kotlin.jvm.internal.y.i(it, "it");
        MediaUtil mediaUtil = MediaUtil.INSTANCE;
        Uri uri = Uri.parse(it);
        kotlin.jvm.internal.y.h(uri, "parse(...)");
        String path = mediaUtil.getPath(context, uri);
        return path == null ? "" : path;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 CameraViewPage$lambda$2$0$5$0(lb.o oVar, Context context, List it) {
        kotlin.jvm.internal.y.i(it, "it");
        String path = MediaUtil.INSTANCE.getPath(context, ((AlbumImage) va.g0.w0(it)).getUri());
        kotlin.jvm.internal.y.f(path);
        oVar.invoke(path, ResultType.PHOTO, 0L, Float.valueOf(0.0f));
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 CameraViewPage$lambda$2$0$6$0(lb.o oVar) {
        oVar.invoke("", ResultType.DELETE, 0L, Float.valueOf(0.0f));
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 CameraViewPage$lambda$2$0$7$0(ManagedActivityResultLauncher managedActivityResultLauncher) {
        managedActivityResultLauncher.launch("image/*");
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 CameraViewPage$lambda$2$0$8$0(ManagedActivityResultLauncher managedActivityResultLauncher) {
        managedActivityResultLauncher.launch("image/*");
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 CameraViewPage$lambda$2$1$0$0(lb.o oVar, Context context, List it) {
        kotlin.jvm.internal.y.i(it, "it");
        String path = MediaUtil.INSTANCE.getPath(context, ((VideoAlbum) va.g0.w0(it)).getUri());
        kotlin.jvm.internal.y.f(path);
        ResultType resultType = ResultType.VIDEO;
        Long duration = ((VideoAlbum) va.g0.w0(it)).getDuration();
        kotlin.jvm.internal.y.f(duration);
        oVar.invoke(path, resultType, duration, Float.valueOf(0.0f));
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String CameraViewPage$lambda$2$1$1$0(Context context, String it) {
        kotlin.jvm.internal.y.i(it, "it");
        MediaUtil mediaUtil = MediaUtil.INSTANCE;
        Uri uri = Uri.parse(it);
        kotlin.jvm.internal.y.h(uri, "parse(...)");
        String path = mediaUtil.getPath(context, uri);
        return path == null ? "" : path;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 CameraViewPage$lambda$2$1$2$0(lb.o oVar, Context context, List it) {
        kotlin.jvm.internal.y.i(it, "it");
        String path = MediaUtil.INSTANCE.getPath(context, ((AlbumImage) va.g0.w0(it)).getUri());
        kotlin.jvm.internal.y.f(path);
        oVar.invoke(path, ResultType.PHOTO, 0L, Float.valueOf(0.0f));
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 CameraViewPage$lambda$3(String str, String str2, boolean z10, lb.a aVar, lb.o oVar, lb.a aVar2, boolean z11, final Function1 function1, PaddingValues it, Composer composer, int i10) {
        RowScopeInstance rowScopeInstance;
        int i11;
        int i12;
        int i13;
        long background;
        long background2;
        kotlin.jvm.internal.y.i(it, "it");
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1377650562, i10, -1, "cu.todus.android.uiCompose.shared.camera.CameraViewPage.<anonymous> (Camera.kt:603)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(PaddingKt.m1729paddingqDBjuR0$default(companion, 0.0f, 0.0f, 0.0f, Dp.m8823constructorimpl(MenuKt.InTransitionDuration), 7, null), 0.0f, 1, null);
            MaterialTheme materialTheme = MaterialTheme.INSTANCE;
            int i14 = MaterialTheme.$stable;
            Modifier modifierM1205backgroundbw27NRU$default = BackgroundKt.m1205backgroundbw27NRU$default(modifierFillMaxSize$default, materialTheme.getColorScheme(composer, i14).getBackground(), null, 2, null);
            Arrangement arrangement = Arrangement.INSTANCE;
            Arrangement.Vertical top = arrangement.getTop();
            Alignment.Companion companion2 = Alignment.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(top, companion2.getStart(), composer, 0);
            int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierM1205backgroundbw27NRU$default);
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
            Z17CameraKt.Z17Camera(androidx.compose.foundation.layout.x.a(ColumnScopeInstance.INSTANCE, companion, 1.0f, false, 2, null), str, str2, z10, null, null, null, aVar, oVar, aVar2, false, composer, 0, 0, 1136);
            Composer composer2 = composer;
            Modifier modifierM1729paddingqDBjuR0$default = PaddingKt.m1729paddingqDBjuR0$default(PaddingKt.m1725padding3ABfNKs(SizeKt.fillMaxWidth$default(BackgroundKt.m1205backgroundbw27NRU$default(companion, materialTheme.getColorScheme(composer2, i14).getBackground(), null, 2, null), 0.0f, 1, null), Dp.m8823constructorimpl(20)), 0.0f, 0.0f, 0.0f, Dp.m8823constructorimpl(30), 7, null);
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getCenter(), companion2.getTop(), composer2, 6);
            int iA2 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer2, modifierM1729paddingqDBjuR0$default);
            lb.a constructor2 = companion3.getConstructor();
            if (!defpackage.r.a(composer2.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                composer2.createNode(constructor2);
            } else {
                composer2.useNode();
            }
            Composer composerM5176constructorimpl2 = Updater.m5176constructorimpl(composer2);
            Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyRowMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl2, Integer.valueOf(iA2), companion3.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl2, companion3.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier2, companion3.getSetModifier());
            RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
            if (z11) {
                composer2.startReplaceGroup(-1284947265);
                AnimatedVisibilityKt.AnimatedVisibility(rowScopeInstance2, z10, (Modifier) null, (EnterTransition) null, (ExitTransition) null, (String) null, ComposableSingletons$CameraKt.INSTANCE.m10084getLambda$499839851$app_productionPFast(), composer2, 1572870, 30);
                rowScopeInstance = rowScopeInstance2;
                composer2 = composer2;
                composer2.endReplaceGroup();
            } else {
                rowScopeInstance = rowScopeInstance2;
                composer2.startReplaceGroup(-1178206918);
                composer2.endReplaceGroup();
            }
            if (z11) {
                composer2.startReplaceGroup(-1284929943);
                boolean zChanged = composer2.changed(function1);
                Object objRememberedValue = composer2.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.p
                        @Override // lb.a
                        public final Object invoke() {
                            return CameraKt.CameraViewPage$lambda$3$0$0$0$0(function1);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue);
                }
                Modifier modifierM1240clickableoSLSa3U$default = ClickableKt.m1240clickableoSLSa3U$default(companion, false, null, null, null, (lb.a) objRememberedValue, 15, null);
                float fM8823constructorimpl = Dp.m8823constructorimpl(!z10 ? 0 : 1);
                if (z10) {
                    composer2.startReplaceGroup(-1284919372);
                    background2 = materialTheme.getColorScheme(composer2, i14).getOnBackground();
                } else {
                    composer2.startReplaceGroup(-1284917966);
                    background2 = materialTheme.getColorScheme(composer2, i14).getBackground();
                }
                composer2.endReplaceGroup();
                i11 = 1;
                i12 = 0;
                i13 = 10;
                Z17LabelKt.m10262Z17LabelfWhpE4E(PaddingKt.m1725padding3ABfNKs(BackgroundKt.m1205backgroundbw27NRU$default(BorderKt.m1216borderxT4_qwU(modifierM1240clickableoSLSa3U$default, fM8823constructorimpl, background2, RoundedCornerShapeKt.getCircleShape()), materialTheme.getColorScheme(composer2, i14).getBackground(), null, 2, null), Dp.m8823constructorimpl(10)), StringResources_androidKt.stringResource(cu.todus.android.R.string.video, composer2, 0), null, materialTheme.getColorScheme(composer2, i14).getOnBackground(), 0, 0, composer, 0, 52);
                composer2 = composer;
                composer2.endReplaceGroup();
            } else {
                i11 = 1;
                i12 = 0;
                i13 = 10;
                composer2.startReplaceGroup(-1177352806);
                composer2.endReplaceGroup();
            }
            boolean zChanged2 = composer2.changed(function1);
            Object objRememberedValue2 = composer2.rememberedValue();
            if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.q
                    @Override // lb.a
                    public final Object invoke() {
                        return CameraKt.CameraViewPage$lambda$3$0$0$1$0(function1);
                    }
                };
                composer2.updateRememberedValue(objRememberedValue2);
            }
            lb.a aVar3 = (lb.a) objRememberedValue2;
            int i15 = i13;
            int i16 = i12;
            int i17 = i11;
            Modifier modifierM1240clickableoSLSa3U$default2 = ClickableKt.m1240clickableoSLSa3U$default(companion, false, null, null, null, aVar3, 15, null);
            float fM8823constructorimpl2 = Dp.m8823constructorimpl(z10 ? i16 : i17);
            if (z10) {
                composer2.startReplaceGroup(-1284892622);
                background = materialTheme.getColorScheme(composer2, i14).getBackground();
            } else {
                composer2.startReplaceGroup(-1284894028);
                background = materialTheme.getColorScheme(composer2, i14).getOnBackground();
            }
            composer2.endReplaceGroup();
            Z17LabelKt.m10262Z17LabelfWhpE4E(PaddingKt.m1725padding3ABfNKs(BackgroundKt.m1205backgroundbw27NRU$default(BorderKt.m1216borderxT4_qwU(modifierM1240clickableoSLSa3U$default2, fM8823constructorimpl2, background, RoundedCornerShapeKt.getCircleShape()), materialTheme.getColorScheme(composer2, i14).getBackground(), null, 2, null), Dp.m8823constructorimpl(i15)), StringResources_androidKt.stringResource(cu.todus.android.R.string.camera, composer2, i16), null, materialTheme.getColorScheme(composer2, i14).getOnBackground(), 0, 0, composer, 0, 52);
            if (z11) {
                composer.startReplaceGroup(-1284878273);
                AnimatedVisibilityKt.AnimatedVisibility(rowScopeInstance, !z10, (Modifier) null, (EnterTransition) null, (ExitTransition) null, (String) null, ComposableSingletons$CameraKt.INSTANCE.m10081getLambda$1772970275$app_productionPFast(), composer, 1572870, 30);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-1176068166);
                composer.endReplaceGroup();
            }
            composer.endNode();
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
    public static final ua.k0 CameraViewPage$lambda$3$0$0$0$0(Function1 function1) {
        function1.invoke(Boolean.TRUE);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 CameraViewPage$lambda$3$0$0$1$0(Function1 function1) {
        function1.invoke(Boolean.FALSE);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 CameraViewPage$lambda$4(boolean z10, boolean z11, String str, String str2, lb.o oVar, lb.a aVar, lb.a aVar2, boolean z12, Function1 function1, int i10, int i11, Composer composer, int i12) {
        CameraViewPage(z10, z11, str, str2, oVar, aVar, aVar2, z12, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return ua.k0.f43947a;
    }

    /* JADX WARN: Failed to calculate best type for var: r10v11 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r10v11 ??, new type: androidx.compose.material3.MaterialTheme
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r13v0 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r13v0 ??, new type: androidx.compose.runtime.Composer
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r13v1 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r13v1 ??, new type: androidx.compose.runtime.Composer
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r13v2 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r13v2 ??, new type: androidx.compose.runtime.Composer
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r13v2 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r13v2 ??, new type: androidx.compose.runtime.Composer
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r13v3 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r13v3 ??, new type: androidx.compose.runtime.Composer
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r13v3 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r13v3 ??, new type: androidx.compose.runtime.Composer
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r13v5 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r13v5 ??, new type: androidx.compose.runtime.Composer
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r1v21 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r1v21 ??, new type: boolean
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r2v21 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r2v21 ??, new type: androidx.compose.material3.MaterialTheme
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r2v21 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r2v21 ??, new type: androidx.compose.material3.MaterialTheme
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /*  JADX ERROR: Types fix failed
        jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r12v3 ??, new type: boolean
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryPossibleTypes(FixTypesVisitor.java:186)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:245)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
        Caused by: java.lang.NullPointerException
        */
    @androidx.compose.runtime.ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @androidx.compose.runtime.Composable
    public static final void ImageEditorViewPage(boolean r43, java.lang.String r44, java.lang.String r45, boolean r46, float r47, kotlin.jvm.functions.Function2 r48, lb.a r49, lb.a r50, androidx.compose.runtime.Composer r51, int r52) {
        /*
            Method dump skipped, instruction units count: 1140
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.uiCompose.shared.camera.CameraKt.ImageEditorViewPage(boolean, java.lang.String, java.lang.String, boolean, float, kotlin.jvm.functions.Function2, lb.a, lb.a, androidx.compose.runtime.Composer, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MutableState ImageEditorViewPage$lambda$0$0$0() {
        return SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
    }

    private static final String ImageEditorViewPage$lambda$0$1(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ImageEditorViewPage$lambda$0$10$0(MutableState mutableState, boolean z10) {
        ImageEditorViewPage$lambda$0$8(mutableState, z10);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ImageEditorViewPage$lambda$0$11$0$0(MutableState mutableState, String it) {
        kotlin.jvm.internal.y.i(it, "it");
        mutableState.setValue(it);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ImageEditorViewPage$lambda$0$11$1$0(Function2 function2, String str, String str2, MutableState mutableState, MutableState mutableState2) {
        if (!ImageEditorViewPage$lambda$0$7(mutableState)) {
            str = str2;
        }
        function2.invoke(str, ImageEditorViewPage$lambda$0$1(mutableState2));
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MutableState ImageEditorViewPage$lambda$0$3$0() {
        return SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
    }

    private static final boolean ImageEditorViewPage$lambda$0$4(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void ImageEditorViewPage$lambda$0$5(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    private static final boolean ImageEditorViewPage$lambda$0$7(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void ImageEditorViewPage$lambda$0$8(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ImageEditorViewPage$lambda$0$9$0(MutableState mutableState, boolean z10) {
        ImageEditorViewPage$lambda$0$5(mutableState, z10);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ImageEditorViewPage$lambda$1(boolean z10, String str, String str2, boolean z11, float f10, Function2 function2, lb.a aVar, lb.a aVar2, int i10, Composer composer, int i11) {
        ImageEditorViewPage(z10, str, str2, z11, f10, function2, aVar, aVar2, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1));
        return ua.k0.f43947a;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void VideoEditorViewPage(final boolean z10, final String videoPath, final String videoPathToSave, final long j10, final long j11, final Function2 onResult, final lb.a retry, final lb.a onError, Composer composer, final int i10) {
        int i11;
        Composer composer2;
        MutableState mutableState;
        int i12;
        MaterialTheme materialTheme;
        Modifier.Companion companion;
        int i13;
        int i14;
        kotlin.jvm.internal.y.i(videoPath, "videoPath");
        kotlin.jvm.internal.y.i(videoPathToSave, "videoPathToSave");
        kotlin.jvm.internal.y.i(onResult, "onResult");
        kotlin.jvm.internal.y.i(retry, "retry");
        kotlin.jvm.internal.y.i(onError, "onError");
        Composer composerStartRestartGroup = composer.startRestartGroup(2010062877);
        if ((i10 & 6) == 0) {
            i11 = (composerStartRestartGroup.changed(z10) ? 4 : 2) | i10;
        } else {
            i11 = i10;
        }
        if ((i10 & 48) == 0) {
            i11 |= composerStartRestartGroup.changed(videoPath) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i11 |= composerStartRestartGroup.changed(videoPathToSave) ? 256 : 128;
        }
        if ((i10 & 3072) == 0) {
            i11 |= composerStartRestartGroup.changed(j10) ? 2048 : 1024;
        }
        if ((i10 & 24576) == 0) {
            i11 |= composerStartRestartGroup.changed(j11) ? 16384 : 8192;
        }
        if ((196608 & i10) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(onResult) ? 131072 : 65536;
        }
        if ((i10 & 12582912) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(onError) ? 8388608 : 4194304;
        }
        if (composerStartRestartGroup.shouldExecute((4269203 & i11) != 4269202, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2010062877, i11, -1, "cu.todus.android.uiCompose.shared.camera.VideoEditorViewPage (Camera.kt:790)");
            }
            Modifier.Companion companion2 = Modifier.INSTANCE;
            Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(companion2, 0.0f, 1, null);
            MaterialTheme materialTheme2 = MaterialTheme.INSTANCE;
            int i15 = MaterialTheme.$stable;
            Modifier modifierM1205backgroundbw27NRU$default = BackgroundKt.m1205backgroundbw27NRU$default(modifierFillMaxSize$default, materialTheme2.getColorScheme(composerStartRestartGroup, i15).getBackground(), null, 2, null);
            Arrangement arrangement = Arrangement.INSTANCE;
            Arrangement.Vertical top = arrangement.getTop();
            Alignment.Companion companion3 = Alignment.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(top, companion3.getStart(), composerStartRestartGroup, 0);
            int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1205backgroundbw27NRU$default);
            ComposeUiNode.Companion companion4 = ComposeUiNode.INSTANCE;
            lb.a constructor = companion4.getConstructor();
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
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyColumnMeasurePolicy, companion4.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion4.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion4.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl, companion4.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion4.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            Object[] objArr = new Object[0];
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            Composer.Companion companion5 = Composer.INSTANCE;
            if (objRememberedValue == companion5.getEmpty()) {
                objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.c1
                    @Override // lb.a
                    public final Object invoke() {
                        return CameraKt.VideoEditorViewPage$lambda$0$0$0();
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final MutableState mutableState2 = (MutableState) RememberSaveableKt.rememberSaveable(objArr, (lb.a) objRememberedValue, composerStartRestartGroup, 48);
            Object[] objArr2 = new Object[0];
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == companion5.getEmpty()) {
                objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.d1
                    @Override // lb.a
                    public final Object invoke() {
                        return CameraKt.VideoEditorViewPage$lambda$0$3$0();
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            final MutableState mutableState3 = (MutableState) RememberSaveableKt.rememberSaveable(objArr2, (lb.a) objRememberedValue2, composerStartRestartGroup, 48);
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == companion5.getEmpty()) {
                objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            final MutableState mutableState4 = (MutableState) objRememberedValue3;
            Modifier modifierA = androidx.compose.foundation.layout.x.a(columnScopeInstance, companion2, 1.0f, false, 2, null);
            boolean zChanged = composerStartRestartGroup.changed(mutableState3);
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue4 == companion5.getEmpty()) {
                objRememberedValue4 = new Function1() { // from class: cu.todus.android.uiCompose.shared.camera.e1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return CameraKt.VideoEditorViewPage$lambda$0$9$0(mutableState3, ((Boolean) obj).booleanValue());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            Function1 function1 = (Function1) objRememberedValue4;
            Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue5 == companion5.getEmpty()) {
                objRememberedValue5 = new Function1() { // from class: cu.todus.android.uiCompose.shared.camera.b
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return CameraKt.VideoEditorViewPage$lambda$0$10$0(mutableState4, ((Boolean) obj).booleanValue());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            }
            int i16 = i11;
            int i17 = i16 & 112;
            Z17VideoEditorKt.Z17VideoEditor(modifierA, videoPath, j10, videoPathToSave, function1, onError, (Function1) objRememberedValue5, null, new VideoEditorConfigurations(j10 / 1000 >= 5, false, j11), composerStartRestartGroup, ((i16 << 3) & 7168) | i17 | 1572864 | ((i16 >> 3) & 896) | ((i16 >> 6) & 458752), 128);
            composer2 = composerStartRestartGroup;
            if (VideoEditorViewPage$lambda$0$4(mutableState3)) {
                composer2.startReplaceGroup(2076516051);
                Modifier modifierM1729paddingqDBjuR0$default = PaddingKt.m1729paddingqDBjuR0$default(PaddingKt.m1725padding3ABfNKs(SizeKt.fillMaxWidth$default(BackgroundKt.m1205backgroundbw27NRU$default(companion2, materialTheme2.getColorScheme(composer2, i15).getBackground(), null, 2, null), 0.0f, 1, null), Dp.m8823constructorimpl(20)), 0.0f, 0.0f, 0.0f, Dp.m8823constructorimpl(30), 7, null);
                MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getStart(), companion3.getCenterVertically(), composer2, 48);
                boolean z11 = false;
                int iA2 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
                CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer2, modifierM1729paddingqDBjuR0$default);
                lb.a constructor2 = companion4.getConstructor();
                if (!defpackage.r.a(composer2.getApplier())) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor2);
                } else {
                    composer2.useNode();
                }
                Composer composerM5176constructorimpl2 = Updater.m5176constructorimpl(composer2);
                Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyRowMeasurePolicy, companion4.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap2, companion4.getSetResolvedCompositionLocals());
                Updater.m5180initimpl(composerM5176constructorimpl2, Integer.valueOf(iA2), companion4.getSetCompositeKeyHash());
                Updater.m5182reconcileimpl(composerM5176constructorimpl2, companion4.getApplyOnDeactivatedNodeAssertion());
                Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier2, companion4.getSetModifier());
                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                if (z10) {
                    composer2.startReplaceGroup(2072002676);
                    Modifier modifierA2 = e3.a(rowScopeInstance, companion2, 1.0f, false, 2, null);
                    String strVideoEditorViewPage$lambda$0$1 = VideoEditorViewPage$lambda$0$1(mutableState2);
                    String strStringResource = StringResources_androidKt.stringResource(cu.todus.android.R.string.video_footer, composer2, 0);
                    RoundedCornerShape circleShape = RoundedCornerShapeKt.getCircleShape();
                    boolean zChanged2 = composer2.changed(mutableState2);
                    Object objRememberedValue6 = composer2.rememberedValue();
                    if (zChanged2 || objRememberedValue6 == companion5.getEmpty()) {
                        objRememberedValue6 = new Function1() { // from class: cu.todus.android.uiCompose.shared.camera.c
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return CameraKt.VideoEditorViewPage$lambda$0$11$0$0(mutableState2, (String) obj);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue6);
                    }
                    i12 = i15;
                    i13 = i17;
                    companion = companion2;
                    materialTheme = materialTheme2;
                    i14 = i16;
                    mutableState = mutableState2;
                    Z17InputTextKt.m10251Z17InputTextf9_u2OI(modifierA2, strVideoEditorViewPage$lambda$0$1, 0, 0, strStringResource, null, (Function1) objRememberedValue6, null, null, XMPPTCPConnection.PacketWriter.QUEUE_SIZE, 0, 0L, 0L, 0L, 0L, 0L, null, false, circleShape, z10, composer2, 805306368, (i16 << 27) & C.ENCODING_PCM_DOUBLE, 261548);
                    composer2 = composer2;
                    composer2.endReplaceGroup();
                } else {
                    mutableState = mutableState2;
                    i12 = i15;
                    materialTheme = materialTheme2;
                    companion = companion2;
                    i13 = i17;
                    i14 = i16;
                    composer2.startReplaceGroup(2072469722);
                    composer2.endReplaceGroup();
                }
                float f10 = 5;
                Modifier.Companion companion6 = companion;
                SpacerKt.Spacer(SizeKt.m1774width3ABfNKs(companion6, Dp.m8823constructorimpl(f10)), composer2, 6);
                Modifier modifierM1216borderxT4_qwU = BorderKt.m1216borderxT4_qwU(PaddingKt.m1729paddingqDBjuR0$default(companion6, 0.0f, Dp.m8823constructorimpl(f10), 0.0f, 0.0f, 13, null), Dp.m8823constructorimpl(1), materialTheme.getColorScheme(composer2, i12).getOnBackground(), RoundedCornerShapeKt.getCircleShape());
                int i18 = i14;
                final MutableState mutableState5 = mutableState;
                boolean zChanged3 = ((i18 & 458752) == 131072 ? true : z11) | ((i18 & 896) == 256 ? true : z11) | (i13 == 32) | composer2.changed(mutableState5);
                Object objRememberedValue7 = composer2.rememberedValue();
                if (zChanged3 || objRememberedValue7 == companion5.getEmpty()) {
                    lb.a aVar = new lb.a() { // from class: cu.todus.android.uiCompose.shared.camera.d
                        @Override // lb.a
                        public final Object invoke() {
                            return CameraKt.VideoEditorViewPage$lambda$0$11$1$0(onResult, videoPathToSave, videoPath, mutableState4, mutableState5);
                        }
                    };
                    composer2.updateRememberedValue(aVar);
                    objRememberedValue7 = aVar;
                }
                IconButtonKt.IconButton((lb.a) objRememberedValue7, modifierM1216borderxT4_qwU, false, null, null, null, ComposableSingletons$CameraKt.INSTANCE.m10083getLambda$3494998$app_productionPFast(), composer2, 1572864, 60);
                composer2.endNode();
                composer2.endReplaceGroup();
            } else {
                composer2.startReplaceGroup(-50778213);
                composer2.endReplaceGroup();
            }
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.shared.camera.e
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CameraKt.VideoEditorViewPage$lambda$1(z10, videoPath, videoPathToSave, j10, j11, onResult, retry, onError, i10, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MutableState VideoEditorViewPage$lambda$0$0$0() {
        return SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
    }

    private static final String VideoEditorViewPage$lambda$0$1(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 VideoEditorViewPage$lambda$0$10$0(MutableState mutableState, boolean z10) {
        VideoEditorViewPage$lambda$0$8(mutableState, z10);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 VideoEditorViewPage$lambda$0$11$0$0(MutableState mutableState, String it) {
        kotlin.jvm.internal.y.i(it, "it");
        mutableState.setValue(it);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 VideoEditorViewPage$lambda$0$11$1$0(Function2 function2, String str, String str2, MutableState mutableState, MutableState mutableState2) {
        if (!VideoEditorViewPage$lambda$0$7(mutableState)) {
            str = str2;
        }
        function2.invoke(str, VideoEditorViewPage$lambda$0$1(mutableState2));
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MutableState VideoEditorViewPage$lambda$0$3$0() {
        return SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
    }

    private static final boolean VideoEditorViewPage$lambda$0$4(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void VideoEditorViewPage$lambda$0$5(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    private static final boolean VideoEditorViewPage$lambda$0$7(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void VideoEditorViewPage$lambda$0$8(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 VideoEditorViewPage$lambda$0$9$0(MutableState mutableState, boolean z10) {
        VideoEditorViewPage$lambda$0$5(mutableState, z10);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 VideoEditorViewPage$lambda$1(boolean z10, String str, String str2, long j10, long j11, Function2 function2, lb.a aVar, lb.a aVar2, int i10, Composer composer, int i11) {
        VideoEditorViewPage(z10, str, str2, j10, j11, function2, aVar, aVar2, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1));
        return ua.k0.f43947a;
    }
}
