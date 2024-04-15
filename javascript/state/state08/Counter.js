import { Component } from "react";

class Counter extends Component {
    // constructor(props) {
    //     super(props);

    //     this.state = {
    //         number: 0,
    //         fixedNumber: 10
    //     };
    // }

    // 생성자 함수를 사용하지 않고, 
    // state 키워드를 이용해서 상태변수를 정의하고 초기화하는 것이 가능
    state = {
        number: 0,
        fixedNumber: 10
    };

    render() {
        const { number, fixedNumber } = this.state;
        return (
            <>
                <h1>number: {number}</h1>
                <h1>fixedNumber: {fixedNumber}</h1>

                <button onClick={() => {
                    console.log("Before:", number);
                    this.setState({ number: number + 1 });
                    console.log("After:", number);
                }}>하나 증가</button>
                <button onClick={() => {
                    console.log("Before:", number);
                    this.setState({ number: number - 1 });
                    console.log("After:", number);
                }}>하나 감소</button>
                <button onClick={() => {
                    this.setState({ number: number + 1 });
                    this.setState({ number: number + 1 });
                    this.setState({ number: number + 1 });
                    this.setState({ number: number + 1 });
                    this.setState({ number: number + 1 });
                }}>다섯 증가</button>
            </>
        );
    }
}
export default Counter;
