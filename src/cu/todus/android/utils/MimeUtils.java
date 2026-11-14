package cu.todus.android.utils;

import android.content.Context;
import android.net.Uri;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.common.MimeTypes;
import androidx.media3.exoplayer.upstream.CmcdConfiguration;
import androidx.media3.extractor.text.ttml.TtmlNode;
import cu.todus.android.data.util.MediaUtil;
import cu.todus.android.xmpp.extension.event.ExtensionEvent;
import cu.todus.android.xmpp.extension.gif.ExtensionGif;
import cu.todus.android.xmpp.extension.mention.ExtensionMention;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import kotlin.Metadata;
import kotlin.jvm.internal.y;
import le.d0;
import org.jivesoftware.smackx.xhtmlim.packet.XHTMLExtension;
import va.g0;
import va.w;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u0003J\u0017\u0010\f\u001a\u00020\u000b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u000e\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0010\u0010\rJ\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0011\u0010\u000fJ\u001d\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001a\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ%\u0010\u001a\u001a\u0004\u0018\u00010\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u001d\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\u001a\u0010\u001eR \u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R \u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010!R\u0016\u0010&\u001a\u0004\u0018\u00010#8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%¨\u0006'"}, d2 = {"Lcu/todus/android/utils/MimeUtils;", "", "<init>", "()V", "", "mimeType", "extension", "Lua/k0;", "add", "(Ljava/lang/String;Ljava/lang/String;)V", "applyOverrides", "", "hasMimeType", "(Ljava/lang/String;)Z", "guessMimeTypeFromExtension", "(Ljava/lang/String;)Ljava/lang/String;", "hasExtension", "guessExtensionFromMimeType", "Landroid/content/Context;", "context", "Landroid/net/Uri;", "uri", "guessMimeTypeFromUri", "(Landroid/content/Context;Landroid/net/Uri;)Ljava/lang/String;", "Ljava/net/URL;", "url", "extractRelevantExtension", "(Ljava/net/URL;)Ljava/lang/String;", "path", "ignoreCryptoExtension", "(Ljava/lang/String;Z)Ljava/lang/String;", "", "mimeTypeToExtensionMap", "Ljava/util/Map;", "extensionToMimeTypeMap", "Ljava/io/InputStream;", "getContentTypesPropertiesStream", "()Ljava/io/InputStream;", "contentTypesPropertiesStream", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class MimeUtils {
    public static final int $stable;
    public static final MimeUtils INSTANCE;
    private static final Map<String, String> extensionToMimeTypeMap;
    private static final Map<String, String> mimeTypeToExtensionMap;

    static {
        MimeUtils mimeUtils = new MimeUtils();
        INSTANCE = mimeUtils;
        mimeTypeToExtensionMap = new HashMap();
        extensionToMimeTypeMap = new HashMap();
        mimeUtils.add("application/andrew-inset", "ez");
        mimeUtils.add("application/dsptype", "tsp");
        mimeUtils.add("application/hta", "hta");
        mimeUtils.add("application/mac-binhex40", "hqx");
        mimeUtils.add("application/mathematica", "nb");
        mimeUtils.add("application/msaccess", "mdb");
        mimeUtils.add("application/oda", "oda");
        mimeUtils.add("application/ogg", "ogg");
        mimeUtils.add("application/pdf", "pdf");
        mimeUtils.add("application/pgp-keys", "key");
        mimeUtils.add("application/pgp-signature", "pgp");
        mimeUtils.add("application/pics-rules", "prf");
        mimeUtils.add("application/pkix-cert", "cer");
        mimeUtils.add("application/rar", "rar");
        mimeUtils.add("application/rdf+xml", "rdf");
        mimeUtils.add("application/rss+xml", "rss");
        mimeUtils.add("application/zip", "zip");
        mimeUtils.add("application/vnd.android.package-archive", "apk");
        mimeUtils.add("application/vnd.cinderella", "cdy");
        mimeUtils.add("application/vnd.ms-pki.stl", "stl");
        mimeUtils.add("application/vnd.oasis.opendocument.database", "odb");
        mimeUtils.add("application/vnd.oasis.opendocument.formula", "odf");
        mimeUtils.add("application/vnd.oasis.opendocument.graphics", "odg");
        mimeUtils.add("application/vnd.oasis.opendocument.graphics-template", "otg");
        mimeUtils.add("application/vnd.oasis.opendocument.image", "odi");
        mimeUtils.add("application/vnd.oasis.opendocument.spreadsheet", "ods");
        mimeUtils.add("application/vnd.oasis.opendocument.spreadsheet-template", "ots");
        mimeUtils.add("application/vnd.oasis.opendocument.text", "odt");
        mimeUtils.add("application/vnd.oasis.opendocument.text-master", "odm");
        mimeUtils.add("application/vnd.oasis.opendocument.text-template", "ott");
        mimeUtils.add("application/vnd.oasis.opendocument.text-web", "oth");
        mimeUtils.add("application/vnd.google-earth.kml+xml", "kml");
        mimeUtils.add("application/vnd.google-earth.kmz", "kmz");
        mimeUtils.add("application/msword", "doc");
        mimeUtils.add("application/msword", TtmlNode.TEXT_EMPHASIS_MARK_DOT);
        mimeUtils.add("application/vnd.openxmlformats-officedocument.wordprocessingml.document", "docx");
        mimeUtils.add("application/vnd.openxmlformats-officedocument.wordprocessingml.template", "dotx");
        mimeUtils.add("application/vnd.ms-excel", "xls");
        mimeUtils.add("application/vnd.ms-excel", "xlt");
        mimeUtils.add("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet", "xlsx");
        mimeUtils.add("application/vnd.openxmlformats-officedocument.spreadsheetml.template", "xltx");
        mimeUtils.add("application/vnd.ms-powerpoint", "ppt");
        mimeUtils.add("application/vnd.ms-powerpoint", "pot");
        mimeUtils.add("application/vnd.ms-powerpoint", "pps");
        mimeUtils.add("application/vnd.openxmlformats-officedocument.presentationml.presentation", "pptx");
        mimeUtils.add("application/vnd.openxmlformats-officedocument.presentationml.template", "potx");
        mimeUtils.add("application/vnd.openxmlformats-officedocument.presentationml.slideshow", "ppsx");
        mimeUtils.add("application/vnd.rim.cod", "cod");
        mimeUtils.add("application/vnd.smaf", "mmf");
        mimeUtils.add("application/vnd.stardivision.calc", "sdc");
        mimeUtils.add("application/vnd.stardivision.draw", "sda");
        mimeUtils.add("application/vnd.stardivision.impress", "sdd");
        mimeUtils.add("application/vnd.stardivision.impress", "sdp");
        mimeUtils.add("application/vnd.stardivision.math", "smf");
        mimeUtils.add("application/vnd.stardivision.writer", "sdw");
        mimeUtils.add("application/vnd.stardivision.writer", "vor");
        mimeUtils.add("application/vnd.stardivision.writer-global", "sgl");
        mimeUtils.add("application/vnd.sun.xml.calc", "sxc");
        mimeUtils.add("application/vnd.sun.xml.calc.template", "stc");
        mimeUtils.add("application/vnd.sun.xml.draw", "sxd");
        mimeUtils.add("application/vnd.sun.xml.draw.template", "std");
        mimeUtils.add("application/vnd.sun.xml.impress", "sxi");
        mimeUtils.add("application/vnd.sun.xml.impress.template", "sti");
        mimeUtils.add("application/vnd.sun.xml.math", "sxm");
        mimeUtils.add("application/vnd.sun.xml.writer", "sxw");
        mimeUtils.add("application/vnd.sun.xml.writer.global", "sxg");
        mimeUtils.add("application/vnd.sun.xml.writer.template", "stw");
        mimeUtils.add("application/vnd.visio", "vsd");
        mimeUtils.add("application/x-abiword", "abw");
        mimeUtils.add("application/x-apple-diskimage", "dmg");
        mimeUtils.add("application/x-bcpio", "bcpio");
        mimeUtils.add("application/x-bittorrent", "torrent");
        mimeUtils.add("application/x-cdf", "cdf");
        mimeUtils.add("application/x-cdlink", "vcd");
        mimeUtils.add("application/x-chess-pgn", "pgn");
        mimeUtils.add("application/x-cpio", "cpio");
        mimeUtils.add("application/x-debian-package", "deb");
        mimeUtils.add("application/x-debian-package", "udeb");
        mimeUtils.add("application/x-director", "dcr");
        mimeUtils.add("application/x-director", "dir");
        mimeUtils.add("application/x-director", "dxr");
        mimeUtils.add("application/x-dms", "dms");
        mimeUtils.add("application/x-doom", "wad");
        mimeUtils.add("application/x-dvi", "dvi");
        mimeUtils.add("application/x-font", "pfa");
        mimeUtils.add("application/x-font", "pfb");
        mimeUtils.add("application/x-font", "gsf");
        mimeUtils.add("application/x-font", "pcf");
        mimeUtils.add("application/x-font", "pcf.Z");
        mimeUtils.add("application/x-freemind", "mm");
        mimeUtils.add("application/x-futuresplash", "spl");
        mimeUtils.add("application/futuresplash", "spl");
        mimeUtils.add("application/x-gnumeric", "gnumeric");
        mimeUtils.add("application/x-go-sgf", "sgf");
        mimeUtils.add("application/x-graphing-calculator", "gcf");
        mimeUtils.add("application/x-gtar", "tgz");
        mimeUtils.add("application/x-gtar", "gtar");
        mimeUtils.add("application/x-gtar", "taz");
        mimeUtils.add("application/x-hdf", "hdf");
        mimeUtils.add("application/x-ica", "ica");
        mimeUtils.add("application/x-internet-signup", "ins");
        mimeUtils.add("application/x-internet-signup", "isp");
        mimeUtils.add("application/x-iphone", "iii");
        mimeUtils.add("application/x-iso9660-image", "iso");
        mimeUtils.add("application/x-jmol", "jmz");
        mimeUtils.add("application/x-kchart", "chrt");
        mimeUtils.add("application/x-killustrator", "kil");
        mimeUtils.add("application/x-koan", "skp");
        mimeUtils.add("application/x-koan", "skd");
        mimeUtils.add("application/x-koan", "skt");
        mimeUtils.add("application/x-koan", "skm");
        mimeUtils.add("application/x-kpresenter", "kpr");
        mimeUtils.add("application/x-kpresenter", "kpt");
        mimeUtils.add("application/x-kspread", "ksp");
        mimeUtils.add("application/x-kword", "kwd");
        mimeUtils.add("application/x-kword", "kwt");
        mimeUtils.add("application/x-latex", "latex");
        mimeUtils.add("application/x-lha", "lha");
        mimeUtils.add("application/x-lzh", "lzh");
        mimeUtils.add("application/x-lzx", "lzx");
        mimeUtils.add("application/x-maker", "frm");
        mimeUtils.add("application/x-maker", "maker");
        mimeUtils.add("application/x-maker", TypedValues.AttributesType.S_FRAME);
        mimeUtils.add("application/x-maker", "fb");
        mimeUtils.add("application/x-maker", "book");
        mimeUtils.add("application/x-maker", "fbdoc");
        mimeUtils.add("application/x-mif", "mif");
        mimeUtils.add("application/x-ms-wmd", "wmd");
        mimeUtils.add("application/x-ms-wmz", "wmz");
        mimeUtils.add("application/x-msi", "msi");
        mimeUtils.add("application/x-ns-proxy-autoconfig", "pac");
        mimeUtils.add("application/x-nwc", "nwc");
        mimeUtils.add("application/x-object", ExtensionMention.TAG_OFFSET);
        mimeUtils.add("application/x-oz-application", "oza");
        mimeUtils.add("application/x-pem-file", "pem");
        mimeUtils.add("application/x-pkcs12", "p12");
        mimeUtils.add("application/x-pkcs12", "pfx");
        mimeUtils.add("application/x-pkcs7-certreqresp", "p7r");
        mimeUtils.add("application/x-pkcs7-crl", "crl");
        mimeUtils.add("application/x-quicktimeplayer", "qtl");
        mimeUtils.add("application/x-shar", "shar");
        mimeUtils.add("application/x-shockwave-flash", "swf");
        mimeUtils.add("application/x-stuffit", "sit");
        mimeUtils.add("application/x-sv4cpio", "sv4cpio");
        mimeUtils.add("application/x-sv4crc", "sv4crc");
        mimeUtils.add("application/x-tar", "tar");
        mimeUtils.add("application/x-texinfo", "texinfo");
        mimeUtils.add("application/x-texinfo", "texi");
        mimeUtils.add("application/x-troff", "t");
        mimeUtils.add("application/x-troff", "roff");
        mimeUtils.add("application/x-troff-man", "man");
        mimeUtils.add("application/x-ustar", "ustar");
        mimeUtils.add("application/x-wais-source", "src");
        mimeUtils.add("application/x-wingz", "wz");
        mimeUtils.add("application/x-webarchive", "webarchive");
        mimeUtils.add("application/x-webarchive-xml", "webarchivexml");
        mimeUtils.add("application/x-x509-ca-cert", "crt");
        mimeUtils.add("application/x-x509-user-cert", "crt");
        mimeUtils.add("application/x-x509-server-cert", "crt");
        mimeUtils.add("application/x-xcf", "xcf");
        mimeUtils.add("application/x-xfig", "fig");
        mimeUtils.add("application/xhtml+xml", "xhtml");
        mimeUtils.add(MimeTypes.AUDIO_AMR_NB, "3gpp");
        mimeUtils.add(MediaUtil.AUDIO_AAC, "aac");
        mimeUtils.add("audio/aac-adts", "aac");
        mimeUtils.add(MimeTypes.AUDIO_AMR, "amr");
        mimeUtils.add(MimeTypes.AUDIO_AMR_WB, "awb");
        mimeUtils.add("audio/basic", "snd");
        mimeUtils.add(MimeTypes.AUDIO_FLAC, "flac");
        mimeUtils.add("application/x-flac", "flac");
        mimeUtils.add("audio/imelody", "imy");
        mimeUtils.add(MimeTypes.AUDIO_MIDI, "mid");
        mimeUtils.add(MimeTypes.AUDIO_MIDI, "midi");
        mimeUtils.add(MimeTypes.AUDIO_MIDI, "ota");
        mimeUtils.add(MimeTypes.AUDIO_MIDI, "kar");
        mimeUtils.add(MimeTypes.AUDIO_MIDI, "rtttl");
        mimeUtils.add(MimeTypes.AUDIO_MIDI, "xmf");
        mimeUtils.add("audio/mobile-xmf", "mxmf");
        mimeUtils.add(MimeTypes.AUDIO_MPEG, "mp3");
        mimeUtils.add(MimeTypes.AUDIO_MPEG, "mpga");
        mimeUtils.add(MimeTypes.AUDIO_MPEG, "mpega");
        mimeUtils.add(MimeTypes.AUDIO_MPEG, "mp2");
        mimeUtils.add(MimeTypes.AUDIO_MPEG, "m4a");
        mimeUtils.add("audio/mpegurl", "m3u");
        mimeUtils.add(MimeTypes.AUDIO_OGG, "oga");
        mimeUtils.add("audio/prs.sid", CmcdConfiguration.KEY_SESSION_ID);
        mimeUtils.add("audio/x-aiff", "aif");
        mimeUtils.add("audio/x-aiff", "aiff");
        mimeUtils.add("audio/x-aiff", "aifc");
        mimeUtils.add("audio/x-gsm", "gsm");
        mimeUtils.add(MimeTypes.AUDIO_MATROSKA, "mka");
        mimeUtils.add("audio/x-mpegurl", "m3u");
        mimeUtils.add("audio/x-ms-wma", "wma");
        mimeUtils.add("audio/x-ms-wax", "wax");
        mimeUtils.add("audio/x-pn-realaudio", "ra");
        mimeUtils.add("audio/x-pn-realaudio", "rm");
        mimeUtils.add("audio/x-pn-realaudio", "ram");
        mimeUtils.add("audio/x-realaudio", "ra");
        mimeUtils.add("audio/x-scpls", "pls");
        mimeUtils.add("audio/x-sd2", "sd2");
        mimeUtils.add("audio/x-wav", "wav");
        mimeUtils.add("image/x-ms-bmp", "bmp");
        mimeUtils.add(MimeTypes.IMAGE_BMP, "bmp");
        mimeUtils.add(MediaUtil.IMAGE_GIF, ExtensionGif.ELEMENT);
        mimeUtils.add("image/x-icon", "ico");
        mimeUtils.add("image/ico", "cur");
        mimeUtils.add("image/ico", "ico");
        mimeUtils.add("image/ief", "ief");
        mimeUtils.add("image/jpeg", "jpg");
        mimeUtils.add("image/jpeg", "jpeg");
        mimeUtils.add("image/jpeg", "jpe");
        mimeUtils.add("image/pcx", "pcx");
        mimeUtils.add("image/png", "png");
        mimeUtils.add("image/svg+xml", "svg");
        mimeUtils.add("image/svg+xml", "svgz");
        mimeUtils.add("image/tiff", "tiff");
        mimeUtils.add("image/tiff", "tif");
        mimeUtils.add("image/vnd.djvu", "djvu");
        mimeUtils.add("image/vnd.djvu", "djv");
        mimeUtils.add("image/vnd.wap.wbmp", "wbmp");
        mimeUtils.add("image/webp", "webp");
        mimeUtils.add("image/x-cmu-raster", "ras");
        mimeUtils.add("image/x-coreldraw", "cdr");
        mimeUtils.add("image/x-coreldrawpattern", "pat");
        mimeUtils.add("image/x-coreldrawtemplate", "cdt");
        mimeUtils.add("image/x-corelphotopaint", "cpt");
        mimeUtils.add("image/x-jg", "art");
        mimeUtils.add("image/x-jng", "jng");
        mimeUtils.add("image/x-photoshop", "psd");
        mimeUtils.add("image/x-portable-anymap", "pnm");
        mimeUtils.add("image/x-portable-bitmap", "pbm");
        mimeUtils.add("image/x-portable-graymap", "pgm");
        mimeUtils.add("image/x-portable-pixmap", "ppm");
        mimeUtils.add("image/x-rgb", "rgb");
        mimeUtils.add("image/x-xbitmap", "xbm");
        mimeUtils.add("image/x-xpixmap", "xpm");
        mimeUtils.add("image/x-xwindowdump", "xwd");
        mimeUtils.add("model/iges", "igs");
        mimeUtils.add("model/iges", "iges");
        mimeUtils.add("model/mesh", "msh");
        mimeUtils.add("model/mesh", "mesh");
        mimeUtils.add("model/mesh", "silo");
        mimeUtils.add("text/calendar", ExtensionEvent.TAG_ICS);
        mimeUtils.add("text/calendar", "icz");
        mimeUtils.add("text/comma-separated-values", "csv");
        mimeUtils.add("text/css", "css");
        mimeUtils.add("text/html", "htm");
        mimeUtils.add("text/html", XHTMLExtension.ELEMENT);
        mimeUtils.add("text/h323", "323");
        mimeUtils.add("text/iuls", "uls");
        mimeUtils.add("text/mathml", "mml");
        mimeUtils.add(MediaUtil.TEXT, "txt");
        mimeUtils.add(MediaUtil.TEXT, "asc");
        mimeUtils.add(MediaUtil.TEXT, "text");
        mimeUtils.add(MediaUtil.TEXT, "diff");
        mimeUtils.add(MediaUtil.TEXT, "po");
        mimeUtils.add("text/richtext", "rtx");
        mimeUtils.add("text/rtf", "rtf");
        mimeUtils.add("text/text", "phps");
        mimeUtils.add("text/tab-separated-values", "tsv");
        mimeUtils.add("text/xml", "xml");
        mimeUtils.add("text/x-bibtex", "bib");
        mimeUtils.add("text/x-boo", "boo");
        mimeUtils.add("text/x-c++hdr", "hpp");
        mimeUtils.add("text/x-c++hdr", "h++");
        mimeUtils.add("text/x-c++hdr", "hxx");
        mimeUtils.add("text/x-c++hdr", "hh");
        mimeUtils.add("text/x-c++src", "cpp");
        mimeUtils.add("text/x-c++src", "c++");
        mimeUtils.add("text/x-c++src", "cc");
        mimeUtils.add("text/x-c++src", "cxx");
        mimeUtils.add("text/x-chdr", "h");
        mimeUtils.add("text/x-component", "htc");
        mimeUtils.add("text/x-csh", "csh");
        mimeUtils.add("text/x-csrc", "c");
        mimeUtils.add("text/x-dsrc", "d");
        mimeUtils.add("text/x-haskell", "hs");
        mimeUtils.add("text/x-java", "java");
        mimeUtils.add("text/x-literate-haskell", "lhs");
        mimeUtils.add("text/x-moc", "moc");
        mimeUtils.add("text/x-pascal", "p");
        mimeUtils.add("text/x-pascal", "pas");
        mimeUtils.add("text/x-pcs-gcd", "gcd");
        mimeUtils.add("text/x-setext", "etx");
        mimeUtils.add("text/x-tcl", "tcl");
        mimeUtils.add("text/x-tex", "tex");
        mimeUtils.add("text/x-tex", "ltx");
        mimeUtils.add("text/x-tex", "sty");
        mimeUtils.add("text/x-tex", "cls");
        mimeUtils.add("text/x-vcalendar", "vcs");
        mimeUtils.add("text/x-vcard", "vcf");
        mimeUtils.add("cu/todus/android/adapter/message/delegate/video/3gpp", "3gpp");
        mimeUtils.add("cu/todus/android/adapter/message/delegate/video/3gpp", "3gp");
        mimeUtils.add("cu/todus/android/adapter/message/delegate/video/3gpp2", "3gpp2");
        mimeUtils.add("cu/todus/android/adapter/message/delegate/video/3gpp2", "3g2");
        mimeUtils.add("cu/todus/android/adapter/message/delegate/video/avi", "avi");
        mimeUtils.add("cu/todus/android/adapter/message/delegate/video/dl", CmcdConfiguration.KEY_DEADLINE);
        mimeUtils.add("cu/todus/android/adapter/message/delegate/video/dv", "dif");
        mimeUtils.add("cu/todus/android/adapter/message/delegate/video/dv", "dv");
        mimeUtils.add("cu/todus/android/adapter/message/delegate/video/fli", "fli");
        mimeUtils.add("cu/todus/android/adapter/message/delegate/video/m4v", "m4v");
        mimeUtils.add("cu/todus/android/adapter/message/delegate/video/mp2ts", "ts");
        mimeUtils.add("cu/todus/android/adapter/message/delegate/video/ogg", "ogv");
        mimeUtils.add("cu/todus/android/adapter/message/delegate/video/mpeg", "mpeg");
        mimeUtils.add("cu/todus/android/adapter/message/delegate/video/mpeg", "mpg");
        mimeUtils.add("cu/todus/android/adapter/message/delegate/video/mpeg", "mpe");
        mimeUtils.add("cu/todus/android/adapter/message/delegate/video/mp4", "mp4");
        mimeUtils.add("cu/todus/android/adapter/message/delegate/video/mpeg", "VOB");
        mimeUtils.add("cu/todus/android/adapter/message/delegate/video/quicktime", "qt");
        mimeUtils.add("cu/todus/android/adapter/message/delegate/video/quicktime", "mov");
        mimeUtils.add("cu/todus/android/adapter/message/delegate/video/vnd.mpegurl", "mxu");
        mimeUtils.add("cu/todus/android/adapter/message/delegate/video/webm", "webm");
        mimeUtils.add("cu/todus/android/adapter/message/delegate/video/x-la-asf", "lsf");
        mimeUtils.add("cu/todus/android/adapter/message/delegate/video/x-la-asf", "lsx");
        mimeUtils.add("cu/todus/android/adapter/message/delegate/video/x-matroska", "mkv");
        mimeUtils.add("cu/todus/android/adapter/message/delegate/video/x-mng", "mng");
        mimeUtils.add("cu/todus/android/adapter/message/delegate/video/x-ms-asf", "asf");
        mimeUtils.add("cu/todus/android/adapter/message/delegate/video/x-ms-asf", "asx");
        mimeUtils.add("cu/todus/android/adapter/message/delegate/video/x-ms-wm", "wm");
        mimeUtils.add("cu/todus/android/adapter/message/delegate/video/x-ms-wmv", "wmv");
        mimeUtils.add("cu/todus/android/adapter/message/delegate/video/x-ms-wmx", "wmx");
        mimeUtils.add("cu/todus/android/adapter/message/delegate/video/x-ms-wvx", "wvx");
        mimeUtils.add("cu/todus/android/adapter/message/delegate/video/x-sgi-movie", "movie");
        mimeUtils.add("cu/todus/android/adapter/message/delegate/video/x-webex", "wrf");
        mimeUtils.add("x-conference/x-cooltalk", "ice");
        mimeUtils.add("x-epoc/x-sisx-app", "sisx");
        mimeUtils.applyOverrides();
        $stable = 8;
    }

    private MimeUtils() {
    }

    private final void add(String mimeType, String extension) {
        Map<String, String> map = mimeTypeToExtensionMap;
        if (!map.containsKey(mimeType)) {
            map.put(mimeType, extension);
        }
        Map<String, String> map2 = extensionToMimeTypeMap;
        if (map2.containsKey(extension)) {
            return;
        }
        map2.put(extension, mimeType);
    }

    private final void applyOverrides() {
        InputStream contentTypesPropertiesStream = getContentTypesPropertiesStream();
        try {
            if (contentTypesPropertiesStream == null) {
                return;
            }
            try {
                Properties properties = new Properties();
                properties.load(contentTypesPropertiesStream);
                for (Map.Entry entry : properties.entrySet()) {
                    Object key = entry.getKey();
                    Object value = entry.getValue();
                    y.g(key, "null cannot be cast to non-null type kotlin.String");
                    y.g(value, "null cannot be cast to non-null type kotlin.String");
                    add((String) value, (String) key);
                }
                contentTypesPropertiesStream.close();
            } catch (Throwable th2) {
                contentTypesPropertiesStream.close();
                throw th2;
            }
        } catch (IOException unused) {
        }
    }

    public static /* synthetic */ String extractRelevantExtension$default(MimeUtils mimeUtils, String str, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return mimeUtils.extractRelevantExtension(str, z10);
    }

    private final InputStream getContentTypesPropertiesStream() {
        String property = System.getProperty("content.types.user.table");
        if (property != null) {
            File file = new File(property);
            if (file.exists()) {
                try {
                    return new FileInputStream(file);
                } catch (IOException unused) {
                }
            }
        }
        File file2 = new File(System.getProperty("java.home"), "lib" + File.separator + "content-types.properties");
        if (!file2.exists()) {
            return null;
        }
        try {
            return new FileInputStream(file2);
        } catch (IOException unused2) {
            return null;
        }
    }

    public final String extractRelevantExtension(String str) {
        return extractRelevantExtension$default(this, str, false, 2, null);
    }

    public final String guessExtensionFromMimeType(String mimeType) {
        List listN;
        if (mimeType == null || mimeType.length() == 0) {
            return null;
        }
        Map<String, String> map = mimeTypeToExtensionMap;
        List listO = new le.m(";").o(mimeType, 0);
        if (listO.isEmpty()) {
            listN = w.n();
        } else {
            ListIterator listIterator = listO.listIterator(listO.size());
            while (listIterator.hasPrevious()) {
                if (((String) listIterator.previous()).length() != 0) {
                    listN = g0.g1(listO, listIterator.nextIndex() + 1);
                }
            }
            listN = w.n();
        }
        return map.get(((String[]) listN.toArray(new String[0]))[0]);
    }

    public final String guessMimeTypeFromExtension(String extension) {
        if (extension == null || extension.length() == 0) {
            return null;
        }
        Map<String, String> map = extensionToMimeTypeMap;
        Locale locale = Locale.getDefault();
        y.h(locale, "getDefault(...)");
        String lowerCase = extension.toLowerCase(locale);
        y.h(lowerCase, "toLowerCase(...)");
        return map.get(lowerCase);
    }

    public final String guessMimeTypeFromUri(Context context, Uri uri) {
        String queryParameter;
        y.i(context, "context");
        y.i(uri, "uri");
        try {
            queryParameter = context.getContentResolver().getType(uri);
        } catch (Throwable unused) {
            queryParameter = null;
        }
        if (queryParameter == null && uri.getPath() != null) {
            String path = uri.getPath();
            y.f(path);
            int iU0 = d0.u0(path, '.', 0, false, 6, null) + 1;
            if (iU0 < path.length()) {
                String strSubstring = path.substring(iU0);
                y.h(strSubstring, "substring(...)");
                queryParameter = guessMimeTypeFromExtension(strSubstring);
            }
        }
        if (queryParameter == null) {
            queryParameter = uri.getQueryParameter("mimeType");
        }
        return queryParameter == null ? "" : queryParameter;
    }

    public final boolean hasExtension(String extension) {
        if (extension == null || extension.length() == 0) {
            return false;
        }
        return extensionToMimeTypeMap.containsKey(extension);
    }

    public final boolean hasMimeType(String mimeType) {
        if (mimeType == null || mimeType.length() == 0) {
            return false;
        }
        return mimeTypeToExtensionMap.containsKey(mimeType);
    }

    public final String extractRelevantExtension(URL url) {
        y.i(url, "url");
        return extractRelevantExtension(url.getPath(), true);
    }

    public final String extractRelevantExtension(String path, boolean ignoreCryptoExtension) {
        if (path != null && path.length() != 0) {
            String strSubstring = path.substring(d0.u0(path, '/', 0, false, 6, null) + 1);
            y.h(strSubstring, "substring(...)");
            Locale locale = Locale.getDefault();
            y.h(locale, "getDefault(...)");
            String lowerCase = strSubstring.toLowerCase(locale);
            y.h(lowerCase, "toLowerCase(...)");
            int iV0 = d0.v0(lowerCase, ".", 0, false, 6, null);
            if (iV0 != -1) {
                String strSubstring2 = lowerCase.substring(iV0 + 1);
                y.h(strSubstring2, "substring(...)");
                return strSubstring2;
            }
        }
        return null;
    }
}
