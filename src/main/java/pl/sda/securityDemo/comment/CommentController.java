package pl.sda.securityDemo.comment;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/comments")
@Controller
class CommentController {

    @GetMapping
    String listComments(){
        return "comment/list";
    }
}
