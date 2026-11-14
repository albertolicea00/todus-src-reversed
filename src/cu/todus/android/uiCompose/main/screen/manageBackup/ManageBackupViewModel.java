package cu.todus.android.uiCompose.main.screen.manageBackup;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.p001lifecycle.ViewModelKt;
import cb.l;
import cb.m;
import cu.todus.android.R;
import cu.todus.android.backup.Exporter;
import cu.todus.android.data.preferences.Owner;
import cu.todus.android.di.MainModule;
import cu.todus.android.repositories.MainRepository;
import cu.todus.android.repositories.RoomsRepository;
import cu.todus.android.uiCompose.shared.insideNotification.Cause;
import cu.todus.android.uiCompose.shared.insideNotification.InsideNotificationState;
import cu.todus.android.utils.CoroutineUtilsKt;
import cu.todus.android.viewModel.ToDusViewModel;
import cu.todus.android.xmpp.extension.file.ExtensionFile;
import java.io.File;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.y;
import le.a0;
import ua.k0;
import ua.v;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J#\u0010\t\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\u000b\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\r\u001a\u00020\u0007¢\u0006\u0004\b\r\u0010\u0003R\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcu/todus/android/uiCompose/main/screen/manageBackup/ManageBackupViewModel;", "Lcu/todus/android/viewModel/ToDusViewModel;", "<init>", "()V", "Ljava/io/File;", ExtensionFile.ELEMENT, "Lkotlin/Function0;", "Lua/k0;", "onCompleted", "import", "(Ljava/io/File;Llb/a;)V", "export", "(Llb/a;)V", "notABackupFile", "Lcu/todus/android/repositories/RoomsRepository;", "roomRepository", "Lcu/todus/android/repositories/RoomsRepository;", "Lv5/f;", "gson", "Lv5/f;", "Lcu/todus/android/repositories/MainRepository;", "mainRepository", "Lcu/todus/android/repositories/MainRepository;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ManageBackupViewModel extends ToDusViewModel {
    public static final int $stable = 8;
    private final RoomsRepository roomRepository = RoomsRepository.INSTANCE.getInstance();
    private final v5.f gson = MainModule.INSTANCE.getInstance().getGson();
    private final MainRepository mainRepository = MainRepository.INSTANCE.getInstance();

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.manageBackup.ManageBackupViewModel$export$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.manageBackup.ManageBackupViewModel$export$1", f = "ManageBackupViewModel.kt", l = {96}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class AnonymousClass1 extends m implements Function1 {
        final /* synthetic */ lb.a $onCompleted;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(lb.a aVar, ab.e<? super AnonymousClass1> eVar) {
            super(1, eVar);
            this.$onCompleted = aVar;
        }

        @Override // cb.a
        public final ab.e<k0> create(ab.e<?> eVar) {
            return ManageBackupViewModel.this.new AnonymousClass1(this.$onCompleted, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super k0> eVar) {
            return ((AnonymousClass1) create(eVar)).invokeSuspend(k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                v.b(obj);
                Exporter exporter = new Exporter(new ManageBackupViewModel$export$1$exporter$1(ManageBackupViewModel.this.roomRepository), new ManageBackupViewModel$export$1$exporter$2(ManageBackupViewModel.this.roomRepository), ManageBackupViewModel.this.gson, new ManageBackupViewModel$export$1$exporter$3(ManageBackupViewModel.this, null), new ManageBackupViewModel$export$1$exporter$4(ManageBackupViewModel.this, null));
                String username = ((Owner) ManageBackupViewModel.this.mainRepository.getOwner().invoke()).getUsername();
                this.L$0 = l.a(exporter);
                this.label = 1;
                obj = exporter.export(username, this);
                if (obj == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v.b(obj);
            }
            if (((Boolean) obj).booleanValue()) {
                MainRepository mainRepository = ManageBackupViewModel.this.mainRepository;
                String string = UUID.randomUUID().toString();
                y.h(string, "toString(...)");
                String strO = a0.O(string, "-", "", false, 4, null);
                Cause cause = Cause.CORRECT;
                String string2 = MainModule.INSTANCE.getInstance().getAppContext().getString(R.string.msgs_exported_correctly);
                y.h(string2, "getString(...)");
                mainRepository.addNewNotification(new InsideNotificationState(strO, cause, string2));
            } else {
                MainRepository mainRepository2 = ManageBackupViewModel.this.mainRepository;
                String string3 = UUID.randomUUID().toString();
                y.h(string3, "toString(...)");
                String strO2 = a0.O(string3, "-", "", false, 4, null);
                Cause cause2 = Cause.ERROR;
                String string4 = MainModule.INSTANCE.getInstance().getAppContext().getString(R.string.msgs_not_exported_correctly);
                y.h(string4, "getString(...)");
                mainRepository2.addNewNotification(new InsideNotificationState(strO2, cause2, string4));
            }
            this.$onCompleted.invoke();
            return k0.f43947a;
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.manageBackup.ManageBackupViewModel$import$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.manageBackup.ManageBackupViewModel$import$1", f = "ManageBackupViewModel.kt", l = {47}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C12931 extends m implements Function1 {
        final /* synthetic */ File $file;
        final /* synthetic */ lb.a $onCompleted;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12931(File file, lb.a aVar, ab.e<? super C12931> eVar) {
            super(1, eVar);
            this.$file = file;
            this.$onCompleted = aVar;
        }

        @Override // cb.a
        public final ab.e<k0> create(ab.e<?> eVar) {
            return ManageBackupViewModel.this.new C12931(this.$file, this.$onCompleted, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super k0> eVar) {
            return ((C12931) create(eVar)).invokeSuspend(k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                v.b(obj);
                Exporter exporter = new Exporter(new ManageBackupViewModel$import$1$exporter$1(ManageBackupViewModel.this.roomRepository), new ManageBackupViewModel$import$1$exporter$2(ManageBackupViewModel.this.roomRepository), ManageBackupViewModel.this.gson, new ManageBackupViewModel$import$1$exporter$3(ManageBackupViewModel.this, null), new ManageBackupViewModel$import$1$exporter$4(ManageBackupViewModel.this, null));
                File file = this.$file;
                String username = ((Owner) ManageBackupViewModel.this.mainRepository.getOwner().invoke()).getUsername();
                this.L$0 = l.a(exporter);
                this.label = 1;
                obj = exporter.m9796import(file, username, this);
                if (obj == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v.b(obj);
            }
            if (((Boolean) obj).booleanValue()) {
                MainRepository mainRepository = ManageBackupViewModel.this.mainRepository;
                String string = UUID.randomUUID().toString();
                y.h(string, "toString(...)");
                String strO = a0.O(string, "-", "", false, 4, null);
                Cause cause = Cause.CORRECT;
                String string2 = MainModule.INSTANCE.getInstance().getAppContext().getString(R.string.msgs_imported_correctly);
                y.h(string2, "getString(...)");
                mainRepository.addNewNotification(new InsideNotificationState(strO, cause, string2));
            } else {
                MainRepository mainRepository2 = ManageBackupViewModel.this.mainRepository;
                String string3 = UUID.randomUUID().toString();
                y.h(string3, "toString(...)");
                String strO2 = a0.O(string3, "-", "", false, 4, null);
                Cause cause2 = Cause.ERROR;
                String string4 = MainModule.INSTANCE.getInstance().getAppContext().getString(R.string.msgs_not_imported_correctly);
                y.h(string4, "getString(...)");
                mainRepository2.addNewNotification(new InsideNotificationState(strO2, cause2, string4));
            }
            this.$onCompleted.invoke();
            return k0.f43947a;
        }
    }

    public final void export(lb.a onCompleted) {
        y.i(onCompleted, "onCompleted");
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(onCompleted, null), 3, null);
    }

    /* JADX INFO: renamed from: import, reason: not valid java name */
    public final void m9943import(File file, lb.a onCompleted) {
        y.i(file, "file");
        y.i(onCompleted, "onCompleted");
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new C12931(file, onCompleted, null), 3, null);
    }

    public final void notABackupFile() {
        MainRepository mainRepository = this.mainRepository;
        String string = UUID.randomUUID().toString();
        y.h(string, "toString(...)");
        String strO = a0.O(string, "-", "", false, 4, null);
        Cause cause = Cause.ERROR;
        String string2 = MainModule.INSTANCE.getInstance().getAppContext().getString(R.string.selected_file_is_not_correct);
        y.h(string2, "getString(...)");
        mainRepository.addNewNotification(new InsideNotificationState(strO, cause, string2));
    }
}
