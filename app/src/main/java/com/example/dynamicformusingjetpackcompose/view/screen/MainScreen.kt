package com.example.dynamicformusingjetpackcompose.view.screen

import android.content.ContentValues.TAG
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.dynamicformusingjetpackcompose.model.FormField
import com.example.dynamicformusingjetpackcompose.model.FormType
import com.example.dynamicformusingjetpackcompose.view.component.DynamicForm

@Composable
fun MainScreen() {
    val data = arrayListOf<String>()
    val context = LocalContext.current
    val formFields = listOf<FormField>(
        FormField(label="Name", value = "", type = FormType.TEXT),
        FormField(label="Email", value = "", type = FormType.EMAIL),
        FormField(label="Number", value = "", type = FormType.NUMBER),
        FormField(label="Password", value = "", type = FormType.PASSWORD)
    )
    Column(modifier = Modifier.padding(20.dp)) {
        DynamicForm(formFields = formFields, onFormSubmit = {
            Log.e(TAG, "Data Form: ${it.keys},${it.values}", )
            data.add(it.values.toString())
        })
    }


}