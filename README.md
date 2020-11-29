# JBossのUndertowやServlet 3.1でWebFluxが使えるかなどを調べる

## ビルド手順

```
mvn clean package
```

## デプロイ

warファイル「spring-web-flux-trial1-0.0.1-SNAPSHOT.war」をJBoss EAP/WildFlyにデプロイする。

## 動作確認

```
curl -i http://localhost:8080/spring-web-flux-trial1-0.0.1-SNAPSHOT/fluxtest1/aa/500
```

Result is aa!

```
curl -i http://localhost:8080/spring-web-flux-trial1-0.0.1-SNAPSHOT/fluxtest1/aiueo/3000
```

*aiueo*kakikukeko*sashisuseso*tatitsuteto

```
curl -i http://localhost:8080/spring-web-flux-trial1-0.0.1-SNAPSHOT/fluxtest1/aiueo2
```

HTTP/1.1 200 OK
Connection: keep-alive
Transfer-Encoding: chunked
Content-Type: text/event-stream
Date: Sun, 29 Nov 2020 08:19:17 GMT

data:aiueo

data:kakikukeko

data:sashisuseso

data:tatitsuteto

data:naninuneno

data:hahihuheho

data:mamimumemo

data:yayiyuyeyo

data:wawiwuwewo

data:gagigugego

## 参考サイト

https://stackoverflow.com/questions/54034108/request-forwarding-with-servlethttphandleradapter-spring-web-flux-in-servlet-3-1

https://github.com/spring-projects/spring-framework/issues/19106

