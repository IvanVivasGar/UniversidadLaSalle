package com.example.lasalleapp.ui.theme.components

import androidx.compose.foundation.background
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
import com.example.lasalleapp.ui.theme.utils.Credit_card
import com.example.lasalleapp.ui.theme.utils.MagnifyingGlass

@Composable
fun PaymentItem(){
    Box(
        modifier = Modifier.fillMaxWidth()
            .background(MaterialTheme.colorScheme.background)
            .padding(top = 10.dp)
    ){
        Column (
            modifier = Modifier.fillMaxWidth()
                .height(230.dp)
                .background(Color.LightGray)
        ){
            Text(text = "Primer Pago",
                fontStyle = MaterialTheme.typography.titleLarge.fontStyle,
                fontWeight = MaterialTheme.typography.titleLarge.fontWeight,
                fontSize = MaterialTheme.typography.titleLarge.fontSize,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.padding(top = 10.dp, start = 10.dp))

            Text(text = "Folio: ",
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
                            fontSize = MaterialTheme.typography.titleMedium.fontSize,
                            color = MaterialTheme.colorScheme.primary)
                        Text(
                            text = "157 - AGO-DIC 2024",
                            fontStyle = MaterialTheme.typography.titleMedium.fontStyle,
                            fontWeight = MaterialTheme.typography.titleLarge.fontWeight,
                            fontSize = MaterialTheme.typography.titleMedium.fontSize,
                            color = MaterialTheme.colorScheme.primary)
                    }

                    Row(
                        modifier = Modifier.fillMaxHeight()
                            .weight(1f)
                            .background(MaterialTheme.colorScheme.primary),
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
                            fontSize = MaterialTheme.typography.titleMedium.fontSize,
                            color = MaterialTheme.colorScheme.primary)
                        Text(
                            text = "octubre 10 de 2024",
                            fontStyle = MaterialTheme.typography.titleMedium.fontStyle,
                            fontWeight = MaterialTheme.typography.titleLarge.fontWeight,
                            fontSize = MaterialTheme.typography.titleMedium.fontSize,
                            color = MaterialTheme.colorScheme.primary)
                    }

                    Row(
                        modifier = Modifier.fillMaxHeight()
                            .weight(1f)
                            .background(MaterialTheme.colorScheme.error),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = androidx.compose.ui.Alignment.CenterVertically
                    ){
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
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun PaymentItemPreview(){
    PaymentItem()
}