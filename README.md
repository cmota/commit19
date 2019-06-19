# commit19
Kotlin Multiplatform is here! 🙌

I'm going to give a talk at Commit Porto about it:
👉 The Hitchhikers Guide Through Kotlin Multiplaform


This repository contains a demo of a simple application developed to show how we can have a shared logical module between two different targets - in this case, Android and iOS.


## Use case
This is a two-screen application that allows to see all the speakers and talks that are going to happen at Commit Porto.


## Implementation
I've hosted a Gist here with a json that contains all the information about the speakers that will be talking at Commit Porto 19. The logic to download a file and parse it will be similar to both platforms - so why not adding this logic to a common module and leave all the UI implementation to the platforms themselves?

This way, `common` contains all this logic needed and `androidMain` and `iosMain` are just responsible to ask for data to populate the views, in this case a RecyclerView and a UITableViewController accordingly.


## Libraries
- org.jetbrains.kotlinx:kotlinx-serialization-runtime-common
- io.ktor:ktor-client-core
- io.ktor:ktor-client-json
- io.ktor:ktor-client-serialization
- org.jetbrains.kotlinx:kotlinx-coroutines-core-common


## Extra
If you want to create your first project using Kotlin Multiplatform for Android and iOS you can find this medium post that I've writen [here](https://medium.com/@cafonsomota/set-up-your-first-kotlin-multiplatform-project-for-android-and-ios-e54c2b6574e7).


## More information
We're on the beginning of Kotlin Multiplatform, and there are already amazing projects out there that it take it a bit further, don't forget to give a look at:
- [Kotlin Conf app](https://github.com/jetbrains/kotlinconf-app)
- [Touchlab Droidcon Kotlin](https://github.com/touchlab/DroidconKotlin)
- [Kotlin Academy App](https://github.com/MarcinMoskala/KotlinAcademyApp)
- [Ktor Samples](https://github.com/ktorio/ktor-samples)
- [Kotlin Multiplatform Template](https://github.com/pink-room/kotlin-multiplatform-template)
