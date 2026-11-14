package cu.todus.android.uiCompose.shared.userCommonList;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.paging.compose.LazyFoundationExtensionsKt;
import androidx.paging.compose.LazyPagingItems;
import androidx.profileinstaller.ProfileVerifier;
import cu.todus.android.data.db.pojo.FollowPartner;
import cu.todus.android.data.db.pojo.UserCommon;
import cu.todus.android.uiCompose.shared.pagerStateIndicator.PagerStateIndicatorKt;
import cu.todus.android.uiCompose.shared.userCommonList.UserCommonListKt;
import defpackage.l;
import defpackage.r;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.y;
import lb.a;
import lb.o;
import le.a0;
import le.d0;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u001aª\u0001\u0010\u0014\u001a\u00020\t\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00062\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\t0\b2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\t0\b2\u0013\b\u0002\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\t0\f¢\u0006\u0002\b\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0016\b\u0002\u0010\u0011\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\u0004\u0012\u00020\u000f0\b2\u0014\b\u0002\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00120\bH\u0007¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcu/todus/android/data/db/pojo/UserCommon;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/compose/ui/Modifier;", "modifier", "Landroidx/compose/foundation/lazy/LazyListState;", "lazyListState", "Landroidx/paging/compose/LazyPagingItems;", "userCommons", "Lkotlin/Function1;", "Lua/k0;", "onClick", "onLongClick", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "header", "", "ownerId", "tag", "", "extraNotForShowCondition", "UserCommonList", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/LazyListState;Landroidx/paging/compose/LazyPagingItems;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class UserCommonListKt {
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[_]]")
    public static final <T extends UserCommon> void UserCommonList(final Modifier modifier, final LazyListState lazyListState, final LazyPagingItems<T> userCommons, final Function1 onClick, final Function1 onLongClick, Function2 function2, final String ownerId, Function1 function1, Function1 function3, Composer composer, final int i10, final int i11) {
        int i12;
        Function2 function4;
        final Function1 function5;
        final Function1 function6;
        final Function1 function7;
        final Function2 function8;
        final Function1 function9;
        y.i(modifier, "modifier");
        y.i(lazyListState, "lazyListState");
        y.i(userCommons, "userCommons");
        y.i(onClick, "onClick");
        y.i(onLongClick, "onLongClick");
        y.i(ownerId, "ownerId");
        Composer composerStartRestartGroup = composer.startRestartGroup(1531453113);
        if ((i10 & 6) == 0) {
            i12 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i10;
        } else {
            i12 = i10;
        }
        if ((i10 & 48) == 0) {
            i12 |= composerStartRestartGroup.changed(lazyListState) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i12 |= (i10 & 512) == 0 ? composerStartRestartGroup.changed(userCommons) : composerStartRestartGroup.changedInstance(userCommons) ? 256 : 128;
        }
        if ((i10 & 3072) == 0) {
            i12 |= composerStartRestartGroup.changedInstance(onClick) ? 2048 : 1024;
        }
        if ((i10 & 24576) == 0) {
            i12 |= composerStartRestartGroup.changedInstance(onLongClick) ? 16384 : 8192;
        }
        int i13 = i11 & 32;
        if (i13 != 0) {
            i12 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            function4 = function2;
        } else {
            function4 = function2;
            if ((i10 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                i12 |= composerStartRestartGroup.changedInstance(function4) ? 131072 : 65536;
            }
        }
        if ((i10 & 1572864) == 0) {
            i12 |= composerStartRestartGroup.changed(ownerId) ? 1048576 : 524288;
        }
        int i14 = i11 & 128;
        if (i14 != 0) {
            i12 |= 12582912;
            function5 = function1;
        } else {
            function5 = function1;
            if ((i10 & 12582912) == 0) {
                i12 |= composerStartRestartGroup.changedInstance(function5) ? 8388608 : 4194304;
            }
        }
        int i15 = i11 & 256;
        if (i15 != 0) {
            i12 |= 100663296;
        } else if ((i10 & 100663296) == 0) {
            i12 |= composerStartRestartGroup.changedInstance(function3) ? 67108864 : 33554432;
        }
        if (composerStartRestartGroup.shouldExecute((i12 & 38347923) != 38347922, i12 & 1)) {
            final Function2 lambda$1322932884$app_productionPFast = i13 != 0 ? ComposableSingletons$UserCommonListKt.INSTANCE.getLambda$1322932884$app_productionPFast() : function4;
            if (i14 != 0) {
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: w8.u
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return UserCommonListKt.UserCommonList$lambda$0$0((UserCommon) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                function5 = (Function1) objRememberedValue;
            }
            if (i15 != 0) {
                Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new Function1() { // from class: w8.j
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return Boolean.valueOf(UserCommonListKt.UserCommonList$lambda$1$0((UserCommon) obj));
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                function9 = (Function1) objRememberedValue2;
            } else {
                function9 = function3;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1531453113, i12, -1, "cu.todus.android.uiCompose.shared.userCommonList.UserCommonList (UserCommonList.kt:27)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            int iA = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
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
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion2.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl, companion2.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion2.getSetModifier());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            Modifier modifierFillMaxHeight$default = SizeKt.fillMaxHeight$default(modifier, 0.0f, 1, null);
            boolean z10 = ((458752 & i12) == 131072) | ((i12 & 896) == 256 || ((i12 & 512) != 0 && composerStartRestartGroup.changedInstance(userCommons))) | ((i12 & 7168) == 2048) | ((57344 & i12) == 16384) | ((3670016 & i12) == 1048576) | ((234881024 & i12) == 67108864) | ((29360128 & i12) == 8388608);
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (z10 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function1() { // from class: w8.k
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return UserCommonListKt.UserCommonList$lambda$2$0$0(userCommons, lambda$1322932884$app_productionPFast, onClick, onLongClick, ownerId, function9, function5, (LazyListScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            LazyDslKt.LazyColumn(modifierFillMaxHeight$default, lazyListState, null, false, null, null, null, false, null, (Function1) objRememberedValue3, composerStartRestartGroup, i12 & 112, TypedValues.PositionType.TYPE_CURVE_FIT);
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            function8 = lambda$1322932884$app_productionPFast;
            function7 = function5;
            function6 = function9;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            function6 = function3;
            function7 = function5;
            function8 = function4;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: w8.l
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return UserCommonListKt.UserCommonList$lambda$3(modifier, lazyListState, userCommons, onClick, onLongClick, function8, ownerId, function7, function6, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String UserCommonList$lambda$0$0(UserCommon userCommon) {
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean UserCommonList$lambda$1$0(UserCommon it) {
        y.i(it, "it");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 UserCommonList$lambda$2$0$0(final LazyPagingItems lazyPagingItems, final Function2 function2, final Function1 function1, final Function1 function3, final String str, final Function1 function4, final Function1 function5, LazyListScope LazyColumn) {
        y.i(LazyColumn, "$this$LazyColumn");
        LazyListScope.CC.m(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(-2077155628, true, new Function3() { // from class: w8.i
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return UserCommonListKt.UserCommonList$lambda$2$0$0$0(function2, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }), 3, null);
        LazyColumn.items(lazyPagingItems.getItemCount(), LazyFoundationExtensionsKt.itemKey(lazyPagingItems, new Function1() { // from class: w8.m
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return UserCommonListKt.UserCommonList$lambda$2$0$0$1((UserCommon) obj);
            }
        }), LazyFoundationExtensionsKt.itemContentType(lazyPagingItems, new Function1() { // from class: w8.n
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return UserCommonListKt.UserCommonList$lambda$2$0$0$2((UserCommon) obj);
            }
        }), ComposableLambdaKt.composableLambdaInstance(-1000926627, true, new o() { // from class: w8.o
            @Override // lb.o
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return UserCommonListKt.UserCommonList$lambda$2$0$0$3(lazyPagingItems, function1, function3, str, function4, function5, (LazyItemScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
            }
        }));
        LazyListScope.CC.m(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(-543102261, true, new Function3() { // from class: w8.p
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return UserCommonListKt.UserCommonList$lambda$2$0$0$4(lazyPagingItems, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }), 3, null);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    public static final k0 UserCommonList$lambda$2$0$0$0(Function2 function2, LazyItemScope item, Composer composer, int i10) {
        y.i(item, "$this$item");
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2077155628, i10, -1, "cu.todus.android.uiCompose.shared.userCommonList.UserCommonList.<anonymous>.<anonymous>.<anonymous>.<anonymous> (UserCommonList.kt:35)");
            }
            function2.invoke(composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object UserCommonList$lambda$2$0$0$1(UserCommon f10) {
        y.i(f10, "f");
        String id2 = f10.getId();
        if (!d0.q0(id2)) {
            return id2;
        }
        String string = UUID.randomUUID().toString();
        y.h(string, "toString(...)");
        return a0.O(string, "-", "", false, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object UserCommonList$lambda$2$0$0$2(UserCommon i10) {
        y.i(i10, "i");
        return "item";
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 UserCommonList$lambda$2$0$0$3(LazyPagingItems lazyPagingItems, final Function1 function1, final Function1 function2, String str, Function1 function3, Function1 function4, LazyItemScope items, int i10, Composer composer, int i11) {
        Composer composer2;
        y.i(items, "$this$items");
        if ((i11 & 48) == 0) {
            i11 |= composer.changed(i10) ? 32 : 16;
        }
        if (composer.shouldExecute((i11 & 145) != 144, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1000926627, i11, -1, "cu.todus.android.uiCompose.shared.userCommonList.UserCommonList.<anonymous>.<anonymous>.<anonymous>.<anonymous> (UserCommonList.kt:45)");
            }
            final UserCommon userCommon = (UserCommon) lazyPagingItems.get(i10);
            if (userCommon != null) {
                composer.startReplaceGroup(1352916785);
                if ((userCommon instanceof FollowPartner) && ((FollowPartner) userCommon).getUnknown()) {
                    composer.startReplaceGroup(182191039);
                    boolean zChanged = composer.changed(function1) | composer.changedInstance(userCommon);
                    Object objRememberedValue = composer.rememberedValue();
                    if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new a() { // from class: w8.q
                            @Override // lb.a
                            public final Object invoke() {
                                return UserCommonListKt.UserCommonList$lambda$2$0$0$3$0$0(function1, userCommon);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue);
                    }
                    a aVar = (a) objRememberedValue;
                    boolean zChanged2 = composer.changed(function2) | composer.changedInstance(userCommon);
                    Object objRememberedValue2 = composer.rememberedValue();
                    if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = new a() { // from class: w8.r
                            @Override // lb.a
                            public final Object invoke() {
                                return UserCommonListKt.UserCommonList$lambda$2$0$0$3$1$0(function2, userCommon);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue2);
                    }
                    composer2 = composer;
                    ContactItemKt.UnknownContactItem(null, aVar, (a) objRememberedValue2, composer2, 0, 1);
                    composer2.endReplaceGroup();
                } else {
                    composer2 = composer;
                    if (userCommon.exists() && !y.d(userCommon.getId(), str) && ((Boolean) function3.invoke(userCommon)).booleanValue()) {
                        composer2.startReplaceGroup(1353400571);
                        String thumbnailPicture = userCommon.getThumbnailPicture();
                        String name = userCommon.getName();
                        String str2 = (String) function4.invoke(userCommon);
                        boolean zChanged3 = composer2.changed(function1) | composer2.changedInstance(userCommon);
                        Object objRememberedValue3 = composer2.rememberedValue();
                        if (zChanged3 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue3 = new a() { // from class: w8.s
                                @Override // lb.a
                                public final Object invoke() {
                                    return UserCommonListKt.UserCommonList$lambda$2$0$0$3$2$0$0(function1, userCommon);
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue3);
                        }
                        a aVar2 = (a) objRememberedValue3;
                        boolean zChanged4 = composer2.changed(function2) | composer2.changedInstance(userCommon);
                        Object objRememberedValue4 = composer2.rememberedValue();
                        if (zChanged4 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue4 = new a() { // from class: w8.t
                                @Override // lb.a
                                public final Object invoke() {
                                    return UserCommonListKt.UserCommonList$lambda$2$0$0$3$2$1$0(function2, userCommon);
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue4);
                        }
                        ContactItemKt.ContactItem(thumbnailPicture, name, str2, aVar2, (a) objRememberedValue4, composer2, 0, 0);
                        composer2.endReplaceGroup();
                    } else {
                        composer2.startReplaceGroup(1353963717);
                        composer2.endReplaceGroup();
                    }
                }
                composer2.endReplaceGroup();
            } else {
                composer.startReplaceGroup(182224369);
                ContactItemKt.ContactPlaceholder(composer, 0);
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
    public static final k0 UserCommonList$lambda$2$0$0$3$0$0(Function1 function1, UserCommon userCommon) {
        function1.invoke(userCommon);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 UserCommonList$lambda$2$0$0$3$1$0(Function1 function1, UserCommon userCommon) {
        function1.invoke(userCommon);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 UserCommonList$lambda$2$0$0$3$2$0$0(Function1 function1, UserCommon userCommon) {
        function1.invoke(userCommon);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 UserCommonList$lambda$2$0$0$3$2$1$0(Function1 function1, UserCommon userCommon) {
        function1.invoke(userCommon);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    public static final k0 UserCommonList$lambda$2$0$0$4(LazyPagingItems lazyPagingItems, LazyItemScope item, Composer composer, int i10) {
        y.i(item, "$this$item");
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-543102261, i10, -1, "cu.todus.android.uiCompose.shared.userCommonList.UserCommonList.<anonymous>.<anonymous>.<anonymous>.<anonymous> (UserCommonList.kt:78)");
            }
            PagerStateIndicatorKt.PagerStateIndicator(null, null, null, null, lazyPagingItems, composer, LazyPagingItems.$stable << 12, 15);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 UserCommonList$lambda$3(Modifier modifier, LazyListState lazyListState, LazyPagingItems lazyPagingItems, Function1 function1, Function1 function2, Function2 function3, String str, Function1 function4, Function1 function5, int i10, int i11, Composer composer, int i12) {
        UserCommonList(modifier, lazyListState, lazyPagingItems, function1, function2, function3, str, function4, function5, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return k0.f43947a;
    }
}
