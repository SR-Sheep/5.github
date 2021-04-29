package com.ktx.ddep.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ktx.ddep.dao.AddressDAO;
import com.ktx.ddep.dao.MarketTimesDAO;
import com.ktx.ddep.dao.MarketsDAO;
import com.ktx.ddep.dao.MembersDAO;
import com.ktx.ddep.util.PaginateUtil;
import com.ktx.ddep.vo.Address;
import com.ktx.ddep.vo.Market;
import com.ktx.ddep.vo.MarketTime;
import com.ktx.ddep.vo.Member;
import com.ktx.ddep.vo.PageVO;
import com.ktx.ddep.vo.Point;

@Service
public class MembersServiceImpl implements MembersService {
	
	@Autowired
	private MembersDAO membersDAO;
	@Autowired
	private MarketsDAO marketsDAO;
	@Autowired
	private AddressDAO addressDAO;
	@Autowired
	private MarketTimesDAO marketTimesDAO;
	
	
	//마이페이지 유저정보 불러오기
	@Override
	public Map<String, Object> userInfo(int no) {
		
		// 맵선언
		Map<String, Object> modelMap = new ConcurrentHashMap<String, Object>();
		
       	//no로 member 정보 받기
       	Member member = membersDAO.selectOne(no);
       	modelMap.put("member", member);
       	
       	//addressNo 받아오기
       	int addressNo=member.getAddressNo();
       	
       	//addressNo로 address 정보 받아오기
       	Address address = addressDAO.selectOne(addressNo);
       	modelMap.put("address", address);
       	
       	//저번주 날짜 가져오기
       	Calendar cal = Calendar.getInstance();
       	cal.add(Calendar.DATE, -7);
       	SimpleDateFormat dateFmt = new SimpleDateFormat("yyyy-MM-dd");

       	//저번주 토요일 얻기
       	cal.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
       	String sat = dateFmt.format(cal.getTime()).toString();

       	//저번주 일요일 얻기
       	cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
       	String sun = dateFmt.format(cal.getTime()).toString();

       	//주간 랭킹을 위한 객체 생성, 원래는 시작시간을 mon으로 넣어야 하지면 현재 데이터를 가져오기 위해 강제로 210101로 설정
       	Point point =new Point("2021-01-01",sat);
       	//Q? no를 넣어주기는 하는데 이 no가 그 no가 아닌데 애라 모르겠다?
       	point.setNo(no);
       	
       	//주간 랭킹 얻기
       	Member memberWeeklyRank = membersDAO.selectWeeklyRankOne(point);
       	
       	//전체 랭킹 얻기
       	Member memberTotalRank = membersDAO.selectTotalRankerOne(no);       	
       	
       	//주간, 전체 랭킹 초기화
       	int totalRank=-1, weeklyRank =-1;
       	
       	//주간 랭킹값이 있으면 가져오기
       	if(memberWeeklyRank!=null){
       		weeklyRank = memberWeeklyRank.getRankNum();
       	}//if end
       	modelMap.put("weeklyRank", weeklyRank);
       	
      	//전체 랭킹 가져오기       	
       	totalRank=memberTotalRank.getRankNum();
       	modelMap.put("totalRank", totalRank);
       	
       	
       	try {
       		//no로 market정보 받아와보기	
           	Market market = marketsDAO.selectOne(no);
           	modelMap.put("market", market);
           	
           	//memberNo로 markettime 받아오기
           	List<MarketTime> marketTimes=marketTimesDAO.selectTime(no);
           	modelMap.put("marketTimes", marketTimes);      	
           	       	
           	//time을 표시 하기 위한 String 선언
           	String timeStr="";
           	
           	//time Str을 저장된 마켓 time 마다 / 붙은 형태로 추가 
           	for(MarketTime marketTime : marketTimes){ 
        		timeStr+=marketTime.getPerfectTime()+" / "; 
        	}//for end
           	
           	//timeStr의 마지막 "/ " 제거
           	if(timeStr.length()>2){
           		timeStr=timeStr.substring(0,timeStr.length()-2);
           	}
           	
           	//model에 넣기
           	modelMap.put("timeStr", timeStr);
		} catch (Exception e) {
			// TODO: handle exception
		}
     	
		return modelMap;
	}
	
	//로그인 정보 확인하기
	@Override
	public Member login(Member member) {				
		
		return membersDAO.selectLogin(member);
	}
	
	//프로필 사진 변경
	@Override
	public int changeProfile(Member member) {
		return membersDAO.updateProfileImg(member);
	}
	
	
	//주간랭킹정보 가져오기
	@Override
	public Map<String, Object> weeklyRanking(Member loginMember) {
		// 맵선언
		Map<String, Object> modelMap = new ConcurrentHashMap<String, Object>();		
		//저번주 날짜 가져오기
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -7);
		//날짜 출력 양식
		SimpleDateFormat dateFmt = new SimpleDateFormat("yyyy-MM-dd");
		//저번주 토요일 얻기
		cal.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
		String sat = dateFmt.format(cal.getTime()).toString();
		modelMap.put("sat", sat);
		//저번주 일요일 얻기
		cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		String sun = dateFmt.format(cal.getTime()).toString();
		modelMap.put("sun", sun);
		//주간 랭킹을 위한 객체 생성, 원래는 시작시간을 mon으로 넣어야 하지면 현재 데이터를 가져오기 위해 강제로 210101로 설정
		Point point =new Point("2021-01-01",sat);
		//순위 정보를 담은 객체 생성
		List<Member> members= membersDAO.selectWeeklyRankList(point);
		//랭킹정보 넣기
		modelMap.put("members", members);
		//마지막 순위 정보를 위한 랭킹 선언
		int lastRanking;
		//100명이 넘으면 최대 사이즈 100명, 나머지 경우 멤버 최대한 보여주기
		if(members.size()>101){
			lastRanking=100;
		}else{
			lastRanking=members.size();
		}
		//마지막 랭킹 순위 넣기
		modelMap.put("lastRanking", lastRanking);		
		//로그인되어 있으면 멤버 랭킹정보 가져오기
		if(loginMember!=null) {
			point.setNo(loginMember.getNo());	
			modelMap.put("myRank", membersDAO.selectWeeklyRankOne(point));
		}
		return modelMap;
	}
	
	//전체 랭킹
	@Override
	public Map<String, Object> totalRanking(Member loginMember, int page) {
		// 맵선언
		Map<String, Object> modelMap = new ConcurrentHashMap<String, Object>();		
		//한 페이지당 보여줄 게시물
		int numPage = 12;
	    //pageVO 객체 생성 -> start, end 값
		PageVO pageVO = new PageVO (page,numPage);
		//총 순위 객체 생성
		modelMap.put("members", membersDAO.selectTotalRankerList(pageVO));
		//top3를 위한 pageVO의 start, end 값 지정
		pageVO.setStart(1);
		pageVO.setEnd(3);
		//top3 객체 생성
		modelMap.put("top3", membersDAO.selectTotalRankerList(pageVO));	
		//총멤버수	
		int total = membersDAO.selectTotal();
		//페이지 블럭수
		int numBlock = 5;
		//주소
		String url="/rank/total";
		//paginate 생성	
		modelMap.put("paginate", PaginateUtil.getPaginate(page, total, numPage, numBlock, url));
		//로그인되어 있으면 멤버 랭킹정보 가져오기
		if(loginMember!=null) {
			modelMap.put("myRank", membersDAO.selectTotalRankerOne(loginMember.getNo()));
		}
		return modelMap;
	}
	
	//닉네임 변경
	@Override
	public int changeNickname(Member member) {
		return membersDAO.updateNickname(member);
	}
	
	//닉네임 체크
	@Override
	public boolean checkNickname(String nickname) {
		//닉네임 변경
		int count = membersDAO.selectCheckNickname(nickname);
		//변경되면 참
		boolean result=count==1;
		
		return result;
	}
	
	
	//주소 변경
	public void changeAddress(Address address) {
		addressDAO.updateAddress(address);
	}
	
	

}
