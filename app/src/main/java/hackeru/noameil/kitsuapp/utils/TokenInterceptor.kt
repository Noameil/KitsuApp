package hackeru.noameil.kitsuapp.utils

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class TokenInterceptor (
): Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {

        val original: Request = chain.request()

        val url =
            original
                .url.newBuilder()
                .build()

        val request = original.newBuilder().url(url).build()

        return chain.proceed(request)
    }
}