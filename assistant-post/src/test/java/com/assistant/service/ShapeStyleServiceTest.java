package com.assistant.service;

import com.assistant.domain.Shape;
import com.assistant.domain.ShapeStyle;
import com.assistant.dto.PointCreateRequest;
import com.assistant.dto.ShapeCreateRequest;
import com.assistant.dto.ShapeStyleCreateRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("쉐입 스타일 서비스 테스트")
@DataJpaTest
@Import(ShapeStyleService.class)
class ShapeStyleServiceTest {

    @Autowired
    private ShapeStyleService shapeStyleService;

    @BeforeEach
    void setUp() {
    }

    @DisplayName("쉐입 스타일을 생성할 수 있다.")
    @Test
    public void 쉐입_스타일은_생성된다() {
        Long styleId = 1L;
        Long shapeId = 1L;
        String orientation = "portrait";
        String fontStyle = "italic";
        ShapeStyleCreateRequest shapeStyleCreateRequest = new ShapeStyleCreateRequest(styleId, shapeId, orientation, fontStyle);
        ShapeStyle createdShapeStyle = shapeStyleService.create(shapeStyleCreateRequest);

        assertEquals(createdShapeStyle.getStyleId(), styleId);
    }
}