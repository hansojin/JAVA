package mvcBoard.frontController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvcBoard.command.Command;
import mvcBoard.command.ContentCommand;
import mvcBoard.command.DeleteCommand;
import mvcBoard.command.ModifyCommand;
import mvcBoard.command.ReplyCommand;
import mvcBoard.command.WriteCommand;

@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public FrontController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request,response);
	}
	
	private void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String commandName=request.getServletPath();
		System.out.println(commandName);
		Command command = null;
		String viewPage = null;
		if(commandName.contains("/write.do")){
			viewPage = "/mvcBoard/write.jsp";
		}else if (commandName.contains("/view.do")){
			viewPage = "/mvcBoard/list.jsp";
		}else if (commandName.contains("/writeOK.do")){
			command = new WriteCommand();
			command.excute(request, response);
			viewPage = "/mvcBoard/list.jsp";
		}
		else if (commandName.contains("/content.do")){
			command = new ContentCommand();
			command.excute(request, response);
			viewPage = "/mvcBoard/content.jsp";
		}
		else if (commandName.contains("/delete.do")){
			command = new DeleteCommand();
			command.excute(request, response);
			viewPage = "/mvcBoard/list.jsp";
		}
		else if (commandName.contains("/reply.do")){
			command = new ContentCommand();
			command.excute(request, response);
			viewPage = "/mvcBoard/reply.jsp";
		}else if (commandName.contains("/replyOK.do")){
			command = new ReplyCommand();
			command.excute(request, response);
			viewPage = "/mvcBoard/list.jsp";
		}
		else if (commandName.contains("/modify.do")){
			command = new ModifyCommand();
			command.excute(request, response);
			viewPage = "/mvcBoard/list.jsp";
		}
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}
}
