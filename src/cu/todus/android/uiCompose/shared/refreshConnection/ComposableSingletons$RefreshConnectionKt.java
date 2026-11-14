package cu.todus.android.uiCompose.shared.refreshConnection;

import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.e3;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.outlined.RefreshKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ShadowKt;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import cu.todus.android.R;
import cu.todus.android.repositories.MainRepository;
import cu.todus.android.uiCompose.shared.refreshConnection.ComposableSingletons$RefreshConnectionKt;
import cu.z17.views.label.Z17LabelKt;
import cu.z17.views.picture.Z17PictureKt;
import defpackage.l;
import defpackage.r;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.y;
import lb.a;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
public final class ComposableSingletons$RefreshConnectionKt {
    public static final ComposableSingletons$RefreshConnectionKt INSTANCE = new ComposableSingletons$RefreshConnectionKt();

    /* JADX INFO: renamed from: lambda$-1441875558, reason: not valid java name */
    private static Function3 f366lambda$1441875558 = ComposableLambdaKt.composableLambdaInstance(-1441875558, false, new Function3() { // from class: v8.a
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$RefreshConnectionKt.lambda__1441875558$lambda$0((AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 lambda__1441875558$lambda$0(AnimatedVisibilityScope AnimatedVisibility, Composer composer, int i10) {
        y.i(AnimatedVisibility, "$this$AnimatedVisibility");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1441875558, i10, -1, "cu.todus.android.uiCompose.shared.refreshConnection.ComposableSingletons$RefreshConnectionKt.lambda$-1441875558.<anonymous> (RefreshConnection.kt:62)");
        }
        Modifier.Companion companion = Modifier.INSTANCE;
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new a() { // from class: v8.b
                @Override // lb.a
                public final Object invoke() {
                    return ComposableSingletons$RefreshConnectionKt.lambda__1441875558$lambda$0$0$0();
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(ClickableKt.m1240clickableoSLSa3U$default(companion, false, null, null, null, (a) objRememberedValue, 15, null), 0.0f, 1, null);
        MaterialTheme materialTheme = MaterialTheme.INSTANCE;
        int i11 = MaterialTheme.$stable;
        Modifier modifierM1725padding3ABfNKs = PaddingKt.m1725padding3ABfNKs(ShadowKt.m5480shadows4CzXII$default(BackgroundKt.m1205backgroundbw27NRU$default(modifierFillMaxWidth$default, materialTheme.getColorScheme(composer, i11).getBackground(), null, 2, null), Dp.m8823constructorimpl(1), null, false, 0L, 0L, 30, null), Dp.m8823constructorimpl(20));
        MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getCenterVertically(), composer, 48);
        int iA = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
        CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierM1725padding3ABfNKs);
        ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
        a constructor = companion2.getConstructor();
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
        Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyRowMeasurePolicy, companion2.getSetMeasurePolicy());
        Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
        Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion2.getSetCompositeKeyHash());
        Updater.m5182reconcileimpl(composerM5176constructorimpl, companion2.getApplyOnDeactivatedNodeAssertion());
        Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion2.getSetModifier());
        Z17LabelKt.m10262Z17LabelfWhpE4E(PaddingKt.m1729paddingqDBjuR0$default(e3.a(RowScopeInstance.INSTANCE, companion, 1.0f, false, 2, null), 0.0f, 0.0f, Dp.m8823constructorimpl(10), 0.0f, 11, null), StringResources_androidKt.stringResource(R.string.critic_network_error_happens, composer, 0), null, 0L, 0, 0, composer, 0, 60);
        Z17PictureKt.m10278Z17BasePictureC8z9wKI(SizeKt.m1769size3ABfNKs(companion, Dp.m8823constructorimpl(24)), RefreshKt.getRefresh(Icons.Outlined.INSTANCE), null, ColorFilter.Companion.m5907tintxETnrds$default(ColorFilter.INSTANCE, materialTheme.getColorScheme(composer, i11).getOnBackground(), 0, 2, null), null, null, 0, null, null, composer, 6, XMPPTCPConnection.PacketWriter.QUEUE_SIZE);
        composer.endNode();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 lambda__1441875558$lambda$0$0$0() {
        MainRepository instanceOrNull = MainRepository.INSTANCE.getInstanceOrNull();
        if (instanceOrNull != null) {
            instanceOrNull.forceReconnect();
        }
        return k0.f43947a;
    }

    /* JADX INFO: renamed from: getLambda$-1441875558$app_productionPFast, reason: not valid java name */
    public final Function3 m10090getLambda$1441875558$app_productionPFast() {
        return f366lambda$1441875558;
    }
}
