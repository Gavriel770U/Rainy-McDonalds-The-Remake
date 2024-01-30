@echo off

set SOURCE_DIR=src
set BUILD_DIR=build
set RESOURCES_DIR=resources

rem Use %~dp0 to get the directory where the script is located
set SCRIPT_DIR=%~dp0

xcopy "%SCRIPT_DIR%%SOURCE_DIR%\%RESOURCES_DIR%" "%SCRIPT_DIR%%BUILD_DIR%\%RESOURCES_DIR%" /E /H /C /I /Y

cd %SOURCE_DIR%
javac -d ../%BUILD_DIR% *.java

cd ../%BUILD_DIR%
jar cfm RainyMcdonaldsRemake.jar ./MANIFEST.MF *.class

echo Build completed successfully.

pause