package cu.todus.android.uiCompose.main.screen.reactSelection;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.p001lifecycle.ViewModelKt;
import cu.todus.android.repositories.ReactionsRepository;
import cu.todus.android.utils.CoroutineUtilsKt;
import cu.todus.android.viewModel.ToDusViewModel;
import cu.z17.singledi.SinglediException;
import cu.z17.views.utils.Z17MutableListFlow;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.y;
import ua.k0;
import ua.v;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\u0003R\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u000f8\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcu/todus/android/uiCompose/main/screen/reactSelection/ReactionsSelectionViewModel;", "Lcu/todus/android/viewModel/ToDusViewModel;", "<init>", "()V", "", "newSelected", "", "pos", "Lua/k0;", "changeReaction", "(Ljava/lang/String;I)V", "reset", "Lcu/todus/android/repositories/ReactionsRepository;", "reactionsRepository", "Lcu/todus/android/repositories/ReactionsRepository;", "Lcu/z17/views/utils/Z17MutableListFlow;", "reactionsSelected", "Lcu/z17/views/utils/Z17MutableListFlow;", "getReactionsSelected", "()Lcu/z17/views/utils/Z17MutableListFlow;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ReactionsSelectionViewModel extends ToDusViewModel {
    public static final int $stable = 8;
    private final ReactionsRepository reactionsRepository;
    private final Z17MutableListFlow<String> reactionsSelected;

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.reactSelection.ReactionsSelectionViewModel$changeReaction$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.reactSelection.ReactionsSelectionViewModel$changeReaction$1", f = "ReactionsSelectionViewModel.kt", l = {19, 19}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class AnonymousClass1 extends cb.m implements Function1 {
        final /* synthetic */ String $newSelected;
        final /* synthetic */ int $pos;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str, int i10, ab.e<? super AnonymousClass1> eVar) {
            super(1, eVar);
            this.$newSelected = str;
            this.$pos = i10;
        }

        @Override // cb.a
        public final ab.e<k0> create(ab.e<?> eVar) {
            return ReactionsSelectionViewModel.this.new AnonymousClass1(this.$newSelected, this.$pos, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super k0> eVar) {
            return ((AnonymousClass1) create(eVar)).invokeSuspend(k0.f43947a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0058, code lost:
        
            if (r1.setReactionsSelection((java.util.List) r6, r5) == r0) goto L15;
         */
        @Override // cb.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r6) {
            /*
                r5 = this;
                java.lang.Object r0 = bb.b.g()
                int r1 = r5.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L22
                if (r1 == r3) goto L1a
                if (r1 != r2) goto L12
                ua.v.b(r6)
                goto L5b
            L12:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r0)
                throw r6
            L1a:
                java.lang.Object r1 = r5.L$0
                cu.todus.android.repositories.ReactionsRepository r1 = (cu.todus.android.repositories.ReactionsRepository) r1
                ua.v.b(r6)
                goto L4d
            L22:
                ua.v.b(r6)
                cu.todus.android.uiCompose.main.screen.reactSelection.ReactionsSelectionViewModel r6 = cu.todus.android.uiCompose.main.screen.reactSelection.ReactionsSelectionViewModel.this
                cu.z17.views.utils.Z17MutableListFlow r6 = r6.getReactionsSelected()
                java.lang.String r1 = r5.$newSelected
                int r4 = r5.$pos
                r6.change(r1, r4)
                cu.todus.android.uiCompose.main.screen.reactSelection.ReactionsSelectionViewModel r6 = cu.todus.android.uiCompose.main.screen.reactSelection.ReactionsSelectionViewModel.this
                cu.todus.android.repositories.ReactionsRepository r1 = cu.todus.android.uiCompose.main.screen.reactSelection.ReactionsSelectionViewModel.access$getReactionsRepository$p(r6)
                cu.todus.android.uiCompose.main.screen.reactSelection.ReactionsSelectionViewModel r6 = cu.todus.android.uiCompose.main.screen.reactSelection.ReactionsSelectionViewModel.this
                cu.z17.views.utils.Z17MutableListFlow r6 = r6.getReactionsSelected()
                te.h r6 = r6.getValue()
                r5.L$0 = r1
                r5.label = r3
                java.lang.Object r6 = te.j.x(r6, r5)
                if (r6 != r0) goto L4d
                goto L5a
            L4d:
                java.util.List r6 = (java.util.List) r6
                r3 = 0
                r5.L$0 = r3
                r5.label = r2
                java.lang.Object r6 = r1.setReactionsSelection(r6, r5)
                if (r6 != r0) goto L5b
            L5a:
                return r0
            L5b:
                ua.k0 r6 = ua.k0.f43947a
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.uiCompose.main.screen.reactSelection.ReactionsSelectionViewModel.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.reactSelection.ReactionsSelectionViewModel$reset$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.reactSelection.ReactionsSelectionViewModel$reset$1", f = "ReactionsSelectionViewModel.kt", l = {25}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C13001 extends cb.m implements Function1 {
        int label;

        public C13001(ab.e<? super C13001> eVar) {
            super(1, eVar);
        }

        @Override // cb.a
        public final ab.e<k0> create(ab.e<?> eVar) {
            return ReactionsSelectionViewModel.this.new C13001(eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super k0> eVar) {
            return ((C13001) create(eVar)).invokeSuspend(k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                v.b(obj);
                ReactionsRepository reactionsRepository = ReactionsSelectionViewModel.this.reactionsRepository;
                this.label = 1;
                if (reactionsRepository.resetToDefaultReactions(this) == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v.b(obj);
            }
            ReactionsSelectionViewModel.this.getReactionsSelected().set(ReactionsSelectionViewModel.this.reactionsRepository.getActualReactions());
            return k0.f43947a;
        }
    }

    public ReactionsSelectionViewModel() throws SinglediException {
        ReactionsRepository singletonInitializer = ReactionsRepository.INSTANCE.getInstance();
        this.reactionsRepository = singletonInitializer;
        this.reactionsSelected = new Z17MutableListFlow<>(singletonInitializer.getActualReactions());
    }

    public final void changeReaction(String newSelected, int pos) {
        y.i(newSelected, "newSelected");
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(newSelected, pos, null), 3, null);
    }

    public final Z17MutableListFlow<String> getReactionsSelected() {
        return this.reactionsSelected;
    }

    public final void reset() {
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new C13001(null), 3, null);
    }
}
