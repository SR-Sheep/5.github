package com.ktx.ddep.service;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ktx.ddep.dao.RcpsDAO;
import com.ktx.ddep.dao.RcpsDAOImpl;
import com.ktx.ddep.vo.PageVO;
import com.ktx.ddep.vo.Rcp;

import org.springframework.stereotype.Service;

@Service
public class RecipesServiceImpl implements RecipesService {

	@Autowired
	private RcpsDAO rcpsDAO;

	@Override
	public Map<String, Object> getRecipes(int page, String choice, String keyword) {
		Map<String, Object> modelMap = new ConcurrentHashMap<String, Object>();
		// pageVO 객체 생성 -> start, end 값
		PageVO pageVO = new PageVO(page, 12);
		// pageVO에 choice 넣기
		pageVO.setChoice(choice);
		// 키워드를 저장할 배열 선언
		String[] keywordArr = null;
		// arry -> set으로 변환(중복값 제거)을 위한 선언
		LinkedHashSet<String> keywordSet = new LinkedHashSet<>();
		// 배열에 키워드 넣기 & 키워드 사이의 공백을 | 로 변경 시도
		try {
			// 공백 기준 arr에 넣기
			keywordArr = keyword.split(" ");
			// 중복값 제거를 위한 set 변환
			for (String word : keywordArr) keywordSet.add(word);
			// set에서 빈 값 제거
			keywordSet.remove("");
			// set을 string으로 변환 및 [ ] 제거
			keyword = keywordSet.toString().substring(1, keywordSet.toString().length() - 1);
			// mapper 이용을 위해 ,를 | 로 변환
			keyword = keyword.replace(", ", "|");
		} catch (Exception e) {}
		// 210129 양 모든 레시피 수 불러오기
		if (keyword.equals("null") || keyword.length() == 0) {
			// 210129 양 모든 레시피 목록 불러오기			
			modelMap.put("rcpsNum", rcpsDAO.countRcps());
		} else {
			pageVO.setKeyword(keyword);
			modelMap.put("rcpsNum", rcpsDAO.countRcps(keyword));
		} // if~else end		
		modelMap.put("recipes", rcpsDAO.selectListByKeyword(pageVO));
		modelMap.put("keywordSet", keywordSet);		

		return modelMap;
	}

	@Override
	public Map<String, Object> getAllrecipes(int page, String choice) {

		// 맵선언
		Map<String, Object> modelMap = new ConcurrentHashMap<String, Object>();

		// pageVO 객체 생성 -> start, end 값
		PageVO pageVO = new PageVO(page, 12);

		// choice 넣기
		pageVO.setChoice(choice);

		// 레시피 정보 넣기
		modelMap.put("recieps", rcpsDAO.selectListByKeyword(pageVO));

		// 레시피 갯수 넣기
		modelMap.put("reicpeNum", rcpsDAO.countRcps());

		return modelMap;
	}

}
