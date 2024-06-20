import { useState } from "react";
import Title from "./Title";

function Todo() {
    const [count, setCount] = useState(10);

    const handlerCountUp = () => setCount(count + 1);
    const handlerCountDown = () => setCount(count - 1);
    const handlerCountReset = () => setCount(0);
    return (
        <>
            <Title count={count} />
            <button onClick={handlerCountUp}>카운트 증가</button>		
            <button onClick={handlerCountDown}>카운트 감소</button>
            <button onClick={handlerCountReset}>카운트 초기화</button>
        </>
    );
}
export default Todo;
