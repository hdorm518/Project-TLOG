package com.tworaveler.tlog.log;

import java.util.ArrayList;
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

@Controller
public class LogShareController {
	@Inject
	LogService service;
	
	@GetMapping("/logShare/logList") 
	public ModelAndView logList(HttpSession session) { 
		ModelAndView mav  = new ModelAndView();
		mav.setViewName("/logShare/logList");
		return mav;
	} 
	@GetMapping("/logShare/logList/searchs") 
	public ModelAndView search(HttpSession session, String searchKey, String searchWord) { 
		ModelAndView mav  = new ModelAndView();
		mav.addObject("searchKey", searchKey);
		mav.addObject("searchWord", searchWord);
		mav.setViewName("/logShare/logList");
		return mav;
	}
	//전체 로그리스트
	@ResponseBody // Ajax
	@RequestMapping(value = "/logShare/logLists", method = RequestMethod.GET)
	public List<LogVO> logLists(@RequestParam("startNum") int startNum) {
		int limitNum =5;
		
		List<LogVO> logLists = service.selectLogLists(startNum, limitNum);
		
		//vo마다 태그리스트 넣기
		for(LogVO lvo : logLists) {
			lvo.setTagList(service.selectLogTag(lvo.gettNum()));
		}
		return logLists;
	}
	//검색한 로그리스트
	@ResponseBody // Ajax
	@RequestMapping(value = "/logShare/searchLists", method = RequestMethod.GET)
	public List<LogVO> searchLists(@RequestParam(value = "startNum") int startNum,String searchKey, String searchWord) {
		int limitNum = 5;
		List<LogVO> logLists = new ArrayList<LogVO>();

		if(searchKey.equals("tag")) {//태그
			logLists = service.selectSearchListsTag("%" + searchWord + "%", startNum, limitNum);
		}else {//제목, 작성자
			logLists = service.selectSearchLists(searchKey, "%" + searchWord + "%", startNum, limitNum);
		}
		
		//vo마다 tNum의 태그리스트 넣기
		for(LogVO lvo : logLists) {
			lvo.setTagList(service.selectLogTag(lvo.gettNum()));
		}
		return logLists;
	}
}