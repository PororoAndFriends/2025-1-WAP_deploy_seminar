package pororoAndFriends.ToyProject01.controller;

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

@RestController
@RequestMapping
@RequiredArgsConstructor
public class BlogController {

    private final BlogRepository blogRepository;

    @PostMapping("/article")
    public ResponseEntity<?> addArticle(@RequestBody AddArticleRequest request) {

        Article article = new Article();
        article.update(request.getTitle(), request.getContent());
        blogRepository.save(article);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/article")
    public ResponseEntity<?> getArticle(@RequestParam(name = "id") Long articleId) {
        Article article = blogRepository.findById(articleId).get();
        return ResponseEntity.ok().body(article);
    }

    @DeleteMapping("/article")
    public ResponseEntity<?> deleteArticle(@RequestBody ArticleId articleId) {
        blogRepository.deleteById(articleId.getId());

        return ResponseEntity.ok().build();
    }

    @PutMapping("/article")
    public ResponseEntity<?> putArticle(@RequestBody PutArticleRequest request) {
        Article article = blogRepository.findById(request.getId()).get();
        article.update(request.getTitle(), request.getContent());
        blogRepository.save(article);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/articles")
    public ResponseEntity<?> getArticles() {
        return ResponseEntity.ok(blogRepository.findAll());
    }
}