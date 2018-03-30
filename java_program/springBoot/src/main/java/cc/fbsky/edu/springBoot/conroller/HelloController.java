package cc.fbsky.edu.springBoot.conroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController
{
    @RequestMapping("/")
    @ResponseBody
    public String home() {
        return "Hello World!";
    }
    
    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }
}
