// src/App.js
import React from 'react';
import { Canvas } from '@react-three/fiber';
import { OrbitControls, Stars } from '@react-three/drei';
import { Physics } from '@react-three/cannon';
import Memo from './components/Memo/Memo';

function App() {
  return (
    <div style={{ height: '100vh' }}>
      <Canvas style={{ background: 'black' }} camera={{ position: [0, 0, 10], fov: 50 }}>
        {/* Ambient light to provide global lighting */}
        <ambientLight intensity={0.5} />
        {/* Point light to illuminate the memo */}
        <pointLight position={[10, 10, 10]} intensity={1} />

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
