package com.dinesh.android.root

data class RvChildModel(
    val className: Class<*> = Class.forName(com.dinesh.android.MainActivity::class.java.name),
    var title: String = "Title not defined",
    var description: String = "Yet to add description for RvChildModel",
    var version: Float = 2.0f,
    var isExpandable: Boolean = false
)
