One of our junior developers decided to try to teach themselves Clean Architecture but got bogged down. It's a real mess and they need your help to get it up and running.

There is a list of cars in json format that should be display in a list. Help them get the cars asynchronously from the json file and display them to the user.

We don't expect you to correct everything but tackle the bits you think would demonstrate your knowledge of Clean Architecture to the junior and the use of Architectural Components within the context of the project. Introduce anything you think is missing or desirable.

Use tests to demonstrate the functionality if this is more congenial.

Please also track any changes in a Version Control System so we can see the progression.


## Solution

The solution uses the following Architecture Components:

ViewModel
LiveData
Data Binding
Navigation
Room
Dagger

It introduces a new layer called domain where the Use Cases (also called Interactors) live. The domain layer is where the business logic happens, which is the code that determines what the app does with the data coming from the repository before it's exposed to the UI for display.

The given app is too simple to showcase a complete representation of Clean Architecture, but it adheres to some of its rules, which work well in a modern Android application: separation of concerns, high level of abstraction and the dependency rule, which in our case means that layers only know about what's directly underneath them:

Presentation layer knows about use cases (domain layer).
Domain layer knows about repository (data layer) but not the Presentation layer.
Data layer doesn't know about domain or presentation layers.
This allows for easier testing and maintenance and recommended for bigger projects (alongside modularization).

ViewModels don't receive a repository but a set of Use Cases, which are reused throughout the presentation layer.
Business logic that was present in ViewModels was moved to Use Cases. This is important because ViewModels tend to grow quickly in size in real applications.

