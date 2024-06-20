import { Component } from "react";
import Lamp from "./Lamp";

class TrafficLight extends Component {
    render() {
        const {size, colors} = this.props;
        return (
            <>
            {
                colors.map((color, index) => { 
                    console.log(size, color);
                    return <Lamp key={index} size={size} color={color}/>; 
                })
            }
            </>
        );
    }
}
export default TrafficLight;
