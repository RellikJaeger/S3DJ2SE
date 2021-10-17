@echo off
if not exist "build\" (
	echo [Nothing to clean]
	exit /b 1
) else (
	echo ^> Cleaning...
	rd /s /q "build\">nul
	echo [Done]
)
