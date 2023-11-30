package mvc2.frontController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc2.command.CheckIDCommand;
import mvc2.command.Command;
import mvc2.command.DeleteCommand;
import mvc2.command.InfoCommand;
import mvc2.command.InfoModifyCommand;
import mvc2.command.ListCommand;
import mvc2.command.LoginCommand;
import mvc2.command.LogoutCommand;
import mvc2.command.ModifyOKCommand;
import mvc2.command.RegisterCommand;
import mvc2.command.ReplyCommand;
import mvc2.command.ReplyOKCommand;
import mvc2.command.SearchCommand;
import mvc2.command.ViewCommand;
import mvc2.command.WriteCommand;

@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FrontController() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}

	public void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String commandName = request.getServletPath();
		String viewPage = null;
		Command command = null;
		
		if(commandName.equals("/registerLogic.do")) {
			command = new RegisterCommand();
			command.excute(request, response);
			viewPage = "login.jsp";
		}else if(commandName.equals("/logoutLogic.do")) {
			command = new LogoutCommand();
			command.excute(request, response);
			viewPage = "login.jsp";
		}else if(commandName.equals("/login.do")) {
			viewPage = "login.jsp";
		}else if(commandName.equals("/register.do")) {
			viewPage = "register.jsp";
		}else if(commandName.equals("/loginLogic.do")) {
			command = new LoginCommand();
			command.excute(request, response);
			viewPage = "login.jsp";
		}else if(commandName.equals("/info.do")) {
			command = new InfoCommand();
			command.excute(request, response);
			viewPage = "info.jsp";
		}else if(commandName.equals("/infoMLogic.do")) {
			command = new InfoModifyCommand();
			command.excute(request, response);
			viewPage = "login.jsp";
		}else if(commandName.equals("/list.do")) {
			command = new ListCommand();
			command.excute(request, response);
			viewPage = "list.jsp";
		}else if(commandName.equals("/write.do")) {
			viewPage = "write.jsp";
		}else if(commandName.equals("/writeLogic.do")) {
			command = new WriteCommand();
			command.excute(request, response);
			viewPage = "list.do";
		}else if(commandName.equals("/view.do")) {
			command = new ViewCommand();
			command.excute(request, response);
			viewPage = "content.jsp";
		}else if(commandName.equals("/modifyOK.do")) {
			command = new ModifyOKCommand();
			command.excute(request, response);
			viewPage = "list.do";
		}else if(commandName.equals("/delete.do")) {
			command = new DeleteCommand();
			command.excute(request, response);
			viewPage = "list.do";
		}else if(commandName.equals("/reply.do")) {
			command = new ReplyCommand();
			command.excute(request, response);
			viewPage = "reply.jsp";
		}else if(commandName.equals("/replyOK.do")) {
			command = new ReplyOKCommand();
			command.excute(request, response);
			viewPage = "list.do";
		}else if(commandName.equals("/search.do")) {
			command = new SearchCommand();
			command.excute(request, response);
			viewPage = "list.do";
		}else if(commandName.equals("/idCheckOK.do")) {
			command = new CheckIDCommand();
			command.excute(request, response);
			viewPage = "idCheckOK.jsp";
		}  
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);	
	}
}
