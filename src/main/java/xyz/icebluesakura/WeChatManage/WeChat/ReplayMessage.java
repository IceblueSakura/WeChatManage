package xyz.icebluesakura.WeChatManage.WeChat;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(
        localName = "xml"
)
public class ReplayMessage {
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
            localName = "MediaId"
    )
    private String MediaId;
    @JacksonXmlProperty(
            localName = "Title"
    )
    private String Title;
    @JacksonXmlProperty(
            localName = "Description"
    )
    private String Description;
    @JacksonXmlProperty(
            localName = "MusicURL"
    )
    private String MusicURL;
    @JacksonXmlProperty(
            localName = "HQMusicUrl"
    )
    private String HQMusicUrl;
    @JacksonXmlProperty(
            localName = "ThumbMediaId"
    )
    private String ThumbMediaId;
    @JacksonXmlProperty(
            localName = "ArticleCount"
    )
    private String ArticleCount;
    @JacksonXmlProperty(
            localName = "Articles"
    )
    private String Articles;
    @JacksonXmlProperty(
            localName = "PicUrl"
    )
    private String PicUrl;
    @JacksonXmlProperty(
            localName = "Url"
    )
    private String Url;

    public ReplayMessage() {
    }

    public void setToUserName(String toUserName) {
        this.ToUserName = toUserName;
    }

    public void setFromUserName(String fromUserName) {
        this.FromUserName = fromUserName;
    }

    public void setCreateTime(String createTime) {
        this.CreateTime = createTime;
    }

    public void setMsgType(String msgType) {
        this.MsgType = msgType;
    }

    public void setContent(String content) {
        this.Content = content;
    }

    public void setMediaId(String mediaId) {
        this.MediaId = mediaId;
    }

    public void setTitle(String title) {
        this.Title = title;
    }

    public void setDescription(String description) {
        this.Description = description;
    }

    public void setMusicURL(String musicURL) {
        this.MusicURL = musicURL;
    }

    public void setHQMusicUrl(String HQMusicUrl) {
        this.HQMusicUrl = HQMusicUrl;
    }

    public void setThumbMediaId(String thumbMediaId) {
        this.ThumbMediaId = thumbMediaId;
    }

    public void setArticleCount(String articleCount) {
        this.ArticleCount = articleCount;
    }

    public void setArticles(String articles) {
        this.Articles = articles;
    }

    public void setPicUrl(String picUrl) {
        this.PicUrl = picUrl;
    }

    public void setUrl(String url) {
        this.Url = url;
    }
}
