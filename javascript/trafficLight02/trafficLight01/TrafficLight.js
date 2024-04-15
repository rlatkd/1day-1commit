import Lamp from "./Lamp";

const TrafficLight = ({size, colors}) => {
    return (
        <>
            {
                colors.map(color => { 
                    console.log(size, color);
                    return <Lamp size={size} color={color}/>; 
                })
            }
        </>
    )};

export default TrafficLight;
