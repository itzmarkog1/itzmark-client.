$ErrorActionPreference = 'Stop'
if (-not (Get-Command gradle -ErrorAction SilentlyContinue)) {
    Write-Host 'Gradle 8.14+ was not found. Install Gradle, or open this folder in IntelliJ IDEA and let it import the Gradle project.' -ForegroundColor Red
    exit 1
}
gradle build
