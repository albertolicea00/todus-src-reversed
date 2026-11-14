package cu.todus.android.xmpp.iq.call;

import cu.todus.android.data.xmpp.TurnCredentials;

import org.jivesoftware.smack.packet.IQ;

/**
 * XMPP IQ stanza requesting TURN server credentials under namespace {@code todus:turn:cred}.
 *
 * @obfuscated_class cu.todus.android.xmpp.iq.call.GetCredentialsIQ
 */
public final class GetCredentialsIQ extends IQ {

    public static final String ELEMENT = "query";
    public static final String NAMESPACE = "todus:turn:cred";

    private final TurnCredentials turnCredentials;

    public GetCredentialsIQ(String userId, TurnCredentials turnCredentials) {
        super(ELEMENT, NAMESPACE);
        this.turnCredentials = turnCredentials;
        setType(IQ.Type.get);
    }

    public TurnCredentials getTurnCredentials() {
        return turnCredentials;
    }

    @Override
    protected IQChildElementXmlStringBuilder getIQChildElementBuilder(IQChildElementXmlStringBuilder xml) {
        xml.rightAngleBracket();
        return xml;
    }
}
