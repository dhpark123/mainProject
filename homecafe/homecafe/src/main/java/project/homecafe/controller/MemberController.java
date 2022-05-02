package project.homecafe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {
    @GetMapping(value = "/member/join")
    public String joinPage() {
        return "member/join";
    }

    @GetMapping(value = "/member/login")
    public String loginPage() {
        return "member/login";
    }
}
