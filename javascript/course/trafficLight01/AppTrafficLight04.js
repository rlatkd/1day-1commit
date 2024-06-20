import TrafficLight from "./TrafficLight01";

function App() {
    const tlsize = 100;
    const tlcolor = [ 'red', 'green', 'blue', 'yellow' ];

    return (
        <>
            <TrafficLight size={tlsize} color={tlcolor}/>
        </>
    );
}

export default App;