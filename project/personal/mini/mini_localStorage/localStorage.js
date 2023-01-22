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

}