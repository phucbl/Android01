BEGIN TRANSACTION;
CREATE TABLE IF NOT EXISTS "Student" (
	"id"	INTEGER PRIMARY KEY AUTOINCREMENT,
	"name"	String,
	"address"	String,
	"gender"	INTEGER
);
INSERT INTO "Student" ("id","name","address","gender") VALUES (1,'Nguyễn Văn A','Thủ Đức','male'),
 (2,'Phạm Hồng Nhung','Quận 2','female'),
 (3,'Phạm Xuân Nhân','Quận 5','male'),
 (4,'Trần Thị Mỹ','Quận 6','female');
COMMIT;
