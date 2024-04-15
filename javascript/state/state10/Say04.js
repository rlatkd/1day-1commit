import { useState } from "react";


function Say() {
    const [message, setMessage] = useState('');
    const [color, setColor] = useState('black');
    const [backgroundColor, setBackgroundColor] = useState('white');


    const handlerClickEnter = () => setMessage('안녕하세요.');
    const handlerClickLeave = () => setMessage('안녕히 가세요.');


    return (
        <>
            <h1 style={{ backgroundColor, color }}>{message}</h1>


            <button onClick={handlerClickEnter}>입장</button>
            <button onClick={handlerClickLeave}>퇴장</button>
            <hr/>
            <button onClick={() => setColor('red')}>붉은색</button>
            <button onClick={() => setColor('blue')}>파란색</button>
            <button onClick={() => setColor('yellow')}>노란색</button>
            <hr/>
            <button onClick={() => setBackgroundColor('gray')}>회색</button>
            <button onClick={() => setBackgroundColor('black')}>검정색</button>
            <button onClick={() => setBackgroundColor('white')}>흰색</button>
        </>
    );
}
export default Say;
