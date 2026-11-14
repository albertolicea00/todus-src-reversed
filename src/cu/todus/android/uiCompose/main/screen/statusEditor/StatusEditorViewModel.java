package cu.todus.android.uiCompose.main.screen.statusEditor;

import android.content.Context;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.media3.extractor.text.ttml.TtmlNode;
import androidx.media3.muxer.MuxerUtil;
import androidx.media3.muxer.WebmConstants;
import androidx.p001lifecycle.ViewModelKt;
import androidx.paging.CachedPagingDataKt;
import androidx.paging.Pager;
import androidx.paging.PagingConfig;
import androidx.paging.PagingData;
import androidx.paging.PagingDataTransforms__PagingDataTransformsKt;
import androidx.paging.PagingSource;
import cu.todus.android.data.db.entity.toDus.Status;
import cu.todus.android.data.db.entity.toDus.User;
import cu.todus.android.data.db.entity.toDus.UserRoomJoin;
import cu.todus.android.data.db.pojo.content.statusContent.StatusImageContent;
import cu.todus.android.data.db.pojo.content.statusContent.StatusTextContent;
import cu.todus.android.data.db.pojo.content.statusContent.StatusVideoContent;
import cu.todus.android.data.preferences.Owner;
import cu.todus.android.data.wrapper.FlowsState;
import cu.todus.android.di.MainModule;
import cu.todus.android.repositories.MainRepository;
import cu.todus.android.repositories.StatusRepository;
import cu.todus.android.repositories.UsersRepository;
import cu.todus.android.utils.CoroutineUtilsKt;
import cu.todus.android.viewModel.ToDusViewModel;
import cu.todus.android.xmpp.XMPPUtils;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.y;
import le.d0;
import pe.d1;
import pe.m0;
import te.b0;
import te.p0;
import te.r0;
import ua.k0;
import ua.v;
import va.w;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000Ä\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006JA\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r¢\u0006\u0004\b\u0011\u0010\u0012J1\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00132\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u000f0\r¢\u0006\u0004\b\u0016\u0010\u0017J9\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u00132\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u000f0\r¢\u0006\u0004\b\u001c\u0010\u001dJ!\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020!0 0\u001f2\u0006\u0010\u001e\u001a\u00020\u0007¢\u0006\u0004\b\"\u0010#J\u0015\u0010%\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020\u0007¢\u0006\u0004\b%\u0010&J-\u0010+\u001a\u00020\u000f2\u0006\u0010(\u001a\u00020'2\b\b\u0002\u0010)\u001a\u00020\u00072\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0*¢\u0006\u0004\b+\u0010,J\r\u0010-\u001a\u00020\u000f¢\u0006\u0004\b-\u0010\u0003J\u0015\u0010/\u001a\u00020\u000f2\u0006\u0010.\u001a\u00020\u0007¢\u0006\u0004\b/\u0010&R\u0014\u00101\u001a\u0002008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u0014\u00104\u001a\u0002038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u00105R\u0014\u00107\u001a\u0002068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u00108R\u0017\u0010:\u001a\u0002098\u0006¢\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=R\u001d\u0010@\u001a\b\u0012\u0004\u0012\u00020?0>8\u0006¢\u0006\f\n\u0004\b@\u0010A\u001a\u0004\bB\u0010CR\u001d\u0010D\u001a\b\u0012\u0004\u0012\u00020?0>8\u0006¢\u0006\f\n\u0004\bD\u0010A\u001a\u0004\bE\u0010CR\u0014\u0010G\u001a\u00020F8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bG\u0010HR#\u0010J\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020I0 0\u001f8\u0006¢\u0006\f\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010MR\"\u0010Q\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020P0O0N8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bQ\u0010RR#\u0010T\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020P0O0S8\u0006¢\u0006\f\n\u0004\bT\u0010U\u001a\u0004\bV\u0010W¨\u0006X"}, d2 = {"Lcu/todus/android/uiCompose/main/screen/statusEditor/StatusEditorViewModel;", "Lcu/todus/android/viewModel/ToDusViewModel;", "<init>", "()V", "Lcu/todus/android/data/preferences/Owner;", UserRoomJoin.AFFILIATION_OWNER, "()Lcu/todus/android/data/preferences/Owner;", "", "textContent", "", "fontColor", TtmlNode.ATTR_TTS_BACKGROUND_COLOR, "fontType", "Lkotlin/Function1;", "Lcu/todus/android/data/db/pojo/content/statusContent/StatusTextContent;", "Lua/k0;", "onComplete", "createTextStatus", "(Ljava/lang/String;IIILkotlin/jvm/functions/Function1;)V", "Ljava/io/File;", "imageFile", "Lcu/todus/android/data/db/pojo/content/statusContent/StatusImageContent;", "createImageStatus", "(Ljava/lang/String;Ljava/io/File;Lkotlin/jvm/functions/Function1;)V", "Landroid/content/Context;", "context", "videoFile", "Lcu/todus/android/data/db/pojo/content/statusContent/StatusVideoContent;", "createVideoStatus", "(Landroid/content/Context;Ljava/lang/String;Ljava/io/File;Lkotlin/jvm/functions/Function1;)V", "filter", "Lte/h;", "Landroidx/paging/PagingData;", "Lcu/todus/android/uiCompose/main/screen/chat/mentionList/MentionItemModel;", "partnersForMention", "(Ljava/lang/String;)Lte/h;", User.COLUMN_TODUS_ID, "searchForPartner", "(Ljava/lang/String;)V", "Lcu/todus/android/data/db/entity/toDus/Status;", "status", "repliedFrom", "Lkotlin/Function0;", "sendStatus", "(Lcu/todus/android/data/db/entity/toDus/Status;Ljava/lang/String;Llb/a;)V", "retrySendStatusesWithError", "statusId", "deleteStatus", "Lcu/todus/android/repositories/StatusRepository;", "statusRepository", "Lcu/todus/android/repositories/StatusRepository;", "Lcu/todus/android/repositories/UsersRepository;", "usersRepository", "Lcu/todus/android/repositories/UsersRepository;", "Lcu/todus/android/repositories/MainRepository;", "mainRepository", "Lcu/todus/android/repositories/MainRepository;", "Lv5/f;", "gson", "Lv5/f;", "getGson", "()Lv5/f;", "", "Landroidx/compose/ui/graphics/Color;", "colors", "Ljava/util/List;", "getColors", "()Ljava/util/List;", "invertedColors", "getInvertedColors", "Landroidx/paging/PagingConfig;", "statusPagingConfig", "Landroidx/paging/PagingConfig;", "Lcu/todus/android/data/db/pojo/StatusWithPartnersOrRooms;", "ownerStatus", "Lte/h;", "getOwnerStatus", "()Lte/h;", "Lte/b0;", "Lcu/todus/android/data/wrapper/FlowsState;", "Lcu/todus/android/data/db/pojo/Partner;", "_requestingPartner", "Lte/b0;", "Lte/p0;", "requestingPartner", "Lte/p0;", "getRequestingPartner", "()Lte/p0;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class StatusEditorViewModel extends ToDusViewModel {
    public static final int $stable = 8;
    private b0 _requestingPartner;
    private final te.h ownerStatus;
    private final p0 requestingPartner;
    private final PagingConfig statusPagingConfig;
    private final StatusRepository statusRepository = StatusRepository.INSTANCE.getInstance();
    private final UsersRepository usersRepository = UsersRepository.INSTANCE.getInstance();
    private final MainRepository mainRepository = MainRepository.INSTANCE.getInstance();
    private final v5.f gson = MainModule.INSTANCE.getInstance().getGson();
    private final List<Color> colors = w.q(Color.m5856boximpl(ColorKt.Color(4286150519L)), Color.m5856boximpl(ColorKt.Color(4294018951L)), Color.m5856boximpl(ColorKt.Color(4293837959L)), Color.m5856boximpl(ColorKt.Color(4287295886L)), Color.m5856boximpl(ColorKt.Color(4292839662L)));
    private final List<Color> invertedColors = w.q(Color.m5856boximpl(ColorKt.Color(MuxerUtil.UNSIGNED_INT_MAX_VALUE)), Color.m5856boximpl(ColorKt.Color(4293837959L)), Color.m5856boximpl(ColorKt.Color(4292839662L)), Color.m5856boximpl(ColorKt.Color(4294018951L)), Color.m5856boximpl(ColorKt.Color(4287295886L)));

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.statusEditor.StatusEditorViewModel$createImageStatus$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.statusEditor.StatusEditorViewModel$createImageStatus$1", f = "StatusEditorViewModel.kt", l = {97}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class AnonymousClass1 extends cb.m implements Function1 {
        final /* synthetic */ File $imageFile;
        final /* synthetic */ Function1 $onComplete;
        final /* synthetic */ String $textContent;
        int label;

        /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.statusEditor.StatusEditorViewModel$createImageStatus$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        @cb.f(c = "cu.todus.android.uiCompose.main.screen.statusEditor.StatusEditorViewModel$createImageStatus$1$1", f = "StatusEditorViewModel.kt", l = {}, m = "invokeSuspend", v = 2)
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
        public static final class C02531 extends cb.m implements Function2 {
            final /* synthetic */ StatusImageContent $content;
            final /* synthetic */ Function1 $onComplete;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C02531(Function1 function1, StatusImageContent statusImageContent, ab.e<? super C02531> eVar) {
                super(2, eVar);
                this.$onComplete = function1;
                this.$content = statusImageContent;
            }

            @Override // cb.a
            public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
                return new C02531(this.$onComplete, this.$content, eVar);
            }

            @Override // cb.a
            public final Object invokeSuspend(Object obj) {
                bb.b.g();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v.b(obj);
                this.$onComplete.invoke(this.$content);
                return k0.f43947a;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
                return ((C02531) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str, File file, Function1 function1, ab.e<? super AnonymousClass1> eVar) {
            super(1, eVar);
            this.$textContent = str;
            this.$imageFile = file;
            this.$onComplete = function1;
        }

        @Override // cb.a
        public final ab.e<k0> create(ab.e<?> eVar) {
            return StatusEditorViewModel.this.new AnonymousClass1(this.$textContent, this.$imageFile, this.$onComplete, eVar);
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
                StatusRepository statusRepository = StatusEditorViewModel.this.statusRepository;
                String str = this.$textContent;
                File file = this.$imageFile;
                this.label = 1;
                obj = statusRepository.prepareImageStatus(str, file, this);
                if (obj == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v.b(obj);
            }
            pe.k.d(ViewModelKt.getViewModelScope(StatusEditorViewModel.this), d1.c(), null, new C02531(this.$onComplete, (StatusImageContent) obj, null), 2, null);
            return k0.f43947a;
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.statusEditor.StatusEditorViewModel$createVideoStatus$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.statusEditor.StatusEditorViewModel$createVideoStatus$1", f = "StatusEditorViewModel.kt", l = {112}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C13161 extends cb.m implements Function1 {
        final /* synthetic */ Context $context;
        final /* synthetic */ Function1 $onComplete;
        final /* synthetic */ String $textContent;
        final /* synthetic */ File $videoFile;
        int label;

        /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.statusEditor.StatusEditorViewModel$createVideoStatus$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        @cb.f(c = "cu.todus.android.uiCompose.main.screen.statusEditor.StatusEditorViewModel$createVideoStatus$1$1", f = "StatusEditorViewModel.kt", l = {}, m = "invokeSuspend", v = 2)
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
        public static final class C02541 extends cb.m implements Function2 {
            final /* synthetic */ StatusVideoContent $content;
            final /* synthetic */ Function1 $onComplete;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C02541(Function1 function1, StatusVideoContent statusVideoContent, ab.e<? super C02541> eVar) {
                super(2, eVar);
                this.$onComplete = function1;
                this.$content = statusVideoContent;
            }

            @Override // cb.a
            public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
                return new C02541(this.$onComplete, this.$content, eVar);
            }

            @Override // cb.a
            public final Object invokeSuspend(Object obj) {
                bb.b.g();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v.b(obj);
                this.$onComplete.invoke(this.$content);
                return k0.f43947a;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
                return ((C02541) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C13161(Context context, String str, File file, Function1 function1, ab.e<? super C13161> eVar) {
            super(1, eVar);
            this.$context = context;
            this.$textContent = str;
            this.$videoFile = file;
            this.$onComplete = function1;
        }

        @Override // cb.a
        public final ab.e<k0> create(ab.e<?> eVar) {
            return StatusEditorViewModel.this.new C13161(this.$context, this.$textContent, this.$videoFile, this.$onComplete, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super k0> eVar) {
            return ((C13161) create(eVar)).invokeSuspend(k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                v.b(obj);
                StatusRepository statusRepository = StatusEditorViewModel.this.statusRepository;
                Context context = this.$context;
                String str = this.$textContent;
                File file = this.$videoFile;
                this.label = 1;
                obj = statusRepository.prepareVideoStatus(context, str, file, this);
                if (obj == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v.b(obj);
            }
            pe.k.d(ViewModelKt.getViewModelScope(StatusEditorViewModel.this), d1.c(), null, new C02541(this.$onComplete, (StatusVideoContent) obj, null), 2, null);
            return k0.f43947a;
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.statusEditor.StatusEditorViewModel$deleteStatus$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.statusEditor.StatusEditorViewModel$deleteStatus$1", f = "StatusEditorViewModel.kt", l = {WebmConstants.MkvEbmlElement.CUE_POINT}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C13171 extends cb.m implements Function1 {
        final /* synthetic */ String $statusId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C13171(String str, ab.e<? super C13171> eVar) {
            super(1, eVar);
            this.$statusId = str;
        }

        @Override // cb.a
        public final ab.e<k0> create(ab.e<?> eVar) {
            return StatusEditorViewModel.this.new C13171(this.$statusId, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super k0> eVar) {
            return ((C13171) create(eVar)).invokeSuspend(k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                v.b(obj);
                StatusRepository statusRepository = StatusEditorViewModel.this.statusRepository;
                String str = this.$statusId;
                this.label = 1;
                if (statusRepository.prepareToUnpostStatus(str, this) == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v.b(obj);
            }
            return k0.f43947a;
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.statusEditor.StatusEditorViewModel$retrySendStatusesWithError$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.statusEditor.StatusEditorViewModel$retrySendStatusesWithError$1", f = "StatusEditorViewModel.kt", l = {WebmConstants.MkvEbmlElement.SAMPLING_FREQUENCY}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C13181 extends cb.m implements Function1 {
        int label;

        public C13181(ab.e<? super C13181> eVar) {
            super(1, eVar);
        }

        @Override // cb.a
        public final ab.e<k0> create(ab.e<?> eVar) {
            return StatusEditorViewModel.this.new C13181(eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super k0> eVar) {
            return ((C13181) create(eVar)).invokeSuspend(k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                v.b(obj);
                MainRepository mainRepository = StatusEditorViewModel.this.mainRepository;
                this.label = 1;
                if (mainRepository.retryUnsentStatuses(this) == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v.b(obj);
            }
            return k0.f43947a;
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.statusEditor.StatusEditorViewModel$searchForPartner$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.statusEditor.StatusEditorViewModel$searchForPartner$1", f = "StatusEditorViewModel.kt", l = {145, 147}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C13191 extends cb.m implements Function1 {
        final /* synthetic */ String $toDusId;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C13191(String str, ab.e<? super C13191> eVar) {
            super(1, eVar);
            this.$toDusId = str;
        }

        @Override // cb.a
        public final ab.e<k0> create(ab.e<?> eVar) {
            return StatusEditorViewModel.this.new C13191(this.$toDusId, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super k0> eVar) {
            return ((C13191) create(eVar)).invokeSuspend(k0.f43947a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:16:0x0063, code lost:
        
            if (r5 == r0) goto L17;
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
                if (r1 == 0) goto L22
                if (r1 == r3) goto L1e
                if (r1 != r2) goto L16
                java.lang.Object r0 = r4.L$0
                cu.todus.android.data.db.entity.toDus.User r0 = (cu.todus.android.data.db.entity.toDus.User) r0
                ua.v.b(r5)
                goto L66
            L16:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r0)
                throw r5
            L1e:
                ua.v.b(r5)
                goto L45
            L22:
                ua.v.b(r5)
                cu.todus.android.uiCompose.main.screen.statusEditor.StatusEditorViewModel r5 = cu.todus.android.uiCompose.main.screen.statusEditor.StatusEditorViewModel.this
                te.b0 r5 = cu.todus.android.uiCompose.main.screen.statusEditor.StatusEditorViewModel.access$get_requestingPartner$p(r5)
                cu.todus.android.data.wrapper.FlowsState$Companion r1 = cu.todus.android.data.wrapper.FlowsState.INSTANCE
                cu.todus.android.data.wrapper.FlowsState r1 = r1.loading()
                r5.setValue(r1)
                cu.todus.android.uiCompose.main.screen.statusEditor.StatusEditorViewModel r5 = cu.todus.android.uiCompose.main.screen.statusEditor.StatusEditorViewModel.this
                cu.todus.android.repositories.MainRepository r5 = cu.todus.android.uiCompose.main.screen.statusEditor.StatusEditorViewModel.access$getMainRepository$p(r5)
                java.lang.String r1 = r4.$toDusId
                r4.label = r3
                java.lang.Object r5 = r5.reloadUser(r1, r4)
                if (r5 != r0) goto L45
                goto L65
            L45:
                cu.todus.android.data.db.entity.toDus.User r5 = (cu.todus.android.data.db.entity.toDus.User) r5
                if (r5 == 0) goto L8a
                cu.todus.android.uiCompose.main.screen.statusEditor.StatusEditorViewModel r1 = cu.todus.android.uiCompose.main.screen.statusEditor.StatusEditorViewModel.this
                cu.todus.android.repositories.MainRepository r1 = cu.todus.android.uiCompose.main.screen.statusEditor.StatusEditorViewModel.access$getMainRepository$p(r1)
                java.lang.String r3 = r5.getUid()
                te.h r1 = r1.getPartnerByIdFlow(r3)
                java.lang.Object r5 = cb.l.a(r5)
                r4.L$0 = r5
                r4.label = r2
                java.lang.Object r5 = te.j.x(r1, r4)
                if (r5 != r0) goto L66
            L65:
                return r0
            L66:
                cu.todus.android.data.db.pojo.Partner r5 = (cu.todus.android.data.db.pojo.Partner) r5
                if (r5 == 0) goto L7a
                cu.todus.android.uiCompose.main.screen.statusEditor.StatusEditorViewModel r0 = cu.todus.android.uiCompose.main.screen.statusEditor.StatusEditorViewModel.this
                te.b0 r0 = cu.todus.android.uiCompose.main.screen.statusEditor.StatusEditorViewModel.access$get_requestingPartner$p(r0)
                cu.todus.android.data.wrapper.FlowsState$Companion r1 = cu.todus.android.data.wrapper.FlowsState.INSTANCE
                cu.todus.android.data.wrapper.FlowsState r5 = r1.success(r5)
                r0.setValue(r5)
                goto L99
            L7a:
                cu.todus.android.uiCompose.main.screen.statusEditor.StatusEditorViewModel r5 = cu.todus.android.uiCompose.main.screen.statusEditor.StatusEditorViewModel.this
                te.b0 r5 = cu.todus.android.uiCompose.main.screen.statusEditor.StatusEditorViewModel.access$get_requestingPartner$p(r5)
                cu.todus.android.data.wrapper.FlowsState$Companion r0 = cu.todus.android.data.wrapper.FlowsState.INSTANCE
                cu.todus.android.data.wrapper.FlowsState r0 = r0.emptyData()
                r5.setValue(r0)
                goto L99
            L8a:
                cu.todus.android.uiCompose.main.screen.statusEditor.StatusEditorViewModel r5 = cu.todus.android.uiCompose.main.screen.statusEditor.StatusEditorViewModel.this
                te.b0 r5 = cu.todus.android.uiCompose.main.screen.statusEditor.StatusEditorViewModel.access$get_requestingPartner$p(r5)
                cu.todus.android.data.wrapper.FlowsState$Companion r0 = cu.todus.android.data.wrapper.FlowsState.INSTANCE
                cu.todus.android.data.wrapper.FlowsState r0 = r0.emptyData()
                r5.setValue(r0)
            L99:
                ua.k0 r5 = ua.k0.f43947a
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.uiCompose.main.screen.statusEditor.StatusEditorViewModel.C13191.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.statusEditor.StatusEditorViewModel$sendStatus$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.statusEditor.StatusEditorViewModel$sendStatus$1", f = "StatusEditorViewModel.kt", l = {169}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C13201 extends cb.m implements Function1 {
        final /* synthetic */ lb.a $onComplete;
        final /* synthetic */ String $repliedFrom;
        final /* synthetic */ Status $status;
        Object L$0;
        Object L$1;
        int label;

        /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.statusEditor.StatusEditorViewModel$sendStatus$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        @cb.f(c = "cu.todus.android.uiCompose.main.screen.statusEditor.StatusEditorViewModel$sendStatus$1$1", f = "StatusEditorViewModel.kt", l = {}, m = "invokeSuspend", v = 2)
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
        public static final class C02551 extends cb.m implements Function2 {
            final /* synthetic */ lb.a $onComplete;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C02551(lb.a aVar, ab.e<? super C02551> eVar) {
                super(2, eVar);
                this.$onComplete = aVar;
            }

            @Override // cb.a
            public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
                return new C02551(this.$onComplete, eVar);
            }

            @Override // cb.a
            public final Object invokeSuspend(Object obj) {
                bb.b.g();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v.b(obj);
                this.$onComplete.invoke();
                return k0.f43947a;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
                return ((C02551) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C13201(Status status, String str, lb.a aVar, ab.e<? super C13201> eVar) {
            super(1, eVar);
            this.$status = status;
            this.$repliedFrom = str;
            this.$onComplete = aVar;
        }

        @Override // cb.a
        public final ab.e<k0> create(ab.e<?> eVar) {
            return StatusEditorViewModel.this.new C13201(this.$status, this.$repliedFrom, this.$onComplete, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super k0> eVar) {
            return ((C13201) create(eVar)).invokeSuspend(k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Status status;
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                v.b(obj);
                String strBuildId = Status.INSTANCE.buildId(StatusEditorViewModel.this.owner().getNameWithDomain(), this.$status.getContent() instanceof StatusVideoContent);
                Status status2 = this.$status;
                String nameWithDomain = this.$repliedFrom;
                StatusEditorViewModel statusEditorViewModel = StatusEditorViewModel.this;
                if (d0.q0(nameWithDomain)) {
                    nameWithDomain = statusEditorViewModel.owner().getNameWithDomain();
                }
                Status statusCopy$default = Status.copy$default(status2, strBuildId, nameWithDomain, StatusEditorViewModel.this.owner().getNameWithDomain(), 0L, false, false, false, null, null, false, false, null, 0, null, 0, 0, 0, 131064, null);
                StatusRepository statusRepository = StatusEditorViewModel.this.statusRepository;
                this.L$0 = cb.l.a(strBuildId);
                this.L$1 = statusCopy$default;
                this.label = 1;
                if (statusRepository.insertOwnerStatus(statusCopy$default, this) == objG) {
                    return objG;
                }
                status = statusCopy$default;
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                status = (Status) this.L$1;
                v.b(obj);
            }
            StatusEditorViewModel.this.mainRepository.getUploadStatusDataSource().putStatusInUploadQueue(status.getId());
            pe.k.d(ViewModelKt.getViewModelScope(StatusEditorViewModel.this), d1.c(), null, new C02551(this.$onComplete, null), 2, null);
            return k0.f43947a;
        }
    }

    public StatusEditorViewModel() {
        PagingConfig pagingConfig = new PagingConfig(10, 10, true, 20, Integer.MAX_VALUE, 0, 32, null);
        this.statusPagingConfig = pagingConfig;
        this.ownerStatus = CachedPagingDataKt.cachedIn(new Pager(pagingConfig, null, new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.statusEditor.s
            @Override // lb.a
            public final Object invoke() {
                return StatusEditorViewModel.ownerStatus$lambda$0(this.f27699c);
            }
        }, 2, null).getFlow(), ViewModelKt.getViewModelScope(this));
        b0 b0VarA = r0.a(FlowsState.INSTANCE.notRequested());
        this._requestingPartner = b0VarA;
        this.requestingPartner = te.j.b(b0VarA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PagingSource ownerStatus$lambda$0(StatusEditorViewModel statusEditorViewModel) {
        return statusEditorViewModel.statusRepository.ownerStatus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PagingSource partnersForMention$lambda$0(StatusEditorViewModel statusEditorViewModel, String str) {
        return statusEditorViewModel.usersRepository.getAllPartners(str);
    }

    public static /* synthetic */ void sendStatus$default(StatusEditorViewModel statusEditorViewModel, Status status, String str, lb.a aVar, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str = "";
        }
        statusEditorViewModel.sendStatus(status, str, aVar);
    }

    public final void createImageStatus(String textContent, File imageFile, Function1 onComplete) {
        y.i(textContent, "textContent");
        y.i(imageFile, "imageFile");
        y.i(onComplete, "onComplete");
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(textContent, imageFile, onComplete, null), 3, null);
    }

    public final void createTextStatus(String textContent, int fontColor, int backgroundColor, int fontType, Function1 onComplete) {
        y.i(textContent, "textContent");
        y.i(onComplete, "onComplete");
        onComplete.invoke(new StatusTextContent(textContent, fontColor, backgroundColor, fontType));
    }

    public final void createVideoStatus(Context context, String textContent, File videoFile, Function1 onComplete) {
        y.i(context, "context");
        y.i(textContent, "textContent");
        y.i(videoFile, "videoFile");
        y.i(onComplete, "onComplete");
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new C13161(context, textContent, videoFile, onComplete, null), 3, null);
    }

    public final void deleteStatus(String statusId) {
        y.i(statusId, "statusId");
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new C13171(statusId, null), 3, null);
    }

    public final List<Color> getColors() {
        return this.colors;
    }

    public final v5.f getGson() {
        return this.gson;
    }

    public final List<Color> getInvertedColors() {
        return this.invertedColors;
    }

    public final te.h getOwnerStatus() {
        return this.ownerStatus;
    }

    public final p0 getRequestingPartner() {
        return this.requestingPartner;
    }

    public final Owner owner() {
        return (Owner) this.statusRepository.getOwner().invoke();
    }

    public final te.h partnersForMention(final String filter) {
        y.i(filter, "filter");
        final te.h flow = new Pager(this.statusPagingConfig, null, new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.statusEditor.t
            @Override // lb.a
            public final Object invoke() {
                return StatusEditorViewModel.partnersForMention$lambda$0(this.f27700c, filter);
            }
        }, 2, null).getFlow();
        return CachedPagingDataKt.cachedIn(new te.h() { // from class: cu.todus.android.uiCompose.main.screen.statusEditor.StatusEditorViewModel$partnersForMention$$inlined$map$1

            /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.statusEditor.StatusEditorViewModel$partnersForMention$$inlined$map$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
            @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
            public static final class AnonymousClass2<T> implements te.i {
                final /* synthetic */ te.i $this_unsafeFlow;

                /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.statusEditor.StatusEditorViewModel$partnersForMention$$inlined$map$1$2$1, reason: invalid class name */
                @cb.f(c = "cu.todus.android.uiCompose.main.screen.statusEditor.StatusEditorViewModel$partnersForMention$$inlined$map$1$2", f = "StatusEditorViewModel.kt", l = {50}, m = "emit", v = 2)
                @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
                public static final class AnonymousClass1 extends cb.d {
                    int I$0;
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(ab.e eVar) {
                        super(eVar);
                    }

                    @Override // cb.a
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(te.i iVar) {
                    this.$this_unsafeFlow = iVar;
                }

                /* JADX WARN: Code duplicated, block: B:7:0x0013  */
                @Override // te.i
                public final Object emit(Object obj, ab.e eVar) {
                    AnonymousClass1 anonymousClass1;
                    if (eVar instanceof AnonymousClass1) {
                        anonymousClass1 = (AnonymousClass1) eVar;
                        int i10 = anonymousClass1.label;
                        if ((i10 & Integer.MIN_VALUE) != 0) {
                            anonymousClass1.label = i10 - Integer.MIN_VALUE;
                        } else {
                            anonymousClass1 = new AnonymousClass1(eVar);
                        }
                    } else {
                        anonymousClass1 = new AnonymousClass1(eVar);
                    }
                    Object obj2 = anonymousClass1.result;
                    Object objG = bb.b.g();
                    int i11 = anonymousClass1.label;
                    if (i11 == 0) {
                        v.b(obj2);
                        te.i iVar = this.$this_unsafeFlow;
                        PagingData map = PagingDataTransforms__PagingDataTransformsKt.map((PagingData) obj, new StatusEditorViewModel$partnersForMention$2$1(null));
                        anonymousClass1.L$0 = cb.l.a(obj);
                        anonymousClass1.L$1 = cb.l.a(anonymousClass1);
                        anonymousClass1.L$2 = cb.l.a(obj);
                        anonymousClass1.L$3 = cb.l.a(iVar);
                        anonymousClass1.I$0 = 0;
                        anonymousClass1.label = 1;
                        if (iVar.emit(map, anonymousClass1) == objG) {
                            return objG;
                        }
                    } else {
                        if (i11 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        v.b(obj2);
                    }
                    return k0.f43947a;
                }
            }

            @Override // te.h
            public Object collect(te.i iVar, ab.e eVar) {
                Object objCollect = flow.collect(new AnonymousClass2(iVar), eVar);
                return objCollect == bb.b.g() ? objCollect : k0.f43947a;
            }
        }, ViewModelKt.getViewModelScope(this));
    }

    public final void retrySendStatusesWithError() {
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new C13181(null), 3, null);
    }

    public final void searchForPartner(String toDusId) {
        y.i(toDusId, "toDusId");
        if (XMPPUtils.INSTANCE.isUser(toDusId + "@im.todus.cu") || y.d(toDusId, owner().getToDusId())) {
            return;
        }
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new C13191(toDusId, null), 3, null);
    }

    public final void sendStatus(Status status, String repliedFrom, lb.a onComplete) {
        y.i(status, "status");
        y.i(repliedFrom, "repliedFrom");
        y.i(onComplete, "onComplete");
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new C13201(status, repliedFrom, onComplete, null), 3, null);
    }
}
