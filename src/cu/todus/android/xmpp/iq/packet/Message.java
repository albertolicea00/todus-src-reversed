package cu.todus.android.xmpp.iq.packet;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import j$.util.DesugarCollections;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.Nonza;
import org.jivesoftware.smack.packet.StreamOpen;
import org.jivesoftware.smack.util.MultiMap;
import org.jivesoftware.smack.util.Objects;
import org.jivesoftware.smack.util.PacketUtil;
import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jxmpp.jid.Jid;
import org.jxmpp.jid.impl.JidCreate;
import org.jxmpp.stringprep.XmppStringprepException;
import org.jxmpp.util.XmppStringUtils;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
public final class Message implements Nonza {
    public static final String BODY = "body";
    public static final String ELEMENT = "m";
    private Jid from;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f28849id;
    private final MultiMap<String, ExtensionElement> packetExtensions;
    private final Set<Subject> subjects;
    private String thread;
    private Jid to;
    private Type type;

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    public static final class Body implements ExtensionElement {
        public static final String ELEMENT = "body";
        public static final String NAMESPACE = "jc";
        private final String language;
        private final String message;
        private final BodyElementNamespace namespace;

        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        public enum BodyElementNamespace {
            client("jc"),
            server(StreamOpen.SERVER_NAMESPACE);

            private final String xmlNamespace;

            BodyElementNamespace(String str) {
                this.xmlNamespace = str;
            }

            public String getNamespace() {
                return this.xmlNamespace;
            }
        }

        public Body(String str, String str2) {
            this(str, str2, BodyElementNamespace.client);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || Body.class != obj.getClass()) {
                return false;
            }
            Body body = (Body) obj;
            return Objects.equals(this.language, body.language) && this.message.equals(body.message);
        }

        @Override // org.jivesoftware.smack.packet.NamedElement
        public String getElementName() {
            return "body";
        }

        public String getLanguage() {
            return this.language;
        }

        public String getMessage() {
            return this.message;
        }

        @Override // org.jivesoftware.smack.packet.ExtensionElement
        public String getNamespace() {
            return this.namespace.xmlNamespace;
        }

        public int hashCode() {
            String str = this.language;
            return ((str != null ? str.hashCode() + 31 : 1) * 31) + this.message.hashCode();
        }

        public Body(String str, String str2, BodyElementNamespace bodyElementNamespace) {
            if (str2 == null) {
                throw new NullPointerException("Message cannot be null.");
            }
            this.language = str;
            this.message = str2;
            this.namespace = (BodyElementNamespace) Objects.requireNonNull(bodyElementNamespace);
        }

        @Override // org.jivesoftware.smack.packet.Element
        public XmlStringBuilder toXML(String str) {
            XmlStringBuilder xmlStringBuilder = new XmlStringBuilder(this, str);
            xmlStringBuilder.optXmlLangAttribute(getLanguage()).rightAngleBracket();
            xmlStringBuilder.escape(this.message);
            xmlStringBuilder.closeElement(getElementName());
            return xmlStringBuilder;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    public static final class Subject implements ExtensionElement {
        public static final String ELEMENT = "subject";
        public static final String NAMESPACE = "jc";
        private final String language;
        private final String subject;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || Subject.class != obj.getClass()) {
                return false;
            }
            Subject subject = (Subject) obj;
            return this.language.equals(subject.language) && this.subject.equals(subject.subject);
        }

        @Override // org.jivesoftware.smack.packet.NamedElement
        public String getElementName() {
            return "subject";
        }

        public String getLanguage() {
            return this.language;
        }

        @Override // org.jivesoftware.smack.packet.ExtensionElement
        public String getNamespace() {
            return "jc";
        }

        public String getSubject() {
            return this.subject;
        }

        public int hashCode() {
            String str = this.language;
            return ((str != null ? str.hashCode() + 31 : 1) * 31) + this.subject.hashCode();
        }

        private Subject(String str, String str2) {
            if (str2 == null) {
                throw new NullPointerException("Subject cannot be null.");
            }
            this.language = str;
            this.subject = str2;
        }

        @Override // org.jivesoftware.smack.packet.Element
        public XmlStringBuilder toXML(String str) {
            XmlStringBuilder xmlStringBuilder = new XmlStringBuilder();
            xmlStringBuilder.halfOpenElement(getElementName()).optXmlLangAttribute(getLanguage()).rightAngleBracket();
            xmlStringBuilder.escape(this.subject);
            xmlStringBuilder.closeElement(getElementName());
            return xmlStringBuilder;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    public enum Type {
        normal,
        chat,
        groupchat,
        headline,
        error;

        public static Type fromString(String str) {
            return valueOf(str.toLowerCase(Locale.US));
        }
    }

    public Message() {
        this.subjects = new HashSet();
        this.packetExtensions = new MultiMap<>();
        this.thread = null;
        this.f28849id = null;
    }

    private String addCommonAttributes(XmlStringBuilder xmlStringBuilder, String str) {
        if (str == null || !str.equals("jc") || !str.equals(StreamOpen.SERVER_NAMESPACE)) {
            str = "jc";
        }
        xmlStringBuilder.optAttribute(TypedValues.TransitionType.S_TO, getTo());
        xmlStringBuilder.optAttribute(TypedValues.TransitionType.S_FROM, getFrom());
        xmlStringBuilder.optAttribute("id", getId());
        return str;
    }

    private String determineLanguage(String str) {
        if ("".equals(str)) {
            return null;
        }
        return str;
    }

    private Body getMessageBody(String str) {
        if (getBodies().size() > 1) {
            return getBodies().iterator().next();
        }
        return null;
    }

    private Subject getMessageSubject(String str) {
        String strDetermineLanguage = determineLanguage(str);
        for (Subject subject : this.subjects) {
            if (Objects.equals(strDetermineLanguage, subject.language)) {
                return subject;
            }
        }
        return null;
    }

    public Body addBody(String str, String str2) {
        String strDetermineLanguage = determineLanguage(str);
        removeBody(strDetermineLanguage);
        Body body = new Body(strDetermineLanguage, str2);
        addExtension(body);
        return body;
    }

    public void addExtension(ExtensionElement extensionElement) {
        if (extensionElement == null) {
            return;
        }
        String strGenerateKey = XmppStringUtils.generateKey(extensionElement.getElementName(), extensionElement.getNamespace());
        synchronized (this.packetExtensions) {
            this.packetExtensions.put(strGenerateKey, extensionElement);
        }
    }

    public void addExtensions(Collection<ExtensionElement> collection) {
        if (collection == null) {
            return;
        }
        Iterator<ExtensionElement> it = collection.iterator();
        while (it.hasNext()) {
            addExtension(it.next());
        }
    }

    public Subject addSubject(String str, String str2) {
        Subject subject = new Subject(determineLanguage(str), str2);
        this.subjects.add(subject);
        return subject;
    }

    public Set<Body> getBodies() {
        List<ExtensionElement> extensions = getExtensions("body", "jc");
        HashSet hashSet = new HashSet(extensions.size());
        Iterator<ExtensionElement> it = extensions.iterator();
        while (it.hasNext()) {
            hashSet.add((Body) it.next());
        }
        return hashSet;
    }

    public String getBody() {
        return getBody("");
    }

    public List<String> getBodyLanguages() {
        Body messageBody = getMessageBody(null);
        ArrayList arrayList = new ArrayList();
        for (Body body : getBodies()) {
            if (!body.equals(messageBody)) {
                arrayList.add(body.language);
            }
        }
        return DesugarCollections.unmodifiableList(arrayList);
    }

    @Override // org.jivesoftware.smack.packet.NamedElement
    public String getElementName() {
        return "m";
    }

    public ExtensionElement getExtension(String str) {
        return PacketUtil.extensionElementFrom(getExtensions(), null, str);
    }

    public List<ExtensionElement> getExtensions() {
        List<ExtensionElement> listValues;
        synchronized (this.packetExtensions) {
            listValues = this.packetExtensions.values();
        }
        return listValues;
    }

    public Jid getFrom() {
        return this.from;
    }

    public String getId() {
        return this.f28849id;
    }

    @Override // org.jivesoftware.smack.packet.ExtensionElement
    public String getNamespace() {
        return "";
    }

    public String getSubject() {
        return getSubject(null);
    }

    public List<String> getSubjectLanguages() {
        Subject messageSubject = getMessageSubject(null);
        ArrayList arrayList = new ArrayList();
        for (Subject subject : this.subjects) {
            if (!subject.equals(messageSubject)) {
                arrayList.add(subject.language);
            }
        }
        return DesugarCollections.unmodifiableList(arrayList);
    }

    public Set<Subject> getSubjects() {
        return DesugarCollections.unmodifiableSet(this.subjects);
    }

    public String getThread() {
        return this.thread;
    }

    public Jid getTo() {
        return this.to;
    }

    public Type getType() {
        Type type = this.type;
        return type == null ? Type.normal : type;
    }

    public boolean hasExtension(String str, String str2) {
        boolean zContainsKey;
        if (str == null) {
            return hasExtension(str2);
        }
        String strGenerateKey = XmppStringUtils.generateKey(str, str2);
        synchronized (this.packetExtensions) {
            zContainsKey = this.packetExtensions.containsKey(strGenerateKey);
        }
        return zContainsKey;
    }

    public ExtensionElement overrideExtension(ExtensionElement extensionElement) {
        ExtensionElement extensionElementRemoveExtension;
        if (extensionElement == null) {
            return null;
        }
        synchronized (this.packetExtensions) {
            extensionElementRemoveExtension = removeExtension(extensionElement.getElementName(), extensionElement.getNamespace());
            addExtension(extensionElement);
        }
        return extensionElementRemoveExtension;
    }

    public boolean removeBody(String str) {
        String strDetermineLanguage = determineLanguage(str);
        for (Body body : getBodies()) {
            if (Objects.equals(body.getLanguage(), strDetermineLanguage)) {
                removeExtension(body);
                return true;
            }
        }
        return false;
    }

    public ExtensionElement removeExtension(String str, String str2) {
        ExtensionElement extensionElementRemove;
        String strGenerateKey = XmppStringUtils.generateKey(str, str2);
        synchronized (this.packetExtensions) {
            extensionElementRemove = this.packetExtensions.remove(strGenerateKey);
        }
        return extensionElementRemove;
    }

    public boolean removeSubject(String str) {
        String strDetermineLanguage = determineLanguage(str);
        for (Subject subject : this.subjects) {
            if (strDetermineLanguage.equals(subject.language)) {
                return this.subjects.remove(subject);
            }
        }
        return false;
    }

    public void setBody(CharSequence charSequence) {
        setBody(charSequence != null ? charSequence.toString() : null);
    }

    public void setFrom(Jid jid) {
        this.from = jid;
    }

    public void setId(String str) {
        this.f28849id = str;
    }

    public void setSubject(String str) {
        if (str == null) {
            removeSubject("");
        } else {
            addSubject(null, str);
        }
    }

    public void setThread(String str) {
        this.thread = str;
    }

    public void setTo(Jid jid) {
        this.to = jid;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Message Stanza [");
        if (this.type != null) {
            sb2.append("type=");
            sb2.append(this.type);
            sb2.append(',');
        }
        sb2.append(']');
        return sb2.toString();
    }

    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public Message m10129clone() {
        return new Message(this);
    }

    public String getBody(String str) {
        Body messageBody = getMessageBody(str);
        if (messageBody == null) {
            return null;
        }
        return messageBody.message;
    }

    public <PE extends ExtensionElement> PE getExtension(String str, String str2) {
        PE pe2;
        if (str2 == null) {
            return null;
        }
        String strGenerateKey = XmppStringUtils.generateKey(str, str2);
        synchronized (this.packetExtensions) {
            pe2 = (PE) this.packetExtensions.getFirst(strGenerateKey);
        }
        if (pe2 == null) {
            return null;
        }
        return pe2;
    }

    public String getSubject(String str) {
        Subject messageSubject = getMessageSubject(str);
        if (messageSubject == null) {
            return null;
        }
        return messageSubject.subject;
    }

    @Override // org.jivesoftware.smack.packet.Element
    public XmlStringBuilder toXML(String str) {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder(str);
        xmlStringBuilder.halfOpenElement("m");
        String strAddCommonAttributes = addCommonAttributes(xmlStringBuilder, str);
        xmlStringBuilder.optAttribute("type", this.type);
        xmlStringBuilder.rightAngleBracket();
        Subject messageSubject = getMessageSubject(null);
        if (messageSubject != null) {
            xmlStringBuilder.element("subject", messageSubject.subject);
        }
        for (Subject subject : getSubjects()) {
            if (!subject.equals(messageSubject)) {
                xmlStringBuilder.append(subject.toXML((String) null));
            }
        }
        xmlStringBuilder.optElement("thread", this.thread);
        xmlStringBuilder.append(getExtensions(), strAddCommonAttributes);
        xmlStringBuilder.closeElement("m");
        return xmlStringBuilder;
    }

    public void setBody(String str) {
        if (str == null) {
            removeBody("");
        } else {
            addBody(null, str);
        }
    }

    public List<ExtensionElement> getExtensions(String str, String str2) {
        StringUtils.requireNotNullOrEmpty(str, "elementName must not be null or empty");
        StringUtils.requireNotNullOrEmpty(str2, "namespace must not be null or empty");
        return this.packetExtensions.getAll(XmppStringUtils.generateKey(str, str2));
    }

    public ExtensionElement removeExtension(ExtensionElement extensionElement) {
        String strGenerateKey = XmppStringUtils.generateKey(extensionElement.getElementName(), extensionElement.getNamespace());
        synchronized (this.packetExtensions) {
            try {
                if (this.packetExtensions.getAll(strGenerateKey).remove(extensionElement)) {
                    return extensionElement;
                }
                return null;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public boolean removeSubject(Subject subject) {
        return this.subjects.remove(subject);
    }

    public Message(Jid jid) {
        this.subjects = new HashSet();
        this.packetExtensions = new MultiMap<>();
        this.thread = null;
        this.f28849id = null;
        setTo(jid);
    }

    public boolean hasExtension(String str) {
        synchronized (this.packetExtensions) {
            try {
                Iterator<ExtensionElement> it = this.packetExtensions.values().iterator();
                while (it.hasNext()) {
                    if (it.next().getNamespace().equals(str)) {
                        return true;
                    }
                }
                return false;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public boolean removeBody(Body body) {
        return removeExtension(body) != null;
    }

    public Message(Jid jid, Type type) {
        this(jid);
        setType(type);
    }

    public Message(Jid jid, String str) {
        this(jid);
        setBody(str);
    }

    public Message(String str, String str2) throws XmppStringprepException {
        this(JidCreate.from(str), str2);
    }

    public Message(Jid jid, ExtensionElement extensionElement) {
        this(jid);
        addExtension(extensionElement);
    }

    public Message(Message message) {
        HashSet hashSet = new HashSet();
        this.subjects = hashSet;
        this.packetExtensions = new MultiMap<>();
        this.thread = null;
        this.f28849id = null;
        this.type = message.type;
        this.thread = message.thread;
        hashSet.addAll(message.subjects);
    }
}
