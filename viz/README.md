
### Intro

* A simple Kotlin exercise to process the [Meetups.csv](https://github.com/peidevs/Event_Resources/blob/master/MeetUps.csv) and graph the # of unique speakers and cat-herders over time.
* Uses a simple [string distance](https://en.wikipedia.org/wiki/Levenshtein_distance#Iterative_with_full_matrix) algorithm to ensure that entries such as `J.B. Rainsberger` and `JB Rainsberger` are considered equivalent.

### Structure

* this is a multi-project Gradle build
* `common` contains the bulk of the code
* `UniqueSpeakers` is a main app
* `UniqueCatHerder` is a main app
