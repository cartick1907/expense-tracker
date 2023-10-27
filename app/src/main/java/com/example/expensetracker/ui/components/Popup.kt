package com.example.expensetracker.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.magnifier
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.expensetracker.viewModels.ExpenseViewModel

@Composable
fun Popup(onDismiss:()->Unit,
          onConfirm:()->Unit){
    var viewModel: ExpenseViewModel = viewModel()
    Dialog(onDismissRequest = {
        onDismiss()
    }) {
        Card(
            colors = CardDefaults.cardColors(Color.White, Color.Black),
            modifier = Modifier
                .fillMaxWidth(),
            shape = RoundedCornerShape(10.dp)
        ){
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text="Add Expense",
                    Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(5.dp)
                )
                var desc by remember {
                    mutableStateOf("")
                }
                var value by remember {
                    mutableStateOf("")
                }
                TextField(
                    value =desc,
                    onValueChange = {
                        desc=it
                    },
                    label = { Text("Description") },
                    singleLine = true,
                    modifier = Modifier.padding(10.dp),

                    )
                TextField(
                    value =value,
                    onValueChange = {
                                    value=it
                    },
                    label = { Text("Value (in Rs)") },
                    singleLine = true,
                    modifier = Modifier.padding(10.dp),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Phone,
                        imeAction = ImeAction.Done,
                    ),

                    )
                Button(onClick = {
                                 viewModel
                    },
                    modifier= Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(10.dp)
                ) {
                    Text("Add")
                }
            }



        }
    }
}