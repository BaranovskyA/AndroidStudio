package com.example.education

class Student {

    var listStudents : ArrayList<String> = arrayListOf<String>("Earl Henderson", "Dylan Newton", "Oliver Simpson", "Morgan Kelley", "Rudolf Gordon", "Gerald Cox", "Benedict Powers", "Brian Clark", "Russell Douglas", "Dale Randall", "Giles Powers", "Austin Watkins", "Shon Wilkerson", "Harold Reed", "Ernest Neal")


    fun sortStudents(): ArrayList<String> {
        listStudents.sort()
        return this.listStudents
    }

    fun randomStudents(): ArrayList<String> {
        listStudents.shuffle()
        return this.listStudents
    }

    fun getAllStudents():ArrayList<String>{
        return listStudents
    }
}