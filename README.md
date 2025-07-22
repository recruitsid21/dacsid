# dacsid

1.Scaffold-DbContext "server=localhost;port=3306;user=root;password=cdacacts;database=studentdb" Pomelo.EntityFrameworkCore.MySql -OutputDir Models -f

2. "ConnectionStrings": {
   "DefaultConnection": "server=localhost;port=3306;user=root;password=cdacacts;database=studentdb"
    },


3. builder.Services.AddDbContext<StudentDbContext>(options =>
  options.UseMySql(builder.Configuration.GetConnectionString("DefaultConnection"),
  new MySqlServerVersion(new Version(8, 0, 36)))); // Change version as per your MySQL
---------------------------------------------------------------------------------------------------
CREATE DATABASE studentdb3;

USE studentdb3;

CREATE TABLE students (
    Id INT PRIMARY KEY AUTO_INCREMENT,
    Name VARCHAR(100),
    Email VARCHAR(100),
    Course VARCHAR(100)
);

SHOW CREATE TABLE students;
--------------------------------------------------------------------
