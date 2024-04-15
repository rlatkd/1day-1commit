import { Component, useState } from "react";
import Title from "./Title";

class Todo extends Component {
    state = {
        count: 10, 
        color: 'black'
    };
    
    render() {
        const { count, color } = this.state;
        const handlerCountUp = () => this.setState({ count: this.state.count + 1 });
        const handlerCountDown = () => this.setState({ count: this.state.count - 1 });
        const handlerCountReset = () => this.setState({ count: 0 });
        const handlerChangeRed = () => this.setState({ color: 'red' });
        const handlerChangeYellow = () => this.setState({ color: 'yellow' });
        const handlerChangeBlue = () => this.setState({ color: 'blue' });
        return(
            <>
                <Title count={count} color={color}/>
                <button onClick={handlerCountUp}>카운트 증가</button>		
                <button onClick={handlerCountDown}>카운트 감소</button>
                <button onClick={handlerCountReset}>카운트 초기화</button>
                <hr/>
                <button onClick={handlerChangeRed}>빨강</button>
                <button onClick={handlerChangeYellow}>노랑</button>
                <button onClick={handlerChangeBlue}>파랑</button>
            </>
        );
    }
}
export default Todo;
