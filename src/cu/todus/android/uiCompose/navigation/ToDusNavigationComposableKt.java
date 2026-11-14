package cu.todus.android.uiCompose.navigation;

import androidx.compose.animation.AnimatedContentScope;
import androidx.compose.animation.AnimatedContentTransitionScope;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.navigation.NamedNavArgument;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavDeepLink;
import androidx.navigation.NavGraphBuilder;
import androidx.navigation.compose.NavGraphBuilderKt;
import cu.todus.android.uiCompose.navigation.ToDusNavigationComposableKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.y;
import lb.o;
import ua.k0;
import va.w;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aÚ\u0001\u0010\u0016\u001a\u00020\u0013*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\u001e\b\u0002\u0010\f\u001a\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\b2\u001e\b\u0002\u0010\u000e\u001a\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\b2\u001e\b\u0002\u0010\u000f\u001a\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\b2\u001e\b\u0002\u0010\u0010\u001a\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\b2\u001d\u0010\u0015\u001a\u0019\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00130\u0011¢\u0006\u0002\b\u0014H\u0007¢\u0006\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Landroidx/navigation/NavGraphBuilder;", "", "route", "", "Landroidx/navigation/NamedNavArgument;", "arguments", "Landroidx/navigation/NavDeepLink;", "deepLinks", "Lkotlin/Function1;", "Landroidx/compose/animation/AnimatedContentTransitionScope;", "Landroidx/navigation/NavBackStackEntry;", "Landroidx/compose/animation/EnterTransition;", "enterTransition", "Landroidx/compose/animation/ExitTransition;", "exitTransition", "popEnterTransition", "popExitTransition", "Lkotlin/Function2;", "Landroidx/compose/animation/AnimatedContentScope;", "Lua/k0;", "Landroidx/compose/runtime/Composable;", "content", "toDusNavigationComposable", "(Landroidx/navigation/NavGraphBuilder;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Llb/o;)V", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class ToDusNavigationComposableKt {
    @ComposableInferredTarget(scheme = "[0[0]]")
    public static final void toDusNavigationComposable(NavGraphBuilder navGraphBuilder, String route, List<NamedNavArgument> arguments, List<NavDeepLink> deepLinks, Function1 function1, Function1 function2, Function1 function3, Function1 function4, final o content) {
        y.i(navGraphBuilder, "<this>");
        y.i(route, "route");
        y.i(arguments, "arguments");
        y.i(deepLinks, "deepLinks");
        y.i(content, "content");
        NavGraphBuilderKt.composable$default(navGraphBuilder, route, arguments, deepLinks, function1, function2, function3, function4, (Function1) null, ComposableLambdaKt.composableLambdaInstance(-388960134, true, new o() { // from class: k8.d4
            @Override // lb.o
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return ToDusNavigationComposableKt.toDusNavigationComposable$lambda$4(content, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 128, (Object) null);
    }

    public static /* synthetic */ void toDusNavigationComposable$default(NavGraphBuilder navGraphBuilder, String str, List list, List list2, Function1 function1, Function1 function2, Function1 function3, Function1 function4, o oVar, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            list = w.n();
        }
        List list3 = list;
        if ((i10 & 4) != 0) {
            list2 = w.n();
        }
        List list4 = list2;
        if ((i10 & 8) != 0) {
            function1 = new Function1() { // from class: k8.f4
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return ToDusNavigationComposableKt.toDusNavigationComposable$lambda$0((AnimatedContentTransitionScope) obj2);
                }
            };
        }
        Function1 function5 = function1;
        if ((i10 & 16) != 0) {
            function2 = new Function1() { // from class: k8.g4
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return ToDusNavigationComposableKt.toDusNavigationComposable$lambda$1((AnimatedContentTransitionScope) obj2);
                }
            };
        }
        toDusNavigationComposable(navGraphBuilder, str, list3, list4, function5, function2, (i10 & 32) != 0 ? new Function1() { // from class: k8.h4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj2) {
                return ToDusNavigationComposableKt.toDusNavigationComposable$lambda$2((AnimatedContentTransitionScope) obj2);
            }
        } : function3, (i10 & 64) != 0 ? new Function1() { // from class: k8.i4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj2) {
                return ToDusNavigationComposableKt.toDusNavigationComposable$lambda$3((AnimatedContentTransitionScope) obj2);
            }
        } : function4, oVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EnterTransition toDusNavigationComposable$lambda$0(AnimatedContentTransitionScope animatedContentTransitionScope) {
        y.i(animatedContentTransitionScope, "<this>");
        return EnterExitTransitionKt.slideInHorizontally(AnimationSpecKt.tween$default(300, 0, null, 6, null), new Function1() { // from class: k8.e4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Integer.valueOf(ToDusNavigationComposableKt.toDusNavigationComposable$lambda$0$0(((Integer) obj).intValue()));
            }
        }).plus(EnterExitTransitionKt.fadeIn$default(AnimationSpecKt.tween$default(300, 0, null, 6, null), 0.0f, 2, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int toDusNavigationComposable$lambda$0$0(int i10) {
        return 300;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ExitTransition toDusNavigationComposable$lambda$1(AnimatedContentTransitionScope animatedContentTransitionScope) {
        y.i(animatedContentTransitionScope, "<this>");
        return EnterExitTransitionKt.slideOutHorizontally(AnimationSpecKt.tween$default(300, 0, null, 6, null), new Function1() { // from class: k8.j4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Integer.valueOf(ToDusNavigationComposableKt.toDusNavigationComposable$lambda$1$0(((Integer) obj).intValue()));
            }
        }).plus(EnterExitTransitionKt.fadeOut$default(AnimationSpecKt.tween$default(300, 0, null, 6, null), 0.0f, 2, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int toDusNavigationComposable$lambda$1$0(int i10) {
        return -300;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EnterTransition toDusNavigationComposable$lambda$2(AnimatedContentTransitionScope animatedContentTransitionScope) {
        y.i(animatedContentTransitionScope, "<this>");
        return EnterExitTransitionKt.slideInHorizontally(AnimationSpecKt.tween$default(300, 0, null, 6, null), new Function1() { // from class: k8.k4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Integer.valueOf(ToDusNavigationComposableKt.toDusNavigationComposable$lambda$2$0(((Integer) obj).intValue()));
            }
        }).plus(EnterExitTransitionKt.fadeIn$default(AnimationSpecKt.tween$default(300, 0, null, 6, null), 0.0f, 2, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int toDusNavigationComposable$lambda$2$0(int i10) {
        return -300;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ExitTransition toDusNavigationComposable$lambda$3(AnimatedContentTransitionScope animatedContentTransitionScope) {
        y.i(animatedContentTransitionScope, "<this>");
        return EnterExitTransitionKt.slideOutHorizontally(AnimationSpecKt.tween$default(300, 0, null, 6, null), new Function1() { // from class: k8.c4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Integer.valueOf(ToDusNavigationComposableKt.toDusNavigationComposable$lambda$3$0(((Integer) obj).intValue()));
            }
        }).plus(EnterExitTransitionKt.fadeOut$default(AnimationSpecKt.tween$default(300, 0, null, 6, null), 0.0f, 2, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int toDusNavigationComposable$lambda$3$0(int i10) {
        return 300;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    public static final k0 toDusNavigationComposable$lambda$4(o oVar, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i10) {
        y.i(composable, "$this$composable");
        y.i(it, "it");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-388960134, i10, -1, "cu.todus.android.uiCompose.navigation.toDusNavigationComposable.<anonymous> (ToDusNavigationComposable.kt:61)");
        }
        oVar.invoke(composable, it, composer, Integer.valueOf(i10 & 126));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return k0.f43947a;
    }
}
