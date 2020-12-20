package com.erbatyr.blog.repo;

import com.erbatyr.blog.models.Article;
import org.springframework.data.repository.CrudRepository;

public interface ArticleRepository extends CrudRepository<Article, Long> {
}
