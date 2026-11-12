// File build cấp project: chỉ khai báo plugin, chưa áp dụng (apply false).
// Module :app sẽ tự áp dụng các plugin cần dùng.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.compose) apply false
    alias(libs.plugins.ksp) apply false
}
