package com.assistant.event;

import com.assistant.dto.ShapeStyleCreateRequest;

public class ShapeStyleCreateEvent {
    private final Long styleId;

    private final Long shapeId;

    private final String orientation;

    private final String fontStyle;

    public ShapeStyleCreateEvent(Long shapeId, String orientation, String fontStyle) {
        this(null, shapeId, orientation, fontStyle);
    }

    public ShapeStyleCreateEvent(Long styleId, Long shapeId, String orientation, String fontStyle) {
        this.styleId = styleId;
        this.shapeId = shapeId;
        this.orientation = orientation;
        this.fontStyle = fontStyle;
    }

    public Long getStyleId() {
        return styleId;
    }

    public Long getShapeId() {
        return shapeId;
    }

    public String getOrientation() {
        return orientation;
    }

    public String getFontStyle() {
        return fontStyle;
    }

    public ShapeStyleCreateRequest toRequest() {
        return new ShapeStyleCreateRequest(styleId, shapeId, orientation, fontStyle);
    }
}
