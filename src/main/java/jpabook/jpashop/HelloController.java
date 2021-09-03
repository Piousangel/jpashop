package jpabook.jpashop;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model){       //매개변수로 받은 model에 데이터를 담 view에 넘기는 역할을 수행
       model.addAttribute("data" , "hello!!! gg");
        return "hello";                 //return 은 화면 이름
    }
}
