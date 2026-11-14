package cu.todus.android.xmpp;

import cu.todus.android.constants.Service;
import cu.todus.android.utils.HashUtils;

import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.tcp.XMPPTCPConnectionConfiguration;
import org.jxmpp.jid.impl.JidCreate;
import org.jxmpp.stringprep.XmppStringprepException;

/**
 * Factory creating Smack {@link XMPPTCPConnectionConfiguration} instances for
 * {@code im.todus.cu} with MD5-hashed resource {@code <md5(username)>_Android},
 * compression enabled, and {@code SecurityMode.disabled}.
 *
 * @obfuscated_class cu.todus.android.xmpp.ToDusXMPPFactoryConfiguration
 */
public final class ToDusXMPPFactoryConfiguration {

    private ToDusXMPPFactoryConfiguration() {
    }

    public static XMPPTCPConnectionConfiguration create(String username, String host, int port)
            throws XmppStringprepException {
        XMPPTCPConnectionConfiguration.Builder builder = XMPPTCPConnectionConfiguration.builder();
        builder.setResource(HashUtils.INSTANCE.md5(username) + "_Android");
        builder.setXmppDomain(JidCreate.from(Service.Config.SERVER_DOMAIN).asDomainBareJid());
        builder.setHost(host);
        builder.setCompressionEnabled(true);
        builder.setPort(port);
        builder.setSendPresence(true);
        builder.setSecurityMode(ConnectionConfiguration.SecurityMode.disabled);
        return builder.build();
    }
}
