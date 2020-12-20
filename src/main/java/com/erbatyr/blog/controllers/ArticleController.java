package com.erbatyr.blog.controllers;

import com.erbatyr.blog.models.Article;
import com.erbatyr.blog.repo.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class ArticleController {

	@Autowired
	private ArticleRepository articleRepository;

	@GetMapping("/article")
	public String articleMain(Model model) {
		Iterable<Article> articles = articleRepository.findAll();
		model.addAttribute("articles", articles);
		return "article-main";
	}

	@GetMapping("/article/new")
	public String articleNew(Model model) {
		return "article-new";
	}

	@PostMapping("/article/new")
	public String articleNewPost(@RequestParam String title, @RequestParam String anons, @RequestParam String full_text, Model model) {
		Article article = new Article(title, anons, full_text);
		articleRepository.save(article);
		return "redirect:/article";
	}

	@GetMapping("/article/{id}")
	public String articleDetail(@PathVariable(value = "id") long id,  Model model) {
		if(!articleRepository.existsById(id)) {
			return "redirect:/article";
		}
		Optional<Article> article = articleRepository.findById(id);
		ArrayList<Article> list = new ArrayList<>();
		article.ifPresent(list::add);
		model.addAttribute("list", list);
		return "article-detail";
	}

	@GetMapping("/article/{id}/edit")
	public String articleEdit(@PathVariable(value = "id") long id,  Model model) {
		if(!articleRepository.existsById(id)) {
			return "redirect:/article";
		}
		Optional<Article> article = articleRepository.findById(id);
		ArrayList<Article> list = new ArrayList<>();
		article.ifPresent(list::add);
		model.addAttribute("list", list);
		return "article-edit";
	}

	@PostMapping("/article/{id}/edit")
	public String articleEditPost(@PathVariable(value = "id") long id, @RequestParam String title, @RequestParam String anons, @RequestParam String full_text, Model model) {
		Article article = articleRepository.findById(id).orElseThrow();
		article.setTitle(title);
		article.setAnons(anons);
		article.setFull_text(full_text);
		articleRepository.save(article);
		return "redirect:/article";
	}

	@PostMapping("/article/{id}/delete")
	public String articleDeletePost(@PathVariable(value = "id") long id, Model model) {
		Article article = articleRepository.findById(id).orElseThrow();
		articleRepository.delete(article);
		return "redirect:/article";
	}
}

