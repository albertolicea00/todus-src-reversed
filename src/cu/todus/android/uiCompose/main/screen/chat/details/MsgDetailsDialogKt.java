package cu.todus.android.uiCompose.main.screen.chat.details;

import android.content.Context;
import android.text.format.DateFormat;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
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
import androidx.compose.foundation.layout.e3;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.LazyListStateKt;
import androidx.compose.foundation.text.InlineTextContentKt;
import androidx.compose.material.MenuKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.PlatformSpanStyle;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.common.C;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.navigation.NavController;
import androidx.navigation.NavHostController;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigator;
import androidx.p001lifecycle.HasDefaultViewModelProviderFactory;
import androidx.p001lifecycle.Lifecycle;
import androidx.p001lifecycle.LifecycleOwner;
import androidx.p001lifecycle.ViewModelProvider;
import androidx.p001lifecycle.ViewModelStoreOwner;
import androidx.p001lifecycle.p002compose.FlowExtKt;
import androidx.p001lifecycle.viewmodel.CreationExtras;
import androidx.p001lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.p001lifecycle.viewmodel.compose.ViewModelKt;
import androidx.paging.compose.LazyFoundationExtensionsKt;
import androidx.paging.compose.LazyPagingItems;
import androidx.paging.compose.LazyPagingItemsKt;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import cu.todus.android.R;
import cu.todus.android.data.db.entity.toDus.Attachment;
import cu.todus.android.data.db.entity.toDus.Contact;
import cu.todus.android.data.db.entity.toDus.Message;
import cu.todus.android.data.db.entity.toDus.Room;
import cu.todus.android.data.db.entity.toDus.User;
import cu.todus.android.data.db.pojo.MarkerWithPartner;
import cu.todus.android.data.db.pojo.MessageWithPartnerWithReactions;
import cu.todus.android.data.db.pojo.MessageWithPartnerWithRoomWithReactions;
import cu.todus.android.data.db.pojo.ReactionWithPartner;
import cu.todus.android.di.MainModule;
import cu.todus.android.repositories.ReactionsRepository;
import cu.todus.android.uiCompose.main.screen.chat.component.ChatParams;
import cu.todus.android.uiCompose.main.screen.chat.item.MessageAction;
import cu.todus.android.uiCompose.main.screen.chat.item.MessageItemKt;
import cu.todus.android.uiCompose.main.screen.chat.item.MsgStatusKt;
import cu.todus.android.uiCompose.navigation.NavLinks;
import cu.todus.android.uiCompose.shared.userCommonList.ContactItemKt;
import cu.todus.android.utils.ColorGenerator;
import cu.todus.android.utils.DateFormatter;
import cu.z17.views.label.Z17LabelKt;
import cu.z17.views.loader.Z17SimpleCircleLoaderKt;
import cu.z17.views.picture.Z17PictureAvatarKt;
import java.util.Date;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.z0;
import org.jivesoftware.smackx.xhtmlim.XHTMLText;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a)\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b\u001aE\u0010\u0012\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00002\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u0010H\u0007¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u001f\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\rH\u0007¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u001f\u0010\u0016\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\u0016\u0010\u0018\u001aE\u0010\u001b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u00192\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u0010H\u0007¢\u0006\u0004\b\u001b\u0010\u001c\u001a'\u0010\u001d\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0015\u001a\u00020\rH\u0007¢\u0006\u0004\b\u001d\u0010\u001e¨\u0006#²\u0006\f\u0010\u001a\u001a\u00020\u001f8\nX\u008a\u0084\u0002²\u0006\f\u0010!\u001a\u00020 8\nX\u008a\u0084\u0002²\u0006\f\u0010\"\u001a\u00020 8\nX\u008a\u0084\u0002"}, d2 = {"", Room.COLUMN_LAST_MSG, "Landroidx/navigation/NavHostController;", "navHostController", "Lcu/todus/android/uiCompose/main/screen/chat/details/MsgDetailsDialogViewModel;", "viewModel", "Lua/k0;", "MsgDetailsDialog", "(Ljava/lang/String;Landroidx/navigation/NavHostController;Lcu/todus/android/uiCompose/main/screen/chat/details/MsgDetailsDialogViewModel;Landroidx/compose/runtime/Composer;II)V", "Landroidx/compose/ui/Modifier;", "modifier", XHTMLText.IMG, "name", "", "createdAt", "reaction", "Lkotlin/Function0;", "onClick", "MsgReactionItem", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Llb/a;Landroidx/compose/runtime/Composer;I)V", AppMeasurementSdk.ConditionalUserProperty.VALUE, "time", "ReactionText", "(Ljava/lang/String;JLandroidx/compose/runtime/Composer;I)V", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;Landroidx/compose/runtime/Composer;I)V", "", "state", "MsgMarkerItem", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;Ljava/lang/String;JILlb/a;Landroidx/compose/runtime/Composer;I)V", "MarkerText", "(Landroidx/compose/ui/Modifier;IJLandroidx/compose/runtime/Composer;I)V", "Lcu/todus/android/uiCompose/main/screen/chat/details/MsgDetailsDialogState;", "", "showReactionLabel", "showMarkersLabel", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class MsgDetailsDialogKt {
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void MarkerText(final Modifier modifier, final int i10, final long j10, Composer composer, final int i11) {
        int i12;
        Composer composer2;
        kotlin.jvm.internal.y.i(modifier, "modifier");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1725132289);
        if ((i11 & 6) == 0) {
            i12 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i11;
        } else {
            i12 = i11;
        }
        if ((i11 & 48) == 0) {
            i12 |= composerStartRestartGroup.changed(i10) ? 32 : 16;
        }
        if ((i11 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i12 |= composerStartRestartGroup.changed(j10) ? 256 : 128;
        }
        if (composerStartRestartGroup.shouldExecute((i12 & 147) != 146, i12 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1725132289, i12, -1, "cu.todus.android.uiCompose.main.screen.chat.details.MarkerText (MsgDetailsDialog.kt:457)");
            }
            Modifier modifierM1729paddingqDBjuR0$default = PaddingKt.m1729paddingqDBjuR0$default(modifier, Dp.m8823constructorimpl(10), 0.0f, 0.0f, 0.0f, 14, null);
            composerStartRestartGroup.startReplaceGroup(5251497);
            AnnotatedString.Builder builder = new AnnotatedString.Builder(0, 1, null);
            composerStartRestartGroup.startReplaceGroup(5252478);
            int iPushStyle = builder.pushStyle(new SpanStyle(0L, TextUnitKt.getSp(10), (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65533, (kotlin.jvm.internal.p) null));
            try {
                builder.append(" ");
                builder.append(MsgStatusKt.createTime(j10, (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext())));
                builder.append(" ");
                ua.k0 k0Var = ua.k0.f43947a;
                builder.pop(iPushStyle);
                composerStartRestartGroup.endReplaceGroup();
                String strCreateStatus = MsgStatusKt.createStatus(i10);
                if (strCreateStatus != null) {
                    InlineTextContentKt.appendInlineContent$default(builder, strCreateStatus, null, 2, null);
                }
                AnnotatedString annotatedString = builder.toAnnotatedString();
                composerStartRestartGroup.endReplaceGroup();
                TextStyle textStyleM8271copyp1EtxEg$default = TextStyle.m8271copyp1EtxEg$default(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyMedium(), 0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, TextAlign.INSTANCE.m8693getEnde0LSkKk(), 0, 0L, null, null, null, 0, 0, null, 16744447, null);
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = ReactionsRepository.INSTANCE.getInstance().m9802inlineContentR2X_6o(TextUnitKt.getSp(20));
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composer2 = composerStartRestartGroup;
                Z17LabelKt.m10261Z17Label3f6hBDE(modifierM1729paddingqDBjuR0$default, annotatedString, (Map) objRememberedValue, textStyleM8271copyp1EtxEg$default, 0L, 0, 0, composer2, 0, 112);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } catch (Throwable th2) {
                builder.pop(iPushStyle);
                throw th2;
            }
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.details.u
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return MsgDetailsDialogKt.MarkerText$lambda$2(modifier, i10, j10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 MarkerText$lambda$2(Modifier modifier, int i10, long j10, int i11, Composer composer, int i12) {
        MarkerText(modifier, i10, j10, composer, RecomposeScopeImplKt.updateChangedFlags(i11 | 1));
        return ua.k0.f43947a;
    }

    /* JADX WARN: Code duplicated, block: B:103:0x032d  */
    /* JADX WARN: Code duplicated, block: B:105:0x0333  */
    /* JADX WARN: Code duplicated, block: B:112:0x0340  */
    /* JADX WARN: Code duplicated, block: B:115:0x034a  */
    /* JADX WARN: Code duplicated, block: B:117:0x0352  */
    /* JADX WARN: Code duplicated, block: B:120:0x036a  */
    /* JADX WARN: Code duplicated, block: B:27:0x0056  */
    /* JADX WARN: Code duplicated, block: B:58:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:61:0x0148  */
    /* JADX WARN: Code duplicated, block: B:64:0x0154  */
    /* JADX WARN: Code duplicated, block: B:65:0x0158  */
    /* JADX WARN: Code duplicated, block: B:68:0x01ab  */
    /* JADX WARN: Code duplicated, block: B:70:0x01b5  */
    /* JADX WARN: Code duplicated, block: B:95:0x02cc  */
    /* JADX WARN: Code duplicated, block: B:98:0x02d8  */
    /* JADX WARN: Code duplicated, block: B:99:0x02dc  */
    /* JADX WARN: Multi-variable type inference failed */
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
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void MsgDetailsDialog(String msgId, final NavHostController navHostController, MsgDetailsDialogViewModel msgDetailsDialogViewModel, Composer composer, final int i10, final int i11) {
        int i12;
        String str;
        final MsgDetailsDialogViewModel msgDetailsDialogViewModel2;
        int i13;
        String str2;
        MsgDetailsDialogViewModel msgDetailsDialogViewModel3;
        int i14;
        Modifier.Companion companion;
        Alignment.Companion companion2;
        ComposeUiNode.Companion companion3;
        lb.a constructor;
        int i15;
        final State stateCollectAsStateWithLifecycle;
        boolean z10;
        int i16;
        lb.a constructor2;
        int i17;
        boolean z11;
        MsgDetailsDialogViewModel msgDetailsDialogViewModel4;
        int i18;
        boolean z12;
        boolean z13;
        Object objRememberedValue;
        Composer composer2;
        final MsgDetailsDialogViewModel msgDetailsDialogViewModel5;
        int i19;
        MsgDetailsDialogViewModel msgDetailsDialogViewModel6 = msgDetailsDialogViewModel;
        kotlin.jvm.internal.y.i(msgId, "msgId");
        kotlin.jvm.internal.y.i(navHostController, "navHostController");
        Composer composerStartRestartGroup = composer.startRestartGroup(-2019547504);
        if ((i10 & 6) == 0) {
            i12 = (composerStartRestartGroup.changed(msgId) ? 4 : 2) | i10;
        } else {
            i12 = i10;
        }
        if ((i10 & 48) == 0) {
            i12 |= composerStartRestartGroup.changedInstance(navHostController) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            if ((i11 & 4) != 0) {
                i19 = 128;
            } else {
                if ((i10 & 512) == 0 ? composerStartRestartGroup.changed(msgDetailsDialogViewModel6) : composerStartRestartGroup.changedInstance(msgDetailsDialogViewModel6)) {
                    i19 = 256;
                } else {
                    i19 = 128;
                }
            }
            i12 |= i19;
        }
        int i20 = i12;
        if (composerStartRestartGroup.shouldExecute((i20 & 147) != 146, i20 & 1)) {
            composerStartRestartGroup.startDefaults();
            if ((i10 & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                if ((i11 & 4) != 0) {
                    int i21 = (i20 << 3) & 112;
                    ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composerStartRestartGroup, 6);
                    if (current == null) {
                        throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                    }
                    i13 = 0;
                    str2 = msgId;
                    msgDetailsDialogViewModel6 = (MsgDetailsDialogViewModel) ViewModelKt.viewModel(z0.b(MsgDetailsDialogViewModel.class), current, msgId, (ViewModelProvider.Factory) null, current instanceof HasDefaultViewModelProviderFactory ? ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras() : CreationExtras.Empty.INSTANCE, composerStartRestartGroup, (i21 << 3) & 896, 0);
                    i20 &= -897;
                }
                int i22 = i20;
                msgDetailsDialogViewModel3 = msgDetailsDialogViewModel6;
                i14 = i22;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2019547504, i14, -1, "cu.todus.android.uiCompose.main.screen.chat.details.MsgDetailsDialog (MsgDetailsDialog.kt:68)");
                }
                companion = Modifier.INSTANCE;
                Modifier modifierM1727paddingVpY3zN4$default = PaddingKt.m1727paddingVpY3zN4$default(BackgroundKt.m1205backgroundbw27NRU$default(SizeKt.fillMaxSize$default(companion, 0.0f, 1, null), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground(), null, 2, null), Dp.m8823constructorimpl(20), 0.0f, 2, null);
                Arrangement.Vertical top = Arrangement.INSTANCE.getTop();
                companion2 = Alignment.INSTANCE;
                MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(top, companion2.getStart(), composerStartRestartGroup, i13);
                int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, i13));
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1727paddingVpY3zN4$default);
                companion3 = ComposeUiNode.INSTANCE;
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
                Composer composerM5176constructorimpl = Updater.m5176constructorimpl(composerStartRestartGroup);
                Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyColumnMeasurePolicy, companion3.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
                Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion3.getSetCompositeKeyHash());
                Updater.m5182reconcileimpl(composerM5176constructorimpl, companion3.getApplyOnDeactivatedNodeAssertion());
                Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion3.getSetModifier());
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                i15 = i14;
                stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(msgDetailsDialogViewModel3.getDetailsState(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composerStartRestartGroup, 0, 7);
                if (!MsgDetailsDialog$lambda$0$0(stateCollectAsStateWithLifecycle).isLoading() || MsgDetailsDialog$lambda$0$0(stateCollectAsStateWithLifecycle).getData() == null) {
                    composerStartRestartGroup = composerStartRestartGroup;
                    str = str2;
                    boolean z14 = i13;
                    MsgDetailsDialogViewModel msgDetailsDialogViewModel7 = msgDetailsDialogViewModel3;
                    z10 = true;
                    i16 = i15;
                    composerStartRestartGroup.startReplaceGroup(1536640994);
                    Modifier modifierM1769size3ABfNKs = SizeKt.m1769size3ABfNKs(companion, Dp.m8823constructorimpl(200));
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion2.getCenter(), z14);
                    int iA2 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, z14 ? 1 : 0));
                    CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1769size3ABfNKs);
                    constructor2 = companion3.getConstructor();
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
                    Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy, companion3.getSetMeasurePolicy());
                    Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
                    Updater.m5180initimpl(composerM5176constructorimpl2, Integer.valueOf(iA2), companion3.getSetCompositeKeyHash());
                    Updater.m5182reconcileimpl(composerM5176constructorimpl2, companion3.getApplyOnDeactivatedNodeAssertion());
                    Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier2, companion3.getSetModifier());
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                    i17 = 256;
                    z11 = z14 ? 1 : 0;
                    msgDetailsDialogViewModel4 = msgDetailsDialogViewModel7;
                    i18 = 4;
                    Z17SimpleCircleLoaderKt.m10265Z17SimpleCircleLoaderZij2fk(null, 0.0f, 0.0f, 0L, composerStartRestartGroup, 0, 15);
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(1537078869);
                    final LazyPagingItems lazyPagingItemsCollectAsLazyPagingItems = LazyPagingItemsKt.collectAsLazyPagingItems(msgDetailsDialogViewModel3.reactionsFromMsg(str2), null, composerStartRestartGroup, i13, 1);
                    final LazyPagingItems lazyPagingItemsCollectAsLazyPagingItems2 = LazyPagingItemsKt.collectAsLazyPagingItems(msgDetailsDialogViewModel3.markersFromMsg(str2), null, composerStartRestartGroup, i13, 1);
                    LazyListState lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(i13, i13, composerStartRestartGroup, i13, 3);
                    Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    Composer.Companion companion4 = Composer.INSTANCE;
                    if (objRememberedValue2 == companion4.getEmpty()) {
                        objRememberedValue2 = SnapshotStateKt.derivedStateOf(new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.details.v
                            @Override // lb.a
                            public final Object invoke() {
                                return Boolean.valueOf(MsgDetailsDialogKt.MsgDetailsDialog$lambda$0$2$0(lazyPagingItemsCollectAsLazyPagingItems));
                            }
                        });
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    final State state = (State) objRememberedValue2;
                    Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue3 == companion4.getEmpty()) {
                        objRememberedValue3 = SnapshotStateKt.derivedStateOf(new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.details.w
                            @Override // lb.a
                            public final Object invoke() {
                                return Boolean.valueOf(MsgDetailsDialogKt.MsgDetailsDialog$lambda$0$4$0(lazyPagingItemsCollectAsLazyPagingItems2));
                            }
                        });
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    final State state2 = (State) objRememberedValue3;
                    Modifier modifierA = androidx.compose.foundation.layout.x.a(columnScopeInstance, companion, 1.0f, false, 2, null);
                    i16 = i15;
                    boolean zChanged = composerStartRestartGroup.changed(stateCollectAsStateWithLifecycle) | ((((i16 & 896) ^ RendererCapabilities.DECODER_SUPPORT_MASK) > 256 && composerStartRestartGroup.changedInstance(msgDetailsDialogViewModel3)) || (i16 & RendererCapabilities.DECODER_SUPPORT_MASK) == 256) | composerStartRestartGroup.changedInstance(navHostController) | composerStartRestartGroup.changedInstance(lazyPagingItemsCollectAsLazyPagingItems) | composerStartRestartGroup.changedInstance(lazyPagingItemsCollectAsLazyPagingItems2);
                    Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (zChanged || objRememberedValue4 == companion4.getEmpty()) {
                        composer2 = composerStartRestartGroup;
                        msgDetailsDialogViewModel5 = msgDetailsDialogViewModel3;
                        str = msgId;
                        Function1 function1 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.details.x
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return MsgDetailsDialogKt.MsgDetailsDialog$lambda$0$6$0(lazyPagingItemsCollectAsLazyPagingItems, lazyPagingItemsCollectAsLazyPagingItems2, msgDetailsDialogViewModel5, stateCollectAsStateWithLifecycle, navHostController, state, state2, (LazyListScope) obj);
                            }
                        };
                        composer2.updateRememberedValue(function1);
                        objRememberedValue4 = function1;
                    } else {
                        composer2 = composerStartRestartGroup;
                        str = str2;
                        msgDetailsDialogViewModel5 = msgDetailsDialogViewModel3;
                    }
                    Composer composer3 = composer2;
                    z10 = true;
                    LazyDslKt.LazyColumn(modifierA, lazyListStateRememberLazyListState, null, false, null, null, null, false, null, (Function1) objRememberedValue4, composer3, 0, TypedValues.PositionType.TYPE_CURVE_FIT);
                    composerStartRestartGroup = composer3;
                    composerStartRestartGroup.endReplaceGroup();
                    i17 = 256;
                    i18 = 4;
                    z11 = false;
                    msgDetailsDialogViewModel4 = msgDetailsDialogViewModel5;
                }
                ua.k0 k0Var = ua.k0.f43947a;
                boolean z15 = ((((i16 & 896) ^ RendererCapabilities.DECODER_SUPPORT_MASK) > i17 || !composerStartRestartGroup.changedInstance(msgDetailsDialogViewModel4)) && (i16 & RendererCapabilities.DECODER_SUPPORT_MASK) != i17) ? z11 : z10 ? 1 : 0;
                z12 = z10;
                if ((i16 & 14) != i18) {
                    z12 = z11;
                }
                z13 = z15 | z12;
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (z13 == 0 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new MsgDetailsDialogKt$MsgDetailsDialog$1$3$1(msgDetailsDialogViewModel4, str, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                EffectsKt.LaunchedEffect(k0Var, (Function2) objRememberedValue, composerStartRestartGroup, 6);
                composerStartRestartGroup.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                msgDetailsDialogViewModel2 = msgDetailsDialogViewModel4;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i11 & 4) != 0) {
                    int i23 = i20 & (-897);
                    msgDetailsDialogViewModel3 = msgDetailsDialogViewModel6;
                    i14 = i23;
                    str2 = msgId;
                    i13 = 0;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2019547504, i14, -1, "cu.todus.android.uiCompose.main.screen.chat.details.MsgDetailsDialog (MsgDetailsDialog.kt:68)");
                }
                companion = Modifier.INSTANCE;
                Modifier modifierM1727paddingVpY3zN4$default2 = PaddingKt.m1727paddingVpY3zN4$default(BackgroundKt.m1205backgroundbw27NRU$default(SizeKt.fillMaxSize$default(companion, 0.0f, 1, null), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground(), null, 2, null), Dp.m8823constructorimpl(20), 0.0f, 2, null);
                Arrangement.Vertical top2 = Arrangement.INSTANCE.getTop();
                companion2 = Alignment.INSTANCE;
                MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(top2, companion2.getStart(), composerStartRestartGroup, i13);
                int iA3 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, i13));
                CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1727paddingVpY3zN4$default2);
                companion3 = ComposeUiNode.INSTANCE;
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
                Composer composerM5176constructorimpl3 = Updater.m5176constructorimpl(composerStartRestartGroup);
                Updater.m5184setimpl(composerM5176constructorimpl3, measurePolicyColumnMeasurePolicy2, companion3.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl3, currentCompositionLocalMap3, companion3.getSetResolvedCompositionLocals());
                Updater.m5180initimpl(composerM5176constructorimpl3, Integer.valueOf(iA3), companion3.getSetCompositeKeyHash());
                Updater.m5182reconcileimpl(composerM5176constructorimpl3, companion3.getApplyOnDeactivatedNodeAssertion());
                Updater.m5184setimpl(composerM5176constructorimpl3, modifierMaterializeModifier3, companion3.getSetModifier());
                ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
                i15 = i14;
                stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(msgDetailsDialogViewModel3.getDetailsState(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composerStartRestartGroup, 0, 7);
                if (MsgDetailsDialog$lambda$0$0(stateCollectAsStateWithLifecycle).isLoading()) {
                    composerStartRestartGroup = composerStartRestartGroup;
                    str = str2;
                    boolean z16 = i13;
                    MsgDetailsDialogViewModel msgDetailsDialogViewModel8 = msgDetailsDialogViewModel3;
                    z10 = true;
                    i16 = i15;
                    composerStartRestartGroup.startReplaceGroup(1536640994);
                    Modifier modifierM1769size3ABfNKs2 = SizeKt.m1769size3ABfNKs(companion, Dp.m8823constructorimpl(200));
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(companion2.getCenter(), z16);
                    int iA4 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, z16 ? 1 : 0));
                    CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1769size3ABfNKs2);
                    constructor2 = companion3.getConstructor();
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
                    Updater.m5184setimpl(composerM5176constructorimpl4, measurePolicyMaybeCachedBoxMeasurePolicy2, companion3.getSetMeasurePolicy());
                    Updater.m5184setimpl(composerM5176constructorimpl4, currentCompositionLocalMap4, companion3.getSetResolvedCompositionLocals());
                    Updater.m5180initimpl(composerM5176constructorimpl4, Integer.valueOf(iA4), companion3.getSetCompositeKeyHash());
                    Updater.m5182reconcileimpl(composerM5176constructorimpl4, companion3.getApplyOnDeactivatedNodeAssertion());
                    Updater.m5184setimpl(composerM5176constructorimpl4, modifierMaterializeModifier4, companion3.getSetModifier());
                    BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                    i17 = 256;
                    z11 = z16 ? 1 : 0;
                    msgDetailsDialogViewModel4 = msgDetailsDialogViewModel8;
                    i18 = 4;
                    Z17SimpleCircleLoaderKt.m10265Z17SimpleCircleLoaderZij2fk(null, 0.0f, 0.0f, 0L, composerStartRestartGroup, 0, 15);
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup = composerStartRestartGroup;
                    str = str2;
                    boolean z17 = i13;
                    MsgDetailsDialogViewModel msgDetailsDialogViewModel9 = msgDetailsDialogViewModel3;
                    z10 = true;
                    i16 = i15;
                    composerStartRestartGroup.startReplaceGroup(1536640994);
                    Modifier modifierM1769size3ABfNKs3 = SizeKt.m1769size3ABfNKs(companion, Dp.m8823constructorimpl(200));
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(companion2.getCenter(), z17);
                    int iA5 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, z17 ? 1 : 0));
                    CompositionLocalMap currentCompositionLocalMap5 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier5 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1769size3ABfNKs3);
                    constructor2 = companion3.getConstructor();
                    if (!defpackage.r.a(composerStartRestartGroup.getApplier())) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor2);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM5176constructorimpl5 = Updater.m5176constructorimpl(composerStartRestartGroup);
                    Updater.m5184setimpl(composerM5176constructorimpl5, measurePolicyMaybeCachedBoxMeasurePolicy3, companion3.getSetMeasurePolicy());
                    Updater.m5184setimpl(composerM5176constructorimpl5, currentCompositionLocalMap5, companion3.getSetResolvedCompositionLocals());
                    Updater.m5180initimpl(composerM5176constructorimpl5, Integer.valueOf(iA5), companion3.getSetCompositeKeyHash());
                    Updater.m5182reconcileimpl(composerM5176constructorimpl5, companion3.getApplyOnDeactivatedNodeAssertion());
                    Updater.m5184setimpl(composerM5176constructorimpl5, modifierMaterializeModifier5, companion3.getSetModifier());
                    BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
                    i17 = 256;
                    z11 = z17 ? 1 : 0;
                    msgDetailsDialogViewModel4 = msgDetailsDialogViewModel9;
                    i18 = 4;
                    Z17SimpleCircleLoaderKt.m10265Z17SimpleCircleLoaderZij2fk(null, 0.0f, 0.0f, 0L, composerStartRestartGroup, 0, 15);
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceGroup();
                }
                ua.k0 k0Var2 = ua.k0.f43947a;
                if (((i16 & 896) ^ RendererCapabilities.DECODER_SUPPORT_MASK) > i17) {
                }
                z12 = z10;
                if ((i16 & 14) != i18) {
                    z12 = z11;
                }
                z13 = z15 | z12;
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (z13 == 0) {
                    objRememberedValue = new MsgDetailsDialogKt$MsgDetailsDialog$1$3$1(msgDetailsDialogViewModel4, str, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new MsgDetailsDialogKt$MsgDetailsDialog$1$3$1(msgDetailsDialogViewModel4, str, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                EffectsKt.LaunchedEffect(k0Var2, (Function2) objRememberedValue, composerStartRestartGroup, 6);
                composerStartRestartGroup.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                msgDetailsDialogViewModel2 = msgDetailsDialogViewModel4;
            }
            str2 = msgId;
            i13 = 0;
            int i24 = i20;
            msgDetailsDialogViewModel3 = msgDetailsDialogViewModel6;
            i14 = i24;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2019547504, i14, -1, "cu.todus.android.uiCompose.main.screen.chat.details.MsgDetailsDialog (MsgDetailsDialog.kt:68)");
            }
            companion = Modifier.INSTANCE;
            Modifier modifierM1727paddingVpY3zN4$default3 = PaddingKt.m1727paddingVpY3zN4$default(BackgroundKt.m1205backgroundbw27NRU$default(SizeKt.fillMaxSize$default(companion, 0.0f, 1, null), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground(), null, 2, null), Dp.m8823constructorimpl(20), 0.0f, 2, null);
            Arrangement.Vertical top3 = Arrangement.INSTANCE.getTop();
            companion2 = Alignment.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy3 = ColumnKt.columnMeasurePolicy(top3, companion2.getStart(), composerStartRestartGroup, i13);
            int iA6 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, i13));
            CompositionLocalMap currentCompositionLocalMap6 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier6 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1727paddingVpY3zN4$default3);
            companion3 = ComposeUiNode.INSTANCE;
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
            Composer composerM5176constructorimpl6 = Updater.m5176constructorimpl(composerStartRestartGroup);
            Updater.m5184setimpl(composerM5176constructorimpl6, measurePolicyColumnMeasurePolicy3, companion3.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl6, currentCompositionLocalMap6, companion3.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl6, Integer.valueOf(iA6), companion3.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl6, companion3.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl6, modifierMaterializeModifier6, companion3.getSetModifier());
            ColumnScopeInstance columnScopeInstance3 = ColumnScopeInstance.INSTANCE;
            i15 = i14;
            stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(msgDetailsDialogViewModel3.getDetailsState(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composerStartRestartGroup, 0, 7);
            if (MsgDetailsDialog$lambda$0$0(stateCollectAsStateWithLifecycle).isLoading()) {
                composerStartRestartGroup = composerStartRestartGroup;
                str = str2;
                boolean z18 = i13;
                MsgDetailsDialogViewModel msgDetailsDialogViewModel10 = msgDetailsDialogViewModel3;
                z10 = true;
                i16 = i15;
                composerStartRestartGroup.startReplaceGroup(1536640994);
                Modifier modifierM1769size3ABfNKs4 = SizeKt.m1769size3ABfNKs(companion, Dp.m8823constructorimpl(200));
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy4 = BoxKt.maybeCachedBoxMeasurePolicy(companion2.getCenter(), z18);
                int iA7 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, z18 ? 1 : 0));
                CompositionLocalMap currentCompositionLocalMap7 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier7 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1769size3ABfNKs4);
                constructor2 = companion3.getConstructor();
                if (!defpackage.r.a(composerStartRestartGroup.getApplier())) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor2);
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM5176constructorimpl7 = Updater.m5176constructorimpl(composerStartRestartGroup);
                Updater.m5184setimpl(composerM5176constructorimpl7, measurePolicyMaybeCachedBoxMeasurePolicy4, companion3.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl7, currentCompositionLocalMap7, companion3.getSetResolvedCompositionLocals());
                Updater.m5180initimpl(composerM5176constructorimpl7, Integer.valueOf(iA7), companion3.getSetCompositeKeyHash());
                Updater.m5182reconcileimpl(composerM5176constructorimpl7, companion3.getApplyOnDeactivatedNodeAssertion());
                Updater.m5184setimpl(composerM5176constructorimpl7, modifierMaterializeModifier7, companion3.getSetModifier());
                BoxScopeInstance boxScopeInstance4 = BoxScopeInstance.INSTANCE;
                i17 = 256;
                z11 = z18 ? 1 : 0;
                msgDetailsDialogViewModel4 = msgDetailsDialogViewModel10;
                i18 = 4;
                Z17SimpleCircleLoaderKt.m10265Z17SimpleCircleLoaderZij2fk(null, 0.0f, 0.0f, 0L, composerStartRestartGroup, 0, 15);
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup = composerStartRestartGroup;
                str = str2;
                boolean z19 = i13;
                MsgDetailsDialogViewModel msgDetailsDialogViewModel11 = msgDetailsDialogViewModel3;
                z10 = true;
                i16 = i15;
                composerStartRestartGroup.startReplaceGroup(1536640994);
                Modifier modifierM1769size3ABfNKs5 = SizeKt.m1769size3ABfNKs(companion, Dp.m8823constructorimpl(200));
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy5 = BoxKt.maybeCachedBoxMeasurePolicy(companion2.getCenter(), z19);
                int iA8 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, z19 ? 1 : 0));
                CompositionLocalMap currentCompositionLocalMap8 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier8 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1769size3ABfNKs5);
                constructor2 = companion3.getConstructor();
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
                Updater.m5184setimpl(composerM5176constructorimpl8, measurePolicyMaybeCachedBoxMeasurePolicy5, companion3.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl8, currentCompositionLocalMap8, companion3.getSetResolvedCompositionLocals());
                Updater.m5180initimpl(composerM5176constructorimpl8, Integer.valueOf(iA8), companion3.getSetCompositeKeyHash());
                Updater.m5182reconcileimpl(composerM5176constructorimpl8, companion3.getApplyOnDeactivatedNodeAssertion());
                Updater.m5184setimpl(composerM5176constructorimpl8, modifierMaterializeModifier8, companion3.getSetModifier());
                BoxScopeInstance boxScopeInstance5 = BoxScopeInstance.INSTANCE;
                i17 = 256;
                z11 = z19 ? 1 : 0;
                msgDetailsDialogViewModel4 = msgDetailsDialogViewModel11;
                i18 = 4;
                Z17SimpleCircleLoaderKt.m10265Z17SimpleCircleLoaderZij2fk(null, 0.0f, 0.0f, 0L, composerStartRestartGroup, 0, 15);
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceGroup();
            }
            ua.k0 k0Var3 = ua.k0.f43947a;
            if (((i16 & 896) ^ RendererCapabilities.DECODER_SUPPORT_MASK) > i17) {
            }
            z12 = z10;
            if ((i16 & 14) != i18) {
                z12 = z11;
            }
            z13 = z15 | z12;
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z13 == 0) {
                objRememberedValue = new MsgDetailsDialogKt$MsgDetailsDialog$1$3$1(msgDetailsDialogViewModel4, str, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = new MsgDetailsDialogKt$MsgDetailsDialog$1$3$1(msgDetailsDialogViewModel4, str, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            EffectsKt.LaunchedEffect(k0Var3, (Function2) objRememberedValue, composerStartRestartGroup, 6);
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            msgDetailsDialogViewModel2 = msgDetailsDialogViewModel4;
        } else {
            str = msgId;
            composerStartRestartGroup.skipToGroupEnd();
            msgDetailsDialogViewModel2 = msgDetailsDialogViewModel6;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final String str3 = str;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.details.y
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return MsgDetailsDialogKt.MsgDetailsDialog$lambda$1(str3, navHostController, msgDetailsDialogViewModel2, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final MsgDetailsDialogState MsgDetailsDialog$lambda$0$0(State<MsgDetailsDialogState> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean MsgDetailsDialog$lambda$0$2$0(LazyPagingItems lazyPagingItems) {
        return lazyPagingItems.getItemCount() > 0;
    }

    private static final boolean MsgDetailsDialog$lambda$0$3(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean MsgDetailsDialog$lambda$0$4$0(LazyPagingItems lazyPagingItems) {
        return lazyPagingItems.getItemCount() > 0;
    }

    private static final boolean MsgDetailsDialog$lambda$0$5(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 MsgDetailsDialog$lambda$0$6$0(final LazyPagingItems lazyPagingItems, final LazyPagingItems lazyPagingItems2, final MsgDetailsDialogViewModel msgDetailsDialogViewModel, final State state, final NavHostController navHostController, final State state2, final State state3, LazyListScope LazyColumn) {
        kotlin.jvm.internal.y.i(LazyColumn, "$this$LazyColumn");
        LazyListScope.CC.m(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(-390026497, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.chat.details.b0
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return MsgDetailsDialogKt.MsgDetailsDialog$lambda$0$6$0$0(msgDetailsDialogViewModel, state, navHostController, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }), 3, null);
        LazyListScope.CC.m(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(-1413634890, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.chat.details.m0
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return MsgDetailsDialogKt.MsgDetailsDialog$lambda$0$6$0$1(state2, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }), 3, null);
        LazyColumn.items(lazyPagingItems.getItemCount(), LazyFoundationExtensionsKt.itemKey(lazyPagingItems, new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.details.p0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MsgDetailsDialogKt.MsgDetailsDialog$lambda$0$6$0$2((ReactionWithPartner) obj);
            }
        }), LazyFoundationExtensionsKt.itemContentType(lazyPagingItems, new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.details.q0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MsgDetailsDialogKt.MsgDetailsDialog$lambda$0$6$0$3((ReactionWithPartner) obj);
            }
        }), ComposableLambdaKt.composableLambdaInstance(-853454648, true, new lb.o() { // from class: cu.todus.android.uiCompose.main.screen.chat.details.r0
            @Override // lb.o
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return MsgDetailsDialogKt.MsgDetailsDialog$lambda$0$6$0$4(lazyPagingItems, navHostController, (LazyItemScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
            }
        }));
        LazyListScope.CC.m(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(1462008375, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.chat.details.s0
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return MsgDetailsDialogKt.MsgDetailsDialog$lambda$0$6$0$5(state3, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }), 3, null);
        LazyColumn.items(lazyPagingItems2.getItemCount(), LazyFoundationExtensionsKt.itemKey(lazyPagingItems2, new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.details.t0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MsgDetailsDialogKt.MsgDetailsDialog$lambda$0$6$0$6((MarkerWithPartner) obj);
            }
        }), LazyFoundationExtensionsKt.itemContentType(lazyPagingItems2, new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.details.u0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MsgDetailsDialogKt.MsgDetailsDialog$lambda$0$6$0$7((MarkerWithPartner) obj);
            }
        }), ComposableLambdaKt.composableLambdaInstance(-91489217, true, new lb.o() { // from class: cu.todus.android.uiCompose.main.screen.chat.details.v0
            @Override // lb.o
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return MsgDetailsDialogKt.MsgDetailsDialog$lambda$0$6$0$8(lazyPagingItems2, navHostController, (LazyItemScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
            }
        }));
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 MsgDetailsDialog$lambda$0$6$0$0(MsgDetailsDialogViewModel msgDetailsDialogViewModel, final State state, final NavHostController navHostController, LazyItemScope item, Composer composer, int i10) {
        String picture;
        String senderAlias;
        Message message;
        kotlin.jvm.internal.y.i(item, "$this$item");
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-390026497, i10, -1, "cu.todus.android.uiCompose.main.screen.chat.details.MsgDetailsDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous> (MsgDetailsDialog.kt:104)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            float f10 = 10;
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(PaddingKt.m1727paddingVpY3zN4$default(companion, Dp.m8823constructorimpl(f10), 0.0f, 2, null), 0.0f, 1, null);
            DateFormatter.Companion companion2 = DateFormatter.INSTANCE;
            MessageWithPartnerWithRoomWithReactions data = MsgDetailsDialog$lambda$0$0(state).getData();
            kotlin.jvm.internal.y.f(data);
            String str = companion2.format(new Date(data.getMessage().getCreateAt()), DateFormatter.Template.STRING_DAY_MONTH_YEAR);
            MaterialTheme materialTheme = MaterialTheme.INSTANCE;
            int i11 = MaterialTheme.$stable;
            Z17LabelKt.m10262Z17LabelfWhpE4E(modifierFillMaxWidth$default, str, TextStyle.m8271copyp1EtxEg$default(materialTheme.getTypography(composer, i11).getTitleSmall(), 0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, TextAlign.INSTANCE.m8692getCentere0LSkKk(), 0, 0L, null, null, null, 0, 0, null, 16744447, null), 0L, 0, 0, composer, 6, 56);
            float f11 = 5;
            SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion, Dp.m8823constructorimpl(f11)), composer, 6);
            Z17LabelKt.m10262Z17LabelfWhpE4E(PaddingKt.m1727paddingVpY3zN4$default(companion, Dp.m8823constructorimpl(f10), 0.0f, 2, null), StringResources_androidKt.stringResource(R.string.author, composer, 0), materialTheme.getTypography(composer, i11).getLabelMedium(), 0L, 0, 0, composer, 6, 56);
            SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion, Dp.m8823constructorimpl(f11)), composer, 6);
            MessageWithPartnerWithRoomWithReactions data2 = MsgDetailsDialog$lambda$0$0(state).getData();
            kotlin.jvm.internal.y.f(data2);
            User senderUser = data2.getSenderUser();
            if (senderUser == null || (picture = senderUser.getPhotoUrl()) == null) {
                MessageWithPartnerWithRoomWithReactions data3 = MsgDetailsDialog$lambda$0$0(state).getData();
                kotlin.jvm.internal.y.f(data3);
                Room senderRoom = data3.getSenderRoom();
                picture = senderRoom != null ? senderRoom.getPicture() : "";
            }
            MessageWithPartnerWithRoomWithReactions data4 = MsgDetailsDialog$lambda$0$0(state).getData();
            if (kotlin.jvm.internal.y.d((data4 == null || (message = data4.getMessage()) == null) ? null : message.getUserSender(), msgDetailsDialogViewModel.getOwner().getNameWithDomain())) {
                composer.startReplaceGroup(-1153268122);
                senderAlias = StringResources_androidKt.stringResource(R.string.f20195me, composer, 0);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-1153264305);
                composer.endReplaceGroup();
                MessageWithPartnerWithRoomWithReactions data5 = MsgDetailsDialog$lambda$0$0(state).getData();
                kotlin.jvm.internal.y.f(data5);
                senderAlias = data5.getSenderAlias();
            }
            boolean zChanged = composer.changed(state) | composer.changedInstance(navHostController);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.details.z
                    @Override // lb.a
                    public final Object invoke() {
                        return MsgDetailsDialogKt.MsgDetailsDialog$lambda$0$6$0$0$0$0(navHostController, state);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            lb.a aVar = (lb.a) objRememberedValue;
            Object objRememberedValue2 = composer.rememberedValue();
            Composer.Companion companion3 = Composer.INSTANCE;
            if (objRememberedValue2 == companion3.getEmpty()) {
                objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.details.d0
                    @Override // lb.a
                    public final Object invoke() {
                        return ua.k0.f43947a;
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            ContactItemKt.ContactItem(picture, senderAlias, "", aVar, (lb.a) objRememberedValue2, composer, 24960, 0);
            SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion, Dp.m8823constructorimpl(f10)), composer, 6);
            Z17LabelKt.m10262Z17LabelfWhpE4E(SizeKt.fillMaxWidth$default(PaddingKt.m1727paddingVpY3zN4$default(companion, Dp.m8823constructorimpl(f10), 0.0f, 2, null), 0.0f, 1, null), StringResources_androidKt.stringResource(R.string.message, composer, 0), materialTheme.getTypography(composer, i11).getLabelMedium(), 0L, 0, 0, composer, 6, 56);
            SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion, Dp.m8823constructorimpl(f10)), composer, 6);
            Modifier modifierFillMaxWidth$default2 = SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null);
            MessageWithPartnerWithRoomWithReactions data6 = MsgDetailsDialog$lambda$0$0(state).getData();
            kotlin.jvm.internal.y.f(data6);
            Message message2 = data6.getMessage();
            MessageWithPartnerWithRoomWithReactions data7 = MsgDetailsDialog$lambda$0$0(state).getData();
            kotlin.jvm.internal.y.f(data7);
            User senderUser2 = data7.getSenderUser();
            MessageWithPartnerWithRoomWithReactions data8 = MsgDetailsDialog$lambda$0$0(state).getData();
            kotlin.jvm.internal.y.f(data8);
            Contact senderContact = data8.getSenderContact();
            MessageWithPartnerWithRoomWithReactions data9 = MsgDetailsDialog$lambda$0$0(state).getData();
            kotlin.jvm.internal.y.f(data9);
            List<Attachment> attachments = data9.getAttachments();
            MessageWithPartnerWithRoomWithReactions data10 = MsgDetailsDialog$lambda$0$0(state).getData();
            kotlin.jvm.internal.y.f(data10);
            MessageWithPartnerWithReactions messageWithPartnerWithReactions = new MessageWithPartnerWithReactions(message2, senderUser2, senderContact, attachments, data10.getReactions());
            String nameWithDomain = msgDetailsDialogViewModel.getOwner().getNameWithDomain();
            String password = msgDetailsDialogViewModel.getOwner().getPassword();
            Object objRememberedValue3 = composer.rememberedValue();
            if (objRememberedValue3 == companion3.getEmpty()) {
                objRememberedValue3 = new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.details.e0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return MsgDetailsDialogKt.MsgDetailsDialog$lambda$0$6$0$0$2$0((MessageAction) obj, ((Integer) obj2).intValue());
                    }
                };
                composer.updateRememberedValue(objRememberedValue3);
            }
            Function2 function2 = (Function2) objRememberedValue3;
            Object objRememberedValue4 = composer.rememberedValue();
            if (objRememberedValue4 == companion3.getEmpty()) {
                objRememberedValue4 = new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.details.f0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return MsgDetailsDialogKt.MsgDetailsDialog$lambda$0$6$0$0$3$0((MessageWithPartnerWithReactions) obj, ((Integer) obj2).intValue());
                    }
                };
                composer.updateRememberedValue(objRememberedValue4);
            }
            Function2 function3 = (Function2) objRememberedValue4;
            Object objRememberedValue5 = composer.rememberedValue();
            if (objRememberedValue5 == companion3.getEmpty()) {
                objRememberedValue5 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.details.g0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return MsgDetailsDialogKt.MsgDetailsDialog$lambda$0$6$0$0$4$0((String) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue5);
            }
            Function1 function1 = (Function1) objRememberedValue5;
            Object objRememberedValue6 = composer.rememberedValue();
            if (objRememberedValue6 == companion3.getEmpty()) {
                objRememberedValue6 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.details.h0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return MsgDetailsDialogKt.MsgDetailsDialog$lambda$0$6$0$0$5$0(((Integer) obj).intValue());
                    }
                };
                composer.updateRememberedValue(objRememberedValue6);
            }
            Function1 function4 = (Function1) objRememberedValue6;
            Object objRememberedValue7 = composer.rememberedValue();
            if (objRememberedValue7 == companion3.getEmpty()) {
                objRememberedValue7 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.details.i0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return MsgDetailsDialogKt.MsgDetailsDialog$lambda$0$6$0$0$6$0((Message) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue7);
            }
            Function1 function5 = (Function1) objRememberedValue7;
            Object objRememberedValue8 = composer.rememberedValue();
            if (objRememberedValue8 == companion3.getEmpty()) {
                objRememberedValue8 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.details.j0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return MsgDetailsDialogKt.MsgDetailsDialog$lambda$0$6$0$0$7$0((String) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue8);
            }
            Function1 function6 = (Function1) objRememberedValue8;
            Object objRememberedValue9 = composer.rememberedValue();
            if (objRememberedValue9 == companion3.getEmpty()) {
                objRememberedValue9 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.details.k0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return MsgDetailsDialogKt.MsgDetailsDialog$lambda$0$6$0$0$8$0((String) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue9);
            }
            Function1 function7 = (Function1) objRememberedValue9;
            Object objRememberedValue10 = composer.rememberedValue();
            if (objRememberedValue10 == companion3.getEmpty()) {
                objRememberedValue10 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.details.l0
                    @Override // lb.a
                    public final Object invoke() {
                        return ua.k0.f43947a;
                    }
                };
                composer.updateRememberedValue(objRememberedValue10);
            }
            lb.a aVar2 = (lb.a) objRememberedValue10;
            Object objRememberedValue11 = composer.rememberedValue();
            if (objRememberedValue11 == companion3.getEmpty()) {
                objRememberedValue11 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.details.a0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return MsgDetailsDialogKt.MsgDetailsDialog$lambda$0$6$0$0$10$0((MessageWithPartnerWithReactions) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue11);
            }
            Function1 function8 = (Function1) objRememberedValue11;
            Object objRememberedValue12 = composer.rememberedValue();
            if (objRememberedValue12 == companion3.getEmpty()) {
                objRememberedValue12 = new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.details.c0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return MsgDetailsDialogKt.MsgDetailsDialog$lambda$0$6$0$0$11$0((MessageAction) obj, (String) obj2);
                    }
                };
                composer.updateRememberedValue(objRememberedValue12);
            }
            MessageItemKt.MessageItem(modifierFillMaxWidth$default2, messageWithPartnerWithReactions, nameWithDomain, password, false, false, false, function2, function3, function1, function4, function5, function6, false, function7, aVar2, false, function8, (Function2) objRememberedValue12, composer, 920346630, 115043766, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 MsgDetailsDialog$lambda$0$6$0$0$0$0(NavHostController navHostController, State state) {
        MessageWithPartnerWithRoomWithReactions data = MsgDetailsDialog$lambda$0$0(state).getData();
        kotlin.jvm.internal.y.f(data);
        ChatParams chatParams = new ChatParams(data.getMessage().getUserSender(), 0, null, 0, 12, null);
        NavLinks navLinks = NavLinks.INSTANCE;
        int type = chatParams.getType();
        String strT = MainModule.INSTANCE.getInstance().getGson().t(chatParams);
        kotlin.jvm.internal.y.h(strT, "toJson(...)");
        NavController.navigate$default((NavController) navHostController, navLinks.goChat(type, strT), (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 MsgDetailsDialog$lambda$0$6$0$0$10$0(MessageWithPartnerWithReactions it) {
        kotlin.jvm.internal.y.i(it, "it");
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 MsgDetailsDialog$lambda$0$6$0$0$11$0(MessageAction messageAction, String value) {
        kotlin.jvm.internal.y.i(messageAction, "messageAction");
        kotlin.jvm.internal.y.i(value, "value");
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 MsgDetailsDialog$lambda$0$6$0$0$2$0(MessageAction messageAction, int i10) {
        kotlin.jvm.internal.y.i(messageAction, "messageAction");
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 MsgDetailsDialog$lambda$0$6$0$0$3$0(MessageWithPartnerWithReactions a10, int i10) {
        kotlin.jvm.internal.y.i(a10, "a1");
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 MsgDetailsDialog$lambda$0$6$0$0$4$0(String it) {
        kotlin.jvm.internal.y.i(it, "it");
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 MsgDetailsDialog$lambda$0$6$0$0$5$0(int i10) {
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 MsgDetailsDialog$lambda$0$6$0$0$6$0(Message it) {
        kotlin.jvm.internal.y.i(it, "it");
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 MsgDetailsDialog$lambda$0$6$0$0$7$0(String it) {
        kotlin.jvm.internal.y.i(it, "it");
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 MsgDetailsDialog$lambda$0$6$0$0$8$0(String it) {
        kotlin.jvm.internal.y.i(it, "it");
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 MsgDetailsDialog$lambda$0$6$0$1(State state, LazyItemScope item, Composer composer, int i10) {
        kotlin.jvm.internal.y.i(item, "$this$item");
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1413634890, i10, -1, "cu.todus.android.uiCompose.main.screen.chat.details.MsgDetailsDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous> (MsgDetailsDialog.kt:206)");
            }
            if (MsgDetailsDialog$lambda$0$3(state)) {
                composer.startReplaceGroup(-1293461281);
                Z17LabelKt.m10262Z17LabelfWhpE4E(PaddingKt.m1725padding3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(10)), StringResources_androidKt.stringResource(R.string.reactions, composer, 0), MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getLabelMedium(), 0L, 0, 0, composer, 6, 56);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-1442339380);
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
    public static final Object MsgDetailsDialog$lambda$0$6$0$2(ReactionWithPartner r10) {
        kotlin.jvm.internal.y.i(r10, "r");
        return r10.getReaction().getId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object MsgDetailsDialog$lambda$0$6$0$3(ReactionWithPartner i10) {
        kotlin.jvm.internal.y.i(i10, "i");
        return "item";
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 MsgDetailsDialog$lambda$0$6$0$4(LazyPagingItems lazyPagingItems, final NavHostController navHostController, LazyItemScope items, int i10, Composer composer, int i11) {
        int i12;
        kotlin.jvm.internal.y.i(items, "$this$items");
        if ((i11 & 6) == 0) {
            i12 = i11 | (composer.changed(items) ? 4 : 2);
        } else {
            i12 = i11;
        }
        if ((i11 & 48) == 0) {
            i12 |= composer.changed(i10) ? 32 : 16;
        }
        if (composer.shouldExecute((i12 & 147) != 146, i12 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-853454648, i12, -1, "cu.todus.android.uiCompose.main.screen.chat.details.MsgDetailsDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous> (MsgDetailsDialog.kt:219)");
            }
            final ReactionWithPartner reactionWithPartner = (ReactionWithPartner) lazyPagingItems.get(i10);
            if (reactionWithPartner == null || le.d0.q0(reactionWithPartner.getReaction().getReactionContent())) {
                composer.startReplaceGroup(940364538);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(939179904);
                Modifier modifierC = androidx.compose.foundation.lazy.g.c(items, Modifier.INSTANCE, null, null, null, 2, null);
                String picture = reactionWithPartner.getPicture();
                String name = reactionWithPartner.getName();
                long createdAt = reactionWithPartner.getReaction().getCreatedAt();
                String reactionContent = reactionWithPartner.getReaction().getReactionContent();
                boolean zChanged = composer.changed(reactionWithPartner) | composer.changedInstance(navHostController);
                Object objRememberedValue = composer.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.details.t
                        @Override // lb.a
                        public final Object invoke() {
                            return MsgDetailsDialogKt.MsgDetailsDialog$lambda$0$6$0$4$0$0(reactionWithPartner, navHostController);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                MsgReactionItem(modifierC, picture, name, createdAt, reactionContent, (lb.a) objRememberedValue, composer, 0);
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
    public static final ua.k0 MsgDetailsDialog$lambda$0$6$0$4$0$0(ReactionWithPartner reactionWithPartner, NavHostController navHostController) {
        String uid;
        User user = reactionWithPartner.getUser();
        if (user != null && (uid = user.getUid()) != null) {
            ChatParams chatParams = new ChatParams(uid, 0, null, 0, 12, null);
            NavLinks navLinks = NavLinks.INSTANCE;
            int type = chatParams.getType();
            String strT = MainModule.INSTANCE.getInstance().getGson().t(chatParams);
            kotlin.jvm.internal.y.h(strT, "toJson(...)");
            NavController.navigate$default((NavController) navHostController, navLinks.goChat(type, strT), (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 MsgDetailsDialog$lambda$0$6$0$5(State state, LazyItemScope item, Composer composer, int i10) {
        kotlin.jvm.internal.y.i(item, "$this$item");
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1462008375, i10, -1, "cu.todus.android.uiCompose.main.screen.chat.details.MsgDetailsDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous> (MsgDetailsDialog.kt:250)");
            }
            if (MsgDetailsDialog$lambda$0$5(state)) {
                composer.startReplaceGroup(535745020);
                Z17LabelKt.m10262Z17LabelfWhpE4E(PaddingKt.m1725padding3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(10)), StringResources_androidKt.stringResource(R.string.state, composer, 0), MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getLabelMedium(), 0L, 0, 0, composer, 6, 56);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-571522741);
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
    public static final Object MsgDetailsDialog$lambda$0$6$0$6(MarkerWithPartner m10) {
        kotlin.jvm.internal.y.i(m10, "m");
        return m10.getId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object MsgDetailsDialog$lambda$0$6$0$7(MarkerWithPartner i10) {
        kotlin.jvm.internal.y.i(i10, "i");
        return "item2";
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 MsgDetailsDialog$lambda$0$6$0$8(LazyPagingItems lazyPagingItems, final NavHostController navHostController, LazyItemScope items, int i10, Composer composer, int i11) {
        int i12;
        kotlin.jvm.internal.y.i(items, "$this$items");
        if ((i11 & 6) == 0) {
            i12 = i11 | (composer.changed(items) ? 4 : 2);
        } else {
            i12 = i11;
        }
        if ((i11 & 48) == 0) {
            i12 |= composer.changed(i10) ? 32 : 16;
        }
        if (composer.shouldExecute((i12 & 147) != 146, i12 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-91489217, i12, -1, "cu.todus.android.uiCompose.main.screen.chat.details.MsgDetailsDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous> (MsgDetailsDialog.kt:263)");
            }
            final MarkerWithPartner markerWithPartner = (MarkerWithPartner) lazyPagingItems.get(i10);
            if (markerWithPartner != null) {
                composer.startReplaceGroup(1749131073);
                Modifier modifierC = androidx.compose.foundation.lazy.g.c(items, Modifier.INSTANCE, null, null, null, 2, null);
                String picture = markerWithPartner.getPicture();
                String name = markerWithPartner.getName();
                long createdAt = markerWithPartner.getMarkerAction().getCreatedAt();
                int i13 = markerWithPartner.getMarkerAction().getMarker() == 5 ? 3 : 2;
                boolean zChanged = composer.changed(markerWithPartner) | composer.changedInstance(navHostController);
                Object objRememberedValue = composer.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.details.n0
                        @Override // lb.a
                        public final Object invoke() {
                            return MsgDetailsDialogKt.MsgDetailsDialog$lambda$0$6$0$8$0$0(markerWithPartner, navHostController);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                MsgMarkerItem(modifierC, picture, name, createdAt, i13, (lb.a) objRememberedValue, composer, 0);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(1750415651);
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
    public static final ua.k0 MsgDetailsDialog$lambda$0$6$0$8$0$0(MarkerWithPartner markerWithPartner, NavHostController navHostController) {
        String uid;
        User user = markerWithPartner.getUser();
        if (user != null && (uid = user.getUid()) != null) {
            ChatParams chatParams = new ChatParams(uid, 0, null, 0, 12, null);
            NavLinks navLinks = NavLinks.INSTANCE;
            int type = chatParams.getType();
            String strT = MainModule.INSTANCE.getInstance().getGson().t(chatParams);
            kotlin.jvm.internal.y.h(strT, "toJson(...)");
            NavController.navigate$default((NavController) navHostController, navLinks.goChat(type, strT), (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 MsgDetailsDialog$lambda$1(String str, NavHostController navHostController, MsgDetailsDialogViewModel msgDetailsDialogViewModel, int i10, int i11, Composer composer, int i12) {
        MsgDetailsDialog(str, navHostController, msgDetailsDialogViewModel, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return ua.k0.f43947a;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void MsgMarkerItem(final Modifier modifier, final String img, final String name, final long j10, final int i10, final lb.a onClick, Composer composer, final int i11) {
        int i12;
        Composer composer2;
        kotlin.jvm.internal.y.i(modifier, "modifier");
        kotlin.jvm.internal.y.i(img, "img");
        kotlin.jvm.internal.y.i(name, "name");
        kotlin.jvm.internal.y.i(onClick, "onClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1171516036);
        if ((i11 & 6) == 0) {
            i12 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i11;
        } else {
            i12 = i11;
        }
        if ((i11 & 48) == 0) {
            i12 |= composerStartRestartGroup.changed(img) ? 32 : 16;
        }
        if ((i11 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i12 |= composerStartRestartGroup.changed(name) ? 256 : 128;
        }
        if ((i11 & 3072) == 0) {
            i12 |= composerStartRestartGroup.changed(j10) ? 2048 : 1024;
        }
        if ((i11 & 24576) == 0) {
            i12 |= composerStartRestartGroup.changed(i10) ? 16384 : 8192;
        }
        if ((196608 & i11) == 0) {
            i12 |= composerStartRestartGroup.changedInstance(onClick) ? 131072 : 65536;
        }
        if (composerStartRestartGroup.shouldExecute((74899 & i12) != 74898, i12 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1171516036, i12, -1, "cu.todus.android.uiCompose.main.screen.chat.details.MsgMarkerItem (MsgDetailsDialog.kt:419)");
            }
            int i13 = i12;
            float f10 = 10;
            Modifier modifierM1727paddingVpY3zN4$default = PaddingKt.m1727paddingVpY3zN4$default(ClickableKt.m1250combinedClickablehoGz1lA$default(SizeKt.fillMaxWidth$default(modifier, 0.0f, 1, null), false, null, null, null, null, null, false, null, onClick, 255, null), 0.0f, Dp.m8823constructorimpl(f10), 1, null);
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getCenterVertically(), composerStartRestartGroup, 48);
            int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1727paddingVpY3zN4$default);
            ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
            lb.a constructor = companion.getConstructor();
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
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyRowMeasurePolicy, companion.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl, companion.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion.getSetModifier());
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            Modifier.Companion companion2 = Modifier.INSTANCE;
            composer2 = composerStartRestartGroup;
            Z17PictureAvatarKt.m10277Z17PictureAvatarajT4Zlk(SizeKt.m1769size3ABfNKs(PaddingKt.m1729paddingqDBjuR0$default(companion2, 0.0f, 0.0f, Dp.m8823constructorimpl(f10), 0.0f, 11, null), Dp.m8823constructorimpl(35)), img, Color.m5856boximpl(ColorKt.Color(ColorGenerator.INSTANCE.getMATERIAL().getColor(name))), null, "", 0, 30, false, null, name, true, 0, composer2, (i13 & 112) | 1597446 | ((i13 << 21) & C.ENCODING_PCM_DOUBLE), 6, 2472);
            int i14 = i13 >> 3;
            Z17LabelKt.m10262Z17LabelfWhpE4E(e3.a(rowScopeInstance, companion2, 0.9f, false, 2, null), name, MaterialTheme.INSTANCE.getTypography(composer2, MaterialTheme.$stable).getBodyLarge(), 0L, 1, 0, composer2, (i14 & 112) | 24576, 40);
            MarkerText(e3.a(rowScopeInstance, companion2, 1.0f, false, 2, null), i10, j10, composer2, ((i13 >> 9) & 112) | (i14 & 896));
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.details.o0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return MsgDetailsDialogKt.MsgMarkerItem$lambda$1(modifier, img, name, j10, i10, onClick, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 MsgMarkerItem$lambda$1(Modifier modifier, String str, String str2, long j10, int i10, lb.a aVar, int i11, Composer composer, int i12) {
        MsgMarkerItem(modifier, str, str2, j10, i10, aVar, composer, RecomposeScopeImplKt.updateChangedFlags(i11 | 1));
        return ua.k0.f43947a;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void MsgReactionItem(final Modifier modifier, final String img, final String name, long j10, final String reaction, final lb.a onClick, Composer composer, final int i10) {
        int i11;
        final long j11 = j10;
        kotlin.jvm.internal.y.i(modifier, "modifier");
        kotlin.jvm.internal.y.i(img, "img");
        kotlin.jvm.internal.y.i(name, "name");
        kotlin.jvm.internal.y.i(reaction, "reaction");
        kotlin.jvm.internal.y.i(onClick, "onClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(-621642891);
        if ((i10 & 6) == 0) {
            i11 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i10;
        } else {
            i11 = i10;
        }
        if ((i10 & 48) == 0) {
            i11 |= composerStartRestartGroup.changed(img) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i11 |= composerStartRestartGroup.changed(name) ? 256 : 128;
        }
        if ((i10 & 3072) == 0) {
            i11 |= composerStartRestartGroup.changed(j11) ? 2048 : 1024;
        }
        if ((i10 & 24576) == 0) {
            i11 |= composerStartRestartGroup.changed(reaction) ? 16384 : 8192;
        }
        if ((196608 & i10) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(onClick) ? 131072 : 65536;
        }
        if (composerStartRestartGroup.shouldExecute((74899 & i11) != 74898, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-621642891, i11, -1, "cu.todus.android.uiCompose.main.screen.chat.details.MsgReactionItem (MsgDetailsDialog.kt:311)");
            }
            int i12 = i11;
            float f10 = 10;
            Modifier modifierM1727paddingVpY3zN4$default = PaddingKt.m1727paddingVpY3zN4$default(ClickableKt.m1250combinedClickablehoGz1lA$default(SizeKt.fillMaxWidth$default(modifier, 0.0f, 1, null), false, null, null, null, null, null, false, null, onClick, 255, null), 0.0f, Dp.m8823constructorimpl(f10), 1, null);
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getCenterVertically(), composerStartRestartGroup, 48);
            int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1727paddingVpY3zN4$default);
            ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
            lb.a constructor = companion.getConstructor();
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
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyRowMeasurePolicy, companion.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl, companion.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion.getSetModifier());
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            Modifier.Companion companion2 = Modifier.INSTANCE;
            Z17PictureAvatarKt.m10277Z17PictureAvatarajT4Zlk(SizeKt.m1769size3ABfNKs(PaddingKt.m1729paddingqDBjuR0$default(companion2, 0.0f, 0.0f, Dp.m8823constructorimpl(f10), 0.0f, 11, null), Dp.m8823constructorimpl(35)), img, Color.m5856boximpl(ColorKt.Color(ColorGenerator.INSTANCE.getMATERIAL().getColor(name))), null, "", 0, 30, false, null, name, true, 0, composerStartRestartGroup, (i12 & 112) | 1597446 | ((i12 << 21) & C.ENCODING_PCM_DOUBLE), 6, 2472);
            composerStartRestartGroup = composerStartRestartGroup;
            Z17LabelKt.m10262Z17LabelfWhpE4E(PaddingKt.m1729paddingqDBjuR0$default(e3.a(rowScopeInstance, companion2, 1.0f, false, 2, null), 0.0f, 0.0f, Dp.m8823constructorimpl(f10), 0.0f, 11, null), name, MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyLarge(), 0L, 1, 0, composerStartRestartGroup, ((i12 >> 3) & 112) | 24576, 40);
            j11 = j10;
            ReactionText(reaction, j11, composerStartRestartGroup, ((i12 >> 12) & 14) | ((i12 >> 6) & 112));
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.details.r
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return MsgDetailsDialogKt.MsgReactionItem$lambda$1(modifier, img, name, j11, reaction, onClick, i10, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 MsgReactionItem$lambda$1(Modifier modifier, String str, String str2, long j10, String str3, lb.a aVar, int i10, Composer composer, int i11) {
        MsgReactionItem(modifier, str, str2, j10, str3, aVar, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1));
        return ua.k0.f43947a;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void ReactionText(final String value, final long j10, Composer composer, final int i10) {
        int i11;
        kotlin.jvm.internal.y.i(value, "value");
        Composer composerStartRestartGroup = composer.startRestartGroup(1165207543);
        if ((i10 & 6) == 0) {
            i11 = (composerStartRestartGroup.changed(value) ? 4 : 2) | i10;
        } else {
            i11 = i10;
        }
        if ((i10 & 48) == 0) {
            i11 |= composerStartRestartGroup.changed(j10) ? 32 : 16;
        }
        if (composerStartRestartGroup.shouldExecute((i11 & 19) != 18, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1165207543, i11, -1, "cu.todus.android.uiCompose.main.screen.chat.details.ReactionText (MsgDetailsDialog.kt:351)");
            }
            composerStartRestartGroup.startReplaceGroup(-1222012215);
            AnnotatedString.Builder builder = new AnnotatedString.Builder(0, 1, null);
            if (!le.d0.q0(value)) {
                long sp = TextUnitKt.getSp(18);
                FontWeight bold = FontWeight.INSTANCE.getBold();
                long sp2 = TextUnitKt.getSp(1);
                TextUnitKt.m9026checkArithmeticR2X_6o(sp2);
                int iPushStyle = builder.pushStyle(new SpanStyle(0L, sp, bold, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, TextUnitKt.pack(TextUnit.m9011getRawTypeimpl(sp2), -TextUnit.m9013getValueimpl(sp2)), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65401, (kotlin.jvm.internal.p) null));
                try {
                    InlineTextContentKt.appendInlineContent$default(builder, value, null, 2, null);
                    ua.k0 k0Var = ua.k0.f43947a;
                    builder.pop(iPushStyle);
                } catch (Throwable th2) {
                    builder.pop(iPushStyle);
                    throw th2;
                }
            }
            composerStartRestartGroup.startReplaceGroup(-1222000166);
            int iPushStyle2 = builder.pushStyle(new SpanStyle(0L, TextUnitKt.getSp(10), (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65533, (kotlin.jvm.internal.p) null));
            try {
                builder.append(" " + DateFormatter.INSTANCE.format(new Date(j10), DateFormat.is24HourFormat((Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext())) ? DateFormatter.Template.TIME : DateFormatter.Template.TIME_12));
                ua.k0 k0Var2 = ua.k0.f43947a;
                builder.pop(iPushStyle2);
                composerStartRestartGroup.endReplaceGroup();
                AnnotatedString annotatedString = builder.toAnnotatedString();
                composerStartRestartGroup.endReplaceGroup();
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = ReactionsRepository.INSTANCE.getInstance().m9802inlineContentR2X_6o(TextUnitKt.getSp(30));
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                Z17LabelKt.m10261Z17Label3f6hBDE(null, annotatedString, (Map) objRememberedValue, null, 0L, 0, 0, composerStartRestartGroup, 0, 121);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } catch (Throwable th3) {
                builder.pop(iPushStyle2);
                throw th3;
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.details.q
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return MsgDetailsDialogKt.ReactionText$lambda$2(value, j10, i10, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ReactionText$lambda$2(String str, long j10, int i10, Composer composer, int i11) {
        ReactionText(str, j10, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1));
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ReactionText$lambda$5(Modifier modifier, String str, int i10, Composer composer, int i11) {
        ReactionText(modifier, str, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1));
        return ua.k0.f43947a;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void ReactionText(final Modifier modifier, final String value, Composer composer, final int i10) {
        int i11;
        kotlin.jvm.internal.y.i(modifier, "modifier");
        kotlin.jvm.internal.y.i(value, "value");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1186771450);
        if ((i10 & 6) == 0) {
            i11 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i10;
        } else {
            i11 = i10;
        }
        if ((i10 & 48) == 0) {
            i11 |= composerStartRestartGroup.changed(value) ? 32 : 16;
        }
        if (composerStartRestartGroup.shouldExecute((i11 & 19) != 18, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1186771450, i11, -1, "cu.todus.android.uiCompose.main.screen.chat.details.ReactionText (MsgDetailsDialog.kt:388)");
            }
            AnnotatedString.Builder builder = new AnnotatedString.Builder(0, 1, null);
            if (!le.d0.q0(value)) {
                int iPushStyle = builder.pushStyle(new SpanStyle(0L, TextUnitKt.getSp(14), FontWeight.INSTANCE.getBold(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65529, (kotlin.jvm.internal.p) null));
                try {
                    InlineTextContentKt.appendInlineContent$default(builder, value, null, 2, null);
                    ua.k0 k0Var = ua.k0.f43947a;
                    builder.pop(iPushStyle);
                } catch (Throwable th2) {
                    builder.pop(iPushStyle);
                    throw th2;
                }
            }
            AnnotatedString annotatedString = builder.toAnnotatedString();
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = ReactionsRepository.INSTANCE.getInstance().m9802inlineContentR2X_6o(TextUnitKt.getSp(24));
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            Z17LabelKt.m10261Z17Label3f6hBDE(modifier, annotatedString, (Map) objRememberedValue, null, 0L, 0, 0, composerStartRestartGroup, i11 & 14, MenuKt.InTransitionDuration);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.details.s
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return MsgDetailsDialogKt.ReactionText$lambda$5(modifier, value, i10, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
