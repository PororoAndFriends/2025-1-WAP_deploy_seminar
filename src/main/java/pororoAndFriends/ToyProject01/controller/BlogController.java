package pororoAndFriends.ToyProject01.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pororoAndFriends.ToyProject01.domain.Article;
import pororoAndFriends.ToyProject01.dto.AddArticleRequest;
import pororoAndFriends.ToyProject01.dto.ArticleId;
import pororoAndFriends.ToyProject01.dto.PutArticleRequest;
import pororoAndFriends.ToyProject01.repository.BlogRepository;
import pororoAndFriends.ToyProject01.service.BlogService;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class BlogController {

    private final BlogService blogService;

    @PostMapping("/article")
    public ResponseEntity<?> addArticle(@RequestBody AddArticleRequest request) {
        blogService.createArticle(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/article")
    public ResponseEntity<?> getArticle(@RequestParam(name = "id") Long articleId) {
        Article article = blogService.getArticle(articleId);
        return ResponseEntity.ok().body(article);
    }

    @DeleteMapping("/article")
    public ResponseEntity<?> deleteArticle(@RequestBody ArticleId articleId) {
        blogService.deleteArticle(articleId.getId());
        return ResponseEntity.ok().build();
    }

    @PutMapping("/article")
    public ResponseEntity<?> putArticle(@RequestBody PutArticleRequest request) {
        Article article = blogService.putArticle(request);
        return ResponseEntity.ok().body(article);
    }

    @GetMapping("/articles")
    public ResponseEntity<?> getArticles() {
        List<Article> articles = blogService.getArticles();
        return ResponseEntity.ok(articles);
    }
}