@echo off
setlocal enabledelayedexpansion

REM 1. Check if mvn is directly available in PATH
where mvn >nul 2>&1
if %ERRORLEVEL% equ 0 (
    mvn %*
    exit /b %ERRORLEVEL%
)

REM 2. Look for existing Maven wrapper binaries in user's .m2 folder
if exist "%USERPROFILE%\.m2\wrapper\dists" (
    for /r "%USERPROFILE%\.m2\wrapper\dists" %%F in (mvn.cmd) do (
        if exist "%%F" (
            "%%F" %*
            exit /b !ERRORLEVEL!
        )
    )
)

REM 3. Fallback to default mvn command
mvn %*
exit /b %ERRORLEVEL%
