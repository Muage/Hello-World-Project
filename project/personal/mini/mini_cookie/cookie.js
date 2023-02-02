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