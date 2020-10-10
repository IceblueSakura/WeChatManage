package xyz.icebluesakura.WeChatManage.WeChat;


import xyz.icebluesakura.WeChatManage.bundle.bundle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/spring"})
public class ResponseController {
    @Value("${wechat.token}")
    private String token;

    public ResponseController() {
    }

    @GetMapping({""})
    public Object getAccess(@RequestParam(name = "signature",defaultValue = "noSignature") String signature, @RequestParam(name = "timestamp",defaultValue = "noTimestamp") String timestrap, @RequestParam(name = "nonce",defaultValue = "noNonce") String nonce, @RequestParam(name = "echostr",defaultValue = "noEchostr") String echostr) {
        List<String> list = new ArrayList();
        StringBuilder str = new StringBuilder();
        list.add(this.token);
        list.add(timestrap);
        list.add(nonce);
        Collections.sort(list);
        Iterator var7 = list.iterator();

        while(var7.hasNext()) {
            String s = (String)var7.next();
            str.append(s);
        }

        str = new StringBuilder(bundle.getSha1(str.toString()));
        return str.toString().compareTo(signature) == 0 ? echostr : list;
    }

    @PostMapping(
            value = {""},
            produces = {"text/xml"}
    )
    public Object postProcess(@RequestBody ReceiveMessage xml) {
        ReplayMessage send = new ReplayMessage();
        send.setToUserName(xml.getFromUserName());
        send.setFromUserName(xml.getToUserName());
        send.setCreateTime(xml.getCreateTime());
        if(xml.getMsgType().compareTo("text") == 0){
            if(xml.getContent().compareTo("测试消息") == 0){
                send.setMsgType("text");
                String CreateTime = new java.text.SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new java.util.Date(Long.parseLong(xml.getCreateTime()) * 1000));
                send.setContent("收到消息：" + xml.getContent() + "\n来源ID：" + xml.getFromUserName() + "\n接收ID: " + xml.getToUserName() + "\n消息创建时间:" + CreateTime);
            }else{
                send.setMsgType("text");
                send.setContent("收到消息：" + xml.getContent());
            }
        }else{
            send.setMsgType("text");
            send.setContent("暂未支持的消息类型：" + xml.getMsgType());
        }

        return send;
    }
}

