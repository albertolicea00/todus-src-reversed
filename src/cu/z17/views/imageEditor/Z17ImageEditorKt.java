package cu.z17.views.imageEditor;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
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
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.graphics.AndroidImageBitmap_androidKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import androidx.media3.common.C;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.p000activity.compose.BackHandlerKt;
import androidx.p001lifecycle.HasDefaultViewModelProviderFactory;
import androidx.p001lifecycle.Lifecycle;
import androidx.p001lifecycle.LifecycleOwner;
import androidx.p001lifecycle.ViewModel;
import androidx.p001lifecycle.ViewModelProvider;
import androidx.p001lifecycle.ViewModelStoreOwner;
import androidx.p001lifecycle.p002compose.FlowExtKt;
import androidx.p001lifecycle.viewmodel.CreationExtras;
import androidx.p001lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.p001lifecycle.viewmodel.compose.ViewModelKt;
import androidx.profileinstaller.ProfileVerifier;
import cu.todus.android.data.rest.entity.NewEntity;
import cu.z17.views.R;
import cu.z17.views.imageEditor.sections.EditorAnimateVisibilityKt;
import cu.z17.views.imageEditor.sections.cropper.CropperKt;
import cu.z17.views.imageEditor.sections.filter.FilterBottomBarKt;
import cu.z17.views.imageEditor.sections.filter.FilterKt;
import cu.z17.views.imageEditor.sections.filter.FilterTopBarKt;
import cu.z17.views.imageEditor.sections.rotater.RotaterKt;
import cu.z17.views.imageEditor.sections.rotater.RotaterTopBarKt;
import cu.z17.views.imageEditor.sections.text.TextBottomBarKt;
import cu.z17.views.imageEditor.sections.text.TextKt;
import cu.z17.views.imageEditor.sections.text.TextTopBarKt;
import cu.z17.views.imageEditor.sections.viewer.ViewerTopBarKt;
import cu.z17.views.label.Z17LabelKt;
import cu.z17.views.loader.Z17SimpleCircleLoaderKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.z0;
import org.jivesoftware.smackx.muc.packet.MUCInitialPresence;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u001a\u0091\u0001\u0010\u0016\u001a\u00020\u000b2\b\b\u0002\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000b0\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\r2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000b0\n2\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0015\u001a\u00020\u0014H\u0007¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u000f\u0010\u0018\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\u0018\u0010\u0019¨\u0006(²\u0006\f\u0010\u001b\u001a\u00020\u001a8\nX\u008a\u0084\u0002²\u0006\u0012\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c8\nX\u008a\u0084\u0002²\u0006\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u001d8\n@\nX\u008a\u008e\u0002²\u0006\u0010\u0010!\u001a\u0004\u0018\u00010 8\n@\nX\u008a\u008e\u0002²\u0006\f\u0010\"\u001a\u00020\u00068\nX\u008a\u0084\u0002²\u0006\u000e\u0010$\u001a\u00020#8\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010%\u001a\u00020\b8\n@\nX\u008a\u008e\u0002²\u0006\u0012\u0010&\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c8\nX\u008a\u0084\u0002²\u0006\u000e\u0010'\u001a\u00020#8\n@\nX\u008a\u008e\u0002"}, d2 = {"Landroidx/compose/ui/Modifier;", "modifier", "Landroid/net/Uri;", NewEntity.NEWS_CONFIG_SOURCE, "", "imagePathToSave", "", "firstCompression", "", "initialRotation", "Lkotlin/Function1;", "Lua/k0;", "onViewState", "Lkotlin/Function0;", "onError", "onEdited", "Lcu/z17/views/imageEditor/Z17ImageEditorViewModel;", "viewModel", "Landroid/content/Context;", "context", "Lcu/z17/views/imageEditor/ImageEditorConfigurations;", "configs", "Z17ImageEditor", "(Landroidx/compose/ui/Modifier;Landroid/net/Uri;Ljava/lang/String;ZFLkotlin/jvm/functions/Function1;Llb/a;Lkotlin/jvm/functions/Function1;Lcu/z17/views/imageEditor/Z17ImageEditorViewModel;Landroid/content/Context;Lcu/z17/views/imageEditor/ImageEditorConfigurations;Landroidx/compose/runtime/Composer;III)V", "Loading", "(Landroidx/compose/runtime/Composer;I)V", "Lcu/z17/views/imageEditor/Z17EditorState;", "currentState", "", "Landroid/graphics/Bitmap;", MUCInitialPresence.History.ELEMENT, "actualBitmap", "Landroidx/compose/ui/geometry/Rect;", "capturingViewBounds", "isOnView", "", "currentColor", "degrees", "filteredBitmaps", "filterSelected", "views_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class Z17ImageEditorKt {
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void Loading(Composer composer, final int i10) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-1090993742);
        if (composerStartRestartGroup.shouldExecute(i10 != 0, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1090993742, i10, -1, "cu.z17.views.imageEditor.Loading (Z17ImageEditor.kt:363)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(companion, 0.0f, 1, null);
            MaterialTheme materialTheme = MaterialTheme.INSTANCE;
            int i11 = MaterialTheme.$stable;
            Modifier modifierM1205backgroundbw27NRU$default = BackgroundKt.m1205backgroundbw27NRU$default(modifierFillMaxSize$default, materialTheme.getColorScheme(composerStartRestartGroup, i11).getBackground(), null, 2, null);
            Alignment.Companion companion2 = Alignment.INSTANCE;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion2.getCenter(), false);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1205backgroundbw27NRU$default);
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
            Function2 setCompositeKeyHash = companion3.getSetCompositeKeyHash();
            if (composerM5176constructorimpl.getInserting() || !kotlin.jvm.internal.y.d(composerM5176constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion3.getSetModifier());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), companion2.getCenterHorizontally(), composerStartRestartGroup, 48);
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
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
            Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyColumnMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash2 = companion3.getSetCompositeKeyHash();
            if (composerM5176constructorimpl2.getInserting() || !kotlin.jvm.internal.y.d(composerM5176constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                composerM5176constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                composerM5176constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier2, companion3.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            Z17SimpleCircleLoaderKt.m10265Z17SimpleCircleLoaderZij2fk(null, 0.0f, 0.0f, 0L, composerStartRestartGroup, 0, 15);
            Modifier modifierM1725padding3ABfNKs = PaddingKt.m1725padding3ABfNKs(companion, Dp.m8823constructorimpl(5));
            Color.Companion companion4 = Color.INSTANCE;
            Z17LabelKt.m10262Z17LabelfWhpE4E(PaddingKt.m1725padding3ABfNKs(BackgroundKt.m1204backgroundbw27NRU(modifierM1725padding3ABfNKs, Color.m5865copywmQWz5c$default(companion4.m5892getBlack0d7_KjU(), 0.5f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(15))), Dp.m8823constructorimpl(10)), StringResources_androidKt.stringResource(R.string.processing_wait, composerStartRestartGroup, 0), materialTheme.getTypography(composerStartRestartGroup, i11).getLabelSmall(), companion4.m5903getWhite0d7_KjU(), 0, 0, composerStartRestartGroup, 3072, 48);
            composerStartRestartGroup = composerStartRestartGroup;
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.imageEditor.x
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return Z17ImageEditorKt.Loading$lambda$99(i10, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 Loading$lambda$99(int i10, Composer composer, int i11) {
        Loading(composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1));
        return ua.k0.f43947a;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0139  */
    /* JADX WARN: Code duplicated, block: B:102:0x013f  */
    /* JADX WARN: Code duplicated, block: B:103:0x0142  */
    /* JADX WARN: Code duplicated, block: B:105:0x0147  */
    /* JADX WARN: Code duplicated, block: B:108:0x0157  */
    /* JADX WARN: Code duplicated, block: B:112:0x015f  */
    /* JADX WARN: Code duplicated, block: B:115:0x0168  */
    /* JADX WARN: Code duplicated, block: B:117:0x0178  */
    /* JADX WARN: Code duplicated, block: B:127:0x019d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:128:0x019f  */
    /* JADX WARN: Code duplicated, block: B:129:0x01a2  */
    /* JADX WARN: Code duplicated, block: B:131:0x01a5  */
    /* JADX WARN: Code duplicated, block: B:133:0x01a8  */
    /* JADX WARN: Code duplicated, block: B:134:0x01ab  */
    /* JADX WARN: Code duplicated, block: B:137:0x01b0  */
    /* JADX WARN: Code duplicated, block: B:139:0x01be  */
    /* JADX WARN: Code duplicated, block: B:141:0x01c2  */
    /* JADX WARN: Code duplicated, block: B:143:0x01cc  */
    /* JADX WARN: Code duplicated, block: B:145:0x01ed  */
    /* JADX WARN: Code duplicated, block: B:147:0x01f5  */
    /* JADX WARN: Code duplicated, block: B:150:0x01fe  */
    /* JADX WARN: Code duplicated, block: B:152:0x020e  */
    /* JADX WARN: Code duplicated, block: B:154:0x022c  */
    /* JADX WARN: Code duplicated, block: B:157:0x023e  */
    /* JADX WARN: Code duplicated, block: B:158:0x0249  */
    /* JADX WARN: Code duplicated, block: B:161:0x0299  */
    /* JADX WARN: Code duplicated, block: B:164:0x02a5  */
    /* JADX WARN: Code duplicated, block: B:165:0x02a9  */
    /* JADX WARN: Code duplicated, block: B:168:0x02ca  */
    /* JADX WARN: Code duplicated, block: B:170:0x02d8  */
    /* JADX WARN: Code duplicated, block: B:173:0x032c  */
    /* JADX WARN: Code duplicated, block: B:176:0x0340  */
    /* JADX WARN: Code duplicated, block: B:179:0x0356  */
    /* JADX WARN: Code duplicated, block: B:180:0x0362  */
    /* JADX WARN: Code duplicated, block: B:183:0x0370  */
    /* JADX WARN: Code duplicated, block: B:186:0x038a  */
    /* JADX WARN: Code duplicated, block: B:187:0x03f1  */
    /* JADX WARN: Code duplicated, block: B:190:0x0401  */
    /* JADX WARN: Code duplicated, block: B:193:0x0418  */
    /* JADX WARN: Code duplicated, block: B:196:0x044e  */
    /* JADX WARN: Code duplicated, block: B:197:0x0457  */
    /* JADX WARN: Code duplicated, block: B:200:0x0498  */
    /* JADX WARN: Code duplicated, block: B:203:0x04a4  */
    /* JADX WARN: Code duplicated, block: B:204:0x04a8  */
    /* JADX WARN: Code duplicated, block: B:207:0x04c9  */
    /* JADX WARN: Code duplicated, block: B:209:0x04d7  */
    /* JADX WARN: Code duplicated, block: B:212:0x0530  */
    /* JADX WARN: Code duplicated, block: B:214:0x0536  */
    /* JADX WARN: Code duplicated, block: B:217:0x0560  */
    /* JADX WARN: Code duplicated, block: B:219:0x0566  */
    /* JADX WARN: Code duplicated, block: B:222:0x0590  */
    /* JADX WARN: Code duplicated, block: B:224:0x0596  */
    /* JADX WARN: Code duplicated, block: B:227:0x05c0  */
    /* JADX WARN: Code duplicated, block: B:229:0x05c6  */
    /* JADX WARN: Code duplicated, block: B:232:0x0604  */
    /* JADX WARN: Code duplicated, block: B:235:0x0610  */
    /* JADX WARN: Code duplicated, block: B:236:0x0614  */
    /* JADX WARN: Code duplicated, block: B:239:0x0635  */
    /* JADX WARN: Code duplicated, block: B:241:0x0643  */
    /* JADX WARN: Code duplicated, block: B:244:0x066c  */
    /* JADX WARN: Code duplicated, block: B:246:0x0672  */
    /* JADX WARN: Code duplicated, block: B:249:0x069e  */
    /* JADX WARN: Code duplicated, block: B:251:0x06a4  */
    /* JADX WARN: Code duplicated, block: B:254:0x06d2  */
    /* JADX WARN: Code duplicated, block: B:256:0x06d8  */
    /* JADX WARN: Code duplicated, block: B:259:0x0704  */
    /* JADX WARN: Code duplicated, block: B:261:0x070a  */
    /* JADX WARN: Code duplicated, block: B:264:0x0736  */
    /* JADX WARN: Code duplicated, block: B:266:0x073c  */
    /* JADX WARN: Code duplicated, block: B:269:0x0753  */
    /* JADX WARN: Code duplicated, block: B:274:0x0764  */
    /* JADX WARN: Code duplicated, block: B:277:0x078f  */
    /* JADX WARN: Code duplicated, block: B:279:0x0795  */
    /* JADX WARN: Code duplicated, block: B:282:0x07cb  */
    /* JADX WARN: Code duplicated, block: B:284:0x07d1  */
    /* JADX WARN: Code duplicated, block: B:287:0x07e7  */
    /* JADX WARN: Code duplicated, block: B:289:0x07f7  */
    /* JADX WARN: Code duplicated, block: B:291:0x07fd  */
    /* JADX WARN: Code duplicated, block: B:294:0x0810  */
    /* JADX WARN: Code duplicated, block: B:297:0x082d  */
    /* JADX WARN: Code duplicated, block: B:298:0x082f  */
    /* JADX WARN: Code duplicated, block: B:301:0x0837  */
    /* JADX WARN: Code duplicated, block: B:302:0x0839  */
    /* JADX WARN: Code duplicated, block: B:305:0x0843  */
    /* JADX WARN: Code duplicated, block: B:306:0x0845  */
    /* JADX WARN: Code duplicated, block: B:309:0x084d  */
    /* JADX WARN: Code duplicated, block: B:313:0x085c  */
    /* JADX WARN: Code duplicated, block: B:316:0x0881  */
    /* JADX WARN: Code duplicated, block: B:317:0x0883  */
    /* JADX WARN: Code duplicated, block: B:320:0x0890  */
    /* JADX WARN: Code duplicated, block: B:321:0x0892  */
    /* JADX WARN: Code duplicated, block: B:324:0x089a  */
    /* JADX WARN: Code duplicated, block: B:328:0x08a7  */
    /* JADX WARN: Code duplicated, block: B:332:0x08d2  */
    /* JADX WARN: Code duplicated, block: B:335:0x08da  */
    /* JADX WARN: Code duplicated, block: B:337:0x08e0  */
    /* JADX WARN: Code duplicated, block: B:340:0x08fa  */
    /* JADX WARN: Code duplicated, block: B:342:0x0900  */
    /* JADX WARN: Code duplicated, block: B:345:0x0916  */
    /* JADX WARN: Code duplicated, block: B:348:0x0924  */
    /* JADX WARN: Code duplicated, block: B:351:0x093b  */
    /* JADX WARN: Code duplicated, block: B:353:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:51:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:53:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:54:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:58:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:60:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:61:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:65:0x00db  */
    /* JADX WARN: Code duplicated, block: B:67:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:68:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:70:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:73:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:81:0x0107  */
    /* JADX WARN: Code duplicated, block: B:84:0x010f  */
    /* JADX WARN: Code duplicated, block: B:86:0x0113  */
    /* JADX WARN: Code duplicated, block: B:88:0x011b  */
    /* JADX WARN: Code duplicated, block: B:89:0x011e  */
    /* JADX WARN: Code duplicated, block: B:93:0x0127  */
    /* JADX WARN: Code duplicated, block: B:96:0x012e  */
    /* JADX WARN: Code duplicated, block: B:98:0x0133  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void Z17ImageEditor(Modifier modifier, final Uri source, final String imagePathToSave, boolean z10, float f10, Function1 onViewState, lb.a onError, final Function1 onEdited, Z17ImageEditorViewModel z17ImageEditorViewModel, Context context, ImageEditorConfigurations imageEditorConfigurations, Composer composer, final int i10, final int i11, final int i12) {
        Modifier modifier2;
        int i13;
        int i14;
        boolean z11;
        float f11;
        int i15;
        int i16;
        Context context2;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        boolean z12;
        Function1 function1;
        Function1 function2;
        lb.a aVar;
        final Z17ImageEditorViewModel z17ImageEditorViewModel2;
        final Context context3;
        final Modifier modifier3;
        Composer composer2;
        final float f12;
        final ImageEditorConfigurations imageEditorConfigurations2;
        final boolean z13;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier modifier4;
        float f13;
        Composer composer3;
        Z17ImageEditorViewModel z17ImageEditorViewModel3;
        ImageEditorConfigurations imageEditorConfigurations3;
        float f14;
        String path;
        ViewModelStoreOwner current;
        CreationExtras defaultViewModelCreationExtras;
        int i22;
        Color.Companion companion;
        int currentCompositeKeyHash;
        int i23;
        lb.a constructor;
        Composer composerM5176constructorimpl;
        Function2 setCompositeKeyHash;
        Composer composer4;
        final State stateCollectAsStateWithLifecycle;
        final State stateCollectAsStateWithLifecycle2;
        Object objRememberedValue;
        Composer.Companion companion2;
        MutableState mutableState;
        Object objRememberedValue2;
        Object objRememberedValue3;
        Object objRememberedValue4;
        State state;
        Object objRememberedValue5;
        Object objQ;
        Object objRememberedValue6;
        Object objRememberedValue7;
        Object objRememberedValue8;
        int currentCompositeKeyHash2;
        lb.a constructor2;
        Composer composerM5176constructorimpl2;
        Function2 setCompositeKeyHash2;
        boolean z14;
        boolean zChanged;
        Object objRememberedValue9;
        boolean zChanged2;
        Object objRememberedValue10;
        boolean zChanged3;
        Object objRememberedValue11;
        boolean zChanged4;
        Object objRememberedValue12;
        int currentCompositeKeyHash3;
        lb.a constructor3;
        Composer composerM5176constructorimpl3;
        Function2 setCompositeKeyHash3;
        boolean zChanged5;
        Object objRememberedValue13;
        boolean zChanged6;
        Object objRememberedValue14;
        boolean zChanged7;
        Object objRememberedValue15;
        boolean zChanged8;
        Object objRememberedValue16;
        boolean zChanged9;
        Object objRememberedValue17;
        boolean zChanged10;
        Object objRememberedValue18;
        final Z17ImageEditorViewModel z17ImageEditorViewModel4;
        boolean zChanged11;
        Object objRememberedValue19;
        boolean z15;
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        Object objRememberedValue20;
        int i24;
        boolean z20;
        boolean z21;
        boolean z22;
        Object objRememberedValue21;
        ab.e eVar;
        boolean z23;
        Object objRememberedValue22;
        boolean zChangedInstance;
        Object objRememberedValue23;
        boolean zChangedInstance2;
        Object objRememberedValue24;
        int i25;
        int i26;
        int i27;
        kotlin.jvm.internal.y.i(source, "source");
        kotlin.jvm.internal.y.i(imagePathToSave, "imagePathToSave");
        kotlin.jvm.internal.y.i(onViewState, "onViewState");
        kotlin.jvm.internal.y.i(onError, "onError");
        kotlin.jvm.internal.y.i(onEdited, "onEdited");
        Composer composerStartRestartGroup = composer.startRestartGroup(804632538);
        int i28 = i12 & 1;
        if (i28 != 0) {
            i13 = i10 | 6;
            modifier2 = modifier;
        } else if ((i10 & 6) == 0) {
            modifier2 = modifier;
            i13 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i10;
        } else {
            modifier2 = modifier;
            i13 = i10;
        }
        if ((i10 & 48) == 0) {
            i13 |= composerStartRestartGroup.changedInstance(source) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i13 |= composerStartRestartGroup.changed(imagePathToSave) ? 256 : 128;
        }
        int i29 = i12 & 8;
        if (i29 != 0) {
            i13 |= 3072;
            z11 = z10;
            i14 = 4;
        } else {
            i14 = 4;
            if ((i10 & 3072) == 0) {
                z11 = z10;
                i13 |= composerStartRestartGroup.changed(z11) ? 2048 : 1024;
            } else {
                z11 = z10;
            }
        }
        int i30 = i12 & 16;
        if (i30 == 0) {
            if ((i10 & 24576) == 0) {
                f11 = f10;
                i13 |= composerStartRestartGroup.changed(f11) ? 16384 : 8192;
            }
            if ((i10 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                if (composerStartRestartGroup.changedInstance(onViewState)) {
                    i27 = 131072;
                } else {
                    i27 = 65536;
                }
                i13 |= i27;
            }
            if ((i10 & 1572864) == 0) {
                if (composerStartRestartGroup.changedInstance(onError)) {
                    i26 = 1048576;
                } else {
                    i26 = 524288;
                }
                i13 |= i26;
            }
            i15 = i13;
            if ((i10 & 12582912) == 0) {
                if (composerStartRestartGroup.changedInstance(onEdited)) {
                    i25 = 8388608;
                } else {
                    i25 = 4194304;
                }
                i16 = i15 | i25;
            } else {
                i16 = i15;
            }
            if ((i10 & 100663296) != 0) {
                i16 |= ((i12 & 256) == 0 || !composerStartRestartGroup.changedInstance(z17ImageEditorViewModel)) ? 33554432 : 67108864;
            }
            if ((i10 & 805306368) == 0) {
                if ((i12 & 512) == 0) {
                    context2 = context;
                    int i31 = composerStartRestartGroup.changedInstance(context2) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
                    i16 |= i31;
                } else {
                    context2 = context;
                }
                i16 |= i31;
            } else {
                context2 = context;
            }
            i17 = i16;
            i18 = i12 & 1024;
            if (i18 != 0) {
                if ((i11 & 6) == 0) {
                    if (composerStartRestartGroup.changed(imageEditorConfigurations)) {
                        i20 = i14;
                    } else {
                        i20 = 2;
                    }
                    i21 = i11 | i20;
                } else {
                    i19 = i11;
                }
                if ((i17 & 306783379) == 306783378 || (i19 & 3) != 2) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z12, i17 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    if ((i10 & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        if (i28 != 0) {
                            modifier4 = Modifier.INSTANCE;
                        } else {
                            modifier4 = modifier2;
                        }
                        if (i29 != 0) {
                            z11 = false;
                        }
                        if (i30 != 0) {
                            f13 = 0.0f;
                        } else {
                            f13 = f11;
                        }
                        if ((i12 & 256) != 0) {
                            path = source.getPath();
                            current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composerStartRestartGroup, 6);
                            if (current == null) {
                                throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                            }
                            if (current instanceof HasDefaultViewModelProviderFactory) {
                                defaultViewModelCreationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                            } else {
                                defaultViewModelCreationExtras = CreationExtras.Empty.INSTANCE;
                            }
                            ViewModel viewModel = ViewModelKt.viewModel(z0.b(Z17ImageEditorViewModel.class), current, path, (ViewModelProvider.Factory) null, defaultViewModelCreationExtras, composerStartRestartGroup, 0, 0);
                            composer3 = composerStartRestartGroup;
                            z17ImageEditorViewModel3 = (Z17ImageEditorViewModel) viewModel;
                            i17 &= -234881025;
                        } else {
                            composer3 = composerStartRestartGroup;
                            z17ImageEditorViewModel3 = z17ImageEditorViewModel;
                        }
                        if ((i12 & 512) != 0) {
                            context2 = (Context) composer3.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                            i17 &= -1879048193;
                        }
                        if (i18 != 0) {
                            imageEditorConfigurations3 = new ImageEditorConfigurations(false, false, false, false, false, 27, null);
                        } else {
                            imageEditorConfigurations3 = imageEditorConfigurations;
                        }
                        f14 = f13;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i12 & 256) != 0) {
                            i17 &= -234881025;
                        }
                        if ((i12 & 512) != 0) {
                            i17 &= -1879048193;
                        }
                        z11 = z11;
                        context2 = context2;
                        modifier4 = modifier2;
                        i17 = i17;
                        imageEditorConfigurations3 = imageEditorConfigurations;
                        f14 = f11;
                        composer3 = composerStartRestartGroup;
                        z17ImageEditorViewModel3 = z17ImageEditorViewModel;
                    }
                    composer3.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        i22 = 1;
                        ComposerKt.traceEventStart(804632538, i17, i19, "cu.z17.views.imageEditor.Z17ImageEditor (Z17ImageEditor.kt:72)");
                    } else {
                        i22 = 1;
                    }
                    companion = Color.INSTANCE;
                    Modifier modifierM1205backgroundbw27NRU$default = BackgroundKt.m1205backgroundbw27NRU$default(modifier4, Color.m5865copywmQWz5c$default(companion.m5900getRed0d7_KjU(), 0.15f, 0.0f, 0.0f, 0.0f, 14, null), null, 2, null);
                    Modifier modifier5 = modifier4;
                    Alignment.Companion companion3 = Alignment.INSTANCE;
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion3.getTopStart(), false);
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                    CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer3, modifierM1205backgroundbw27NRU$default);
                    ComposeUiNode.Companion companion4 = ComposeUiNode.INSTANCE;
                    i23 = i17;
                    constructor = companion4.getConstructor();
                    if (!defpackage.r.a(composer3.getApplier())) {
                        ComposablesKt.invalidApplier();
                    }
                    composer3.startReusableNode();
                    if (composer3.getInserting()) {
                        composer3.createNode(constructor);
                    } else {
                        composer3.useNode();
                    }
                    composerM5176constructorimpl = Updater.m5176constructorimpl(composer3);
                    final Z17ImageEditorViewModel z17ImageEditorViewModel5 = z17ImageEditorViewModel3;
                    Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, companion4.getSetMeasurePolicy());
                    Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion4.getSetResolvedCompositionLocals());
                    setCompositeKeyHash = companion4.getSetCompositeKeyHash();
                    if (composerM5176constructorimpl.getInserting() || !kotlin.jvm.internal.y.d(composerM5176constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion4.getSetModifier());
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                    composer4 = composer3;
                    stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(z17ImageEditorViewModel5.getCurrentState(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composer4, 0, 7);
                    stateCollectAsStateWithLifecycle2 = FlowExtKt.collectAsStateWithLifecycle(z17ImageEditorViewModel5.getHistory().getValue(), va.w.n(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composer4, 48, 14);
                    objRememberedValue = composer4.rememberedValue();
                    companion2 = Composer.INSTANCE;
                    if (objRememberedValue == companion2.getEmpty()) {
                        objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                        composer4.updateRememberedValue(objRememberedValue);
                    }
                    mutableState = (MutableState) objRememberedValue;
                    objRememberedValue2 = composer4.rememberedValue();
                    if (objRememberedValue2 == companion2.getEmpty()) {
                        objRememberedValue2 = new FocusRequester();
                        composer4.updateRememberedValue(objRememberedValue2);
                    }
                    final FocusRequester focusRequester = (FocusRequester) objRememberedValue2;
                    objRememberedValue3 = composer4.rememberedValue();
                    if (objRememberedValue3 == companion2.getEmpty()) {
                        objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                        composer4.updateRememberedValue(objRememberedValue3);
                    }
                    final MutableState mutableState2 = (MutableState) objRememberedValue3;
                    objRememberedValue4 = composer4.rememberedValue();
                    if (objRememberedValue4 == companion2.getEmpty()) {
                        objRememberedValue4 = SnapshotStateKt.derivedStateOf(new lb.a() { // from class: cu.z17.views.imageEditor.h
                            @Override // lb.a
                            public final Object invoke() {
                                return Boolean.valueOf(Z17ImageEditorKt.Z17ImageEditor$lambda$95$lambda$10$lambda$9(stateCollectAsStateWithLifecycle));
                            }
                        });
                        composer4.updateRememberedValue(objRememberedValue4);
                    }
                    state = (State) objRememberedValue4;
                    objRememberedValue5 = composer4.rememberedValue();
                    if (objRememberedValue5 == companion2.getEmpty()) {
                        Color colorM5856boximpl = Color.m5856boximpl(companion.m5903getWhite0d7_KjU());
                        Color colorM5856boximpl2 = Color.m5856boximpl(companion.m5892getBlack0d7_KjU());
                        Color colorM5856boximpl3 = Color.m5856boximpl(ColorKt.Color(4294940672L));
                        Color colorM5856boximpl4 = Color.m5856boximpl(ColorKt.Color(4291176488L));
                        Color colorM5856boximpl5 = Color.m5856boximpl(ColorKt.Color(4283215696L));
                        Color colorM5856boximpl6 = Color.m5856boximpl(ColorKt.Color(4288423856L));
                        Color[] colorArr = new Color[6];
                        colorArr[0] = colorM5856boximpl;
                        colorArr[i22] = colorM5856boximpl2;
                        colorArr[2] = colorM5856boximpl3;
                        colorArr[3] = colorM5856boximpl4;
                        colorArr[i14] = colorM5856boximpl5;
                        colorArr[5] = colorM5856boximpl6;
                        objQ = va.w.q(colorArr);
                        composer4.updateRememberedValue(objQ);
                    } else {
                        objQ = objRememberedValue5;
                    }
                    final List list = (List) objQ;
                    objRememberedValue6 = composer4.rememberedValue();
                    if (objRememberedValue6 == companion2.getEmpty()) {
                        objRememberedValue6 = SnapshotIntStateKt.mutableIntStateOf(0);
                        composer4.updateRememberedValue(objRememberedValue6);
                    }
                    final MutableIntState mutableIntState = (MutableIntState) objRememberedValue6;
                    objRememberedValue7 = composer4.rememberedValue();
                    if (objRememberedValue7 == companion2.getEmpty()) {
                        objRememberedValue7 = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
                        composer4.updateRememberedValue(objRememberedValue7);
                    }
                    final MutableFloatState mutableFloatState = (MutableFloatState) objRememberedValue7;
                    final State stateCollectAsStateWithLifecycle3 = FlowExtKt.collectAsStateWithLifecycle(z17ImageEditorViewModel5.getFilteredBitmaps().getValue(), va.w.n(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composer4, 48, 14);
                    objRememberedValue8 = composer4.rememberedValue();
                    if (objRememberedValue8 == companion2.getEmpty()) {
                        objRememberedValue8 = SnapshotIntStateKt.mutableIntStateOf(0);
                        composer4.updateRememberedValue(objRememberedValue8);
                    }
                    final MutableIntState mutableIntState2 = (MutableIntState) objRememberedValue8;
                    Modifier.Companion companion5 = Modifier.INSTANCE;
                    final Context context4 = context2;
                    final ImageEditorConfigurations imageEditorConfigurations4 = imageEditorConfigurations3;
                    Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(companion5, 0.0f, i22, null);
                    MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), companion3.getStart(), composer4, 0);
                    currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                    CompositionLocalMap currentCompositionLocalMap2 = composer4.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer4, modifierFillMaxSize$default);
                    constructor2 = companion4.getConstructor();
                    if (!defpackage.r.a(composer4.getApplier())) {
                        ComposablesKt.invalidApplier();
                    }
                    composer4.startReusableNode();
                    if (composer4.getInserting()) {
                        composer4.createNode(constructor2);
                    } else {
                        composer4.useNode();
                    }
                    composerM5176constructorimpl2 = Updater.m5176constructorimpl(composer4);
                    Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyColumnMeasurePolicy, companion4.getSetMeasurePolicy());
                    Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap2, companion4.getSetResolvedCompositionLocals());
                    setCompositeKeyHash2 = companion4.getSetCompositeKeyHash();
                    if (composerM5176constructorimpl2.getInserting() || !kotlin.jvm.internal.y.d(composerM5176constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                        composerM5176constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                        composerM5176constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                    }
                    Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier2, companion4.getSetModifier());
                    ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                    Bitmap bitmapZ17ImageEditor$lambda$95$lambda$3 = Z17ImageEditor$lambda$95$lambda$3(mutableState);
                    z14 = z11;
                    ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(272879167, true, new Function3() { // from class: cu.z17.views.imageEditor.t
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return Z17ImageEditorKt.Z17ImageEditor$lambda$95$lambda$86$lambda$27(z17ImageEditorViewModel5, imagePathToSave, context4, imageEditorConfigurations4, stateCollectAsStateWithLifecycle2, (Bitmap) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composer4, 54);
                    zChanged = composer4.changed(stateCollectAsStateWithLifecycle);
                    objRememberedValue9 = composer4.rememberedValue();
                    if (zChanged || objRememberedValue9 == companion2.getEmpty()) {
                        objRememberedValue9 = new lb.a() { // from class: cu.z17.views.imageEditor.a0
                            @Override // lb.a
                            public final Object invoke() {
                                return Boolean.valueOf(Z17ImageEditorKt.Z17ImageEditor$lambda$95$lambda$86$lambda$29$lambda$28(stateCollectAsStateWithLifecycle));
                            }
                        };
                        composer4.updateRememberedValue(objRememberedValue9);
                    }
                    EditorAnimateVisibilityKt.EditorAnimateVisibility(bitmapZ17ImageEditor$lambda$95$lambda$3, composableLambdaRememberComposableLambda, (lb.a) objRememberedValue9, composer4, 48);
                    Bitmap bitmapZ17ImageEditor$lambda$95$lambda$4 = Z17ImageEditor$lambda$95$lambda$3(mutableState);
                    ComposableLambda composableLambdaRememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(132330614, true, new Function3() { // from class: cu.z17.views.imageEditor.b0
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return Z17ImageEditorKt.Z17ImageEditor$lambda$95$lambda$86$lambda$32(list, mutableIntState, (Bitmap) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composer4, 54);
                    zChanged2 = composer4.changed(stateCollectAsStateWithLifecycle);
                    objRememberedValue10 = composer4.rememberedValue();
                    if (zChanged2 || objRememberedValue10 == companion2.getEmpty()) {
                        objRememberedValue10 = new lb.a() { // from class: cu.z17.views.imageEditor.c0
                            @Override // lb.a
                            public final Object invoke() {
                                return Boolean.valueOf(Z17ImageEditorKt.Z17ImageEditor$lambda$95$lambda$86$lambda$34$lambda$33(stateCollectAsStateWithLifecycle));
                            }
                        };
                        composer4.updateRememberedValue(objRememberedValue10);
                    }
                    EditorAnimateVisibilityKt.EditorAnimateVisibility(bitmapZ17ImageEditor$lambda$95$lambda$4, composableLambdaRememberComposableLambda2, (lb.a) objRememberedValue10, composer4, 48);
                    Bitmap bitmapZ17ImageEditor$lambda$95$lambda$5 = Z17ImageEditor$lambda$95$lambda$3(mutableState);
                    ComposableLambda composableLambdaRememberComposableLambda3 = ComposableLambdaKt.rememberComposableLambda(-1583267977, true, new Function3() { // from class: cu.z17.views.imageEditor.d0
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return Z17ImageEditorKt.Z17ImageEditor$lambda$95$lambda$86$lambda$37(mutableFloatState, (Bitmap) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composer4, 54);
                    zChanged3 = composer4.changed(stateCollectAsStateWithLifecycle);
                    objRememberedValue11 = composer4.rememberedValue();
                    if (zChanged3 || objRememberedValue11 == companion2.getEmpty()) {
                        objRememberedValue11 = new lb.a() { // from class: cu.z17.views.imageEditor.e0
                            @Override // lb.a
                            public final Object invoke() {
                                return Boolean.valueOf(Z17ImageEditorKt.Z17ImageEditor$lambda$95$lambda$86$lambda$39$lambda$38(stateCollectAsStateWithLifecycle));
                            }
                        };
                        composer4.updateRememberedValue(objRememberedValue11);
                    }
                    EditorAnimateVisibilityKt.EditorAnimateVisibility(bitmapZ17ImageEditor$lambda$95$lambda$5, composableLambdaRememberComposableLambda3, (lb.a) objRememberedValue11, composer4, 48);
                    Bitmap bitmapZ17ImageEditor$lambda$95$lambda$6 = Z17ImageEditor$lambda$95$lambda$3(mutableState);
                    ComposableLambda composableLambdaRememberComposableLambda4 = ComposableLambdaKt.rememberComposableLambda(996100728, true, new Function3() { // from class: cu.z17.views.imageEditor.f0
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return Z17ImageEditorKt.Z17ImageEditor$lambda$95$lambda$86$lambda$42(stateCollectAsStateWithLifecycle3, mutableIntState2, (Bitmap) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composer4, 54);
                    zChanged4 = composer4.changed(stateCollectAsStateWithLifecycle);
                    objRememberedValue12 = composer4.rememberedValue();
                    if (zChanged4 || objRememberedValue12 == companion2.getEmpty()) {
                        objRememberedValue12 = new lb.a() { // from class: cu.z17.views.imageEditor.g0
                            @Override // lb.a
                            public final Object invoke() {
                                return Boolean.valueOf(Z17ImageEditorKt.Z17ImageEditor$lambda$95$lambda$86$lambda$44$lambda$43(stateCollectAsStateWithLifecycle));
                            }
                        };
                        composer4.updateRememberedValue(objRememberedValue12);
                    }
                    EditorAnimateVisibilityKt.EditorAnimateVisibility(bitmapZ17ImageEditor$lambda$95$lambda$6, composableLambdaRememberComposableLambda4, (lb.a) objRememberedValue12, composer4, 48);
                    Modifier modifierA = androidx.compose.foundation.layout.x.a(columnScopeInstance, companion5, 1.0f, false, 2, null);
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(companion3.getTopStart(), false);
                    currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                    CompositionLocalMap currentCompositionLocalMap3 = composer4.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composer4, modifierA);
                    constructor3 = companion4.getConstructor();
                    if (!defpackage.r.a(composer4.getApplier())) {
                        ComposablesKt.invalidApplier();
                    }
                    composer4.startReusableNode();
                    if (composer4.getInserting()) {
                        composer4.createNode(constructor3);
                    } else {
                        composer4.useNode();
                    }
                    composerM5176constructorimpl3 = Updater.m5176constructorimpl(composer4);
                    Updater.m5184setimpl(composerM5176constructorimpl3, measurePolicyMaybeCachedBoxMeasurePolicy2, companion4.getSetMeasurePolicy());
                    Updater.m5184setimpl(composerM5176constructorimpl3, currentCompositionLocalMap3, companion4.getSetResolvedCompositionLocals());
                    setCompositeKeyHash3 = companion4.getSetCompositeKeyHash();
                    if (composerM5176constructorimpl3.getInserting() || !kotlin.jvm.internal.y.d(composerM5176constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                        composerM5176constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                        composerM5176constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                    }
                    Updater.m5184setimpl(composerM5176constructorimpl3, modifierMaterializeModifier3, companion4.getSetModifier());
                    Bitmap bitmapZ17ImageEditor$lambda$95$lambda$7 = Z17ImageEditor$lambda$95$lambda$3(mutableState);
                    Function3 function3M10147getLambda$1781389051$views_release = ComposableSingletons$Z17ImageEditorKt.INSTANCE.m10147getLambda$1781389051$views_release();
                    zChanged5 = composer4.changed(stateCollectAsStateWithLifecycle);
                    objRememberedValue13 = composer4.rememberedValue();
                    if (zChanged5 || objRememberedValue13 == companion2.getEmpty()) {
                        objRememberedValue13 = new lb.a() { // from class: cu.z17.views.imageEditor.h0
                            @Override // lb.a
                            public final Object invoke() {
                                return Boolean.valueOf(Z17ImageEditorKt.Z17ImageEditor$lambda$95$lambda$86$lambda$71$lambda$46$lambda$45(stateCollectAsStateWithLifecycle));
                            }
                        };
                        composer4.updateRememberedValue(objRememberedValue13);
                    }
                    EditorAnimateVisibilityKt.EditorAnimateVisibility(bitmapZ17ImageEditor$lambda$95$lambda$7, function3M10147getLambda$1781389051$views_release, (lb.a) objRememberedValue13, composer4, 48);
                    Bitmap bitmapZ17ImageEditor$lambda$95$lambda$8 = Z17ImageEditor$lambda$95$lambda$3(mutableState);
                    ComposableLambda composableLambdaRememberComposableLambda5 = ComposableLambdaKt.rememberComposableLambda(-139639044, true, new Function3() { // from class: cu.z17.views.imageEditor.i
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return Z17ImageEditorKt.Z17ImageEditor$lambda$95$lambda$86$lambda$71$lambda$49(focusRequester, list, mutableIntState, mutableState2, (Bitmap) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composer4, 54);
                    zChanged6 = composer4.changed(stateCollectAsStateWithLifecycle);
                    objRememberedValue14 = composer4.rememberedValue();
                    if (zChanged6 || objRememberedValue14 == companion2.getEmpty()) {
                        objRememberedValue14 = new lb.a() { // from class: cu.z17.views.imageEditor.j
                            @Override // lb.a
                            public final Object invoke() {
                                return Boolean.valueOf(Z17ImageEditorKt.Z17ImageEditor$lambda$95$lambda$86$lambda$71$lambda$51$lambda$50(stateCollectAsStateWithLifecycle));
                            }
                        };
                        composer4.updateRememberedValue(objRememberedValue14);
                    }
                    EditorAnimateVisibilityKt.EditorAnimateVisibility(bitmapZ17ImageEditor$lambda$95$lambda$8, composableLambdaRememberComposableLambda5, (lb.a) objRememberedValue14, composer4, 48);
                    Bitmap bitmapZ17ImageEditor$lambda$95$lambda$9 = Z17ImageEditor$lambda$95$lambda$3(mutableState);
                    ComposableLambda composableLambdaRememberComposableLambda6 = ComposableLambdaKt.rememberComposableLambda(-368428995, true, new Function3() { // from class: cu.z17.views.imageEditor.k
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return Z17ImageEditorKt.Z17ImageEditor$lambda$95$lambda$86$lambda$71$lambda$56(z17ImageEditorViewModel5, imagePathToSave, onEdited, (Bitmap) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composer4, 54);
                    zChanged7 = composer4.changed(stateCollectAsStateWithLifecycle);
                    objRememberedValue15 = composer4.rememberedValue();
                    if (zChanged7 || objRememberedValue15 == companion2.getEmpty()) {
                        objRememberedValue15 = new lb.a() { // from class: cu.z17.views.imageEditor.l
                            @Override // lb.a
                            public final Object invoke() {
                                return Boolean.valueOf(Z17ImageEditorKt.Z17ImageEditor$lambda$95$lambda$86$lambda$71$lambda$58$lambda$57(stateCollectAsStateWithLifecycle));
                            }
                        };
                        composer4.updateRememberedValue(objRememberedValue15);
                    }
                    EditorAnimateVisibilityKt.EditorAnimateVisibility(bitmapZ17ImageEditor$lambda$95$lambda$9, composableLambdaRememberComposableLambda6, (lb.a) objRememberedValue15, composer4, 48);
                    Bitmap bitmapZ17ImageEditor$lambda$95$lambda$10 = Z17ImageEditor$lambda$95$lambda$3(mutableState);
                    ComposableLambda composableLambdaRememberComposableLambda7 = ComposableLambdaKt.rememberComposableLambda(-597218946, true, new Function3() { // from class: cu.z17.views.imageEditor.n
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return Z17ImageEditorKt.Z17ImageEditor$lambda$95$lambda$86$lambda$71$lambda$63(z17ImageEditorViewModel5, imagePathToSave, onEdited, mutableFloatState, (Bitmap) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composer4, 54);
                    zChanged8 = composer4.changed(stateCollectAsStateWithLifecycle);
                    objRememberedValue16 = composer4.rememberedValue();
                    if (zChanged8 || objRememberedValue16 == companion2.getEmpty()) {
                        objRememberedValue16 = new lb.a() { // from class: cu.z17.views.imageEditor.o
                            @Override // lb.a
                            public final Object invoke() {
                                return Boolean.valueOf(Z17ImageEditorKt.Z17ImageEditor$lambda$95$lambda$86$lambda$71$lambda$65$lambda$64(stateCollectAsStateWithLifecycle));
                            }
                        };
                        composer4.updateRememberedValue(objRememberedValue16);
                    }
                    EditorAnimateVisibilityKt.EditorAnimateVisibility(bitmapZ17ImageEditor$lambda$95$lambda$10, composableLambdaRememberComposableLambda7, (lb.a) objRememberedValue16, composer4, 48);
                    Bitmap bitmapZ17ImageEditor$lambda$95$lambda$11 = Z17ImageEditor$lambda$95$lambda$3(mutableState);
                    ComposableLambda composableLambdaRememberComposableLambda8 = ComposableLambdaKt.rememberComposableLambda(-826008897, true, new Function3() { // from class: cu.z17.views.imageEditor.p
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return Z17ImageEditorKt.Z17ImageEditor$lambda$95$lambda$86$lambda$71$lambda$68(z17ImageEditorViewModel5, stateCollectAsStateWithLifecycle3, mutableIntState2, (Bitmap) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composer4, 54);
                    zChanged9 = composer4.changed(stateCollectAsStateWithLifecycle);
                    objRememberedValue17 = composer4.rememberedValue();
                    if (zChanged9 || objRememberedValue17 == companion2.getEmpty()) {
                        objRememberedValue17 = new lb.a() { // from class: cu.z17.views.imageEditor.q
                            @Override // lb.a
                            public final Object invoke() {
                                return Boolean.valueOf(Z17ImageEditorKt.Z17ImageEditor$lambda$95$lambda$86$lambda$71$lambda$70$lambda$69(stateCollectAsStateWithLifecycle));
                            }
                        };
                        composer4.updateRememberedValue(objRememberedValue17);
                    }
                    EditorAnimateVisibilityKt.EditorAnimateVisibility(bitmapZ17ImageEditor$lambda$95$lambda$11, composableLambdaRememberComposableLambda8, (lb.a) objRememberedValue17, composer4, 48);
                    if (Z17ImageEditor$lambda$95$lambda$0(stateCollectAsStateWithLifecycle) != Z17EditorState.LOADING || Z17ImageEditor$lambda$95$lambda$3(mutableState) == null) {
                        composer4.startReplaceGroup(1210587573);
                        Loading(composer4, 0);
                    } else {
                        composer4.startReplaceGroup(1200133350);
                    }
                    composer4.endReplaceGroup();
                    composer4.endNode();
                    Bitmap bitmapZ17ImageEditor$lambda$95$lambda$12 = Z17ImageEditor$lambda$95$lambda$3(mutableState);
                    ComposableLambda composableLambdaRememberComposableLambda9 = ComposableLambdaKt.rememberComposableLambda(-719497863, true, new Function3() { // from class: cu.z17.views.imageEditor.r
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return Z17ImageEditorKt.Z17ImageEditor$lambda$95$lambda$86$lambda$76(z17ImageEditorViewModel5, (Bitmap) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composer4, 54);
                    zChanged10 = composer4.changed(stateCollectAsStateWithLifecycle);
                    objRememberedValue18 = composer4.rememberedValue();
                    if (zChanged10 || objRememberedValue18 == companion2.getEmpty()) {
                        objRememberedValue18 = new lb.a() { // from class: cu.z17.views.imageEditor.s
                            @Override // lb.a
                            public final Object invoke() {
                                return Boolean.valueOf(Z17ImageEditorKt.Z17ImageEditor$lambda$95$lambda$86$lambda$78$lambda$77(stateCollectAsStateWithLifecycle));
                            }
                        };
                        composer4.updateRememberedValue(objRememberedValue18);
                    }
                    EditorAnimateVisibilityKt.EditorAnimateVisibility(bitmapZ17ImageEditor$lambda$95$lambda$12, composableLambdaRememberComposableLambda9, (lb.a) objRememberedValue18, composer4, 48);
                    Bitmap bitmapZ17ImageEditor$lambda$95$lambda$13 = Z17ImageEditor$lambda$95$lambda$3(mutableState);
                    Function3 function3 = new Function3() { // from class: cu.z17.views.imageEditor.u
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return Z17ImageEditorKt.Z17ImageEditor$lambda$95$lambda$86$lambda$83(stateCollectAsStateWithLifecycle3, z17ImageEditorViewModel5, imagePathToSave, onEdited, mutableIntState2, (Bitmap) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    };
                    z17ImageEditorViewModel4 = z17ImageEditorViewModel5;
                    function1 = onEdited;
                    ComposableLambda composableLambdaRememberComposableLambda10 = ComposableLambdaKt.rememberComposableLambda(1859870842, true, function3, composer4, 54);
                    zChanged11 = composer4.changed(stateCollectAsStateWithLifecycle);
                    objRememberedValue19 = composer4.rememberedValue();
                    if (zChanged11 || objRememberedValue19 == companion2.getEmpty()) {
                        objRememberedValue19 = new lb.a() { // from class: cu.z17.views.imageEditor.v
                            @Override // lb.a
                            public final Object invoke() {
                                return Boolean.valueOf(Z17ImageEditorKt.Z17ImageEditor$lambda$95$lambda$86$lambda$85$lambda$84(stateCollectAsStateWithLifecycle));
                            }
                        };
                        composer4.updateRememberedValue(objRememberedValue19);
                    }
                    EditorAnimateVisibilityKt.EditorAnimateVisibility(bitmapZ17ImageEditor$lambda$95$lambda$13, composableLambdaRememberComposableLambda10, (lb.a) objRememberedValue19, composer4, 48);
                    composer4.endNode();
                    if (Z17ImageEditor$lambda$95$lambda$11(state)) {
                        z15 = true;
                        composer4.startReplaceGroup(-1242932030);
                    } else {
                        composer4.startReplaceGroup(1761407863);
                        zChangedInstance2 = composer4.changedInstance(z17ImageEditorViewModel4);
                        objRememberedValue24 = composer4.rememberedValue();
                        if (zChangedInstance2 || objRememberedValue24 == companion2.getEmpty()) {
                            objRememberedValue24 = new lb.a() { // from class: cu.z17.views.imageEditor.w
                                @Override // lb.a
                                public final Object invoke() {
                                    return Z17ImageEditorKt.Z17ImageEditor$lambda$95$lambda$88$lambda$87(z17ImageEditorViewModel4);
                                }
                            };
                            composer4.updateRememberedValue(objRememberedValue24);
                        }
                        z15 = true;
                        BackHandlerKt.BackHandler(false, (lb.a) objRememberedValue24, composer4, 0, 1);
                    }
                    composer4.endReplaceGroup();
                    ua.k0 k0Var = ua.k0.f43947a;
                    boolean zChangedInstance3 = composer4.changedInstance(z17ImageEditorViewModel4) | composer4.changedInstance(source);
                    if ((i23 & 896) == 256) {
                        z16 = z15;
                    } else {
                        z16 = false;
                    }
                    boolean z24 = zChangedInstance3 | z16;
                    if ((i23 & 7168) == 2048) {
                        z17 = z15;
                    } else {
                        z17 = false;
                    }
                    boolean z25 = z24 | z17;
                    if ((57344 & i23) == 16384) {
                        z18 = z15;
                    } else {
                        z18 = false;
                    }
                    z19 = z25 | z18;
                    objRememberedValue20 = composer4.rememberedValue();
                    if (!z19 || objRememberedValue20 == companion2.getEmpty()) {
                        f12 = f14;
                        i24 = 131072;
                        Z17ImageEditorKt$Z17ImageEditor$1$3$1 z17ImageEditorKt$Z17ImageEditor$1$3$1 = new Z17ImageEditorKt$Z17ImageEditor$1$3$1(z17ImageEditorViewModel4, source, imagePathToSave, z14, f12, null);
                        z11 = z14;
                        z17ImageEditorViewModel4 = z17ImageEditorViewModel4;
                        composer4.updateRememberedValue(z17ImageEditorKt$Z17ImageEditor$1$3$1);
                        objRememberedValue20 = z17ImageEditorKt$Z17ImageEditor$1$3$1;
                    } else {
                        z11 = z14;
                        f12 = f14;
                        i24 = 131072;
                    }
                    EffectsKt.LaunchedEffect(k0Var, (Function2) objRememberedValue20, composer4, 6);
                    Z17EditorState z17EditorStateZ17ImageEditor$lambda$95$lambda$0 = Z17ImageEditor$lambda$95$lambda$0(stateCollectAsStateWithLifecycle);
                    if ((458752 & i23) == i24) {
                        z20 = z15;
                    } else {
                        z20 = false;
                    }
                    boolean zChanged12 = z20 | composer4.changed(stateCollectAsStateWithLifecycle);
                    if ((3670016 & i23) == 1048576) {
                        z21 = z15;
                    } else {
                        z21 = false;
                    }
                    z22 = zChanged12 | z21;
                    objRememberedValue21 = composer4.rememberedValue();
                    if (!z22 || objRememberedValue21 == companion2.getEmpty()) {
                        function2 = onViewState;
                        aVar = onError;
                        eVar = null;
                        objRememberedValue21 = new Z17ImageEditorKt$Z17ImageEditor$1$4$1(function2, aVar, stateCollectAsStateWithLifecycle, null);
                        composer4.updateRememberedValue(objRememberedValue21);
                    } else {
                        function2 = onViewState;
                        aVar = onError;
                        eVar = null;
                    }
                    EffectsKt.LaunchedEffect(z17EditorStateZ17ImageEditor$lambda$95$lambda$0, (Function2) objRememberedValue21, composer4, 0);
                    Integer numValueOf = Integer.valueOf(Z17ImageEditor$lambda$95$lambda$1(stateCollectAsStateWithLifecycle2).size());
                    boolean zChanged13 = composer4.changed(stateCollectAsStateWithLifecycle2);
                    if ((i23 & 29360128) != 8388608) {
                        z15 = false;
                    }
                    z23 = zChanged13 | z15;
                    objRememberedValue22 = composer4.rememberedValue();
                    if (z23 || objRememberedValue22 == companion2.getEmpty()) {
                        objRememberedValue22 = new Z17ImageEditorKt$Z17ImageEditor$1$5$1(function1, mutableState, stateCollectAsStateWithLifecycle2, eVar);
                        composer4.updateRememberedValue(objRememberedValue22);
                    }
                    EffectsKt.LaunchedEffect(numValueOf, (Function2) objRememberedValue22, composer4, 0);
                    zChangedInstance = composer4.changedInstance(z17ImageEditorViewModel4);
                    objRememberedValue23 = composer4.rememberedValue();
                    if (zChangedInstance || objRememberedValue23 == companion2.getEmpty()) {
                        objRememberedValue23 = new Function1() { // from class: cu.z17.views.imageEditor.y
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return Z17ImageEditorKt.Z17ImageEditor$lambda$95$lambda$94$lambda$93(z17ImageEditorViewModel4, (DisposableEffectScope) obj);
                            }
                        };
                        composer4.updateRememberedValue(objRememberedValue23);
                    }
                    EffectsKt.DisposableEffect(k0Var, (Function1) objRememberedValue23, composer4, 6);
                    composer4.endNode();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z17ImageEditorViewModel2 = z17ImageEditorViewModel4;
                    composer2 = composer4;
                    context3 = context4;
                    imageEditorConfigurations2 = imageEditorConfigurations4;
                    modifier3 = modifier5;
                } else {
                    function1 = onEdited;
                    function2 = onViewState;
                    aVar = onError;
                    composerStartRestartGroup.skipToGroupEnd();
                    z17ImageEditorViewModel2 = z17ImageEditorViewModel;
                    context3 = context2;
                    modifier3 = modifier2;
                    composer2 = composerStartRestartGroup;
                    f12 = f11;
                    imageEditorConfigurations2 = imageEditorConfigurations;
                }
                z13 = z11;
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final Function1 function4 = function2;
                    final Function1 function5 = function1;
                    final lb.a aVar2 = aVar;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.imageEditor.z
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return Z17ImageEditorKt.Z17ImageEditor$lambda$96(modifier3, source, imagePathToSave, z13, f12, function4, aVar2, function5, z17ImageEditorViewModel2, context3, imageEditorConfigurations2, i10, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i21 = i11 | 6;
            i19 = i21;
            if ((i17 & 306783379) == 306783378) {
                z12 = true;
            } else {
                z12 = true;
            }
            if (composerStartRestartGroup.shouldExecute(z12, i17 & 1)) {
                composerStartRestartGroup.startDefaults();
                if ((i10 & 1) != 0) {
                    if (i28 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i29 != 0) {
                        z11 = false;
                    }
                    if (i30 != 0) {
                        f13 = 0.0f;
                    } else {
                        f13 = f11;
                    }
                    if ((i12 & 256) != 0) {
                        path = source.getPath();
                        current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composerStartRestartGroup, 6);
                        if (current == null) {
                            throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                        }
                        if (current instanceof HasDefaultViewModelProviderFactory) {
                            defaultViewModelCreationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                        } else {
                            defaultViewModelCreationExtras = CreationExtras.Empty.INSTANCE;
                        }
                        ViewModel viewModel2 = ViewModelKt.viewModel(z0.b(Z17ImageEditorViewModel.class), current, path, (ViewModelProvider.Factory) null, defaultViewModelCreationExtras, composerStartRestartGroup, 0, 0);
                        composer3 = composerStartRestartGroup;
                        z17ImageEditorViewModel3 = (Z17ImageEditorViewModel) viewModel2;
                        i17 &= -234881025;
                    } else {
                        composer3 = composerStartRestartGroup;
                        z17ImageEditorViewModel3 = z17ImageEditorViewModel;
                    }
                    if ((i12 & 512) != 0) {
                        context2 = (Context) composer3.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                        i17 &= -1879048193;
                    }
                    if (i18 != 0) {
                        imageEditorConfigurations3 = new ImageEditorConfigurations(false, false, false, false, false, 27, null);
                    } else {
                        imageEditorConfigurations3 = imageEditorConfigurations;
                    }
                    f14 = f13;
                } else {
                    if (i28 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i29 != 0) {
                        z11 = false;
                    }
                    if (i30 != 0) {
                        f13 = 0.0f;
                    } else {
                        f13 = f11;
                    }
                    if ((i12 & 256) != 0) {
                        path = source.getPath();
                        current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composerStartRestartGroup, 6);
                        if (current == null) {
                            throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                        }
                        if (current instanceof HasDefaultViewModelProviderFactory) {
                            defaultViewModelCreationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                        } else {
                            defaultViewModelCreationExtras = CreationExtras.Empty.INSTANCE;
                        }
                        ViewModel viewModel3 = ViewModelKt.viewModel(z0.b(Z17ImageEditorViewModel.class), current, path, (ViewModelProvider.Factory) null, defaultViewModelCreationExtras, composerStartRestartGroup, 0, 0);
                        composer3 = composerStartRestartGroup;
                        z17ImageEditorViewModel3 = (Z17ImageEditorViewModel) viewModel3;
                        i17 &= -234881025;
                    } else {
                        composer3 = composerStartRestartGroup;
                        z17ImageEditorViewModel3 = z17ImageEditorViewModel;
                    }
                    if ((i12 & 512) != 0) {
                        context2 = (Context) composer3.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                        i17 &= -1879048193;
                    }
                    if (i18 != 0) {
                        imageEditorConfigurations3 = new ImageEditorConfigurations(false, false, false, false, false, 27, null);
                    } else {
                        imageEditorConfigurations3 = imageEditorConfigurations;
                    }
                    f14 = f13;
                }
                composer3.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    i22 = 1;
                    ComposerKt.traceEventStart(804632538, i17, i19, "cu.z17.views.imageEditor.Z17ImageEditor (Z17ImageEditor.kt:72)");
                } else {
                    i22 = 1;
                }
                companion = Color.INSTANCE;
                Modifier modifierM1205backgroundbw27NRU$default2 = BackgroundKt.m1205backgroundbw27NRU$default(modifier4, Color.m5865copywmQWz5c$default(companion.m5900getRed0d7_KjU(), 0.15f, 0.0f, 0.0f, 0.0f, 14, null), null, 2, null);
                Modifier modifier6 = modifier4;
                Alignment.Companion companion6 = Alignment.INSTANCE;
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(companion6.getTopStart(), false);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                CompositionLocalMap currentCompositionLocalMap4 = composer3.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composer3, modifierM1205backgroundbw27NRU$default2);
                ComposeUiNode.Companion companion7 = ComposeUiNode.INSTANCE;
                i23 = i17;
                constructor = companion7.getConstructor();
                if (!defpackage.r.a(composer3.getApplier())) {
                    ComposablesKt.invalidApplier();
                }
                composer3.startReusableNode();
                if (composer3.getInserting()) {
                    composer3.createNode(constructor);
                } else {
                    composer3.useNode();
                }
                composerM5176constructorimpl = Updater.m5176constructorimpl(composer3);
                final Z17ImageEditorViewModel z17ImageEditorViewModel6 = z17ImageEditorViewModel3;
                Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy3, companion7.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap4, companion7.getSetResolvedCompositionLocals());
                setCompositeKeyHash = companion7.getSetCompositeKeyHash();
                if (composerM5176constructorimpl.getInserting()) {
                    composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                } else {
                    composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier4, companion7.getSetModifier());
                BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                composer4 = composer3;
                stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(z17ImageEditorViewModel6.getCurrentState(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composer4, 0, 7);
                stateCollectAsStateWithLifecycle2 = FlowExtKt.collectAsStateWithLifecycle(z17ImageEditorViewModel6.getHistory().getValue(), va.w.n(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composer4, 48, 14);
                objRememberedValue = composer4.rememberedValue();
                companion2 = Composer.INSTANCE;
                if (objRememberedValue == companion2.getEmpty()) {
                    objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                    composer4.updateRememberedValue(objRememberedValue);
                }
                mutableState = (MutableState) objRememberedValue;
                objRememberedValue2 = composer4.rememberedValue();
                if (objRememberedValue2 == companion2.getEmpty()) {
                    objRememberedValue2 = new FocusRequester();
                    composer4.updateRememberedValue(objRememberedValue2);
                }
                final FocusRequester focusRequester2 = (FocusRequester) objRememberedValue2;
                objRememberedValue3 = composer4.rememberedValue();
                if (objRememberedValue3 == companion2.getEmpty()) {
                    objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                    composer4.updateRememberedValue(objRememberedValue3);
                }
                final MutableState mutableState3 = (MutableState) objRememberedValue3;
                objRememberedValue4 = composer4.rememberedValue();
                if (objRememberedValue4 == companion2.getEmpty()) {
                    objRememberedValue4 = SnapshotStateKt.derivedStateOf(new lb.a() { // from class: cu.z17.views.imageEditor.h
                        @Override // lb.a
                        public final Object invoke() {
                            return Boolean.valueOf(Z17ImageEditorKt.Z17ImageEditor$lambda$95$lambda$10$lambda$9(stateCollectAsStateWithLifecycle));
                        }
                    });
                    composer4.updateRememberedValue(objRememberedValue4);
                }
                state = (State) objRememberedValue4;
                objRememberedValue5 = composer4.rememberedValue();
                if (objRememberedValue5 == companion2.getEmpty()) {
                    Color colorM5856boximpl7 = Color.m5856boximpl(companion.m5903getWhite0d7_KjU());
                    Color colorM5856boximpl8 = Color.m5856boximpl(companion.m5892getBlack0d7_KjU());
                    Color colorM5856boximpl9 = Color.m5856boximpl(ColorKt.Color(4294940672L));
                    Color colorM5856boximpl10 = Color.m5856boximpl(ColorKt.Color(4291176488L));
                    Color colorM5856boximpl11 = Color.m5856boximpl(ColorKt.Color(4283215696L));
                    Color colorM5856boximpl12 = Color.m5856boximpl(ColorKt.Color(4288423856L));
                    Color[] colorArr2 = new Color[6];
                    colorArr2[0] = colorM5856boximpl7;
                    colorArr2[i22] = colorM5856boximpl8;
                    colorArr2[2] = colorM5856boximpl9;
                    colorArr2[3] = colorM5856boximpl10;
                    colorArr2[i14] = colorM5856boximpl11;
                    colorArr2[5] = colorM5856boximpl12;
                    objQ = va.w.q(colorArr2);
                    composer4.updateRememberedValue(objQ);
                } else {
                    objQ = objRememberedValue5;
                }
                final List list2 = (List) objQ;
                objRememberedValue6 = composer4.rememberedValue();
                if (objRememberedValue6 == companion2.getEmpty()) {
                    objRememberedValue6 = SnapshotIntStateKt.mutableIntStateOf(0);
                    composer4.updateRememberedValue(objRememberedValue6);
                }
                final MutableIntState mutableIntState3 = (MutableIntState) objRememberedValue6;
                objRememberedValue7 = composer4.rememberedValue();
                if (objRememberedValue7 == companion2.getEmpty()) {
                    objRememberedValue7 = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
                    composer4.updateRememberedValue(objRememberedValue7);
                }
                final MutableFloatState mutableFloatState2 = (MutableFloatState) objRememberedValue7;
                final State stateCollectAsStateWithLifecycle4 = FlowExtKt.collectAsStateWithLifecycle(z17ImageEditorViewModel6.getFilteredBitmaps().getValue(), va.w.n(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composer4, 48, 14);
                objRememberedValue8 = composer4.rememberedValue();
                if (objRememberedValue8 == companion2.getEmpty()) {
                    objRememberedValue8 = SnapshotIntStateKt.mutableIntStateOf(0);
                    composer4.updateRememberedValue(objRememberedValue8);
                }
                final MutableIntState mutableIntState4 = (MutableIntState) objRememberedValue8;
                Modifier.Companion companion8 = Modifier.INSTANCE;
                final Context context5 = context2;
                final ImageEditorConfigurations imageEditorConfigurations5 = imageEditorConfigurations3;
                Modifier modifierFillMaxSize$default2 = SizeKt.fillMaxSize$default(companion8, 0.0f, i22, null);
                MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), companion6.getStart(), composer4, 0);
                currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                CompositionLocalMap currentCompositionLocalMap5 = composer4.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier5 = ComposedModifierKt.materializeModifier(composer4, modifierFillMaxSize$default2);
                constructor2 = companion7.getConstructor();
                if (!defpackage.r.a(composer4.getApplier())) {
                    ComposablesKt.invalidApplier();
                }
                composer4.startReusableNode();
                if (composer4.getInserting()) {
                    composer4.createNode(constructor2);
                } else {
                    composer4.useNode();
                }
                composerM5176constructorimpl2 = Updater.m5176constructorimpl(composer4);
                Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyColumnMeasurePolicy2, companion7.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap5, companion7.getSetResolvedCompositionLocals());
                setCompositeKeyHash2 = companion7.getSetCompositeKeyHash();
                if (composerM5176constructorimpl2.getInserting()) {
                    composerM5176constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    composerM5176constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                } else {
                    composerM5176constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    composerM5176constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                }
                Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier5, companion7.getSetModifier());
                ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
                Bitmap bitmapZ17ImageEditor$lambda$95$lambda$14 = Z17ImageEditor$lambda$95$lambda$3(mutableState);
                z14 = z11;
                ComposableLambda composableLambdaRememberComposableLambda11 = ComposableLambdaKt.rememberComposableLambda(272879167, true, new Function3() { // from class: cu.z17.views.imageEditor.t
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return Z17ImageEditorKt.Z17ImageEditor$lambda$95$lambda$86$lambda$27(z17ImageEditorViewModel6, imagePathToSave, context5, imageEditorConfigurations5, stateCollectAsStateWithLifecycle2, (Bitmap) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composer4, 54);
                zChanged = composer4.changed(stateCollectAsStateWithLifecycle);
                objRememberedValue9 = composer4.rememberedValue();
                if (zChanged) {
                    objRememberedValue9 = new lb.a() { // from class: cu.z17.views.imageEditor.a0
                        @Override // lb.a
                        public final Object invoke() {
                            return Boolean.valueOf(Z17ImageEditorKt.Z17ImageEditor$lambda$95$lambda$86$lambda$29$lambda$28(stateCollectAsStateWithLifecycle));
                        }
                    };
                    composer4.updateRememberedValue(objRememberedValue9);
                } else {
                    objRememberedValue9 = new lb.a() { // from class: cu.z17.views.imageEditor.a0
                        @Override // lb.a
                        public final Object invoke() {
                            return Boolean.valueOf(Z17ImageEditorKt.Z17ImageEditor$lambda$95$lambda$86$lambda$29$lambda$28(stateCollectAsStateWithLifecycle));
                        }
                    };
                    composer4.updateRememberedValue(objRememberedValue9);
                }
                EditorAnimateVisibilityKt.EditorAnimateVisibility(bitmapZ17ImageEditor$lambda$95$lambda$14, composableLambdaRememberComposableLambda11, (lb.a) objRememberedValue9, composer4, 48);
                Bitmap bitmapZ17ImageEditor$lambda$95$lambda$15 = Z17ImageEditor$lambda$95$lambda$3(mutableState);
                ComposableLambda composableLambdaRememberComposableLambda12 = ComposableLambdaKt.rememberComposableLambda(132330614, true, new Function3() { // from class: cu.z17.views.imageEditor.b0
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return Z17ImageEditorKt.Z17ImageEditor$lambda$95$lambda$86$lambda$32(list2, mutableIntState3, (Bitmap) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composer4, 54);
                zChanged2 = composer4.changed(stateCollectAsStateWithLifecycle);
                objRememberedValue10 = composer4.rememberedValue();
                if (zChanged2) {
                    objRememberedValue10 = new lb.a() { // from class: cu.z17.views.imageEditor.c0
                        @Override // lb.a
                        public final Object invoke() {
                            return Boolean.valueOf(Z17ImageEditorKt.Z17ImageEditor$lambda$95$lambda$86$lambda$34$lambda$33(stateCollectAsStateWithLifecycle));
                        }
                    };
                    composer4.updateRememberedValue(objRememberedValue10);
                } else {
                    objRememberedValue10 = new lb.a() { // from class: cu.z17.views.imageEditor.c0
                        @Override // lb.a
                        public final Object invoke() {
                            return Boolean.valueOf(Z17ImageEditorKt.Z17ImageEditor$lambda$95$lambda$86$lambda$34$lambda$33(stateCollectAsStateWithLifecycle));
                        }
                    };
                    composer4.updateRememberedValue(objRememberedValue10);
                }
                EditorAnimateVisibilityKt.EditorAnimateVisibility(bitmapZ17ImageEditor$lambda$95$lambda$15, composableLambdaRememberComposableLambda12, (lb.a) objRememberedValue10, composer4, 48);
                Bitmap bitmapZ17ImageEditor$lambda$95$lambda$16 = Z17ImageEditor$lambda$95$lambda$3(mutableState);
                ComposableLambda composableLambdaRememberComposableLambda13 = ComposableLambdaKt.rememberComposableLambda(-1583267977, true, new Function3() { // from class: cu.z17.views.imageEditor.d0
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return Z17ImageEditorKt.Z17ImageEditor$lambda$95$lambda$86$lambda$37(mutableFloatState2, (Bitmap) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composer4, 54);
                zChanged3 = composer4.changed(stateCollectAsStateWithLifecycle);
                objRememberedValue11 = composer4.rememberedValue();
                if (zChanged3) {
                    objRememberedValue11 = new lb.a() { // from class: cu.z17.views.imageEditor.e0
                        @Override // lb.a
                        public final Object invoke() {
                            return Boolean.valueOf(Z17ImageEditorKt.Z17ImageEditor$lambda$95$lambda$86$lambda$39$lambda$38(stateCollectAsStateWithLifecycle));
                        }
                    };
                    composer4.updateRememberedValue(objRememberedValue11);
                } else {
                    objRememberedValue11 = new lb.a() { // from class: cu.z17.views.imageEditor.e0
                        @Override // lb.a
                        public final Object invoke() {
                            return Boolean.valueOf(Z17ImageEditorKt.Z17ImageEditor$lambda$95$lambda$86$lambda$39$lambda$38(stateCollectAsStateWithLifecycle));
                        }
                    };
                    composer4.updateRememberedValue(objRememberedValue11);
                }
                EditorAnimateVisibilityKt.EditorAnimateVisibility(bitmapZ17ImageEditor$lambda$95$lambda$16, composableLambdaRememberComposableLambda13, (lb.a) objRememberedValue11, composer4, 48);
                Bitmap bitmapZ17ImageEditor$lambda$95$lambda$17 = Z17ImageEditor$lambda$95$lambda$3(mutableState);
                ComposableLambda composableLambdaRememberComposableLambda14 = ComposableLambdaKt.rememberComposableLambda(996100728, true, new Function3() { // from class: cu.z17.views.imageEditor.f0
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return Z17ImageEditorKt.Z17ImageEditor$lambda$95$lambda$86$lambda$42(stateCollectAsStateWithLifecycle4, mutableIntState4, (Bitmap) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composer4, 54);
                zChanged4 = composer4.changed(stateCollectAsStateWithLifecycle);
                objRememberedValue12 = composer4.rememberedValue();
                if (zChanged4) {
                    objRememberedValue12 = new lb.a() { // from class: cu.z17.views.imageEditor.g0
                        @Override // lb.a
                        public final Object invoke() {
                            return Boolean.valueOf(Z17ImageEditorKt.Z17ImageEditor$lambda$95$lambda$86$lambda$44$lambda$43(stateCollectAsStateWithLifecycle));
                        }
                    };
                    composer4.updateRememberedValue(objRememberedValue12);
                } else {
                    objRememberedValue12 = new lb.a() { // from class: cu.z17.views.imageEditor.g0
                        @Override // lb.a
                        public final Object invoke() {
                            return Boolean.valueOf(Z17ImageEditorKt.Z17ImageEditor$lambda$95$lambda$86$lambda$44$lambda$43(stateCollectAsStateWithLifecycle));
                        }
                    };
                    composer4.updateRememberedValue(objRememberedValue12);
                }
                EditorAnimateVisibilityKt.EditorAnimateVisibility(bitmapZ17ImageEditor$lambda$95$lambda$17, composableLambdaRememberComposableLambda14, (lb.a) objRememberedValue12, composer4, 48);
                Modifier modifierA2 = androidx.compose.foundation.layout.x.a(columnScopeInstance2, companion8, 1.0f, false, 2, null);
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy4 = BoxKt.maybeCachedBoxMeasurePolicy(companion6.getTopStart(), false);
                currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                CompositionLocalMap currentCompositionLocalMap6 = composer4.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier6 = ComposedModifierKt.materializeModifier(composer4, modifierA2);
                constructor3 = companion7.getConstructor();
                if (!defpackage.r.a(composer4.getApplier())) {
                    ComposablesKt.invalidApplier();
                }
                composer4.startReusableNode();
                if (composer4.getInserting()) {
                    composer4.createNode(constructor3);
                } else {
                    composer4.useNode();
                }
                composerM5176constructorimpl3 = Updater.m5176constructorimpl(composer4);
                Updater.m5184setimpl(composerM5176constructorimpl3, measurePolicyMaybeCachedBoxMeasurePolicy4, companion7.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl3, currentCompositionLocalMap6, companion7.getSetResolvedCompositionLocals());
                setCompositeKeyHash3 = companion7.getSetCompositeKeyHash();
                if (composerM5176constructorimpl3.getInserting()) {
                    composerM5176constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                    composerM5176constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                } else {
                    composerM5176constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                    composerM5176constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                }
                Updater.m5184setimpl(composerM5176constructorimpl3, modifierMaterializeModifier6, companion7.getSetModifier());
                Bitmap bitmapZ17ImageEditor$lambda$95$lambda$18 = Z17ImageEditor$lambda$95$lambda$3(mutableState);
                Function3 function3M10147getLambda$1781389051$views_release2 = ComposableSingletons$Z17ImageEditorKt.INSTANCE.m10147getLambda$1781389051$views_release();
                zChanged5 = composer4.changed(stateCollectAsStateWithLifecycle);
                objRememberedValue13 = composer4.rememberedValue();
                if (zChanged5) {
                    objRememberedValue13 = new lb.a() { // from class: cu.z17.views.imageEditor.h0
                        @Override // lb.a
                        public final Object invoke() {
                            return Boolean.valueOf(Z17ImageEditorKt.Z17ImageEditor$lambda$95$lambda$86$lambda$71$lambda$46$lambda$45(stateCollectAsStateWithLifecycle));
                        }
                    };
                    composer4.updateRememberedValue(objRememberedValue13);
                } else {
                    objRememberedValue13 = new lb.a() { // from class: cu.z17.views.imageEditor.h0
                        @Override // lb.a
                        public final Object invoke() {
                            return Boolean.valueOf(Z17ImageEditorKt.Z17ImageEditor$lambda$95$lambda$86$lambda$71$lambda$46$lambda$45(stateCollectAsStateWithLifecycle));
                        }
                    };
                    composer4.updateRememberedValue(objRememberedValue13);
                }
                EditorAnimateVisibilityKt.EditorAnimateVisibility(bitmapZ17ImageEditor$lambda$95$lambda$18, function3M10147getLambda$1781389051$views_release2, (lb.a) objRememberedValue13, composer4, 48);
                Bitmap bitmapZ17ImageEditor$lambda$95$lambda$19 = Z17ImageEditor$lambda$95$lambda$3(mutableState);
                ComposableLambda composableLambdaRememberComposableLambda15 = ComposableLambdaKt.rememberComposableLambda(-139639044, true, new Function3() { // from class: cu.z17.views.imageEditor.i
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return Z17ImageEditorKt.Z17ImageEditor$lambda$95$lambda$86$lambda$71$lambda$49(focusRequester2, list2, mutableIntState3, mutableState3, (Bitmap) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composer4, 54);
                zChanged6 = composer4.changed(stateCollectAsStateWithLifecycle);
                objRememberedValue14 = composer4.rememberedValue();
                if (zChanged6) {
                    objRememberedValue14 = new lb.a() { // from class: cu.z17.views.imageEditor.j
                        @Override // lb.a
                        public final Object invoke() {
                            return Boolean.valueOf(Z17ImageEditorKt.Z17ImageEditor$lambda$95$lambda$86$lambda$71$lambda$51$lambda$50(stateCollectAsStateWithLifecycle));
                        }
                    };
                    composer4.updateRememberedValue(objRememberedValue14);
                } else {
                    objRememberedValue14 = new lb.a() { // from class: cu.z17.views.imageEditor.j
                        @Override // lb.a
                        public final Object invoke() {
                            return Boolean.valueOf(Z17ImageEditorKt.Z17ImageEditor$lambda$95$lambda$86$lambda$71$lambda$51$lambda$50(stateCollectAsStateWithLifecycle));
                        }
                    };
                    composer4.updateRememberedValue(objRememberedValue14);
                }
                EditorAnimateVisibilityKt.EditorAnimateVisibility(bitmapZ17ImageEditor$lambda$95$lambda$19, composableLambdaRememberComposableLambda15, (lb.a) objRememberedValue14, composer4, 48);
                Bitmap bitmapZ17ImageEditor$lambda$95$lambda$20 = Z17ImageEditor$lambda$95$lambda$3(mutableState);
                ComposableLambda composableLambdaRememberComposableLambda16 = ComposableLambdaKt.rememberComposableLambda(-368428995, true, new Function3() { // from class: cu.z17.views.imageEditor.k
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return Z17ImageEditorKt.Z17ImageEditor$lambda$95$lambda$86$lambda$71$lambda$56(z17ImageEditorViewModel6, imagePathToSave, onEdited, (Bitmap) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composer4, 54);
                zChanged7 = composer4.changed(stateCollectAsStateWithLifecycle);
                objRememberedValue15 = composer4.rememberedValue();
                if (zChanged7) {
                    objRememberedValue15 = new lb.a() { // from class: cu.z17.views.imageEditor.l
                        @Override // lb.a
                        public final Object invoke() {
                            return Boolean.valueOf(Z17ImageEditorKt.Z17ImageEditor$lambda$95$lambda$86$lambda$71$lambda$58$lambda$57(stateCollectAsStateWithLifecycle));
                        }
                    };
                    composer4.updateRememberedValue(objRememberedValue15);
                } else {
                    objRememberedValue15 = new lb.a() { // from class: cu.z17.views.imageEditor.l
                        @Override // lb.a
                        public final Object invoke() {
                            return Boolean.valueOf(Z17ImageEditorKt.Z17ImageEditor$lambda$95$lambda$86$lambda$71$lambda$58$lambda$57(stateCollectAsStateWithLifecycle));
                        }
                    };
                    composer4.updateRememberedValue(objRememberedValue15);
                }
                EditorAnimateVisibilityKt.EditorAnimateVisibility(bitmapZ17ImageEditor$lambda$95$lambda$20, composableLambdaRememberComposableLambda16, (lb.a) objRememberedValue15, composer4, 48);
                Bitmap bitmapZ17ImageEditor$lambda$95$lambda$110 = Z17ImageEditor$lambda$95$lambda$3(mutableState);
                ComposableLambda composableLambdaRememberComposableLambda17 = ComposableLambdaKt.rememberComposableLambda(-597218946, true, new Function3() { // from class: cu.z17.views.imageEditor.n
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return Z17ImageEditorKt.Z17ImageEditor$lambda$95$lambda$86$lambda$71$lambda$63(z17ImageEditorViewModel6, imagePathToSave, onEdited, mutableFloatState2, (Bitmap) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composer4, 54);
                zChanged8 = composer4.changed(stateCollectAsStateWithLifecycle);
                objRememberedValue16 = composer4.rememberedValue();
                if (zChanged8) {
                    objRememberedValue16 = new lb.a() { // from class: cu.z17.views.imageEditor.o
                        @Override // lb.a
                        public final Object invoke() {
                            return Boolean.valueOf(Z17ImageEditorKt.Z17ImageEditor$lambda$95$lambda$86$lambda$71$lambda$65$lambda$64(stateCollectAsStateWithLifecycle));
                        }
                    };
                    composer4.updateRememberedValue(objRememberedValue16);
                } else {
                    objRememberedValue16 = new lb.a() { // from class: cu.z17.views.imageEditor.o
                        @Override // lb.a
                        public final Object invoke() {
                            return Boolean.valueOf(Z17ImageEditorKt.Z17ImageEditor$lambda$95$lambda$86$lambda$71$lambda$65$lambda$64(stateCollectAsStateWithLifecycle));
                        }
                    };
                    composer4.updateRememberedValue(objRememberedValue16);
                }
                EditorAnimateVisibilityKt.EditorAnimateVisibility(bitmapZ17ImageEditor$lambda$95$lambda$110, composableLambdaRememberComposableLambda17, (lb.a) objRememberedValue16, composer4, 48);
                Bitmap bitmapZ17ImageEditor$lambda$95$lambda$111 = Z17ImageEditor$lambda$95$lambda$3(mutableState);
                ComposableLambda composableLambdaRememberComposableLambda18 = ComposableLambdaKt.rememberComposableLambda(-826008897, true, new Function3() { // from class: cu.z17.views.imageEditor.p
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return Z17ImageEditorKt.Z17ImageEditor$lambda$95$lambda$86$lambda$71$lambda$68(z17ImageEditorViewModel6, stateCollectAsStateWithLifecycle4, mutableIntState4, (Bitmap) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composer4, 54);
                zChanged9 = composer4.changed(stateCollectAsStateWithLifecycle);
                objRememberedValue17 = composer4.rememberedValue();
                if (zChanged9) {
                    objRememberedValue17 = new lb.a() { // from class: cu.z17.views.imageEditor.q
                        @Override // lb.a
                        public final Object invoke() {
                            return Boolean.valueOf(Z17ImageEditorKt.Z17ImageEditor$lambda$95$lambda$86$lambda$71$lambda$70$lambda$69(stateCollectAsStateWithLifecycle));
                        }
                    };
                    composer4.updateRememberedValue(objRememberedValue17);
                } else {
                    objRememberedValue17 = new lb.a() { // from class: cu.z17.views.imageEditor.q
                        @Override // lb.a
                        public final Object invoke() {
                            return Boolean.valueOf(Z17ImageEditorKt.Z17ImageEditor$lambda$95$lambda$86$lambda$71$lambda$70$lambda$69(stateCollectAsStateWithLifecycle));
                        }
                    };
                    composer4.updateRememberedValue(objRememberedValue17);
                }
                EditorAnimateVisibilityKt.EditorAnimateVisibility(bitmapZ17ImageEditor$lambda$95$lambda$111, composableLambdaRememberComposableLambda18, (lb.a) objRememberedValue17, composer4, 48);
                if (Z17ImageEditor$lambda$95$lambda$0(stateCollectAsStateWithLifecycle) != Z17EditorState.LOADING) {
                    composer4.startReplaceGroup(1210587573);
                    Loading(composer4, 0);
                } else {
                    composer4.startReplaceGroup(1210587573);
                    Loading(composer4, 0);
                }
                composer4.endReplaceGroup();
                composer4.endNode();
                Bitmap bitmapZ17ImageEditor$lambda$95$lambda$112 = Z17ImageEditor$lambda$95$lambda$3(mutableState);
                ComposableLambda composableLambdaRememberComposableLambda19 = ComposableLambdaKt.rememberComposableLambda(-719497863, true, new Function3() { // from class: cu.z17.views.imageEditor.r
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return Z17ImageEditorKt.Z17ImageEditor$lambda$95$lambda$86$lambda$76(z17ImageEditorViewModel6, (Bitmap) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composer4, 54);
                zChanged10 = composer4.changed(stateCollectAsStateWithLifecycle);
                objRememberedValue18 = composer4.rememberedValue();
                if (zChanged10) {
                    objRememberedValue18 = new lb.a() { // from class: cu.z17.views.imageEditor.s
                        @Override // lb.a
                        public final Object invoke() {
                            return Boolean.valueOf(Z17ImageEditorKt.Z17ImageEditor$lambda$95$lambda$86$lambda$78$lambda$77(stateCollectAsStateWithLifecycle));
                        }
                    };
                    composer4.updateRememberedValue(objRememberedValue18);
                } else {
                    objRememberedValue18 = new lb.a() { // from class: cu.z17.views.imageEditor.s
                        @Override // lb.a
                        public final Object invoke() {
                            return Boolean.valueOf(Z17ImageEditorKt.Z17ImageEditor$lambda$95$lambda$86$lambda$78$lambda$77(stateCollectAsStateWithLifecycle));
                        }
                    };
                    composer4.updateRememberedValue(objRememberedValue18);
                }
                EditorAnimateVisibilityKt.EditorAnimateVisibility(bitmapZ17ImageEditor$lambda$95$lambda$112, composableLambdaRememberComposableLambda19, (lb.a) objRememberedValue18, composer4, 48);
                Bitmap bitmapZ17ImageEditor$lambda$95$lambda$113 = Z17ImageEditor$lambda$95$lambda$3(mutableState);
                Function3 function6 = new Function3() { // from class: cu.z17.views.imageEditor.u
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return Z17ImageEditorKt.Z17ImageEditor$lambda$95$lambda$86$lambda$83(stateCollectAsStateWithLifecycle4, z17ImageEditorViewModel6, imagePathToSave, onEdited, mutableIntState4, (Bitmap) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                };
                z17ImageEditorViewModel4 = z17ImageEditorViewModel6;
                function1 = onEdited;
                ComposableLambda composableLambdaRememberComposableLambda110 = ComposableLambdaKt.rememberComposableLambda(1859870842, true, function6, composer4, 54);
                zChanged11 = composer4.changed(stateCollectAsStateWithLifecycle);
                objRememberedValue19 = composer4.rememberedValue();
                if (zChanged11) {
                    objRememberedValue19 = new lb.a() { // from class: cu.z17.views.imageEditor.v
                        @Override // lb.a
                        public final Object invoke() {
                            return Boolean.valueOf(Z17ImageEditorKt.Z17ImageEditor$lambda$95$lambda$86$lambda$85$lambda$84(stateCollectAsStateWithLifecycle));
                        }
                    };
                    composer4.updateRememberedValue(objRememberedValue19);
                } else {
                    objRememberedValue19 = new lb.a() { // from class: cu.z17.views.imageEditor.v
                        @Override // lb.a
                        public final Object invoke() {
                            return Boolean.valueOf(Z17ImageEditorKt.Z17ImageEditor$lambda$95$lambda$86$lambda$85$lambda$84(stateCollectAsStateWithLifecycle));
                        }
                    };
                    composer4.updateRememberedValue(objRememberedValue19);
                }
                EditorAnimateVisibilityKt.EditorAnimateVisibility(bitmapZ17ImageEditor$lambda$95$lambda$113, composableLambdaRememberComposableLambda110, (lb.a) objRememberedValue19, composer4, 48);
                composer4.endNode();
                if (Z17ImageEditor$lambda$95$lambda$11(state)) {
                    composer4.startReplaceGroup(1761407863);
                    zChangedInstance2 = composer4.changedInstance(z17ImageEditorViewModel4);
                    objRememberedValue24 = composer4.rememberedValue();
                    if (zChangedInstance2) {
                        objRememberedValue24 = new lb.a() { // from class: cu.z17.views.imageEditor.w
                            @Override // lb.a
                            public final Object invoke() {
                                return Z17ImageEditorKt.Z17ImageEditor$lambda$95$lambda$88$lambda$87(z17ImageEditorViewModel4);
                            }
                        };
                        composer4.updateRememberedValue(objRememberedValue24);
                    } else {
                        objRememberedValue24 = new lb.a() { // from class: cu.z17.views.imageEditor.w
                            @Override // lb.a
                            public final Object invoke() {
                                return Z17ImageEditorKt.Z17ImageEditor$lambda$95$lambda$88$lambda$87(z17ImageEditorViewModel4);
                            }
                        };
                        composer4.updateRememberedValue(objRememberedValue24);
                    }
                    z15 = true;
                    BackHandlerKt.BackHandler(false, (lb.a) objRememberedValue24, composer4, 0, 1);
                } else {
                    z15 = true;
                    composer4.startReplaceGroup(-1242932030);
                }
                composer4.endReplaceGroup();
                ua.k0 k0Var2 = ua.k0.f43947a;
                boolean zChangedInstance4 = composer4.changedInstance(z17ImageEditorViewModel4) | composer4.changedInstance(source);
                if ((i23 & 896) == 256) {
                    z16 = z15;
                } else {
                    z16 = false;
                }
                boolean z26 = zChangedInstance4 | z16;
                if ((i23 & 7168) == 2048) {
                    z17 = z15;
                } else {
                    z17 = false;
                }
                boolean z27 = z26 | z17;
                if ((57344 & i23) == 16384) {
                    z18 = z15;
                } else {
                    z18 = false;
                }
                z19 = z27 | z18;
                objRememberedValue20 = composer4.rememberedValue();
                if (z19) {
                    f12 = f14;
                    i24 = 131072;
                    Z17ImageEditorKt$Z17ImageEditor$1$3$1 z17ImageEditorKt$Z17ImageEditor$1$3$2 = new Z17ImageEditorKt$Z17ImageEditor$1$3$1(z17ImageEditorViewModel4, source, imagePathToSave, z14, f12, null);
                    z11 = z14;
                    z17ImageEditorViewModel4 = z17ImageEditorViewModel4;
                    composer4.updateRememberedValue(z17ImageEditorKt$Z17ImageEditor$1$3$2);
                    objRememberedValue20 = z17ImageEditorKt$Z17ImageEditor$1$3$2;
                } else {
                    f12 = f14;
                    i24 = 131072;
                    Z17ImageEditorKt$Z17ImageEditor$1$3$1 z17ImageEditorKt$Z17ImageEditor$1$3$3 = new Z17ImageEditorKt$Z17ImageEditor$1$3$1(z17ImageEditorViewModel4, source, imagePathToSave, z14, f12, null);
                    z11 = z14;
                    z17ImageEditorViewModel4 = z17ImageEditorViewModel4;
                    composer4.updateRememberedValue(z17ImageEditorKt$Z17ImageEditor$1$3$3);
                    objRememberedValue20 = z17ImageEditorKt$Z17ImageEditor$1$3$3;
                }
                EffectsKt.LaunchedEffect(k0Var2, (Function2) objRememberedValue20, composer4, 6);
                Z17EditorState z17EditorStateZ17ImageEditor$lambda$95$lambda$1 = Z17ImageEditor$lambda$95$lambda$0(stateCollectAsStateWithLifecycle);
                if ((458752 & i23) == i24) {
                    z20 = z15;
                } else {
                    z20 = false;
                }
                boolean zChanged14 = z20 | composer4.changed(stateCollectAsStateWithLifecycle);
                if ((3670016 & i23) == 1048576) {
                    z21 = z15;
                } else {
                    z21 = false;
                }
                z22 = zChanged14 | z21;
                objRememberedValue21 = composer4.rememberedValue();
                if (z22) {
                    function2 = onViewState;
                    aVar = onError;
                    eVar = null;
                    objRememberedValue21 = new Z17ImageEditorKt$Z17ImageEditor$1$4$1(function2, aVar, stateCollectAsStateWithLifecycle, null);
                    composer4.updateRememberedValue(objRememberedValue21);
                } else {
                    function2 = onViewState;
                    aVar = onError;
                    eVar = null;
                    objRememberedValue21 = new Z17ImageEditorKt$Z17ImageEditor$1$4$1(function2, aVar, stateCollectAsStateWithLifecycle, null);
                    composer4.updateRememberedValue(objRememberedValue21);
                }
                EffectsKt.LaunchedEffect(z17EditorStateZ17ImageEditor$lambda$95$lambda$1, (Function2) objRememberedValue21, composer4, 0);
                Integer numValueOf2 = Integer.valueOf(Z17ImageEditor$lambda$95$lambda$1(stateCollectAsStateWithLifecycle2).size());
                boolean zChanged15 = composer4.changed(stateCollectAsStateWithLifecycle2);
                if ((i23 & 29360128) != 8388608) {
                    z15 = false;
                }
                z23 = zChanged15 | z15;
                objRememberedValue22 = composer4.rememberedValue();
                if (z23) {
                    objRememberedValue22 = new Z17ImageEditorKt$Z17ImageEditor$1$5$1(function1, mutableState, stateCollectAsStateWithLifecycle2, eVar);
                    composer4.updateRememberedValue(objRememberedValue22);
                } else {
                    objRememberedValue22 = new Z17ImageEditorKt$Z17ImageEditor$1$5$1(function1, mutableState, stateCollectAsStateWithLifecycle2, eVar);
                    composer4.updateRememberedValue(objRememberedValue22);
                }
                EffectsKt.LaunchedEffect(numValueOf2, (Function2) objRememberedValue22, composer4, 0);
                zChangedInstance = composer4.changedInstance(z17ImageEditorViewModel4);
                objRememberedValue23 = composer4.rememberedValue();
                if (zChangedInstance) {
                    objRememberedValue23 = new Function1() { // from class: cu.z17.views.imageEditor.y
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return Z17ImageEditorKt.Z17ImageEditor$lambda$95$lambda$94$lambda$93(z17ImageEditorViewModel4, (DisposableEffectScope) obj);
                        }
                    };
                    composer4.updateRememberedValue(objRememberedValue23);
                } else {
                    objRememberedValue23 = new Function1() { // from class: cu.z17.views.imageEditor.y
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return Z17ImageEditorKt.Z17ImageEditor$lambda$95$lambda$94$lambda$93(z17ImageEditorViewModel4, (DisposableEffectScope) obj);
                        }
                    };
                    composer4.updateRememberedValue(objRememberedValue23);
                }
                EffectsKt.DisposableEffect(k0Var2, (Function1) objRememberedValue23, composer4, 6);
                composer4.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z17ImageEditorViewModel2 = z17ImageEditorViewModel4;
                composer2 = composer4;
                context3 = context5;
                imageEditorConfigurations2 = imageEditorConfigurations5;
                modifier3 = modifier6;
            } else {
                function1 = onEdited;
                function2 = onViewState;
                aVar = onError;
                composerStartRestartGroup.skipToGroupEnd();
                z17ImageEditorViewModel2 = z17ImageEditorViewModel;
                context3 = context2;
                modifier3 = modifier2;
                composer2 = composerStartRestartGroup;
                f12 = f11;
                imageEditorConfigurations2 = imageEditorConfigurations;
            }
            z13 = z11;
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final Function1 function7 = function2;
                final Function1 function8 = function1;
                final lb.a aVar3 = aVar;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.imageEditor.z
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return Z17ImageEditorKt.Z17ImageEditor$lambda$96(modifier3, source, imagePathToSave, z13, f12, function7, aVar3, function8, z17ImageEditorViewModel2, context3, imageEditorConfigurations2, i10, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i13 |= 24576;
        f11 = f10;
        if ((i10 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            if (composerStartRestartGroup.changedInstance(onViewState)) {
                i27 = 131072;
            } else {
                i27 = 65536;
            }
            i13 |= i27;
        }
        if ((i10 & 1572864) == 0) {
            if (composerStartRestartGroup.changedInstance(onError)) {
                i26 = 1048576;
            } else {
                i26 = 524288;
            }
            i13 |= i26;
        }
        i15 = i13;
        if ((i10 & 12582912) == 0) {
            if (composerStartRestartGroup.changedInstance(onEdited)) {
                i25 = 8388608;
            } else {
                i25 = 4194304;
            }
            i16 = i15 | i25;
        } else {
            i16 = i15;
        }
        if ((i10 & 100663296) != 0) {
            i16 |= ((i12 & 256) == 0 || !composerStartRestartGroup.changedInstance(z17ImageEditorViewModel)) ? 33554432 : 67108864;
        }
        if ((i10 & 805306368) == 0) {
            if ((i12 & 512) == 0) {
                context2 = context;
                if (composerStartRestartGroup.changedInstance(context2)) {
                }
                i16 |= i31;
            } else {
                context2 = context;
            }
            i16 |= i31;
        } else {
            context2 = context;
        }
        i17 = i16;
        i18 = i12 & 1024;
        if (i18 != 0) {
            if ((i11 & 6) == 0) {
                if (composerStartRestartGroup.changed(imageEditorConfigurations)) {
                    i20 = i14;
                } else {
                    i20 = 2;
                }
                i21 = i11 | i20;
            } else {
                i19 = i11;
            }
            if ((i17 & 306783379) == 306783378) {
                z12 = true;
            } else {
                z12 = true;
            }
            if (composerStartRestartGroup.shouldExecute(z12, i17 & 1)) {
                composerStartRestartGroup.startDefaults();
                if ((i10 & 1) != 0) {
                    if (i28 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i29 != 0) {
                        z11 = false;
                    }
                    if (i30 != 0) {
                        f13 = 0.0f;
                    } else {
                        f13 = f11;
                    }
                    if ((i12 & 256) != 0) {
                        path = source.getPath();
                        current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composerStartRestartGroup, 6);
                        if (current == null) {
                            throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                        }
                        if (current instanceof HasDefaultViewModelProviderFactory) {
                            defaultViewModelCreationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                        } else {
                            defaultViewModelCreationExtras = CreationExtras.Empty.INSTANCE;
                        }
                        ViewModel viewModel4 = ViewModelKt.viewModel(z0.b(Z17ImageEditorViewModel.class), current, path, (ViewModelProvider.Factory) null, defaultViewModelCreationExtras, composerStartRestartGroup, 0, 0);
                        composer3 = composerStartRestartGroup;
                        z17ImageEditorViewModel3 = (Z17ImageEditorViewModel) viewModel4;
                        i17 &= -234881025;
                    } else {
                        composer3 = composerStartRestartGroup;
                        z17ImageEditorViewModel3 = z17ImageEditorViewModel;
                    }
                    if ((i12 & 512) != 0) {
                        context2 = (Context) composer3.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                        i17 &= -1879048193;
                    }
                    if (i18 != 0) {
                        imageEditorConfigurations3 = new ImageEditorConfigurations(false, false, false, false, false, 27, null);
                    } else {
                        imageEditorConfigurations3 = imageEditorConfigurations;
                    }
                    f14 = f13;
                } else {
                    if (i28 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i29 != 0) {
                        z11 = false;
                    }
                    if (i30 != 0) {
                        f13 = 0.0f;
                    } else {
                        f13 = f11;
                    }
                    if ((i12 & 256) != 0) {
                        path = source.getPath();
                        current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composerStartRestartGroup, 6);
                        if (current == null) {
                            throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                        }
                        if (current instanceof HasDefaultViewModelProviderFactory) {
                            defaultViewModelCreationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                        } else {
                            defaultViewModelCreationExtras = CreationExtras.Empty.INSTANCE;
                        }
                        ViewModel viewModel5 = ViewModelKt.viewModel(z0.b(Z17ImageEditorViewModel.class), current, path, (ViewModelProvider.Factory) null, defaultViewModelCreationExtras, composerStartRestartGroup, 0, 0);
                        composer3 = composerStartRestartGroup;
                        z17ImageEditorViewModel3 = (Z17ImageEditorViewModel) viewModel5;
                        i17 &= -234881025;
                    } else {
                        composer3 = composerStartRestartGroup;
                        z17ImageEditorViewModel3 = z17ImageEditorViewModel;
                    }
                    if ((i12 & 512) != 0) {
                        context2 = (Context) composer3.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                        i17 &= -1879048193;
                    }
                    if (i18 != 0) {
                        imageEditorConfigurations3 = new ImageEditorConfigurations(false, false, false, false, false, 27, null);
                    } else {
                        imageEditorConfigurations3 = imageEditorConfigurations;
                    }
                    f14 = f13;
                }
                composer3.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    i22 = 1;
                    ComposerKt.traceEventStart(804632538, i17, i19, "cu.z17.views.imageEditor.Z17ImageEditor (Z17ImageEditor.kt:72)");
                } else {
                    i22 = 1;
                }
                companion = Color.INSTANCE;
                Modifier modifierM1205backgroundbw27NRU$default3 = BackgroundKt.m1205backgroundbw27NRU$default(modifier4, Color.m5865copywmQWz5c$default(companion.m5900getRed0d7_KjU(), 0.15f, 0.0f, 0.0f, 0.0f, 14, null), null, 2, null);
                Modifier modifier7 = modifier4;
                Alignment.Companion companion9 = Alignment.INSTANCE;
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy5 = BoxKt.maybeCachedBoxMeasurePolicy(companion9.getTopStart(), false);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                CompositionLocalMap currentCompositionLocalMap7 = composer3.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier7 = ComposedModifierKt.materializeModifier(composer3, modifierM1205backgroundbw27NRU$default3);
                ComposeUiNode.Companion companion10 = ComposeUiNode.INSTANCE;
                i23 = i17;
                constructor = companion10.getConstructor();
                if (!defpackage.r.a(composer3.getApplier())) {
                    ComposablesKt.invalidApplier();
                }
                composer3.startReusableNode();
                if (composer3.getInserting()) {
                    composer3.createNode(constructor);
                } else {
                    composer3.useNode();
                }
                composerM5176constructorimpl = Updater.m5176constructorimpl(composer3);
                final Z17ImageEditorViewModel z17ImageEditorViewModel7 = z17ImageEditorViewModel3;
                Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy5, companion10.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap7, companion10.getSetResolvedCompositionLocals());
                setCompositeKeyHash = companion10.getSetCompositeKeyHash();
                if (composerM5176constructorimpl.getInserting()) {
                    composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                } else {
                    composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier7, companion10.getSetModifier());
                BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
                composer4 = composer3;
                stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(z17ImageEditorViewModel7.getCurrentState(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composer4, 0, 7);
                stateCollectAsStateWithLifecycle2 = FlowExtKt.collectAsStateWithLifecycle(z17ImageEditorViewModel7.getHistory().getValue(), va.w.n(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composer4, 48, 14);
                objRememberedValue = composer4.rememberedValue();
                companion2 = Composer.INSTANCE;
                if (objRememberedValue == companion2.getEmpty()) {
                    objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                    composer4.updateRememberedValue(objRememberedValue);
                }
                mutableState = (MutableState) objRememberedValue;
                objRememberedValue2 = composer4.rememberedValue();
                if (objRememberedValue2 == companion2.getEmpty()) {
                    objRememberedValue2 = new FocusRequester();
                    composer4.updateRememberedValue(objRememberedValue2);
                }
                final FocusRequester focusRequester3 = (FocusRequester) objRememberedValue2;
                objRememberedValue3 = composer4.rememberedValue();
                if (objRememberedValue3 == companion2.getEmpty()) {
                    objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                    composer4.updateRememberedValue(objRememberedValue3);
                }
                final MutableState mutableState4 = (MutableState) objRememberedValue3;
                objRememberedValue4 = composer4.rememberedValue();
                if (objRememberedValue4 == companion2.getEmpty()) {
                    objRememberedValue4 = SnapshotStateKt.derivedStateOf(new lb.a() { // from class: cu.z17.views.imageEditor.h
                        @Override // lb.a
                        public final Object invoke() {
                            return Boolean.valueOf(Z17ImageEditorKt.Z17ImageEditor$lambda$95$lambda$10$lambda$9(stateCollectAsStateWithLifecycle));
                        }
                    });
                    composer4.updateRememberedValue(objRememberedValue4);
                }
                state = (State) objRememberedValue4;
                objRememberedValue5 = composer4.rememberedValue();
                if (objRememberedValue5 == companion2.getEmpty()) {
                    Color colorM5856boximpl13 = Color.m5856boximpl(companion.m5903getWhite0d7_KjU());
                    Color colorM5856boximpl14 = Color.m5856boximpl(companion.m5892getBlack0d7_KjU());
                    Color colorM5856boximpl15 = Color.m5856boximpl(ColorKt.Color(4294940672L));
                    Color colorM5856boximpl16 = Color.m5856boximpl(ColorKt.Color(4291176488L));
                    Color colorM5856boximpl17 = Color.m5856boximpl(ColorKt.Color(4283215696L));
                    Color colorM5856boximpl18 = Color.m5856boximpl(ColorKt.Color(4288423856L));
                    Color[] colorArr3 = new Color[6];
                    colorArr3[0] = colorM5856boximpl13;
                    colorArr3[i22] = colorM5856boximpl14;
                    colorArr3[2] = colorM5856boximpl15;
                    colorArr3[3] = colorM5856boximpl16;
                    colorArr3[i14] = colorM5856boximpl17;
                    colorArr3[5] = colorM5856boximpl18;
                    objQ = va.w.q(colorArr3);
                    composer4.updateRememberedValue(objQ);
                } else {
                    objQ = objRememberedValue5;
                }
                final List list3 = (List) objQ;
                objRememberedValue6 = composer4.rememberedValue();
                if (objRememberedValue6 == companion2.getEmpty()) {
                    objRememberedValue6 = SnapshotIntStateKt.mutableIntStateOf(0);
                    composer4.updateRememberedValue(objRememberedValue6);
                }
                final MutableIntState mutableIntState5 = (MutableIntState) objRememberedValue6;
                objRememberedValue7 = composer4.rememberedValue();
                if (objRememberedValue7 == companion2.getEmpty()) {
                    objRememberedValue7 = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
                    composer4.updateRememberedValue(objRememberedValue7);
                }
                final MutableFloatState mutableFloatState3 = (MutableFloatState) objRememberedValue7;
                final State stateCollectAsStateWithLifecycle5 = FlowExtKt.collectAsStateWithLifecycle(z17ImageEditorViewModel7.getFilteredBitmaps().getValue(), va.w.n(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composer4, 48, 14);
                objRememberedValue8 = composer4.rememberedValue();
                if (objRememberedValue8 == companion2.getEmpty()) {
                    objRememberedValue8 = SnapshotIntStateKt.mutableIntStateOf(0);
                    composer4.updateRememberedValue(objRememberedValue8);
                }
                final MutableIntState mutableIntState6 = (MutableIntState) objRememberedValue8;
                Modifier.Companion companion11 = Modifier.INSTANCE;
                final Context context6 = context2;
                final ImageEditorConfigurations imageEditorConfigurations6 = imageEditorConfigurations3;
                Modifier modifierFillMaxSize$default3 = SizeKt.fillMaxSize$default(companion11, 0.0f, i22, null);
                MeasurePolicy measurePolicyColumnMeasurePolicy3 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), companion9.getStart(), composer4, 0);
                currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                CompositionLocalMap currentCompositionLocalMap8 = composer4.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier8 = ComposedModifierKt.materializeModifier(composer4, modifierFillMaxSize$default3);
                constructor2 = companion10.getConstructor();
                if (!defpackage.r.a(composer4.getApplier())) {
                    ComposablesKt.invalidApplier();
                }
                composer4.startReusableNode();
                if (composer4.getInserting()) {
                    composer4.createNode(constructor2);
                } else {
                    composer4.useNode();
                }
                composerM5176constructorimpl2 = Updater.m5176constructorimpl(composer4);
                Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyColumnMeasurePolicy3, companion10.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap8, companion10.getSetResolvedCompositionLocals());
                setCompositeKeyHash2 = companion10.getSetCompositeKeyHash();
                if (composerM5176constructorimpl2.getInserting()) {
                    composerM5176constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    composerM5176constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                } else {
                    composerM5176constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    composerM5176constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                }
                Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier8, companion10.getSetModifier());
                ColumnScopeInstance columnScopeInstance3 = ColumnScopeInstance.INSTANCE;
                Bitmap bitmapZ17ImageEditor$lambda$95$lambda$114 = Z17ImageEditor$lambda$95$lambda$3(mutableState);
                z14 = z11;
                ComposableLambda composableLambdaRememberComposableLambda111 = ComposableLambdaKt.rememberComposableLambda(272879167, true, new Function3() { // from class: cu.z17.views.imageEditor.t
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return Z17ImageEditorKt.Z17ImageEditor$lambda$95$lambda$86$lambda$27(z17ImageEditorViewModel7, imagePathToSave, context6, imageEditorConfigurations6, stateCollectAsStateWithLifecycle2, (Bitmap) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composer4, 54);
                zChanged = composer4.changed(stateCollectAsStateWithLifecycle);
                objRememberedValue9 = composer4.rememberedValue();
                if (zChanged) {
                    objRememberedValue9 = new lb.a() { // from class: cu.z17.views.imageEditor.a0
                        @Override // lb.a
                        public final Object invoke() {
                            return Boolean.valueOf(Z17ImageEditorKt.Z17ImageEditor$lambda$95$lambda$86$lambda$29$lambda$28(stateCollectAsStateWithLifecycle));
                        }
                    };
                    composer4.updateRememberedValue(objRememberedValue9);
                } else {
                    objRememberedValue9 = new lb.a() { // from class: cu.z17.views.imageEditor.a0
                        @Override // lb.a
                        public final Object invoke() {
                            return Boolean.valueOf(Z17ImageEditorKt.Z17ImageEditor$lambda$95$lambda$86$lambda$29$lambda$28(stateCollectAsStateWithLifecycle));
                        }
                    };
                    composer4.updateRememberedValue(objRememberedValue9);
                }
                EditorAnimateVisibilityKt.EditorAnimateVisibility(bitmapZ17ImageEditor$lambda$95$lambda$114, composableLambdaRememberComposableLambda111, (lb.a) objRememberedValue9, composer4, 48);
                Bitmap bitmapZ17ImageEditor$lambda$95$lambda$115 = Z17ImageEditor$lambda$95$lambda$3(mutableState);
                ComposableLambda composableLambdaRememberComposableLambda112 = ComposableLambdaKt.rememberComposableLambda(132330614, true, new Function3() { // from class: cu.z17.views.imageEditor.b0
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return Z17ImageEditorKt.Z17ImageEditor$lambda$95$lambda$86$lambda$32(list3, mutableIntState5, (Bitmap) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composer4, 54);
                zChanged2 = composer4.changed(stateCollectAsStateWithLifecycle);
                objRememberedValue10 = composer4.rememberedValue();
                if (zChanged2) {
                    objRememberedValue10 = new lb.a() { // from class: cu.z17.views.imageEditor.c0
                        @Override // lb.a
                        public final Object invoke() {
                            return Boolean.valueOf(Z17ImageEditorKt.Z17ImageEditor$lambda$95$lambda$86$lambda$34$lambda$33(stateCollectAsStateWithLifecycle));
                        }
                    };
                    composer4.updateRememberedValue(objRememberedValue10);
                } else {
                    objRememberedValue10 = new lb.a() { // from class: cu.z17.views.imageEditor.c0
                        @Override // lb.a
                        public final Object invoke() {
                            return Boolean.valueOf(Z17ImageEditorKt.Z17ImageEditor$lambda$95$lambda$86$lambda$34$lambda$33(stateCollectAsStateWithLifecycle));
                        }
                    };
                    composer4.updateRememberedValue(objRememberedValue10);
                }
                EditorAnimateVisibilityKt.EditorAnimateVisibility(bitmapZ17ImageEditor$lambda$95$lambda$115, composableLambdaRememberComposableLambda112, (lb.a) objRememberedValue10, composer4, 48);
                Bitmap bitmapZ17ImageEditor$lambda$95$lambda$116 = Z17ImageEditor$lambda$95$lambda$3(mutableState);
                ComposableLambda composableLambdaRememberComposableLambda113 = ComposableLambdaKt.rememberComposableLambda(-1583267977, true, new Function3() { // from class: cu.z17.views.imageEditor.d0
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return Z17ImageEditorKt.Z17ImageEditor$lambda$95$lambda$86$lambda$37(mutableFloatState3, (Bitmap) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composer4, 54);
                zChanged3 = composer4.changed(stateCollectAsStateWithLifecycle);
                objRememberedValue11 = composer4.rememberedValue();
                if (zChanged3) {
                    objRememberedValue11 = new lb.a() { // from class: cu.z17.views.imageEditor.e0
                        @Override // lb.a
                        public final Object invoke() {
                            return Boolean.valueOf(Z17ImageEditorKt.Z17ImageEditor$lambda$95$lambda$86$lambda$39$lambda$38(stateCollectAsStateWithLifecycle));
                        }
                    };
                    composer4.updateRememberedValue(objRememberedValue11);
                } else {
                    objRememberedValue11 = new lb.a() { // from class: cu.z17.views.imageEditor.e0
                        @Override // lb.a
                        public final Object invoke() {
                            return Boolean.valueOf(Z17ImageEditorKt.Z17ImageEditor$lambda$95$lambda$86$lambda$39$lambda$38(stateCollectAsStateWithLifecycle));
                        }
                    };
                    composer4.updateRememberedValue(objRememberedValue11);
                }
                EditorAnimateVisibilityKt.EditorAnimateVisibility(bitmapZ17ImageEditor$lambda$95$lambda$116, composableLambdaRememberComposableLambda113, (lb.a) objRememberedValue11, composer4, 48);
                Bitmap bitmapZ17ImageEditor$lambda$95$lambda$117 = Z17ImageEditor$lambda$95$lambda$3(mutableState);
                ComposableLambda composableLambdaRememberComposableLambda114 = ComposableLambdaKt.rememberComposableLambda(996100728, true, new Function3() { // from class: cu.z17.views.imageEditor.f0
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return Z17ImageEditorKt.Z17ImageEditor$lambda$95$lambda$86$lambda$42(stateCollectAsStateWithLifecycle5, mutableIntState6, (Bitmap) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composer4, 54);
                zChanged4 = composer4.changed(stateCollectAsStateWithLifecycle);
                objRememberedValue12 = composer4.rememberedValue();
                if (zChanged4) {
                    objRememberedValue12 = new lb.a() { // from class: cu.z17.views.imageEditor.g0
                        @Override // lb.a
                        public final Object invoke() {
                            return Boolean.valueOf(Z17ImageEditorKt.Z17ImageEditor$lambda$95$lambda$86$lambda$44$lambda$43(stateCollectAsStateWithLifecycle));
                        }
                    };
                    composer4.updateRememberedValue(objRememberedValue12);
                } else {
                    objRememberedValue12 = new lb.a() { // from class: cu.z17.views.imageEditor.g0
                        @Override // lb.a
                        public final Object invoke() {
                            return Boolean.valueOf(Z17ImageEditorKt.Z17ImageEditor$lambda$95$lambda$86$lambda$44$lambda$43(stateCollectAsStateWithLifecycle));
                        }
                    };
                    composer4.updateRememberedValue(objRememberedValue12);
                }
                EditorAnimateVisibilityKt.EditorAnimateVisibility(bitmapZ17ImageEditor$lambda$95$lambda$117, composableLambdaRememberComposableLambda114, (lb.a) objRememberedValue12, composer4, 48);
                Modifier modifierA3 = androidx.compose.foundation.layout.x.a(columnScopeInstance3, companion11, 1.0f, false, 2, null);
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy6 = BoxKt.maybeCachedBoxMeasurePolicy(companion9.getTopStart(), false);
                currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                CompositionLocalMap currentCompositionLocalMap9 = composer4.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier9 = ComposedModifierKt.materializeModifier(composer4, modifierA3);
                constructor3 = companion10.getConstructor();
                if (!defpackage.r.a(composer4.getApplier())) {
                    ComposablesKt.invalidApplier();
                }
                composer4.startReusableNode();
                if (composer4.getInserting()) {
                    composer4.createNode(constructor3);
                } else {
                    composer4.useNode();
                }
                composerM5176constructorimpl3 = Updater.m5176constructorimpl(composer4);
                Updater.m5184setimpl(composerM5176constructorimpl3, measurePolicyMaybeCachedBoxMeasurePolicy6, companion10.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl3, currentCompositionLocalMap9, companion10.getSetResolvedCompositionLocals());
                setCompositeKeyHash3 = companion10.getSetCompositeKeyHash();
                if (composerM5176constructorimpl3.getInserting()) {
                    composerM5176constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                    composerM5176constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                } else {
                    composerM5176constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                    composerM5176constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                }
                Updater.m5184setimpl(composerM5176constructorimpl3, modifierMaterializeModifier9, companion10.getSetModifier());
                Bitmap bitmapZ17ImageEditor$lambda$95$lambda$118 = Z17ImageEditor$lambda$95$lambda$3(mutableState);
                Function3 function3M10147getLambda$1781389051$views_release3 = ComposableSingletons$Z17ImageEditorKt.INSTANCE.m10147getLambda$1781389051$views_release();
                zChanged5 = composer4.changed(stateCollectAsStateWithLifecycle);
                objRememberedValue13 = composer4.rememberedValue();
                if (zChanged5) {
                    objRememberedValue13 = new lb.a() { // from class: cu.z17.views.imageEditor.h0
                        @Override // lb.a
                        public final Object invoke() {
                            return Boolean.valueOf(Z17ImageEditorKt.Z17ImageEditor$lambda$95$lambda$86$lambda$71$lambda$46$lambda$45(stateCollectAsStateWithLifecycle));
                        }
                    };
                    composer4.updateRememberedValue(objRememberedValue13);
                } else {
                    objRememberedValue13 = new lb.a() { // from class: cu.z17.views.imageEditor.h0
                        @Override // lb.a
                        public final Object invoke() {
                            return Boolean.valueOf(Z17ImageEditorKt.Z17ImageEditor$lambda$95$lambda$86$lambda$71$lambda$46$lambda$45(stateCollectAsStateWithLifecycle));
                        }
                    };
                    composer4.updateRememberedValue(objRememberedValue13);
                }
                EditorAnimateVisibilityKt.EditorAnimateVisibility(bitmapZ17ImageEditor$lambda$95$lambda$118, function3M10147getLambda$1781389051$views_release3, (lb.a) objRememberedValue13, composer4, 48);
                Bitmap bitmapZ17ImageEditor$lambda$95$lambda$119 = Z17ImageEditor$lambda$95$lambda$3(mutableState);
                ComposableLambda composableLambdaRememberComposableLambda115 = ComposableLambdaKt.rememberComposableLambda(-139639044, true, new Function3() { // from class: cu.z17.views.imageEditor.i
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return Z17ImageEditorKt.Z17ImageEditor$lambda$95$lambda$86$lambda$71$lambda$49(focusRequester3, list3, mutableIntState5, mutableState4, (Bitmap) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composer4, 54);
                zChanged6 = composer4.changed(stateCollectAsStateWithLifecycle);
                objRememberedValue14 = composer4.rememberedValue();
                if (zChanged6) {
                    objRememberedValue14 = new lb.a() { // from class: cu.z17.views.imageEditor.j
                        @Override // lb.a
                        public final Object invoke() {
                            return Boolean.valueOf(Z17ImageEditorKt.Z17ImageEditor$lambda$95$lambda$86$lambda$71$lambda$51$lambda$50(stateCollectAsStateWithLifecycle));
                        }
                    };
                    composer4.updateRememberedValue(objRememberedValue14);
                } else {
                    objRememberedValue14 = new lb.a() { // from class: cu.z17.views.imageEditor.j
                        @Override // lb.a
                        public final Object invoke() {
                            return Boolean.valueOf(Z17ImageEditorKt.Z17ImageEditor$lambda$95$lambda$86$lambda$71$lambda$51$lambda$50(stateCollectAsStateWithLifecycle));
                        }
                    };
                    composer4.updateRememberedValue(objRememberedValue14);
                }
                EditorAnimateVisibilityKt.EditorAnimateVisibility(bitmapZ17ImageEditor$lambda$95$lambda$119, composableLambdaRememberComposableLambda115, (lb.a) objRememberedValue14, composer4, 48);
                Bitmap bitmapZ17ImageEditor$lambda$95$lambda$21 = Z17ImageEditor$lambda$95$lambda$3(mutableState);
                ComposableLambda composableLambdaRememberComposableLambda116 = ComposableLambdaKt.rememberComposableLambda(-368428995, true, new Function3() { // from class: cu.z17.views.imageEditor.k
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return Z17ImageEditorKt.Z17ImageEditor$lambda$95$lambda$86$lambda$71$lambda$56(z17ImageEditorViewModel7, imagePathToSave, onEdited, (Bitmap) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composer4, 54);
                zChanged7 = composer4.changed(stateCollectAsStateWithLifecycle);
                objRememberedValue15 = composer4.rememberedValue();
                if (zChanged7) {
                    objRememberedValue15 = new lb.a() { // from class: cu.z17.views.imageEditor.l
                        @Override // lb.a
                        public final Object invoke() {
                            return Boolean.valueOf(Z17ImageEditorKt.Z17ImageEditor$lambda$95$lambda$86$lambda$71$lambda$58$lambda$57(stateCollectAsStateWithLifecycle));
                        }
                    };
                    composer4.updateRememberedValue(objRememberedValue15);
                } else {
                    objRememberedValue15 = new lb.a() { // from class: cu.z17.views.imageEditor.l
                        @Override // lb.a
                        public final Object invoke() {
                            return Boolean.valueOf(Z17ImageEditorKt.Z17ImageEditor$lambda$95$lambda$86$lambda$71$lambda$58$lambda$57(stateCollectAsStateWithLifecycle));
                        }
                    };
                    composer4.updateRememberedValue(objRememberedValue15);
                }
                EditorAnimateVisibilityKt.EditorAnimateVisibility(bitmapZ17ImageEditor$lambda$95$lambda$21, composableLambdaRememberComposableLambda116, (lb.a) objRememberedValue15, composer4, 48);
                Bitmap bitmapZ17ImageEditor$lambda$95$lambda$1110 = Z17ImageEditor$lambda$95$lambda$3(mutableState);
                ComposableLambda composableLambdaRememberComposableLambda117 = ComposableLambdaKt.rememberComposableLambda(-597218946, true, new Function3() { // from class: cu.z17.views.imageEditor.n
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return Z17ImageEditorKt.Z17ImageEditor$lambda$95$lambda$86$lambda$71$lambda$63(z17ImageEditorViewModel7, imagePathToSave, onEdited, mutableFloatState3, (Bitmap) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composer4, 54);
                zChanged8 = composer4.changed(stateCollectAsStateWithLifecycle);
                objRememberedValue16 = composer4.rememberedValue();
                if (zChanged8) {
                    objRememberedValue16 = new lb.a() { // from class: cu.z17.views.imageEditor.o
                        @Override // lb.a
                        public final Object invoke() {
                            return Boolean.valueOf(Z17ImageEditorKt.Z17ImageEditor$lambda$95$lambda$86$lambda$71$lambda$65$lambda$64(stateCollectAsStateWithLifecycle));
                        }
                    };
                    composer4.updateRememberedValue(objRememberedValue16);
                } else {
                    objRememberedValue16 = new lb.a() { // from class: cu.z17.views.imageEditor.o
                        @Override // lb.a
                        public final Object invoke() {
                            return Boolean.valueOf(Z17ImageEditorKt.Z17ImageEditor$lambda$95$lambda$86$lambda$71$lambda$65$lambda$64(stateCollectAsStateWithLifecycle));
                        }
                    };
                    composer4.updateRememberedValue(objRememberedValue16);
                }
                EditorAnimateVisibilityKt.EditorAnimateVisibility(bitmapZ17ImageEditor$lambda$95$lambda$1110, composableLambdaRememberComposableLambda117, (lb.a) objRememberedValue16, composer4, 48);
                Bitmap bitmapZ17ImageEditor$lambda$95$lambda$1111 = Z17ImageEditor$lambda$95$lambda$3(mutableState);
                ComposableLambda composableLambdaRememberComposableLambda118 = ComposableLambdaKt.rememberComposableLambda(-826008897, true, new Function3() { // from class: cu.z17.views.imageEditor.p
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return Z17ImageEditorKt.Z17ImageEditor$lambda$95$lambda$86$lambda$71$lambda$68(z17ImageEditorViewModel7, stateCollectAsStateWithLifecycle5, mutableIntState6, (Bitmap) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composer4, 54);
                zChanged9 = composer4.changed(stateCollectAsStateWithLifecycle);
                objRememberedValue17 = composer4.rememberedValue();
                if (zChanged9) {
                    objRememberedValue17 = new lb.a() { // from class: cu.z17.views.imageEditor.q
                        @Override // lb.a
                        public final Object invoke() {
                            return Boolean.valueOf(Z17ImageEditorKt.Z17ImageEditor$lambda$95$lambda$86$lambda$71$lambda$70$lambda$69(stateCollectAsStateWithLifecycle));
                        }
                    };
                    composer4.updateRememberedValue(objRememberedValue17);
                } else {
                    objRememberedValue17 = new lb.a() { // from class: cu.z17.views.imageEditor.q
                        @Override // lb.a
                        public final Object invoke() {
                            return Boolean.valueOf(Z17ImageEditorKt.Z17ImageEditor$lambda$95$lambda$86$lambda$71$lambda$70$lambda$69(stateCollectAsStateWithLifecycle));
                        }
                    };
                    composer4.updateRememberedValue(objRememberedValue17);
                }
                EditorAnimateVisibilityKt.EditorAnimateVisibility(bitmapZ17ImageEditor$lambda$95$lambda$1111, composableLambdaRememberComposableLambda118, (lb.a) objRememberedValue17, composer4, 48);
                if (Z17ImageEditor$lambda$95$lambda$0(stateCollectAsStateWithLifecycle) != Z17EditorState.LOADING) {
                    composer4.startReplaceGroup(1210587573);
                    Loading(composer4, 0);
                } else {
                    composer4.startReplaceGroup(1210587573);
                    Loading(composer4, 0);
                }
                composer4.endReplaceGroup();
                composer4.endNode();
                Bitmap bitmapZ17ImageEditor$lambda$95$lambda$1112 = Z17ImageEditor$lambda$95$lambda$3(mutableState);
                ComposableLambda composableLambdaRememberComposableLambda119 = ComposableLambdaKt.rememberComposableLambda(-719497863, true, new Function3() { // from class: cu.z17.views.imageEditor.r
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return Z17ImageEditorKt.Z17ImageEditor$lambda$95$lambda$86$lambda$76(z17ImageEditorViewModel7, (Bitmap) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composer4, 54);
                zChanged10 = composer4.changed(stateCollectAsStateWithLifecycle);
                objRememberedValue18 = composer4.rememberedValue();
                if (zChanged10) {
                    objRememberedValue18 = new lb.a() { // from class: cu.z17.views.imageEditor.s
                        @Override // lb.a
                        public final Object invoke() {
                            return Boolean.valueOf(Z17ImageEditorKt.Z17ImageEditor$lambda$95$lambda$86$lambda$78$lambda$77(stateCollectAsStateWithLifecycle));
                        }
                    };
                    composer4.updateRememberedValue(objRememberedValue18);
                } else {
                    objRememberedValue18 = new lb.a() { // from class: cu.z17.views.imageEditor.s
                        @Override // lb.a
                        public final Object invoke() {
                            return Boolean.valueOf(Z17ImageEditorKt.Z17ImageEditor$lambda$95$lambda$86$lambda$78$lambda$77(stateCollectAsStateWithLifecycle));
                        }
                    };
                    composer4.updateRememberedValue(objRememberedValue18);
                }
                EditorAnimateVisibilityKt.EditorAnimateVisibility(bitmapZ17ImageEditor$lambda$95$lambda$1112, composableLambdaRememberComposableLambda119, (lb.a) objRememberedValue18, composer4, 48);
                Bitmap bitmapZ17ImageEditor$lambda$95$lambda$1113 = Z17ImageEditor$lambda$95$lambda$3(mutableState);
                Function3 function9 = new Function3() { // from class: cu.z17.views.imageEditor.u
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return Z17ImageEditorKt.Z17ImageEditor$lambda$95$lambda$86$lambda$83(stateCollectAsStateWithLifecycle5, z17ImageEditorViewModel7, imagePathToSave, onEdited, mutableIntState6, (Bitmap) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                };
                z17ImageEditorViewModel4 = z17ImageEditorViewModel7;
                function1 = onEdited;
                ComposableLambda composableLambdaRememberComposableLambda1110 = ComposableLambdaKt.rememberComposableLambda(1859870842, true, function9, composer4, 54);
                zChanged11 = composer4.changed(stateCollectAsStateWithLifecycle);
                objRememberedValue19 = composer4.rememberedValue();
                if (zChanged11) {
                    objRememberedValue19 = new lb.a() { // from class: cu.z17.views.imageEditor.v
                        @Override // lb.a
                        public final Object invoke() {
                            return Boolean.valueOf(Z17ImageEditorKt.Z17ImageEditor$lambda$95$lambda$86$lambda$85$lambda$84(stateCollectAsStateWithLifecycle));
                        }
                    };
                    composer4.updateRememberedValue(objRememberedValue19);
                } else {
                    objRememberedValue19 = new lb.a() { // from class: cu.z17.views.imageEditor.v
                        @Override // lb.a
                        public final Object invoke() {
                            return Boolean.valueOf(Z17ImageEditorKt.Z17ImageEditor$lambda$95$lambda$86$lambda$85$lambda$84(stateCollectAsStateWithLifecycle));
                        }
                    };
                    composer4.updateRememberedValue(objRememberedValue19);
                }
                EditorAnimateVisibilityKt.EditorAnimateVisibility(bitmapZ17ImageEditor$lambda$95$lambda$1113, composableLambdaRememberComposableLambda1110, (lb.a) objRememberedValue19, composer4, 48);
                composer4.endNode();
                if (Z17ImageEditor$lambda$95$lambda$11(state)) {
                    composer4.startReplaceGroup(1761407863);
                    zChangedInstance2 = composer4.changedInstance(z17ImageEditorViewModel4);
                    objRememberedValue24 = composer4.rememberedValue();
                    if (zChangedInstance2) {
                        objRememberedValue24 = new lb.a() { // from class: cu.z17.views.imageEditor.w
                            @Override // lb.a
                            public final Object invoke() {
                                return Z17ImageEditorKt.Z17ImageEditor$lambda$95$lambda$88$lambda$87(z17ImageEditorViewModel4);
                            }
                        };
                        composer4.updateRememberedValue(objRememberedValue24);
                    } else {
                        objRememberedValue24 = new lb.a() { // from class: cu.z17.views.imageEditor.w
                            @Override // lb.a
                            public final Object invoke() {
                                return Z17ImageEditorKt.Z17ImageEditor$lambda$95$lambda$88$lambda$87(z17ImageEditorViewModel4);
                            }
                        };
                        composer4.updateRememberedValue(objRememberedValue24);
                    }
                    z15 = true;
                    BackHandlerKt.BackHandler(false, (lb.a) objRememberedValue24, composer4, 0, 1);
                } else {
                    z15 = true;
                    composer4.startReplaceGroup(-1242932030);
                }
                composer4.endReplaceGroup();
                ua.k0 k0Var3 = ua.k0.f43947a;
                boolean zChangedInstance5 = composer4.changedInstance(z17ImageEditorViewModel4) | composer4.changedInstance(source);
                if ((i23 & 896) == 256) {
                    z16 = z15;
                } else {
                    z16 = false;
                }
                boolean z28 = zChangedInstance5 | z16;
                if ((i23 & 7168) == 2048) {
                    z17 = z15;
                } else {
                    z17 = false;
                }
                boolean z29 = z28 | z17;
                if ((57344 & i23) == 16384) {
                    z18 = z15;
                } else {
                    z18 = false;
                }
                z19 = z29 | z18;
                objRememberedValue20 = composer4.rememberedValue();
                if (z19) {
                    f12 = f14;
                    i24 = 131072;
                    Z17ImageEditorKt$Z17ImageEditor$1$3$1 z17ImageEditorKt$Z17ImageEditor$1$3$4 = new Z17ImageEditorKt$Z17ImageEditor$1$3$1(z17ImageEditorViewModel4, source, imagePathToSave, z14, f12, null);
                    z11 = z14;
                    z17ImageEditorViewModel4 = z17ImageEditorViewModel4;
                    composer4.updateRememberedValue(z17ImageEditorKt$Z17ImageEditor$1$3$4);
                    objRememberedValue20 = z17ImageEditorKt$Z17ImageEditor$1$3$4;
                } else {
                    f12 = f14;
                    i24 = 131072;
                    Z17ImageEditorKt$Z17ImageEditor$1$3$1 z17ImageEditorKt$Z17ImageEditor$1$3$5 = new Z17ImageEditorKt$Z17ImageEditor$1$3$1(z17ImageEditorViewModel4, source, imagePathToSave, z14, f12, null);
                    z11 = z14;
                    z17ImageEditorViewModel4 = z17ImageEditorViewModel4;
                    composer4.updateRememberedValue(z17ImageEditorKt$Z17ImageEditor$1$3$5);
                    objRememberedValue20 = z17ImageEditorKt$Z17ImageEditor$1$3$5;
                }
                EffectsKt.LaunchedEffect(k0Var3, (Function2) objRememberedValue20, composer4, 6);
                Z17EditorState z17EditorStateZ17ImageEditor$lambda$95$lambda$2 = Z17ImageEditor$lambda$95$lambda$0(stateCollectAsStateWithLifecycle);
                if ((458752 & i23) == i24) {
                    z20 = z15;
                } else {
                    z20 = false;
                }
                boolean zChanged16 = z20 | composer4.changed(stateCollectAsStateWithLifecycle);
                if ((3670016 & i23) == 1048576) {
                    z21 = z15;
                } else {
                    z21 = false;
                }
                z22 = zChanged16 | z21;
                objRememberedValue21 = composer4.rememberedValue();
                if (z22) {
                    function2 = onViewState;
                    aVar = onError;
                    eVar = null;
                    objRememberedValue21 = new Z17ImageEditorKt$Z17ImageEditor$1$4$1(function2, aVar, stateCollectAsStateWithLifecycle, null);
                    composer4.updateRememberedValue(objRememberedValue21);
                } else {
                    function2 = onViewState;
                    aVar = onError;
                    eVar = null;
                    objRememberedValue21 = new Z17ImageEditorKt$Z17ImageEditor$1$4$1(function2, aVar, stateCollectAsStateWithLifecycle, null);
                    composer4.updateRememberedValue(objRememberedValue21);
                }
                EffectsKt.LaunchedEffect(z17EditorStateZ17ImageEditor$lambda$95$lambda$2, (Function2) objRememberedValue21, composer4, 0);
                Integer numValueOf3 = Integer.valueOf(Z17ImageEditor$lambda$95$lambda$1(stateCollectAsStateWithLifecycle2).size());
                boolean zChanged17 = composer4.changed(stateCollectAsStateWithLifecycle2);
                if ((i23 & 29360128) != 8388608) {
                    z15 = false;
                }
                z23 = zChanged17 | z15;
                objRememberedValue22 = composer4.rememberedValue();
                if (z23) {
                    objRememberedValue22 = new Z17ImageEditorKt$Z17ImageEditor$1$5$1(function1, mutableState, stateCollectAsStateWithLifecycle2, eVar);
                    composer4.updateRememberedValue(objRememberedValue22);
                } else {
                    objRememberedValue22 = new Z17ImageEditorKt$Z17ImageEditor$1$5$1(function1, mutableState, stateCollectAsStateWithLifecycle2, eVar);
                    composer4.updateRememberedValue(objRememberedValue22);
                }
                EffectsKt.LaunchedEffect(numValueOf3, (Function2) objRememberedValue22, composer4, 0);
                zChangedInstance = composer4.changedInstance(z17ImageEditorViewModel4);
                objRememberedValue23 = composer4.rememberedValue();
                if (zChangedInstance) {
                    objRememberedValue23 = new Function1() { // from class: cu.z17.views.imageEditor.y
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return Z17ImageEditorKt.Z17ImageEditor$lambda$95$lambda$94$lambda$93(z17ImageEditorViewModel4, (DisposableEffectScope) obj);
                        }
                    };
                    composer4.updateRememberedValue(objRememberedValue23);
                } else {
                    objRememberedValue23 = new Function1() { // from class: cu.z17.views.imageEditor.y
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return Z17ImageEditorKt.Z17ImageEditor$lambda$95$lambda$94$lambda$93(z17ImageEditorViewModel4, (DisposableEffectScope) obj);
                        }
                    };
                    composer4.updateRememberedValue(objRememberedValue23);
                }
                EffectsKt.DisposableEffect(k0Var3, (Function1) objRememberedValue23, composer4, 6);
                composer4.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z17ImageEditorViewModel2 = z17ImageEditorViewModel4;
                composer2 = composer4;
                context3 = context6;
                imageEditorConfigurations2 = imageEditorConfigurations6;
                modifier3 = modifier7;
            } else {
                function1 = onEdited;
                function2 = onViewState;
                aVar = onError;
                composerStartRestartGroup.skipToGroupEnd();
                z17ImageEditorViewModel2 = z17ImageEditorViewModel;
                context3 = context2;
                modifier3 = modifier2;
                composer2 = composerStartRestartGroup;
                f12 = f11;
                imageEditorConfigurations2 = imageEditorConfigurations;
            }
            z13 = z11;
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final Function1 function10 = function2;
                final Function1 function11 = function1;
                final lb.a aVar4 = aVar;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.imageEditor.z
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return Z17ImageEditorKt.Z17ImageEditor$lambda$96(modifier3, source, imagePathToSave, z13, f12, function10, aVar4, function11, z17ImageEditorViewModel2, context3, imageEditorConfigurations2, i10, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i21 = i11 | 6;
        i19 = i21;
        if ((i17 & 306783379) == 306783378) {
            z12 = true;
        } else {
            z12 = true;
        }
        if (composerStartRestartGroup.shouldExecute(z12, i17 & 1)) {
            composerStartRestartGroup.startDefaults();
            if ((i10 & 1) != 0) {
                if (i28 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (i29 != 0) {
                    z11 = false;
                }
                if (i30 != 0) {
                    f13 = 0.0f;
                } else {
                    f13 = f11;
                }
                if ((i12 & 256) != 0) {
                    path = source.getPath();
                    current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composerStartRestartGroup, 6);
                    if (current == null) {
                        throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                    }
                    if (current instanceof HasDefaultViewModelProviderFactory) {
                        defaultViewModelCreationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                    } else {
                        defaultViewModelCreationExtras = CreationExtras.Empty.INSTANCE;
                    }
                    ViewModel viewModel6 = ViewModelKt.viewModel(z0.b(Z17ImageEditorViewModel.class), current, path, (ViewModelProvider.Factory) null, defaultViewModelCreationExtras, composerStartRestartGroup, 0, 0);
                    composer3 = composerStartRestartGroup;
                    z17ImageEditorViewModel3 = (Z17ImageEditorViewModel) viewModel6;
                    i17 &= -234881025;
                } else {
                    composer3 = composerStartRestartGroup;
                    z17ImageEditorViewModel3 = z17ImageEditorViewModel;
                }
                if ((i12 & 512) != 0) {
                    context2 = (Context) composer3.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                    i17 &= -1879048193;
                }
                if (i18 != 0) {
                    imageEditorConfigurations3 = new ImageEditorConfigurations(false, false, false, false, false, 27, null);
                } else {
                    imageEditorConfigurations3 = imageEditorConfigurations;
                }
                f14 = f13;
            } else {
                if (i28 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (i29 != 0) {
                    z11 = false;
                }
                if (i30 != 0) {
                    f13 = 0.0f;
                } else {
                    f13 = f11;
                }
                if ((i12 & 256) != 0) {
                    path = source.getPath();
                    current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composerStartRestartGroup, 6);
                    if (current == null) {
                        throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                    }
                    if (current instanceof HasDefaultViewModelProviderFactory) {
                        defaultViewModelCreationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                    } else {
                        defaultViewModelCreationExtras = CreationExtras.Empty.INSTANCE;
                    }
                    ViewModel viewModel7 = ViewModelKt.viewModel(z0.b(Z17ImageEditorViewModel.class), current, path, (ViewModelProvider.Factory) null, defaultViewModelCreationExtras, composerStartRestartGroup, 0, 0);
                    composer3 = composerStartRestartGroup;
                    z17ImageEditorViewModel3 = (Z17ImageEditorViewModel) viewModel7;
                    i17 &= -234881025;
                } else {
                    composer3 = composerStartRestartGroup;
                    z17ImageEditorViewModel3 = z17ImageEditorViewModel;
                }
                if ((i12 & 512) != 0) {
                    context2 = (Context) composer3.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                    i17 &= -1879048193;
                }
                if (i18 != 0) {
                    imageEditorConfigurations3 = new ImageEditorConfigurations(false, false, false, false, false, 27, null);
                } else {
                    imageEditorConfigurations3 = imageEditorConfigurations;
                }
                f14 = f13;
            }
            composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                i22 = 1;
                ComposerKt.traceEventStart(804632538, i17, i19, "cu.z17.views.imageEditor.Z17ImageEditor (Z17ImageEditor.kt:72)");
            } else {
                i22 = 1;
            }
            companion = Color.INSTANCE;
            Modifier modifierM1205backgroundbw27NRU$default4 = BackgroundKt.m1205backgroundbw27NRU$default(modifier4, Color.m5865copywmQWz5c$default(companion.m5900getRed0d7_KjU(), 0.15f, 0.0f, 0.0f, 0.0f, 14, null), null, 2, null);
            Modifier modifier8 = modifier4;
            Alignment.Companion companion12 = Alignment.INSTANCE;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy7 = BoxKt.maybeCachedBoxMeasurePolicy(companion12.getTopStart(), false);
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
            CompositionLocalMap currentCompositionLocalMap10 = composer3.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier10 = ComposedModifierKt.materializeModifier(composer3, modifierM1205backgroundbw27NRU$default4);
            ComposeUiNode.Companion companion13 = ComposeUiNode.INSTANCE;
            i23 = i17;
            constructor = companion13.getConstructor();
            if (!defpackage.r.a(composer3.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composer3.startReusableNode();
            if (composer3.getInserting()) {
                composer3.createNode(constructor);
            } else {
                composer3.useNode();
            }
            composerM5176constructorimpl = Updater.m5176constructorimpl(composer3);
            final Z17ImageEditorViewModel z17ImageEditorViewModel8 = z17ImageEditorViewModel3;
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy7, companion13.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap10, companion13.getSetResolvedCompositionLocals());
            setCompositeKeyHash = companion13.getSetCompositeKeyHash();
            if (composerM5176constructorimpl.getInserting()) {
                composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            } else {
                composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier10, companion13.getSetModifier());
            BoxScopeInstance boxScopeInstance4 = BoxScopeInstance.INSTANCE;
            composer4 = composer3;
            stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(z17ImageEditorViewModel8.getCurrentState(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composer4, 0, 7);
            stateCollectAsStateWithLifecycle2 = FlowExtKt.collectAsStateWithLifecycle(z17ImageEditorViewModel8.getHistory().getValue(), va.w.n(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composer4, 48, 14);
            objRememberedValue = composer4.rememberedValue();
            companion2 = Composer.INSTANCE;
            if (objRememberedValue == companion2.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                composer4.updateRememberedValue(objRememberedValue);
            }
            mutableState = (MutableState) objRememberedValue;
            objRememberedValue2 = composer4.rememberedValue();
            if (objRememberedValue2 == companion2.getEmpty()) {
                objRememberedValue2 = new FocusRequester();
                composer4.updateRememberedValue(objRememberedValue2);
            }
            final FocusRequester focusRequester4 = (FocusRequester) objRememberedValue2;
            objRememberedValue3 = composer4.rememberedValue();
            if (objRememberedValue3 == companion2.getEmpty()) {
                objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                composer4.updateRememberedValue(objRememberedValue3);
            }
            final MutableState mutableState5 = (MutableState) objRememberedValue3;
            objRememberedValue4 = composer4.rememberedValue();
            if (objRememberedValue4 == companion2.getEmpty()) {
                objRememberedValue4 = SnapshotStateKt.derivedStateOf(new lb.a() { // from class: cu.z17.views.imageEditor.h
                    @Override // lb.a
                    public final Object invoke() {
                        return Boolean.valueOf(Z17ImageEditorKt.Z17ImageEditor$lambda$95$lambda$10$lambda$9(stateCollectAsStateWithLifecycle));
                    }
                });
                composer4.updateRememberedValue(objRememberedValue4);
            }
            state = (State) objRememberedValue4;
            objRememberedValue5 = composer4.rememberedValue();
            if (objRememberedValue5 == companion2.getEmpty()) {
                Color colorM5856boximpl19 = Color.m5856boximpl(companion.m5903getWhite0d7_KjU());
                Color colorM5856boximpl110 = Color.m5856boximpl(companion.m5892getBlack0d7_KjU());
                Color colorM5856boximpl111 = Color.m5856boximpl(ColorKt.Color(4294940672L));
                Color colorM5856boximpl112 = Color.m5856boximpl(ColorKt.Color(4291176488L));
                Color colorM5856boximpl113 = Color.m5856boximpl(ColorKt.Color(4283215696L));
                Color colorM5856boximpl114 = Color.m5856boximpl(ColorKt.Color(4288423856L));
                Color[] colorArr4 = new Color[6];
                colorArr4[0] = colorM5856boximpl19;
                colorArr4[i22] = colorM5856boximpl110;
                colorArr4[2] = colorM5856boximpl111;
                colorArr4[3] = colorM5856boximpl112;
                colorArr4[i14] = colorM5856boximpl113;
                colorArr4[5] = colorM5856boximpl114;
                objQ = va.w.q(colorArr4);
                composer4.updateRememberedValue(objQ);
            } else {
                objQ = objRememberedValue5;
            }
            final List list4 = (List) objQ;
            objRememberedValue6 = composer4.rememberedValue();
            if (objRememberedValue6 == companion2.getEmpty()) {
                objRememberedValue6 = SnapshotIntStateKt.mutableIntStateOf(0);
                composer4.updateRememberedValue(objRememberedValue6);
            }
            final MutableIntState mutableIntState7 = (MutableIntState) objRememberedValue6;
            objRememberedValue7 = composer4.rememberedValue();
            if (objRememberedValue7 == companion2.getEmpty()) {
                objRememberedValue7 = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
                composer4.updateRememberedValue(objRememberedValue7);
            }
            final MutableFloatState mutableFloatState4 = (MutableFloatState) objRememberedValue7;
            final State stateCollectAsStateWithLifecycle6 = FlowExtKt.collectAsStateWithLifecycle(z17ImageEditorViewModel8.getFilteredBitmaps().getValue(), va.w.n(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composer4, 48, 14);
            objRememberedValue8 = composer4.rememberedValue();
            if (objRememberedValue8 == companion2.getEmpty()) {
                objRememberedValue8 = SnapshotIntStateKt.mutableIntStateOf(0);
                composer4.updateRememberedValue(objRememberedValue8);
            }
            final MutableIntState mutableIntState8 = (MutableIntState) objRememberedValue8;
            Modifier.Companion companion14 = Modifier.INSTANCE;
            final Context context7 = context2;
            final ImageEditorConfigurations imageEditorConfigurations7 = imageEditorConfigurations3;
            Modifier modifierFillMaxSize$default4 = SizeKt.fillMaxSize$default(companion14, 0.0f, i22, null);
            MeasurePolicy measurePolicyColumnMeasurePolicy4 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), companion12.getStart(), composer4, 0);
            currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
            CompositionLocalMap currentCompositionLocalMap11 = composer4.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier11 = ComposedModifierKt.materializeModifier(composer4, modifierFillMaxSize$default4);
            constructor2 = companion13.getConstructor();
            if (!defpackage.r.a(composer4.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composer4.startReusableNode();
            if (composer4.getInserting()) {
                composer4.createNode(constructor2);
            } else {
                composer4.useNode();
            }
            composerM5176constructorimpl2 = Updater.m5176constructorimpl(composer4);
            Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyColumnMeasurePolicy4, companion13.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap11, companion13.getSetResolvedCompositionLocals());
            setCompositeKeyHash2 = companion13.getSetCompositeKeyHash();
            if (composerM5176constructorimpl2.getInserting()) {
                composerM5176constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                composerM5176constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            } else {
                composerM5176constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                composerM5176constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier11, companion13.getSetModifier());
            ColumnScopeInstance columnScopeInstance4 = ColumnScopeInstance.INSTANCE;
            Bitmap bitmapZ17ImageEditor$lambda$95$lambda$1114 = Z17ImageEditor$lambda$95$lambda$3(mutableState);
            z14 = z11;
            ComposableLambda composableLambdaRememberComposableLambda1111 = ComposableLambdaKt.rememberComposableLambda(272879167, true, new Function3() { // from class: cu.z17.views.imageEditor.t
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return Z17ImageEditorKt.Z17ImageEditor$lambda$95$lambda$86$lambda$27(z17ImageEditorViewModel8, imagePathToSave, context7, imageEditorConfigurations7, stateCollectAsStateWithLifecycle2, (Bitmap) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer4, 54);
            zChanged = composer4.changed(stateCollectAsStateWithLifecycle);
            objRememberedValue9 = composer4.rememberedValue();
            if (zChanged) {
                objRememberedValue9 = new lb.a() { // from class: cu.z17.views.imageEditor.a0
                    @Override // lb.a
                    public final Object invoke() {
                        return Boolean.valueOf(Z17ImageEditorKt.Z17ImageEditor$lambda$95$lambda$86$lambda$29$lambda$28(stateCollectAsStateWithLifecycle));
                    }
                };
                composer4.updateRememberedValue(objRememberedValue9);
            } else {
                objRememberedValue9 = new lb.a() { // from class: cu.z17.views.imageEditor.a0
                    @Override // lb.a
                    public final Object invoke() {
                        return Boolean.valueOf(Z17ImageEditorKt.Z17ImageEditor$lambda$95$lambda$86$lambda$29$lambda$28(stateCollectAsStateWithLifecycle));
                    }
                };
                composer4.updateRememberedValue(objRememberedValue9);
            }
            EditorAnimateVisibilityKt.EditorAnimateVisibility(bitmapZ17ImageEditor$lambda$95$lambda$1114, composableLambdaRememberComposableLambda1111, (lb.a) objRememberedValue9, composer4, 48);
            Bitmap bitmapZ17ImageEditor$lambda$95$lambda$1115 = Z17ImageEditor$lambda$95$lambda$3(mutableState);
            ComposableLambda composableLambdaRememberComposableLambda1112 = ComposableLambdaKt.rememberComposableLambda(132330614, true, new Function3() { // from class: cu.z17.views.imageEditor.b0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return Z17ImageEditorKt.Z17ImageEditor$lambda$95$lambda$86$lambda$32(list4, mutableIntState7, (Bitmap) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer4, 54);
            zChanged2 = composer4.changed(stateCollectAsStateWithLifecycle);
            objRememberedValue10 = composer4.rememberedValue();
            if (zChanged2) {
                objRememberedValue10 = new lb.a() { // from class: cu.z17.views.imageEditor.c0
                    @Override // lb.a
                    public final Object invoke() {
                        return Boolean.valueOf(Z17ImageEditorKt.Z17ImageEditor$lambda$95$lambda$86$lambda$34$lambda$33(stateCollectAsStateWithLifecycle));
                    }
                };
                composer4.updateRememberedValue(objRememberedValue10);
            } else {
                objRememberedValue10 = new lb.a() { // from class: cu.z17.views.imageEditor.c0
                    @Override // lb.a
                    public final Object invoke() {
                        return Boolean.valueOf(Z17ImageEditorKt.Z17ImageEditor$lambda$95$lambda$86$lambda$34$lambda$33(stateCollectAsStateWithLifecycle));
                    }
                };
                composer4.updateRememberedValue(objRememberedValue10);
            }
            EditorAnimateVisibilityKt.EditorAnimateVisibility(bitmapZ17ImageEditor$lambda$95$lambda$1115, composableLambdaRememberComposableLambda1112, (lb.a) objRememberedValue10, composer4, 48);
            Bitmap bitmapZ17ImageEditor$lambda$95$lambda$1116 = Z17ImageEditor$lambda$95$lambda$3(mutableState);
            ComposableLambda composableLambdaRememberComposableLambda1113 = ComposableLambdaKt.rememberComposableLambda(-1583267977, true, new Function3() { // from class: cu.z17.views.imageEditor.d0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return Z17ImageEditorKt.Z17ImageEditor$lambda$95$lambda$86$lambda$37(mutableFloatState4, (Bitmap) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer4, 54);
            zChanged3 = composer4.changed(stateCollectAsStateWithLifecycle);
            objRememberedValue11 = composer4.rememberedValue();
            if (zChanged3) {
                objRememberedValue11 = new lb.a() { // from class: cu.z17.views.imageEditor.e0
                    @Override // lb.a
                    public final Object invoke() {
                        return Boolean.valueOf(Z17ImageEditorKt.Z17ImageEditor$lambda$95$lambda$86$lambda$39$lambda$38(stateCollectAsStateWithLifecycle));
                    }
                };
                composer4.updateRememberedValue(objRememberedValue11);
            } else {
                objRememberedValue11 = new lb.a() { // from class: cu.z17.views.imageEditor.e0
                    @Override // lb.a
                    public final Object invoke() {
                        return Boolean.valueOf(Z17ImageEditorKt.Z17ImageEditor$lambda$95$lambda$86$lambda$39$lambda$38(stateCollectAsStateWithLifecycle));
                    }
                };
                composer4.updateRememberedValue(objRememberedValue11);
            }
            EditorAnimateVisibilityKt.EditorAnimateVisibility(bitmapZ17ImageEditor$lambda$95$lambda$1116, composableLambdaRememberComposableLambda1113, (lb.a) objRememberedValue11, composer4, 48);
            Bitmap bitmapZ17ImageEditor$lambda$95$lambda$1117 = Z17ImageEditor$lambda$95$lambda$3(mutableState);
            ComposableLambda composableLambdaRememberComposableLambda1114 = ComposableLambdaKt.rememberComposableLambda(996100728, true, new Function3() { // from class: cu.z17.views.imageEditor.f0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return Z17ImageEditorKt.Z17ImageEditor$lambda$95$lambda$86$lambda$42(stateCollectAsStateWithLifecycle6, mutableIntState8, (Bitmap) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer4, 54);
            zChanged4 = composer4.changed(stateCollectAsStateWithLifecycle);
            objRememberedValue12 = composer4.rememberedValue();
            if (zChanged4) {
                objRememberedValue12 = new lb.a() { // from class: cu.z17.views.imageEditor.g0
                    @Override // lb.a
                    public final Object invoke() {
                        return Boolean.valueOf(Z17ImageEditorKt.Z17ImageEditor$lambda$95$lambda$86$lambda$44$lambda$43(stateCollectAsStateWithLifecycle));
                    }
                };
                composer4.updateRememberedValue(objRememberedValue12);
            } else {
                objRememberedValue12 = new lb.a() { // from class: cu.z17.views.imageEditor.g0
                    @Override // lb.a
                    public final Object invoke() {
                        return Boolean.valueOf(Z17ImageEditorKt.Z17ImageEditor$lambda$95$lambda$86$lambda$44$lambda$43(stateCollectAsStateWithLifecycle));
                    }
                };
                composer4.updateRememberedValue(objRememberedValue12);
            }
            EditorAnimateVisibilityKt.EditorAnimateVisibility(bitmapZ17ImageEditor$lambda$95$lambda$1117, composableLambdaRememberComposableLambda1114, (lb.a) objRememberedValue12, composer4, 48);
            Modifier modifierA4 = androidx.compose.foundation.layout.x.a(columnScopeInstance4, companion14, 1.0f, false, 2, null);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy8 = BoxKt.maybeCachedBoxMeasurePolicy(companion12.getTopStart(), false);
            currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
            CompositionLocalMap currentCompositionLocalMap12 = composer4.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier12 = ComposedModifierKt.materializeModifier(composer4, modifierA4);
            constructor3 = companion13.getConstructor();
            if (!defpackage.r.a(composer4.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composer4.startReusableNode();
            if (composer4.getInserting()) {
                composer4.createNode(constructor3);
            } else {
                composer4.useNode();
            }
            composerM5176constructorimpl3 = Updater.m5176constructorimpl(composer4);
            Updater.m5184setimpl(composerM5176constructorimpl3, measurePolicyMaybeCachedBoxMeasurePolicy8, companion13.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl3, currentCompositionLocalMap12, companion13.getSetResolvedCompositionLocals());
            setCompositeKeyHash3 = companion13.getSetCompositeKeyHash();
            if (composerM5176constructorimpl3.getInserting()) {
                composerM5176constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                composerM5176constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
            } else {
                composerM5176constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                composerM5176constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
            }
            Updater.m5184setimpl(composerM5176constructorimpl3, modifierMaterializeModifier12, companion13.getSetModifier());
            Bitmap bitmapZ17ImageEditor$lambda$95$lambda$1118 = Z17ImageEditor$lambda$95$lambda$3(mutableState);
            Function3 function3M10147getLambda$1781389051$views_release4 = ComposableSingletons$Z17ImageEditorKt.INSTANCE.m10147getLambda$1781389051$views_release();
            zChanged5 = composer4.changed(stateCollectAsStateWithLifecycle);
            objRememberedValue13 = composer4.rememberedValue();
            if (zChanged5) {
                objRememberedValue13 = new lb.a() { // from class: cu.z17.views.imageEditor.h0
                    @Override // lb.a
                    public final Object invoke() {
                        return Boolean.valueOf(Z17ImageEditorKt.Z17ImageEditor$lambda$95$lambda$86$lambda$71$lambda$46$lambda$45(stateCollectAsStateWithLifecycle));
                    }
                };
                composer4.updateRememberedValue(objRememberedValue13);
            } else {
                objRememberedValue13 = new lb.a() { // from class: cu.z17.views.imageEditor.h0
                    @Override // lb.a
                    public final Object invoke() {
                        return Boolean.valueOf(Z17ImageEditorKt.Z17ImageEditor$lambda$95$lambda$86$lambda$71$lambda$46$lambda$45(stateCollectAsStateWithLifecycle));
                    }
                };
                composer4.updateRememberedValue(objRememberedValue13);
            }
            EditorAnimateVisibilityKt.EditorAnimateVisibility(bitmapZ17ImageEditor$lambda$95$lambda$1118, function3M10147getLambda$1781389051$views_release4, (lb.a) objRememberedValue13, composer4, 48);
            Bitmap bitmapZ17ImageEditor$lambda$95$lambda$1119 = Z17ImageEditor$lambda$95$lambda$3(mutableState);
            ComposableLambda composableLambdaRememberComposableLambda1115 = ComposableLambdaKt.rememberComposableLambda(-139639044, true, new Function3() { // from class: cu.z17.views.imageEditor.i
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return Z17ImageEditorKt.Z17ImageEditor$lambda$95$lambda$86$lambda$71$lambda$49(focusRequester4, list4, mutableIntState7, mutableState5, (Bitmap) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer4, 54);
            zChanged6 = composer4.changed(stateCollectAsStateWithLifecycle);
            objRememberedValue14 = composer4.rememberedValue();
            if (zChanged6) {
                objRememberedValue14 = new lb.a() { // from class: cu.z17.views.imageEditor.j
                    @Override // lb.a
                    public final Object invoke() {
                        return Boolean.valueOf(Z17ImageEditorKt.Z17ImageEditor$lambda$95$lambda$86$lambda$71$lambda$51$lambda$50(stateCollectAsStateWithLifecycle));
                    }
                };
                composer4.updateRememberedValue(objRememberedValue14);
            } else {
                objRememberedValue14 = new lb.a() { // from class: cu.z17.views.imageEditor.j
                    @Override // lb.a
                    public final Object invoke() {
                        return Boolean.valueOf(Z17ImageEditorKt.Z17ImageEditor$lambda$95$lambda$86$lambda$71$lambda$51$lambda$50(stateCollectAsStateWithLifecycle));
                    }
                };
                composer4.updateRememberedValue(objRememberedValue14);
            }
            EditorAnimateVisibilityKt.EditorAnimateVisibility(bitmapZ17ImageEditor$lambda$95$lambda$1119, composableLambdaRememberComposableLambda1115, (lb.a) objRememberedValue14, composer4, 48);
            Bitmap bitmapZ17ImageEditor$lambda$95$lambda$22 = Z17ImageEditor$lambda$95$lambda$3(mutableState);
            ComposableLambda composableLambdaRememberComposableLambda1116 = ComposableLambdaKt.rememberComposableLambda(-368428995, true, new Function3() { // from class: cu.z17.views.imageEditor.k
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return Z17ImageEditorKt.Z17ImageEditor$lambda$95$lambda$86$lambda$71$lambda$56(z17ImageEditorViewModel8, imagePathToSave, onEdited, (Bitmap) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer4, 54);
            zChanged7 = composer4.changed(stateCollectAsStateWithLifecycle);
            objRememberedValue15 = composer4.rememberedValue();
            if (zChanged7) {
                objRememberedValue15 = new lb.a() { // from class: cu.z17.views.imageEditor.l
                    @Override // lb.a
                    public final Object invoke() {
                        return Boolean.valueOf(Z17ImageEditorKt.Z17ImageEditor$lambda$95$lambda$86$lambda$71$lambda$58$lambda$57(stateCollectAsStateWithLifecycle));
                    }
                };
                composer4.updateRememberedValue(objRememberedValue15);
            } else {
                objRememberedValue15 = new lb.a() { // from class: cu.z17.views.imageEditor.l
                    @Override // lb.a
                    public final Object invoke() {
                        return Boolean.valueOf(Z17ImageEditorKt.Z17ImageEditor$lambda$95$lambda$86$lambda$71$lambda$58$lambda$57(stateCollectAsStateWithLifecycle));
                    }
                };
                composer4.updateRememberedValue(objRememberedValue15);
            }
            EditorAnimateVisibilityKt.EditorAnimateVisibility(bitmapZ17ImageEditor$lambda$95$lambda$22, composableLambdaRememberComposableLambda1116, (lb.a) objRememberedValue15, composer4, 48);
            Bitmap bitmapZ17ImageEditor$lambda$95$lambda$11110 = Z17ImageEditor$lambda$95$lambda$3(mutableState);
            ComposableLambda composableLambdaRememberComposableLambda1117 = ComposableLambdaKt.rememberComposableLambda(-597218946, true, new Function3() { // from class: cu.z17.views.imageEditor.n
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return Z17ImageEditorKt.Z17ImageEditor$lambda$95$lambda$86$lambda$71$lambda$63(z17ImageEditorViewModel8, imagePathToSave, onEdited, mutableFloatState4, (Bitmap) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer4, 54);
            zChanged8 = composer4.changed(stateCollectAsStateWithLifecycle);
            objRememberedValue16 = composer4.rememberedValue();
            if (zChanged8) {
                objRememberedValue16 = new lb.a() { // from class: cu.z17.views.imageEditor.o
                    @Override // lb.a
                    public final Object invoke() {
                        return Boolean.valueOf(Z17ImageEditorKt.Z17ImageEditor$lambda$95$lambda$86$lambda$71$lambda$65$lambda$64(stateCollectAsStateWithLifecycle));
                    }
                };
                composer4.updateRememberedValue(objRememberedValue16);
            } else {
                objRememberedValue16 = new lb.a() { // from class: cu.z17.views.imageEditor.o
                    @Override // lb.a
                    public final Object invoke() {
                        return Boolean.valueOf(Z17ImageEditorKt.Z17ImageEditor$lambda$95$lambda$86$lambda$71$lambda$65$lambda$64(stateCollectAsStateWithLifecycle));
                    }
                };
                composer4.updateRememberedValue(objRememberedValue16);
            }
            EditorAnimateVisibilityKt.EditorAnimateVisibility(bitmapZ17ImageEditor$lambda$95$lambda$11110, composableLambdaRememberComposableLambda1117, (lb.a) objRememberedValue16, composer4, 48);
            Bitmap bitmapZ17ImageEditor$lambda$95$lambda$11111 = Z17ImageEditor$lambda$95$lambda$3(mutableState);
            ComposableLambda composableLambdaRememberComposableLambda1118 = ComposableLambdaKt.rememberComposableLambda(-826008897, true, new Function3() { // from class: cu.z17.views.imageEditor.p
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return Z17ImageEditorKt.Z17ImageEditor$lambda$95$lambda$86$lambda$71$lambda$68(z17ImageEditorViewModel8, stateCollectAsStateWithLifecycle6, mutableIntState8, (Bitmap) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer4, 54);
            zChanged9 = composer4.changed(stateCollectAsStateWithLifecycle);
            objRememberedValue17 = composer4.rememberedValue();
            if (zChanged9) {
                objRememberedValue17 = new lb.a() { // from class: cu.z17.views.imageEditor.q
                    @Override // lb.a
                    public final Object invoke() {
                        return Boolean.valueOf(Z17ImageEditorKt.Z17ImageEditor$lambda$95$lambda$86$lambda$71$lambda$70$lambda$69(stateCollectAsStateWithLifecycle));
                    }
                };
                composer4.updateRememberedValue(objRememberedValue17);
            } else {
                objRememberedValue17 = new lb.a() { // from class: cu.z17.views.imageEditor.q
                    @Override // lb.a
                    public final Object invoke() {
                        return Boolean.valueOf(Z17ImageEditorKt.Z17ImageEditor$lambda$95$lambda$86$lambda$71$lambda$70$lambda$69(stateCollectAsStateWithLifecycle));
                    }
                };
                composer4.updateRememberedValue(objRememberedValue17);
            }
            EditorAnimateVisibilityKt.EditorAnimateVisibility(bitmapZ17ImageEditor$lambda$95$lambda$11111, composableLambdaRememberComposableLambda1118, (lb.a) objRememberedValue17, composer4, 48);
            if (Z17ImageEditor$lambda$95$lambda$0(stateCollectAsStateWithLifecycle) != Z17EditorState.LOADING) {
                composer4.startReplaceGroup(1210587573);
                Loading(composer4, 0);
            } else {
                composer4.startReplaceGroup(1210587573);
                Loading(composer4, 0);
            }
            composer4.endReplaceGroup();
            composer4.endNode();
            Bitmap bitmapZ17ImageEditor$lambda$95$lambda$11112 = Z17ImageEditor$lambda$95$lambda$3(mutableState);
            ComposableLambda composableLambdaRememberComposableLambda1119 = ComposableLambdaKt.rememberComposableLambda(-719497863, true, new Function3() { // from class: cu.z17.views.imageEditor.r
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return Z17ImageEditorKt.Z17ImageEditor$lambda$95$lambda$86$lambda$76(z17ImageEditorViewModel8, (Bitmap) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer4, 54);
            zChanged10 = composer4.changed(stateCollectAsStateWithLifecycle);
            objRememberedValue18 = composer4.rememberedValue();
            if (zChanged10) {
                objRememberedValue18 = new lb.a() { // from class: cu.z17.views.imageEditor.s
                    @Override // lb.a
                    public final Object invoke() {
                        return Boolean.valueOf(Z17ImageEditorKt.Z17ImageEditor$lambda$95$lambda$86$lambda$78$lambda$77(stateCollectAsStateWithLifecycle));
                    }
                };
                composer4.updateRememberedValue(objRememberedValue18);
            } else {
                objRememberedValue18 = new lb.a() { // from class: cu.z17.views.imageEditor.s
                    @Override // lb.a
                    public final Object invoke() {
                        return Boolean.valueOf(Z17ImageEditorKt.Z17ImageEditor$lambda$95$lambda$86$lambda$78$lambda$77(stateCollectAsStateWithLifecycle));
                    }
                };
                composer4.updateRememberedValue(objRememberedValue18);
            }
            EditorAnimateVisibilityKt.EditorAnimateVisibility(bitmapZ17ImageEditor$lambda$95$lambda$11112, composableLambdaRememberComposableLambda1119, (lb.a) objRememberedValue18, composer4, 48);
            Bitmap bitmapZ17ImageEditor$lambda$95$lambda$11113 = Z17ImageEditor$lambda$95$lambda$3(mutableState);
            Function3 function12 = new Function3() { // from class: cu.z17.views.imageEditor.u
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return Z17ImageEditorKt.Z17ImageEditor$lambda$95$lambda$86$lambda$83(stateCollectAsStateWithLifecycle6, z17ImageEditorViewModel8, imagePathToSave, onEdited, mutableIntState8, (Bitmap) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            };
            z17ImageEditorViewModel4 = z17ImageEditorViewModel8;
            function1 = onEdited;
            ComposableLambda composableLambdaRememberComposableLambda11110 = ComposableLambdaKt.rememberComposableLambda(1859870842, true, function12, composer4, 54);
            zChanged11 = composer4.changed(stateCollectAsStateWithLifecycle);
            objRememberedValue19 = composer4.rememberedValue();
            if (zChanged11) {
                objRememberedValue19 = new lb.a() { // from class: cu.z17.views.imageEditor.v
                    @Override // lb.a
                    public final Object invoke() {
                        return Boolean.valueOf(Z17ImageEditorKt.Z17ImageEditor$lambda$95$lambda$86$lambda$85$lambda$84(stateCollectAsStateWithLifecycle));
                    }
                };
                composer4.updateRememberedValue(objRememberedValue19);
            } else {
                objRememberedValue19 = new lb.a() { // from class: cu.z17.views.imageEditor.v
                    @Override // lb.a
                    public final Object invoke() {
                        return Boolean.valueOf(Z17ImageEditorKt.Z17ImageEditor$lambda$95$lambda$86$lambda$85$lambda$84(stateCollectAsStateWithLifecycle));
                    }
                };
                composer4.updateRememberedValue(objRememberedValue19);
            }
            EditorAnimateVisibilityKt.EditorAnimateVisibility(bitmapZ17ImageEditor$lambda$95$lambda$11113, composableLambdaRememberComposableLambda11110, (lb.a) objRememberedValue19, composer4, 48);
            composer4.endNode();
            if (Z17ImageEditor$lambda$95$lambda$11(state)) {
                composer4.startReplaceGroup(1761407863);
                zChangedInstance2 = composer4.changedInstance(z17ImageEditorViewModel4);
                objRememberedValue24 = composer4.rememberedValue();
                if (zChangedInstance2) {
                    objRememberedValue24 = new lb.a() { // from class: cu.z17.views.imageEditor.w
                        @Override // lb.a
                        public final Object invoke() {
                            return Z17ImageEditorKt.Z17ImageEditor$lambda$95$lambda$88$lambda$87(z17ImageEditorViewModel4);
                        }
                    };
                    composer4.updateRememberedValue(objRememberedValue24);
                } else {
                    objRememberedValue24 = new lb.a() { // from class: cu.z17.views.imageEditor.w
                        @Override // lb.a
                        public final Object invoke() {
                            return Z17ImageEditorKt.Z17ImageEditor$lambda$95$lambda$88$lambda$87(z17ImageEditorViewModel4);
                        }
                    };
                    composer4.updateRememberedValue(objRememberedValue24);
                }
                z15 = true;
                BackHandlerKt.BackHandler(false, (lb.a) objRememberedValue24, composer4, 0, 1);
            } else {
                z15 = true;
                composer4.startReplaceGroup(-1242932030);
            }
            composer4.endReplaceGroup();
            ua.k0 k0Var4 = ua.k0.f43947a;
            boolean zChangedInstance6 = composer4.changedInstance(z17ImageEditorViewModel4) | composer4.changedInstance(source);
            if ((i23 & 896) == 256) {
                z16 = z15;
            } else {
                z16 = false;
            }
            boolean z210 = zChangedInstance6 | z16;
            if ((i23 & 7168) == 2048) {
                z17 = z15;
            } else {
                z17 = false;
            }
            boolean z211 = z210 | z17;
            if ((57344 & i23) == 16384) {
                z18 = z15;
            } else {
                z18 = false;
            }
            z19 = z211 | z18;
            objRememberedValue20 = composer4.rememberedValue();
            if (z19) {
                f12 = f14;
                i24 = 131072;
                Z17ImageEditorKt$Z17ImageEditor$1$3$1 z17ImageEditorKt$Z17ImageEditor$1$3$6 = new Z17ImageEditorKt$Z17ImageEditor$1$3$1(z17ImageEditorViewModel4, source, imagePathToSave, z14, f12, null);
                z11 = z14;
                z17ImageEditorViewModel4 = z17ImageEditorViewModel4;
                composer4.updateRememberedValue(z17ImageEditorKt$Z17ImageEditor$1$3$6);
                objRememberedValue20 = z17ImageEditorKt$Z17ImageEditor$1$3$6;
            } else {
                f12 = f14;
                i24 = 131072;
                Z17ImageEditorKt$Z17ImageEditor$1$3$1 z17ImageEditorKt$Z17ImageEditor$1$3$7 = new Z17ImageEditorKt$Z17ImageEditor$1$3$1(z17ImageEditorViewModel4, source, imagePathToSave, z14, f12, null);
                z11 = z14;
                z17ImageEditorViewModel4 = z17ImageEditorViewModel4;
                composer4.updateRememberedValue(z17ImageEditorKt$Z17ImageEditor$1$3$7);
                objRememberedValue20 = z17ImageEditorKt$Z17ImageEditor$1$3$7;
            }
            EffectsKt.LaunchedEffect(k0Var4, (Function2) objRememberedValue20, composer4, 6);
            Z17EditorState z17EditorStateZ17ImageEditor$lambda$95$lambda$3 = Z17ImageEditor$lambda$95$lambda$0(stateCollectAsStateWithLifecycle);
            if ((458752 & i23) == i24) {
                z20 = z15;
            } else {
                z20 = false;
            }
            boolean zChanged18 = z20 | composer4.changed(stateCollectAsStateWithLifecycle);
            if ((3670016 & i23) == 1048576) {
                z21 = z15;
            } else {
                z21 = false;
            }
            z22 = zChanged18 | z21;
            objRememberedValue21 = composer4.rememberedValue();
            if (z22) {
                function2 = onViewState;
                aVar = onError;
                eVar = null;
                objRememberedValue21 = new Z17ImageEditorKt$Z17ImageEditor$1$4$1(function2, aVar, stateCollectAsStateWithLifecycle, null);
                composer4.updateRememberedValue(objRememberedValue21);
            } else {
                function2 = onViewState;
                aVar = onError;
                eVar = null;
                objRememberedValue21 = new Z17ImageEditorKt$Z17ImageEditor$1$4$1(function2, aVar, stateCollectAsStateWithLifecycle, null);
                composer4.updateRememberedValue(objRememberedValue21);
            }
            EffectsKt.LaunchedEffect(z17EditorStateZ17ImageEditor$lambda$95$lambda$3, (Function2) objRememberedValue21, composer4, 0);
            Integer numValueOf4 = Integer.valueOf(Z17ImageEditor$lambda$95$lambda$1(stateCollectAsStateWithLifecycle2).size());
            boolean zChanged19 = composer4.changed(stateCollectAsStateWithLifecycle2);
            if ((i23 & 29360128) != 8388608) {
                z15 = false;
            }
            z23 = zChanged19 | z15;
            objRememberedValue22 = composer4.rememberedValue();
            if (z23) {
                objRememberedValue22 = new Z17ImageEditorKt$Z17ImageEditor$1$5$1(function1, mutableState, stateCollectAsStateWithLifecycle2, eVar);
                composer4.updateRememberedValue(objRememberedValue22);
            } else {
                objRememberedValue22 = new Z17ImageEditorKt$Z17ImageEditor$1$5$1(function1, mutableState, stateCollectAsStateWithLifecycle2, eVar);
                composer4.updateRememberedValue(objRememberedValue22);
            }
            EffectsKt.LaunchedEffect(numValueOf4, (Function2) objRememberedValue22, composer4, 0);
            zChangedInstance = composer4.changedInstance(z17ImageEditorViewModel4);
            objRememberedValue23 = composer4.rememberedValue();
            if (zChangedInstance) {
                objRememberedValue23 = new Function1() { // from class: cu.z17.views.imageEditor.y
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Z17ImageEditorKt.Z17ImageEditor$lambda$95$lambda$94$lambda$93(z17ImageEditorViewModel4, (DisposableEffectScope) obj);
                    }
                };
                composer4.updateRememberedValue(objRememberedValue23);
            } else {
                objRememberedValue23 = new Function1() { // from class: cu.z17.views.imageEditor.y
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Z17ImageEditorKt.Z17ImageEditor$lambda$95$lambda$94$lambda$93(z17ImageEditorViewModel4, (DisposableEffectScope) obj);
                    }
                };
                composer4.updateRememberedValue(objRememberedValue23);
            }
            EffectsKt.DisposableEffect(k0Var4, (Function1) objRememberedValue23, composer4, 6);
            composer4.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            z17ImageEditorViewModel2 = z17ImageEditorViewModel4;
            composer2 = composer4;
            context3 = context7;
            imageEditorConfigurations2 = imageEditorConfigurations7;
            modifier3 = modifier8;
        } else {
            function1 = onEdited;
            function2 = onViewState;
            aVar = onError;
            composerStartRestartGroup.skipToGroupEnd();
            z17ImageEditorViewModel2 = z17ImageEditorViewModel;
            context3 = context2;
            modifier3 = modifier2;
            composer2 = composerStartRestartGroup;
            f12 = f11;
            imageEditorConfigurations2 = imageEditorConfigurations;
        }
        z13 = z11;
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Function1 function13 = function2;
            final Function1 function14 = function1;
            final lb.a aVar5 = aVar;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.imageEditor.z
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return Z17ImageEditorKt.Z17ImageEditor$lambda$96(modifier3, source, imagePathToSave, z13, f12, function13, aVar5, function14, z17ImageEditorViewModel2, context3, imageEditorConfigurations2, i10, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Z17EditorState Z17ImageEditor$lambda$95$lambda$0(State<? extends Z17EditorState> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<Bitmap> Z17ImageEditor$lambda$95$lambda$1(State<? extends List<Bitmap>> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Z17ImageEditor$lambda$95$lambda$10$lambda$9(State state) {
        return Z17ImageEditor$lambda$95$lambda$0(state) == Z17EditorState.VIEW;
    }

    private static final boolean Z17ImageEditor$lambda$95$lambda$11(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    private static final List<Bitmap> Z17ImageEditor$lambda$95$lambda$19(State<? extends List<Bitmap>> state) {
        return state.getValue();
    }

    private static final Bitmap Z17ImageEditor$lambda$95$lambda$3(MutableState<Bitmap> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 Z17ImageEditor$lambda$95$lambda$86$lambda$27(final Z17ImageEditorViewModel z17ImageEditorViewModel, final String str, final Context context, ImageEditorConfigurations imageEditorConfigurations, State state, Bitmap it, Composer composer, int i10) {
        kotlin.jvm.internal.y.i(it, "it");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(272879167, i10, -1, "cu.z17.views.imageEditor.Z17ImageEditor.<anonymous>.<anonymous>.<anonymous> (Z17ImageEditor.kt:130)");
        }
        Modifier modifierSafeContentPadding = WindowInsetsPadding_androidKt.safeContentPadding(Modifier.INSTANCE);
        int size = Z17ImageEditor$lambda$95$lambda$1(state).size();
        boolean zChangedInstance = composer.changedInstance(z17ImageEditorViewModel);
        Object objRememberedValue = composer.rememberedValue();
        if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new Z17ImageEditorKt$Z17ImageEditor$1$1$1$1$1(z17ImageEditorViewModel);
            composer.updateRememberedValue(objRememberedValue);
        }
        sb.h hVar = (sb.h) objRememberedValue;
        boolean zChangedInstance2 = composer.changedInstance(z17ImageEditorViewModel);
        Object objRememberedValue2 = composer.rememberedValue();
        if (zChangedInstance2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = new Z17ImageEditorKt$Z17ImageEditor$1$1$1$2$1(z17ImageEditorViewModel);
            composer.updateRememberedValue(objRememberedValue2);
        }
        Function1 function1 = (Function1) objRememberedValue2;
        Function1 function2 = (Function1) hVar;
        boolean zChangedInstance3 = composer.changedInstance(z17ImageEditorViewModel) | composer.changed(str) | composer.changedInstance(context);
        Object objRememberedValue3 = composer.rememberedValue();
        if (zChangedInstance3 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue3 = new lb.a() { // from class: cu.z17.views.imageEditor.c
                @Override // lb.a
                public final Object invoke() {
                    return Z17ImageEditorKt.Z17ImageEditor$lambda$95$lambda$86$lambda$27$lambda$26$lambda$25(z17ImageEditorViewModel, str, context);
                }
            };
            composer.updateRememberedValue(objRememberedValue3);
        }
        ViewerTopBarKt.ViewerTopBar(modifierSafeContentPadding, size, str, function1, function2, (lb.a) objRememberedValue3, imageEditorConfigurations, composer, 0, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 Z17ImageEditor$lambda$95$lambda$86$lambda$27$lambda$26$lambda$25(Z17ImageEditorViewModel z17ImageEditorViewModel, String str, Context context) {
        z17ImageEditorViewModel.requestCompress(str, context);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Z17ImageEditor$lambda$95$lambda$86$lambda$29$lambda$28(State state) {
        return Z17ImageEditor$lambda$95$lambda$0(state) == Z17EditorState.VIEW;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 Z17ImageEditor$lambda$95$lambda$86$lambda$32(List list, final MutableIntState mutableIntState, Bitmap it, Composer composer, int i10) {
        kotlin.jvm.internal.y.i(it, "it");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(132330614, i10, -1, "cu.z17.views.imageEditor.Z17ImageEditor.<anonymous>.<anonymous>.<anonymous> (Z17ImageEditor.kt:148)");
        }
        Modifier modifierSafeContentPadding = WindowInsetsPadding_androidKt.safeContentPadding(Modifier.INSTANCE);
        int intValue = mutableIntState.getIntValue();
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new Function1() { // from class: cu.z17.views.imageEditor.i0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return Z17ImageEditorKt.Z17ImageEditor$lambda$95$lambda$86$lambda$32$lambda$31$lambda$30(mutableIntState, ((Integer) obj).intValue());
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        TextTopBarKt.TextTopBar(modifierSafeContentPadding, list, intValue, (Function1) objRememberedValue, composer, 3072, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 Z17ImageEditor$lambda$95$lambda$86$lambda$32$lambda$31$lambda$30(MutableIntState mutableIntState, int i10) {
        mutableIntState.setIntValue(i10);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Z17ImageEditor$lambda$95$lambda$86$lambda$34$lambda$33(State state) {
        return Z17ImageEditor$lambda$95$lambda$0(state) == Z17EditorState.TEXT;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 Z17ImageEditor$lambda$95$lambda$86$lambda$37(final MutableFloatState mutableFloatState, Bitmap it, Composer composer, int i10) {
        kotlin.jvm.internal.y.i(it, "it");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1583267977, i10, -1, "cu.z17.views.imageEditor.Z17ImageEditor.<anonymous>.<anonymous>.<anonymous> (Z17ImageEditor.kt:163)");
        }
        Modifier modifierSafeContentPadding = WindowInsetsPadding_androidKt.safeContentPadding(Modifier.INSTANCE);
        float floatValue = mutableFloatState.getFloatValue();
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new Function1() { // from class: cu.z17.views.imageEditor.k0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return Z17ImageEditorKt.Z17ImageEditor$lambda$95$lambda$86$lambda$37$lambda$36$lambda$35(mutableFloatState, ((Float) obj).floatValue());
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        RotaterTopBarKt.RotaterTopBar(modifierSafeContentPadding, floatValue, (Function1) objRememberedValue, composer, RendererCapabilities.DECODER_SUPPORT_MASK, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 Z17ImageEditor$lambda$95$lambda$86$lambda$37$lambda$36$lambda$35(MutableFloatState mutableFloatState, float f10) {
        mutableFloatState.setFloatValue(f10);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Z17ImageEditor$lambda$95$lambda$86$lambda$39$lambda$38(State state) {
        return Z17ImageEditor$lambda$95$lambda$0(state) == Z17EditorState.ROTATE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 Z17ImageEditor$lambda$95$lambda$86$lambda$42(State state, final MutableIntState mutableIntState, Bitmap it, Composer composer, int i10) {
        kotlin.jvm.internal.y.i(it, "it");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(996100728, i10, -1, "cu.z17.views.imageEditor.Z17ImageEditor.<anonymous>.<anonymous>.<anonymous> (Z17ImageEditor.kt:177)");
        }
        Modifier modifierSafeContentPadding = WindowInsetsPadding_androidKt.safeContentPadding(Modifier.INSTANCE);
        List<Bitmap> listZ17ImageEditor$lambda$95$lambda$19 = Z17ImageEditor$lambda$95$lambda$19(state);
        int intValue = mutableIntState.getIntValue();
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new Function1() { // from class: cu.z17.views.imageEditor.o0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return Z17ImageEditorKt.Z17ImageEditor$lambda$95$lambda$86$lambda$42$lambda$41$lambda$40(mutableIntState, ((Integer) obj).intValue());
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        FilterTopBarKt.FilterTopBar(modifierSafeContentPadding, it, listZ17ImageEditor$lambda$95$lambda$19, intValue, (Function1) objRememberedValue, composer, ((i10 << 3) & 112) | 24576, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 Z17ImageEditor$lambda$95$lambda$86$lambda$42$lambda$41$lambda$40(MutableIntState mutableIntState, int i10) {
        mutableIntState.setIntValue(i10);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Z17ImageEditor$lambda$95$lambda$86$lambda$44$lambda$43(State state) {
        return Z17ImageEditor$lambda$95$lambda$0(state) == Z17EditorState.FILTER;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Z17ImageEditor$lambda$95$lambda$86$lambda$71$lambda$46$lambda$45(State state) {
        return Z17ImageEditor$lambda$95$lambda$0(state) == Z17EditorState.VIEW;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 Z17ImageEditor$lambda$95$lambda$86$lambda$71$lambda$49(FocusRequester focusRequester, List list, MutableIntState mutableIntState, final MutableState mutableState, Bitmap it, Composer composer, int i10) {
        kotlin.jvm.internal.y.i(it, "it");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-139639044, i10, -1, "cu.z17.views.imageEditor.Z17ImageEditor.<anonymous>.<anonymous>.<anonymous>.<anonymous> (Z17ImageEditor.kt:209)");
        }
        int intValue = mutableIntState.getIntValue();
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new Function1() { // from class: cu.z17.views.imageEditor.j0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return Z17ImageEditorKt.Z17ImageEditor$lambda$95$lambda$86$lambda$71$lambda$49$lambda$48$lambda$47(mutableState, (LayoutCoordinates) obj);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        TextKt.Text2(it, focusRequester, intValue, list, (Function1) objRememberedValue, composer, (i10 & 14) | 24624);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 Z17ImageEditor$lambda$95$lambda$86$lambda$71$lambda$49$lambda$48$lambda$47(MutableState mutableState, LayoutCoordinates it) {
        kotlin.jvm.internal.y.i(it, "it");
        mutableState.setValue(Build.VERSION.SDK_INT >= 26 ? LayoutCoordinatesKt.boundsInWindow(it, true) : LayoutCoordinatesKt.boundsInRoot(it));
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Z17ImageEditor$lambda$95$lambda$86$lambda$71$lambda$51$lambda$50(State state) {
        return Z17ImageEditor$lambda$95$lambda$0(state) == Z17EditorState.TEXT;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 Z17ImageEditor$lambda$95$lambda$86$lambda$71$lambda$56(final Z17ImageEditorViewModel z17ImageEditorViewModel, final String str, final Function1 function1, Bitmap it, Composer composer, int i10) {
        kotlin.jvm.internal.y.i(it, "it");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-368428995, i10, -1, "cu.z17.views.imageEditor.Z17ImageEditor.<anonymous>.<anonymous>.<anonymous>.<anonymous> (Z17ImageEditor.kt:230)");
        }
        ImageBitmap imageBitmapAsImageBitmap = AndroidImageBitmap_androidKt.asImageBitmap(it);
        boolean zChangedInstance = composer.changedInstance(z17ImageEditorViewModel) | composer.changed(str) | composer.changed(function1);
        Object objRememberedValue = composer.rememberedValue();
        if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new Function1() { // from class: cu.z17.views.imageEditor.f
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return Z17ImageEditorKt.Z17ImageEditor$lambda$95$lambda$86$lambda$71$lambda$56$lambda$53$lambda$52(z17ImageEditorViewModel, str, function1, (ImageBitmap) obj);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        Function1 function2 = (Function1) objRememberedValue;
        boolean zChangedInstance2 = composer.changedInstance(z17ImageEditorViewModel);
        Object objRememberedValue2 = composer.rememberedValue();
        if (zChangedInstance2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = new lb.a() { // from class: cu.z17.views.imageEditor.g
                @Override // lb.a
                public final Object invoke() {
                    return Z17ImageEditorKt.Z17ImageEditor$lambda$95$lambda$86$lambda$71$lambda$56$lambda$55$lambda$54(z17ImageEditorViewModel);
                }
            };
            composer.updateRememberedValue(objRememberedValue2);
        }
        CropperKt.Cropper(imageBitmapAsImageBitmap, function2, (lb.a) objRememberedValue2, composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 Z17ImageEditor$lambda$95$lambda$86$lambda$71$lambda$56$lambda$53$lambda$52(Z17ImageEditorViewModel z17ImageEditorViewModel, String str, Function1 function1, ImageBitmap it) {
        kotlin.jvm.internal.y.i(it, "it");
        z17ImageEditorViewModel.setBitmap(AndroidImageBitmap_androidKt.asAndroidBitmap(it), str);
        function1.invoke(Boolean.TRUE);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 Z17ImageEditor$lambda$95$lambda$86$lambda$71$lambda$56$lambda$55$lambda$54(Z17ImageEditorViewModel z17ImageEditorViewModel) {
        z17ImageEditorViewModel.requestState(Z17EditorState.VIEW);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Z17ImageEditor$lambda$95$lambda$86$lambda$71$lambda$58$lambda$57(State state) {
        return Z17ImageEditor$lambda$95$lambda$0(state) == Z17EditorState.CROP;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 Z17ImageEditor$lambda$95$lambda$86$lambda$71$lambda$63(final Z17ImageEditorViewModel z17ImageEditorViewModel, final String str, final Function1 function1, MutableFloatState mutableFloatState, Bitmap it, Composer composer, int i10) {
        kotlin.jvm.internal.y.i(it, "it");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-597218946, i10, -1, "cu.z17.views.imageEditor.Z17ImageEditor.<anonymous>.<anonymous>.<anonymous>.<anonymous> (Z17ImageEditor.kt:247)");
        }
        float floatValue = mutableFloatState.getFloatValue();
        boolean zChangedInstance = composer.changedInstance(z17ImageEditorViewModel) | composer.changed(str) | composer.changed(function1);
        Object objRememberedValue = composer.rememberedValue();
        if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new Function1() { // from class: cu.z17.views.imageEditor.m0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return Z17ImageEditorKt.Z17ImageEditor$lambda$95$lambda$86$lambda$71$lambda$63$lambda$60$lambda$59(z17ImageEditorViewModel, str, function1, (Bitmap) obj);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        Function1 function2 = (Function1) objRememberedValue;
        boolean zChangedInstance2 = composer.changedInstance(z17ImageEditorViewModel);
        Object objRememberedValue2 = composer.rememberedValue();
        if (zChangedInstance2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = new lb.a() { // from class: cu.z17.views.imageEditor.n0
                @Override // lb.a
                public final Object invoke() {
                    return Z17ImageEditorKt.Z17ImageEditor$lambda$95$lambda$86$lambda$71$lambda$63$lambda$62$lambda$61(z17ImageEditorViewModel);
                }
            };
            composer.updateRememberedValue(objRememberedValue2);
        }
        RotaterKt.Rotate(it, floatValue, function2, (lb.a) objRememberedValue2, composer, i10 & 14);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 Z17ImageEditor$lambda$95$lambda$86$lambda$71$lambda$63$lambda$60$lambda$59(Z17ImageEditorViewModel z17ImageEditorViewModel, String str, Function1 function1, Bitmap it) {
        kotlin.jvm.internal.y.i(it, "it");
        z17ImageEditorViewModel.setBitmap(it, str);
        function1.invoke(Boolean.TRUE);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 Z17ImageEditor$lambda$95$lambda$86$lambda$71$lambda$63$lambda$62$lambda$61(Z17ImageEditorViewModel z17ImageEditorViewModel) {
        z17ImageEditorViewModel.requestState(Z17EditorState.VIEW);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Z17ImageEditor$lambda$95$lambda$86$lambda$71$lambda$65$lambda$64(State state) {
        return Z17ImageEditor$lambda$95$lambda$0(state) == Z17EditorState.ROTATE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 Z17ImageEditor$lambda$95$lambda$86$lambda$71$lambda$68(final Z17ImageEditorViewModel z17ImageEditorViewModel, State state, MutableIntState mutableIntState, Bitmap it, Composer composer, int i10) {
        kotlin.jvm.internal.y.i(it, "it");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-826008897, i10, -1, "cu.z17.views.imageEditor.Z17ImageEditor.<anonymous>.<anonymous>.<anonymous>.<anonymous> (Z17ImageEditor.kt:265)");
        }
        List<Bitmap> listZ17ImageEditor$lambda$95$lambda$19 = Z17ImageEditor$lambda$95$lambda$19(state);
        int intValue = mutableIntState.getIntValue();
        boolean zChangedInstance = composer.changedInstance(z17ImageEditorViewModel);
        Object objRememberedValue = composer.rememberedValue();
        if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new Function1() { // from class: cu.z17.views.imageEditor.l0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return Z17ImageEditorKt.Z17ImageEditor$lambda$95$lambda$86$lambda$71$lambda$68$lambda$67$lambda$66(z17ImageEditorViewModel, (List) obj);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        FilterKt.Filter(it, listZ17ImageEditor$lambda$95$lambda$19, intValue, (Function1) objRememberedValue, composer, i10 & 14);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 Z17ImageEditor$lambda$95$lambda$86$lambda$71$lambda$68$lambda$67$lambda$66(Z17ImageEditorViewModel z17ImageEditorViewModel, List it) {
        kotlin.jvm.internal.y.i(it, "it");
        z17ImageEditorViewModel.getFilteredBitmaps().removeAll();
        z17ImageEditorViewModel.getFilteredBitmaps().addAll(it);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Z17ImageEditor$lambda$95$lambda$86$lambda$71$lambda$70$lambda$69(State state) {
        return Z17ImageEditor$lambda$95$lambda$0(state) == Z17EditorState.FILTER;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 Z17ImageEditor$lambda$95$lambda$86$lambda$76(final Z17ImageEditorViewModel z17ImageEditorViewModel, Bitmap it, Composer composer, int i10) {
        kotlin.jvm.internal.y.i(it, "it");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-719497863, i10, -1, "cu.z17.views.imageEditor.Z17ImageEditor.<anonymous>.<anonymous>.<anonymous> (Z17ImageEditor.kt:288)");
        }
        Modifier modifierSafeContentPadding = WindowInsetsPadding_androidKt.safeContentPadding(Modifier.INSTANCE);
        Object objRememberedValue = composer.rememberedValue();
        Composer.Companion companion = Composer.INSTANCE;
        if (objRememberedValue == companion.getEmpty()) {
            objRememberedValue = new lb.a() { // from class: cu.z17.views.imageEditor.d
                @Override // lb.a
                public final Object invoke() {
                    return ua.k0.f43947a;
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        lb.a aVar = (lb.a) objRememberedValue;
        boolean zChangedInstance = composer.changedInstance(z17ImageEditorViewModel);
        Object objRememberedValue2 = composer.rememberedValue();
        if (zChangedInstance || objRememberedValue2 == companion.getEmpty()) {
            objRememberedValue2 = new lb.a() { // from class: cu.z17.views.imageEditor.e
                @Override // lb.a
                public final Object invoke() {
                    return Z17ImageEditorKt.Z17ImageEditor$lambda$95$lambda$86$lambda$76$lambda$75$lambda$74(z17ImageEditorViewModel);
                }
            };
            composer.updateRememberedValue(objRememberedValue2);
        }
        TextBottomBarKt.TextBottomBar(modifierSafeContentPadding, aVar, (lb.a) objRememberedValue2, composer, 48, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 Z17ImageEditor$lambda$95$lambda$86$lambda$76$lambda$75$lambda$74(Z17ImageEditorViewModel z17ImageEditorViewModel) {
        z17ImageEditorViewModel.requestState(Z17EditorState.VIEW);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Z17ImageEditor$lambda$95$lambda$86$lambda$78$lambda$77(State state) {
        return Z17ImageEditor$lambda$95$lambda$0(state) == Z17EditorState.TEXT;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 Z17ImageEditor$lambda$95$lambda$86$lambda$83(final State state, final Z17ImageEditorViewModel z17ImageEditorViewModel, final String str, final Function1 function1, final MutableIntState mutableIntState, final Bitmap it, Composer composer, int i10) {
        kotlin.jvm.internal.y.i(it, "it");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1859870842, i10, -1, "cu.z17.views.imageEditor.Z17ImageEditor.<anonymous>.<anonymous>.<anonymous> (Z17ImageEditor.kt:304)");
        }
        Modifier modifierSafeContentPadding = WindowInsetsPadding_androidKt.safeContentPadding(Modifier.INSTANCE);
        boolean zChangedInstance = composer.changedInstance(it) | composer.changed(state) | composer.changedInstance(z17ImageEditorViewModel) | composer.changed(str) | composer.changed(function1);
        Object objRememberedValue = composer.rememberedValue();
        if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            lb.a aVar = new lb.a() { // from class: cu.z17.views.imageEditor.b
                @Override // lb.a
                public final Object invoke() {
                    return Z17ImageEditorKt.Z17ImageEditor$lambda$95$lambda$86$lambda$83$lambda$80$lambda$79(it, z17ImageEditorViewModel, str, function1, mutableIntState, state);
                }
            };
            composer.updateRememberedValue(aVar);
            objRememberedValue = aVar;
        }
        lb.a aVar2 = (lb.a) objRememberedValue;
        boolean zChangedInstance2 = composer.changedInstance(z17ImageEditorViewModel);
        Object objRememberedValue2 = composer.rememberedValue();
        if (zChangedInstance2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = new lb.a() { // from class: cu.z17.views.imageEditor.m
                @Override // lb.a
                public final Object invoke() {
                    return Z17ImageEditorKt.Z17ImageEditor$lambda$95$lambda$86$lambda$83$lambda$82$lambda$81(z17ImageEditorViewModel);
                }
            };
            composer.updateRememberedValue(objRememberedValue2);
        }
        FilterBottomBarKt.FilterBottomBar(modifierSafeContentPadding, aVar2, (lb.a) objRememberedValue2, composer, 0, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 Z17ImageEditor$lambda$95$lambda$86$lambda$83$lambda$80$lambda$79(Bitmap bitmap, Z17ImageEditorViewModel z17ImageEditorViewModel, String str, Function1 function1, MutableIntState mutableIntState, State state) {
        if (mutableIntState.getIntValue() != 0) {
            bitmap = Z17ImageEditor$lambda$95$lambda$19(state).get(mutableIntState.getIntValue() - 1);
        }
        z17ImageEditorViewModel.setBitmap(bitmap, str);
        function1.invoke(Boolean.TRUE);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 Z17ImageEditor$lambda$95$lambda$86$lambda$83$lambda$82$lambda$81(Z17ImageEditorViewModel z17ImageEditorViewModel) {
        z17ImageEditorViewModel.requestState(Z17EditorState.VIEW);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Z17ImageEditor$lambda$95$lambda$86$lambda$85$lambda$84(State state) {
        return Z17ImageEditor$lambda$95$lambda$0(state) == Z17EditorState.FILTER;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 Z17ImageEditor$lambda$95$lambda$88$lambda$87(Z17ImageEditorViewModel z17ImageEditorViewModel) {
        z17ImageEditorViewModel.requestState(Z17EditorState.VIEW);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult Z17ImageEditor$lambda$95$lambda$94$lambda$93(final Z17ImageEditorViewModel z17ImageEditorViewModel, DisposableEffectScope DisposableEffect) {
        kotlin.jvm.internal.y.i(DisposableEffect, "$this$DisposableEffect");
        return new DisposableEffectResult() { // from class: cu.z17.views.imageEditor.Z17ImageEditorKt$Z17ImageEditor$lambda$95$lambda$94$lambda$93$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                z17ImageEditorViewModel.getHistory().removeAll();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 Z17ImageEditor$lambda$96(Modifier modifier, Uri uri, String str, boolean z10, float f10, Function1 function1, lb.a aVar, Function1 function2, Z17ImageEditorViewModel z17ImageEditorViewModel, Context context, ImageEditorConfigurations imageEditorConfigurations, int i10, int i11, int i12, Composer composer, int i13) {
        Z17ImageEditor(modifier, uri, str, z10, f10, function1, aVar, function2, z17ImageEditorViewModel, context, imageEditorConfigurations, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), RecomposeScopeImplKt.updateChangedFlags(i11), i12);
        return ua.k0.f43947a;
    }
}
