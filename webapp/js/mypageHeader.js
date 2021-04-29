/** 마이페이지 헤더에서만 작동하는 자바스크립트 구문입니다 (정보수정, 포인트 적립 내역 등) */

//선언
    const $receipt_tab=$(".receipt_tab");
    const $market_tab=$(".market_tab");
    const $review_tab=$(".review_tab");
    const $question_tab=$(".question_tab");
    const $tab_under_bar=$(".tab_under_bar")
    const $mypageReceipt=$("#mypageReceipt");
    const $mypageReview=$("#mypageReview");
    const $mypageMarket=$("#mypageMarket");
    const $mypageQuestion=$("#mypageQuestion");
    const $mypageContent=$("#mypageContent");


    //마이페이지 탭 선택시 아래 막대 이동 함수
    function underbar(x){
        $tab_under_bar.css("left",x+"px");
    }

   /* //레시피 선택 시
    $receipt_tab.on("click",function (){
        $mypageContent.children().addClass("hidden");
        $mypageMarket.removeClass("hidden");
        underbar(72);
    })

    //장터 선택시
    $market_tab.on("click",function (){
        $mypageContent.children().addClass("hidden");
        $mypageReceipt.removeClass("hidden");
        underbar(322);
    })

    //요리 후기 선택시
    $review_tab.on("click",function (){
        $mypageContent.children().addClass("hidden");
        $mypageReview.removeClass("hidden");
        underbar(572);
    })

    //문의하기 선택 시
    $question_tab.on("click",function (){
        $mypageContent.children().addClass("hidden");
        $mypageQuestion.removeClass("hidden");
        underbar(822);
    })*/


    /*--■■■■■■■■■■■■■■■■■■■■■■■■■■■닉네임 변경■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■--*/

    //선언
    const $nickname=$("#nickname");
    const $nickname_regex=$(".nickname_regex");
    const $nickname_box=$(".nickname_box");
    const $user_nickname=$(".user_nickname");
    const $mypage_user_nickname=$("#mypage .user_nickname");

    //유효성 판별을 위한 변수 선언
    let nicknameBoolean = false;

    //유효성 에러시 메세지 출력 함수
    function wrong(){
        $nickname_regex.html("한글,영어,숫자 7글자까지 가능합니다.")
        $nickname_regex.css("color","red");
    }

    //닉네임 클릭시 input창 보여주기
    $mypage_user_nickname.on("click",function(){

        $nickname_box.removeClass("hidden");

        //input에 포커스를 맞추고 값을 현재 유저이름으로 변경
        $nickname.val($user_nickname.text());

        //◆◆◆◆◆◆◆◆◆◆ⓦⓗⓨ??? 어차피 유저 닉네임은 서버에서 가져올 것이지만 두번 출력되는 이유를 모르겠음!◆◆◆◆◆◆◆◆◆◆
        //alert($user_nickname.text());
        $nickname.focus();
    })


    //input focus 벗어날 시 현재 값을 지우고 숨기기
    $nickname.blur(function (){
        $(this).val('');
        $nickname_box.addClass("hidden");
    });

    //닉네임 변경
    $nickname.on("keyup",function(e){

        //새로운 닉네임 입력 시 한글,숫자,영어만 입력 가능
        const regex = /^[가-힣|\w]*$/
        const result = regex.exec($(this).val());

        //닉네임 유효성 검사
        if(result != null){
            $nickname_regex.html("멋진 닉네임이네요.");
            $nickname_regex.css("color","#1c00db");

            nicknameBoolean=true;

            //글자수 7글자 초과시 메세지 출력
            if(($(this).val().length)>7||($(this).val().length===0)){
                wrong();
                nicknameBoolean=false;
            }

        //한글,숫자,영어가 아니면 메세지 출력
        }else{
            wrong();
            nicknameBoolean=false;
        } //if-else end


        //엔터를 쳤을 떄 모든 유효성 검사 만족시 값 변경
        if (e.keyCode === 13&&nicknameBoolean){
            //alert(nicknameBoolean);

            $user_nickname.text($(this).val());
            $nickname_box.addClass("hidden");
        }

    }) //$nickName keyup() end

    /*--■■■■■■■■■■■■■■■■■■■■■■■■---닉네임 변경 end---■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■--*/

    /*--■■■■■■■■■■■■■■■■■■■■■■■■■■■■---각종 안내---■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■--*/

    //선언
    const $user_info_grade_img=$(" .user_info .grade_img");
    const $grade_info_box=$(".grade_info_box");
    const $layerWrap=$("#layerWrap");
    const $cumulative_point=$(".cumulative_point");
    const $point=$(".point");
    const $point_history_box=$(".point_history_box");
    const $service_idx_wrap_service_idx=$(".service_idx_wrap .service_idx");
    const $service_idx_box=$(".service_idx_box");




    //창 열기 함수 선언
    function openBox(click_name, box_name){
        click_name.on("click",function(){
            box_name.removeClass("hidden");
            $layerWrap.removeClass("hidden");
        })
    }

    //닉네임 뒤 등급 이미지 클릭시 등급 설명 보여주기
    openBox($user_info_grade_img,$grade_info_box);

    //누적 포인트 클릭시 등급 설명 보여주기
    openBox($cumulative_point,$grade_info_box);

    //포인트 클릭시 포인트 내역 창 보여주기
    openBox($point,$point_history_box);



    //창 닫기를 위한 선언
   const $close_btn=$(".close_btn");
   const $box=$(".box");

    //창 닫기 함수 선언
    function closeBox(){
        $box.addClass("hidden");
        $layerWrap.addClass("hidden");
    }


    //주변 검은 부분 눌렀을 시 창 닫기
    $layerWrap.on("click",function (){
        closeBox();
    })

    //닫기 버튼 눌렀을 시 창 닫기
    $close_btn.on("click",function (){
        closeBox();
    })


    const $point_accumulation_tab= $(".point_accumulation_tab");
    const $point_use_tab=$(".point_use_tab");
    const $point_history_accumulation=$(".point_history_accumulation");
    const $point_history_use=$(".point_history_use");

    //포인트 내역 박스에서 적립 내역 선택시
    $point_accumulation_tab.on("click",function ( ) {

        $point_history_accumulation.removeClass("hidden");
        $point_history_use.addClass("hidden");

    });

    //포인트 내역 박스에서 사용 내역 선택시
    $point_use_tab.on("click",function ( ) {

        $point_history_use.removeClass("hidden");
        $point_history_accumulation.addClass("hidden");

    });


    //프로필 사진 등록 미리보기 함수 선언 (실제로는 서버에 바로 업로드해서 보여줌)
    function previewImage(f){

        let file = f.files;

        // 확장자 체크
        if(!/\.(gif|jpg|jpeg|png)$/i.test(file[0].name)){
            alert('gif, jpg, png 파일만 선택해 주세요.\n\n현재 파일 : ' + file[0].name);

            // 선택한 파일 초기화
            f.outerHTML = f.outerHTML;

            document.getElementById('profile').innerHTML = '';

        }
        else {

            // FileReader 객체 사용
            let reader = new FileReader();

            // 파일 읽기가 완료되었을때 실행
            reader.onload = function(rst){
                $("#profileImage").attr("src",rst.target.result);
            }

            // 파일을 읽는다
            reader.readAsDataURL(file[0]);

        }
    }

    const $mypage_profile_wrap=$("#mypage .profile_wrap");
    const $profile_wrap_close_btn=$(".profile_wrap .close_btn");
    const $profileImage=$("#profileImage");

    //마우스를 프로필 이미지에 hover시 x버튼 보여주기

        $mypage_profile_wrap.hover(
            function () {
                if ($profileImage.attr("src") !== "img/profile_img_default.jpg") {
                $profile_wrap_close_btn.removeClass("hidden")
                }
            }, function () {
                $profile_wrap_close_btn.addClass("hidden")
            }
        )


    //x버튼 누르면 기본 이미지로 변경하기
    $profile_wrap_close_btn.on("click",function (){
        $profileImage.attr("src","img/profile_img_default.jpg");
        $profile_wrap_close_btn.addClass("hidden");
    });







    const $service_idx=$(".service_idx");


    //서비스 지수 그래프 계산 함수
    function starGraph(keyframes, options){

        //선언, 가장 많은 평가의 길이는 170px로 고정하고, 나머지 값은 최대값과 비교한 %에 따라 그래프의 길이가 변화함
        const max_width = 170;
        let lv=[];
        let countNum=0;


        //각 평점 배열에 저장하기
        for(let i=0;i<5;i++){
            lv[i]=parseInt($(".star_idx_lv"+(i+1)+' .star_idx_num').text());
            countNum+=lv[i];
        }

        //배열 중 가장 많은 평가 값 가져오기
        const max_num=Math.max.apply(null, lv);
        let star_rate_sum=0;


        //각 평점당 평가 숫자에 따른 그래프 길이 계산하기
        for(let j=1;j<6;j++){
            let width=max_width*(lv[(j-1)]/max_num);
            $('.star_idx_lv' + j + ' .star_graph').width(width);

            //각 평점 * 평가수 의 합 계산하기
            star_rate_sum+=j*lv[j-1];
        }


        //소수점 1자리수까지 평점 계산
        $service_idx.text((star_rate_sum/countNum).toFixed(1));

    }

    //서비스 지수 함수 호출, 서버에 값 저장시 바로 받아와서 보여줌
    starGraph();

    //서비스 지수 클릭시 서비스 지수 창 보여주기
    $service_idx_wrap_service_idx.on("click",function(){
        $service_idx_box.removeClass("hidden");
        $layerWrap.removeClass("hidden");
        starGraph();
    })





    //--■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■지도■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■--//
    //본 예제에서는 도로명 주소 표기 방식에 대한 법령에 따라, 내려오는 데이터를 조합하여 올바른 주소를 구성하는 방법을 설명합니다.

    //선언
    $roadAddress=$("#roadAddress");

    function sample4_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                let roadAddr = data.roadAddress; // 도로명 주소 변수
                let extraRoadAddr = ''; // 참고 항목 변수

                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraRoadAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                    extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraRoadAddr !== ''){
                    extraRoadAddr = ' (' + extraRoadAddr + ')';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.


                $roadAddress.text(roadAddr);
            }
        }).open();
    }//sample4_execDaumPostcode() end
