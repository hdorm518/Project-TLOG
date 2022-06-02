package com.tworaveler.tlog;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

<<<<<<< HEAD
import com.tworaveler.tlog.home.HomeService;
import com.tworaveler.tlog.vo.LogVO;
import com.tworaveler.tlog.vo.MemberVO;
=======
import com.tworaveler.tlog.log.LogService;
import com.tworaveler.tlog.log.LogVO;
import com.tworaveler.tlog.member.MemberVO;
>>>>>>> ec75ab9956c7671b65ec8774c1655eaed19f6b03

@Controller
public class HomeController {
	@Inject
	LogService service;
	
	@GetMapping("/") 
	public ModelAndView home(HttpSession session) { 
		ModelAndView mav  = new ModelAndView();
		session.setAttribute("logStatus", "Y"); //임시

		//(1) tLog 10개
		if(session.getAttribute("logStatus").equals("Y")) {
			//팔로잉 tLog
			List<LogVO> logList = service.selectFollowLog(1); //임시(logId)
			//vo마다 tNum의 태그리스트 넣기
			for(LogVO vo : logList) {
				vo.setTagList(service.selectLogTag(vo.gettNum()));
			}
			mav.addObject("logList", logList);
		}else {
			//좋아요순 tLog
			List<LogVO> logList = service.selectLikeLog();
			for(LogVO vo : logList) {
				vo.setTagList(service.selectLogTag(vo.gettNum()));
			}
			mav.addObject("logList", logList);
		}
		
		//(2) 팔로워 많은 유저
		List<MemberVO> followedUser = service.FollowedUser();
		for(MemberVO vo : followedUser) {
			vo.setTagList(service.selectMyTag(vo.getUserNum()));
		}
		mav.addObject("followedUser", followedUser);
		
<<<<<<< HEAD
		//(3) 태그 리스트
		List<String> tagList = service.selectTagAll();
=======
		//(3) �깭洹� 由ъ뒪�듃
		List<LogVO> tagList = service.selectTagAll();
>>>>>>> ec75ab9956c7671b65ec8774c1655eaed19f6b03
		mav.addObject("tagList", tagList);
		
		mav.setViewName("/home");
		return mav;
	} 
	
	@ResponseBody // Ajax
	@RequestMapping(value = "/home/logDetail", method = RequestMethod.GET)
	public List<LogVO> logDetail(@RequestParam("tNum") int tNum) {
		List<LogVO> detailList = service.selectLogDetail(tNum);
		for(LogVO vo : detailList) {
			vo.setTagUserList(service.selectTagUsers(tNum));
		}
		return detailList;
	}
}