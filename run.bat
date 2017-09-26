@echo off
set /p num="Enter Node Number: "

java -cp target/JavaTest-1.0-SNAPSHOT.jar;jar\*;target\lib\* com.by.iason.App %num%

pause