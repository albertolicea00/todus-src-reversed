package cu.todus.android.uiCompose.main.screen.setting;

import android.content.Context;
import androidx.autofill.HintConstants;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.ScaffoldKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.automirrored.outlined.LogoutKt;
import androidx.compose.material.icons.outlined.ArrowForwardIosKt;
import androidx.compose.material.icons.outlined.BallotKt;
import androidx.compose.material.icons.outlined.BatterySaverKt;
import androidx.compose.material.icons.outlined.BlockKt;
import androidx.compose.material.icons.outlined.Brightness4Kt;
import androidx.compose.material.icons.outlined.DataSaverOffKt;
import androidx.compose.material.icons.outlined.ImportExportKt;
import androidx.compose.material.icons.outlined.LockKt;
import androidx.compose.material.icons.outlined.NotificationsKt;
import androidx.compose.material.icons.outlined.PrivacyTipKt;
import androidx.compose.material.icons.outlined.ShareKt;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.TopAppBarScrollBehavior;
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
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
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
import cu.todus.android.R;
import cu.todus.android.constants.Service;
import cu.todus.android.data.preferences.RootEnvironment;
import cu.todus.android.uiCompose.navigation.NavLinks;
import cu.todus.android.uiCompose.theme.Other;
import cu.todus.android.utils.IntentUtil;
import cu.z17.views.button.Z17ButtonsKt;
import cu.z17.views.inputText.Z17InputTextKt;
import cu.z17.views.label.Z17LabelKt;
import cu.z17.views.permission.PermissionsRequesterState;
import cu.z17.views.permission.PermissionsResult;
import cu.z17.views.permission.Z17PermissionRequesterKt;
import cu.z17.views.picture.Z17PictureAvatarKt;
import cu.z17.views.picture.Z17PictureKt;
import cu.z17.views.scaffold.Z17ScaffoldKt;
import cu.z17.views.textToggle.Z17TextToggleKt;
import cu.z17.views.topBar.Z17TopBarKt;
import cu.z17.views.utils.Z17InlineUtilsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\u001a!\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\u001a=\u0010\u0010\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u000eH\u0007¢\u0006\u0004\b\u0010\u0010\u0011\u001a5\u0010\u0017\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u000eH\u0007¢\u0006\u0004\b\u0015\u0010\u0016\u001a+\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00182\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00040\u001aH\u0007¢\u0006\u0004\b\u001c\u0010\u001d¨\u0006$²\u0006\f\u0010\u001f\u001a\u00020\u001e8\nX\u008a\u0084\u0002²\u0006\f\u0010 \u001a\u00020\u001e8\nX\u008a\u0084\u0002²\u0006\u0014\u0010\"\u001a\n !*\u0004\u0018\u00010\u00180\u00188\nX\u008a\u0084\u0002²\u0006\u000e\u0010#\u001a\u00020\u000b8\n@\nX\u008a\u008e\u0002"}, d2 = {"Landroidx/navigation/NavHostController;", "navHostController", "Lcu/todus/android/uiCompose/main/screen/setting/SettingViewModel;", "viewModel", "Lua/k0;", "SettingScreen", "(Landroidx/navigation/NavHostController;Lcu/todus/android/uiCompose/main/screen/setting/SettingViewModel;Landroidx/compose/runtime/Composer;II)V", "Landroidx/compose/ui/Modifier;", "modifier", "", "image", "", "name", HintConstants.AUTOFILL_HINT_PHONE_NUMBER, "Lkotlin/Function0;", "onClick", "ProfileCard", "(Landroidx/compose/ui/Modifier;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Llb/a;Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/ui/graphics/Color;", "color", "title", "GoSectionBtn-3IgeMak", "(Ljava/lang/Object;JLjava/lang/String;Llb/a;Landroidx/compose/runtime/Composer;I)V", "GoSectionBtn", "Lcu/todus/android/data/preferences/RootEnvironment;", "hostSelected", "Lkotlin/Function1;", "onSelect", "HostSelection", "(Lcu/todus/android/data/preferences/RootEnvironment;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "", "sentryState", "requestModeState", "kotlin.jvm.PlatformType", "root", "newHost", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class SettingScreenKt {
    @Composable
    /* JADX INFO: renamed from: GoSectionBtn-3IgeMak, reason: not valid java name */
    public static final void m9983GoSectionBtn3IgeMak(final Object image, final long j10, final String title, final lb.a onClick, Composer composer, final int i10) {
        int i11;
        kotlin.jvm.internal.y.i(image, "image");
        kotlin.jvm.internal.y.i(title, "title");
        kotlin.jvm.internal.y.i(onClick, "onClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(1287639474);
        if ((i10 & 6) == 0) {
            i11 = (composerStartRestartGroup.changedInstance(image) ? 4 : 2) | i10;
        } else {
            i11 = i10;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i11 |= composerStartRestartGroup.changed(title) ? 256 : 128;
        }
        if ((i10 & 3072) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(onClick) ? 2048 : 1024;
        }
        int i12 = i11;
        if (composerStartRestartGroup.shouldExecute((i12 & 1155) != 1154, i12 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1287639474, i12, -1, "cu.todus.android.uiCompose.main.screen.setting.GoSectionBtn (SettingScreen.kt:406)");
            }
            Alignment.Companion companion = Alignment.INSTANCE;
            Alignment.Vertical centerVertically = companion.getCenterVertically();
            Arrangement arrangement = Arrangement.INSTANCE;
            Arrangement.HorizontalOrVertical spaceBetween = arrangement.getSpaceBetween();
            Modifier.Companion companion2 = Modifier.INSTANCE;
            float f10 = 10;
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(PaddingKt.m1726paddingVpY3zN4(companion2, Dp.m8823constructorimpl(30), Dp.m8823constructorimpl(f10)), 0.0f, 1, null);
            boolean z10 = (i12 & 7168) == 2048;
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z10 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.setting.i1
                    @Override // lb.a
                    public final Object invoke() {
                        return SettingScreenKt.GoSectionBtn_3IgeMak$lambda$0$0(onClick);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            Modifier modifierM1240clickableoSLSa3U$default = ClickableKt.m1240clickableoSLSa3U$default(modifierFillMaxWidth$default, false, null, null, null, (lb.a) objRememberedValue, 15, null);
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(spaceBetween, centerVertically, composerStartRestartGroup, 54);
            int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1240clickableoSLSa3U$default);
            ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
            lb.a constructor = companion3.getConstructor();
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
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyRowMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion3.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl, companion3.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion3.getSetModifier());
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(arrangement.getStart(), companion.getCenterVertically(), composerStartRestartGroup, 48);
            int iA2 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion2);
            lb.a constructor2 = companion3.getConstructor();
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
            Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyRowMeasurePolicy2, companion3.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl2, Integer.valueOf(iA2), companion3.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl2, companion3.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier2, companion3.getSetModifier());
            Modifier modifierM1725padding3ABfNKs = PaddingKt.m1725padding3ABfNKs(BackgroundKt.m1204backgroundbw27NRU(SizeKt.m1769size3ABfNKs(companion2, Dp.m8823constructorimpl(40)), Color.m5865copywmQWz5c$default(Other.INSTANCE.m10118getRed0d7_KjU(), 0.7f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.getCircleShape()), Dp.m8823constructorimpl(f10));
            ColorFilter.Companion companion4 = ColorFilter.INSTANCE;
            MaterialTheme materialTheme = MaterialTheme.INSTANCE;
            int i13 = MaterialTheme.$stable;
            Z17PictureKt.m10278Z17BasePictureC8z9wKI(modifierM1725padding3ABfNKs, image, null, ColorFilter.Companion.m5907tintxETnrds$default(companion4, materialTheme.getColorScheme(composerStartRestartGroup, i13).getBackground(), 0, 2, null), null, null, 0, null, null, composerStartRestartGroup, (i12 << 3) & 112, XMPPTCPConnection.PacketWriter.QUEUE_SIZE);
            SpacerKt.Spacer(SizeKt.m1774width3ABfNKs(companion2, Dp.m8823constructorimpl(f10)), composerStartRestartGroup, 6);
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, title, materialTheme.getTypography(composerStartRestartGroup, i13).getBodyMedium(), 0L, 0, 0, composerStartRestartGroup, (i12 >> 3) & 112, 57);
            composerStartRestartGroup.endNode();
            Z17PictureKt.m10278Z17BasePictureC8z9wKI(SizeKt.m1769size3ABfNKs(companion2, Dp.m8823constructorimpl(24)), ArrowForwardIosKt.getArrowForwardIos(Icons.Outlined.INSTANCE), null, ColorFilter.Companion.m5907tintxETnrds$default(companion4, materialTheme.getColorScheme(composerStartRestartGroup, i13).getOnBackground(), 0, 2, null), null, null, 0, null, null, composerStartRestartGroup, 6, XMPPTCPConnection.PacketWriter.QUEUE_SIZE);
            composerStartRestartGroup = composerStartRestartGroup;
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.setting.l1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SettingScreenKt.GoSectionBtn_3IgeMak$lambda$2(image, j10, title, onClick, i10, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 GoSectionBtn_3IgeMak$lambda$0$0(lb.a aVar) {
        aVar.invoke();
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 GoSectionBtn_3IgeMak$lambda$2(Object obj, long j10, String str, lb.a aVar, int i10, Composer composer, int i11) {
        m9983GoSectionBtn3IgeMak(obj, j10, str, aVar, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1));
        return ua.k0.f43947a;
    }

    /* JADX WARN: Code duplicated, block: B:80:0x029d  */
    /* JADX WARN: Code duplicated, block: B:82:0x02a2  */
    /* JADX WARN: Code duplicated, block: B:87:0x02b7  */
    /* JADX WARN: Code duplicated, block: B:90:0x02db  */
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
    public static final void HostSelection(final RootEnvironment hostSelected, final Function1 onSelect, Composer composer, final int i10) {
        int i11;
        char c10;
        Object obj;
        Object objMutableStateOf$default;
        boolean z10;
        boolean z11;
        boolean z12;
        boolean zChanged;
        Object objRememberedValue;
        kotlin.jvm.internal.y.i(hostSelected, "hostSelected");
        kotlin.jvm.internal.y.i(onSelect, "onSelect");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1829248803);
        if ((i10 & 6) == 0) {
            i11 = (composerStartRestartGroup.changed(hostSelected) ? 4 : 2) | i10;
        } else {
            i11 = i10;
        }
        if ((i10 & 48) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(onSelect) ? 32 : 16;
        }
        if (composerStartRestartGroup.shouldExecute((i11 & 19) != 18, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1829248803, i11, -1, "cu.todus.android.uiCompose.main.screen.setting.HostSelection (SettingScreen.kt:445)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            Modifier modifierM1727paddingVpY3zN4$default = PaddingKt.m1727paddingVpY3zN4$default(companion, Dp.m8823constructorimpl(20), 0.0f, 2, null);
            Arrangement.Vertical top = Arrangement.INSTANCE.getTop();
            Alignment.Companion companion2 = Alignment.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(top, companion2.getStart(), composerStartRestartGroup, 0);
            int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1727paddingVpY3zN4$default);
            ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
            lb.a constructor = companion3.getConstructor();
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
            SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion, Dp.m8823constructorimpl(15)), composerStartRestartGroup, 6);
            Modifier modifierAlign = columnScopeInstance.align(companion, companion2.getCenterHorizontally());
            MaterialTheme materialTheme = MaterialTheme.INSTANCE;
            int i12 = MaterialTheme.$stable;
            int i13 = i11;
            Z17LabelKt.m10262Z17LabelfWhpE4E(modifierAlign, "Host-Selection", materialTheme.getTypography(composerStartRestartGroup, i12).getTitleSmall(), 0L, 0, 0, composerStartRestartGroup, 48, 56);
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, "ATENCIÓN. Si eres del equipo desarrollador con acceso a este feature debes saber que al usarlo puedes provocar errores inesperados en todo el sistema. Selecciona una entorno LOCAL, luego añade la URL terminada en '/' y reinicia la aplicación para que tome efecto.", materialTheme.getTypography(composerStartRestartGroup, i12).getBodySmall(), 0L, 0, 0, composerStartRestartGroup, 48, 57);
            SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion, Dp.m8823constructorimpl(10)), composerStartRestartGroup, 6);
            boolean z13 = hostSelected.getApplicationEnvironment() == Service.ApplicationEnvironment.PROD_2;
            int i14 = i13 & 112;
            boolean z14 = i14 == 32;
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (z14 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.setting.m1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return SettingScreenKt.HostSelection$lambda$0$0$0(onSelect, ((Boolean) obj2).booleanValue());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            Z17TextToggleKt.Z17TextToggle(null, z13, (Function1) objRememberedValue2, null, "Producción IM 2", null, null, composerStartRestartGroup, 24576, 105);
            float f10 = 5;
            SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion, Dp.m8823constructorimpl(f10)), composerStartRestartGroup, 6);
            boolean z15 = hostSelected.getApplicationEnvironment() == Service.ApplicationEnvironment.LOCAL;
            boolean z16 = i14 == 32;
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (z16 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.setting.n1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return SettingScreenKt.HostSelection$lambda$0$1$0(onSelect, ((Boolean) obj2).booleanValue());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            Z17TextToggleKt.Z17TextToggle(null, z15, (Function1) objRememberedValue3, null, "Local", null, null, composerStartRestartGroup, 24576, 105);
            boolean zChanged2 = composerStartRestartGroup.changed(hostSelected.getRootUrl());
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (zChanged2 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                c10 = 2;
                obj = null;
                objMutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(hostSelected.getRootUrl(), null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objMutableStateOf$default);
            } else {
                objMutableStateOf$default = objRememberedValue4;
                c10 = 2;
                obj = null;
            }
            final MutableState mutableState = (MutableState) objMutableStateOf$default;
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(companion, 0.0f, 1, obj);
            String strHostSelection$lambda$0$3 = HostSelection$lambda$0$3(mutableState);
            boolean zChanged3 = composerStartRestartGroup.changed(mutableState);
            Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (zChanged3 || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue5 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.setting.o1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return SettingScreenKt.HostSelection$lambda$0$5$0(mutableState, (String) obj2);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            }
            Z17InputTextKt.m10251Z17InputTextf9_u2OI(modifierFillMaxWidth$default, strHostSelection$lambda$0$3, 0, 0, null, null, (Function1) objRememberedValue5, null, null, 0, 0, 0L, 0L, 0L, 0L, 0L, null, false, null, false, composerStartRestartGroup, 6, 0, 1048508);
            SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion, Dp.m8823constructorimpl(f10)), composerStartRestartGroup, 6);
            Modifier modifierAlign2 = columnScopeInstance.align(companion, companion2.getEnd());
            if (Z17InlineUtilsKt.isAnUrl(HostSelection$lambda$0$3(mutableState))) {
                z10 = false;
                if (le.a0.F(HostSelection$lambda$0$3(mutableState), "/", false, 2, null)) {
                    z11 = true;
                }
                if (i14 == 32) {
                    z12 = true;
                } else {
                    z12 = z10;
                }
                zChanged = composerStartRestartGroup.changed(mutableState) | z12;
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.setting.p1
                        @Override // lb.a
                        public final Object invoke() {
                            return SettingScreenKt.HostSelection$lambda$0$6$0(onSelect, mutableState);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                Z17ButtonsKt.Z17SecondaryButton(modifierAlign2, (lb.a) objRememberedValue, "Save LOCAL", null, false, z11, composerStartRestartGroup, RendererCapabilities.DECODER_SUPPORT_MASK, 24);
                composerStartRestartGroup = composerStartRestartGroup;
                composerStartRestartGroup.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                z10 = false;
            }
            z11 = z10;
            if (i14 == 32) {
                z12 = true;
            } else {
                z12 = z10;
            }
            zChanged = composerStartRestartGroup.changed(mutableState) | z12;
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged) {
                objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.setting.p1
                    @Override // lb.a
                    public final Object invoke() {
                        return SettingScreenKt.HostSelection$lambda$0$6$0(onSelect, mutableState);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.setting.p1
                    @Override // lb.a
                    public final Object invoke() {
                        return SettingScreenKt.HostSelection$lambda$0$6$0(onSelect, mutableState);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            Z17ButtonsKt.Z17SecondaryButton(modifierAlign2, (lb.a) objRememberedValue, "Save LOCAL", null, false, z11, composerStartRestartGroup, RendererCapabilities.DECODER_SUPPORT_MASK, 24);
            composerStartRestartGroup = composerStartRestartGroup;
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.setting.q1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return SettingScreenKt.HostSelection$lambda$1(hostSelected, onSelect, i10, (Composer) obj2, ((Integer) obj3).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 HostSelection$lambda$0$0$0(Function1 function1, boolean z10) {
        function1.invoke(new RootEnvironment(Service.ApplicationEnvironment.PROD_2, ""));
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 HostSelection$lambda$0$1$0(Function1 function1, boolean z10) {
        function1.invoke(new RootEnvironment(Service.ApplicationEnvironment.LOCAL, ""));
        return ua.k0.f43947a;
    }

    private static final String HostSelection$lambda$0$3(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 HostSelection$lambda$0$5$0(MutableState mutableState, String it) {
        kotlin.jvm.internal.y.i(it, "it");
        mutableState.setValue(it);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 HostSelection$lambda$0$6$0(Function1 function1, MutableState mutableState) {
        function1.invoke(new RootEnvironment(Service.ApplicationEnvironment.LOCAL, HostSelection$lambda$0$3(mutableState)));
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 HostSelection$lambda$1(RootEnvironment rootEnvironment, Function1 function1, int i10, Composer composer, int i11) {
        HostSelection(rootEnvironment, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1));
        return ua.k0.f43947a;
    }

    @Composable
    public static final void ProfileCard(final Modifier modifier, final Object image, final String name, final String phoneNumber, final lb.a onClick, Composer composer, final int i10) {
        int i11;
        Composer composer2;
        kotlin.jvm.internal.y.i(modifier, "modifier");
        kotlin.jvm.internal.y.i(image, "image");
        kotlin.jvm.internal.y.i(name, "name");
        kotlin.jvm.internal.y.i(phoneNumber, "phoneNumber");
        kotlin.jvm.internal.y.i(onClick, "onClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(-772099759);
        if ((i10 & 6) == 0) {
            i11 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i10;
        } else {
            i11 = i10;
        }
        if ((i10 & 48) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(image) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i11 |= composerStartRestartGroup.changed(name) ? 256 : 128;
        }
        if ((i10 & 3072) == 0) {
            i11 |= composerStartRestartGroup.changed(phoneNumber) ? 2048 : 1024;
        }
        if ((i10 & 24576) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(onClick) ? 16384 : 8192;
        }
        int i12 = i11;
        if (composerStartRestartGroup.shouldExecute((i12 & 9363) != 9362, i12 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-772099759, i12, -1, "cu.todus.android.uiCompose.main.screen.setting.ProfileCard (SettingScreen.kt:365)");
            }
            boolean z10 = (57344 & i12) == 16384;
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z10 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.setting.m0
                    @Override // lb.a
                    public final Object invoke() {
                        return SettingScreenKt.ProfileCard$lambda$0$0(onClick);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            Modifier modifierM1725padding3ABfNKs = PaddingKt.m1725padding3ABfNKs(ClickableKt.m1240clickableoSLSa3U$default(modifier, false, null, null, null, (lb.a) objRememberedValue, 15, null), Dp.m8823constructorimpl(20));
            Brush.Companion companion = Brush.INSTANCE;
            MaterialTheme materialTheme = MaterialTheme.INSTANCE;
            int i13 = MaterialTheme.$stable;
            float f10 = 10;
            Modifier modifierM1725padding3ABfNKs2 = PaddingKt.m1725padding3ABfNKs(BackgroundKt.background$default(modifierM1725padding3ABfNKs, Brush.Companion.m5827verticalGradient8A3gB4$default(companion, va.w.q(Color.m5856boximpl(materialTheme.getColorScheme(composerStartRestartGroup, i13).getInversePrimary()), Color.m5856boximpl(Color.m5865copywmQWz5c$default(materialTheme.getColorScheme(composerStartRestartGroup, i13).getInversePrimary(), 0.4f, 0.0f, 0.0f, 0.0f, 14, null))), 0.0f, 0.0f, 0, 14, (Object) null), RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(45)), 0.0f, 4, null), Dp.m8823constructorimpl(f10));
            Alignment.Companion companion2 = Alignment.INSTANCE;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion2.getTopStart(), false);
            int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1725padding3ABfNKs2);
            ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
            lb.a constructor = companion3.getConstructor();
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
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion3.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl, companion3.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion3.getSetModifier());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            Alignment.Vertical centerVertically = companion2.getCenterVertically();
            Modifier.Companion companion4 = Modifier.INSTANCE;
            Arrangement arrangement = Arrangement.INSTANCE;
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getStart(), centerVertically, composerStartRestartGroup, 48);
            int iA2 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion4);
            lb.a constructor2 = companion3.getConstructor();
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
            Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyRowMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl2, Integer.valueOf(iA2), companion3.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl2, companion3.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier2, companion3.getSetModifier());
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            composer2 = composerStartRestartGroup;
            Z17PictureAvatarKt.m10277Z17PictureAvatarajT4Zlk(SizeKt.m1769size3ABfNKs(companion4, Dp.m8823constructorimpl(80)), image, Integer.valueOf(R.drawable.profile), null, null, 0, null, false, null, null, false, 0, composer2, (i12 & 112) | 6, 0, 4088);
            SpacerKt.Spacer(SizeKt.m1774width3ABfNKs(companion4, Dp.m8823constructorimpl(f10)), composer2, 6);
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(arrangement.getTop(), companion2.getStart(), composer2, 0);
            int iA3 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
            CompositionLocalMap currentCompositionLocalMap3 = composer2.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composer2, companion4);
            lb.a constructor3 = companion3.getConstructor();
            if (!defpackage.r.a(composer2.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                composer2.createNode(constructor3);
            } else {
                composer2.useNode();
            }
            Composer composerM5176constructorimpl3 = Updater.m5176constructorimpl(composer2);
            Updater.m5184setimpl(composerM5176constructorimpl3, measurePolicyColumnMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl3, currentCompositionLocalMap3, companion3.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl3, Integer.valueOf(iA3), companion3.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl3, companion3.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl3, modifierMaterializeModifier3, companion3.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, name, materialTheme.getTypography(composer2, i13).getTitleSmall(), 0L, 0, 0, composer2, (i12 >> 3) & 112, 57);
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, phoneNumber, materialTheme.getTypography(composer2, i13).getBodyMedium(), 0L, 0, 0, composer2, (i12 >> 6) & 112, 57);
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, StringResources_androidKt.stringResource(R.string.edit, composer2, 0), TextStyle.m8271copyp1EtxEg$default(materialTheme.getTypography(composer2, i13).getBodyMedium(), 0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, TextDecoration.INSTANCE.getUnderline(), null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16773119, null), materialTheme.getColorScheme(composer2, i13).getPrimary(), 0, 0, composer2, 0, 49);
            composer2.endNode();
            composer2.endNode();
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.setting.x0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SettingScreenKt.ProfileCard$lambda$2(modifier, image, name, phoneNumber, onClick, i10, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ProfileCard$lambda$0$0(lb.a aVar) {
        aVar.invoke();
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ProfileCard$lambda$2(Modifier modifier, Object obj, String str, String str2, lb.a aVar, int i10, Composer composer, int i11) {
        ProfileCard(modifier, obj, str, str2, aVar, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1));
        return ua.k0.f43947a;
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0040  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void SettingScreen(final NavHostController navHostController, SettingViewModel settingViewModel, Composer composer, final int i10, final int i11) {
        int i12;
        Composer composer2;
        int i13;
        final SettingViewModel settingViewModel2 = settingViewModel;
        kotlin.jvm.internal.y.i(navHostController, "navHostController");
        Composer composerStartRestartGroup = composer.startRestartGroup(1745117924);
        if ((i10 & 6) == 0) {
            i12 = (composerStartRestartGroup.changedInstance(navHostController) ? 4 : 2) | i10;
        } else {
            i12 = i10;
        }
        if ((i10 & 48) == 0) {
            if ((i11 & 2) != 0) {
                i13 = 16;
            } else {
                if ((i10 & 64) == 0 ? composerStartRestartGroup.changed(settingViewModel2) : composerStartRestartGroup.changedInstance(settingViewModel2)) {
                    i13 = 32;
                } else {
                    i13 = 16;
                }
            }
            i12 |= i13;
        }
        int i14 = i12;
        if (composerStartRestartGroup.shouldExecute((i14 & 19) != 18, i14 & 1)) {
            composerStartRestartGroup.startDefaults();
            if ((i10 & 1) != 0 && !composerStartRestartGroup.getDefaultsInvalid()) {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i11 & 2) != 0) {
                    i14 &= -113;
                }
            } else if ((i11 & 2) != 0) {
                ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composerStartRestartGroup, 6);
                if (current == null) {
                    throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                }
                settingViewModel2 = (SettingViewModel) ViewModelKt.viewModel(kotlin.jvm.internal.z0.b(SettingViewModel.class), current, (String) null, (ViewModelProvider.Factory) null, current instanceof HasDefaultViewModelProviderFactory ? ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras() : CreationExtras.Empty.INSTANCE, composerStartRestartGroup, 0, 0);
                i14 &= -113;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1745117924, i14, -1, "cu.todus.android.uiCompose.main.screen.setting.SettingScreen (SettingScreen.kt:91)");
            }
            final Context context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
            composer2 = composerStartRestartGroup;
            Z17ScaffoldKt.m10301Z17BaseScaffoldueL0Wzs(ComposableLambdaKt.rememberComposableLambda(-1341956072, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.setting.g1
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return SettingScreenKt.SettingScreen$lambda$0(navHostController, context, settingViewModel2, (TopAppBarScrollBehavior) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), false, false, false, null, null, 0L, ScaffoldKt.rememberScaffoldState(null, null, composerStartRestartGroup, 0, 3), null, ComposableLambdaKt.rememberComposableLambda(902408218, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.setting.h1
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return SettingScreenKt.SettingScreen$lambda$1(settingViewModel2, context, navHostController, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composer2, 805306806, 376);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.setting.j1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SettingScreenKt.SettingScreen$lambda$2(navHostController, settingViewModel2, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 SettingScreen$lambda$0(final NavHostController navHostController, final Context context, final SettingViewModel settingViewModel, TopAppBarScrollBehavior it, Composer composer, int i10) {
        kotlin.jvm.internal.y.i(it, "it");
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1341956072, i10, -1, "cu.todus.android.uiCompose.main.screen.setting.SettingScreen.<anonymous> (SettingScreen.kt:99)");
            }
            Function2 lambda$556023717$app_productionPFast = ComposableSingletons$SettingScreenKt.INSTANCE.getLambda$556023717$app_productionPFast();
            ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1857526896, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.setting.e1
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return SettingScreenKt.SettingScreen$lambda$0$0(context, settingViewModel, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54);
            boolean zChangedInstance = composer.changedInstance(navHostController);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.setting.f1
                    @Override // lb.a
                    public final Object invoke() {
                        return SettingScreenKt.SettingScreen$lambda$0$1$0(navHostController);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            Z17TopBarKt.m10304Z17TopBardW2gCk(lambda$556023717$app_productionPFast, null, false, composableLambdaRememberComposableLambda, false, navHostController, (lb.a) objRememberedValue, null, 0L, 0L, 0.0f, composer, 3078, 0, 1942);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 SettingScreen$lambda$0$0(final Context context, final SettingViewModel settingViewModel, RowScope Z17TopBar, Composer composer, int i10) {
        kotlin.jvm.internal.y.i(Z17TopBar, "$this$Z17TopBar");
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1857526896, i10, -1, "cu.todus.android.uiCompose.main.screen.setting.SettingScreen.<anonymous>.<anonymous> (SettingScreen.kt:110)");
            }
            boolean zChangedInstance = composer.changedInstance(context) | composer.changedInstance(settingViewModel);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.setting.k1
                    @Override // lb.a
                    public final Object invoke() {
                        return SettingScreenKt.SettingScreen$lambda$0$0$0$0(context, settingViewModel);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            IconButtonKt.IconButton((lb.a) objRememberedValue, PaddingKt.m1727paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m8823constructorimpl(5), 0.0f, 2, null), false, null, null, null, ComposableSingletons$SettingScreenKt.INSTANCE.getLambda$580382258$app_productionPFast(), composer, 1572912, 60);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 SettingScreen$lambda$0$0$0$0(Context context, SettingViewModel settingViewModel) {
        IntentUtil.INSTANCE.shareText(context, "Chat", "https://chat.todus.cu/chat-profile/" + settingViewModel.getOwner().getToDusId());
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 SettingScreen$lambda$0$1$0(NavHostController navHostController) {
        navHostController.navigateUp();
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 SettingScreen$lambda$1(SettingViewModel settingViewModel, final Context context, final NavHostController navHostController, Modifier it, Composer composer, int i10) {
        final MutableState mutableState;
        kotlin.jvm.internal.y.i(it, "it");
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(902408218, i10, -1, "cu.todus.android.uiCompose.main.screen.setting.SettingScreen.<anonymous> (SettingScreen.kt:129)");
            }
            te.h sentryState = settingViewModel.getSentryState();
            Boolean bool = Boolean.FALSE;
            State stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(sentryState, bool, (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composer, 48, 14);
            State stateCollectAsStateWithLifecycle2 = FlowExtKt.collectAsStateWithLifecycle(settingViewModel.getRequestModeState(), bool, (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composer, 48, 14);
            Object objRememberedValue = composer.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new PermissionsRequesterState(null, false, va.w.n(), 1, null), null, 2, null);
                composer.updateRememberedValue(objRememberedValue);
            }
            final MutableState mutableState2 = (MutableState) objRememberedValue;
            Modifier.Companion companion2 = Modifier.INSTANCE;
            Modifier modifierVerticalScroll$default = ScrollKt.verticalScroll$default(SizeKt.fillMaxSize$default(companion2, 0.0f, 1, null), ScrollKt.rememberScrollState(0, composer, 0, 1), false, null, false, 14, null);
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer, 0);
            int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierVerticalScroll$default);
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
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(companion2, 0.0f, 1, null);
            String photoUrl = settingViewModel.getOwner().getPhotoUrl();
            String alias = settingViewModel.getOwner().getAlias();
            String username = settingViewModel.getOwner().getUsername();
            boolean zChangedInstance = composer.changedInstance(navHostController);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.setting.u0
                    @Override // lb.a
                    public final Object invoke() {
                        return SettingScreenKt.SettingScreen$lambda$1$3$0$0(navHostController);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            ProfileCard(modifierFillMaxWidth$default, photoUrl, alias, username, (lb.a) objRememberedValue2, composer, 6);
            Icons.Outlined outlined = Icons.Outlined.INSTANCE;
            ImageVector lock = LockKt.getLock(outlined);
            Other other = Other.INSTANCE;
            long jM10116getPink0d7_KjU = other.m10116getPink0d7_KjU();
            String strStringResource = StringResources_androidKt.stringResource(R.string.secure_folder, composer, 0);
            boolean zChangedInstance2 = composer.changedInstance(navHostController);
            Object objRememberedValue3 = composer.rememberedValue();
            if (zChangedInstance2 || objRememberedValue3 == companion.getEmpty()) {
                objRememberedValue3 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.setting.v0
                    @Override // lb.a
                    public final Object invoke() {
                        return SettingScreenKt.SettingScreen$lambda$1$3$1$0(navHostController);
                    }
                };
                composer.updateRememberedValue(objRememberedValue3);
            }
            m9983GoSectionBtn3IgeMak(lock, jM10116getPink0d7_KjU, strStringResource, (lb.a) objRememberedValue3, composer, 0);
            ImageVector dataSaverOff = DataSaverOffKt.getDataSaverOff(outlined);
            long jM10117getPurple0d7_KjU = other.m10117getPurple0d7_KjU();
            String strStringResource2 = StringResources_androidKt.stringResource(R.string.data_usage_and_storage, composer, 0);
            boolean zChangedInstance3 = composer.changedInstance(navHostController);
            Object objRememberedValue4 = composer.rememberedValue();
            if (zChangedInstance3 || objRememberedValue4 == companion.getEmpty()) {
                objRememberedValue4 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.setting.w0
                    @Override // lb.a
                    public final Object invoke() {
                        return SettingScreenKt.SettingScreen$lambda$1$3$2$0(navHostController);
                    }
                };
                composer.updateRememberedValue(objRememberedValue4);
            }
            m9983GoSectionBtn3IgeMak(dataSaverOff, jM10117getPurple0d7_KjU, strStringResource2, (lb.a) objRememberedValue4, composer, 0);
            ImageVector notifications = NotificationsKt.getNotifications(outlined);
            long jM10114getOrange10d7_KjU = other.m10114getOrange10d7_KjU();
            String strStringResource3 = StringResources_androidKt.stringResource(R.string.notifications, composer, 0);
            boolean zChangedInstance4 = composer.changedInstance(navHostController);
            Object objRememberedValue5 = composer.rememberedValue();
            if (zChangedInstance4 || objRememberedValue5 == companion.getEmpty()) {
                objRememberedValue5 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.setting.y0
                    @Override // lb.a
                    public final Object invoke() {
                        return SettingScreenKt.SettingScreen$lambda$1$3$3$0(navHostController);
                    }
                };
                composer.updateRememberedValue(objRememberedValue5);
            }
            m9983GoSectionBtn3IgeMak(notifications, jM10114getOrange10d7_KjU, strStringResource3, (lb.a) objRememberedValue5, composer, 0);
            ImageVector privacyTip = PrivacyTipKt.getPrivacyTip(outlined);
            long jM10112getGrey0d7_KjU = other.m10112getGrey0d7_KjU();
            String strStringResource4 = StringResources_androidKt.stringResource(R.string.privacy, composer, 0);
            boolean zChangedInstance5 = composer.changedInstance(navHostController);
            Object objRememberedValue6 = composer.rememberedValue();
            if (zChangedInstance5 || objRememberedValue6 == companion.getEmpty()) {
                objRememberedValue6 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.setting.z0
                    @Override // lb.a
                    public final Object invoke() {
                        return SettingScreenKt.SettingScreen$lambda$1$3$4$0(navHostController);
                    }
                };
                composer.updateRememberedValue(objRememberedValue6);
            }
            m9983GoSectionBtn3IgeMak(privacyTip, jM10112getGrey0d7_KjU, strStringResource4, (lb.a) objRememberedValue6, composer, 0);
            ImageVector block = BlockKt.getBlock(outlined);
            long jM10115getOrange20d7_KjU = other.m10115getOrange20d7_KjU();
            String strStringResource5 = StringResources_androidKt.stringResource(R.string.banned_users, composer, 0);
            boolean zChangedInstance6 = composer.changedInstance(navHostController);
            Object objRememberedValue7 = composer.rememberedValue();
            if (zChangedInstance6 || objRememberedValue7 == companion.getEmpty()) {
                objRememberedValue7 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.setting.a1
                    @Override // lb.a
                    public final Object invoke() {
                        return SettingScreenKt.SettingScreen$lambda$1$3$5$0(navHostController);
                    }
                };
                composer.updateRememberedValue(objRememberedValue7);
            }
            m9983GoSectionBtn3IgeMak(block, jM10115getOrange20d7_KjU, strStringResource5, (lb.a) objRememberedValue7, composer, 0);
            ImageVector brightness4 = Brightness4Kt.getBrightness4(outlined);
            Color.Companion companion4 = Color.INSTANCE;
            long jM5892getBlack0d7_KjU = companion4.m5892getBlack0d7_KjU();
            String strStringResource6 = StringResources_androidKt.stringResource(R.string.themes, composer, 0);
            boolean zChangedInstance7 = composer.changedInstance(navHostController);
            Object objRememberedValue8 = composer.rememberedValue();
            if (zChangedInstance7 || objRememberedValue8 == companion.getEmpty()) {
                objRememberedValue8 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.setting.b1
                    @Override // lb.a
                    public final Object invoke() {
                        return SettingScreenKt.SettingScreen$lambda$1$3$6$0(navHostController);
                    }
                };
                composer.updateRememberedValue(objRememberedValue8);
            }
            m9983GoSectionBtn3IgeMak(brightness4, jM5892getBlack0d7_KjU, strStringResource6, (lb.a) objRememberedValue8, composer, 48);
            ImageVector ballot = BallotKt.getBallot(outlined);
            long jM10111getGreen0d7_KjU = other.m10111getGreen0d7_KjU();
            String strStringResource7 = StringResources_androidKt.stringResource(R.string.permissions, composer, 0);
            Object objRememberedValue9 = composer.rememberedValue();
            if (objRememberedValue9 == companion.getEmpty()) {
                objRememberedValue9 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.setting.c1
                    @Override // lb.a
                    public final Object invoke() {
                        return SettingScreenKt.SettingScreen$lambda$1$3$7$0(mutableState2);
                    }
                };
                composer.updateRememberedValue(objRememberedValue9);
            }
            m9983GoSectionBtn3IgeMak(ballot, jM10111getGreen0d7_KjU, strStringResource7, (lb.a) objRememberedValue9, composer, 3072);
            ImageVector importExport = ImportExportKt.getImportExport(outlined);
            long jM5892getBlack0d7_KjU2 = companion4.m5892getBlack0d7_KjU();
            String strStringResource8 = StringResources_androidKt.stringResource(R.string.import_chats, composer, 0);
            boolean zChangedInstance8 = composer.changedInstance(navHostController);
            Object objRememberedValue10 = composer.rememberedValue();
            if (zChangedInstance8 || objRememberedValue10 == companion.getEmpty()) {
                objRememberedValue10 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.setting.d1
                    @Override // lb.a
                    public final Object invoke() {
                        return SettingScreenKt.SettingScreen$lambda$1$3$8$0(navHostController);
                    }
                };
                composer.updateRememberedValue(objRememberedValue10);
            }
            m9983GoSectionBtn3IgeMak(importExport, jM5892getBlack0d7_KjU2, strStringResource8, (lb.a) objRememberedValue10, composer, 48);
            Integer numValueOf = Integer.valueOf(R.drawable.terms);
            MaterialTheme materialTheme = MaterialTheme.INSTANCE;
            int i11 = MaterialTheme.$stable;
            long secondary = materialTheme.getColorScheme(composer, i11).getSecondary();
            String strStringResource9 = StringResources_androidKt.stringResource(R.string.terms_and_terms_of_use, composer, 0);
            boolean zChangedInstance9 = composer.changedInstance(context);
            Object objRememberedValue11 = composer.rememberedValue();
            if (zChangedInstance9 || objRememberedValue11 == companion.getEmpty()) {
                objRememberedValue11 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.setting.r1
                    @Override // lb.a
                    public final Object invoke() {
                        return SettingScreenKt.SettingScreen$lambda$1$3$9$0(context);
                    }
                };
                composer.updateRememberedValue(objRememberedValue11);
            }
            m9983GoSectionBtn3IgeMak(numValueOf, secondary, strStringResource9, (lb.a) objRememberedValue11, composer, 0);
            ImageVector batterySaver = BatterySaverKt.getBatterySaver(outlined);
            long jM10111getGreen0d7_KjU2 = other.m10111getGreen0d7_KjU();
            String strStringResource10 = StringResources_androidKt.stringResource(R.string.battery_preference, composer, 0);
            boolean zChangedInstance10 = composer.changedInstance(navHostController);
            Object objRememberedValue12 = composer.rememberedValue();
            if (zChangedInstance10 || objRememberedValue12 == companion.getEmpty()) {
                objRememberedValue12 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.setting.n0
                    @Override // lb.a
                    public final Object invoke() {
                        return SettingScreenKt.SettingScreen$lambda$1$3$10$0(navHostController);
                    }
                };
                composer.updateRememberedValue(objRememberedValue12);
            }
            m9983GoSectionBtn3IgeMak(batterySaver, jM10111getGreen0d7_KjU2, strStringResource10, (lb.a) objRememberedValue12, composer, 0);
            float f10 = 30;
            Modifier modifierM1727paddingVpY3zN4$default = PaddingKt.m1727paddingVpY3zN4$default(companion2, Dp.m8823constructorimpl(f10), 0.0f, 2, null);
            float f11 = 10;
            Modifier modifierM1729paddingqDBjuR0$default = PaddingKt.m1729paddingqDBjuR0$default(modifierM1727paddingVpY3zN4$default, 0.0f, Dp.m8823constructorimpl(f11), 0.0f, 0.0f, 13, null);
            boolean zSettingScreen$lambda$1$1 = SettingScreen$lambda$1$1(stateCollectAsStateWithLifecycle2);
            boolean zChangedInstance11 = composer.changedInstance(settingViewModel);
            Object objRememberedValue13 = composer.rememberedValue();
            if (zChangedInstance11 || objRememberedValue13 == companion.getEmpty()) {
                objRememberedValue13 = new SettingScreenKt$SettingScreen$2$1$12$1(settingViewModel);
                composer.updateRememberedValue(objRememberedValue13);
            }
            ComposableSingletons$SettingScreenKt composableSingletons$SettingScreenKt = ComposableSingletons$SettingScreenKt.INSTANCE;
            Z17TextToggleKt.Z17TextToggle(modifierM1729paddingqDBjuR0$default, zSettingScreen$lambda$1$1, (Function1) ((sb.h) objRememberedValue13), composableSingletons$SettingScreenKt.getLambda$1916832291$app_productionPFast(), StringResources_androidKt.stringResource(R.string.request_mode, composer, 0), null, null, composer, 3078, 96);
            float f12 = 80;
            float f13 = 20;
            Z17LabelKt.m10262Z17LabelfWhpE4E(PaddingKt.m1729paddingqDBjuR0$default(companion2, Dp.m8823constructorimpl(f12), 0.0f, Dp.m8823constructorimpl(f13), 0.0f, 10, null), StringResources_androidKt.stringResource(R.string.request_mode_desc, composer, 0), materialTheme.getTypography(composer, i11).getBodyMedium(), 0L, 0, 0, composer, 6, 56);
            Modifier modifierM1729paddingqDBjuR0$default2 = PaddingKt.m1729paddingqDBjuR0$default(PaddingKt.m1727paddingVpY3zN4$default(companion2, Dp.m8823constructorimpl(f10), 0.0f, 2, null), 0.0f, Dp.m8823constructorimpl(f11), 0.0f, 0.0f, 13, null);
            boolean zSettingScreen$lambda$1$0 = SettingScreen$lambda$1$0(stateCollectAsStateWithLifecycle);
            boolean zChangedInstance12 = composer.changedInstance(settingViewModel);
            Object objRememberedValue14 = composer.rememberedValue();
            if (zChangedInstance12 || objRememberedValue14 == companion.getEmpty()) {
                objRememberedValue14 = new SettingScreenKt$SettingScreen$2$1$13$1(settingViewModel);
                composer.updateRememberedValue(objRememberedValue14);
            }
            Z17TextToggleKt.Z17TextToggle(modifierM1729paddingqDBjuR0$default2, zSettingScreen$lambda$1$0, (Function1) ((sb.h) objRememberedValue14), composableSingletons$SettingScreenKt.m9982getLambda$805437734$app_productionPFast(), StringResources_androidKt.stringResource(R.string.sentry_center, composer, 0), null, null, composer, 3078, 96);
            Z17LabelKt.m10262Z17LabelfWhpE4E(PaddingKt.m1729paddingqDBjuR0$default(companion2, Dp.m8823constructorimpl(f12), 0.0f, Dp.m8823constructorimpl(f13), 0.0f, 10, null), StringResources_androidKt.stringResource(R.string.sentry_center_description, composer, 0), materialTheme.getTypography(composer, i11).getBodyMedium(), 0L, 0, 0, composer, 6, 56);
            ImageVector share = ShareKt.getShare(outlined);
            long jM10109getBlue0d7_KjU = other.m10109getBlue0d7_KjU();
            String strStringResource11 = StringResources_androidKt.stringResource(R.string.share_with_others, composer, 0);
            boolean zChangedInstance13 = composer.changedInstance(context);
            Object objRememberedValue15 = composer.rememberedValue();
            if (zChangedInstance13 || objRememberedValue15 == companion.getEmpty()) {
                objRememberedValue15 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.setting.o0
                    @Override // lb.a
                    public final Object invoke() {
                        return SettingScreenKt.SettingScreen$lambda$1$3$13$0(context);
                    }
                };
                composer.updateRememberedValue(objRememberedValue15);
            }
            m9983GoSectionBtn3IgeMak(share, jM10109getBlue0d7_KjU, strStringResource11, (lb.a) objRememberedValue15, composer, 0);
            ImageVector logout = LogoutKt.getLogout(Icons.AutoMirrored.Outlined.INSTANCE);
            long jM10117getPurple0d7_KjU2 = other.m10117getPurple0d7_KjU();
            String strStringResource12 = StringResources_androidKt.stringResource(R.string.logout, composer, 0);
            boolean zChangedInstance14 = composer.changedInstance(navHostController);
            Object objRememberedValue16 = composer.rememberedValue();
            if (zChangedInstance14 || objRememberedValue16 == companion.getEmpty()) {
                objRememberedValue16 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.setting.p0
                    @Override // lb.a
                    public final Object invoke() {
                        return SettingScreenKt.SettingScreen$lambda$1$3$14$0(navHostController);
                    }
                };
                composer.updateRememberedValue(objRememberedValue16);
            }
            m9983GoSectionBtn3IgeMak(logout, jM10117getPurple0d7_KjU2, strStringResource12, (lb.a) objRememberedValue16, composer, 0);
            composer.startReplaceGroup(1956043314);
            composer.endReplaceGroup();
            SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion2, Dp.m8823constructorimpl(100)), composer, 6);
            composer.endNode();
            PermissionsRequesterState permissionsRequesterState = (PermissionsRequesterState) mutableState2.getValue();
            Object objRememberedValue17 = composer.rememberedValue();
            if (objRememberedValue17 == companion.getEmpty()) {
                objRememberedValue17 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.setting.q0
                    @Override // lb.a
                    public final Object invoke() {
                        return ua.k0.f43947a;
                    }
                };
                composer.updateRememberedValue(objRememberedValue17);
            }
            lb.a aVar = (lb.a) objRememberedValue17;
            Object objRememberedValue18 = composer.rememberedValue();
            if (objRememberedValue18 == companion.getEmpty()) {
                mutableState = mutableState2;
                objRememberedValue18 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.setting.r0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return SettingScreenKt.SettingScreen$lambda$1$5$0(mutableState, (PermissionsResult) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue18);
            } else {
                mutableState = mutableState2;
            }
            Z17PermissionRequesterKt.Z17PermissionChecker(null, aVar, permissionsRequesterState, (Function1) objRememberedValue18, composableSingletons$SettingScreenKt.getLambda$1068469690$app_productionPFast(), composer, 27696, 1);
            PermissionsRequesterState permissionsRequesterState2 = (PermissionsRequesterState) mutableState.getValue();
            String packageName = context.getPackageName();
            kotlin.jvm.internal.y.h(packageName, "getPackageName(...)");
            Object objRememberedValue19 = composer.rememberedValue();
            if (objRememberedValue19 == companion.getEmpty()) {
                objRememberedValue19 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.setting.s0
                    @Override // lb.a
                    public final Object invoke() {
                        return SettingScreenKt.SettingScreen$lambda$1$6$0(mutableState);
                    }
                };
                composer.updateRememberedValue(objRememberedValue19);
            }
            lb.a aVar2 = (lb.a) objRememberedValue19;
            Object objRememberedValue20 = composer.rememberedValue();
            if (objRememberedValue20 == companion.getEmpty()) {
                objRememberedValue20 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.setting.t0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return SettingScreenKt.SettingScreen$lambda$1$7$0(mutableState, (PermissionsResult) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue20);
            }
            Z17PermissionRequesterKt.Z17PermissionRequester(permissionsRequesterState2, aVar2, (Function1) objRememberedValue20, packageName, composer, 432);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return ua.k0.f43947a;
    }

    private static final boolean SettingScreen$lambda$1$0(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    private static final boolean SettingScreen$lambda$1$1(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 SettingScreen$lambda$1$3$0$0(NavHostController navHostController) {
        NavController.navigate$default((NavController) navHostController, NavLinks.EDIT_PROFILE, (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 SettingScreen$lambda$1$3$1$0(NavHostController navHostController) {
        NavController.navigate$default((NavController) navHostController, NavLinks.SECRET_ROOM_ACCESS, (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 SettingScreen$lambda$1$3$10$0(NavHostController navHostController) {
        NavController.navigate$default((NavController) navHostController, NavLinks.BATTERY_PREFERENCE, (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 SettingScreen$lambda$1$3$13$0(Context context) {
        IntentUtil.sendInvitation$default(IntentUtil.INSTANCE, context, null, 2, null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 SettingScreen$lambda$1$3$14$0(NavHostController navHostController) {
        NavController.navigate$default((NavController) navHostController, "logout", (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 SettingScreen$lambda$1$3$2$0(NavHostController navHostController) {
        NavController.navigate$default((NavController) navHostController, NavLinks.DATA_PREFERENCES, (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 SettingScreen$lambda$1$3$3$0(NavHostController navHostController) {
        NavController.navigate$default((NavController) navHostController, NavLinks.MUTED_ROOMS, (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 SettingScreen$lambda$1$3$4$0(NavHostController navHostController) {
        NavController.navigate$default((NavController) navHostController, NavLinks.PRIVACY, (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 SettingScreen$lambda$1$3$5$0(NavHostController navHostController) {
        NavController.navigate$default((NavController) navHostController, "blocked", (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 SettingScreen$lambda$1$3$6$0(NavHostController navHostController) {
        NavController.navigate$default((NavController) navHostController, NavLinks.THEME_SELECTOR, (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 SettingScreen$lambda$1$3$7$0(MutableState mutableState) {
        mutableState.setValue(PermissionsRequesterState.copy$default((PermissionsRequesterState) mutableState.getValue(), null, true, null, 5, null));
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 SettingScreen$lambda$1$3$8$0(NavHostController navHostController) {
        NavController.navigate$default((NavController) navHostController, NavLinks.MANAGE_BACKUP, (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 SettingScreen$lambda$1$3$9$0(Context context) {
        IntentUtil.INSTANCE.showWeb(context, "https://www.todus.cu/landing/terms");
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 SettingScreen$lambda$1$5$0(MutableState mutableState, PermissionsResult result) {
        kotlin.jvm.internal.y.i(result, "result");
        mutableState.setValue(PermissionsRequesterState.copy$default((PermissionsRequesterState) mutableState.getValue(), result, false, null, 6, null));
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 SettingScreen$lambda$1$6$0(MutableState mutableState) {
        mutableState.setValue(PermissionsRequesterState.copy$default((PermissionsRequesterState) mutableState.getValue(), null, false, null, 5, null));
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 SettingScreen$lambda$1$7$0(MutableState mutableState, PermissionsResult result) {
        kotlin.jvm.internal.y.i(result, "result");
        mutableState.setValue(PermissionsRequesterState.copy$default((PermissionsRequesterState) mutableState.getValue(), result, false, null, 6, null));
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 SettingScreen$lambda$2(NavHostController navHostController, SettingViewModel settingViewModel, int i10, int i11, Composer composer, int i12) {
        SettingScreen(navHostController, settingViewModel, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return ua.k0.f43947a;
    }
}
