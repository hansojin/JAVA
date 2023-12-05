package MIMEtest;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/IMGServlet")
public class IMGServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private File image; 	// 이미지 파일 객체 선언
	
	public void init() {
		//초기화 메서드를 통해 이미지 파일을 연결
		ServletContext context = this.getServletContext();
		String path = context.getRealPath("MIMEtest/images");
		image = new File(path, "moon.jpg");
	}
	
    public IMGServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("image/jpg");
		//현재 Servlet의 MIME을 image/jpg로 지정하여 파일의 확장자 명과 동일하게 만듦
		//실제 gif나 jpg 등 이미지 관련 데이터들은 정확한 MIME을 지정하지 않고 같은 image 계열의 MIME을 지정해도 정상 출력이 이루어짐
		
		//지정된 파일로 부터 데이터를 읽을 객체 선언
		DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream(image)));
		//읽은 데이터를 출력할 Servlet의 출력 객체를 Stream 객체로 지정
		//일반적으로는 PrintWriter를 사용하지만 image나 application과 같은 데이터의 경우에는 각 byte에 더 중요한 의미가 있고 깨질 우려가 있기 때문에 Stream 출력객체를 사용
		ServletOutputStream out = response.getOutputStream();
		
		byte[] data = new byte[512];					//한번에 읽을 수 있는 byte 수를 512byte로 제한
		
		while(true) {
			int x = in.read(data, 0, data.length);		//최대 512byte 씩 데이터를 읽고, x에는 읽은 개수가 저장됨
			if(x == -1) 
				break;									//더이상 읽을 데이터가 없으면 break
			out.write(data, 0, x);						//읽은 개수 만큼 출력		
			out.flush();								//클라이언트로 전송 = flush()는 현재 버퍼에 있는 내용을 상대측으로 비워 내는 역할을 함
		}
		in.close();
		out.close();
	}

}
