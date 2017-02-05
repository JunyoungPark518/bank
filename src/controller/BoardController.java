package controller;

import java.util.Vector;

import javax.swing.JOptionPane;

import domain.ArticleBean;
import enums.Board;
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
		BoardService service = new BoardServiceImpl();
		Vector<ArticleBean> list = service.list();
		ArticleBean a = new ArticleBean();
		Board[] board = {Board.EXIT, Board.CHECK, Board.ADD, Board.SEARCH, Board.CHANGE, Board.DELETE};
		Board[] selboard = {Board.EXIT, Board.FIND_ONE, Board.FIND_SOME, Board.ALL};
		Board[] chgboard = {Board.EXIT, Board.CHANGE_TITLE, Board.CHANGE_CONTENT };
		boolean temp = false;
		while(true) {
			Board bselect = (Board)JOptionPane.showInputDialog(null, "BOARD PAGE", "SELECT BOARD MENU", JOptionPane.QUESTION_MESSAGE, null, board, board[0]);
			switch(bselect) {
			default:
			case EXIT:
				return;
			case CHECK:
				JOptionPane.showMessageDialog(null, "CAPACITY: " + list.capacity() + "\nSIZE: " + list.size() + "\nLIST\n" + list);
				break;
			case ADD:
				String[] input = JOptionPane.showInputDialog("Sequence/Name/Title/Date").split("/");
				a.setSeq(input[0]);
				a.setUid(input[1]);
				a.setTitle(input[2]);
				a.setRegdate(input[3]);
				a.setContent(JOptionPane.showInputDialog("게시글에 작성될 내용 입력"));
				list.add(a);
				JOptionPane.showMessageDialog(null, "게시판에 추가되었습니다!");
				break;
			case SEARCH:
				temp = true;
				while(temp) {
					Board searchselect = (Board)JOptionPane.showInputDialog(null, "BOARD PAGE", "SELECT SEARCH MENU", JOptionPane.QUESTION_MESSAGE, null, selboard, selboard[0]);
					switch(searchselect) {
					default:
					case EXIT:
						temp = false;
						break;
					case FIND_ONE:
						// 2-1.검색(1)..맨 마지막에 추가한 글 검색,
	//					JOptionPane.showMessageDialog(null, list.get(list.size()-1).toString());
						a = new ArticleBean();
						a.setSeq(JOptionPane.showInputDialog("검색하려는 게시글의 번호 입력"));
						JOptionPane.showMessageDialog(null, service.findOne(a).toString());
						break;
					case FIND_SOME:
						a = new ArticleBean();
						a.setUid(JOptionPane.showInputDialog("검색하려는 회원 이름 입력"));
						JOptionPane.showMessageDialog(null, service.findSome(a).toString());
						break;
					case ALL:
						JOptionPane.showMessageDialog(null, list);
						break;
					}
				}
				break;
			case CHANGE:
				a = new ArticleBean();
				a.setSeq(JOptionPane.showInputDialog("수정하려는 게시글의 번호 입력"));
				temp = true;
				while(temp) {
					Board chgselect = (Board)JOptionPane.showInputDialog(null, "BOARD PAGE", "SELECT CHANGE MENU", JOptionPane.QUESTION_MESSAGE, null, chgboard, chgboard[0]);
					switch(chgselect) {
					default:
					case EXIT:
						temp = false;
						break;
					case CHANGE_TITLE:
						a.setTitle(JOptionPane.showInputDialog("어떤 제목으로 변경할까요?"));
						service.update(a);
						JOptionPane.showMessageDialog(null, "변경 완료!!");
						break;
					case CHANGE_CONTENT:
						a.setContent(JOptionPane.showInputDialog("어떤 내용으로 변경할까요?"));
						service.update(a);
						JOptionPane.showMessageDialog(null, "변경 완료!!");
						break;
					}
				}
				break;
			case DELETE:
				a = new ArticleBean();
				a.setSeq(JOptionPane.showInputDialog("삭제를 원하는 게시글의 번호 입력"));
				service.delete(a);
				break;
			}
		}
	}
}
