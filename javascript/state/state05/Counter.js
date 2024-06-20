import { Component } from "react";

class Counter extends Component {
    // 생성자 함수 -> 초기화를 담당
    constructor(props) {
        // props가 존재하는 경우, 부모 컴포넌트의 생성자를 호출
        super(props);

        // 상태변수를 정의
        this.state = {
            number: 0   // 상태변수이름 : 상태변수초기값
        };
    }

    render() {
        // 상태 변수가 하나 또는 개수가 적다면 아래와 같이 직접 선언
        // const number = this.state.number;
        
        // 일반적으로 객체 비구조화를 이용해서 상태변수의 값을 분해해서 지역변수로 할당
        const { number } = this.state;
        return (
            <>
                {/* 상태변수의 값을 출력 */}
                <h1>{number}</h1>

                {/* 버튼을 하나 추가해서 해당 버튼을 클릭할 때 마다 상태변수의 값을 하나씩 증가 */}
                <button onClick={() => {
                    console.log("Before:", number);
                    this.setState({ number: number + 1 });
                    console.log("After:", number);
                }}>하나 증가</button>
            </>
        );
    }
}
export default Counter;
