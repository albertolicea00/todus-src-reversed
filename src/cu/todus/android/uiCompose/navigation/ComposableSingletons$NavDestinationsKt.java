package cu.todus.android.uiCompose.navigation;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.navigation.NavHostController;
import cu.todus.android.uiCompose.auth.screen.register.BigRegisterScreenKt;
import cu.todus.android.uiCompose.auth.screen.register.RegisterScreenKt;
import cu.todus.android.uiCompose.auth.screen.verify.BigVerifyScreenKt;
import cu.todus.android.uiCompose.auth.screen.verify.VerifyScreenKt;
import cu.todus.android.uiCompose.call.screen.call.CallScreenKt;
import cu.todus.android.uiCompose.intentReceiver.screen.presend.PresentScreenKt;
import cu.todus.android.uiCompose.intentReceiver.screen.sendTo.SendToScreenKt;
import cu.todus.android.uiCompose.loading.screen.LoadingScreenKt;
import cu.todus.android.uiCompose.main.screen.about.AboutScreenKt;
import cu.todus.android.uiCompose.main.screen.batteryPreference.BatteryPreferenceScreenKt;
import cu.todus.android.uiCompose.main.screen.batteryPreference.BigBatteryPreferenceScreenKt;
import cu.todus.android.uiCompose.main.screen.catalogue.CatalogueWebScreenKt;
import cu.todus.android.uiCompose.main.screen.catalogue.catalogue.CatalogueScreenKt;
import cu.todus.android.uiCompose.main.screen.catalogue.checkIn.CatalogueCheckInScreenKt;
import cu.todus.android.uiCompose.main.screen.catalogue.form.CatalogueFormScreenKt;
import cu.todus.android.uiCompose.main.screen.catalogue.myCatalogue.MyCatalogueScreenKt;
import cu.todus.android.uiCompose.main.screen.catalogue.preview.ProductPreviewScreenKt;
import cu.todus.android.uiCompose.main.screen.chat.component.card.BigChatCardScreenKt;
import cu.todus.android.uiCompose.main.screen.chat.component.card.ChatCardScreenKt;
import cu.todus.android.uiCompose.main.screen.chat.component.channel.BigChatChannelScreenKt;
import cu.todus.android.uiCompose.main.screen.chat.component.channel.ChatChannelScreenKt;
import cu.todus.android.uiCompose.main.screen.chat.component.group.BigChatGroupScreenKt;
import cu.todus.android.uiCompose.main.screen.chat.component.group.ChatGroupScreenKt;
import cu.todus.android.uiCompose.main.screen.chat.component.p2p.BigChatP2PScreenKt;
import cu.todus.android.uiCompose.main.screen.chat.component.p2p.ChatP2PScreenKt;
import cu.todus.android.uiCompose.main.screen.chatPreview.previewCard.PreviewCardScreenKt;
import cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel.PreviewChannelScreenKt;
import cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel.adminRights.PreviewChannelAdminsScreenKt;
import cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel.subscribers.PreviewSubscribersScreenKt;
import cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.PreviewGroupScreenKt;
import cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.adminRights.PreviewGroupAdminsScreenKt;
import cu.todus.android.uiCompose.main.screen.chatPreview.previewP2P.PreviewP2PScreenKt;
import cu.todus.android.uiCompose.main.screen.chatResources.ChatResourcesScreenKt;
import cu.todus.android.uiCompose.main.screen.contactsPermission.ContactsPermissionScreenKt;
import cu.todus.android.uiCompose.main.screen.createChannel.CreateChannelScreenKt;
import cu.todus.android.uiCompose.main.screen.createGroup.CreateGroupStep1SelectionScreenKt;
import cu.todus.android.uiCompose.main.screen.createGroup.CreateGroupStep2ConfigurationScreenKt;
import cu.todus.android.uiCompose.main.screen.dataPreferences.DataPreferencesScreenKt;
import cu.todus.android.uiCompose.main.screen.dateEditor.DateEditorScreenKt;
import cu.todus.android.uiCompose.main.screen.editProfile.EditProfileScreenKt;
import cu.todus.android.uiCompose.main.screen.editToDusId.EditToDusIdScreenKt;
import cu.todus.android.uiCompose.main.screen.initInfoProfile.BigInitInfoProfileScreenKt;
import cu.todus.android.uiCompose.main.screen.initInfoProfile.InitInfoProfileScreenKt;
import cu.todus.android.uiCompose.main.screen.joinRoom.JoinRoomScreenKt;
import cu.todus.android.uiCompose.main.screen.linkedDevice.LinkedDeviceScreenKt;
import cu.todus.android.uiCompose.main.screen.logout.LogoutScreenKt;
import cu.todus.android.uiCompose.main.screen.manageBackup.ManageBackupScreenKt;
import cu.todus.android.uiCompose.main.screen.manageStickers.ManageStickersScreenKt;
import cu.todus.android.uiCompose.main.screen.map.MapScreenKt;
import cu.todus.android.uiCompose.main.screen.nearPeople.NearPeopleScreenKt;
import cu.todus.android.uiCompose.main.screen.news.NewsScreenKt;
import cu.todus.android.uiCompose.main.screen.privacy.PrivacyScreenKt;
import cu.todus.android.uiCompose.main.screen.pubEditor.PublicationEditorScreenKt;
import cu.todus.android.uiCompose.main.screen.qrReader.QrReaderScreenKt;
import cu.todus.android.uiCompose.main.screen.qrViewer.QrViewerScreenKt;
import cu.todus.android.uiCompose.main.screen.reactSelection.ReactionsSelectionScreenKt;
import cu.todus.android.uiCompose.main.screen.rooms.home.BigHomeScreenKt;
import cu.todus.android.uiCompose.main.screen.rooms.home.HomeScreenKt;
import cu.todus.android.uiCompose.main.screen.rooms.muted.MutedRoomsScreenKt;
import cu.todus.android.uiCompose.main.screen.rooms.request.RequestRoomsScreenKt;
import cu.todus.android.uiCompose.main.screen.rooms.secret.SecretRoomsScreenKt;
import cu.todus.android.uiCompose.main.screen.search.SearchScreenKt;
import cu.todus.android.uiCompose.main.screen.searchUser.SearchUserScreenKt;
import cu.todus.android.uiCompose.main.screen.secretRoomsAccess.SecretRoomAccessKt;
import cu.todus.android.uiCompose.main.screen.setting.BigSettingScreenKt;
import cu.todus.android.uiCompose.main.screen.setting.SettingScreenKt;
import cu.todus.android.uiCompose.main.screen.socialProfile.SocialProfileScreenKt;
import cu.todus.android.uiCompose.main.screen.statusEditor.StatusEditorScreenKt;
import cu.todus.android.uiCompose.main.screen.statusList.StatusListScreenKt;
import cu.todus.android.uiCompose.main.screen.statusPreview.StatusPreviewScreenKt;
import cu.todus.android.uiCompose.main.screen.themeSelector.ThemeSelectorScreenKt;
import cu.todus.android.uiCompose.main.screen.usersDisplay.blocked.BlockedScreenKt;
import cu.todus.android.uiCompose.main.screen.usersDisplay.forwardTo.ForwardToScreenKt;
import cu.todus.android.uiCompose.main.screen.usersDisplay.openWith.OpenWithScreenKt;
import cu.todus.android.uiCompose.navigation.ComposableSingletons$NavDestinationsKt;
import cu.todus.android.uiCompose.start.screen.firstOpen.BigFirstOpenScreensKt;
import cu.todus.android.uiCompose.start.screen.firstOpen.FirstOpenScreensKt;
import cu.todus.android.uiCompose.start.screen.welcome.BigWelcomeScreenKt;
import cu.todus.android.uiCompose.start.screen.welcome.WelcomeScreenKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.y;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
public final class ComposableSingletons$NavDestinationsKt {
    public static final ComposableSingletons$NavDestinationsKt INSTANCE = new ComposableSingletons$NavDestinationsKt();

    /* JADX INFO: renamed from: lambda$-2075210816, reason: not valid java name */
    private static Function2 f319lambda$2075210816 = ComposableLambdaKt.composableLambdaInstance(-2075210816, false, new Function2() { // from class: k8.a
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$NavDestinationsKt.lambda__2075210816$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-1335914194, reason: not valid java name */
    private static Function2 f289lambda$1335914194 = ComposableLambdaKt.composableLambdaInstance(-1335914194, false, new Function2() { // from class: k8.r1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$NavDestinationsKt.lambda__1335914194$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-1569580744, reason: not valid java name */
    private static Function2 f300lambda$1569580744 = ComposableLambdaKt.composableLambdaInstance(-1569580744, false, new Function2() { // from class: k8.d2
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$NavDestinationsKt.lambda__1569580744$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2 lambda$224869158 = ComposableLambdaKt.composableLambdaInstance(224869158, false, new Function2() { // from class: k8.p2
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$NavDestinationsKt.lambda_224869158$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2 lambda$1250327253 = ComposableLambdaKt.composableLambdaInstance(1250327253, false, new Function2() { // from class: k8.b3
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$NavDestinationsKt.lambda_1250327253$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2 lambda$1135628199 = ComposableLambdaKt.composableLambdaInstance(1135628199, false, new Function2() { // from class: k8.n3
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$NavDestinationsKt.lambda_1135628199$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-33817025, reason: not valid java name */
    private static Function2 f325lambda$33817025 = ComposableLambdaKt.composableLambdaInstance(-33817025, false, new Function2() { // from class: k8.z3
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$NavDestinationsKt.lambda__33817025$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2 lambda$1409541777 = ComposableLambdaKt.composableLambdaInstance(1409541777, false, new Function2() { // from class: k8.k
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$NavDestinationsKt.lambda_1409541777$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-1238164812, reason: not valid java name */
    private static Function2 f286lambda$1238164812 = ComposableLambdaKt.composableLambdaInstance(-1238164812, false, new Function2() { // from class: k8.x
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$NavDestinationsKt.lambda__1238164812$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-498868190, reason: not valid java name */
    private static Function2 f333lambda$498868190 = ComposableLambdaKt.composableLambdaInstance(-498868190, false, new Function2() { // from class: k8.j0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$NavDestinationsKt.lambda__498868190$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-1993150299, reason: not valid java name */
    private static Function2 f316lambda$1993150299 = ComposableLambdaKt.composableLambdaInstance(-1993150299, false, new Function2() { // from class: k8.w
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$NavDestinationsKt.lambda__1993150299$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-198700397, reason: not valid java name */
    private static Function2 f314lambda$198700397 = ComposableLambdaKt.composableLambdaInstance(-198700397, false, new Function2() { // from class: k8.u0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$NavDestinationsKt.lambda__198700397$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2 lambda$1652674281 = ComposableLambdaKt.composableLambdaInstance(1652674281, false, new Function2() { // from class: k8.g1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$NavDestinationsKt.lambda_1652674281$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-457822889, reason: not valid java name */
    private static Function2 f330lambda$457822889 = ComposableLambdaKt.composableLambdaInstance(-457822889, false, new Function2() { // from class: k8.j1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$NavDestinationsKt.lambda__457822889$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-746183516, reason: not valid java name */
    private static Function2 f341lambda$746183516 = ComposableLambdaKt.composableLambdaInstance(-746183516, false, new Function2() { // from class: k8.k1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$NavDestinationsKt.lambda__746183516$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2 lambda$697175286 = ComposableLambdaKt.composableLambdaInstance(697175286, false, new Function2() { // from class: k8.l1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$NavDestinationsKt.lambda_697175286$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2 lambda$429630921 = ComposableLambdaKt.composableLambdaInstance(429630921, false, new Function2() { // from class: k8.m1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$NavDestinationsKt.lambda_429630921$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-1803608777, reason: not valid java name */
    private static Function2 f307lambda$1803608777 = ComposableLambdaKt.composableLambdaInstance(-1803608777, false, new Function2() { // from class: k8.o1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$NavDestinationsKt.lambda__1803608777$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-441360405, reason: not valid java name */
    private static Function2 f329lambda$441360405 = ComposableLambdaKt.composableLambdaInstance(-441360405, false, new Function2() { // from class: k8.p1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$NavDestinationsKt.lambda__441360405$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-1442263235, reason: not valid java name */
    private static Function2 f295lambda$1442263235 = ComposableLambdaKt.composableLambdaInstance(-1442263235, false, new Function2() { // from class: k8.q1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$NavDestinationsKt.lambda__1442263235$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2 lambda$1764502330 = ComposableLambdaKt.composableLambdaInstance(1764502330, false, new Function2() { // from class: k8.s1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$NavDestinationsKt.lambda_1764502330$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-211495000, reason: not valid java name */
    private static Function2 f321lambda$211495000 = ComposableLambdaKt.composableLambdaInstance(-211495000, false, new Function2() { // from class: k8.t1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$NavDestinationsKt.lambda__211495000$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2 lambda$1894144076 = ComposableLambdaKt.composableLambdaInstance(1894144076, false, new Function2() { // from class: k8.u1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$NavDestinationsKt.lambda_1894144076$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-957464418, reason: not valid java name */
    private static Function2 f351lambda$957464418 = ComposableLambdaKt.composableLambdaInstance(-957464418, false, new Function2() { // from class: k8.v1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$NavDestinationsKt.lambda__957464418$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-1988264126, reason: not valid java name */
    private static Function2 f315lambda$1988264126 = ComposableLambdaKt.composableLambdaInstance(-1988264126, false, new Function2() { // from class: k8.w1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$NavDestinationsKt.lambda__1988264126$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2 lambda$2100075284 = ComposableLambdaKt.composableLambdaInstance(2100075284, false, new Function2() { // from class: k8.x1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$NavDestinationsKt.lambda_2100075284$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2 lambda$1770541526 = ComposableLambdaKt.composableLambdaInstance(1770541526, false, new Function2() { // from class: k8.z1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$NavDestinationsKt.lambda_1770541526$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-339955644, reason: not valid java name */
    private static Function2 f326lambda$339955644 = ComposableLambdaKt.composableLambdaInstance(-339955644, false, new Function2() { // from class: k8.a2
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$NavDestinationsKt.lambda__339955644$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2 lambda$831717883 = ComposableLambdaKt.composableLambdaInstance(831717883, false, new Function2() { // from class: k8.b2
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$NavDestinationsKt.lambda_831717883$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-294657203, reason: not valid java name */
    private static Function2 f324lambda$294657203 = ComposableLambdaKt.composableLambdaInstance(-294657203, false, new Function2() { // from class: k8.c2
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$NavDestinationsKt.lambda__294657203$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2 lambda$1883123518 = ComposableLambdaKt.composableLambdaInstance(1883123518, false, new Function2() { // from class: k8.e2
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$NavDestinationsKt.lambda_1883123518$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-617393876, reason: not valid java name */
    private static Function2 f336lambda$617393876 = ComposableLambdaKt.composableLambdaInstance(-617393876, false, new Function2() { // from class: k8.f2
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$NavDestinationsKt.lambda__617393876$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-1284085325, reason: not valid java name */
    private static Function2 f287lambda$1284085325 = ComposableLambdaKt.composableLambdaInstance(-1284085325, false, new Function2() { // from class: k8.g2
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$NavDestinationsKt.lambda__1284085325$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2 lambda$2009979141 = ComposableLambdaKt.composableLambdaInstance(2009979141, false, new Function2() { // from class: k8.h2
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$NavDestinationsKt.lambda_2009979141$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2 lambda$164314231 = ComposableLambdaKt.composableLambdaInstance(164314231, false, new Function2() { // from class: k8.i2
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$NavDestinationsKt.lambda_164314231$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2 lambda$369368905 = ComposableLambdaKt.composableLambdaInstance(369368905, false, new Function2() { // from class: k8.k2
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$NavDestinationsKt.lambda_369368905$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2 lambda$2126860827 = ComposableLambdaKt.composableLambdaInstance(2126860827, false, new Function2() { // from class: k8.l2
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$NavDestinationsKt.lambda_2126860827$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2 lambda$640241517 = ComposableLambdaKt.composableLambdaInstance(640241517, false, new Function2() { // from class: k8.m2
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$NavDestinationsKt.lambda_640241517$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2 lambda$858660503 = ComposableLambdaKt.composableLambdaInstance(858660503, false, new Function2() { // from class: k8.n2
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$NavDestinationsKt.lambda_858660503$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2 lambda$652032617 = ComposableLambdaKt.composableLambdaInstance(652032617, false, new Function2() { // from class: k8.o2
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$NavDestinationsKt.lambda_652032617$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-961740792, reason: not valid java name */
    private static Function2 f352lambda$961740792 = ComposableLambdaKt.composableLambdaInstance(-961740792, false, new Function2() { // from class: k8.q2
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$NavDestinationsKt.lambda__961740792$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-1960016394, reason: not valid java name */
    private static Function2 f310lambda$1960016394 = ComposableLambdaKt.composableLambdaInstance(-1960016394, false, new Function2() { // from class: k8.r2
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$NavDestinationsKt.lambda__1960016394$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2 lambda$607555089 = ComposableLambdaKt.composableLambdaInstance(607555089, false, new Function2() { // from class: k8.s2
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$NavDestinationsKt.lambda_607555089$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-259691265, reason: not valid java name */
    private static Function2 f322lambda$259691265 = ComposableLambdaKt.composableLambdaInstance(-259691265, false, new Function2() { // from class: k8.t2
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$NavDestinationsKt.lambda__259691265$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-790759999, reason: not valid java name */
    private static Function2 f342lambda$790759999 = ComposableLambdaKt.composableLambdaInstance(-790759999, false, new Function2() { // from class: k8.v2
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$NavDestinationsKt.lambda__790759999$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2 lambda$652598803 = ComposableLambdaKt.composableLambdaInstance(652598803, false, new Function2() { // from class: k8.w2
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$NavDestinationsKt.lambda_652598803$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-1468180859, reason: not valid java name */
    private static Function2 f296lambda$1468180859 = ComposableLambdaKt.composableLambdaInstance(-1468180859, false, new Function2() { // from class: k8.x2
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$NavDestinationsKt.lambda__1468180859$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2 lambda$1863569779 = ComposableLambdaKt.composableLambdaInstance(1863569779, false, new Function2() { // from class: k8.y2
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$NavDestinationsKt.lambda_1863569779$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2 lambda$1906438752 = ComposableLambdaKt.composableLambdaInstance(1906438752, false, new Function2() { // from class: k8.z2
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$NavDestinationsKt.lambda_1906438752$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-945169742, reason: not valid java name */
    private static Function2 f349lambda$945169742 = ComposableLambdaKt.composableLambdaInstance(-945169742, false, new Function2() { // from class: k8.a3
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$NavDestinationsKt.lambda__945169742$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-864430289, reason: not valid java name */
    private static Function2 f346lambda$864430289 = ComposableLambdaKt.composableLambdaInstance(-864430289, false, new Function2() { // from class: k8.c3
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$NavDestinationsKt.lambda__864430289$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2 lambda$578928513 = ComposableLambdaKt.composableLambdaInstance(578928513, false, new Function2() { // from class: k8.d3
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$NavDestinationsKt.lambda_578928513$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2 lambda$2144123770 = ComposableLambdaKt.composableLambdaInstance(2144123770, false, new Function2() { // from class: k8.e3
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$NavDestinationsKt.lambda_2144123770$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2 lambda$1180907112 = ComposableLambdaKt.composableLambdaInstance(1180907112, false, new Function2() { // from class: k8.g3
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$NavDestinationsKt.lambda_1180907112$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-293894906, reason: not valid java name */
    private static Function2 f323lambda$293894906 = ComposableLambdaKt.composableLambdaInstance(-293894906, false, new Function2() { // from class: k8.h3
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$NavDestinationsKt.lambda__293894906$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2 lambda$1890575220 = ComposableLambdaKt.composableLambdaInstance(1890575220, false, new Function2() { // from class: k8.i3
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$NavDestinationsKt.lambda_1890575220$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2 lambda$1894107019 = ComposableLambdaKt.composableLambdaInstance(1894107019, false, new Function2() { // from class: k8.j3
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$NavDestinationsKt.lambda_1894107019$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2 lambda$1383153117 = ComposableLambdaKt.composableLambdaInstance(1383153117, false, new Function2() { // from class: k8.k3
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$NavDestinationsKt.lambda_1383153117$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-1223802583, reason: not valid java name */
    private static Function2 f285lambda$1223802583 = ComposableLambdaKt.composableLambdaInstance(-1223802583, false, new Function2() { // from class: k8.l3
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$NavDestinationsKt.lambda__1223802583$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-1430430469, reason: not valid java name */
    private static Function2 f293lambda$1430430469 = ComposableLambdaKt.composableLambdaInstance(-1430430469, false, new Function2() { // from class: k8.m3
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$NavDestinationsKt.lambda__1430430469$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-72159414, reason: not valid java name */
    private static Function2 f339lambda$72159414 = ComposableLambdaKt.composableLambdaInstance(-72159414, false, new Function2() { // from class: k8.o3
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$NavDestinationsKt.lambda__72159414$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2 lambda$667137208 = ComposableLambdaKt.composableLambdaInstance(667137208, false, new Function2() { // from class: k8.p3
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$NavDestinationsKt.lambda_667137208$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2 lambda$480738973 = ComposableLambdaKt.composableLambdaInstance(480738973, false, new Function2() { // from class: k8.r3
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$NavDestinationsKt.lambda_480738973$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-1629758197, reason: not valid java name */
    private static Function2 f304lambda$1629758197 = ComposableLambdaKt.composableLambdaInstance(-1629758197, false, new Function2() { // from class: k8.s3
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$NavDestinationsKt.lambda__1629758197$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-953101436, reason: not valid java name */
    private static Function2 f350lambda$953101436 = ComposableLambdaKt.composableLambdaInstance(-953101436, false, new Function2() { // from class: k8.t3
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$NavDestinationsKt.lambda__953101436$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-1067800490, reason: not valid java name */
    private static Function2 f282lambda$1067800490 = ComposableLambdaKt.composableLambdaInstance(-1067800490, false, new Function2() { // from class: k8.u3
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$NavDestinationsKt.lambda__1067800490$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2 lambda$491916876 = ComposableLambdaKt.composableLambdaInstance(491916876, false, new Function2() { // from class: k8.v3
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$NavDestinationsKt.lambda_491916876$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-1741322822, reason: not valid java name */
    private static Function2 f305lambda$1741322822 = ComposableLambdaKt.composableLambdaInstance(-1741322822, false, new Function2() { // from class: k8.w3
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$NavDestinationsKt.lambda__1741322822$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-1091639369, reason: not valid java name */
    private static Function2 f283lambda$1091639369 = ComposableLambdaKt.composableLambdaInstance(-1091639369, false, new Function2() { // from class: k8.x3
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$NavDestinationsKt.lambda__1091639369$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-886584695, reason: not valid java name */
    private static Function2 f347lambda$886584695 = ComposableLambdaKt.composableLambdaInstance(-886584695, false, new Function2() { // from class: k8.y3
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$NavDestinationsKt.lambda__886584695$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-582162177, reason: not valid java name */
    private static Function2 f334lambda$582162177 = ComposableLambdaKt.composableLambdaInstance(-582162177, false, new Function2() { // from class: k8.a4
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$NavDestinationsKt.lambda__582162177$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-1982590255, reason: not valid java name */
    private static Function2 f313lambda$1982590255 = ComposableLambdaKt.composableLambdaInstance(-1982590255, false, new Function2() { // from class: k8.b
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$NavDestinationsKt.lambda__1982590255$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2 lambda$878471912 = ComposableLambdaKt.composableLambdaInstance(878471912, false, new Function2() { // from class: k8.c
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$NavDestinationsKt.lambda_878471912$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-1622045482, reason: not valid java name */
    private static Function2 f303lambda$1622045482 = ComposableLambdaKt.composableLambdaInstance(-1622045482, false, new Function2() { // from class: k8.d
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$NavDestinationsKt.lambda__1622045482$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-1882709325, reason: not valid java name */
    private static Function2 f308lambda$1882709325 = ComposableLambdaKt.composableLambdaInstance(-1882709325, false, new Function2() { // from class: k8.e
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$NavDestinationsKt.lambda__1882709325$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-2089337211, reason: not valid java name */
    private static Function2 f320lambda$2089337211 = ComposableLambdaKt.composableLambdaInstance(-2089337211, false, new Function2() { // from class: k8.f
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$NavDestinationsKt.lambda__2089337211$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2 lambda$553227691 = ComposableLambdaKt.composableLambdaInstance(553227691, false, new Function2() { // from class: k8.g
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$NavDestinationsKt.lambda_553227691$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-4661607, reason: not valid java name */
    private static Function2 f331lambda$4661607 = ComposableLambdaKt.composableLambdaInstance(-4661607, false, new Function2() { // from class: k8.h
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$NavDestinationsKt.lambda__4661607$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-1900002833, reason: not valid java name */
    private static Function2 f309lambda$1900002833 = ComposableLambdaKt.composableLambdaInstance(-1900002833, false, new Function2() { // from class: k8.i
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$NavDestinationsKt.lambda__1900002833$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2 lambda$1268589377 = ComposableLambdaKt.composableLambdaInstance(1268589377, false, new Function2() { // from class: k8.j
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$NavDestinationsKt.lambda_1268589377$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2 lambda$1400720576 = ComposableLambdaKt.composableLambdaInstance(1400720576, false, new Function2() { // from class: k8.m
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$NavDestinationsKt.lambda_1400720576$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2 lambda$889766674 = ComposableLambdaKt.composableLambdaInstance(889766674, false, new Function2() { // from class: k8.n
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$NavDestinationsKt.lambda_889766674$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2 lambda$673186171 = ComposableLambdaKt.composableLambdaInstance(673186171, false, new Function2() { // from class: k8.o
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$NavDestinationsKt.lambda_673186171$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-1437310999, reason: not valid java name */
    private static Function2 f294lambda$1437310999 = ComposableLambdaKt.composableLambdaInstance(-1437310999, false, new Function2() { // from class: k8.p
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$NavDestinationsKt.lambda__1437310999$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-39550485, reason: not valid java name */
    private static Function2 f328lambda$39550485 = ComposableLambdaKt.composableLambdaInstance(-39550485, false, new Function2() { // from class: k8.q
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$NavDestinationsKt.lambda__39550485$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-1002767143, reason: not valid java name */
    private static Function2 f281lambda$1002767143 = ComposableLambdaKt.composableLambdaInstance(-1002767143, false, new Function2() { // from class: k8.r
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$NavDestinationsKt.lambda__1002767143$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-1415345546, reason: not valid java name */
    private static Function2 f292lambda$1415345546 = ComposableLambdaKt.composableLambdaInstance(-1415345546, false, new Function2() { // from class: k8.s
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$NavDestinationsKt.lambda__1415345546$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2 lambda$769124580 = ComposableLambdaKt.composableLambdaInstance(769124580, false, new Function2() { // from class: k8.t
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$NavDestinationsKt.lambda_769124580$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2 lambda$537877511 = ComposableLambdaKt.composableLambdaInstance(537877511, false, new Function2() { // from class: k8.u
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$NavDestinationsKt.lambda_537877511$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-1962639883, reason: not valid java name */
    private static Function2 f311lambda$1962639883 = ComposableLambdaKt.composableLambdaInstance(-1962639883, false, new Function2() { // from class: k8.v
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$NavDestinationsKt.lambda__1962639883$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-1568303307, reason: not valid java name */
    private static Function2 f299lambda$1568303307 = ComposableLambdaKt.composableLambdaInstance(-1568303307, false, new Function2() { // from class: k8.y
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$NavDestinationsKt.lambda__1568303307$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-1363248633, reason: not valid java name */
    private static Function2 f290lambda$1363248633 = ComposableLambdaKt.composableLambdaInstance(-1363248633, false, new Function2() { // from class: k8.z
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$NavDestinationsKt.lambda__1363248633$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2 lambda$893171558 = ComposableLambdaKt.composableLambdaInstance(893171558, false, new Function2() { // from class: k8.a0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$NavDestinationsKt.lambda_893171558$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-70045100, reason: not valid java name */
    private static Function2 f338lambda$70045100 = ComposableLambdaKt.composableLambdaInstance(-70045100, false, new Function2() { // from class: k8.b0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$NavDestinationsKt.lambda__70045100$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-1982112229, reason: not valid java name */
    private static Function2 f312lambda$1982112229 = ComposableLambdaKt.composableLambdaInstance(-1982112229, false, new Function2() { // from class: k8.c0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$NavDestinationsKt.lambda__1982112229$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2 lambda$1311952237 = ComposableLambdaKt.composableLambdaInstance(1311952237, false, new Function2() { // from class: k8.d0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$NavDestinationsKt.lambda_1311952237$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-1405530612, reason: not valid java name */
    private static Function2 f291lambda$1405530612 = ComposableLambdaKt.composableLambdaInstance(-1405530612, false, new Function2() { // from class: k8.e0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$NavDestinationsKt.lambda__1405530612$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-1612158498, reason: not valid java name */
    private static Function2 f302lambda$1612158498 = ComposableLambdaKt.composableLambdaInstance(-1612158498, false, new Function2() { // from class: k8.f0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$NavDestinationsKt.lambda__1612158498$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-2061234458, reason: not valid java name */
    private static Function2 f318lambda$2061234458 = ComposableLambdaKt.composableLambdaInstance(-2061234458, false, new Function2() { // from class: k8.g0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$NavDestinationsKt.lambda__2061234458$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-1321937836, reason: not valid java name */
    private static Function2 f288lambda$1321937836 = ComposableLambdaKt.composableLambdaInstance(-1321937836, false, new Function2() { // from class: k8.i0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$NavDestinationsKt.lambda__1321937836$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-1524770540, reason: not valid java name */
    private static Function2 f297lambda$1524770540 = ComposableLambdaKt.composableLambdaInstance(-1524770540, false, new Function2() { // from class: k8.r0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$NavDestinationsKt.lambda__1524770540$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2 lambda$1806980098 = ComposableLambdaKt.composableLambdaInstance(1806980098, false, new Function2() { // from class: k8.c1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$NavDestinationsKt.lambda_1806980098$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-790774554, reason: not valid java name */
    private static Function2 f343lambda$790774554 = ComposableLambdaKt.composableLambdaInstance(-790774554, false, new Function2() { // from class: k8.n1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$NavDestinationsKt.lambda__790774554$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2 lambda$549523668 = ComposableLambdaKt.composableLambdaInstance(549523668, false, new Function2() { // from class: k8.y1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$NavDestinationsKt.lambda_549523668$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-937712599, reason: not valid java name */
    private static Function2 f348lambda$937712599 = ComposableLambdaKt.composableLambdaInstance(-937712599, false, new Function2() { // from class: k8.j2
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$NavDestinationsKt.lambda__937712599$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-732657925, reason: not valid java name */
    private static Function2 f340lambda$732657925 = ComposableLambdaKt.composableLambdaInstance(-732657925, false, new Function2() { // from class: k8.u2
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$NavDestinationsKt.lambda__732657925$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-628055465, reason: not valid java name */
    private static Function2 f337lambda$628055465 = ComposableLambdaKt.composableLambdaInstance(-628055465, false, new Function2() { // from class: k8.f3
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$NavDestinationsKt.lambda__628055465$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-2028483543, reason: not valid java name */
    private static Function2 f317lambda$2028483543 = ComposableLambdaKt.composableLambdaInstance(-2028483543, false, new Function2() { // from class: k8.q3
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$NavDestinationsKt.lambda__2028483543$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-589823581, reason: not valid java name */
    private static Function2 f335lambda$589823581 = ComposableLambdaKt.composableLambdaInstance(-589823581, false, new Function2() { // from class: k8.b4
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$NavDestinationsKt.lambda__589823581$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-1590726411, reason: not valid java name */
    private static Function2 f301lambda$1590726411 = ComposableLambdaKt.composableLambdaInstance(-1590726411, false, new Function2() { // from class: k8.l
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$NavDestinationsKt.lambda__1590726411$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2 lambda$1540467814 = ComposableLambdaKt.composableLambdaInstance(1540467814, false, new Function2() { // from class: k8.h0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$NavDestinationsKt.lambda_1540467814$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2 lambda$1425768760 = ComposableLambdaKt.composableLambdaInstance(1425768760, false, new Function2() { // from class: k8.k0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$NavDestinationsKt.lambda_1425768760$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2 lambda$109907659 = ComposableLambdaKt.composableLambdaInstance(109907659, false, new Function2() { // from class: k8.l0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$NavDestinationsKt.lambda_109907659$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-853308999, reason: not valid java name */
    private static Function2 f345lambda$853308999 = ComposableLambdaKt.composableLambdaInstance(-853308999, false, new Function2() { // from class: k8.m0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$NavDestinationsKt.lambda__853308999$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2 lambda$492769818 = ComposableLambdaKt.composableLambdaInstance(492769818, false, new Function2() { // from class: k8.n0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$NavDestinationsKt.lambda_492769818$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-470446840, reason: not valid java name */
    private static Function2 f332lambda$470446840 = ComposableLambdaKt.composableLambdaInstance(-470446840, false, new Function2() { // from class: k8.o0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$NavDestinationsKt.lambda__470446840$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-1170692923, reason: not valid java name */
    private static Function2 f284lambda$1170692923 = ComposableLambdaKt.composableLambdaInstance(-1170692923, false, new Function2() { // from class: k8.p0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$NavDestinationsKt.lambda__1170692923$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2 lambda$2123371543 = ComposableLambdaKt.composableLambdaInstance(2123371543, false, new Function2() { // from class: k8.q0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$NavDestinationsKt.lambda_2123371543$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-346924322, reason: not valid java name */
    private static Function2 f327lambda$346924322 = ComposableLambdaKt.composableLambdaInstance(-346924322, false, new Function2() { // from class: k8.s0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$NavDestinationsKt.lambda__346924322$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-1747352400, reason: not valid java name */
    private static Function2 f306lambda$1747352400 = ComposableLambdaKt.composableLambdaInstance(-1747352400, false, new Function2() { // from class: k8.t0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$NavDestinationsKt.lambda__1747352400$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2 lambda$1397909063 = ComposableLambdaKt.composableLambdaInstance(1397909063, false, new Function2() { // from class: k8.v0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$NavDestinationsKt.lambda_1397909063$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2 lambda$397006233 = ComposableLambdaKt.composableLambdaInstance(397006233, false, new Function2() { // from class: k8.w0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$NavDestinationsKt.lambda_397006233$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2 lambda$358414207 = ComposableLambdaKt.composableLambdaInstance(358414207, false, new Function2() { // from class: k8.x0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$NavDestinationsKt.lambda_358414207$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2 lambda$243715153 = ComposableLambdaKt.composableLambdaInstance(243715153, false, new Function2() { // from class: k8.y0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$NavDestinationsKt.lambda_243715153$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2 lambda$2000377498 = ComposableLambdaKt.composableLambdaInstance(2000377498, false, new Function2() { // from class: k8.z0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$NavDestinationsKt.lambda_2000377498$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-1555293176, reason: not valid java name */
    private static Function2 f298lambda$1555293176 = ComposableLambdaKt.composableLambdaInstance(-1555293176, false, new Function2() { // from class: k8.a1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$NavDestinationsKt.lambda__1555293176$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2 lambda$918835609 = ComposableLambdaKt.composableLambdaInstance(918835609, false, new Function2() { // from class: k8.b1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$NavDestinationsKt.lambda_918835609$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2 lambda$1658132231 = ComposableLambdaKt.composableLambdaInstance(1658132231, false, new Function2() { // from class: k8.d1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$NavDestinationsKt.lambda_1658132231$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2 lambda$2019416431 = ComposableLambdaKt.composableLambdaInstance(2019416431, false, new Function2() { // from class: k8.e1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$NavDestinationsKt.lambda_2019416431$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2 lambda$1812788545 = ComposableLambdaKt.composableLambdaInstance(1812788545, false, new Function2() { // from class: k8.f1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$NavDestinationsKt.lambda_1812788545$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2 lambda$320989946 = ComposableLambdaKt.composableLambdaInstance(320989946, false, new Function2() { // from class: k8.h1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$NavDestinationsKt.lambda_320989946$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-805385140, reason: not valid java name */
    private static Function2 f344lambda$805385140 = ComposableLambdaKt.composableLambdaInstance(-805385140, false, new Function2() { // from class: k8.i1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$NavDestinationsKt.lambda__805385140$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 lambda_109907659$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(109907659, i10, -1, "cu.todus.android.uiCompose.navigation.ComposableSingletons$NavDestinationsKt.lambda$109907659.<anonymous> (NavDestinations.kt:1052)");
            }
            NavDestinations.ChatResourcesDest chatResourcesDest = NavDestinations.ChatResourcesDest.INSTANCE;
            Object obj = chatResourcesDest.getArgs()[0];
            y.g(obj, "null cannot be cast to non-null type androidx.navigation.NavHostController");
            Object obj2 = chatResourcesDest.getArgs()[1];
            y.g(obj2, "null cannot be cast to non-null type kotlin.String");
            ChatResourcesScreenKt.ChatResourcesScreen((NavHostController) obj, (String) obj2, null, composer, 0, 4);
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
    public static final k0 lambda_1135628199$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1135628199, i10, -1, "cu.todus.android.uiCompose.navigation.ComposableSingletons$NavDestinationsKt.lambda$1135628199.<anonymous> (NavDestinations.kt:196)");
            }
            Object obj = NavDestinations.VerifyDest.INSTANCE.getArgs()[0];
            y.g(obj, "null cannot be cast to non-null type androidx.navigation.NavHostController");
            BigVerifyScreenKt.BigVerifyScreen((NavHostController) obj, null, composer, 0, 2);
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
    public static final k0 lambda_1180907112$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1180907112, i10, -1, "cu.todus.android.uiCompose.navigation.ComposableSingletons$NavDestinationsKt.lambda$1180907112.<anonymous> (NavDestinations.kt:587)");
            }
            Object obj = NavDestinations.SettingScreenDest.INSTANCE.getArgs()[0];
            y.g(obj, "null cannot be cast to non-null type androidx.navigation.NavHostController");
            BigSettingScreenKt.BigSettingScreen((NavHostController) obj, null, composer, 0, 2);
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
    public static final k0 lambda_1250327253$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1250327253, i10, -1, "cu.todus.android.uiCompose.navigation.ComposableSingletons$NavDestinationsKt.lambda$1250327253.<anonymous> (NavDestinations.kt:191)");
            }
            Object obj = NavDestinations.VerifyDest.INSTANCE.getArgs()[0];
            y.g(obj, "null cannot be cast to non-null type androidx.navigation.NavHostController");
            VerifyScreenKt.VerifyScreen((NavHostController) obj, null, composer, 0, 2);
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
    public static final k0 lambda_1268589377$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1268589377, i10, -1, "cu.todus.android.uiCompose.navigation.ComposableSingletons$NavDestinationsKt.lambda$1268589377.<anonymous> (NavDestinations.kt:788)");
            }
            Object obj = NavDestinations.NewsDest.INSTANCE.getArgs()[0];
            y.g(obj, "null cannot be cast to non-null type androidx.navigation.NavHostController");
            NewsScreenKt.NewsScreen((NavHostController) obj, null, composer, 0, 2);
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
    public static final k0 lambda_1311952237$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1311952237, i10, -1, "cu.todus.android.uiCompose.navigation.ComposableSingletons$NavDestinationsKt.lambda$1311952237.<anonymous> (NavDestinations.kt:917)");
            }
            NavDestinations.StatusEditorDest statusEditorDest = NavDestinations.StatusEditorDest.INSTANCE;
            Object obj = statusEditorDest.getArgs()[0];
            y.g(obj, "null cannot be cast to non-null type androidx.navigation.NavHostController");
            Object obj2 = statusEditorDest.getArgs()[1];
            y.g(obj2, "null cannot be cast to non-null type kotlin.String");
            StatusEditorScreenKt.StatusEditorScreen((NavHostController) obj, (String) obj2, null, composer, 0, 4);
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
    public static final k0 lambda_1383153117$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1383153117, i10, -1, "cu.todus.android.uiCompose.navigation.ComposableSingletons$NavDestinationsKt.lambda$1383153117.<anonymous> (NavDestinations.kt:617)");
            }
            Object obj = NavDestinations.SecretRoomAccessDest.INSTANCE.getArgs()[0];
            y.g(obj, "null cannot be cast to non-null type androidx.navigation.NavHostController");
            SecretRoomAccessKt.SecretRoomAccess((NavHostController) obj, null, composer, 0, 2);
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
    public static final k0 lambda_1397909063$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1397909063, i10, -1, "cu.todus.android.uiCompose.navigation.ComposableSingletons$NavDestinationsKt.lambda$1397909063.<anonymous> (NavDestinations.kt:1116)");
            }
            NavDestinations.CatalogueWebDest catalogueWebDest = NavDestinations.CatalogueWebDest.INSTANCE;
            Object obj = catalogueWebDest.getArgs()[0];
            y.g(obj, "null cannot be cast to non-null type androidx.navigation.NavHostController");
            Object obj2 = catalogueWebDest.getArgs()[1];
            y.g(obj2, "null cannot be cast to non-null type kotlin.String");
            CatalogueWebScreenKt.CatalogueWebScreen((NavHostController) obj, (String) obj2, composer, 0);
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
    public static final k0 lambda_1400720576$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1400720576, i10, -1, "cu.todus.android.uiCompose.navigation.ComposableSingletons$NavDestinationsKt.lambda$1400720576.<anonymous> (NavDestinations.kt:798)");
            }
            NavDestinations.CatalogueCheckInDest catalogueCheckInDest = NavDestinations.CatalogueCheckInDest.INSTANCE;
            Object obj = catalogueCheckInDest.getArgs()[0];
            y.g(obj, "null cannot be cast to non-null type androidx.navigation.NavHostController");
            Object obj2 = catalogueCheckInDest.getArgs()[1];
            y.g(obj2, "null cannot be cast to non-null type kotlin.String");
            CatalogueCheckInScreenKt.CatalogueCheckInScreen((NavHostController) obj, (String) obj2, null, composer, 0, 4);
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
    public static final k0 lambda_1409541777$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1409541777, i10, -1, "cu.todus.android.uiCompose.navigation.ComposableSingletons$NavDestinationsKt.lambda$1409541777.<anonymous> (NavDestinations.kt:211)");
            }
            Object obj = NavDestinations.RegisterDest.INSTANCE.getArgs()[0];
            y.g(obj, "null cannot be cast to non-null type androidx.navigation.NavHostController");
            BigRegisterScreenKt.BigRegisterScreen((NavHostController) obj, null, composer, 0, 2);
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
    public static final k0 lambda_1425768760$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1425768760, i10, -1, "cu.todus.android.uiCompose.navigation.ComposableSingletons$NavDestinationsKt.lambda$1425768760.<anonymous> (NavDestinations.kt:1042)");
            }
            Object obj = NavDestinations.LogoutDest.INSTANCE.getArgs()[0];
            y.g(obj, "null cannot be cast to non-null type androidx.navigation.NavHostController");
            LogoutScreenKt.LogoutScreen((NavHostController) obj, composer, 0);
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
    public static final k0 lambda_1540467814$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1540467814, i10, -1, "cu.todus.android.uiCompose.navigation.ComposableSingletons$NavDestinationsKt.lambda$1540467814.<anonymous> (NavDestinations.kt:1037)");
            }
            Object obj = NavDestinations.LogoutDest.INSTANCE.getArgs()[0];
            y.g(obj, "null cannot be cast to non-null type androidx.navigation.NavHostController");
            LogoutScreenKt.LogoutScreen((NavHostController) obj, composer, 0);
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
    public static final k0 lambda_164314231$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(164314231, i10, -1, "cu.todus.android.uiCompose.navigation.ComposableSingletons$NavDestinationsKt.lambda$164314231.<anonymous> (NavDestinations.kt:433)");
            }
            NavDestinations.PreviewChannelDest previewChannelDest = NavDestinations.PreviewChannelDest.INSTANCE;
            Object obj = previewChannelDest.getArgs()[0];
            y.g(obj, "null cannot be cast to non-null type androidx.navigation.NavHostController");
            Object obj2 = previewChannelDest.getArgs()[1];
            y.g(obj2, "null cannot be cast to non-null type kotlin.String");
            PreviewChannelScreenKt.PreviewChannelScreen((NavHostController) obj, (String) obj2, null, false, composer, 0, 12);
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
    public static final k0 lambda_1652674281$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1652674281, i10, -1, "cu.todus.android.uiCompose.navigation.ComposableSingletons$NavDestinationsKt.lambda$1652674281.<anonymous> (NavDestinations.kt:258)");
            }
            NavDestinations.ChatChannelDest chatChannelDest = NavDestinations.ChatChannelDest.INSTANCE;
            Object obj = chatChannelDest.getArgs()[0];
            y.g(obj, "null cannot be cast to non-null type androidx.navigation.NavHostController");
            Object obj2 = chatChannelDest.getArgs()[1];
            y.g(obj2, "null cannot be cast to non-null type kotlin.String");
            ChatChannelScreenKt.ChatChannelScreen((NavHostController) obj, (String) obj2, null, composer, 0, 4);
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
    public static final k0 lambda_1658132231$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1658132231, i10, -1, "cu.todus.android.uiCompose.navigation.ComposableSingletons$NavDestinationsKt.lambda$1658132231.<anonymous> (NavDestinations.kt:1170)");
            }
            NavDestinations.PresentDest presentDest = NavDestinations.PresentDest.INSTANCE;
            Object obj = presentDest.getArgs()[0];
            y.g(obj, "null cannot be cast to non-null type androidx.navigation.NavHostController");
            Object obj2 = presentDest.getArgs()[1];
            y.g(obj2, "null cannot be cast to non-null type kotlin.String");
            PresentScreenKt.PresentScreen((NavHostController) obj, (String) obj2, null, composer, 0, 4);
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
    public static final k0 lambda_1764502330$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1764502330, i10, -1, "cu.todus.android.uiCompose.navigation.ComposableSingletons$NavDestinationsKt.lambda$1764502330.<anonymous> (NavDestinations.kt:318)");
            }
            NavDestinations.MapDest mapDest = NavDestinations.MapDest.INSTANCE;
            Object obj = mapDest.getArgs()[0];
            y.g(obj, "null cannot be cast to non-null type androidx.navigation.NavHostController");
            Object obj2 = mapDest.getArgs()[1];
            y.g(obj2, "null cannot be cast to non-null type kotlin.String");
            MapScreenKt.MapScreen((NavHostController) obj, (String) obj2, null, composer, 0, 4);
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
    public static final k0 lambda_1770541526$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1770541526, i10, -1, "cu.todus.android.uiCompose.navigation.ComposableSingletons$NavDestinationsKt.lambda$1770541526.<anonymous> (NavDestinations.kt:367)");
            }
            NavDestinations.PreviewCardDest previewCardDest = NavDestinations.PreviewCardDest.INSTANCE;
            Object obj = previewCardDest.getArgs()[0];
            y.g(obj, "null cannot be cast to non-null type androidx.navigation.NavHostController");
            Object obj2 = previewCardDest.getArgs()[1];
            y.g(obj2, "null cannot be cast to non-null type kotlin.String");
            PreviewCardScreenKt.PreviewCardScreen((NavHostController) obj, (String) obj2, null, false, composer, 0, 12);
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
    public static final k0 lambda_1806980098$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1806980098, i10, -1, "cu.todus.android.uiCompose.navigation.ComposableSingletons$NavDestinationsKt.lambda$1806980098.<anonymous> (NavDestinations.kt:964)");
            }
            NavDestinations.StatusPreviewDest statusPreviewDest = NavDestinations.StatusPreviewDest.INSTANCE;
            Object obj = statusPreviewDest.getArgs()[0];
            y.g(obj, "null cannot be cast to non-null type androidx.navigation.NavHostController");
            Object obj2 = statusPreviewDest.getArgs()[1];
            y.g(obj2, "null cannot be cast to non-null type kotlin.String");
            StatusPreviewScreenKt.StatusPreviewScreen((NavHostController) obj, (String) obj2, null, composer, 0, 4);
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
    public static final k0 lambda_1812788545$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1812788545, i10, -1, "cu.todus.android.uiCompose.navigation.ComposableSingletons$NavDestinationsKt.lambda$1812788545.<anonymous> (NavDestinations.kt:1187)");
            }
            NavDestinations.SearchUserDest searchUserDest = NavDestinations.SearchUserDest.INSTANCE;
            Object obj = searchUserDest.getArgs()[0];
            y.g(obj, "null cannot be cast to non-null type androidx.navigation.NavHostController");
            Object obj2 = searchUserDest.getArgs()[1];
            y.g(obj2, "null cannot be cast to non-null type kotlin.String");
            SearchUserScreenKt.SearchUserScreen((NavHostController) obj, (String) obj2, null, composer, 0, 4);
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
    public static final k0 lambda_1863569779$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1863569779, i10, -1, "cu.todus.android.uiCompose.navigation.ComposableSingletons$NavDestinationsKt.lambda$1863569779.<anonymous> (NavDestinations.kt:540)");
            }
            Object obj = NavDestinations.CreateChannelDest.INSTANCE.getArgs()[0];
            y.g(obj, "null cannot be cast to non-null type androidx.navigation.NavHostController");
            CreateChannelScreenKt.CreateChannelScreen((NavHostController) obj, null, composer, 0, 2);
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
    public static final k0 lambda_1883123518$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1883123518, i10, -1, "cu.todus.android.uiCompose.navigation.ComposableSingletons$NavDestinationsKt.lambda$1883123518.<anonymous> (NavDestinations.kt:399)");
            }
            NavDestinations.ForwardToDest forwardToDest = NavDestinations.ForwardToDest.INSTANCE;
            Object obj = forwardToDest.getArgs()[0];
            y.g(obj, "null cannot be cast to non-null type androidx.navigation.NavHostController");
            Object obj2 = forwardToDest.getArgs()[1];
            y.g(obj2, "null cannot be cast to non-null type kotlin.String");
            ForwardToScreenKt.ForwardToScreen((NavHostController) obj, (String) obj2, null, composer, 0, 4);
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
    public static final k0 lambda_1890575220$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1890575220, i10, -1, "cu.todus.android.uiCompose.navigation.ComposableSingletons$NavDestinationsKt.lambda$1890575220.<anonymous> (NavDestinations.kt:602)");
            }
            Object obj = NavDestinations.SecretRoomsDest.INSTANCE.getArgs()[0];
            y.g(obj, "null cannot be cast to non-null type androidx.navigation.NavHostController");
            SecretRoomsScreenKt.SecretRoomsScreen((NavHostController) obj, null, composer, 0, 2);
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
    public static final k0 lambda_1894107019$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1894107019, i10, -1, "cu.todus.android.uiCompose.navigation.ComposableSingletons$NavDestinationsKt.lambda$1894107019.<anonymous> (NavDestinations.kt:612)");
            }
            Object obj = NavDestinations.SecretRoomAccessDest.INSTANCE.getArgs()[0];
            y.g(obj, "null cannot be cast to non-null type androidx.navigation.NavHostController");
            SecretRoomAccessKt.SecretRoomAccess((NavHostController) obj, null, composer, 0, 2);
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
    public static final k0 lambda_1894144076$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1894144076, i10, -1, "cu.todus.android.uiCompose.navigation.ComposableSingletons$NavDestinationsKt.lambda$1894144076.<anonymous> (NavDestinations.kt:335)");
            }
            Object obj = NavDestinations.OpenWithDest.INSTANCE.getArgs()[0];
            y.g(obj, "null cannot be cast to non-null type androidx.navigation.NavHostController");
            OpenWithScreenKt.OpenWithScreen((NavHostController) obj, null, composer, 0, 2);
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
    public static final k0 lambda_1906438752$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1906438752, i10, -1, "cu.todus.android.uiCompose.navigation.ComposableSingletons$NavDestinationsKt.lambda$1906438752.<anonymous> (NavDestinations.kt:550)");
            }
            Object obj = NavDestinations.QrReaderDest.INSTANCE.getArgs()[0];
            y.g(obj, "null cannot be cast to non-null type androidx.navigation.NavHostController");
            QrReaderScreenKt.QrReaderScreen((NavHostController) obj, composer, 0);
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
    public static final k0 lambda_2000377498$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2000377498, i10, -1, "cu.todus.android.uiCompose.navigation.ComposableSingletons$NavDestinationsKt.lambda$2000377498.<anonymous> (NavDestinations.kt:1153)");
            }
            LoadingScreenKt.LoadingScreen(composer, 0);
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
    public static final k0 lambda_2009979141$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2009979141, i10, -1, "cu.todus.android.uiCompose.navigation.ComposableSingletons$NavDestinationsKt.lambda$2009979141.<anonymous> (NavDestinations.kt:422)");
            }
            NavDestinations.PreviewGroupDest previewGroupDest = NavDestinations.PreviewGroupDest.INSTANCE;
            Object obj = previewGroupDest.getArgs()[0];
            y.g(obj, "null cannot be cast to non-null type androidx.navigation.NavHostController");
            Object obj2 = previewGroupDest.getArgs()[1];
            y.g(obj2, "null cannot be cast to non-null type kotlin.String");
            PreviewGroupScreenKt.PreviewGroupScreen((NavHostController) obj, (String) obj2, null, false, composer, 0, 12);
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
    public static final k0 lambda_2019416431$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2019416431, i10, -1, "cu.todus.android.uiCompose.navigation.ComposableSingletons$NavDestinationsKt.lambda$2019416431.<anonymous> (NavDestinations.kt:1181)");
            }
            NavDestinations.SearchUserDest searchUserDest = NavDestinations.SearchUserDest.INSTANCE;
            Object obj = searchUserDest.getArgs()[0];
            y.g(obj, "null cannot be cast to non-null type androidx.navigation.NavHostController");
            Object obj2 = searchUserDest.getArgs()[1];
            y.g(obj2, "null cannot be cast to non-null type kotlin.String");
            SearchUserScreenKt.SearchUserScreen((NavHostController) obj, (String) obj2, null, composer, 0, 4);
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
    public static final k0 lambda_2100075284$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2100075284, i10, -1, "cu.todus.android.uiCompose.navigation.ComposableSingletons$NavDestinationsKt.lambda$2100075284.<anonymous> (NavDestinations.kt:356)");
            }
            NavDestinations.PreviewP2PDest previewP2PDest = NavDestinations.PreviewP2PDest.INSTANCE;
            Object obj = previewP2PDest.getArgs()[0];
            y.g(obj, "null cannot be cast to non-null type androidx.navigation.NavHostController");
            Object obj2 = previewP2PDest.getArgs()[1];
            y.g(obj2, "null cannot be cast to non-null type kotlin.String");
            PreviewP2PScreenKt.PreviewP2PScreen((NavHostController) obj, (String) obj2, null, false, composer, 0, 12);
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
    public static final k0 lambda_2123371543$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2123371543, i10, -1, "cu.todus.android.uiCompose.navigation.ComposableSingletons$NavDestinationsKt.lambda$2123371543.<anonymous> (NavDestinations.kt:1091)");
            }
            Object obj = NavDestinations.RequestRoomsDest.INSTANCE.getArgs()[0];
            y.g(obj, "null cannot be cast to non-null type androidx.navigation.NavHostController");
            RequestRoomsScreenKt.RequestRoomsScreen((NavHostController) obj, null, composer, 0, 2);
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
    public static final k0 lambda_2126860827$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2126860827, i10, -1, "cu.todus.android.uiCompose.navigation.ComposableSingletons$NavDestinationsKt.lambda$2126860827.<anonymous> (NavDestinations.kt:450)");
            }
            NavDestinations.PreviewChannelAdminsDest previewChannelAdminsDest = NavDestinations.PreviewChannelAdminsDest.INSTANCE;
            Object obj = previewChannelAdminsDest.getArgs()[0];
            y.g(obj, "null cannot be cast to non-null type androidx.navigation.NavHostController");
            Object obj2 = previewChannelAdminsDest.getArgs()[1];
            y.g(obj2, "null cannot be cast to non-null type kotlin.String");
            PreviewChannelAdminsScreenKt.PreviewChannelAdminsScreen((NavHostController) obj, (String) obj2, null, composer, 0, 4);
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
    public static final k0 lambda_2144123770$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2144123770, i10, -1, "cu.todus.android.uiCompose.navigation.ComposableSingletons$NavDestinationsKt.lambda$2144123770.<anonymous> (NavDestinations.kt:582)");
            }
            Object obj = NavDestinations.SettingScreenDest.INSTANCE.getArgs()[0];
            y.g(obj, "null cannot be cast to non-null type androidx.navigation.NavHostController");
            SettingScreenKt.SettingScreen((NavHostController) obj, null, composer, 0, 2);
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
    public static final k0 lambda_224869158$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(224869158, i10, -1, "cu.todus.android.uiCompose.navigation.ComposableSingletons$NavDestinationsKt.lambda$224869158.<anonymous> (NavDestinations.kt:179)");
            }
            Object obj = NavDestinations.FirstOpenDest.INSTANCE.getArgs()[0];
            y.g(obj, "null cannot be cast to non-null type androidx.navigation.NavHostController");
            BigFirstOpenScreensKt.BigFirstOpenScreen((NavHostController) obj, composer, 0);
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
    public static final k0 lambda_243715153$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(243715153, i10, -1, "cu.todus.android.uiCompose.navigation.ComposableSingletons$NavDestinationsKt.lambda$243715153.<anonymous> (NavDestinations.kt:1142)");
            }
            NavDestinations.SendToDest sendToDest = NavDestinations.SendToDest.INSTANCE;
            Object obj = sendToDest.getArgs()[0];
            y.g(obj, "null cannot be cast to non-null type androidx.navigation.NavHostController");
            Object obj2 = sendToDest.getArgs()[1];
            y.g(obj2, "null cannot be cast to non-null type kotlin.String");
            SendToScreenKt.SendToScreen((NavHostController) obj, (String) obj2, null, composer, 0, 4);
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
    public static final k0 lambda_320989946$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(320989946, i10, -1, "cu.todus.android.uiCompose.navigation.ComposableSingletons$NavDestinationsKt.lambda$320989946.<anonymous> (NavDestinations.kt:1201)");
            }
            Object obj = NavDestinations.CallDest.INSTANCE.getArgs()[0];
            y.g(obj, "null cannot be cast to non-null type androidx.navigation.NavHostController");
            CallScreenKt.CallScreen((NavHostController) obj, null, composer, 0, 2);
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
    public static final k0 lambda_358414207$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(358414207, i10, -1, "cu.todus.android.uiCompose.navigation.ComposableSingletons$NavDestinationsKt.lambda$358414207.<anonymous> (NavDestinations.kt:1136)");
            }
            NavDestinations.SendToDest sendToDest = NavDestinations.SendToDest.INSTANCE;
            Object obj = sendToDest.getArgs()[0];
            y.g(obj, "null cannot be cast to non-null type androidx.navigation.NavHostController");
            Object obj2 = sendToDest.getArgs()[1];
            y.g(obj2, "null cannot be cast to non-null type kotlin.String");
            SendToScreenKt.SendToScreen((NavHostController) obj, (String) obj2, null, composer, 0, 4);
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
    public static final k0 lambda_369368905$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(369368905, i10, -1, "cu.todus.android.uiCompose.navigation.ComposableSingletons$NavDestinationsKt.lambda$369368905.<anonymous> (NavDestinations.kt:439)");
            }
            NavDestinations.PreviewChannelDest previewChannelDest = NavDestinations.PreviewChannelDest.INSTANCE;
            Object obj = previewChannelDest.getArgs()[0];
            y.g(obj, "null cannot be cast to non-null type androidx.navigation.NavHostController");
            Object obj2 = previewChannelDest.getArgs()[1];
            y.g(obj2, "null cannot be cast to non-null type kotlin.String");
            PreviewChannelScreenKt.PreviewChannelScreen((NavHostController) obj, (String) obj2, null, false, composer, 0, 12);
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
    public static final k0 lambda_397006233$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(397006233, i10, -1, "cu.todus.android.uiCompose.navigation.ComposableSingletons$NavDestinationsKt.lambda$397006233.<anonymous> (NavDestinations.kt:1122)");
            }
            NavDestinations.CatalogueWebDest catalogueWebDest = NavDestinations.CatalogueWebDest.INSTANCE;
            Object obj = catalogueWebDest.getArgs()[0];
            y.g(obj, "null cannot be cast to non-null type androidx.navigation.NavHostController");
            Object obj2 = catalogueWebDest.getArgs()[1];
            y.g(obj2, "null cannot be cast to non-null type kotlin.String");
            CatalogueWebScreenKt.CatalogueWebScreen((NavHostController) obj, (String) obj2, composer, 0);
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
    public static final k0 lambda_429630921$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(429630921, i10, -1, "cu.todus.android.uiCompose.navigation.ComposableSingletons$NavDestinationsKt.lambda$429630921.<anonymous> (NavDestinations.kt:292)");
            }
            InitInfoProfileScreenKt.InitInfoProfileScreen(null, composer, 0, 1);
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
    public static final k0 lambda_480738973$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(480738973, i10, -1, "cu.todus.android.uiCompose.navigation.ComposableSingletons$NavDestinationsKt.lambda$480738973.<anonymous> (NavDestinations.kt:657)");
            }
            Object obj = NavDestinations.EditProfileDest.INSTANCE.getArgs()[0];
            y.g(obj, "null cannot be cast to non-null type androidx.navigation.NavHostController");
            EditProfileScreenKt.EditInfoProfileScreen((NavHostController) obj, null, composer, 0, 2);
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
    public static final k0 lambda_491916876$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(491916876, i10, -1, "cu.todus.android.uiCompose.navigation.ComposableSingletons$NavDestinationsKt.lambda$491916876.<anonymous> (NavDestinations.kt:687)");
            }
            Object obj = NavDestinations.DataPreferencesDest.INSTANCE.getArgs()[0];
            y.g(obj, "null cannot be cast to non-null type androidx.navigation.NavHostController");
            DataPreferencesScreenKt.DataPreferencesScreen((NavHostController) obj, null, composer, 0, 2);
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
    public static final k0 lambda_492769818$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(492769818, i10, -1, "cu.todus.android.uiCompose.navigation.ComposableSingletons$NavDestinationsKt.lambda$492769818.<anonymous> (NavDestinations.kt:1069)");
            }
            NavDestinations.SocialProfileDest socialProfileDest = NavDestinations.SocialProfileDest.INSTANCE;
            Object obj = socialProfileDest.getArgs()[0];
            y.g(obj, "null cannot be cast to non-null type androidx.navigation.NavHostController");
            Object obj2 = socialProfileDest.getArgs()[1];
            y.g(obj2, "null cannot be cast to non-null type kotlin.String");
            SocialProfileScreenKt.SocialProfileScreen((NavHostController) obj, (String) obj2, null, composer, 0, 4);
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
    public static final k0 lambda_537877511$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(537877511, i10, -1, "cu.todus.android.uiCompose.navigation.ComposableSingletons$NavDestinationsKt.lambda$537877511.<anonymous> (NavDestinations.kt:862)");
            }
            NavDestinations.CatalogueDest catalogueDest = NavDestinations.CatalogueDest.INSTANCE;
            Object obj = catalogueDest.getArgs()[0];
            y.g(obj, "null cannot be cast to non-null type androidx.navigation.NavHostController");
            Object obj2 = catalogueDest.getArgs()[1];
            y.g(obj2, "null cannot be cast to non-null type kotlin.String");
            CatalogueScreenKt.CatalogueScreen((NavHostController) obj, (String) obj2, null, composer, 0, 4);
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
    public static final k0 lambda_549523668$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(549523668, i10, -1, "cu.todus.android.uiCompose.navigation.ComposableSingletons$NavDestinationsKt.lambda$549523668.<anonymous> (NavDestinations.kt:980)");
            }
            Object obj = NavDestinations.BatteryPreferenceDest.INSTANCE.getArgs()[0];
            y.g(obj, "null cannot be cast to non-null type androidx.navigation.NavHostController");
            BigBatteryPreferenceScreenKt.BigBatteryPreferenceScreen((NavHostController) obj, null, composer, 0, 2);
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
    public static final k0 lambda_553227691$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(553227691, i10, -1, "cu.todus.android.uiCompose.navigation.ComposableSingletons$NavDestinationsKt.lambda$553227691.<anonymous> (NavDestinations.kt:768)");
            }
            Object obj = NavDestinations.AboutDest.INSTANCE.getArgs()[0];
            y.g(obj, "null cannot be cast to non-null type androidx.navigation.NavHostController");
            AboutScreenKt.AboutScreen((NavHostController) obj, composer, 0);
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
    public static final k0 lambda_578928513$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(578928513, i10, -1, "cu.todus.android.uiCompose.navigation.ComposableSingletons$NavDestinationsKt.lambda$578928513.<anonymous> (NavDestinations.kt:571)");
            }
            NavDestinations.QrViewerDest qrViewerDest = NavDestinations.QrViewerDest.INSTANCE;
            Object obj = qrViewerDest.getArgs()[0];
            y.g(obj, "null cannot be cast to non-null type androidx.navigation.NavHostController");
            Object obj2 = qrViewerDest.getArgs()[1];
            y.g(obj2, "null cannot be cast to non-null type kotlin.String");
            QrViewerScreenKt.QrViewerScreen((NavHostController) obj, (String) obj2, composer, 0);
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
    public static final k0 lambda_607555089$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(607555089, i10, -1, "cu.todus.android.uiCompose.navigation.ComposableSingletons$NavDestinationsKt.lambda$607555089.<anonymous> (NavDestinations.kt:501)");
            }
            NavDestinations.CreateGroupStep2ConfigurationDest createGroupStep2ConfigurationDest = NavDestinations.CreateGroupStep2ConfigurationDest.INSTANCE;
            Object obj = createGroupStep2ConfigurationDest.getArgs()[0];
            y.g(obj, "null cannot be cast to non-null type androidx.navigation.NavHostController");
            Object obj2 = createGroupStep2ConfigurationDest.getArgs()[1];
            y.g(obj2, "null cannot be cast to non-null type kotlin.String");
            CreateGroupStep2ConfigurationScreenKt.CreateGroupStep2ConfigurationScreen((NavHostController) obj, (String) obj2, null, composer, 0, 4);
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
    public static final k0 lambda_640241517$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(640241517, i10, -1, "cu.todus.android.uiCompose.navigation.ComposableSingletons$NavDestinationsKt.lambda$640241517.<anonymous> (NavDestinations.kt:456)");
            }
            NavDestinations.PreviewChannelAdminsDest previewChannelAdminsDest = NavDestinations.PreviewChannelAdminsDest.INSTANCE;
            Object obj = previewChannelAdminsDest.getArgs()[0];
            y.g(obj, "null cannot be cast to non-null type androidx.navigation.NavHostController");
            Object obj2 = previewChannelAdminsDest.getArgs()[1];
            y.g(obj2, "null cannot be cast to non-null type kotlin.String");
            PreviewChannelAdminsScreenKt.PreviewChannelAdminsScreen((NavHostController) obj, (String) obj2, null, composer, 0, 4);
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
    public static final k0 lambda_652032617$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(652032617, i10, -1, "cu.todus.android.uiCompose.navigation.ComposableSingletons$NavDestinationsKt.lambda$652032617.<anonymous> (NavDestinations.kt:473)");
            }
            NavDestinations.DateEditorDest dateEditorDest = NavDestinations.DateEditorDest.INSTANCE;
            Object obj = dateEditorDest.getArgs()[0];
            y.g(obj, "null cannot be cast to non-null type androidx.navigation.NavHostController");
            Object obj2 = dateEditorDest.getArgs()[1];
            y.g(obj2, "null cannot be cast to non-null type kotlin.String");
            DateEditorScreenKt.DateEditorScreen((NavHostController) obj, (String) obj2, null, composer, 0, 4);
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
    public static final k0 lambda_652598803$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(652598803, i10, -1, "cu.todus.android.uiCompose.navigation.ComposableSingletons$NavDestinationsKt.lambda$652598803.<anonymous> (NavDestinations.kt:524)");
            }
            NavDestinations.JoinRoomDest joinRoomDest = NavDestinations.JoinRoomDest.INSTANCE;
            Object obj = joinRoomDest.getArgs()[0];
            y.g(obj, "null cannot be cast to non-null type androidx.navigation.NavHostController");
            Object obj2 = joinRoomDest.getArgs()[1];
            y.g(obj2, "null cannot be cast to non-null type kotlin.String");
            JoinRoomScreenKt.JoinRoomScreen((NavHostController) obj, (String) obj2, null, composer, 0, 4);
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
    public static final k0 lambda_667137208$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(667137208, i10, -1, "cu.todus.android.uiCompose.navigation.ComposableSingletons$NavDestinationsKt.lambda$667137208.<anonymous> (NavDestinations.kt:647)");
            }
            Object obj = NavDestinations.BlockedDest.INSTANCE.getArgs()[0];
            y.g(obj, "null cannot be cast to non-null type androidx.navigation.NavHostController");
            BlockedScreenKt.BlockedScreen((NavHostController) obj, null, composer, 0, 2);
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
    public static final k0 lambda_673186171$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(673186171, i10, -1, "cu.todus.android.uiCompose.navigation.ComposableSingletons$NavDestinationsKt.lambda$673186171.<anonymous> (NavDestinations.kt:815)");
            }
            Object obj = NavDestinations.MyCatalogueDest.INSTANCE.getArgs()[0];
            y.g(obj, "null cannot be cast to non-null type androidx.navigation.NavHostController");
            MyCatalogueScreenKt.MyCatalogueScreen((NavHostController) obj, null, composer, 0, 2);
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
    public static final k0 lambda_697175286$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(697175286, i10, -1, "cu.todus.android.uiCompose.navigation.ComposableSingletons$NavDestinationsKt.lambda$697175286.<anonymous> (NavDestinations.kt:281)");
            }
            NavDestinations.ChatCardDest chatCardDest = NavDestinations.ChatCardDest.INSTANCE;
            Object obj = chatCardDest.getArgs()[0];
            y.g(obj, "null cannot be cast to non-null type androidx.navigation.NavHostController");
            Object obj2 = chatCardDest.getArgs()[1];
            y.g(obj2, "null cannot be cast to non-null type kotlin.String");
            BigChatCardScreenKt.BigChatCardScreen((NavHostController) obj, (String) obj2, null, composer, 0, 4);
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
    public static final k0 lambda_769124580$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(769124580, i10, -1, "cu.todus.android.uiCompose.navigation.ComposableSingletons$NavDestinationsKt.lambda$769124580.<anonymous> (NavDestinations.kt:852)");
            }
            Object obj = NavDestinations.EditToDusIdDest.INSTANCE.getArgs()[0];
            y.g(obj, "null cannot be cast to non-null type androidx.navigation.NavHostController");
            EditToDusIdScreenKt.EditToDusIdScreen((NavHostController) obj, null, composer, 0, 2);
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
    public static final k0 lambda_831717883$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(831717883, i10, -1, "cu.todus.android.uiCompose.navigation.ComposableSingletons$NavDestinationsKt.lambda$831717883.<anonymous> (NavDestinations.kt:384)");
            }
            Object obj = NavDestinations.HomeDest.INSTANCE.getArgs()[0];
            y.g(obj, "null cannot be cast to non-null type androidx.navigation.NavHostController");
            HomeScreenKt.HomeScreen((NavHostController) obj, null, composer, 0, 2);
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
    public static final k0 lambda_858660503$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(858660503, i10, -1, "cu.todus.android.uiCompose.navigation.ComposableSingletons$NavDestinationsKt.lambda$858660503.<anonymous> (NavDestinations.kt:467)");
            }
            NavDestinations.DateEditorDest dateEditorDest = NavDestinations.DateEditorDest.INSTANCE;
            Object obj = dateEditorDest.getArgs()[0];
            y.g(obj, "null cannot be cast to non-null type androidx.navigation.NavHostController");
            Object obj2 = dateEditorDest.getArgs()[1];
            y.g(obj2, "null cannot be cast to non-null type kotlin.String");
            DateEditorScreenKt.DateEditorScreen((NavHostController) obj, (String) obj2, null, composer, 0, 4);
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
    public static final k0 lambda_878471912$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(878471912, i10, -1, "cu.todus.android.uiCompose.navigation.ComposableSingletons$NavDestinationsKt.lambda$878471912.<anonymous> (NavDestinations.kt:736)");
            }
            NavDestinations.PubEditorDest pubEditorDest = NavDestinations.PubEditorDest.INSTANCE;
            Object obj = pubEditorDest.getArgs()[0];
            y.g(obj, "null cannot be cast to non-null type androidx.navigation.NavHostController");
            Object obj2 = pubEditorDest.getArgs()[1];
            y.g(obj2, "null cannot be cast to non-null type kotlin.String");
            PublicationEditorScreenKt.PubEditorScreen((NavHostController) obj, (String) obj2, null, composer, 0, 4);
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
    public static final k0 lambda_889766674$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(889766674, i10, -1, "cu.todus.android.uiCompose.navigation.ComposableSingletons$NavDestinationsKt.lambda$889766674.<anonymous> (NavDestinations.kt:804)");
            }
            NavDestinations.CatalogueCheckInDest catalogueCheckInDest = NavDestinations.CatalogueCheckInDest.INSTANCE;
            Object obj = catalogueCheckInDest.getArgs()[0];
            y.g(obj, "null cannot be cast to non-null type androidx.navigation.NavHostController");
            Object obj2 = catalogueCheckInDest.getArgs()[1];
            y.g(obj2, "null cannot be cast to non-null type kotlin.String");
            CatalogueCheckInScreenKt.CatalogueCheckInScreen((NavHostController) obj, (String) obj2, null, composer, 0, 4);
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
    public static final k0 lambda_893171558$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(893171558, i10, -1, "cu.todus.android.uiCompose.navigation.ComposableSingletons$NavDestinationsKt.lambda$893171558.<anonymous> (NavDestinations.kt:896)");
            }
            Object obj = NavDestinations.ThemeSelectorDest.INSTANCE.getArgs()[0];
            y.g(obj, "null cannot be cast to non-null type androidx.navigation.NavHostController");
            ThemeSelectorScreenKt.ThemeSelectorScreen((NavHostController) obj, null, composer, 0, 2);
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
    public static final k0 lambda_918835609$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(918835609, i10, -1, "cu.todus.android.uiCompose.navigation.ComposableSingletons$NavDestinationsKt.lambda$918835609.<anonymous> (NavDestinations.kt:1164)");
            }
            NavDestinations.PresentDest presentDest = NavDestinations.PresentDest.INSTANCE;
            Object obj = presentDest.getArgs()[0];
            y.g(obj, "null cannot be cast to non-null type androidx.navigation.NavHostController");
            Object obj2 = presentDest.getArgs()[1];
            y.g(obj2, "null cannot be cast to non-null type kotlin.String");
            PresentScreenKt.PresentScreen((NavHostController) obj, (String) obj2, null, composer, 0, 4);
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
    public static final k0 lambda__1002767143$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1002767143, i10, -1, "cu.todus.android.uiCompose.navigation.ComposableSingletons$NavDestinationsKt.lambda$-1002767143.<anonymous> (NavDestinations.kt:836)");
            }
            NavDestinations.CatalogueFormDest catalogueFormDest = NavDestinations.CatalogueFormDest.INSTANCE;
            Object obj = catalogueFormDest.getArgs()[0];
            y.g(obj, "null cannot be cast to non-null type androidx.navigation.NavHostController");
            Object obj2 = catalogueFormDest.getArgs()[1];
            y.g(obj2, "null cannot be cast to non-null type kotlin.String");
            CatalogueFormScreenKt.CatalogueFormScreen((NavHostController) obj, (String) obj2, null, composer, 0, 4);
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
    public static final k0 lambda__1067800490$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1067800490, i10, -1, "cu.todus.android.uiCompose.navigation.ComposableSingletons$NavDestinationsKt.lambda$-1067800490.<anonymous> (NavDestinations.kt:677)");
            }
            Object obj = NavDestinations.SearchDest.INSTANCE.getArgs()[0];
            y.g(obj, "null cannot be cast to non-null type androidx.navigation.NavHostController");
            SearchScreenKt.SearchScreen((NavHostController) obj, null, composer, 0, 2);
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
    public static final k0 lambda__1091639369$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1091639369, i10, -1, "cu.todus.android.uiCompose.navigation.ComposableSingletons$NavDestinationsKt.lambda$-1091639369.<anonymous> (NavDestinations.kt:702)");
            }
            NavDestinations.ManageStickersDest manageStickersDest = NavDestinations.ManageStickersDest.INSTANCE;
            Object obj = manageStickersDest.getArgs()[0];
            y.g(obj, "null cannot be cast to non-null type androidx.navigation.NavHostController");
            Object obj2 = manageStickersDest.getArgs()[1];
            y.g(obj2, "null cannot be cast to non-null type kotlin.String");
            ManageStickersScreenKt.ManageStickersScreen((NavHostController) obj, (String) obj2, null, composer, 0, 4);
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
    public static final k0 lambda__1170692923$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1170692923, i10, -1, "cu.todus.android.uiCompose.navigation.ComposableSingletons$NavDestinationsKt.lambda$-1170692923.<anonymous> (NavDestinations.kt:1086)");
            }
            Object obj = NavDestinations.RequestRoomsDest.INSTANCE.getArgs()[0];
            y.g(obj, "null cannot be cast to non-null type androidx.navigation.NavHostController");
            RequestRoomsScreenKt.RequestRoomsScreen((NavHostController) obj, null, composer, 0, 2);
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
    public static final k0 lambda__1223802583$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1223802583, i10, -1, "cu.todus.android.uiCompose.navigation.ComposableSingletons$NavDestinationsKt.lambda$-1223802583.<anonymous> (NavDestinations.kt:627)");
            }
            Object obj = NavDestinations.MutedRoomsDest.INSTANCE.getArgs()[0];
            y.g(obj, "null cannot be cast to non-null type androidx.navigation.NavHostController");
            MutedRoomsScreenKt.MutedRoomsScreen((NavHostController) obj, null, composer, 0, 2);
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
    public static final k0 lambda__1238164812$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1238164812, i10, -1, "cu.todus.android.uiCompose.navigation.ComposableSingletons$NavDestinationsKt.lambda$-1238164812.<anonymous> (NavDestinations.kt:224)");
            }
            NavDestinations.ChatP2PDest chatP2PDest = NavDestinations.ChatP2PDest.INSTANCE;
            Object obj = chatP2PDest.getArgs()[0];
            y.g(obj, "null cannot be cast to non-null type androidx.navigation.NavHostController");
            Object obj2 = chatP2PDest.getArgs()[1];
            y.g(obj2, "null cannot be cast to non-null type kotlin.String");
            ChatP2PScreenKt.ChatP2PScreen((NavHostController) obj, (String) obj2, null, composer, 0, 4);
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
    public static final k0 lambda__1284085325$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1284085325, i10, -1, "cu.todus.android.uiCompose.navigation.ComposableSingletons$NavDestinationsKt.lambda$-1284085325.<anonymous> (NavDestinations.kt:416)");
            }
            NavDestinations.PreviewGroupDest previewGroupDest = NavDestinations.PreviewGroupDest.INSTANCE;
            Object obj = previewGroupDest.getArgs()[0];
            y.g(obj, "null cannot be cast to non-null type androidx.navigation.NavHostController");
            Object obj2 = previewGroupDest.getArgs()[1];
            y.g(obj2, "null cannot be cast to non-null type kotlin.String");
            PreviewGroupScreenKt.PreviewGroupScreen((NavHostController) obj, (String) obj2, null, false, composer, 0, 12);
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
    public static final k0 lambda__1321937836$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1321937836, i10, -1, "cu.todus.android.uiCompose.navigation.ComposableSingletons$NavDestinationsKt.lambda$-1321937836.<anonymous> (NavDestinations.kt:948)");
            }
            Object obj = NavDestinations.PrivacyDest.INSTANCE.getArgs()[0];
            y.g(obj, "null cannot be cast to non-null type androidx.navigation.NavHostController");
            PrivacyScreenKt.PrivacyScreen((NavHostController) obj, null, composer, 0, 2);
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
    public static final k0 lambda__1335914194$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1335914194, i10, -1, "cu.todus.android.uiCompose.navigation.ComposableSingletons$NavDestinationsKt.lambda$-1335914194.<anonymous> (NavDestinations.kt:166)");
            }
            BigWelcomeScreenKt.BigWelcomeScreen(null, composer, 0, 1);
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
    public static final k0 lambda__1363248633$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1363248633, i10, -1, "cu.todus.android.uiCompose.navigation.ComposableSingletons$NavDestinationsKt.lambda$-1363248633.<anonymous> (NavDestinations.kt:885)");
            }
            NavDestinations.ProductPreviewDest productPreviewDest = NavDestinations.ProductPreviewDest.INSTANCE;
            Object obj = productPreviewDest.getArgs()[0];
            y.g(obj, "null cannot be cast to non-null type androidx.navigation.NavHostController");
            Object obj2 = productPreviewDest.getArgs()[1];
            y.g(obj2, "null cannot be cast to non-null type kotlin.String");
            ProductPreviewScreenKt.ProductPreviewScreen((NavHostController) obj, (String) obj2, null, composer, 0, 4);
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
    public static final k0 lambda__1405530612$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1405530612, i10, -1, "cu.todus.android.uiCompose.navigation.ComposableSingletons$NavDestinationsKt.lambda$-1405530612.<anonymous> (NavDestinations.kt:928)");
            }
            Object obj = NavDestinations.StatusListDest.INSTANCE.getArgs()[0];
            y.g(obj, "null cannot be cast to non-null type androidx.navigation.NavHostController");
            StatusListScreenKt.StatusListScreen((NavHostController) obj, null, composer, 0, 2);
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
    public static final k0 lambda__1415345546$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1415345546, i10, -1, "cu.todus.android.uiCompose.navigation.ComposableSingletons$NavDestinationsKt.lambda$-1415345546.<anonymous> (NavDestinations.kt:847)");
            }
            Object obj = NavDestinations.EditToDusIdDest.INSTANCE.getArgs()[0];
            y.g(obj, "null cannot be cast to non-null type androidx.navigation.NavHostController");
            EditToDusIdScreenKt.EditToDusIdScreen((NavHostController) obj, null, composer, 0, 2);
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
    public static final k0 lambda__1430430469$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1430430469, i10, -1, "cu.todus.android.uiCompose.navigation.ComposableSingletons$NavDestinationsKt.lambda$-1430430469.<anonymous> (NavDestinations.kt:632)");
            }
            Object obj = NavDestinations.MutedRoomsDest.INSTANCE.getArgs()[0];
            y.g(obj, "null cannot be cast to non-null type androidx.navigation.NavHostController");
            MutedRoomsScreenKt.MutedRoomsScreen((NavHostController) obj, null, composer, 0, 2);
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
    public static final k0 lambda__1437310999$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1437310999, i10, -1, "cu.todus.android.uiCompose.navigation.ComposableSingletons$NavDestinationsKt.lambda$-1437310999.<anonymous> (NavDestinations.kt:820)");
            }
            Object obj = NavDestinations.MyCatalogueDest.INSTANCE.getArgs()[0];
            y.g(obj, "null cannot be cast to non-null type androidx.navigation.NavHostController");
            MyCatalogueScreenKt.MyCatalogueScreen((NavHostController) obj, null, composer, 0, 2);
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
    public static final k0 lambda__1442263235$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1442263235, i10, -1, "cu.todus.android.uiCompose.navigation.ComposableSingletons$NavDestinationsKt.lambda$-1442263235.<anonymous> (NavDestinations.kt:308)");
            }
            Object obj = NavDestinations.LinkedDeviceDest.INSTANCE.getArgs()[0];
            y.g(obj, "null cannot be cast to non-null type androidx.navigation.NavHostController");
            LinkedDeviceScreenKt.LinkedDeviceScreen((NavHostController) obj, null, composer, 0, 2);
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
    public static final k0 lambda__1468180859$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1468180859, i10, -1, "cu.todus.android.uiCompose.navigation.ComposableSingletons$NavDestinationsKt.lambda$-1468180859.<anonymous> (NavDestinations.kt:535)");
            }
            Object obj = NavDestinations.CreateChannelDest.INSTANCE.getArgs()[0];
            y.g(obj, "null cannot be cast to non-null type androidx.navigation.NavHostController");
            CreateChannelScreenKt.CreateChannelScreen((NavHostController) obj, null, composer, 0, 2);
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
    public static final k0 lambda__1524770540$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1524770540, i10, -1, "cu.todus.android.uiCompose.navigation.ComposableSingletons$NavDestinationsKt.lambda$-1524770540.<anonymous> (NavDestinations.kt:958)");
            }
            NavDestinations.StatusPreviewDest statusPreviewDest = NavDestinations.StatusPreviewDest.INSTANCE;
            Object obj = statusPreviewDest.getArgs()[0];
            y.g(obj, "null cannot be cast to non-null type androidx.navigation.NavHostController");
            Object obj2 = statusPreviewDest.getArgs()[1];
            y.g(obj2, "null cannot be cast to non-null type kotlin.String");
            StatusPreviewScreenKt.StatusPreviewScreen((NavHostController) obj, (String) obj2, null, composer, 0, 4);
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
    public static final k0 lambda__1555293176$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1555293176, i10, -1, "cu.todus.android.uiCompose.navigation.ComposableSingletons$NavDestinationsKt.lambda$-1555293176.<anonymous> (NavDestinations.kt:1156)");
            }
            LoadingScreenKt.LoadingScreen(composer, 0);
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
    public static final k0 lambda__1568303307$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1568303307, i10, -1, "cu.todus.android.uiCompose.navigation.ComposableSingletons$NavDestinationsKt.lambda$-1568303307.<anonymous> (NavDestinations.kt:879)");
            }
            NavDestinations.ProductPreviewDest productPreviewDest = NavDestinations.ProductPreviewDest.INSTANCE;
            Object obj = productPreviewDest.getArgs()[0];
            y.g(obj, "null cannot be cast to non-null type androidx.navigation.NavHostController");
            Object obj2 = productPreviewDest.getArgs()[1];
            y.g(obj2, "null cannot be cast to non-null type kotlin.String");
            ProductPreviewScreenKt.ProductPreviewScreen((NavHostController) obj, (String) obj2, null, composer, 0, 4);
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
    public static final k0 lambda__1569580744$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1569580744, i10, -1, "cu.todus.android.uiCompose.navigation.ComposableSingletons$NavDestinationsKt.lambda$-1569580744.<anonymous> (NavDestinations.kt:174)");
            }
            Object obj = NavDestinations.FirstOpenDest.INSTANCE.getArgs()[0];
            y.g(obj, "null cannot be cast to non-null type androidx.navigation.NavHostController");
            FirstOpenScreensKt.FirstOpenScreen((NavHostController) obj, composer, 0);
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
    public static final k0 lambda__1590726411$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1590726411, i10, -1, "cu.todus.android.uiCompose.navigation.ComposableSingletons$NavDestinationsKt.lambda$-1590726411.<anonymous> (NavDestinations.kt:1027)");
            }
            Object obj = NavDestinations.ManageBackupDest.INSTANCE.getArgs()[0];
            y.g(obj, "null cannot be cast to non-null type androidx.navigation.NavHostController");
            ManageBackupScreenKt.ManageBackupScreen((NavHostController) obj, null, composer, 0, 2);
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
    public static final k0 lambda__1612158498$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1612158498, i10, -1, "cu.todus.android.uiCompose.navigation.ComposableSingletons$NavDestinationsKt.lambda$-1612158498.<anonymous> (NavDestinations.kt:933)");
            }
            Object obj = NavDestinations.StatusListDest.INSTANCE.getArgs()[0];
            y.g(obj, "null cannot be cast to non-null type androidx.navigation.NavHostController");
            StatusListScreenKt.StatusListScreen((NavHostController) obj, null, composer, 0, 2);
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
    public static final k0 lambda__1622045482$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1622045482, i10, -1, "cu.todus.android.uiCompose.navigation.ComposableSingletons$NavDestinationsKt.lambda$-1622045482.<anonymous> (NavDestinations.kt:742)");
            }
            NavDestinations.PubEditorDest pubEditorDest = NavDestinations.PubEditorDest.INSTANCE;
            Object obj = pubEditorDest.getArgs()[0];
            y.g(obj, "null cannot be cast to non-null type androidx.navigation.NavHostController");
            Object obj2 = pubEditorDest.getArgs()[1];
            y.g(obj2, "null cannot be cast to non-null type kotlin.String");
            PublicationEditorScreenKt.PubEditorScreen((NavHostController) obj, (String) obj2, null, composer, 0, 4);
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
    public static final k0 lambda__1629758197$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1629758197, i10, -1, "cu.todus.android.uiCompose.navigation.ComposableSingletons$NavDestinationsKt.lambda$-1629758197.<anonymous> (NavDestinations.kt:662)");
            }
            Object obj = NavDestinations.EditProfileDest.INSTANCE.getArgs()[0];
            y.g(obj, "null cannot be cast to non-null type androidx.navigation.NavHostController");
            EditProfileScreenKt.EditInfoProfileScreen((NavHostController) obj, null, composer, 0, 2);
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
    public static final k0 lambda__1741322822$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1741322822, i10, -1, "cu.todus.android.uiCompose.navigation.ComposableSingletons$NavDestinationsKt.lambda$-1741322822.<anonymous> (NavDestinations.kt:692)");
            }
            Object obj = NavDestinations.DataPreferencesDest.INSTANCE.getArgs()[0];
            y.g(obj, "null cannot be cast to non-null type androidx.navigation.NavHostController");
            DataPreferencesScreenKt.DataPreferencesScreen((NavHostController) obj, null, composer, 0, 2);
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
    public static final k0 lambda__1747352400$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1747352400, i10, -1, "cu.todus.android.uiCompose.navigation.ComposableSingletons$NavDestinationsKt.lambda$-1747352400.<anonymous> (NavDestinations.kt:1106)");
            }
            Object obj = NavDestinations.ContactsPermissionDest.INSTANCE.getArgs()[0];
            y.g(obj, "null cannot be cast to non-null type androidx.navigation.NavHostController");
            ContactsPermissionScreenKt.ContactsPermissionsScreen((NavHostController) obj, composer, 0);
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
    public static final k0 lambda__1803608777$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1803608777, i10, -1, "cu.todus.android.uiCompose.navigation.ComposableSingletons$NavDestinationsKt.lambda$-1803608777.<anonymous> (NavDestinations.kt:295)");
            }
            BigInitInfoProfileScreenKt.BigInitInfoProfileScreen(null, composer, 0, 1);
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
    public static final k0 lambda__1882709325$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1882709325, i10, -1, "cu.todus.android.uiCompose.navigation.ComposableSingletons$NavDestinationsKt.lambda$-1882709325.<anonymous> (NavDestinations.kt:753)");
            }
            Object obj = NavDestinations.NearPeopleDest.INSTANCE.getArgs()[0];
            y.g(obj, "null cannot be cast to non-null type androidx.navigation.NavHostController");
            NearPeopleScreenKt.NearPeopleScreen((NavHostController) obj, null, composer, 0, 2);
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
    public static final k0 lambda__1900002833$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1900002833, i10, -1, "cu.todus.android.uiCompose.navigation.ComposableSingletons$NavDestinationsKt.lambda$-1900002833.<anonymous> (NavDestinations.kt:783)");
            }
            Object obj = NavDestinations.NewsDest.INSTANCE.getArgs()[0];
            y.g(obj, "null cannot be cast to non-null type androidx.navigation.NavHostController");
            NewsScreenKt.NewsScreen((NavHostController) obj, null, composer, 0, 2);
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
    public static final k0 lambda__1960016394$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1960016394, i10, -1, "cu.todus.android.uiCompose.navigation.ComposableSingletons$NavDestinationsKt.lambda$-1960016394.<anonymous> (NavDestinations.kt:490)");
            }
            NavDestinations.CreateGroupStep1SelectionDest createGroupStep1SelectionDest = NavDestinations.CreateGroupStep1SelectionDest.INSTANCE;
            Object obj = createGroupStep1SelectionDest.getArgs()[0];
            y.g(obj, "null cannot be cast to non-null type androidx.navigation.NavHostController");
            Object obj2 = createGroupStep1SelectionDest.getArgs()[1];
            y.g(obj2, "null cannot be cast to non-null type kotlin.String");
            CreateGroupStep1SelectionScreenKt.CreateGroupStep1SelectionScreen((NavHostController) obj, (String) obj2, null, composer, 0, 4);
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
    public static final k0 lambda__1962639883$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1962639883, i10, -1, "cu.todus.android.uiCompose.navigation.ComposableSingletons$NavDestinationsKt.lambda$-1962639883.<anonymous> (NavDestinations.kt:868)");
            }
            NavDestinations.CatalogueDest catalogueDest = NavDestinations.CatalogueDest.INSTANCE;
            Object obj = catalogueDest.getArgs()[0];
            y.g(obj, "null cannot be cast to non-null type androidx.navigation.NavHostController");
            Object obj2 = catalogueDest.getArgs()[1];
            y.g(obj2, "null cannot be cast to non-null type kotlin.String");
            CatalogueScreenKt.CatalogueScreen((NavHostController) obj, (String) obj2, null, composer, 0, 4);
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
    public static final k0 lambda__1982112229$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1982112229, i10, -1, "cu.todus.android.uiCompose.navigation.ComposableSingletons$NavDestinationsKt.lambda$-1982112229.<anonymous> (NavDestinations.kt:911)");
            }
            NavDestinations.StatusEditorDest statusEditorDest = NavDestinations.StatusEditorDest.INSTANCE;
            Object obj = statusEditorDest.getArgs()[0];
            y.g(obj, "null cannot be cast to non-null type androidx.navigation.NavHostController");
            Object obj2 = statusEditorDest.getArgs()[1];
            y.g(obj2, "null cannot be cast to non-null type kotlin.String");
            StatusEditorScreenKt.StatusEditorScreen((NavHostController) obj, (String) obj2, null, composer, 0, 4);
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
    public static final k0 lambda__1982590255$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1982590255, i10, -1, "cu.todus.android.uiCompose.navigation.ComposableSingletons$NavDestinationsKt.lambda$-1982590255.<anonymous> (NavDestinations.kt:725)");
            }
            NavDestinations.PreviewSubscribersDest previewSubscribersDest = NavDestinations.PreviewSubscribersDest.INSTANCE;
            Object obj = previewSubscribersDest.getArgs()[0];
            y.g(obj, "null cannot be cast to non-null type androidx.navigation.NavHostController");
            Object obj2 = previewSubscribersDest.getArgs()[1];
            y.g(obj2, "null cannot be cast to non-null type kotlin.String");
            PreviewSubscribersScreenKt.PreviewSubscribersScreen((NavHostController) obj, (String) obj2, null, composer, 0, 4);
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
    public static final k0 lambda__198700397$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-198700397, i10, -1, "cu.todus.android.uiCompose.navigation.ComposableSingletons$NavDestinationsKt.lambda$-198700397.<anonymous> (NavDestinations.kt:247)");
            }
            NavDestinations.ChatGroupDest chatGroupDest = NavDestinations.ChatGroupDest.INSTANCE;
            Object obj = chatGroupDest.getArgs()[0];
            y.g(obj, "null cannot be cast to non-null type androidx.navigation.NavHostController");
            Object obj2 = chatGroupDest.getArgs()[1];
            y.g(obj2, "null cannot be cast to non-null type kotlin.String");
            BigChatGroupScreenKt.BigChatGroupScreen((NavHostController) obj, (String) obj2, null, composer, 0, 4);
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
    public static final k0 lambda__1988264126$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1988264126, i10, -1, "cu.todus.android.uiCompose.navigation.ComposableSingletons$NavDestinationsKt.lambda$-1988264126.<anonymous> (NavDestinations.kt:350)");
            }
            NavDestinations.PreviewP2PDest previewP2PDest = NavDestinations.PreviewP2PDest.INSTANCE;
            Object obj = previewP2PDest.getArgs()[0];
            y.g(obj, "null cannot be cast to non-null type androidx.navigation.NavHostController");
            Object obj2 = previewP2PDest.getArgs()[1];
            y.g(obj2, "null cannot be cast to non-null type kotlin.String");
            PreviewP2PScreenKt.PreviewP2PScreen((NavHostController) obj, (String) obj2, null, false, composer, 0, 12);
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
    public static final k0 lambda__1993150299$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1993150299, i10, -1, "cu.todus.android.uiCompose.navigation.ComposableSingletons$NavDestinationsKt.lambda$-1993150299.<anonymous> (NavDestinations.kt:241)");
            }
            NavDestinations.ChatGroupDest chatGroupDest = NavDestinations.ChatGroupDest.INSTANCE;
            Object obj = chatGroupDest.getArgs()[0];
            y.g(obj, "null cannot be cast to non-null type androidx.navigation.NavHostController");
            Object obj2 = chatGroupDest.getArgs()[1];
            y.g(obj2, "null cannot be cast to non-null type kotlin.String");
            ChatGroupScreenKt.ChatGroupScreen((NavHostController) obj, (String) obj2, null, composer, 0, 4);
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
    public static final k0 lambda__2028483543$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2028483543, i10, -1, "cu.todus.android.uiCompose.navigation.ComposableSingletons$NavDestinationsKt.lambda$-2028483543.<anonymous> (NavDestinations.kt:1011)");
            }
            NavDestinations.PreviewGroupAdminsDest previewGroupAdminsDest = NavDestinations.PreviewGroupAdminsDest.INSTANCE;
            Object obj = previewGroupAdminsDest.getArgs()[0];
            y.g(obj, "null cannot be cast to non-null type androidx.navigation.NavHostController");
            Object obj2 = previewGroupAdminsDest.getArgs()[1];
            y.g(obj2, "null cannot be cast to non-null type kotlin.String");
            PreviewGroupAdminsScreenKt.PreviewGroupAdminsScreen((NavHostController) obj, (String) obj2, null, composer, 0, 4);
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
    public static final k0 lambda__2061234458$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2061234458, i10, -1, "cu.todus.android.uiCompose.navigation.ComposableSingletons$NavDestinationsKt.lambda$-2061234458.<anonymous> (NavDestinations.kt:943)");
            }
            Object obj = NavDestinations.PrivacyDest.INSTANCE.getArgs()[0];
            y.g(obj, "null cannot be cast to non-null type androidx.navigation.NavHostController");
            PrivacyScreenKt.PrivacyScreen((NavHostController) obj, null, composer, 0, 2);
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
    public static final k0 lambda__2075210816$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2075210816, i10, -1, "cu.todus.android.uiCompose.navigation.ComposableSingletons$NavDestinationsKt.lambda$-2075210816.<anonymous> (NavDestinations.kt:163)");
            }
            WelcomeScreenKt.WelcomeScreen(null, composer, 0, 1);
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
    public static final k0 lambda__2089337211$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2089337211, i10, -1, "cu.todus.android.uiCompose.navigation.ComposableSingletons$NavDestinationsKt.lambda$-2089337211.<anonymous> (NavDestinations.kt:758)");
            }
            Object obj = NavDestinations.NearPeopleDest.INSTANCE.getArgs()[0];
            y.g(obj, "null cannot be cast to non-null type androidx.navigation.NavHostController");
            NearPeopleScreenKt.NearPeopleScreen((NavHostController) obj, null, composer, 0, 2);
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
    public static final k0 lambda__211495000$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-211495000, i10, -1, "cu.todus.android.uiCompose.navigation.ComposableSingletons$NavDestinationsKt.lambda$-211495000.<anonymous> (NavDestinations.kt:324)");
            }
            NavDestinations.MapDest mapDest = NavDestinations.MapDest.INSTANCE;
            Object obj = mapDest.getArgs()[0];
            y.g(obj, "null cannot be cast to non-null type androidx.navigation.NavHostController");
            Object obj2 = mapDest.getArgs()[1];
            y.g(obj2, "null cannot be cast to non-null type kotlin.String");
            MapScreenKt.MapScreen((NavHostController) obj, (String) obj2, null, composer, 0, 4);
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
    public static final k0 lambda__259691265$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-259691265, i10, -1, "cu.todus.android.uiCompose.navigation.ComposableSingletons$NavDestinationsKt.lambda$-259691265.<anonymous> (NavDestinations.kt:507)");
            }
            NavDestinations.CreateGroupStep2ConfigurationDest createGroupStep2ConfigurationDest = NavDestinations.CreateGroupStep2ConfigurationDest.INSTANCE;
            Object obj = createGroupStep2ConfigurationDest.getArgs()[0];
            y.g(obj, "null cannot be cast to non-null type androidx.navigation.NavHostController");
            Object obj2 = createGroupStep2ConfigurationDest.getArgs()[1];
            y.g(obj2, "null cannot be cast to non-null type kotlin.String");
            CreateGroupStep2ConfigurationScreenKt.CreateGroupStep2ConfigurationScreen((NavHostController) obj, (String) obj2, null, composer, 0, 4);
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
    public static final k0 lambda__293894906$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-293894906, i10, -1, "cu.todus.android.uiCompose.navigation.ComposableSingletons$NavDestinationsKt.lambda$-293894906.<anonymous> (NavDestinations.kt:597)");
            }
            Object obj = NavDestinations.SecretRoomsDest.INSTANCE.getArgs()[0];
            y.g(obj, "null cannot be cast to non-null type androidx.navigation.NavHostController");
            SecretRoomsScreenKt.SecretRoomsScreen((NavHostController) obj, null, composer, 0, 2);
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
    public static final k0 lambda__294657203$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-294657203, i10, -1, "cu.todus.android.uiCompose.navigation.ComposableSingletons$NavDestinationsKt.lambda$-294657203.<anonymous> (NavDestinations.kt:389)");
            }
            Object obj = NavDestinations.HomeDest.INSTANCE.getArgs()[0];
            y.g(obj, "null cannot be cast to non-null type androidx.navigation.NavHostController");
            BigHomeScreenKt.BigHomeScreen((NavHostController) obj, null, composer, 0, 2);
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
    public static final k0 lambda__33817025$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-33817025, i10, -1, "cu.todus.android.uiCompose.navigation.ComposableSingletons$NavDestinationsKt.lambda$-33817025.<anonymous> (NavDestinations.kt:206)");
            }
            Object obj = NavDestinations.RegisterDest.INSTANCE.getArgs()[0];
            y.g(obj, "null cannot be cast to non-null type androidx.navigation.NavHostController");
            RegisterScreenKt.RegisterScreen((NavHostController) obj, null, composer, 0, 2);
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
    public static final k0 lambda__339955644$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-339955644, i10, -1, "cu.todus.android.uiCompose.navigation.ComposableSingletons$NavDestinationsKt.lambda$-339955644.<anonymous> (NavDestinations.kt:373)");
            }
            NavDestinations.PreviewCardDest previewCardDest = NavDestinations.PreviewCardDest.INSTANCE;
            Object obj = previewCardDest.getArgs()[0];
            y.g(obj, "null cannot be cast to non-null type androidx.navigation.NavHostController");
            Object obj2 = previewCardDest.getArgs()[1];
            y.g(obj2, "null cannot be cast to non-null type kotlin.String");
            PreviewCardScreenKt.PreviewCardScreen((NavHostController) obj, (String) obj2, null, false, composer, 0, 12);
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
    public static final k0 lambda__346924322$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-346924322, i10, -1, "cu.todus.android.uiCompose.navigation.ComposableSingletons$NavDestinationsKt.lambda$-346924322.<anonymous> (NavDestinations.kt:1101)");
            }
            Object obj = NavDestinations.ContactsPermissionDest.INSTANCE.getArgs()[0];
            y.g(obj, "null cannot be cast to non-null type androidx.navigation.NavHostController");
            ContactsPermissionScreenKt.ContactsPermissionsScreen((NavHostController) obj, composer, 0);
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
    public static final k0 lambda__39550485$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-39550485, i10, -1, "cu.todus.android.uiCompose.navigation.ComposableSingletons$NavDestinationsKt.lambda$-39550485.<anonymous> (NavDestinations.kt:830)");
            }
            NavDestinations.CatalogueFormDest catalogueFormDest = NavDestinations.CatalogueFormDest.INSTANCE;
            Object obj = catalogueFormDest.getArgs()[0];
            y.g(obj, "null cannot be cast to non-null type androidx.navigation.NavHostController");
            Object obj2 = catalogueFormDest.getArgs()[1];
            y.g(obj2, "null cannot be cast to non-null type kotlin.String");
            CatalogueFormScreenKt.CatalogueFormScreen((NavHostController) obj, (String) obj2, null, composer, 0, 4);
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
    public static final k0 lambda__441360405$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-441360405, i10, -1, "cu.todus.android.uiCompose.navigation.ComposableSingletons$NavDestinationsKt.lambda$-441360405.<anonymous> (NavDestinations.kt:303)");
            }
            Object obj = NavDestinations.LinkedDeviceDest.INSTANCE.getArgs()[0];
            y.g(obj, "null cannot be cast to non-null type androidx.navigation.NavHostController");
            LinkedDeviceScreenKt.LinkedDeviceScreen((NavHostController) obj, null, composer, 0, 2);
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
    public static final k0 lambda__457822889$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-457822889, i10, -1, "cu.todus.android.uiCompose.navigation.ComposableSingletons$NavDestinationsKt.lambda$-457822889.<anonymous> (NavDestinations.kt:264)");
            }
            NavDestinations.ChatChannelDest chatChannelDest = NavDestinations.ChatChannelDest.INSTANCE;
            Object obj = chatChannelDest.getArgs()[0];
            y.g(obj, "null cannot be cast to non-null type androidx.navigation.NavHostController");
            Object obj2 = chatChannelDest.getArgs()[1];
            y.g(obj2, "null cannot be cast to non-null type kotlin.String");
            BigChatChannelScreenKt.BigChatChannelScreen((NavHostController) obj, (String) obj2, null, composer, 0, 4);
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
    public static final k0 lambda__4661607$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-4661607, i10, -1, "cu.todus.android.uiCompose.navigation.ComposableSingletons$NavDestinationsKt.lambda$-4661607.<anonymous> (NavDestinations.kt:773)");
            }
            Object obj = NavDestinations.AboutDest.INSTANCE.getArgs()[0];
            y.g(obj, "null cannot be cast to non-null type androidx.navigation.NavHostController");
            AboutScreenKt.AboutScreen((NavHostController) obj, composer, 0);
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
    public static final k0 lambda__470446840$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-470446840, i10, -1, "cu.todus.android.uiCompose.navigation.ComposableSingletons$NavDestinationsKt.lambda$-470446840.<anonymous> (NavDestinations.kt:1075)");
            }
            NavDestinations.SocialProfileDest socialProfileDest = NavDestinations.SocialProfileDest.INSTANCE;
            Object obj = socialProfileDest.getArgs()[0];
            y.g(obj, "null cannot be cast to non-null type androidx.navigation.NavHostController");
            Object obj2 = socialProfileDest.getArgs()[1];
            y.g(obj2, "null cannot be cast to non-null type kotlin.String");
            SocialProfileScreenKt.SocialProfileScreen((NavHostController) obj, (String) obj2, null, composer, 0, 4);
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
    public static final k0 lambda__498868190$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-498868190, i10, -1, "cu.todus.android.uiCompose.navigation.ComposableSingletons$NavDestinationsKt.lambda$-498868190.<anonymous> (NavDestinations.kt:230)");
            }
            NavDestinations.ChatP2PDest chatP2PDest = NavDestinations.ChatP2PDest.INSTANCE;
            Object obj = chatP2PDest.getArgs()[0];
            y.g(obj, "null cannot be cast to non-null type androidx.navigation.NavHostController");
            Object obj2 = chatP2PDest.getArgs()[1];
            y.g(obj2, "null cannot be cast to non-null type kotlin.String");
            BigChatP2PScreenKt.BigChatP2PScreen((NavHostController) obj, (String) obj2, null, composer, 0, 4);
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
    public static final k0 lambda__582162177$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-582162177, i10, -1, "cu.todus.android.uiCompose.navigation.ComposableSingletons$NavDestinationsKt.lambda$-582162177.<anonymous> (NavDestinations.kt:719)");
            }
            NavDestinations.PreviewSubscribersDest previewSubscribersDest = NavDestinations.PreviewSubscribersDest.INSTANCE;
            Object obj = previewSubscribersDest.getArgs()[0];
            y.g(obj, "null cannot be cast to non-null type androidx.navigation.NavHostController");
            Object obj2 = previewSubscribersDest.getArgs()[1];
            y.g(obj2, "null cannot be cast to non-null type kotlin.String");
            PreviewSubscribersScreenKt.PreviewSubscribersScreen((NavHostController) obj, (String) obj2, null, composer, 0, 4);
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
    public static final k0 lambda__589823581$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-589823581, i10, -1, "cu.todus.android.uiCompose.navigation.ComposableSingletons$NavDestinationsKt.lambda$-589823581.<anonymous> (NavDestinations.kt:1022)");
            }
            Object obj = NavDestinations.ManageBackupDest.INSTANCE.getArgs()[0];
            y.g(obj, "null cannot be cast to non-null type androidx.navigation.NavHostController");
            ManageBackupScreenKt.ManageBackupScreen((NavHostController) obj, null, composer, 0, 2);
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
    public static final k0 lambda__617393876$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-617393876, i10, -1, "cu.todus.android.uiCompose.navigation.ComposableSingletons$NavDestinationsKt.lambda$-617393876.<anonymous> (NavDestinations.kt:405)");
            }
            NavDestinations.ForwardToDest forwardToDest = NavDestinations.ForwardToDest.INSTANCE;
            Object obj = forwardToDest.getArgs()[0];
            y.g(obj, "null cannot be cast to non-null type androidx.navigation.NavHostController");
            Object obj2 = forwardToDest.getArgs()[1];
            y.g(obj2, "null cannot be cast to non-null type kotlin.String");
            ForwardToScreenKt.ForwardToScreen((NavHostController) obj, (String) obj2, null, composer, 0, 4);
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
    public static final k0 lambda__628055465$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-628055465, i10, -1, "cu.todus.android.uiCompose.navigation.ComposableSingletons$NavDestinationsKt.lambda$-628055465.<anonymous> (NavDestinations.kt:1005)");
            }
            NavDestinations.PreviewGroupAdminsDest previewGroupAdminsDest = NavDestinations.PreviewGroupAdminsDest.INSTANCE;
            Object obj = previewGroupAdminsDest.getArgs()[0];
            y.g(obj, "null cannot be cast to non-null type androidx.navigation.NavHostController");
            Object obj2 = previewGroupAdminsDest.getArgs()[1];
            y.g(obj2, "null cannot be cast to non-null type kotlin.String");
            PreviewGroupAdminsScreenKt.PreviewGroupAdminsScreen((NavHostController) obj, (String) obj2, null, composer, 0, 4);
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
    public static final k0 lambda__70045100$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-70045100, i10, -1, "cu.todus.android.uiCompose.navigation.ComposableSingletons$NavDestinationsKt.lambda$-70045100.<anonymous> (NavDestinations.kt:901)");
            }
            Object obj = NavDestinations.ThemeSelectorDest.INSTANCE.getArgs()[0];
            y.g(obj, "null cannot be cast to non-null type androidx.navigation.NavHostController");
            ThemeSelectorScreenKt.ThemeSelectorScreen((NavHostController) obj, null, composer, 0, 2);
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
    public static final k0 lambda__72159414$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-72159414, i10, -1, "cu.todus.android.uiCompose.navigation.ComposableSingletons$NavDestinationsKt.lambda$-72159414.<anonymous> (NavDestinations.kt:642)");
            }
            Object obj = NavDestinations.BlockedDest.INSTANCE.getArgs()[0];
            y.g(obj, "null cannot be cast to non-null type androidx.navigation.NavHostController");
            BlockedScreenKt.BlockedScreen((NavHostController) obj, null, composer, 0, 2);
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
    public static final k0 lambda__732657925$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-732657925, i10, -1, "cu.todus.android.uiCompose.navigation.ComposableSingletons$NavDestinationsKt.lambda$-732657925.<anonymous> (NavDestinations.kt:995)");
            }
            Object obj = NavDestinations.ReactSelectionDest.INSTANCE.getArgs()[0];
            y.g(obj, "null cannot be cast to non-null type androidx.navigation.NavHostController");
            ReactionsSelectionScreenKt.ReactionsSelectionScreen((NavHostController) obj, null, composer, 0, 2);
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
    public static final k0 lambda__746183516$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-746183516, i10, -1, "cu.todus.android.uiCompose.navigation.ComposableSingletons$NavDestinationsKt.lambda$-746183516.<anonymous> (NavDestinations.kt:275)");
            }
            NavDestinations.ChatCardDest chatCardDest = NavDestinations.ChatCardDest.INSTANCE;
            Object obj = chatCardDest.getArgs()[0];
            y.g(obj, "null cannot be cast to non-null type androidx.navigation.NavHostController");
            Object obj2 = chatCardDest.getArgs()[1];
            y.g(obj2, "null cannot be cast to non-null type kotlin.String");
            ChatCardScreenKt.ChatCardScreen((NavHostController) obj, (String) obj2, null, composer, 0, 4);
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
    public static final k0 lambda__790759999$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-790759999, i10, -1, "cu.todus.android.uiCompose.navigation.ComposableSingletons$NavDestinationsKt.lambda$-790759999.<anonymous> (NavDestinations.kt:518)");
            }
            NavDestinations.JoinRoomDest joinRoomDest = NavDestinations.JoinRoomDest.INSTANCE;
            Object obj = joinRoomDest.getArgs()[0];
            y.g(obj, "null cannot be cast to non-null type androidx.navigation.NavHostController");
            Object obj2 = joinRoomDest.getArgs()[1];
            y.g(obj2, "null cannot be cast to non-null type kotlin.String");
            JoinRoomScreenKt.JoinRoomScreen((NavHostController) obj, (String) obj2, null, composer, 0, 4);
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
    public static final k0 lambda__790774554$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-790774554, i10, -1, "cu.todus.android.uiCompose.navigation.ComposableSingletons$NavDestinationsKt.lambda$-790774554.<anonymous> (NavDestinations.kt:975)");
            }
            Object obj = NavDestinations.BatteryPreferenceDest.INSTANCE.getArgs()[0];
            y.g(obj, "null cannot be cast to non-null type androidx.navigation.NavHostController");
            BatteryPreferenceScreenKt.BatteryPreferenceScreen((NavHostController) obj, null, composer, 0, 2);
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
    public static final k0 lambda__805385140$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-805385140, i10, -1, "cu.todus.android.uiCompose.navigation.ComposableSingletons$NavDestinationsKt.lambda$-805385140.<anonymous> (NavDestinations.kt:1206)");
            }
            Object obj = NavDestinations.CallDest.INSTANCE.getArgs()[0];
            y.g(obj, "null cannot be cast to non-null type androidx.navigation.NavHostController");
            CallScreenKt.CallScreen((NavHostController) obj, null, composer, 0, 2);
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
    public static final k0 lambda__853308999$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-853308999, i10, -1, "cu.todus.android.uiCompose.navigation.ComposableSingletons$NavDestinationsKt.lambda$-853308999.<anonymous> (NavDestinations.kt:1058)");
            }
            NavDestinations.ChatResourcesDest chatResourcesDest = NavDestinations.ChatResourcesDest.INSTANCE;
            Object obj = chatResourcesDest.getArgs()[0];
            y.g(obj, "null cannot be cast to non-null type androidx.navigation.NavHostController");
            Object obj2 = chatResourcesDest.getArgs()[1];
            y.g(obj2, "null cannot be cast to non-null type kotlin.String");
            ChatResourcesScreenKt.ChatResourcesScreen((NavHostController) obj, (String) obj2, null, composer, 0, 4);
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
    public static final k0 lambda__864430289$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-864430289, i10, -1, "cu.todus.android.uiCompose.navigation.ComposableSingletons$NavDestinationsKt.lambda$-864430289.<anonymous> (NavDestinations.kt:565)");
            }
            NavDestinations.QrViewerDest qrViewerDest = NavDestinations.QrViewerDest.INSTANCE;
            Object obj = qrViewerDest.getArgs()[0];
            y.g(obj, "null cannot be cast to non-null type androidx.navigation.NavHostController");
            Object obj2 = qrViewerDest.getArgs()[1];
            y.g(obj2, "null cannot be cast to non-null type kotlin.String");
            QrViewerScreenKt.QrViewerScreen((NavHostController) obj, (String) obj2, composer, 0);
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
    public static final k0 lambda__886584695$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-886584695, i10, -1, "cu.todus.android.uiCompose.navigation.ComposableSingletons$NavDestinationsKt.lambda$-886584695.<anonymous> (NavDestinations.kt:708)");
            }
            NavDestinations.ManageStickersDest manageStickersDest = NavDestinations.ManageStickersDest.INSTANCE;
            Object obj = manageStickersDest.getArgs()[0];
            y.g(obj, "null cannot be cast to non-null type androidx.navigation.NavHostController");
            Object obj2 = manageStickersDest.getArgs()[1];
            y.g(obj2, "null cannot be cast to non-null type kotlin.String");
            ManageStickersScreenKt.ManageStickersScreen((NavHostController) obj, (String) obj2, null, composer, 0, 4);
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
    public static final k0 lambda__937712599$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-937712599, i10, -1, "cu.todus.android.uiCompose.navigation.ComposableSingletons$NavDestinationsKt.lambda$-937712599.<anonymous> (NavDestinations.kt:990)");
            }
            Object obj = NavDestinations.ReactSelectionDest.INSTANCE.getArgs()[0];
            y.g(obj, "null cannot be cast to non-null type androidx.navigation.NavHostController");
            ReactionsSelectionScreenKt.ReactionsSelectionScreen((NavHostController) obj, null, composer, 0, 2);
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
    public static final k0 lambda__945169742$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-945169742, i10, -1, "cu.todus.android.uiCompose.navigation.ComposableSingletons$NavDestinationsKt.lambda$-945169742.<anonymous> (NavDestinations.kt:555)");
            }
            Object obj = NavDestinations.QrReaderDest.INSTANCE.getArgs()[0];
            y.g(obj, "null cannot be cast to non-null type androidx.navigation.NavHostController");
            QrReaderScreenKt.QrReaderScreen((NavHostController) obj, composer, 0);
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
    public static final k0 lambda__953101436$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-953101436, i10, -1, "cu.todus.android.uiCompose.navigation.ComposableSingletons$NavDestinationsKt.lambda$-953101436.<anonymous> (NavDestinations.kt:672)");
            }
            Object obj = NavDestinations.SearchDest.INSTANCE.getArgs()[0];
            y.g(obj, "null cannot be cast to non-null type androidx.navigation.NavHostController");
            SearchScreenKt.SearchScreen((NavHostController) obj, null, composer, 0, 2);
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
    public static final k0 lambda__957464418$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-957464418, i10, -1, "cu.todus.android.uiCompose.navigation.ComposableSingletons$NavDestinationsKt.lambda$-957464418.<anonymous> (NavDestinations.kt:340)");
            }
            Object obj = NavDestinations.OpenWithDest.INSTANCE.getArgs()[0];
            y.g(obj, "null cannot be cast to non-null type androidx.navigation.NavHostController");
            OpenWithScreenKt.OpenWithScreen((NavHostController) obj, null, composer, 0, 2);
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
    public static final k0 lambda__961740792$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-961740792, i10, -1, "cu.todus.android.uiCompose.navigation.ComposableSingletons$NavDestinationsKt.lambda$-961740792.<anonymous> (NavDestinations.kt:484)");
            }
            NavDestinations.CreateGroupStep1SelectionDest createGroupStep1SelectionDest = NavDestinations.CreateGroupStep1SelectionDest.INSTANCE;
            Object obj = createGroupStep1SelectionDest.getArgs()[0];
            y.g(obj, "null cannot be cast to non-null type androidx.navigation.NavHostController");
            Object obj2 = createGroupStep1SelectionDest.getArgs()[1];
            y.g(obj2, "null cannot be cast to non-null type kotlin.String");
            CreateGroupStep1SelectionScreenKt.CreateGroupStep1SelectionScreen((NavHostController) obj, (String) obj2, null, composer, 0, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: renamed from: getLambda$-1002767143$app_productionPFast, reason: not valid java name */
    public final Function2 m10002getLambda$1002767143$app_productionPFast() {
        return f281lambda$1002767143;
    }

    /* JADX INFO: renamed from: getLambda$-1067800490$app_productionPFast, reason: not valid java name */
    public final Function2 m10003getLambda$1067800490$app_productionPFast() {
        return f282lambda$1067800490;
    }

    /* JADX INFO: renamed from: getLambda$-1091639369$app_productionPFast, reason: not valid java name */
    public final Function2 m10004getLambda$1091639369$app_productionPFast() {
        return f283lambda$1091639369;
    }

    /* JADX INFO: renamed from: getLambda$-1170692923$app_productionPFast, reason: not valid java name */
    public final Function2 m10005getLambda$1170692923$app_productionPFast() {
        return f284lambda$1170692923;
    }

    /* JADX INFO: renamed from: getLambda$-1223802583$app_productionPFast, reason: not valid java name */
    public final Function2 m10006getLambda$1223802583$app_productionPFast() {
        return f285lambda$1223802583;
    }

    /* JADX INFO: renamed from: getLambda$-1238164812$app_productionPFast, reason: not valid java name */
    public final Function2 m10007getLambda$1238164812$app_productionPFast() {
        return f286lambda$1238164812;
    }

    /* JADX INFO: renamed from: getLambda$-1284085325$app_productionPFast, reason: not valid java name */
    public final Function2 m10008getLambda$1284085325$app_productionPFast() {
        return f287lambda$1284085325;
    }

    /* JADX INFO: renamed from: getLambda$-1321937836$app_productionPFast, reason: not valid java name */
    public final Function2 m10009getLambda$1321937836$app_productionPFast() {
        return f288lambda$1321937836;
    }

    /* JADX INFO: renamed from: getLambda$-1335914194$app_productionPFast, reason: not valid java name */
    public final Function2 m10010getLambda$1335914194$app_productionPFast() {
        return f289lambda$1335914194;
    }

    /* JADX INFO: renamed from: getLambda$-1363248633$app_productionPFast, reason: not valid java name */
    public final Function2 m10011getLambda$1363248633$app_productionPFast() {
        return f290lambda$1363248633;
    }

    /* JADX INFO: renamed from: getLambda$-1405530612$app_productionPFast, reason: not valid java name */
    public final Function2 m10012getLambda$1405530612$app_productionPFast() {
        return f291lambda$1405530612;
    }

    /* JADX INFO: renamed from: getLambda$-1415345546$app_productionPFast, reason: not valid java name */
    public final Function2 m10013getLambda$1415345546$app_productionPFast() {
        return f292lambda$1415345546;
    }

    /* JADX INFO: renamed from: getLambda$-1430430469$app_productionPFast, reason: not valid java name */
    public final Function2 m10014getLambda$1430430469$app_productionPFast() {
        return f293lambda$1430430469;
    }

    /* JADX INFO: renamed from: getLambda$-1437310999$app_productionPFast, reason: not valid java name */
    public final Function2 m10015getLambda$1437310999$app_productionPFast() {
        return f294lambda$1437310999;
    }

    /* JADX INFO: renamed from: getLambda$-1442263235$app_productionPFast, reason: not valid java name */
    public final Function2 m10016getLambda$1442263235$app_productionPFast() {
        return f295lambda$1442263235;
    }

    /* JADX INFO: renamed from: getLambda$-1468180859$app_productionPFast, reason: not valid java name */
    public final Function2 m10017getLambda$1468180859$app_productionPFast() {
        return f296lambda$1468180859;
    }

    /* JADX INFO: renamed from: getLambda$-1524770540$app_productionPFast, reason: not valid java name */
    public final Function2 m10018getLambda$1524770540$app_productionPFast() {
        return f297lambda$1524770540;
    }

    /* JADX INFO: renamed from: getLambda$-1555293176$app_productionPFast, reason: not valid java name */
    public final Function2 m10019getLambda$1555293176$app_productionPFast() {
        return f298lambda$1555293176;
    }

    /* JADX INFO: renamed from: getLambda$-1568303307$app_productionPFast, reason: not valid java name */
    public final Function2 m10020getLambda$1568303307$app_productionPFast() {
        return f299lambda$1568303307;
    }

    /* JADX INFO: renamed from: getLambda$-1569580744$app_productionPFast, reason: not valid java name */
    public final Function2 m10021getLambda$1569580744$app_productionPFast() {
        return f300lambda$1569580744;
    }

    /* JADX INFO: renamed from: getLambda$-1590726411$app_productionPFast, reason: not valid java name */
    public final Function2 m10022getLambda$1590726411$app_productionPFast() {
        return f301lambda$1590726411;
    }

    /* JADX INFO: renamed from: getLambda$-1612158498$app_productionPFast, reason: not valid java name */
    public final Function2 m10023getLambda$1612158498$app_productionPFast() {
        return f302lambda$1612158498;
    }

    /* JADX INFO: renamed from: getLambda$-1622045482$app_productionPFast, reason: not valid java name */
    public final Function2 m10024getLambda$1622045482$app_productionPFast() {
        return f303lambda$1622045482;
    }

    /* JADX INFO: renamed from: getLambda$-1629758197$app_productionPFast, reason: not valid java name */
    public final Function2 m10025getLambda$1629758197$app_productionPFast() {
        return f304lambda$1629758197;
    }

    /* JADX INFO: renamed from: getLambda$-1741322822$app_productionPFast, reason: not valid java name */
    public final Function2 m10026getLambda$1741322822$app_productionPFast() {
        return f305lambda$1741322822;
    }

    /* JADX INFO: renamed from: getLambda$-1747352400$app_productionPFast, reason: not valid java name */
    public final Function2 m10027getLambda$1747352400$app_productionPFast() {
        return f306lambda$1747352400;
    }

    /* JADX INFO: renamed from: getLambda$-1803608777$app_productionPFast, reason: not valid java name */
    public final Function2 m10028getLambda$1803608777$app_productionPFast() {
        return f307lambda$1803608777;
    }

    /* JADX INFO: renamed from: getLambda$-1882709325$app_productionPFast, reason: not valid java name */
    public final Function2 m10029getLambda$1882709325$app_productionPFast() {
        return f308lambda$1882709325;
    }

    /* JADX INFO: renamed from: getLambda$-1900002833$app_productionPFast, reason: not valid java name */
    public final Function2 m10030getLambda$1900002833$app_productionPFast() {
        return f309lambda$1900002833;
    }

    /* JADX INFO: renamed from: getLambda$-1960016394$app_productionPFast, reason: not valid java name */
    public final Function2 m10031getLambda$1960016394$app_productionPFast() {
        return f310lambda$1960016394;
    }

    /* JADX INFO: renamed from: getLambda$-1962639883$app_productionPFast, reason: not valid java name */
    public final Function2 m10032getLambda$1962639883$app_productionPFast() {
        return f311lambda$1962639883;
    }

    /* JADX INFO: renamed from: getLambda$-1982112229$app_productionPFast, reason: not valid java name */
    public final Function2 m10033getLambda$1982112229$app_productionPFast() {
        return f312lambda$1982112229;
    }

    /* JADX INFO: renamed from: getLambda$-1982590255$app_productionPFast, reason: not valid java name */
    public final Function2 m10034getLambda$1982590255$app_productionPFast() {
        return f313lambda$1982590255;
    }

    /* JADX INFO: renamed from: getLambda$-198700397$app_productionPFast, reason: not valid java name */
    public final Function2 m10035getLambda$198700397$app_productionPFast() {
        return f314lambda$198700397;
    }

    /* JADX INFO: renamed from: getLambda$-1988264126$app_productionPFast, reason: not valid java name */
    public final Function2 m10036getLambda$1988264126$app_productionPFast() {
        return f315lambda$1988264126;
    }

    /* JADX INFO: renamed from: getLambda$-1993150299$app_productionPFast, reason: not valid java name */
    public final Function2 m10037getLambda$1993150299$app_productionPFast() {
        return f316lambda$1993150299;
    }

    /* JADX INFO: renamed from: getLambda$-2028483543$app_productionPFast, reason: not valid java name */
    public final Function2 m10038getLambda$2028483543$app_productionPFast() {
        return f317lambda$2028483543;
    }

    /* JADX INFO: renamed from: getLambda$-2061234458$app_productionPFast, reason: not valid java name */
    public final Function2 m10039getLambda$2061234458$app_productionPFast() {
        return f318lambda$2061234458;
    }

    /* JADX INFO: renamed from: getLambda$-2075210816$app_productionPFast, reason: not valid java name */
    public final Function2 m10040getLambda$2075210816$app_productionPFast() {
        return f319lambda$2075210816;
    }

    /* JADX INFO: renamed from: getLambda$-2089337211$app_productionPFast, reason: not valid java name */
    public final Function2 m10041getLambda$2089337211$app_productionPFast() {
        return f320lambda$2089337211;
    }

    /* JADX INFO: renamed from: getLambda$-211495000$app_productionPFast, reason: not valid java name */
    public final Function2 m10042getLambda$211495000$app_productionPFast() {
        return f321lambda$211495000;
    }

    /* JADX INFO: renamed from: getLambda$-259691265$app_productionPFast, reason: not valid java name */
    public final Function2 m10043getLambda$259691265$app_productionPFast() {
        return f322lambda$259691265;
    }

    /* JADX INFO: renamed from: getLambda$-293894906$app_productionPFast, reason: not valid java name */
    public final Function2 m10044getLambda$293894906$app_productionPFast() {
        return f323lambda$293894906;
    }

    /* JADX INFO: renamed from: getLambda$-294657203$app_productionPFast, reason: not valid java name */
    public final Function2 m10045getLambda$294657203$app_productionPFast() {
        return f324lambda$294657203;
    }

    /* JADX INFO: renamed from: getLambda$-33817025$app_productionPFast, reason: not valid java name */
    public final Function2 m10046getLambda$33817025$app_productionPFast() {
        return f325lambda$33817025;
    }

    /* JADX INFO: renamed from: getLambda$-339955644$app_productionPFast, reason: not valid java name */
    public final Function2 m10047getLambda$339955644$app_productionPFast() {
        return f326lambda$339955644;
    }

    /* JADX INFO: renamed from: getLambda$-346924322$app_productionPFast, reason: not valid java name */
    public final Function2 m10048getLambda$346924322$app_productionPFast() {
        return f327lambda$346924322;
    }

    /* JADX INFO: renamed from: getLambda$-39550485$app_productionPFast, reason: not valid java name */
    public final Function2 m10049getLambda$39550485$app_productionPFast() {
        return f328lambda$39550485;
    }

    /* JADX INFO: renamed from: getLambda$-441360405$app_productionPFast, reason: not valid java name */
    public final Function2 m10050getLambda$441360405$app_productionPFast() {
        return f329lambda$441360405;
    }

    /* JADX INFO: renamed from: getLambda$-457822889$app_productionPFast, reason: not valid java name */
    public final Function2 m10051getLambda$457822889$app_productionPFast() {
        return f330lambda$457822889;
    }

    /* JADX INFO: renamed from: getLambda$-4661607$app_productionPFast, reason: not valid java name */
    public final Function2 m10052getLambda$4661607$app_productionPFast() {
        return f331lambda$4661607;
    }

    /* JADX INFO: renamed from: getLambda$-470446840$app_productionPFast, reason: not valid java name */
    public final Function2 m10053getLambda$470446840$app_productionPFast() {
        return f332lambda$470446840;
    }

    /* JADX INFO: renamed from: getLambda$-498868190$app_productionPFast, reason: not valid java name */
    public final Function2 m10054getLambda$498868190$app_productionPFast() {
        return f333lambda$498868190;
    }

    /* JADX INFO: renamed from: getLambda$-582162177$app_productionPFast, reason: not valid java name */
    public final Function2 m10055getLambda$582162177$app_productionPFast() {
        return f334lambda$582162177;
    }

    /* JADX INFO: renamed from: getLambda$-589823581$app_productionPFast, reason: not valid java name */
    public final Function2 m10056getLambda$589823581$app_productionPFast() {
        return f335lambda$589823581;
    }

    /* JADX INFO: renamed from: getLambda$-617393876$app_productionPFast, reason: not valid java name */
    public final Function2 m10057getLambda$617393876$app_productionPFast() {
        return f336lambda$617393876;
    }

    /* JADX INFO: renamed from: getLambda$-628055465$app_productionPFast, reason: not valid java name */
    public final Function2 m10058getLambda$628055465$app_productionPFast() {
        return f337lambda$628055465;
    }

    /* JADX INFO: renamed from: getLambda$-70045100$app_productionPFast, reason: not valid java name */
    public final Function2 m10059getLambda$70045100$app_productionPFast() {
        return f338lambda$70045100;
    }

    /* JADX INFO: renamed from: getLambda$-72159414$app_productionPFast, reason: not valid java name */
    public final Function2 m10060getLambda$72159414$app_productionPFast() {
        return f339lambda$72159414;
    }

    /* JADX INFO: renamed from: getLambda$-732657925$app_productionPFast, reason: not valid java name */
    public final Function2 m10061getLambda$732657925$app_productionPFast() {
        return f340lambda$732657925;
    }

    /* JADX INFO: renamed from: getLambda$-746183516$app_productionPFast, reason: not valid java name */
    public final Function2 m10062getLambda$746183516$app_productionPFast() {
        return f341lambda$746183516;
    }

    /* JADX INFO: renamed from: getLambda$-790759999$app_productionPFast, reason: not valid java name */
    public final Function2 m10063getLambda$790759999$app_productionPFast() {
        return f342lambda$790759999;
    }

    /* JADX INFO: renamed from: getLambda$-790774554$app_productionPFast, reason: not valid java name */
    public final Function2 m10064getLambda$790774554$app_productionPFast() {
        return f343lambda$790774554;
    }

    /* JADX INFO: renamed from: getLambda$-805385140$app_productionPFast, reason: not valid java name */
    public final Function2 m10065getLambda$805385140$app_productionPFast() {
        return f344lambda$805385140;
    }

    /* JADX INFO: renamed from: getLambda$-853308999$app_productionPFast, reason: not valid java name */
    public final Function2 m10066getLambda$853308999$app_productionPFast() {
        return f345lambda$853308999;
    }

    /* JADX INFO: renamed from: getLambda$-864430289$app_productionPFast, reason: not valid java name */
    public final Function2 m10067getLambda$864430289$app_productionPFast() {
        return f346lambda$864430289;
    }

    /* JADX INFO: renamed from: getLambda$-886584695$app_productionPFast, reason: not valid java name */
    public final Function2 m10068getLambda$886584695$app_productionPFast() {
        return f347lambda$886584695;
    }

    /* JADX INFO: renamed from: getLambda$-937712599$app_productionPFast, reason: not valid java name */
    public final Function2 m10069getLambda$937712599$app_productionPFast() {
        return f348lambda$937712599;
    }

    /* JADX INFO: renamed from: getLambda$-945169742$app_productionPFast, reason: not valid java name */
    public final Function2 m10070getLambda$945169742$app_productionPFast() {
        return f349lambda$945169742;
    }

    /* JADX INFO: renamed from: getLambda$-953101436$app_productionPFast, reason: not valid java name */
    public final Function2 m10071getLambda$953101436$app_productionPFast() {
        return f350lambda$953101436;
    }

    /* JADX INFO: renamed from: getLambda$-957464418$app_productionPFast, reason: not valid java name */
    public final Function2 m10072getLambda$957464418$app_productionPFast() {
        return f351lambda$957464418;
    }

    /* JADX INFO: renamed from: getLambda$-961740792$app_productionPFast, reason: not valid java name */
    public final Function2 m10073getLambda$961740792$app_productionPFast() {
        return f352lambda$961740792;
    }

    public final Function2 getLambda$109907659$app_productionPFast() {
        return lambda$109907659;
    }

    public final Function2 getLambda$1135628199$app_productionPFast() {
        return lambda$1135628199;
    }

    public final Function2 getLambda$1180907112$app_productionPFast() {
        return lambda$1180907112;
    }

    public final Function2 getLambda$1250327253$app_productionPFast() {
        return lambda$1250327253;
    }

    public final Function2 getLambda$1268589377$app_productionPFast() {
        return lambda$1268589377;
    }

    public final Function2 getLambda$1311952237$app_productionPFast() {
        return lambda$1311952237;
    }

    public final Function2 getLambda$1383153117$app_productionPFast() {
        return lambda$1383153117;
    }

    public final Function2 getLambda$1397909063$app_productionPFast() {
        return lambda$1397909063;
    }

    public final Function2 getLambda$1400720576$app_productionPFast() {
        return lambda$1400720576;
    }

    public final Function2 getLambda$1409541777$app_productionPFast() {
        return lambda$1409541777;
    }

    public final Function2 getLambda$1425768760$app_productionPFast() {
        return lambda$1425768760;
    }

    public final Function2 getLambda$1540467814$app_productionPFast() {
        return lambda$1540467814;
    }

    public final Function2 getLambda$164314231$app_productionPFast() {
        return lambda$164314231;
    }

    public final Function2 getLambda$1652674281$app_productionPFast() {
        return lambda$1652674281;
    }

    public final Function2 getLambda$1658132231$app_productionPFast() {
        return lambda$1658132231;
    }

    public final Function2 getLambda$1764502330$app_productionPFast() {
        return lambda$1764502330;
    }

    public final Function2 getLambda$1770541526$app_productionPFast() {
        return lambda$1770541526;
    }

    public final Function2 getLambda$1806980098$app_productionPFast() {
        return lambda$1806980098;
    }

    public final Function2 getLambda$1812788545$app_productionPFast() {
        return lambda$1812788545;
    }

    public final Function2 getLambda$1863569779$app_productionPFast() {
        return lambda$1863569779;
    }

    public final Function2 getLambda$1883123518$app_productionPFast() {
        return lambda$1883123518;
    }

    public final Function2 getLambda$1890575220$app_productionPFast() {
        return lambda$1890575220;
    }

    public final Function2 getLambda$1894107019$app_productionPFast() {
        return lambda$1894107019;
    }

    public final Function2 getLambda$1894144076$app_productionPFast() {
        return lambda$1894144076;
    }

    public final Function2 getLambda$1906438752$app_productionPFast() {
        return lambda$1906438752;
    }

    public final Function2 getLambda$2000377498$app_productionPFast() {
        return lambda$2000377498;
    }

    public final Function2 getLambda$2009979141$app_productionPFast() {
        return lambda$2009979141;
    }

    public final Function2 getLambda$2019416431$app_productionPFast() {
        return lambda$2019416431;
    }

    public final Function2 getLambda$2100075284$app_productionPFast() {
        return lambda$2100075284;
    }

    public final Function2 getLambda$2123371543$app_productionPFast() {
        return lambda$2123371543;
    }

    public final Function2 getLambda$2126860827$app_productionPFast() {
        return lambda$2126860827;
    }

    public final Function2 getLambda$2144123770$app_productionPFast() {
        return lambda$2144123770;
    }

    public final Function2 getLambda$224869158$app_productionPFast() {
        return lambda$224869158;
    }

    public final Function2 getLambda$243715153$app_productionPFast() {
        return lambda$243715153;
    }

    public final Function2 getLambda$320989946$app_productionPFast() {
        return lambda$320989946;
    }

    public final Function2 getLambda$358414207$app_productionPFast() {
        return lambda$358414207;
    }

    public final Function2 getLambda$369368905$app_productionPFast() {
        return lambda$369368905;
    }

    public final Function2 getLambda$397006233$app_productionPFast() {
        return lambda$397006233;
    }

    public final Function2 getLambda$429630921$app_productionPFast() {
        return lambda$429630921;
    }

    public final Function2 getLambda$480738973$app_productionPFast() {
        return lambda$480738973;
    }

    public final Function2 getLambda$491916876$app_productionPFast() {
        return lambda$491916876;
    }

    public final Function2 getLambda$492769818$app_productionPFast() {
        return lambda$492769818;
    }

    public final Function2 getLambda$537877511$app_productionPFast() {
        return lambda$537877511;
    }

    public final Function2 getLambda$549523668$app_productionPFast() {
        return lambda$549523668;
    }

    public final Function2 getLambda$553227691$app_productionPFast() {
        return lambda$553227691;
    }

    public final Function2 getLambda$578928513$app_productionPFast() {
        return lambda$578928513;
    }

    public final Function2 getLambda$607555089$app_productionPFast() {
        return lambda$607555089;
    }

    public final Function2 getLambda$640241517$app_productionPFast() {
        return lambda$640241517;
    }

    public final Function2 getLambda$652032617$app_productionPFast() {
        return lambda$652032617;
    }

    public final Function2 getLambda$652598803$app_productionPFast() {
        return lambda$652598803;
    }

    public final Function2 getLambda$667137208$app_productionPFast() {
        return lambda$667137208;
    }

    public final Function2 getLambda$673186171$app_productionPFast() {
        return lambda$673186171;
    }

    public final Function2 getLambda$697175286$app_productionPFast() {
        return lambda$697175286;
    }

    public final Function2 getLambda$769124580$app_productionPFast() {
        return lambda$769124580;
    }

    public final Function2 getLambda$831717883$app_productionPFast() {
        return lambda$831717883;
    }

    public final Function2 getLambda$858660503$app_productionPFast() {
        return lambda$858660503;
    }

    public final Function2 getLambda$878471912$app_productionPFast() {
        return lambda$878471912;
    }

    public final Function2 getLambda$889766674$app_productionPFast() {
        return lambda$889766674;
    }

    public final Function2 getLambda$893171558$app_productionPFast() {
        return lambda$893171558;
    }

    public final Function2 getLambda$918835609$app_productionPFast() {
        return lambda$918835609;
    }
}
