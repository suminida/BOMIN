package com.it.controller;

import com.it.controller.action.Action;
import com.it.controller.action.BoardDeleteAction;
import com.it.controller.action.BoardListAction;
import com.it.controller.action.BoardUpdateAction;
import com.it.controller.action.BoardUpdateFormAction;
import com.it.controller.action.BoardViewAction;
import com.it.controller.action.BoardWriteAction;
import com.it.controller.action.BoardWriteFormAction;

public class BoardActionFactory {
private static BoardActionFactory instance = new BoardActionFactory();

private BoardActionFactory() {
	super();
}

public static BoardActionFactory getInstance() {
	return instance;
	
}

public Action getAction(String command) {
	Action action = null;
	System.out.println("ActionFactory : " + command);
	if (command.equals("board_list")) {
		action = new BoardListAction();
	} else if (command.equals("board_write_form")) {
		action = new BoardWriteFormAction();
	} else if (command.equals("board_write")) {
		action = new BoardWriteAction();
	} else if (command.equals("board_view")) {
		action = new BoardViewAction();
	}  else if (command.equals("board_update_form")) {
		action = new BoardUpdateFormAction();
	} else if (command.equals("board_update")) {
		action = new BoardUpdateAction();
	} else if (command.equals("board_delete")) {
		action = new BoardDeleteAction();
	}
	return action;
}
}
