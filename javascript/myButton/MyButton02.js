import './App.css';
import { useState } from 'react';


function App() {
  const [isClicked, setIsClicked] = useState(false);


  return (
    <button onClick={() => setIsClicked(!isClicked)}>
      {isClicked ? "클릭되었습니다." : "클릭해주세요."}
    </button>
  );
}


export default App;