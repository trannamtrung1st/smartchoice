/****** Script for SelectTopNRows command from SSMS  ******/
SELECT TOP (1000) 
      p.[name] as jobName
      ,p.[salaryFrom]
      ,p.[salaryTo]
      ,p.[experienceRequirement]
      ,p.[degreeRequirement]
      ,p.[numOfVacancy]
      ,p.[genderRequirement]
      ,p.[description]
      ,p.[benefit]
      ,p.[otherRequirement]
      ,p.[contactAddress]
      ,c.[id] as companyId
	  ,c.[address] as companyAddress
	  ,cf.[id] as fieldId
	  ,l.[isInVietNam]
	  ,l.[name] as locationName
  FROM [SmartChoice].[dbo].[JobPost] as p
  INNER JOIN Company as c ON c.id = p.companyId
  INNER JOIN JobField as jf ON jf.jobPostId = p.id
  INNER JOIN CareerField as cf on jf.careerFieldId = cf.id
  INNER JOIN JobLocation as jl ON jl.jobPostId = p.id
  INNER JOIN Location as l on jl.locationName = l.name
