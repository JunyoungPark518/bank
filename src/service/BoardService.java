package service;

import java.util.List;

import domain.ArticleBean;

public interface BoardService {
	// CREATE
	public void addArticle(ArticleBean param);
	// READ: SELECT
	public ArticleBean findOne(ArticleBean param);
	public List<ArticleBean> findSome(ArticleBean param);
	public List<ArticleBean> list();
	// UPDATE
	public void update(ArticleBean param);
	// DELETE
	public void delete(ArticleBean param);
}
