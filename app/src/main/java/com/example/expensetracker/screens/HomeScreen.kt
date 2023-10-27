package com.example.expensetracker.screens

import android.text.Layout.Alignment
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.expensetracker.models.Person
import com.example.expensetracker.ui.components.Popup
import com.example.expensetracker.viewModels.ExpenseViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(){
    var viewModel:ExpenseViewModel = viewModel()
    var data: State<List<Person>> = viewModel.users.collectAsState()
    var actualdata = data.value
    var balance by remember {
        mutableStateOf(1000)
    }
    var user = "Kartik"
    Column(
         modifier = Modifier.fillMaxSize()
    ) {
        Surface(
            shadowElevation = 6.dp,
        ) {
            CenterAlignedTopAppBar(title = {
                Text(text="Welcome Back $user !!")

            })
        }
        Column(
            modifier = Modifier.fillMaxSize(),
        ) {
            Box(modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
                contentAlignment = androidx.compose.ui.Alignment.Center)
            {
                Text(
                    text =balance.toString(),
                    textAlign = TextAlign.Center,
                    color= Color.White,
                    fontSize = 40.sp
                )
            }
            Button(
                onClick = {
                    viewModel.showPopup()
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                ,
            ) {
                Text(text = "Enter Expense")
            }


            if(viewModel.isInputActive){
                Popup(onDismiss = { viewModel.dismissPopup() }
                    , onConfirm = {})
            }

        }

    }
}