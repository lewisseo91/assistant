// src/components/Memo/Memo.js
import React from 'react';
import { extend, useLoader } from '@react-three/fiber';
import { useBox } from '@react-three/cannon';
import { BoxGeometry, MeshStandardMaterial, TextureLoader } from 'three';
import { Text } from '@react-three/drei';

extend({ BoxGeometry, MeshStandardMaterial });

function Memo({ content }) {
  const texture = useLoader(TextureLoader, '/assets/note-texture.jpg');

  const [ref] = useBox(() => ({
    type: 'Static',
    position: [0, 0, 0],
  }));

  return (
    <mesh ref={ref} position={[0, 0, 0]} castShadow receiveShadow>
      <boxGeometry args={[2, 2, 0.1]} />
      {/* 메모 박스의 밝기 조절 */}
      <meshStandardMaterial
        map={texture}
      />

      {/* 텍스트를 별도의 mesh로 분리하여 밝기 영향 방지 */}
      <Text
        position={[0, 0, 0.2]}  // 텍스트를 박스 앞쪽에 배치
        fontSize={0.2}           // 폰트 크기 설정
        color="white"            // 텍스트 색상을 흰색으로 유지
        anchorX="center"         // 텍스트를 중심에 맞춤
        anchorY="middle"
      >
        {content}
      </Text>
    </mesh>
  );
}

export default Memo;
