package cu.todus.android.uiCompose.main.screen.rooms.roomItem;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.AspectRatioKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.e3;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.InlineTextContentKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.outlined.AddCircleOutlineKt;
import androidx.compose.material.icons.outlined.PushPinKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.AlphaKt;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.common.C;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.profileinstaller.ProfileVerifier;
import cu.todus.android.R;
import cu.todus.android.data.db.entity.toDus.Reaction;
import cu.todus.android.repositories.ReactionsRepository;
import cu.todus.android.uiCompose.main.screen.chat.details.MsgDetailsDialogKt;
import cu.todus.android.uiCompose.main.screen.chat.item.MsgStatusKt;
import cu.todus.android.uiCompose.main.screen.rooms.roomItem.RoomItemKt;
import cu.todus.android.uiCompose.navigation.NavLinks;
import cu.todus.android.uiCompose.theme.Other;
import cu.todus.android.utils.ColorGenerator;
import cu.z17.views.label.Z17LabelKt;
import cu.z17.views.loader.Z17ShimmerLoaderKt;
import cu.z17.views.picture.Z17PictureAvatarKt;
import cu.z17.views.picture.Z17PictureKt;
import defpackage.l;
import defpackage.r;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.y;
import lb.a;
import le.z;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;
import ua.k0;
import va.g0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u001aÇ\u0001\u0010\u001c\u001a\u00020\u00182\b\b\u0002\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\u0010\u001a\u00020\b2\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\b2\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00142\u0014\b\u0002\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00180\u00172\u000e\b\u0002\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00180\u001aH\u0007¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u0017\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u0001\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\u001e\u0010\u001f\u001a1\u0010 \u001a\u00020\u00182\b\b\u0002\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b \u0010!\u001a)\u0010\"\u001a\u00020\u00182\b\b\u0002\u0010\u0001\u001a\u00020\u00002\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014H\u0007¢\u0006\u0004\b\"\u0010#¨\u0006$"}, d2 = {"Landroidx/compose/ui/Modifier;", "modifier", "", "roomName", "", "avatarImgSource", "lastMessage", "lastUpdateTime", "", "areUnread", "unreadCount", "", "roomType", "isPined", "roomId", "msgStatus", "fromOwner", "Lcu/todus/android/uiCompose/main/screen/rooms/roomItem/RoomItemState;", "state", "hasStatus", "", "Lcu/todus/android/data/db/entity/toDus/Reaction;", "reactions", "Lkotlin/Function1;", "Lua/k0;", "navigateTo", "Lkotlin/Function0;", "searchForStatus", "RoomItem", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;IZLjava/lang/String;Ljava/lang/Integer;ZLcu/todus/android/uiCompose/main/screen/rooms/roomItem/RoomItemState;ZLjava/util/List;Lkotlin/jvm/functions/Function1;Llb/a;Landroidx/compose/runtime/Composer;III)V", "RoomItemPlaceholder", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)V", "SimpleRoomItem", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;Ljava/lang/Object;ILandroidx/compose/runtime/Composer;II)V", "ReactionsInRoom", "(Landroidx/compose/ui/Modifier;Ljava/util/List;Landroidx/compose/runtime/Composer;II)V", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class RoomItemKt {

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[RoomItemState.values().length];
            try {
                iArr[RoomItemState.REGULAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[RoomItemState.TYPING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[RoomItemState.DRAFT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void ReactionsInRoom(Modifier modifier, final List<Reaction> list, Composer composer, final int i10, final int i11) {
        final Modifier modifier2;
        int i12;
        Composer composerStartRestartGroup = composer.startRestartGroup(-2036288690);
        int i13 = i11 & 1;
        if (i13 != 0) {
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
            i12 |= composerStartRestartGroup.changedInstance(list) ? 32 : 16;
        }
        if (composerStartRestartGroup.shouldExecute((i12 & 19) != 18, i12 & 1)) {
            Modifier modifier3 = i13 != 0 ? Modifier.INSTANCE : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2036288690, i12, -1, "cu.todus.android.uiCompose.main.screen.rooms.roomItem.ReactionsInRoom (RoomItem.kt:344)");
            }
            if (list == null || !(!list.isEmpty())) {
                composerStartRestartGroup.startReplaceGroup(-957301932);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-958117821);
                Modifier modifierAlpha = AlphaKt.alpha(PaddingKt.m1729paddingqDBjuR0$default(modifier3, Dp.m8823constructorimpl(5), 0.0f, Dp.m8823constructorimpl(10), 0.0f, 10, null), 0.8f);
                MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getCenterVertically(), composerStartRestartGroup, 48);
                int iA = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierAlpha);
                ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
                a constructor = companion.getConstructor();
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
                Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyRowMeasurePolicy, companion.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
                Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion.getSetCompositeKeyHash());
                Updater.m5182reconcileimpl(composerM5176constructorimpl, companion.getApplyOnDeactivatedNodeAssertion());
                Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion.getSetModifier());
                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                if (list.size() > 2) {
                    composerStartRestartGroup.startReplaceGroup(-1744577046);
                    Iterator it = g0.Y0(list).subList(0, 2).iterator();
                    while (it.hasNext()) {
                        MsgDetailsDialogKt.ReactionText(Modifier.INSTANCE, ((Reaction) it.next()).getReactionContent(), composerStartRestartGroup, 6);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(-1744352854);
                    Iterator it2 = g0.Y0(list).iterator();
                    while (it2.hasNext()) {
                        MsgDetailsDialogKt.ReactionText(Modifier.INSTANCE, ((Reaction) it2.next()).getReactionContent(), composerStartRestartGroup, 6);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                }
                if (list.size() > 2) {
                    composerStartRestartGroup.startReplaceGroup(-1744145278);
                    Z17PictureKt.m10278Z17BasePictureC8z9wKI(SizeKt.m1769size3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(20)), AddCircleOutlineKt.getAddCircleOutline(Icons.Outlined.INSTANCE), null, null, null, null, 0, null, null, composerStartRestartGroup, 6, TypedValues.PositionType.TYPE_CURVE_FIT);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(-1743973259);
                    composerStartRestartGroup.endReplaceGroup();
                }
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier3;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: c8.a
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return RoomItemKt.ReactionsInRoom$lambda$1(modifier2, list, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 ReactionsInRoom$lambda$1(Modifier modifier, List list, int i10, int i11, Composer composer, int i12) {
        ReactionsInRoom(modifier, list, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return k0.f43947a;
    }

    /* JADX WARN: Code duplicated, block: B:141:0x01d9  */
    /* JADX WARN: Code duplicated, block: B:142:0x01de  */
    /* JADX WARN: Code duplicated, block: B:144:0x01e4  */
    /* JADX WARN: Code duplicated, block: B:146:0x01ea  */
    /* JADX WARN: Code duplicated, block: B:147:0x01ed  */
    /* JADX WARN: Code duplicated, block: B:151:0x01f5  */
    /* JADX WARN: Code duplicated, block: B:153:0x01fc  */
    /* JADX WARN: Code duplicated, block: B:155:0x0202  */
    /* JADX WARN: Code duplicated, block: B:157:0x0208  */
    /* JADX WARN: Code duplicated, block: B:165:0x0225  */
    /* JADX WARN: Code duplicated, block: B:168:0x022e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:169:0x0230  */
    /* JADX WARN: Code duplicated, block: B:170:0x0233  */
    /* JADX WARN: Code duplicated, block: B:173:0x0238  */
    /* JADX WARN: Code duplicated, block: B:176:0x023c  */
    /* JADX WARN: Code duplicated, block: B:178:0x023f  */
    /* JADX WARN: Code duplicated, block: B:179:0x0242  */
    /* JADX WARN: Code duplicated, block: B:181:0x0246  */
    /* JADX WARN: Code duplicated, block: B:182:0x0249  */
    /* JADX WARN: Code duplicated, block: B:184:0x024d  */
    /* JADX WARN: Code duplicated, block: B:185:0x0252  */
    /* JADX WARN: Code duplicated, block: B:187:0x0256  */
    /* JADX WARN: Code duplicated, block: B:188:0x0258  */
    /* JADX WARN: Code duplicated, block: B:190:0x025c  */
    /* JADX WARN: Code duplicated, block: B:191:0x025e  */
    /* JADX WARN: Code duplicated, block: B:193:0x0262  */
    /* JADX WARN: Code duplicated, block: B:195:0x026e  */
    /* JADX WARN: Code duplicated, block: B:197:0x027a  */
    /* JADX WARN: Code duplicated, block: B:199:0x027e  */
    /* JADX WARN: Code duplicated, block: B:201:0x028a  */
    /* JADX WARN: Code duplicated, block: B:203:0x0296  */
    /* JADX WARN: Code duplicated, block: B:206:0x029e  */
    /* JADX WARN: Code duplicated, block: B:209:0x02dd  */
    /* JADX WARN: Code duplicated, block: B:212:0x02e9  */
    /* JADX WARN: Code duplicated, block: B:213:0x02ed  */
    /* JADX WARN: Code duplicated, block: B:216:0x0377  */
    /* JADX WARN: Code duplicated, block: B:219:0x0383  */
    /* JADX WARN: Code duplicated, block: B:220:0x0387  */
    /* JADX WARN: Code duplicated, block: B:223:0x03bc  */
    /* JADX WARN: Code duplicated, block: B:224:0x03df  */
    /* JADX WARN: Code duplicated, block: B:227:0x0402  */
    /* JADX WARN: Code duplicated, block: B:228:0x0404  */
    /* JADX WARN: Code duplicated, block: B:231:0x040c  */
    /* JADX WARN: Code duplicated, block: B:232:0x040e  */
    /* JADX WARN: Code duplicated, block: B:235:0x0417  */
    /* JADX WARN: Code duplicated, block: B:236:0x0419  */
    /* JADX WARN: Code duplicated, block: B:239:0x0425  */
    /* JADX WARN: Code duplicated, block: B:240:0x0427  */
    /* JADX WARN: Code duplicated, block: B:245:0x0437  */
    /* JADX WARN: Code duplicated, block: B:248:0x04b9  */
    /* JADX WARN: Code duplicated, block: B:250:0x04c3 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:251:0x04c5  */
    /* JADX WARN: Code duplicated, block: B:252:0x04c8  */
    /* JADX WARN: Code duplicated, block: B:253:0x04cb  */
    /* JADX WARN: Code duplicated, block: B:255:0x052c  */
    /* JADX WARN: Code duplicated, block: B:258:0x0580  */
    /* JADX WARN: Code duplicated, block: B:261:0x058c  */
    /* JADX WARN: Code duplicated, block: B:262:0x0590  */
    /* JADX WARN: Code duplicated, block: B:265:0x05ea  */
    /* JADX WARN: Code duplicated, block: B:268:0x05f6  */
    /* JADX WARN: Code duplicated, block: B:269:0x05fa  */
    /* JADX WARN: Code duplicated, block: B:272:0x064f  */
    /* JADX WARN: Code duplicated, block: B:274:0x0658  */
    /* JADX WARN: Code duplicated, block: B:277:0x06c9  */
    /* JADX WARN: Code duplicated, block: B:279:0x06d2  */
    /* JADX WARN: Code duplicated, block: B:282:0x0756  */
    /* JADX WARN: Code duplicated, block: B:285:0x0762  */
    /* JADX WARN: Code duplicated, block: B:286:0x0766  */
    /* JADX WARN: Code duplicated, block: B:289:0x07a0  */
    /* JADX WARN: Code duplicated, block: B:296:0x07c8  */
    /* JADX WARN: Code duplicated, block: B:299:0x07d7  */
    /* JADX WARN: Code duplicated, block: B:301:0x07da  */
    /* JADX WARN: Code duplicated, block: B:303:0x07dd  */
    /* JADX WARN: Code duplicated, block: B:305:0x081f  */
    /* JADX WARN: Code duplicated, block: B:307:0x0828  */
    /* JADX WARN: Code duplicated, block: B:309:0x08a3  */
    /* JADX WARN: Code duplicated, block: B:311:0x08b2  */
    /* JADX WARN: Code duplicated, block: B:313:0x08fa  */
    /* JADX WARN: Code duplicated, block: B:315:0x0903  */
    /* JADX WARN: Code duplicated, block: B:317:0x0978  */
    /* JADX WARN: Code duplicated, block: B:319:0x0993  */
    /* JADX WARN: Code duplicated, block: B:321:0x09d7  */
    /* JADX WARN: Code duplicated, block: B:323:0x09e0  */
    /* JADX WARN: Code duplicated, block: B:326:0x0a28  */
    /* JADX WARN: Code duplicated, block: B:329:0x0a3d  */
    /* JADX WARN: Code duplicated, block: B:330:0x0a40  */
    /* JADX WARN: Code duplicated, block: B:332:0x0a66  */
    /* JADX WARN: Code duplicated, block: B:336:0x0a90  */
    /* JADX WARN: Code duplicated, block: B:338:0x0a96  */
    /* JADX WARN: Code duplicated, block: B:339:0x0a9b  */
    /* JADX WARN: Code duplicated, block: B:341:0x0a9e  */
    /* JADX WARN: Code duplicated, block: B:342:0x0b66  */
    /* JADX WARN: Code duplicated, block: B:344:0x0b7c  */
    /* JADX WARN: Code duplicated, block: B:345:0x0bd5  */
    /* JADX WARN: Code duplicated, block: B:348:0x0bf0  */
    /* JADX WARN: Code duplicated, block: B:350:0x0c09  */
    /* JADX WARN: Code duplicated, block: B:353:0x0c25  */
    /* JADX WARN: Code duplicated, block: B:355:? A[RETURN, SYNTHETIC] */
    @Composable
    public static final void RoomItem(Modifier modifier, final String roomName, final Object avatarImgSource, final String lastMessage, final String lastUpdateTime, final boolean z10, String str, final int i10, final boolean z11, String str2, Integer num, boolean z12, RoomItemState roomItemState, boolean z13, List<Reaction> list, Function1 function1, a aVar, Composer composer, final int i11, final int i12, final int i13) {
        Modifier modifier2;
        int i14;
        String str3;
        final String str4;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        boolean z14;
        final Integer num2;
        final boolean z15;
        final boolean z16;
        final Function1 function2;
        final a aVar2;
        Composer composer2;
        final String str5;
        final Modifier modifier3;
        final RoomItemState roomItemState2;
        final List<Reaction> list2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier modifier4;
        final String str6;
        Integer num3;
        boolean z17;
        RoomItemState roomItemState3;
        final boolean z18;
        List<Reaction> list3;
        final Function1 function3;
        final a aVar3;
        a constructor;
        RowScopeInstance rowScopeInstance;
        Modifier.Companion companion;
        a constructor2;
        Modifier modifierM1216borderxT4_qwU;
        boolean z19;
        boolean z20;
        boolean z21;
        boolean z22;
        boolean z23;
        Object objRememberedValue;
        String str7;
        char c10;
        int i23;
        int i24;
        a constructor3;
        a constructor4;
        MaterialTheme materialTheme;
        FontWeight medium;
        int i25;
        float f10;
        FontWeight normal;
        Object obj;
        a constructor5;
        Object objRememberedValue2;
        Composer.Companion companion2;
        int i26;
        AnnotatedString annotatedString;
        int i27;
        int i28;
        int i29;
        int i30;
        MaterialTheme materialTheme2;
        int i31;
        Modifier.Companion companion3;
        FontWeight normal2;
        Object objRememberedValue3;
        int i32;
        MaterialTheme materialTheme3;
        int i33;
        Modifier.Companion companion4;
        String str8;
        int i34;
        Integer numV;
        int iIntValue;
        FontWeight normal3;
        FontWeight normal4;
        AnnotatedString.Builder builder;
        String strCreateStatus;
        int i35;
        Object objRememberedValue4;
        Object objRememberedValue5;
        y.i(roomName, "roomName");
        y.i(avatarImgSource, "avatarImgSource");
        y.i(lastMessage, "lastMessage");
        y.i(lastUpdateTime, "lastUpdateTime");
        Composer composerStartRestartGroup = composer.startRestartGroup(806965281);
        int i36 = i13 & 1;
        if (i36 != 0) {
            i14 = i11 | 6;
            modifier2 = modifier;
        } else if ((i11 & 6) == 0) {
            modifier2 = modifier;
            i14 = i11 | (composerStartRestartGroup.changed(modifier2) ? 4 : 2);
        } else {
            modifier2 = modifier;
            i14 = i11;
        }
        if ((i11 & 48) == 0) {
            i14 |= composerStartRestartGroup.changed(roomName) ? 32 : 16;
        }
        if ((i11 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i14 |= composerStartRestartGroup.changedInstance(avatarImgSource) ? 256 : 128;
        }
        if ((i11 & 3072) == 0) {
            i14 |= composerStartRestartGroup.changed(lastMessage) ? 2048 : 1024;
        }
        if ((i11 & 24576) == 0) {
            i14 |= composerStartRestartGroup.changed(lastUpdateTime) ? 16384 : 8192;
        }
        if ((i11 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            i14 |= composerStartRestartGroup.changed(z10) ? 131072 : 65536;
        }
        int i37 = i13 & 64;
        if (i37 != 0) {
            i14 |= 1572864;
            str3 = str;
        } else {
            str3 = str;
            if ((i11 & 1572864) == 0) {
                i14 |= composerStartRestartGroup.changed(str3) ? 1048576 : 524288;
            }
        }
        if ((i11 & 12582912) == 0) {
            i14 |= composerStartRestartGroup.changed(i10) ? 8388608 : 4194304;
        }
        if ((i11 & 100663296) == 0) {
            i14 |= composerStartRestartGroup.changed(z11) ? 67108864 : 33554432;
        }
        int i38 = i13 & 512;
        if (i38 != 0) {
            i14 |= 805306368;
            str4 = str2;
        } else {
            str4 = str2;
            if ((i11 & 805306368) == 0) {
                i14 |= composerStartRestartGroup.changed(str4) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
            }
        }
        int i39 = i14;
        int i40 = i13 & 1024;
        if (i40 != 0) {
            i15 = i12 | 6;
        } else if ((i12 & 6) == 0) {
            i15 = i12 | (composerStartRestartGroup.changed(num) ? 4 : 2);
        } else {
            i15 = i12;
        }
        int i41 = i13 & 2048;
        if (i41 != 0) {
            i15 |= 48;
        } else if ((i12 & 48) == 0) {
            i15 |= composerStartRestartGroup.changed(z12) ? 32 : 16;
        }
        int i42 = i15;
        int i43 = i13 & 4096;
        if (i43 != 0) {
            i16 = i42 | RendererCapabilities.DECODER_SUPPORT_MASK;
        } else if ((i12 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i16 = i42 | (composerStartRestartGroup.changed(roomItemState == null ? -1 : roomItemState.ordinal()) ? 256 : 128);
        } else {
            i16 = i42;
        }
        int i44 = i13 & 8192;
        if (i44 != 0) {
            i17 = i16 | 3072;
        } else {
            int i45 = i16;
            if ((i12 & 3072) == 0) {
                i45 |= composerStartRestartGroup.changed(z13) ? 2048 : 1024;
            }
            i17 = i45;
        }
        int i46 = i13 & 16384;
        if (i46 == 0) {
            i18 = i17;
            if ((i12 & 24576) == 0) {
                i18 |= composerStartRestartGroup.changedInstance(list) ? 16384 : 8192;
            }
            i19 = i13 & 32768;
            if (i19 != 0) {
                i18 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            } else if ((i12 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                if (composerStartRestartGroup.changedInstance(function1)) {
                    i20 = 131072;
                } else {
                    i20 = 65536;
                }
                i18 |= i20;
            }
            i21 = i13 & 65536;
            if (i21 != 0) {
                i18 |= 1572864;
            } else if ((i12 & 1572864) == 0) {
                i18 |= composerStartRestartGroup.changedInstance(aVar) ? 1048576 : 524288;
            }
            i22 = i18;
            if ((i39 & 306783379) == 306783378 || (599187 & i22) != 599186) {
                z14 = true;
            } else {
                z14 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z14, i39 & 1)) {
                if (i36 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (i37 != 0) {
                    str3 = "";
                }
                str6 = i38 == 0 ? str4 : "";
                if (i40 != 0) {
                    num3 = null;
                } else {
                    num3 = num;
                }
                if (i41 != 0) {
                    z17 = false;
                } else {
                    z17 = z12;
                }
                if (i43 != 0) {
                    roomItemState3 = RoomItemState.REGULAR;
                } else {
                    roomItemState3 = roomItemState;
                }
                if (i44 != 0) {
                    z18 = false;
                } else {
                    z18 = z13;
                }
                if (i46 != 0) {
                    list3 = null;
                } else {
                    list3 = list;
                }
                if (i19 != 0) {
                    objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue5 = new Function1() { // from class: c8.c
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return RoomItemKt.RoomItem$lambda$0$0((String) obj2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    }
                    function3 = (Function1) objRememberedValue5;
                } else {
                    function3 = function1;
                }
                if (i21 != 0) {
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue4 = new a() { // from class: c8.d
                            @Override // lb.a
                            public final Object invoke() {
                                return k0.f43947a;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    aVar3 = (a) objRememberedValue4;
                } else {
                    aVar3 = aVar;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(806965281, i39, i22, "cu.todus.android.uiCompose.main.screen.rooms.roomItem.RoomItem (RoomItem.kt:71)");
                }
                Alignment.Companion companion5 = Alignment.INSTANCE;
                Alignment.Vertical centerVertically = companion5.getCenterVertically();
                Arrangement arrangement = Arrangement.INSTANCE;
                MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getStart(), centerVertically, composerStartRestartGroup, 48);
                int iA = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier4);
                ComposeUiNode.Companion companion6 = ComposeUiNode.INSTANCE;
                Modifier modifier5 = modifier4;
                constructor = companion6.getConstructor();
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
                Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyRowMeasurePolicy, companion6.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion6.getSetResolvedCompositionLocals());
                Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion6.getSetCompositeKeyHash());
                Updater.m5182reconcileimpl(composerM5176constructorimpl, companion6.getApplyOnDeactivatedNodeAssertion());
                Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion6.getSetModifier());
                rowScopeInstance = RowScopeInstance.INSTANCE;
                companion = Modifier.INSTANCE;
                float f11 = 10;
                Modifier modifierM1729paddingqDBjuR0$default = PaddingKt.m1729paddingqDBjuR0$default(SizeKt.m1769size3ABfNKs(companion, Dp.m8823constructorimpl(80)), Dp.m8823constructorimpl(f11), 0.0f, Dp.m8823constructorimpl(f11), Dp.m8823constructorimpl(f11), 2, null);
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion5.getBottomEnd(), false);
                int iA2 = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1729paddingqDBjuR0$default);
                constructor2 = companion6.getConstructor();
                if (!r.a(composerStartRestartGroup.getApplier())) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor2);
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM5176constructorimpl2 = Updater.m5176constructorimpl(composerStartRestartGroup);
                Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy, companion6.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap2, companion6.getSetResolvedCompositionLocals());
                Updater.m5180initimpl(composerM5176constructorimpl2, Integer.valueOf(iA2), companion6.getSetCompositeKeyHash());
                Updater.m5182reconcileimpl(composerM5176constructorimpl2, companion6.getApplyOnDeactivatedNodeAssertion());
                Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier2, companion6.getSetModifier());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                if (z18) {
                    composerStartRestartGroup.startReplaceGroup(-562270891);
                    modifierM1216borderxT4_qwU = BorderKt.m1216borderxT4_qwU(companion, Dp.m8823constructorimpl(3), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimary(), RoundedCornerShapeKt.getCircleShape());
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(-562264429);
                    composerStartRestartGroup.endReplaceGroup();
                    modifierM1216borderxT4_qwU = companion;
                }
                Modifier modifierFillMaxHeight$default = SizeKt.fillMaxHeight$default(AspectRatioKt.aspectRatio$default(companion.then(modifierM1216borderxT4_qwU), 1.0f, false, 2, null), 0.0f, 1, null);
                if ((i22 & 7168) == 2048) {
                    z19 = true;
                } else {
                    z19 = false;
                }
                if ((3670016 & i22) == 1048576) {
                    z20 = true;
                } else {
                    z20 = false;
                }
                boolean z24 = z19 | z20;
                if ((458752 & i22) == 131072) {
                    z21 = true;
                } else {
                    z21 = false;
                }
                boolean z25 = z24 | z21;
                if ((i39 & C.ENCODING_PCM_DOUBLE) == 536870912) {
                    z22 = true;
                } else {
                    z22 = false;
                }
                z23 = z25 | z22;
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (z23 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new a() { // from class: c8.e
                        @Override // lb.a
                        public final Object invoke() {
                            return RoomItemKt.RoomItem$lambda$2$0$0$0(z18, aVar3, function3, str6);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                List<Reaction> list4 = list3;
                String str9 = str6;
                Function1 function4 = function3;
                str7 = str3;
                a aVar4 = aVar3;
                boolean z26 = z18;
                Z17PictureAvatarKt.m10277Z17PictureAvatarajT4Zlk(ClickableKt.m1240clickableoSLSa3U$default(modifierFillMaxHeight$default, false, null, null, null, (a) objRememberedValue, 15, null), avatarImgSource, Color.m5856boximpl(ColorKt.Color(ColorGenerator.INSTANCE.getMATERIAL().getColor(roomName))), null, null, 0, null, false, null, roomName, true, 0, composerStartRestartGroup, ((i39 >> 3) & 112) | ((i39 << 24) & C.ENCODING_PCM_DOUBLE), 6, 2552);
                if (i10 != 0) {
                    composerStartRestartGroup.startReplaceGroup(-249710934);
                    c10 = 3;
                    if (i10 != 1) {
                        i35 = R.drawable.group_image_type;
                    } else if (i10 != 3) {
                        i35 = R.drawable.channel_image_type;
                    } else {
                        i35 = R.drawable.verified;
                    }
                    MaterialTheme materialTheme4 = MaterialTheme.INSTANCE;
                    int i47 = MaterialTheme.$stable;
                    i23 = 2;
                    Z17PictureKt.m10278Z17BasePictureC8z9wKI(SizeKt.m1769size3ABfNKs(PaddingKt.m1725padding3ABfNKs(BackgroundKt.m1204backgroundbw27NRU(companion, materialTheme4.getColorScheme(composerStartRestartGroup, i47).getBackground(), RoundedCornerShapeKt.getCircleShape()), Dp.m8823constructorimpl(2)), Dp.m8823constructorimpl(15)), Integer.valueOf(i35), null, ColorFilter.Companion.m5907tintxETnrds$default(ColorFilter.INSTANCE, materialTheme4.getColorScheme(composerStartRestartGroup, i47).getOnBackground(), 0, 2, null), null, null, 0, null, null, composerStartRestartGroup, 0, XMPPTCPConnection.PacketWriter.QUEUE_SIZE);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    c10 = 3;
                    i23 = 2;
                    composerStartRestartGroup.startReplaceGroup(-249114153);
                    composerStartRestartGroup.endReplaceGroup();
                }
                composerStartRestartGroup.endNode();
                Modifier modifierA = e3.a(rowScopeInstance, companion, 1.0f, false, 2, null);
                i24 = 6;
                MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(arrangement.getCenter(), companion5.getStart(), composerStartRestartGroup, 6);
                int iA3 = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierA);
                constructor3 = companion6.getConstructor();
                if (!r.a(composerStartRestartGroup.getApplier())) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor3);
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM5176constructorimpl3 = Updater.m5176constructorimpl(composerStartRestartGroup);
                Updater.m5184setimpl(composerM5176constructorimpl3, measurePolicyColumnMeasurePolicy, companion6.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl3, currentCompositionLocalMap3, companion6.getSetResolvedCompositionLocals());
                Updater.m5180initimpl(composerM5176constructorimpl3, Integer.valueOf(iA3), companion6.getSetCompositeKeyHash());
                Updater.m5182reconcileimpl(composerM5176constructorimpl3, companion6.getApplyOnDeactivatedNodeAssertion());
                Updater.m5184setimpl(composerM5176constructorimpl3, modifierMaterializeModifier3, companion6.getSetModifier());
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(arrangement.getStart(), companion5.getTop(), composerStartRestartGroup, 0);
                int iA4 = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
                constructor4 = companion6.getConstructor();
                if (!r.a(composerStartRestartGroup.getApplier())) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor4);
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM5176constructorimpl4 = Updater.m5176constructorimpl(composerStartRestartGroup);
                Updater.m5184setimpl(composerM5176constructorimpl4, measurePolicyRowMeasurePolicy2, companion6.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl4, currentCompositionLocalMap4, companion6.getSetResolvedCompositionLocals());
                Updater.m5180initimpl(composerM5176constructorimpl4, Integer.valueOf(iA4), companion6.getSetCompositeKeyHash());
                Updater.m5182reconcileimpl(composerM5176constructorimpl4, companion6.getApplyOnDeactivatedNodeAssertion());
                Updater.m5184setimpl(composerM5176constructorimpl4, modifierMaterializeModifier4, companion6.getSetModifier());
                Modifier modifierA2 = e3.a(rowScopeInstance, companion, 1.0f, false, 2, null);
                materialTheme = MaterialTheme.INSTANCE;
                int i48 = MaterialTheme.$stable;
                TextStyle bodyLarge = materialTheme.getTypography(composerStartRestartGroup, i48).getBodyLarge();
                if (z10) {
                    medium = FontWeight.INSTANCE.getBold();
                } else {
                    medium = FontWeight.INSTANCE.getMedium();
                }
                i25 = i48;
                Z17LabelKt.m10262Z17LabelfWhpE4E(modifierA2, roomName, TextStyle.m8271copyp1EtxEg$default(bodyLarge, 0L, 0L, medium, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777211, null), 0L, 1, 0, composerStartRestartGroup, (i39 & 112) | 24576, 40);
                f10 = 15;
                Modifier modifierM1727paddingVpY3zN4$default = PaddingKt.m1727paddingVpY3zN4$default(companion, Dp.m8823constructorimpl(f10), 0.0f, i23, null);
                TextStyle bodySmall = materialTheme.getTypography(composerStartRestartGroup, i25).getBodySmall();
                if (z10) {
                    normal = FontWeight.INSTANCE.getBold();
                } else {
                    normal = FontWeight.INSTANCE.getNormal();
                }
                obj = null;
                Z17LabelKt.m10262Z17LabelfWhpE4E(modifierM1727paddingVpY3zN4$default, lastUpdateTime, TextStyle.m8271copyp1EtxEg$default(bodySmall, 0L, 0L, normal, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777211, null), 0L, 0, 0, composerStartRestartGroup, ((i39 >> 9) & 112) | 6, 56);
                composerStartRestartGroup.endNode();
                MeasurePolicy measurePolicyRowMeasurePolicy3 = RowKt.rowMeasurePolicy(arrangement.getStart(), companion5.getCenterVertically(), composerStartRestartGroup, 48);
                int iA5 = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap5 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier5 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
                constructor5 = companion6.getConstructor();
                if (!r.a(composerStartRestartGroup.getApplier())) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor5);
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM5176constructorimpl5 = Updater.m5176constructorimpl(composerStartRestartGroup);
                Updater.m5184setimpl(composerM5176constructorimpl5, measurePolicyRowMeasurePolicy3, companion6.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl5, currentCompositionLocalMap5, companion6.getSetResolvedCompositionLocals());
                Updater.m5180initimpl(composerM5176constructorimpl5, Integer.valueOf(iA5), companion6.getSetCompositeKeyHash());
                Updater.m5182reconcileimpl(composerM5176constructorimpl5, companion6.getApplyOnDeactivatedNodeAssertion());
                Updater.m5184setimpl(composerM5176constructorimpl5, modifierMaterializeModifier5, companion6.getSetModifier());
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                companion2 = Composer.INSTANCE;
                if (objRememberedValue2 == companion2.getEmpty()) {
                    i26 = 1;
                    builder = new AnnotatedString.Builder(0, 1, null);
                    if (num3 != null && z17 && (strCreateStatus = MsgStatusKt.createStatus(num3.intValue())) != null) {
                        InlineTextContentKt.appendInlineContent$default(builder, strCreateStatus, null, 2, null);
                        k0 k0Var = k0.f43947a;
                    }
                    builder.append(lastMessage);
                    objRememberedValue2 = builder.toAnnotatedString();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    i26 = 1;
                }
                annotatedString = (AnnotatedString) objRememberedValue2;
                i27 = WhenMappings.$EnumSwitchMapping$0[roomItemState3.ordinal()];
                if (i27 != i26) {
                    i28 = 2;
                    i29 = 3;
                    i30 = i26;
                    composerStartRestartGroup.startReplaceGroup(-843479984);
                    if (annotatedString.getText().length() > 0) {
                        composerStartRestartGroup.startReplaceGroup(-843399942);
                        companion3 = companion;
                        Modifier modifierM1729paddingqDBjuR0$default2 = PaddingKt.m1729paddingqDBjuR0$default(e3.a(rowScopeInstance, companion, 1.0f, false, 2, null), 0.0f, 0.0f, Dp.m8823constructorimpl(f10), 0.0f, 11, null);
                        TextStyle labelMedium = materialTheme.getTypography(composerStartRestartGroup, i25).getLabelMedium();
                        if (z10) {
                            normal2 = FontWeight.INSTANCE.getBold();
                        } else {
                            normal2 = FontWeight.INSTANCE.getNormal();
                        }
                        TextStyle textStyleM8271copyp1EtxEg$default = TextStyle.m8271copyp1EtxEg$default(labelMedium, 0L, 0L, normal2, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777211, null);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue3 == companion2.getEmpty()) {
                            objRememberedValue3 = ReactionsRepository.m9801inlineContentR2X_6o$default(ReactionsRepository.INSTANCE.getInstance(), 0L, i30, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        Map map = (Map) objRememberedValue3;
                        if (z10) {
                            i32 = 2;
                        } else {
                            i32 = i30;
                        }
                        i31 = 0;
                        materialTheme2 = materialTheme;
                        Z17LabelKt.m10261Z17Label3f6hBDE(modifierM1729paddingqDBjuR0$default2, annotatedString, map, textStyleM8271copyp1EtxEg$default, 0L, i32, 0, composerStartRestartGroup, 48, 80);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        materialTheme2 = materialTheme;
                        i31 = 0;
                        companion3 = companion;
                        composerStartRestartGroup.startReplaceGroup(-842675348);
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    k0 k0Var2 = k0.f43947a;
                } else if (i27 != 2) {
                    int i49 = i26;
                    composerStartRestartGroup.startReplaceGroup(-842562508);
                    Modifier modifierM1729paddingqDBjuR0$default3 = PaddingKt.m1729paddingqDBjuR0$default(e3.a(rowScopeInstance, companion, 1.0f, false, 2, null), 0.0f, 0.0f, Dp.m8823constructorimpl(f10), 0.0f, 11, null);
                    TextStyle labelMedium2 = materialTheme.getTypography(composerStartRestartGroup, i25).getLabelMedium();
                    if (z10) {
                        normal3 = FontWeight.INSTANCE.getBold();
                    } else {
                        normal3 = FontWeight.INSTANCE.getNormal();
                    }
                    Z17LabelKt.m10262Z17LabelfWhpE4E(modifierM1729paddingqDBjuR0$default3, StringResources_androidKt.stringResource(R.string.typing, composerStartRestartGroup, 0), TextStyle.m8271copyp1EtxEg$default(labelMedium2, 0L, 0L, normal3, FontStyle.m8368boximpl(FontStyle.INSTANCE.m8377getItalic_LCdwA()), null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777203, null), materialTheme.getColorScheme(composerStartRestartGroup, i25).getPrimary(), 0, 0, composerStartRestartGroup, 0, 48);
                    composerStartRestartGroup.endReplaceGroup();
                    k0 k0Var3 = k0.f43947a;
                    obj = null;
                    i24 = 6;
                    i25 = i25;
                    i30 = i49;
                    materialTheme2 = materialTheme;
                    i31 = 0;
                    i28 = 2;
                    companion3 = companion;
                    i29 = 3;
                } else {
                    if (i27 == 3) {
                        composerStartRestartGroup.startReplaceGroup(1912453202);
                        composerStartRestartGroup.endReplaceGroup();
                        throw new ua.r();
                    }
                    composerStartRestartGroup.startReplaceGroup(-841844083);
                    Modifier modifierM1729paddingqDBjuR0$default4 = PaddingKt.m1729paddingqDBjuR0$default(e3.a(rowScopeInstance, companion, 1.0f, false, 2, null), 0.0f, 0.0f, Dp.m8823constructorimpl(f10), 0.0f, 11, null);
                    TextStyle labelMedium3 = materialTheme.getTypography(composerStartRestartGroup, i25).getLabelMedium();
                    if (z10) {
                        normal4 = FontWeight.INSTANCE.getBold();
                    } else {
                        normal4 = FontWeight.INSTANCE.getNormal();
                    }
                    Z17LabelKt.m10262Z17LabelfWhpE4E(modifierM1729paddingqDBjuR0$default4, StringResources_androidKt.stringResource(R.string.draft, composerStartRestartGroup, 0), TextStyle.m8271copyp1EtxEg$default(labelMedium3, 0L, 0L, normal4, FontStyle.m8368boximpl(FontStyle.INSTANCE.m8377getItalic_LCdwA()), null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777203, null), Other.INSTANCE.m10118getRed0d7_KjU(), 0, 0, composerStartRestartGroup, 0, 48);
                    composerStartRestartGroup.endReplaceGroup();
                    k0 k0Var4 = k0.f43947a;
                    obj = null;
                    i24 = 6;
                    i25 = i25;
                    i30 = i26;
                    materialTheme2 = materialTheme;
                    i28 = 2;
                    companion3 = companion;
                    i29 = 3;
                    i31 = 0;
                }
                ReactionsInRoom(companion3, list4, composerStartRestartGroup, i24 | ((i22 >> 9) & 112), i31);
                if (z10) {
                    numV = z.v(str7);
                    if (numV != null) {
                        iIntValue = numV.intValue();
                    } else {
                        iIntValue = i31;
                    }
                    if (iIntValue > 0) {
                        composerStartRestartGroup.startReplaceGroup(-840973603);
                        Modifier.Companion companion7 = companion3;
                        companion4 = companion7;
                        Modifier modifierM1726paddingVpY3zN4 = PaddingKt.m1726paddingVpY3zN4(BackgroundKt.m1204backgroundbw27NRU(PaddingKt.m1729paddingqDBjuR0$default(companion7, Dp.m8823constructorimpl(i28), 0.0f, Dp.m8823constructorimpl(20), 0.0f, 10, null), materialTheme2.getColorScheme(composerStartRestartGroup, i25).getPrimary(), RoundedCornerShapeKt.getCircleShape()), Dp.m8823constructorimpl(i29), Dp.m8823constructorimpl(i30));
                        TextStyle textStyleM8271copyp1EtxEg$default2 = TextStyle.m8271copyp1EtxEg$default(materialTheme2.getTypography(composerStartRestartGroup, i25).getLabelSmall(), 0L, 0L, FontWeight.INSTANCE.getBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777211, null);
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(" ");
                        str8 = str7;
                        sb2.append(str8);
                        sb2.append(" ");
                        materialTheme3 = materialTheme2;
                        i33 = i25;
                        i34 = i28;
                        Z17LabelKt.m10262Z17LabelfWhpE4E(modifierM1726paddingVpY3zN4, sb2.toString(), textStyleM8271copyp1EtxEg$default2, materialTheme2.getColorScheme(composerStartRestartGroup, i25).getBackground(), 0, 0, composerStartRestartGroup, 0, 48);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        materialTheme3 = materialTheme2;
                        i33 = i25;
                        companion4 = companion3;
                        str8 = str7;
                        i34 = i28;
                        composerStartRestartGroup.startReplaceGroup(-840313396);
                        composerStartRestartGroup.endReplaceGroup();
                    }
                } else {
                    materialTheme3 = materialTheme2;
                    i33 = i25;
                    companion4 = companion3;
                    str8 = str7;
                    i34 = i28;
                    composerStartRestartGroup.startReplaceGroup(-840313396);
                    composerStartRestartGroup.endReplaceGroup();
                }
                if (z11) {
                    composerStartRestartGroup.startReplaceGroup(-840252264);
                    Z17PictureKt.m10278Z17BasePictureC8z9wKI(SizeKt.m1769size3ABfNKs(PaddingKt.m1727paddingVpY3zN4$default(companion4, Dp.m8823constructorimpl(f10), 0.0f, i34, obj), Dp.m8823constructorimpl(20)), PushPinKt.getPushPin(Icons.Outlined.INSTANCE), null, ColorFilter.Companion.m5907tintxETnrds$default(ColorFilter.INSTANCE, materialTheme3.getColorScheme(composerStartRestartGroup, i33).getOnBackground(), 0, 2, null), null, null, 0, null, null, composerStartRestartGroup, 6, XMPPTCPConnection.PacketWriter.QUEUE_SIZE);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(-839925524);
                    composerStartRestartGroup.endReplaceGroup();
                }
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer2 = composerStartRestartGroup;
                list2 = list4;
                num2 = num3;
                z15 = z17;
                roomItemState2 = roomItemState3;
                modifier3 = modifier5;
                str5 = str8;
                str4 = str9;
                function2 = function4;
                z16 = z26;
                aVar2 = aVar4;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                num2 = num;
                z15 = z12;
                z16 = z13;
                function2 = function1;
                aVar2 = aVar;
                composer2 = composerStartRestartGroup;
                str5 = str3;
                modifier3 = modifier2;
                roomItemState2 = roomItemState;
                list2 = list;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: c8.f
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj2, Object obj3) {
                        return RoomItemKt.RoomItem$lambda$3(modifier3, roomName, avatarImgSource, lastMessage, lastUpdateTime, z10, str5, i10, z11, str4, num2, z15, roomItemState2, z16, list2, function2, aVar2, i11, i12, i13, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                });
            }
        }
        i18 = i17 | 24576;
        i19 = i13 & 32768;
        if (i19 != 0) {
            i18 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        } else if ((i12 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            if (composerStartRestartGroup.changedInstance(function1)) {
                i20 = 131072;
            } else {
                i20 = 65536;
            }
            i18 |= i20;
        }
        i21 = i13 & 65536;
        if (i21 != 0) {
            i18 |= 1572864;
        } else if ((i12 & 1572864) == 0) {
            i18 |= composerStartRestartGroup.changedInstance(aVar) ? 1048576 : 524288;
        }
        i22 = i18;
        if ((i39 & 306783379) == 306783378) {
            z14 = true;
        } else {
            z14 = true;
        }
        if (composerStartRestartGroup.shouldExecute(z14, i39 & 1)) {
            if (i36 != 0) {
                modifier4 = Modifier.INSTANCE;
            } else {
                modifier4 = modifier2;
            }
            if (i37 != 0) {
                str3 = "";
            }
            if (i38 == 0) {
            }
            if (i40 != 0) {
                num3 = null;
            } else {
                num3 = num;
            }
            if (i41 != 0) {
                z17 = false;
            } else {
                z17 = z12;
            }
            if (i43 != 0) {
                roomItemState3 = RoomItemState.REGULAR;
            } else {
                roomItemState3 = roomItemState;
            }
            if (i44 != 0) {
                z18 = false;
            } else {
                z18 = z13;
            }
            if (i46 != 0) {
                list3 = null;
            } else {
                list3 = list;
            }
            if (i19 != 0) {
                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue5 = new Function1() { // from class: c8.c
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return RoomItemKt.RoomItem$lambda$0$0((String) obj2);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                function3 = (Function1) objRememberedValue5;
            } else {
                function3 = function1;
            }
            if (i21 != 0) {
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue4 = new a() { // from class: c8.d
                        @Override // lb.a
                        public final Object invoke() {
                            return k0.f43947a;
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                aVar3 = (a) objRememberedValue4;
            } else {
                aVar3 = aVar;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(806965281, i39, i22, "cu.todus.android.uiCompose.main.screen.rooms.roomItem.RoomItem (RoomItem.kt:71)");
            }
            Alignment.Companion companion8 = Alignment.INSTANCE;
            Alignment.Vertical centerVertically2 = companion8.getCenterVertically();
            Arrangement arrangement2 = Arrangement.INSTANCE;
            MeasurePolicy measurePolicyRowMeasurePolicy4 = RowKt.rowMeasurePolicy(arrangement2.getStart(), centerVertically2, composerStartRestartGroup, 48);
            int iA6 = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap6 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier6 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier4);
            ComposeUiNode.Companion companion9 = ComposeUiNode.INSTANCE;
            Modifier modifier6 = modifier4;
            constructor = companion9.getConstructor();
            if (!r.a(composerStartRestartGroup.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM5176constructorimpl6 = Updater.m5176constructorimpl(composerStartRestartGroup);
            Updater.m5184setimpl(composerM5176constructorimpl6, measurePolicyRowMeasurePolicy4, companion9.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl6, currentCompositionLocalMap6, companion9.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl6, Integer.valueOf(iA6), companion9.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl6, companion9.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl6, modifierMaterializeModifier6, companion9.getSetModifier());
            rowScopeInstance = RowScopeInstance.INSTANCE;
            companion = Modifier.INSTANCE;
            float f12 = 10;
            Modifier modifierM1729paddingqDBjuR0$default5 = PaddingKt.m1729paddingqDBjuR0$default(SizeKt.m1769size3ABfNKs(companion, Dp.m8823constructorimpl(80)), Dp.m8823constructorimpl(f12), 0.0f, Dp.m8823constructorimpl(f12), Dp.m8823constructorimpl(f12), 2, null);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(companion8.getBottomEnd(), false);
            int iA7 = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap7 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier7 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1729paddingqDBjuR0$default5);
            constructor2 = companion9.getConstructor();
            if (!r.a(composerStartRestartGroup.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor2);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM5176constructorimpl7 = Updater.m5176constructorimpl(composerStartRestartGroup);
            Updater.m5184setimpl(composerM5176constructorimpl7, measurePolicyMaybeCachedBoxMeasurePolicy2, companion9.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl7, currentCompositionLocalMap7, companion9.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl7, Integer.valueOf(iA7), companion9.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl7, companion9.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl7, modifierMaterializeModifier7, companion9.getSetModifier());
            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
            if (z18) {
                composerStartRestartGroup.startReplaceGroup(-562270891);
                modifierM1216borderxT4_qwU = BorderKt.m1216borderxT4_qwU(companion, Dp.m8823constructorimpl(3), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimary(), RoundedCornerShapeKt.getCircleShape());
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-562264429);
                composerStartRestartGroup.endReplaceGroup();
                modifierM1216borderxT4_qwU = companion;
            }
            Modifier modifierFillMaxHeight$default2 = SizeKt.fillMaxHeight$default(AspectRatioKt.aspectRatio$default(companion.then(modifierM1216borderxT4_qwU), 1.0f, false, 2, null), 0.0f, 1, null);
            if ((i22 & 7168) == 2048) {
                z19 = true;
            } else {
                z19 = false;
            }
            if ((3670016 & i22) == 1048576) {
                z20 = true;
            } else {
                z20 = false;
            }
            boolean z27 = z19 | z20;
            if ((458752 & i22) == 131072) {
                z21 = true;
            } else {
                z21 = false;
            }
            boolean z28 = z27 | z21;
            if ((i39 & C.ENCODING_PCM_DOUBLE) == 536870912) {
                z22 = true;
            } else {
                z22 = false;
            }
            z23 = z28 | z22;
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z23) {
                objRememberedValue = new a() { // from class: c8.e
                    @Override // lb.a
                    public final Object invoke() {
                        return RoomItemKt.RoomItem$lambda$2$0$0$0(z18, aVar3, function3, str6);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = new a() { // from class: c8.e
                    @Override // lb.a
                    public final Object invoke() {
                        return RoomItemKt.RoomItem$lambda$2$0$0$0(z18, aVar3, function3, str6);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            List<Reaction> list5 = list3;
            String str10 = str6;
            Function1 function5 = function3;
            str7 = str3;
            a aVar5 = aVar3;
            boolean z29 = z18;
            Z17PictureAvatarKt.m10277Z17PictureAvatarajT4Zlk(ClickableKt.m1240clickableoSLSa3U$default(modifierFillMaxHeight$default2, false, null, null, null, (a) objRememberedValue, 15, null), avatarImgSource, Color.m5856boximpl(ColorKt.Color(ColorGenerator.INSTANCE.getMATERIAL().getColor(roomName))), null, null, 0, null, false, null, roomName, true, 0, composerStartRestartGroup, ((i39 >> 3) & 112) | ((i39 << 24) & C.ENCODING_PCM_DOUBLE), 6, 2552);
            if (i10 != 0) {
                composerStartRestartGroup.startReplaceGroup(-249710934);
                c10 = 3;
                if (i10 != 1) {
                    i35 = R.drawable.group_image_type;
                } else if (i10 != 3) {
                    i35 = R.drawable.channel_image_type;
                } else {
                    i35 = R.drawable.verified;
                }
                MaterialTheme materialTheme5 = MaterialTheme.INSTANCE;
                int i410 = MaterialTheme.$stable;
                i23 = 2;
                Z17PictureKt.m10278Z17BasePictureC8z9wKI(SizeKt.m1769size3ABfNKs(PaddingKt.m1725padding3ABfNKs(BackgroundKt.m1204backgroundbw27NRU(companion, materialTheme5.getColorScheme(composerStartRestartGroup, i410).getBackground(), RoundedCornerShapeKt.getCircleShape()), Dp.m8823constructorimpl(2)), Dp.m8823constructorimpl(15)), Integer.valueOf(i35), null, ColorFilter.Companion.m5907tintxETnrds$default(ColorFilter.INSTANCE, materialTheme5.getColorScheme(composerStartRestartGroup, i410).getOnBackground(), 0, 2, null), null, null, 0, null, null, composerStartRestartGroup, 0, XMPPTCPConnection.PacketWriter.QUEUE_SIZE);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                c10 = 3;
                i23 = 2;
                composerStartRestartGroup.startReplaceGroup(-249114153);
                composerStartRestartGroup.endReplaceGroup();
            }
            composerStartRestartGroup.endNode();
            Modifier modifierA3 = e3.a(rowScopeInstance, companion, 1.0f, false, 2, null);
            i24 = 6;
            MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(arrangement2.getCenter(), companion8.getStart(), composerStartRestartGroup, 6);
            int iA8 = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap8 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier8 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierA3);
            constructor3 = companion9.getConstructor();
            if (!r.a(composerStartRestartGroup.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor3);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM5176constructorimpl8 = Updater.m5176constructorimpl(composerStartRestartGroup);
            Updater.m5184setimpl(composerM5176constructorimpl8, measurePolicyColumnMeasurePolicy2, companion9.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl8, currentCompositionLocalMap8, companion9.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl8, Integer.valueOf(iA8), companion9.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl8, companion9.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl8, modifierMaterializeModifier8, companion9.getSetModifier());
            ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
            MeasurePolicy measurePolicyRowMeasurePolicy5 = RowKt.rowMeasurePolicy(arrangement2.getStart(), companion8.getTop(), composerStartRestartGroup, 0);
            int iA9 = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap9 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier9 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
            constructor4 = companion9.getConstructor();
            if (!r.a(composerStartRestartGroup.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor4);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM5176constructorimpl9 = Updater.m5176constructorimpl(composerStartRestartGroup);
            Updater.m5184setimpl(composerM5176constructorimpl9, measurePolicyRowMeasurePolicy5, companion9.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl9, currentCompositionLocalMap9, companion9.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl9, Integer.valueOf(iA9), companion9.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl9, companion9.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl9, modifierMaterializeModifier9, companion9.getSetModifier());
            Modifier modifierA4 = e3.a(rowScopeInstance, companion, 1.0f, false, 2, null);
            materialTheme = MaterialTheme.INSTANCE;
            int i411 = MaterialTheme.$stable;
            TextStyle bodyLarge2 = materialTheme.getTypography(composerStartRestartGroup, i411).getBodyLarge();
            if (z10) {
                medium = FontWeight.INSTANCE.getBold();
            } else {
                medium = FontWeight.INSTANCE.getMedium();
            }
            i25 = i411;
            Z17LabelKt.m10262Z17LabelfWhpE4E(modifierA4, roomName, TextStyle.m8271copyp1EtxEg$default(bodyLarge2, 0L, 0L, medium, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777211, null), 0L, 1, 0, composerStartRestartGroup, (i39 & 112) | 24576, 40);
            f10 = 15;
            Modifier modifierM1727paddingVpY3zN4$default2 = PaddingKt.m1727paddingVpY3zN4$default(companion, Dp.m8823constructorimpl(f10), 0.0f, i23, null);
            TextStyle bodySmall2 = materialTheme.getTypography(composerStartRestartGroup, i25).getBodySmall();
            if (z10) {
                normal = FontWeight.INSTANCE.getBold();
            } else {
                normal = FontWeight.INSTANCE.getNormal();
            }
            obj = null;
            Z17LabelKt.m10262Z17LabelfWhpE4E(modifierM1727paddingVpY3zN4$default2, lastUpdateTime, TextStyle.m8271copyp1EtxEg$default(bodySmall2, 0L, 0L, normal, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777211, null), 0L, 0, 0, composerStartRestartGroup, ((i39 >> 9) & 112) | 6, 56);
            composerStartRestartGroup.endNode();
            MeasurePolicy measurePolicyRowMeasurePolicy6 = RowKt.rowMeasurePolicy(arrangement2.getStart(), companion8.getCenterVertically(), composerStartRestartGroup, 48);
            int iA10 = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap10 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier10 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
            constructor5 = companion9.getConstructor();
            if (!r.a(composerStartRestartGroup.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor5);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM5176constructorimpl10 = Updater.m5176constructorimpl(composerStartRestartGroup);
            Updater.m5184setimpl(composerM5176constructorimpl10, measurePolicyRowMeasurePolicy6, companion9.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl10, currentCompositionLocalMap10, companion9.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl10, Integer.valueOf(iA10), companion9.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl10, companion9.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl10, modifierMaterializeModifier10, companion9.getSetModifier());
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            companion2 = Composer.INSTANCE;
            if (objRememberedValue2 == companion2.getEmpty()) {
                i26 = 1;
                builder = new AnnotatedString.Builder(0, 1, null);
                if (num3 != null) {
                    InlineTextContentKt.appendInlineContent$default(builder, strCreateStatus, null, 2, null);
                    k0 k0Var5 = k0.f43947a;
                }
                builder.append(lastMessage);
                objRememberedValue2 = builder.toAnnotatedString();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            } else {
                i26 = 1;
            }
            annotatedString = (AnnotatedString) objRememberedValue2;
            i27 = WhenMappings.$EnumSwitchMapping$0[roomItemState3.ordinal()];
            if (i27 != i26) {
                i28 = 2;
                i29 = 3;
                i30 = i26;
                composerStartRestartGroup.startReplaceGroup(-843479984);
                if (annotatedString.getText().length() > 0) {
                    composerStartRestartGroup.startReplaceGroup(-843399942);
                    companion3 = companion;
                    Modifier modifierM1729paddingqDBjuR0$default6 = PaddingKt.m1729paddingqDBjuR0$default(e3.a(rowScopeInstance, companion, 1.0f, false, 2, null), 0.0f, 0.0f, Dp.m8823constructorimpl(f10), 0.0f, 11, null);
                    TextStyle labelMedium4 = materialTheme.getTypography(composerStartRestartGroup, i25).getLabelMedium();
                    if (z10) {
                        normal2 = FontWeight.INSTANCE.getBold();
                    } else {
                        normal2 = FontWeight.INSTANCE.getNormal();
                    }
                    TextStyle textStyleM8271copyp1EtxEg$default3 = TextStyle.m8271copyp1EtxEg$default(labelMedium4, 0L, 0L, normal2, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777211, null);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue3 == companion2.getEmpty()) {
                        objRememberedValue3 = ReactionsRepository.m9801inlineContentR2X_6o$default(ReactionsRepository.INSTANCE.getInstance(), 0L, i30, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    Map map2 = (Map) objRememberedValue3;
                    if (z10) {
                        i32 = 2;
                    } else {
                        i32 = i30;
                    }
                    i31 = 0;
                    materialTheme2 = materialTheme;
                    Z17LabelKt.m10261Z17Label3f6hBDE(modifierM1729paddingqDBjuR0$default6, annotatedString, map2, textStyleM8271copyp1EtxEg$default3, 0L, i32, 0, composerStartRestartGroup, 48, 80);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    materialTheme2 = materialTheme;
                    i31 = 0;
                    companion3 = companion;
                    composerStartRestartGroup.startReplaceGroup(-842675348);
                    composerStartRestartGroup.endReplaceGroup();
                }
                composerStartRestartGroup.endReplaceGroup();
                k0 k0Var6 = k0.f43947a;
            } else if (i27 != 2) {
                int i412 = i26;
                composerStartRestartGroup.startReplaceGroup(-842562508);
                Modifier modifierM1729paddingqDBjuR0$default7 = PaddingKt.m1729paddingqDBjuR0$default(e3.a(rowScopeInstance, companion, 1.0f, false, 2, null), 0.0f, 0.0f, Dp.m8823constructorimpl(f10), 0.0f, 11, null);
                TextStyle labelMedium5 = materialTheme.getTypography(composerStartRestartGroup, i25).getLabelMedium();
                if (z10) {
                    normal3 = FontWeight.INSTANCE.getBold();
                } else {
                    normal3 = FontWeight.INSTANCE.getNormal();
                }
                Z17LabelKt.m10262Z17LabelfWhpE4E(modifierM1729paddingqDBjuR0$default7, StringResources_androidKt.stringResource(R.string.typing, composerStartRestartGroup, 0), TextStyle.m8271copyp1EtxEg$default(labelMedium5, 0L, 0L, normal3, FontStyle.m8368boximpl(FontStyle.INSTANCE.m8377getItalic_LCdwA()), null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777203, null), materialTheme.getColorScheme(composerStartRestartGroup, i25).getPrimary(), 0, 0, composerStartRestartGroup, 0, 48);
                composerStartRestartGroup.endReplaceGroup();
                k0 k0Var7 = k0.f43947a;
                obj = null;
                i24 = 6;
                i25 = i25;
                i30 = i412;
                materialTheme2 = materialTheme;
                i31 = 0;
                i28 = 2;
                companion3 = companion;
                i29 = 3;
            } else {
                if (i27 == 3) {
                    composerStartRestartGroup.startReplaceGroup(1912453202);
                    composerStartRestartGroup.endReplaceGroup();
                    throw new ua.r();
                }
                composerStartRestartGroup.startReplaceGroup(-841844083);
                Modifier modifierM1729paddingqDBjuR0$default8 = PaddingKt.m1729paddingqDBjuR0$default(e3.a(rowScopeInstance, companion, 1.0f, false, 2, null), 0.0f, 0.0f, Dp.m8823constructorimpl(f10), 0.0f, 11, null);
                TextStyle labelMedium6 = materialTheme.getTypography(composerStartRestartGroup, i25).getLabelMedium();
                if (z10) {
                    normal4 = FontWeight.INSTANCE.getBold();
                } else {
                    normal4 = FontWeight.INSTANCE.getNormal();
                }
                Z17LabelKt.m10262Z17LabelfWhpE4E(modifierM1729paddingqDBjuR0$default8, StringResources_androidKt.stringResource(R.string.draft, composerStartRestartGroup, 0), TextStyle.m8271copyp1EtxEg$default(labelMedium6, 0L, 0L, normal4, FontStyle.m8368boximpl(FontStyle.INSTANCE.m8377getItalic_LCdwA()), null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777203, null), Other.INSTANCE.m10118getRed0d7_KjU(), 0, 0, composerStartRestartGroup, 0, 48);
                composerStartRestartGroup.endReplaceGroup();
                k0 k0Var8 = k0.f43947a;
                obj = null;
                i24 = 6;
                i25 = i25;
                i30 = i26;
                materialTheme2 = materialTheme;
                i28 = 2;
                companion3 = companion;
                i29 = 3;
                i31 = 0;
            }
            ReactionsInRoom(companion3, list5, composerStartRestartGroup, i24 | ((i22 >> 9) & 112), i31);
            if (z10) {
                materialTheme3 = materialTheme2;
                i33 = i25;
                companion4 = companion3;
                str8 = str7;
                i34 = i28;
                composerStartRestartGroup.startReplaceGroup(-840313396);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                numV = z.v(str7);
                if (numV != null) {
                    iIntValue = numV.intValue();
                } else {
                    iIntValue = i31;
                }
                if (iIntValue > 0) {
                    composerStartRestartGroup.startReplaceGroup(-840973603);
                    Modifier.Companion companion10 = companion3;
                    companion4 = companion10;
                    Modifier modifierM1726paddingVpY3zN5 = PaddingKt.m1726paddingVpY3zN4(BackgroundKt.m1204backgroundbw27NRU(PaddingKt.m1729paddingqDBjuR0$default(companion10, Dp.m8823constructorimpl(i28), 0.0f, Dp.m8823constructorimpl(20), 0.0f, 10, null), materialTheme2.getColorScheme(composerStartRestartGroup, i25).getPrimary(), RoundedCornerShapeKt.getCircleShape()), Dp.m8823constructorimpl(i29), Dp.m8823constructorimpl(i30));
                    TextStyle textStyleM8271copyp1EtxEg$default4 = TextStyle.m8271copyp1EtxEg$default(materialTheme2.getTypography(composerStartRestartGroup, i25).getLabelSmall(), 0L, 0L, FontWeight.INSTANCE.getBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777211, null);
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(" ");
                    str8 = str7;
                    sb3.append(str8);
                    sb3.append(" ");
                    materialTheme3 = materialTheme2;
                    i33 = i25;
                    i34 = i28;
                    Z17LabelKt.m10262Z17LabelfWhpE4E(modifierM1726paddingVpY3zN5, sb3.toString(), textStyleM8271copyp1EtxEg$default4, materialTheme2.getColorScheme(composerStartRestartGroup, i25).getBackground(), 0, 0, composerStartRestartGroup, 0, 48);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    materialTheme3 = materialTheme2;
                    i33 = i25;
                    companion4 = companion3;
                    str8 = str7;
                    i34 = i28;
                    composerStartRestartGroup.startReplaceGroup(-840313396);
                    composerStartRestartGroup.endReplaceGroup();
                }
            }
            if (z11) {
                composerStartRestartGroup.startReplaceGroup(-840252264);
                Z17PictureKt.m10278Z17BasePictureC8z9wKI(SizeKt.m1769size3ABfNKs(PaddingKt.m1727paddingVpY3zN4$default(companion4, Dp.m8823constructorimpl(f10), 0.0f, i34, obj), Dp.m8823constructorimpl(20)), PushPinKt.getPushPin(Icons.Outlined.INSTANCE), null, ColorFilter.Companion.m5907tintxETnrds$default(ColorFilter.INSTANCE, materialTheme3.getColorScheme(composerStartRestartGroup, i33).getOnBackground(), 0, 2, null), null, null, 0, null, null, composerStartRestartGroup, 6, XMPPTCPConnection.PacketWriter.QUEUE_SIZE);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-839925524);
                composerStartRestartGroup.endReplaceGroup();
            }
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer2 = composerStartRestartGroup;
            list2 = list5;
            num2 = num3;
            z15 = z17;
            roomItemState2 = roomItemState3;
            modifier3 = modifier6;
            str5 = str8;
            str4 = str10;
            function2 = function5;
            z16 = z29;
            aVar2 = aVar5;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            num2 = num;
            z15 = z12;
            z16 = z13;
            function2 = function1;
            aVar2 = aVar;
            composer2 = composerStartRestartGroup;
            str5 = str3;
            modifier3 = modifier2;
            roomItemState2 = roomItemState;
            list2 = list;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: c8.f
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return RoomItemKt.RoomItem$lambda$3(modifier3, roomName, avatarImgSource, lastMessage, lastUpdateTime, z10, str5, i10, z11, str4, num2, z15, roomItemState2, z16, list2, function2, aVar2, i11, i12, i13, (Composer) obj2, ((Integer) obj3).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 RoomItem$lambda$0$0(String it) {
        y.i(it, "it");
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 RoomItem$lambda$2$0$0$0(boolean z10, a aVar, Function1 function1, String str) {
        if (z10) {
            aVar.invoke();
        } else {
            function1.invoke(NavLinks.INSTANCE.goPreview(str));
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 RoomItem$lambda$3(Modifier modifier, String str, Object obj, String str2, String str3, boolean z10, String str4, int i10, boolean z11, String str5, Integer num, boolean z12, RoomItemState roomItemState, boolean z13, List list, Function1 function1, a aVar, int i11, int i12, int i13, Composer composer, int i14) {
        RoomItem(modifier, str, obj, str2, str3, z10, str4, i10, z11, str5, num, z12, roomItemState, z13, list, function1, aVar, composer, RecomposeScopeImplKt.updateChangedFlags(i11 | 1), RecomposeScopeImplKt.updateChangedFlags(i12), i13);
        return k0.f43947a;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void RoomItemPlaceholder(final Modifier modifier, Composer composer, final int i10) {
        int i11;
        y.i(modifier, "modifier");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1502940081);
        if ((i10 & 6) == 0) {
            i11 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i10;
        } else {
            i11 = i10;
        }
        if (composerStartRestartGroup.shouldExecute((i11 & 3) != 2, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1502940081, i11, -1, "cu.todus.android.uiCompose.main.screen.rooms.roomItem.RoomItemPlaceholder (RoomItem.kt:246)");
            }
            Modifier modifierM1755height3ABfNKs = SizeKt.m1755height3ABfNKs(modifier, Dp.m8823constructorimpl(100));
            Alignment.Companion companion = Alignment.INSTANCE;
            Alignment.Vertical centerVertically = companion.getCenterVertically();
            Arrangement arrangement = Arrangement.INSTANCE;
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getStart(), centerVertically, composerStartRestartGroup, 48);
            int iA = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1755height3ABfNKs);
            ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
            a constructor = companion2.getConstructor();
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
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyRowMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion2.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl, companion2.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion2.getSetModifier());
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            Modifier.Companion companion3 = Modifier.INSTANCE;
            Z17ShimmerLoaderKt.Z17Shimmer(ClipKt.clip(AspectRatioKt.aspectRatio$default(SizeKt.m1755height3ABfNKs(companion3, Dp.m8823constructorimpl(70)), 1.0f, false, 2, null), RoundedCornerShapeKt.getCircleShape()), composerStartRestartGroup, 0);
            float f10 = 10;
            SpacerKt.Spacer(SizeKt.m1774width3ABfNKs(companion3, Dp.m8823constructorimpl(f10)), composerStartRestartGroup, 6);
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(arrangement.getCenter(), companion.getStart(), composerStartRestartGroup, 6);
            int iA2 = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion3);
            a constructor2 = companion2.getConstructor();
            if (!r.a(composerStartRestartGroup.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor2);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM5176constructorimpl2 = Updater.m5176constructorimpl(composerStartRestartGroup);
            Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyColumnMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap2, companion2.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl2, Integer.valueOf(iA2), companion2.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl2, companion2.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier2, companion2.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            float f11 = 15;
            float f12 = 16;
            Z17ShimmerLoaderKt.Z17Shimmer(SizeKt.m1755height3ABfNKs(ClipKt.clip(SizeKt.fillMaxWidth(companion3, 0.7f), RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(f11))), Dp.m8823constructorimpl(f12)), composerStartRestartGroup, 0);
            SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion3, Dp.m8823constructorimpl(f10)), composerStartRestartGroup, 6);
            Z17ShimmerLoaderKt.Z17Shimmer(SizeKt.m1755height3ABfNKs(ClipKt.clip(SizeKt.fillMaxWidth(companion3, 1.0f), RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(f11))), Dp.m8823constructorimpl(f12)), composerStartRestartGroup, 0);
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: c8.g
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return RoomItemKt.RoomItemPlaceholder$lambda$1(modifier, i10, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 RoomItemPlaceholder$lambda$1(Modifier modifier, int i10, Composer composer, int i11) {
        RoomItemPlaceholder(modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1));
        return k0.f43947a;
    }

    @Composable
    public static final void SimpleRoomItem(Modifier modifier, final String roomName, final Object avatarImgSource, final int i10, Composer composer, final int i11, final int i12) {
        Modifier modifier2;
        int i13;
        final Modifier modifier3;
        Modifier.Companion companion;
        int i14;
        y.i(roomName, "roomName");
        y.i(avatarImgSource, "avatarImgSource");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1448164330);
        int i15 = i12 & 1;
        if (i15 != 0) {
            i13 = i11 | 6;
            modifier2 = modifier;
        } else if ((i11 & 6) == 0) {
            modifier2 = modifier;
            i13 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i11;
        } else {
            modifier2 = modifier;
            i13 = i11;
        }
        if ((i11 & 48) == 0) {
            i13 |= composerStartRestartGroup.changed(roomName) ? 32 : 16;
        }
        if ((i11 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i13 |= composerStartRestartGroup.changedInstance(avatarImgSource) ? 256 : 128;
        }
        if ((i11 & 3072) == 0) {
            i13 |= composerStartRestartGroup.changed(i10) ? 2048 : 1024;
        }
        if (composerStartRestartGroup.shouldExecute((i13 & 1171) != 1170, i13 & 1)) {
            Modifier modifier4 = i15 != 0 ? Modifier.INSTANCE : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1448164330, i13, -1, "cu.todus.android.uiCompose.main.screen.rooms.roomItem.SimpleRoomItem (RoomItem.kt:286)");
            }
            Alignment.Companion companion2 = Alignment.INSTANCE;
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), companion2.getCenterVertically(), composerStartRestartGroup, 48);
            int iA = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier4);
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
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyRowMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion3.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl, companion3.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion3.getSetModifier());
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            Modifier.Companion companion4 = Modifier.INSTANCE;
            Modifier modifierM1727paddingVpY3zN4$default = PaddingKt.m1727paddingVpY3zN4$default(SizeKt.m1769size3ABfNKs(companion4, Dp.m8823constructorimpl(80)), Dp.m8823constructorimpl(10), 0.0f, 2, null);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion2.getBottomEnd(), false);
            int iA2 = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1727paddingVpY3zN4$default);
            a constructor2 = companion3.getConstructor();
            if (!r.a(composerStartRestartGroup.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor2);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM5176constructorimpl2 = Updater.m5176constructorimpl(composerStartRestartGroup);
            Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl2, Integer.valueOf(iA2), companion3.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl2, companion3.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier2, companion3.getSetModifier());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            Modifier modifier5 = modifier4;
            int i16 = i13;
            Z17PictureAvatarKt.m10277Z17PictureAvatarajT4Zlk(SizeKt.fillMaxHeight$default(companion4, 0.0f, 1, null), avatarImgSource, Color.m5856boximpl(ColorKt.Color(ColorGenerator.INSTANCE.getMATERIAL().getColor(roomName))), null, null, 0, null, false, null, roomName, true, 0, composerStartRestartGroup, ((i13 >> 3) & 112) | 6 | ((i13 << 24) & C.ENCODING_PCM_DOUBLE), 6, 2552);
            if (i10 != 0) {
                composerStartRestartGroup.startReplaceGroup(475607561);
                if (i10 != 1) {
                    i14 = i10 != 3 ? R.drawable.channel_image_type : R.drawable.verified;
                } else {
                    i14 = R.drawable.group_image_type;
                }
                MaterialTheme materialTheme = MaterialTheme.INSTANCE;
                int i17 = MaterialTheme.$stable;
                companion = companion4;
                Z17PictureKt.m10278Z17BasePictureC8z9wKI(SizeKt.m1769size3ABfNKs(PaddingKt.m1725padding3ABfNKs(BackgroundKt.m1204backgroundbw27NRU(companion4, materialTheme.getColorScheme(composerStartRestartGroup, i17).getBackground(), RoundedCornerShapeKt.getCircleShape()), Dp.m8823constructorimpl(2)), Dp.m8823constructorimpl(15)), Integer.valueOf(i14), null, ColorFilter.Companion.m5907tintxETnrds$default(ColorFilter.INSTANCE, materialTheme.getColorScheme(composerStartRestartGroup, i17).getOnBackground(), 0, 2, null), null, null, 0, null, null, composerStartRestartGroup, 0, XMPPTCPConnection.PacketWriter.QUEUE_SIZE);
                composerStartRestartGroup = composerStartRestartGroup;
                composerStartRestartGroup.endReplaceGroup();
            } else {
                companion = companion4;
                composerStartRestartGroup.startReplaceGroup(476204342);
                composerStartRestartGroup.endReplaceGroup();
            }
            composerStartRestartGroup.endNode();
            Z17LabelKt.m10262Z17LabelfWhpE4E(e3.a(rowScopeInstance, companion, 1.0f, false, 2, null), roomName, MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyLarge(), 0L, 1, 0, composerStartRestartGroup, (i16 & 112) | 24576, 40);
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier5;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: c8.b
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return RoomItemKt.SimpleRoomItem$lambda$1(modifier3, roomName, avatarImgSource, i10, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 SimpleRoomItem$lambda$1(Modifier modifier, String str, Object obj, int i10, int i11, int i12, Composer composer, int i13) {
        SimpleRoomItem(modifier, str, obj, i10, composer, RecomposeScopeImplKt.updateChangedFlags(i11 | 1), i12);
        return k0.f43947a;
    }
}
