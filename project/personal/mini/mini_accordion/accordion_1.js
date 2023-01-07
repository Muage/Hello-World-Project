window.onload = () => {

    // FAQ container (panel-faq-container)
    const panelFaqContainer = document.querySelectorAll('.panel-faq-container');
    // console.log(panelFaqContainer); // NodeList 객체로서 가져온다.

    // FAQ answer (panel-faq-answer)
    let panelFaqAnswer = document.querySelectorAll('.panel-faq-answer');
    // console.log(panelFaqAnswer);

    // FAQ All Close (btn-all-close)
    const btnAllClose = document.getElementById('btn-all-close');
    // console.log(btnAllClose);

    // 반복문 순회하면서 해당 FAQ 제목 클릭 시 콜백 처리
    for(let i = 0; i < panelFaqContainer.length; i++) {
        panelFaqContainer[i].addEventListener('click', function() {
            // FAQ title 클릭 시 처리
            // console.log(`${i} 클릭됨`);
            // console.log(panelFaqAnswer[i].classList.length);

            // this.classList.add('active');    // this -> panelFaqContainer

            // FAQ title 클릭 시
            // active 클래스가 있으면 answer 닫기
            if(panelFaqAnswer[i].classList.length == 2) {
                panelFaqAnswer[i].classList.remove('active');
            } else {    // active 클래스가 없으면 answer 열기 active 클래스 추가
                panelFaqAnswer[i].classList.add('active');
            }
        });
    }

    btnAllClose.addEventListener('click', function() {
        console.log('모두 닫기 버튼 클릭');

        // FAQ All Close 버튼 클릭 시 처리
        for(let i = 0; i < panelFaqAnswer.length; i++) {
            panelFaqAnswer[i].classList.remove('active');
        }
    })

}