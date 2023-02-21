package com.assistant.domain;

public class ShapeStyle {
    private final Long styleId;

    private final String orientation;

    private final String fontStyle;

    private boolean deleted;

    public ShapeStyle(Long styleId, String orientation, String fontStyle) {
        this.styleId = styleId;
        this.orientation = orientation;
        this.fontStyle = fontStyle;
        this.deleted = false;
    }

    public static ShapeStyle create(Long styleId, String orientation, String fontStyle) {
        return new ShapeStyle(styleId, orientation, fontStyle);
    }

    public Long getStyleId() {
        return styleId;
    }

    public boolean getDeleted() {
        return this.deleted;
    }

    public void delete() {
        this.deleted = true;
    }
}
