package com.example.realTest.article;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/article")
public class ArticleController {
    private final ArticleService articleService;

    @GetMapping("/list")
    public String list(Model model) {
        List<Article> articleList = this.articleService.getList();
        model.addAttribute("articleList", articleList);
        return "article_list";
    }

    @GetMapping("/create")
    public String create() {
        return "article_form";
    }

    @PostMapping("/create")
    public String create(@RequestParam(value = "title") String title, @RequestParam(value = "content") String content) {
        this.articleService.create(title, content);
        return "redirect:/";
    }

    @GetMapping("/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id) {
        Article article = this.articleService.getArticle(id);
        model.addAttribute("article", article);
        return "article_detail";
    }

    @GetMapping("/modify/{id}")
    public String modify(Model model, @PathVariable("id") Integer id) {
        Article article = this.articleService.getArticle(id);
        model.addAttribute("article", article);
        return "article_modify";
    }

    @PostMapping("/modify/{id}")
    public String modify(@PathVariable(value = "id") Integer id, @RequestParam(value = "title") String title,
                         @RequestParam(value = "content") String content) {
        this.articleService.modify(id,title,content);
        return String.format("redirect:/article/detail/%s",id);
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable(value = "id")Integer id){
        this.articleService.delete(id);
        return "redirect:/";
    }
}
