package cu.todus.android.uiCompose.main.screen.chat.list;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.material.MenuKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.outlined.EmojiEmotionsKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import cu.todus.android.R;
import cu.todus.android.uiCompose.main.screen.chat.placeholder.ChatPlaceholderKt;
import cu.z17.views.picture.Z17PictureKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.y;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
public final class ComposableSingletons$MsgListKt {
    public static final ComposableSingletons$MsgListKt INSTANCE = new ComposableSingletons$MsgListKt();
    private static Function3 lambda$2139340831 = ComposableLambdaKt.composableLambdaInstance(2139340831, false, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.chat.list.a
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$MsgListKt.lambda_2139340831$lambda$0((Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });
    private static Function2 lambda$1578902171 = ComposableLambdaKt.composableLambdaInstance(1578902171, false, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.list.b
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$MsgListKt.lambda_1578902171$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-385672366, reason: not valid java name */
    private static Function2 f195lambda$385672366 = ComposableLambdaKt.composableLambdaInstance(-385672366, false, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.list.c
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$MsgListKt.lambda__385672366$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-76109163, reason: not valid java name */
    private static Function3 f196lambda$76109163 = ComposableLambdaKt.composableLambdaInstance(-76109163, false, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.chat.list.d
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$MsgListKt.lambda__76109163$lambda$0((LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 lambda_1578902171$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1578902171, i10, -1, "cu.todus.android.uiCompose.main.screen.chat.list.ComposableSingletons$MsgListKt.lambda$1578902171.<anonymous> (MsgList.kt:262)");
            }
            Z17PictureKt.m10278Z17BasePictureC8z9wKI(SizeKt.m1769size3ABfNKs(PaddingKt.m1727paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m8823constructorimpl(5), 0.0f, 2, null), Dp.m8823constructorimpl(24)), Integer.valueOf(R.drawable.business), null, null, null, null, 0, null, null, composer, 6, TypedValues.PositionType.TYPE_CURVE_FIT);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 lambda_2139340831$lambda$0(Modifier it, Composer composer, int i10) {
        y.i(it, "it");
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2139340831, i10, -1, "cu.todus.android.uiCompose.main.screen.chat.list.ComposableSingletons$MsgListKt.lambda$2139340831.<anonymous> (MsgList.kt:219)");
            }
            ChatPlaceholderKt.ChatPlaceholder(SizeKt.m1755height3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(1000)), composer, 6, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 lambda__385672366$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-385672366, i10, -1, "cu.todus.android.uiCompose.main.screen.chat.list.ComposableSingletons$MsgListKt.lambda$-385672366.<anonymous> (MsgList.kt:275)");
            }
            Z17PictureKt.m10278Z17BasePictureC8z9wKI(SizeKt.m1769size3ABfNKs(PaddingKt.m1727paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m8823constructorimpl(5), 0.0f, 2, null), Dp.m8823constructorimpl(24)), EmojiEmotionsKt.getEmojiEmotions(Icons.Outlined.INSTANCE), null, null, null, null, 0, null, null, composer, 6, TypedValues.PositionType.TYPE_CURVE_FIT);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 lambda__76109163$lambda$0(LazyItemScope item, Composer composer, int i10) {
        y.i(item, "$this$item");
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-76109163, i10, -1, "cu.todus.android.uiCompose.main.screen.chat.list.ComposableSingletons$MsgListKt.lambda$-76109163.<anonymous> (MsgList.kt:296)");
            }
            SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(MenuKt.InTransitionDuration)), composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: renamed from: getLambda$-385672366$app_productionPFast, reason: not valid java name */
    public final Function2 m9895getLambda$385672366$app_productionPFast() {
        return f195lambda$385672366;
    }

    /* JADX INFO: renamed from: getLambda$-76109163$app_productionPFast, reason: not valid java name */
    public final Function3 m9896getLambda$76109163$app_productionPFast() {
        return f196lambda$76109163;
    }

    public final Function2 getLambda$1578902171$app_productionPFast() {
        return lambda$1578902171;
    }

    public final Function3 getLambda$2139340831$app_productionPFast() {
        return lambda$2139340831;
    }
}
