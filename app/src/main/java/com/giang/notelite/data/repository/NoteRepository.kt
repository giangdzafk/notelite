package com.giang.notelite.data.repository

import com.giang.notelite.data.local.Note
import com.giang.notelite.data.local.NoteDao
import kotlinx.coroutines.flow.Flow

/**
 * Repository: "cửa duy nhất" để ViewModel lấy/ghi dữ liệu.
 * ViewModel không gọi thẳng DAO, mà luôn đi qua đây.
 */
class NoteRepository(private val noteDao: NoteDao) {

    // ĐÃ CÓ SẴN (bản đơn giản): chưa xử lý tìm kiếm
    fun observeNotes(query: String): Flow<List<Note>> {
        // TODO 5: Nếu query rỗng/toàn khoảng trắng -> noteDao.observeAll()
        //  ngược lại -> noteDao.search(query.trim())  (cần làm TODO 4 trước)
        return noteDao.observeAll()
    }

    // TODO 6: suspend fun getNote(id: Long): Note?

    // TODO 7: suspend fun addNote(title: String, content: String): Long
    //  Gợi ý: tạo Note(title = ..., content = ...) rồi gọi noteDao.insert(...)
    //  (không cần truyền id, Room tự sinh vì autoGenerate = true)

    // TODO 8: suspend fun updateNote(note: Note)
    //  Nhớ cập nhật thời gian: note.copy(updatedAt = System.currentTimeMillis())

    // TODO 9: suspend fun deleteNote(note: Note)
}
