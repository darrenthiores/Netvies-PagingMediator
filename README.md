# Netvies

Netvies - Paging3 RemoteMediator

Fully written in Kotlin using compose, implementing Clean Architecture and MVVM Pattern with Dependency Injection (Koin).
Netvlies is a single screen app using MovieDB API as data source, then fetched with Ktor and displayed using Paging3.
This project has been UI tested in the MainScreenTest.kt

This app is basically the same with my recent project (Netvies) you can check it in my repository, what makes it different is that
this one implement Paging3 RemoteMediator to support offline-online

Note:
if you want to try this project, please use your own API key and place it in the build.gradle(:core)
in the buildConfigField("String", "API_KEY", '"YOUR API KEY HERE"')

<img width="500" alt="Screen Shot 2022-05-24 at 23 53 31" src="https://user-images.githubusercontent.com/69592810/170092188-456fb630-5e3d-4db7-ab2e-0514a96d1cb5.png">

Main Screen

<img src="https://user-images.githubusercontent.com/69592810/175814788-d238dcdc-de5f-4b03-bb4f-a6683a45cc6a.png" width="35%" height="35%">
