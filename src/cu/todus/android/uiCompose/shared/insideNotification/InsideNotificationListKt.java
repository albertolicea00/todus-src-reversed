package cu.todus.android.uiCompose.shared.insideNotification;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.LazyListStateKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import cu.todus.android.constants.Service;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.y;
import ua.k0;
import va.g0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a1\u0010\u0007\u001a\u00020\u00052\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"", "Lcu/todus/android/uiCompose/shared/insideNotification/InsideNotificationState;", Service.Endpoint.LINKED_DEVICES_LIST, "Lkotlin/Function1;", "", "Lua/k0;", "onClear", "InsideNotificationList", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class InsideNotificationListKt {
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void InsideNotificationList(final List<InsideNotificationState> list, final Function1 onClear, Composer composer, final int i10) {
        int i11;
        y.i(list, "list");
        y.i(onClear, "onClear");
        Composer composerStartRestartGroup = composer.startRestartGroup(1782207471);
        if ((i10 & 6) == 0) {
            i11 = (composerStartRestartGroup.changedInstance(list) ? 4 : 2) | i10;
        } else {
            i11 = i10;
        }
        if ((i10 & 48) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(onClear) ? 32 : 16;
        }
        if (composerStartRestartGroup.shouldExecute((i11 & 19) != 18, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1782207471, i11, -1, "cu.todus.android.uiCompose.shared.insideNotification.InsideNotificationList (InsideNotificationList.kt:16)");
            }
            LazyListState lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
            Modifier modifierSafeContentPadding = WindowInsetsPadding_androidKt.safeContentPadding(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null));
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(list) | ((i11 & 112) == 32);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: cu.todus.android.uiCompose.shared.insideNotification.g
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return InsideNotificationListKt.InsideNotificationList$lambda$0$0(list, onClear, (LazyListScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            LazyDslKt.LazyColumn(modifierSafeContentPadding, lazyListStateRememberLazyListState, null, false, null, null, null, false, null, (Function1) objRememberedValue, composerStartRestartGroup, 0, TypedValues.PositionType.TYPE_CURVE_FIT);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.shared.insideNotification.h
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return InsideNotificationListKt.InsideNotificationList$lambda$1(list, onClear, i10, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 InsideNotificationList$lambda$0$0(final List list, final Function1 function1, LazyListScope LazyColumn) {
        y.i(LazyColumn, "$this$LazyColumn");
        final Function1 function2 = new Function1() { // from class: cu.todus.android.uiCompose.shared.insideNotification.i
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return InsideNotificationListKt.InsideNotificationList$lambda$0$0$0((InsideNotificationState) obj);
            }
        };
        final InsideNotificationListKt$InsideNotificationList$lambda$0$0$$inlined$items$default$1 insideNotificationListKt$InsideNotificationList$lambda$0$0$$inlined$items$default$1 = new Function1() { // from class: cu.todus.android.uiCompose.shared.insideNotification.InsideNotificationListKt$InsideNotificationList$lambda$0$0$$inlined$items$default$1
            @Override // kotlin.jvm.functions.Function1
            public final Void invoke(InsideNotificationState insideNotificationState) {
                return null;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke((InsideNotificationState) obj);
            }
        };
        LazyColumn.items(list.size(), new Function1() { // from class: cu.todus.android.uiCompose.shared.insideNotification.InsideNotificationListKt$InsideNotificationList$lambda$0$0$$inlined$items$default$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke(((Number) obj).intValue());
            }

            public final Object invoke(int i10) {
                return function2.invoke(list.get(i10));
            }
        }, new Function1() { // from class: cu.todus.android.uiCompose.shared.insideNotification.InsideNotificationListKt$InsideNotificationList$lambda$0$0$$inlined$items$default$3
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke(((Number) obj).intValue());
            }

            public final Object invoke(int i10) {
                return insideNotificationListKt$InsideNotificationList$lambda$0$0$$inlined$items$default$1.invoke(list.get(i10));
            }
        }, ComposableLambdaKt.composableLambdaInstance(802480018, true, new lb.o() { // from class: cu.todus.android.uiCompose.shared.insideNotification.InsideNotificationListKt$InsideNotificationList$lambda$0$0$$inlined$items$default$4
            @Override // lb.o
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                invoke((LazyItemScope) obj, ((Number) obj2).intValue(), (Composer) obj3, ((Number) obj4).intValue());
                return k0.f43947a;
            }

            @Composable
            public final void invoke(LazyItemScope lazyItemScope, int i10, Composer composer, int i11) {
                int i12;
                if ((i11 & 6) == 0) {
                    i12 = i11 | (composer.changed(lazyItemScope) ? 4 : 2);
                } else {
                    i12 = i11;
                }
                if ((i11 & 48) == 0) {
                    i12 |= composer.changed(i10) ? 32 : 16;
                }
                if (!composer.shouldExecute((i12 & 147) != 146, i12 & 1)) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(802480018, i12, -1, "androidx.compose.foundation.lazy.items.<anonymous> (LazyDsl.kt:178)");
                }
                final InsideNotificationState insideNotificationState = (InsideNotificationState) list.get(i10);
                composer.startReplaceGroup(-576387405);
                Modifier modifierC = androidx.compose.foundation.lazy.g.c(lazyItemScope, Modifier.INSTANCE, null, null, null, 2, null);
                Cause cause = insideNotificationState.getCause();
                String msg = insideNotificationState.getMsg();
                boolean zD = y.d(((InsideNotificationState) g0.w0(list)).getId(), insideNotificationState.getId());
                boolean zChanged = composer.changed(function1) | composer.changed(insideNotificationState);
                Object objRememberedValue = composer.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    final Function1 function3 = function1;
                    objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.shared.insideNotification.InsideNotificationListKt$InsideNotificationList$1$1$2$1$1
                        @Override // lb.a
                        public /* bridge */ /* synthetic */ Object invoke() {
                            m10086invoke();
                            return k0.f43947a;
                        }

                        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                        public final void m10086invoke() {
                            function3.invoke(insideNotificationState.getId());
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                InsideNotificationKt.InsideNotification(modifierC, zD, cause, msg, (lb.a) objRememberedValue, composer, 0);
                composer.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object InsideNotificationList$lambda$0$0$0(InsideNotificationState n10) {
        y.i(n10, "n");
        return n10.getId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 InsideNotificationList$lambda$1(List list, Function1 function1, int i10, Composer composer, int i11) {
        InsideNotificationList(list, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1));
        return k0.f43947a;
    }
}
