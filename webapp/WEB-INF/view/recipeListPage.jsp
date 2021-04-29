<%@page import="java.util.LinkedHashSet"%>
<%@page import="java.util.HashSet"%>
<%@page import="org.apache.ibatis.reflection.SystemMetaObject"%>
<%@page import="com.ktx.ddep.dao.RcpsSavedDAO"%>
<%@page import="com.ktx.ddep.vo.PageVO"%>
<%@page import="com.ktx.ddep.dao.RcpRvsDAOImpl"%>
<%@page import="com.ktx.ddep.dao.MembersDAO"%>
<%@page import="com.ktx.ddep.dao.RcpsDAOImpl"%>
<%@page import="java.util.List"%>
<%@page import="com.ktx.ddep.vo.Rcp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>레시피 목록페이지</title>
<c:import url="/WEB-INF/view/template/link.jsp"/>
<style>

/*21-02-09 08:18 양 스크롤바 덜컹 거려서 추가함  */
html { overflow-y:scroll; }

#recipe {
	padding: 5px;
	/*margin: auto;*/
	width: 1100px;
	margin: auto;
	position: relative;
}


.category, .radio {
	display: none;
	/*cursor: pointer;*/
}

.category:checked+label, .radio:checked+label {
	background-color: rgb(204, 168, 114);
	color: #fff;
	/*cursor: pointer;*/
}


.recipe_list {
	padding: 35px 0px;
	width: 1100px;
	position: relative;
	/*양*/
	background-color: #fafafa;
	clear: both;
	
}

.recipe_box_wrap{
	width: 1060px;
	margin:auto;
}

.recipe_list .recipe_box {
	display: inline-block;
	position : relative;
	margin: 20px;
	width: 225px;
	box-shadow: 0 2px 5px 0 rgba(0, 0, 0, 0.16), 0 2px 10px 0 rgba(0, 0, 0, 0.12);
	transition : .2s ease;
	
}

.recipe_box{
	animation : fade 1 .8s ease;
}

.recipe_list .recipe_box:hover {
	box-shadow: 0 2px 5px 0 rgba(0, 0, 0, 0.16), 0 10px 10px 0 rgba(0, 0, 0, 0.12);
	
	
}

.recipe_box:hover{
	transform : scale(1.05);
	
}

.recipe_img{
	width: 225px;
	height: 180px;
}

.recipe_box>h3 {
	font-size: 14px;
}

.recipe_box>h3>img {
	width: 25px;
	height: 25px;
	border-radius: 50%;
}



.recipe_number, .recipe_price {
	margin-right: 30px;
	float: left;
	height: 40px;
}



<%--검색관련 --%>
#edge {
	position : relative;
	width: 400px;
	height: 40px;
	/*border: 1px solid #424242;
	border-radius: 10px;*/
	margin : 10px;
}

#edge #getBtn {
	position : absolute;
	height: 30px;
	width : 30px;
	top : 5px;
	right : 10px;
	background-color: white;
	
	font-size : 20px;
	
	border: none;
	cursor: pointer;
	}
	
#search {
	margin: 10px;
	width: 340px;
	
	font-size : 20px;
	line-height: 15px;
	
	border: none;
	border-bottom: 1px solid #424242;
}	


.recipe_filter {
	float: right;
	height: 50px;
	padding: 5px;
	position: relative;
	/*양*/
	text-align: right;
}

#categoryBox {
	padding: 20px; /*15px*/
	height: 110px; /*100px*/
	position: relative;
	border-top : 1px solid #424242;
	border-bottom : 1px solid #424242;
	margin-top : 15px 0;
	
	
	
	/*background-color: red;*/

	/*margin: auto;*/
	/*display: block;*/
}



/*방현수 수정 구역*/
.recipe_title_wrap, .recipe_box .profile_wrap {
	position : relative;
	display:table;
	width: 225px;
	overflow: hidden;
	height: 42px;
}

.title_area, .profile_area {
	width:130px;
	display:table-cell;
	padding: 10px 0 10px 10px;
}

.subtitle {
	font-size: 12px;
	margin-bottom: 5px;
	color : #424242;
}

.title {
	font-size: 15px;
	font-weight: 600;
}

.rate_area, .recipe_area {
	display:table-cell;
	vertical-align : middle;
	text-align:center;
	padding: 5px;
}

.rate_area img {
	width: 30px;
	float: left;
}

.rate_point {
	color: goldenrod;
	line-height: 25px;
}

.profile_img {
	border: 1px solid #b89878;
	width: 28px;
	border-radius: 50%;
	float: left;
	position: relative;
}

.profile_name {
	font-size: 12px;
	line-height: 30px;
	margin-left: 5px;
}



/*검색결과*/

.recipe_keyword_wrap {
	width: 1100px;
	margin: auto;
	border-bottom: 1px solid #424242;
}

.recipe_keyword {
	display : inline-block;	
	margin: auto 20px;
	padding: 10px;
	background-color: rgb(204, 168, 114);
	border-radius: 10px;
	color: white;	
	margin: 15px;
}


.search_result .recipe_keyword {
	font-size : 10px;
	margin : 10px 5px;
}



.category_lbl {
	border: 1px solid gray;
	border-radius: 20px;
	margin-right: 20px;
	padding: 5px 20px;
}

.filter_lbl {
	display : inline-block;
	border: 1px solid gray;
	border-radius: 10px;
	text-align: center;	
	padding: 5px;
	margin-right: 5px;
	width : 80px;
	height : 30px;
	line-height: 26px;
	/*margin-bottom: 10px;*/
}

.category_price, .category_number {
	height: 40px;
	line-height: 40px;
	margin-bottom: 30px; /*20px*/
	/*양*/
	clear: both;
}

.price_area, .number_area {
	height: 40px;
	float: left;
	line-height: 40px;
}

#moreList{
	position : relative;
	text-align: center;
}

#moreList button {
	position: relative;
	border: 1px solid gray;	
	/*padding: 5px;*/
	width: 1050px;
	height: 40px;
	line-height: 40px;
	text-align: center;
	font-weight: 700;
}


.rcps_num{
	float : left;
	margin : 30px 0 10px 20px;
}

#goTop {
	position: fixed;
	right: 50px;
	top: 80%;	
}

#topBtn {
	width: 45px;
	height: 45px;
	font-size: 25px;
}

/*    리본 구역 */
/*    .ribbon_wrap {*/
/*        width: 30px;*/
/*        margin: 10px auto;*/
/*        background-color: aquamarine;*/

/*        !*margin: 10px auto;*!*/
/*        position: relative;*/
/*    }*/
/*    .ribbon_type img{*/
/*        width: 30px;*/
/*        height: 50px;*/

/*        vertical-align: middle;*/
/*    }*/
/*    .category_ribbon {*/
/*        margin: auto;*/
/*        font-size: 10px;*/
/*        width: 30px;*/
/*        height: 30px;*/
/*        !*background-color: yellow;*!*/
/*        text-align: center;*/

/*        display: block;*/
/*        position: absolute;*/
/*        top: 10%;*/
/*        left: 0;*/
/*        color: #fff;*/
/*    }*/

/*.ribbon_price {*/
/*    width: 30px;*/
/*    margin: 10px auto;*/
/*    background-color: aquamarine;*/

/*    !*margin: 10px auto;*!*/
/*    position: relative;*/
/*}*/

	/* 리본 안 글씨 */
	.ribbon_font {
		font-size: 10px;
		width: 30px;
		height: 30px;
		line-height: 10px;
		/*background-color: yellow;*/
		text-align: center;
		position: absolute;
		/*top: 10%;*/
		/*left: 0;*/
		color: #fff;
		top: 0px;
		left: -15px;
	}
	
	/* 리본 */
	/* 양 수정 */
	.cheap3 {
		position: relative;
		margin-left: 30px;
	}
	
	.cheap3 img {
		position: absolute;
		top: -10px;
		left: -15px;
		width: 30px;
		height: 60px;
	}
	/* 양 수정 부분 끝 */
	.cheap2 {
		position: relative;
		margin-left: 30px;
	}
	
	.cheap2 img {
		position: absolute;
		top: -10px;
		left: -15px;
		width: 30px;
		height: 60px;
	}
	
	.cheap1 {
		position: relative;
		margin-left: 30px;
	}
	
	.cheap1 img {
		position: absolute;
		top: -10px;
		left: -15px;
		width: 30px;
		height: 60px;
	}
	
	.comfort3 {
		position: relative;
		margin-left: 30px;
	}
	
	.comfort3 img {
		position: absolute;
		top: -10px;
		left: -15px;
		width: 30px;
		height: 60px;
	}
	
	.comfort2 {
		position: relative;
		margin-left: 30px;
	}
	
	.comfort2 img {
		position: absolute;
		top: -10px;
		left: -15px;
		width: 30px;
		height: 60px;
	}
	
	.comfort1 {
		position: relative;
		margin-left: 30px;
	}
	
	.comfort1 img {
		position: absolute;
		top: -10px;
		left: -15px;
		width: 30px;
		height: 60px;
	}

	.ribbon{
	    display: inline-block;
	    position: relative;
	    float: right;
	}
	
	.ribbon img{
	    width: 40px;
	}
	
	.ribbon_wrap{
	    position : absolute;
	    right: 0;
	    top:0;
	}
	
	.view_area, .scrap_area{
		display: table-cell;
		vertical-align:middle;
		font-size: 12px;
		text-align: center;		
	}
	
	.view_area i, .scrap_area i{
		color :  #cca872		
	}
	
	.view_area div, .scrap_area div{
		margin: 5px;
	}
	
	.profile_area a:hover{
		text-decoration: underline;
		font-weight: 700;
	}
	
	
	<%--21-02-17 15:41 양 결과 없을 시  --%>
	.no_recipe{
		position : relative;
		height : 500px;	
		font-size : 40px;
		text-align: center;
	}
	
	.no_recipe img, .no_recipe h3{
		margin : 20px;
		
		
	}
	
	
	
	@keyframes fade{
		0%{
			opacity: 0;
			transform : translateY(10px);
		}
		100%{
			opacity: 1;
			transform : translateY(0px);
		}
	}
	
	
	


</style>
</head>
<body>
<c:import url="/WEB-INF/view/template/header.jsp">
	<c:param name="type" value="recipe"></c:param>
</c:import>

	<div id="recipe">
		<form action="/recipe" method="get">
			<div id="edge">
				<input type="text" name="keyword" id="search"
					placeholder="재료, 레시피를 검색하세요.">
				<button id="getBtn">
					<i class="fas fa-search"></i>
				</button>
			</div>
			<!-- edge end -->
		

		<div id="categoryBox" class="hidden">

			<div class="category_price">

				<h2 class="recipe_price">가격대</h2>

				<div class="ribbon_price ">

					<div class="price_area cheap3">
						<img src="/img/ribbon1Cheap3.png">
						<input type="checkbox" id="cheap3" name="cheap3" value="3" class="category " />
						<label for="cheap3" class="category_lbl"> 저렴+3 </label>
					</div>

					<div class="price_area cheap2">
						<img src="/img/ribbon2Cheap2.png">
						<input type="checkbox" id="cheap2" name="cheap2" value="2" class="category " />
						<label for="cheap2" class="category_lbl "> 저렴+2 </label>
					</div>
					<div class="price_area cheap1">
						<img src="/img/ribbon3Cheap1.png">
						<input type="checkbox" id="cheap1" name="cheap1" value="1" class="category " />
						<label for="cheap1" class="category_lbl "> 저렴+1 </label>
					</div>
				</div><%--//ribbon_price end --%>
			</div><%--//category_price end --%>
			
			


			<div class="category_number">
				<h2 class="recipe_number">재료수</h2>
				<div class="number_area comfort3">
					<img src="/img/ribbon4Easy3.png">
					<input type="checkbox" name="easy" id="easy3" value="3" class="category" />
					<label for="easy3" class="category_lbl "> 편리+3 </label>
				</div>
				<!-- number_area -->
				<div class="number_area comfort2">
					<img src="img/ribbon5Easy2.png"> 
					<input type="checkbox" name="easy" id="easy2" value="2" class="category"/>
					<label for="easy2" class="category_lbl "> 편리+2 </label>
				</div>
				<!-- number_area -->
				<div class="number_area comfort1">
					<img src="img/ribbon6Easy1.png">
					<input type="checkbox" name="easy" id="easy1" value="1" class="category" />
					<label for="easy1" class="category_lbl"> 편리+1 </label>
				</div>
				<!-- number_area -->
			</div>
			<!-- category_number end -->
		</div>
		<!-- categoryBox end -->
		</form>
		<%--21-02-14 11:32 양 검색시 키워드 보여주기 --%>
		<div class="recipe_keyword_wrap">
			<c:forEach items="${keywordSet}" var="word">
				<c:if test="${word!='null'}">
				       <h3 class="recipe_keyword">${word}</h3>
				</c:if>
			</c:forEach>
		</div>
		<!-- recipe_result end -->
		
		<%--21-02-17 14:38 양 레시피 못찾을 시 문구 변경 --%>
		<c:if test="${rcpsNum!=0}">
		
		
		<div class="recipe_filter">
			<input type="radio" id="recent" class="radio" name="choice"	checked="checked" />
			<label for="recent" class="filter_lbl"> 최신순 </label>
			<input type="radio" id="view" class="radio" name="choice" />
			<label for="view" class="filter_lbl"> 조회순 </label>
			 <input type="radio" id="scrap" class="radio" name="choice" />
			 <label for="scrap" class="filter_lbl"> 스크랩순 </label>
		</div><!-- recipe_filter end -->
		
		<h3 class="rcps_num">
			${rcpsNum}개의 레시피를 찾았습니다.</h3>
		</c:if>
		<div class="recipe_list">
			<div class="recipe_box_wrap">
			<c:if test="${rcpsNum==0}">
				<div class="no_recipe">
					<img src="/img/notFoundDog.png" alt="찾는 레시피가 없습니다."/>
					<h3>찾는 레시피가 없습니다.</h3>
				</div><%--no_recipe end --%>
			</c:if>
				<%--ajax 처리함 --%>
			</div><!--recipe_box_wrap end  -->		
		</div><!--recipe_list end  -->
		<!-- recipe_list end -->

		<div id="goTop">
			<button type="button" onclick="goTop()" id="topBtn">
				<i class="fas fa-chevron-up"></i>
			</button>
		</div>

		<div id="moreList">
			<button class="more_btn">더보기</button>
		</div>
		<!-- more_list end -->

	</div>
	<!-- recipe end -->
	

	
	

	<c:import url="/WEB-INF/view/template/footer.jsp"/>
	<script src="js/jquery.js"></script>
	<script>

	//210131 양 더보기 버튼 클릭시 ajax로 목록 불러오기
	const $more_btn=$(".more_btn");
	
	const $recipe_list=$(".recipe_list"); 
	const $recipe_box_wrap=$(".recipe_box_wrap"); 
	
	//ajax 처리를 위한 page 변수 선언
	let page=1;
	
	//21-02-09 07:46 양 필터의 값을 얻어오기 위한 choice 선언
	let choice="recent";

	//21-02-13 17:02 양 검색어 값을 얻어오기 위한 keyword 선언
	let keyword=null;
	
	//21-02-09 10:58 양 숫자변환 함수 선언
	function numFormat(num){
		if(num<1000){
			return num;
		}else if(num>1000){
			return (num/1000).toFixed(1)+"k";
		}else if(num>1000000){
			return (num/1000000).toFixed(1)+"m";
		}else if(num/1000000000){
			return (num/1000000000).toFixed(1)+"g";
		}
	}//numFormat() end	
	
	
	
	function getRecipies() {
		//21-02-09 07:47 양 선택한 필터의 값 받아오기		
		
		choice = $('input:checked[name="choice"]').attr('id');		
		
		<c:if test="${keyword!='null'}">
		 keyword="${keyword}";
		</c:if>
		
		$.ajax({
			url:"/ajax/recipelist",//주소
			type:"get",//방식
			data:{"page":page, "choice":choice, "keyword":keyword},//파라미터
			dataType:"json",//응답의 자료형
			error:function(xhr,error){
				alert("서버 점검중!");
				console.log(error);
			},
			success:function(json){
				page+=1;
				
				console.log(json);
				
				$(json.recipes).each(function() {			
							
				let html="";
				html+='<div class="recipe_box">';
					html+='<a class="recipe_box_link" href="/recipe/'+this.no+'">';
					html+='<img class="recipe_img" src="/img/recipeImg/'+this.img+'" />';
					<%--방현수 수정 구역--%>
					html+='<div class="recipe_title_wrap">';
						html+='<div class="title_area">';
							html+='<p class="subtitle">';
							if(this.price!=0){
								html+=this.price.toLocaleString('ko-KR')+'p로 만드는';
								}<%--if end--%>	
							html+='</p><h3 class="title">'+this.title+'</h3>';
						html+='</div>';//title area end
						html+='<div class="rate_area">';
						html+='<img src="/img/golden_egg.png"/>';
						html+='<span class="rate_point">'+this.rcpsAvg+'%</span>';
						html+='</div>';//rate_area end
					html+='</div>'; //recipe_title_wrap end
					html+='</a>';
					html+='<div class="profile_wrap">';
						html+='<div class="profile_area">';
					html+='<a href="/mypageHeader.jsp?no='+this.memberNo+'">';
							html+='<img src="/img/profileImg/'+this.profileImg+'" class="profile_img"/>'; 
							html+='<span class="profile_name">'+this.nickname+'</span>';
						html+='</a>';
						html+='</div>';//prifile_area end
						html+='<div class="view_area">'
							html+='<i class="fas fa-eye"></i><div>'+numFormat(this.viewCount)+'</div>';
						html+='</div>'//view_area end
						html+='<div class="scrap_area">'
							html+='<i class="fas fa-bookmark"></i><div>'+numFormat(this.scrapCount)+'</div>';							
						html+='</div>';//scrap_area end
					html+='</div>';//profile end
					<%-- 검색 키워드 존재 시 레시피 밑에 키워드 보여줌 --%>
					html+='<div class="search_result">';
						<c:forEach var="word" items="${keywordSet}">
						if(this.title.includes('${word}')){								
								html+='<span class="recipe_keyword">${word}</span>';
						}<%--if end --%>							
						</c:forEach>
					html+='</div>';<!-- search_result end -->
					
					html+='<div class="ribbon_wrap">';
					
					html+='<div class="easy ribbon">';
					if(this.itemCount<4){
						html+='<img src="img/ribbon4Easy3.png">';						
					}else if(this.itemCount<6){
						html+='<img src="img/ribbon5Easy2.png">';						
					}else if(this.itemCount<8){
						html+='<img src="img/ribbon6Easy1.png">';						
					}
                    html+='</div>';
                        
                    html+='<div class="cheap ribbon">';
                    if(this.price==0){                    
					}else if(this.price<6900){   
                        html+='<img src="img/ribbon1Cheap3.png">';
                    }else if(this.price<9900){
                    	html+='<img src="img/ribbon2Cheap2.png">';
                    }else if(this.price<12900){
                    	html+='<img src="img/ribbon3Cheap1.png">';
                    }                    
                	html+='</div>'<!--ribbon_wrap end-->
				html+='</div>';//recipe_box end
				
				$recipe_box_wrap.append(html);
				
				})//each() end
				//json길이가 12 보다 작으면 더보기 버튼 숨기기
				if(json.recipes.length<12){
					$("#moreList").addClass("hidden");
				}//if end			
				
			}
		});//ajax end

	}//getRecipes() end
	
	//레시피 실행
	getRecipies();
	
	
	//더보기 버튼 클릭시 레시피 목록 불러오기
	$more_btn.on("click",function(){
		getRecipies();	
	})

	//21-02-09 06:24 양 레시피 텝 변화시 값 출력
	$('input[name="choice"]').change(function(){
		//페이지 초기화
		page=1;
		//목록 비우기
		$recipe_box_wrap.empty();
		
		//더보기 버튼 보여주기
		$("#moreList").removeClass("hidden");
		
		//레시피 불러오기
		getRecipies();
	});
	
    
    // $(".clx").on("click", function (e) {
    //     e.preventDefault();
    //
    //     $(".show").removeClass("show");
    //
    //     $(this).next().addClass(".show");
    //
    //     const idx = this.dataset.index;
    //
    //     const txt = $(this).text();
    //
    //     $(".active-tab").css("left",65*idx).text(txt);
    // })
 

    //스크롤업 버튼누르면 올라가게 하는 기능
    function goTop() {
        $('html, body').scrollTop(0);
    //    0.1처 속도 올라가게 애니메이션 넣기
     // $('html').animate( { scrollTop : 0 }, 100 )
    }


</script>

</body>
</html>