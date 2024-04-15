function TrafficLight ( {size} ) {
    return (
        <>
            <div style={{ width:size, height:size, borderRadius:size/2, backgroundColor:'red'}}/>
            <div style={{ width:size, height:size, borderRadius:size/2, backgroundColor:'red'}}/>
            <div style={{ width:size, height:size, borderRadius:size/2, backgroundColor:'red'}}/>
        </>
    );
}

export default TrafficLight;