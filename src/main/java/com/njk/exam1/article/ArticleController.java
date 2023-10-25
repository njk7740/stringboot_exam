package com.njk.exam1.article;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/article")
public class ArticleController {
    private final ArticleService articleService;

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("articleList", articleService.getList());
        return "article_list";
    }

    @GetMapping("/create")
    public String create() {
        articleService.create();
        return "redirect:/";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("articleList", articleService.getList());
        model.addAttribute("articleDetail", articleService.getById(id));
        return "article_list";
    }

    @PostMapping("/modify/{id}")
    public String modify(@PathVariable("id") Integer id, String subject, String content) {
        Article article = articleService.getById(id);
        articleService.modify(article, subject, content);
        return String.format("redirect:/article/detail/%s", id);
    }
}
