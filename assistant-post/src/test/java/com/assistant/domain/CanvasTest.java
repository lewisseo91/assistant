package com.assistant.domain;


import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CanvasTest {

    @Test
    public void 캔버스를_등록할수_있다() {
        Long id = 1L;
        Canvas canvas = Canvas.create(id);
        assertEquals(canvas.getCanvasId(), id);
    }

    @Test
    public void 캔버스를_수정할수_있다() {
        Long id = 1L;
        List<Long> updateShapes = List.of(1L, 2L);
        List<Long> updateContents = List.of(1L, 2L);

        Canvas updatedCanvas = Canvas.update(id, updateShapes, updateContents);
        assertEquals(updatedCanvas.getShapes(), updateShapes);
        assertEquals(updatedCanvas.getContents(), updateContents);
    }
//    @Test
//    public void 캔버스는_컨텐트를_등록할수_있다() {
//        Long id = 1L;
//        Canvas canvas = Canvas.create(id);
//        assertEquals(title, post.getTitle());
//    }
//
//    @Test
//    public void 캔버스는_컨텐트를_삭제할수_있다() {
//        Long id = 1L;
//        Canvas canvas = Canvas.create(id);
//        assertEquals(title, post.getTitle());
//    }
}
