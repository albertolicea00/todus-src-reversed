package cu.todus.proto;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MapEntryLite;
import com.google.protobuf.MapFieldLite;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.WireFormat;
import j$.util.DesugarCollections;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
public final class ApiProto {

    /* JADX INFO: renamed from: cu.todus.proto.ApiProto$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    public static final class ChannelsSendMessageReq extends GeneratedMessageLite<ChannelsSendMessageReq, Builder> implements ChannelsSendMessageReqOrBuilder {
        public static final int CHANNEL_USERNAME_FIELD_NUMBER = 1;
        private static final ChannelsSendMessageReq DEFAULT_INSTANCE;
        public static final int MESSAGE_FIELD_NUMBER = 3;
        private static volatile Parser<ChannelsSendMessageReq> PARSER = null;
        public static final int USER_DOMAIN_FIELD_NUMBER = 2;
        private String channelUsername_ = "";
        private String userDomain_ = "";
        private String message_ = "";

        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        public static final class Builder extends GeneratedMessageLite.Builder<ChannelsSendMessageReq, Builder> implements ChannelsSendMessageReqOrBuilder {
            public Builder clearChannelUsername() {
                copyOnWrite();
                ((ChannelsSendMessageReq) this.instance).clearChannelUsername();
                return this;
            }

            public Builder clearMessage() {
                copyOnWrite();
                ((ChannelsSendMessageReq) this.instance).clearMessage();
                return this;
            }

            public Builder clearUserDomain() {
                copyOnWrite();
                ((ChannelsSendMessageReq) this.instance).clearUserDomain();
                return this;
            }

            @Override // cu.todus.proto.ApiProto.ChannelsSendMessageReqOrBuilder
            public String getChannelUsername() {
                return ((ChannelsSendMessageReq) this.instance).getChannelUsername();
            }

            @Override // cu.todus.proto.ApiProto.ChannelsSendMessageReqOrBuilder
            public ByteString getChannelUsernameBytes() {
                return ((ChannelsSendMessageReq) this.instance).getChannelUsernameBytes();
            }

            @Override // cu.todus.proto.ApiProto.ChannelsSendMessageReqOrBuilder
            public String getMessage() {
                return ((ChannelsSendMessageReq) this.instance).getMessage();
            }

            @Override // cu.todus.proto.ApiProto.ChannelsSendMessageReqOrBuilder
            public ByteString getMessageBytes() {
                return ((ChannelsSendMessageReq) this.instance).getMessageBytes();
            }

            @Override // cu.todus.proto.ApiProto.ChannelsSendMessageReqOrBuilder
            public String getUserDomain() {
                return ((ChannelsSendMessageReq) this.instance).getUserDomain();
            }

            @Override // cu.todus.proto.ApiProto.ChannelsSendMessageReqOrBuilder
            public ByteString getUserDomainBytes() {
                return ((ChannelsSendMessageReq) this.instance).getUserDomainBytes();
            }

            public Builder setChannelUsername(String str) {
                copyOnWrite();
                ((ChannelsSendMessageReq) this.instance).setChannelUsername(str);
                return this;
            }

            public Builder setChannelUsernameBytes(ByteString byteString) {
                copyOnWrite();
                ((ChannelsSendMessageReq) this.instance).setChannelUsernameBytes(byteString);
                return this;
            }

            public Builder setMessage(String str) {
                copyOnWrite();
                ((ChannelsSendMessageReq) this.instance).setMessage(str);
                return this;
            }

            public Builder setMessageBytes(ByteString byteString) {
                copyOnWrite();
                ((ChannelsSendMessageReq) this.instance).setMessageBytes(byteString);
                return this;
            }

            public Builder setUserDomain(String str) {
                copyOnWrite();
                ((ChannelsSendMessageReq) this.instance).setUserDomain(str);
                return this;
            }

            public Builder setUserDomainBytes(ByteString byteString) {
                copyOnWrite();
                ((ChannelsSendMessageReq) this.instance).setUserDomainBytes(byteString);
                return this;
            }

            private Builder() {
                super(ChannelsSendMessageReq.DEFAULT_INSTANCE);
            }
        }

        static {
            ChannelsSendMessageReq channelsSendMessageReq = new ChannelsSendMessageReq();
            DEFAULT_INSTANCE = channelsSendMessageReq;
            GeneratedMessageLite.registerDefaultInstance(ChannelsSendMessageReq.class, channelsSendMessageReq);
        }

        private ChannelsSendMessageReq() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearChannelUsername() {
            this.channelUsername_ = getDefaultInstance().getChannelUsername();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearMessage() {
            this.message_ = getDefaultInstance().getMessage();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearUserDomain() {
            this.userDomain_ = getDefaultInstance().getUserDomain();
        }

        public static ChannelsSendMessageReq getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static ChannelsSendMessageReq parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (ChannelsSendMessageReq) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ChannelsSendMessageReq parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (ChannelsSendMessageReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser<ChannelsSendMessageReq> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setChannelUsername(String str) {
            str.getClass();
            this.channelUsername_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setChannelUsernameBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.channelUsername_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMessage(String str) {
            str.getClass();
            this.message_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMessageBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.message_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUserDomain(String str) {
            str.getClass();
            this.userDomain_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUserDomainBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.userDomain_ = byteString.toStringUtf8();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new ChannelsSendMessageReq();
                case 2:
                    return new Builder();
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ", new Object[]{"channelUsername_", "userDomain_", "message_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<ChannelsSendMessageReq> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (ChannelsSendMessageReq.class) {
                        try {
                            defaultInstanceBasedParser = PARSER;
                            if (defaultInstanceBasedParser == null) {
                                defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                                PARSER = defaultInstanceBasedParser;
                            }
                        } catch (Throwable th2) {
                            throw th2;
                        }
                        break;
                    }
                    return defaultInstanceBasedParser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        @Override // cu.todus.proto.ApiProto.ChannelsSendMessageReqOrBuilder
        public String getChannelUsername() {
            return this.channelUsername_;
        }

        @Override // cu.todus.proto.ApiProto.ChannelsSendMessageReqOrBuilder
        public ByteString getChannelUsernameBytes() {
            return ByteString.copyFromUtf8(this.channelUsername_);
        }

        @Override // cu.todus.proto.ApiProto.ChannelsSendMessageReqOrBuilder
        public String getMessage() {
            return this.message_;
        }

        @Override // cu.todus.proto.ApiProto.ChannelsSendMessageReqOrBuilder
        public ByteString getMessageBytes() {
            return ByteString.copyFromUtf8(this.message_);
        }

        @Override // cu.todus.proto.ApiProto.ChannelsSendMessageReqOrBuilder
        public String getUserDomain() {
            return this.userDomain_;
        }

        @Override // cu.todus.proto.ApiProto.ChannelsSendMessageReqOrBuilder
        public ByteString getUserDomainBytes() {
            return ByteString.copyFromUtf8(this.userDomain_);
        }

        public static Builder newBuilder(ChannelsSendMessageReq channelsSendMessageReq) {
            return DEFAULT_INSTANCE.createBuilder(channelsSendMessageReq);
        }

        public static ChannelsSendMessageReq parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ChannelsSendMessageReq) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ChannelsSendMessageReq parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ChannelsSendMessageReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static ChannelsSendMessageReq parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (ChannelsSendMessageReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static ChannelsSendMessageReq parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ChannelsSendMessageReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static ChannelsSendMessageReq parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (ChannelsSendMessageReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static ChannelsSendMessageReq parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ChannelsSendMessageReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static ChannelsSendMessageReq parseFrom(InputStream inputStream) throws IOException {
            return (ChannelsSendMessageReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ChannelsSendMessageReq parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ChannelsSendMessageReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ChannelsSendMessageReq parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (ChannelsSendMessageReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static ChannelsSendMessageReq parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ChannelsSendMessageReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    public interface ChannelsSendMessageReqOrBuilder extends MessageLiteOrBuilder {
        String getChannelUsername();

        ByteString getChannelUsernameBytes();

        String getMessage();

        ByteString getMessageBytes();

        String getUserDomain();

        ByteString getUserDomainBytes();
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    public static final class ChannelsSendMessageResp extends GeneratedMessageLite<ChannelsSendMessageResp, Builder> implements ChannelsSendMessageRespOrBuilder {
        private static final ChannelsSendMessageResp DEFAULT_INSTANCE;
        public static final int MSG_FIELD_NUMBER = 1;
        private static volatile Parser<ChannelsSendMessageResp> PARSER;
        private int msg_;

        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        public static final class Builder extends GeneratedMessageLite.Builder<ChannelsSendMessageResp, Builder> implements ChannelsSendMessageRespOrBuilder {
            public Builder clearMsg() {
                copyOnWrite();
                ((ChannelsSendMessageResp) this.instance).clearMsg();
                return this;
            }

            @Override // cu.todus.proto.ApiProto.ChannelsSendMessageRespOrBuilder
            public MessageErrors getMsg() {
                return ((ChannelsSendMessageResp) this.instance).getMsg();
            }

            @Override // cu.todus.proto.ApiProto.ChannelsSendMessageRespOrBuilder
            public int getMsgValue() {
                return ((ChannelsSendMessageResp) this.instance).getMsgValue();
            }

            public Builder setMsg(MessageErrors messageErrors) {
                copyOnWrite();
                ((ChannelsSendMessageResp) this.instance).setMsg(messageErrors);
                return this;
            }

            public Builder setMsgValue(int i10) {
                copyOnWrite();
                ((ChannelsSendMessageResp) this.instance).setMsgValue(i10);
                return this;
            }

            private Builder() {
                super(ChannelsSendMessageResp.DEFAULT_INSTANCE);
            }
        }

        static {
            ChannelsSendMessageResp channelsSendMessageResp = new ChannelsSendMessageResp();
            DEFAULT_INSTANCE = channelsSendMessageResp;
            GeneratedMessageLite.registerDefaultInstance(ChannelsSendMessageResp.class, channelsSendMessageResp);
        }

        private ChannelsSendMessageResp() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearMsg() {
            this.msg_ = 0;
        }

        public static ChannelsSendMessageResp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static ChannelsSendMessageResp parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (ChannelsSendMessageResp) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ChannelsSendMessageResp parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (ChannelsSendMessageResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser<ChannelsSendMessageResp> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMsg(MessageErrors messageErrors) {
            this.msg_ = messageErrors.getNumber();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMsgValue(int i10) {
            this.msg_ = i10;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new ChannelsSendMessageResp();
                case 2:
                    return new Builder();
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\f", new Object[]{"msg_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<ChannelsSendMessageResp> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (ChannelsSendMessageResp.class) {
                        try {
                            defaultInstanceBasedParser = PARSER;
                            if (defaultInstanceBasedParser == null) {
                                defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                                PARSER = defaultInstanceBasedParser;
                            }
                        } catch (Throwable th2) {
                            throw th2;
                        }
                        break;
                    }
                    return defaultInstanceBasedParser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        @Override // cu.todus.proto.ApiProto.ChannelsSendMessageRespOrBuilder
        public MessageErrors getMsg() {
            MessageErrors messageErrorsForNumber = MessageErrors.forNumber(this.msg_);
            return messageErrorsForNumber == null ? MessageErrors.UNRECOGNIZED : messageErrorsForNumber;
        }

        @Override // cu.todus.proto.ApiProto.ChannelsSendMessageRespOrBuilder
        public int getMsgValue() {
            return this.msg_;
        }

        public static Builder newBuilder(ChannelsSendMessageResp channelsSendMessageResp) {
            return DEFAULT_INSTANCE.createBuilder(channelsSendMessageResp);
        }

        public static ChannelsSendMessageResp parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ChannelsSendMessageResp) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ChannelsSendMessageResp parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ChannelsSendMessageResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static ChannelsSendMessageResp parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (ChannelsSendMessageResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static ChannelsSendMessageResp parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ChannelsSendMessageResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static ChannelsSendMessageResp parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (ChannelsSendMessageResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static ChannelsSendMessageResp parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ChannelsSendMessageResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static ChannelsSendMessageResp parseFrom(InputStream inputStream) throws IOException {
            return (ChannelsSendMessageResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ChannelsSendMessageResp parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ChannelsSendMessageResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ChannelsSendMessageResp parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (ChannelsSendMessageResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static ChannelsSendMessageResp parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ChannelsSendMessageResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    public interface ChannelsSendMessageRespOrBuilder extends MessageLiteOrBuilder {
        MessageErrors getMsg();

        int getMsgValue();
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    public static final class CheckChannelsVersionReq extends GeneratedMessageLite<CheckChannelsVersionReq, Builder> implements CheckChannelsVersionReqOrBuilder {
        public static final int CHANNEL_VER_FIELD_NUMBER = 2;
        private static final CheckChannelsVersionReq DEFAULT_INSTANCE;
        private static volatile Parser<CheckChannelsVersionReq> PARSER;
        private MapFieldLite<String, Integer> channelVer_ = MapFieldLite.emptyMapField();

        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        public static final class Builder extends GeneratedMessageLite.Builder<CheckChannelsVersionReq, Builder> implements CheckChannelsVersionReqOrBuilder {
            public Builder clearChannelVer() {
                copyOnWrite();
                ((CheckChannelsVersionReq) this.instance).getMutableChannelVerMap().clear();
                return this;
            }

            @Override // cu.todus.proto.ApiProto.CheckChannelsVersionReqOrBuilder
            public boolean containsChannelVer(String str) {
                str.getClass();
                return ((CheckChannelsVersionReq) this.instance).getChannelVerMap().containsKey(str);
            }

            @Override // cu.todus.proto.ApiProto.CheckChannelsVersionReqOrBuilder
            @Deprecated
            public Map<String, Integer> getChannelVer() {
                return getChannelVerMap();
            }

            @Override // cu.todus.proto.ApiProto.CheckChannelsVersionReqOrBuilder
            public int getChannelVerCount() {
                return ((CheckChannelsVersionReq) this.instance).getChannelVerMap().size();
            }

            @Override // cu.todus.proto.ApiProto.CheckChannelsVersionReqOrBuilder
            public Map<String, Integer> getChannelVerMap() {
                return DesugarCollections.unmodifiableMap(((CheckChannelsVersionReq) this.instance).getChannelVerMap());
            }

            @Override // cu.todus.proto.ApiProto.CheckChannelsVersionReqOrBuilder
            public int getChannelVerOrDefault(String str, int i10) {
                str.getClass();
                Map<String, Integer> channelVerMap = ((CheckChannelsVersionReq) this.instance).getChannelVerMap();
                return channelVerMap.containsKey(str) ? channelVerMap.get(str).intValue() : i10;
            }

            @Override // cu.todus.proto.ApiProto.CheckChannelsVersionReqOrBuilder
            public int getChannelVerOrThrow(String str) {
                str.getClass();
                Map<String, Integer> channelVerMap = ((CheckChannelsVersionReq) this.instance).getChannelVerMap();
                if (channelVerMap.containsKey(str)) {
                    return channelVerMap.get(str).intValue();
                }
                throw new IllegalArgumentException();
            }

            public Builder putAllChannelVer(Map<String, Integer> map) {
                copyOnWrite();
                ((CheckChannelsVersionReq) this.instance).getMutableChannelVerMap().putAll(map);
                return this;
            }

            public Builder putChannelVer(String str, int i10) {
                str.getClass();
                copyOnWrite();
                ((CheckChannelsVersionReq) this.instance).getMutableChannelVerMap().put(str, Integer.valueOf(i10));
                return this;
            }

            public Builder removeChannelVer(String str) {
                str.getClass();
                copyOnWrite();
                ((CheckChannelsVersionReq) this.instance).getMutableChannelVerMap().remove(str);
                return this;
            }

            private Builder() {
                super(CheckChannelsVersionReq.DEFAULT_INSTANCE);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        public static final class ChannelVerDefaultEntryHolder {
            static final MapEntryLite<String, Integer> defaultEntry = MapEntryLite.newDefaultInstance(WireFormat.FieldType.STRING, "", WireFormat.FieldType.INT32, 0);

            private ChannelVerDefaultEntryHolder() {
            }
        }

        static {
            CheckChannelsVersionReq checkChannelsVersionReq = new CheckChannelsVersionReq();
            DEFAULT_INSTANCE = checkChannelsVersionReq;
            GeneratedMessageLite.registerDefaultInstance(CheckChannelsVersionReq.class, checkChannelsVersionReq);
        }

        private CheckChannelsVersionReq() {
        }

        public static CheckChannelsVersionReq getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Map<String, Integer> getMutableChannelVerMap() {
            return internalGetMutableChannelVer();
        }

        private MapFieldLite<String, Integer> internalGetChannelVer() {
            return this.channelVer_;
        }

        private MapFieldLite<String, Integer> internalGetMutableChannelVer() {
            if (!this.channelVer_.isMutable()) {
                this.channelVer_ = this.channelVer_.mutableCopy();
            }
            return this.channelVer_;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static CheckChannelsVersionReq parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (CheckChannelsVersionReq) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static CheckChannelsVersionReq parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (CheckChannelsVersionReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser<CheckChannelsVersionReq> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        @Override // cu.todus.proto.ApiProto.CheckChannelsVersionReqOrBuilder
        public boolean containsChannelVer(String str) {
            str.getClass();
            return internalGetChannelVer().containsKey(str);
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new CheckChannelsVersionReq();
                case 2:
                    return new Builder();
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0002\u0002\u0001\u0001\u0000\u0000\u00022", new Object[]{"channelVer_", ChannelVerDefaultEntryHolder.defaultEntry});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<CheckChannelsVersionReq> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (CheckChannelsVersionReq.class) {
                        try {
                            defaultInstanceBasedParser = PARSER;
                            if (defaultInstanceBasedParser == null) {
                                defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                                PARSER = defaultInstanceBasedParser;
                            }
                        } catch (Throwable th2) {
                            throw th2;
                        }
                        break;
                    }
                    return defaultInstanceBasedParser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        @Override // cu.todus.proto.ApiProto.CheckChannelsVersionReqOrBuilder
        @Deprecated
        public Map<String, Integer> getChannelVer() {
            return getChannelVerMap();
        }

        @Override // cu.todus.proto.ApiProto.CheckChannelsVersionReqOrBuilder
        public int getChannelVerCount() {
            return internalGetChannelVer().size();
        }

        @Override // cu.todus.proto.ApiProto.CheckChannelsVersionReqOrBuilder
        public Map<String, Integer> getChannelVerMap() {
            return DesugarCollections.unmodifiableMap(internalGetChannelVer());
        }

        @Override // cu.todus.proto.ApiProto.CheckChannelsVersionReqOrBuilder
        public int getChannelVerOrDefault(String str, int i10) {
            str.getClass();
            MapFieldLite<String, Integer> mapFieldLiteInternalGetChannelVer = internalGetChannelVer();
            return mapFieldLiteInternalGetChannelVer.containsKey(str) ? mapFieldLiteInternalGetChannelVer.get(str).intValue() : i10;
        }

        @Override // cu.todus.proto.ApiProto.CheckChannelsVersionReqOrBuilder
        public int getChannelVerOrThrow(String str) {
            str.getClass();
            MapFieldLite<String, Integer> mapFieldLiteInternalGetChannelVer = internalGetChannelVer();
            if (mapFieldLiteInternalGetChannelVer.containsKey(str)) {
                return mapFieldLiteInternalGetChannelVer.get(str).intValue();
            }
            throw new IllegalArgumentException();
        }

        public static Builder newBuilder(CheckChannelsVersionReq checkChannelsVersionReq) {
            return DEFAULT_INSTANCE.createBuilder(checkChannelsVersionReq);
        }

        public static CheckChannelsVersionReq parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (CheckChannelsVersionReq) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static CheckChannelsVersionReq parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (CheckChannelsVersionReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static CheckChannelsVersionReq parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (CheckChannelsVersionReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static CheckChannelsVersionReq parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (CheckChannelsVersionReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static CheckChannelsVersionReq parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (CheckChannelsVersionReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static CheckChannelsVersionReq parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (CheckChannelsVersionReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static CheckChannelsVersionReq parseFrom(InputStream inputStream) throws IOException {
            return (CheckChannelsVersionReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static CheckChannelsVersionReq parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (CheckChannelsVersionReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static CheckChannelsVersionReq parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (CheckChannelsVersionReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static CheckChannelsVersionReq parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (CheckChannelsVersionReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    public interface CheckChannelsVersionReqOrBuilder extends MessageLiteOrBuilder {
        boolean containsChannelVer(String str);

        @Deprecated
        Map<String, Integer> getChannelVer();

        int getChannelVerCount();

        Map<String, Integer> getChannelVerMap();

        int getChannelVerOrDefault(String str, int i10);

        int getChannelVerOrThrow(String str);
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    public static final class CheckChannelsVersionResp extends GeneratedMessageLite<CheckChannelsVersionResp, Builder> implements CheckChannelsVersionRespOrBuilder {
        private static final CheckChannelsVersionResp DEFAULT_INSTANCE;
        private static volatile Parser<CheckChannelsVersionResp> PARSER = null;
        public static final int VER_AFF_FIELD_NUMBER = 1;
        private MapFieldLite<String, VerAff> verAff_ = MapFieldLite.emptyMapField();

        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        public static final class Builder extends GeneratedMessageLite.Builder<CheckChannelsVersionResp, Builder> implements CheckChannelsVersionRespOrBuilder {
            public Builder clearVerAff() {
                copyOnWrite();
                ((CheckChannelsVersionResp) this.instance).getMutableVerAffMap().clear();
                return this;
            }

            @Override // cu.todus.proto.ApiProto.CheckChannelsVersionRespOrBuilder
            public boolean containsVerAff(String str) {
                str.getClass();
                return ((CheckChannelsVersionResp) this.instance).getVerAffMap().containsKey(str);
            }

            @Override // cu.todus.proto.ApiProto.CheckChannelsVersionRespOrBuilder
            @Deprecated
            public Map<String, VerAff> getVerAff() {
                return getVerAffMap();
            }

            @Override // cu.todus.proto.ApiProto.CheckChannelsVersionRespOrBuilder
            public int getVerAffCount() {
                return ((CheckChannelsVersionResp) this.instance).getVerAffMap().size();
            }

            @Override // cu.todus.proto.ApiProto.CheckChannelsVersionRespOrBuilder
            public Map<String, VerAff> getVerAffMap() {
                return DesugarCollections.unmodifiableMap(((CheckChannelsVersionResp) this.instance).getVerAffMap());
            }

            @Override // cu.todus.proto.ApiProto.CheckChannelsVersionRespOrBuilder
            public VerAff getVerAffOrDefault(String str, VerAff verAff) {
                str.getClass();
                Map<String, VerAff> verAffMap = ((CheckChannelsVersionResp) this.instance).getVerAffMap();
                return verAffMap.containsKey(str) ? verAffMap.get(str) : verAff;
            }

            @Override // cu.todus.proto.ApiProto.CheckChannelsVersionRespOrBuilder
            public VerAff getVerAffOrThrow(String str) {
                str.getClass();
                Map<String, VerAff> verAffMap = ((CheckChannelsVersionResp) this.instance).getVerAffMap();
                if (verAffMap.containsKey(str)) {
                    return verAffMap.get(str);
                }
                throw new IllegalArgumentException();
            }

            public Builder putAllVerAff(Map<String, VerAff> map) {
                copyOnWrite();
                ((CheckChannelsVersionResp) this.instance).getMutableVerAffMap().putAll(map);
                return this;
            }

            public Builder putVerAff(String str, VerAff verAff) {
                str.getClass();
                verAff.getClass();
                copyOnWrite();
                ((CheckChannelsVersionResp) this.instance).getMutableVerAffMap().put(str, verAff);
                return this;
            }

            public Builder removeVerAff(String str) {
                str.getClass();
                copyOnWrite();
                ((CheckChannelsVersionResp) this.instance).getMutableVerAffMap().remove(str);
                return this;
            }

            private Builder() {
                super(CheckChannelsVersionResp.DEFAULT_INSTANCE);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        public static final class VerAff extends GeneratedMessageLite<VerAff, Builder> implements VerAffOrBuilder {
            public static final int AFF_FIELD_NUMBER = 2;
            private static final VerAff DEFAULT_INSTANCE;
            private static volatile Parser<VerAff> PARSER = null;
            public static final int VERSION_FIELD_NUMBER = 1;
            private String aff_ = "";
            private int version_;

            /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
            public static final class Builder extends GeneratedMessageLite.Builder<VerAff, Builder> implements VerAffOrBuilder {
                public Builder clearAff() {
                    copyOnWrite();
                    ((VerAff) this.instance).clearAff();
                    return this;
                }

                public Builder clearVersion() {
                    copyOnWrite();
                    ((VerAff) this.instance).clearVersion();
                    return this;
                }

                @Override // cu.todus.proto.ApiProto.CheckChannelsVersionResp.VerAffOrBuilder
                public String getAff() {
                    return ((VerAff) this.instance).getAff();
                }

                @Override // cu.todus.proto.ApiProto.CheckChannelsVersionResp.VerAffOrBuilder
                public ByteString getAffBytes() {
                    return ((VerAff) this.instance).getAffBytes();
                }

                @Override // cu.todus.proto.ApiProto.CheckChannelsVersionResp.VerAffOrBuilder
                public int getVersion() {
                    return ((VerAff) this.instance).getVersion();
                }

                public Builder setAff(String str) {
                    copyOnWrite();
                    ((VerAff) this.instance).setAff(str);
                    return this;
                }

                public Builder setAffBytes(ByteString byteString) {
                    copyOnWrite();
                    ((VerAff) this.instance).setAffBytes(byteString);
                    return this;
                }

                public Builder setVersion(int i10) {
                    copyOnWrite();
                    ((VerAff) this.instance).setVersion(i10);
                    return this;
                }

                private Builder() {
                    super(VerAff.DEFAULT_INSTANCE);
                }
            }

            static {
                VerAff verAff = new VerAff();
                DEFAULT_INSTANCE = verAff;
                GeneratedMessageLite.registerDefaultInstance(VerAff.class, verAff);
            }

            private VerAff() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearAff() {
                this.aff_ = getDefaultInstance().getAff();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearVersion() {
                this.version_ = 0;
            }

            public static VerAff getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.createBuilder();
            }

            public static VerAff parseDelimitedFrom(InputStream inputStream) throws IOException {
                return (VerAff) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static VerAff parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
                return (VerAff) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
            }

            public static Parser<VerAff> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setAff(String str) {
                str.getClass();
                this.aff_ = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setAffBytes(ByteString byteString) {
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.aff_ = byteString.toStringUtf8();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setVersion(int i10) {
                this.version_ = i10;
            }

            @Override // com.google.protobuf.GeneratedMessageLite
            public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                Parser defaultInstanceBasedParser;
                switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                    case 1:
                        return new VerAff();
                    case 2:
                        return new Builder();
                    case 3:
                        return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0004\u0002Ȉ", new Object[]{"version_", "aff_"});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        Parser<VerAff> parser = PARSER;
                        if (parser != null) {
                            return parser;
                        }
                        synchronized (VerAff.class) {
                            try {
                                defaultInstanceBasedParser = PARSER;
                                if (defaultInstanceBasedParser == null) {
                                    defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                                    PARSER = defaultInstanceBasedParser;
                                }
                            } catch (Throwable th2) {
                                throw th2;
                            }
                            break;
                        }
                        return defaultInstanceBasedParser;
                    case 6:
                        return (byte) 1;
                    case 7:
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }

            @Override // cu.todus.proto.ApiProto.CheckChannelsVersionResp.VerAffOrBuilder
            public String getAff() {
                return this.aff_;
            }

            @Override // cu.todus.proto.ApiProto.CheckChannelsVersionResp.VerAffOrBuilder
            public ByteString getAffBytes() {
                return ByteString.copyFromUtf8(this.aff_);
            }

            @Override // cu.todus.proto.ApiProto.CheckChannelsVersionResp.VerAffOrBuilder
            public int getVersion() {
                return this.version_;
            }

            public static Builder newBuilder(VerAff verAff) {
                return DEFAULT_INSTANCE.createBuilder(verAff);
            }

            public static VerAff parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (VerAff) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static VerAff parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (VerAff) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
            }

            public static VerAff parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                return (VerAff) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
            }

            public static VerAff parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (VerAff) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
            }

            public static VerAff parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                return (VerAff) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
            }

            public static VerAff parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (VerAff) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
            }

            public static VerAff parseFrom(InputStream inputStream) throws IOException {
                return (VerAff) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static VerAff parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (VerAff) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static VerAff parseFrom(CodedInputStream codedInputStream) throws IOException {
                return (VerAff) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
            }

            public static VerAff parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (VerAff) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        public static final class VerAffDefaultEntryHolder {
            static final MapEntryLite<String, VerAff> defaultEntry = MapEntryLite.newDefaultInstance(WireFormat.FieldType.STRING, "", WireFormat.FieldType.MESSAGE, VerAff.getDefaultInstance());

            private VerAffDefaultEntryHolder() {
            }
        }

        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        public interface VerAffOrBuilder extends MessageLiteOrBuilder {
            String getAff();

            ByteString getAffBytes();

            int getVersion();
        }

        static {
            CheckChannelsVersionResp checkChannelsVersionResp = new CheckChannelsVersionResp();
            DEFAULT_INSTANCE = checkChannelsVersionResp;
            GeneratedMessageLite.registerDefaultInstance(CheckChannelsVersionResp.class, checkChannelsVersionResp);
        }

        private CheckChannelsVersionResp() {
        }

        public static CheckChannelsVersionResp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Map<String, VerAff> getMutableVerAffMap() {
            return internalGetMutableVerAff();
        }

        private MapFieldLite<String, VerAff> internalGetMutableVerAff() {
            if (!this.verAff_.isMutable()) {
                this.verAff_ = this.verAff_.mutableCopy();
            }
            return this.verAff_;
        }

        private MapFieldLite<String, VerAff> internalGetVerAff() {
            return this.verAff_;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static CheckChannelsVersionResp parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (CheckChannelsVersionResp) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static CheckChannelsVersionResp parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (CheckChannelsVersionResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser<CheckChannelsVersionResp> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        @Override // cu.todus.proto.ApiProto.CheckChannelsVersionRespOrBuilder
        public boolean containsVerAff(String str) {
            str.getClass();
            return internalGetVerAff().containsKey(str);
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new CheckChannelsVersionResp();
                case 2:
                    return new Builder();
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u00012", new Object[]{"verAff_", VerAffDefaultEntryHolder.defaultEntry});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<CheckChannelsVersionResp> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (CheckChannelsVersionResp.class) {
                        try {
                            defaultInstanceBasedParser = PARSER;
                            if (defaultInstanceBasedParser == null) {
                                defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                                PARSER = defaultInstanceBasedParser;
                            }
                        } catch (Throwable th2) {
                            throw th2;
                        }
                        break;
                    }
                    return defaultInstanceBasedParser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        @Override // cu.todus.proto.ApiProto.CheckChannelsVersionRespOrBuilder
        @Deprecated
        public Map<String, VerAff> getVerAff() {
            return getVerAffMap();
        }

        @Override // cu.todus.proto.ApiProto.CheckChannelsVersionRespOrBuilder
        public int getVerAffCount() {
            return internalGetVerAff().size();
        }

        @Override // cu.todus.proto.ApiProto.CheckChannelsVersionRespOrBuilder
        public Map<String, VerAff> getVerAffMap() {
            return DesugarCollections.unmodifiableMap(internalGetVerAff());
        }

        @Override // cu.todus.proto.ApiProto.CheckChannelsVersionRespOrBuilder
        public VerAff getVerAffOrDefault(String str, VerAff verAff) {
            str.getClass();
            MapFieldLite<String, VerAff> mapFieldLiteInternalGetVerAff = internalGetVerAff();
            return mapFieldLiteInternalGetVerAff.containsKey(str) ? mapFieldLiteInternalGetVerAff.get(str) : verAff;
        }

        @Override // cu.todus.proto.ApiProto.CheckChannelsVersionRespOrBuilder
        public VerAff getVerAffOrThrow(String str) {
            str.getClass();
            MapFieldLite<String, VerAff> mapFieldLiteInternalGetVerAff = internalGetVerAff();
            if (mapFieldLiteInternalGetVerAff.containsKey(str)) {
                return mapFieldLiteInternalGetVerAff.get(str);
            }
            throw new IllegalArgumentException();
        }

        public static Builder newBuilder(CheckChannelsVersionResp checkChannelsVersionResp) {
            return DEFAULT_INSTANCE.createBuilder(checkChannelsVersionResp);
        }

        public static CheckChannelsVersionResp parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (CheckChannelsVersionResp) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static CheckChannelsVersionResp parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (CheckChannelsVersionResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static CheckChannelsVersionResp parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (CheckChannelsVersionResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static CheckChannelsVersionResp parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (CheckChannelsVersionResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static CheckChannelsVersionResp parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (CheckChannelsVersionResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static CheckChannelsVersionResp parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (CheckChannelsVersionResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static CheckChannelsVersionResp parseFrom(InputStream inputStream) throws IOException {
            return (CheckChannelsVersionResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static CheckChannelsVersionResp parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (CheckChannelsVersionResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static CheckChannelsVersionResp parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (CheckChannelsVersionResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static CheckChannelsVersionResp parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (CheckChannelsVersionResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    public interface CheckChannelsVersionRespOrBuilder extends MessageLiteOrBuilder {
        boolean containsVerAff(String str);

        @Deprecated
        Map<String, CheckChannelsVersionResp.VerAff> getVerAff();

        int getVerAffCount();

        Map<String, CheckChannelsVersionResp.VerAff> getVerAffMap();

        CheckChannelsVersionResp.VerAff getVerAffOrDefault(String str, CheckChannelsVersionResp.VerAff verAff);

        CheckChannelsVersionResp.VerAff getVerAffOrThrow(String str);
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    public static final class CreateChannelReq extends GeneratedMessageLite<CreateChannelReq, Builder> implements CreateChannelReqOrBuilder {
        public static final int CONFIG_FIELD_NUMBER = 1;
        private static final CreateChannelReq DEFAULT_INSTANCE;
        private static volatile Parser<CreateChannelReq> PARSER;
        private MapFieldLite<String, String> config_ = MapFieldLite.emptyMapField();

        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        public static final class Builder extends GeneratedMessageLite.Builder<CreateChannelReq, Builder> implements CreateChannelReqOrBuilder {
            public Builder clearConfig() {
                copyOnWrite();
                ((CreateChannelReq) this.instance).getMutableConfigMap().clear();
                return this;
            }

            @Override // cu.todus.proto.ApiProto.CreateChannelReqOrBuilder
            public boolean containsConfig(String str) {
                str.getClass();
                return ((CreateChannelReq) this.instance).getConfigMap().containsKey(str);
            }

            @Override // cu.todus.proto.ApiProto.CreateChannelReqOrBuilder
            @Deprecated
            public Map<String, String> getConfig() {
                return getConfigMap();
            }

            @Override // cu.todus.proto.ApiProto.CreateChannelReqOrBuilder
            public int getConfigCount() {
                return ((CreateChannelReq) this.instance).getConfigMap().size();
            }

            @Override // cu.todus.proto.ApiProto.CreateChannelReqOrBuilder
            public Map<String, String> getConfigMap() {
                return DesugarCollections.unmodifiableMap(((CreateChannelReq) this.instance).getConfigMap());
            }

            @Override // cu.todus.proto.ApiProto.CreateChannelReqOrBuilder
            public String getConfigOrDefault(String str, String str2) {
                str.getClass();
                Map<String, String> configMap = ((CreateChannelReq) this.instance).getConfigMap();
                return configMap.containsKey(str) ? configMap.get(str) : str2;
            }

            @Override // cu.todus.proto.ApiProto.CreateChannelReqOrBuilder
            public String getConfigOrThrow(String str) {
                str.getClass();
                Map<String, String> configMap = ((CreateChannelReq) this.instance).getConfigMap();
                if (configMap.containsKey(str)) {
                    return configMap.get(str);
                }
                throw new IllegalArgumentException();
            }

            public Builder putAllConfig(Map<String, String> map) {
                copyOnWrite();
                ((CreateChannelReq) this.instance).getMutableConfigMap().putAll(map);
                return this;
            }

            public Builder putConfig(String str, String str2) {
                str.getClass();
                str2.getClass();
                copyOnWrite();
                ((CreateChannelReq) this.instance).getMutableConfigMap().put(str, str2);
                return this;
            }

            public Builder removeConfig(String str) {
                str.getClass();
                copyOnWrite();
                ((CreateChannelReq) this.instance).getMutableConfigMap().remove(str);
                return this;
            }

            private Builder() {
                super(CreateChannelReq.DEFAULT_INSTANCE);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        public static final class ConfigDefaultEntryHolder {
            static final MapEntryLite<String, String> defaultEntry;

            static {
                WireFormat.FieldType fieldType = WireFormat.FieldType.STRING;
                defaultEntry = MapEntryLite.newDefaultInstance(fieldType, "", fieldType, "");
            }

            private ConfigDefaultEntryHolder() {
            }
        }

        static {
            CreateChannelReq createChannelReq = new CreateChannelReq();
            DEFAULT_INSTANCE = createChannelReq;
            GeneratedMessageLite.registerDefaultInstance(CreateChannelReq.class, createChannelReq);
        }

        private CreateChannelReq() {
        }

        public static CreateChannelReq getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Map<String, String> getMutableConfigMap() {
            return internalGetMutableConfig();
        }

        private MapFieldLite<String, String> internalGetConfig() {
            return this.config_;
        }

        private MapFieldLite<String, String> internalGetMutableConfig() {
            if (!this.config_.isMutable()) {
                this.config_ = this.config_.mutableCopy();
            }
            return this.config_;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static CreateChannelReq parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (CreateChannelReq) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static CreateChannelReq parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (CreateChannelReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser<CreateChannelReq> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        @Override // cu.todus.proto.ApiProto.CreateChannelReqOrBuilder
        public boolean containsConfig(String str) {
            str.getClass();
            return internalGetConfig().containsKey(str);
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new CreateChannelReq();
                case 2:
                    return new Builder();
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u00012", new Object[]{"config_", ConfigDefaultEntryHolder.defaultEntry});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<CreateChannelReq> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (CreateChannelReq.class) {
                        try {
                            defaultInstanceBasedParser = PARSER;
                            if (defaultInstanceBasedParser == null) {
                                defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                                PARSER = defaultInstanceBasedParser;
                            }
                        } catch (Throwable th2) {
                            throw th2;
                        }
                        break;
                    }
                    return defaultInstanceBasedParser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        @Override // cu.todus.proto.ApiProto.CreateChannelReqOrBuilder
        @Deprecated
        public Map<String, String> getConfig() {
            return getConfigMap();
        }

        @Override // cu.todus.proto.ApiProto.CreateChannelReqOrBuilder
        public int getConfigCount() {
            return internalGetConfig().size();
        }

        @Override // cu.todus.proto.ApiProto.CreateChannelReqOrBuilder
        public Map<String, String> getConfigMap() {
            return DesugarCollections.unmodifiableMap(internalGetConfig());
        }

        @Override // cu.todus.proto.ApiProto.CreateChannelReqOrBuilder
        public String getConfigOrDefault(String str, String str2) {
            str.getClass();
            MapFieldLite<String, String> mapFieldLiteInternalGetConfig = internalGetConfig();
            return mapFieldLiteInternalGetConfig.containsKey(str) ? mapFieldLiteInternalGetConfig.get(str) : str2;
        }

        @Override // cu.todus.proto.ApiProto.CreateChannelReqOrBuilder
        public String getConfigOrThrow(String str) {
            str.getClass();
            MapFieldLite<String, String> mapFieldLiteInternalGetConfig = internalGetConfig();
            if (mapFieldLiteInternalGetConfig.containsKey(str)) {
                return mapFieldLiteInternalGetConfig.get(str);
            }
            throw new IllegalArgumentException();
        }

        public static Builder newBuilder(CreateChannelReq createChannelReq) {
            return DEFAULT_INSTANCE.createBuilder(createChannelReq);
        }

        public static CreateChannelReq parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (CreateChannelReq) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static CreateChannelReq parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (CreateChannelReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static CreateChannelReq parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (CreateChannelReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static CreateChannelReq parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (CreateChannelReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static CreateChannelReq parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (CreateChannelReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static CreateChannelReq parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (CreateChannelReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static CreateChannelReq parseFrom(InputStream inputStream) throws IOException {
            return (CreateChannelReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static CreateChannelReq parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (CreateChannelReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static CreateChannelReq parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (CreateChannelReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static CreateChannelReq parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (CreateChannelReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    public interface CreateChannelReqOrBuilder extends MessageLiteOrBuilder {
        boolean containsConfig(String str);

        @Deprecated
        Map<String, String> getConfig();

        int getConfigCount();

        Map<String, String> getConfigMap();

        String getConfigOrDefault(String str, String str2);

        String getConfigOrThrow(String str);
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    public static final class CreateChannelResp extends GeneratedMessageLite<CreateChannelResp, Builder> implements CreateChannelRespOrBuilder {
        public static final int CHANNELUSERNAME_FIELD_NUMBER = 2;
        private static final CreateChannelResp DEFAULT_INSTANCE;
        public static final int MSG_FIELD_NUMBER = 1;
        private static volatile Parser<CreateChannelResp> PARSER;
        private String channelUsername_ = "";
        private int msg_;

        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        public static final class Builder extends GeneratedMessageLite.Builder<CreateChannelResp, Builder> implements CreateChannelRespOrBuilder {
            public Builder clearChannelUsername() {
                copyOnWrite();
                ((CreateChannelResp) this.instance).clearChannelUsername();
                return this;
            }

            public Builder clearMsg() {
                copyOnWrite();
                ((CreateChannelResp) this.instance).clearMsg();
                return this;
            }

            @Override // cu.todus.proto.ApiProto.CreateChannelRespOrBuilder
            public String getChannelUsername() {
                return ((CreateChannelResp) this.instance).getChannelUsername();
            }

            @Override // cu.todus.proto.ApiProto.CreateChannelRespOrBuilder
            public ByteString getChannelUsernameBytes() {
                return ((CreateChannelResp) this.instance).getChannelUsernameBytes();
            }

            @Override // cu.todus.proto.ApiProto.CreateChannelRespOrBuilder
            public MessageErrors getMsg() {
                return ((CreateChannelResp) this.instance).getMsg();
            }

            @Override // cu.todus.proto.ApiProto.CreateChannelRespOrBuilder
            public int getMsgValue() {
                return ((CreateChannelResp) this.instance).getMsgValue();
            }

            public Builder setChannelUsername(String str) {
                copyOnWrite();
                ((CreateChannelResp) this.instance).setChannelUsername(str);
                return this;
            }

            public Builder setChannelUsernameBytes(ByteString byteString) {
                copyOnWrite();
                ((CreateChannelResp) this.instance).setChannelUsernameBytes(byteString);
                return this;
            }

            public Builder setMsg(MessageErrors messageErrors) {
                copyOnWrite();
                ((CreateChannelResp) this.instance).setMsg(messageErrors);
                return this;
            }

            public Builder setMsgValue(int i10) {
                copyOnWrite();
                ((CreateChannelResp) this.instance).setMsgValue(i10);
                return this;
            }

            private Builder() {
                super(CreateChannelResp.DEFAULT_INSTANCE);
            }
        }

        static {
            CreateChannelResp createChannelResp = new CreateChannelResp();
            DEFAULT_INSTANCE = createChannelResp;
            GeneratedMessageLite.registerDefaultInstance(CreateChannelResp.class, createChannelResp);
        }

        private CreateChannelResp() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearChannelUsername() {
            this.channelUsername_ = getDefaultInstance().getChannelUsername();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearMsg() {
            this.msg_ = 0;
        }

        public static CreateChannelResp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static CreateChannelResp parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (CreateChannelResp) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static CreateChannelResp parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (CreateChannelResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser<CreateChannelResp> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setChannelUsername(String str) {
            str.getClass();
            this.channelUsername_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setChannelUsernameBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.channelUsername_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMsg(MessageErrors messageErrors) {
            this.msg_ = messageErrors.getNumber();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMsgValue(int i10) {
            this.msg_ = i10;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new CreateChannelResp();
                case 2:
                    return new Builder();
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0002Ȉ", new Object[]{"msg_", "channelUsername_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<CreateChannelResp> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (CreateChannelResp.class) {
                        try {
                            defaultInstanceBasedParser = PARSER;
                            if (defaultInstanceBasedParser == null) {
                                defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                                PARSER = defaultInstanceBasedParser;
                            }
                        } catch (Throwable th2) {
                            throw th2;
                        }
                        break;
                    }
                    return defaultInstanceBasedParser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        @Override // cu.todus.proto.ApiProto.CreateChannelRespOrBuilder
        public String getChannelUsername() {
            return this.channelUsername_;
        }

        @Override // cu.todus.proto.ApiProto.CreateChannelRespOrBuilder
        public ByteString getChannelUsernameBytes() {
            return ByteString.copyFromUtf8(this.channelUsername_);
        }

        @Override // cu.todus.proto.ApiProto.CreateChannelRespOrBuilder
        public MessageErrors getMsg() {
            MessageErrors messageErrorsForNumber = MessageErrors.forNumber(this.msg_);
            return messageErrorsForNumber == null ? MessageErrors.UNRECOGNIZED : messageErrorsForNumber;
        }

        @Override // cu.todus.proto.ApiProto.CreateChannelRespOrBuilder
        public int getMsgValue() {
            return this.msg_;
        }

        public static Builder newBuilder(CreateChannelResp createChannelResp) {
            return DEFAULT_INSTANCE.createBuilder(createChannelResp);
        }

        public static CreateChannelResp parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (CreateChannelResp) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static CreateChannelResp parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (CreateChannelResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static CreateChannelResp parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (CreateChannelResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static CreateChannelResp parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (CreateChannelResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static CreateChannelResp parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (CreateChannelResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static CreateChannelResp parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (CreateChannelResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static CreateChannelResp parseFrom(InputStream inputStream) throws IOException {
            return (CreateChannelResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static CreateChannelResp parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (CreateChannelResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static CreateChannelResp parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (CreateChannelResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static CreateChannelResp parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (CreateChannelResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    public interface CreateChannelRespOrBuilder extends MessageLiteOrBuilder {
        String getChannelUsername();

        ByteString getChannelUsernameBytes();

        MessageErrors getMsg();

        int getMsgValue();
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    public static final class DeleteChannelReq extends GeneratedMessageLite<DeleteChannelReq, Builder> implements DeleteChannelReqOrBuilder {
        public static final int CHANNEL_DOMAIN_FIELD_NUMBER = 2;
        public static final int CHANNEL_USERNAME_FIELD_NUMBER = 1;
        private static final DeleteChannelReq DEFAULT_INSTANCE;
        private static volatile Parser<DeleteChannelReq> PARSER;
        private String channelUsername_ = "";
        private String channelDomain_ = "";

        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        public static final class Builder extends GeneratedMessageLite.Builder<DeleteChannelReq, Builder> implements DeleteChannelReqOrBuilder {
            public Builder clearChannelDomain() {
                copyOnWrite();
                ((DeleteChannelReq) this.instance).clearChannelDomain();
                return this;
            }

            public Builder clearChannelUsername() {
                copyOnWrite();
                ((DeleteChannelReq) this.instance).clearChannelUsername();
                return this;
            }

            @Override // cu.todus.proto.ApiProto.DeleteChannelReqOrBuilder
            public String getChannelDomain() {
                return ((DeleteChannelReq) this.instance).getChannelDomain();
            }

            @Override // cu.todus.proto.ApiProto.DeleteChannelReqOrBuilder
            public ByteString getChannelDomainBytes() {
                return ((DeleteChannelReq) this.instance).getChannelDomainBytes();
            }

            @Override // cu.todus.proto.ApiProto.DeleteChannelReqOrBuilder
            public String getChannelUsername() {
                return ((DeleteChannelReq) this.instance).getChannelUsername();
            }

            @Override // cu.todus.proto.ApiProto.DeleteChannelReqOrBuilder
            public ByteString getChannelUsernameBytes() {
                return ((DeleteChannelReq) this.instance).getChannelUsernameBytes();
            }

            public Builder setChannelDomain(String str) {
                copyOnWrite();
                ((DeleteChannelReq) this.instance).setChannelDomain(str);
                return this;
            }

            public Builder setChannelDomainBytes(ByteString byteString) {
                copyOnWrite();
                ((DeleteChannelReq) this.instance).setChannelDomainBytes(byteString);
                return this;
            }

            public Builder setChannelUsername(String str) {
                copyOnWrite();
                ((DeleteChannelReq) this.instance).setChannelUsername(str);
                return this;
            }

            public Builder setChannelUsernameBytes(ByteString byteString) {
                copyOnWrite();
                ((DeleteChannelReq) this.instance).setChannelUsernameBytes(byteString);
                return this;
            }

            private Builder() {
                super(DeleteChannelReq.DEFAULT_INSTANCE);
            }
        }

        static {
            DeleteChannelReq deleteChannelReq = new DeleteChannelReq();
            DEFAULT_INSTANCE = deleteChannelReq;
            GeneratedMessageLite.registerDefaultInstance(DeleteChannelReq.class, deleteChannelReq);
        }

        private DeleteChannelReq() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearChannelDomain() {
            this.channelDomain_ = getDefaultInstance().getChannelDomain();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearChannelUsername() {
            this.channelUsername_ = getDefaultInstance().getChannelUsername();
        }

        public static DeleteChannelReq getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static DeleteChannelReq parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (DeleteChannelReq) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static DeleteChannelReq parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (DeleteChannelReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser<DeleteChannelReq> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setChannelDomain(String str) {
            str.getClass();
            this.channelDomain_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setChannelDomainBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.channelDomain_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setChannelUsername(String str) {
            str.getClass();
            this.channelUsername_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setChannelUsernameBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.channelUsername_ = byteString.toStringUtf8();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new DeleteChannelReq();
                case 2:
                    return new Builder();
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ", new Object[]{"channelUsername_", "channelDomain_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<DeleteChannelReq> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (DeleteChannelReq.class) {
                        try {
                            defaultInstanceBasedParser = PARSER;
                            if (defaultInstanceBasedParser == null) {
                                defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                                PARSER = defaultInstanceBasedParser;
                            }
                        } catch (Throwable th2) {
                            throw th2;
                        }
                        break;
                    }
                    return defaultInstanceBasedParser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        @Override // cu.todus.proto.ApiProto.DeleteChannelReqOrBuilder
        public String getChannelDomain() {
            return this.channelDomain_;
        }

        @Override // cu.todus.proto.ApiProto.DeleteChannelReqOrBuilder
        public ByteString getChannelDomainBytes() {
            return ByteString.copyFromUtf8(this.channelDomain_);
        }

        @Override // cu.todus.proto.ApiProto.DeleteChannelReqOrBuilder
        public String getChannelUsername() {
            return this.channelUsername_;
        }

        @Override // cu.todus.proto.ApiProto.DeleteChannelReqOrBuilder
        public ByteString getChannelUsernameBytes() {
            return ByteString.copyFromUtf8(this.channelUsername_);
        }

        public static Builder newBuilder(DeleteChannelReq deleteChannelReq) {
            return DEFAULT_INSTANCE.createBuilder(deleteChannelReq);
        }

        public static DeleteChannelReq parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (DeleteChannelReq) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static DeleteChannelReq parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (DeleteChannelReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static DeleteChannelReq parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (DeleteChannelReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static DeleteChannelReq parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (DeleteChannelReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static DeleteChannelReq parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (DeleteChannelReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static DeleteChannelReq parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (DeleteChannelReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static DeleteChannelReq parseFrom(InputStream inputStream) throws IOException {
            return (DeleteChannelReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static DeleteChannelReq parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (DeleteChannelReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static DeleteChannelReq parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (DeleteChannelReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static DeleteChannelReq parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (DeleteChannelReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    public interface DeleteChannelReqOrBuilder extends MessageLiteOrBuilder {
        String getChannelDomain();

        ByteString getChannelDomainBytes();

        String getChannelUsername();

        ByteString getChannelUsernameBytes();
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    public static final class DeleteChannelResp extends GeneratedMessageLite<DeleteChannelResp, Builder> implements DeleteChannelRespOrBuilder {
        private static final DeleteChannelResp DEFAULT_INSTANCE;
        public static final int MSG_FIELD_NUMBER = 1;
        private static volatile Parser<DeleteChannelResp> PARSER;
        private int msg_;

        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        public static final class Builder extends GeneratedMessageLite.Builder<DeleteChannelResp, Builder> implements DeleteChannelRespOrBuilder {
            public Builder clearMsg() {
                copyOnWrite();
                ((DeleteChannelResp) this.instance).clearMsg();
                return this;
            }

            @Override // cu.todus.proto.ApiProto.DeleteChannelRespOrBuilder
            public MessageErrors getMsg() {
                return ((DeleteChannelResp) this.instance).getMsg();
            }

            @Override // cu.todus.proto.ApiProto.DeleteChannelRespOrBuilder
            public int getMsgValue() {
                return ((DeleteChannelResp) this.instance).getMsgValue();
            }

            public Builder setMsg(MessageErrors messageErrors) {
                copyOnWrite();
                ((DeleteChannelResp) this.instance).setMsg(messageErrors);
                return this;
            }

            public Builder setMsgValue(int i10) {
                copyOnWrite();
                ((DeleteChannelResp) this.instance).setMsgValue(i10);
                return this;
            }

            private Builder() {
                super(DeleteChannelResp.DEFAULT_INSTANCE);
            }
        }

        static {
            DeleteChannelResp deleteChannelResp = new DeleteChannelResp();
            DEFAULT_INSTANCE = deleteChannelResp;
            GeneratedMessageLite.registerDefaultInstance(DeleteChannelResp.class, deleteChannelResp);
        }

        private DeleteChannelResp() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearMsg() {
            this.msg_ = 0;
        }

        public static DeleteChannelResp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static DeleteChannelResp parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (DeleteChannelResp) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static DeleteChannelResp parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (DeleteChannelResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser<DeleteChannelResp> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMsg(MessageErrors messageErrors) {
            this.msg_ = messageErrors.getNumber();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMsgValue(int i10) {
            this.msg_ = i10;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new DeleteChannelResp();
                case 2:
                    return new Builder();
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\f", new Object[]{"msg_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<DeleteChannelResp> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (DeleteChannelResp.class) {
                        try {
                            defaultInstanceBasedParser = PARSER;
                            if (defaultInstanceBasedParser == null) {
                                defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                                PARSER = defaultInstanceBasedParser;
                            }
                        } catch (Throwable th2) {
                            throw th2;
                        }
                        break;
                    }
                    return defaultInstanceBasedParser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        @Override // cu.todus.proto.ApiProto.DeleteChannelRespOrBuilder
        public MessageErrors getMsg() {
            MessageErrors messageErrorsForNumber = MessageErrors.forNumber(this.msg_);
            return messageErrorsForNumber == null ? MessageErrors.UNRECOGNIZED : messageErrorsForNumber;
        }

        @Override // cu.todus.proto.ApiProto.DeleteChannelRespOrBuilder
        public int getMsgValue() {
            return this.msg_;
        }

        public static Builder newBuilder(DeleteChannelResp deleteChannelResp) {
            return DEFAULT_INSTANCE.createBuilder(deleteChannelResp);
        }

        public static DeleteChannelResp parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (DeleteChannelResp) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static DeleteChannelResp parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (DeleteChannelResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static DeleteChannelResp parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (DeleteChannelResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static DeleteChannelResp parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (DeleteChannelResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static DeleteChannelResp parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (DeleteChannelResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static DeleteChannelResp parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (DeleteChannelResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static DeleteChannelResp parseFrom(InputStream inputStream) throws IOException {
            return (DeleteChannelResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static DeleteChannelResp parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (DeleteChannelResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static DeleteChannelResp parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (DeleteChannelResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static DeleteChannelResp parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (DeleteChannelResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    public interface DeleteChannelRespOrBuilder extends MessageLiteOrBuilder {
        MessageErrors getMsg();

        int getMsgValue();
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    public static final class EditConfigChannelReq extends GeneratedMessageLite<EditConfigChannelReq, Builder> implements EditConfigChannelReqOrBuilder {
        public static final int CHANNEL_USERNAME_FIELD_NUMBER = 1;
        private static final EditConfigChannelReq DEFAULT_INSTANCE;
        public static final int NEW_CONFIG_FIELD_NUMBER = 3;
        private static volatile Parser<EditConfigChannelReq> PARSER = null;
        public static final int USER_DOMAIN_FIELD_NUMBER = 2;
        private MapFieldLite<String, String> newConfig_ = MapFieldLite.emptyMapField();
        private String channelUsername_ = "";
        private String userDomain_ = "";

        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        public static final class Builder extends GeneratedMessageLite.Builder<EditConfigChannelReq, Builder> implements EditConfigChannelReqOrBuilder {
            public Builder clearChannelUsername() {
                copyOnWrite();
                ((EditConfigChannelReq) this.instance).clearChannelUsername();
                return this;
            }

            public Builder clearNewConfig() {
                copyOnWrite();
                ((EditConfigChannelReq) this.instance).getMutableNewConfigMap().clear();
                return this;
            }

            public Builder clearUserDomain() {
                copyOnWrite();
                ((EditConfigChannelReq) this.instance).clearUserDomain();
                return this;
            }

            @Override // cu.todus.proto.ApiProto.EditConfigChannelReqOrBuilder
            public boolean containsNewConfig(String str) {
                str.getClass();
                return ((EditConfigChannelReq) this.instance).getNewConfigMap().containsKey(str);
            }

            @Override // cu.todus.proto.ApiProto.EditConfigChannelReqOrBuilder
            public String getChannelUsername() {
                return ((EditConfigChannelReq) this.instance).getChannelUsername();
            }

            @Override // cu.todus.proto.ApiProto.EditConfigChannelReqOrBuilder
            public ByteString getChannelUsernameBytes() {
                return ((EditConfigChannelReq) this.instance).getChannelUsernameBytes();
            }

            @Override // cu.todus.proto.ApiProto.EditConfigChannelReqOrBuilder
            @Deprecated
            public Map<String, String> getNewConfig() {
                return getNewConfigMap();
            }

            @Override // cu.todus.proto.ApiProto.EditConfigChannelReqOrBuilder
            public int getNewConfigCount() {
                return ((EditConfigChannelReq) this.instance).getNewConfigMap().size();
            }

            @Override // cu.todus.proto.ApiProto.EditConfigChannelReqOrBuilder
            public Map<String, String> getNewConfigMap() {
                return DesugarCollections.unmodifiableMap(((EditConfigChannelReq) this.instance).getNewConfigMap());
            }

            @Override // cu.todus.proto.ApiProto.EditConfigChannelReqOrBuilder
            public String getNewConfigOrDefault(String str, String str2) {
                str.getClass();
                Map<String, String> newConfigMap = ((EditConfigChannelReq) this.instance).getNewConfigMap();
                return newConfigMap.containsKey(str) ? newConfigMap.get(str) : str2;
            }

            @Override // cu.todus.proto.ApiProto.EditConfigChannelReqOrBuilder
            public String getNewConfigOrThrow(String str) {
                str.getClass();
                Map<String, String> newConfigMap = ((EditConfigChannelReq) this.instance).getNewConfigMap();
                if (newConfigMap.containsKey(str)) {
                    return newConfigMap.get(str);
                }
                throw new IllegalArgumentException();
            }

            @Override // cu.todus.proto.ApiProto.EditConfigChannelReqOrBuilder
            public String getUserDomain() {
                return ((EditConfigChannelReq) this.instance).getUserDomain();
            }

            @Override // cu.todus.proto.ApiProto.EditConfigChannelReqOrBuilder
            public ByteString getUserDomainBytes() {
                return ((EditConfigChannelReq) this.instance).getUserDomainBytes();
            }

            public Builder putAllNewConfig(Map<String, String> map) {
                copyOnWrite();
                ((EditConfigChannelReq) this.instance).getMutableNewConfigMap().putAll(map);
                return this;
            }

            public Builder putNewConfig(String str, String str2) {
                str.getClass();
                str2.getClass();
                copyOnWrite();
                ((EditConfigChannelReq) this.instance).getMutableNewConfigMap().put(str, str2);
                return this;
            }

            public Builder removeNewConfig(String str) {
                str.getClass();
                copyOnWrite();
                ((EditConfigChannelReq) this.instance).getMutableNewConfigMap().remove(str);
                return this;
            }

            public Builder setChannelUsername(String str) {
                copyOnWrite();
                ((EditConfigChannelReq) this.instance).setChannelUsername(str);
                return this;
            }

            public Builder setChannelUsernameBytes(ByteString byteString) {
                copyOnWrite();
                ((EditConfigChannelReq) this.instance).setChannelUsernameBytes(byteString);
                return this;
            }

            public Builder setUserDomain(String str) {
                copyOnWrite();
                ((EditConfigChannelReq) this.instance).setUserDomain(str);
                return this;
            }

            public Builder setUserDomainBytes(ByteString byteString) {
                copyOnWrite();
                ((EditConfigChannelReq) this.instance).setUserDomainBytes(byteString);
                return this;
            }

            private Builder() {
                super(EditConfigChannelReq.DEFAULT_INSTANCE);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        public static final class NewConfigDefaultEntryHolder {
            static final MapEntryLite<String, String> defaultEntry;

            static {
                WireFormat.FieldType fieldType = WireFormat.FieldType.STRING;
                defaultEntry = MapEntryLite.newDefaultInstance(fieldType, "", fieldType, "");
            }

            private NewConfigDefaultEntryHolder() {
            }
        }

        static {
            EditConfigChannelReq editConfigChannelReq = new EditConfigChannelReq();
            DEFAULT_INSTANCE = editConfigChannelReq;
            GeneratedMessageLite.registerDefaultInstance(EditConfigChannelReq.class, editConfigChannelReq);
        }

        private EditConfigChannelReq() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearChannelUsername() {
            this.channelUsername_ = getDefaultInstance().getChannelUsername();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearUserDomain() {
            this.userDomain_ = getDefaultInstance().getUserDomain();
        }

        public static EditConfigChannelReq getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Map<String, String> getMutableNewConfigMap() {
            return internalGetMutableNewConfig();
        }

        private MapFieldLite<String, String> internalGetMutableNewConfig() {
            if (!this.newConfig_.isMutable()) {
                this.newConfig_ = this.newConfig_.mutableCopy();
            }
            return this.newConfig_;
        }

        private MapFieldLite<String, String> internalGetNewConfig() {
            return this.newConfig_;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static EditConfigChannelReq parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (EditConfigChannelReq) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static EditConfigChannelReq parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (EditConfigChannelReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser<EditConfigChannelReq> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setChannelUsername(String str) {
            str.getClass();
            this.channelUsername_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setChannelUsernameBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.channelUsername_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUserDomain(String str) {
            str.getClass();
            this.userDomain_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUserDomainBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.userDomain_ = byteString.toStringUtf8();
        }

        @Override // cu.todus.proto.ApiProto.EditConfigChannelReqOrBuilder
        public boolean containsNewConfig(String str) {
            str.getClass();
            return internalGetNewConfig().containsKey(str);
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new EditConfigChannelReq();
                case 2:
                    return new Builder();
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0001\u0000\u0000\u0001Ȉ\u0002Ȉ\u00032", new Object[]{"channelUsername_", "userDomain_", "newConfig_", NewConfigDefaultEntryHolder.defaultEntry});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<EditConfigChannelReq> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (EditConfigChannelReq.class) {
                        try {
                            defaultInstanceBasedParser = PARSER;
                            if (defaultInstanceBasedParser == null) {
                                defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                                PARSER = defaultInstanceBasedParser;
                            }
                        } catch (Throwable th2) {
                            throw th2;
                        }
                        break;
                    }
                    return defaultInstanceBasedParser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        @Override // cu.todus.proto.ApiProto.EditConfigChannelReqOrBuilder
        public String getChannelUsername() {
            return this.channelUsername_;
        }

        @Override // cu.todus.proto.ApiProto.EditConfigChannelReqOrBuilder
        public ByteString getChannelUsernameBytes() {
            return ByteString.copyFromUtf8(this.channelUsername_);
        }

        @Override // cu.todus.proto.ApiProto.EditConfigChannelReqOrBuilder
        @Deprecated
        public Map<String, String> getNewConfig() {
            return getNewConfigMap();
        }

        @Override // cu.todus.proto.ApiProto.EditConfigChannelReqOrBuilder
        public int getNewConfigCount() {
            return internalGetNewConfig().size();
        }

        @Override // cu.todus.proto.ApiProto.EditConfigChannelReqOrBuilder
        public Map<String, String> getNewConfigMap() {
            return DesugarCollections.unmodifiableMap(internalGetNewConfig());
        }

        @Override // cu.todus.proto.ApiProto.EditConfigChannelReqOrBuilder
        public String getNewConfigOrDefault(String str, String str2) {
            str.getClass();
            MapFieldLite<String, String> mapFieldLiteInternalGetNewConfig = internalGetNewConfig();
            return mapFieldLiteInternalGetNewConfig.containsKey(str) ? mapFieldLiteInternalGetNewConfig.get(str) : str2;
        }

        @Override // cu.todus.proto.ApiProto.EditConfigChannelReqOrBuilder
        public String getNewConfigOrThrow(String str) {
            str.getClass();
            MapFieldLite<String, String> mapFieldLiteInternalGetNewConfig = internalGetNewConfig();
            if (mapFieldLiteInternalGetNewConfig.containsKey(str)) {
                return mapFieldLiteInternalGetNewConfig.get(str);
            }
            throw new IllegalArgumentException();
        }

        @Override // cu.todus.proto.ApiProto.EditConfigChannelReqOrBuilder
        public String getUserDomain() {
            return this.userDomain_;
        }

        @Override // cu.todus.proto.ApiProto.EditConfigChannelReqOrBuilder
        public ByteString getUserDomainBytes() {
            return ByteString.copyFromUtf8(this.userDomain_);
        }

        public static Builder newBuilder(EditConfigChannelReq editConfigChannelReq) {
            return DEFAULT_INSTANCE.createBuilder(editConfigChannelReq);
        }

        public static EditConfigChannelReq parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (EditConfigChannelReq) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static EditConfigChannelReq parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (EditConfigChannelReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static EditConfigChannelReq parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (EditConfigChannelReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static EditConfigChannelReq parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (EditConfigChannelReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static EditConfigChannelReq parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (EditConfigChannelReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static EditConfigChannelReq parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (EditConfigChannelReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static EditConfigChannelReq parseFrom(InputStream inputStream) throws IOException {
            return (EditConfigChannelReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static EditConfigChannelReq parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (EditConfigChannelReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static EditConfigChannelReq parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (EditConfigChannelReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static EditConfigChannelReq parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (EditConfigChannelReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    public interface EditConfigChannelReqOrBuilder extends MessageLiteOrBuilder {
        boolean containsNewConfig(String str);

        String getChannelUsername();

        ByteString getChannelUsernameBytes();

        @Deprecated
        Map<String, String> getNewConfig();

        int getNewConfigCount();

        Map<String, String> getNewConfigMap();

        String getNewConfigOrDefault(String str, String str2);

        String getNewConfigOrThrow(String str);

        String getUserDomain();

        ByteString getUserDomainBytes();
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    public static final class GetInfoChannelResp extends GeneratedMessageLite<GetInfoChannelResp, Builder> implements GetInfoChannelRespOrBuilder {
        public static final int AFF_COUNT_FIELD_NUMBER = 6;
        public static final int CONFIG_FIELD_NUMBER = 1;
        public static final int CREATE_DATE_FIELD_NUMBER = 5;
        public static final int CREATOR_FIELD_NUMBER = 4;
        private static final GetInfoChannelResp DEFAULT_INSTANCE;
        public static final int OFFICIAL_FIELD_NUMBER = 3;
        private static volatile Parser<GetInfoChannelResp> PARSER = null;
        public static final int VERSION_FIELD_NUMBER = 2;
        private long affCount_;
        private long createDate_;
        private boolean official_;
        private int version_;
        private MapFieldLite<String, String> config_ = MapFieldLite.emptyMapField();
        private String creator_ = "";

        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        public static final class Builder extends GeneratedMessageLite.Builder<GetInfoChannelResp, Builder> implements GetInfoChannelRespOrBuilder {
            public Builder clearAffCount() {
                copyOnWrite();
                ((GetInfoChannelResp) this.instance).clearAffCount();
                return this;
            }

            public Builder clearConfig() {
                copyOnWrite();
                ((GetInfoChannelResp) this.instance).getMutableConfigMap().clear();
                return this;
            }

            public Builder clearCreateDate() {
                copyOnWrite();
                ((GetInfoChannelResp) this.instance).clearCreateDate();
                return this;
            }

            public Builder clearCreator() {
                copyOnWrite();
                ((GetInfoChannelResp) this.instance).clearCreator();
                return this;
            }

            public Builder clearOfficial() {
                copyOnWrite();
                ((GetInfoChannelResp) this.instance).clearOfficial();
                return this;
            }

            public Builder clearVersion() {
                copyOnWrite();
                ((GetInfoChannelResp) this.instance).clearVersion();
                return this;
            }

            @Override // cu.todus.proto.ApiProto.GetInfoChannelRespOrBuilder
            public boolean containsConfig(String str) {
                str.getClass();
                return ((GetInfoChannelResp) this.instance).getConfigMap().containsKey(str);
            }

            @Override // cu.todus.proto.ApiProto.GetInfoChannelRespOrBuilder
            public long getAffCount() {
                return ((GetInfoChannelResp) this.instance).getAffCount();
            }

            @Override // cu.todus.proto.ApiProto.GetInfoChannelRespOrBuilder
            @Deprecated
            public Map<String, String> getConfig() {
                return getConfigMap();
            }

            @Override // cu.todus.proto.ApiProto.GetInfoChannelRespOrBuilder
            public int getConfigCount() {
                return ((GetInfoChannelResp) this.instance).getConfigMap().size();
            }

            @Override // cu.todus.proto.ApiProto.GetInfoChannelRespOrBuilder
            public Map<String, String> getConfigMap() {
                return DesugarCollections.unmodifiableMap(((GetInfoChannelResp) this.instance).getConfigMap());
            }

            @Override // cu.todus.proto.ApiProto.GetInfoChannelRespOrBuilder
            public String getConfigOrDefault(String str, String str2) {
                str.getClass();
                Map<String, String> configMap = ((GetInfoChannelResp) this.instance).getConfigMap();
                return configMap.containsKey(str) ? configMap.get(str) : str2;
            }

            @Override // cu.todus.proto.ApiProto.GetInfoChannelRespOrBuilder
            public String getConfigOrThrow(String str) {
                str.getClass();
                Map<String, String> configMap = ((GetInfoChannelResp) this.instance).getConfigMap();
                if (configMap.containsKey(str)) {
                    return configMap.get(str);
                }
                throw new IllegalArgumentException();
            }

            @Override // cu.todus.proto.ApiProto.GetInfoChannelRespOrBuilder
            public long getCreateDate() {
                return ((GetInfoChannelResp) this.instance).getCreateDate();
            }

            @Override // cu.todus.proto.ApiProto.GetInfoChannelRespOrBuilder
            public String getCreator() {
                return ((GetInfoChannelResp) this.instance).getCreator();
            }

            @Override // cu.todus.proto.ApiProto.GetInfoChannelRespOrBuilder
            public ByteString getCreatorBytes() {
                return ((GetInfoChannelResp) this.instance).getCreatorBytes();
            }

            @Override // cu.todus.proto.ApiProto.GetInfoChannelRespOrBuilder
            public boolean getOfficial() {
                return ((GetInfoChannelResp) this.instance).getOfficial();
            }

            @Override // cu.todus.proto.ApiProto.GetInfoChannelRespOrBuilder
            public int getVersion() {
                return ((GetInfoChannelResp) this.instance).getVersion();
            }

            public Builder putAllConfig(Map<String, String> map) {
                copyOnWrite();
                ((GetInfoChannelResp) this.instance).getMutableConfigMap().putAll(map);
                return this;
            }

            public Builder putConfig(String str, String str2) {
                str.getClass();
                str2.getClass();
                copyOnWrite();
                ((GetInfoChannelResp) this.instance).getMutableConfigMap().put(str, str2);
                return this;
            }

            public Builder removeConfig(String str) {
                str.getClass();
                copyOnWrite();
                ((GetInfoChannelResp) this.instance).getMutableConfigMap().remove(str);
                return this;
            }

            public Builder setAffCount(long j10) {
                copyOnWrite();
                ((GetInfoChannelResp) this.instance).setAffCount(j10);
                return this;
            }

            public Builder setCreateDate(long j10) {
                copyOnWrite();
                ((GetInfoChannelResp) this.instance).setCreateDate(j10);
                return this;
            }

            public Builder setCreator(String str) {
                copyOnWrite();
                ((GetInfoChannelResp) this.instance).setCreator(str);
                return this;
            }

            public Builder setCreatorBytes(ByteString byteString) {
                copyOnWrite();
                ((GetInfoChannelResp) this.instance).setCreatorBytes(byteString);
                return this;
            }

            public Builder setOfficial(boolean z10) {
                copyOnWrite();
                ((GetInfoChannelResp) this.instance).setOfficial(z10);
                return this;
            }

            public Builder setVersion(int i10) {
                copyOnWrite();
                ((GetInfoChannelResp) this.instance).setVersion(i10);
                return this;
            }

            private Builder() {
                super(GetInfoChannelResp.DEFAULT_INSTANCE);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        public static final class ConfigDefaultEntryHolder {
            static final MapEntryLite<String, String> defaultEntry;

            static {
                WireFormat.FieldType fieldType = WireFormat.FieldType.STRING;
                defaultEntry = MapEntryLite.newDefaultInstance(fieldType, "", fieldType, "");
            }

            private ConfigDefaultEntryHolder() {
            }
        }

        static {
            GetInfoChannelResp getInfoChannelResp = new GetInfoChannelResp();
            DEFAULT_INSTANCE = getInfoChannelResp;
            GeneratedMessageLite.registerDefaultInstance(GetInfoChannelResp.class, getInfoChannelResp);
        }

        private GetInfoChannelResp() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearAffCount() {
            this.affCount_ = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearCreateDate() {
            this.createDate_ = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearCreator() {
            this.creator_ = getDefaultInstance().getCreator();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearOfficial() {
            this.official_ = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearVersion() {
            this.version_ = 0;
        }

        public static GetInfoChannelResp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Map<String, String> getMutableConfigMap() {
            return internalGetMutableConfig();
        }

        private MapFieldLite<String, String> internalGetConfig() {
            return this.config_;
        }

        private MapFieldLite<String, String> internalGetMutableConfig() {
            if (!this.config_.isMutable()) {
                this.config_ = this.config_.mutableCopy();
            }
            return this.config_;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static GetInfoChannelResp parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (GetInfoChannelResp) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static GetInfoChannelResp parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (GetInfoChannelResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser<GetInfoChannelResp> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAffCount(long j10) {
            this.affCount_ = j10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCreateDate(long j10) {
            this.createDate_ = j10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCreator(String str) {
            str.getClass();
            this.creator_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCreatorBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.creator_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setOfficial(boolean z10) {
            this.official_ = z10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setVersion(int i10) {
            this.version_ = i10;
        }

        @Override // cu.todus.proto.ApiProto.GetInfoChannelRespOrBuilder
        public boolean containsConfig(String str) {
            str.getClass();
            return internalGetConfig().containsKey(str);
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new GetInfoChannelResp();
                case 2:
                    return new Builder();
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0006\u0000\u0000\u0001\u0006\u0006\u0001\u0000\u0000\u00012\u0002\u0004\u0003\u0007\u0004Ȉ\u0005\u0002\u0006\u0002", new Object[]{"config_", ConfigDefaultEntryHolder.defaultEntry, "version_", "official_", "creator_", "createDate_", "affCount_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<GetInfoChannelResp> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (GetInfoChannelResp.class) {
                        try {
                            defaultInstanceBasedParser = PARSER;
                            if (defaultInstanceBasedParser == null) {
                                defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                                PARSER = defaultInstanceBasedParser;
                            }
                        } catch (Throwable th2) {
                            throw th2;
                        }
                        break;
                    }
                    return defaultInstanceBasedParser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        @Override // cu.todus.proto.ApiProto.GetInfoChannelRespOrBuilder
        public long getAffCount() {
            return this.affCount_;
        }

        @Override // cu.todus.proto.ApiProto.GetInfoChannelRespOrBuilder
        @Deprecated
        public Map<String, String> getConfig() {
            return getConfigMap();
        }

        @Override // cu.todus.proto.ApiProto.GetInfoChannelRespOrBuilder
        public int getConfigCount() {
            return internalGetConfig().size();
        }

        @Override // cu.todus.proto.ApiProto.GetInfoChannelRespOrBuilder
        public Map<String, String> getConfigMap() {
            return DesugarCollections.unmodifiableMap(internalGetConfig());
        }

        @Override // cu.todus.proto.ApiProto.GetInfoChannelRespOrBuilder
        public String getConfigOrDefault(String str, String str2) {
            str.getClass();
            MapFieldLite<String, String> mapFieldLiteInternalGetConfig = internalGetConfig();
            return mapFieldLiteInternalGetConfig.containsKey(str) ? mapFieldLiteInternalGetConfig.get(str) : str2;
        }

        @Override // cu.todus.proto.ApiProto.GetInfoChannelRespOrBuilder
        public String getConfigOrThrow(String str) {
            str.getClass();
            MapFieldLite<String, String> mapFieldLiteInternalGetConfig = internalGetConfig();
            if (mapFieldLiteInternalGetConfig.containsKey(str)) {
                return mapFieldLiteInternalGetConfig.get(str);
            }
            throw new IllegalArgumentException();
        }

        @Override // cu.todus.proto.ApiProto.GetInfoChannelRespOrBuilder
        public long getCreateDate() {
            return this.createDate_;
        }

        @Override // cu.todus.proto.ApiProto.GetInfoChannelRespOrBuilder
        public String getCreator() {
            return this.creator_;
        }

        @Override // cu.todus.proto.ApiProto.GetInfoChannelRespOrBuilder
        public ByteString getCreatorBytes() {
            return ByteString.copyFromUtf8(this.creator_);
        }

        @Override // cu.todus.proto.ApiProto.GetInfoChannelRespOrBuilder
        public boolean getOfficial() {
            return this.official_;
        }

        @Override // cu.todus.proto.ApiProto.GetInfoChannelRespOrBuilder
        public int getVersion() {
            return this.version_;
        }

        public static Builder newBuilder(GetInfoChannelResp getInfoChannelResp) {
            return DEFAULT_INSTANCE.createBuilder(getInfoChannelResp);
        }

        public static GetInfoChannelResp parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (GetInfoChannelResp) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static GetInfoChannelResp parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (GetInfoChannelResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static GetInfoChannelResp parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (GetInfoChannelResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static GetInfoChannelResp parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (GetInfoChannelResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static GetInfoChannelResp parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (GetInfoChannelResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static GetInfoChannelResp parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (GetInfoChannelResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static GetInfoChannelResp parseFrom(InputStream inputStream) throws IOException {
            return (GetInfoChannelResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static GetInfoChannelResp parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (GetInfoChannelResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static GetInfoChannelResp parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (GetInfoChannelResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static GetInfoChannelResp parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (GetInfoChannelResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    public interface GetInfoChannelRespOrBuilder extends MessageLiteOrBuilder {
        boolean containsConfig(String str);

        long getAffCount();

        @Deprecated
        Map<String, String> getConfig();

        int getConfigCount();

        Map<String, String> getConfigMap();

        String getConfigOrDefault(String str, String str2);

        String getConfigOrThrow(String str);

        long getCreateDate();

        String getCreator();

        ByteString getCreatorBytes();

        boolean getOfficial();

        int getVersion();
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    public static final class GetPackInfoResp extends GeneratedMessageLite<GetPackInfoResp, Builder> implements GetPackInfoRespOrBuilder {
        public static final int ANIMATED_FIELD_NUMBER = 5;
        public static final int COUNT_FIELD_NUMBER = 6;
        public static final int CREATED_AT_FIELD_NUMBER = 4;
        private static final GetPackInfoResp DEFAULT_INSTANCE;
        public static final int NAME_FIELD_NUMBER = 2;
        private static volatile Parser<GetPackInfoResp> PARSER = null;
        public static final int THUMB_FIELD_NUMBER = 3;
        public static final int TITLE_FIELD_NUMBER = 1;
        private boolean animated_;
        private long count_;
        private long createdAt_;
        private String title_ = "";
        private String name_ = "";
        private String thumb_ = "";

        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        public static final class Builder extends GeneratedMessageLite.Builder<GetPackInfoResp, Builder> implements GetPackInfoRespOrBuilder {
            public Builder clearAnimated() {
                copyOnWrite();
                ((GetPackInfoResp) this.instance).clearAnimated();
                return this;
            }

            public Builder clearCount() {
                copyOnWrite();
                ((GetPackInfoResp) this.instance).clearCount();
                return this;
            }

            public Builder clearCreatedAt() {
                copyOnWrite();
                ((GetPackInfoResp) this.instance).clearCreatedAt();
                return this;
            }

            public Builder clearName() {
                copyOnWrite();
                ((GetPackInfoResp) this.instance).clearName();
                return this;
            }

            public Builder clearThumb() {
                copyOnWrite();
                ((GetPackInfoResp) this.instance).clearThumb();
                return this;
            }

            public Builder clearTitle() {
                copyOnWrite();
                ((GetPackInfoResp) this.instance).clearTitle();
                return this;
            }

            @Override // cu.todus.proto.ApiProto.GetPackInfoRespOrBuilder
            public boolean getAnimated() {
                return ((GetPackInfoResp) this.instance).getAnimated();
            }

            @Override // cu.todus.proto.ApiProto.GetPackInfoRespOrBuilder
            public long getCount() {
                return ((GetPackInfoResp) this.instance).getCount();
            }

            @Override // cu.todus.proto.ApiProto.GetPackInfoRespOrBuilder
            public long getCreatedAt() {
                return ((GetPackInfoResp) this.instance).getCreatedAt();
            }

            @Override // cu.todus.proto.ApiProto.GetPackInfoRespOrBuilder
            public String getName() {
                return ((GetPackInfoResp) this.instance).getName();
            }

            @Override // cu.todus.proto.ApiProto.GetPackInfoRespOrBuilder
            public ByteString getNameBytes() {
                return ((GetPackInfoResp) this.instance).getNameBytes();
            }

            @Override // cu.todus.proto.ApiProto.GetPackInfoRespOrBuilder
            public String getThumb() {
                return ((GetPackInfoResp) this.instance).getThumb();
            }

            @Override // cu.todus.proto.ApiProto.GetPackInfoRespOrBuilder
            public ByteString getThumbBytes() {
                return ((GetPackInfoResp) this.instance).getThumbBytes();
            }

            @Override // cu.todus.proto.ApiProto.GetPackInfoRespOrBuilder
            public String getTitle() {
                return ((GetPackInfoResp) this.instance).getTitle();
            }

            @Override // cu.todus.proto.ApiProto.GetPackInfoRespOrBuilder
            public ByteString getTitleBytes() {
                return ((GetPackInfoResp) this.instance).getTitleBytes();
            }

            public Builder setAnimated(boolean z10) {
                copyOnWrite();
                ((GetPackInfoResp) this.instance).setAnimated(z10);
                return this;
            }

            public Builder setCount(long j10) {
                copyOnWrite();
                ((GetPackInfoResp) this.instance).setCount(j10);
                return this;
            }

            public Builder setCreatedAt(long j10) {
                copyOnWrite();
                ((GetPackInfoResp) this.instance).setCreatedAt(j10);
                return this;
            }

            public Builder setName(String str) {
                copyOnWrite();
                ((GetPackInfoResp) this.instance).setName(str);
                return this;
            }

            public Builder setNameBytes(ByteString byteString) {
                copyOnWrite();
                ((GetPackInfoResp) this.instance).setNameBytes(byteString);
                return this;
            }

            public Builder setThumb(String str) {
                copyOnWrite();
                ((GetPackInfoResp) this.instance).setThumb(str);
                return this;
            }

            public Builder setThumbBytes(ByteString byteString) {
                copyOnWrite();
                ((GetPackInfoResp) this.instance).setThumbBytes(byteString);
                return this;
            }

            public Builder setTitle(String str) {
                copyOnWrite();
                ((GetPackInfoResp) this.instance).setTitle(str);
                return this;
            }

            public Builder setTitleBytes(ByteString byteString) {
                copyOnWrite();
                ((GetPackInfoResp) this.instance).setTitleBytes(byteString);
                return this;
            }

            private Builder() {
                super(GetPackInfoResp.DEFAULT_INSTANCE);
            }
        }

        static {
            GetPackInfoResp getPackInfoResp = new GetPackInfoResp();
            DEFAULT_INSTANCE = getPackInfoResp;
            GeneratedMessageLite.registerDefaultInstance(GetPackInfoResp.class, getPackInfoResp);
        }

        private GetPackInfoResp() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearAnimated() {
            this.animated_ = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearCount() {
            this.count_ = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearCreatedAt() {
            this.createdAt_ = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearName() {
            this.name_ = getDefaultInstance().getName();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearThumb() {
            this.thumb_ = getDefaultInstance().getThumb();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearTitle() {
            this.title_ = getDefaultInstance().getTitle();
        }

        public static GetPackInfoResp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static GetPackInfoResp parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (GetPackInfoResp) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static GetPackInfoResp parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (GetPackInfoResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser<GetPackInfoResp> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAnimated(boolean z10) {
            this.animated_ = z10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCount(long j10) {
            this.count_ = j10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCreatedAt(long j10) {
            this.createdAt_ = j10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setName(String str) {
            str.getClass();
            this.name_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setNameBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.name_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setThumb(String str) {
            str.getClass();
            this.thumb_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setThumbBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.thumb_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTitle(String str) {
            str.getClass();
            this.title_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTitleBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.title_ = byteString.toStringUtf8();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new GetPackInfoResp();
                case 2:
                    return new Builder();
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0006\u0000\u0000\u0001\u0006\u0006\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ\u0004\u0002\u0005\u0007\u0006\u0002", new Object[]{"title_", "name_", "thumb_", "createdAt_", "animated_", "count_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<GetPackInfoResp> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (GetPackInfoResp.class) {
                        try {
                            defaultInstanceBasedParser = PARSER;
                            if (defaultInstanceBasedParser == null) {
                                defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                                PARSER = defaultInstanceBasedParser;
                            }
                        } catch (Throwable th2) {
                            throw th2;
                        }
                        break;
                    }
                    return defaultInstanceBasedParser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        @Override // cu.todus.proto.ApiProto.GetPackInfoRespOrBuilder
        public boolean getAnimated() {
            return this.animated_;
        }

        @Override // cu.todus.proto.ApiProto.GetPackInfoRespOrBuilder
        public long getCount() {
            return this.count_;
        }

        @Override // cu.todus.proto.ApiProto.GetPackInfoRespOrBuilder
        public long getCreatedAt() {
            return this.createdAt_;
        }

        @Override // cu.todus.proto.ApiProto.GetPackInfoRespOrBuilder
        public String getName() {
            return this.name_;
        }

        @Override // cu.todus.proto.ApiProto.GetPackInfoRespOrBuilder
        public ByteString getNameBytes() {
            return ByteString.copyFromUtf8(this.name_);
        }

        @Override // cu.todus.proto.ApiProto.GetPackInfoRespOrBuilder
        public String getThumb() {
            return this.thumb_;
        }

        @Override // cu.todus.proto.ApiProto.GetPackInfoRespOrBuilder
        public ByteString getThumbBytes() {
            return ByteString.copyFromUtf8(this.thumb_);
        }

        @Override // cu.todus.proto.ApiProto.GetPackInfoRespOrBuilder
        public String getTitle() {
            return this.title_;
        }

        @Override // cu.todus.proto.ApiProto.GetPackInfoRespOrBuilder
        public ByteString getTitleBytes() {
            return ByteString.copyFromUtf8(this.title_);
        }

        public static Builder newBuilder(GetPackInfoResp getPackInfoResp) {
            return DEFAULT_INSTANCE.createBuilder(getPackInfoResp);
        }

        public static GetPackInfoResp parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (GetPackInfoResp) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static GetPackInfoResp parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (GetPackInfoResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static GetPackInfoResp parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (GetPackInfoResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static GetPackInfoResp parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (GetPackInfoResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static GetPackInfoResp parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (GetPackInfoResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static GetPackInfoResp parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (GetPackInfoResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static GetPackInfoResp parseFrom(InputStream inputStream) throws IOException {
            return (GetPackInfoResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static GetPackInfoResp parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (GetPackInfoResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static GetPackInfoResp parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (GetPackInfoResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static GetPackInfoResp parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (GetPackInfoResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    public interface GetPackInfoRespOrBuilder extends MessageLiteOrBuilder {
        boolean getAnimated();

        long getCount();

        long getCreatedAt();

        String getName();

        ByteString getNameBytes();

        String getThumb();

        ByteString getThumbBytes();

        String getTitle();

        ByteString getTitleBytes();
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    public static final class GetPacks extends GeneratedMessageLite<GetPacks, Builder> implements GetPacksOrBuilder {
        private static final GetPacks DEFAULT_INSTANCE;
        public static final int LIMIT_FIELD_NUMBER = 1;
        public static final int OFFSET_FIELD_NUMBER = 2;
        private static volatile Parser<GetPacks> PARSER;
        private int limit_;
        private int offset_;

        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        public static final class Builder extends GeneratedMessageLite.Builder<GetPacks, Builder> implements GetPacksOrBuilder {
            public Builder clearLimit() {
                copyOnWrite();
                ((GetPacks) this.instance).clearLimit();
                return this;
            }

            public Builder clearOffset() {
                copyOnWrite();
                ((GetPacks) this.instance).clearOffset();
                return this;
            }

            @Override // cu.todus.proto.ApiProto.GetPacksOrBuilder
            public int getLimit() {
                return ((GetPacks) this.instance).getLimit();
            }

            @Override // cu.todus.proto.ApiProto.GetPacksOrBuilder
            public int getOffset() {
                return ((GetPacks) this.instance).getOffset();
            }

            public Builder setLimit(int i10) {
                copyOnWrite();
                ((GetPacks) this.instance).setLimit(i10);
                return this;
            }

            public Builder setOffset(int i10) {
                copyOnWrite();
                ((GetPacks) this.instance).setOffset(i10);
                return this;
            }

            private Builder() {
                super(GetPacks.DEFAULT_INSTANCE);
            }
        }

        static {
            GetPacks getPacks = new GetPacks();
            DEFAULT_INSTANCE = getPacks;
            GeneratedMessageLite.registerDefaultInstance(GetPacks.class, getPacks);
        }

        private GetPacks() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearLimit() {
            this.limit_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearOffset() {
            this.offset_ = 0;
        }

        public static GetPacks getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static GetPacks parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (GetPacks) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static GetPacks parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (GetPacks) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser<GetPacks> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setLimit(int i10) {
            this.limit_ = i10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setOffset(int i10) {
            this.offset_ = i10;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new GetPacks();
                case 2:
                    return new Builder();
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0004\u0002\u0004", new Object[]{"limit_", "offset_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<GetPacks> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (GetPacks.class) {
                        try {
                            defaultInstanceBasedParser = PARSER;
                            if (defaultInstanceBasedParser == null) {
                                defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                                PARSER = defaultInstanceBasedParser;
                            }
                        } catch (Throwable th2) {
                            throw th2;
                        }
                        break;
                    }
                    return defaultInstanceBasedParser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        @Override // cu.todus.proto.ApiProto.GetPacksOrBuilder
        public int getLimit() {
            return this.limit_;
        }

        @Override // cu.todus.proto.ApiProto.GetPacksOrBuilder
        public int getOffset() {
            return this.offset_;
        }

        public static Builder newBuilder(GetPacks getPacks) {
            return DEFAULT_INSTANCE.createBuilder(getPacks);
        }

        public static GetPacks parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (GetPacks) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static GetPacks parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (GetPacks) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static GetPacks parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (GetPacks) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static GetPacks parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (GetPacks) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static GetPacks parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (GetPacks) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static GetPacks parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (GetPacks) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static GetPacks parseFrom(InputStream inputStream) throws IOException {
            return (GetPacks) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static GetPacks parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (GetPacks) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static GetPacks parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (GetPacks) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static GetPacks parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (GetPacks) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    public interface GetPacksOrBuilder extends MessageLiteOrBuilder {
        int getLimit();

        int getOffset();
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    public static final class GetPacksResp extends GeneratedMessageLite<GetPacksResp, Builder> implements GetPacksRespOrBuilder {
        private static final GetPacksResp DEFAULT_INSTANCE;
        public static final int PACKS_FIELD_NUMBER = 1;
        private static volatile Parser<GetPacksResp> PARSER;
        private Internal.ProtobufList<Pack> packs_ = GeneratedMessageLite.emptyProtobufList();

        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        public static final class Builder extends GeneratedMessageLite.Builder<GetPacksResp, Builder> implements GetPacksRespOrBuilder {
            public Builder addAllPacks(Iterable<? extends Pack> iterable) {
                copyOnWrite();
                ((GetPacksResp) this.instance).addAllPacks(iterable);
                return this;
            }

            public Builder addPacks(Pack pack) {
                copyOnWrite();
                ((GetPacksResp) this.instance).addPacks(pack);
                return this;
            }

            public Builder clearPacks() {
                copyOnWrite();
                ((GetPacksResp) this.instance).clearPacks();
                return this;
            }

            @Override // cu.todus.proto.ApiProto.GetPacksRespOrBuilder
            public Pack getPacks(int i10) {
                return ((GetPacksResp) this.instance).getPacks(i10);
            }

            @Override // cu.todus.proto.ApiProto.GetPacksRespOrBuilder
            public int getPacksCount() {
                return ((GetPacksResp) this.instance).getPacksCount();
            }

            @Override // cu.todus.proto.ApiProto.GetPacksRespOrBuilder
            public List<Pack> getPacksList() {
                return DesugarCollections.unmodifiableList(((GetPacksResp) this.instance).getPacksList());
            }

            public Builder removePacks(int i10) {
                copyOnWrite();
                ((GetPacksResp) this.instance).removePacks(i10);
                return this;
            }

            public Builder setPacks(int i10, Pack pack) {
                copyOnWrite();
                ((GetPacksResp) this.instance).setPacks(i10, pack);
                return this;
            }

            private Builder() {
                super(GetPacksResp.DEFAULT_INSTANCE);
            }

            public Builder addPacks(int i10, Pack pack) {
                copyOnWrite();
                ((GetPacksResp) this.instance).addPacks(i10, pack);
                return this;
            }

            public Builder setPacks(int i10, Pack.Builder builder) {
                copyOnWrite();
                ((GetPacksResp) this.instance).setPacks(i10, builder.build());
                return this;
            }

            public Builder addPacks(Pack.Builder builder) {
                copyOnWrite();
                ((GetPacksResp) this.instance).addPacks(builder.build());
                return this;
            }

            public Builder addPacks(int i10, Pack.Builder builder) {
                copyOnWrite();
                ((GetPacksResp) this.instance).addPacks(i10, builder.build());
                return this;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        public static final class Pack extends GeneratedMessageLite<Pack, Builder> implements PackOrBuilder {
            public static final int ANIMATED_FIELD_NUMBER = 5;
            public static final int COUNT_FIELD_NUMBER = 6;
            public static final int CREATED_AT_FIELD_NUMBER = 4;
            private static final Pack DEFAULT_INSTANCE;
            public static final int NAME_FIELD_NUMBER = 2;
            private static volatile Parser<Pack> PARSER = null;
            public static final int THUMB_FIELD_NUMBER = 3;
            public static final int TITLE_FIELD_NUMBER = 1;
            private boolean animated_;
            private long count_;
            private long createdAt_;
            private String title_ = "";
            private String name_ = "";
            private String thumb_ = "";

            /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
            public static final class Builder extends GeneratedMessageLite.Builder<Pack, Builder> implements PackOrBuilder {
                public Builder clearAnimated() {
                    copyOnWrite();
                    ((Pack) this.instance).clearAnimated();
                    return this;
                }

                public Builder clearCount() {
                    copyOnWrite();
                    ((Pack) this.instance).clearCount();
                    return this;
                }

                public Builder clearCreatedAt() {
                    copyOnWrite();
                    ((Pack) this.instance).clearCreatedAt();
                    return this;
                }

                public Builder clearName() {
                    copyOnWrite();
                    ((Pack) this.instance).clearName();
                    return this;
                }

                public Builder clearThumb() {
                    copyOnWrite();
                    ((Pack) this.instance).clearThumb();
                    return this;
                }

                public Builder clearTitle() {
                    copyOnWrite();
                    ((Pack) this.instance).clearTitle();
                    return this;
                }

                @Override // cu.todus.proto.ApiProto.GetPacksResp.PackOrBuilder
                public boolean getAnimated() {
                    return ((Pack) this.instance).getAnimated();
                }

                @Override // cu.todus.proto.ApiProto.GetPacksResp.PackOrBuilder
                public long getCount() {
                    return ((Pack) this.instance).getCount();
                }

                @Override // cu.todus.proto.ApiProto.GetPacksResp.PackOrBuilder
                public long getCreatedAt() {
                    return ((Pack) this.instance).getCreatedAt();
                }

                @Override // cu.todus.proto.ApiProto.GetPacksResp.PackOrBuilder
                public String getName() {
                    return ((Pack) this.instance).getName();
                }

                @Override // cu.todus.proto.ApiProto.GetPacksResp.PackOrBuilder
                public ByteString getNameBytes() {
                    return ((Pack) this.instance).getNameBytes();
                }

                @Override // cu.todus.proto.ApiProto.GetPacksResp.PackOrBuilder
                public String getThumb() {
                    return ((Pack) this.instance).getThumb();
                }

                @Override // cu.todus.proto.ApiProto.GetPacksResp.PackOrBuilder
                public ByteString getThumbBytes() {
                    return ((Pack) this.instance).getThumbBytes();
                }

                @Override // cu.todus.proto.ApiProto.GetPacksResp.PackOrBuilder
                public String getTitle() {
                    return ((Pack) this.instance).getTitle();
                }

                @Override // cu.todus.proto.ApiProto.GetPacksResp.PackOrBuilder
                public ByteString getTitleBytes() {
                    return ((Pack) this.instance).getTitleBytes();
                }

                public Builder setAnimated(boolean z10) {
                    copyOnWrite();
                    ((Pack) this.instance).setAnimated(z10);
                    return this;
                }

                public Builder setCount(long j10) {
                    copyOnWrite();
                    ((Pack) this.instance).setCount(j10);
                    return this;
                }

                public Builder setCreatedAt(long j10) {
                    copyOnWrite();
                    ((Pack) this.instance).setCreatedAt(j10);
                    return this;
                }

                public Builder setName(String str) {
                    copyOnWrite();
                    ((Pack) this.instance).setName(str);
                    return this;
                }

                public Builder setNameBytes(ByteString byteString) {
                    copyOnWrite();
                    ((Pack) this.instance).setNameBytes(byteString);
                    return this;
                }

                public Builder setThumb(String str) {
                    copyOnWrite();
                    ((Pack) this.instance).setThumb(str);
                    return this;
                }

                public Builder setThumbBytes(ByteString byteString) {
                    copyOnWrite();
                    ((Pack) this.instance).setThumbBytes(byteString);
                    return this;
                }

                public Builder setTitle(String str) {
                    copyOnWrite();
                    ((Pack) this.instance).setTitle(str);
                    return this;
                }

                public Builder setTitleBytes(ByteString byteString) {
                    copyOnWrite();
                    ((Pack) this.instance).setTitleBytes(byteString);
                    return this;
                }

                private Builder() {
                    super(Pack.DEFAULT_INSTANCE);
                }
            }

            static {
                Pack pack = new Pack();
                DEFAULT_INSTANCE = pack;
                GeneratedMessageLite.registerDefaultInstance(Pack.class, pack);
            }

            private Pack() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearAnimated() {
                this.animated_ = false;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearCount() {
                this.count_ = 0L;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearCreatedAt() {
                this.createdAt_ = 0L;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearName() {
                this.name_ = getDefaultInstance().getName();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearThumb() {
                this.thumb_ = getDefaultInstance().getThumb();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearTitle() {
                this.title_ = getDefaultInstance().getTitle();
            }

            public static Pack getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.createBuilder();
            }

            public static Pack parseDelimitedFrom(InputStream inputStream) throws IOException {
                return (Pack) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static Pack parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
                return (Pack) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
            }

            public static Parser<Pack> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setAnimated(boolean z10) {
                this.animated_ = z10;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setCount(long j10) {
                this.count_ = j10;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setCreatedAt(long j10) {
                this.createdAt_ = j10;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setName(String str) {
                str.getClass();
                this.name_ = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setNameBytes(ByteString byteString) {
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.name_ = byteString.toStringUtf8();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setThumb(String str) {
                str.getClass();
                this.thumb_ = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setThumbBytes(ByteString byteString) {
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.thumb_ = byteString.toStringUtf8();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setTitle(String str) {
                str.getClass();
                this.title_ = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setTitleBytes(ByteString byteString) {
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.title_ = byteString.toStringUtf8();
            }

            @Override // com.google.protobuf.GeneratedMessageLite
            public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                Parser defaultInstanceBasedParser;
                switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                    case 1:
                        return new Pack();
                    case 2:
                        return new Builder();
                    case 3:
                        return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0006\u0000\u0000\u0001\u0006\u0006\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ\u0004\u0002\u0005\u0007\u0006\u0002", new Object[]{"title_", "name_", "thumb_", "createdAt_", "animated_", "count_"});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        Parser<Pack> parser = PARSER;
                        if (parser != null) {
                            return parser;
                        }
                        synchronized (Pack.class) {
                            try {
                                defaultInstanceBasedParser = PARSER;
                                if (defaultInstanceBasedParser == null) {
                                    defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                                    PARSER = defaultInstanceBasedParser;
                                }
                            } catch (Throwable th2) {
                                throw th2;
                            }
                            break;
                        }
                        return defaultInstanceBasedParser;
                    case 6:
                        return (byte) 1;
                    case 7:
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }

            @Override // cu.todus.proto.ApiProto.GetPacksResp.PackOrBuilder
            public boolean getAnimated() {
                return this.animated_;
            }

            @Override // cu.todus.proto.ApiProto.GetPacksResp.PackOrBuilder
            public long getCount() {
                return this.count_;
            }

            @Override // cu.todus.proto.ApiProto.GetPacksResp.PackOrBuilder
            public long getCreatedAt() {
                return this.createdAt_;
            }

            @Override // cu.todus.proto.ApiProto.GetPacksResp.PackOrBuilder
            public String getName() {
                return this.name_;
            }

            @Override // cu.todus.proto.ApiProto.GetPacksResp.PackOrBuilder
            public ByteString getNameBytes() {
                return ByteString.copyFromUtf8(this.name_);
            }

            @Override // cu.todus.proto.ApiProto.GetPacksResp.PackOrBuilder
            public String getThumb() {
                return this.thumb_;
            }

            @Override // cu.todus.proto.ApiProto.GetPacksResp.PackOrBuilder
            public ByteString getThumbBytes() {
                return ByteString.copyFromUtf8(this.thumb_);
            }

            @Override // cu.todus.proto.ApiProto.GetPacksResp.PackOrBuilder
            public String getTitle() {
                return this.title_;
            }

            @Override // cu.todus.proto.ApiProto.GetPacksResp.PackOrBuilder
            public ByteString getTitleBytes() {
                return ByteString.copyFromUtf8(this.title_);
            }

            public static Builder newBuilder(Pack pack) {
                return DEFAULT_INSTANCE.createBuilder(pack);
            }

            public static Pack parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (Pack) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static Pack parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (Pack) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
            }

            public static Pack parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                return (Pack) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
            }

            public static Pack parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (Pack) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
            }

            public static Pack parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                return (Pack) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
            }

            public static Pack parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (Pack) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
            }

            public static Pack parseFrom(InputStream inputStream) throws IOException {
                return (Pack) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static Pack parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (Pack) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static Pack parseFrom(CodedInputStream codedInputStream) throws IOException {
                return (Pack) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
            }

            public static Pack parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (Pack) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        public interface PackOrBuilder extends MessageLiteOrBuilder {
            boolean getAnimated();

            long getCount();

            long getCreatedAt();

            String getName();

            ByteString getNameBytes();

            String getThumb();

            ByteString getThumbBytes();

            String getTitle();

            ByteString getTitleBytes();
        }

        static {
            GetPacksResp getPacksResp = new GetPacksResp();
            DEFAULT_INSTANCE = getPacksResp;
            GeneratedMessageLite.registerDefaultInstance(GetPacksResp.class, getPacksResp);
        }

        private GetPacksResp() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllPacks(Iterable<? extends Pack> iterable) {
            ensurePacksIsMutable();
            AbstractMessageLite.addAll((Iterable) iterable, (List) this.packs_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addPacks(Pack pack) {
            pack.getClass();
            ensurePacksIsMutable();
            this.packs_.add(pack);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPacks() {
            this.packs_ = GeneratedMessageLite.emptyProtobufList();
        }

        private void ensurePacksIsMutable() {
            Internal.ProtobufList<Pack> protobufList = this.packs_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.packs_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        public static GetPacksResp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static GetPacksResp parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (GetPacksResp) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static GetPacksResp parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (GetPacksResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser<GetPacksResp> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removePacks(int i10) {
            ensurePacksIsMutable();
            this.packs_.remove(i10);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPacks(int i10, Pack pack) {
            pack.getClass();
            ensurePacksIsMutable();
            this.packs_.set(i10, pack);
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new GetPacksResp();
                case 2:
                    return new Builder();
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"packs_", Pack.class});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<GetPacksResp> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (GetPacksResp.class) {
                        try {
                            defaultInstanceBasedParser = PARSER;
                            if (defaultInstanceBasedParser == null) {
                                defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                                PARSER = defaultInstanceBasedParser;
                            }
                        } catch (Throwable th2) {
                            throw th2;
                        }
                        break;
                    }
                    return defaultInstanceBasedParser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        @Override // cu.todus.proto.ApiProto.GetPacksRespOrBuilder
        public Pack getPacks(int i10) {
            return this.packs_.get(i10);
        }

        @Override // cu.todus.proto.ApiProto.GetPacksRespOrBuilder
        public int getPacksCount() {
            return this.packs_.size();
        }

        @Override // cu.todus.proto.ApiProto.GetPacksRespOrBuilder
        public List<Pack> getPacksList() {
            return this.packs_;
        }

        public PackOrBuilder getPacksOrBuilder(int i10) {
            return this.packs_.get(i10);
        }

        public List<? extends PackOrBuilder> getPacksOrBuilderList() {
            return this.packs_;
        }

        public static Builder newBuilder(GetPacksResp getPacksResp) {
            return DEFAULT_INSTANCE.createBuilder(getPacksResp);
        }

        public static GetPacksResp parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (GetPacksResp) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static GetPacksResp parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (GetPacksResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static GetPacksResp parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (GetPacksResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addPacks(int i10, Pack pack) {
            pack.getClass();
            ensurePacksIsMutable();
            this.packs_.add(i10, pack);
        }

        public static GetPacksResp parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (GetPacksResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static GetPacksResp parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (GetPacksResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static GetPacksResp parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (GetPacksResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static GetPacksResp parseFrom(InputStream inputStream) throws IOException {
            return (GetPacksResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static GetPacksResp parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (GetPacksResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static GetPacksResp parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (GetPacksResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static GetPacksResp parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (GetPacksResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    public interface GetPacksRespOrBuilder extends MessageLiteOrBuilder {
        GetPacksResp.Pack getPacks(int i10);

        int getPacksCount();

        List<GetPacksResp.Pack> getPacksList();
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    public enum MessageErrors implements Internal.EnumLite {
        ChannelExists(0),
        NoErrors(1),
        InvalidConfig(2),
        ChannelNotExists(3),
        NotChannelAdmin(4),
        FullChannel(5),
        NotChannelCreator(6),
        CreatorCantUnsubscribe(7),
        UNRECOGNIZED(-1);

        public static final int ChannelExists_VALUE = 0;
        public static final int ChannelNotExists_VALUE = 3;
        public static final int CreatorCantUnsubscribe_VALUE = 7;
        public static final int FullChannel_VALUE = 5;
        public static final int InvalidConfig_VALUE = 2;
        public static final int NoErrors_VALUE = 1;
        public static final int NotChannelAdmin_VALUE = 4;
        public static final int NotChannelCreator_VALUE = 6;
        private static final Internal.EnumLiteMap<MessageErrors> internalValueMap = new Internal.EnumLiteMap<MessageErrors>() { // from class: cu.todus.proto.ApiProto.MessageErrors.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public MessageErrors findValueByNumber(int i10) {
                return MessageErrors.forNumber(i10);
            }
        };
        private final int value;

        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        public static final class MessageErrorsVerifier implements Internal.EnumVerifier {
            static final Internal.EnumVerifier INSTANCE = new MessageErrorsVerifier();

            private MessageErrorsVerifier() {
            }

            @Override // com.google.protobuf.Internal.EnumVerifier
            public boolean isInRange(int i10) {
                return MessageErrors.forNumber(i10) != null;
            }
        }

        MessageErrors(int i10) {
            this.value = i10;
        }

        public static MessageErrors forNumber(int i10) {
            switch (i10) {
                case 0:
                    return ChannelExists;
                case 1:
                    return NoErrors;
                case 2:
                    return InvalidConfig;
                case 3:
                    return ChannelNotExists;
                case 4:
                    return NotChannelAdmin;
                case 5:
                    return FullChannel;
                case 6:
                    return NotChannelCreator;
                case 7:
                    return CreatorCantUnsubscribe;
                default:
                    return null;
            }
        }

        public static Internal.EnumLiteMap<MessageErrors> internalGetValueMap() {
            return internalValueMap;
        }

        public static Internal.EnumVerifier internalGetVerifier() {
            return MessageErrorsVerifier.INSTANCE;
        }

        @Override // com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Deprecated
        public static MessageErrors valueOf(int i10) {
            return forNumber(i10);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    public static final class MyChannelsResp extends GeneratedMessageLite<MyChannelsResp, Builder> implements MyChannelsRespOrBuilder {
        public static final int CHANNELS_FIELD_NUMBER = 1;
        private static final MyChannelsResp DEFAULT_INSTANCE;
        private static volatile Parser<MyChannelsResp> PARSER;
        private Internal.ProtobufList<String> channels_ = GeneratedMessageLite.emptyProtobufList();

        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        public static final class Builder extends GeneratedMessageLite.Builder<MyChannelsResp, Builder> implements MyChannelsRespOrBuilder {
            public Builder addAllChannels(Iterable<String> iterable) {
                copyOnWrite();
                ((MyChannelsResp) this.instance).addAllChannels(iterable);
                return this;
            }

            public Builder addChannels(String str) {
                copyOnWrite();
                ((MyChannelsResp) this.instance).addChannels(str);
                return this;
            }

            public Builder addChannelsBytes(ByteString byteString) {
                copyOnWrite();
                ((MyChannelsResp) this.instance).addChannelsBytes(byteString);
                return this;
            }

            public Builder clearChannels() {
                copyOnWrite();
                ((MyChannelsResp) this.instance).clearChannels();
                return this;
            }

            @Override // cu.todus.proto.ApiProto.MyChannelsRespOrBuilder
            public String getChannels(int i10) {
                return ((MyChannelsResp) this.instance).getChannels(i10);
            }

            @Override // cu.todus.proto.ApiProto.MyChannelsRespOrBuilder
            public ByteString getChannelsBytes(int i10) {
                return ((MyChannelsResp) this.instance).getChannelsBytes(i10);
            }

            @Override // cu.todus.proto.ApiProto.MyChannelsRespOrBuilder
            public int getChannelsCount() {
                return ((MyChannelsResp) this.instance).getChannelsCount();
            }

            @Override // cu.todus.proto.ApiProto.MyChannelsRespOrBuilder
            public List<String> getChannelsList() {
                return DesugarCollections.unmodifiableList(((MyChannelsResp) this.instance).getChannelsList());
            }

            public Builder setChannels(int i10, String str) {
                copyOnWrite();
                ((MyChannelsResp) this.instance).setChannels(i10, str);
                return this;
            }

            private Builder() {
                super(MyChannelsResp.DEFAULT_INSTANCE);
            }
        }

        static {
            MyChannelsResp myChannelsResp = new MyChannelsResp();
            DEFAULT_INSTANCE = myChannelsResp;
            GeneratedMessageLite.registerDefaultInstance(MyChannelsResp.class, myChannelsResp);
        }

        private MyChannelsResp() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllChannels(Iterable<String> iterable) {
            ensureChannelsIsMutable();
            AbstractMessageLite.addAll((Iterable) iterable, (List) this.channels_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addChannels(String str) {
            str.getClass();
            ensureChannelsIsMutable();
            this.channels_.add(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addChannelsBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            ensureChannelsIsMutable();
            this.channels_.add(byteString.toStringUtf8());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearChannels() {
            this.channels_ = GeneratedMessageLite.emptyProtobufList();
        }

        private void ensureChannelsIsMutable() {
            Internal.ProtobufList<String> protobufList = this.channels_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.channels_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        public static MyChannelsResp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static MyChannelsResp parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (MyChannelsResp) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static MyChannelsResp parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (MyChannelsResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser<MyChannelsResp> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setChannels(int i10, String str) {
            str.getClass();
            ensureChannelsIsMutable();
            this.channels_.set(i10, str);
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new MyChannelsResp();
                case 2:
                    return new Builder();
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001Ț", new Object[]{"channels_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<MyChannelsResp> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (MyChannelsResp.class) {
                        try {
                            defaultInstanceBasedParser = PARSER;
                            if (defaultInstanceBasedParser == null) {
                                defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                                PARSER = defaultInstanceBasedParser;
                            }
                        } catch (Throwable th2) {
                            throw th2;
                        }
                        break;
                    }
                    return defaultInstanceBasedParser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        @Override // cu.todus.proto.ApiProto.MyChannelsRespOrBuilder
        public String getChannels(int i10) {
            return this.channels_.get(i10);
        }

        @Override // cu.todus.proto.ApiProto.MyChannelsRespOrBuilder
        public ByteString getChannelsBytes(int i10) {
            return ByteString.copyFromUtf8(this.channels_.get(i10));
        }

        @Override // cu.todus.proto.ApiProto.MyChannelsRespOrBuilder
        public int getChannelsCount() {
            return this.channels_.size();
        }

        @Override // cu.todus.proto.ApiProto.MyChannelsRespOrBuilder
        public List<String> getChannelsList() {
            return this.channels_;
        }

        public static Builder newBuilder(MyChannelsResp myChannelsResp) {
            return DEFAULT_INSTANCE.createBuilder(myChannelsResp);
        }

        public static MyChannelsResp parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (MyChannelsResp) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static MyChannelsResp parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (MyChannelsResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static MyChannelsResp parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (MyChannelsResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static MyChannelsResp parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (MyChannelsResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static MyChannelsResp parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (MyChannelsResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static MyChannelsResp parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (MyChannelsResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static MyChannelsResp parseFrom(InputStream inputStream) throws IOException {
            return (MyChannelsResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static MyChannelsResp parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (MyChannelsResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static MyChannelsResp parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (MyChannelsResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static MyChannelsResp parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (MyChannelsResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    public interface MyChannelsRespOrBuilder extends MessageLiteOrBuilder {
        String getChannels(int i10);

        ByteString getChannelsBytes(int i10);

        int getChannelsCount();

        List<String> getChannelsList();
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    public static final class ProtoAuthCheckRequest extends GeneratedMessageLite<ProtoAuthCheckRequest, Builder> implements ProtoAuthCheckRequestOrBuilder {
        private static final ProtoAuthCheckRequest DEFAULT_INSTANCE;
        private static volatile Parser<ProtoAuthCheckRequest> PARSER = null;
        public static final int PASSWORD_FIELD_NUMBER = 2;
        public static final int USERNAME_FIELD_NUMBER = 1;
        private String username_ = "";
        private String password_ = "";

        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        public static final class Builder extends GeneratedMessageLite.Builder<ProtoAuthCheckRequest, Builder> implements ProtoAuthCheckRequestOrBuilder {
            public Builder clearPassword() {
                copyOnWrite();
                ((ProtoAuthCheckRequest) this.instance).clearPassword();
                return this;
            }

            public Builder clearUsername() {
                copyOnWrite();
                ((ProtoAuthCheckRequest) this.instance).clearUsername();
                return this;
            }

            @Override // cu.todus.proto.ApiProto.ProtoAuthCheckRequestOrBuilder
            public String getPassword() {
                return ((ProtoAuthCheckRequest) this.instance).getPassword();
            }

            @Override // cu.todus.proto.ApiProto.ProtoAuthCheckRequestOrBuilder
            public ByteString getPasswordBytes() {
                return ((ProtoAuthCheckRequest) this.instance).getPasswordBytes();
            }

            @Override // cu.todus.proto.ApiProto.ProtoAuthCheckRequestOrBuilder
            public String getUsername() {
                return ((ProtoAuthCheckRequest) this.instance).getUsername();
            }

            @Override // cu.todus.proto.ApiProto.ProtoAuthCheckRequestOrBuilder
            public ByteString getUsernameBytes() {
                return ((ProtoAuthCheckRequest) this.instance).getUsernameBytes();
            }

            public Builder setPassword(String str) {
                copyOnWrite();
                ((ProtoAuthCheckRequest) this.instance).setPassword(str);
                return this;
            }

            public Builder setPasswordBytes(ByteString byteString) {
                copyOnWrite();
                ((ProtoAuthCheckRequest) this.instance).setPasswordBytes(byteString);
                return this;
            }

            public Builder setUsername(String str) {
                copyOnWrite();
                ((ProtoAuthCheckRequest) this.instance).setUsername(str);
                return this;
            }

            public Builder setUsernameBytes(ByteString byteString) {
                copyOnWrite();
                ((ProtoAuthCheckRequest) this.instance).setUsernameBytes(byteString);
                return this;
            }

            private Builder() {
                super(ProtoAuthCheckRequest.DEFAULT_INSTANCE);
            }
        }

        static {
            ProtoAuthCheckRequest protoAuthCheckRequest = new ProtoAuthCheckRequest();
            DEFAULT_INSTANCE = protoAuthCheckRequest;
            GeneratedMessageLite.registerDefaultInstance(ProtoAuthCheckRequest.class, protoAuthCheckRequest);
        }

        private ProtoAuthCheckRequest() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPassword() {
            this.password_ = getDefaultInstance().getPassword();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearUsername() {
            this.username_ = getDefaultInstance().getUsername();
        }

        public static ProtoAuthCheckRequest getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static ProtoAuthCheckRequest parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (ProtoAuthCheckRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ProtoAuthCheckRequest parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (ProtoAuthCheckRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser<ProtoAuthCheckRequest> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPassword(String str) {
            str.getClass();
            this.password_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPasswordBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.password_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUsername(String str) {
            str.getClass();
            this.username_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUsernameBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.username_ = byteString.toStringUtf8();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new ProtoAuthCheckRequest();
                case 2:
                    return new Builder();
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ", new Object[]{"username_", "password_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<ProtoAuthCheckRequest> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (ProtoAuthCheckRequest.class) {
                        try {
                            defaultInstanceBasedParser = PARSER;
                            if (defaultInstanceBasedParser == null) {
                                defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                                PARSER = defaultInstanceBasedParser;
                            }
                        } catch (Throwable th2) {
                            throw th2;
                        }
                        break;
                    }
                    return defaultInstanceBasedParser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        @Override // cu.todus.proto.ApiProto.ProtoAuthCheckRequestOrBuilder
        public String getPassword() {
            return this.password_;
        }

        @Override // cu.todus.proto.ApiProto.ProtoAuthCheckRequestOrBuilder
        public ByteString getPasswordBytes() {
            return ByteString.copyFromUtf8(this.password_);
        }

        @Override // cu.todus.proto.ApiProto.ProtoAuthCheckRequestOrBuilder
        public String getUsername() {
            return this.username_;
        }

        @Override // cu.todus.proto.ApiProto.ProtoAuthCheckRequestOrBuilder
        public ByteString getUsernameBytes() {
            return ByteString.copyFromUtf8(this.username_);
        }

        public static Builder newBuilder(ProtoAuthCheckRequest protoAuthCheckRequest) {
            return DEFAULT_INSTANCE.createBuilder(protoAuthCheckRequest);
        }

        public static ProtoAuthCheckRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ProtoAuthCheckRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ProtoAuthCheckRequest parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ProtoAuthCheckRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static ProtoAuthCheckRequest parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (ProtoAuthCheckRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static ProtoAuthCheckRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ProtoAuthCheckRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static ProtoAuthCheckRequest parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (ProtoAuthCheckRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static ProtoAuthCheckRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ProtoAuthCheckRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static ProtoAuthCheckRequest parseFrom(InputStream inputStream) throws IOException {
            return (ProtoAuthCheckRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ProtoAuthCheckRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ProtoAuthCheckRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ProtoAuthCheckRequest parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (ProtoAuthCheckRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static ProtoAuthCheckRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ProtoAuthCheckRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    public interface ProtoAuthCheckRequestOrBuilder extends MessageLiteOrBuilder {
        String getPassword();

        ByteString getPasswordBytes();

        String getUsername();

        ByteString getUsernameBytes();
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    public static final class ProtoMamMessageRequest extends GeneratedMessageLite<ProtoMamMessageRequest, Builder> implements ProtoMamMessageRequestOrBuilder {
        private static final ProtoMamMessageRequest DEFAULT_INSTANCE;
        public static final int IDS_FIELD_NUMBER = 1;
        public static final int LIMIT_FIELD_NUMBER = 2;
        private static volatile Parser<ProtoMamMessageRequest> PARSER;
        private Internal.ProtobufList<String> ids_ = GeneratedMessageLite.emptyProtobufList();
        private int limit_;

        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        public static final class Builder extends GeneratedMessageLite.Builder<ProtoMamMessageRequest, Builder> implements ProtoMamMessageRequestOrBuilder {
            public Builder addAllIds(Iterable<String> iterable) {
                copyOnWrite();
                ((ProtoMamMessageRequest) this.instance).addAllIds(iterable);
                return this;
            }

            public Builder addIds(String str) {
                copyOnWrite();
                ((ProtoMamMessageRequest) this.instance).addIds(str);
                return this;
            }

            public Builder addIdsBytes(ByteString byteString) {
                copyOnWrite();
                ((ProtoMamMessageRequest) this.instance).addIdsBytes(byteString);
                return this;
            }

            public Builder clearIds() {
                copyOnWrite();
                ((ProtoMamMessageRequest) this.instance).clearIds();
                return this;
            }

            public Builder clearLimit() {
                copyOnWrite();
                ((ProtoMamMessageRequest) this.instance).clearLimit();
                return this;
            }

            @Override // cu.todus.proto.ApiProto.ProtoMamMessageRequestOrBuilder
            public String getIds(int i10) {
                return ((ProtoMamMessageRequest) this.instance).getIds(i10);
            }

            @Override // cu.todus.proto.ApiProto.ProtoMamMessageRequestOrBuilder
            public ByteString getIdsBytes(int i10) {
                return ((ProtoMamMessageRequest) this.instance).getIdsBytes(i10);
            }

            @Override // cu.todus.proto.ApiProto.ProtoMamMessageRequestOrBuilder
            public int getIdsCount() {
                return ((ProtoMamMessageRequest) this.instance).getIdsCount();
            }

            @Override // cu.todus.proto.ApiProto.ProtoMamMessageRequestOrBuilder
            public List<String> getIdsList() {
                return DesugarCollections.unmodifiableList(((ProtoMamMessageRequest) this.instance).getIdsList());
            }

            @Override // cu.todus.proto.ApiProto.ProtoMamMessageRequestOrBuilder
            public int getLimit() {
                return ((ProtoMamMessageRequest) this.instance).getLimit();
            }

            public Builder setIds(int i10, String str) {
                copyOnWrite();
                ((ProtoMamMessageRequest) this.instance).setIds(i10, str);
                return this;
            }

            public Builder setLimit(int i10) {
                copyOnWrite();
                ((ProtoMamMessageRequest) this.instance).setLimit(i10);
                return this;
            }

            private Builder() {
                super(ProtoMamMessageRequest.DEFAULT_INSTANCE);
            }
        }

        static {
            ProtoMamMessageRequest protoMamMessageRequest = new ProtoMamMessageRequest();
            DEFAULT_INSTANCE = protoMamMessageRequest;
            GeneratedMessageLite.registerDefaultInstance(ProtoMamMessageRequest.class, protoMamMessageRequest);
        }

        private ProtoMamMessageRequest() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllIds(Iterable<String> iterable) {
            ensureIdsIsMutable();
            AbstractMessageLite.addAll((Iterable) iterable, (List) this.ids_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addIds(String str) {
            str.getClass();
            ensureIdsIsMutable();
            this.ids_.add(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addIdsBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            ensureIdsIsMutable();
            this.ids_.add(byteString.toStringUtf8());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearIds() {
            this.ids_ = GeneratedMessageLite.emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearLimit() {
            this.limit_ = 0;
        }

        private void ensureIdsIsMutable() {
            Internal.ProtobufList<String> protobufList = this.ids_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.ids_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        public static ProtoMamMessageRequest getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static ProtoMamMessageRequest parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (ProtoMamMessageRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ProtoMamMessageRequest parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (ProtoMamMessageRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser<ProtoMamMessageRequest> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setIds(int i10, String str) {
            str.getClass();
            ensureIdsIsMutable();
            this.ids_.set(i10, str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setLimit(int i10) {
            this.limit_ = i10;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new ProtoMamMessageRequest();
                case 2:
                    return new Builder();
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001Ț\u0002\u0004", new Object[]{"ids_", "limit_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<ProtoMamMessageRequest> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (ProtoMamMessageRequest.class) {
                        try {
                            defaultInstanceBasedParser = PARSER;
                            if (defaultInstanceBasedParser == null) {
                                defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                                PARSER = defaultInstanceBasedParser;
                            }
                        } catch (Throwable th2) {
                            throw th2;
                        }
                        break;
                    }
                    return defaultInstanceBasedParser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        @Override // cu.todus.proto.ApiProto.ProtoMamMessageRequestOrBuilder
        public String getIds(int i10) {
            return this.ids_.get(i10);
        }

        @Override // cu.todus.proto.ApiProto.ProtoMamMessageRequestOrBuilder
        public ByteString getIdsBytes(int i10) {
            return ByteString.copyFromUtf8(this.ids_.get(i10));
        }

        @Override // cu.todus.proto.ApiProto.ProtoMamMessageRequestOrBuilder
        public int getIdsCount() {
            return this.ids_.size();
        }

        @Override // cu.todus.proto.ApiProto.ProtoMamMessageRequestOrBuilder
        public List<String> getIdsList() {
            return this.ids_;
        }

        @Override // cu.todus.proto.ApiProto.ProtoMamMessageRequestOrBuilder
        public int getLimit() {
            return this.limit_;
        }

        public static Builder newBuilder(ProtoMamMessageRequest protoMamMessageRequest) {
            return DEFAULT_INSTANCE.createBuilder(protoMamMessageRequest);
        }

        public static ProtoMamMessageRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ProtoMamMessageRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ProtoMamMessageRequest parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ProtoMamMessageRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static ProtoMamMessageRequest parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (ProtoMamMessageRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static ProtoMamMessageRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ProtoMamMessageRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static ProtoMamMessageRequest parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (ProtoMamMessageRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static ProtoMamMessageRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ProtoMamMessageRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static ProtoMamMessageRequest parseFrom(InputStream inputStream) throws IOException {
            return (ProtoMamMessageRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ProtoMamMessageRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ProtoMamMessageRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ProtoMamMessageRequest parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (ProtoMamMessageRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static ProtoMamMessageRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ProtoMamMessageRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    public interface ProtoMamMessageRequestOrBuilder extends MessageLiteOrBuilder {
        String getIds(int i10);

        ByteString getIdsBytes(int i10);

        int getIdsCount();

        List<String> getIdsList();

        int getLimit();
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    public static final class ProtoMamMessageResponse extends GeneratedMessageLite<ProtoMamMessageResponse, Builder> implements ProtoMamMessageResponseOrBuilder {
        private static final ProtoMamMessageResponse DEFAULT_INSTANCE;
        public static final int MESSAGES_FIELD_NUMBER = 1;
        private static volatile Parser<ProtoMamMessageResponse> PARSER;
        private Internal.ProtobufList<Message> messages_ = GeneratedMessageLite.emptyProtobufList();

        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        public static final class Builder extends GeneratedMessageLite.Builder<ProtoMamMessageResponse, Builder> implements ProtoMamMessageResponseOrBuilder {
            public Builder addAllMessages(Iterable<? extends Message> iterable) {
                copyOnWrite();
                ((ProtoMamMessageResponse) this.instance).addAllMessages(iterable);
                return this;
            }

            public Builder addMessages(Message message) {
                copyOnWrite();
                ((ProtoMamMessageResponse) this.instance).addMessages(message);
                return this;
            }

            public Builder clearMessages() {
                copyOnWrite();
                ((ProtoMamMessageResponse) this.instance).clearMessages();
                return this;
            }

            @Override // cu.todus.proto.ApiProto.ProtoMamMessageResponseOrBuilder
            public Message getMessages(int i10) {
                return ((ProtoMamMessageResponse) this.instance).getMessages(i10);
            }

            @Override // cu.todus.proto.ApiProto.ProtoMamMessageResponseOrBuilder
            public int getMessagesCount() {
                return ((ProtoMamMessageResponse) this.instance).getMessagesCount();
            }

            @Override // cu.todus.proto.ApiProto.ProtoMamMessageResponseOrBuilder
            public List<Message> getMessagesList() {
                return DesugarCollections.unmodifiableList(((ProtoMamMessageResponse) this.instance).getMessagesList());
            }

            public Builder removeMessages(int i10) {
                copyOnWrite();
                ((ProtoMamMessageResponse) this.instance).removeMessages(i10);
                return this;
            }

            public Builder setMessages(int i10, Message message) {
                copyOnWrite();
                ((ProtoMamMessageResponse) this.instance).setMessages(i10, message);
                return this;
            }

            private Builder() {
                super(ProtoMamMessageResponse.DEFAULT_INSTANCE);
            }

            public Builder addMessages(int i10, Message message) {
                copyOnWrite();
                ((ProtoMamMessageResponse) this.instance).addMessages(i10, message);
                return this;
            }

            public Builder setMessages(int i10, Message.Builder builder) {
                copyOnWrite();
                ((ProtoMamMessageResponse) this.instance).setMessages(i10, builder.build());
                return this;
            }

            public Builder addMessages(Message.Builder builder) {
                copyOnWrite();
                ((ProtoMamMessageResponse) this.instance).addMessages(builder.build());
                return this;
            }

            public Builder addMessages(int i10, Message.Builder builder) {
                copyOnWrite();
                ((ProtoMamMessageResponse) this.instance).addMessages(i10, builder.build());
                return this;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        public static final class Message extends GeneratedMessageLite<Message, Builder> implements MessageOrBuilder {
            private static final Message DEFAULT_INSTANCE;
            public static final int FROM_FIELD_NUMBER = 4;
            public static final int ID_FIELD_NUMBER = 1;
            private static volatile Parser<Message> PARSER = null;
            public static final int TIMESTAMP_FIELD_NUMBER = 3;
            public static final int XML_FIELD_NUMBER = 2;
            private long timestamp_;
            private String id_ = "";
            private String xml_ = "";
            private String from_ = "";

            /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
            public static final class Builder extends GeneratedMessageLite.Builder<Message, Builder> implements MessageOrBuilder {
                public Builder clearFrom() {
                    copyOnWrite();
                    ((Message) this.instance).clearFrom();
                    return this;
                }

                public Builder clearId() {
                    copyOnWrite();
                    ((Message) this.instance).clearId();
                    return this;
                }

                public Builder clearTimestamp() {
                    copyOnWrite();
                    ((Message) this.instance).clearTimestamp();
                    return this;
                }

                public Builder clearXml() {
                    copyOnWrite();
                    ((Message) this.instance).clearXml();
                    return this;
                }

                @Override // cu.todus.proto.ApiProto.ProtoMamMessageResponse.MessageOrBuilder
                public String getFrom() {
                    return ((Message) this.instance).getFrom();
                }

                @Override // cu.todus.proto.ApiProto.ProtoMamMessageResponse.MessageOrBuilder
                public ByteString getFromBytes() {
                    return ((Message) this.instance).getFromBytes();
                }

                @Override // cu.todus.proto.ApiProto.ProtoMamMessageResponse.MessageOrBuilder
                public String getId() {
                    return ((Message) this.instance).getId();
                }

                @Override // cu.todus.proto.ApiProto.ProtoMamMessageResponse.MessageOrBuilder
                public ByteString getIdBytes() {
                    return ((Message) this.instance).getIdBytes();
                }

                @Override // cu.todus.proto.ApiProto.ProtoMamMessageResponse.MessageOrBuilder
                public long getTimestamp() {
                    return ((Message) this.instance).getTimestamp();
                }

                @Override // cu.todus.proto.ApiProto.ProtoMamMessageResponse.MessageOrBuilder
                public String getXml() {
                    return ((Message) this.instance).getXml();
                }

                @Override // cu.todus.proto.ApiProto.ProtoMamMessageResponse.MessageOrBuilder
                public ByteString getXmlBytes() {
                    return ((Message) this.instance).getXmlBytes();
                }

                public Builder setFrom(String str) {
                    copyOnWrite();
                    ((Message) this.instance).setFrom(str);
                    return this;
                }

                public Builder setFromBytes(ByteString byteString) {
                    copyOnWrite();
                    ((Message) this.instance).setFromBytes(byteString);
                    return this;
                }

                public Builder setId(String str) {
                    copyOnWrite();
                    ((Message) this.instance).setId(str);
                    return this;
                }

                public Builder setIdBytes(ByteString byteString) {
                    copyOnWrite();
                    ((Message) this.instance).setIdBytes(byteString);
                    return this;
                }

                public Builder setTimestamp(long j10) {
                    copyOnWrite();
                    ((Message) this.instance).setTimestamp(j10);
                    return this;
                }

                public Builder setXml(String str) {
                    copyOnWrite();
                    ((Message) this.instance).setXml(str);
                    return this;
                }

                public Builder setXmlBytes(ByteString byteString) {
                    copyOnWrite();
                    ((Message) this.instance).setXmlBytes(byteString);
                    return this;
                }

                private Builder() {
                    super(Message.DEFAULT_INSTANCE);
                }
            }

            static {
                Message message = new Message();
                DEFAULT_INSTANCE = message;
                GeneratedMessageLite.registerDefaultInstance(Message.class, message);
            }

            private Message() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearFrom() {
                this.from_ = getDefaultInstance().getFrom();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearId() {
                this.id_ = getDefaultInstance().getId();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearTimestamp() {
                this.timestamp_ = 0L;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearXml() {
                this.xml_ = getDefaultInstance().getXml();
            }

            public static Message getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.createBuilder();
            }

            public static Message parseDelimitedFrom(InputStream inputStream) throws IOException {
                return (Message) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static Message parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
                return (Message) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
            }

            public static Parser<Message> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setFrom(String str) {
                str.getClass();
                this.from_ = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setFromBytes(ByteString byteString) {
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.from_ = byteString.toStringUtf8();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setId(String str) {
                str.getClass();
                this.id_ = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setIdBytes(ByteString byteString) {
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.id_ = byteString.toStringUtf8();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setTimestamp(long j10) {
                this.timestamp_ = j10;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setXml(String str) {
                str.getClass();
                this.xml_ = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setXmlBytes(ByteString byteString) {
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.xml_ = byteString.toStringUtf8();
            }

            @Override // com.google.protobuf.GeneratedMessageLite
            public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                Parser defaultInstanceBasedParser;
                switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                    case 1:
                        return new Message();
                    case 2:
                        return new Builder();
                    case 3:
                        return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003\u0002\u0004Ȉ", new Object[]{"id_", "xml_", "timestamp_", "from_"});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        Parser<Message> parser = PARSER;
                        if (parser != null) {
                            return parser;
                        }
                        synchronized (Message.class) {
                            try {
                                defaultInstanceBasedParser = PARSER;
                                if (defaultInstanceBasedParser == null) {
                                    defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                                    PARSER = defaultInstanceBasedParser;
                                }
                            } catch (Throwable th2) {
                                throw th2;
                            }
                            break;
                        }
                        return defaultInstanceBasedParser;
                    case 6:
                        return (byte) 1;
                    case 7:
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }

            @Override // cu.todus.proto.ApiProto.ProtoMamMessageResponse.MessageOrBuilder
            public String getFrom() {
                return this.from_;
            }

            @Override // cu.todus.proto.ApiProto.ProtoMamMessageResponse.MessageOrBuilder
            public ByteString getFromBytes() {
                return ByteString.copyFromUtf8(this.from_);
            }

            @Override // cu.todus.proto.ApiProto.ProtoMamMessageResponse.MessageOrBuilder
            public String getId() {
                return this.id_;
            }

            @Override // cu.todus.proto.ApiProto.ProtoMamMessageResponse.MessageOrBuilder
            public ByteString getIdBytes() {
                return ByteString.copyFromUtf8(this.id_);
            }

            @Override // cu.todus.proto.ApiProto.ProtoMamMessageResponse.MessageOrBuilder
            public long getTimestamp() {
                return this.timestamp_;
            }

            @Override // cu.todus.proto.ApiProto.ProtoMamMessageResponse.MessageOrBuilder
            public String getXml() {
                return this.xml_;
            }

            @Override // cu.todus.proto.ApiProto.ProtoMamMessageResponse.MessageOrBuilder
            public ByteString getXmlBytes() {
                return ByteString.copyFromUtf8(this.xml_);
            }

            public static Builder newBuilder(Message message) {
                return DEFAULT_INSTANCE.createBuilder(message);
            }

            public static Message parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (Message) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static Message parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (Message) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
            }

            public static Message parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                return (Message) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
            }

            public static Message parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (Message) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
            }

            public static Message parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                return (Message) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
            }

            public static Message parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (Message) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
            }

            public static Message parseFrom(InputStream inputStream) throws IOException {
                return (Message) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static Message parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (Message) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static Message parseFrom(CodedInputStream codedInputStream) throws IOException {
                return (Message) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
            }

            public static Message parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (Message) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        public interface MessageOrBuilder extends MessageLiteOrBuilder {
            String getFrom();

            ByteString getFromBytes();

            String getId();

            ByteString getIdBytes();

            long getTimestamp();

            String getXml();

            ByteString getXmlBytes();
        }

        static {
            ProtoMamMessageResponse protoMamMessageResponse = new ProtoMamMessageResponse();
            DEFAULT_INSTANCE = protoMamMessageResponse;
            GeneratedMessageLite.registerDefaultInstance(ProtoMamMessageResponse.class, protoMamMessageResponse);
        }

        private ProtoMamMessageResponse() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllMessages(Iterable<? extends Message> iterable) {
            ensureMessagesIsMutable();
            AbstractMessageLite.addAll((Iterable) iterable, (List) this.messages_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addMessages(Message message) {
            message.getClass();
            ensureMessagesIsMutable();
            this.messages_.add(message);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearMessages() {
            this.messages_ = GeneratedMessageLite.emptyProtobufList();
        }

        private void ensureMessagesIsMutable() {
            Internal.ProtobufList<Message> protobufList = this.messages_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.messages_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        public static ProtoMamMessageResponse getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static ProtoMamMessageResponse parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (ProtoMamMessageResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ProtoMamMessageResponse parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (ProtoMamMessageResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser<ProtoMamMessageResponse> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeMessages(int i10) {
            ensureMessagesIsMutable();
            this.messages_.remove(i10);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMessages(int i10, Message message) {
            message.getClass();
            ensureMessagesIsMutable();
            this.messages_.set(i10, message);
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new ProtoMamMessageResponse();
                case 2:
                    return new Builder();
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"messages_", Message.class});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<ProtoMamMessageResponse> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (ProtoMamMessageResponse.class) {
                        try {
                            defaultInstanceBasedParser = PARSER;
                            if (defaultInstanceBasedParser == null) {
                                defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                                PARSER = defaultInstanceBasedParser;
                            }
                        } catch (Throwable th2) {
                            throw th2;
                        }
                        break;
                    }
                    return defaultInstanceBasedParser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        @Override // cu.todus.proto.ApiProto.ProtoMamMessageResponseOrBuilder
        public Message getMessages(int i10) {
            return this.messages_.get(i10);
        }

        @Override // cu.todus.proto.ApiProto.ProtoMamMessageResponseOrBuilder
        public int getMessagesCount() {
            return this.messages_.size();
        }

        @Override // cu.todus.proto.ApiProto.ProtoMamMessageResponseOrBuilder
        public List<Message> getMessagesList() {
            return this.messages_;
        }

        public MessageOrBuilder getMessagesOrBuilder(int i10) {
            return this.messages_.get(i10);
        }

        public List<? extends MessageOrBuilder> getMessagesOrBuilderList() {
            return this.messages_;
        }

        public static Builder newBuilder(ProtoMamMessageResponse protoMamMessageResponse) {
            return DEFAULT_INSTANCE.createBuilder(protoMamMessageResponse);
        }

        public static ProtoMamMessageResponse parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ProtoMamMessageResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ProtoMamMessageResponse parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ProtoMamMessageResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static ProtoMamMessageResponse parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (ProtoMamMessageResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addMessages(int i10, Message message) {
            message.getClass();
            ensureMessagesIsMutable();
            this.messages_.add(i10, message);
        }

        public static ProtoMamMessageResponse parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ProtoMamMessageResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static ProtoMamMessageResponse parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (ProtoMamMessageResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static ProtoMamMessageResponse parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ProtoMamMessageResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static ProtoMamMessageResponse parseFrom(InputStream inputStream) throws IOException {
            return (ProtoMamMessageResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ProtoMamMessageResponse parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ProtoMamMessageResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ProtoMamMessageResponse parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (ProtoMamMessageResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static ProtoMamMessageResponse parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ProtoMamMessageResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    public interface ProtoMamMessageResponseOrBuilder extends MessageLiteOrBuilder {
        ProtoMamMessageResponse.Message getMessages(int i10);

        int getMessagesCount();

        List<ProtoMamMessageResponse.Message> getMessagesList();
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    public static final class ProtoMucConfigRequest extends GeneratedMessageLite<ProtoMucConfigRequest, Builder> implements ProtoMucConfigRequestOrBuilder {
        private static final ProtoMucConfigRequest DEFAULT_INSTANCE;
        public static final int GROUPS_FIELD_NUMBER = 1;
        private static volatile Parser<ProtoMucConfigRequest> PARSER;
        private Internal.ProtobufList<String> groups_ = GeneratedMessageLite.emptyProtobufList();

        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        public static final class Builder extends GeneratedMessageLite.Builder<ProtoMucConfigRequest, Builder> implements ProtoMucConfigRequestOrBuilder {
            public Builder addAllGroups(Iterable<String> iterable) {
                copyOnWrite();
                ((ProtoMucConfigRequest) this.instance).addAllGroups(iterable);
                return this;
            }

            public Builder addGroups(String str) {
                copyOnWrite();
                ((ProtoMucConfigRequest) this.instance).addGroups(str);
                return this;
            }

            public Builder addGroupsBytes(ByteString byteString) {
                copyOnWrite();
                ((ProtoMucConfigRequest) this.instance).addGroupsBytes(byteString);
                return this;
            }

            public Builder clearGroups() {
                copyOnWrite();
                ((ProtoMucConfigRequest) this.instance).clearGroups();
                return this;
            }

            @Override // cu.todus.proto.ApiProto.ProtoMucConfigRequestOrBuilder
            public String getGroups(int i10) {
                return ((ProtoMucConfigRequest) this.instance).getGroups(i10);
            }

            @Override // cu.todus.proto.ApiProto.ProtoMucConfigRequestOrBuilder
            public ByteString getGroupsBytes(int i10) {
                return ((ProtoMucConfigRequest) this.instance).getGroupsBytes(i10);
            }

            @Override // cu.todus.proto.ApiProto.ProtoMucConfigRequestOrBuilder
            public int getGroupsCount() {
                return ((ProtoMucConfigRequest) this.instance).getGroupsCount();
            }

            @Override // cu.todus.proto.ApiProto.ProtoMucConfigRequestOrBuilder
            public List<String> getGroupsList() {
                return DesugarCollections.unmodifiableList(((ProtoMucConfigRequest) this.instance).getGroupsList());
            }

            public Builder setGroups(int i10, String str) {
                copyOnWrite();
                ((ProtoMucConfigRequest) this.instance).setGroups(i10, str);
                return this;
            }

            private Builder() {
                super(ProtoMucConfigRequest.DEFAULT_INSTANCE);
            }
        }

        static {
            ProtoMucConfigRequest protoMucConfigRequest = new ProtoMucConfigRequest();
            DEFAULT_INSTANCE = protoMucConfigRequest;
            GeneratedMessageLite.registerDefaultInstance(ProtoMucConfigRequest.class, protoMucConfigRequest);
        }

        private ProtoMucConfigRequest() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllGroups(Iterable<String> iterable) {
            ensureGroupsIsMutable();
            AbstractMessageLite.addAll((Iterable) iterable, (List) this.groups_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addGroups(String str) {
            str.getClass();
            ensureGroupsIsMutable();
            this.groups_.add(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addGroupsBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            ensureGroupsIsMutable();
            this.groups_.add(byteString.toStringUtf8());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearGroups() {
            this.groups_ = GeneratedMessageLite.emptyProtobufList();
        }

        private void ensureGroupsIsMutable() {
            Internal.ProtobufList<String> protobufList = this.groups_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.groups_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        public static ProtoMucConfigRequest getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static ProtoMucConfigRequest parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (ProtoMucConfigRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ProtoMucConfigRequest parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (ProtoMucConfigRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser<ProtoMucConfigRequest> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setGroups(int i10, String str) {
            str.getClass();
            ensureGroupsIsMutable();
            this.groups_.set(i10, str);
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new ProtoMucConfigRequest();
                case 2:
                    return new Builder();
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001Ț", new Object[]{"groups_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<ProtoMucConfigRequest> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (ProtoMucConfigRequest.class) {
                        try {
                            defaultInstanceBasedParser = PARSER;
                            if (defaultInstanceBasedParser == null) {
                                defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                                PARSER = defaultInstanceBasedParser;
                            }
                        } catch (Throwable th2) {
                            throw th2;
                        }
                        break;
                    }
                    return defaultInstanceBasedParser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        @Override // cu.todus.proto.ApiProto.ProtoMucConfigRequestOrBuilder
        public String getGroups(int i10) {
            return this.groups_.get(i10);
        }

        @Override // cu.todus.proto.ApiProto.ProtoMucConfigRequestOrBuilder
        public ByteString getGroupsBytes(int i10) {
            return ByteString.copyFromUtf8(this.groups_.get(i10));
        }

        @Override // cu.todus.proto.ApiProto.ProtoMucConfigRequestOrBuilder
        public int getGroupsCount() {
            return this.groups_.size();
        }

        @Override // cu.todus.proto.ApiProto.ProtoMucConfigRequestOrBuilder
        public List<String> getGroupsList() {
            return this.groups_;
        }

        public static Builder newBuilder(ProtoMucConfigRequest protoMucConfigRequest) {
            return DEFAULT_INSTANCE.createBuilder(protoMucConfigRequest);
        }

        public static ProtoMucConfigRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ProtoMucConfigRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ProtoMucConfigRequest parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ProtoMucConfigRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static ProtoMucConfigRequest parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (ProtoMucConfigRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static ProtoMucConfigRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ProtoMucConfigRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static ProtoMucConfigRequest parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (ProtoMucConfigRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static ProtoMucConfigRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ProtoMucConfigRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static ProtoMucConfigRequest parseFrom(InputStream inputStream) throws IOException {
            return (ProtoMucConfigRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ProtoMucConfigRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ProtoMucConfigRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ProtoMucConfigRequest parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (ProtoMucConfigRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static ProtoMucConfigRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ProtoMucConfigRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    public interface ProtoMucConfigRequestOrBuilder extends MessageLiteOrBuilder {
        String getGroups(int i10);

        ByteString getGroupsBytes(int i10);

        int getGroupsCount();

        List<String> getGroupsList();
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    public static final class ProtoMucConfigResponse extends GeneratedMessageLite<ProtoMucConfigResponse, Builder> implements ProtoMucConfigResponseOrBuilder {
        private static final ProtoMucConfigResponse DEFAULT_INSTANCE;
        private static volatile Parser<ProtoMucConfigResponse> PARSER = null;
        public static final int PROTOMUCINFORESPONSE_FIELD_NUMBER = 2;
        public static final int SUCCESS_FIELD_NUMBER = 1;
        private Internal.ProtobufList<ProtoMucInfo> protoMucInfoResponse_ = GeneratedMessageLite.emptyProtobufList();
        private boolean success_;

        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        public static final class Builder extends GeneratedMessageLite.Builder<ProtoMucConfigResponse, Builder> implements ProtoMucConfigResponseOrBuilder {
            public Builder addAllProtoMucInfoResponse(Iterable<? extends ProtoMucInfo> iterable) {
                copyOnWrite();
                ((ProtoMucConfigResponse) this.instance).addAllProtoMucInfoResponse(iterable);
                return this;
            }

            public Builder addProtoMucInfoResponse(ProtoMucInfo protoMucInfo) {
                copyOnWrite();
                ((ProtoMucConfigResponse) this.instance).addProtoMucInfoResponse(protoMucInfo);
                return this;
            }

            public Builder clearProtoMucInfoResponse() {
                copyOnWrite();
                ((ProtoMucConfigResponse) this.instance).clearProtoMucInfoResponse();
                return this;
            }

            public Builder clearSuccess() {
                copyOnWrite();
                ((ProtoMucConfigResponse) this.instance).clearSuccess();
                return this;
            }

            @Override // cu.todus.proto.ApiProto.ProtoMucConfigResponseOrBuilder
            public ProtoMucInfo getProtoMucInfoResponse(int i10) {
                return ((ProtoMucConfigResponse) this.instance).getProtoMucInfoResponse(i10);
            }

            @Override // cu.todus.proto.ApiProto.ProtoMucConfigResponseOrBuilder
            public int getProtoMucInfoResponseCount() {
                return ((ProtoMucConfigResponse) this.instance).getProtoMucInfoResponseCount();
            }

            @Override // cu.todus.proto.ApiProto.ProtoMucConfigResponseOrBuilder
            public List<ProtoMucInfo> getProtoMucInfoResponseList() {
                return DesugarCollections.unmodifiableList(((ProtoMucConfigResponse) this.instance).getProtoMucInfoResponseList());
            }

            @Override // cu.todus.proto.ApiProto.ProtoMucConfigResponseOrBuilder
            public boolean getSuccess() {
                return ((ProtoMucConfigResponse) this.instance).getSuccess();
            }

            public Builder removeProtoMucInfoResponse(int i10) {
                copyOnWrite();
                ((ProtoMucConfigResponse) this.instance).removeProtoMucInfoResponse(i10);
                return this;
            }

            public Builder setProtoMucInfoResponse(int i10, ProtoMucInfo protoMucInfo) {
                copyOnWrite();
                ((ProtoMucConfigResponse) this.instance).setProtoMucInfoResponse(i10, protoMucInfo);
                return this;
            }

            public Builder setSuccess(boolean z10) {
                copyOnWrite();
                ((ProtoMucConfigResponse) this.instance).setSuccess(z10);
                return this;
            }

            private Builder() {
                super(ProtoMucConfigResponse.DEFAULT_INSTANCE);
            }

            public Builder addProtoMucInfoResponse(int i10, ProtoMucInfo protoMucInfo) {
                copyOnWrite();
                ((ProtoMucConfigResponse) this.instance).addProtoMucInfoResponse(i10, protoMucInfo);
                return this;
            }

            public Builder setProtoMucInfoResponse(int i10, ProtoMucInfo.Builder builder) {
                copyOnWrite();
                ((ProtoMucConfigResponse) this.instance).setProtoMucInfoResponse(i10, builder.build());
                return this;
            }

            public Builder addProtoMucInfoResponse(ProtoMucInfo.Builder builder) {
                copyOnWrite();
                ((ProtoMucConfigResponse) this.instance).addProtoMucInfoResponse(builder.build());
                return this;
            }

            public Builder addProtoMucInfoResponse(int i10, ProtoMucInfo.Builder builder) {
                copyOnWrite();
                ((ProtoMucConfigResponse) this.instance).addProtoMucInfoResponse(i10, builder.build());
                return this;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        public static final class ProtoMucInfo extends GeneratedMessageLite<ProtoMucInfo, Builder> implements ProtoMucInfoOrBuilder {
            public static final int AFF_FIELD_NUMBER = 3;
            public static final int CONFIG_FIELD_NUMBER = 4;
            private static final ProtoMucInfo DEFAULT_INSTANCE;
            public static final int MUCID_FIELD_NUMBER = 1;
            private static volatile Parser<ProtoMucInfo> PARSER = null;
            public static final int VERSION_FIELD_NUMBER = 2;
            private MapFieldLite<String, String> aff_ = MapFieldLite.emptyMapField();
            private MapFieldLite<String, String> config_ = MapFieldLite.emptyMapField();
            private String mucId_ = "";
            private String version_ = "";

            /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
            public static final class AffDefaultEntryHolder {
                static final MapEntryLite<String, String> defaultEntry;

                static {
                    WireFormat.FieldType fieldType = WireFormat.FieldType.STRING;
                    defaultEntry = MapEntryLite.newDefaultInstance(fieldType, "", fieldType, "");
                }

                private AffDefaultEntryHolder() {
                }
            }

            /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
            public static final class Builder extends GeneratedMessageLite.Builder<ProtoMucInfo, Builder> implements ProtoMucInfoOrBuilder {
                public Builder clearAff() {
                    copyOnWrite();
                    ((ProtoMucInfo) this.instance).getMutableAffMap().clear();
                    return this;
                }

                public Builder clearConfig() {
                    copyOnWrite();
                    ((ProtoMucInfo) this.instance).getMutableConfigMap().clear();
                    return this;
                }

                public Builder clearMucId() {
                    copyOnWrite();
                    ((ProtoMucInfo) this.instance).clearMucId();
                    return this;
                }

                public Builder clearVersion() {
                    copyOnWrite();
                    ((ProtoMucInfo) this.instance).clearVersion();
                    return this;
                }

                @Override // cu.todus.proto.ApiProto.ProtoMucConfigResponse.ProtoMucInfoOrBuilder
                public boolean containsAff(String str) {
                    str.getClass();
                    return ((ProtoMucInfo) this.instance).getAffMap().containsKey(str);
                }

                @Override // cu.todus.proto.ApiProto.ProtoMucConfigResponse.ProtoMucInfoOrBuilder
                public boolean containsConfig(String str) {
                    str.getClass();
                    return ((ProtoMucInfo) this.instance).getConfigMap().containsKey(str);
                }

                @Override // cu.todus.proto.ApiProto.ProtoMucConfigResponse.ProtoMucInfoOrBuilder
                @Deprecated
                public Map<String, String> getAff() {
                    return getAffMap();
                }

                @Override // cu.todus.proto.ApiProto.ProtoMucConfigResponse.ProtoMucInfoOrBuilder
                public int getAffCount() {
                    return ((ProtoMucInfo) this.instance).getAffMap().size();
                }

                @Override // cu.todus.proto.ApiProto.ProtoMucConfigResponse.ProtoMucInfoOrBuilder
                public Map<String, String> getAffMap() {
                    return DesugarCollections.unmodifiableMap(((ProtoMucInfo) this.instance).getAffMap());
                }

                @Override // cu.todus.proto.ApiProto.ProtoMucConfigResponse.ProtoMucInfoOrBuilder
                public String getAffOrDefault(String str, String str2) {
                    str.getClass();
                    Map<String, String> affMap = ((ProtoMucInfo) this.instance).getAffMap();
                    return affMap.containsKey(str) ? affMap.get(str) : str2;
                }

                @Override // cu.todus.proto.ApiProto.ProtoMucConfigResponse.ProtoMucInfoOrBuilder
                public String getAffOrThrow(String str) {
                    str.getClass();
                    Map<String, String> affMap = ((ProtoMucInfo) this.instance).getAffMap();
                    if (affMap.containsKey(str)) {
                        return affMap.get(str);
                    }
                    throw new IllegalArgumentException();
                }

                @Override // cu.todus.proto.ApiProto.ProtoMucConfigResponse.ProtoMucInfoOrBuilder
                @Deprecated
                public Map<String, String> getConfig() {
                    return getConfigMap();
                }

                @Override // cu.todus.proto.ApiProto.ProtoMucConfigResponse.ProtoMucInfoOrBuilder
                public int getConfigCount() {
                    return ((ProtoMucInfo) this.instance).getConfigMap().size();
                }

                @Override // cu.todus.proto.ApiProto.ProtoMucConfigResponse.ProtoMucInfoOrBuilder
                public Map<String, String> getConfigMap() {
                    return DesugarCollections.unmodifiableMap(((ProtoMucInfo) this.instance).getConfigMap());
                }

                @Override // cu.todus.proto.ApiProto.ProtoMucConfigResponse.ProtoMucInfoOrBuilder
                public String getConfigOrDefault(String str, String str2) {
                    str.getClass();
                    Map<String, String> configMap = ((ProtoMucInfo) this.instance).getConfigMap();
                    return configMap.containsKey(str) ? configMap.get(str) : str2;
                }

                @Override // cu.todus.proto.ApiProto.ProtoMucConfigResponse.ProtoMucInfoOrBuilder
                public String getConfigOrThrow(String str) {
                    str.getClass();
                    Map<String, String> configMap = ((ProtoMucInfo) this.instance).getConfigMap();
                    if (configMap.containsKey(str)) {
                        return configMap.get(str);
                    }
                    throw new IllegalArgumentException();
                }

                @Override // cu.todus.proto.ApiProto.ProtoMucConfigResponse.ProtoMucInfoOrBuilder
                public String getMucId() {
                    return ((ProtoMucInfo) this.instance).getMucId();
                }

                @Override // cu.todus.proto.ApiProto.ProtoMucConfigResponse.ProtoMucInfoOrBuilder
                public ByteString getMucIdBytes() {
                    return ((ProtoMucInfo) this.instance).getMucIdBytes();
                }

                @Override // cu.todus.proto.ApiProto.ProtoMucConfigResponse.ProtoMucInfoOrBuilder
                public String getVersion() {
                    return ((ProtoMucInfo) this.instance).getVersion();
                }

                @Override // cu.todus.proto.ApiProto.ProtoMucConfigResponse.ProtoMucInfoOrBuilder
                public ByteString getVersionBytes() {
                    return ((ProtoMucInfo) this.instance).getVersionBytes();
                }

                public Builder putAff(String str, String str2) {
                    str.getClass();
                    str2.getClass();
                    copyOnWrite();
                    ((ProtoMucInfo) this.instance).getMutableAffMap().put(str, str2);
                    return this;
                }

                public Builder putAllAff(Map<String, String> map) {
                    copyOnWrite();
                    ((ProtoMucInfo) this.instance).getMutableAffMap().putAll(map);
                    return this;
                }

                public Builder putAllConfig(Map<String, String> map) {
                    copyOnWrite();
                    ((ProtoMucInfo) this.instance).getMutableConfigMap().putAll(map);
                    return this;
                }

                public Builder putConfig(String str, String str2) {
                    str.getClass();
                    str2.getClass();
                    copyOnWrite();
                    ((ProtoMucInfo) this.instance).getMutableConfigMap().put(str, str2);
                    return this;
                }

                public Builder removeAff(String str) {
                    str.getClass();
                    copyOnWrite();
                    ((ProtoMucInfo) this.instance).getMutableAffMap().remove(str);
                    return this;
                }

                public Builder removeConfig(String str) {
                    str.getClass();
                    copyOnWrite();
                    ((ProtoMucInfo) this.instance).getMutableConfigMap().remove(str);
                    return this;
                }

                public Builder setMucId(String str) {
                    copyOnWrite();
                    ((ProtoMucInfo) this.instance).setMucId(str);
                    return this;
                }

                public Builder setMucIdBytes(ByteString byteString) {
                    copyOnWrite();
                    ((ProtoMucInfo) this.instance).setMucIdBytes(byteString);
                    return this;
                }

                public Builder setVersion(String str) {
                    copyOnWrite();
                    ((ProtoMucInfo) this.instance).setVersion(str);
                    return this;
                }

                public Builder setVersionBytes(ByteString byteString) {
                    copyOnWrite();
                    ((ProtoMucInfo) this.instance).setVersionBytes(byteString);
                    return this;
                }

                private Builder() {
                    super(ProtoMucInfo.DEFAULT_INSTANCE);
                }
            }

            /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
            public static final class ConfigDefaultEntryHolder {
                static final MapEntryLite<String, String> defaultEntry;

                static {
                    WireFormat.FieldType fieldType = WireFormat.FieldType.STRING;
                    defaultEntry = MapEntryLite.newDefaultInstance(fieldType, "", fieldType, "");
                }

                private ConfigDefaultEntryHolder() {
                }
            }

            static {
                ProtoMucInfo protoMucInfo = new ProtoMucInfo();
                DEFAULT_INSTANCE = protoMucInfo;
                GeneratedMessageLite.registerDefaultInstance(ProtoMucInfo.class, protoMucInfo);
            }

            private ProtoMucInfo() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearMucId() {
                this.mucId_ = getDefaultInstance().getMucId();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearVersion() {
                this.version_ = getDefaultInstance().getVersion();
            }

            public static ProtoMucInfo getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public Map<String, String> getMutableAffMap() {
                return internalGetMutableAff();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public Map<String, String> getMutableConfigMap() {
                return internalGetMutableConfig();
            }

            private MapFieldLite<String, String> internalGetAff() {
                return this.aff_;
            }

            private MapFieldLite<String, String> internalGetConfig() {
                return this.config_;
            }

            private MapFieldLite<String, String> internalGetMutableAff() {
                if (!this.aff_.isMutable()) {
                    this.aff_ = this.aff_.mutableCopy();
                }
                return this.aff_;
            }

            private MapFieldLite<String, String> internalGetMutableConfig() {
                if (!this.config_.isMutable()) {
                    this.config_ = this.config_.mutableCopy();
                }
                return this.config_;
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.createBuilder();
            }

            public static ProtoMucInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
                return (ProtoMucInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static ProtoMucInfo parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
                return (ProtoMucInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
            }

            public static Parser<ProtoMucInfo> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setMucId(String str) {
                str.getClass();
                this.mucId_ = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setMucIdBytes(ByteString byteString) {
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.mucId_ = byteString.toStringUtf8();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setVersion(String str) {
                str.getClass();
                this.version_ = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setVersionBytes(ByteString byteString) {
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.version_ = byteString.toStringUtf8();
            }

            @Override // cu.todus.proto.ApiProto.ProtoMucConfigResponse.ProtoMucInfoOrBuilder
            public boolean containsAff(String str) {
                str.getClass();
                return internalGetAff().containsKey(str);
            }

            @Override // cu.todus.proto.ApiProto.ProtoMucConfigResponse.ProtoMucInfoOrBuilder
            public boolean containsConfig(String str) {
                str.getClass();
                return internalGetConfig().containsKey(str);
            }

            @Override // com.google.protobuf.GeneratedMessageLite
            public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                Parser defaultInstanceBasedParser;
                switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                    case 1:
                        return new ProtoMucInfo();
                    case 2:
                        return new Builder();
                    case 3:
                        return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0002\u0000\u0000\u0001Ȉ\u0002Ȉ\u00032\u00042", new Object[]{"mucId_", "version_", "aff_", AffDefaultEntryHolder.defaultEntry, "config_", ConfigDefaultEntryHolder.defaultEntry});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        Parser<ProtoMucInfo> parser = PARSER;
                        if (parser != null) {
                            return parser;
                        }
                        synchronized (ProtoMucInfo.class) {
                            try {
                                defaultInstanceBasedParser = PARSER;
                                if (defaultInstanceBasedParser == null) {
                                    defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                                    PARSER = defaultInstanceBasedParser;
                                }
                            } catch (Throwable th2) {
                                throw th2;
                            }
                            break;
                        }
                        return defaultInstanceBasedParser;
                    case 6:
                        return (byte) 1;
                    case 7:
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }

            @Override // cu.todus.proto.ApiProto.ProtoMucConfigResponse.ProtoMucInfoOrBuilder
            @Deprecated
            public Map<String, String> getAff() {
                return getAffMap();
            }

            @Override // cu.todus.proto.ApiProto.ProtoMucConfigResponse.ProtoMucInfoOrBuilder
            public int getAffCount() {
                return internalGetAff().size();
            }

            @Override // cu.todus.proto.ApiProto.ProtoMucConfigResponse.ProtoMucInfoOrBuilder
            public Map<String, String> getAffMap() {
                return DesugarCollections.unmodifiableMap(internalGetAff());
            }

            @Override // cu.todus.proto.ApiProto.ProtoMucConfigResponse.ProtoMucInfoOrBuilder
            public String getAffOrDefault(String str, String str2) {
                str.getClass();
                MapFieldLite<String, String> mapFieldLiteInternalGetAff = internalGetAff();
                return mapFieldLiteInternalGetAff.containsKey(str) ? mapFieldLiteInternalGetAff.get(str) : str2;
            }

            @Override // cu.todus.proto.ApiProto.ProtoMucConfigResponse.ProtoMucInfoOrBuilder
            public String getAffOrThrow(String str) {
                str.getClass();
                MapFieldLite<String, String> mapFieldLiteInternalGetAff = internalGetAff();
                if (mapFieldLiteInternalGetAff.containsKey(str)) {
                    return mapFieldLiteInternalGetAff.get(str);
                }
                throw new IllegalArgumentException();
            }

            @Override // cu.todus.proto.ApiProto.ProtoMucConfigResponse.ProtoMucInfoOrBuilder
            @Deprecated
            public Map<String, String> getConfig() {
                return getConfigMap();
            }

            @Override // cu.todus.proto.ApiProto.ProtoMucConfigResponse.ProtoMucInfoOrBuilder
            public int getConfigCount() {
                return internalGetConfig().size();
            }

            @Override // cu.todus.proto.ApiProto.ProtoMucConfigResponse.ProtoMucInfoOrBuilder
            public Map<String, String> getConfigMap() {
                return DesugarCollections.unmodifiableMap(internalGetConfig());
            }

            @Override // cu.todus.proto.ApiProto.ProtoMucConfigResponse.ProtoMucInfoOrBuilder
            public String getConfigOrDefault(String str, String str2) {
                str.getClass();
                MapFieldLite<String, String> mapFieldLiteInternalGetConfig = internalGetConfig();
                return mapFieldLiteInternalGetConfig.containsKey(str) ? mapFieldLiteInternalGetConfig.get(str) : str2;
            }

            @Override // cu.todus.proto.ApiProto.ProtoMucConfigResponse.ProtoMucInfoOrBuilder
            public String getConfigOrThrow(String str) {
                str.getClass();
                MapFieldLite<String, String> mapFieldLiteInternalGetConfig = internalGetConfig();
                if (mapFieldLiteInternalGetConfig.containsKey(str)) {
                    return mapFieldLiteInternalGetConfig.get(str);
                }
                throw new IllegalArgumentException();
            }

            @Override // cu.todus.proto.ApiProto.ProtoMucConfigResponse.ProtoMucInfoOrBuilder
            public String getMucId() {
                return this.mucId_;
            }

            @Override // cu.todus.proto.ApiProto.ProtoMucConfigResponse.ProtoMucInfoOrBuilder
            public ByteString getMucIdBytes() {
                return ByteString.copyFromUtf8(this.mucId_);
            }

            @Override // cu.todus.proto.ApiProto.ProtoMucConfigResponse.ProtoMucInfoOrBuilder
            public String getVersion() {
                return this.version_;
            }

            @Override // cu.todus.proto.ApiProto.ProtoMucConfigResponse.ProtoMucInfoOrBuilder
            public ByteString getVersionBytes() {
                return ByteString.copyFromUtf8(this.version_);
            }

            public static Builder newBuilder(ProtoMucInfo protoMucInfo) {
                return DEFAULT_INSTANCE.createBuilder(protoMucInfo);
            }

            public static ProtoMucInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (ProtoMucInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static ProtoMucInfo parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (ProtoMucInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
            }

            public static ProtoMucInfo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                return (ProtoMucInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
            }

            public static ProtoMucInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (ProtoMucInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
            }

            public static ProtoMucInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                return (ProtoMucInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
            }

            public static ProtoMucInfo parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (ProtoMucInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
            }

            public static ProtoMucInfo parseFrom(InputStream inputStream) throws IOException {
                return (ProtoMucInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static ProtoMucInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (ProtoMucInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static ProtoMucInfo parseFrom(CodedInputStream codedInputStream) throws IOException {
                return (ProtoMucInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
            }

            public static ProtoMucInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (ProtoMucInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        public interface ProtoMucInfoOrBuilder extends MessageLiteOrBuilder {
            boolean containsAff(String str);

            boolean containsConfig(String str);

            @Deprecated
            Map<String, String> getAff();

            int getAffCount();

            Map<String, String> getAffMap();

            String getAffOrDefault(String str, String str2);

            String getAffOrThrow(String str);

            @Deprecated
            Map<String, String> getConfig();

            int getConfigCount();

            Map<String, String> getConfigMap();

            String getConfigOrDefault(String str, String str2);

            String getConfigOrThrow(String str);

            String getMucId();

            ByteString getMucIdBytes();

            String getVersion();

            ByteString getVersionBytes();
        }

        static {
            ProtoMucConfigResponse protoMucConfigResponse = new ProtoMucConfigResponse();
            DEFAULT_INSTANCE = protoMucConfigResponse;
            GeneratedMessageLite.registerDefaultInstance(ProtoMucConfigResponse.class, protoMucConfigResponse);
        }

        private ProtoMucConfigResponse() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllProtoMucInfoResponse(Iterable<? extends ProtoMucInfo> iterable) {
            ensureProtoMucInfoResponseIsMutable();
            AbstractMessageLite.addAll((Iterable) iterable, (List) this.protoMucInfoResponse_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addProtoMucInfoResponse(ProtoMucInfo protoMucInfo) {
            protoMucInfo.getClass();
            ensureProtoMucInfoResponseIsMutable();
            this.protoMucInfoResponse_.add(protoMucInfo);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearProtoMucInfoResponse() {
            this.protoMucInfoResponse_ = GeneratedMessageLite.emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSuccess() {
            this.success_ = false;
        }

        private void ensureProtoMucInfoResponseIsMutable() {
            Internal.ProtobufList<ProtoMucInfo> protobufList = this.protoMucInfoResponse_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.protoMucInfoResponse_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        public static ProtoMucConfigResponse getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static ProtoMucConfigResponse parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (ProtoMucConfigResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ProtoMucConfigResponse parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (ProtoMucConfigResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser<ProtoMucConfigResponse> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeProtoMucInfoResponse(int i10) {
            ensureProtoMucInfoResponseIsMutable();
            this.protoMucInfoResponse_.remove(i10);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setProtoMucInfoResponse(int i10, ProtoMucInfo protoMucInfo) {
            protoMucInfo.getClass();
            ensureProtoMucInfoResponseIsMutable();
            this.protoMucInfoResponse_.set(i10, protoMucInfo);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSuccess(boolean z10) {
            this.success_ = z10;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new ProtoMucConfigResponse();
                case 2:
                    return new Builder();
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u0007\u0002\u001b", new Object[]{"success_", "protoMucInfoResponse_", ProtoMucInfo.class});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<ProtoMucConfigResponse> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (ProtoMucConfigResponse.class) {
                        try {
                            defaultInstanceBasedParser = PARSER;
                            if (defaultInstanceBasedParser == null) {
                                defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                                PARSER = defaultInstanceBasedParser;
                            }
                        } catch (Throwable th2) {
                            throw th2;
                        }
                        break;
                    }
                    return defaultInstanceBasedParser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        @Override // cu.todus.proto.ApiProto.ProtoMucConfigResponseOrBuilder
        public ProtoMucInfo getProtoMucInfoResponse(int i10) {
            return this.protoMucInfoResponse_.get(i10);
        }

        @Override // cu.todus.proto.ApiProto.ProtoMucConfigResponseOrBuilder
        public int getProtoMucInfoResponseCount() {
            return this.protoMucInfoResponse_.size();
        }

        @Override // cu.todus.proto.ApiProto.ProtoMucConfigResponseOrBuilder
        public List<ProtoMucInfo> getProtoMucInfoResponseList() {
            return this.protoMucInfoResponse_;
        }

        public ProtoMucInfoOrBuilder getProtoMucInfoResponseOrBuilder(int i10) {
            return this.protoMucInfoResponse_.get(i10);
        }

        public List<? extends ProtoMucInfoOrBuilder> getProtoMucInfoResponseOrBuilderList() {
            return this.protoMucInfoResponse_;
        }

        @Override // cu.todus.proto.ApiProto.ProtoMucConfigResponseOrBuilder
        public boolean getSuccess() {
            return this.success_;
        }

        public static Builder newBuilder(ProtoMucConfigResponse protoMucConfigResponse) {
            return DEFAULT_INSTANCE.createBuilder(protoMucConfigResponse);
        }

        public static ProtoMucConfigResponse parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ProtoMucConfigResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ProtoMucConfigResponse parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ProtoMucConfigResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static ProtoMucConfigResponse parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (ProtoMucConfigResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addProtoMucInfoResponse(int i10, ProtoMucInfo protoMucInfo) {
            protoMucInfo.getClass();
            ensureProtoMucInfoResponseIsMutable();
            this.protoMucInfoResponse_.add(i10, protoMucInfo);
        }

        public static ProtoMucConfigResponse parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ProtoMucConfigResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static ProtoMucConfigResponse parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (ProtoMucConfigResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static ProtoMucConfigResponse parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ProtoMucConfigResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static ProtoMucConfigResponse parseFrom(InputStream inputStream) throws IOException {
            return (ProtoMucConfigResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ProtoMucConfigResponse parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ProtoMucConfigResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ProtoMucConfigResponse parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (ProtoMucConfigResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static ProtoMucConfigResponse parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ProtoMucConfigResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    public interface ProtoMucConfigResponseOrBuilder extends MessageLiteOrBuilder {
        ProtoMucConfigResponse.ProtoMucInfo getProtoMucInfoResponse(int i10);

        int getProtoMucInfoResponseCount();

        List<ProtoMucConfigResponse.ProtoMucInfo> getProtoMucInfoResponseList();

        boolean getSuccess();
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    public static final class ProtoMucInfoRequest extends GeneratedMessageLite<ProtoMucInfoRequest, Builder> implements ProtoMucInfoRequestOrBuilder {
        private static final ProtoMucInfoRequest DEFAULT_INSTANCE;
        public static final int GROUPS_FIELD_NUMBER = 1;
        private static volatile Parser<ProtoMucInfoRequest> PARSER;
        private Internal.ProtobufList<String> groups_ = GeneratedMessageLite.emptyProtobufList();

        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        public static final class Builder extends GeneratedMessageLite.Builder<ProtoMucInfoRequest, Builder> implements ProtoMucInfoRequestOrBuilder {
            public Builder addAllGroups(Iterable<String> iterable) {
                copyOnWrite();
                ((ProtoMucInfoRequest) this.instance).addAllGroups(iterable);
                return this;
            }

            public Builder addGroups(String str) {
                copyOnWrite();
                ((ProtoMucInfoRequest) this.instance).addGroups(str);
                return this;
            }

            public Builder addGroupsBytes(ByteString byteString) {
                copyOnWrite();
                ((ProtoMucInfoRequest) this.instance).addGroupsBytes(byteString);
                return this;
            }

            public Builder clearGroups() {
                copyOnWrite();
                ((ProtoMucInfoRequest) this.instance).clearGroups();
                return this;
            }

            @Override // cu.todus.proto.ApiProto.ProtoMucInfoRequestOrBuilder
            public String getGroups(int i10) {
                return ((ProtoMucInfoRequest) this.instance).getGroups(i10);
            }

            @Override // cu.todus.proto.ApiProto.ProtoMucInfoRequestOrBuilder
            public ByteString getGroupsBytes(int i10) {
                return ((ProtoMucInfoRequest) this.instance).getGroupsBytes(i10);
            }

            @Override // cu.todus.proto.ApiProto.ProtoMucInfoRequestOrBuilder
            public int getGroupsCount() {
                return ((ProtoMucInfoRequest) this.instance).getGroupsCount();
            }

            @Override // cu.todus.proto.ApiProto.ProtoMucInfoRequestOrBuilder
            public List<String> getGroupsList() {
                return DesugarCollections.unmodifiableList(((ProtoMucInfoRequest) this.instance).getGroupsList());
            }

            public Builder setGroups(int i10, String str) {
                copyOnWrite();
                ((ProtoMucInfoRequest) this.instance).setGroups(i10, str);
                return this;
            }

            private Builder() {
                super(ProtoMucInfoRequest.DEFAULT_INSTANCE);
            }
        }

        static {
            ProtoMucInfoRequest protoMucInfoRequest = new ProtoMucInfoRequest();
            DEFAULT_INSTANCE = protoMucInfoRequest;
            GeneratedMessageLite.registerDefaultInstance(ProtoMucInfoRequest.class, protoMucInfoRequest);
        }

        private ProtoMucInfoRequest() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllGroups(Iterable<String> iterable) {
            ensureGroupsIsMutable();
            AbstractMessageLite.addAll((Iterable) iterable, (List) this.groups_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addGroups(String str) {
            str.getClass();
            ensureGroupsIsMutable();
            this.groups_.add(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addGroupsBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            ensureGroupsIsMutable();
            this.groups_.add(byteString.toStringUtf8());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearGroups() {
            this.groups_ = GeneratedMessageLite.emptyProtobufList();
        }

        private void ensureGroupsIsMutable() {
            Internal.ProtobufList<String> protobufList = this.groups_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.groups_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        public static ProtoMucInfoRequest getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static ProtoMucInfoRequest parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (ProtoMucInfoRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ProtoMucInfoRequest parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (ProtoMucInfoRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser<ProtoMucInfoRequest> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setGroups(int i10, String str) {
            str.getClass();
            ensureGroupsIsMutable();
            this.groups_.set(i10, str);
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new ProtoMucInfoRequest();
                case 2:
                    return new Builder();
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001Ț", new Object[]{"groups_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<ProtoMucInfoRequest> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (ProtoMucInfoRequest.class) {
                        try {
                            defaultInstanceBasedParser = PARSER;
                            if (defaultInstanceBasedParser == null) {
                                defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                                PARSER = defaultInstanceBasedParser;
                            }
                        } catch (Throwable th2) {
                            throw th2;
                        }
                        break;
                    }
                    return defaultInstanceBasedParser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        @Override // cu.todus.proto.ApiProto.ProtoMucInfoRequestOrBuilder
        public String getGroups(int i10) {
            return this.groups_.get(i10);
        }

        @Override // cu.todus.proto.ApiProto.ProtoMucInfoRequestOrBuilder
        public ByteString getGroupsBytes(int i10) {
            return ByteString.copyFromUtf8(this.groups_.get(i10));
        }

        @Override // cu.todus.proto.ApiProto.ProtoMucInfoRequestOrBuilder
        public int getGroupsCount() {
            return this.groups_.size();
        }

        @Override // cu.todus.proto.ApiProto.ProtoMucInfoRequestOrBuilder
        public List<String> getGroupsList() {
            return this.groups_;
        }

        public static Builder newBuilder(ProtoMucInfoRequest protoMucInfoRequest) {
            return DEFAULT_INSTANCE.createBuilder(protoMucInfoRequest);
        }

        public static ProtoMucInfoRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ProtoMucInfoRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ProtoMucInfoRequest parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ProtoMucInfoRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static ProtoMucInfoRequest parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (ProtoMucInfoRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static ProtoMucInfoRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ProtoMucInfoRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static ProtoMucInfoRequest parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (ProtoMucInfoRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static ProtoMucInfoRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ProtoMucInfoRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static ProtoMucInfoRequest parseFrom(InputStream inputStream) throws IOException {
            return (ProtoMucInfoRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ProtoMucInfoRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ProtoMucInfoRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ProtoMucInfoRequest parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (ProtoMucInfoRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static ProtoMucInfoRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ProtoMucInfoRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    public interface ProtoMucInfoRequestOrBuilder extends MessageLiteOrBuilder {
        String getGroups(int i10);

        ByteString getGroupsBytes(int i10);

        int getGroupsCount();

        List<String> getGroupsList();
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    public static final class ProtoMucInfoResponse extends GeneratedMessageLite<ProtoMucInfoResponse, Builder> implements ProtoMucInfoResponseOrBuilder {
        private static final ProtoMucInfoResponse DEFAULT_INSTANCE;
        public static final int MUCS_FIELD_NUMBER = 2;
        private static volatile Parser<ProtoMucInfoResponse> PARSER;
        private Internal.ProtobufList<ProtoMucInfo> mucs_ = GeneratedMessageLite.emptyProtobufList();

        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        public static final class Builder extends GeneratedMessageLite.Builder<ProtoMucInfoResponse, Builder> implements ProtoMucInfoResponseOrBuilder {
            public Builder addAllMucs(Iterable<? extends ProtoMucInfo> iterable) {
                copyOnWrite();
                ((ProtoMucInfoResponse) this.instance).addAllMucs(iterable);
                return this;
            }

            public Builder addMucs(ProtoMucInfo protoMucInfo) {
                copyOnWrite();
                ((ProtoMucInfoResponse) this.instance).addMucs(protoMucInfo);
                return this;
            }

            public Builder clearMucs() {
                copyOnWrite();
                ((ProtoMucInfoResponse) this.instance).clearMucs();
                return this;
            }

            @Override // cu.todus.proto.ApiProto.ProtoMucInfoResponseOrBuilder
            public ProtoMucInfo getMucs(int i10) {
                return ((ProtoMucInfoResponse) this.instance).getMucs(i10);
            }

            @Override // cu.todus.proto.ApiProto.ProtoMucInfoResponseOrBuilder
            public int getMucsCount() {
                return ((ProtoMucInfoResponse) this.instance).getMucsCount();
            }

            @Override // cu.todus.proto.ApiProto.ProtoMucInfoResponseOrBuilder
            public List<ProtoMucInfo> getMucsList() {
                return DesugarCollections.unmodifiableList(((ProtoMucInfoResponse) this.instance).getMucsList());
            }

            public Builder removeMucs(int i10) {
                copyOnWrite();
                ((ProtoMucInfoResponse) this.instance).removeMucs(i10);
                return this;
            }

            public Builder setMucs(int i10, ProtoMucInfo protoMucInfo) {
                copyOnWrite();
                ((ProtoMucInfoResponse) this.instance).setMucs(i10, protoMucInfo);
                return this;
            }

            private Builder() {
                super(ProtoMucInfoResponse.DEFAULT_INSTANCE);
            }

            public Builder addMucs(int i10, ProtoMucInfo protoMucInfo) {
                copyOnWrite();
                ((ProtoMucInfoResponse) this.instance).addMucs(i10, protoMucInfo);
                return this;
            }

            public Builder setMucs(int i10, ProtoMucInfo.Builder builder) {
                copyOnWrite();
                ((ProtoMucInfoResponse) this.instance).setMucs(i10, builder.build());
                return this;
            }

            public Builder addMucs(ProtoMucInfo.Builder builder) {
                copyOnWrite();
                ((ProtoMucInfoResponse) this.instance).addMucs(builder.build());
                return this;
            }

            public Builder addMucs(int i10, ProtoMucInfo.Builder builder) {
                copyOnWrite();
                ((ProtoMucInfoResponse) this.instance).addMucs(i10, builder.build());
                return this;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        public static final class ProtoMucInfo extends GeneratedMessageLite<ProtoMucInfo, Builder> implements ProtoMucInfoOrBuilder {
            public static final int CONFIG_FIELD_NUMBER = 4;
            private static final ProtoMucInfo DEFAULT_INSTANCE;
            public static final int MUCID_FIELD_NUMBER = 1;
            private static volatile Parser<ProtoMucInfo> PARSER = null;
            public static final int VERSION_FIELD_NUMBER = 2;
            private MapFieldLite<String, String> config_ = MapFieldLite.emptyMapField();
            private String mucId_ = "";
            private String version_ = "";

            /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
            public static final class Builder extends GeneratedMessageLite.Builder<ProtoMucInfo, Builder> implements ProtoMucInfoOrBuilder {
                public Builder clearConfig() {
                    copyOnWrite();
                    ((ProtoMucInfo) this.instance).getMutableConfigMap().clear();
                    return this;
                }

                public Builder clearMucId() {
                    copyOnWrite();
                    ((ProtoMucInfo) this.instance).clearMucId();
                    return this;
                }

                public Builder clearVersion() {
                    copyOnWrite();
                    ((ProtoMucInfo) this.instance).clearVersion();
                    return this;
                }

                @Override // cu.todus.proto.ApiProto.ProtoMucInfoResponse.ProtoMucInfoOrBuilder
                public boolean containsConfig(String str) {
                    str.getClass();
                    return ((ProtoMucInfo) this.instance).getConfigMap().containsKey(str);
                }

                @Override // cu.todus.proto.ApiProto.ProtoMucInfoResponse.ProtoMucInfoOrBuilder
                @Deprecated
                public Map<String, String> getConfig() {
                    return getConfigMap();
                }

                @Override // cu.todus.proto.ApiProto.ProtoMucInfoResponse.ProtoMucInfoOrBuilder
                public int getConfigCount() {
                    return ((ProtoMucInfo) this.instance).getConfigMap().size();
                }

                @Override // cu.todus.proto.ApiProto.ProtoMucInfoResponse.ProtoMucInfoOrBuilder
                public Map<String, String> getConfigMap() {
                    return DesugarCollections.unmodifiableMap(((ProtoMucInfo) this.instance).getConfigMap());
                }

                @Override // cu.todus.proto.ApiProto.ProtoMucInfoResponse.ProtoMucInfoOrBuilder
                public String getConfigOrDefault(String str, String str2) {
                    str.getClass();
                    Map<String, String> configMap = ((ProtoMucInfo) this.instance).getConfigMap();
                    return configMap.containsKey(str) ? configMap.get(str) : str2;
                }

                @Override // cu.todus.proto.ApiProto.ProtoMucInfoResponse.ProtoMucInfoOrBuilder
                public String getConfigOrThrow(String str) {
                    str.getClass();
                    Map<String, String> configMap = ((ProtoMucInfo) this.instance).getConfigMap();
                    if (configMap.containsKey(str)) {
                        return configMap.get(str);
                    }
                    throw new IllegalArgumentException();
                }

                @Override // cu.todus.proto.ApiProto.ProtoMucInfoResponse.ProtoMucInfoOrBuilder
                public String getMucId() {
                    return ((ProtoMucInfo) this.instance).getMucId();
                }

                @Override // cu.todus.proto.ApiProto.ProtoMucInfoResponse.ProtoMucInfoOrBuilder
                public ByteString getMucIdBytes() {
                    return ((ProtoMucInfo) this.instance).getMucIdBytes();
                }

                @Override // cu.todus.proto.ApiProto.ProtoMucInfoResponse.ProtoMucInfoOrBuilder
                public String getVersion() {
                    return ((ProtoMucInfo) this.instance).getVersion();
                }

                @Override // cu.todus.proto.ApiProto.ProtoMucInfoResponse.ProtoMucInfoOrBuilder
                public ByteString getVersionBytes() {
                    return ((ProtoMucInfo) this.instance).getVersionBytes();
                }

                public Builder putAllConfig(Map<String, String> map) {
                    copyOnWrite();
                    ((ProtoMucInfo) this.instance).getMutableConfigMap().putAll(map);
                    return this;
                }

                public Builder putConfig(String str, String str2) {
                    str.getClass();
                    str2.getClass();
                    copyOnWrite();
                    ((ProtoMucInfo) this.instance).getMutableConfigMap().put(str, str2);
                    return this;
                }

                public Builder removeConfig(String str) {
                    str.getClass();
                    copyOnWrite();
                    ((ProtoMucInfo) this.instance).getMutableConfigMap().remove(str);
                    return this;
                }

                public Builder setMucId(String str) {
                    copyOnWrite();
                    ((ProtoMucInfo) this.instance).setMucId(str);
                    return this;
                }

                public Builder setMucIdBytes(ByteString byteString) {
                    copyOnWrite();
                    ((ProtoMucInfo) this.instance).setMucIdBytes(byteString);
                    return this;
                }

                public Builder setVersion(String str) {
                    copyOnWrite();
                    ((ProtoMucInfo) this.instance).setVersion(str);
                    return this;
                }

                public Builder setVersionBytes(ByteString byteString) {
                    copyOnWrite();
                    ((ProtoMucInfo) this.instance).setVersionBytes(byteString);
                    return this;
                }

                private Builder() {
                    super(ProtoMucInfo.DEFAULT_INSTANCE);
                }
            }

            /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
            public static final class ConfigDefaultEntryHolder {
                static final MapEntryLite<String, String> defaultEntry;

                static {
                    WireFormat.FieldType fieldType = WireFormat.FieldType.STRING;
                    defaultEntry = MapEntryLite.newDefaultInstance(fieldType, "", fieldType, "");
                }

                private ConfigDefaultEntryHolder() {
                }
            }

            static {
                ProtoMucInfo protoMucInfo = new ProtoMucInfo();
                DEFAULT_INSTANCE = protoMucInfo;
                GeneratedMessageLite.registerDefaultInstance(ProtoMucInfo.class, protoMucInfo);
            }

            private ProtoMucInfo() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearMucId() {
                this.mucId_ = getDefaultInstance().getMucId();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearVersion() {
                this.version_ = getDefaultInstance().getVersion();
            }

            public static ProtoMucInfo getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public Map<String, String> getMutableConfigMap() {
                return internalGetMutableConfig();
            }

            private MapFieldLite<String, String> internalGetConfig() {
                return this.config_;
            }

            private MapFieldLite<String, String> internalGetMutableConfig() {
                if (!this.config_.isMutable()) {
                    this.config_ = this.config_.mutableCopy();
                }
                return this.config_;
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.createBuilder();
            }

            public static ProtoMucInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
                return (ProtoMucInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static ProtoMucInfo parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
                return (ProtoMucInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
            }

            public static Parser<ProtoMucInfo> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setMucId(String str) {
                str.getClass();
                this.mucId_ = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setMucIdBytes(ByteString byteString) {
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.mucId_ = byteString.toStringUtf8();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setVersion(String str) {
                str.getClass();
                this.version_ = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setVersionBytes(ByteString byteString) {
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.version_ = byteString.toStringUtf8();
            }

            @Override // cu.todus.proto.ApiProto.ProtoMucInfoResponse.ProtoMucInfoOrBuilder
            public boolean containsConfig(String str) {
                str.getClass();
                return internalGetConfig().containsKey(str);
            }

            @Override // com.google.protobuf.GeneratedMessageLite
            public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                Parser defaultInstanceBasedParser;
                switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                    case 1:
                        return new ProtoMucInfo();
                    case 2:
                        return new Builder();
                    case 3:
                        return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0004\u0003\u0001\u0000\u0000\u0001Ȉ\u0002Ȉ\u00042", new Object[]{"mucId_", "version_", "config_", ConfigDefaultEntryHolder.defaultEntry});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        Parser<ProtoMucInfo> parser = PARSER;
                        if (parser != null) {
                            return parser;
                        }
                        synchronized (ProtoMucInfo.class) {
                            try {
                                defaultInstanceBasedParser = PARSER;
                                if (defaultInstanceBasedParser == null) {
                                    defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                                    PARSER = defaultInstanceBasedParser;
                                }
                            } catch (Throwable th2) {
                                throw th2;
                            }
                            break;
                        }
                        return defaultInstanceBasedParser;
                    case 6:
                        return (byte) 1;
                    case 7:
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }

            @Override // cu.todus.proto.ApiProto.ProtoMucInfoResponse.ProtoMucInfoOrBuilder
            @Deprecated
            public Map<String, String> getConfig() {
                return getConfigMap();
            }

            @Override // cu.todus.proto.ApiProto.ProtoMucInfoResponse.ProtoMucInfoOrBuilder
            public int getConfigCount() {
                return internalGetConfig().size();
            }

            @Override // cu.todus.proto.ApiProto.ProtoMucInfoResponse.ProtoMucInfoOrBuilder
            public Map<String, String> getConfigMap() {
                return DesugarCollections.unmodifiableMap(internalGetConfig());
            }

            @Override // cu.todus.proto.ApiProto.ProtoMucInfoResponse.ProtoMucInfoOrBuilder
            public String getConfigOrDefault(String str, String str2) {
                str.getClass();
                MapFieldLite<String, String> mapFieldLiteInternalGetConfig = internalGetConfig();
                return mapFieldLiteInternalGetConfig.containsKey(str) ? mapFieldLiteInternalGetConfig.get(str) : str2;
            }

            @Override // cu.todus.proto.ApiProto.ProtoMucInfoResponse.ProtoMucInfoOrBuilder
            public String getConfigOrThrow(String str) {
                str.getClass();
                MapFieldLite<String, String> mapFieldLiteInternalGetConfig = internalGetConfig();
                if (mapFieldLiteInternalGetConfig.containsKey(str)) {
                    return mapFieldLiteInternalGetConfig.get(str);
                }
                throw new IllegalArgumentException();
            }

            @Override // cu.todus.proto.ApiProto.ProtoMucInfoResponse.ProtoMucInfoOrBuilder
            public String getMucId() {
                return this.mucId_;
            }

            @Override // cu.todus.proto.ApiProto.ProtoMucInfoResponse.ProtoMucInfoOrBuilder
            public ByteString getMucIdBytes() {
                return ByteString.copyFromUtf8(this.mucId_);
            }

            @Override // cu.todus.proto.ApiProto.ProtoMucInfoResponse.ProtoMucInfoOrBuilder
            public String getVersion() {
                return this.version_;
            }

            @Override // cu.todus.proto.ApiProto.ProtoMucInfoResponse.ProtoMucInfoOrBuilder
            public ByteString getVersionBytes() {
                return ByteString.copyFromUtf8(this.version_);
            }

            public static Builder newBuilder(ProtoMucInfo protoMucInfo) {
                return DEFAULT_INSTANCE.createBuilder(protoMucInfo);
            }

            public static ProtoMucInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (ProtoMucInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static ProtoMucInfo parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (ProtoMucInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
            }

            public static ProtoMucInfo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                return (ProtoMucInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
            }

            public static ProtoMucInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (ProtoMucInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
            }

            public static ProtoMucInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                return (ProtoMucInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
            }

            public static ProtoMucInfo parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (ProtoMucInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
            }

            public static ProtoMucInfo parseFrom(InputStream inputStream) throws IOException {
                return (ProtoMucInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static ProtoMucInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (ProtoMucInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static ProtoMucInfo parseFrom(CodedInputStream codedInputStream) throws IOException {
                return (ProtoMucInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
            }

            public static ProtoMucInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (ProtoMucInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        public interface ProtoMucInfoOrBuilder extends MessageLiteOrBuilder {
            boolean containsConfig(String str);

            @Deprecated
            Map<String, String> getConfig();

            int getConfigCount();

            Map<String, String> getConfigMap();

            String getConfigOrDefault(String str, String str2);

            String getConfigOrThrow(String str);

            String getMucId();

            ByteString getMucIdBytes();

            String getVersion();

            ByteString getVersionBytes();
        }

        static {
            ProtoMucInfoResponse protoMucInfoResponse = new ProtoMucInfoResponse();
            DEFAULT_INSTANCE = protoMucInfoResponse;
            GeneratedMessageLite.registerDefaultInstance(ProtoMucInfoResponse.class, protoMucInfoResponse);
        }

        private ProtoMucInfoResponse() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllMucs(Iterable<? extends ProtoMucInfo> iterable) {
            ensureMucsIsMutable();
            AbstractMessageLite.addAll((Iterable) iterable, (List) this.mucs_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addMucs(ProtoMucInfo protoMucInfo) {
            protoMucInfo.getClass();
            ensureMucsIsMutable();
            this.mucs_.add(protoMucInfo);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearMucs() {
            this.mucs_ = GeneratedMessageLite.emptyProtobufList();
        }

        private void ensureMucsIsMutable() {
            Internal.ProtobufList<ProtoMucInfo> protobufList = this.mucs_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.mucs_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        public static ProtoMucInfoResponse getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static ProtoMucInfoResponse parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (ProtoMucInfoResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ProtoMucInfoResponse parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (ProtoMucInfoResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser<ProtoMucInfoResponse> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeMucs(int i10) {
            ensureMucsIsMutable();
            this.mucs_.remove(i10);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMucs(int i10, ProtoMucInfo protoMucInfo) {
            protoMucInfo.getClass();
            ensureMucsIsMutable();
            this.mucs_.set(i10, protoMucInfo);
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new ProtoMucInfoResponse();
                case 2:
                    return new Builder();
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0002\u0002\u0001\u0000\u0001\u0000\u0002\u001b", new Object[]{"mucs_", ProtoMucInfo.class});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<ProtoMucInfoResponse> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (ProtoMucInfoResponse.class) {
                        try {
                            defaultInstanceBasedParser = PARSER;
                            if (defaultInstanceBasedParser == null) {
                                defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                                PARSER = defaultInstanceBasedParser;
                            }
                        } catch (Throwable th2) {
                            throw th2;
                        }
                        break;
                    }
                    return defaultInstanceBasedParser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        @Override // cu.todus.proto.ApiProto.ProtoMucInfoResponseOrBuilder
        public ProtoMucInfo getMucs(int i10) {
            return this.mucs_.get(i10);
        }

        @Override // cu.todus.proto.ApiProto.ProtoMucInfoResponseOrBuilder
        public int getMucsCount() {
            return this.mucs_.size();
        }

        @Override // cu.todus.proto.ApiProto.ProtoMucInfoResponseOrBuilder
        public List<ProtoMucInfo> getMucsList() {
            return this.mucs_;
        }

        public ProtoMucInfoOrBuilder getMucsOrBuilder(int i10) {
            return this.mucs_.get(i10);
        }

        public List<? extends ProtoMucInfoOrBuilder> getMucsOrBuilderList() {
            return this.mucs_;
        }

        public static Builder newBuilder(ProtoMucInfoResponse protoMucInfoResponse) {
            return DEFAULT_INSTANCE.createBuilder(protoMucInfoResponse);
        }

        public static ProtoMucInfoResponse parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ProtoMucInfoResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ProtoMucInfoResponse parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ProtoMucInfoResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static ProtoMucInfoResponse parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (ProtoMucInfoResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addMucs(int i10, ProtoMucInfo protoMucInfo) {
            protoMucInfo.getClass();
            ensureMucsIsMutable();
            this.mucs_.add(i10, protoMucInfo);
        }

        public static ProtoMucInfoResponse parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ProtoMucInfoResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static ProtoMucInfoResponse parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (ProtoMucInfoResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static ProtoMucInfoResponse parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ProtoMucInfoResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static ProtoMucInfoResponse parseFrom(InputStream inputStream) throws IOException {
            return (ProtoMucInfoResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ProtoMucInfoResponse parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ProtoMucInfoResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ProtoMucInfoResponse parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (ProtoMucInfoResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static ProtoMucInfoResponse parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ProtoMucInfoResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    public interface ProtoMucInfoResponseOrBuilder extends MessageLiteOrBuilder {
        ProtoMucInfoResponse.ProtoMucInfo getMucs(int i10);

        int getMucsCount();

        List<ProtoMucInfoResponse.ProtoMucInfo> getMucsList();
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    public static final class ProtoMucListRequest extends GeneratedMessageLite<ProtoMucListRequest, Builder> implements ProtoMucListRequestOrBuilder {
        private static final ProtoMucListRequest DEFAULT_INSTANCE;
        public static final int DOMAIN_FIELD_NUMBER = 1;
        private static volatile Parser<ProtoMucListRequest> PARSER;
        private String domain_ = "";

        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        public static final class Builder extends GeneratedMessageLite.Builder<ProtoMucListRequest, Builder> implements ProtoMucListRequestOrBuilder {
            public Builder clearDomain() {
                copyOnWrite();
                ((ProtoMucListRequest) this.instance).clearDomain();
                return this;
            }

            @Override // cu.todus.proto.ApiProto.ProtoMucListRequestOrBuilder
            public String getDomain() {
                return ((ProtoMucListRequest) this.instance).getDomain();
            }

            @Override // cu.todus.proto.ApiProto.ProtoMucListRequestOrBuilder
            public ByteString getDomainBytes() {
                return ((ProtoMucListRequest) this.instance).getDomainBytes();
            }

            public Builder setDomain(String str) {
                copyOnWrite();
                ((ProtoMucListRequest) this.instance).setDomain(str);
                return this;
            }

            public Builder setDomainBytes(ByteString byteString) {
                copyOnWrite();
                ((ProtoMucListRequest) this.instance).setDomainBytes(byteString);
                return this;
            }

            private Builder() {
                super(ProtoMucListRequest.DEFAULT_INSTANCE);
            }
        }

        static {
            ProtoMucListRequest protoMucListRequest = new ProtoMucListRequest();
            DEFAULT_INSTANCE = protoMucListRequest;
            GeneratedMessageLite.registerDefaultInstance(ProtoMucListRequest.class, protoMucListRequest);
        }

        private ProtoMucListRequest() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearDomain() {
            this.domain_ = getDefaultInstance().getDomain();
        }

        public static ProtoMucListRequest getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static ProtoMucListRequest parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (ProtoMucListRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ProtoMucListRequest parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (ProtoMucListRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser<ProtoMucListRequest> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDomain(String str) {
            str.getClass();
            this.domain_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDomainBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.domain_ = byteString.toStringUtf8();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new ProtoMucListRequest();
                case 2:
                    return new Builder();
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"domain_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<ProtoMucListRequest> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (ProtoMucListRequest.class) {
                        try {
                            defaultInstanceBasedParser = PARSER;
                            if (defaultInstanceBasedParser == null) {
                                defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                                PARSER = defaultInstanceBasedParser;
                            }
                        } catch (Throwable th2) {
                            throw th2;
                        }
                        break;
                    }
                    return defaultInstanceBasedParser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        @Override // cu.todus.proto.ApiProto.ProtoMucListRequestOrBuilder
        public String getDomain() {
            return this.domain_;
        }

        @Override // cu.todus.proto.ApiProto.ProtoMucListRequestOrBuilder
        public ByteString getDomainBytes() {
            return ByteString.copyFromUtf8(this.domain_);
        }

        public static Builder newBuilder(ProtoMucListRequest protoMucListRequest) {
            return DEFAULT_INSTANCE.createBuilder(protoMucListRequest);
        }

        public static ProtoMucListRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ProtoMucListRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ProtoMucListRequest parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ProtoMucListRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static ProtoMucListRequest parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (ProtoMucListRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static ProtoMucListRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ProtoMucListRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static ProtoMucListRequest parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (ProtoMucListRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static ProtoMucListRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ProtoMucListRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static ProtoMucListRequest parseFrom(InputStream inputStream) throws IOException {
            return (ProtoMucListRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ProtoMucListRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ProtoMucListRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ProtoMucListRequest parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (ProtoMucListRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static ProtoMucListRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ProtoMucListRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    public interface ProtoMucListRequestOrBuilder extends MessageLiteOrBuilder {
        String getDomain();

        ByteString getDomainBytes();
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    public static final class ProtoMucListResponse extends GeneratedMessageLite<ProtoMucListResponse, Builder> implements ProtoMucListResponseOrBuilder {
        private static final ProtoMucListResponse DEFAULT_INSTANCE;
        private static volatile Parser<ProtoMucListResponse> PARSER = null;
        public static final int ROOMID_FIELD_NUMBER = 2;
        public static final int SUCCESS_FIELD_NUMBER = 1;
        private Internal.ProtobufList<String> roomId_ = GeneratedMessageLite.emptyProtobufList();
        private boolean success_;

        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        public static final class Builder extends GeneratedMessageLite.Builder<ProtoMucListResponse, Builder> implements ProtoMucListResponseOrBuilder {
            public Builder addAllRoomId(Iterable<String> iterable) {
                copyOnWrite();
                ((ProtoMucListResponse) this.instance).addAllRoomId(iterable);
                return this;
            }

            public Builder addRoomId(String str) {
                copyOnWrite();
                ((ProtoMucListResponse) this.instance).addRoomId(str);
                return this;
            }

            public Builder addRoomIdBytes(ByteString byteString) {
                copyOnWrite();
                ((ProtoMucListResponse) this.instance).addRoomIdBytes(byteString);
                return this;
            }

            public Builder clearRoomId() {
                copyOnWrite();
                ((ProtoMucListResponse) this.instance).clearRoomId();
                return this;
            }

            public Builder clearSuccess() {
                copyOnWrite();
                ((ProtoMucListResponse) this.instance).clearSuccess();
                return this;
            }

            @Override // cu.todus.proto.ApiProto.ProtoMucListResponseOrBuilder
            public String getRoomId(int i10) {
                return ((ProtoMucListResponse) this.instance).getRoomId(i10);
            }

            @Override // cu.todus.proto.ApiProto.ProtoMucListResponseOrBuilder
            public ByteString getRoomIdBytes(int i10) {
                return ((ProtoMucListResponse) this.instance).getRoomIdBytes(i10);
            }

            @Override // cu.todus.proto.ApiProto.ProtoMucListResponseOrBuilder
            public int getRoomIdCount() {
                return ((ProtoMucListResponse) this.instance).getRoomIdCount();
            }

            @Override // cu.todus.proto.ApiProto.ProtoMucListResponseOrBuilder
            public List<String> getRoomIdList() {
                return DesugarCollections.unmodifiableList(((ProtoMucListResponse) this.instance).getRoomIdList());
            }

            @Override // cu.todus.proto.ApiProto.ProtoMucListResponseOrBuilder
            public boolean getSuccess() {
                return ((ProtoMucListResponse) this.instance).getSuccess();
            }

            public Builder setRoomId(int i10, String str) {
                copyOnWrite();
                ((ProtoMucListResponse) this.instance).setRoomId(i10, str);
                return this;
            }

            public Builder setSuccess(boolean z10) {
                copyOnWrite();
                ((ProtoMucListResponse) this.instance).setSuccess(z10);
                return this;
            }

            private Builder() {
                super(ProtoMucListResponse.DEFAULT_INSTANCE);
            }
        }

        static {
            ProtoMucListResponse protoMucListResponse = new ProtoMucListResponse();
            DEFAULT_INSTANCE = protoMucListResponse;
            GeneratedMessageLite.registerDefaultInstance(ProtoMucListResponse.class, protoMucListResponse);
        }

        private ProtoMucListResponse() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllRoomId(Iterable<String> iterable) {
            ensureRoomIdIsMutable();
            AbstractMessageLite.addAll((Iterable) iterable, (List) this.roomId_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addRoomId(String str) {
            str.getClass();
            ensureRoomIdIsMutable();
            this.roomId_.add(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addRoomIdBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            ensureRoomIdIsMutable();
            this.roomId_.add(byteString.toStringUtf8());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearRoomId() {
            this.roomId_ = GeneratedMessageLite.emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSuccess() {
            this.success_ = false;
        }

        private void ensureRoomIdIsMutable() {
            Internal.ProtobufList<String> protobufList = this.roomId_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.roomId_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        public static ProtoMucListResponse getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static ProtoMucListResponse parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (ProtoMucListResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ProtoMucListResponse parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (ProtoMucListResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser<ProtoMucListResponse> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRoomId(int i10, String str) {
            str.getClass();
            ensureRoomIdIsMutable();
            this.roomId_.set(i10, str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSuccess(boolean z10) {
            this.success_ = z10;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new ProtoMucListResponse();
                case 2:
                    return new Builder();
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u0007\u0002Ț", new Object[]{"success_", "roomId_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<ProtoMucListResponse> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (ProtoMucListResponse.class) {
                        try {
                            defaultInstanceBasedParser = PARSER;
                            if (defaultInstanceBasedParser == null) {
                                defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                                PARSER = defaultInstanceBasedParser;
                            }
                        } catch (Throwable th2) {
                            throw th2;
                        }
                        break;
                    }
                    return defaultInstanceBasedParser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        @Override // cu.todus.proto.ApiProto.ProtoMucListResponseOrBuilder
        public String getRoomId(int i10) {
            return this.roomId_.get(i10);
        }

        @Override // cu.todus.proto.ApiProto.ProtoMucListResponseOrBuilder
        public ByteString getRoomIdBytes(int i10) {
            return ByteString.copyFromUtf8(this.roomId_.get(i10));
        }

        @Override // cu.todus.proto.ApiProto.ProtoMucListResponseOrBuilder
        public int getRoomIdCount() {
            return this.roomId_.size();
        }

        @Override // cu.todus.proto.ApiProto.ProtoMucListResponseOrBuilder
        public List<String> getRoomIdList() {
            return this.roomId_;
        }

        @Override // cu.todus.proto.ApiProto.ProtoMucListResponseOrBuilder
        public boolean getSuccess() {
            return this.success_;
        }

        public static Builder newBuilder(ProtoMucListResponse protoMucListResponse) {
            return DEFAULT_INSTANCE.createBuilder(protoMucListResponse);
        }

        public static ProtoMucListResponse parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ProtoMucListResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ProtoMucListResponse parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ProtoMucListResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static ProtoMucListResponse parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (ProtoMucListResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static ProtoMucListResponse parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ProtoMucListResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static ProtoMucListResponse parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (ProtoMucListResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static ProtoMucListResponse parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ProtoMucListResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static ProtoMucListResponse parseFrom(InputStream inputStream) throws IOException {
            return (ProtoMucListResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ProtoMucListResponse parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ProtoMucListResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ProtoMucListResponse parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (ProtoMucListResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static ProtoMucListResponse parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ProtoMucListResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    public interface ProtoMucListResponseOrBuilder extends MessageLiteOrBuilder {
        String getRoomId(int i10);

        ByteString getRoomIdBytes(int i10);

        int getRoomIdCount();

        List<String> getRoomIdList();

        boolean getSuccess();
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    public static final class ProtoMucMembersRequest extends GeneratedMessageLite<ProtoMucMembersRequest, Builder> implements ProtoMucMembersRequestOrBuilder {
        private static final ProtoMucMembersRequest DEFAULT_INSTANCE;
        public static final int LIMIT_FIELD_NUMBER = 3;
        public static final int MUCID_FIELD_NUMBER = 1;
        public static final int OFFSET_FIELD_NUMBER = 2;
        private static volatile Parser<ProtoMucMembersRequest> PARSER;
        private int limit_;
        private String mucId_ = "";
        private int offset_;

        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        public static final class Builder extends GeneratedMessageLite.Builder<ProtoMucMembersRequest, Builder> implements ProtoMucMembersRequestOrBuilder {
            public Builder clearLimit() {
                copyOnWrite();
                ((ProtoMucMembersRequest) this.instance).clearLimit();
                return this;
            }

            public Builder clearMucId() {
                copyOnWrite();
                ((ProtoMucMembersRequest) this.instance).clearMucId();
                return this;
            }

            public Builder clearOffset() {
                copyOnWrite();
                ((ProtoMucMembersRequest) this.instance).clearOffset();
                return this;
            }

            @Override // cu.todus.proto.ApiProto.ProtoMucMembersRequestOrBuilder
            public int getLimit() {
                return ((ProtoMucMembersRequest) this.instance).getLimit();
            }

            @Override // cu.todus.proto.ApiProto.ProtoMucMembersRequestOrBuilder
            public String getMucId() {
                return ((ProtoMucMembersRequest) this.instance).getMucId();
            }

            @Override // cu.todus.proto.ApiProto.ProtoMucMembersRequestOrBuilder
            public ByteString getMucIdBytes() {
                return ((ProtoMucMembersRequest) this.instance).getMucIdBytes();
            }

            @Override // cu.todus.proto.ApiProto.ProtoMucMembersRequestOrBuilder
            public int getOffset() {
                return ((ProtoMucMembersRequest) this.instance).getOffset();
            }

            public Builder setLimit(int i10) {
                copyOnWrite();
                ((ProtoMucMembersRequest) this.instance).setLimit(i10);
                return this;
            }

            public Builder setMucId(String str) {
                copyOnWrite();
                ((ProtoMucMembersRequest) this.instance).setMucId(str);
                return this;
            }

            public Builder setMucIdBytes(ByteString byteString) {
                copyOnWrite();
                ((ProtoMucMembersRequest) this.instance).setMucIdBytes(byteString);
                return this;
            }

            public Builder setOffset(int i10) {
                copyOnWrite();
                ((ProtoMucMembersRequest) this.instance).setOffset(i10);
                return this;
            }

            private Builder() {
                super(ProtoMucMembersRequest.DEFAULT_INSTANCE);
            }
        }

        static {
            ProtoMucMembersRequest protoMucMembersRequest = new ProtoMucMembersRequest();
            DEFAULT_INSTANCE = protoMucMembersRequest;
            GeneratedMessageLite.registerDefaultInstance(ProtoMucMembersRequest.class, protoMucMembersRequest);
        }

        private ProtoMucMembersRequest() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearLimit() {
            this.limit_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearMucId() {
            this.mucId_ = getDefaultInstance().getMucId();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearOffset() {
            this.offset_ = 0;
        }

        public static ProtoMucMembersRequest getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static ProtoMucMembersRequest parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (ProtoMucMembersRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ProtoMucMembersRequest parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (ProtoMucMembersRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser<ProtoMucMembersRequest> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setLimit(int i10) {
            this.limit_ = i10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMucId(String str) {
            str.getClass();
            this.mucId_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMucIdBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.mucId_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setOffset(int i10) {
            this.offset_ = i10;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new ProtoMucMembersRequest();
                case 2:
                    return new Builder();
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\u0004\u0003\u0004", new Object[]{"mucId_", "offset_", "limit_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<ProtoMucMembersRequest> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (ProtoMucMembersRequest.class) {
                        try {
                            defaultInstanceBasedParser = PARSER;
                            if (defaultInstanceBasedParser == null) {
                                defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                                PARSER = defaultInstanceBasedParser;
                            }
                        } catch (Throwable th2) {
                            throw th2;
                        }
                        break;
                    }
                    return defaultInstanceBasedParser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        @Override // cu.todus.proto.ApiProto.ProtoMucMembersRequestOrBuilder
        public int getLimit() {
            return this.limit_;
        }

        @Override // cu.todus.proto.ApiProto.ProtoMucMembersRequestOrBuilder
        public String getMucId() {
            return this.mucId_;
        }

        @Override // cu.todus.proto.ApiProto.ProtoMucMembersRequestOrBuilder
        public ByteString getMucIdBytes() {
            return ByteString.copyFromUtf8(this.mucId_);
        }

        @Override // cu.todus.proto.ApiProto.ProtoMucMembersRequestOrBuilder
        public int getOffset() {
            return this.offset_;
        }

        public static Builder newBuilder(ProtoMucMembersRequest protoMucMembersRequest) {
            return DEFAULT_INSTANCE.createBuilder(protoMucMembersRequest);
        }

        public static ProtoMucMembersRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ProtoMucMembersRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ProtoMucMembersRequest parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ProtoMucMembersRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static ProtoMucMembersRequest parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (ProtoMucMembersRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static ProtoMucMembersRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ProtoMucMembersRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static ProtoMucMembersRequest parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (ProtoMucMembersRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static ProtoMucMembersRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ProtoMucMembersRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static ProtoMucMembersRequest parseFrom(InputStream inputStream) throws IOException {
            return (ProtoMucMembersRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ProtoMucMembersRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ProtoMucMembersRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ProtoMucMembersRequest parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (ProtoMucMembersRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static ProtoMucMembersRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ProtoMucMembersRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    public interface ProtoMucMembersRequestOrBuilder extends MessageLiteOrBuilder {
        int getLimit();

        String getMucId();

        ByteString getMucIdBytes();

        int getOffset();
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    public static final class ProtoMucMembersResponse extends GeneratedMessageLite<ProtoMucMembersResponse, Builder> implements ProtoMucMembersResponseOrBuilder {
        private static final ProtoMucMembersResponse DEFAULT_INSTANCE;
        private static volatile Parser<ProtoMucMembersResponse> PARSER = null;
        public static final int PROTOMUCMEMBERS_FIELD_NUMBER = 1;
        private Internal.ProtobufList<ProtoMucMember> protoMucMembers_ = GeneratedMessageLite.emptyProtobufList();

        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        public static final class Builder extends GeneratedMessageLite.Builder<ProtoMucMembersResponse, Builder> implements ProtoMucMembersResponseOrBuilder {
            public Builder addAllProtoMucMembers(Iterable<? extends ProtoMucMember> iterable) {
                copyOnWrite();
                ((ProtoMucMembersResponse) this.instance).addAllProtoMucMembers(iterable);
                return this;
            }

            public Builder addProtoMucMembers(ProtoMucMember protoMucMember) {
                copyOnWrite();
                ((ProtoMucMembersResponse) this.instance).addProtoMucMembers(protoMucMember);
                return this;
            }

            public Builder clearProtoMucMembers() {
                copyOnWrite();
                ((ProtoMucMembersResponse) this.instance).clearProtoMucMembers();
                return this;
            }

            @Override // cu.todus.proto.ApiProto.ProtoMucMembersResponseOrBuilder
            public ProtoMucMember getProtoMucMembers(int i10) {
                return ((ProtoMucMembersResponse) this.instance).getProtoMucMembers(i10);
            }

            @Override // cu.todus.proto.ApiProto.ProtoMucMembersResponseOrBuilder
            public int getProtoMucMembersCount() {
                return ((ProtoMucMembersResponse) this.instance).getProtoMucMembersCount();
            }

            @Override // cu.todus.proto.ApiProto.ProtoMucMembersResponseOrBuilder
            public List<ProtoMucMember> getProtoMucMembersList() {
                return DesugarCollections.unmodifiableList(((ProtoMucMembersResponse) this.instance).getProtoMucMembersList());
            }

            public Builder removeProtoMucMembers(int i10) {
                copyOnWrite();
                ((ProtoMucMembersResponse) this.instance).removeProtoMucMembers(i10);
                return this;
            }

            public Builder setProtoMucMembers(int i10, ProtoMucMember protoMucMember) {
                copyOnWrite();
                ((ProtoMucMembersResponse) this.instance).setProtoMucMembers(i10, protoMucMember);
                return this;
            }

            private Builder() {
                super(ProtoMucMembersResponse.DEFAULT_INSTANCE);
            }

            public Builder addProtoMucMembers(int i10, ProtoMucMember protoMucMember) {
                copyOnWrite();
                ((ProtoMucMembersResponse) this.instance).addProtoMucMembers(i10, protoMucMember);
                return this;
            }

            public Builder setProtoMucMembers(int i10, ProtoMucMember.Builder builder) {
                copyOnWrite();
                ((ProtoMucMembersResponse) this.instance).setProtoMucMembers(i10, builder.build());
                return this;
            }

            public Builder addProtoMucMembers(ProtoMucMember.Builder builder) {
                copyOnWrite();
                ((ProtoMucMembersResponse) this.instance).addProtoMucMembers(builder.build());
                return this;
            }

            public Builder addProtoMucMembers(int i10, ProtoMucMember.Builder builder) {
                copyOnWrite();
                ((ProtoMucMembersResponse) this.instance).addProtoMucMembers(i10, builder.build());
                return this;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        public static final class ProtoMucMember extends GeneratedMessageLite<ProtoMucMember, Builder> implements ProtoMucMemberOrBuilder {
            public static final int AFFILIATION_FIELD_NUMBER = 3;
            private static final ProtoMucMember DEFAULT_INSTANCE;
            private static volatile Parser<ProtoMucMember> PARSER = null;
            public static final int USER_FIELD_NUMBER = 2;
            private int affiliation_;
            private String user_ = "";

            /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
            public static final class Builder extends GeneratedMessageLite.Builder<ProtoMucMember, Builder> implements ProtoMucMemberOrBuilder {
                public Builder clearAffiliation() {
                    copyOnWrite();
                    ((ProtoMucMember) this.instance).clearAffiliation();
                    return this;
                }

                public Builder clearUser() {
                    copyOnWrite();
                    ((ProtoMucMember) this.instance).clearUser();
                    return this;
                }

                @Override // cu.todus.proto.ApiProto.ProtoMucMembersResponse.ProtoMucMemberOrBuilder
                public int getAffiliation() {
                    return ((ProtoMucMember) this.instance).getAffiliation();
                }

                @Override // cu.todus.proto.ApiProto.ProtoMucMembersResponse.ProtoMucMemberOrBuilder
                public String getUser() {
                    return ((ProtoMucMember) this.instance).getUser();
                }

                @Override // cu.todus.proto.ApiProto.ProtoMucMembersResponse.ProtoMucMemberOrBuilder
                public ByteString getUserBytes() {
                    return ((ProtoMucMember) this.instance).getUserBytes();
                }

                public Builder setAffiliation(int i10) {
                    copyOnWrite();
                    ((ProtoMucMember) this.instance).setAffiliation(i10);
                    return this;
                }

                public Builder setUser(String str) {
                    copyOnWrite();
                    ((ProtoMucMember) this.instance).setUser(str);
                    return this;
                }

                public Builder setUserBytes(ByteString byteString) {
                    copyOnWrite();
                    ((ProtoMucMember) this.instance).setUserBytes(byteString);
                    return this;
                }

                private Builder() {
                    super(ProtoMucMember.DEFAULT_INSTANCE);
                }
            }

            static {
                ProtoMucMember protoMucMember = new ProtoMucMember();
                DEFAULT_INSTANCE = protoMucMember;
                GeneratedMessageLite.registerDefaultInstance(ProtoMucMember.class, protoMucMember);
            }

            private ProtoMucMember() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearAffiliation() {
                this.affiliation_ = 0;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearUser() {
                this.user_ = getDefaultInstance().getUser();
            }

            public static ProtoMucMember getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.createBuilder();
            }

            public static ProtoMucMember parseDelimitedFrom(InputStream inputStream) throws IOException {
                return (ProtoMucMember) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static ProtoMucMember parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
                return (ProtoMucMember) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
            }

            public static Parser<ProtoMucMember> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setAffiliation(int i10) {
                this.affiliation_ = i10;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setUser(String str) {
                str.getClass();
                this.user_ = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setUserBytes(ByteString byteString) {
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.user_ = byteString.toStringUtf8();
            }

            @Override // com.google.protobuf.GeneratedMessageLite
            public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                Parser defaultInstanceBasedParser;
                switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                    case 1:
                        return new ProtoMucMember();
                    case 2:
                        return new Builder();
                    case 3:
                        return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0002\u0003\u0002\u0000\u0000\u0000\u0002Ȉ\u0003\u0004", new Object[]{"user_", "affiliation_"});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        Parser<ProtoMucMember> parser = PARSER;
                        if (parser != null) {
                            return parser;
                        }
                        synchronized (ProtoMucMember.class) {
                            try {
                                defaultInstanceBasedParser = PARSER;
                                if (defaultInstanceBasedParser == null) {
                                    defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                                    PARSER = defaultInstanceBasedParser;
                                }
                            } catch (Throwable th2) {
                                throw th2;
                            }
                            break;
                        }
                        return defaultInstanceBasedParser;
                    case 6:
                        return (byte) 1;
                    case 7:
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }

            @Override // cu.todus.proto.ApiProto.ProtoMucMembersResponse.ProtoMucMemberOrBuilder
            public int getAffiliation() {
                return this.affiliation_;
            }

            @Override // cu.todus.proto.ApiProto.ProtoMucMembersResponse.ProtoMucMemberOrBuilder
            public String getUser() {
                return this.user_;
            }

            @Override // cu.todus.proto.ApiProto.ProtoMucMembersResponse.ProtoMucMemberOrBuilder
            public ByteString getUserBytes() {
                return ByteString.copyFromUtf8(this.user_);
            }

            public static Builder newBuilder(ProtoMucMember protoMucMember) {
                return DEFAULT_INSTANCE.createBuilder(protoMucMember);
            }

            public static ProtoMucMember parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (ProtoMucMember) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static ProtoMucMember parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (ProtoMucMember) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
            }

            public static ProtoMucMember parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                return (ProtoMucMember) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
            }

            public static ProtoMucMember parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (ProtoMucMember) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
            }

            public static ProtoMucMember parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                return (ProtoMucMember) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
            }

            public static ProtoMucMember parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (ProtoMucMember) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
            }

            public static ProtoMucMember parseFrom(InputStream inputStream) throws IOException {
                return (ProtoMucMember) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static ProtoMucMember parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (ProtoMucMember) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static ProtoMucMember parseFrom(CodedInputStream codedInputStream) throws IOException {
                return (ProtoMucMember) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
            }

            public static ProtoMucMember parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (ProtoMucMember) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        public interface ProtoMucMemberOrBuilder extends MessageLiteOrBuilder {
            int getAffiliation();

            String getUser();

            ByteString getUserBytes();
        }

        static {
            ProtoMucMembersResponse protoMucMembersResponse = new ProtoMucMembersResponse();
            DEFAULT_INSTANCE = protoMucMembersResponse;
            GeneratedMessageLite.registerDefaultInstance(ProtoMucMembersResponse.class, protoMucMembersResponse);
        }

        private ProtoMucMembersResponse() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllProtoMucMembers(Iterable<? extends ProtoMucMember> iterable) {
            ensureProtoMucMembersIsMutable();
            AbstractMessageLite.addAll((Iterable) iterable, (List) this.protoMucMembers_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addProtoMucMembers(ProtoMucMember protoMucMember) {
            protoMucMember.getClass();
            ensureProtoMucMembersIsMutable();
            this.protoMucMembers_.add(protoMucMember);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearProtoMucMembers() {
            this.protoMucMembers_ = GeneratedMessageLite.emptyProtobufList();
        }

        private void ensureProtoMucMembersIsMutable() {
            Internal.ProtobufList<ProtoMucMember> protobufList = this.protoMucMembers_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.protoMucMembers_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        public static ProtoMucMembersResponse getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static ProtoMucMembersResponse parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (ProtoMucMembersResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ProtoMucMembersResponse parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (ProtoMucMembersResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser<ProtoMucMembersResponse> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeProtoMucMembers(int i10) {
            ensureProtoMucMembersIsMutable();
            this.protoMucMembers_.remove(i10);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setProtoMucMembers(int i10, ProtoMucMember protoMucMember) {
            protoMucMember.getClass();
            ensureProtoMucMembersIsMutable();
            this.protoMucMembers_.set(i10, protoMucMember);
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new ProtoMucMembersResponse();
                case 2:
                    return new Builder();
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"protoMucMembers_", ProtoMucMember.class});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<ProtoMucMembersResponse> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (ProtoMucMembersResponse.class) {
                        try {
                            defaultInstanceBasedParser = PARSER;
                            if (defaultInstanceBasedParser == null) {
                                defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                                PARSER = defaultInstanceBasedParser;
                            }
                        } catch (Throwable th2) {
                            throw th2;
                        }
                        break;
                    }
                    return defaultInstanceBasedParser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        @Override // cu.todus.proto.ApiProto.ProtoMucMembersResponseOrBuilder
        public ProtoMucMember getProtoMucMembers(int i10) {
            return this.protoMucMembers_.get(i10);
        }

        @Override // cu.todus.proto.ApiProto.ProtoMucMembersResponseOrBuilder
        public int getProtoMucMembersCount() {
            return this.protoMucMembers_.size();
        }

        @Override // cu.todus.proto.ApiProto.ProtoMucMembersResponseOrBuilder
        public List<ProtoMucMember> getProtoMucMembersList() {
            return this.protoMucMembers_;
        }

        public ProtoMucMemberOrBuilder getProtoMucMembersOrBuilder(int i10) {
            return this.protoMucMembers_.get(i10);
        }

        public List<? extends ProtoMucMemberOrBuilder> getProtoMucMembersOrBuilderList() {
            return this.protoMucMembers_;
        }

        public static Builder newBuilder(ProtoMucMembersResponse protoMucMembersResponse) {
            return DEFAULT_INSTANCE.createBuilder(protoMucMembersResponse);
        }

        public static ProtoMucMembersResponse parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ProtoMucMembersResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ProtoMucMembersResponse parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ProtoMucMembersResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static ProtoMucMembersResponse parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (ProtoMucMembersResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addProtoMucMembers(int i10, ProtoMucMember protoMucMember) {
            protoMucMember.getClass();
            ensureProtoMucMembersIsMutable();
            this.protoMucMembers_.add(i10, protoMucMember);
        }

        public static ProtoMucMembersResponse parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ProtoMucMembersResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static ProtoMucMembersResponse parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (ProtoMucMembersResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static ProtoMucMembersResponse parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ProtoMucMembersResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static ProtoMucMembersResponse parseFrom(InputStream inputStream) throws IOException {
            return (ProtoMucMembersResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ProtoMucMembersResponse parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ProtoMucMembersResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ProtoMucMembersResponse parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (ProtoMucMembersResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static ProtoMucMembersResponse parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ProtoMucMembersResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    public interface ProtoMucMembersResponseOrBuilder extends MessageLiteOrBuilder {
        ProtoMucMembersResponse.ProtoMucMember getProtoMucMembers(int i10);

        int getProtoMucMembersCount();

        List<ProtoMucMembersResponse.ProtoMucMember> getProtoMucMembersList();
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    public static final class ProtoMucShareIdRequest extends GeneratedMessageLite<ProtoMucShareIdRequest, Builder> implements ProtoMucShareIdRequestOrBuilder {
        private static final ProtoMucShareIdRequest DEFAULT_INSTANCE;
        private static volatile Parser<ProtoMucShareIdRequest> PARSER = null;
        public static final int SHAREID_FIELD_NUMBER = 1;
        public static final int SUCCESS_FIELD_NUMBER = 2;
        private String shareId_ = "";
        private boolean success_;

        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        public static final class Builder extends GeneratedMessageLite.Builder<ProtoMucShareIdRequest, Builder> implements ProtoMucShareIdRequestOrBuilder {
            public Builder clearShareId() {
                copyOnWrite();
                ((ProtoMucShareIdRequest) this.instance).clearShareId();
                return this;
            }

            public Builder clearSuccess() {
                copyOnWrite();
                ((ProtoMucShareIdRequest) this.instance).clearSuccess();
                return this;
            }

            @Override // cu.todus.proto.ApiProto.ProtoMucShareIdRequestOrBuilder
            public String getShareId() {
                return ((ProtoMucShareIdRequest) this.instance).getShareId();
            }

            @Override // cu.todus.proto.ApiProto.ProtoMucShareIdRequestOrBuilder
            public ByteString getShareIdBytes() {
                return ((ProtoMucShareIdRequest) this.instance).getShareIdBytes();
            }

            @Override // cu.todus.proto.ApiProto.ProtoMucShareIdRequestOrBuilder
            public boolean getSuccess() {
                return ((ProtoMucShareIdRequest) this.instance).getSuccess();
            }

            public Builder setShareId(String str) {
                copyOnWrite();
                ((ProtoMucShareIdRequest) this.instance).setShareId(str);
                return this;
            }

            public Builder setShareIdBytes(ByteString byteString) {
                copyOnWrite();
                ((ProtoMucShareIdRequest) this.instance).setShareIdBytes(byteString);
                return this;
            }

            public Builder setSuccess(boolean z10) {
                copyOnWrite();
                ((ProtoMucShareIdRequest) this.instance).setSuccess(z10);
                return this;
            }

            private Builder() {
                super(ProtoMucShareIdRequest.DEFAULT_INSTANCE);
            }
        }

        static {
            ProtoMucShareIdRequest protoMucShareIdRequest = new ProtoMucShareIdRequest();
            DEFAULT_INSTANCE = protoMucShareIdRequest;
            GeneratedMessageLite.registerDefaultInstance(ProtoMucShareIdRequest.class, protoMucShareIdRequest);
        }

        private ProtoMucShareIdRequest() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearShareId() {
            this.shareId_ = getDefaultInstance().getShareId();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSuccess() {
            this.success_ = false;
        }

        public static ProtoMucShareIdRequest getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static ProtoMucShareIdRequest parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (ProtoMucShareIdRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ProtoMucShareIdRequest parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (ProtoMucShareIdRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser<ProtoMucShareIdRequest> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setShareId(String str) {
            str.getClass();
            this.shareId_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setShareIdBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.shareId_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSuccess(boolean z10) {
            this.success_ = z10;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new ProtoMucShareIdRequest();
                case 2:
                    return new Builder();
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002\u0007", new Object[]{"shareId_", "success_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<ProtoMucShareIdRequest> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (ProtoMucShareIdRequest.class) {
                        try {
                            defaultInstanceBasedParser = PARSER;
                            if (defaultInstanceBasedParser == null) {
                                defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                                PARSER = defaultInstanceBasedParser;
                            }
                        } catch (Throwable th2) {
                            throw th2;
                        }
                        break;
                    }
                    return defaultInstanceBasedParser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        @Override // cu.todus.proto.ApiProto.ProtoMucShareIdRequestOrBuilder
        public String getShareId() {
            return this.shareId_;
        }

        @Override // cu.todus.proto.ApiProto.ProtoMucShareIdRequestOrBuilder
        public ByteString getShareIdBytes() {
            return ByteString.copyFromUtf8(this.shareId_);
        }

        @Override // cu.todus.proto.ApiProto.ProtoMucShareIdRequestOrBuilder
        public boolean getSuccess() {
            return this.success_;
        }

        public static Builder newBuilder(ProtoMucShareIdRequest protoMucShareIdRequest) {
            return DEFAULT_INSTANCE.createBuilder(protoMucShareIdRequest);
        }

        public static ProtoMucShareIdRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ProtoMucShareIdRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ProtoMucShareIdRequest parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ProtoMucShareIdRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static ProtoMucShareIdRequest parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (ProtoMucShareIdRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static ProtoMucShareIdRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ProtoMucShareIdRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static ProtoMucShareIdRequest parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (ProtoMucShareIdRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static ProtoMucShareIdRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ProtoMucShareIdRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static ProtoMucShareIdRequest parseFrom(InputStream inputStream) throws IOException {
            return (ProtoMucShareIdRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ProtoMucShareIdRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ProtoMucShareIdRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ProtoMucShareIdRequest parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (ProtoMucShareIdRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static ProtoMucShareIdRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ProtoMucShareIdRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    public interface ProtoMucShareIdRequestOrBuilder extends MessageLiteOrBuilder {
        String getShareId();

        ByteString getShareIdBytes();

        boolean getSuccess();
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    public static final class ProtoMucShareIdResponse extends GeneratedMessageLite<ProtoMucShareIdResponse, Builder> implements ProtoMucShareIdResponseOrBuilder {
        public static final int ADMINS_FIELD_NUMBER = 5;
        public static final int CANTAFF_FIELD_NUMBER = 6;
        public static final int CONFIG_FIELD_NUMBER = 4;
        private static final ProtoMucShareIdResponse DEFAULT_INSTANCE;
        public static final int LSERVER_FIELD_NUMBER = 2;
        public static final int LUSER_FIELD_NUMBER = 1;
        private static volatile Parser<ProtoMucShareIdResponse> PARSER = null;
        public static final int VERSION_FIELD_NUMBER = 3;
        private int cantAff_;
        private MapFieldLite<String, String> config_ = MapFieldLite.emptyMapField();
        private String luser_ = "";
        private String lserver_ = "";
        private String version_ = "";
        private Internal.ProtobufList<String> admins_ = GeneratedMessageLite.emptyProtobufList();

        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        public static final class Builder extends GeneratedMessageLite.Builder<ProtoMucShareIdResponse, Builder> implements ProtoMucShareIdResponseOrBuilder {
            public Builder addAdmins(String str) {
                copyOnWrite();
                ((ProtoMucShareIdResponse) this.instance).addAdmins(str);
                return this;
            }

            public Builder addAdminsBytes(ByteString byteString) {
                copyOnWrite();
                ((ProtoMucShareIdResponse) this.instance).addAdminsBytes(byteString);
                return this;
            }

            public Builder addAllAdmins(Iterable<String> iterable) {
                copyOnWrite();
                ((ProtoMucShareIdResponse) this.instance).addAllAdmins(iterable);
                return this;
            }

            public Builder clearAdmins() {
                copyOnWrite();
                ((ProtoMucShareIdResponse) this.instance).clearAdmins();
                return this;
            }

            public Builder clearCantAff() {
                copyOnWrite();
                ((ProtoMucShareIdResponse) this.instance).clearCantAff();
                return this;
            }

            public Builder clearConfig() {
                copyOnWrite();
                ((ProtoMucShareIdResponse) this.instance).getMutableConfigMap().clear();
                return this;
            }

            public Builder clearLserver() {
                copyOnWrite();
                ((ProtoMucShareIdResponse) this.instance).clearLserver();
                return this;
            }

            public Builder clearLuser() {
                copyOnWrite();
                ((ProtoMucShareIdResponse) this.instance).clearLuser();
                return this;
            }

            public Builder clearVersion() {
                copyOnWrite();
                ((ProtoMucShareIdResponse) this.instance).clearVersion();
                return this;
            }

            @Override // cu.todus.proto.ApiProto.ProtoMucShareIdResponseOrBuilder
            public boolean containsConfig(String str) {
                str.getClass();
                return ((ProtoMucShareIdResponse) this.instance).getConfigMap().containsKey(str);
            }

            @Override // cu.todus.proto.ApiProto.ProtoMucShareIdResponseOrBuilder
            public String getAdmins(int i10) {
                return ((ProtoMucShareIdResponse) this.instance).getAdmins(i10);
            }

            @Override // cu.todus.proto.ApiProto.ProtoMucShareIdResponseOrBuilder
            public ByteString getAdminsBytes(int i10) {
                return ((ProtoMucShareIdResponse) this.instance).getAdminsBytes(i10);
            }

            @Override // cu.todus.proto.ApiProto.ProtoMucShareIdResponseOrBuilder
            public int getAdminsCount() {
                return ((ProtoMucShareIdResponse) this.instance).getAdminsCount();
            }

            @Override // cu.todus.proto.ApiProto.ProtoMucShareIdResponseOrBuilder
            public List<String> getAdminsList() {
                return DesugarCollections.unmodifiableList(((ProtoMucShareIdResponse) this.instance).getAdminsList());
            }

            @Override // cu.todus.proto.ApiProto.ProtoMucShareIdResponseOrBuilder
            public int getCantAff() {
                return ((ProtoMucShareIdResponse) this.instance).getCantAff();
            }

            @Override // cu.todus.proto.ApiProto.ProtoMucShareIdResponseOrBuilder
            @Deprecated
            public Map<String, String> getConfig() {
                return getConfigMap();
            }

            @Override // cu.todus.proto.ApiProto.ProtoMucShareIdResponseOrBuilder
            public int getConfigCount() {
                return ((ProtoMucShareIdResponse) this.instance).getConfigMap().size();
            }

            @Override // cu.todus.proto.ApiProto.ProtoMucShareIdResponseOrBuilder
            public Map<String, String> getConfigMap() {
                return DesugarCollections.unmodifiableMap(((ProtoMucShareIdResponse) this.instance).getConfigMap());
            }

            @Override // cu.todus.proto.ApiProto.ProtoMucShareIdResponseOrBuilder
            public String getConfigOrDefault(String str, String str2) {
                str.getClass();
                Map<String, String> configMap = ((ProtoMucShareIdResponse) this.instance).getConfigMap();
                return configMap.containsKey(str) ? configMap.get(str) : str2;
            }

            @Override // cu.todus.proto.ApiProto.ProtoMucShareIdResponseOrBuilder
            public String getConfigOrThrow(String str) {
                str.getClass();
                Map<String, String> configMap = ((ProtoMucShareIdResponse) this.instance).getConfigMap();
                if (configMap.containsKey(str)) {
                    return configMap.get(str);
                }
                throw new IllegalArgumentException();
            }

            @Override // cu.todus.proto.ApiProto.ProtoMucShareIdResponseOrBuilder
            public String getLserver() {
                return ((ProtoMucShareIdResponse) this.instance).getLserver();
            }

            @Override // cu.todus.proto.ApiProto.ProtoMucShareIdResponseOrBuilder
            public ByteString getLserverBytes() {
                return ((ProtoMucShareIdResponse) this.instance).getLserverBytes();
            }

            @Override // cu.todus.proto.ApiProto.ProtoMucShareIdResponseOrBuilder
            public String getLuser() {
                return ((ProtoMucShareIdResponse) this.instance).getLuser();
            }

            @Override // cu.todus.proto.ApiProto.ProtoMucShareIdResponseOrBuilder
            public ByteString getLuserBytes() {
                return ((ProtoMucShareIdResponse) this.instance).getLuserBytes();
            }

            @Override // cu.todus.proto.ApiProto.ProtoMucShareIdResponseOrBuilder
            public String getVersion() {
                return ((ProtoMucShareIdResponse) this.instance).getVersion();
            }

            @Override // cu.todus.proto.ApiProto.ProtoMucShareIdResponseOrBuilder
            public ByteString getVersionBytes() {
                return ((ProtoMucShareIdResponse) this.instance).getVersionBytes();
            }

            public Builder putAllConfig(Map<String, String> map) {
                copyOnWrite();
                ((ProtoMucShareIdResponse) this.instance).getMutableConfigMap().putAll(map);
                return this;
            }

            public Builder putConfig(String str, String str2) {
                str.getClass();
                str2.getClass();
                copyOnWrite();
                ((ProtoMucShareIdResponse) this.instance).getMutableConfigMap().put(str, str2);
                return this;
            }

            public Builder removeConfig(String str) {
                str.getClass();
                copyOnWrite();
                ((ProtoMucShareIdResponse) this.instance).getMutableConfigMap().remove(str);
                return this;
            }

            public Builder setAdmins(int i10, String str) {
                copyOnWrite();
                ((ProtoMucShareIdResponse) this.instance).setAdmins(i10, str);
                return this;
            }

            public Builder setCantAff(int i10) {
                copyOnWrite();
                ((ProtoMucShareIdResponse) this.instance).setCantAff(i10);
                return this;
            }

            public Builder setLserver(String str) {
                copyOnWrite();
                ((ProtoMucShareIdResponse) this.instance).setLserver(str);
                return this;
            }

            public Builder setLserverBytes(ByteString byteString) {
                copyOnWrite();
                ((ProtoMucShareIdResponse) this.instance).setLserverBytes(byteString);
                return this;
            }

            public Builder setLuser(String str) {
                copyOnWrite();
                ((ProtoMucShareIdResponse) this.instance).setLuser(str);
                return this;
            }

            public Builder setLuserBytes(ByteString byteString) {
                copyOnWrite();
                ((ProtoMucShareIdResponse) this.instance).setLuserBytes(byteString);
                return this;
            }

            public Builder setVersion(String str) {
                copyOnWrite();
                ((ProtoMucShareIdResponse) this.instance).setVersion(str);
                return this;
            }

            public Builder setVersionBytes(ByteString byteString) {
                copyOnWrite();
                ((ProtoMucShareIdResponse) this.instance).setVersionBytes(byteString);
                return this;
            }

            private Builder() {
                super(ProtoMucShareIdResponse.DEFAULT_INSTANCE);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        public static final class ConfigDefaultEntryHolder {
            static final MapEntryLite<String, String> defaultEntry;

            static {
                WireFormat.FieldType fieldType = WireFormat.FieldType.STRING;
                defaultEntry = MapEntryLite.newDefaultInstance(fieldType, "", fieldType, "");
            }

            private ConfigDefaultEntryHolder() {
            }
        }

        static {
            ProtoMucShareIdResponse protoMucShareIdResponse = new ProtoMucShareIdResponse();
            DEFAULT_INSTANCE = protoMucShareIdResponse;
            GeneratedMessageLite.registerDefaultInstance(ProtoMucShareIdResponse.class, protoMucShareIdResponse);
        }

        private ProtoMucShareIdResponse() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAdmins(String str) {
            str.getClass();
            ensureAdminsIsMutable();
            this.admins_.add(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAdminsBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            ensureAdminsIsMutable();
            this.admins_.add(byteString.toStringUtf8());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllAdmins(Iterable<String> iterable) {
            ensureAdminsIsMutable();
            AbstractMessageLite.addAll((Iterable) iterable, (List) this.admins_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearAdmins() {
            this.admins_ = GeneratedMessageLite.emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearCantAff() {
            this.cantAff_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearLserver() {
            this.lserver_ = getDefaultInstance().getLserver();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearLuser() {
            this.luser_ = getDefaultInstance().getLuser();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearVersion() {
            this.version_ = getDefaultInstance().getVersion();
        }

        private void ensureAdminsIsMutable() {
            Internal.ProtobufList<String> protobufList = this.admins_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.admins_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        public static ProtoMucShareIdResponse getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Map<String, String> getMutableConfigMap() {
            return internalGetMutableConfig();
        }

        private MapFieldLite<String, String> internalGetConfig() {
            return this.config_;
        }

        private MapFieldLite<String, String> internalGetMutableConfig() {
            if (!this.config_.isMutable()) {
                this.config_ = this.config_.mutableCopy();
            }
            return this.config_;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static ProtoMucShareIdResponse parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (ProtoMucShareIdResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ProtoMucShareIdResponse parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (ProtoMucShareIdResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser<ProtoMucShareIdResponse> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAdmins(int i10, String str) {
            str.getClass();
            ensureAdminsIsMutable();
            this.admins_.set(i10, str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCantAff(int i10) {
            this.cantAff_ = i10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setLserver(String str) {
            str.getClass();
            this.lserver_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setLserverBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.lserver_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setLuser(String str) {
            str.getClass();
            this.luser_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setLuserBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.luser_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setVersion(String str) {
            str.getClass();
            this.version_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setVersionBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.version_ = byteString.toStringUtf8();
        }

        @Override // cu.todus.proto.ApiProto.ProtoMucShareIdResponseOrBuilder
        public boolean containsConfig(String str) {
            str.getClass();
            return internalGetConfig().containsKey(str);
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new ProtoMucShareIdResponse();
                case 2:
                    return new Builder();
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0006\u0000\u0000\u0001\u0006\u0006\u0001\u0001\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ\u00042\u0005Ț\u0006\u0004", new Object[]{"luser_", "lserver_", "version_", "config_", ConfigDefaultEntryHolder.defaultEntry, "admins_", "cantAff_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<ProtoMucShareIdResponse> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (ProtoMucShareIdResponse.class) {
                        try {
                            defaultInstanceBasedParser = PARSER;
                            if (defaultInstanceBasedParser == null) {
                                defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                                PARSER = defaultInstanceBasedParser;
                            }
                        } catch (Throwable th2) {
                            throw th2;
                        }
                        break;
                    }
                    return defaultInstanceBasedParser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        @Override // cu.todus.proto.ApiProto.ProtoMucShareIdResponseOrBuilder
        public String getAdmins(int i10) {
            return this.admins_.get(i10);
        }

        @Override // cu.todus.proto.ApiProto.ProtoMucShareIdResponseOrBuilder
        public ByteString getAdminsBytes(int i10) {
            return ByteString.copyFromUtf8(this.admins_.get(i10));
        }

        @Override // cu.todus.proto.ApiProto.ProtoMucShareIdResponseOrBuilder
        public int getAdminsCount() {
            return this.admins_.size();
        }

        @Override // cu.todus.proto.ApiProto.ProtoMucShareIdResponseOrBuilder
        public List<String> getAdminsList() {
            return this.admins_;
        }

        @Override // cu.todus.proto.ApiProto.ProtoMucShareIdResponseOrBuilder
        public int getCantAff() {
            return this.cantAff_;
        }

        @Override // cu.todus.proto.ApiProto.ProtoMucShareIdResponseOrBuilder
        @Deprecated
        public Map<String, String> getConfig() {
            return getConfigMap();
        }

        @Override // cu.todus.proto.ApiProto.ProtoMucShareIdResponseOrBuilder
        public int getConfigCount() {
            return internalGetConfig().size();
        }

        @Override // cu.todus.proto.ApiProto.ProtoMucShareIdResponseOrBuilder
        public Map<String, String> getConfigMap() {
            return DesugarCollections.unmodifiableMap(internalGetConfig());
        }

        @Override // cu.todus.proto.ApiProto.ProtoMucShareIdResponseOrBuilder
        public String getConfigOrDefault(String str, String str2) {
            str.getClass();
            MapFieldLite<String, String> mapFieldLiteInternalGetConfig = internalGetConfig();
            return mapFieldLiteInternalGetConfig.containsKey(str) ? mapFieldLiteInternalGetConfig.get(str) : str2;
        }

        @Override // cu.todus.proto.ApiProto.ProtoMucShareIdResponseOrBuilder
        public String getConfigOrThrow(String str) {
            str.getClass();
            MapFieldLite<String, String> mapFieldLiteInternalGetConfig = internalGetConfig();
            if (mapFieldLiteInternalGetConfig.containsKey(str)) {
                return mapFieldLiteInternalGetConfig.get(str);
            }
            throw new IllegalArgumentException();
        }

        @Override // cu.todus.proto.ApiProto.ProtoMucShareIdResponseOrBuilder
        public String getLserver() {
            return this.lserver_;
        }

        @Override // cu.todus.proto.ApiProto.ProtoMucShareIdResponseOrBuilder
        public ByteString getLserverBytes() {
            return ByteString.copyFromUtf8(this.lserver_);
        }

        @Override // cu.todus.proto.ApiProto.ProtoMucShareIdResponseOrBuilder
        public String getLuser() {
            return this.luser_;
        }

        @Override // cu.todus.proto.ApiProto.ProtoMucShareIdResponseOrBuilder
        public ByteString getLuserBytes() {
            return ByteString.copyFromUtf8(this.luser_);
        }

        @Override // cu.todus.proto.ApiProto.ProtoMucShareIdResponseOrBuilder
        public String getVersion() {
            return this.version_;
        }

        @Override // cu.todus.proto.ApiProto.ProtoMucShareIdResponseOrBuilder
        public ByteString getVersionBytes() {
            return ByteString.copyFromUtf8(this.version_);
        }

        public static Builder newBuilder(ProtoMucShareIdResponse protoMucShareIdResponse) {
            return DEFAULT_INSTANCE.createBuilder(protoMucShareIdResponse);
        }

        public static ProtoMucShareIdResponse parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ProtoMucShareIdResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ProtoMucShareIdResponse parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ProtoMucShareIdResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static ProtoMucShareIdResponse parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (ProtoMucShareIdResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static ProtoMucShareIdResponse parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ProtoMucShareIdResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static ProtoMucShareIdResponse parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (ProtoMucShareIdResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static ProtoMucShareIdResponse parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ProtoMucShareIdResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static ProtoMucShareIdResponse parseFrom(InputStream inputStream) throws IOException {
            return (ProtoMucShareIdResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ProtoMucShareIdResponse parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ProtoMucShareIdResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ProtoMucShareIdResponse parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (ProtoMucShareIdResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static ProtoMucShareIdResponse parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ProtoMucShareIdResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    public interface ProtoMucShareIdResponseOrBuilder extends MessageLiteOrBuilder {
        boolean containsConfig(String str);

        String getAdmins(int i10);

        ByteString getAdminsBytes(int i10);

        int getAdminsCount();

        List<String> getAdminsList();

        int getCantAff();

        @Deprecated
        Map<String, String> getConfig();

        int getConfigCount();

        Map<String, String> getConfigMap();

        String getConfigOrDefault(String str, String str2);

        String getConfigOrThrow(String str);

        String getLserver();

        ByteString getLserverBytes();

        String getLuser();

        ByteString getLuserBytes();

        String getVersion();

        ByteString getVersionBytes();
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    public static final class ProtoPresignedUrlRequest extends GeneratedMessageLite<ProtoPresignedUrlRequest, Builder> implements ProtoPresignedUrlRequestOrBuilder {
        private static final ProtoPresignedUrlRequest DEFAULT_INSTANCE;
        private static volatile Parser<ProtoPresignedUrlRequest> PARSER = null;
        public static final int PERSISTENT_FIELD_NUMBER = 2;
        public static final int TYPE_FIELD_NUMBER = 1;
        private boolean persistent_;
        private int type_;

        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        public static final class Builder extends GeneratedMessageLite.Builder<ProtoPresignedUrlRequest, Builder> implements ProtoPresignedUrlRequestOrBuilder {
            public Builder clearPersistent() {
                copyOnWrite();
                ((ProtoPresignedUrlRequest) this.instance).clearPersistent();
                return this;
            }

            public Builder clearType() {
                copyOnWrite();
                ((ProtoPresignedUrlRequest) this.instance).clearType();
                return this;
            }

            @Override // cu.todus.proto.ApiProto.ProtoPresignedUrlRequestOrBuilder
            public boolean getPersistent() {
                return ((ProtoPresignedUrlRequest) this.instance).getPersistent();
            }

            @Override // cu.todus.proto.ApiProto.ProtoPresignedUrlRequestOrBuilder
            public int getType() {
                return ((ProtoPresignedUrlRequest) this.instance).getType();
            }

            public Builder setPersistent(boolean z10) {
                copyOnWrite();
                ((ProtoPresignedUrlRequest) this.instance).setPersistent(z10);
                return this;
            }

            public Builder setType(int i10) {
                copyOnWrite();
                ((ProtoPresignedUrlRequest) this.instance).setType(i10);
                return this;
            }

            private Builder() {
                super(ProtoPresignedUrlRequest.DEFAULT_INSTANCE);
            }
        }

        static {
            ProtoPresignedUrlRequest protoPresignedUrlRequest = new ProtoPresignedUrlRequest();
            DEFAULT_INSTANCE = protoPresignedUrlRequest;
            GeneratedMessageLite.registerDefaultInstance(ProtoPresignedUrlRequest.class, protoPresignedUrlRequest);
        }

        private ProtoPresignedUrlRequest() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPersistent() {
            this.persistent_ = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearType() {
            this.type_ = 0;
        }

        public static ProtoPresignedUrlRequest getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static ProtoPresignedUrlRequest parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (ProtoPresignedUrlRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ProtoPresignedUrlRequest parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (ProtoPresignedUrlRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser<ProtoPresignedUrlRequest> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPersistent(boolean z10) {
            this.persistent_ = z10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setType(int i10) {
            this.type_ = i10;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new ProtoPresignedUrlRequest();
                case 2:
                    return new Builder();
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0004\u0002\u0007", new Object[]{"type_", "persistent_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<ProtoPresignedUrlRequest> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (ProtoPresignedUrlRequest.class) {
                        try {
                            defaultInstanceBasedParser = PARSER;
                            if (defaultInstanceBasedParser == null) {
                                defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                                PARSER = defaultInstanceBasedParser;
                            }
                        } catch (Throwable th2) {
                            throw th2;
                        }
                        break;
                    }
                    return defaultInstanceBasedParser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        @Override // cu.todus.proto.ApiProto.ProtoPresignedUrlRequestOrBuilder
        public boolean getPersistent() {
            return this.persistent_;
        }

        @Override // cu.todus.proto.ApiProto.ProtoPresignedUrlRequestOrBuilder
        public int getType() {
            return this.type_;
        }

        public static Builder newBuilder(ProtoPresignedUrlRequest protoPresignedUrlRequest) {
            return DEFAULT_INSTANCE.createBuilder(protoPresignedUrlRequest);
        }

        public static ProtoPresignedUrlRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ProtoPresignedUrlRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ProtoPresignedUrlRequest parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ProtoPresignedUrlRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static ProtoPresignedUrlRequest parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (ProtoPresignedUrlRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static ProtoPresignedUrlRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ProtoPresignedUrlRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static ProtoPresignedUrlRequest parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (ProtoPresignedUrlRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static ProtoPresignedUrlRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ProtoPresignedUrlRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static ProtoPresignedUrlRequest parseFrom(InputStream inputStream) throws IOException {
            return (ProtoPresignedUrlRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ProtoPresignedUrlRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ProtoPresignedUrlRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ProtoPresignedUrlRequest parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (ProtoPresignedUrlRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static ProtoPresignedUrlRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ProtoPresignedUrlRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    public interface ProtoPresignedUrlRequestOrBuilder extends MessageLiteOrBuilder {
        boolean getPersistent();

        int getType();
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    public static final class ProtoPresignedUrlResponse extends GeneratedMessageLite<ProtoPresignedUrlResponse, Builder> implements ProtoPresignedUrlResponseOrBuilder {
        private static final ProtoPresignedUrlResponse DEFAULT_INSTANCE;
        public static final int GET_FIELD_NUMBER = 2;
        private static volatile Parser<ProtoPresignedUrlResponse> PARSER = null;
        public static final int PUT_FIELD_NUMBER = 1;
        public static final int SUCCESS_FIELD_NUMBER = 3;
        private boolean success_;
        private String put_ = "";
        private String get_ = "";

        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        public static final class Builder extends GeneratedMessageLite.Builder<ProtoPresignedUrlResponse, Builder> implements ProtoPresignedUrlResponseOrBuilder {
            public Builder clearGet() {
                copyOnWrite();
                ((ProtoPresignedUrlResponse) this.instance).clearGet();
                return this;
            }

            public Builder clearPut() {
                copyOnWrite();
                ((ProtoPresignedUrlResponse) this.instance).clearPut();
                return this;
            }

            public Builder clearSuccess() {
                copyOnWrite();
                ((ProtoPresignedUrlResponse) this.instance).clearSuccess();
                return this;
            }

            @Override // cu.todus.proto.ApiProto.ProtoPresignedUrlResponseOrBuilder
            public String getGet() {
                return ((ProtoPresignedUrlResponse) this.instance).getGet();
            }

            @Override // cu.todus.proto.ApiProto.ProtoPresignedUrlResponseOrBuilder
            public ByteString getGetBytes() {
                return ((ProtoPresignedUrlResponse) this.instance).getGetBytes();
            }

            @Override // cu.todus.proto.ApiProto.ProtoPresignedUrlResponseOrBuilder
            public String getPut() {
                return ((ProtoPresignedUrlResponse) this.instance).getPut();
            }

            @Override // cu.todus.proto.ApiProto.ProtoPresignedUrlResponseOrBuilder
            public ByteString getPutBytes() {
                return ((ProtoPresignedUrlResponse) this.instance).getPutBytes();
            }

            @Override // cu.todus.proto.ApiProto.ProtoPresignedUrlResponseOrBuilder
            public boolean getSuccess() {
                return ((ProtoPresignedUrlResponse) this.instance).getSuccess();
            }

            public Builder setGet(String str) {
                copyOnWrite();
                ((ProtoPresignedUrlResponse) this.instance).setGet(str);
                return this;
            }

            public Builder setGetBytes(ByteString byteString) {
                copyOnWrite();
                ((ProtoPresignedUrlResponse) this.instance).setGetBytes(byteString);
                return this;
            }

            public Builder setPut(String str) {
                copyOnWrite();
                ((ProtoPresignedUrlResponse) this.instance).setPut(str);
                return this;
            }

            public Builder setPutBytes(ByteString byteString) {
                copyOnWrite();
                ((ProtoPresignedUrlResponse) this.instance).setPutBytes(byteString);
                return this;
            }

            public Builder setSuccess(boolean z10) {
                copyOnWrite();
                ((ProtoPresignedUrlResponse) this.instance).setSuccess(z10);
                return this;
            }

            private Builder() {
                super(ProtoPresignedUrlResponse.DEFAULT_INSTANCE);
            }
        }

        static {
            ProtoPresignedUrlResponse protoPresignedUrlResponse = new ProtoPresignedUrlResponse();
            DEFAULT_INSTANCE = protoPresignedUrlResponse;
            GeneratedMessageLite.registerDefaultInstance(ProtoPresignedUrlResponse.class, protoPresignedUrlResponse);
        }

        private ProtoPresignedUrlResponse() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearGet() {
            this.get_ = getDefaultInstance().getGet();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPut() {
            this.put_ = getDefaultInstance().getPut();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSuccess() {
            this.success_ = false;
        }

        public static ProtoPresignedUrlResponse getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static ProtoPresignedUrlResponse parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (ProtoPresignedUrlResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ProtoPresignedUrlResponse parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (ProtoPresignedUrlResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser<ProtoPresignedUrlResponse> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setGet(String str) {
            str.getClass();
            this.get_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setGetBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.get_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPut(String str) {
            str.getClass();
            this.put_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPutBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.put_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSuccess(boolean z10) {
            this.success_ = z10;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new ProtoPresignedUrlResponse();
                case 2:
                    return new Builder();
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003\u0007", new Object[]{"put_", "get_", "success_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<ProtoPresignedUrlResponse> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (ProtoPresignedUrlResponse.class) {
                        try {
                            defaultInstanceBasedParser = PARSER;
                            if (defaultInstanceBasedParser == null) {
                                defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                                PARSER = defaultInstanceBasedParser;
                            }
                        } catch (Throwable th2) {
                            throw th2;
                        }
                        break;
                    }
                    return defaultInstanceBasedParser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        @Override // cu.todus.proto.ApiProto.ProtoPresignedUrlResponseOrBuilder
        public String getGet() {
            return this.get_;
        }

        @Override // cu.todus.proto.ApiProto.ProtoPresignedUrlResponseOrBuilder
        public ByteString getGetBytes() {
            return ByteString.copyFromUtf8(this.get_);
        }

        @Override // cu.todus.proto.ApiProto.ProtoPresignedUrlResponseOrBuilder
        public String getPut() {
            return this.put_;
        }

        @Override // cu.todus.proto.ApiProto.ProtoPresignedUrlResponseOrBuilder
        public ByteString getPutBytes() {
            return ByteString.copyFromUtf8(this.put_);
        }

        @Override // cu.todus.proto.ApiProto.ProtoPresignedUrlResponseOrBuilder
        public boolean getSuccess() {
            return this.success_;
        }

        public static Builder newBuilder(ProtoPresignedUrlResponse protoPresignedUrlResponse) {
            return DEFAULT_INSTANCE.createBuilder(protoPresignedUrlResponse);
        }

        public static ProtoPresignedUrlResponse parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ProtoPresignedUrlResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ProtoPresignedUrlResponse parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ProtoPresignedUrlResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static ProtoPresignedUrlResponse parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (ProtoPresignedUrlResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static ProtoPresignedUrlResponse parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ProtoPresignedUrlResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static ProtoPresignedUrlResponse parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (ProtoPresignedUrlResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static ProtoPresignedUrlResponse parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ProtoPresignedUrlResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static ProtoPresignedUrlResponse parseFrom(InputStream inputStream) throws IOException {
            return (ProtoPresignedUrlResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ProtoPresignedUrlResponse parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ProtoPresignedUrlResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ProtoPresignedUrlResponse parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (ProtoPresignedUrlResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static ProtoPresignedUrlResponse parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ProtoPresignedUrlResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    public interface ProtoPresignedUrlResponseOrBuilder extends MessageLiteOrBuilder {
        String getGet();

        ByteString getGetBytes();

        String getPut();

        ByteString getPutBytes();

        boolean getSuccess();
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    public static final class ProtoUserAuthTokenRequest extends GeneratedMessageLite<ProtoUserAuthTokenRequest, Builder> implements ProtoUserAuthTokenRequestOrBuilder {
        private static final ProtoUserAuthTokenRequest DEFAULT_INSTANCE;
        private static volatile Parser<ProtoUserAuthTokenRequest> PARSER = null;
        public static final int PASSWORD_FIELD_NUMBER = 2;
        public static final int USERNAME_FIELD_NUMBER = 1;
        public static final int VERSION_FIELD_NUMBER = 3;
        private String username_ = "";
        private String password_ = "";
        private String version_ = "";

        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        public static final class Builder extends GeneratedMessageLite.Builder<ProtoUserAuthTokenRequest, Builder> implements ProtoUserAuthTokenRequestOrBuilder {
            public Builder clearPassword() {
                copyOnWrite();
                ((ProtoUserAuthTokenRequest) this.instance).clearPassword();
                return this;
            }

            public Builder clearUsername() {
                copyOnWrite();
                ((ProtoUserAuthTokenRequest) this.instance).clearUsername();
                return this;
            }

            public Builder clearVersion() {
                copyOnWrite();
                ((ProtoUserAuthTokenRequest) this.instance).clearVersion();
                return this;
            }

            @Override // cu.todus.proto.ApiProto.ProtoUserAuthTokenRequestOrBuilder
            public String getPassword() {
                return ((ProtoUserAuthTokenRequest) this.instance).getPassword();
            }

            @Override // cu.todus.proto.ApiProto.ProtoUserAuthTokenRequestOrBuilder
            public ByteString getPasswordBytes() {
                return ((ProtoUserAuthTokenRequest) this.instance).getPasswordBytes();
            }

            @Override // cu.todus.proto.ApiProto.ProtoUserAuthTokenRequestOrBuilder
            public String getUsername() {
                return ((ProtoUserAuthTokenRequest) this.instance).getUsername();
            }

            @Override // cu.todus.proto.ApiProto.ProtoUserAuthTokenRequestOrBuilder
            public ByteString getUsernameBytes() {
                return ((ProtoUserAuthTokenRequest) this.instance).getUsernameBytes();
            }

            @Override // cu.todus.proto.ApiProto.ProtoUserAuthTokenRequestOrBuilder
            public String getVersion() {
                return ((ProtoUserAuthTokenRequest) this.instance).getVersion();
            }

            @Override // cu.todus.proto.ApiProto.ProtoUserAuthTokenRequestOrBuilder
            public ByteString getVersionBytes() {
                return ((ProtoUserAuthTokenRequest) this.instance).getVersionBytes();
            }

            public Builder setPassword(String str) {
                copyOnWrite();
                ((ProtoUserAuthTokenRequest) this.instance).setPassword(str);
                return this;
            }

            public Builder setPasswordBytes(ByteString byteString) {
                copyOnWrite();
                ((ProtoUserAuthTokenRequest) this.instance).setPasswordBytes(byteString);
                return this;
            }

            public Builder setUsername(String str) {
                copyOnWrite();
                ((ProtoUserAuthTokenRequest) this.instance).setUsername(str);
                return this;
            }

            public Builder setUsernameBytes(ByteString byteString) {
                copyOnWrite();
                ((ProtoUserAuthTokenRequest) this.instance).setUsernameBytes(byteString);
                return this;
            }

            public Builder setVersion(String str) {
                copyOnWrite();
                ((ProtoUserAuthTokenRequest) this.instance).setVersion(str);
                return this;
            }

            public Builder setVersionBytes(ByteString byteString) {
                copyOnWrite();
                ((ProtoUserAuthTokenRequest) this.instance).setVersionBytes(byteString);
                return this;
            }

            private Builder() {
                super(ProtoUserAuthTokenRequest.DEFAULT_INSTANCE);
            }
        }

        static {
            ProtoUserAuthTokenRequest protoUserAuthTokenRequest = new ProtoUserAuthTokenRequest();
            DEFAULT_INSTANCE = protoUserAuthTokenRequest;
            GeneratedMessageLite.registerDefaultInstance(ProtoUserAuthTokenRequest.class, protoUserAuthTokenRequest);
        }

        private ProtoUserAuthTokenRequest() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPassword() {
            this.password_ = getDefaultInstance().getPassword();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearUsername() {
            this.username_ = getDefaultInstance().getUsername();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearVersion() {
            this.version_ = getDefaultInstance().getVersion();
        }

        public static ProtoUserAuthTokenRequest getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static ProtoUserAuthTokenRequest parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (ProtoUserAuthTokenRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ProtoUserAuthTokenRequest parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (ProtoUserAuthTokenRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser<ProtoUserAuthTokenRequest> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPassword(String str) {
            str.getClass();
            this.password_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPasswordBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.password_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUsername(String str) {
            str.getClass();
            this.username_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUsernameBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.username_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setVersion(String str) {
            str.getClass();
            this.version_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setVersionBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.version_ = byteString.toStringUtf8();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new ProtoUserAuthTokenRequest();
                case 2:
                    return new Builder();
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ", new Object[]{"username_", "password_", "version_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<ProtoUserAuthTokenRequest> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (ProtoUserAuthTokenRequest.class) {
                        try {
                            defaultInstanceBasedParser = PARSER;
                            if (defaultInstanceBasedParser == null) {
                                defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                                PARSER = defaultInstanceBasedParser;
                            }
                        } catch (Throwable th2) {
                            throw th2;
                        }
                        break;
                    }
                    return defaultInstanceBasedParser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        @Override // cu.todus.proto.ApiProto.ProtoUserAuthTokenRequestOrBuilder
        public String getPassword() {
            return this.password_;
        }

        @Override // cu.todus.proto.ApiProto.ProtoUserAuthTokenRequestOrBuilder
        public ByteString getPasswordBytes() {
            return ByteString.copyFromUtf8(this.password_);
        }

        @Override // cu.todus.proto.ApiProto.ProtoUserAuthTokenRequestOrBuilder
        public String getUsername() {
            return this.username_;
        }

        @Override // cu.todus.proto.ApiProto.ProtoUserAuthTokenRequestOrBuilder
        public ByteString getUsernameBytes() {
            return ByteString.copyFromUtf8(this.username_);
        }

        @Override // cu.todus.proto.ApiProto.ProtoUserAuthTokenRequestOrBuilder
        public String getVersion() {
            return this.version_;
        }

        @Override // cu.todus.proto.ApiProto.ProtoUserAuthTokenRequestOrBuilder
        public ByteString getVersionBytes() {
            return ByteString.copyFromUtf8(this.version_);
        }

        public static Builder newBuilder(ProtoUserAuthTokenRequest protoUserAuthTokenRequest) {
            return DEFAULT_INSTANCE.createBuilder(protoUserAuthTokenRequest);
        }

        public static ProtoUserAuthTokenRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ProtoUserAuthTokenRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ProtoUserAuthTokenRequest parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ProtoUserAuthTokenRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static ProtoUserAuthTokenRequest parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (ProtoUserAuthTokenRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static ProtoUserAuthTokenRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ProtoUserAuthTokenRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static ProtoUserAuthTokenRequest parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (ProtoUserAuthTokenRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static ProtoUserAuthTokenRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ProtoUserAuthTokenRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static ProtoUserAuthTokenRequest parseFrom(InputStream inputStream) throws IOException {
            return (ProtoUserAuthTokenRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ProtoUserAuthTokenRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ProtoUserAuthTokenRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ProtoUserAuthTokenRequest parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (ProtoUserAuthTokenRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static ProtoUserAuthTokenRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ProtoUserAuthTokenRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    public interface ProtoUserAuthTokenRequestOrBuilder extends MessageLiteOrBuilder {
        String getPassword();

        ByteString getPasswordBytes();

        String getUsername();

        ByteString getUsernameBytes();

        String getVersion();

        ByteString getVersionBytes();
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    public static final class ProtoUserAuthTokenResponse extends GeneratedMessageLite<ProtoUserAuthTokenResponse, Builder> implements ProtoUserAuthTokenResponseOrBuilder {
        private static final ProtoUserAuthTokenResponse DEFAULT_INSTANCE;
        public static final int EXPIRETIME_FIELD_NUMBER = 3;
        private static volatile Parser<ProtoUserAuthTokenResponse> PARSER = null;
        public static final int SUCCESS_FIELD_NUMBER = 1;
        public static final int TOKENSTRING_FIELD_NUMBER = 2;
        private long expireTime_;
        private boolean success_;
        private String tokenString_ = "";

        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        public static final class Builder extends GeneratedMessageLite.Builder<ProtoUserAuthTokenResponse, Builder> implements ProtoUserAuthTokenResponseOrBuilder {
            public Builder clearExpireTime() {
                copyOnWrite();
                ((ProtoUserAuthTokenResponse) this.instance).clearExpireTime();
                return this;
            }

            public Builder clearSuccess() {
                copyOnWrite();
                ((ProtoUserAuthTokenResponse) this.instance).clearSuccess();
                return this;
            }

            public Builder clearTokenString() {
                copyOnWrite();
                ((ProtoUserAuthTokenResponse) this.instance).clearTokenString();
                return this;
            }

            @Override // cu.todus.proto.ApiProto.ProtoUserAuthTokenResponseOrBuilder
            public long getExpireTime() {
                return ((ProtoUserAuthTokenResponse) this.instance).getExpireTime();
            }

            @Override // cu.todus.proto.ApiProto.ProtoUserAuthTokenResponseOrBuilder
            public boolean getSuccess() {
                return ((ProtoUserAuthTokenResponse) this.instance).getSuccess();
            }

            @Override // cu.todus.proto.ApiProto.ProtoUserAuthTokenResponseOrBuilder
            public String getTokenString() {
                return ((ProtoUserAuthTokenResponse) this.instance).getTokenString();
            }

            @Override // cu.todus.proto.ApiProto.ProtoUserAuthTokenResponseOrBuilder
            public ByteString getTokenStringBytes() {
                return ((ProtoUserAuthTokenResponse) this.instance).getTokenStringBytes();
            }

            public Builder setExpireTime(long j10) {
                copyOnWrite();
                ((ProtoUserAuthTokenResponse) this.instance).setExpireTime(j10);
                return this;
            }

            public Builder setSuccess(boolean z10) {
                copyOnWrite();
                ((ProtoUserAuthTokenResponse) this.instance).setSuccess(z10);
                return this;
            }

            public Builder setTokenString(String str) {
                copyOnWrite();
                ((ProtoUserAuthTokenResponse) this.instance).setTokenString(str);
                return this;
            }

            public Builder setTokenStringBytes(ByteString byteString) {
                copyOnWrite();
                ((ProtoUserAuthTokenResponse) this.instance).setTokenStringBytes(byteString);
                return this;
            }

            private Builder() {
                super(ProtoUserAuthTokenResponse.DEFAULT_INSTANCE);
            }
        }

        static {
            ProtoUserAuthTokenResponse protoUserAuthTokenResponse = new ProtoUserAuthTokenResponse();
            DEFAULT_INSTANCE = protoUserAuthTokenResponse;
            GeneratedMessageLite.registerDefaultInstance(ProtoUserAuthTokenResponse.class, protoUserAuthTokenResponse);
        }

        private ProtoUserAuthTokenResponse() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearExpireTime() {
            this.expireTime_ = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSuccess() {
            this.success_ = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearTokenString() {
            this.tokenString_ = getDefaultInstance().getTokenString();
        }

        public static ProtoUserAuthTokenResponse getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static ProtoUserAuthTokenResponse parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (ProtoUserAuthTokenResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ProtoUserAuthTokenResponse parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (ProtoUserAuthTokenResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser<ProtoUserAuthTokenResponse> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setExpireTime(long j10) {
            this.expireTime_ = j10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSuccess(boolean z10) {
            this.success_ = z10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTokenString(String str) {
            str.getClass();
            this.tokenString_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTokenStringBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.tokenString_ = byteString.toStringUtf8();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new ProtoUserAuthTokenResponse();
                case 2:
                    return new Builder();
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u0007\u0002Ȉ\u0003\u0002", new Object[]{"success_", "tokenString_", "expireTime_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<ProtoUserAuthTokenResponse> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (ProtoUserAuthTokenResponse.class) {
                        try {
                            defaultInstanceBasedParser = PARSER;
                            if (defaultInstanceBasedParser == null) {
                                defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                                PARSER = defaultInstanceBasedParser;
                            }
                        } catch (Throwable th2) {
                            throw th2;
                        }
                        break;
                    }
                    return defaultInstanceBasedParser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        @Override // cu.todus.proto.ApiProto.ProtoUserAuthTokenResponseOrBuilder
        public long getExpireTime() {
            return this.expireTime_;
        }

        @Override // cu.todus.proto.ApiProto.ProtoUserAuthTokenResponseOrBuilder
        public boolean getSuccess() {
            return this.success_;
        }

        @Override // cu.todus.proto.ApiProto.ProtoUserAuthTokenResponseOrBuilder
        public String getTokenString() {
            return this.tokenString_;
        }

        @Override // cu.todus.proto.ApiProto.ProtoUserAuthTokenResponseOrBuilder
        public ByteString getTokenStringBytes() {
            return ByteString.copyFromUtf8(this.tokenString_);
        }

        public static Builder newBuilder(ProtoUserAuthTokenResponse protoUserAuthTokenResponse) {
            return DEFAULT_INSTANCE.createBuilder(protoUserAuthTokenResponse);
        }

        public static ProtoUserAuthTokenResponse parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ProtoUserAuthTokenResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ProtoUserAuthTokenResponse parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ProtoUserAuthTokenResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static ProtoUserAuthTokenResponse parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (ProtoUserAuthTokenResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static ProtoUserAuthTokenResponse parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ProtoUserAuthTokenResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static ProtoUserAuthTokenResponse parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (ProtoUserAuthTokenResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static ProtoUserAuthTokenResponse parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ProtoUserAuthTokenResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static ProtoUserAuthTokenResponse parseFrom(InputStream inputStream) throws IOException {
            return (ProtoUserAuthTokenResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ProtoUserAuthTokenResponse parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ProtoUserAuthTokenResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ProtoUserAuthTokenResponse parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (ProtoUserAuthTokenResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static ProtoUserAuthTokenResponse parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ProtoUserAuthTokenResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    public interface ProtoUserAuthTokenResponseOrBuilder extends MessageLiteOrBuilder {
        long getExpireTime();

        boolean getSuccess();

        String getTokenString();

        ByteString getTokenStringBytes();
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    public static final class ProtoUserRegisterRequest extends GeneratedMessageLite<ProtoUserRegisterRequest, Builder> implements ProtoUserRegisterRequestOrBuilder {
        public static final int CLIENTTOKEN_FIELD_NUMBER = 2;
        public static final int CODE_FIELD_NUMBER = 3;
        private static final ProtoUserRegisterRequest DEFAULT_INSTANCE;
        private static volatile Parser<ProtoUserRegisterRequest> PARSER = null;
        public static final int USERNAME_FIELD_NUMBER = 1;
        private String username_ = "";
        private String clientToken_ = "";
        private String code_ = "";

        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        public static final class Builder extends GeneratedMessageLite.Builder<ProtoUserRegisterRequest, Builder> implements ProtoUserRegisterRequestOrBuilder {
            public Builder clearClientToken() {
                copyOnWrite();
                ((ProtoUserRegisterRequest) this.instance).clearClientToken();
                return this;
            }

            public Builder clearCode() {
                copyOnWrite();
                ((ProtoUserRegisterRequest) this.instance).clearCode();
                return this;
            }

            public Builder clearUsername() {
                copyOnWrite();
                ((ProtoUserRegisterRequest) this.instance).clearUsername();
                return this;
            }

            @Override // cu.todus.proto.ApiProto.ProtoUserRegisterRequestOrBuilder
            public String getClientToken() {
                return ((ProtoUserRegisterRequest) this.instance).getClientToken();
            }

            @Override // cu.todus.proto.ApiProto.ProtoUserRegisterRequestOrBuilder
            public ByteString getClientTokenBytes() {
                return ((ProtoUserRegisterRequest) this.instance).getClientTokenBytes();
            }

            @Override // cu.todus.proto.ApiProto.ProtoUserRegisterRequestOrBuilder
            public String getCode() {
                return ((ProtoUserRegisterRequest) this.instance).getCode();
            }

            @Override // cu.todus.proto.ApiProto.ProtoUserRegisterRequestOrBuilder
            public ByteString getCodeBytes() {
                return ((ProtoUserRegisterRequest) this.instance).getCodeBytes();
            }

            @Override // cu.todus.proto.ApiProto.ProtoUserRegisterRequestOrBuilder
            public String getUsername() {
                return ((ProtoUserRegisterRequest) this.instance).getUsername();
            }

            @Override // cu.todus.proto.ApiProto.ProtoUserRegisterRequestOrBuilder
            public ByteString getUsernameBytes() {
                return ((ProtoUserRegisterRequest) this.instance).getUsernameBytes();
            }

            public Builder setClientToken(String str) {
                copyOnWrite();
                ((ProtoUserRegisterRequest) this.instance).setClientToken(str);
                return this;
            }

            public Builder setClientTokenBytes(ByteString byteString) {
                copyOnWrite();
                ((ProtoUserRegisterRequest) this.instance).setClientTokenBytes(byteString);
                return this;
            }

            public Builder setCode(String str) {
                copyOnWrite();
                ((ProtoUserRegisterRequest) this.instance).setCode(str);
                return this;
            }

            public Builder setCodeBytes(ByteString byteString) {
                copyOnWrite();
                ((ProtoUserRegisterRequest) this.instance).setCodeBytes(byteString);
                return this;
            }

            public Builder setUsername(String str) {
                copyOnWrite();
                ((ProtoUserRegisterRequest) this.instance).setUsername(str);
                return this;
            }

            public Builder setUsernameBytes(ByteString byteString) {
                copyOnWrite();
                ((ProtoUserRegisterRequest) this.instance).setUsernameBytes(byteString);
                return this;
            }

            private Builder() {
                super(ProtoUserRegisterRequest.DEFAULT_INSTANCE);
            }
        }

        static {
            ProtoUserRegisterRequest protoUserRegisterRequest = new ProtoUserRegisterRequest();
            DEFAULT_INSTANCE = protoUserRegisterRequest;
            GeneratedMessageLite.registerDefaultInstance(ProtoUserRegisterRequest.class, protoUserRegisterRequest);
        }

        private ProtoUserRegisterRequest() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearClientToken() {
            this.clientToken_ = getDefaultInstance().getClientToken();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearCode() {
            this.code_ = getDefaultInstance().getCode();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearUsername() {
            this.username_ = getDefaultInstance().getUsername();
        }

        public static ProtoUserRegisterRequest getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static ProtoUserRegisterRequest parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (ProtoUserRegisterRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ProtoUserRegisterRequest parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (ProtoUserRegisterRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser<ProtoUserRegisterRequest> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setClientToken(String str) {
            str.getClass();
            this.clientToken_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setClientTokenBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.clientToken_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCode(String str) {
            str.getClass();
            this.code_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCodeBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.code_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUsername(String str) {
            str.getClass();
            this.username_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUsernameBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.username_ = byteString.toStringUtf8();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new ProtoUserRegisterRequest();
                case 2:
                    return new Builder();
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ", new Object[]{"username_", "clientToken_", "code_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<ProtoUserRegisterRequest> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (ProtoUserRegisterRequest.class) {
                        try {
                            defaultInstanceBasedParser = PARSER;
                            if (defaultInstanceBasedParser == null) {
                                defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                                PARSER = defaultInstanceBasedParser;
                            }
                        } catch (Throwable th2) {
                            throw th2;
                        }
                        break;
                    }
                    return defaultInstanceBasedParser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        @Override // cu.todus.proto.ApiProto.ProtoUserRegisterRequestOrBuilder
        public String getClientToken() {
            return this.clientToken_;
        }

        @Override // cu.todus.proto.ApiProto.ProtoUserRegisterRequestOrBuilder
        public ByteString getClientTokenBytes() {
            return ByteString.copyFromUtf8(this.clientToken_);
        }

        @Override // cu.todus.proto.ApiProto.ProtoUserRegisterRequestOrBuilder
        public String getCode() {
            return this.code_;
        }

        @Override // cu.todus.proto.ApiProto.ProtoUserRegisterRequestOrBuilder
        public ByteString getCodeBytes() {
            return ByteString.copyFromUtf8(this.code_);
        }

        @Override // cu.todus.proto.ApiProto.ProtoUserRegisterRequestOrBuilder
        public String getUsername() {
            return this.username_;
        }

        @Override // cu.todus.proto.ApiProto.ProtoUserRegisterRequestOrBuilder
        public ByteString getUsernameBytes() {
            return ByteString.copyFromUtf8(this.username_);
        }

        public static Builder newBuilder(ProtoUserRegisterRequest protoUserRegisterRequest) {
            return DEFAULT_INSTANCE.createBuilder(protoUserRegisterRequest);
        }

        public static ProtoUserRegisterRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ProtoUserRegisterRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ProtoUserRegisterRequest parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ProtoUserRegisterRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static ProtoUserRegisterRequest parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (ProtoUserRegisterRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static ProtoUserRegisterRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ProtoUserRegisterRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static ProtoUserRegisterRequest parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (ProtoUserRegisterRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static ProtoUserRegisterRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ProtoUserRegisterRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static ProtoUserRegisterRequest parseFrom(InputStream inputStream) throws IOException {
            return (ProtoUserRegisterRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ProtoUserRegisterRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ProtoUserRegisterRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ProtoUserRegisterRequest parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (ProtoUserRegisterRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static ProtoUserRegisterRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ProtoUserRegisterRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    public interface ProtoUserRegisterRequestOrBuilder extends MessageLiteOrBuilder {
        String getClientToken();

        ByteString getClientTokenBytes();

        String getCode();

        ByteString getCodeBytes();

        String getUsername();

        ByteString getUsernameBytes();
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    public static final class ProtoUserRegisterResponse extends GeneratedMessageLite<ProtoUserRegisterResponse, Builder> implements ProtoUserRegisterResponseOrBuilder {
        private static final ProtoUserRegisterResponse DEFAULT_INSTANCE;
        private static volatile Parser<ProtoUserRegisterResponse> PARSER = null;
        public static final int PASSWD_FIELD_NUMBER = 1;
        public static final int PROTOUSERRESERVE_FIELD_NUMBER = 2;
        private int bitField0_;
        private String passwd_ = "";
        private ProtoUserRoster protoUserReserve_;

        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        public static final class Builder extends GeneratedMessageLite.Builder<ProtoUserRegisterResponse, Builder> implements ProtoUserRegisterResponseOrBuilder {
            public Builder clearPasswd() {
                copyOnWrite();
                ((ProtoUserRegisterResponse) this.instance).clearPasswd();
                return this;
            }

            public Builder clearProtoUserReserve() {
                copyOnWrite();
                ((ProtoUserRegisterResponse) this.instance).clearProtoUserReserve();
                return this;
            }

            @Override // cu.todus.proto.ApiProto.ProtoUserRegisterResponseOrBuilder
            public String getPasswd() {
                return ((ProtoUserRegisterResponse) this.instance).getPasswd();
            }

            @Override // cu.todus.proto.ApiProto.ProtoUserRegisterResponseOrBuilder
            public ByteString getPasswdBytes() {
                return ((ProtoUserRegisterResponse) this.instance).getPasswdBytes();
            }

            @Override // cu.todus.proto.ApiProto.ProtoUserRegisterResponseOrBuilder
            public ProtoUserRoster getProtoUserReserve() {
                return ((ProtoUserRegisterResponse) this.instance).getProtoUserReserve();
            }

            @Override // cu.todus.proto.ApiProto.ProtoUserRegisterResponseOrBuilder
            public boolean hasProtoUserReserve() {
                return ((ProtoUserRegisterResponse) this.instance).hasProtoUserReserve();
            }

            public Builder mergeProtoUserReserve(ProtoUserRoster protoUserRoster) {
                copyOnWrite();
                ((ProtoUserRegisterResponse) this.instance).mergeProtoUserReserve(protoUserRoster);
                return this;
            }

            public Builder setPasswd(String str) {
                copyOnWrite();
                ((ProtoUserRegisterResponse) this.instance).setPasswd(str);
                return this;
            }

            public Builder setPasswdBytes(ByteString byteString) {
                copyOnWrite();
                ((ProtoUserRegisterResponse) this.instance).setPasswdBytes(byteString);
                return this;
            }

            public Builder setProtoUserReserve(ProtoUserRoster protoUserRoster) {
                copyOnWrite();
                ((ProtoUserRegisterResponse) this.instance).setProtoUserReserve(protoUserRoster);
                return this;
            }

            private Builder() {
                super(ProtoUserRegisterResponse.DEFAULT_INSTANCE);
            }

            public Builder setProtoUserReserve(ProtoUserRoster.Builder builder) {
                copyOnWrite();
                ((ProtoUserRegisterResponse) this.instance).setProtoUserReserve(builder.build());
                return this;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        public static final class ProtoUserRoster extends GeneratedMessageLite<ProtoUserRoster, Builder> implements ProtoUserRosterOrBuilder {
            public static final int ALIAS_FIELD_NUMBER = 2;
            private static final ProtoUserRoster DEFAULT_INSTANCE;
            public static final int DESCRIPTION_FIELD_NUMBER = 4;
            private static volatile Parser<ProtoUserRoster> PARSER = null;
            public static final int PICTUREURL_FIELD_NUMBER = 3;
            public static final int TODUSID_FIELD_NUMBER = 6;
            public static final int USERNAME_FIELD_NUMBER = 1;
            public static final int VERSION_FIELD_NUMBER = 5;
            private long version_;
            private String username_ = "";
            private String alias_ = "";
            private String pictureUrl_ = "";
            private String description_ = "";
            private String toDusId_ = "";

            /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
            public static final class Builder extends GeneratedMessageLite.Builder<ProtoUserRoster, Builder> implements ProtoUserRosterOrBuilder {
                public Builder clearAlias() {
                    copyOnWrite();
                    ((ProtoUserRoster) this.instance).clearAlias();
                    return this;
                }

                public Builder clearDescription() {
                    copyOnWrite();
                    ((ProtoUserRoster) this.instance).clearDescription();
                    return this;
                }

                public Builder clearPictureUrl() {
                    copyOnWrite();
                    ((ProtoUserRoster) this.instance).clearPictureUrl();
                    return this;
                }

                public Builder clearToDusId() {
                    copyOnWrite();
                    ((ProtoUserRoster) this.instance).clearToDusId();
                    return this;
                }

                public Builder clearUsername() {
                    copyOnWrite();
                    ((ProtoUserRoster) this.instance).clearUsername();
                    return this;
                }

                public Builder clearVersion() {
                    copyOnWrite();
                    ((ProtoUserRoster) this.instance).clearVersion();
                    return this;
                }

                @Override // cu.todus.proto.ApiProto.ProtoUserRegisterResponse.ProtoUserRosterOrBuilder
                public String getAlias() {
                    return ((ProtoUserRoster) this.instance).getAlias();
                }

                @Override // cu.todus.proto.ApiProto.ProtoUserRegisterResponse.ProtoUserRosterOrBuilder
                public ByteString getAliasBytes() {
                    return ((ProtoUserRoster) this.instance).getAliasBytes();
                }

                @Override // cu.todus.proto.ApiProto.ProtoUserRegisterResponse.ProtoUserRosterOrBuilder
                public String getDescription() {
                    return ((ProtoUserRoster) this.instance).getDescription();
                }

                @Override // cu.todus.proto.ApiProto.ProtoUserRegisterResponse.ProtoUserRosterOrBuilder
                public ByteString getDescriptionBytes() {
                    return ((ProtoUserRoster) this.instance).getDescriptionBytes();
                }

                @Override // cu.todus.proto.ApiProto.ProtoUserRegisterResponse.ProtoUserRosterOrBuilder
                public String getPictureUrl() {
                    return ((ProtoUserRoster) this.instance).getPictureUrl();
                }

                @Override // cu.todus.proto.ApiProto.ProtoUserRegisterResponse.ProtoUserRosterOrBuilder
                public ByteString getPictureUrlBytes() {
                    return ((ProtoUserRoster) this.instance).getPictureUrlBytes();
                }

                @Override // cu.todus.proto.ApiProto.ProtoUserRegisterResponse.ProtoUserRosterOrBuilder
                public String getToDusId() {
                    return ((ProtoUserRoster) this.instance).getToDusId();
                }

                @Override // cu.todus.proto.ApiProto.ProtoUserRegisterResponse.ProtoUserRosterOrBuilder
                public ByteString getToDusIdBytes() {
                    return ((ProtoUserRoster) this.instance).getToDusIdBytes();
                }

                @Override // cu.todus.proto.ApiProto.ProtoUserRegisterResponse.ProtoUserRosterOrBuilder
                public String getUsername() {
                    return ((ProtoUserRoster) this.instance).getUsername();
                }

                @Override // cu.todus.proto.ApiProto.ProtoUserRegisterResponse.ProtoUserRosterOrBuilder
                public ByteString getUsernameBytes() {
                    return ((ProtoUserRoster) this.instance).getUsernameBytes();
                }

                @Override // cu.todus.proto.ApiProto.ProtoUserRegisterResponse.ProtoUserRosterOrBuilder
                public long getVersion() {
                    return ((ProtoUserRoster) this.instance).getVersion();
                }

                public Builder setAlias(String str) {
                    copyOnWrite();
                    ((ProtoUserRoster) this.instance).setAlias(str);
                    return this;
                }

                public Builder setAliasBytes(ByteString byteString) {
                    copyOnWrite();
                    ((ProtoUserRoster) this.instance).setAliasBytes(byteString);
                    return this;
                }

                public Builder setDescription(String str) {
                    copyOnWrite();
                    ((ProtoUserRoster) this.instance).setDescription(str);
                    return this;
                }

                public Builder setDescriptionBytes(ByteString byteString) {
                    copyOnWrite();
                    ((ProtoUserRoster) this.instance).setDescriptionBytes(byteString);
                    return this;
                }

                public Builder setPictureUrl(String str) {
                    copyOnWrite();
                    ((ProtoUserRoster) this.instance).setPictureUrl(str);
                    return this;
                }

                public Builder setPictureUrlBytes(ByteString byteString) {
                    copyOnWrite();
                    ((ProtoUserRoster) this.instance).setPictureUrlBytes(byteString);
                    return this;
                }

                public Builder setToDusId(String str) {
                    copyOnWrite();
                    ((ProtoUserRoster) this.instance).setToDusId(str);
                    return this;
                }

                public Builder setToDusIdBytes(ByteString byteString) {
                    copyOnWrite();
                    ((ProtoUserRoster) this.instance).setToDusIdBytes(byteString);
                    return this;
                }

                public Builder setUsername(String str) {
                    copyOnWrite();
                    ((ProtoUserRoster) this.instance).setUsername(str);
                    return this;
                }

                public Builder setUsernameBytes(ByteString byteString) {
                    copyOnWrite();
                    ((ProtoUserRoster) this.instance).setUsernameBytes(byteString);
                    return this;
                }

                public Builder setVersion(long j10) {
                    copyOnWrite();
                    ((ProtoUserRoster) this.instance).setVersion(j10);
                    return this;
                }

                private Builder() {
                    super(ProtoUserRoster.DEFAULT_INSTANCE);
                }
            }

            static {
                ProtoUserRoster protoUserRoster = new ProtoUserRoster();
                DEFAULT_INSTANCE = protoUserRoster;
                GeneratedMessageLite.registerDefaultInstance(ProtoUserRoster.class, protoUserRoster);
            }

            private ProtoUserRoster() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearAlias() {
                this.alias_ = getDefaultInstance().getAlias();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearDescription() {
                this.description_ = getDefaultInstance().getDescription();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearPictureUrl() {
                this.pictureUrl_ = getDefaultInstance().getPictureUrl();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearToDusId() {
                this.toDusId_ = getDefaultInstance().getToDusId();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearUsername() {
                this.username_ = getDefaultInstance().getUsername();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearVersion() {
                this.version_ = 0L;
            }

            public static ProtoUserRoster getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.createBuilder();
            }

            public static ProtoUserRoster parseDelimitedFrom(InputStream inputStream) throws IOException {
                return (ProtoUserRoster) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static ProtoUserRoster parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
                return (ProtoUserRoster) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
            }

            public static Parser<ProtoUserRoster> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setAlias(String str) {
                str.getClass();
                this.alias_ = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setAliasBytes(ByteString byteString) {
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.alias_ = byteString.toStringUtf8();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setDescription(String str) {
                str.getClass();
                this.description_ = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setDescriptionBytes(ByteString byteString) {
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.description_ = byteString.toStringUtf8();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setPictureUrl(String str) {
                str.getClass();
                this.pictureUrl_ = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setPictureUrlBytes(ByteString byteString) {
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.pictureUrl_ = byteString.toStringUtf8();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setToDusId(String str) {
                str.getClass();
                this.toDusId_ = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setToDusIdBytes(ByteString byteString) {
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.toDusId_ = byteString.toStringUtf8();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setUsername(String str) {
                str.getClass();
                this.username_ = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setUsernameBytes(ByteString byteString) {
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.username_ = byteString.toStringUtf8();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setVersion(long j10) {
                this.version_ = j10;
            }

            @Override // com.google.protobuf.GeneratedMessageLite
            public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                Parser defaultInstanceBasedParser;
                switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                    case 1:
                        return new ProtoUserRoster();
                    case 2:
                        return new Builder();
                    case 3:
                        return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0006\u0000\u0000\u0001\u0006\u0006\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ\u0004Ȉ\u0005\u0002\u0006Ȉ", new Object[]{"username_", "alias_", "pictureUrl_", "description_", "version_", "toDusId_"});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        Parser<ProtoUserRoster> parser = PARSER;
                        if (parser != null) {
                            return parser;
                        }
                        synchronized (ProtoUserRoster.class) {
                            try {
                                defaultInstanceBasedParser = PARSER;
                                if (defaultInstanceBasedParser == null) {
                                    defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                                    PARSER = defaultInstanceBasedParser;
                                }
                            } catch (Throwable th2) {
                                throw th2;
                            }
                            break;
                        }
                        return defaultInstanceBasedParser;
                    case 6:
                        return (byte) 1;
                    case 7:
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }

            @Override // cu.todus.proto.ApiProto.ProtoUserRegisterResponse.ProtoUserRosterOrBuilder
            public String getAlias() {
                return this.alias_;
            }

            @Override // cu.todus.proto.ApiProto.ProtoUserRegisterResponse.ProtoUserRosterOrBuilder
            public ByteString getAliasBytes() {
                return ByteString.copyFromUtf8(this.alias_);
            }

            @Override // cu.todus.proto.ApiProto.ProtoUserRegisterResponse.ProtoUserRosterOrBuilder
            public String getDescription() {
                return this.description_;
            }

            @Override // cu.todus.proto.ApiProto.ProtoUserRegisterResponse.ProtoUserRosterOrBuilder
            public ByteString getDescriptionBytes() {
                return ByteString.copyFromUtf8(this.description_);
            }

            @Override // cu.todus.proto.ApiProto.ProtoUserRegisterResponse.ProtoUserRosterOrBuilder
            public String getPictureUrl() {
                return this.pictureUrl_;
            }

            @Override // cu.todus.proto.ApiProto.ProtoUserRegisterResponse.ProtoUserRosterOrBuilder
            public ByteString getPictureUrlBytes() {
                return ByteString.copyFromUtf8(this.pictureUrl_);
            }

            @Override // cu.todus.proto.ApiProto.ProtoUserRegisterResponse.ProtoUserRosterOrBuilder
            public String getToDusId() {
                return this.toDusId_;
            }

            @Override // cu.todus.proto.ApiProto.ProtoUserRegisterResponse.ProtoUserRosterOrBuilder
            public ByteString getToDusIdBytes() {
                return ByteString.copyFromUtf8(this.toDusId_);
            }

            @Override // cu.todus.proto.ApiProto.ProtoUserRegisterResponse.ProtoUserRosterOrBuilder
            public String getUsername() {
                return this.username_;
            }

            @Override // cu.todus.proto.ApiProto.ProtoUserRegisterResponse.ProtoUserRosterOrBuilder
            public ByteString getUsernameBytes() {
                return ByteString.copyFromUtf8(this.username_);
            }

            @Override // cu.todus.proto.ApiProto.ProtoUserRegisterResponse.ProtoUserRosterOrBuilder
            public long getVersion() {
                return this.version_;
            }

            public static Builder newBuilder(ProtoUserRoster protoUserRoster) {
                return DEFAULT_INSTANCE.createBuilder(protoUserRoster);
            }

            public static ProtoUserRoster parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (ProtoUserRoster) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static ProtoUserRoster parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (ProtoUserRoster) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
            }

            public static ProtoUserRoster parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                return (ProtoUserRoster) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
            }

            public static ProtoUserRoster parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (ProtoUserRoster) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
            }

            public static ProtoUserRoster parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                return (ProtoUserRoster) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
            }

            public static ProtoUserRoster parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (ProtoUserRoster) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
            }

            public static ProtoUserRoster parseFrom(InputStream inputStream) throws IOException {
                return (ProtoUserRoster) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static ProtoUserRoster parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (ProtoUserRoster) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static ProtoUserRoster parseFrom(CodedInputStream codedInputStream) throws IOException {
                return (ProtoUserRoster) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
            }

            public static ProtoUserRoster parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (ProtoUserRoster) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        public interface ProtoUserRosterOrBuilder extends MessageLiteOrBuilder {
            String getAlias();

            ByteString getAliasBytes();

            String getDescription();

            ByteString getDescriptionBytes();

            String getPictureUrl();

            ByteString getPictureUrlBytes();

            String getToDusId();

            ByteString getToDusIdBytes();

            String getUsername();

            ByteString getUsernameBytes();

            long getVersion();
        }

        static {
            ProtoUserRegisterResponse protoUserRegisterResponse = new ProtoUserRegisterResponse();
            DEFAULT_INSTANCE = protoUserRegisterResponse;
            GeneratedMessageLite.registerDefaultInstance(ProtoUserRegisterResponse.class, protoUserRegisterResponse);
        }

        private ProtoUserRegisterResponse() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPasswd() {
            this.passwd_ = getDefaultInstance().getPasswd();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearProtoUserReserve() {
            this.protoUserReserve_ = null;
            this.bitField0_ &= -2;
        }

        public static ProtoUserRegisterResponse getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeProtoUserReserve(ProtoUserRoster protoUserRoster) {
            protoUserRoster.getClass();
            ProtoUserRoster protoUserRoster2 = this.protoUserReserve_;
            if (protoUserRoster2 == null || protoUserRoster2 == ProtoUserRoster.getDefaultInstance()) {
                this.protoUserReserve_ = protoUserRoster;
            } else {
                this.protoUserReserve_ = ProtoUserRoster.newBuilder(this.protoUserReserve_).mergeFrom(protoUserRoster).buildPartial();
            }
            this.bitField0_ |= 1;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static ProtoUserRegisterResponse parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (ProtoUserRegisterResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ProtoUserRegisterResponse parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (ProtoUserRegisterResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser<ProtoUserRegisterResponse> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPasswd(String str) {
            str.getClass();
            this.passwd_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPasswdBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.passwd_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setProtoUserReserve(ProtoUserRoster protoUserRoster) {
            protoUserRoster.getClass();
            this.protoUserReserve_ = protoUserRoster;
            this.bitField0_ |= 1;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new ProtoUserRegisterResponse();
                case 2:
                    return new Builder();
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002ဉ\u0000", new Object[]{"bitField0_", "passwd_", "protoUserReserve_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<ProtoUserRegisterResponse> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (ProtoUserRegisterResponse.class) {
                        try {
                            defaultInstanceBasedParser = PARSER;
                            if (defaultInstanceBasedParser == null) {
                                defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                                PARSER = defaultInstanceBasedParser;
                            }
                        } catch (Throwable th2) {
                            throw th2;
                        }
                        break;
                    }
                    return defaultInstanceBasedParser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        @Override // cu.todus.proto.ApiProto.ProtoUserRegisterResponseOrBuilder
        public String getPasswd() {
            return this.passwd_;
        }

        @Override // cu.todus.proto.ApiProto.ProtoUserRegisterResponseOrBuilder
        public ByteString getPasswdBytes() {
            return ByteString.copyFromUtf8(this.passwd_);
        }

        @Override // cu.todus.proto.ApiProto.ProtoUserRegisterResponseOrBuilder
        public ProtoUserRoster getProtoUserReserve() {
            ProtoUserRoster protoUserRoster = this.protoUserReserve_;
            return protoUserRoster == null ? ProtoUserRoster.getDefaultInstance() : protoUserRoster;
        }

        @Override // cu.todus.proto.ApiProto.ProtoUserRegisterResponseOrBuilder
        public boolean hasProtoUserReserve() {
            return (this.bitField0_ & 1) != 0;
        }

        public static Builder newBuilder(ProtoUserRegisterResponse protoUserRegisterResponse) {
            return DEFAULT_INSTANCE.createBuilder(protoUserRegisterResponse);
        }

        public static ProtoUserRegisterResponse parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ProtoUserRegisterResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ProtoUserRegisterResponse parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ProtoUserRegisterResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static ProtoUserRegisterResponse parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (ProtoUserRegisterResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static ProtoUserRegisterResponse parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ProtoUserRegisterResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static ProtoUserRegisterResponse parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (ProtoUserRegisterResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static ProtoUserRegisterResponse parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ProtoUserRegisterResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static ProtoUserRegisterResponse parseFrom(InputStream inputStream) throws IOException {
            return (ProtoUserRegisterResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ProtoUserRegisterResponse parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ProtoUserRegisterResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ProtoUserRegisterResponse parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (ProtoUserRegisterResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static ProtoUserRegisterResponse parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ProtoUserRegisterResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    public interface ProtoUserRegisterResponseOrBuilder extends MessageLiteOrBuilder {
        String getPasswd();

        ByteString getPasswdBytes();

        ProtoUserRegisterResponse.ProtoUserRoster getProtoUserReserve();

        boolean hasProtoUserReserve();
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    public static final class ProtoUserReserveRequest extends GeneratedMessageLite<ProtoUserReserveRequest, Builder> implements ProtoUserReserveRequestOrBuilder {
        public static final int CLIENTTOKEN_FIELD_NUMBER = 2;
        private static final ProtoUserReserveRequest DEFAULT_INSTANCE;
        private static volatile Parser<ProtoUserReserveRequest> PARSER = null;
        public static final int USERNAME_FIELD_NUMBER = 1;
        private String username_ = "";
        private String clientToken_ = "";

        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        public static final class Builder extends GeneratedMessageLite.Builder<ProtoUserReserveRequest, Builder> implements ProtoUserReserveRequestOrBuilder {
            public Builder clearClientToken() {
                copyOnWrite();
                ((ProtoUserReserveRequest) this.instance).clearClientToken();
                return this;
            }

            public Builder clearUsername() {
                copyOnWrite();
                ((ProtoUserReserveRequest) this.instance).clearUsername();
                return this;
            }

            @Override // cu.todus.proto.ApiProto.ProtoUserReserveRequestOrBuilder
            public String getClientToken() {
                return ((ProtoUserReserveRequest) this.instance).getClientToken();
            }

            @Override // cu.todus.proto.ApiProto.ProtoUserReserveRequestOrBuilder
            public ByteString getClientTokenBytes() {
                return ((ProtoUserReserveRequest) this.instance).getClientTokenBytes();
            }

            @Override // cu.todus.proto.ApiProto.ProtoUserReserveRequestOrBuilder
            public String getUsername() {
                return ((ProtoUserReserveRequest) this.instance).getUsername();
            }

            @Override // cu.todus.proto.ApiProto.ProtoUserReserveRequestOrBuilder
            public ByteString getUsernameBytes() {
                return ((ProtoUserReserveRequest) this.instance).getUsernameBytes();
            }

            public Builder setClientToken(String str) {
                copyOnWrite();
                ((ProtoUserReserveRequest) this.instance).setClientToken(str);
                return this;
            }

            public Builder setClientTokenBytes(ByteString byteString) {
                copyOnWrite();
                ((ProtoUserReserveRequest) this.instance).setClientTokenBytes(byteString);
                return this;
            }

            public Builder setUsername(String str) {
                copyOnWrite();
                ((ProtoUserReserveRequest) this.instance).setUsername(str);
                return this;
            }

            public Builder setUsernameBytes(ByteString byteString) {
                copyOnWrite();
                ((ProtoUserReserveRequest) this.instance).setUsernameBytes(byteString);
                return this;
            }

            private Builder() {
                super(ProtoUserReserveRequest.DEFAULT_INSTANCE);
            }
        }

        static {
            ProtoUserReserveRequest protoUserReserveRequest = new ProtoUserReserveRequest();
            DEFAULT_INSTANCE = protoUserReserveRequest;
            GeneratedMessageLite.registerDefaultInstance(ProtoUserReserveRequest.class, protoUserReserveRequest);
        }

        private ProtoUserReserveRequest() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearClientToken() {
            this.clientToken_ = getDefaultInstance().getClientToken();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearUsername() {
            this.username_ = getDefaultInstance().getUsername();
        }

        public static ProtoUserReserveRequest getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static ProtoUserReserveRequest parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (ProtoUserReserveRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ProtoUserReserveRequest parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (ProtoUserReserveRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser<ProtoUserReserveRequest> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setClientToken(String str) {
            str.getClass();
            this.clientToken_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setClientTokenBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.clientToken_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUsername(String str) {
            str.getClass();
            this.username_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUsernameBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.username_ = byteString.toStringUtf8();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new ProtoUserReserveRequest();
                case 2:
                    return new Builder();
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ", new Object[]{"username_", "clientToken_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<ProtoUserReserveRequest> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (ProtoUserReserveRequest.class) {
                        try {
                            defaultInstanceBasedParser = PARSER;
                            if (defaultInstanceBasedParser == null) {
                                defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                                PARSER = defaultInstanceBasedParser;
                            }
                        } catch (Throwable th2) {
                            throw th2;
                        }
                        break;
                    }
                    return defaultInstanceBasedParser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        @Override // cu.todus.proto.ApiProto.ProtoUserReserveRequestOrBuilder
        public String getClientToken() {
            return this.clientToken_;
        }

        @Override // cu.todus.proto.ApiProto.ProtoUserReserveRequestOrBuilder
        public ByteString getClientTokenBytes() {
            return ByteString.copyFromUtf8(this.clientToken_);
        }

        @Override // cu.todus.proto.ApiProto.ProtoUserReserveRequestOrBuilder
        public String getUsername() {
            return this.username_;
        }

        @Override // cu.todus.proto.ApiProto.ProtoUserReserveRequestOrBuilder
        public ByteString getUsernameBytes() {
            return ByteString.copyFromUtf8(this.username_);
        }

        public static Builder newBuilder(ProtoUserReserveRequest protoUserReserveRequest) {
            return DEFAULT_INSTANCE.createBuilder(protoUserReserveRequest);
        }

        public static ProtoUserReserveRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ProtoUserReserveRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ProtoUserReserveRequest parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ProtoUserReserveRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static ProtoUserReserveRequest parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (ProtoUserReserveRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static ProtoUserReserveRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ProtoUserReserveRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static ProtoUserReserveRequest parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (ProtoUserReserveRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static ProtoUserReserveRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ProtoUserReserveRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static ProtoUserReserveRequest parseFrom(InputStream inputStream) throws IOException {
            return (ProtoUserReserveRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ProtoUserReserveRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ProtoUserReserveRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ProtoUserReserveRequest parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (ProtoUserReserveRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static ProtoUserReserveRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ProtoUserReserveRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    public interface ProtoUserReserveRequestOrBuilder extends MessageLiteOrBuilder {
        String getClientToken();

        ByteString getClientTokenBytes();

        String getUsername();

        ByteString getUsernameBytes();
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    public static final class ProtoUsersMeRequest extends GeneratedMessageLite<ProtoUsersMeRequest, Builder> implements ProtoUsersMeRequestOrBuilder {
        private static final ProtoUsersMeRequest DEFAULT_INSTANCE;
        private static volatile Parser<ProtoUsersMeRequest> PARSER = null;
        public static final int USERINFO_FIELD_NUMBER = 1;
        private MapFieldLite<String, String> userInfo_ = MapFieldLite.emptyMapField();

        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        public static final class Builder extends GeneratedMessageLite.Builder<ProtoUsersMeRequest, Builder> implements ProtoUsersMeRequestOrBuilder {
            public Builder clearUserInfo() {
                copyOnWrite();
                ((ProtoUsersMeRequest) this.instance).getMutableUserInfoMap().clear();
                return this;
            }

            @Override // cu.todus.proto.ApiProto.ProtoUsersMeRequestOrBuilder
            public boolean containsUserInfo(String str) {
                str.getClass();
                return ((ProtoUsersMeRequest) this.instance).getUserInfoMap().containsKey(str);
            }

            @Override // cu.todus.proto.ApiProto.ProtoUsersMeRequestOrBuilder
            @Deprecated
            public Map<String, String> getUserInfo() {
                return getUserInfoMap();
            }

            @Override // cu.todus.proto.ApiProto.ProtoUsersMeRequestOrBuilder
            public int getUserInfoCount() {
                return ((ProtoUsersMeRequest) this.instance).getUserInfoMap().size();
            }

            @Override // cu.todus.proto.ApiProto.ProtoUsersMeRequestOrBuilder
            public Map<String, String> getUserInfoMap() {
                return DesugarCollections.unmodifiableMap(((ProtoUsersMeRequest) this.instance).getUserInfoMap());
            }

            @Override // cu.todus.proto.ApiProto.ProtoUsersMeRequestOrBuilder
            public String getUserInfoOrDefault(String str, String str2) {
                str.getClass();
                Map<String, String> userInfoMap = ((ProtoUsersMeRequest) this.instance).getUserInfoMap();
                return userInfoMap.containsKey(str) ? userInfoMap.get(str) : str2;
            }

            @Override // cu.todus.proto.ApiProto.ProtoUsersMeRequestOrBuilder
            public String getUserInfoOrThrow(String str) {
                str.getClass();
                Map<String, String> userInfoMap = ((ProtoUsersMeRequest) this.instance).getUserInfoMap();
                if (userInfoMap.containsKey(str)) {
                    return userInfoMap.get(str);
                }
                throw new IllegalArgumentException();
            }

            public Builder putAllUserInfo(Map<String, String> map) {
                copyOnWrite();
                ((ProtoUsersMeRequest) this.instance).getMutableUserInfoMap().putAll(map);
                return this;
            }

            public Builder putUserInfo(String str, String str2) {
                str.getClass();
                str2.getClass();
                copyOnWrite();
                ((ProtoUsersMeRequest) this.instance).getMutableUserInfoMap().put(str, str2);
                return this;
            }

            public Builder removeUserInfo(String str) {
                str.getClass();
                copyOnWrite();
                ((ProtoUsersMeRequest) this.instance).getMutableUserInfoMap().remove(str);
                return this;
            }

            private Builder() {
                super(ProtoUsersMeRequest.DEFAULT_INSTANCE);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        public static final class UserInfoDefaultEntryHolder {
            static final MapEntryLite<String, String> defaultEntry;

            static {
                WireFormat.FieldType fieldType = WireFormat.FieldType.STRING;
                defaultEntry = MapEntryLite.newDefaultInstance(fieldType, "", fieldType, "");
            }

            private UserInfoDefaultEntryHolder() {
            }
        }

        static {
            ProtoUsersMeRequest protoUsersMeRequest = new ProtoUsersMeRequest();
            DEFAULT_INSTANCE = protoUsersMeRequest;
            GeneratedMessageLite.registerDefaultInstance(ProtoUsersMeRequest.class, protoUsersMeRequest);
        }

        private ProtoUsersMeRequest() {
        }

        public static ProtoUsersMeRequest getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Map<String, String> getMutableUserInfoMap() {
            return internalGetMutableUserInfo();
        }

        private MapFieldLite<String, String> internalGetMutableUserInfo() {
            if (!this.userInfo_.isMutable()) {
                this.userInfo_ = this.userInfo_.mutableCopy();
            }
            return this.userInfo_;
        }

        private MapFieldLite<String, String> internalGetUserInfo() {
            return this.userInfo_;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static ProtoUsersMeRequest parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (ProtoUsersMeRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ProtoUsersMeRequest parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (ProtoUsersMeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser<ProtoUsersMeRequest> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        @Override // cu.todus.proto.ApiProto.ProtoUsersMeRequestOrBuilder
        public boolean containsUserInfo(String str) {
            str.getClass();
            return internalGetUserInfo().containsKey(str);
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new ProtoUsersMeRequest();
                case 2:
                    return new Builder();
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u00012", new Object[]{"userInfo_", UserInfoDefaultEntryHolder.defaultEntry});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<ProtoUsersMeRequest> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (ProtoUsersMeRequest.class) {
                        try {
                            defaultInstanceBasedParser = PARSER;
                            if (defaultInstanceBasedParser == null) {
                                defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                                PARSER = defaultInstanceBasedParser;
                            }
                        } catch (Throwable th2) {
                            throw th2;
                        }
                        break;
                    }
                    return defaultInstanceBasedParser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        @Override // cu.todus.proto.ApiProto.ProtoUsersMeRequestOrBuilder
        @Deprecated
        public Map<String, String> getUserInfo() {
            return getUserInfoMap();
        }

        @Override // cu.todus.proto.ApiProto.ProtoUsersMeRequestOrBuilder
        public int getUserInfoCount() {
            return internalGetUserInfo().size();
        }

        @Override // cu.todus.proto.ApiProto.ProtoUsersMeRequestOrBuilder
        public Map<String, String> getUserInfoMap() {
            return DesugarCollections.unmodifiableMap(internalGetUserInfo());
        }

        @Override // cu.todus.proto.ApiProto.ProtoUsersMeRequestOrBuilder
        public String getUserInfoOrDefault(String str, String str2) {
            str.getClass();
            MapFieldLite<String, String> mapFieldLiteInternalGetUserInfo = internalGetUserInfo();
            return mapFieldLiteInternalGetUserInfo.containsKey(str) ? mapFieldLiteInternalGetUserInfo.get(str) : str2;
        }

        @Override // cu.todus.proto.ApiProto.ProtoUsersMeRequestOrBuilder
        public String getUserInfoOrThrow(String str) {
            str.getClass();
            MapFieldLite<String, String> mapFieldLiteInternalGetUserInfo = internalGetUserInfo();
            if (mapFieldLiteInternalGetUserInfo.containsKey(str)) {
                return mapFieldLiteInternalGetUserInfo.get(str);
            }
            throw new IllegalArgumentException();
        }

        public static Builder newBuilder(ProtoUsersMeRequest protoUsersMeRequest) {
            return DEFAULT_INSTANCE.createBuilder(protoUsersMeRequest);
        }

        public static ProtoUsersMeRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ProtoUsersMeRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ProtoUsersMeRequest parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ProtoUsersMeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static ProtoUsersMeRequest parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (ProtoUsersMeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static ProtoUsersMeRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ProtoUsersMeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static ProtoUsersMeRequest parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (ProtoUsersMeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static ProtoUsersMeRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ProtoUsersMeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static ProtoUsersMeRequest parseFrom(InputStream inputStream) throws IOException {
            return (ProtoUsersMeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ProtoUsersMeRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ProtoUsersMeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ProtoUsersMeRequest parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (ProtoUsersMeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static ProtoUsersMeRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ProtoUsersMeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    public interface ProtoUsersMeRequestOrBuilder extends MessageLiteOrBuilder {
        boolean containsUserInfo(String str);

        @Deprecated
        Map<String, String> getUserInfo();

        int getUserInfoCount();

        Map<String, String> getUserInfoMap();

        String getUserInfoOrDefault(String str, String str2);

        String getUserInfoOrThrow(String str);
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    public static final class ProtoUsersMeResponse extends GeneratedMessageLite<ProtoUsersMeResponse, Builder> implements ProtoUsersMeResponseOrBuilder {
        private static final ProtoUsersMeResponse DEFAULT_INSTANCE;
        private static volatile Parser<ProtoUsersMeResponse> PARSER = null;
        public static final int SUCCESS_FIELD_NUMBER = 1;
        private boolean success_;

        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        public static final class Builder extends GeneratedMessageLite.Builder<ProtoUsersMeResponse, Builder> implements ProtoUsersMeResponseOrBuilder {
            public Builder clearSuccess() {
                copyOnWrite();
                ((ProtoUsersMeResponse) this.instance).clearSuccess();
                return this;
            }

            @Override // cu.todus.proto.ApiProto.ProtoUsersMeResponseOrBuilder
            public boolean getSuccess() {
                return ((ProtoUsersMeResponse) this.instance).getSuccess();
            }

            public Builder setSuccess(boolean z10) {
                copyOnWrite();
                ((ProtoUsersMeResponse) this.instance).setSuccess(z10);
                return this;
            }

            private Builder() {
                super(ProtoUsersMeResponse.DEFAULT_INSTANCE);
            }
        }

        static {
            ProtoUsersMeResponse protoUsersMeResponse = new ProtoUsersMeResponse();
            DEFAULT_INSTANCE = protoUsersMeResponse;
            GeneratedMessageLite.registerDefaultInstance(ProtoUsersMeResponse.class, protoUsersMeResponse);
        }

        private ProtoUsersMeResponse() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSuccess() {
            this.success_ = false;
        }

        public static ProtoUsersMeResponse getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static ProtoUsersMeResponse parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (ProtoUsersMeResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ProtoUsersMeResponse parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (ProtoUsersMeResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser<ProtoUsersMeResponse> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSuccess(boolean z10) {
            this.success_ = z10;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new ProtoUsersMeResponse();
                case 2:
                    return new Builder();
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0007", new Object[]{"success_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<ProtoUsersMeResponse> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (ProtoUsersMeResponse.class) {
                        try {
                            defaultInstanceBasedParser = PARSER;
                            if (defaultInstanceBasedParser == null) {
                                defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                                PARSER = defaultInstanceBasedParser;
                            }
                        } catch (Throwable th2) {
                            throw th2;
                        }
                        break;
                    }
                    return defaultInstanceBasedParser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        @Override // cu.todus.proto.ApiProto.ProtoUsersMeResponseOrBuilder
        public boolean getSuccess() {
            return this.success_;
        }

        public static Builder newBuilder(ProtoUsersMeResponse protoUsersMeResponse) {
            return DEFAULT_INSTANCE.createBuilder(protoUsersMeResponse);
        }

        public static ProtoUsersMeResponse parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ProtoUsersMeResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ProtoUsersMeResponse parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ProtoUsersMeResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static ProtoUsersMeResponse parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (ProtoUsersMeResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static ProtoUsersMeResponse parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ProtoUsersMeResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static ProtoUsersMeResponse parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (ProtoUsersMeResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static ProtoUsersMeResponse parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ProtoUsersMeResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static ProtoUsersMeResponse parseFrom(InputStream inputStream) throws IOException {
            return (ProtoUsersMeResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ProtoUsersMeResponse parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ProtoUsersMeResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ProtoUsersMeResponse parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (ProtoUsersMeResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static ProtoUsersMeResponse parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ProtoUsersMeResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    public interface ProtoUsersMeResponseOrBuilder extends MessageLiteOrBuilder {
        boolean getSuccess();
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    public static final class ProtoUsersRosterRequest extends GeneratedMessageLite<ProtoUsersRosterRequest, Builder> implements ProtoUsersRosterRequestOrBuilder {
        private static final ProtoUsersRosterRequest DEFAULT_INSTANCE;
        public static final int NUMBERS_FIELD_NUMBER = 1;
        private static volatile Parser<ProtoUsersRosterRequest> PARSER;
        private Internal.ProtobufList<String> numbers_ = GeneratedMessageLite.emptyProtobufList();

        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        public static final class Builder extends GeneratedMessageLite.Builder<ProtoUsersRosterRequest, Builder> implements ProtoUsersRosterRequestOrBuilder {
            public Builder addAllNumbers(Iterable<String> iterable) {
                copyOnWrite();
                ((ProtoUsersRosterRequest) this.instance).addAllNumbers(iterable);
                return this;
            }

            public Builder addNumbers(String str) {
                copyOnWrite();
                ((ProtoUsersRosterRequest) this.instance).addNumbers(str);
                return this;
            }

            public Builder addNumbersBytes(ByteString byteString) {
                copyOnWrite();
                ((ProtoUsersRosterRequest) this.instance).addNumbersBytes(byteString);
                return this;
            }

            public Builder clearNumbers() {
                copyOnWrite();
                ((ProtoUsersRosterRequest) this.instance).clearNumbers();
                return this;
            }

            @Override // cu.todus.proto.ApiProto.ProtoUsersRosterRequestOrBuilder
            public String getNumbers(int i10) {
                return ((ProtoUsersRosterRequest) this.instance).getNumbers(i10);
            }

            @Override // cu.todus.proto.ApiProto.ProtoUsersRosterRequestOrBuilder
            public ByteString getNumbersBytes(int i10) {
                return ((ProtoUsersRosterRequest) this.instance).getNumbersBytes(i10);
            }

            @Override // cu.todus.proto.ApiProto.ProtoUsersRosterRequestOrBuilder
            public int getNumbersCount() {
                return ((ProtoUsersRosterRequest) this.instance).getNumbersCount();
            }

            @Override // cu.todus.proto.ApiProto.ProtoUsersRosterRequestOrBuilder
            public List<String> getNumbersList() {
                return DesugarCollections.unmodifiableList(((ProtoUsersRosterRequest) this.instance).getNumbersList());
            }

            public Builder setNumbers(int i10, String str) {
                copyOnWrite();
                ((ProtoUsersRosterRequest) this.instance).setNumbers(i10, str);
                return this;
            }

            private Builder() {
                super(ProtoUsersRosterRequest.DEFAULT_INSTANCE);
            }
        }

        static {
            ProtoUsersRosterRequest protoUsersRosterRequest = new ProtoUsersRosterRequest();
            DEFAULT_INSTANCE = protoUsersRosterRequest;
            GeneratedMessageLite.registerDefaultInstance(ProtoUsersRosterRequest.class, protoUsersRosterRequest);
        }

        private ProtoUsersRosterRequest() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllNumbers(Iterable<String> iterable) {
            ensureNumbersIsMutable();
            AbstractMessageLite.addAll((Iterable) iterable, (List) this.numbers_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addNumbers(String str) {
            str.getClass();
            ensureNumbersIsMutable();
            this.numbers_.add(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addNumbersBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            ensureNumbersIsMutable();
            this.numbers_.add(byteString.toStringUtf8());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearNumbers() {
            this.numbers_ = GeneratedMessageLite.emptyProtobufList();
        }

        private void ensureNumbersIsMutable() {
            Internal.ProtobufList<String> protobufList = this.numbers_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.numbers_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        public static ProtoUsersRosterRequest getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static ProtoUsersRosterRequest parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (ProtoUsersRosterRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ProtoUsersRosterRequest parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (ProtoUsersRosterRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser<ProtoUsersRosterRequest> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setNumbers(int i10, String str) {
            str.getClass();
            ensureNumbersIsMutable();
            this.numbers_.set(i10, str);
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new ProtoUsersRosterRequest();
                case 2:
                    return new Builder();
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001Ț", new Object[]{"numbers_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<ProtoUsersRosterRequest> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (ProtoUsersRosterRequest.class) {
                        try {
                            defaultInstanceBasedParser = PARSER;
                            if (defaultInstanceBasedParser == null) {
                                defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                                PARSER = defaultInstanceBasedParser;
                            }
                        } catch (Throwable th2) {
                            throw th2;
                        }
                        break;
                    }
                    return defaultInstanceBasedParser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        @Override // cu.todus.proto.ApiProto.ProtoUsersRosterRequestOrBuilder
        public String getNumbers(int i10) {
            return this.numbers_.get(i10);
        }

        @Override // cu.todus.proto.ApiProto.ProtoUsersRosterRequestOrBuilder
        public ByteString getNumbersBytes(int i10) {
            return ByteString.copyFromUtf8(this.numbers_.get(i10));
        }

        @Override // cu.todus.proto.ApiProto.ProtoUsersRosterRequestOrBuilder
        public int getNumbersCount() {
            return this.numbers_.size();
        }

        @Override // cu.todus.proto.ApiProto.ProtoUsersRosterRequestOrBuilder
        public List<String> getNumbersList() {
            return this.numbers_;
        }

        public static Builder newBuilder(ProtoUsersRosterRequest protoUsersRosterRequest) {
            return DEFAULT_INSTANCE.createBuilder(protoUsersRosterRequest);
        }

        public static ProtoUsersRosterRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ProtoUsersRosterRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ProtoUsersRosterRequest parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ProtoUsersRosterRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static ProtoUsersRosterRequest parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (ProtoUsersRosterRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static ProtoUsersRosterRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ProtoUsersRosterRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static ProtoUsersRosterRequest parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (ProtoUsersRosterRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static ProtoUsersRosterRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ProtoUsersRosterRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static ProtoUsersRosterRequest parseFrom(InputStream inputStream) throws IOException {
            return (ProtoUsersRosterRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ProtoUsersRosterRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ProtoUsersRosterRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ProtoUsersRosterRequest parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (ProtoUsersRosterRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static ProtoUsersRosterRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ProtoUsersRosterRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    public interface ProtoUsersRosterRequestOrBuilder extends MessageLiteOrBuilder {
        String getNumbers(int i10);

        ByteString getNumbersBytes(int i10);

        int getNumbersCount();

        List<String> getNumbersList();
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    public static final class ProtoUsersRosterResponse extends GeneratedMessageLite<ProtoUsersRosterResponse, Builder> implements ProtoUsersRosterResponseOrBuilder {
        private static final ProtoUsersRosterResponse DEFAULT_INSTANCE;
        private static volatile Parser<ProtoUsersRosterResponse> PARSER = null;
        public static final int SUCCESS_FIELD_NUMBER = 2;
        public static final int USERROSTER_FIELD_NUMBER = 1;
        private boolean success_;
        private Internal.ProtobufList<ProtoUserRoster> userRoster_ = GeneratedMessageLite.emptyProtobufList();

        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        public static final class Builder extends GeneratedMessageLite.Builder<ProtoUsersRosterResponse, Builder> implements ProtoUsersRosterResponseOrBuilder {
            public Builder addAllUserRoster(Iterable<? extends ProtoUserRoster> iterable) {
                copyOnWrite();
                ((ProtoUsersRosterResponse) this.instance).addAllUserRoster(iterable);
                return this;
            }

            public Builder addUserRoster(ProtoUserRoster protoUserRoster) {
                copyOnWrite();
                ((ProtoUsersRosterResponse) this.instance).addUserRoster(protoUserRoster);
                return this;
            }

            public Builder clearSuccess() {
                copyOnWrite();
                ((ProtoUsersRosterResponse) this.instance).clearSuccess();
                return this;
            }

            public Builder clearUserRoster() {
                copyOnWrite();
                ((ProtoUsersRosterResponse) this.instance).clearUserRoster();
                return this;
            }

            @Override // cu.todus.proto.ApiProto.ProtoUsersRosterResponseOrBuilder
            public boolean getSuccess() {
                return ((ProtoUsersRosterResponse) this.instance).getSuccess();
            }

            @Override // cu.todus.proto.ApiProto.ProtoUsersRosterResponseOrBuilder
            public ProtoUserRoster getUserRoster(int i10) {
                return ((ProtoUsersRosterResponse) this.instance).getUserRoster(i10);
            }

            @Override // cu.todus.proto.ApiProto.ProtoUsersRosterResponseOrBuilder
            public int getUserRosterCount() {
                return ((ProtoUsersRosterResponse) this.instance).getUserRosterCount();
            }

            @Override // cu.todus.proto.ApiProto.ProtoUsersRosterResponseOrBuilder
            public List<ProtoUserRoster> getUserRosterList() {
                return DesugarCollections.unmodifiableList(((ProtoUsersRosterResponse) this.instance).getUserRosterList());
            }

            public Builder removeUserRoster(int i10) {
                copyOnWrite();
                ((ProtoUsersRosterResponse) this.instance).removeUserRoster(i10);
                return this;
            }

            public Builder setSuccess(boolean z10) {
                copyOnWrite();
                ((ProtoUsersRosterResponse) this.instance).setSuccess(z10);
                return this;
            }

            public Builder setUserRoster(int i10, ProtoUserRoster protoUserRoster) {
                copyOnWrite();
                ((ProtoUsersRosterResponse) this.instance).setUserRoster(i10, protoUserRoster);
                return this;
            }

            private Builder() {
                super(ProtoUsersRosterResponse.DEFAULT_INSTANCE);
            }

            public Builder addUserRoster(int i10, ProtoUserRoster protoUserRoster) {
                copyOnWrite();
                ((ProtoUsersRosterResponse) this.instance).addUserRoster(i10, protoUserRoster);
                return this;
            }

            public Builder setUserRoster(int i10, ProtoUserRoster.Builder builder) {
                copyOnWrite();
                ((ProtoUsersRosterResponse) this.instance).setUserRoster(i10, builder.build());
                return this;
            }

            public Builder addUserRoster(ProtoUserRoster.Builder builder) {
                copyOnWrite();
                ((ProtoUsersRosterResponse) this.instance).addUserRoster(builder.build());
                return this;
            }

            public Builder addUserRoster(int i10, ProtoUserRoster.Builder builder) {
                copyOnWrite();
                ((ProtoUsersRosterResponse) this.instance).addUserRoster(i10, builder.build());
                return this;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        public static final class ProtoUserRoster extends GeneratedMessageLite<ProtoUserRoster, Builder> implements ProtoUserRosterOrBuilder {
            private static final ProtoUserRoster DEFAULT_INSTANCE;
            private static volatile Parser<ProtoUserRoster> PARSER = null;
            public static final int TODUSID_FIELD_NUMBER = 4;
            public static final int USERINFO_FIELD_NUMBER = 3;
            public static final int USERNAME_FIELD_NUMBER = 1;
            public static final int VERSION_FIELD_NUMBER = 2;
            private long version_;
            private MapFieldLite<String, String> userInfo_ = MapFieldLite.emptyMapField();
            private String username_ = "";
            private String toDusId_ = "";

            /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
            public static final class Builder extends GeneratedMessageLite.Builder<ProtoUserRoster, Builder> implements ProtoUserRosterOrBuilder {
                public Builder clearToDusId() {
                    copyOnWrite();
                    ((ProtoUserRoster) this.instance).clearToDusId();
                    return this;
                }

                public Builder clearUserInfo() {
                    copyOnWrite();
                    ((ProtoUserRoster) this.instance).getMutableUserInfoMap().clear();
                    return this;
                }

                public Builder clearUsername() {
                    copyOnWrite();
                    ((ProtoUserRoster) this.instance).clearUsername();
                    return this;
                }

                public Builder clearVersion() {
                    copyOnWrite();
                    ((ProtoUserRoster) this.instance).clearVersion();
                    return this;
                }

                @Override // cu.todus.proto.ApiProto.ProtoUsersRosterResponse.ProtoUserRosterOrBuilder
                public boolean containsUserInfo(String str) {
                    str.getClass();
                    return ((ProtoUserRoster) this.instance).getUserInfoMap().containsKey(str);
                }

                @Override // cu.todus.proto.ApiProto.ProtoUsersRosterResponse.ProtoUserRosterOrBuilder
                public String getToDusId() {
                    return ((ProtoUserRoster) this.instance).getToDusId();
                }

                @Override // cu.todus.proto.ApiProto.ProtoUsersRosterResponse.ProtoUserRosterOrBuilder
                public ByteString getToDusIdBytes() {
                    return ((ProtoUserRoster) this.instance).getToDusIdBytes();
                }

                @Override // cu.todus.proto.ApiProto.ProtoUsersRosterResponse.ProtoUserRosterOrBuilder
                @Deprecated
                public Map<String, String> getUserInfo() {
                    return getUserInfoMap();
                }

                @Override // cu.todus.proto.ApiProto.ProtoUsersRosterResponse.ProtoUserRosterOrBuilder
                public int getUserInfoCount() {
                    return ((ProtoUserRoster) this.instance).getUserInfoMap().size();
                }

                @Override // cu.todus.proto.ApiProto.ProtoUsersRosterResponse.ProtoUserRosterOrBuilder
                public Map<String, String> getUserInfoMap() {
                    return DesugarCollections.unmodifiableMap(((ProtoUserRoster) this.instance).getUserInfoMap());
                }

                @Override // cu.todus.proto.ApiProto.ProtoUsersRosterResponse.ProtoUserRosterOrBuilder
                public String getUserInfoOrDefault(String str, String str2) {
                    str.getClass();
                    Map<String, String> userInfoMap = ((ProtoUserRoster) this.instance).getUserInfoMap();
                    return userInfoMap.containsKey(str) ? userInfoMap.get(str) : str2;
                }

                @Override // cu.todus.proto.ApiProto.ProtoUsersRosterResponse.ProtoUserRosterOrBuilder
                public String getUserInfoOrThrow(String str) {
                    str.getClass();
                    Map<String, String> userInfoMap = ((ProtoUserRoster) this.instance).getUserInfoMap();
                    if (userInfoMap.containsKey(str)) {
                        return userInfoMap.get(str);
                    }
                    throw new IllegalArgumentException();
                }

                @Override // cu.todus.proto.ApiProto.ProtoUsersRosterResponse.ProtoUserRosterOrBuilder
                public String getUsername() {
                    return ((ProtoUserRoster) this.instance).getUsername();
                }

                @Override // cu.todus.proto.ApiProto.ProtoUsersRosterResponse.ProtoUserRosterOrBuilder
                public ByteString getUsernameBytes() {
                    return ((ProtoUserRoster) this.instance).getUsernameBytes();
                }

                @Override // cu.todus.proto.ApiProto.ProtoUsersRosterResponse.ProtoUserRosterOrBuilder
                public long getVersion() {
                    return ((ProtoUserRoster) this.instance).getVersion();
                }

                public Builder putAllUserInfo(Map<String, String> map) {
                    copyOnWrite();
                    ((ProtoUserRoster) this.instance).getMutableUserInfoMap().putAll(map);
                    return this;
                }

                public Builder putUserInfo(String str, String str2) {
                    str.getClass();
                    str2.getClass();
                    copyOnWrite();
                    ((ProtoUserRoster) this.instance).getMutableUserInfoMap().put(str, str2);
                    return this;
                }

                public Builder removeUserInfo(String str) {
                    str.getClass();
                    copyOnWrite();
                    ((ProtoUserRoster) this.instance).getMutableUserInfoMap().remove(str);
                    return this;
                }

                public Builder setToDusId(String str) {
                    copyOnWrite();
                    ((ProtoUserRoster) this.instance).setToDusId(str);
                    return this;
                }

                public Builder setToDusIdBytes(ByteString byteString) {
                    copyOnWrite();
                    ((ProtoUserRoster) this.instance).setToDusIdBytes(byteString);
                    return this;
                }

                public Builder setUsername(String str) {
                    copyOnWrite();
                    ((ProtoUserRoster) this.instance).setUsername(str);
                    return this;
                }

                public Builder setUsernameBytes(ByteString byteString) {
                    copyOnWrite();
                    ((ProtoUserRoster) this.instance).setUsernameBytes(byteString);
                    return this;
                }

                public Builder setVersion(long j10) {
                    copyOnWrite();
                    ((ProtoUserRoster) this.instance).setVersion(j10);
                    return this;
                }

                private Builder() {
                    super(ProtoUserRoster.DEFAULT_INSTANCE);
                }
            }

            /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
            public static final class UserInfoDefaultEntryHolder {
                static final MapEntryLite<String, String> defaultEntry;

                static {
                    WireFormat.FieldType fieldType = WireFormat.FieldType.STRING;
                    defaultEntry = MapEntryLite.newDefaultInstance(fieldType, "", fieldType, "");
                }

                private UserInfoDefaultEntryHolder() {
                }
            }

            static {
                ProtoUserRoster protoUserRoster = new ProtoUserRoster();
                DEFAULT_INSTANCE = protoUserRoster;
                GeneratedMessageLite.registerDefaultInstance(ProtoUserRoster.class, protoUserRoster);
            }

            private ProtoUserRoster() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearToDusId() {
                this.toDusId_ = getDefaultInstance().getToDusId();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearUsername() {
                this.username_ = getDefaultInstance().getUsername();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearVersion() {
                this.version_ = 0L;
            }

            public static ProtoUserRoster getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public Map<String, String> getMutableUserInfoMap() {
                return internalGetMutableUserInfo();
            }

            private MapFieldLite<String, String> internalGetMutableUserInfo() {
                if (!this.userInfo_.isMutable()) {
                    this.userInfo_ = this.userInfo_.mutableCopy();
                }
                return this.userInfo_;
            }

            private MapFieldLite<String, String> internalGetUserInfo() {
                return this.userInfo_;
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.createBuilder();
            }

            public static ProtoUserRoster parseDelimitedFrom(InputStream inputStream) throws IOException {
                return (ProtoUserRoster) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static ProtoUserRoster parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
                return (ProtoUserRoster) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
            }

            public static Parser<ProtoUserRoster> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setToDusId(String str) {
                str.getClass();
                this.toDusId_ = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setToDusIdBytes(ByteString byteString) {
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.toDusId_ = byteString.toStringUtf8();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setUsername(String str) {
                str.getClass();
                this.username_ = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setUsernameBytes(ByteString byteString) {
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.username_ = byteString.toStringUtf8();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setVersion(long j10) {
                this.version_ = j10;
            }

            @Override // cu.todus.proto.ApiProto.ProtoUsersRosterResponse.ProtoUserRosterOrBuilder
            public boolean containsUserInfo(String str) {
                str.getClass();
                return internalGetUserInfo().containsKey(str);
            }

            @Override // com.google.protobuf.GeneratedMessageLite
            public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                Parser defaultInstanceBasedParser;
                switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                    case 1:
                        return new ProtoUserRoster();
                    case 2:
                        return new Builder();
                    case 3:
                        return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0001\u0000\u0000\u0001Ȉ\u0002\u0002\u00032\u0004Ȉ", new Object[]{"username_", "version_", "userInfo_", UserInfoDefaultEntryHolder.defaultEntry, "toDusId_"});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        Parser<ProtoUserRoster> parser = PARSER;
                        if (parser != null) {
                            return parser;
                        }
                        synchronized (ProtoUserRoster.class) {
                            try {
                                defaultInstanceBasedParser = PARSER;
                                if (defaultInstanceBasedParser == null) {
                                    defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                                    PARSER = defaultInstanceBasedParser;
                                }
                            } catch (Throwable th2) {
                                throw th2;
                            }
                            break;
                        }
                        return defaultInstanceBasedParser;
                    case 6:
                        return (byte) 1;
                    case 7:
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }

            @Override // cu.todus.proto.ApiProto.ProtoUsersRosterResponse.ProtoUserRosterOrBuilder
            public String getToDusId() {
                return this.toDusId_;
            }

            @Override // cu.todus.proto.ApiProto.ProtoUsersRosterResponse.ProtoUserRosterOrBuilder
            public ByteString getToDusIdBytes() {
                return ByteString.copyFromUtf8(this.toDusId_);
            }

            @Override // cu.todus.proto.ApiProto.ProtoUsersRosterResponse.ProtoUserRosterOrBuilder
            @Deprecated
            public Map<String, String> getUserInfo() {
                return getUserInfoMap();
            }

            @Override // cu.todus.proto.ApiProto.ProtoUsersRosterResponse.ProtoUserRosterOrBuilder
            public int getUserInfoCount() {
                return internalGetUserInfo().size();
            }

            @Override // cu.todus.proto.ApiProto.ProtoUsersRosterResponse.ProtoUserRosterOrBuilder
            public Map<String, String> getUserInfoMap() {
                return DesugarCollections.unmodifiableMap(internalGetUserInfo());
            }

            @Override // cu.todus.proto.ApiProto.ProtoUsersRosterResponse.ProtoUserRosterOrBuilder
            public String getUserInfoOrDefault(String str, String str2) {
                str.getClass();
                MapFieldLite<String, String> mapFieldLiteInternalGetUserInfo = internalGetUserInfo();
                return mapFieldLiteInternalGetUserInfo.containsKey(str) ? mapFieldLiteInternalGetUserInfo.get(str) : str2;
            }

            @Override // cu.todus.proto.ApiProto.ProtoUsersRosterResponse.ProtoUserRosterOrBuilder
            public String getUserInfoOrThrow(String str) {
                str.getClass();
                MapFieldLite<String, String> mapFieldLiteInternalGetUserInfo = internalGetUserInfo();
                if (mapFieldLiteInternalGetUserInfo.containsKey(str)) {
                    return mapFieldLiteInternalGetUserInfo.get(str);
                }
                throw new IllegalArgumentException();
            }

            @Override // cu.todus.proto.ApiProto.ProtoUsersRosterResponse.ProtoUserRosterOrBuilder
            public String getUsername() {
                return this.username_;
            }

            @Override // cu.todus.proto.ApiProto.ProtoUsersRosterResponse.ProtoUserRosterOrBuilder
            public ByteString getUsernameBytes() {
                return ByteString.copyFromUtf8(this.username_);
            }

            @Override // cu.todus.proto.ApiProto.ProtoUsersRosterResponse.ProtoUserRosterOrBuilder
            public long getVersion() {
                return this.version_;
            }

            public static Builder newBuilder(ProtoUserRoster protoUserRoster) {
                return DEFAULT_INSTANCE.createBuilder(protoUserRoster);
            }

            public static ProtoUserRoster parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (ProtoUserRoster) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static ProtoUserRoster parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (ProtoUserRoster) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
            }

            public static ProtoUserRoster parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                return (ProtoUserRoster) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
            }

            public static ProtoUserRoster parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (ProtoUserRoster) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
            }

            public static ProtoUserRoster parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                return (ProtoUserRoster) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
            }

            public static ProtoUserRoster parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (ProtoUserRoster) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
            }

            public static ProtoUserRoster parseFrom(InputStream inputStream) throws IOException {
                return (ProtoUserRoster) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static ProtoUserRoster parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (ProtoUserRoster) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static ProtoUserRoster parseFrom(CodedInputStream codedInputStream) throws IOException {
                return (ProtoUserRoster) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
            }

            public static ProtoUserRoster parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (ProtoUserRoster) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        public interface ProtoUserRosterOrBuilder extends MessageLiteOrBuilder {
            boolean containsUserInfo(String str);

            String getToDusId();

            ByteString getToDusIdBytes();

            @Deprecated
            Map<String, String> getUserInfo();

            int getUserInfoCount();

            Map<String, String> getUserInfoMap();

            String getUserInfoOrDefault(String str, String str2);

            String getUserInfoOrThrow(String str);

            String getUsername();

            ByteString getUsernameBytes();

            long getVersion();
        }

        static {
            ProtoUsersRosterResponse protoUsersRosterResponse = new ProtoUsersRosterResponse();
            DEFAULT_INSTANCE = protoUsersRosterResponse;
            GeneratedMessageLite.registerDefaultInstance(ProtoUsersRosterResponse.class, protoUsersRosterResponse);
        }

        private ProtoUsersRosterResponse() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllUserRoster(Iterable<? extends ProtoUserRoster> iterable) {
            ensureUserRosterIsMutable();
            AbstractMessageLite.addAll((Iterable) iterable, (List) this.userRoster_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addUserRoster(ProtoUserRoster protoUserRoster) {
            protoUserRoster.getClass();
            ensureUserRosterIsMutable();
            this.userRoster_.add(protoUserRoster);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSuccess() {
            this.success_ = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearUserRoster() {
            this.userRoster_ = GeneratedMessageLite.emptyProtobufList();
        }

        private void ensureUserRosterIsMutable() {
            Internal.ProtobufList<ProtoUserRoster> protobufList = this.userRoster_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.userRoster_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        public static ProtoUsersRosterResponse getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static ProtoUsersRosterResponse parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (ProtoUsersRosterResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ProtoUsersRosterResponse parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (ProtoUsersRosterResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser<ProtoUsersRosterResponse> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeUserRoster(int i10) {
            ensureUserRosterIsMutable();
            this.userRoster_.remove(i10);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSuccess(boolean z10) {
            this.success_ = z10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUserRoster(int i10, ProtoUserRoster protoUserRoster) {
            protoUserRoster.getClass();
            ensureUserRosterIsMutable();
            this.userRoster_.set(i10, protoUserRoster);
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new ProtoUsersRosterResponse();
                case 2:
                    return new Builder();
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u001b\u0002\u0007", new Object[]{"userRoster_", ProtoUserRoster.class, "success_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<ProtoUsersRosterResponse> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (ProtoUsersRosterResponse.class) {
                        try {
                            defaultInstanceBasedParser = PARSER;
                            if (defaultInstanceBasedParser == null) {
                                defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                                PARSER = defaultInstanceBasedParser;
                            }
                        } catch (Throwable th2) {
                            throw th2;
                        }
                        break;
                    }
                    return defaultInstanceBasedParser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        @Override // cu.todus.proto.ApiProto.ProtoUsersRosterResponseOrBuilder
        public boolean getSuccess() {
            return this.success_;
        }

        @Override // cu.todus.proto.ApiProto.ProtoUsersRosterResponseOrBuilder
        public ProtoUserRoster getUserRoster(int i10) {
            return this.userRoster_.get(i10);
        }

        @Override // cu.todus.proto.ApiProto.ProtoUsersRosterResponseOrBuilder
        public int getUserRosterCount() {
            return this.userRoster_.size();
        }

        @Override // cu.todus.proto.ApiProto.ProtoUsersRosterResponseOrBuilder
        public List<ProtoUserRoster> getUserRosterList() {
            return this.userRoster_;
        }

        public ProtoUserRosterOrBuilder getUserRosterOrBuilder(int i10) {
            return this.userRoster_.get(i10);
        }

        public List<? extends ProtoUserRosterOrBuilder> getUserRosterOrBuilderList() {
            return this.userRoster_;
        }

        public static Builder newBuilder(ProtoUsersRosterResponse protoUsersRosterResponse) {
            return DEFAULT_INSTANCE.createBuilder(protoUsersRosterResponse);
        }

        public static ProtoUsersRosterResponse parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ProtoUsersRosterResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ProtoUsersRosterResponse parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ProtoUsersRosterResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static ProtoUsersRosterResponse parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (ProtoUsersRosterResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addUserRoster(int i10, ProtoUserRoster protoUserRoster) {
            protoUserRoster.getClass();
            ensureUserRosterIsMutable();
            this.userRoster_.add(i10, protoUserRoster);
        }

        public static ProtoUsersRosterResponse parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ProtoUsersRosterResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static ProtoUsersRosterResponse parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (ProtoUsersRosterResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static ProtoUsersRosterResponse parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ProtoUsersRosterResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static ProtoUsersRosterResponse parseFrom(InputStream inputStream) throws IOException {
            return (ProtoUsersRosterResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ProtoUsersRosterResponse parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ProtoUsersRosterResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ProtoUsersRosterResponse parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (ProtoUsersRosterResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static ProtoUsersRosterResponse parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ProtoUsersRosterResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    public interface ProtoUsersRosterResponseOrBuilder extends MessageLiteOrBuilder {
        boolean getSuccess();

        ProtoUsersRosterResponse.ProtoUserRoster getUserRoster(int i10);

        int getUserRosterCount();

        List<ProtoUsersRosterResponse.ProtoUserRoster> getUserRosterList();
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    public static final class SubscribeToChannelReq extends GeneratedMessageLite<SubscribeToChannelReq, Builder> implements SubscribeToChannelReqOrBuilder {
        public static final int CHANNEL_USERNAME_FIELD_NUMBER = 1;
        private static final SubscribeToChannelReq DEFAULT_INSTANCE;
        private static volatile Parser<SubscribeToChannelReq> PARSER = null;
        public static final int USER_DOMAIN_FIELD_NUMBER = 2;
        private String channelUsername_ = "";
        private String userDomain_ = "";

        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        public static final class Builder extends GeneratedMessageLite.Builder<SubscribeToChannelReq, Builder> implements SubscribeToChannelReqOrBuilder {
            public Builder clearChannelUsername() {
                copyOnWrite();
                ((SubscribeToChannelReq) this.instance).clearChannelUsername();
                return this;
            }

            public Builder clearUserDomain() {
                copyOnWrite();
                ((SubscribeToChannelReq) this.instance).clearUserDomain();
                return this;
            }

            @Override // cu.todus.proto.ApiProto.SubscribeToChannelReqOrBuilder
            public String getChannelUsername() {
                return ((SubscribeToChannelReq) this.instance).getChannelUsername();
            }

            @Override // cu.todus.proto.ApiProto.SubscribeToChannelReqOrBuilder
            public ByteString getChannelUsernameBytes() {
                return ((SubscribeToChannelReq) this.instance).getChannelUsernameBytes();
            }

            @Override // cu.todus.proto.ApiProto.SubscribeToChannelReqOrBuilder
            public String getUserDomain() {
                return ((SubscribeToChannelReq) this.instance).getUserDomain();
            }

            @Override // cu.todus.proto.ApiProto.SubscribeToChannelReqOrBuilder
            public ByteString getUserDomainBytes() {
                return ((SubscribeToChannelReq) this.instance).getUserDomainBytes();
            }

            public Builder setChannelUsername(String str) {
                copyOnWrite();
                ((SubscribeToChannelReq) this.instance).setChannelUsername(str);
                return this;
            }

            public Builder setChannelUsernameBytes(ByteString byteString) {
                copyOnWrite();
                ((SubscribeToChannelReq) this.instance).setChannelUsernameBytes(byteString);
                return this;
            }

            public Builder setUserDomain(String str) {
                copyOnWrite();
                ((SubscribeToChannelReq) this.instance).setUserDomain(str);
                return this;
            }

            public Builder setUserDomainBytes(ByteString byteString) {
                copyOnWrite();
                ((SubscribeToChannelReq) this.instance).setUserDomainBytes(byteString);
                return this;
            }

            private Builder() {
                super(SubscribeToChannelReq.DEFAULT_INSTANCE);
            }
        }

        static {
            SubscribeToChannelReq subscribeToChannelReq = new SubscribeToChannelReq();
            DEFAULT_INSTANCE = subscribeToChannelReq;
            GeneratedMessageLite.registerDefaultInstance(SubscribeToChannelReq.class, subscribeToChannelReq);
        }

        private SubscribeToChannelReq() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearChannelUsername() {
            this.channelUsername_ = getDefaultInstance().getChannelUsername();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearUserDomain() {
            this.userDomain_ = getDefaultInstance().getUserDomain();
        }

        public static SubscribeToChannelReq getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static SubscribeToChannelReq parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (SubscribeToChannelReq) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static SubscribeToChannelReq parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (SubscribeToChannelReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser<SubscribeToChannelReq> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setChannelUsername(String str) {
            str.getClass();
            this.channelUsername_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setChannelUsernameBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.channelUsername_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUserDomain(String str) {
            str.getClass();
            this.userDomain_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUserDomainBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.userDomain_ = byteString.toStringUtf8();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new SubscribeToChannelReq();
                case 2:
                    return new Builder();
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ", new Object[]{"channelUsername_", "userDomain_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<SubscribeToChannelReq> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (SubscribeToChannelReq.class) {
                        try {
                            defaultInstanceBasedParser = PARSER;
                            if (defaultInstanceBasedParser == null) {
                                defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                                PARSER = defaultInstanceBasedParser;
                            }
                        } catch (Throwable th2) {
                            throw th2;
                        }
                        break;
                    }
                    return defaultInstanceBasedParser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        @Override // cu.todus.proto.ApiProto.SubscribeToChannelReqOrBuilder
        public String getChannelUsername() {
            return this.channelUsername_;
        }

        @Override // cu.todus.proto.ApiProto.SubscribeToChannelReqOrBuilder
        public ByteString getChannelUsernameBytes() {
            return ByteString.copyFromUtf8(this.channelUsername_);
        }

        @Override // cu.todus.proto.ApiProto.SubscribeToChannelReqOrBuilder
        public String getUserDomain() {
            return this.userDomain_;
        }

        @Override // cu.todus.proto.ApiProto.SubscribeToChannelReqOrBuilder
        public ByteString getUserDomainBytes() {
            return ByteString.copyFromUtf8(this.userDomain_);
        }

        public static Builder newBuilder(SubscribeToChannelReq subscribeToChannelReq) {
            return DEFAULT_INSTANCE.createBuilder(subscribeToChannelReq);
        }

        public static SubscribeToChannelReq parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SubscribeToChannelReq) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static SubscribeToChannelReq parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (SubscribeToChannelReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static SubscribeToChannelReq parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (SubscribeToChannelReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static SubscribeToChannelReq parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (SubscribeToChannelReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static SubscribeToChannelReq parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (SubscribeToChannelReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static SubscribeToChannelReq parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (SubscribeToChannelReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static SubscribeToChannelReq parseFrom(InputStream inputStream) throws IOException {
            return (SubscribeToChannelReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static SubscribeToChannelReq parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SubscribeToChannelReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static SubscribeToChannelReq parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (SubscribeToChannelReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static SubscribeToChannelReq parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SubscribeToChannelReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    public interface SubscribeToChannelReqOrBuilder extends MessageLiteOrBuilder {
        String getChannelUsername();

        ByteString getChannelUsernameBytes();

        String getUserDomain();

        ByteString getUserDomainBytes();
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    public static final class SubscribeToChannelResp extends GeneratedMessageLite<SubscribeToChannelResp, Builder> implements SubscribeToChannelRespOrBuilder {
        private static final SubscribeToChannelResp DEFAULT_INSTANCE;
        public static final int MSG_FIELD_NUMBER = 1;
        private static volatile Parser<SubscribeToChannelResp> PARSER;
        private int msg_;

        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        public static final class Builder extends GeneratedMessageLite.Builder<SubscribeToChannelResp, Builder> implements SubscribeToChannelRespOrBuilder {
            public Builder clearMsg() {
                copyOnWrite();
                ((SubscribeToChannelResp) this.instance).clearMsg();
                return this;
            }

            @Override // cu.todus.proto.ApiProto.SubscribeToChannelRespOrBuilder
            public MessageErrors getMsg() {
                return ((SubscribeToChannelResp) this.instance).getMsg();
            }

            @Override // cu.todus.proto.ApiProto.SubscribeToChannelRespOrBuilder
            public int getMsgValue() {
                return ((SubscribeToChannelResp) this.instance).getMsgValue();
            }

            public Builder setMsg(MessageErrors messageErrors) {
                copyOnWrite();
                ((SubscribeToChannelResp) this.instance).setMsg(messageErrors);
                return this;
            }

            public Builder setMsgValue(int i10) {
                copyOnWrite();
                ((SubscribeToChannelResp) this.instance).setMsgValue(i10);
                return this;
            }

            private Builder() {
                super(SubscribeToChannelResp.DEFAULT_INSTANCE);
            }
        }

        static {
            SubscribeToChannelResp subscribeToChannelResp = new SubscribeToChannelResp();
            DEFAULT_INSTANCE = subscribeToChannelResp;
            GeneratedMessageLite.registerDefaultInstance(SubscribeToChannelResp.class, subscribeToChannelResp);
        }

        private SubscribeToChannelResp() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearMsg() {
            this.msg_ = 0;
        }

        public static SubscribeToChannelResp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static SubscribeToChannelResp parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (SubscribeToChannelResp) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static SubscribeToChannelResp parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (SubscribeToChannelResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser<SubscribeToChannelResp> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMsg(MessageErrors messageErrors) {
            this.msg_ = messageErrors.getNumber();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMsgValue(int i10) {
            this.msg_ = i10;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new SubscribeToChannelResp();
                case 2:
                    return new Builder();
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\f", new Object[]{"msg_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<SubscribeToChannelResp> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (SubscribeToChannelResp.class) {
                        try {
                            defaultInstanceBasedParser = PARSER;
                            if (defaultInstanceBasedParser == null) {
                                defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                                PARSER = defaultInstanceBasedParser;
                            }
                        } catch (Throwable th2) {
                            throw th2;
                        }
                        break;
                    }
                    return defaultInstanceBasedParser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        @Override // cu.todus.proto.ApiProto.SubscribeToChannelRespOrBuilder
        public MessageErrors getMsg() {
            MessageErrors messageErrorsForNumber = MessageErrors.forNumber(this.msg_);
            return messageErrorsForNumber == null ? MessageErrors.UNRECOGNIZED : messageErrorsForNumber;
        }

        @Override // cu.todus.proto.ApiProto.SubscribeToChannelRespOrBuilder
        public int getMsgValue() {
            return this.msg_;
        }

        public static Builder newBuilder(SubscribeToChannelResp subscribeToChannelResp) {
            return DEFAULT_INSTANCE.createBuilder(subscribeToChannelResp);
        }

        public static SubscribeToChannelResp parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SubscribeToChannelResp) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static SubscribeToChannelResp parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (SubscribeToChannelResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static SubscribeToChannelResp parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (SubscribeToChannelResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static SubscribeToChannelResp parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (SubscribeToChannelResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static SubscribeToChannelResp parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (SubscribeToChannelResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static SubscribeToChannelResp parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (SubscribeToChannelResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static SubscribeToChannelResp parseFrom(InputStream inputStream) throws IOException {
            return (SubscribeToChannelResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static SubscribeToChannelResp parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SubscribeToChannelResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static SubscribeToChannelResp parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (SubscribeToChannelResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static SubscribeToChannelResp parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SubscribeToChannelResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    public interface SubscribeToChannelRespOrBuilder extends MessageLiteOrBuilder {
        MessageErrors getMsg();

        int getMsgValue();
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    public static final class UnsubscribeFromChannelResp extends GeneratedMessageLite<UnsubscribeFromChannelResp, Builder> implements UnsubscribeFromChannelRespOrBuilder {
        private static final UnsubscribeFromChannelResp DEFAULT_INSTANCE;
        public static final int MSG_FIELD_NUMBER = 1;
        private static volatile Parser<UnsubscribeFromChannelResp> PARSER;
        private int msg_;

        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        public static final class Builder extends GeneratedMessageLite.Builder<UnsubscribeFromChannelResp, Builder> implements UnsubscribeFromChannelRespOrBuilder {
            public Builder clearMsg() {
                copyOnWrite();
                ((UnsubscribeFromChannelResp) this.instance).clearMsg();
                return this;
            }

            @Override // cu.todus.proto.ApiProto.UnsubscribeFromChannelRespOrBuilder
            public MessageErrors getMsg() {
                return ((UnsubscribeFromChannelResp) this.instance).getMsg();
            }

            @Override // cu.todus.proto.ApiProto.UnsubscribeFromChannelRespOrBuilder
            public int getMsgValue() {
                return ((UnsubscribeFromChannelResp) this.instance).getMsgValue();
            }

            public Builder setMsg(MessageErrors messageErrors) {
                copyOnWrite();
                ((UnsubscribeFromChannelResp) this.instance).setMsg(messageErrors);
                return this;
            }

            public Builder setMsgValue(int i10) {
                copyOnWrite();
                ((UnsubscribeFromChannelResp) this.instance).setMsgValue(i10);
                return this;
            }

            private Builder() {
                super(UnsubscribeFromChannelResp.DEFAULT_INSTANCE);
            }
        }

        static {
            UnsubscribeFromChannelResp unsubscribeFromChannelResp = new UnsubscribeFromChannelResp();
            DEFAULT_INSTANCE = unsubscribeFromChannelResp;
            GeneratedMessageLite.registerDefaultInstance(UnsubscribeFromChannelResp.class, unsubscribeFromChannelResp);
        }

        private UnsubscribeFromChannelResp() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearMsg() {
            this.msg_ = 0;
        }

        public static UnsubscribeFromChannelResp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static UnsubscribeFromChannelResp parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (UnsubscribeFromChannelResp) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static UnsubscribeFromChannelResp parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (UnsubscribeFromChannelResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser<UnsubscribeFromChannelResp> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMsg(MessageErrors messageErrors) {
            this.msg_ = messageErrors.getNumber();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMsgValue(int i10) {
            this.msg_ = i10;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new UnsubscribeFromChannelResp();
                case 2:
                    return new Builder();
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\f", new Object[]{"msg_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<UnsubscribeFromChannelResp> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (UnsubscribeFromChannelResp.class) {
                        try {
                            defaultInstanceBasedParser = PARSER;
                            if (defaultInstanceBasedParser == null) {
                                defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                                PARSER = defaultInstanceBasedParser;
                            }
                        } catch (Throwable th2) {
                            throw th2;
                        }
                        break;
                    }
                    return defaultInstanceBasedParser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        @Override // cu.todus.proto.ApiProto.UnsubscribeFromChannelRespOrBuilder
        public MessageErrors getMsg() {
            MessageErrors messageErrorsForNumber = MessageErrors.forNumber(this.msg_);
            return messageErrorsForNumber == null ? MessageErrors.UNRECOGNIZED : messageErrorsForNumber;
        }

        @Override // cu.todus.proto.ApiProto.UnsubscribeFromChannelRespOrBuilder
        public int getMsgValue() {
            return this.msg_;
        }

        public static Builder newBuilder(UnsubscribeFromChannelResp unsubscribeFromChannelResp) {
            return DEFAULT_INSTANCE.createBuilder(unsubscribeFromChannelResp);
        }

        public static UnsubscribeFromChannelResp parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (UnsubscribeFromChannelResp) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static UnsubscribeFromChannelResp parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (UnsubscribeFromChannelResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static UnsubscribeFromChannelResp parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (UnsubscribeFromChannelResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static UnsubscribeFromChannelResp parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (UnsubscribeFromChannelResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static UnsubscribeFromChannelResp parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (UnsubscribeFromChannelResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static UnsubscribeFromChannelResp parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (UnsubscribeFromChannelResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static UnsubscribeFromChannelResp parseFrom(InputStream inputStream) throws IOException {
            return (UnsubscribeFromChannelResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static UnsubscribeFromChannelResp parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (UnsubscribeFromChannelResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static UnsubscribeFromChannelResp parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (UnsubscribeFromChannelResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static UnsubscribeFromChannelResp parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (UnsubscribeFromChannelResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    public interface UnsubscribeFromChannelRespOrBuilder extends MessageLiteOrBuilder {
        MessageErrors getMsg();

        int getMsgValue();
    }

    private ApiProto() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }
}
