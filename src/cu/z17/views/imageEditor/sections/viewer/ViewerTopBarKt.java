package cu.z17.views.imageEditor.sections.viewer;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.ui.Modifier;
import cu.z17.views.imageEditor.ImageEditorConfigurations;
import cu.z17.views.imageEditor.Z17EditorState;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import lb.a;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001ag\u0010\u000f\u001a\u00020\b2\b\b\u0002\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u00062\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0007¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Landroidx/compose/ui/Modifier;", "modifier", "", "count", "", "path", "Lkotlin/Function1;", "Lcu/z17/views/imageEditor/Z17EditorState;", "Lua/k0;", "requestState", "requestStepBack", "Lkotlin/Function0;", "requestCompress", "Lcu/z17/views/imageEditor/ImageEditorConfigurations;", "configs", "ViewerTopBar", "(Landroidx/compose/ui/Modifier;ILjava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Llb/a;Lcu/z17/views/imageEditor/ImageEditorConfigurations;Landroidx/compose/runtime/Composer;II)V", "views_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ViewerTopBarKt {
    /*  JADX ERROR: Types fix failed
        jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r13v3 ??, new type: boolean
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryPossibleTypes(FixTypesVisitor.java:186)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:245)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
        Caused by: java.lang.NullPointerException
        */
    @androidx.compose.runtime.ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @androidx.compose.runtime.Composable
    public static final void ViewerTopBar(androidx.compose.ui.Modifier r58, int r59, java.lang.String r60, kotlin.jvm.functions.Function1 r61, kotlin.jvm.functions.Function1 r62, lb.a r63, cu.z17.views.imageEditor.ImageEditorConfigurations r64, androidx.compose.runtime.Composer r65, int r66, int r67) {
        /*
            Method dump skipped, instruction units count: 1535
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.z17.views.imageEditor.sections.viewer.ViewerTopBarKt.ViewerTopBar(androidx.compose.ui.Modifier, int, java.lang.String, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, lb.a, cu.z17.views.imageEditor.ImageEditorConfigurations, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 ViewerTopBar$lambda$13$lambda$1$lambda$0(Function1 function1, String str) {
        function1.invoke(str);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 ViewerTopBar$lambda$13$lambda$11$lambda$10(a aVar) {
        aVar.invoke();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 ViewerTopBar$lambda$13$lambda$3$lambda$2(Function1 function1) {
        function1.invoke(Z17EditorState.TEXT);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 ViewerTopBar$lambda$13$lambda$5$lambda$4(Function1 function1) {
        function1.invoke(Z17EditorState.FILTER);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 ViewerTopBar$lambda$13$lambda$7$lambda$6(Function1 function1) {
        function1.invoke(Z17EditorState.CROP);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 ViewerTopBar$lambda$13$lambda$9$lambda$8(Function1 function1) {
        function1.invoke(Z17EditorState.ROTATE);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 ViewerTopBar$lambda$14(Modifier modifier, int i10, String str, Function1 function1, Function1 function2, a aVar, ImageEditorConfigurations imageEditorConfigurations, int i11, int i12, Composer composer, int i13) {
        ViewerTopBar(modifier, i10, str, function1, function2, aVar, imageEditorConfigurations, composer, RecomposeScopeImplKt.updateChangedFlags(i11 | 1), i12);
        return k0.f43947a;
    }
}
