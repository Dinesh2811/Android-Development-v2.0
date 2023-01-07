package com.dinesh.android.root

import android.util.Log
import com.dinesh.android.java.activity.GoTo_Class
import com.dinesh.android.java.activity.LayoutInflater_Class
import com.dinesh.android.java.android_lifecycle.a.MainActivity

object RvData {
    private val rvParentModelList = ArrayList<RvParentModel>()
    private var childTitle = ArrayList<String>()
    private var childClassName = ArrayList<Class<*>>()
    private var childDescription = ArrayList<String>()

    private fun initializeData(){
        childTitle = arrayListOf("GoTo_Class", "LayoutInflater_Class")
        childClassName = arrayListOf(GoTo_Class::class.java, LayoutInflater_Class::class.java)
        childDescription = arrayListOf("Description -> GoTo_Class")
        setRvParentModelList(parentPackageName = "Activity",rvChildModelList = setRvChildModelList(childTitle,childClassName, descriptionList = childDescription))

        childTitle = arrayListOf("Basic", "Live", "View Model", "Room v1.0 (Hidden)")
        childClassName = arrayListOf(
            com.dinesh.android.java.android_lifecycle.a.MainActivity::class.java,
            com.dinesh.android.java.android_lifecycle.live_data.MainActivity::class.java,
            com.dinesh.android.java.android_lifecycle.view_model.MainActivity::class.java,
            com.dinesh.android.MainActivity::class.java
        )
        setRvParentModelList(parentPackageName = "Android Lifecycle", rvChildModelList = setRvChildModelList(childTitle, childClassName))

    }

    fun rvList(): ArrayList<RvParentModel> {
        if (rvParentModelList.isEmpty()) {
            initializeData()
        }
        return rvParentModelList
    }

    private fun setRvParentModelList(parentPackageName: String = "Activity Test", rvChildModelList: ArrayList<RvChildModel> = ArrayList()): ArrayList<RvParentModel> {
        if (parentPackageName.isNotEmpty() && rvChildModelList.isNotEmpty() ){
            rvParentModelList.add(RvParentModel(parentPackageName,rvChildModelList))
        }
        return rvParentModelList
    }

    private fun setRvChildModelList(stringList: ArrayList<String>, className: ArrayList<Class<*>>, descriptionList: ArrayList<String> = ArrayList()): ArrayList<RvChildModel> {
        val rvChildModelList = ArrayList<RvChildModel>()
        if (stringList.isNotEmpty()) {
            var i = 0
            stringList.forEach { rvChildModelTitle ->
                if (className.size < stringList.size){ className.add(Class.forName(com.dinesh.android.MainActivity::class.java.name)) }
                if (descriptionList.size < stringList.size){ descriptionList.add("Yet to add description") }
                val existingChild = rvChildModelList.find { it.title == rvChildModelTitle }
                if (existingChild == null) {
                    rvChildModelList.add(RvChildModel(title = rvChildModelTitle, className = className[i], description = descriptionList[i]))
                    i++
                } } }
        return rvChildModelList
    }

}













/*




object RvData {

//    private val rvParentModelList = ArrayList<RvParentModel>()
//    private val rvChildModelList = ArrayList<RvChildModel>()

    fun rvList(): ArrayList<RvParentModel> {
        return parentList(ArrayList())
    }

    private fun parentList(rvParentModelList: ArrayList<RvParentModel>): ArrayList<RvParentModel> {
//        rvParentModelList.add(RvParentModel("Activity", childList1(ArrayList())))
//        rvParentModelList.add(RvParentModel("Android Lifecycle", childList2(ArrayList())))
//
//        return rvParentModelList

        rvParentModelList.add(
            RvParentModel(
                "Activity", setRvChildModelList(
                    arrayListOf("GoTo_Class", "LayoutInflater_Class"),
                    arrayListOf(GoTo_Class::class.java, LayoutInflater_Class::class.java),
                    arrayListOf("Description -> GoTo_Class")
                )
            )
        )
        rvParentModelList.add(
            RvParentModel(
                "Android Lifecycle", setRvChildModelList(
                    arrayListOf("Basic", "Live Data", "View Model", "Room v1.0 (Hidden)"),
                    arrayListOf(
                        MainActivity::class.java,
                        com.dinesh.android.java.android_lifecycle.live_data.MainActivity::class.java,
                        com.dinesh.android.java.android_lifecycle.view_model.MainActivity::class.java,
                        com.dinesh.android.MainActivity::class.java
                    )
                )
            )
        )
        return rvParentModelList
    }


    fun setRvChildModelList(stringList: ArrayList<String>, className: ArrayList<Class<*>>, descriptionList: ArrayList<String> = ArrayList()): ArrayList<RvChildModel> {
        val rvChildModelList = ArrayList<RvChildModel>()
        var i = 0
        stringList.forEach {
            if (className.size < stringList.size){ className.add(Class.forName(com.dinesh.android.MainActivity::class.java.name)) }
            if (descriptionList.size < stringList.size){ descriptionList.add("Yet to add description") }
            rvChildModelList.add(RvChildModel(title = it, className = className[i], description = descriptionList[i]))
            i++
        }
        return rvChildModelList
    }


    internal fun childList1(rvChildModelList: ArrayList<RvChildModel>): ArrayList<RvChildModel> {
        rvChildModelList.add(RvChildModel(Class.forName(GoTo_Class::class.java.name), "GoTo_Class"))
        rvChildModelList.add(RvChildModel(Class.forName(LayoutInflater_Class::class.java.name), "LayoutInflater_Class"))

        return rvChildModelList
    }

    internal fun childList2(rvChildModelList: ArrayList<RvChildModel>): ArrayList<RvChildModel> {
        rvChildModelList.add(RvChildModel(Class.forName(com.dinesh.android.java.android_lifecycle.a.MainActivity::class.java.name), "Basic"))
        rvChildModelList.add(RvChildModel(Class.forName(com.dinesh.android.java.android_lifecycle.live_data.MainActivity::class.java.name), "Live Data"))
        rvChildModelList.add(RvChildModel(Class.forName(com.dinesh.android.java.android_lifecycle.view_model.MainActivity::class.java.name), "View Model"))
        rvChildModelList.add(RvChildModel(title = "Room v1.0 (Hidden)"))

        return rvChildModelList
    }


}


*/


/*

//fun ArrayList<RvParentModel>.rvList(rvParentModelList: ArrayList<RvParentModel>): ArrayList<RvParentModel>{
//return arrayListOf(
//        RvParentModel("Activity", RvData.childList1(ArrayList())),
//        RvParentModel("Android Lifecycle", RvData.childList2(ArrayList())))
//}
fun ArrayList<RvParentModel>.rvParentList(rvParentModelList: ArrayList<RvParentModel>): ArrayList<RvParentModel>{
    val rvChildModelList = ArrayList<RvChildModel>()

    return arrayListOf(
        RvParentModel("Activity", rvChildModelList.rvChildList()),
        RvParentModel("Android Lifecycle", RvData.childList2(ArrayList()))
    )
}


fun ArrayList<RvChildModel>.rvChildList(): ArrayList<RvChildModel>{
//    return arrayListOf(
//        RvChildModel(Class.forName(GoTo_Class::class.java.name), "GoTo_Class")
//    )
    var rvChildModelList = ArrayList<RvChildModel>()
//    rvChildModelList = arrayListOf(RvChildModel(Class.forName(GoTo_Class::class.java.name), "GoTo_Class"))
    rvChildModelList.add(RvChildModel(Class.forName(GoTo_Class::class.java.name), "GoTo_Class"))

    return rvChildModelList
}


 */


////v1.0
//object RvData {
//    private val rvParentModelList = ArrayList<RvParentModel>()
//
//    init {
//        rvParentModelList.add(RvParentModel("Activity", childList(
//            "GoTo_Class" to GoTo_Class::class.java,
//            "LayoutInflater_Class" to LayoutInflater_Class::class.java
//        )))
//        rvParentModelList.add(RvParentModel("Android Lifecycle", childList(
//            "Basic" to com.dinesh.android.java.android_lifecycle.a.MainActivity::class.java,
//            "Live Data" to com.dinesh.android.java.android_lifecycle.live_data.MainActivity::class.java,
//            "View Model" to com.dinesh.android.java.android_lifecycle.view_model.MainActivity::class.java,
//            "Room v1.0 (Hidden)" to null
//        )))
//    }
//
//    fun rvList() = rvParentModelList
//
//    private fun childList(vararg items: Pair<String, Class<*>?>): ArrayList<RvChildModel> {
//        val rvChildModelList = ArrayList<RvChildModel>()
//        for ((title, className) in items) {
//            rvChildModelList.add(RvChildModel(className!!, title))
//        }
//        return rvChildModelList
//    }
//}


////v2.0
//object RvData {
//    val rvList: ArrayList<RvParentModel>
//        get() {
//            val rvParentModelList = ArrayList<RvParentModel>()
//            rvParentModelList.add(RvParentModel("Activity", childList(
//                RvChildModel(Class.forName(GoTo_Class::class.java.name), "GoTo_Class"),
//                RvChildModel(Class.forName(LayoutInflater_Class::class.java.name), "LayoutInflater_Class")
//            )))
//            rvParentModelList.add(RvParentModel("Android Lifecycle", childList(
//                RvChildModel(Class.forName(com.dinesh.android.java.android_lifecycle.a.MainActivity::class.java.name), "Basic"),
//                RvChildModel(Class.forName(com.dinesh.android.java.android_lifecycle.live_data.MainActivity::class.java.name), "Live Data"),
//                RvChildModel(Class.forName(com.dinesh.android.java.android_lifecycle.view_model.MainActivity::class.java.name), "View Model"),
//                RvChildModel(title = "Room v1.0 (Hidden)")
//            )))
//            return rvParentModelList
//        }
//
//    private fun childList(vararg children: RvChildModel): ArrayList<RvChildModel> {
//        val rvChildModelList = ArrayList<RvChildModel>()
//        rvChildModelList.addAll(children)
//        return rvChildModelList
//    }
//}


////v3.0
//object RvData {
//    fun rvList(): ArrayList<RvParentModel> {
//        val rvParentModelList = ArrayList<RvParentModel>()
//        rvParentModelList.add(RvParentModel("Activity", childList("GoTo_Class", "LayoutInflater_Class")))
//        rvParentModelList.add(RvParentModel("Android Lifecycle", childList("Basic", "Live Data", "View Model", "Room v1.0 (Hidden)")))
//        return rvParentModelList
//    }
//
//    private fun childList(vararg titles: String): ArrayList<RvChildModel> {
//        val rvChildModelList = ArrayList<RvChildModel>()
//        for (title in titles) {
//            val className = when (title) {
//                "GoTo_Class" -> Class.forName(GoTo_Class::class.java.name)
//                "LayoutInflater_Class" -> Class.forName(LayoutInflater_Class::class.java.name)
//                "Basic" -> Class.forName(com.dinesh.android.java.android_lifecycle.a.MainActivity::class.java.name)
//                "Live Data" -> Class.forName(com.dinesh.android.java.android_lifecycle.live_data.MainActivity::class.java.name)
//                "View Model" -> Class.forName(com.dinesh.android.java.android_lifecycle.view_model.MainActivity::class.java.name)
//                else -> null
//            }
//            rvChildModelList.add(RvChildModel(className!!, title))
//        }
//        return rvChildModelList
//    }
//}


////v4.0
//object RvData {
//    fun rvList(): ArrayList<RvParentModel> {
//        val rvParentModelList = ArrayList<RvParentModel>()
//        rvParentModelList.add(RvParentModel("Activity", childList("GoTo_Class", "LayoutInflater_Class")))
//        rvParentModelList.add(RvParentModel("Android Lifecycle", childList("Basic", "Live Data", "View Model", "Room v1.0 (Hidden)")))
//        return rvParentModelList
//    }
//
//    private fun childList(vararg titles: String): ArrayList<RvChildModel> {
//        val rvChildModelList = ArrayList<RvChildModel>()
//        for (title in titles) {
//            val className = getClassName(title)
//            rvChildModelList.add(RvChildModel(className!!, title))
//        }
//        return rvChildModelList
//    }
//
//    private fun getClassName(title: String): Class<*>? {
//        return when (title) {
//            "GoTo_Class" -> Class.forName(GoTo_Class::class.java.name)
//            "LayoutInflater_Class" -> Class.forName(LayoutInflater_Class::class.java.name)
//            "Basic" -> Class.forName(com.dinesh.android.java.android_lifecycle.a.MainActivity::class.java.name)
//            "Live Data" -> Class.forName(com.dinesh.android.java.android_lifecycle.live_data.MainActivity::class.java.name)
//            "View Model" -> Class.forName(com.dinesh.android.java.android_lifecycle.view_model.MainActivity::class.java.name)
//            else -> null
//        }
//    }
//}


/*


object RvData {

     fun rvList(): ArrayList<RvParentModel> {
         return parentList(ArrayList())
    }

    private fun parentList(rvParentModelList: ArrayList<RvParentModel>): ArrayList<RvParentModel> {
        rvParentModelList.add(RvParentModel("Activity", childList1(ArrayList())))
        rvParentModelList.add(RvParentModel("Android Lifecycle", childList2(ArrayList())))

        return rvParentModelList
    }

    private fun childList1(rvChildModelList: ArrayList<RvChildModel>): ArrayList<RvChildModel> {
        rvChildModelList.add(RvChildModel(Class.forName(GoTo_Class::class.java.name), "GoTo_Class"))
        rvChildModelList.add(RvChildModel(Class.forName(LayoutInflater_Class::class.java.name), "LayoutInflater_Class"))

        return rvChildModelList
    }

    private fun childList2(rvChildModelList: ArrayList<RvChildModel>): ArrayList<RvChildModel> {
        rvChildModelList.add(RvChildModel(Class.forName(com.dinesh.android.java.android_lifecycle.a.MainActivity::class.java.name), "Basic"))
        rvChildModelList.add(RvChildModel(Class.forName(com.dinesh.android.java.android_lifecycle.live_data.MainActivity::class.java.name), "Live Data"))
        rvChildModelList.add(RvChildModel(Class.forName(com.dinesh.android.java.android_lifecycle.view_model.MainActivity::class.java.name), "View Model"))
        rvChildModelList.add(RvChildModel(title = "Room v1.0 (Hidden)"))

        return rvChildModelList
    }

}



 */