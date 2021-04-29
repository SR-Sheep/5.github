package com.ktx.ddep.controller;

import java.util.LinkedHashSet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ktx.ddep.service.RecipesService;

@Controller
public class RecipeController {
	
	@Autowired
	private RecipesService service;
		
	
	//레시피 리스트 페이지 접속
	@RequestMapping(value ="/recipe",method = RequestMethod.GET)
	public String recipePage(Model model,@RequestParam(defaultValue ="1") int page, @RequestParam(defaultValue = "recent") String choice, @RequestParam(defaultValue="null")String keyword) {
		//검색시 키워드 저장
		model.addAttribute("keyword",keyword);
		//레시피 리스트 정보 불러오기
		model.addAllAttributes(service.getRecipes(page, choice, keyword));
		return "recipeListPage";
	}
	
	//ajax로 레시피 다음 목록 불러오기
	@RequestMapping(value="/ajax/recipelist", method=RequestMethod.GET,
			produces = "application/json; charset=UTF-8")
	@ResponseBody
	public Map<String, Object> loadRecipes(Model model, int page, String choice,
			@RequestParam(defaultValue="null") String keyword) {
		return service.getRecipes(page, choice, keyword);
	}
	
	
	@RequestMapping(value = "/recipe/{recipeNo}", method = RequestMethod.GET)
	public String recipeDetail(Model model, @PathVariable int recipeNo) {
		return "";
	}

}
