package co.micol.member.web;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.member.command.Command;
import co.micol.member.command.MainCommand;
import co.micol.member.command.MemberDeleteCommand;
import co.micol.member.command.MemberDeleteForm;
import co.micol.member.command.MemberInsertCommand;
import co.micol.member.command.MemberInsertForm;
import co.micol.member.command.MemberListCommand;
import co.micol.member.command.MemberSearchCommand;
import co.micol.member.command.MemberSearchForm;
import co.micol.member.command.MemberUpdateCommand;
import co.micol.member.command.MemberUpdateForm;

/**
 * Servlet implementation class FrontController
 */
//@WebServlet("/FrontController")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private HashMap<String, Command> map = new HashMap<String, Command>();
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO command 객체를 정리한다.
		
		map.put("/main.do", new MainCommand()); // 홈
		map.put("/memberList.do", new MemberListCommand()); // 회원목록
		map.put("/memberSearchForm.do", new MemberSearchForm()); //회원검색 폼
		map.put("/memberSearch.do", new MemberSearchCommand()); // 회원검색 
		map.put("/memberInsertForm.do", new MemberInsertForm()); // 회원가입 폼
		map.put("/memberInsert.do", new MemberInsertCommand()); // 회원가입
		map.put("/memberDeleteForm.do", new MemberDeleteForm()); // 회원삭제 폼
		map.put("/memberDelete.do", new MemberDeleteCommand()); // 회원삭제
		map.put("/memberUpdateForm.do", new MemberUpdateForm()); // 회원수정 폼
		map.put("/memberUpdate.do", new MemberUpdateCommand()); // 회원수정
		
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO 여기가 요청분석 및 처리, view Page 선택하는 곳.
		
		request.setCharacterEncoding("utf-8"); // 한글 깨짐 방지
		// 실제요청을 분석
		
		String uri = request.getRequestURI();
		String context = request.getContextPath();
		
		String path = uri.substring(context.length()); // 실 요청 문 예)/main.do
		
		Command command = map.get(path); //예시) Command command = new MainCommand();
		String viewPage = command.execute(request, response); // 실행될 결과를 보여줄 페이지
		
		//suffix
		if(!viewPage.endsWith(".do")) { // 보여줄 페이지 선택
			viewPage = "WEB-INF/views/" + viewPage + ".jsp";
		}
		
		// 데이터를 그대로 넘김.
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
		
		
	}

}
