package com.practic.studentfragment.domain

import android.graphics.Bitmap
import android.os.Parcel
import android.os.Parcelable

class Student() : Parcelable {

    var name: String? = ""
    var description: String? = ""
    var image: Bitmap? = null

    constructor(name: String?, description: String?, image: Bitmap) : this() {
        this.name = name
        this.description = description
        this.image = image
    }

    constructor(parcel: Parcel) : this() {
        name = parcel.readString().toString()
        image = parcel.readValue(Bitmap::class.java.classLoader) as? Bitmap
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(p0: Parcel?, p1: Int) {
        p0?.writeString(name)
        p0?.writeValue(image)
    }

    companion object CREATOR : Parcelable.Creator<Student> {
        override fun createFromParcel(parcel: Parcel): Student {
            return Student(parcel)
        }

        override fun newArray(size: Int): Array<Student?> {
            return arrayOfNulls(size)
        }
    }

    override fun toString(): String {
        return "Image: $image"
    }


}