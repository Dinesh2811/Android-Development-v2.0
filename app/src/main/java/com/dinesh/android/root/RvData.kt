package com.dinesh.android.root

import com.dinesh.android.java.activity.GoTo_Class
import com.dinesh.android.java.activity.LayoutInflater_Class
import com.dinesh.android.java.android_lifecycle.a.MainActivity


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