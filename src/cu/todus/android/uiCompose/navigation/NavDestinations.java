package cu.todus.android.uiCompose.navigation;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 1)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\bF\bÇ\u0002\u0018\u00002\u00020\u0001:C\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006G"}, d2 = {"Lcu/todus/android/uiCompose/navigation/NavDestinations;", "", "<init>", "()V", "AppDestination", "WelcomeDest", "FirstOpenDest", "VerifyDest", "RegisterDest", "ChatP2PDest", "ChatGroupDest", "ChatChannelDest", "ChatCardDest", "InitInfoProfileDest", "LinkedDeviceDest", "MapDest", "OpenWithDest", "PreviewP2PDest", "PreviewCardDest", "HomeDest", "ForwardToDest", "PreviewGroupDest", "PreviewChannelDest", "PreviewChannelAdminsDest", "DateEditorDest", "CreateGroupStep1SelectionDest", "CreateGroupStep2ConfigurationDest", "JoinRoomDest", "CreateChannelDest", "QrReaderDest", "QrViewerDest", "SettingScreenDest", "SecretRoomsDest", "SecretRoomAccessDest", "MutedRoomsDest", "BlockedDest", "EditProfileDest", "SearchDest", "DataPreferencesDest", "ManageStickersDest", "PreviewSubscribersDest", "PubEditorDest", "NearPeopleDest", "AboutDest", "NewsDest", "CatalogueCheckInDest", "MyCatalogueDest", "CatalogueFormDest", "EditToDusIdDest", "CatalogueDest", "ProductPreviewDest", "ThemeSelectorDest", "StatusEditorDest", "StatusListDest", "PrivacyDest", "StatusPreviewDest", "BatteryPreferenceDest", "ReactSelectionDest", "PreviewGroupAdminsDest", "ManageBackupDest", "LogoutDest", "ChatResourcesDest", "SocialProfileDest", "RequestRoomsDest", "ContactsPermissionDest", "CatalogueWebDest", "SendToDest", "LoadingDest", "PresentDest", "SearchUserDest", "CallDest", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class NavDestinations {
    public static final int $stable = 0;
    public static final NavDestinations INSTANCE = new NavDestinations();

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @StabilityInferred(parameters = 0)
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096D¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR*\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R%\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\b\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R%\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\b\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcu/todus/android/uiCompose/navigation/NavDestinations$AboutDest;", "Lcu/todus/android/uiCompose/navigation/NavDestinations$AppDestination;", "<init>", "()V", "", "route", "Ljava/lang/String;", "getRoute", "()Ljava/lang/String;", "", "", "args", "[Ljava/lang/Object;", "getArgs", "()[Ljava/lang/Object;", "setArgs", "([Ljava/lang/Object;)V", "Lkotlin/Function0;", "Lua/k0;", "Landroidx/compose/runtime/Composable;", "screen", "Lkotlin/jvm/functions/Function2;", "getScreen", "()Lkotlin/jvm/functions/Function2;", "bigScreen", "getBigScreen", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class AboutDest implements AppDestination {
        public static final int $stable;
        private static final Function2 bigScreen;
        private static final Function2 screen;
        public static final AboutDest INSTANCE = new AboutDest();
        private static final String route = NavLinks.ABOUT;
        private static Object[] args = new Object[0];

        static {
            ComposableSingletons$NavDestinationsKt composableSingletons$NavDestinationsKt = ComposableSingletons$NavDestinationsKt.INSTANCE;
            screen = composableSingletons$NavDestinationsKt.getLambda$553227691$app_productionPFast();
            bigScreen = composableSingletons$NavDestinationsKt.m10052getLambda$4661607$app_productionPFast();
            $stable = 8;
        }

        private AboutDest() {
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Object[] getArgs() {
            return args;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Function2 getBigScreen() {
            return bigScreen;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public String getRoute() {
            return route;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Function2 getScreen() {
            return screen;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public void setArgs(Object[] objArr) {
            y.i(objArr, "<set-?>");
            args = objArr;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001R\u0014\u0010\u0005\u001a\u00020\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001f\u0010\u000b\u001a\r\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\b8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR!\u0010\r\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0002\b\b8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\nR$\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000e8&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0014À\u0006\u0003"}, d2 = {"Lcu/todus/android/uiCompose/navigation/NavDestinations$AppDestination;", "", "", "getRoute", "()Ljava/lang/String;", "route", "Lkotlin/Function0;", "Lua/k0;", "Landroidx/compose/runtime/Composable;", "getScreen", "()Lkotlin/jvm/functions/Function2;", "screen", "getBigScreen", "bigScreen", "", "getArgs", "()[Ljava/lang/Object;", "setArgs", "([Ljava/lang/Object;)V", "args", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public interface AppDestination {
        Object[] getArgs();

        Function2 getBigScreen();

        String getRoute();

        Function2 getScreen();

        void setArgs(Object[] objArr);
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @StabilityInferred(parameters = 0)
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096D¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR*\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R%\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\b\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R%\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\b\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcu/todus/android/uiCompose/navigation/NavDestinations$BatteryPreferenceDest;", "Lcu/todus/android/uiCompose/navigation/NavDestinations$AppDestination;", "<init>", "()V", "", "route", "Ljava/lang/String;", "getRoute", "()Ljava/lang/String;", "", "", "args", "[Ljava/lang/Object;", "getArgs", "()[Ljava/lang/Object;", "setArgs", "([Ljava/lang/Object;)V", "Lkotlin/Function0;", "Lua/k0;", "Landroidx/compose/runtime/Composable;", "screen", "Lkotlin/jvm/functions/Function2;", "getScreen", "()Lkotlin/jvm/functions/Function2;", "bigScreen", "getBigScreen", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class BatteryPreferenceDest implements AppDestination {
        public static final int $stable;
        private static final Function2 bigScreen;
        private static final Function2 screen;
        public static final BatteryPreferenceDest INSTANCE = new BatteryPreferenceDest();
        private static final String route = NavLinks.BATTERY_PREFERENCE;
        private static Object[] args = new Object[0];

        static {
            ComposableSingletons$NavDestinationsKt composableSingletons$NavDestinationsKt = ComposableSingletons$NavDestinationsKt.INSTANCE;
            screen = composableSingletons$NavDestinationsKt.m10064getLambda$790774554$app_productionPFast();
            bigScreen = composableSingletons$NavDestinationsKt.getLambda$549523668$app_productionPFast();
            $stable = 8;
        }

        private BatteryPreferenceDest() {
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Object[] getArgs() {
            return args;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Function2 getBigScreen() {
            return bigScreen;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public String getRoute() {
            return route;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Function2 getScreen() {
            return screen;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public void setArgs(Object[] objArr) {
            y.i(objArr, "<set-?>");
            args = objArr;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @StabilityInferred(parameters = 0)
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096D¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR*\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R%\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\b\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R%\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\b\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcu/todus/android/uiCompose/navigation/NavDestinations$BlockedDest;", "Lcu/todus/android/uiCompose/navigation/NavDestinations$AppDestination;", "<init>", "()V", "", "route", "Ljava/lang/String;", "getRoute", "()Ljava/lang/String;", "", "", "args", "[Ljava/lang/Object;", "getArgs", "()[Ljava/lang/Object;", "setArgs", "([Ljava/lang/Object;)V", "Lkotlin/Function0;", "Lua/k0;", "Landroidx/compose/runtime/Composable;", "screen", "Lkotlin/jvm/functions/Function2;", "getScreen", "()Lkotlin/jvm/functions/Function2;", "bigScreen", "getBigScreen", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class BlockedDest implements AppDestination {
        public static final int $stable;
        private static final Function2 bigScreen;
        private static final Function2 screen;
        public static final BlockedDest INSTANCE = new BlockedDest();
        private static final String route = "blocked";
        private static Object[] args = new Object[0];

        static {
            ComposableSingletons$NavDestinationsKt composableSingletons$NavDestinationsKt = ComposableSingletons$NavDestinationsKt.INSTANCE;
            screen = composableSingletons$NavDestinationsKt.m10060getLambda$72159414$app_productionPFast();
            bigScreen = composableSingletons$NavDestinationsKt.getLambda$667137208$app_productionPFast();
            $stable = 8;
        }

        private BlockedDest() {
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Object[] getArgs() {
            return args;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Function2 getBigScreen() {
            return bigScreen;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public String getRoute() {
            return route;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Function2 getScreen() {
            return screen;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public void setArgs(Object[] objArr) {
            y.i(objArr, "<set-?>");
            args = objArr;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @StabilityInferred(parameters = 0)
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096D¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR*\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R%\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\b\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R%\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\b\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcu/todus/android/uiCompose/navigation/NavDestinations$CallDest;", "Lcu/todus/android/uiCompose/navigation/NavDestinations$AppDestination;", "<init>", "()V", "", "route", "Ljava/lang/String;", "getRoute", "()Ljava/lang/String;", "", "", "args", "[Ljava/lang/Object;", "getArgs", "()[Ljava/lang/Object;", "setArgs", "([Ljava/lang/Object;)V", "Lkotlin/Function0;", "Lua/k0;", "Landroidx/compose/runtime/Composable;", "screen", "Lkotlin/jvm/functions/Function2;", "getScreen", "()Lkotlin/jvm/functions/Function2;", "bigScreen", "getBigScreen", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class CallDest implements AppDestination {
        public static final int $stable;
        private static final Function2 bigScreen;
        private static final Function2 screen;
        public static final CallDest INSTANCE = new CallDest();
        private static final String route = "call";
        private static Object[] args = new Object[0];

        static {
            ComposableSingletons$NavDestinationsKt composableSingletons$NavDestinationsKt = ComposableSingletons$NavDestinationsKt.INSTANCE;
            screen = composableSingletons$NavDestinationsKt.getLambda$320989946$app_productionPFast();
            bigScreen = composableSingletons$NavDestinationsKt.m10065getLambda$805385140$app_productionPFast();
            $stable = 8;
        }

        private CallDest() {
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Object[] getArgs() {
            return args;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Function2 getBigScreen() {
            return bigScreen;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public String getRoute() {
            return route;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Function2 getScreen() {
            return screen;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public void setArgs(Object[] objArr) {
            y.i(objArr, "<set-?>");
            args = objArr;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @StabilityInferred(parameters = 0)
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096D¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR*\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R%\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\b\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R%\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\b\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcu/todus/android/uiCompose/navigation/NavDestinations$CatalogueCheckInDest;", "Lcu/todus/android/uiCompose/navigation/NavDestinations$AppDestination;", "<init>", "()V", "", "route", "Ljava/lang/String;", "getRoute", "()Ljava/lang/String;", "", "", "args", "[Ljava/lang/Object;", "getArgs", "()[Ljava/lang/Object;", "setArgs", "([Ljava/lang/Object;)V", "Lkotlin/Function0;", "Lua/k0;", "Landroidx/compose/runtime/Composable;", "screen", "Lkotlin/jvm/functions/Function2;", "getScreen", "()Lkotlin/jvm/functions/Function2;", "bigScreen", "getBigScreen", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class CatalogueCheckInDest implements AppDestination {
        public static final int $stable;
        private static final Function2 bigScreen;
        private static final Function2 screen;
        public static final CatalogueCheckInDest INSTANCE = new CatalogueCheckInDest();
        private static final String route = NavLinks.CATALOGUE_CHECK_IN;
        private static Object[] args = new Object[0];

        static {
            ComposableSingletons$NavDestinationsKt composableSingletons$NavDestinationsKt = ComposableSingletons$NavDestinationsKt.INSTANCE;
            screen = composableSingletons$NavDestinationsKt.getLambda$1400720576$app_productionPFast();
            bigScreen = composableSingletons$NavDestinationsKt.getLambda$889766674$app_productionPFast();
            $stable = 8;
        }

        private CatalogueCheckInDest() {
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Object[] getArgs() {
            return args;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Function2 getBigScreen() {
            return bigScreen;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public String getRoute() {
            return route;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Function2 getScreen() {
            return screen;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public void setArgs(Object[] objArr) {
            y.i(objArr, "<set-?>");
            args = objArr;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @StabilityInferred(parameters = 0)
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096D¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR*\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R%\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\b\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R%\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\b\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcu/todus/android/uiCompose/navigation/NavDestinations$CatalogueDest;", "Lcu/todus/android/uiCompose/navigation/NavDestinations$AppDestination;", "<init>", "()V", "", "route", "Ljava/lang/String;", "getRoute", "()Ljava/lang/String;", "", "", "args", "[Ljava/lang/Object;", "getArgs", "()[Ljava/lang/Object;", "setArgs", "([Ljava/lang/Object;)V", "Lkotlin/Function0;", "Lua/k0;", "Landroidx/compose/runtime/Composable;", "screen", "Lkotlin/jvm/functions/Function2;", "getScreen", "()Lkotlin/jvm/functions/Function2;", "bigScreen", "getBigScreen", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class CatalogueDest implements AppDestination {
        public static final int $stable;
        private static final Function2 bigScreen;
        private static final Function2 screen;
        public static final CatalogueDest INSTANCE = new CatalogueDest();
        private static final String route = NavLinks.CATALOGUE;
        private static Object[] args = new Object[0];

        static {
            ComposableSingletons$NavDestinationsKt composableSingletons$NavDestinationsKt = ComposableSingletons$NavDestinationsKt.INSTANCE;
            screen = composableSingletons$NavDestinationsKt.getLambda$537877511$app_productionPFast();
            bigScreen = composableSingletons$NavDestinationsKt.m10032getLambda$1962639883$app_productionPFast();
            $stable = 8;
        }

        private CatalogueDest() {
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Object[] getArgs() {
            return args;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Function2 getBigScreen() {
            return bigScreen;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public String getRoute() {
            return route;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Function2 getScreen() {
            return screen;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public void setArgs(Object[] objArr) {
            y.i(objArr, "<set-?>");
            args = objArr;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @StabilityInferred(parameters = 0)
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096D¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR*\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R%\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\b\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R%\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\b\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcu/todus/android/uiCompose/navigation/NavDestinations$CatalogueFormDest;", "Lcu/todus/android/uiCompose/navigation/NavDestinations$AppDestination;", "<init>", "()V", "", "route", "Ljava/lang/String;", "getRoute", "()Ljava/lang/String;", "", "", "args", "[Ljava/lang/Object;", "getArgs", "()[Ljava/lang/Object;", "setArgs", "([Ljava/lang/Object;)V", "Lkotlin/Function0;", "Lua/k0;", "Landroidx/compose/runtime/Composable;", "screen", "Lkotlin/jvm/functions/Function2;", "getScreen", "()Lkotlin/jvm/functions/Function2;", "bigScreen", "getBigScreen", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class CatalogueFormDest implements AppDestination {
        public static final int $stable;
        private static final Function2 bigScreen;
        private static final Function2 screen;
        public static final CatalogueFormDest INSTANCE = new CatalogueFormDest();
        private static final String route = NavLinks.CATALOGUE_FORM;
        private static Object[] args = new Object[0];

        static {
            ComposableSingletons$NavDestinationsKt composableSingletons$NavDestinationsKt = ComposableSingletons$NavDestinationsKt.INSTANCE;
            screen = composableSingletons$NavDestinationsKt.m10049getLambda$39550485$app_productionPFast();
            bigScreen = composableSingletons$NavDestinationsKt.m10002getLambda$1002767143$app_productionPFast();
            $stable = 8;
        }

        private CatalogueFormDest() {
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Object[] getArgs() {
            return args;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Function2 getBigScreen() {
            return bigScreen;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public String getRoute() {
            return route;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Function2 getScreen() {
            return screen;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public void setArgs(Object[] objArr) {
            y.i(objArr, "<set-?>");
            args = objArr;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @StabilityInferred(parameters = 0)
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096D¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR*\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R%\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\b\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R%\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\b\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcu/todus/android/uiCompose/navigation/NavDestinations$CatalogueWebDest;", "Lcu/todus/android/uiCompose/navigation/NavDestinations$AppDestination;", "<init>", "()V", "", "route", "Ljava/lang/String;", "getRoute", "()Ljava/lang/String;", "", "", "args", "[Ljava/lang/Object;", "getArgs", "()[Ljava/lang/Object;", "setArgs", "([Ljava/lang/Object;)V", "Lkotlin/Function0;", "Lua/k0;", "Landroidx/compose/runtime/Composable;", "screen", "Lkotlin/jvm/functions/Function2;", "getScreen", "()Lkotlin/jvm/functions/Function2;", "bigScreen", "getBigScreen", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class CatalogueWebDest implements AppDestination {
        public static final int $stable;
        private static final Function2 bigScreen;
        private static final Function2 screen;
        public static final CatalogueWebDest INSTANCE = new CatalogueWebDest();
        private static final String route = NavLinks.CATALOGUE_WEB;
        private static Object[] args = new Object[0];

        static {
            ComposableSingletons$NavDestinationsKt composableSingletons$NavDestinationsKt = ComposableSingletons$NavDestinationsKt.INSTANCE;
            screen = composableSingletons$NavDestinationsKt.getLambda$1397909063$app_productionPFast();
            bigScreen = composableSingletons$NavDestinationsKt.getLambda$397006233$app_productionPFast();
            $stable = 8;
        }

        private CatalogueWebDest() {
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Object[] getArgs() {
            return args;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Function2 getBigScreen() {
            return bigScreen;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public String getRoute() {
            return route;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Function2 getScreen() {
            return screen;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public void setArgs(Object[] objArr) {
            y.i(objArr, "<set-?>");
            args = objArr;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @StabilityInferred(parameters = 0)
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096D¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR*\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R%\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\b\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R%\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\b\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcu/todus/android/uiCompose/navigation/NavDestinations$ChatCardDest;", "Lcu/todus/android/uiCompose/navigation/NavDestinations$AppDestination;", "<init>", "()V", "", "route", "Ljava/lang/String;", "getRoute", "()Ljava/lang/String;", "", "", "args", "[Ljava/lang/Object;", "getArgs", "()[Ljava/lang/Object;", "setArgs", "([Ljava/lang/Object;)V", "Lkotlin/Function0;", "Lua/k0;", "Landroidx/compose/runtime/Composable;", "screen", "Lkotlin/jvm/functions/Function2;", "getScreen", "()Lkotlin/jvm/functions/Function2;", "bigScreen", "getBigScreen", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class ChatCardDest implements AppDestination {
        public static final int $stable;
        private static final Function2 bigScreen;
        private static final Function2 screen;
        public static final ChatCardDest INSTANCE = new ChatCardDest();
        private static final String route = NavLinks.CHAT_CARD;
        private static Object[] args = new Object[0];

        static {
            ComposableSingletons$NavDestinationsKt composableSingletons$NavDestinationsKt = ComposableSingletons$NavDestinationsKt.INSTANCE;
            screen = composableSingletons$NavDestinationsKt.m10062getLambda$746183516$app_productionPFast();
            bigScreen = composableSingletons$NavDestinationsKt.getLambda$697175286$app_productionPFast();
            $stable = 8;
        }

        private ChatCardDest() {
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Object[] getArgs() {
            return args;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Function2 getBigScreen() {
            return bigScreen;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public String getRoute() {
            return route;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Function2 getScreen() {
            return screen;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public void setArgs(Object[] objArr) {
            y.i(objArr, "<set-?>");
            args = objArr;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @StabilityInferred(parameters = 0)
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096D¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR*\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R%\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\b\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R%\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\b\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcu/todus/android/uiCompose/navigation/NavDestinations$ChatChannelDest;", "Lcu/todus/android/uiCompose/navigation/NavDestinations$AppDestination;", "<init>", "()V", "", "route", "Ljava/lang/String;", "getRoute", "()Ljava/lang/String;", "", "", "args", "[Ljava/lang/Object;", "getArgs", "()[Ljava/lang/Object;", "setArgs", "([Ljava/lang/Object;)V", "Lkotlin/Function0;", "Lua/k0;", "Landroidx/compose/runtime/Composable;", "screen", "Lkotlin/jvm/functions/Function2;", "getScreen", "()Lkotlin/jvm/functions/Function2;", "bigScreen", "getBigScreen", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class ChatChannelDest implements AppDestination {
        public static final int $stable;
        private static final Function2 bigScreen;
        private static final Function2 screen;
        public static final ChatChannelDest INSTANCE = new ChatChannelDest();
        private static final String route = NavLinks.CHAT_CHANNEL;
        private static Object[] args = new Object[0];

        static {
            ComposableSingletons$NavDestinationsKt composableSingletons$NavDestinationsKt = ComposableSingletons$NavDestinationsKt.INSTANCE;
            screen = composableSingletons$NavDestinationsKt.getLambda$1652674281$app_productionPFast();
            bigScreen = composableSingletons$NavDestinationsKt.m10051getLambda$457822889$app_productionPFast();
            $stable = 8;
        }

        private ChatChannelDest() {
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Object[] getArgs() {
            return args;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Function2 getBigScreen() {
            return bigScreen;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public String getRoute() {
            return route;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Function2 getScreen() {
            return screen;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public void setArgs(Object[] objArr) {
            y.i(objArr, "<set-?>");
            args = objArr;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @StabilityInferred(parameters = 0)
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096D¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR*\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R%\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\b\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R%\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\b\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcu/todus/android/uiCompose/navigation/NavDestinations$ChatGroupDest;", "Lcu/todus/android/uiCompose/navigation/NavDestinations$AppDestination;", "<init>", "()V", "", "route", "Ljava/lang/String;", "getRoute", "()Ljava/lang/String;", "", "", "args", "[Ljava/lang/Object;", "getArgs", "()[Ljava/lang/Object;", "setArgs", "([Ljava/lang/Object;)V", "Lkotlin/Function0;", "Lua/k0;", "Landroidx/compose/runtime/Composable;", "screen", "Lkotlin/jvm/functions/Function2;", "getScreen", "()Lkotlin/jvm/functions/Function2;", "bigScreen", "getBigScreen", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class ChatGroupDest implements AppDestination {
        public static final int $stable;
        private static final Function2 bigScreen;
        private static final Function2 screen;
        public static final ChatGroupDest INSTANCE = new ChatGroupDest();
        private static final String route = NavLinks.CHAT_GROUP;
        private static Object[] args = new Object[0];

        static {
            ComposableSingletons$NavDestinationsKt composableSingletons$NavDestinationsKt = ComposableSingletons$NavDestinationsKt.INSTANCE;
            screen = composableSingletons$NavDestinationsKt.m10037getLambda$1993150299$app_productionPFast();
            bigScreen = composableSingletons$NavDestinationsKt.m10035getLambda$198700397$app_productionPFast();
            $stable = 8;
        }

        private ChatGroupDest() {
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Object[] getArgs() {
            return args;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Function2 getBigScreen() {
            return bigScreen;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public String getRoute() {
            return route;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Function2 getScreen() {
            return screen;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public void setArgs(Object[] objArr) {
            y.i(objArr, "<set-?>");
            args = objArr;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @StabilityInferred(parameters = 0)
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096D¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR*\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R%\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\b\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R%\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\b\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcu/todus/android/uiCompose/navigation/NavDestinations$ChatP2PDest;", "Lcu/todus/android/uiCompose/navigation/NavDestinations$AppDestination;", "<init>", "()V", "", "route", "Ljava/lang/String;", "getRoute", "()Ljava/lang/String;", "", "", "args", "[Ljava/lang/Object;", "getArgs", "()[Ljava/lang/Object;", "setArgs", "([Ljava/lang/Object;)V", "Lkotlin/Function0;", "Lua/k0;", "Landroidx/compose/runtime/Composable;", "screen", "Lkotlin/jvm/functions/Function2;", "getScreen", "()Lkotlin/jvm/functions/Function2;", "bigScreen", "getBigScreen", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class ChatP2PDest implements AppDestination {
        public static final int $stable;
        private static final Function2 bigScreen;
        private static final Function2 screen;
        public static final ChatP2PDest INSTANCE = new ChatP2PDest();
        private static final String route = NavLinks.CHAT_P2P;
        private static Object[] args = new Object[0];

        static {
            ComposableSingletons$NavDestinationsKt composableSingletons$NavDestinationsKt = ComposableSingletons$NavDestinationsKt.INSTANCE;
            screen = composableSingletons$NavDestinationsKt.m10007getLambda$1238164812$app_productionPFast();
            bigScreen = composableSingletons$NavDestinationsKt.m10054getLambda$498868190$app_productionPFast();
            $stable = 8;
        }

        private ChatP2PDest() {
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Object[] getArgs() {
            return args;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Function2 getBigScreen() {
            return bigScreen;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public String getRoute() {
            return route;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Function2 getScreen() {
            return screen;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public void setArgs(Object[] objArr) {
            y.i(objArr, "<set-?>");
            args = objArr;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @StabilityInferred(parameters = 0)
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096D¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR*\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R%\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\b\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R%\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\b\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcu/todus/android/uiCompose/navigation/NavDestinations$ChatResourcesDest;", "Lcu/todus/android/uiCompose/navigation/NavDestinations$AppDestination;", "<init>", "()V", "", "route", "Ljava/lang/String;", "getRoute", "()Ljava/lang/String;", "", "", "args", "[Ljava/lang/Object;", "getArgs", "()[Ljava/lang/Object;", "setArgs", "([Ljava/lang/Object;)V", "Lkotlin/Function0;", "Lua/k0;", "Landroidx/compose/runtime/Composable;", "screen", "Lkotlin/jvm/functions/Function2;", "getScreen", "()Lkotlin/jvm/functions/Function2;", "bigScreen", "getBigScreen", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class ChatResourcesDest implements AppDestination {
        public static final int $stable;
        private static final Function2 bigScreen;
        private static final Function2 screen;
        public static final ChatResourcesDest INSTANCE = new ChatResourcesDest();
        private static final String route = NavLinks.CHAT_RESOURCES;
        private static Object[] args = new Object[0];

        static {
            ComposableSingletons$NavDestinationsKt composableSingletons$NavDestinationsKt = ComposableSingletons$NavDestinationsKt.INSTANCE;
            screen = composableSingletons$NavDestinationsKt.getLambda$109907659$app_productionPFast();
            bigScreen = composableSingletons$NavDestinationsKt.m10066getLambda$853308999$app_productionPFast();
            $stable = 8;
        }

        private ChatResourcesDest() {
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Object[] getArgs() {
            return args;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Function2 getBigScreen() {
            return bigScreen;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public String getRoute() {
            return route;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Function2 getScreen() {
            return screen;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public void setArgs(Object[] objArr) {
            y.i(objArr, "<set-?>");
            args = objArr;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @StabilityInferred(parameters = 0)
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096D¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR*\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R%\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\b\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R%\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\b\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcu/todus/android/uiCompose/navigation/NavDestinations$ContactsPermissionDest;", "Lcu/todus/android/uiCompose/navigation/NavDestinations$AppDestination;", "<init>", "()V", "", "route", "Ljava/lang/String;", "getRoute", "()Ljava/lang/String;", "", "", "args", "[Ljava/lang/Object;", "getArgs", "()[Ljava/lang/Object;", "setArgs", "([Ljava/lang/Object;)V", "Lkotlin/Function0;", "Lua/k0;", "Landroidx/compose/runtime/Composable;", "screen", "Lkotlin/jvm/functions/Function2;", "getScreen", "()Lkotlin/jvm/functions/Function2;", "bigScreen", "getBigScreen", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class ContactsPermissionDest implements AppDestination {
        public static final int $stable;
        private static final Function2 bigScreen;
        private static final Function2 screen;
        public static final ContactsPermissionDest INSTANCE = new ContactsPermissionDest();
        private static final String route = NavLinks.CONTACTS_PERMISSION;
        private static Object[] args = new Object[0];

        static {
            ComposableSingletons$NavDestinationsKt composableSingletons$NavDestinationsKt = ComposableSingletons$NavDestinationsKt.INSTANCE;
            screen = composableSingletons$NavDestinationsKt.m10048getLambda$346924322$app_productionPFast();
            bigScreen = composableSingletons$NavDestinationsKt.m10027getLambda$1747352400$app_productionPFast();
            $stable = 8;
        }

        private ContactsPermissionDest() {
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Object[] getArgs() {
            return args;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Function2 getBigScreen() {
            return bigScreen;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public String getRoute() {
            return route;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Function2 getScreen() {
            return screen;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public void setArgs(Object[] objArr) {
            y.i(objArr, "<set-?>");
            args = objArr;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @StabilityInferred(parameters = 0)
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096D¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR*\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R%\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\b\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R%\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\b\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcu/todus/android/uiCompose/navigation/NavDestinations$CreateChannelDest;", "Lcu/todus/android/uiCompose/navigation/NavDestinations$AppDestination;", "<init>", "()V", "", "route", "Ljava/lang/String;", "getRoute", "()Ljava/lang/String;", "", "", "args", "[Ljava/lang/Object;", "getArgs", "()[Ljava/lang/Object;", "setArgs", "([Ljava/lang/Object;)V", "Lkotlin/Function0;", "Lua/k0;", "Landroidx/compose/runtime/Composable;", "screen", "Lkotlin/jvm/functions/Function2;", "getScreen", "()Lkotlin/jvm/functions/Function2;", "bigScreen", "getBigScreen", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class CreateChannelDest implements AppDestination {
        public static final int $stable;
        private static final Function2 bigScreen;
        private static final Function2 screen;
        public static final CreateChannelDest INSTANCE = new CreateChannelDest();
        private static final String route = NavLinks.CREATE_CHANNEL;
        private static Object[] args = new Object[0];

        static {
            ComposableSingletons$NavDestinationsKt composableSingletons$NavDestinationsKt = ComposableSingletons$NavDestinationsKt.INSTANCE;
            screen = composableSingletons$NavDestinationsKt.m10017getLambda$1468180859$app_productionPFast();
            bigScreen = composableSingletons$NavDestinationsKt.getLambda$1863569779$app_productionPFast();
            $stable = 8;
        }

        private CreateChannelDest() {
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Object[] getArgs() {
            return args;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Function2 getBigScreen() {
            return bigScreen;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public String getRoute() {
            return route;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Function2 getScreen() {
            return screen;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public void setArgs(Object[] objArr) {
            y.i(objArr, "<set-?>");
            args = objArr;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @StabilityInferred(parameters = 0)
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096D¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR*\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R%\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\b\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R%\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\b\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcu/todus/android/uiCompose/navigation/NavDestinations$CreateGroupStep1SelectionDest;", "Lcu/todus/android/uiCompose/navigation/NavDestinations$AppDestination;", "<init>", "()V", "", "route", "Ljava/lang/String;", "getRoute", "()Ljava/lang/String;", "", "", "args", "[Ljava/lang/Object;", "getArgs", "()[Ljava/lang/Object;", "setArgs", "([Ljava/lang/Object;)V", "Lkotlin/Function0;", "Lua/k0;", "Landroidx/compose/runtime/Composable;", "screen", "Lkotlin/jvm/functions/Function2;", "getScreen", "()Lkotlin/jvm/functions/Function2;", "bigScreen", "getBigScreen", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class CreateGroupStep1SelectionDest implements AppDestination {
        public static final int $stable;
        private static final Function2 bigScreen;
        private static final Function2 screen;
        public static final CreateGroupStep1SelectionDest INSTANCE = new CreateGroupStep1SelectionDest();
        private static final String route = NavLinks.CREATE_GROUP_STEP1_SELECTION;
        private static Object[] args = new Object[0];

        static {
            ComposableSingletons$NavDestinationsKt composableSingletons$NavDestinationsKt = ComposableSingletons$NavDestinationsKt.INSTANCE;
            screen = composableSingletons$NavDestinationsKt.m10073getLambda$961740792$app_productionPFast();
            bigScreen = composableSingletons$NavDestinationsKt.m10031getLambda$1960016394$app_productionPFast();
            $stable = 8;
        }

        private CreateGroupStep1SelectionDest() {
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Object[] getArgs() {
            return args;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Function2 getBigScreen() {
            return bigScreen;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public String getRoute() {
            return route;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Function2 getScreen() {
            return screen;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public void setArgs(Object[] objArr) {
            y.i(objArr, "<set-?>");
            args = objArr;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @StabilityInferred(parameters = 0)
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096D¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR*\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R%\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\b\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R%\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\b\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcu/todus/android/uiCompose/navigation/NavDestinations$CreateGroupStep2ConfigurationDest;", "Lcu/todus/android/uiCompose/navigation/NavDestinations$AppDestination;", "<init>", "()V", "", "route", "Ljava/lang/String;", "getRoute", "()Ljava/lang/String;", "", "", "args", "[Ljava/lang/Object;", "getArgs", "()[Ljava/lang/Object;", "setArgs", "([Ljava/lang/Object;)V", "Lkotlin/Function0;", "Lua/k0;", "Landroidx/compose/runtime/Composable;", "screen", "Lkotlin/jvm/functions/Function2;", "getScreen", "()Lkotlin/jvm/functions/Function2;", "bigScreen", "getBigScreen", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class CreateGroupStep2ConfigurationDest implements AppDestination {
        public static final int $stable;
        private static final Function2 bigScreen;
        private static final Function2 screen;
        public static final CreateGroupStep2ConfigurationDest INSTANCE = new CreateGroupStep2ConfigurationDest();
        private static final String route = NavLinks.CREATE_GROUP_STEP2_CONFIGURATION;
        private static Object[] args = new Object[0];

        static {
            ComposableSingletons$NavDestinationsKt composableSingletons$NavDestinationsKt = ComposableSingletons$NavDestinationsKt.INSTANCE;
            screen = composableSingletons$NavDestinationsKt.getLambda$607555089$app_productionPFast();
            bigScreen = composableSingletons$NavDestinationsKt.m10043getLambda$259691265$app_productionPFast();
            $stable = 8;
        }

        private CreateGroupStep2ConfigurationDest() {
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Object[] getArgs() {
            return args;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Function2 getBigScreen() {
            return bigScreen;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public String getRoute() {
            return route;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Function2 getScreen() {
            return screen;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public void setArgs(Object[] objArr) {
            y.i(objArr, "<set-?>");
            args = objArr;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @StabilityInferred(parameters = 0)
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096D¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR*\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R%\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\b\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R%\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\b\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcu/todus/android/uiCompose/navigation/NavDestinations$DataPreferencesDest;", "Lcu/todus/android/uiCompose/navigation/NavDestinations$AppDestination;", "<init>", "()V", "", "route", "Ljava/lang/String;", "getRoute", "()Ljava/lang/String;", "", "", "args", "[Ljava/lang/Object;", "getArgs", "()[Ljava/lang/Object;", "setArgs", "([Ljava/lang/Object;)V", "Lkotlin/Function0;", "Lua/k0;", "Landroidx/compose/runtime/Composable;", "screen", "Lkotlin/jvm/functions/Function2;", "getScreen", "()Lkotlin/jvm/functions/Function2;", "bigScreen", "getBigScreen", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class DataPreferencesDest implements AppDestination {
        public static final int $stable;
        private static final Function2 bigScreen;
        private static final Function2 screen;
        public static final DataPreferencesDest INSTANCE = new DataPreferencesDest();
        private static final String route = NavLinks.DATA_PREFERENCES;
        private static Object[] args = new Object[0];

        static {
            ComposableSingletons$NavDestinationsKt composableSingletons$NavDestinationsKt = ComposableSingletons$NavDestinationsKt.INSTANCE;
            screen = composableSingletons$NavDestinationsKt.getLambda$491916876$app_productionPFast();
            bigScreen = composableSingletons$NavDestinationsKt.m10026getLambda$1741322822$app_productionPFast();
            $stable = 8;
        }

        private DataPreferencesDest() {
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Object[] getArgs() {
            return args;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Function2 getBigScreen() {
            return bigScreen;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public String getRoute() {
            return route;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Function2 getScreen() {
            return screen;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public void setArgs(Object[] objArr) {
            y.i(objArr, "<set-?>");
            args = objArr;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @StabilityInferred(parameters = 0)
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096D¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR*\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R%\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\b\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R%\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\b\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcu/todus/android/uiCompose/navigation/NavDestinations$DateEditorDest;", "Lcu/todus/android/uiCompose/navigation/NavDestinations$AppDestination;", "<init>", "()V", "", "route", "Ljava/lang/String;", "getRoute", "()Ljava/lang/String;", "", "", "args", "[Ljava/lang/Object;", "getArgs", "()[Ljava/lang/Object;", "setArgs", "([Ljava/lang/Object;)V", "Lkotlin/Function0;", "Lua/k0;", "Landroidx/compose/runtime/Composable;", "screen", "Lkotlin/jvm/functions/Function2;", "getScreen", "()Lkotlin/jvm/functions/Function2;", "bigScreen", "getBigScreen", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class DateEditorDest implements AppDestination {
        public static final int $stable;
        private static final Function2 bigScreen;
        private static final Function2 screen;
        public static final DateEditorDest INSTANCE = new DateEditorDest();
        private static final String route = NavLinks.DATE_EDITOR;
        private static Object[] args = new Object[0];

        static {
            ComposableSingletons$NavDestinationsKt composableSingletons$NavDestinationsKt = ComposableSingletons$NavDestinationsKt.INSTANCE;
            screen = composableSingletons$NavDestinationsKt.getLambda$858660503$app_productionPFast();
            bigScreen = composableSingletons$NavDestinationsKt.getLambda$652032617$app_productionPFast();
            $stable = 8;
        }

        private DateEditorDest() {
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Object[] getArgs() {
            return args;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Function2 getBigScreen() {
            return bigScreen;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public String getRoute() {
            return route;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Function2 getScreen() {
            return screen;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public void setArgs(Object[] objArr) {
            y.i(objArr, "<set-?>");
            args = objArr;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @StabilityInferred(parameters = 0)
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096D¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR*\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R%\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\b\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R%\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\b\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcu/todus/android/uiCompose/navigation/NavDestinations$EditProfileDest;", "Lcu/todus/android/uiCompose/navigation/NavDestinations$AppDestination;", "<init>", "()V", "", "route", "Ljava/lang/String;", "getRoute", "()Ljava/lang/String;", "", "", "args", "[Ljava/lang/Object;", "getArgs", "()[Ljava/lang/Object;", "setArgs", "([Ljava/lang/Object;)V", "Lkotlin/Function0;", "Lua/k0;", "Landroidx/compose/runtime/Composable;", "screen", "Lkotlin/jvm/functions/Function2;", "getScreen", "()Lkotlin/jvm/functions/Function2;", "bigScreen", "getBigScreen", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class EditProfileDest implements AppDestination {
        public static final int $stable;
        private static final Function2 bigScreen;
        private static final Function2 screen;
        public static final EditProfileDest INSTANCE = new EditProfileDest();
        private static final String route = NavLinks.EDIT_PROFILE;
        private static Object[] args = new Object[0];

        static {
            ComposableSingletons$NavDestinationsKt composableSingletons$NavDestinationsKt = ComposableSingletons$NavDestinationsKt.INSTANCE;
            screen = composableSingletons$NavDestinationsKt.getLambda$480738973$app_productionPFast();
            bigScreen = composableSingletons$NavDestinationsKt.m10025getLambda$1629758197$app_productionPFast();
            $stable = 8;
        }

        private EditProfileDest() {
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Object[] getArgs() {
            return args;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Function2 getBigScreen() {
            return bigScreen;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public String getRoute() {
            return route;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Function2 getScreen() {
            return screen;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public void setArgs(Object[] objArr) {
            y.i(objArr, "<set-?>");
            args = objArr;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @StabilityInferred(parameters = 0)
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096D¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR*\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R%\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\b\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R%\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\b\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcu/todus/android/uiCompose/navigation/NavDestinations$EditToDusIdDest;", "Lcu/todus/android/uiCompose/navigation/NavDestinations$AppDestination;", "<init>", "()V", "", "route", "Ljava/lang/String;", "getRoute", "()Ljava/lang/String;", "", "", "args", "[Ljava/lang/Object;", "getArgs", "()[Ljava/lang/Object;", "setArgs", "([Ljava/lang/Object;)V", "Lkotlin/Function0;", "Lua/k0;", "Landroidx/compose/runtime/Composable;", "screen", "Lkotlin/jvm/functions/Function2;", "getScreen", "()Lkotlin/jvm/functions/Function2;", "bigScreen", "getBigScreen", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class EditToDusIdDest implements AppDestination {
        public static final int $stable;
        private static final Function2 bigScreen;
        private static final Function2 screen;
        public static final EditToDusIdDest INSTANCE = new EditToDusIdDest();
        private static final String route = NavLinks.EDIT_TODUS_ID;
        private static Object[] args = new Object[0];

        static {
            ComposableSingletons$NavDestinationsKt composableSingletons$NavDestinationsKt = ComposableSingletons$NavDestinationsKt.INSTANCE;
            screen = composableSingletons$NavDestinationsKt.m10013getLambda$1415345546$app_productionPFast();
            bigScreen = composableSingletons$NavDestinationsKt.getLambda$769124580$app_productionPFast();
            $stable = 8;
        }

        private EditToDusIdDest() {
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Object[] getArgs() {
            return args;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Function2 getBigScreen() {
            return bigScreen;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public String getRoute() {
            return route;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Function2 getScreen() {
            return screen;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public void setArgs(Object[] objArr) {
            y.i(objArr, "<set-?>");
            args = objArr;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @StabilityInferred(parameters = 0)
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096D¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR*\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R%\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\b\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R%\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\b\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcu/todus/android/uiCompose/navigation/NavDestinations$FirstOpenDest;", "Lcu/todus/android/uiCompose/navigation/NavDestinations$AppDestination;", "<init>", "()V", "", "route", "Ljava/lang/String;", "getRoute", "()Ljava/lang/String;", "", "", "args", "[Ljava/lang/Object;", "getArgs", "()[Ljava/lang/Object;", "setArgs", "([Ljava/lang/Object;)V", "Lkotlin/Function0;", "Lua/k0;", "Landroidx/compose/runtime/Composable;", "screen", "Lkotlin/jvm/functions/Function2;", "getScreen", "()Lkotlin/jvm/functions/Function2;", "bigScreen", "getBigScreen", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class FirstOpenDest implements AppDestination {
        public static final int $stable;
        private static final Function2 bigScreen;
        private static final Function2 screen;
        public static final FirstOpenDest INSTANCE = new FirstOpenDest();
        private static final String route = NavLinks.FIRST_OPEN;
        private static Object[] args = new Object[0];

        static {
            ComposableSingletons$NavDestinationsKt composableSingletons$NavDestinationsKt = ComposableSingletons$NavDestinationsKt.INSTANCE;
            screen = composableSingletons$NavDestinationsKt.m10021getLambda$1569580744$app_productionPFast();
            bigScreen = composableSingletons$NavDestinationsKt.getLambda$224869158$app_productionPFast();
            $stable = 8;
        }

        private FirstOpenDest() {
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Object[] getArgs() {
            return args;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Function2 getBigScreen() {
            return bigScreen;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public String getRoute() {
            return route;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Function2 getScreen() {
            return screen;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public void setArgs(Object[] objArr) {
            y.i(objArr, "<set-?>");
            args = objArr;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @StabilityInferred(parameters = 0)
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096D¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR*\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R%\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\b\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R%\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\b\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcu/todus/android/uiCompose/navigation/NavDestinations$ForwardToDest;", "Lcu/todus/android/uiCompose/navigation/NavDestinations$AppDestination;", "<init>", "()V", "", "route", "Ljava/lang/String;", "getRoute", "()Ljava/lang/String;", "", "", "args", "[Ljava/lang/Object;", "getArgs", "()[Ljava/lang/Object;", "setArgs", "([Ljava/lang/Object;)V", "Lkotlin/Function0;", "Lua/k0;", "Landroidx/compose/runtime/Composable;", "screen", "Lkotlin/jvm/functions/Function2;", "getScreen", "()Lkotlin/jvm/functions/Function2;", "bigScreen", "getBigScreen", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class ForwardToDest implements AppDestination {
        public static final int $stable;
        private static final Function2 bigScreen;
        private static final Function2 screen;
        public static final ForwardToDest INSTANCE = new ForwardToDest();
        private static final String route = NavLinks.FORWARD_TO;
        private static Object[] args = new Object[0];

        static {
            ComposableSingletons$NavDestinationsKt composableSingletons$NavDestinationsKt = ComposableSingletons$NavDestinationsKt.INSTANCE;
            screen = composableSingletons$NavDestinationsKt.getLambda$1883123518$app_productionPFast();
            bigScreen = composableSingletons$NavDestinationsKt.m10057getLambda$617393876$app_productionPFast();
            $stable = 8;
        }

        private ForwardToDest() {
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Object[] getArgs() {
            return args;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Function2 getBigScreen() {
            return bigScreen;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public String getRoute() {
            return route;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Function2 getScreen() {
            return screen;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public void setArgs(Object[] objArr) {
            y.i(objArr, "<set-?>");
            args = objArr;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @StabilityInferred(parameters = 0)
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096D¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR*\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R%\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\b\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R%\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\b\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcu/todus/android/uiCompose/navigation/NavDestinations$HomeDest;", "Lcu/todus/android/uiCompose/navigation/NavDestinations$AppDestination;", "<init>", "()V", "", "route", "Ljava/lang/String;", "getRoute", "()Ljava/lang/String;", "", "", "args", "[Ljava/lang/Object;", "getArgs", "()[Ljava/lang/Object;", "setArgs", "([Ljava/lang/Object;)V", "Lkotlin/Function0;", "Lua/k0;", "Landroidx/compose/runtime/Composable;", "screen", "Lkotlin/jvm/functions/Function2;", "getScreen", "()Lkotlin/jvm/functions/Function2;", "bigScreen", "getBigScreen", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class HomeDest implements AppDestination {
        public static final int $stable;
        private static final Function2 bigScreen;
        private static final Function2 screen;
        public static final HomeDest INSTANCE = new HomeDest();
        private static final String route = NavLinks.HOME;
        private static Object[] args = new Object[0];

        static {
            ComposableSingletons$NavDestinationsKt composableSingletons$NavDestinationsKt = ComposableSingletons$NavDestinationsKt.INSTANCE;
            screen = composableSingletons$NavDestinationsKt.getLambda$831717883$app_productionPFast();
            bigScreen = composableSingletons$NavDestinationsKt.m10045getLambda$294657203$app_productionPFast();
            $stable = 8;
        }

        private HomeDest() {
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Object[] getArgs() {
            return args;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Function2 getBigScreen() {
            return bigScreen;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public String getRoute() {
            return route;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Function2 getScreen() {
            return screen;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public void setArgs(Object[] objArr) {
            y.i(objArr, "<set-?>");
            args = objArr;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @StabilityInferred(parameters = 0)
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096D¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR*\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R%\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\b\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R%\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\b\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcu/todus/android/uiCompose/navigation/NavDestinations$InitInfoProfileDest;", "Lcu/todus/android/uiCompose/navigation/NavDestinations$AppDestination;", "<init>", "()V", "", "route", "Ljava/lang/String;", "getRoute", "()Ljava/lang/String;", "", "", "args", "[Ljava/lang/Object;", "getArgs", "()[Ljava/lang/Object;", "setArgs", "([Ljava/lang/Object;)V", "Lkotlin/Function0;", "Lua/k0;", "Landroidx/compose/runtime/Composable;", "screen", "Lkotlin/jvm/functions/Function2;", "getScreen", "()Lkotlin/jvm/functions/Function2;", "bigScreen", "getBigScreen", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class InitInfoProfileDest implements AppDestination {
        public static final int $stable;
        private static final Function2 bigScreen;
        private static final Function2 screen;
        public static final InitInfoProfileDest INSTANCE = new InitInfoProfileDest();
        private static final String route = NavLinks.INIT_INFO_PROFILE;
        private static Object[] args = new Object[0];

        static {
            ComposableSingletons$NavDestinationsKt composableSingletons$NavDestinationsKt = ComposableSingletons$NavDestinationsKt.INSTANCE;
            screen = composableSingletons$NavDestinationsKt.getLambda$429630921$app_productionPFast();
            bigScreen = composableSingletons$NavDestinationsKt.m10028getLambda$1803608777$app_productionPFast();
            $stable = 8;
        }

        private InitInfoProfileDest() {
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Object[] getArgs() {
            return args;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Function2 getBigScreen() {
            return bigScreen;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public String getRoute() {
            return route;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Function2 getScreen() {
            return screen;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public void setArgs(Object[] objArr) {
            y.i(objArr, "<set-?>");
            args = objArr;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @StabilityInferred(parameters = 0)
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096D¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR*\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R%\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\b\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R%\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\b\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcu/todus/android/uiCompose/navigation/NavDestinations$JoinRoomDest;", "Lcu/todus/android/uiCompose/navigation/NavDestinations$AppDestination;", "<init>", "()V", "", "route", "Ljava/lang/String;", "getRoute", "()Ljava/lang/String;", "", "", "args", "[Ljava/lang/Object;", "getArgs", "()[Ljava/lang/Object;", "setArgs", "([Ljava/lang/Object;)V", "Lkotlin/Function0;", "Lua/k0;", "Landroidx/compose/runtime/Composable;", "screen", "Lkotlin/jvm/functions/Function2;", "getScreen", "()Lkotlin/jvm/functions/Function2;", "bigScreen", "getBigScreen", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class JoinRoomDest implements AppDestination {
        public static final int $stable;
        private static final Function2 bigScreen;
        private static final Function2 screen;
        public static final JoinRoomDest INSTANCE = new JoinRoomDest();
        private static final String route = NavLinks.JOIN_ROOM;
        private static Object[] args = new Object[0];

        static {
            ComposableSingletons$NavDestinationsKt composableSingletons$NavDestinationsKt = ComposableSingletons$NavDestinationsKt.INSTANCE;
            screen = composableSingletons$NavDestinationsKt.m10063getLambda$790759999$app_productionPFast();
            bigScreen = composableSingletons$NavDestinationsKt.getLambda$652598803$app_productionPFast();
            $stable = 8;
        }

        private JoinRoomDest() {
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Object[] getArgs() {
            return args;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Function2 getBigScreen() {
            return bigScreen;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public String getRoute() {
            return route;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Function2 getScreen() {
            return screen;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public void setArgs(Object[] objArr) {
            y.i(objArr, "<set-?>");
            args = objArr;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @StabilityInferred(parameters = 0)
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096D¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR*\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R%\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\b\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R%\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\b\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcu/todus/android/uiCompose/navigation/NavDestinations$LinkedDeviceDest;", "Lcu/todus/android/uiCompose/navigation/NavDestinations$AppDestination;", "<init>", "()V", "", "route", "Ljava/lang/String;", "getRoute", "()Ljava/lang/String;", "", "", "args", "[Ljava/lang/Object;", "getArgs", "()[Ljava/lang/Object;", "setArgs", "([Ljava/lang/Object;)V", "Lkotlin/Function0;", "Lua/k0;", "Landroidx/compose/runtime/Composable;", "screen", "Lkotlin/jvm/functions/Function2;", "getScreen", "()Lkotlin/jvm/functions/Function2;", "bigScreen", "getBigScreen", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class LinkedDeviceDest implements AppDestination {
        public static final int $stable;
        private static final Function2 bigScreen;
        private static final Function2 screen;
        public static final LinkedDeviceDest INSTANCE = new LinkedDeviceDest();
        private static final String route = "linked_device";
        private static Object[] args = new Object[0];

        static {
            ComposableSingletons$NavDestinationsKt composableSingletons$NavDestinationsKt = ComposableSingletons$NavDestinationsKt.INSTANCE;
            screen = composableSingletons$NavDestinationsKt.m10050getLambda$441360405$app_productionPFast();
            bigScreen = composableSingletons$NavDestinationsKt.m10016getLambda$1442263235$app_productionPFast();
            $stable = 8;
        }

        private LinkedDeviceDest() {
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Object[] getArgs() {
            return args;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Function2 getBigScreen() {
            return bigScreen;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public String getRoute() {
            return route;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Function2 getScreen() {
            return screen;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public void setArgs(Object[] objArr) {
            y.i(objArr, "<set-?>");
            args = objArr;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @StabilityInferred(parameters = 0)
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096D¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR*\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R%\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\b\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R%\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\b\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcu/todus/android/uiCompose/navigation/NavDestinations$LoadingDest;", "Lcu/todus/android/uiCompose/navigation/NavDestinations$AppDestination;", "<init>", "()V", "", "route", "Ljava/lang/String;", "getRoute", "()Ljava/lang/String;", "", "", "args", "[Ljava/lang/Object;", "getArgs", "()[Ljava/lang/Object;", "setArgs", "([Ljava/lang/Object;)V", "Lkotlin/Function0;", "Lua/k0;", "Landroidx/compose/runtime/Composable;", "screen", "Lkotlin/jvm/functions/Function2;", "getScreen", "()Lkotlin/jvm/functions/Function2;", "bigScreen", "getBigScreen", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class LoadingDest implements AppDestination {
        public static final int $stable;
        private static final Function2 bigScreen;
        private static final Function2 screen;
        public static final LoadingDest INSTANCE = new LoadingDest();
        private static final String route = NavLinks.LOADING;
        private static Object[] args = new Object[0];

        static {
            ComposableSingletons$NavDestinationsKt composableSingletons$NavDestinationsKt = ComposableSingletons$NavDestinationsKt.INSTANCE;
            screen = composableSingletons$NavDestinationsKt.getLambda$2000377498$app_productionPFast();
            bigScreen = composableSingletons$NavDestinationsKt.m10019getLambda$1555293176$app_productionPFast();
            $stable = 8;
        }

        private LoadingDest() {
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Object[] getArgs() {
            return args;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Function2 getBigScreen() {
            return bigScreen;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public String getRoute() {
            return route;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Function2 getScreen() {
            return screen;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public void setArgs(Object[] objArr) {
            y.i(objArr, "<set-?>");
            args = objArr;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @StabilityInferred(parameters = 0)
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096D¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR*\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R%\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\b\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R%\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\b\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcu/todus/android/uiCompose/navigation/NavDestinations$LogoutDest;", "Lcu/todus/android/uiCompose/navigation/NavDestinations$AppDestination;", "<init>", "()V", "", "route", "Ljava/lang/String;", "getRoute", "()Ljava/lang/String;", "", "", "args", "[Ljava/lang/Object;", "getArgs", "()[Ljava/lang/Object;", "setArgs", "([Ljava/lang/Object;)V", "Lkotlin/Function0;", "Lua/k0;", "Landroidx/compose/runtime/Composable;", "screen", "Lkotlin/jvm/functions/Function2;", "getScreen", "()Lkotlin/jvm/functions/Function2;", "bigScreen", "getBigScreen", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class LogoutDest implements AppDestination {
        public static final int $stable;
        private static final Function2 bigScreen;
        private static final Function2 screen;
        public static final LogoutDest INSTANCE = new LogoutDest();
        private static final String route = "logout";
        private static Object[] args = new Object[0];

        static {
            ComposableSingletons$NavDestinationsKt composableSingletons$NavDestinationsKt = ComposableSingletons$NavDestinationsKt.INSTANCE;
            screen = composableSingletons$NavDestinationsKt.getLambda$1540467814$app_productionPFast();
            bigScreen = composableSingletons$NavDestinationsKt.getLambda$1425768760$app_productionPFast();
            $stable = 8;
        }

        private LogoutDest() {
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Object[] getArgs() {
            return args;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Function2 getBigScreen() {
            return bigScreen;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public String getRoute() {
            return route;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Function2 getScreen() {
            return screen;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public void setArgs(Object[] objArr) {
            y.i(objArr, "<set-?>");
            args = objArr;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @StabilityInferred(parameters = 0)
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096D¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR*\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R%\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\b\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R%\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\b\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcu/todus/android/uiCompose/navigation/NavDestinations$ManageBackupDest;", "Lcu/todus/android/uiCompose/navigation/NavDestinations$AppDestination;", "<init>", "()V", "", "route", "Ljava/lang/String;", "getRoute", "()Ljava/lang/String;", "", "", "args", "[Ljava/lang/Object;", "getArgs", "()[Ljava/lang/Object;", "setArgs", "([Ljava/lang/Object;)V", "Lkotlin/Function0;", "Lua/k0;", "Landroidx/compose/runtime/Composable;", "screen", "Lkotlin/jvm/functions/Function2;", "getScreen", "()Lkotlin/jvm/functions/Function2;", "bigScreen", "getBigScreen", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class ManageBackupDest implements AppDestination {
        public static final int $stable;
        private static final Function2 bigScreen;
        private static final Function2 screen;
        public static final ManageBackupDest INSTANCE = new ManageBackupDest();
        private static final String route = NavLinks.MANAGE_BACKUP;
        private static Object[] args = new Object[0];

        static {
            ComposableSingletons$NavDestinationsKt composableSingletons$NavDestinationsKt = ComposableSingletons$NavDestinationsKt.INSTANCE;
            screen = composableSingletons$NavDestinationsKt.m10056getLambda$589823581$app_productionPFast();
            bigScreen = composableSingletons$NavDestinationsKt.m10022getLambda$1590726411$app_productionPFast();
            $stable = 8;
        }

        private ManageBackupDest() {
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Object[] getArgs() {
            return args;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Function2 getBigScreen() {
            return bigScreen;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public String getRoute() {
            return route;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Function2 getScreen() {
            return screen;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public void setArgs(Object[] objArr) {
            y.i(objArr, "<set-?>");
            args = objArr;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @StabilityInferred(parameters = 0)
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096D¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR*\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R%\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\b\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R%\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\b\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcu/todus/android/uiCompose/navigation/NavDestinations$ManageStickersDest;", "Lcu/todus/android/uiCompose/navigation/NavDestinations$AppDestination;", "<init>", "()V", "", "route", "Ljava/lang/String;", "getRoute", "()Ljava/lang/String;", "", "", "args", "[Ljava/lang/Object;", "getArgs", "()[Ljava/lang/Object;", "setArgs", "([Ljava/lang/Object;)V", "Lkotlin/Function0;", "Lua/k0;", "Landroidx/compose/runtime/Composable;", "screen", "Lkotlin/jvm/functions/Function2;", "getScreen", "()Lkotlin/jvm/functions/Function2;", "bigScreen", "getBigScreen", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class ManageStickersDest implements AppDestination {
        public static final int $stable;
        private static final Function2 bigScreen;
        private static final Function2 screen;
        public static final ManageStickersDest INSTANCE = new ManageStickersDest();
        private static final String route = NavLinks.MANAGE_STICKERS;
        private static Object[] args = new Object[0];

        static {
            ComposableSingletons$NavDestinationsKt composableSingletons$NavDestinationsKt = ComposableSingletons$NavDestinationsKt.INSTANCE;
            screen = composableSingletons$NavDestinationsKt.m10004getLambda$1091639369$app_productionPFast();
            bigScreen = composableSingletons$NavDestinationsKt.m10068getLambda$886584695$app_productionPFast();
            $stable = 8;
        }

        private ManageStickersDest() {
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Object[] getArgs() {
            return args;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Function2 getBigScreen() {
            return bigScreen;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public String getRoute() {
            return route;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Function2 getScreen() {
            return screen;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public void setArgs(Object[] objArr) {
            y.i(objArr, "<set-?>");
            args = objArr;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @StabilityInferred(parameters = 0)
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096D¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR*\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R%\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\b\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R%\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\b\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcu/todus/android/uiCompose/navigation/NavDestinations$MapDest;", "Lcu/todus/android/uiCompose/navigation/NavDestinations$AppDestination;", "<init>", "()V", "", "route", "Ljava/lang/String;", "getRoute", "()Ljava/lang/String;", "", "", "args", "[Ljava/lang/Object;", "getArgs", "()[Ljava/lang/Object;", "setArgs", "([Ljava/lang/Object;)V", "Lkotlin/Function0;", "Lua/k0;", "Landroidx/compose/runtime/Composable;", "screen", "Lkotlin/jvm/functions/Function2;", "getScreen", "()Lkotlin/jvm/functions/Function2;", "bigScreen", "getBigScreen", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class MapDest implements AppDestination {
        public static final int $stable;
        private static final Function2 bigScreen;
        private static final Function2 screen;
        public static final MapDest INSTANCE = new MapDest();
        private static final String route = NavLinks.MAP;
        private static Object[] args = new Object[0];

        static {
            ComposableSingletons$NavDestinationsKt composableSingletons$NavDestinationsKt = ComposableSingletons$NavDestinationsKt.INSTANCE;
            screen = composableSingletons$NavDestinationsKt.getLambda$1764502330$app_productionPFast();
            bigScreen = composableSingletons$NavDestinationsKt.m10042getLambda$211495000$app_productionPFast();
            $stable = 8;
        }

        private MapDest() {
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Object[] getArgs() {
            return args;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Function2 getBigScreen() {
            return bigScreen;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public String getRoute() {
            return route;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Function2 getScreen() {
            return screen;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public void setArgs(Object[] objArr) {
            y.i(objArr, "<set-?>");
            args = objArr;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @StabilityInferred(parameters = 0)
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096D¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR*\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R%\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\b\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R%\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\b\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcu/todus/android/uiCompose/navigation/NavDestinations$MutedRoomsDest;", "Lcu/todus/android/uiCompose/navigation/NavDestinations$AppDestination;", "<init>", "()V", "", "route", "Ljava/lang/String;", "getRoute", "()Ljava/lang/String;", "", "", "args", "[Ljava/lang/Object;", "getArgs", "()[Ljava/lang/Object;", "setArgs", "([Ljava/lang/Object;)V", "Lkotlin/Function0;", "Lua/k0;", "Landroidx/compose/runtime/Composable;", "screen", "Lkotlin/jvm/functions/Function2;", "getScreen", "()Lkotlin/jvm/functions/Function2;", "bigScreen", "getBigScreen", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class MutedRoomsDest implements AppDestination {
        public static final int $stable;
        private static final Function2 bigScreen;
        private static final Function2 screen;
        public static final MutedRoomsDest INSTANCE = new MutedRoomsDest();
        private static final String route = NavLinks.MUTED_ROOMS;
        private static Object[] args = new Object[0];

        static {
            ComposableSingletons$NavDestinationsKt composableSingletons$NavDestinationsKt = ComposableSingletons$NavDestinationsKt.INSTANCE;
            screen = composableSingletons$NavDestinationsKt.m10006getLambda$1223802583$app_productionPFast();
            bigScreen = composableSingletons$NavDestinationsKt.m10014getLambda$1430430469$app_productionPFast();
            $stable = 8;
        }

        private MutedRoomsDest() {
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Object[] getArgs() {
            return args;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Function2 getBigScreen() {
            return bigScreen;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public String getRoute() {
            return route;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Function2 getScreen() {
            return screen;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public void setArgs(Object[] objArr) {
            y.i(objArr, "<set-?>");
            args = objArr;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @StabilityInferred(parameters = 0)
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096D¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR*\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R%\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\b\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R%\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\b\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcu/todus/android/uiCompose/navigation/NavDestinations$MyCatalogueDest;", "Lcu/todus/android/uiCompose/navigation/NavDestinations$AppDestination;", "<init>", "()V", "", "route", "Ljava/lang/String;", "getRoute", "()Ljava/lang/String;", "", "", "args", "[Ljava/lang/Object;", "getArgs", "()[Ljava/lang/Object;", "setArgs", "([Ljava/lang/Object;)V", "Lkotlin/Function0;", "Lua/k0;", "Landroidx/compose/runtime/Composable;", "screen", "Lkotlin/jvm/functions/Function2;", "getScreen", "()Lkotlin/jvm/functions/Function2;", "bigScreen", "getBigScreen", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class MyCatalogueDest implements AppDestination {
        public static final int $stable;
        private static final Function2 bigScreen;
        private static final Function2 screen;
        public static final MyCatalogueDest INSTANCE = new MyCatalogueDest();
        private static final String route = NavLinks.MY_CATALOGUE;
        private static Object[] args = new Object[0];

        static {
            ComposableSingletons$NavDestinationsKt composableSingletons$NavDestinationsKt = ComposableSingletons$NavDestinationsKt.INSTANCE;
            screen = composableSingletons$NavDestinationsKt.getLambda$673186171$app_productionPFast();
            bigScreen = composableSingletons$NavDestinationsKt.m10015getLambda$1437310999$app_productionPFast();
            $stable = 8;
        }

        private MyCatalogueDest() {
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Object[] getArgs() {
            return args;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Function2 getBigScreen() {
            return bigScreen;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public String getRoute() {
            return route;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Function2 getScreen() {
            return screen;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public void setArgs(Object[] objArr) {
            y.i(objArr, "<set-?>");
            args = objArr;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @StabilityInferred(parameters = 0)
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096D¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR*\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R%\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\b\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R%\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\b\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcu/todus/android/uiCompose/navigation/NavDestinations$NearPeopleDest;", "Lcu/todus/android/uiCompose/navigation/NavDestinations$AppDestination;", "<init>", "()V", "", "route", "Ljava/lang/String;", "getRoute", "()Ljava/lang/String;", "", "", "args", "[Ljava/lang/Object;", "getArgs", "()[Ljava/lang/Object;", "setArgs", "([Ljava/lang/Object;)V", "Lkotlin/Function0;", "Lua/k0;", "Landroidx/compose/runtime/Composable;", "screen", "Lkotlin/jvm/functions/Function2;", "getScreen", "()Lkotlin/jvm/functions/Function2;", "bigScreen", "getBigScreen", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class NearPeopleDest implements AppDestination {
        public static final int $stable;
        private static final Function2 bigScreen;
        private static final Function2 screen;
        public static final NearPeopleDest INSTANCE = new NearPeopleDest();
        private static final String route = NavLinks.NEAR;
        private static Object[] args = new Object[0];

        static {
            ComposableSingletons$NavDestinationsKt composableSingletons$NavDestinationsKt = ComposableSingletons$NavDestinationsKt.INSTANCE;
            screen = composableSingletons$NavDestinationsKt.m10029getLambda$1882709325$app_productionPFast();
            bigScreen = composableSingletons$NavDestinationsKt.m10041getLambda$2089337211$app_productionPFast();
            $stable = 8;
        }

        private NearPeopleDest() {
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Object[] getArgs() {
            return args;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Function2 getBigScreen() {
            return bigScreen;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public String getRoute() {
            return route;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Function2 getScreen() {
            return screen;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public void setArgs(Object[] objArr) {
            y.i(objArr, "<set-?>");
            args = objArr;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @StabilityInferred(parameters = 0)
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096D¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR*\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R%\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\b\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R%\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\b\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcu/todus/android/uiCompose/navigation/NavDestinations$NewsDest;", "Lcu/todus/android/uiCompose/navigation/NavDestinations$AppDestination;", "<init>", "()V", "", "route", "Ljava/lang/String;", "getRoute", "()Ljava/lang/String;", "", "", "args", "[Ljava/lang/Object;", "getArgs", "()[Ljava/lang/Object;", "setArgs", "([Ljava/lang/Object;)V", "Lkotlin/Function0;", "Lua/k0;", "Landroidx/compose/runtime/Composable;", "screen", "Lkotlin/jvm/functions/Function2;", "getScreen", "()Lkotlin/jvm/functions/Function2;", "bigScreen", "getBigScreen", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class NewsDest implements AppDestination {
        public static final int $stable;
        private static final Function2 bigScreen;
        private static final Function2 screen;
        public static final NewsDest INSTANCE = new NewsDest();
        private static final String route = NavLinks.NEWS;
        private static Object[] args = new Object[0];

        static {
            ComposableSingletons$NavDestinationsKt composableSingletons$NavDestinationsKt = ComposableSingletons$NavDestinationsKt.INSTANCE;
            screen = composableSingletons$NavDestinationsKt.m10030getLambda$1900002833$app_productionPFast();
            bigScreen = composableSingletons$NavDestinationsKt.getLambda$1268589377$app_productionPFast();
            $stable = 8;
        }

        private NewsDest() {
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Object[] getArgs() {
            return args;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Function2 getBigScreen() {
            return bigScreen;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public String getRoute() {
            return route;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Function2 getScreen() {
            return screen;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public void setArgs(Object[] objArr) {
            y.i(objArr, "<set-?>");
            args = objArr;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @StabilityInferred(parameters = 0)
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096D¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR*\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R%\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\b\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R%\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\b\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcu/todus/android/uiCompose/navigation/NavDestinations$OpenWithDest;", "Lcu/todus/android/uiCompose/navigation/NavDestinations$AppDestination;", "<init>", "()V", "", "route", "Ljava/lang/String;", "getRoute", "()Ljava/lang/String;", "", "", "args", "[Ljava/lang/Object;", "getArgs", "()[Ljava/lang/Object;", "setArgs", "([Ljava/lang/Object;)V", "Lkotlin/Function0;", "Lua/k0;", "Landroidx/compose/runtime/Composable;", "screen", "Lkotlin/jvm/functions/Function2;", "getScreen", "()Lkotlin/jvm/functions/Function2;", "bigScreen", "getBigScreen", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class OpenWithDest implements AppDestination {
        public static final int $stable;
        private static final Function2 bigScreen;
        private static final Function2 screen;
        public static final OpenWithDest INSTANCE = new OpenWithDest();
        private static final String route = NavLinks.OPEN_WITH;
        private static Object[] args = new Object[0];

        static {
            ComposableSingletons$NavDestinationsKt composableSingletons$NavDestinationsKt = ComposableSingletons$NavDestinationsKt.INSTANCE;
            screen = composableSingletons$NavDestinationsKt.getLambda$1894144076$app_productionPFast();
            bigScreen = composableSingletons$NavDestinationsKt.m10072getLambda$957464418$app_productionPFast();
            $stable = 8;
        }

        private OpenWithDest() {
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Object[] getArgs() {
            return args;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Function2 getBigScreen() {
            return bigScreen;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public String getRoute() {
            return route;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Function2 getScreen() {
            return screen;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public void setArgs(Object[] objArr) {
            y.i(objArr, "<set-?>");
            args = objArr;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @StabilityInferred(parameters = 0)
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096D¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR*\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R%\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\b\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R%\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\b\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcu/todus/android/uiCompose/navigation/NavDestinations$PresentDest;", "Lcu/todus/android/uiCompose/navigation/NavDestinations$AppDestination;", "<init>", "()V", "", "route", "Ljava/lang/String;", "getRoute", "()Ljava/lang/String;", "", "", "args", "[Ljava/lang/Object;", "getArgs", "()[Ljava/lang/Object;", "setArgs", "([Ljava/lang/Object;)V", "Lkotlin/Function0;", "Lua/k0;", "Landroidx/compose/runtime/Composable;", "screen", "Lkotlin/jvm/functions/Function2;", "getScreen", "()Lkotlin/jvm/functions/Function2;", "bigScreen", "getBigScreen", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class PresentDest implements AppDestination {
        public static final int $stable;
        private static final Function2 bigScreen;
        private static final Function2 screen;
        public static final PresentDest INSTANCE = new PresentDest();
        private static final String route = NavLinks.PRESENT;
        private static Object[] args = new Object[0];

        static {
            ComposableSingletons$NavDestinationsKt composableSingletons$NavDestinationsKt = ComposableSingletons$NavDestinationsKt.INSTANCE;
            screen = composableSingletons$NavDestinationsKt.getLambda$918835609$app_productionPFast();
            bigScreen = composableSingletons$NavDestinationsKt.getLambda$1658132231$app_productionPFast();
            $stable = 8;
        }

        private PresentDest() {
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Object[] getArgs() {
            return args;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Function2 getBigScreen() {
            return bigScreen;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public String getRoute() {
            return route;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Function2 getScreen() {
            return screen;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public void setArgs(Object[] objArr) {
            y.i(objArr, "<set-?>");
            args = objArr;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @StabilityInferred(parameters = 0)
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096D¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR*\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R%\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\b\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R%\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\b\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcu/todus/android/uiCompose/navigation/NavDestinations$PreviewCardDest;", "Lcu/todus/android/uiCompose/navigation/NavDestinations$AppDestination;", "<init>", "()V", "", "route", "Ljava/lang/String;", "getRoute", "()Ljava/lang/String;", "", "", "args", "[Ljava/lang/Object;", "getArgs", "()[Ljava/lang/Object;", "setArgs", "([Ljava/lang/Object;)V", "Lkotlin/Function0;", "Lua/k0;", "Landroidx/compose/runtime/Composable;", "screen", "Lkotlin/jvm/functions/Function2;", "getScreen", "()Lkotlin/jvm/functions/Function2;", "bigScreen", "getBigScreen", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class PreviewCardDest implements AppDestination {
        public static final int $stable;
        private static final Function2 bigScreen;
        private static final Function2 screen;
        public static final PreviewCardDest INSTANCE = new PreviewCardDest();
        private static final String route = NavLinks.PREVIEW_CARD;
        private static Object[] args = new Object[0];

        static {
            ComposableSingletons$NavDestinationsKt composableSingletons$NavDestinationsKt = ComposableSingletons$NavDestinationsKt.INSTANCE;
            screen = composableSingletons$NavDestinationsKt.getLambda$1770541526$app_productionPFast();
            bigScreen = composableSingletons$NavDestinationsKt.m10047getLambda$339955644$app_productionPFast();
            $stable = 8;
        }

        private PreviewCardDest() {
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Object[] getArgs() {
            return args;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Function2 getBigScreen() {
            return bigScreen;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public String getRoute() {
            return route;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Function2 getScreen() {
            return screen;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public void setArgs(Object[] objArr) {
            y.i(objArr, "<set-?>");
            args = objArr;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @StabilityInferred(parameters = 0)
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096D¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR*\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R%\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\b\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R%\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\b\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcu/todus/android/uiCompose/navigation/NavDestinations$PreviewChannelAdminsDest;", "Lcu/todus/android/uiCompose/navigation/NavDestinations$AppDestination;", "<init>", "()V", "", "route", "Ljava/lang/String;", "getRoute", "()Ljava/lang/String;", "", "", "args", "[Ljava/lang/Object;", "getArgs", "()[Ljava/lang/Object;", "setArgs", "([Ljava/lang/Object;)V", "Lkotlin/Function0;", "Lua/k0;", "Landroidx/compose/runtime/Composable;", "screen", "Lkotlin/jvm/functions/Function2;", "getScreen", "()Lkotlin/jvm/functions/Function2;", "bigScreen", "getBigScreen", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class PreviewChannelAdminsDest implements AppDestination {
        public static final int $stable;
        private static final Function2 bigScreen;
        private static final Function2 screen;
        public static final PreviewChannelAdminsDest INSTANCE = new PreviewChannelAdminsDest();
        private static final String route = NavLinks.PREVIEW_ADMINS_CHANNEL;
        private static Object[] args = new Object[0];

        static {
            ComposableSingletons$NavDestinationsKt composableSingletons$NavDestinationsKt = ComposableSingletons$NavDestinationsKt.INSTANCE;
            screen = composableSingletons$NavDestinationsKt.getLambda$2126860827$app_productionPFast();
            bigScreen = composableSingletons$NavDestinationsKt.getLambda$640241517$app_productionPFast();
            $stable = 8;
        }

        private PreviewChannelAdminsDest() {
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Object[] getArgs() {
            return args;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Function2 getBigScreen() {
            return bigScreen;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public String getRoute() {
            return route;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Function2 getScreen() {
            return screen;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public void setArgs(Object[] objArr) {
            y.i(objArr, "<set-?>");
            args = objArr;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @StabilityInferred(parameters = 0)
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096D¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR*\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R%\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\b\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R%\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\b\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcu/todus/android/uiCompose/navigation/NavDestinations$PreviewChannelDest;", "Lcu/todus/android/uiCompose/navigation/NavDestinations$AppDestination;", "<init>", "()V", "", "route", "Ljava/lang/String;", "getRoute", "()Ljava/lang/String;", "", "", "args", "[Ljava/lang/Object;", "getArgs", "()[Ljava/lang/Object;", "setArgs", "([Ljava/lang/Object;)V", "Lkotlin/Function0;", "Lua/k0;", "Landroidx/compose/runtime/Composable;", "screen", "Lkotlin/jvm/functions/Function2;", "getScreen", "()Lkotlin/jvm/functions/Function2;", "bigScreen", "getBigScreen", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class PreviewChannelDest implements AppDestination {
        public static final int $stable;
        private static final Function2 bigScreen;
        private static final Function2 screen;
        public static final PreviewChannelDest INSTANCE = new PreviewChannelDest();
        private static final String route = NavLinks.PREVIEW_CHANNEL;
        private static Object[] args = new Object[0];

        static {
            ComposableSingletons$NavDestinationsKt composableSingletons$NavDestinationsKt = ComposableSingletons$NavDestinationsKt.INSTANCE;
            screen = composableSingletons$NavDestinationsKt.getLambda$164314231$app_productionPFast();
            bigScreen = composableSingletons$NavDestinationsKt.getLambda$369368905$app_productionPFast();
            $stable = 8;
        }

        private PreviewChannelDest() {
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Object[] getArgs() {
            return args;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Function2 getBigScreen() {
            return bigScreen;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public String getRoute() {
            return route;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Function2 getScreen() {
            return screen;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public void setArgs(Object[] objArr) {
            y.i(objArr, "<set-?>");
            args = objArr;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @StabilityInferred(parameters = 0)
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096D¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR*\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R%\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\b\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R%\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\b\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcu/todus/android/uiCompose/navigation/NavDestinations$PreviewGroupAdminsDest;", "Lcu/todus/android/uiCompose/navigation/NavDestinations$AppDestination;", "<init>", "()V", "", "route", "Ljava/lang/String;", "getRoute", "()Ljava/lang/String;", "", "", "args", "[Ljava/lang/Object;", "getArgs", "()[Ljava/lang/Object;", "setArgs", "([Ljava/lang/Object;)V", "Lkotlin/Function0;", "Lua/k0;", "Landroidx/compose/runtime/Composable;", "screen", "Lkotlin/jvm/functions/Function2;", "getScreen", "()Lkotlin/jvm/functions/Function2;", "bigScreen", "getBigScreen", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class PreviewGroupAdminsDest implements AppDestination {
        public static final int $stable;
        private static final Function2 bigScreen;
        private static final Function2 screen;
        public static final PreviewGroupAdminsDest INSTANCE = new PreviewGroupAdminsDest();
        private static final String route = NavLinks.PREVIEW_ADMINS_GROUP;
        private static Object[] args = new Object[0];

        static {
            ComposableSingletons$NavDestinationsKt composableSingletons$NavDestinationsKt = ComposableSingletons$NavDestinationsKt.INSTANCE;
            screen = composableSingletons$NavDestinationsKt.m10058getLambda$628055465$app_productionPFast();
            bigScreen = composableSingletons$NavDestinationsKt.m10038getLambda$2028483543$app_productionPFast();
            $stable = 8;
        }

        private PreviewGroupAdminsDest() {
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Object[] getArgs() {
            return args;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Function2 getBigScreen() {
            return bigScreen;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public String getRoute() {
            return route;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Function2 getScreen() {
            return screen;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public void setArgs(Object[] objArr) {
            y.i(objArr, "<set-?>");
            args = objArr;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @StabilityInferred(parameters = 0)
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096D¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR*\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R%\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\b\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R%\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\b\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcu/todus/android/uiCompose/navigation/NavDestinations$PreviewGroupDest;", "Lcu/todus/android/uiCompose/navigation/NavDestinations$AppDestination;", "<init>", "()V", "", "route", "Ljava/lang/String;", "getRoute", "()Ljava/lang/String;", "", "", "args", "[Ljava/lang/Object;", "getArgs", "()[Ljava/lang/Object;", "setArgs", "([Ljava/lang/Object;)V", "Lkotlin/Function0;", "Lua/k0;", "Landroidx/compose/runtime/Composable;", "screen", "Lkotlin/jvm/functions/Function2;", "getScreen", "()Lkotlin/jvm/functions/Function2;", "bigScreen", "getBigScreen", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class PreviewGroupDest implements AppDestination {
        public static final int $stable;
        private static final Function2 bigScreen;
        private static final Function2 screen;
        public static final PreviewGroupDest INSTANCE = new PreviewGroupDest();
        private static final String route = NavLinks.PREVIEW_GROUP;
        private static Object[] args = new Object[0];

        static {
            ComposableSingletons$NavDestinationsKt composableSingletons$NavDestinationsKt = ComposableSingletons$NavDestinationsKt.INSTANCE;
            screen = composableSingletons$NavDestinationsKt.m10008getLambda$1284085325$app_productionPFast();
            bigScreen = composableSingletons$NavDestinationsKt.getLambda$2009979141$app_productionPFast();
            $stable = 8;
        }

        private PreviewGroupDest() {
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Object[] getArgs() {
            return args;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Function2 getBigScreen() {
            return bigScreen;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public String getRoute() {
            return route;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Function2 getScreen() {
            return screen;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public void setArgs(Object[] objArr) {
            y.i(objArr, "<set-?>");
            args = objArr;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @StabilityInferred(parameters = 0)
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096D¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR*\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R%\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\b\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R%\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\b\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcu/todus/android/uiCompose/navigation/NavDestinations$PreviewP2PDest;", "Lcu/todus/android/uiCompose/navigation/NavDestinations$AppDestination;", "<init>", "()V", "", "route", "Ljava/lang/String;", "getRoute", "()Ljava/lang/String;", "", "", "args", "[Ljava/lang/Object;", "getArgs", "()[Ljava/lang/Object;", "setArgs", "([Ljava/lang/Object;)V", "Lkotlin/Function0;", "Lua/k0;", "Landroidx/compose/runtime/Composable;", "screen", "Lkotlin/jvm/functions/Function2;", "getScreen", "()Lkotlin/jvm/functions/Function2;", "bigScreen", "getBigScreen", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class PreviewP2PDest implements AppDestination {
        public static final int $stable;
        private static final Function2 bigScreen;
        private static final Function2 screen;
        public static final PreviewP2PDest INSTANCE = new PreviewP2PDest();
        private static final String route = NavLinks.PREVIEW_P2P;
        private static Object[] args = new Object[0];

        static {
            ComposableSingletons$NavDestinationsKt composableSingletons$NavDestinationsKt = ComposableSingletons$NavDestinationsKt.INSTANCE;
            screen = composableSingletons$NavDestinationsKt.m10036getLambda$1988264126$app_productionPFast();
            bigScreen = composableSingletons$NavDestinationsKt.getLambda$2100075284$app_productionPFast();
            $stable = 8;
        }

        private PreviewP2PDest() {
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Object[] getArgs() {
            return args;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Function2 getBigScreen() {
            return bigScreen;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public String getRoute() {
            return route;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Function2 getScreen() {
            return screen;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public void setArgs(Object[] objArr) {
            y.i(objArr, "<set-?>");
            args = objArr;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @StabilityInferred(parameters = 0)
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096D¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR*\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R%\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\b\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R%\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\b\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcu/todus/android/uiCompose/navigation/NavDestinations$PreviewSubscribersDest;", "Lcu/todus/android/uiCompose/navigation/NavDestinations$AppDestination;", "<init>", "()V", "", "route", "Ljava/lang/String;", "getRoute", "()Ljava/lang/String;", "", "", "args", "[Ljava/lang/Object;", "getArgs", "()[Ljava/lang/Object;", "setArgs", "([Ljava/lang/Object;)V", "Lkotlin/Function0;", "Lua/k0;", "Landroidx/compose/runtime/Composable;", "screen", "Lkotlin/jvm/functions/Function2;", "getScreen", "()Lkotlin/jvm/functions/Function2;", "bigScreen", "getBigScreen", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class PreviewSubscribersDest implements AppDestination {
        public static final int $stable;
        private static final Function2 bigScreen;
        private static final Function2 screen;
        public static final PreviewSubscribersDest INSTANCE = new PreviewSubscribersDest();
        private static final String route = NavLinks.PREVIEW_SUBSCRIBERS;
        private static Object[] args = new Object[0];

        static {
            ComposableSingletons$NavDestinationsKt composableSingletons$NavDestinationsKt = ComposableSingletons$NavDestinationsKt.INSTANCE;
            screen = composableSingletons$NavDestinationsKt.m10055getLambda$582162177$app_productionPFast();
            bigScreen = composableSingletons$NavDestinationsKt.m10034getLambda$1982590255$app_productionPFast();
            $stable = 8;
        }

        private PreviewSubscribersDest() {
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Object[] getArgs() {
            return args;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Function2 getBigScreen() {
            return bigScreen;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public String getRoute() {
            return route;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Function2 getScreen() {
            return screen;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public void setArgs(Object[] objArr) {
            y.i(objArr, "<set-?>");
            args = objArr;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @StabilityInferred(parameters = 0)
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096D¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR*\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R%\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\b\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R%\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\b\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcu/todus/android/uiCompose/navigation/NavDestinations$PrivacyDest;", "Lcu/todus/android/uiCompose/navigation/NavDestinations$AppDestination;", "<init>", "()V", "", "route", "Ljava/lang/String;", "getRoute", "()Ljava/lang/String;", "", "", "args", "[Ljava/lang/Object;", "getArgs", "()[Ljava/lang/Object;", "setArgs", "([Ljava/lang/Object;)V", "Lkotlin/Function0;", "Lua/k0;", "Landroidx/compose/runtime/Composable;", "screen", "Lkotlin/jvm/functions/Function2;", "getScreen", "()Lkotlin/jvm/functions/Function2;", "bigScreen", "getBigScreen", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class PrivacyDest implements AppDestination {
        public static final int $stable;
        private static final Function2 bigScreen;
        private static final Function2 screen;
        public static final PrivacyDest INSTANCE = new PrivacyDest();
        private static final String route = NavLinks.PRIVACY;
        private static Object[] args = new Object[0];

        static {
            ComposableSingletons$NavDestinationsKt composableSingletons$NavDestinationsKt = ComposableSingletons$NavDestinationsKt.INSTANCE;
            screen = composableSingletons$NavDestinationsKt.m10039getLambda$2061234458$app_productionPFast();
            bigScreen = composableSingletons$NavDestinationsKt.m10009getLambda$1321937836$app_productionPFast();
            $stable = 8;
        }

        private PrivacyDest() {
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Object[] getArgs() {
            return args;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Function2 getBigScreen() {
            return bigScreen;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public String getRoute() {
            return route;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Function2 getScreen() {
            return screen;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public void setArgs(Object[] objArr) {
            y.i(objArr, "<set-?>");
            args = objArr;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @StabilityInferred(parameters = 0)
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096D¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR*\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R%\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\b\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R%\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\b\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcu/todus/android/uiCompose/navigation/NavDestinations$ProductPreviewDest;", "Lcu/todus/android/uiCompose/navigation/NavDestinations$AppDestination;", "<init>", "()V", "", "route", "Ljava/lang/String;", "getRoute", "()Ljava/lang/String;", "", "", "args", "[Ljava/lang/Object;", "getArgs", "()[Ljava/lang/Object;", "setArgs", "([Ljava/lang/Object;)V", "Lkotlin/Function0;", "Lua/k0;", "Landroidx/compose/runtime/Composable;", "screen", "Lkotlin/jvm/functions/Function2;", "getScreen", "()Lkotlin/jvm/functions/Function2;", "bigScreen", "getBigScreen", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class ProductPreviewDest implements AppDestination {
        public static final int $stable;
        private static final Function2 bigScreen;
        private static final Function2 screen;
        public static final ProductPreviewDest INSTANCE = new ProductPreviewDest();
        private static final String route = NavLinks.PRODUCT_PREVIEW;
        private static Object[] args = new Object[0];

        static {
            ComposableSingletons$NavDestinationsKt composableSingletons$NavDestinationsKt = ComposableSingletons$NavDestinationsKt.INSTANCE;
            screen = composableSingletons$NavDestinationsKt.m10020getLambda$1568303307$app_productionPFast();
            bigScreen = composableSingletons$NavDestinationsKt.m10011getLambda$1363248633$app_productionPFast();
            $stable = 8;
        }

        private ProductPreviewDest() {
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Object[] getArgs() {
            return args;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Function2 getBigScreen() {
            return bigScreen;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public String getRoute() {
            return route;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Function2 getScreen() {
            return screen;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public void setArgs(Object[] objArr) {
            y.i(objArr, "<set-?>");
            args = objArr;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @StabilityInferred(parameters = 0)
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096D¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR*\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R%\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\b\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R%\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\b\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcu/todus/android/uiCompose/navigation/NavDestinations$PubEditorDest;", "Lcu/todus/android/uiCompose/navigation/NavDestinations$AppDestination;", "<init>", "()V", "", "route", "Ljava/lang/String;", "getRoute", "()Ljava/lang/String;", "", "", "args", "[Ljava/lang/Object;", "getArgs", "()[Ljava/lang/Object;", "setArgs", "([Ljava/lang/Object;)V", "Lkotlin/Function0;", "Lua/k0;", "Landroidx/compose/runtime/Composable;", "screen", "Lkotlin/jvm/functions/Function2;", "getScreen", "()Lkotlin/jvm/functions/Function2;", "bigScreen", "getBigScreen", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class PubEditorDest implements AppDestination {
        public static final int $stable;
        private static final Function2 bigScreen;
        private static final Function2 screen;
        public static final PubEditorDest INSTANCE = new PubEditorDest();
        private static final String route = NavLinks.PUB_EDITOR;
        private static Object[] args = new Object[0];

        static {
            ComposableSingletons$NavDestinationsKt composableSingletons$NavDestinationsKt = ComposableSingletons$NavDestinationsKt.INSTANCE;
            screen = composableSingletons$NavDestinationsKt.getLambda$878471912$app_productionPFast();
            bigScreen = composableSingletons$NavDestinationsKt.m10024getLambda$1622045482$app_productionPFast();
            $stable = 8;
        }

        private PubEditorDest() {
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Object[] getArgs() {
            return args;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Function2 getBigScreen() {
            return bigScreen;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public String getRoute() {
            return route;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Function2 getScreen() {
            return screen;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public void setArgs(Object[] objArr) {
            y.i(objArr, "<set-?>");
            args = objArr;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @StabilityInferred(parameters = 0)
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096D¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR*\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R%\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\b\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R%\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\b\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcu/todus/android/uiCompose/navigation/NavDestinations$QrReaderDest;", "Lcu/todus/android/uiCompose/navigation/NavDestinations$AppDestination;", "<init>", "()V", "", "route", "Ljava/lang/String;", "getRoute", "()Ljava/lang/String;", "", "", "args", "[Ljava/lang/Object;", "getArgs", "()[Ljava/lang/Object;", "setArgs", "([Ljava/lang/Object;)V", "Lkotlin/Function0;", "Lua/k0;", "Landroidx/compose/runtime/Composable;", "screen", "Lkotlin/jvm/functions/Function2;", "getScreen", "()Lkotlin/jvm/functions/Function2;", "bigScreen", "getBigScreen", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class QrReaderDest implements AppDestination {
        public static final int $stable;
        private static final Function2 bigScreen;
        private static final Function2 screen;
        public static final QrReaderDest INSTANCE = new QrReaderDest();
        private static final String route = NavLinks.QR_READER;
        private static Object[] args = new Object[0];

        static {
            ComposableSingletons$NavDestinationsKt composableSingletons$NavDestinationsKt = ComposableSingletons$NavDestinationsKt.INSTANCE;
            screen = composableSingletons$NavDestinationsKt.getLambda$1906438752$app_productionPFast();
            bigScreen = composableSingletons$NavDestinationsKt.m10070getLambda$945169742$app_productionPFast();
            $stable = 8;
        }

        private QrReaderDest() {
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Object[] getArgs() {
            return args;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Function2 getBigScreen() {
            return bigScreen;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public String getRoute() {
            return route;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Function2 getScreen() {
            return screen;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public void setArgs(Object[] objArr) {
            y.i(objArr, "<set-?>");
            args = objArr;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @StabilityInferred(parameters = 0)
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096D¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR*\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R%\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\b\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R%\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\b\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcu/todus/android/uiCompose/navigation/NavDestinations$QrViewerDest;", "Lcu/todus/android/uiCompose/navigation/NavDestinations$AppDestination;", "<init>", "()V", "", "route", "Ljava/lang/String;", "getRoute", "()Ljava/lang/String;", "", "", "args", "[Ljava/lang/Object;", "getArgs", "()[Ljava/lang/Object;", "setArgs", "([Ljava/lang/Object;)V", "Lkotlin/Function0;", "Lua/k0;", "Landroidx/compose/runtime/Composable;", "screen", "Lkotlin/jvm/functions/Function2;", "getScreen", "()Lkotlin/jvm/functions/Function2;", "bigScreen", "getBigScreen", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class QrViewerDest implements AppDestination {
        public static final int $stable;
        private static final Function2 bigScreen;
        private static final Function2 screen;
        public static final QrViewerDest INSTANCE = new QrViewerDest();
        private static final String route = NavLinks.QR_VIEWER;
        private static Object[] args = new Object[0];

        static {
            ComposableSingletons$NavDestinationsKt composableSingletons$NavDestinationsKt = ComposableSingletons$NavDestinationsKt.INSTANCE;
            screen = composableSingletons$NavDestinationsKt.m10067getLambda$864430289$app_productionPFast();
            bigScreen = composableSingletons$NavDestinationsKt.getLambda$578928513$app_productionPFast();
            $stable = 8;
        }

        private QrViewerDest() {
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Object[] getArgs() {
            return args;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Function2 getBigScreen() {
            return bigScreen;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public String getRoute() {
            return route;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Function2 getScreen() {
            return screen;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public void setArgs(Object[] objArr) {
            y.i(objArr, "<set-?>");
            args = objArr;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @StabilityInferred(parameters = 0)
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096D¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR*\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R%\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\b\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R%\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\b\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcu/todus/android/uiCompose/navigation/NavDestinations$ReactSelectionDest;", "Lcu/todus/android/uiCompose/navigation/NavDestinations$AppDestination;", "<init>", "()V", "", "route", "Ljava/lang/String;", "getRoute", "()Ljava/lang/String;", "", "", "args", "[Ljava/lang/Object;", "getArgs", "()[Ljava/lang/Object;", "setArgs", "([Ljava/lang/Object;)V", "Lkotlin/Function0;", "Lua/k0;", "Landroidx/compose/runtime/Composable;", "screen", "Lkotlin/jvm/functions/Function2;", "getScreen", "()Lkotlin/jvm/functions/Function2;", "bigScreen", "getBigScreen", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class ReactSelectionDest implements AppDestination {
        public static final int $stable;
        private static final Function2 bigScreen;
        private static final Function2 screen;
        public static final ReactSelectionDest INSTANCE = new ReactSelectionDest();
        private static final String route = NavLinks.REACT_SELECTION;
        private static Object[] args = new Object[0];

        static {
            ComposableSingletons$NavDestinationsKt composableSingletons$NavDestinationsKt = ComposableSingletons$NavDestinationsKt.INSTANCE;
            screen = composableSingletons$NavDestinationsKt.m10069getLambda$937712599$app_productionPFast();
            bigScreen = composableSingletons$NavDestinationsKt.m10061getLambda$732657925$app_productionPFast();
            $stable = 8;
        }

        private ReactSelectionDest() {
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Object[] getArgs() {
            return args;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Function2 getBigScreen() {
            return bigScreen;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public String getRoute() {
            return route;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Function2 getScreen() {
            return screen;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public void setArgs(Object[] objArr) {
            y.i(objArr, "<set-?>");
            args = objArr;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @StabilityInferred(parameters = 0)
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096D¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR*\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R%\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\b\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R%\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\b\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcu/todus/android/uiCompose/navigation/NavDestinations$RegisterDest;", "Lcu/todus/android/uiCompose/navigation/NavDestinations$AppDestination;", "<init>", "()V", "", "route", "Ljava/lang/String;", "getRoute", "()Ljava/lang/String;", "", "", "args", "[Ljava/lang/Object;", "getArgs", "()[Ljava/lang/Object;", "setArgs", "([Ljava/lang/Object;)V", "Lkotlin/Function0;", "Lua/k0;", "Landroidx/compose/runtime/Composable;", "screen", "Lkotlin/jvm/functions/Function2;", "getScreen", "()Lkotlin/jvm/functions/Function2;", "bigScreen", "getBigScreen", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class RegisterDest implements AppDestination {
        public static final int $stable;
        private static final Function2 bigScreen;
        private static final Function2 screen;
        public static final RegisterDest INSTANCE = new RegisterDest();
        private static final String route = "register";
        private static Object[] args = new Object[0];

        static {
            ComposableSingletons$NavDestinationsKt composableSingletons$NavDestinationsKt = ComposableSingletons$NavDestinationsKt.INSTANCE;
            screen = composableSingletons$NavDestinationsKt.m10046getLambda$33817025$app_productionPFast();
            bigScreen = composableSingletons$NavDestinationsKt.getLambda$1409541777$app_productionPFast();
            $stable = 8;
        }

        private RegisterDest() {
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Object[] getArgs() {
            return args;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Function2 getBigScreen() {
            return bigScreen;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public String getRoute() {
            return route;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Function2 getScreen() {
            return screen;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public void setArgs(Object[] objArr) {
            y.i(objArr, "<set-?>");
            args = objArr;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @StabilityInferred(parameters = 0)
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096D¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR*\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R%\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\b\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R%\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\b\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcu/todus/android/uiCompose/navigation/NavDestinations$RequestRoomsDest;", "Lcu/todus/android/uiCompose/navigation/NavDestinations$AppDestination;", "<init>", "()V", "", "route", "Ljava/lang/String;", "getRoute", "()Ljava/lang/String;", "", "", "args", "[Ljava/lang/Object;", "getArgs", "()[Ljava/lang/Object;", "setArgs", "([Ljava/lang/Object;)V", "Lkotlin/Function0;", "Lua/k0;", "Landroidx/compose/runtime/Composable;", "screen", "Lkotlin/jvm/functions/Function2;", "getScreen", "()Lkotlin/jvm/functions/Function2;", "bigScreen", "getBigScreen", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class RequestRoomsDest implements AppDestination {
        public static final int $stable;
        private static final Function2 bigScreen;
        private static final Function2 screen;
        public static final RequestRoomsDest INSTANCE = new RequestRoomsDest();
        private static final String route = NavLinks.REQUEST_ROOMS;
        private static Object[] args = new Object[0];

        static {
            ComposableSingletons$NavDestinationsKt composableSingletons$NavDestinationsKt = ComposableSingletons$NavDestinationsKt.INSTANCE;
            screen = composableSingletons$NavDestinationsKt.m10005getLambda$1170692923$app_productionPFast();
            bigScreen = composableSingletons$NavDestinationsKt.getLambda$2123371543$app_productionPFast();
            $stable = 8;
        }

        private RequestRoomsDest() {
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Object[] getArgs() {
            return args;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Function2 getBigScreen() {
            return bigScreen;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public String getRoute() {
            return route;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Function2 getScreen() {
            return screen;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public void setArgs(Object[] objArr) {
            y.i(objArr, "<set-?>");
            args = objArr;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @StabilityInferred(parameters = 0)
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096D¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR*\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R%\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\b\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R%\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\b\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcu/todus/android/uiCompose/navigation/NavDestinations$SearchDest;", "Lcu/todus/android/uiCompose/navigation/NavDestinations$AppDestination;", "<init>", "()V", "", "route", "Ljava/lang/String;", "getRoute", "()Ljava/lang/String;", "", "", "args", "[Ljava/lang/Object;", "getArgs", "()[Ljava/lang/Object;", "setArgs", "([Ljava/lang/Object;)V", "Lkotlin/Function0;", "Lua/k0;", "Landroidx/compose/runtime/Composable;", "screen", "Lkotlin/jvm/functions/Function2;", "getScreen", "()Lkotlin/jvm/functions/Function2;", "bigScreen", "getBigScreen", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class SearchDest implements AppDestination {
        public static final int $stable;
        private static final Function2 bigScreen;
        private static final Function2 screen;
        public static final SearchDest INSTANCE = new SearchDest();
        private static final String route = NavLinks.SEARCH;
        private static Object[] args = new Object[0];

        static {
            ComposableSingletons$NavDestinationsKt composableSingletons$NavDestinationsKt = ComposableSingletons$NavDestinationsKt.INSTANCE;
            screen = composableSingletons$NavDestinationsKt.m10071getLambda$953101436$app_productionPFast();
            bigScreen = composableSingletons$NavDestinationsKt.m10003getLambda$1067800490$app_productionPFast();
            $stable = 8;
        }

        private SearchDest() {
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Object[] getArgs() {
            return args;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Function2 getBigScreen() {
            return bigScreen;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public String getRoute() {
            return route;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Function2 getScreen() {
            return screen;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public void setArgs(Object[] objArr) {
            y.i(objArr, "<set-?>");
            args = objArr;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @StabilityInferred(parameters = 0)
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096D¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR*\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R%\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\b\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R%\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\b\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcu/todus/android/uiCompose/navigation/NavDestinations$SearchUserDest;", "Lcu/todus/android/uiCompose/navigation/NavDestinations$AppDestination;", "<init>", "()V", "", "route", "Ljava/lang/String;", "getRoute", "()Ljava/lang/String;", "", "", "args", "[Ljava/lang/Object;", "getArgs", "()[Ljava/lang/Object;", "setArgs", "([Ljava/lang/Object;)V", "Lkotlin/Function0;", "Lua/k0;", "Landroidx/compose/runtime/Composable;", "screen", "Lkotlin/jvm/functions/Function2;", "getScreen", "()Lkotlin/jvm/functions/Function2;", "bigScreen", "getBigScreen", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class SearchUserDest implements AppDestination {
        public static final int $stable;
        private static final Function2 bigScreen;
        private static final Function2 screen;
        public static final SearchUserDest INSTANCE = new SearchUserDest();
        private static final String route = NavLinks.SEARCH_USER;
        private static Object[] args = new Object[0];

        static {
            ComposableSingletons$NavDestinationsKt composableSingletons$NavDestinationsKt = ComposableSingletons$NavDestinationsKt.INSTANCE;
            screen = composableSingletons$NavDestinationsKt.getLambda$2019416431$app_productionPFast();
            bigScreen = composableSingletons$NavDestinationsKt.getLambda$1812788545$app_productionPFast();
            $stable = 8;
        }

        private SearchUserDest() {
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Object[] getArgs() {
            return args;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Function2 getBigScreen() {
            return bigScreen;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public String getRoute() {
            return route;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Function2 getScreen() {
            return screen;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public void setArgs(Object[] objArr) {
            y.i(objArr, "<set-?>");
            args = objArr;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @StabilityInferred(parameters = 0)
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096D¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR*\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R%\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\b\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R%\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\b\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcu/todus/android/uiCompose/navigation/NavDestinations$SecretRoomAccessDest;", "Lcu/todus/android/uiCompose/navigation/NavDestinations$AppDestination;", "<init>", "()V", "", "route", "Ljava/lang/String;", "getRoute", "()Ljava/lang/String;", "", "", "args", "[Ljava/lang/Object;", "getArgs", "()[Ljava/lang/Object;", "setArgs", "([Ljava/lang/Object;)V", "Lkotlin/Function0;", "Lua/k0;", "Landroidx/compose/runtime/Composable;", "screen", "Lkotlin/jvm/functions/Function2;", "getScreen", "()Lkotlin/jvm/functions/Function2;", "bigScreen", "getBigScreen", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class SecretRoomAccessDest implements AppDestination {
        public static final int $stable;
        private static final Function2 bigScreen;
        private static final Function2 screen;
        public static final SecretRoomAccessDest INSTANCE = new SecretRoomAccessDest();
        private static final String route = NavLinks.SECRET_ROOM_ACCESS;
        private static Object[] args = new Object[0];

        static {
            ComposableSingletons$NavDestinationsKt composableSingletons$NavDestinationsKt = ComposableSingletons$NavDestinationsKt.INSTANCE;
            screen = composableSingletons$NavDestinationsKt.getLambda$1894107019$app_productionPFast();
            bigScreen = composableSingletons$NavDestinationsKt.getLambda$1383153117$app_productionPFast();
            $stable = 8;
        }

        private SecretRoomAccessDest() {
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Object[] getArgs() {
            return args;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Function2 getBigScreen() {
            return bigScreen;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public String getRoute() {
            return route;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Function2 getScreen() {
            return screen;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public void setArgs(Object[] objArr) {
            y.i(objArr, "<set-?>");
            args = objArr;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @StabilityInferred(parameters = 0)
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096D¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR*\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R%\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\b\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R%\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\b\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcu/todus/android/uiCompose/navigation/NavDestinations$SecretRoomsDest;", "Lcu/todus/android/uiCompose/navigation/NavDestinations$AppDestination;", "<init>", "()V", "", "route", "Ljava/lang/String;", "getRoute", "()Ljava/lang/String;", "", "", "args", "[Ljava/lang/Object;", "getArgs", "()[Ljava/lang/Object;", "setArgs", "([Ljava/lang/Object;)V", "Lkotlin/Function0;", "Lua/k0;", "Landroidx/compose/runtime/Composable;", "screen", "Lkotlin/jvm/functions/Function2;", "getScreen", "()Lkotlin/jvm/functions/Function2;", "bigScreen", "getBigScreen", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class SecretRoomsDest implements AppDestination {
        public static final int $stable;
        private static final Function2 bigScreen;
        private static final Function2 screen;
        public static final SecretRoomsDest INSTANCE = new SecretRoomsDest();
        private static final String route = NavLinks.SECRET_ROOMS;
        private static Object[] args = new Object[0];

        static {
            ComposableSingletons$NavDestinationsKt composableSingletons$NavDestinationsKt = ComposableSingletons$NavDestinationsKt.INSTANCE;
            screen = composableSingletons$NavDestinationsKt.m10044getLambda$293894906$app_productionPFast();
            bigScreen = composableSingletons$NavDestinationsKt.getLambda$1890575220$app_productionPFast();
            $stable = 8;
        }

        private SecretRoomsDest() {
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Object[] getArgs() {
            return args;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Function2 getBigScreen() {
            return bigScreen;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public String getRoute() {
            return route;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Function2 getScreen() {
            return screen;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public void setArgs(Object[] objArr) {
            y.i(objArr, "<set-?>");
            args = objArr;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @StabilityInferred(parameters = 0)
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096D¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR*\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R%\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\b\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R%\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\b\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcu/todus/android/uiCompose/navigation/NavDestinations$SendToDest;", "Lcu/todus/android/uiCompose/navigation/NavDestinations$AppDestination;", "<init>", "()V", "", "route", "Ljava/lang/String;", "getRoute", "()Ljava/lang/String;", "", "", "args", "[Ljava/lang/Object;", "getArgs", "()[Ljava/lang/Object;", "setArgs", "([Ljava/lang/Object;)V", "Lkotlin/Function0;", "Lua/k0;", "Landroidx/compose/runtime/Composable;", "screen", "Lkotlin/jvm/functions/Function2;", "getScreen", "()Lkotlin/jvm/functions/Function2;", "bigScreen", "getBigScreen", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class SendToDest implements AppDestination {
        public static final int $stable;
        private static final Function2 bigScreen;
        private static final Function2 screen;
        public static final SendToDest INSTANCE = new SendToDest();
        private static final String route = NavLinks.SEND_TO;
        private static Object[] args = new Object[0];

        static {
            ComposableSingletons$NavDestinationsKt composableSingletons$NavDestinationsKt = ComposableSingletons$NavDestinationsKt.INSTANCE;
            screen = composableSingletons$NavDestinationsKt.getLambda$358414207$app_productionPFast();
            bigScreen = composableSingletons$NavDestinationsKt.getLambda$243715153$app_productionPFast();
            $stable = 8;
        }

        private SendToDest() {
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Object[] getArgs() {
            return args;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Function2 getBigScreen() {
            return bigScreen;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public String getRoute() {
            return route;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Function2 getScreen() {
            return screen;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public void setArgs(Object[] objArr) {
            y.i(objArr, "<set-?>");
            args = objArr;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @StabilityInferred(parameters = 0)
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096D¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR*\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R%\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\b\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R%\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\b\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcu/todus/android/uiCompose/navigation/NavDestinations$SettingScreenDest;", "Lcu/todus/android/uiCompose/navigation/NavDestinations$AppDestination;", "<init>", "()V", "", "route", "Ljava/lang/String;", "getRoute", "()Ljava/lang/String;", "", "", "args", "[Ljava/lang/Object;", "getArgs", "()[Ljava/lang/Object;", "setArgs", "([Ljava/lang/Object;)V", "Lkotlin/Function0;", "Lua/k0;", "Landroidx/compose/runtime/Composable;", "screen", "Lkotlin/jvm/functions/Function2;", "getScreen", "()Lkotlin/jvm/functions/Function2;", "bigScreen", "getBigScreen", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class SettingScreenDest implements AppDestination {
        public static final int $stable;
        private static final Function2 bigScreen;
        private static final Function2 screen;
        public static final SettingScreenDest INSTANCE = new SettingScreenDest();
        private static final String route = NavLinks.SETTING;
        private static Object[] args = new Object[0];

        static {
            ComposableSingletons$NavDestinationsKt composableSingletons$NavDestinationsKt = ComposableSingletons$NavDestinationsKt.INSTANCE;
            screen = composableSingletons$NavDestinationsKt.getLambda$2144123770$app_productionPFast();
            bigScreen = composableSingletons$NavDestinationsKt.getLambda$1180907112$app_productionPFast();
            $stable = 8;
        }

        private SettingScreenDest() {
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Object[] getArgs() {
            return args;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Function2 getBigScreen() {
            return bigScreen;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public String getRoute() {
            return route;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Function2 getScreen() {
            return screen;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public void setArgs(Object[] objArr) {
            y.i(objArr, "<set-?>");
            args = objArr;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @StabilityInferred(parameters = 0)
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096D¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR*\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R%\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\b\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R%\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\b\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcu/todus/android/uiCompose/navigation/NavDestinations$SocialProfileDest;", "Lcu/todus/android/uiCompose/navigation/NavDestinations$AppDestination;", "<init>", "()V", "", "route", "Ljava/lang/String;", "getRoute", "()Ljava/lang/String;", "", "", "args", "[Ljava/lang/Object;", "getArgs", "()[Ljava/lang/Object;", "setArgs", "([Ljava/lang/Object;)V", "Lkotlin/Function0;", "Lua/k0;", "Landroidx/compose/runtime/Composable;", "screen", "Lkotlin/jvm/functions/Function2;", "getScreen", "()Lkotlin/jvm/functions/Function2;", "bigScreen", "getBigScreen", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class SocialProfileDest implements AppDestination {
        public static final int $stable;
        private static final Function2 bigScreen;
        private static final Function2 screen;
        public static final SocialProfileDest INSTANCE = new SocialProfileDest();
        private static final String route = NavLinks.SOCIAL_PROFILE;
        private static Object[] args = new Object[0];

        static {
            ComposableSingletons$NavDestinationsKt composableSingletons$NavDestinationsKt = ComposableSingletons$NavDestinationsKt.INSTANCE;
            screen = composableSingletons$NavDestinationsKt.getLambda$492769818$app_productionPFast();
            bigScreen = composableSingletons$NavDestinationsKt.m10053getLambda$470446840$app_productionPFast();
            $stable = 8;
        }

        private SocialProfileDest() {
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Object[] getArgs() {
            return args;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Function2 getBigScreen() {
            return bigScreen;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public String getRoute() {
            return route;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Function2 getScreen() {
            return screen;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public void setArgs(Object[] objArr) {
            y.i(objArr, "<set-?>");
            args = objArr;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @StabilityInferred(parameters = 0)
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096D¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR*\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R%\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\b\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R%\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\b\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcu/todus/android/uiCompose/navigation/NavDestinations$StatusEditorDest;", "Lcu/todus/android/uiCompose/navigation/NavDestinations$AppDestination;", "<init>", "()V", "", "route", "Ljava/lang/String;", "getRoute", "()Ljava/lang/String;", "", "", "args", "[Ljava/lang/Object;", "getArgs", "()[Ljava/lang/Object;", "setArgs", "([Ljava/lang/Object;)V", "Lkotlin/Function0;", "Lua/k0;", "Landroidx/compose/runtime/Composable;", "screen", "Lkotlin/jvm/functions/Function2;", "getScreen", "()Lkotlin/jvm/functions/Function2;", "bigScreen", "getBigScreen", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class StatusEditorDest implements AppDestination {
        public static final int $stable;
        private static final Function2 bigScreen;
        private static final Function2 screen;
        public static final StatusEditorDest INSTANCE = new StatusEditorDest();
        private static final String route = NavLinks.STATUS_EDITOR;
        private static Object[] args = new Object[0];

        static {
            ComposableSingletons$NavDestinationsKt composableSingletons$NavDestinationsKt = ComposableSingletons$NavDestinationsKt.INSTANCE;
            screen = composableSingletons$NavDestinationsKt.m10033getLambda$1982112229$app_productionPFast();
            bigScreen = composableSingletons$NavDestinationsKt.getLambda$1311952237$app_productionPFast();
            $stable = 8;
        }

        private StatusEditorDest() {
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Object[] getArgs() {
            return args;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Function2 getBigScreen() {
            return bigScreen;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public String getRoute() {
            return route;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Function2 getScreen() {
            return screen;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public void setArgs(Object[] objArr) {
            y.i(objArr, "<set-?>");
            args = objArr;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @StabilityInferred(parameters = 0)
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096D¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR*\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R%\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\b\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R%\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\b\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcu/todus/android/uiCompose/navigation/NavDestinations$StatusListDest;", "Lcu/todus/android/uiCompose/navigation/NavDestinations$AppDestination;", "<init>", "()V", "", "route", "Ljava/lang/String;", "getRoute", "()Ljava/lang/String;", "", "", "args", "[Ljava/lang/Object;", "getArgs", "()[Ljava/lang/Object;", "setArgs", "([Ljava/lang/Object;)V", "Lkotlin/Function0;", "Lua/k0;", "Landroidx/compose/runtime/Composable;", "screen", "Lkotlin/jvm/functions/Function2;", "getScreen", "()Lkotlin/jvm/functions/Function2;", "bigScreen", "getBigScreen", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class StatusListDest implements AppDestination {
        public static final int $stable;
        private static final Function2 bigScreen;
        private static final Function2 screen;
        public static final StatusListDest INSTANCE = new StatusListDest();
        private static final String route = NavLinks.STATUS_LIST;
        private static Object[] args = new Object[0];

        static {
            ComposableSingletons$NavDestinationsKt composableSingletons$NavDestinationsKt = ComposableSingletons$NavDestinationsKt.INSTANCE;
            screen = composableSingletons$NavDestinationsKt.m10012getLambda$1405530612$app_productionPFast();
            bigScreen = composableSingletons$NavDestinationsKt.m10023getLambda$1612158498$app_productionPFast();
            $stable = 8;
        }

        private StatusListDest() {
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Object[] getArgs() {
            return args;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Function2 getBigScreen() {
            return bigScreen;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public String getRoute() {
            return route;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Function2 getScreen() {
            return screen;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public void setArgs(Object[] objArr) {
            y.i(objArr, "<set-?>");
            args = objArr;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @StabilityInferred(parameters = 0)
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096D¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR*\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R%\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\b\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R%\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\b\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcu/todus/android/uiCompose/navigation/NavDestinations$StatusPreviewDest;", "Lcu/todus/android/uiCompose/navigation/NavDestinations$AppDestination;", "<init>", "()V", "", "route", "Ljava/lang/String;", "getRoute", "()Ljava/lang/String;", "", "", "args", "[Ljava/lang/Object;", "getArgs", "()[Ljava/lang/Object;", "setArgs", "([Ljava/lang/Object;)V", "Lkotlin/Function0;", "Lua/k0;", "Landroidx/compose/runtime/Composable;", "screen", "Lkotlin/jvm/functions/Function2;", "getScreen", "()Lkotlin/jvm/functions/Function2;", "bigScreen", "getBigScreen", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class StatusPreviewDest implements AppDestination {
        public static final int $stable;
        private static final Function2 bigScreen;
        private static final Function2 screen;
        public static final StatusPreviewDest INSTANCE = new StatusPreviewDest();
        private static final String route = NavLinks.STATUS_PREVIEW;
        private static Object[] args = new Object[0];

        static {
            ComposableSingletons$NavDestinationsKt composableSingletons$NavDestinationsKt = ComposableSingletons$NavDestinationsKt.INSTANCE;
            screen = composableSingletons$NavDestinationsKt.m10018getLambda$1524770540$app_productionPFast();
            bigScreen = composableSingletons$NavDestinationsKt.getLambda$1806980098$app_productionPFast();
            $stable = 8;
        }

        private StatusPreviewDest() {
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Object[] getArgs() {
            return args;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Function2 getBigScreen() {
            return bigScreen;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public String getRoute() {
            return route;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Function2 getScreen() {
            return screen;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public void setArgs(Object[] objArr) {
            y.i(objArr, "<set-?>");
            args = objArr;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @StabilityInferred(parameters = 0)
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096D¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR*\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R%\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\b\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R%\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\b\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcu/todus/android/uiCompose/navigation/NavDestinations$ThemeSelectorDest;", "Lcu/todus/android/uiCompose/navigation/NavDestinations$AppDestination;", "<init>", "()V", "", "route", "Ljava/lang/String;", "getRoute", "()Ljava/lang/String;", "", "", "args", "[Ljava/lang/Object;", "getArgs", "()[Ljava/lang/Object;", "setArgs", "([Ljava/lang/Object;)V", "Lkotlin/Function0;", "Lua/k0;", "Landroidx/compose/runtime/Composable;", "screen", "Lkotlin/jvm/functions/Function2;", "getScreen", "()Lkotlin/jvm/functions/Function2;", "bigScreen", "getBigScreen", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class ThemeSelectorDest implements AppDestination {
        public static final int $stable;
        private static final Function2 bigScreen;
        private static final Function2 screen;
        public static final ThemeSelectorDest INSTANCE = new ThemeSelectorDest();
        private static final String route = NavLinks.THEME_SELECTOR;
        private static Object[] args = new Object[0];

        static {
            ComposableSingletons$NavDestinationsKt composableSingletons$NavDestinationsKt = ComposableSingletons$NavDestinationsKt.INSTANCE;
            screen = composableSingletons$NavDestinationsKt.getLambda$893171558$app_productionPFast();
            bigScreen = composableSingletons$NavDestinationsKt.m10059getLambda$70045100$app_productionPFast();
            $stable = 8;
        }

        private ThemeSelectorDest() {
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Object[] getArgs() {
            return args;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Function2 getBigScreen() {
            return bigScreen;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public String getRoute() {
            return route;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Function2 getScreen() {
            return screen;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public void setArgs(Object[] objArr) {
            y.i(objArr, "<set-?>");
            args = objArr;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @StabilityInferred(parameters = 0)
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096D¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR*\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R%\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\b\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R%\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\b\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcu/todus/android/uiCompose/navigation/NavDestinations$VerifyDest;", "Lcu/todus/android/uiCompose/navigation/NavDestinations$AppDestination;", "<init>", "()V", "", "route", "Ljava/lang/String;", "getRoute", "()Ljava/lang/String;", "", "", "args", "[Ljava/lang/Object;", "getArgs", "()[Ljava/lang/Object;", "setArgs", "([Ljava/lang/Object;)V", "Lkotlin/Function0;", "Lua/k0;", "Landroidx/compose/runtime/Composable;", "screen", "Lkotlin/jvm/functions/Function2;", "getScreen", "()Lkotlin/jvm/functions/Function2;", "bigScreen", "getBigScreen", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class VerifyDest implements AppDestination {
        public static final int $stable;
        private static final Function2 bigScreen;
        private static final Function2 screen;
        public static final VerifyDest INSTANCE = new VerifyDest();
        private static final String route = NavLinks.VERIFY;
        private static Object[] args = new Object[0];

        static {
            ComposableSingletons$NavDestinationsKt composableSingletons$NavDestinationsKt = ComposableSingletons$NavDestinationsKt.INSTANCE;
            screen = composableSingletons$NavDestinationsKt.getLambda$1250327253$app_productionPFast();
            bigScreen = composableSingletons$NavDestinationsKt.getLambda$1135628199$app_productionPFast();
            $stable = 8;
        }

        private VerifyDest() {
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Object[] getArgs() {
            return args;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Function2 getBigScreen() {
            return bigScreen;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public String getRoute() {
            return route;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Function2 getScreen() {
            return screen;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public void setArgs(Object[] objArr) {
            y.i(objArr, "<set-?>");
            args = objArr;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @StabilityInferred(parameters = 0)
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096D¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR*\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R%\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\b\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R%\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\b\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcu/todus/android/uiCompose/navigation/NavDestinations$WelcomeDest;", "Lcu/todus/android/uiCompose/navigation/NavDestinations$AppDestination;", "<init>", "()V", "", "route", "Ljava/lang/String;", "getRoute", "()Ljava/lang/String;", "", "", "args", "[Ljava/lang/Object;", "getArgs", "()[Ljava/lang/Object;", "setArgs", "([Ljava/lang/Object;)V", "Lkotlin/Function0;", "Lua/k0;", "Landroidx/compose/runtime/Composable;", "screen", "Lkotlin/jvm/functions/Function2;", "getScreen", "()Lkotlin/jvm/functions/Function2;", "bigScreen", "getBigScreen", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class WelcomeDest implements AppDestination {
        public static final int $stable;
        private static final Function2 bigScreen;
        private static final Function2 screen;
        public static final WelcomeDest INSTANCE = new WelcomeDest();
        private static final String route = NavLinks.WELCOME;
        private static Object[] args = new Object[0];

        static {
            ComposableSingletons$NavDestinationsKt composableSingletons$NavDestinationsKt = ComposableSingletons$NavDestinationsKt.INSTANCE;
            screen = composableSingletons$NavDestinationsKt.m10040getLambda$2075210816$app_productionPFast();
            bigScreen = composableSingletons$NavDestinationsKt.m10010getLambda$1335914194$app_productionPFast();
            $stable = 8;
        }

        private WelcomeDest() {
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Object[] getArgs() {
            return args;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Function2 getBigScreen() {
            return bigScreen;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public String getRoute() {
            return route;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public Function2 getScreen() {
            return screen;
        }

        @Override // cu.todus.android.uiCompose.navigation.NavDestinations.AppDestination
        public void setArgs(Object[] objArr) {
            y.i(objArr, "<set-?>");
            args = objArr;
        }
    }

    private NavDestinations() {
    }
}
