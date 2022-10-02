package com.example.plugins

import com.example.models.actStorage
import com.example.routes.actRouting
import com.example.routes.albumRouting
import com.example.routes.staticRouting
import io.ktor.server.routing.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.request.*

fun Application.configureRouting() {
    routing {
        staticRouting()
        actRouting()
        albumRouting()
    }

//    // Starting point for a Ktor app:
//    routing {
//        get("/") {
//            call.respondText("Hello World!")
//        }
//    }
//    routing {
//        get("act") {
//            call.respondText("Hello World Acts!")
//        }
//    }
//    routing {
//        get("album") {
//            call.respondText("Hello World Albums!")
//        }
//    }
//    routing {
//        get("/") {
//
//            call.respondText("Hello World ??!")
//        }
//    }
}
