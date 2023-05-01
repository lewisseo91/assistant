package com.assistant.dto;

public class ShapeStyleCreateRequest {
    private final Long styleId;

    private final Long shapeId;

    private final String orientation;

    private final String fontStyle;

    public ShapeStyleCreateRequest(Long styleId, Long shapeId, String orientation, String fontStyle) {
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
}
