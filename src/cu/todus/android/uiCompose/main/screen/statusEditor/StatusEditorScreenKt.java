package cu.todus.android.uiCompose.main.screen.statusEditor;

import android.content.Context;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.TopAppBarScrollBehavior;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.navigation.NavController;
import androidx.navigation.NavHostController;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigator;
import androidx.p000activity.compose.BackHandlerKt;
import androidx.paging.compose.LazyPagingItems;
import androidx.paging.compose.LazyPagingItemsKt;
import cu.todus.android.data.db.entity.toDus.Status;
import cu.todus.android.data.db.pojo.content.Content;
import cu.todus.android.data.db.pojo.content.statusContent.StatusImageContent;
import cu.todus.android.data.db.pojo.content.statusContent.StatusTextContent;
import cu.todus.android.data.db.pojo.content.statusContent.StatusVideoContent;
import cu.todus.android.data.util.MediaUtil;
import cu.todus.android.uiCompose.main.screen.statusEditor.pages.finalPreview.FinalPreviewKt;
import cu.todus.android.uiCompose.main.screen.statusEditor.pages.mediaEditor.MediaEditorKt;
import cu.todus.android.uiCompose.main.screen.statusEditor.pages.ownerStatus.OwnerStatusKt;
import cu.todus.android.uiCompose.main.screen.statusEditor.pages.textEditor.TextEditorKt;
import cu.todus.android.uiCompose.main.screen.statusPreview.StatusPreviewParams;
import cu.todus.android.uiCompose.navigation.NavLinks;
import cu.todus.android.uiCompose.shared.camera.CameraParams;
import cu.z17.views.topBar.Z17TopBarKt;
import cu.z17.views.utils.Z17InlineUtilsKt;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.y;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a)\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\r²\u0006\u000e\u0010\n\u001a\u00020\t8\n@\nX\u008a\u008e\u0002²\u0006\u0010\u0010\f\u001a\u0004\u0018\u00010\u000b8\n@\nX\u008a\u008e\u0002"}, d2 = {"Landroidx/navigation/NavHostController;", "navHostController", "", "params", "Lcu/todus/android/uiCompose/main/screen/statusEditor/StatusEditorViewModel;", "viewModel", "Lua/k0;", "StatusEditorScreen", "(Landroidx/navigation/NavHostController;Ljava/lang/String;Lcu/todus/android/uiCompose/main/screen/statusEditor/StatusEditorViewModel;Landroidx/compose/runtime/Composer;II)V", "", "optionSelected", "Lcu/todus/android/data/db/pojo/content/Content;", "statusContent", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class StatusEditorScreenKt {
    /* JADX WARN: Failed to calculate best type for var: r5v15 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r5v15 ??, new type: int
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r5v15 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r5v15 ??, new type: int
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
    /* JADX WARN: Failed to calculate best type for var: r5v19 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r5v19 ??, new type: int
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
    /* JADX WARN: Failed to calculate best type for var: r5v22 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r5v22 ??, new type: int
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
    /* JADX WARN: Failed to calculate best type for var: r9v10 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r9v10 ??, new type: int
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
    /* JADX WARN: Failed to calculate best type for var: r9v11 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r9v11 ??, new type: int
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
    /* JADX WARN: Failed to calculate best type for var: r9v15 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r9v15 ??, new type: int
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
    /* JADX WARN: Failed to calculate best type for var: r9v17 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r9v17 ??, new type: int
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
    /*  JADX ERROR: Types fix failed
        jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r5v15 ??, new type: char
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
    public static final void StatusEditorScreen(androidx.navigation.NavHostController r23, java.lang.String r24, cu.todus.android.uiCompose.main.screen.statusEditor.StatusEditorViewModel r25, androidx.compose.runtime.Composer r26, int r27, int r28) {
        /*
            Method dump skipped, instruction units count: 448
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.uiCompose.main.screen.statusEditor.StatusEditorScreenKt.StatusEditorScreen(androidx.navigation.NavHostController, java.lang.String, cu.todus.android.uiCompose.main.screen.statusEditor.StatusEditorViewModel, androidx.compose.runtime.Composer, int, int):void");
    }

    private static final Content StatusEditorScreen$lambda$5(MutableState<Content> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 StatusEditorScreen$lambda$7(final NavHostController navHostController, TopAppBarScrollBehavior it, Composer composer, int i10) {
        y.i(it, "it");
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1222646919, i10, -1, "cu.todus.android.uiCompose.main.screen.statusEditor.StatusEditorScreen.<anonymous> (StatusEditorScreen.kt:76)");
            }
            Function2 lambda$1250735052$app_productionPFast = ComposableSingletons$StatusEditorScreenKt.INSTANCE.getLambda$1250735052$app_productionPFast();
            boolean zChangedInstance = composer.changedInstance(navHostController);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.statusEditor.m
                    @Override // lb.a
                    public final Object invoke() {
                        return StatusEditorScreenKt.StatusEditorScreen$lambda$7$0$0(navHostController);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            Z17TopBarKt.m10304Z17TopBardW2gCk(lambda$1250735052$app_productionPFast, null, false, null, false, navHostController, (lb.a) objRememberedValue, null, 0L, 0L, 0.0f, composer, 6, 0, 1950);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 StatusEditorScreen$lambda$7$0$0(NavHostController navHostController) {
        navHostController.navigateUp();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 StatusEditorScreen$lambda$8(final StatusEditorViewModel statusEditorViewModel, final NavHostController navHostController, final StatusEditorParams statusEditorParams, final Context context, final MutableIntState mutableIntState, final MutableState mutableState, Modifier it, Composer composer, int i10) {
        int i11;
        CameraParams cameraParams;
        Composer composer2 = composer;
        y.i(it, "it");
        if ((i10 & 6) == 0) {
            i11 = i10 | (composer2.changed(it) ? 4 : 2);
        } else {
            i11 = i10;
        }
        if (composer2.shouldExecute((i11 & 19) != 18, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1900980791, i11, -1, "cu.todus.android.uiCompose.main.screen.statusEditor.StatusEditorScreen.<anonymous> (StatusEditorScreen.kt:90)");
            }
            LazyPagingItems lazyPagingItemsCollectAsLazyPagingItems = LazyPagingItemsKt.collectAsLazyPagingItems(statusEditorViewModel.getOwnerStatus(), null, composer2, 0, 1);
            Modifier modifierM1205backgroundbw27NRU$default = BackgroundKt.m1205backgroundbw27NRU$default(SizeKt.fillMaxSize$default(WindowInsetsPadding_androidKt.imePadding(it), 0.0f, 1, null), MaterialTheme.INSTANCE.getColorScheme(composer2, MaterialTheme.$stable).getBackground(), null, 2, null);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getCenter(), false);
            int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
            CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer2, modifierM1205backgroundbw27NRU$default);
            ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
            lb.a constructor = companion.getConstructor();
            if (!defpackage.r.a(composer2.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                composer2.createNode(constructor);
            } else {
                composer2.useNode();
            }
            Composer composerM5176constructorimpl = Updater.m5176constructorimpl(composer2);
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, companion.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl, companion.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion.getSetModifier());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            int intValue = mutableIntState.getIntValue();
            if (intValue == 0) {
                composer2.startReplaceGroup(895197601);
                boolean zChangedInstance = composer2.changedInstance(navHostController) | composer2.changedInstance(statusEditorViewModel);
                Object objRememberedValue = composer2.rememberedValue();
                if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function2() { // from class: cu.todus.android.uiCompose.main.screen.statusEditor.p
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return StatusEditorScreenKt.StatusEditorScreen$lambda$8$0$0$0(navHostController, statusEditorViewModel, ((Integer) obj).intValue(), (String) obj2);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue);
                }
                Function2 function2 = (Function2) objRememberedValue;
                boolean zChangedInstance2 = composer2.changedInstance(statusEditorViewModel);
                Object objRememberedValue2 = composer2.rememberedValue();
                if (zChangedInstance2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.statusEditor.q
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return StatusEditorScreenKt.StatusEditorScreen$lambda$8$0$1$0(statusEditorViewModel, (String) obj);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue2);
                }
                Function1 function1 = (Function1) objRememberedValue2;
                Object objRememberedValue3 = composer2.rememberedValue();
                Composer.Companion companion2 = Composer.INSTANCE;
                if (objRememberedValue3 == companion2.getEmpty()) {
                    objRememberedValue3 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.statusEditor.r
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return StatusEditorScreenKt.StatusEditorScreen$lambda$8$0$2$0(mutableIntState, ((Integer) obj).intValue());
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue3);
                }
                Function1 function3 = (Function1) objRememberedValue3;
                boolean zChangedInstance3 = composer2.changedInstance(statusEditorViewModel);
                Object objRememberedValue4 = composer2.rememberedValue();
                if (zChangedInstance3 || objRememberedValue4 == companion2.getEmpty()) {
                    objRememberedValue4 = new StatusEditorScreenKt$StatusEditorScreen$2$1$4$1(statusEditorViewModel);
                    composer2.updateRememberedValue(objRememberedValue4);
                }
                OwnerStatusKt.OwnerStatus(function2, function1, lazyPagingItemsCollectAsLazyPagingItems, function3, (lb.a) ((sb.h) objRememberedValue4), statusEditorViewModel.owner().getNameWithDomain(), composer2, (LazyPagingItems.$stable << 6) | 3072);
                composer2 = composer2;
                composer2.endReplaceGroup();
                k0 k0Var = k0.f43947a;
            } else if (intValue == 1) {
                composer2.startReplaceGroup(896347081);
                String text = statusEditorParams.getText();
                if (text == null) {
                    text = "";
                }
                List<Color> colors = statusEditorViewModel.getColors();
                List<Color> invertedColors = statusEditorViewModel.getInvertedColors();
                boolean zChangedInstance4 = composer2.changedInstance(statusEditorViewModel);
                Object objRememberedValue5 = composer2.rememberedValue();
                if (zChangedInstance4 || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue5 = new lb.o() { // from class: cu.todus.android.uiCompose.main.screen.statusEditor.c
                        @Override // lb.o
                        public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            return StatusEditorScreenKt.StatusEditorScreen$lambda$8$0$4$0(statusEditorViewModel, mutableState, mutableIntState, (String) obj, ((Integer) obj2).intValue(), ((Integer) obj3).intValue(), ((Integer) obj4).intValue());
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue5);
                }
                lb.o oVar = (lb.o) objRememberedValue5;
                Object objRememberedValue6 = composer2.rememberedValue();
                if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue6 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.statusEditor.d
                        @Override // lb.a
                        public final Object invoke() {
                            return StatusEditorScreenKt.StatusEditorScreen$lambda$8$0$5$0(mutableIntState);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue6);
                }
                TextEditorKt.TextEditor(text, colors, invertedColors, oVar, (lb.a) objRememberedValue6, composer2, 24576);
                composer2 = composer2;
                composer2.endReplaceGroup();
                k0 k0Var2 = k0.f43947a;
            } else if (intValue == 2) {
                composer2.startReplaceGroup(897520152);
                if (statusEditorParams.getType() != null) {
                    Integer numValueOf = Integer.valueOf(y.d(statusEditorParams.getType(), Status.IMG_TYPE) ? 1 : 2);
                    String path = statusEditorParams.getPath();
                    long durationFromFile = 0;
                    if (y.d(statusEditorParams.getType(), Status.VIDEO_TYPE)) {
                        try {
                            durationFromFile = MediaUtil.INSTANCE.getDurationFromFile(context, new File(statusEditorParams.getPath()));
                        } catch (Exception unused) {
                        }
                    }
                    cameraParams = new CameraParams(numValueOf, path, durationFromFile);
                } else {
                    cameraParams = null;
                }
                boolean zChangedInstance5 = composer2.changedInstance(statusEditorViewModel);
                Object objRememberedValue7 = composer2.rememberedValue();
                if (zChangedInstance5 || objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue7 = new Function2() { // from class: cu.todus.android.uiCompose.main.screen.statusEditor.e
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return StatusEditorScreenKt.StatusEditorScreen$lambda$8$0$6$0(statusEditorViewModel, mutableState, mutableIntState, (File) obj, (String) obj2);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue7);
                }
                Function2 function4 = (Function2) objRememberedValue7;
                boolean zChangedInstance6 = composer2.changedInstance(statusEditorViewModel) | composer2.changedInstance(context);
                Object objRememberedValue8 = composer2.rememberedValue();
                if (zChangedInstance6 || objRememberedValue8 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue8 = new Function2() { // from class: cu.todus.android.uiCompose.main.screen.statusEditor.f
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return StatusEditorScreenKt.StatusEditorScreen$lambda$8$0$7$0(statusEditorViewModel, context, mutableState, mutableIntState, (File) obj, (String) obj2);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue8);
                }
                Function2 function5 = (Function2) objRememberedValue8;
                Object objRememberedValue9 = composer2.rememberedValue();
                if (objRememberedValue9 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue9 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.statusEditor.g
                        @Override // lb.a
                        public final Object invoke() {
                            return StatusEditorScreenKt.StatusEditorScreen$lambda$8$0$8$0(mutableIntState);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue9);
                }
                MediaEditorKt.MediaEditor(cameraParams, function4, function5, (lb.a) objRememberedValue9, composer2, 3072);
                composer2.endReplaceGroup();
                k0 k0Var3 = k0.f43947a;
            } else if (intValue != 3) {
                composer2.startReplaceGroup(900566801);
                composer2.endReplaceGroup();
                k0 k0Var4 = k0.f43947a;
            } else {
                composer2.startReplaceGroup(-940809986);
                Content contentStatusEditorScreen$lambda$5 = StatusEditorScreen$lambda$5(mutableState);
                if (contentStatusEditorScreen$lambda$5 == null) {
                    composer2.startReplaceGroup(899661507);
                    composer2.endReplaceGroup();
                } else {
                    composer2.startReplaceGroup(899661508);
                    boolean zChangedInstance7 = composer2.changedInstance(context);
                    Object objRememberedValue10 = composer2.rememberedValue();
                    if (zChangedInstance7 || objRememberedValue10 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue10 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.statusEditor.h
                            @Override // lb.a
                            public final Object invoke() {
                                return StatusEditorScreenKt.StatusEditorScreen$lambda$8$0$9$0$0(statusEditorParams, context, mutableIntState);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue10);
                    }
                    FinalPreviewKt.FinalPreview(statusEditorViewModel, contentStatusEditorScreen$lambda$5, (lb.a) objRememberedValue10, composer2, StatusEditorViewModel.$stable);
                    k0 k0Var5 = k0.f43947a;
                    composer2.endReplaceGroup();
                }
                composer2.endReplaceGroup();
                k0 k0Var6 = k0.f43947a;
            }
            composer2.endNode();
            boolean zChangedInstance8 = composer2.changedInstance(navHostController);
            Object objRememberedValue11 = composer2.rememberedValue();
            if (zChangedInstance8 || objRememberedValue11 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue11 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.statusEditor.o
                    @Override // lb.a
                    public final Object invoke() {
                        return StatusEditorScreenKt.StatusEditorScreen$lambda$8$1$0(navHostController, mutableIntState);
                    }
                };
                composer2.updateRememberedValue(objRememberedValue11);
            }
            BackHandlerKt.BackHandler(false, (lb.a) objRememberedValue11, composer2, 0, 1);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 StatusEditorScreen$lambda$8$0$0$0(NavHostController navHostController, StatusEditorViewModel statusEditorViewModel, int i10, String id2) {
        y.i(id2, "id");
        NavLinks navLinks = NavLinks.INSTANCE;
        String strT = statusEditorViewModel.getGson().t(new StatusPreviewParams(true, i10, id2));
        y.h(strT, "toJson(...)");
        NavController.navigate$default((NavController) navHostController, navLinks.goStatusPreview(strT), (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 StatusEditorScreen$lambda$8$0$1$0(StatusEditorViewModel statusEditorViewModel, String id2) {
        y.i(id2, "id");
        statusEditorViewModel.deleteStatus(id2);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 StatusEditorScreen$lambda$8$0$2$0(MutableIntState mutableIntState, int i10) {
        mutableIntState.setIntValue(i10);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 StatusEditorScreen$lambda$8$0$4$0(StatusEditorViewModel statusEditorViewModel, final MutableState mutableState, final MutableIntState mutableIntState, String textContent, int i10, int i11, int i12) {
        y.i(textContent, "textContent");
        statusEditorViewModel.createTextStatus(textContent, i10, i11, i12, new Function1() { // from class: cu.todus.android.uiCompose.main.screen.statusEditor.b
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return StatusEditorScreenKt.StatusEditorScreen$lambda$8$0$4$0$0(mutableState, mutableIntState, (StatusTextContent) obj);
            }
        });
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 StatusEditorScreen$lambda$8$0$4$0$0(MutableState mutableState, MutableIntState mutableIntState, StatusTextContent it) {
        y.i(it, "it");
        mutableState.setValue(it);
        mutableIntState.setIntValue(3);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 StatusEditorScreen$lambda$8$0$5$0(MutableIntState mutableIntState) {
        mutableIntState.setIntValue(0);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 StatusEditorScreen$lambda$8$0$6$0(StatusEditorViewModel statusEditorViewModel, final MutableState mutableState, final MutableIntState mutableIntState, File imageFile, String textContent) {
        y.i(imageFile, "imageFile");
        y.i(textContent, "textContent");
        statusEditorViewModel.createImageStatus(textContent, imageFile, new Function1() { // from class: cu.todus.android.uiCompose.main.screen.statusEditor.i
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return StatusEditorScreenKt.StatusEditorScreen$lambda$8$0$6$0$0(mutableState, mutableIntState, (StatusImageContent) obj);
            }
        });
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 StatusEditorScreen$lambda$8$0$6$0$0(MutableState mutableState, MutableIntState mutableIntState, StatusImageContent it) {
        y.i(it, "it");
        mutableState.setValue(it);
        mutableIntState.setIntValue(3);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 StatusEditorScreen$lambda$8$0$7$0(StatusEditorViewModel statusEditorViewModel, Context context, final MutableState mutableState, final MutableIntState mutableIntState, File videoFile, String textContent) {
        y.i(videoFile, "videoFile");
        y.i(textContent, "textContent");
        statusEditorViewModel.createVideoStatus(context, textContent, videoFile, new Function1() { // from class: cu.todus.android.uiCompose.main.screen.statusEditor.n
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return StatusEditorScreenKt.StatusEditorScreen$lambda$8$0$7$0$0(mutableState, mutableIntState, (StatusVideoContent) obj);
            }
        });
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 StatusEditorScreen$lambda$8$0$7$0$0(MutableState mutableState, MutableIntState mutableIntState, StatusVideoContent it) {
        y.i(it, "it");
        mutableState.setValue(it);
        mutableIntState.setIntValue(3);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 StatusEditorScreen$lambda$8$0$8$0(MutableIntState mutableIntState) {
        mutableIntState.setIntValue(0);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 StatusEditorScreen$lambda$8$0$9$0$0(StatusEditorParams statusEditorParams, Context context, MutableIntState mutableIntState) {
        mutableIntState.setIntValue(0);
        if (statusEditorParams.getType() != null) {
            Z17InlineUtilsKt.findActivity(context).finish();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 StatusEditorScreen$lambda$8$1$0(NavHostController navHostController, MutableIntState mutableIntState) {
        if (mutableIntState.getIntValue() != 0) {
            mutableIntState.setIntValue(0);
        } else {
            navHostController.navigateUp();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 StatusEditorScreen$lambda$9(NavHostController navHostController, String str, StatusEditorViewModel statusEditorViewModel, int i10, int i11, Composer composer, int i12) {
        StatusEditorScreen(navHostController, str, statusEditorViewModel, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return k0.f43947a;
    }
}
