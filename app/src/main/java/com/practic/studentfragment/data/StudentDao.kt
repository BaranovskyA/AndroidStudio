package com.practic.studentfragment.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface StudentDao {

    @Query("SELECT * FROM studententity")
    fun initiateGetStudents(): List<StudentEntity>

    @Query("SELECT * FROM studentsgroupentity")
    fun initiateGetGroups(): List<StudentsGroupEntity>

    @Query("SELECT * FROM studententity WHERE id = :id")
    fun initiateGetStudent(id: Int): StudentEntity

    @Query("SELECT * FROM studentsgroupentity WHERE id = :id")
    fun initiateGetGroup(id: Int): StudentsGroupEntity

    @Query("DELETE FROM studententity")
    fun initiateDeleteStudents()

    @Query("DELETE FROM studentsgroupentity")
    fun initiateDeleteGroups()

    @Query("DELETE FROM studententity WHERE id = :id")
    fun initiateDeleteStudent(id: Int)

    @Query("DELETE FROM studentsgroupentity WHERE id = :id")
    fun initiateDeleteGroup(id: Int)

    @Insert
    fun initiateInsertStudent(student: StudentEntity)

    @Insert
    fun initiateInsertStudents(students: List<StudentEntity>)

    @Insert
    fun initiateInsertGroup(group: StudentsGroupEntity)

    @Insert
    fun initiateInsertGroups(groups: List<StudentsGroupEntity>)

    @Delete
    fun initiateDeleteStudent(student: StudentEntity)

    @Delete
    fun initiateDeleteGroup(group: StudentsGroupEntity)
}