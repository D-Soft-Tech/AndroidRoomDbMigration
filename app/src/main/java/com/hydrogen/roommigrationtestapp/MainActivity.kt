package com.hydrogen.roommigrationtestapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hydrogen.roommigrationtestapp.presentation.viewModel.UserViewModel
import com.hydrogen.roommigrationtestapp.ui.theme.RoomMigrationTestAppTheme
import com.hydrogen.roommigrationtestapp.utils.di.UserViewModelFactory

class MainActivity : ComponentActivity() {
        private val viewModel: UserViewModel by viewModels {
        UserViewModelFactory(this)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RoomMigrationTestAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    UserContact(Modifier.padding(top = 15.dp)) { name, address, phoneNumber, age ->
                        viewModel.saveUser(name, address, phoneNumber, age)
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
fun UserContact(
    modifier: Modifier = Modifier,
    saveUser: (name: String, address: String, phoneNumber: String, age: Int) -> Unit
) {
    var userName by remember { mutableStateOf("") }
    Surface {
        Box(contentAlignment = Alignment.TopCenter, modifier = modifier.fillMaxSize()) {
            Column(
                modifier
                    .fillMaxWidth()
                    .padding(15.dp), horizontalAlignment = Alignment.CenterHorizontally
            ) {
                OutlinedTextField(
                    value = userName,
                    onValueChange = {
                        userName = it
                    },
                    label = {
                        Text(text = stringResource(id = R.string.name))
                    },
                    modifier = modifier
                )

                Spacer(modifier = modifier.height(10.dp))
                var address by remember { mutableStateOf("") }
                OutlinedTextField(value = address, onValueChange = {
                    address = it
                }, label = { Text(text = stringResource(id = R.string.address)) })

                Spacer(modifier = modifier.height(10.dp))
                var phoneNumber by remember { mutableStateOf("") }
                OutlinedTextField(
                    value = phoneNumber,
                    onValueChange = {
                        phoneNumber = it
                    },
                    label = { Text(text = stringResource(id = R.string.phone_number)) }
                )

                Spacer(modifier = modifier.height(10.dp))
                var age by remember { mutableIntStateOf(0) }
                OutlinedTextField(value = age.toString(), onValueChange = {
                    age = it.toInt()
                }, label = {
                    Text(text = stringResource(id = R.string.user_age))
                })

                Spacer(modifier = modifier.height(10.dp))
                OutlinedButton(onClick = {
                    saveUser.invoke(userName, address, phoneNumber, age)
                }) {
                    Text(text = stringResource(id = R.string.saveUser))
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun UserContactPreview() {
    RoomMigrationTestAppTheme {
        UserContact(saveUser = { _, address, _, _ ->
            Log.d("RESULT", address)
        })
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    RoomMigrationTestAppTheme {
        Greeting("Android")
    }
}