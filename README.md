# Ktor

Ktor is the standard mechanism for building web service APIs in Kotlin

The home page

https://ktor.io/

The quick project template generator: 

https://start.ktor.io

Examples and Samples

https://ktor.io/learn/

---
The example app in this repository is for musical acts and their albums

## Static Pages

To serve static content, we can use a specific routing function already built into Ktor named *static*. The function takes two parameters: the route under which the static content should be made available, and a lambda where we can define the location from where the content should be served.

    fun Route.staticRouting() {
        static("/static") {
            resources("files")
        }
    }

## Curl Statements For the REST API

### GET

    curl --location --request GET 'http://0.0.0.0:8080/act'

    curl --location --request GET 'http://0.0.0.0:8080/album'

### POST

    curl --location --request POST 'http://0.0.0.0:8080/act' \
    --header 'Content-Type: text/plain' \
    --data-raw '{"id": "3","name": "The Notorious Bobbins","yearFirstActive": 1999,"yearLastActive": 2022}'

    curl --location --request POST 'http://0.0.0.0:8080/album' \
    --header 'Content-Type: text/plain' \
    --data-raw '{ "id":"5", "actId" = "2", "title" = "The Bobbins Album", "releaseYear" = 2017,"trackCount" = 37}'


### DELETE

    curl --location --request DELETE 'http://0.0.0.0:8080/act/1'

    curl --location --request DELETE 'http://0.0.0.0:8080/album/1'



