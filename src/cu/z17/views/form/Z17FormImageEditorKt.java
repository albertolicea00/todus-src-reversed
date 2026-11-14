package cu.z17.views.form;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import cu.todus.android.xmpp.extension.edited.ExtensionEdited;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a1\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Landroidx/compose/ui/Modifier;", "modifier", "", "origin", ExtensionEdited.ELEMENT, "", "optionSelected", "Lua/k0;", "Z17FormImageEditor", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;Ljava/lang/String;ILandroidx/compose/runtime/Composer;II)V", "views_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class Z17FormImageEditorKt {
    @Composable
    public static final void Z17FormImageEditor(Modifier modifier, final String origin, final String edited, final int i10, Composer composer, final int i11, final int i12) {
        kotlin.jvm.internal.y.i(origin, "origin");
        kotlin.jvm.internal.y.i(edited, "edited");
        Composer composerStartRestartGroup = composer.startRestartGroup(1052205590);
        int i13 = i11 & 1;
        if (composerStartRestartGroup.shouldExecute(i13 != 0, i13)) {
            if ((i12 & 1) != 0) {
                modifier = Modifier.INSTANCE;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1052205590, i11, -1, "cu.z17.views.form.Z17FormImageEditor (Z17FormImageEditor.kt:11)");
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        final Modifier modifier2 = modifier;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.form.z
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return Z17FormImageEditorKt.Z17FormImageEditor$lambda$0(modifier2, origin, edited, i10, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 Z17FormImageEditor$lambda$0(Modifier modifier, String str, String str2, int i10, int i11, int i12, Composer composer, int i13) {
        Z17FormImageEditor(modifier, str, str2, i10, composer, RecomposeScopeImplKt.updateChangedFlags(i11 | 1), i12);
        return ua.k0.f43947a;
    }
}
