package com.assistant.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class ShapeStyle {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private final Long styleId;

    @Column(name = "shape_id")
    private final Long shapeId;

    @Column(name = "orientation")
    private final String orientation;

    @Column(name = "font_style")
    private final String fontStyle;

    @Column(name = "deleted")
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
