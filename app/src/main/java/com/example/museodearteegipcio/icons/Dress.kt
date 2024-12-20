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

val Icons.Dress: ImageVector
    get() {
        if (_dress != null) {
            return _dress!!
        }
        _dress = ImageVector.Builder(
            name = "Dress",
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
            moveToRelative(240.0F, 438.0F)
            lineToRelative(-40.0F, 22.0F)
            quadToRelative(-14.0F, 8.0F, -30.0F, 4.0F)
            reflectiveQuadToRelative(-24.0F, -18.0F)
            lineTo(66.0F, 306.0F)
            quadToRelative(-8.0F, -14.0F, -4.0F, -30.0F)
            reflectiveQuadToRelative(18.0F, -24.0F)
            lineToRelative(230.0F, -132.0F)
            horizontalLineToRelative(70.0F)
            quadToRelative(9.0F, 0.0F, 14.5F, 5.5F)
            reflectiveQuadTo(400.0F, 140.0F)
            verticalLineToRelative(20.0F)
            quadToRelative(0.0F, 33.0F, 23.5F, 56.5F)
            reflectiveQuadTo(480.0F, 240.0F)
            quadToRelative(33.0F, 0.0F, 56.5F, -23.5F)
            reflectiveQuadTo(560.0F, 160.0F)
            verticalLineToRelative(-20.0F)
            quadToRelative(0.0F, -9.0F, 5.5F, -14.5F)
            reflectiveQuadTo(580.0F, 120.0F)
            horizontalLineToRelative(70.0F)
            lineToRelative(230.0F, 132.0F)
            quadToRelative(14.0F, 8.0F, 18.0F, 24.0F)
            reflectiveQuadToRelative(-4.0F, 30.0F)
            lineToRelative(-80.0F, 140.0F)
            quadToRelative(-8.0F, 14.0F, -23.5F, 17.5F)
            reflectiveQuadTo(760.0F, 459.0F)
            lineToRelative(-40.0F, -20.0F)
            verticalLineToRelative(361.0F)
            quadToRelative(0.0F, 17.0F, -11.5F, 28.5F)
            reflectiveQuadTo(680.0F, 840.0F)
            lineTo(280.0F, 840.0F)
            quadToRelative(-17.0F, 0.0F, -28.5F, -11.5F)
            reflectiveQuadTo(240.0F, 800.0F)
            verticalLineToRelative(-362.0F)

            moveTo(320.0F, 304.0F)
            verticalLineToRelative(456.0F)
            horizontalLineToRelative(320.0F)
            verticalLineToRelative(-456.0F)
            lineToRelative(124.0F, 68.0F)
            lineToRelative(42.0F, -70.0F)
            lineToRelative(-172.0F, -100.0F)
            quadToRelative(-15.0F, 51.0F, -56.5F, 84.5F)
            reflectiveQuadTo(480.0F, 320.0F)
            quadToRelative(-56.0F, 0.0F, -97.5F, -33.5F)
            reflectiveQuadTo(326.0F, 202.0F)
            lineTo(154.0F, 302.0F)
            lineToRelative(42.0F, 70.0F)
            lineToRelative(124.0F, -68.0F)

            moveTo(480.0F, 481.0F)
            close()
        }.build()
        return _dress!!
    }
private var _dress: ImageVector? = null
