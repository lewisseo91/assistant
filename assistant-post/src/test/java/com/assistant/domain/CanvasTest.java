package com.assistant.domain;


import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CanvasTest {

    @Test
    public void 캔버스를_등록할수_있다() {
        Long id = 1L;
        Long postId = 1L;
        Canvas canvas = Canvas.create(id, postId);
        assertEquals(canvas.getCanvasId(), id);
    }

    @Test
    public void 캔버스를_수정할수_있다() {
        Long id = 1L;
        Long postId = 1L;
        Canvas canvas = Canvas.create(id, postId);

        Long newCanvasId = 2L;
        Canvas updatedCanvas = Canvas.update(newCanvasId, postId);
        assertEquals(updatedCanvas.getCanvasId(), newCanvasId);
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
