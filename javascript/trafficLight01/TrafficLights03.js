function Lamp ( {size, color}) {
    return (
        <>
            <div style={{ width:size, height:size, borderRadius:size/2, backgroundColor:color}}/>
        </>
    );
}


function TrafficLight ( {size} ) {
    return (
        <>
            <Lamp size={size} color='red'/>
            <Lamp size={size} color='green'/>
            <Lamp size={size} color='yellow'/>
        </>
    );
}

export default TrafficLight;