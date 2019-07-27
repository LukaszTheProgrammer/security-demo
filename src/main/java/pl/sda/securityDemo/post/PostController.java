package pl.sda.securityDemo.post;


import java.time.LocalDate;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/posts")
class PostController {

    private final PostRepository postRepository;

    public PostController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @GetMapping
    String listPosts(@RequestParam(required = false) String content, Model model) {
        if(content == null) {
            model.addAttribute("posts", postRepository.findAll());
        } else{
            model.addAttribute("posts", postRepository.searchContaining(content));
        }

        return "post/list";
    }

    @GetMapping("/add")
    String addPost() {
        return "post/add";
    }

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    String savePost(@RequestParam String title, @RequestParam String description, Model model) {
        Post post = new Post(title, description, LocalDate.now());
        postRepository.save(post);
        model.addAttribute("posts", postRepository.findAll());

        return "post/list";
    }

}
