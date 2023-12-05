package fileUpload;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FileUploadResult")
public class FileUploadResult extends HttpServlet {
	private static final long serialVersionUID = 1L;

    //multipart의 전송을 수용하기 위해 post 메서드로 정의
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		ServletInputStream pIn = request.getInputStream();
		//전송되어 온 내용을 Stream으로 읽기 위한 객체 선언
		
		response.setContentType("text/html;charset=UTF-8");
		ServletOutputStream pOut = response.getOutputStream();
		//전송되어 온 내용을 그대로 사용자에게 출력하기 위한 객체 선언
		
		pOut.write("start<br>".getBytes());
		while (true) {
			//전송된 모든 내용을 출력할 때까지
			int x = pIn.read();
			if (x==-1)
				break;
			pOut.write((char)x);
			
		}
		pOut.write("end<br>".getBytes());
		
		pIn.close();
		pOut.close();
	}
	

}
