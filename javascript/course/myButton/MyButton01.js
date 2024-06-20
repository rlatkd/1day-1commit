function MyButton() {
   
    const [ isClicked, setIsClicked ] = React.useState(false);
    // <button onClick="콜백함수">내용</button>
    return React.createElement(
        'button',
        { onClick: () => setIsClicked(!isClicked) },
        isClicked ? "클릭되었습니다." : "클릭해주세요."
    );
}

const domContainer = document.querySelector('#root');
// ReactDOM.render(React.createElement(MyButton), domContainer);
ReactDOM.createRoot(domContainer).render(React.createElement(MyButton));	// 18 버전 이상