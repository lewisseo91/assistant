// src/App.js
import React, { useState } from 'react';
import { Canvas } from '@react-three/fiber';
import { OrbitControls, Stars } from '@react-three/drei';
import { Physics } from '@react-three/cannon';
import Memo from './components/Memo/Memo';

function App() {
  const [memos, setMemos] = useState([]); // 메모들을 관리하는 상태

  const handleCanvasClick = (event) => {
    // 새로운 메모를 추가
    setMemos((prevMemos) => [
      ...prevMemos,
      {
        id: prevMemos.length + 1,
        position: [Math.random() * 4 - 2, Math.random() * 4 - 2, 0], // 메모의 무작위 위치
        content: `Memo ${prevMemos.length + 1}`, // 간단한 텍스트 내용
      },
    ]);
  };

  return (
    <div style={{ height: '100vh', backgroundColor: 'black' }}>
      <Canvas onClick={handleCanvasClick} camera={{ position: [0, 0, 10], fov: 50 }}>
        <ambientLight intensity={0.5} />
        <pointLight position={[10, 10, 10]} intensity={1} castShadow />

        <OrbitControls enableZoom={true} />
        <Stars radius={100} depth={50} count={5000} factor={4} saturation={0} fade />

        <Physics>
          {/* 상태에서 관리하는 메모들을 렌더링 */}
          {memos.map((memo) => (
            <Memo key={memo.id} position={memo.position} content={memo.content} />
          ))}
        </Physics>
      </Canvas>
    </div>
  );
}

export default App;
