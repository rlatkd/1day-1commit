import { Component } from "react";

class MyComponentClass extends Component {

    render() {
        
        const { name, age, nickname, children } = this.props;
   
        return (
            <>
                <h1>이름은 {name}입니다.</h1>
                <h2>나이는 {age}입니다.</h2>
                <h2>별명은 {nickname}입니다.</h2>
                <div>{children}</div>
            </>
        );
    }
}

MyComponentClass.defaultProps = {
    name: '아무개',
    age: 0,
    nickname: '없음'
}

export default MyComponentClass;
