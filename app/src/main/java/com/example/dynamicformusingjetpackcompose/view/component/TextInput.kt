package com.example.dynamicformusingjetpackcompose.view.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextInput(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    label: String,
    inputType: KeyboardType = KeyboardType.Text
) {
    val isTypePassword = inputType == KeyboardType.Password;

    val visualTransformation = if (isTypePassword) {
        PasswordVisualTransformation()
    } else {
        VisualTransformation.None
    }
    // use outlinedtextfield as textinput
    OutlinedTextField(
        visualTransformation = visualTransformation,
        keyboardOptions = KeyboardOptions(keyboardType = inputType),
        value = value,
        onValueChange = onValueChange,
        modifier = modifier.fillMaxWidth(),
        label = {
            Text(text = label)
        })
}