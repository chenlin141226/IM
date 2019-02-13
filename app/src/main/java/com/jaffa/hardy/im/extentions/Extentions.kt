package com.jaffa.hardy.im.extentions /**
 * 正则表达式：验证密码
 */
val REGEX_PASSWORD = "^[a-zA-Z0-9]{6,20}$"

/**
 * 正则表达式：验证手机号
 */
val REGEX_TEL = "^((17[0-9])|(14[0-9])|(13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$"

fun String.isValidUserName():Boolean = this.matches(Regex("^[a-zA-Z]\\w{2,19}"))

fun String.isValidPassword():Boolean = this.matches(Regex("^[0-9]{3,20}"))