package io.javalin.http.staticfiles

import org.eclipse.jetty.server.handler.ContextHandler
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

enum class Location { CLASSPATH, EXTERNAL; }
data class StaticFileConfig(val urlPathPrefix: String, val path: String, val location: Location, val aliasChecks: List<ContextHandler.AliasCheck>)

interface ResourceHandler {
    fun handle(httpRequest: HttpServletRequest, httpResponse: HttpServletResponse): Boolean
    fun addStaticFileConfig(config: StaticFileConfig)
}
