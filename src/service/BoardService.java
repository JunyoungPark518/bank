package service;

import java.util.Vector;

import domain.ArticleBean;

public interface BoardService {
	// CREATE
	public void addArticle(ArticleBean param);
	// READ: SELECT
	public ArticleBean findOne(ArticleBean param);
	public Vector<ArticleBean> findSome(ArticleBean param);
	public Vector<ArticleBean> list();
	// UPDATE
	public void update(ArticleBean param);
	// DELETE
	public void delete(ArticleBean param);
}
