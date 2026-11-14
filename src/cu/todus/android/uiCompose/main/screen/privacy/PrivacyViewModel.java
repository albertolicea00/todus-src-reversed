package cu.todus.android.uiCompose.main.screen.privacy;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.spatial.RectListKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.media3.container.MdtaMetadataEntry;
import androidx.p001lifecycle.ViewModelKt;
import androidx.paging.CachedPagingDataKt;
import androidx.paging.Pager;
import androidx.paging.PagingConfig;
import androidx.paging.PagingSource;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import cu.todus.android.data.db.entity.toDus.UserRoomJoin;
import cu.todus.android.data.preferences.Owner;
import cu.todus.android.repositories.MainRepository;
import cu.todus.android.repositories.UsersRepository;
import cu.todus.android.utils.CoroutineUtilsKt;
import cu.todus.android.viewModel.ToDusViewModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t2\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\rJ3\u0010\u0012\u001a\u00020\u00102$\u0010\u0011\u001a \u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u000f\u0012\u0004\u0012\u00020\u00100\u000e¢\u0006\u0004\b\u0012\u0010\u0013JK\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00072$\u0010\u0011\u001a \u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u000f\u0012\u0004\u0012\u00020\u00100\u000e¢\u0006\u0004\b\u0017\u0010\u0018J9\u0010\u001c\u001a\u00020\u00102*\u0010\u0011\u001a&\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u001a\u0012\u0004\u0012\u00020\u00100\u0019¢\u0006\u0004\b\u001c\u0010\u001dJA\u0010\u001f\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u00072*\u0010\u0011\u001a&\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u001a\u0012\u0004\u0012\u00020\u00100\u0019¢\u0006\u0004\b\u001f\u0010 JG\u0010\"\u001a\u00020\u00102\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00070\u001a2*\u0010\u0011\u001a&\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u001a\u0012\u0004\u0012\u00020\u00100\u0019¢\u0006\u0004\b\"\u0010#R\u0016\u0010%\u001a\u00020$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010(\u001a\u00020'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010+\u001a\u00020*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,¨\u0006-"}, d2 = {"Lcu/todus/android/uiCompose/main/screen/privacy/PrivacyViewModel;", "Lcu/todus/android/viewModel/ToDusViewModel;", "<init>", "()V", "Lcu/todus/android/data/preferences/Owner;", UserRoomJoin.AFFILIATION_OWNER, "()Lcu/todus/android/data/preferences/Owner;", "", "filter", "Lte/h;", "Landroidx/paging/PagingData;", "Lcu/todus/android/data/db/pojo/Friend;", "friendsOnDbNoHeaders", "(Ljava/lang/String;)Lte/h;", "Lkotlin/Function1;", "Lua/y;", "Lua/k0;", "onResult", "getProfilePrivacy", "(Lkotlin/jvm/functions/Function1;)V", "privacyOfProfileInfo", "privacyOfLast", "privacyOfProfilePhoto", "changePrivacyOfProfile", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "Lkotlin/Function3;", "", "Lcu/todus/android/data/db/pojo/Partner;", "getPrivacyOfAdd", "(Lkotlin/jvm/functions/Function3;)V", AppMeasurementSdk.ConditionalUserProperty.VALUE, "changePrivacyOfAdd", "(Ljava/lang/String;Lkotlin/jvm/functions/Function3;)V", "excludes", "changePrivacyOfAddSetExcludes", "(Ljava/util/List;Lkotlin/jvm/functions/Function3;)V", "Lcu/todus/android/repositories/MainRepository;", "mainRepository", "Lcu/todus/android/repositories/MainRepository;", "Lcu/todus/android/repositories/UsersRepository;", "usersRepository", "Lcu/todus/android/repositories/UsersRepository;", "Landroidx/paging/PagingConfig;", "contactsPagingConfig", "Landroidx/paging/PagingConfig;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class PrivacyViewModel extends ToDusViewModel {
    public static final int $stable = 8;
    private MainRepository mainRepository = MainRepository.INSTANCE.getInstance();
    private final UsersRepository usersRepository = UsersRepository.INSTANCE.getInstance();
    private final PagingConfig contactsPagingConfig = new PagingConfig(30, 0, true, 60, Integer.MAX_VALUE, 0, 32, null);

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.privacy.PrivacyViewModel$changePrivacyOfAdd$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.privacy.PrivacyViewModel$changePrivacyOfAdd$1", f = "PrivacyViewModel.kt", l = {76, MdtaMetadataEntry.TYPE_INDICATOR_UNSIGNED_INT64}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class AnonymousClass1 extends cb.m implements Function1 {
        final /* synthetic */ Function3 $onResult;
        final /* synthetic */ String $value;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str, Function3 function3, ab.e<? super AnonymousClass1> eVar) {
            super(1, eVar);
            this.$value = str;
            this.$onResult = function3;
        }

        @Override // cb.a
        public final ab.e<ua.k0> create(ab.e<?> eVar) {
            return PrivacyViewModel.this.new AnonymousClass1(this.$value, this.$onResult, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super ua.k0> eVar) {
            return ((AnonymousClass1) create(eVar)).invokeSuspend(ua.k0.f43947a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x003e, code lost:
        
            if (r5 == r0) goto L15;
         */
        @Override // cb.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r5) {
            /*
                r4 = this;
                java.lang.Object r0 = bb.b.g()
                int r1 = r4.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L1e
                if (r1 == r3) goto L1a
                if (r1 != r2) goto L12
                ua.v.b(r5)
                goto L41
            L12:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r0)
                throw r5
            L1a:
                ua.v.b(r5)
                goto L32
            L1e:
                ua.v.b(r5)
                cu.todus.android.uiCompose.main.screen.privacy.PrivacyViewModel r5 = cu.todus.android.uiCompose.main.screen.privacy.PrivacyViewModel.this
                cu.todus.android.repositories.MainRepository r5 = cu.todus.android.uiCompose.main.screen.privacy.PrivacyViewModel.access$getMainRepository$p(r5)
                java.lang.String r1 = r4.$value
                r4.label = r3
                java.lang.Object r5 = r5.updatePrivacyOfAdd(r1, r4)
                if (r5 != r0) goto L32
                goto L40
            L32:
                cu.todus.android.uiCompose.main.screen.privacy.PrivacyViewModel r5 = cu.todus.android.uiCompose.main.screen.privacy.PrivacyViewModel.this
                cu.todus.android.repositories.MainRepository r5 = cu.todus.android.uiCompose.main.screen.privacy.PrivacyViewModel.access$getMainRepository$p(r5)
                r4.label = r2
                java.lang.Object r5 = r5.getPrivacyOfAdd(r4)
                if (r5 != r0) goto L41
            L40:
                return r0
            L41:
                ua.y r5 = (ua.y) r5
                kotlin.jvm.functions.Function3 r0 = r4.$onResult
                if (r5 == 0) goto L4f
                java.lang.Object r1 = r5.f()
                java.lang.String r1 = (java.lang.String) r1
                if (r1 != 0) goto L51
            L4f:
                java.lang.String r1 = "error"
            L51:
                if (r5 == 0) goto L5b
                java.lang.Object r2 = r5.g()
                java.util.List r2 = (java.util.List) r2
                if (r2 != 0) goto L5f
            L5b:
                java.util.List r2 = va.w.n()
            L5f:
                if (r5 == 0) goto L69
                java.lang.Object r5 = r5.h()
                java.util.List r5 = (java.util.List) r5
                if (r5 != 0) goto L6d
            L69:
                java.util.List r5 = va.w.n()
            L6d:
                r0.invoke(r1, r2, r5)
                ua.k0 r5 = ua.k0.f43947a
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.uiCompose.main.screen.privacy.PrivacyViewModel.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.privacy.PrivacyViewModel$changePrivacyOfAddSetExcludes$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.privacy.PrivacyViewModel$changePrivacyOfAddSetExcludes$1", f = "PrivacyViewModel.kt", l = {92, 94}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C12961 extends cb.m implements Function1 {
        final /* synthetic */ List<String> $excludes;
        final /* synthetic */ Function3 $onResult;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12961(List<String> list, Function3 function3, ab.e<? super C12961> eVar) {
            super(1, eVar);
            this.$excludes = list;
            this.$onResult = function3;
        }

        @Override // cb.a
        public final ab.e<ua.k0> create(ab.e<?> eVar) {
            return PrivacyViewModel.this.new C12961(this.$excludes, this.$onResult, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super ua.k0> eVar) {
            return ((C12961) create(eVar)).invokeSuspend(ua.k0.f43947a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x003e, code lost:
        
            if (r5 == r0) goto L15;
         */
        @Override // cb.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r5) {
            /*
                r4 = this;
                java.lang.Object r0 = bb.b.g()
                int r1 = r4.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L1e
                if (r1 == r3) goto L1a
                if (r1 != r2) goto L12
                ua.v.b(r5)
                goto L41
            L12:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r0)
                throw r5
            L1a:
                ua.v.b(r5)
                goto L32
            L1e:
                ua.v.b(r5)
                cu.todus.android.uiCompose.main.screen.privacy.PrivacyViewModel r5 = cu.todus.android.uiCompose.main.screen.privacy.PrivacyViewModel.this
                cu.todus.android.repositories.MainRepository r5 = cu.todus.android.uiCompose.main.screen.privacy.PrivacyViewModel.access$getMainRepository$p(r5)
                java.util.List<java.lang.String> r1 = r4.$excludes
                r4.label = r3
                java.lang.Object r5 = r5.updatePrivacyOfAddExcludes(r1, r4)
                if (r5 != r0) goto L32
                goto L40
            L32:
                cu.todus.android.uiCompose.main.screen.privacy.PrivacyViewModel r5 = cu.todus.android.uiCompose.main.screen.privacy.PrivacyViewModel.this
                cu.todus.android.repositories.MainRepository r5 = cu.todus.android.uiCompose.main.screen.privacy.PrivacyViewModel.access$getMainRepository$p(r5)
                r4.label = r2
                java.lang.Object r5 = r5.getPrivacyOfAdd(r4)
                if (r5 != r0) goto L41
            L40:
                return r0
            L41:
                ua.y r5 = (ua.y) r5
                kotlin.jvm.functions.Function3 r0 = r4.$onResult
                if (r5 == 0) goto L4f
                java.lang.Object r1 = r5.f()
                java.lang.String r1 = (java.lang.String) r1
                if (r1 != 0) goto L51
            L4f:
                java.lang.String r1 = "error"
            L51:
                if (r5 == 0) goto L5b
                java.lang.Object r2 = r5.g()
                java.util.List r2 = (java.util.List) r2
                if (r2 != 0) goto L5f
            L5b:
                java.util.List r2 = va.w.n()
            L5f:
                if (r5 == 0) goto L69
                java.lang.Object r5 = r5.h()
                java.util.List r5 = (java.util.List) r5
                if (r5 != 0) goto L6d
            L69:
                java.util.List r5 = va.w.n()
            L6d:
                r0.invoke(r1, r2, r5)
                ua.k0 r5 = ua.k0.f43947a
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.uiCompose.main.screen.privacy.PrivacyViewModel.C12961.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.privacy.PrivacyViewModel$changePrivacyOfProfile$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.privacy.PrivacyViewModel$changePrivacyOfProfile$1", f = "PrivacyViewModel.kt", l = {47, ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C12971 extends cb.m implements Function1 {
        final /* synthetic */ Function1 $onResult;
        final /* synthetic */ String $privacyOfLast;
        final /* synthetic */ String $privacyOfProfileInfo;
        final /* synthetic */ String $privacyOfProfilePhoto;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12971(String str, String str2, String str3, Function1 function1, ab.e<? super C12971> eVar) {
            super(1, eVar);
            this.$privacyOfProfileInfo = str;
            this.$privacyOfLast = str2;
            this.$privacyOfProfilePhoto = str3;
            this.$onResult = function1;
        }

        @Override // cb.a
        public final ab.e<ua.k0> create(ab.e<?> eVar) {
            return PrivacyViewModel.this.new C12971(this.$privacyOfProfileInfo, this.$privacyOfLast, this.$privacyOfProfilePhoto, this.$onResult, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super ua.k0> eVar) {
            return ((C12971) create(eVar)).invokeSuspend(ua.k0.f43947a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0042, code lost:
        
            if (r7 == r0) goto L15;
         */
        @Override // cb.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) {
            /*
                r6 = this;
                java.lang.Object r0 = bb.b.g()
                int r1 = r6.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L1e
                if (r1 == r3) goto L1a
                if (r1 != r2) goto L12
                ua.v.b(r7)
                goto L45
            L12:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r0)
                throw r7
            L1a:
                ua.v.b(r7)
                goto L36
            L1e:
                ua.v.b(r7)
                cu.todus.android.uiCompose.main.screen.privacy.PrivacyViewModel r7 = cu.todus.android.uiCompose.main.screen.privacy.PrivacyViewModel.this
                cu.todus.android.repositories.MainRepository r7 = cu.todus.android.uiCompose.main.screen.privacy.PrivacyViewModel.access$getMainRepository$p(r7)
                java.lang.String r1 = r6.$privacyOfProfileInfo
                java.lang.String r4 = r6.$privacyOfLast
                java.lang.String r5 = r6.$privacyOfProfilePhoto
                r6.label = r3
                java.lang.Object r7 = r7.updateProfilePrivacy(r1, r4, r5, r6)
                if (r7 != r0) goto L36
                goto L44
            L36:
                cu.todus.android.uiCompose.main.screen.privacy.PrivacyViewModel r7 = cu.todus.android.uiCompose.main.screen.privacy.PrivacyViewModel.this
                cu.todus.android.repositories.MainRepository r7 = cu.todus.android.uiCompose.main.screen.privacy.PrivacyViewModel.access$getMainRepository$p(r7)
                r6.label = r2
                java.lang.Object r7 = r7.getProfilePrivacy(r6)
                if (r7 != r0) goto L45
            L44:
                return r0
            L45:
                ua.y r7 = (ua.y) r7
                kotlin.jvm.functions.Function1 r0 = r6.$onResult
                if (r7 != 0) goto L52
                ua.y r7 = new ua.y
                java.lang.String r1 = "error"
                r7.<init>(r1, r1, r1)
            L52:
                r0.invoke(r7)
                ua.k0 r7 = ua.k0.f43947a
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.uiCompose.main.screen.privacy.PrivacyViewModel.C12971.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.privacy.PrivacyViewModel$getPrivacyOfAdd$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.privacy.PrivacyViewModel$getPrivacyOfAdd$1", f = "PrivacyViewModel.kt", l = {RectListKt.BitOffsetForGesturable}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C12981 extends cb.m implements Function1 {
        final /* synthetic */ Function3 $onResult;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12981(Function3 function3, ab.e<? super C12981> eVar) {
            super(1, eVar);
            this.$onResult = function3;
        }

        @Override // cb.a
        public final ab.e<ua.k0> create(ab.e<?> eVar) {
            return PrivacyViewModel.this.new C12981(this.$onResult, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super ua.k0> eVar) {
            return ((C12981) create(eVar)).invokeSuspend(ua.k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            String str;
            List listN;
            List listN2;
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                ua.v.b(obj);
                MainRepository mainRepository = PrivacyViewModel.this.mainRepository;
                this.label = 1;
                obj = mainRepository.getPrivacyOfAdd(this);
                if (obj == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ua.v.b(obj);
            }
            ua.y yVar = (ua.y) obj;
            Function3 function3 = this.$onResult;
            if (yVar == null || (str = (String) yVar.f()) == null) {
                str = "error";
            }
            if (yVar == null || (listN = (List) yVar.g()) == null) {
                listN = va.w.n();
            }
            if (yVar == null || (listN2 = (List) yVar.h()) == null) {
                listN2 = va.w.n();
            }
            function3.invoke(str, listN, listN2);
            return ua.k0.f43947a;
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.privacy.PrivacyViewModel$getProfilePrivacy$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.privacy.PrivacyViewModel$getProfilePrivacy$1", f = "PrivacyViewModel.kt", l = {35}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C12991 extends cb.m implements Function1 {
        final /* synthetic */ Function1 $onResult;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12991(Function1 function1, ab.e<? super C12991> eVar) {
            super(1, eVar);
            this.$onResult = function1;
        }

        @Override // cb.a
        public final ab.e<ua.k0> create(ab.e<?> eVar) {
            return PrivacyViewModel.this.new C12991(this.$onResult, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super ua.k0> eVar) {
            return ((C12991) create(eVar)).invokeSuspend(ua.k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                ua.v.b(obj);
                MainRepository mainRepository = PrivacyViewModel.this.mainRepository;
                this.label = 1;
                obj = mainRepository.getProfilePrivacy(this);
                if (obj == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ua.v.b(obj);
            }
            ua.y yVar = (ua.y) obj;
            Function1 function1 = this.$onResult;
            if (yVar == null) {
                yVar = new ua.y("error", "error", "error");
            }
            function1.invoke(yVar);
            return ua.k0.f43947a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PagingSource friendsOnDbNoHeaders$lambda$0(PrivacyViewModel privacyViewModel, String str) {
        return privacyViewModel.usersRepository.getFriends(str);
    }

    public final void changePrivacyOfAdd(String value, Function3 onResult) {
        kotlin.jvm.internal.y.i(value, "value");
        kotlin.jvm.internal.y.i(onResult, "onResult");
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(value, onResult, null), 3, null);
    }

    public final void changePrivacyOfAddSetExcludes(List<String> excludes, Function3 onResult) {
        kotlin.jvm.internal.y.i(excludes, "excludes");
        kotlin.jvm.internal.y.i(onResult, "onResult");
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new C12961(excludes, onResult, null), 3, null);
    }

    public final void changePrivacyOfProfile(String privacyOfProfileInfo, String privacyOfLast, String privacyOfProfilePhoto, Function1 onResult) {
        kotlin.jvm.internal.y.i(privacyOfProfileInfo, "privacyOfProfileInfo");
        kotlin.jvm.internal.y.i(privacyOfLast, "privacyOfLast");
        kotlin.jvm.internal.y.i(privacyOfProfilePhoto, "privacyOfProfilePhoto");
        kotlin.jvm.internal.y.i(onResult, "onResult");
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new C12971(privacyOfProfileInfo, privacyOfLast, privacyOfProfilePhoto, onResult, null), 3, null);
    }

    public final te.h friendsOnDbNoHeaders(final String filter) {
        kotlin.jvm.internal.y.i(filter, "filter");
        return CachedPagingDataKt.cachedIn(new Pager(this.contactsPagingConfig, null, new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.privacy.w0
            @Override // lb.a
            public final Object invoke() {
                return PrivacyViewModel.friendsOnDbNoHeaders$lambda$0(this.f26821c, filter);
            }
        }, 2, null).getFlow(), ViewModelKt.getViewModelScope(this));
    }

    public final void getPrivacyOfAdd(Function3 onResult) {
        kotlin.jvm.internal.y.i(onResult, "onResult");
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new C12981(onResult, null), 3, null);
    }

    public final void getProfilePrivacy(Function1 onResult) {
        kotlin.jvm.internal.y.i(onResult, "onResult");
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new C12991(onResult, null), 3, null);
    }

    public final Owner owner() {
        return (Owner) this.mainRepository.getOwner().invoke();
    }
}
