# Ktor

Ktor is the standard mechanism for building web service APIs in Kotlin

The example app in this repository is for musical acts and their albums

## Curl Statements

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



