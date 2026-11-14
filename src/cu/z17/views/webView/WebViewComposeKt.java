package cu.z17.views.webView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.viewinterop.AndroidView_androidKt;
import cu.z17.views.webView.WebViewComposeKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.y;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a!\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u000f\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\t\u001a#\u0010\u000e\u001a\u00020\u00042\u0012\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\nH\u0002¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Landroidx/compose/ui/Modifier;", "modifier", "", "url", "Lua/k0;", "Z17WebView", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)V", "Landroid/webkit/WebChromeClient;", "customWebChromeClient", "()Landroid/webkit/WebChromeClient;", "Landroid/webkit/ValueCallback;", "", "Landroid/net/Uri;", "filePathCallback", "openFileChooser", "(Landroid/webkit/ValueCallback;)V", "views_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class WebViewComposeKt {
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    @SuppressLint({"ClickableViewAccessibility"})
    public static final void Z17WebView(final Modifier modifier, final String url, Composer composer, final int i10, final int i11) {
        int i12;
        y.i(url, "url");
        Composer composerStartRestartGroup = composer.startRestartGroup(867932869);
        int i13 = i11 & 1;
        if (i13 != 0) {
            i12 = i10 | 6;
        } else if ((i10 & 6) == 0) {
            i12 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i10;
        } else {
            i12 = i10;
        }
        if ((i10 & 48) == 0) {
            i12 |= composerStartRestartGroup.changed(url) ? 32 : 16;
        }
        if (composerStartRestartGroup.shouldExecute((i12 & 19) != 18, i12 & 1)) {
            if (i13 != 0) {
                modifier = Modifier.INSTANCE;
            }
            Modifier modifier2 = modifier;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(867932869, i12, -1, "cu.z17.views.webView.Z17WebView (WebViewCompose.kt:20)");
            }
            boolean z10 = (i12 & 112) == 32;
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z10 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: w9.b
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return WebViewComposeKt.Z17WebView$lambda$3$lambda$2(url, (Context) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            AndroidView_androidKt.AndroidView((Function1) objRememberedValue, modifier2, null, composerStartRestartGroup, (i12 << 3) & 112, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier = modifier2;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: w9.c
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return WebViewComposeKt.Z17WebView$lambda$4(modifier, url, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WebView Z17WebView$lambda$3$lambda$2(String str, Context context) {
        y.i(context, "context");
        WebView webView = new WebView(context);
        webView.getSettings().setDomStorageEnabled(true);
        webView.getSettings().setAllowContentAccess(true);
        webView.getSettings().setAllowFileAccess(true);
        webView.setVerticalScrollBarEnabled(false);
        webView.setHorizontalScrollBarEnabled(false);
        webView.setOnTouchListener(new View.OnTouchListener() { // from class: w9.a
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return WebViewComposeKt.Z17WebView$lambda$3$lambda$2$lambda$1$lambda$0(view, motionEvent);
            }
        });
        webView.setWebChromeClient(customWebChromeClient());
        webView.loadUrl(str);
        return webView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Z17WebView$lambda$3$lambda$2$lambda$1$lambda$0(View view, MotionEvent motionEvent) {
        return motionEvent.getAction() == 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 Z17WebView$lambda$4(Modifier modifier, String str, int i10, int i11, Composer composer, int i12) {
        Z17WebView(modifier, str, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return k0.f43947a;
    }

    private static final WebChromeClient customWebChromeClient() {
        return new WebChromeClient() { // from class: cu.z17.views.webView.WebViewComposeKt$customWebChromeClient$webChromeClient$1
            @Override // android.webkit.WebChromeClient
            public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> filePathCallback, WebChromeClient.FileChooserParams fileChooserParams) {
                y.i(webView, "webView");
                y.i(filePathCallback, "filePathCallback");
                y.i(fileChooserParams, "fileChooserParams");
                WebViewComposeKt.openFileChooser(filePathCallback);
                return true;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void openFileChooser(ValueCallback<Uri[]> valueCallback) {
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.setType("*/*");
        intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
    }
}
