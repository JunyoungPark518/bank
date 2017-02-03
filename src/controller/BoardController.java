package controller;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;

import domain.ArticleBean;
import service.BoardService;
import serviceImpl.BoardServiceImpl;

/**
@FILE  : BoardController.java
@DATE  : 2017. 2. 3.
@AUTHOR: J.John Park
@STORY
// 1.추가..주어진 BbsBean 값을 vec 에 추가하기
// 1,James,Hello,2016-2-6 17:30
// 2,Tom,Hi,2016-8-6 17:30
// 3,Alex,Good Morning,2016-11-20 17:30
// 4,Betty,I'm happy,2016-12-25 17:30
// 5,John,Thank you,2017-2-6 17:30
// 2.검색(1)..seq가 1인 글 검색, 
// 해당 seq 가 있으면 내용을 보여주고
// 없으면 해당글이 존재하지 않는다고 출력함
// 3.검색(some)...
// James 가 쓴 글 검색
// 하나라도 없으면 해당글이 존재하지 않는다고 출력함
// 4.전체 출력
// 글이 하나도 없으면
// 빈 게시판 이라고 출력함
// 5.수정 (seq가 1인 글의 내용을 Good Bye)로 변경
// 수정이 끝나면 바뀐 글내용 출력하기
// 6.삭제 (seq가 인 글을 삭제)
// 삭제가 끝나면 해당글이 없다고 출력함
 */
public class BoardController {
	public void start() {
		
	}
	public static void main(String[] args) {
		BoardService service = new BoardServiceImpl();
		Vector<ArticleBean> list = service.list();
		ArticleBean a = new ArticleBean();
		
		// 0.리스트 스펙보기
		System.out.println("CAPA: " + list.capacity());
		System.out.println("SIZE: " + list.size());
		
		// 1.추가..주어진 BbsBean 값을 vec 에 추가하기
		String[] input = {"6","James","Good bye","2017-1-6 16:30"};
		a.setSeq(input[0]);
		a.setUid(input[1]);
		a.setTitle(input[2]);
		a.setRegdate(input[3]);
		list.add(a);
		
		// 2-1.검색(1)..맨 마지막에 추가한 글 검색,
		System.out.println("2-1.검색(1)..맨 마지막에 추가한 글 검색");
		System.out.println(list.get(list.size()-1).toString());
		
		// 2-2.검색(1)..seq가 3인 글 검색, 
		System.out.println("2-2.검색(1)..seq가 3인 글 검색");
		a = new ArticleBean();
		a.setSeq("3");
		System.out.println(service.findOne(a).toString());
		
		// 3.검색(some)...James 가 쓴 글 검색
		a = new ArticleBean();
		a.setUid("James");
		System.out.println(service.findSome(a).toString());
		
		// 4.전체 출력
		System.out.println(list);

		// 5.수정 (seq가 1인 글의 내용을 Good Bye)로 변경
		a = new ArticleBean();
		a.setSeq("1");
		a.setTitle("Good Bye");
		service.update(a);
		// 수정이 끝나면 바뀐 글내용 출력하기
		System.out.println(list);
		
		// 6.삭제 (seq가 3인 글을 삭제)
		a = new ArticleBean();
		a.setSeq("1");
		service.delete(a);
		// 삭제가 끝나면 해당글이 없다고 출력함
		System.out.println(list);
	}
}
