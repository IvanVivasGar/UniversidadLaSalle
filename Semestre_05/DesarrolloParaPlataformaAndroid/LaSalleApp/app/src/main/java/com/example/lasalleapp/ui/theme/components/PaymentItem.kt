package com.example.lasalleapp.ui.theme.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lasalleapp.models.Payment
import com.example.lasalleapp.ui.theme.utils.Check_circle
import com.example.lasalleapp.ui.theme.utils.Credit_card
import com.example.lasalleapp.ui.theme.utils.MagnifyingGlass
import com.example.lasalleapp.ui.theme.utils.Pending_actions
import com.example.lasalleapp.ui.theme.utils.payments

@Composable
fun PaymentItem(payment: Payment){
    Box(
        modifier = Modifier.fillMaxWidth()
            .background(MaterialTheme.colorScheme.background)
            .padding(top = 10.dp, start = 10.dp, end = 10.dp, bottom = 5.dp)
    ){
        Column (
            modifier = Modifier.fillMaxWidth()
                .height(230.dp)
                .background(Color.LightGray)
        ){
            Row(
                modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween
            ){
                Text(text = "Primer Pago",
                    fontStyle = MaterialTheme.typography.titleLarge.fontStyle,
                    fontWeight = MaterialTheme.typography.titleLarge.fontWeight,
                    fontSize = MaterialTheme.typography.titleLarge.fontSize,
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.padding(top = 10.dp, start = 10.dp))

                if(payment.paid){
                    Icon(
                        imageVector = Check_circle,
                        contentDescription = "paid",
                        modifier = Modifier.size(40.dp).padding(top = 10.dp, end = 10.dp),
                        tint = Color.DarkGray)
                }else{
                    Icon(
                        imageVector = Pending_actions,
                        contentDescription = "not paid",
                        modifier = Modifier.size(40.dp).padding(top = 10.dp, end = 10.dp),
                        tint = MaterialTheme.colorScheme.error)
                }
            }

            Text(text = "Folio: " + payment.id.toString(),
                fontStyle = MaterialTheme.typography.titleMedium.fontStyle,
                fontWeight = MaterialTheme.typography.titleLarge.fontWeight,
                fontSize = MaterialTheme.typography.titleMedium.fontSize,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.padding(top = 10.dp, start = 10.dp))

            Column (
                modifier = Modifier.fillMaxSize()
                    .padding(top = 10.dp)
                    .background(MaterialTheme.colorScheme.background)
            ){
                Row (
                    modifier = Modifier.fillMaxWidth().weight(1f)
                ){
                    Column (
                        modifier = Modifier.fillMaxHeight().weight(1f),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
                    ){
                        Text(
                            text = "Periodo",
                            fontStyle = MaterialTheme.typography.titleMedium.fontStyle,
                            fontWeight = MaterialTheme.typography.titleMedium.fontWeight,
                            fontSize = MaterialTheme.typography.titleMedium.fontSize)
                        Text(
                            text = payment.period,
                            fontStyle = MaterialTheme.typography.titleMedium.fontStyle,
                            fontWeight = MaterialTheme.typography.titleLarge.fontWeight,
                            fontSize = MaterialTheme.typography.titleMedium.fontSize)
                    }

                    Row(
                        modifier = Modifier.fillMaxHeight()
                            .weight(1f)
                            .background(MaterialTheme.colorScheme.primary)
                            .clickable {  },
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = androidx.compose.ui.Alignment.CenterVertically
                    ){
                        Icon(
                            imageVector = MagnifyingGlass,
                            contentDescription = "text",
                            modifier = Modifier.size(40.dp)
                                .padding(end = 15.dp),
                            tint = MaterialTheme.colorScheme.background
                        )
                        Text(
                            text = "Ver recibo",
                            fontStyle = MaterialTheme.typography.titleMedium.fontStyle,
                            fontWeight = MaterialTheme.typography.titleLarge.fontWeight,
                            fontSize = MaterialTheme.typography.titleMedium.fontSize,
                            color = MaterialTheme.colorScheme.background)
                    }
                }

                Row (
                    modifier = Modifier.fillMaxWidth().weight(1f)
                ){
                    Column (
                        modifier = Modifier.fillMaxHeight().weight(1f),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
                    ){
                        Text(
                            text = "Vencimiento",
                            fontStyle = MaterialTheme.typography.titleMedium.fontStyle,
                            fontWeight = MaterialTheme.typography.titleMedium.fontWeight,
                            fontSize = MaterialTheme.typography.titleMedium.fontSize)
                        Text(
                            text = payment.dueDate,
                            fontStyle = MaterialTheme.typography.titleMedium.fontStyle,
                            fontWeight = MaterialTheme.typography.titleLarge.fontWeight,
                            fontSize = MaterialTheme.typography.titleMedium.fontSize)
                    }

                    Row(
                        modifier = Modifier.fillMaxHeight()
                            .weight(1f)
                            .background(MaterialTheme.colorScheme.error)
                            .clickable {  },
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = androidx.compose.ui.Alignment.CenterVertically
                    ){
                        if(!payment.paid){
                            Icon(
                                imageVector = Credit_card,
                                contentDescription = "text",
                                modifier = Modifier.size(40.dp)
                                    .padding(end = 15.dp),
                                tint = MaterialTheme.colorScheme.background
                            )
                            Text(
                                text = "Pagar en linea",
                                fontStyle = MaterialTheme.typography.titleMedium.fontStyle,
                                fontWeight = MaterialTheme.typography.titleLarge.fontWeight,
                                fontSize = MaterialTheme.typography.titleMedium.fontSize,
                                color = MaterialTheme.colorScheme.background)
                        }else{
                            Text(
                                text = "Pagado",
                                fontStyle = MaterialTheme.typography.titleMedium.fontStyle,
                                fontWeight = MaterialTheme.typography.titleLarge.fontWeight,
                                fontSize = MaterialTheme.typography.titleMedium.fontSize,
                                color = MaterialTheme.colorScheme.background)
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun PaymentItemPreview(){
    PaymentItem(payment = payments[0])
}