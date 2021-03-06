USE [master]
GO
/****** Object:  Database [SmartChoice]    Script Date: 6/15/2020 4:45:25 PM ******/
CREATE DATABASE [SmartChoice]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'SmartChoice', FILENAME = N'T:\ITs\SqlServer\ServerInstances\MSSQL12.TNT\MSSQL\DATA\SmartChoice.mdf' , SIZE = 4096KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'SmartChoice_log', FILENAME = N'T:\ITs\SqlServer\ServerInstances\MSSQL12.TNT\MSSQL\DATA\SmartChoice_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [SmartChoice] SET COMPATIBILITY_LEVEL = 120
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [SmartChoice].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [SmartChoice] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [SmartChoice] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [SmartChoice] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [SmartChoice] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [SmartChoice] SET ARITHABORT OFF 
GO
ALTER DATABASE [SmartChoice] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [SmartChoice] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [SmartChoice] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [SmartChoice] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [SmartChoice] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [SmartChoice] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [SmartChoice] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [SmartChoice] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [SmartChoice] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [SmartChoice] SET  DISABLE_BROKER 
GO
ALTER DATABASE [SmartChoice] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [SmartChoice] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [SmartChoice] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [SmartChoice] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [SmartChoice] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [SmartChoice] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [SmartChoice] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [SmartChoice] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [SmartChoice] SET  MULTI_USER 
GO
ALTER DATABASE [SmartChoice] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [SmartChoice] SET DB_CHAINING OFF 
GO
ALTER DATABASE [SmartChoice] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [SmartChoice] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
ALTER DATABASE [SmartChoice] SET DELAYED_DURABILITY = DISABLED 
GO
USE [SmartChoice]
GO
/****** Object:  Table [dbo].[CareerField]    Script Date: 6/15/2020 4:45:25 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CareerField](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](255) NOT NULL,
 CONSTRAINT [PK_CareerField] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Company]    Script Date: 6/15/2020 4:45:26 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Company](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[code] [varchar](50) NOT NULL,
	[name] [nvarchar](255) NOT NULL,
	[address] [nvarchar](500) NULL,
	[image] [nvarchar](2000) NULL,
	[detailUrl] [nvarchar](1000) NULL,
 CONSTRAINT [PK_Company] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[JobField]    Script Date: 6/15/2020 4:45:26 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[JobField](
	[careerFieldId] [int] NOT NULL,
	[jobPostId] [int] NOT NULL,
 CONSTRAINT [PK_JobField] PRIMARY KEY CLUSTERED 
(
	[careerFieldId] ASC,
	[jobPostId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[JobLocation]    Script Date: 6/15/2020 4:45:26 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[JobLocation](
	[locationName] [nvarchar](50) NOT NULL,
	[jobPostId] [int] NOT NULL,
 CONSTRAINT [PK_JobLocation] PRIMARY KEY CLUSTERED 
(
	[locationName] ASC,
	[jobPostId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[JobPost]    Script Date: 6/15/2020 4:45:26 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[JobPost](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[code] [varchar](100) NOT NULL,
	[name] [nvarchar](255) NOT NULL,
	[url] [nvarchar](1000) NULL,
	[salaryFrom] [float] NULL,
	[salaryTo] [float] NULL,
	[experienceRequirement] [nvarchar](100) NULL,
	[degreeRequirement] [nvarchar](100) NULL,
	[numOfVacancy] [int] NULL,
	[genderRequirement] [bit] NULL,
	[description] [nvarchar](max) NULL,
	[benefit] [nvarchar](max) NULL,
	[otherRequirement] [nvarchar](max) NULL,
	[expiredDate] [date] NULL,
	[updatedDate] [date] NULL,
	[contactPerson] [nvarchar](255) NULL,
	[contactAddress] [nvarchar](500) NULL,
	[companyId] [int] NOT NULL,
 CONSTRAINT [PK_JobPost] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Location]    Script Date: 6/15/2020 4:45:26 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Location](
	[name] [nvarchar](50) NOT NULL,
	[isInVietNam] [bit] NULL,
 CONSTRAINT [PK_Location] PRIMARY KEY CLUSTERED 
(
	[name] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[JobField]  WITH CHECK ADD  CONSTRAINT [FK_JobField_CareerField] FOREIGN KEY([careerFieldId])
REFERENCES [dbo].[CareerField] ([id])
GO
ALTER TABLE [dbo].[JobField] CHECK CONSTRAINT [FK_JobField_CareerField]
GO
ALTER TABLE [dbo].[JobField]  WITH CHECK ADD  CONSTRAINT [FK_JobField_JobPost] FOREIGN KEY([jobPostId])
REFERENCES [dbo].[JobPost] ([id])
GO
ALTER TABLE [dbo].[JobField] CHECK CONSTRAINT [FK_JobField_JobPost]
GO
ALTER TABLE [dbo].[JobLocation]  WITH CHECK ADD  CONSTRAINT [FK_JobLocation_JobPost] FOREIGN KEY([jobPostId])
REFERENCES [dbo].[JobPost] ([id])
GO
ALTER TABLE [dbo].[JobLocation] CHECK CONSTRAINT [FK_JobLocation_JobPost]
GO
ALTER TABLE [dbo].[JobLocation]  WITH CHECK ADD  CONSTRAINT [FK_JobLocation_Location] FOREIGN KEY([locationName])
REFERENCES [dbo].[Location] ([name])
GO
ALTER TABLE [dbo].[JobLocation] CHECK CONSTRAINT [FK_JobLocation_Location]
GO
ALTER TABLE [dbo].[JobPost]  WITH CHECK ADD  CONSTRAINT [FK_JobPost_Company] FOREIGN KEY([companyId])
REFERENCES [dbo].[Company] ([id])
GO
ALTER TABLE [dbo].[JobPost] CHECK CONSTRAINT [FK_JobPost_Company]
GO
USE [master]
GO
ALTER DATABASE [SmartChoice] SET  READ_WRITE 
GO
