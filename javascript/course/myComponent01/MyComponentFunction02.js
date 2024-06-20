function MyComponentFunction({name}) {     ⇐ 매개변수를 받을 때 부터 객체 비구조화를 통해 지역변수로 재할당
    return (
        <>
            <h1>이름은 {name}입니다.</h1>
            <h2>나이는 23살입니다.</h2>
        </>
    );
}
export default MyComponentFunction;