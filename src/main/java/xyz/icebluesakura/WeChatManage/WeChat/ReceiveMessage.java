package xyz.icebluesakura.WeChatManage.WeChat;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(
        localName = "xml"
)
public class ReceiveMessage {
    @JacksonXmlProperty(
            localName = "ToUserName"
    )
    private String ToUserName;
    @JacksonXmlProperty(
            localName = "FromUserName"
    )
    private String FromUserName;
    @JacksonXmlProperty(
            localName = "CreateTime"
    )
    private String CreateTime;
    @JacksonXmlProperty(
            localName = "MsgType"
    )
    private String MsgType;
    @JacksonXmlProperty(
            localName = "Content"
    )
    private String Content;
    @JacksonXmlProperty(
            localName = "MsgId"
    )
    private String MsgId;

    public ReceiveMessage() {
    }

    public String getToUserName() {
        return this.ToUserName;
    }

    public void setToUserName(String toUserName) {
        this.ToUserName = toUserName;
    }

    public String getFromUserName() {
        return this.FromUserName;
    }

    public void setFromUserName(String fromUserName) {
        this.FromUserName = fromUserName;
    }

    public String getCreateTime() {
        return this.CreateTime;
    }

    public void setCreateTime(String createTime) {
        this.CreateTime = createTime;
    }

    public String getMsgType() {
        return this.MsgType;
    }

    public void setMsgType(String msgType) {
        this.MsgType = msgType;
    }

    public String getContent() {
        return this.Content;
    }

    public void setContent(String content) {
        this.Content = content;
    }

    public String getMsgId() {
        return this.MsgId;
    }

    public void setMsgId(String msgId) {
        this.MsgId = msgId;
    }
}
