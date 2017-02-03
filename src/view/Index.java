package view;

import javax.swing.JOptionPane;

import enums.First;
import controller.AdminController;
import controller.BoardController;
import controller.CustomerController;

public class Index {
	public static void main(String[] args) {
		First[] first = {First.EXIT, First.MEMBER, First.ADMIN, First.BOARD};
		First select = (First)JOptionPane.showInputDialog(
				null, // frame
				"MAIN PAGE", // framtitle
				"MAIN MENU", // order
				JOptionPane.QUESTION_MESSAGE, // type
				null, // icon
				first, // Array of choices
				first[1] // default
			);
		switch(select) {
			case EXIT : return;
			case MEMBER : new CustomerController().start(); break;
			case ADMIN : new AdminController().start(); break;
			case BOARD : new BoardController().start(); break;
		}
	}
}
