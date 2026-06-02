@echo off
echo Compiling Hotel Management System...
cd src
javac *.java
if %errorlevel% neq 0 (
    echo Compilation failed!
    pause
    exit /b 1
)
echo Running Hotel Management GUI...
java HotelGUI
pause
