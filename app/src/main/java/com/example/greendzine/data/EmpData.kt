package com.example.greendzine.data

class EmpData() {
    fun loadEmpData(): List<Employees> {
        return listOf<Employees>(
            Employees(1, "Gunal", "15-01-2002", "Android Developer"),
            Employees(2, "Seenivasagan", "25-12-1969", "Software Engineer"),
            Employees(3, "Arjun", "16-11-2000", "Web Developer"),
            Employees(4, "Robert", "16-11-2000", "Software Architect"),
            Employees(5, "Todd", "16-11-2000", "Cloud Engineer"),
            Employees(6, "Mick", "16-11-2000", "ML Developer"),
            Employees(7, "Kendrick", "16-11-2000", "CyberSecurity Expert"),
            Employees(8, "Bill", "16-11-2000", "DevOps Engineer")
        )
    }

    fun loadEmpProd():List<EmpProd>{
        return listOf<EmpProd>(
            EmpProd("Monday",4),
            EmpProd("Tuesday",92),
            EmpProd("Wednesday",122),
            EmpProd("Thursday",93),
            EmpProd("Friday",89),
            EmpProd("Saturday",98),
        )
    }
}