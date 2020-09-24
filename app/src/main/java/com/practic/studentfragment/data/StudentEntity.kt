package com.practic.studentfragment.data

import androidx.room.*
import androidx.room.ForeignKey.CASCADE
import com.google.gson.annotations.SerializedName

@Entity(
    foreignKeys = [ForeignKey(
        entity = StudentsGroupEntity::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("groupId"),
        onDelete = CASCADE
    )]
)
class StudentEntity {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

    @ColumnInfo(index = true)
    var groupId: Int = 0

    @SerializedName("name")
    var name: String = ""
}