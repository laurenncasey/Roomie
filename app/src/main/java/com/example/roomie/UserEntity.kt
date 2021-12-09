package com.example.roomie


import java.io.Serializable;
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


    @Entity
    class UserEntity: Serializable {
        /*
    * Getters and Setters
    * */
        @PrimaryKey(autoGenerate = true)
        var id = 0

        @ColumnInfo(name = "username")
        var username: String? = null

        @ColumnInfo(name = "password")
        var password: String? = null

        @ColumnInfo(name = "profilepic")//before writing to table need to break the profile pic into a byte array
        var profilepic: ByteArray? = null

        @ColumnInfo(name = "fullname")
        var fullname: String? = null

        @ColumnInfo(name = "gender")//female = 0, male = 1, other = -1
        var gender: Int? = null

        @ColumnInfo(name = "lgbt")//true = lgbt, false = non-lgbt
        var lgbt: Boolean? = null

        @ColumnInfo(name = "major")
        var major: String? = null

        @ColumnInfo(name = "bio")
        var bio: String? = null

        /**
         * Aspensen Morganson = 0
         * Oak Ridge = 1
         * Chancellors = 2
         * Govenors = 3
         * Horan = 4
         * Bridgeman = 5
         * Murray = 6
         * Towers N = 7
         * Towers S = 8
         * Suites = 9
         *
         * Applicable for dorm1, 2, 3
         */
        @ColumnInfo(name = "dorm1")
        var dorm1: Int? = null

        @ColumnInfo(name = "dorm2")
        var dorm2: Int? = null

        @ColumnInfo(name = "dorm3")
        var dorm3: Int? = null

        @ColumnInfo(name = "clean")//clean = 0, non-clean=1, in between = -1
        var clean: Int? = null

        @ColumnInfo(name = "waketime")//morning person = 0, night person=1, in between = -1
        var waketime: Int? = null

        @ColumnInfo(name = "pets")//has pet = true, no pet = false
        var pets: Boolean? = null

        @ColumnInfo(name = "smoking")//smoker = true, non smoker = false
        var smoking: Boolean? = null

        @ColumnInfo(name = "alcohol")//drinker = true, non drinker = false
        var alcohol: Boolean? = null

        @ColumnInfo(name = "introvert")//introvert = 0, extrovert=1, in between = -1
        var introvert: Int? = null

        @ColumnInfo(name = "email")
        var email: String? = null

        fun getID(): Int {
            return id
        }

        fun setID(id: Int) {
            this.id = id
        }

        fun getUserName(): String? {
            return username
        }

        fun setUserName(username: String) {
            this.username = username
        }

        fun getPwd(): String? {
            return password
        }

        fun setPwd(password: String) {
            this.password = password
        }
        /*
        fun getProfilePic(): String? {
            return profilepic
        }

        fun setProfilePic(profilepic: String) {
            this.profilepic = profilepic
        }

         */

        fun getFullName(): String? {
            return fullname
        }

        fun setFullName(fullname: String) {
            this.fullname = fullname
        }

        fun getUserEmail(): String? {
            return email
        }

        fun setUserEmail(email: String) {
            this.email = email
        }
        fun getGend(): Int?{
            return gender
        }
        fun setGend(gender: Int){
            this.gender = gender
        }
        fun getLGBT(): Boolean? {
            return lgbt
        }
        fun setLGBT(lgbt: Boolean){
            this.lgbt = lgbt
        }
        fun getMjr(): String?{
            return major
        }
        fun setMjr(major: String){
            this.major = major
        }
        fun getBiography(): String?{
            return bio
        }
        fun setBiography(bio: String){
            this.bio = bio
        }
        fun getDormOne(): Int?
        {
            return dorm1
        }
        fun setDormOne(dorm1: Int){
            this.dorm1 = dorm1
        }
        fun getDormTwo(): Int?
        {
            return dorm2
        }
        fun setDormTwo(dorm2: Int){
            this.dorm2 = dorm2
        }
        fun getDormThree(): Int?
        {
            return dorm3
        }
        fun setDormThree(dorm3: Int){
            this.dorm3 = dorm3
        }
        fun getIntro(): Int?{
           return introvert
        }
        fun setIntro(introvert: Int){
            this.introvert = introvert
        }
    }

