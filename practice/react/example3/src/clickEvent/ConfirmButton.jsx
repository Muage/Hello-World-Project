// import React, { Component } from 'react';
import React from 'react';
import { useState } from 'react';

// 1. bind 코드 사용
// class ConfirmButton extends Component {

//     constructor(props) {
//         super(props);
//         this.state = {
//             isConfirmed: false
//         };

//         this.handleConfirm = this.handleConfirm.bind(this);
//     }

//     handleConfirm() {
//         this.setState(prevState => ({
//             isConfirmed: !prevState.isConfirmed
//         }));
//     }

//     render() {
//         return (
//             <button
//                     onClick={this.handleConfirm}
//                     disabled={this.state.isConfirmed}>
//                 {this.state.isConfirmed ? "확인됨" : "확인하기"}
//             </button>
//         );
//     }

// }


// 2. Class fields syntax 사용
// class ConfirmButton extends Component {

//     constructor(props) {
//         super(props);
//         this.state = {
//             isConfirmed: false
//         };
//     }
    
//     // Arrow Function으로 변경
//     handleConfirm = () => {
//         this.setState(prevState => ({
//             isConfirmed: !prevState.isConfirmed
//         }));
//     }

//     render() {
//         return (
//             <button
//                     onClick={this.handleConfirm}
//                     disabled={this.state.isConfirmed}>
//                 {this.state.isConfirmed ? "확인됨" : "확인하기"}
//             </button>
//         );
//     }

// }


// 3. 컨펌받은 컴포넌트를 함수 컴포넌트로 바꿔보기
function ConfirmButton(props) {

    const [isConfirmed, setIsConfirmed] = useState(false);

    const handleConfirm = () => {
        setIsConfirmed(prevIsConfirmed => !prevIsConfirmed);
    };

    return (
        <button
                onClick={handleConfirm}
                disabled={isConfirmed}>
            {isConfirmed ? "확인됨" : "확인하기"}
        </button>
    )

}

export default ConfirmButton;