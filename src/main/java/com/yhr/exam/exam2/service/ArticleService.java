package com.yhr.exam.exam2.service;

import java.util.List;

import com.yhr.exam.exam2.dto.Article;
import com.yhr.exam.exam2.dto.ResultData;
import com.yhr.exam.exam2.repository.ArticleRepository;
import com.yhr.exam.exam2.util.Ut;
import com.yhr.exam2.container.Container;

public class ArticleService {
	private ArticleRepository articleRepository = Container.articleRepository;

	public ResultData write(String title, String body) {
		int id = articleRepository.write(title, body);

		return ResultData.from("S-1", Ut.f("%d번 게시물이 생성되었습니다.", id), "id", id);
	}

	public List<Article> getForPrintArticles() {
		return articleRepository.getForPrintArticles();
	}

	public Article getForPrintArticleById(int id) {
		return articleRepository.getForPrintArticleById(id);
	}

	public ResultData delete(int id) {
		articleRepository.delete(id);

		return ResultData.from("S-1", Ut.f("%d번 게시물이 삭제되었습니다.", id), "id", id);

	}

	public ResultData modify(int id, String title, String body) {
		articleRepository.modify(id, title, body);

		return ResultData.from("S-1", Ut.f("%d번 게시물이 수정되었습니다.", id), "id", id);
	}

}