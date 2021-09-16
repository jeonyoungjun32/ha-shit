<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- viewport-->
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- CSS -->
<link rel="stylesheet" type="text/css" href="/baskinrobbins/css/style.css"/>
<link rel="stylesheet" type="text/css" href="https://unpkg.com/aos@2.3.1/dist/aos.css" />
<!-- js -->
<script type="text/javascript" src="js/jquery-3.6.0.min.js"></script>
<!-- <script type="text/javascript" src="js/index.js" ></script> -->
<script type="text/javascript" src="https://unpkg.com/aos@2.3.1/dist/aos.js"></script>
<script>
$(function () {
	AOS.init();
});
    
$(function () {
    var $header = $('header');
    var $headerBtn = $('.header_btn');

    $headerBtn.on('click',function(){
        $header.toggleClass('open');
        if($header.hasClass('open')) {
            $header.animate({top : -170},300);
            $headerBtn.attr({
                src : 'img/menu_line.png',
                alt : '헤더 닫기 버튼'
            })
        } else {
            $header.animate({top : 0},300);
            $headerBtn.attr({
                src : 'img/close_line.png',
                alt : '헤더 열기 버튼'
            });
        };
    });
});

$(function () {
    var $aside = $('aside');
    var $asideBtn = $aside.find('button');
    $asideBtn.on('click', function () {
        $aside.toggleClass('open');
        if ($aside.hasClass('open')) {
            $aside.animate({ right: 0}, 300);
            $asideBtn.find('img').attr({
                src : 'img/btn_close.png',
                alt : '사이드바 닫기 버튼'
            })
        } else {
            $aside.animate({ right: "-250px"}, 300);
            $asideBtn.find('img').attr({
                src : 'img/btn_open.png',
                alt : '사이드바 열기 버튼'
            });
        };
    });
});

$(function () {
    var $article = $('.article'),
        $slideGroup = $article.find('.img_box'),
        $slides = $slideGroup.find('.slide'),
        $nav = $article.find('.button_box'),
        $indicator = $article.find('.bottom_button'),
        $slideCount = $slides.length,
        $curIndex = 0,
        $indicatorHTML ='',
        $timer;
    
    // 각 슬라이드의 위치 설정
    // 해당 인디게이터의 앵커를 설정
    $slides.each(function (i) {
        $(this).css({ left: 100 * i + '%' });
        $indicatorHTML += '<a href="#">' + (i + 1) + '</a>';
        console.log($indicatorHTML); //console 테스트
    });
    $indicator.html($indicatorHTML);
    
    //슬라이드 이동 함수(모든 슬라이드 표시)
    function goToSlide(index) {
        $slideGroup.animate({ left: -100 * index + '%' }, 500);
        $curIndex = index;
    }
    
    // 타이머를 시작하는 함수, 자동 슬라이드
    function startTimer() {
        $timer = setInterval(function () {
            //cur 0, next1 / ...cur3, next0
            var $nextIndex = ($curIndex + 1) % $slideCount;
            goToSlide($nextIndex);
        }, 5000);
    }
    
    // 타이머를 중지하는 함수
    function stopTimer() {
        clearInterval($timer);
    }

    //마우스 오버시 타이머 함수 정지, 그렇지 않으면 시작
    $slideGroup.on({
        mouseenter: stopTimer,
        mouseleave: startTimer
    })

    //인디게이터의 링크를 클릭하면 해당 슬라이드 표시
    $indicator.find('a').on('click', function (e) {
        e.preventDefault();
        if (!$(this).hasClass('active')) {
            goToSlide($(this).index());
        }
    });
    //첫번째 슬라이드 표시
    goToSlide($curIndex);

    //자동슬라이드
    startTimer(); 
});
</script>
<title>베스킨 라빈스</title>	
</head>
<body id="top"><!--스크롤 테스트 중-->
    <!-- header 구간-->
    <div class="header_btn_box">
        <img src="img/close_line.png" class="header_btn">
    </div>
    <header class="header" id="header">
        <div class="header_top">
            <nav class="scroll_box">
                <ul>
                    <li><a href="#top" class="top">top</a></il>
                    <li><a href="#section" class="section">section</a></il>
                    <li><a href="#footer" class="footer">footer</a></il>
                </ul>
            </nav>
            <a href="index.html"><img src="img/logoimg.png" alt="logo_img" class="logo_img"></a>
            <div class="text_box">
                <div class="search_box">
                    <input type="text" placeholder="검색할 내용을 입력해주세요" size="22">
                    <input type="submit" value="검색">
                </div>
                <div class="login_box">
                    <a href="login/login.jsp">login</a>
                    <a href="#">logout</a>
                </div>
            </div>
        </div>
        <!-- 데스크탑 전용-->
        <nav class="nav">
            <ul>
                <li class="nav_li">
                    <p>FLAVOR OF THE MONTH</p>
                    <ul>
                        <li><a href="#">test</a></li>
                    </ul>
                </li>
                <li class="nav_li">
                    <p>MENU</p>
                    <ul>
                        <li><a href="#">아이스크림</a></li>
                        <li><a href="#">아이스크림케이크</a></li>
                        <li><a href="#">음료</a></li>
                        <li><a href="#">커피</a></li>
                        <li><a href="#">디저트</a></li>
                    </ul>
                </li>
                <li class="nav_li">
                    <p>영양 성분 및 알레르기</p>
                        <ul>
                            <li><a href="#">아이스크림</a></li>
                            <li><a href="#">아이스크림케이크</a></li>
                            <li><a href="#">음료</a></li>
                            <li><a href="#">커피</a></li>
                            <li><a href="#">디저트</a></li>
                        </ul>
                </li>
                <!-- 추후 업데이트 계획 -->
                <!-- <li class="nav_li">
                    <p>EVENT</p>
                    <ul>
                        <li><a href="#">시작 예정 이벤트</a></li>
                        <li><a href="#">진행중인 이벤트</a></li>
                        <li><a href="#">종료된 이벤트</a></li>
                        <li><a href="#">당첨자 발표</a></li>
                    </ul>
                </li> -->
                <li class="nav_li">
                    <p>SOTRE</p>
                    <ul>
                        <!-- 추후 업데이트 계획 -->
                        <!-- <li><a href="#">매장 찾기</a></li> -->
                        <li><a href="#">주문</a></li>
                    </ul>
                </li>
                <li class="nav_li">
                    <p>고객센터</p>
                    <ul>
                        <li><a href="#">공지사항</a></li>
                        <li><a href="#">문의게시판</a></li>
                    </ul>
                </li>
            </ul>
        </nav>
    </header>
    <div class="header_backgound">
        <div class="opacity_bottom"></div>
    </div>
    <!-- 노트 모바일전용 -->
    <aside class="aside">
        <!-- 반응형 메뉴 부를 버튼 만들어야함-->
        <button class="button">
            <img alt="버튼 이미지" src="img/btn_open.png">
        </button>
        <div class="text_box">
            <div class="search_box">
                <input type="text" placeholder="검색할 내용을 입력해주세요" size="22">
                <input type="submit" value="검색">
            </div>
            <div class="login_box">
                <a href="login.html">login</a>
                <a href="logout.html">logout</a>
            </div>
        </div>
        <nav class="nav">
            <ul>
                <li class="nav_li">
                    <p>FLAVOR OF THE MONTH</p>
                    <ul>
                        <li><a href="#">test</a></li>
                        <li><a href="#"></a></li>
                        <li><a href="#"></a></li>
                    </ul>
                </li>
                <li class="nav_li">
                    <p>MENU</p>
                    <ul>
                        <li><a href="#">아이스크림</a></li>
                        <li><a href="#">아이스크림케이크</a></li>
                        <li><a href="#">음료</a></li>
                        <li><a href="#">커피</a></li>
                        <li><a href="#">디저트</a></li>
                    </ul>
                </li>
                <li class="nav_li">
                    <p>영양 성분 및 알레르기</p>
                        <ul>
                            <li><a href="#">아이스크림</a></li>
                            <li><a href="#">아이스크림케이크</a></li>
                            <li><a href="#">음료</a></li>
                        </ul>
                </li>
                <li class="nav_li">
                    <p>EVENT</p>
                    <ul>
                        <li><a href="#">시작 예정 이벤트</a></li>
                        <li><a href="#">진행중인 이벤트</a></li>
                        <li><a href="#">종료된 이벤트</a></li>
                        <li><a href="#">당첨자 발표</a></li>
                    </ul>
                </li>
                <li class="nav_li">
                    <p>SOTRE</p>
                    <ul>
                        <li><a href="#">매장 찾기</a></li>
                        <li><a href="#">주문</a></li>
                    </ul>
                </li>
                <li class="nav_li">
                    <p>ABOUT</p>
                    <ul>
                        <li><a href="#">공지사항</a></li>
                        <li><a href="#">고객센터</a></li>
                    </ul>
                </li>
            </ul>
        </nav>
    </aside>