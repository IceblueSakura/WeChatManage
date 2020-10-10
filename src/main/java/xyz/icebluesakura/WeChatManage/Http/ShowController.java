package xyz.icebluesakura.WeChatManage.Http;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/spring/web"})
public class ShowController {
    public ShowController() {
    }

    @GetMapping({"/"})
    public String index(Model model) {
        model.addAttribute("title", "Index");
        model.addAttribute("p", "HelloWorld");
        model.addAttribute("class", "abc");
        return "index";
    }
}