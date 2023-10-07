javac -cp "C:/L3/RHgestion/WEB-INF/lib/framworktmc2023.jar;C:/L3/RHgestion/WEB-INF/lib/DAOtmc2023.jar;C:/L3/RHgestion/WEB-INF/lib/gson-2.8.6.jar" -d . *.java

xcopy "C:\L3\RHgestion\*" "C:\Program Files\Apache Software Foundation\Tomcat 10.0\webapps\RHgestion" /E /H /C /I /Y