package net.propertyApp.designSystem.atoms

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import net.propertyApp.designSystem.tokens.avivColors
import net.propertyApp.designSystem.tokens.avivSpacing
import net.propertyApp.designSystem.tokens.rememberChevronRight

@Composable
fun UpButton(
    label: String,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier.padding(avivSpacing.smallSpacing).clickable { onClick() },
        verticalAlignment = androidx.compose.ui.Alignment.CenterVertically
    ) {
        Icon(
            rememberChevronRight(),
            tint = avivColors.tertiary,
            contentDescription = label,
            modifier = Modifier
                .padding(start = avivSpacing.smallSpacing, end = avivSpacing.smallSpacing)
                .rotate(180f),
        )
        Text(label, color = avivColors.tertiary)
    }
}