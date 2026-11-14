package cu.todus.android.uiCompose.main.screen.chat.attachmentPreview;

import android.content.Context;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.pager.PagerScope;
import androidx.compose.foundation.pager.PagerState;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.outlined.DownloadKt;
import androidx.compose.material.icons.outlined.ShareKt;
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
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.media3.exoplayer.analytics.AnalyticsListener;
import androidx.profileinstaller.ProfileVerifier;
import cu.todus.android.R;
import cu.todus.android.data.db.entity.toDus.Attachment;
import cu.todus.android.data.db.entity.toDus.Room;
import cu.todus.android.data.db.pojo.content.Content;
import cu.todus.android.data.db.pojo.content.FileContent;
import cu.todus.android.data.db.pojo.content.VideoContent;
import cu.todus.android.data.paths.DirectoryPaths;
import cu.todus.android.uiCompose.player.PlayerActivity;
import cu.todus.android.utils.ImageScalerKt;
import cu.todus.android.volatileState.PathsVolatileState;
import cu.z17.singledi.SinglediException;
import cu.z17.views.label.Z17LabelKt;
import cu.z17.views.picture.Z17PictureKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0003\u001aY\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00062\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\b\b\u0002\u0010\n\u001a\u00020\tH\u0007¢\u0006\u0004\b\u000b\u0010\f\u001aC\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u000f2\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0007¢\u0006\u0004\b\u0013\u0010\u0014\u001aU\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00152\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00062\u0006\u0010\u0017\u001a\u00020\u000f2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00040\u00062\b\b\u0002\u0010\u0019\u001a\u00020\u000f2\u000e\b\u0002\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006H\u0007¢\u0006\u0004\b\u001b\u0010\u001c\u001a-\u0010!\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u00032\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00040\u0006H\u0007¢\u0006\u0004\b!\u0010\"¨\u0006&²\u0006\u0012\u0010$\u001a\b\u0012\u0004\u0012\u00020\r0#8\nX\u008a\u0084\u0002²\u0006\u000e\u0010%\u001a\u00020\u000f8\n@\nX\u008a\u008e\u0002"}, d2 = {"Lcu/todus/android/uiCompose/main/screen/chat/attachmentPreview/AttachmentPreviewState;", "attachmentPreview", "Lkotlin/Function1;", "", "Lua/k0;", "onShare", "Lkotlin/Function0;", "onClose", "goStickers", "Lcu/todus/android/uiCompose/main/screen/chat/attachmentPreview/AttachmentPreviewViewModel;", "viewModel", "AttachmentPreviewWithOptions", "(Lcu/todus/android/uiCompose/main/screen/chat/attachmentPreview/AttachmentPreviewState;Lkotlin/jvm/functions/Function1;Llb/a;Lkotlin/jvm/functions/Function1;Lcu/todus/android/uiCompose/main/screen/chat/attachmentPreview/AttachmentPreviewViewModel;Landroidx/compose/runtime/Composer;II)V", "Lcu/todus/android/data/db/entity/toDus/Attachment;", "attachment", "", "fromOwner", Room.COLUMN_LAST_MSG, "isSecret", "ItemPreview", "(Lcu/todus/android/data/db/entity/toDus/Attachment;ZLjava/lang/String;ZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/ui/Modifier;", "modifier", "showOptions", "onOpenOptions", "showGoPlayer", "onGoPlayer", "AttachmentTopBar", "(Landroidx/compose/ui/Modifier;Llb/a;ZLlb/a;ZLlb/a;Landroidx/compose/runtime/Composer;II)V", "", "icon", "label", "onClick", "PopupMenuItem", "(Ljava/lang/Object;Ljava/lang/String;Llb/a;Landroidx/compose/runtime/Composer;I)V", "", Attachment.TABLE_NAME, "popupControl", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class AttachmentPreviewKt {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v44 */
    /* JADX WARN: Type inference failed for: r11v45, types: [boolean] */
    /* JADX WARN: Type inference failed for: r11v46 */
    /* JADX WARN: Type inference failed for: r13v22 */
    /* JADX WARN: Type inference failed for: r13v23 */
    /* JADX WARN: Type inference failed for: r13v24 */
    /* JADX WARN: Type inference failed for: r6v17, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r6v22 */
    /* JADX WARN: Type inference failed for: r6v24 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r40v0 java.lang.Object
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
        	at jadx.core.dex.visitors.ModVisitor.anonymousCallArgMod(ModVisitor.java:535)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
        	at jadx.core.dex.visitors.ModVisitor.processAnonymousConstructor(ModVisitor.java:528)
        	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:111)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
        */
    @androidx.compose.runtime.ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @androidx.compose.runtime.Composable
    public static final void AttachmentPreviewWithOptions(final cu.todus.android.uiCompose.main.screen.chat.attachmentPreview.AttachmentPreviewState r50, final kotlin.jvm.functions.Function1 r51, lb.a r52, final kotlin.jvm.functions.Function1 r53, cu.todus.android.uiCompose.main.screen.chat.attachmentPreview.AttachmentPreviewViewModel r54, androidx.compose.runtime.Composer r55, final int r56, final int r57) {
        /*
            Method dump skipped, instruction units count: 2061
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.uiCompose.main.screen.chat.attachmentPreview.AttachmentPreviewKt.AttachmentPreviewWithOptions(cu.todus.android.uiCompose.main.screen.chat.attachmentPreview.AttachmentPreviewState, kotlin.jvm.functions.Function1, lb.a, kotlin.jvm.functions.Function1, cu.todus.android.uiCompose.main.screen.chat.attachmentPreview.AttachmentPreviewViewModel, androidx.compose.runtime.Composer, int, int):void");
    }

    private static final List<Attachment> AttachmentPreviewWithOptions$lambda$1$0(State<? extends List<Attachment>> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int AttachmentPreviewWithOptions$lambda$1$2$0(State state) {
        return AttachmentPreviewWithOptions$lambda$1$0(state).size();
    }

    private static final boolean AttachmentPreviewWithOptions$lambda$1$4(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void AttachmentPreviewWithOptions$lambda$1$5(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 AttachmentPreviewWithOptions$lambda$1$6$0(AttachmentPreviewState attachmentPreviewState, Function1 function1, State state, PagerScope HorizontalPager, int i10, Composer composer, int i11) {
        kotlin.jvm.internal.y.i(HorizontalPager, "$this$HorizontalPager");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1055233614, i11, -1, "cu.todus.android.uiCompose.main.screen.chat.attachmentPreview.AttachmentPreviewWithOptions.<anonymous>.<anonymous>.<anonymous> (AttachmentPreview.kt:121)");
        }
        ItemPreview(AttachmentPreviewWithOptions$lambda$1$0(state).get(i10), attachmentPreviewState.getFromOwner(), attachmentPreviewState.getMsgId(), attachmentPreviewState.isSecret(), function1, composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 AttachmentPreviewWithOptions$lambda$1$6$1$0(MutableState mutableState) {
        AttachmentPreviewWithOptions$lambda$1$5(mutableState, true);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 AttachmentPreviewWithOptions$lambda$1$6$2$0(lb.a aVar, Context context, PagerState pagerState, State state) {
        aVar.invoke();
        PlayerActivity.Companion companion = PlayerActivity.INSTANCE;
        Content content = AttachmentPreviewWithOptions$lambda$1$0(state).get(pagerState.getCurrentPage()).getContent();
        kotlin.jvm.internal.y.g(content, "null cannot be cast to non-null type cu.todus.android.data.db.pojo.content.VideoContent");
        String path = ((VideoContent) content).getPath();
        Content content2 = AttachmentPreviewWithOptions$lambda$1$0(state).get(pagerState.getCurrentPage()).getContent();
        kotlin.jvm.internal.y.g(content2, "null cannot be cast to non-null type cu.todus.android.data.db.pojo.content.VideoContent");
        long width = ((VideoContent) content2).getWidth();
        Content content3 = AttachmentPreviewWithOptions$lambda$1$0(state).get(pagerState.getCurrentPage()).getContent();
        kotlin.jvm.internal.y.g(content3, "null cannot be cast to non-null type cu.todus.android.data.db.pojo.content.VideoContent");
        companion.openPlayerActivity(context, false, "", path, ImageScalerKt.getScaleFromSize(width, ((VideoContent) content3).getHeight()).scale());
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 AttachmentPreviewWithOptions$lambda$1$6$3$0(MutableState mutableState) {
        AttachmentPreviewWithOptions$lambda$1$5(mutableState, false);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 AttachmentPreviewWithOptions$lambda$1$6$4(final Function1 function1, final State state, final PagerState pagerState, final Context context, final MutableState mutableState, Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(987262565, i10, -1, "cu.todus.android.uiCompose.main.screen.chat.attachmentPreview.AttachmentPreviewWithOptions.<anonymous>.<anonymous>.<anonymous> (AttachmentPreview.kt:163)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            MaterialTheme materialTheme = MaterialTheme.INSTANCE;
            int i11 = MaterialTheme.$stable;
            float f10 = 15;
            Modifier modifierM1216borderxT4_qwU = BorderKt.m1216borderxT4_qwU(BackgroundKt.m1204backgroundbw27NRU(companion, materialTheme.getColorScheme(composer, i11).getBackground(), RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(f10))), Dp.m8823constructorimpl(1), materialTheme.getColorScheme(composer, i11).getOnBackground(), RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(f10)));
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer, 0);
            int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierM1216borderxT4_qwU);
            ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
            lb.a constructor = companion2.getConstructor();
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
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyColumnMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion2.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl, companion2.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion2.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            Icons.Outlined outlined = Icons.Outlined.INSTANCE;
            ImageVector share = ShareKt.getShare(outlined);
            String strStringResource = StringResources_androidKt.stringResource(R.string.share, composer, 0);
            boolean zChanged = composer.changed(function1) | composer.changed(state) | composer.changed(pagerState);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.attachmentPreview.k
                    @Override // lb.a
                    public final Object invoke() {
                        return AttachmentPreviewKt.AttachmentPreviewWithOptions$lambda$1$6$4$0$0$0(function1, pagerState, mutableState, state);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            PopupMenuItem(share, strStringResource, (lb.a) objRememberedValue, composer, 0);
            ImageVector download = DownloadKt.getDownload(outlined);
            String strStringResource2 = StringResources_androidKt.stringResource(R.string.save_in_downloads, composer, 0);
            boolean zChanged2 = composer.changed(state) | composer.changed(pagerState) | composer.changedInstance(context);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.attachmentPreview.m
                    @Override // lb.a
                    public final Object invoke() {
                        return AttachmentPreviewKt.AttachmentPreviewWithOptions$lambda$1$6$4$0$1$0(mutableState, pagerState, context, state);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            PopupMenuItem(download, strStringResource2, (lb.a) objRememberedValue2, composer, 0);
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
    public static final ua.k0 AttachmentPreviewWithOptions$lambda$1$6$4$0$0$0(Function1 function1, PagerState pagerState, MutableState mutableState, State state) {
        AttachmentPreviewWithOptions$lambda$1$5(mutableState, false);
        function1.invoke(AttachmentPreviewWithOptions$lambda$1$0(state).get(pagerState.getCurrentPage()).getMsg());
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 AttachmentPreviewWithOptions$lambda$1$6$4$0$1$0(MutableState mutableState, PagerState pagerState, Context context, State state) throws SinglediException {
        AttachmentPreviewWithOptions$lambda$1$5(mutableState, false);
        AttachmentPreviewWithOptions$lambda$1$saveInDownloads(pagerState, context, state);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 AttachmentPreviewWithOptions$lambda$1$7$0$0(pe.m0 m0Var, PagerState pagerState) {
        pe.k.d(m0Var, null, null, new AttachmentPreviewKt$AttachmentPreviewWithOptions$2$3$1$1$1(pagerState, null), 3, null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 AttachmentPreviewWithOptions$lambda$1$7$1$0(pe.m0 m0Var, PagerState pagerState) {
        pe.k.d(m0Var, null, null, new AttachmentPreviewKt$AttachmentPreviewWithOptions$2$3$2$1$1(pagerState, null), 3, null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 AttachmentPreviewWithOptions$lambda$1$8$0(lb.a aVar) {
        aVar.invoke();
        return ua.k0.f43947a;
    }

    private static final void AttachmentPreviewWithOptions$lambda$1$saveInDownloads(PagerState pagerState, Context context, State<? extends List<Attachment>> state) throws SinglediException {
        Attachment attachment = AttachmentPreviewWithOptions$lambda$1$0(state).get(pagerState.getCurrentPage());
        DirectoryPaths singletonInitializer = DirectoryPaths.INSTANCE.getInstance();
        Content content = attachment.getContent();
        kotlin.jvm.internal.y.g(content, "null cannot be cast to non-null type cu.todus.android.data.db.pojo.content.FileContent");
        singletonInitializer.saveToPublicFolder(((FileContent) content).getPath(), context, ((FileContent) attachment.getContent()).getName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 AttachmentPreviewWithOptions$lambda$2(AttachmentPreviewState attachmentPreviewState, Function1 function1, lb.a aVar, Function1 function2, AttachmentPreviewViewModel attachmentPreviewViewModel, int i10, int i11, Composer composer, int i12) {
        AttachmentPreviewWithOptions(attachmentPreviewState, function1, aVar, function2, attachmentPreviewViewModel, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return ua.k0.f43947a;
    }

    /* JADX WARN: Code duplicated, block: B:102:0x021b  */
    /* JADX WARN: Code duplicated, block: B:104:0x0223  */
    /* JADX WARN: Code duplicated, block: B:106:0x0249  */
    /* JADX WARN: Code duplicated, block: B:108:0x0255  */
    /* JADX WARN: Code duplicated, block: B:110:0x0261  */
    /* JADX WARN: Code duplicated, block: B:111:0x0264  */
    /* JADX WARN: Code duplicated, block: B:114:0x026b  */
    /* JADX WARN: Code duplicated, block: B:116:0x0273  */
    /* JADX WARN: Code duplicated, block: B:118:0x0292  */
    /* JADX WARN: Code duplicated, block: B:120:0x029d A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:122:0x02dd  */
    /* JADX WARN: Code duplicated, block: B:125:0x02f2  */
    /* JADX WARN: Code duplicated, block: B:127:0x02f8  */
    /* JADX WARN: Code duplicated, block: B:130:0x0304  */
    /* JADX WARN: Code duplicated, block: B:132:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:44:0x0084  */
    /* JADX WARN: Code duplicated, block: B:46:0x0088  */
    /* JADX WARN: Code duplicated, block: B:48:0x008b  */
    /* JADX WARN: Code duplicated, block: B:50:0x0093  */
    /* JADX WARN: Code duplicated, block: B:51:0x0096  */
    /* JADX WARN: Code duplicated, block: B:55:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:56:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:59:0x00b1 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:60:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:61:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:63:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:65:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:67:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:70:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:73:0x0115  */
    /* JADX WARN: Code duplicated, block: B:76:0x0121  */
    /* JADX WARN: Code duplicated, block: B:77:0x0125  */
    /* JADX WARN: Code duplicated, block: B:80:0x0159  */
    /* JADX WARN: Code duplicated, block: B:81:0x015b  */
    /* JADX WARN: Code duplicated, block: B:84:0x0162  */
    /* JADX WARN: Code duplicated, block: B:86:0x016a  */
    /* JADX WARN: Code duplicated, block: B:89:0x01c4  */
    /* JADX WARN: Code duplicated, block: B:92:0x01d0  */
    /* JADX WARN: Code duplicated, block: B:93:0x01d4  */
    /* JADX WARN: Code duplicated, block: B:96:0x0204  */
    /* JADX WARN: Code duplicated, block: B:98:0x0211  */
    /* JADX WARN: Code duplicated, block: B:99:0x0214  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void AttachmentTopBar(final Modifier modifier, final lb.a onClose, final boolean z10, final lb.a onOpenOptions, boolean z11, lb.a aVar, Composer composer, final int i10, final int i11) {
        int i12;
        int i13;
        lb.a aVar2;
        int i14;
        boolean z12;
        final boolean z13;
        final lb.a aVar3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        boolean z14;
        lb.a aVar4;
        lb.a constructor;
        boolean z15;
        Object objRememberedValue;
        ComposableSingletons$AttachmentPreviewKt composableSingletons$AttachmentPreviewKt;
        final lb.a aVar5;
        Modifier.Companion companion;
        lb.a constructor2;
        Modifier.Companion companion2;
        boolean z16;
        Object objRememberedValue2;
        boolean z17;
        Object objRememberedValue3;
        Object objRememberedValue4;
        kotlin.jvm.internal.y.i(modifier, "modifier");
        kotlin.jvm.internal.y.i(onClose, "onClose");
        kotlin.jvm.internal.y.i(onOpenOptions, "onOpenOptions");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1462932909);
        if ((i10 & 6) == 0) {
            i12 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i10;
        } else {
            i12 = i10;
        }
        if ((i10 & 48) == 0) {
            i12 |= composerStartRestartGroup.changedInstance(onClose) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i12 |= composerStartRestartGroup.changed(z10) ? 256 : 128;
        }
        if ((i10 & 3072) == 0) {
            i12 |= composerStartRestartGroup.changedInstance(onOpenOptions) ? 2048 : 1024;
        }
        int i15 = i11 & 16;
        if (i15 == 0) {
            if ((i10 & 24576) == 0) {
                i12 |= composerStartRestartGroup.changed(z11) ? 16384 : 8192;
            }
            i13 = i11 & 32;
            if (i13 != 0) {
                if ((196608 & i10) == 0) {
                    aVar2 = aVar;
                    if (composerStartRestartGroup.changedInstance(aVar2)) {
                        i14 = 131072;
                    } else {
                        i14 = 65536;
                    }
                    i12 |= i14;
                }
                if ((74899 & i12) != 74898) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z12, i12 & 1)) {
                    if (i15 != 0) {
                        z14 = false;
                    } else {
                        z14 = z11;
                    }
                    if (i13 != 0) {
                        objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue4 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.attachmentPreview.a
                                @Override // lb.a
                                public final Object invoke() {
                                    return ua.k0.f43947a;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        }
                        aVar4 = (lb.a) objRememberedValue4;
                    } else {
                        aVar4 = aVar2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1462932909, i12, -1, "cu.todus.android.uiCompose.main.screen.chat.attachmentPreview.AttachmentTopBar (AttachmentPreview.kt:323)");
                    }
                    Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(modifier, 0.0f, 1, null);
                    Alignment.Companion companion3 = Alignment.INSTANCE;
                    Alignment.Vertical centerVertically = companion3.getCenterVertically();
                    Arrangement arrangement = Arrangement.INSTANCE;
                    MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getSpaceBetween(), centerVertically, composerStartRestartGroup, 54);
                    int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxWidth$default);
                    ComposeUiNode.Companion companion4 = ComposeUiNode.INSTANCE;
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
                    Composer composerM5176constructorimpl = Updater.m5176constructorimpl(composerStartRestartGroup);
                    Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyRowMeasurePolicy, companion4.getSetMeasurePolicy());
                    Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion4.getSetResolvedCompositionLocals());
                    Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion4.getSetCompositeKeyHash());
                    Updater.m5182reconcileimpl(composerM5176constructorimpl, companion4.getApplyOnDeactivatedNodeAssertion());
                    Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion4.getSetModifier());
                    RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                    if ((i12 & 112) == 32) {
                        z15 = true;
                    } else {
                        z15 = false;
                    }
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (z15 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.attachmentPreview.l
                            @Override // lb.a
                            public final Object invoke() {
                                return AttachmentPreviewKt.AttachmentTopBar$lambda$1$0$0(onClose);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composableSingletons$AttachmentPreviewKt = ComposableSingletons$AttachmentPreviewKt.INSTANCE;
                    aVar5 = aVar4;
                    IconButtonKt.IconButton((lb.a) objRememberedValue, null, false, null, null, null, composableSingletons$AttachmentPreviewKt.m9854getLambda$866094319$app_productionPFast(), composerStartRestartGroup, 1572864, 62);
                    Alignment.Vertical centerVertically2 = companion3.getCenterVertically();
                    companion = Modifier.INSTANCE;
                    MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(arrangement.getStart(), centerVertically2, composerStartRestartGroup, 48);
                    int iA2 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
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
                    Composer composerM5176constructorimpl2 = Updater.m5176constructorimpl(composerStartRestartGroup);
                    Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyRowMeasurePolicy2, companion4.getSetMeasurePolicy());
                    Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap2, companion4.getSetResolvedCompositionLocals());
                    Updater.m5180initimpl(composerM5176constructorimpl2, Integer.valueOf(iA2), companion4.getSetCompositeKeyHash());
                    Updater.m5182reconcileimpl(composerM5176constructorimpl2, companion4.getApplyOnDeactivatedNodeAssertion());
                    Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier2, companion4.getSetModifier());
                    if (z14) {
                        composerStartRestartGroup.startReplaceGroup(408802395);
                        if ((458752 & i12) == 131072) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (z17 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue3 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.attachmentPreview.n
                                @Override // lb.a
                                public final Object invoke() {
                                    return AttachmentPreviewKt.AttachmentTopBar$lambda$1$1$0$0(aVar5);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        companion2 = companion;
                        IconButtonKt.IconButton((lb.a) objRememberedValue3, null, false, null, null, null, composableSingletons$AttachmentPreviewKt.getLambda$1629990130$app_productionPFast(), composerStartRestartGroup, 1572864, 62);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        companion2 = companion;
                        composerStartRestartGroup.startReplaceGroup(-211643241);
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    if (z10) {
                        composerStartRestartGroup.startReplaceGroup(408816701);
                        if ((i12 & 7168) == 2048) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (z16 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.attachmentPreview.o
                                @Override // lb.a
                                public final Object invoke() {
                                    return AttachmentPreviewKt.AttachmentTopBar$lambda$1$1$1$0(onOpenOptions);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        IconButtonKt.IconButton((lb.a) objRememberedValue2, null, false, null, null, null, composableSingletons$AttachmentPreviewKt.m9853getLambda$1990818405$app_productionPFast(), composerStartRestartGroup, 1572864, 62);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-211197833);
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    if (!z10 || z14) {
                        composerStartRestartGroup.startReplaceGroup(-210903209);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-211141537);
                        Z17PictureKt.m10278Z17BasePictureC8z9wKI(SizeKt.m1769size3ABfNKs(companion2, Dp.m8823constructorimpl(24)), "", null, ColorFilter.Companion.m5907tintxETnrds$default(ColorFilter.INSTANCE, MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground(), 0, 2, null), null, null, 0, null, null, composerStartRestartGroup, 54, XMPPTCPConnection.PacketWriter.QUEUE_SIZE);
                        composerStartRestartGroup = composerStartRestartGroup;
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endNode();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z13 = z14;
                    aVar3 = aVar5;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    z13 = z11;
                    aVar3 = aVar2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.attachmentPreview.p
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AttachmentPreviewKt.AttachmentTopBar$lambda$2(modifier, onClose, z10, onOpenOptions, z13, aVar3, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i12 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            aVar2 = aVar;
            if ((74899 & i12) != 74898) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z12, i12 & 1)) {
                if (i15 != 0) {
                    z14 = false;
                } else {
                    z14 = z11;
                }
                if (i13 != 0) {
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue4 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.attachmentPreview.a
                            @Override // lb.a
                            public final Object invoke() {
                                return ua.k0.f43947a;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    aVar4 = (lb.a) objRememberedValue4;
                } else {
                    aVar4 = aVar2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1462932909, i12, -1, "cu.todus.android.uiCompose.main.screen.chat.attachmentPreview.AttachmentTopBar (AttachmentPreview.kt:323)");
                }
                Modifier modifierFillMaxWidth$default2 = SizeKt.fillMaxWidth$default(modifier, 0.0f, 1, null);
                Alignment.Companion companion5 = Alignment.INSTANCE;
                Alignment.Vertical centerVertically3 = companion5.getCenterVertically();
                Arrangement arrangement2 = Arrangement.INSTANCE;
                MeasurePolicy measurePolicyRowMeasurePolicy3 = RowKt.rowMeasurePolicy(arrangement2.getSpaceBetween(), centerVertically3, composerStartRestartGroup, 54);
                int iA3 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxWidth$default2);
                ComposeUiNode.Companion companion6 = ComposeUiNode.INSTANCE;
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
                Composer composerM5176constructorimpl3 = Updater.m5176constructorimpl(composerStartRestartGroup);
                Updater.m5184setimpl(composerM5176constructorimpl3, measurePolicyRowMeasurePolicy3, companion6.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl3, currentCompositionLocalMap3, companion6.getSetResolvedCompositionLocals());
                Updater.m5180initimpl(composerM5176constructorimpl3, Integer.valueOf(iA3), companion6.getSetCompositeKeyHash());
                Updater.m5182reconcileimpl(composerM5176constructorimpl3, companion6.getApplyOnDeactivatedNodeAssertion());
                Updater.m5184setimpl(composerM5176constructorimpl3, modifierMaterializeModifier3, companion6.getSetModifier());
                RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
                if ((i12 & 112) == 32) {
                    z15 = true;
                } else {
                    z15 = false;
                }
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (z15) {
                    objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.attachmentPreview.l
                        @Override // lb.a
                        public final Object invoke() {
                            return AttachmentPreviewKt.AttachmentTopBar$lambda$1$0$0(onClose);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.attachmentPreview.l
                        @Override // lb.a
                        public final Object invoke() {
                            return AttachmentPreviewKt.AttachmentTopBar$lambda$1$0$0(onClose);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composableSingletons$AttachmentPreviewKt = ComposableSingletons$AttachmentPreviewKt.INSTANCE;
                aVar5 = aVar4;
                IconButtonKt.IconButton((lb.a) objRememberedValue, null, false, null, null, null, composableSingletons$AttachmentPreviewKt.m9854getLambda$866094319$app_productionPFast(), composerStartRestartGroup, 1572864, 62);
                Alignment.Vertical centerVertically4 = companion5.getCenterVertically();
                companion = Modifier.INSTANCE;
                MeasurePolicy measurePolicyRowMeasurePolicy4 = RowKt.rowMeasurePolicy(arrangement2.getStart(), centerVertically4, composerStartRestartGroup, 48);
                int iA4 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
                constructor2 = companion6.getConstructor();
                if (!defpackage.r.a(composerStartRestartGroup.getApplier())) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor2);
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM5176constructorimpl4 = Updater.m5176constructorimpl(composerStartRestartGroup);
                Updater.m5184setimpl(composerM5176constructorimpl4, measurePolicyRowMeasurePolicy4, companion6.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl4, currentCompositionLocalMap4, companion6.getSetResolvedCompositionLocals());
                Updater.m5180initimpl(composerM5176constructorimpl4, Integer.valueOf(iA4), companion6.getSetCompositeKeyHash());
                Updater.m5182reconcileimpl(composerM5176constructorimpl4, companion6.getApplyOnDeactivatedNodeAssertion());
                Updater.m5184setimpl(composerM5176constructorimpl4, modifierMaterializeModifier4, companion6.getSetModifier());
                if (z14) {
                    composerStartRestartGroup.startReplaceGroup(408802395);
                    if ((458752 & i12) == 131072) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (z17) {
                        objRememberedValue3 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.attachmentPreview.n
                            @Override // lb.a
                            public final Object invoke() {
                                return AttachmentPreviewKt.AttachmentTopBar$lambda$1$1$0$0(aVar5);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.attachmentPreview.n
                            @Override // lb.a
                            public final Object invoke() {
                                return AttachmentPreviewKt.AttachmentTopBar$lambda$1$1$0$0(aVar5);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    companion2 = companion;
                    IconButtonKt.IconButton((lb.a) objRememberedValue3, null, false, null, null, null, composableSingletons$AttachmentPreviewKt.getLambda$1629990130$app_productionPFast(), composerStartRestartGroup, 1572864, 62);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    companion2 = companion;
                    composerStartRestartGroup.startReplaceGroup(-211643241);
                    composerStartRestartGroup.endReplaceGroup();
                }
                if (z10) {
                    composerStartRestartGroup.startReplaceGroup(408816701);
                    if ((i12 & 7168) == 2048) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (z16) {
                        objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.attachmentPreview.o
                            @Override // lb.a
                            public final Object invoke() {
                                return AttachmentPreviewKt.AttachmentTopBar$lambda$1$1$1$0(onOpenOptions);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.attachmentPreview.o
                            @Override // lb.a
                            public final Object invoke() {
                                return AttachmentPreviewKt.AttachmentTopBar$lambda$1$1$1$0(onOpenOptions);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    IconButtonKt.IconButton((lb.a) objRememberedValue2, null, false, null, null, null, composableSingletons$AttachmentPreviewKt.m9853getLambda$1990818405$app_productionPFast(), composerStartRestartGroup, 1572864, 62);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(-211197833);
                    composerStartRestartGroup.endReplaceGroup();
                }
                if (z10) {
                    composerStartRestartGroup.startReplaceGroup(-210903209);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(-210903209);
                    composerStartRestartGroup.endReplaceGroup();
                }
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z13 = z14;
                aVar3 = aVar5;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                z13 = z11;
                aVar3 = aVar2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.attachmentPreview.p
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AttachmentPreviewKt.AttachmentTopBar$lambda$2(modifier, onClose, z10, onOpenOptions, z13, aVar3, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i12 |= 24576;
        i13 = i11 & 32;
        if (i13 != 0) {
            if ((196608 & i10) == 0) {
                aVar2 = aVar;
                if (composerStartRestartGroup.changedInstance(aVar2)) {
                    i14 = 131072;
                } else {
                    i14 = 65536;
                }
                i12 |= i14;
            }
            if ((74899 & i12) != 74898) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z12, i12 & 1)) {
                if (i15 != 0) {
                    z14 = false;
                } else {
                    z14 = z11;
                }
                if (i13 != 0) {
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue4 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.attachmentPreview.a
                            @Override // lb.a
                            public final Object invoke() {
                                return ua.k0.f43947a;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    aVar4 = (lb.a) objRememberedValue4;
                } else {
                    aVar4 = aVar2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1462932909, i12, -1, "cu.todus.android.uiCompose.main.screen.chat.attachmentPreview.AttachmentTopBar (AttachmentPreview.kt:323)");
                }
                Modifier modifierFillMaxWidth$default3 = SizeKt.fillMaxWidth$default(modifier, 0.0f, 1, null);
                Alignment.Companion companion7 = Alignment.INSTANCE;
                Alignment.Vertical centerVertically5 = companion7.getCenterVertically();
                Arrangement arrangement3 = Arrangement.INSTANCE;
                MeasurePolicy measurePolicyRowMeasurePolicy5 = RowKt.rowMeasurePolicy(arrangement3.getSpaceBetween(), centerVertically5, composerStartRestartGroup, 54);
                int iA5 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap5 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier5 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxWidth$default3);
                ComposeUiNode.Companion companion8 = ComposeUiNode.INSTANCE;
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
                Composer composerM5176constructorimpl5 = Updater.m5176constructorimpl(composerStartRestartGroup);
                Updater.m5184setimpl(composerM5176constructorimpl5, measurePolicyRowMeasurePolicy5, companion8.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl5, currentCompositionLocalMap5, companion8.getSetResolvedCompositionLocals());
                Updater.m5180initimpl(composerM5176constructorimpl5, Integer.valueOf(iA5), companion8.getSetCompositeKeyHash());
                Updater.m5182reconcileimpl(composerM5176constructorimpl5, companion8.getApplyOnDeactivatedNodeAssertion());
                Updater.m5184setimpl(composerM5176constructorimpl5, modifierMaterializeModifier5, companion8.getSetModifier());
                RowScopeInstance rowScopeInstance3 = RowScopeInstance.INSTANCE;
                if ((i12 & 112) == 32) {
                    z15 = true;
                } else {
                    z15 = false;
                }
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (z15) {
                    objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.attachmentPreview.l
                        @Override // lb.a
                        public final Object invoke() {
                            return AttachmentPreviewKt.AttachmentTopBar$lambda$1$0$0(onClose);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.attachmentPreview.l
                        @Override // lb.a
                        public final Object invoke() {
                            return AttachmentPreviewKt.AttachmentTopBar$lambda$1$0$0(onClose);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composableSingletons$AttachmentPreviewKt = ComposableSingletons$AttachmentPreviewKt.INSTANCE;
                aVar5 = aVar4;
                IconButtonKt.IconButton((lb.a) objRememberedValue, null, false, null, null, null, composableSingletons$AttachmentPreviewKt.m9854getLambda$866094319$app_productionPFast(), composerStartRestartGroup, 1572864, 62);
                Alignment.Vertical centerVertically6 = companion7.getCenterVertically();
                companion = Modifier.INSTANCE;
                MeasurePolicy measurePolicyRowMeasurePolicy6 = RowKt.rowMeasurePolicy(arrangement3.getStart(), centerVertically6, composerStartRestartGroup, 48);
                int iA6 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap6 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier6 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
                constructor2 = companion8.getConstructor();
                if (!defpackage.r.a(composerStartRestartGroup.getApplier())) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor2);
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM5176constructorimpl6 = Updater.m5176constructorimpl(composerStartRestartGroup);
                Updater.m5184setimpl(composerM5176constructorimpl6, measurePolicyRowMeasurePolicy6, companion8.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl6, currentCompositionLocalMap6, companion8.getSetResolvedCompositionLocals());
                Updater.m5180initimpl(composerM5176constructorimpl6, Integer.valueOf(iA6), companion8.getSetCompositeKeyHash());
                Updater.m5182reconcileimpl(composerM5176constructorimpl6, companion8.getApplyOnDeactivatedNodeAssertion());
                Updater.m5184setimpl(composerM5176constructorimpl6, modifierMaterializeModifier6, companion8.getSetModifier());
                if (z14) {
                    composerStartRestartGroup.startReplaceGroup(408802395);
                    if ((458752 & i12) == 131072) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (z17) {
                        objRememberedValue3 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.attachmentPreview.n
                            @Override // lb.a
                            public final Object invoke() {
                                return AttachmentPreviewKt.AttachmentTopBar$lambda$1$1$0$0(aVar5);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.attachmentPreview.n
                            @Override // lb.a
                            public final Object invoke() {
                                return AttachmentPreviewKt.AttachmentTopBar$lambda$1$1$0$0(aVar5);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    companion2 = companion;
                    IconButtonKt.IconButton((lb.a) objRememberedValue3, null, false, null, null, null, composableSingletons$AttachmentPreviewKt.getLambda$1629990130$app_productionPFast(), composerStartRestartGroup, 1572864, 62);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    companion2 = companion;
                    composerStartRestartGroup.startReplaceGroup(-211643241);
                    composerStartRestartGroup.endReplaceGroup();
                }
                if (z10) {
                    composerStartRestartGroup.startReplaceGroup(408816701);
                    if ((i12 & 7168) == 2048) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (z16) {
                        objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.attachmentPreview.o
                            @Override // lb.a
                            public final Object invoke() {
                                return AttachmentPreviewKt.AttachmentTopBar$lambda$1$1$1$0(onOpenOptions);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.attachmentPreview.o
                            @Override // lb.a
                            public final Object invoke() {
                                return AttachmentPreviewKt.AttachmentTopBar$lambda$1$1$1$0(onOpenOptions);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    IconButtonKt.IconButton((lb.a) objRememberedValue2, null, false, null, null, null, composableSingletons$AttachmentPreviewKt.m9853getLambda$1990818405$app_productionPFast(), composerStartRestartGroup, 1572864, 62);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(-211197833);
                    composerStartRestartGroup.endReplaceGroup();
                }
                if (z10) {
                    composerStartRestartGroup.startReplaceGroup(-210903209);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(-210903209);
                    composerStartRestartGroup.endReplaceGroup();
                }
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z13 = z14;
                aVar3 = aVar5;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                z13 = z11;
                aVar3 = aVar2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.attachmentPreview.p
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AttachmentPreviewKt.AttachmentTopBar$lambda$2(modifier, onClose, z10, onOpenOptions, z13, aVar3, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i12 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        aVar2 = aVar;
        if ((74899 & i12) != 74898) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z12, i12 & 1)) {
            if (i15 != 0) {
                z14 = false;
            } else {
                z14 = z11;
            }
            if (i13 != 0) {
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue4 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.attachmentPreview.a
                        @Override // lb.a
                        public final Object invoke() {
                            return ua.k0.f43947a;
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                aVar4 = (lb.a) objRememberedValue4;
            } else {
                aVar4 = aVar2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1462932909, i12, -1, "cu.todus.android.uiCompose.main.screen.chat.attachmentPreview.AttachmentTopBar (AttachmentPreview.kt:323)");
            }
            Modifier modifierFillMaxWidth$default4 = SizeKt.fillMaxWidth$default(modifier, 0.0f, 1, null);
            Alignment.Companion companion9 = Alignment.INSTANCE;
            Alignment.Vertical centerVertically7 = companion9.getCenterVertically();
            Arrangement arrangement4 = Arrangement.INSTANCE;
            MeasurePolicy measurePolicyRowMeasurePolicy7 = RowKt.rowMeasurePolicy(arrangement4.getSpaceBetween(), centerVertically7, composerStartRestartGroup, 54);
            int iA7 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap7 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier7 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxWidth$default4);
            ComposeUiNode.Companion companion10 = ComposeUiNode.INSTANCE;
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
            Composer composerM5176constructorimpl7 = Updater.m5176constructorimpl(composerStartRestartGroup);
            Updater.m5184setimpl(composerM5176constructorimpl7, measurePolicyRowMeasurePolicy7, companion10.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl7, currentCompositionLocalMap7, companion10.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl7, Integer.valueOf(iA7), companion10.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl7, companion10.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl7, modifierMaterializeModifier7, companion10.getSetModifier());
            RowScopeInstance rowScopeInstance4 = RowScopeInstance.INSTANCE;
            if ((i12 & 112) == 32) {
                z15 = true;
            } else {
                z15 = false;
            }
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z15) {
                objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.attachmentPreview.l
                    @Override // lb.a
                    public final Object invoke() {
                        return AttachmentPreviewKt.AttachmentTopBar$lambda$1$0$0(onClose);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.attachmentPreview.l
                    @Override // lb.a
                    public final Object invoke() {
                        return AttachmentPreviewKt.AttachmentTopBar$lambda$1$0$0(onClose);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composableSingletons$AttachmentPreviewKt = ComposableSingletons$AttachmentPreviewKt.INSTANCE;
            aVar5 = aVar4;
            IconButtonKt.IconButton((lb.a) objRememberedValue, null, false, null, null, null, composableSingletons$AttachmentPreviewKt.m9854getLambda$866094319$app_productionPFast(), composerStartRestartGroup, 1572864, 62);
            Alignment.Vertical centerVertically8 = companion9.getCenterVertically();
            companion = Modifier.INSTANCE;
            MeasurePolicy measurePolicyRowMeasurePolicy8 = RowKt.rowMeasurePolicy(arrangement4.getStart(), centerVertically8, composerStartRestartGroup, 48);
            int iA8 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap8 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier8 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
            constructor2 = companion10.getConstructor();
            if (!defpackage.r.a(composerStartRestartGroup.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor2);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM5176constructorimpl8 = Updater.m5176constructorimpl(composerStartRestartGroup);
            Updater.m5184setimpl(composerM5176constructorimpl8, measurePolicyRowMeasurePolicy8, companion10.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl8, currentCompositionLocalMap8, companion10.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl8, Integer.valueOf(iA8), companion10.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl8, companion10.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl8, modifierMaterializeModifier8, companion10.getSetModifier());
            if (z14) {
                composerStartRestartGroup.startReplaceGroup(408802395);
                if ((458752 & i12) == 131072) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (z17) {
                    objRememberedValue3 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.attachmentPreview.n
                        @Override // lb.a
                        public final Object invoke() {
                            return AttachmentPreviewKt.AttachmentTopBar$lambda$1$1$0$0(aVar5);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.attachmentPreview.n
                        @Override // lb.a
                        public final Object invoke() {
                            return AttachmentPreviewKt.AttachmentTopBar$lambda$1$1$0$0(aVar5);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                companion2 = companion;
                IconButtonKt.IconButton((lb.a) objRememberedValue3, null, false, null, null, null, composableSingletons$AttachmentPreviewKt.getLambda$1629990130$app_productionPFast(), composerStartRestartGroup, 1572864, 62);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                companion2 = companion;
                composerStartRestartGroup.startReplaceGroup(-211643241);
                composerStartRestartGroup.endReplaceGroup();
            }
            if (z10) {
                composerStartRestartGroup.startReplaceGroup(408816701);
                if ((i12 & 7168) == 2048) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (z16) {
                    objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.attachmentPreview.o
                        @Override // lb.a
                        public final Object invoke() {
                            return AttachmentPreviewKt.AttachmentTopBar$lambda$1$1$1$0(onOpenOptions);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.attachmentPreview.o
                        @Override // lb.a
                        public final Object invoke() {
                            return AttachmentPreviewKt.AttachmentTopBar$lambda$1$1$1$0(onOpenOptions);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                IconButtonKt.IconButton((lb.a) objRememberedValue2, null, false, null, null, null, composableSingletons$AttachmentPreviewKt.m9853getLambda$1990818405$app_productionPFast(), composerStartRestartGroup, 1572864, 62);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-211197833);
                composerStartRestartGroup.endReplaceGroup();
            }
            if (z10) {
                composerStartRestartGroup.startReplaceGroup(-210903209);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-210903209);
                composerStartRestartGroup.endReplaceGroup();
            }
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            z13 = z14;
            aVar3 = aVar5;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            z13 = z11;
            aVar3 = aVar2;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.attachmentPreview.p
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AttachmentPreviewKt.AttachmentTopBar$lambda$2(modifier, onClose, z10, onOpenOptions, z13, aVar3, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 AttachmentTopBar$lambda$1$0$0(lb.a aVar) {
        aVar.invoke();
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 AttachmentTopBar$lambda$1$1$0$0(lb.a aVar) {
        aVar.invoke();
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 AttachmentTopBar$lambda$1$1$1$0(lb.a aVar) {
        aVar.invoke();
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 AttachmentTopBar$lambda$2(Modifier modifier, lb.a aVar, boolean z10, lb.a aVar2, boolean z11, lb.a aVar3, int i10, int i11, Composer composer, int i12) {
        AttachmentTopBar(modifier, aVar, z10, aVar2, z11, aVar3, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return ua.k0.f43947a;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void ItemPreview(Attachment attachment, boolean z10, String msgId, final boolean z11, final Function1 goStickers, Composer composer, final int i10) {
        int i11;
        boolean z12;
        String str;
        final Attachment attachment2;
        kotlin.jvm.internal.y.i(attachment, "attachment");
        kotlin.jvm.internal.y.i(msgId, "msgId");
        kotlin.jvm.internal.y.i(goStickers, "goStickers");
        Composer composerStartRestartGroup = composer.startRestartGroup(576403801);
        if ((i10 & 6) == 0) {
            i11 = (composerStartRestartGroup.changed(attachment) ? 4 : 2) | i10;
        } else {
            i11 = i10;
        }
        if ((i10 & 48) == 0) {
            i11 |= composerStartRestartGroup.changed(z10) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i11 |= composerStartRestartGroup.changed(msgId) ? 256 : 128;
        }
        if ((i10 & 3072) == 0) {
            i11 |= composerStartRestartGroup.changed(z11) ? 2048 : 1024;
        }
        if ((i10 & 24576) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(goStickers) ? 16384 : 8192;
        }
        if (composerStartRestartGroup.shouldExecute((i11 & 9363) != 9362, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(576403801, i11, -1, "cu.todus.android.uiCompose.main.screen.chat.attachmentPreview.ItemPreview (AttachmentPreview.kt:282)");
            }
            if (attachment.getType() == 1) {
                composerStartRestartGroup.startReplaceGroup(-126721433);
                z12 = z10;
                str = msgId;
                ImagePreviewKt.ImagePreview(attachment, z12, str, !PathsVolatileState.INSTANCE.getInstance().publicImages() || z11, composerStartRestartGroup, i11 & AnalyticsListener.EVENT_DRM_SESSION_ACQUIRED);
                attachment2 = attachment;
                composerStartRestartGroup.endReplaceGroup();
            } else {
                z12 = z10;
                str = msgId;
                attachment2 = attachment;
                if (attachment2.getType() == 2) {
                    composerStartRestartGroup.startReplaceGroup(-126713113);
                    VideoPreviewKt.VideoPreview(attachment2, z12, str, !PathsVolatileState.INSTANCE.getInstance().publicVideos() || z11, composerStartRestartGroup, i11 & AnalyticsListener.EVENT_DRM_SESSION_ACQUIRED);
                    composerStartRestartGroup.endReplaceGroup();
                } else if (attachment2.getType() == 5 && (attachment2.getContent() instanceof FileContent) && le.a0.F(((FileContent) attachment2.getContent()).getPath(), ".pdf", false, 2, null)) {
                    composerStartRestartGroup.startReplaceGroup(-126701678);
                    PdfPreviewKt.PdfPreview(attachment2, composerStartRestartGroup, i11 & 14);
                    composerStartRestartGroup.endReplaceGroup();
                } else if (attachment2.getType() == 5) {
                    composerStartRestartGroup.startReplaceGroup(-126698157);
                    FilePreviewKt.FilePreview(attachment2, composerStartRestartGroup, i11 & 14);
                    composerStartRestartGroup.endReplaceGroup();
                } else if (attachment2.getType() == 13) {
                    composerStartRestartGroup.startReplaceGroup(-126694470);
                    StickerPreviewKt.StickerPreview(attachment2, goStickers, composerStartRestartGroup, (i11 & 14) | ((i11 >> 9) & 112));
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(367537897);
                    composerStartRestartGroup.endReplaceGroup();
                }
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            z12 = z10;
            str = msgId;
            attachment2 = attachment;
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final boolean z13 = z12;
            final String str2 = str;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.attachmentPreview.j
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AttachmentPreviewKt.ItemPreview$lambda$0(attachment2, z13, str2, z11, goStickers, i10, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ItemPreview$lambda$0(Attachment attachment, boolean z10, String str, boolean z11, Function1 function1, int i10, Composer composer, int i11) {
        ItemPreview(attachment, z10, str, z11, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1));
        return ua.k0.f43947a;
    }

    @Composable
    public static final void PopupMenuItem(Object icon, String label, final lb.a onClick, Composer composer, final int i10) {
        int i11;
        final Object obj;
        Composer composer2;
        final String str;
        kotlin.jvm.internal.y.i(icon, "icon");
        kotlin.jvm.internal.y.i(label, "label");
        kotlin.jvm.internal.y.i(onClick, "onClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(263546890);
        if ((i10 & 6) == 0) {
            i11 = (composerStartRestartGroup.changedInstance(icon) ? 4 : 2) | i10;
        } else {
            i11 = i10;
        }
        if ((i10 & 48) == 0) {
            i11 |= composerStartRestartGroup.changed(label) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(onClick) ? 256 : 128;
        }
        int i12 = i11;
        if (composerStartRestartGroup.shouldExecute((i12 & 147) != 146, i12 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(263546890, i12, -1, "cu.todus.android.uiCompose.main.screen.chat.attachmentPreview.PopupMenuItem (AttachmentPreview.kt:383)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            boolean z10 = (i12 & 896) == 256;
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z10 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.attachmentPreview.q
                    @Override // lb.a
                    public final Object invoke() {
                        return AttachmentPreviewKt.PopupMenuItem$lambda$0$0(onClick);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            Modifier modifierM1240clickableoSLSa3U$default = ClickableKt.m1240clickableoSLSa3U$default(companion, false, null, null, null, (lb.a) objRememberedValue, 15, null);
            MaterialTheme materialTheme = MaterialTheme.INSTANCE;
            int i13 = MaterialTheme.$stable;
            float f10 = 10;
            Modifier modifierM1725padding3ABfNKs = PaddingKt.m1725padding3ABfNKs(BackgroundKt.m1205backgroundbw27NRU$default(modifierM1240clickableoSLSa3U$default, materialTheme.getColorScheme(composerStartRestartGroup, i13).getBackground(), null, 2, null), Dp.m8823constructorimpl(f10));
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getCenterVertically(), composerStartRestartGroup, 48);
            int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1725padding3ABfNKs);
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
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyRowMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion2.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl, companion2.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion2.getSetModifier());
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            SpacerKt.Spacer(SizeKt.m1774width3ABfNKs(companion, Dp.m8823constructorimpl(f10)), composerStartRestartGroup, 6);
            Z17PictureKt.m10278Z17BasePictureC8z9wKI(SizeKt.m1769size3ABfNKs(companion, Dp.m8823constructorimpl(24)), icon, null, ColorFilter.Companion.m5907tintxETnrds$default(ColorFilter.INSTANCE, materialTheme.getColorScheme(composerStartRestartGroup, i13).getOnBackground(), 0, 2, null), null, null, 0, null, null, composerStartRestartGroup, ((i12 << 3) & 112) | 6, XMPPTCPConnection.PacketWriter.QUEUE_SIZE);
            obj = icon;
            SpacerKt.Spacer(SizeKt.m1774width3ABfNKs(companion, Dp.m8823constructorimpl(f10)), composerStartRestartGroup, 6);
            str = label;
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, str, null, 0L, 1, 0, composerStartRestartGroup, (i12 & 112) | 24576, 45);
            composer2 = composerStartRestartGroup;
            SpacerKt.Spacer(SizeKt.m1774width3ABfNKs(companion, Dp.m8823constructorimpl(f10)), composer2, 6);
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            obj = icon;
            composer2 = composerStartRestartGroup;
            str = label;
            composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.attachmentPreview.r
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return AttachmentPreviewKt.PopupMenuItem$lambda$2(obj, str, onClick, i10, (Composer) obj2, ((Integer) obj3).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 PopupMenuItem$lambda$0$0(lb.a aVar) {
        aVar.invoke();
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 PopupMenuItem$lambda$2(Object obj, String str, lb.a aVar, int i10, Composer composer, int i11) {
        PopupMenuItem(obj, str, aVar, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1));
        return ua.k0.f43947a;
    }
}
