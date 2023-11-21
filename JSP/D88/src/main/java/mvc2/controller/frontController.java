package mvc2.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc2.command.BContentCommand;
import mvc2.command.BDeleteCommand;
import mvc2.command.BInsertCommand;
import mvc2.command.BListCommand;
import mvc2.command.BModifyCommand;
import mvc2.command.BReplyCommand;
import mvc2.command.BReplyInsertCommand;
import mvc2.command.BWriteCommand;

@WebServlet("*.do")
public class frontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public frontController() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);	
	}
	
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("actionDo");
		String uri = request.getRequestURI(); 		// project + file path
		System.out.println("uri : " + uri);
		String conPath = request.getContextPath();	// project path
		System.out.println("conPath : " + conPath);
		String command = uri.substring(conPath.length());
		System.out.println("command : " + command);
		
		if(command.equals("/write.do")){
			System.out.println("--write--");
			BWriteCommand bWrite = new BWriteCommand();
			bWrite.excute(request,response);
		}
		else if(command.equals("/list.do")){
			System.out.println("--list--");
			BListCommand bList = new BListCommand();
			bList.excute(request,response);
		}
		else if(command.equals("/insert.do")){
			System.out.println("--insert--");
			BInsertCommand bInsert = new BInsertCommand();
			bInsert.excute(request, response);
		}
		else if(command.equals("/modify.do")){
			System.out.println("--modify--");
			BModifyCommand bModify = new BModifyCommand();
			bModify.excute(request, response);
		}
		else if(command.equals("/delete.do")){
			System.out.println("--delete--");
			BDeleteCommand bDelete = new BDeleteCommand();
			bDelete.excute(request, response);
		}
		else if(command.equals("/reply.do")){
			System.out.println("--reply--");
			BReplyCommand bReply = new BReplyCommand();
			bReply.excute(request, response);
		}
		else if(command.equals("/replyInsert.do")){
			System.out.println("--replyInsert--");
			BReplyInsertCommand bReplyInsert = new BReplyInsertCommand();
			bReplyInsert.excute(request, response);
		}
		else if(command.equals("/content.do")){
			System.out.println("--content--");
			BContentCommand  bContent = new BContentCommand();
			bContent.excute(request, response);	
		}
	}
	
}
