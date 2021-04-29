package com.ktx.ddep.controller;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ktx.ddep.service.MembersService;
import com.ktx.ddep.util.FileRenameUtil;
import com.ktx.ddep.util.ResizeImageUtil;
import com.ktx.ddep.vo.Address;
import com.ktx.ddep.vo.Member;

@Controller
public class MemberController {
	
	@Autowired
	private MembersService service;
	
	//마이페이지 접속
	@RequestMapping(value = "/mypage/{no}", method = RequestMethod.GET)
	public String mypage(Model model, @PathVariable int no) {
		//유저정보 가져오기
		model.addAllAttributes(service.userInfo(no));		
		return "mypageHeader";
	}
	
	//로그인 페이지 접속
	@RequestMapping(value = "/login", method=RequestMethod.GET)
	public String login() {
		return "login";
	}
	
	//로그아웃
	@RequestMapping(value = "/log", method=RequestMethod.DELETE)
	public String logout(HttpSession sesion, HttpServletRequest request) {
		//세션 비활성화
		sesion.invalidate();
		//이전페이지로 보내기
		return "redirect:"+request.getHeader("Referer");
	}
	
	//로그인 확인
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginCheck(HttpSession session, Member member, RedirectAttributes ra) {
		//로그인 멤버 불러오기
		Member loginMember=service.login(member);
		
		if(loginMember==null) {
			//로그인 실패, msg에 값을 넣어주고 login에서 값을 공유
			ra.addFlashAttribute("msg", "아이디나 비밀번호가 틀렸습니다.");
			//로그인 페이지로 이동
			return "redirect:/login";
		}else {			
			//로그인 성공
			session.setAttribute("loginMember", loginMember);
			ra.addFlashAttribute("msg","반갑습니다"+loginMember.getNickname()+"님");
			//메인 페이지로 이동
			return "redirect:/";
		}//if~else end	
	}
	
	//프로필 변경
	@RequestMapping(value = "/ajax/profile", method = RequestMethod.PUT)
	public String changeProfile2() {
		System.out.println("put이다");
		return "";
	}
	//프로필 변경
	@RequestMapping(value = "/ajax/profile", method = RequestMethod.POST)
	@ResponseBody
	public Member changeProfile(HttpServletRequest request,
			 MultipartFile profile, HttpSession session) throws Exception{
				Member loginMember =(Member)session.getAttribute("loginMember");		
				// 서버
				ServletContext application = request.getServletContext();
				// 기본경로
				String rootPath = application.getRealPath("/");
				// 업로드 폴더 경로
				String uploadPath = rootPath + "img" + File.separator + "upload" + File.separator;
				// 파일의 실제 이름
				String fileName = profile.getOriginalFilename();
				// 파일 객체 생성
				File file = new File(uploadPath + fileName);
				// 파일이름이 같다면 숫자가 붙음
				file = FileRenameUtil.rename(file);
				//System.out.println(file);
				// 임시폴더에 우리 업로드폴더로 이동
				profile.transferTo(file);
				// 리사이즈 경로 설정
				String resizePath = rootPath + "img" + File.separator + "profileImg" + File.separator;
				// 리사이즈
				ResizeImageUtil.resize(file.toString(), resizePath + file.getName(), 200);				
				//profileImage를 세팅(파일의 이름으로)
				loginMember.setProfileImg(file.getName());
				//프로필 이미지 이름 변경
				service.changeProfile(loginMember);
				return loginMember;
			}
	
	//주간 랭킹 접속
	@RequestMapping(value ="/rank/week" ,method = RequestMethod.GET)
	public String weeklyRanking(Model model, HttpSession sesion) {
		//랭킹정보 가져오기
		model.addAllAttributes(service.weeklyRanking((Member)sesion.getAttribute("loginMember")));		
		return "/rankingWeekly";
	}
	
	//전채 랭킹 접속
	@RequestMapping(value ="/rank/total/page/{page}" ,method = RequestMethod.GET)
	public String totalRanking(Model model, HttpSession sesion,@PathVariable int page) {
		//랭킹정보 가져오기
		model.addAllAttributes(service.totalRanking((Member)sesion.getAttribute("loginMember"),page));		
		return "/rankingTotal";
	}
	
	
	//닉네임 변경
	@RequestMapping(value = "/ajax/nickname",method=RequestMethod.PUT)
	@ResponseBody
	public void changeNickname(Member member) {
		//닉네임 변경
		service.changeNickname(member);
	}
	
	//닉네임 체크
		@RequestMapping(value = "/ajax/nickname",method=RequestMethod.GET)
		@ResponseBody
		public boolean checkNickname(String nickname) {
			//닉네임 체크			
			return service.checkNickname(nickname);
		}
		
		//주소 변경
		@RequestMapping(value = "/ajax/address",method=RequestMethod.PUT)
		@ResponseBody
		public void changeAddress(Address address) {
			//주소 변경			
			service.changeAddress(address);
		}

}
