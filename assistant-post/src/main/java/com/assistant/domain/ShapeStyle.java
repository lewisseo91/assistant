package com.assistant.domain;

public class ShapeStyle {
    private final Long styleId;

    private final Long shapeId;

    private final String orientation;

    private final String fontStyle;

    private boolean deleted;

    public ShapeStyle(Long styleId, Long shapeId, String orientation, String fontStyle) {
        this.styleId = styleId;
        this.shapeId = shapeId;
        this.orientation = orientation;
        this.fontStyle = fontStyle;
        this.deleted = false;
    }

    public static ShapeStyle create(Long styleId, Long shapeId, String orientation, String fontStyle) {
        return new ShapeStyle(styleId, shapeId, orientation, fontStyle);
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

    public boolean isDeleted() {
        return deleted;
    }

    public void delete() {
        this.deleted = true;
    }
}
