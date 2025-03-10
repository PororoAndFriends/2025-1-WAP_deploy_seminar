package pororoAndFriends.ToyProject01.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pororoAndFriends.ToyProject01.domain.Article;
import pororoAndFriends.ToyProject01.dto.AddArticleRequest;
import pororoAndFriends.ToyProject01.dto.PutArticleRequest;
import pororoAndFriends.ToyProject01.service.BlogService;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final BlogService blogService;

    @GetMapping("/")
    public String homeController(Model model) {
        List<Article> articles = blogService.getArticles();
        model.addAttribute("articles", articles);
        return "home";
    }

    @GetMapping("/createArticle")
    public String createArticleForm(Model model) {
        model.addAttribute("addArticleRequest", new AddArticleRequest("", ""));
        return "articleCreateForm";
    }

    @PostMapping("/createArticle")
    public String createArticle(@ModelAttribute AddArticleRequest request) {
        blogService.createArticle(request);
        return "redirect:/";
    }

    @GetMapping("/updateArticle")
    public String updateArticleForm(@RequestParam(name = "id") Long articleId, Model model) {
        Article article = blogService.getArticle(articleId);
        model.addAttribute("putArticleRequest",
                new PutArticleRequest(article.getTitle(), article.getContent(),articleId));
        return "articleUpdateForm";
    }

    @PostMapping("/updateArticle")
    public String updateArticle(@ModelAttribute PutArticleRequest request) {
        blogService.putArticle(request);
        return "redirect:/";
    }

    @PostMapping("/deleteArticle")
    public String deleteArticle(@RequestParam(name = "id") Long articleId) {
        blogService.deleteArticle(articleId);
        return "redirect:/";
    }
}
