package com.winphyoethu.pocketo.presentation.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
fun ExpenseItem(
    expenseTitle: String,
    expenseDate: String,
    expenseAmount: String,
    expenseIcon: ImageVector,
) {

    ConstraintLayout(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
    ) {

        val (icon, title, date, amount) = createRefs()

        Icon(
            expenseIcon,
            contentDescription = "transaction",
            modifier = Modifier
                .height(32.dp)
                .width(32.dp)
                .constrainAs(icon) {
                    start.linkTo(parent.start)
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                }
        )
        Text(
            text = expenseTitle, modifier = Modifier
                .constrainAs(title) {
                    start.linkTo(icon.end)
                    top.linkTo(icon.top)
                }
                .padding(16.dp, 0.dp, 0.dp, 0.dp),
            style = MaterialTheme.typography.titleSmall
        )
        Text(
            text = expenseDate,
            fontSize = 11.sp,
            modifier = Modifier
                .constrainAs(date) {
                    start.linkTo(icon.end)
                    top.linkTo(title.bottom)
                }
                .padding(16.dp, 4.dp, 0.dp, 0.dp)
        )
        Text(
            text = expenseAmount,
            fontWeight = FontWeight.Bold,
            color = Color.Red, modifier = Modifier
                .constrainAs(amount) {
                    end.linkTo(parent.end)
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                })
    }

}