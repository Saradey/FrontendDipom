package com.evgeny.goncharov.graduationproject.security

import java.security.cert.CertificateException
import java.security.cert.X509Certificate
import javax.net.ssl.X509TrustManager


/**
 * Created by Evgeny Goncharov on 2019-05-22.
 * jtgn@yandex.ru
 */


class DefaultTrustManager : X509TrustManager{

    @Throws(CertificateException::class)
    override fun checkClientTrusted(chain: Array<out X509Certificate>?, authType: String?) {}

    @Throws(CertificateException::class)
    override fun checkServerTrusted(chain: Array<out X509Certificate>?, authType: String?) {}

    override fun getAcceptedIssuers(): Array<X509Certificate> {
        return arrayOf()
    }

}