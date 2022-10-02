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

fun Route.actRouting() {

    route("/act") {
        get {
            if (actStorage.isNotEmpty()) {
                call.respond(actStorage.toString())
            } else {
                call.respondText("No act found", status = HttpStatusCode.OK)
            }
        }
        get("{id?}") {
            val id = call.parameters["id"] ?: return@get call.respondText(
                "Missing id",
                status = HttpStatusCode.BadRequest
            )
            val act =
                actStorage.find { it.id == id } ?: return@get call.respondText(
                    "No act with id $id",
                    status = HttpStatusCode.NotFound
                )
            call.respond(act.toString())
        }
        post {
            val actJson = call.receive<String>()
            val actModel = Gson().fromJson(actJson, Act::class.java)
            actStorage.add(actModel)
            call.respondText("Act stored correctly", status = HttpStatusCode.Created)
        }
        delete("{id?}") {
            val id = call.parameters["id"] ?: return@delete call.respond(HttpStatusCode.BadRequest)
            if (actStorage.removeIf { it.id == id }) {
                call.respondText("Act removed correctly", status = HttpStatusCode.Accepted)
            } else {
                call.respondText("Not Found", status = HttpStatusCode.NotFound)
            }
        }
    }
}