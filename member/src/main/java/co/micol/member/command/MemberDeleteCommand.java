package co.micol.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.member.service.MemberService;
import co.micol.member.serviceImpl.MemberServiceImpl;
import co.micol.member.vo.MemberVO;

public class MemberDeleteCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		MemberService dao = new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		vo.setId(request.getParameter("id"));
		int result = dao.memberDelete(vo);
		
		String view;
		if(result != 0) {
			view = "memberList.do";
		} else {
			request.setAttribute("message", "삭제를 실패 했습니다.");
			view = "member/memberDeleteFail";
		}
		
		return view;
	}

}
