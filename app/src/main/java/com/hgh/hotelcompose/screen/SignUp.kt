package com.hgh.hotelcompose.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.hgh.hotelcompose.Routes
import com.hgh.hotelcompose.ui.theme.Purple200
import com.hgh.hotelcompose.ui.theme.Purple700
import com.hgh.hotelcompose.ui.theme.Red
import com.hgh.hotelcompose.ui.theme.Teal200

@Composable
fun SignUp(navController: NavHostController) {

    Box(modifier = Modifier.fillMaxSize()) {
        ClickableText(
            text = AnnotatedString("Already Have account"),
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(20.dp),
            onClick = { navController.navigate(Routes.Login.route) },
            style = TextStyle(
                fontSize = 14.sp,
                fontFamily = FontFamily.Default,
                textDecoration = TextDecoration.Underline,
                color = Purple700
            )
        )
    }
    Column(
        modifier = Modifier.padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var username by remember { mutableStateOf(TextFieldValue()) }
        var password by remember { mutableStateOf(TextFieldValue()) }
        var confirmPassword by remember { mutableStateOf(TextFieldValue()) }

        var showError by remember { mutableStateOf(false) }
        var passwordsMatch by remember { mutableStateOf(true) }

        Text(text = "Sign Up", style = TextStyle(fontSize = 40.sp))
        Spacer(modifier = Modifier.height(20.dp))
        TextField(
            value = username,
            onValueChange = { username = it },
            label = { Text("Username") },
            isError = showError && username.text.isEmpty()
        )

        Spacer(modifier = Modifier.height(20.dp))
        TextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            isError = showError && password.text.isEmpty()
        )

        Spacer(modifier = Modifier.height(20.dp))
        TextField(
            value = confirmPassword,
            onValueChange = { confirmPassword = it },
            label = { Text("Confirm Password") },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            isError = showError && (confirmPassword.text.isEmpty() || !passwordsMatch)
        )

        Spacer(modifier = Modifier.height(20.dp))
        Box(modifier = Modifier.padding(40.dp, 0.dp, 40.dp, 0.dp)) {
            Button(
                onClick = {
                    if (username.text.isEmpty() || password.text.isEmpty()) {
                        showError = true
                    } else {
                        if (password.text == confirmPassword.text) {
                            // Passwords match, navigate to home screen or perform sign-up logic
                            navController.navigate(Routes.Home.route)
                            println("Username: ${username.text}, Password: ${password.text}, Confirm Password: ${confirmPassword.text}")
                        } else {
                            // Passwords don't match, notify user
                            passwordsMatch = false
                            showError = true
                        }
                    }
                    println("Username: ${username.text}, Password: ${password.text}, Confirm-Password: ${confirmPassword.text}")
                },
                shape = RoundedCornerShape(50.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                Text(text = "SignUp")
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        if (showError) {
            Snackbar(
                modifier = Modifier.padding(16.dp),
                backgroundColor = if (passwordsMatch) Red else Purple200, // Change background color based on passwords match status
                action = {
                    TextButton(onClick = {
                        showError = false
                        passwordsMatch = true // Reset passwords match status when dismissing the Snackbar
                    }) {
                        Text("Dismiss")
                    }
                }
            ) {
                Text(if (passwordsMatch) "Please provide valid input" else "Passwords do not match")
            }
        } }

}

