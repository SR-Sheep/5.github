package com.ktx.ddep.service;

import java.util.Map;

public interface RecipesService {
	
	//레시피 검색시
	public Map<String,Object> getRecipes(int page, String choice, String keyword);
	
	//레시피 전체 목록
	public Map<String,Object> getAllrecipes(int page, String choice);
}
