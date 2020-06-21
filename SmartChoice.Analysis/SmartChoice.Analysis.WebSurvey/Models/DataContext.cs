using System;
using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Metadata;

namespace SmartChoice.Analysis.WebSurvey.Models
{
    public partial class DataContext : DbContext
    {
        public DataContext()
        {
        }

        public DataContext(DbContextOptions<DataContext> options)
            : base(options)
        {
        }

        public virtual DbSet<CareerField> CareerField { get; set; }
        public virtual DbSet<Company> Company { get; set; }
        public virtual DbSet<JobField> JobField { get; set; }
        public virtual DbSet<JobLocation> JobLocation { get; set; }
        public virtual DbSet<JobPost> JobPost { get; set; }
        public virtual DbSet<Location> Location { get; set; }

        protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
        {
            if (!optionsBuilder.IsConfigured)
            {
#warning To protect potentially sensitive information in your connection string, you should move it out of source code. See http://go.microsoft.com/fwlink/?LinkId=723263 for guidance on storing connection strings.
                optionsBuilder.UseSqlServer("Server=localhost;Database=SmartChoice;Trusted_Connection=False;User Id=sa;Password=123456");
            }
        }

        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            modelBuilder.Entity<CareerField>(entity =>
            {
                entity.Property(e => e.Id).HasColumnName("id");

                entity.Property(e => e.Name)
                    .IsRequired()
                    .HasColumnName("name")
                    .HasMaxLength(255);
            });

            modelBuilder.Entity<Company>(entity =>
            {
                entity.Property(e => e.Id).HasColumnName("id");

                entity.Property(e => e.Address)
                    .HasColumnName("address")
                    .HasMaxLength(500);

                entity.Property(e => e.Code)
                    .IsRequired()
                    .HasColumnName("code")
                    .HasMaxLength(50)
                    .IsUnicode(false);

                entity.Property(e => e.DetailUrl)
                    .HasColumnName("detailUrl")
                    .HasMaxLength(1000);

                entity.Property(e => e.Image)
                    .HasColumnName("image")
                    .HasMaxLength(2000);

                entity.Property(e => e.Name)
                    .IsRequired()
                    .HasColumnName("name")
                    .HasMaxLength(255);
            });

            modelBuilder.Entity<JobField>(entity =>
            {
                entity.HasKey(e => new { e.CareerFieldId, e.JobPostId });

                entity.Property(e => e.CareerFieldId).HasColumnName("careerFieldId");

                entity.Property(e => e.JobPostId).HasColumnName("jobPostId");

                entity.HasOne(d => d.CareerField)
                    .WithMany(p => p.JobField)
                    .HasForeignKey(d => d.CareerFieldId)
                    .OnDelete(DeleteBehavior.ClientSetNull)
                    .HasConstraintName("FK_JobField_CareerField1");

                entity.HasOne(d => d.JobPost)
                    .WithMany(p => p.JobField)
                    .HasForeignKey(d => d.JobPostId)
                    .OnDelete(DeleteBehavior.ClientSetNull)
                    .HasConstraintName("FK_JobField_JobPost1");
            });

            modelBuilder.Entity<JobLocation>(entity =>
            {
                entity.HasKey(e => new { e.LocationName, e.JobPostId });

                entity.Property(e => e.LocationName)
                    .HasColumnName("locationName")
                    .HasMaxLength(50);

                entity.Property(e => e.JobPostId).HasColumnName("jobPostId");

                entity.HasOne(d => d.JobPost)
                    .WithMany(p => p.JobLocation)
                    .HasForeignKey(d => d.JobPostId)
                    .OnDelete(DeleteBehavior.ClientSetNull)
                    .HasConstraintName("FK_JobLocation_JobPost1");

                entity.HasOne(d => d.LocationNameNavigation)
                    .WithMany(p => p.JobLocation)
                    .HasForeignKey(d => d.LocationName)
                    .OnDelete(DeleteBehavior.ClientSetNull)
                    .HasConstraintName("FK_JobLocation_Location1");
            });

            modelBuilder.Entity<JobPost>(entity =>
            {
                entity.Property(e => e.Id).HasColumnName("id");

                entity.Property(e => e.Benefit).HasColumnName("benefit");

                entity.Property(e => e.Code)
                    .IsRequired()
                    .HasColumnName("code")
                    .HasMaxLength(100)
                    .IsUnicode(false);

                entity.Property(e => e.CompanyId).HasColumnName("companyId");

                entity.Property(e => e.ContactAddress)
                    .HasColumnName("contactAddress")
                    .HasMaxLength(500);

                entity.Property(e => e.ContactPerson)
                    .HasColumnName("contactPerson")
                    .HasMaxLength(255);

                entity.Property(e => e.DegreeRequirement)
                    .HasColumnName("degreeRequirement")
                    .HasMaxLength(100);

                entity.Property(e => e.Description).HasColumnName("description");

                entity.Property(e => e.ExperienceRequirement)
                    .HasColumnName("experienceRequirement")
                    .HasMaxLength(100);

                entity.Property(e => e.ExpiredDate)
                    .HasColumnName("expiredDate")
                    .HasColumnType("date");

                entity.Property(e => e.GenderRequirement).HasColumnName("genderRequirement");

                entity.Property(e => e.Name)
                    .IsRequired()
                    .HasColumnName("name")
                    .HasMaxLength(255);

                entity.Property(e => e.NumOfVacancy).HasColumnName("numOfVacancy");

                entity.Property(e => e.OtherRequirement).HasColumnName("otherRequirement");

                entity.Property(e => e.SalaryFrom).HasColumnName("salaryFrom");

                entity.Property(e => e.SalaryTo).HasColumnName("salaryTo");

                entity.Property(e => e.UpdatedDate)
                    .HasColumnName("updatedDate")
                    .HasColumnType("date");

                entity.Property(e => e.Url)
                    .HasColumnName("url")
                    .HasMaxLength(1000);

                entity.HasOne(d => d.Company)
                    .WithMany(p => p.JobPost)
                    .HasForeignKey(d => d.CompanyId)
                    .OnDelete(DeleteBehavior.ClientSetNull)
                    .HasConstraintName("FK_JobPost_Company");
            });

            modelBuilder.Entity<Location>(entity =>
            {
                entity.HasKey(e => e.Name);

                entity.Property(e => e.Name)
                    .HasColumnName("name")
                    .HasMaxLength(50);

                entity.Property(e => e.IsInVietNam).HasColumnName("isInVietNam");
            });

            OnModelCreatingPartial(modelBuilder);
        }

        partial void OnModelCreatingPartial(ModelBuilder modelBuilder);
    }
}
