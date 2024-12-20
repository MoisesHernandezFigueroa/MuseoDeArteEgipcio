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

val Icons.Pyramid: ImageVector
    get() {
        if (_pyramid != null) {
            return _pyramid!!
        }
        _pyramid = ImageVector.Builder(
            name = "Pyramid",
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
            verticalLineToRelative(-440.0F)
            horizontalLineToRelative(80.0F)
            verticalLineToRelative(80.0F)
            horizontalLineToRelative(80.0F)
            lineToRelative(119.0F, -395.0F)
            verticalLineToRelative(-85.0F)
            horizontalLineToRelative(80.0F)
            verticalLineToRelative(80.0F)
            horizontalLineToRelative(81.0F)
            verticalLineToRelative(-80.0F)
            horizontalLineToRelative(80.0F)
            verticalLineToRelative(80.0F)
            lineToRelative(120.0F, 400.0F)
            horizontalLineToRelative(80.0F)
            verticalLineToRelative(-80.0F)
            horizontalLineToRelative(80.0F)
            verticalLineToRelative(440.0F)
            lineTo(520.0F, 880.0F)
            verticalLineToRelative(-200.0F)
            horizontalLineToRelative(-80.0F)
            verticalLineToRelative(200.0F)
            lineTo(80.0F, 880.0F)

            moveTo(348.0F, 440.0F)
            horizontalLineToRelative(264.0F)
            lineToRelative(-24.0F, -80.0F)
            lineTo(372.0F, 360.0F)
            lineToRelative(-24.0F, 80.0F)

            moveTo(396.0F, 280.0F)
            horizontalLineToRelative(168.0F)
            lineToRelative(-24.0F, -80.0F)
            lineTo(420.0F, 200.0F)
            lineToRelative(-24.0F, 80.0F)

            moveTo(160.0F, 800.0F)
            horizontalLineToRelative(200.0F)
            verticalLineToRelative(-200.0F)
            horizontalLineToRelative(240.0F)
            verticalLineToRelative(200.0F)
            horizontalLineToRelative(200.0F)
            verticalLineToRelative(-200.0F)
            lineTo(660.0F, 600.0F)
            lineToRelative(-24.0F, -80.0F)
            lineTo(324.0F, 520.0F)
            lineToRelative(-24.0F, 80.0F)
            lineTo(160.0F, 600.0F)
            verticalLineToRelative(200.0F)

            moveTo(480.0F, 500.0F)
            close()
        }.build()
        return _pyramid!!
    }
private var _pyramid: ImageVector? = null
