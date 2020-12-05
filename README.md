# Caffeine counter

This simple application demonstrates my Kotlin and _Spring Boot_ skill through development
of very simple HTTP REST driven application where you can added caffeine drinkers and vending
machine and then request how much caffeine there is in blood of a specific drinker.

[Prerequisites](#Prerequisites)

[Running](#how-to-run)

## Prerequisites
This application expects you have Java 8 or higher already present on your system. If you don't have
Java installed you can download the [AdoptOpenJDK 8](https://github.com/AdoptOpenJDK/openjdk8-binaries/releases/download/jdk8u275-b01/OpenJDK8U-jdk_x64_windows_hotspot_8u275b01.msi) distribution for free

## How to run

This application uses *Gradle* as build automation tool. Gradle is very simple and all you have to do is to run this 
command in root application directory `./gradlew.bat bootRun` (`./gradlew bootRun` on _Linux_ or _WSL_) this command 
automatically downloads and installs Gradle of specific version to your system if it is not already present on your system.