package shine.command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shine.dto.FaceDto;
import shine.dao.FaceDao;

public class FaceCommand implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FaceDao dao = FaceDao.getFaceDAO();
		ArrayList<FaceDto> list = dao.getFace();
		StringBuilder sb = new StringBuilder("[");
		int size = list.size();
		for(int i=0;i<size;i++) {
			FaceDto dto = list.get(i);
			sb.append("{\"id\" : \"" + dto.getId() + "\", " + "\"msg\" : \"" + dto.getMsg() + "\"}");
			if(i!=size-1)
				sb.append(",");
		}
		sb.append("]");
		System.out.println("command " + sb.toString());
		request.setAttribute("result", sb.toString());

	}

}
