import { useState } from "react";

function Say() {
    const [message, setMessage] = useState('');

    // 이벤트 핸들러 함수를 정의 ==> 접두어로 handler 또는 on을 사용
    const handlerClickEnter = () => setMessage('안녕하세요.');
    const handlerClickLeave = () => setMessage('안녕히 가세요.');

    return (
        <>
            <h1>{message}</h1>

            <button onClick={handlerClickEnter}>입장</button>
            <button onClick={handlerClickLeave}>퇴장</button>
        </>
    );
}
export default Say;
