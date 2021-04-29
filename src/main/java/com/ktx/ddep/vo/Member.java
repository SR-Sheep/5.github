package com.ktx.ddep.vo;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Calendar;

public class Member {
	private int no, currPoints, accuPoints, addressNo, loginCount, /* 210122 양 랭킹 순위 */ rankNum,
			/* 210126 양 주간 랭킹 합산포인트 */sumPoint;

	private String email, password, name, nickname, phoneNumber, profileImg, sido, gugun, dong;
	private String gender, marketkeeperStep, warning, tutorial, grade, rcpWarning;
	private String gradeImg,gradeBigImg;
	private Date birthDate, startDay;
	private Timestamp regdate;
	private Double lat, lng;

	// 2021-01-24 이소현
	private Calendar calendar;

	public Calendar getCalendar() {
		return calendar;
	}

	public void setCalendar(Calendar calendar) {
		this.calendar = calendar;
	}

	public int getNowYear() {
		return nowYear;
	}

	public void setNowYear(int nowYear) {
		this.nowYear = nowYear;
	}

	private int nowYear;

	public Member() {

		calendar = Calendar.getInstance();

		nowYear = calendar.get(Calendar.YEAR);

	}

	public int getRankNum() {
		return rankNum;
	}

	public String getRcpWarning() {
		return rcpWarning;
	}

	public void setRcpWarning(String rcpWarning) {
		this.rcpWarning = rcpWarning;
	}

	public void setRankNum(int rankNum) {
		this.rankNum = rankNum;
	}

	public String getMarketkeeperStep() {
		return marketkeeperStep;
	}

	public void setMarketkeeperStep(String marketkeeperStep) {
		this.marketkeeperStep = marketkeeperStep;
	}

	// 로그인
	public Member(String email, String password) {
		this.email = email;
		this.password = password;
	}

	// 회원가입
	public Member(int addressNo, String email, String password, String name, String nickname, String phoneNumber,
			String gender, Date birthDate) {
		this.addressNo = addressNo;
		this.email = email;
		this.password = password;
		this.name = name;
		this.nickname = nickname;
		this.phoneNumber = phoneNumber;
		this.gender = gender;
		this.birthDate = birthDate;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getCurrPoints() {
		return currPoints;
	}

	public void setCurrPoints(int currPoints) {
		this.currPoints = currPoints;
	}

	public int getAccuPoints() {
		return accuPoints;
	}

	public void setAccuPoints(int accuPoints) {
		this.accuPoints = accuPoints;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public int getAddressNo() {
		return addressNo;
	}

	public void setAddressNo(int addressNo) {
		this.addressNo = addressNo;
	}

	public int getLoginCount() {
		return loginCount;
	}

	public void setLoginCount(int loginCount) {
		this.loginCount = loginCount;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getProfileImg() {
		return profileImg;
	}

	public void setProfileImg(String profileImg) {
		this.profileImg = profileImg;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMarketkepperStep() {
		return marketkeeperStep;
	}

	public void setMarketkepperStep(String marketkepperStep) {
		this.marketkeeperStep = marketkepperStep;
	}

	public String getWarning() {
		return warning;
	}

	public void setWarning(String warning) {
		this.warning = warning;
	}

	public String getTutorial() {
		return tutorial;
	}

	public void setTutorial(String tutorial) {
		this.tutorial = tutorial;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		calendar.setTime(birthDate);
		this.birthDate = birthDate;
	}

	public Date getStartDay() {
		return startDay;
	}

	// 2021-01-24 이소현
	public int getYear() {
		return calendar.get(Calendar.YEAR);
	}

	// 2021-01-24 이소현
	public int getMonth() {
		return calendar.get(Calendar.MONTH) + 1;
	}

	// 2021-01-24 이소현
	public int getDate() {
		return calendar.get(Calendar.DATE);
	}

	public void setStartDay(Date startDay) {
		this.startDay = startDay;
	}

	public Timestamp getRegdate() {
		return regdate;
	}

	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}

	public int getSumPoint() {
		return sumPoint;
	}

	public void setSumPoint(int sumPoint) {
		this.sumPoint = sumPoint;
	}

	public String getSido() {
		return sido;
	}

	public void setSido(String sido) {
		this.sido = sido;
	}

	public String getGugun() {
		return gugun;
	}

	public void setGugun(String gugun) {
		this.gugun = gugun;
	}

	public String getDong() {
		return dong;
	}

	public void setDong(String dong) {
		this.dong = dong;
	}

	public Double getLat() {
		return lat;
	}

	public void setLat(Double lat) {
		this.lat = lat;
	}

	public Double getLng() {
		return lng;
	}

	public void setLng(Double lng) {
		this.lng = lng;
	}

	// 210122 양 등급 이미지를 불러오는 함수
	public String getGradeImg() {

		String iconName = "";

		// 210125 양 등급 String로 바뀌면 사용
		if (grade.equals("f")) {
			iconName = "Family";
		} else if (grade.equals("s")) {
			iconName = "Silver";
		} else if (grade.equals("g")) {
			iconName = "Gold";
		} else if (grade.equals("p")) {
			iconName = "Platinum";
		} else if (grade.equals("d")) {
			iconName = "Diamond";
		} else if (grade.equals("h")) {
			iconName = "Heritage";
		} else if (grade.equals("r")) {
			iconName = "Royal";
		}

		return "<img src=\"/img/icon" + iconName + "Small.png\" alt=\"" + iconName + "\">";

	}

	// 210125 양 전체 랭킹 등급 이미지를 불러오는 함수
	public String getGradeBigImg() {

		String iconName = "";

		// 210125 양 등급 String로 바뀌면 사용
		if (grade.equals("f")) {
			iconName = "Family";
		} else if (grade.equals("s")) {
			iconName = "Silver";
		} else if (grade.equals("g")) {
			iconName = "Gold";
		} else if (grade.equals("p")) {
			iconName = "Platinum";
		} else if (grade.equals("d")) {
			iconName = "Diamond";
		} else if (grade.equals("h")) {
			iconName = "Heritage";
		} else if (grade.equals("r")) {
			iconName = "Royal";
		}

		return "<img src=\"/img/icon" + iconName + ".png\" alt=\"" + iconName + "\">";

	}


	public void setGradeBigImg(String gradeBigImg) {
		this.gradeBigImg = gradeBigImg;
	}

	public void setGradeImg(String gradeImg) {
		this.gradeImg = gradeImg;
	}
	
	

}
