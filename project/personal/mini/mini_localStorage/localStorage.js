// 브라우저 로컬 데이터에 저장하기

// 주요 메서드
// 값 저장하기 -> localStorage.setItem(key, value);
// 값 가져오기 -> localStorage.getItem(key);
// 값 삭제하기 -> localStorage.removeItem(key);
// 키(key)를 그대로 놓고 새로운 값을 저장하면 덮어쓰기가 되면서 기존 로컬 데이터 정보가 수정


window.onload = () => {

    /* Set Data 버튼 */
    const btnSetLocalData = document.querySelector('.btnSetLocalData');
    // console.log(btnSetLocalData);

    /* input 텍스트 값 */
    const input = document.querySelector('input');

    /* Set Data 버튼 클릭 시 */
    btnSetLocalData.addEventListener('click', () => {
        /* 입력한 텍스트 값 가져오기 */
        const inputValue = input.value;
        // console.log(inputValue);

        /* localStorage 저장하기 */
        /** F12 -> Application -> Storage -> Local Storage 에서 확인 **/
        localStorage.setItem('userId', inputValue);
        input.value="";
    });

    /* Get Data 버튼 */
    const btnGetLocalData = document.querySelector('.btnGetLocalData');
    // console.log(btnGetLocalData);

    /* Get Data 버튼 클릭 시 */
    btnGetLocalData.addEventListener('click', () => {
        /* 해당 키의 로컬 데이터가 있으면 가져오기 */
        const getData = localStorage.getItem('userId');

        if(!getData) alert("해당 키로 저장된 로컬 데이터가 없습니다.");
        else input.value = getData; // input 텍스트 박스에 삽입
    });

    /* Remove 버튼 */
    const btnRemoveLocalData = document.querySelector('.btnRemoveLocalData');
    /* Remove 버튼 클릭 시 */
    btnRemoveLocalData.addEventListener('click', () => {
        /* 해당 키의 로컬 데이터 삭제하기 */
        localStorage.removeItem('userId');
        // alert("삭제되었습니다.");
    });



    /* localStorage Data All View  버튼 */
    const btnAllView = document.querySelector('.btnAllView');
    // console.log(btnAllView);

    /* localStorage Data All View  버튼 클릭 시 */
    btnAllView.addEventListener('click', () => {
        /* localStorage 데이터 값 가져와서 출력 */
        const getData = localStorage.getItem('background-color');
        // console.log(getData);

        /* 배열 정보를 동적으로 테이블 생성하여 삽입하기 */
        // let arr = new Array();
        // let result = "";

        // arr.push({name: "홍길동", email: "hong@example.com", age: 25, pastime: "음악감상"});
        // arr.push({name: "이순신", email: "lee@example.com", age: 33, pastime: "산책"});
        // arr.push({name: "강감찬", email: "kang@example.com", age: 44, pastime: "영화감상"});
        // arr.push({name: "김유신", email: "kim@example.com", age: 55, pastime: "야식먹기"});
        // arr.push({name: "심청이", email: "shim@example.com", age: 66, pastime: "독서"});

        // console.log(arr[0].name);
        // console.log(arr[0].email);
        // console.log(arr[0].age);
        // console.log(arr[0].pastime);

        /* 반복문 순회하면서 배열 정보 result 변수에 누적 */
        // for(const i in arr) {
            // console.log(i);
            // result += "<tr>";
            // result += "<td>" + arr[i].name + "</td>";
            // result += "<td>" + arr[i].email + "</td>";
            // result += "<td>" + arr[i].age + "</td>";
            // result += "<td>" + arr[i].pastime + "</td>";
            // result += "</tr>";
        // }
        // console.log(result);

        // let htmlTbody = document.getElementById('html-tbody');
        // console.log(htmlTbody);

        /* Append */
        // $('#html-tbody').empty();
        // $('#html-tbody').append(result);

        /* Append-JS */
        // htmlTbody.append(result);       // 텍스트 문자열 형태로 append
        // htmlTbody.appendChild(result);  // node err
        // htmlTbody.innerText(result);    // 괄호가 x
        // htmlTbody.innerText = result;
        // htmlTbody.innerHTML = result;

        /* Key만 출력 */
        // console.log(localStorage.key(0));   // userId
        // console.log(localStorage.key(1));   // color
        // console.log(localStorage.key(2));   // fontWeight
        // console.log(localStorage.key(3));   // userName
        // console.log(localStorage.key(4));   // backgroundColor

        /* Key 개수 */
        // console.log(localStorage.length);

        /* 결과 변수 -> 반복문 쓰지 않고 하나만 출력 */
        // let result = "";
        // result += "<tr>";
        // result += "<td class='align-middle' width='30%'>" + localStorage.key(2) + "</td>";
        // result += "<td class='align-middle' width='30%'>" + localStorage.getItem(localStorage.key(2)) + "</td>";
        // result += "<td><button class='btnRemove'>Remove</button></td>";
        // result += "</tr>";
        // console.log(result);

        // let htmlTbody = document.getElementById('html-tbody');
        // htmlTbody.innerHTML = result;

        /* Key 순회하면서 key: value 값 출력하기 */
        // console.log("로컬 스토리지 길이: " + localStorage.length);
        let arr = new Array();
        let result = "";

        for(let i = 0; i < localStorage.length; i++) {
            let key = localStorage.key(i);
            // console.log(`${key}: ${localStorage.getItem(key)}`);

            /* 결과 변수 */
            result += "<tr>";
            result += "<td class='align-middle' width='30%'>" + key + "</td>";
            result += "<td class='align-middle'>" + localStorage.getItem(key) + "</td>";
            result += "<td><button class='btnRemove'>Remove</button></td>";
            result += "</tr>";

            /* 배열에 저장 */
            arr.push(result);
        }
        // console.log(arr);

        /* append 붙이기 */
        $('#html-tbody').empty();
        $('#html-tbody').append(result);
    });


    /* 테이블의 열과 줄을 동적으로 생성하여 삽입하기 */
    /* 버튼 가져오기 */
    const btnCreate = document.querySelector('.btnCreate');
    // console.log(btnCreate);

    /* Create row and column 클릭 시 */
    btnCreate.addEventListener('click', () => {
        let htmlTbody = document.getElementById('html-tbody-create');
        // console.log(htmlTbody);

        /* JavaScript Table row and column */

        /* Insert a row at the end of table */
        const newRow = htmlTbody.insertRow();

        /* Insert a cell at the end of the row */
        const newCell0 = newRow.insertCell();
        const newCell1 = newRow.insertCell();
        const newCell2 = newRow.insertCell();
        const newCell3 = newRow.insertCell();

        /* Append - 텍스트 노드를 새롭게 생성한 Cell에 붙이기 */
        const newText0 = document.createTextNode('홍길동');
        newCell0.appendChild(newText0);
        
        const newText1 = document.createTextNode('hong@example.com');
        newCell1.appendChild(newText1);
        
        const newText2 = document.createTextNode('22');
        newCell2.appendChild(newText2);
        
        const newText3 = document.createTextNode('영화보기');
        newCell3.appendChild(newText3);

        /* 테이블 Row 구하기 */
        const myTable = document.getElementById('myTable');
        // console.log(myTable.rows.length - 1);   // thead가 있으므로 보통 순수 tbody쪽의 row만 알기 위해 -1
        // console.log(myTable.rows[0]);           // thead
        // console.log(myTable.rows[1]);           // tbody의 first row

        /* Cell 개수 구하기 */
        const cntRow = myTable.rows.length - 1;
        const cntCell = myTable.rows[cntRow].cells.length;  // 해당 row의 cell의 개수
        console.log(cntCell);
        console.log("테이블 row 수: " + cntRow);

        /* 반복문 순회하면서 각 Cell의 정보값 setting */
        for(let i = 0; i < cntCell; i++) {
            htmlTbody.rows[cntRow - 1].cells[i].innerHTML = `Data [${cntRow - 1}][${i}]`;
        }
    });

}