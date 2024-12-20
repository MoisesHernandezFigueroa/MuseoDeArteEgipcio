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

val Icons.Skull: ImageVector
    get() {
        if (_skull != null) {
            return _skull!!
        }
        _skull = ImageVector.Builder(
            name = "Skull",
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
            moveTo(240.0F, 880.0F)
            verticalLineToRelative(-170.0F)
            quadToRelative(-39.0F, -17.0F, -68.5F, -45.5F)
            reflectiveQuadToRelative(-50.0F, -64.5F)
            quadToRelative(-20.5F, -36.0F, -31.0F, -77.0F)
            reflectiveQuadTo(80.0F, 440.0F)
            quadToRelative(0.0F, -158.0F, 112.0F, -259.0F)
            reflectiveQuadToRelative(288.0F, -101.0F)
            quadToRelative(176.0F, 0.0F, 288.0F, 101.0F)
            reflectiveQuadToRelative(112.0F, 259.0F)
            quadToRelative(0.0F, 42.0F, -10.5F, 83.0F)
            reflectiveQuadToRelative(-31.0F, 77.0F)
            quadToRelative(-20.5F, 36.0F, -50.0F, 64.5F)
            reflectiveQuadTo(720.0F, 710.0F)
            verticalLineToRelative(170.0F)
            lineTo(240.0F, 880.0F)

            moveTo(320.0F, 800.0F)
            horizontalLineToRelative(40.0F)
            verticalLineToRelative(-80.0F)
            horizontalLineToRelative(80.0F)
            verticalLineToRelative(80.0F)
            horizontalLineToRelative(80.0F)
            verticalLineToRelative(-80.0F)
            horizontalLineToRelative(80.0F)
            verticalLineToRelative(80.0F)
            horizontalLineToRelative(40.0F)
            verticalLineToRelative(-142.0F)
            quadToRelative(38.0F, -9.0F, 67.5F, -30.0F)
            reflectiveQuadToRelative(50.0F, -50.0F)
            quadToRelative(20.5F, -29.0F, 31.5F, -64.0F)
            reflectiveQuadToRelative(11.0F, -74.0F)
            quadToRelative(0.0F, -125.0F, -88.5F, -202.5F)
            reflectiveQuadTo(480.0F, 160.0F)
            quadToRelative(-143.0F, 0.0F, -231.5F, 77.5F)
            reflectiveQuadTo(160.0F, 440.0F)
            quadToRelative(0.0F, 39.0F, 11.0F, 74.0F)
            reflectiveQuadToRelative(31.5F, 64.0F)
            quadToRelative(20.5F, 29.0F, 50.5F, 50.0F)
            reflectiveQuadToRelative(67.0F, 30.0F)
            verticalLineToRelative(142.0F)

            moveTo(420.0F, 600.0F)
            horizontalLineToRelative(120.0F)
            lineToRelative(-60.0F, -120.0F)
            lineToRelative(-60.0F, 120.0F)

            moveTo(340.0F, 520.0F)
            quadToRelative(33.0F, 0.0F, 56.5F, -23.5F)
            reflectiveQuadTo(420.0F, 440.0F)
            quadToRelative(0.0F, -33.0F, -23.5F, -56.5F)
            reflectiveQuadTo(340.0F, 360.0F)
            quadToRelative(-33.0F, 0.0F, -56.5F, 23.5F)
            reflectiveQuadTo(260.0F, 440.0F)
            quadToRelative(0.0F, 33.0F, 23.5F, 56.5F)
            reflectiveQuadTo(340.0F, 520.0F)

            moveTo(620.0F, 520.0F)
            quadToRelative(33.0F, 0.0F, 56.5F, -23.5F)
            reflectiveQuadTo(700.0F, 440.0F)
            quadToRelative(0.0F, -33.0F, -23.5F, -56.5F)
            reflectiveQuadTo(620.0F, 360.0F)
            quadToRelative(-33.0F, 0.0F, -56.5F, 23.5F)
            reflectiveQuadTo(540.0F, 440.0F)
            quadToRelative(0.0F, 33.0F, 23.5F, 56.5F)
            reflectiveQuadTo(620.0F, 520.0F)

            moveTo(480.0F, 800.0F)
            close()
        }.build()
        return _skull!!
    }
private var _skull: ImageVector? = null
