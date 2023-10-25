package com.njk.exam1.article;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ArticleService {
    private final ArticleRepository articleRepository;

    public void create() {
        Article article = new Article();
        article.setSubject("new title");
        article.setContent("");
        articleRepository.save(article);
    }

    public void modify(Article article, String subject, String content) {
        article.setSubject(subject);
        article.setContent(content);
        articleRepository.save(article);
    }

    public Article getById(Integer id) {
        Optional<Article> article = articleRepository.findById(id);
        if(article.isPresent()) return article.get();
        throw new RuntimeException("게시물이 없습니다.");
    }

    public List<Article> getList() {
        return articleRepository.findAll();
    }
}
