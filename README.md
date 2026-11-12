# NoteLite — Bản khung 20% (Kotlin · MVVM · Room · Compose)

Bản này **đã chạy được**. App hiện danh sách ghi chú (đang trống) và mở được màn soạn thảo, nhưng **chưa lưu, sửa, xóa hay tìm kiếm được**. Phần đó bạn tự viết qua 20 TODO bên dưới.

## Đã có sẵn (~20%)
- Cấu hình Gradle, Manifest, Theme, `MainActivity`, Navigation giữa 2 màn
- `Note` (Entity), `NoteDatabase`, DI thủ công (`AppContainer`), `AppViewModelProvider`
- DAO và Repository mới có hàm đọc danh sách `observeAll()`
- Khung 2 màn hình và 2 ViewModel (state, ô nhập đã nối với ViewModel)

## Cách làm
1. Mở bằng Android Studio (**File › Open** → thư mục `NoteLite-starter`), bấm Run để thấy app chạy.
2. Mở cửa sổ **View › Tool Windows › TODO**: Android Studio liệt kê sẵn mọi dòng `// TODO`.
3. Làm **theo thứ tự số**. Sau mỗi mốc ✅ hãy chạy app để kiểm tra.

## Lộ trình TODO

| Mốc | TODO | File | Kết quả khi xong |
|---|---|---|---|
| **A. Tầng data** | 1 → 4 | `data/local/NoteDao.kt` | Có đủ SQL: insert, getById, update, delete, search |
| | 5 → 9 | `data/repository/NoteRepository.kt` | Repository gọi đủ các hàm DAO |
| **B. Thêm & sửa** | 16, 17, 19 | `ui/edit/NoteEditViewModel.kt`, `NoteEditScreen.kt` | ✅ Tạo ghi chú mới → quay về thấy trong danh sách. Bấm vào ghi chú → sửa được |
| **C. Xóa** | 18, 20 | `ui/edit/...` | ✅ Xóa từ màn sửa, có hộp thoại xác nhận |
| | 11, 15 | `ui/notes/...` | ✅ Xóa ngay trên danh sách |
| **D. Tìm kiếm** | 10, 12, 13 | `ui/notes/...` | ✅ Gõ từ khóa → danh sách lọc theo tiêu đề/nội dung |
| **E. Giao diện** | 14 | `ui/notes/NoteListScreen.kt` | Thẻ ghi chú có nội dung rút gọn + thời gian |

## Lỗi hay gặp
- **"Suspend function should be called only from a coroutine"** → bọc lời gọi trong `viewModelScope.launch { }`.
- **Build lỗi sau khi sửa DAO** → xem tab *Build*. Room báo lỗi SQL ngay lúc biên dịch, đọc kỹ câu báo lỗi.
- **Lưu xong nhưng màn hình không quay lại** → chưa làm TODO 19 (lắng nghe sự kiện).

Khi làm xong một mốc, hãy gửi code để được review.
