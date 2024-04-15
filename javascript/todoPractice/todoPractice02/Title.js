import { Component } from "react";

class Title extends Component {
    render() {
        const {count} = this.props;
        return (
            <>
                <h1>현재 카운트는 {count}입니다.</h1>
            </>
        );
    }
}
export default Title;
