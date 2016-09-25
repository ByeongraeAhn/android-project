package com.ldcc.android.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.ldcc.android.dao.VoteDao;
import com.ldcc.android.domain.ResultVo;
import com.ldcc.android.domain.VoteVo;

@Controller
public class TestController {

	@Autowired
	VoteDao voteDao;
	
	@RequestMapping(value = "/validation", method = RequestMethod.GET)
	public Object validation(
			@RequestParam String name)
			throws UnsupportedEncodingException {

		
		//이름 디코딩
		String nameUTF = URLDecoder.decode(name, "utf-8");
		
		//초기 설정
		HashMap<String, Object> responseData = new HashMap<String, Object>();
		responseData.put("status", "success");
		
		//투표 했는지 검증
		List<VoteVo> voteVoValidation = voteDao.validationName();
		
		for (int i = 0; i < voteVoValidation.size(); i++) {
			if (voteVoValidation.get(i).getName().equals(nameUTF)) {
				responseData.put("status", "dup");
			} 
		}

		return responseData;

	}

	// 투표 INSERT
	@RequestMapping(value = "/voteinsert", method = RequestMethod.GET)
	public Object voteinsert(
			@RequestParam int question, 
			@RequestParam int selected, 
			@RequestParam int delay,
			@RequestParam String name)
			throws UnsupportedEncodingException {

		// 1번 - 2
		// 2번 - 4
		// 3번 - 1
		// 4번 - 3
		// 5번 - 2
		
		//클라이언트 IP확인
		HttpServletRequest req = ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();
        String ip = req.getHeader("X-FORWARDED-FOR");
        if (ip == null) {
        	ip = req.getRemoteAddr();
        }
        System.out.println("[투표]접속 아이피       :    " + ip);
        
        //현재시간
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd, hh:mm:ss a"); 
        System.out.println("[투표]접속 시간      :     " + sdf.format(new Date()).toString()); 
		
		//이름 디코딩
		String nameUTF = URLDecoder.decode(name, "utf-8");
		
		//초기 설정
		HashMap<String, Object> responseData = new HashMap<String, Object>();
		responseData.put("status", "success");
		
		// question = 문제
		// selected = 정답
		int correct = 0;
		switch (question) {
		case 1:
			if (selected == 2) {
				correct = 1;
			}
			break;

		case 2:
			if (selected == 4) {
				correct = 1;
			}
			break;

		case 3:
			if (selected == 1) {
				correct = 1;
			}
			break;

		case 4:
			if (selected == 3) {
				correct = 1;
			}
			break;
		case 5:
			if (selected == 2) {
				correct = 1;
			}
			break;
		default:
			break;
		}

		//값 세팅 후 인서트
		VoteVo voteVo = new VoteVo();
		voteVo.setName(nameUTF);
		voteVo.setQuestion(question);
		voteVo.setSelected(selected);
		voteVo.setDelay(delay);
		voteVo.setCorrect(correct);
		voteDao.insert(voteVo);

		return responseData;

	}

	// 랭킹 결과 받아오기
	@RequestMapping(value = "/voteresult", method = RequestMethod.GET)
	public Object voteresult() {
		
		//클라이언트 IP확인
		HttpServletRequest req = ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();
        String ip = req.getHeader("X-FORWARDED-FOR");
        if (ip == null) {
        	ip = req.getRemoteAddr();
        }
        System.out.println("[결과페이지]접속 아이피       :    " + ip);
        
        //현재시간
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd, hh:mm:ss a"); 
        System.out.println("[결과페이지]접속 시간      :     " + sdf.format(new Date()).toString()); 

		VoteVo voteVo = new VoteVo();

		HashMap<String, Object> responseData = new HashMap<String, Object>();
		responseData.put("caseby", "boardlist");
		responseData.put("status", "success");
		responseData.put("data", voteDao.selectAll());
		
		return responseData;
	}

	// 투표 통계
	@RequestMapping(value = "/votecal", method = RequestMethod.GET)
	public Object votecal() {

		HashMap<String, Object> responseData = new HashMap<String, Object>();
		responseData.put("caseby", "boardlist");
		responseData.put("status", "success");
		
		ResultVo list;

		//문제1(보기4개)
		list = voteDao.selectCal1();
		int a1 = list.getQ1num1();
		int b1 = list.getQ1num2();
		int c1 = list.getQ1num3();
		int d1 = list.getQ1num4();
		
		List<Integer> listper1 = new ArrayList<Integer>();
		listper1.add((int) (a1 / (float) (a1 + b1 + c1 + d1) * 100));
		listper1.add((int) (b1 / (float) (a1 + b1 + c1 + d1) * 100));
		listper1.add((int) (c1 / (float) (a1 + b1 + c1 + d1) * 100));
		listper1.add((int) (d1 / (float) (a1 + b1 + c1 + d1) * 100));
		listper1.add(a1);
		listper1.add(b1);
		listper1.add(c1);
		listper1.add(d1);
		
		//문제2(보기4개)
		list = voteDao.selectCal2();
		int a2 = list.getQ1num1();
		int b2 = list.getQ1num2();
		int c2 = list.getQ1num3();
		int d2 = list.getQ1num4();

		List<Integer> listper2 = new ArrayList<Integer>();
		listper2.add((int) (a2 / (float) (a2 + b2 + c2 + d2) * 100));
		listper2.add((int) (b2 / (float) (a2 + b2 + c2 + d2) * 100));
		listper2.add((int) (c2 / (float) (a2 + b2 + c2 + d2) * 100));
		listper2.add((int) (d2 / (float) (a2 + b2 + c2 + d2) * 100));
		listper2.add(a2);
		listper2.add(b2);
		listper2.add(c2);
		listper2.add(d2);
		
		//문제3(보기4개)
		list = voteDao.selectCal3();
		int a3 = list.getQ1num1();
		int b3 = list.getQ1num2();
		int c3 = list.getQ1num3();
		int d3 = list.getQ1num4();

		List<Integer> listper3 = new ArrayList<Integer>();
		listper3.add((int) (a3 / (float) (a3 + b3 + c3 + d3) * 100));
		listper3.add((int) (b3 / (float) (a3 + b3 + c3 + d3) * 100));
		listper3.add((int) (c3 / (float) (a3 + b3 + c3 + d3) * 100));
		listper3.add((int) (d3 / (float) (a3 + b3 + c3 + d3) * 100));
		listper3.add(a3);
		listper3.add(b3);
		listper3.add(c3);
		listper3.add(d3);
		
		//문제4(보기4개)
		list = voteDao.selectCal4();
		int a4 = list.getQ1num1();
		int b4 = list.getQ1num2();
		int c4 = list.getQ1num3();
		int d4 = list.getQ1num4();
		
		List<Integer> listper4 = new ArrayList<Integer>();
		listper4.add((int) (a4 / (float) (a4 + b4 + c4 + d4) * 100));
		listper4.add((int) (b4 / (float) (a4 + b4 + c4 + d4) * 100));
		listper4.add((int) (c4 / (float) (a4 + b4 + c4 + d4) * 100));
		listper4.add((int) (d4 / (float) (a4 + b4 + c4 + d4) * 100));
		listper4.add(a4);
		listper4.add(b4);
		listper4.add(c4);
		listper4.add(d4);
		
		//문제5(보기4개)
		list = voteDao.selectCal5();
		int a5 = list.getQ1num1();
		int b5 = list.getQ1num2();
		int c5 = list.getQ1num3();
		int d5 = list.getQ1num4();
		
		List<Integer> listper5 = new ArrayList<Integer>();
		listper5.add((int) (a5 / (float) (a5 + b5 + c5 + d5) * 100));
		listper5.add((int) (b5 / (float) (a5 + b5 + c5 + d5) * 100));
		listper5.add((int) (c5 / (float) (a5 + b5 + c5 + d5) * 100));
		listper5.add((int) (d5 / (float) (a5 + b5 + c5 + d5) * 100));
		listper5.add(a5);
		listper5.add(b5);
		listper5.add(c5);
		listper5.add(d5);
		
		
		responseData.put("listper1", listper1);
		responseData.put("listper2", listper2);
		responseData.put("listper3", listper3);
		responseData.put("listper4", listper4);
		responseData.put("listper5", listper5);

		return responseData;
	}
	
	// 과거
	@RequestMapping(value = "/voteinsert2", method = RequestMethod.GET)
	public Object voteinsert2(@RequestParam String checked, HttpSession session) {
		int idx = Integer.parseInt(checked);

		HashMap<String, Object> responseData = new HashMap<String, Object>();

		if (session.isNew() == false) {
			System.out.println("isnew 들어옴");
			responseData.put("status", "dup");
			return responseData;
		} else {
			VoteVo voteVo = new VoteVo();
			voteDao.update(idx);
			System.out.println("else 들어옴");

			responseData.put("status", "new");

			return responseData;

		}
	}

}
