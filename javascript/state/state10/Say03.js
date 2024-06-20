import { useState } from "react";

function Say() {
    const [message, setMessage] = useState('');
    const [color, setColor] = useState('black');    // 상태변수 개수만큼 useState() 훅을 사용

    const handlerClickEnter = () => setMessage('안녕하세요.');
    const handlerClickLeave = () => setMessage('안녕히 가세요.');

    return (
        <>
            {/* 단축속성명을 이용해서 color: color를 color로 표현 */}
            <h1 style={{ backgroundColor: 'green', color }}>{message}</h1>

            <button onClick={handlerClickEnter}>입장</button>
            <button onClick={handlerClickLeave}>퇴장</button>
            <hr/>
            <button onClick={() => setColor('red')}>붉은색</button>
            <button onClick={() => setColor('blue')}>파란색</button>
            <button onClick={() => setColor('yellow')}>노란색</button>
        </>
    );
}
export default Say;
