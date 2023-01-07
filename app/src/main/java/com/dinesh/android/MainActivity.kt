package com.dinesh.android

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.dinesh.android.java.activity.GoTo_Class
import com.dinesh.android.java.activity.LayoutInflater_Class
import com.dinesh.android.root.RvChildModel
import com.dinesh.android.root.RvMain
//import com.dinesh.android.root.TestRvData.setClassList
//import com.dinesh.android.root.TestRvData.setRvChildModelList
//import com.dinesh.android.root.TestRvData.setRvParentModelList
//import com.dinesh.android.root.TestRvData.setStringList

private val TAG = "log_" + MainActivity::class.java.name.split(MainActivity::class.java.name.split(".").toTypedArray()[2] + ".").toTypedArray()[1]

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContent {
//            Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
//                RootUI(
//                    "Dinesh"
//                )
//            }
//        }
        var stringList: ArrayList<String> = arrayListOf("stringList", "stringList rfb")

//        fun test(stringList: ArrayList<String>): ArrayList<String>{ return stringList }
//        fun test(stringList: ArrayList<String>): String { return stringList[1] }
//        Log.d(TAG, "onCreate: ${test(arrayListOf("stringList","stringList rfb"))}")
/*

        fun testList(rvChildModelList: ArrayList<RvChildModel>): ArrayList<RvChildModel>{
            return rvChildModelList
        }
        Log.d(TAG, "onCreate: ${testList(
            arrayListOf(RvChildModel(Class.forName(GoTo_Class::class.java.name), "GoTo_Class"),
                RvChildModel(Class.forName(GoTo_Class::class.java.name), "GoTo_Class")
            ))[0]}")

 */

        fun testList(rvChildModelList: ArrayList<RvChildModel>): ArrayList<RvChildModel> {
            return rvChildModelList
        }
//        Log.d(TAG, "onCreate: ${testList(
//            arrayListOf(RvChildModel(Class.forName(GoTo_Class::class.java.name), "GoTo_Class"),
//                RvChildModel(Class.forName(GoTo_Class::class.java.name), "GoTo_Class")
//            ))[0]}")

//        fun test123(stringList: ArrayList<String>): ArrayList<String> {
////            testList(
////                arrayListOf(RvChildModel(Class.forName(GoTo_Class::class.java.name), "GoTo_Class"),
////                    RvChildModel(Class.forName(GoTo_Class::class.java.name), "GoTo_Class")
////                ))[0]
//            return stringList
//        }

//        fun test123(stringList: ArrayList<String>){
//            stringList.forEach {
//                Log.d(TAG, "test123: ${testList(arrayListOf(RvChildModel( title = it)))}")
//            }
//        }
//
//        Log.d(TAG, "onCreate: ${test123(arrayListOf("stringList", "stringList_rfb"))}")


        fun test123(classList: ArrayList<Class<*>>,stringList: ArrayList<String>): ArrayList<RvChildModel> {
            val rvChildModelList = ArrayList<RvChildModel>()
            var i = 0
            stringList.forEach {
                rvChildModelList.add(RvChildModel(title = it, className = classList[i]))
                i++
            }
//            Log.d(TAG, "test123: ${rvChildModelList}")
            return rvChildModelList
        }

        fun getClassName(className: Class<*>): String {
            return className.name
        }

//        fun getClass(className: Class<*>,classString: String = ""): Class<*>? {
//            return Class.forName(className.name)
////            return Class.forName(GoTo_Class::class.java.name)
////            return when (className) {
////                "GoTo_Class" -> Class.forName(GoTo_Class::class.java.name)
////                // Add additional cases for other class names here
////                else -> null
////            }
//        }
//
//        Log.d(TAG, "onCreate: ${getClass(GoTo_Class::class.java)}")



//        fun getClass(className: Class<*>,classString: String = ""): ArrayList<Class<*>> {
////        fun getClass(className: Class<*>,classString: String = ""): Class<*> {
//            val classList = ArrayList<Class<*>>()
//            classList.add(className)
//            return classList
////            return Class.forName(className.name)
//        }


//        Log.d(TAG, "onCreate: ${getClass(GoTo_Class::class.java)}")



        fun getClass(className: ArrayList<Class<*>>,classString: String = ""): ArrayList<Class<*>> {
//        fun getClass(className: Class<*>,classString: String = ""): Class<*> {
            val classList = ArrayList<Class<*>>()
            className.forEach { classList.add(it) }
            return classList
//            return Class.forName(className.name)
        }

//        Log.d(TAG, "onCreate: ${getClass(arrayListOf(
//            GoTo_Class::class.java,
//            LayoutInflater_Class::class.java
//        ))}")




        test123(arrayListOf(
            Class.forName(GoTo_Class::class.java.name),
            Class.forName(LayoutInflater_Class::class.java.name)
        ), arrayListOf("GoTo_Class", "LayoutInflater_Class") )

//        Log.d(TAG, "onCreate: ${test123(arrayListOf(
//            Class.forName(GoTo_Class::class.java.name),
//            Class.forName(LayoutInflater_Class::class.java.name)
//        ), arrayListOf("GoTo_Class", "LayoutInflater_Class") )}")


//        Log.d(TAG, "onCreate: ${test123(
//            stringList = arrayListOf("GoTo_Class", "LayoutInflater_Class"),
//            classList = arrayListOf(
//                Class.forName(GoTo_Class::class.java.name),
//                Class.forName(LayoutInflater_Class::class.java.name)
//            )
//        )}")

//        var stringList1: ArrayList<String> = arrayListOf("GoTo_Class", "LayoutInflater_Class")
//        val className1: ArrayList<Class<*>> = arrayListOf(GoTo_Class::class.java, LayoutInflater_Class::class.java)

        var childClassName: ArrayList<Class<*>>
        var childTitle: ArrayList<String>
        var child = ArrayList<RvChildModel>()

        childTitle = arrayListOf("GoTo_Class", "LayoutInflater_Class")
        childClassName = arrayListOf(GoTo_Class::class.java, LayoutInflater_Class::class.java)
//        setRvChildModelList(setStringList(childTitle), setClassList(childClassName))
//        child.add(RvChildModel(className = childClassName[0], title = childTitle[0]))
//        setRvChildModelList(childModel = child)

        childTitle = arrayListOf("GoTo_Class_1", "LayoutInflater_Class_1")
        childClassName = arrayListOf(GoTo_Class::class.java, LayoutInflater_Class::class.java)
//        setRvChildModelList(setStringList(childTitle), setClassList(childClassName))
//        child.add(RvChildModel(className = childClassName[0], title = childTitle[0]))
//        setRvChildModelList(childModel = child)

//        child.add(RvChildModel(className = setClassList(arrayListOf(GoTo_Class::class.java, LayoutInflater_Class::class.java))[0], title = setStringList(arrayListOf("GoTo_Class_1", "LayoutInflater_Class_1"))[0]))
//        setRvChildModelList(setStringList(childTitle), setClassList(childClassName))
//        setRvChildModelList(childModel = child)

//        Log.d(TAG, "onCreate 2: ${setRvChildModelList()}")
//        Log.e(TAG, "onCreate 2: ${setRvChildModelList().size}")
//
//
//        Log.d(TAG, "setRvParentModelList: ${setRvParentModelList(rvChildModelList = setRvChildModelList())}")




//        Log.e(TAG, "onCreate: ${funParent(stringList1,className1)}")
//        Log.d(TAG, "onCreate: ${rvList()}")
//        Log.d(TAG, "onCreate: ${TestRvData.setRvParentModelList()}")

        startActivity(Intent(this, RvMain::class.java))


//        startActivity(Intent(this, ToolbarMain::class.java))
//        startActivity(Intent(this, com.dinesh.android.kotlin.app.MainActivity::class.java))
//        startActivity(Intent(this, NavMain::class.java))
//        finish()

    }
}

@Composable
fun RootUI(
    name: String = "Android",
    modifier: Modifier = Modifier
) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    RootUI()
}