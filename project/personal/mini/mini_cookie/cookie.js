/** 방법 1 */

// /* 자바스크립트로 쿠키(Cookie) 읽기, 생성하기, 삭제하기 */
// /* 기본적인 방법 -> document.cookie = "name=?; name2=?; expires=?; path=?"; */

// /* 쿠키 읽기 */
// function getCookie() {
//     /* 로컬에 저장된 쿠키 뿌려주기 */
//     const allCookies = document.cookie; // 하나의 문자열로 리턴 -> cookie1=value; cookie2=value; cookie3=value;
//     console.log(typeof allCookies);     // string

//     /* if 조건문 -> 쿠키가 있으면 */
//     if(allCookies != "")
//         alert("저장된 쿠키의 값: " + allCookies);
//     else
//         alert("저장된 쿠키가 없습니다.");
// }

// /* 쿠키 생성하기 */
// function setCookie() {
//     // /* 기본적인 날짜 출력 -> 날짜 쓸 일? : 만료일 -> expiration, expire */
//     // let nowDate = new Date();
//     // console.log(nowDate);
    
//     // /* 만료일 생성 */
//     // let expiration = nowDate.getDate() + 10;
//     // console.log(expiration);

//     /* 현재 날짜 기준으로 만료일 생성 */
//     let expiration = new Date();
//     expiration.setDate(expiration.getDate() + 10);
//     console.log(expiration);

//     /* 날짜를 쿠키로 저장하기 위해 UTC 방식으로 표시 -> toUTCString() 사용 */
//     console.log(expiration.toUTCString());

//     /* 쿠키 생성하기 */
//     let cookies = "";
//     cookies = "userid=superman; expires=" + expiration.toUTCString();
//     console.log(cookies);

//     /* 쿠키 저장하기 */
//     document.cookie = cookies;
//     alert("쿠키를 생성하였습니다.");
// }

// /* 쿠키 삭제하기 */
// function delCookie() {
//     /* document.cookie에 값을 대입하는 형태로 쿠키 삭제 */
//     // document.cookie = 'username=honggildong';                               // 쿠키 생성
//     // document.cookie = 'username=lessonsin';                                 // 쿠키 수정
//     // document.cookie = 'username=; expires=Sat, 01 Jan 1972 00:00:00 GMT';   // 쿠키 삭제
//     document.cookie = 'userid=; expires=Sat, 01 Jan 1972 00:00:00 GMT';
//     alert("쿠키를 삭제하였습니다.");
// }

// /** Summary */
// /** 1. JS에서 쿠키를 편리하게 사용하려면 사용자가 직접 함수를 만드는 것 */
// /** 2. 더 편리한 것은 JS 쿠키 관련 경량 라이브러리 사용 */
// /** 3. document.cookie */
// /** 4. 쿠키의 삭제는 한참 지난 날짜를 입력하는 것 */
// /** 5. 일반적으로 Set(생성), Get(읽기), Del(삭제) 사용자 함수를 구현해서 사용함 */



/** 방법 2 */
/* JS 쿠키 사용자 정의 함수 및 전체 삭제 만들기 */
/* 쿠키 읽기 */
const getCookie = function() {

    /* 로컬에 저장된 모든 쿠키 읽어오기 */
    const allCookies = document.cookie; // 하나의 문자열로 리턴
    console.log(allCookies);

    if(allCookies != "")
        alert("저장된 쿠키의 값: " + allCookies);
    else
        alert("저장된 쿠키가 없습니다.");

}

/* 쿠키 생성하기 -> 함수 표현식 */
const setCookie = function(cname, cvalue, cexpire) {

    event.preventDefault(); // submit, href 발생 시 이동 및 새로고침 방지

    /* 넘어온 값 체크 */
    if(document.getElementById('cname').value != "") {
        cname = document.getElementById('cname').value;
        cvalue = document.getElementById('cvalue').value;
        cexpire = document.getElementById('cexpire').value;
    }
    console.log("cname: " + cname);
    console.log("cvalue: " + cvalue);
    console.log("cexpire: " + cexpire);
    console.log("typeof cexpire: " + typeof cexpire);

    /* 만료일 생성 */
    let expiration = new Date();
    console.log(expiration);
    expiration.setDate(expiration.getDate() + parseInt(cexpire));
    console.log(expiration);

    /* 날짜를 쿠키로 저장하기 위해 UTC 방식으로 표기 */
    console.log(expiration.toUTCString);

    /* 쿠키 생성하기 */
    let cookies = "";
    cookies += `${cname}=${cvalue};`;
    cookies += `expires=${expiration.toUTCString};`;
    console.log(cookies);

    /* 쿠키 저장하기 */
    document.cookie = cookies;
    // document.getElementById('cname').value = "";
    // document.getElementById('cname').focus();
    document.getElementById('form').reset();
    alert("쿠키를 생성하였습니다.");

}

/* 쿠키 삭제하기 */
const delCookie = function(cname) {

    // document.cookie = 'userid=; expires=Sat, 01 Jan 1972 00:00:00 GMT';
    console.log(cname);
    setCookie(cname, "", 0);
    alert("쿠키를 삭제하였습니다.");

}

/* 쿠키 전체삭제 */
const allDelCookies = function(domain, path) {

    // const doc = document;
    domain = domain || document.domain,
    path = path || '/';

    const cookies = document.cookie.split("; ");
    // console.log(cookies);
    // console.log(typeof cookies);

    const expiration = "Sat, 01 Jan 1972 00:00:00 GMT";
    // console.log(expiration);

    /* 반복문 순회하면서 쿠키 전체 삭제 */
    // for(let i = 0; i < cookies.length; i++) {
    for(let i = cookies.length - 1; i >= 0; i--) {
        // console.log(cookies[i].split("=")[0]);
        document.cookie = cookies[i].split("=")[0] + "=; expires=" + expiration;
        // document.cookie = cookies[i].split("=")[0] + "=; expires=" + expiration + "; domain=" + domain + "; path=" + path;
    }

    alert("쿠키를 모두 삭제하였습니다.");

}

/* addEventListener */
const form = document.getElementById('form');
form.addEventListener('submit', setCookie);