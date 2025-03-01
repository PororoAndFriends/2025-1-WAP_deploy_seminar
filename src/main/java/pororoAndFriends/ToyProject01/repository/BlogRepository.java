package pororoAndFriends.ToyProject01.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pororoAndFriends.ToyProject01.domain.Article;

@Repository
public interface BlogRepository extends JpaRepository<Article, Long> {
}
