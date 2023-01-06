window.onload = () => {

    const panelFaqContainer = document.querySelectorAll('.panel-faq-container');
    console.log(panelFaqContainer); // NodeList 객체로서 가져온다.

    // 반복문 순회하면서 해당 FAQ 제목 클릭 시 콜백 처리
    for(let i = 0; i < panelFaqContainer.length; i++) {
        panelFaqContainer[i].addEventListener('click', function() {
            // 클릭 시 처리
            console.log(`${i} 클릭됨`);
        });
    }

}