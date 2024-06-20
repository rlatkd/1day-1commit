import { Component, useState } from "react";
import Title from "./Title";

class Todo extends Component {
    state = {
        count: 10
    };
    
    render() {
        const { count } = this.state;
        const handlerCountUp = () => this.setState({ count: this.state.count + 1 });
        const handlerCountDown = () => this.setState({ count: this.state.count - 1 });
        const handlerCountReset = () => this.setState({ count: 0 });
    
        return(
            <>
                <Title count={count} />
                <button onClick={handlerCountUp}>카운트 증가</button>		
                <button onClick={handlerCountDown}>카운트 감소</button>
                <button onClick={handlerCountReset}>카운트 초기화</button>
            </>
        );
    }
}
export default Todo;
