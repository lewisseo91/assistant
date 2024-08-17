// src/components/Memo/Memo.js
import React from 'react';
import { extend } from '@react-three/fiber';
import { useBox } from '@react-three/cannon';
import { BoxGeometry, MeshStandardMaterial, PlaneGeometry } from 'three';
import { Text } from '@react-three/drei';

// react-three-fiber에 BoxGeometry, MeshStandardMaterial, PlaneGeometry 등록
extend({ BoxGeometry, MeshStandardMaterial, PlaneGeometry });

function Memo({ content }) {
  const [ref] = useBox(() => ({
    type: 'Static', // 메모를 고정된 상태로 설정
    position: [0, 0, 0],
  }));

  return (
    <mesh ref={ref} position={[0, 0, 0]}>
      <boxGeometry args={[2, 2, 0.1]} />
      <meshStandardMaterial color="#A9A9A9" />

      <Text
        position={[0, 0, 0.2]}  // 텍스트를 박스의 앞쪽에 배치
        fontSize={0.2}           // 폰트 크기 설정
        color="white"            // 텍스트 색상을 흰색으로 설정
        anchorX="center"         // 텍스트를 중심에 맞춤
        anchorY="middle"
      >
        {content}
      </Text>
    </mesh>
  );
}

export default Memo;
