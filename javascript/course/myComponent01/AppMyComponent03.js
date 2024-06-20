import './App.css';
import MyComponentClass from './MyComponentClass';
import MyComponentFunction from './MyComponentFunction';


function App() {


  const datas = [
    { name: '홍길동', age: 23, nickname: '호부호형을 원하는 자' },
    { name: '고길동', age: 40, nickname: '둘리가 싫은 자' },
    { name: '신길동', age: 50, nickname: '신길동 매운 짬뽕' }
  ];


  return (
    <>
      {
        datas.map(data => <MyComponentClass name={data.name} age={data.age} nickname={data.nickname}><i>어떤 내용</i></MyComponentClass>)
      }
      <hr/>
      <MyComponentClass name='홍길동' age={23} nickname='호부호형'><i>어떤 내용</i></MyComponentClass>
      <MyComponentClass name='고길동' age={23} nickname='호부호형'><i>어떤 내용</i></MyComponentClass>
      <MyComponentClass name='신길동' age={23} nickname='호부호형'><i>어떤 내용</i></MyComponentClass>
      <hr/>
      <MyComponentFunction>
        <i>또 어떤 내용</i>
      </MyComponentFunction>
    </>  
  );
}


export default App;