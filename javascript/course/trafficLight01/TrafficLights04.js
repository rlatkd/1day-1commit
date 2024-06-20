function Lamp ( {size, color}) {
    return (
        <>
            <div style={{ width:size, height:size, borderRadius:size/2, backgroundColor:color}}/>
        </>
    );
}


function TrafficLight ( {size, colors} ) {
    return (
        <>
            {
                colors.map(color => <Lamp size={size} color={color}/>)
            }
        </>
    );
}

export default TrafficLight;