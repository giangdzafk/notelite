package com.giang.notelite.data.local

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

/**
 * DAO (Data Access Object): nơi khai báo các câu SQL. Room tự sinh code thực thi.
 *
 * - Hàm trả về Flow: Room tự phát lại dữ liệu mới mỗi khi bảng "notes" thay đổi.
 * - Hàm suspend: chạy 1 lần, Room tự chuyển sang luồng nền (không chặn UI).
 */
@Dao
interface NoteDao {

    // ĐÃ CÓ SẴN: lấy tất cả ghi chú, mới cập nhật nằm trên
    @Query("SELECT * FROM notes ORDER BY updatedAt DESC")
    fun observeAll(): Flow<List<Note>>

    // TODO 1: Thêm hàm insert ghi chú.
    //  Gợi ý: dùng @Insert, hàm suspend, trả về Long (id vừa được sinh).

    // TODO 2: Thêm hàm getById(id: Long) trả về Note? (null nếu không có).
    //  Gợi ý: @Query("SELECT * FROM notes WHERE id = :id"), hàm suspend.

    // TODO 3: Thêm hàm update và delete.
    //  Gợi ý: dùng @Update và @Delete, đều là hàm suspend.

    // TODO 4: Thêm hàm search(query: String): Flow<List<Note>>
    //  Tìm trong cả title và content.
    //  Gợi ý SQL: WHERE title LIKE '%' || :query || '%' OR content LIKE ...
    //  (|| là phép nối chuỗi trong SQLite)
}
