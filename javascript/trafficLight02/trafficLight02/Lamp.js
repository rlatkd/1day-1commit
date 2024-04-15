import { Component } from "react";

class Lamp extends Component {
    render() {
        const { size, color } = this.props;
        return (
            <div style={{ width:size, height:size, borderRadius:size/2, backgroundColor:color }} />
        );
    }
}
export default Lamp;
