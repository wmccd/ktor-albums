package com.example.routes

//class ActRoutes {
//}

import com.example.models.*
import com.google.gson.Gson
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.albumRouting() {

    println("albumRouting HERE")
    route("/album") {
        get {
            if (albumStorage.isNotEmpty()) {
                call.respond(albumStorage.toString())
            } else {
                call.respondText("No album found", status = HttpStatusCode.OK)
            }
        }
        get("{id?}") {
            val id = call.parameters["id"] ?: return@get call.respondText(
                "Missing id",
                status = HttpStatusCode.BadRequest
            )
            val album =
                albumStorage.find { it.id == id } ?: return@get call.respondText(
                    "No album with id $id",
                    status = HttpStatusCode.NotFound
                )
            call.respond(album.toString())
        }
        post {
            val albumJson = call.receive<String>()
            val albumModel = Gson().fromJson(albumJson, Album::class.java)
            albumStorage.add(albumModel)
            call.respondText("Album stored correctly", status = HttpStatusCode.Created)
        }
        delete("{id?}") {
            val id = call.parameters["id"] ?: return@delete call.respond(HttpStatusCode.BadRequest)
            if (albumStorage.removeIf { it.id == id }) {
                call.respondText("Album removed correctly", status = HttpStatusCode.Accepted)
            } else {
                call.respondText("Not Found", status = HttpStatusCode.NotFound)
            }
        }
    }
}