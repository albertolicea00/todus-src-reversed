package cu.todus.android.uiCompose.main.screen.chat.component.p2p;

import android.R;
import android.content.Context;
import android.net.Uri;
import androidx.camera.video.VideoSpec;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.text.input.TextFieldState;
import androidx.compose.foundation.text.input.TextFieldStateKt;
import androidx.compose.material3.TextKt;
import androidx.compose.material3.TopAppBarScrollBehavior;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import androidx.compose.ui.tooling.preview.Devices;
import androidx.compose.ui.tooling.preview.Preview;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.navigation.NavController;
import androidx.navigation.NavHostController;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigator;
import androidx.p000activity.compose.ManagedActivityResultLauncher;
import androidx.paging.compose.LazyPagingItems;
import cu.todus.android.data.db.entity.cache.BotShortcut;
import cu.todus.android.data.db.entity.toDus.Attachment;
import cu.todus.android.data.db.entity.toDus.Message;
import cu.todus.android.data.db.entity.toDus.Sticker;
import cu.todus.android.data.db.entity.toDus.User;
import cu.todus.android.data.db.pojo.Friend;
import cu.todus.android.data.db.pojo.MessageWithPartnerWithReactions;
import cu.todus.android.data.db.pojo.content.ButtonContent;
import cu.todus.android.data.db.pojo.content.ButtonTemplate;
import cu.todus.android.data.db.pojo.content.ContactContent;
import cu.todus.android.data.db.pojo.messageentity.MentionName;
import cu.todus.android.data.db.pojo.messageentity.MessageEntity;
import cu.todus.android.data.util.MediaUtil;
import cu.todus.android.data.wrapper.FlowsState;
import cu.todus.android.domain.handlers.Send;
import cu.todus.android.uiCompose.call.AudioCallActivity;
import cu.todus.android.uiCompose.call.VideoCallActivity;
import cu.todus.android.uiCompose.main.screen.chat.attachmentPreview.AttachmentPreviewKt;
import cu.todus.android.uiCompose.main.screen.chat.attachmentPreview.AttachmentPreviewState;
import cu.todus.android.uiCompose.main.screen.chat.attachmentSelector.AttachmentSelectorKt;
import cu.todus.android.uiCompose.main.screen.chat.component.ChatParams;
import cu.todus.android.uiCompose.main.screen.chat.component.ChatScreenState;
import cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel;
import cu.todus.android.uiCompose.main.screen.chat.component.SendToParams;
import cu.todus.android.uiCompose.main.screen.chat.details.MsgDetailsDialogKt;
import cu.todus.android.uiCompose.main.screen.chat.functionalities.ChatButtonsFunctionality;
import cu.todus.android.uiCompose.main.screen.chat.functionalities.ChatComplexFunctionalities;
import cu.todus.android.uiCompose.main.screen.chat.input.ChatInputKt;
import cu.todus.android.uiCompose.main.screen.chat.item.MessageAction;
import cu.todus.android.uiCompose.main.screen.chat.pagerDialog.PagerDialogData;
import cu.todus.android.uiCompose.main.screen.chat.presend.PresentListKt;
import cu.todus.android.uiCompose.main.screen.chat.preview.MsgPreviewKt;
import cu.todus.android.uiCompose.main.screen.chat.stickers.GroupsContainerKt;
import cu.todus.android.uiCompose.main.screen.chat.toolbar.ChatActionBarKt;
import cu.todus.android.uiCompose.main.screen.dateEditor.DateEditorParams;
import cu.todus.android.uiCompose.main.screen.manageStickers.ManageStickersParams;
import cu.todus.android.uiCompose.main.screen.map.MapMotive;
import cu.todus.android.uiCompose.main.screen.map.MapParams;
import cu.todus.android.uiCompose.main.screen.statusPreview.StatusPreviewParams;
import cu.todus.android.uiCompose.navigation.NavLinks;
import cu.todus.android.uiCompose.shared.animations.attach.AttachContainerKt;
import cu.todus.android.utils.ContactUtil;
import cu.todus.android.utils.IntentUtil;
import cu.z17.singledi.SinglediException;
import cu.z17.views.permission.PermissionsRequesterState;
import cu.z17.views.permission.PermissionsResult;
import j$.util.Collection;
import j$.util.function.Predicate$CC;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u001a)\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b\u001a\u000f\u0010\t\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006(²\u0006\u000e\u0010\f\u001a\u00020\u000b8\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\u000e\u001a\u0004\u0018\u00010\r8\nX\u008a\u0084\u0002²\u0006\u0012\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\nX\u008a\u0084\u0002²\u0006\u001c\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00128\n@\nX\u008a\u008e\u0002²\u0006\u001c\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00128\n@\nX\u008a\u008e\u0002²\u0006\f\u0010\u0017\u001a\u00020\u00168\nX\u008a\u0084\u0002²\u0006\u000e\u0010\u0019\u001a\u00020\u00188\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\u001a\u001a\u00020\u00188\n@\nX\u008a\u008e\u0002²\u0006\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\n@\nX\u008a\u008e\u0002²\u0006\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\u001f\u001a\u00020\u000b8\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010 \u001a\u00020\u000b8\n@\nX\u008a\u008e\u0002²\u0006\f\u0010!\u001a\u00020\u000b8\nX\u008a\u0084\u0002²\u0006\u000e\u0010\"\u001a\u00020\u000b8\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010#\u001a\u00020\u000b8\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010$\u001a\u00020\u000b8\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010%\u001a\u00020\u00028\n@\nX\u008a\u008e\u0002²\u0006\f\u0010&\u001a\u00020\u000b8\nX\u008a\u0084\u0002²\u0006\f\u0010'\u001a\u00020\u000b8\nX\u008a\u0084\u0002"}, d2 = {"Landroidx/navigation/NavHostController;", "navHostController", "", "params", "Lcu/todus/android/uiCompose/main/screen/chat/component/ChatViewModel;", "viewModel", "Lua/k0;", "ChatP2PScreen", "(Landroidx/navigation/NavHostController;Ljava/lang/String;Lcu/todus/android/uiCompose/main/screen/chat/component/ChatViewModel;Landroidx/compose/runtime/Composer;II)V", "ChatP2PScreenPreview", "(Landroidx/compose/runtime/Composer;I)V", "", "isLoading", "Lcu/todus/android/uiCompose/main/screen/chat/component/ChatScreenState;", "chatScreenState", "Lcu/todus/android/data/wrapper/FlowsState;", "Lcu/todus/android/data/db/pojo/Friend;", "requestedFriendByContact", "Lkotlin/Function1;", "scrollBottom", "", "scrollToPosition", "", "actualRecorderTime", "Lcu/z17/views/permission/PermissionsRequesterState;", "mediaPermissionsState", "callPermissionsState", "Lcu/todus/android/uiCompose/main/screen/chat/pagerDialog/PagerDialogData;", "createPlaceholderMsg", "Lcu/todus/android/uiCompose/main/screen/chat/attachmentPreview/AttachmentPreviewState;", "attachmentPreview", "showAttachmentSelector", "isPickingFiles", "showDeleteForEveryone", "showDeleteDialog", "openCamera", "showStickers", "msgDetailId", "showUnknown", "firstItemVisible", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class ChatP2PScreenKt {

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[MessageAction.values().length];
            try {
                iArr[MessageAction.MENTION_CLICK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MessageAction.TAG_CLICK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[MessageAction.NUMBER_CLICK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[MessageAction.LINK_CLICK.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[MessageAction.COMMAND_CLICK.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Failed to calculate best type for var: r11v11 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r11v11 ??, new type: boolean
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
    /* JADX WARN: Failed to calculate best type for var: r14v1 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r14v1 ??, new type: boolean
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
    /* JADX WARN: Failed to calculate best type for var: r3v16 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r3v16 ??, new type: androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r3v16 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r3v16 ??, new type: androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
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
    /* JADX WARN: Failed to calculate best type for var: r3v32 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r3v32 ??, new type: boolean
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
    /* JADX WARN: Failed to calculate best type for var: r51v0 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r51v0 ??, new type: androidx.compose.runtime.Composer
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
    /* JADX WARN: Failed to calculate best type for var: r5v20 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r5v20 ??, new type: androidx.compose.runtime.Composer
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
    /* JADX WARN: Failed to calculate best type for var: r6v0 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r6v0 ??, new type: androidx.compose.runtime.Composer
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r6v0 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r6v0 ??, new type: androidx.compose.runtime.Composer
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
    /* JADX WARN: Failed to calculate best type for var: r6v18 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r6v18 ??, new type: androidx.compose.runtime.Composer
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
    /* JADX WARN: Failed to calculate best type for var: r6v2 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r6v2 ??, new type: androidx.compose.runtime.Composer
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r6v2 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r6v2 ??, new type: androidx.compose.runtime.Composer
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
    /* JADX WARN: Failed to calculate best type for var: r6v5 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r6v5 ??, new type: androidx.compose.runtime.Composer
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r6v5 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r6v5 ??, new type: androidx.compose.runtime.Composer
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
    /* JADX WARN: Failed to calculate best type for var: r6v6 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r6v6 ??, new type: androidx.compose.runtime.Composer
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r6v6 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r6v6 ??, new type: androidx.compose.runtime.Composer
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
    /* JADX WARN: Failed to calculate best type for var: r7v10 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r7v10 ??, new type: boolean
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
    /* JADX WARN: Failed to set immutable type for var: r51v0 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r51v0 ??, new type: androidx.compose.runtime.Composer
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.applyWithWiderIgnSame(TypeUpdate.java:73)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setImmutableType(TypeInferenceVisitor.java:111)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$0(TypeInferenceVisitor.java:102)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:102)
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
        jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r5v8 ??, new type: boolean
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
    @android.annotation.SuppressLint({"CoroutineCreationDuringComposition"})
    public static final void ChatP2PScreen(androidx.navigation.NavHostController r48, java.lang.String r49, cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel r50, androidx.compose.runtime.Composer r51, int r52, int r53) {
        /*
            Method dump skipped, instruction units count: 1427
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.uiCompose.main.screen.chat.component.p2p.ChatP2PScreenKt.ChatP2PScreen(androidx.navigation.NavHostController, java.lang.String, cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel, androidx.compose.runtime.Composer, int, int):void");
    }

    private static final void ChatP2PScreen$addAttachedFileToSend(SnapshotStateList<Uri> snapshotStateList, MutableState<Boolean> mutableState, Uri uri) {
        Uri next;
        Iterator<Uri> it = snapshotStateList.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!kotlin.jvm.internal.y.d(next.getPath(), uri.getPath()));
        if (next == null) {
            snapshotStateList.add(uri);
        }
        ChatP2PScreen$lambda$39(mutableState, true);
    }

    private static final void ChatP2PScreen$addItemToSelected(MutableState<MessageWithPartnerWithReactions> mutableState, MutableState<MessageWithPartnerWithReactions> mutableState2, SnapshotStateList<MessageWithPartnerWithReactions> snapshotStateList, ChatViewModel chatViewModel, MessageWithPartnerWithReactions messageWithPartnerWithReactions) {
        mutableState.setValue(null);
        mutableState2.setValue(null);
        snapshotStateList.add(messageWithPartnerWithReactions);
        ArrayList arrayList = new ArrayList(va.x.y(snapshotStateList, 10));
        Iterator<MessageWithPartnerWithReactions> it = snapshotStateList.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getMessage().getId());
        }
        chatViewModel.allMsgsAreMine(va.g0.o1(arrayList));
    }

    private static final void ChatP2PScreen$attachmentClicked(SoftwareKeyboardController softwareKeyboardController, Context context, final ChatViewModel chatViewModel, final NavHostController navHostController, final ChatParams chatParams, final TextFieldState textFieldState, MutableState<PagerDialogData> mutableState, State<ChatScreenState> state, final MutableState<AttachmentPreviewState> mutableState2, boolean z10, MessageAction messageAction, MessageWithPartnerWithReactions messageWithPartnerWithReactions, int i10) throws IllegalAccessException, SinglediException, IOException, InvocationTargetException {
        if (softwareKeyboardController != null) {
            softwareKeyboardController.hide();
        }
        ChatComplexFunctionalities chatComplexFunctionalities = ChatComplexFunctionalities.INSTANCE;
        v5.f gson = chatViewModel.getGson();
        Function1 function1 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.e6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ChatP2PScreenKt.ChatP2PScreen$attachmentClicked$lambda$44(navHostController, (String) obj);
            }
        };
        ChatP2PScreenKt$ChatP2PScreen$attachmentClicked$2 chatP2PScreenKt$ChatP2PScreen$attachmentClicked$2 = new ChatP2PScreenKt$ChatP2PScreen$attachmentClicked$2(chatViewModel);
        ChatP2PScreenKt$ChatP2PScreen$attachmentClicked$3 chatP2PScreenKt$ChatP2PScreen$attachmentClicked$3 = new ChatP2PScreenKt$ChatP2PScreen$attachmentClicked$3(chatViewModel);
        ChatP2PScreenKt$ChatP2PScreen$attachmentClicked$4 chatP2PScreenKt$ChatP2PScreen$attachmentClicked$4 = new ChatP2PScreenKt$ChatP2PScreen$attachmentClicked$4(chatViewModel);
        Function1 function2 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.p6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ChatP2PScreenKt.ChatP2PScreen$attachmentClicked$lambda$45(chatViewModel, chatParams, (String) obj);
            }
        };
        Function1 function3 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.a7
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ChatP2PScreenKt.ChatP2PScreen$attachmentClicked$lambda$46(textFieldState, (String) obj);
            }
        };
        ChatP2PScreenKt$ChatP2PScreen$attachmentClicked$7 chatP2PScreenKt$ChatP2PScreen$attachmentClicked$7 = new ChatP2PScreenKt$ChatP2PScreen$attachmentClicked$7(mutableState);
        ChatScreenState chatScreenStateChatP2PScreen$lambda$6 = ChatP2PScreen$lambda$6(state);
        chatComplexFunctionalities.attachmentClicked(messageAction, i10, z10, messageWithPartnerWithReactions, context, gson, function1, chatP2PScreenKt$ChatP2PScreen$attachmentClicked$2, chatP2PScreenKt$ChatP2PScreen$attachmentClicked$3, chatP2PScreenKt$ChatP2PScreen$attachmentClicked$4, function2, function3, chatP2PScreenKt$ChatP2PScreen$attachmentClicked$7, chatScreenStateChatP2PScreen$lambda$6 != null ? chatScreenStateChatP2PScreen$lambda$6.isSecret() : false, new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.l7
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ChatP2PScreenKt.ChatP2PScreen$attachmentClicked$lambda$47(mutableState2, (AttachmentPreviewState) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatP2PScreen$attachmentClicked$lambda$44(NavHostController navHostController, String it) {
        kotlin.jvm.internal.y.i(it, "it");
        NavController.navigate$default((NavController) navHostController, it, (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatP2PScreen$attachmentClicked$lambda$45(ChatViewModel chatViewModel, ChatParams chatParams, String msgContent) {
        kotlin.jvm.internal.y.i(msgContent, "msgContent");
        ChatViewModel.sendMessage$default(chatViewModel, msgContent, chatParams.getUid(), false, null, null, null, null, 124, null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatP2PScreen$attachmentClicked$lambda$46(TextFieldState textFieldState, String text) {
        kotlin.jvm.internal.y.i(text, "text");
        TextFieldStateKt.setTextAndPlaceCursorAtEnd(textFieldState, text);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatP2PScreen$attachmentClicked$lambda$47(MutableState mutableState, AttachmentPreviewState it) {
        kotlin.jvm.internal.y.i(it, "it");
        mutableState.setValue(it);
        return ua.k0.f43947a;
    }

    private static final void ChatP2PScreen$clearAttachedFilesToSend(SnapshotStateList<Uri> snapshotStateList, MutableState<Boolean> mutableState, MutableState<Boolean> mutableState2) {
        snapshotStateList.clear();
        ChatP2PScreen$lambda$39(mutableState, false);
        ChatP2PScreen$lambda$36(mutableState2, false);
    }

    private static final List<String> ChatP2PScreen$clearSelection(SnapshotStateList<MessageWithPartnerWithReactions> snapshotStateList) {
        List<MessageWithPartnerWithReactions> list = snapshotStateList.toList();
        snapshotStateList.clear();
        ArrayList arrayList = new ArrayList(va.x.y(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((MessageWithPartnerWithReactions) it.next()).getMessage().getId());
        }
        return arrayList;
    }

    private static final void ChatP2PScreen$createAndSendDate(NavHostController navHostController, ChatViewModel chatViewModel, ChatParams chatParams, MutableState<MessageWithPartnerWithReactions> mutableState) {
        Message message;
        NavLinks navLinks = NavLinks.INSTANCE;
        v5.f gson = chatViewModel.getGson();
        String uid = chatParams.getUid();
        MessageWithPartnerWithReactions value = mutableState.getValue();
        String strT = gson.t(new DateEditorParams(uid, (value == null || (message = value.getMessage()) == null) ? null : message.getId()));
        kotlin.jvm.internal.y.h(strT, "toJson(...)");
        NavController.navigate$default((NavController) navHostController, navLinks.goDateEditor(strT), (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
    }

    private static final void ChatP2PScreen$handleClickOnMention(ChatViewModel chatViewModel, final MutableState<Boolean> mutableState, final NavHostController navHostController, MessageEntity messageEntity) {
        ChatP2PScreen$lambda$2(mutableState, true);
        if (messageEntity instanceof MentionName) {
            chatViewModel.goChatByMention((MentionName) messageEntity, new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.a6
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return ChatP2PScreenKt.ChatP2PScreen$handleClickOnMention$lambda$68(navHostController, mutableState, (String) obj);
                }
            }, new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.b6
                @Override // lb.a
                public final Object invoke() {
                    return ChatP2PScreenKt.ChatP2PScreen$handleClickOnMention$lambda$69(mutableState);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatP2PScreen$handleClickOnMention$lambda$68(NavHostController navHostController, MutableState mutableState, String it) {
        kotlin.jvm.internal.y.i(it, "it");
        ChatP2PScreen$lambda$2(mutableState, false);
        NavController.navigate$default((NavController) navHostController, it, (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatP2PScreen$handleClickOnMention$lambda$69(MutableState mutableState) {
        ChatP2PScreen$lambda$2(mutableState, false);
        return ua.k0.f43947a;
    }

    private static final boolean ChatP2PScreen$lambda$1(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final Function1 ChatP2PScreen$lambda$12(MutableState<Function1> mutableState) {
        return mutableState.getValue();
    }

    private static final long ChatP2PScreen$lambda$14(State<Long> state) {
        return state.getValue().longValue();
    }

    private static final PermissionsRequesterState ChatP2PScreen$lambda$16(MutableState<PermissionsRequesterState> mutableState) {
        return mutableState.getValue();
    }

    private static final PermissionsRequesterState ChatP2PScreen$lambda$19(MutableState<PermissionsRequesterState> mutableState) {
        return mutableState.getValue();
    }

    private static final void ChatP2PScreen$lambda$2(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    private static final PagerDialogData ChatP2PScreen$lambda$26(MutableState<PagerDialogData> mutableState) {
        return mutableState.getValue();
    }

    private static final AttachmentPreviewState ChatP2PScreen$lambda$32(MutableState<AttachmentPreviewState> mutableState) {
        return mutableState.getValue();
    }

    private static final boolean ChatP2PScreen$lambda$35(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void ChatP2PScreen$lambda$36(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    private static final boolean ChatP2PScreen$lambda$38(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void ChatP2PScreen$lambda$39(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatP2PScreen$lambda$4(NavHostController navHostController, String str, ChatViewModel chatViewModel, int i10, int i11, Composer composer, int i12) {
        ChatP2PScreen(navHostController, str, chatViewModel, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatP2PScreen$lambda$43$0(Context context, MutableState mutableState, SnapshotStateList snapshotStateList, Uri uri) {
        if (uri != null) {
            ChatP2PScreen$lambda$39(mutableState, true);
            String path = MediaUtil.INSTANCE.getPath(context, uri);
            if (path == null) {
                path = "";
            }
            ChatP2PScreen$addAttachedFileToSend(snapshotStateList, mutableState, Uri.fromFile(new File(path)));
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatP2PScreen$lambda$48$0(Context context, ChatViewModel chatViewModel, ChatParams chatParams, MutableState mutableState, Uri uri) {
        Message message;
        if (uri != null) {
            ContactUtil contactUtil = ContactUtil.INSTANCE;
            Uri uriNormalizeScheme = uri.normalizeScheme();
            kotlin.jvm.internal.y.h(uriNormalizeScheme, "normalizeScheme(...)");
            ContactContent contactContentLoadContact = contactUtil.loadContact(context, uriNormalizeScheme);
            if (contactContentLoadContact != null) {
                String uid = chatParams.getUid();
                MessageWithPartnerWithReactions messageWithPartnerWithReactions = (MessageWithPartnerWithReactions) mutableState.getValue();
                chatViewModel.sendContact(uid, contactContentLoadContact, (messageWithPartnerWithReactions == null || (message = messageWithPartnerWithReactions.getMessage()) == null) ? null : message.getId());
            }
        }
        return ua.k0.f43947a;
    }

    private static final boolean ChatP2PScreen$lambda$49(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ChatScreenState ChatP2PScreen$lambda$6(State<ChatScreenState> state) {
        return state.getValue();
    }

    private static final boolean ChatP2PScreen$lambda$60(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void ChatP2PScreen$lambda$61(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    private static final boolean ChatP2PScreen$lambda$63(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void ChatP2PScreen$lambda$64(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    private static final boolean ChatP2PScreen$lambda$66(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void ChatP2PScreen$lambda$67(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    private static final FlowsState<Friend> ChatP2PScreen$lambda$7(State<FlowsState<Friend>> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatP2PScreen$lambda$70$0(ChatViewModel chatViewModel, Context context, State state, Uri uri) {
        if (uri != null) {
            String path = MediaUtil.INSTANCE.getPath(context, uri);
            if (path == null) {
                path = "";
            }
            ChatScreenState chatScreenStateChatP2PScreen$lambda$6 = ChatP2PScreen$lambda$6(state);
            kotlin.jvm.internal.y.f(chatScreenStateChatP2PScreen$lambda$6);
            chatViewModel.setChatBackground(path, chatScreenStateChatP2PScreen$lambda$6.getId());
        }
        return ua.k0.f43947a;
    }

    private static final String ChatP2PScreen$lambda$72(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean ChatP2PScreen$lambda$74$0(State state) {
        String number;
        ChatScreenState chatScreenStateChatP2PScreen$lambda$6 = ChatP2PScreen$lambda$6(state);
        if (chatScreenStateChatP2PScreen$lambda$6 == null || (number = chatScreenStateChatP2PScreen$lambda$6.getNumber()) == null || number.length() != 0) {
            return false;
        }
        ChatScreenState chatScreenStateChatP2PScreen$lambda$7 = ChatP2PScreen$lambda$6(state);
        return kotlin.jvm.internal.y.d(chatScreenStateChatP2PScreen$lambda$7 != null ? chatScreenStateChatP2PScreen$lambda$7.getUnknownUserState() : null, "new");
    }

    private static final boolean ChatP2PScreen$lambda$75(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 ChatP2PScreen$lambda$76(MutableState mutableState, final MutableState mutableState2, MutableState mutableState3, final NavHostController navHostController, final SnapshotStateList snapshotStateList, final ChatViewModel chatViewModel, final TextFieldState textFieldState, final SoftwareKeyboardController softwareKeyboardController, final Context context, final ManagedActivityResultLauncher managedActivityResultLauncher, final State state, final MutableState mutableState4, final MutableState mutableState5, final MutableState mutableState6, final MutableState mutableState7, final ChatParams chatParams, final MutableState mutableState8, TopAppBarScrollBehavior it, Composer composer, int i10) {
        kotlin.jvm.internal.y.i(it, "it");
        boolean z10 = false;
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(652832732, i10, -1, "cu.todus.android.uiCompose.main.screen.chat.component.p2p.ChatP2PScreen.<anonymous> (ChatP2PScreen.kt:566)");
            }
            if (ChatP2PScreen$lambda$32(mutableState) == null && le.d0.q0(ChatP2PScreen$lambda$72(mutableState2)) && !ChatP2PScreen$lambda$63(mutableState3)) {
                z10 = true;
            }
            AttachContainerKt.AnimateContainer(null, z10, ComposableLambdaKt.rememberComposableLambda(328250315, true, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.x6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ChatP2PScreenKt.ChatP2PScreen$lambda$76$0(navHostController, snapshotStateList, chatViewModel, textFieldState, softwareKeyboardController, context, managedActivityResultLauncher, state, mutableState4, mutableState5, mutableState6, mutableState2, mutableState7, chatParams, mutableState8, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, RendererCapabilities.DECODER_SUPPORT_MASK, 1);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:37:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:42:0x0115  */
    /* JADX WARN: Code duplicated, block: B:47:0x0131  */
    /* JADX WARN: Code duplicated, block: B:52:0x0152  */
    /* JADX WARN: Code duplicated, block: B:55:0x0168  */
    /* JADX WARN: Code duplicated, block: B:60:0x0184  */
    /* JADX WARN: Code duplicated, block: B:65:0x01a7  */
    /* JADX WARN: Code duplicated, block: B:70:0x01c8  */
    /* JADX WARN: Code duplicated, block: B:75:0x01e9  */
    /* JADX WARN: Code duplicated, block: B:78:0x0229  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 ChatP2PScreen$lambda$76$0(final NavHostController navHostController, final SnapshotStateList snapshotStateList, final ChatViewModel chatViewModel, final TextFieldState textFieldState, final SoftwareKeyboardController softwareKeyboardController, final Context context, final ManagedActivityResultLauncher managedActivityResultLauncher, final State state, final MutableState mutableState, final MutableState mutableState2, final MutableState mutableState3, final MutableState mutableState4, final MutableState mutableState5, final ChatParams chatParams, final MutableState mutableState6, Composer composer, int i10) throws SinglediException {
        lb.a aVar;
        boolean zChangedInstance;
        Object objRememberedValue;
        boolean zChanged;
        Object objRememberedValue2;
        boolean zChangedInstance2;
        Object objRememberedValue3;
        boolean zChangedInstance3;
        Object objRememberedValue4;
        Object objRememberedValue5;
        boolean zChangedInstance4;
        Object objRememberedValue6;
        boolean zChangedInstance5;
        Object objRememberedValue7;
        boolean zChangedInstance6;
        Object objRememberedValue8;
        boolean zChangedInstance7;
        Object objRememberedValue9;
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(328250315, i10, -1, "cu.todus.android.uiCompose.main.screen.chat.component.p2p.ChatP2PScreen.<anonymous>.<anonymous> (ChatP2PScreen.kt:569)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            ChatScreenState chatScreenStateChatP2PScreen$lambda$6 = ChatP2PScreen$lambda$6(state);
            int size = snapshotStateList.toList().size();
            boolean zListIsEditable = ChatComplexFunctionalities.INSTANCE.listIsEditable(snapshotStateList, chatViewModel.getOwner().getNameWithDomain());
            boolean zChangedInstance8 = composer.changedInstance(chatViewModel) | composer.changed(textFieldState);
            Object objRememberedValue10 = composer.rememberedValue();
            if (zChangedInstance8 || objRememberedValue10 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue10 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.y6
                    @Override // lb.a
                    public final Object invoke() {
                        return ChatP2PScreenKt.ChatP2PScreen$lambda$76$0$0$0(mutableState, chatViewModel, snapshotStateList, textFieldState);
                    }
                };
                composer.updateRememberedValue(objRememberedValue10);
            }
            lb.a aVar2 = (lb.a) objRememberedValue10;
            Object objRememberedValue11 = composer.rememberedValue();
            Composer.Companion companion2 = Composer.INSTANCE;
            if (objRememberedValue11 == companion2.getEmpty()) {
                objRememberedValue11 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.d7
                    @Override // lb.a
                    public final Object invoke() {
                        return ua.k0.f43947a;
                    }
                };
                composer.updateRememberedValue(objRememberedValue11);
            }
            lb.a aVar3 = (lb.a) objRememberedValue11;
            Object objRememberedValue12 = composer.rememberedValue();
            if (objRememberedValue12 == companion2.getEmpty()) {
                objRememberedValue12 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.e7
                    @Override // lb.a
                    public final Object invoke() {
                        return ChatP2PScreenKt.ChatP2PScreen$lambda$76$0$2$0(mutableState2);
                    }
                };
                composer.updateRememberedValue(objRememberedValue12);
            }
            lb.a aVar4 = (lb.a) objRememberedValue12;
            MessageWithPartnerWithReactions messageWithPartnerWithReactions = (MessageWithPartnerWithReactions) va.g0.y0(snapshotStateList);
            boolean zAvailable = messageWithPartnerWithReactions != null ? messageWithPartnerWithReactions.available() : false;
            boolean zChangedInstance9 = composer.changedInstance(chatViewModel);
            Object objRememberedValue13 = composer.rememberedValue();
            if (zChangedInstance9) {
                aVar = aVar4;
            } else {
                aVar = aVar4;
                if (objRememberedValue13 == companion2.getEmpty()) {
                }
                lb.a aVar5 = (lb.a) objRememberedValue13;
                boolean zChatP2PScreen$listIsForwardable = ChatP2PScreen$listIsForwardable(snapshotStateList);
                zChangedInstance = composer.changedInstance(navHostController) | composer.changedInstance(chatViewModel);
                objRememberedValue = composer.rememberedValue();
                if (zChangedInstance || objRememberedValue == companion2.getEmpty()) {
                    objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.g7
                        @Override // lb.a
                        public final Object invoke() {
                            return ChatP2PScreenKt.ChatP2PScreen$lambda$76$0$4$0(navHostController, chatViewModel, snapshotStateList);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                lb.a aVar6 = (lb.a) objRememberedValue;
                zChanged = composer.changed(softwareKeyboardController);
                objRememberedValue2 = composer.rememberedValue();
                if (zChanged || objRememberedValue2 == companion2.getEmpty()) {
                    objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.h7
                        @Override // lb.a
                        public final Object invoke() {
                            return ChatP2PScreenKt.ChatP2PScreen$lambda$76$0$5$0(softwareKeyboardController, snapshotStateList, mutableState4);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue2);
                }
                lb.a aVar7 = (lb.a) objRememberedValue2;
                zChangedInstance2 = composer.changedInstance(chatViewModel);
                objRememberedValue3 = composer.rememberedValue();
                if (zChangedInstance2 || objRememberedValue3 == companion2.getEmpty()) {
                    objRememberedValue3 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.i7
                        @Override // lb.a
                        public final Object invoke() {
                            return ChatP2PScreenKt.ChatP2PScreen$lambda$76$0$6$0(chatViewModel, snapshotStateList);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue3);
                }
                lb.a aVar8 = (lb.a) objRememberedValue3;
                zChangedInstance3 = composer.changedInstance(chatViewModel) | composer.changedInstance(context);
                objRememberedValue4 = composer.rememberedValue();
                if (zChangedInstance3 || objRememberedValue4 == companion2.getEmpty()) {
                    objRememberedValue4 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.j7
                        @Override // lb.a
                        public final Object invoke() {
                            return ChatP2PScreenKt.ChatP2PScreen$lambda$76$0$7$0(chatViewModel, context, snapshotStateList);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue4);
                }
                lb.a aVar9 = (lb.a) objRememberedValue4;
                objRememberedValue5 = composer.rememberedValue();
                if (objRememberedValue5 == companion2.getEmpty()) {
                    objRememberedValue5 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.k7
                        @Override // lb.a
                        public final Object invoke() {
                            return ChatP2PScreenKt.ChatP2PScreen$lambda$76$0$8$0(snapshotStateList);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue5);
                }
                lb.a aVar10 = (lb.a) objRememberedValue5;
                zChangedInstance4 = composer.changedInstance(managedActivityResultLauncher);
                objRememberedValue6 = composer.rememberedValue();
                if (zChangedInstance4 || objRememberedValue6 == companion2.getEmpty()) {
                    objRememberedValue6 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.g3
                        @Override // lb.a
                        public final Object invoke() {
                            return ChatP2PScreenKt.ChatP2PScreen$lambda$76$0$9$0(managedActivityResultLauncher, mutableState5);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue6);
                }
                lb.a aVar11 = (lb.a) objRememberedValue6;
                zChangedInstance5 = composer.changedInstance(chatViewModel) | composer.changed(state);
                objRememberedValue7 = composer.rememberedValue();
                if (zChangedInstance5 || objRememberedValue7 == companion2.getEmpty()) {
                    objRememberedValue7 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.z6
                        @Override // lb.a
                        public final Object invoke() {
                            return ChatP2PScreenKt.ChatP2PScreen$lambda$76$0$10$0(chatViewModel, state);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue7);
                }
                lb.a aVar12 = (lb.a) objRememberedValue7;
                zChangedInstance6 = composer.changedInstance(chatViewModel) | composer.changedInstance(context);
                objRememberedValue8 = composer.rememberedValue();
                if (zChangedInstance6 || objRememberedValue8 == companion2.getEmpty()) {
                    objRememberedValue8 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.b7
                        @Override // lb.a
                        public final Object invoke() {
                            return ChatP2PScreenKt.ChatP2PScreen$lambda$76$0$11$0(chatViewModel, chatParams, mutableState6, context);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue8);
                }
                lb.a aVar13 = (lb.a) objRememberedValue8;
                zChangedInstance7 = composer.changedInstance(chatViewModel) | composer.changedInstance(context);
                objRememberedValue9 = composer.rememberedValue();
                if (zChangedInstance7 || objRememberedValue9 == companion2.getEmpty()) {
                    objRememberedValue9 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.c7
                        @Override // lb.a
                        public final Object invoke() {
                            return ChatP2PScreenKt.ChatP2PScreen$lambda$76$0$12$0(chatViewModel, chatParams, mutableState6, context);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue9);
                }
                ChatActionBarKt.ChatActionBar(companion, navHostController, chatScreenStateChatP2PScreen$lambda$6, size, zListIsEditable, aVar2, false, aVar3, true, aVar, zAvailable, aVar5, zChatP2PScreen$listIsForwardable, aVar6, true, aVar7, false, null, true, aVar8, aVar9, aVar10, aVar11, aVar12, null, aVar13, (lb.a) objRememberedValue9, composer, 920125446, 100687872, 48, R.style.Animation);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            objRememberedValue13 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.f7
                @Override // lb.a
                public final Object invoke() {
                    return ChatP2PScreenKt.ChatP2PScreen$lambda$76$0$3$0(mutableState3, chatViewModel, mutableState, snapshotStateList);
                }
            };
            composer.updateRememberedValue(objRememberedValue13);
            lb.a aVar14 = (lb.a) objRememberedValue13;
            boolean zChatP2PScreen$listIsForwardable2 = ChatP2PScreen$listIsForwardable(snapshotStateList);
            zChangedInstance = composer.changedInstance(navHostController) | composer.changedInstance(chatViewModel);
            objRememberedValue = composer.rememberedValue();
            if (zChangedInstance) {
                objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.g7
                    @Override // lb.a
                    public final Object invoke() {
                        return ChatP2PScreenKt.ChatP2PScreen$lambda$76$0$4$0(navHostController, chatViewModel, snapshotStateList);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.g7
                    @Override // lb.a
                    public final Object invoke() {
                        return ChatP2PScreenKt.ChatP2PScreen$lambda$76$0$4$0(navHostController, chatViewModel, snapshotStateList);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            lb.a aVar15 = (lb.a) objRememberedValue;
            zChanged = composer.changed(softwareKeyboardController);
            objRememberedValue2 = composer.rememberedValue();
            if (zChanged) {
                objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.h7
                    @Override // lb.a
                    public final Object invoke() {
                        return ChatP2PScreenKt.ChatP2PScreen$lambda$76$0$5$0(softwareKeyboardController, snapshotStateList, mutableState4);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            } else {
                objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.h7
                    @Override // lb.a
                    public final Object invoke() {
                        return ChatP2PScreenKt.ChatP2PScreen$lambda$76$0$5$0(softwareKeyboardController, snapshotStateList, mutableState4);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            lb.a aVar16 = (lb.a) objRememberedValue2;
            zChangedInstance2 = composer.changedInstance(chatViewModel);
            objRememberedValue3 = composer.rememberedValue();
            if (zChangedInstance2) {
                objRememberedValue3 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.i7
                    @Override // lb.a
                    public final Object invoke() {
                        return ChatP2PScreenKt.ChatP2PScreen$lambda$76$0$6$0(chatViewModel, snapshotStateList);
                    }
                };
                composer.updateRememberedValue(objRememberedValue3);
            } else {
                objRememberedValue3 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.i7
                    @Override // lb.a
                    public final Object invoke() {
                        return ChatP2PScreenKt.ChatP2PScreen$lambda$76$0$6$0(chatViewModel, snapshotStateList);
                    }
                };
                composer.updateRememberedValue(objRememberedValue3);
            }
            lb.a aVar17 = (lb.a) objRememberedValue3;
            zChangedInstance3 = composer.changedInstance(chatViewModel) | composer.changedInstance(context);
            objRememberedValue4 = composer.rememberedValue();
            if (zChangedInstance3) {
                objRememberedValue4 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.j7
                    @Override // lb.a
                    public final Object invoke() {
                        return ChatP2PScreenKt.ChatP2PScreen$lambda$76$0$7$0(chatViewModel, context, snapshotStateList);
                    }
                };
                composer.updateRememberedValue(objRememberedValue4);
            } else {
                objRememberedValue4 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.j7
                    @Override // lb.a
                    public final Object invoke() {
                        return ChatP2PScreenKt.ChatP2PScreen$lambda$76$0$7$0(chatViewModel, context, snapshotStateList);
                    }
                };
                composer.updateRememberedValue(objRememberedValue4);
            }
            lb.a aVar18 = (lb.a) objRememberedValue4;
            objRememberedValue5 = composer.rememberedValue();
            if (objRememberedValue5 == companion2.getEmpty()) {
                objRememberedValue5 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.k7
                    @Override // lb.a
                    public final Object invoke() {
                        return ChatP2PScreenKt.ChatP2PScreen$lambda$76$0$8$0(snapshotStateList);
                    }
                };
                composer.updateRememberedValue(objRememberedValue5);
            }
            lb.a aVar19 = (lb.a) objRememberedValue5;
            zChangedInstance4 = composer.changedInstance(managedActivityResultLauncher);
            objRememberedValue6 = composer.rememberedValue();
            if (zChangedInstance4) {
                objRememberedValue6 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.g3
                    @Override // lb.a
                    public final Object invoke() {
                        return ChatP2PScreenKt.ChatP2PScreen$lambda$76$0$9$0(managedActivityResultLauncher, mutableState5);
                    }
                };
                composer.updateRememberedValue(objRememberedValue6);
            } else {
                objRememberedValue6 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.g3
                    @Override // lb.a
                    public final Object invoke() {
                        return ChatP2PScreenKt.ChatP2PScreen$lambda$76$0$9$0(managedActivityResultLauncher, mutableState5);
                    }
                };
                composer.updateRememberedValue(objRememberedValue6);
            }
            lb.a aVar110 = (lb.a) objRememberedValue6;
            zChangedInstance5 = composer.changedInstance(chatViewModel) | composer.changed(state);
            objRememberedValue7 = composer.rememberedValue();
            if (zChangedInstance5) {
                objRememberedValue7 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.z6
                    @Override // lb.a
                    public final Object invoke() {
                        return ChatP2PScreenKt.ChatP2PScreen$lambda$76$0$10$0(chatViewModel, state);
                    }
                };
                composer.updateRememberedValue(objRememberedValue7);
            } else {
                objRememberedValue7 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.z6
                    @Override // lb.a
                    public final Object invoke() {
                        return ChatP2PScreenKt.ChatP2PScreen$lambda$76$0$10$0(chatViewModel, state);
                    }
                };
                composer.updateRememberedValue(objRememberedValue7);
            }
            lb.a aVar111 = (lb.a) objRememberedValue7;
            zChangedInstance6 = composer.changedInstance(chatViewModel) | composer.changedInstance(context);
            objRememberedValue8 = composer.rememberedValue();
            if (zChangedInstance6) {
                objRememberedValue8 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.b7
                    @Override // lb.a
                    public final Object invoke() {
                        return ChatP2PScreenKt.ChatP2PScreen$lambda$76$0$11$0(chatViewModel, chatParams, mutableState6, context);
                    }
                };
                composer.updateRememberedValue(objRememberedValue8);
            } else {
                objRememberedValue8 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.b7
                    @Override // lb.a
                    public final Object invoke() {
                        return ChatP2PScreenKt.ChatP2PScreen$lambda$76$0$11$0(chatViewModel, chatParams, mutableState6, context);
                    }
                };
                composer.updateRememberedValue(objRememberedValue8);
            }
            lb.a aVar112 = (lb.a) objRememberedValue8;
            zChangedInstance7 = composer.changedInstance(chatViewModel) | composer.changedInstance(context);
            objRememberedValue9 = composer.rememberedValue();
            if (zChangedInstance7) {
                objRememberedValue9 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.c7
                    @Override // lb.a
                    public final Object invoke() {
                        return ChatP2PScreenKt.ChatP2PScreen$lambda$76$0$12$0(chatViewModel, chatParams, mutableState6, context);
                    }
                };
                composer.updateRememberedValue(objRememberedValue9);
            } else {
                objRememberedValue9 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.c7
                    @Override // lb.a
                    public final Object invoke() {
                        return ChatP2PScreenKt.ChatP2PScreen$lambda$76$0$12$0(chatViewModel, chatParams, mutableState6, context);
                    }
                };
                composer.updateRememberedValue(objRememberedValue9);
            }
            ChatActionBarKt.ChatActionBar(companion, navHostController, chatScreenStateChatP2PScreen$lambda$6, size, zListIsEditable, aVar2, false, aVar3, true, aVar, zAvailable, aVar14, zChatP2PScreen$listIsForwardable2, aVar15, true, aVar16, false, null, true, aVar17, aVar18, aVar19, aVar110, aVar111, null, aVar112, (lb.a) objRememberedValue9, composer, 920125446, 100687872, 48, R.style.Animation);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatP2PScreen$lambda$76$0$0$0(MutableState mutableState, ChatViewModel chatViewModel, SnapshotStateList snapshotStateList, TextFieldState textFieldState) {
        List<String> listChatP2PScreen$clearSelection = ChatP2PScreen$clearSelection(snapshotStateList);
        if (!listChatP2PScreen$clearSelection.isEmpty()) {
            mutableState.setValue(ChatComplexFunctionalities.INSTANCE.findMsg(listChatP2PScreen$clearSelection.get(0), chatViewModel.getMsgList()));
            MessageWithPartnerWithReactions messageWithPartnerWithReactions = (MessageWithPartnerWithReactions) mutableState.getValue();
            if (messageWithPartnerWithReactions != null) {
                TextFieldStateKt.setTextAndPlaceCursorAtEnd(textFieldState, messageWithPartnerWithReactions.getMessage().getContent());
            }
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatP2PScreen$lambda$76$0$10$0(ChatViewModel chatViewModel, State state) {
        ChatScreenState chatScreenStateChatP2PScreen$lambda$6 = ChatP2PScreen$lambda$6(state);
        kotlin.jvm.internal.y.f(chatScreenStateChatP2PScreen$lambda$6);
        chatViewModel.removeChatBackground(chatScreenStateChatP2PScreen$lambda$6.getId());
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatP2PScreen$lambda$76$0$11$0(ChatViewModel chatViewModel, final ChatParams chatParams, MutableState mutableState, final Context context) {
        if (kotlin.jvm.internal.y.d(ChatP2PScreen$lambda$19(mutableState).getPermissionsResult(), PermissionsResult.INSTANCE.granted())) {
            chatViewModel.startAudioCallNew(chatParams.getUid(), new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.c6
                @Override // lb.a
                public final Object invoke() {
                    return ChatP2PScreenKt.ChatP2PScreen$lambda$76$0$11$0$0(context, chatParams);
                }
            });
        } else {
            mutableState.setValue(PermissionsRequesterState.copy$default(ChatP2PScreen$lambda$19(mutableState), null, true, null, 5, null));
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatP2PScreen$lambda$76$0$11$0$0(Context context, ChatParams chatParams) {
        AudioCallActivity.INSTANCE.start(context, chatParams.getUid());
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatP2PScreen$lambda$76$0$12$0(ChatViewModel chatViewModel, final ChatParams chatParams, MutableState mutableState, final Context context) {
        if (kotlin.jvm.internal.y.d(ChatP2PScreen$lambda$19(mutableState).getPermissionsResult(), PermissionsResult.INSTANCE.granted())) {
            chatViewModel.startVideoCallNew(chatParams.getUid(), new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.w6
                @Override // lb.a
                public final Object invoke() {
                    return ChatP2PScreenKt.ChatP2PScreen$lambda$76$0$12$0$0(context, chatParams);
                }
            });
        } else {
            mutableState.setValue(PermissionsRequesterState.copy$default(ChatP2PScreen$lambda$19(mutableState), null, true, null, 5, null));
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatP2PScreen$lambda$76$0$12$0$0(Context context, ChatParams chatParams) {
        VideoCallActivity.INSTANCE.start(context, chatParams.getUid());
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatP2PScreen$lambda$76$0$2$0(MutableState mutableState) {
        ChatP2PScreen$lambda$61(mutableState, true);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatP2PScreen$lambda$76$0$3$0(MutableState mutableState, ChatViewModel chatViewModel, MutableState mutableState2, SnapshotStateList snapshotStateList) {
        List<String> listChatP2PScreen$clearSelection = ChatP2PScreen$clearSelection(snapshotStateList);
        if (!listChatP2PScreen$clearSelection.isEmpty()) {
            mutableState.setValue(ChatComplexFunctionalities.INSTANCE.findMsg(listChatP2PScreen$clearSelection.get(0), chatViewModel.getMsgList()));
            mutableState2.setValue(null);
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatP2PScreen$lambda$76$0$4$0(NavHostController navHostController, ChatViewModel chatViewModel, SnapshotStateList snapshotStateList) {
        List<String> listChatP2PScreen$clearSelection = ChatP2PScreen$clearSelection(snapshotStateList);
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = listChatP2PScreen$clearSelection.iterator();
        while (it.hasNext()) {
            arrayList.add(new Send(3, (String) it.next()));
        }
        NavLinks navLinks = NavLinks.INSTANCE;
        String strT = chatViewModel.getGson().t(new SendToParams(arrayList));
        kotlin.jvm.internal.y.h(strT, "toJson(...)");
        NavController.navigate$default((NavController) navHostController, navLinks.goForwardTo(strT), (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatP2PScreen$lambda$76$0$5$0(SoftwareKeyboardController softwareKeyboardController, SnapshotStateList snapshotStateList, MutableState mutableState) {
        if (softwareKeyboardController != null) {
            softwareKeyboardController.hide();
        }
        mutableState.setValue((String) va.g0.w0(ChatP2PScreen$clearSelection(snapshotStateList)));
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatP2PScreen$lambda$76$0$6$0(ChatViewModel chatViewModel, SnapshotStateList snapshotStateList) {
        chatViewModel.share(ChatP2PScreen$clearSelection(snapshotStateList));
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatP2PScreen$lambda$76$0$7$0(ChatViewModel chatViewModel, Context context, SnapshotStateList snapshotStateList) {
        chatViewModel.pastToClipboard(ChatP2PScreen$clearSelection(snapshotStateList), context);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatP2PScreen$lambda$76$0$8$0(SnapshotStateList snapshotStateList) {
        ChatP2PScreen$clearSelection(snapshotStateList);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatP2PScreen$lambda$76$0$9$0(ManagedActivityResultLauncher managedActivityResultLauncher, MutableState mutableState) {
        Integer state = ChatP2PScreen$lambda$16(mutableState).getPermissionsResult().getState();
        if (state != null && state.intValue() == 2) {
            managedActivityResultLauncher.launch("image/*");
        } else {
            mutableState.setValue(PermissionsRequesterState.copy$default(ChatP2PScreen$lambda$16(mutableState), null, true, null, 5, null));
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r5v0 java.lang.Object
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
        	at jadx.core.dex.visitors.ModVisitor.anonymousCallArgMod(ModVisitor.java:535)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
        	at jadx.core.dex.visitors.ModVisitor.processAnonymousConstructor(ModVisitor.java:528)
        	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:111)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
        */
    @androidx.compose.runtime.ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @androidx.compose.runtime.Composable
    public static final ua.k0 ChatP2PScreen$lambda$77(final androidx.compose.runtime.snapshots.SnapshotStateList r50, final cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel r51, final androidx.compose.runtime.State r52, final androidx.compose.foundation.text.input.TextFieldState r53, final cu.todus.android.uiCompose.main.screen.chat.component.ChatParams r54, pe.m0 r55, final androidx.compose.runtime.MutableState r56, final androidx.compose.runtime.MutableState r57, final androidx.compose.runtime.snapshots.SnapshotStateList r58, final androidx.compose.runtime.MutableState r59, androidx.compose.runtime.MutableState r60, androidx.paging.compose.LazyPagingItems r61, final androidx.navigation.NavHostController r62, androidx.compose.ui.platform.SoftwareKeyboardController r63, final android.content.Context r64, final androidx.compose.ui.focus.FocusRequester r65, final androidx.compose.runtime.MutableState r66, final androidx.compose.runtime.MutableState r67, androidx.compose.runtime.MutableState r68, androidx.compose.runtime.State r69, final androidx.compose.runtime.MutableState r70, final androidx.compose.runtime.MutableState r71, final androidx.p000activity.compose.ManagedActivityResultLauncher r72, final androidx.compose.runtime.MutableState r73, final androidx.p000activity.compose.ManagedActivityResultLauncher r74, final androidx.compose.runtime.MutableState r75, final androidx.paging.compose.LazyPagingItems r76, final androidx.paging.compose.LazyPagingItems r77, final androidx.paging.compose.LazyPagingItems r78, final androidx.compose.runtime.State r79, final androidx.compose.runtime.MutableState r80, androidx.compose.runtime.State r81, final androidx.compose.runtime.MutableState r82, androidx.compose.runtime.State r83, androidx.compose.runtime.MutableState r84, androidx.compose.runtime.MutableState r85, cu.todus.android.uiCompose.main.screen.chat.component.p2p.ChatP2PScreenKt$ChatP2PScreen$notificationFilter$1$1 r86, androidx.compose.ui.Modifier r87, androidx.compose.runtime.Composer r88, int r89) {
        /*
            Method dump skipped, instruction units count: 3030
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.uiCompose.main.screen.chat.component.p2p.ChatP2PScreenKt.ChatP2PScreen$lambda$77(androidx.compose.runtime.snapshots.SnapshotStateList, cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel, androidx.compose.runtime.State, androidx.compose.foundation.text.input.TextFieldState, cu.todus.android.uiCompose.main.screen.chat.component.ChatParams, pe.m0, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.snapshots.SnapshotStateList, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.paging.compose.LazyPagingItems, androidx.navigation.NavHostController, androidx.compose.ui.platform.SoftwareKeyboardController, android.content.Context, androidx.compose.ui.focus.FocusRequester, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.State, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.activity.compose.ManagedActivityResultLauncher, androidx.compose.runtime.MutableState, androidx.activity.compose.ManagedActivityResultLauncher, androidx.compose.runtime.MutableState, androidx.paging.compose.LazyPagingItems, androidx.paging.compose.LazyPagingItems, androidx.paging.compose.LazyPagingItems, androidx.compose.runtime.State, androidx.compose.runtime.MutableState, androidx.compose.runtime.State, androidx.compose.runtime.MutableState, androidx.compose.runtime.State, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, cu.todus.android.uiCompose.main.screen.chat.component.p2p.ChatP2PScreenKt$ChatP2PScreen$notificationFilter$1$1, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int):ua.k0");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean ChatP2PScreen$lambda$77$0$0$0(LazyListState lazyListState) {
        return lazyListState.getFirstVisibleItemIndex() == 0;
    }

    private static final boolean ChatP2PScreen$lambda$77$0$1(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 ChatP2PScreen$lambda$77$0$10(final MutableState mutableState, ChatViewModel chatViewModel, Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1978741210, i10, -1, "cu.todus.android.uiCompose.main.screen.chat.component.p2p.ChatP2PScreen.<anonymous>.<anonymous>.<anonymous> (ChatP2PScreen.kt:952)");
            }
            MessageWithPartnerWithReactions messageWithPartnerWithReactions = (MessageWithPartnerWithReactions) mutableState.getValue();
            if (messageWithPartnerWithReactions == null) {
                composer.startReplaceGroup(-253198762);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-253198761);
                String nameWithDomain = chatViewModel.getOwner().getNameWithDomain();
                String alias = chatViewModel.getOwner().getAlias();
                Object objRememberedValue = composer.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.r3
                        @Override // lb.a
                        public final Object invoke() {
                            return ChatP2PScreenKt.ChatP2PScreen$lambda$77$0$10$0$0$0(mutableState);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                MsgPreviewKt.ReplyPreview(nameWithDomain, alias, messageWithPartnerWithReactions, (lb.a) objRememberedValue, composer, 3072);
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
    public static final ua.k0 ChatP2PScreen$lambda$77$0$10$0$0$0(MutableState mutableState) {
        mutableState.setValue(null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatP2PScreen$lambda$77$0$11$0(MutableState mutableState) {
        mutableState.setValue(null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 ChatP2PScreen$lambda$77$0$12(final MutableState mutableState, ChatViewModel chatViewModel, final TextFieldState textFieldState, Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2109142705, i10, -1, "cu.todus.android.uiCompose.main.screen.chat.component.p2p.ChatP2PScreen.<anonymous>.<anonymous>.<anonymous> (ChatP2PScreen.kt:969)");
            }
            MessageWithPartnerWithReactions messageWithPartnerWithReactions = (MessageWithPartnerWithReactions) mutableState.getValue();
            if (messageWithPartnerWithReactions == null) {
                composer.startReplaceGroup(1901267534);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(1901267535);
                String nameWithDomain = chatViewModel.getOwner().getNameWithDomain();
                String alias = chatViewModel.getOwner().getAlias();
                boolean zChanged = composer.changed(textFieldState);
                Object objRememberedValue = composer.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.q3
                        @Override // lb.a
                        public final Object invoke() {
                            return ChatP2PScreenKt.ChatP2PScreen$lambda$77$0$12$0$0$0(mutableState, textFieldState);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                MsgPreviewKt.EditPreview(messageWithPartnerWithReactions, nameWithDomain, alias, (lb.a) objRememberedValue, composer, 0);
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
    public static final ua.k0 ChatP2PScreen$lambda$77$0$12$0$0$0(MutableState mutableState, TextFieldState textFieldState) {
        mutableState.setValue(null);
        TextFieldStateKt.setTextAndPlaceCursorAtEnd(textFieldState, "");
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatP2PScreen$lambda$77$0$13$0(SnapshotStateList snapshotStateList, MutableState mutableState, MutableState mutableState2) {
        ChatP2PScreen$clearAttachedFilesToSend(snapshotStateList, mutableState, mutableState2);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 ChatP2PScreen$lambda$77$0$14(final SnapshotStateList snapshotStateList, final ManagedActivityResultLauncher managedActivityResultLauncher, MutableState mutableState, final MutableState mutableState2, final MutableState mutableState3, Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-770650450, i10, -1, "cu.todus.android.uiCompose.main.screen.chat.component.p2p.ChatP2PScreen.<anonymous>.<anonymous>.<anonymous> (ChatP2PScreen.kt:989)");
            }
            Integer state = ChatP2PScreen$lambda$16(mutableState).getPermissionsResult().getState();
            if (state != null && state.intValue() == 2) {
                composer.startReplaceGroup(-1847268773);
                Object objRememberedValue = composer.rememberedValue();
                Composer.Companion companion = Composer.INSTANCE;
                if (objRememberedValue == companion.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.d6
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ChatP2PScreenKt.ChatP2PScreen$lambda$77$0$14$0$0(snapshotStateList, mutableState2, mutableState3, (Uri) obj);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                Function1 function1 = (Function1) objRememberedValue;
                boolean zChangedInstance = composer.changedInstance(managedActivityResultLauncher);
                Object objRememberedValue2 = composer.rememberedValue();
                if (zChangedInstance || objRememberedValue2 == companion.getEmpty()) {
                    objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.f6
                        @Override // lb.a
                        public final Object invoke() {
                            return ChatP2PScreenKt.ChatP2PScreen$lambda$77$0$14$1$0(managedActivityResultLauncher);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue2);
                }
                PresentListKt.PresentList(snapshotStateList, function1, (lb.a) objRememberedValue2, composer, 54);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-1846875724);
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
    public static final ua.k0 ChatP2PScreen$lambda$77$0$14$0$0(SnapshotStateList snapshotStateList, MutableState mutableState, MutableState mutableState2, Uri it) {
        kotlin.jvm.internal.y.i(it, "it");
        ChatP2PScreen$removeAttachedFilesToSend(snapshotStateList, mutableState, mutableState2, it);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatP2PScreen$lambda$77$0$14$1$0(ManagedActivityResultLauncher managedActivityResultLauncher) {
        managedActivityResultLauncher.launch("*/*");
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatP2PScreen$lambda$77$0$15$0(MutableState mutableState) {
        ChatP2PScreen$lambda$36(mutableState, false);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 ChatP2PScreen$lambda$77$0$16(final ChatViewModel chatViewModel, final ManagedActivityResultLauncher managedActivityResultLauncher, NavHostController navHostController, final ManagedActivityResultLauncher managedActivityResultLauncher2, final Context context, final TextFieldState textFieldState, final MutableState mutableState, final MutableState mutableState2, final SnapshotStateList snapshotStateList, final MutableState mutableState3, final ChatParams chatParams, final MutableState mutableState4, final MutableState mutableState5, Composer composer, int i10) {
        ManagedActivityResultLauncher managedActivityResultLauncher3;
        final NavHostController navHostController2;
        final MutableState mutableState6;
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(567841805, i10, -1, "cu.todus.android.uiCompose.main.screen.chat.component.p2p.ChatP2PScreen.<anonymous>.<anonymous>.<anonymous> (ChatP2PScreen.kt:1007)");
            }
            v5.f gson = chatViewModel.getGson();
            List<BotShortcut> attachmentShortcuts = chatViewModel.getAttachmentShortcuts();
            boolean zChangedInstance = composer.changedInstance(managedActivityResultLauncher);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                lb.a aVar = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.j3
                    @Override // lb.a
                    public final Object invoke() {
                        return ChatP2PScreenKt.ChatP2PScreen$lambda$77$0$16$0$0(managedActivityResultLauncher, mutableState, mutableState2, snapshotStateList, mutableState3);
                    }
                };
                managedActivityResultLauncher3 = managedActivityResultLauncher;
                composer.updateRememberedValue(aVar);
                objRememberedValue = aVar;
            } else {
                managedActivityResultLauncher3 = managedActivityResultLauncher;
            }
            lb.a aVar2 = (lb.a) objRememberedValue;
            boolean zChangedInstance2 = composer.changedInstance(navHostController) | composer.changedInstance(chatViewModel);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChangedInstance2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                navHostController2 = navHostController;
                lb.a aVar3 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.k3
                    @Override // lb.a
                    public final Object invoke() {
                        return ChatP2PScreenKt.ChatP2PScreen$lambda$77$0$16$1$0(navHostController2, chatViewModel, chatParams, mutableState4, mutableState3);
                    }
                };
                composer.updateRememberedValue(aVar3);
                objRememberedValue2 = aVar3;
            } else {
                navHostController2 = navHostController;
            }
            lb.a aVar4 = (lb.a) objRememberedValue2;
            boolean zChangedInstance3 = composer.changedInstance(navHostController2) | composer.changedInstance(chatViewModel);
            Object objRememberedValue3 = composer.rememberedValue();
            if (zChangedInstance3 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                mutableState6 = mutableState3;
                lb.a aVar5 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.l3
                    @Override // lb.a
                    public final Object invoke() {
                        return ChatP2PScreenKt.ChatP2PScreen$lambda$77$0$16$2$0(navHostController2, chatViewModel, chatParams, mutableState4, mutableState6);
                    }
                };
                composer.updateRememberedValue(aVar5);
                objRememberedValue3 = aVar5;
            } else {
                mutableState6 = mutableState3;
            }
            lb.a aVar6 = (lb.a) objRememberedValue3;
            boolean zChangedInstance4 = composer.changedInstance(managedActivityResultLauncher2);
            Object objRememberedValue4 = composer.rememberedValue();
            if (zChangedInstance4 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.m3
                    @Override // lb.a
                    public final Object invoke() {
                        return ChatP2PScreenKt.ChatP2PScreen$lambda$77$0$16$3$0(managedActivityResultLauncher2, mutableState6);
                    }
                };
                composer.updateRememberedValue(objRememberedValue4);
            }
            lb.a aVar7 = (lb.a) objRememberedValue4;
            boolean zChangedInstance5 = composer.changedInstance(navHostController2);
            Object objRememberedValue5 = composer.rememberedValue();
            if (zChangedInstance5 || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue5 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.n3
                    @Override // lb.a
                    public final Object invoke() {
                        return ChatP2PScreenKt.ChatP2PScreen$lambda$77$0$16$4$0(navHostController2, chatParams, mutableState6);
                    }
                };
                composer.updateRememberedValue(objRememberedValue5);
            }
            lb.a aVar8 = (lb.a) objRememberedValue5;
            boolean zChangedInstance6 = composer.changedInstance(managedActivityResultLauncher3);
            Object objRememberedValue6 = composer.rememberedValue();
            if (zChangedInstance6 || objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                final ManagedActivityResultLauncher managedActivityResultLauncher4 = managedActivityResultLauncher3;
                lb.a aVar9 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.o3
                    @Override // lb.a
                    public final Object invoke() {
                        return ChatP2PScreenKt.ChatP2PScreen$lambda$77$0$16$5$0(managedActivityResultLauncher4, mutableState, mutableState2, snapshotStateList, mutableState6);
                    }
                };
                composer.updateRememberedValue(aVar9);
                objRememberedValue6 = aVar9;
            }
            lb.a aVar10 = (lb.a) objRememberedValue6;
            boolean zChangedInstance7 = composer.changedInstance(context) | composer.changedInstance(r2) | composer.changedInstance(navHostController2) | composer.changed(textFieldState);
            Object objRememberedValue7 = composer.rememberedValue();
            if (zChangedInstance7 || objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                final NavHostController navHostController3 = navHostController2;
                Function1 function1 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.p3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ChatP2PScreenKt.ChatP2PScreen$lambda$77$0$16$6$0(context, chatViewModel, chatParams, navHostController3, textFieldState, mutableState5, mutableState3, (ButtonContent) obj);
                    }
                };
                composer.updateRememberedValue(function1);
                objRememberedValue7 = function1;
            }
            AttachmentSelectorKt.AttachmentSelector(aVar2, aVar4, aVar6, aVar7, aVar8, aVar10, (Function1) objRememberedValue7, gson, attachmentShortcuts, composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatP2PScreen$lambda$77$0$16$0$0(ManagedActivityResultLauncher managedActivityResultLauncher, MutableState mutableState, MutableState mutableState2, SnapshotStateList snapshotStateList, MutableState mutableState3) {
        Integer state = ChatP2PScreen$lambda$16(mutableState).getPermissionsResult().getState();
        if (state == null || state.intValue() != 2) {
            mutableState.setValue(PermissionsRequesterState.copy$default(ChatP2PScreen$lambda$16(mutableState), null, true, null, 5, null));
        } else if (ChatP2PScreen$lambda$38(mutableState2)) {
            ChatP2PScreen$clearAttachedFilesToSend(snapshotStateList, mutableState2, mutableState3);
        } else {
            managedActivityResultLauncher.launch("*/*");
        }
        ChatP2PScreen$lambda$36(mutableState3, false);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatP2PScreen$lambda$77$0$16$1$0(NavHostController navHostController, ChatViewModel chatViewModel, ChatParams chatParams, MutableState mutableState, MutableState mutableState2) {
        ChatP2PScreen$createAndSendDate(navHostController, chatViewModel, chatParams, mutableState);
        ChatP2PScreen$lambda$36(mutableState2, false);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatP2PScreen$lambda$77$0$16$2$0(NavHostController navHostController, ChatViewModel chatViewModel, ChatParams chatParams, MutableState mutableState, MutableState mutableState2) {
        ChatP2PScreen$selectMapLocation(navHostController, chatViewModel, chatParams, mutableState);
        ChatP2PScreen$lambda$36(mutableState2, false);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatP2PScreen$lambda$77$0$16$3$0(ManagedActivityResultLauncher managedActivityResultLauncher, MutableState mutableState) {
        managedActivityResultLauncher.launch(null);
        ChatP2PScreen$lambda$36(mutableState, false);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatP2PScreen$lambda$77$0$16$4$0(NavHostController navHostController, ChatParams chatParams, MutableState mutableState) {
        NavController.navigate$default((NavController) navHostController, NavLinks.INSTANCE.goPubEditor(chatParams.getUid()), (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        ChatP2PScreen$lambda$36(mutableState, false);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatP2PScreen$lambda$77$0$16$5$0(ManagedActivityResultLauncher managedActivityResultLauncher, MutableState mutableState, MutableState mutableState2, SnapshotStateList snapshotStateList, MutableState mutableState3) {
        Integer state = ChatP2PScreen$lambda$16(mutableState).getPermissionsResult().getState();
        if (state == null || state.intValue() != 2) {
            mutableState.setValue(PermissionsRequesterState.copy$default(ChatP2PScreen$lambda$16(mutableState), null, true, null, 5, null));
        } else if (ChatP2PScreen$lambda$38(mutableState2)) {
            ChatP2PScreen$clearAttachedFilesToSend(snapshotStateList, mutableState2, mutableState3);
        } else {
            managedActivityResultLauncher.launch(VideoSpec.MIME_TYPE_UNSPECIFIED);
        }
        ChatP2PScreen$lambda$36(mutableState3, false);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatP2PScreen$lambda$77$0$16$6$0(Context context, ChatViewModel chatViewModel, ChatParams chatParams, NavHostController navHostController, TextFieldState textFieldState, MutableState mutableState, MutableState mutableState2, ButtonContent it) {
        kotlin.jvm.internal.y.i(it, "it");
        ChatP2PScreen$onClickInShortcut(context, chatViewModel, chatParams, navHostController, textFieldState, mutableState, it);
        ChatP2PScreen$lambda$36(mutableState2, false);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatP2PScreen$lambda$77$0$17$0(MutableState mutableState) {
        ChatP2PScreen$lambda$67(mutableState, false);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 ChatP2PScreen$lambda$77$0$18(LazyPagingItems lazyPagingItems, LazyPagingItems lazyPagingItems2, LazyPagingItems lazyPagingItems3, final NavHostController navHostController, final ChatViewModel chatViewModel, final MutableState mutableState, final ChatParams chatParams, final MutableState mutableState2, final FocusRequester focusRequester, Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1906334060, i10, -1, "cu.todus.android.uiCompose.main.screen.chat.component.p2p.ChatP2PScreen.<anonymous>.<anonymous>.<anonymous> (ChatP2PScreen.kt:1066)");
            }
            boolean zChangedInstance = composer.changedInstance(navHostController) | composer.changedInstance(chatViewModel);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.h3
                    @Override // lb.a
                    public final Object invoke() {
                        return ChatP2PScreenKt.ChatP2PScreen$lambda$77$0$18$0$0(navHostController, chatViewModel, mutableState);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            lb.a aVar = (lb.a) objRememberedValue;
            boolean zChangedInstance2 = composer.changedInstance(chatViewModel);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChangedInstance2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                Function1 function1 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.i3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ChatP2PScreenKt.ChatP2PScreen$lambda$77$0$18$1$0(chatViewModel, chatParams, mutableState2, focusRequester, mutableState, (Sticker) obj);
                    }
                };
                composer.updateRememberedValue(function1);
                objRememberedValue2 = function1;
            }
            Function1 function2 = (Function1) objRememberedValue2;
            boolean zChangedInstance3 = composer.changedInstance(chatViewModel);
            Object objRememberedValue3 = composer.rememberedValue();
            if (zChangedInstance3 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new ChatP2PScreenKt$ChatP2PScreen$4$1$17$3$1(chatViewModel);
                composer.updateRememberedValue(objRememberedValue3);
            }
            int i11 = LazyPagingItems.$stable;
            GroupsContainerKt.GroupsContainer(lazyPagingItems, lazyPagingItems2, lazyPagingItems3, aVar, function2, (Function2) ((sb.h) objRememberedValue3), composer, (i11 << 6) | (i11 << 3) | i11);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatP2PScreen$lambda$77$0$18$0$0(NavHostController navHostController, ChatViewModel chatViewModel, MutableState mutableState) {
        NavLinks navLinks = NavLinks.INSTANCE;
        String strT = chatViewModel.getGson().t(new ManageStickersParams(null, 1, null));
        kotlin.jvm.internal.y.h(strT, "toJson(...)");
        NavController.navigate$default((NavController) navHostController, navLinks.goManageStickers(strT), (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        ChatP2PScreen$lambda$67(mutableState, false);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatP2PScreen$lambda$77$0$18$1$0(ChatViewModel chatViewModel, ChatParams chatParams, MutableState mutableState, FocusRequester focusRequester, MutableState mutableState2, Sticker it) {
        Message message;
        kotlin.jvm.internal.y.i(it, "it");
        String uid = chatParams.getUid();
        MessageWithPartnerWithReactions messageWithPartnerWithReactions = (MessageWithPartnerWithReactions) mutableState.getValue();
        chatViewModel.sendSticker(uid, it, (messageWithPartnerWithReactions == null || (message = messageWithPartnerWithReactions.getMessage()) == null) ? null : message.getId());
        mutableState.setValue(null);
        ChatP2PScreen$lambda$67(mutableState2, false);
        FocusRequester.m5530requestFocus3ESFkO8$default(focusRequester, 0, 1, null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 ChatP2PScreen$lambda$77$0$19(TextFieldState textFieldState, final ChatViewModel chatViewModel, final Context context, FocusRequester focusRequester, State state, MutableState mutableState, final MutableState mutableState2, SnapshotStateList snapshotStateList, ChatParams chatParams, final MutableState mutableState3, final MutableState mutableState4, MutableState mutableState5, final MutableState mutableState6, Composer composer, int i10) {
        Object obj;
        final MutableState mutableState7;
        final SnapshotStateList snapshotStateList2;
        final ChatParams chatParams2;
        final MutableState mutableState8;
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(489922371, i10, -1, "cu.todus.android.uiCompose.main.screen.chat.component.p2p.ChatP2PScreen.<anonymous>.<anonymous>.<anonymous> (ChatP2PScreen.kt:1104)");
            }
            long jChatP2PScreen$lambda$14 = ChatP2PScreen$lambda$14(state);
            boolean zChatP2PScreen$lambda$38 = ChatP2PScreen$lambda$38(mutableState);
            boolean zChatP2PScreen$lambda$66 = ChatP2PScreen$lambda$66(mutableState2);
            boolean zChangedInstance = composer.changedInstance(chatViewModel) | composer.changedInstance(context);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                mutableState7 = mutableState;
                snapshotStateList2 = snapshotStateList;
                chatParams2 = chatParams;
                mutableState8 = mutableState5;
                obj = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.g6
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return ChatP2PScreenKt.ChatP2PScreen$lambda$77$0$19$0$0(chatViewModel, snapshotStateList2, chatParams2, mutableState3, mutableState4, context, mutableState7, mutableState8, (String) obj2);
                    }
                };
                composer.updateRememberedValue(obj);
            } else {
                mutableState7 = mutableState;
                chatParams2 = chatParams;
                mutableState8 = mutableState5;
                obj = objRememberedValue;
                snapshotStateList2 = snapshotStateList;
            }
            Function1 function1 = (Function1) obj;
            boolean zChangedInstance2 = composer.changedInstance(chatViewModel);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChangedInstance2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.h6
                    @Override // lb.a
                    public final Object invoke() {
                        return ChatP2PScreenKt.ChatP2PScreen$lambda$77$0$19$1$0(chatViewModel, chatParams2);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            lb.a aVar = (lb.a) objRememberedValue2;
            boolean zChangedInstance3 = composer.changedInstance(chatViewModel);
            Object objRememberedValue3 = composer.rememberedValue();
            if (zChangedInstance3 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.i6
                    @Override // lb.a
                    public final Object invoke() {
                        return ChatP2PScreenKt.ChatP2PScreen$lambda$77$0$19$2$0(chatViewModel, chatParams2);
                    }
                };
                composer.updateRememberedValue(objRememberedValue3);
            }
            lb.a aVar2 = (lb.a) objRememberedValue3;
            boolean zChangedInstance4 = composer.changedInstance(chatViewModel);
            Object objRememberedValue4 = composer.rememberedValue();
            if (zChangedInstance4 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.j6
                    @Override // lb.a
                    public final Object invoke() {
                        return ChatP2PScreenKt.ChatP2PScreen$lambda$77$0$19$3$0(chatViewModel);
                    }
                };
                composer.updateRememberedValue(objRememberedValue4);
            }
            lb.a aVar3 = (lb.a) objRememberedValue4;
            Object objRememberedValue5 = composer.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (objRememberedValue5 == companion.getEmpty()) {
                objRememberedValue5 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.k6
                    @Override // lb.a
                    public final Object invoke() {
                        return ChatP2PScreenKt.ChatP2PScreen$lambda$77$0$19$4$0(snapshotStateList2, mutableState7, mutableState8);
                    }
                };
                composer.updateRememberedValue(objRememberedValue5);
            }
            lb.a aVar4 = (lb.a) objRememberedValue5;
            Object objRememberedValue6 = composer.rememberedValue();
            if (objRememberedValue6 == companion.getEmpty()) {
                objRememberedValue6 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.l6
                    @Override // lb.a
                    public final Object invoke() {
                        return ChatP2PScreenKt.ChatP2PScreen$lambda$77$0$19$5$0(mutableState2);
                    }
                };
                composer.updateRememberedValue(objRememberedValue6);
            }
            lb.a aVar5 = (lb.a) objRememberedValue6;
            Object objRememberedValue7 = composer.rememberedValue();
            if (objRememberedValue7 == companion.getEmpty()) {
                objRememberedValue7 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.m6
                    @Override // lb.a
                    public final Object invoke() {
                        return ChatP2PScreenKt.ChatP2PScreen$lambda$77$0$19$6$0(snapshotStateList2, mutableState7, mutableState8, mutableState6);
                    }
                };
                composer.updateRememberedValue(objRememberedValue7);
            }
            ChatInputKt.ChatInput(textFieldState, null, function1, aVar, aVar2, aVar3, aVar4, aVar5, (lb.a) objRememberedValue7, zChatP2PScreen$lambda$38, jChatP2PScreen$lambda$14, focusRequester, zChatP2PScreen$lambda$66, composer, 114819072, 48, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatP2PScreen$lambda$77$0$19$0$0(ChatViewModel chatViewModel, SnapshotStateList snapshotStateList, ChatParams chatParams, MutableState mutableState, MutableState mutableState2, Context context, MutableState mutableState3, MutableState mutableState4, String messageContent) {
        Message message;
        Message message2;
        kotlin.jvm.internal.y.i(messageContent, "messageContent");
        chatViewModel.sendTyping(false);
        if (snapshotStateList.isEmpty()) {
            String uid = chatParams.getUid();
            MessageWithPartnerWithReactions messageWithPartnerWithReactions = (MessageWithPartnerWithReactions) mutableState.getValue();
            String id2 = (messageWithPartnerWithReactions == null || (message2 = messageWithPartnerWithReactions.getMessage()) == null) ? null : message2.getId();
            MessageWithPartnerWithReactions messageWithPartnerWithReactions2 = (MessageWithPartnerWithReactions) mutableState2.getValue();
            ChatViewModel.sendMessage$default(chatViewModel, messageContent, uid, false, null, id2, (messageWithPartnerWithReactions2 == null || (message = messageWithPartnerWithReactions2.getMessage()) == null) ? null : message.getId(), null, 76, null);
        } else {
            ChatP2PScreen$selectMethodAndSend(chatParams, mutableState, chatViewModel, context, snapshotStateList, mutableState3, mutableState4, messageContent);
        }
        mutableState.setValue(null);
        mutableState2.setValue(null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatP2PScreen$lambda$77$0$19$1$0(ChatViewModel chatViewModel, ChatParams chatParams) {
        chatViewModel.startRecorder(chatParams.getUid());
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatP2PScreen$lambda$77$0$19$2$0(ChatViewModel chatViewModel, ChatParams chatParams) {
        chatViewModel.stopRecorderAndSend(chatParams.getUid());
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatP2PScreen$lambda$77$0$19$3$0(ChatViewModel chatViewModel) {
        chatViewModel.stopRecorder();
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatP2PScreen$lambda$77$0$19$4$0(SnapshotStateList snapshotStateList, MutableState mutableState, MutableState mutableState2) {
        ChatP2PScreen$clearAttachedFilesToSend(snapshotStateList, mutableState, mutableState2);
        ChatP2PScreen$lambda$36(mutableState2, true);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatP2PScreen$lambda$77$0$19$5$0(MutableState mutableState) {
        ChatP2PScreen$lambda$67(mutableState, !ChatP2PScreen$lambda$66(mutableState));
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatP2PScreen$lambda$77$0$19$6$0(SnapshotStateList snapshotStateList, MutableState mutableState, MutableState mutableState2, MutableState mutableState3) {
        ChatP2PScreen$clearAttachedFilesToSend(snapshotStateList, mutableState, mutableState2);
        ChatP2PScreen$lambda$64(mutableState3, true);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatP2PScreen$lambda$77$0$2$0(pe.m0 m0Var, LazyListState lazyListState, boolean z10) {
        pe.k.d(m0Var, null, null, new ChatP2PScreenKt$ChatP2PScreen$4$1$1$1$1(z10, lazyListState, null), 3, null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatP2PScreen$lambda$77$0$3$0(pe.m0 m0Var, LazyListState lazyListState, int i10) {
        pe.k.d(m0Var, null, null, new ChatP2PScreenKt$ChatP2PScreen$4$1$2$1$1(lazyListState, i10, null), 3, null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatP2PScreen$lambda$77$0$4$10$0(ChatViewModel chatViewModel, SnapshotStateList snapshotStateList, SoftwareKeyboardController softwareKeyboardController, Context context, NavHostController navHostController, ChatParams chatParams, TextFieldState textFieldState, MutableState mutableState, State state, MutableState mutableState2, MutableState mutableState3, MutableState mutableState4, boolean z10, MessageAction messageAction, MessageWithPartnerWithReactions msg, int i10) throws IllegalAccessException, SinglediException, IOException, InvocationTargetException {
        kotlin.jvm.internal.y.i(messageAction, "messageAction");
        kotlin.jvm.internal.y.i(msg, "msg");
        if (msg.getMessage().getState() == 4) {
            chatViewModel.tryResend(msg.getMessage().getId());
        } else if (ChatP2PScreen$selectedListIsEmpty(snapshotStateList)) {
            ChatP2PScreen$attachmentClicked(softwareKeyboardController, context, chatViewModel, navHostController, chatParams, textFieldState, mutableState, state, mutableState2, z10, messageAction, msg, i10);
        } else if (ChatP2PScreen$selectedContains(snapshotStateList, msg.getMessage().getId())) {
            ChatP2PScreen$removeItemFromSelected(snapshotStateList, chatViewModel, msg.getMessage().getId());
        } else {
            ChatP2PScreen$addItemToSelected(mutableState3, mutableState4, snapshotStateList, chatViewModel, msg);
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatP2PScreen$lambda$77$0$4$11$0(SnapshotStateList snapshotStateList, ChatViewModel chatViewModel, MutableState mutableState, MutableState mutableState2, MessageWithPartnerWithReactions msg, int i10) {
        kotlin.jvm.internal.y.i(msg, "msg");
        if (ChatP2PScreen$selectedContains(snapshotStateList, msg.getMessage().getId())) {
            ChatP2PScreen$removeItemFromSelected(snapshotStateList, chatViewModel, msg.getMessage().getId());
        } else {
            ChatP2PScreen$addItemToSelected(mutableState, mutableState2, snapshotStateList, chatViewModel, msg);
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatP2PScreen$lambda$77$0$4$12$0(ChatViewModel chatViewModel, Context context, TextFieldState textFieldState, MutableState mutableState, NavHostController navHostController, MessageWithPartnerWithReactions msg, MessageAction messageAction, String value) {
        Object next;
        String username;
        kotlin.jvm.internal.y.i(msg, "msg");
        kotlin.jvm.internal.y.i(messageAction, "messageAction");
        kotlin.jvm.internal.y.i(value, "value");
        int i10 = WhenMappings.$EnumSwitchMapping$0[messageAction.ordinal()];
        if (i10 == 1) {
            Iterator<T> it = msg.getMessage().getMessageEntities().iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!kotlin.jvm.internal.y.d(((MessageEntity) next).getUrl(), value));
            MessageEntity mentionName = (MessageEntity) next;
            if (mentionName == null) {
                mentionName = new MentionName("", value, 0, 0, null);
            }
            ChatP2PScreen$handleClickOnMention(chatViewModel, mutableState, navHostController, mentionName);
        } else if (i10 == 3) {
            User senderUser = msg.getSenderUser();
            if (senderUser == null || (username = senderUser.getUsername()) == null) {
                username = "";
            }
            chatViewModel.requestUserByContact(value, value, username);
        } else if (i10 == 4) {
            IntentUtil.INSTANCE.showWeb(context, value);
        } else if (i10 == 5) {
            TextFieldStateKt.setTextAndPlaceCursorAtEnd(textFieldState, value);
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatP2PScreen$lambda$77$0$4$13$0(State state, NavHostController navHostController) {
        String toDusId;
        ChatScreenState chatScreenStateChatP2PScreen$lambda$6 = ChatP2PScreen$lambda$6(state);
        if (chatScreenStateChatP2PScreen$lambda$6 != null && (toDusId = chatScreenStateChatP2PScreen$lambda$6.getToDusId()) != null) {
            NavController.navigate$default((NavController) navHostController, NavLinks.INSTANCE.goCatalogueCheckIn(toDusId), (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatP2PScreen$lambda$77$0$4$14$0(NavHostController navHostController, ChatParams chatParams) {
        NavController.navigate$default((NavController) navHostController, NavLinks.INSTANCE.goSocialProfile(chatParams.getUid()), (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatP2PScreen$lambda$77$0$4$15$0(ChatViewModel chatViewModel, ChatParams chatParams, MutableState mutableState) {
        chatViewModel.displayAllMsg(chatParams.getUid());
        Function1 function1ChatP2PScreen$lambda$9 = ChatP2PScreen$lambda$9(mutableState);
        if (function1ChatP2PScreen$lambda$9 != null) {
            function1ChatP2PScreen$lambda$9.invoke(Boolean.FALSE);
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatP2PScreen$lambda$77$0$4$4$0(FocusRequester focusRequester, MutableState mutableState, SnapshotStateList snapshotStateList, MessageWithPartnerWithReactions it) {
        kotlin.jvm.internal.y.i(it, "it");
        FocusRequester.m5530requestFocus3ESFkO8$default(focusRequester, 0, 1, null);
        ChatP2PScreen$clearSelection(snapshotStateList);
        mutableState.setValue(it);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatP2PScreen$lambda$77$0$4$5$0(ChatViewModel chatViewModel, SnapshotStateList snapshotStateList, String roomId, String msgId, String value) {
        kotlin.jvm.internal.y.i(roomId, "roomId");
        kotlin.jvm.internal.y.i(msgId, "msgId");
        kotlin.jvm.internal.y.i(value, "value");
        ChatP2PScreen$clearSelection(snapshotStateList);
        chatViewModel.onReacted(roomId, msgId, value);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatP2PScreen$lambda$77$0$4$6$0(NavHostController navHostController) {
        NavController.navigate$default((NavController) navHostController, NavLinks.REACT_SELECTION, (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatP2PScreen$lambda$77$0$4$7$0(String it) {
        kotlin.jvm.internal.y.i(it, "it");
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatP2PScreen$lambda$77$0$4$9$0(final ChatViewModel chatViewModel, final NavHostController navHostController, final String it) {
        kotlin.jvm.internal.y.i(it, "it");
        chatViewModel.getStatusPosition(it, new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.z5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ChatP2PScreenKt.ChatP2PScreen$lambda$77$0$4$9$0$0(navHostController, chatViewModel, it, (Pair) obj);
            }
        });
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatP2PScreen$lambda$77$0$4$9$0$0(NavHostController navHostController, ChatViewModel chatViewModel, String str, Pair result) {
        kotlin.jvm.internal.y.i(result, "result");
        NavLinks navLinks = NavLinks.INSTANCE;
        String strT = chatViewModel.getGson().t(new StatusPreviewParams(((Boolean) result.getFirst()).booleanValue(), ((Number) result.getSecond()).intValue(), str));
        kotlin.jvm.internal.y.h(strT, "toJson(...)");
        NavController.navigate$default((NavController) navHostController, navLinks.goStatusPreview(strT), (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatP2PScreen$lambda$77$0$5$0(ChatViewModel chatViewModel, State state) {
        ChatScreenState chatScreenStateChatP2PScreen$lambda$6 = ChatP2PScreen$lambda$6(state);
        String id2 = chatScreenStateChatP2PScreen$lambda$6 != null ? chatScreenStateChatP2PScreen$lambda$6.getId() : null;
        kotlin.jvm.internal.y.f(id2);
        chatViewModel.setUnknownRoomAsAccepted(id2);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatP2PScreen$lambda$77$0$6$0(ChatViewModel chatViewModel, State state) {
        ChatScreenState chatScreenStateChatP2PScreen$lambda$6 = ChatP2PScreen$lambda$6(state);
        String id2 = chatScreenStateChatP2PScreen$lambda$6 != null ? chatScreenStateChatP2PScreen$lambda$6.getId() : null;
        kotlin.jvm.internal.y.f(id2);
        chatViewModel.setUnknownRoomAsAccepted(id2);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatP2PScreen$lambda$77$0$7$0(ChatViewModel chatViewModel, State state) {
        ChatScreenState chatScreenStateChatP2PScreen$lambda$6 = ChatP2PScreen$lambda$6(state);
        String id2 = chatScreenStateChatP2PScreen$lambda$6 != null ? chatScreenStateChatP2PScreen$lambda$6.getId() : null;
        kotlin.jvm.internal.y.f(id2);
        chatViewModel.setUnknownUserAsShared(id2);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatP2PScreen$lambda$77$0$8$0(ChatViewModel chatViewModel, State state) {
        ChatScreenState chatScreenStateChatP2PScreen$lambda$6 = ChatP2PScreen$lambda$6(state);
        String id2 = chatScreenStateChatP2PScreen$lambda$6 != null ? chatScreenStateChatP2PScreen$lambda$6.getId() : null;
        kotlin.jvm.internal.y.f(id2);
        chatViewModel.setUnknownUserAsBlocked(id2);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatP2PScreen$lambda$77$0$9$0(MutableState mutableState) {
        mutableState.setValue(null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ChatP2PScreen$lambda$77$0$goReply(MutableState<Function1> mutableState, int i10) {
        Function1 function1ChatP2PScreen$lambda$12 = ChatP2PScreen$lambda$12(mutableState);
        if (function1ChatP2PScreen$lambda$12 != null) {
            function1ChatP2PScreen$lambda$12.invoke(Integer.valueOf(i10));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatP2PScreen$lambda$77$1$0$0(ChatViewModel chatViewModel) {
        chatViewModel.readRequestingFriend();
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatP2PScreen$lambda$77$1$1$0(NavHostController navHostController, String it) {
        kotlin.jvm.internal.y.i(it, "it");
        NavController.navigate$default((NavController) navHostController, it, (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatP2PScreen$lambda$77$1$10$0(MutableState mutableState) {
        ChatP2PScreen$lambda$64(mutableState, false);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 ChatP2PScreen$lambda$77$1$11(final MutableState mutableState, final ChatViewModel chatViewModel, final NavHostController navHostController, Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-922216059, i10, -1, "cu.todus.android.uiCompose.main.screen.chat.component.p2p.ChatP2PScreen.<anonymous>.<anonymous>.<anonymous> (ChatP2PScreen.kt:1244)");
            }
            AttachmentPreviewState attachmentPreviewStateChatP2PScreen$lambda$32 = ChatP2PScreen$lambda$32(mutableState);
            if (attachmentPreviewStateChatP2PScreen$lambda$32 == null) {
                composer.startReplaceGroup(1167238457);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(1167238458);
                boolean zChangedInstance = composer.changedInstance(chatViewModel);
                Object objRememberedValue = composer.rememberedValue();
                if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.x4
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ChatP2PScreenKt.ChatP2PScreen$lambda$77$1$11$0$0$0(chatViewModel, (String) obj);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                Function1 function1 = (Function1) objRememberedValue;
                Object objRememberedValue2 = composer.rememberedValue();
                Composer.Companion companion = Composer.INSTANCE;
                if (objRememberedValue2 == companion.getEmpty()) {
                    objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.i5
                        @Override // lb.a
                        public final Object invoke() {
                            return ChatP2PScreenKt.ChatP2PScreen$lambda$77$1$11$0$1$0(mutableState);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue2);
                }
                lb.a aVar = (lb.a) objRememberedValue2;
                boolean zChangedInstance2 = composer.changedInstance(navHostController) | composer.changedInstance(chatViewModel);
                Object objRememberedValue3 = composer.rememberedValue();
                if (zChangedInstance2 || objRememberedValue3 == companion.getEmpty()) {
                    objRememberedValue3 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.t5
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ChatP2PScreenKt.ChatP2PScreen$lambda$77$1$11$0$2$0(navHostController, chatViewModel, (String) obj);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue3);
                }
                AttachmentPreviewKt.AttachmentPreviewWithOptions(attachmentPreviewStateChatP2PScreen$lambda$32, function1, aVar, (Function1) objRememberedValue3, null, composer, RendererCapabilities.DECODER_SUPPORT_MASK, 16);
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
    public static final ua.k0 ChatP2PScreen$lambda$77$1$11$0$0$0(ChatViewModel chatViewModel, String it) {
        kotlin.jvm.internal.y.i(it, "it");
        chatViewModel.share(va.v.e(it));
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatP2PScreen$lambda$77$1$11$0$1$0(MutableState mutableState) {
        mutableState.setValue(null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatP2PScreen$lambda$77$1$11$0$2$0(NavHostController navHostController, ChatViewModel chatViewModel, String it) {
        kotlin.jvm.internal.y.i(it, "it");
        NavLinks navLinks = NavLinks.INSTANCE;
        String strT = chatViewModel.getGson().t(new ManageStickersParams(it));
        kotlin.jvm.internal.y.h(strT, "toJson(...)");
        NavController.navigate$default((NavController) navHostController, navLinks.goManageStickers(strT), (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatP2PScreen$lambda$77$1$12$0(MutableState mutableState) {
        mutableState.setValue("");
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 ChatP2PScreen$lambda$77$1$13(NavHostController navHostController, MutableState mutableState, Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1376695512, i10, -1, "cu.todus.android.uiCompose.main.screen.chat.component.p2p.ChatP2PScreen.<anonymous>.<anonymous>.<anonymous> (ChatP2PScreen.kt:1269)");
            }
            MsgDetailsDialogKt.MsgDetailsDialog(ChatP2PScreen$lambda$72(mutableState), navHostController, null, composer, 0, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatP2PScreen$lambda$77$1$14$0(MutableState mutableState) {
        mutableState.setValue(PermissionsRequesterState.copy$default(ChatP2PScreen$lambda$16(mutableState), null, true, null, 5, null));
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatP2PScreen$lambda$77$1$15$0(MutableState mutableState, PermissionsResult result) {
        kotlin.jvm.internal.y.i(result, "result");
        mutableState.setValue(PermissionsRequesterState.copy$default(ChatP2PScreen$lambda$16(mutableState), result, false, null, 6, null));
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatP2PScreen$lambda$77$1$16$0(MutableState mutableState) {
        mutableState.setValue(PermissionsRequesterState.copy$default(ChatP2PScreen$lambda$16(mutableState), null, false, null, 5, null));
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatP2PScreen$lambda$77$1$17$0(MutableState mutableState, PermissionsResult result) {
        kotlin.jvm.internal.y.i(result, "result");
        mutableState.setValue(PermissionsRequesterState.copy$default(ChatP2PScreen$lambda$16(mutableState), result, false, null, 6, null));
        Integer state = result.getState();
        if (state != null && state.intValue() == 2) {
            mutableState.setValue(PermissionsRequesterState.copy$default(ChatP2PScreen$lambda$16(mutableState), null, false, null, 5, null));
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatP2PScreen$lambda$77$1$18$0(MutableState mutableState, PermissionsResult result) {
        kotlin.jvm.internal.y.i(result, "result");
        mutableState.setValue(PermissionsRequesterState.copy$default(ChatP2PScreen$lambda$19(mutableState), result, false, null, 6, null));
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatP2PScreen$lambda$77$1$19$0(MutableState mutableState) {
        mutableState.setValue(PermissionsRequesterState.copy$default(ChatP2PScreen$lambda$19(mutableState), null, false, null, 5, null));
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatP2PScreen$lambda$77$1$2$0(MutableState mutableState) {
        ChatP2PScreen$lambda$61(mutableState, false);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatP2PScreen$lambda$77$1$20$0(MutableState mutableState, PermissionsResult result) {
        kotlin.jvm.internal.y.i(result, "result");
        mutableState.setValue(PermissionsRequesterState.copy$default(ChatP2PScreen$lambda$19(mutableState), result, false, null, 6, null));
        Integer state = result.getState();
        if (state != null && state.intValue() == 2) {
            mutableState.setValue(PermissionsRequesterState.copy$default(ChatP2PScreen$lambda$19(mutableState), null, false, null, 5, null));
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatP2PScreen$lambda$77$1$5$0(MutableState mutableState) {
        mutableState.setValue(null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatP2PScreen$lambda$77$1$6$0(TextFieldState textFieldState, ChatViewModel chatViewModel, ChatParams chatParams, MutableState mutableState, String value, boolean z10) {
        kotlin.jvm.internal.y.i(value, "value");
        TextFieldStateKt.setTextAndPlaceCursorAtEnd(textFieldState, value);
        mutableState.setValue(null);
        if (z10) {
            ChatViewModel.sendMessage$default(chatViewModel, textFieldState.getText().toString(), chatParams.getUid(), false, null, null, null, null, 124, null);
            TextFieldStateKt.setTextAndPlaceCursorAtEnd(textFieldState, "");
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatP2PScreen$lambda$77$1$7$0(ChatParams chatParams, MutableState mutableState, ChatViewModel chatViewModel, MutableState mutableState2, List files, String content) {
        Message message;
        kotlin.jvm.internal.y.i(files, "files");
        kotlin.jvm.internal.y.i(content, "content");
        String uid = chatParams.getUid();
        MessageWithPartnerWithReactions messageWithPartnerWithReactions = (MessageWithPartnerWithReactions) mutableState.getValue();
        chatViewModel.sendVideos(uid, files, content, (messageWithPartnerWithReactions == null || (message = messageWithPartnerWithReactions.getMessage()) == null) ? null : message.getId());
        mutableState.setValue(null);
        ChatP2PScreen$lambda$64(mutableState2, false);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatP2PScreen$lambda$77$1$8$0(ChatParams chatParams, MutableState mutableState, ChatViewModel chatViewModel, MutableState mutableState2, List files, String content) {
        Message message;
        kotlin.jvm.internal.y.i(files, "files");
        kotlin.jvm.internal.y.i(content, "content");
        String uid = chatParams.getUid();
        MessageWithPartnerWithReactions messageWithPartnerWithReactions = (MessageWithPartnerWithReactions) mutableState.getValue();
        chatViewModel.sendImages(uid, files, content, (messageWithPartnerWithReactions == null || (message = messageWithPartnerWithReactions.getMessage()) == null) ? null : message.getId());
        mutableState.setValue(null);
        ChatP2PScreen$lambda$64(mutableState2, false);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatP2PScreen$lambda$77$1$9$0(MutableState mutableState) {
        ChatP2PScreen$lambda$64(mutableState, false);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatP2PScreen$lambda$77$2$0(SnapshotStateList snapshotStateList) {
        ChatP2PScreen$clearSelection(snapshotStateList);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult ChatP2PScreen$lambda$77$5$0(final ChatViewModel chatViewModel, final TextFieldState textFieldState, final ChatParams chatParams, final ChatP2PScreenKt$ChatP2PScreen$notificationFilter$1$1 chatP2PScreenKt$ChatP2PScreen$notificationFilter$1$1, DisposableEffectScope DisposableEffect) {
        kotlin.jvm.internal.y.i(DisposableEffect, "$this$DisposableEffect");
        return new DisposableEffectResult() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.ChatP2PScreenKt$ChatP2PScreen$lambda$77$5$0$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                chatViewModel.setRoomDraft(textFieldState.getText().toString(), chatParams.getUid());
                chatViewModel.stopRecorder();
                chatViewModel.getNotificationManager().unRegister(chatP2PScreenKt$ChatP2PScreen$notificationFilter$1$1);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatP2PScreen$lambda$78(NavHostController navHostController, String str, ChatViewModel chatViewModel, int i10, int i11, Composer composer, int i12) {
        ChatP2PScreen(navHostController, str, chatViewModel, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function1 ChatP2PScreen$lambda$9(MutableState<Function1> mutableState) {
        return mutableState.getValue();
    }

    private static final boolean ChatP2PScreen$listIsForwardable(SnapshotStateList<MessageWithPartnerWithReactions> snapshotStateList) {
        boolean z10;
        boolean z11;
        if (defpackage.r.a(snapshotStateList) && snapshotStateList.isEmpty()) {
            z10 = false;
            break;
        }
        Iterator<MessageWithPartnerWithReactions> it = snapshotStateList.iterator();
        loop2: while (true) {
            if (!it.hasNext()) {
                z10 = false;
                break;
            }
            List<Attachment> attachments = it.next().getAttachments();
            if (!defpackage.r.a(attachments) || !attachments.isEmpty()) {
                Iterator<T> it2 = attachments.iterator();
                while (it2.hasNext()) {
                    if (((Attachment) it2.next()).getType() == 16) {
                        z10 = true;
                        break loop2;
                    }
                }
            }
        }
        if (defpackage.r.a(snapshotStateList) && snapshotStateList.isEmpty()) {
            z11 = false;
            break;
        }
        Iterator<MessageWithPartnerWithReactions> it3 = snapshotStateList.iterator();
        loop0: while (true) {
            if (!it3.hasNext()) {
                z11 = false;
                break;
            }
            List<Attachment> attachments2 = it3.next().getAttachments();
            if (!defpackage.r.a(attachments2) || !attachments2.isEmpty()) {
                for (Attachment attachment : attachments2) {
                    if (attachment.getState() != 2 && attachment.getState() != 6) {
                        z11 = true;
                        break loop0;
                    }
                }
            }
        }
        return (z10 || z11) ? false : true;
    }

    private static final void ChatP2PScreen$onClickInShortcut(Context context, final ChatViewModel chatViewModel, final ChatParams chatParams, final NavHostController navHostController, final TextFieldState textFieldState, MutableState<PagerDialogData> mutableState, ButtonContent buttonContent) {
        ChatButtonsFunctionality.INSTANCE.handleClick(buttonContent, context, new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.f3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ChatP2PScreenKt.ChatP2PScreen$onClickInShortcut$lambda$28(chatViewModel, chatParams, (String) obj);
            }
        }, new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.b4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ChatP2PScreenKt.ChatP2PScreen$onClickInShortcut$lambda$29(navHostController, (String) obj);
            }
        }, new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.m4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ChatP2PScreenKt.ChatP2PScreen$onClickInShortcut$lambda$30(textFieldState, (String) obj);
            }
        }, new ChatP2PScreenKt$ChatP2PScreen$onClickInShortcut$4(mutableState), (64 & 64) != 0 ? new Function1() { // from class: q7.a
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ChatButtonsFunctionality.handleClick$lambda$0((BotShortcut) obj);
            }
        } : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatP2PScreen$onClickInShortcut$lambda$28(ChatViewModel chatViewModel, ChatParams chatParams, String it) {
        kotlin.jvm.internal.y.i(it, "it");
        ChatViewModel.sendMessage$default(chatViewModel, it, chatParams.getUid(), false, null, null, null, null, 124, null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatP2PScreen$onClickInShortcut$lambda$29(NavHostController navHostController, String it) {
        kotlin.jvm.internal.y.i(it, "it");
        NavController.navigate$default((NavController) navHostController, it, (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatP2PScreen$onClickInShortcut$lambda$30(TextFieldState textFieldState, String text) {
        kotlin.jvm.internal.y.i(text, "text");
        TextFieldStateKt.setTextAndPlaceCursorAtEnd(textFieldState, text);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ChatP2PScreen$onDelete(ChatViewModel chatViewModel, SnapshotStateList<MessageWithPartnerWithReactions> snapshotStateList) {
        chatViewModel.deleteMessages(ChatP2PScreen$clearSelection(snapshotStateList));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ChatP2PScreen$onDeleteToAll(ChatViewModel chatViewModel, ChatParams chatParams, SnapshotStateList<MessageWithPartnerWithReactions> snapshotStateList) {
        chatViewModel.deleteForAll(chatParams.getUid(), ChatP2PScreen$clearSelection(snapshotStateList));
    }

    private static final void ChatP2PScreen$removeAttachedFilesToSend(SnapshotStateList<Uri> snapshotStateList, MutableState<Boolean> mutableState, MutableState<Boolean> mutableState2, Uri uri) {
        if (snapshotStateList.size() == 1) {
            ChatP2PScreen$clearAttachedFilesToSend(snapshotStateList, mutableState, mutableState2);
        } else {
            snapshotStateList.remove(uri);
        }
    }

    private static final void ChatP2PScreen$removeItemFromSelected(SnapshotStateList<MessageWithPartnerWithReactions> snapshotStateList, ChatViewModel chatViewModel, final String str) {
        final Function1 function1 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.s3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(ChatP2PScreenKt.ChatP2PScreen$removeItemFromSelected$lambda$53(str, (MessageWithPartnerWithReactions) obj));
            }
        };
        Collection.EL.removeIf(snapshotStateList, new Predicate() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.t3
            public /* synthetic */ Predicate and(Predicate predicate) {
                return Predicate$CC.$default$and(this, predicate);
            }

            public /* synthetic */ Predicate negate() {
                return Predicate$CC.$default$negate(this);
            }

            @Override // java.util.function.Predicate
            public /* synthetic */ Predicate or(Predicate predicate) {
                return Predicate$CC.$default$or(this, predicate);
            }

            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return ChatP2PScreenKt.ChatP2PScreen$removeItemFromSelected$lambda$54(function1, obj);
            }
        });
        ArrayList arrayList = new ArrayList(va.x.y(snapshotStateList, 10));
        Iterator<MessageWithPartnerWithReactions> it = snapshotStateList.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getMessage().getId());
        }
        chatViewModel.allMsgsAreMine(va.g0.o1(arrayList));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean ChatP2PScreen$removeItemFromSelected$lambda$53(String str, MessageWithPartnerWithReactions it) {
        kotlin.jvm.internal.y.i(it, "it");
        return kotlin.jvm.internal.y.d(it.getMessage().getId(), str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean ChatP2PScreen$removeItemFromSelected$lambda$54(Function1 function1, Object obj) {
        return ((Boolean) function1.invoke(obj)).booleanValue();
    }

    private static final void ChatP2PScreen$selectMapLocation(NavHostController navHostController, ChatViewModel chatViewModel, ChatParams chatParams, MutableState<MessageWithPartnerWithReactions> mutableState) {
        Message message;
        NavLinks navLinks = NavLinks.INSTANCE;
        v5.f gson = chatViewModel.getGson();
        MapMotive mapMotive = MapMotive.SELECT;
        String uid = chatParams.getUid();
        MessageWithPartnerWithReactions value = mutableState.getValue();
        String strT = gson.t(new MapParams(mapMotive, uid, (value == null || (message = value.getMessage()) == null) ? null : message.getId(), null, 8, null));
        kotlin.jvm.internal.y.h(strT, "toJson(...)");
        NavController.navigate$default((NavController) navHostController, navLinks.goMap(strT), (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
    }

    private static final void ChatP2PScreen$selectMethodAndSend(ChatParams chatParams, MutableState<MessageWithPartnerWithReactions> mutableState, ChatViewModel chatViewModel, Context context, final SnapshotStateList<Uri> snapshotStateList, final MutableState<Boolean> mutableState2, final MutableState<Boolean> mutableState3, String str) {
        Message message;
        ChatComplexFunctionalities chatComplexFunctionalities = ChatComplexFunctionalities.INSTANCE;
        String uid = chatParams.getUid();
        MessageWithPartnerWithReactions value = mutableState.getValue();
        chatComplexFunctionalities.selectMethodAndSend(str, uid, (value == null || (message = value.getMessage()) == null) ? null : message.getId(), context, snapshotStateList, new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.v3
            @Override // lb.a
            public final Object invoke() {
                return ChatP2PScreenKt.ChatP2PScreen$selectMethodAndSend$lambda$42(snapshotStateList, mutableState2, mutableState3);
            }
        }, new ChatP2PScreenKt$ChatP2PScreen$selectMethodAndSend$1(chatViewModel), new ChatP2PScreenKt$ChatP2PScreen$selectMethodAndSend$2(chatViewModel), new ChatP2PScreenKt$ChatP2PScreen$selectMethodAndSend$3(chatViewModel), new ChatP2PScreenKt$ChatP2PScreen$selectMethodAndSend$4(chatViewModel));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatP2PScreen$selectMethodAndSend$lambda$42(SnapshotStateList snapshotStateList, MutableState mutableState, MutableState mutableState2) {
        ChatP2PScreen$clearAttachedFilesToSend(snapshotStateList, mutableState, mutableState2);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:11:0x0028 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:13:0x002a A[RETURN] */
    public static final boolean ChatP2PScreen$selectedContains(SnapshotStateList<MessageWithPartnerWithReactions> snapshotStateList, String str) {
        Iterator<MessageWithPartnerWithReactions> it = snapshotStateList.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            if (kotlin.jvm.internal.y.d(it.next().getMessage().getId(), str)) {
                if (i10 != -1) {
                    return true;
                }
                return false;
            }
            i10++;
        }
        i10 = -1;
        if (i10 != -1) {
            return true;
        }
        return false;
    }

    private static final boolean ChatP2PScreen$selectedListIsEmpty(SnapshotStateList<MessageWithPartnerWithReactions> snapshotStateList) {
        return snapshotStateList.toList().isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ChatP2PScreen$setPlaceholderData(MutableState<PagerDialogData> mutableState, String str, ButtonTemplate buttonTemplate, boolean z10) {
        mutableState.setValue(new PagerDialogData(str, buttonTemplate, z10, null, 8, null));
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    @Preview(device = Devices.PIXEL_5, showBackground = true, showSystemUi = true)
    public static final void ChatP2PScreenPreview(Composer composer, final int i10) {
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(825688582);
        if (composerStartRestartGroup.shouldExecute(i10 != 0, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(825688582, i10, -1, "cu.todus.android.uiCompose.main.screen.chat.component.p2p.ChatP2PScreenPreview (ChatP2PScreen.kt:1389)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            Modifier modifierM1205backgroundbw27NRU$default = BackgroundKt.m1205backgroundbw27NRU$default(SizeKt.fillMaxSize$default(companion, 0.0f, 1, null), Color.INSTANCE.m5903getWhite0d7_KjU(), null, 2, null);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getCenter(), false);
            int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1205backgroundbw27NRU$default);
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
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion2.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl, companion2.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion2.getSetModifier());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            composer2 = composerStartRestartGroup;
            TextKt.m3850TextNvy7gAk("ChatP2PScreen Preview\n\nEsta pantalla requiere:\n- NavHostController\n- Parámetros de chat\n- ViewModel con datos\n\nUsa Compose Preview para ver cambios en tiempo real", SizeKt.fillMaxWidth(companion, 0.8f), 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer2, 54, 0, 262140);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.u3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ChatP2PScreenKt.ChatP2PScreenPreview$lambda$1(i10, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatP2PScreenPreview$lambda$1(int i10, Composer composer, int i11) {
        ChatP2PScreenPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1));
        return ua.k0.f43947a;
    }
}
