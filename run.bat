@echo off
if not exist "build\Main.class" (
	echo Please build the program first.
	exit /b 1
) else (
	pushd "build\"
	echo ^> Running...
	java Main
	echo [Stopped]
	popd
)
