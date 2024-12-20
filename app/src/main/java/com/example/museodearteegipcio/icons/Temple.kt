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

val Icons.Temple: ImageVector
    get() {
        if (_temple != null) {
            return _temple!!
        }
        _temple = ImageVector.Builder(
            name = "Temple",
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
            moveTo(80.0F, 880.0F)
            verticalLineToRelative(-320.0F)
            lineToRelative(160.0F, -71.0F)
            verticalLineToRelative(-129.0F)
            lineToRelative(200.0F, -100.0F)
            verticalLineToRelative(-60.0F)
            horizontalLineToRelative(-80.0F)
            verticalLineToRelative(-80.0F)
            horizontalLineToRelative(80.0F)
            verticalLineToRelative(-80.0F)
            horizontalLineToRelative(80.0F)
            verticalLineToRelative(80.0F)
            horizontalLineToRelative(80.0F)
            verticalLineToRelative(80.0F)
            horizontalLineToRelative(-80.0F)
            verticalLineToRelative(60.0F)
            lineToRelative(200.0F, 100.0F)
            verticalLineToRelative(129.0F)
            lineToRelative(160.0F, 71.0F)
            verticalLineToRelative(320.0F)
            lineTo(520.0F, 880.0F)
            verticalLineToRelative(-160.0F)
            quadToRelative(0.0F, -17.0F, -11.5F, -28.5F)
            reflectiveQuadTo(480.0F, 680.0F)
            quadToRelative(-17.0F, 0.0F, -28.5F, 11.5F)
            reflectiveQuadTo(440.0F, 720.0F)
            verticalLineToRelative(160.0F)
            lineTo(80.0F, 880.0F)

            moveTo(160.0F, 800.0F)
            horizontalLineToRelative(200.0F)
            verticalLineToRelative(-82.0F)
            quadToRelative(0.0F, -51.0F, 35.0F, -86.5F)
            reflectiveQuadToRelative(85.0F, -35.5F)
            quadToRelative(50.0F, 0.0F, 85.0F, 35.5F)
            reflectiveQuadToRelative(35.0F, 86.5F)
            verticalLineToRelative(82.0F)
            horizontalLineToRelative(200.0F)
            verticalLineToRelative(-192.0F)
            lineToRelative(-160.0F, -72.0F)
            verticalLineToRelative(-134.0F)
            lineToRelative(-160.0F, -82.0F)
            lineToRelative(-160.0F, 82.0F)
            verticalLineToRelative(134.0F)
            lineToRelative(-160.0F, 72.0F)
            verticalLineToRelative(192.0F)

            moveTo(480.0F, 540.0F)
            quadToRelative(25.0F, 0.0F, 42.5F, -17.5F)
            reflectiveQuadTo(540.0F, 480.0F)
            quadToRelative(0.0F, -25.0F, -17.5F, -42.5F)
            reflectiveQuadTo(480.0F, 420.0F)
            quadToRelative(-25.0F, 0.0F, -42.5F, 17.5F)
            reflectiveQuadTo(420.0F, 480.0F)
            quadToRelative(0.0F, 25.0F, 17.5F, 42.5F)
            reflectiveQuadTo(480.0F, 540.0F)

            moveTo(480.0F, 560.0F)
            close()
        }.build()
        return _temple!!
    }
private var _temple: ImageVector? = null
