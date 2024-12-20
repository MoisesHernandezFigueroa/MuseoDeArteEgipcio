package com.example.museodearteegipcio.icons

import androidx.compose.material.icons.Icons
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val Icons.Paint: ImageVector
    get() {
        if (_paint != null) {
            return _paint!!
        }
        _paint = ImageVector.Builder(
            name = "Paint",
            defaultWidth = 24.0.dp,
            defaultHeight = 24.0.dp,
            viewportWidth = 960.0F,
            viewportHeight = 960.0F,
        ).path(
            fill = SolidColor(Color(0xFFE8EAED)),
            fillAlpha = 1.0F,
            strokeAlpha = 1.0F,
            strokeLineWidth = 0.0F,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 4.0F,
            pathFillType = PathFillType.NonZero,
        ) {
            moveTo(240.0F, 840.0F)
            quadToRelative(-45.0F, 0.0F, -89.0F, -22.0F)
            reflectiveQuadToRelative(-71.0F, -58.0F)
            quadToRelative(26.0F, 0.0F, 53.0F, -20.5F)
            reflectiveQuadToRelative(27.0F, -59.5F)
            quadToRelative(0.0F, -50.0F, 35.0F, -85.0F)
            reflectiveQuadToRelative(85.0F, -35.0F)
            quadToRelative(50.0F, 0.0F, 85.0F, 35.0F)
            reflectiveQuadToRelative(35.0F, 85.0F)
            quadToRelative(0.0F, 66.0F, -47.0F, 113.0F)
            reflectiveQuadToRelative(-113.0F, 47.0F)

            moveTo(240.0F, 760.0F)
            quadToRelative(33.0F, 0.0F, 56.5F, -23.5F)
            reflectiveQuadTo(320.0F, 680.0F)
            quadToRelative(0.0F, -17.0F, -11.5F, -28.5F)
            reflectiveQuadTo(280.0F, 640.0F)
            quadToRelative(-17.0F, 0.0F, -28.5F, 11.5F)
            reflectiveQuadTo(240.0F, 680.0F)
            quadToRelative(0.0F, 23.0F, -5.5F, 42.0F)
            reflectiveQuadTo(220.0F, 758.0F)
            quadToRelative(5.0F, 2.0F, 10.0F, 2.0F)
            horizontalLineToRelative(10.0F)

            moveTo(470.0F, 600.0F)
            lineTo(360.0F, 490.0F)
            lineToRelative(358.0F, -358.0F)
            quadToRelative(11.0F, -11.0F, 27.5F, -11.5F)
            reflectiveQuadTo(774.0F, 132.0F)
            lineToRelative(54.0F, 54.0F)
            quadToRelative(12.0F, 12.0F, 12.0F, 28.0F)
            reflectiveQuadToRelative(-12.0F, 28.0F)
            lineTo(470.0F, 600.0F)

            moveTo(280.0F, 680.0F)
            close()
        }.build()
        return _paint!!
    }
private var _paint: ImageVector? = null
