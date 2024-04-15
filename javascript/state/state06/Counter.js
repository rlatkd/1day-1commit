import { Component } from "react";

class Counter extends Component {
    constructor(props) {
        super(props);

        this.state = {
            number: 0,
            fixedNumber: 10
        };
    }

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
            </>
        );
    }
}
export default Counter;
