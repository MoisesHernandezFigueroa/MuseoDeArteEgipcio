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

val Icons.Building: ImageVector
    get() {
        if (_building != null) {
            return _building!!
        }
        _building = ImageVector.Builder(
            name = "Building",
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
            moveTo(756.0F, 840.0F)
            lineTo(537.0F, 621.0F)
            lineToRelative(84.0F, -84.0F)
            lineToRelative(219.0F, 219.0F)
            lineToRelative(-84.0F, 84.0F)

            moveTo(204.0F, 840.0F)
            lineTo(120.0F, 756.0F)
            lineTo(396.0F, 480.0F)
            lineTo(328.0F, 412.0F)
            lineTo(300.0F, 440.0F)
            lineTo(249.0F, 389.0F)
            verticalLineToRelative(82.0F)
            lineToRelative(-28.0F, 28.0F)
            lineToRelative(-121.0F, -121.0F)
            lineToRelative(28.0F, -28.0F)
            horizontalLineToRelative(82.0F)
            lineToRelative(-50.0F, -50.0F)
            lineToRelative(142.0F, -142.0F)
            quadToRelative(20.0F, -20.0F, 43.0F, -29.0F)
            reflectiveQuadToRelative(47.0F, -9.0F)
            quadToRelative(24.0F, 0.0F, 47.0F, 9.0F)
            reflectiveQuadToRelative(43.0F, 29.0F)
            lineToRelative(-92.0F, 92.0F)
            lineToRelative(50.0F, 50.0F)
            lineToRelative(-28.0F, 28.0F)
            lineToRelative(68.0F, 68.0F)
            lineToRelative(90.0F, -90.0F)
            quadToRelative(-4.0F, -11.0F, -6.5F, -23.0F)
            reflectiveQuadToRelative(-2.5F, -24.0F)
            quadToRelative(0.0F, -59.0F, 40.5F, -99.5F)
            reflectiveQuadTo(701.0F, 119.0F)
            quadToRelative(15.0F, 0.0F, 28.5F, 3.0F)
            reflectiveQuadToRelative(27.5F, 9.0F)
            lineToRelative(-99.0F, 99.0F)
            lineToRelative(72.0F, 72.0F)
            lineToRelative(99.0F, -99.0F)
            quadToRelative(7.0F, 14.0F, 9.5F, 27.5F)
            reflectiveQuadTo(841.0F, 259.0F)
            quadToRelative(0.0F, 59.0F, -40.5F, 99.5F)
            reflectiveQuadTo(701.0F, 399.0F)
            quadToRelative(-12.0F, 0.0F, -24.0F, -2.0F)
            reflectiveQuadToRelative(-23.0F, -7.0F)
            lineTo(204.0F, 840.0F)
            close()
        }.build()
        return _building!!
    }
private var _building: ImageVector? = null

