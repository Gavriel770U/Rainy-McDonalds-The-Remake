#!/bin/bash

SOURCE_DIR=src
BUILD_DIR=build
RESOURCES_DIR=resources

# Use pwd to get the directory where the script is located
SCRIPT_DIR=$(pwd)

cd "$SOURCE_DIR"
javac -d "../$BUILD_DIR" *.java

mkdir -p "$SCRIPT_DIR"/$BUILD_DIR/$RESOURCES_DIR/

cp -Rf "$SCRIPT_DIR"/"$SOURCE_DIR"/"$RESOURCES_DIR"/* "$SCRIPT_DIR"/$BUILD_DIR/$RESOURCES_DIR/

cd "../$BUILD_DIR"
jar cfm RainyMcdonaldsRemake.jar ./MANIFEST.MF *.class

echo "Build completed successfully."
