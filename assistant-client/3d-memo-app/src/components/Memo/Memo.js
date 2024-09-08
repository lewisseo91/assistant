import React from 'react';
import { extend, useLoader } from '@react-three/fiber';
import { useBox } from '@react-three/cannon';
import { BoxGeometry, MeshBasicMaterial, TextureLoader } from 'three';
import { Text } from '@react-three/drei';

extend({ BoxGeometry, MeshBasicMaterial });

function Memo({ content, position }) {
  const texture = useLoader(TextureLoader, '/assets/note-texture.jpg'); // 텍스처 로드

  const [ref] = useBox(() => ({
    type: 'Static',
    position: position, // 메모 위치 설정
  }));

  return (
    <mesh ref={ref} position={position}>
      <boxGeometry args={[2, 2, 0.1]} />
      <meshBasicMaterial map={texture} />

      <Text
        position={[0, 0, 0.2]}  // 텍스트를 박스 앞쪽에 배치
        fontSize={0.2}           // 폰트 크기 설정
        color="black"            // 텍스트 색상
        anchorX="center"         // 텍스트의 수평 기준점
        anchorY="middle"         // 텍스트의 수직 기준점
      >
        {content}
      </Text>
    </mesh>
  );
}

export default Memo;
