import { Component } from "react";

class MyComponentClass extends Component {

    render() {
        console.log(this);
        console.log(this.props);		⇐ 부모 클래스(Componet)에 정의된 속성
        return (
            <>
                <h1>이름은 {this.props.name}입니다.</h1>
                <h2>나이는 23살입니다.</h2>
            </>
        );
    }
}

export default MyComponentClass;