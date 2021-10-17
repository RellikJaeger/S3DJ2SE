@echo off
call clean
if not exist "src\" (
	echo src folder not found to build!
	exit /b 1
) else (
	if not exist "build\" (md "build\")
	pushd "src\"
	echo ^> Building...
	dir /s /B *.java > "..\build\sources.txt"
	popd
	pushd "build\"
	javac -d . @sources.txt
	popd
	echo [Done]
	call run
)
