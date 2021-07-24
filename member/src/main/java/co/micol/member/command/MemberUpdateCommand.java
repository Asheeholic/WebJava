package co.micol.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.member.service.MemberService;
import co.micol.member.serviceImpl.MemberServiceImpl;
import co.micol.member.vo.MemberVO;

public class MemberUpdateCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String[] hobbys = request.getParameterValues("hobbys");
		String hobby = "";
		for(String h : hobbys) {
			hobby += h + ", ";
		}
		hobby = hobby.substring(0, hobby.length()-2); // 마지막 반점 제거
		
		// vo 받기
		MemberService dao = new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		vo.setId(request.getParameter("id"));
		vo.setPassword(request.getParameter("password"));
		//vo.setName(request.getParameter("name"));
		vo.setAge(Integer.valueOf(request.getParameter("age")));
		vo.setHobby(hobby);
		int result = dao.memberUpdate(vo);
		
		// 처리 결과 반환 정하기
		String view;
		if(result != 0) {
			view = "memberList.do";
		} else {
			request.setAttribute("message", "수정이 실패 되었습니다. 다시 시도 해보세요.");
			view = "member/memberUpdateFail";
		}
		
		return view;
	}

}
