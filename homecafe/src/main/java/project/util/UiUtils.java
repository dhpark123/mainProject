package project.util;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;


@Controller
public class UiUtils {
    public String redirectForMessage(@RequestParam(value = "message", required = false) String message,
                                     @RequestParam(value = "redirectUri", required = false) String redirectUri,
                                     @RequestParam(value = "params", required = false) Map<String, Object> params, Model model) {
        model.addAttribute("message", message);
        model.addAttribute("redirectUri", redirectUri);
        model.addAttribute("params", params);

        return "utils/redirectForMessage";
    }

}
