package project.homecafe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import project.homecafe.domain.MemberDTO;
import project.homecafe.service.MemberService;
import project.util.UiUtils;

import java.util.Map;

@Controller
public class MemberController extends UiUtils {
    @Autowired
    private MemberService memberService;

    @GetMapping(value = "member/join")
    public String joinPage(@ModelAttribute("params") MemberDTO params, @RequestParam(value = "idx", required = false) Long idx, Model model) {
        // params.getIdx() 는 안되나?
        if (idx == null) {
            model.addAttribute("member", new MemberDTO());
        } else {
            MemberDTO member = memberService.getMemberDetail(idx);
            if (member == null || "Y".equals(member.getDeleteYn())) {
                return redirectForMessage("없는 게시글이거나 이미 삭제된 게시글입니다.", "/home", null,  model);
            }
            model.addAttribute("member", member);
        }
        return "/member/join";
    }

    @PostMapping(value = "member/memJoin")
    public String memberJoin (@ModelAttribute("params") final MemberDTO params, Model model) {
//        Map<String, Object> pagingParams= getPagingParams(params);

        try {
            boolean isRegistered = memberService.registerMember(params);
            if (isRegistered == false) {

                return redirectForMessage("게시글 등록에 실패하였습니다.", "/ome", null, model);
            }
        } catch (DataAccessException e) {
            return redirectForMessage("데이터베이스 처리 과정에서 문제가 발생하였습니다.", "/home", null, model);
        } catch (Exception e) {
            return redirectForMessage("시스템에 문제가 발생하였습니다.", "/home", null, model);
        }
        return redirectForMessage("게시글 등록이 완료되었습니다.", "/home", null, model);
    }

    @GetMapping(value = "member/login")
    public String loginPage() {
        return "/member/login";
    }

    @PostMapping(value = "member/memLogin")
    public String memberLogin () {
        return "redirectUri:/home";
    }
}
