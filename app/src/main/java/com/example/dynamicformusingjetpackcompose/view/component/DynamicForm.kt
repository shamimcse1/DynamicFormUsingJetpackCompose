package com.example.dynamicformusingjetpackcompose.view.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.dynamicformusingjetpackcompose.model.FormField
import com.example.dynamicformusingjetpackcompose.model.FormType

@Composable
fun DynamicForm(
    formFields: List<FormField>,
    onFormSubmit: (Map<String, String>) -> Unit,
    modifier: Modifier = Modifier
) {
    val formState = remember { mutableStateMapOf<String, String>() }
    Column(modifier = modifier) {
        formFields.forEach { formField ->

            val inputType = when (formField.type) {
                FormType.TEXT -> KeyboardType.Text
                FormType.EMAIL -> KeyboardType.Email
                FormType.NUMBER -> KeyboardType.Number
                FormType.PASSWORD -> KeyboardType.Password
            }

            TextInput(
                value = formState[formField.label] ?: formField.value,
                onValueChange = { formState[formField.label] = it },
                label = formField.label,
                inputType = inputType
            )
        }

        Button(onClick = { onFormSubmit(formState.toMap()) }, modifier = Modifier.padding(top = 20.dp)) {
            Text(text = "Submit")
        }
    }
}