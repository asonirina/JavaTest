@echo off
set /p num="Enter Node Number: "

java -cp target/JavaTest-1.0-SNAPSHOT.jar;jar\*;target\lib\*;src\main\resources\config.properties com.by.iason.App %num%

pause