/* 자바스크립트로 쿠키(Cookie) 읽기, 생성하기, 삭제하기 */
/* 기본적인 방법 -> document.cookie = "name=?; name2=?; expires=?; path=?"; */

/* 쿠키 읽기 */
function getCookie() {
    /* 로컬에 저장된 쿠키 뿌려주기 */
    const allCookies = document.cookie; // 하나의 문자열로 리턴 -> cookie1=value; cookie2=value; cookie3=value;
    console.log(typeof allCookies);     // string

    /* if 조건문 -> 쿠키가 있으면 */
    if(allCookies != "")
        alert("저장된 쿠키의 값: " + allCookies);
    else
        alert("저장된 쿠키가 없습니다.");
}

/* 쿠키 생성하기 */
function setCookie() {
    // /* 기본적인 날짜 출력 -> 날짜 쓸 일? : 만료일 -> expiration, expire */
    // let nowDate = new Date();
    // console.log(nowDate);
    
    // /* 만료일 생성 */
    // let expiration = nowDate.getDate() + 10;
    // console.log(expiration);

    /* 현재 날짜 기준으로 만료일 생성 */
    let expiration = new Date();
    expiration.setDate(expiration.getDate() + 10);
    console.log(expiration);

    /* 날짜를 쿠키로 저장하기 위해 UTC 방식으로 표시 -> toUTCString() 사용 */
    console.log(expiration.toUTCString());

    /* 쿠키 생성하기 */
    let cookies = "";
    cookies = "userid=superman; expires=" + expiration.toUTCString();
    console.log(cookies);

    /* 쿠키 저장하기 */
    document.cookie = cookies;
    alert("쿠키를 생성하였습니다.");
}

/* 쿠키 삭제하기 */
function delCookie() {
    /* document.cookie에 값을 대입하는 형태로 쿠키 삭제 */
    // document.cookie = 'username=honggildong';                               // 쿠키 생성
    // document.cookie = 'username=lessonsin';                                 // 쿠키 수정
    // document.cookie = 'username=; expires=Sat, 01 Jan 1972 00:00:00 GMT';   // 쿠키 삭제
    document.cookie = 'userid=; expires=Sat, 01 Jan 1972 00:00:00 GMT';
    alert("쿠키를 삭제하였습니다.");
}

/** Summary */
/** 1. JS에서 쿠키를 편리하게 사용하려면 사용자가 직접 함수를 만드는 것 */
/** 2. 더 편리한 것은 JS 쿠키 관련 경량 라이브러리 사용 */
/** 3. document.cookie */
/** 4. 쿠키의 삭제는 한참 지난 날짜를 입력하는 것 */
/** 5. 일반적으로 Set(생성), Get(읽기), Del(삭제) 사용자 함수를 구현해서 사용함 */