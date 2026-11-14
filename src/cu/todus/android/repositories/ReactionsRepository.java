package cu.todus.android.repositories;

import androidx.compose.foundation.text.InlineTextContent;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.text.Placeholder;
import androidx.compose.ui.text.PlaceholderVerticalAlign;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import cu.todus.android.data.preferences.ReactionsSelected;
import cu.todus.android.di.PreferencesModule;
import cu.todus.android.utils.CoroutineUtilsKt;
import cu.z17.singledi.SingletonInitializer;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import pe.d1;
import va.w0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J#\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\nJ\u001e\u0010\u000f\u001a\u00020\u000e2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\fH\u0086@¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u000eH\u0086@¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00070\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001d\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00070\f8\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0017\u001a\u0004\b\u0019\u0010\u001aR(\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00070\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0017\u001a\u0004\b\u001c\u0010\u001a\"\u0004\b\u001d\u0010\u001e¨\u0006 "}, d2 = {"Lcu/todus/android/repositories/ReactionsRepository;", "", "<init>", "()V", "Landroidx/compose/ui/unit/TextUnit;", "size", "", "", "Landroidx/compose/foundation/text/InlineTextContent;", "inlineContent--R2X_6o", "(J)Ljava/util/Map;", "inlineContent", "", "reactions", "Lua/k0;", "setReactionsSelection", "(Ljava/util/List;Lab/e;)Ljava/lang/Object;", "resetToDefaultReactions", "(Lab/e;)Ljava/lang/Object;", "Lcu/todus/android/di/PreferencesModule;", "preferences", "Lcu/todus/android/di/PreferencesModule;", "defaultReactions", "Ljava/util/List;", "allReactions", "getAllReactions", "()Ljava/util/List;", "actualReactions", "getActualReactions", "setActualReactions", "(Ljava/util/List;)V", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ReactionsRepository {
    private List<String> actualReactions;
    private final List<String> allReactions;
    private final List<String> defaultReactions;
    private final PreferencesModule preferences = PreferencesModule.INSTANCE.getInstance();

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: renamed from: cu.todus.android.repositories.ReactionsRepository$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.repositories.ReactionsRepository$1", f = "ReactionsRepository.kt", l = {335}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class AnonymousClass1 extends cb.m implements Function1 {
        Object L$0;
        int label;

        public AnonymousClass1(ab.e<? super AnonymousClass1> eVar) {
            super(1, eVar);
        }

        @Override // cb.a
        public final ab.e<ua.k0> create(ab.e<?> eVar) {
            return ReactionsRepository.this.new AnonymousClass1(eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super ua.k0> eVar) {
            return ((AnonymousClass1) create(eVar)).invokeSuspend(ua.k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            ReactionsRepository reactionsRepository;
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                ua.v.b(obj);
                ReactionsRepository reactionsRepository2 = ReactionsRepository.this;
                PreferencesModule preferencesModule = reactionsRepository2.preferences;
                this.L$0 = reactionsRepository2;
                this.label = 1;
                Object reactionsSelected = preferencesModule.getReactionsSelected(this);
                if (reactionsSelected == objG) {
                    return objG;
                }
                reactionsRepository = reactionsRepository2;
                obj = reactionsSelected;
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                reactionsRepository = (ReactionsRepository) this.L$0;
                ua.v.b(obj);
            }
            List<String> list = ((ReactionsSelected) obj).getList();
            ReactionsRepository reactionsRepository3 = ReactionsRepository.this;
            if (list.isEmpty()) {
                list = reactionsRepository3.defaultReactions;
            }
            reactionsRepository.setActualReactions(list);
            return ua.k0.f43947a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcu/todus/android/repositories/ReactionsRepository$Companion;", "Lcu/z17/singledi/SingletonInitializer;", "Lcu/todus/android/repositories/ReactionsRepository;", "<init>", "()V", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion extends SingletonInitializer<ReactionsRepository> {
        public /* synthetic */ Companion(kotlin.jvm.internal.p pVar) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.repositories.ReactionsRepository$resetToDefaultReactions$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.repositories.ReactionsRepository", f = "ReactionsRepository.kt", l = {329}, m = "resetToDefaultReactions", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C11281 extends cb.d {
        int label;
        /* synthetic */ Object result;

        public C11281(ab.e<? super C11281> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ReactionsRepository.this.resetToDefaultReactions(this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.repositories.ReactionsRepository$setReactionsSelection$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.repositories.ReactionsRepository", f = "ReactionsRepository.kt", l = {324}, m = "setReactionsSelection", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C11291 extends cb.d {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C11291(ab.e<? super C11291> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ReactionsRepository.this.setReactionsSelection(null, this);
        }
    }

    public ReactionsRepository() {
        List<String> listQ = va.w.q("👍", "👎", "😂", "😭", "😡");
        this.defaultReactions = listQ;
        this.allReactions = va.w.q("👍", "🙒", "👎", "😂", "😭", "😡", "😤", "😥", "😦", "😧", "😨", "😩", "😰", "😱", "😳", "😵", "😶", "😷", "😸", "🙁", "🙇", "🙈", "🙉", "🙑");
        this.actualReactions = listQ;
        CoroutineUtilsKt.launchWithContext$default(pe.n0.a(d1.b()), null, null, new AnonymousClass1(null), 3, null);
    }

    /* JADX INFO: renamed from: inlineContent--R2X_6o$default, reason: not valid java name */
    public static /* synthetic */ Map m9801inlineContentR2X_6o$default(ReactionsRepository reactionsRepository, long j10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            j10 = TextUnitKt.getSp(20);
        }
        return reactionsRepository.m9802inlineContentR2X_6o(j10);
    }

    public final List<String> getActualReactions() {
        return this.actualReactions;
    }

    public final List<String> getAllReactions() {
        return this.allReactions;
    }

    /* JADX INFO: renamed from: inlineContent--R2X_6o, reason: not valid java name */
    public final Map<String, InlineTextContent> m9802inlineContentR2X_6o(long size) {
        TextUnitKt.m9026checkArithmeticR2X_6o(size);
        float f10 = 2;
        long jPack = TextUnitKt.pack(TextUnit.m9011getRawTypeimpl(size), TextUnit.m9013getValueimpl(size) / f10);
        PlaceholderVerticalAlign.Companion companion = PlaceholderVerticalAlign.INSTANCE;
        Placeholder placeholder = new Placeholder(size, jPack, companion.m8183getTextCenterJ6kI3mc(), null);
        ComposableSingletons$ReactionsRepositoryKt composableSingletons$ReactionsRepositoryKt = ComposableSingletons$ReactionsRepositoryKt.INSTANCE;
        Pair pairA = ua.z.a("server", new InlineTextContent(placeholder, composableSingletons$ReactionsRepositoryKt.getLambda$179410667$app_productionPFast()));
        TextUnitKt.m9026checkArithmeticR2X_6o(size);
        Pair pairA2 = ua.z.a("received", new InlineTextContent(new Placeholder(size, TextUnitKt.pack(TextUnit.m9011getRawTypeimpl(size), TextUnit.m9013getValueimpl(size) / f10), companion.m8183getTextCenterJ6kI3mc(), null), composableSingletons$ReactionsRepositoryKt.getLambda$348554442$app_productionPFast()));
        TextUnitKt.m9026checkArithmeticR2X_6o(size);
        Pair pairA3 = ua.z.a("read", new InlineTextContent(new Placeholder(size, TextUnitKt.pack(TextUnit.m9011getRawTypeimpl(size), TextUnit.m9013getValueimpl(size) / f10), companion.m8183getTextCenterJ6kI3mc(), null), composableSingletons$ReactionsRepositoryKt.getLambda$517698217$app_productionPFast()));
        TextUnitKt.m9026checkArithmeticR2X_6o(size);
        Pair pairA4 = ua.z.a("unable", new InlineTextContent(new Placeholder(size, TextUnitKt.pack(TextUnit.m9011getRawTypeimpl(size), TextUnit.m9013getValueimpl(size) / f10), companion.m8183getTextCenterJ6kI3mc(), null), composableSingletons$ReactionsRepositoryKt.getLambda$686841992$app_productionPFast()));
        TextUnitKt.m9026checkArithmeticR2X_6o(size);
        Pair pairA5 = ua.z.a("sentryUnsent", new InlineTextContent(new Placeholder(size, TextUnitKt.pack(TextUnit.m9011getRawTypeimpl(size), TextUnit.m9013getValueimpl(size) / f10), companion.m8183getTextCenterJ6kI3mc(), null), composableSingletons$ReactionsRepositoryKt.getLambda$855985767$app_productionPFast()));
        TextUnitKt.m9026checkArithmeticR2X_6o(size);
        return w0.l(pairA, pairA2, pairA3, pairA4, pairA5, ua.z.a("timeout", new InlineTextContent(new Placeholder(size, TextUnitKt.pack(TextUnit.m9011getRawTypeimpl(size), TextUnit.m9013getValueimpl(size) / f10), companion.m8183getTextCenterJ6kI3mc(), null), composableSingletons$ReactionsRepositoryKt.getLambda$1025129542$app_productionPFast())), ua.z.a("👍", new InlineTextContent(new Placeholder(size, size, companion.m8183getTextCenterJ6kI3mc(), null), composableSingletons$ReactionsRepositoryKt.getLambda$1194273317$app_productionPFast())), ua.z.a("👎", new InlineTextContent(new Placeholder(size, size, companion.m8183getTextCenterJ6kI3mc(), null), composableSingletons$ReactionsRepositoryKt.getLambda$1363417092$app_productionPFast())), ua.z.a("😂", new InlineTextContent(new Placeholder(size, size, companion.m8183getTextCenterJ6kI3mc(), null), composableSingletons$ReactionsRepositoryKt.getLambda$1532560867$app_productionPFast())), ua.z.a("😭", new InlineTextContent(new Placeholder(size, size, companion.m8183getTextCenterJ6kI3mc(), null), composableSingletons$ReactionsRepositoryKt.getLambda$1701704642$app_productionPFast())), ua.z.a("😡", new InlineTextContent(new Placeholder(size, size, companion.m8183getTextCenterJ6kI3mc(), null), composableSingletons$ReactionsRepositoryKt.m9799getLambda$321437504$app_productionPFast())), ua.z.a("😢", new InlineTextContent(new Placeholder(size, size, companion.m8183getTextCenterJ6kI3mc(), null), composableSingletons$ReactionsRepositoryKt.m9797getLambda$152293729$app_productionPFast())), ua.z.a("😤", new InlineTextContent(new Placeholder(size, size, companion.m8183getTextCenterJ6kI3mc(), null), composableSingletons$ReactionsRepositoryKt.getLambda$16850046$app_productionPFast())), ua.z.a("😥", new InlineTextContent(new Placeholder(size, size, companion.m8183getTextCenterJ6kI3mc(), null), composableSingletons$ReactionsRepositoryKt.getLambda$185993821$app_productionPFast())), ua.z.a("😦", new InlineTextContent(new Placeholder(size, size, companion.m8183getTextCenterJ6kI3mc(), null), composableSingletons$ReactionsRepositoryKt.getLambda$355137596$app_productionPFast())), ua.z.a("😧", new InlineTextContent(new Placeholder(size, size, companion.m8183getTextCenterJ6kI3mc(), null), composableSingletons$ReactionsRepositoryKt.getLambda$524281371$app_productionPFast())), ua.z.a("😨", new InlineTextContent(new Placeholder(size, size, companion.m8183getTextCenterJ6kI3mc(), null), composableSingletons$ReactionsRepositoryKt.getLambda$693425146$app_productionPFast())), ua.z.a("😩", new InlineTextContent(new Placeholder(size, size, companion.m8183getTextCenterJ6kI3mc(), null), composableSingletons$ReactionsRepositoryKt.getLambda$862568921$app_productionPFast())), ua.z.a("😰", new InlineTextContent(new Placeholder(size, size, companion.m8183getTextCenterJ6kI3mc(), null), composableSingletons$ReactionsRepositoryKt.getLambda$1031712696$app_productionPFast())), ua.z.a("😱", new InlineTextContent(new Placeholder(size, size, companion.m8183getTextCenterJ6kI3mc(), null), composableSingletons$ReactionsRepositoryKt.getLambda$1200856471$app_productionPFast())), ua.z.a("😳", new InlineTextContent(new Placeholder(size, size, companion.m8183getTextCenterJ6kI3mc(), null), composableSingletons$ReactionsRepositoryKt.getLambda$627052225$app_productionPFast())), ua.z.a("😵", new InlineTextContent(new Placeholder(size, size, companion.m8183getTextCenterJ6kI3mc(), null), composableSingletons$ReactionsRepositoryKt.getLambda$796196000$app_productionPFast())), ua.z.a("😶", new InlineTextContent(new Placeholder(size, size, companion.m8183getTextCenterJ6kI3mc(), null), composableSingletons$ReactionsRepositoryKt.getLambda$965339775$app_productionPFast())), ua.z.a("😷", new InlineTextContent(new Placeholder(size, size, companion.m8183getTextCenterJ6kI3mc(), null), composableSingletons$ReactionsRepositoryKt.getLambda$1134483550$app_productionPFast())), ua.z.a("😸", new InlineTextContent(new Placeholder(size, size, companion.m8183getTextCenterJ6kI3mc(), null), composableSingletons$ReactionsRepositoryKt.getLambda$1303627325$app_productionPFast())), ua.z.a("🙁", new InlineTextContent(new Placeholder(size, size, companion.m8183getTextCenterJ6kI3mc(), null), composableSingletons$ReactionsRepositoryKt.getLambda$1472771100$app_productionPFast())), ua.z.a("🙇", new InlineTextContent(new Placeholder(size, size, companion.m8183getTextCenterJ6kI3mc(), null), composableSingletons$ReactionsRepositoryKt.getLambda$1641914875$app_productionPFast())), ua.z.a("🙈", new InlineTextContent(new Placeholder(size, size, companion.m8183getTextCenterJ6kI3mc(), null), composableSingletons$ReactionsRepositoryKt.getLambda$1811058650$app_productionPFast())), ua.z.a("🙉", new InlineTextContent(new Placeholder(size, size, companion.m8183getTextCenterJ6kI3mc(), null), composableSingletons$ReactionsRepositoryKt.getLambda$1980202425$app_productionPFast())), ua.z.a("🙑", new InlineTextContent(new Placeholder(size, size, companion.m8183getTextCenterJ6kI3mc(), null), composableSingletons$ReactionsRepositoryKt.m9798getLambda$2145621096$app_productionPFast())), ua.z.a("🙒", new InlineTextContent(new Placeholder(size, size, companion.m8183getTextCenterJ6kI3mc(), null), composableSingletons$ReactionsRepositoryKt.getLambda$1575541954$app_productionPFast())));
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object resetToDefaultReactions(ab.e<? super ua.k0> eVar) {
        C11281 c11281;
        if (eVar instanceof C11281) {
            c11281 = (C11281) eVar;
            int i10 = c11281.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c11281.label = i10 - Integer.MIN_VALUE;
            } else {
                c11281 = new C11281(eVar);
            }
        } else {
            c11281 = new C11281(eVar);
        }
        Object obj = c11281.result;
        Object objG = bb.b.g();
        int i11 = c11281.label;
        if (i11 == 0) {
            ua.v.b(obj);
            PreferencesModule preferencesModule = this.preferences;
            ReactionsSelected reactionsSelected = new ReactionsSelected(this.defaultReactions);
            c11281.label = 1;
            if (preferencesModule.saveReactionsSelected(reactionsSelected, c11281) == objG) {
                return objG;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ua.v.b(obj);
        }
        this.actualReactions = this.defaultReactions;
        return ua.k0.f43947a;
    }

    public final void setActualReactions(List<String> list) {
        kotlin.jvm.internal.y.i(list, "<set-?>");
        this.actualReactions = list;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object setReactionsSelection(List<String> list, ab.e<? super ua.k0> eVar) {
        C11291 c11291;
        if (eVar instanceof C11291) {
            c11291 = (C11291) eVar;
            int i10 = c11291.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c11291.label = i10 - Integer.MIN_VALUE;
            } else {
                c11291 = new C11291(eVar);
            }
        } else {
            c11291 = new C11291(eVar);
        }
        Object obj = c11291.result;
        Object objG = bb.b.g();
        int i11 = c11291.label;
        if (i11 == 0) {
            ua.v.b(obj);
            PreferencesModule preferencesModule = this.preferences;
            ReactionsSelected reactionsSelected = new ReactionsSelected(list);
            c11291.L$0 = list;
            c11291.label = 1;
            if (preferencesModule.saveReactionsSelected(reactionsSelected, c11291) == objG) {
                return objG;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            list = (List) c11291.L$0;
            ua.v.b(obj);
        }
        this.actualReactions = list;
        return ua.k0.f43947a;
    }
}
