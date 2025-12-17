-- Migration script to drop username column if it exists
SET @exist := (SELECT COUNT(*) FROM information_schema.COLUMNS WHERE TABLE_SCHEMA = 'courses' AND TABLE_NAME = 'course_links' AND COLUMN_NAME = 'username');
SET @sqlstmt := IF(@exist > 0, 'ALTER TABLE course_links DROP COLUMN username', 'SELECT ''Column username does not exist''');
PREPARE stmt FROM @sqlstmt;
EXECUTE stmt;

