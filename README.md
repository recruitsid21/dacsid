# dacsid

1.Scaffold-DbContext "server=localhost;port=3306;user=root;password=cdacacts;database=studentdb" Pomelo.EntityFrameworkCore.MySql -OutputDir Models -f

2. "ConnectionStrings": {
   "DefaultConnection": "server=localhost;port=3306;user=root;password=cdacacts;database=studentdb"
    },


3. builder.Services.AddDbContext<StudentDbContext>(options =>
  options.UseMySql(builder.Configuration.GetConnectionString("DefaultConnection"),
  new MySqlServerVersion(new Version(8, 0, 36)))); // Change version as per your MySQL
