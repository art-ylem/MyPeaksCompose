package com.sidorov.mypeakscompose.utils

const val DEFAULT_FLOAT = 0F
const val DEFAULT_DOUBLE = 0.0
const val DEFAULT_INT = 0
const val DEFAULT_LONG = 0L
const val DEFAULT_BOOLEAN = false
const val EMPTY_STRING = ""
const val LINE_BREAK = "\n"
const val SPACE_IN_LINE = " "
const val UNDEFINED_ID = -1L

fun Float?.orDefault() = this ?: DEFAULT_FLOAT
fun Double?.orDefault() = this ?: DEFAULT_DOUBLE
fun Int?.orDefault() = this ?: DEFAULT_INT
fun Long?.orDefault() = this ?: DEFAULT_LONG
fun Boolean?.orDefault() = this ?: DEFAULT_BOOLEAN
fun Boolean.toInt() = if (this) 1 else 0