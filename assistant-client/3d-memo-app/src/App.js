// src/App.js
import React from 'react';
import { Canvas } from '@react-three/fiber';
import { OrbitControls, Stars } from '@react-three/drei';
import { Physics } from '@react-three/cannon';
import Memo from './components/Memo/Memo';

function App() {
  return (
    <div style={{ height: '100vh', backgroundColor: 'black' }}>
      <Canvas shadows camera={{ position: [0, 0, 10], fov: 50 }}>
        <ambientLight intensity={0.5} />
        <pointLight position={[10, 10, 10]} intensity={1} castShadow />

        <OrbitControls enableZoom={true} />
        <Stars radius={100} depth={50} count={5000} factor={4} saturation={0} fade />

        <Physics>
          <Memo content="Hello, World!" />
        </Physics>
      </Canvas>
    </div>
  );
}

export default App;
