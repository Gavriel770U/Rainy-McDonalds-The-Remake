@echo off

set SOURCE_DIR=src
set BUILD_DIR=build

cd %SOURCE_DIR%
javac -d ../%BUILD_DIR% *.java

cd ../%BUILD_DIR%
jar cfm RainyMcdonaldsRemake.jar ./MANIFEST.MF *.class

echo Build completed successfully.

pause