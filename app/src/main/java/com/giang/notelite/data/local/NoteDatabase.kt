package com.giang.notelite.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/**
 * Lớp database của Room. Khi đổi cấu trúc bảng (thêm cột...) phải tăng version
 * và viết Migration, nếu không app sẽ crash với dữ liệu cũ.
 */
@Database(entities = [Note::class], version = 1, exportSchema = false)
abstract class NoteDatabase : RoomDatabase() {

    abstract fun noteDao(): NoteDao

    companion object {
        // @Volatile: mọi luồng luôn thấy giá trị mới nhất của INSTANCE
        @Volatile
        private var INSTANCE: NoteDatabase? = null

        // Singleton: cả app chỉ mở 1 kết nối database (mở nhiều rất tốn tài nguyên)
        fun getInstance(context: Context): NoteDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    NoteDatabase::class.java,
                    "notelite.db"
                ).build().also { INSTANCE = it }
            }
    }
}
