package com.example.realTest;

import com.example.realTest.article.Article;
import com.example.realTest.article.ArticleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RealTestApplicationTests {
    @Autowired
    ArticleService articleService;

    @Test
    void contextLoads() {
        for (int i = 1; i < 20; i++) {
            this.articleService.create("제목 " + i, "내용" + i, null);
        }
    }

}
