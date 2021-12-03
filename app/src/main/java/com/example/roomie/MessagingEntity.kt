package com.example.roomie
import java.io.Serializable;
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Time

@Entity
class MessagingEntity: Serializable {
    /*
* Getters and Setters
*
* Each entry into the table is a single message.
*
* */
    @PrimaryKey(autoGenerate = true)
    var id = 0

    @ColumnInfo(name = "useridFrom")//will be int generated from user entity table (PK)
    var useridFrom: Int? = null

    @ColumnInfo(name = "useridTo")//will be int generated from user entity table (PK)
    var useridTo: Int? = null

    @ColumnInfo(name = "messagecontent")
    var messagecontent: String? = null

    @ColumnInfo(name = "timestamp")//female = 0, male = 1, other = -1
    var timestamp: Time? = null


}