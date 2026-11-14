package cu.todus.android.uiCompose.main.screen.chat.attachmentSelector;

import android.content.Context;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.FlowLayoutKt;
import androidx.compose.foundation.layout.FlowRowScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.LazyListStateKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.outlined.AttachFileKt;
import androidx.compose.material.icons.outlined.CalendarMonthKt;
import androidx.compose.material.icons.outlined.ContactsKt;
import androidx.compose.material.icons.outlined.MapKt;
import androidx.compose.material.icons.outlined.VideocamKt;
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
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import androidx.media3.exoplayer.RendererCapabilities;
import cu.todus.android.R;
import cu.todus.android.data.db.entity.cache.BotShortcut;
import cu.todus.android.data.db.pojo.content.ButtonContent;
import cu.todus.android.notification.SystemNotificationExecutor;
import cu.todus.android.uiCompose.shared.botShortcutBtn.BotShortcutKt;
import cu.todus.android.uiCompose.theme.Other;
import cu.z17.views.label.Z17LabelKt;
import cu.z17.views.permission.PermissionNeedIt;
import cu.z17.views.permission.PermissionsRequesterState;
import cu.z17.views.permission.PermissionsResult;
import cu.z17.views.permission.Z17PermissionRequesterKt;
import cu.z17.views.picture.Z17PictureKt;
import defpackage.r;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.y;
import lb.o;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;
import ua.k0;
import va.v;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u001a\u008d\u0001\u0010\u0010\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\b2\u0006\u0010\f\u001a\u00020\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0007¢\u0006\u0004\b\u0010\u0010\u0011\u001a5\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00162\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\u0007¢\u0006\u0004\b\u0019\u0010\u001a¨\u0006\u001c"}, d2 = {"Lkotlin/Function0;", "Lua/k0;", "onOpenAttachFile", "onOpenAttachEvent", "onOpenAttachLocation", "onOpenAttachContact", "onOpenPubEditor", "onOpenAttachVideo", "Lkotlin/Function1;", "Lcu/todus/android/data/db/pojo/content/ButtonContent;", "onClickInShortcut", "Lv5/f;", "gson", "", "Lcu/todus/android/data/db/entity/cache/BotShortcut;", "botShortcuts", "AttachmentSelector", "(Llb/a;Llb/a;Llb/a;Llb/a;Llb/a;Llb/a;Lkotlin/jvm/functions/Function1;Lv5/f;Ljava/util/List;Landroidx/compose/runtime/Composer;I)V", "", "icon", "Landroidx/compose/ui/graphics/Color;", "color", "", "text", SystemNotificationExecutor.ACTION, "AttachmentSelectorBtn-3IgeMak", "(Ljava/lang/Object;JLjava/lang/String;Llb/a;Landroidx/compose/runtime/Composer;I)V", "AttachmentSelectorBtn", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class AttachmentSelectorKt {
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void AttachmentSelector(final lb.a onOpenAttachFile, final lb.a onOpenAttachEvent, final lb.a onOpenAttachLocation, final lb.a onOpenAttachContact, final lb.a onOpenPubEditor, final lb.a onOpenAttachVideo, final Function1 onClickInShortcut, final v5.f gson, final List<BotShortcut> botShortcuts, Composer composer, final int i10) {
        int i11;
        Composer composer2;
        Composer composer3;
        boolean z10;
        y.i(onOpenAttachFile, "onOpenAttachFile");
        y.i(onOpenAttachEvent, "onOpenAttachEvent");
        y.i(onOpenAttachLocation, "onOpenAttachLocation");
        y.i(onOpenAttachContact, "onOpenAttachContact");
        y.i(onOpenPubEditor, "onOpenPubEditor");
        y.i(onOpenAttachVideo, "onOpenAttachVideo");
        y.i(onClickInShortcut, "onClickInShortcut");
        y.i(gson, "gson");
        y.i(botShortcuts, "botShortcuts");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1581027525);
        if ((i10 & 6) == 0) {
            i11 = (composerStartRestartGroup.changedInstance(onOpenAttachFile) ? 4 : 2) | i10;
        } else {
            i11 = i10;
        }
        if ((i10 & 48) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(onOpenAttachEvent) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(onOpenAttachLocation) ? 256 : 128;
        }
        if ((i10 & 3072) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(onOpenAttachContact) ? 2048 : 1024;
        }
        if ((i10 & 24576) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(onOpenPubEditor) ? 16384 : 8192;
        }
        if ((196608 & i10) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(onOpenAttachVideo) ? 131072 : 65536;
        }
        if ((1572864 & i10) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(onClickInShortcut) ? 1048576 : 524288;
        }
        if ((12582912 & i10) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(gson) ? 8388608 : 4194304;
        }
        if ((100663296 & i10) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(botShortcuts) ? 67108864 : 33554432;
        }
        if (composerStartRestartGroup.shouldExecute((38347923 & i11) != 38347922, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1581027525, i11, -1, "cu.todus.android.uiCompose.main.screen.chat.attachmentSelector.AttachmentSelector (AttachmentSelector.kt:57)");
            }
            final Context context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new PermissionsRequesterState(null, false, v.e(PermissionNeedIt.CONTACT), 1, null), null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final MutableState mutableState = (MutableState) objRememberedValue;
            Modifier.Companion companion2 = Modifier.INSTANCE;
            Modifier modifierM1725padding3ABfNKs = PaddingKt.m1725padding3ABfNKs(BackgroundKt.m1205backgroundbw27NRU$default(SizeKt.fillMaxWidth$default(companion2, 0.0f, 1, null), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground(), null, 2, null), Dp.m8823constructorimpl(10));
            Alignment.Companion companion3 = Alignment.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), companion3.getCenterHorizontally(), composerStartRestartGroup, 48);
            int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1725padding3ABfNKs);
            ComposeUiNode.Companion companion4 = ComposeUiNode.INSTANCE;
            lb.a constructor = companion4.getConstructor();
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
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyColumnMeasurePolicy, companion4.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion4.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion4.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl, companion4.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion4.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            if (botShortcuts.isEmpty()) {
                composer3 = composerStartRestartGroup;
                z10 = true;
                composer3.startReplaceGroup(-1467510063);
                composer3.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-1468415325);
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion3.getTopStart(), false);
                int iA2 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion2);
                lb.a constructor2 = companion4.getConstructor();
                if (!r.a(composerStartRestartGroup.getApplier())) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor2);
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM5176constructorimpl2 = Updater.m5176constructorimpl(composerStartRestartGroup);
                Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy, companion4.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap2, companion4.getSetResolvedCompositionLocals());
                Updater.m5180initimpl(composerM5176constructorimpl2, Integer.valueOf(iA2), companion4.getSetCompositeKeyHash());
                Updater.m5182reconcileimpl(composerM5176constructorimpl2, companion4.getApplyOnDeactivatedNodeAssertion());
                Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier2, companion4.getSetModifier());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                LazyListState lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                boolean zChangedInstance = composerStartRestartGroup.changedInstance(botShortcuts) | composerStartRestartGroup.changedInstance(gson) | ((3670016 & i11) == 1048576);
                Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance || objRememberedValue2 == companion.getEmpty()) {
                    objRememberedValue2 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.attachmentSelector.a
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return AttachmentSelectorKt.AttachmentSelector$lambda$1$0$0$0(botShortcuts, gson, onClickInShortcut, (LazyListScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                Function1 function1 = (Function1) objRememberedValue2;
                z10 = true;
                LazyDslKt.LazyRow(null, lazyListStateRememberLazyListState, null, false, null, null, null, false, null, function1, composerStartRestartGroup, 0, 509);
                composer3 = composerStartRestartGroup;
                composer3.endNode();
                composer3.endReplaceGroup();
            }
            composer2 = composer3;
            FlowLayoutKt.FlowRow(null, null, null, null, 3, 0, ComposableLambdaKt.rememberComposableLambda(384886806, z10, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.chat.attachmentSelector.c
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return AttachmentSelectorKt.AttachmentSelector$lambda$1$1(onOpenAttachFile, onOpenAttachEvent, onOpenAttachLocation, onOpenAttachContact, onOpenPubEditor, onOpenAttachVideo, mutableState, context, (FlowRowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer3, 54), composer2, 1597440, 47);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.attachmentSelector.d
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AttachmentSelectorKt.AttachmentSelector$lambda$2(onOpenAttachFile, onOpenAttachEvent, onOpenAttachLocation, onOpenAttachContact, onOpenPubEditor, onOpenAttachVideo, onClickInShortcut, gson, botShortcuts, i10, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 AttachmentSelector$lambda$1$0$0$0(final List list, final v5.f fVar, final Function1 function1, LazyListScope LazyRow) {
        y.i(LazyRow, "$this$LazyRow");
        final Function1 function2 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.attachmentSelector.g
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AttachmentSelectorKt.AttachmentSelector$lambda$1$0$0$0$0((BotShortcut) obj);
            }
        };
        final AttachmentSelectorKt$AttachmentSelector$lambda$1$0$0$0$$inlined$items$default$1 attachmentSelectorKt$AttachmentSelector$lambda$1$0$0$0$$inlined$items$default$1 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.attachmentSelector.AttachmentSelectorKt$AttachmentSelector$lambda$1$0$0$0$$inlined$items$default$1
            @Override // kotlin.jvm.functions.Function1
            public final Void invoke(BotShortcut botShortcut) {
                return null;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke((BotShortcut) obj);
            }
        };
        LazyRow.items(list.size(), new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.attachmentSelector.AttachmentSelectorKt$AttachmentSelector$lambda$1$0$0$0$$inlined$items$default$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke(((Number) obj).intValue());
            }

            public final Object invoke(int i10) {
                return function2.invoke(list.get(i10));
            }
        }, new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.attachmentSelector.AttachmentSelectorKt$AttachmentSelector$lambda$1$0$0$0$$inlined$items$default$3
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke(((Number) obj).intValue());
            }

            public final Object invoke(int i10) {
                return attachmentSelectorKt$AttachmentSelector$lambda$1$0$0$0$$inlined$items$default$1.invoke(list.get(i10));
            }
        }, ComposableLambdaKt.composableLambdaInstance(802480018, true, new o() { // from class: cu.todus.android.uiCompose.main.screen.chat.attachmentSelector.AttachmentSelectorKt$AttachmentSelector$lambda$1$0$0$0$$inlined$items$default$4
            @Override // lb.o
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                invoke((LazyItemScope) obj, ((Number) obj2).intValue(), (Composer) obj3, ((Number) obj4).intValue());
                return k0.f43947a;
            }

            @Composable
            public final void invoke(LazyItemScope lazyItemScope, int i10, Composer composer, int i11) {
                int i12;
                if ((i11 & 6) == 0) {
                    i12 = (composer.changed(lazyItemScope) ? 4 : 2) | i11;
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
                final BotShortcut botShortcut = (BotShortcut) list.get(i10);
                composer.startReplaceGroup(-1949751750);
                float f10 = 5;
                Modifier modifierM1729paddingqDBjuR0$default = PaddingKt.m1729paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, Dp.m8823constructorimpl(f10), Dp.m8823constructorimpl(f10), 3, null);
                boolean zChangedInstance = composer.changedInstance(fVar) | composer.changed(botShortcut) | composer.changed(function1);
                Object objRememberedValue = composer.rememberedValue();
                if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    final v5.f fVar2 = fVar;
                    final Function1 function3 = function1;
                    objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.attachmentSelector.AttachmentSelectorKt$AttachmentSelector$1$1$1$1$2$1$1
                        @Override // lb.a
                        public /* bridge */ /* synthetic */ Object invoke() {
                            m9856invoke();
                            return k0.f43947a;
                        }

                        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                        public final void m9856invoke() {
                            try {
                                ButtonContent buttonContent = (ButtonContent) fVar2.j(botShortcut.getBtnContent(), ButtonContent.class);
                                Function1 function4 = function3;
                                y.f(buttonContent);
                                function4.invoke(buttonContent);
                            } catch (Exception e10) {
                                e10.printStackTrace();
                            }
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                BotShortcutKt.BotShortcutBtn(modifierM1729paddingqDBjuR0$default, botShortcut, (lb.a) objRememberedValue, composer, 6, 0);
                composer.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object AttachmentSelector$lambda$1$0$0$0$0(BotShortcut it) {
        y.i(it, "it");
        return it.getId() + it.getRoomId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 AttachmentSelector$lambda$1$1(lb.a aVar, lb.a aVar2, lb.a aVar3, final lb.a aVar4, lb.a aVar5, lb.a aVar6, final MutableState mutableState, Context context, FlowRowScope FlowRow, Composer composer, int i10) {
        y.i(FlowRow, "$this$FlowRow");
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(384886806, i10, -1, "cu.todus.android.uiCompose.main.screen.chat.attachmentSelector.AttachmentSelector.<anonymous>.<anonymous> (AttachmentSelector.kt:104)");
            }
            Icons.Outlined outlined = Icons.Outlined.INSTANCE;
            ImageVector attachFile = AttachFileKt.getAttachFile(outlined);
            Other other = Other.INSTANCE;
            m9855AttachmentSelectorBtn3IgeMak(attachFile, other.m10109getBlue0d7_KjU(), StringResources_androidKt.stringResource(R.string.file, composer, 0), aVar, composer, 0);
            m9855AttachmentSelectorBtn3IgeMak(CalendarMonthKt.getCalendarMonth(outlined), other.m10114getOrange10d7_KjU(), StringResources_androidKt.stringResource(R.string.date, composer, 0), aVar2, composer, 0);
            m9855AttachmentSelectorBtn3IgeMak(MapKt.getMap(outlined), other.m10111getGreen0d7_KjU(), StringResources_androidKt.stringResource(R.string.location, composer, 0), aVar3, composer, 0);
            ImageVector contacts = ContactsKt.getContacts(outlined);
            long jM10115getOrange20d7_KjU = other.m10115getOrange20d7_KjU();
            String strStringResource = StringResources_androidKt.stringResource(R.string.contact, composer, 0);
            boolean zChanged = composer.changed(aVar4);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.attachmentSelector.h
                    @Override // lb.a
                    public final Object invoke() {
                        return AttachmentSelectorKt.AttachmentSelector$lambda$1$1$0$0(mutableState, aVar4);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            m9855AttachmentSelectorBtn3IgeMak(contacts, jM10115getOrange20d7_KjU, strStringResource, (lb.a) objRememberedValue, composer, 0);
            m9855AttachmentSelectorBtn3IgeMak(Integer.valueOf(R.drawable.f20191h1), other.m10117getPurple0d7_KjU(), StringResources_androidKt.stringResource(R.string.editor, composer, 0), aVar5, composer, 0);
            m9855AttachmentSelectorBtn3IgeMak(VideocamKt.getVideocam(outlined), other.m10118getRed0d7_KjU(), StringResources_androidKt.stringResource(R.string.video, composer, 0), aVar6, composer, 0);
            PermissionsRequesterState permissionsRequesterState = (PermissionsRequesterState) mutableState.getValue();
            Object objRememberedValue2 = composer.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.attachmentSelector.i
                    @Override // lb.a
                    public final Object invoke() {
                        return AttachmentSelectorKt.AttachmentSelector$lambda$1$1$1$0(mutableState);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            lb.a aVar7 = (lb.a) objRememberedValue2;
            Object objRememberedValue3 = composer.rememberedValue();
            if (objRememberedValue3 == companion.getEmpty()) {
                objRememberedValue3 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.attachmentSelector.j
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return AttachmentSelectorKt.AttachmentSelector$lambda$1$1$2$0(mutableState, (PermissionsResult) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue3);
            }
            Z17PermissionRequesterKt.Z17PermissionChecker(null, aVar7, permissionsRequesterState, (Function1) objRememberedValue3, ComposableSingletons$AttachmentSelectorKt.INSTANCE.getLambda$1735159222$app_productionPFast(), composer, 27696, 1);
            PermissionsRequesterState permissionsRequesterState2 = (PermissionsRequesterState) mutableState.getValue();
            String packageName = context.getPackageName();
            y.h(packageName, "getPackageName(...)");
            Object objRememberedValue4 = composer.rememberedValue();
            if (objRememberedValue4 == companion.getEmpty()) {
                objRememberedValue4 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.attachmentSelector.k
                    @Override // lb.a
                    public final Object invoke() {
                        return AttachmentSelectorKt.AttachmentSelector$lambda$1$1$3$0(mutableState);
                    }
                };
                composer.updateRememberedValue(objRememberedValue4);
            }
            lb.a aVar8 = (lb.a) objRememberedValue4;
            Object objRememberedValue5 = composer.rememberedValue();
            if (objRememberedValue5 == companion.getEmpty()) {
                objRememberedValue5 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.attachmentSelector.b
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return AttachmentSelectorKt.AttachmentSelector$lambda$1$1$4$0(mutableState, (PermissionsResult) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue5);
            }
            Z17PermissionRequesterKt.Z17PermissionRequester(permissionsRequesterState2, aVar8, (Function1) objRememberedValue5, packageName, composer, 432);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 AttachmentSelector$lambda$1$1$0$0(MutableState mutableState, lb.a aVar) {
        Integer state = ((PermissionsRequesterState) mutableState.getValue()).getPermissionsResult().getState();
        if (state != null && state.intValue() == 2) {
            aVar.invoke();
        } else {
            mutableState.setValue(PermissionsRequesterState.copy$default((PermissionsRequesterState) mutableState.getValue(), null, true, null, 5, null));
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 AttachmentSelector$lambda$1$1$1$0(MutableState mutableState) {
        mutableState.setValue(PermissionsRequesterState.copy$default((PermissionsRequesterState) mutableState.getValue(), null, true, null, 5, null));
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 AttachmentSelector$lambda$1$1$2$0(MutableState mutableState, PermissionsResult result) {
        y.i(result, "result");
        mutableState.setValue(PermissionsRequesterState.copy$default((PermissionsRequesterState) mutableState.getValue(), result, false, null, 6, null));
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 AttachmentSelector$lambda$1$1$3$0(MutableState mutableState) {
        mutableState.setValue(PermissionsRequesterState.copy$default((PermissionsRequesterState) mutableState.getValue(), null, false, null, 5, null));
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 AttachmentSelector$lambda$1$1$4$0(MutableState mutableState, PermissionsResult result) {
        y.i(result, "result");
        mutableState.setValue(PermissionsRequesterState.copy$default((PermissionsRequesterState) mutableState.getValue(), result, false, null, 6, null));
        Integer state = result.getState();
        if (state != null && state.intValue() == 2) {
            mutableState.setValue(PermissionsRequesterState.copy$default((PermissionsRequesterState) mutableState.getValue(), null, false, null, 5, null));
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 AttachmentSelector$lambda$2(lb.a aVar, lb.a aVar2, lb.a aVar3, lb.a aVar4, lb.a aVar5, lb.a aVar6, Function1 function1, v5.f fVar, List list, int i10, Composer composer, int i11) {
        AttachmentSelector(aVar, aVar2, aVar3, aVar4, aVar5, aVar6, function1, fVar, list, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1));
        return k0.f43947a;
    }

    @Composable
    /* JADX INFO: renamed from: AttachmentSelectorBtn-3IgeMak, reason: not valid java name */
    public static final void m9855AttachmentSelectorBtn3IgeMak(final Object icon, final long j10, final String text, final lb.a action, Composer composer, final int i10) {
        int i11;
        y.i(icon, "icon");
        y.i(text, "text");
        y.i(action, "action");
        Composer composerStartRestartGroup = composer.startRestartGroup(-789738827);
        if ((i10 & 6) == 0) {
            i11 = (composerStartRestartGroup.changedInstance(icon) ? 4 : 2) | i10;
        } else {
            i11 = i10;
        }
        if ((i10 & 48) == 0) {
            i11 |= composerStartRestartGroup.changed(j10) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i11 |= composerStartRestartGroup.changed(text) ? 256 : 128;
        }
        if ((i10 & 3072) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(action) ? 2048 : 1024;
        }
        if (composerStartRestartGroup.shouldExecute((i11 & 1171) != 1170, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-789738827, i11, -1, "cu.todus.android.uiCompose.main.screen.chat.attachmentSelector.AttachmentSelectorBtn (AttachmentSelector.kt:206)");
            }
            Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
            Modifier.Companion companion = Modifier.INSTANCE;
            boolean z10 = (i11 & 7168) == 2048;
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z10 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.attachmentSelector.e
                    @Override // lb.a
                    public final Object invoke() {
                        return AttachmentSelectorKt.AttachmentSelectorBtn_3IgeMak$lambda$0$0(action);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            float f10 = 10;
            Modifier modifierM1729paddingqDBjuR0$default = PaddingKt.m1729paddingqDBjuR0$default(ClickableKt.m1240clickableoSLSa3U$default(companion, false, null, null, null, (lb.a) objRememberedValue, 15, null), 0.0f, 0.0f, 0.0f, Dp.m8823constructorimpl(f10), 7, null);
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), centerHorizontally, composerStartRestartGroup, 48);
            int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1729paddingqDBjuR0$default);
            ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
            lb.a constructor = companion2.getConstructor();
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
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyColumnMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion2.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl, companion2.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion2.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            Z17PictureKt.m10278Z17BasePictureC8z9wKI(SizeKt.m1769size3ABfNKs(PaddingKt.m1725padding3ABfNKs(BackgroundKt.m1204backgroundbw27NRU(PaddingKt.m1727paddingVpY3zN4$default(companion, Dp.m8823constructorimpl(15), 0.0f, 2, null), j10, RoundedCornerShapeKt.getCircleShape()), Dp.m8823constructorimpl(f10)), Dp.m8823constructorimpl(30)), icon, null, ColorFilter.Companion.m5907tintxETnrds$default(ColorFilter.INSTANCE, Color.INSTANCE.m5903getWhite0d7_KjU(), 0, 2, null), null, null, 0, null, null, composerStartRestartGroup, ((i11 << 3) & 112) | 3072, XMPPTCPConnection.PacketWriter.QUEUE_SIZE);
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, text, MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getLabelSmall(), 0L, 0, 0, composerStartRestartGroup, (i11 >> 3) & 112, 57);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.attachmentSelector.f
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AttachmentSelectorKt.AttachmentSelectorBtn_3IgeMak$lambda$2(icon, j10, text, action, i10, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 AttachmentSelectorBtn_3IgeMak$lambda$0$0(lb.a aVar) {
        aVar.invoke();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 AttachmentSelectorBtn_3IgeMak$lambda$2(Object obj, long j10, String str, lb.a aVar, int i10, Composer composer, int i11) {
        m9855AttachmentSelectorBtn3IgeMak(obj, j10, str, aVar, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1));
        return k0.f43947a;
    }
}
