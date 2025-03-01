package pororoAndFriends.ToyProject01.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pororoAndFriends.ToyProject01.domain.Article;
import pororoAndFriends.ToyProject01.dto.AddArticleRequest;
import pororoAndFriends.ToyProject01.dto.PutArticleRequest;
import pororoAndFriends.ToyProject01.repository.BlogRepository;

@Service
@RequiredArgsConstructor
public class BlogService {
    private final BlogRepository blogRepository;

    public void createArticle(AddArticleRequest request) {
        Article article = new Article();
        article.update(request.getTitle(), request.getContent());
        blogRepository.save(article);
    }


    public Article getArticle(Long articleId) {
        return blogRepository.findById(articleId).orElseThrow(() -> new IllegalArgumentException("Article not found"));
    }

    public void deleteArticle(Long id) {
        blogRepository.deleteById(id);
    }

    public Article putArticle(PutArticleRequest request) {
        Article article = blogRepository.findById(request.getId())
                .orElseThrow(() -> new IllegalArgumentException("Article not found"));
        article.update(request.getTitle(), request.getContent());
        blogRepository.save(article);
        return article;
    }

    public List<Article> getArticles() {
        return blogRepository.findAll();
    }
}