import './App.css';
import MyComponentClass from './MyComponentClass';
import MyComponentFunction from './MyComponentFunction';

function App() {
  return (
    <>
      <MyComponentClass name="신길동" age={23} nickname={"길동"} />
      <hr/>
      <MyComponentFunction name="고길동" age={40} nickname="길동" />
    </>                                      ~~~~
  );                                         숫자인 경우 { }로 묶어서 표현
}

export default App;