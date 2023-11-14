package world.hello;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/formTest")
public class formTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public formTest() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		out.print("<!DOCTYPE>");
		out.print("<html>");
		out.print("<head>");
		out.print("<title>FORM TEST</title>");
		out.print("</head>");
		out.print("<body>");

		out.print(
				"	<form method=\"post\" action=\"formCheck\">                                                               ");
		out.print(
				"		<table>                                                                                             ");
		out.print(
				"			<caption>글 쓰 기</caption>                                                                     ");
		out.print(
				"			<tr>                                                                                            ");
		out.print(
				"				<td><label for=\"title\">제목</label></td>                                                    ");
		out.print(
				"				<td><input type=\"text\" name=\"title\" id=\"title\" size=\"40\"                                    ");
		out.print(
				"					required></td>                                                                          ");
		out.print(
				"			</tr>                                                                                           ");
		out.print(
				"			<tr>                                                                                            ");
		out.print(
				"				<td><label for=\"name\">이름</label></td>                                                     ");
		out.print(
				"				<td><input type=\"text\" name=\"name\" id=\"name\" size=\"40\" required></td>                       ");
		out.print(
				"			</tr>                                                                                           ");
		out.print(
				"			<tr>                                                                                            ");
		out.print(
				"				<td><label for=\"pw\">비밀번호</label></td>                                                   ");
		out.print(
				"				<td><input type=\"password\" name=\"pw\" id=\"pw\" size=\"40\" required></td>                       ");
		out.print(
				"			</tr>                                                                                           ");
		out.print(
				"			<tr>                                                                                            ");
		out.print(
				"				<td><label for=\"email\">E-mail</label></td>                                                  ");
		out.print(
				"				<td><input type=\"email\" name=\"email\" id=\"email\" size=\"40\"                                   ");
		out.print(
				"					required></td>                                                                          ");
		out.print(
				"			</tr>                                                                                           ");
		out.print(
				"			<tr>                                                                                            ");
		out.print(
				"				<td>취미</td>                                                                               ");
		out.print(
				"				<td>                                                                                        ");
		out.print(
				"					<input type=\"checkbox\" name=\"hobby\" value=\"swimming\">수영                               ");
		out.print(
				"					<input type=\"checkbox\" name=\"hobby\" value=\"baseball\">야구                               ");
		out.print(
				"					<input type=\"checkbox\" name=\"hobby\" value=\"soccer\">축구                                 ");
		out.print(
				"					<input type=\"checkbox\" name=\"hobby\" value=\"basketball\">농구                             ");
		out.print(
				"				</td>                                                                                       ");
		out.print(
				"			</tr>                                                                                           ");
		out.print(
				"			<tr>                                                                                            ");
		out.print(
				"				<td colspan=\"2\"><textarea cols=\"50\" rows=\"10\" name=\"contents\" required></textarea></td>     ");
		out.print(
				"			</tr>                                                                                           ");
		out.print(
				"			<tr>                                                                                            ");
		out.print(
				"				<td colspan=\"2\"><input type=\"submit\" value=\"SUBMIT\">                                        ");
		out.print(
				"			</tr>                                                                                           ");
		out.print(
				"		</table>                                                                                            ");
		out.print(
				"	</form>		                                                                                            ");
		out.print("</body>");
		out.print("</html>");
	}


}
