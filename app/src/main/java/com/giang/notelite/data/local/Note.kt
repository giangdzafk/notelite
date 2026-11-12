package com.giang.notelite.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Entity = 1 bảng trong SQLite. Mỗi object Note = 1 dòng trong bảng "notes".
 * id = 0 nghĩa là "chưa lưu", Room sẽ tự sinh id khi insert (autoGenerate).
 */
@Entity(tableName = "notes")
data class Note(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val title: String,
    val content: String,
    val createdAt: Long = System.currentTimeMillis(),
    val updatedAt: Long = System.currentTimeMillis(),
)
