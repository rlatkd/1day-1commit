import { useState } from "react";

function Say() {
    // 상태변수를 정의
    const [message, setMessage] = useState('');

    console.log("message", typeof(message));
    console.log("setMessage", typeof(setMessage));

    console.log("useState('')[0]", typeof(useState('')[0]));
    console.log("useState('')[1]", typeof(useState('')[1]));
    
    return (
        <>
            <h1>{message}</h1>

            <button onClick={() => setMessage('안녕하세요.')}>입장</button>
            <button onClick={() => setMessage('안녕히 가세요.')}>퇴장</button>
        </>
    );
}
export default Say;
