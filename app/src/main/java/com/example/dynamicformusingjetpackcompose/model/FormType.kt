package com.example.dynamicformusingjetpackcompose.model

enum class FormType{
  TEXT,
  EMAIL,
  NUMBER,
  PASSWORD
}

data class FormField(var label:String, var type:FormType, var value:String="")