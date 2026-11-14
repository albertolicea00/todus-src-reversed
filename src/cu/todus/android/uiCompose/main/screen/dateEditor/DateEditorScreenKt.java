package cu.todus.android.uiCompose.main.screen.dateEditor;

import android.content.Context;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.foundation.layout.e3;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.ScaffoldKt;
import androidx.compose.material.ScaffoldState;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.DeleteKt;
import androidx.compose.material.icons.filled.EditCalendarKt;
import androidx.compose.material3.AppBarKt;
import androidx.compose.material3.FloatingActionButtonKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.TopAppBarDefaults;
import androidx.compose.material3.TopAppBarScrollBehavior;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.snapshots.SnapshotStateMap;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.navigation.NavHostController;
import androidx.p001lifecycle.HasDefaultViewModelProviderFactory;
import androidx.p001lifecycle.ViewModelProvider;
import androidx.p001lifecycle.ViewModelStoreOwner;
import androidx.p001lifecycle.viewmodel.CreationExtras;
import androidx.p001lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.p001lifecycle.viewmodel.compose.ViewModelKt;
import androidx.test.internal.runner.listener.InstrumentationResultPrinter;
import cu.todus.android.R;
import cu.todus.android.data.db.pojo.content.TemplateContent;
import cu.todus.android.repositories.MainRepository;
import cu.todus.android.uiCompose.shared.insideNotification.Cause;
import cu.todus.android.uiCompose.shared.insideNotification.InsideNotificationState;
import cu.z17.views.button.Z17ButtonsKt;
import cu.z17.views.dialogs.Z17DialogsKt;
import cu.z17.views.inputText.Z17InputTextKt;
import cu.z17.views.label.Z17LabelKt;
import cu.z17.views.picture.Z17PictureKt;
import cu.z17.views.scaffold.Z17ScaffoldKt;
import cu.z17.views.spinner.Z17SpinnerKt;
import cu.z17.views.topBar.Z17TopBarKt;
import j$.time.LocalDateTime;
import j$.time.format.DateTimeFormatter;
import java.text.DateFormatSymbols;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.z0;
import ua.k0;
import va.w0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b$\u001a)\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b\u001ac\u0010\u0014\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000e0\r2\u001e\u0010\u0011\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0004\u0012\u00020\u00060\u00102\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u0012H\u0007¢\u0006\u0004\b\u0014\u0010\u0015\u001aQ\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\t2\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000e0\r2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00060\u00122\u0006\u0010\u0018\u001a\u00020\u000b2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00060\u0012H\u0007¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u0019\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u0015\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u000e¢\u0006\u0004\b\u001f\u0010 \u001a-\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000e0\r2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0004\b\"\u0010#\u001a\u0015\u0010%\u001a\u00020\u00022\u0006\u0010$\u001a\u00020\u000e¢\u0006\u0004\b%\u0010&\u001a\u0015\u0010(\u001a\u00020\u00022\u0006\u0010'\u001a\u00020\u000e¢\u0006\u0004\b(\u0010&\u001a5\u0010+\u001a\u00020\u000b2\u0012\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000e0\r2\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0004\b+\u0010,\u001a!\u0010-\u001a\u00020\u00022\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0004\b-\u0010.¨\u00066²\u0006\u000e\u0010/\u001a\u00020\u000e8\n@\nX\u008a\u008e\u0002²\u0006\u000e\u00100\u001a\u00020\u000b8\n@\nX\u008a\u008e\u0002²\u0006\u000e\u00101\u001a\u00020\u000e8\n@\nX\u008a\u008e\u0002²\u0006\u000e\u00102\u001a\u00020\u000e8\n@\nX\u008a\u008e\u0002²\u0006\u000e\u00103\u001a\u00020\u00028\n@\nX\u008a\u008e\u0002²\u0006\u000e\u00104\u001a\u00020\u000e8\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010$\u001a\u00020\u000e8\n@\nX\u008a\u008e\u0002²\u0006\u000e\u00105\u001a\u00020\u000e8\n@\nX\u008a\u008e\u0002"}, d2 = {"Landroidx/navigation/NavHostController;", "navHostController", "", "params", "Lcu/todus/android/uiCompose/main/screen/dateEditor/DateEditorViewModel;", "viewModel", "Lua/k0;", "DateEditorScreen", "(Landroidx/navigation/NavHostController;Ljava/lang/String;Lcu/todus/android/uiCompose/main/screen/dateEditor/DateEditorViewModel;Landroidx/compose/runtime/Composer;II)V", "Landroidx/compose/ui/Modifier;", "modifier", "", "show", "", "", "initialDate", "Lkotlin/Function1;", "onSelected", "Lkotlin/Function0;", "onClose", "TimePicker", "(Landroidx/compose/ui/Modifier;ZLjava/util/Map;Lkotlin/jvm/functions/Function1;Llb/a;Landroidx/compose/runtime/Composer;II)V", "date", "onClick", "showDelete", "onDelete", "DatePoint", "(Landroidx/compose/ui/Modifier;Ljava/util/Map;Llb/a;ZLlb/a;Landroidx/compose/runtime/Composer;II)V", "getNextDay", "()Ljava/util/Map;", "hour24", "convert24hTo12h", "(I)I", "dateMap", "getNextDayFromMap", "(Ljava/util/Map;)Ljava/util/Map;", "month", "getMonthName", "(I)Ljava/lang/String;", TemplateContent.NUMBER_TYPE, "getDoubleDigits", "firstDateMap", "secondDateMap", "isSecondDateAfterFirst", "(Ljava/util/Map;Ljava/util/Map;)Z", "formatDateFromMap", "(Ljava/util/Map;)Ljava/lang/String;", "showInputDate", "isRange", "hour", "minute", "amPm", "day", "year", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class DateEditorScreenKt {
    /* JADX WARN: Code duplicated, block: B:27:0x0056  */
    /* JADX WARN: Code duplicated, block: B:58:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:61:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:64:0x0114  */
    /* JADX WARN: Code duplicated, block: B:67:0x012b  */
    /* JADX WARN: Code duplicated, block: B:70:0x0154  */
    /* JADX WARN: Code duplicated, block: B:71:0x01bd  */
    /* JADX WARN: Code duplicated, block: B:74:0x01ce  */
    /* JADX WARN: Code duplicated, block: B:77:0x01e6  */
    /* JADX WARN: Code duplicated, block: B:80:0x029f  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void DateEditorScreen(final NavHostController navHostController, final String params, DateEditorViewModel dateEditorViewModel, Composer composer, final int i10, final int i11) {
        int i12;
        Composer composer2;
        final DateEditorViewModel dateEditorViewModel2;
        int i13;
        Composer composer3;
        Object objRememberedValue;
        Composer.Companion companion;
        int i14;
        Object objRememberedValue2;
        Object objRememberedValue3;
        Object objRememberedValue4;
        Object objRememberedValue5;
        Object objRememberedValue6;
        int i15;
        DateEditorViewModel dateEditorViewModel3 = dateEditorViewModel;
        kotlin.jvm.internal.y.i(navHostController, "navHostController");
        kotlin.jvm.internal.y.i(params, "params");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1459853635);
        if ((i10 & 6) == 0) {
            i12 = (composerStartRestartGroup.changedInstance(navHostController) ? 4 : 2) | i10;
        } else {
            i12 = i10;
        }
        if ((i10 & 48) == 0) {
            i12 |= composerStartRestartGroup.changed(params) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            if ((i11 & 4) != 0) {
                i15 = 128;
            } else {
                if ((i10 & 512) == 0 ? composerStartRestartGroup.changed(dateEditorViewModel3) : composerStartRestartGroup.changedInstance(dateEditorViewModel3)) {
                    i15 = 256;
                } else {
                    i15 = 128;
                }
            }
            i12 |= i15;
        }
        if (composerStartRestartGroup.shouldExecute((i12 & 147) != 146, i12 & 1)) {
            composerStartRestartGroup.startDefaults();
            if ((i10 & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                if ((i11 & 4) != 0) {
                    ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composerStartRestartGroup, 6);
                    if (current == null) {
                        throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                    }
                    i13 = 0;
                    composer3 = composerStartRestartGroup;
                    dateEditorViewModel3 = (DateEditorViewModel) ViewModelKt.viewModel(z0.b(DateEditorViewModel.class), current, (String) null, (ViewModelProvider.Factory) null, current instanceof HasDefaultViewModelProviderFactory ? ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras() : CreationExtras.Empty.INSTANCE, composerStartRestartGroup, 0, 0);
                    i12 &= -897;
                }
                composer3.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1459853635, i12, -1, "cu.todus.android.uiCompose.main.screen.dateEditor.DateEditorScreen (DateEditorScreen.kt:69)");
                }
                final Context context = (Context) composer3.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                objRememberedValue = composer3.rememberedValue();
                companion = Composer.INSTANCE;
                if (objRememberedValue == companion.getEmpty()) {
                    objRememberedValue = (DateEditorParams) dateEditorViewModel3.getGson().j(params, DateEditorParams.class);
                    composer3.updateRememberedValue(objRememberedValue);
                }
                final DateEditorParams dateEditorParams = (DateEditorParams) objRememberedValue;
                ScaffoldState scaffoldStateRememberScaffoldState = ScaffoldKt.rememberScaffoldState(null, null, composer3, i13, 3);
                i14 = i13;
                objRememberedValue2 = composer3.rememberedValue();
                if (objRememberedValue2 == companion.getEmpty()) {
                    objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
                    composer3.updateRememberedValue(objRememberedValue2);
                }
                final MutableState mutableState = (MutableState) objRememberedValue2;
                objRememberedValue3 = composer3.rememberedValue();
                if (objRememberedValue3 == companion.getEmpty()) {
                    objRememberedValue3 = SnapshotIntStateKt.mutableIntStateOf(-1);
                    composer3.updateRememberedValue(objRememberedValue3);
                }
                final MutableIntState mutableIntState = (MutableIntState) objRememberedValue3;
                objRememberedValue4 = composer3.rememberedValue();
                if (objRememberedValue4 == companion.getEmpty()) {
                    Map<String, Integer> nextDay = getNextDay();
                    Integer num = nextDay.get("day");
                    kotlin.jvm.internal.y.f(num);
                    Pair pairA = ua.z.a("day", num);
                    Integer num2 = nextDay.get("month");
                    kotlin.jvm.internal.y.f(num2);
                    Pair pairA2 = ua.z.a("month", num2);
                    Integer num3 = nextDay.get("year");
                    kotlin.jvm.internal.y.f(num3);
                    Pair pairA3 = ua.z.a("year", num3);
                    Integer num4 = nextDay.get("hour");
                    kotlin.jvm.internal.y.f(num4);
                    Pair pairA4 = ua.z.a("hour", num4);
                    Integer num5 = nextDay.get("minute");
                    kotlin.jvm.internal.y.f(num5);
                    Pair pairA5 = ua.z.a("minute", num5);
                    Integer num6 = nextDay.get(InstrumentationResultPrinter.REPORT_KEY_NUM_CURRENT);
                    kotlin.jvm.internal.y.f(num6);
                    Pair pairA6 = ua.z.a(InstrumentationResultPrinter.REPORT_KEY_NUM_CURRENT, num6);
                    Pair[] pairArr = new Pair[6];
                    pairArr[i14] = pairA;
                    pairArr[1] = pairA2;
                    pairArr[2] = pairA3;
                    pairArr[3] = pairA4;
                    pairArr[4] = pairA5;
                    pairArr[5] = pairA6;
                    objRememberedValue4 = SnapshotStateKt.mutableStateMapOf(pairArr);
                    composer3.updateRememberedValue(objRememberedValue4);
                }
                final SnapshotStateMap snapshotStateMap = (SnapshotStateMap) objRememberedValue4;
                objRememberedValue5 = composer3.rememberedValue();
                if (objRememberedValue5 == companion.getEmpty()) {
                    objRememberedValue5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                    composer3.updateRememberedValue(objRememberedValue5);
                }
                final MutableState mutableState2 = (MutableState) objRememberedValue5;
                objRememberedValue6 = composer3.rememberedValue();
                if (objRememberedValue6 == companion.getEmpty()) {
                    Map<String, Integer> nextDay2 = getNextDay();
                    Integer num7 = nextDay2.get("day");
                    kotlin.jvm.internal.y.f(num7);
                    Pair pairA7 = ua.z.a("day", num7);
                    Integer num8 = nextDay2.get("month");
                    kotlin.jvm.internal.y.f(num8);
                    Pair pairA8 = ua.z.a("month", num8);
                    Integer num9 = nextDay2.get("year");
                    kotlin.jvm.internal.y.f(num9);
                    Pair pairA9 = ua.z.a("year", num9);
                    Integer num10 = nextDay2.get("hour");
                    kotlin.jvm.internal.y.f(num10);
                    Pair pairA10 = ua.z.a("hour", num10);
                    Integer num11 = nextDay2.get("minute");
                    kotlin.jvm.internal.y.f(num11);
                    Pair pairA11 = ua.z.a("minute", num11);
                    Integer num12 = nextDay2.get(InstrumentationResultPrinter.REPORT_KEY_NUM_CURRENT);
                    kotlin.jvm.internal.y.f(num12);
                    Pair pairA12 = ua.z.a(InstrumentationResultPrinter.REPORT_KEY_NUM_CURRENT, num12);
                    Pair[] pairArr2 = new Pair[6];
                    pairArr2[i14] = pairA7;
                    pairArr2[1] = pairA8;
                    pairArr2[2] = pairA9;
                    pairArr2[3] = pairA10;
                    pairArr2[4] = pairA11;
                    pairArr2[5] = pairA12;
                    objRememberedValue6 = SnapshotStateKt.mutableStateMapOf(pairArr2);
                    composer3.updateRememberedValue(objRememberedValue6);
                }
                final SnapshotStateMap snapshotStateMap2 = (SnapshotStateMap) objRememberedValue6;
                final DateEditorViewModel dateEditorViewModel4 = dateEditorViewModel3;
                Composer composer4 = composer3;
                Z17ScaffoldKt.m10301Z17BaseScaffoldueL0Wzs(ComposableLambdaKt.rememberComposableLambda(-1309027063, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.dateEditor.v
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return DateEditorScreenKt.DateEditorScreen$lambda$10(navHostController, (TopAppBarScrollBehavior) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composer3, 54), false, false, false, ComposableLambdaKt.rememberComposableLambda(-1771459019, true, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.dateEditor.w
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return DateEditorScreenKt.DateEditorScreen$lambda$11(context, dateEditorViewModel4, navHostController, mutableState, dateEditorParams, snapshotStateMap, snapshotStateMap2, mutableState2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composer3, 54), null, 0L, scaffoldStateRememberScaffoldState, null, ComposableLambdaKt.rememberComposableLambda(771897799, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.dateEditor.x
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return DateEditorScreenKt.DateEditorScreen$lambda$12(mutableState, snapshotStateMap, snapshotStateMap2, mutableIntState, mutableState2, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composer3, 54), composer4, 805331382, 360);
                composer2 = composer4;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                dateEditorViewModel2 = dateEditorViewModel4;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i11 & 4) != 0) {
                    i12 &= -897;
                }
            }
            composer3 = composerStartRestartGroup;
            i13 = 0;
            composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1459853635, i12, -1, "cu.todus.android.uiCompose.main.screen.dateEditor.DateEditorScreen (DateEditorScreen.kt:69)");
            }
            final Context context2 = (Context) composer3.consume(AndroidCompositionLocals_androidKt.getLocalContext());
            objRememberedValue = composer3.rememberedValue();
            companion = Composer.INSTANCE;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = (DateEditorParams) dateEditorViewModel3.getGson().j(params, DateEditorParams.class);
                composer3.updateRememberedValue(objRememberedValue);
            }
            final DateEditorParams dateEditorParams2 = (DateEditorParams) objRememberedValue;
            ScaffoldState scaffoldStateRememberScaffoldState2 = ScaffoldKt.rememberScaffoldState(null, null, composer3, i13, 3);
            i14 = i13;
            objRememberedValue2 = composer3.rememberedValue();
            if (objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
                composer3.updateRememberedValue(objRememberedValue2);
            }
            final MutableState mutableState3 = (MutableState) objRememberedValue2;
            objRememberedValue3 = composer3.rememberedValue();
            if (objRememberedValue3 == companion.getEmpty()) {
                objRememberedValue3 = SnapshotIntStateKt.mutableIntStateOf(-1);
                composer3.updateRememberedValue(objRememberedValue3);
            }
            final MutableIntState mutableIntState2 = (MutableIntState) objRememberedValue3;
            objRememberedValue4 = composer3.rememberedValue();
            if (objRememberedValue4 == companion.getEmpty()) {
                Map<String, Integer> nextDay3 = getNextDay();
                Integer num13 = nextDay3.get("day");
                kotlin.jvm.internal.y.f(num13);
                Pair pairA13 = ua.z.a("day", num13);
                Integer num14 = nextDay3.get("month");
                kotlin.jvm.internal.y.f(num14);
                Pair pairA14 = ua.z.a("month", num14);
                Integer num15 = nextDay3.get("year");
                kotlin.jvm.internal.y.f(num15);
                Pair pairA15 = ua.z.a("year", num15);
                Integer num16 = nextDay3.get("hour");
                kotlin.jvm.internal.y.f(num16);
                Pair pairA16 = ua.z.a("hour", num16);
                Integer num17 = nextDay3.get("minute");
                kotlin.jvm.internal.y.f(num17);
                Pair pairA17 = ua.z.a("minute", num17);
                Integer num18 = nextDay3.get(InstrumentationResultPrinter.REPORT_KEY_NUM_CURRENT);
                kotlin.jvm.internal.y.f(num18);
                Pair pairA18 = ua.z.a(InstrumentationResultPrinter.REPORT_KEY_NUM_CURRENT, num18);
                Pair[] pairArr3 = new Pair[6];
                pairArr3[i14] = pairA13;
                pairArr3[1] = pairA14;
                pairArr3[2] = pairA15;
                pairArr3[3] = pairA16;
                pairArr3[4] = pairA17;
                pairArr3[5] = pairA18;
                objRememberedValue4 = SnapshotStateKt.mutableStateMapOf(pairArr3);
                composer3.updateRememberedValue(objRememberedValue4);
            }
            final SnapshotStateMap snapshotStateMap3 = (SnapshotStateMap) objRememberedValue4;
            objRememberedValue5 = composer3.rememberedValue();
            if (objRememberedValue5 == companion.getEmpty()) {
                objRememberedValue5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                composer3.updateRememberedValue(objRememberedValue5);
            }
            final MutableState mutableState4 = (MutableState) objRememberedValue5;
            objRememberedValue6 = composer3.rememberedValue();
            if (objRememberedValue6 == companion.getEmpty()) {
                Map<String, Integer> nextDay4 = getNextDay();
                Integer num19 = nextDay4.get("day");
                kotlin.jvm.internal.y.f(num19);
                Pair pairA19 = ua.z.a("day", num19);
                Integer num20 = nextDay4.get("month");
                kotlin.jvm.internal.y.f(num20);
                Pair pairA20 = ua.z.a("month", num20);
                Integer num21 = nextDay4.get("year");
                kotlin.jvm.internal.y.f(num21);
                Pair pairA21 = ua.z.a("year", num21);
                Integer num110 = nextDay4.get("hour");
                kotlin.jvm.internal.y.f(num110);
                Pair pairA110 = ua.z.a("hour", num110);
                Integer num111 = nextDay4.get("minute");
                kotlin.jvm.internal.y.f(num111);
                Pair pairA111 = ua.z.a("minute", num111);
                Integer num112 = nextDay4.get(InstrumentationResultPrinter.REPORT_KEY_NUM_CURRENT);
                kotlin.jvm.internal.y.f(num112);
                Pair pairA112 = ua.z.a(InstrumentationResultPrinter.REPORT_KEY_NUM_CURRENT, num112);
                Pair[] pairArr4 = new Pair[6];
                pairArr4[i14] = pairA19;
                pairArr4[1] = pairA20;
                pairArr4[2] = pairA21;
                pairArr4[3] = pairA110;
                pairArr4[4] = pairA111;
                pairArr4[5] = pairA112;
                objRememberedValue6 = SnapshotStateKt.mutableStateMapOf(pairArr4);
                composer3.updateRememberedValue(objRememberedValue6);
            }
            final SnapshotStateMap snapshotStateMap4 = (SnapshotStateMap) objRememberedValue6;
            final DateEditorViewModel dateEditorViewModel5 = dateEditorViewModel3;
            Composer composer5 = composer3;
            Z17ScaffoldKt.m10301Z17BaseScaffoldueL0Wzs(ComposableLambdaKt.rememberComposableLambda(-1309027063, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.dateEditor.v
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return DateEditorScreenKt.DateEditorScreen$lambda$10(navHostController, (TopAppBarScrollBehavior) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer3, 54), false, false, false, ComposableLambdaKt.rememberComposableLambda(-1771459019, true, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.dateEditor.w
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DateEditorScreenKt.DateEditorScreen$lambda$11(context2, dateEditorViewModel5, navHostController, mutableState3, dateEditorParams2, snapshotStateMap3, snapshotStateMap4, mutableState4, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer3, 54), null, 0L, scaffoldStateRememberScaffoldState2, null, ComposableLambdaKt.rememberComposableLambda(771897799, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.dateEditor.x
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return DateEditorScreenKt.DateEditorScreen$lambda$12(mutableState3, snapshotStateMap3, snapshotStateMap4, mutableIntState2, mutableState4, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer3, 54), composer5, 805331382, 360);
            composer2 = composer5;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            dateEditorViewModel2 = dateEditorViewModel5;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            dateEditorViewModel2 = dateEditorViewModel3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.dateEditor.y
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DateEditorScreenKt.DateEditorScreen$lambda$13(navHostController, params, dateEditorViewModel2, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 DateEditorScreen$lambda$10(final NavHostController navHostController, TopAppBarScrollBehavior it, Composer composer, int i10) {
        kotlin.jvm.internal.y.i(it, "it");
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1309027063, i10, -1, "cu.todus.android.uiCompose.main.screen.dateEditor.DateEditorScreen.<anonymous> (DateEditorScreen.kt:115)");
            }
            Function2 function2M9935getLambda$88496036$app_productionPFast = ComposableSingletons$DateEditorScreenKt.INSTANCE.m9935getLambda$88496036$app_productionPFast();
            TopAppBarScrollBehavior topAppBarScrollBehaviorPinnedScrollBehavior = TopAppBarDefaults.INSTANCE.pinnedScrollBehavior(AppBarKt.rememberTopAppBarState(0.0f, 0.0f, 0.0f, composer, 0, 7), null, composer, TopAppBarDefaults.$stable << 6, 2);
            boolean zChangedInstance = composer.changedInstance(navHostController);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.dateEditor.u
                    @Override // lb.a
                    public final Object invoke() {
                        return DateEditorScreenKt.DateEditorScreen$lambda$10$0$0(navHostController);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            Z17TopBarKt.m10304Z17TopBardW2gCk(function2M9935getLambda$88496036$app_productionPFast, topAppBarScrollBehaviorPinnedScrollBehavior, false, null, false, navHostController, (lb.a) objRememberedValue, null, 0L, 0L, 0.0f, composer, 6, 0, 1948);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 DateEditorScreen$lambda$10$0$0(NavHostController navHostController) {
        navHostController.navigateUp();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 DateEditorScreen$lambda$11(final Context context, final DateEditorViewModel dateEditorViewModel, final NavHostController navHostController, final MutableState mutableState, final DateEditorParams dateEditorParams, final SnapshotStateMap snapshotStateMap, final SnapshotStateMap snapshotStateMap2, final MutableState mutableState2, Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1771459019, i10, -1, "cu.todus.android.uiCompose.main.screen.dateEditor.DateEditorScreen.<anonymous> (DateEditorScreen.kt:129)");
            }
            ComposableSingletons$DateEditorScreenKt composableSingletons$DateEditorScreenKt = ComposableSingletons$DateEditorScreenKt.INSTANCE;
            Function2 function2M9933getLambda$1329001695$app_productionPFast = composableSingletons$DateEditorScreenKt.m9933getLambda$1329001695$app_productionPFast();
            Function2 function2M9934getLambda$377169856$app_productionPFast = composableSingletons$DateEditorScreenKt.m9934getLambda$377169856$app_productionPFast();
            boolean zChangedInstance = composer.changedInstance(context) | composer.changedInstance(dateEditorViewModel) | composer.changedInstance(navHostController);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.dateEditor.t
                    @Override // lb.a
                    public final Object invoke() {
                        return DateEditorScreenKt.DateEditorScreen$lambda$11$0$0(mutableState, context, dateEditorParams, snapshotStateMap, snapshotStateMap2, dateEditorViewModel, navHostController, mutableState2);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            FloatingActionButtonKt.m3249ExtendedFloatingActionButtonElI57k(function2M9933getLambda$1329001695$app_productionPFast, function2M9934getLambda$377169856$app_productionPFast, (lb.a) objRememberedValue, null, true, null, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getPrimary(), 0L, null, null, composer, 24630, 936);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 DateEditorScreen$lambda$11$0$0(MutableState mutableState, Context context, DateEditorParams dateEditorParams, SnapshotStateMap snapshotStateMap, SnapshotStateMap snapshotStateMap2, DateEditorViewModel dateEditorViewModel, NavHostController navHostController, MutableState mutableState2) {
        if (le.d0.q0((CharSequence) mutableState.getValue())) {
            MainRepository instanceOrNull = MainRepository.INSTANCE.getInstanceOrNull();
            if (instanceOrNull != null) {
                String string = UUID.randomUUID().toString();
                kotlin.jvm.internal.y.h(string, "toString(...)");
                String strO = le.a0.O(string, "-", "", false, 4, null);
                Cause cause = Cause.ERROR;
                String string2 = context.getString(R.string.must_have_title);
                kotlin.jvm.internal.y.h(string2, "getString(...)");
                instanceOrNull.addNewNotification(new InsideNotificationState(strO, cause, string2));
            }
        } else {
            if (DateEditorScreen$lambda$7(mutableState2)) {
                dateEditorViewModel.sendEvent(dateEditorParams.getRoomId(), formatDateFromMap(snapshotStateMap), formatDateFromMap(snapshotStateMap2), (String) mutableState.getValue(), false, dateEditorParams.getReplyMsgId());
            } else {
                dateEditorViewModel.sendEvent(dateEditorParams.getRoomId(), formatDateFromMap(snapshotStateMap), formatDateFromMap(snapshotStateMap), (String) mutableState.getValue(), false, dateEditorParams.getReplyMsgId());
            }
            navHostController.navigateUp();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 DateEditorScreen$lambda$12(final MutableState mutableState, final SnapshotStateMap snapshotStateMap, final SnapshotStateMap snapshotStateMap2, MutableIntState mutableIntState, final MutableState mutableState2, Modifier it, Composer composer, int i10) {
        int i11;
        final MutableIntState mutableIntState2;
        boolean z10;
        Map<String, Integer> nextDay;
        kotlin.jvm.internal.y.i(it, "it");
        if ((i10 & 6) == 0) {
            i11 = i10 | (composer.changed(it) ? 4 : 2);
        } else {
            i11 = i10;
        }
        if (composer.shouldExecute((i11 & 19) != 18, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(771897799, i11, -1, "cu.todus.android.uiCompose.main.screen.dateEditor.DateEditorScreen.<anonymous> (DateEditorScreen.kt:182)");
            }
            float f10 = 20;
            Modifier modifierVerticalScroll$default = ScrollKt.verticalScroll$default(SizeKt.fillMaxHeight$default(PaddingKt.m1727paddingVpY3zN4$default(WindowInsetsPadding_androidKt.imePadding(it), Dp.m8823constructorimpl(f10), 0.0f, 2, null), 0.0f, 1, null), ScrollKt.rememberScrollState(0, composer, 0, 1), false, null, false, 14, null);
            Arrangement.Vertical top = Arrangement.INSTANCE.getTop();
            Alignment.Companion companion = Alignment.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(top, companion.getStart(), composer, 0);
            int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierVerticalScroll$default);
            ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
            lb.a constructor = companion2.getConstructor();
            if (!defpackage.r.a(composer.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor);
            } else {
                composer.useNode();
            }
            Composer composerM5176constructorimpl = Updater.m5176constructorimpl(composer);
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyColumnMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion2.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl, companion2.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion2.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            Modifier.Companion companion3 = Modifier.INSTANCE;
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(companion3, 0.0f, 1, null);
            MaterialTheme materialTheme = MaterialTheme.INSTANCE;
            int i12 = MaterialTheme.$stable;
            Z17LabelKt.m10262Z17LabelfWhpE4E(PaddingKt.m1725padding3ABfNKs(BackgroundKt.m1204backgroundbw27NRU(modifierFillMaxWidth$default, Color.m5865copywmQWz5c$default(materialTheme.getColorScheme(composer, i12).getOnBackground(), 0.2f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(10))), Dp.m8823constructorimpl(f10)), StringResources_androidKt.stringResource(R.string.create_date_add_title_date, composer, 0), TextStyle.m8271copyp1EtxEg$default(materialTheme.getTypography(composer, i12).getBodyMedium(), 0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, TextAlign.INSTANCE.m8692getCentere0LSkKk(), 0, 0L, null, null, null, 0, 0, null, 16744447, null), 0L, 0, 0, composer, 0, 56);
            float f11 = 15;
            SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion3, Dp.m8823constructorimpl(f11)), composer, 6);
            Modifier modifierFillMaxWidth$default2 = SizeKt.fillMaxWidth$default(companion3, 0.0f, 1, null);
            String str = (String) mutableState.getValue();
            String strStringResource = StringResources_androidKt.stringResource(R.string.title, composer, 0);
            Object objRememberedValue = composer.rememberedValue();
            Composer.Companion companion4 = Composer.INSTANCE;
            if (objRememberedValue == companion4.getEmpty()) {
                objRememberedValue = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.dateEditor.k
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DateEditorScreenKt.DateEditorScreen$lambda$12$0$0$0(mutableState, (String) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            Z17InputTextKt.m10251Z17InputTextf9_u2OI(modifierFillMaxWidth$default2, str, 1, 0, strStringResource, null, (Function1) objRememberedValue, null, null, 65, 0, 0L, 0L, 0L, 0L, 0L, null, false, null, false, composer, 806879622, 0, 1047976);
            SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion3, Dp.m8823constructorimpl(f11)), composer, 6);
            Object objRememberedValue2 = composer.rememberedValue();
            if (objRememberedValue2 == companion4.getEmpty()) {
                mutableIntState2 = mutableIntState;
                objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.dateEditor.l
                    @Override // lb.a
                    public final Object invoke() {
                        return DateEditorScreenKt.DateEditorScreen$lambda$12$0$1$0(mutableIntState2);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            } else {
                mutableIntState2 = mutableIntState;
            }
            lb.a aVar = (lb.a) objRememberedValue2;
            Object objRememberedValue3 = composer.rememberedValue();
            if (objRememberedValue3 == companion4.getEmpty()) {
                objRememberedValue3 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.dateEditor.m
                    @Override // lb.a
                    public final Object invoke() {
                        return k0.f43947a;
                    }
                };
                composer.updateRememberedValue(objRememberedValue3);
            }
            DatePoint(companion3, snapshotStateMap, aVar, false, (lb.a) objRememberedValue3, composer, 28086, 0);
            Composer composer2 = composer;
            Z17LabelKt.m10262Z17LabelfWhpE4E(columnScopeInstance.align(companion3, companion.getCenterHorizontally()), " | ", null, 0L, 0, 0, composer2, 48, 60);
            Z17LabelKt.m10262Z17LabelfWhpE4E(columnScopeInstance.align(companion3, companion.getCenterHorizontally()), " | ", null, 0L, 0, 0, composer2, 48, 60);
            if (DateEditorScreen$lambda$7(mutableState2)) {
                composer2.startReplaceGroup(626904705);
                Object objRememberedValue4 = composer2.rememberedValue();
                if (objRememberedValue4 == companion4.getEmpty()) {
                    objRememberedValue4 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.dateEditor.n
                        @Override // lb.a
                        public final Object invoke() {
                            return DateEditorScreenKt.DateEditorScreen$lambda$12$0$3$0(mutableIntState2);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue4);
                }
                lb.a aVar2 = (lb.a) objRememberedValue4;
                Object objRememberedValue5 = composer2.rememberedValue();
                if (objRememberedValue5 == companion4.getEmpty()) {
                    objRememberedValue5 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.dateEditor.p
                        @Override // lb.a
                        public final Object invoke() {
                            return DateEditorScreenKt.DateEditorScreen$lambda$12$0$4$0(mutableState2);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue5);
                }
                DatePoint(companion3, snapshotStateMap2, aVar2, true, (lb.a) objRememberedValue5, composer2, 28086, 0);
                composer2.endReplaceGroup();
                z10 = false;
            } else {
                composer2.startReplaceGroup(627289570);
                z10 = false;
                String strStringResource2 = StringResources_androidKt.stringResource(R.string.add_end_date, composer2, 0);
                Object objRememberedValue6 = composer2.rememberedValue();
                if (objRememberedValue6 == companion4.getEmpty()) {
                    objRememberedValue6 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.dateEditor.q
                        @Override // lb.a
                        public final Object invoke() {
                            return DateEditorScreenKt.DateEditorScreen$lambda$12$0$5$0(mutableState2);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue6);
                }
                Z17ButtonsKt.Z17SecondaryDialogButton(null, (lb.a) objRememberedValue6, strStringResource2, null, true, false, false, composer, 24624, 105);
                composer2 = composer;
                composer2.endReplaceGroup();
            }
            boolean z11 = mutableIntState2.getIntValue() != -1 ? true : z10;
            int intValue = mutableIntState2.getIntValue();
            if (intValue != 1) {
                nextDay = intValue != 2 ? getNextDay() : getNextDayFromMap(snapshotStateMap);
            } else {
                nextDay = snapshotStateMap;
            }
            Object objRememberedValue7 = composer2.rememberedValue();
            if (objRememberedValue7 == companion4.getEmpty()) {
                objRememberedValue7 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.dateEditor.r
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DateEditorScreenKt.DateEditorScreen$lambda$12$0$6$0(snapshotStateMap, snapshotStateMap2, mutableIntState2, (Map) obj);
                    }
                };
                composer2.updateRememberedValue(objRememberedValue7);
            }
            Function1 function1 = (Function1) objRememberedValue7;
            Object objRememberedValue8 = composer2.rememberedValue();
            if (objRememberedValue8 == companion4.getEmpty()) {
                objRememberedValue8 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.dateEditor.s
                    @Override // lb.a
                    public final Object invoke() {
                        return DateEditorScreenKt.DateEditorScreen$lambda$12$0$7$0(mutableIntState2);
                    }
                };
                composer2.updateRememberedValue(objRememberedValue8);
            }
            TimePicker(companion3, z11, nextDay, function1, (lb.a) objRememberedValue8, composer2, 27654, 0);
            composer.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 DateEditorScreen$lambda$12$0$0$0(MutableState mutableState, String newValue) {
        kotlin.jvm.internal.y.i(newValue, "newValue");
        mutableState.setValue(newValue);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 DateEditorScreen$lambda$12$0$1$0(MutableIntState mutableIntState) {
        mutableIntState.setIntValue(1);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 DateEditorScreen$lambda$12$0$3$0(MutableIntState mutableIntState) {
        mutableIntState.setIntValue(2);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 DateEditorScreen$lambda$12$0$4$0(MutableState mutableState) {
        DateEditorScreen$lambda$8(mutableState, false);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 DateEditorScreen$lambda$12$0$5$0(MutableState mutableState) {
        DateEditorScreen$lambda$8(mutableState, true);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 DateEditorScreen$lambda$12$0$6$0(SnapshotStateMap snapshotStateMap, SnapshotStateMap snapshotStateMap2, MutableIntState mutableIntState, Map it) {
        kotlin.jvm.internal.y.i(it, "it");
        if (mutableIntState.getIntValue() == 1) {
            for (Map.Entry entry : it.entrySet()) {
                snapshotStateMap.put((String) entry.getKey(), Integer.valueOf(((Number) entry.getValue()).intValue()));
            }
        } else if (mutableIntState.getIntValue() == 2) {
            for (Map.Entry entry2 : it.entrySet()) {
                snapshotStateMap2.put((String) entry2.getKey(), Integer.valueOf(((Number) entry2.getValue()).intValue()));
            }
        }
        if (!isSecondDateAfterFirst(snapshotStateMap, snapshotStateMap2)) {
            for (Map.Entry<String, Integer> entry3 : getNextDayFromMap(snapshotStateMap).entrySet()) {
                snapshotStateMap2.put(entry3.getKey(), Integer.valueOf(entry3.getValue().intValue()));
            }
        }
        mutableIntState.setIntValue(-1);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 DateEditorScreen$lambda$12$0$7$0(MutableIntState mutableIntState) {
        mutableIntState.setIntValue(-1);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 DateEditorScreen$lambda$13(NavHostController navHostController, String str, DateEditorViewModel dateEditorViewModel, int i10, int i11, Composer composer, int i12) {
        DateEditorScreen(navHostController, str, dateEditorViewModel, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return k0.f43947a;
    }

    private static final boolean DateEditorScreen$lambda$7(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void DateEditorScreen$lambda$8(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void DatePoint(Modifier modifier, final Map<String, Integer> date, final lb.a onClick, final boolean z10, final lb.a onDelete, Composer composer, final int i10, final int i11) {
        Modifier modifier2;
        int i12;
        final Modifier modifier3;
        kotlin.jvm.internal.y.i(date, "date");
        kotlin.jvm.internal.y.i(onClick, "onClick");
        kotlin.jvm.internal.y.i(onDelete, "onDelete");
        Composer composerStartRestartGroup = composer.startRestartGroup(1125388870);
        int i13 = i11 & 1;
        if (i13 != 0) {
            i12 = i10 | 6;
            modifier2 = modifier;
        } else if ((i10 & 6) == 0) {
            modifier2 = modifier;
            i12 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i10;
        } else {
            modifier2 = modifier;
            i12 = i10;
        }
        if ((i10 & 48) == 0) {
            i12 |= composerStartRestartGroup.changedInstance(date) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i12 |= composerStartRestartGroup.changedInstance(onClick) ? 256 : 128;
        }
        if ((i10 & 3072) == 0) {
            i12 |= composerStartRestartGroup.changed(z10) ? 2048 : 1024;
        }
        if ((i10 & 24576) == 0) {
            i12 |= composerStartRestartGroup.changedInstance(onDelete) ? 16384 : 8192;
        }
        if (composerStartRestartGroup.shouldExecute((i12 & 9363) != 9362, i12 & 1)) {
            modifier3 = i13 != 0 ? Modifier.INSTANCE : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1125388870, i12, -1, "cu.todus.android.uiCompose.main.screen.dateEditor.DatePoint (DateEditorScreen.kt:545)");
            }
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(modifier3, 0.0f, 1, null);
            boolean z11 = (i12 & 896) == 256;
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z11 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.dateEditor.d
                    @Override // lb.a
                    public final Object invoke() {
                        return DateEditorScreenKt.DatePoint$lambda$0$0(onClick);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            Modifier modifierM1240clickableoSLSa3U$default = ClickableKt.m1240clickableoSLSa3U$default(modifierFillMaxWidth$default, false, null, null, null, (lb.a) objRememberedValue, 15, null);
            float f10 = 10;
            Modifier modifierM1725padding3ABfNKs = PaddingKt.m1725padding3ABfNKs(modifierM1240clickableoSLSa3U$default, Dp.m8823constructorimpl(f10));
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composerStartRestartGroup, 48);
            int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1725padding3ABfNKs);
            ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
            lb.a constructor = companion.getConstructor();
            if (!defpackage.r.a(composerStartRestartGroup.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM5176constructorimpl = Updater.m5176constructorimpl(composerStartRestartGroup);
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyRowMeasurePolicy, companion.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl, companion.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion.getSetModifier());
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            Modifier.Companion companion2 = Modifier.INSTANCE;
            Modifier modifierM1769size3ABfNKs = SizeKt.m1769size3ABfNKs(PaddingKt.m1729paddingqDBjuR0$default(companion2, 0.0f, 0.0f, Dp.m8823constructorimpl(f10), 0.0f, 11, null), Dp.m8823constructorimpl(30));
            Icons icons = Icons.INSTANCE;
            int i14 = i12;
            Z17PictureKt.m10278Z17BasePictureC8z9wKI(modifierM1769size3ABfNKs, EditCalendarKt.getEditCalendar(icons.getDefault()), null, null, null, null, 0, null, null, composerStartRestartGroup, 6, TypedValues.PositionType.TYPE_CURVE_FIT);
            Integer num = date.get("month");
            kotlin.jvm.internal.y.f(num);
            composerStartRestartGroup = composerStartRestartGroup;
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, getMonthName(num.intValue()) + " " + date.get("day") + ", " + date.get("year"), null, 0L, 0, 0, composerStartRestartGroup, 0, 61);
            Modifier modifierA = e3.a(rowScopeInstance, companion2, 1.0f, false, 2, null);
            TextStyle textStyleM8271copyp1EtxEg$default = TextStyle.m8271copyp1EtxEg$default(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyMedium(), 0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, TextAlign.INSTANCE.m8693getEnde0LSkKk(), 0, 0L, null, null, null, 0, 0, null, 16744447, null);
            Integer num2 = date.get("hour");
            kotlin.jvm.internal.y.f(num2);
            String doubleDigits = getDoubleDigits(num2.intValue());
            Integer num3 = date.get("minute");
            kotlin.jvm.internal.y.f(num3);
            Z17LabelKt.m10262Z17LabelfWhpE4E(modifierA, doubleDigits + ":" + getDoubleDigits(num3.intValue()), textStyleM8271copyp1EtxEg$default, 0L, 0, 0, composerStartRestartGroup, 0, 56);
            if (z10) {
                composerStartRestartGroup.startReplaceGroup(-500291411);
                boolean z12 = (i14 & 57344) == 16384;
                Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (z12 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.dateEditor.o
                        @Override // lb.a
                        public final Object invoke() {
                            return DateEditorScreenKt.DatePoint$lambda$1$0$0(onDelete);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                Z17PictureKt.m10278Z17BasePictureC8z9wKI(SizeKt.m1769size3ABfNKs(PaddingKt.m1729paddingqDBjuR0$default(ClickableKt.m1240clickableoSLSa3U$default(companion2, false, null, null, null, (lb.a) objRememberedValue2, 15, null), Dp.m8823constructorimpl(f10), 0.0f, 0.0f, 0.0f, 14, null), Dp.m8823constructorimpl(20)), DeleteKt.getDelete(icons.getDefault()), null, null, null, null, 0, null, null, composerStartRestartGroup, 0, TypedValues.PositionType.TYPE_CURVE_FIT);
                composerStartRestartGroup = composerStartRestartGroup;
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(1671061280);
                composerStartRestartGroup.endReplaceGroup();
            }
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.dateEditor.z
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DateEditorScreenKt.DatePoint$lambda$2(modifier3, date, onClick, z10, onDelete, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 DatePoint$lambda$0$0(lb.a aVar) {
        aVar.invoke();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 DatePoint$lambda$1$0$0(lb.a aVar) {
        aVar.invoke();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 DatePoint$lambda$2(Modifier modifier, Map map, lb.a aVar, boolean z10, lb.a aVar2, int i10, int i11, Composer composer, int i12) {
        DatePoint(modifier, map, aVar, z10, aVar2, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return k0.f43947a;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void TimePicker(final Modifier modifier, final boolean z10, final Map<String, Integer> initialDate, final Function1 onSelected, final lb.a onClose, Composer composer, final int i10, final int i11) {
        int i12;
        kotlin.jvm.internal.y.i(initialDate, "initialDate");
        kotlin.jvm.internal.y.i(onSelected, "onSelected");
        kotlin.jvm.internal.y.i(onClose, "onClose");
        Composer composerStartRestartGroup = composer.startRestartGroup(-314022318);
        int i13 = i11 & 1;
        if (i13 != 0) {
            i12 = i10 | 6;
        } else if ((i10 & 6) == 0) {
            i12 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i10;
        } else {
            i12 = i10;
        }
        if ((i10 & 48) == 0) {
            i12 |= composerStartRestartGroup.changed(z10) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i12 |= composerStartRestartGroup.changedInstance(initialDate) ? 256 : 128;
        }
        if ((i10 & 3072) == 0) {
            i12 |= composerStartRestartGroup.changedInstance(onSelected) ? 2048 : 1024;
        }
        if ((i10 & 24576) == 0) {
            i12 |= composerStartRestartGroup.changedInstance(onClose) ? 16384 : 8192;
        }
        if (composerStartRestartGroup.shouldExecute((i12 & 9363) != 9362, i12 & 1)) {
            if (i13 != 0) {
                modifier = Modifier.INSTANCE;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-314022318, i12, -1, "cu.todus.android.uiCompose.main.screen.dateEditor.TimePicker (DateEditorScreen.kt:299)");
            }
            Z17DialogsKt.Z17CustomDialog(z10, onClose, ComposableLambdaKt.rememberComposableLambda(299973664, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.dateEditor.a0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return DateEditorScreenKt.TimePicker$lambda$0(modifier, onSelected, initialDate, (lb.a) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i12 >> 3) & 14) | RendererCapabilities.DECODER_SUPPORT_MASK | ((i12 >> 9) & 112));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier2 = modifier;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.dateEditor.b0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DateEditorScreenKt.TimePicker$lambda$1(modifier2, z10, initialDate, onSelected, onClose, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 TimePicker$lambda$0(Modifier modifier, final Function1 function1, Map map, lb.a it, Composer composer, int i10) {
        final MutableIntState mutableIntState;
        final MutableState mutableState;
        final MutableIntState mutableIntState2;
        final MutableIntState mutableIntState3;
        kotlin.jvm.internal.y.i(it, "it");
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(299973664, i10, -1, "cu.todus.android.uiCompose.main.screen.dateEditor.TimePicker.<anonymous> (DateEditorScreen.kt:304)");
            }
            MaterialTheme materialTheme = MaterialTheme.INSTANCE;
            int i11 = MaterialTheme.$stable;
            float f10 = 5;
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(PaddingKt.m1725padding3ABfNKs(BackgroundKt.m1204backgroundbw27NRU(modifier, materialTheme.getColorScheme(composer, i11).getBackground(), RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(15))), Dp.m8823constructorimpl(f10)), 0.0f, 1, null);
            Arrangement arrangement = Arrangement.INSTANCE;
            Arrangement.Vertical top = arrangement.getTop();
            Alignment.Companion companion = Alignment.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(top, companion.getStart(), composer, 0);
            int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierFillMaxWidth$default);
            ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
            lb.a constructor = companion2.getConstructor();
            if (!defpackage.r.a(composer.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor);
            } else {
                composer.useNode();
            }
            Composer composerM5176constructorimpl = Updater.m5176constructorimpl(composer);
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyColumnMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion2.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl, companion2.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion2.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            Modifier.Companion companion3 = Modifier.INSTANCE;
            Z17LabelKt.m10262Z17LabelfWhpE4E(PaddingKt.m1729paddingqDBjuR0$default(companion3, 0.0f, Dp.m8823constructorimpl(10), 0.0f, Dp.m8823constructorimpl(25), 5, null), StringResources_androidKt.stringResource(R.string.select_start_date_time, composer, 0), materialTheme.getTypography(composer, i11).getLabelLarge(), 0L, 0, 0, composer, 6, 56);
            Object objRememberedValue = composer.rememberedValue();
            Composer.Companion companion4 = Composer.INSTANCE;
            if (objRememberedValue == companion4.getEmpty()) {
                Object obj = map.get("hour");
                kotlin.jvm.internal.y.f(obj);
                objRememberedValue = SnapshotIntStateKt.mutableIntStateOf(((Number) obj).intValue());
                composer.updateRememberedValue(objRememberedValue);
            }
            final MutableIntState mutableIntState4 = (MutableIntState) objRememberedValue;
            Object objRememberedValue2 = composer.rememberedValue();
            if (objRememberedValue2 == companion4.getEmpty()) {
                Object obj2 = map.get("minute");
                kotlin.jvm.internal.y.f(obj2);
                objRememberedValue2 = SnapshotIntStateKt.mutableIntStateOf(((Number) obj2).intValue());
                composer.updateRememberedValue(objRememberedValue2);
            }
            MutableIntState mutableIntState5 = (MutableIntState) objRememberedValue2;
            Object objRememberedValue3 = composer.rememberedValue();
            if (objRememberedValue3 == companion4.getEmpty()) {
                Object obj3 = map.get(InstrumentationResultPrinter.REPORT_KEY_NUM_CURRENT);
                kotlin.jvm.internal.y.f(obj3);
                objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(((Number) obj3).intValue() == 1 ? "AM" : "PM", null, 2, null);
                composer.updateRememberedValue(objRememberedValue3);
            }
            MutableState mutableState2 = (MutableState) objRememberedValue3;
            List listO1 = va.g0.o1(new rb.f(1, 12));
            List listO2 = va.g0.o1(new rb.f(0, 59));
            Modifier modifierFillMaxWidth$default2 = SizeKt.fillMaxWidth$default(companion3, 0.0f, 1, null);
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getCenter(), companion.getCenterVertically(), composer, 54);
            int iA2 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer, modifierFillMaxWidth$default2);
            lb.a constructor2 = companion2.getConstructor();
            if (!defpackage.r.a(composer.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor2);
            } else {
                composer.useNode();
            }
            Composer composerM5176constructorimpl2 = Updater.m5176constructorimpl(composer);
            Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyRowMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap2, companion2.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl2, Integer.valueOf(iA2), companion2.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl2, companion2.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier2, companion2.getSetModifier());
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, StringResources_androidKt.stringResource(R.string.day_time, composer, 0), materialTheme.getTypography(composer, i11).getLabelMedium(), 0L, 0, 0, composer, 0, 57);
            SpacerKt.Spacer(e3.a(rowScopeInstance, companion3, 1.0f, false, 2, null), composer, 0);
            float f11 = 50;
            float f12 = 60;
            Modifier modifierM1775widthInVpY3zN4 = SizeKt.m1775widthInVpY3zN4(companion3, Dp.m8823constructorimpl(f11), Dp.m8823constructorimpl(f12));
            float f13 = (float) 0.3d;
            Modifier modifierM1216borderxT4_qwU = BorderKt.m1216borderxT4_qwU(modifierM1775widthInVpY3zN4, Dp.m8823constructorimpl(f13), materialTheme.getColorScheme(composer, i11).getPrimary(), RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(f10)));
            int intValue = mutableIntState4.getIntValue();
            Object objRememberedValue4 = composer.rememberedValue();
            if (objRememberedValue4 == companion4.getEmpty()) {
                objRememberedValue4 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.dateEditor.i0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj4) {
                        return DateEditorScreenKt.TimePicker$lambda$0$0$9$0$0(mutableIntState4, ((Integer) obj4).intValue());
                    }
                };
                composer.updateRememberedValue(objRememberedValue4);
            }
            Function1 function2 = (Function1) objRememberedValue4;
            Integer numValueOf = Integer.valueOf(intValue);
            Object objRememberedValue5 = composer.rememberedValue();
            if (objRememberedValue5 == companion4.getEmpty()) {
                objRememberedValue5 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.dateEditor.e
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj4) {
                        return DateEditorScreenKt.TimePicker$lambda$0$0$9$1$0(((Integer) obj4).intValue());
                    }
                };
                composer.updateRememberedValue(objRememberedValue5);
            }
            Z17SpinnerKt.Z17Spinner2(modifierM1216borderxT4_qwU, listO1, function2, numValueOf, (Function1) objRememberedValue5, null, composer, 24960, 32);
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, ":", null, 0L, 0, 0, composer, 48, 61);
            Modifier modifierM1216borderxT4_qwU2 = BorderKt.m1216borderxT4_qwU(SizeKt.m1775widthInVpY3zN4(companion3, Dp.m8823constructorimpl(f11), Dp.m8823constructorimpl(f12)), Dp.m8823constructorimpl(f13), materialTheme.getColorScheme(composer, i11).getPrimary(), RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(f10)));
            int intValue2 = mutableIntState5.getIntValue();
            Object objRememberedValue6 = composer.rememberedValue();
            if (objRememberedValue6 == companion4.getEmpty()) {
                mutableIntState = mutableIntState5;
                objRememberedValue6 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.dateEditor.f
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj4) {
                        return DateEditorScreenKt.TimePicker$lambda$0$0$9$2$0(mutableIntState, ((Integer) obj4).intValue());
                    }
                };
                composer.updateRememberedValue(objRememberedValue6);
            } else {
                mutableIntState = mutableIntState5;
            }
            Function1 function3 = (Function1) objRememberedValue6;
            Integer numValueOf2 = Integer.valueOf(intValue2);
            Object objRememberedValue7 = composer.rememberedValue();
            if (objRememberedValue7 == companion4.getEmpty()) {
                objRememberedValue7 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.dateEditor.g
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj4) {
                        return DateEditorScreenKt.TimePicker$lambda$0$0$9$3$0(((Integer) obj4).intValue());
                    }
                };
                composer.updateRememberedValue(objRememberedValue7);
            }
            Z17SpinnerKt.Z17Spinner2(modifierM1216borderxT4_qwU2, listO2, function3, numValueOf2, (Function1) objRememberedValue7, null, composer, 24960, 32);
            final MutableIntState mutableIntState6 = mutableIntState;
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, ":", null, 0L, 0, 0, composer, 48, 61);
            Modifier modifierM1216borderxT4_qwU3 = BorderKt.m1216borderxT4_qwU(SizeKt.m1775widthInVpY3zN4(companion3, Dp.m8823constructorimpl(f11), Dp.m8823constructorimpl(f12)), Dp.m8823constructorimpl(f13), materialTheme.getColorScheme(composer, i11).getPrimary(), RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(f10)));
            List listQ = va.w.q("AM", "PM");
            String strTimePicker$lambda$0$0$7 = TimePicker$lambda$0$0$7(mutableState2);
            Object objRememberedValue8 = composer.rememberedValue();
            if (objRememberedValue8 == companion4.getEmpty()) {
                mutableState = mutableState2;
                objRememberedValue8 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.dateEditor.h
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj4) {
                        return DateEditorScreenKt.TimePicker$lambda$0$0$9$4$0(mutableState, (String) obj4);
                    }
                };
                composer.updateRememberedValue(objRememberedValue8);
            } else {
                mutableState = mutableState2;
            }
            Function1 function4 = (Function1) objRememberedValue8;
            Object objRememberedValue9 = composer.rememberedValue();
            if (objRememberedValue9 == companion4.getEmpty()) {
                objRememberedValue9 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.dateEditor.i
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj4) {
                        return DateEditorScreenKt.TimePicker$lambda$0$0$9$5$0((String) obj4);
                    }
                };
                composer.updateRememberedValue(objRememberedValue9);
            }
            Z17SpinnerKt.Z17Spinner2(modifierM1216borderxT4_qwU3, listQ, function4, strTimePicker$lambda$0$0$7, (Function1) objRememberedValue9, null, composer, 25008, 32);
            composer.endNode();
            SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion3, Dp.m8823constructorimpl(20)), composer, 6);
            Object objRememberedValue10 = composer.rememberedValue();
            if (objRememberedValue10 == companion4.getEmpty()) {
                Object obj4 = map.get("day");
                kotlin.jvm.internal.y.f(obj4);
                objRememberedValue10 = SnapshotIntStateKt.mutableIntStateOf(((Number) obj4).intValue());
                composer.updateRememberedValue(objRememberedValue10);
            }
            final MutableIntState mutableIntState7 = (MutableIntState) objRememberedValue10;
            Object objRememberedValue11 = composer.rememberedValue();
            if (objRememberedValue11 == companion4.getEmpty()) {
                Object obj5 = map.get("month");
                kotlin.jvm.internal.y.f(obj5);
                objRememberedValue11 = SnapshotIntStateKt.mutableIntStateOf(((Number) obj5).intValue());
                composer.updateRememberedValue(objRememberedValue11);
            }
            MutableIntState mutableIntState8 = (MutableIntState) objRememberedValue11;
            Object objRememberedValue12 = composer.rememberedValue();
            if (objRememberedValue12 == companion4.getEmpty()) {
                Object obj6 = map.get("year");
                kotlin.jvm.internal.y.f(obj6);
                objRememberedValue12 = SnapshotIntStateKt.mutableIntStateOf(((Number) obj6).intValue());
                composer.updateRememberedValue(objRememberedValue12);
            }
            MutableIntState mutableIntState9 = (MutableIntState) objRememberedValue12;
            List listO3 = va.g0.o1(new rb.f(1, 12));
            List listO4 = va.g0.o1(new rb.f(2024, 2100));
            Modifier modifierFillMaxWidth$default3 = SizeKt.fillMaxWidth$default(companion3, 0.0f, 1, null);
            MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(arrangement.getCenter(), companion.getCenterVertically(), composer, 54);
            int iA3 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap3 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composer, modifierFillMaxWidth$default3);
            lb.a constructor3 = companion2.getConstructor();
            if (!defpackage.r.a(composer.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor3);
            } else {
                composer.useNode();
            }
            Composer composerM5176constructorimpl3 = Updater.m5176constructorimpl(composer);
            Updater.m5184setimpl(composerM5176constructorimpl3, measurePolicyRowMeasurePolicy2, companion2.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl3, currentCompositionLocalMap3, companion2.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl3, Integer.valueOf(iA3), companion2.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl3, companion2.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl3, modifierMaterializeModifier3, companion2.getSetModifier());
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, StringResources_androidKt.stringResource(R.string.date_day, composer, 0), materialTheme.getTypography(composer, i11).getLabelMedium(), 0L, 0, 0, composer, 0, 57);
            SpacerKt.Spacer(e3.a(rowScopeInstance, companion3, 1.0f, false, 2, null), composer, 0);
            int iTimePicker$lambda$0$0$getDaysInMonth = TimePicker$lambda$0$0$getDaysInMonth(mutableIntState8.getIntValue(), mutableIntState9.getIntValue());
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, "D/", materialTheme.getTypography(composer, i11).getLabelLarge(), 0L, 0, 0, composer, 48, 57);
            Modifier modifierM1216borderxT4_qwU4 = BorderKt.m1216borderxT4_qwU(SizeKt.m1775widthInVpY3zN4(companion3, Dp.m8823constructorimpl(f11), Dp.m8823constructorimpl(f12)), Dp.m8823constructorimpl(f13), materialTheme.getColorScheme(composer, i11).getPrimary(), RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(f10)));
            List listO5 = va.g0.o1(new rb.f(1, iTimePicker$lambda$0$0$getDaysInMonth));
            int intValue3 = mutableIntState7.getIntValue();
            Object objRememberedValue13 = composer.rememberedValue();
            if (objRememberedValue13 == companion4.getEmpty()) {
                objRememberedValue13 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.dateEditor.j
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj7) {
                        return DateEditorScreenKt.TimePicker$lambda$0$0$19$0$0(mutableIntState7, ((Integer) obj7).intValue());
                    }
                };
                composer.updateRememberedValue(objRememberedValue13);
            }
            Function1 function5 = (Function1) objRememberedValue13;
            Integer numValueOf3 = Integer.valueOf(intValue3);
            Object objRememberedValue14 = composer.rememberedValue();
            if (objRememberedValue14 == companion4.getEmpty()) {
                objRememberedValue14 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.dateEditor.c0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj7) {
                        return DateEditorScreenKt.TimePicker$lambda$0$0$19$1$0(((Integer) obj7).intValue());
                    }
                };
                composer.updateRememberedValue(objRememberedValue14);
            }
            Z17SpinnerKt.Z17Spinner2(modifierM1216borderxT4_qwU4, listO5, function5, numValueOf3, (Function1) objRememberedValue14, null, composer, 24960, 32);
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, "M/", materialTheme.getTypography(composer, i11).getLabelLarge(), 0L, 0, 0, composer, 48, 57);
            Modifier modifierM1216borderxT4_qwU5 = BorderKt.m1216borderxT4_qwU(SizeKt.m1775widthInVpY3zN4(companion3, Dp.m8823constructorimpl(f11), Dp.m8823constructorimpl(f12)), Dp.m8823constructorimpl(f13), materialTheme.getColorScheme(composer, i11).getPrimary(), RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(f10)));
            int intValue4 = mutableIntState8.getIntValue();
            Object objRememberedValue15 = composer.rememberedValue();
            if (objRememberedValue15 == companion4.getEmpty()) {
                mutableIntState2 = mutableIntState8;
                objRememberedValue15 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.dateEditor.d0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj7) {
                        return DateEditorScreenKt.TimePicker$lambda$0$0$19$2$0(mutableIntState2, mutableIntState7, ((Integer) obj7).intValue());
                    }
                };
                composer.updateRememberedValue(objRememberedValue15);
            } else {
                mutableIntState2 = mutableIntState8;
            }
            Function1 function6 = (Function1) objRememberedValue15;
            Integer numValueOf4 = Integer.valueOf(intValue4);
            Object objRememberedValue16 = composer.rememberedValue();
            if (objRememberedValue16 == companion4.getEmpty()) {
                objRememberedValue16 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.dateEditor.e0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj7) {
                        return DateEditorScreenKt.TimePicker$lambda$0$0$19$3$0(((Integer) obj7).intValue());
                    }
                };
                composer.updateRememberedValue(objRememberedValue16);
            }
            Z17SpinnerKt.Z17Spinner2(modifierM1216borderxT4_qwU5, listO3, function6, numValueOf4, (Function1) objRememberedValue16, null, composer, 24960, 32);
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, "-", materialTheme.getTypography(composer, i11).getLabelLarge(), 0L, 0, 0, composer, 48, 57);
            Modifier modifierM1216borderxT4_qwU6 = BorderKt.m1216borderxT4_qwU(SizeKt.m1775widthInVpY3zN4(companion3, Dp.m8823constructorimpl(f11), Dp.m8823constructorimpl(f12)), Dp.m8823constructorimpl(f13), materialTheme.getColorScheme(composer, i11).getPrimary(), RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(f10)));
            int intValue5 = mutableIntState9.getIntValue();
            Object objRememberedValue17 = composer.rememberedValue();
            if (objRememberedValue17 == companion4.getEmpty()) {
                mutableIntState3 = mutableIntState9;
                objRememberedValue17 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.dateEditor.f0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj7) {
                        return DateEditorScreenKt.TimePicker$lambda$0$0$19$4$0(mutableIntState3, mutableIntState2, mutableIntState7, ((Integer) obj7).intValue());
                    }
                };
                composer.updateRememberedValue(objRememberedValue17);
            } else {
                mutableIntState3 = mutableIntState9;
            }
            Function1 function7 = (Function1) objRememberedValue17;
            Integer numValueOf5 = Integer.valueOf(intValue5);
            Object objRememberedValue18 = composer.rememberedValue();
            if (objRememberedValue18 == companion4.getEmpty()) {
                objRememberedValue18 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.dateEditor.g0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj7) {
                        return String.valueOf(((Integer) obj7).intValue());
                    }
                };
                composer.updateRememberedValue(objRememberedValue18);
            }
            Z17SpinnerKt.Z17Spinner2(modifierM1216borderxT4_qwU6, listO4, function7, numValueOf5, (Function1) objRememberedValue18, null, composer, 24960, 32);
            composer.endNode();
            SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion3, Dp.m8823constructorimpl(30)), composer, 6);
            String strStringResource = StringResources_androidKt.stringResource(R.string.select, composer, 0);
            boolean zChanged = composer.changed(function1);
            Object objRememberedValue19 = composer.rememberedValue();
            if (zChanged || objRememberedValue19 == companion4.getEmpty()) {
                final MutableIntState mutableIntState10 = mutableIntState3;
                final MutableState mutableState3 = mutableState;
                final MutableIntState mutableIntState11 = mutableIntState2;
                lb.a aVar = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.dateEditor.h0
                    @Override // lb.a
                    public final Object invoke() {
                        return DateEditorScreenKt.TimePicker$lambda$0$0$20$0(function1, mutableIntState7, mutableIntState11, mutableIntState10, mutableIntState4, mutableIntState6, mutableState3);
                    }
                };
                composer.updateRememberedValue(aVar);
                objRememberedValue19 = aVar;
            }
            Z17ButtonsKt.Z17PrimaryDialogButton(null, (lb.a) objRememberedValue19, strStringResource, null, true, false, false, composer, 24576, 105);
            composer.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 TimePicker$lambda$0$0$19$0$0(MutableIntState mutableIntState, int i10) {
        mutableIntState.setIntValue(i10);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String TimePicker$lambda$0$0$19$1$0(int i10) {
        if (i10 >= 10) {
            return String.valueOf(i10);
        }
        return "0" + i10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 TimePicker$lambda$0$0$19$2$0(MutableIntState mutableIntState, MutableIntState mutableIntState2, int i10) {
        mutableIntState.setIntValue(i10);
        if (mutableIntState2.getIntValue() > 28) {
            mutableIntState2.setIntValue(1);
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String TimePicker$lambda$0$0$19$3$0(int i10) {
        if (i10 >= 10) {
            return String.valueOf(i10);
        }
        return "0" + i10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 TimePicker$lambda$0$0$19$4$0(MutableIntState mutableIntState, MutableIntState mutableIntState2, MutableIntState mutableIntState3, int i10) {
        mutableIntState.setIntValue(i10);
        if (mutableIntState2.getIntValue() == 2) {
            mutableIntState3.setIntValue(1);
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 TimePicker$lambda$0$0$20$0(Function1 function1, MutableIntState mutableIntState, MutableIntState mutableIntState2, MutableIntState mutableIntState3, MutableIntState mutableIntState4, MutableIntState mutableIntState5, MutableState mutableState) {
        function1.invoke(w0.l(ua.z.a("day", Integer.valueOf(mutableIntState.getIntValue())), ua.z.a("month", Integer.valueOf(mutableIntState2.getIntValue())), ua.z.a("year", Integer.valueOf(mutableIntState3.getIntValue())), ua.z.a("hour", Integer.valueOf(mutableIntState4.getIntValue())), ua.z.a("minute", Integer.valueOf(mutableIntState5.getIntValue())), ua.z.a(InstrumentationResultPrinter.REPORT_KEY_NUM_CURRENT, Integer.valueOf(kotlin.jvm.internal.y.d(TimePicker$lambda$0$0$7(mutableState), "AM") ? 1 : 0))));
        return k0.f43947a;
    }

    private static final String TimePicker$lambda$0$0$7(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 TimePicker$lambda$0$0$9$0$0(MutableIntState mutableIntState, int i10) {
        mutableIntState.setIntValue(i10);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String TimePicker$lambda$0$0$9$1$0(int i10) {
        if (i10 >= 10) {
            return String.valueOf(i10);
        }
        return "0" + i10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 TimePicker$lambda$0$0$9$2$0(MutableIntState mutableIntState, int i10) {
        mutableIntState.setIntValue(i10);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String TimePicker$lambda$0$0$9$3$0(int i10) {
        if (i10 >= 10) {
            return String.valueOf(i10);
        }
        return "0" + i10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 TimePicker$lambda$0$0$9$4$0(MutableState mutableState, String it) {
        kotlin.jvm.internal.y.i(it, "it");
        mutableState.setValue(it);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String TimePicker$lambda$0$0$9$5$0(String it) {
        kotlin.jvm.internal.y.i(it, "it");
        return it;
    }

    private static final int TimePicker$lambda$0$0$getDaysInMonth(int i10, int i11) {
        if (i10 != 2) {
            return (i10 == 4 || i10 == 6 || i10 == 9 || i10 == 11) ? 30 : 31;
        }
        return ((i11 % 4 != 0 || i11 % 100 == 0) && i11 % 400 != 0) ? 28 : 29;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 TimePicker$lambda$1(Modifier modifier, boolean z10, Map map, Function1 function1, lb.a aVar, int i10, int i11, Composer composer, int i12) {
        TimePicker(modifier, z10, map, function1, aVar, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return k0.f43947a;
    }

    public static final int convert24hTo12h(int i10) {
        if (i10 == 0) {
            return 12;
        }
        return i10 <= 12 ? i10 : i10 - 12;
    }

    public static final String formatDateFromMap(Map<String, Integer> dateMap) {
        kotlin.jvm.internal.y.i(dateMap, "dateMap");
        Integer num = dateMap.get("day");
        if (num == null) {
            throw new IllegalArgumentException("Día no válido");
        }
        int iIntValue = num.intValue();
        Integer num2 = dateMap.get("month");
        if (num2 == null) {
            throw new IllegalArgumentException("Mes no válido");
        }
        int iIntValue2 = num2.intValue();
        Integer num3 = dateMap.get("year");
        if (num3 == null) {
            throw new IllegalArgumentException("Año no válido");
        }
        int iIntValue3 = num3.intValue();
        Integer num4 = dateMap.get("hour");
        if (num4 == null) {
            throw new IllegalArgumentException("Hora no válida");
        }
        int iIntValue4 = num4.intValue();
        Integer num5 = dateMap.get("minute");
        if (num5 == null) {
            throw new IllegalArgumentException("Minuto no válido");
        }
        int iIntValue5 = num5.intValue();
        Integer num6 = dateMap.get(InstrumentationResultPrinter.REPORT_KEY_NUM_CURRENT);
        if (num6 == null) {
            throw new IllegalArgumentException("AM/PM no válido");
        }
        int iIntValue6 = num6.intValue();
        if (iIntValue6 != 1 || iIntValue4 >= 12) {
            if (iIntValue6 == 0 && iIntValue4 == 12) {
                iIntValue4 = 0;
            } else {
                iIntValue4 += iIntValue6 != 0 ? 0 : 12;
            }
        }
        String str = LocalDateTime.of(iIntValue3, iIntValue2, iIntValue, iIntValue4, iIntValue5).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        kotlin.jvm.internal.y.h(str, "format(...)");
        return str;
    }

    public static final String getDoubleDigits(int i10) {
        if (i10 >= 10) {
            return String.valueOf(i10);
        }
        return "0" + i10;
    }

    public static final String getMonthName(int i10) {
        String[] months = new DateFormatSymbols().getMonths();
        if (1 > i10 || i10 >= 13) {
            return "Mes no válido";
        }
        String str = months[i10 - 1];
        kotlin.jvm.internal.y.f(str);
        return str;
    }

    public static final Map<String, Integer> getNextDay() {
        LocalDateTime localDateTimePlusDays = LocalDateTime.now().plusDays(1L);
        return w0.l(ua.z.a("day", Integer.valueOf(localDateTimePlusDays.getDayOfMonth())), ua.z.a("month", Integer.valueOf(localDateTimePlusDays.getMonthValue())), ua.z.a("year", Integer.valueOf(localDateTimePlusDays.getYear())), ua.z.a("hour", Integer.valueOf(convert24hTo12h(localDateTimePlusDays.getHour()))), ua.z.a("minute", Integer.valueOf(localDateTimePlusDays.getMinute())), ua.z.a(InstrumentationResultPrinter.REPORT_KEY_NUM_CURRENT, Integer.valueOf(localDateTimePlusDays.getHour() < 12 ? 1 : 0)));
    }

    public static final Map<String, Integer> getNextDayFromMap(Map<String, Integer> dateMap) {
        kotlin.jvm.internal.y.i(dateMap, "dateMap");
        Integer num = dateMap.get("day");
        if (num == null) {
            throw new IllegalArgumentException("Día no válido");
        }
        int iIntValue = num.intValue();
        Integer num2 = dateMap.get("month");
        if (num2 == null) {
            throw new IllegalArgumentException("Mes no válido");
        }
        int iIntValue2 = num2.intValue();
        Integer num3 = dateMap.get("year");
        if (num3 == null) {
            throw new IllegalArgumentException("Año no válido");
        }
        int iIntValue3 = num3.intValue();
        Integer num4 = dateMap.get("hour");
        if (num4 == null) {
            throw new IllegalArgumentException("Hora no válida");
        }
        int iIntValue4 = num4.intValue();
        Integer num5 = dateMap.get("minute");
        if (num5 == null) {
            throw new IllegalArgumentException("Minuto no válido");
        }
        LocalDateTime localDateTimePlusDays = LocalDateTime.of(iIntValue3, iIntValue2, iIntValue, iIntValue4, num5.intValue()).plusDays(1L);
        return w0.l(ua.z.a("day", Integer.valueOf(localDateTimePlusDays.getDayOfMonth())), ua.z.a("month", Integer.valueOf(localDateTimePlusDays.getMonthValue())), ua.z.a("year", Integer.valueOf(localDateTimePlusDays.getYear())), ua.z.a("hour", Integer.valueOf(localDateTimePlusDays.getHour())), ua.z.a("minute", Integer.valueOf(localDateTimePlusDays.getMinute())), ua.z.a(InstrumentationResultPrinter.REPORT_KEY_NUM_CURRENT, 1));
    }

    public static final boolean isSecondDateAfterFirst(Map<String, Integer> firstDateMap, Map<String, Integer> secondDateMap) {
        kotlin.jvm.internal.y.i(firstDateMap, "firstDateMap");
        kotlin.jvm.internal.y.i(secondDateMap, "secondDateMap");
        Integer num = firstDateMap.get("day");
        if (num == null) {
            throw new IllegalArgumentException("Día no válido en la primera fecha");
        }
        int iIntValue = num.intValue();
        Integer num2 = firstDateMap.get("month");
        if (num2 == null) {
            throw new IllegalArgumentException("Mes no válido en la primera fecha");
        }
        int iIntValue2 = num2.intValue();
        Integer num3 = firstDateMap.get("year");
        if (num3 == null) {
            throw new IllegalArgumentException("Año no válido en la primera fecha");
        }
        int iIntValue3 = num3.intValue();
        Integer num4 = firstDateMap.get("hour");
        if (num4 == null) {
            throw new IllegalArgumentException("Hora no válida en la primera fecha");
        }
        int iIntValue4 = num4.intValue();
        Integer num5 = firstDateMap.get("minute");
        if (num5 == null) {
            throw new IllegalArgumentException("Minuto no válido en la primera fecha");
        }
        int iIntValue5 = num5.intValue();
        Integer num6 = firstDateMap.get(InstrumentationResultPrinter.REPORT_KEY_NUM_CURRENT);
        if (num6 == null) {
            throw new IllegalArgumentException("AM/PM no válido en la primera fecha");
        }
        int iIntValue6 = num6.intValue();
        Integer num7 = secondDateMap.get("day");
        if (num7 == null) {
            throw new IllegalArgumentException("Día no válido en la segunda fecha");
        }
        int iIntValue7 = num7.intValue();
        Integer num8 = secondDateMap.get("month");
        if (num8 == null) {
            throw new IllegalArgumentException("Mes no válido en la segunda fecha");
        }
        int iIntValue8 = num8.intValue();
        Integer num9 = secondDateMap.get("year");
        if (num9 == null) {
            throw new IllegalArgumentException("Año no válido en la segunda fecha");
        }
        int iIntValue9 = num9.intValue();
        Integer num10 = secondDateMap.get("hour");
        if (num10 == null) {
            throw new IllegalArgumentException("Hora no válida en la segunda fecha");
        }
        int iIntValue10 = num10.intValue();
        Integer num11 = secondDateMap.get("minute");
        if (num11 == null) {
            throw new IllegalArgumentException("Minuto no válido en la segunda fecha");
        }
        int iIntValue11 = num11.intValue();
        Integer num12 = secondDateMap.get(InstrumentationResultPrinter.REPORT_KEY_NUM_CURRENT);
        if (num12 == null) {
            throw new IllegalArgumentException("AM/PM no válido en la segunda fecha");
        }
        int iIntValue12 = num12.intValue();
        if (iIntValue6 != 1) {
            iIntValue4 = iIntValue4 == 12 ? 12 : iIntValue4 + 12;
        } else if (iIntValue4 == 12) {
            iIntValue4 = 0;
        }
        if (iIntValue12 != 1) {
            iIntValue10 = iIntValue10 == 12 ? 12 : iIntValue10 + 12;
        } else if (iIntValue10 == 12) {
            iIntValue10 = 0;
        }
        return LocalDateTime.of(iIntValue9, iIntValue8, iIntValue7, iIntValue10, iIntValue11).isAfter(LocalDateTime.of(iIntValue3, iIntValue2, iIntValue, iIntValue4, iIntValue5));
    }
}
