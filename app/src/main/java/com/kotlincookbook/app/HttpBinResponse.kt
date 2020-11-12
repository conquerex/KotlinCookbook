package com.kotlincookbook.app

import com.google.gson.annotations.SerializedName

data class HttpBinResponse(

	@field:SerializedName("args")
	val args: Args? = null,

	@field:SerializedName("headers")
	val headers: Headers? = null,

	@field:SerializedName("origin")
	val origin: String? = null,

	@field:SerializedName("url")
	val url: String? = null
)

data class Args(
	val any: Any? = null
)

data class Headers(

	@field:SerializedName("Accept")
	val accept: String? = null,

	@field:SerializedName("Referer")
	val referer: String? = null,

	@field:SerializedName("User-Agent")
	val userAgent: String? = null,

	@field:SerializedName("Sec-Fetch-Dest")
	val secFetchDest: String? = null,

	@field:SerializedName("Sec-Fetch-Site")
	val secFetchSite: String? = null,

	@field:SerializedName("Host")
	val host: String? = null,

	@field:SerializedName("Accept-Encoding")
	val acceptEncoding: String? = null,

	@field:SerializedName("Accept-Language")
	val acceptLanguage: String? = null,

	@field:SerializedName("X-Amzn-Trace-Id")
	val xAmznTraceId: String? = null,

	@field:SerializedName("Sec-Fetch-Mode")
	val secFetchMode: String? = null
)
