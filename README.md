# Rick And Morty DB

## About
This application lets us search for "Rick And Morty" characters, preview information about them, such as episodes in which they appeared, images, and other show specific character information.
You can also find information about seasons and episodes.
There is also an integration of google maps.


## Features
- list of all the **characters**
- **search** trough the character list
- preview more **information** about the character
  - name
  - species
  - gender
  - episodes
- **season/episode** list with airing dates


![List of characters, and search bar](http://ix.io/28IC)

![Preview of character information](http://ix.io/28ID)

![Season and episode list](http://ix.io/28IE)

## Technical background

### Java Files

```
├── adapters
│   ├── CharacterAdapter.java
│   └── EpisodeAdapter.java
├── ApiClient.java
├── ApiService.java
├── models
│   ├── Character.java
│   ├── Characters.java
│   ├── Episode.java
│   └── Episodes.java
└── ui
    ├── characters
    │   ├── CharactersFragment.java
    │   └── CharactersViewModel.java
    ├── episodes
    │   ├── CharacterDetailsActivity.java
    │   ├── EpisodesFragment.java
    │   └── EpisodesViewModel.java
    ├── locations
    │   ├── LocationsFragment.java
    │   └── LocationsViewModel.java
    └── MainActivity.java
```

### Navigation
At the bottom of the screen there is a `BottomNavigationView`, with three buttons. Above it there is a `NavHostFragment`. They belong to an activity that is active almost during whole app lifecycle (one activity - many fragments). By clicking the buttons in the `BottomNavigationView` the view does Fragment transactions in `NavHostFragment` using `NavController`.

### Lists
There are three `RecyclerView`'s in the project. One for characters, another two for episodes. Respective adapters are in `adapters/` directory while

### Data
Retrofit is used to get data from [Rick And Morty API](https://rickandmortyapi.com).
In project we have an interface `ApiService.java` with necessary API calls, and `ApiClient.java`, where we setup necessary tools to get data, including `Gson`, `Retrofit`, `okHttp` and of course our `ApiService`. In `models/` directory there are all necessary POJO classes, for examlpe `Character.java` or `Episodes.java` which are filled in with data Retrofit gathers.
In layouts data is accesed trough `apiService`, static field in `ApiService.java`.

### Fragments
Each fragment (navigated by `BottomNavigationView`) has it's own package in `ui` package.


### Layout Resource Files
```
├── activity_character_details.xml
├── activity_main.xml
├── character_rv_item.xml
├── characters_fragment.xml
├── episode_rv_item.xml
├── episodes_fragment.xml
├── episode_table.xml
└── locations_fragment.xml
```
Here we have `<Fragment>`s, `<RecyclerView>`'s item layouts, `<RecyclerView>` in purpose of inclusion and reusability, and two Activities, one is the main (with bottom navigation view), another is for character detail preview.

### Android views
- SearchBar
- RecyclerView
- BottomNavigationView
- CollapsingToolbarLayout

### Dependencies

```
dependencies {
  def nav_version = "2.1.0"

  // navigation
  implementation "androidx.navigation:navigation-fragment:$nav_version"
  implementation "androidx.navigation:navigation-ui:$nav_version"

  // retrofit
  implementation 'com.squareup.retrofit2:retrofit:2.6.2'
  implementation 'com.google.code.gson:gson:2.8.6'
  implementation 'com.squareup.retrofit2:converter-gson:2.6.2'
  implementation "com.squareup.okhttp3:logging-interceptor:4.2.0"

  // glide
  implementation 'com.github.bumptech.glide:glide:4.11.0'
  annotationProcessor 'com.github.bumptech.glide:compiler:4.11.0'

  // google maps and location
  implementation 'com.google.android.gms:play-services-maps:17.0.0'
  implementation 'com.google.android.gms:play-services-location:17.0.0'
}
```

## Author
[Mirko Jovanovic](https://github.com/mirkojovanovic)

## Credits
[Rick And Morty API](https://rickandmortyapi.com)

