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

val Icons.Food: ImageVector
    get() {
        if (_food != null) {
            return _food!!
        }
        _food = ImageVector.Builder(
            name = "Food",
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
            moveToRelative(160.0F, 840.0F)
            lineToRelative(-80.0F, -80.0F)
            horizontalLineToRelative(800.0F)
            lineToRelative(-80.0F, 80.0F)
            lineTo(160.0F, 840.0F)

            moveTo(120.0F, 720.0F)
            quadToRelative(6.0F, -18.0F, 16.0F, -34.0F)
            reflectiveQuadToRelative(24.0F, -30.0F)
            verticalLineToRelative(-296.0F)
            horizontalLineToRelative(-40.0F)
            verticalLineToRelative(-60.0F)
            horizontalLineToRelative(40.0F)
            verticalLineToRelative(-30.0F)
            horizontalLineToRelative(-40.0F)
            verticalLineToRelative(-60.0F)
            horizontalLineToRelative(40.0F)
            verticalLineToRelative(-30.0F)
            horizontalLineToRelative(-40.0F)
            verticalLineToRelative(-60.0F)
            horizontalLineToRelative(280.0F)
            quadToRelative(33.0F, 0.0F, 56.5F, 23.5F)
            reflectiveQuadTo(480.0F, 200.0F)
            verticalLineToRelative(10.0F)
            horizontalLineToRelative(360.0F)
            verticalLineToRelative(60.0F)
            lineTo(480.0F, 270.0F)
            verticalLineToRelative(10.0F)
            quadToRelative(0.0F, 33.0F, -23.5F, 56.5F)
            reflectiveQuadTo(400.0F, 360.0F)
            horizontalLineToRelative(-80.0F)
            verticalLineToRelative(244.0F)
            quadToRelative(14.0F, 2.0F, 28.0F, 6.0F)
            reflectiveQuadToRelative(26.0F, 12.0F)
            quadToRelative(26.0F, -65.0F, 83.0F, -103.5F)
            reflectiveQuadTo(583.0F, 480.0F)
            quadToRelative(90.0F, 0.0F, 153.5F, 61.5F)
            reflectiveQuadTo(800.0F, 692.0F)
            verticalLineToRelative(28.0F)
            lineTo(120.0F, 720.0F)

            moveTo(454.0F, 640.0F)
            horizontalLineToRelative(252.0F)
            quadToRelative(-17.0F, -36.0F, -50.0F, -58.0F)
            reflectiveQuadToRelative(-73.0F, -22.0F)
            quadToRelative(-42.0F, 0.0F, -77.0F, 21.0F)
            reflectiveQuadToRelative(-52.0F, 59.0F)

            moveTo(320.0F, 210.0F)
            horizontalLineToRelative(80.0F)
            verticalLineToRelative(-30.0F)
            horizontalLineToRelative(-80.0F)
            verticalLineToRelative(30.0F)

            moveTo(320.0F, 300.0F)
            horizontalLineToRelative(80.0F)
            verticalLineToRelative(-30.0F)
            horizontalLineToRelative(-80.0F)
            verticalLineToRelative(30.0F)

            moveTo(220.0F, 210.0F)
            horizontalLineToRelative(40.0F)
            verticalLineToRelative(-30.0F)
            horizontalLineToRelative(-40.0F)
            verticalLineToRelative(30.0F)

            moveTo(220.0F, 300.0F)
            horizontalLineToRelative(40.0F)
            verticalLineToRelative(-30.0F)
            horizontalLineToRelative(-40.0F)
            verticalLineToRelative(30.0F)

            moveTo(220.0F, 614.0F)
            quadToRelative(10.0F, -5.0F, 19.5F, -7.5F)
            reflectiveQuadTo(260.0F, 602.0F)
            verticalLineToRelative(-242.0F)
            horizontalLineToRelative(-40.0F)
            verticalLineToRelative(254.0F)

            moveTo(580.0F, 640.0F)
            close()
        }.build()
        return _food!!
    }
private var _food: ImageVector? = null
