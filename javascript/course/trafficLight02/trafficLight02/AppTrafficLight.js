import TrafficLight from './trafficLight/TrafficLight';

function App() {
  const tlSize = 100;
  const tlColors = [ 'red', 'yellow', 'green' ];
  return (
    <>
      <TrafficLight size={tlSize} colors={tlColors} />
    </>  
  );
}
export default App;
