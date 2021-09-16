package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {
	
	/*인터페이스 추상메서드*/
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
