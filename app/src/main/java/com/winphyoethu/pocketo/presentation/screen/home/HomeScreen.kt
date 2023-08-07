package com.winphyoethu.pocketo.presentation.screen.home

import android.graphics.drawable.shapes.OvalShape
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowCircleDown
import androidx.compose.material.icons.filled.ArrowCircleUp
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.rounded.ArrowCircleUp
import androidx.compose.material.icons.rounded.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import com.winphyoethu.pocketo.R
import com.winphyoethu.pocketo.presentation.component.ExpenseItem
import com.winphyoethu.pocketo.presentation.component.IncomeExpenseCard
import com.winphyoethu.pocketo.presentation.component.PocketoBottomNavigation
import com.winphyoethu.pocketo.ui.theme.typography

data class SampleExpense(
    val expenseTitle: String,
    val expenseDate: String,
    val expenseAmount: String,
    val expenseIcon: ImageVector
)

@Preview
@Composable
fun HomeScreen() {

    val expenseItemList = listOf(
        SampleExpense("Phone Bill", "4 Apr 2023", "- 2300", Icons.Rounded.ArrowCircleUp),
        SampleExpense("Rent Fee", "4 Apr 2023", "- 8000", Icons.Filled.ArrowCircleUp),
        SampleExpense("Internet Bill", "4 Apr 2023", "- 250", Icons.Filled.ArrowCircleUp),
        SampleExpense("Shopping Saturday", "4 Apr 2023", "- 400", Icons.Filled.ArrowCircleUp),
        SampleExpense("Shopping Central", "4 Apr 2023", "- 1000", Icons.Filled.ArrowCircleUp),
        SampleExpense("Shopping Central", "4 Apr 2023", "- 1000", Icons.Filled.ArrowCircleUp),
        SampleExpense("Shopping Central", "4 Apr 2023", "- 1000", Icons.Filled.ArrowCircleUp),
        SampleExpense("Shopping Central", "4 Apr 2023", "- 1000", Icons.Filled.ArrowCircleUp)
    )

    Column {
        // Title
        Text(
            text = "My wallet",
            modifier = Modifier.padding(16.dp),
            style = MaterialTheme.typography.headlineLarge
        )

        // Balance Card
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            elevation = CardDefaults.elevatedCardElevation(4.dp),
            border = BorderStroke(4.dp, Color.Transparent),
            colors = CardDefaults.cardColors(),
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.pocketo_background),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxWidth()
                )
                Column {
                    Text(
                        text = "Total Balance",
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .padding(0.dp, 16.dp, 0.dp, 0.dp),
                        color = MaterialTheme.colorScheme.onPrimary,
                        style = MaterialTheme.typography.labelLarge
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "$ 5,500.00",
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .padding(0.dp, 0.dp, 0.dp, 16.dp),
                        color = MaterialTheme.colorScheme.onPrimary,
                        style = MaterialTheme.typography.titleLarge
                    )
                }
            }
        }

        // Income, Expense Card
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 0.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            IncomeExpenseCard(
                cardTitle = "Total Income",
                iconId = R.drawable.arrow_down,
                amount = "$ 10,000",
                modifier = Modifier
                    .padding(0.dp, 0.dp, 4.dp, 0.dp)
                    .fillMaxWidth()
                    .weight(1f)
            )
            IncomeExpenseCard(
                cardTitle = "Total Expense",
                iconId = R.drawable.arrow_up,
                amount = "$ 4,500",
                modifier = Modifier
                    .padding(4.dp, 0.dp, 0.dp, 0.dp)
                    .fillMaxWidth()
                    .weight(1f)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Transaction
        Card(
            border = BorderStroke(8.dp, MaterialTheme.colorScheme.secondaryContainer),
            modifier = Modifier
                .fillMaxHeight(),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondaryContainer)
        ) {
            Text(
                text = "Expenses",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(12.dp)
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState())
            ) {
                expenseItemList.forEach {
                    ExpenseItem(
                        expenseTitle = it.expenseTitle,
                        expenseDate = it.expenseDate,
                        expenseAmount = it.expenseAmount,
                        expenseIcon = it.expenseIcon
                    )
                }
            }
        }
    }

}