package cu.z17.views.floatingMutilple;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.MutableTransitionState;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.outlined.AddKt;
import androidx.compose.material.icons.outlined.CloseKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.runtime.Composable;
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
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.motion.widget.Key;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.profileinstaller.ProfileVerifier;
import cu.z17.views.floatingMutilple.Z17MultipleFabState;
import cu.z17.views.floatingMutilple.Z17MultipleFabViewKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.y;
import lb.a;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\u001aE\u0010\r\u001a\u00020\n2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u0012²\u0006\u000e\u0010\u000f\u001a\u00020\u000e8\n@\nX\u008a\u008e\u0002²\u0006\f\u0010\u0011\u001a\u00020\u00108\nX\u008a\u0084\u0002"}, d2 = {"", "Lcu/z17/views/floatingMutilple/Z17MultipleFabObj;", "items", "Landroidx/compose/ui/Modifier;", "modifier", "", "baseIcon", "Landroidx/compose/ui/graphics/Color;", "buttonColor", "iconColor", "Lua/k0;", "Z17MultipleView-jA1GFJw", "(Ljava/util/List;Landroidx/compose/ui/Modifier;Ljava/lang/Object;JJLandroidx/compose/runtime/Composer;II)V", "Z17MultipleView", "Lcu/z17/views/floatingMutilple/Z17MultipleFabState;", "filterFabState", "", "iconRotationDegree", "views_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class Z17MultipleFabViewKt {
    /* JADX WARN: Code duplicated, block: B:100:0x017a  */
    /* JADX WARN: Code duplicated, block: B:101:0x017d  */
    /* JADX WARN: Code duplicated, block: B:104:0x0184  */
    /* JADX WARN: Code duplicated, block: B:107:0x019d  */
    /* JADX WARN: Code duplicated, block: B:111:0x01a9  */
    /* JADX WARN: Code duplicated, block: B:114:0x01b1  */
    /* JADX WARN: Code duplicated, block: B:117:0x0217  */
    /* JADX WARN: Code duplicated, block: B:120:0x0223  */
    /* JADX WARN: Code duplicated, block: B:121:0x0227  */
    /* JADX WARN: Code duplicated, block: B:126:0x0254  */
    /* JADX WARN: Code duplicated, block: B:129:0x0271  */
    /* JADX WARN: Code duplicated, block: B:130:0x0273  */
    /* JADX WARN: Code duplicated, block: B:133:0x027e  */
    /* JADX WARN: Code duplicated, block: B:136:0x02b3  */
    /* JADX WARN: Code duplicated, block: B:139:0x02c6  */
    /* JADX WARN: Code duplicated, block: B:140:0x02c9  */
    /* JADX WARN: Code duplicated, block: B:143:0x02f7  */
    /* JADX WARN: Code duplicated, block: B:146:0x02ff  */
    /* JADX WARN: Code duplicated, block: B:149:0x030c  */
    /* JADX WARN: Code duplicated, block: B:151:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:23:0x0042  */
    /* JADX WARN: Code duplicated, block: B:25:0x0046  */
    /* JADX WARN: Code duplicated, block: B:27:0x004e  */
    /* JADX WARN: Code duplicated, block: B:28:0x0051  */
    /* JADX WARN: Code duplicated, block: B:31:0x0057  */
    /* JADX WARN: Code duplicated, block: B:34:0x005d  */
    /* JADX WARN: Code duplicated, block: B:36:0x0061  */
    /* JADX WARN: Code duplicated, block: B:38:0x0069  */
    /* JADX WARN: Code duplicated, block: B:39:0x006c  */
    /* JADX WARN: Code duplicated, block: B:42:0x0072  */
    /* JADX WARN: Code duplicated, block: B:45:0x0078  */
    /* JADX WARN: Code duplicated, block: B:47:0x007c  */
    /* JADX WARN: Code duplicated, block: B:49:0x0084  */
    /* JADX WARN: Code duplicated, block: B:50:0x0087  */
    /* JADX WARN: Code duplicated, block: B:53:0x008d  */
    /* JADX WARN: Code duplicated, block: B:56:0x0096  */
    /* JADX WARN: Code duplicated, block: B:57:0x0098  */
    /* JADX WARN: Code duplicated, block: B:60:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:75:0x00cb A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:76:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:79:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:82:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:85:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:88:0x010a  */
    /* JADX WARN: Code duplicated, block: B:91:0x011c  */
    /* JADX WARN: Code duplicated, block: B:94:0x0131  */
    /* JADX WARN: Code duplicated, block: B:97:0x016d  */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Composable
    /* JADX INFO: renamed from: Z17MultipleView-jA1GFJw, reason: not valid java name */
    public static final void m10142Z17MultipleViewjA1GFJw(final List<Z17MultipleFabObj> items, Modifier modifier, Object obj, long j10, long j11, Composer composer, final int i10, final int i11) {
        int i12;
        Modifier modifier2;
        Object add;
        long primary;
        long background;
        boolean z10;
        final Modifier modifier3;
        final Object obj2;
        final long j12;
        Composer composer2;
        final long j13;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Object objRememberedValue;
        Composer.Companion companion;
        final MutableState mutableState;
        Object objRememberedValue2;
        Object obj3;
        Object currentState;
        Z17MultipleFabState z17MultipleFabState;
        float f10;
        int currentCompositeKeyHash;
        a constructor;
        Composer composerM5176constructorimpl;
        Function2 setCompositeKeyHash;
        boolean z11;
        Object objRememberedValue3;
        Object objRememberedValue4;
        Object close;
        y.i(items, "items");
        Composer composerStartRestartGroup = composer.startRestartGroup(-70879292);
        if ((i10 & 6) == 0) {
            i12 = (composerStartRestartGroup.changedInstance(items) ? 4 : 2) | i10;
        } else {
            i12 = i10;
        }
        int i13 = i11 & 2;
        if (i13 == 0) {
            if ((i10 & 48) == 0) {
                modifier2 = modifier;
                i12 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                if ((i11 & 4) == 0) {
                    add = obj;
                    int i14 = composerStartRestartGroup.changedInstance(add) ? 256 : 128;
                    i12 |= i14;
                } else {
                    add = obj;
                }
                i12 |= i14;
            } else {
                add = obj;
            }
            if ((i10 & 3072) == 0) {
                if ((i11 & 8) == 0) {
                    primary = j10;
                    int i15 = composerStartRestartGroup.changed(primary) ? 2048 : 1024;
                    i12 |= i15;
                } else {
                    primary = j10;
                }
                i12 |= i15;
            } else {
                primary = j10;
            }
            if ((i10 & 24576) == 0) {
                if ((i11 & 16) == 0) {
                    background = j11;
                    int i16 = composerStartRestartGroup.changed(background) ? 16384 : 8192;
                    i12 |= i16;
                } else {
                    background = j11;
                }
                i12 |= i16;
            } else {
                background = j11;
            }
            if ((i12 & 9363) != 9362) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z10, i12 & 1)) {
                composerStartRestartGroup.startDefaults();
                if ((i10 & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    if (i13 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if ((i11 & 4) != 0) {
                        i12 &= -897;
                        add = AddKt.getAdd(Icons.Outlined.INSTANCE);
                    }
                    if ((i11 & 8) != 0) {
                        primary = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimary();
                        i12 &= -7169;
                    }
                    if ((i11 & 16) != 0) {
                        background = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground();
                        i12 &= -57345;
                    }
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    if ((i11 & 4) != 0) {
                        i12 &= -897;
                    }
                    if ((i11 & 8) != 0) {
                        i12 &= -7169;
                    }
                    if ((i11 & 16) != 0) {
                        i12 &= -57345;
                    }
                }
                long j14 = primary;
                long j15 = background;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-70879292, i12, -1, "cu.z17.views.floatingMutilple.Z17MultipleView (Z17MultipleFabView.kt:31)");
                }
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                companion = Composer.INSTANCE;
                if (objRememberedValue == companion.getEmpty()) {
                    objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Z17MultipleFabState.COLLAPSED, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                mutableState = (MutableState) objRememberedValue;
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                obj3 = objRememberedValue2;
                if (objRememberedValue2 == companion.getEmpty()) {
                    MutableTransitionState mutableTransitionState = new MutableTransitionState(Z17MultipleView_jA1GFJw$lambda$1(mutableState));
                    mutableTransitionState.setTargetState$animation_core(Z17MultipleFabState.COLLAPSED);
                    composerStartRestartGroup.updateRememberedValue(mutableTransitionState);
                    obj3 = mutableTransitionState;
                }
                Transition transitionUpdateTransition = TransitionKt.updateTransition((MutableTransitionState) obj3, "transition", composerStartRestartGroup, MutableTransitionState.$stable | 48, 0);
                Function3 function3 = new Function3() { // from class: d9.m
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj4, Object obj5, Object obj6) {
                        return Z17MultipleFabViewKt.Z17MultipleView_jA1GFJw$lambda$5((Transition.Segment) obj4, (Composer) obj5, ((Integer) obj6).intValue());
                    }
                };
                TwoWayConverter<Float, AnimationVector1D> vectorConverter = VectorConvertersKt.getVectorConverter(r.f36628a);
                MutableTransitionState mutableTransitionState2 = (MutableTransitionState) transitionUpdateTransition.getCurrentState();
                composerStartRestartGroup.startReplaceGroup(200967883);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(200967883, 0, -1, "cu.z17.views.floatingMutilple.Z17MultipleView.<anonymous> (Z17MultipleFabView.kt:48)");
                }
                currentState = mutableTransitionState2.getCurrentState();
                z17MultipleFabState = Z17MultipleFabState.EXPANDED;
                if (currentState == z17MultipleFabState) {
                    f10 = 230.0f;
                } else {
                    f10 = 0.0f;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composerStartRestartGroup.endReplaceGroup();
                Float fValueOf = Float.valueOf(f10);
                MutableTransitionState mutableTransitionState3 = (MutableTransitionState) transitionUpdateTransition.getTargetState();
                composerStartRestartGroup.startReplaceGroup(200967883);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(200967883, 0, -1, "cu.z17.views.floatingMutilple.Z17MultipleView.<anonymous> (Z17MultipleFabView.kt:48)");
                }
                float f11 = mutableTransitionState3.getCurrentState() != z17MultipleFabState ? 0.0f : 230.0f;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composerStartRestartGroup.endReplaceGroup();
                State stateCreateTransitionAnimation = TransitionKt.createTransitionAnimation(transitionUpdateTransition, fValueOf, Float.valueOf(f11), (FiniteAnimationSpec) function3.invoke(transitionUpdateTransition.getSegment(), composerStartRestartGroup, 0), vectorConverter, Key.ROTATION, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE);
                Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(modifier2, 0.0f, 1, null);
                Alignment.Companion companion2 = Alignment.INSTANCE;
                MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.m1615spacedByD5KLDUw(Dp.m8823constructorimpl(16), companion2.getBottom()), companion2.getEnd(), composerStartRestartGroup, 54);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxSize$default);
                ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
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
                composerM5176constructorimpl = Updater.m5176constructorimpl(composerStartRestartGroup);
                Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyColumnMeasurePolicy, companion3.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
                setCompositeKeyHash = companion3.getSetCompositeKeyHash();
                if (composerM5176constructorimpl.getInserting() || !y.d(composerM5176constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion3.getSetModifier());
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                if (Z17MultipleView_jA1GFJw$lambda$1(mutableState) == z17MultipleFabState) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue3 == companion.getEmpty()) {
                    objRememberedValue3 = new a() { // from class: d9.n
                        @Override // lb.a
                        public final Object invoke() {
                            return Z17MultipleFabViewKt.Z17MultipleView_jA1GFJw$lambda$12$lambda$9$lambda$8(mutableState);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                int i17 = i12 << 6;
                Z17MultipleFabMenuKt.Z17MultipleFabMenu(null, z11, items, (a) objRememberedValue3, composerStartRestartGroup, (i17 & 896) | 3072, 1);
                Z17MultipleFabState z17MultipleFabStateZ17MultipleView_jA1GFJw$lambda$1 = Z17MultipleView_jA1GFJw$lambda$1(mutableState);
                float fZ17MultipleView_jA1GFJw$lambda$7 = Z17MultipleView_jA1GFJw$lambda$7(stateCreateTransitionAnimation);
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue4 == companion.getEmpty()) {
                    objRememberedValue4 = new Function1() { // from class: d9.o
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj4) {
                            return Z17MultipleFabViewKt.Z17MultipleView_jA1GFJw$lambda$12$lambda$11$lambda$10(mutableState, (Z17MultipleFabState) obj4);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                Function1 function1 = (Function1) objRememberedValue4;
                if (Z17MultipleView_jA1GFJw$lambda$1(mutableState) == Z17MultipleFabState.COLLAPSED) {
                    close = add;
                } else {
                    close = CloseKt.getClose(Icons.Outlined.INSTANCE);
                }
                Z17MultipleFabKt.m10138Z17MultipleFabnBX6wN0(null, z17MultipleFabStateZ17MultipleView_jA1GFJw$lambda$1, fZ17MultipleView_jA1GFJw$lambda$7, function1, j15, j14, close, composerStartRestartGroup, (57344 & i12) | 3072 | (458752 & i17), 1);
                primary = j14;
                Composer composer3 = composerStartRestartGroup;
                composer3.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
                obj2 = add;
                j12 = j15;
                composer2 = composer3;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                obj2 = add;
                j12 = background;
                composer2 = composerStartRestartGroup;
            }
            j13 = primary;
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: d9.p
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj4, Object obj5) {
                        return Z17MultipleFabViewKt.Z17MultipleView_jA1GFJw$lambda$13(items, modifier3, obj2, j13, j12, i10, i11, (Composer) obj4, ((Integer) obj5).intValue());
                    }
                });
            }
        }
        i12 |= 48;
        modifier2 = modifier;
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            if ((i11 & 4) == 0) {
                add = obj;
                if (composerStartRestartGroup.changedInstance(add)) {
                }
                i12 |= i14;
            } else {
                add = obj;
            }
            i12 |= i14;
        } else {
            add = obj;
        }
        if ((i10 & 3072) == 0) {
            if ((i11 & 8) == 0) {
                primary = j10;
                if (composerStartRestartGroup.changed(primary)) {
                }
                i12 |= i15;
            } else {
                primary = j10;
            }
            i12 |= i15;
        } else {
            primary = j10;
        }
        if ((i10 & 24576) == 0) {
            if ((i11 & 16) == 0) {
                background = j11;
                if (composerStartRestartGroup.changed(background)) {
                }
                i12 |= i16;
            } else {
                background = j11;
            }
            i12 |= i16;
        } else {
            background = j11;
        }
        if ((i12 & 9363) != 9362) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z10, i12 & 1)) {
            composerStartRestartGroup.startDefaults();
            if ((i10 & 1) != 0) {
                if (i13 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if ((i11 & 4) != 0) {
                    i12 &= -897;
                    add = AddKt.getAdd(Icons.Outlined.INSTANCE);
                }
                if ((i11 & 8) != 0) {
                    primary = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimary();
                    i12 &= -7169;
                }
                if ((i11 & 16) != 0) {
                    background = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground();
                    i12 &= -57345;
                }
            } else {
                if (i13 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if ((i11 & 4) != 0) {
                    i12 &= -897;
                    add = AddKt.getAdd(Icons.Outlined.INSTANCE);
                }
                if ((i11 & 8) != 0) {
                    primary = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimary();
                    i12 &= -7169;
                }
                if ((i11 & 16) != 0) {
                    background = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground();
                    i12 &= -57345;
                }
            }
            long j16 = primary;
            long j17 = background;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-70879292, i12, -1, "cu.z17.views.floatingMutilple.Z17MultipleView (Z17MultipleFabView.kt:31)");
            }
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            companion = Composer.INSTANCE;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Z17MultipleFabState.COLLAPSED, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            mutableState = (MutableState) objRememberedValue;
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            obj3 = objRememberedValue2;
            if (objRememberedValue2 == companion.getEmpty()) {
                MutableTransitionState mutableTransitionState4 = new MutableTransitionState(Z17MultipleView_jA1GFJw$lambda$1(mutableState));
                mutableTransitionState4.setTargetState$animation_core(Z17MultipleFabState.COLLAPSED);
                composerStartRestartGroup.updateRememberedValue(mutableTransitionState4);
                obj3 = mutableTransitionState4;
            }
            Transition transitionUpdateTransition2 = TransitionKt.updateTransition((MutableTransitionState) obj3, "transition", composerStartRestartGroup, MutableTransitionState.$stable | 48, 0);
            Function3 function4 = new Function3() { // from class: d9.m
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj4, Object obj5, Object obj6) {
                    return Z17MultipleFabViewKt.Z17MultipleView_jA1GFJw$lambda$5((Transition.Segment) obj4, (Composer) obj5, ((Integer) obj6).intValue());
                }
            };
            TwoWayConverter<Float, AnimationVector1D> vectorConverter2 = VectorConvertersKt.getVectorConverter(r.f36628a);
            MutableTransitionState mutableTransitionState5 = (MutableTransitionState) transitionUpdateTransition2.getCurrentState();
            composerStartRestartGroup.startReplaceGroup(200967883);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(200967883, 0, -1, "cu.z17.views.floatingMutilple.Z17MultipleView.<anonymous> (Z17MultipleFabView.kt:48)");
            }
            currentState = mutableTransitionState5.getCurrentState();
            z17MultipleFabState = Z17MultipleFabState.EXPANDED;
            if (currentState == z17MultipleFabState) {
                f10 = 230.0f;
            } else {
                f10 = 0.0f;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composerStartRestartGroup.endReplaceGroup();
            Float fValueOf2 = Float.valueOf(f10);
            MutableTransitionState mutableTransitionState6 = (MutableTransitionState) transitionUpdateTransition2.getTargetState();
            composerStartRestartGroup.startReplaceGroup(200967883);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(200967883, 0, -1, "cu.z17.views.floatingMutilple.Z17MultipleView.<anonymous> (Z17MultipleFabView.kt:48)");
            }
            if (mutableTransitionState6.getCurrentState() != z17MultipleFabState) {
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composerStartRestartGroup.endReplaceGroup();
            State stateCreateTransitionAnimation2 = TransitionKt.createTransitionAnimation(transitionUpdateTransition2, fValueOf2, Float.valueOf(f11), (FiniteAnimationSpec) function4.invoke(transitionUpdateTransition2.getSegment(), composerStartRestartGroup, 0), vectorConverter2, Key.ROTATION, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE);
            Modifier modifierFillMaxSize$default2 = SizeKt.fillMaxSize$default(modifier2, 0.0f, 1, null);
            Alignment.Companion companion4 = Alignment.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.m1615spacedByD5KLDUw(Dp.m8823constructorimpl(16), companion4.getBottom()), companion4.getEnd(), composerStartRestartGroup, 54);
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxSize$default2);
            ComposeUiNode.Companion companion5 = ComposeUiNode.INSTANCE;
            constructor = companion5.getConstructor();
            if (!defpackage.r.a(composerStartRestartGroup.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            composerM5176constructorimpl = Updater.m5176constructorimpl(composerStartRestartGroup);
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyColumnMeasurePolicy2, companion5.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap2, companion5.getSetResolvedCompositionLocals());
            setCompositeKeyHash = companion5.getSetCompositeKeyHash();
            if (composerM5176constructorimpl.getInserting()) {
                composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            } else {
                composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier2, companion5.getSetModifier());
            ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
            if (Z17MultipleView_jA1GFJw$lambda$1(mutableState) == z17MultipleFabState) {
                z11 = true;
            } else {
                z11 = false;
            }
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == companion.getEmpty()) {
                objRememberedValue3 = new a() { // from class: d9.n
                    @Override // lb.a
                    public final Object invoke() {
                        return Z17MultipleFabViewKt.Z17MultipleView_jA1GFJw$lambda$12$lambda$9$lambda$8(mutableState);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            int i18 = i12 << 6;
            Z17MultipleFabMenuKt.Z17MultipleFabMenu(null, z11, items, (a) objRememberedValue3, composerStartRestartGroup, (i18 & 896) | 3072, 1);
            Z17MultipleFabState z17MultipleFabStateZ17MultipleView_jA1GFJw$lambda$2 = Z17MultipleView_jA1GFJw$lambda$1(mutableState);
            float fZ17MultipleView_jA1GFJw$lambda$8 = Z17MultipleView_jA1GFJw$lambda$7(stateCreateTransitionAnimation2);
            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue4 == companion.getEmpty()) {
                objRememberedValue4 = new Function1() { // from class: d9.o
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj4) {
                        return Z17MultipleFabViewKt.Z17MultipleView_jA1GFJw$lambda$12$lambda$11$lambda$10(mutableState, (Z17MultipleFabState) obj4);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            Function1 function2 = (Function1) objRememberedValue4;
            if (Z17MultipleView_jA1GFJw$lambda$1(mutableState) == Z17MultipleFabState.COLLAPSED) {
                close = add;
            } else {
                close = CloseKt.getClose(Icons.Outlined.INSTANCE);
            }
            Z17MultipleFabKt.m10138Z17MultipleFabnBX6wN0(null, z17MultipleFabStateZ17MultipleView_jA1GFJw$lambda$2, fZ17MultipleView_jA1GFJw$lambda$8, function2, j17, j16, close, composerStartRestartGroup, (57344 & i12) | 3072 | (458752 & i18), 1);
            primary = j16;
            Composer composer4 = composerStartRestartGroup;
            composer4.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier2;
            obj2 = add;
            j12 = j17;
            composer2 = composer4;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
            obj2 = add;
            j12 = background;
            composer2 = composerStartRestartGroup;
        }
        j13 = primary;
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: d9.p
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj4, Object obj5) {
                    return Z17MultipleFabViewKt.Z17MultipleView_jA1GFJw$lambda$13(items, modifier3, obj2, j13, j12, i10, i11, (Composer) obj4, ((Integer) obj5).intValue());
                }
            });
        }
    }

    private static final Z17MultipleFabState Z17MultipleView_jA1GFJw$lambda$1(MutableState<Z17MultipleFabState> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 Z17MultipleView_jA1GFJw$lambda$12$lambda$11$lambda$10(MutableState mutableState, Z17MultipleFabState state) {
        y.i(state, "state");
        mutableState.setValue(state);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 Z17MultipleView_jA1GFJw$lambda$12$lambda$9$lambda$8(MutableState mutableState) {
        mutableState.setValue(Z17MultipleFabState.COLLAPSED);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 Z17MultipleView_jA1GFJw$lambda$13(List list, Modifier modifier, Object obj, long j10, long j11, int i10, int i11, Composer composer, int i12) {
        m10142Z17MultipleViewjA1GFJw(list, modifier, obj, j10, j11, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    public static final FiniteAnimationSpec Z17MultipleView_jA1GFJw$lambda$5(Transition.Segment animateFloat, Composer composer, int i10) {
        y.i(animateFloat, "$this$animateFloat");
        composer.startReplaceGroup(-1372507710);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1372507710, i10, -1, "cu.z17.views.floatingMutilple.Z17MultipleView.<anonymous> (Z17MultipleFabView.kt:46)");
        }
        TweenSpec tweenSpecTween$default = AnimationSpecKt.tween$default(150, 0, EasingKt.getFastOutSlowInEasing(), 2, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return tweenSpecTween$default;
    }

    private static final float Z17MultipleView_jA1GFJw$lambda$7(State<Float> state) {
        return state.getValue().floatValue();
    }
}
