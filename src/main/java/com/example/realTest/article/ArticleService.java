package com.example.realTest.article;

import com.example.realTest.user.SiteUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleService {
    private final ArticleRepository articleRepository;

    public List<Article> getList(String keyword) {
        return this.articleRepository.findAllByKeyword(keyword);
    }

    public void create(String title, String content, SiteUser user) {
        Article article = new Article();
        article.setTitle(title);
        article.setContent(content);
        article.setAuthor(user);
        article.setCreateDate(LocalDateTime.now());
        this.articleRepository.save(article);
    }

    public Article getArticle(Integer id) {
        return this.articleRepository.getById(id);
    }

    public void modify(Integer id, String title, String content) {
        Article article = this.getArticle(id);
        article.setTitle(title);
        article.setContent(content);
        this.articleRepository.save(article);
    }

    public void delete(Integer id) {
        Article article = this.getArticle(id);
        this.articleRepository.delete(article);
    }
}
